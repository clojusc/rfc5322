(ns rfc5322.core
  (:require
    [instaparse.core :as instaparse]
    [rfc5322.xform :as xform]
    [rfc5322.parser :as parser]
    [taoensso.timbre :as log]))

(defn log-and-passthrough
  [x level msg]
  (log/log level (str msg x))
  x)

(defn convert
  "Given an RFC 5322 formatted message, parse it and convert it to a Clojure
  hash-map."
  [message-text & mode]
  (let [mode (vec (or mode [:full]))]
    (-> message-text
        (parser/parse mode)
        (log-and-passthrough :trace "Got parsed data: ")
        (xform/->map)
        (log-and-passthrough :trace "Got mapped data: "))))
