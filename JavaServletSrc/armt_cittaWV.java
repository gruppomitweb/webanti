public class armt_cittaWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_IDBASE;
  //   variabile per il progressivo
  public String op_IDBASE;
  public String w_CITTA;
  public String w_CAB;
  public String w_PROV;
  public String w_CAP;
  public String w_PKTBSTATI;
  public String w_SIGLA;
  public String w_PREF;
  public String w_IDISTAT;
  public String w_IDREGIO;
  public String w_dessta;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
