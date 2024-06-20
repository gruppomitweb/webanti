// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_wu_poschkBO extends armt_wu_poschkBL {
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
  public armt_wu_poschkBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_wu_poschk");
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
    // Se il record è stato modificato, prosegue con il salvataggio
    if (IsUpdated()) {
      // Verifica globale dei check delle variabili.
      l_bResult = l_bResult && BRCheck();
      l_bResult = l_bResult && Check();
      l_bResult = l_bResult && (m_bSkipCheckOTPSecurity || CheckOTPSecurity());
      l_bResult = l_bResult && (p_bAlreadyAccepted || CanSave());
      if (l_bResult) {
        // Il metodo "Save" richiede l'utilizzo di una transazione. Se il modulo che
        // gestisce le transazioni trova che ce n'è già una, utilizza quella, altrimenti
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
  public static String[] m_cLoadParameterNames = {"CPCODMAG","CPCODAJW"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_CPCODMAG,String p_CPCODAJW) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_wuposchk,m_cPhName_wuposchk,m_cVirtName_wuposchk,m_cVirtName_wuposchk+".CPCODMAG="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_CPCODMAG,"C",5,0),m_cServer_wuposchk,p_CPCODMAG)+" AND "+m_cVirtName_wuposchk+".CPCODAJW="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_CPCODAJW,"C",9,0),m_cServer_wuposchk,p_CPCODAJW),"");
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
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_CPCODMAG = l_rsLoad.GetString("CPCODMAG");
        w_CPCODAJW = l_rsLoad.GetString("CPCODAJW");
        w_CPRAGSOC = l_rsLoad.GetString("CPRAGSOC");
        w_CPDOMICI = l_rsLoad.GetString("CPDOMICI");
        w_CP_CITTA = l_rsLoad.GetString("CP_CITTA");
        w_CPERR_01 = l_rsLoad.GetString("CPERR_01");
        w_CPERR_02 = l_rsLoad.GetString("CPERR_02");
        w_CPERR_03 = l_rsLoad.GetString("CPERR_03");
        w_CPERR_04 = l_rsLoad.GetString("CPERR_04");
        w_CPERR_05 = l_rsLoad.GetString("CPERR_05");
        w_CPERR_06 = l_rsLoad.GetString("CPERR_06");
        w_CPERR_07 = l_rsLoad.GetString("CPERR_07");
        w_CPERR_08 = l_rsLoad.GetString("CPERR_08");
        w_CPERR_09 = l_rsLoad.GetString("CPERR_09");
        w_CPERR_10 = l_rsLoad.GetString("CPERR_10");
        w_CPFLGCOR = l_rsLoad.GetString("CPFLGCOR");
        w_CPFLGFOR = l_rsLoad.GetString("CPFLGFOR");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"wuposchk")) {
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
    return Load(w_CPCODMAG,w_CPCODAJW);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_wuposchk);
      l_cSql = "insert into "+m_oWrInfo_wuposchk.GetTableWriteName()+" (";
      l_cSql = l_cSql+"CPCODMAG,";
      l_cSql = l_cSql+"CPCODAJW,";
      l_cSql = l_cSql+"CPRAGSOC,";
      l_cSql = l_cSql+"CPDOMICI,";
      l_cSql = l_cSql+"CP_CITTA,";
      l_cSql = l_cSql+"CPERR_01,";
      l_cSql = l_cSql+"CPERR_02,";
      l_cSql = l_cSql+"CPERR_03,";
      l_cSql = l_cSql+"CPERR_04,";
      l_cSql = l_cSql+"CPERR_05,";
      l_cSql = l_cSql+"CPERR_06,";
      l_cSql = l_cSql+"CPERR_07,";
      l_cSql = l_cSql+"CPERR_08,";
      l_cSql = l_cSql+"CPERR_09,";
      l_cSql = l_cSql+"CPERR_10,";
      l_cSql = l_cSql+"CPFLGCOR,";
      l_cSql = l_cSql+"CPFLGFOR,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_wuposchk.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"wuposchk")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPCODMAG,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPCODAJW,"C",9,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPRAGSOC,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPDOMICI,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CP_CITTA,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPERR_01,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPERR_02,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPERR_03,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPERR_04,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPERR_05,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPERR_06,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPERR_07,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPERR_08,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPERR_09,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPERR_10,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPFLGCOR,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CPFLGFOR,"C",1,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_wuposchk.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"wuposchk")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_wuposchk,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_wuposchk);
      l_cSql = "Update "+m_oWrInfo_wuposchk.GetTableWriteName()+" set";
      l_cSql = l_cSql+" CPRAGSOC = "+CPLib.ToSQL(w_CPRAGSOC,"C",30,0);
      l_cSql = l_cSql+", CPDOMICI = "+CPLib.ToSQL(w_CPDOMICI,"C",40,0);
      l_cSql = l_cSql+", CP_CITTA = "+CPLib.ToSQL(w_CP_CITTA,"C",30,0);
      l_cSql = l_cSql+", CPERR_01 = "+CPLib.ToSQL(w_CPERR_01,"C",60,0);
      l_cSql = l_cSql+", CPERR_02 = "+CPLib.ToSQL(w_CPERR_02,"C",60,0);
      l_cSql = l_cSql+", CPERR_03 = "+CPLib.ToSQL(w_CPERR_03,"C",60,0);
      l_cSql = l_cSql+", CPERR_04 = "+CPLib.ToSQL(w_CPERR_04,"C",60,0);
      l_cSql = l_cSql+", CPERR_05 = "+CPLib.ToSQL(w_CPERR_05,"C",60,0);
      l_cSql = l_cSql+", CPERR_06 = "+CPLib.ToSQL(w_CPERR_06,"C",60,0);
      l_cSql = l_cSql+", CPERR_07 = "+CPLib.ToSQL(w_CPERR_07,"C",60,0);
      l_cSql = l_cSql+", CPERR_08 = "+CPLib.ToSQL(w_CPERR_08,"C",60,0);
      l_cSql = l_cSql+", CPERR_09 = "+CPLib.ToSQL(w_CPERR_09,"C",60,0);
      l_cSql = l_cSql+", CPERR_10 = "+CPLib.ToSQL(w_CPERR_10,"C",60,0);
      l_cSql = l_cSql+", CPFLGCOR = "+CPLib.ToSQL(w_CPFLGCOR,"C",1,0);
      l_cSql = l_cSql+", CPFLGFOR = "+CPLib.ToSQL(w_CPFLGFOR,"C",1,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"wuposchk")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"CPCODMAG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CPCODMAG,"C",5,0),m_cServer_wuposchk,w_CPCODMAG)+" AND "+"CPCODAJW="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CPCODAJW,"C",9,0),m_cServer_wuposchk,w_CPCODAJW);
      l_cSql = l_cSql+m_oWrInfo_wuposchk.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"wuposchk")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_wuposchk,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_CPCODMAG,String p_CPCODAJW) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_CPCODMAG,p_CPCODAJW);
    // * --- Area Manuale = BO - Delete Init
    // * --- Fine Area Manuale
    if (m_bLoaded) {
      if (CanDelete()) {
        /*  Il metodo "Delete" richiede l'utilizzo di una transazione. Se il modulo che
                                    gestisce le transazioni trova che ce n'è già una, utilizza quella, altrimenti
                                    ne inizia una nuova ("begin transaction").
                                  */
        m_Sql.RequireTransaction();
        NotifyEvent("Delete start");
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_wuposchk.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"CPCODMAG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CPCODMAG,"C",5,0),m_cServer_wuposchk,w_CPCODMAG)+" AND "+"CPCODAJW="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CPCODAJW,"C",9,0),m_cServer_wuposchk,w_CPCODAJW);
          l_cSql = l_cSql+m_oWrInfo_wuposchk.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"wuposchk")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_wuposchk,l_cSql);
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
    return Delete(w_CPCODMAG,w_CPCODAJW);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
