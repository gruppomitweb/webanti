public class aosmt_mod_ind_mitWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_IDMOD;
  public String w_DESCRI;
  public java.sql.Date w_DTFINVAL;
  // variabili che puntano ai figli
  public aosdt_ind_mitBO aosdt_ind_mit;
  public String m_cWv_aosdt_ind_mit;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
