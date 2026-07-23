(ns marketentry.registry
  "Pure-function market-entry filing-draft + filing-submit record
  construction -- an append-only market-entry book-of-record draft.

  Like every sibling actor's registry, there is no single international
  reference-number standard for a public-sector market-entry filing --
  every jurisdiction assigns its own format. This namespace does NOT
  invent one; it builds a jurisdiction-scoped sequence number and
  validates the record's required fields, the same honest,
  non-fabricating discipline `marketentry.facts` uses.

  `engagement-fee-matches-claim?` is an HONEST reapplication of the
  SAME ground-truth-recompute DISCIPLINE sibling actors use (verify a
  claimed monetary total against the entity's own recorded quantity x
  unit fields), reapplied to a market-entry engagement fee line.

  `foreign-entity-eligible?` / `foreign-entity-eligibility-mismatch?`
  are the SAME discipline applied to a genuinely Republic of El
  Salvador-specific mechanism: Ley de Compras Públicas (Decreto
  Legislativo No. 652, Diario Oficial No. 43, Tomo 438, 2 de marzo de
  2023), Art. 24 literal f)'s own bar on legal capacity to offer and
  contract for 'persona jurídica extranjera y no estar legalmente
  constituida de conformidad con las normas de su propio país, o, no
  haber cumplido con las disposiciones de la legislación nacional
  aplicables para su ejercicio o funcionamiento' -- traced to Código de
  Comercio (Decreto Legislativo No. 671) Arts. 358-360's own foreign-
  company domicile/sucursal + Registro de Comercio registration regime.

  This is a GENUINELY DIFFERENT check SHAPE than every prior iso3166
  sibling this repo mirrors: Nicaragua's Ley 1238 Art. 18.6/Art. 29.4
  mechanism is a THRESHOLD-GATED, CROSS-BRANCH CERTIFICATION
  REQUIREMENT (a legislative-branch body certifies once a contract
  value crosses a threshold); Cuba's Ley 118 Art. 21 mechanism is a
  SECTOR/MODALITY AUTHORITY-JURISDICTION ROUTING classification; Haiti's
  Arrêté du 23 février 2026 mechanism is a CATEGORY-GATED SINGLE-
  THRESHOLD APPLICABILITY GATE; the Dominican Republic's MIPYME
  mechanism is a CERTIFICATION-GATED, DUAL-CLOCK ELIGIBILITY test. El
  Salvador's Art. 24 literal f) mechanism is none of these: it is a
  SELF-ATTESTED, COMPOUND (two-ANDed-fact) NEGATIVE ELIGIBILITY
  CRITERION with a NULLITY consequence -- there is no threshold and no
  separate third-party certifying authority the way Nicaragua's
  Comisión de Verificación de Proveedores del Estado is; the
  contracting institution's own Unidad de Compras Públicas reviews it
  at intake. This iteration deliberately did NOT invent a second
  'unverified-by-a-third-party' check to force a two-part shape onto a
  mechanism the law itself only gives one self-attested test for -- a
  smaller honest catalog beats a fabricated comprehensive one.

  This iteration also deliberately did NOT model Art. 39/40's floating
  '240 salarios mínimos mensuales del sector comercio vigente' licitación-
  competitiva/comparación-de-precios threshold as a governor check: this
  iteration did not independently confirm today's dollar value of that
  wage-indexed figure (Ministerio de Trabajo y Previsión Social's
  current minimum-wage decree was not fetched this session) -- the same
  honest scope-narrowing discipline Cuba's two-of-three-tier Ley 118
  Art. 21 model and Nicaragua's un-fetched Acuerdo Ministerial inflation
  update already established for this family.

  This namespace is pure data + pure functions -- no I/O, no network
  call to any real government system. It builds the RECORD an operator
  would keep, not the act of submitting a portal registration itself
  (that is `marketentry.operation`'s `:filing/submit`, always
  human-gated -- see README Actuation)."
  (:require [clojure.string :as str]))

(defn- unsigned-certificate
  "Every certificate this actor produces is UNSIGNED -- signature is
  the market-entry operator's act, not this actor's."
  [kind subject record-id]
  {"@context" ["https://www.w3.org/ns/credentials/v2"]
   "type" ["VerifiableCredential" kind]
   "credentialSubject" {"id" subject "record" record-id}
   "proof" nil
   "issued_by_registry" false
   "status" "draft-unsigned"})

(defn- zero-pad [n w]
  (let [s (str n)]
    (str (apply str (repeat (max 0 (- w (count s))) "0")) s)))

