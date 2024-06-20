// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class opemt_scarti_importBO extends opemt_scarti_importBL {
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
  public opemt_scarti_importBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"opemt_scarti_import");
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
  public static String[] m_cLoadParameterNames = {"IMPPROG"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(double p_IMPPROG) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_scarti_import,m_cPhName_scarti_import,m_cVirtName_scarti_import,m_cVirtName_scarti_import+".IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_IMPPROG,"N",10,0),m_cServer_scarti_import,p_IMPPROG),"");
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
        w_xdestipope = "";
        w_RAGSOCexec = "";
        w_RAGSOCreal = "";
        w_RAGSOCben = "";
        w_RAGSOCaltro = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_IMPPROG = l_rsLoad.GetDouble("IMPPROG");
        w_CODSTUDIO = l_rsLoad.GetString("CODSTUDIO");
        w_CODDIPE = l_rsLoad.GetString("CODDIPE");
        w_NUMPROG = l_rsLoad.GetString("NUMPROG");
        w_DATAOPE = l_rsLoad.GetString("DATAOPE");
        w_FLAGFRAZ = l_rsLoad.GetString("FLAGFRAZ");
        w_CAUOPER = l_rsLoad.GetString("CAUOPER");
        w_CONNESREAL = l_rsLoad.GetString("CONNESREAL");
        w_RAGSOCreal = "";
        Link_TRIYBQSKCQ("Load");
        w_CONNESCLI = l_rsLoad.GetString("CONNESCLI");
        w_RAGSOCexec = "";
        Link_DHRGEXYQZL("Load");
        w_CONNESBEN = l_rsLoad.GetString("CONNESBEN");
        w_RAGSOCben = "";
        Link_SQWOYVEXHD("Load");
        w_CONNALTRO = l_rsLoad.GetString("CONNALTRO");
        w_RAGSOCaltro = "";
        Link_SFOARTDXXG("Load");
        w_DATAREG = l_rsLoad.GetString("DATAREG");
        w_STATOREG = l_rsLoad.GetString("STATOREG");
        w_DATARETT = l_rsLoad.GetString("DATARETT");
        w_VALUTA = l_rsLoad.GetString("VALUTA");
        w_IMPORTO = l_rsLoad.GetDouble("IMPORTO");
        w_CONTANTI = l_rsLoad.GetDouble("CONTANTI");
        w_MEZPAG = l_rsLoad.GetString("MEZPAG");
        w_PRESTAZ = l_rsLoad.GetString("PRESTAZ");
        w_RAGIO = l_rsLoad.GetString("RAGIO");
        w_MODSVOL = l_rsLoad.GetString("MODSVOL");
        w_AREAGEO = l_rsLoad.GetString("AREAGEO");
        w_TIPO = l_rsLoad.GetString("TIPO");
        w_AMMONT = l_rsLoad.GetString("AMMONT");
        w_DURAT = l_rsLoad.GetString("DURAT");
        w_RAREA = l_rsLoad.GetDouble("RAREA");
        w_RRAGIO = l_rsLoad.GetDouble("RRAGIO");
        w_RCOMP = l_rsLoad.GetDouble("RCOMP");
        w_RTIPO = l_rsLoad.GetDouble("RTIPO");
        w_RFREQ = l_rsLoad.GetDouble("RFREQ");
        w_RIMP = l_rsLoad.GetDouble("RIMP");
        w_TIPOOPER = l_rsLoad.GetString("TIPOOPER");
        w_xdestipope = "";
        Link_KYUSCDSEVM("Load");
        w_TXTERR = l_rsLoad.GetString("TXTERR");
        w_DESPUNTO = l_rsLoad.GetString("DESPUNTO");
        w_IMPPROG13 = l_rsLoad.GetString("IMPPROG13");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"scarti_import")) {
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
    return Load(w_IMPPROG);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_scarti_import);
      l_cSql = "insert into "+m_oWrInfo_scarti_import.GetTableWriteName()+" (";
      l_cSql = l_cSql+"IMPPROG,";
      l_cSql = l_cSql+"CODSTUDIO,";
      l_cSql = l_cSql+"CODDIPE,";
      l_cSql = l_cSql+"NUMPROG,";
      l_cSql = l_cSql+"DATAOPE,";
      l_cSql = l_cSql+"FLAGFRAZ,";
      l_cSql = l_cSql+"CAUOPER,";
      l_cSql = l_cSql+"CONNESREAL,";
      l_cSql = l_cSql+"CONNESCLI,";
      l_cSql = l_cSql+"CONNESBEN,";
      l_cSql = l_cSql+"CONNALTRO,";
      l_cSql = l_cSql+"DATAREG,";
      l_cSql = l_cSql+"STATOREG,";
      l_cSql = l_cSql+"DATARETT,";
      l_cSql = l_cSql+"VALUTA,";
      l_cSql = l_cSql+"IMPORTO,";
      l_cSql = l_cSql+"CONTANTI,";
      l_cSql = l_cSql+"MEZPAG,";
      l_cSql = l_cSql+"PRESTAZ,";
      l_cSql = l_cSql+"RAGIO,";
      l_cSql = l_cSql+"MODSVOL,";
      l_cSql = l_cSql+"AREAGEO,";
      l_cSql = l_cSql+"TIPO,";
      l_cSql = l_cSql+"AMMONT,";
      l_cSql = l_cSql+"DURAT,";
      l_cSql = l_cSql+"RAREA,";
      l_cSql = l_cSql+"RRAGIO,";
      l_cSql = l_cSql+"RCOMP,";
      l_cSql = l_cSql+"RTIPO,";
      l_cSql = l_cSql+"RFREQ,";
      l_cSql = l_cSql+"RIMP,";
      l_cSql = l_cSql+"TIPOOPER,";
      l_cSql = l_cSql+"TXTERR,";
      l_cSql = l_cSql+"DESPUNTO,";
      l_cSql = l_cSql+"IMPPROG13,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_scarti_import.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"scarti_import")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_IMPPROG,"N",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODSTUDIO,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODDIPE,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMPROG,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAOPE,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGFRAZ,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAUOPER,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONNESREAL,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONNESCLI,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONNESBEN,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONNALTRO,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAREG,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_STATOREG,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATARETT,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VALUTA,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IMPORTO,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONTANTI,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MEZPAG,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PRESTAZ,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAGIO,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MODSVOL,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AREAGEO,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPO,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AMMONT,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DURAT,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAREA,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RRAGIO,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RCOMP,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RTIPO,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RFREQ,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RIMP,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPOOPER,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TXTERR,"M",10,0,m_cServer_scarti_import,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESPUNTO,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IMPPROG13,"C",13,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_scarti_import.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"scarti_import")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_scarti_import,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_scarti_import);
      l_cSql = "Update "+m_oWrInfo_scarti_import.GetTableWriteName()+" set";
      l_cSql = l_cSql+" CODSTUDIO = "+CPLib.ToSQL(w_CODSTUDIO,"C",11,0);
      l_cSql = l_cSql+", CODDIPE = "+CPLib.ToSQL(w_CODDIPE,"C",6,0);
      l_cSql = l_cSql+", NUMPROG = "+CPLib.ToSQL(w_NUMPROG,"C",11,0);
      l_cSql = l_cSql+", DATAOPE = "+CPLib.ToSQL(w_DATAOPE,"C",8,0);
      l_cSql = l_cSql+", FLAGFRAZ = "+CPLib.ToSQL(w_FLAGFRAZ,"C",1,0);
      l_cSql = l_cSql+", CAUOPER = "+CPLib.ToSQL(w_CAUOPER,"C",4,0);
      l_cSql = l_cSql+", CONNESREAL = "+CPLib.ToSQL(w_CONNESREAL,"C",11,0);
      l_cSql = l_cSql+", CONNESCLI = "+CPLib.ToSQL(w_CONNESCLI,"C",11,0);
      l_cSql = l_cSql+", CONNESBEN = "+CPLib.ToSQL(w_CONNESBEN,"C",11,0);
      l_cSql = l_cSql+", CONNALTRO = "+CPLib.ToSQL(w_CONNALTRO,"C",11,0);
      l_cSql = l_cSql+", DATAREG = "+CPLib.ToSQL(w_DATAREG,"C",8,0);
      l_cSql = l_cSql+", STATOREG = "+CPLib.ToSQL(w_STATOREG,"C",1,0);
      l_cSql = l_cSql+", DATARETT = "+CPLib.ToSQL(w_DATARETT,"C",8,0);
      l_cSql = l_cSql+", VALUTA = "+CPLib.ToSQL(w_VALUTA,"C",3,0);
      l_cSql = l_cSql+", IMPORTO = "+CPLib.ToSQL(w_IMPORTO,"N",15,2);
      l_cSql = l_cSql+", CONTANTI = "+CPLib.ToSQL(w_CONTANTI,"N",15,2);
      l_cSql = l_cSql+", MEZPAG = "+CPLib.ToSQL(w_MEZPAG,"C",30,0);
      l_cSql = l_cSql+", PRESTAZ = "+CPLib.ToSQL(w_PRESTAZ,"C",30,0);
      l_cSql = l_cSql+", RAGIO = "+CPLib.ToSQL(w_RAGIO,"C",5,0);
      l_cSql = l_cSql+", MODSVOL = "+CPLib.ToSQL(w_MODSVOL,"C",5,0);
      l_cSql = l_cSql+", AREAGEO = "+CPLib.ToSQL(w_AREAGEO,"C",3,0);
      l_cSql = l_cSql+", TIPO = "+CPLib.ToSQL(w_TIPO,"C",3,0);
      l_cSql = l_cSql+", AMMONT = "+CPLib.ToSQL(w_AMMONT,"C",2,0);
      l_cSql = l_cSql+", DURAT = "+CPLib.ToSQL(w_DURAT,"C",2,0);
      l_cSql = l_cSql+", RAREA = "+CPLib.ToSQL(w_RAREA,"N",3,0);
      l_cSql = l_cSql+", RRAGIO = "+CPLib.ToSQL(w_RRAGIO,"N",3,0);
      l_cSql = l_cSql+", RCOMP = "+CPLib.ToSQL(w_RCOMP,"N",3,0);
      l_cSql = l_cSql+", RTIPO = "+CPLib.ToSQL(w_RTIPO,"N",3,0);
      l_cSql = l_cSql+", RFREQ = "+CPLib.ToSQL(w_RFREQ,"N",3,0);
      l_cSql = l_cSql+", RIMP = "+CPLib.ToSQL(w_RIMP,"N",3,0);
      l_cSql = l_cSql+", TIPOOPER = "+CPLib.ToSQLNull(w_TIPOOPER,"C",2,0);
      l_cSql = l_cSql+", TXTERR = "+CPLib.ToSQL(w_TXTERR,"M",10,0,m_cServer_scarti_import,m_oParameters);
      l_cSql = l_cSql+", DESPUNTO = "+CPLib.ToSQL(w_DESPUNTO,"C",80,0);
      l_cSql = l_cSql+", IMPPROG13 = "+CPLib.ToSQL(w_IMPPROG13,"C",13,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"scarti_import")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IMPPROG,"N",10,0),m_cServer_scarti_import,w_IMPPROG);
      l_cSql = l_cSql+m_oWrInfo_scarti_import.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"scarti_import")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_scarti_import,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(double p_IMPPROG) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_IMPPROG);
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
          l_cSql = "Delete from "+m_oWrInfo_scarti_import.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IMPPROG,"N",10,0),m_cServer_scarti_import,w_IMPPROG);
          l_cSql = l_cSql+m_oWrInfo_scarti_import.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"scarti_import")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_scarti_import,l_cSql);
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
    return Delete(w_IMPPROG);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"TRIYBQSKCQ")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "opemt_personbo";
      result.m_rdField = new String[]{"PARTIVA" , "RAGSOC"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("TRIYBQSKCQ",CPLib.GetLinkedFieldProps("PARTIVA","CONNESREAL","C",11,0));
    } else if (CPLib.eq(p_cID,"DHRGEXYQZL")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"PARTIVA" , "RAGSOC"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("DHRGEXYQZL",CPLib.GetLinkedFieldProps("PARTIVA","CONNESCLI","C",11,0));
    } else if (CPLib.eq(p_cID,"SQWOYVEXHD")) {
      result.m_TableName = "personbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "opemt_personbo";
      result.m_rdField = new String[]{"PARTIVA" , "RAGSOC"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SQWOYVEXHD",CPLib.GetLinkedFieldProps("PARTIVA","CONNESBEN","C",11,0));
    } else if (CPLib.eq(p_cID,"SFOARTDXXG")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "opemt_personbo";
      result.m_rdField = new String[]{"PARTIVA" , "RAGSOC"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SFOARTDXXG",CPLib.GetLinkedFieldProps("PARTIVA","CONNALTRO","C",11,0));
    } else if (CPLib.eq(p_cID,"KYUSCDSEVM")) {
      result.m_TableName = "tipilegbo_m";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"TIPLEG" , "DESCRIZ"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("KYUSCDSEVM",CPLib.GetLinkedFieldProps("TIPLEG","TIPOOPER","C",2,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,opert_del_scarti_contante,
  public static final String i_InvokedRoutines = ",opert_del_scarti_contante,";
}
