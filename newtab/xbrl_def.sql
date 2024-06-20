DELETE FROM xbrl_def WHERE 1=1;
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750MQ7YX', 'NB', NULL, NULL, 'PROLOGO                                 ', 'yuirmumvfq', '<xbrli:xbrl xmlns:t-SARA="http://www.bancaditalia.it/uif/xbrlTaxonomy" xmlns:d-SETTORIZSINT="http://www.bancaditalia.it/uif/domain/SETTORIZSINT" xmlns:link="http://www.xbrl.org/2003/linkbase" xmlns:p-common="http://www.bancaditalia.it/uif/common" xmlns:p-SARA="http://www.bancaditalia.it/uif/xbrlTaxonomy/p-SARA" xmlns:d-TIPOSEGNALANTE="http://www.bancaditalia.it/uif/domain/TIPOSEGNALANTE" xmlns:d-ty="http://www.bancaditalia.it/uif/domain/ty" xmlns:ref="http://www.xbrl.org/2004/ref" xmlns:d-VALUTASARA="http://www.bancaditalia.it/uif/domain/VALUTASARA" xmlns:d-DAREAVERE="http://www.bancaditalia.it/uif/domain/DAREAVERE" xmlns:d-CAUSALEAGGREGATA="http://www.bancaditalia.it/uif/domain/CAUSALEAGGREGATA" xmlns:xbrldi="http://xbrl.org/2006/xbrldi" xmlns:xbrli="http://www.xbrl.org/2003/instance" xmlns:iso4217="http://www.xbrl.org/2003/iso4217" xmlns:d-util="http://www.bancaditalia.it/uif/domain/util" xmlns:xlink="http://www.w3.org/1999/xlink">');
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750NJUM0', 'NB', NULL, NULL, 'TASSONOMIA                              ', 'xkszuqkrxp', '<link:schemaRef xlink:type="simple" xlink:href="t-SARA-2014-01-01.xsd"/>');
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750R01HM', 'NB', NULL, NULL, 'CONTESTO_BONIFICIALTRIITA               ', 'lsgtitabxv', '<xbrli:context id="CTX_F_SARA_BONIFICIALTRIITA##NITA##">
  <xbrli:entity><xbrli:identifier scheme="http://www.bancaditalia.it/uif">##PIVAINTER##</xbrli:identifier></xbrli:entity>
  <xbrli:period><xbrli:instant>##FINE_PERIODO##</xbrli:instant></xbrli:period>
  <xbrli:scenario>
    <xbrldi:explicitMember dimension="d-TIPOSEGNALANTE:TIPO_SEGNALANTE">d-TIPOSEGNALANTE:TIPOSEGNALANTE_##TIPINTER##</xbrldi:explicitMember>
    <xbrldi:typedMember dimension="d-ty:CODICE_INTERNO_DIP"><d-ty:AUTODESCRIPTIVE>##CODDIP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_DIP"><d-ty:AUTODESCRIPTIVE>##CABDIP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:PAESE_RES_CLIENTE"><d-ty:AUTODESCRIPTIVE>##PAESECLI##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_RES_CLIENTE"><d-ty:AUTODESCRIPTIVE>##CABCLI##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:explicitMember dimension="d-CAUSALEAGGREGATA:CAUSALE_AGGREGATA">d-CAUSALEAGGREGATA:CAUSALEAGGREGATA_##CODVOC##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-VALUTASARA:CODICE_VALUTA">d-VALUTASARA:VALUTASARA_##VALUTA##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-DAREAVERE:SEGNO_MONETARIO">d-DAREAVERE:DAREAVERE_##SEGNO##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-SETTORIZSINT:SETTORIZ_SINT_ECON">d-SETTORIZSINT:SETTORIZSINT_##SETTSINT##</xbrldi:explicitMember>
    <xbrldi:typedMember dimension="d-ty:PAESE_CONTROPARTE"><d-ty:AUTODESCRIPTIVE>##PAESECP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_CONTROPARTE"><d-ty:AUTODESCRIPTIVE>##CABCP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
   	<xbrldi:typedMember dimension="d-ty:PAESE_INTERM_CTRP"><d-ty:AUTODESCRIPTIVE>##PAESEICP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_INTERM_CTRP"><d-ty:AUTODESCRIPTIVE>##CABICP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
  </xbrli:scenario>
