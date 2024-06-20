// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_startrdmR implements CallerWithObjs {
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
  public String m_cPhName_f_tbcauana;
  public String m_cServer_f_tbcauana;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_f_fraziobo;
  public String m_cServer_f_fraziobo;
  public String m_cPhName_tmp_ricmas1;
  public String m_cServer_tmp_ricmas1;
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
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_startrdmR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_startrdm",m_Caller);
    m_cPhName_f_tbcauana = p_ContextObject.GetPhName("f_tbcauana");
    if (m_cPhName_f_tbcauana.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_tbcauana = m_cPhName_f_tbcauana+" "+m_Ctx.GetWritePhName("f_tbcauana");
    }
    m_cServer_f_tbcauana = p_ContextObject.GetServer("f_tbcauana");
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    if (m_cPhName_tbcauana.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcauana = m_cPhName_tbcauana+" "+m_Ctx.GetWritePhName("tbcauana");
    }
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_f_fraziobo = p_ContextObject.GetPhName("f_fraziobo");
    if (m_cPhName_f_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_fraziobo = m_cPhName_f_fraziobo+" "+m_Ctx.GetWritePhName("f_fraziobo");
    }
    m_cServer_f_fraziobo = p_ContextObject.GetServer("f_fraziobo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_ricmas1")) {
      m_cPhName_tmp_ricmas1 = p_ContextObject.GetPhName("tmp_ricmas1");
      if (m_cPhName_tmp_ricmas1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_ricmas1 = m_cPhName_tmp_ricmas1+" "+m_Ctx.GetWritePhName("tmp_ricmas1");
      }
      m_cServer_tmp_ricmas1 = p_ContextObject.GetServer("tmp_ricmas1");
    }
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
      return "arrt_startrdm";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
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
    /* Crea cursore temporaneo */
    // * --- Drop temporary table tmp_ricmas1
    if (m_Ctx.IsSharedTemp("tmp_ricmas1")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_ricmas1")) {
        m_cServer = m_Ctx.GetServer("tmp_ricmas1");
        m_cPhName = m_Ctx.GetPhName("tmp_ricmas1");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_ricmas1");
    }
    // * --- Create temporary table tmp_ricmas1
    if (m_Ctx.IsSharedTemp("tmp_ricmas1")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_ricmas1")) {
        m_cServer = m_Ctx.GetServer("tmp_ricmas1");
        m_cPhName = m_Ctx.GetPhName("tmp_ricmas1");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_ricmas1");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_ricmas1");
    if ( ! (m_Ctx.IsSharedTemp("tmp_ricmas1"))) {
      m_cServer = m_Ctx.GetServer("tmp_ricmas1");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_ricmas1",m_cServer,"proto")),m_cPhName,"tmp_ricmas1",m_Ctx);
    }
    m_cPhName_tmp_ricmas1 = m_cPhName;
    /* Lancia anagrafica */
    /* Stop armt_ricercamassa */
    Forward f;
    f=new Forward("armt_ricercamassa",false,this,Forward.QueryStatus,false);
    f.SetParameter("m_cParameterSequence", "");
    f.SetParameter("m_cMode","hyperlink");
    throw f;
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
  public static arrt_startrdmR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_startrdmR(p_Ctx, p_Caller);
  }
  public void Blank() {
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
