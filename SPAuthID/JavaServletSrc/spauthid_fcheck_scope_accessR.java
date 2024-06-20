// * --- Area Manuale = BO - Header
// * --- spauthid_fcheck_scope_access
import java.util.*;
// * --- Fine Area Manuale
public class spauthid_fcheck_scope_accessR implements CallerWithObjs {
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
  public String m_cPhName_spauthid_client_scope_mapping;
  public String m_cServer_spauthid_client_scope_mapping;
  public String m_cPhName_cpusers;
  public String m_cServer_cpusers;
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
  public String pScopes;
  public String pClientId;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spauthid_fcheck_scope_accessR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spauthid_fcheck_scope_access",m_Caller);
    m_cPhName_spauthid_client_scope_mapping = p_ContextObject.GetPhName("spauthid_client_scope_mapping");
    if (m_cPhName_spauthid_client_scope_mapping.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_spauthid_client_scope_mapping = m_cPhName_spauthid_client_scope_mapping+" "+m_Ctx.GetWritePhName("spauthid_client_scope_mapping");
    }
    m_cServer_spauthid_client_scope_mapping = p_ContextObject.GetServer("spauthid_client_scope_mapping");
    m_cPhName_cpusers = p_ContextObject.GetPhName("cpusers");
    if (m_cPhName_cpusers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers = m_cPhName_cpusers+" "+m_Ctx.GetWritePhName("cpusers");
    }
    m_cServer_cpusers = p_ContextObject.GetServer("cpusers");
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
      return "spauthid_fcheck_scope_access";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pScopes",p_cVarName)) {
      return pScopes;
    }
    if (CPLib.eqr("pClientId",p_cVarName)) {
      return pClientId;
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
    if (CPLib.eqr("pScopes",p_cVarName)) {
      pScopes = value;
      return;
    }
    if (CPLib.eqr("pClientId",p_cVarName)) {
      pClientId = value;
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_spauthid_qcount_requested_scopes=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Controlla se il client ha accesso a TUTTI gli scope richiesti
         @param pScopes gli scope richiesti
         @param clientId l'username del client che richiede le risorse
         @return true/false che indica se si ha accesso o meno */
      /* pScopes Char(0) */
      /* pClientId Char(0) */
      /* allowedScopeCount Numeric(0, 0) */
      double allowedScopeCount;
      allowedScopeCount = 0;
      /* clientCode Numeric(9, 0) */
      double clientCode;
      clientCode = 0;
      /* commaSeparatedScopes Object(StringBuilder) */
      StringBuilder commaSeparatedScopes;
      commaSeparatedScopes = null;
      /* requestedScopeCount Numeric(0, 0) */
      double requestedScopeCount;
      requestedScopeCount = 0;
      /* separator Char(0) := " " // spazio */
      String separator;
      separator = " ";
      /* Recupero il codice utente dal client id filtrando per utenti "machine" */
      // * --- Read from cpusers
      m_cServer = m_Ctx.GetServer("cpusers");
      m_cPhName = m_Ctx.GetPhName("cpusers");
      m_cSql = "";
      m_cSql = m_cSql+"name="+CPSql.SQLValueAdapter(CPLib.ToSQL(pClientId,"C",50,0,m_cServer),m_cServer,pClientId);
      m_cSql = m_cSql+" and accesstype_machine="+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"L",1,0,m_cServer),m_cServer,1);
      m_cSql = m_cSql+" and accesstype_service="+CPSql.SQLValueAdapter(CPLib.ToSQL(0,"L",1,0,m_cServer),m_cServer,0);
      m_cSql = m_cSql+" and accesstype_human="+CPSql.SQLValueAdapter(CPLib.ToSQL(0,"L",1,0,m_cServer),m_cServer,0);
      if (m_Ctx.IsSharedTemp("cpusers")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("code",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        clientCode = Read_Cursor.GetDouble("code");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpusers into routine spauthid_fcheck_scope_access returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        clientCode = 0;
        Read_Cursor.Close();
        /* Return False */
        throw new Stop(false);
      }
      /* commaSeparatedScopes := new StringBuilder() */
      commaSeparatedScopes = new StringBuilder();
      /* Creo una stringa del tipo " 'scope1', 'scope2', ..." */
      String[] requestedElements = pScopes.split(separator);
       for (String element : requestedElements) {
         commaSeparatedScopes.append("'" + element + "',");
      }
      /* requestedScopeCount := requestedElements .length */
      requestedScopeCount = CPLib.Round(requestedElements.length,0);
      // * --- Select from spauthid_qcount_requested_scopes
      SPBridge.HMCaller _h00000012;
      _h00000012 = new SPBridge.HMCaller();
      _h00000012.Set("m_cVQRList",m_cVQRList);
      _h00000012.Set("pScopes",commaSeparatedScopes.toString());
      _h00000012.Set("pClientCode",clientCode);
      if (Cursor_spauthid_qcount_requested_scopes!=null)
        Cursor_spauthid_qcount_requested_scopes.Close();
      Cursor_spauthid_qcount_requested_scopes = new VQRHolder("spauthid_qcount_requested_scopes",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000012,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_spauthid_qcount_requested_scopes.Eof())) {
        /* allowedScopeCount := spauthid_qcount_requested_scopes->scopeCount */
        allowedScopeCount = CPLib.Round(Cursor_spauthid_qcount_requested_scopes.GetDouble("scopeCount"),0);
        // Exit Loop
        if (true) {
          break;
        }
        Cursor_spauthid_qcount_requested_scopes.Next();
      }
      m_cConnectivityError = Cursor_spauthid_qcount_requested_scopes.ErrorMessage();
      Cursor_spauthid_qcount_requested_scopes.Close();
      // * --- End Select
      /* Il client può chiedere tutti gli scope per cui ha accesso o un suo sottoinsieme */
      /* Return requestedScopeCount = allowedScopeCount */
      throw new Stop(CPLib.eqr(requestedScopeCount,allowedScopeCount));
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_spauthid_qcount_requested_scopes!=null)
          Cursor_spauthid_qcount_requested_scopes.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pScopes,String p_pClientId) {
    pScopes = p_pScopes;
    pClientId = p_pClientId;
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
  public boolean Run(String p_pScopes,String p_pClientId) {
    pScopes = p_pScopes;
    pClientId = p_pClientId;
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
  public static spauthid_fcheck_scope_accessR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spauthid_fcheck_scope_accessR(p_Ctx, p_Caller);
  }
  public static spauthid_fcheck_scope_accessR Make(CPContext p_Ctx) {
    return new spauthid_fcheck_scope_accessR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pScopes = CPLib.Space(0);
    pClientId = CPLib.Space(0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,spauthid_qcount_requested_scopes,
  public static final String m_cVQRList = ",spauthid_qcount_requested_scopes,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pScopes","pClientId"};
}