</xbrli:context>');
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750R5DRK', 'NB', NULL, NULL, 'CONTESTO_BONIFICIALTRIESTERI            ', 'lxhokvielo', '<xbrli:context id="CTX_F_SARA_BONIFICIALTRIESTERI##NEXT##">
  <xbrli:entity><xbrli:identifier scheme="http://www.bancaditalia.it/uif">##PIVAINTER##</xbrli:identifier></xbrli:entity>
  <xbrli:period><xbrli:instant>##FINE_PERIODO##</xbrli:instant></xbrli:period>
  <xbrli:scenario>
    <xbrldi:explicitMember dimension="d-TIPOSEGNALANTE:TIPO_SEGNALANTE">d-TIPOSEGNALANTE:TIPOSEGNALANTE_##TIPINTER##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-CAUSALEAGGREGATA:CAUSALE_AGGREGATA">d-CAUSALEAGGREGATA:CAUSALEAGGREGATA_##CODVOC##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-VALUTASARA:CODICE_VALUTA">d-VALUTASARA:VALUTASARA_##VALUTA##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-DAREAVERE:SEGNO_MONETARIO">d-DAREAVERE:DAREAVERE_##SEGNO##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-SETTORIZSINT:SETTORIZ_SINT_ECON">d-SETTORIZSINT:SETTORIZSINT_##SETTSINT##</xbrldi:explicitMember>
    <xbrldi:typedMember dimension="d-ty:PAESE_CONTROPARTE"><d-ty:AUTODESCRIPTIVE>##PAESECP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:PAESE_INTERM_CTRP"><d-ty:AUTODESCRIPTIVE>##PAESEICP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:PAESE_RES_CLIENTE"><d-ty:AUTODESCRIPTIVE>##PAESECLI##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_CONTROPARTE"><d-ty:AUTODESCRIPTIVE>##CABCP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:CODICE_INTERNO_DIP"><d-ty:AUTODESCRIPTIVE>##CODDIP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_DIP"><d-ty:AUTODESCRIPTIVE>##CABDIP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_RES_CLIENTE"><d-ty:AUTODESCRIPTIVE>##CABCLI##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
  </xbrli:scenario>
</xbrli:context>');
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750TRC71', 'NB', NULL, NULL, 'CONTESTO_ALTREOPERAZIONIALTRI           ', 'cipviqaczl', '<xbrli:context id="CTX_F_SARA_ALTREOPERAZIONIALTRI##NALT##">
  <xbrli:entity><xbrli:identifier scheme="http://www.bancaditalia.it/uif">##PIVAINTER##</xbrli:identifier></xbrli:entity>
  <xbrli:period><xbrli:instant>##FINE_PERIODO##</xbrli:instant></xbrli:period>
  <xbrli:scenario>
    <xbrldi:explicitMember dimension="d-TIPOSEGNALANTE:TIPO_SEGNALANTE">d-TIPOSEGNALANTE:TIPOSEGNALANTE_##TIPINTER##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-CAUSALEAGGREGATA:CAUSALE_AGGREGATA">d-CAUSALEAGGREGATA:CAUSALEAGGREGATA_##CODVOC##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-VALUTASARA:CODICE_VALUTA">d-VALUTASARA:VALUTASARA_##VALUTA##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-DAREAVERE:SEGNO_MONETARIO">d-DAREAVERE:DAREAVERE_##SEGNO##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-SETTORIZSINT:SETTORIZ_SINT_ECON">d-SETTORIZSINT:SETTORIZSINT_##SETTSINT##</xbrldi:explicitMember>
    <xbrldi:typedMember dimension="d-ty:PAESE_RES_CLIENTE"><d-ty:AUTODESCRIPTIVE>##PAESECLI##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:CODICE_INTERNO_DIP"><d-ty:AUTODESCRIPTIVE>##CODDIP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_DIP"><d-ty:AUTODESCRIPTIVE>##CABDIP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_RES_CLIENTE"><d-ty:AUTODESCRIPTIVE>##CABCLI##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
  </xbrli:scenario>
