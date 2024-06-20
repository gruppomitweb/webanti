// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_inviomese_delopeR implements CallerWithObjs {
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
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_appointestbo;
  public String m_cServer_appointestbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_aefiles;
  public String m_cServer_aefiles;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tmp_stovaria;
  public String m_cServer_tmp_stovaria;
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
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
  public java.sql.Date w_a_data;
  public java.sql.Date w_dadata;
  public java.sql.Date w_datprf;
  public java.sql.Date w_datpri;
  public java.sql.Date w_datsecf;
  public java.sql.Date w_datseci;
  public String w_iniz;
  public String w_seco;
  public String _errlog;
  public double imprec;
  public double _noprot;
  public String _rapold;
  public String _tipoco;
  public double _nriga;
  public double _newrow;
  public double _conta;
  public String _idriga;
  public String _prog;
  public String _idbase;
  public double _newope;
  public double _aggope;
  public String _opeagg;
  public double nProgImp;
  public double _bottom;
  public double _top;
  public double _cicli;
  public double _max;
  public double _min;
  public double _cfestero;
  public String _chkcli;
  public double _errate;
  public String _iddelega;
  public String _prgope;
  public String gAzienda;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_inviomese_delopeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_inviomese_delope",m_Caller);
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_appointestbo = p_ContextObject.GetPhName("appointestbo");
    if (m_cPhName_appointestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_appointestbo = m_cPhName_appointestbo+" "+m_Ctx.GetWritePhName("appointestbo");
    }
    m_cServer_appointestbo = p_ContextObject.GetServer("appointestbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_aefiles = p_ContextObject.GetPhName("aefiles");
    if (m_cPhName_aefiles.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefiles = m_cPhName_aefiles+" "+m_Ctx.GetWritePhName("aefiles");
    }
    m_cServer_aefiles = p_ContextObject.GetServer("aefiles");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stovaria")) {
      m_cPhName_tmp_stovaria = p_ContextObject.GetPhName("tmp_stovaria");
      if (m_cPhName_tmp_stovaria.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stovaria = m_cPhName_tmp_stovaria+" "+m_Ctx.GetWritePhName("tmp_stovaria");
      }
      m_cServer_tmp_stovaria = p_ContextObject.GetServer("tmp_stovaria");
    }
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    if (m_cPhName_aeopcanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopcanc = m_cPhName_aeopcanc+" "+m_Ctx.GetWritePhName("aeopcanc");
    }
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("imprec",p_cVarName)) {
      return imprec;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      return _noprot;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      return _nriga;
    }
    if (CPLib.eqr("_newrow",p_cVarName)) {
      return _newrow;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_newope",p_cVarName)) {
      return _newope;
    }
    if (CPLib.eqr("_aggope",p_cVarName)) {
      return _aggope;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_cfestero",p_cVarName)) {
      return _cfestero;
    }
    if (CPLib.eqr("_errate",p_cVarName)) {
      return _errate;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_inviomese_delope";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("iniz",p_cVarName)) {
      return w_iniz;
    }
    if (CPLib.eqr("seco",p_cVarName)) {
      return w_seco;
    }
    if (CPLib.eqr("_errlog",p_cVarName)) {
      return _errlog;
    }
    if (CPLib.eqr("_rapold",p_cVarName)) {
      return _rapold;
    }
    if (CPLib.eqr("_tipoco",p_cVarName)) {
      return _tipoco;
    }
    if (CPLib.eqr("_idriga",p_cVarName)) {
      return _idriga;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      return _prog;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      return _idbase;
    }
    if (CPLib.eqr("_opeagg",p_cVarName)) {
      return _opeagg;
    }
    if (CPLib.eqr("_chkcli",p_cVarName)) {
      return _chkcli;
    }
    if (CPLib.eqr("_iddelega",p_cVarName)) {
      return _iddelega;
    }
    if (CPLib.eqr("_prgope",p_cVarName)) {
      return _prgope;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("a_data",p_cVarName)) {
      return w_a_data;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
    }
    if (CPLib.eqr("datprf",p_cVarName)) {
      return w_datprf;
    }
    if (CPLib.eqr("datpri",p_cVarName)) {
      return w_datpri;
    }
    if (CPLib.eqr("datsecf",p_cVarName)) {
      return w_datsecf;
    }
    if (CPLib.eqr("datseci",p_cVarName)) {
      return w_datseci;
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
    if (CPLib.eqr("imprec",p_cVarName)) {
      imprec = value;
      return;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      _noprot = value;
      return;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      _nriga = value;
      return;
    }
    if (CPLib.eqr("_newrow",p_cVarName)) {
      _newrow = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_newope",p_cVarName)) {
      _newope = value;
      return;
    }
    if (CPLib.eqr("_aggope",p_cVarName)) {
      _aggope = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
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
    if (CPLib.eqr("_cfestero",p_cVarName)) {
      _cfestero = value;
      return;
    }
    if (CPLib.eqr("_errate",p_cVarName)) {
      _errate = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("iniz",p_cVarName)) {
      w_iniz = value;
      return;
    }
    if (CPLib.eqr("seco",p_cVarName)) {
      w_seco = value;
      return;
    }
    if (CPLib.eqr("_errlog",p_cVarName)) {
      _errlog = value;
      return;
    }
    if (CPLib.eqr("_rapold",p_cVarName)) {
      _rapold = value;
      return;
    }
    if (CPLib.eqr("_tipoco",p_cVarName)) {
      _tipoco = value;
      return;
    }
    if (CPLib.eqr("_idriga",p_cVarName)) {
      _idriga = value;
      return;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      _prog = value;
      return;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      _idbase = value;
      return;
    }
    if (CPLib.eqr("_opeagg",p_cVarName)) {
      _opeagg = value;
      return;
    }
    if (CPLib.eqr("_chkcli",p_cVarName)) {
      _chkcli = value;
      return;
    }
    if (CPLib.eqr("_iddelega",p_cVarName)) {
      _iddelega = value;
      return;
    }
    if (CPLib.eqr("_prgope",p_cVarName)) {
      _prgope = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("a_data",p_cVarName)) {
      w_a_data = value;
      return;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
    if (CPLib.eqr("datprf",p_cVarName)) {
      w_datprf = value;
      return;
    }
    if (CPLib.eqr("datpri",p_cVarName)) {
      w_datpri = value;
      return;
    }
    if (CPLib.eqr("datsecf",p_cVarName)) {
      w_datsecf = value;
      return;
    }
    if (CPLib.eqr("datseci",p_cVarName)) {
      w_datseci = value;
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
    /* w_a_data Date */
    /* w_dadata Date */
    /* w_datprf Date */
    /* w_datpri Date */
    /* w_datsecf Date */
    /* w_datseci Date */
    /* w_iniz Char(1) */
    /* w_seco Char(1) */
    /* _errlog Memo */
    /* imprec Numeric(10, 0) */
    /* _noprot Numeric(1, 0) */
    /* _rapold Char(25) */
    /* _tipoco Char(1) */
    /* _nriga Numeric(4, 0) */
    /* _newrow Numeric(4, 0) */
    /* _conta Numeric(10, 0) */
    /* _idriga Char(10) */
    /* _prog Char(10) */
    /* _idbase Char(10) */
    /* _newope Numeric(10, 0) */
    /* _aggope Numeric(10, 0) */
    /* _opeagg Char(1) */
    /* nProgImp Numeric(15, 0) */
    /* _bottom Numeric(15, 0) */
    /* _top Numeric(15, 0) */
    /* _cicli Numeric(15, 0) */
    /* _conta Numeric(15, 0) */
    /* _max Numeric(15, 0) */
    /* _min Numeric(15, 0) */
    /* _cfestero Numeric(1, 0) */
    /* _chkcli Char(16) */
    /* _errate Numeric(10, 0) */
    /* _iddelega Char(10) */
    /* _prgope Char(10) */
    /* gAzienda Char(10) // Azienda */
    /* gMsgImp Char(120) // Messaggio Import */
    // * --- Drop temporary table tmp_stovaria
    if (m_Ctx.IsSharedTemp("tmp_stovaria")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_stovaria")) {
        m_cServer = m_Ctx.GetServer("tmp_stovaria");
        m_cPhName = m_Ctx.GetPhName("tmp_stovaria");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_stovaria");
    }
    // * --- Create temporary table tmp_stovaria
    if (m_Ctx.IsSharedTemp("tmp_stovaria")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_stovaria")) {
        m_cServer = m_Ctx.GetServer("tmp_stovaria");
        m_cPhName = m_Ctx.GetPhName("tmp_stovaria");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_stovaria");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_stovaria");
    if ( ! (m_Ctx.IsSharedTemp("tmp_stovaria"))) {
      m_cServer = m_Ctx.GetServer("tmp_stovaria");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stovaria",m_cServer,"proto")),m_cPhName,"tmp_stovaria",m_Ctx);
    }
    m_cPhName_tmp_stovaria = m_cPhName;
    /* Verifica la casistica */
    /* gMsgImp := "Selezione dati da elaborare ....." // Messaggio Import */
    gMsgImp = "Selezione dati da elaborare .....";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry0000002Estatus;
    nTry0000002Estatus = m_Sql.GetTransactionStatus();
    String cTry0000002Emsg;
    cTry0000002Emsg = m_Sql.TransactionErrorMessage();
    try {
      /* Case w_iniz='S' and w_seco='N' and Empty(w_dadata) and Empty(w_a_data) */
      if (CPLib.eqr(w_iniz,"S") && CPLib.eqr(w_seco,"N") && CPLib.Empty(w_dadata) && CPLib.Empty(w_a_data)) {
        /* w_dadata := w_datpri */
        w_dadata = w_datpri;
        /* w_a_data := w_datprf */
        w_a_data = w_datprf;
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* Exec "Import Dati" Page 2:Page_2 */
        Page_2();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* gMsgImp := 'Sono state importate' + NL + LRTrim(Str(imprec,10,0)) + " informazioni" */
        gMsgImp = "Sono state importate"+"\n"+CPLib.LRTrim(CPLib.Str(imprec,10,0))+" informazioni";
        /* w_dadata := NullDate() */
        w_dadata = CPLib.NullDate();
        /* w_a_data := NullDate() */
        w_a_data = CPLib.NullDate();
        /* Case w_seco='S' and w_iniz='N' and Empty(w_dadata) and Empty(w_a_data) */
      } else if (CPLib.eqr(w_seco,"S") && CPLib.eqr(w_iniz,"N") && CPLib.Empty(w_dadata) && CPLib.Empty(w_a_data)) {
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* w_dadata := w_datseci */
        w_dadata = w_datseci;
        /* w_a_data := w_datsecf */
        w_a_data = w_datsecf;
        /* Exec "Import Dati" Page 2:Page_2 */
        Page_2();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* gMsgImp := 'Sono state importate' + NL + LRTrim(Str(imprec,10,0)) + " informazioni" */
        gMsgImp = "Sono state importate"+"\n"+CPLib.LRTrim(CPLib.Str(imprec,10,0))+" informazioni";
        /* w_dadata := NullDate() */
        w_dadata = CPLib.NullDate();
        /* w_a_data := NullDate() */
        w_a_data = CPLib.NullDate();
        /* Case w_iniz='N' and w_seco='N' and not(Empty(w_dadata)) and not(Empty(w_a_data)) */
      } else if (CPLib.eqr(w_iniz,"N") && CPLib.eqr(w_seco,"N") &&  ! (CPLib.Empty(w_dadata)) &&  ! (CPLib.Empty(w_a_data))) {
        /* Exec "Import Dati" Page 2:Page_2 */
        Page_2();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* gMsgImp := 'Elaborate ' + LRTrim(Str(imprec,10,0)) + " informazioni"+ ' - Aggiornate: '+LRTrim(Str(_aggope,10,0))+ ' - Nuove: '+LRTrim(Str(_newope,10,0))+' - Errate: '+LRTrim(Str(_errate,10,0)) */
        gMsgImp = "Elaborate "+CPLib.LRTrim(CPLib.Str(imprec,10,0))+" informazioni"+" - Aggiornate: "+CPLib.LRTrim(CPLib.Str(_aggope,10,0))+" - Nuove: "+CPLib.LRTrim(CPLib.Str(_newope,10,0))+" - Errate: "+CPLib.LRTrim(CPLib.Str(_errate,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } else { // Otherwise
        /* gMsgImp := 'Impossibile effettuare operazione - Selezionare o Primo Invio o Secondo o Periodo' */
        gMsgImp = "Impossibile effettuare operazione - Selezionare o Primo Invio o Secondo o Periodo";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End Case
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
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000002Estatus,0)) {
        m_Sql.SetTransactionStatus(nTry0000002Estatus,cTry0000002Emsg);
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_inviomens_delope_1=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_aederig=null;
    CPResultSet Cursor_qbe_inviomens_delope_2=null;
    CPResultSet Cursor_qbe_inviomens_delope_3=null;
    CPResultSet Cursor_qbe_inviomens_delope_4=null;
    CPResultSet Cursor_qbe_inviomens_delope_5_min_max=null;
    CPResultSet Cursor_qbe_inviomens_delope_5=null;
    CPResultSet Cursor_aeoprig=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Estrae dati per primo invio */
      /* imprec := 0 */
      imprec = CPLib.Round(0,0);
      /* _errate := 0 */
      _errate = CPLib.Round(0,0);
      /* _newope := 0 */
      _newope = CPLib.Round(0,0);
      /* _aggope := 0 */
      _aggope = CPLib.Round(0,0);
      // * --- Select from qbe_inviomens_delope_1
      if (Cursor_qbe_inviomens_delope_1!=null)
        Cursor_qbe_inviomens_delope_1.Close();
      Cursor_qbe_inviomens_delope_1 = new VQRHolder("qbe_inviomens_delope_1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_inviomens_delope_1.Eof())) {
        /* imprec := imprec + 1 */
        imprec = CPLib.Round(imprec+1,0);
        /* _iddelega := '' */
        _iddelega = "";
        // * --- Read from aederig
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_delope_1.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_inviomens_delope_1.GetString("RAPPORTO"));
        m_cSql = m_cSql+" and CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_delope_1.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_inviomens_delope_1.GetString("CODINTER"));
        if (m_Ctx.IsSharedTemp("aederig")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _iddelega = Read_Cursor.GetString("IDBASE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aederig into routine arrt_inviomese_delope returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _iddelega = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* _cfestero := 0 */
        _cfestero = CPLib.Round(0,0);
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_inviomens_delope_1.GetString("CODINTER")),"C",16,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_qbe_inviomens_delope_1.GetString("CODINTER")));
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CFESTERO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _cfestero = CPLib.Round(Read_Cursor.GetDouble("CFESTERO"),0);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_inviomese_delope returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _cfestero = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(_iddelega) */
        if (CPLib.Empty(_iddelega)) {
          /* _newope := _newope + 1 */
          _newope = CPLib.Round(_newope+1,0);
          /* _prog := Utilities.GetAutonumber("PRGAEDELEG\'"+LRTrim(gAzienda)+"'",'',10) */
          _prog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAEDELEG\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* nProgImp := Utilities.GetAutonumber("PROGAED\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAED\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"00000052")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000052(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_delope_1.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_delope_1.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_delope_1.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_delope_1.GetDate("DATAINI"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_delope_1.GetDate("DATAFINE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("A","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_cfestero,1)?"S":"N"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aederig",true);
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
          // * --- Select from aederig
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          if (Cursor_aederig!=null)
            Cursor_aederig.Close();
          Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_delope_1.GetString("RAPPORTO"),"?",0,0)+"  and  CONNESINT="+CPLib.ToSQL(Cursor_qbe_inviomens_delope_1.GetString("CODINTER"),"?",0,0)+"  and  ADATA="+CPLib.ToSQL(Cursor_qbe_inviomens_delope_1.GetDate("DATAINI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aederig.Eof())) {
            /* _opeagg := 'N' */
            _opeagg = "N";
            /* If aederig->IDBASE = qbe_inviomens_delope_1->NUMPROG1 */
            if (CPLib.eqr(Cursor_aederig.GetString("IDBASE"),Cursor_qbe_inviomens_delope_1.GetString("NUMPROG1"))) {
              /* If Empty(aederig->TIPOAG) */
              if (CPLib.Empty(Cursor_aederig.GetString("TIPOAG"))) {
                /* _opeagg := 'S' */
                _opeagg = "S";
                // * --- Write into aederig from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aederig");
                m_cPhName = m_Ctx.GetPhName("aederig");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"00000058")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(Cursor_qbe_inviomens_delope_1.GetString("TIPOAG"),"C",2,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("IDBASE"))+"";
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
              /* If aederig->ASPEDITO=0 */
              if (CPLib.eqr(Cursor_aederig.GetDouble("ASPEDITO"),0)) {
                /* If Empty(aederig->ADATA) */
                if (CPLib.Empty(Cursor_aederig.GetDate("ADATA"))) {
                  /* _opeagg := 'S' */
                  _opeagg = "S";
                  // * --- Write into aederig from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aederig");
                  m_cPhName = m_Ctx.GetPhName("aederig");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"0000005C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"ADATA = "+CPLib.ToSQL(Cursor_qbe_inviomens_delope_1.GetDate("DATAINI"),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("IDBASE"))+"";
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
                /* If Empty(aederig->CONNESINT) */
                if (CPLib.Empty(Cursor_aederig.GetString("CONNESINT"))) {
                  /* _opeagg := 'S' */
                  _opeagg = "S";
                  // * --- Write into aederig from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aederig");
                  m_cPhName = m_Ctx.GetPhName("aederig");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"0000005F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQL(Cursor_qbe_inviomens_delope_1.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("IDBASE"))+"";
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
                /* If _opeagg='S' */
                if (CPLib.eqr(_opeagg,"S")) {
                  /* _aggope := _aggope + 1 */
                  _aggope = CPLib.Round(_aggope+1,0);
                } // End If
              } // End If
            } // End If
            Cursor_aederig.Next();
          }
          m_cConnectivityError = Cursor_aederig.ErrorMessage();
          Cursor_aederig.Close();
          // * --- End Select
        } // End If
        Cursor_qbe_inviomens_delope_1.Next();
      }
      m_cConnectivityError = Cursor_qbe_inviomens_delope_1.ErrorMessage();
      Cursor_qbe_inviomens_delope_1.Close();
      // * --- End Select
      // * --- Select from qbe_inviomens_delope_2
      if (Cursor_qbe_inviomens_delope_2!=null)
        Cursor_qbe_inviomens_delope_2.Close();
      Cursor_qbe_inviomens_delope_2 = new VQRHolder("qbe_inviomens_delope_2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_inviomens_delope_2.Eof())) {
        // * --- Select from aederig
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
        Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_delope_2.GetString("RAPPORTO"),"?",0,0)+"  and  CONNESINT="+CPLib.ToSQL(Cursor_qbe_inviomens_delope_2.GetString("CODINTER"),"?",0,0)+"  and  ADATA="+CPLib.ToSQL(Cursor_qbe_inviomens_delope_2.GetDate("DATAINI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aederig.Eof())) {
          /* _aggope := _aggope + 1 */
          _aggope = CPLib.Round(_aggope+1,0);
          // * --- Write into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"00000065")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(Cursor_qbe_inviomens_delope_2.GetDate("DATAFINE"),"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("IDBASE"))+"";
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
          Cursor_aederig.Next();
        }
        m_cConnectivityError = Cursor_aederig.ErrorMessage();
        Cursor_aederig.Close();
        // * --- End Select
        Cursor_qbe_inviomens_delope_2.Next();
      }
      m_cConnectivityError = Cursor_qbe_inviomens_delope_2.ErrorMessage();
      Cursor_qbe_inviomens_delope_2.Close();
      // * --- End Select
      // * --- Select from qbe_inviomens_delope_3
      if (Cursor_qbe_inviomens_delope_3!=null)
        Cursor_qbe_inviomens_delope_3.Close();
      Cursor_qbe_inviomens_delope_3 = new VQRHolder("qbe_inviomens_delope_3",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_inviomens_delope_3.Eof())) {
        /* imprec := imprec + 1 */
        imprec = CPLib.Round(imprec+1,0);
        /* _iddelega := '' */
        _iddelega = "";
        // * --- Read from aederig
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_delope_3.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_inviomens_delope_3.GetString("RAPPORTO"));
        m_cSql = m_cSql+" and CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_delope_3.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_inviomens_delope_3.GetString("CODINTER"));
        if (m_Ctx.IsSharedTemp("aederig")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _iddelega = Read_Cursor.GetString("IDBASE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aederig into routine arrt_inviomese_delope returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _iddelega = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* _cfestero := 0 */
        _cfestero = CPLib.Round(0,0);
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_delope_3.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_inviomens_delope_3.GetString("CODINTER"));
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CFESTERO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _cfestero = CPLib.Round(Read_Cursor.GetDouble("CFESTERO"),0);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_inviomese_delope returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _cfestero = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(_iddelega) */
        if (CPLib.Empty(_iddelega)) {
          /* _newope := _newope + 1 */
          _newope = CPLib.Round(_newope+1,0);
          /* _prog := Utilities.GetAutonumber("PRGAEDELEG\'"+LRTrim(gAzienda)+"'",'',10) */
          _prog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAEDELEG\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* nProgImp := Utilities.GetAutonumber("PROGAED\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAED\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"00000070")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000070(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_delope_3.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_delope_3.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_delope_3.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_delope_3.GetDate("DATAINI"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_delope_3.GetDate("DATAFINE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_cfestero,1)?"S":"N"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aederig",true);
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
          // * --- Select from aederig
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          if (Cursor_aederig!=null)
            Cursor_aederig.Close();
          Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_delope_3.GetString("RAPPORTO"),"?",0,0)+"  and  CONNESINT="+CPLib.ToSQL(Cursor_qbe_inviomens_delope_3.GetString("CODINTER"),"?",0,0)+"  and  ADATA="+CPLib.ToSQL(Cursor_qbe_inviomens_delope_3.GetDate("DATAINI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aederig.Eof())) {
            /* If aederig->IDBASE = qbe_inviomens_delope_3->NUMPROG1 */
            if (CPLib.eqr(Cursor_aederig.GetString("IDBASE"),Cursor_qbe_inviomens_delope_3.GetString("NUMPROG1"))) {
              /* _opeagg := 'N' */
              _opeagg = "N";
              /* If Empty(aederig->TIPOAG) */
              if (CPLib.Empty(Cursor_aederig.GetString("TIPOAG"))) {
                /* _opeagg := 'S' */
                _opeagg = "S";
                // * --- Write into aederig from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aederig");
                m_cPhName = m_Ctx.GetPhName("aederig");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"00000076")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(Cursor_qbe_inviomens_delope_3.GetString("TIPOAG"),"C",2,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("IDBASE"))+"";
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
              /* If aederig->ASPEDITO=0 */
              if (CPLib.eqr(Cursor_aederig.GetDouble("ASPEDITO"),0)) {
                /* If Empty(aederig->ADATA) */
                if (CPLib.Empty(Cursor_aederig.GetDate("ADATA"))) {
                  /* _opeagg := 'S' */
                  _opeagg = "S";
                  // * --- Write into aederig from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aederig");
                  m_cPhName = m_Ctx.GetPhName("aederig");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"0000007A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"ADATA = "+CPLib.ToSQL(Cursor_qbe_inviomens_delope_3.GetDate("DATAINI"),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("IDBASE"))+"";
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
                /* If Empty(aederig->CONNESINT) */
                if (CPLib.Empty(Cursor_aederig.GetString("CONNESINT"))) {
                  /* _opeagg := 'S' */
                  _opeagg = "S";
                  // * --- Write into aederig from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aederig");
                  m_cPhName = m_Ctx.GetPhName("aederig");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"0000007D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQL(Cursor_qbe_inviomens_delope_3.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("IDBASE"))+"";
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
              /* If _opeagg='S' */
              if (CPLib.eqr(_opeagg,"S")) {
                /* _aggope := _aggope + 1 */
                _aggope = CPLib.Round(_aggope+1,0);
              } // End If
            } // End If
            Cursor_aederig.Next();
          }
          m_cConnectivityError = Cursor_aederig.ErrorMessage();
          Cursor_aederig.Close();
          // * --- End Select
        } // End If
        Cursor_qbe_inviomens_delope_3.Next();
      }
      m_cConnectivityError = Cursor_qbe_inviomens_delope_3.ErrorMessage();
      Cursor_qbe_inviomens_delope_3.Close();
      // * --- End Select
      // * --- Select from qbe_inviomens_delope_4
      if (Cursor_qbe_inviomens_delope_4!=null)
        Cursor_qbe_inviomens_delope_4.Close();
      Cursor_qbe_inviomens_delope_4 = new VQRHolder("qbe_inviomens_delope_4",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_inviomens_delope_4.Eof())) {
        // * --- Select from aederig
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
        Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviomens_delope_4.GetString("RAPPORTO"),"?",0,0)+"  and  CONNESINT="+CPLib.ToSQL(Cursor_qbe_inviomens_delope_4.GetString("CODINTER"),"?",0,0)+"  and  ADATA="+CPLib.ToSQL(Cursor_qbe_inviomens_delope_4.GetDate("DATAINI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aederig.Eof())) {
          /* _aggope := _aggope + 1 */
          _aggope = CPLib.Round(_aggope+1,0);
          // * --- Write into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"00000083")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(Cursor_qbe_inviomens_delope_4.GetDate("DATAFINE"),"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("IDBASE"))+"";
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
          Cursor_aederig.Next();
        }
        m_cConnectivityError = Cursor_aederig.ErrorMessage();
        Cursor_aederig.Close();
        // * --- End Select
        Cursor_qbe_inviomens_delope_4.Next();
      }
      m_cConnectivityError = Cursor_qbe_inviomens_delope_4.ErrorMessage();
      Cursor_qbe_inviomens_delope_4.Close();
      // * --- End Select
      /* Operazioni ExtraConto */
      // * --- Select from qbe_inviomens_delope_5_min_max
      if (Cursor_qbe_inviomens_delope_5_min_max!=null)
        Cursor_qbe_inviomens_delope_5_min_max.Close();
      Cursor_qbe_inviomens_delope_5_min_max = new VQRHolder("qbe_inviomens_delope_5_min_max",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_inviomens_delope_5_min_max.Eof())) {
        /* _max := qbe_inviomens_delope_5_min_max->NUMMAX */
        _max = CPLib.Round(Cursor_qbe_inviomens_delope_5_min_max.GetDouble("NUMMAX"),0);
        /* _min := qbe_inviomens_delope_5_min_max->NUMMIN */
        _min = CPLib.Round(Cursor_qbe_inviomens_delope_5_min_max.GetDouble("NUMMIN"),0);
        Cursor_qbe_inviomens_delope_5_min_max.Next();
      }
      m_cConnectivityError = Cursor_qbe_inviomens_delope_5_min_max.ErrorMessage();
      Cursor_qbe_inviomens_delope_5_min_max.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,1000) <> 0,Int(_max/1000) + 1,Int(_max/1000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,1000),0)?CPLib.Int(_max/1000)+1:CPLib.Int(_max/1000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* While _conta<=_cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* _bottom := ((_conta -1 ) * 1000) + 1 */
        _bottom = CPLib.Round(((_conta-1)*1000)+1,0);
        /* _top := _conta * 1000 */
        _top = CPLib.Round(_conta*1000,0);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_inviomens_delope_5
          if (Cursor_qbe_inviomens_delope_5!=null)
            Cursor_qbe_inviomens_delope_5.Close();
          Cursor_qbe_inviomens_delope_5 = new VQRHolder("qbe_inviomens_delope_5",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_inviomens_delope_5.Eof())) {
            /* imprec := imprec + 1 */
            imprec = CPLib.Round(imprec+1,0);
            /* gMsgImp := "Sto elaborando l'operazione n° "+LRTrim(Str(imprec,10,0)) // Messaggio Import */
            gMsgImp = "Sto elaborando l'operazione n° "+CPLib.LRTrim(CPLib.Str(imprec,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _cfestero := qbe_inviomens_delope_5->CFESTERO */
            _cfestero = CPLib.Round(Cursor_qbe_inviomens_delope_5.GetDouble("CFESTERO"),0);
            /* _chkcli := LRTrim(qbe_inviomens_delope_5->CONNES) */
            _chkcli = CPLib.LRTrim(Cursor_qbe_inviomens_delope_5.GetString("CONNES"));
            /* If not(Empty(LRTrim(_chkcli))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(_chkcli)))) {
              /* _idbase := '' */
              _idbase = "";
              // * --- Read from aeoprig
              m_cServer = m_Ctx.GetServer("aeoprig");
              m_cPhName = m_Ctx.GetPhName("aeoprig");
              m_cSql = "";
              m_cSql = m_cSql+"CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_inviomens_delope_5.GetString("COLLEG")),"C",16,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_qbe_inviomens_delope_5.GetString("COLLEG")));
              m_cSql = m_cSql+" and ADATA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_delope_5.GetDate("DATAOPE"),"D",8,0,m_cServer),m_cServer,Cursor_qbe_inviomens_delope_5.GetDate("DATAOPE"));
              if (m_Ctx.IsSharedTemp("aeoprig")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _idbase = Read_Cursor.GetString("IDBASE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aeoprig into routine arrt_inviomese_delope returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _idbase = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If not(Empty(LRTrim(_idbase))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(_idbase)))) {
                /* _prgope := '' */
                _prgope = "";
                // * --- Read from aeopcanc
                m_cServer = m_Ctx.GetServer("aeopcanc");
                m_cPhName = m_Ctx.GetPhName("aeopcanc");
                m_cSql = "";
                m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"C",10,0,m_cServer),m_cServer,_idbase);
                if (m_Ctx.IsSharedTemp("aeopcanc")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROGRES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _prgope = Read_Cursor.GetString("PROGRES");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on aeopcanc into routine arrt_inviomese_delope returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _prgope = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
              /* If Empty(LRTrim(_idbase)) or not(Empty(_prgope)) */
              if (CPLib.Empty(CPLib.LRTrim(_idbase)) ||  ! (CPLib.Empty(_prgope))) {
                /* _prog := Utilities.GetAutonumber("PRGAEOPEXTR\'"+LRTrim(gAzienda)+"'",'',10) */
                _prog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAEOPEXTR\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                /* _tipoco := iif(Empty(LRTrim(qbe_inviomens_delope_5->COINT)),'2',qbe_inviomens_delope_5->COINT) */
                _tipoco = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_inviomens_delope_5.GetString("COINT")))?"2":Cursor_qbe_inviomens_delope_5.GetString("COINT"));
                /* nProgImp := Utilities.GetAutonumber("PROGAED\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAED\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                // * --- Insert into aeoprig from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aeoprig");
                m_cPhName = m_Ctx.GetPhName("aeoprig");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"0000009D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000009D(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_inviomens_delope_5.GetString("COLLEG")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_delope_5.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("98","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tipoco,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_cfestero,1)?"S":"N"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(Cursor_qbe_inviomens_delope_5.GetDate("DATAOPE")),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeoprig",true);
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
                // * --- Write into opextrbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"0000009E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(_prog,"C",10,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_inviomens_delope_5.GetString("COLLEG")),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_qbe_inviomens_delope_5.GetString("COLLEG")))+"";
                m_cSql = m_cSql+" and DATAOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_delope_5.GetDate("DATAOPE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_delope_5.GetDate("DATAOPE"))+"";
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
                /* _newope := _newope + 1 */
                _newope = CPLib.Round(_newope+1,0);
              } else { // Else
                // * --- Select from aeoprig
                m_cServer = m_Ctx.GetServer("aeoprig");
                m_cPhName = m_Ctx.GetPhName("aeoprig");
                if (Cursor_aeoprig!=null)
                  Cursor_aeoprig.Close();
                Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESINT="+CPLib.ToSQL(Cursor_qbe_inviomens_delope_5.GetString("COLLEG"),"?",0,0)+"  and  ADATA="+CPLib.ToSQL(Cursor_qbe_inviomens_delope_5.GetDate("DATAOPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aeoprig.Eof())) {
                  /* If aeoprig->IDBASE=qbe_inviomens_delope_5->NUMPROG1 */
                  if (CPLib.eqr(Cursor_aeoprig.GetString("IDBASE"),Cursor_qbe_inviomens_delope_5.GetString("NUMPROG1"))) {
                    /* _opeagg := 'N' */
                    _opeagg = "N";
                    /* If Empty(aeoprig->TIPOAG) */
                    if (CPLib.Empty(Cursor_aeoprig.GetString("TIPOAG"))) {
                      // * --- Write into aeoprig from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("aeoprig");
                      m_cPhName = m_Ctx.GetPhName("aeoprig");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"000000A4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL("98","C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"COINT = "+CPLib.ToSQL("2","C",1,0,m_cServer)+", ";
                      m_cSql = m_cSql+"NOCODFISC = "+CPLib.ToSQL((CPLib.eqr(_cfestero,1)?"S":"N"),"C",1,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_delope_5.GetString("NUMPROG1"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_delope_5.GetString("NUMPROG1"))+"";
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
                      /* _opeagg := 'S' */
                      _opeagg = "S";
                    } // End If
                    /* If aeoprig->ASPEDITO=0 */
                    if (CPLib.eqr(Cursor_aeoprig.GetDouble("ASPEDITO"),0)) {
                      /* If Empty(aeoprig->ADATA) */
                      if (CPLib.Empty(Cursor_aeoprig.GetDate("ADATA"))) {
                        // * --- Write into aeoprig from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("aeoprig");
                        m_cPhName = m_Ctx.GetPhName("aeoprig");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"000000A8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"ADATA = "+CPLib.ToSQL(Cursor_qbe_inviomens_delope_5.GetDate("DATAOPE"),"D",8,0)+", ";
                        m_cSql = m_cSql+"NOCODFISC = "+CPLib.ToSQL((CPLib.eqr(_cfestero,1)?"S":"N"),"C",1,0,m_cServer)+", ";
                        m_cSql = m_cSql+"ANNOOPE = "+CPLib.ToSQL(CPLib.Year(Cursor_qbe_inviomens_delope_5.GetDate("DATAOPE")),"N",4,0)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_delope_5.GetString("NUMPROG1"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_delope_5.GetString("NUMPROG1"))+"";
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
                        /* _opeagg := 'S' */
                        _opeagg = "S";
                      } // End If
                      /* If Empty(aeoprig->CONNESINT) */
                      if (CPLib.Empty(Cursor_aeoprig.GetString("CONNESINT"))) {
                        // * --- Write into aeoprig from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("aeoprig");
                        m_cPhName = m_Ctx.GetPhName("aeoprig");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"000000AB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQL(Cursor_qbe_inviomens_delope_5.GetString("COLLEG"),"C",16,0,m_cServer)+", ";
                        m_cSql = m_cSql+"NOCODFISC = "+CPLib.ToSQL((CPLib.eqr(_cfestero,1)?"S":"N"),"C",1,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviomens_delope_5.GetString("NUMPROG1"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviomens_delope_5.GetString("NUMPROG1"))+"";
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
                        /* _opeagg := 'S' */
                        _opeagg = "S";
                      } // End If
                    } // End If
                    /* If _opeagg='S' */
                    if (CPLib.eqr(_opeagg,"S")) {
                      /* _aggope := _aggope + 1 */
                      _aggope = CPLib.Round(_aggope+1,0);
                    } // End If
                  } // End If
                  Cursor_aeoprig.Next();
                }
                m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
                Cursor_aeoprig.Close();
                // * --- End Select
              } // End If
            } else { // Else
              /* _errate := _errate + 1 */
              _errate = CPLib.Round(_errate+1,0);
              // * --- Insert into tmp_stovaria from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stovaria");
              m_cPhName = m_Ctx.GetPhName("tmp_stovaria");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stovaria",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_inviomese_delope",97,"000000B0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000B0(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_delope_5.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviomens_delope_5.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stovaria",true);
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
            Cursor_qbe_inviomens_delope_5.Next();
          }
          m_cConnectivityError = Cursor_qbe_inviomens_delope_5.ErrorMessage();
          Cursor_qbe_inviomens_delope_5.Close();
          // * --- End Select
        } // End If
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_inviomens_delope_1!=null)
          Cursor_qbe_inviomens_delope_1.Close();
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
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_inviomens_delope_2!=null)
          Cursor_qbe_inviomens_delope_2.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_inviomens_delope_3!=null)
          Cursor_qbe_inviomens_delope_3.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_inviomens_delope_4!=null)
          Cursor_qbe_inviomens_delope_4.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_inviomens_delope_5_min_max!=null)
          Cursor_qbe_inviomens_delope_5_min_max.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_inviomens_delope_5!=null)
          Cursor_qbe_inviomens_delope_5.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
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
      m_Caller.SetDate("a_data","D",8,0,w_a_data);
      m_Caller.SetDate("dadata","D",8,0,w_dadata);
      m_Caller.SetDate("datprf","D",8,0,w_datprf);
      m_Caller.SetDate("datpri","D",8,0,w_datpri);
      m_Caller.SetDate("datsecf","D",8,0,w_datsecf);
      m_Caller.SetDate("datseci","D",8,0,w_datseci);
      m_Caller.SetString("iniz","C",1,0,w_iniz);
      m_Caller.SetString("seco","C",1,0,w_seco);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_inviomese_delopeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_inviomese_delopeR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_a_data = m_Caller.GetDate("a_data","D",8,0);
    w_dadata = m_Caller.GetDate("dadata","D",8,0);
    w_datprf = m_Caller.GetDate("datprf","D",8,0);
    w_datpri = m_Caller.GetDate("datpri","D",8,0);
    w_datsecf = m_Caller.GetDate("datsecf","D",8,0);
    w_datseci = m_Caller.GetDate("datseci","D",8,0);
    w_iniz = m_Caller.GetString("iniz","C",1,0);
    w_seco = m_Caller.GetString("seco","C",1,0);
    _errlog = "";
    imprec = 0;
    _noprot = 0;
    _rapold = CPLib.Space(25);
    _tipoco = CPLib.Space(1);
    _nriga = 0;
    _newrow = 0;
    _conta = 0;
    _idriga = CPLib.Space(10);
    _prog = CPLib.Space(10);
    _idbase = CPLib.Space(10);
    _newope = 0;
    _aggope = 0;
    _opeagg = CPLib.Space(1);
    nProgImp = 0;
    _bottom = 0;
    _top = 0;
    _cicli = 0;
    _max = 0;
    _min = 0;
    _cfestero = 0;
    _chkcli = CPLib.Space(16);
    _errate = 0;
    _iddelega = CPLib.Space(10);
    _prgope = CPLib.Space(10);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_inviomens_delope_1,qbe_inviomens_delope_2,qbe_inviomens_delope_3,qbe_inviomens_delope_4,qbe_inviomens_delope_5_min_max,qbe_inviomens_delope_5,
  public static final String m_cVQRList = ",qbe_inviomens_delope_1,qbe_inviomens_delope_2,qbe_inviomens_delope_3,qbe_inviomens_delope_4,qbe_inviomens_delope_5_min_max,qbe_inviomens_delope_5,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000052(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"PROGDLG,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aederig",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000070(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"PROGDLG,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aederig",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"PROGOPX,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeoprig",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"DATVARIA,";
    p_cSql = p_cSql+"NUMVARIA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stovaria",true);
    return p_cSql;
  }
}
