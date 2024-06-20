// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_chk_sl_fatcaR implements CallerWithObjs {
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
  public double pRiga;
  public String pTipo;
  public String pLista;
  public boolean bRitorno;
  public double _contar;
  public double _riga;
  public String _tipoi;
  public String _lista;
  public String _testo;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_chk_sl_fatcaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_chk_sl_fatca",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pRiga",p_cVarName)) {
      return pRiga;
    }
    if (CPLib.eqr("_contar",p_cVarName)) {
      return _contar;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_chk_sl_fatca";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pLista",p_cVarName)) {
      return pLista;
    }
    if (CPLib.eqr("_tipoi",p_cVarName)) {
      return _tipoi;
    }
    if (CPLib.eqr("_lista",p_cVarName)) {
      return _lista;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      return _testo;
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
    if (CPLib.eqr("pRiga",p_cVarName)) {
      pRiga = value;
      return;
    }
    if (CPLib.eqr("_contar",p_cVarName)) {
      _contar = value;
      return;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      _riga = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pLista",p_cVarName)) {
      pLista = value;
      return;
    }
    if (CPLib.eqr("_tipoi",p_cVarName)) {
      _tipoi = value;
      return;
    }
    if (CPLib.eqr("_lista",p_cVarName)) {
      _lista = value;
      return;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      _testo = value;
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
    /* Parametro */
    /* pRiga Numeric(4, 0) */
    /* pTipo Char(7) */
    /* pLista Memo */
    /* bRitorno Bool */
    /* _contar Numeric(4, 0) */
    /* _riga Numeric(2, 0) */
    /* _tipoi Char(8) */
    /* _lista Memo */
    /* _testo Char(9) */
    /* bRitorno := True */
    bRitorno = true;
    /* If pTipo='OECD304' */
    if (CPLib.eqr(pTipo,"OECD304")) {
      /* _contar := 0 */
      _contar = CPLib.Round(0,0);
      /* _lista := pLista */
      _lista = pLista;
      /* While At(pTipo,_lista) <> 0 */
      while (CPLib.ne(CPLib.At(pTipo,_lista),0)) {
        /* _testo := Substr(_lista,At(pTipo,_lista)-2,9) */
        _testo = CPLib.Substr(_lista,CPLib.At(pTipo,_lista)-2,9);
        /* If _testo <> LRTrim(Str(pRiga,4,0))+"."+LRTrim(pTipo) */
        if (CPLib.ne(_testo,CPLib.LRTrim(CPLib.Str(pRiga,4,0))+"."+CPLib.LRTrim(pTipo))) {
          /* bRitorno := False */
          bRitorno = false;
          // Exit Loop
          if (true) {
            break;
          }
        } // End If
        /* _lista := Substr(_lista,At(pTipo,_lista)) */
        _lista = CPLib.Substr(_lista,CPLib.At(pTipo,_lista));
      } // End While
    } // End If
    /* Return bRitorno */
    throw new Stop(bRitorno);
  }
  void _init_() {
  }
  public String RunAsync(double p_pRiga,String p_pTipo,String p_pLista) {
    pRiga = p_pRiga;
    pTipo = p_pTipo;
    pLista = p_pLista;
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
  public boolean Run(double p_pRiga,String p_pTipo,String p_pLista) {
    pRiga = p_pRiga;
    pTipo = p_pTipo;
    pLista = p_pLista;
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
  public static arfn_chk_sl_fatcaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_chk_sl_fatcaR(p_Ctx, p_Caller);
  }
  public static arfn_chk_sl_fatcaR Make(CPContext p_Ctx) {
    return new arfn_chk_sl_fatcaR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pRiga = 0;
    pTipo = CPLib.Space(7);
    pLista = "";
    bRitorno = false;
    _contar = 0;
    _riga = 0;
    _tipoi = CPLib.Space(8);
    _lista = "";
    _testo = CPLib.Space(9);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chk_sl_fatca,
  public static final String i_InvokedRoutines = ",arfn_chk_sl_fatca,";
  public static String[] m_cRunParameterNames={"pRiga","pTipo","pLista"};
}