</xbrli:context>');
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750R01H2', 'NB', NULL, NULL, 'CONTESTO_BONIFICIBANCHE                 ', 'lsgtitabxv', '<xbrli:context id="CTX_F_SARA_BONIFICIBANCHE##NITA##">
  <xbrli:entity><xbrli:identifier scheme="http://www.bancaditalia.it/uif">##PIVAINTER##</xbrli:identifier></xbrli:entity>
  <xbrli:period><xbrli:instant>##FINE_PERIODO##</xbrli:instant></xbrli:period>
  <xbrli:scenario>
    <xbrldi:explicitMember dimension="d-TIPOSEGNALANTE:TIPO_SEGNALANTE">d-TIPOSEGNALANTE:TIPOSEGNALANTE_##TIPINTER##</xbrldi:explicitMember>
    <xbrldi:typedMember dimension="d-ty:CODICE_INTERNO_DIP"><d-ty:AUTODESCRIPTIVE>##CODDIP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_DIP"><d-ty:AUTODESCRIPTIVE>##CABDIP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:PAESE_RES_CLIENTE"><d-ty:AUTODESCRIPTIVE>##PAESECLI##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_RES_CLIENTE"><d-ty:AUTODESCRIPTIVE>##CABCLI##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:explicitMember dimension="d-CAUSALEAGGREGATA:CAUSALE_AGGREGATA">d-CAUSALEAGGREGATA:CAUSALEAGGREGATA_##CODVOC##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-VALUTASARA:CODICE_VALUTA">d-VALUTASARA:VALUTASARA_##VALUTA##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-DAREAVERE:SEGNO_MONETARIO">d-DAREAVERE:DAREAVERE_##SEGNO##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-SETTORIZSINT:SETTORIZ_SINT_ECON">d-SETTORIZSINT:SETTORIZSINT_##SETTSINT##</xbrldi:explicitMember>
    <xbrldi:typedMember dimension="d-ty:PAESE_CONTROPARTE"><d-ty:AUTODESCRIPTIVE>##PAESECP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_CONTROPARTE"><d-ty:AUTODESCRIPTIVE>##CABCP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
   	<xbrldi:typedMember dimension="d-ty:PAESE_INTERM_CTRP"><d-ty:AUTODESCRIPTIVE>##PAESEICP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_INTERM_CTRP"><d-ty:AUTODESCRIPTIVE>##CABICP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
  </xbrli:scenario>
</xbrli:context>');
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750R5DR2', 'NB', NULL, NULL, 'CONTESTO_BONIFICIESTERI                 ', 'lxhokvielo', '<xbrli:context id="CTX_F_SARA_BONIFICIESTERI##NEXT##">
  <xbrli:entity><xbrli:identifier scheme="http://www.bancaditalia.it/uif">##PIVAINTER##</xbrli:identifier></xbrli:entity>
  <xbrli:period><xbrli:instant>##FINE_PERIODO##</xbrli:instant></xbrli:period>
  <xbrli:scenario>
    <xbrldi:explicitMember dimension="d-TIPOSEGNALANTE:TIPO_SEGNALANTE">d-TIPOSEGNALANTE:TIPOSEGNALANTE_##TIPINTER##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-CAUSALEAGGREGATA:CAUSALE_AGGREGATA">d-CAUSALEAGGREGATA:CAUSALEAGGREGATA_##CODVOC##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-VALUTASARA:CODICE_VALUTA">d-VALUTASARA:VALUTASARA_##VALUTA##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-DAREAVERE:SEGNO_MONETARIO">d-DAREAVERE:DAREAVERE_##SEGNO##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-SETTORIZSINT:SETTORIZ_SINT_ECON">d-SETTORIZSINT:SETTORIZSINT_##SETTSINT##</xbrldi:explicitMember>
    <xbrldi:typedMember dimension="d-ty:PAESE_CONTROPARTE"><d-ty:AUTODESCRIPTIVE>##PAESECP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:PAESE_INTERM_CTRP"><d-ty:AUTODESCRIPTIVE>##PAESEICP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:PAESE_RES_CLIENTE"><d-ty:AUTODESCRIPTIVE>##PAESECLI##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_CONTROPARTE"><d-ty:AUTODESCRIPTIVE>##CABCP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:CODICE_INTERNO_DIP"><d-ty:AUTODESCRIPTIVE>##CODDIP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_DIP"><d-ty:AUTODESCRIPTIVE>##CABDIP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_RES_CLIENTE"><d-ty:AUTODESCRIPTIVE>##CABCLI##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
  </xbrli:scenario>
