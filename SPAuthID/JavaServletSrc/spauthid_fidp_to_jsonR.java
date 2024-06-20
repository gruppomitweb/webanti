// * --- Area Manuale = BO - Header
// * --- spauthid_fidp_to_json
import org.json.JSONObject;
// * --- Fine Area Manuale
public class spauthid_fidp_to_jsonR implements CallerWithObjs {
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
  public String m_cPhName_spauthid_identity_provider;
  public String m_cServer_spauthid_identity_provider;
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
  public String pIdpCode;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spauthid_fidp_to_jsonR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spauthid_fidp_to_json",m_Caller);
    m_cPhName_spauthid_identity_provider = p_ContextObject.GetPhName("spauthid_identity_provider");
    if (m_cPhName_spauthid_identity_provider.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_spauthid_identity_provider = m_cPhName_spauthid_identity_provider+" "+m_Ctx.GetWritePhName("spauthid_identity_provider");
    }
    m_cServer_spauthid_identity_provider = p_ContextObject.GetServer("spauthid_identity_provider");
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
      return "spauthid_fidp_to_json";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pIdpCode",p_cVarName)) {
      return pIdpCode;
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
    if (CPLib.eqr("pIdpCode",p_cVarName)) {
      pIdpCode = value;
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
    CPResultSet Cursor_spauthid_identity_provider=null;
    try {
      /* Recupera i dati di un idp e li restituisce in formato JSON
         @param pIdpCode il codice dell'Identity provider di cui recuperare i dati
         @return result un JSON che contiene i dati dell'idp */
      /* pIdpCode Char(0) */
      /* result Object(org.json.JSONObject) */
      org.json.JSONObject result;
      result = null;
      /* result := new org.json.JSONObject() */
      result = new org.json.JSONObject();
      // * --- Select from spauthid_identity_provider
      m_cServer = m_Ctx.GetServer("spauthid_identity_provider");
      m_cPhName = m_Ctx.GetPhName("spauthid_identity_provider");
      if (Cursor_spauthid_identity_provider!=null)
        Cursor_spauthid_identity_provider.Close();
      Cursor_spauthid_identity_provider = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"code = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pIdpCode,"?",0,0,m_cServer, m_oParameters),m_cServer,pIdpCode)+" "+")"+(m_Ctx.IsSharedTemp("spauthid_identity_provider")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_spauthid_identity_provider.Eof())) {
        /* result.put("client_id", spauthid_identity_provider->client_id) */
        result.put("client_id",Cursor_spauthid_identity_provider.GetString("client_id"));
        /* result.put("client_secret", spauthid_identity_provider->client_secret) */
        result.put("client_secret",Cursor_spauthid_identity_provider.GetString("client_secret"));
        /* result.put("auth_uri", spauthid_identity_provider->auth_uri) */
        result.put("auth_uri",Cursor_spauthid_identity_provider.GetString("auth_uri"));
        /* result.put("token_uri", spauthid_identity_provider->token_uri) */
        result.put("token_uri",Cursor_spauthid_identity_provider.GetString("token_uri"));
        /* result.put("scope", spauthid_identity_provider->scope) */
        result.put("scope",Cursor_spauthid_identity_provider.GetString("scope"));
        /* result.put("redirect_uri", spauthid_identity_provider->redirect_uri) */
        result.put("redirect_uri",Cursor_spauthid_identity_provider.GetString("redirect_uri"));
        /* result.put("jwks_uri", spauthid_identity_provider->jwks_uri) */
        result.put("jwks_uri",Cursor_spauthid_identity_provider.GetString("jwks_uri"));
        /* result.put("autologin", spauthid_identity_provider->autologin) */
        result.put("autologin",Cursor_spauthid_identity_provider.GetString("autologin"));
        /* result.put("mutual_jwks", spauthid_identity_provider->mutual_jwks) */
        result.put("mutual_jwks",Cursor_spauthid_identity_provider.GetString("mutual_jwks"));
        // Exit Loop
        if (true) {
          break;
        }
        Cursor_spauthid_identity_provider.Next();
      }
      m_cConnectivityError = Cursor_spauthid_identity_provider.ErrorMessage();
      Cursor_spauthid_identity_provider.Close();
      // * --- End Select
      /* Return result */
      throw new Stop(result);
    } finally {
      try {
        if (Cursor_spauthid_identity_provider!=null)
          Cursor_spauthid_identity_provider.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pIdpCode) {
    pIdpCode = p_pIdpCode;
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
  public org.json.JSONObject Run(String p_pIdpCode) {
    pIdpCode = p_pIdpCode;
    return Run();
  }
  public org.json.JSONObject Run() {
    org.json.JSONObject l_result;
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
        l_result = (org.json.JSONObject)stop_value.GetObject();
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
  public static spauthid_fidp_to_jsonR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spauthid_fidp_to_jsonR(p_Ctx, p_Caller);
  }
  public static spauthid_fidp_to_jsonR Make(CPContext p_Ctx) {
    return new spauthid_fidp_to_jsonR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pIdpCode = CPLib.Space(0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pIdpCode"};
}
