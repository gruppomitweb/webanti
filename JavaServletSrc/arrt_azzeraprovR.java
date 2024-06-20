// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_azzeraprovR implements CallerWithObjs {
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
  public String m_cPhName_xoginfo;
  public String m_cServer_xoginfo;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
  public String m_cPhName_xtatorap;
  public String m_cServer_xtatorap;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_xocfrabo;
  public String m_cServer_xocfrabo;
  public String m_cPhName_xerzistifrz;
  public String m_cServer_xerzistifrz;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xeneficfrz;
  public String m_cServer_xeneficfrz;
  public String m_cPhName_xocopebo;
  public String m_cServer_xocopebo;
  public String m_cPhName_xntestit;
  public String m_cServer_xntestit;
  public String m_cPhName_xapotit;
  public String m_cServer_xapotit;
  public String m_cPhName_xerzistiope;
  public String m_cServer_xerzistiope;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_storico_import;
  public String m_cServer_storico_import;
  public String m_cPhName_xperazbo_agg;
  public String m_cServer_xperazbo_agg;
  public String m_cPhName_xraziobo_agg;
  public String m_cServer_xraziobo_agg;
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
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_azzeraprovR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_azzeraprov",m_Caller);
    m_cPhName_xoginfo = p_ContextObject.GetPhName("xoginfo");
    if (m_cPhName_xoginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xoginfo = m_cPhName_xoginfo+" "+m_Ctx.GetWritePhName("xoginfo");
    }
    m_cServer_xoginfo = p_ContextObject.GetServer("xoginfo");
    m_cPhName_xogopebo = p_ContextObject.GetPhName("xogopebo");
    if (m_cPhName_xogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopebo = m_cPhName_xogopebo+" "+m_Ctx.GetWritePhName("xogopebo");
    }
    m_cServer_xogopebo = p_ContextObject.GetServer("xogopebo");
    m_cPhName_xogopefbo = p_ContextObject.GetPhName("xogopefbo");
    if (m_cPhName_xogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopefbo = m_cPhName_xogopefbo+" "+m_Ctx.GetWritePhName("xogopefbo");
    }
    m_cServer_xogopefbo = p_ContextObject.GetServer("xogopefbo");
    m_cPhName_xtatorap = p_ContextObject.GetPhName("xtatorap");
    if (m_cPhName_xtatorap.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xtatorap = m_cPhName_xtatorap+" "+m_Ctx.GetWritePhName("xtatorap");
    }
    m_cServer_xtatorap = p_ContextObject.GetServer("xtatorap");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    if (m_cPhName_xelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xelegabo = m_cPhName_xelegabo+" "+m_Ctx.GetWritePhName("xelegabo");
    }
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    if (m_cPhName_xraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo = m_cPhName_xraziobo+" "+m_Ctx.GetWritePhName("xraziobo");
    }
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_xocfrabo = p_ContextObject.GetPhName("xocfrabo");
    if (m_cPhName_xocfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocfrabo = m_cPhName_xocfrabo+" "+m_Ctx.GetWritePhName("xocfrabo");
    }
    m_cServer_xocfrabo = p_ContextObject.GetServer("xocfrabo");
    m_cPhName_xerzistifrz = p_ContextObject.GetPhName("xerzistifrz");
    if (m_cPhName_xerzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistifrz = m_cPhName_xerzistifrz+" "+m_Ctx.GetWritePhName("xerzistifrz");
    }
    m_cServer_xerzistifrz = p_ContextObject.GetServer("xerzistifrz");
    m_cPhName_xlientifrz = p_ContextObject.GetPhName("xlientifrz");
    if (m_cPhName_xlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientifrz = m_cPhName_xlientifrz+" "+m_Ctx.GetWritePhName("xlientifrz");
    }
    m_cServer_xlientifrz = p_ContextObject.GetServer("xlientifrz");
    m_cPhName_xeneficfrz = p_ContextObject.GetPhName("xeneficfrz");
    if (m_cPhName_xeneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficfrz = m_cPhName_xeneficfrz+" "+m_Ctx.GetWritePhName("xeneficfrz");
    }
    m_cServer_xeneficfrz = p_ContextObject.GetServer("xeneficfrz");
    m_cPhName_xocopebo = p_ContextObject.GetPhName("xocopebo");
    if (m_cPhName_xocopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocopebo = m_cPhName_xocopebo+" "+m_Ctx.GetWritePhName("xocopebo");
    }
    m_cServer_xocopebo = p_ContextObject.GetServer("xocopebo");
    m_cPhName_xntestit = p_ContextObject.GetPhName("xntestit");
    if (m_cPhName_xntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestit = m_cPhName_xntestit+" "+m_Ctx.GetWritePhName("xntestit");
    }
    m_cServer_xntestit = p_ContextObject.GetServer("xntestit");
    m_cPhName_xapotit = p_ContextObject.GetPhName("xapotit");
    if (m_cPhName_xapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapotit = m_cPhName_xapotit+" "+m_Ctx.GetWritePhName("xapotit");
    }
    m_cServer_xapotit = p_ContextObject.GetServer("xapotit");
    m_cPhName_xerzistiope = p_ContextObject.GetPhName("xerzistiope");
    if (m_cPhName_xerzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistiope = m_cPhName_xerzistiope+" "+m_Ctx.GetWritePhName("xerzistiope");
    }
    m_cServer_xerzistiope = p_ContextObject.GetServer("xerzistiope");
    m_cPhName_xlientiope = p_ContextObject.GetPhName("xlientiope");
    if (m_cPhName_xlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientiope = m_cPhName_xlientiope+" "+m_Ctx.GetWritePhName("xlientiope");
    }
    m_cServer_xlientiope = p_ContextObject.GetServer("xlientiope");
    m_cPhName_xeneficope = p_ContextObject.GetPhName("xeneficope");
    if (m_cPhName_xeneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficope = m_cPhName_xeneficope+" "+m_Ctx.GetWritePhName("xeneficope");
    }
    m_cServer_xeneficope = p_ContextObject.GetServer("xeneficope");
    m_cPhName_storico_import = p_ContextObject.GetPhName("storico_import");
    if (m_cPhName_storico_import.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_storico_import = m_cPhName_storico_import+" "+m_Ctx.GetWritePhName("storico_import");
    }
    m_cServer_storico_import = p_ContextObject.GetServer("storico_import");
    m_cPhName_xperazbo_agg = p_ContextObject.GetPhName("xperazbo_agg");
    if (m_cPhName_xperazbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo_agg = m_cPhName_xperazbo_agg+" "+m_Ctx.GetWritePhName("xperazbo_agg");
    }
    m_cServer_xperazbo_agg = p_ContextObject.GetServer("xperazbo_agg");
    m_cPhName_xraziobo_agg = p_ContextObject.GetPhName("xraziobo_agg");
    if (m_cPhName_xraziobo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo_agg = m_cPhName_xraziobo_agg+" "+m_Ctx.GetWritePhName("xraziobo_agg");
    }
    m_cServer_xraziobo_agg = p_ContextObject.GetServer("xraziobo_agg");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_azzeraprov";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
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
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgImp := "Inizio cancellazione archivi provvisori" // Messaggio Import */
    gMsgImp = "Inizio cancellazione archivi provvisori";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry00000005status;
    nTry00000005status = m_Sql.GetTransactionStatus();
    String cTry00000005msg;
    cTry00000005msg = m_Sql.TransactionErrorMessage();
    try {
      /* Azzeramento Archivi Provvisori */
      /* gMsgImp := "Azzero Esecutori Rapporti" // Messaggio Import */
      gMsgImp = "Azzero Esecutori Rapporti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xoginfo
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xoginfo");
      m_cPhName = m_Ctx.GetPhName("xoginfo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xoginfo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"00000008")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Esecutori Operazioni" // Messaggio Import */
      gMsgImp = "Azzero Esecutori Operazioni";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xogopebo
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xogopebo");
      m_cPhName = m_Ctx.GetPhName("xogopebo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xogopebo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"0000000A")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Esecutori Frazionate" // Messaggio Import */
      gMsgImp = "Azzero Esecutori Frazionate";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xogopefbo
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xogopefbo");
      m_cPhName = m_Ctx.GetPhName("xogopefbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xogopefbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"0000000C")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      // * --- Delete from xtatorap
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xtatorap");
      m_cPhName = m_Ctx.GetPhName("xtatorap");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xtatorap",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"0000000D")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero intestatari Rapporti" // Messaggio Import */
      gMsgImp = "Azzero intestatari Rapporti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xntestbo
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xntestbo");
      m_cPhName = m_Ctx.GetPhName("xntestbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"0000000F")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Delegati Rapporti" // Messaggio Import */
      gMsgImp = "Azzero Delegati Rapporti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xelegabo
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xelegabo");
      m_cPhName = m_Ctx.GetPhName("xelegabo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xelegabo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"00000011")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Informazioni Rapporti" // Messaggio Import */
      gMsgImp = "Azzero Informazioni Rapporti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xapopebo
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xapopebo");
      m_cPhName = m_Ctx.GetPhName("xapopebo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"00000013")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Anagrafiche Rapporti" // Messaggio Import */
      gMsgImp = "Azzero Anagrafiche Rapporti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xnarapbo
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xnarapbo");
      m_cPhName = m_Ctx.GetPhName("xnarapbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xnarapbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"00000015")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Fiduciari Operazioni" // Messaggio Import */
      gMsgImp = "Azzero Fiduciari Operazioni";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xerzistiope
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xerzistiope");
      m_cPhName = m_Ctx.GetPhName("xerzistiope");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xerzistiope",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"00000017")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Altri Clienti Operazioni" // Messaggio Import */
      gMsgImp = "Azzero Altri Clienti Operazioni";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xlientiope
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xlientiope");
      m_cPhName = m_Ctx.GetPhName("xlientiope");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientiope",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"00000019")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Controparti Operazioni" // Messaggio Import */
      gMsgImp = "Azzero Controparti Operazioni";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xeneficope
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xeneficope");
      m_cPhName = m_Ctx.GetPhName("xeneficope");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficope",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"0000001B")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Dati Aggiuntivi Operazioni" // Messaggio Import */
      gMsgImp = "Azzero Dati Aggiuntivi Operazioni";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xperazbo_agg
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xperazbo_agg");
      m_cPhName = m_Ctx.GetPhName("xperazbo_agg");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo_agg",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"0000001D")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Operazioni" // Messaggio Import */
      gMsgImp = "Azzero Operazioni";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xperazbo
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xperazbo");
      m_cPhName = m_Ctx.GetPhName("xperazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"0000001F")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Fiduciari Frazionate" // Messaggio Import */
      gMsgImp = "Azzero Fiduciari Frazionate";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xerzistifrz
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xerzistifrz");
      m_cPhName = m_Ctx.GetPhName("xerzistifrz");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xerzistifrz",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"00000021")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Altri Clienti Frazionate" // Messaggio Import */
      gMsgImp = "Azzero Altri Clienti Frazionate";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xlientifrz
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xlientifrz");
      m_cPhName = m_Ctx.GetPhName("xlientifrz");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientifrz",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"00000023")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Controparti Frazionate" // Messaggio Import */
      gMsgImp = "Azzero Controparti Frazionate";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xeneficfrz
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xeneficfrz");
      m_cPhName = m_Ctx.GetPhName("xeneficfrz");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficfrz",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"00000025")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Dati Aggiuntivi Frazionate" // Messaggio Import */
      gMsgImp = "Azzero Dati Aggiuntivi Frazionate";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xraziobo_agg
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xraziobo_agg");
      m_cPhName = m_Ctx.GetPhName("xraziobo_agg");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo_agg",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"00000027")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Frazionate" // Messaggio Import */
      gMsgImp = "Azzero Frazionate";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xraziobo
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xraziobo");
      m_cPhName = m_Ctx.GetPhName("xraziobo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"00000029")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Legami tra soggetti" // Messaggio Import */
      gMsgImp = "Azzero Legami tra soggetti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from xntestit
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xntestit");
      m_cPhName = m_Ctx.GetPhName("xntestit");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestit",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"0000002B")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      // * --- Delete from xapotit
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xapotit");
      m_cPhName = m_Ctx.GetPhName("xapotit");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapotit",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"0000002C")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgImp := "Azzero Aggregatore Rapporti" // Messaggio Import */
      gMsgImp = "Azzero Aggregatore Rapporti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from knarapbo
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("knarapbo");
      m_cPhName = m_Ctx.GetPhName("knarapbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"0000002E")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"TIPORAP = "+CPSql.SQLValueAdapter(CPLib.ToSQL("P","?",0,0,m_cServer),m_cServer,"P")+"";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter();
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
      // * --- Delete from xocopebo
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xocopebo");
      m_cPhName = m_Ctx.GetPhName("xocopebo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xocopebo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"0000002F")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      // * --- Delete from xocfrabo
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xocfrabo");
      m_cPhName = m_Ctx.GetPhName("xocfrabo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xocfrabo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"00000030")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      // * --- Write into storico_import from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("storico_import");
      m_cPhName = m_Ctx.GetPhName("storico_import");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"storico_import",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_azzeraprov",12,"00000032")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"ELIM_IMP = "+CPLib.ToSQL(CPLib.DateTime(),"T",14,0)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"storico_import",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"ELIM_IMP is null";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter();
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
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000005status,0)) {
        m_Sql.SetTransactionStatus(nTry00000005status,cTry00000005msg);
      }
    }
    /* gMsgImp := "Elaborazione terminata con successo!" // Messaggio Import */
    gMsgImp = "Elaborazione terminata con successo!";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
  }
  void _init_() {
  }
  public String RunAsync() {
    return CPAsyncRoutine.CreateAsyncAndStart(
    new CPAsyncRoutine.AsyncRunnable() {
      public void Compute(CPAsyncRoutine.AsyncResult p_oResult) {
        try {
          p_oResult.m_oResult=new Stop(Run());
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
  public String Run() {
    String l_result;
    l_result = "";
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
      } catch(Stop stop_value) {
        l_result = stop_value.GetString();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = "";
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return l_result;
  }
  public static arrt_azzeraprovR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_azzeraprovR(p_Ctx, p_Caller);
  }
  public static arrt_azzeraprovR Make(CPContext p_Ctx) {
    return new arrt_azzeraprovR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_azzeraprov,
  public static final String i_InvokedRoutines = ",arrt_azzeraprov,";
  public static String[] m_cRunParameterNames={};
}