(defn compute-engagement-fee
  "The ground-truth engagement fee for `engagement`'s own `:base-fee`
  and `:monitoring-months` x `:monthly-rate` -- a single flat
  base + months x rate calculation, not a full pricing engine."
  [{:keys [base-fee monthly-rate monitoring-months]}]
  (+ (double base-fee)
     (* (double monthly-rate) (double monitoring-months))))

(defn engagement-fee-matches-claim?
  "Does `engagement`'s own `:claimed-fee` equal the independently
  recomputed `compute-engagement-fee`?"
  [{:keys [claimed-fee] :as engagement}]
  (== (double claimed-fee) (compute-engagement-fee engagement)))

(defn foreign-entity-eligible?
  "The ground-truth answer, independently recomputed from `engagement`'s
  own declared `:foreign-entity?` / `:home-country-constituted?` /
  `:local-registro-comercio-inscrito?`, to 'does Ley de Compras Públicas
  Art. 24 literal f) bar this bidder from legal capacity to offer and
  contract' -- a domestic (non-foreign) entity is always eligible on
  this ground. A foreign entity is eligible only when BOTH: it is
  validly constituted under its own country's law, AND it has complied
  with the Salvadoran national legislation applicable to its operation
  (Código de Comercio Arts. 358-360: fixed domicile or sucursal,
  registered at the Registro de Comercio). A missing/nil
  `:foreign-entity?` is treated as false (domestic, not a foreign
  entity) -- the same fail-strict-on-the-DECLARED-facts discipline the
  rest of this family uses for a missing declared quantity, rather than
  throwing."
  [{:keys [foreign-entity? home-country-constituted? local-registro-comercio-inscrito?]}]
  (or (not foreign-entity?)
      (boolean (and home-country-constituted? local-registro-comercio-inscrito?))))

(defn foreign-entity-eligibility-mismatch?
  "Does `engagement` declare a `:claimed-eligible?` that does NOT match
  the independently recomputed `foreign-entity-eligible?`? An engagement
  with no claim at all is not flagged by this check (entity/engagement-
  scope-gated, the same discipline Cuba's `:claimed-approval-authority`-
  gated check and Nicaragua's `:claimed-certificado-requerido?`-gated
  check use)."
  [{:keys [claimed-eligible?] :as engagement}]
  (boolean (and (some? claimed-eligible?)
                (not= claimed-eligible? (foreign-entity-eligible? engagement)))))

(defn register-draft
  "Validate + construct the FILING-DRAFT registration DRAFT -- the
  market-entry operator's own act of preparing a portal registration
  package. Pure function -- does not touch any real government system."
  [engagement-id jurisdiction sequence]
  (when-not (and engagement-id (not= engagement-id ""))
    (throw (ex-info "draft: engagement_id required" {})))
  (when-not (and jurisdiction (not= jurisdiction ""))
    (throw (ex-info "draft: jurisdiction required" {})))
  (when (< sequence 0)
    (throw (ex-info "draft: sequence must be >= 0" {})))
  (let [draft-number (str (str/upper-case jurisdiction) "-DFT-" (zero-pad sequence 6))
        record {"record_id" draft-number
                "kind" "filing-draft"
                "engagement_id" engagement-id
                "jurisdiction" jurisdiction
                "immutable" true}]
    {"record" record "draft_number" draft-number
     "certificate" (unsigned-certificate "FilingDraft" draft-number draft-number)}))

(defn register-submit
  "Validate + construct the FILING-SUBMIT registration DRAFT -- the
  market-entry operator's own act of actually submitting the DINAC/
  COMPRASAL filing / Registro de Comercio inscription (always
  human-gated upstream)."
  [engagement-id jurisdiction sequence]
  (when-not (and engagement-id (not= engagement-id ""))
    (throw (ex-info "submit: engagement_id required" {})))
  (when-not (and jurisdiction (not= jurisdiction ""))
    (throw (ex-info "submit: jurisdiction required" {})))
  (when (< sequence 0)
    (throw (ex-info "submit: sequence must be >= 0" {})))
  (let [submit-number (str (str/upper-case jurisdiction) "-SUB-" (zero-pad sequence 6))
        record {"record_id" submit-number
                "kind" "filing-submit"
                "engagement_id" engagement-id
                "jurisdiction" jurisdiction
                "immutable" true}]
    {"record" record "submit_number" submit-number
     "certificate" (unsigned-certificate "FilingSubmit" submit-number submit-number)}))

(defn append [history result]
  (conj (vec history) (get result "record")))
