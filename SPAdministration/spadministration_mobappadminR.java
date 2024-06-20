// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_mobappadminR implements CallerWithObjs {
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
  public String m_cPhName_cpappstore;
  public String m_cServer_cpappstore;
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
  public String appNames;
  public boolean forceCreateFile;
  public boolean ignoreFile;
  public boolean forceSaving;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spadministration_mobappadminR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spadministration_mobappadmin",m_Caller);
    m_cPhName_cpappstore = p_ContextObject.GetPhName("cpappstore");
    if (m_cPhName_cpappstore.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpappstore = m_cPhName_cpappstore+" "+m_Ctx.GetWritePhName("cpappstore");
    }
    m_cServer_cpappstore = p_ContextObject.GetServer("cpappstore");
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
      return "spadministration_mobappadmin";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("appNames",p_cVarName)) {
      return appNames;
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
    if (CPLib.eqr("forceCreateFile",p_cVarName)) {
      return forceCreateFile;
    }
    if (CPLib.eqr("ignoreFile",p_cVarName)) {
      return ignoreFile;
    }
    if (CPLib.eqr("forceSaving",p_cVarName)) {
      return forceSaving;
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
    if (CPLib.eqr("appNames",p_cVarName)) {
      appNames = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("forceCreateFile",p_cVarName)) {
      forceCreateFile = value;
      return;
    }
    if (CPLib.eqr("ignoreFile",p_cVarName)) {
      ignoreFile = value;
      return;
    }
    if (CPLib.eqr("forceSaving",p_cVarName)) {
      forceSaving = value;
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
  void main() throws Exception {
    /* appNames Memo */
    /* forceCreateFile Bool */
    /* ignoreFile Bool */
    /* appsToAdmin Object(String[]) // Applicazioni online trovate su disco */
    String[] appsToAdmin;
    appsToAdmin = null;
    /* forceSaving Bool */
    /* okRefresh Bool */
    boolean okRefresh;
    okRefresh = false;
    /* okRefresh := false */
    okRefresh = false;
    /* If Empty(appNames) */
    if (CPLib.Empty(appNames)) {
      appsToAdmin = new String[0];
      /* appsToAdmin := com.zucchetti.sitepainter.Library.GetAvailableMobileApps().toArray( appsToAdmin ) // Applicazioni online trovate su disco */
      appsToAdmin = com.zucchetti.sitepainter.Library.GetAvailableMobileApps().toArray(appsToAdmin);
    } else { // Else
      /* appsToAdmin := CPLib.Split( appNames, ',' ) // applicazioni passate come parametro */
      appsToAdmin = CPLib.Split(appNames,",");
      /* forceSaving := true */
      forceSaving = true;
    } // End If
    for (int i = 0; CPLib.ne(i,appsToAdmin.length); i = i + (1)) {
      /* okRefresh := okRefresh or CheckApp(appsToAdmin[i]) */
      okRefresh = okRefresh || CheckApp(appsToAdmin[i]);
    }
    /* Return okRefresh */
    throw new Stop(okRefresh);
  }
  boolean CheckApp(String appName) throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* appName Char(100) */
      /* appCode Char(10) */
      String appCode;
      appCode = CPLib.Space(10);
      /* bo_app Object(spadministration_mobappstoreBO) */
      spadministration_mobappstoreBO bo_app;
      bo_app = null;
      /* appCode := '' */
      appCode = "";
      /* bo_app := new spadministration_mobappstoreBO() */
      bo_app = new spadministration_mobappstoreBO(m_Ctx);
      // * --- Read from cpappstore
      m_cServer = m_Ctx.GetServer("cpappstore");
      m_cPhName = m_Ctx.GetPhName("cpappstore");
      m_cSql = "";
      m_cSql = m_cSql+"oaappmenu="+CPSql.SQLValueAdapter(CPLib.ToSQL(appName,"C",100,0,m_cServer),m_cServer,appName);
      if (m_Ctx.IsSharedTemp("cpappstore")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("oa__code",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        appCode = Read_Cursor.GetString("oa__code");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpappstore into routine spadministration_mobappadmin returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        appCode = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* bRes Bool */
      boolean bRes;
      bRes = false;
      /* If Empty( appCode ) */
      if (CPLib.Empty(appCode)) {
        /* Exec "Crea applicazione online" Page 3:CreateMobileApp( bo_app, appName ) */
        CreateMobileApp(bo_app,appName);
        /* bo_app.w_ignoreFile := ignoreFile */
        bo_app.w_ignoreFile = ignoreFile;
        /* bRes := bo_app.Save() */
        bRes = bo_app.Save();
        /* Error Msg bo_app.LastErrorMessage() */
        m_cLastMsgError = bo_app.LastErrorMessage();
        new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
        /* Page Return bRes */
        return bRes;
      } else { // Else
        /* If bo_app.Load( appCode ) */
        if (bo_app.Load(appCode)) {
          /* json_app Object(org.json.JSONObject) // Applicazione online prodotta dal plan */
          org.json.JSONObject json_app;
          json_app = null;
          /* json_app := com.zucchetti.sitepainter.Library.GetMobileApp( appName ) */
          json_app = com.zucchetti.sitepainter.Library.GetMobileApp(appName);
          /* bo_app.w_forceCreateFile := forceCreateFile */
          bo_app.w_forceCreateFile = forceCreateFile;
          /* bo_app.w_ignoreFile := ignoreFile */
          bo_app.w_ignoreFile = ignoreFile;
          /* If Trim(bo_app.w_oaappchecksum) <> json_app.optString( "checksum" ) */
          if (CPLib.ne(CPLib.Trim(bo_app.w_oaappchecksum),json_app.optString("checksum"))) {
            /* Exec "Compila applicazione online" Page 4:FillMobileApp( bo_app, json_app ) */
            FillMobileApp(bo_app,json_app);
            /* bRes := bo_app.Save() */
            bRes = bo_app.Save();
            /* Error Msg bo_app.LastErrorMessage() */
            m_cLastMsgError = bo_app.LastErrorMessage();
            new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
            /* Page Return bRes */
            return bRes;
            /* ElseIf forceSaving */
          } else if (forceSaving) {
            /* bo_app.SetUpdated() */
            bo_app.SetUpdated();
            /* bRes := bo_app.Save() */
            bRes = bo_app.Save();
            /* Error Msg bo_app.LastErrorMessage() */
            m_cLastMsgError = bo_app.LastErrorMessage();
            new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
            /* Page Return bRes */
            return bRes;
          } // End If
          /* Page Return false */
          return false;
        } else { // Else
          /* Error Msg bo_app.LastErrorMessage() */
          m_cLastMsgError = bo_app.LastErrorMessage();
          new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
          /* Page Return false */
          return false;
        } // End If
      } // End If
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void CreateMobileApp(spadministration_mobappstoreBO bo_app,String appName) throws Exception {
    /* bo_app Object(spadministration_mobappstoreBO) // BO applicazione mobile da salvare */
    /* appName Char(50) // nome dell'applicazione */
    /* -- assert not( bo_app.m_bLoaded ) */
    /* bo_app.Initialize() */
    bo_app.Initialize();
    /* bo_app.Set_oaappmenu(appName) // nome del plan = nome dell'applicazione */
    bo_app.Set_oaappmenu(appName);
    /* Exec "Compila applicazione online" Page 4:FillMobileApp( bo_app, com.zucchetti.sitepainter.Library.GetMobileApp( appName ) ) */
    FillMobileApp(bo_app,com.zucchetti.sitepainter.Library.GetMobileApp(appName));
  }
  void FillMobileApp(spadministration_mobappstoreBO bo_app,org.json.JSONObject json_app) throws Exception {
    /* bo_app Object(spadministration_mobappstoreBO) // BO applicazione online da salvare */
    /* -- assert not( bo_app.m_bLoaded ) */
    /* json_app Object(org.json.JSONObject) // Applicazione online prodotta dal plan */
    /* -- assert not( IsNull( json_app ) ) */
    /* bo_app.Set_oadescri(json_app.optString( "description","No description submitted" )) // descrizione */
    bo_app.Set_oadescri(json_app.optString("description","No description submitted"));
    /* bo_app.Set_oaapptitle(json_app.optString( "title" )) // titolo */
    bo_app.Set_oaapptitle(json_app.optString("title"));
    /* bo_app.Set_oaapplogo(json_app.optString( "logo" )) // logo */
    bo_app.Set_oaapplogo(json_app.optString("logo"));
    /* bo_app.Set_oaappfavico(json_app.optString( "icon" )) // icona */
    bo_app.Set_oaappfavico(json_app.optString("icon"));
    /* bo_app.Set_oaapplanding(json_app.optString( "landingPage" )) // Landing page */
    bo_app.Set_oaapplanding(json_app.optString("landingPage"));
    /* bo_app.Set_oaappheader(json_app.optString( "header" )) // header */
    bo_app.Set_oaappheader(json_app.optString("header"));
    /* bo_app.Set_oaappdescrheader(json_app.optString( "descrHeader" )) // header */
    bo_app.Set_oaappdescrheader(json_app.optString("descrHeader"));
    /* bo_app.Set_oaapphideutilitygroup(json_app.optDouble( "hideControlPanel" ,0)) // Hide menu utility: 1 hide, 0 display */
    bo_app.Set_oaapphideutilitygroup(json_app.optDouble("hideControlPanel",0));
    /* bo_app.Set_oaapphomelink(json_app.optString( "homeLink" , "index")) // homelink: index - default */
    bo_app.Set_oaapphomelink(json_app.optString("homeLink","index"));
    /* bo_app.Set_oaskinname(json_app.optString( "skinName" ,"iMobile")) // Skin name, if empty set iMobile (default) */
    bo_app.Set_oaskinname(json_app.optString("skinName","iMobile"));
    /* bo_app.Set_oaappvariantname(json_app.optString( "skinVariant" ,"")) // Skin variant name: EMPTY default */
    bo_app.Set_oaappvariantname(json_app.optString("skinVariant",""));
    /* bo_app.Set_OAAPPACCESSMODE(json_app.optString( "access_mode" ,"browser_and_hybrid")) // Access mode */
    bo_app.Set_OAAPPACCESSMODE(json_app.optString("access_mode","browser_and_hybrid"));
    /* bo_app.Set_oaappchecksum(json_app.optString( "checksum" )) // checksum */
    bo_app.Set_oaappchecksum(json_app.optString("checksum"));
    /* bo_app.CtxLoad_spadministration_dmobapp_qkm() // Figlio quick menu */
    bo_app.CtxLoad_spadministration_dmobapp_qkm();
    /* bo_dqkm_app Object(spadministration_dmobapp_qkmBO) // Quick menu per applicazione */
    spadministration_dmobapp_qkmBO bo_dqkm_app;
    bo_dqkm_app = null;
    /* bo_dqkm_app := bo_app.spadministration_dmobapp_qkm // Quick menu per applicazione */
    bo_dqkm_app = bo_app.spadministration_dmobapp_qkm;
    /* json_quickmenu Object(org.json.JSONArray) */
    org.json.JSONArray json_quickmenu;
    json_quickmenu = null;
    /* json_quickmenu := json_app.optJSONArray( "quickmenu" ) */
    json_quickmenu = json_app.optJSONArray("quickmenu");
    /* If not( IsNull( json_quickmenu ) ) and json_quickmenu.length() > 0 */
    if ( ! (CPLib.IsNull(json_quickmenu)) && CPLib.gt(json_quickmenu.length(),0)) {
      /* While bo_dqkm_app.Rows() > 0 */
      while (CPLib.gt(bo_dqkm_app.Rows(),0)) {
        /* bo_dqkm_app.SetRow(0) // Imposta riga corrente */
        bo_dqkm_app.SetRow(0);
        /* bo_dqkm_app.DeleteRow() // Cancella riga corrente */
        bo_dqkm_app.DeleteRow();
      } // End While
      for (int varIdx = 0; CPLib.ne(varIdx,json_quickmenu.length()); varIdx = varIdx + (1)) {
        /* json_mo Object(org.json.JSONObject) */
        org.json.JSONObject json_mo;
        json_mo = null;
        /* json_mo := json_quickmenu.optJSONObject(varIdx) */
        json_mo = json_quickmenu.optJSONObject(varIdx);
        /* bo_dqkm_app.AddRow() // Crea nuova riga */
        bo_dqkm_app.AddRow();
        /* bo_dqkm_app.Set_QA_LABEL(json_mo.optString('description')) */
        bo_dqkm_app.Set_QA_LABEL(json_mo.optString("description"));
        /* bo_dqkm_app.Set_QA_URL(json_mo.optString('url')) */
        bo_dqkm_app.Set_QA_URL(json_mo.optString("url"));
        /* bo_dqkm_app.Set_QA_ICON(json_mo.optString('icon')) */
        bo_dqkm_app.Set_QA_ICON(json_mo.optString("icon"));
        /* bo_dqkm_app.SaveRow() // Salva riga corrente */
        bo_dqkm_app.SaveRow();
      }
    } // End If
  }
  void _init_() {
  }
  public String RunAsync(String p_appNames,boolean p_forceCreateFile,boolean p_ignoreFile) {
    appNames = p_appNames;
    forceCreateFile = p_forceCreateFile;
    ignoreFile = p_ignoreFile;
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
  public boolean Run(String p_appNames,boolean p_forceCreateFile,boolean p_ignoreFile) {
    appNames = p_appNames;
    forceCreateFile = p_forceCreateFile;
    ignoreFile = p_ignoreFile;
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
          main();
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
  public static spadministration_mobappadminR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spadministration_mobappadminR(p_Ctx, p_Caller);
  }
  public static spadministration_mobappadminR Make(CPContext p_Ctx) {
    return new spadministration_mobappadminR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    appNames = "";
    forceCreateFile = false;
    ignoreFile = false;
    forceSaving = false;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,spadministration_mobappadmin,
  public static final String i_InvokedRoutines = ",spadministration_mobappadmin,";
  public static String[] m_cRunParameterNames={"appNames","forceCreateFile","ignoreFile"};
}
