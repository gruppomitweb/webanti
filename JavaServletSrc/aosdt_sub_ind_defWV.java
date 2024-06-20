public class aosdt_sub_ind_defWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_IDMOD;
  public String w_IDIND;
  public String w_IDSUBIND;
  public String w_PROGSUBIND;
  public String w_DESCRI;
  public double w_PESO;
  public double w_INDRISCH;
  public boolean w_LOCKMIT;
  public boolean w_NOAPPLIC;
  public boolean w_show_noapplic;
  public String w_DESCRI_layer;
  public boolean w_open_layer;
  public boolean w_write_layer;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
  public String opk_IDSUBIND;
}
