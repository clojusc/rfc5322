(ns rfc5322.core.test
  (:require
  	[clojure.test :refer :all]
    [rfc5322.parser :as parser]))

(def msg-1
"From: Alice <alice@example.com>
To: Bob <bob@example.com>
Subject: Security
Date: Fri, 21 Nov 1997 09:55:06 -0600
Message-ID: <a1b2c3d4@smtp.example.com>

There may be a problem with your passwords. In
particular, your consistent use of the same one
over the course of many years. Somewhat worrying
is the fact that 'secret' is fairly easy to guess
(and no, 'sekrit' isn't any better). However,
what I find most troubling is that this password
has been published in countless online security
documents and open source software. I suspect
a leak.")

(deftest rfc5322-parse
  (is (= (first (parser/parse msg-1))
         :message)))

(deftest rfc5322-parse-no-obselete
  (is (= (first (parser/parse msg-1 (parser/make-lite-parser)))
         :message)))
