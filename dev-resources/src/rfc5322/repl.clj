(ns rfc5322.repl
  "Development namespace"
  (:require
    [clojure.java.io :as io]
    [clojure.pprint :refer [pprint print-table]]
    [clojure.string :as string]
    [clojure.walk :refer [macroexpand-all]]
    [instaparse.core :as instaparse]
    [rfc5322.core :as core]
    [rfc5322.parser :as parser]
    [rfc5322.tests.data :as test-data]
    [rfc5322.xform :as xform]
    [taoensso.timbre :as log]
    [trifl.java :refer [show-methods]]))

(log/set-level! :warn)

(def msg-1 (test-data/load "sample-1.rfc5322"))
(def parsed-lite (parser/parse msg-1 [:lite]))
(def parsed-full (parser/parse msg-1 [:full]))

(defn demo-lite
  []
  (-> msg-1
      (core/convert :lite)
      pprint))

(defn demo-full
  []
  (-> msg-1
      (core/convert :full)
      pprint))

(defn test-message
  []
  (println msg-1))
