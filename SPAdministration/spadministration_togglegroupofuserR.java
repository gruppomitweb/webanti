// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_togglegroupofuserR implements CallerWithObjs {
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
  public double userCode;
  public double groupCode;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spadministration_togglegroupofuserR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spadministration_togglegroupofuser",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("userCode",p_cVarName)) {
      return userCode;
    }
    if (CPLib.eqr("groupCode",p_cVarName)) {
      return groupCode;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "spadministration_togglegroupofuser";
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
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("userCode",p_cVarName)) {
      userCode = value;
      return;
    }
    if (CPLib.eqr("groupCode",p_cVarName)) {
      groupCode = value;
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
    /* userCode Numeric(9, 0) */
    /* groupCode Numeric(9, 0) */
    /* cpuser Object(spadministration_usersBO) */
    spadministration_usersBO cpuser;
    cpuser = null;
    /* cpuser := new spadministration_usersBO() */
    cpuser = new spadministration_usersBO(m_Ctx);
    /* If UserAdmin.HasAdminRights() */
    if (UserAdmin.Make(m_Ctx).HasAdminRights()) {
      /* If cpuser.Load(userCode) */
      if (cpuser.Load(userCode)) {
        /* cpusergroups Object(spadministration_usersgroupsBO) */
        spadministration_usersgroupsBO cpusergroups;
        cpusergroups = null;
        /* cpuser.CtxLoad_spadministration_usersgroups() */
        cpuser.CtxLoad_spadministration_usersgroups();
        /* cpusergroups := cpuser.spadministration_usersgroups */
        cpusergroups = cpuser.spadministration_usersgroups;
        /* If not ( cpusergroups.IsLoaded() ) */
        if ( ! (cpusergroups.IsLoaded())) {
          /* cpusergroups.Initialize() */
          cpusergroups.Initialize();
          /* cpusergroups.w_usercode := userCode */
          cpusergroups.w_usercode = userCode;
          /* cpusergroups.SetUpdated() */
          cpusergroups.SetUpdated();
        } // End If
        /* foundgroup Bool */
        boolean foundgroup;
        foundgroup = false;
        /* currentRow Numeric(10, 0) */
        double currentRow;
        currentRow = 0;
        /* While currentRow<cpusergroups.Rows() and not( foundgroup ) */
        while (CPLib.lt(currentRow,cpusergroups.Rows()) &&  ! (foundgroup)) {
          /* cpusergroups.SetRow(currentRow) */
          cpusergroups.SetRow(currentRow);
          /* If cpusergroups.w_groupcode=groupCode */
          if (CPLib.eqr(cpusergroups.w_groupcode,groupCode)) {
            /* foundgroup := true */
            foundgroup = true;
            /* If cpusergroups.w_datestart<>NullDate() and cpusergroups.w_datestart>Date() */
            if (CPLib.ne(cpusergroups.w_datestart,CPLib.NullDate()) && CPLib.gt(cpusergroups.w_datestart,CPLib.Date())) {
              /* Error Msg 'MSG_SET_START_VALIDITY_GROUP_TODAY' */
              m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"MSG_SET_START_VALIDITY_GROUP_TODAY");
              new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
              /* cpusergroups.Set_datestart(Date()) */
              cpusergroups.Set_datestart(CPLib.Date());
              /* ElseIf cpusergroups.w_datestop<>NullDate() and cpusergroups.w_datestop<Date() */
            } else if (CPLib.ne(cpusergroups.w_datestop,CPLib.NullDate()) && CPLib.lt(cpusergroups.w_datestop,CPLib.Date())) {
              /* Error Msg 'MSG_RESET_END_VALIDITY_GROUP' */
              m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"MSG_RESET_END_VALIDITY_GROUP");
              new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
              /* cpusergroups.Set_datestop(NullDate()) */
              cpusergroups.Set_datestop(CPLib.NullDate());
            } else { // Else
              /* cpusergroups.DeleteRow() */
              cpusergroups.DeleteRow();
              /* Error Msg 'MSG_GROUP_REMOVED_SUCCESFULLY' */
              m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"MSG_GROUP_REMOVED_SUCCESFULLY");
              new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
            } // End If
          } // End If
          /* currentRow := currentRow+1 */
          currentRow = CPLib.Round(currentRow+1,0);
        } // End While
        /* If not( foundgroup ) */
        if ( ! (foundgroup)) {
          /* cpusergroups.AddRow() */
          cpusergroups.AddRow();
          /* cpusergroups.Set_groupcode(groupCode) */
          cpusergroups.Set_groupcode(groupCode);
          /* cpusergroups.SaveRow() */
          cpusergroups.SaveRow();
          /* Error Msg 'MSG_GROUP_ADDED_SUCCESFULLY' */
          m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"MSG_GROUP_ADDED_SUCCESFULLY");
          new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
        } // End If
        /* If cpusergroups.Save() */
        if (cpusergroups.Save()) {
          /* Return true */
          throw new Stop(true);
        } else { // Else
          /* Error Msg FormatMsg('MSG_OPEN_NOT_COMPLETE')+NL+FormatMsg('MSG_LOOK_INTO_COUNTERS') */
          m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"MSG_OPEN_NOT_COMPLETE")+"\n"+CPLib.FormatMsg(m_Ctx,"MSG_LOOK_INTO_COUNTERS");
          new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
        } // End If
      } else { // Else
        /* Error Msg 'MSG_USER_NOT_FOUND' */
        m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"MSG_USER_NOT_FOUND");
        new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
      } // End If
    } // End If
    /* Return false */
    throw new Stop(false);
  }
  void _init_() {
  }
  public String RunAsync(double p_userCode,double p_groupCode) {
    userCode = p_userCode;
    groupCode = p_groupCode;
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
  public boolean Run(double p_userCode,double p_groupCode) {
    userCode = p_userCode;
    groupCode = p_groupCode;
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
  public static spadministration_togglegroupofuserR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spadministration_togglegroupofuserR(p_Ctx, p_Caller);
  }
  public static spadministration_togglegroupofuserR Make(CPContext p_Ctx) {
    return new spadministration_togglegroupofuserR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    userCode = 0;
    groupCode = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,spadministration_togglegroupofuser,
  public static final String i_InvokedRoutines = ",spadministration_togglegroupofuser,";
  public static String[] m_cRunParameterNames={"userCode","groupCode"};
}
