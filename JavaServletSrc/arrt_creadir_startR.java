// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_creadir_startR implements CallerWithObjs {
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
  public String m_cPhName_cgo_vltplat;
  public String m_cServer_cgo_vltplat;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
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
  public String gPathApp;
  public String gPathDoc;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_creadir_startR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_creadir_start",m_Caller);
    m_cPhName_cgo_vltplat = p_ContextObject.GetPhName("cgo_vltplat");
    if (m_cPhName_cgo_vltplat.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_vltplat = m_cPhName_cgo_vltplat+" "+m_Ctx.GetWritePhName("cgo_vltplat");
    }
    m_cServer_cgo_vltplat = p_ContextObject.GetServer("cgo_vltplat");
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
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
      return "arrt_creadir_start";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_cgo_vltplat=null;
    try {
      /* Definisce variabili Globali */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* Crea la cartella */
      /* gPathApp := Strtran(FileLibMit.GetLocation(),'\','/') // Path Applicazione */
      gPathApp = CPLib.Strtran(FileLibMit.GetLocation(),"\\","/");
      /* gPathApp := Left(gPathApp,Len(LRTrim(gPathApp))-1) // Path Applicazione */
      gPathApp = CPLib.Left(gPathApp,CPLib.Len(CPLib.LRTrim(gPathApp))-1);
      m_Ctx.SetGlobalString("gPathApp",gPathApp);
      // * --- Select from cpazi
      m_cServer = m_Ctx.GetServer("cpazi");
      m_cPhName = m_Ctx.GetPhName("cpazi");
      if (Cursor_cpazi!=null)
        Cursor_cpazi.Close();
      Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select codazi  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cpazi.Eof())) {
        /* gAzienda := cpazi->codazi // Azienda */
        gAzienda = Cursor_cpazi.GetString("codazi");
        /* Utilities.SetCompany(gAzienda) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(gAzienda);
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* gPathDoc := intermbo->RICEVUTE // Path Documenti */
          gPathDoc = Cursor_intermbo.GetString("RICEVUTE");
          m_Ctx.SetGlobalString("gPathDoc",gPathDoc);
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* FileLibMit.CreateDir("appo/"+LRTrim(gAzienda)) */
        FileLibMit.CreateDir("appo/"+CPLib.LRTrim(gAzienda));
        /* FileLibMit.CreateDir("export/"+LRTrim(gAzienda)) */
        FileLibMit.CreateDir("export/"+CPLib.LRTrim(gAzienda));
        /* FileLibMit.CreateDir("output/"+LRTrim(gAzienda)) */
        FileLibMit.CreateDir("output/"+CPLib.LRTrim(gAzienda));
        /* FileLibMit.CreateDir("stampe_off/"+LRTrim(gAzienda)) */
        FileLibMit.CreateDir("stampe_off/"+CPLib.LRTrim(gAzienda));
        /* If not(Empty(gPathDoc)) */
        if ( ! (CPLib.Empty(gPathDoc))) {
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/appo/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/flussi/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/Import/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/Import/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/Log/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/Log/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/VLT/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/VLT/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/DocCGO/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/DocCGO/"+CPLib.LRTrim(gAzienda));
          // * --- Select from cgo_vltplat
          m_cServer = m_Ctx.GetServer("cgo_vltplat");
          m_cPhName = m_Ctx.GetPhName("cgo_vltplat");
          if (Cursor_cgo_vltplat!=null)
            Cursor_cgo_vltplat.Close();
          Cursor_cgo_vltplat = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select VPDIRFILE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_vltplat")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_vltplat.Eof())) {
            /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/VLT/"+LRTrim(gAzienda)+"/"+LRTrim(cgo_vltplat->VPDIRFILE)) */
            FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/VLT/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(Cursor_cgo_vltplat.GetString("VPDIRFILE")));
            Cursor_cgo_vltplat.Next();
          }
          m_cConnectivityError = Cursor_cgo_vltplat.ErrorMessage();
          Cursor_cgo_vltplat.Close();
          // * --- End Select
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/CERTIFICATI/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/CERTIFICATI/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/INVII/DAP/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/INVII/STO/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/INVII/STO/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/INVII/ESI/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/INVII/ESI/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/INVII/PRE/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/INVII/PRE/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/INVII/555/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/INVII/555/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/RICEVUTE/ELB/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/RICEVUTE/ELB/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/RICEVUTE/ESI/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/RICEVUTE/ESI/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/RICEVUTE/RIC/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/RICEVUTE/RIC/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/MIGRA/ELB/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/MIGRA/ELB/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/MIGRA/ESI/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/MIGRA/ESI/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/MIGRA/RIC/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/MIGRA/RIC/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/MASSCF/DAP/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/MASSCF/DAP/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/MASSCF/STO/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/MASSCF/STO/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/MASSCF/ESI/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/MASSCF/ESI/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/MASSCF/PRE/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/MASSCF/PRE/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/MASSCFR/ELB/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/MASSCFR/ELB/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/MASSCFR/ESI/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/MASSCFR/ESI/"+CPLib.LRTrim(gAzienda));
          /* FileLibMit.CreateDirPath(LRTrim(gPathDoc)+"/SID/MASSCFR/RIC/"+LRTrim(gAzienda)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathDoc)+"/SID/MASSCFR/RIC/"+CPLib.LRTrim(gAzienda));
        } // End If
        Cursor_cpazi.Next();
      }
      m_cConnectivityError = Cursor_cpazi.ErrorMessage();
      Cursor_cpazi.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_vltplat!=null)
          Cursor_cgo_vltplat.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_creadir_startR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_creadir_startR(p_Ctx, p_Caller);
  }
  public void Blank() {
    gPathApp = CPLib.Space(80);
    gPathDoc = CPLib.Space(80);
    gAzienda = CPLib.Space(10);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
