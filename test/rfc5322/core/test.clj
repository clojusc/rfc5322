(ns rfc5322.core.test
  (:require [clojure.test :refer :all]
            [rfc5322.core :as rfc5322]))

(def msg-1
"From: John Doe <jdoe@machine.example>
To: Mary Smith <mary@example.net>
Subject: Saying Hello
Date: Fri, 21 Nov 1997 09:55:06 -0600
Message-ID: <1234@local.machine.example>

This is a message just to say hello.
So, \"Hello\".")

(deftest rfc5322-parse
  (is (= (first (rfc5322/parse msg-1))
         :message)))

(deftest rfc5322-parse-no-obselete
  (is (= (first (rfc5322/parse msg-1 rfc5322/grammar-parser-no-obselete))
         :message)))
