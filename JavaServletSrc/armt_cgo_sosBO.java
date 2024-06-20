// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_cgo_sosBO extends armt_cgo_sosBL {
  class SqlLoader {
    public boolean m_bLink_1_6 = false;
    public boolean m_bLink_1_34 = false;
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
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_6","SOSCODDIP","CODDIP");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_6","SOSCODDIP","CODDIP",true);
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
    public void AddJoinedLink_1_34(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_34.CODSTA AS CODSTA134";
        m_cSelect = m_cSelect+" ,link_1_34.DESCRI AS DESCRI134";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_34","SOSCLIEPAE","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_34","SOSCLIEPAE","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_34 = true;
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
  public armt_cgo_sosBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_cgo_sos");
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
  public static String[] m_cLoadParameterNames = {"SOSCODICE"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(double p_SOSCODICE) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_cgo_sos,m_cPhName_cgo_sos,m_cVirtName_cgo_sos,m_cVirtName_cgo_sos+".SOSCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_SOSCODICE,"N",10,0),m_cServer_cgo_sos,p_SOSCODICE),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_6(m_cPhName_anadip,m_cServer_anadip);
    l_oSqlLoader.AddJoinedLink_1_34(m_cPhName_tbstati,m_cServer_tbstati);
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
        w_gCodDip = m_Ctx.GetGlobalString("gCodDip");
        w_IDBIGLIETTO = "";
        w_xdesdip = "";
        w_gUserCode = m_Ctx.GetGlobalNumber("gUserCode");
        w_xDESSTATO = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_SOSCODICE = l_rsLoad.GetDouble("SOSCODICE");
        op_SOSCODICE = w_SOSCODICE;
        w_SOSCODDIP = l_rsLoad.GetString("SOSCODDIP");
        if (l_oSqlLoader.m_bLink_1_6) {
          w_xdesdip = l_rsLoad.GetString("DESCRIZ106");
        } else {
          Link_DHBRXDCHIH("Load");
        }
        w_SOSSEGNANT = l_rsLoad.GetString("SOSSEGNANT");
        w_SOSSEGNAFAX = l_rsLoad.GetString("SOSSEGNAFAX");
        w_SOSSEGNAEM = l_rsLoad.GetString("SOSSEGNAEM");
        w_SOSSEGNACF = l_rsLoad.GetString("SOSSEGNACF");
        w_SOSSEGNACOG = l_rsLoad.GetString("SOSSEGNACOG");
        w_SOSSEGNANOM = l_rsLoad.GetString("SOSSEGNANOM");
        w_SOSSEGNALN = l_rsLoad.GetString("SOSSEGNALN");
        // Link con tbluonas non eseguito: riporta solo campi
        w_SOSSEGNADN = l_rsLoad.GetDate("SOSSEGNADN");
        w_SOSSEGNASX = l_rsLoad.GetString("SOSSEGNASX");
        w_SOSSTATOOP = l_rsLoad.GetString("SOSSTATOOP");
        Link_UXJUHWBCMH("Load");
        w_SOSDATAOP = l_rsLoad.GetDate("SOSDATAOP");
        w_SOSTIPOOP = l_rsLoad.GetString("SOSTIPOOP");
        w_SOSIMPOPE = l_rsLoad.GetDouble("SOSIMPOPE");
        w_SOSMEZPAG = l_rsLoad.GetString("SOSMEZPAG");
        w_SOSNUMBON = l_rsLoad.GetString("SOSNUMBON");
        w_SOSBANASS = l_rsLoad.GetString("SOSBANASS");
        w_SOSNUMASS = l_rsLoad.GetString("SOSNUMASS");
        w_SOSDESOPE = l_rsLoad.GetString("SOSDESOPE");
        w_SOSMOTSOS = l_rsLoad.GetString("SOSMOTSOS");
        w_SOSCLIECOG = l_rsLoad.GetString("SOSCLIECOG");
        w_SOSCLIENOM = l_rsLoad.GetString("SOSCLIENOM");
        w_SOSCLIELN = l_rsLoad.GetString("SOSCLIELN");
        // Link con tbluonas non eseguito: riporta solo campi
        w_SOSCLIEDN = l_rsLoad.GetDate("SOSCLIEDN");
        w_SOSCLIESX = l_rsLoad.GetString("SOSCLIESX");
        w_SOSCLIECF = l_rsLoad.GetString("SOSCLIECF");
        w_SOSCLIEPAE = l_rsLoad.GetString("SOSCLIEPAE");
        if (l_oSqlLoader.m_bLink_1_34) {
          w_xDESSTATO = l_rsLoad.GetString("DESCRI134");
        } else {
          Link_CQREEAUGJZ("Load");
        }
        w_SOSCLIECR = l_rsLoad.GetString("SOSCLIECR");
        // Link con tbcitta non eseguito: riporta solo campi
        w_SOSCLIEIND = l_rsLoad.GetString("SOSCLIEIND");
        w_SOSCLIECAR = l_rsLoad.GetString("SOSCLIECAR");
        w_SOSCLIETD = l_rsLoad.GetString("SOSCLIETD");
        w_SOSCLIEND = l_rsLoad.GetString("SOSCLIEND");
        w_SOSCLIEDRD = l_rsLoad.GetDate("SOSCLIEDRD");
        w_SOSCLIEDSD = l_rsLoad.GetDate("SOSCLIEDSD");
        w_SOSCLIEAUD = l_rsLoad.GetString("SOSCLIEAUD");
        w_SOSSEGNAPN = l_rsLoad.GetString("SOSSEGNAPN");
        w_SOSCLIEPN = l_rsLoad.GetString("SOSCLIEPN");
        w_SOSCLIEPR = l_rsLoad.GetString("SOSCLIEPR");
        w_SOSUTENTE = l_rsLoad.GetDouble("SOSUTENTE");
        w_SOSDATSEG = l_rsLoad.GetDate("SOSDATSEG");
        // Assegna i valori degli op_
        op_codazi = m_Ctx.GetCompany();
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_sos")) {
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
    return Load(w_SOSCODICE);
  }
  void Insert() {
    String l_cSql;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    double l_nUpdatedRows;
    // * --- Area Manuale = BO - Insert Init
    // * --- Fine Area Manuale
    // Aggiornamento dei progressivi
    SaveAutonumber();
    // * --- Area Manuale = BO - Autonum Assigned
    // * --- Fine Area Manuale
    NotifyEvent("Insert start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_sos);
      l_cSql = "insert into "+m_oWrInfo_cgo_sos.GetTableWriteName()+" (";
      l_cSql = l_cSql+"SOSCODICE,";
      l_cSql = l_cSql+"SOSCODDIP,";
      l_cSql = l_cSql+"SOSSEGNANT,";
      l_cSql = l_cSql+"SOSSEGNAFAX,";
      l_cSql = l_cSql+"SOSSEGNAEM,";
      l_cSql = l_cSql+"SOSSEGNACF,";
      l_cSql = l_cSql+"SOSSEGNACOG,";
      l_cSql = l_cSql+"SOSSEGNANOM,";
      l_cSql = l_cSql+"SOSSEGNALN,";
      l_cSql = l_cSql+"SOSSEGNADN,";
      l_cSql = l_cSql+"SOSSEGNASX,";
      l_cSql = l_cSql+"SOSSTATOOP,";
      l_cSql = l_cSql+"SOSDATAOP,";
      l_cSql = l_cSql+"SOSTIPOOP,";
      l_cSql = l_cSql+"SOSIMPOPE,";
      l_cSql = l_cSql+"SOSMEZPAG,";
      l_cSql = l_cSql+"SOSNUMBON,";
      l_cSql = l_cSql+"SOSBANASS,";
      l_cSql = l_cSql+"SOSNUMASS,";
      l_cSql = l_cSql+"SOSDESOPE,";
      l_cSql = l_cSql+"SOSMOTSOS,";
      l_cSql = l_cSql+"SOSCLIECOG,";
      l_cSql = l_cSql+"SOSCLIENOM,";
      l_cSql = l_cSql+"SOSCLIELN,";
      l_cSql = l_cSql+"SOSCLIEDN,";
      l_cSql = l_cSql+"SOSCLIESX,";
      l_cSql = l_cSql+"SOSCLIECF,";
      l_cSql = l_cSql+"SOSCLIEPAE,";
      l_cSql = l_cSql+"SOSCLIECR,";
      l_cSql = l_cSql+"SOSCLIEIND,";
      l_cSql = l_cSql+"SOSCLIECAR,";
      l_cSql = l_cSql+"SOSCLIETD,";
      l_cSql = l_cSql+"SOSCLIEND,";
      l_cSql = l_cSql+"SOSCLIEDRD,";
      l_cSql = l_cSql+"SOSCLIEDSD,";
      l_cSql = l_cSql+"SOSCLIEAUD,";
      l_cSql = l_cSql+"SOSSEGNAPN,";
      l_cSql = l_cSql+"SOSCLIEPN,";
      l_cSql = l_cSql+"SOSCLIEPR,";
      l_cSql = l_cSql+"SOSUTENTE,";
      l_cSql = l_cSql+"SOSDATSEG,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_sos.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_sos")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCODICE,"N",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_SOSCODDIP,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSSEGNANT,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSSEGNAFAX,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSSEGNAEM,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSSEGNACF,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSSEGNACOG,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSSEGNANOM,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_SOSSEGNALN,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSSEGNADN,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSSEGNASX,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSSTATOOP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSDATAOP,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSTIPOOP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSIMPOPE,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSMEZPAG,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSNUMBON,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSBANASS,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSNUMASS,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSDESOPE,"M",10,0,m_cServer_cgo_sos,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSMOTSOS,"M",10,0,m_cServer_cgo_sos,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCLIECOG,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCLIENOM,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_SOSCLIELN,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCLIEDN,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCLIESX,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCLIECF,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_SOSCLIEPAE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCLIECR,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCLIEIND,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCLIECAR,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCLIETD,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCLIEND,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCLIEDRD,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCLIEDSD,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCLIEAUD,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSSEGNAPN,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCLIEPN,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSCLIEPR,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSUTENTE,"N",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SOSDATSEG,"D",8,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cgo_sos.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_sos")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_sos,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cgo_sos);
      l_cSql = "Update "+m_oWrInfo_cgo_sos.GetTableWriteName()+" set";
      l_cSql = l_cSql+" SOSCODDIP = "+CPLib.ToSQLNull(w_SOSCODDIP,"C",6,0);
      l_cSql = l_cSql+", SOSSEGNANT = "+CPLib.ToSQL(w_SOSSEGNANT,"C",15,0);
      l_cSql = l_cSql+", SOSSEGNAFAX = "+CPLib.ToSQL(w_SOSSEGNAFAX,"C",15,0);
      l_cSql = l_cSql+", SOSSEGNAEM = "+CPLib.ToSQL(w_SOSSEGNAEM,"C",40,0);
      l_cSql = l_cSql+", SOSSEGNACF = "+CPLib.ToSQL(w_SOSSEGNACF,"C",16,0);
      l_cSql = l_cSql+", SOSSEGNACOG = "+CPLib.ToSQL(w_SOSSEGNACOG,"C",30,0);
      l_cSql = l_cSql+", SOSSEGNANOM = "+CPLib.ToSQL(w_SOSSEGNANOM,"C",30,0);
      l_cSql = l_cSql+", SOSSEGNALN = "+CPLib.ToSQLNull(w_SOSSEGNALN,"C",50,0);
      l_cSql = l_cSql+", SOSSEGNADN = "+CPLib.ToSQL(w_SOSSEGNADN,"D",8,0);
      l_cSql = l_cSql+", SOSSEGNASX = "+CPLib.ToSQL(w_SOSSEGNASX,"C",1,0);
      l_cSql = l_cSql+", SOSSTATOOP = "+CPLib.ToSQL(w_SOSSTATOOP,"C",1,0);
      l_cSql = l_cSql+", SOSDATAOP = "+CPLib.ToSQL(w_SOSDATAOP,"D",8,0);
      l_cSql = l_cSql+", SOSTIPOOP = "+CPLib.ToSQL(w_SOSTIPOOP,"C",1,0);
      l_cSql = l_cSql+", SOSIMPOPE = "+CPLib.ToSQL(w_SOSIMPOPE,"N",15,2);
      l_cSql = l_cSql+", SOSMEZPAG = "+CPLib.ToSQL(w_SOSMEZPAG,"C",1,0);
      l_cSql = l_cSql+", SOSNUMBON = "+CPLib.ToSQL(w_SOSNUMBON,"C",30,0);
      l_cSql = l_cSql+", SOSBANASS = "+CPLib.ToSQL(w_SOSBANASS,"C",50,0);
      l_cSql = l_cSql+", SOSNUMASS = "+CPLib.ToSQL(w_SOSNUMASS,"C",30,0);
      l_cSql = l_cSql+", SOSDESOPE = "+CPLib.ToSQL(w_SOSDESOPE,"M",10,0,m_cServer_cgo_sos,m_oParameters);
      l_cSql = l_cSql+", SOSMOTSOS = "+CPLib.ToSQL(w_SOSMOTSOS,"M",10,0,m_cServer_cgo_sos,m_oParameters);
      l_cSql = l_cSql+", SOSCLIECOG = "+CPLib.ToSQL(w_SOSCLIECOG,"C",30,0);
      l_cSql = l_cSql+", SOSCLIENOM = "+CPLib.ToSQL(w_SOSCLIENOM,"C",30,0);
      l_cSql = l_cSql+", SOSCLIELN = "+CPLib.ToSQLNull(w_SOSCLIELN,"C",50,0);
      l_cSql = l_cSql+", SOSCLIEDN = "+CPLib.ToSQL(w_SOSCLIEDN,"D",8,0);
      l_cSql = l_cSql+", SOSCLIESX = "+CPLib.ToSQL(w_SOSCLIESX,"C",1,0);
      l_cSql = l_cSql+", SOSCLIECF = "+CPLib.ToSQL(w_SOSCLIECF,"C",16,0);
      l_cSql = l_cSql+", SOSCLIEPAE = "+CPLib.ToSQLNull(w_SOSCLIEPAE,"C",3,0);
      l_cSql = l_cSql+", SOSCLIECR = "+CPLib.ToSQL(w_SOSCLIECR,"C",50,0);
      l_cSql = l_cSql+", SOSCLIEIND = "+CPLib.ToSQL(w_SOSCLIEIND,"C",50,0);
      l_cSql = l_cSql+", SOSCLIECAR = "+CPLib.ToSQL(w_SOSCLIECAR,"C",5,0);
      l_cSql = l_cSql+", SOSCLIETD = "+CPLib.ToSQL(w_SOSCLIETD,"C",2,0);
      l_cSql = l_cSql+", SOSCLIEND = "+CPLib.ToSQL(w_SOSCLIEND,"C",15,0);
      l_cSql = l_cSql+", SOSCLIEDRD = "+CPLib.ToSQL(w_SOSCLIEDRD,"D",8,0);
      l_cSql = l_cSql+", SOSCLIEDSD = "+CPLib.ToSQL(w_SOSCLIEDSD,"D",8,0);
      l_cSql = l_cSql+", SOSCLIEAUD = "+CPLib.ToSQL(w_SOSCLIEAUD,"C",50,0);
      l_cSql = l_cSql+", SOSSEGNAPN = "+CPLib.ToSQL(w_SOSSEGNAPN,"C",2,0);
      l_cSql = l_cSql+", SOSCLIEPN = "+CPLib.ToSQL(w_SOSCLIEPN,"C",2,0);
      l_cSql = l_cSql+", SOSCLIEPR = "+CPLib.ToSQL(w_SOSCLIEPR,"C",2,0);
      l_cSql = l_cSql+", SOSUTENTE = "+CPLib.ToSQL(w_SOSUTENTE,"N",10,0);
      l_cSql = l_cSql+", SOSDATSEG = "+CPLib.ToSQL(w_SOSDATSEG,"D",8,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_sos")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"SOSCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SOSCODICE,"N",10,0),m_cServer_cgo_sos,w_SOSCODICE);
      l_cSql = l_cSql+m_oWrInfo_cgo_sos.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_sos")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_sos,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(double p_SOSCODICE) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_SOSCODICE);
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
          l_cSql = "Delete from "+m_oWrInfo_cgo_sos.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"SOSCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SOSCODICE,"N",10,0),m_cServer_cgo_sos,w_SOSCODICE);
          l_cSql = l_cSql+m_oWrInfo_cgo_sos.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"cgo_sos")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_cgo_sos,l_cSql);
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
    return Delete(w_SOSCODICE);
  }
  void SaveAutonumber() {
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    m_Sql.NextTableProg(this,"PRGSEGSOS","i_codazi,w_SOSCODICE",m_cServer_cgo_sos,m_Ctx.GetCompany());
    op_SOSCODICE = w_SOSCODICE;
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"DHBRXDCHIH")) {
      result.m_TableName = "anadip";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_anadip";
      result.m_rdField = new String[]{"CODDIP" , "DESCRIZ"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("DHBRXDCHIH",CPLib.GetLinkedFieldProps("CODDIP","SOSCODDIP","C",6,0),CPLib.GetLinkedFieldProps("DESCRIZ","xdesdip","C",30,0));
    } else if (CPLib.eq(p_cID,"NMTFLCHLGD")) {
      result.m_TableName = "tbluonas";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"DESCRI" , "PROVINCIA"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NMTFLCHLGD",CPLib.GetLinkedFieldProps("DESCRI","SOSSEGNALN","C",50,0));
    } else if (CPLib.eq(p_cID,"UXJUHWBCMH")) {
      result.m_TableName = "cgo_operazioni_storico";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CAIDBIGLIETTO"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("UXJUHWBCMH",CPLib.GetLinkedFieldProps("CAIDBIGLIETTO","IDBIGLIETTO","C",28,0));
      result.AppendFilter("CODDIPE","C","=",true);
    } else if (CPLib.eq(p_cID,"EKWIYNRJCN")) {
      result.m_TableName = "tbluonas";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"DESCRI" , "PROVINCIA"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("EKWIYNRJCN",CPLib.GetLinkedFieldProps("DESCRI","SOSCLIELN","C",50,0));
    } else if (CPLib.eq(p_cID,"CQREEAUGJZ")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_SuggestRows = 10;
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("CQREEAUGJZ",CPLib.GetLinkedFieldProps("CODSTA","SOSCLIEPAE","C",3,0));
    } else if (CPLib.eq(p_cID,"RNXXROADTV")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_SuggestRows = 10;
      result.m_rdField = new String[]{"CITTA" , "PROV"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("RNXXROADTV",CPLib.GetLinkedFieldProps("CITTA","SOSCLIECR","C",50,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_cgo_chkdata,arrt_cgo_sos_biglietto,arrt_cgo_sos_email,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_cgo_chkdata,arrt_cgo_sos_biglietto,arrt_cgo_sos_email,arrt_writelog,";
}
