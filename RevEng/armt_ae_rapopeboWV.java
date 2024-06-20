public class armt_ae_rapopeboWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_CODINTER;
  public String w_CODDIPE;
  public String w_RAPPORTO;
  public java.sql.Date w_DATAOPE;
  public java.sql.Date w_DATAREG;
  public String w_TIPOOPRAP;
  public String w_CONNESOPER;
  public String w_TIPOLEG;
  public java.sql.Date w_DATARETT;
  public String w_IDBASE;
  //   variabile per il progressivo
  public String op_IDBASE;
  public String w_TIPOINTER;
  public String w_TIPOINF;
  public String w_IDEREG;
  public String w_FLAGRAP;
  public String w_OPRAP;
  public String w_STATOREG;
  public String w_OPERAZMOD;
  public String w_OPERATORE;
  public String w_AUTOM;
  public String w_DESCCIT;
  public String w_PROVINCIA;
  public String w_CODCAB;
  public String w_NUMPROG;
  //   variabile per il progressivo
  public String op_NUMPROG;
  public String w_FLAGRAP2;
  public String w_FLAGLIRE;
  public double w_PRGIMPINF;
  //   variabile per il progressivo
  public double op_PRGIMPINF;
  public String w_CDATOPE;
  public String w_gIntemediario;
  public String w_xdescrap;
  public String w_xDescDipe;
  public java.sql.Date w_datpaseuro;
  public String w_contdate;
  public String w_xDesReg;
  public String w_tipreg;
  public String w_xRagSoc;
  public double w_sEdit;
  public String w_errmsg;
  public String w_Aggiorna;
  public double w_lancio;
  public String w_VALUTA;
  public double w_tipregn;
  public java.sql.Date w_dataoggi;
  public String w_CITINT;
  public String w_CITDIP;
  public String w_PROVDIP;
  public String w_CABDIP;
  public String w_PROVINT;
  public String w_CABINT;
  // variabili che puntano ai figli
  public ardt_ae_intestboBO ardt_ae_intestbo;
  public String m_cWv_ardt_ae_intestbo;
  public ardt_ae_delegaboBO ardt_ae_delegabo;
  public String m_cWv_ardt_ae_delegabo;
  public ardt_ae_soginfoBO ardt_ae_soginfo;
  public String m_cWv_ardt_ae_soginfo;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public String o_CODINTER;
  public String o_CODDIPE;
  public java.sql.Date o_DATAOPE;
  public String o_CONNESOPER;
  public String o_TIPOLEG;
  public String op_codazi;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
