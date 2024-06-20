// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_mesecfR implements CallerWithObjs {
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
  public String pMese;
  public String bRitorno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_mesecfR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_mesecf",m_Caller);
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
      return "arfn_mesecf";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pMese",p_cVarName)) {
      return pMese;
    }
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      return bRitorno;
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
    if (CPLib.eqr("pMese",p_cVarName)) {
      pMese = value;
      return;
    }
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      bRitorno = value;
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
    /* Parametro */
    /* pMese Char(1) */
    /* Variabile Locale */
    /* bRitorno Char(2) */
    /* Verifica il mese */
    /* Case Upper(pMese)='A' */
    if (CPLib.eqr(CPLib.Upper(pMese),"A")) {
      /* bRitorno := '01' */
      bRitorno = "01";
      /* Case Upper(pMese)='B' */
    } else if (CPLib.eqr(CPLib.Upper(pMese),"B")) {
      /* bRitorno := '02' */
      bRitorno = "02";
      /* Case Upper(pMese)='C' */
    } else if (CPLib.eqr(CPLib.Upper(pMese),"C")) {
      /* bRitorno := '03' */
      bRitorno = "03";
      /* Case Upper(pMese)='D' */
    } else if (CPLib.eqr(CPLib.Upper(pMese),"D")) {
      /* bRitorno := '04' */
      bRitorno = "04";
      /* Case Upper(pMese)='E' */
    } else if (CPLib.eqr(CPLib.Upper(pMese),"E")) {
      /* bRitorno := '05' */
      bRitorno = "05";
      /* Case Upper(pMese)='H' */
    } else if (CPLib.eqr(CPLib.Upper(pMese),"H")) {
      /* bRitorno := '06' */
      bRitorno = "06";
      /* Case Upper(pMese)='L' */
    } else if (CPLib.eqr(CPLib.Upper(pMese),"L")) {
      /* bRitorno := '07' */
      bRitorno = "07";
      /* Case Upper(pMese)='M' */
    } else if (CPLib.eqr(CPLib.Upper(pMese),"M")) {
      /* bRitorno := '08' */
      bRitorno = "08";
      /* Case Upper(pMese)='P' */
    } else if (CPLib.eqr(CPLib.Upper(pMese),"P")) {
      /* bRitorno := '09' */
      bRitorno = "09";
      /* Case Upper(pMese)='R' */
    } else if (CPLib.eqr(CPLib.Upper(pMese),"R")) {
      /* bRitorno := '10' */
      bRitorno = "10";
      /* Case Upper(pMese)='S' */
    } else if (CPLib.eqr(CPLib.Upper(pMese),"S")) {
      /* bRitorno := '11' */
      bRitorno = "11";
      /* Case Upper(pMese)='T' */
    } else if (CPLib.eqr(CPLib.Upper(pMese),"T")) {
      /* bRitorno := '12' */
      bRitorno = "12";
    } else { // Otherwise
      /* bRitorno := '00' */
      bRitorno = "00";
    } // End Case
    /* Return bRitorno */
    throw new Stop(bRitorno);
  }
  void _init_() {
  }
  public String RunAsync(String p_pMese) {
    pMese = p_pMese;
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
  public String Run(String p_pMese) {
    pMese = p_pMese;
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
  public static arfn_mesecfR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_mesecfR(p_Ctx, p_Caller);
  }
  public static arfn_mesecfR Make(CPContext p_Ctx) {
    return new arfn_mesecfR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pMese = CPLib.Space(1);
    bRitorno = CPLib.Space(2);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_mesecf,
  public static final String i_InvokedRoutines = ",arfn_mesecf,";
  public static String[] m_cRunParameterNames={"pMese"};
}
