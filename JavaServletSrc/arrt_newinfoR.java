// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_newinfoR implements CallerWithObjs {
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
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
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
  public String cRapporto;
  public String pTipo;
  public String cRitorno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_newinfoR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_newinfo",m_Caller);
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
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
      return "arrt_newinfo";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("cRapporto",p_cVarName)) {
      return cRapporto;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
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
    if (CPLib.eqr("cRapporto",p_cVarName)) {
      cRapporto = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
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
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_xnarapbo=null;
    CPResultSet Cursor_jnarapbo=null;
    try {
      /* Definizione variabili locali */
      /* cRapporto Char(25) */
      /* pTipo Char(1) */
      /* Variabile Locale */
      /* cRitorno Char(25) */
      /* Verifica l'esistenza in base al tipo */
      /* cRitorno := 'N' */
      cRitorno = "N";
      /* Case pTipo='D' */
      if (CPLib.eqr(pTipo,"D")) {
        // * --- Select from anarapbo
        m_cServer = m_Ctx.GetServer("anarapbo");
        m_cPhName = m_Ctx.GetPhName("anarapbo");
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
        Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(cRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,cRapporto)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_anarapbo.Eof())) {
          /* cRitorno := 'S' */
          cRitorno = "S";
          Cursor_anarapbo.Next();
        }
        m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
        Cursor_anarapbo.Close();
        // * --- End Select
        /* Case pTipo='P' */
      } else if (CPLib.eqr(pTipo,"P")) {
        // * --- Select from xnarapbo
        m_cServer = m_Ctx.GetServer("xnarapbo");
        m_cPhName = m_Ctx.GetPhName("xnarapbo");
        if (Cursor_xnarapbo!=null)
          Cursor_xnarapbo.Close();
        Cursor_xnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(cRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,cRapporto)+" "+")"+(m_Ctx.IsSharedTemp("xnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xnarapbo.Eof())) {
          /* cRitorno := 'S' */
          cRitorno = "S";
          Cursor_xnarapbo.Next();
        }
        m_cConnectivityError = Cursor_xnarapbo.ErrorMessage();
        Cursor_xnarapbo.Close();
        // * --- End Select
        /* Case pTipo='A' */
      } else if (CPLib.eqr(pTipo,"A")) {
        // * --- Select from jnarapbo
        m_cServer = m_Ctx.GetServer("jnarapbo");
        m_cPhName = m_Ctx.GetPhName("jnarapbo");
        if (Cursor_jnarapbo!=null)
          Cursor_jnarapbo.Close();
        Cursor_jnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(cRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,cRapporto)+" "+")"+(m_Ctx.IsSharedTemp("jnarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_jnarapbo.Eof())) {
          /* cRitorno := 'S' */
          cRitorno = "S";
          Cursor_jnarapbo.Next();
        }
        m_cConnectivityError = Cursor_jnarapbo.ErrorMessage();
        Cursor_jnarapbo.Close();
        // * --- End Select
      } // End Case
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xnarapbo!=null)
          Cursor_xnarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jnarapbo!=null)
          Cursor_jnarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_cRapporto,String p_pTipo) {
    cRapporto = p_cRapporto;
    pTipo = p_pTipo;
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
  public String Run(String p_cRapporto,String p_pTipo) {
    cRapporto = p_cRapporto;
    pTipo = p_pTipo;
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
  public static arrt_newinfoR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_newinfoR(p_Ctx, p_Caller);
  }
  public static arrt_newinfoR Make(CPContext p_Ctx) {
    return new arrt_newinfoR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    cRapporto = CPLib.Space(25);
    pTipo = CPLib.Space(1);
    cRitorno = CPLib.Space(25);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_newinfo,
  public static final String i_InvokedRoutines = ",arrt_newinfo,";
  public static String[] m_cRunParameterNames={"cRapporto","pTipo"};
}
