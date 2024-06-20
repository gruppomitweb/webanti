public class armd_anagrappoWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_RAPPORTO;
  public String w_TIPOAG;
  public String w_COINT;
  public String w_RIFANA;
  public String w_CONNESINT;
  public double w_ASPEDITO;
  public java.sql.Date w_ADATA;
  public String w_APROG;
  public String w_AOLDPROG;
  public String w_AFILE;
  public String w_AOLDFILE;
  public java.sql.Date w_ADATARET;
  public double w_CSPEDITO;
  public java.sql.Date w_CDATA;
  public String w_CPROG;
  public String w_COLDPROG;
  public String w_CFILE;
  public String w_COLDFILE;
  public java.sql.Date w_CDATARET;
  public String w_IDRIF;
  public String w_NOCODFISC;
  public String w_IDBASE;
  public double w_CPROWNUM;
  public String w_IDESITO;
  public double w_RSPEDITO;
  public String w_UNIQUECODE;
  public String w_CAB;
  public String w_VALUTA;
  public double w_PROGAER;
  //   variabile per il progressivo
  public double op_PROGAER;
  public double w_PROGAET;
  //   variabile per il progressivo
  public double op_PROGAET;
  public java.sql.Date w_DATESITO;
  public double w_CFESTERO;
  public String w_xragsoc;
  public java.sql.Date w_dtcanc;
  public double w_spcanc;
  public String w_filecanc;
  public String w_idcanc;
  // variabili che puntano ai figli
  public ardt_ae_saldianno_rapBO ardt_ae_saldianno_rap;
  public String m_cWv_ardt_ae_saldianno_rap;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public String o_TIPOAG;
  public String o_IDBASE;
  public String op_codazi;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public XDCFieldValue[] extendedFields_trs = new XDCFieldValue[]{};
  // array contenente i valori ripetuti dei campi estesi
  public XDCFieldValue[] work_extended = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
}
