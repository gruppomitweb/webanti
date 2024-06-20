// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_cgo_chkidbR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String pIDB;
  public boolean bRitorno;
  public double _err;
  public String _char;
  public double _achar;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_cgo_chkidbR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arfn_cgo_chkidb",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_err",p_cVarName)) {
      return _err;
    }
    if (CPLib.eqr("_achar",p_cVarName)) {
      return _achar;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_cgo_chkidb";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pIDB",p_cVarName)) {
      return pIDB;
    }
    if (CPLib.eqr("_char",p_cVarName)) {
      return _char;
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
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      return bRitorno;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_err",p_cVarName)) {
      _err = value;
      return;
    }
    if (CPLib.eqr("_achar",p_cVarName)) {
      _achar = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pIDB",p_cVarName)) {
      pIDB = value;
      return;
    }
    if (CPLib.eqr("_char",p_cVarName)) {
      _char = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      bRitorno = value;
      return;
    }
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
    /* pIDB Char(30) */
    /* bRitorno Bool */
    /* _err Numeric(1, 0) */
    /* _char Char(1) */
    /* _achar Numeric(3, 0) */
    /* bRitorno := True */
    bRitorno = true;
    /* _err := 0 */
    _err = CPLib.Round(0,0);
    /* If not(Empty(pIDB)) */
    if ( ! (CPLib.Empty(pIDB))) {
      /* If Len(LRTrim(pIDB)) <> 12 and Len(LRTrim(pIDB)) <> 14 and Len(LRTrim(pIDB)) <> 20 and Len(LRTrim(pIDB)) <> 28 */
      if (CPLib.ne(CPLib.Len(CPLib.LRTrim(pIDB)),12) && CPLib.ne(CPLib.Len(CPLib.LRTrim(pIDB)),14) && CPLib.ne(CPLib.Len(CPLib.LRTrim(pIDB)),20) && CPLib.ne(CPLib.Len(CPLib.LRTrim(pIDB)),28)) {
        /* Error Msg 'La lunghezza del biglietto deve essere di 12, 14, 20 o 28 caratteri' */
        m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"La lunghezza del biglietto deve essere di 12, 14, 20 o 28 caratteri");
        new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
        /* _err := 1 */
        _err = CPLib.Round(1,0);
        /* bRitorno := False */
        bRitorno = false;
      } // End If
      /* If _err = 0 */
      if (CPLib.eqr(_err,0)) {
        for (int i = 1; CPLib.ne(i,CPLib.Len(CPLib.LRTrim(pIDB))); i = i + (1)) {
          /* _char := Upper(Substr(LRTrim(pIDB),i,1)) */
          _char = CPLib.Upper(CPLib.Substr(CPLib.LRTrim(pIDB),i,1));
          /* _achar := Asc(_char) */
          _achar = CPLib.Round(CPLib.Asc(_char),0);
          /* If not(_achar >= 48 and _achar <= 57) and not(_achar >= 65 and _achar <= 90) */
          if ( ! (CPLib.ge(_achar,48) && CPLib.le(_achar,57)) &&  ! (CPLib.ge(_achar,65) && CPLib.le(_achar,90))) {
            /* Error Msg 'Si possono utilizzare solo i caratteri da  0 a 9 e da  A a Z' */
            m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"Si possono utilizzare solo i caratteri da  0 a 9 e da  A a Z");
            new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
            /* _err := 1 */
            _err = CPLib.Round(1,0);
            /* bRitorno := False */
            bRitorno = false;
          } // End If
        }
      } // End If
    } // End If
    /* Return bRitorno */
    throw new Stop(bRitorno);
  }
  void _init_() {
  }
  public String RunAsync(String p_pIDB) {
    pIDB = p_pIDB;
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
    );
  }
  public boolean Run(String p_pIDB) {
    pIDB = p_pIDB;
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
  public static arfn_cgo_chkidbR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_cgo_chkidbR(p_Ctx, p_Caller);
  }
  public static arfn_cgo_chkidbR Make(CPContext p_Ctx) {
    return new arfn_cgo_chkidbR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pIDB = CPLib.Space(30);
    bRitorno = false;
    _err = 0;
    _char = CPLib.Space(1);
    _achar = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_cgo_chkidb,
  public static final String i_InvokedRoutines = ",arfn_cgo_chkidb,";
  public static String[] m_cRunParameterNames={"pIDB"};
}