</xbrli:context>');
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750TRC72', 'NB', NULL, NULL, 'CONTESTO_ALTREOPERAZIONI                ', 'cipviqaczl', '<xbrli:context id="CTX_F_SARA_ALTREOPERAZIONI##NALT##">
  <xbrli:entity><xbrli:identifier scheme="http://www.bancaditalia.it/uif">##PIVAINTER##</xbrli:identifier></xbrli:entity>
  <xbrli:period><xbrli:instant>##FINE_PERIODO##</xbrli:instant></xbrli:period>
  <xbrli:scenario>
    <xbrldi:explicitMember dimension="d-TIPOSEGNALANTE:TIPO_SEGNALANTE">d-TIPOSEGNALANTE:TIPOSEGNALANTE_##TIPINTER##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-CAUSALEAGGREGATA:CAUSALE_AGGREGATA">d-CAUSALEAGGREGATA:CAUSALEAGGREGATA_##CODVOC##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-VALUTASARA:CODICE_VALUTA">d-VALUTASARA:VALUTASARA_##VALUTA##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-DAREAVERE:SEGNO_MONETARIO">d-DAREAVERE:DAREAVERE_##SEGNO##</xbrldi:explicitMember>
    <xbrldi:explicitMember dimension="d-SETTORIZSINT:SETTORIZ_SINT_ECON">d-SETTORIZSINT:SETTORIZSINT_##SETTSINT##</xbrldi:explicitMember>
    <xbrldi:typedMember dimension="d-ty:PAESE_RES_CLIENTE"><d-ty:AUTODESCRIPTIVE>##PAESECLI##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:CODICE_INTERNO_DIP"><d-ty:AUTODESCRIPTIVE>##CODDIP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_DIP"><d-ty:AUTODESCRIPTIVE>##CABDIP##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
    <xbrldi:typedMember dimension="d-ty:COMUNE_RES_CLIENTE"><d-ty:AUTODESCRIPTIVE>##CABCLI##</d-ty:AUTODESCRIPTIVE></xbrldi:typedMember>
  </xbrli:scenario>
