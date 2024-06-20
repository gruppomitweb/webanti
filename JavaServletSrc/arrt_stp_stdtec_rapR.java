// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_stp_stdtec_rapR implements CallerWithObjs {
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
  public String m_cPhName_tmp_stpoperazioni;
  public String m_cServer_tmp_stpoperazioni;
  public String m_cPhName_tmp_soggettioper;
  public String m_cServer_tmp_soggettioper;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
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
  public String pAUI;
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public String w_daRapporto;
  public String w_aRapporto;
  public String w_daCodDip;
  public String w_aCodDip;
  public String _nomerep;
  public ReportLibrary _report;
  public boolean bReport;
  public String _id;
  public String _idrep;
  public double _conta;
  public String _numsto;
  public String w_c_dadata;
  public String w_c_adata;
  public String xProg;
  public String lReport;
  public double _avanza;
  public String gDescAzi;
  public String gAzienda;
  public String gPathApp;
  public String gUrlApp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_stp_stdtec_rapR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stp_stdtec_rap",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
      m_cPhName_tmp_stpoperazioni = p_ContextObject.GetPhName("tmp_stpoperazioni");
      if (m_cPhName_tmp_stpoperazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stpoperazioni = m_cPhName_tmp_stpoperazioni+" "+m_Ctx.GetWritePhName("tmp_stpoperazioni");
      }
      m_cServer_tmp_stpoperazioni = p_ContextObject.GetServer("tmp_stpoperazioni");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_soggettioper")) {
      m_cPhName_tmp_soggettioper = p_ContextObject.GetPhName("tmp_soggettioper");
      if (m_cPhName_tmp_soggettioper.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_soggettioper = m_cPhName_tmp_soggettioper+" "+m_Ctx.GetWritePhName("tmp_soggettioper");
      }
      m_cServer_tmp_soggettioper = p_ContextObject.GetServer("tmp_soggettioper");
    }
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_avanza",p_cVarName)) {
      return _avanza;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_stp_stdtec_rap";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("daRapporto",p_cVarName)) {
      return w_daRapporto;
    }
    if (CPLib.eqr("aRapporto",p_cVarName)) {
      return w_aRapporto;
    }
    if (CPLib.eqr("daCodDip",p_cVarName)) {
      return w_daCodDip;
    }
    if (CPLib.eqr("aCodDip",p_cVarName)) {
      return w_aCodDip;
    }
    if (CPLib.eqr("pAUI",p_cVarName)) {
      return pAUI;
    }
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      return _nomerep;
    }
    if (CPLib.eqr("_id",p_cVarName)) {
      return _id;
    }
    if (CPLib.eqr("_idrep",p_cVarName)) {
      return _idrep;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      return _numsto;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      return w_c_dadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("xProg",p_cVarName)) {
      return xProg;
    }
    if (CPLib.eqr("lReport",p_cVarName)) {
      return lReport;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
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
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_avanza",p_cVarName)) {
      _avanza = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("daRapporto",p_cVarName)) {
      w_daRapporto = value;
      return;
    }
    if (CPLib.eqr("aRapporto",p_cVarName)) {
      w_aRapporto = value;
      return;
    }
    if (CPLib.eqr("daCodDip",p_cVarName)) {
      w_daCodDip = value;
      return;
    }
    if (CPLib.eqr("aCodDip",p_cVarName)) {
      w_aCodDip = value;
      return;
    }
    if (CPLib.eqr("pAUI",p_cVarName)) {
      pAUI = value;
      return;
    }
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      _nomerep = value;
      return;
    }
    if (CPLib.eqr("_id",p_cVarName)) {
      _id = value;
      return;
    }
    if (CPLib.eqr("_idrep",p_cVarName)) {
      _idrep = value;
      return;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      _numsto = value;
      return;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      w_c_dadata = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("xProg",p_cVarName)) {
      xProg = value;
      return;
    }
    if (CPLib.eqr("lReport",p_cVarName)) {
      lReport = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    /* pAUI Char(1) */
    /* w_DaDatOpe Date */
    /* w_ADatOpe Date */
    /* w_daRapporto Char(25) */
    /* w_aRapporto Char(16) */
    /* w_daCodDip Char(6) */
    /* w_aCodDip Char(6) */
    /* _nomerep Memo // Nome Stampa */
    /* _report Object(ReportLibrary) */
    /* bReport Bool */
    /* _id Char(6) */
    /* _idrep Char(10) */
    /* _conta Numeric(10, 0) */
    /* _numsto Char(15) */
    /* w_c_dadata Char(8) */
    /* w_c_adata Char(8) */
    /* xProg Char(15) */
    /* lReport Memo */
    /* _avanza Numeric(1, 0) */
    /* gDescAzi Char(70) // Descrizione Intermediario */
    /* gAzienda Char(10) // Azienda */
    /* gPathApp Char(80) // Path Applicazione */
    /* gUrlApp Char(80) // URL Applicazione */
    // * --- Drop temporary table tmp_stpoperazioni
    if (m_Ctx.IsSharedTemp("tmp_stpoperazioni")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_stpoperazioni");
    }
    // * --- Drop temporary table tmp_soggettioper
    if (m_Ctx.IsSharedTemp("tmp_soggettioper")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_soggettioper")) {
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_soggettioper");
    }
    // * --- Create temporary table tmp_stpoperazioni
    if (m_Ctx.IsSharedTemp("tmp_stpoperazioni")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_stpoperazioni");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_stpoperazioni");
    if ( ! (m_Ctx.IsSharedTemp("tmp_stpoperazioni"))) {
      m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stpoperazioni",m_cServer,"proto")),m_cPhName,"tmp_stpoperazioni",m_Ctx);
    }
    m_cPhName_tmp_stpoperazioni = m_cPhName;
    // * --- Create temporary table tmp_soggettioper
    if (m_Ctx.IsSharedTemp("tmp_soggettioper")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_soggettioper")) {
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_soggettioper");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_soggettioper");
    if ( ! (m_Ctx.IsSharedTemp("tmp_soggettioper"))) {
      m_cServer = m_Ctx.GetServer("tmp_soggettioper");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_soggettioper",m_cServer,"proto")),m_cPhName,"tmp_soggettioper",m_Ctx,new String[]{"IDBASE,TIPOPERS,CONNES"});
    }
    m_cPhName_tmp_soggettioper = m_cPhName;
    /* Lancio la stampa */
    /* w_c_dadata := iif(Empty(w_DaDatOpe),'',DateToChar(w_DaDatOpe)) */
    w_c_dadata = (CPLib.Empty(w_DaDatOpe)?"":CPLib.DateToChar(w_DaDatOpe));
    /* w_c_adata := iif(Empty(w_ADatOpe),'',DateToChar(w_ADatOpe)) */
    w_c_adata = (CPLib.Empty(w_ADatOpe)?"":CPLib.DateToChar(w_ADatOpe));
    /* _conta := 0 */
    _conta = CPLib.Round(0,0);
    /* Case pAUI='D' */
    if (CPLib.eqr(pAUI,"D")) {
      /* Exec "Rapporti AUI" Page 2:Page_2 */
      Page_2();
      /* Case pAUI='P' */
    } else if (CPLib.eqr(pAUI,"P")) {
      /* Exec " Rapporti Prov." Page 3:Page_3 */
      Page_3();
    } // End Case
    /* If not(Empty(LRTrim(lReport))) */
    if ( ! (CPLib.Empty(CPLib.LRTrim(lReport)))) {
      /* _idrep := LibreriaMit.UniqueId() */
      _idrep = LibreriaMit.UniqueId();
      /* bReport := _report.MergingPdf(lReport,LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/stampa_stdtec_rap_'+_idrep+'.pdf',True) */
      bReport = _report.MergingPdf(lReport,CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/stampa_stdtec_rap_"+_idrep+".pdf",true);
      /* Stop LRTrim(gUrlApp)+'/stampe_off/'+LRTrim(gAzienda)+'/stampa_stdtec_rap_'+_idrep+".pdf" */
      Forward f;
      f=new Forward(CPLib.LRTrim(gUrlApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/stampa_stdtec_rap_"+_idrep+".pdf",false,this,Forward.NoStatus,true);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } else { // Else
    } // End If
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_allrapopebo_tec=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_intermbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allrapopebo_tec
      if (Cursor_qbe_allrapopebo_tec!=null)
        Cursor_qbe_allrapopebo_tec.Close();
      Cursor_qbe_allrapopebo_tec = new VQRHolder("qbe_allrapopebo_tec",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allrapopebo_tec.Eof())) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _id := Right('000000'+LRTrim(Str(_conta,10,0)),6) */
        _id = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),6);
        // * --- Delete from tmp_stpoperazioni
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"0000002D")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        }
        // * --- Delete from tmp_soggettioper
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"0000002E")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        }
        // * --- Insert into tmp_stpoperazioni from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"0000002F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000002F(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetDate("DATAOPE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("DIPCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("DIPPRV"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("DIPCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetDate("DATAREG"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetDate("DATARETT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGLIRE1"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("VALUTA1"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
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
        /* Case qbe_allrapopebo_tec->TIPOOPRAP='25' or qbe_allrapopebo_tec->TIPOOPRAP='28' */
        if (CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"28")) {
          /* If qbe_allrapopebo_tec->TIPOOPRAP='25' */
          if (CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"25")) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If intestbo->DATAINI <= qbe_allrapopebo_tec->DATAOPE and (intestbo->DATAFINE >= qbe_allrapopebo_tec->DATAOPE or Empty(intestbo->DATAFINE)) */
              if (CPLib.le(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_allrapopebo_tec.GetDate("DATAOPE")) && (CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_allrapopebo_tec.GetDate("DATAOPE")) || CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")))) {
                /* xProg := '' */
                xProg = "";
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000035")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000035(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
                /* xProg := arfn_chkspers(intestbo->CODINTER,qbe_allrapopebo_tec->DATAREG) */
                xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_allrapopebo_tec.GetDate("DATAREG"));
                /* If Empty(LRTrim(xProg)) */
                if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000039")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"0000003B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            // * --- Select from delegabo
            m_cServer = m_Ctx.GetServer("delegabo");
            m_cPhName = m_Ctx.GetPhName("delegabo");
            if (Cursor_delegabo!=null)
              Cursor_delegabo.Close();
            Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_delegabo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If Empty(delegabo->CODINTER) */
              if (CPLib.Empty(Cursor_delegabo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                /* xProg := '' */
                xProg = "";
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000042")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000042(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
                /* xProg := arfn_chkspers(delegabo->CODINTER,qbe_allrapopebo_tec->DATAOPE) */
                xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),Cursor_qbe_allrapopebo_tec.GetDate("DATAOPE"));
                /* If Empty(LRTrim(xProg)) */
                if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000046")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"))+"";
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
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000048")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"))+"";
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
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_delegabo.Next();
            }
            m_cConnectivityError = Cursor_delegabo.ErrorMessage();
            Cursor_delegabo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If intestbo->DATAINI <= qbe_allrapopebo_tec->DATAOPE and (intestbo->DATAFINE >= qbe_allrapopebo_tec->DATAOPE or Empty(intestbo->DATAFINE)) */
              if (CPLib.le(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_allrapopebo_tec.GetDate("DATAOPE")) && (CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_allrapopebo_tec.GetDate("DATAOPE")) || CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")))) {
                /* xProg := '' */
                xProg = "";
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"0000004C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000004C(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
                /* xProg := arfn_chkspers(intestbo->CODINTER,qbe_allrapopebo_tec->DATAOPE) */
                xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_allrapopebo_tec.GetDate("DATAOPE"));
                /* If Empty(LRTrim(xProg)) */
                if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000050")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000052")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            // * --- Select from delegabo
            m_cServer = m_Ctx.GetServer("delegabo");
            m_cPhName = m_Ctx.GetPhName("delegabo");
            if (Cursor_delegabo!=null)
              Cursor_delegabo.Close();
            Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_delegabo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If Empty(delegabo->CODINTER) */
              if (CPLib.Empty(Cursor_delegabo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                /* xProg := '' */
                xProg = "";
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000059")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000059(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
                /* xProg := arfn_chkspers(delegabo->CODINTER,qbe_allrapopebo_tec->DATAOPE) */
                xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),Cursor_qbe_allrapopebo_tec.GetDate("DATAOPE"));
                /* If Empty(LRTrim(xProg)) */
                if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"0000005D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"))+"";
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
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"0000005F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"))+"";
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
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_delegabo.Next();
            }
            m_cConnectivityError = Cursor_delegabo.ErrorMessage();
            Cursor_delegabo.Close();
            // * --- End Select
          } // End If
          /* Case Right(qbe_allrapopebo_tec->TIPOOPRAP,1)='6' or qbe_allrapopebo_tec->TIPOOPRAP='38' */
        } else if (CPLib.eqr(CPLib.Right(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),1),"6") || CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"38")) {
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(intestbo->CODINTER) */
            if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000066")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000066(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
              /* xProg := arfn_chkspers(intestbo->CODINTER,qbe_allrapopebo_tec->DATAOPE) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_allrapopebo_tec.GetDate("DATAOPE"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"0000006A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"0000006C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
          /* Case qbe_allrapopebo_tec->TIPOOPRAP='31' or qbe_allrapopebo_tec->TIPOOPRAP='32' */
        } else if (CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"31") || CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"32")) {
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(intestbo->CODINTER) */
            if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000073")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000073(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
              /* xProg := arfn_chkspers(intestbo->CODINTER,iif(qbe_allrapopebo_tec->TIPOOPRAP='31',arfn_dateminus(qbe_allrapopebo_tec->DATAOPE,1),qbe_allrapopebo_tec->DATAOPE)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),(CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"31")?arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_allrapopebo_tec.GetDate("DATAOPE"),1):Cursor_qbe_allrapopebo_tec.GetDate("DATAOPE")));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000077")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000079")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
        } else { // Otherwise
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(intestbo->CODINTER) */
            if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000080")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000080(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
              /* xProg := arfn_chkspers(intestbo->CODINTER,qbe_allrapopebo_tec->DATAOPE) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_allrapopebo_tec.GetDate("DATAOPE"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000084")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000086")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
        } // End Case
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          // * --- Write into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000088")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
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
          }
          // * --- Write into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000089")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
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
          }
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* _report := ReportLibrary.GetReportLibrary() */
        _report = ReportLibrary.Make(m_Ctx).GetReportLibrary();
        /* _report.setParameterChar('w_daCodDip',w_daCodDip) */
        _report.setParameterChar("w_daCodDip",w_daCodDip);
        /* _report.setParameterChar('w_aCodDip',w_aCodDip) */
        _report.setParameterChar("w_aCodDip",w_aCodDip);
        /* _report.setParameterChar('w_daRapporto',w_daRapporto) */
        _report.setParameterChar("w_daRapporto",w_daRapporto);
        /* _report.setParameterChar('w_aRapporto',w_aRapporto) */
        _report.setParameterChar("w_aRapporto",w_aRapporto);
        /* _report.setParameterChar('w_c_dadata',w_c_dadata) */
        _report.setParameterChar("w_c_dadata",w_c_dadata);
        /* _report.setParameterChar('w_c_adata',w_c_adata) */
        _report.setParameterChar("w_c_adata",w_c_adata);
        /* _report.setParameterChar('DescAzi',gDescAzi) */
        _report.setParameterChar("DescAzi",gDescAzi);
        /* _report.setParameterChar('pAUI',pAUI) */
        _report.setParameterChar("pAUI",pAUI);
        /* _nomerep := 'arrp_stp_stdtec_rap;arrp_stp_stdtec_rap_1;arrp_stp_stdtec_rap_2' // Nome Stampa */
        _nomerep = "arrp_stp_stdtec_rap;arrp_stp_stdtec_rap_1;arrp_stp_stdtec_rap_2";
        /* bReport := _report.makeReportMergingPdf(_nomerep,LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/stampa_stdtec_rap_'+_id+'.pdf','A4','PORTRAIT','PDF') */
        bReport = _report.makeReportMergingPdf(_nomerep,CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/stampa_stdtec_rap_"+_id+".pdf","A4","PORTRAIT","PDF");
        /* lReport := lReport+LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/stampa_stdtec_rap_'+_id+'.pdf;' */
        lReport = lReport+CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/stampa_stdtec_rap_"+_id+".pdf;";
        Cursor_qbe_allrapopebo_tec.Next();
      }
      m_cConnectivityError = Cursor_qbe_allrapopebo_tec.ErrorMessage();
      Cursor_qbe_allrapopebo_tec.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allrapopebo_tec!=null)
          Cursor_qbe_allrapopebo_tec.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
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
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
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
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_allxapopebo_tec=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_xelegabo=null;
    CPResultSet Cursor_intermbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allxapopebo_tec
      if (Cursor_qbe_allxapopebo_tec!=null)
        Cursor_qbe_allxapopebo_tec.Close();
      Cursor_qbe_allxapopebo_tec = new VQRHolder("qbe_allxapopebo_tec",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allxapopebo_tec.Eof())) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _id := Right('000000'+LRTrim(Str(_conta,10,0)),6) */
        _id = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),6);
        // * --- Delete from tmp_stpoperazioni
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"00000099")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        }
        // * --- Delete from tmp_soggettioper
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"0000009A")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        }
        // * --- Insert into tmp_stpoperazioni from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"0000009B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000009B(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetDate("DATAOPE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("DIPCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("DIPPRV"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("DIPCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetDate("DATAREG"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetDate("DATARETT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGLIRE1"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("VALUTA1"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
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
        /* Case qbe_allxapopebo_tec->TIPOOPRAP='25' or qbe_allxapopebo_tec->TIPOOPRAP='28' */
        if (CPLib.eqr(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),"28")) {
          /* If qbe_allxapopebo_tec->TIPOOPRAP='25' */
          if (CPLib.eqr(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),"25")) {
            // * --- Select from xntestbo
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            if (Cursor_xntestbo!=null)
              Cursor_xntestbo.Close();
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestbo.Eof())) {
              /* If xntestbo->DATAINI <= qbe_allxapopebo_tec->DATAOPE and xntestbo->DATAFINE >= qbe_allxapopebo_tec->DATAOPE */
              if (CPLib.le(Cursor_xntestbo.GetDate("DATAINI"),Cursor_qbe_allxapopebo_tec.GetDate("DATAOPE")) && CPLib.ge(Cursor_xntestbo.GetDate("DATAFINE"),Cursor_qbe_allxapopebo_tec.GetDate("DATAOPE"))) {
                /* xProg := '' */
                xProg = "";
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000A1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000A1(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
                /* xProg := arfn_chkspers(xntestbo->CODINTER,qbe_allxapopebo_tec->DATAREG) */
                xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_allxapopebo_tec.GetDate("DATAREG"));
                /* If Empty(LRTrim(xProg)) */
                if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000A5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000A7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_xntestbo.Next();
            }
            m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
            Cursor_xntestbo.Close();
            // * --- End Select
            // * --- Select from xelegabo
            m_cServer = m_Ctx.GetServer("xelegabo");
            m_cPhName = m_Ctx.GetPhName("xelegabo");
            if (Cursor_xelegabo!=null)
              Cursor_xelegabo.Close();
            Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xelegabo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If Empty(xelegabo->CODINTER) */
              if (CPLib.Empty(Cursor_xelegabo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                /* xProg := '' */
                xProg = "";
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000AE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000AE(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
                /* xProg := arfn_chkspers(xelegabo->CODINTER,qbe_allxapopebo_tec->DATAREG) */
                xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xelegabo.GetString("CODINTER"),Cursor_qbe_allxapopebo_tec.GetDate("DATAREG"));
                /* If Empty(LRTrim(xProg)) */
                if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000B2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xelegabo.GetString("CODINTER"))+"";
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
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000B4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xelegabo.GetString("CODINTER"))+"";
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
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_xelegabo.Next();
            }
            m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
            Cursor_xelegabo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from xntestbo
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            if (Cursor_xntestbo!=null)
              Cursor_xntestbo.Close();
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestbo.Eof())) {
              /* If xntestbo->DATAINI <= qbe_allxapopebo_tec->DATAOPE and xntestbo->DATAFINE >= qbe_allxapopebo_tec->DATAOPE */
              if (CPLib.le(Cursor_xntestbo.GetDate("DATAINI"),Cursor_qbe_allxapopebo_tec.GetDate("DATAOPE")) && CPLib.ge(Cursor_xntestbo.GetDate("DATAFINE"),Cursor_qbe_allxapopebo_tec.GetDate("DATAOPE"))) {
                /* xProg := '' */
                xProg = "";
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000B8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000B8(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
                /* xProg := arfn_chkspers(xntestbo->CODINTER,qbe_allxapopebo_tec->DATAREG) */
                xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_allxapopebo_tec.GetDate("DATAREG"));
                /* If Empty(LRTrim(xProg)) */
                if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000BC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000BE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_xntestbo.Next();
            }
            m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
            Cursor_xntestbo.Close();
            // * --- End Select
            // * --- Select from xelegabo
            m_cServer = m_Ctx.GetServer("xelegabo");
            m_cPhName = m_Ctx.GetPhName("xelegabo");
            if (Cursor_xelegabo!=null)
              Cursor_xelegabo.Close();
            Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xelegabo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If Empty(xelegabo->CODINTER) */
              if (CPLib.Empty(Cursor_xelegabo.GetString("CODINTER"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                /* xProg := '' */
                xProg = "";
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000C5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000C5(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
                /* xProg := arfn_chkspers(xelegabo->CODINTER,qbe_allxapopebo_tec->DATAREG) */
                xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xelegabo.GetString("CODINTER"),Cursor_qbe_allxapopebo_tec.GetDate("DATAREG"));
                /* If Empty(LRTrim(xProg)) */
                if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000C9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xelegabo.GetString("CODINTER"))+"";
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
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000CB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                    m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xelegabo.GetString("CODINTER"))+"";
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
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_xelegabo.Next();
            }
            m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
            Cursor_xelegabo.Close();
            // * --- End Select
          } // End If
          /* Case Right(qbe_allxapopebo_tec->TIPOOPRAP,1)='6' or qbe_allxapopebo_tec->TIPOOPRAP='38' */
        } else if (CPLib.eqr(CPLib.Right(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),1),"6") || CPLib.eqr(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),"38")) {
          // * --- Select from xntestbo
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          if (Cursor_xntestbo!=null)
            Cursor_xntestbo.Close();
          Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xntestbo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(xntestbo->CODINTER) */
            if (CPLib.Empty(Cursor_xntestbo.GetString("CODINTER"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000D2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000D2(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
              /* xProg := arfn_chkspers(xntestbo->CODINTER,qbe_allxapopebo_tec->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_allxapopebo_tec.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000D6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000D8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_xntestbo.Next();
          }
          m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
          Cursor_xntestbo.Close();
          // * --- End Select
          /* Case qbe_allxapopebo_tec->TIPOOPRAP='31' or qbe_allxapopebo_tec->TIPOOPRAP='32' */
        } else if (CPLib.eqr(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),"31") || CPLib.eqr(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),"32")) {
          // * --- Select from xntestbo
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          if (Cursor_xntestbo!=null)
            Cursor_xntestbo.Close();
          Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xntestbo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(xntestbo->CODINTER) */
            if (CPLib.Empty(Cursor_xntestbo.GetString("CODINTER"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000DF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000DF(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
              /* xProg := arfn_chkspers(xntestbo->CODINTER,qbe_allxapopebo_tec->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_allxapopebo_tec.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000E3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000E5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_xntestbo.Next();
          }
          m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
          Cursor_xntestbo.Close();
          // * --- End Select
        } else { // Otherwise
          // * --- Select from xntestbo
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          if (Cursor_xntestbo!=null)
            Cursor_xntestbo.Close();
          Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xntestbo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(xntestbo->CODINTER) */
            if (CPLib.Empty(Cursor_xntestbo.GetString("CODINTER"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000EC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000EC(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
              /* xProg := arfn_chkspers(xntestbo->CODINTER,qbe_allxapopebo_tec->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_allxapopebo_tec.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000F0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000F2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_xntestbo.Next();
          }
          m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
          Cursor_xntestbo.Close();
          // * --- End Select
        } // End Case
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          // * --- Write into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000F4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
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
          }
          // * --- Write into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap",139,"000000F5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
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
          }
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* _report := ReportLibrary.GetReportLibrary() */
        _report = ReportLibrary.Make(m_Ctx).GetReportLibrary();
        /* _report.setParameterChar('w_daCodDip',w_daCodDip) */
        _report.setParameterChar("w_daCodDip",w_daCodDip);
        /* _report.setParameterChar('w_aCodDip',w_aCodDip) */
        _report.setParameterChar("w_aCodDip",w_aCodDip);
        /* _report.setParameterChar('w_daRapporto',w_daRapporto) */
        _report.setParameterChar("w_daRapporto",w_daRapporto);
        /* _report.setParameterChar('w_aRapporto',w_aRapporto) */
        _report.setParameterChar("w_aRapporto",w_aRapporto);
        /* _report.setParameterChar('w_c_dadata',w_c_dadata) */
        _report.setParameterChar("w_c_dadata",w_c_dadata);
        /* _report.setParameterChar('w_c_adata',w_c_adata) */
        _report.setParameterChar("w_c_adata",w_c_adata);
        /* _report.setParameterChar('DescAzi',gDescAzi) */
        _report.setParameterChar("DescAzi",gDescAzi);
        /* _report.setParameterChar('pAUI',pAUI) */
        _report.setParameterChar("pAUI",pAUI);
        /* _nomerep := 'arrp_stp_stdtec_rap;arrp_stp_stdtec_rap_1;arrp_stp_stdtec_rap_2' // Nome Stampa */
        _nomerep = "arrp_stp_stdtec_rap;arrp_stp_stdtec_rap_1;arrp_stp_stdtec_rap_2";
        /* bReport := _report.makeReportMergingPdf(_nomerep,LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/stampa_stdtec_rap_'+_id+'.pdf','A4','PORTRAIT','PDF') */
        bReport = _report.makeReportMergingPdf(_nomerep,CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/stampa_stdtec_rap_"+_id+".pdf","A4","PORTRAIT","PDF");
        /* lReport := lReport+LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/stampa_stdtec_rap_'+_id+'.pdf;' */
        lReport = lReport+CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/stampa_stdtec_rap_"+_id+".pdf;";
        Cursor_qbe_allxapopebo_tec.Next();
      }
      m_cConnectivityError = Cursor_qbe_allxapopebo_tec.ErrorMessage();
      Cursor_qbe_allxapopebo_tec.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allxapopebo_tec!=null)
          Cursor_qbe_allxapopebo_tec.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
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
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xelegabo!=null)
          Cursor_xelegabo.Close();
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
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pAUI) {
    pAUI = p_pAUI;
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
  public Forward Run(String p_pAUI) {
    pAUI = p_pAUI;
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
      m_Caller.SetString("daRapporto","C",25,0,w_daRapporto);
      m_Caller.SetString("aRapporto","C",16,0,w_aRapporto);
      m_Caller.SetString("daCodDip","C",6,0,w_daCodDip);
      m_Caller.SetString("aCodDip","C",6,0,w_aCodDip);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stp_stdtec_rapR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stp_stdtec_rapR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pAUI = CPLib.Space(1);
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    w_daRapporto = m_Caller.GetString("daRapporto","C",25,0);
    w_aRapporto = m_Caller.GetString("aRapporto","C",16,0);
    w_daCodDip = m_Caller.GetString("daCodDip","C",6,0);
    w_aCodDip = m_Caller.GetString("aCodDip","C",6,0);
    _nomerep = "";
    _report = null;
    bReport = false;
    _id = CPLib.Space(6);
    _idrep = CPLib.Space(10);
    _conta = 0;
    _numsto = CPLib.Space(15);
    w_c_dadata = CPLib.Space(8);
    w_c_adata = CPLib.Space(8);
    xProg = CPLib.Space(15);
    lReport = "";
    _avanza = 0;
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_allrapopebo_tec,qbe_allxapopebo_tec,
  public static final String m_cVQRList = ",qbe_allrapopebo_tec,qbe_allxapopebo_tec,";
  // ENTITY_BATCHES: ,arfn_chkspers,arfn_dateminus,
  public static final String i_InvokedRoutines = ",arfn_chkspers,arfn_dateminus,";
  public static String[] m_cRunParameterNames={"pAUI"};
  protected static String GetFieldsName_0000002F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000035(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000042(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000004C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000059(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000066(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000073(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000080(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000AE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000DF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000EC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
}
