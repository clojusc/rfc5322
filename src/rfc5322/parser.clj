(ns rfc5322.parser
  (:require
    [clojure.java.io :as io]
    [instaparse.core :as instaparse]
    [taoensso.timbre :as log]))

(defn read-grammar
  [filename]
  (io/input-stream (io/resource filename)))

(defn make-grammar-parser
  [filename]
  (instaparse/parser
    (read-grammar filename)
    :input-format :abnf
    :instaparse.abnf/case-insensitive true))

(defn make-parser
  [mode]
  (case mode
    :lite (make-grammar-parser "rfc5322-no-obselete.abnf")
    :full (make-grammar-parser "rfc5322.abnf")))

(defn obsolete
  [key]
  (when (keyword? key)
    (re-find #"^obs\-" (name key))))

(defn parse
  "Parses a string and returns the simplified parse tree if it is a valid email
  and nil otherwise. Because RFC 5322 is ambiguous, the returned parse tree
  is the one with the least number of obsolete tokens."
  ([message-text]
    (parse message-text :full))
  ([message-text mode]
    (log/debugf "Parsing message \n%s\nUsing %s mode ..."
                message-text
                mode)
    (instaparse/parse (make-parser mode) message-text)))
