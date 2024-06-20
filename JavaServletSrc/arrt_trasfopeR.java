// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_trasfopeR implements CallerWithObjs {
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
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_docopebo;
  public String m_cServer_docopebo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_operazbo_agg;
  public String m_cServer_operazbo_agg;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_xerzistiope;
  public String m_cServer_xerzistiope;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xocopebo;
  public String m_cServer_xocopebo;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xperazbo_agg;
  public String m_cServer_xperazbo_agg;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_xapcoll;
  public String m_cServer_xapcoll;
  public String m_cPhName_rapcoll;
  public String m_cServer_rapcoll;
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
  public java.sql.Date pDatIni;
  public java.sql.Date pDatFin;
  public String pForza;
  public String pInform;
  public String cProg1;
  public String cProg2;
  public String w_idbase;
  public double _conta;
  public String w_cdaope;
  public String w_c_aope;
  public String w_cdareg;
  public String w_c_areg;
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
  public String idb2;
  public java.sql.Date _datareg;
  public String _idrif;
  public double _totale;
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public String w_flgforce;
  public boolean passato_il_check;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public double gFlgDTP;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_trasfopeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_trasfope",m_Caller);
    m_cPhName_beneficope = p_ContextObject.GetPhName("beneficope");
    if (m_cPhName_beneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficope = m_cPhName_beneficope+" "+m_Ctx.GetWritePhName("beneficope");
    }
    m_cServer_beneficope = p_ContextObject.GetServer("beneficope");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_docopebo = p_ContextObject.GetPhName("docopebo");
    if (m_cPhName_docopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docopebo = m_cPhName_docopebo+" "+m_Ctx.GetWritePhName("docopebo");
    }
    m_cServer_docopebo = p_ContextObject.GetServer("docopebo");
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
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_terzistiope = p_ContextObject.GetPhName("terzistiope");
    if (m_cPhName_terzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistiope = m_cPhName_terzistiope+" "+m_Ctx.GetWritePhName("terzistiope");
    }
    m_cServer_terzistiope = p_ContextObject.GetServer("terzistiope");
    m_cPhName_xeneficope = p_ContextObject.GetPhName("xeneficope");
    if (m_cPhName_xeneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficope = m_cPhName_xeneficope+" "+m_Ctx.GetWritePhName("xeneficope");
    }
    m_cServer_xeneficope = p_ContextObject.GetServer("xeneficope");
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
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_xapcoll = p_ContextObject.GetPhName("xapcoll");
    if (m_cPhName_xapcoll.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapcoll = m_cPhName_xapcoll+" "+m_Ctx.GetWritePhName("xapcoll");
    }
    m_cServer_xapcoll = p_ContextObject.GetServer("xapcoll");
    m_cPhName_rapcoll = p_ContextObject.GetPhName("rapcoll");
    if (m_cPhName_rapcoll.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapcoll = m_cPhName_rapcoll+" "+m_Ctx.GetWritePhName("rapcoll");
    }
    m_cServer_rapcoll = p_ContextObject.GetServer("rapcoll");
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
    if (CPLib.eqr("_totale",p_cVarName)) {
      return _totale;
    }
    if (CPLib.eqr("gFlgDTP",p_cVarName)) {
      return gFlgDTP;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_trasfope";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pForza",p_cVarName)) {
      return pForza;
    }
    if (CPLib.eqr("pInform",p_cVarName)) {
      return pInform;
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
    if (CPLib.eqr("cdareg",p_cVarName)) {
      return w_cdareg;
    }
    if (CPLib.eqr("c_areg",p_cVarName)) {
      return w_c_areg;
    }
    if (CPLib.eqr("datreg",p_cVarName)) {
      return w_datreg;
    }
    if (CPLib.eqr("idb2",p_cVarName)) {
      return idb2;
    }
    if (CPLib.eqr("_idrif",p_cVarName)) {
      return _idrif;
    }
    if (CPLib.eqr("flgforce",p_cVarName)) {
      return w_flgforce;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDatIni",p_cVarName)) {
      return pDatIni;
    }
    if (CPLib.eqr("pDatFin",p_cVarName)) {
      return pDatFin;
    }
    if (CPLib.eqr("_maxreg",p_cVarName)) {
      return _maxreg;
    }
    if (CPLib.eqr("_minreg",p_cVarName)) {
      return _minreg;
    }
    if (CPLib.eqr("_datareg",p_cVarName)) {
      return _datareg;
    }
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      return w_DaDatOpe;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      return w_ADatOpe;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("passato_il_check",p_cVarName)) {
      return passato_il_check;
    }
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
    if (CPLib.eqr("_totale",p_cVarName)) {
      _totale = value;
      return;
    }
    if (CPLib.eqr("gFlgDTP",p_cVarName)) {
      gFlgDTP = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pForza",p_cVarName)) {
      pForza = value;
      return;
    }
    if (CPLib.eqr("pInform",p_cVarName)) {
      pInform = value;
      return;
    }
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
    if (CPLib.eqr("cdareg",p_cVarName)) {
      w_cdareg = value;
      return;
    }
    if (CPLib.eqr("c_areg",p_cVarName)) {
      w_c_areg = value;
      return;
    }
    if (CPLib.eqr("datreg",p_cVarName)) {
      w_datreg = value;
      return;
    }
    if (CPLib.eqr("idb2",p_cVarName)) {
      idb2 = value;
      return;
    }
    if (CPLib.eqr("_idrif",p_cVarName)) {
      _idrif = value;
      return;
    }
    if (CPLib.eqr("flgforce",p_cVarName)) {
      w_flgforce = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDatIni",p_cVarName)) {
      pDatIni = value;
      return;
    }
    if (CPLib.eqr("pDatFin",p_cVarName)) {
      pDatFin = value;
      return;
    }
    if (CPLib.eqr("_maxreg",p_cVarName)) {
      _maxreg = value;
      return;
    }
    if (CPLib.eqr("_minreg",p_cVarName)) {
      _minreg = value;
      return;
    }
    if (CPLib.eqr("_datareg",p_cVarName)) {
      _datareg = value;
      return;
    }
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      w_DaDatOpe = value;
      return;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      w_ADatOpe = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("passato_il_check",p_cVarName)) {
      passato_il_check = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void main() throws Exception {
    CPResultSet Cursor_qbe_trasfope_datope=null;
    CPResultSet Cursor_qbe_trasfope_count_ope=null;
    CPResultSet Cursor_qbe_trasfope_idbase_ope=null;
    CPResultSet Cursor_xperazbo=null;
    CPResultSet Cursor_xperazbo_agg=null;
    CPResultSet Cursor_xogopebo=null;
    CPResultSet Cursor_xlientiope=null;
    CPResultSet Cursor_xeneficope=null;
    CPResultSet Cursor_xerzistiope=null;
    CPResultSet Cursor_xocopebo=null;
    CPResultSet Cursor_xapcoll=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pDatIni Date */
      /* pDatFin Date */
      /* pForza Char(1) */
      /* pInform Char(30) // annotazioni varie / Rifimp esteso (9X) */
      /* cProg1 Char(10) */
      /* cProg2 Char(11) */
      /* w_idbase Char(10) */
      /* _conta Numeric(10, 0) */
      /* w_cdaope Char(8) */
      /* w_c_aope Char(8) */
      /* w_cdareg Char(8) */
      /* w_c_areg Char(8) */
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
      /* idb2 Char(10) */
      /* _datareg Date */
      /* _idrif Char(10) */
      /* _totale Numeric(10, 0) */
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_flgforce Char(1) */
      /* passato_il_check Bool */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gFlgDTP Numeric(1, 0) // Forza Data Trasferimento Provvisorie */
      /* Scorre la query e trasferisce i dati */
      /* w_DaDatOpe := pDatIni */
      w_DaDatOpe = pDatIni;
      /* w_ADatOpe := pDatFin */
      w_ADatOpe = pDatFin;
      /* w_flgforce := pForza */
      w_flgforce = pForza;
      /* gMsgProc := 'Ora Inizio Trasferimento: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Trasferimento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := "Selezione record da elaborare..." // Messaggio Import */
      gMsgImp = "Selezione record da elaborare...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* w_cdaope := iif(Empty(w_DaDatOpe) or DateToChar(w_DaDatOpe)='01000101','',DateToChar(w_DaDatOpe)) */
      w_cdaope = (CPLib.Empty(w_DaDatOpe) || CPLib.eqr(CPLib.DateToChar(w_DaDatOpe),"01000101")?"":CPLib.DateToChar(w_DaDatOpe));
      /* w_c_aope := iif(Empty(w_ADatOpe) or DateToChar(w_ADatOpe)='01000101','',DateToChar(w_ADatOpe)) */
      w_c_aope = (CPLib.Empty(w_ADatOpe) || CPLib.eqr(CPLib.DateToChar(w_ADatOpe),"01000101")?"":CPLib.DateToChar(w_ADatOpe));
      /* w_cdareg := '' */
      w_cdareg = "";
      /* w_c_areg := '' */
      w_c_areg = "";
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000031status;
      nTry00000031status = m_Sql.GetTransactionStatus();
      String cTry00000031msg;
      cTry00000031msg = m_Sql.TransactionErrorMessage();
      try {
        /* _totale := 0 */
        _totale = CPLib.Round(0,0);
        /* If w_flgforce <> 'S' */
        if (CPLib.ne(w_flgforce,"S")) {
        } // End If
        /* If _totale=0 */
        if (CPLib.eqr(_totale,0)) {
          // * --- Select from qbe_trasfope_datope
          SPBridge.HMCaller _h00000035;
          _h00000035 = new SPBridge.HMCaller();
          _h00000035.Set("m_cVQRList",m_cVQRList);
          _h00000035.Set("cdaope",w_cdaope);
          _h00000035.Set("c_aope",w_c_aope);
          _h00000035.Set("pInform",pInform);
          if (Cursor_qbe_trasfope_datope!=null)
            Cursor_qbe_trasfope_datope.Close();
          Cursor_qbe_trasfope_datope = new VQRHolder("qbe_trasfope_datope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000035,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_trasfope_datope.Eof())) {
            /* w_datreg := DateToChar(qbe_trasfope_datope->DATAOPE) */
            w_datreg = CPLib.DateToChar(Cursor_qbe_trasfope_datope.GetDate("DATAOPE"));
            // * --- Select from qbe_trasfope_count_ope
            SPBridge.HMCaller _h00000037;
            _h00000037 = new SPBridge.HMCaller();
            _h00000037.Set("m_cVQRList",m_cVQRList);
            _h00000037.Set("datreg",w_datreg);
            if (Cursor_qbe_trasfope_count_ope!=null)
              Cursor_qbe_trasfope_count_ope.Close();
            Cursor_qbe_trasfope_count_ope = new VQRHolder("qbe_trasfope_count_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000037,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_trasfope_count_ope.Eof())) {
              /* _min := qbe_trasfope_count_ope->MINOPE */
              _min = CPLib.Round(Cursor_qbe_trasfope_count_ope.GetDouble("MINOPE"),0);
              /* _max := qbe_trasfope_count_ope->MAXOPE */
              _max = CPLib.Round(Cursor_qbe_trasfope_count_ope.GetDouble("MAXOPE"),0);
              /* _tot := qbe_trasfope_count_ope->TOTOPE */
              _tot = CPLib.Round(Cursor_qbe_trasfope_count_ope.GetDouble("TOTOPE"),0);
              Cursor_qbe_trasfope_count_ope.Next();
            }
            m_cConnectivityError = Cursor_qbe_trasfope_count_ope.ErrorMessage();
            Cursor_qbe_trasfope_count_ope.Close();
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
              /* gMsgImp := 'Lettura operazioni in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
              gMsgImp = "Lettura operazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* If _top>=_min */
              if (CPLib.ge(_top,_min)) {
                // * --- Select from qbe_trasfope_idbase_ope
                if (Cursor_qbe_trasfope_idbase_ope!=null)
                  Cursor_qbe_trasfope_idbase_ope.Close();
                Cursor_qbe_trasfope_idbase_ope = new VQRHolder("qbe_trasfope_idbase_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
                while ( ! (Cursor_qbe_trasfope_idbase_ope.Eof())) {
                  /* w_idbase := qbe_trasfope_idbase_ope->IDBASE */
                  w_idbase = Cursor_qbe_trasfope_idbase_ope.GetString("IDBASE");
                  // * --- Select from xperazbo
                  m_cServer = m_Ctx.GetServer("xperazbo");
                  m_cPhName = m_Ctx.GetPhName("xperazbo");
                  if (Cursor_xperazbo!=null)
                    Cursor_xperazbo.Close();
                  Cursor_xperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,w_idbase)+" "+")"+(m_Ctx.IsSharedTemp("xperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_xperazbo.Eof())) {
                    /* Exec "check" Page 2:check */
                    check();
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                    /* If passato_il_check */
                    if (passato_il_check) {
                      /* Calcol i nuovi progressivi */
                      /* idb2 := LibreriaMit.UniqueId() */
                      idb2 = LibreriaMit.UniqueId();
                      /* cProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
                      cProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
                      /* cProg2 := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(gAzienda)+"'",Space(11),11) */
                      cProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(11),11);
                      /* _datareg := Date() */
                      _datareg = CPLib.Date();
                      // * --- Insert into operazbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("operazbo");
                      m_cPhName = m_Ctx.GetPhName("operazbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"00000052")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000052(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("ANNOOPE"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datareg),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDate("DATAIMP"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDate("DATAOPE"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_datareg,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDate("DATARETT"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(idb2,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cProg2,9)+idb2,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("IMPIN"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("IMPOUT"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("IMPSARA"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("MITIG"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("MITIGDOC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("NOPROT"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("NOSARA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("PROQUOTA"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("RAREA"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("RCOMP"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("RFREQ"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("RIMP"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("RTIPO"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("SV58550"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("SV58550MA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("TIPOORO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
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
                      // * --- Select from xperazbo_agg
                      m_cServer = m_Ctx.GetServer("xperazbo_agg");
                      m_cPhName = m_Ctx.GetPhName("xperazbo_agg");
                      if (Cursor_xperazbo_agg!=null)
                        Cursor_xperazbo_agg.Close();
                      Cursor_xperazbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,w_idbase)+" "+")"+(m_Ctx.IsSharedTemp("xperazbo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_xperazbo_agg.Eof())) {
                        // * --- Insert into operazbo_agg from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("operazbo_agg");
                        m_cPhName = m_Ctx.GetPhName("operazbo_agg");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo_agg",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"00000054")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_00000054(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetDouble("CACODICE"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("IDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetDateTime("CADATAORA"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetDouble("CATIPGIO"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetDouble("CATIPCON"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetDouble("CAPV_COD"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("IDDOCALL"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("VPCODICE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetDate("WUDATRET"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("C_COGNOME"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("C_NOME"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("SOSPAGAM"),"?",0,0,m_cServer)+", ";
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
                        // * --- Delete from xperazbo_agg
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("xperazbo_agg");
                        m_cPhName = m_Ctx.GetPhName("xperazbo_agg");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo_agg",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"00000055")+"delete from "+m_oWrInfo.GetTableWriteName();
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
                        Cursor_xperazbo_agg.Next();
                      }
                      m_cConnectivityError = Cursor_xperazbo_agg.ErrorMessage();
                      Cursor_xperazbo_agg.Close();
                      // * --- End Select
                      // * --- Select from xogopebo
                      m_cServer = m_Ctx.GetServer("xogopebo");
                      m_cPhName = m_Ctx.GetPhName("xogopebo");
                      if (Cursor_xogopebo!=null)
                        Cursor_xogopebo.Close();
                      Cursor_xogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_xogopebo.Eof())) {
                        // * --- Insert into sogopebo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("sogopebo");
                        m_cPhName = m_Ctx.GetPhName("sogopebo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"00000057")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_00000057(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xogopebo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xogopebo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sogopebo",true);
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
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"00000058")+"delete from "+m_oWrInfo.GetTableWriteName();
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xogopebo.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xogopebo.GetString("IDFILEBO"))+"";
                        m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xogopebo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_xogopebo.GetDouble("CPROWNUM"))+"";
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
                        Cursor_xogopebo.Next();
                      }
                      m_cConnectivityError = Cursor_xogopebo.ErrorMessage();
                      Cursor_xogopebo.Close();
                      // * --- End Select
                      // * --- Select from xlientiope
                      m_cServer = m_Ctx.GetServer("xlientiope");
                      m_cPhName = m_Ctx.GetPhName("xlientiope");
                      if (Cursor_xlientiope!=null)
                        Cursor_xlientiope.Close();
                      Cursor_xlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_xlientiope.Eof())) {
                        // * --- Insert into clientiope from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("clientiope");
                        m_cPhName = m_Ctx.GetPhName("clientiope");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"0000005A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_0000005A(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"clientiope",true);
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
                        // * --- Delete from xlientiope
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("xlientiope");
                        m_cPhName = m_Ctx.GetPhName("xlientiope");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientiope",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"0000005B")+"delete from "+m_oWrInfo.GetTableWriteName();
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xlientiope.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xlientiope.GetString("IDFILEBO"))+"";
                        m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xlientiope.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xlientiope.GetString("CODSOG"))+"";
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
                        Cursor_xlientiope.Next();
                      }
                      m_cConnectivityError = Cursor_xlientiope.ErrorMessage();
                      Cursor_xlientiope.Close();
                      // * --- End Select
                      // * --- Select from xeneficope
                      m_cServer = m_Ctx.GetServer("xeneficope");
                      m_cPhName = m_Ctx.GetPhName("xeneficope");
                      if (Cursor_xeneficope!=null)
                        Cursor_xeneficope.Close();
                      Cursor_xeneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xeneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_xeneficope.Eof())) {
                        // * --- Insert into beneficope from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("beneficope");
                        m_cPhName = m_Ctx.GetPhName("beneficope");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"0000005D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_0000005D(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetDouble("CPROWNUM"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"beneficope",true);
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
                        // * --- Delete from xeneficope
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("xeneficope");
                        m_cPhName = m_Ctx.GetPhName("xeneficope");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficope",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"0000005E")+"delete from "+m_oWrInfo.GetTableWriteName();
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xeneficope.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xeneficope.GetString("IDFILEBO"))+"";
                        m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xeneficope.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_xeneficope.GetDouble("CPROWNUM"))+"";
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
                        Cursor_xeneficope.Next();
                      }
                      m_cConnectivityError = Cursor_xeneficope.ErrorMessage();
                      Cursor_xeneficope.Close();
                      // * --- End Select
                      // * --- Select from xerzistiope
                      m_cServer = m_Ctx.GetServer("xerzistiope");
                      m_cPhName = m_Ctx.GetPhName("xerzistiope");
                      if (Cursor_xerzistiope!=null)
                        Cursor_xerzistiope.Close();
                      Cursor_xerzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xerzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_xerzistiope.Eof())) {
                        // * --- Insert into terzistiope from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("terzistiope");
                        m_cPhName = m_Ctx.GetPhName("terzistiope");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"00000060")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_00000060(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"terzistiope",true);
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
                        // * --- Delete from xerzistiope
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("xerzistiope");
                        m_cPhName = m_Ctx.GetPhName("xerzistiope");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xerzistiope",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"00000061")+"delete from "+m_oWrInfo.GetTableWriteName();
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xerzistiope.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xerzistiope.GetString("IDFILEBO"))+"";
                        m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xerzistiope.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xerzistiope.GetString("CODSOG"))+"";
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
                        Cursor_xerzistiope.Next();
                      }
                      m_cConnectivityError = Cursor_xerzistiope.ErrorMessage();
                      Cursor_xerzistiope.Close();
                      // * --- End Select
                      // * --- Select from xocopebo
                      m_cServer = m_Ctx.GetServer("xocopebo");
                      m_cPhName = m_Ctx.GetPhName("xocopebo");
                      if (Cursor_xocopebo!=null)
                        Cursor_xocopebo.Close();
                      Cursor_xocopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_xperazbo.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xocopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_xocopebo.Eof())) {
                        // * --- Insert into docopebo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("docopebo");
                        m_cPhName = m_Ctx.GetPhName("docopebo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"docopebo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"00000063")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_00000063(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetDate("DATARILASC"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetDate("DATAVALI"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"docopebo",true);
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
                        // * --- Delete from xocopebo
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("xocopebo");
                        m_cPhName = m_Ctx.GetPhName("xocopebo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xocopebo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"00000064")+"delete from "+m_oWrInfo.GetTableWriteName();
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xocopebo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_xocopebo.GetString("NUMPROG"))+"";
                        m_cSql = m_cSql+" and CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xocopebo.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_xocopebo.GetString("CONNESCLI"))+"";
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
                        Cursor_xocopebo.Next();
                      }
                      m_cConnectivityError = Cursor_xocopebo.ErrorMessage();
                      Cursor_xocopebo.Close();
                      // * --- End Select
                      // * --- Select from xapcoll
                      m_cServer = m_Ctx.GetServer("xapcoll");
                      m_cPhName = m_Ctx.GetPhName("xapcoll");
                      if (Cursor_xapcoll!=null)
                        Cursor_xapcoll.Close();
                      Cursor_xapcoll = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xapcoll")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_xapcoll.Eof())) {
                        // * --- Insert into rapcoll from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("rapcoll");
                        m_cPhName = m_Ctx.GetPhName("rapcoll");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapcoll",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"00000066")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_00000066(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapcoll.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapcoll.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"rapcoll",true);
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
                        // * --- Delete from xapcoll
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("xapcoll");
                        m_cPhName = m_Ctx.GetPhName("xapcoll");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapcoll",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"00000067")+"delete from "+m_oWrInfo.GetTableWriteName();
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapcoll.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xapcoll.GetString("IDFILEBO"))+"";
                        m_cSql = m_cSql+" and RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapcoll.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xapcoll.GetString("RAPPORTO"))+"";
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
                        Cursor_xapcoll.Next();
                      }
                      m_cConnectivityError = Cursor_xapcoll.ErrorMessage();
                      Cursor_xapcoll.Close();
                      // * --- End Select
                      // * --- Delete from xperazbo
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xperazbo");
                      m_cPhName = m_Ctx.GetPhName("xperazbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfope",93,"00000068")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_xperazbo.GetString("IDBASE"))+"";
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
                      /* gMsgImp := "Sono state trasferite "+LRTrim(Str(_conta,10,0))+" operazioni" // Messaggio Import */
                      gMsgImp = "Sono state trasferite "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" operazioni";
                      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                    } else { // Else
                      /* Check non passato :( */
                    } // End If
                    Cursor_xperazbo.Next();
                  }
                  m_cConnectivityError = Cursor_xperazbo.ErrorMessage();
                  Cursor_xperazbo.Close();
                  // * --- End Select
                  Cursor_qbe_trasfope_idbase_ope.Next();
                }
                m_cConnectivityError = Cursor_qbe_trasfope_idbase_ope.ErrorMessage();
                Cursor_qbe_trasfope_idbase_ope.Close();
                // * --- End Select
              } else { // Else
                /* gMsgImp := 'Lettura operazioni in corso ...' // Messaggio Import */
                gMsgImp = "Lettura operazioni in corso ...";
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              } // End If
              /* _contacicli := _contacicli+1 */
              _contacicli = CPLib.Round(_contacicli+1,0);
            } // End While
            Cursor_qbe_trasfope_datope.Next();
          }
          m_cConnectivityError = Cursor_qbe_trasfope_datope.ErrorMessage();
          Cursor_qbe_trasfope_datope.Close();
          // * --- End Select
          /* gMsgProc := gMsgProc + 'Trasferite '+LRTrim(Str(_conta,10,0))+" operazioni" + NL */
          gMsgProc = gMsgProc+"Trasferite "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" operazioni"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := "Elaborazione Terminata con successo." // Messaggio Import */
          gMsgImp = "Elaborazione Terminata con successo.";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } else { // Else
          /* gMsgProc := gMsgProc + 'Il trasferimento è stato bloccato in quanto sono state trovate operazioni con gli stessi riferimenti' + NL */
          gMsgProc = gMsgProc+"Il trasferimento è stato bloccato in quanto sono state trovate operazioni con gli stessi riferimenti"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Selezionare il flag Forza Trasferimento in caso si voglia comunque proseguire' + NL */
          gMsgProc = gMsgProc+"Selezionare il flag Forza Trasferimento in caso si voglia comunque proseguire"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := "Elaborazione Abortita." // Messaggio Import */
          gMsgImp = "Elaborazione Abortita.";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* gMsgProc := gMsgProc + 'Ora Fine Trasferimento: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Trasferimento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* gMsgProc := gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
        gMsgProc = gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgImp := "Elaborazione Terminata. con errori Non è stata trasferita alcuna operazione" // Messaggio Import */
        gMsgImp = "Elaborazione Terminata. con errori Non è stata trasferita alcuna operazione";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000031status,0)) {
          m_Sql.SetTransactionStatus(nTry00000031status,cTry00000031msg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_trasfope_datope!=null)
          Cursor_qbe_trasfope_datope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasfope_count_ope!=null)
          Cursor_qbe_trasfope_count_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasfope_idbase_ope!=null)
          Cursor_qbe_trasfope_idbase_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xperazbo!=null)
          Cursor_xperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xperazbo_agg!=null)
          Cursor_xperazbo_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xogopebo!=null)
          Cursor_xogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xlientiope!=null)
          Cursor_xlientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xeneficope!=null)
          Cursor_xeneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xerzistiope!=null)
          Cursor_xerzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xocopebo!=null)
          Cursor_xocopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xapcoll!=null)
          Cursor_xapcoll.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void check() throws Exception {
    /* passato_il_check := False */
    passato_il_check = false;
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_pDatIni,java.sql.Date p_pDatFin,String p_pForza,String p_pInform) {
    pDatIni = p_pDatIni;
    pDatFin = p_pDatFin;
    pForza = p_pForza;
    pInform = p_pInform;
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
  public String Run(java.sql.Date p_pDatIni,java.sql.Date p_pDatFin,String p_pForza,String p_pInform) {
    pDatIni = p_pDatIni;
    pDatFin = p_pDatFin;
    pForza = p_pForza;
    pInform = p_pInform;
    return Run();
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
          main();
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
  public static arrt_trasfopeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_trasfopeR(p_Ctx, p_Caller);
  }
  public static arrt_trasfopeR Make(CPContext p_Ctx) {
    return new arrt_trasfopeR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pDatIni = CPLib.NullDate();
    pDatFin = CPLib.NullDate();
    pForza = CPLib.Space(1);
    pInform = CPLib.Space(30);
    cProg1 = CPLib.Space(10);
    cProg2 = CPLib.Space(11);
    w_idbase = CPLib.Space(10);
    _conta = 0;
    w_cdaope = CPLib.Space(8);
    w_c_aope = CPLib.Space(8);
    w_cdareg = CPLib.Space(8);
    w_c_areg = CPLib.Space(8);
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
    idb2 = CPLib.Space(10);
    _datareg = CPLib.NullDate();
    _idrif = CPLib.Space(10);
    _totale = 0;
    w_DaDatOpe = CPLib.NullDate();
    w_ADatOpe = CPLib.NullDate();
    w_flgforce = CPLib.Space(1);
    passato_il_check = false;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gFlgDTP=m_Ctx.GetGlobalNumber("gFlgDTP");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_trasfope_datope,qbe_trasfope_count_ope,qbe_trasfope_idbase_ope,
  public static final String m_cVQRList = ",qbe_trasfope_datope,qbe_trasfope_count_ope,qbe_trasfope_idbase_ope,";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_trasfope,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_trasfope,";
  public static String[] m_cRunParameterNames={"pDatIni","pDatFin","pForza","pInform"};
  protected static String GetFieldsName_00000052(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DAC6,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGDAC6,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"IMPSARA,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITIGDOC,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NOSARA,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROQUOTA,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"SV58550,";
    p_cSql = p_cSql+"SV58550MA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOORO,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000054(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"C_COGNOME,";
    p_cSql = p_cSql+"C_NOME,";
    p_cSql = p_cSql+"SOSPAGAM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000057(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"beneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000060(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"terzistiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000063(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"docopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000066(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapcoll",true);
    return p_cSql;
  }
}
