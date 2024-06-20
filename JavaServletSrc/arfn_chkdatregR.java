// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_chkdatregR implements CallerWithObjs {
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
  public java.sql.Date pDatOpe;
  public java.sql.Date pDatReg;
  public String pTipCon;
  public String pStato;
  public boolean bReturn;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_chkdatregR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_chkdatreg",m_Caller);
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
      return "arfn_chkdatreg";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pTipCon",p_cVarName)) {
      return pTipCon;
    }
    if (CPLib.eqr("pStato",p_cVarName)) {
      return pStato;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      return pDatOpe;
    }
    if (CPLib.eqr("pDatReg",p_cVarName)) {
      return pDatReg;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("bReturn",p_cVarName)) {
      return bReturn;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipCon",p_cVarName)) {
      pTipCon = value;
      return;
    }
    if (CPLib.eqr("pStato",p_cVarName)) {
      pStato = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      pDatOpe = value;
      return;
    }
    if (CPLib.eqr("pDatReg",p_cVarName)) {
      pDatReg = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bReturn",p_cVarName)) {
      bReturn = value;
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
    /* Parametri */
    /* pDatOpe Date */
    /* pDatReg Date */
    /* pTipCon Char(1) */
    /* pStato Char(4) */
    /* Varibile di ritorno */
    /* bReturn Bool */
    /* Verifica in base al tipo */
    /* bReturn := True */
    bReturn = true;
    /* If pTipCon <> 'N' and pTipCon <> 'S' */
    if (CPLib.ne(pTipCon,"N") && CPLib.ne(pTipCon,"S")) {
      /* If bReturn */
      if (bReturn) {
        /* If LRTrim(pStato) <> 'E' */
        if (CPLib.ne(CPLib.LRTrim(pStato),"E")) {
          /* Case pTipCon = 'U' */
          if (CPLib.eqr(pTipCon,"U")) {
            /* If pDatReg <> Date() */
            if (CPLib.ne(pDatReg,CPLib.Date())) {
              /* Error Msg 'Data Registrazione Diversa dalla Data di Sistema' */
              m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"Data Registrazione Diversa dalla Data di Sistema");
              new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
              /* bReturn := False */
              bReturn = false;
            } // End If
            /* Case pTipCon = 'I' */
          } else if (CPLib.eqr(pTipCon,"I")) {
            /* If pDatReg < Date() */
            if (CPLib.lt(pDatReg,CPLib.Date())) {
              /* Error Msg "Data Registrazione inferiore alla Data di Sistema" */
              m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"Data Registrazione inferiore alla Data di Sistema");
              new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
              /* bReturn := False */
              bReturn = false;
            } // End If
          } // End Case
        } // End If
      } // End If
    } // End If
    /* Return bReturn */
    throw new Stop(bReturn);
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_pDatOpe,java.sql.Date p_pDatReg,String p_pTipCon,String p_pStato) {
    pDatOpe = p_pDatOpe;
    pDatReg = p_pDatReg;
    pTipCon = p_pTipCon;
    pStato = p_pStato;
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
  public boolean Run(java.sql.Date p_pDatOpe,java.sql.Date p_pDatReg,String p_pTipCon,String p_pStato) {
    pDatOpe = p_pDatOpe;
    pDatReg = p_pDatReg;
    pTipCon = p_pTipCon;
    pStato = p_pStato;
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
  public static arfn_chkdatregR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_chkdatregR(p_Ctx, p_Caller);
  }
  public static arfn_chkdatregR Make(CPContext p_Ctx) {
    return new arfn_chkdatregR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pDatOpe = CPLib.NullDate();
    pDatReg = CPLib.NullDate();
    pTipCon = CPLib.Space(1);
    pStato = CPLib.Space(4);
    bReturn = false;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chkdatreg,
  public static final String i_InvokedRoutines = ",arfn_chkdatreg,";
  public static String[] m_cRunParameterNames={"pDatOpe","pDatReg","pTipCon","pStato"};
}
