// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_cgo_qadv_operazioniBO extends armt_cgo_qadv_operazioniBL {
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
  public armt_cgo_qadv_operazioniBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_cgo_qadv_operazioni");
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
  public static String[] m_cLoadParameterNames = {"SNAINUMOPE"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_SNAINUMOPE) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_cgo_qadv_operazioni,m_cPhName_cgo_qadv_operazioni,m_cVirtName_cgo_qadv_operazioni,m_cVirtName_cgo_qadv_operazioni+".SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_SNAINUMOPE,"C",15,0),m_cServer_cgo_qadv_operazioni,p_SNAINUMOPE),"");
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
        w_QADV_DOMANDA01 = l_rsLoad.GetDouble("QADV_DOMANDA01");
        w_QADV_DOMANDA02 = l_rsLoad.GetDouble("QADV_DOMANDA02");
        w_QADV_DOMANDA03 = l_rsLoad.GetDouble("QADV_DOMANDA03");
        w_QADV_DOMANDA03_1 = l_rsLoad.GetString("QADV_DOMANDA03_1");
        w_QADV_DOMANDA03_2 = l_rsLoad.GetString("QADV_DOMANDA03_2");
        w_QADV_DOMANDA03_3 = l_rsLoad.GetString("QADV_DOMANDA03_3");
        w_QADV_MOTIVO03 = l_rsLoad.GetString("QADV_MOTIVO03");
        w_QADV_DOMANDA04 = l_rsLoad.GetDouble("QADV_DOMANDA04");
        w_QADV_DOMANDA04_1 = l_rsLoad.GetString("QADV_DOMANDA04_1");
        w_QADV_DOMANDA04_2 = l_rsLoad.GetString("QADV_DOMANDA04_2");
        w_QADV_DOMANDA04_3 = l_rsLoad.GetString("QADV_DOMANDA04_3");
        w_QADV_DOMANDA04_4 = l_rsLoad.GetString("QADV_DOMANDA04_4");
        w_QADV_DOMANDA05 = l_rsLoad.GetDouble("QADV_DOMANDA05");
        w_QADV_MOTIVO05 = l_rsLoad.GetString("QADV_MOTIVO05");
        w_QADV_DOMANDA06 = l_rsLoad.GetDouble("QADV_DOMANDA06");
        w_QADV_DOMANDA07 = l_rsLoad.GetDouble("QADV_DOMANDA07");
        w_QADV_DOMANDA08 = l_rsLoad.GetDouble("QADV_DOMANDA08");
        w_QADV_DOMANDA09 = l_rsLoad.GetDouble("QADV_DOMANDA09");
        w_QADV_DOMANDA10 = l_rsLoad.GetDouble("QADV_DOMANDA10");
        w_QADV_DOMANDA11 = l_rsLoad.GetDouble("QADV_DOMANDA11");
        w_QADV_DOMANDA12 = l_rsLoad.GetDouble("QADV_DOMANDA12");
        w_SNAINUMOPE = l_rsLoad.GetString("SNAINUMOPE");
        w_QADV_PUNTEGGIO01 = l_rsLoad.GetDouble("QADV_PUNTEGGIO01");
        w_QADV_PUNTEGGIO02 = l_rsLoad.GetDouble("QADV_PUNTEGGIO02");
        w_QADV_PUNTEGGIO03 = l_rsLoad.GetDouble("QADV_PUNTEGGIO03");
        w_QADV_PUNTEGGIO04 = l_rsLoad.GetDouble("QADV_PUNTEGGIO04");
        w_QADV_MOTIVO04 = l_rsLoad.GetString("QADV_MOTIVO04");
        w_QADV_PUNTEGGIO05 = l_rsLoad.GetDouble("QADV_PUNTEGGIO05");
        w_QADV_PUNTEGGIO06 = l_rsLoad.GetDouble("QADV_PUNTEGGIO06");
        w_QADV_PUNTEGGIO07 = l_rsLoad.GetDouble("QADV_PUNTEGGIO07");
        w_QADV_PUNTEGGIO08 = l_rsLoad.GetDouble("QADV_PUNTEGGIO08");
        w_QADV_PUNTEGGIO09 = l_rsLoad.GetDouble("QADV_PUNTEGGIO09");
        w_QADV_PUNTEGGIO10 = l_rsLoad.GetDouble("QADV_PUNTEGGIO10");
        w_QADV_PUNTEGGIO11 = l_rsLoad.GetDouble("QADV_PUNTEGGIO11");
        w_QADV_PUNTEGGIO12 = l_rsLoad.GetDouble("QADV_PUNTEGGIO12");
        w_QADV_FLGCOMPLETO = l_rsLoad.GetString("QADV_FLGCOMPLETO");
        w_QADV_TOTALE = l_rsLoad.GetDouble("QADV_TOTALE");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_qadv_operazioni")) {
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
    return Load(w_SNAINUMOPE);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_qadv_operazioni);
      l_cSql = "insert into "+m_oWrInfo_cgo_qadv_operazioni.GetTableWriteName()+" (";
      l_cSql = l_cSql+"QADV_DOMANDA01,";
      l_cSql = l_cSql+"QADV_DOMANDA02,";
      l_cSql = l_cSql+"QADV_DOMANDA03,";
      l_cSql = l_cSql+"QADV_DOMANDA03_1,";
      l_cSql = l_cSql+"QADV_DOMANDA03_2,";
      l_cSql = l_cSql+"QADV_DOMANDA03_3,";
      l_cSql = l_cSql+"QADV_MOTIVO03,";
      l_cSql = l_cSql+"QADV_DOMANDA04,";
      l_cSql = l_cSql+"QADV_DOMANDA04_1,";
      l_cSql = l_cSql+"QADV_DOMANDA04_2,";
      l_cSql = l_cSql+"QADV_DOMANDA04_3,";
      l_cSql = l_cSql+"QADV_DOMANDA04_4,";
      l_cSql = l_cSql+"QADV_DOMANDA05,";
      l_cSql = l_cSql+"QADV_MOTIVO05,";
      l_cSql = l_cSql+"QADV_DOMANDA06,";
      l_cSql = l_cSql+"QADV_DOMANDA07,";
      l_cSql = l_cSql+"QADV_DOMANDA08,";
      l_cSql = l_cSql+"QADV_DOMANDA09,";
      l_cSql = l_cSql+"QADV_DOMANDA10,";
      l_cSql = l_cSql+"QADV_DOMANDA11,";
      l_cSql = l_cSql+"QADV_DOMANDA12,";
      l_cSql = l_cSql+"SNAINUMOPE,";
      l_cSql = l_cSql+"QADV_PUNTEGGIO01,";
      l_cSql = l_cSql+"QADV_PUNTEGGIO02,";
      l_cSql = l_cSql+"QADV_PUNTEGGIO03,";
      l_cSql = l_cSql+"QADV_PUNTEGGIO04,";
      l_cSql = l_cSql+"QADV_MOTIVO04,";
      l_cSql = l_cSql+"QADV_PUNTEGGIO05,";
      l_cSql = l_cSql+"QADV_PUNTEGGIO06,";
      l_cSql = l_cSql+"QADV_PUNTEGGIO07,";
      l_cSql = l_cSql+"QADV_PUNTEGGIO08,";
      l_cSql = l_cSql+"QADV_PUNTEGGIO09,";
      l_cSql = l_cSql+"QADV_PUNTEGGIO10,";
      l_cSql = l_cSql+"QADV_PUNTEGGIO11,";
      l_cSql = l_cSql+"QADV_PUNTEGGIO12,";
      l_cSql = l_cSql+"QADV_FLGCOMPLETO,";
      l_cSql = l_cSql+"QADV_TOTALE,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_qadv_operazioni.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_qadv_operazioni")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA01,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA02,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA03,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA03_1,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA03_2,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA03_3,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_MOTIVO03,"M",10,0,m_cServer_cgo_qadv_operazioni,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA04,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA04_1,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA04_2,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA04_3,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA04_4,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA05,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_MOTIVO05,"M",10,0,m_cServer_cgo_qadv_operazioni,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA06,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA07,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA08,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA09,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA10,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA11,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_DOMANDA12,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SNAINUMOPE,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_PUNTEGGIO01,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_PUNTEGGIO02,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_PUNTEGGIO03,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_PUNTEGGIO04,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_MOTIVO04,"M",10,0,m_cServer_cgo_qadv_operazioni,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_PUNTEGGIO05,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_PUNTEGGIO06,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_PUNTEGGIO07,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_PUNTEGGIO08,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_PUNTEGGIO09,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_PUNTEGGIO10,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_PUNTEGGIO11,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_PUNTEGGIO12,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_FLGCOMPLETO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_QADV_TOTALE,"N",3,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_qadv_operazioni.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_qadv_operazioni")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_qadv_operazioni,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_qadv_operazioni);
      l_cSql = "Update "+m_oWrInfo_cgo_qadv_operazioni.GetTableWriteName()+" set";
      l_cSql = l_cSql+" QADV_DOMANDA01 = "+CPLib.ToSQL(w_QADV_DOMANDA01,"N",2,0);
      l_cSql = l_cSql+", QADV_DOMANDA02 = "+CPLib.ToSQL(w_QADV_DOMANDA02,"N",2,0);
      l_cSql = l_cSql+", QADV_DOMANDA03 = "+CPLib.ToSQL(w_QADV_DOMANDA03,"N",2,0);
      l_cSql = l_cSql+", QADV_DOMANDA03_1 = "+CPLib.ToSQL(w_QADV_DOMANDA03_1,"C",1,0);
      l_cSql = l_cSql+", QADV_DOMANDA03_2 = "+CPLib.ToSQL(w_QADV_DOMANDA03_2,"C",1,0);
      l_cSql = l_cSql+", QADV_DOMANDA03_3 = "+CPLib.ToSQL(w_QADV_DOMANDA03_3,"C",1,0);
      l_cSql = l_cSql+", QADV_MOTIVO03 = "+CPLib.ToSQL(w_QADV_MOTIVO03,"M",10,0,m_cServer_cgo_qadv_operazioni,m_oParameters);
      l_cSql = l_cSql+", QADV_DOMANDA04 = "+CPLib.ToSQL(w_QADV_DOMANDA04,"N",2,0);
      l_cSql = l_cSql+", QADV_DOMANDA04_1 = "+CPLib.ToSQL(w_QADV_DOMANDA04_1,"C",1,0);
      l_cSql = l_cSql+", QADV_DOMANDA04_2 = "+CPLib.ToSQL(w_QADV_DOMANDA04_2,"C",1,0);
      l_cSql = l_cSql+", QADV_DOMANDA04_3 = "+CPLib.ToSQL(w_QADV_DOMANDA04_3,"C",1,0);
      l_cSql = l_cSql+", QADV_DOMANDA04_4 = "+CPLib.ToSQL(w_QADV_DOMANDA04_4,"C",1,0);
      l_cSql = l_cSql+", QADV_DOMANDA05 = "+CPLib.ToSQL(w_QADV_DOMANDA05,"N",2,0);
      l_cSql = l_cSql+", QADV_MOTIVO05 = "+CPLib.ToSQL(w_QADV_MOTIVO05,"M",10,0,m_cServer_cgo_qadv_operazioni,m_oParameters);
      l_cSql = l_cSql+", QADV_DOMANDA06 = "+CPLib.ToSQL(w_QADV_DOMANDA06,"N",2,0);
      l_cSql = l_cSql+", QADV_DOMANDA07 = "+CPLib.ToSQL(w_QADV_DOMANDA07,"N",2,0);
      l_cSql = l_cSql+", QADV_DOMANDA08 = "+CPLib.ToSQL(w_QADV_DOMANDA08,"N",2,0);
      l_cSql = l_cSql+", QADV_DOMANDA09 = "+CPLib.ToSQL(w_QADV_DOMANDA09,"N",2,0);
      l_cSql = l_cSql+", QADV_DOMANDA10 = "+CPLib.ToSQL(w_QADV_DOMANDA10,"N",2,0);
      l_cSql = l_cSql+", QADV_DOMANDA11 = "+CPLib.ToSQL(w_QADV_DOMANDA11,"N",2,0);
      l_cSql = l_cSql+", QADV_DOMANDA12 = "+CPLib.ToSQL(w_QADV_DOMANDA12,"N",2,0);
      l_cSql = l_cSql+", QADV_PUNTEGGIO01 = "+CPLib.ToSQL(w_QADV_PUNTEGGIO01,"N",3,0);
      l_cSql = l_cSql+", QADV_PUNTEGGIO02 = "+CPLib.ToSQL(w_QADV_PUNTEGGIO02,"N",3,0);
      l_cSql = l_cSql+", QADV_PUNTEGGIO03 = "+CPLib.ToSQL(w_QADV_PUNTEGGIO03,"N",3,0);
      l_cSql = l_cSql+", QADV_PUNTEGGIO04 = "+CPLib.ToSQL(w_QADV_PUNTEGGIO04,"N",3,0);
      l_cSql = l_cSql+", QADV_MOTIVO04 = "+CPLib.ToSQL(w_QADV_MOTIVO04,"M",10,0,m_cServer_cgo_qadv_operazioni,m_oParameters);
      l_cSql = l_cSql+", QADV_PUNTEGGIO05 = "+CPLib.ToSQL(w_QADV_PUNTEGGIO05,"N",3,0);
      l_cSql = l_cSql+", QADV_PUNTEGGIO06 = "+CPLib.ToSQL(w_QADV_PUNTEGGIO06,"N",3,0);
      l_cSql = l_cSql+", QADV_PUNTEGGIO07 = "+CPLib.ToSQL(w_QADV_PUNTEGGIO07,"N",3,0);
      l_cSql = l_cSql+", QADV_PUNTEGGIO08 = "+CPLib.ToSQL(w_QADV_PUNTEGGIO08,"N",3,0);
      l_cSql = l_cSql+", QADV_PUNTEGGIO09 = "+CPLib.ToSQL(w_QADV_PUNTEGGIO09,"N",3,0);
      l_cSql = l_cSql+", QADV_PUNTEGGIO10 = "+CPLib.ToSQL(w_QADV_PUNTEGGIO10,"N",3,0);
      l_cSql = l_cSql+", QADV_PUNTEGGIO11 = "+CPLib.ToSQL(w_QADV_PUNTEGGIO11,"N",3,0);
      l_cSql = l_cSql+", QADV_PUNTEGGIO12 = "+CPLib.ToSQL(w_QADV_PUNTEGGIO12,"N",3,0);
      l_cSql = l_cSql+", QADV_FLGCOMPLETO = "+CPLib.ToSQL(w_QADV_FLGCOMPLETO,"C",1,0);
      l_cSql = l_cSql+", QADV_TOTALE = "+CPLib.ToSQL(w_QADV_TOTALE,"N",3,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_qadv_operazioni")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"C",15,0),m_cServer_cgo_qadv_operazioni,w_SNAINUMOPE);
      l_cSql = l_cSql+m_oWrInfo_cgo_qadv_operazioni.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_qadv_operazioni")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_qadv_operazioni,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_SNAINUMOPE) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_SNAINUMOPE);
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
          l_cSql = "Delete from "+m_oWrInfo_cgo_qadv_operazioni.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"C",15,0),m_cServer_cgo_qadv_operazioni,w_SNAINUMOPE);
          l_cSql = l_cSql+m_oWrInfo_cgo_qadv_operazioni.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_qadv_operazioni")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_qadv_operazioni,l_cSql);
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
    return Delete(w_SNAINUMOPE);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arrt_calccodfis,arrt_cgo_punteggio_adv,
  public static final String i_InvokedRoutines = ",arrt_calccodfis,arrt_cgo_punteggio_adv,";
}
