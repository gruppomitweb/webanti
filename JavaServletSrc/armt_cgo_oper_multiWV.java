public class armt_cgo_oper_multiWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_SNAINUMOPE;
  //   variabile per il progressivo
  public String op_SNAINUMOPE;
  public String w_TIPOGIOCO;
  public String w_VLTPLAT;
  public String w_CGOTIPOPE;
  public String w_CAIDBIGLIETTO;
  public java.sql.Date w_DATAOPE;
  public String w_FLAGCONT;
  public String w_FLAGWALLET;
  public double w_CACODICE;
  public String w_CODANA;
  public String w_CODVOC;
  public String w_CAFLGOPE;
  public String w_SEGNO;
  public double w_TOTLIRE;
  public double w_TOTCONT;
  public double w_IMPWALLET;
  public String w_CODWALLET;
  public String w_CODTRANSZ;
  public String w_CGOFLGVLT;
  public String w_CGOFLGVNP;
  public String w_CC4CIFRE;
  public double w_CCMESSCA;
  public double w_CCANNSCA;
  public String w_IBAN;
  public String w_ASSEGNO;
  public String w_CCDATSCA;
  public double w_CFESTERO;
  public String w_PEP;
  public String w_CODFISC;
  public String w_COGNOME;
  public String w_NOME;
  public String w_NASCOMUN;
  public String w_TIPINTER;
  public String w_SESSO;
  public String w_NASSTATO;
  public java.sql.Date w_DATANASC;
  public String w_PAESE;
  public String w_DESCCIT;
  public String w_PROVINCIA;
  public String w_CAP;
  public String w_DOMICILIO;
  public String w_NUMTEL;
  public String w_FLGDOM;
  public String w_PAESE2;
  public String w_DESCCIT2;
  public String w_PROVINCIA2;
  public String w_CAP2;
  public String w_DOMICILIO2;
  public String w_TIPODOC;
  public String w_NUMDOCUM;
  public java.sql.Date w_DATARILASC;
  public java.sql.Date w_DATAVALI;
  public String w_RDCODAUT;
  public String w_RDLOCAUT;
  public String w_PEPDESCRI;
  public String w_TIPOPERS;
  public String w_RAGSOC;
  public String w_SOTGRUP;
  public String w_RAMOGRUP;
  public String w_SETTSINT;
  public java.sql.Date w_DATAREG;
  public String w_TIPOOPRAP;
  public String w_VALUTA;
  public double w_CAMBIO;
  public String w_CONNESCLI;
  public String w_CONNESBEN;
  public String w_C_RAG;
  public String w_C_CTA;
  public String w_C_PRV;
  public String w_C_CAP;
  public String w_C_CAB;
  public String w_C_IND;
  public String w_C_STA;
  public String w_CODINTER;
  public String w_FLAGFRAZ;
  public String w_COLLEG;
  public String w_CODCAB;
  public String w_ATTIV;
  public String w_AUTRILASC;
  public String w_IDDOCALL;
  public String w_FLGDOCALL;
  public String w_PROFESSIONE;
  public String w_MEZPAGAM;
  public String w_CODDIPE;
  public String w_DESCCITDIP;
  public String w_PROVINCIADIP;
  public String w_CODCABDIP;
  public String w_gIntemediario;
  public String w_gCodDip;
  public String w_gStpDwn;
  public double w_gVLT;
  public double w_gVNP;
  public String w_gChkDate;
  public String w_gGesDoc;
  public String w_gSeekAos;
  public java.sql.Date w_gDataVaria;
  public String w_gFlgDoc;
  public String w_gTipMul;
  public String w_xARDESCRI;
  public double w_xSOGTPGIO;
  public String w_xDEFTPGIO;
  public String w_xEDTTPGIO;
  public String w_xEDTSPGIO;
  public String w_xDEFSPGIO;
  public String w_xFLGPLGIO;
  public String w_FLGPAGAM;
  public String w_FILTROMP;
  public String w_idcitta;
  public String w_idcitta2;
  public String w_dessta;
  public String w_tipsot;
  public String w_STATOREG;
  public String w_IDBASE;
  public String w_NUMPROG;
  public String w_DESCRI;
  public String w_xDescDipe;
  public java.sql.Date w_datpaseuro;
  public String w_xdes1;
  public String w_desccauana;
  public String w_CITINT;
  public String w_CITDIP;
  public String w_PROVDIP;
  public String w_CABDIP;
  public String w_PROVINT;
  public String w_CABINT;
  public String w_xdesccausin;
  public String w_xdesctipatt;
  public String w_MIDBIGLIETTO;
  public String w_MIDBIGLIETTO1;
  public String w_MIDBIGLIETTO2;
  public String w_MIDBIGLIETTO3;
  public String w_MIDBIGLIETTO4;
  public String w_xVPFLGATT;
  public String w_DOC03;
  public String w_DOC04;
  public boolean w_edtdoc;
  public String w_saveddoc;
  public String w_dessta2;
  public double w_xIMPMINTOT;
  public String w_gAzienda;
  public String w_xCGOFLGPROF;
  public String w_TELDIP;
  public String w_CODLOC;
  public String w_ANA_FOUND;
  // variabili che puntano ai figli
  public ardt_cgo_oper_multiBO ardt_cgo_oper_multi;
  public String m_cWv_ardt_cgo_oper_multi;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public String o_TIPOGIOCO;
  public String o_CGOTIPOPE;
  public java.sql.Date o_DATAOPE;
  public String o_FLAGCONT;
  public String o_FLAGWALLET;
  public double o_CACODICE;
  public String o_CODANA;
  public String o_CODVOC;
  public String o_SEGNO;
  public double o_TOTLIRE;
  public double o_TOTCONT;
  public double o_IMPWALLET;
  public String o_CGOFLGVLT;
  public String o_FLGPAGAM;
  public String o_FILTROMP;
  public String o_COGNOME;
  public String o_NOME;
  public String o_NASCOMUN;
  public String o_TIPINTER;
  public String o_NASSTATO;
  public String o_PAESE;
  public String o_idcitta;
  public String o_PAESE2;
  public String o_idcitta2;
  public java.sql.Date o_DATARILASC;
  public java.sql.Date o_DATAVALI;
  public String o_RDCODAUT;
  public String o_RDLOCAUT;
  public String o_SOTGRUP;
  public String o_TIPOOPRAP;
  public String o_CONNESBEN;
  public String o_C_CTA;
  public String o_CODINTER;
  public String o_COLLEG;
  public String o_ATTIV;
  public String o_MEZPAGAM;
  public String o_CODDIPE;
  public String op_codazi;
  // variabile contenente i valori per i campi aggiunti e le proprietÓ dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
