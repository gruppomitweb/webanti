// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_cgo_telematico_errBO extends armt_cgo_telematico_errBL {
  class SqlLoader {
    public boolean m_bLink_1_6 = false;
    public boolean m_bLink_1_8 = false;
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
    public void AddJoinedLink_1_6(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_6.CODDIP AS CODDIP106";
        m_cSelect = m_cSelect+" ,link_1_6.DESCRIZ AS DESCRIZ106";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_6","CODDIPE","CODDIP");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_6","CODDIPE","CODDIP",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_6 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_8(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_8.RAPPORTO AS RAPPORTO108";
        m_cSelect = m_cSelect+" ,link_1_8.DESCRAP AS DESCRAP108";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_8","RAPPORTO","RAPPORTO");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_8","RAPPORTO","RAPPORTO",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_8 = true;
          m_nColumns = m_nColumns+2;
        }
      }
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
  public armt_cgo_telematico_errBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_cgo_telematico_err");
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
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_cgo_telematico_err,m_cPhName_cgo_telematico_err,m_cVirtName_cgo_telematico_err,m_cVirtName_cgo_telematico_err+".SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_SNAINUMOPE,"C",15,0),m_cServer_cgo_telematico_err,p_SNAINUMOPE),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_6(m_cPhName_anadip,m_cServer_anadip);
    l_oSqlLoader.AddJoinedLink_1_8(m_cPhName_knarapbo,m_cServer_knarapbo);
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
        w_xdesdip = "";
        w_xdesrap = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_SNAINUMOPE = l_rsLoad.GetString("SNAINUMOPE");
        w_ENV = l_rsLoad.GetString("ENV");
        w_CODDIPE = l_rsLoad.GetString("CODDIPE");
        if (l_oSqlLoader.m_bLink_1_6) {
          w_xdesdip = l_rsLoad.GetString("DESCRIZ106");
        } else {
          Link_YMJRPKIKSX("Load");
        }
        w_RAPPORTO = l_rsLoad.GetString("RAPPORTO");
        if (l_oSqlLoader.m_bLink_1_8) {
          w_xdesrap = l_rsLoad.GetString("DESCRAP108");
        } else {
          Link_DSKEQYLWDR("Load");
        }
        w_TOTLIRE = l_rsLoad.GetDouble("TOTLIRE");
        w_CADATAORA = l_rsLoad.GetDateTime("CADATAORA");
        w_CAIDBIGLIETTO = l_rsLoad.GetString("CAIDBIGLIETTO");
        w_CSMF_COD = l_rsLoad.GetDouble("CSMF_COD");
        w_NUM_CONC = l_rsLoad.GetDouble("NUM_CONC");
        w_P_VEND = l_rsLoad.GetDouble("P_VEND");
        w_IPCOLLEG = l_rsLoad.GetString("IPCOLLEG");
        w_ORACOLLEG = l_rsLoad.GetDateTime("ORACOLLEG");
        w_DUCOLLEG = l_rsLoad.GetDouble("DUCOLLEG");
        w_TXTERR = l_rsLoad.GetString("TXTERR");
        w_MEZPAGAM = l_rsLoad.GetString("MEZPAGAM");
        w_IBAN = l_rsLoad.GetString("IBAN");
        w_CACODICE = l_rsLoad.GetDouble("CACODICE");
        w_FLGFULL = l_rsLoad.GetString("FLGFULL");
        w_CATIPGIO = l_rsLoad.GetDouble("CATIPGIO");
        w_CATIPCON = l_rsLoad.GetDouble("CATIPCON");
        w_CAPV_COD = l_rsLoad.GetDouble("CAPV_COD");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_telematico_err")) {
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_telematico_err);
      l_cSql = "insert into "+m_oWrInfo_cgo_telematico_err.GetTableWriteName()+" (";
      l_cSql = l_cSql+"SNAINUMOPE,";
      l_cSql = l_cSql+"ENV,";
      l_cSql = l_cSql+"CODDIPE,";
      l_cSql = l_cSql+"RAPPORTO,";
      l_cSql = l_cSql+"TOTLIRE,";
      l_cSql = l_cSql+"CADATAORA,";
      l_cSql = l_cSql+"CAIDBIGLIETTO,";
      l_cSql = l_cSql+"CSMF_COD,";
      l_cSql = l_cSql+"NUM_CONC,";
      l_cSql = l_cSql+"P_VEND,";
      l_cSql = l_cSql+"IPCOLLEG,";
      l_cSql = l_cSql+"ORACOLLEG,";
      l_cSql = l_cSql+"DUCOLLEG,";
      l_cSql = l_cSql+"TXTERR,";
      l_cSql = l_cSql+"MEZPAGAM,";
      l_cSql = l_cSql+"IBAN,";
      l_cSql = l_cSql+"CACODICE,";
      l_cSql = l_cSql+"FLGFULL,";
      l_cSql = l_cSql+"CATIPGIO,";
      l_cSql = l_cSql+"CATIPCON,";
      l_cSql = l_cSql+"CAPV_COD,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_telematico_err.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_telematico_err")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_SNAINUMOPE,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ENV,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODDIPE,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_RAPPORTO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TOTLIRE,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CADATAORA,"T",14,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAIDBIGLIETTO,"C",28,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CSMF_COD,"N",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUM_CONC,"N",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_P_VEND,"N",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IPCOLLEG,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ORACOLLEG,"T",14,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DUCOLLEG,"N",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TXTERR,"M",10,0,m_cServer_cgo_telematico_err,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MEZPAGAM,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IBAN,"C",27,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CACODICE,"N",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGFULL,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CATIPGIO,"N",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CATIPCON,"N",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAPV_COD,"N",10,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_telematico_err.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_telematico_err")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_telematico_err,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_telematico_err);
      l_cSql = "Update "+m_oWrInfo_cgo_telematico_err.GetTableWriteName()+" set";
      l_cSql = l_cSql+" ENV = "+CPLib.ToSQL(w_ENV,"C",1,0);
      l_cSql = l_cSql+", CODDIPE = "+CPLib.ToSQLNull(w_CODDIPE,"C",6,0);
      l_cSql = l_cSql+", RAPPORTO = "+CPLib.ToSQLNull(w_RAPPORTO,"C",25,0);
      l_cSql = l_cSql+", TOTLIRE = "+CPLib.ToSQL(w_TOTLIRE,"N",15,2);
      l_cSql = l_cSql+", CADATAORA = "+CPLib.ToSQL(w_CADATAORA,"T",14,0);
      l_cSql = l_cSql+", CAIDBIGLIETTO = "+CPLib.ToSQL(w_CAIDBIGLIETTO,"C",28,0);
      l_cSql = l_cSql+", CSMF_COD = "+CPLib.ToSQL(w_CSMF_COD,"N",11,0);
      l_cSql = l_cSql+", NUM_CONC = "+CPLib.ToSQL(w_NUM_CONC,"N",11,0);
      l_cSql = l_cSql+", P_VEND = "+CPLib.ToSQL(w_P_VEND,"N",11,0);
      l_cSql = l_cSql+", IPCOLLEG = "+CPLib.ToSQL(w_IPCOLLEG,"C",20,0);
      l_cSql = l_cSql+", ORACOLLEG = "+CPLib.ToSQL(w_ORACOLLEG,"T",14,0);
      l_cSql = l_cSql+", DUCOLLEG = "+CPLib.ToSQL(w_DUCOLLEG,"N",10,0);
      l_cSql = l_cSql+", TXTERR = "+CPLib.ToSQL(w_TXTERR,"M",10,0,m_cServer_cgo_telematico_err,m_oParameters);
      l_cSql = l_cSql+", MEZPAGAM = "+CPLib.ToSQL(w_MEZPAGAM,"C",1,0);
      l_cSql = l_cSql+", IBAN = "+CPLib.ToSQL(w_IBAN,"C",27,0);
      l_cSql = l_cSql+", CACODICE = "+CPLib.ToSQL(w_CACODICE,"N",5,0);
      l_cSql = l_cSql+", FLGFULL = "+CPLib.ToSQL(w_FLGFULL,"C",1,0);
      l_cSql = l_cSql+", CATIPGIO = "+CPLib.ToSQL(w_CATIPGIO,"N",5,0);
      l_cSql = l_cSql+", CATIPCON = "+CPLib.ToSQL(w_CATIPCON,"N",5,0);
      l_cSql = l_cSql+", CAPV_COD = "+CPLib.ToSQL(w_CAPV_COD,"N",10,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_telematico_err")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"C",15,0),m_cServer_cgo_telematico_err,w_SNAINUMOPE);
      l_cSql = l_cSql+m_oWrInfo_cgo_telematico_err.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_telematico_err")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_telematico_err,l_cSql,m_oParameters);
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
          l_cSql = "Delete from "+m_oWrInfo_cgo_telematico_err.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"C",15,0),m_cServer_cgo_telematico_err,w_SNAINUMOPE);
          l_cSql = l_cSql+m_oWrInfo_cgo_telematico_err.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_telematico_err")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_telematico_err,l_cSql);
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
    if (CPLib.eq(p_cID,"YMJRPKIKSX")) {
      result.m_TableName = "anadip";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODDIP" , "DESCRIZ"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("YMJRPKIKSX",CPLib.GetLinkedFieldProps("CODDIP","CODDIPE","C",6,0));
    } else if (CPLib.eq(p_cID,"DSKEQYLWDR")) {
      result.m_TableName = "knarapbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAPPORTO" , "DESCRAP"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("DSKEQYLWDR",CPLib.GetLinkedFieldProps("RAPPORTO","RAPPORTO","C",25,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_chkiban,arrt_save_cgo_telematico_err,
  public static final String i_InvokedRoutines = ",arfn_chkiban,arrt_save_cgo_telematico_err,";
}
