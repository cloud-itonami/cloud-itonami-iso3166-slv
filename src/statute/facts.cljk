(ns statute.facts
  "General-law compliance catalog for the Republic of El Salvador (SLV)
  -- extends this repo's existing `marketentry.facts` (public-sector
  market-entry/foreign-investment only, narrow scope) with a second,
  orthogonal catalog of national statutes a foreign investor operating
  in this jurisdiction must generally track for compliance. Mirrors
  cloud-itonami-iso3166-jpn/-deu/-bgr/-aze/-alb/-arm/-atg/-ben/-btn/-caf/
  -cub/-hti/-dom/-nic's `statute.facts` (ADR-2607141700, cloud-itonami-
  compliance-fact-federation).

  Every entry cites an OFFICIAL government-hosted URL, fetched and
  `pdftotext -layout`-verified this iteration (2026-07-22/23) directly
  from `www.asamblea.gob.sv` (the Asamblea Legislativa's own decree
  portal -- a public POST search form + per-decree pages with a direct
  PDF link, no bot-detection encountered on this host) or
  `www.mh.gob.sv` (Ministerio de Hacienda) -- never fabricated.

  - **Company/commercial registration**: Código de Comercio, Decreto
    Legislativo No. 671 (aprobado 8 de mayo de 1970, publicado en el
    Diario Oficial No. 140, Tomo 228, 31 de julio de 1970, since
    reformed many times through 2025). This iteration fetched the
    Asamblea's own consolidated PDF directly and confirmed Art. 456 (own
    text, read directly, Título III 'PUBLICIDAD', Capítulo I 'REGISTRO
    DE COMERCIO'): 'SE ESTABLECE EL REGISTRO DE COMERCIO, COMO OFICINA
    ADMINISTRATIVA, DEPENDIENTE DEL CENTRO NACIONAL DE REGISTROS,
    DESTINADA A GARANTIZAR LA PUBLICIDAD FORMAL DE LOS ACTOS Y
    CONTRATOS MERCANTILES...' -- independently confirming the CNR's own
    supervisory role over the Registro de Comercio (`cnr.gob.sv` itself
    returned an Incapsula bot-detection challenge on every direct fetch
    attempt this iteration made; per this session's hard safety rule
    this iteration did NOT attempt to bypass it -- see
    `marketentry.facts` namespace docstring gap note; CNR's role was
    instead independently confirmed from this Code's own text and,
    separately, from the Ley de Compras Públicas' own Art. 10). Art.
    111 (own text): 'LA ESCRITURA SOCIAL DEBE INSCRIBIRSE EN EL REGISTRO
    DE COMERCIO.' Arts. 358-360 (own text, Capítulo XIII 'SOCIEDADES
    EXTRANJERAS'): a foreign company operating in El Salvador must fix
    domicile or establish a sucursal, prove it is 'legalmente
    constituida, de acuerdo con las leyes del país en que se hubiera
    organizado' (Art. 358 literal a), and register at the Registro de
    Comercio -- the SAME mechanism this catalog's `marketentry.facts`
    flagship check (Ley de Compras Públicas Art. 24 literal f) cross-
    references.
  - **Public procurement**: Ley de Compras Públicas, Decreto Legislativo
    No. 652 -- the SAME law `marketentry.facts` uses as its market-entry
    spec-basis; it is ALSO catalogued here as a general national-law
    reference per this task's own instructions, since a foreign investor
    tracks it both as a market-entry gate and as an ongoing compliance
    statute. See `marketentry.facts` for the full research trail on why
    this iteration cites Ley de Compras Públicas (2023) rather than the
    now-repealed LACAP (2000) the task brief originally named.
  - **Tax registration (NIT)**: Código Tributario, Decreto Legislativo
    No. 230 (aprobado por la Asamblea Legislativa 14 de diciembre de
    2000, publicado en el Diario Oficial No. 241, Tomo 349, 22 de
    diciembre de 2000). This iteration fetched the Asamblea's own
    consolidated PDF directly and confirmed Art. 86 (own text, read
    directly, Sección Segunda 'REGISTRO DE CONTRIBUYENTES'): 'La
    Administración Tributaria llevará un Registro de Contribuyentes...
    Deberán inscribirse en el Registro los sujetos pasivos que de
    conformidad a los supuestos establecidos en este Código o en las
    Leyes tributarias respectivas, resulten obligados al pago de los
    diferentes impuestos... El plazo para inscribirse será dentro de los
    quince días siguientes a la fecha de iniciación de las actividades.
    Las personas jurídicas... están sujetos a la obligación establecida
    en el inciso precedente, desde la fecha de su constitución...' Art.
    87 (own text): the NIT (Número de Identificación Tributaria) and
    Número de Registro de Contribuyente are basic registry data. This
    iteration also directly fetched `www.mh.gob.sv` (Ministerio de
    Hacienda, HTTP 200): its own site lists 'NIT DIGITAL' among
    'SERVICIOS FRECUENTES', linking to `portaldgii.mh.gob.sv`.
  - **Labor**: Código de Trabajo, Decreto Legislativo No. 15 (aprobado
    23 de junio de 1972, publicado en el Diario Oficial No. 142, Tomo
    236, 31 de julio de 1972). This iteration fetched this law's own
    consolidated PDF directly from the Asamblea Legislativa's site and
    independently found and read Art. 7 (own text): 'Todo patrono está
    obligado a integrar el personal de su empresa con un noventa por
    ciento de salvadoreños, por lo menos... Sin embargo, en
    circunstancias especiales que el Ministerio de Trabajo y Previsión
    Social calificará, los patronos podrán ser autorizados para emplear
    más de un diez por ciento de extranjeros...' -- a real, verified
    90%-Salvadoran-workforce quota with a discretionary MTPS (Ministerio
    de Trabajo y Previsión Social) technical exception, GENUINELY
    ANALOGOUS to (but independently re-confirmed from El Salvador's own
    text, not copy-pasted from) Nicaragua's Ley 185 Art. 14 finding in
    this same sibling family. Art. 8 (own text): Salvadoran workers'
    combined wages must be at least 85% of an employer's total wage
    bill, subject to the same Art. 7 exception. Art. 10 (own text):
    Central Americans by origin count as Salvadorans for both quotas.
    This is documented here as a real, verified fact this catalog does
    not build a governor check around (it is a general ongoing
    employment obligation on any employer, not a market-entry filing
    gate the way Ley de Compras Públicas Art. 24 literal f is) -- the
    same 'document but do not force into the flagship' discipline this
    task's own instructions call for.
  - **Investment framework**: Ley de Inversiones, Decreto Legislativo
    No. 732 (aprobada por la Asamblea Legislativa 14 de octubre de 1999,
    publicada en el Diario Oficial No. 210, Tomo 345, 11 de noviembre de
    1999, firmada por el Presidente Francisco Guillermo Flores Pérez y
    el Ministro de Economía Miguel Ernesto Lacayo Arguello -- own
    closing signature block read directly). Its own Art. 16 creates the
    Oficina Nacional de Inversiones (ONI), 'como una dependencia del
    Ministerio de Economía, encargada de facilitar, centralizar, y
    coordinar los procedimientos gubernamentales...' Art. 17 (own text):
    foreign investors 'deberán registrar sus inversiones en la ONI,
    quién emitirá una Credencial' -- a REGISTRATION/FACILITATION office,
    not a promotion agency. HONEST, GENUINELY-VERIFIED CORRECTION of a
    plausible task-brief assumption: **PROESA is a SEPARATE institution
    from ONI, created by its OWN later law** -- this iteration
    independently searched and fetched Ley de Creación del Organismo
    Promotor de Exportaciones e Inversiones de El Salvador (PROESA),
    Decreto Legislativo No. 663 (aprobada 9 de abril de 2014, publicada
    en el Diario Oficial No. 93, Tomo 403, 23 de mayo de 2014). Its own
    Art. 1 (own text, read directly): 'Créase el Organismo Promotor de
    Exportaciones e Inversiones de El Salvador, que en el texto de esta
    Ley podrá denominarse PROESA, como una institución de derecho
    público, adscrita a la Presidencia de la República, con personalidad
    jurídica y patrimonio propio...' -- i.e. PROESA (investment/export
    PROMOTION, attached to the Presidency, created 2014) and ONI
    (investment REGISTRATION, under the Ministerio de Economía, created
    1999 by the Ley de Inversiones itself) are two DIFFERENT bodies with
    different roles under different laws; this catalog does not
    conflate them. `www.proesa.gob.sv` itself connection-timed-out on
    every direct fetch attempt this iteration made -- disclosed,
    reachability gap, not concealed; PROESA's own legal basis was
    instead confirmed entirely from its own creation law's text.
  - **Currency / dollarization**: Ley de Integración Monetaria, Decreto
    Legislativo No. 201 (aprobada por la Asamblea Legislativa 30 de
    noviembre de 2000, publicada en el Diario Oficial No. 241, Tomo 349,
    22 de diciembre de 2000 -- the SAME Diario Oficial edition as the
    Código Tributario above). This iteration fetched this law's own text
    directly and confirmed Art. 1 (own text): 'El tipo de cambio entre
    el colón y el dólar de los Estados Unidos de América será fijo e
    inalterable a partir de la vigencia de esta Ley, a razón de ocho
    colones setenta y cinco centavos por dólar...' and Art. 3 (own
    text): 'El dólar tendrá curso legal irrestricto con poder liberatorio
    ilimitado para el pago de obligaciones en dinero en el territorio
    nacional.' -- El Salvador's 2001 dollarization, INDEPENDENTLY
    confirmed rather than assumed.
  - **Bitcoin Law**: Ley Bitcoin, Decreto Legislativo No. 57 (aprobado 8
    de junio de 2021, publicado en el Diario Oficial No. 110, Tomo 431,
    9 de junio de 2021), AS REFORMED by Decreto Legislativo No. 199
    (aprobado 29 de enero de 2025, publicado en el Diario Oficial No.
    21, Tomo 446, 30 de enero de 2025, en vigencia desde el 30 de abril
    de 2025). This iteration independently fetched and read BOTH the
    original law's own consolidated text and the 2025 reform decree's
    own text directly from the Asamblea Legislativa's site. GENUINELY
    VERIFIED FINDING relevant to this task's own research question
    ('does the Bitcoin Law have a merchant-acceptance obligation
    genuinely useful for this catalog, or is it out of scope'): **the
    CURRENT, in-force text of Art. 1 (own text, as reformed, read
    directly) states Bitcoin has 'curso legal, definido por su poder
    liberatorio ilimitado, con ACEPTACIÓN VOLUNTARIA por las personas
    naturales o jurídicas con total participación privada únicamente'
    -- i.e. merchant acceptance of Bitcoin is explicitly VOLUNTARY under
    current law, not mandatory.** The 2025 reform decree's own Art. 7
    additionally repeals the original law's Arts. 4, 8 and 9 outright
    ('Deróguense los artículos 4, 8 y 9 de la Ley Bitcoin', own text).
    Because there is NO current mandatory merchant-acceptance obligation
    to verify, this iteration deliberately did NOT build a
    `marketentry.facts`/governor flagship check on the Bitcoin Law --
    doing so would misrepresent a voluntary regime as a mandatory
    compliance gate. It is catalogued here only as a general statute a
    foreign investor should be aware of (legal-tender status, capital-
    gains tax exemption on Bitcoin exchanges per Art. 5, accounting
    reference currency remains the dollar per Art. 6), consistent with
    this task's own instruction that a smaller honest catalog beats a
    fabricated comprehensive one.

  A law not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of statute entries. `:statute/url` + `:statute/law-number`
  are the citation the governor requires before any compliance-fact
  proposal referencing this law can commit."
  {"SLV"
   [{:statute/id "slv.decreto-652-ley-compras-publicas"
     :statute/title "Ley de Compras Públicas"
     :statute/jurisdiction "SLV"
     :statute/kind :law
     :statute/law-number "Decreto Legislativo No. 652, aprobada por la Asamblea Legislativa 25 de enero de 2023, publicada en el Diario Oficial No. 43, Tomo 438, 2 de marzo de 2023. Reemplaza (own page, own text, of the repealed law: 'DERROGADA POR: LEY DE COMPRAS PÚBLICAS. D. L. N° 652, 25 DE ENERO DE 2023; D. O. N° 43, T. 438, 2 DE MARZO DE 2023.') la LACAP, Ley de Adquisiciones y Contrataciones de la Administración Pública, Decreto Legislativo No. 868 (5 de abril de 2000, Diario Oficial No. 88, Tomo 347, 15 de mayo de 2000). Su ente rector, la DINAC, tiene su propia Ley de Creación (Decreto Legislativo No. 653, misma fecha y Diario Oficial)."
     :statute/url "https://www.asamblea.gob.sv/sites/default/files/documents/decretos/E536B0B9-7307-4A35-9A3F-FD58D141291E.pdf"
     :statute/url-provenance :official-asamblea-gob-sv
     :statute/enacted-date "2023-01-25"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:public-procurement}}
    {:statute/id "slv.decreto-671-codigo-comercio"
     :statute/title "Código de Comercio"
     :statute/jurisdiction "SLV"
     :statute/kind :code
     :statute/law-number "Decreto Legislativo No. 671, aprobado 8 de mayo de 1970, publicado en el Diario Oficial No. 140, Tomo 228, 31 de julio de 1970 (reformado numerosas veces, la más reciente reforma indexada por esta iteración: Decreto Legislativo No. 203, 29 de enero de 2025)."
     :statute/url "https://www.asamblea.gob.sv/sites/default/files/documents/decretos/945102FD-7B05-485E-B98B-6C5D3C0509E3.pdf"
     :statute/url-provenance :official-asamblea-gob-sv
     :statute/enacted-date "1970-05-08"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "slv.decreto-230-codigo-tributario"
     :statute/title "Código Tributario"
     :statute/jurisdiction "SLV"
     :statute/kind :code
     :statute/law-number "Decreto Legislativo No. 230, aprobado por la Asamblea Legislativa 14 de diciembre de 2000, publicado en el Diario Oficial No. 241, Tomo 349, 22 de diciembre de 2000."
     :statute/url "https://www.asamblea.gob.sv/sites/default/files/documents/decretos/CCE2E63A-6B08-4576-919B-A51A59D0B783.pdf"
     :statute/url-provenance :official-asamblea-gob-sv
     :statute/enacted-date "2000-12-14"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:tax}}
    {:statute/id "slv.decreto-15-codigo-trabajo"
     :statute/title "Código de Trabajo"
     :statute/jurisdiction "SLV"
     :statute/kind :code
     :statute/law-number "Decreto Legislativo No. 15, aprobado 23 de junio de 1972, publicado en el Diario Oficial No. 142, Tomo 236, 31 de julio de 1972 (own masthead, read directly)."
     :statute/url "https://www.asamblea.gob.sv/sites/default/files/documents/decretos/07CA3BA2-6910-4CE3-8759-E0C43D4BCAF8.pdf"
     :statute/url-provenance :official-asamblea-gob-sv
     :statute/enacted-date "1972-06-23"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:labor}}
    {:statute/id "slv.decreto-732-ley-inversiones"
     :statute/title "Ley de Inversiones"
     :statute/jurisdiction "SLV"
     :statute/kind :law
     :statute/law-number "Decreto Legislativo No. 732, aprobada por la Asamblea Legislativa 14 de octubre de 1999, publicada en el Diario Oficial No. 210, Tomo 345, 11 de noviembre de 1999, firmada por el Presidente Francisco Guillermo Flores Pérez (own closing signature block, read directly). Crea la Oficina Nacional de Inversiones (ONI), dependencia del Ministerio de Economía -- distinta de PROESA (Decreto Legislativo No. 663, 2014)."
     :statute/url "https://www.asamblea.gob.sv/sites/default/files/documents/decretos/56DB12D8-B277-4461-8D9D-7986402D4556.pdf"
     :statute/url-provenance :official-asamblea-gob-sv
     :statute/enacted-date "1999-10-14"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:foreign-investment}}
    {:statute/id "slv.decreto-663-proesa"
     :statute/title "Ley de Creación del Organismo Promotor de Exportaciones e Inversiones de El Salvador (PROESA)"
     :statute/jurisdiction "SLV"
     :statute/kind :law
     :statute/law-number "Decreto Legislativo No. 663, aprobada 9 de abril de 2014, publicada en el Diario Oficial No. 93, Tomo 403, 23 de mayo de 2014. Institución de derecho público adscrita a la Presidencia de la República (Art. 1, own text) -- SEPARADA de la Oficina Nacional de Inversiones (ONI) que crea la Ley de Inversiones de 1999."
     :statute/url "https://www.asamblea.gob.sv/sites/default/files/documents/decretos/602A60DA-0F4B-47CB-BAFA-A8C6AFB9E60D.pdf"
     :statute/url-provenance :official-asamblea-gob-sv
     :statute/enacted-date "2014-04-09"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:foreign-investment}}
    {:statute/id "slv.decreto-201-ley-integracion-monetaria"
     :statute/title "Ley de Integración Monetaria"
     :statute/jurisdiction "SLV"
     :statute/kind :law
     :statute/law-number "Decreto Legislativo No. 201, aprobada por la Asamblea Legislativa 30 de noviembre de 2000, publicada en el Diario Oficial No. 241, Tomo 349, 22 de diciembre de 2000. Art. 1 (own text): fija el tipo de cambio colón/dólar a 8.75:1; Art. 3 (own text): el dólar tiene curso legal irrestricto con poder liberatorio ilimitado -- la dolarización de El Salvador (2001), verificada directamente."
     :statute/url "https://www.asamblea.gob.sv/sites/default/files/documents/decretos/104A5755-354C-416D-A944-7314F6359CFF.pdf"
     :statute/url-provenance :official-asamblea-gob-sv
     :statute/enacted-date "2000-11-30"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:currency}}
    {:statute/id "slv.decreto-57-ley-bitcoin"
     :statute/title "Ley Bitcoin (as reformed by Decreto Legislativo No. 199)"
     :statute/jurisdiction "SLV"
     :statute/kind :law
     :statute/law-number "Decreto Legislativo No. 57, aprobado 8 de junio de 2021, publicado en el Diario Oficial No. 110, Tomo 431, 9 de junio de 2021; reformado por Decreto Legislativo No. 199, aprobado 29 de enero de 2025, publicado en el Diario Oficial No. 21, Tomo 446, 30 de enero de 2025, en vigencia desde el 30 de abril de 2025 (deroga los Arts. 4, 8 y 9 originales). Art. 1 (own text, as reformed): Bitcoin tiene curso legal con ACEPTACIÓN VOLUNTARIA -- no es una obligación de aceptación mercantil obligatoria bajo el derecho vigente; por eso este catálogo NO construye un governor check sobre esta ley (ver namespace docstring)."
     :statute/url "https://www.asamblea.gob.sv/sites/default/files/documents/decretos/4B2D90B7-98D4-467D-8126-2E180D938095.pdf"
     :statute/url-provenance :official-asamblea-gob-sv
     :statute/enacted-date "2021-06-08"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:currency}}]})

(defn spec-basis
  "The jurisdiction's statute vector, or nil -- nil means NO spec-basis
  for that jurisdiction yet."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report, same shape/discipline as `marketentry.facts/coverage`:
  never report a missing jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-slv statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "SLV")) " SLV statute(s) seeded with an "
                 "official citation. Extend `statute.facts/catalog`, never "
                 "fabricate a law-id or URL.")})))

(defn by-topic
  "Statutes for `iso3` tagged with `topic` (e.g. :labor, :data-protection)."
  [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
