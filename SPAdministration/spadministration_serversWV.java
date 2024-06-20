public class spadministration_serversWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_ServerName;
  public String w_ServerDesc;
  public String w_ODBCDataSource;
  public String w_DatabaseType;
  public String w_PostIt;
  public String w_DatabaseType_SupportedDatabases;
  public String w_DatabaseType_Other;
  public String w_DatabaseType_Var;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public String o_DatabaseType;
  public String o_DatabaseType_Other;
  public String o_DatabaseType_Var;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
