public class armt_tbprcbckWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public double w_PBCODICE;
  //   variabile per il progressivo
  public double op_PBCODICE;
  public String w_PBDESCRI;
  public String w_PBNOTE;
  public String w_PBATTIVO;
  public String w_PBNOMPRC;
  public String w_PBROUTINE;
  public String w_PBTIMEXP;
  public boolean w_PBFORZAESEC;
  public java.sql.Timestamp w_PBLASTSTART;
  public java.sql.Timestamp w_PBLASTEND;
  // variabili che puntano ai figli
  public dt_tbprcbck_paramBO dt_tbprcbck_param;
  public String m_cWv_dt_tbprcbck_param;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  public String op_codazi;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
