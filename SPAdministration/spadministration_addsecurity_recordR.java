// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_addsecurity_recordR implements CallerWithObjs {
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
  public String type;
  public double code;
  public String progname;
  public String backto;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spadministration_addsecurity_recordR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spadministration_addsecurity_record",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("code",p_cVarName)) {
      return code;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "spadministration_addsecurity_record";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("type",p_cVarName)) {
      return type;
    }
    if (CPLib.eqr("progname",p_cVarName)) {
      return progname;
    }
    if (CPLib.eqr("backto",p_cVarName)) {
      return backto;
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
    if (CPLib.eqr("code",p_cVarName)) {
      code = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("type",p_cVarName)) {
      type = value;
      return;
    }
    if (CPLib.eqr("progname",p_cVarName)) {
      progname = value;
      return;
    }
    if (CPLib.eqr("backto",p_cVarName)) {
      backto = value;
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
    /* type Char(1) */
    /* code Numeric(6, 0) */
    /* progname Char(50) */
    /* backto Char(0) */
    /* If UserAdmin.HasAdminRights() */
    if (UserAdmin.Make(m_Ctx).HasAdminRights()) {
      /* Case backto='../jsp-system/spproceduresecurity_portlet.jsp' or backto='../jsp-system/spadministration_pg_procedure_security_states.jsp' */
      if (CPLib.eqr(backto,"../jsp-system/spproceduresecurity_portlet.jsp") || CPLib.eqr(backto,"../jsp-system/spadministration_pg_procedure_security_states.jsp")) {
        /* If type='U' */
        if (CPLib.eqr(type,"U")) {
          /* UserAdmin.AddSecurityRecord(progname, 0, code, -1000, -1000, -1000, -1000) */
          UserAdmin.Make(m_Ctx).AddSecurityRecord(progname,0,code,-1000,-1000,-1000,-1000);
          /* ElseIf type='G' */
        } else if (CPLib.eqr(type,"G")) {
          /* UserAdmin.AddSecurityRecord(progname, code, 0, 0, 0, 0, 0) */
          UserAdmin.Make(m_Ctx).AddSecurityRecord(progname,code,0,0,0,0,0);
        } // End If
        /* Case backto='../jsp-system/spquerysecurity_portlet.jsp' */
      } else if (CPLib.eqr(backto,"../jsp-system/spquerysecurity_portlet.jsp")) {
        /* If type='U' */
        if (CPLib.eqr(type,"U")) {
          /* UserAdmin.AddSecurityRecord(progname, 0, code, 1, -1000, -1000, -1000) */
          UserAdmin.Make(m_Ctx).AddSecurityRecord(progname,0,code,1,-1000,-1000,-1000);
          /* ElseIf type='G' */
        } else if (CPLib.eqr(type,"G")) {
          /* UserAdmin.AddSecurityRecord(progname, code, 0, 1, 0, 0, 0) */
          UserAdmin.Make(m_Ctx).AddSecurityRecord(progname,code,0,1,0,0,0);
        } // End If
      } // End Case
    } // End If
    /* Stop backto */
    Forward f;
    f=new Forward(backto,false,this,Forward.Start,false);
    f.SetParameter("progname",progname);
    f.SetParameter("m_cParameterSequence","progname");
    f.SetParameter("m_cMode","hyperlink");
    throw f;
  }
  void _init_() {
  }
  public String RunAsync(String p_type,double p_code,String p_progname,String p_backto) {
    type = p_type;
    code = p_code;
    progname = p_progname;
    backto = p_backto;
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
  public Forward Run(String p_type,double p_code,String p_progname,String p_backto) {
    type = p_type;
    code = p_code;
    progname = p_progname;
    backto = p_backto;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static spadministration_addsecurity_recordR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spadministration_addsecurity_recordR(p_Ctx, p_Caller);
  }
  public void Blank() {
    type = CPLib.Space(1);
    code = 0;
    progname = CPLib.Space(50);
    backto = CPLib.Space(0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,spadministration_addsecurity_record,
  public static final String i_InvokedRoutines = ",spadministration_addsecurity_record,";
  public static String[] m_cRunParameterNames={"type","code","progname","backto"};
}
