(ns marketentry.facts-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.facts :as facts]))

(deftest slv-has-spec-basis
  (let [sb (facts/spec-basis "SLV")]
    (is (some? sb))
    (is (string? (:provenance sb)))
    (is (seq (:required-evidence sb)))
    (is (some? (facts/corporate-number-spec-basis "SLV")))
    (is (some? (facts/foreign-entity-eligibility-spec-basis "SLV")))))

(deftest slv-rep-spec-basis-is-honestly-absent
  (testing "no verifiable Salvadoran representative-exclusion-extension provision was located -- deliberately not claimed"
    (is (nil? (facts/rep-spec-basis "SLV")))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest required-evidence-satisfied
  (let [sb (facts/spec-basis "SLV")
        all (:required-evidence sb)]
    (is (true? (facts/required-evidence-satisfied? "SLV" all)))
    (is (not (facts/required-evidence-satisfied? "SLV" (take 1 all))))
    (is (nil? (facts/required-evidence-satisfied? "ATL" all)))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["SLV" "USA" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 2 (:covered c)))
    (is (= ["ATL"] (:missing-jurisdictions c)))))

(deftest foreign-entity-eligibility-spec-basis-criteria
  (let [fe (facts/foreign-entity-eligibility-spec-basis "SLV")]
    (is (= #{:home-country-constituted? :local-registro-comercio-inscrito?}
           (get-in fe [:foreign-entity-eligibility-criteria :requires-both])))))
