(ns rfc5322.xform
  (:require
    [clojure.java.io :as io]
    [clojure.string :as string]
    [instaparse.core :as instaparse]
    [rfc5322.parser :as parser]))

(defn ->str-data
  [key & strs]
  {key (reduce str strs)})

(defn get-name
  [xs]
  (->> xs
       (map :name)
       (remove nil?)
       (first)
       (string/lower-case)
       (keyword)))

(defn get-value
  [xs]
  (->> xs
       (map :value)
       (remove nil?)
       (first)
       (string/trim)))

(defn pairs->map
  [& xs]
  {(get-name xs) (get-value xs)})

(defn merge-fields
  [& xs]
  (->> xs
       (filter map?)
       (reduce merge)))

(defn ->map
  "Transform data in RFC 5322 internet message format to a map.

  Note that this is by no means definitive or complete!"
  [xs]
  (instaparse/transform
    {:LF str
     :line-feeds str
     :text str
     :VCHAR str
     :WSP str
     :FWS str
     :ftext str
     :obs-utext str
     :obs-FWS str
     :obs-body str
     :obs-unstruct str
     :body (partial ->str-data :body)
     :field-name (partial ->str-data :name)
     :unstructured (partial ->str-data :value)
     :obs-optional pairs->map
     :optional-field pairs->map
     :obs-fields merge-fields
     :fields merge-fields
     :message merge-fields}
    xs))
