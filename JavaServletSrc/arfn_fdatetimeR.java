// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_fdatetimeR implements CallerWithObjs {
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
  public java.sql.Timestamp pDate;
  public String pTipo;
  public String cDate;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_fdatetimeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_fdatetime",m_Caller);
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
      return "arfn_fdatetime";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("cDate",p_cVarName)) {
      return cDate;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDate",p_cVarName)) {
      return pDate;
    }
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
    if (CPLib.eqr("cDate",p_cVarName)) {
      cDate = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
    if (CPLib.eqr("pDate",p_cVarName)) {
      pDate = value;
      return;
    }
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
    /* Data da convertire */
    /* pDate DateTime */
    /* pTipo Char(1) := '1' */
    /* Variabili locali */
    /* cDate Char(19) // data Convertita */
    /* Inverte la data  */
    /* If Empty(pDate) or DateTimeToChar(pDate)='01000101000000' */
    if (CPLib.Empty(pDate) || CPLib.eqr(CPLib.DateTimeToChar(pDate),"01000101000000")) {
      /* cDate := Space(14) // data Convertita */
      cDate = CPLib.Space(14);
    } else { // Else
      /* Case pTipo='1' */
      if (CPLib.eqr(pTipo,"1")) {
        /* cDate := Substr(DateTimeToChar(pDate),7,2)+'-'+Substr(DateTimeToChar(pDate),5,2)+'-'+Left(DateTimeToChar(pDate),4) + " " +Substr(DateTimeToChar(pDate),9,2)+":"+Substr(DateTimeToChar(pDate),11,2)+":"+Substr(DateTimeToChar(pDate),13,2) // data Convertita */
        cDate = CPLib.Substr(CPLib.DateTimeToChar(pDate),7,2)+"-"+CPLib.Substr(CPLib.DateTimeToChar(pDate),5,2)+"-"+CPLib.Left(CPLib.DateTimeToChar(pDate),4)+" "+CPLib.Substr(CPLib.DateTimeToChar(pDate),9,2)+":"+CPLib.Substr(CPLib.DateTimeToChar(pDate),11,2)+":"+CPLib.Substr(CPLib.DateTimeToChar(pDate),13,2);
        /* Case pTipo='2' */
      } else if (CPLib.eqr(pTipo,"2")) {
        /* cDate := Left(DateTimeToChar(pDate),4) + '-' + Substr(DateTimeToChar(pDate),5,2) + '-' + Substr(DateTimeToChar(pDate),7,2) + "T" +Substr(DateTimeToChar(pDate),9,2) + ":" + Substr(DateTimeToChar(pDate),11,2) + ":" + Substr(DateTimeToChar(pDate),13,2) // data Convertita */
        cDate = CPLib.Left(CPLib.DateTimeToChar(pDate),4)+"-"+CPLib.Substr(CPLib.DateTimeToChar(pDate),5,2)+"-"+CPLib.Substr(CPLib.DateTimeToChar(pDate),7,2)+"T"+CPLib.Substr(CPLib.DateTimeToChar(pDate),9,2)+":"+CPLib.Substr(CPLib.DateTimeToChar(pDate),11,2)+":"+CPLib.Substr(CPLib.DateTimeToChar(pDate),13,2);
        /* Case pTipo='3' */
      } else if (CPLib.eqr(pTipo,"3")) {
        /* cDate := Left(DateTimeToChar(pDate),4) + '-' + Substr(DateTimeToChar(pDate),5,2) + '-' + Substr(DateTimeToChar(pDate),7,2) + " " +Substr(DateTimeToChar(pDate),9,2) + ":" + Substr(DateTimeToChar(pDate),11,2) + ":" + Substr(DateTimeToChar(pDate),13,2) // data Convertita */
        cDate = CPLib.Left(CPLib.DateTimeToChar(pDate),4)+"-"+CPLib.Substr(CPLib.DateTimeToChar(pDate),5,2)+"-"+CPLib.Substr(CPLib.DateTimeToChar(pDate),7,2)+" "+CPLib.Substr(CPLib.DateTimeToChar(pDate),9,2)+":"+CPLib.Substr(CPLib.DateTimeToChar(pDate),11,2)+":"+CPLib.Substr(CPLib.DateTimeToChar(pDate),13,2);
      } // End Case
    } // End If
    /* Ritorna il parametro */
    /* Return cDate */
    throw new Stop(cDate);
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Timestamp p_pDate) {
    return RunAsync(p_pDate,"1");
  }
  public String RunAsync(java.sql.Timestamp p_pDate,String p_pTipo) {
    pDate = p_pDate;
    pTipo = p_pTipo;
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
  public String Run(java.sql.Timestamp p_pDate) {
    return Run(p_pDate,"1");
  }
  public String Run(java.sql.Timestamp p_pDate,String p_pTipo) {
    pDate = p_pDate;
    pTipo = p_pTipo;
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
  public static arfn_fdatetimeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_fdatetimeR(p_Ctx, p_Caller);
  }
  public static arfn_fdatetimeR Make(CPContext p_Ctx) {
    return new arfn_fdatetimeR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pDate = CPLib.NullDateTime();
    pTipo = CPLib.Space(1);
    cDate = CPLib.Space(19);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pDate","pTipo"};
}
