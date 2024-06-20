// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_import_webopeR implements CallerWithObjs {
  // gestori associati a particolari eventi ('Routine start')
  public static volatile java.util.Map<String,java.util.List<com.zucchetti.sitepainter.EventHandler>> specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile java.util.List<com.zucchetti.sitepainter.EventHandler> allEventsHandlers;
  // indica se si sta gestendo un evento scatenato da questa routine per restituire il valore corretto di i_EntityName ed i_EntityType
  static boolean m_bEventRunning;
  public String m_cLastMsgError;
  public boolean m_bError;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabile di caller (variabili di caller): passata nel costruttore
  public CallerWithObjs m_Caller;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_webope_intermbo;
  public String m_cServer_webope_intermbo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_webope_personbo;
  public String m_cServer_webope_personbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_wersonbo_agg;
  public String m_cServer_wersonbo_agg;
  public String m_cPhName_webope_operazbo;
  public String m_cServer_webope_operazbo;
  public String m_cPhName_ope_contante;
  public String m_cServer_ope_contante;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_operazbo_agg;
  public String m_cServer_operazbo_agg;
  public String m_cPhName_webope_ope_contante;
  public String m_cServer_webope_ope_contante;
  public String m_cPhName_webope_rapotit;
  public String m_cServer_webope_rapotit;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_webope_intestit;
  public String m_cServer_webope_intestit;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_webope_cpwarn;
  public String m_cServer_webope_cpwarn;
  public String m_cPhName_cpwarn;
  public String m_cServer_cpwarn;
  public String m_cPhName_webope_anarapbo;
  public String m_cServer_webope_anarapbo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_webope_rapopebo;
  public String m_cServer_webope_rapopebo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_webope_intestbo;
  public String m_cServer_webope_intestbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_webope_delegabo;
  public String m_cServer_webope_delegabo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_webope_soginfo;
  public String m_cServer_webope_soginfo;
  public String m_cPhName_soginfo;
  public String m_cServer_soginfo;
  String m_cServer;
  String m_cPhName;
  CPPhTableWrInfo m_oWrInfo;
  String m_cQuery;
  String m_cQueryTable;
  String m_cSql;
  java.util.List<String> m_oParameters;
  String m_cWhere;
  int m_nUpdatedRows;
  // Contiene il messaggio di errore dell'ultima select terminata a causa della caduta della connessione
  String m_cConnectivityError;
  public String _progsto;
  public double nProgSto;
  public String cProgSto;
  public String _delcon;
  public String _ident;
  public String _min;
  public double _nmin;
  public double _nmax;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_import_webopeR (CPContext p_ContextObject, Caller caller) {
    if (caller == null)
      m_Caller = CallerWithObjsImpl.EMPTY;
    else if (caller instanceof CallerWithObjs)
      m_Caller = (CallerWithObjs)caller;
    else
      m_Caller = new CallerWithObjsImpl(caller);
    m_Ctx=p_ContextObject;
    // Assegnazione della variabile di collegamento con il database
    m_Sql=m_Ctx.GetSql();
    /*  Impostazione dell'ambiente globale: il businness object si collega
                                all'oggetto globale (unico per più istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda è contenuta nel global object.
                             */
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_import_webope",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_webope_intermbo = p_ContextObject.GetPhName("webope_intermbo");
    if (m_cPhName_webope_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webope_intermbo = m_cPhName_webope_intermbo+" "+m_Ctx.GetWritePhName("webope_intermbo");
    }
    m_cServer_webope_intermbo = p_ContextObject.GetServer("webope_intermbo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_webope_personbo = p_ContextObject.GetPhName("webope_personbo");
    if (m_cPhName_webope_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webope_personbo = m_cPhName_webope_personbo+" "+m_Ctx.GetWritePhName("webope_personbo");
    }
    m_cServer_webope_personbo = p_ContextObject.GetServer("webope_personbo");
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_wersonbo_agg = p_ContextObject.GetPhName("wersonbo_agg");
    if (m_cPhName_wersonbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo_agg = m_cPhName_wersonbo_agg+" "+m_Ctx.GetWritePhName("wersonbo_agg");
    }
    m_cServer_wersonbo_agg = p_ContextObject.GetServer("wersonbo_agg");
    m_cPhName_webope_operazbo = p_ContextObject.GetPhName("webope_operazbo");
    if (m_cPhName_webope_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webope_operazbo = m_cPhName_webope_operazbo+" "+m_Ctx.GetWritePhName("webope_operazbo");
    }
    m_cServer_webope_operazbo = p_ContextObject.GetServer("webope_operazbo");
    m_cPhName_ope_contante = p_ContextObject.GetPhName("ope_contante");
    if (m_cPhName_ope_contante.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_ope_contante = m_cPhName_ope_contante+" "+m_Ctx.GetWritePhName("ope_contante");
    }
    m_cServer_ope_contante = p_ContextObject.GetServer("ope_contante");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_operazbo_agg = p_ContextObject.GetPhName("operazbo_agg");
    if (m_cPhName_operazbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo_agg = m_cPhName_operazbo_agg+" "+m_Ctx.GetWritePhName("operazbo_agg");
    }
    m_cServer_operazbo_agg = p_ContextObject.GetServer("operazbo_agg");
    m_cPhName_webope_ope_contante = p_ContextObject.GetPhName("webope_ope_contante");
    if (m_cPhName_webope_ope_contante.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webope_ope_contante = m_cPhName_webope_ope_contante+" "+m_Ctx.GetWritePhName("webope_ope_contante");
    }
    m_cServer_webope_ope_contante = p_ContextObject.GetServer("webope_ope_contante");
    m_cPhName_webope_rapotit = p_ContextObject.GetPhName("webope_rapotit");
    if (m_cPhName_webope_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webope_rapotit = m_cPhName_webope_rapotit+" "+m_Ctx.GetWritePhName("webope_rapotit");
    }
    m_cServer_webope_rapotit = p_ContextObject.GetServer("webope_rapotit");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    m_cPhName_webope_intestit = p_ContextObject.GetPhName("webope_intestit");
    if (m_cPhName_webope_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webope_intestit = m_cPhName_webope_intestit+" "+m_Ctx.GetWritePhName("webope_intestit");
    }
    m_cServer_webope_intestit = p_ContextObject.GetServer("webope_intestit");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_webope_cpwarn = p_ContextObject.GetPhName("webope_cpwarn");
    if (m_cPhName_webope_cpwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webope_cpwarn = m_cPhName_webope_cpwarn+" "+m_Ctx.GetWritePhName("webope_cpwarn");
    }
    m_cServer_webope_cpwarn = p_ContextObject.GetServer("webope_cpwarn");
    m_cPhName_cpwarn = p_ContextObject.GetPhName("cpwarn");
    if (m_cPhName_cpwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpwarn = m_cPhName_cpwarn+" "+m_Ctx.GetWritePhName("cpwarn");
    }
    m_cServer_cpwarn = p_ContextObject.GetServer("cpwarn");
    m_cPhName_webope_anarapbo = p_ContextObject.GetPhName("webope_anarapbo");
    if (m_cPhName_webope_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webope_anarapbo = m_cPhName_webope_anarapbo+" "+m_Ctx.GetWritePhName("webope_anarapbo");
    }
    m_cServer_webope_anarapbo = p_ContextObject.GetServer("webope_anarapbo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_webope_rapopebo = p_ContextObject.GetPhName("webope_rapopebo");
    if (m_cPhName_webope_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webope_rapopebo = m_cPhName_webope_rapopebo+" "+m_Ctx.GetWritePhName("webope_rapopebo");
    }
    m_cServer_webope_rapopebo = p_ContextObject.GetServer("webope_rapopebo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_webope_intestbo = p_ContextObject.GetPhName("webope_intestbo");
    if (m_cPhName_webope_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webope_intestbo = m_cPhName_webope_intestbo+" "+m_Ctx.GetWritePhName("webope_intestbo");
    }
    m_cServer_webope_intestbo = p_ContextObject.GetServer("webope_intestbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_webope_delegabo = p_ContextObject.GetPhName("webope_delegabo");
    if (m_cPhName_webope_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webope_delegabo = m_cPhName_webope_delegabo+" "+m_Ctx.GetWritePhName("webope_delegabo");
    }
    m_cServer_webope_delegabo = p_ContextObject.GetServer("webope_delegabo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_webope_soginfo = p_ContextObject.GetPhName("webope_soginfo");
    if (m_cPhName_webope_soginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webope_soginfo = m_cPhName_webope_soginfo+" "+m_Ctx.GetWritePhName("webope_soginfo");
    }
    m_cServer_webope_soginfo = p_ContextObject.GetServer("webope_soginfo");
    m_cPhName_soginfo = p_ContextObject.GetPhName("soginfo");
    if (m_cPhName_soginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_soginfo = m_cPhName_soginfo+" "+m_Ctx.GetWritePhName("soginfo");
    }
    m_cServer_soginfo = p_ContextObject.GetServer("soginfo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("nProgSto",p_cVarName)) {
      return nProgSto;
    }
    if (CPLib.eqr("_nmin",p_cVarName)) {
      return _nmin;
    }
    if (CPLib.eqr("_nmax",p_cVarName)) {
      return _nmax;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_import_webope";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_progsto",p_cVarName)) {
      return _progsto;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      return cProgSto;
    }
    if (CPLib.eqr("_delcon",p_cVarName)) {
      return _delcon;
    }
    if (CPLib.eqr("_ident",p_cVarName)) {
      return _ident;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("nProgSto",p_cVarName)) {
      nProgSto = value;
      return;
    }
    if (CPLib.eqr("_nmin",p_cVarName)) {
      _nmin = value;
      return;
    }
    if (CPLib.eqr("_nmax",p_cVarName)) {
      _nmax = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_progsto",p_cVarName)) {
      _progsto = value;
      return;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      cProgSto = value;
      return;
    }
    if (CPLib.eqr("_delcon",p_cVarName)) {
      _delcon = value;
      return;
    }
    if (CPLib.eqr("_ident",p_cVarName)) {
      _ident = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_webope_personbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_webope_rapotit=null;
    CPResultSet Cursor_webope_intestit=null;
    CPResultSet Cursor_qbe_dataope_webope_operazbo=null;
    CPResultSet Cursor_webope_operazbo=null;
    CPResultSet Cursor_webope_ope_contante=null;
    CPResultSet Cursor_webope_cpwarn=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _progsto Char(12) */
      /* nProgSto Numeric(10, 0) := 0 */
      nProgSto = CPLib.Round(0,0);
      /* cProgSto Char(15) */
      /* _delcon Char(16) */
      /* _ident Char(3) */
      /* _min Char(11) */
      /* _nmin Numeric(8, 0) */
      /* _nmax Numeric(11, 0) */
      /* gAzienda Char(10) // Azienda */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000000Dstatus;
      nTry0000000Dstatus = m_Sql.GetTransactionStatus();
      String cTry0000000Dmsg;
      cTry0000000Dmsg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Delete from personbo_agg
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo_agg");
        m_cPhName = m_Ctx.GetPhName("personbo_agg");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000010")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        // * --- Delete from wersonbo_agg
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("wersonbo_agg");
        m_cPhName = m_Ctx.GetPhName("wersonbo_agg");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo_agg",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000011")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        // * --- Delete from wersonbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000012")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        // * --- Delete from personbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000013")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        // * --- Select from webope_personbo
        m_cServer = m_Ctx.GetServer("webope_personbo");
        m_cPhName = m_Ctx.GetPhName("webope_personbo");
        if (Cursor_webope_personbo!=null)
          Cursor_webope_personbo.Close();
        Cursor_webope_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"STATOREG='0'  or  STATOREG='1'  or  STATOREG='2' "+")"+(m_Ctx.IsSharedTemp("webope_personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"STATOREG ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_webope_personbo.Eof())) {
          /* Case LRTrim(webope_personbo->TIPOIDEN)='A' */
          if (CPLib.eqr(CPLib.LRTrim(Cursor_webope_personbo.GetString("TIPOIDEN")),"A")) {
            /* _ident := '001' */
            _ident = "001";
            /* Case LRTrim(webope_personbo->TIPOIDEN)='B' */
          } else if (CPLib.eqr(CPLib.LRTrim(Cursor_webope_personbo.GetString("TIPOIDEN")),"B")) {
            /* _ident := '003' */
            _ident = "003";
          } else { // Otherwise
            /* _ident := '002' */
            _ident = "002";
          } // End Case
          /* If webope_personbo->STATOREG='0' or webope_personbo->STATOREG='1' */
          if (CPLib.eqr(Cursor_webope_personbo.GetString("STATOREG"),"0") || CPLib.eqr(Cursor_webope_personbo.GetString("STATOREG"),"1")) {
            // * --- Insert into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"0000001B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000001B(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("CAUSALE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CODLEGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAFINE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAINI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATANASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAPROF"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAREVPROF"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DISATTIVO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("FATTURATO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("FLGNOTRIM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("FREQUENZA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("IMPORTOMAX"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("NUMOPERAZ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_webope_personbo.GetString("PROVINCIA")),2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("RAPSEGNA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("SOGAFFIDATARIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("TIPOSOGGETTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAIDENT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_ident,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              throw new RoutineException();
            }
            // * --- Insert into personbo_agg from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo_agg");
            m_cPhName = m_Ctx.GetPhName("personbo_agg");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"0000001C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000001C(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("EMAIL"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NUMTEL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NUMCEL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("PEC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("REFERENTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              throw new RoutineException();
            }
          } else { // Else
            /* _delcon := '' */
            _delcon = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_webope_personbo.GetString("CONNES"),"C",16,0,m_cServer),m_cServer,Cursor_webope_personbo.GetString("CONNES"));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _delcon = Read_Cursor.GetString("CONNES");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_webope returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _delcon = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(_delcon)) */
            if (CPLib.Empty(CPLib.LRTrim(_delcon))) {
              // * --- Insert into personbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000020")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000020(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("CAUSALE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CODLEGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAFINE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAINI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAPROF"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAREVPROF"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DISATTIVO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("FATTURATO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("FLGNOTRIM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("FREQUENZA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("IMPORTOMAX"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("NUMOPERAZ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_webope_personbo.GetString("PROVINCIA")),2),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("RAPSEGNA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("SOGAFFIDATARIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("TIPOSOGGETTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAIDENT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_ident,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
              // * --- Insert into personbo_agg from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("personbo_agg");
              m_cPhName = m_Ctx.GetPhName("personbo_agg");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000021")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000021(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("EMAIL"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NUMTEL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NUMCEL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("PEC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("REFERENTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
            } // End If
          } // End If
          Cursor_webope_personbo.Next();
        }
        m_cConnectivityError = Cursor_webope_personbo.ErrorMessage();
        Cursor_webope_personbo.Close();
        // * --- End Select
        /* nProgSto := 0 */
        nProgSto = CPLib.Round(0,0);
        // * --- Select from webope_personbo
        m_cServer = m_Ctx.GetServer("webope_personbo");
        m_cPhName = m_Ctx.GetPhName("webope_personbo");
        if (Cursor_webope_personbo!=null)
          Cursor_webope_personbo.Close();
        Cursor_webope_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"STATOREG='3' "+")"+(m_Ctx.IsSharedTemp("webope_personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CONNES,DATARETT,IDBASE ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_webope_personbo.Eof())) {
          /* cProgSto := '' */
          cProgSto = "";
          // * --- Select from wersonbo
          m_cServer = m_Ctx.GetServer("wersonbo");
          m_cPhName = m_Ctx.GetPhName("wersonbo");
          if (Cursor_wersonbo!=null)
            Cursor_wersonbo.Close();
          Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select sanumpro  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_webope_personbo.GetString("CONNES"),"?",0,0)+"  and  datamodi="+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATARETT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_wersonbo.Eof())) {
            /* cProgSto := wersonbo->sanumpro */
            cProgSto = Cursor_wersonbo.GetString("sanumpro");
            Cursor_wersonbo.Next();
          }
          m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
          Cursor_wersonbo.Close();
          // * --- End Select
          /* If Empty(LRTrim(cProgSto)) */
          if (CPLib.Empty(CPLib.LRTrim(cProgSto))) {
            /* Case LRTrim(webope_personbo->TIPOIDEN)='A' */
            if (CPLib.eqr(CPLib.LRTrim(Cursor_webope_personbo.GetString("TIPOIDEN")),"A")) {
              /* _ident := '001' */
              _ident = "001";
              /* Case LRTrim(webope_personbo->TIPOIDEN)='B' */
            } else if (CPLib.eqr(CPLib.LRTrim(Cursor_webope_personbo.GetString("TIPOIDEN")),"B")) {
              /* _ident := '003' */
              _ident = "003";
            } else { // Otherwise
              /* _ident := '002' */
              _ident = "002";
            } // End Case
            /* nProgSto := nProgSto + 1 */
            nProgSto = CPLib.Round(nProgSto+1,0);
            /* cProgSto := Right('000000000000000'+LRTrim(Str(nProgSto,15,0)),15) */
            cProgSto = CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(nProgSto,15,0)),15);
            // * --- Insert into wersonbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"0000002F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000002F(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("CAUSALE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CODLEGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAFINE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAINI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATANASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAPROF"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAREVPROF"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DISATTIVO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("FATTURATO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("FLGNOTRIM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("FREQUENZA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("IMPORTOMAX"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("NUMOPERAZ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_webope_personbo.GetString("PROVINCIA")),2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("RAPSEGNA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("SOGAFFIDATARIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("TIPOSOGGETTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetDate("DATAIDENT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_ident,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wersonbo",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              throw new RoutineException();
            }
            // * --- Insert into wersonbo_agg from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wersonbo_agg");
            m_cPhName = m_Ctx.GetPhName("wersonbo_agg");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo_agg",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000030")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000030(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("EMAIL"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NUMTEL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("NUMCEL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("PEC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_personbo.GetString("REFERENTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wersonbo_agg",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              throw new RoutineException();
            }
          } // End If
          Cursor_webope_personbo.Next();
        }
        m_cConnectivityError = Cursor_webope_personbo.ErrorMessage();
        Cursor_webope_personbo.Close();
        // * --- End Select
        /* If nProgSto > 0 */
        if (CPLib.gt(nProgSto,0)) {
          // * --- Merge into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_cQuery = "select ";
          m_cQuery =  m_cQuery+""+CPLib.ToSQL("prog\\PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0)+" as tablecode";
          m_cQuery =  m_cQuery+", "+CPLib.ToSQL(gAzienda,"?",0,0)+" as warncode";
          if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
            m_cQuery = m_cQuery+" from dual";
          }
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cWhere = "cpwarn.tablecode = cptmp_1xab23.tablecode";
          m_cWhere = m_cWhere+" and "+"cpwarn.warncode = cptmp_1xab23.warncode";
          m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
          if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000032")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" cpwarn USING ";
            m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
            m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
            m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(nProgSto,"N",10,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",true,true);
            m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
            m_cSql = m_cSql+GetFieldsName_00000032(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(gAzienda,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgSto,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
            m_cSql = m_cSql+")";
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
              m_cSql = m_cSql+";";
            }
          } else {
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000032")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(nProgSto,"N",10,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
            m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.eqr(m_nUpdatedRows,0)) {
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000032")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000032(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(gAzienda,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgSto,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
              m_cSql = m_cSql+")";
            } else {
              m_cSql = "";
            }
          }
          if ( ! (CPLib.Empty(m_cSql))) {
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          }
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
        } // End If
        // * --- Delete from intestit
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("intestit");
        m_cPhName = m_Ctx.GetPhName("intestit");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestit",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000034")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        // * --- Delete from rapotit
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("rapotit");
        m_cPhName = m_Ctx.GetPhName("rapotit");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000035")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        // * --- Select from webope_rapotit
        m_cServer = m_Ctx.GetServer("webope_rapotit");
        m_cPhName = m_Ctx.GetPhName("webope_rapotit");
        if (Cursor_webope_rapotit!=null)
          Cursor_webope_rapotit.Close();
        Cursor_webope_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("webope_rapotit")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_webope_rapotit.Eof())) {
          // * --- Insert into rapotit from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapotit");
          m_cPhName = m_Ctx.GetPhName("rapotit");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000037")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000037(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetDate("DATARETT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetDate("DATAAGE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetDouble("PRGIMPTIT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_rapotit.GetString("IDBASE2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"rapotit",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          Cursor_webope_rapotit.Next();
        }
        m_cConnectivityError = Cursor_webope_rapotit.ErrorMessage();
        Cursor_webope_rapotit.Close();
        // * --- End Select
        // * --- Select from webope_intestit
        m_cServer = m_Ctx.GetServer("webope_intestit");
        m_cPhName = m_Ctx.GetPhName("webope_intestit");
        if (Cursor_webope_intestit!=null)
          Cursor_webope_intestit.Close();
        Cursor_webope_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("webope_intestit")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_webope_intestit.Eof())) {
          // * --- Insert into intestit from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("intestit");
          m_cPhName = m_Ctx.GetPhName("intestit");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestit",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000039")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000039(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetString("CODCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetDate("DATAINI"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetDate("DATARETT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetDate("DATAFINE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetDouble("ABBINATO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_intestit.GetDouble("PRGIMPTITE"),"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"intestit",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          Cursor_webope_intestit.Next();
        }
        m_cConnectivityError = Cursor_webope_intestit.ErrorMessage();
        Cursor_webope_intestit.Close();
        // * --- End Select
        // * --- Delete from ope_contante
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("ope_contante");
        m_cPhName = m_Ctx.GetPhName("ope_contante");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"ope_contante",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"0000003B")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        // * --- Delete from operazbo_agg
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("operazbo_agg");
        m_cPhName = m_Ctx.GetPhName("operazbo_agg");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo_agg",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"0000003C")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        // * --- Delete from operazbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"0000003D")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        // * --- Select from qbe_dataope_webope_operazbo
        if (Cursor_qbe_dataope_webope_operazbo!=null)
          Cursor_qbe_dataope_webope_operazbo.Close();
        Cursor_qbe_dataope_webope_operazbo = new VQRHolder("qbe_dataope_webope_operazbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_dataope_webope_operazbo.Eof())) {
          // * --- Select from webope_operazbo
          m_cServer = m_Ctx.GetServer("webope_operazbo");
          m_cPhName = m_Ctx.GetPhName("webope_operazbo");
          if (Cursor_webope_operazbo!=null)
            Cursor_webope_operazbo.Close();
          Cursor_webope_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAOPE="+CPLib.ToSQL(Cursor_qbe_dataope_webope_operazbo.GetDate("DATAOPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("webope_operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"NUMPROG ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_webope_operazbo.Eof())) {
            // * --- Insert into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000040")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000040(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_webope_operazbo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_webope_operazbo.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_webope_operazbo.GetString("TIPATT"),"SOV")?"8199":"8101"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("CODCLICON"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("CONNESREAL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("DESPUNTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("IMPPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("MEZPAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("NOTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("PRESTAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_webope_operazbo.GetString("NUMPROG")),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("TIPATT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetDouble("CONTANTI")*100,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetDouble("IMPORTO")*100,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              throw new RoutineException();
            }
            // * --- Insert into operazbo_agg from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo_agg");
            m_cPhName = m_Ctx.GetPhName("operazbo_agg");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo_agg",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000041")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000041(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_operazbo.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo_agg",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              throw new RoutineException();
            }
            // * --- Select from webope_ope_contante
            m_cServer = m_Ctx.GetServer("webope_ope_contante");
            m_cPhName = m_Ctx.GetPhName("webope_ope_contante");
            if (Cursor_webope_ope_contante!=null)
              Cursor_webope_ope_contante.Close();
            Cursor_webope_ope_contante = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDOPE="+CPLib.ToSQL(Cursor_webope_operazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("webope_ope_contante")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_webope_ope_contante.Eof())) {
              // * --- Insert into ope_contante from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("ope_contante");
              m_cPhName = m_Ctx.GetPhName("ope_contante");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"ope_contante",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000043")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000043(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetString("IDOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetDouble("BILLSRIT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetDouble("BILLSSOV"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetString("TIPATT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetString("TIPOATTIV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetString("CODICEGLN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetDouble("TAGLIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetDouble("NBANCONOTE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetString("ABIINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetString("ABIPROPR"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetString("GLNALTROSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetString("GLNALTRASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetString("CODCLICON"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetString("CODCOMCON"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetString("ATECO_CON"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetDouble("TOTALERIG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_ope_contante.GetDouble("TOTALEGEN"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"ope_contante",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
              Cursor_webope_ope_contante.Next();
            }
            m_cConnectivityError = Cursor_webope_ope_contante.ErrorMessage();
            Cursor_webope_ope_contante.Close();
            // * --- End Select
            Cursor_webope_operazbo.Next();
          }
          m_cConnectivityError = Cursor_webope_operazbo.ErrorMessage();
          Cursor_webope_operazbo.Close();
          // * --- End Select
          Cursor_qbe_dataope_webope_operazbo.Next();
        }
        m_cConnectivityError = Cursor_qbe_dataope_webope_operazbo.ErrorMessage();
        Cursor_qbe_dataope_webope_operazbo.Close();
        // * --- End Select
        // * --- Select from webope_cpwarn
        m_cServer = m_Ctx.GetServer("webope_cpwarn");
        m_cPhName = m_Ctx.GetPhName("webope_cpwarn");
        if (Cursor_webope_cpwarn!=null)
          Cursor_webope_cpwarn.Close();
        Cursor_webope_cpwarn = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("webope_cpwarn")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_webope_cpwarn.Eof())) {
          // * --- Merge into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_cQuery = "select ";
          m_cQuery =  m_cQuery+""+CPLib.ToSQL(Cursor_webope_cpwarn.GetString("tablecode"),"?",0,0)+" as tablecode";
          m_cQuery =  m_cQuery+", "+CPLib.ToSQL(Cursor_webope_cpwarn.GetString("warncode"),"?",0,0)+" as warncode";
          if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
            m_cQuery = m_cQuery+" from dual";
          }
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cWhere = "cpwarn.tablecode = cptmp_1xab23.tablecode";
          m_cWhere = m_cWhere+" and "+"cpwarn.warncode = cptmp_1xab23.warncode";
          m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
          if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000045")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" cpwarn USING ";
            m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
            m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
            m_cSql = m_cSql+"cpwarn.autonum = "+CPLib.ToSQL(Cursor_webope_cpwarn.GetDouble("autonum"),"?",0,0)+" , ";
            m_cSql = m_cSql+"cpwarn.autonum_name = "+CPLib.ToSQL(Cursor_webope_cpwarn.GetString("autonum_name"),"?",0,0)+" , ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",true,true);
            m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
            m_cSql = m_cSql+GetFieldsName_00000045(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_cpwarn.GetString("tablecode"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_cpwarn.GetString("warncode"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_cpwarn.GetDouble("autonum"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_cpwarn.GetString("autonum_name"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
            m_cSql = m_cSql+")";
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
              m_cSql = m_cSql+";";
            }
          } else {
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000045")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(Cursor_webope_cpwarn.GetDouble("autonum"),"N",10,0)+", ";
            m_cSql = m_cSql+"autonum_name = "+CPLib.ToSQL(Cursor_webope_cpwarn.GetString("autonum_name"),"C",60,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_webope_cpwarn.GetString("tablecode"),"?",0,0,m_cServer),m_cServer,Cursor_webope_cpwarn.GetString("tablecode"))+"";
            m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_webope_cpwarn.GetString("warncode"),"?",0,0,m_cServer),m_cServer,Cursor_webope_cpwarn.GetString("warncode"))+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.eqr(m_nUpdatedRows,0)) {
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_webope",66,"00000045")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000045(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_cpwarn.GetString("tablecode"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_cpwarn.GetString("warncode"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_cpwarn.GetDouble("autonum"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webope_cpwarn.GetString("autonum_name"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
              m_cSql = m_cSql+")";
            } else {
              m_cSql = "";
            }
          }
          if ( ! (CPLib.Empty(m_cSql))) {
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          }
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          Cursor_webope_cpwarn.Next();
        }
        m_cConnectivityError = Cursor_webope_cpwarn.ErrorMessage();
        Cursor_webope_cpwarn.Close();
        // * --- End Select
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000000Dstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000000Dstatus,cTry0000000Dmsg);
        }
      }
    } finally {
      try {
        if (Cursor_webope_personbo!=null)
          Cursor_webope_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_webope_rapotit!=null)
          Cursor_webope_rapotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_webope_intestit!=null)
          Cursor_webope_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_dataope_webope_operazbo!=null)
          Cursor_qbe_dataope_webope_operazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_webope_operazbo!=null)
          Cursor_webope_operazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_webope_ope_contante!=null)
          Cursor_webope_ope_contante.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_webope_cpwarn!=null)
          Cursor_webope_cpwarn.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync() {
    return CPAsyncRoutine.CreateAsyncAndStart(
    new CPAsyncRoutine.AsyncRunnable() {
      public void Compute(CPAsyncRoutine.AsyncResult p_oResult) {
        try {
          p_oResult.m_oResult=Run();
        } finally {
          //evito di tenere nell'heap della virtual machine riferimenti non piu' usati
          m_Caller = null;
          m_Sql = null;
          m_Ctx = null;
        }
      }
    }
    );
  }
  public Forward Run() {
    Forward f;
    f = Forward.Unforwarded;
    m_Ctx = m_Ctx.DisabledDataFilteringVersion();
    try {
      try {
        try {
          try {
            m_bEventRunning = true;
            com.zucchetti.sitepainter.EventHandler.notifyEvent("Run start",this,m_Ctx,specificEventsHandlers,allEventsHandlers);
          } finally {
            m_bEventRunning = false;
          }
          Page_1();
        } finally {
          try {
            m_bEventRunning = true;
            com.zucchetti.sitepainter.EventHandler.notifyEvent(com.zucchetti.sitepainter.EventHandler.RUN_END,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
          } finally {
            m_bEventRunning = false;
          }
        }
      } catch(Forward forward) {
        f=forward;
      } catch(Stop stop_value) {
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        CPStdCounter.Error(fault);
        CallerExImpl l_oTraceSink;
        l_oTraceSink = new CallerExImpl(m_Caller,"");
        if (l_oTraceSink.HasWorkingVar("m_cFaultTrace")) {
          if ( ! (CPLib.IsAdministrator(m_Ctx)) && m_Ctx.HasAdministeredUsers()) {
            l_oTraceSink.SetString("m_cFaultTrace","C",0,0,"MSG_ADMIN_REQUIRED");
          } else {
            l_oTraceSink.SetString("m_cFaultTrace","C",0,0,CPLib.DumpException(fault));
          }
        }
      }
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_import_webopeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_webopeR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _progsto = CPLib.Space(12);
    nProgSto = CPLib.Round(0,0);
    cProgSto = CPLib.Space(15);
    _delcon = CPLib.Space(16);
    _ident = CPLib.Space(3);
    _min = CPLib.Space(11);
    _nmin = 0;
    _nmax = 0;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_dataope_webope_operazbo,
  public static final String m_cVQRList = ",qbe_dataope_webope_operazbo,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000001B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CAUSALE,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODLEGRAP,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"DATAPROF,";
    p_cSql = p_cSql+"DATAREVPROF,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DISATTIVO,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"FATTURATO,";
    p_cSql = p_cSql+"FLGNOTRIM,";
    p_cSql = p_cSql+"FREQUENZA,";
    p_cSql = p_cSql+"IMPORTOMAX,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"NUMOPERAZ,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"RAPSEGNA,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"SOGAFFIDATARIO,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"TIPOSOGGETTO,";
    p_cSql = p_cSql+"DATAIDENT,";
    p_cSql = p_cSql+"IDENT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000001C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+"EMAIL,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"NUMCEL,";
    p_cSql = p_cSql+"PEC,";
    p_cSql = p_cSql+"REFERENTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000020(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CAUSALE,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODLEGRAP,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"DATAPROF,";
    p_cSql = p_cSql+"DATAREVPROF,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DISATTIVO,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"FATTURATO,";
    p_cSql = p_cSql+"FLGNOTRIM,";
    p_cSql = p_cSql+"FREQUENZA,";
    p_cSql = p_cSql+"IMPORTOMAX,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"NUMOPERAZ,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"RAPSEGNA,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"SOGAFFIDATARIO,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"TIPOSOGGETTO,";
    p_cSql = p_cSql+"DATAIDENT,";
    p_cSql = p_cSql+"IDENT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000021(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+"EMAIL,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"NUMCEL,";
    p_cSql = p_cSql+"PEC,";
    p_cSql = p_cSql+"REFERENTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CAUSALE,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODLEGRAP,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"datamodi,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"DATAPROF,";
    p_cSql = p_cSql+"DATAREVPROF,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DISATTIVO,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"FATTURATO,";
    p_cSql = p_cSql+"FLGNOTRIM,";
    p_cSql = p_cSql+"FREQUENZA,";
    p_cSql = p_cSql+"IMPORTOMAX,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"NUMOPERAZ,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"RAPSEGNA,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"sanumpro,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"SOGAFFIDATARIO,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"TIPOSOGGETTO,";
    p_cSql = p_cSql+"DATAIDENT,";
    p_cSql = p_cSql+"IDENT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000030(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"sanumpro,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+"EMAIL,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"NUMCEL,";
    p_cSql = p_cSql+"PEC,";
    p_cSql = p_cSql+"REFERENTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000032(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000037(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPTIT,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapotit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000039(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODCLI,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"PRGIMPTITE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000040(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCLICON,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESPUNTO,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IMPPROG,";
    p_cSql = p_cSql+"MEZPAG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"PRESTAZ,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPATT,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000041(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000043(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDOPE,";
    p_cSql = p_cSql+"BILLSRIT,";
    p_cSql = p_cSql+"BILLSSOV,";
    p_cSql = p_cSql+"TIPATT,";
    p_cSql = p_cSql+"TIPOATTIV,";
    p_cSql = p_cSql+"CODICEGLN,";
    p_cSql = p_cSql+"TAGLIO,";
    p_cSql = p_cSql+"NBANCONOTE,";
    p_cSql = p_cSql+"ABIINTER,";
    p_cSql = p_cSql+"ABIPROPR,";
    p_cSql = p_cSql+"GLNALTROSOG,";
    p_cSql = p_cSql+"GLNALTRASC,";
    p_cSql = p_cSql+"CODCLICON,";
    p_cSql = p_cSql+"CODCOMCON,";
    p_cSql = p_cSql+"ATECO_CON,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"TOTALERIG,";
    p_cSql = p_cSql+"TOTALEGEN,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"ope_contante",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000045(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+"autonum_name,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
}
