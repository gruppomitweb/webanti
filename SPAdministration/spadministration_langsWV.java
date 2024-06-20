public class spadministration_langsWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_code;
  public String w_name;
  public String w_datalanguage;
  public boolean w_admin_database;
  public boolean w_database_updated;
  public boolean w_refreshlanguage;
  public boolean w_sudb_mode;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
