(ns rfc5322.core
  (:require
    [instaparse.core :as instaparse]
    [rfc5322.xform :as xform]
    [rfc5322.parser :as parser]
    [trifl.java :refer [show-methods]]))

(defn convert
  "Given an RFC 5322 formatted message, parse it and convert it to a Clojure
  hash-map."
  ([message-text]
    (convert message-text :full))
  ([message-text mode]
    (-> message-text
        (parser/parse mode)
        (xform/->map))))
