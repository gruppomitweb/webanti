public class ardt_titopersWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_CONTITO;
  public String w_CONPERS;
  public java.sql.Date w_DATAINI;
  public java.sql.Date w_DATAFINE;
  public String w_NOTEBREV;
  public String w_xragsoc;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le propriet� dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
}
