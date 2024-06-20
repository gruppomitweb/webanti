// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_agecharR implements CallerWithObjs {
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
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_agecharR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_agechar",m_Caller);
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
      return "arfn_agechar";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pString",p_cVarName)) {
      return pString;
    }
    if (CPLib.eqr("pChar",p_cVarName)) {
      return pChar;
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
    if (CPLib.eqr("pString",p_cVarName)) {
      pString = value;
      return;
    }
    if (CPLib.eqr("pChar",p_cVarName)) {
      pChar = value;
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
    double _ldem;
    _ldem = 0;
    /* _ldem2 Numeric(10, 0) */
    double _ldem2;
    _ldem2 = 0;
    /* _i Numeric(10, 0) */
    double _i;
    _i = 0;
    /* _strdem Char(100) */
    String _strdem;
    _strdem = CPLib.Space(100);
    /* _strdem2 Char(100) */
    String _strdem2;
    _strdem2 = CPLib.Space(100);
    /* _cdem Char(1) */
    String _cdem;
    _cdem = CPLib.Space(1);
    /* _ddem Char(1) */
    String _ddem;
    _ddem = CPLib.Space(1);
    /* _adem Numeric(3, 0) */
    double _adem;
    _adem = 0;
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
      /* Case _adem=9 */
      if (CPLib.eqr(_adem,9)) {
        /* _ddem := pChar */
        _ddem = pChar;
        /* Case _adem < 32 or _adem=141 or _adem=143 or _adem=144 or _adem=157 */
      } else if (CPLib.lt(_adem,32) || CPLib.eqr(_adem,141) || CPLib.eqr(_adem,143) || CPLib.eqr(_adem,144) || CPLib.eqr(_adem,157)) {
        /* _ddem := "" */
        _ddem = "";
        /* Case (_adem >= 192 and _adem <= 197) or (_adem >= 224 and _adem <= 229) or _adem=64 */
      } else if ((CPLib.ge(_adem,192) && CPLib.le(_adem,197)) || (CPLib.ge(_adem,224) && CPLib.le(_adem,229)) || CPLib.eqr(_adem,64)) {
        /* _ddem := 'A' */
        _ddem = "A";
        /* Case _adem=162 or _adem=169 or _adem=199 */
      } else if (CPLib.eqr(_adem,162) || CPLib.eqr(_adem,169) || CPLib.eqr(_adem,199)) {
        /* _ddem := 'C' */
        _ddem = "C";
        /* Case (_adem >= 200 and _adem <= 203) or (_adem >= 232 and _adem <= 235) or _adem=38 or _adem=128 or _adem=230 or _adem=198 */
      } else if ((CPLib.ge(_adem,200) && CPLib.le(_adem,203)) || (CPLib.ge(_adem,232) && CPLib.le(_adem,235)) || CPLib.eqr(_adem,38) || CPLib.eqr(_adem,128) || CPLib.eqr(_adem,230) || CPLib.eqr(_adem,198)) {
        /* _ddem := 'E' */
        _ddem = "E";
        /* Case (_adem >= 204 and _adem <= 207) or (_adem >= 236 and _adem <= 239)  */
      } else if ((CPLib.ge(_adem,204) && CPLib.le(_adem,207)) || (CPLib.ge(_adem,236) && CPLib.le(_adem,239))) {
        /* _ddem := 'I' */
        _ddem = "I";
        /* Case _adem=163 */
      } else if (CPLib.eqr(_adem,163)) {
        /* _ddem := 'L' */
        _ddem = "L";
        /* Case _adem=181 */
      } else if (CPLib.eqr(_adem,181)) {
        /* _ddem := 'M' */
        _ddem = "M";
        /* Case _adem=209 or _adem=241 */
      } else if (CPLib.eqr(_adem,209) || CPLib.eqr(_adem,241)) {
        /* _ddem := 'N' */
        _ddem = "N";
        /* Case (_adem >= 210 and _adem <= 214) or (_adem >= 242 and _adem <= 246) or _adem=216 or _adem=248 */
      } else if ((CPLib.ge(_adem,210) && CPLib.le(_adem,214)) || (CPLib.ge(_adem,242) && CPLib.le(_adem,246)) || CPLib.eqr(_adem,216) || CPLib.eqr(_adem,248)) {
        /* _ddem := 'O' */
        _ddem = "O";
        /* Case _adem=138 or _adem=154 or _adem=223 or _adem=231 */
      } else if (CPLib.eqr(_adem,138) || CPLib.eqr(_adem,154) || CPLib.eqr(_adem,223) || CPLib.eqr(_adem,231)) {
        /* _ddem := 'S' */
        _ddem = "S";
        /* Case (_adem >= 217 and _adem <= 220) or (_adem >= 249 and _adem <= 252)  */
      } else if ((CPLib.ge(_adem,217) && CPLib.le(_adem,220)) || (CPLib.ge(_adem,249) && CPLib.le(_adem,252))) {
        /* _ddem := 'U' */
        _ddem = "U";
        /* Case _adem=159 or _adem=165 or _adem=221 or _adem=253 or _adem=255 */
      } else if (CPLib.eqr(_adem,159) || CPLib.eqr(_adem,165) || CPLib.eqr(_adem,221) || CPLib.eqr(_adem,253) || CPLib.eqr(_adem,255)) {
        /* _ddem := 'Y' */
        _ddem = "Y";
        /* Case _adem=142 or _adem=158 */
      } else if (CPLib.eqr(_adem,142) || CPLib.eqr(_adem,158)) {
        /* _ddem := 'Z' */
        _ddem = "Z";
        /* Case (not( _adem >= 48 and _adem <= 57) and not(_adem >= 65 and _adem <= 90) and _adem <> 32 and _adem <> 95 and _adem <> 39 and _adem<>45) */
      } else if (( ! (CPLib.ge(_adem,48) && CPLib.le(_adem,57)) &&  ! (CPLib.ge(_adem,65) && CPLib.le(_adem,90)) && CPLib.ne(_adem,32) && CPLib.ne(_adem,95) && CPLib.ne(_adem,39) && CPLib.ne(_adem,45))) {
        /* _ddem := pChar */
        _ddem = pChar;
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
  public static arfn_agecharR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_agecharR(p_Ctx, p_Caller);
  }
  public static arfn_agecharR Make(CPContext p_Ctx) {
    return new arfn_agecharR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pString = CPLib.Space(100);
    pChar = CPLib.Space(1);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_agechar,
  public static final String i_InvokedRoutines = ",arfn_agechar,";
  public static String[] m_cRunParameterNames={"pString","pChar"};
}
