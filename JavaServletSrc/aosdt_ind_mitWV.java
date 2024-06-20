public class aosdt_ind_mitWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_IDMOD;
  public String w_IDIND;
  public String w_PROGIND;
  public String w_DESCRI;
  public String w_DESCRI_layer;
  // variabili che puntano ai figli
  public aosdt_sub_ind_mitBO aosdt_sub_ind_mit;
  public String m_cWv_aosdt_sub_ind_mit;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
  public String opk_IDIND;
}
