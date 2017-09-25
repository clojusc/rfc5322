(defproject clojusc/rfc5322 "0.4.0-SNAPSHOT"
  :description "A Parser for the Internet Message Format (RFC 5322)"
  :url "https://github.com/clojusc/rfc5322"
  :license {
    :name "Eclipse Public License"
    :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
    [cpath-clj "0.1.2"]
    [instaparse "1.4.8"]
    [org.clojure/clojure "1.8.0"]
    [speclj "3.3.2"]]
  :plugins [[speclj "3.3.2"]]
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
    :uberjar {
      :aot :all}
    :test {
      :exclusions [org.clojure/clojure]
      :plugins [
        [jonase/eastwood "0.2.4"]
        [lein-kibit "0.1.5"]
        [lein-ancient "0.6.12"]]}
    :dev {
      :source-paths ["dev-resources/src"]
      :repl-options {
        :init-ns trifl.dev}
      :dependencies [
        [org.clojure/tools.namespace "0.2.11"
         :exclusions [org.clojure/clojure]]]}}
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
      ["lint"]
      ["test"]
      ["compile"]
      ["uberjar"]]})
