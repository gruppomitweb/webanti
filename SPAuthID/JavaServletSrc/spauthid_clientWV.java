public class spauthid_clientWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public double w_usercode;
  public String w_publickey;
  public String w_callbackuri;
  public double w_CPROWNUM;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public XDCFieldValue[] extendedFields_trs = new XDCFieldValue[]{};
  // array contenente i valori ripetuti dei campi estesi
  public XDCFieldValue[] work_extended = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
}
