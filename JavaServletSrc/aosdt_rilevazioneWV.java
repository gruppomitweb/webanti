public class aosdt_rilevazioneWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_IDMOD;
  public String w_CONNES;
  public java.sql.Date w_DTRIL;
  public String w_PROVENIENZA;
  public double w_CPROWNUM;
  public String w_DESCRI;
  // variabili che puntano ai figli
  public aosdt_anom_rilBO aosdt_anom_ril;
  public String m_cWv_aosdt_anom_ril;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public String o_IDMOD;
  public double o_CPROWNUM;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
}
