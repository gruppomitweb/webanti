public class aosdt_anom_rilWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_IDMOD;
  public double w_ROWRIL;
  public String w_IDIND;
  public String w_IDSUBIND;
  public String w_NOTA;
  public String w_CONNES;
  public String w_PROGIND;
  public String w_DESCRI_IND;
  public String w_PROGSUBIND;
  public String w_DESCRI_SUBIND;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
  public String opk_IDIND;
  public String opk_IDSUBIND;
}
