// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_allinea_anagrafiche_reportR implements CallerWithObjs {
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
  public String m_cPhName_tmp_aafiles;
  public String m_cServer_tmp_aafiles;
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
  public double _cicli;
  public double _conta;
  public double _contar;
  public double _bottom;
  public double _top;
  public double _max;
  public String _terr;
  public String _nomerep;
  public ReportLibrary _report;
  public double _nrep;
  public String gPathApp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_allinea_anagrafiche_reportR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_allinea_anagrafiche_report",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_aafiles")) {
      m_cPhName_tmp_aafiles = p_ContextObject.GetPhName("tmp_aafiles");
      if (m_cPhName_tmp_aafiles.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_aafiles = m_cPhName_tmp_aafiles+" "+m_Ctx.GetWritePhName("tmp_aafiles");
      }
      m_cServer_tmp_aafiles = p_ContextObject.GetServer("tmp_aafiles");
    }
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_contar",p_cVarName)) {
      return _contar;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_nrep",p_cVarName)) {
      return _nrep;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_allinea_anagrafiche_report";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_terr",p_cVarName)) {
      return _terr;
    }
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      return _nomerep;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_contar",p_cVarName)) {
      _contar = value;
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
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_nrep",p_cVarName)) {
      _nrep = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_terr",p_cVarName)) {
      _terr = value;
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
    CPResultSet Cursor_qbe_max_alline_anag=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _cicli Numeric(15, 0) */
      /* _conta Numeric(15, 0) */
      /* _contar Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _max Numeric(15, 0) */
      /* _terr Char(3) // Tipo Errore */
      /* _nomerep Char(30) // Nome Stampa */
      /* _report Object(ReportLibrary) */
      /* _nrep Numeric(3, 0) */
      /* gPathApp Char(80) // Path Applicazione */
      /* Crea il file per inserire i nomi delle stampe */
      // * --- Drop temporary table tmp_aafiles
      if (m_Ctx.IsSharedTemp("tmp_aafiles")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_aafiles")) {
          m_cServer = m_Ctx.GetServer("tmp_aafiles");
          m_cPhName = m_Ctx.GetPhName("tmp_aafiles");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_aafiles");
      }
      // * --- Create temporary table tmp_aafiles
      if (m_Ctx.IsSharedTemp("tmp_aafiles")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_aafiles")) {
          m_cServer = m_Ctx.GetServer("tmp_aafiles");
          m_cPhName = m_Ctx.GetPhName("tmp_aafiles");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_aafiles");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_aafiles");
      if ( ! (m_Ctx.IsSharedTemp("tmp_aafiles"))) {
        m_cServer = m_Ctx.GetServer("tmp_aafiles");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_aafiles",m_cServer,"proto")),m_cPhName,"tmp_aafiles",m_Ctx);
      }
      m_cPhName_tmp_aafiles = m_cPhName;
      /* Seleziona i massimi per tipo */
      /* _report := ReportLibrary.GetReportLibrary() */
      _report = ReportLibrary.Make(m_Ctx).GetReportLibrary();
      /* _nrep := 0 */
      _nrep = CPLib.Round(0,0);
      // * --- Select from qbe_max_alline_anag
      if (Cursor_qbe_max_alline_anag!=null)
        Cursor_qbe_max_alline_anag.Close();
      Cursor_qbe_max_alline_anag = new VQRHolder("qbe_max_alline_anag",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_max_alline_anag.Eof())) {
        /* _terr := qbe_max_alline_anag->tipo // Tipo Errore */
        _terr = Cursor_qbe_max_alline_anag.GetString("tipo");
        /* _max := qbe_max_alline_anag->PROGERRORE */
        _max = CPLib.Round(Cursor_qbe_max_alline_anag.GetDouble("PROGERRORE"),0);
        /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
        /* _conta := 1 */
        _conta = CPLib.Round(1,0);
        /* While _conta <= _cicli */
        while (CPLib.le(_conta,_cicli)) {
          /* _bottom := ((_conta -1 ) * 10000) + 1 */
          _bottom = CPLib.Round(((_conta-1)*10000)+1,0);
          /* _top := _conta * 10000 */
          _top = CPLib.Round(_conta*10000,0);
          /* _report.setParameterChar('tiperr',_terr) */
          _report.setParameterChar("tiperr",_terr);
          /* _report.setParameterChar('valmin',Right('0000000000'+LRTrim(Str(_bottom,10,0)),10)) */
          _report.setParameterChar("valmin",CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_bottom,10,0)),10));
          /* _report.setParameterChar('valmax',Right('0000000000'+LRTrim(Str(_top,10,0)),10)) */
          _report.setParameterChar("valmax",CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_top,10,0)),10));
          /* _nomerep := 'arrp_errpersonbo_'+_terr+"_"+LRTrim(Str(_conta,10,0)) // Nome Stampa */
          _nomerep = "arrp_errpersonbo_"+_terr+"_"+CPLib.LRTrim(CPLib.Str(_conta,10,0));
          /* If _report.makeReport('arrp_errpersonbo',LRTrim(gPathApp)+"/stampe_off/"+LRTrim(_nomerep),'A4','PORTRAIT','PDF') */
          if (_report.makeReport("arrp_errpersonbo",CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(_nomerep),"A4","PORTRAIT","PDF")) {
            // * --- Insert into tmp_aafiles from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_aafiles");
            m_cPhName = m_Ctx.GetPhName("tmp_aafiles");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_aafiles",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_anagrafiche_report",17,"00000020")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000020(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_terr,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_nomerep,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_aafiles",true);
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
            /* _nrep := _nrep + 1 */
            _nrep = CPLib.Round(_nrep+1,0);
          } // End If
          /* _report.cleanObj() */
          _report.cleanObj();
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
        } // End While
        Cursor_qbe_max_alline_anag.Next();
      }
      m_cConnectivityError = Cursor_qbe_max_alline_anag.ErrorMessage();
      Cursor_qbe_max_alline_anag.Close();
      // * --- End Select
      /* If _nrep = 0 */
      if (CPLib.eqr(_nrep,0)) {
        /* Return  */
        Forward f;
        f=new Forward("arpg_allinea_anagrafiche_noreport",false,this,Forward.Start,false);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
        /* Return  */
        Forward f;
        f=new Forward("arpg_allinea_anagrafiche_report",false,this,Forward.Start,false);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End If
    } finally {
      try {
        if (Cursor_qbe_max_alline_anag!=null)
          Cursor_qbe_max_alline_anag.Close();
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
  public static arrt_allinea_anagrafiche_reportR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_allinea_anagrafiche_reportR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _cicli = 0;
    _conta = 0;
    _contar = 0;
    _bottom = 0;
    _top = 0;
    _max = 0;
    _terr = CPLib.Space(3);
    _nomerep = CPLib.Space(30);
    _report = null;
    _nrep = 0;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_max_alline_anag,
  public static final String m_cVQRList = ",qbe_max_alline_anag,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000020(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AATIPERR,";
    p_cSql = p_cSql+"AANOMREP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_aafiles",true);
    return p_cSql;
  }
}
