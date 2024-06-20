// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_chkdatperR implements CallerWithObjs {
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
  public java.sql.Date pDaDatOpe;
  public java.sql.Date pADatOpe;
  public String pTipOpe;
  public java.sql.Date gDatDel;
  public java.sql.Date gDatTra;
  public String bRitorno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_chkdatperR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_chkdatper",m_Caller);
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
      return "arfn_chkdatper";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pTipOpe",p_cVarName)) {
      return pTipOpe;
    }
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      return bRitorno;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDaDatOpe",p_cVarName)) {
      return pDaDatOpe;
    }
    if (CPLib.eqr("pADatOpe",p_cVarName)) {
      return pADatOpe;
    }
    if (CPLib.eqr("gDatDel",p_cVarName)) {
      return gDatDel;
    }
    if (CPLib.eqr("gDatTra",p_cVarName)) {
      return gDatTra;
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
    if (CPLib.eqr("pTipOpe",p_cVarName)) {
      pTipOpe = value;
      return;
    }
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      bRitorno = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDaDatOpe",p_cVarName)) {
      pDaDatOpe = value;
      return;
    }
    if (CPLib.eqr("pADatOpe",p_cVarName)) {
      pADatOpe = value;
      return;
    }
    if (CPLib.eqr("gDatDel",p_cVarName)) {
      gDatDel = value;
      return;
    }
    if (CPLib.eqr("gDatTra",p_cVarName)) {
      gDatTra = value;
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
    /* pDaDatOpe Date */
    /* pADatOpe Date */
    /* pTipOpe Char(1) */
    /* Varibili Globali */
    /* gDatDel Date // Data Massima Cancellazione Operazioni */
    /* gDatTra Date // Data Massima Trasf a Storico */
    /* Varibile di ritorno */
    /* bRitorno Char(70) */
    /* Verifica in base al tipo */
    /* bRitorno := '' */
    bRitorno = "";
    /* If pDaDatOpe > pADatOpe */
    if (CPLib.gt(pDaDatOpe,pADatOpe)) {
      /* bRitorno := 'La data di fine periodo deve essere maggiore di quella di inizio periodo' */
      bRitorno = "La data di fine periodo deve essere maggiore di quella di inizio periodo";
    } // End If
    /* If pTipOpe = "T" */
    if (CPLib.eqr(pTipOpe,"T")) {
      /* If pADatOpe > gDatTra */
      if (CPLib.gt(pADatOpe,gDatTra)) {
        /* bRitorno := 'La data di fine periodo deve essere inferiore di 3 mesi rispetto alla data odierna' */
        bRitorno = "La data di fine periodo deve essere inferiore di 3 mesi rispetto alla data odierna";
      } // End If
    } else { // Else
      /* If pADatOpe > gDatDel */
      if (CPLib.gt(pADatOpe,gDatDel)) {
        /* bRitorno := 'La data di fine periodo deve essere inferiore di 10 anni rispetto alla data odierna' */
        bRitorno = "La data di fine periodo deve essere inferiore di 10 anni rispetto alla data odierna";
      } // End If
    } // End If
    /* Return bRitorno */
    throw new Stop(bRitorno);
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_pDaDatOpe,java.sql.Date p_pADatOpe,String p_pTipOpe) {
    pDaDatOpe = p_pDaDatOpe;
    pADatOpe = p_pADatOpe;
    pTipOpe = p_pTipOpe;
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
  public String Run(java.sql.Date p_pDaDatOpe,java.sql.Date p_pADatOpe,String p_pTipOpe) {
    pDaDatOpe = p_pDaDatOpe;
    pADatOpe = p_pADatOpe;
    pTipOpe = p_pTipOpe;
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
  public static arfn_chkdatperR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_chkdatperR(p_Ctx, p_Caller);
  }
  public static arfn_chkdatperR Make(CPContext p_Ctx) {
    return new arfn_chkdatperR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pDaDatOpe = CPLib.NullDate();
    pADatOpe = CPLib.NullDate();
    pTipOpe = CPLib.Space(1);
    bRitorno = CPLib.Space(70);
    gDatDel=m_Ctx.GetGlobalDate("gDatDel");
    gDatTra=m_Ctx.GetGlobalDate("gDatTra");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chkdatper,
  public static final String i_InvokedRoutines = ",arfn_chkdatper,";
  public static String[] m_cRunParameterNames={"pDaDatOpe","pADatOpe","pTipOpe"};
}
