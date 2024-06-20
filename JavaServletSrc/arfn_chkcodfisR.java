// * --- Area Manuale = BO - Header
// * --- arfn_chkcodfis
import it.finanze.entrate.aru00.util.legacy.CodiceFiscale;
// * --- Fine Area Manuale
public class arfn_chkcodfisR implements CallerWithObjs {
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
  public String pSTATO;
  public double pCFE;
  public boolean bRitorno;
  public double nCR;
  public String cCR;
  public double nV1;
  public double nV2;
  public double nVal;
  public double nVal1;
  public double conta;
  public double nCR1;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_chkcodfisR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_chkcodfis",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pCFE",p_cVarName)) {
      return pCFE;
    }
    if (CPLib.eqr("nCR",p_cVarName)) {
      return nCR;
    }
    if (CPLib.eqr("nV1",p_cVarName)) {
      return nV1;
    }
    if (CPLib.eqr("nV2",p_cVarName)) {
      return nV2;
    }
    if (CPLib.eqr("nVal",p_cVarName)) {
      return nVal;
    }
    if (CPLib.eqr("nVal1",p_cVarName)) {
      return nVal1;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("nCR1",p_cVarName)) {
      return nCR1;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_chkcodfis";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pCODFIS",p_cVarName)) {
      return pCODFIS;
    }
    if (CPLib.eqr("pSTATO",p_cVarName)) {
      return pSTATO;
    }
    if (CPLib.eqr("cCR",p_cVarName)) {
      return cCR;
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
    if (CPLib.eqr("pCFE",p_cVarName)) {
      pCFE = value;
      return;
    }
    if (CPLib.eqr("nCR",p_cVarName)) {
      nCR = value;
      return;
    }
    if (CPLib.eqr("nV1",p_cVarName)) {
      nV1 = value;
      return;
    }
    if (CPLib.eqr("nV2",p_cVarName)) {
      nV2 = value;
      return;
    }
    if (CPLib.eqr("nVal",p_cVarName)) {
      nVal = value;
      return;
    }
    if (CPLib.eqr("nVal1",p_cVarName)) {
      nVal1 = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("nCR1",p_cVarName)) {
      nCR1 = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pCODFIS",p_cVarName)) {
      pCODFIS = value;
      return;
    }
    if (CPLib.eqr("pSTATO",p_cVarName)) {
      pSTATO = value;
      return;
    }
    if (CPLib.eqr("cCR",p_cVarName)) {
      cCR = value;
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
    /* pSTATO Char(3) // Stato Residenza */
    /* pCFE Numeric(1, 0) // Codice Fiscale non generato da agenzia entrate */
    /* bRitorno Bool // Valore di Ritorno */
    /* nCR Numeric(3, 0) // Valore carattere di ritorno */
    /* cCR Char(1) // Carattere da controllare */
    /* nV1 Numeric(3, 0) // Somma Valori Dispari */
    /* nV2 Numeric(3, 0) // Somma Valori Pari */
    /* nVal Numeric(2, 0) // Valore Carattere ASCII */
    /* nVal1 Numeric(2, 0) // Valore di ritorno da controllo */
    /* conta Numeric(2, 0) */
    /* nCR1 Numeric(2, 0) */
    /* Verifica codice fiscale solo se italiano */
    /* bRitorno := True // Valore di Ritorno */
    bRitorno = true;
    /* If pCFE<>1 */
    if (CPLib.ne(pCFE,1)) {
      /* bRitorno := CodiceFiscale.isCF(pCODFIS) // Valore di Ritorno */
      bRitorno = CodiceFiscale.isCF(pCODFIS);
    } // End If
    /* Return bRitorno */
    throw new Stop(bRitorno);
  }
  void Page_2() throws Exception {
    /* Controlla valore ascii e ritorna il valore di controllo */
    /* Case nVal = 1 */
    if (CPLib.eqr(nVal,1)) {
      /* nVal1 := 1 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(1,0);
      /* Case nVal = 2 */
    } else if (CPLib.eqr(nVal,2)) {
      /* nVal1 := 0 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(0,0);
      /* Case nVal = 3 */
    } else if (CPLib.eqr(nVal,3)) {
      /* nVal1 := 5 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(5,0);
      /* Case nVal = 4 */
    } else if (CPLib.eqr(nVal,4)) {
      /* nVal1 := 7 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(7,0);
      /* Case nVal = 5 */
    } else if (CPLib.eqr(nVal,5)) {
      /* nVal1 := 9 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(9,0);
      /* Case nVal = 6 */
    } else if (CPLib.eqr(nVal,6)) {
      /* nVal1 := 13 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(13,0);
      /* Case nVal = 7 */
    } else if (CPLib.eqr(nVal,7)) {
      /* nVal1 := 15 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(15,0);
      /* Case nVal = 8 */
    } else if (CPLib.eqr(nVal,8)) {
      /* nVal1 := 17 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(17,0);
      /* Case nVal = 9 */
    } else if (CPLib.eqr(nVal,9)) {
      /* nVal1 := 19 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(19,0);
      /* Case nVal = 10 */
    } else if (CPLib.eqr(nVal,10)) {
      /* nVal1 := 21 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(21,0);
      /* Case nVal = 11 */
    } else if (CPLib.eqr(nVal,11)) {
      /* nVal1 := 2 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(2,0);
      /* Case nVal = 12 */
    } else if (CPLib.eqr(nVal,12)) {
      /* nVal1 := 4 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(4,0);
      /* Case nVal = 13 */
    } else if (CPLib.eqr(nVal,13)) {
      /* nVal1 := 18 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(18,0);
      /* Case nVal = 14 */
    } else if (CPLib.eqr(nVal,14)) {
      /* nVal1 := 20 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(20,0);
      /* Case nVal = 15 */
    } else if (CPLib.eqr(nVal,15)) {
      /* nVal1 := 11 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(11,0);
      /* Case nVal = 16 */
    } else if (CPLib.eqr(nVal,16)) {
      /* nVal1 := 3 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(3,0);
      /* Case nVal = 17 */
    } else if (CPLib.eqr(nVal,17)) {
      /* nVal1 := 6 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(6,0);
      /* Case nVal = 18 */
    } else if (CPLib.eqr(nVal,18)) {
      /* nVal1 := 8 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(8,0);
      /* Case nVal = 19 */
    } else if (CPLib.eqr(nVal,19)) {
      /* nVal1 := 12 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(12,0);
      /* Case nVal = 20 */
    } else if (CPLib.eqr(nVal,20)) {
      /* nVal1 := 14 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(14,0);
      /* Case nVal = 21 */
    } else if (CPLib.eqr(nVal,21)) {
      /* nVal1 := 16 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(16,0);
      /* Case nVal = 22 */
    } else if (CPLib.eqr(nVal,22)) {
      /* nVal1 := 10 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(10,0);
      /* Case nVal = 23 */
    } else if (CPLib.eqr(nVal,23)) {
      /* nVal1 := 22 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(22,0);
      /* Case nVal = 24 */
    } else if (CPLib.eqr(nVal,24)) {
      /* nVal1 := 25 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(25,0);
      /* Case nVal = 25 */
    } else if (CPLib.eqr(nVal,25)) {
      /* nVal1 := 24 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(24,0);
      /* Case nVal = 26 */
    } else if (CPLib.eqr(nVal,26)) {
      /* nVal1 := 23 // Valore di ritorno da controllo */
      nVal1 = CPLib.Round(23,0);
    } // End Case
  }
  void _init_() {
  }
  public String RunAsync(String p_pCODFIS,String p_pSTATO,double p_pCFE) {
    pCODFIS = p_pCODFIS;
    pSTATO = p_pSTATO;
    pCFE = p_pCFE;
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
  public boolean Run(String p_pCODFIS,String p_pSTATO,double p_pCFE) {
    pCODFIS = p_pCODFIS;
    pSTATO = p_pSTATO;
    pCFE = p_pCFE;
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
  public static arfn_chkcodfisR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_chkcodfisR(p_Ctx, p_Caller);
  }
  public static arfn_chkcodfisR Make(CPContext p_Ctx) {
    return new arfn_chkcodfisR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pCODFIS = CPLib.Space(16);
    pSTATO = CPLib.Space(3);
    pCFE = 0;
    bRitorno = false;
    nCR = 0;
    cCR = CPLib.Space(1);
    nV1 = 0;
    nV2 = 0;
    nVal = 0;
    nVal1 = 0;
    conta = 0;
    nCR1 = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chkcodfis,
  public static final String i_InvokedRoutines = ",arfn_chkcodfis,";
  public static String[] m_cRunParameterNames={"pCODFIS","pSTATO","pCFE"};
}
