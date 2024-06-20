public class aosmt_mod_ind_defWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_IDMOD;
  public String w_IDMODMIT;
  public String w_DESCRI;
  public java.sql.Date w_DTFINVAL;
  public boolean w_show_noapplic;
  public double w_pippo;
  // variabili che puntano ai figli
  public aosdt_ind_defBO aosdt_ind_def;
  public String m_cWv_aosdt_ind_def;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public boolean o_show_noapplic;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
