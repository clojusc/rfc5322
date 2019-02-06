(ns rfc5322.repl
  "Development namespace"
  (:require
    [clojure.java.io :as io]
    [clojure.pprint :refer [pprint print-table]]
    [clojure.string :as string]
    [clojure.walk :refer [macroexpand-all]]
    [instaparse.core :as instaparse]
    [rfc5322.core.test :as test]
    [rfc5322.core :as core]
    [rfc5322.parser :as parser]
    [trifl.java :refer [show-methods]]))

(def lite (instaparse/parse (parser/make-lite-parser) test/msg-1))
(def full (instaparse/parse (parser/make-full-parser) test/msg-1))

(defn demo-lite
  []
  (pprint
    (core/->map lite)))

(defn demo-full
  []
  (pprint
    (core/->map full)))
