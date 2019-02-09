(ns rfc5322.tests.parser
  (:require
  	[clojure.test :refer :all]
    [rfc5322.parser :as parser]
    [rfc5322.tests.data :as test-data]
    [taoensso.timbre :as log])
  (:refer-clojure :exclude [parse]))

(log/set-level! :warn)

(deftest parse
	(let [full (parser/parse (test-data/load "sample-1.rfc5322") :full)]
	  (is (= full (parser/parse (test-data/load "sample-1.rfc5322"))))
	  (is (= :message (first full)))
	  (is (= 458 (count (flatten (second full)))))))

(deftest parse-no-obselete
	(let [lite (parser/parse (test-data/load "sample-1.rfc5322") :lite)]
	  (is (= :message (first lite)))
	  (is (= 336 (count (flatten (second lite)))))))
