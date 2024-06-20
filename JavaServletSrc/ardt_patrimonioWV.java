public class ardt_patrimonioWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_CONNES;
  public String w_CODICE;
  public double w_IMPEFF;
  public double w_RISCHIO;
  public double w_ANNO;
  public String w_IDBASE;
  public String w_xDESCRI;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
  public double opk_ANNO;
}
