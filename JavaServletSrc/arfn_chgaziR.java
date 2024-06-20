// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_chgaziR implements CallerWithObjs {
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
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
  public String pCodAzi;
  public String gAzienda;
  public String gIntemediario;
  public String gActLog;
  public String gSeekAOS;
  public String gDescAzi;
  public String gUrlApp;
  public String gFlgPEP;
  public String gIPP;
  public String gIPS;
  public String gIPSP;
  public boolean bRitorno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_chgaziR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_chgazi",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
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
      return "arfn_chgazi";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pCodAzi",p_cVarName)) {
      return pCodAzi;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gActLog",p_cVarName)) {
      return gActLog;
    }
    if (CPLib.eqr("gSeekAOS",p_cVarName)) {
      return gSeekAOS;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gFlgPEP",p_cVarName)) {
      return gFlgPEP;
    }
    if (CPLib.eqr("gIPP",p_cVarName)) {
      return gIPP;
    }
    if (CPLib.eqr("gIPS",p_cVarName)) {
      return gIPS;
    }
    if (CPLib.eqr("gIPSP",p_cVarName)) {
      return gIPSP;
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
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      return bRitorno;
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
    if (CPLib.eqr("pCodAzi",p_cVarName)) {
      pCodAzi = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("gActLog",p_cVarName)) {
      gActLog = value;
      return;
    }
    if (CPLib.eqr("gSeekAOS",p_cVarName)) {
      gSeekAOS = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("gFlgPEP",p_cVarName)) {
      gFlgPEP = value;
      return;
    }
    if (CPLib.eqr("gIPP",p_cVarName)) {
      gIPP = value;
      return;
    }
    if (CPLib.eqr("gIPS",p_cVarName)) {
      gIPS = value;
      return;
    }
    if (CPLib.eqr("gIPSP",p_cVarName)) {
      gIPSP = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      bRitorno = value;
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
    CPResultSet Cursor_intermbo=null;
    try {
      /* pCodAzi Char(10) // Codice Azienda */
      /* gAzienda Char(10) // Azienda */
      /* gIntemediario Char(11) */
      /* gActLog Char(1) */
      /* gSeekAOS Char(1) */
      /* gDescAzi Char(70) */
      /* gUrlApp Char(80) */
      /* gFlgPEP Char(1) */
      /* gIPP Char(20) // Protocollo Server */
      /* gIPS Char(120) // IP Server */
      /* gIPSP Char(20) // Porta Server */
      /* bRitorno Bool */
      /* bRitorno := Utilities.SetCompany(pCodAzi) */
      bRitorno = Utilities.Make(m_Ctx,m_Caller).SetCompany(pCodAzi);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* gIntemediario := intermbo->CODINTER // Intermediario */
        gIntemediario = Cursor_intermbo.GetString("CODINTER");
        m_Ctx.SetGlobalString("gIntemediario",gIntemediario);
        /* gActLog := intermbo->FLGLOG // Log Attivo */
        gActLog = Cursor_intermbo.GetString("FLGLOG");
        m_Ctx.SetGlobalString("gActLog",gActLog);
        /* gSeekAOS := intermbo->FLGAOS // Collegamento a TER */
        gSeekAOS = Cursor_intermbo.GetString("FLGAOS");
        m_Ctx.SetGlobalString("gSeekAOS",gSeekAOS);
        /* gDescAzi := intermbo->RAGSOC // Descrizione Azienda */
        gDescAzi = Cursor_intermbo.GetString("RAGSOC");
        m_Ctx.SetGlobalString("gDescAzi",gDescAzi);
        /* gUrlApp := LRTrim(gIPP)+'://'+LRTrim(gIPS)+":"+LRTrim(gIPSP)+"/"+iif(Empty(LRTrim(intermbo->URLAPPL)),'webanti',LRTrim(intermbo->URLAPPL))+"/" // URL Applicazione */
        gUrlApp = CPLib.LRTrim(gIPP)+"://"+CPLib.LRTrim(gIPS)+":"+CPLib.LRTrim(gIPSP)+"/"+(CPLib.Empty(CPLib.LRTrim(Cursor_intermbo.GetString("URLAPPL")))?"webanti":CPLib.LRTrim(Cursor_intermbo.GetString("URLAPPL")))+"/";
        m_Ctx.SetGlobalString("gUrlApp",gUrlApp);
        /* gFlgPEP := intermbo->ITFLGPEP // Liste PEP */
        gFlgPEP = Cursor_intermbo.GetString("ITFLGPEP");
        m_Ctx.SetGlobalString("gFlgPEP",gFlgPEP);
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* gAzienda := pCodAzi // Azienda */
      gAzienda = pCodAzi;
      m_Ctx.SetGlobalString("gAzienda",gAzienda);
      /* Return bRitorno */
      throw new Stop(bRitorno);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pCodAzi) {
    pCodAzi = p_pCodAzi;
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
  public boolean Run(String p_pCodAzi) {
    pCodAzi = p_pCodAzi;
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return l_result;
  }
  public static arfn_chgaziR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_chgaziR(p_Ctx, p_Caller);
  }
  public static arfn_chgaziR Make(CPContext p_Ctx) {
    return new arfn_chgaziR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pCodAzi = CPLib.Space(10);
    bRitorno = false;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gActLog=m_Ctx.GetGlobalString("gActLog");
    gSeekAOS=m_Ctx.GetGlobalString("gSeekAOS");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gFlgPEP=m_Ctx.GetGlobalString("gFlgPEP");
    gIPP=m_Ctx.GetGlobalString("gIPP");
    gIPS=m_Ctx.GetGlobalString("gIPS");
    gIPSP=m_Ctx.GetGlobalString("gIPSP");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chgazi,
  public static final String i_InvokedRoutines = ",arfn_chgazi,";
  public static String[] m_cRunParameterNames={"pCodAzi"};
}
