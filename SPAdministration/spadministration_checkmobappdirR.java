// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_checkmobappdirR implements CallerWithObjs {
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
  public String menuname;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spadministration_checkmobappdirR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spadministration_checkmobappdir",m_Caller);
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
      return "spadministration_checkmobappdir";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("menuname",p_cVarName)) {
      return menuname;
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
    if (CPLib.eqr("menuname",p_cVarName)) {
      menuname = value;
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
    /* menuname Char(100) // Menu appl */
    /* webroot Char(100) */
    String webroot;
    webroot = CPLib.Space(100);
    /* webroot := com.zucchetti.sitepainter.Library.GetWebRootPath() */
    webroot = com.zucchetti.sitepainter.Library.GetWebRootPath();
    /* appdir Object(java.io.File) */
    java.io.File appdir;
    appdir = null;
    /* appdir := new java.io.File(webroot,menuname) */
    appdir = new java.io.File(webroot,menuname);
    /* If appdir.exists() */
    if (appdir.exists()) {
      /* fileversion Numeric(5, 0) */
      double fileversion;
      fileversion = 0;
      double nTry00000008status;
      nTry00000008status = m_Sql.GetTransactionStatus();
      String cTry00000008msg;
      cTry00000008msg = m_Sql.TransactionErrorMessage();
      try {
        /* line Char(0) */
        String line;
        line = CPLib.Space(0);
        /* jspfile Object(java.io.File) */
        java.io.File jspfile;
        jspfile = null;
        /* jspreader Object(java.io.BufferedReader) */
        java.io.BufferedReader jspreader;
        jspreader = null;
        /* indexversion Numeric(5, 0) */
        double indexversion;
        indexversion = 0;
        /* defaultversion Numeric(5, 0) */
        double defaultversion;
        defaultversion = 0;
        /* jspfile := new java.io.File(appdir,"index.jsp") */
        jspfile = new java.io.File(appdir,"index.jsp");
        /* jspreader := getReader(jspfile) */
        jspreader = getReader(jspfile);
        /* line := jspreader.readLine() */
        line = jspreader.readLine();
        /* jspreader.close() */
        jspreader.close();
        /* line := Strtran(line, '<% /*VERSION=','') */
        line = CPLib.Strtran(line,"<% /*VERSION=","");
        /* line := Strtran(line, '* /','') */
        line = CPLib.Strtran(line,"*/","");
        /* indexversion := Val(line) */
        indexversion = CPLib.Round(CPLib.Val(line),0);
        /* jspfile := new java.io.File(appdir,"default.jsp") */
        jspfile = new java.io.File(appdir,"default.jsp");
        /* jspreader := getReader(jspfile) */
        jspreader = getReader(jspfile);
        /* line := jspreader.readLine() */
        line = jspreader.readLine();
        /* jspreader.close() */
        jspreader.close();
        /* line := Strtran(line, '<% /*VERSION=','') */
        line = CPLib.Strtran(line,"<% /*VERSION=","");
        /* line := Strtran(line, '* /','') */
        line = CPLib.Strtran(line,"*/","");
        /* defaultversion := Val(line) */
        defaultversion = CPLib.Round(CPLib.Val(line),0);
        /* fileversion := Min ( indexversion, defaultversion ) */
        fileversion = CPLib.Round(CPLib.Min(indexversion,defaultversion),0);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* fileversion := 0 */
        fileversion = CPLib.Round(0,0);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000008status,0)) {
          m_Sql.SetTransactionStatus(nTry00000008status,cTry00000008msg);
        }
      }
      /* If fileversion=0 or fileversion<spadministration_createmobappdirR.VERSION */
      if (CPLib.eqr(fileversion,0) || CPLib.lt(fileversion,spadministration_createmobappdirR.VERSION)) {
        /* Return true */
        throw new Stop(true);
      } // End If
    } else { // Else
      /* Return true */
      throw new Stop(true);
    } // End If
    /* Return false */
    throw new Stop(false);
  }
  void _init_() {
  }
  public String RunAsync(String p_menuname) {
    menuname = p_menuname;
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
  public boolean Run(String p_menuname) {
    menuname = p_menuname;
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
  public static spadministration_checkmobappdirR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spadministration_checkmobappdirR(p_Ctx, p_Caller);
  }
  public static spadministration_checkmobappdirR Make(CPContext p_Ctx) {
    return new spadministration_checkmobappdirR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    menuname = CPLib.Space(100);
  }
  // * --- Area Manuale = BO - Methods
  // * --- spadministration_checkmobappdir
  protected java.io.BufferedReader getReader(java.io.File file) {
    try {
      return new java.io.BufferedReader(new java.io.FileReader(file));
    } catch(Exception e) {
      return null;
    }
  }
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,spadministration_checkmobappdir,
  public static final String i_InvokedRoutines = ",spadministration_checkmobappdir,";
  public static String[] m_cRunParameterNames={"menuname"};
}
