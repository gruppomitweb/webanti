// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_checkpasswordciclicityR implements CallerWithObjs {
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
  public double pwddaysduration;
  public double pwdciclicity;
  public boolean found;
  public double conta;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spadministration_checkpasswordciclicityR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spadministration_checkpasswordciclicity",m_Caller);
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
    if (CPLib.eqr("pwddaysduration",p_cVarName)) {
      return pwddaysduration;
    }
    if (CPLib.eqr("pwdciclicity",p_cVarName)) {
      return pwdciclicity;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "spadministration_checkpasswordciclicity";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("password",p_cVarName)) {
      return password;
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
    if (CPLib.eqr("found",p_cVarName)) {
      return found;
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
    if (CPLib.eqr("usercode",p_cVarName)) {
      usercode = value;
      return;
    }
    if (CPLib.eqr("pwddaysduration",p_cVarName)) {
      pwddaysduration = value;
      return;
    }
    if (CPLib.eqr("pwdciclicity",p_cVarName)) {
      pwdciclicity = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("password",p_cVarName)) {
      password = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("found",p_cVarName)) {
      found = value;
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
    CPResultSet Cursor_cphistorypwd=null;
    try {
      /* usercode Numeric(30, 0) */
      /* password Char(20) */
      /* If Empty(usercode) */
      if (CPLib.Empty(usercode)) {
        /* usercode := Utilities.UserCode() */
        usercode = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).UserCode(),0);
      } // End If
      /* pwddaysduration Numeric(0, 0) */
      /* pwdciclicity Numeric(4, 0) */
      /* found Bool */
      /* conta Numeric(4, 0) */
      /* pwddaysduration := spadministration_getpwdduration(usercode) */
      pwddaysduration = CPLib.Round(spadministration_getpwddurationR.Make(m_Ctx,this).Run(usercode),0);
      /* pwdciclicity := spadministration_getpwdciclicity(usercode) */
      pwdciclicity = CPLib.Round(spadministration_getpwdciclicityR.Make(m_Ctx,this).Run(usercode),0);
      /* found := False */
      found = false;
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from cphistorypwd
      m_cServer = m_Ctx.GetServer("cphistorypwd");
      m_cPhName = m_Ctx.GetPhName("cphistorypwd");
      if (Cursor_cphistorypwd!=null)
        Cursor_cphistorypwd.Close();
      Cursor_cphistorypwd = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select code,pwpassword,pwdatcreate  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"code="+CPSql.SQLValueAdapter(CPLib.ToSQL(usercode,"?",0,0,m_cServer, m_oParameters),m_cServer,usercode)+" "+")"+(m_Ctx.IsSharedTemp("cphistorypwd")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"pwdatcreate desc ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_cphistorypwd.Eof())) {
        /* If conta<=pwdciclicity */
        if (CPLib.le(conta,pwdciclicity)) {
          /* If CPLib.CheckPwd(usercode,password,cphistorypwd->pwpassword) */
          if (CPLib.CheckPwd(usercode,password,Cursor_cphistorypwd.GetString("pwpassword"))) {
            /* found := True */
            found = true;
          } // End If
        } else { // Else
          // * --- Delete from cphistorypwd
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cphistorypwd");
          m_cPhName = m_Ctx.GetPhName("cphistorypwd");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cphistorypwd",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("spadministration_checkpasswordciclicity",13,"00000011")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"code = "+CPSql.SQLValueAdapter(CPLib.ToSQL(usercode,"?",0,0,m_cServer),m_cServer,usercode)+"";
          m_cSql = m_cSql+" and pwpassword = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cphistorypwd.GetString("pwpassword"),"?",0,0,m_cServer),m_cServer,Cursor_cphistorypwd.GetString("pwpassword"))+"";
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
        /* conta := conta+1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_cphistorypwd.Next();
      }
      m_cConnectivityError = Cursor_cphistorypwd.ErrorMessage();
      Cursor_cphistorypwd.Close();
      // * --- End Select
      /* Return not(found) */
      throw new Stop( ! (found));
    } finally {
      try {
        if (Cursor_cphistorypwd!=null)
          Cursor_cphistorypwd.Close();
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
    );
  }
  public boolean Run(double p_usercode,String p_password) {
    usercode = p_usercode;
    password = p_password;
    return Run();
  }
  public boolean Run() {
    boolean l_result;
    l_result = false;
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
        l_result = stop_value.GetLogic();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = false;
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
  public static spadministration_checkpasswordciclicityR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spadministration_checkpasswordciclicityR(p_Ctx, p_Caller);
  }
  public static spadministration_checkpasswordciclicityR Make(CPContext p_Ctx) {
    return new spadministration_checkpasswordciclicityR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    usercode = 0;
    password = CPLib.Space(20);
    pwddaysduration = 0;
    pwdciclicity = 0;
    found = false;
    conta = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,spadministration_checkpasswordciclicity,spadministration_getpwdciclicity,spadministration_getpwdduration,
  public static final String i_InvokedRoutines = ",spadministration_checkpasswordciclicity,spadministration_getpwdciclicity,spadministration_getpwdduration,";
  public static String[] m_cRunParameterNames={"usercode","password"};
}
