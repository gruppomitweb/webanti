public class spadministration_groupsWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public double w_code;
  public String w_name;
  public String w_grptype;
  public java.sql.Date w_datestart;
  public java.sql.Date w_datestop;
  public String w_company;
  public double w_pwdcomplexity;
  public double w_pwddaysduration;
  public double w_pwdciclicity;
  public double w_captchalevel;
  public String w_grpdescription;
  public double w_idfolder;
  public double w_init_code;
  // variabili che puntano ai figli
  public spadministration_subgroupsBO spadministration_subgroups;
  public String m_cWv_spadministration_subgroups;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
