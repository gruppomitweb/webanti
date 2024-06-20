// * --- Area Manuale = BO - Header
// * --- fn_estraejson
import org.json.*;

// * --- Fine Area Manuale
public class fn_estraejsonR implements CallerWithObjs {
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
  public JSONObject jsonSorgente;
  public MemoryCursor_mccampijson_mcrdef mcObjects;
  public String oldValue;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public fn_estraejsonR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("fn_estraejson",m_Caller);
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
      return "fn_estraejson";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("oldValue",p_cVarName)) {
      return oldValue;
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
    if (CPLib.eqr("mcObjects",p_cVarName)) {
      return mcObjects;
    }
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
    if (CPLib.eqr("oldValue",p_cVarName)) {
      oldValue = value;
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
    if (CPLib.eqr("mcObjects",p_cVarName)) {
      mcObjects = (MemoryCursor_mccampijson_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    /* jsonSorgente Object(JSONObject) */
    /* mcObjects MemoryCursor(mcCampiJSon.MCRDef) */
    /* oldValue Char(0) := "" */
    /* oJSon Object(JSONObject) */
    JSONObject oJSon;
    oJSon = null;
    /* _ritorno Char(0) := '' */
    String _ritorno;
    _ritorno = "";
    /* mcObjects.GoTop() */
    mcObjects.GoTop();
    /* If mcObjects.RecCount() = 1 */
    if (CPLib.eqr(mcObjects.RecCount(),1)) {
      /* _ritorno := iif(jsonSorgente.has(mcObjects.nomecampo),jsonSorgente.get(mcObjects.nomecampo).toString(),"") */
      _ritorno = (jsonSorgente.has(mcObjects.row.nomecampo)?jsonSorgente.get(mcObjects.row.nomecampo).toString():"");
    } else { // Else
      /* If jsonSorgente.has(mcObjects.nomecampo) */
      if (jsonSorgente.has(mcObjects.row.nomecampo)) {
        /* oJSon := jsonSorgente.getJSONObject(mcObjects.nomecampo) */
        oJSon = jsonSorgente.getJSONObject(mcObjects.row.nomecampo);
        /* mcObjects.Delete() */
        mcObjects.Delete();
        /* _ritorno := fn_estraejson(oJSon,mcObjects,oldValue) */
        _ritorno = fn_estraejsonR.Make(m_Ctx,this).Run(oJSon,mcObjects,oldValue);
      } else { // Else
        /* _ritorno := '' */
        _ritorno = "";
      } // End If
    } // End If
    /* Return iif(Empty(_ritorno),oldValue,_ritorno) */
    throw new Stop((CPLib.Empty(_ritorno)?oldValue:_ritorno));
  }
  void _init_() {
  }
  public String RunAsync(JSONObject p_jsonSorgente,MemoryCursor_mccampijson_mcrdef p_mcObjects) {
    return RunAsync(p_jsonSorgente,p_mcObjects,"");
  }
  public String RunAsync(JSONObject p_jsonSorgente,MemoryCursor_mccampijson_mcrdef p_mcObjects,String p_oldValue) {
    jsonSorgente = p_jsonSorgente;
    mcObjects = p_mcObjects;
    oldValue = p_oldValue;
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
  public String Run(JSONObject p_jsonSorgente,MemoryCursor_mccampijson_mcrdef p_mcObjects) {
    return Run(p_jsonSorgente,p_mcObjects,"");
  }
  public String Run(JSONObject p_jsonSorgente,MemoryCursor_mccampijson_mcrdef p_mcObjects,String p_oldValue) {
    jsonSorgente = p_jsonSorgente;
    mcObjects = p_mcObjects;
    oldValue = p_oldValue;
    return Run();
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
  public static fn_estraejsonR Make(CPContext p_Ctx, Caller p_Caller) {
    return new fn_estraejsonR(p_Ctx, p_Caller);
  }
  public static fn_estraejsonR Make(CPContext p_Ctx) {
    return new fn_estraejsonR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    jsonSorgente = null;
    mcObjects = new MemoryCursor_mccampijson_mcrdef();
    oldValue = CPLib.Space(0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,fn_estraejson,
  public static final String i_InvokedRoutines = ",fn_estraejson,";
  public static String[] m_cRunParameterNames={"jsonSorgente","mcObjects","oldValue"};
}
