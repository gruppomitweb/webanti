public class spadministration_usersgroupsWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public double w_usercode;
  public double w_groupcode;
  public java.sql.Date w_datestart;
  public java.sql.Date w_datestop;
  public String w_companies;
  public String w_name;
  public double w_selected_group;
  public boolean w_appoggio;
  public double w_pwd_complexity;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public double o_selected_group;
  public double o_groupcode;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
  public double opk_groupcode;
}
