public class ardt_rischiodipWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_CODDIP;
  public String w_TIPOANALISI;
  public java.sql.Date w_DATAINI;
  public java.sql.Date w_DATFIN;
  public String w_RISGLOB;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
  public String opk_TIPOANALISI;
  public java.sql.Date opk_DATAINI;
}
