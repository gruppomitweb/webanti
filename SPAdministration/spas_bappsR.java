// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spas_bappsR implements CallerWithObjs {
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
  public String appsAsStr;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spas_bappsR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spas_bapps",m_Caller);
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
      return "spas_bapps";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("appsAsStr",p_cVarName)) {
      return appsAsStr;
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
    if (CPLib.eqr("appsAsStr",p_cVarName)) {
      appsAsStr = value;
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
    CPResultSet Cursor_spma_qgetinfo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* apps Object(org.json.JSONArray) // Array di apps */
      org.json.JSONArray apps;
      apps = null;
      /* apps := new org.json.JSONArray() // Array di apps */
      apps = new org.json.JSONArray();
      /* online */
      // * --- Select from spma_qgetinfo
      if (Cursor_spma_qgetinfo!=null)
        Cursor_spma_qgetinfo.Close();
      Cursor_spma_qgetinfo = new VQRHolder("spma_qgetinfo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_spma_qgetinfo.Eof())) {
        /* appOnline Object(org.json.JSONObject) // App online */
        org.json.JSONObject appOnline;
        appOnline = null;
        /* appOnline := new org.json.JSONObject() */
        appOnline = new org.json.JSONObject();
        /* appOnline.put('isOnline', true) */
        appOnline.put("isOnline",true);
        /* appOnline.put('url',  RTrim( spma_qgetinfo->OAAPPPLAN) + '/') */
        appOnline.put("url",CPLib.RTrim(Cursor_spma_qgetinfo.GetString("OAAPPPLAN"))+"/");
        /* appOnline.put('name', RTrim(spma_qgetinfo->OAAPPTITLE)) */
        appOnline.put("name",CPLib.RTrim(Cursor_spma_qgetinfo.GetString("OAAPPTITLE")));
        /* appOnline.put('details', RTrim(spma_qgetinfo->OADESCRI)) */
        appOnline.put("details",CPLib.RTrim(Cursor_spma_qgetinfo.GetString("OADESCRI")));
        /* appOnline.put('icon', RTrim(spma_qgetinfo->OAAPPLOGO)) // BOLSTE 22/12/2017 Retrocompatibilità: vedi commento */
        appOnline.put("icon",CPLib.RTrim(Cursor_spma_qgetinfo.GetString("OAAPPLOGO")));
        /* appOnline.put('logo', RTrim(spma_qgetinfo->OAAPPLOGO)) */
        appOnline.put("logo",CPLib.RTrim(Cursor_spma_qgetinfo.GetString("OAAPPLOGO")));
        /* appOnline.put('code', RTrim(spma_qgetinfo->oa__code)) */
        appOnline.put("code",CPLib.RTrim(Cursor_spma_qgetinfo.GetString("oa__code")));
        /* If spma_qgetinfo->oaappreqreg=1 */
        if (CPLib.eqr(Cursor_spma_qgetinfo.GetDouble("oaappreqreg"),1)) {
          /* appOnline.put('registration_url', RTrim(spma_qgetinfo->oaappurlreg)) */
          appOnline.put("registration_url",CPLib.RTrim(Cursor_spma_qgetinfo.GetString("oaappurlreg")));
        } // End If
        /* apps.put(appOnline) */
        apps.put(appOnline);
        Cursor_spma_qgetinfo.Next();
      }
      m_cConnectivityError = Cursor_spma_qgetinfo.ErrorMessage();
      Cursor_spma_qgetinfo.Close();
      // * --- End Select
      /* appsAsStr Char(0) // Apps JSON serializzate in Stringa */
      /* appsAsStr := apps.toString() // Apps JSON serializzate in Stringa */
      appsAsStr = apps.toString();
      /* Fire Event 'SPGettingMobileApps' */
      try {
        m_bEventRunning = true;
        com.zucchetti.sitepainter.EventHandler.notifyEvent("SPGettingMobileApps",this,m_Ctx,specificEventsHandlers,allEventsHandlers);
      } finally {
        m_bEventRunning = false;
      }
      /* Stop type.json */
      Forward f;
      f=new Forward(Forward.m_cDirectToClient,false,this,Forward.NoStatus,true);
      f.SetParameter(Forward.m_cContentToShow,appsAsStr);
      f.SetParameter(Forward.m_cFilenameForClient,"type.json");
      f.SetParameter("m_cParameterSequence",Forward.m_cContentToShow+","+Forward.m_cFilenameForClient);
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_spma_qgetinfo!=null)
          Cursor_spma_qgetinfo.Close();
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static spas_bappsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spas_bappsR(p_Ctx, p_Caller);
  }
  public void Blank() {
    appsAsStr = CPLib.Space(0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,spma_qgetinfo,
  public static final String m_cVQRList = ",spma_qgetinfo,";
  // ENTITY_BATCHES: ,spas_bapps,
  public static final String i_InvokedRoutines = ",spas_bapps,";
  public static String[] m_cRunParameterNames={};
}
