// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_calcflaglireR implements CallerWithObjs {
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
  public java.sql.Date pDatOpe;
  public String pTipDiv;
  public java.sql.Date pDatEuro;
  public String cRitorno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_calcflaglireR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_calcflaglire",m_Caller);
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
      return "arfn_calcflaglire";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pTipDiv",p_cVarName)) {
      return pTipDiv;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      return pDatOpe;
    }
    if (CPLib.eqr("pDatEuro",p_cVarName)) {
      return pDatEuro;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipDiv",p_cVarName)) {
      pTipDiv = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      pDatOpe = value;
      return;
    }
    if (CPLib.eqr("pDatEuro",p_cVarName)) {
      pDatEuro = value;
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
    /* Parametri */
    /* pDatOpe Date */
    /* pTipDiv Char(1) */
    /* pDatEuro Date */
    /* cRitorno Char(1) */
    /* Controllo le date e la divisa */
    /* Case pTipDiv = 'L' */
    if (CPLib.eqr(pTipDiv,"L")) {
      /* If pDatOpe < CharToDate("20020101") */
      if (CPLib.lt(pDatOpe,CPLib.CharToDate("20020101"))) {
        /* If pDatEuro <= pDatOpe */
        if (CPLib.le(pDatEuro,pDatOpe)) {
          /* cRitorno := '7' */
          cRitorno = "7";
        } else { // Else
          /* cRitorno := '1' */
          cRitorno = "1";
        } // End If
      } else { // Else
        /* cRitorno := '7' */
        cRitorno = "7";
      } // End If
      /* Case pTipDiv = 'E' */
    } else if (CPLib.eqr(pTipDiv,"E")) {
      /* If pDatOpe < CharToDate("20020101") */
      if (CPLib.lt(pDatOpe,CPLib.CharToDate("20020101"))) {
        /* If pDatEuro <= pDatOpe */
        if (CPLib.le(pDatEuro,pDatOpe)) {
          /* cRitorno := '3' */
          cRitorno = "3";
        } else { // Else
          /* cRitorno := '5' */
          cRitorno = "5";
        } // End If
      } else { // Else
        /* cRitorno := '3' */
        cRitorno = "3";
      } // End If
      /* Case pTipDiv = 'V' */
    } else if (CPLib.eqr(pTipDiv,"V")) {
      /* Case pDatOpe < CharToDate("19990101") */
      if (CPLib.lt(pDatOpe,CPLib.CharToDate("19990101"))) {
        /* cRitorno := '2' */
        cRitorno = "2";
        /* Case pDatOpe >= CharToDate("19990101") and pDatOpe < CharToDate("20020101") */
      } else if (CPLib.ge(pDatOpe,CPLib.CharToDate("19990101")) && CPLib.lt(pDatOpe,CPLib.CharToDate("20020101"))) {
        /* If pDatOpe <= pDatEuro */
        if (CPLib.le(pDatOpe,pDatEuro)) {
          /* cRitorno := '4' */
          cRitorno = "4";
        } else { // Else
          /* cRitorno := '6' */
          cRitorno = "6";
        } // End If
      } else { // Otherwise
        /* cRitorno := '4' */
        cRitorno = "4";
      } // End Case
    } // End Case
    /* Return cRitorno */
    throw new Stop(cRitorno);
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_pDatOpe,String p_pTipDiv,java.sql.Date p_pDatEuro) {
    pDatOpe = p_pDatOpe;
    pTipDiv = p_pTipDiv;
    pDatEuro = p_pDatEuro;
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
  public String Run(java.sql.Date p_pDatOpe,String p_pTipDiv,java.sql.Date p_pDatEuro) {
    pDatOpe = p_pDatOpe;
    pTipDiv = p_pTipDiv;
    pDatEuro = p_pDatEuro;
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
  public static arfn_calcflaglireR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_calcflaglireR(p_Ctx, p_Caller);
  }
  public static arfn_calcflaglireR Make(CPContext p_Ctx) {
    return new arfn_calcflaglireR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pDatOpe = CPLib.NullDate();
    pTipDiv = CPLib.Space(1);
    pDatEuro = CPLib.NullDate();
    cRitorno = CPLib.Space(1);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_calcflaglire,
  public static final String i_InvokedRoutines = ",arfn_calcflaglire,";
  public static String[] m_cRunParameterNames={"pDatOpe","pTipDiv","pDatEuro"};
}
