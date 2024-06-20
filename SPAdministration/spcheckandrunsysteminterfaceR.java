// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spcheckandrunsysteminterfaceR implements CallerWithObjs {
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
  public String entity;
  public boolean systemTablesOk;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spcheckandrunsysteminterfaceR (CPContext p_ContextObject, Caller caller) {
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
                                all'oggetto globale (unico per pi� istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda � contenuta nel global object.
                             */
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("spcheckandrunsysteminterface",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "spcheckandrunsysteminterface";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("entity",p_cVarName)) {
      return entity;
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
    if (CPLib.eqr("systemTablesOk",p_cVarName)) {
      return systemTablesOk;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("entity",p_cVarName)) {
      entity = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("systemTablesOk",p_cVarName)) {
      systemTablesOk = value;
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
    /* entity Char(100) */
    /* If UserAdmin.HasAdminRights() */
    if (UserAdmin.Make(m_Ctx).HasAdminRights()) {
      /* systemTablesOk Bool */
      DBAdm dbadm = new DBAdm(m_Ctx);
      systemTablesOk = dbadm.VerifySystemTables();
      /* If systemTablesOk */
      if (systemTablesOk) {
        /* If Left(entity,3) = 'jsp' or Left(entity,7) = 'servlet' or Left(entity,12) = 'portalstudio' */
        if (CPLib.eqr(CPLib.Left(entity,3),"jsp") || CPLib.eqr(CPLib.Left(entity,7),"servlet") || CPLib.eqr(CPLib.Left(entity,12),"portalstudio")) {
          /* entity := '../' + entity */
          entity = "../"+entity;
        } // End If
        /* If not(CheckRedirect(entity, m_Caller)) */
        if ( ! (CheckRedirect(entity,m_Caller))) {
          /* Stop SPSystemTableError */
          Forward f;
          f=new Forward("SPSystemTableError",false,this,Forward.Start,false);
          f.SetParameter("m_cParameterSequence", "");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
        } // End If
        /* Stop entity */
        Forward f;
        f=new Forward(entity,false,this,Forward.NoStatus,true);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
        /* Stop SPSystemTableError */
        Forward f;
        f=new Forward("SPSystemTableError",false,this,Forward.Start,false);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End If
    } // End If
  }
  void _init_() {
  }
  public String RunAsync(String p_entity) {
    entity = p_entity;
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
  public Forward Run(String p_entity) {
    entity = p_entity;
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
  public static spcheckandrunsysteminterfaceR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spcheckandrunsysteminterfaceR(p_Ctx, p_Caller);
  }
  public void Blank() {
    entity = CPLib.Space(100);
    systemTablesOk = false;
  }
  // * --- Area Manuale = BO - Methods
  // * --- spcheckandrunsysteminterface
  public static boolean CheckRedirect(String l_cURL, CallerWithObjs m_Caller){
    return SPLib.SecurityCheckForRedirections(((spcheckandrunsysteminterface.ServletStatus)m_Caller).request, l_cURL);
  }
  
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,spcheckandrunsysteminterface,
  public static final String i_InvokedRoutines = ",spcheckandrunsysteminterface,";
  public static String[] m_cRunParameterNames={"entity"};
}