public class armt_decodestatiWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_account;
  public String w_CODSTA;
  public String w_DESCRI;
  public String w_SIGLA;
  public String w_ISO;
  public String w_ISO2;
  public String w_IDTBLS;
  public String w_IDBASE;
  public double w_id;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
