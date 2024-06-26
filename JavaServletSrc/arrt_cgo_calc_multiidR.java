// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_calc_multiidR implements CallerWithObjs {
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
  public armt_cgo_oper_multiBO pObj;
  public double _oldrow;
  public double _numrig;
  public double conta;
  public double conta2;
  public double _righe;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_calc_multiidR (CPContext p_ContextObject, Caller caller) {
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
                                all'oggetto globale (unico per pi� istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda � contenuta nel global object.
                             */
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_cgo_calc_multiid",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_oldrow",p_cVarName)) {
      return _oldrow;
    }
    if (CPLib.eqr("_numrig",p_cVarName)) {
      return _numrig;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("conta2",p_cVarName)) {
      return conta2;
    }
    if (CPLib.eqr("_righe",p_cVarName)) {
      return _righe;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cgo_calc_multiid";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
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
    if (CPLib.eqr("_oldrow",p_cVarName)) {
      _oldrow = value;
      return;
    }
    if (CPLib.eqr("_numrig",p_cVarName)) {
      _numrig = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("conta2",p_cVarName)) {
      conta2 = value;
      return;
    }
    if (CPLib.eqr("_righe",p_cVarName)) {
      _righe = value;
      return;
    }
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
    /* pObj Object(armt_cgo_oper_multiBO) */
    /* _oldrow Numeric(3, 0) */
    /* _numrig Numeric(3, 0) */
    /* conta Numeric(3, 0) */
    /* conta2 Numeric(3, 0) */
    /* _righe Numeric(3, 0) */
    /* pObj.CtxLoad_ardt_cgo_oper_multi() */
    pObj.CtxLoad_ardt_cgo_oper_multi();
    /* _numrig := pObj.ardt_cgo_oper_multi.Rows() */
    _numrig = CPLib.Round(pObj.ardt_cgo_oper_multi.Rows(),0);
    /* conta := 0 */
    conta = CPLib.Round(0,0);
    /* conta2 := 1 */
    conta2 = CPLib.Round(1,0);
    /* _righe := 0 */
    _righe = CPLib.Round(0,0);
    /* pObj.w_MIDBIGLIETTO := '' */
    pObj.w_MIDBIGLIETTO = "";
    /* pObj.w_MIDBIGLIETTO1 := '' */
    pObj.w_MIDBIGLIETTO1 = "";
    /* pObj.w_MIDBIGLIETTO2 := '' */
    pObj.w_MIDBIGLIETTO2 = "";
    /* pObj.w_MIDBIGLIETTO3 := '' */
    pObj.w_MIDBIGLIETTO3 = "";
    /* pObj.w_MIDBIGLIETTO4 := '' */
    pObj.w_MIDBIGLIETTO4 = "";
    /* While _righe < _numrig */
    while (CPLib.lt(_righe,_numrig)) {
      /* pObj.ardt_cgo_oper_multi.SetRow(_righe) */
      pObj.ardt_cgo_oper_multi.SetRow(_righe);
      /* Case conta2 = 1 */
      if (CPLib.eqr(conta2,1)) {
        /* pObj.w_MIDBIGLIETTO1 := pObj.w_MIDBIGLIETTO1 + iif(not(Empty(LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO))),LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO)+" - ",'') */
        pObj.w_MIDBIGLIETTO1 = pObj.w_MIDBIGLIETTO1+( ! (CPLib.Empty(CPLib.LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO)))?CPLib.LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO)+" - ":"");
        /* Case conta2 = 2 */
      } else if (CPLib.eqr(conta2,2)) {
        /* pObj.w_MIDBIGLIETTO2 := pObj.w_MIDBIGLIETTO2 + iif(not(Empty(LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO))),LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO)+" - ",'') */
        pObj.w_MIDBIGLIETTO2 = pObj.w_MIDBIGLIETTO2+( ! (CPLib.Empty(CPLib.LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO)))?CPLib.LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO)+" - ":"");
        /* Case conta2 = 3 */
      } else if (CPLib.eqr(conta2,3)) {
        /* pObj.w_MIDBIGLIETTO3 := pObj.w_MIDBIGLIETTO3 + iif(not(Empty(LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO))),LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO)+" - ",'') */
        pObj.w_MIDBIGLIETTO3 = pObj.w_MIDBIGLIETTO3+( ! (CPLib.Empty(CPLib.LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO)))?CPLib.LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO)+" - ":"");
        /* Case conta2 = 4 */
      } else if (CPLib.eqr(conta2,4)) {
        /* pObj.w_MIDBIGLIETTO4 := pObj.w_MIDBIGLIETTO4 + iif(not(Empty(LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO))),LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO)+" - ",'') */
        pObj.w_MIDBIGLIETTO4 = pObj.w_MIDBIGLIETTO4+( ! (CPLib.Empty(CPLib.LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO)))?CPLib.LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO)+" - ":"");
      } // End Case
      /* pObj.w_MIDBIGLIETTO := pObj.w_MIDBIGLIETTO + iif(not(Empty(LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO))),LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO)+" - ",'') */
      pObj.w_MIDBIGLIETTO = pObj.w_MIDBIGLIETTO+( ! (CPLib.Empty(CPLib.LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO)))?CPLib.LRTrim(pObj.ardt_cgo_oper_multi.w_CAIDBIGLIETTO)+" - ":"");
      /* conta := conta + 1 */
      conta = CPLib.Round(conta+1,0);
      /* If conta = 6 */
      if (CPLib.eqr(conta,6)) {
        /* pObj.w_MIDBIGLIETTO := Left(pObj.w_MIDBIGLIETTO,Len(LRTrim(pObj.w_MIDBIGLIETTO)) - 2) + NL */
        pObj.w_MIDBIGLIETTO = CPLib.Left(pObj.w_MIDBIGLIETTO,CPLib.Len(CPLib.LRTrim(pObj.w_MIDBIGLIETTO))-2)+"\n";
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* conta2 := conta2 + 1 */
        conta2 = CPLib.Round(conta2+1,0);
      } // End If
      /* _righe := _righe + 1 */
      _righe = CPLib.Round(_righe+1,0);
    } // End While
    /* If conta < 6 */
    if (CPLib.lt(conta,6)) {
      /* pObj.w_MIDBIGLIETTO := Left(pObj.w_MIDBIGLIETTO,Len(LRTrim(pObj.w_MIDBIGLIETTO)) - 2) */
      pObj.w_MIDBIGLIETTO = CPLib.Left(pObj.w_MIDBIGLIETTO,CPLib.Len(CPLib.LRTrim(pObj.w_MIDBIGLIETTO))-2);
    } // End If
    /* pObj.w_MIDBIGLIETTO1 := Left(pObj.w_MIDBIGLIETTO1,Len(LRTrim(pObj.w_MIDBIGLIETTO1)) - 2) */
    pObj.w_MIDBIGLIETTO1 = CPLib.Left(pObj.w_MIDBIGLIETTO1,CPLib.Len(CPLib.LRTrim(pObj.w_MIDBIGLIETTO1))-2);
    /* pObj.w_MIDBIGLIETTO2 := Left(pObj.w_MIDBIGLIETTO2,Len(LRTrim(pObj.w_MIDBIGLIETTO2)) - 2) */
    pObj.w_MIDBIGLIETTO2 = CPLib.Left(pObj.w_MIDBIGLIETTO2,CPLib.Len(CPLib.LRTrim(pObj.w_MIDBIGLIETTO2))-2);
    /* pObj.w_MIDBIGLIETTO3 := Left(pObj.w_MIDBIGLIETTO3,Len(LRTrim(pObj.w_MIDBIGLIETTO3)) - 2) */
    pObj.w_MIDBIGLIETTO3 = CPLib.Left(pObj.w_MIDBIGLIETTO3,CPLib.Len(CPLib.LRTrim(pObj.w_MIDBIGLIETTO3))-2);
    /* pObj.w_MIDBIGLIETTO4 := Left(pObj.w_MIDBIGLIETTO4,Len(LRTrim(pObj.w_MIDBIGLIETTO4)) - 2) */
    pObj.w_MIDBIGLIETTO4 = CPLib.Left(pObj.w_MIDBIGLIETTO4,CPLib.Len(CPLib.LRTrim(pObj.w_MIDBIGLIETTO4))-2);
  }
  void _init_() {
  }
  public String RunAsync(armt_cgo_oper_multiBO p_pObj) {
    pObj = p_pObj;
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
  public Forward Run(armt_cgo_oper_multiBO p_pObj) {
    pObj = p_pObj;
    return Run();
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
  public static arrt_cgo_calc_multiidR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_calc_multiidR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pObj = null;
    _oldrow = 0;
    _numrig = 0;
    conta = 0;
    conta2 = 0;
    _righe = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pObj"};
}
