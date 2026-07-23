# cloud-itonami-iso3166-slv

Open ISO 3166 Blueprint for **SLV**: Republic of El Salvador.

- DINAC (Dirección Nacional de Compras Públicas), Ley de Creación de la
  DINAC (Decreto Legislativo No. 653) -- public-sector procurement
  under Ley de Compras Públicas (Decreto Legislativo No. 652, 2023),
  which replaced the earlier LACAP (Decreto Legislativo No. 868, 2000)
- Registro de Comercio (Código de Comercio, Decreto Legislativo No. 671,
  dependency of the Centro Nacional de Registros -- CNR) business
  registration + NIT (Número de Identificación Tributaria, Código
  Tributario Decreto Legislativo No. 230) tax registration

AGPL-3.0-or-later.

## Market-entry / statute catalogs

Governed public-sector market-entry compliance actor, same architecture
as `cloud-itonami-iso3166-cub`/`-nic`. This iteration first verified El
Salvador's REAL, CURRENT procurement law rather than assuming the task
brief's premise: LACAP, "Ley de Adquisiciones y Contrataciones de la
Administración Pública" (which the brief named), turned out to have
been REPEALED and replaced by **Ley de Compras Públicas** (Decreto
Legislativo No. 652, Diario Oficial No. 43, Tomo 438, 2 de marzo de
2023), confirmed directly from the Asamblea Legislativa's own decree
portal (`www.asamblea.gob.sv`, fetched/`pdftotext`-verified
2026-07-22/23; LACAP's own decree page states its own repeal verbatim:
"DERROGADA POR: LEY DE COMPRAS PÚBLICAS. D. L. N° 652..."):

- `src/marketentry/{facts,governor,phase,sim,operation,registry,store,
  marketentryllm}.cljc` -- the actor. `facts.cljc` cites Ley de Compras
  Públicas (D.L. 652) and its Autoridad Rectora, DINAC, which has its
  OWN Ley de Creación (D.L. 653, issued the same day/Diario Oficial
  edition). COMPRASAL remains the e-procurement portal's name under the
  new law (Art. 10); RUPES (Registro Único de Proveedores del Estado,
  Art. 12) is the mandatory supplier registry. Contracting-method value
  tiers are pegged to a FLOATING threshold (240 salarios mínimos
  mensuales del sector comercio vigente, Arts. 39/40) -- this iteration
  disclosed, rather than fabricated, that it could not independently
  confirm today's dollar value of that wage-indexed figure.
  `governor.cljc`'s flagship check independently recomputes whether a
  foreign-legal-entity bidder actually satisfies **Ley de Compras
  Públicas Art. 24 literal f)**: legal capacity to offer/contract bars
  a foreign entity that is not validly constituted under its own
  country's law OR has not complied with the Salvadoran legislation
  applicable to its operation -- traced to **Código de Comercio Arts.
  358-360** (foreign companies must fix domicile/establish a sucursal,
  registering at the Registro de Comercio). This is a SELF-ATTESTED,
  COMPOUND NEGATIVE ELIGIBILITY CRITERION with a nullity consequence --
  a shape genuinely different from every other iso3166 sibling's (no
  separate third-party certifying authority is involved, unlike
  Nicaragua's Comisión de Verificación de Proveedores del Estado).
- `src/statute/facts.cljc` -- general-law catalog: Ley de Compras
  Públicas itself (also catalogued here as an ongoing compliance
  statute, not just a market-entry gate); Código de Comercio (D.L. 671,
  1970) -- Registro de Comercio business registration, dependent on the
  Centro Nacional de Registros (CNR); Código Tributario (D.L. 230, 2000,
  Art. 86/87 -- NIT tax registration); Código de Trabajo (D.L. 15, 1972
  -- this iteration also independently verified Art. 7's real
  90%-Salvadoran-workforce quota with a discretionary MTPS technical
  exception, documented but not built into the flagship check); Ley de
  Inversiones (D.L. 732, 1999, creates the Oficina Nacional de
  Inversiones -- ONI, a REGISTRATION office under the Ministerio de
  Economía); and the SEPARATE Ley de Creación de PROESA (D.L. 663,
  2014, a PROMOTION institution attached to the Presidencia -- this
  iteration independently discovered and confirmed PROESA and ONI are
  two DIFFERENT bodies under two DIFFERENT laws, a genuinely useful
  correction of a plausible assumption); Ley de Integración Monetaria
  (D.L. 201, 2000 -- El Salvador's 2001 dollarization, verified
  directly); and the Ley Bitcoin (D.L. 57, 2021, as reformed by D.L.
  199, 2025) -- this iteration verified that current law makes Bitcoin
  merchant acceptance explicitly VOLUNTARY (Art. 1, as reformed), so it
  deliberately did NOT build a governor check on a mandatory-acceptance
  obligation that does not currently exist.

Every citation is curl/`pdftotext`-verified against an official source
(`www.asamblea.gob.sv`, `www.mh.gob.sv`) -- `www.cnr.gob.sv` returned an
Incapsula bot-detection challenge on every attempt and was NOT bypassed
(per this session's hard safety rule); CNR's role was instead
independently confirmed from the Código de Comercio's own text and the
Ley de Compras Públicas' own text. `www.proesa.gob.sv` connection-timed-
out on every attempt; PROESA's legal basis was confirmed entirely from
its own creation law's text instead. All gaps are disclosed in the
namespace docstrings, never concealed.

## Culture catalog

Alongside the market-entry / statute catalogs, this repo carries a
**country-level regional-culture catalog** (ADR-2607171400 addendum 2,
`cloud-itonami-municipality-culture-catalog` Wave 1, in
`com-junkawasaki/root`) — national dishes, protected products, beverages,
crafts, festivals and heritage sites for El Salvador:

- `src/culture/facts.cljc` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring `statute.facts`).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.
