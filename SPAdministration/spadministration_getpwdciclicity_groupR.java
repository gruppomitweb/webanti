// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_getpwdciclicity_groupR implements CallerWithObjs {
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
  public String m_cPhName_cpgroups;
  public String m_cServer_cpgroups;
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
  public double ciclicity;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spadministration_getpwdciclicity_groupR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spadministration_getpwdciclicity_group",m_Caller);
    m_cPhName_cpgroups = p_ContextObject.GetPhName("cpgroups");
    if (m_cPhName_cpgroups.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpgroups = m_cPhName_cpgroups+" "+m_Ctx.GetWritePhName("cpgroups");
    }
    m_cServer_cpgroups = p_ContextObject.GetServer("cpgroups");
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
    if (CPLib.eqr("ciclicity",p_cVarName)) {
      return ciclicity;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "spadministration_getpwdciclicity_group";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
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
    if (CPLib.eqr("usercode",p_cVarName)) {
      usercode = value;
      return;
    }
    if (CPLib.eqr("ciclicity",p_cVarName)) {
      ciclicity = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
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
    CPResultSet Cursor_spadministration_user_pwdciclicity=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* usercode Numeric(9, 0) */
      /* ciclicity Numeric(3, 0) */
      /* ciclicity := 0 */
      ciclicity = CPLib.Round(0,0);
      /* If usercode<>-1 and usercode<>0 and UserAdmin.HasAdministratedUsers() and ( UserAdmin.HasAdminRights() or m_Ctx.UserCode() = usercode ) */
      if (CPLib.ne(usercode,-1) && CPLib.ne(usercode,0) && UserAdmin.Make(m_Ctx).HasAdministratedUsers() && (UserAdmin.Make(m_Ctx).HasAdminRights() || CPLib.eqr(m_Ctx.UserCode(),usercode))) {
        // * --- Select from spadministration_user_pwdciclicity
        if (Cursor_spadministration_user_pwdciclicity!=null)
          Cursor_spadministration_user_pwdciclicity.Close();
        Cursor_spadministration_user_pwdciclicity = new VQRHolder("spadministration_user_pwdciclicity",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_spadministration_user_pwdciclicity.Eof())) {
          /* ciclicity := spadministration_user_pwdciclicity->pwdciclicity */
          ciclicity = CPLib.Round(Cursor_spadministration_user_pwdciclicity.GetDouble("pwdciclicity"),0);
          Cursor_spadministration_user_pwdciclicity.Next();
        }
        m_cConnectivityError = Cursor_spadministration_user_pwdciclicity.ErrorMessage();
        Cursor_spadministration_user_pwdciclicity.Close();
        // * --- End Select
      } // End If
      /* Return ciclicity */
      throw new Stop(ciclicity);
    } finally {
      try {
        if (Cursor_spadministration_user_pwdciclicity!=null)
          Cursor_spadministration_user_pwdciclicity.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(double p_usercode) {
    usercode = p_usercode;
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
  public double Run(double p_usercode) {
    usercode = p_usercode;
    return Run();
  }
  public double Run() {
    double l_result;
    l_result = 0;
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
        l_result = stop_value.GetNumber();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = 0;
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
  public static spadministration_getpwdciclicity_groupR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spadministration_getpwdciclicity_groupR(p_Ctx, p_Caller);
  }
  public static spadministration_getpwdciclicity_groupR Make(CPContext p_Ctx) {
    return new spadministration_getpwdciclicity_groupR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    usercode = 0;
    ciclicity = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,spadministration_user_pwdciclicity,
  public static final String m_cVQRList = ",spadministration_user_pwdciclicity,";
  // ENTITY_BATCHES: ,spadministration_getpwdciclicity_group,
  public static final String i_InvokedRoutines = ",spadministration_getpwdciclicity_group,";
  public static String[] m_cRunParameterNames={"usercode"};
}
