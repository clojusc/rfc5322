(ns rfc5322.core
  (:require [clojure.java.io :as io]
            [instaparse.core :as insta]))

(defn read-grammar
  [filename]
  (io/resource filename))

(def grammar-parser
  (insta/parser
    "resources/rfc5322.abnf"
    :input-format :abnf
    :instaparse.abnf/case-insensitive true))

(def grammar-parser-no-obselete
  (insta/parser
    "resources/rfc5322-no-obselete.abnf"
    :input-format :abnf
    :instaparse.abnf/case-insensitive true))

(defn obsolete
  [key]
  (when (keyword? key)
    (re-find #"^obs\-" (name key))))

(defn parse
  "Parses a string and returns the simplified parse tree if it is a valid email
  and nil otherwise. Because RFC 5322 is ambiguous, the returned parse tree
  is the one with the least number of obsolete tokens."
  ([msg]
    (parse msg grammar-parser))
  ([msg parser]
    (insta/parse parser msg)))

(defn valid?
  "Answer with whether a given string is a valid email address according to the
  RFC 5322 specification."
  [email]
  (vector? (parse email)))
