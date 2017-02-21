(ns rfc5322.core
  (:require [clojure.java.io :as io]
            [instaparse.core :as insta]))

(defn read-grammar
  [filename]
  (io/resource filename))

(defn make-grammar-parser
  [filename]
  (insta/parser
    filename
    :input-format :abnf
    :instaparse.abnf/case-insensitive true))

(defn make-full-parser
  []
  (make-grammar-parser "resources/rfc5322.abnf"))

(defn make-lite-parser
  []
  (make-grammar-parser "resources/rfc5322-no-obselete.abnf"))

(defn obsolete
  [key]
  (when (keyword? key)
    (re-find #"^obs\-" (name key))))

(defn parse
  "Parses a string and returns the simplified parse tree if it is a valid email
  and nil otherwise. Because RFC 5322 is ambiguous, the returned parse tree
  is the one with the least number of obsolete tokens."
  ([msg]
    (parse msg (make-full-parser)))
  ([msg parser]
    (insta/parse parser msg)))

