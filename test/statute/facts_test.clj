(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest slv-has-spec-basis
  (let [sb (facts/spec-basis "SLV")]
    (is (= 8 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "https://") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["SLV" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= #{"slv.decreto-652-ley-compras-publicas"}
         (set (mapv :statute/id (facts/by-topic "SLV" :public-procurement)))))
  (is (= #{"slv.decreto-671-codigo-comercio"}
         (set (mapv :statute/id (facts/by-topic "SLV" :corporate-governance)))))
  (is (= #{"slv.decreto-230-codigo-tributario"}
         (set (mapv :statute/id (facts/by-topic "SLV" :tax)))))
  (is (= #{"slv.decreto-15-codigo-trabajo"}
         (set (mapv :statute/id (facts/by-topic "SLV" :labor)))))
  (is (= #{"slv.decreto-732-ley-inversiones" "slv.decreto-663-proesa"}
         (set (mapv :statute/id (facts/by-topic "SLV" :foreign-investment)))))
  (is (= #{"slv.decreto-201-ley-integracion-monetaria" "slv.decreto-57-ley-bitcoin"}
         (set (mapv :statute/id (facts/by-topic "SLV" :currency)))))
  (is (empty? (facts/by-topic "ATL" :labor))))
