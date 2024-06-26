// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_xraziobo_aggBO extends armt_xraziobo_aggBL {
  class SqlLoader {
    double m_nColumns = 0;
    CPSql m_Sql;
    String m_cServer;
    String m_cMainTable;
    String m_cSelect;
    String m_cFrom;
    String m_cAlias;
    String m_cWhere;
    String m_cOrderBy;
    public SqlLoader(CPSql sql,String server,String from,String alias,String where,String orderby) {
      m_cAlias = alias;
      m_Sql = sql;
      m_cServer = server;
      m_cMainTable = alias;
      m_cSelect = m_cAlias+".*";
      m_cFrom = from+" "+m_cAlias;
      m_cWhere = where;
      m_cOrderBy = orderby;
    }
    public CPResultSet Query() {
      String l_cWhere = QueryFilter(m_Ctx);
      if (CPLib.Empty(l_cWhere)) {
        l_cWhere = m_cWhere;
      } else {
        if ( ! (CPLib.Empty(m_cWhere))) {
          l_cWhere = "("+m_cWhere+") and ("+l_cWhere+")";
        }
      }
      return m_Sql.Query(m_cServer,CPSql.BuildSQLPhrase(m_cSelect,m_cFrom,l_cWhere,m_cOrderBy));
    }
  }
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public armt_xraziobo_aggBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean CheckOTPSecurity() {
    boolean l_bResult;
    l_bResult = true;
    int accessType;
    boolean requiredOTP;
    boolean requiredPwd;
    requiredOTP = (m_bLoaded?false:false);
    requiredPwd = (m_bLoaded?false:false);
    if (requiredOTP) {
      accessType = 3;
    } else if (requiredPwd) {
      accessType = 2;
    } else {
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_xraziobo_agg");
    }
    if (CPLib.eq(accessType,2)) {
      // richiesta password
      if ( ! (CPLib.CheckPwd(m_Ctx,m_cPassword))) {
        l_bResult = false;
        m_nLastError = 4;
        m_cLastMsgError = (CPLib.Empty(m_cPassword)?"MSG_NEED_PWD":"MSG_WRONG_PWD");
      }
    } else if (CPLib.eq(accessType,3)) {
      // richiesto otp
      if (CPLib.Empty(m_cOTP) ||  ! (CPLib.CheckOTP(m_Ctx.UserCode(),m_cOTP))) {
        l_bResult = false;
        m_nLastError = 5;
        m_cLastMsgError = (CPLib.Empty(m_cOTP)?"MSG_NEED_OTP":"MSG_WRONG_OTP");
      }
    }
    return l_bResult;
  }
  public boolean CanSave() {
    ResetErrorMessage();
    boolean l_bResult;
    l_bResult = true;
    if (l_bResult) {
      l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
    }
    return l_bResult;
  }
  public static String[] m_cSaveParameterNames = {"AlreadyAccepted"};
  public boolean Save() {
    return Save(false);
  }
  public boolean Save(boolean p_bAlreadyAccepted) {
    boolean l_bResult;
    l_bResult = true;
    // Se il record � stato modificato, prosegue con il salvataggio
    if (IsUpdated()) {
      // Verifica globale dei check delle variabili.
      l_bResult = l_bResult && BRCheck();
      l_bResult = l_bResult && Check();
      l_bResult = l_bResult && (m_bSkipCheckOTPSecurity || CheckOTPSecurity());
      l_bResult = l_bResult && (p_bAlreadyAccepted || CanSave());
      if (l_bResult) {
        // Il metodo "Save" richiede l'utilizzo di una transazione. Se il modulo che
        // gestisce le transazioni trova che ce n'� gi� una, utilizza quella, altrimenti
        // ne inizia una nuova ("begin transaction").
        m_Sql.RequireTransaction();
        if (m_bLoaded) {
          Update();
          BROnUpdated();
        } else {
          Insert();
          BROnInserted();
        }
        if (CPLib.gt(m_MNTs.length,0)) {
          if (m_bLoaded) {
            NotifyEvent("Update children start");
          } else {
            NotifyEvent("Insert children start");
          }
        }
        CPLib.SaveMNTs(m_Sql,m_MNTs,this);
        l_bResult = CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK);
        if (CPLib.gt(m_MNTs.length,0)) {
          if (m_bLoaded) {
            NotifyEvent("Update children end");
          } else {
            NotifyEvent("Insert children end");
          }
        }
        /*  Se il metodo di richiesta della transazione ha cominciato una nuova transazione,
                                    questa viene terminata ("Commit" o "Rollback"), altrimenti segna come completata
                                    la parte di transazione corrente
                                  */
        // * --- Area Manuale = BO - Save End
        // * --- Fine Area Manuale
        BROnSaved();
        if (CPLib.ne(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          l_bResult = false;
        }
        m_Sql.CompleteTransaction();
      }
    }
    return l_bResult;
  }
  public static String[] m_cLoadParameterNames = {"IDBASE"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_IDBASE) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_xraziobo_agg,m_cPhName_xraziobo_agg,m_cVirtName_xraziobo_agg,m_cVirtName_xraziobo_agg+".IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_IDBASE,"C",10,0),m_cServer_xraziobo_agg,p_IDBASE),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    // Cursore dei record caricati
    l_rsLoad = l_oSqlLoader.Query();
    try {
      m_bLoaded =  ! (l_rsLoad.Eof());
      if (m_bLoaded) {
        m_bCalculating = true;
        /*  Assegna il valore iniziale a tutte le variabili non calcolate/inizializzate.
                                    Queste variabili non vengono inizializzate nella lettura del record,
                                    quindi terrebbero il valore che avevano precedentemente.
                                 */
        w_SEGNO = "";
        w_xC1DESCRI = "";
        w_xC2DESCRI = "";
        w_xC3DESCRI = "";
        w_xC4DESCRI = "";
        w_xC5DESCRI = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_IDBASE = l_rsLoad.GetString("IDBASE");
        w_CATEG01 = l_rsLoad.GetString("CATEG01");
        w_xC1DESCRI = "";
        Link_CANUTVNGFD("Load");
        w_CATEG02 = l_rsLoad.GetString("CATEG02");
        w_xC2DESCRI = "";
        Link_IXGRJLAKIQ("Load");
        w_CATEG03 = l_rsLoad.GetString("CATEG03");
        w_xC3DESCRI = "";
        Link_NKIXCWZJHO("Load");
        w_CATEG04 = l_rsLoad.GetString("CATEG04");
        w_xC4DESCRI = "";
        Link_JQLGHMLOKO("Load");
        w_CATEG05 = l_rsLoad.GetString("CATEG05");
        w_xC5DESCRI = "";
        Link_QVBZSFMTVP("Load");
        w_CATEGORIA = l_rsLoad.GetString("CATEGORIA");
        w_FLAGFRAUD = l_rsLoad.GetDouble("FLAGFRAUD");
        w_SV58724 = l_rsLoad.GetString("SV58724");
        w_SV58726SCA = l_rsLoad.GetString("SV58726SCA");
        w_SV58726SA = l_rsLoad.GetString("SV58726SA");
        w_SV58726PISP = l_rsLoad.GetString("SV58726PISP");
        w_C_COGNOME = l_rsLoad.GetString("C_COGNOME");
        w_C_NOME = l_rsLoad.GetString("C_NOME");
        w_SOSPAGAM = l_rsLoad.GetString("SOSPAGAM");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"xraziobo_agg")) {
          m_cOldCPCCCHK = l_rsLoad.GetString("CPCCCHK");
        } else {
          m_cOldCPCCCHK = "nocpcc";
        }
        m_bCalculating = false;
        SaveDependsOn();
        m_cPreviousState = GetCurrentState();
        NotifyEvent("Load");
      } else {
        Blank();
      }
    } finally {
      l_rsLoad.Close();
    }
    // * --- Area Manuale = BO - Load Record End
    // * --- Fine Area Manuale
    return m_bLoaded;
  }
  public boolean Load() {
    return Load(w_IDBASE);
  }
  void Insert() {
    String l_cSql;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    double l_nUpdatedRows;
    // * --- Area Manuale = BO - Insert Init
    // * --- Fine Area Manuale
    // * --- Area Manuale = BO - Autonum Assigned
    // * --- Fine Area Manuale
    NotifyEvent("Insert start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_xraziobo_agg);
      l_cSql = "insert into "+m_oWrInfo_xraziobo_agg.GetTableWriteName()+" (";
      l_cSql = l_cSql+"IDBASE,";
      l_cSql = l_cSql+"CATEG01,";
      l_cSql = l_cSql+"CATEG02,";
      l_cSql = l_cSql+"CATEG03,";
      l_cSql = l_cSql+"CATEG04,";
      l_cSql = l_cSql+"CATEG05,";
      l_cSql = l_cSql+"CATEGORIA,";
      l_cSql = l_cSql+"FLAGFRAUD,";
      l_cSql = l_cSql+"SV58724,";
      l_cSql = l_cSql+"SV58726SCA,";
      l_cSql = l_cSql+"SV58726SA,";
      l_cSql = l_cSql+"SV58726PISP,";
      l_cSql = l_cSql+"C_COGNOME,";
      l_cSql = l_cSql+"C_NOME,";
      l_cSql = l_cSql+"SOSPAGAM,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_xraziobo_agg.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"xraziobo_agg")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDBASE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG01,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG02,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG03,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG04,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG05,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CATEGORIA,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGFRAUD,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SV58724,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SV58726SCA,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SV58726SA,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SV58726PISP,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_COGNOME,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_NOME,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSPAGAM,"C",1,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_xraziobo_agg.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"xraziobo_agg")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_xraziobo_agg,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Insert end");
    // * --- Area Manuale = BO - Insert End
    // * --- Fine Area Manuale
  }
  void Update() {
    String l_cSql;
    int l_nUpdatedRows;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    // * --- Area Manuale = BO - Replace Init
    // * --- Fine Area Manuale
    NotifyEvent("Update start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_xraziobo_agg);
      l_cSql = "Update "+m_oWrInfo_xraziobo_agg.GetTableWriteName()+" set";
      l_cSql = l_cSql+" CATEG01 = "+CPLib.ToSQLNull(w_CATEG01,"C",2,0);
      l_cSql = l_cSql+", CATEG02 = "+CPLib.ToSQLNull(w_CATEG02,"C",2,0);
      l_cSql = l_cSql+", CATEG03 = "+CPLib.ToSQLNull(w_CATEG03,"C",2,0);
      l_cSql = l_cSql+", CATEG04 = "+CPLib.ToSQLNull(w_CATEG04,"C",2,0);
      l_cSql = l_cSql+", CATEG05 = "+CPLib.ToSQLNull(w_CATEG05,"C",2,0);
      l_cSql = l_cSql+", CATEGORIA = "+CPLib.ToSQL(w_CATEGORIA,"C",10,0);
      l_cSql = l_cSql+", FLAGFRAUD = "+CPLib.ToSQL(w_FLAGFRAUD,"N",1,0);
      l_cSql = l_cSql+", SV58724 = "+CPLib.ToSQL(w_SV58724,"C",2,0);
      l_cSql = l_cSql+", SV58726SCA = "+CPLib.ToSQL(w_SV58726SCA,"C",1,0);
      l_cSql = l_cSql+", SV58726SA = "+CPLib.ToSQL(w_SV58726SA,"C",3,0);
      l_cSql = l_cSql+", SV58726PISP = "+CPLib.ToSQL(w_SV58726PISP,"C",3,0);
      l_cSql = l_cSql+", C_COGNOME = "+CPLib.ToSQL(w_C_COGNOME,"C",50,0);
      l_cSql = l_cSql+", C_NOME = "+CPLib.ToSQL(w_C_NOME,"C",30,0);
      l_cSql = l_cSql+", SOSPAGAM = "+CPLib.ToSQL(w_SOSPAGAM,"C",1,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"xraziobo_agg")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_xraziobo_agg,w_IDBASE);
      l_cSql = l_cSql+m_oWrInfo_xraziobo_agg.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"xraziobo_agg")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_xraziobo_agg,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_IDBASE) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_IDBASE);
    // * --- Area Manuale = BO - Delete Init
    // * --- Fine Area Manuale
    if (m_bLoaded) {
      if (CanDelete()) {
        /*  Il metodo "Delete" richiede l'utilizzo di una transazione. Se il modulo che
                                    gestisce le transazioni trova che ce n'� gi� una, utilizza quella, altrimenti
                                    ne inizia una nuova ("begin transaction").
                                  */
        m_Sql.RequireTransaction();
        NotifyEvent("Delete start");
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_xraziobo_agg.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_xraziobo_agg,w_IDBASE);
          l_cSql = l_cSql+m_oWrInfo_xraziobo_agg.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"xraziobo_agg")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_xraziobo_agg,l_cSql);
          if (CPLib.ne(l_nUpdatedRows,1)) {
            // AbortTransaction
            m_Sql.AbortTransaction();
          }
        }
        NotifyEvent("Delete end");
        BROnDeleted();
        l_bTrsOk = CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK);
        // Se il metodo di richiesta della transazione ha cominciato una nuova transazione,
        // questa viene terminata ("Commit" o "Rollback"), altrimenti segna come completata
        // la parte di transazione corrente
        m_Sql.CompleteTransaction();
      } else {
        m_Sql.AbortTransaction(m_cLastMsgError);
      }
    }
    // * --- Area Manuale = BO - Delete End
    // * --- Fine Area Manuale
    return m_bLoaded && CPLib.eq(l_nUpdatedRows,1) && l_bTrsOk;
  }
  public boolean Delete() {
    return Delete(w_IDBASE);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"CANUTVNGFD")) {
      result.m_TableName = "tbcateg01";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "opemt_tbcateg01";
      result.m_rdField = new String[]{"C1CODICE" , "C1DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("CANUTVNGFD",CPLib.GetLinkedFieldProps("C1CODICE","CATEG01","C",2,0));
      result.AppendFilter("C1CODTAB","C","=",false);
    } else if (CPLib.eq(p_cID,"IXGRJLAKIQ")) {
      result.m_TableName = "tbcateg02";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "opemt_tbcateg02";
      result.m_rdField = new String[]{"C2CODICE" , "C2DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("IXGRJLAKIQ",CPLib.GetLinkedFieldProps("C2CODICE","CATEG02","C",2,0));
      result.AppendFilter("C2CODTAB","C","=",false);
    } else if (CPLib.eq(p_cID,"NKIXCWZJHO")) {
      result.m_TableName = "tbcateg03";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "opemt_tbcateg03";
      result.m_rdField = new String[]{"C3CODICE" , "C3DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NKIXCWZJHO",CPLib.GetLinkedFieldProps("C3CODICE","CATEG03","C",2,0));
      result.AppendFilter("C3CODTAB","C","=",false);
    } else if (CPLib.eq(p_cID,"JQLGHMLOKO")) {
      result.m_TableName = "tbcateg04";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "opemt_tbcateg04";
      result.m_rdField = new String[]{"C4CODICE" , "C4DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("JQLGHMLOKO",CPLib.GetLinkedFieldProps("C4CODICE","CATEG04","C",2,0));
      result.AppendFilter("C4CODTAB","C","=",false);
    } else if (CPLib.eq(p_cID,"QVBZSFMTVP")) {
      result.m_TableName = "tbcateg05";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "opemt_tbcateg05";
      result.m_rdField = new String[]{"C5CODICE" , "C5DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("QVBZSFMTVP",CPLib.GetLinkedFieldProps("C5CODICE","CATEG05","C",2,0));
      result.AppendFilter("C5CODTAB","C","=",false);
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,fwfn_calc_categoria,
  public static final String i_InvokedRoutines = ",fwfn_calc_categoria,";
}
