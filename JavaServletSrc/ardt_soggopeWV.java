public class ardt_soggopeWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_COLLEG;
  public String w_CODINTER;
  public String w_IDBASE;
  public double w_PRIMO;
  public java.sql.Date w_DATAINI;
  public java.sql.Date w_DATAFINE;
  public String w_TIPOLEG;
  public String w_RUOLO;
  public String w_xRAGSOC;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
  public String opk_CODINTER;
  public String opk_IDBASE;
}
