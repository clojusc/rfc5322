(ns rfc5322.tests.data
	(:require
		[clojure.java.io :as io])
	(:refer-clojure :exclude [load]))

(defn load
	[filename]
	(slurp (io/resource filename)))
