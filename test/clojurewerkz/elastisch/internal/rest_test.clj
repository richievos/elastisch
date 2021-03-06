(ns clojurewerkz.elastisch.internal.rest-test
  (:require [clojurewerkz.elastisch.rest :as rest]
            [clojure.test :refer :all]))

(println (str "Using Clojure version " *clojure-version*))

(deftest test-successful-connection
  (is (= "http://localhost:9200" (:uri rest/*endpoint*)))
  (is (not (nil? (:version rest/*endpoint*)))))


(deftest test-mget-path
  (is (= "http://localhost:9200/_mget"
         (rest/index-mget-url)))
  (is (= "http://localhost:9200/index_name/_mget"
         (rest/index-mget-url "index_name")))
  (is (= "http://localhost:9200/index_name/type_name/_mget"
         (rest/index-mget-url "index_name" "type_name"))))
