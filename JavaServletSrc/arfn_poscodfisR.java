// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_poscodfisR implements CallerWithObjs {
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
  public String pCODFIS;
  public boolean bRitorno;
  public double nV1;
  public double nVal;
  public double conta;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_poscodfisR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_poscodfis",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("nV1",p_cVarName)) {
      return nV1;
    }
    if (CPLib.eqr("nVal",p_cVarName)) {
      return nVal;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_poscodfis";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pCODFIS",p_cVarName)) {
      return pCODFIS;
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
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("nV1",p_cVarName)) {
      nV1 = value;
      return;
    }
    if (CPLib.eqr("nVal",p_cVarName)) {
      nVal = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pCODFIS",p_cVarName)) {
      pCODFIS = value;
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
    /* Verifica Codice Fiscale - Partita IVA */
    /* pCODFIS Char(16) // Codice Fiscale o Partita IVA */
    /* bRitorno Bool // Valore di Ritorno */
    /* nV1 Numeric(3, 0) // Somma Valori Dispari */
    /* nVal Numeric(2, 0) // Valore Carattere ASCII */
    /* conta Numeric(2, 0) */
    /* bRitorno := False // Valore di Ritorno */
    bRitorno = false;
    /* pCODFIS := Upper(pCODFIS) // Codice Fiscale o Partita IVA */
    pCODFIS = CPLib.Upper(pCODFIS);
    /* conta := 1 */
    conta = CPLib.Round(1,0);
    /* nVal := 0 // Valore Carattere ASCII */
    nVal = CPLib.Round(0,0);
    /* While conta <= 16 */
    while (CPLib.le(conta,16)) {
      /* nV1 := Asc(Substr(pCODFIS,conta,1)) // Valore Carattere ASCII */
      nV1 = CPLib.Round(CPLib.Asc(CPLib.Substr(pCODFIS,conta,1)),0);
      /* If (conta >= 1 and conta <=6) or (conta =9) or (conta=12)  or (conta=16) */
      if ((CPLib.ge(conta,1) && CPLib.le(conta,6)) || (CPLib.eqr(conta,9)) || (CPLib.eqr(conta,12)) || (CPLib.eqr(conta,16))) {
        /* If nV1 >= 65 and nV1 <= 90 */
        if (CPLib.ge(nV1,65) && CPLib.le(nV1,90)) {
          /* nVal := nVal + 1 // Valore Carattere ASCII */
          nVal = CPLib.Round(nVal+1,0);
        } // End If
      } else { // Else
        /* If nV1 >= 48 and nV1 <= 57 */
        if (CPLib.ge(nV1,48) && CPLib.le(nV1,57)) {
          /* nVal := nVal + 1 // Valore Carattere ASCII */
          nVal = CPLib.Round(nVal+1,0);
        } // End If
      } // End If
      /* conta := conta + 1 */
      conta = CPLib.Round(conta+1,0);
    } // End While
    /* If nVal=16 */
    if (CPLib.eqr(nVal,16)) {
      /* bRitorno := True // Valore di Ritorno */
      bRitorno = true;
    } // End If
    /* Return bRitorno */
    throw new Stop(bRitorno);
  }
  void _init_() {
  }
  public String RunAsync(String p_pCODFIS) {
    pCODFIS = p_pCODFIS;
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
  public boolean Run(String p_pCODFIS) {
    pCODFIS = p_pCODFIS;
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
  public static arfn_poscodfisR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_poscodfisR(p_Ctx, p_Caller);
  }
  public static arfn_poscodfisR Make(CPContext p_Ctx) {
    return new arfn_poscodfisR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pCODFIS = CPLib.Space(16);
    bRitorno = false;
    nV1 = 0;
    nVal = 0;
    conta = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_poscodfis,
  public static final String i_InvokedRoutines = ",arfn_poscodfis,";
  public static String[] m_cRunParameterNames={"pCODFIS"};
}
