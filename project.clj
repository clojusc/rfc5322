(defproject clojusc/rfc5322 "0.2.0-SNAPSHOT"
  :description "A Parser for the Internet Message Format (RFC 5322)"
  :url "https://github.com/clojusc/rfc5322"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [instaparse "1.4.5"]
                 [speclj "3.3.2"]]
  :plugins [[speclj "2.7.4"]]
  :test-path "spec/")
