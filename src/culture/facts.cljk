(ns culture.facts
  "Country-level regional-culture catalog for El Salvador (SLV) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"SLV"
   [{:culture/id "slv.dish.pupusa"
     :culture/name "Pupusa"
     :culture/country "SLV"
     :culture/kind :dish
     :culture/summary "Thick griddle cake stuffed with cheese, beans, chicharron or squash; the national dish of El Salvador with its own National Pupusa Day, and recognized by the WTO in 2018 as El Salvador's designation of origin."
     :culture/url "https://en.wikipedia.org/wiki/Pupusa"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "slv.dish.curtido"
     :culture/name "Curtido"
     :culture/country "SLV"
     :culture/kind :dish
     :culture/summary "Lightly fermented cabbage, onion and carrot relish typical of Salvadoran cuisine, commonly served alongside pupusas."
     :culture/url "https://en.wikipedia.org/wiki/Curtido"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "slv.dish.yuca-frita"
     :culture/name "Yuca frita"
     :culture/country "SLV"
     :culture/kind :dish
     :culture/summary "Deep-fried cassava root served with curtido and chicharron, listed among the dishes of Salvadoran cuisine."
     :culture/url "https://en.wikipedia.org/wiki/Salvadoran_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "slv.beverage.horchata-de-morro"
     :culture/name "Horchata de morro"
     :culture/country "SLV"
     :culture/kind :beverage
     :culture/summary "El Salvador's version of horchata, made by grinding jicaro (morro) seeds with rice rather than the Spanish tiger-nut or Mexican rice-only bases used elsewhere."
     :culture/url "https://en.wikipedia.org/wiki/Horchata"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "slv.craft.ilobasco-pottery"
     :culture/name "Ilobasco pottery"
     :culture/country "SLV"
     :culture/kind :craft
     :culture/summary "Locally extracted clay craftsmanship from the city of Ilobasco, including miniature scenes and \"surprises\" (a hidden scene under a fruit- or house-shaped clay cover); described as valuable architectural heritage and a major tourist attraction in El Salvador."
     :culture/url "https://en.wikipedia.org/wiki/Ilobasco"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "slv.heritage.joya-de-ceren"
     :culture/name "Joya de Ceren"
     :culture/name-local "Joya de Cerén"
     :culture/country "SLV"
     :culture/kind :heritage
     :culture/summary "Pre-Hispanic Maya farming community buried by the Laguna Caldera volcano around AD 600, nicknamed the \"Pompeii of the Americas\"; inscribed on the UNESCO World Heritage List in 1993 for its archaeological importance."
     :culture/url "https://en.wikipedia.org/wiki/Joya_de_Cer%C3%A9n"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-slv culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "SLV"))
                 " SLV entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
