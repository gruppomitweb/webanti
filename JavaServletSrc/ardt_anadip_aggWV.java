public class ardt_anadip_aggWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_CODDIPE;
  public double w_ANNORIF;
  public double w_MESERIF;
  public java.sql.Date w_DATAINI;
  public java.sql.Date w_DATAFINE;
  public double w_ANOMAGE;
  public double w_SOSCLIENTI;
  public double w_SOSAGENZIA;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
  public double opk_ANNORIF;
  public double opk_MESERIF;
}
