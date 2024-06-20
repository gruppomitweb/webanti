// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_mobapplistR implements CallerWithObjs {
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
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spadministration_mobapplistR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spadministration_mobapplist",m_Caller);
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
      return "spadministration_mobapplist";
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
    CPResultSet Cursor_spquery_mobappstore=null;
    CPResultSet Cursor_cpappstore=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* apps Object(String[]) // Applicazioni mobile trovate su disco */
      String[] apps;
      apps = null;
      apps = new String[0];
      /* listMobAppStore MemoryCursor(spmc_mobappstore.MCRDef) */
      MemoryCursor_spmc_mobappstore_mcrdef listMobAppStore;
      listMobAppStore = new MemoryCursor_spmc_mobappstore_mcrdef();
      /* appOnDBtoMC MemoryCursor(spadminstration_mobapplist_mc.MCRDef) */
      MemoryCursor_spadminstration_mobapplist_mc_mcrdef appOnDBtoMC;
      appOnDBtoMC = new MemoryCursor_spadminstration_mobapplist_mc_mcrdef();
      /* apps := com.zucchetti.sitepainter.Library.GetAvailableMobileApps().toArray( apps ) // Applicazioni offline trovate su disco */
      apps = com.zucchetti.sitepainter.Library.GetAvailableMobileApps().toArray(apps);
      // * --- Fill memory cursor listMobAppStore on spquery_mobappstore
      listMobAppStore.Zap();
      if (Cursor_spquery_mobappstore!=null)
        Cursor_spquery_mobappstore.Close();
      Cursor_spquery_mobappstore = new VQRHolder("spquery_mobappstore",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_spquery_mobappstore;
        Cursor_spquery_mobappstore.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine spadministration_mobapplist: query on spquery_mobappstore returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_spquery_mobappstore.Eof())) {
        listMobAppStore.AppendWithTrimmedKey(Cursor_spquery_mobappstore.GetString("oaappmenu"));
        listMobAppStore.row.oa__code = Cursor_spquery_mobappstore.GetString("oa__code");
        listMobAppStore.row.oaapptitle = Cursor_spquery_mobappstore.GetString("oaapptitle");
        listMobAppStore.row.oaapplogo = Cursor_spquery_mobappstore.GetString("oaapplogo");
        listMobAppStore.row.oaappmenu = Cursor_spquery_mobappstore.GetString("oaappmenu");
        listMobAppStore.row.oareserved = Cursor_spquery_mobappstore.GetString("oareserved");
        listMobAppStore.row.oaappchecksum = Cursor_spquery_mobappstore.GetString("oaappchecksum");
        listMobAppStore.row.oatoadmin = Cursor_spquery_mobappstore.GetDouble("oatoadmin");
        listMobAppStore.row.oaapptype = Cursor_spquery_mobappstore.GetDouble("oaapptype");
        listMobAppStore.row.oaapppublished = Cursor_spquery_mobappstore.GetDouble("oaapppublished");
        Cursor_spquery_mobappstore.Next();
      }
      m_cConnectivityError = Cursor_spquery_mobappstore.ErrorMessage();
      Cursor_spquery_mobappstore.Close();
      listMobAppStore.GoTop();
      // * --- Fill memory cursor appOnDBtoMC on cpappstore
      appOnDBtoMC.Zap();
      m_cServer = m_Ctx.GetServer("cpappstore");
      m_cPhName = m_Ctx.GetPhName("cpappstore");
      if (Cursor_cpappstore!=null)
        Cursor_cpappstore.Close();
      Cursor_cpappstore = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select oa__code,oaappmenu,oaappchecksum,oaapppublished  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpappstore")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_cpappstore;
        Cursor_cpappstore.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine spadministration_mobapplist: query on cpappstore returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_cpappstore.Eof())) {
        appOnDBtoMC.AppendWithTrimmedKey(Cursor_cpappstore.GetString("oaappmenu"));
        appOnDBtoMC.row.oa__code = Cursor_cpappstore.GetString("oa__code");
        appOnDBtoMC.row.oaappmenu = Cursor_cpappstore.GetString("oaappmenu");
        appOnDBtoMC.row.oaappchecksum = Cursor_cpappstore.GetString("oaappchecksum");
        Cursor_cpappstore.Next();
      }
      m_cConnectivityError = Cursor_cpappstore.ErrorMessage();
      Cursor_cpappstore.Close();
      appOnDBtoMC.GoTop();
      /* appName Char(100) */
      String appName;
      appName = CPLib.Space(100);
      for (int i = 0; CPLib.ne(i,apps.length); i = i + (1)) {
        /* appName := apps[i] */
        appName = apps[i];
        /* json_app Object(org.json.JSONObject) // Applicazione offline prodotta dal plan */
        org.json.JSONObject json_app;
        json_app = null;
        /* json_app := com.zucchetti.sitepainter.Library.GetMobileApp( appName ) */
        json_app = com.zucchetti.sitepainter.Library.GetMobileApp(appName);
        /* If listMobAppStore.HasKey( appName ) */
        if (listMobAppStore.HasKey(appName)) {
          /* -- controlla app su disco */
          /* listMobAppStore.GoToKey(appName) */
          listMobAppStore.GoToKey(appName);
          /* listMobAppStore.oaapptype := 1 */
          listMobAppStore.row.oaapptype = 1;
          /* If LRTrim( listMobAppStore.oaappchecksum ) <> LRTrim( json_app.optString( "checksum" ) ) or spadministration_checkmobappdir( appName ) */
          if (CPLib.ne(CPLib.LRTrim(listMobAppStore.row.oaappchecksum),CPLib.LRTrim(json_app.optString("checksum"))) || spadministration_checkmobappdirR.Make(m_Ctx,this).Run(appName)) {
            /* listMobAppStore.oatoadmin := 1 */
            listMobAppStore.row.oatoadmin = 1;
            /* listMobAppStore.SaveRow() */
            listMobAppStore.SaveRow();
          } // End If
          /* appOnDBtoMC.GoToKey(appName) */
          appOnDBtoMC.GoToKey(appName);
          /* appOnDBtoMC.Delete() */
          appOnDBtoMC.Delete();
        } else { // Else
          /* -- nuova app da amministrare */
          /* listMobAppStore.AppendWithKey(appName) */
          listMobAppStore.AppendWithKey(appName);
          /* listMobAppStore.oa__code := 'NOT ADMIN.' */
          listMobAppStore.row.oa__code = "NOT ADMIN.";
          /* listMobAppStore.oatoadmin := 2 */
          listMobAppStore.row.oatoadmin = 2;
          /* listMobAppStore.oaapptitle := json_app.optString( 'title' ) */
          listMobAppStore.row.oaapptitle = json_app.optString("title");
          /* listMobAppStore.oaapplogo := json_app.optString( 'logo' ) */
          listMobAppStore.row.oaapplogo = json_app.optString("logo");
          /* listMobAppStore.oaappmenu := appName */
          listMobAppStore.row.oaappmenu = appName;
          /* listMobAppStore.oaapptype := 1 */
          listMobAppStore.row.oaapptype = 1;
          /* listMobAppStore.oaapppublished := json_app.optDouble( 'published', 1.0 ) */
          listMobAppStore.row.oaapppublished = json_app.optDouble("published",1.0);
          /* listMobAppStore.SaveRow() */
          listMobAppStore.SaveRow();
        } // End If
      }
      for (MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef appOnDBtoMCRow : appOnDBtoMC._iterable_()) {
        /* -- app presenti su db ma non su disco */
        /* appName := appOnDBtoMCRow.oaappmenu */
        appName = appOnDBtoMCRow.oaappmenu;
        /* listMobAppStore.GoToKey(appName) */
        listMobAppStore.GoToKey(appName);
        /* listMobAppStore.oatoadmin := iif (spadministration_checkmobappdir(appName) , 1, 0 ) */
        listMobAppStore.row.oatoadmin = (spadministration_checkmobappdirR.Make(m_Ctx,this).Run(appName)?1:0);
        /* listMobAppStore.oaapptype := 2 */
        listMobAppStore.row.oaapptype = 2;
      }
      /* Return listMobAppStore */
      throw new Stop(listMobAppStore);
    } finally {
      try {
        if (Cursor_spquery_mobappstore!=null)
          Cursor_spquery_mobappstore.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cpappstore!=null)
          Cursor_cpappstore.Close();
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
  public MemoryCursor_spmc_mobappstore_mcrdef Run() {
    MemoryCursor_spmc_mobappstore_mcrdef l_result;
    l_result = null;
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
        l_result = (MemoryCursor_spmc_mobappstore_mcrdef)stop_value.GetObject();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = null;
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
  public static spadministration_mobapplistR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spadministration_mobapplistR(p_Ctx, p_Caller);
  }
  public static spadministration_mobapplistR Make(CPContext p_Ctx) {
    return new spadministration_mobapplistR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,spquery_mobappstore,
  public static final String m_cVQRList = ",spquery_mobappstore,";
  // ENTITY_BATCHES: ,spadministration_checkmobappdir,spadministration_mobapplist,
  public static final String i_InvokedRoutines = ",spadministration_checkmobappdir,spadministration_mobapplist,";
  public static String[] m_cRunParameterNames={};
}
