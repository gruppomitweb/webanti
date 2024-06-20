public class ardt_wutrxchk_casesWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public double w_TRXCODICE;
  public double w_TRXCODCASE;
  public String w_WCNOMCAS;
  public String w_WCDESCRI;
  public String w_WCBEHAVIOR;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
  public double opk_TRXCODCASE;
}
