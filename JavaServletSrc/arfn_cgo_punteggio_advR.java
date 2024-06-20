// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_cgo_punteggio_advR implements CallerWithObjs {
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
  public double pDomanda;
  public double pValore;
  public double nRitorno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_cgo_punteggio_advR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_cgo_punteggio_adv",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDomanda",p_cVarName)) {
      return pDomanda;
    }
    if (CPLib.eqr("pValore",p_cVarName)) {
      return pValore;
    }
    if (CPLib.eqr("nRitorno",p_cVarName)) {
      return nRitorno;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_cgo_punteggio_adv";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
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
    if (CPLib.eqr("pDomanda",p_cVarName)) {
      pDomanda = value;
      return;
    }
    if (CPLib.eqr("pValore",p_cVarName)) {
      pValore = value;
      return;
    }
    if (CPLib.eqr("nRitorno",p_cVarName)) {
      nRitorno = value;
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
    /* pDomanda Numeric(2, 0) // Numero Domanda */
    /* pValore Numeric(3, 0) // Valore della Risposta */
    /* nRitorno Numeric(3, 0) */
    /* If pDomanda=1 */
    if (CPLib.eqr(pDomanda,1)) {
      /* Case pValore=1 */
      if (CPLib.eqr(pValore,1)) {
        /* nRitorno := 15 */
        nRitorno = CPLib.Round(15,0);
        /* Case pValore=2 */
      } else if (CPLib.eqr(pValore,2)) {
        /* nRitorno := 5 */
        nRitorno = CPLib.Round(5,0);
        /* Case pValore=3 */
      } else if (CPLib.eqr(pValore,3)) {
        /* nRitorno := 1 */
        nRitorno = CPLib.Round(1,0);
        /* Case pValore=4 */
      } else if (CPLib.eqr(pValore,4)) {
        /* nRitorno := 1 */
        nRitorno = CPLib.Round(1,0);
      } // End Case
    } // End If
    /* If pDomanda=2 */
    if (CPLib.eqr(pDomanda,2)) {
      /* Case pValore=1 */
      if (CPLib.eqr(pValore,1)) {
        /* nRitorno := 15 */
        nRitorno = CPLib.Round(15,0);
        /* Case pValore=2 */
      } else if (CPLib.eqr(pValore,2)) {
        /* nRitorno := 10 */
        nRitorno = CPLib.Round(10,0);
        /* Case pValore=3 */
      } else if (CPLib.eqr(pValore,3)) {
        /* nRitorno := 3 */
        nRitorno = CPLib.Round(3,0);
        /* Case pValore=4 */
      } else if (CPLib.eqr(pValore,4)) {
        /* nRitorno := 0 */
        nRitorno = CPLib.Round(0,0);
      } // End Case
    } // End If
    /* If pDomanda=3 */
    if (CPLib.eqr(pDomanda,3)) {
      /* Case pValore=1 */
      if (CPLib.eqr(pValore,1)) {
        /* nRitorno := 1 */
        nRitorno = CPLib.Round(1,0);
        /* Case pValore=2 */
      } else if (CPLib.eqr(pValore,2)) {
        /* nRitorno := 10 */
        nRitorno = CPLib.Round(10,0);
        /* Case pValore=3 */
      } else if (CPLib.eqr(pValore,3)) {
        /* nRitorno := 15 */
        nRitorno = CPLib.Round(15,0);
        /* Case pValore=4 */
      } else if (CPLib.eqr(pValore,4)) {
        /* nRitorno := 10 */
        nRitorno = CPLib.Round(10,0);
      } // End Case
    } // End If
    /* If pDomanda=4 */
    if (CPLib.eqr(pDomanda,4)) {
      /* Case pValore=1 */
      if (CPLib.eqr(pValore,1)) {
        /* nRitorno := 20 */
        nRitorno = CPLib.Round(20,0);
        /* Case pValore=2 */
      } else if (CPLib.eqr(pValore,2)) {
        /* nRitorno := 15 */
        nRitorno = CPLib.Round(15,0);
        /* Case pValore=3 */
      } else if (CPLib.eqr(pValore,3)) {
        /* nRitorno := 15 */
        nRitorno = CPLib.Round(15,0);
        /* Case pValore=4 */
      } else if (CPLib.eqr(pValore,4)) {
        /* nRitorno := 10 */
        nRitorno = CPLib.Round(10,0);
        /* Case pValore=5 */
      } else if (CPLib.eqr(pValore,5)) {
        /* nRitorno := 1 */
        nRitorno = CPLib.Round(1,0);
      } // End Case
    } // End If
    /* If pDomanda=5 */
    if (CPLib.eqr(pDomanda,5)) {
      /* Case pValore=1 */
      if (CPLib.eqr(pValore,1)) {
        /* nRitorno := 15 */
        nRitorno = CPLib.Round(15,0);
        /* Case pValore=2 */
      } else if (CPLib.eqr(pValore,2)) {
        /* nRitorno := 15 */
        nRitorno = CPLib.Round(15,0);
        /* Case pValore=3 */
      } else if (CPLib.eqr(pValore,3)) {
        /* nRitorno := 5 */
        nRitorno = CPLib.Round(5,0);
        /* Case pValore=4 */
      } else if (CPLib.eqr(pValore,4)) {
        /* nRitorno := 15 */
        nRitorno = CPLib.Round(15,0);
        /* Case pValore=5 */
      } else if (CPLib.eqr(pValore,5)) {
        /* nRitorno := 15 */
        nRitorno = CPLib.Round(15,0);
      } // End Case
    } // End If
    /* If pDomanda=6 */
    if (CPLib.eqr(pDomanda,6)) {
      /* Case pValore=1 */
      if (CPLib.eqr(pValore,1)) {
        /* nRitorno := 0 */
        nRitorno = CPLib.Round(0,0);
        /* Case pValore=2 */
      } else if (CPLib.eqr(pValore,2)) {
        /* nRitorno := 20 */
        nRitorno = CPLib.Round(20,0);
      } // End Case
    } // End If
    /* If pDomanda=7 */
    if (CPLib.eqr(pDomanda,7)) {
      /* Case pValore=1 */
      if (CPLib.eqr(pValore,1)) {
        /* nRitorno := 1 */
        nRitorno = CPLib.Round(1,0);
        /* Case pValore=2 */
      } else if (CPLib.eqr(pValore,2)) {
        /* nRitorno := 1 */
        nRitorno = CPLib.Round(1,0);
        /* Case pValore=3 */
      } else if (CPLib.eqr(pValore,3)) {
        /* nRitorno := 1 */
        nRitorno = CPLib.Round(1,0);
        /* Case pValore=4 */
      } else if (CPLib.eqr(pValore,4)) {
        /* nRitorno := 5 */
        nRitorno = CPLib.Round(5,0);
        /* Case pValore=5 */
      } else if (CPLib.eqr(pValore,5)) {
        /* nRitorno := 10 */
        nRitorno = CPLib.Round(10,0);
        /* Case pValore=6 */
      } else if (CPLib.eqr(pValore,6)) {
        /* nRitorno := 5 */
        nRitorno = CPLib.Round(5,0);
      } // End Case
    } // End If
    /* If pDomanda=8 */
    if (CPLib.eqr(pDomanda,8)) {
      /* Case pValore=1 */
      if (CPLib.eqr(pValore,1)) {
        /* nRitorno := 10 */
        nRitorno = CPLib.Round(10,0);
        /* Case pValore=2 */
      } else if (CPLib.eqr(pValore,2)) {
        /* nRitorno := 5 */
        nRitorno = CPLib.Round(5,0);
        /* Case pValore=3 */
      } else if (CPLib.eqr(pValore,3)) {
        /* nRitorno := 5 */
        nRitorno = CPLib.Round(5,0);
      } // End Case
    } // End If
    /* If pDomanda=9 */
    if (CPLib.eqr(pDomanda,9)) {
      /* Case pValore=1 */
      if (CPLib.eqr(pValore,1)) {
        /* nRitorno := 10 */
        nRitorno = CPLib.Round(10,0);
        /* Case pValore=2 */
      } else if (CPLib.eqr(pValore,2)) {
        /* nRitorno := 0 */
        nRitorno = CPLib.Round(0,0);
      } // End Case
    } // End If
    /* If pDomanda=10 */
    if (CPLib.eqr(pDomanda,10)) {
      /* Case pValore=1 */
      if (CPLib.eqr(pValore,1)) {
        /* nRitorno := 5 */
        nRitorno = CPLib.Round(5,0);
        /* Case pValore=2 */
      } else if (CPLib.eqr(pValore,2)) {
        /* nRitorno := 1 */
        nRitorno = CPLib.Round(1,0);
      } // End Case
    } // End If
    /* If pDomanda=11 */
    if (CPLib.eqr(pDomanda,11)) {
      /* Case pValore=1 */
      if (CPLib.eqr(pValore,1)) {
        /* nRitorno := 10 */
        nRitorno = CPLib.Round(10,0);
        /* Case pValore=2 */
      } else if (CPLib.eqr(pValore,2)) {
        /* nRitorno := 5 */
        nRitorno = CPLib.Round(5,0);
      } // End Case
    } // End If
    /* If pDomanda=12 */
    if (CPLib.eqr(pDomanda,12)) {
      /* Case pValore=1 */
      if (CPLib.eqr(pValore,1)) {
        /* nRitorno := 40 */
        nRitorno = CPLib.Round(40,0);
        /* Case pValore=2 */
      } else if (CPLib.eqr(pValore,2)) {
        /* nRitorno := 0 */
        nRitorno = CPLib.Round(0,0);
      } // End Case
    } // End If
    /* Return nRitorno */
    throw new Stop(nRitorno);
  }
  void _init_() {
  }
  public String RunAsync(double p_pDomanda,double p_pValore) {
    pDomanda = p_pDomanda;
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
  public double Run(double p_pDomanda,double p_pValore) {
    pDomanda = p_pDomanda;
    pValore = p_pValore;
    return Run();
  }
  public double Run() {
    double l_result;
    l_result = 0;
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
        l_result = stop_value.GetNumber();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = 0;
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
  public static arfn_cgo_punteggio_advR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_cgo_punteggio_advR(p_Ctx, p_Caller);
  }
  public static arfn_cgo_punteggio_advR Make(CPContext p_Ctx) {
    return new arfn_cgo_punteggio_advR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pDomanda = 0;
    pValore = 0;
    nRitorno = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_cgo_punteggio_adv,
  public static final String i_InvokedRoutines = ",arfn_cgo_punteggio_adv,";
  public static String[] m_cRunParameterNames={"pDomanda","pValore"};
}
