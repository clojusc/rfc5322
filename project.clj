(defproject clojusc/rfc5322 "0.3.0"
  :description "A Parser for the Internet Message Format (RFC 5322)"
  :url "https://github.com/clojusc/rfc5322"
  :license {
    :name "Eclipse Public License"
    :url "http://www.eclipse.org/legal/epl-v10.html"}
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
    :uberjar {:aot :all}})
