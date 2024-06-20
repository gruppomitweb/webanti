// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_cgo_tbtipgioBO extends armt_cgo_tbtipgioBL {
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
  public armt_cgo_tbtipgioBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_cgo_tbtipgio");
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
      l_bResult = CanSaveChild(ardt_cgo_tgtiporeg,m_cWv_ardt_cgo_tgtiporeg,"m_cWv_ardt_cgo_tgtiporeg");
      if (l_bResult) {
        l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
      } else {
        m_cLastMsgError = ardt_cgo_tgtiporeg.m_cLastMsgError;
      }
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
        if (m_bLoaded) {
          NotifyEvent("Update children start");
        } else {
          NotifyEvent("Insert children start");
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (ardt_cgo_tgtiporeg.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_cgo_tgtiporeg)) {
            ardt_cgo_tgtiporeg.SetFromContext(m_cWv_ardt_cgo_tgtiporeg);
            m_cWv_ardt_cgo_tgtiporeg = "_not_empty_";
          }
          if (ardt_cgo_tgtiporeg.IsUpdated()) {
            ardt_cgo_tgtiporeg.w_TRCODGIO = w_CODTPGIO;
            if ( ! (ardt_cgo_tgtiporeg.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        CPLib.SaveMNTs(m_Sql,m_MNTs,this);
        l_bResult = CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK);
        if (m_bLoaded) {
          NotifyEvent("Update children end");
        } else {
          NotifyEvent("Insert children end");
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
  public static String[] m_cLoadParameterNames = {"CODTPGIO"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_CODTPGIO) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_cgo_tbtipgio,m_cPhName_cgo_tbtipgio,m_cVirtName_cgo_tbtipgio,m_cVirtName_cgo_tbtipgio+".CODTPGIO="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_CODTPGIO,"C",3,0),m_cServer_cgo_tbtipgio,p_CODTPGIO),"");
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
        w_CODTPGIO = l_rsLoad.GetString("CODTPGIO");
        w_DESTPGIO = l_rsLoad.GetString("DESTPGIO");
        w_SOGTPGIO = l_rsLoad.GetDouble("SOGTPGIO");
        w_EDTTPGIO = l_rsLoad.GetString("EDTTPGIO");
        w_DEFTPGIO = l_rsLoad.GetString("DEFTPGIO");
        w_EDTSPGIO = l_rsLoad.GetString("EDTSPGIO");
        w_DEFSPGIO = l_rsLoad.GetString("DEFSPGIO");
        w_FLGPLGIO = l_rsLoad.GetString("FLGPLGIO");
        w_FLGMLGIO = l_rsLoad.GetString("FLGMLGIO");
        w_MAGPAGGIO = l_rsLoad.GetDouble("MAGPAGGIO");
        w_MINPAGGIO = l_rsLoad.GetDouble("MINPAGGIO");
        w_FDC1OSGIO = l_rsLoad.GetString("FDC1OSGIO");
        w_FDC2OSGIO = l_rsLoad.GetString("FDC2OSGIO");
        w_FDC3OSGIO = l_rsLoad.GetString("FDC3OSGIO");
        w_FDC4OSGIO = l_rsLoad.GetString("FDC4OSGIO");
        w_FDC5OSGIO = l_rsLoad.GetString("FDC5OSGIO");
        w_FDC6OSGIO = l_rsLoad.GetString("FDC6OSGIO");
        w_FDC1SSGIO = l_rsLoad.GetString("FDC1SSGIO");
        w_FDC2SSGIO = l_rsLoad.GetString("FDC2SSGIO");
        w_FDC3SSGIO = l_rsLoad.GetString("FDC3SSGIO");
        w_FDC4SSGIO = l_rsLoad.GetString("FDC4SSGIO");
        w_FDC5SSGIO = l_rsLoad.GetString("FDC5SSGIO");
        w_FDC6SSGIO = l_rsLoad.GetString("FDC6SSGIO");
        w_FDC1ACGIO = l_rsLoad.GetString("FDC1ACGIO");
        w_FDC2ACGIO = l_rsLoad.GetString("FDC2ACGIO");
        w_FDC3ACGIO = l_rsLoad.GetString("FDC3ACGIO");
        w_FDC4ACGIO = l_rsLoad.GetString("FDC4ACGIO");
        w_FDC5ACGIO = l_rsLoad.GetString("FDC5ACGIO");
        w_FDC6ACGIO = l_rsLoad.GetString("FDC6ACGIO");
        w_NCOPAGGIO = l_rsLoad.GetDouble("NCOPAGGIO");
        w_FLTIPGIO = l_rsLoad.GetString("FLTIPGIO");
        w_FLGATTIVO = l_rsLoad.GetString("FLGATTIVO");
        w_IMPMINGIO = l_rsLoad.GetDouble("IMPMINGIO");
        w_IMPMINTOT = l_rsLoad.GetDouble("IMPMINTOT");
        // Assegna i valori degli op_
        // Assegna il contesto dei figli a Empty
        m_cWv_ardt_cgo_tgtiporeg = "";
        ardt_cgo_tgtiporeg.m_lCtxLoaded = false;
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_tbtipgio")) {
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
    return Load(w_CODTPGIO);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_tbtipgio);
      l_cSql = "insert into "+m_oWrInfo_cgo_tbtipgio.GetTableWriteName()+" (";
      l_cSql = l_cSql+"CODTPGIO,";
      l_cSql = l_cSql+"DESTPGIO,";
      l_cSql = l_cSql+"SOGTPGIO,";
      l_cSql = l_cSql+"EDTTPGIO,";
      l_cSql = l_cSql+"DEFTPGIO,";
      l_cSql = l_cSql+"EDTSPGIO,";
      l_cSql = l_cSql+"DEFSPGIO,";
      l_cSql = l_cSql+"FLGPLGIO,";
      l_cSql = l_cSql+"FLGMLGIO,";
      l_cSql = l_cSql+"MAGPAGGIO,";
      l_cSql = l_cSql+"MINPAGGIO,";
      l_cSql = l_cSql+"FDC1OSGIO,";
      l_cSql = l_cSql+"FDC2OSGIO,";
      l_cSql = l_cSql+"FDC3OSGIO,";
      l_cSql = l_cSql+"FDC4OSGIO,";
      l_cSql = l_cSql+"FDC5OSGIO,";
      l_cSql = l_cSql+"FDC6OSGIO,";
      l_cSql = l_cSql+"FDC1SSGIO,";
      l_cSql = l_cSql+"FDC2SSGIO,";
      l_cSql = l_cSql+"FDC3SSGIO,";
      l_cSql = l_cSql+"FDC4SSGIO,";
      l_cSql = l_cSql+"FDC5SSGIO,";
      l_cSql = l_cSql+"FDC6SSGIO,";
      l_cSql = l_cSql+"FDC1ACGIO,";
      l_cSql = l_cSql+"FDC2ACGIO,";
      l_cSql = l_cSql+"FDC3ACGIO,";
      l_cSql = l_cSql+"FDC4ACGIO,";
      l_cSql = l_cSql+"FDC5ACGIO,";
      l_cSql = l_cSql+"FDC6ACGIO,";
      l_cSql = l_cSql+"NCOPAGGIO,";
      l_cSql = l_cSql+"FLTIPGIO,";
      l_cSql = l_cSql+"FLGATTIVO,";
      l_cSql = l_cSql+"IMPMINGIO,";
      l_cSql = l_cSql+"IMPMINTOT,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_tbtipgio.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_tbtipgio")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODTPGIO,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESTPGIO,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOGTPGIO,"N",12,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_EDTTPGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DEFTPGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_EDTSPGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DEFSPGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGPLGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGMLGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MAGPAGGIO,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MINPAGGIO,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC1OSGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC2OSGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC3OSGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC4OSGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC5OSGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC6OSGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC1SSGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC2SSGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC3SSGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC4SSGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC5SSGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC6SSGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC1ACGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC2ACGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC3ACGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC4ACGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC5ACGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FDC6ACGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NCOPAGGIO,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLTIPGIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGATTIVO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IMPMINGIO,"N",10,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IMPMINTOT,"N",12,2)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_tbtipgio.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_tbtipgio")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_tbtipgio,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_tbtipgio);
      l_cSql = "Update "+m_oWrInfo_cgo_tbtipgio.GetTableWriteName()+" set";
      l_cSql = l_cSql+" DESTPGIO = "+CPLib.ToSQL(w_DESTPGIO,"C",50,0);
      l_cSql = l_cSql+", SOGTPGIO = "+CPLib.ToSQL(w_SOGTPGIO,"N",12,2);
      l_cSql = l_cSql+", EDTTPGIO = "+CPLib.ToSQL(w_EDTTPGIO,"C",1,0);
      l_cSql = l_cSql+", DEFTPGIO = "+CPLib.ToSQL(w_DEFTPGIO,"C",1,0);
      l_cSql = l_cSql+", EDTSPGIO = "+CPLib.ToSQL(w_EDTSPGIO,"C",1,0);
      l_cSql = l_cSql+", DEFSPGIO = "+CPLib.ToSQL(w_DEFSPGIO,"C",1,0);
      l_cSql = l_cSql+", FLGPLGIO = "+CPLib.ToSQL(w_FLGPLGIO,"C",1,0);
      l_cSql = l_cSql+", FLGMLGIO = "+CPLib.ToSQL(w_FLGMLGIO,"C",1,0);
      l_cSql = l_cSql+", MAGPAGGIO = "+CPLib.ToSQL(w_MAGPAGGIO,"N",2,0);
      l_cSql = l_cSql+", MINPAGGIO = "+CPLib.ToSQL(w_MINPAGGIO,"N",2,0);
      l_cSql = l_cSql+", FDC1OSGIO = "+CPLib.ToSQL(w_FDC1OSGIO,"C",1,0);
      l_cSql = l_cSql+", FDC2OSGIO = "+CPLib.ToSQL(w_FDC2OSGIO,"C",1,0);
      l_cSql = l_cSql+", FDC3OSGIO = "+CPLib.ToSQL(w_FDC3OSGIO,"C",1,0);
      l_cSql = l_cSql+", FDC4OSGIO = "+CPLib.ToSQL(w_FDC4OSGIO,"C",1,0);
      l_cSql = l_cSql+", FDC5OSGIO = "+CPLib.ToSQL(w_FDC5OSGIO,"C",1,0);
      l_cSql = l_cSql+", FDC6OSGIO = "+CPLib.ToSQL(w_FDC6OSGIO,"C",1,0);
      l_cSql = l_cSql+", FDC1SSGIO = "+CPLib.ToSQL(w_FDC1SSGIO,"C",1,0);
      l_cSql = l_cSql+", FDC2SSGIO = "+CPLib.ToSQL(w_FDC2SSGIO,"C",1,0);
      l_cSql = l_cSql+", FDC3SSGIO = "+CPLib.ToSQL(w_FDC3SSGIO,"C",1,0);
      l_cSql = l_cSql+", FDC4SSGIO = "+CPLib.ToSQL(w_FDC4SSGIO,"C",1,0);
      l_cSql = l_cSql+", FDC5SSGIO = "+CPLib.ToSQL(w_FDC5SSGIO,"C",1,0);
      l_cSql = l_cSql+", FDC6SSGIO = "+CPLib.ToSQL(w_FDC6SSGIO,"C",1,0);
      l_cSql = l_cSql+", FDC1ACGIO = "+CPLib.ToSQL(w_FDC1ACGIO,"C",1,0);
      l_cSql = l_cSql+", FDC2ACGIO = "+CPLib.ToSQL(w_FDC2ACGIO,"C",1,0);
      l_cSql = l_cSql+", FDC3ACGIO = "+CPLib.ToSQL(w_FDC3ACGIO,"C",1,0);
      l_cSql = l_cSql+", FDC4ACGIO = "+CPLib.ToSQL(w_FDC4ACGIO,"C",1,0);
      l_cSql = l_cSql+", FDC5ACGIO = "+CPLib.ToSQL(w_FDC5ACGIO,"C",1,0);
      l_cSql = l_cSql+", FDC6ACGIO = "+CPLib.ToSQL(w_FDC6ACGIO,"C",1,0);
      l_cSql = l_cSql+", NCOPAGGIO = "+CPLib.ToSQL(w_NCOPAGGIO,"N",2,0);
      l_cSql = l_cSql+", FLTIPGIO = "+CPLib.ToSQL(w_FLTIPGIO,"C",1,0);
      l_cSql = l_cSql+", FLGATTIVO = "+CPLib.ToSQL(w_FLGATTIVO,"C",1,0);
      l_cSql = l_cSql+", IMPMINGIO = "+CPLib.ToSQL(w_IMPMINGIO,"N",10,2);
      l_cSql = l_cSql+", IMPMINTOT = "+CPLib.ToSQL(w_IMPMINTOT,"N",12,2);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_tbtipgio")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"CODTPGIO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODTPGIO,"C",3,0),m_cServer_cgo_tbtipgio,w_CODTPGIO);
      l_cSql = l_cSql+m_oWrInfo_cgo_tbtipgio.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_tbtipgio")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_tbtipgio,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_CODTPGIO) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_CODTPGIO);
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
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_cgo_tgtiporeg.w_TRCODGIO = w_CODTPGIO;
          ardt_cgo_tgtiporeg.Delete();
        }
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_cgo_tbtipgio.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"CODTPGIO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODTPGIO,"C",3,0),m_cServer_cgo_tbtipgio,w_CODTPGIO);
          l_cSql = l_cSql+m_oWrInfo_cgo_tbtipgio.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_tbtipgio")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_tbtipgio,l_cSql);
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
    return Delete(w_CODTPGIO);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arrt_cgo_agg_cgotipope,
  public static final String i_InvokedRoutines = ",arrt_cgo_agg_cgotipope,";
}
