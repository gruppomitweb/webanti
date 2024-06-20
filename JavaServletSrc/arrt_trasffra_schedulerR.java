// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_trasffra_schedulerR implements CallerWithObjs {
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
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_docfrabo;
  public String m_cServer_docfrabo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_fraziobo_agg;
  public String m_cServer_fraziobo_agg;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_xeneficfrz;
  public String m_cServer_xeneficfrz;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_xerzistifrz;
  public String m_cServer_xerzistifrz;
  public String m_cPhName_xerzistiope;
  public String m_cServer_xerzistiope;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xocfrabo;
  public String m_cServer_xocfrabo;
  public String m_cPhName_xocopebo;
  public String m_cServer_xocopebo;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xperazbo_agg;
  public String m_cServer_xperazbo_agg;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
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
  public String cProg1;
  public String cProg2;
  public String w_idbase;
  public double _conta;
  public String w_cdaope;
  public String w_c_aope;
  public String w_datreg;
  public double _min;
  public double _max;
  public double _tot;
  public double _cicli;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public java.sql.Date _maxreg;
  public java.sql.Date _minreg;
  public String _gAzienda;
  public String gMsgImp;
  public String _gMsgProc;
  public java.sql.Date _minope;
  public String cProg;
  public String _errore;
  public java.sql.Date _datareg;
  public double _flgdatareg;
  public double _daysmin;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_trasffra_schedulerR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_trasffra_scheduler",m_Caller);
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    if (m_cPhName_beneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficfrz = m_cPhName_beneficfrz+" "+m_Ctx.GetWritePhName("beneficfrz");
    }
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_docfrabo = p_ContextObject.GetPhName("docfrabo");
    if (m_cPhName_docfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docfrabo = m_cPhName_docfrabo+" "+m_Ctx.GetWritePhName("docfrabo");
    }
    m_cServer_docfrabo = p_ContextObject.GetServer("docfrabo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_fraziobo_agg = p_ContextObject.GetPhName("fraziobo_agg");
    if (m_cPhName_fraziobo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo_agg = m_cPhName_fraziobo_agg+" "+m_Ctx.GetWritePhName("fraziobo_agg");
    }
    m_cServer_fraziobo_agg = p_ContextObject.GetServer("fraziobo_agg");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    if (m_cPhName_sogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopefbo = m_cPhName_sogopefbo+" "+m_Ctx.GetWritePhName("sogopefbo");
    }
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    m_cPhName_terzistifrz = p_ContextObject.GetPhName("terzistifrz");
    if (m_cPhName_terzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistifrz = m_cPhName_terzistifrz+" "+m_Ctx.GetWritePhName("terzistifrz");
    }
    m_cServer_terzistifrz = p_ContextObject.GetServer("terzistifrz");
    m_cPhName_xeneficfrz = p_ContextObject.GetPhName("xeneficfrz");
    if (m_cPhName_xeneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficfrz = m_cPhName_xeneficfrz+" "+m_Ctx.GetWritePhName("xeneficfrz");
    }
    m_cServer_xeneficfrz = p_ContextObject.GetServer("xeneficfrz");
    m_cPhName_xeneficope = p_ContextObject.GetPhName("xeneficope");
    if (m_cPhName_xeneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficope = m_cPhName_xeneficope+" "+m_Ctx.GetWritePhName("xeneficope");
    }
    m_cServer_xeneficope = p_ContextObject.GetServer("xeneficope");
    m_cPhName_xerzistifrz = p_ContextObject.GetPhName("xerzistifrz");
    if (m_cPhName_xerzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistifrz = m_cPhName_xerzistifrz+" "+m_Ctx.GetWritePhName("xerzistifrz");
    }
    m_cServer_xerzistifrz = p_ContextObject.GetServer("xerzistifrz");
    m_cPhName_xerzistiope = p_ContextObject.GetPhName("xerzistiope");
    if (m_cPhName_xerzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistiope = m_cPhName_xerzistiope+" "+m_Ctx.GetWritePhName("xerzistiope");
    }
    m_cServer_xerzistiope = p_ContextObject.GetServer("xerzistiope");
    m_cPhName_xlientifrz = p_ContextObject.GetPhName("xlientifrz");
    if (m_cPhName_xlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientifrz = m_cPhName_xlientifrz+" "+m_Ctx.GetWritePhName("xlientifrz");
    }
    m_cServer_xlientifrz = p_ContextObject.GetServer("xlientifrz");
    m_cPhName_xlientiope = p_ContextObject.GetPhName("xlientiope");
    if (m_cPhName_xlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientiope = m_cPhName_xlientiope+" "+m_Ctx.GetWritePhName("xlientiope");
    }
    m_cServer_xlientiope = p_ContextObject.GetServer("xlientiope");
    m_cPhName_xocfrabo = p_ContextObject.GetPhName("xocfrabo");
    if (m_cPhName_xocfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocfrabo = m_cPhName_xocfrabo+" "+m_Ctx.GetWritePhName("xocfrabo");
    }
    m_cServer_xocfrabo = p_ContextObject.GetServer("xocfrabo");
    m_cPhName_xocopebo = p_ContextObject.GetPhName("xocopebo");
    if (m_cPhName_xocopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocopebo = m_cPhName_xocopebo+" "+m_Ctx.GetWritePhName("xocopebo");
    }
    m_cServer_xocopebo = p_ContextObject.GetServer("xocopebo");
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
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xperazbo_agg = p_ContextObject.GetPhName("xperazbo_agg");
    if (m_cPhName_xperazbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo_agg = m_cPhName_xperazbo_agg+" "+m_Ctx.GetWritePhName("xperazbo_agg");
    }
    m_cServer_xperazbo_agg = p_ContextObject.GetServer("xperazbo_agg");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    if (m_cPhName_xraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo = m_cPhName_xraziobo+" "+m_Ctx.GetWritePhName("xraziobo");
    }
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_xraziobo_agg = p_ContextObject.GetPhName("xraziobo_agg");
    if (m_cPhName_xraziobo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo_agg = m_cPhName_xraziobo_agg+" "+m_Ctx.GetWritePhName("xraziobo_agg");
    }
    m_cServer_xraziobo_agg = p_ContextObject.GetServer("xraziobo_agg");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      return _contacicli;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_flgdatareg",p_cVarName)) {
      return _flgdatareg;
    }
    if (CPLib.eqr("_daysmin",p_cVarName)) {
      return _daysmin;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_trasffra_scheduler";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("cProg1",p_cVarName)) {
      return cProg1;
    }
    if (CPLib.eqr("cProg2",p_cVarName)) {
      return cProg2;
    }
    if (CPLib.eqr("idbase",p_cVarName)) {
      return w_idbase;
    }
    if (CPLib.eqr("cdaope",p_cVarName)) {
      return w_cdaope;
    }
    if (CPLib.eqr("c_aope",p_cVarName)) {
      return w_c_aope;
    }
    if (CPLib.eqr("datreg",p_cVarName)) {
      return w_datreg;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      return _gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      return _gMsgProc;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_maxreg",p_cVarName)) {
      return _maxreg;
    }
    if (CPLib.eqr("_minreg",p_cVarName)) {
      return _minreg;
    }
    if (CPLib.eqr("_minope",p_cVarName)) {
      return _minope;
    }
    if (CPLib.eqr("_datareg",p_cVarName)) {
      return _datareg;
    }
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
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      _contacicli = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_flgdatareg",p_cVarName)) {
      _flgdatareg = value;
      return;
    }
    if (CPLib.eqr("_daysmin",p_cVarName)) {
      _daysmin = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("cProg1",p_cVarName)) {
      cProg1 = value;
      return;
    }
    if (CPLib.eqr("cProg2",p_cVarName)) {
      cProg2 = value;
      return;
    }
    if (CPLib.eqr("idbase",p_cVarName)) {
      w_idbase = value;
      return;
    }
    if (CPLib.eqr("cdaope",p_cVarName)) {
      w_cdaope = value;
      return;
    }
    if (CPLib.eqr("c_aope",p_cVarName)) {
      w_c_aope = value;
      return;
    }
    if (CPLib.eqr("datreg",p_cVarName)) {
      w_datreg = value;
      return;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      _gAzienda = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      _gMsgProc = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_maxreg",p_cVarName)) {
      _maxreg = value;
      return;
    }
    if (CPLib.eqr("_minreg",p_cVarName)) {
      _minreg = value;
      return;
    }
    if (CPLib.eqr("_minope",p_cVarName)) {
      _minope = value;
      return;
    }
    if (CPLib.eqr("_datareg",p_cVarName)) {
      _datareg = value;
      return;
    }
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
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_trasffra_datope=null;
    CPResultSet Cursor_qbe_trasffra_count_fra=null;
    CPResultSet Cursor_qbe_trasffra_idbase_fra=null;
    CPResultSet Cursor_xraziobo=null;
    CPResultSet Cursor_xraziobo_agg=null;
    CPResultSet Cursor_xogopefbo=null;
    CPResultSet Cursor_xlientifrz=null;
    CPResultSet Cursor_xeneficfrz=null;
    CPResultSet Cursor_xerzistifrz=null;
    CPResultSet Cursor_xocfrabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* cProg1 Char(10) */
      /* cProg2 Char(11) */
      /* w_idbase Char(10) */
      /* _conta Numeric(10, 0) */
      /* w_cdaope Char(8) */
      /* w_c_aope Char(8) */
      /* w_datreg Char(8) */
      /* _min Numeric(10, 0) */
      /* _max Numeric(10, 0) */
      /* _tot Numeric(10, 0) */
      /* _cicli Numeric(10, 0) */
      /* _contacicli Numeric(10, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _maxreg Date */
      /* _minreg Date */
      /* _gAzienda Char(10) // Azienda */
      /* gMsgImp Char(10) // Messaggio Import */
      /* _gMsgProc Memo // Messaggio */
      /* _minope Date */
      /* cProg Char(20) */
      /* _errore Memo */
      /* _datareg Date */
      /* _flgdatareg Numeric(1, 0) */
      /* _daysmin Numeric(3, 0) */
      /* Scorre la query e trasferisce i dati */
      /* _gMsgProc := 'Ora Inizio Trasferimento: '+ arfn_fdatetime(DateTime()) + NL */
      _gMsgProc = "Ora Inizio Trasferimento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      // * --- Select from cpazi
      m_cServer = m_Ctx.GetServer("cpazi");
      m_cPhName = m_Ctx.GetPhName("cpazi");
      if (Cursor_cpazi!=null)
        Cursor_cpazi.Close();
      Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cpazi.Eof())) {
        /* Utilities.SetCompany(LRTrim(cpazi->codazi)) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(CPLib.LRTrim(Cursor_cpazi.GetString("codazi")));
        /* _gAzienda := LRTrim(cpazi->codazi) // Azienda */
        _gAzienda = CPLib.LRTrim(Cursor_cpazi.GetString("codazi"));
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* _flgdatareg := intermbo->FLGDATATP */
          _flgdatareg = CPLib.Round(Cursor_intermbo.GetDouble("FLGDATATP"),0);
          /* _daysmin := intermbo->NUMGIORN */
          _daysmin = CPLib.Round(Cursor_intermbo.GetDouble("NUMGIORN"),0);
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* _minope := arfn_dateminus(Date(),_daysmin) */
        _minope = arfn_dateminusR.Make(m_Ctx,this).Run(CPLib.Date(),_daysmin);
        /* w_cdaope := "" */
        w_cdaope = "";
        /* w_c_aope := DateToChar(_minope) */
        w_c_aope = CPLib.DateToChar(_minope);
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000028status;
        nTry00000028status = m_Sql.GetTransactionStatus();
        String cTry00000028msg;
        cTry00000028msg = m_Sql.TransactionErrorMessage();
        try {
          // * --- Select from qbe_trasffra_datope
          SPBridge.HMCaller _h00000029;
          _h00000029 = new SPBridge.HMCaller();
          _h00000029.Set("m_cVQRList",m_cVQRList);
          _h00000029.Set("cdaope",w_cdaope);
          _h00000029.Set("c_aope",w_c_aope);
          if (Cursor_qbe_trasffra_datope!=null)
            Cursor_qbe_trasffra_datope.Close();
          Cursor_qbe_trasffra_datope = new VQRHolder("qbe_trasffra_datope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000029,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_trasffra_datope.Eof())) {
            /* w_datreg := DateToChar(qbe_trasffra_datope->DATAOPE) */
            w_datreg = CPLib.DateToChar(Cursor_qbe_trasffra_datope.GetDate("DATAOPE"));
            // * --- Select from qbe_trasffra_count_fra
            SPBridge.HMCaller _h0000002B;
            _h0000002B = new SPBridge.HMCaller();
            _h0000002B.Set("m_cVQRList",m_cVQRList);
            _h0000002B.Set("datreg",w_datreg);
            if (Cursor_qbe_trasffra_count_fra!=null)
              Cursor_qbe_trasffra_count_fra.Close();
            Cursor_qbe_trasffra_count_fra = new VQRHolder("qbe_trasffra_count_fra",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002B,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_trasffra_count_fra.Eof())) {
              /* _min := qbe_trasffra_count_fra->MINOPE */
              _min = CPLib.Round(Cursor_qbe_trasffra_count_fra.GetDouble("MINOPE"),0);
              /* _max := qbe_trasffra_count_fra->MAXOPE */
              _max = CPLib.Round(Cursor_qbe_trasffra_count_fra.GetDouble("MAXOPE"),0);
              /* _tot := qbe_trasffra_count_fra->TOTOPE */
              _tot = CPLib.Round(Cursor_qbe_trasffra_count_fra.GetDouble("TOTOPE"),0);
              Cursor_qbe_trasffra_count_fra.Next();
            }
            m_cConnectivityError = Cursor_qbe_trasffra_count_fra.ErrorMessage();
            Cursor_qbe_trasffra_count_fra.Close();
            // * --- End Select
            /* If _tot < 5000 */
            if (CPLib.lt(_tot,5000)) {
              /* _cicli := iif(_tot=0,0,1) */
              _cicli = CPLib.Round((CPLib.eqr(_tot,0)?0:1),0);
            } else { // Else
              /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
              _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
            } // End If
            /* _contacicli := 1 */
            _contacicli = CPLib.Round(1,0);
            /* While _contacicli<=_cicli */
            while (CPLib.le(_contacicli,_cicli)) {
              /* If _cicli = 1 */
              if (CPLib.eqr(_cicli,1)) {
                /* _bottom := _min */
                _bottom = CPLib.Round(_min,0);
                /* _top := _max */
                _top = CPLib.Round(_max,0);
              } else { // Else
                /* _bottom := ((_contacicli -1 ) * 5000) + 1 */
                _bottom = CPLib.Round(((_contacicli-1)*5000)+1,0);
                /* _top := _contacicli * 5000 */
                _top = CPLib.Round(_contacicli*5000,0);
              } // End If
              /* If _top>=_min */
              if (CPLib.ge(_top,_min)) {
                // * --- Select from qbe_trasffra_idbase_fra
                if (Cursor_qbe_trasffra_idbase_fra!=null)
                  Cursor_qbe_trasffra_idbase_fra.Close();
                Cursor_qbe_trasffra_idbase_fra = new VQRHolder("qbe_trasffra_idbase_fra",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
                while ( ! (Cursor_qbe_trasffra_idbase_fra.Eof())) {
                  /* w_idbase := qbe_trasffra_idbase_fra->IDBASE */
                  w_idbase = Cursor_qbe_trasffra_idbase_fra.GetString("IDBASE");
                  // * --- Select from xraziobo
                  m_cServer = m_Ctx.GetServer("xraziobo");
                  m_cPhName = m_Ctx.GetPhName("xraziobo");
                  if (Cursor_xraziobo!=null)
                    Cursor_xraziobo.Close();
                  Cursor_xraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,w_idbase)+" "+")"+(m_Ctx.IsSharedTemp("xraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_xraziobo.Eof())) {
                    /* Calcol i nuovi progressivi */
                    /* cProg1 := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(_gAzienda)+"'",Space(10),10) */
                    cProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(_gAzienda)+"'",CPLib.Space(10),10);
                    /* cProg2 := Utilities.GetAutonumber("PFRAZIO2\'"+LRTrim(_gAzienda)+"'",Space(11),11) */
                    cProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO2\\'"+CPLib.LRTrim(_gAzienda)+"'",CPLib.Space(11),11);
                    /* _datareg := Date() */
                    _datareg = CPLib.Date();
                    // * --- Insert into fraziobo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("fraziobo");
                    m_cPhName = m_Ctx.GetPhName("fraziobo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_scheduler",82,"00000041")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000041(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_xraziobo.GetDate("DATAOPE"))+cProg2+"Z","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datareg,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDate("DATARETT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("RIMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("RAREA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("PRGIMPFRZ"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datareg),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("ANNOOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo",true);
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
                    // * --- Select from xraziobo_agg
                    m_cServer = m_Ctx.GetServer("xraziobo_agg");
                    m_cPhName = m_Ctx.GetPhName("xraziobo_agg");
                    if (Cursor_xraziobo_agg!=null)
                      Cursor_xraziobo_agg.Close();
                    Cursor_xraziobo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,w_idbase)+" "+")"+(m_Ctx.IsSharedTemp("xraziobo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xraziobo_agg.Eof())) {
                      // * --- Insert into fraziobo_agg from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("fraziobo_agg");
                      m_cPhName = m_Ctx.GetPhName("fraziobo_agg");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo_agg",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_scheduler",82,"00000043")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000043(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetDouble("CACODICE"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("IDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetDateTime("CADATAORA"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetDouble("CATIPGIO"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetDouble("CATIPCON"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetDouble("CAPV_COD"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("IDDOCALL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("VPCODICE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetDate("WUDATRET"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo_agg",true);
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
                      // * --- Delete from xraziobo_agg
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xraziobo_agg");
                      m_cPhName = m_Ctx.GetPhName("xraziobo_agg");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo_agg",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_scheduler",82,"00000044")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"?",0,0,m_cServer),m_cServer,w_idbase)+"";
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
                      Cursor_xraziobo_agg.Next();
                    }
                    m_cConnectivityError = Cursor_xraziobo_agg.ErrorMessage();
                    Cursor_xraziobo_agg.Close();
                    // * --- End Select
                    // * --- Select from xogopefbo
                    m_cServer = m_Ctx.GetServer("xogopefbo");
                    m_cPhName = m_Ctx.GetPhName("xogopefbo");
                    if (Cursor_xogopefbo!=null)
                      Cursor_xogopefbo.Close();
                    Cursor_xogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xogopefbo.Eof())) {
                      // * --- Insert into sogopefbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("sogopefbo");
                      m_cPhName = m_Ctx.GetPhName("sogopefbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_scheduler",82,"00000046")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000046(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xogopefbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xogopefbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sogopefbo",true);
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
                      // * --- Delete from xogopebo
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xogopebo");
                      m_cPhName = m_Ctx.GetPhName("xogopebo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xogopebo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_scheduler",82,"00000047")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xogopefbo.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xogopefbo.GetString("IDFILEBO"))+"";
                      m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xogopefbo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_xogopefbo.GetDouble("CPROWNUM"))+"";
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
                      Cursor_xogopefbo.Next();
                    }
                    m_cConnectivityError = Cursor_xogopefbo.ErrorMessage();
                    Cursor_xogopefbo.Close();
                    // * --- End Select
                    // * --- Select from xlientifrz
                    m_cServer = m_Ctx.GetServer("xlientifrz");
                    m_cPhName = m_Ctx.GetPhName("xlientifrz");
                    if (Cursor_xlientifrz!=null)
                      Cursor_xlientifrz.Close();
                    Cursor_xlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xlientifrz.Eof())) {
                      // * --- Insert into clientifrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("clientifrz");
                      m_cPhName = m_Ctx.GetPhName("clientifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_scheduler",82,"00000049")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000049(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"clientifrz",true);
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
                      // * --- Delete from xlientifrz
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xlientifrz");
                      m_cPhName = m_Ctx.GetPhName("xlientifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_scheduler",82,"0000004A")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xlientifrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xlientifrz.GetString("IDFILEBO"))+"";
                      m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xlientifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xlientifrz.GetString("CODSOG"))+"";
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
                      Cursor_xlientifrz.Next();
                    }
                    m_cConnectivityError = Cursor_xlientifrz.ErrorMessage();
                    Cursor_xlientifrz.Close();
                    // * --- End Select
                    // * --- Select from xeneficfrz
                    m_cServer = m_Ctx.GetServer("xeneficfrz");
                    m_cPhName = m_Ctx.GetPhName("xeneficfrz");
                    if (Cursor_xeneficfrz!=null)
                      Cursor_xeneficfrz.Close();
                    Cursor_xeneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xeneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xeneficfrz.Eof())) {
                      // * --- Insert into beneficfrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("beneficfrz");
                      m_cPhName = m_Ctx.GetPhName("beneficfrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_scheduler",82,"0000004C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000004C(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetDouble("CPROWNUM"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"beneficfrz",true);
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
                      // * --- Delete from xeneficfrz
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xeneficfrz");
                      m_cPhName = m_Ctx.GetPhName("xeneficfrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficfrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_scheduler",82,"0000004D")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xeneficfrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xeneficfrz.GetString("IDFILEBO"))+"";
                      m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xeneficfrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xeneficfrz.GetString("CODSOG"))+"";
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
                      Cursor_xeneficfrz.Next();
                    }
                    m_cConnectivityError = Cursor_xeneficfrz.ErrorMessage();
                    Cursor_xeneficfrz.Close();
                    // * --- End Select
                    // * --- Select from xerzistifrz
                    m_cServer = m_Ctx.GetServer("xerzistifrz");
                    m_cPhName = m_Ctx.GetPhName("xerzistifrz");
                    if (Cursor_xerzistifrz!=null)
                      Cursor_xerzistifrz.Close();
                    Cursor_xerzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xerzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xerzistifrz.Eof())) {
                      // * --- Insert into terzistifrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("terzistifrz");
                      m_cPhName = m_Ctx.GetPhName("terzistifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_scheduler",82,"0000004F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000004F(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"terzistifrz",true);
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
                      // * --- Delete from xerzistifrz
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xerzistifrz");
                      m_cPhName = m_Ctx.GetPhName("xerzistifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xerzistifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_scheduler",82,"00000050")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xerzistifrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xerzistifrz.GetString("IDFILEBO"))+"";
                      m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xerzistifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xerzistifrz.GetString("CODSOG"))+"";
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
                      Cursor_xerzistifrz.Next();
                    }
                    m_cConnectivityError = Cursor_xerzistifrz.ErrorMessage();
                    Cursor_xerzistifrz.Close();
                    // * --- End Select
                    // * --- Select from xocfrabo
                    m_cServer = m_Ctx.GetServer("xocfrabo");
                    m_cPhName = m_Ctx.GetPhName("xocfrabo");
                    if (Cursor_xocfrabo!=null)
                      Cursor_xocfrabo.Close();
                    Cursor_xocfrabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_xraziobo.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xocfrabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xocfrabo.Eof())) {
                      // * --- Insert into docfrabo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("docfrabo");
                      m_cPhName = m_Ctx.GetPhName("docfrabo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"docfrabo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_scheduler",82,"00000052")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000052(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetDate("DATARILASC"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetDate("DATAVALI"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"docfrabo",true);
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
                      // * --- Delete from xocfrabo
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xocfrabo");
                      m_cPhName = m_Ctx.GetPhName("xocfrabo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xocfrabo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_scheduler",82,"00000053")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xocfrabo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_xocfrabo.GetString("NUMPROG"))+"";
                      m_cSql = m_cSql+" and CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xocfrabo.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_xocfrabo.GetString("CONNESCLI"))+"";
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
                      Cursor_xocfrabo.Next();
                    }
                    m_cConnectivityError = Cursor_xocfrabo.ErrorMessage();
                    Cursor_xocfrabo.Close();
                    // * --- End Select
                    /* If False */
                    if (false) {
                      /* Exec Routine arrt_writelog('TRASF_SCHED','FRAZIOBO',xraziobo->NUMPROG,"Ho trasferito la frazionata con ID BIGLIETTO:"+LRTrim(xraziobo->RIFIMP),'S') */
                      arrt_writelogR.Make(m_Ctx,this).Run("TRASF_SCHED","FRAZIOBO",Cursor_xraziobo.GetString("NUMPROG"),"Ho trasferito la frazionata con ID BIGLIETTO:"+CPLib.LRTrim(Cursor_xraziobo.GetString("RIFIMP")),"S");
                    } // End If
                    // * --- Delete from xraziobo
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("xraziobo");
                    m_cPhName = m_Ctx.GetPhName("xraziobo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_trasffra_scheduler",82,"00000056")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"?",0,0,m_cServer),m_cServer,w_idbase)+"";
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
                    /* _conta := _conta + 1 */
                    _conta = CPLib.Round(_conta+1,0);
                    Cursor_xraziobo.Next();
                  }
                  m_cConnectivityError = Cursor_xraziobo.ErrorMessage();
                  Cursor_xraziobo.Close();
                  // * --- End Select
                  Cursor_qbe_trasffra_idbase_fra.Next();
                }
                m_cConnectivityError = Cursor_qbe_trasffra_idbase_fra.ErrorMessage();
                Cursor_qbe_trasffra_idbase_fra.Close();
                // * --- End Select
              } else { // Else
              } // End If
              /* _contacicli := _contacicli+1 */
              _contacicli = CPLib.Round(_contacicli+1,0);
            } // End While
            Cursor_qbe_trasffra_datope.Next();
          }
          m_cConnectivityError = Cursor_qbe_trasffra_datope.ErrorMessage();
          Cursor_qbe_trasffra_datope.Close();
          // * --- End Select
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
          /* _gMsgProc := _gMsgProc + 'Trasferite '+LRTrim(Str(_conta,10,0))+" frazionate" + NL */
          _gMsgProc = _gMsgProc+"Trasferite "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" frazionate"+"\n";
          /* _gMsgProc := _gMsgProc + 'Ora Fine Trasferimento: '+ arfn_fdatetime(DateTime()) + NL */
          _gMsgProc = _gMsgProc+"Ora Fine Trasferimento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
          /* _errore := l_exeption.toString() */
          _errore = l_exeption.toString();
          /* _gMsgProc := _gMsgProc + 'Trasferite '+LRTrim(Str(_conta,10,0))+" frazionate" + NL */
          _gMsgProc = _gMsgProc+"Trasferite "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" frazionate"+"\n";
          /* _gMsgProc := _gMsgProc + _errore + NL */
          _gMsgProc = _gMsgProc+_errore+"\n";
          /* _gMsgProc := _gMsgProc + 'Ora Fine Trasferimento: '+ arfn_fdatetime(DateTime()) + NL */
          _gMsgProc = _gMsgProc+"Ora Fine Trasferimento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000028status,0)) {
            m_Sql.SetTransactionStatus(nTry00000028status,cTry00000028msg);
          }
        }
        /* Exec Routine arrt_writelog('TRASF_SCHED','FRAZIOBO',"",_gMsgProc,'S') */
        arrt_writelogR.Make(m_Ctx,this).Run("TRASF_SCHED","FRAZIOBO","",_gMsgProc,"S");
        Cursor_cpazi.Next();
      }
      m_cConnectivityError = Cursor_cpazi.ErrorMessage();
      Cursor_cpazi.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasffra_datope!=null)
          Cursor_qbe_trasffra_datope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasffra_count_fra!=null)
          Cursor_qbe_trasffra_count_fra.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasffra_idbase_fra!=null)
          Cursor_qbe_trasffra_idbase_fra.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xraziobo!=null)
          Cursor_xraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xraziobo_agg!=null)
          Cursor_xraziobo_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xogopefbo!=null)
          Cursor_xogopefbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xlientifrz!=null)
          Cursor_xlientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xeneficfrz!=null)
          Cursor_xeneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xerzistifrz!=null)
          Cursor_xerzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xocfrabo!=null)
          Cursor_xocfrabo.Close();
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
  public static arrt_trasffra_schedulerR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_trasffra_schedulerR(p_Ctx, p_Caller);
  }
  public void Blank() {
    cProg1 = CPLib.Space(10);
    cProg2 = CPLib.Space(11);
    w_idbase = CPLib.Space(10);
    _conta = 0;
    w_cdaope = CPLib.Space(8);
    w_c_aope = CPLib.Space(8);
    w_datreg = CPLib.Space(8);
    _min = 0;
    _max = 0;
    _tot = 0;
    _cicli = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _maxreg = CPLib.NullDate();
    _minreg = CPLib.NullDate();
    _gAzienda = CPLib.Space(10);
    _gMsgProc = "";
    _minope = CPLib.NullDate();
    cProg = CPLib.Space(20);
    _errore = "";
    _datareg = CPLib.NullDate();
    _flgdatareg = 0;
    _daysmin = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_trasffra_datope,qbe_trasffra_count_fra,qbe_trasffra_idbase_fra,
  public static final String m_cVQRList = ",qbe_trasffra_datope,qbe_trasffra_count_fra,qbe_trasffra_idbase_fra,";
  // ENTITY_BATCHES: ,arfn_dateminus,arfn_fdatetime,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_dateminus,arfn_fdatetime,arrt_writelog,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000041(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
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
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000043(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"IDBIGLIETTO,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+"IDDOCALL,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+"WUDATRET,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000046(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopefbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000049(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000004C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"beneficfrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000004F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"terzistifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000052(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"docfrabo",true);
    return p_cSql;
  }
}
