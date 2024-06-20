// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_terne_saldiR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_tbesitoae;
  public String m_cServer_tbesitoae;
  public String m_cPhName_tmp_terne_saldi;
  public String m_cServer_tmp_terne_saldi;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
  public String m_cPhName_aecanc;
  public String m_cServer_aecanc;
  public String m_cPhName_aedecanc;
  public String m_cServer_aedecanc;
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
  public double w_anno;
  public java.sql.Date w_a_data;
  public String w_stpoff;
  public String fhand;
  public String _prap;
  public String riga;
  public String nomefileimport;
  public String _intercf;
  public String _intercg;
  public String _internm;
  public String _interrs;
  public String _interpr;
  public String _interid;
  public String _interinfo;
  public double _i;
  public double _j;
  public String _esito;
  public double _start;
  public String _cdescri;
  public String _sdescri;
  public double conta;
  public double contat;
  public double _totale;
  public String _numprog;
  public String _rapporto;
  public String _idfileimp;
  public java.sql.Date _datesito;
  public String _idb;
  public String _blocco;
  public double _annoage;
  public double _meseage;
  public String _afile;
  public String _aprog;
  public String _coint;
  public String _tipoag;
  public String _tipoter;
  public String _tipoerr;
  public java.sql.Date w_datini;
  public java.sql.Date w_datfin;
  public java.sql.Date _inir;
  public java.sql.Date _finr;
  public java.sql.Date _inid;
  public java.sql.Date _find;
  public String _codsog;
  public String _idrif;
  public String _nomerep;
  public ReportLibrary _report;
  public boolean bReport;
  public double _nerr;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String gIntemediario;
  public String gDescAzi;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_terne_saldiR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_terne_saldi",m_Caller);
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_tbesitoae = p_ContextObject.GetPhName("tbesitoae");
    if (m_cPhName_tbesitoae.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbesitoae = m_cPhName_tbesitoae+" "+m_Ctx.GetWritePhName("tbesitoae");
    }
    m_cServer_tbesitoae = p_ContextObject.GetServer("tbesitoae");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_terne_saldi")) {
      m_cPhName_tmp_terne_saldi = p_ContextObject.GetPhName("tmp_terne_saldi");
      if (m_cPhName_tmp_terne_saldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_terne_saldi = m_cPhName_tmp_terne_saldi+" "+m_Ctx.GetWritePhName("tmp_terne_saldi");
      }
      m_cServer_tmp_terne_saldi = p_ContextObject.GetServer("tmp_terne_saldi");
    }
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    if (m_cPhName_aeopcanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopcanc = m_cPhName_aeopcanc+" "+m_Ctx.GetWritePhName("aeopcanc");
    }
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    if (m_cPhName_aecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aecanc = m_cPhName_aecanc+" "+m_Ctx.GetWritePhName("aecanc");
    }
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
    m_cPhName_aedecanc = p_ContextObject.GetPhName("aedecanc");
    if (m_cPhName_aedecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aedecanc = m_cPhName_aedecanc+" "+m_Ctx.GetWritePhName("aedecanc");
    }
    m_cServer_aedecanc = p_ContextObject.GetServer("aedecanc");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      return _i;
    }
    if (CPLib.eqr("_j",p_cVarName)) {
      return _j;
    }
    if (CPLib.eqr("_start",p_cVarName)) {
      return _start;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("contat",p_cVarName)) {
      return contat;
    }
    if (CPLib.eqr("_totale",p_cVarName)) {
      return _totale;
    }
    if (CPLib.eqr("_annoage",p_cVarName)) {
      return _annoage;
    }
    if (CPLib.eqr("_meseage",p_cVarName)) {
      return _meseage;
    }
    if (CPLib.eqr("_nerr",p_cVarName)) {
      return _nerr;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_terne_saldi";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("stpoff",p_cVarName)) {
      return w_stpoff;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_prap",p_cVarName)) {
      return _prap;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      return nomefileimport;
    }
    if (CPLib.eqr("_intercf",p_cVarName)) {
      return _intercf;
    }
    if (CPLib.eqr("_intercg",p_cVarName)) {
      return _intercg;
    }
    if (CPLib.eqr("_internm",p_cVarName)) {
      return _internm;
    }
    if (CPLib.eqr("_interrs",p_cVarName)) {
      return _interrs;
    }
    if (CPLib.eqr("_interpr",p_cVarName)) {
      return _interpr;
    }
    if (CPLib.eqr("_interid",p_cVarName)) {
      return _interid;
    }
    if (CPLib.eqr("_interinfo",p_cVarName)) {
      return _interinfo;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("_cdescri",p_cVarName)) {
      return _cdescri;
    }
    if (CPLib.eqr("_sdescri",p_cVarName)) {
      return _sdescri;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      return _numprog;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_idfileimp",p_cVarName)) {
      return _idfileimp;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      return _idb;
    }
    if (CPLib.eqr("_blocco",p_cVarName)) {
      return _blocco;
    }
    if (CPLib.eqr("_afile",p_cVarName)) {
      return _afile;
    }
    if (CPLib.eqr("_aprog",p_cVarName)) {
      return _aprog;
    }
    if (CPLib.eqr("_coint",p_cVarName)) {
      return _coint;
    }
    if (CPLib.eqr("_tipoag",p_cVarName)) {
      return _tipoag;
    }
    if (CPLib.eqr("_tipoter",p_cVarName)) {
      return _tipoter;
    }
    if (CPLib.eqr("_tipoerr",p_cVarName)) {
      return _tipoerr;
    }
    if (CPLib.eqr("_codsog",p_cVarName)) {
      return _codsog;
    }
    if (CPLib.eqr("_idrif",p_cVarName)) {
      return _idrif;
    }
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      return _nomerep;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("a_data",p_cVarName)) {
      return w_a_data;
    }
    if (CPLib.eqr("_datesito",p_cVarName)) {
      return _datesito;
    }
    if (CPLib.eqr("datini",p_cVarName)) {
      return w_datini;
    }
    if (CPLib.eqr("datfin",p_cVarName)) {
      return w_datfin;
    }
    if (CPLib.eqr("_inir",p_cVarName)) {
      return _inir;
    }
    if (CPLib.eqr("_finr",p_cVarName)) {
      return _finr;
    }
    if (CPLib.eqr("_inid",p_cVarName)) {
      return _inid;
    }
    if (CPLib.eqr("_find",p_cVarName)) {
      return _find;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("bReport",p_cVarName)) {
      return bReport;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      _i = value;
      return;
    }
    if (CPLib.eqr("_j",p_cVarName)) {
      _j = value;
      return;
    }
    if (CPLib.eqr("_start",p_cVarName)) {
      _start = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("contat",p_cVarName)) {
      contat = value;
      return;
    }
    if (CPLib.eqr("_totale",p_cVarName)) {
      _totale = value;
      return;
    }
    if (CPLib.eqr("_annoage",p_cVarName)) {
      _annoage = value;
      return;
    }
    if (CPLib.eqr("_meseage",p_cVarName)) {
      _meseage = value;
      return;
    }
    if (CPLib.eqr("_nerr",p_cVarName)) {
      _nerr = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("stpoff",p_cVarName)) {
      w_stpoff = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_prap",p_cVarName)) {
      _prap = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      nomefileimport = value;
      return;
    }
    if (CPLib.eqr("_intercf",p_cVarName)) {
      _intercf = value;
      return;
    }
    if (CPLib.eqr("_intercg",p_cVarName)) {
      _intercg = value;
      return;
    }
    if (CPLib.eqr("_internm",p_cVarName)) {
      _internm = value;
      return;
    }
    if (CPLib.eqr("_interrs",p_cVarName)) {
      _interrs = value;
      return;
    }
    if (CPLib.eqr("_interpr",p_cVarName)) {
      _interpr = value;
      return;
    }
    if (CPLib.eqr("_interid",p_cVarName)) {
      _interid = value;
      return;
    }
    if (CPLib.eqr("_interinfo",p_cVarName)) {
      _interinfo = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("_cdescri",p_cVarName)) {
      _cdescri = value;
      return;
    }
    if (CPLib.eqr("_sdescri",p_cVarName)) {
      _sdescri = value;
      return;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      _numprog = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_idfileimp",p_cVarName)) {
      _idfileimp = value;
      return;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      _idb = value;
      return;
    }
    if (CPLib.eqr("_blocco",p_cVarName)) {
      _blocco = value;
      return;
    }
    if (CPLib.eqr("_afile",p_cVarName)) {
      _afile = value;
      return;
    }
    if (CPLib.eqr("_aprog",p_cVarName)) {
      _aprog = value;
      return;
    }
    if (CPLib.eqr("_coint",p_cVarName)) {
      _coint = value;
      return;
    }
    if (CPLib.eqr("_tipoag",p_cVarName)) {
      _tipoag = value;
      return;
    }
    if (CPLib.eqr("_tipoter",p_cVarName)) {
      _tipoter = value;
      return;
    }
    if (CPLib.eqr("_tipoerr",p_cVarName)) {
      _tipoerr = value;
      return;
    }
    if (CPLib.eqr("_codsog",p_cVarName)) {
      _codsog = value;
      return;
    }
    if (CPLib.eqr("_idrif",p_cVarName)) {
      _idrif = value;
      return;
    }
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      _nomerep = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
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
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("a_data",p_cVarName)) {
      w_a_data = value;
      return;
    }
    if (CPLib.eqr("_datesito",p_cVarName)) {
      _datesito = value;
      return;
    }
    if (CPLib.eqr("datini",p_cVarName)) {
      w_datini = value;
      return;
    }
    if (CPLib.eqr("datfin",p_cVarName)) {
      w_datfin = value;
      return;
    }
    if (CPLib.eqr("_inir",p_cVarName)) {
      _inir = value;
      return;
    }
    if (CPLib.eqr("_finr",p_cVarName)) {
      _finr = value;
      return;
    }
    if (CPLib.eqr("_inid",p_cVarName)) {
      _inid = value;
      return;
    }
    if (CPLib.eqr("_find",p_cVarName)) {
      _find = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bReport",p_cVarName)) {
      bReport = value;
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
  void Page_1() throws Exception {
    CPResultSet Cursor_tmp_list_imprich=null;
    CPResultSet Cursor_qbe_chk_terne_r=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_esito_ts_conta=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_anno Numeric(4, 0) */
      /* w_a_data Date */
      /* w_stpoff Char(1) */
      /* fhand Char(1) */
      /* _prap Char(10) */
      /* riga Memo */
      /* nomefileimport Char(50) */
      /* _intercf Char(16) */
      /* _intercg Char(26) */
      /* _internm Char(25) */
      /* _interrs Char(70) */
      /* _interpr Char(17) */
      /* _interid Char(15) */
      /* _interinfo Char(240) */
      /* _i Numeric(2, 0) */
      /* _j Numeric(2, 0) */
      /* _esito Char(40) */
      /* _start Numeric(4, 0) */
      /* _cdescri Memo */
      /* _sdescri Memo */
      /* conta Numeric(10, 0) */
      /* contat Numeric(10, 0) */
      /* _totale Numeric(10, 0) */
      /* _numprog Char(25) */
      /* _rapporto Char(25) */
      /* _idfileimp Char(10) */
      /* _datesito Date */
      /* _idb Char(10) */
      /* _blocco Char(81) */
      /* _annoage Numeric(4, 0) */
      /* _meseage Numeric(2, 0) */
      /* _afile Char(15) */
      /* _aprog Char(25) */
      /* _coint Char(1) */
      /* _tipoag Char(2) */
      /* _tipoter Char(1) */
      /* _tipoerr Char(4) */
      /* w_datini Date */
      /* w_datfin Date */
      /* _inir Date */
      /* _finr Date */
      /* _inid Date */
      /* _find Date */
      /* _codsog Char(16) */
      /* _idrif Char(15) */
      /* _nomerep Memo // Nome Stampa */
      /* _report Object(ReportLibrary) */
      /* bReport Bool */
      /* _nerr Numeric(10, 0) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gIntemediario Char(11) // Intermediario */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Cicla sul file della lista e lancia la pagina appropriata */
      // * --- Drop temporary table tmp_terne_saldi
      if (m_Ctx.IsSharedTemp("tmp_terne_saldi")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_terne_saldi")) {
          m_cServer = m_Ctx.GetServer("tmp_terne_saldi");
          m_cPhName = m_Ctx.GetPhName("tmp_terne_saldi");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_terne_saldi");
      }
      // * --- Create temporary table tmp_terne_saldi
      if (m_Ctx.IsSharedTemp("tmp_terne_saldi")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_terne_saldi")) {
          m_cServer = m_Ctx.GetServer("tmp_terne_saldi");
          m_cPhName = m_Ctx.GetPhName("tmp_terne_saldi");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_terne_saldi");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_terne_saldi");
      if ( ! (m_Ctx.IsSharedTemp("tmp_terne_saldi"))) {
        m_cServer = m_Ctx.GetServer("tmp_terne_saldi");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_terne_saldi",m_cServer,"proto")),m_cPhName,"tmp_terne_saldi",m_Ctx);
      }
      m_cPhName_tmp_terne_saldi = m_cPhName;
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000041status;
      nTry00000041status = m_Sql.GetTransactionStatus();
      String cTry00000041msg;
      cTry00000041msg = m_Sql.TransactionErrorMessage();
      try {
        /* _totale := 0 */
        _totale = CPLib.Round(0,0);
        /* _annoage := iif(Empty(w_a_data) or DateToChar(w_a_data)='00010101',2070,Year(w_a_data)) */
        _annoage = CPLib.Round((CPLib.Empty(w_a_data) || CPLib.eqr(CPLib.DateToChar(w_a_data),"00010101")?2070:CPLib.Year(w_a_data)),0);
        /* _meseage := iif(Empty(w_a_data) or DateToChar(w_a_data)='00010101',12,Month(w_a_data)) */
        _meseage = CPLib.Round((CPLib.Empty(w_a_data) || CPLib.eqr(CPLib.DateToChar(w_a_data),"00010101")?12:CPLib.Month(w_a_data)),0);
        /* w_datini := CharToDate(Str(w_anno,4,0)+'0101') */
        w_datini = CPLib.CharToDate(CPLib.Str(w_anno,4,0)+"0101");
        /* w_datfin := CharToDate(Str(w_anno,4,0)+'1231') */
        w_datfin = CPLib.CharToDate(CPLib.Str(w_anno,4,0)+"1231");
        /* gMsgProc := gMsgProc + 'Aggiornamento Tabelle Agenzia Entrate - Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Aggiornamento Tabelle Agenzia Entrate - Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Aggiornamento Tabella Delegati' // Messaggio Import */
        gMsgImp = "Aggiornamento Tabella Delegati";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Write into aederig from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_terne_saldi",586,"00000049")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"ABBSALDI = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
        /* gMsgImp := 'Aggiornamento Tabella Operazioni Extraconto' // Messaggio Import */
        gMsgImp = "Aggiornamento Tabella Operazioni Extraconto";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Write into aeoprig from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aeoprig");
        m_cPhName = m_Ctx.GetPhName("aeoprig");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_terne_saldi",586,"0000004B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"ABBSALDI = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
        /* gMsgImp := 'Aggiornamento Tabella Rapporti' // Messaggio Import */
        gMsgImp = "Aggiornamento Tabella Rapporti";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Write into aerighe from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_terne_saldi",586,"0000004D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"ABBSALDI = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
        /* gMsgProc := gMsgProc + 'Aggiornamento Tabelle Agenzia Entrate - Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Aggiornamento Tabelle Agenzia Entrate - Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Select from tmp_list_imprich
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
        Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"priorita,nomefile ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_list_imprich.Eof())) {
          /* nomefileimport := LRTrim(tmp_list_imprich->nomefile) */
          nomefileimport = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
          /* _idfileimp := '' */
          _idfileimp = "";
          /* If Empty(LRTrim(_idfileimp)) */
          if (CPLib.Empty(CPLib.LRTrim(_idfileimp))) {
            /* Exec "Lettura File Terne" Page 2:Page_2 */
            Page_2();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            // * --- Delete from tmp_list_imprich
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_list_imprich");
            m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_terne_saldi",586,"00000054")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"nomefile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_list_imprich.GetString("nomefile"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_list_imprich.GetString("nomefile"))+"";
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
            /* _idfileimp := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
            _idfileimp = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          } else { // Else
            /* gMsgProc := gMsgProc + 'Il file '+LRTrim(nomefileimport)+"è già stato elaborato" + NL */
            gMsgProc = gMsgProc+"Il file "+CPLib.LRTrim(nomefileimport)+"è già stato elaborato"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          Cursor_tmp_list_imprich.Next();
        }
        m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
        Cursor_tmp_list_imprich.Close();
        // * --- End Select
        /* gMsgImp := 'Fine importazione dati. Inizio fase di commit. Attendere prego...' // Messaggio Import */
        gMsgImp = "Fine importazione dati. Inizio fase di commit. Attendere prego...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        // * --- Select from qbe_chk_terne_r
        SPBridge.HMCaller _h00000059;
        _h00000059 = new SPBridge.HMCaller();
        _h00000059.Set("m_cVQRList",m_cVQRList);
        _h00000059.Set("datini",w_datini);
        _h00000059.Set("datfin",w_datfin);
        if (Cursor_qbe_chk_terne_r!=null)
          Cursor_qbe_chk_terne_r.Close();
        Cursor_qbe_chk_terne_r = new VQRHolder("qbe_chk_terne_r",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000059,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_chk_terne_r.Eof())) {
          /* _prap := '' */
          _prap = "";
          /* _idrif := '' */
          _idrif = "";
          /* If qbe_chk_terne_r->TIPO='R' */
          if (CPLib.eqr(Cursor_qbe_chk_terne_r.GetString("TIPO"),"R")) {
            // * --- Read from aecanc
            m_cServer = m_Ctx.GetServer("aecanc");
            m_cPhName = m_Ctx.GetPhName("aecanc");
            m_cSql = "";
            m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_chk_terne_r.GetString("APROG"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_chk_terne_r.GetString("APROG"));
            m_cSql = m_cSql+" and AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_chk_terne_r.GetString("AFILE"),"C",15,0,m_cServer),m_cServer,Cursor_qbe_chk_terne_r.GetString("AFILE"));
            if (m_Ctx.IsSharedTemp("aecanc")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROGRES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("IDFILE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _prap = Read_Cursor.GetString("PROGRES");
              _idrif = Read_Cursor.GetString("IDFILE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on aecanc into routine arrt_terne_saldi returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _prap = "";
              _idrif = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* If qbe_chk_terne_r->TIPO='D' */
          if (CPLib.eqr(Cursor_qbe_chk_terne_r.GetString("TIPO"),"D")) {
            // * --- Read from aedecanc
            m_cServer = m_Ctx.GetServer("aedecanc");
            m_cPhName = m_Ctx.GetPhName("aedecanc");
            m_cSql = "";
            m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_chk_terne_r.GetString("APROG"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_chk_terne_r.GetString("APROG"));
            m_cSql = m_cSql+" and AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_chk_terne_r.GetString("AFILE"),"C",15,0,m_cServer),m_cServer,Cursor_qbe_chk_terne_r.GetString("AFILE"));
            if (m_Ctx.IsSharedTemp("aedecanc")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROGRES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("IDFILE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _prap = Read_Cursor.GetString("PROGRES");
              _idrif = Read_Cursor.GetString("IDFILE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on aedecanc into routine arrt_terne_saldi returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _prap = "";
              _idrif = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* If qbe_chk_terne_r->TIPO='O' */
          if (CPLib.eqr(Cursor_qbe_chk_terne_r.GetString("TIPO"),"O")) {
            // * --- Read from aeopcanc
            m_cServer = m_Ctx.GetServer("aeopcanc");
            m_cPhName = m_Ctx.GetPhName("aeopcanc");
            m_cSql = "";
            m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_chk_terne_r.GetString("APROG"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_chk_terne_r.GetString("APROG"));
            m_cSql = m_cSql+" and AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_chk_terne_r.GetString("AFILE"),"C",15,0,m_cServer),m_cServer,Cursor_qbe_chk_terne_r.GetString("AFILE"));
            if (m_Ctx.IsSharedTemp("aeopcanc")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROGRES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("IDFILE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _prap = Read_Cursor.GetString("PROGRES");
              _idrif = Read_Cursor.GetString("IDFILE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on aeopcanc into routine arrt_terne_saldi returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _prap = "";
              _idrif = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* If Empty(LRTrim(_prap)) or (not(Empty(LRTrim(_prap))) and Empty(LRTrim(_idrif))) */
          if (CPLib.Empty(CPLib.LRTrim(_prap)) || ( ! (CPLib.Empty(CPLib.LRTrim(_prap))) && CPLib.Empty(CPLib.LRTrim(_idrif)))) {
            // * --- Insert into tmp_terne_saldi from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_terne_saldi");
            m_cPhName = m_Ctx.GetPhName("tmp_terne_saldi");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_terne_saldi",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_terne_saldi",586,"00000063")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000063(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chk_terne_r.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chk_terne_r.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chk_terne_r.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chk_terne_r.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chk_terne_r.GetDate("CDATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chk_terne_r.GetString("COINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chk_terne_r.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chk_terne_r.GetString("COINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_terne_saldi",true);
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
          Cursor_qbe_chk_terne_r.Next();
        }
        m_cConnectivityError = Cursor_qbe_chk_terne_r.ErrorMessage();
        Cursor_qbe_chk_terne_r.Close();
        // * --- End Select
        /* If w_stpoff='S' */
        if (CPLib.eqr(w_stpoff,"S")) {
          /* _nerr := 0 */
          _nerr = CPLib.Round(0,0);
          // * --- Select from qbe_esito_ts_conta
          if (Cursor_qbe_esito_ts_conta!=null)
            Cursor_qbe_esito_ts_conta.Close();
          Cursor_qbe_esito_ts_conta = new VQRHolder("qbe_esito_ts_conta",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_esito_ts_conta.Eof())) {
            /* _nerr := qbe_esito_ts_conta->TOTALE */
            _nerr = CPLib.Round(Cursor_qbe_esito_ts_conta.GetDouble("TOTALE"),0);
            Cursor_qbe_esito_ts_conta.Next();
          }
          m_cConnectivityError = Cursor_qbe_esito_ts_conta.ErrorMessage();
          Cursor_qbe_esito_ts_conta.Close();
          // * --- End Select
          /* If _nerr=0 */
          if (CPLib.eqr(_nerr,0)) {
            /* System.out.println('Non ci sono errori nel confronto delle terne') */
            System.out.println("Non ci sono errori nel confronto delle terne");
            /* Info Msg 'Non ci sono errori nel confronto delle terne' */
            if ( ! (CPLib.IsNull(m_Info))) {
              m_Info.log(CPLib.FormatMsg(m_Ctx,"Non ci sono errori nel confronto delle terne"));
            }
            /* gMsgProc := gMsgProc + 'Non ci sono errori nel confronto delle terne' + NL */
            gMsgProc = gMsgProc+"Non ci sono errori nel confronto delle terne"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* _report := ReportLibrary.GetReportLibrary() */
            _report = ReportLibrary.Make(m_Ctx).GetReportLibrary();
            /* _report.setParameterChar('w_DescAzi',gDescAzi) */
            _report.setParameterChar("w_DescAzi",gDescAzi);
            /* _report.setParameterNumeric('w_anno',w_anno) */
            _report.setParameterNumeric("w_anno",w_anno);
            /* _nomerep := 'arrp_imp_terne_err' // Nome Stampa */
            _nomerep = "arrp_imp_terne_err";
            /* bReport := _report.makeReport(_nomerep,LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/errori_terne_'+Str(w_anno,4,0)+'.pdf','A4','LANDSCAPE','PDF') */
            bReport = _report.makeReport(_nomerep,CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/errori_terne_"+CPLib.Str(w_anno,4,0)+".pdf","A4","LANDSCAPE","PDF");
          } // End If
        } // End If
        /* gMsgProc := gMsgProc + 'Totale Record Elaborati: '+LRTrim(Str(_totale,10,0)) + NL */
        gMsgProc = gMsgProc+"Totale Record Elaborati: "+CPLib.LRTrim(CPLib.Str(_totale,10,0))+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Procedura terminata correttamente' // Messaggio Import */
        gMsgImp = "Procedura terminata correttamente";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* gMsgProc := gMsgProc + "Rilevati errori nell'impotazione dei file!" + NL */
        gMsgProc = gMsgProc+"Rilevati errori nell'impotazione dei file!"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
        gMsgProc = gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Procedura terminata con errori' // Messaggio Import */
        gMsgImp = "Procedura terminata con errori";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000041status,0)) {
          m_Sql.SetTransactionStatus(nTry00000041status,cTry00000041msg);
        }
      }
    } finally {
      try {
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_chk_terne_r!=null)
          Cursor_qbe_chk_terne_r.Close();
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
        if (Cursor_qbe_esito_ts_conta!=null)
          Cursor_qbe_esito_ts_conta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibMit.OpenRead("./appo/"+nomefileimport);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* contat := 0 */
      contat = CPLib.Round(0,0);
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* _totale := _totale + 1 */
          _totale = CPLib.Round(_totale+1,0);
          /* If Len(LRTrim(riga)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* Case Left(riga,1)='0' */
            if (CPLib.eqr(CPLib.Left(riga,1),"0")) {
              /* If LRTrim(Substr(riga,9,16)) <> gIntemediario */
              if (CPLib.ne(CPLib.LRTrim(CPLib.Substr(riga,9,16)),gIntemediario)) {
                /* gMsgProc := 'Il file ' + nomefileimport + " non è riferito all'intermediario attuale" // Messaggio */
                gMsgProc = "Il file "+nomefileimport+" non è riferito all'intermediario attuale";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                // Exit Loop
                if (true) {
                  break;
                }
                /* ElseIf Left(riga,8) <> '0CCT0034' */
              } else if (CPLib.ne(CPLib.Left(riga,8),"0CCT0034")) {
                /* gMsgProc := 'Hai selezionato un file NON ADATTO PER LA VERIFICA DELLE TERNE' // Messaggio */
                gMsgProc = "Hai selezionato un file NON ADATTO PER LA VERIFICA DELLE TERNE";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                // Exit Loop
                if (true) {
                  break;
                }
              } else { // Else
                /* If Empty(w_a_data) */
                if (CPLib.Empty(w_a_data)) {
                  /* w_a_data := CharToDate(Substr(riga,272,4)+Substr(riga,277,2)+Substr(riga,280,2)) */
                  w_a_data = CPLib.CharToDate(CPLib.Substr(riga,272,4)+CPLib.Substr(riga,277,2)+CPLib.Substr(riga,280,2));
                  /* _annoage := iif(Empty(w_a_data) or DateToChar(w_a_data)='00010101',2070,Year(w_a_data)) */
                  _annoage = CPLib.Round((CPLib.Empty(w_a_data) || CPLib.eqr(CPLib.DateToChar(w_a_data),"00010101")?2070:CPLib.Year(w_a_data)),0);
                  /* _meseage := iif(Empty(w_a_data) or DateToChar(w_a_data)='00010101',12,Month(w_a_data)) */
                  _meseage = CPLib.Round((CPLib.Empty(w_a_data) || CPLib.eqr(CPLib.DateToChar(w_a_data),"00010101")?12:CPLib.Month(w_a_data)),0);
                } // End If
              } // End If
              /* Case Left(riga,1)='B' */
            } else if (CPLib.eqr(CPLib.Left(riga,1),"B")) {
              for (int i = 0; CPLib.ne(i,24); i = i + (1)) {
                /* If Len(LRTrim(Substr(riga,2+(81*i),80))) >0 */
                if (CPLib.gt(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,2+(81*i),80))),0)) {
                  /* contat := contat + 1 */
                  contat = CPLib.Round(contat+1,0);
                  /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file '+nomefileimport+' - Terne '+Str(contat,10,0) // Messaggio Import */
                  gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file "+nomefileimport+" - Terne "+CPLib.Str(contat,10,0);
                  m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  /* _blocco := Substr(riga,2+(81*i),81) */
                  _blocco = CPLib.Substr(riga,2+(81*i),81);
                  /* _afile := Substr(_blocco,18,15) */
                  _afile = CPLib.Substr(_blocco,18,15);
                  /* _aprog := arfn_delzero(Substr(_blocco,33,25)) */
                  _aprog = arfn_delzeroR.Make(m_Ctx,this).Run(CPLib.Substr(_blocco,33,25));
                  /* _coint := '' */
                  _coint = "";
                  /* _tipoag := '' */
                  _tipoag = "";
                  /* _tipoter := '' */
                  _tipoter = "";
                  /* _tipoerr := '' */
                  _tipoerr = "";
                  /* _rapporto := '' */
                  _rapporto = "";
                  /* _inir := NullDate() */
                  _inir = CPLib.NullDate();
                  /* _finr := NullDate() */
                  _finr = CPLib.NullDate();
                  /* _inid := NullDate() */
                  _inid = CPLib.NullDate();
                  /* _find := NullDate() */
                  _find = CPLib.NullDate();
                  /* Cerca le terne sulle varie tabelle */
                  /* If not(Val('20'+Substr(_afile,3,2)) >= _annoage and Val(Substr(_afile,5,2)) >= _meseage) */
                  if ( ! (CPLib.ge(CPLib.Val("20"+CPLib.Substr(_afile,3,2)),_annoage) && CPLib.ge(CPLib.Val(CPLib.Substr(_afile,5,2)),_meseage))) {
                    /* If Left(_blocco,1) ='1' or Left(_blocco,1) ='4'  */
                    if (CPLib.eqr(CPLib.Left(_blocco,1),"1") || CPLib.eqr(CPLib.Left(_blocco,1),"4")) {
                      /* _idb := '' */
                      _idb = "";
                      /* _rapporto := '' */
                      _rapporto = "";
                      /* _inid := iif(Substr(_blocco,60,10)<>'0001-01-01',CharToDate(LRTrim(Strtran(Substr(_blocco,60,10),'-',''))),NullDate()) */
                      _inid = (CPLib.ne(CPLib.Substr(_blocco,60,10),"0001-01-01")?CPLib.CharToDate(CPLib.LRTrim(CPLib.Strtran(CPLib.Substr(_blocco,60,10),"-",""))):CPLib.NullDate());
                      /* _find := iif(Substr(_blocco,70,10)<>'0001-01-01',CharToDate(LRTrim(Strtran(Substr(_blocco,70,10),'-',''))),NullDate()) */
                      _find = (CPLib.ne(CPLib.Substr(_blocco,70,10),"0001-01-01")?CPLib.CharToDate(CPLib.LRTrim(CPLib.Strtran(CPLib.Substr(_blocco,70,10),"-",""))):CPLib.NullDate());
                      /* _prap := '' */
                      _prap = "";
                      /* Case Substr(_blocco,58,2)='98' */
                      if (CPLib.eqr(CPLib.Substr(_blocco,58,2),"98")) {
                        /* _tipoter := 'O' */
                        _tipoter = "O";
                        /* _codsog := '' */
                        _codsog = "";
                        /* _idrif := '' */
                        _idrif = "";
                        // * --- Read from aeopcanc
                        m_cServer = m_Ctx.GetServer("aeopcanc");
                        m_cPhName = m_Ctx.GetPhName("aeopcanc");
                        m_cSql = "";
                        m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_afile,"C",15,0,m_cServer),m_cServer,_afile);
                        m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_aprog,"C",25,0,m_cServer),m_cServer,_aprog);
                        if (m_Ctx.IsSharedTemp("aeopcanc")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROGRES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("IDFILE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _prap = Read_Cursor.GetString("PROGRES");
                          _idrif = Read_Cursor.GetString("IDFILE");
                          _idb = Read_Cursor.GetString("IDBASE");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on aeopcanc into routine arrt_terne_saldi returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _prap = "";
                          _idrif = "";
                          _idb = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                        /* If Empty(LRTrim(_prap)) */
                        if (CPLib.Empty(CPLib.LRTrim(_prap))) {
                          // * --- Read from aeoprig
                          m_cServer = m_Ctx.GetServer("aeoprig");
                          m_cPhName = m_Ctx.GetPhName("aeoprig");
                          m_cSql = "";
                          m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_afile,"C",15,0,m_cServer),m_cServer,_afile);
                          m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_aprog,"C",25,0,m_cServer),m_cServer,_aprog);
                          if (m_Ctx.IsSharedTemp("aeoprig")) {
                            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                          }
                          if (Read_Cursor!=null)
                            Read_Cursor.Close();
                          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPOAG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("ADATA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CDATA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                          if ( ! (Read_Cursor.Eof())) {
                            _rapporto = Read_Cursor.GetString("RAPPORTO");
                            _idb = Read_Cursor.GetString("IDBASE");
                            _coint = Read_Cursor.GetString("COINT");
                            _tipoag = Read_Cursor.GetString("TIPOAG");
                            _inir = Read_Cursor.GetDate("ADATA");
                            _finr = Read_Cursor.GetDate("CDATA");
                            _codsog = Read_Cursor.GetString("CONNESINT");
                            Read_Cursor.Next();
                            if ( ! (Read_Cursor.Eof())) {
                              Error l_oErrorFault = new Error("Read on aeoprig into routine arrt_terne_saldi returns two or more records. This item should return only a record.");
                              CPStdCounter.Error(l_oErrorFault);
                            }
                            Read_Cursor.Close();
                          } else {
                            // Error: no record found!
                            _rapporto = "";
                            _idb = "";
                            _coint = "";
                            _tipoag = "";
                            _inir = CPLib.NullDate();
                            _finr = CPLib.NullDate();
                            _codsog = "";
                            Read_Cursor.Close();
                            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                          }
                          /* Se trova la terna la marca */
                          /* If not(Empty(_inir)) */
                          if ( ! (CPLib.Empty(_inir))) {
                            /* _rapporto := Substr(_blocco,33,25) */
                            _rapporto = CPLib.Substr(_blocco,33,25);
                            // * --- Write into aeoprig from values
                            m_Sql.RequireTransaction();
                            m_cServer = m_Ctx.GetServer("aeoprig");
                            m_cPhName = m_Ctx.GetPhName("aeoprig");
                            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_terne_saldi",586,"000000AE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                            m_cSql = m_cSql+"ABBSALDI = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
                            m_cSql = m_cSql+" where ";
                            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_idb,"?",0,0,m_cServer),m_cServer,_idb)+"";
                            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                            if (CPLib.lt(m_nUpdatedRows,0)) {
                              m_Sql.AbortTransaction();
                            }
                            m_Sql.CompleteTransaction();
                            m_cLastMsgError = m_Sql.TransactionErrorMessage();
                            if (CPLib.ne(m_cLastMsgError,"")) {
                              m_bError = true;
                            }
                          } // End If
                        } else { // Else
                          /* If not(Empty(LRTrim(_idrif))) */
                          if ( ! (CPLib.Empty(CPLib.LRTrim(_idrif)))) {
                            // * --- Write into aeoprig from values
                            m_Sql.RequireTransaction();
                            m_cServer = m_Ctx.GetServer("aeoprig");
                            m_cPhName = m_Ctx.GetPhName("aeoprig");
                            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_terne_saldi",586,"000000B0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                            m_cSql = m_cSql+"ABBSALDI = "+CPLib.ToSQL("D","C",1,0,m_cServer)+", ";
                            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
                            m_cSql = m_cSql+" where ";
                            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_idb,"?",0,0,m_cServer),m_cServer,_idb)+"";
                            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                            if (CPLib.lt(m_nUpdatedRows,0)) {
                              m_Sql.AbortTransaction();
                            }
                            m_Sql.CompleteTransaction();
                            m_cLastMsgError = m_Sql.TransactionErrorMessage();
                            if (CPLib.ne(m_cLastMsgError,"")) {
                              m_bError = true;
                            }
                          } // End If
                        } // End If
                        /* Case Substr(_blocco,58,2) <> '98' and Substr(_blocco,80,1)='3' */
                      } else if (CPLib.ne(CPLib.Substr(_blocco,58,2),"98") && CPLib.eqr(CPLib.Substr(_blocco,80,1),"3")) {
                        /* _tipoter := 'D' */
                        _tipoter = "D";
                        /* _codsog := '' */
                        _codsog = "";
                        // * --- Read from aederig
                        m_cServer = m_Ctx.GetServer("aederig");
                        m_cPhName = m_Ctx.GetPhName("aederig");
                        m_cSql = "";
                        m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_afile,"C",15,0,m_cServer),m_cServer,_afile);
                        m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_aprog,"C",25,0,m_cServer),m_cServer,_aprog);
                        if (m_Ctx.IsSharedTemp("aederig")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPOAG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("ADATA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CDATA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _rapporto = Read_Cursor.GetString("RAPPORTO");
                          _idb = Read_Cursor.GetString("IDBASE");
                          _coint = Read_Cursor.GetString("COINT");
                          _tipoag = Read_Cursor.GetString("TIPOAG");
                          _inir = Read_Cursor.GetDate("ADATA");
                          _finr = Read_Cursor.GetDate("CDATA");
                          _codsog = Read_Cursor.GetString("CONNESINT");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on aederig into routine arrt_terne_saldi returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _rapporto = "";
                          _idb = "";
                          _coint = "";
                          _tipoag = "";
                          _inir = CPLib.NullDate();
                          _finr = CPLib.NullDate();
                          _codsog = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                        /* Se trova la terna la marca */
                        /* If not(Empty(_rapporto)) */
                        if ( ! (CPLib.Empty(_rapporto))) {
                          // * --- Write into aederig from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("aederig");
                          m_cPhName = m_Ctx.GetPhName("aederig");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_terne_saldi",586,"000000B6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                          m_cSql = m_cSql+"ABBSALDI = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_idb,"?",0,0,m_cServer),m_cServer,_idb)+"";
                          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                          if (CPLib.lt(m_nUpdatedRows,0)) {
                            m_Sql.AbortTransaction();
                          }
                          m_Sql.CompleteTransaction();
                          m_cLastMsgError = m_Sql.TransactionErrorMessage();
                          if (CPLib.ne(m_cLastMsgError,"")) {
                            m_bError = true;
                          }
                        } // End If
                        /* Case Substr(_blocco,58,2) <> '98' and Substr(_blocco,80,1) <> '3' */
                      } else if (CPLib.ne(CPLib.Substr(_blocco,58,2),"98") && CPLib.ne(CPLib.Substr(_blocco,80,1),"3")) {
                        /* _tipoter := 'R' */
                        _tipoter = "R";
                        /* _codsog := '' */
                        _codsog = "";
                        // * --- Read from aerighe
                        m_cServer = m_Ctx.GetServer("aerighe");
                        m_cPhName = m_Ctx.GetPhName("aerighe");
                        m_cSql = "";
                        m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_afile,"C",15,0,m_cServer),m_cServer,_afile);
                        m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_aprog,"C",25,0,m_cServer),m_cServer,_aprog);
                        if (m_Ctx.IsSharedTemp("aerighe")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("ADATA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CDATA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _rapporto = Read_Cursor.GetString("RAPPORTO");
                          _idb = Read_Cursor.GetString("IDBASE");
                          _inir = Read_Cursor.GetDate("ADATA");
                          _finr = Read_Cursor.GetDate("CDATA");
                          _codsog = Read_Cursor.GetString("CONNESINT");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on aerighe into routine arrt_terne_saldi returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _rapporto = "";
                          _idb = "";
                          _inir = CPLib.NullDate();
                          _finr = CPLib.NullDate();
                          _codsog = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                        /* Se trova la terna la marca */
                        /* If not(Empty(_rapporto)) */
                        if ( ! (CPLib.Empty(_rapporto))) {
                          // * --- Read from aetesta
                          m_cServer = m_Ctx.GetServer("aetesta");
                          m_cPhName = m_Ctx.GetPhName("aetesta");
                          m_cSql = "";
                          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"C",25,0,m_cServer),m_cServer,_rapporto);
                          if (m_Ctx.IsSharedTemp("aetesta")) {
                            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                          }
                          if (Read_Cursor!=null)
                            Read_Cursor.Close();
                          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("COINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPOAG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                          if ( ! (Read_Cursor.Eof())) {
                            _coint = Read_Cursor.GetString("COINT");
                            _tipoag = Read_Cursor.GetString("TIPOAG");
                            Read_Cursor.Next();
                            if ( ! (Read_Cursor.Eof())) {
                              Error l_oErrorFault = new Error("Read on aetesta into routine arrt_terne_saldi returns two or more records. This item should return only a record.");
                              CPStdCounter.Error(l_oErrorFault);
                            }
                            Read_Cursor.Close();
                          } else {
                            // Error: no record found!
                            _coint = "";
                            _tipoag = "";
                            Read_Cursor.Close();
                            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                          }
                          // * --- Write into aerighe from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("aerighe");
                          m_cPhName = m_Ctx.GetPhName("aerighe");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_terne_saldi",586,"000000BD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                          m_cSql = m_cSql+"ABBSALDI = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_idb,"?",0,0,m_cServer),m_cServer,_idb)+"";
                          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                          if (CPLib.lt(m_nUpdatedRows,0)) {
                            m_Sql.AbortTransaction();
                          }
                          m_Sql.CompleteTransaction();
                          m_cLastMsgError = m_Sql.TransactionErrorMessage();
                          if (CPLib.ne(m_cLastMsgError,"")) {
                            m_bError = true;
                          }
                        } // End If
                      } // End Case
                      /* If not(Empty(_rapporto)) */
                      if ( ! (CPLib.Empty(_rapporto))) {
                        /* If _coint <> Substr(_blocco,80,1) */
                        if (CPLib.ne(_coint,CPLib.Substr(_blocco,80,1))) {
                          /* _tipoerr := '1' */
                          _tipoerr = "1";
                        } // End If
                        /* If _tipoag <> Substr(_blocco,58,2) */
                        if (CPLib.ne(_tipoag,CPLib.Substr(_blocco,58,2))) {
                          /* _tipoerr := LRTrim(_tipoerr)+'2' */
                          _tipoerr = CPLib.LRTrim(_tipoerr)+"2";
                        } // End If
                        /* If _inir <> _inid */
                        if (CPLib.ne(_inir,_inid)) {
                          /* _tipoerr := LRTrim(_tipoerr)+'3' */
                          _tipoerr = CPLib.LRTrim(_tipoerr)+"3";
                        } // End If
                        /* If _finr <> _find and _finr <= w_a_data */
                        if (CPLib.ne(_finr,_find) && CPLib.le(_finr,w_a_data)) {
                          /* _tipoerr := LRTrim(_tipoerr)+'4' */
                          _tipoerr = CPLib.LRTrim(_tipoerr)+"4";
                        } // End If
                      } else { // Else
                        /* If Empty(LRTrim(_prap)) */
                        if (CPLib.Empty(CPLib.LRTrim(_prap))) {
                          /* _tipoerr := '9' */
                          _tipoerr = "9";
                        } // End If
                      } // End If
                      // * --- Insert into tmp_terne_saldi from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_terne_saldi");
                      m_cPhName = m_Ctx.GetPhName("tmp_terne_saldi");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_terne_saldi",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_terne_saldi",586,"000000C9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000C9(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_blocco,1),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_blocco,2,16),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_blocco,18,15),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_blocco,33,25),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_blocco,58,2),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_inid,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_find,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_blocco,80,1),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_idb))?0:1),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_coint,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_tipoag,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_tipoter,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_tipoerr),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_inir,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_finr,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_codsog,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_terne_saldi",true);
                      m_cSql = m_cSql+")";
                      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                      if (CPLib.lt(m_nUpdatedRows,0)) {
                        m_Sql.AbortTransaction();
                      }
                      m_Sql.CompleteTransaction();
                      m_cLastMsgError = m_Sql.TransactionErrorMessage();
                      if (CPLib.ne(m_cLastMsgError,"")) {
                        m_bError = true;
                      }
                    } // End If
                  } // End If
                } // End If
              }
              /* Case Left(riga,1)='9' */
            } else if (CPLib.eqr(CPLib.Left(riga,1),"9")) {
            } // End Case
          } // End If
        } // End If
      } // End While
      /* gMsgProc := gMsgProc + 'Record Elaborati: '+LRTrim(Str(conta,10,0)) + ' dal file '+nomefileimport+NL */
      gMsgProc = gMsgProc+"Record Elaborati: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" dal file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Terne Elaborate: '+LRTrim(Str(contat,10,0)) + NL */
      gMsgProc = gMsgProc+"Terne Elaborate: "+CPLib.LRTrim(CPLib.Str(contat,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* FileLibMit.DeleteFile('./appo/'+nomefileimport) */
      FileLibMit.DeleteFile("./appo/"+nomefileimport);
      /* gMsgImp := 'Fine importazione del file '+nomefileimport // Messaggio Import */
      gMsgImp = "Fine importazione del file "+nomefileimport;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync() {
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
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
      m_Caller.SetNumber("anno","N",4,0,w_anno);
      m_Caller.SetDate("a_data","D",8,0,w_a_data);
      m_Caller.SetString("stpoff","C",1,0,w_stpoff);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_terne_saldiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_terne_saldiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_anno = m_Caller.GetNumber("anno","N",4,0);
    w_a_data = m_Caller.GetDate("a_data","D",8,0);
    w_stpoff = m_Caller.GetString("stpoff","C",1,0);
    fhand = CPLib.Space(1);
    _prap = CPLib.Space(10);
    riga = "";
    nomefileimport = CPLib.Space(50);
    _intercf = CPLib.Space(16);
    _intercg = CPLib.Space(26);
    _internm = CPLib.Space(25);
    _interrs = CPLib.Space(70);
    _interpr = CPLib.Space(17);
    _interid = CPLib.Space(15);
    _interinfo = CPLib.Space(240);
    _i = 0;
    _j = 0;
    _esito = CPLib.Space(40);
    _start = 0;
    _cdescri = "";
    _sdescri = "";
    conta = 0;
    contat = 0;
    _totale = 0;
    _numprog = CPLib.Space(25);
    _rapporto = CPLib.Space(25);
    _idfileimp = CPLib.Space(10);
    _datesito = CPLib.NullDate();
    _idb = CPLib.Space(10);
    _blocco = CPLib.Space(81);
    _annoage = 0;
    _meseage = 0;
    _afile = CPLib.Space(15);
    _aprog = CPLib.Space(25);
    _coint = CPLib.Space(1);
    _tipoag = CPLib.Space(2);
    _tipoter = CPLib.Space(1);
    _tipoerr = CPLib.Space(4);
    w_datini = CPLib.NullDate();
    w_datfin = CPLib.NullDate();
    _inir = CPLib.NullDate();
    _finr = CPLib.NullDate();
    _inid = CPLib.NullDate();
    _find = CPLib.NullDate();
    _codsog = CPLib.Space(16);
    _idrif = CPLib.Space(15);
    _nomerep = "";
    _report = null;
    bReport = false;
    _nerr = 0;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_chk_terne_r,qbe_esito_ts_conta,
  public static final String m_cVQRList = ",qbe_chk_terne_r,qbe_esito_ts_conta,";
  // ENTITY_BATCHES: ,arfn_delzero,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_delzero,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000063(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DBINI,";
    p_cSql = p_cSql+"DBFIN,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"FLGVAL,";
    p_cSql = p_cSql+"FLGDEL,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_terne_saldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOTERNA,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"PRGREC,";
    p_cSql = p_cSql+"TIPRAP,";
    p_cSql = p_cSql+"DATINI,";
    p_cSql = p_cSql+"DATFIN,";
    p_cSql = p_cSql+"FLGDEL,";
    p_cSql = p_cSql+"FLGVAL,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"TIPOTER,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"DBINI,";
    p_cSql = p_cSql+"DBFIN,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_terne_saldi",true);
    return p_cSql;
  }
}
