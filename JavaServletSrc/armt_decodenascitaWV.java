public class armt_decodenascitaWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public double w_id;
  public String w_account;
  public String w_SIGLA;
  public String w_DESCRI;
  public java.sql.Date w_DATINI;
  public java.sql.Date w_DATFIN;
  public String w_PROVINCIA;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
