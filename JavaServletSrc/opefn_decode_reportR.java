// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class opefn_decode_reportR implements CallerWithObjs {
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
  public String pTipo;
  public String pValore;
  public String _ritorno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public opefn_decode_reportR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("opefn_decode_report",m_Caller);
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
      return "opefn_decode_report";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pValore",p_cVarName)) {
      return pValore;
    }
    if (CPLib.eqr("_ritorno",p_cVarName)) {
      return _ritorno;
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
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pValore",p_cVarName)) {
      pValore = value;
      return;
    }
    if (CPLib.eqr("_ritorno",p_cVarName)) {
      _ritorno = value;
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
    /* pTipo Char(1) // Tipo Decodifica */
    /* pValore Char(20) // Valoreda decodificare */
    /* _ritorno Char(80) */
    /* Case pTipo='T' */
    if (CPLib.eqr(pTipo,"T")) {
      /* Case LRTrim(pValore)='a' */
      if (CPLib.eqr(CPLib.LRTrim(pValore),"a")) {
        /* _ritorno := "Dipendenze bancarie e postali" */
        _ritorno = "Dipendenze bancarie e postali";
        /* Case LRTrim(pValore)='b' */
      } else if (CPLib.eqr(CPLib.LRTrim(pValore),"b")) {
        /* _ritorno := "Sale conta del medesimo operatore o di altri operatori" */
        _ritorno = "Sale conta del medesimo operatore o di altri operatori";
        /* Case LRTrim(pValore)='c' */
      } else if (CPLib.eqr(CPLib.LRTrim(pValore),"c")) {
        /* _ritorno := "Punti serviti della �grande distribuzione organizzata� (GDO)" */
        _ritorno = "Punti serviti della \u201cgrande distribuzione organizzata\u201d (GDO)";
        /* Case LRTrim(pValore)='d' */
      } else if (CPLib.eqr(CPLib.LRTrim(pValore),"d")) {
        /* _ritorno := "Punti serviti di clienti non rientranti fra quelli individuati al punto precedente (altri)" */
        _ritorno = "Punti serviti di clienti non rientranti fra quelli individuati al punto precedente (altri)";
      } // End Case
      /* Case pTipo='R' */
    } else if (CPLib.eqr(pTipo,"R")) {
      /* Case LRTrim(pValore)='0' */
      if (CPLib.eqr(CPLib.LRTrim(pValore),"0")) {
        /* _ritorno := "Cliente Diretto" */
        _ritorno = "Cliente Diretto";
        /* Case LRTrim(pValore)='1' */
      } else if (CPLib.eqr(CPLib.LRTrim(pValore),"1")) {
        /* _ritorno := "Cliente acquisito tramite un network CIT" */
        _ritorno = "Cliente acquisito tramite un network CIT";
        /* Case LRTrim(pValore)='2' */
      } else if (CPLib.eqr(CPLib.LRTrim(pValore),"2")) {
        /* _ritorno := "Cliente acquisito tramite un network non CIT" */
        _ritorno = "Cliente acquisito tramite un network non CIT";
        /* Case LRTrim(pValore)='3' */
      } else if (CPLib.eqr(CPLib.LRTrim(pValore),"3")) {
        /* _ritorno := "Soggetto Servito" */
        _ritorno = "Soggetto Servito";
      } // End Case
    } // End Case
    /* Return _ritorno */
    throw new Stop(_ritorno);
  }
  void _init_() {
  }
  public String RunAsync(String p_pTipo,String p_pValore) {
    pTipo = p_pTipo;
    pValore = p_pValore;
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
  public String Run(String p_pTipo,String p_pValore) {
    pTipo = p_pTipo;
    pValore = p_pValore;
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
  public static opefn_decode_reportR Make(CPContext p_Ctx, Caller p_Caller) {
    return new opefn_decode_reportR(p_Ctx, p_Caller);
  }
  public static opefn_decode_reportR Make(CPContext p_Ctx) {
    return new opefn_decode_reportR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    pValore = CPLib.Space(20);
    _ritorno = CPLib.Space(80);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,opefn_decode_report,
  public static final String i_InvokedRoutines = ",opefn_decode_report,";
  public static String[] m_cRunParameterNames={"pTipo","pValore"};
}
