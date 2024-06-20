// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spas_fgetlicenseR implements CallerWithObjs {
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
  public String cJSONObjectLicenseData;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spas_fgetlicenseR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spas_fgetlicense",m_Caller);
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
      return "spas_fgetlicense";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("cJSONObjectLicenseData",p_cVarName)) {
      return cJSONObjectLicenseData;
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
    if (CPLib.eqr("cJSONObjectLicenseData",p_cVarName)) {
      cJSONObjectLicenseData = value;
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
    /* licenseObject Object(org.json.JSONObject) // Licenza */
    org.json.JSONObject licenseObject;
    licenseObject = null;
    /* cJSONObjectLicenseData Memo // Dati di licenza in formato JSON */
    /* Fire Event 'Getting license data' */
    try {
      m_bEventRunning = true;
      com.zucchetti.sitepainter.EventHandler.notifyEvent("Getting license data",this,m_Ctx,specificEventsHandlers,allEventsHandlers);
    } finally {
      m_bEventRunning = false;
    }
    /* If Empty( cJSONObjectLicenseData ) */
    if (CPLib.Empty(cJSONObjectLicenseData)) {
      /* licenseObject := com.zucchetti.sitepainter.Library.GetStdLicense() // Dati di licenza */
      licenseObject = com.zucchetti.sitepainter.Library.GetStdLicense();
      /* licenseObject.put('type', 'IAR') // Tipo licenza IAR */
      licenseObject.put("type","IAR");
    } else { // Else
      /* licenseObject := new org.json.JSONObject(cJSONObjectLicenseData) // Dati di licenza */
      licenseObject = new org.json.JSONObject(cJSONObjectLicenseData);
      /* isEmpty Bool // Licenza IAF senza abilitazione a firma IAR */
      boolean isEmpty;
      isEmpty = false;
      /* isEmpty := licenseObject.length() = 0 // Licenza IAF senza abilitazione a firma IAR */
      isEmpty = CPLib.eqr(licenseObject.length(),0);
      /* If isEmpty */
      if (isEmpty) {
        /* licenseObject := com.zucchetti.sitepainter.Library.GetNullIARLicense().toJSONObject() // Licenza vuota */
        licenseObject = com.zucchetti.sitepainter.Library.GetNullIARLicense().toJSONObject();
      } else { // Else
        /* licenseObject.put('digest', com.zucchetti.sitepainter.Library.calculateIARLicenseDigest( licenseObject, licenseObject.getJSONArray( 'properties' ) )) // Dati di licenza */
        licenseObject.put("digest",com.zucchetti.sitepainter.Library.calculateIARLicenseDigest(licenseObject,licenseObject.getJSONArray("properties")));
      } // End If
      /* licenseObject.put('empty', isEmpty) // Tipo licenza IAF */
      licenseObject.put("empty",isEmpty);
      /* licenseObject.put('type', 'IAF') // Tipo licenza IAF */
      licenseObject.put("type","IAF");
    } // End If
    /* l_oLicenseDigest Object(org.json.JSONObject) */
    org.json.JSONObject l_oLicenseDigest;
    l_oLicenseDigest = null;
    /* l_oLicenseDigest := new org.json.JSONObject() */
    l_oLicenseDigest = new org.json.JSONObject();
    /* l_oLicenseDigest.putOpt('signature', licenseObject.getString( 'signature' )) */
    l_oLicenseDigest.putOpt("signature",licenseObject.getString("signature"));
    /* licenseObject.remove('signature') */
    licenseObject.remove("signature");
    /* l_oLicenseDigest.putOpt('digest', licenseObject.getString( 'digest' )) */
    l_oLicenseDigest.putOpt("digest",licenseObject.getString("digest"));
    /* licenseObject.remove('digest') */
    licenseObject.remove("digest");
    /* l_oLicenseDigest.putOpt('infos', licenseObject) */
    l_oLicenseDigest.putOpt("infos",licenseObject);
    /* Return l_oLicenseDigest */
    throw new Stop(l_oLicenseDigest);
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
  public static spas_fgetlicenseR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spas_fgetlicenseR(p_Ctx, p_Caller);
  }
  public static spas_fgetlicenseR Make(CPContext p_Ctx) {
    return new spas_fgetlicenseR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    cJSONObjectLicenseData = "";
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,spas_fgetlicense,
  public static final String i_InvokedRoutines = ",spas_fgetlicense,";
  public static String[] m_cRunParameterNames={};
}
