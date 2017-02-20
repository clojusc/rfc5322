(ns rfc5322.core
  (:require [instaparse.core :as insta]))

;;;; This provides functions for parsing a string to determine if it is a valid
;;;; email address according to RFC 5322 which obsoletes the former
;;;; specification RFC 2822. RFC 2822 obsoleted the original specification for
;;;; email which is RFC 822.

;;;; Author: Zachary Kuhn

(def email-parser
  (insta/parser
    "src/rfc5322/rfc5322.abnf"
    :input-format :abnf))

;; All tokens that begin with 'obs-' are considered obsolete in the spec
(defn obsolete
  [key]
  (when (keyword? key)
    (re-find #"^obs\-" (name key))))

(defn obsolete-matches
  "Answers with the number of obsolete tokens in a parse"
  [parse-tree]
  (count (filter obsolete (flatten parse-tree))))

(defn sort-by-least-obsolete-matches
  [parse-trees]
  (sort-by obsolete-matches parse-trees))

(defn parse
  "Parses a string and returns the simplified parse tree if it is a valid email
  address and nil otherwise. Because RFC 5322 is ambiguous, the returned parse
  is the one with the least number of obsolete tokens."
  [email]
  (->>
    (insta/parses email-parser email :start :addr-spec)
    ;; Collapse many of the extra tokens so the returned parse is more readable.
    (insta/transform
      {:ALPHA str
       :DQUOTE str
       :quoted-string str
       :qcontent str
       :qtext str
       :atext str
       :atom str
       :word str
       :dot-atom-text str
       :dot-atom str
       :obs-local-part
         (fn
            [& words]
            [:obs-local-part (clojure.string/join words)])})
    sort-by-least-obsolete-matches
    first))

(defn valid?
  "Answer with whether a given string is a valid email address according to the
  RFC 5322 specification."
  [email]
  (vector? (parse email)))
