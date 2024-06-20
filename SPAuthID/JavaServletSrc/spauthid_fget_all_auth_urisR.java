// * --- Area Manuale = BO - Header
// * --- spauthid_fget_all_auth_uris
import javax.servlet.http.*;
import org.json.*;
// * --- Fine Area Manuale
public class spauthid_fget_all_auth_urisR implements CallerWithObjs {
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
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spauthid_fget_all_auth_urisR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spauthid_fget_all_auth_uris",m_Caller);
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
      return "spauthid_fget_all_auth_uris";
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
    CPResultSet Cursor_spauthid_identity_provider=null;
    try {
      /* @param Nessun parametro
         @return un JSON convertito a stringa contenente authURI e autologin per ogni IdP */
      /* identityProvider Object(com.zucchetti.sitepainter.oauth.client.IdentityProvider) // classe di appoggio che calcola l'Auth URI a runtime */
      com.zucchetti.sitepainter.oauth.client.IdentityProvider identityProvider;
      identityProvider = null;
      /* jsonObj JSON // JSON di appoggio per popolare la classe IdentityProvider */
      com.zucchetti.sitepainter.datatypes.CPJSONStruct jsonObj;
      jsonObj = com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
      /* innerJson Object(JSONObject) // JSON di appoggio per popolare il risultato */
      JSONObject innerJson;
      innerJson = null;
      /* request Object(javax.servlet.http.HttpServletRequest) // utilizzata per settare il parametro state dell'Auth URI */
      javax.servlet.http.HttpServletRequest request;
      request = null;
      /* result JSON // il risultato finale sarà convertito a stringa tramite toString() */
      com.zucchetti.sitepainter.datatypes.CPJSONStruct result;
      result = com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
      /* request := getRequest() */
      request = getRequest();
      // * --- Select from spauthid_identity_provider
      m_cServer = m_Ctx.GetServer("spauthid_identity_provider");
      m_cPhName = m_Ctx.GetPhName("spauthid_identity_provider");
      if (Cursor_spauthid_identity_provider!=null)
        Cursor_spauthid_identity_provider.Close();
      Cursor_spauthid_identity_provider = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select  *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("spauthid_identity_provider")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_spauthid_identity_provider.Eof())) {
        /* jsonObj := jsonObj.EmptyStruct() */
        jsonObj = com.zucchetti.sitepainter.datatypes.CPJSONStruct.ToJSON(jsonObj.EmptyStruct());
        /* jsonObj.put("client_id", spauthid_identity_provider->client_id) */
        jsonObj.put("client_id",Cursor_spauthid_identity_provider.GetString("client_id"));
        /* jsonObj.put("client_secret", spauthid_identity_provider->client_secret) */
        jsonObj.put("client_secret",Cursor_spauthid_identity_provider.GetString("client_secret"));
        /* jsonObj.put("auth_uri", spauthid_identity_provider->auth_uri) */
        jsonObj.put("auth_uri",Cursor_spauthid_identity_provider.GetString("auth_uri"));
        /* jsonObj.put("token_uri", spauthid_identity_provider->token_uri) */
        jsonObj.put("token_uri",Cursor_spauthid_identity_provider.GetString("token_uri"));
        /* jsonObj.put("scope", spauthid_identity_provider->scope) */
        jsonObj.put("scope",Cursor_spauthid_identity_provider.GetString("scope"));
        /* jsonObj.put("redirect_uri", spauthid_identity_provider->redirect_uri) */
        jsonObj.put("redirect_uri",Cursor_spauthid_identity_provider.GetString("redirect_uri"));
        /* jsonObj.put("jwks_uri", spauthid_identity_provider->jwks_uri) */
        jsonObj.put("jwks_uri",Cursor_spauthid_identity_provider.GetString("jwks_uri"));
        /* jsonObj.put("name", spauthid_identity_provider->idp_name) */
        jsonObj.put("name",Cursor_spauthid_identity_provider.GetString("idp_name"));
        JSONObject j =  new JSONObject(jsonObj.toJSONString());
        /* identityProvider := identityProvider.fromJSON(j) */
        identityProvider = identityProvider.fromJSON(j);
        /* innerJson := new JSONObject() */
        innerJson = new JSONObject();
        /* innerJson.put('uri', identityProvider.makeAuthURI(request.getSession())) */
        innerJson.put("uri",identityProvider.makeAuthURI(request.getSession()));
        /* innerJson.put('autologin', spauthid_identity_provider->autologin) */
        innerJson.put("autologin",Cursor_spauthid_identity_provider.GetString("autologin"));
        /* result.put(spauthid_identity_provider->code, innerJson) */
        result.put(Cursor_spauthid_identity_provider.GetString("code"),innerJson);
        Cursor_spauthid_identity_provider.Next();
      }
      m_cConnectivityError = Cursor_spauthid_identity_provider.ErrorMessage();
      Cursor_spauthid_identity_provider.Close();
      // * --- End Select
      /* Return result.toString() */
      throw new Stop(result.toString());
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
  javax.servlet.http.HttpServletRequest getRequest() throws Exception {
    /* Determina Http Request */
    /* httpRequest Object(javax.servlet.http.HttpServletRequest) */
    javax.servlet.http.HttpServletRequest httpRequest;
    httpRequest = null;
    /* httpResponse Object(javax.servlet.http.HttpServletResponse) */
    javax.servlet.http.HttpServletResponse httpResponse;
    httpResponse = null;
    javax.servlet.http.HttpServletRequest[] req = {null};
    javax.servlet.http.HttpServletResponse[] resp = {null};
    com.zucchetti.sitepainter.Library.GetRequestResponse(req, resp);
    httpRequest = req[0];
    httpResponse = resp[0];
    /* Page Return httpRequest */
    return httpRequest;
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
  public static spauthid_fget_all_auth_urisR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spauthid_fget_all_auth_urisR(p_Ctx, p_Caller);
  }
  public static spauthid_fget_all_auth_urisR Make(CPContext p_Ctx) {
    return new spauthid_fget_all_auth_urisR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
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
