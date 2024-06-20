// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class SPAdministration_afterloginR implements CallerWithObjs {
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
  public String m_cPhName_cpusers;
  public String m_cServer_cpusers;
  public String m_cPhName_cphistorypwd;
  public String m_cServer_cphistorypwd;
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
  public double usercode;
  public String password;
  public cp_login.ServletStatus cp_login_status;
  public boolean from_cp_login;
  public String changeReason;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public SPAdministration_afterloginR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("SPAdministration_afterlogin",m_Caller);
    m_cPhName_cpusers = p_ContextObject.GetPhName("cpusers");
    if (m_cPhName_cpusers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers = m_cPhName_cpusers+" "+m_Ctx.GetWritePhName("cpusers");
    }
    m_cServer_cpusers = p_ContextObject.GetServer("cpusers");
    m_cPhName_cphistorypwd = p_ContextObject.GetPhName("cphistorypwd");
    if (m_cPhName_cphistorypwd.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cphistorypwd = m_cPhName_cphistorypwd+" "+m_Ctx.GetWritePhName("cphistorypwd");
    }
    m_cServer_cphistorypwd = p_ContextObject.GetServer("cphistorypwd");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("usercode",p_cVarName)) {
      return usercode;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "SPAdministration_afterlogin";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("password",p_cVarName)) {
      return password;
    }
    if (CPLib.eqr("changeReason",p_cVarName)) {
      return changeReason;
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
    if (CPLib.eqr("from_cp_login",p_cVarName)) {
      return from_cp_login;
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
    if (CPLib.eqr("usercode",p_cVarName)) {
      usercode = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("password",p_cVarName)) {
      password = value;
      return;
    }
    if (CPLib.eqr("changeReason",p_cVarName)) {
      changeReason = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("from_cp_login",p_cVarName)) {
      from_cp_login = value;
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
    CPResultSet Read_Cursor=null;
    try {
      /* --do nothing */
      /* usercode Numeric(30, 0) */
      /* password Char(20) */
      /* cp_login_status Object(cp_login.ServletStatus) */
      /* from_cp_login Bool */
      /* changeReason Char(10) */
      /* usercode := m_Ctx.userCode() */
      usercode = CPLib.Round(m_Ctx.userCode(),0);
      /* If usercode<>-1 and UserAdmin.HasAdministratedUsers() */
      if (CPLib.ne(usercode,-1) && UserAdmin.Make(m_Ctx).HasAdministratedUsers()) {
        // * --- Read from cpusers
        m_cServer = m_Ctx.GetServer("cpusers");
        m_cPhName = m_Ctx.GetPhName("cpusers");
        m_cSql = "";
        m_cSql = m_cSql+"code="+CPSql.SQLValueAdapter(CPLib.ToSQL(usercode,"N",9,0,m_cServer),m_cServer,usercode);
        if (m_Ctx.IsSharedTemp("cpusers")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("passwd",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          password = Read_Cursor.GetString("passwd");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cpusers into routine SPAdministration_afterlogin returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          password = "";
          Read_Cursor.Close();
          /* Warn Msg 'Aferlogin: failed reading cpusers: code = '+usercode */
          if ( ! (CPLib.IsNull(m_Warning))) {
            m_Warning.log("Aferlogin: failed reading cpusers: code = "+usercode);
          }
        }
        from_cp_login = m_Caller instanceof cp_login.ServletStatus;
        /* If from_cp_login */
        if (from_cp_login) {
          /* changeReason := spadministration_ispasswordexpired() */
          changeReason = spadministration_ispasswordexpiredR.Make(m_Ctx,this).Run();
          /* If not(Empty(changeReason)) */
          if ( ! (CPLib.Empty(changeReason))) {
            cp_login_status = (cp_login.ServletStatus) m_Caller;
            cp_login_status.request.setAttribute("com.zucchetti.sitepainter.root_m_cURL_servlet",cp_login.GuessURLString(cp_login_status.m_cURL_servlet, cp_login_status));
            cp_login_status.request.setAttribute("com.zucchetti.sitepainter.changeReason",changeReason);
            /* cp_login_status.m_cURL_servlet := "SPChangePassword" */
            cp_login_status.m_cURL_servlet = "SPChangePassword";
            /* cp_login_status.m_cCacheKey := "" */
            cp_login_status.m_cCacheKey = "";
            /* m_Ctx.GetAuthority().m_cChangePasswordLockDestination := "SPChangePassword,spadministration_changepassword,spadministration_updatepassword,cp_login,spadministration_getpwdcomplexity,spadministration_getpwdduration,spadministration_getpwdciclicity,routine spadministration_getcaptchalevel" */
            m_Ctx.GetAuthority().m_cChangePasswordLockDestination = "SPChangePassword,spadministration_changepassword,spadministration_updatepassword,cp_login,spadministration_getpwdcomplexity,spadministration_getpwdduration,spadministration_getpwdciclicity,routine spadministration_getcaptchalevel";
          } // End If
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static SPAdministration_afterloginR Make(CPContext p_Ctx, Caller p_Caller) {
    return new SPAdministration_afterloginR(p_Ctx, p_Caller);
  }
  public void Blank() {
    usercode = 0;
    password = CPLib.Space(20);
    cp_login_status = null;
    from_cp_login = false;
    changeReason = CPLib.Space(10);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,spadministration_ispasswordexpired,
  public static final String i_InvokedRoutines = ",spadministration_ispasswordexpired,";
  public static String[] m_cRunParameterNames={};
}
