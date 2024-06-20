// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_inimeseR implements CallerWithObjs {
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
  public java.sql.Date pData;
  public double pPeriodo;
  public double _aaaa;
  public double _mm;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_inimeseR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_inimese",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pPeriodo",p_cVarName)) {
      return pPeriodo;
    }
    if (CPLib.eqr("_aaaa",p_cVarName)) {
      return _aaaa;
    }
    if (CPLib.eqr("_mm",p_cVarName)) {
      return _mm;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_inimese";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pData",p_cVarName)) {
      return pData;
    }
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
    if (CPLib.eqr("pPeriodo",p_cVarName)) {
      pPeriodo = value;
      return;
    }
    if (CPLib.eqr("_aaaa",p_cVarName)) {
      _aaaa = value;
      return;
    }
    if (CPLib.eqr("_mm",p_cVarName)) {
      _mm = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pData",p_cVarName)) {
      pData = value;
      return;
    }
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
    /* pData Date */
    /* pPeriodo Numeric(1, 0) */
    /* _aaaa Numeric(4, 0) */
    /* _mm Numeric(2, 0) */
    /* _aaaa := Year(pData) */
    _aaaa = CPLib.Round(CPLib.Year(pData),0);
    /* _mm := Month(pData) + pPeriodo */
    _mm = CPLib.Round(CPLib.Month(pData)+pPeriodo,0);
    /* If Mod(_mm,12)=0 */
    if (CPLib.eqr(CPLib.Mod(_mm,12),0)) {
      /* _aaaa := _aaaa + Int(_mm/12) - 1 */
      _aaaa = CPLib.Round(_aaaa+CPLib.Int(_mm/12)-1,0);
      /* _mm := 12 */
      _mm = CPLib.Round(12,0);
    } else { // Else
      /* _aaaa := _aaaa + Int(_mm/12) */
      _aaaa = CPLib.Round(_aaaa+CPLib.Int(_mm/12),0);
      /* _mm := Mod(_mm,12) */
      _mm = CPLib.Round(CPLib.Mod(_mm,12),0);
    } // End If
    /* Return Right("0000"+Str(_aaaa,4,0),4)+Right("00"+LRTrim(Str(_mm,2,0)),2) */
    throw new Stop(CPLib.Right("0000"+CPLib.Str(_aaaa,4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(_mm,2,0)),2));
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_pData,double p_pPeriodo) {
    pData = p_pData;
    pPeriodo = p_pPeriodo;
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
  public String Run(java.sql.Date p_pData,double p_pPeriodo) {
    pData = p_pData;
    pPeriodo = p_pPeriodo;
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
  public static arfn_inimeseR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_inimeseR(p_Ctx, p_Caller);
  }
  public static arfn_inimeseR Make(CPContext p_Ctx) {
    return new arfn_inimeseR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pData = CPLib.NullDate();
    pPeriodo = 0;
    _aaaa = 0;
    _mm = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_inimese,
  public static final String i_InvokedRoutines = ",arfn_inimese,";
  public static String[] m_cRunParameterNames={"pData","pPeriodo"};
}
