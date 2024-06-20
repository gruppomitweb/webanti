public class armt_tipregWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_CODICE;
  public String w_DES1;
  public String w_DES2;
  public String w_TIPREG;
  public String w_OPERAZIO;
  public java.sql.Date w_DATAINI;
  public java.sql.Date w_DATAFINE;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
