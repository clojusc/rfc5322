(ns rfc5322.tests.parser
  (:require
  	[clojure.test :refer :all]
    [rfc5322.core :as core]
    [rfc5322.tests.data :as test-data]
    [taoensso.timbre :as log]))

(log/set-level! :warn)

(deftest core
	(is (= {}
		     (core/convert test-data/msg-1))))
