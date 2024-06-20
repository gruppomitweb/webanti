// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_cgo_personboBO extends armt_cgo_personboBL {
  class SqlLoader {
    public boolean m_bLink_1_8 = false;
    public boolean m_bLink_1_20 = false;
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
    public void AddJoinedLink_1_8(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_8.CODSTA AS CODSTA108";
        m_cSelect = m_cSelect+" ,link_1_8.DESCRI AS DESCRI108";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_8","PAESE","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_8","PAESE","CODSTA",true);
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
    public void AddJoinedLink_1_20(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_20.TIPDOC AS TIPDOC120";
        m_cSelect = m_cSelect+" ,link_1_20.DESCRI AS DESCRI120";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_20","TIPODOC","TIPDOC");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_20","TIPODOC","TIPDOC",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_20 = true;
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
  public armt_cgo_personboBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_cgo_personbo");
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
  public static String[] m_cLoadParameterNames = {"PRGSOG"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_PRGSOG) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_cgo_soggetti_err,m_cPhName_cgo_soggetti_err,m_cVirtName_cgo_soggetti_err,m_cVirtName_cgo_soggetti_err+".PRGSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_PRGSOG,"C",15,0),m_cServer_cgo_soggetti_err,p_PRGSOG),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_8(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_1_20(m_cPhName_tbtipdoc,m_cServer_tbtipdoc);
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
        w_dessta = "";
        w_DESCRI = "";
        w_CODCAB = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_COGNOME = l_rsLoad.GetString("COGNOME");
        w_NOME = l_rsLoad.GetString("NOME");
        w_CFESTERO = l_rsLoad.GetDouble("CFESTERO");
        w_PAESE = l_rsLoad.GetString("PAESE");
        if (l_oSqlLoader.m_bLink_1_8) {
          w_dessta = l_rsLoad.GetString("DESCRI108");
        } else {
          Link_YVIKEGPYPM("Load");
        }
        w_DESCCIT = l_rsLoad.GetString("DESCCIT");
        w_PROVINCIA = "";
        w_CAP = "";
        w_CODCAB = "";
        Link_ODAYKSRECA("Load");
        w_PROVINCIA = l_rsLoad.GetString("PROVINCIA");
        w_CAP = l_rsLoad.GetString("CAP");
        w_DOMICILIO = l_rsLoad.GetString("DOMICILIO");
        w_IDCITTANA = l_rsLoad.GetString("IDCITTANA");
        // Link con tbcittna non eseguito: riporta solo campi
        w_nascomunid = w_IDCITTANA;
        w_NASCOMUN = "";
        w_NASPROV = "";
        Link_ZRIWLTGERM("Load");
        w_NASCOMUN = l_rsLoad.GetString("NASCOMUN");
        w_NASPROV = l_rsLoad.GetString("NASPROV");
        w_SESSO = l_rsLoad.GetString("SESSO");
        w_NASSTATO = l_rsLoad.GetString("NASSTATO");
        // Link con tbstatna non eseguito: riporta solo campi
        w_DATANASC = l_rsLoad.GetDate("DATANASC");
        w_TIPODOC = l_rsLoad.GetString("TIPODOC");
        if (l_oSqlLoader.m_bLink_1_20) {
          w_DESCRI = l_rsLoad.GetString("DESCRI120");
        } else {
          Link_MBGANUUHRA("Load");
        }
        w_NUMDOCUM = l_rsLoad.GetString("NUMDOCUM");
        w_DATARILASC = l_rsLoad.GetDate("DATARILASC");
        w_DATAVALI = l_rsLoad.GetDate("DATAVALI");
        w_AUTRILASC = l_rsLoad.GetString("AUTRILASC");
        w_CONNES = l_rsLoad.GetString("CONNES");
        w_PEP = l_rsLoad.GetString("PEP");
        w_TXTERR = l_rsLoad.GetString("TXTERR");
        w_PRGSOG = l_rsLoad.GetString("PRGSOG");
        w_FLGFULL = l_rsLoad.GetString("FLGFULL");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_soggetti_err")) {
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
    return Load(w_PRGSOG);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_soggetti_err);
      l_cSql = "insert into "+m_oWrInfo_cgo_soggetti_err.GetTableWriteName()+" (";
      l_cSql = l_cSql+"COGNOME,";
      l_cSql = l_cSql+"NOME,";
      l_cSql = l_cSql+"CFESTERO,";
      l_cSql = l_cSql+"PAESE,";
      l_cSql = l_cSql+"DESCCIT,";
      l_cSql = l_cSql+"PROVINCIA,";
      l_cSql = l_cSql+"CAP,";
      l_cSql = l_cSql+"DOMICILIO,";
      l_cSql = l_cSql+"IDCITTANA,";
      l_cSql = l_cSql+"NASCOMUN,";
      l_cSql = l_cSql+"NASPROV,";
      l_cSql = l_cSql+"SESSO,";
      l_cSql = l_cSql+"NASSTATO,";
      l_cSql = l_cSql+"DATANASC,";
      l_cSql = l_cSql+"TIPODOC,";
      l_cSql = l_cSql+"NUMDOCUM,";
      l_cSql = l_cSql+"DATARILASC,";
      l_cSql = l_cSql+"DATAVALI,";
      l_cSql = l_cSql+"AUTRILASC,";
      l_cSql = l_cSql+"CONNES,";
      l_cSql = l_cSql+"PEP,";
      l_cSql = l_cSql+"TXTERR,";
      l_cSql = l_cSql+"PRGSOG,";
      l_cSql = l_cSql+"FLGFULL,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_soggetti_err.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_soggetti_err")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_COGNOME,"C",26,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOME,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CFESTERO,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_PAESE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCCIT,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROVINCIA,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAP,"C",9,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DOMICILIO,"C",35,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDCITTANA,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NASCOMUN,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NASPROV,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SESSO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NASSTATO,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATANASC,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPODOC,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMDOCUM,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATARILASC,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAVALI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AUTRILASC,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONNES,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PEP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TXTERR,"M",10,0,m_cServer_cgo_soggetti_err,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PRGSOG,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGFULL,"C",1,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_soggetti_err.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_soggetti_err")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_soggetti_err,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_soggetti_err);
      l_cSql = "Update "+m_oWrInfo_cgo_soggetti_err.GetTableWriteName()+" set";
      l_cSql = l_cSql+" COGNOME = "+CPLib.ToSQL(w_COGNOME,"C",26,0);
      l_cSql = l_cSql+", NOME = "+CPLib.ToSQL(w_NOME,"C",25,0);
      l_cSql = l_cSql+", CFESTERO = "+CPLib.ToSQL(w_CFESTERO,"N",1,0);
      l_cSql = l_cSql+", PAESE = "+CPLib.ToSQLNull(w_PAESE,"C",3,0);
      l_cSql = l_cSql+", DESCCIT = "+CPLib.ToSQL(w_DESCCIT,"C",30,0);
      l_cSql = l_cSql+", PROVINCIA = "+CPLib.ToSQL(w_PROVINCIA,"C",2,0);
      l_cSql = l_cSql+", CAP = "+CPLib.ToSQL(w_CAP,"C",9,0);
      l_cSql = l_cSql+", DOMICILIO = "+CPLib.ToSQL(w_DOMICILIO,"C",35,0);
      l_cSql = l_cSql+", IDCITTANA = "+CPLib.ToSQL(w_IDCITTANA,"C",40,0);
      l_cSql = l_cSql+", NASCOMUN = "+CPLib.ToSQL(w_NASCOMUN,"C",30,0);
      l_cSql = l_cSql+", NASPROV = "+CPLib.ToSQL(w_NASPROV,"C",2,0);
      l_cSql = l_cSql+", SESSO = "+CPLib.ToSQL(w_SESSO,"C",1,0);
      l_cSql = l_cSql+", NASSTATO = "+CPLib.ToSQL(w_NASSTATO,"C",30,0);
      l_cSql = l_cSql+", DATANASC = "+CPLib.ToSQL(w_DATANASC,"D",8,0);
      l_cSql = l_cSql+", TIPODOC = "+CPLib.ToSQLNull(w_TIPODOC,"C",2,0);
      l_cSql = l_cSql+", NUMDOCUM = "+CPLib.ToSQL(w_NUMDOCUM,"C",15,0);
      l_cSql = l_cSql+", DATARILASC = "+CPLib.ToSQL(w_DATARILASC,"D",8,0);
      l_cSql = l_cSql+", DATAVALI = "+CPLib.ToSQL(w_DATAVALI,"D",8,0);
      l_cSql = l_cSql+", AUTRILASC = "+CPLib.ToSQL(w_AUTRILASC,"C",30,0);
      l_cSql = l_cSql+", CONNES = "+CPLib.ToSQL(w_CONNES,"C",16,0);
      l_cSql = l_cSql+", PEP = "+CPLib.ToSQL(w_PEP,"C",1,0);
      l_cSql = l_cSql+", TXTERR = "+CPLib.ToSQL(w_TXTERR,"M",10,0,m_cServer_cgo_soggetti_err,m_oParameters);
      l_cSql = l_cSql+", FLGFULL = "+CPLib.ToSQL(w_FLGFULL,"C",1,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_soggetti_err")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"PRGSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_PRGSOG,"C",15,0),m_cServer_cgo_soggetti_err,w_PRGSOG);
      l_cSql = l_cSql+m_oWrInfo_cgo_soggetti_err.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_soggetti_err")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_soggetti_err,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_PRGSOG) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_PRGSOG);
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
          l_cSql = "Delete from "+m_oWrInfo_cgo_soggetti_err.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"PRGSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_PRGSOG,"C",15,0),m_cServer_cgo_soggetti_err,w_PRGSOG);
          l_cSql = l_cSql+m_oWrInfo_cgo_soggetti_err.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_soggetti_err")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_soggetti_err,l_cSql);
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
    return Delete(w_PRGSOG);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"YVIKEGPYPM")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("YVIKEGPYPM",CPLib.GetLinkedFieldProps("CODSTA","PAESE","C",3,0));
    } else if (CPLib.eq(p_cID,"ODAYKSRECA")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_SuggestRows = 10;
      result.m_rdField = new String[]{"CITTA" , "PROV" , "CAP" , "CAB"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ODAYKSRECA",CPLib.GetLinkedFieldProps("CITTA","DESCCIT","C",30,0));
    } else if (CPLib.eq(p_cID,"BYPEBFEOAJ")) {
      result.m_TableName = "tbcittna";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"IDBASE"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("BYPEBFEOAJ",CPLib.GetLinkedFieldProps("IDBASE","IDCITTANA","C",40,0));
    } else if (CPLib.eq(p_cID,"ZRIWLTGERM")) {
      result.m_TableName = "tbcittna";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"IDBASE" , "CITTA" , "PROV"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ZRIWLTGERM",CPLib.GetLinkedFieldProps("IDBASE","nascomunid","C",40,0));
    } else if (CPLib.eq(p_cID,"HODZKKOSYW")) {
      result.m_TableName = "tbstatna";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_SuggestRows = 10;
      result.m_rdField = new String[]{"DESCRI"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("HODZKKOSYW",CPLib.GetLinkedFieldProps("DESCRI","NASSTATO","C",30,0));
    } else if (CPLib.eq(p_cID,"MBGANUUHRA")) {
      result.m_TableName = "tbtipdoc";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"TIPDOC" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("MBGANUUHRA",CPLib.GetLinkedFieldProps("TIPDOC","TIPODOC","C",2,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_agechar,arfn_cgo_calccodfis,arfn_chkcodfis,arrt_calccodfis,arrt_cgo_read_flgope,arrt_save_cgo_soggetti_err,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_cgo_calccodfis,arfn_chkcodfis,arrt_calccodfis,arrt_cgo_read_flgope,arrt_save_cgo_soggetti_err,";
}
