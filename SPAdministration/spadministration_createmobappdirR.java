// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_createmobappdirR implements CallerWithObjs {
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
  public String w_oaappmenu;
  public boolean dontCheckExists;
  // * --- Area Manuale = BO - Properties
  // * --- spadministration_createmobappdir
  public static int VERSION = 1;
  // * --- Fine Area Manuale
  public spadministration_createmobappdirR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spadministration_createmobappdir",m_Caller);
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
      return "spadministration_createmobappdir";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("oaappmenu",p_cVarName)) {
      return w_oaappmenu;
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
    if (CPLib.eqr("dontCheckExists",p_cVarName)) {
      return dontCheckExists;
    }
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("oaappmenu",p_cVarName)) {
      w_oaappmenu = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("dontCheckExists",p_cVarName)) {
      dontCheckExists = value;
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
    /* w_oaappmenu Char(100) // Menu appl */
    /* dontCheckExists Bool */
    /* webroot Char(100) */
    String webroot;
    webroot = CPLib.Space(100);
    /* webroot := com.zucchetti.sitepainter.Library.GetWebRootPath() */
    webroot = com.zucchetti.sitepainter.Library.GetWebRootPath();
    /* appdir Object(java.io.File) */
    java.io.File appdir;
    appdir = null;
    /* appdir := new java.io.File(webroot+java.io.File.separator+w_oaappmenu+java.io.File.separator) */
    appdir = new java.io.File(webroot+java.io.File.separator+w_oaappmenu+java.io.File.separator);
    /* If not(dontCheckExists) and appdir.exists() */
    if ( ! (dontCheckExists) && appdir.exists()) {
      // Transaction Error
      m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"directory already on your disk."));
      /* Error Msg 'directory already on your disk.' */
      m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"directory already on your disk.");
      new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
      /* ElseIf appdir.mkdir() or dontCheckExists */
    } else if (appdir.mkdir() || dontCheckExists) {
      /* indexfile Object(java.io.File) */
      java.io.File indexfile;
      indexfile = null;
      /* indexfile := new java.io.File(appdir,"index.jsp") */
      indexfile = new java.io.File(appdir,"index.jsp");
      /* indexwriter Object(java.io.BufferedWriter) */
      java.io.BufferedWriter indexwriter;
      indexwriter = null;
      /* indexwriter := getWriter(indexfile) */
      indexwriter = getWriter(indexfile);
      /* indexwriter.write('<% /*VERSION=' + VERSION +'* /') */
      indexwriter.write("<% /*VERSION="+VERSION+"*/");
      /* indexwriter.newLine() */
      indexwriter.newLine();
      /* indexwriter.write(' com.zucchetti.SPBridge.Sitepainter sp=com.zucchetti.SPBridge.Sitepainter.getSitepainter(request);') */
      indexwriter.write(" com.zucchetti.SPBridge.Sitepainter sp=com.zucchetti.SPBridge.Sitepainter.getSitepainter(request);");
      /* indexwriter.newLine() */
      indexwriter.newLine();
      /* indexwriter.write(' sp.StartMobilePage(request,response, out,"' + w_oaappmenu + '",true);') */
      indexwriter.write(" sp.StartMobilePage(request,response, out,\""+w_oaappmenu+"\",true);");
      /* Exec "WriteDefaultDeviceFallback" Page 2:WriteDefaultDeviceFallback(indexwriter) */
      WriteDefaultDeviceFallback(indexwriter);
      /* indexwriter.newLine() */
      indexwriter.newLine();
      /* indexwriter.write(' pageContext.include("../jsp/spma_index.jsp");') */
      indexwriter.write(" pageContext.include(\"../jsp/spma_index.jsp\");");
      /* indexwriter.newLine() */
      indexwriter.newLine();
      /* indexwriter.write(' sp.EndMobilePage(request,response, out,"' + w_oaappmenu + '",true); %>') */
      indexwriter.write(" sp.EndMobilePage(request,response, out,\""+w_oaappmenu+"\",true); %>");
      /* indexwriter.close() */
      indexwriter.close();
      /* defaultfile Object(java.io.File) */
      java.io.File defaultfile;
      defaultfile = null;
      /* defaultfile := new java.io.File(appdir,"default.jsp") */
      defaultfile = new java.io.File(appdir,"default.jsp");
      /* defaultwriter Object(java.io.BufferedWriter) */
      java.io.BufferedWriter defaultwriter;
      defaultwriter = null;
      /* defaultwriter := getWriter(defaultfile) */
      defaultwriter = getWriter(defaultfile);
      /* defaultwriter.write('<% /*VERSION=' + VERSION + '* /') */
      defaultwriter.write("<% /*VERSION="+VERSION+"*/");
      /* defaultwriter.newLine() */
      defaultwriter.newLine();
      /* defaultwriter.write(' com.zucchetti.SPBridge.Sitepainter sp=com.zucchetti.SPBridge.Sitepainter.getSitepainter(request);') */
      defaultwriter.write(" com.zucchetti.SPBridge.Sitepainter sp=com.zucchetti.SPBridge.Sitepainter.getSitepainter(request);");
      /* defaultwriter.newLine() */
      defaultwriter.newLine();
      /* defaultwriter.write(' String redirectUrl = sp.CheckSecurityMobile("' + w_oaappmenu + '");') */
      defaultwriter.write(" String redirectUrl = sp.CheckSecurityMobile(\""+w_oaappmenu+"\");");
      /* defaultwriter.newLine() */
      defaultwriter.newLine();
      /* defaultwriter.write(' if (redirectUrl!=null) response.sendRedirect(redirectUrl);') */
      defaultwriter.write(" if (redirectUrl!=null) response.sendRedirect(redirectUrl);");
      /* defaultwriter.newLine() */
      defaultwriter.newLine();
      /* defaultwriter.write(' else {') */
      defaultwriter.write(" else {");
      /* defaultwriter.newLine() */
      defaultwriter.newLine();
      /* Exec "WriteDefaultDeviceFallback" Page 2:WriteDefaultDeviceFallback(defaultwriter) */
      WriteDefaultDeviceFallback(defaultwriter);
      /* defaultwriter.write(' sp.StartMobilePage(request,response, out,"' + w_oaappmenu + '",false);') */
      defaultwriter.write(" sp.StartMobilePage(request,response, out,\""+w_oaappmenu+"\",false);");
      /* defaultwriter.newLine() */
      defaultwriter.newLine();
      /* defaultwriter.write(' pageContext.include("../jsp/spma_default.jsp");') */
      defaultwriter.write(" pageContext.include(\"../jsp/spma_default.jsp\");");
      /* defaultwriter.newLine() */
      defaultwriter.newLine();
      /* defaultwriter.write(' sp.EndMobilePage(request,response, out,"' + w_oaappmenu + '",false); } %>') */
      defaultwriter.write(" sp.EndMobilePage(request,response, out,\""+w_oaappmenu+"\",false); } %>");
      /* defaultwriter.close() */
      defaultwriter.close();
    } else { // Else
      // Transaction Error
      m_Sql.AbortTransaction();
      /* Error Msg 'Generic error creating directory.' */
      m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"Generic error creating directory.");
      new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
    } // End If
  }
  void WriteDefaultDeviceFallback(java.io.BufferedWriter writer) throws Exception {
    /* writer Object(java.io.BufferedWriter) */
    /* writer.write('String DeviceToGo = ( sp.getDeviceSelected()==null ? com.zucchetti.PortalStudio.JSPLib.GetUserAgent(request) : sp.getDeviceSelected() );') */
    writer.write("String DeviceToGo = ( sp.getDeviceSelected()==null ? com.zucchetti.PortalStudio.JSPLib.GetUserAgent(request) : sp.getDeviceSelected() );");
    /* writer.newLine() */
    writer.newLine();
    /* writer.write('if ( "DEFAULT".equals(DeviceToGo) ) {') */
    writer.write("if ( \"DEFAULT\".equals(DeviceToGo) ) {");
    /* writer.newLine() */
    writer.newLine();
    /* writer.write('sp.setDeviceSelected( "TABLET" );') */
    writer.write("sp.setDeviceSelected( \"TABLET\" );");
    /* writer.newLine() */
    writer.newLine();
    /* writer.write('}') */
    writer.write("}");
    /* writer.newLine() */
    writer.newLine();
  }
  void _init_() {
  }
  public String RunAsync(boolean p_dontCheckExists) {
    dontCheckExists = p_dontCheckExists;
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
    );
  }
  public Forward Run(boolean p_dontCheckExists) {
    dontCheckExists = p_dontCheckExists;
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
      m_Caller.SetString("oaappmenu","C",100,0,w_oaappmenu);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static spadministration_createmobappdirR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spadministration_createmobappdirR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_oaappmenu = m_Caller.GetString("oaappmenu","C",100,0);
    dontCheckExists = false;
  }
  // * --- Area Manuale = BO - Methods
  // * --- spadministration_createmobappdir
  protected java.io.BufferedWriter getWriter(java.io.File file) {
    try {
      return new java.io.BufferedWriter(new java.io.FileWriter(file));
    } catch(Exception e) {
      return null;
    }
  }
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,spadministration_createmobappdir,
  public static final String i_InvokedRoutines = ",spadministration_createmobappdir,";
  public static String[] m_cRunParameterNames={"dontCheckExists"};
}
