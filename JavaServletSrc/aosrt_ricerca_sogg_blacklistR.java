// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class aosrt_ricerca_sogg_blacklistR implements CallerWithObjs {
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
  public String m_cPhName_cptsrvr;
  public String m_cServer_cptsrvr;
  public String m_cPhName_tmp_seek_sogg;
  public String m_cServer_tmp_seek_sogg;
  public String m_cPhName_webaos_soggetti;
  public String m_cServer_webaos_soggetti;
  public String m_cPhName_webaos_soggettiweb;
  public String m_cServer_webaos_soggettiweb;
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
  public String w_criterio;
  public String w_denomin;
  public String w_simili;
  public String w_flgnega;
  public String w_flgnote;
  public String w_flgafon;
  public double _conta;
  public String _denom;
  public double _count;
  public double _step;
  public String w_denom01;
  public String w_denom02;
  public String w_denom03;
  public String w_denom04;
  public String w_denom05;
  public String w_denom06;
  public String w_denom07;
  public String w_denom08;
  public String w_denom09;
  public String w_denom10;
  public String _denomin;
  public String w_nomereport;
  public double _nblock;
  public String _odbcdatasource;
  public String _DatabaseTypeString;
  public String gMsgImp;
  public String gMsgProc;
  public String gAppName;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public aosrt_ricerca_sogg_blacklistR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("aosrt_ricerca_sogg_blacklist",m_Caller);
    m_cPhName_cptsrvr = p_ContextObject.GetPhName("cptsrvr");
    if (m_cPhName_cptsrvr.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cptsrvr = m_cPhName_cptsrvr+" "+m_Ctx.GetWritePhName("cptsrvr");
    }
    m_cServer_cptsrvr = p_ContextObject.GetServer("cptsrvr");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_seek_sogg")) {
      m_cPhName_tmp_seek_sogg = p_ContextObject.GetPhName("tmp_seek_sogg");
      if (m_cPhName_tmp_seek_sogg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_seek_sogg = m_cPhName_tmp_seek_sogg+" "+m_Ctx.GetWritePhName("tmp_seek_sogg");
      }
      m_cServer_tmp_seek_sogg = p_ContextObject.GetServer("tmp_seek_sogg");
    }
    m_cPhName_webaos_soggetti = p_ContextObject.GetPhName("webaos_soggetti");
    if (m_cPhName_webaos_soggetti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webaos_soggetti = m_cPhName_webaos_soggetti+" "+m_Ctx.GetWritePhName("webaos_soggetti");
    }
    m_cServer_webaos_soggetti = p_ContextObject.GetServer("webaos_soggetti");
    m_cPhName_webaos_soggettiweb = p_ContextObject.GetPhName("webaos_soggettiweb");
    if (m_cPhName_webaos_soggettiweb.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webaos_soggettiweb = m_cPhName_webaos_soggettiweb+" "+m_Ctx.GetWritePhName("webaos_soggettiweb");
    }
    m_cServer_webaos_soggettiweb = p_ContextObject.GetServer("webaos_soggettiweb");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_count",p_cVarName)) {
      return _count;
    }
    if (CPLib.eqr("_step",p_cVarName)) {
      return _step;
    }
    if (CPLib.eqr("_nblock",p_cVarName)) {
      return _nblock;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "aosrt_ricerca_sogg_blacklist";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("criterio",p_cVarName)) {
      return w_criterio;
    }
    if (CPLib.eqr("denomin",p_cVarName)) {
      return w_denomin;
    }
    if (CPLib.eqr("simili",p_cVarName)) {
      return w_simili;
    }
    if (CPLib.eqr("flgnega",p_cVarName)) {
      return w_flgnega;
    }
    if (CPLib.eqr("flgnote",p_cVarName)) {
      return w_flgnote;
    }
    if (CPLib.eqr("flgafon",p_cVarName)) {
      return w_flgafon;
    }
    if (CPLib.eqr("_denom",p_cVarName)) {
      return _denom;
    }
    if (CPLib.eqr("denom01",p_cVarName)) {
      return w_denom01;
    }
    if (CPLib.eqr("denom02",p_cVarName)) {
      return w_denom02;
    }
    if (CPLib.eqr("denom03",p_cVarName)) {
      return w_denom03;
    }
    if (CPLib.eqr("denom04",p_cVarName)) {
      return w_denom04;
    }
    if (CPLib.eqr("denom05",p_cVarName)) {
      return w_denom05;
    }
    if (CPLib.eqr("denom06",p_cVarName)) {
      return w_denom06;
    }
    if (CPLib.eqr("denom07",p_cVarName)) {
      return w_denom07;
    }
    if (CPLib.eqr("denom08",p_cVarName)) {
      return w_denom08;
    }
    if (CPLib.eqr("denom09",p_cVarName)) {
      return w_denom09;
    }
    if (CPLib.eqr("denom10",p_cVarName)) {
      return w_denom10;
    }
    if (CPLib.eqr("_denomin",p_cVarName)) {
      return _denomin;
    }
    if (CPLib.eqr("nomereport",p_cVarName)) {
      return w_nomereport;
    }
    if (CPLib.eqr("_odbcdatasource",p_cVarName)) {
      return _odbcdatasource;
    }
    if (CPLib.eqr("_DatabaseTypeString",p_cVarName)) {
      return _DatabaseTypeString;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gAppName",p_cVarName)) {
      return gAppName;
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
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_count",p_cVarName)) {
      _count = value;
      return;
    }
    if (CPLib.eqr("_step",p_cVarName)) {
      _step = value;
      return;
    }
    if (CPLib.eqr("_nblock",p_cVarName)) {
      _nblock = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("criterio",p_cVarName)) {
      w_criterio = value;
      return;
    }
    if (CPLib.eqr("denomin",p_cVarName)) {
      w_denomin = value;
      return;
    }
    if (CPLib.eqr("simili",p_cVarName)) {
      w_simili = value;
      return;
    }
    if (CPLib.eqr("flgnega",p_cVarName)) {
      w_flgnega = value;
      return;
    }
    if (CPLib.eqr("flgnote",p_cVarName)) {
      w_flgnote = value;
      return;
    }
    if (CPLib.eqr("flgafon",p_cVarName)) {
      w_flgafon = value;
      return;
    }
    if (CPLib.eqr("_denom",p_cVarName)) {
      _denom = value;
      return;
    }
    if (CPLib.eqr("denom01",p_cVarName)) {
      w_denom01 = value;
      return;
    }
    if (CPLib.eqr("denom02",p_cVarName)) {
      w_denom02 = value;
      return;
    }
    if (CPLib.eqr("denom03",p_cVarName)) {
      w_denom03 = value;
      return;
    }
    if (CPLib.eqr("denom04",p_cVarName)) {
      w_denom04 = value;
      return;
    }
    if (CPLib.eqr("denom05",p_cVarName)) {
      w_denom05 = value;
      return;
    }
    if (CPLib.eqr("denom06",p_cVarName)) {
      w_denom06 = value;
      return;
    }
    if (CPLib.eqr("denom07",p_cVarName)) {
      w_denom07 = value;
      return;
    }
    if (CPLib.eqr("denom08",p_cVarName)) {
      w_denom08 = value;
      return;
    }
    if (CPLib.eqr("denom09",p_cVarName)) {
      w_denom09 = value;
      return;
    }
    if (CPLib.eqr("denom10",p_cVarName)) {
      w_denom10 = value;
      return;
    }
    if (CPLib.eqr("_denomin",p_cVarName)) {
      _denomin = value;
      return;
    }
    if (CPLib.eqr("nomereport",p_cVarName)) {
      w_nomereport = value;
      return;
    }
    if (CPLib.eqr("_odbcdatasource",p_cVarName)) {
      _odbcdatasource = value;
      return;
    }
    if (CPLib.eqr("_DatabaseTypeString",p_cVarName)) {
      _DatabaseTypeString = value;
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
    if (CPLib.eqr("gAppName",p_cVarName)) {
      gAppName = value;
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_webaos_soggetti=null;
    CPResultSet Cursor_webaos_soggettiweb=null;
    CPResultSet Cursor_qbe_ric_denom_blacklist=null;
    CPResultSet Cursor_qbe_ric_denom_afon_blacklist=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_criterio Char(1) */
      /* w_denomin Char(60) */
      /* w_simili Char(60) */
      /* w_flgnega Char(1) */
      /* w_flgnote Char(1) */
      /* w_flgafon Char(1) */
      /* _conta Numeric(10, 0) */
      /* _denom Char(80) */
      /* _count Numeric(10, 0) */
      /* _step Numeric(10, 0) */
      /* w_denom01 Char(80) */
      /* w_denom02 Char(80) */
      /* w_denom03 Char(80) */
      /* w_denom04 Char(80) */
      /* w_denom05 Char(80) */
      /* w_denom06 Char(80) */
      /* w_denom07 Char(80) */
      /* w_denom08 Char(80) */
      /* w_denom09 Char(80) */
      /* w_denom10 Char(80) */
      /* _denomin Char(80) */
      /* w_nomereport Char(25) */
      /* _nblock Numeric(2, 0) */
      /* _odbcdatasource Char(128) := '' */
      _odbcdatasource = "";
      /* _DatabaseTypeString Char(60) := '' */
      _DatabaseTypeString = "";
      /* gMsgImp Char(500) // Variabile per messaggi Elaborazione */
      /* gMsgProc Char(500) // Log Elaborazione */
      /* gAppName Char(3) // Applicazione Riferimento */
      /* gMsgProc := 'Inizio procedura '+arfn_fdatetime(DateTime())+NL // Log Elaborazione */
      gMsgProc = "Inizio procedura "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Crea tabella appoggio */
      // * --- Read from cptsrvr
      m_cServer = m_Ctx.GetServer("cptsrvr");
      m_cPhName = m_Ctx.GetPhName("cptsrvr");
      m_cSql = "";
      m_cSql = m_cSql+"ServerName="+CPSql.SQLValueAdapter(CPLib.ToSQL("WEBAOS","C",10,0,m_cServer),m_cServer,"WEBAOS");
      if (m_Ctx.IsSharedTemp("cptsrvr")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ODBCDataSource",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DatabaseType",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _odbcdatasource = Read_Cursor.GetString("ODBCDataSource");
        _DatabaseTypeString = Read_Cursor.GetString("DatabaseType");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cptsrvr into routine aosrt_ricerca_sogg_blacklist returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _odbcdatasource = "";
        _DatabaseTypeString = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* Utilities.SetAlternativeServer('','tmp_seek_sogg',_odbcdatasource) */
      Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("","tmp_seek_sogg",_odbcdatasource);
      // * --- Drop temporary table tmp_seek_sogg
      if (m_Ctx.IsSharedTemp("tmp_seek_sogg")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_seek_sogg")) {
          m_cServer = m_Ctx.GetServer("tmp_seek_sogg");
          m_cPhName = m_Ctx.GetPhName("tmp_seek_sogg");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_seek_sogg");
      }
      // * --- Create temporary table tmp_seek_sogg
      if (m_Ctx.IsSharedTemp("tmp_seek_sogg")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_seek_sogg")) {
          m_cServer = m_Ctx.GetServer("tmp_seek_sogg");
          m_cPhName = m_Ctx.GetPhName("tmp_seek_sogg");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_seek_sogg");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_seek_sogg");
      if ( ! (m_Ctx.IsSharedTemp("tmp_seek_sogg"))) {
        m_cServer = m_Ctx.GetServer("tmp_seek_sogg");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_seek_sogg",m_cServer,"proto")),m_cPhName,"tmp_seek_sogg",m_Ctx);
      }
      m_cPhName_tmp_seek_sogg = m_cPhName;
      /* Seleziona in base alla tipologia */
      /* Case w_criterio='D' */
      if (CPLib.eqr(w_criterio,"D")) {
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* If w_flgafon='N' */
        if (CPLib.eqr(w_flgafon,"N")) {
          /* _denom := LRTrim(w_denomin) */
          _denom = CPLib.LRTrim(w_denomin);
          // * --- Select from webaos_soggetti
          m_cServer = m_Ctx.GetServer("webaos_soggetti");
          m_cPhName = m_Ctx.GetPhName("webaos_soggetti");
          if (Cursor_webaos_soggetti!=null)
            Cursor_webaos_soggetti.Close();
          Cursor_webaos_soggetti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAGSOC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_denom,"?",0,0,m_cServer, m_oParameters),m_cServer,_denom)+" "+")"+(m_Ctx.IsSharedTemp("webaos_soggetti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_webaos_soggetti.Eof())) {
            // * --- Insert into tmp_seek_sogg from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_seek_sogg");
            m_cPhName = m_Ctx.GetPhName("tmp_seek_sogg");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_seek_sogg",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("aosrt_ricerca_sogg_blacklist",51,"0000002C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000002C(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("APPOGGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("COSAFARE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RAGSOCBLK"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RAGSOCX"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RIFERIM"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("SPEC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetDate("DATANAS"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("LUOGONAS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RESPAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RESCITTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RESIND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_seek_sogg",true);
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
            Cursor_webaos_soggetti.Next();
          }
          m_cConnectivityError = Cursor_webaos_soggetti.ErrorMessage();
          Cursor_webaos_soggetti.Close();
          // * --- End Select
        } else { // Else
          /* _denom := LRTrim(aosfn_unifonia(LRTrim(w_denomin),'')) */
          _denom = CPLib.LRTrim(aosfn_unifoniaR.Make(m_Ctx,this).Run(CPLib.LRTrim(w_denomin),""));
          // * --- Select from webaos_soggettiweb
          m_cServer = m_Ctx.GetServer("webaos_soggettiweb");
          m_cPhName = m_Ctx.GetPhName("webaos_soggettiweb");
          if (Cursor_webaos_soggettiweb!=null)
            Cursor_webaos_soggettiweb.Close();
          Cursor_webaos_soggettiweb = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAGSOCX = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_denom,"?",0,0,m_cServer, m_oParameters),m_cServer,_denom)+" "+")"+(m_Ctx.IsSharedTemp("webaos_soggettiweb")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_webaos_soggettiweb.Eof())) {
            // * --- Insert into tmp_seek_sogg from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_seek_sogg");
            m_cPhName = m_Ctx.GetPhName("tmp_seek_sogg");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_seek_sogg",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("aosrt_ricerca_sogg_blacklist",51,"00000030")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000030(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("APPOGGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("COSAFARE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RAGSOCBLK"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RAGSOCX"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RIFERIM"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("SPEC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetDate("DATANAS"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("LUOGONAS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RESPAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RESCITTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_webaos_soggetti.GetString("RESIND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_seek_sogg",true);
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
            Cursor_webaos_soggettiweb.Next();
          }
          m_cConnectivityError = Cursor_webaos_soggettiweb.ErrorMessage();
          Cursor_webaos_soggettiweb.Close();
          // * --- End Select
        } // End If
        /* Case w_criterio='R' */
      } else if (CPLib.eqr(w_criterio,"R")) {
        /* w_denom01 := '' */
        w_denom01 = "";
        /* w_denom02 := '' */
        w_denom02 = "";
        /* w_denom03 := '' */
        w_denom03 = "";
        /* w_denom04 := '' */
        w_denom04 = "";
        /* w_denom05 := '' */
        w_denom05 = "";
        /* w_denom06 := '' */
        w_denom06 = "";
        /* w_denom07 := '' */
        w_denom07 = "";
        /* w_denom08 := '' */
        w_denom08 = "";
        /* w_denom09 := '' */
        w_denom09 = "";
        /* w_denom10 := '' */
        w_denom10 = "";
        /* _denom := LRTrim(w_simili)+" " */
        _denom = CPLib.LRTrim(w_simili)+" ";
        /* _count := 0 */
        _count = CPLib.Round(0,0);
        /* While not(Empty(LRTrim(_denom))) */
        while ( ! (CPLib.Empty(CPLib.LRTrim(_denom)))) {
          /* _step := At(" ",_denom)  */
          _step = CPLib.Round(CPLib.At(" ",_denom),0);
          /* If _step <> 0 */
          if (CPLib.ne(_step,0)) {
            /* _denomin := Left(_denom,(_step - 1)) */
            _denomin = CPLib.Left(_denom,(_step-1));
          } // End If
          /* If not(Empty(LRTrim(_denomin))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(_denomin)))) {
            /* _count := _count + 1 */
            _count = CPLib.Round(_count+1,0);
            /* Case _count = 1 */
            if (CPLib.eqr(_count,1)) {
              /* If w_flgafon ='N' */
              if (CPLib.eqr(w_flgafon,"N")) {
                /* w_denom01 := Strtran('%?'+LRTrim(_denomin)+'?%',' ','') */
                w_denom01 = CPLib.Strtran("%?"+CPLib.LRTrim(_denomin)+"?%"," ","");
              } else { // Else
                /* w_denom01 := Strtran('%?'+aosfn_unifonia(LRTrim(_denomin),'')+'?%',' ','') */
                w_denom01 = CPLib.Strtran("%?"+aosfn_unifoniaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_denomin),"")+"?%"," ","");
              } // End If
              /* w_denom01 := iif(w_denom01='%??%','',w_denom01) */
              w_denom01 = (CPLib.eqr(w_denom01,"%??%")?"":w_denom01);
              /* Case _count = 2 */
            } else if (CPLib.eqr(_count,2)) {
              /* If w_flgafon ='N' */
              if (CPLib.eqr(w_flgafon,"N")) {
                /* w_denom02 := Strtran('%?'+LRTrim(_denomin)+'?%',' ','') */
                w_denom02 = CPLib.Strtran("%?"+CPLib.LRTrim(_denomin)+"?%"," ","");
              } else { // Else
                /* w_denom02 := Strtran('%?'+aosfn_unifonia(LRTrim(_denomin),'')+'?%',' ','') */
                w_denom02 = CPLib.Strtran("%?"+aosfn_unifoniaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_denomin),"")+"?%"," ","");
              } // End If
              /* w_denom02 := iif(w_denom02='%??%','',w_denom02) */
              w_denom02 = (CPLib.eqr(w_denom02,"%??%")?"":w_denom02);
              /* Case _count = 3 */
            } else if (CPLib.eqr(_count,3)) {
              /* If w_flgafon ='N' */
              if (CPLib.eqr(w_flgafon,"N")) {
                /* w_denom03 := Strtran('%?'+LRTrim(_denomin)+'?%',' ','') */
                w_denom03 = CPLib.Strtran("%?"+CPLib.LRTrim(_denomin)+"?%"," ","");
              } else { // Else
                /* w_denom03 := Strtran('%?'+aosfn_unifonia(LRTrim(_denomin),'')+'?%',' ','') */
                w_denom03 = CPLib.Strtran("%?"+aosfn_unifoniaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_denomin),"")+"?%"," ","");
              } // End If
              /* w_denom03 := iif(w_denom03='%??%','',w_denom03) */
              w_denom03 = (CPLib.eqr(w_denom03,"%??%")?"":w_denom03);
              /* Case _count = 4 */
            } else if (CPLib.eqr(_count,4)) {
              /* If w_flgafon ='N' */
              if (CPLib.eqr(w_flgafon,"N")) {
                /* w_denom04 := Strtran('%?'+LRTrim(_denomin)+'?%',' ','') */
                w_denom04 = CPLib.Strtran("%?"+CPLib.LRTrim(_denomin)+"?%"," ","");
              } else { // Else
                /* w_denom04 := Strtran('%?'+aosfn_unifonia(LRTrim(_denomin),'')+'?%',' ','') */
                w_denom04 = CPLib.Strtran("%?"+aosfn_unifoniaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_denomin),"")+"?%"," ","");
              } // End If
              /* w_denom04 := iif(w_denom04='%??%','',w_denom04) */
              w_denom04 = (CPLib.eqr(w_denom04,"%??%")?"":w_denom04);
              /* Case _count = 5 */
            } else if (CPLib.eqr(_count,5)) {
              /* If w_flgafon ='N' */
              if (CPLib.eqr(w_flgafon,"N")) {
                /* w_denom05 := Strtran('%?'+LRTrim(_denomin)+'?%',' ','') */
                w_denom05 = CPLib.Strtran("%?"+CPLib.LRTrim(_denomin)+"?%"," ","");
              } else { // Else
                /* w_denom05 := Strtran('%?'+aosfn_unifonia(LRTrim(_denomin),'')+'?%',' ','') */
                w_denom05 = CPLib.Strtran("%?"+aosfn_unifoniaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_denomin),"")+"?%"," ","");
              } // End If
              /* w_denom05 := iif(w_denom05='%??%','',w_denom05) */
              w_denom05 = (CPLib.eqr(w_denom05,"%??%")?"":w_denom05);
              /* Case _count = 6 */
            } else if (CPLib.eqr(_count,6)) {
              /* If w_flgafon ='N' */
              if (CPLib.eqr(w_flgafon,"N")) {
                /* w_denom06 := Strtran('%?'+LRTrim(_denomin)+'?%',' ','') */
                w_denom06 = CPLib.Strtran("%?"+CPLib.LRTrim(_denomin)+"?%"," ","");
              } else { // Else
                /* w_denom06 := Strtran('%?'+aosfn_unifonia(LRTrim(_denomin),'')+'?%',' ','') */
                w_denom06 = CPLib.Strtran("%?"+aosfn_unifoniaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_denomin),"")+"?%"," ","");
              } // End If
              /* w_denom06 := iif(w_denom06='%??%','',w_denom06) */
              w_denom06 = (CPLib.eqr(w_denom06,"%??%")?"":w_denom06);
              /* Case _count = 7 */
            } else if (CPLib.eqr(_count,7)) {
              /* If w_flgafon ='N' */
              if (CPLib.eqr(w_flgafon,"N")) {
                /* w_denom07 := Strtran('%?'+LRTrim(_denomin)+'?%',' ','') */
                w_denom07 = CPLib.Strtran("%?"+CPLib.LRTrim(_denomin)+"?%"," ","");
              } else { // Else
                /* w_denom07 := Strtran('%?'+aosfn_unifonia(LRTrim(_denomin),'')+'?%',' ','') */
                w_denom07 = CPLib.Strtran("%?"+aosfn_unifoniaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_denomin),"")+"?%"," ","");
              } // End If
              /* w_denom07 := iif(w_denom07='%??%','',w_denom07) */
              w_denom07 = (CPLib.eqr(w_denom07,"%??%")?"":w_denom07);
              /* Case _count = 8 */
            } else if (CPLib.eqr(_count,8)) {
              /* If w_flgafon ='N' */
              if (CPLib.eqr(w_flgafon,"N")) {
                /* w_denom08 := Strtran('%?'+LRTrim(_denomin)+'?%',' ','') */
                w_denom08 = CPLib.Strtran("%?"+CPLib.LRTrim(_denomin)+"?%"," ","");
              } else { // Else
                /* w_denom08 := Strtran('%?'+aosfn_unifonia(LRTrim(_denomin),'')+'?%',' ','') */
                w_denom08 = CPLib.Strtran("%?"+aosfn_unifoniaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_denomin),"")+"?%"," ","");
              } // End If
              /* w_denom08 := iif(w_denom08='%??%','',w_denom08) */
              w_denom08 = (CPLib.eqr(w_denom08,"%??%")?"":w_denom08);
              /* Case _count = 9 */
            } else if (CPLib.eqr(_count,9)) {
              /* If w_flgafon ='N' */
              if (CPLib.eqr(w_flgafon,"N")) {
                /* w_denom09 := Strtran('%?'+LRTrim(_denomin)+'?%',' ','') */
                w_denom09 = CPLib.Strtran("%?"+CPLib.LRTrim(_denomin)+"?%"," ","");
              } else { // Else
                /* w_denom09 := Strtran('%?'+aosfn_unifonia(LRTrim(_denomin),'')+'?%',' ','') */
                w_denom09 = CPLib.Strtran("%?"+aosfn_unifoniaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_denomin),"")+"?%"," ","");
              } // End If
              /* w_denom09 := iif(w_denom09='%??%','',w_denom09) */
              w_denom09 = (CPLib.eqr(w_denom09,"%??%")?"":w_denom09);
              /* Case _count = 10 */
            } else if (CPLib.eqr(_count,10)) {
              /* If w_flgafon ='N' */
              if (CPLib.eqr(w_flgafon,"N")) {
                /* w_denom10 := Strtran('%?'+LRTrim(_denomin)+'?%',' ','') */
                w_denom10 = CPLib.Strtran("%?"+CPLib.LRTrim(_denomin)+"?%"," ","");
              } else { // Else
                /* w_denom10 := Strtran('%?'+aosfn_unifonia(LRTrim(_denomin),'')+'?%',' ','') */
                w_denom10 = CPLib.Strtran("%?"+aosfn_unifoniaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_denomin),"")+"?%"," ","");
              } // End If
              /* w_denom10 := iif(w_denom10='%??%','',w_denom10) */
              w_denom10 = (CPLib.eqr(w_denom10,"%??%")?"":w_denom10);
            } // End Case
          } // End If
          /* _denom := Substr(_denom,(_step+1)) */
          _denom = CPLib.Substr(_denom,(_step+1));
        } // End While
        /* If _count > 0 */
        if (CPLib.gt(_count,0)) {
          /* _conta := 0 */
          _conta = CPLib.Round(0,0);
          /* If w_flgafon = 'N' */
          if (CPLib.eqr(w_flgafon,"N")) {
            // * --- Select from qbe_ric_denom_blacklist
            if (Cursor_qbe_ric_denom_blacklist!=null)
              Cursor_qbe_ric_denom_blacklist.Close();
            Cursor_qbe_ric_denom_blacklist = new VQRHolder("qbe_ric_denom_blacklist",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_ric_denom_blacklist.Eof())) {
              // * --- Insert into tmp_seek_sogg from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_seek_sogg");
              m_cPhName = m_Ctx.GetPhName("tmp_seek_sogg");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_seek_sogg",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("aosrt_ricerca_sogg_blacklist",51,"00000072")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000072(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetString("APPOGGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetString("COSAFARE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetString("RAGSOCBLK"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetString("RAGSOCX"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetString("RIFERIM"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetString("SPEC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetDate("DATANAS"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetString("LUOGONAS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetString("RESPAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetString("RESCITTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_blacklist.GetString("RESIND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_seek_sogg",true);
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
              Cursor_qbe_ric_denom_blacklist.Next();
            }
            m_cConnectivityError = Cursor_qbe_ric_denom_blacklist.ErrorMessage();
            Cursor_qbe_ric_denom_blacklist.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from qbe_ric_denom_afon_blacklist
            if (Cursor_qbe_ric_denom_afon_blacklist!=null)
              Cursor_qbe_ric_denom_afon_blacklist.Close();
            Cursor_qbe_ric_denom_afon_blacklist = new VQRHolder("qbe_ric_denom_afon_blacklist",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_ric_denom_afon_blacklist.Eof())) {
              // * --- Insert into tmp_seek_sogg from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_seek_sogg");
              m_cPhName = m_Ctx.GetPhName("tmp_seek_sogg");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_seek_sogg",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("aosrt_ricerca_sogg_blacklist",51,"00000075")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000075(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetString("APPOGGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetString("COSAFARE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetString("RAGSOCBLK"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetString("RAGSOCX"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetString("RIFERIM"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetString("SPEC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetDate("DATANAS"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetString("LUOGONAS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetString("RESPAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetString("RESCITTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ric_denom_afon_blacklist.GetString("RESIND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_seek_sogg",true);
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
              Cursor_qbe_ric_denom_afon_blacklist.Next();
            }
            m_cConnectivityError = Cursor_qbe_ric_denom_afon_blacklist.ErrorMessage();
            Cursor_qbe_ric_denom_afon_blacklist.Close();
            // * --- End Select
          } // End If
        } // End If
      } // End Case
      /* If _conta = 0 and w_flgnega='S' */
      if (CPLib.eqr(_conta,0) && CPLib.eqr(w_flgnega,"S")) {
        // * --- Insert into tmp_seek_sogg from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_seek_sogg");
        m_cPhName = m_Ctx.GetPhName("tmp_seek_sogg");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_seek_sogg",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("aosrt_ricerca_sogg_blacklist",51,"00000078")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000078(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("NEGATIVA","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_seek_sogg",true);
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
      /* gMsgImp := 'Elaborazione terminata. Premere il bottone per la stampa del risultato' // Variabile per messaggi Elaborazione */
      gMsgImp = "Elaborazione terminata. Premere il bottone per la stampa del risultato";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc+'Riscontrati: '+LRTrim(Str(_conta,15,0))+' '+iif(_conta>1,'soggetti','soggetto')+NL // Log Elaborazione */
      gMsgProc = gMsgProc+"Riscontrati: "+CPLib.LRTrim(CPLib.Str(_conta,15,0))+" "+(CPLib.gt(_conta,1)?"soggetti":"soggetto")+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc+'Fine procedura '+arfn_fdatetime(DateTime()) // Log Elaborazione */
      gMsgProc = gMsgProc+"Fine procedura "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_webaos_soggetti!=null)
          Cursor_webaos_soggetti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_webaos_soggettiweb!=null)
          Cursor_webaos_soggettiweb.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_ric_denom_blacklist!=null)
          Cursor_qbe_ric_denom_blacklist.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_ric_denom_afon_blacklist!=null)
          Cursor_qbe_ric_denom_afon_blacklist.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_criterio,String p_w_denomin,String p_w_simili,String p_w_flgnega,String p_w_flgnote,String p_w_flgafon) {
    w_criterio = p_w_criterio;
    w_denomin = p_w_denomin;
    w_simili = p_w_simili;
    w_flgnega = p_w_flgnega;
    w_flgnote = p_w_flgnote;
    w_flgafon = p_w_flgafon;
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
  public Forward Run(String p_w_criterio,String p_w_denomin,String p_w_simili,String p_w_flgnega,String p_w_flgnote,String p_w_flgafon) {
    w_criterio = p_w_criterio;
    w_denomin = p_w_denomin;
    w_simili = p_w_simili;
    w_flgnega = p_w_flgnega;
    w_flgnote = p_w_flgnote;
    w_flgafon = p_w_flgafon;
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static aosrt_ricerca_sogg_blacklistR Make(CPContext p_Ctx, Caller p_Caller) {
    return new aosrt_ricerca_sogg_blacklistR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_criterio = CPLib.Space(1);
    w_denomin = CPLib.Space(60);
    w_simili = CPLib.Space(60);
    w_flgnega = CPLib.Space(1);
    w_flgnote = CPLib.Space(1);
    w_flgafon = CPLib.Space(1);
    _conta = 0;
    _denom = CPLib.Space(80);
    _count = 0;
    _step = 0;
    w_denom01 = CPLib.Space(80);
    w_denom02 = CPLib.Space(80);
    w_denom03 = CPLib.Space(80);
    w_denom04 = CPLib.Space(80);
    w_denom05 = CPLib.Space(80);
    w_denom06 = CPLib.Space(80);
    w_denom07 = CPLib.Space(80);
    w_denom08 = CPLib.Space(80);
    w_denom09 = CPLib.Space(80);
    w_denom10 = CPLib.Space(80);
    _denomin = CPLib.Space(80);
    w_nomereport = CPLib.Space(25);
    _nblock = 0;
    _odbcdatasource = "";
    _DatabaseTypeString = "";
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gAppName=m_Ctx.GetGlobalString("gAppName");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_ric_denom_blacklist,qbe_ric_denom_afon_blacklist,
  public static final String m_cVQRList = ",qbe_ric_denom_blacklist,qbe_ric_denom_afon_blacklist,";
  // ENTITY_BATCHES: ,aosfn_unifonia,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",aosfn_unifonia,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"w_criterio","w_denomin","w_simili","w_flgnega","w_flgnote","w_flgafon"};
  protected static String GetFieldsName_0000002C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"APPOGGIO,";
    p_cSql = p_cSql+"COSAFARE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAGSOCBLK,";
    p_cSql = p_cSql+"RAGSOCX,";
    p_cSql = p_cSql+"RIFERIM,";
    p_cSql = p_cSql+"SPEC,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"DATANAS,";
    p_cSql = p_cSql+"LUOGONAS,";
    p_cSql = p_cSql+"RESPAESE,";
    p_cSql = p_cSql+"RESCITTA,";
    p_cSql = p_cSql+"RESIND,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_seek_sogg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000030(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"APPOGGIO,";
    p_cSql = p_cSql+"COSAFARE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAGSOCBLK,";
    p_cSql = p_cSql+"RAGSOCX,";
    p_cSql = p_cSql+"RIFERIM,";
    p_cSql = p_cSql+"SPEC,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"DATANAS,";
    p_cSql = p_cSql+"LUOGONAS,";
    p_cSql = p_cSql+"RESPAESE,";
    p_cSql = p_cSql+"RESCITTA,";
    p_cSql = p_cSql+"RESIND,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_seek_sogg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000072(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"APPOGGIO,";
    p_cSql = p_cSql+"COSAFARE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAGSOCBLK,";
    p_cSql = p_cSql+"RAGSOCX,";
    p_cSql = p_cSql+"RIFERIM,";
    p_cSql = p_cSql+"SPEC,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"DATANAS,";
    p_cSql = p_cSql+"LUOGONAS,";
    p_cSql = p_cSql+"RESPAESE,";
    p_cSql = p_cSql+"RESCITTA,";
    p_cSql = p_cSql+"RESIND,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_seek_sogg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000075(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"APPOGGIO,";
    p_cSql = p_cSql+"COSAFARE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAGSOCBLK,";
    p_cSql = p_cSql+"RAGSOCX,";
    p_cSql = p_cSql+"RIFERIM,";
    p_cSql = p_cSql+"SPEC,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"DATANAS,";
    p_cSql = p_cSql+"LUOGONAS,";
    p_cSql = p_cSql+"RESPAESE,";
    p_cSql = p_cSql+"RESCITTA,";
    p_cSql = p_cSql+"RESIND,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_seek_sogg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000078(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_seek_sogg",true);
    return p_cSql;
  }
}
