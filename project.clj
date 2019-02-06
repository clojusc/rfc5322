(defn get-banner
  []
  (try
    (str
      (slurp "resources/text/banner.txt")
      (slurp "resources/text/loading.txt"))
    ;; If another project can't find the banner, just skip it;
    ;; this function is really only meant to be used by Dragon itself.
    (catch Exception _ "")))

(defn get-help
  []
  (str "\nTo demo the code, try the following:\n\n"
       "\t(demo-lite)\n"
       "\t(source demo-lite)\n"
       "\t(source parsed-lite)\n"
       "\tparsed-lite\n\n"
       "\t(demo-full)\n"
       "\t(source demo-full)\n"
       "\t(source parsed-full)\n"
       "\tparsed-full\n\n"
       "\t(test-message)\n\n"))

(defn get-prompt
  [ns]
  (str "\u001B[35m[\u001B[34m"
       ns
       "\u001B[35m]\u001B[33m λ\u001B[m=> "))

(defproject clojusc/rfc5322 "0.5.0-SNAPSHOT"
  :description "A Parser for the Internet Message Format (RFC 5322)"
  :url "https://github.com/clojusc/rfc5322"
  :license {
    :name "Eclipse Public License"
    :url "http://www.eclipse.org/legal/epl-v10.html"}
  :excludsions [org.clojure/clojure]
  :dependencies [
    [instaparse "1.4.10"]
    [org.clojure/clojure "1.10.0"]
    [speclj "3.3.2"]]
  :plugins [[speclj "3.3.2"]]
  :test-path "spec/"
  :source-paths ["src" "dev-resources/src" "test"]
  :profiles {
    :ubercompile {
      :aot :all}
    :custom-repl {
      :repl-options {
        :init-ns rfc5322.repl
        :prompt ~get-prompt
        :init ~(println (get-banner))
        :welcome ~(println (get-help))}}
    :dev {
      :dependencies [
        [clojusc/trifl "0.4.2"]
        [org.clojure/tools.namespace "0.2.11"]]}
    :lint {
      :plugins [
        [jonase/eastwood "0.3.5"]
        [lein-kibit "0.1.6"]]}
    :test {
      :dependencies [
        [clojusc/ltest "0.4.0-SNAPSHOT"]]
      :plugins [
        [lein-ancient "0.6.15"]
        [lein-ltest "0.4.0-SNAPSHOT"]]
      :test-selectors {
        :select :select}}
    :docs {
      :dependencies [
        [codox-theme-rdash "0.1.2"]]
      :plugins [
        [lein-codox "0.10.5"]
        [lein-marginalia "0.9.1"]
        [lein-simpleton "1.3.0"]]
      :codox {
        :project {
          :name "rfc5322"
          :description "A Parser for the Internet Message Format (RFC 5322)"}
        :namespaces [#"^rfc5322\.(?!dev)"]
        :themes [:rdash]
        :output-path "docs/master/current"
        :doc-paths ["docs/source"]
        :metadata {
          :doc/format :markdown
          :doc "Documentation forthcoming"}}}}
  :aliases {
    "repl" ["with-profile" "+custom-repl,+test" "repl"]
    "ubercompile" ["with-profile" "+ubercompile" "compile"]
    "check-vers" ["with-profile" "+test" "ancient" "check" ":all"]
    "check-jars" ["with-profile" "+test" "do"
      ["deps" ":tree"]
      ["deps" ":plugin-tree"]]
    "check-deps" ["do"
      ["check-jars"]
      ["check-vers"]]
    "kibit" ["with-profile" "+lint" "kibit"]
    "eastwood" ["with-profile" "+lint" "eastwood" "{:namespaces [:source-paths]}"]
    "lint" ["do"
      ["kibit"]
      ;["eastwood"]
      ]
    "ltest" ["with-profile" "+test" "ltest"]
    "docs" ["with-profile" "+docs,+test" "do"
      ["codox"]
      ["marg" "--dir" "docs/current"
              "--file" "marginalia.html"
              "--name" "sockets"]]
    "build" ["with-profile" "+test" "do"
      ;["check-deps"]
      ["ubercompile"]
      ["lint"]
      ["ltest"]
      ["docs"]
      ["uberjar"]]
    "publish-docs" ["do"
      ["docs"]
      ["shell" "resources/scripts/publish-docs.sh"]]})
