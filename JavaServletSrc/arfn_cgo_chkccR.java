// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_cgo_chkccR implements CallerWithObjs {
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
  public String pULT4;
  public java.sql.Date pDatOpe;
  public double pMese;
  public double pAnno;
  public double pTIPO;
  public String pMezzo;
  public boolean bRitorno;
  public String cErrore;
  public String _char;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_cgo_chkccR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_cgo_chkcc",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pMese",p_cVarName)) {
      return pMese;
    }
    if (CPLib.eqr("pAnno",p_cVarName)) {
      return pAnno;
    }
    if (CPLib.eqr("pTIPO",p_cVarName)) {
      return pTIPO;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_cgo_chkcc";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pULT4",p_cVarName)) {
      return pULT4;
    }
    if (CPLib.eqr("pMezzo",p_cVarName)) {
      return pMezzo;
    }
    if (CPLib.eqr("cErrore",p_cVarName)) {
      return cErrore;
    }
    if (CPLib.eqr("_char",p_cVarName)) {
      return _char;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      return pDatOpe;
    }
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
    if (CPLib.eqr("pMese",p_cVarName)) {
      pMese = value;
      return;
    }
    if (CPLib.eqr("pAnno",p_cVarName)) {
      pAnno = value;
      return;
    }
    if (CPLib.eqr("pTIPO",p_cVarName)) {
      pTIPO = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pULT4",p_cVarName)) {
      pULT4 = value;
      return;
    }
    if (CPLib.eqr("pMezzo",p_cVarName)) {
      pMezzo = value;
      return;
    }
    if (CPLib.eqr("cErrore",p_cVarName)) {
      cErrore = value;
      return;
    }
    if (CPLib.eqr("_char",p_cVarName)) {
      _char = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      pDatOpe = value;
      return;
    }
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
    /* pULT4 Char(4) // Ultime 4 cifre Carta di credito */
    /* pDatOpe Date // Data Operazione */
    /* pMese Numeric(2, 0) // Mese Scadenza */
    /* pAnno Numeric(4, 0) // Anno Scadenza */
    /* pTIPO Numeric(1, 0) // Tipo controllo (1-ULT4 - 2-SCAD) */
    /* pMezzo Char(1) // Mezzo di Pagamento */
    /* bRitorno Bool */
    /* cErrore Char(80) */
    /* _char Char(1) */
    /* bRitorno := True */
    bRitorno = true;
    /* If pMezzo='V' */
    if (CPLib.eqr(pMezzo,"V")) {
      /* Case pTIPO=1 */
      if (CPLib.eqr(pTIPO,1)) {
        /* If Len(LRTrim(pULT4)) < 4 */
        if (CPLib.lt(CPLib.Len(CPLib.LRTrim(pULT4)),4)) {
          /* bRitorno := False */
          bRitorno = false;
          /* cErrore := 'Deve contenere 4 cifre' */
          cErrore = "Deve contenere 4 cifre";
        } else { // Else
          for (int i = 1; CPLib.ne(i,5); i = i + (1)) {
            /* _char := Substr(pULT4,i,1) */
            _char = CPLib.Substr(pULT4,i,1);
            /* If not(Asc(_char) >= 48 and Asc(_char) <= 57) */
            if ( ! (CPLib.ge(CPLib.Asc(_char),48) && CPLib.le(CPLib.Asc(_char),57))) {
              /* bRitorno := False */
              bRitorno = false;
              /* cErrore := 'Deve contenere solo numeri' */
              cErrore = "Deve contenere solo numeri";
            } // End If
          }
        } // End If
        /* Case pTIPO=2 */
      } else if (CPLib.eqr(pTIPO,2)) {
        /* Case Year(pDatOpe) > pAnno  */
        if (CPLib.gt(CPLib.Year(pDatOpe),pAnno)) {
          /* bRitorno := False */
          bRitorno = false;
          /* cErrore := "La data di scadenza della carta è inferiore alla data dell'operazione" */
          cErrore = "La data di scadenza della carta è inferiore alla data dell'operazione";
          /* Case Year(pDatOpe) = pAnno and Month(pDatOpe) > pMese */
        } else if (CPLib.eqr(CPLib.Year(pDatOpe),pAnno) && CPLib.gt(CPLib.Month(pDatOpe),pMese)) {
          /* bRitorno := False */
          bRitorno = false;
          /* cErrore := "La data di scadenza della carta è inferiore alla data dell'operazione" */
          cErrore = "La data di scadenza della carta è inferiore alla data dell'operazione";
        } // End Case
      } // End Case
      /* Error Msg cErrore */
      m_cLastMsgError = cErrore;
      new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
    } // End If
    /* Return bRitorno */
    throw new Stop(bRitorno);
  }
  void _init_() {
  }
  public String RunAsync(String p_pULT4,java.sql.Date p_pDatOpe,double p_pMese,double p_pAnno,double p_pTIPO,String p_pMezzo) {
    pULT4 = p_pULT4;
    pDatOpe = p_pDatOpe;
    pMese = p_pMese;
    pAnno = p_pAnno;
    pTIPO = p_pTIPO;
    pMezzo = p_pMezzo;
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
  public boolean Run(String p_pULT4,java.sql.Date p_pDatOpe,double p_pMese,double p_pAnno,double p_pTIPO,String p_pMezzo) {
    pULT4 = p_pULT4;
    pDatOpe = p_pDatOpe;
    pMese = p_pMese;
    pAnno = p_pAnno;
    pTIPO = p_pTIPO;
    pMezzo = p_pMezzo;
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
  public static arfn_cgo_chkccR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_cgo_chkccR(p_Ctx, p_Caller);
  }
  public static arfn_cgo_chkccR Make(CPContext p_Ctx) {
    return new arfn_cgo_chkccR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pULT4 = CPLib.Space(4);
    pDatOpe = CPLib.NullDate();
    pMese = 0;
    pAnno = 0;
    pTIPO = 0;
    pMezzo = CPLib.Space(1);
    bRitorno = false;
    cErrore = CPLib.Space(80);
    _char = CPLib.Space(1);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_cgo_chkcc,
  public static final String i_InvokedRoutines = ",arfn_cgo_chkcc,";
  public static String[] m_cRunParameterNames={"pULT4","pDatOpe","pMese","pAnno","pTIPO","pMezzo"};
}
