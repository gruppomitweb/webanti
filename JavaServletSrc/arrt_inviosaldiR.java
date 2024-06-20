// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_inviosaldiR implements CallerWithObjs {
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
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_tmp_stprapporti;
  public String m_cServer_tmp_stprapporti;
  public String m_cPhName_tmp_esitosaldi;
  public String m_cServer_tmp_esitosaldi;
  public String m_cPhName_aeinvio;
  public String m_cServer_aeinvio;
  public String m_cPhName_aecanc;
  public String m_cServer_aecanc;
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
  public double w_anno;
  public java.sql.Date w_a_data;
  public java.sql.Date w_dadata;
  public String w_flgcod;
  public String w_flgstp;
  public String w_flgnum;
  public String gMsgImp;
  public String gAzienda;
  public String gDescAzi;
  public String gIntemediario;
  public String gPathApp;
  public double _min;
  public double _max;
  public double _tot;
  public double _mono;
  public double _cicli;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public double _saldo;
  public double _qta;
  public String _val;
  public String _unique;
  public double _coint;
  public String _rapp;
  public double _ok;
  public String _idb;
  public String _collopex;
  public String _descrapp;
  public String _fileanno;
  public double _deleted;
  public String _txterr;
  public double _contarec;
  public double _contaerr;
  public double _contarig;
  public MemoryCursor_mcerrsaldi_mcrdef mcErrori;
  public MemoryCursorRow_mcerrsaldi_mcrdef rwErrori;
  public MemoryCursor_mcstpsaldi_mcrdef mcStpAgg;
  public MemoryCursorRow_mcstpsaldi_mcrdef rwStpAgg;
  public String _nomerep;
  public ReportLibrary _report;
  public boolean bReport;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_inviosaldiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_inviosaldi",m_Caller);
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
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti")) {
      m_cPhName_tmp_stprapporti = p_ContextObject.GetPhName("tmp_stprapporti");
      if (m_cPhName_tmp_stprapporti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stprapporti = m_cPhName_tmp_stprapporti+" "+m_Ctx.GetWritePhName("tmp_stprapporti");
      }
      m_cServer_tmp_stprapporti = p_ContextObject.GetServer("tmp_stprapporti");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_esitosaldi")) {
      m_cPhName_tmp_esitosaldi = p_ContextObject.GetPhName("tmp_esitosaldi");
      if (m_cPhName_tmp_esitosaldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_esitosaldi = m_cPhName_tmp_esitosaldi+" "+m_Ctx.GetWritePhName("tmp_esitosaldi");
      }
      m_cServer_tmp_esitosaldi = p_ContextObject.GetServer("tmp_esitosaldi");
    }
    m_cPhName_aeinvio = p_ContextObject.GetPhName("aeinvio");
    if (m_cPhName_aeinvio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeinvio = m_cPhName_aeinvio+" "+m_Ctx.GetWritePhName("aeinvio");
    }
    m_cServer_aeinvio = p_ContextObject.GetServer("aeinvio");
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    if (m_cPhName_aecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aecanc = m_cPhName_aecanc+" "+m_Ctx.GetWritePhName("aecanc");
    }
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    if (m_cPhName_aeopcanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopcanc = m_cPhName_aeopcanc+" "+m_Ctx.GetWritePhName("aeopcanc");
    }
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
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
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
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
    if (CPLib.eqr("_saldo",p_cVarName)) {
      return _saldo;
    }
    if (CPLib.eqr("_qta",p_cVarName)) {
      return _qta;
    }
    if (CPLib.eqr("_coint",p_cVarName)) {
      return _coint;
    }
    if (CPLib.eqr("_ok",p_cVarName)) {
      return _ok;
    }
    if (CPLib.eqr("_deleted",p_cVarName)) {
      return _deleted;
    }
    if (CPLib.eqr("_contarec",p_cVarName)) {
      return _contarec;
    }
    if (CPLib.eqr("_contaerr",p_cVarName)) {
      return _contaerr;
    }
    if (CPLib.eqr("_contarig",p_cVarName)) {
      return _contarig;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_inviosaldi";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("flgcod",p_cVarName)) {
      return w_flgcod;
    }
    if (CPLib.eqr("flgstp",p_cVarName)) {
      return w_flgstp;
    }
    if (CPLib.eqr("flgnum",p_cVarName)) {
      return w_flgnum;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("_val",p_cVarName)) {
      return _val;
    }
    if (CPLib.eqr("_unique",p_cVarName)) {
      return _unique;
    }
    if (CPLib.eqr("_rapp",p_cVarName)) {
      return _rapp;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      return _idb;
    }
    if (CPLib.eqr("_collopex",p_cVarName)) {
      return _collopex;
    }
    if (CPLib.eqr("_descrapp",p_cVarName)) {
      return _descrapp;
    }
    if (CPLib.eqr("_fileanno",p_cVarName)) {
      return _fileanno;
    }
    if (CPLib.eqr("_txterr",p_cVarName)) {
      return _txterr;
    }
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      return _nomerep;
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
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      return mcErrori;
    }
    if (CPLib.eqr("mcStpAgg",p_cVarName)) {
      return mcStpAgg;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rwErrori",p_cVarName)) {
      return rwErrori;
    }
    if (CPLib.eqr("rwStpAgg",p_cVarName)) {
      return rwStpAgg;
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
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
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
    if (CPLib.eqr("_saldo",p_cVarName)) {
      _saldo = value;
      return;
    }
    if (CPLib.eqr("_qta",p_cVarName)) {
      _qta = value;
      return;
    }
    if (CPLib.eqr("_coint",p_cVarName)) {
      _coint = value;
      return;
    }
    if (CPLib.eqr("_ok",p_cVarName)) {
      _ok = value;
      return;
    }
    if (CPLib.eqr("_deleted",p_cVarName)) {
      _deleted = value;
      return;
    }
    if (CPLib.eqr("_contarec",p_cVarName)) {
      _contarec = value;
      return;
    }
    if (CPLib.eqr("_contaerr",p_cVarName)) {
      _contaerr = value;
      return;
    }
    if (CPLib.eqr("_contarig",p_cVarName)) {
      _contarig = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("flgcod",p_cVarName)) {
      w_flgcod = value;
      return;
    }
    if (CPLib.eqr("flgstp",p_cVarName)) {
      w_flgstp = value;
      return;
    }
    if (CPLib.eqr("flgnum",p_cVarName)) {
      w_flgnum = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("_val",p_cVarName)) {
      _val = value;
      return;
    }
    if (CPLib.eqr("_unique",p_cVarName)) {
      _unique = value;
      return;
    }
    if (CPLib.eqr("_rapp",p_cVarName)) {
      _rapp = value;
      return;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      _idb = value;
      return;
    }
    if (CPLib.eqr("_collopex",p_cVarName)) {
      _collopex = value;
      return;
    }
    if (CPLib.eqr("_descrapp",p_cVarName)) {
      _descrapp = value;
      return;
    }
    if (CPLib.eqr("_fileanno",p_cVarName)) {
      _fileanno = value;
      return;
    }
    if (CPLib.eqr("_txterr",p_cVarName)) {
      _txterr = value;
      return;
    }
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      _nomerep = value;
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
    if (CPLib.eqr("rwErrori",p_cVarName)) {
      rwErrori = (MemoryCursorRow_mcerrsaldi_mcrdef)value;
      return;
    }
    if (CPLib.eqr("rwStpAgg",p_cVarName)) {
      rwStpAgg = (MemoryCursorRow_mcstpsaldi_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      mcErrori = (MemoryCursor_mcerrsaldi_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcStpAgg",p_cVarName)) {
      mcStpAgg = (MemoryCursor_mcstpsaldi_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    /* w_anno Numeric(4, 0) */
    /* w_a_data Date */
    /* w_dadata Date */
    /* w_flgcod Char(1) */
    /* w_flgstp Char(1) */
    /* w_flgnum Char(1) */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gAzienda Char(10) // Azienda */
    /* gDescAzi Char(70) // Descrizione Intermediario */
    /* gIntemediario Char(11) // Intermediario */
    /* gPathApp Char(80) // Path Applicazione */
    /* _min Numeric(15, 0) */
    /* _max Numeric(15, 0) */
    /* _tot Numeric(15, 0) */
    /* _mono Numeric(1, 0) */
    /* _cicli Numeric(15, 0) */
    /* _contacicli Numeric(15, 0) */
    /* _bottom Numeric(15, 0) */
    /* _top Numeric(15, 0) */
    /* _saldo Numeric(17, 0) */
    /* _qta Numeric(6, 0) */
    /* _val Char(3) */
    /* _unique Char(50) */
    /* _coint Numeric(10, 0) */
    /* _rapp Char(25) */
    /* _ok Numeric(1, 0) */
    /* _idb Char(10) */
    /* _collopex Char(16) */
    /* _descrapp Char(50) */
    /* _fileanno Char(50) */
    /* _deleted Numeric(1, 0) */
    /* _txterr Memo */
    /* _contarec Numeric(10, 0) */
    /* _contaerr Numeric(10, 0) */
    /* _contarig Numeric(10, 0) */
    /* mcErrori MemoryCursor(mcErrSaldi.MCRDef) */
    /* rwErrori Row(mcErrSaldi.MCRDef) */
    /* mcStpAgg MemoryCursor(mcStpSaldi.MCRDef) */
    /* rwStpAgg Row(mcStpSaldi.MCRDef) */
    /* _nomerep Memo // Nome Stampa */
    /* _report Object(ReportLibrary) */
    /* bReport Bool */
    // * --- Drop temporary table tmp_stprapporti
    if (m_Ctx.IsSharedTemp("tmp_stprapporti")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti")) {
        m_cServer = m_Ctx.GetServer("tmp_stprapporti");
        m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_stprapporti");
    }
    // * --- Create temporary table tmp_stprapporti
    if (m_Ctx.IsSharedTemp("tmp_stprapporti")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti")) {
        m_cServer = m_Ctx.GetServer("tmp_stprapporti");
        m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_stprapporti");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_stprapporti");
    if ( ! (m_Ctx.IsSharedTemp("tmp_stprapporti"))) {
      m_cServer = m_Ctx.GetServer("tmp_stprapporti");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stprapporti",m_cServer,"proto")),m_cPhName,"tmp_stprapporti",m_Ctx);
    }
    m_cPhName_tmp_stprapporti = m_cPhName;
    // * --- Drop temporary table tmp_esitosaldi
    if (m_Ctx.IsSharedTemp("tmp_esitosaldi")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_esitosaldi")) {
        m_cServer = m_Ctx.GetServer("tmp_esitosaldi");
        m_cPhName = m_Ctx.GetPhName("tmp_esitosaldi");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_esitosaldi");
    }
    // * --- Create temporary table tmp_esitosaldi
    if (m_Ctx.IsSharedTemp("tmp_esitosaldi")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_esitosaldi")) {
        m_cServer = m_Ctx.GetServer("tmp_esitosaldi");
        m_cPhName = m_Ctx.GetPhName("tmp_esitosaldi");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_esitosaldi");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_esitosaldi");
    if ( ! (m_Ctx.IsSharedTemp("tmp_esitosaldi"))) {
      m_cServer = m_Ctx.GetServer("tmp_esitosaldi");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_esitosaldi",m_cServer,"proto")),m_cPhName,"tmp_esitosaldi",m_Ctx);
    }
    m_cPhName_tmp_esitosaldi = m_cPhName;
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry00000034status;
    nTry00000034status = m_Sql.GetTransactionStatus();
    String cTry00000034msg;
    cTry00000034msg = m_Sql.TransactionErrorMessage();
    try {
      /* Exec "Rapporti Continuativi" Page 2:Page_2 */
      Page_2();
      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
        throw new RoutineException();
      }
      /* Exec "Operazioni Extraconto" Page 3:Page_3 */
      Page_3();
      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
        throw new RoutineException();
      }
      // Commit
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      m_Sql.CompleteTransaction();
      /* If w_flgstp='S' */
      if (CPLib.eqr(w_flgstp,"S")) {
        /* _report := ReportLibrary.GetReportLibrary() */
        _report = ReportLibrary.Make(m_Ctx).GetReportLibrary();
        /* _report.setParameterChar('w_DescAzi',gDescAzi) */
        _report.setParameterChar("w_DescAzi",gDescAzi);
        /* _report.setParameterNumeric('w_anno',w_anno) */
        _report.setParameterNumeric("w_anno",w_anno);
        /* _nomerep := 'arrp_inviosaldi_anomalie.vrp' // Nome Stampa */
        _nomerep = "arrp_inviosaldi_anomalie.vrp";
        /* bReport := _report.makeReport(_nomerep,LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/errori_saldi_'+Str(w_anno,4,0)+'.pdf','A4','LANDSCAPE','PDF') */
        bReport = _report.makeReport(_nomerep,CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/errori_saldi_"+CPLib.Str(w_anno,4,0)+".pdf","A4","LANDSCAPE","PDF");
      } // End If
      /* gMsgImp := 'Estrazione Dati terminata. Premere il bottone per lanciare la stampa' // Messaggio Import */
      gMsgImp = "Estrazione Dati terminata. Premere il bottone per lanciare la stampa";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } catch(Exception l_exeption) {
      Stop.ReactToException(l_exeption);
      // Rollback
      m_Sql.AbortTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      m_bError = true;
      m_Sql.CompleteTransaction();
      /* gMsgImp := 'Estrazione Dati terminata con errori.' // Messaggio Import */
      gMsgImp = "Estrazione Dati terminata con errori.";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000034status,0)) {
        m_Sql.SetTransactionStatus(nTry00000034status,cTry00000034msg);
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_inviosaldi_minmax_rap=null;
    CPResultSet Cursor_qbe_inviosaldi_rap=null;
    CPResultSet Cursor_aecanc=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_aetesta=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_jnarapbo=null;
    CPResultSet Cursor_aeannora=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Estrae Saldi per Rapporti Continuativi */
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      // * --- Select from qbe_inviosaldi_minmax_rap
      if (Cursor_qbe_inviosaldi_minmax_rap!=null)
        Cursor_qbe_inviosaldi_minmax_rap.Close();
      Cursor_qbe_inviosaldi_minmax_rap = new VQRHolder("qbe_inviosaldi_minmax_rap",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_inviosaldi_minmax_rap.Eof())) {
        /* _min := qbe_inviosaldi_minmax_rap->MINPRG */
        _min = CPLib.Round(Cursor_qbe_inviosaldi_minmax_rap.GetDouble("MINPRG"),0);
        /* _max := qbe_inviosaldi_minmax_rap->MAXPRG */
        _max = CPLib.Round(Cursor_qbe_inviosaldi_minmax_rap.GetDouble("MAXPRG"),0);
        /* _tot := qbe_inviosaldi_minmax_rap->TOTPRG */
        _tot = CPLib.Round(Cursor_qbe_inviosaldi_minmax_rap.GetDouble("TOTPRG"),0);
        Cursor_qbe_inviosaldi_minmax_rap.Next();
      }
      m_cConnectivityError = Cursor_qbe_inviosaldi_minmax_rap.ErrorMessage();
      Cursor_qbe_inviosaldi_minmax_rap.Close();
      // * --- End Select
      /* _mono := iif(_tot > 15000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,15000)?0:1),0);
      /* If _mono = 1 */
      if (CPLib.eqr(_mono,1)) {
        /* If _tot = 0 */
        if (CPLib.eqr(_tot,0)) {
          /* _cicli := 0 */
          _cicli = CPLib.Round(0,0);
        } else { // Else
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } // End If
      } else { // Else
        /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      } // End If
      /* _contacicli := 1 */
      _contacicli = CPLib.Round(1,0);
      /* gMsgImp := 'Lettura rapporti continuativi in corso ...' // Messaggio Import */
      gMsgImp = "Lettura rapporti continuativi in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _coint := 0 */
      _coint = CPLib.Round(0,0);
      /* _rapp := '' */
      _rapp = "";
      /* While _contacicli <= _cicli */
      while (CPLib.le(_contacicli,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
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
        /* gMsgImp := 'Lettura rapporti continuativi in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
        gMsgImp = "Lettura rapporti continuativi in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_inviosaldi_rap
          if (Cursor_qbe_inviosaldi_rap!=null)
            Cursor_qbe_inviosaldi_rap.Close();
          Cursor_qbe_inviosaldi_rap = new VQRHolder("qbe_inviosaldi_rap",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_inviosaldi_rap.Eof())) {
            /* _descrapp := '' */
            _descrapp = "";
            /* _deleted := 0 */
            _deleted = CPLib.Round(0,0);
            // * --- Select from aecanc
            m_cServer = m_Ctx.GetServer("aecanc");
            m_cPhName = m_Ctx.GetPhName("aecanc");
            if (Cursor_aecanc!=null)
              Cursor_aecanc.Close();
            Cursor_aecanc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select PROGRES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetString("RAPPORTO"),"?",0,0)+"  and  AFILE="+CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetString("AFILE"),"?",0,0)+"  and  APROG="+CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetString("APROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aecanc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_aecanc.Eof())) {
              /* _deleted := 1 */
              _deleted = CPLib.Round(1,0);
              Cursor_aecanc.Next();
            }
            m_cConnectivityError = Cursor_aecanc.ErrorMessage();
            Cursor_aecanc.Close();
            // * --- End Select
            /* If _deleted=0 */
            if (CPLib.eqr(_deleted,0)) {
              // * --- Read from anarapbo
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_inviosaldi_rap.GetString("RAPPORTO"));
              if (m_Ctx.IsSharedTemp("anarapbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _descrapp = Read_Cursor.GetString("DESCRAP");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_inviosaldi returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _descrapp = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_descrapp)) */
              if (CPLib.Empty(CPLib.LRTrim(_descrapp))) {
                // * --- Read from jnarapbo
                m_cServer = m_Ctx.GetServer("jnarapbo");
                m_cPhName = m_Ctx.GetPhName("jnarapbo");
                m_cSql = "";
                m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_inviosaldi_rap.GetString("RAPPORTO"));
                if (m_Ctx.IsSharedTemp("jnarapbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _descrapp = Read_Cursor.GetString("DESCRAP");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on jnarapbo into routine arrt_inviosaldi returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _descrapp = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
              /* _txterr := '' */
              _txterr = "";
              // * --- Insert into tmp_stprapporti from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stprapporti");
              m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stprapporti",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_inviosaldi",188,"00000067")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000067(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetDate("ADATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetDate("CDATA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("X","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_descrapp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stprapporti",true);
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
              /* _fileanno := '' */
              _fileanno = "";
              // * --- Read from aeinvio
              m_cServer = m_Ctx.GetServer("aeinvio");
              m_cPhName = m_Ctx.GetPhName("aeinvio");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_inviosaldi_rap.GetString("RAPPORTO"));
              m_cSql = m_cSql+" and CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_inviosaldi_rap.GetString("CONNESINT"));
              m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_anno,4,0),"C",4,0,m_cServer),m_cServer,CPLib.Str(w_anno,4,0));
              m_cSql = m_cSql+" and TIPO="+CPSql.SQLValueAdapter(CPLib.ToSQL("I","C",1,0,m_cServer),m_cServer,"I");
              if (m_Ctx.IsSharedTemp("aeinvio")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FILEANNO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _fileanno = Read_Cursor.GetString("FILEANNO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aeinvio into routine arrt_inviosaldi returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _fileanno = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* gMsgImp := 'Lettura dati soggetto con NDG -> '+qbe_inviosaldi_rap->CONNESINT // Messaggio Import */
              gMsgImp = "Lettura dati soggetto con NDG -> "+Cursor_qbe_inviosaldi_rap.GetString("CONNESINT");
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* If Empty(LRTrim(_fileanno)) or w_flgcod='S' */
              if (CPLib.Empty(CPLib.LRTrim(_fileanno)) || CPLib.eqr(w_flgcod,"S")) {
                /* _saldo := 0 */
                _saldo = CPLib.Round(0,0);
                /* _qta := 0 */
                _qta = CPLib.Round(0,0);
                /* _val := '' */
                _val = "";
                /* _unique := '' */
                _unique = "";
                // * --- Select from aetesta
                m_cServer = m_Ctx.GetServer("aetesta");
                m_cPhName = m_Ctx.GetPhName("aetesta");
                if (Cursor_aetesta!=null)
                  Cursor_aetesta.Close();
                Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aetesta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aetesta.Eof())) {
                  /* If aetesta->TIPOAG='99' and Empty(LRTrim(aetesta->DESCRI)) */
                  if (CPLib.eqr(Cursor_aetesta.GetString("TIPOAG"),"99") && CPLib.Empty(CPLib.LRTrim(Cursor_aetesta.GetString("DESCRI")))) {
                    /* _ok := 1 */
                    _ok = CPLib.Round(1,0);
                    // * --- Select from anarapbo
                    m_cServer = m_Ctx.GetServer("anarapbo");
                    m_cPhName = m_Ctx.GetPhName("anarapbo");
                    if (Cursor_anarapbo!=null)
                      Cursor_anarapbo.Close();
                    Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_anarapbo.Eof())) {
                      // * --- Write into aetesta from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("aetesta");
                      m_cPhName = m_Ctx.GetPhName("aetesta");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviosaldi",188,"00000074")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Upper(CPLib.Left(Cursor_anarapbo.GetString("DESCRAP"),24)),"C",24,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_anarapbo.GetString("RAPPORTO"))+"";
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
                      /* _ok := 0 */
                      _ok = CPLib.Round(0,0);
                      Cursor_anarapbo.Next();
                    }
                    m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
                    Cursor_anarapbo.Close();
                    // * --- End Select
                    /* If _ok=1 */
                    if (CPLib.eqr(_ok,1)) {
                      // * --- Select from jnarapbo
                      m_cServer = m_Ctx.GetServer("jnarapbo");
                      m_cPhName = m_Ctx.GetPhName("jnarapbo");
                      if (Cursor_jnarapbo!=null)
                        Cursor_jnarapbo.Close();
                      Cursor_jnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_jnarapbo.Eof())) {
                        // * --- Write into aetesta from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("aetesta");
                        m_cPhName = m_Ctx.GetPhName("aetesta");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_inviosaldi",188,"00000078")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(CPLib.Upper(CPLib.Left(Cursor_jnarapbo.GetString("DESCRAP"),24)),"C",24,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_jnarapbo.GetString("RAPPORTO"))+"";
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
                        /* _ok := 0 */
                        _ok = CPLib.Round(0,0);
                        Cursor_jnarapbo.Next();
                      }
                      m_cConnectivityError = Cursor_jnarapbo.ErrorMessage();
                      Cursor_jnarapbo.Close();
                      // * --- End Select
                    } // End If
                    /* If _ok=1 */
                    if (CPLib.eqr(_ok,1)) {
                      /* _txterr := _txterr + 'Manca descrizione rapporto (obbligatoria per tipoag = 99)' + NL */
                      _txterr = _txterr+"Manca descrizione rapporto (obbligatoria per tipoag = 99)"+"\n";
                    } // End If
                  } // End If
                  /* If Empty(aetesta->CAB) and At(aetesta->TIPOAG,'|01|02|03|12|13') <> 0 */
                  if (CPLib.Empty(Cursor_aetesta.GetString("CAB")) && CPLib.ne(CPLib.At(Cursor_aetesta.GetString("TIPOAG"),"|01|02|03|12|13"),0)) {
                    /* _txterr := _txterr + 'Manca CAB (obbligatorio per tipoag = 01 o 02 o 03 o 12 o 13)' + NL */
                    _txterr = _txterr+"Manca CAB (obbligatorio per tipoag = 01 o 02 o 03 o 12 o 13)"+"\n";
                  } // End If
                  /* If Empty(aetesta->VALUTA) and At(aetesta->TIPOAG,'|01|02|03|04|05|06|07|09|10|14|15|23|24') <> 0 */
                  if (CPLib.Empty(Cursor_aetesta.GetString("VALUTA")) && CPLib.ne(CPLib.At(Cursor_aetesta.GetString("TIPOAG"),"|01|02|03|04|05|06|07|09|10|14|15|23|24"),0)) {
                    /* _ok := 1 */
                    _ok = CPLib.Round(1,0);
                    // * --- Select from anarapbo
                    m_cServer = m_Ctx.GetServer("anarapbo");
                    m_cPhName = m_Ctx.GetPhName("anarapbo");
                    if (Cursor_anarapbo!=null)
                      Cursor_anarapbo.Close();
                    Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DESCRAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_anarapbo.Eof())) {
                      // * --- Write into aetesta from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("aetesta");
                      m_cPhName = m_Ctx.GetPhName("aetesta");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_inviosaldi",188,"00000081")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(Cursor_anarapbo.GetString("VALUTA"),"C",3,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_anarapbo.GetString("RAPPORTO"))+"";
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
                      /* _ok := 0 */
                      _ok = CPLib.Round(0,0);
                      Cursor_anarapbo.Next();
                    }
                    m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
                    Cursor_anarapbo.Close();
                    // * --- End Select
                    /* If _ok=1 */
                    if (CPLib.eqr(_ok,1)) {
                      // * --- Select from jnarapbo
                      m_cServer = m_Ctx.GetServer("jnarapbo");
                      m_cPhName = m_Ctx.GetPhName("jnarapbo");
                      if (Cursor_jnarapbo!=null)
                        Cursor_jnarapbo.Close();
                      Cursor_jnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DESCRAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_jnarapbo.Eof())) {
                        // * --- Write into aetesta from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("aetesta");
                        m_cPhName = m_Ctx.GetPhName("aetesta");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_inviosaldi",188,"00000085")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(Cursor_anarapbo.GetString("VALUTA"),"C",3,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_jnarapbo.GetString("RAPPORTO"))+"";
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
                        /* _ok := 0 */
                        _ok = CPLib.Round(0,0);
                        Cursor_jnarapbo.Next();
                      }
                      m_cConnectivityError = Cursor_jnarapbo.ErrorMessage();
                      Cursor_jnarapbo.Close();
                      // * --- End Select
                    } // End If
                    /* If _ok=1 */
                    if (CPLib.eqr(_ok,1)) {
                      /* _txterr := _txterr + 'Manca valuta (obblig. per tipoag = 01,02,03,04,05,06,07,09,10,14,15,23 o 24)' + NL */
                      _txterr = _txterr+"Manca valuta (obblig. per tipoag = 01,02,03,04,05,06,07,09,10,14,15,23 o 24)"+"\n";
                    } // End If
                  } // End If
                  /* If Empty(LRTrim(aetesta->UNIQUECODE)) or w_flgcod='S' */
                  if (CPLib.Empty(CPLib.LRTrim(Cursor_aetesta.GetString("UNIQUECODE"))) || CPLib.eqr(w_flgcod,"S")) {
                    /* _unique := LRTrim(gIntemediario)+"_"+Str(w_anno,4,0)+"_"+arfn_agechar(aetesta->RAPPORTO,'_') */
                    _unique = CPLib.LRTrim(gIntemediario)+"_"+CPLib.Str(w_anno,4,0)+"_"+arfn_agecharR.Make(m_Ctx,this).Run(Cursor_aetesta.GetString("RAPPORTO"),"_");
                    /* _unique := Strtran(_unique," ","_") */
                    _unique = CPLib.Strtran(_unique," ","_");
                    /* _unique := Strtran(_unique,"-","_") */
                    _unique = CPLib.Strtran(_unique,"-","_");
                    // * --- Write into aetesta from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aetesta");
                    m_cPhName = m_Ctx.GetPhName("aetesta");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_inviosaldi",188,"0000008D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"UNIQUECODE = "+CPLib.ToSQL(_unique,"C",50,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aetesta.GetString("RAPPORTO"))+"";
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
                  /* _idb := '' */
                  _idb = "";
                  // * --- Read from aeannora
                  m_cServer = m_Ctx.GetServer("aeannora");
                  m_cPhName = m_Ctx.GetPhName("aeannora");
                  m_cSql = "";
                  m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_inviosaldi_rap.GetString("RAPPORTO"));
                  m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"C",4,0,m_cServer),m_cServer,w_anno);
                  if (m_Ctx.IsSharedTemp("aeannora")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _idb = Read_Cursor.GetString("IDBASE");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on aeannora into routine arrt_inviosaldi returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _idb = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Empty(LRTrim(_idb)) */
                  if (CPLib.Empty(CPLib.LRTrim(_idb))) {
                    // * --- Insert into aeannora from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aeannora");
                    m_cPhName = m_Ctx.GetPhName("aeannora");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeannora",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_inviosaldi",188,"00000091")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000091(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeannora",true);
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
                  /* If At(aetesta->TIPOAG,'|01|02|03|04|05|06|07|09|10|14|15|23|24') <> 0 */
                  if (CPLib.ne(CPLib.At(Cursor_aetesta.GetString("TIPOAG"),"|01|02|03|04|05|06|07|09|10|14|15|23|24"),0)) {
                    // * --- Select from aeannora
                    m_cServer = m_Ctx.GetServer("aeannora");
                    m_cPhName = m_Ctx.GetPhName("aeannora");
                    if (Cursor_aeannora!=null)
                      Cursor_aeannora.Close();
                    Cursor_aeannora = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0)+"  and  ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer, m_oParameters),m_cServer,w_anno)+" "+")"+(m_Ctx.IsSharedTemp("aeannora")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_aeannora.Eof())) {
                      /* If aeannora->IMPORTO1+aeannora->IMPORTO2+aeannora->IMPORTO3+aeannora->IMPORTO4+aeannora->IMPORTO5 = 0 */
                      if (CPLib.eqr(Cursor_aeannora.GetDouble("IMPORTO1")+Cursor_aeannora.GetDouble("IMPORTO2")+Cursor_aeannora.GetDouble("IMPORTO3")+Cursor_aeannora.GetDouble("IMPORTO4")+Cursor_aeannora.GetDouble("IMPORTO5"),0)) {
                        /* _txterr := _txterr + "Inserire saldo per tipo = " + aetesta->TIPOAG + NL */
                        _txterr = _txterr+"Inserire saldo per tipo = "+Cursor_aetesta.GetString("TIPOAG")+"\n";
                      } // End If
                      Cursor_aeannora.Next();
                    }
                    m_cConnectivityError = Cursor_aeannora.ErrorMessage();
                    Cursor_aeannora.Close();
                    // * --- End Select
                  } // End If
                  /* If not(Empty(LRTrim(_txterr))) */
                  if ( ! (CPLib.Empty(CPLib.LRTrim(_txterr)))) {
                    // * --- Insert into tmp_esitosaldi from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_esitosaldi");
                    m_cPhName = m_Ctx.GetPhName("tmp_esitosaldi");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitosaldi",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_inviosaldi",188,"00000097")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000097(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_rap.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Manca descrizione rapporto (obbligatoria per tipoag = 99)","?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitosaldi",true);
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
                  Cursor_aetesta.Next();
                }
                m_cConnectivityError = Cursor_aetesta.ErrorMessage();
                Cursor_aetesta.Close();
                // * --- End Select
                /* If _rapp = qbe_inviosaldi_rap->RAPPORTO */
                if (CPLib.eqr(_rapp,Cursor_qbe_inviosaldi_rap.GetString("RAPPORTO"))) {
                  /* _coint := _coint + 1 */
                  _coint = CPLib.Round(_coint+1,0);
                } else { // Else
                  /* _rapp := qbe_inviosaldi_rap->RAPPORTO */
                  _rapp = Cursor_qbe_inviosaldi_rap.GetString("RAPPORTO");
                } // End If
              } // End If
            } else { // Else
            } // End If
            Cursor_qbe_inviosaldi_rap.Next();
          }
          m_cConnectivityError = Cursor_qbe_inviosaldi_rap.ErrorMessage();
          Cursor_qbe_inviosaldi_rap.Close();
          // * --- End Select
        } else { // Else
          /* gMsgImp := 'Lettura rapporti continuativi in corso ...' // Messaggio Import */
          gMsgImp = "Lettura rapporti continuativi in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacicli := _contacicli+1 */
        _contacicli = CPLib.Round(_contacicli+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_inviosaldi_minmax_rap!=null)
          Cursor_qbe_inviosaldi_minmax_rap.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_inviosaldi_rap!=null)
          Cursor_qbe_inviosaldi_rap.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aecanc!=null)
          Cursor_aecanc.Close();
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
        if (Cursor_aetesta!=null)
          Cursor_aetesta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jnarapbo!=null)
          Cursor_jnarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeannora!=null)
          Cursor_aeannora.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_inviosaldi_minmax_ope=null;
    CPResultSet Cursor_qbe_inviosaldi_ope=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Estrae Saldi per Operazioni ExtraConto */
      /* _contaerr := 0 */
      _contaerr = CPLib.Round(0,0);
      /* _contarig := 0 */
      _contarig = CPLib.Round(0,0);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      /* _contarec := 0 */
      _contarec = CPLib.Round(0,0);
      // * --- Select from qbe_inviosaldi_minmax_ope
      if (Cursor_qbe_inviosaldi_minmax_ope!=null)
        Cursor_qbe_inviosaldi_minmax_ope.Close();
      Cursor_qbe_inviosaldi_minmax_ope = new VQRHolder("qbe_inviosaldi_minmax_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_inviosaldi_minmax_ope.Eof())) {
        /* _min := qbe_inviosaldi_minmax_ope->MINPRG */
        _min = CPLib.Round(Cursor_qbe_inviosaldi_minmax_ope.GetDouble("MINPRG"),0);
        /* _max := qbe_inviosaldi_minmax_ope->MAXPRG */
        _max = CPLib.Round(Cursor_qbe_inviosaldi_minmax_ope.GetDouble("MAXPRG"),0);
        /* _tot := qbe_inviosaldi_minmax_ope->TOTPRG */
        _tot = CPLib.Round(Cursor_qbe_inviosaldi_minmax_ope.GetDouble("TOTPRG"),0);
        Cursor_qbe_inviosaldi_minmax_ope.Next();
      }
      m_cConnectivityError = Cursor_qbe_inviosaldi_minmax_ope.ErrorMessage();
      Cursor_qbe_inviosaldi_minmax_ope.Close();
      // * --- End Select
      /* _mono := iif(_tot > 15000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,15000)?0:1),0);
      /* If _mono = 1 */
      if (CPLib.eqr(_mono,1)) {
        /* If _tot = 0 */
        if (CPLib.eqr(_tot,0)) {
          /* _cicli := 0 */
          _cicli = CPLib.Round(0,0);
        } else { // Else
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } // End If
      } else { // Else
        /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      } // End If
      /* _contacicli := 1 */
      _contacicli = CPLib.Round(1,0);
      /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
      gMsgImp = "Lettura operazioni extraconto in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* While _contacicli <= _cicli */
      while (CPLib.le(_contacicli,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
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
        /* gMsgImp := 'Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
        gMsgImp = "Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_inviosaldi_ope
          if (Cursor_qbe_inviosaldi_ope!=null)
            Cursor_qbe_inviosaldi_ope.Close();
          Cursor_qbe_inviosaldi_ope = new VQRHolder("qbe_inviosaldi_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_inviosaldi_ope.Eof())) {
            /* _contarec := _contarec + 1 */
            _contarec = CPLib.Round(_contarec+1,0);
            /* _deleted := 0 */
            _deleted = CPLib.Round(0,0);
            /* gMsgImp := 'Lettura dati soggetto con NDG -> '+LRTrim(qbe_inviosaldi_ope->CONNESINT)+ " - Record N. " + LRTrim(Str(_contarec,10,0)) + " su "+LRTrim(Str(_tot,10,0)) // Messaggio Import */
            gMsgImp = "Lettura dati soggetto con NDG -> "+CPLib.LRTrim(Cursor_qbe_inviosaldi_ope.GetString("CONNESINT"))+" - Record N. "+CPLib.LRTrim(CPLib.Str(_contarec,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_tot,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If Empty(qbe_inviosaldi_ope->PROGRES) */
            if (CPLib.Empty(Cursor_qbe_inviosaldi_ope.GetString("PROGRES"))) {
              /* _txterr := '' */
              _txterr = "";
              /* If Empty(LRTrim(qbe_inviosaldi_ope->FILEANNO)) or w_flgcod='S' */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_inviosaldi_ope.GetString("FILEANNO"))) || CPLib.eqr(w_flgcod,"S")) {
                /* _saldo := 0 */
                _saldo = CPLib.Round(0,0);
                /* _qta := 0 */
                _qta = CPLib.Round(0,0);
                /* _val := '' */
                _val = "";
                /* _unique := '' */
                _unique = "";
                /* _qta := qbe_inviosaldi_ope->QUANTITAX */
                _qta = CPLib.Round(Cursor_qbe_inviosaldi_ope.GetDouble("QUANTITAX"),0);
                /* If Empty(qbe_inviosaldi_ope->VALUTA) and Empty(qbe_inviosaldi_ope->VALUTAX) */
                if (CPLib.Empty(Cursor_qbe_inviosaldi_ope.GetString("VALUTA")) && CPLib.Empty(Cursor_qbe_inviosaldi_ope.GetString("VALUTAX"))) {
                  /* _txterr := _txterr+ 'Manca valuta (obblig. per operaz. extraconto)'+NL */
                  _txterr = _txterr+"Manca valuta (obblig. per operaz. extraconto)"+"\n";
                } // End If
                /* If Empty(qbe_inviosaldi_ope->SALDO) or Empty(qbe_inviosaldi_ope->QUANTITA) */
                if (CPLib.Empty(Cursor_qbe_inviosaldi_ope.GetDouble("SALDO")) || CPLib.Empty(Cursor_qbe_inviosaldi_ope.GetDouble("QUANTITA"))) {
                  /* _ok := 0 */
                  _ok = CPLib.Round(0,0);
                  /* If not(Empty(qbe_inviosaldi_ope->COLLEG)) */
                  if ( ! (CPLib.Empty(Cursor_qbe_inviosaldi_ope.GetString("COLLEG")))) {
                    /* If not(Empty(qbe_inviosaldi_ope->SALDOX)) */
                    if ( ! (CPLib.Empty(Cursor_qbe_inviosaldi_ope.GetDouble("SALDOX")))) {
                      /* _ok := 1 */
                      _ok = CPLib.Round(1,0);
                      /* If Empty(qbe_inviosaldi_ope->QUANTITA) and _qta=0 */
                      if (CPLib.Empty(Cursor_qbe_inviosaldi_ope.GetDouble("QUANTITA")) && CPLib.eqr(_qta,0)) {
                        /* _qta := 1 */
                        _qta = CPLib.Round(1,0);
                      } // End If
                    } // End If
                  } // End If
                  /* If _ok=0 */
                  if (CPLib.eqr(_ok,0)) {
                    /* _txterr := _txterr+ 'Manca saldo / numero operazioni anno (obblig. x op. extraconto)'+NL */
                    _txterr = _txterr+"Manca saldo / numero operazioni anno (obblig. x op. extraconto)"+"\n";
                  } // End If
                } // End If
                /* If Empty(qbe_inviosaldi_ope->UNIQUECODE) or w_flgcod='S' */
                if (CPLib.Empty(Cursor_qbe_inviosaldi_ope.GetString("UNIQUECODE")) || CPLib.eqr(w_flgcod,"S")) {
                  /* _unique := LRTrim(gIntemediario)+"_"+Str(w_anno,4,0)+"_"+arfn_agechar(qbe_inviosaldi_ope->CONNESINT,'_') */
                  _unique = CPLib.LRTrim(gIntemediario)+"_"+CPLib.Str(w_anno,4,0)+"_"+arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_inviosaldi_ope.GetString("CONNESINT"),"_");
                  /* _unique := Strtran(_unique," ","_") */
                  _unique = CPLib.Strtran(_unique," ","_");
                  /* _unique := Strtran(_unique,"-","_") */
                  _unique = CPLib.Strtran(_unique,"-","_");
                } else { // Else
                  /* _unique := qbe_inviosaldi_ope->UNIQUECODE */
                  _unique = Cursor_qbe_inviosaldi_ope.GetString("UNIQUECODE");
                } // End If
                /* If not(Empty(LRTrim(_txterr))) */
                if ( ! (CPLib.Empty(CPLib.LRTrim(_txterr)))) {
                  /* _contaerr := _contaerr + 1 */
                  _contaerr = CPLib.Round(_contaerr+1,0);
                  /* If w_flgnum='S' */
                  if (CPLib.eqr(w_flgnum,"S")) {
                    // * --- Insert into tmp_esitosaldi from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_esitosaldi");
                    m_cPhName = m_Ctx.GetPhName("tmp_esitosaldi");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitosaldi",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_inviosaldi",188,"000000D9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000D9(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_txterr,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitosaldi",true);
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
                    /* mcErrori.AppendBlank() */
                    mcErrori.AppendBlank();
                    /* mcErrori.TIPO := 'O' */
                    mcErrori.row.TIPO = "O";
                    /* mcErrori.RAPPORTO := qbe_inviosaldi_ope->RAPPORTO */
                    mcErrori.row.RAPPORTO = Cursor_qbe_inviosaldi_ope.GetString("RAPPORTO");
                    /* mcErrori.CONNESINT := qbe_inviosaldi_ope->CONNESINT */
                    mcErrori.row.CONNESINT = Cursor_qbe_inviosaldi_ope.GetString("CONNESINT");
                    /* mcErrori.TXTERR := _txterr */
                    mcErrori.row.TXTERR = _txterr;
                    /* mcErrori.SaveRow() */
                    mcErrori.SaveRow();
                  } // End If
                } else { // Else
                  /* _contarig := _contarig + 1 */
                  _contarig = CPLib.Round(_contarig+1,0);
                  /* If w_flgnum='S' */
                  if (CPLib.eqr(w_flgnum,"S")) {
                    // * --- Insert into tmp_stprapporti from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stprapporti");
                    m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stprapporti",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_inviosaldi",188,"000000E2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000E2(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetDate("ADATA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("X","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stprapporti",true);
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
                    // * --- Write into aeoprig from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aeoprig");
                    m_cPhName = m_Ctx.GetPhName("aeoprig");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_inviosaldi",188,"000000E3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"UNIQUECODE = "+CPLib.ToSQL(_unique,"C",50,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ANNO = "+CPLib.ToSQL(CPLib.Str(w_anno,4,0),"C",4,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SALDO = "+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetDouble("SALDOX"),"N",17,0)+", ";
                    m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("VALUTAX"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"QUANTITA = "+CPLib.ToSQL(_qta,"N",6,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviosaldi_ope.GetString("IDBASE"))+"";
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
                  } else { // Else
                    /* mcStpAgg.AppendBlank() */
                    mcStpAgg.AppendBlank();
                    /* mcStpAgg.TIPORAP := 'O' */
                    mcStpAgg.row.TIPORAP = "O";
                    /* mcStpAgg.RAPPORTO := qbe_inviosaldi_ope->RAPPORTO */
                    mcStpAgg.row.RAPPORTO = Cursor_qbe_inviosaldi_ope.GetString("RAPPORTO");
                    /* mcStpAgg.CONNESINT := qbe_inviosaldi_ope->CONNESINT */
                    mcStpAgg.row.CONNESINT = Cursor_qbe_inviosaldi_ope.GetString("CONNESINT");
                    /* mcStpAgg.DATAINI := qbe_inviosaldi_ope->ADATA */
                    mcStpAgg.row.DATAINI = Cursor_qbe_inviosaldi_ope.GetDate("ADATA");
                    /* mcStpAgg.IDEREG := 'X' */
                    mcStpAgg.row.IDEREG = "X";
                    /* mcStpAgg.IDBASE := qbe_inviosaldi_ope->IDBASE */
                    mcStpAgg.row.IDBASE = Cursor_qbe_inviosaldi_ope.GetString("IDBASE");
                    /* mcStpAgg.UNIQUE := _unique */
                    mcStpAgg.row.UNIQUE = _unique;
                    /* mcStpAgg.ANNO := Str(w_anno,4,0) */
                    mcStpAgg.row.ANNO = CPLib.Str(w_anno,4,0);
                    /* mcStpAgg.SALDO := qbe_inviosaldi_ope->SALDOX */
                    mcStpAgg.row.SALDO = Cursor_qbe_inviosaldi_ope.GetDouble("SALDOX");
                    /* mcStpAgg.QUANTITA := _qta */
                    mcStpAgg.row.QUANTITA = _qta;
                    /* mcStpAgg.VALUTA := qbe_inviosaldi_ope->VALUTAX */
                    mcStpAgg.row.VALUTA = Cursor_qbe_inviosaldi_ope.GetString("VALUTAX");
                    /* mcStpAgg.SaveRow() */
                    mcStpAgg.SaveRow();
                  } // End If
                } // End If
              } // End If
            } // End If
            Cursor_qbe_inviosaldi_ope.Next();
          }
          m_cConnectivityError = Cursor_qbe_inviosaldi_ope.ErrorMessage();
          Cursor_qbe_inviosaldi_ope.Close();
          // * --- End Select
        } else { // Else
          /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
          gMsgImp = "Lettura operazioni extraconto in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacicli := _contacicli+1 */
        _contacicli = CPLib.Round(_contacicli+1,0);
      } // End While
      /* If w_flgnum='N' */
      if (CPLib.eqr(w_flgnum,"N")) {
        /* gMsgImp := 'Attendere .. Scrittura Dati ...' // Messaggio Import */
        gMsgImp = "Attendere .. Scrittura Dati ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If _contaerr > 0 */
        if (CPLib.gt(_contaerr,0)) {
          for (MemoryCursorRow_mcerrsaldi_mcrdef rwErrori : mcErrori._iterable_()) {
            // * --- Insert into tmp_esitosaldi from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_esitosaldi");
            m_cPhName = m_Ctx.GetPhName("tmp_esitosaldi");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitosaldi",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_inviosaldi",188,"000000F7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000F7(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwErrori.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwErrori.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwErrori.CONNESINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwErrori.TXTERR,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitosaldi",true);
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
          }
        } // End If
        /* If _contarig > 0 */
        if (CPLib.gt(_contarig,0)) {
          for (MemoryCursorRow_mcstpsaldi_mcrdef rwStpAgg : mcStpAgg._iterable_()) {
            // * --- Insert into tmp_stprapporti from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stprapporti");
            m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stprapporti",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_inviosaldi",188,"000000FA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000FA(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwStpAgg.TIPORAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwStpAgg.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwStpAgg.CONNESINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwStpAgg.DATAINI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwStpAgg.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stprapporti",true);
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
            // * --- Write into aeoprig from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aeoprig");
            m_cPhName = m_Ctx.GetPhName("aeoprig");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_inviosaldi",188,"000000FB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"UNIQUECODE = "+CPLib.ToSQL(rwStpAgg.UNIQUE,"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(rwStpAgg.CONNESINT,"C",25,0,m_cServer)+", ";
            m_cSql = m_cSql+"ANNO = "+CPLib.ToSQL(rwStpAgg.ANNO,"C",4,0,m_cServer)+", ";
            m_cSql = m_cSql+"SALDO = "+CPLib.ToSQL(rwStpAgg.SALDO,"N",17,0)+", ";
            m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(rwStpAgg.VALUTA,"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"QUANTITA = "+CPLib.ToSQL(rwStpAgg.QUANTITA,"N",6,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rwStpAgg.IDBASE,"?",0,0,m_cServer),m_cServer,rwStpAgg.IDBASE)+"";
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
          }
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_qbe_inviosaldi_minmax_ope!=null)
          Cursor_qbe_inviosaldi_minmax_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_inviosaldi_ope!=null)
          Cursor_qbe_inviosaldi_ope.Close();
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
      m_Caller.SetNumber("anno","N",4,0,w_anno);
      m_Caller.SetDate("a_data","D",8,0,w_a_data);
      m_Caller.SetDate("dadata","D",8,0,w_dadata);
      m_Caller.SetString("flgcod","C",1,0,w_flgcod);
      m_Caller.SetString("flgstp","C",1,0,w_flgstp);
      m_Caller.SetString("flgnum","C",1,0,w_flgnum);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_inviosaldiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_inviosaldiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_anno = m_Caller.GetNumber("anno","N",4,0);
    w_a_data = m_Caller.GetDate("a_data","D",8,0);
    w_dadata = m_Caller.GetDate("dadata","D",8,0);
    w_flgcod = m_Caller.GetString("flgcod","C",1,0);
    w_flgstp = m_Caller.GetString("flgstp","C",1,0);
    w_flgnum = m_Caller.GetString("flgnum","C",1,0);
    _min = 0;
    _max = 0;
    _tot = 0;
    _mono = 0;
    _cicli = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _saldo = 0;
    _qta = 0;
    _val = CPLib.Space(3);
    _unique = CPLib.Space(50);
    _coint = 0;
    _rapp = CPLib.Space(25);
    _ok = 0;
    _idb = CPLib.Space(10);
    _collopex = CPLib.Space(16);
    _descrapp = CPLib.Space(50);
    _fileanno = CPLib.Space(50);
    _deleted = 0;
    _txterr = "";
    _contarec = 0;
    _contaerr = 0;
    _contarig = 0;
    mcErrori = new MemoryCursor_mcerrsaldi_mcrdef();
    rwErrori = new MemoryCursorRow_mcerrsaldi_mcrdef();
    mcStpAgg = new MemoryCursor_mcstpsaldi_mcrdef();
    rwStpAgg = new MemoryCursorRow_mcstpsaldi_mcrdef();
    _nomerep = "";
    _report = null;
    bReport = false;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_inviosaldi_minmax_rap,qbe_inviosaldi_rap,qbe_inviosaldi_minmax_ope,qbe_inviosaldi_ope,
  public static final String m_cVQRList = ",qbe_inviosaldi_minmax_rap,qbe_inviosaldi_rap,qbe_inviosaldi_minmax_ope,qbe_inviosaldi_ope,";
  // ENTITY_BATCHES: ,arfn_agechar,
  public static final String i_InvokedRoutines = ",arfn_agechar,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000067(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stprapporti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000091(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeannora",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000097(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTEST,";
    p_cSql = p_cSql+"TXTERR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitosaldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTEST,";
    p_cSql = p_cSql+"TXTERR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitosaldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stprapporti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTEST,";
    p_cSql = p_cSql+"TXTERR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitosaldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000FA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stprapporti",true);
    return p_cSql;
  }
}
