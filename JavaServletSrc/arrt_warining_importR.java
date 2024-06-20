// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_warining_importR implements CallerWithObjs {
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
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_destwarn;
  public String m_cServer_destwarn;
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
  public double _ggprov;
  public double _ggaui;
  public String _azienda;
  public java.sql.Date _minprv;
  public java.sql.Date _maxaui;
  public java.sql.Date _maxope;
  public java.sql.Date _maxfrz;
  public java.sql.Date _minxpe;
  public java.sql.Date _minxrz;
  public String _messaggio;
  public String _serversmtp;
  public String _portasmtp;
  public String _emailsend;
  public String _emailuser;
  public String _emailpwd;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_warining_importR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_warining_import",m_Caller);
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_destwarn = p_ContextObject.GetPhName("destwarn");
    if (m_cPhName_destwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_destwarn = m_cPhName_destwarn+" "+m_Ctx.GetWritePhName("destwarn");
    }
    m_cServer_destwarn = p_ContextObject.GetServer("destwarn");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_ggprov",p_cVarName)) {
      return _ggprov;
    }
    if (CPLib.eqr("_ggaui",p_cVarName)) {
      return _ggaui;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_warining_import";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_azienda",p_cVarName)) {
      return _azienda;
    }
    if (CPLib.eqr("_messaggio",p_cVarName)) {
      return _messaggio;
    }
    if (CPLib.eqr("_serversmtp",p_cVarName)) {
      return _serversmtp;
    }
    if (CPLib.eqr("_portasmtp",p_cVarName)) {
      return _portasmtp;
    }
    if (CPLib.eqr("_emailsend",p_cVarName)) {
      return _emailsend;
    }
    if (CPLib.eqr("_emailuser",p_cVarName)) {
      return _emailuser;
    }
    if (CPLib.eqr("_emailpwd",p_cVarName)) {
      return _emailpwd;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_minprv",p_cVarName)) {
      return _minprv;
    }
    if (CPLib.eqr("_maxaui",p_cVarName)) {
      return _maxaui;
    }
    if (CPLib.eqr("_maxope",p_cVarName)) {
      return _maxope;
    }
    if (CPLib.eqr("_maxfrz",p_cVarName)) {
      return _maxfrz;
    }
    if (CPLib.eqr("_minxpe",p_cVarName)) {
      return _minxpe;
    }
    if (CPLib.eqr("_minxrz",p_cVarName)) {
      return _minxrz;
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
    if (CPLib.eqr("_ggprov",p_cVarName)) {
      _ggprov = value;
      return;
    }
    if (CPLib.eqr("_ggaui",p_cVarName)) {
      _ggaui = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_azienda",p_cVarName)) {
      _azienda = value;
      return;
    }
    if (CPLib.eqr("_messaggio",p_cVarName)) {
      _messaggio = value;
      return;
    }
    if (CPLib.eqr("_serversmtp",p_cVarName)) {
      _serversmtp = value;
      return;
    }
    if (CPLib.eqr("_portasmtp",p_cVarName)) {
      _portasmtp = value;
      return;
    }
    if (CPLib.eqr("_emailsend",p_cVarName)) {
      _emailsend = value;
      return;
    }
    if (CPLib.eqr("_emailuser",p_cVarName)) {
      _emailuser = value;
      return;
    }
    if (CPLib.eqr("_emailpwd",p_cVarName)) {
      _emailpwd = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_minprv",p_cVarName)) {
      _minprv = value;
      return;
    }
    if (CPLib.eqr("_maxaui",p_cVarName)) {
      _maxaui = value;
      return;
    }
    if (CPLib.eqr("_maxope",p_cVarName)) {
      _maxope = value;
      return;
    }
    if (CPLib.eqr("_maxfrz",p_cVarName)) {
      _maxfrz = value;
      return;
    }
    if (CPLib.eqr("_minxpe",p_cVarName)) {
      _minxpe = value;
      return;
    }
    if (CPLib.eqr("_minxrz",p_cVarName)) {
      _minxrz = value;
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
    CPResultSet Cursor_qbe_tab_mmc_d=null;
    CPResultSet Cursor_destwarn=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _ggprov Numeric(3, 0) */
      /* _ggaui Numeric(3, 0) */
      /* _azienda Char(10) */
      /* _minprv Date */
      /* _maxaui Date */
      /* _maxope Date */
      /* _maxfrz Date */
      /* _minxpe Date */
      /* _minxrz Date */
      /* _messaggio Memo */
      /* _serversmtp Char(100) */
      /* _portasmtp Char(10) */
      /* _emailsend Char(50) */
      /* _emailuser Char(50) */
      /* _emailpwd Char(50) */
      // * --- Select from cpazi
      m_cServer = m_Ctx.GetServer("cpazi");
      m_cPhName = m_Ctx.GetPhName("cpazi");
      if (Cursor_cpazi!=null)
        Cursor_cpazi.Close();
      Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select codazi  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cpazi.Eof())) {
        /* _azienda := cpazi->codazi */
        _azienda = Cursor_cpazi.GetString("codazi");
        Cursor_cpazi.Next();
      }
      m_cConnectivityError = Cursor_cpazi.ErrorMessage();
      Cursor_cpazi.Close();
      // * --- End Select
      /* Utilities.SetCompany(_azienda) */
      Utilities.Make(m_Ctx,m_Caller).SetCompany(_azienda);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select GGWARNPRV,GGWARNAUI,ALTSRVMAIL,ALTPRTMAIL,ALTEMLMAIL,ALTUSRMAIL,ALTPWDMAIL  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _ggprov := intermbo->GGWARNPRV */
        _ggprov = CPLib.Round(Cursor_intermbo.GetDouble("GGWARNPRV"),0);
        /* _ggaui := intermbo->GGWARNAUI */
        _ggaui = CPLib.Round(Cursor_intermbo.GetDouble("GGWARNAUI"),0);
        /* _serversmtp := intermbo->ALTSRVMAIL */
        _serversmtp = Cursor_intermbo.GetString("ALTSRVMAIL");
        /* _portasmtp := intermbo->ALTPRTMAIL */
        _portasmtp = Cursor_intermbo.GetString("ALTPRTMAIL");
        /* _emailsend := intermbo->ALTEMLMAIL */
        _emailsend = Cursor_intermbo.GetString("ALTEMLMAIL");
        /* _emailuser := intermbo->ALTUSRMAIL */
        _emailuser = Cursor_intermbo.GetString("ALTUSRMAIL");
        /* _emailpwd := intermbo->ALTPWDMAIL */
        _emailpwd = Cursor_intermbo.GetString("ALTPWDMAIL");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc_d
      SPBridge.HMCaller _h0000001E;
      _h0000001E = new SPBridge.HMCaller();
      _h0000001E.Set("m_cVQRList",m_cVQRList);
      _h0000001E.Set("tbname","xperazbo");
      _h0000001E.Set("fldname","DATAOPE");
      if (Cursor_qbe_tab_mmc_d!=null)
        Cursor_qbe_tab_mmc_d.Close();
      Cursor_qbe_tab_mmc_d = new VQRHolder("qbe_tab_mmc_d",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000001E,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc_d.Eof())) {
        /* _minxpe := qbe_tab_mmc_d->min */
        _minxpe = Cursor_qbe_tab_mmc_d.GetDate("min");
        Cursor_qbe_tab_mmc_d.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc_d.ErrorMessage();
      Cursor_qbe_tab_mmc_d.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc_d
      SPBridge.HMCaller _h00000020;
      _h00000020 = new SPBridge.HMCaller();
      _h00000020.Set("m_cVQRList",m_cVQRList);
      _h00000020.Set("tbname","operazbo");
      _h00000020.Set("fldname","DATAREG");
      if (Cursor_qbe_tab_mmc_d!=null)
        Cursor_qbe_tab_mmc_d.Close();
      Cursor_qbe_tab_mmc_d = new VQRHolder("qbe_tab_mmc_d",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000020,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc_d.Eof())) {
        /* _maxope := qbe_tab_mmc_d->max */
        _maxope = Cursor_qbe_tab_mmc_d.GetDate("max");
        Cursor_qbe_tab_mmc_d.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc_d.ErrorMessage();
      Cursor_qbe_tab_mmc_d.Close();
      // * --- End Select
      /* _minprv := _minxpe */
      _minprv = _minxpe;
      /* _maxaui := _maxope */
      _maxaui = _maxope;
      /* _messaggio := '' */
      _messaggio = "";
      /* If DateDiff(_minprv,Date()) >= _ggprov */
      if (CPLib.ge(CPLib.DateDiff(_minprv,CPLib.Date()),_ggprov)) {
        /* _messaggio := 'Ci sono operazioni che hanno una data superiore a '+LRTrim(Str(_ggprov,3,0))+" giorni (Archivi provvisori)."+NL */
        _messaggio = "Ci sono operazioni che hanno una data superiore a "+CPLib.LRTrim(CPLib.Str(_ggprov,3,0))+" giorni (Archivi provvisori)."+"\n";
      } // End If
      /* System.out.println(DateDiff(_maxaui,Date())) */
      System.out.println(CPLib.DateDiff(_maxaui,CPLib.Date()));
      /* If DateDiff(_maxaui,Date()) >= _ggaui */
      if (CPLib.ge(CPLib.DateDiff(_maxaui,CPLib.Date()),_ggaui)) {
        /* _messaggio := _messaggio + 'Non sono state registrate operazioni da più di '+LRTrim(Str(_ggaui,3,0))+" giorni. (A.U.I.)"+NL */
        _messaggio = _messaggio+"Non sono state registrate operazioni da più di "+CPLib.LRTrim(CPLib.Str(_ggaui,3,0))+" giorni. (A.U.I.)"+"\n";
      } // End If
      /* If not(Empty(LRTrim(_messaggio))) */
      if ( ! (CPLib.Empty(CPLib.LRTrim(_messaggio)))) {
        // * --- Select from destwarn
        m_cServer = m_Ctx.GetServer("destwarn");
        m_cPhName = m_Ctx.GetPhName("destwarn");
        if (Cursor_destwarn!=null)
          Cursor_destwarn.Close();
        Cursor_destwarn = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("destwarn")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_destwarn.Eof())) {
          /* MailLibrary.sendMail(_messaggio,"","CONTROLLO OPERAZIONI",_serversmtp,LRTrim(destwarn->DWEMAIL),"","",_emailsend,"",_emailuser,_emailpwd,false,_portasmtp,false) */
          MailLibrary.sendMail(_messaggio,"","CONTROLLO OPERAZIONI",_serversmtp,CPLib.LRTrim(Cursor_destwarn.GetString("DWEMAIL")),"","",_emailsend,"",_emailuser,_emailpwd,false,_portasmtp,false);
          Cursor_destwarn.Next();
        }
        m_cConnectivityError = Cursor_destwarn.ErrorMessage();
        Cursor_destwarn.Close();
        // * --- End Select
      } // End If
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
        if (Cursor_qbe_tab_mmc_d!=null)
          Cursor_qbe_tab_mmc_d.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_destwarn!=null)
          Cursor_destwarn.Close();
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
  public static arrt_warining_importR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_warining_importR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _ggprov = 0;
    _ggaui = 0;
    _azienda = CPLib.Space(10);
    _minprv = CPLib.NullDate();
    _maxaui = CPLib.NullDate();
    _maxope = CPLib.NullDate();
    _maxfrz = CPLib.NullDate();
    _minxpe = CPLib.NullDate();
    _minxrz = CPLib.NullDate();
    _messaggio = "";
    _serversmtp = CPLib.Space(100);
    _portasmtp = CPLib.Space(10);
    _emailsend = CPLib.Space(50);
    _emailuser = CPLib.Space(50);
    _emailpwd = CPLib.Space(50);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tab_mmc_d,qbe_tab_mmc_d,
  public static final String m_cVQRList = ",qbe_tab_mmc_d,qbe_tab_mmc_d,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
