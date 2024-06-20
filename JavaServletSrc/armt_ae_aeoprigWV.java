public class armt_ae_aeoprigWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_RAPPORTO;
  public String w_COINT;
  public String w_TIPOAG;
  public String w_IDBASE;
  //   variabile per il progressivo
  public String op_IDBASE;
  public String w_CONNESINT;
  public java.sql.Date w_ADATA;
  public java.sql.Date w_ADATARET;
  public double w_ASPEDITO;
  public String w_AFILE;
  public String w_APROG;
  public String w_AOLDPROG;
  public String w_AOLDFILE;
  public double w_CSPEDITO;
  public String w_CPROG;
  public String w_COLDPROG;
  public String w_CFILE;
  public String w_COLDFILE;
  public String w_IDRIF;
  public java.sql.Date w_ADTPRE;
  public java.sql.Date w_CDTPRE;
  public java.sql.Date w_CDATA;
  public java.sql.Date w_CDATARET;
  public String w_NOCODFISC;
  public String w_IDESITO;
  public java.sql.Date w_DATESITO;
  public double w_PROGOPX;
  //   variabile per il progressivo
  public double op_PROGOPX;
  public double w_RSPEDITO;
  public String w_xragsoc;
  public java.sql.Date w_dtcanc;
  public double w_spcanc;
  public String w_filecanc;
  public String w_idcanc;
  public double w_xcfestero;
  public String w_desctrap;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public String o_IDBASE;
  public String op_codazi;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
