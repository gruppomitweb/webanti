// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_discouicR implements CallerWithObjs {
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
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tmp_invio;
  public String m_cServer_tmp_invio;
  public String m_cPhName_tmp_dischebo;
  public String m_cServer_tmp_dischebo;
  public String m_cPhName_tmp_settorbo;
  public String m_cServer_tmp_settorbo;
  public String m_cPhName_filedatiuic;
  public String m_cServer_filedatiuic;
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
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public String w_tipocr;
  public String w_codcr;
  public java.sql.Date w_datinv;
  public double w_numinv;
  public String gPathApp;
  public String gPathDoc;
  public String gTipInter;
  public String gIntemediario;
  public String gAzienda;
  public String _tipcentro;
  public String _codcentro;
  public String _settsint;
  public double _appconta;
  public double _totconta;
  public double _conta;
  public String _codcab;
  public String _provin;
  public String _paese;
  public String _testo;
  public String _file;
  public String cdadata;
  public String c_adata;
  public java.sql.Date w_dadata;
  public java.sql.Date w_adata;
  public String _mesi;
  public String _mese;
  public String _codcab2;
  public String _provin2;
  public String _perpaese;
  public String _percab;
  public String _perprov;
  public String cNomeFile;
  public String cOnlyNomeFile;
  public String cNomeFileZip;
  public String cProg;
  public String fhand;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_discouicR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_discouic",m_Caller);
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_invio")) {
      m_cPhName_tmp_invio = p_ContextObject.GetPhName("tmp_invio");
      if (m_cPhName_tmp_invio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_invio = m_cPhName_tmp_invio+" "+m_Ctx.GetWritePhName("tmp_invio");
      }
      m_cServer_tmp_invio = p_ContextObject.GetServer("tmp_invio");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_dischebo")) {
      m_cPhName_tmp_dischebo = p_ContextObject.GetPhName("tmp_dischebo");
      if (m_cPhName_tmp_dischebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_dischebo = m_cPhName_tmp_dischebo+" "+m_Ctx.GetWritePhName("tmp_dischebo");
      }
      m_cServer_tmp_dischebo = p_ContextObject.GetServer("tmp_dischebo");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_settorbo")) {
      m_cPhName_tmp_settorbo = p_ContextObject.GetPhName("tmp_settorbo");
      if (m_cPhName_tmp_settorbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_settorbo = m_cPhName_tmp_settorbo+" "+m_Ctx.GetWritePhName("tmp_settorbo");
      }
      m_cServer_tmp_settorbo = p_ContextObject.GetServer("tmp_settorbo");
    }
    m_cPhName_filedatiuic = p_ContextObject.GetPhName("filedatiuic");
    if (m_cPhName_filedatiuic.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_filedatiuic = m_cPhName_filedatiuic+" "+m_Ctx.GetWritePhName("filedatiuic");
    }
    m_cServer_filedatiuic = p_ContextObject.GetServer("filedatiuic");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("numinv",p_cVarName)) {
      return w_numinv;
    }
    if (CPLib.eqr("_appconta",p_cVarName)) {
      return _appconta;
    }
    if (CPLib.eqr("_totconta",p_cVarName)) {
      return _totconta;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_discouic";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("tipocr",p_cVarName)) {
      return w_tipocr;
    }
    if (CPLib.eqr("codcr",p_cVarName)) {
      return w_codcr;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      return gTipInter;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("_tipcentro",p_cVarName)) {
      return _tipcentro;
    }
    if (CPLib.eqr("_codcentro",p_cVarName)) {
      return _codcentro;
    }
    if (CPLib.eqr("_settsint",p_cVarName)) {
      return _settsint;
    }
    if (CPLib.eqr("_codcab",p_cVarName)) {
      return _codcab;
    }
    if (CPLib.eqr("_provin",p_cVarName)) {
      return _provin;
    }
    if (CPLib.eqr("_paese",p_cVarName)) {
      return _paese;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      return _testo;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      return _file;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      return cdadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return c_adata;
    }
    if (CPLib.eqr("_mesi",p_cVarName)) {
      return _mesi;
    }
    if (CPLib.eqr("_mese",p_cVarName)) {
      return _mese;
    }
    if (CPLib.eqr("_codcab2",p_cVarName)) {
      return _codcab2;
    }
    if (CPLib.eqr("_provin2",p_cVarName)) {
      return _provin2;
    }
    if (CPLib.eqr("_perpaese",p_cVarName)) {
      return _perpaese;
    }
    if (CPLib.eqr("_percab",p_cVarName)) {
      return _percab;
    }
    if (CPLib.eqr("_perprov",p_cVarName)) {
      return _perprov;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      return cNomeFile;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      return cOnlyNomeFile;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
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
    if (CPLib.eqr("datinv",p_cVarName)) {
      return w_datinv;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
    }
    if (CPLib.eqr("adata",p_cVarName)) {
      return w_adata;
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
    if (CPLib.eqr("numinv",p_cVarName)) {
      w_numinv = value;
      return;
    }
    if (CPLib.eqr("_appconta",p_cVarName)) {
      _appconta = value;
      return;
    }
    if (CPLib.eqr("_totconta",p_cVarName)) {
      _totconta = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipocr",p_cVarName)) {
      w_tipocr = value;
      return;
    }
    if (CPLib.eqr("codcr",p_cVarName)) {
      w_codcr = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      gTipInter = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("_tipcentro",p_cVarName)) {
      _tipcentro = value;
      return;
    }
    if (CPLib.eqr("_codcentro",p_cVarName)) {
      _codcentro = value;
      return;
    }
    if (CPLib.eqr("_settsint",p_cVarName)) {
      _settsint = value;
      return;
    }
    if (CPLib.eqr("_codcab",p_cVarName)) {
      _codcab = value;
      return;
    }
    if (CPLib.eqr("_provin",p_cVarName)) {
      _provin = value;
      return;
    }
    if (CPLib.eqr("_paese",p_cVarName)) {
      _paese = value;
      return;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      _testo = value;
      return;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      _file = value;
      return;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      cdadata = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      c_adata = value;
      return;
    }
    if (CPLib.eqr("_mesi",p_cVarName)) {
      _mesi = value;
      return;
    }
    if (CPLib.eqr("_mese",p_cVarName)) {
      _mese = value;
      return;
    }
    if (CPLib.eqr("_codcab2",p_cVarName)) {
      _codcab2 = value;
      return;
    }
    if (CPLib.eqr("_provin2",p_cVarName)) {
      _provin2 = value;
      return;
    }
    if (CPLib.eqr("_perpaese",p_cVarName)) {
      _perpaese = value;
      return;
    }
    if (CPLib.eqr("_percab",p_cVarName)) {
      _percab = value;
      return;
    }
    if (CPLib.eqr("_perprov",p_cVarName)) {
      _perprov = value;
      return;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      cNomeFile = value;
      return;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      cOnlyNomeFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
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
    if (CPLib.eqr("datinv",p_cVarName)) {
      w_datinv = value;
      return;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
    if (CPLib.eqr("adata",p_cVarName)) {
      w_adata = value;
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
    /* w_DaDatOpe Date */
    /* w_ADatOpe Date */
    /* w_tipocr Char(2) */
    /* w_codcr Char(11) */
    /* w_datinv Date */
    /* w_numinv Numeric(10, 0) */
    /* Variabili Globali */
    /* gPathApp Char(80) // Path Applicazione */
    /* gPathDoc Char(128) // Path Applicazione */
    /* gTipInter Char(2) // Tipo Intermediario */
    /* gIntemediario Char(11) // Intermediario */
    /* gAzienda Char(10) // Azienda */
    /* _tipcentro Char(2) */
    /* _codcentro Char(11) */
    /* _settsint Char(3) */
    /* _appconta Numeric(10, 0) */
    /* _totconta Numeric(10, 0) */
    /* _conta Numeric(10, 0) */
    /* _codcab Char(6) */
    /* _provin Char(2) */
    /* _paese Char(3) */
    /* _testo Memo */
    /* _file Char(20) */
    /* cdadata Char(8) */
    /* c_adata Char(8) */
    /* w_dadata Date */
    /* w_adata Date */
    /* _mesi Char(12) */
    /* _mese Char(1) */
    /* _codcab2 Char(6) */
    /* _provin2 Char(2) */
    /* _perpaese Char(3) */
    /* _percab Char(6) */
    /* _perprov Char(2) */
    /* cNomeFile Char(30) */
    /* cOnlyNomeFile Char(30) */
    /* cNomeFileZip Char(30) */
    /* cProg Char(10) */
    /* fhand Char(10) */
    /* Assegna valore a variabili */
    /* w_dadata := w_DaDatOpe */
    w_dadata = w_DaDatOpe;
    /* w_adata := w_ADatOpe */
    w_adata = w_ADatOpe;
    /* cdadata := DateToChar(w_DaDatOpe) */
    cdadata = CPLib.DateToChar(w_DaDatOpe);
    /* c_adata := DateToChar(w_ADatOpe) */
    c_adata = CPLib.DateToChar(w_ADatOpe);
    /* _tipcentro := iif(Empty(w_tipocr),gTipInter,w_tipocr) */
    _tipcentro = (CPLib.Empty(w_tipocr)?gTipInter:w_tipocr);
    /* _codcentro := iif(Empty(w_codcr),gIntemediario,w_codcr) */
    _codcentro = (CPLib.Empty(w_codcr)?gIntemediario:w_codcr);
    // * --- Drop temporary table tmp_dischebo
    if (m_Ctx.IsSharedTemp("tmp_dischebo")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_dischebo")) {
        m_cServer = m_Ctx.GetServer("tmp_dischebo");
        m_cPhName = m_Ctx.GetPhName("tmp_dischebo");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_dischebo");
    }
    // * --- Create temporary table tmp_dischebo
    if (m_Ctx.IsSharedTemp("tmp_dischebo")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_dischebo")) {
        m_cServer = m_Ctx.GetServer("tmp_dischebo");
        m_cPhName = m_Ctx.GetPhName("tmp_dischebo");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_dischebo");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_dischebo");
    if ( ! (m_Ctx.IsSharedTemp("tmp_dischebo"))) {
      m_cServer = m_Ctx.GetServer("tmp_dischebo");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_dischebo",m_cServer,"proto")),m_cPhName,"tmp_dischebo",m_Ctx);
    }
    m_cPhName_tmp_dischebo = m_cPhName;
    // * --- Drop temporary table tmp_invio
    if (m_Ctx.IsSharedTemp("tmp_invio")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_invio")) {
        m_cServer = m_Ctx.GetServer("tmp_invio");
        m_cPhName = m_Ctx.GetPhName("tmp_invio");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_invio");
    }
    // * --- Create temporary table tmp_invio
    if (m_Ctx.IsSharedTemp("tmp_invio")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_invio")) {
        m_cServer = m_Ctx.GetServer("tmp_invio");
        m_cPhName = m_Ctx.GetPhName("tmp_invio");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_invio");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_invio");
    if ( ! (m_Ctx.IsSharedTemp("tmp_invio"))) {
      m_cServer = m_Ctx.GetServer("tmp_invio");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_invio",m_cServer,"proto")),m_cPhName,"tmp_invio",m_Ctx);
    }
    m_cPhName_tmp_invio = m_cPhName;
    // * --- Drop temporary table tmp_settorbo
    if (m_Ctx.IsSharedTemp("tmp_settorbo")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_settorbo")) {
        m_cServer = m_Ctx.GetServer("tmp_settorbo");
        m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_settorbo");
    }
    // * --- Create temporary table tmp_settorbo
    if (m_Ctx.IsSharedTemp("tmp_settorbo")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_settorbo")) {
        m_cServer = m_Ctx.GetServer("tmp_settorbo");
        m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_settorbo");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_settorbo");
    if ( ! (m_Ctx.IsSharedTemp("tmp_settorbo"))) {
      m_cServer = m_Ctx.GetServer("tmp_settorbo");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_settorbo",m_cServer,"proto")),m_cPhName,"tmp_settorbo",m_Ctx,new String[]{"SETTSINT"});
    }
    m_cPhName_tmp_settorbo = m_cPhName;
    /* Verifica le operazioni da trasportare */
    /* Exec "Operazioni" Page 2:Page_2 */
    Page_2();
    /* Exec "Frazionate" Page 3:Page_3 */
    Page_3();
    /* Exec "Creazione File per invio" Page 4:Page_4 */
    Page_4();
    /* Invia il file */
    /* _mesi := "ABCDEFGHIJKL" */
    _mesi = "ABCDEFGHIJKL";
    /* _mese := Substr(_mesi,Month(w_DaDatOpe),1) */
    _mese = CPLib.Substr(_mesi,CPLib.Month(w_DaDatOpe),1);
    /* _file := iif(w_numinv > 1,"R","A")+Substr(DateToChar(w_DaDatOpe),4,1)+_mese+"00000.ARI" */
    _file = (CPLib.gt(w_numinv,1)?"R":"A")+CPLib.Substr(CPLib.DateToChar(w_DaDatOpe),4,1)+_mese+"00000.ARI";
    /* cNomeFile := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_file) */
    cNomeFile = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_file);
    /* cOnlyNomeFile := _file */
    cOnlyNomeFile = _file;
    /* cNomeFileZip := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_file)+"_"+Right('00000'+LRTrim(Str(w_numinv,5,0)),5)+".zip" */
    cNomeFileZip = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_file)+"_"+CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(w_numinv,5,0)),5)+".zip";
    /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_file)) */
    fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_file));
    /* FileLibMit.Write(fhand,_testo) */
    FileLibMit.Write(fhand,_testo);
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* cProg := Utilities.GetAutonumber("PRGFILEUIC\'"+LRTrim(gAzienda)+"'",'',10) */
    cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILEUIC\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
    // * --- Insert into filedatiuic from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("filedatiuic");
    m_cPhName = m_Ctx.GetPhName("filedatiuic");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"filedatiuic",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic",76,"00000047")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
    m_cSql = m_cSql+GetFieldsName_00000047(m_Ctx,m_oWrInfo);
    m_cSql = m_cSql+") values (";
    m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_file)+"_"+CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(w_numinv,5,0)),5)+".zip","?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL("Dati Aggregati relativi al periodo: "+arfn_fdateR.Make(m_Ctx,this).Run(w_DaDatOpe)+" - "+arfn_fdateR.Make(m_Ctx,this).Run(w_ADatOpe)+" - Invio N. "+CPLib.LRTrim(CPLib.Str(w_numinv,3,0)),"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+m_oWrInfo.InsertValues();
    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"filedatiuic",true);
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
    /* Exec "Crea file zip" Page 5:Page_5 */
    Page_5();
    /* FileLibMit.DeleteFile(cNomeFile) */
    FileLibMit.DeleteFile(cNomeFile);
    /* Stop arpg_filesuic */
    Forward f;
    f=new Forward("arpg_filesuic",false,this,Forward.Start,false);
    f.SetParameter("m_cParameterSequence", "");
    f.SetParameter("m_cMode","hyperlink");
    throw f;
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_opeuif=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_tmp_settorbo=null;
    CPResultSet Cursor_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla su operazbo e seleziona i record nel range definito */
      // * --- Select from qbe_opeuif
      if (Cursor_qbe_opeuif!=null)
        Cursor_qbe_opeuif.Close();
      Cursor_qbe_opeuif = new VQRHolder("qbe_opeuif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_opeuif.Eof())) {
        // * --- Drop temporary table tmp_settorbo
        if (m_Ctx.IsSharedTemp("tmp_settorbo")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_settorbo")) {
            m_cServer = m_Ctx.GetServer("tmp_settorbo");
            m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_settorbo");
        }
        // * --- Create temporary table tmp_settorbo
        if (m_Ctx.IsSharedTemp("tmp_settorbo")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_settorbo")) {
            m_cServer = m_Ctx.GetServer("tmp_settorbo");
            m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_settorbo");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_settorbo");
        if ( ! (m_Ctx.IsSharedTemp("tmp_settorbo"))) {
          m_cServer = m_Ctx.GetServer("tmp_settorbo");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_settorbo",m_cServer,"proto")),m_cPhName,"tmp_settorbo",m_Ctx,new String[]{"SETTSINT"});
        }
        m_cPhName_tmp_settorbo = m_cPhName;
        /* If qbe_opeuif->CODVOC <> '76' and qbe_opeuif->CODVOC <> '77'  */
        if (CPLib.ne(Cursor_qbe_opeuif.GetString("CODVOC"),"76") && CPLib.ne(Cursor_qbe_opeuif.GetString("CODVOC"),"77")) {
          /* If not(Empty(qbe_opeuif->RAPPORTO)) */
          if ( ! (CPLib.Empty(Cursor_qbe_opeuif.GetString("RAPPORTO")))) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If intestbo->DATAINI <= qbe_opeuif->DATAOPE and (Empty(intestbo->DATAFINE) or intestbo->DATAFINE >= qbe_opeuif->DATAOPE) and intestbo->TIPOPERS='P' */
              if (CPLib.le(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_opeuif.GetDate("DATAOPE")) && (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")) || CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_opeuif.GetDate("DATAOPE"))) && CPLib.eqr(Cursor_intestbo.GetString("TIPOPERS"),"P")) {
                /* _settsint := '' */
                _settsint = "";
                // * --- Read from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_cSql = "";
                m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"));
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SETTSINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _settsint = Read_Cursor.GetString("SETTSINT");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine arrt_discouic returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _settsint = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _appconta := 0 */
                _appconta = CPLib.Round(0,0);
                // * --- Read from tmp_settorbo
                m_cServer = m_Ctx.GetServer("tmp_settorbo");
                m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
                m_cSql = "";
                m_cSql = m_cSql+"SETTSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_settsint,"C",3,0,m_cServer),m_cServer,_settsint);
                if (m_Ctx.IsSharedTemp("tmp_settorbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _appconta = CPLib.Round(Read_Cursor.GetDouble("CONTA"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tmp_settorbo into routine arrt_discouic returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _appconta = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If _appconta = 0 */
                if (CPLib.eqr(_appconta,0)) {
                  // * --- Insert into tmp_settorbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_settorbo");
                  m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_settorbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic",76,"00000058")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000058(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_settorbo",true);
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
                } else { // Else
                  // * --- Write into tmp_settorbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_settorbo");
                  m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_settorbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic",76,"00000059")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CONTA = CONTA+("+CPLib.ToSQL(1,"N",10,0)+"), ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_settorbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"SETTSINT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_settsint,"?",0,0,m_cServer),m_cServer,_settsint)+"";
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
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } else { // Else
            /* _settsint := '' */
            _settsint = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESCLI"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_opeuif.GetString("CONNESCLI"));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SETTSINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _settsint = Read_Cursor.GetString("SETTSINT");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_discouic returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _settsint = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _settsint := iif(Empty(_settsint),'999',_settsint) */
            _settsint = (CPLib.Empty(_settsint)?"999":_settsint);
            /* _appconta := 0 */
            _appconta = CPLib.Round(0,0);
            // * --- Read from tmp_settorbo
            m_cServer = m_Ctx.GetServer("tmp_settorbo");
            m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
            m_cSql = "";
            m_cSql = m_cSql+"SETTSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_settsint,"C",3,0,m_cServer),m_cServer,_settsint);
            if (m_Ctx.IsSharedTemp("tmp_settorbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _appconta = CPLib.Round(Read_Cursor.GetDouble("CONTA"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tmp_settorbo into routine arrt_discouic returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _appconta = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If _appconta = 0 */
            if (CPLib.eqr(_appconta,0)) {
              // * --- Insert into tmp_settorbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_settorbo");
              m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_settorbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic",76,"00000060")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000060(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_settorbo",true);
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
            } else { // Else
              // * --- Write into tmp_settorbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_settorbo");
              m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_settorbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic",76,"00000061")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CONTA = CONTA+("+CPLib.ToSQL(1,"N",10,0)+"), ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_settorbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"SETTSINT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_settsint,"?",0,0,m_cServer),m_cServer,_settsint)+"";
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
          /* Conta il numero di record */
          /* _totconta := 0 */
          _totconta = CPLib.Round(0,0);
          // * --- Select from tmp_settorbo
          m_cServer = m_Ctx.GetServer("tmp_settorbo");
          m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
          if (Cursor_tmp_settorbo!=null)
            Cursor_tmp_settorbo.Close();
          Cursor_tmp_settorbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONTA  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_settorbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_settorbo.Eof())) {
            /* _totconta := _totconta + tmp_settorbo->CONTA */
            _totconta = CPLib.Round(_totconta+Cursor_tmp_settorbo.GetDouble("CONTA"),0);
            Cursor_tmp_settorbo.Next();
          }
          m_cConnectivityError = Cursor_tmp_settorbo.ErrorMessage();
          Cursor_tmp_settorbo.Close();
          // * --- End Select
          /* Inserisce i record nel file appoggio INVIO */
          // * --- Select from tmp_settorbo
          m_cServer = m_Ctx.GetServer("tmp_settorbo");
          m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
          if (Cursor_tmp_settorbo!=null)
            Cursor_tmp_settorbo.Close();
          Cursor_tmp_settorbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_settorbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_settorbo.Eof())) {
            /* _appconta := tmp_settorbo->CONTA */
            _appconta = CPLib.Round(Cursor_tmp_settorbo.GetDouble("CONTA"),0);
            /* _conta := 1 */
            _conta = CPLib.Round(1,0);
            /* While _conta <= _appconta */
            while (CPLib.le(_conta,_appconta)) {
              /* _paese := '' */
              _paese = "";
              /* _codcab := '' */
              _codcab = "";
              /* _provin := '' */
              _provin = "";
              /* _perpaese := '' */
              _perpaese = "";
              /* _percab := '' */
              _percab = "";
              /* _perprov := '' */
              _perprov = "";
              /* If qbe_opeuif->CODVOC='16' or qbe_opeuif->CODVOC='17' or qbe_opeuif->CODVOC='30' or qbe_opeuif->CODVOC='35'  or qbe_opeuif->CODVOC='1B' or qbe_opeuif->CODVOC='2B' or qbe_opeuif->CODVOC='3B' or qbe_opeuif->CODVOC='4B' or qbe_opeuif->CODVOC='5B' or qbe_opeuif->CODVOC='6B' or qbe_opeuif->CODVOC='3M' or qbe_opeuif->CODVOC='4M' or qbe_opeuif->CODVOC='5M' or qbe_opeuif->CODVOC='6M' */
              if (CPLib.eqr(Cursor_qbe_opeuif.GetString("CODVOC"),"16") || CPLib.eqr(Cursor_qbe_opeuif.GetString("CODVOC"),"17") || CPLib.eqr(Cursor_qbe_opeuif.GetString("CODVOC"),"30") || CPLib.eqr(Cursor_qbe_opeuif.GetString("CODVOC"),"35") || CPLib.eqr(Cursor_qbe_opeuif.GetString("CODVOC"),"1B") || CPLib.eqr(Cursor_qbe_opeuif.GetString("CODVOC"),"2B") || CPLib.eqr(Cursor_qbe_opeuif.GetString("CODVOC"),"3B") || CPLib.eqr(Cursor_qbe_opeuif.GetString("CODVOC"),"4B") || CPLib.eqr(Cursor_qbe_opeuif.GetString("CODVOC"),"5B") || CPLib.eqr(Cursor_qbe_opeuif.GetString("CODVOC"),"6B") || CPLib.eqr(Cursor_qbe_opeuif.GetString("CODVOC"),"3M") || CPLib.eqr(Cursor_qbe_opeuif.GetString("CODVOC"),"4M") || CPLib.eqr(Cursor_qbe_opeuif.GetString("CODVOC"),"5M") || CPLib.eqr(Cursor_qbe_opeuif.GetString("CODVOC"),"6M")) {
                /* _paese := qbe_opeuif->PAESE */
                _paese = Cursor_qbe_opeuif.GetString("PAESE");
                /* If _paese='086' */
                if (CPLib.eqr(_paese,"086")) {
                  /* _codcab := qbe_opeuif->CODCAB2 */
                  _codcab = Cursor_qbe_opeuif.GetString("CODCAB2");
                  /* _provin := qbe_opeuif->PROV2 */
                  _provin = Cursor_qbe_opeuif.GetString("PROV2");
                } // End If
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _perpaese := personbo->PAESE */
                  _perpaese = Cursor_personbo.GetString("PAESE");
                  /* If _perpaese='086' */
                  if (CPLib.eqr(_perpaese,"086")) {
                    /* _percab := iif(not(Empty(personbo->CODCAB)),personbo->CODCAB,qbe_opeuif->CODCAB2) */
                    _percab = ( ! (CPLib.Empty(Cursor_personbo.GetString("CODCAB")))?Cursor_personbo.GetString("CODCAB"):Cursor_qbe_opeuif.GetString("CODCAB2"));
                    /* _perprov := iif(not(Empty(personbo->CODCAB)),personbo->PROVINCIA,qbe_opeuif->PROV2) */
                    _perprov = ( ! (CPLib.Empty(Cursor_personbo.GetString("CODCAB")))?Cursor_personbo.GetString("PROVINCIA"):Cursor_qbe_opeuif.GetString("PROV2"));
                  } // End If
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              // * --- Insert into tmp_dischebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_dischebo");
              m_cPhName = m_Ctx.GetPhName("tmp_dischebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_dischebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic",76,"0000007B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000007B(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_settorbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("TOTLIRE")/_totconta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("TOTCONT")/_totconta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1/_totconta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.gt(Cursor_qbe_opeuif.GetDouble("TOTCONT"),0)?1/_totconta:0),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_perpaese,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_percab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_perprov,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paese,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codcab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_provin,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_dischebo",true);
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
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
            } // End While
            Cursor_tmp_settorbo.Next();
          }
          m_cConnectivityError = Cursor_tmp_settorbo.ErrorMessage();
          Cursor_tmp_settorbo.Close();
          // * --- End Select
        } else { // Else
          // * --- Insert into tmp_dischebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_dischebo");
          m_cPhName = m_Ctx.GetPhName("tmp_dischebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_dischebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic",76,"0000007D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000007D(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(6),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(6),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.gt(Cursor_qbe_opeuif.GetDouble("TOTCONT"),0)?1:0),"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_dischebo",true);
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
        Cursor_qbe_opeuif.Next();
      }
      m_cConnectivityError = Cursor_qbe_opeuif.ErrorMessage();
      Cursor_qbe_opeuif.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_opeuif!=null)
          Cursor_qbe_opeuif.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
        if (Cursor_tmp_settorbo!=null)
          Cursor_tmp_settorbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_frauif=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_tmp_settorbo=null;
    CPResultSet Cursor_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla su fraziobo e seleziona i record nel range definito */
      // * --- Select from qbe_frauif
      if (Cursor_qbe_frauif!=null)
        Cursor_qbe_frauif.Close();
      Cursor_qbe_frauif = new VQRHolder("qbe_frauif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_frauif.Eof())) {
        // * --- Drop temporary table tmp_settorbo
        if (m_Ctx.IsSharedTemp("tmp_settorbo")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_settorbo")) {
            m_cServer = m_Ctx.GetServer("tmp_settorbo");
            m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_settorbo");
        }
        // * --- Create temporary table tmp_settorbo
        if (m_Ctx.IsSharedTemp("tmp_settorbo")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_settorbo")) {
            m_cServer = m_Ctx.GetServer("tmp_settorbo");
            m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_settorbo");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_settorbo");
        if ( ! (m_Ctx.IsSharedTemp("tmp_settorbo"))) {
          m_cServer = m_Ctx.GetServer("tmp_settorbo");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_settorbo",m_cServer,"proto")),m_cPhName,"tmp_settorbo",m_Ctx,new String[]{"SETTSINT"});
        }
        m_cPhName_tmp_settorbo = m_cPhName;
        /* If qbe_frauif->CODVOC <> '76' and qbe_frauif->CODVOC <> '77'  */
        if (CPLib.ne(Cursor_qbe_frauif.GetString("CODVOC"),"76") && CPLib.ne(Cursor_qbe_frauif.GetString("CODVOC"),"77")) {
          /* If not(Empty(qbe_frauif->RAPPORTO)) */
          if ( ! (CPLib.Empty(Cursor_qbe_frauif.GetString("RAPPORTO")))) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If intestbo->DATAINI <= qbe_frauif->DATAOPE and (Empty(intestbo->DATAFINE) or intestbo->DATAFINE >= qbe_frauif->DATAOPE) and intestbo->TIPOPERS='P' */
              if (CPLib.le(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_frauif.GetDate("DATAOPE")) && (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")) || CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_frauif.GetDate("DATAOPE"))) && CPLib.eqr(Cursor_intestbo.GetString("TIPOPERS"),"P")) {
                /* _settsint := '' */
                _settsint = "";
                // * --- Read from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_cSql = "";
                m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"));
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SETTSINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _settsint = Read_Cursor.GetString("SETTSINT");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine arrt_discouic returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _settsint = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _appconta := 0 */
                _appconta = CPLib.Round(0,0);
                // * --- Read from tmp_settorbo
                m_cServer = m_Ctx.GetServer("tmp_settorbo");
                m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
                m_cSql = "";
                m_cSql = m_cSql+"SETTSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_settsint,"C",3,0,m_cServer),m_cServer,_settsint);
                if (m_Ctx.IsSharedTemp("tmp_settorbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _appconta = CPLib.Round(Read_Cursor.GetDouble("CONTA"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tmp_settorbo into routine arrt_discouic returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _appconta = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If _appconta = 0 */
                if (CPLib.eqr(_appconta,0)) {
                  // * --- Insert into tmp_settorbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_settorbo");
                  m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_settorbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic",76,"0000008B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000008B(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_settorbo",true);
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
                } else { // Else
                  // * --- Write into tmp_settorbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_settorbo");
                  m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_settorbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic",76,"0000008C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CONTA = CONTA+("+CPLib.ToSQL(1,"N",10,0)+"), ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_settorbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"SETTSINT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_settsint,"?",0,0,m_cServer),m_cServer,_settsint)+"";
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
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } else { // Else
            /* _settsint := '' */
            _settsint = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESCLI"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_frauif.GetString("CONNESCLI"));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SETTSINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _settsint = Read_Cursor.GetString("SETTSINT");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_discouic returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _settsint = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _settsint := iif(Empty(_settsint),'999',_settsint) */
            _settsint = (CPLib.Empty(_settsint)?"999":_settsint);
            /* _appconta := 0 */
            _appconta = CPLib.Round(0,0);
            // * --- Read from tmp_settorbo
            m_cServer = m_Ctx.GetServer("tmp_settorbo");
            m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
            m_cSql = "";
            m_cSql = m_cSql+"SETTSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(_settsint,"C",3,0,m_cServer),m_cServer,_settsint);
            if (m_Ctx.IsSharedTemp("tmp_settorbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _appconta = CPLib.Round(Read_Cursor.GetDouble("CONTA"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tmp_settorbo into routine arrt_discouic returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _appconta = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If _appconta = 0 */
            if (CPLib.eqr(_appconta,0)) {
              // * --- Insert into tmp_settorbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_settorbo");
              m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_settorbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic",76,"00000093")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000093(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_settorbo",true);
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
            } else { // Else
              // * --- Write into tmp_settorbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_settorbo");
              m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_settorbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic",76,"00000094")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CONTA = CONTA+("+CPLib.ToSQL(1,"N",10,0)+"), ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_settorbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"SETTSINT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_settsint,"?",0,0,m_cServer),m_cServer,_settsint)+"";
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
          /* Conta il numero di record */
          /* _totconta := 0 */
          _totconta = CPLib.Round(0,0);
          // * --- Select from tmp_settorbo
          m_cServer = m_Ctx.GetServer("tmp_settorbo");
          m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
          if (Cursor_tmp_settorbo!=null)
            Cursor_tmp_settorbo.Close();
          Cursor_tmp_settorbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONTA  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_settorbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_settorbo.Eof())) {
            /* _totconta := _totconta + tmp_settorbo->CONTA */
            _totconta = CPLib.Round(_totconta+Cursor_tmp_settorbo.GetDouble("CONTA"),0);
            Cursor_tmp_settorbo.Next();
          }
          m_cConnectivityError = Cursor_tmp_settorbo.ErrorMessage();
          Cursor_tmp_settorbo.Close();
          // * --- End Select
          /* Inserisce i record nel file appoggio INVIO */
          // * --- Select from tmp_settorbo
          m_cServer = m_Ctx.GetServer("tmp_settorbo");
          m_cPhName = m_Ctx.GetPhName("tmp_settorbo");
          if (Cursor_tmp_settorbo!=null)
            Cursor_tmp_settorbo.Close();
          Cursor_tmp_settorbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_settorbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_settorbo.Eof())) {
            /* _appconta := tmp_settorbo->CONTA */
            _appconta = CPLib.Round(Cursor_tmp_settorbo.GetDouble("CONTA"),0);
            /* _conta := 1 */
            _conta = CPLib.Round(1,0);
            /* While _conta <= _appconta */
            while (CPLib.le(_conta,_appconta)) {
              /* _paese := '' */
              _paese = "";
              /* _codcab := '' */
              _codcab = "";
              /* _provin := '' */
              _provin = "";
              /* _perpaese := '' */
              _perpaese = "";
              /* _percab := '' */
              _percab = "";
              /* _perprov := '' */
              _perprov = "";
              /* If qbe_frauif->CODVOC='16' or qbe_frauif->CODVOC='17' or qbe_frauif->CODVOC='30' or qbe_frauif->CODVOC='35'  or qbe_frauif->CODVOC='1B' or qbe_frauif->CODVOC='2B' or qbe_frauif->CODVOC='3B' or qbe_frauif->CODVOC='4B' or qbe_frauif->CODVOC='5B' or qbe_frauif->CODVOC='6B' or qbe_frauif->CODVOC='3M' or qbe_frauif->CODVOC='4M' or qbe_frauif->CODVOC='5M' or qbe_frauif->CODVOC='6M' */
              if (CPLib.eqr(Cursor_qbe_frauif.GetString("CODVOC"),"16") || CPLib.eqr(Cursor_qbe_frauif.GetString("CODVOC"),"17") || CPLib.eqr(Cursor_qbe_frauif.GetString("CODVOC"),"30") || CPLib.eqr(Cursor_qbe_frauif.GetString("CODVOC"),"35") || CPLib.eqr(Cursor_qbe_frauif.GetString("CODVOC"),"1B") || CPLib.eqr(Cursor_qbe_frauif.GetString("CODVOC"),"2B") || CPLib.eqr(Cursor_qbe_frauif.GetString("CODVOC"),"3B") || CPLib.eqr(Cursor_qbe_frauif.GetString("CODVOC"),"4B") || CPLib.eqr(Cursor_qbe_frauif.GetString("CODVOC"),"5B") || CPLib.eqr(Cursor_qbe_frauif.GetString("CODVOC"),"6B") || CPLib.eqr(Cursor_qbe_frauif.GetString("CODVOC"),"3M") || CPLib.eqr(Cursor_qbe_frauif.GetString("CODVOC"),"4M") || CPLib.eqr(Cursor_qbe_frauif.GetString("CODVOC"),"5M") || CPLib.eqr(Cursor_qbe_frauif.GetString("CODVOC"),"6M")) {
                /* _paese := qbe_frauif->PAESE */
                _paese = Cursor_qbe_frauif.GetString("PAESE");
                /* If _paese='086' */
                if (CPLib.eqr(_paese,"086")) {
                  /* _codcab := qbe_frauif->CODCAB2 */
                  _codcab = Cursor_qbe_frauif.GetString("CODCAB2");
                  /* _provin := qbe_frauif->PROV2 */
                  _provin = Cursor_qbe_frauif.GetString("PROV2");
                } // End If
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _perpaese := personbo->PAESE */
                  _perpaese = Cursor_personbo.GetString("PAESE");
                  /* If _perpaese='086' */
                  if (CPLib.eqr(_perpaese,"086")) {
                    /* _percab := iif(not(Empty(personbo->CODCAB)),personbo->CODCAB,qbe_frauif->CODCAB2) */
                    _percab = ( ! (CPLib.Empty(Cursor_personbo.GetString("CODCAB")))?Cursor_personbo.GetString("CODCAB"):Cursor_qbe_frauif.GetString("CODCAB2"));
                    /* _perprov := iif(not(Empty(personbo->CODCAB)),personbo->PROVINCIA,qbe_frauif->PROV2) */
                    _perprov = ( ! (CPLib.Empty(Cursor_personbo.GetString("CODCAB")))?Cursor_personbo.GetString("PROVINCIA"):Cursor_qbe_frauif.GetString("PROV2"));
                  } // End If
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              // * --- Insert into tmp_dischebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_dischebo");
              m_cPhName = m_Ctx.GetPhName("tmp_dischebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_dischebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic",76,"000000AE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000AE(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_settorbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("TOTLIRE")/_totconta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("TOTCONT")/_totconta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1/_totconta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.gt(Cursor_qbe_frauif.GetDouble("TOTCONT"),0)?1/_totconta:0),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_perpaese,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_percab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_perprov,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paese,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codcab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_provin,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_dischebo",true);
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
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
            } // End While
            Cursor_tmp_settorbo.Next();
          }
          m_cConnectivityError = Cursor_tmp_settorbo.ErrorMessage();
          Cursor_tmp_settorbo.Close();
          // * --- End Select
        } else { // Else
          // * --- Insert into tmp_dischebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_dischebo");
          m_cPhName = m_Ctx.GetPhName("tmp_dischebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_dischebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic",76,"000000B0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000B0(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(6),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(6),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.gt(Cursor_qbe_frauif.GetDouble("TOTCONT"),0)?1:0),"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_dischebo",true);
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
        Cursor_qbe_frauif.Next();
      }
      m_cConnectivityError = Cursor_qbe_frauif.ErrorMessage();
      Cursor_qbe_frauif.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_frauif!=null)
          Cursor_qbe_frauif.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
        if (Cursor_tmp_settorbo!=null)
          Cursor_tmp_settorbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_tmp_dischebo=null;
    CPResultSet Cursor_tmp_invio=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Crea il file per l'invio */
      // * --- Drop temporary table tmp_invio
      if (m_Ctx.IsSharedTemp("tmp_invio")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_invio")) {
          m_cServer = m_Ctx.GetServer("tmp_invio");
          m_cPhName = m_Ctx.GetPhName("tmp_invio");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_invio");
      }
      // * --- Create temporary table tmp_invio
      if (m_Ctx.IsSharedTemp("tmp_invio")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_invio")) {
          m_cServer = m_Ctx.GetServer("tmp_invio");
          m_cPhName = m_Ctx.GetPhName("tmp_invio");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_invio");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_invio");
      if ( ! (m_Ctx.IsSharedTemp("tmp_invio"))) {
        m_cServer = m_Ctx.GetServer("tmp_invio");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_invio",m_cServer,"proto")),m_cPhName,"tmp_invio",m_Ctx);
      }
      m_cPhName_tmp_invio = m_cPhName;
      // * --- Select from qbe_tmp_dischebo
      if (Cursor_qbe_tmp_dischebo!=null)
        Cursor_qbe_tmp_dischebo.Close();
      Cursor_qbe_tmp_dischebo = new VQRHolder("qbe_tmp_dischebo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tmp_dischebo.Eof())) {
        // * --- Insert into tmp_invio from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_invio");
        m_cPhName = m_Ctx.GetPhName("tmp_invio");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_invio",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic",76,"000000B5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000000B5(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetString("PERPAESE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetString("PERCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetString("PERPROV"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetDouble("TOTCONT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetDouble("OPERAZIONI"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tmp_dischebo.GetDouble("CONTANTI"),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_invio",true);
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
        Cursor_qbe_tmp_dischebo.Next();
      }
      m_cConnectivityError = Cursor_qbe_tmp_dischebo.ErrorMessage();
      Cursor_qbe_tmp_dischebo.Close();
      // * --- End Select
      /* Crea il Record di testa */
      /* _testo := "01" + gTipInter + gIntemediario + DateToChar(w_ADatOpe) + "X" + Right('00'+LRTrim(Str(w_numinv,2,0)),2) */
      _testo = "01"+gTipInter+gIntemediario+CPLib.DateToChar(w_ADatOpe)+"X"+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(w_numinv,2,0)),2);
      /* _testo := _testo + DateToChar(w_datinv) + Space(1) + iif(w_numinv > 1,'S','N') + _tipcentro + _codcentro + "7553" + Space(66) + NL */
      _testo = _testo+CPLib.DateToChar(w_datinv)+CPLib.Space(1)+(CPLib.gt(w_numinv,1)?"S":"N")+_tipcentro+_codcentro+"7553"+CPLib.Space(66)+"\n";
      /* Cicla su INVIO e scrive su DISCEBO */
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      // * --- Select from tmp_invio
      m_cServer = m_Ctx.GetServer("tmp_invio");
      m_cPhName = m_Ctx.GetPhName("tmp_invio");
      if (Cursor_tmp_invio!=null)
        Cursor_tmp_invio.Close();
      Cursor_tmp_invio = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_invio")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_invio.Eof())) {
        /* _testo := _testo + "03" + gTipInter + gIntemediario + DateToChar(w_ADatOpe) + "X" */
        _testo = _testo+"03"+gTipInter+gIntemediario+CPLib.DateToChar(w_ADatOpe)+"X";
        /* _testo := _testo + Right("0000000"+LRTrim(Str(_conta,7,0)),7) + Left(LRTrim(tmp_invio->CODCAB)+Space(6),6) + Left(LRTrim(tmp_invio->PROVINCIA)+Space(2),2) + Left(LRTrim(tmp_invio->CODVOC)+Space(2),2) */
        _testo = _testo+CPLib.Right("0000000"+CPLib.LRTrim(CPLib.Str(_conta,7,0)),7)+CPLib.Left(CPLib.LRTrim(Cursor_tmp_invio.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_tmp_invio.GetString("PROVINCIA"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_tmp_invio.GetString("CODVOC"))+CPLib.Space(2),2);
        /* _testo := _testo + Left(LRTrim(tmp_invio->FLAGLIRE)+Space(1),1) + Left(LRTrim(tmp_invio->SEGNO)+Space(1) ,1)+ Left(LRTrim(tmp_invio->SETTSINT)+Space(3),3) + Left(LRTrim(tmp_invio->PERPAESE)+Space(3),3) */
        _testo = _testo+CPLib.Left(CPLib.LRTrim(Cursor_tmp_invio.GetString("FLAGLIRE"))+CPLib.Space(1),1)+CPLib.Left(CPLib.LRTrim(Cursor_tmp_invio.GetString("SEGNO"))+CPLib.Space(1),1)+CPLib.Left(CPLib.LRTrim(Cursor_tmp_invio.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_tmp_invio.GetString("PERPAESE"))+CPLib.Space(3),3);
        /* _testo := _testo + Left(LRTrim(tmp_invio->PERCAB)+Space(6),6) + Left(LRTrim(tmp_invio->PERPROV)+Space(2),2) */
        _testo = _testo+CPLib.Left(CPLib.LRTrim(Cursor_tmp_invio.GetString("PERCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_tmp_invio.GetString("PERPROV"))+CPLib.Space(2),2);
        /* _testo := _testo +  Left(LRTrim(tmp_invio->PAESE)+Space(3),3) + Left(LRTrim(tmp_invio->CODCAB2)+Space(6),6) + Left(LRTrim(tmp_invio->PROV2)+Space(2),2) */
        _testo = _testo+CPLib.Left(CPLib.LRTrim(Cursor_tmp_invio.GetString("PAESE"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_tmp_invio.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_tmp_invio.GetString("PROV2"))+CPLib.Space(2),2);
        /* _testo := _testo + Right("000000000000000"+LRTrim(Str(tmp_invio->TOTLIRE/100,15,0)),15) + Right("000000000000000"+LRTrim(Str(tmp_invio->TOTCONT/100,15,0)),15) */
        _testo = _testo+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_tmp_invio.GetDouble("TOTLIRE")/100,15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_tmp_invio.GetDouble("TOTCONT")/100,15,0)),15);
        /* _testo := _testo + Right("000000"+LRTrim(Str(Round(tmp_invio->OPERAZIONI,0),6,0)),6) + Right("00000"+LRTrim(Str(Round(tmp_invio->CONTANTI,0),5,0)),5) */
        _testo = _testo+CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(CPLib.Round(Cursor_tmp_invio.GetDouble("OPERAZIONI"),0),6,0)),6)+CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(CPLib.Round(Cursor_tmp_invio.GetDouble("CONTANTI"),0),5,0)),5);
        /* _testo := _testo + Space(10) + NL */
        _testo = _testo+CPLib.Space(10)+"\n";
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        Cursor_tmp_invio.Next();
      }
      m_cConnectivityError = Cursor_tmp_invio.ErrorMessage();
      Cursor_tmp_invio.Close();
      // * --- End Select
      /* Record di coda */
      /* _testo := _testo + "09" + gTipInter + gIntemediario + DateToChar(w_ADatOpe) + "X" + Right('00'+LRTrim(Str(w_numinv,2,0)),2) */
      _testo = _testo+"09"+gTipInter+gIntemediario+CPLib.DateToChar(w_ADatOpe)+"X"+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(w_numinv,2,0)),2);
      /* _testo := _testo + Right("000000000"+LRTrim(Str(_conta - 1,9,0)),9) + Space(84) */
      _testo = _testo+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_conta-1,9,0)),9)+CPLib.Space(84);
    } finally {
      try {
        if (Cursor_qbe_tmp_dischebo!=null)
          Cursor_qbe_tmp_dischebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_invio!=null)
          Cursor_tmp_invio.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    /* Crea file zip */
    // These are the files to include in the ZIP file
        String[] filenames = new String[]{cNomeFile};
        
        // Create a buffer for reading the files
        byte[] buf = new byte[1024];
        
        try {
            // Create the ZIP file
            String outFilename = cNomeFileZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Compress the files
            for (int i=0; i<filenames.length; i++) {
                java.io.FileInputStream in = new java.io.FileInputStream(filenames[i]);
        
                // Add ZIP entry to output stream.
                out.putNextEntry(new java.util.zip.ZipEntry(cOnlyNomeFile));
        
                // Transfer bytes from the file to the ZIP file
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
        
                // Complete the entry
                out.closeEntry();
                in.close();
            }
        
            // Complete the ZIP file
            out.close();
        } catch (java.io.IOException e) {
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
      m_Caller.SetDate("DaDatOpe","D",8,0,w_DaDatOpe);
      m_Caller.SetDate("ADatOpe","D",8,0,w_ADatOpe);
      m_Caller.SetString("tipocr","C",2,0,w_tipocr);
      m_Caller.SetString("codcr","C",11,0,w_codcr);
      m_Caller.SetDate("datinv","D",8,0,w_datinv);
      m_Caller.SetNumber("numinv","N",10,0,w_numinv);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_discouicR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_discouicR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    w_tipocr = m_Caller.GetString("tipocr","C",2,0);
    w_codcr = m_Caller.GetString("codcr","C",11,0);
    w_datinv = m_Caller.GetDate("datinv","D",8,0);
    w_numinv = m_Caller.GetNumber("numinv","N",10,0);
    _tipcentro = CPLib.Space(2);
    _codcentro = CPLib.Space(11);
    _settsint = CPLib.Space(3);
    _appconta = 0;
    _totconta = 0;
    _conta = 0;
    _codcab = CPLib.Space(6);
    _provin = CPLib.Space(2);
    _paese = CPLib.Space(3);
    _testo = "";
    _file = CPLib.Space(20);
    cdadata = CPLib.Space(8);
    c_adata = CPLib.Space(8);
    w_dadata = CPLib.NullDate();
    w_adata = CPLib.NullDate();
    _mesi = CPLib.Space(12);
    _mese = CPLib.Space(1);
    _codcab2 = CPLib.Space(6);
    _provin2 = CPLib.Space(2);
    _perpaese = CPLib.Space(3);
    _percab = CPLib.Space(6);
    _perprov = CPLib.Space(2);
    cNomeFile = CPLib.Space(30);
    cOnlyNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    cProg = CPLib.Space(10);
    fhand = CPLib.Space(10);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gTipInter=m_Ctx.GetGlobalString("gTipInter");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_opeuif,qbe_frauif,qbe_tmp_dischebo,
  public static final String m_cVQRList = ",qbe_opeuif,qbe_frauif,qbe_tmp_dischebo,";
  // ENTITY_BATCHES: ,arfn_fdate,
  public static final String i_InvokedRoutines = ",arfn_fdate,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000047(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"filedatiuic",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000058(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"CONTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_settorbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000060(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"CONTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_settorbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000007B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"OPERAZIONI,";
    p_cSql = p_cSql+"CONTANTI,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"PERPROV,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_dischebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000007D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"PERPROV,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"OPERAZIONI,";
    p_cSql = p_cSql+"CONTANTI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_dischebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"CONTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_settorbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000093(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"CONTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_settorbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000AE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"OPERAZIONI,";
    p_cSql = p_cSql+"CONTANTI,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"PERPROV,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_dischebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"PERPROV,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"OPERAZIONI,";
    p_cSql = p_cSql+"CONTANTI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_dischebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"PERPROV,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"OPERAZIONI,";
    p_cSql = p_cSql+"CONTANTI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_invio",true);
    return p_cSql;
  }
}
