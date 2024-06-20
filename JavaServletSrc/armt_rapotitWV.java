public class armt_rapotitWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_CODINTER;
  public String w_CODDIPE;
  public String w_IDBASE;
  //   variabile per il progressivo
  public String op_IDBASE;
  public String w_TIPOINTER;
  public String w_TIPOINF;
  public String w_IDEREG;
  public String w_FLAGRAP;
  public String w_OPRAP;
  public String w_OPERATORE;
  public String w_AUTOM;
  public String w_DESCCIT;
  public String w_PROVINCIA;
  public String w_CODCAB;
  public String w_FLAGRAP2;
  public String w_FLAGLIRE;
  public double w_PRGIMPTIT;
  //   variabile per il progressivo
  public double op_PRGIMPTIT;
  public String w_CONNESCLI;
  public java.sql.Date w_DATAOPE;
  public java.sql.Date w_DATAREG;
  public String w_CDATOPE;
  public String w_TIPOOPRAP;
  public String w_CONNESOPER;
  public String w_TIPOLEG;
  public String w_RAPPORTO;
  public String w_STATOREG;
  public String w_NUMPROG;
  //   variabile per il progressivo
  public String op_NUMPROG;
  public String w_DESCINTER;
  public String w_COLLEG;
  public String w_OPERAZMOD;
  public String w_CDATREG;
  public java.sql.Date w_DATARETT;
  public String w_flgpf;
  public String w_flgpg;
  public String w_gCodDip;
  public String w_gIntemediario;
  public String w_xdescrap;
  public String w_xDescDipe;
  public java.sql.Date w_datpaseuro;
  public String w_gChkDate;
  public String w_xDesReg;
  public String w_xRagSoc;
  public double w_sEdit;
  public String w_errmsg;
  public String w_Aggiorna;
  public double w_lancio;
  public String w_VALUTA;
  public String w_gSblocco;
  public String w_tipreg;
  public double w_tipregn;
  public java.sql.Date w_dataoggi;
  public String w_gStatus;
  public java.sql.Date w_gDataVaria;
  public String w_CITINT;
  public String w_CITDIP;
  public String w_PROVDIP;
  public String w_CABDIP;
  public String w_PROVINT;
  public String w_CABINT;
  public String w_xRagSocCli;
  public String w_filtro;
  public String w_SESSO;
  // variabili che puntano ai figli
  public ardt_intestitBO ardt_intestit;
  public String m_cWv_ardt_intestit;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public String o_flgpf;
  public String o_CODINTER;
  public String o_CODDIPE;
  public String o_filtro;
  public String o_CONNESCLI;
  public java.sql.Date o_DATAOPE;
  public java.sql.Date o_DATAREG;
  public String o_CDATOPE;
  public String o_TIPOOPRAP;
  public String o_CONNESOPER;
  public String op_codazi;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
