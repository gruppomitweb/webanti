public class ardt_docautWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_DACODICE;
  public String w_DATIPDOC;
  public String w_xDESCRI;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le propriet� dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
  public String opk_DATIPDOC;
}
