// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_anomes_oamR implements CallerWithObjs {
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
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public MemoryCursorRow_qbe_oam_operazbo_vqr pRiga;
  public String pNCF;
  public MemoryCursor_mcerrsaldi_mcrdef mcErrori;
  public MemoryCursor_mcerrsaldi_mcrdef mcErrPers;
  public MemoryCursorRow_mcerrsaldi_mcrdef rowErrore;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_anomes_oamR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_anomes_oam",m_Caller);
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
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
      return "arfn_anomes_oam";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pNCF",p_cVarName)) {
      return pNCF;
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
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      return mcErrori;
    }
    if (CPLib.eqr("mcErrPers",p_cVarName)) {
      return mcErrPers;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pRiga",p_cVarName)) {
      return pRiga;
    }
    if (CPLib.eqr("rowErrore",p_cVarName)) {
      return rowErrore;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pNCF",p_cVarName)) {
      pNCF = value;
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
    if (CPLib.eqr("pRiga",p_cVarName)) {
      pRiga = (MemoryCursorRow_qbe_oam_operazbo_vqr)value;
      return;
    }
    if (CPLib.eqr("rowErrore",p_cVarName)) {
      rowErrore = (MemoryCursorRow_mcerrsaldi_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      mcErrori = (MemoryCursor_mcerrsaldi_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcErrPers",p_cVarName)) {
      mcErrPers = (MemoryCursor_mcerrsaldi_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    /* pRiga Row(qbe_oam_operazbo.vqr) // Valori della riga da esaminare */
    /* pNCF Char(1) // Non verificare codice fiscale */
    /* mcErrori MemoryCursor(mcErrSaldi.MCRDef) */
    /* mcErrPers MemoryCursor(mcErrSaldi.MCRDef) */
    /* rowErrore Row(mcErrSaldi.MCRDef) */
    /* If Empty(pRiga.CODANA) */
    if (CPLib.Empty(pRiga.CODANA)) {
      /* mcErrori.AppendBlank() */
      mcErrori.AppendBlank();
      /* mcErrori.TIPO := pRiga.TIPO */
      mcErrori.row.TIPO = pRiga.TIPO;
      /* mcErrori.RAPPORTO := pRiga.NUMPROG */
      mcErrori.row.RAPPORTO = pRiga.NUMPROG;
      /* mcErrori.TXTERR :=  'Manca Causale Analitica' */
      mcErrori.row.TXTERR = "Manca Causale Analitica";
      /* mcErrori.SaveRow() */
      mcErrori.SaveRow();
    } // End If
    /* If Empty(pRiga.DATAOPE) */
    if (CPLib.Empty(pRiga.DATAOPE)) {
      /* mcErrori.AppendBlank() */
      mcErrori.AppendBlank();
      /* mcErrori.TIPO := pRiga.TIPO */
      mcErrori.row.TIPO = pRiga.TIPO;
      /* mcErrori.RAPPORTO := pRiga.NUMPROG */
      mcErrori.row.RAPPORTO = pRiga.NUMPROG;
      /* mcErrori.TXTERR :=  'Manca Data Operazione' */
      mcErrori.row.TXTERR = "Manca Data Operazione";
      /* mcErrori.SaveRow() */
      mcErrori.SaveRow();
    } // End If
    /* If Empty(pRiga.VALUTA) */
    if (CPLib.Empty(pRiga.VALUTA)) {
      /* mcErrori.AppendBlank() */
      mcErrori.AppendBlank();
      /* mcErrori.TIPO := pRiga.TIPO */
      mcErrori.row.TIPO = pRiga.TIPO;
      /* mcErrori.RAPPORTO := pRiga.NUMPROG */
      mcErrori.row.RAPPORTO = pRiga.NUMPROG;
      /* mcErrori.TXTERR :=  'Manca il codice della valuta' */
      mcErrori.row.TXTERR = "Manca il codice della valuta";
      /* mcErrori.SaveRow() */
      mcErrori.SaveRow();
    } // End If
    /* If Empty(pRiga.VALUTA) */
    if (CPLib.Empty(pRiga.VALUTA)) {
      /* mcErrori.AppendBlank() */
      mcErrori.AppendBlank();
      /* mcErrori.TIPO := pRiga.TIPO */
      mcErrori.row.TIPO = pRiga.TIPO;
      /* mcErrori.RAPPORTO := pRiga.NUMPROG */
      mcErrori.row.RAPPORTO = pRiga.NUMPROG;
      /* mcErrori.TXTERR :=  'Manca il codice della valuta' */
      mcErrori.row.TXTERR = "Manca il codice della valuta";
      /* mcErrori.SaveRow() */
      mcErrori.SaveRow();
    } // End If
    /* If pRiga.CAMBIO=0 */
    if (CPLib.eqr(pRiga.CAMBIO,0)) {
      /* mcErrori.AppendBlank() */
      mcErrori.AppendBlank();
      /* mcErrori.TIPO := pRiga.TIPO */
      mcErrori.row.TIPO = pRiga.TIPO;
      /* mcErrori.RAPPORTO := pRiga.NUMPROG */
      mcErrori.row.RAPPORTO = pRiga.NUMPROG;
      /* mcErrori.TXTERR :=  'Il valore del cambio è pari a 0' */
      mcErrori.row.TXTERR = "Il valore del cambio è pari a 0";
      /* mcErrori.SaveRow() */
      mcErrori.SaveRow();
    } // End If
    /* If pRiga.IMPIN=0 */
    if (CPLib.eqr(pRiga.IMPIN,0)) {
      /* mcErrori.AppendBlank() */
      mcErrori.AppendBlank();
      /* mcErrori.TIPO := pRiga.TIPO */
      mcErrori.row.TIPO = pRiga.TIPO;
      /* mcErrori.RAPPORTO := pRiga.NUMPROG */
      mcErrori.row.RAPPORTO = pRiga.NUMPROG;
      /* mcErrori.TXTERR :=  'Il valore del importo in entrata è pari a 0' */
      mcErrori.row.TXTERR = "Il valore del importo in entrata è pari a 0";
      /* mcErrori.SaveRow() */
      mcErrori.SaveRow();
    } // End If
    /* If pRiga.IMPOUT=0 */
    if (CPLib.eqr(pRiga.IMPOUT,0)) {
      /* mcErrori.AppendBlank() */
      mcErrori.AppendBlank();
      /* mcErrori.TIPO := pRiga.TIPO */
      mcErrori.row.TIPO = pRiga.TIPO;
      /* mcErrori.RAPPORTO := pRiga.NUMPROG */
      mcErrori.row.RAPPORTO = pRiga.NUMPROG;
      /* mcErrori.TXTERR :=  'Il valore del importo in entrata è pari a 0' */
      mcErrori.row.TXTERR = "Il valore del importo in entrata è pari a 0";
      /* mcErrori.SaveRow() */
      mcErrori.SaveRow();
    } // End If
    /* mcErrPers := arfn_anompers_oam(pRiga.CONNESCLI,pRiga.TIPO,pRiga.NUMPROG,pRiga.DATAOPE,pNCF) */
    mcErrPers = arfn_anompers_oamR.Make(m_Ctx,this).Run(pRiga.CONNESCLI,pRiga.TIPO,pRiga.NUMPROG,pRiga.DATAOPE,pNCF);
    for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrPers._iterable_()) {
      /* mcErrori.AppendBlank() */
      mcErrori.AppendBlank();
      /* mcErrori.TIPO := pRiga.TIPO */
      mcErrori.row.TIPO = pRiga.TIPO;
      /* mcErrori.RAPPORTO := pRiga.NUMPROG */
      mcErrori.row.RAPPORTO = pRiga.NUMPROG;
      /* mcErrori.TXTERR := rowErrore.TXTERR */
      mcErrori.row.TXTERR = rowErrore.TXTERR;
      /* mcErrori.CONNESINT := rowErrore.CONNESINT */
      mcErrori.row.CONNESINT = rowErrore.CONNESINT;
      /* mcErrori.SaveRow() */
      mcErrori.SaveRow();
    }
    /* Return mcErrori */
    throw new Stop(mcErrori);
  }
  void _init_() {
  }
  public String RunAsync(MemoryCursorRow_qbe_oam_operazbo_vqr p_pRiga,String p_pNCF) {
    pRiga = p_pRiga;
    pNCF = p_pNCF;
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
  public MemoryCursor_mcerrsaldi_mcrdef Run(MemoryCursorRow_qbe_oam_operazbo_vqr p_pRiga,String p_pNCF) {
    pRiga = p_pRiga;
    pNCF = p_pNCF;
    return Run();
  }
  public MemoryCursor_mcerrsaldi_mcrdef Run() {
    MemoryCursor_mcerrsaldi_mcrdef l_result;
    l_result = null;
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
        l_result = (MemoryCursor_mcerrsaldi_mcrdef)stop_value.GetObject();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = null;
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
  public static arfn_anomes_oamR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_anomes_oamR(p_Ctx, p_Caller);
  }
  public static arfn_anomes_oamR Make(CPContext p_Ctx) {
    return new arfn_anomes_oamR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pRiga = new MemoryCursorRow_qbe_oam_operazbo_vqr();
    pNCF = CPLib.Space(1);
    mcErrori = new MemoryCursor_mcerrsaldi_mcrdef();
    mcErrPers = new MemoryCursor_mcerrsaldi_mcrdef();
    rowErrore = new MemoryCursorRow_mcerrsaldi_mcrdef();
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_anomes_oam,arfn_anompers_oam,
  public static final String i_InvokedRoutines = ",arfn_anomes_oam,arfn_anompers_oam,";
  public static String[] m_cRunParameterNames={"pRiga","pNCF"};
}
