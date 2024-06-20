// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_stpverage_do_wuR implements CallerWithObjs {
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_tmp_stpverage_do;
  public String m_cServer_tmp_stpverage_do;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_tmp_aafiles;
  public String m_cServer_tmp_aafiles;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
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
  public String pTipo;
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public String w_c_adata;
  public String w_cdadata;
  public String w_chkcfis;
  public String w_noninvio;
  public String w_codmage;
  public String w_fisccod;
  public String w_statonas;
  public String w_tipoerr;
  public String _motivo;
  public String _codrap;
  public String _codper;
  public java.sql.Date _datnas;
  public String _provnas;
  public String _comnas;
  public String _naznas;
  public String _mesnas;
  public String _gionas;
  public String _annnas;
  public String _sesso;
  public String _codfisc;
  public String _cmesi;
  public double _pos;
  public String _motivo2;
  public String _chkcf;
  public String _chkstato;
  public String _chknet;
  public ReportLibrary _report;
  public boolean bReport;
  public String filename;
  public String filepath;
  public double _conta;
  public double _max;
  public double _min;
  public double _tot;
  public double _cicli;
  public double _bottom;
  public double _top;
  public double _reccount;
  public String gMsgImp;
  public String gPathApp;
  public String gUrlApp;
  public String gAzienda;
  public String w_CODFISC;
  public java.sql.Date w_DATANASC;
  public String w_NASCOMUN;
  public String w_NASSTATO;
  public String w_COGNOME;
  public String w_RAGSOC;
  public String w_NOME;
  public String w_SESSO;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_stpverage_do_wuR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stpverage_do_wu",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stpverage_do")) {
      m_cPhName_tmp_stpverage_do = p_ContextObject.GetPhName("tmp_stpverage_do");
      if (m_cPhName_tmp_stpverage_do.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stpverage_do = m_cPhName_tmp_stpverage_do+" "+m_Ctx.GetWritePhName("tmp_stpverage_do");
      }
      m_cServer_tmp_stpverage_do = p_ContextObject.GetServer("tmp_stpverage_do");
    }
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
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
    m_cPhName_tmp_aafiles = p_ContextObject.GetPhName("tmp_aafiles");
    if (m_cPhName_tmp_aafiles.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_aafiles = m_cPhName_tmp_aafiles+" "+m_Ctx.GetWritePhName("tmp_aafiles");
    }
    m_cServer_tmp_aafiles = p_ContextObject.GetServer("tmp_aafiles");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_pos",p_cVarName)) {
      return _pos;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_stpverage_do_wu";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      return w_cdadata;
    }
    if (CPLib.eqr("chkcfis",p_cVarName)) {
      return w_chkcfis;
    }
    if (CPLib.eqr("noninvio",p_cVarName)) {
      return w_noninvio;
    }
    if (CPLib.eqr("codmage",p_cVarName)) {
      return w_codmage;
    }
    if (CPLib.eqr("fisccod",p_cVarName)) {
      return w_fisccod;
    }
    if (CPLib.eqr("statonas",p_cVarName)) {
      return w_statonas;
    }
    if (CPLib.eqr("tipoerr",p_cVarName)) {
      return w_tipoerr;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("_motivo",p_cVarName)) {
      return _motivo;
    }
    if (CPLib.eqr("_codrap",p_cVarName)) {
      return _codrap;
    }
    if (CPLib.eqr("_codper",p_cVarName)) {
      return _codper;
    }
    if (CPLib.eqr("_provnas",p_cVarName)) {
      return _provnas;
    }
    if (CPLib.eqr("_comnas",p_cVarName)) {
      return _comnas;
    }
    if (CPLib.eqr("_naznas",p_cVarName)) {
      return _naznas;
    }
    if (CPLib.eqr("_mesnas",p_cVarName)) {
      return _mesnas;
    }
    if (CPLib.eqr("_gionas",p_cVarName)) {
      return _gionas;
    }
    if (CPLib.eqr("_annnas",p_cVarName)) {
      return _annnas;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      return _sesso;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      return _codfisc;
    }
    if (CPLib.eqr("_cmesi",p_cVarName)) {
      return _cmesi;
    }
    if (CPLib.eqr("_motivo2",p_cVarName)) {
      return _motivo2;
    }
    if (CPLib.eqr("_chkcf",p_cVarName)) {
      return _chkcf;
    }
    if (CPLib.eqr("_chkstato",p_cVarName)) {
      return _chkstato;
    }
    if (CPLib.eqr("_chknet",p_cVarName)) {
      return _chknet;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      return filename;
    }
    if (CPLib.eqr("filepath",p_cVarName)) {
      return filepath;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      return w_CODFISC;
    }
    if (CPLib.eqr("NASCOMUN",p_cVarName)) {
      return w_NASCOMUN;
    }
    if (CPLib.eqr("NASSTATO",p_cVarName)) {
      return w_NASSTATO;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      return w_COGNOME;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      return w_RAGSOC;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      return w_NOME;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      return w_SESSO;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      return w_DaDatOpe;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      return w_ADatOpe;
    }
    if (CPLib.eqr("_datnas",p_cVarName)) {
      return _datnas;
    }
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      return w_DATANASC;
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
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_pos",p_cVarName)) {
      _pos = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
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
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      w_cdadata = value;
      return;
    }
    if (CPLib.eqr("chkcfis",p_cVarName)) {
      w_chkcfis = value;
      return;
    }
    if (CPLib.eqr("noninvio",p_cVarName)) {
      w_noninvio = value;
      return;
    }
    if (CPLib.eqr("codmage",p_cVarName)) {
      w_codmage = value;
      return;
    }
    if (CPLib.eqr("fisccod",p_cVarName)) {
      w_fisccod = value;
      return;
    }
    if (CPLib.eqr("statonas",p_cVarName)) {
      w_statonas = value;
      return;
    }
    if (CPLib.eqr("tipoerr",p_cVarName)) {
      w_tipoerr = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("_motivo",p_cVarName)) {
      _motivo = value;
      return;
    }
    if (CPLib.eqr("_codrap",p_cVarName)) {
      _codrap = value;
      return;
    }
    if (CPLib.eqr("_codper",p_cVarName)) {
      _codper = value;
      return;
    }
    if (CPLib.eqr("_provnas",p_cVarName)) {
      _provnas = value;
      return;
    }
    if (CPLib.eqr("_comnas",p_cVarName)) {
      _comnas = value;
      return;
    }
    if (CPLib.eqr("_naznas",p_cVarName)) {
      _naznas = value;
      return;
    }
    if (CPLib.eqr("_mesnas",p_cVarName)) {
      _mesnas = value;
      return;
    }
    if (CPLib.eqr("_gionas",p_cVarName)) {
      _gionas = value;
      return;
    }
    if (CPLib.eqr("_annnas",p_cVarName)) {
      _annnas = value;
      return;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      _sesso = value;
      return;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      _codfisc = value;
      return;
    }
    if (CPLib.eqr("_cmesi",p_cVarName)) {
      _cmesi = value;
      return;
    }
    if (CPLib.eqr("_motivo2",p_cVarName)) {
      _motivo2 = value;
      return;
    }
    if (CPLib.eqr("_chkcf",p_cVarName)) {
      _chkcf = value;
      return;
    }
    if (CPLib.eqr("_chkstato",p_cVarName)) {
      _chkstato = value;
      return;
    }
    if (CPLib.eqr("_chknet",p_cVarName)) {
      _chknet = value;
      return;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      filename = value;
      return;
    }
    if (CPLib.eqr("filepath",p_cVarName)) {
      filepath = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      w_CODFISC = value;
      return;
    }
    if (CPLib.eqr("NASCOMUN",p_cVarName)) {
      w_NASCOMUN = value;
      return;
    }
    if (CPLib.eqr("NASSTATO",p_cVarName)) {
      w_NASSTATO = value;
      return;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      w_COGNOME = value;
      return;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      w_RAGSOC = value;
      return;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      w_NOME = value;
      return;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      w_SESSO = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      w_DaDatOpe = value;
      return;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      w_ADatOpe = value;
      return;
    }
    if (CPLib.eqr("_datnas",p_cVarName)) {
      _datnas = value;
      return;
    }
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      w_DATANASC = value;
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_stpverage_do_wu_count=null;
    CPResultSet Cursor_tmp_stpverage_do=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pTipo Char(1) */
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_c_adata Char(8) */
      /* w_cdadata Char(8) */
      /* w_chkcfis Char(1) */
      /* w_noninvio Char(1) */
      /* w_codmage Char(5) // MacroAgente */
      /* w_fisccod Char(16) */
      /* w_statonas Char(40) // Paese di nascita */
      /* w_tipoerr Char(1) // Tipo Errore */
      /* _motivo Memo */
      /* _codrap Char(25) */
      /* _codper Char(16) */
      /* _datnas Date */
      /* _provnas Char(2) */
      /* _comnas Char(40) */
      /* _naznas Char(40) */
      /* _mesnas Char(2) */
      /* _gionas Char(2) */
      /* _annnas Char(4) */
      /* _sesso Char(1) */
      /* _codfisc Char(16) */
      /* _cmesi Char(12) */
      /* _pos Numeric(2, 0) */
      /* _motivo2 Memo */
      /* _chkcf Char(16) */
      /* _chkstato Char(30) */
      /* _chknet Char(5) */
      /* _report Object(ReportLibrary) */
      /* bReport Bool */
      /* filename Char(128) */
      /* filepath Char(128) */
      /* _conta Numeric(10, 0) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _reccount Numeric(15, 0) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gPathApp Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* w_CODFISC Char(16) // Codice Fiscale */
      /* w_DATANASC Date // Data Nascita */
      /* w_NASCOMUN Char(30) // Luogo di Nascita */
      /* w_NASSTATO Char(30) // Stato di nascita */
      /* w_COGNOME Char(26) // Ragione Sociale */
      /* w_RAGSOC Char(70) // Ragione Sociale */
      /* w_NOME Char(25) // Ragione Sociale */
      /* w_SESSO Char(1) // Sesso */
      /* Creazione file di appoggio */
      // * --- Drop temporary table tmp_stpverage_do
      if (m_Ctx.IsSharedTemp("tmp_stpverage_do")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpverage_do")) {
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpverage_do");
      }
      // * --- Create temporary table tmp_stpverage_do
      if (m_Ctx.IsSharedTemp("tmp_stpverage_do")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpverage_do")) {
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpverage_do");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_stpverage_do");
      if ( ! (m_Ctx.IsSharedTemp("tmp_stpverage_do"))) {
        m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stpverage_do",m_cServer,"proto")),m_cPhName,"tmp_stpverage_do",m_Ctx);
      }
      m_cPhName_tmp_stpverage_do = m_cPhName;
      /* Veirifica dati intermediario */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* If Empty(intermbo->CODINTER) or Empty(intermbo->DESCCIT) or Empty(intermbo->PROVINCIA) or Empty(intermbo->RAGSOC) */
        if (CPLib.Empty(Cursor_intermbo.GetString("CODINTER")) || CPLib.Empty(Cursor_intermbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_intermbo.GetString("PROVINCIA")) || CPLib.Empty(Cursor_intermbo.GetString("RAGSOC"))) {
          /* _motivo := "Non valorizzato:"+NL */
          _motivo = "Non valorizzato:"+"\n";
          /* If Empty(intermbo->CODINTER) */
          if (CPLib.Empty(Cursor_intermbo.GetString("CODINTER"))) {
            /* _motivo := _motivo + "-- Codice Fiscale"+NL */
            _motivo = _motivo+"-- Codice Fiscale"+"\n";
          } // End If
          /* If Empty(intermbo->DESCCIT) */
          if (CPLib.Empty(Cursor_intermbo.GetString("DESCCIT"))) {
            /* _motivo := _motivo + "-- Citta' Sede Legale"+NL */
            _motivo = _motivo+"-- Citta' Sede Legale"+"\n";
          } // End If
          /* If Empty(intermbo->PROVINCIA) */
          if (CPLib.Empty(Cursor_intermbo.GetString("PROVINCIA"))) {
            /* _motivo := _motivo + "-- Provincia Sede Legale"+NL */
            _motivo = _motivo+"-- Provincia Sede Legale"+"\n";
          } // End If
          /* If Empty(intermbo->RAGSOC) */
          if (CPLib.Empty(Cursor_intermbo.GetString("RAGSOC"))) {
            /* _motivo := _motivo + "-- Ragione Sociale"+NL */
            _motivo = _motivo+"-- Ragione Sociale"+"\n";
          } // End If
          // * --- Insert into tmp_stpverage_do from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"0000004A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000004A(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("INTERMEDIARIO","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Mancano in Anagrafica Intermediario alcuni dati","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
          /* If Len(LRTrim(intermbo->CODFISC)) = 16 */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))),16)) {
            // * --- Insert into tmp_stpverage_do from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
            m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"0000004C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000004C(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL("INTERMEDIARIO","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("In 1-01 Anagrafica intermediario dati non congrui","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Valorizzato cod. fisc. intermediario in modo errato","?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* Cicla su aederig e verifica tutto */
      /* gMsgImp := 'Attendere...Selezione soggetti da controllare' // Messaggio Import */
      gMsgImp = "Attendere...Selezione soggetti da controllare";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If w_noninvio='N' */
      if (CPLib.eqr(w_noninvio,"N")) {
        /* Exec "Tutte" Page 4:Page_4 */
        Page_4();
      } else { // Else
        /* Exec "Non Inviate" Page 3:Page_3 */
        Page_3();
      } // End If
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_stpverage_do_wu_count
      if (Cursor_qbe_stpverage_do_wu_count!=null)
        Cursor_qbe_stpverage_do_wu_count.Close();
      Cursor_qbe_stpverage_do_wu_count = new VQRHolder("qbe_stpverage_do_wu_count",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_stpverage_do_wu_count.Eof())) {
        /* _conta := qbe_stpverage_do_wu_count->TOTALE */
        _conta = CPLib.Round(Cursor_qbe_stpverage_do_wu_count.GetDouble("TOTALE"),0);
        Cursor_qbe_stpverage_do_wu_count.Next();
      }
      m_cConnectivityError = Cursor_qbe_stpverage_do_wu_count.ErrorMessage();
      Cursor_qbe_stpverage_do_wu_count.Close();
      // * --- End Select
      /* If pTipo='X' */
      if (CPLib.eqr(pTipo,"X")) {
        /* If _conta = 0 */
        if (CPLib.eqr(_conta,0)) {
          /* gMsgImp := 'Elaborazione Terminata ! Non ci sono dati da stampare' // Messaggio Import */
          gMsgImp = "Elaborazione Terminata ! Non ci sono dati da stampare";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } else { // Else
          /* gMsgImp := 'Elaborazione Terminata !' // Messaggio Import */
          gMsgImp = "Elaborazione Terminata !";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _report := ReportLibrary.GetReportLibrary() */
          _report = ReportLibrary.Make(m_Ctx).GetReportLibrary();
          /* filename := 'Errori_'+DateTimeToChar(DateTime()) */
          filename = "Errori_"+CPLib.DateTimeToChar(CPLib.DateTime());
          /* bReport := _report.makeReport('arrp_stpverage_do_wu',LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+"/"+LRTrim(filename),'A4','LANDSCAPE','XLS') */
          bReport = _report.makeReport("arrp_stpverage_do_wu",CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(filename),"A4","LANDSCAPE","XLS");
          /* filepath := LRTrim(Strtran(gPathApp,'/','//'))+"//stampe_off//"+LRTrim(gAzienda)+"//"+LRTrim(filename)+".xls" */
          filepath = CPLib.LRTrim(CPLib.Strtran(gPathApp,"/","//"))+"//stampe_off//"+CPLib.LRTrim(gAzienda)+"//"+CPLib.LRTrim(filename)+".xls";
          /* Stop LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+LRTrim(filepath) */
          Forward f;
          f=new Forward(CPLib.LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+CPLib.LRTrim(filepath),false,this,Forward.NoStatus,true);
          f.SetParameter("m_cParameterSequence", "");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
        } // End If
        /* ElseIf pTipo='U' */
      } else if (CPLib.eqr(pTipo,"U")) {
        /* If _conta=0 */
        if (CPLib.eqr(_conta,0)) {
          /* gMsgImp := 'Elaborazione Terminata ! Non ci sono dati da aggiornare' // Messaggio Import */
          gMsgImp = "Elaborazione Terminata ! Non ci sono dati da aggiornare";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } else { // Else
          // * --- Select from tmp_stpverage_do
          m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
          m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
          if (Cursor_tmp_stpverage_do!=null)
            Cursor_tmp_stpverage_do.Close();
          Cursor_tmp_stpverage_do = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_stpverage_do")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_stpverage_do.Eof())) {
            /* gMsgImp := 'Aggiornamento del soggetto con codice: ' + LRTrim(tmp_stpverage_do->NUMRAP) // Messaggio Import */
            gMsgImp = "Aggiornamento del soggetto con codice: "+CPLib.LRTrim(Cursor_tmp_stpverage_do.GetString("NUMRAP"));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            // * --- Write into opextrbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("opextrbo");
            m_cPhName = m_Ctx.GetPhName("opextrbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"00000062")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_stpverage_do.GetString("NUMRAP")),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_tmp_stpverage_do.GetString("NUMRAP")))+"";
            m_cSql = m_cSql+" and DATAOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_stpverage_do.GetDate("DATOPE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_stpverage_do.GetDate("DATOPE"))+"";
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
            Cursor_tmp_stpverage_do.Next();
          }
          m_cConnectivityError = Cursor_tmp_stpverage_do.ErrorMessage();
          Cursor_tmp_stpverage_do.Close();
          // * --- End Select
          /* gMsgImp := 'Elaborazione Terminata !' // Messaggio Import */
          gMsgImp = "Elaborazione Terminata !";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_stpverage_do_wu_count!=null)
          Cursor_qbe_stpverage_do_wu_count.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_stpverage_do!=null)
          Cursor_tmp_stpverage_do.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Ricava i dati dal codice fiscale */
      /* If Len(LRTrim(_codfisc)) = 16 */
      if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_codfisc)),16)) {
        /* _cmesi := "ABCDEHLMPRST" */
        _cmesi = "ABCDEHLMPRST";
        /* _pos := At(Substr(_codfisc,9,1),_cmesi) */
        _pos = CPLib.Round(CPLib.At(CPLib.Substr(_codfisc,9,1),_cmesi),0);
        /* _mesnas := Right('00'+LRTrim(Str(_pos,2,0)),2) */
        _mesnas = CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(_pos,2,0)),2);
        /* If Val(Substr(_codfisc,10,2)) >= 40 */
        if (CPLib.ge(CPLib.Val(CPLib.Substr(_codfisc,10,2)),40)) {
          /* _gionas := Right('00'+LRTrim(Str((Val(Substr(_codfisc,10,2)) - 40),2,0)),2) */
          _gionas = CPLib.Right("00"+CPLib.LRTrim(CPLib.Str((CPLib.Val(CPLib.Substr(_codfisc,10,2))-40),2,0)),2);
          /* _sesso := '2' */
          _sesso = "2";
        } else { // Else
          /* _gionas := Substr(_codfisc,10,2) */
          _gionas = CPLib.Substr(_codfisc,10,2);
          /* _sesso := '1' */
          _sesso = "1";
        } // End If
        /* _annnas := "19"+Substr(_codfisc,7,2) */
        _annnas = "19"+CPLib.Substr(_codfisc,7,2);
        /* _datnas := CharToDate(_annnas+_mesnas+_gionas) */
        _datnas = CPLib.CharToDate(_annnas+_mesnas+_gionas);
        /* _naznas := '' */
        _naznas = "";
        /* _provnas := '' */
        _provnas = "";
        /* _comnas := '' */
        _comnas = "";
        // * --- Read from tbcitta
        m_cServer = m_Ctx.GetServer("tbcitta");
        m_cPhName = m_Ctx.GetPhName("tbcitta");
        m_cSql = "";
        m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_codfisc,12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(_codfisc,12,4));
        if (m_Ctx.IsSharedTemp("tbcitta")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _comnas = Read_Cursor.GetString("CITTA");
          _provnas = Read_Cursor.GetString("PROV");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_stpverage_do_wu returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _comnas = "";
          _provnas = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(_provnas)) */
        if (CPLib.Empty(CPLib.LRTrim(_provnas))) {
          /* _comnas := '' */
          _comnas = "";
          /* _provnas := 'EE' */
          _provnas = "EE";
          // * --- Read from tbstati
          m_cServer = m_Ctx.GetServer("tbstati");
          m_cPhName = m_Ctx.GetPhName("tbstati");
          m_cSql = "";
          m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_codfisc,12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(_codfisc,12,4));
          if (m_Ctx.IsSharedTemp("tbstati")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _naznas = Read_Cursor.GetString("DESCRI");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbstati into routine arrt_stpverage_do_wu returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _naznas = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
        } // End If
      } // End If
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
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_chkopex_wu_1_minmax=null;
    CPResultSet Cursor_qbe_chkopex_wu_1=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_chkopex_wu_1_minmax
      if (Cursor_qbe_chkopex_wu_1_minmax!=null)
        Cursor_qbe_chkopex_wu_1_minmax.Close();
      Cursor_qbe_chkopex_wu_1_minmax = new VQRHolder("qbe_chkopex_wu_1_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_chkopex_wu_1_minmax.Eof())) {
        /* _min := qbe_chkopex_wu_1_minmax->MINOPX */
        _min = CPLib.Round(Cursor_qbe_chkopex_wu_1_minmax.GetDouble("MINOPX"),0);
        /* _max := qbe_chkopex_wu_1_minmax->MAXOPX */
        _max = CPLib.Round(Cursor_qbe_chkopex_wu_1_minmax.GetDouble("MAXOPX"),0);
        /* _tot := qbe_chkopex_wu_1_minmax->TOTOPX */
        _tot = CPLib.Round(Cursor_qbe_chkopex_wu_1_minmax.GetDouble("TOTOPX"),0);
        Cursor_qbe_chkopex_wu_1_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_chkopex_wu_1_minmax.ErrorMessage();
      Cursor_qbe_chkopex_wu_1_minmax.Close();
      // * --- End Select
      /* _reccount := _max - _min */
      _reccount = CPLib.Round(_max-_min,0);
      /* _cicli := iif(Mod(_reccount,1000) <> 0,Int(_reccount/1000) + 1,Int(_reccount/1000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,1000),0)?CPLib.Int(_reccount/1000)+1:CPLib.Int(_reccount/1000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* While _conta<=_cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* If _cicli = 1 */
        if (CPLib.eqr(_cicli,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* If _conta=1 */
          if (CPLib.eqr(_conta,1)) {
            /* _bottom := _min */
            _bottom = CPLib.Round(_min,0);
            /* _top := _min + 999 */
            _top = CPLib.Round(_min+999,0);
            /* ElseIf _conta = _cicli */
          } else if (CPLib.eqr(_conta,_cicli)) {
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _bottom + 999 */
            _top = CPLib.Round(_bottom+999,0);
          } // End If
        } // End If
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_chkopex_wu_1
          SPBridge.HMCaller _h0000008B;
          _h0000008B = new SPBridge.HMCaller();
          _h0000008B.Set("m_cVQRList",m_cVQRList);
          _h0000008B.Set("DaDatOpe",w_DaDatOpe);
          _h0000008B.Set("ADatOpe",w_ADatOpe);
          _h0000008B.Set("codmage",w_codmage);
          _h0000008B.Set("codfisc",w_fisccod);
          _h0000008B.Set("statonas",w_statonas);
          _h0000008B.Set("_bottom",_bottom);
          _h0000008B.Set("_top",_top);
          if (Cursor_qbe_chkopex_wu_1!=null)
            Cursor_qbe_chkopex_wu_1.Close();
          Cursor_qbe_chkopex_wu_1 = new VQRHolder("qbe_chkopex_wu_1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000008B,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_chkopex_wu_1.Eof())) {
            /* gMsgImp := 'Verifica soggetto con codice: ' + qbe_chkopex_wu_1->CONNESINT // Messaggio Import */
            gMsgImp = "Verifica soggetto con codice: "+Cursor_qbe_chkopex_wu_1.GetString("CONNESINT");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If Empty(qbe_chkopex_wu_1->ADATA) or Empty(qbe_chkopex_wu_1->CONNESINT) or Empty(qbe_chkopex_wu_1->TIPOAG) */
            if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetDate("ADATA")) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("CONNESINT")) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("TIPOAG"))) {
              /* _motivo := "Non valorizzato:"+NL */
              _motivo = "Non valorizzato:"+"\n";
              /* If Empty(qbe_chkopex_wu_1->CONNESINT) */
              if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("CONNESINT"))) {
                /* _motivo := _motivo + "-- Codice Cliente"+NL */
                _motivo = _motivo+"-- Codice Cliente"+"\n";
              } // End If
              /* If Empty(qbe_chkopex_wu_1->ADATA) */
              if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetDate("ADATA"))) {
                /* _motivo := _motivo + "-- Data Operazione"+NL */
                _motivo = _motivo+"-- Data Operazione"+"\n";
              } // End If
              /* If Empty(qbe_chkopex_wu_1->TIPOAG) */
              if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("TIPOAG"))) {
                /* _motivo := _motivo + "-- Tipo Rapporto"+NL */
                _motivo = _motivo+"-- Tipo Rapporto"+"\n";
              } // End If
              /* If Empty(w_tipoerr) or (not(Empty(w_tipoerr)) and w_tipoerr ='3') */
              if (CPLib.Empty(w_tipoerr) || ( ! (CPLib.Empty(w_tipoerr)) && CPLib.eqr(w_tipoerr,"3"))) {
                // * --- Insert into tmp_stpverage_do from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"00000096")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000096(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("In 6-02 Anag. Oper. ExtraConto Agenzia dati non congrui riga","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
            /* If Empty(LRTrim(qbe_chkopex_wu_1->CODFISC)) and (qbe_chkopex_wu_1->NOCODFISC='N' and qbe_chkopex_wu_1->CFESTERO=0) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_chkopex_wu_1.GetString("CODFISC"))) && (CPLib.eqr(Cursor_qbe_chkopex_wu_1.GetString("NOCODFISC"),"N") && CPLib.eqr(Cursor_qbe_chkopex_wu_1.GetDouble("CFESTERO"),0))) {
              /* If Empty(w_tipoerr) or (not(Empty(w_tipoerr)) and w_tipoerr ='6') */
              if (CPLib.Empty(w_tipoerr) || ( ! (CPLib.Empty(w_tipoerr)) && CPLib.eqr(w_tipoerr,"6"))) {
                // * --- Insert into tmp_stpverage_do from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"00000099")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000099(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Non presente intestatario dell'operazione in data "+CPLib.LRTrim(arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_chkopex_wu_1.GetDate("ADATA"))),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
            } else { // Else
              /* If qbe_chkopex_wu_1->CFESTERO=1 or qbe_chkopex_wu_1->NOCODFISC='S' */
              if (CPLib.eqr(Cursor_qbe_chkopex_wu_1.GetDouble("CFESTERO"),1) || CPLib.eqr(Cursor_qbe_chkopex_wu_1.GetString("NOCODFISC"),"S")) {
                /* If not(Empty(qbe_chkopex_wu_1->COGNOME)) or not(Empty(qbe_chkopex_wu_1->NOME)) */
                if ( ! (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("COGNOME"))) ||  ! (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NOME")))) {
                  /* If Empty(qbe_chkopex_wu_1->COGNOME) or Empty(qbe_chkopex_wu_1->NOME) or Empty(qbe_chkopex_wu_1->SESSO) or Empty(qbe_chkopex_wu_1->DATANASC) or (Empty(qbe_chkopex_wu_1->NASCOMUN) and Empty(qbe_chkopex_wu_1->NASSTATO)) or Empty(qbe_chkopex_wu_1->TIPINTER) */
                  if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("COGNOME")) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NOME")) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("SESSO")) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetDate("DATANASC")) || (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NASCOMUN")) && CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NASSTATO"))) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("TIPINTER"))) {
                    /* _motivo := "Non valorizzato:"+NL */
                    _motivo = "Non valorizzato:"+"\n";
                    /* If Empty(qbe_chkopex_wu_1->COGNOME) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("COGNOME"))) {
                      /* _motivo := _motivo + "--  Cognome"+NL */
                      _motivo = _motivo+"--  Cognome"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->NOME) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NOME"))) {
                      /* _motivo := _motivo + "--  Nome"+NL */
                      _motivo = _motivo+"--  Nome"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->SESSO) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("SESSO"))) {
                      /* _motivo := _motivo + "--  Sesso"+NL */
                      _motivo = _motivo+"--  Sesso"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->DATANASC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetDate("DATANASC"))) {
                      /* _motivo := _motivo + "--  Data di nascita"+NL */
                      _motivo = _motivo+"--  Data di nascita"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->NASCOMUN) and Empty(qbe_chkopex_wu_1->NASSTATO) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NASCOMUN")) && CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NASSTATO"))) {
                      /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                      _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->TIPINTER) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("TIPINTER"))) {
                      /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(w_tipoerr) or (not(Empty(w_tipoerr)) and w_tipoerr ='7') */
                    if (CPLib.Empty(w_tipoerr) || ( ! (CPLib.Empty(w_tipoerr)) && CPLib.eqr(w_tipoerr,"7"))) {
                      // * --- Insert into tmp_stpverage_do from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"000000AB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000AB(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetDate("ADATA"),"?",0,0)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                } else { // Else
                  /* If Empty(qbe_chkopex_wu_1->RAGSOC) or Empty(qbe_chkopex_wu_1->DESCCIT) or Empty(qbe_chkopex_wu_1->PROVINCIA) */
                  if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("RAGSOC")) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("DESCCIT")) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("PROVINCIA"))) {
                    /* If Empty(qbe_chkopex_wu_1->RAGSOC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("RAGSOC"))) {
                      /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                      _motivo = _motivo+"--  Ragione Sociale"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->DESCCIT) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("DESCCIT"))) {
                      /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                      _motivo = _motivo+"--  Città Sede Legale"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->PROVINCIA) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("PROVINCIA"))) {
                      /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(w_tipoerr) or (not(Empty(w_tipoerr)) and w_tipoerr ='9') */
                    if (CPLib.Empty(w_tipoerr) || ( ! (CPLib.Empty(w_tipoerr)) && CPLib.eqr(w_tipoerr,"9"))) {
                      // * --- Insert into tmp_stpverage_do from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"000000B4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000B4(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetDate("ADATA"),"?",0,0)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
              } else { // Else
                /* If Len(LRTrim(qbe_chkopex_wu_1->CODFISC)) = 16 */
                if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_qbe_chkopex_wu_1.GetString("CODFISC"))),16)) {
                  /* If Empty(qbe_chkopex_wu_1->COGNOME) or Empty(qbe_chkopex_wu_1->NOME) or Empty(qbe_chkopex_wu_1->SESSO) or Empty(qbe_chkopex_wu_1->DATANASC) or (Empty(qbe_chkopex_wu_1->NASCOMUN) and Empty(qbe_chkopex_wu_1->NASSTATO)) or Empty(qbe_chkopex_wu_1->TIPINTER) */
                  if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("COGNOME")) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NOME")) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("SESSO")) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetDate("DATANASC")) || (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NASCOMUN")) && CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NASSTATO"))) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("TIPINTER"))) {
                    /* _motivo := "Non valorizzato:" */
                    _motivo = "Non valorizzato:";
                    /* If Empty(qbe_chkopex_wu_1->COGNOME) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("COGNOME"))) {
                      /* _motivo := _motivo + "--  Cognome"+NL */
                      _motivo = _motivo+"--  Cognome"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->NOME) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NOME"))) {
                      /* _motivo := _motivo + "--  Nome"+NL */
                      _motivo = _motivo+"--  Nome"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->SESSO) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("SESSO"))) {
                      /* _motivo := _motivo + "--  Sesso"+NL */
                      _motivo = _motivo+"--  Sesso"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->DATANASC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetDate("DATANASC"))) {
                      /* _motivo := _motivo + "--  Data di nascita"+NL */
                      _motivo = _motivo+"--  Data di nascita"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->NASCOMUN) and Empty(qbe_chkopex_wu_1->NASSTATO) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NASCOMUN")) && CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NASSTATO"))) {
                      /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                      _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                    } // End If
                    /* If (Upper(LRTrim(qbe_chkopex_wu_1->NASSTATO))='ITALIA' or Upper(LRTrim(qbe_chkopex_wu_1->NASSTATO))='ITALY') and Empty(LRTrim(qbe_chkopex_wu_1->NASCOMUN)) */
                    if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_1.GetString("NASSTATO"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_1.GetString("NASSTATO"))),"ITALY")) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_chkopex_wu_1.GetString("NASCOMUN")))) {
                      /* _motivo := _motivo + "--  Comune di nascita"+NL */
                      _motivo = _motivo+"--  Comune di nascita"+"\n";
                    } // End If
                    /* If (Upper(LRTrim(qbe_chkopex_wu_1->NASCOMUN))='ITALIA' or Upper(LRTrim(qbe_chkopex_wu_1->NASCOMUN))='ITALY')  */
                    if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_1.GetString("NASCOMUN"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_1.GetString("NASCOMUN"))),"ITALY"))) {
                      /* _motivo := _motivo + "--  Comune di nascita errato"+NL */
                      _motivo = _motivo+"--  Comune di nascita errato"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->TIPINTER) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("TIPINTER"))) {
                      /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->CODFISC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("CODFISC"))) {
                      /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                      _motivo = _motivo+"--  Codice Fiscale"+"\n";
                    } // End If
                  } // End If
                  /* If w_chkcfis='S' */
                  if (CPLib.eqr(w_chkcfis,"S")) {
                    /* If not(arfn_chkcodfis(qbe_chkopex_wu_1->CODFISC,'086',qbe_chkopex_wu_1->CFESTERO)) */
                    if ( ! (arfn_chkcodfisR.Make(m_Ctx,this).Run(Cursor_qbe_chkopex_wu_1.GetString("CODFISC"),"086",Cursor_qbe_chkopex_wu_1.GetDouble("CFESTERO")))) {
                      /* _motivo := _motivo + "--  Codice Fiscale Errato"+NL */
                      _motivo = _motivo+"--  Codice Fiscale Errato"+"\n";
                    } // End If
                  } // End If
                  /* If Empty(w_tipoerr) or (not(Empty(w_tipoerr)) and w_tipoerr ='9') */
                  if (CPLib.Empty(w_tipoerr) || ( ! (CPLib.Empty(w_tipoerr)) && CPLib.eqr(w_tipoerr,"9"))) {
                    /* If not(Empty(LRTrim(_motivo))) and LRTrim(_motivo) <> "Non valorizzato:" */
                    if ( ! (CPLib.Empty(CPLib.LRTrim(_motivo))) && CPLib.ne(CPLib.LRTrim(_motivo),"Non valorizzato:")) {
                      // * --- Insert into tmp_stpverage_do from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"000000CF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000CF(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetDate("ADATA"),"?",0,0)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                /* If Len(LRTrim(qbe_chkopex_wu_1->CODFISC)) = 11 */
                if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_qbe_chkopex_wu_1.GetString("CODFISC"))),11)) {
                  /* If Empty(qbe_chkopex_wu_1->RAGSOC) or Empty(qbe_chkopex_wu_1->DESCCIT) or Empty(qbe_chkopex_wu_1->PROVINCIA) */
                  if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("RAGSOC")) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("DESCCIT")) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("PROVINCIA"))) {
                    /* If Empty(qbe_chkopex_wu_1->RAGSOC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("RAGSOC"))) {
                      /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                      _motivo = _motivo+"--  Ragione Sociale"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->DESCCIT) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("DESCCIT"))) {
                      /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                      _motivo = _motivo+"--  Città Sede Legale"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->PROVINCIA) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("PROVINCIA"))) {
                      /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->CODFISC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("CODFISC"))) {
                      /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                      _motivo = _motivo+"--  Codice Fiscale"+"\n";
                    } // End If
                    /* If Empty(w_tipoerr) or (not(Empty(w_tipoerr)) and w_tipoerr ='10') */
                    if (CPLib.Empty(w_tipoerr) || ( ! (CPLib.Empty(w_tipoerr)) && CPLib.eqr(w_tipoerr,"10"))) {
                      // * --- Insert into tmp_stpverage_do from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"000000DB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000DB(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetDate("ADATA"),"?",0,0)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                /* If Len(LRTrim(qbe_chkopex_wu_1->CODFISC)) <> 16 and Len(LRTrim(qbe_chkopex_wu_1->CODFISC)) <> 11 */
                if (CPLib.ne(CPLib.Len(CPLib.LRTrim(Cursor_qbe_chkopex_wu_1.GetString("CODFISC"))),16) && CPLib.ne(CPLib.Len(CPLib.LRTrim(Cursor_qbe_chkopex_wu_1.GetString("CODFISC"))),11)) {
                  /* If Empty(qbe_chkopex_wu_1->COGNOME) or Empty(qbe_chkopex_wu_1->NOME) or Empty(qbe_chkopex_wu_1->SESSO) or Empty(qbe_chkopex_wu_1->DATANASC) or (Empty(qbe_chkopex_wu_1->NASCOMUN) and Empty(qbe_chkopex_wu_1->NASSTATO)) or Empty(qbe_chkopex_wu_1->TIPINTER) */
                  if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("COGNOME")) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NOME")) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("SESSO")) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetDate("DATANASC")) || (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NASCOMUN")) && CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NASSTATO"))) || CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("TIPINTER"))) {
                    /* _motivo := "Non valorizzato:" */
                    _motivo = "Non valorizzato:";
                    /* If Empty(qbe_chkopex_wu_1->COGNOME) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("COGNOME"))) {
                      /* _motivo := _motivo + "--  Cognome"+NL */
                      _motivo = _motivo+"--  Cognome"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->NOME) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NOME"))) {
                      /* _motivo := _motivo + "--  Nome"+NL */
                      _motivo = _motivo+"--  Nome"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->SESSO) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("SESSO"))) {
                      /* _motivo := _motivo + "--  Sesso"+NL */
                      _motivo = _motivo+"--  Sesso"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->DATANASC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetDate("DATANASC"))) {
                      /* _motivo := _motivo + "--  Data di nascita"+NL */
                      _motivo = _motivo+"--  Data di nascita"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->NASCOMUN) and Empty(qbe_chkopex_wu_1->NASSTATO) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NASCOMUN")) && CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("NASSTATO"))) {
                      /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                      _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                    } // End If
                    /* If (Upper(LRTrim(qbe_chkopex_wu_1->NASSTATO))='ITALIA' or Upper(LRTrim(qbe_chkopex_wu_1->NASSTATO))='ITALY') and Empty(LRTrim(qbe_chkopex_wu_1->NASCOMUN)) */
                    if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_1.GetString("NASSTATO"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_1.GetString("NASSTATO"))),"ITALY")) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_chkopex_wu_1.GetString("NASCOMUN")))) {
                      /* _motivo := _motivo + "--  Comune di nascita"+NL */
                      _motivo = _motivo+"--  Comune di nascita"+"\n";
                    } // End If
                    /* If (Upper(LRTrim(qbe_chkopex_wu_1->NASCOMUN))='ITALIA' or Upper(LRTrim(qbe_chkopex_wu_1->NASCOMUN))='ITALY')  */
                    if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_1.GetString("NASCOMUN"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_1.GetString("NASCOMUN"))),"ITALY"))) {
                      /* _motivo := _motivo + "--  Comune di nascita errato"+NL */
                      _motivo = _motivo+"--  Comune di nascita errato"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->TIPINTER) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("TIPINTER"))) {
                      /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_1->CODFISC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("CODFISC"))) {
                      /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                      _motivo = _motivo+"--  Codice Fiscale"+"\n";
                    } // End If
                    /* If not(Empty(qbe_chkopex_wu_1->CODFISC)) */
                    if ( ! (CPLib.Empty(Cursor_qbe_chkopex_wu_1.GetString("CODFISC")))) {
                      /* _motivo := _motivo + "--  Codice Fiscale Errato"+NL */
                      _motivo = _motivo+"--  Codice Fiscale Errato"+"\n";
                    } // End If
                  } // End If
                  // * --- Insert into tmp_stpverage_do from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"000000F3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000000F3(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_1.GetDate("ADATA"),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
            /* _motivo := '' */
            _motivo = "";
            Cursor_qbe_chkopex_wu_1.Next();
          }
          m_cConnectivityError = Cursor_qbe_chkopex_wu_1.ErrorMessage();
          Cursor_qbe_chkopex_wu_1.Close();
          // * --- End Select
        } // End If
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_chkopex_wu_1_minmax!=null)
          Cursor_qbe_chkopex_wu_1_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_chkopex_wu_1!=null)
          Cursor_qbe_chkopex_wu_1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_chkopex_wu_2_minmax=null;
    CPResultSet Cursor_qbe_chkopex_wu_2=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_chkopex_wu_2_minmax
      if (Cursor_qbe_chkopex_wu_2_minmax!=null)
        Cursor_qbe_chkopex_wu_2_minmax.Close();
      Cursor_qbe_chkopex_wu_2_minmax = new VQRHolder("qbe_chkopex_wu_2_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_chkopex_wu_2_minmax.Eof())) {
        /* _min := qbe_chkopex_wu_2_minmax->MINOPX */
        _min = CPLib.Round(Cursor_qbe_chkopex_wu_2_minmax.GetDouble("MINOPX"),0);
        /* _max := qbe_chkopex_wu_2_minmax->MAXOPX */
        _max = CPLib.Round(Cursor_qbe_chkopex_wu_2_minmax.GetDouble("MAXOPX"),0);
        /* _tot := qbe_chkopex_wu_2_minmax->TOTOPX */
        _tot = CPLib.Round(Cursor_qbe_chkopex_wu_2_minmax.GetDouble("TOTOPX"),0);
        Cursor_qbe_chkopex_wu_2_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_chkopex_wu_2_minmax.ErrorMessage();
      Cursor_qbe_chkopex_wu_2_minmax.Close();
      // * --- End Select
      /* _reccount := _max - _min */
      _reccount = CPLib.Round(_max-_min,0);
      /* _cicli := iif(Mod(_reccount,1000) <> 0,Int(_reccount/1000) + 1,Int(_reccount/1000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,1000),0)?CPLib.Int(_reccount/1000)+1:CPLib.Int(_reccount/1000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* While _conta<=_cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* If _cicli = 1 */
        if (CPLib.eqr(_cicli,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* If _conta=1 */
          if (CPLib.eqr(_conta,1)) {
            /* _bottom := _min */
            _bottom = CPLib.Round(_min,0);
            /* _top := _min + 999 */
            _top = CPLib.Round(_min+999,0);
            /* ElseIf _conta = _cicli */
          } else if (CPLib.eqr(_conta,_cicli)) {
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _bottom + 999 */
            _top = CPLib.Round(_bottom+999,0);
          } // End If
        } // End If
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_chkopex_wu_2
          SPBridge.HMCaller _h00000109;
          _h00000109 = new SPBridge.HMCaller();
          _h00000109.Set("m_cVQRList",m_cVQRList);
          _h00000109.Set("DaDatOpe",w_DaDatOpe);
          _h00000109.Set("ADatOpe",w_ADatOpe);
          _h00000109.Set("codmage",w_codmage);
          _h00000109.Set("codfisc",w_fisccod);
          _h00000109.Set("statonas",w_statonas);
          _h00000109.Set("_bottom",_bottom);
          _h00000109.Set("_top",_top);
          if (Cursor_qbe_chkopex_wu_2!=null)
            Cursor_qbe_chkopex_wu_2.Close();
          Cursor_qbe_chkopex_wu_2 = new VQRHolder("qbe_chkopex_wu_2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000109,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_chkopex_wu_2.Eof())) {
            /* gMsgImp := 'Verifica soggetto con codice: ' + qbe_chkopex_wu_2->CONNESINT // Messaggio Import */
            gMsgImp = "Verifica soggetto con codice: "+Cursor_qbe_chkopex_wu_2.GetString("CONNESINT");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If Empty(qbe_chkopex_wu_2->ADATA) or Empty(qbe_chkopex_wu_2->CONNESINT) or Empty(qbe_chkopex_wu_2->TIPOAG) */
            if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetDate("ADATA")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("CONNESINT")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("TIPOAG"))) {
              /* _motivo := "Non valorizzato:"+NL */
              _motivo = "Non valorizzato:"+"\n";
              /* If Empty(qbe_chkopex_wu_2->CONNESINT) */
              if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("CONNESINT"))) {
                /* _motivo := _motivo + "-- Codice Cliente"+NL */
                _motivo = _motivo+"-- Codice Cliente"+"\n";
              } // End If
              /* If Empty(qbe_chkopex_wu_2->ADATA) */
              if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetDate("ADATA"))) {
                /* _motivo := _motivo + "-- Data Apertura"+NL */
                _motivo = _motivo+"-- Data Apertura"+"\n";
              } // End If
              /* If Empty(qbe_chkopex_wu_2->TIPOAG) */
              if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("TIPOAG"))) {
                /* _motivo := _motivo + "-- Tipo Rapporto"+NL */
                _motivo = _motivo+"-- Tipo Rapporto"+"\n";
              } // End If
              /* If Empty(w_tipoerr) or (not(Empty(w_tipoerr)) and w_tipoerr ='3') */
              if (CPLib.Empty(w_tipoerr) || ( ! (CPLib.Empty(w_tipoerr)) && CPLib.eqr(w_tipoerr,"3"))) {
                // * --- Insert into tmp_stpverage_do from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"00000114")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000114(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("CONNESINT")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_2.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("In 6-02 Anag. Oper. ExtraConto Agenzia dati non congrui riga","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_2.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_2.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
            /* If Empty(LRTrim(qbe_chkopex_wu_2->CODFISC)) and qbe_chkopex_wu_2->NOCODFISC='N' */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("CODFISC"))) && CPLib.eqr(Cursor_qbe_chkopex_wu_2.GetString("NOCODFISC"),"N")) {
              /* If Empty(w_tipoerr) or (not(Empty(w_tipoerr)) and w_tipoerr ='6') */
              if (CPLib.Empty(w_tipoerr) || ( ! (CPLib.Empty(w_tipoerr)) && CPLib.eqr(w_tipoerr,"6"))) {
                // * --- Insert into tmp_stpverage_do from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"00000117")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000117(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("CONNESINT")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Non presente intestatario dell'operazione in data "+CPLib.LRTrim(arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_chkopex_wu_2.GetDate("ADATA"))),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_2.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_2.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
            } else { // Else
              /* If qbe_chkopex_wu_2->CFESTERO=1 or qbe_chkopex_wu_2->NOCODFISC='S' */
              if (CPLib.eqr(Cursor_qbe_chkopex_wu_2.GetDouble("CFESTERO"),1) || CPLib.eqr(Cursor_qbe_chkopex_wu_2.GetString("NOCODFISC"),"S")) {
                /* If not(Empty(qbe_chkopex_wu_2->COGNOME)) or not(Empty(qbe_chkopex_wu_2->NOME)) */
                if ( ! (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("COGNOME"))) ||  ! (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NOME")))) {
                  /* If Empty(qbe_chkopex_wu_2->COGNOME) or Empty(qbe_chkopex_wu_2->NOME) or Empty(qbe_chkopex_wu_2->SESSO) or Empty(qbe_chkopex_wu_2->DATANASC) or (Empty(qbe_chkopex_wu_2->NASCOMUN) and Empty(qbe_chkopex_wu_2->NASSTATO)) or Empty(qbe_chkopex_wu_2->TIPINTER) */
                  if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("COGNOME")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NOME")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("SESSO")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetDate("DATANASC")) || (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NASCOMUN")) && CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NASSTATO"))) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("TIPINTER"))) {
                    /* _motivo := "Non valorizzato:"+NL */
                    _motivo = "Non valorizzato:"+"\n";
                    /* If Empty(qbe_chkopex_wu_2->COGNOME) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("COGNOME"))) {
                      /* _motivo := _motivo + "--  Cognome"+NL */
                      _motivo = _motivo+"--  Cognome"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->NOME) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NOME"))) {
                      /* _motivo := _motivo + "--  Nome"+NL */
                      _motivo = _motivo+"--  Nome"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->SESSO) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("SESSO"))) {
                      /* _motivo := _motivo + "--  Sesso"+NL */
                      _motivo = _motivo+"--  Sesso"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->DATANASC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetDate("DATANASC"))) {
                      /* _motivo := _motivo + "--  Data di nascita"+NL */
                      _motivo = _motivo+"--  Data di nascita"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->NASCOMUN) and Empty(qbe_chkopex_wu_2->NASSTATO) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NASCOMUN")) && CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NASSTATO"))) {
                      /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                      _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->TIPINTER) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("TIPINTER"))) {
                      /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(w_tipoerr) or (not(Empty(w_tipoerr)) and w_tipoerr ='7') */
                    if (CPLib.Empty(w_tipoerr) || ( ! (CPLib.Empty(w_tipoerr)) && CPLib.eqr(w_tipoerr,"7"))) {
                      // * --- Insert into tmp_stpverage_do from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"00000129")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000129(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("CONNESINT")),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_2.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_2.GetDate("ADATA"),"?",0,0)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                } else { // Else
                  /* If Empty(qbe_chkopex_wu_2->RAGSOC) or Empty(qbe_chkopex_wu_2->DESCCIT) or Empty(qbe_chkopex_wu_2->PROVINCIA) */
                  if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("RAGSOC")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("DESCCIT")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("PROVINCIA"))) {
                    /* If Empty(qbe_chkopex_wu_2->RAGSOC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("RAGSOC"))) {
                      /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                      _motivo = _motivo+"--  Ragione Sociale"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->DESCCIT) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("DESCCIT"))) {
                      /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                      _motivo = _motivo+"--  Città Sede Legale"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->PROVINCIA) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("PROVINCIA"))) {
                      /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(w_tipoerr) or (not(Empty(w_tipoerr)) and w_tipoerr ='9') */
                    if (CPLib.Empty(w_tipoerr) || ( ! (CPLib.Empty(w_tipoerr)) && CPLib.eqr(w_tipoerr,"9"))) {
                      // * --- Insert into tmp_stpverage_do from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"00000132")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000132(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("CONNESINT")),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_2.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_2.GetDate("ADATA"),"?",0,0)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
              } else { // Else
                /* If Len(LRTrim(qbe_chkopex_wu_2->CODFISC)) = 16 */
                if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("CODFISC"))),16)) {
                  /* If Empty(qbe_chkopex_wu_2->COGNOME) or Empty(qbe_chkopex_wu_2->NOME) or Empty(qbe_chkopex_wu_2->SESSO) or Empty(qbe_chkopex_wu_2->DATANASC) or (Empty(qbe_chkopex_wu_2->NASCOMUN) and Empty(qbe_chkopex_wu_2->NASSTATO)) or Empty(qbe_chkopex_wu_2->TIPINTER) */
                  if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("COGNOME")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NOME")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("SESSO")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetDate("DATANASC")) || (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NASCOMUN")) && CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NASSTATO"))) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("TIPINTER"))) {
                    /* _motivo := "Non valorizzato:" */
                    _motivo = "Non valorizzato:";
                    /* If Empty(qbe_chkopex_wu_2->COGNOME) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("COGNOME"))) {
                      /* _motivo := _motivo + "--  Cognome"+NL */
                      _motivo = _motivo+"--  Cognome"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->NOME) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NOME"))) {
                      /* _motivo := _motivo + "--  Nome"+NL */
                      _motivo = _motivo+"--  Nome"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->SESSO) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("SESSO"))) {
                      /* _motivo := _motivo + "--  Sesso"+NL */
                      _motivo = _motivo+"--  Sesso"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->DATANASC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetDate("DATANASC"))) {
                      /* _motivo := _motivo + "--  Data di nascita"+NL */
                      _motivo = _motivo+"--  Data di nascita"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->NASCOMUN) and Empty(qbe_chkopex_wu_2->NASSTATO) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NASCOMUN")) && CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NASSTATO"))) {
                      /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                      _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                    } // End If
                    /* If (Upper(LRTrim(qbe_chkopex_wu_2->NASSTATO))='ITALIA' or Upper(LRTrim(qbe_chkopex_wu_2->NASSTATO))='ITALY') and Empty(LRTrim(qbe_chkopex_wu_2->NASCOMUN)) */
                    if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("NASSTATO"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("NASSTATO"))),"ITALY")) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("NASCOMUN")))) {
                      /* _motivo := _motivo + "--  Comune di nascita"+NL */
                      _motivo = _motivo+"--  Comune di nascita"+"\n";
                    } // End If
                    /* If (Upper(LRTrim(qbe_chkopex_wu_2->NASCOMUN))='ITALIA' or Upper(LRTrim(qbe_chkopex_wu_2->NASCOMUN))='ITALY')  */
                    if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("NASCOMUN"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("NASCOMUN"))),"ITALY"))) {
                      /* _motivo := _motivo + "--  Comune di nascita errato"+NL */
                      _motivo = _motivo+"--  Comune di nascita errato"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->TIPINTER) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("TIPINTER"))) {
                      /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->CODFISC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("CODFISC"))) {
                      /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                      _motivo = _motivo+"--  Codice Fiscale"+"\n";
                    } // End If
                  } // End If
                  /* If w_chkcfis='S' */
                  if (CPLib.eqr(w_chkcfis,"S")) {
                    /* If arfn_chkcodfis(qbe_chkopex_wu_2->CODFISC,'086',qbe_chkopex_wu_2->CFESTERO) */
                    if (arfn_chkcodfisR.Make(m_Ctx,this).Run(Cursor_qbe_chkopex_wu_2.GetString("CODFISC"),"086",Cursor_qbe_chkopex_wu_2.GetDouble("CFESTERO"))) {
                      /* w_CODFISC := '' // Codice Fiscale */
                      w_CODFISC = "";
                      /* w_DATANASC := NullDate() // Data Nascita */
                      w_DATANASC = CPLib.NullDate();
                      /* w_NASCOMUN := '' // Luogo di Nascita */
                      w_NASCOMUN = "";
                      /* w_NASSTATO := '' // Stato di nascita */
                      w_NASSTATO = "";
                      /* w_COGNOME := '' // Ragione Sociale */
                      w_COGNOME = "";
                      /* w_RAGSOC := '' // Ragione Sociale */
                      w_RAGSOC = "";
                      /* w_NOME := '' // Ragione Sociale */
                      w_NOME = "";
                      /* w_SESSO := '' // Sesso */
                      w_SESSO = "";
                      /* w_DATANASC := qbe_chkopex_wu_2->DATANASC // Data Nascita */
                      w_DATANASC = Cursor_qbe_chkopex_wu_2.GetDate("DATANASC");
                      /* w_NASCOMUN := qbe_chkopex_wu_2->NASCOMUN // Luogo di Nascita */
                      w_NASCOMUN = Cursor_qbe_chkopex_wu_2.GetString("NASCOMUN");
                      /* w_NASSTATO := qbe_chkopex_wu_2->NASSTATO // Stato di nascita */
                      w_NASSTATO = Cursor_qbe_chkopex_wu_2.GetString("NASSTATO");
                      /* w_COGNOME := qbe_chkopex_wu_2->COGNOME // Ragione Sociale */
                      w_COGNOME = Cursor_qbe_chkopex_wu_2.GetString("COGNOME");
                      /* w_RAGSOC := qbe_chkopex_wu_2->RAGSOC // Ragione Sociale */
                      w_RAGSOC = Cursor_qbe_chkopex_wu_2.GetString("RAGSOC");
                      /* w_NOME := qbe_chkopex_wu_2->NOME // Ragione Sociale */
                      w_NOME = Cursor_qbe_chkopex_wu_2.GetString("NOME");
                      /* w_SESSO := qbe_chkopex_wu_2->SESSO // Sesso */
                      w_SESSO = Cursor_qbe_chkopex_wu_2.GetString("SESSO");
                      /* Exec Routine arrt_calccodfis */
                      arrt_calccodfisR.Make(m_Ctx,this).Run();
                      /* _codfisc := qbe_chkopex_wu_2->CODFISC */
                      _codfisc = Cursor_qbe_chkopex_wu_2.GetString("CODFISC");
                      /* Exec "Ricava dati da codice fiscale" Page 2:Page_2 */
                      Page_2();
                      /* _motivo2 := "" */
                      _motivo2 = "";
                      /* If not(Empty(w_CODFISC)) */
                      if ( ! (CPLib.Empty(w_CODFISC))) {
                        /* If Left(_codfisc,3) <> Left(w_CODFISC,3) */
                        if (CPLib.ne(CPLib.Left(_codfisc,3),CPLib.Left(w_CODFISC,3))) {
                          /* _motivo2 := _motivo2 + "++ Cognome"+NL */
                          _motivo2 = _motivo2+"++ Cognome"+"\n";
                        } // End If
                        /* If Substr(_codfisc,4,3) <> Substr(w_CODFISC,4,3) */
                        if (CPLib.ne(CPLib.Substr(_codfisc,4,3),CPLib.Substr(w_CODFISC,4,3))) {
                          /* _motivo2 := _motivo2 + "++ Nome"+NL */
                          _motivo2 = _motivo2+"++ Nome"+"\n";
                        } // End If
                      } // End If
                      /* If _datnas <> qbe_chkopex_wu_2->DATANASC */
                      if (CPLib.ne(_datnas,Cursor_qbe_chkopex_wu_2.GetDate("DATANASC"))) {
                        /* _motivo2 := _motivo2 + "++  Data di nascita"+NL */
                        _motivo2 = _motivo2+"++  Data di nascita"+"\n";
                      } // End If
                      /* If _provnas <> qbe_chkopex_wu_2->TIPINTER */
                      if (CPLib.ne(_provnas,Cursor_qbe_chkopex_wu_2.GetString("TIPINTER"))) {
                        /* _motivo2 := _motivo2 + "++  Provincia di nascita"+NL */
                        _motivo2 = _motivo2+"++  Provincia di nascita"+"\n";
                      } // End If
                      /* If _sesso <> qbe_chkopex_wu_2->SESSO */
                      if (CPLib.ne(_sesso,Cursor_qbe_chkopex_wu_2.GetString("SESSO"))) {
                        /* _motivo2 := _motivo2 + "++  Sesso"+NL */
                        _motivo2 = _motivo2+"++  Sesso"+"\n";
                      } // End If
                      /* If not(Empty(_comnas)) */
                      if ( ! (CPLib.Empty(_comnas))) {
                        /* If LRTrim(_comnas) <> LRTrim(qbe_chkopex_wu_2->NASCOMUN) */
                        if (CPLib.ne(CPLib.LRTrim(_comnas),CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("NASCOMUN")))) {
                          /* _motivo2 := _motivo2 + "++  Comune di nascita"+NL */
                          _motivo2 = _motivo2+"++  Comune di nascita"+"\n";
                        } // End If
                      } // End If
                      /* If not(Empty(_naznas)) */
                      if ( ! (CPLib.Empty(_naznas))) {
                        /* If LRTrim(_naznas) <> LRTrim(qbe_chkopex_wu_2->NASSTATO) */
                        if (CPLib.ne(CPLib.LRTrim(_naznas),CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("NASSTATO")))) {
                          /* _motivo2 := _motivo2 + "++  Stato di nascita"+NL */
                          _motivo2 = _motivo2+"++  Stato di nascita"+"\n";
                        } // End If
                      } // End If
                      /* If Len(LRTrim(_motivo2)) > 0 */
                      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_motivo2)),0)) {
                        /* _motivo := _motivo + "--  Codice Fiscale Incongruente per:"+NL+_motivo2+NL */
                        _motivo = _motivo+"--  Codice Fiscale Incongruente per:"+"\n"+_motivo2+"\n";
                      } // End If
                    } else { // Else
                      /* _motivo := _motivo + "--  Codice Fiscale Errato"+NL */
                      _motivo = _motivo+"--  Codice Fiscale Errato"+"\n";
                    } // End If
                  } // End If
                  /* If Empty(w_tipoerr) or (not(Empty(w_tipoerr)) and w_tipoerr ='9') */
                  if (CPLib.Empty(w_tipoerr) || ( ! (CPLib.Empty(w_tipoerr)) && CPLib.eqr(w_tipoerr,"9"))) {
                    /* If not(Empty(LRTrim(_motivo))) and LRTrim(_motivo) <> "Non valorizzato:" */
                    if ( ! (CPLib.Empty(CPLib.LRTrim(_motivo))) && CPLib.ne(CPLib.LRTrim(_motivo),"Non valorizzato:")) {
                      // * --- Insert into tmp_stpverage_do from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"00000175")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000175(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("CONNESINT")),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_2.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_2.GetDate("ADATA"),"?",0,0)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                /* If Len(LRTrim(qbe_chkopex_wu_2->CODFISC)) = 11 */
                if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("CODFISC"))),11)) {
                  /* If Empty(qbe_chkopex_wu_2->RAGSOC) or Empty(qbe_chkopex_wu_2->DESCCIT) or Empty(qbe_chkopex_wu_2->PROVINCIA) or Empty(qbe_chkopex_wu_2->CODFISC) */
                  if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("RAGSOC")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("DESCCIT")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("PROVINCIA")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("CODFISC"))) {
                    /* If Empty(qbe_chkopex_wu_2->RAGSOC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("RAGSOC"))) {
                      /* _motivo := _motivo + "--  Ragione Sociale"+NL */
                      _motivo = _motivo+"--  Ragione Sociale"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->DESCCIT) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("DESCCIT"))) {
                      /* _motivo := _motivo + "--  Città Sede Legale"+NL */
                      _motivo = _motivo+"--  Città Sede Legale"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->PROVINCIA) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("PROVINCIA"))) {
                      /* _motivo := _motivo + "--  Provincia Sede Legale (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia Sede Legale (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->CODFISC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("CODFISC"))) {
                      /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                      _motivo = _motivo+"--  Codice Fiscale"+"\n";
                    } // End If
                    /* If Empty(w_tipoerr) or (not(Empty(w_tipoerr)) and w_tipoerr ='10') */
                    if (CPLib.Empty(w_tipoerr) || ( ! (CPLib.Empty(w_tipoerr)) && CPLib.eqr(w_tipoerr,"10"))) {
                      // * --- Insert into tmp_stpverage_do from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"00000181")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000181(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("CONNESINT")),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_2.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_2.GetDate("ADATA"),"?",0,0)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
                /* If Len(LRTrim(qbe_chkopex_wu_2->CODFISC)) <> 16 and Len(LRTrim(qbe_chkopex_wu_2->CODFISC)) <> 11 */
                if (CPLib.ne(CPLib.Len(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("CODFISC"))),16) && CPLib.ne(CPLib.Len(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("CODFISC"))),11)) {
                  /* If Empty(qbe_chkopex_wu_2->COGNOME) or Empty(qbe_chkopex_wu_2->NOME) or Empty(qbe_chkopex_wu_2->SESSO) or Empty(qbe_chkopex_wu_2->DATANASC) or (Empty(qbe_chkopex_wu_2->NASCOMUN) and Empty(qbe_chkopex_wu_2->NASSTATO)) or Empty(qbe_chkopex_wu_2->TIPINTER) */
                  if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("COGNOME")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NOME")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("SESSO")) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetDate("DATANASC")) || (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NASCOMUN")) && CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NASSTATO"))) || CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("TIPINTER"))) {
                    /* _motivo := "Non valorizzato:" */
                    _motivo = "Non valorizzato:";
                    /* If Empty(qbe_chkopex_wu_2->COGNOME) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("COGNOME"))) {
                      /* _motivo := _motivo + "--  Cognome"+NL */
                      _motivo = _motivo+"--  Cognome"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->NOME) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NOME"))) {
                      /* _motivo := _motivo + "--  Nome"+NL */
                      _motivo = _motivo+"--  Nome"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->SESSO) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("SESSO"))) {
                      /* _motivo := _motivo + "--  Sesso"+NL */
                      _motivo = _motivo+"--  Sesso"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->DATANASC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetDate("DATANASC"))) {
                      /* _motivo := _motivo + "--  Data di nascita"+NL */
                      _motivo = _motivo+"--  Data di nascita"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->NASCOMUN) and Empty(qbe_chkopex_wu_2->NASSTATO) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NASCOMUN")) && CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("NASSTATO"))) {
                      /* _motivo := _motivo + "--  Comune o stato di nascita"+NL */
                      _motivo = _motivo+"--  Comune o stato di nascita"+"\n";
                    } // End If
                    /* If (Upper(LRTrim(qbe_chkopex_wu_2->NASSTATO))='ITALIA' or Upper(LRTrim(qbe_chkopex_wu_2->NASSTATO))='ITALY') and Empty(LRTrim(qbe_chkopex_wu_2->NASCOMUN)) */
                    if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("NASSTATO"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("NASSTATO"))),"ITALY")) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("NASCOMUN")))) {
                      /* _motivo := _motivo + "--  Comune di nascita"+NL */
                      _motivo = _motivo+"--  Comune di nascita"+"\n";
                    } // End If
                    /* If (Upper(LRTrim(qbe_chkopex_wu_2->NASCOMUN))='ITALIA' or Upper(LRTrim(qbe_chkopex_wu_2->NASCOMUN))='ITALY')  */
                    if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("NASCOMUN"))),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("NASCOMUN"))),"ITALY"))) {
                      /* _motivo := _motivo + "--  Comune di nascita errato"+NL */
                      _motivo = _motivo+"--  Comune di nascita errato"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->TIPINTER) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("TIPINTER"))) {
                      /* _motivo := _motivo + "--  Provincia di nascita (EE se straniero)"+NL */
                      _motivo = _motivo+"--  Provincia di nascita (EE se straniero)"+"\n";
                    } // End If
                    /* If Empty(qbe_chkopex_wu_2->CODFISC) */
                    if (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("CODFISC"))) {
                      /* _motivo := _motivo + "--  Codice Fiscale"+NL */
                      _motivo = _motivo+"--  Codice Fiscale"+"\n";
                    } // End If
                    /* If not(Empty(qbe_chkopex_wu_2->CODFISC)) */
                    if ( ! (CPLib.Empty(Cursor_qbe_chkopex_wu_2.GetString("CODFISC")))) {
                      /* _motivo := _motivo + "--  Codice Fiscale Errato"+NL */
                      _motivo = _motivo+"--  Codice Fiscale Errato"+"\n";
                    } // End If
                  } // End If
                  /* If w_chkcfis='S' */
                  if (CPLib.eqr(w_chkcfis,"S")) {
                    /* If not(arfn_chkcodfis(qbe_chkopex_wu_2->CODFISC,'086',qbe_chkopex_wu_2->CFESTERO)) */
                    if ( ! (arfn_chkcodfisR.Make(m_Ctx,this).Run(Cursor_qbe_chkopex_wu_2.GetString("CODFISC"),"086",Cursor_qbe_chkopex_wu_2.GetDouble("CFESTERO")))) {
                      /* _motivo := _motivo + "--  Codice Fiscale Errato"+NL */
                      _motivo = _motivo+"--  Codice Fiscale Errato"+"\n";
                    } // End If
                  } // End If
                  /* If Empty(w_tipoerr) or (not(Empty(w_tipoerr)) and w_tipoerr ='9') */
                  if (CPLib.Empty(w_tipoerr) || ( ! (CPLib.Empty(w_tipoerr)) && CPLib.eqr(w_tipoerr,"9"))) {
                    /* If not(Empty(LRTrim(_motivo))) and LRTrim(_motivo) <> "Non valorizzato:" */
                    if ( ! (CPLib.Empty(CPLib.LRTrim(_motivo))) && CPLib.ne(CPLib.LRTrim(_motivo),"Non valorizzato:")) {
                      // * --- Insert into tmp_stpverage_do from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_stpverage_do");
                      m_cPhName = m_Ctx.GetPhName("tmp_stpverage_do");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpverage_do",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stpverage_do_wu",119,"0000019E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000019E(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_chkopex_wu_2.GetString("CONNESINT")),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_motivo,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("In 2-01 Anagrafica Persone e societa'","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_2.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_chkopex_wu_2.GetDate("ADATA"),"?",0,0)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpverage_do",true);
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
              } // End If
            } // End If
            /* _motivo := '' */
            _motivo = "";
            Cursor_qbe_chkopex_wu_2.Next();
          }
          m_cConnectivityError = Cursor_qbe_chkopex_wu_2.ErrorMessage();
          Cursor_qbe_chkopex_wu_2.Close();
          // * --- End Select
        } // End If
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_chkopex_wu_2_minmax!=null)
          Cursor_qbe_chkopex_wu_2_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_chkopex_wu_2!=null)
          Cursor_qbe_chkopex_wu_2.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pTipo) {
    pTipo = p_pTipo;
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
  public Forward Run(String p_pTipo) {
    pTipo = p_pTipo;
    return Run();
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
      m_Caller.SetDate("DaDatOpe","D",8,0,w_DaDatOpe);
      m_Caller.SetDate("ADatOpe","D",8,0,w_ADatOpe);
      m_Caller.SetString("c_adata","C",8,0,w_c_adata);
      m_Caller.SetString("cdadata","C",8,0,w_cdadata);
      m_Caller.SetString("chkcfis","C",1,0,w_chkcfis);
      m_Caller.SetString("noninvio","C",1,0,w_noninvio);
      m_Caller.SetString("codmage","C",5,0,w_codmage);
      m_Caller.SetString("fisccod","C",16,0,w_fisccod);
      m_Caller.SetString("statonas","C",40,0,w_statonas);
      m_Caller.SetString("tipoerr","C",1,0,w_tipoerr);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stpverage_do_wuR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stpverage_do_wuR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    w_c_adata = m_Caller.GetString("c_adata","C",8,0);
    w_cdadata = m_Caller.GetString("cdadata","C",8,0);
    w_chkcfis = m_Caller.GetString("chkcfis","C",1,0);
    w_noninvio = m_Caller.GetString("noninvio","C",1,0);
    w_codmage = m_Caller.GetString("codmage","C",5,0);
    w_fisccod = m_Caller.GetString("fisccod","C",16,0);
    w_statonas = m_Caller.GetString("statonas","C",40,0);
    w_tipoerr = m_Caller.GetString("tipoerr","C",1,0);
    _motivo = "";
    _codrap = CPLib.Space(25);
    _codper = CPLib.Space(16);
    _datnas = CPLib.NullDate();
    _provnas = CPLib.Space(2);
    _comnas = CPLib.Space(40);
    _naznas = CPLib.Space(40);
    _mesnas = CPLib.Space(2);
    _gionas = CPLib.Space(2);
    _annnas = CPLib.Space(4);
    _sesso = CPLib.Space(1);
    _codfisc = CPLib.Space(16);
    _cmesi = CPLib.Space(12);
    _pos = 0;
    _motivo2 = "";
    _chkcf = CPLib.Space(16);
    _chkstato = CPLib.Space(30);
    _chknet = CPLib.Space(5);
    _report = null;
    bReport = false;
    filename = CPLib.Space(128);
    filepath = CPLib.Space(128);
    _conta = 0;
    _max = 0;
    _min = 0;
    _tot = 0;
    _cicli = 0;
    _bottom = 0;
    _top = 0;
    _reccount = 0;
    w_CODFISC = CPLib.Space(16);
    w_DATANASC = CPLib.NullDate();
    w_NASCOMUN = CPLib.Space(30);
    w_NASSTATO = CPLib.Space(30);
    w_COGNOME = CPLib.Space(26);
    w_RAGSOC = CPLib.Space(70);
    w_NOME = CPLib.Space(25);
    w_SESSO = CPLib.Space(1);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_stpverage_do_wu_count,qbe_chkopex_wu_1_minmax,qbe_chkopex_wu_1,qbe_chkopex_wu_2_minmax,qbe_chkopex_wu_2,
  public static final String m_cVQRList = ",qbe_stpverage_do_wu_count,qbe_chkopex_wu_1_minmax,qbe_chkopex_wu_1,qbe_chkopex_wu_2_minmax,qbe_chkopex_wu_2,";
  // ENTITY_BATCHES: ,arfn_chkcodfis,arfn_fdate,arrt_calccodfis,
  public static final String i_InvokedRoutines = ",arfn_chkcodfis,arfn_fdate,arrt_calccodfis,";
  public static String[] m_cRunParameterNames={"pTipo"};
  protected static String GetFieldsName_0000004A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000004C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000096(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000099(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000AB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000DB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000114(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000117(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000129(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000132(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000175(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000181(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000019E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMRAP,";
    p_cSql = p_cSql+"TIPOERR,";
    p_cSql = p_cSql+"MOTIVO,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpverage_do",true);
    return p_cSql;
  }
}
