(ns marketentry.registry-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.registry :as registry]))

(deftest engagement-fee-recompute
  (let [e {:base-fee 500000 :monthly-rate 30000 :monitoring-months 12 :claimed-fee 860000.0}]
    (is (== 860000.0 (registry/compute-engagement-fee e)))
    (is (true? (registry/engagement-fee-matches-claim? e))))
  (let [bad {:base-fee 500000 :monthly-rate 30000 :monitoring-months 12 :claimed-fee 999000.0}]
    (is (false? (registry/engagement-fee-matches-claim? bad)))))

(deftest register-draft-and-submit
  (let [d (registry/register-draft "eng-1" "SLV" 0)
        s (registry/register-submit "eng-1" "SLV" 0)]
    (is (= "SLV-DFT-000000" (get d "draft_number")))
    (is (= "SLV-SUB-000000" (get s "submit_number")))
    (is (nil? (get-in d ["certificate" "proof"])))
    (is (= "draft-unsigned" (get-in s ["certificate" "status"])))))

(deftest register-requires-ids
  (is (thrown? Exception (registry/register-draft "" "SLV" 0)))
  (is (thrown? Exception (registry/register-submit "eng-1" "" 0))))

(deftest foreign-entity-eligible-domestic-entity-always-eligible
  (testing "a non-foreign (domestic) entity is always eligible on this ground, regardless of the other facts"
    (is (true? (registry/foreign-entity-eligible? {:foreign-entity? false})))
    (is (true? (registry/foreign-entity-eligible? {})))))

(deftest foreign-entity-eligible-requires-both-facts
  (testing "a foreign entity is eligible only when BOTH home-country-constituted? and local-registro-comercio-inscrito? are true"
    (is (true? (registry/foreign-entity-eligible?
                {:foreign-entity? true :home-country-constituted? true :local-registro-comercio-inscrito? true})))
    (is (false? (registry/foreign-entity-eligible?
                 {:foreign-entity? true :home-country-constituted? true :local-registro-comercio-inscrito? false})))
    (is (false? (registry/foreign-entity-eligible?
                 {:foreign-entity? true :home-country-constituted? false :local-registro-comercio-inscrito? true})))
    (is (false? (registry/foreign-entity-eligible?
                 {:foreign-entity? true})))))

(deftest foreign-entity-eligibility-mismatch-is-entity-scope-gated
  (testing "an engagement with no claim at all is never flagged"
    (is (false? (registry/foreign-entity-eligibility-mismatch?
                 {:foreign-entity? true :home-country-constituted? false :local-registro-comercio-inscrito? false}))))
  (testing "a claimed eligibility that does NOT match the independently recomputed test -> mismatch"
    (is (true? (registry/foreign-entity-eligibility-mismatch?
                {:foreign-entity? true :home-country-constituted? true :local-registro-comercio-inscrito? false
                 :claimed-eligible? true})))
    (is (true? (registry/foreign-entity-eligibility-mismatch?
                {:foreign-entity? false :claimed-eligible? false}))))
  (testing "a claimed eligibility that DOES match -> not flagged"
    (is (false? (registry/foreign-entity-eligibility-mismatch?
                 {:foreign-entity? true :home-country-constituted? true :local-registro-comercio-inscrito? true
                  :claimed-eligible? true})))
    (is (false? (registry/foreign-entity-eligibility-mismatch?
                 {:foreign-entity? false :claimed-eligible? true})))))
