# Business Model — Republic of El Salvador

## Offer

- DINAC (Dirección Nacional de Compras Públicas, Ley de Creación de la
  DINAC, Decreto Legislativo No. 653) -- public-sector procurement
  under Ley de Compras Públicas (Decreto Legislativo No. 652, Diario
  Oficial No. 43, Tomo 438, 2 de marzo de 2023). Ley de Compras Públicas
  replaced the earlier LACAP (Decreto Legislativo No. 868, 2000).
  COMPRASAL is the electronic backbone/public portal; RUPES is the
  mandatory national supplier registry (see `src/marketentry/facts.cljk`)
- Registro de Comercio (Código de Comercio, Decreto Legislativo No. 671,
  dependency of the Centro Nacional de Registros -- CNR) business
  registration -- required for legal effect of the escritura social
  (Art. 111)
- NIT (Número de Identificación Tributaria) tax registration (Código
  Tributario, Decreto Legislativo No. 230, Art. 86/87, Ministerio de
  Hacienda)
- Foreign-entity eligibility gate (flagship check) -- bars a filing
  from a foreign legal entity that is not validly constituted under its
  own country's law, or has not complied with the Salvadoran
  legislation applicable to its operation (Ley de Compras Públicas Art.
  24 literal f; Código de Comercio Arts. 358-360 domicile/sucursal +
  Registro de Comercio registration)
- value-tiered contracting methods (Licitación Competitiva/Comparación
  de Precios/Contratación Directa/Baja Cuantía)

## Trust Controls

- Any actual DINAC/COMPRASAL filing or Registro de Comercio inscription
  requires Market-Entry Compliance Governor clearance and always
  escalates to human sign-off.
- A false or fabricated regulatory-requirement claim is a HARD hold.
- `:filing/submit` never automated
