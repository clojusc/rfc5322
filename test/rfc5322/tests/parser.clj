(ns rfc5322.tests.parser
  (:require
  	[clojure.test :refer :all]
    [rfc5322.parser :as parser]
    [rfc5322.tests.data :as test-data]
    [taoensso.timbre :as log])
  (:import
  	(rfc5322.exception ParserException))
  (:refer-clojure :exclude [parse]))

(log/set-level! :warn)

(deftest parse
	(let [full (parser/parse (test-data/load "sample-1.rfc5322") [:full])]
	  (is (= :message (first full)))
	  (is (= 458 (count (flatten (second full)))))))

(deftest parse-message-line-max-length
	(let [full (parser/parse (test-data/load "sample-2.rfc5322") [:lite])]
	  (is (= :message (first full)))
	  (is (= 336 (count (flatten (second full)))))))

(deftest parse-message-line-too-long
	(is (thrown? ParserException
		           (parser/parse (test-data/load "sample-3.rfc5322") [:lite]))))

(deftest parse-no-obselete
	(let [lite (parser/parse (test-data/load "sample-1.rfc5322") [:lite])]
	  (is (= :message (first lite)))
	  (is (= 336 (count (flatten (second lite)))))))

(deftest parse-utf8
	(let [lite (parser/parse (test-data/load "sample-4.rfc5322") [:lite :utf8])]
	  (is (= :message (first lite)))
	  (is (= 336 (count (flatten (second lite))))))
	(is (thrown? ParserException
		           (parser/parse (test-data/load "sample-4.rfc5322") [:lite]))))
