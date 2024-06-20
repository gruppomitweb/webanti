public class ardt_xerzistirapWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_IDFILEBO;
  public String w_CODSOG;
  public String w_IDBASE;
  public String w_xragsoc;
  public String w_DOMICILIO;
  public String w_DESCCIT;
  public String w_PROVINCIA;
  public String w_CAP;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
  public String opk_CODSOG;
}
