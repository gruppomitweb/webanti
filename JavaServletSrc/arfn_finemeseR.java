// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_finemeseR implements CallerWithObjs {
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
  public java.sql.Date pDatIni;
  public String _annomese;
  public double _mese;
  public double _anno;
  public String _datanew;
  public java.sql.Date _data;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_finemeseR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_finemese",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_mese",p_cVarName)) {
      return _mese;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_finemese";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("_annomese",p_cVarName)) {
      return _annomese;
    }
    if (CPLib.eqr("_datanew",p_cVarName)) {
      return _datanew;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDatIni",p_cVarName)) {
      return pDatIni;
    }
    if (CPLib.eqr("_data",p_cVarName)) {
      return _data;
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
    if (CPLib.eqr("_mese",p_cVarName)) {
      _mese = value;
      return;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      _anno = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_annomese",p_cVarName)) {
      _annomese = value;
      return;
    }
    if (CPLib.eqr("_datanew",p_cVarName)) {
      _datanew = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDatIni",p_cVarName)) {
      pDatIni = value;
      return;
    }
    if (CPLib.eqr("_data",p_cVarName)) {
      _data = value;
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
    /* Parametro */
    /* pDatIni Date // Data di partenza */
    /* Definizione variabili locali */
    /* _annomese Char(6) */
    /* _mese Numeric(2, 0) */
    /* _anno Numeric(4, 0) */
    /* _datanew Char(8) */
    /* _data Date */
    /* Seleziona Anno mese e quindi verifica */
    /* If not(Empty(pDatIni)) */
    if ( ! (CPLib.Empty(pDatIni))) {
      /* _annomese := Left(DateToChar(pDatIni),6) */
      _annomese = CPLib.Left(CPLib.DateToChar(pDatIni),6);
      /* _anno := Year(pDatIni) */
      _anno = CPLib.Round(CPLib.Year(pDatIni),0);
      /* _mese := Month(pDatIni) */
      _mese = CPLib.Round(CPLib.Month(pDatIni),0);
      /* Verifica il mese */
      /* Case _mese = 4 or _mese = 6 or _mese = 9 or _mese = 11 */
      if (CPLib.eqr(_mese,4) || CPLib.eqr(_mese,6) || CPLib.eqr(_mese,9) || CPLib.eqr(_mese,11)) {
        /* _datanew := _annomese + '30' */
        _datanew = _annomese+"30";
        /* Case _mese = 2 */
      } else if (CPLib.eqr(_mese,2)) {
        /* If Mod(_anno,100) <> 0 and Mod(_anno,4) = 0 */
        if (CPLib.ne(CPLib.Mod(_anno,100),0) && CPLib.eqr(CPLib.Mod(_anno,4),0)) {
          /* _datanew := _annomese + '29' */
          _datanew = _annomese+"29";
          /* ElseIf Mod(_anno,4) <> 0 */
        } else if (CPLib.ne(CPLib.Mod(_anno,4),0)) {
          /* _datanew := _annomese + '28' */
          _datanew = _annomese+"28";
          /* ElseIf Mod(_anno,100) = 0 and Mod(_anno,400) <> 0 */
        } else if (CPLib.eqr(CPLib.Mod(_anno,100),0) && CPLib.ne(CPLib.Mod(_anno,400),0)) {
          /* _datanew := _annomese + '28' */
          _datanew = _annomese+"28";
          /* ElseIf Mod(_anno,100) = 0 and Mod(_anno,400) = 0 */
        } else if (CPLib.eqr(CPLib.Mod(_anno,100),0) && CPLib.eqr(CPLib.Mod(_anno,400),0)) {
          /* _datanew := _annomese + '29' */
          _datanew = _annomese+"29";
        } // End If
      } else { // Otherwise
        /* _datanew := _annomese + '31' */
        _datanew = _annomese+"31";
      } // End Case
      /* _data := CharToDate(_datanew) */
      _data = CPLib.CharToDate(_datanew);
    } else { // Else
      /* _data := NullDate() */
      _data = CPLib.NullDate();
    } // End If
    /* Return _data */
    throw new Stop(_data);
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_pDatIni) {
    pDatIni = p_pDatIni;
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
  public java.sql.Date Run(java.sql.Date p_pDatIni) {
    pDatIni = p_pDatIni;
    return Run();
  }
  public java.sql.Date Run() {
    java.sql.Date l_result;
    l_result = CPLib.NullDate();
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
        l_result = stop_value.GetDate();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = CPLib.NullDate();
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
  public static arfn_finemeseR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_finemeseR(p_Ctx, p_Caller);
  }
  public static arfn_finemeseR Make(CPContext p_Ctx) {
    return new arfn_finemeseR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pDatIni = CPLib.NullDate();
    _annomese = CPLib.Space(6);
    _mese = 0;
    _anno = 0;
    _datanew = CPLib.Space(8);
    _data = CPLib.NullDate();
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_finemese,
  public static final String i_InvokedRoutines = ",arfn_finemese,";
  public static String[] m_cRunParameterNames={"pDatIni"};
}
