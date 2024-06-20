// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_ispasswordexpiredR implements CallerWithObjs {
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
  public String m_cPhName_cphistorypwd;
  public String m_cServer_cphistorypwd;
  public String m_cPhName_cpusers;
  public String m_cServer_cpusers;
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
  public java.sql.Timestamp pwd_create;
  public boolean change_pwd;
  public double pwddaysduration;
  public String changeReason;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spadministration_ispasswordexpiredR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spadministration_ispasswordexpired",m_Caller);
    m_cPhName_cphistorypwd = p_ContextObject.GetPhName("cphistorypwd");
    if (m_cPhName_cphistorypwd.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cphistorypwd = m_cPhName_cphistorypwd+" "+m_Ctx.GetWritePhName("cphistorypwd");
    }
    m_cServer_cphistorypwd = p_ContextObject.GetServer("cphistorypwd");
    m_cPhName_cpusers = p_ContextObject.GetPhName("cpusers");
    if (m_cPhName_cpusers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers = m_cPhName_cpusers+" "+m_Ctx.GetWritePhName("cpusers");
    }
    m_cServer_cpusers = p_ContextObject.GetServer("cpusers");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("usercode",p_cVarName)) {
      return usercode;
    }
    if (CPLib.eqr("pwddaysduration",p_cVarName)) {
      return pwddaysduration;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "spadministration_ispasswordexpired";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
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
    if (CPLib.eqr("pwd_create",p_cVarName)) {
      return pwd_create;
    }
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("change_pwd",p_cVarName)) {
      return change_pwd;
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
    if (CPLib.eqr("pwddaysduration",p_cVarName)) {
      pwddaysduration = value;
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
    if (CPLib.eqr("pwd_create",p_cVarName)) {
      pwd_create = value;
      return;
    }
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("change_pwd",p_cVarName)) {
      change_pwd = value;
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
      /* usercode Numeric(30, 0) */
      /* password Char(20) */
      /* pwd_create DateTime */
      /* change_pwd Bool */
      /* pwddaysduration Numeric(4, 0) */
      /* changeReason Char(10) */
      /* If Empty(usercode) */
      if (CPLib.Empty(usercode)) {
        /* usercode := Utilities.UserCode() */
        usercode = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).UserCode(),0);
      } // End If
      /* If Empty(password) */
      if (CPLib.Empty(password)) {
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
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("passwd",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("pwdcreate",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("forcepwdchange",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          password = Read_Cursor.GetString("passwd");
          pwd_create = Read_Cursor.GetDateTime("pwdcreate");
          change_pwd = Read_Cursor.GetBoolean("forcepwdchange");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cpusers into routine spadministration_ispasswordexpired returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          password = "";
          pwd_create = CPLib.NullDateTime();
          change_pwd = false;
          Read_Cursor.Close();
          /* Warn Msg "ispasswordexpired: Error reading cpusers: usercode = "+usercode */
          if ( ! (CPLib.IsNull(m_Warning))) {
            m_Warning.log("ispasswordexpired: Error reading cpusers: usercode = "+usercode);
          }
        }
        /* If change_pwd */
        if (change_pwd) {
          /* changeReason := 'force' */
          changeReason = "force";
        } // End If
      } // End If
      /* If not(change_pwd) */
      if ( ! (change_pwd)) {
        /* pwddaysduration := spadministration_getpwdduration(usercode) */
        pwddaysduration = CPLib.Round(spadministration_getpwddurationR.Make(m_Ctx,this).Run(usercode),0);
        /* If pwddaysduration>0 */
        if (CPLib.gt(pwddaysduration,0)) {
          /* change_pwd := DateDiff(Date(pwd_create),Date())>pwddaysduration */
          change_pwd = CPLib.gt(CPLib.DateDiff(CPLib.Date(pwd_create),CPLib.Date()),pwddaysduration);
          /* If change_pwd */
          if (change_pwd) {
            /* changeReason := 'expire' */
            changeReason = "expire";
          } // End If
        } // End If
      } // End If
      /* Return changeReason */
      throw new Stop(changeReason);
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
  public String RunAsync(double p_usercode,String p_password) {
    usercode = p_usercode;
    password = p_password;
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
    return CPAsyncRoutine.CreateAsyncAndStart(
    new CPAsyncRoutine.AsyncRunnable() {
      public void Compute(CPAsyncRoutine.AsyncResult p_oResult) {
        try {
          p_oResult.m_oResult=new Stop(Run());
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
  public String Run(double p_usercode,String p_password) {
    usercode = p_usercode;
    password = p_password;
    return Run();
  }
  public String Run() {
    String l_result;
    l_result = "";
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
      } catch(Stop stop_value) {
        l_result = stop_value.GetString();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = "";
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
    return l_result;
  }
  public static spadministration_ispasswordexpiredR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spadministration_ispasswordexpiredR(p_Ctx, p_Caller);
  }
  public static spadministration_ispasswordexpiredR Make(CPContext p_Ctx) {
    return new spadministration_ispasswordexpiredR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    usercode = 0;
    password = CPLib.Space(20);
    pwd_create = CPLib.NullDateTime();
    change_pwd = false;
    pwddaysduration = 0;
    changeReason = CPLib.Space(10);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,spadministration_getpwdduration,spadministration_ispasswordexpired,
  public static final String i_InvokedRoutines = ",spadministration_getpwdduration,spadministration_ispasswordexpired,";
  public static String[] m_cRunParameterNames={"usercode","password"};
}
