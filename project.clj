(defproject clojusc/rfc5322 "0.4.0-SNAPSHOT"
  :description "A Parser for the Internet Message Format (RFC 5322)"
  :url "https://github.com/clojusc/rfc5322"
  :license {
    :name "Eclipse Public License"
    :url "http://www.eclipse.org/legal/epl-v10.html"}
  :excludsions [org.clojure/clojure]
  :dependencies [
    [cpath-clj "0.1.2"]
    [instaparse "1.4.5"]
    [org.clojure/clojure "1.8.0"]
    [speclj "3.3.2"]]
  :plugins [[speclj "2.7.4"]]
  :test-path "spec/"
  :repl-options {
    :init-ns rfc5322.dev
    :welcome (println
               (str "\nTo demo the code, try the following:\n\n"
                    "\t(demo-lite)\n"
                    "\t(source demo-lite)\n"
                    "\t(source lite)\n\n"
                    "\t(demo-full)\n"
                    "\t(source demo-full)\n"
                    "\t(source full)\n"
                    "\t(source ->map)\n"))}
  :source-paths ["src" "dev-resources/src" "test"]
  :profiles {
    :ubercompile {
      :aot :all}
    :test {
      :plugins [
         [jonase/eastwood "0.2.3"]
         [lein-ancient "0.6.10"]
         [lein-bikeshed "0.4.1"]
         [lein-kibit "0.1.2"]
         [venantius/yagni "0.1.4"]]}
    :docs {
      :dependencies [[codox-theme-rdash "0.1.1"]]
      :plugins [[lein-codox "0.10.1"]
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
    "check-deps" [
      "with-profile" "+test" "ancient" "check" ":all"]
    "kibit" [
      "with-profile" "+test" "do"
        ["shell" "echo" "== Kibit =="]
        ["kibit"]]
    "outlaw" [
      "with-profile" "+test"
      "eastwood" "{:namespaces [:source-paths] :source-paths [\"src\"]}"]
    "lint" [
      "with-profile" "+test" "do"
        ["check"] ["kibit"] ["outlaw"]]
    "build" ["with-profile" "+test" "do"
      ["check-deps"]
      ;["lint"]
      ["test"]
      ["compile"]
      ["with-profile" "+ubercompile" "compile"]
      ["clean"]
      ["uberjar"]]})
