(ns rfc5322.tests.core
  (:require
  	[clojure.test :refer :all]
    [rfc5322.core :as core]
    [rfc5322.tests.data :as test-data]
    [taoensso.timbre :as log]))

(log/set-level! :warn)

(deftest core
	(is (= {:from "Alice <alice@example.com>"
		      :to "Bob <bob@example.com>"
		      :subject "Security"
		      :date "Fri, 21 Nov 1997 09:55:06 -0600"
		      :message-id "<a1b2c3d4@smtp.example.com>"
		      :body "There may be a problem with your passwords. In\nparticular, your consistent use of the same one\nover the course of many years. Somewhat worrying\nis the fact that 'secret' is fairly easy to guess\n(and no, 'sekrit' isn't any better). However,\nwhat I find most troubling is that this password\nhas been published in countless online security\ndocuments and open source software. I suspect\na leak.\n"}
		     (core/convert (test-data/load "sample-1.rfc5322")))))
