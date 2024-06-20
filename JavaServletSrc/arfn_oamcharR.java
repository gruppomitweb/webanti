// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_oamcharR implements CallerWithObjs {
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
  public String pString;
  public String pChar;
  public double _ldem;
  public double _ldem2;
  public double _i;
  public String _strdem;
  public String _strdem2;
  public String _cdem;
  public String _ddem;
  public double _adem;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_oamcharR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_oamchar",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_ldem",p_cVarName)) {
      return _ldem;
    }
    if (CPLib.eqr("_ldem2",p_cVarName)) {
      return _ldem2;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      return _i;
    }
    if (CPLib.eqr("_adem",p_cVarName)) {
      return _adem;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_oamchar";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pString",p_cVarName)) {
      return pString;
    }
    if (CPLib.eqr("pChar",p_cVarName)) {
      return pChar;
    }
    if (CPLib.eqr("_strdem",p_cVarName)) {
      return _strdem;
    }
    if (CPLib.eqr("_strdem2",p_cVarName)) {
      return _strdem2;
    }
    if (CPLib.eqr("_cdem",p_cVarName)) {
      return _cdem;
    }
    if (CPLib.eqr("_ddem",p_cVarName)) {
      return _ddem;
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
    if (CPLib.eqr("_ldem",p_cVarName)) {
      _ldem = value;
      return;
    }
    if (CPLib.eqr("_ldem2",p_cVarName)) {
      _ldem2 = value;
      return;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      _i = value;
      return;
    }
    if (CPLib.eqr("_adem",p_cVarName)) {
      _adem = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pString",p_cVarName)) {
      pString = value;
      return;
    }
    if (CPLib.eqr("pChar",p_cVarName)) {
      pChar = value;
      return;
    }
    if (CPLib.eqr("_strdem",p_cVarName)) {
      _strdem = value;
      return;
    }
    if (CPLib.eqr("_strdem2",p_cVarName)) {
      _strdem2 = value;
      return;
    }
    if (CPLib.eqr("_cdem",p_cVarName)) {
      _cdem = value;
      return;
    }
    if (CPLib.eqr("_ddem",p_cVarName)) {
      _ddem = value;
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
    /* Parametri della funzione */
    /* pString Char(100) // Stringa da modificare */
    /* pChar Char(1) // Carattere Sostitutivo */
    /* _ldem Numeric(10, 0) */
    /* _ldem2 Numeric(10, 0) */
    /* _i Numeric(10, 0) */
    /* _strdem Char(100) */
    /* _strdem2 Char(100) */
    /* _cdem Char(1) */
    /* _ddem Char(1) */
    /* _adem Numeric(3, 0) */
    /* Ripulisce variabile e controlla lunghezza */
    /* _strdem := Upper(pString) */
    _strdem = CPLib.Upper(pString);
    /* _strdem2 := _strdem */
    _strdem2 = _strdem;
    /* _strdem := LRTrim(_strdem) */
    _strdem = CPLib.LRTrim(_strdem);
    /* _ldem := Len(LRTrim(_strdem)) */
    _ldem = CPLib.Round(CPLib.Len(CPLib.LRTrim(_strdem)),0);
    /* Cicla sulla stringa e controlla i caratteri */
    /* _i := 1 */
    _i = CPLib.Round(1,0);
    /* While _i <= _ldem */
    while (CPLib.le(_i,_ldem)) {
      /* _cdem := Substr(_strdem,_i,1) */
      _cdem = CPLib.Substr(_strdem,_i,1);
      /* _adem := Asc(_cdem) */
      _adem = CPLib.Round(CPLib.Asc(_cdem),0);
      /* _ddem := _cdem */
      _ddem = _cdem;
      /* Case _adem=34 */
      if (CPLib.eqr(_adem,34)) {
        /* _ddem := "&quot;" */
        _ddem = "&quot;";
        /* Case _adem=38 */
      } else if (CPLib.eqr(_adem,38)) {
        /* _ddem := "&amp;" */
        _ddem = "&amp;";
        /* Case _adem=60 */
      } else if (CPLib.eqr(_adem,60)) {
        /* _ddem := "&lt;" */
        _ddem = "&lt;";
        /* Case _adem=62 */
      } else if (CPLib.eqr(_adem,62)) {
        /* _ddem := "&gt;" */
        _ddem = "&gt;";
      } else { // Otherwise
        /* _ddem := _cdem */
        _ddem = _cdem;
      } // End Case
      /* If _cdem <> _ddem */
      if (CPLib.ne(_cdem,_ddem)) {
        /* _strdem2 := Strtran(_strdem2,_cdem,_ddem) */
        _strdem2 = CPLib.Strtran(_strdem2,_cdem,_ddem);
        /* _strdem := Strtran(_strdem,_cdem,Space(1)) */
        _strdem = CPLib.Strtran(_strdem,_cdem,CPLib.Space(1));
      } // End If
      /* _i := _i + 1 */
      _i = CPLib.Round(_i+1,0);
    } // End While
    /* _strdem2 := Strtran(_strdem2,Space(4),Space(1)) */
    _strdem2 = CPLib.Strtran(_strdem2,CPLib.Space(4),CPLib.Space(1));
    /* _strdem2 := Strtran(_strdem2,Space(3),Space(1)) */
    _strdem2 = CPLib.Strtran(_strdem2,CPLib.Space(3),CPLib.Space(1));
    /* _strdem2 := Strtran(_strdem2,Space(2),Space(1)) */
    _strdem2 = CPLib.Strtran(_strdem2,CPLib.Space(2),CPLib.Space(1));
    /* Return LRTrim(_strdem2) */
    throw new Stop(CPLib.LRTrim(_strdem2));
  }
  void _init_() {
  }
  public String RunAsync(String p_pString,String p_pChar) {
    pString = p_pString;
    pChar = p_pChar;
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
  public String Run(String p_pString,String p_pChar) {
    pString = p_pString;
    pChar = p_pChar;
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
  public static arfn_oamcharR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_oamcharR(p_Ctx, p_Caller);
  }
  public static arfn_oamcharR Make(CPContext p_Ctx) {
    return new arfn_oamcharR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pString = CPLib.Space(100);
    pChar = CPLib.Space(1);
    _ldem = 0;
    _ldem2 = 0;
    _i = 0;
    _strdem = CPLib.Space(100);
    _strdem2 = CPLib.Space(100);
    _cdem = CPLib.Space(1);
    _ddem = CPLib.Space(1);
    _adem = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_oamchar,
  public static final String i_InvokedRoutines = ",arfn_oamchar,";
  public static String[] m_cRunParameterNames={"pString","pChar"};
}
