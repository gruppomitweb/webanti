// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_personbo_aggBO extends armt_personbo_aggBL {
  class SqlLoader {
    public boolean m_bLink_1_12 = false;
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
    public void AddJoinedLink_1_12(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_12.CODSTA AS CODSTA112";
        m_cSelect = m_cSelect+" ,link_1_12.DESCRI AS DESCRI112";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_12","NAZIONE","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_12","NAZIONE","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_12 = true;
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
  public armt_personbo_aggBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_personbo_agg");
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
  public static String[] m_cLoadParameterNames = {"CONNES"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_CONNES) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_personbo_agg,m_cPhName_personbo_agg,m_cVirtName_personbo_agg,m_cVirtName_personbo_agg+".CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_CONNES,"C",16,0),m_cServer_personbo_agg,p_CONNES),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_12(m_cPhName_tbstati,m_cServer_tbstati);
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
        w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
        w_xDesNaz = "";
        w_xC1DESCRI = "";
        w_xC2DESCRI = "";
        w_xC3DESCRI = "";
        w_xC4DESCRI = "";
        w_xC5DESCRI = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_CONNES = l_rsLoad.GetString("CONNES");
        w_EMAIL = l_rsLoad.GetString("EMAIL");
        w_FLGEMAIL = l_rsLoad.GetString("FLGEMAIL");
        w_TELEFONO = l_rsLoad.GetString("TELEFONO");
        w_FLGVALIDO = l_rsLoad.GetString("FLGVALIDO");
        w_FLGANAVAL = l_rsLoad.GetString("FLGANAVAL");
        w_CLOCCUPA = l_rsLoad.GetDouble("CLOCCUPA");
        w_NAZIONE = l_rsLoad.GetString("NAZIONE");
        if (l_oSqlLoader.m_bLink_1_12) {
          w_xDesNaz = l_rsLoad.GetString("DESCRI112");
        } else {
          Link_BGFCAXGJBL("Load");
        }
        w_CLPRVDOM = l_rsLoad.GetString("CLPRVDOM");
        w_REGRES = l_rsLoad.GetString("REGRES");
        w_FLGBL = l_rsLoad.GetString("FLGBL");
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
        w_FLGPREGIUD = l_rsLoad.GetString("FLGPREGIUD");
        w_FLGTRUST = l_rsLoad.GetString("FLGTRUST");
        w_FLGRISCHIO = l_rsLoad.GetString("FLGRISCHIO");
        w_FLGFALSADIC = l_rsLoad.GetString("FLGFALSADIC");
        w_FLGEQUIFIN = l_rsLoad.GetString("FLGEQUIFIN");
        w_FLGRICINF = l_rsLoad.GetString("FLGRICINF");
        w_CATEGORIA = l_rsLoad.GetString("CATEGORIA");
        w_NUMCEL = l_rsLoad.GetString("NUMCEL");
        w_EMAIL = l_rsLoad.GetString("EMAIL");
        w_PEC = l_rsLoad.GetString("PEC");
        w_REFERENTE = l_rsLoad.GetString("REFERENTE");
        w_CONALTO = l_rsLoad.GetDouble("CONALTO");
        w_APPALTO = l_rsLoad.GetDouble("APPALTO");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"personbo_agg")) {
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
    return Load(w_CONNES);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_personbo_agg);
      l_cSql = "insert into "+m_oWrInfo_personbo_agg.GetTableWriteName()+" (";
      l_cSql = l_cSql+"CONNES,";
      l_cSql = l_cSql+"EMAIL,";
      l_cSql = l_cSql+"FLGEMAIL,";
      l_cSql = l_cSql+"TELEFONO,";
      l_cSql = l_cSql+"FLGVALIDO,";
      l_cSql = l_cSql+"FLGANAVAL,";
      l_cSql = l_cSql+"CLOCCUPA,";
      l_cSql = l_cSql+"NAZIONE,";
      l_cSql = l_cSql+"CLPRVDOM,";
      l_cSql = l_cSql+"REGRES,";
      l_cSql = l_cSql+"FLGBL,";
      l_cSql = l_cSql+"CATEG01,";
      l_cSql = l_cSql+"CATEG02,";
      l_cSql = l_cSql+"CATEG03,";
      l_cSql = l_cSql+"CATEG04,";
      l_cSql = l_cSql+"CATEG05,";
      l_cSql = l_cSql+"FLGPREGIUD,";
      l_cSql = l_cSql+"FLGTRUST,";
      l_cSql = l_cSql+"FLGRISCHIO,";
      l_cSql = l_cSql+"FLGFALSADIC,";
      l_cSql = l_cSql+"FLGEQUIFIN,";
      l_cSql = l_cSql+"FLGRICINF,";
      l_cSql = l_cSql+"CATEGORIA,";
      l_cSql = l_cSql+"NUMCEL,";
      l_cSql = l_cSql+"PEC,";
      l_cSql = l_cSql+"REFERENTE,";
      l_cSql = l_cSql+"CONALTO,";
      l_cSql = l_cSql+"APPALTO,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_personbo_agg.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"personbo_agg")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONNES,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_EMAIL,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGEMAIL,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TELEFONO,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGVALIDO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGANAVAL,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CLOCCUPA,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_NAZIONE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CLPRVDOM,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_REGRES,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGBL,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG01,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG02,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG03,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG04,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CATEG05,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGPREGIUD,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGTRUST,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGRISCHIO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGFALSADIC,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGEQUIFIN,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLGRICINF,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CATEGORIA,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMCEL,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PEC,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_REFERENTE,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONALTO,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_APPALTO,"N",1,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_personbo_agg.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"personbo_agg")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_personbo_agg,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_personbo_agg);
      l_cSql = "Update "+m_oWrInfo_personbo_agg.GetTableWriteName()+" set";
      l_cSql = l_cSql+" EMAIL = "+CPLib.ToSQL(w_EMAIL,"C",50,0);
      l_cSql = l_cSql+", FLGEMAIL = "+CPLib.ToSQL(w_FLGEMAIL,"C",1,0);
      l_cSql = l_cSql+", TELEFONO = "+CPLib.ToSQL(w_TELEFONO,"C",50,0);
      l_cSql = l_cSql+", FLGVALIDO = "+CPLib.ToSQL(w_FLGVALIDO,"C",1,0);
      l_cSql = l_cSql+", FLGANAVAL = "+CPLib.ToSQL(w_FLGANAVAL,"C",1,0);
      l_cSql = l_cSql+", CLOCCUPA = "+CPLib.ToSQL(w_CLOCCUPA,"N",3,0);
      l_cSql = l_cSql+", NAZIONE = "+CPLib.ToSQLNull(w_NAZIONE,"C",3,0);
      l_cSql = l_cSql+", CLPRVDOM = "+CPLib.ToSQL(w_CLPRVDOM,"C",2,0);
      l_cSql = l_cSql+", REGRES = "+CPLib.ToSQL(w_REGRES,"C",2,0);
      l_cSql = l_cSql+", FLGBL = "+CPLib.ToSQL(w_FLGBL,"C",1,0);
      l_cSql = l_cSql+", CATEG01 = "+CPLib.ToSQLNull(w_CATEG01,"C",2,0);
      l_cSql = l_cSql+", CATEG02 = "+CPLib.ToSQLNull(w_CATEG02,"C",2,0);
      l_cSql = l_cSql+", CATEG03 = "+CPLib.ToSQLNull(w_CATEG03,"C",2,0);
      l_cSql = l_cSql+", CATEG04 = "+CPLib.ToSQLNull(w_CATEG04,"C",2,0);
      l_cSql = l_cSql+", CATEG05 = "+CPLib.ToSQLNull(w_CATEG05,"C",2,0);
      l_cSql = l_cSql+", FLGPREGIUD = "+CPLib.ToSQL(w_FLGPREGIUD,"C",1,0);
      l_cSql = l_cSql+", FLGTRUST = "+CPLib.ToSQL(w_FLGTRUST,"C",1,0);
      l_cSql = l_cSql+", FLGRISCHIO = "+CPLib.ToSQL(w_FLGRISCHIO,"C",1,0);
      l_cSql = l_cSql+", FLGFALSADIC = "+CPLib.ToSQL(w_FLGFALSADIC,"C",1,0);
      l_cSql = l_cSql+", FLGEQUIFIN = "+CPLib.ToSQL(w_FLGEQUIFIN,"C",1,0);
      l_cSql = l_cSql+", FLGRICINF = "+CPLib.ToSQL(w_FLGRICINF,"C",1,0);
      l_cSql = l_cSql+", CATEGORIA = "+CPLib.ToSQL(w_CATEGORIA,"C",10,0);
      l_cSql = l_cSql+", NUMCEL = "+CPLib.ToSQL(w_NUMCEL,"C",15,0);
      l_cSql = l_cSql+", PEC = "+CPLib.ToSQL(w_PEC,"C",50,0);
      l_cSql = l_cSql+", REFERENTE = "+CPLib.ToSQL(w_REFERENTE,"C",50,0);
      l_cSql = l_cSql+", CONALTO = "+CPLib.ToSQL(w_CONALTO,"N",1,0);
      l_cSql = l_cSql+", APPALTO = "+CPLib.ToSQL(w_APPALTO,"N",1,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"personbo_agg")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"C",16,0),m_cServer_personbo_agg,w_CONNES);
      l_cSql = l_cSql+m_oWrInfo_personbo_agg.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"personbo_agg")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_personbo_agg,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_CONNES) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_CONNES);
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
          l_cSql = "Delete from "+m_oWrInfo_personbo_agg.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"C",16,0),m_cServer_personbo_agg,w_CONNES);
          l_cSql = l_cSql+m_oWrInfo_personbo_agg.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"personbo_agg")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_personbo_agg,l_cSql);
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
    return Delete(w_CONNES);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"BGFCAXGJBL")) {
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
      result.AppendFieldsHash("BGFCAXGJBL",CPLib.GetLinkedFieldProps("CODSTA","NAZIONE","C",3,0));
    } else if (CPLib.eq(p_cID,"CANUTVNGFD")) {
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
  // ENTITY_BATCHES: ,arrt_calccodfis,arrt_calcolasett,fwfn_calc_categoria,
  public static final String i_InvokedRoutines = ",arrt_calccodfis,arrt_calcolasett,fwfn_calc_categoria,";
}