</xbrli:context>');
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750V9JQJ', 'NB', NULL, NULL, 'UNITA                                   ', 'xtpgxiyzms', '<xbrli:context id="CTX_F_SARA_PERIOD">
    <xbrli:entity><xbrli:identifier scheme="http://www.bancaditalia.it/uif">##PIVAINTER##</xbrli:identifier></xbrli:entity>
    <xbrli:period><xbrli:instant>##FINE_PERIODO##</xbrli:instant></xbrli:period>
  </xbrli:context>
  <xbrli:unit id="EUR"><xbrli:measure>iso4217:EUR</xbrli:measure></xbrli:unit>
  <xbrli:unit id="PURE"><xbrli:measure>xbrli:pure</xbrli:measure></xbrli:unit>');
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750VA4OI', 'NB', NULL, NULL, 'TIMEPROD                                ', 'mdfcabqafo', '<p-common:TIMEPROD contextRef="CTX_F_SARA_PERIOD">##DATAPROD##T##ORAPROD##</p-common:TIMEPROD>');
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750WFD9M', 'NB', NULL, NULL, 'FATTI_BONIFICIALTRIITA                  ', 'rhmqpbvijn', '<p-SARA:IMPORTO_TOT_SARA_BONIFICIALTRIITA decimals="0" contextRef="CTX_F_SARA_BONIFICIALTRIITA##NITA##" unitRef="EUR">##TOTIMP##</p-SARA:IMPORTO_TOT_SARA_BONIFICIALTRIITA>
  <p-SARA:NUMERO_TOT_OPER_SARA_BONIFICIALTRIITA decimals="0" contextRef="CTX_F_SARA_BONIFICIALTRIITA##NITA##" unitRef="PURE">##TOTOPE##</p-SARA:NUMERO_TOT_OPER_SARA_BONIFICIALTRIITA>
  <p-SARA:IMPORTO_TOT_CONTANTI_SARA_BONIFICIALTRIITA decimals="0" contextRef="CTX_F_SARA_BONIFICIALTRIITA##NITA##" unitRef="EUR">##TOTCON##</p-SARA:IMPORTO_TOT_CONTANTI_SARA_BONIFICIALTRIITA>
  <p-SARA:NUMERO_OPER_CONT_SARA_BONIFICIALTRIITA decimals="0" contextRef="CTX_F_SARA_BONIFICIALTRIITA##NITA##" unitRef="PURE">##OPECON##</p-SARA:NUMERO_OPER_CONT_SARA_BONIFICIALTRIITA>');
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750WIT6F', 'NB', NULL, NULL, 'FATTI_BONIFICIALTRIESTERI               ', 'zwvhuintba', '<p-SARA:IMPORTO_TOT_SARA_BONIFICIALTRIESTERI decimals="0" contextRef="CTX_F_SARA_BONIFICIALTRIESTERI##NEXT##" unitRef="EUR">##TOTIMP##</p-SARA:IMPORTO_TOT_SARA_BONIFICIALTRIESTERI>
  <p-SARA:NUMERO_TOT_OPER_SARA_BONIFICIALTRIESTERI decimals="0" contextRef="CTX_F_SARA_BONIFICIALTRIESTERI##NEXT##" unitRef="PURE">##TOTOPE##</p-SARA:NUMERO_TOT_OPER_SARA_BONIFICIALTRIESTERI>
  <p-SARA:IMPORTO_TOT_CONTANTI_SARA_BONIFICIALTRIESTERI decimals="0" contextRef="CTX_F_SARA_BONIFICIALTRIESTERI##NEXT##" unitRef="EUR">##TOTCON##</p-SARA:IMPORTO_TOT_CONTANTI_SARA_BONIFICIALTRIESTERI>
  <p-SARA:NUMERO_OPER_CONT_SARA_BONIFICIALTRIESTERI decimals="0" contextRef="CTX_F_SARA_BONIFICIALTRIESTERI##NEXT##" unitRef="PURE">##OPECON##</p-SARA:NUMERO_OPER_CONT_SARA_BONIFICIALTRIESTERI>');
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750WPEZ1', 'NB', NULL, NULL, 'FATTI_ALTREOPERAZIONIALTRI              ', 'wxkistranm', '<p-SARA:IMPORTO_TOT_SARA_ALTREOPERAZIONIALTRI decimals="0" contextRef="CTX_F_SARA_ALTREOPERAZIONIALTRI##NALT##" unitRef="EUR">##TOTIMP##</p-SARA:IMPORTO_TOT_SARA_ALTREOPERAZIONIALTRI>
  <p-SARA:NUMERO_TOT_OPER_SARA_ALTREOPERAZIONIALTRI decimals="0" contextRef="CTX_F_SARA_ALTREOPERAZIONIALTRI##NALT##" unitRef="PURE">##TOTOPE##</p-SARA:NUMERO_TOT_OPER_SARA_ALTREOPERAZIONIALTRI>
  <p-SARA:IMPORTO_TOT_CONTANTI_SARA_ALTREOPERAZIONIALTRI decimals="0" contextRef="CTX_F_SARA_ALTREOPERAZIONIALTRI##NALT##" unitRef="EUR">##TOTCON##</p-SARA:IMPORTO_TOT_CONTANTI_SARA_ALTREOPERAZIONIALTRI>
  <p-SARA:NUMERO_OPER_CONT_SARA_ALTREOPERAZIONIALTRI decimals="0" contextRef="CTX_F_SARA_ALTREOPERAZIONIALTRI##NALT##" unitRef="PURE">##OPECON##</p-SARA:NUMERO_OPER_CONT_SARA_ALTREOPERAZIONIALTRI>');
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750WFD93', 'NB', NULL, NULL, 'FATTI_BONIFICIBANCHE                    ', 'rhmqpbvijn', '<p-SARA:IMPORTO_TOT_SARA_BONIFICIBANCHE decimals="0" contextRef="CTX_F_SARA_BONIFICIBANCHE##NITA##" unitRef="EUR">##TOTIMP##</p-SARA:IMPORTO_TOT_SARA_BONIFICIBANCHE>
  <p-SARA:NUMERO_TOT_OPER_SARA_BONIFICIBANCHE decimals="0" contextRef="CTX_F_SARA_BONIFICIBANCHE##NITA##" unitRef="PURE">##TOTOPE##</p-SARA:NUMERO_TOT_OPER_SARA_BONIFICIBANCHE>
  <p-SARA:IMPORTO_TOT_CONTANTI_SARA_BONIFICIBANCHE decimals="0" contextRef="CTX_F_SARA_BONIFICIBANCHE##NITA##" unitRef="EUR">##TOTCON##</p-SARA:IMPORTO_TOT_CONTANTI_SARA_BONIFICIBANCHE>
  <p-SARA:NUMERO_OPER_CONT_SARA_BONIFICIBANCHE decimals="0" contextRef="CTX_F_SARA_BONIFICIBANCHE##NITA##" unitRef="PURE">##OPECON##</p-SARA:NUMERO_OPER_CONT_SARA_BONIFICIBANCHE>');
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750WIT63', 'NB', NULL, NULL, 'FATTI_BONIFICIESTERI                    ', 'zwvhuintba', '<p-SARA:IMPORTO_TOT_SARA_BONIFICIESTERI decimals="0" contextRef="CTX_F_SARA_BONIFICIESTERI##NEXT##" unitRef="EUR">##TOTIMP##</p-SARA:IMPORTO_TOT_SARA_BONIFICIESTERI>
  <p-SARA:NUMERO_TOT_OPER_SARA_BONIFICIESTERI decimals="0" contextRef="CTX_F_SARA_BONIFICIESTERI##NEXT##" unitRef="PURE">##TOTOPE##</p-SARA:NUMERO_TOT_OPER_SARA_BONIFICIESTERI>
  <p-SARA:IMPORTO_TOT_CONTANTI_SARA_BONIFICIESTERI decimals="0" contextRef="CTX_F_SARA_BONIFICIESTERI##NEXT##" unitRef="EUR">##TOTCON##</p-SARA:IMPORTO_TOT_CONTANTI_SARA_BONIFICIESTERI>
  <p-SARA:NUMERO_OPER_CONT_SARA_BONIFICIESTERI decimals="0" contextRef="CTX_F_SARA_BONIFICIESTERI##NEXT##" unitRef="PURE">##OPECON##</p-SARA:NUMERO_OPER_CONT_SARA_BONIFICIESTERI>');
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750WPEZ3', 'NB', NULL, NULL, 'FATTI_ALTREOPERAZIONI                   ', 'wxkistranm', '<p-SARA:IMPORTO_TOT_SARA_ALTREOPERAZIONI decimals="0" contextRef="CTX_F_SARA_ALTREOPERAZIONI##NALT##" unitRef="EUR">##TOTIMP##</p-SARA:IMPORTO_TOT_SARA_ALTREOPERAZIONI>
  <p-SARA:NUMERO_TOT_OPER_SARA_ALTREOPERAZIONI decimals="0" contextRef="CTX_F_SARA_ALTREOPERAZIONI##NALT##" unitRef="PURE">##TOTOPE##</p-SARA:NUMERO_TOT_OPER_SARA_ALTREOPERAZIONI>
  <p-SARA:IMPORTO_TOT_CONTANTI_SARA_ALTREOPERAZIONI decimals="0" contextRef="CTX_F_SARA_ALTREOPERAZIONI##NALT##" unitRef="EUR">##TOTCON##</p-SARA:IMPORTO_TOT_CONTANTI_SARA_ALTREOPERAZIONI>
  <p-SARA:NUMERO_OPER_CONT_SARA_ALTREOPERAZIONI decimals="0" contextRef="CTX_F_SARA_ALTREOPERAZIONI##NALT##" unitRef="PURE">##OPECON##</p-SARA:NUMERO_OPER_CONT_SARA_ALTREOPERAZIONI>'); 
INSERT INTO xbrl_def(IDBASE, TIPO_INT, DATA_VAL, DATA_VAL_A, SEZIONE, CPCCCHK, XML_TXT) VALUES ('_3750WQ90V', 'NB', NULL, NULL, 'EPILOGO                                 ', 'yknjrtymlm', '</xbrli:xbrl>');
