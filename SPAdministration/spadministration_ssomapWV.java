public class spadministration_ssomapWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_ssoid;
  public double w_userid;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le propriet� dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}