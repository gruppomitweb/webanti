// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_cinabicabR implements CallerWithObjs {
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
  public String pCodice;
  public double _sd;
  public double _sp;
  public String _code;
  public double _i;
  public double _n;
  public double _r;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_cinabicabR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_cinabicab",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_sd",p_cVarName)) {
      return _sd;
    }
    if (CPLib.eqr("_sp",p_cVarName)) {
      return _sp;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      return _i;
    }
    if (CPLib.eqr("_n",p_cVarName)) {
      return _n;
    }
    if (CPLib.eqr("_r",p_cVarName)) {
      return _r;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_cinabicab";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pCodice",p_cVarName)) {
      return pCodice;
    }
    if (CPLib.eqr("_code",p_cVarName)) {
      return _code;
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
    if (CPLib.eqr("_sd",p_cVarName)) {
      _sd = value;
      return;
    }
    if (CPLib.eqr("_sp",p_cVarName)) {
      _sp = value;
      return;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      _i = value;
      return;
    }
    if (CPLib.eqr("_n",p_cVarName)) {
      _n = value;
      return;
    }
    if (CPLib.eqr("_r",p_cVarName)) {
      _r = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pCodice",p_cVarName)) {
      pCodice = value;
      return;
    }
    if (CPLib.eqr("_code",p_cVarName)) {
      _code = value;
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
    /* Parametri */
    /* pCodice Char(5) // Codice ABI o CAB */
    /* _sd Numeric(3, 0) */
    /* _sp Numeric(3, 0) */
    /* _code Char(5) */
    /* _i Numeric(1, 0) */
    /* _n Numeric(2, 0) */
    /* _r Numeric(2, 0) */
    /* Verifica */
    /* _code := pCodice */
    _code = pCodice;
    /* If Len(LRTrim(_code))<5 */
    if (CPLib.lt(CPLib.Len(CPLib.LRTrim(_code)),5)) {
      /* _code := pCodice */
      _code = pCodice;
    } // End If
    for (int _i = 1; CPLib.ne(_i,6); _i = _i + (1)) {
      /* If Mod(_i - 1,2)=0 */
      if (CPLib.eqr(CPLib.Mod(_i-1,2),0)) {
        /* _n := Val(Substr(_code,_i,1))*2 */
        _n = CPLib.Round(CPLib.Val(CPLib.Substr(_code,_i,1))*2,0);
        /* If _n > 9 */
        if (CPLib.gt(_n,9)) {
          /* _n := Int(_n/10)+Mod(_n,10) */
          _n = CPLib.Round(CPLib.Int(_n/10)+CPLib.Mod(_n,10),0);
        } // End If
        /* _sp := _sp + _n */
        _sp = CPLib.Round(_sp+_n,0);
      } else { // Else
        /* _n := Val(Substr(_code,_i,1)) */
        _n = CPLib.Round(CPLib.Val(CPLib.Substr(_code,_i,1)),0);
        /* _sd := _sd + _n */
        _sd = CPLib.Round(_sd+_n,0);
      } // End If
    }
    /* _r := _sp + _sd */
    _r = CPLib.Round(_sp+_sd,0);
    /* _r := Mod(_r,10) */
    _r = CPLib.Round(CPLib.Mod(_r,10),0);
    /* If _r <> 0 */
    if (CPLib.ne(_r,0)) {
      /* _r := Int(10 - _r) */
      _r = CPLib.Round(CPLib.Int(10-_r),0);
    } // End If
    /* Return LRTrim(Str(_r,1,0)) */
    throw new Stop(CPLib.LRTrim(CPLib.Str(_r,1,0)));
  }
  void _init_() {
  }
  public String RunAsync(String p_pCodice) {
    pCodice = p_pCodice;
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
  public String Run(String p_pCodice) {
    pCodice = p_pCodice;
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
  public static arfn_cinabicabR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_cinabicabR(p_Ctx, p_Caller);
  }
  public static arfn_cinabicabR Make(CPContext p_Ctx) {
    return new arfn_cinabicabR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pCodice = CPLib.Space(5);
    _sd = 0;
    _sp = 0;
    _code = CPLib.Space(5);
    _i = 0;
    _n = 0;
    _r = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_cinabicab,
  public static final String i_InvokedRoutines = ",arfn_cinabicab,";
  public static String[] m_cRunParameterNames={"pCodice"};
}
