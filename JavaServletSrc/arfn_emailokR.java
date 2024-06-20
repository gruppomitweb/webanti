// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_emailokR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String pEmail;
  public String _v;
  public String _eml;
  public String _s;
  public boolean bRitorno;
  public String _err;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_emailokR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arfn_emailok",m_Caller);
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
      return "arfn_emailok";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pEmail",p_cVarName)) {
      return pEmail;
    }
    if (CPLib.eqr("_v",p_cVarName)) {
      return _v;
    }
    if (CPLib.eqr("_eml",p_cVarName)) {
      return _eml;
    }
    if (CPLib.eqr("_s",p_cVarName)) {
      return _s;
    }
    if (CPLib.eqr("_err",p_cVarName)) {
      return _err;
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
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pEmail",p_cVarName)) {
      pEmail = value;
      return;
    }
    if (CPLib.eqr("_v",p_cVarName)) {
      _v = value;
      return;
    }
    if (CPLib.eqr("_eml",p_cVarName)) {
      _eml = value;
      return;
    }
    if (CPLib.eqr("_s",p_cVarName)) {
      _s = value;
      return;
    }
    if (CPLib.eqr("_err",p_cVarName)) {
      _err = value;
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
    /* Campo Email */
    /* pEmail Char(100) */
    /* _v Char(100) */
    /* _eml Char(100) */
    /* _s Char(100) */
    /* bRitorno Bool */
    /* _err Memo */
    /* bRitorno := True */
    bRitorno = true;
    /* _v := LRTrim(pEmail) */
    _v = CPLib.LRTrim(pEmail);
    /* If not(Empty(_v)) */
    if ( ! (CPLib.Empty(_v))) {
      /* _v := LRTrim(pEmail)+";" */
      _v = CPLib.LRTrim(pEmail)+";";
      /* While At(";",_v) <> 0 */
      while (CPLib.ne(CPLib.At(";",_v),0)) {
        /* _eml := Left(_v,At(";",_v)-1) */
        _eml = CPLib.Left(_v,CPLib.At(";",_v)-1);
        /* _v := Substr(_v,At(";",_v)+1) */
        _v = CPLib.Substr(_v,CPLib.At(";",_v)+1);
        /* _s := Substr(_eml,At("@",_eml)+1) */
        _s = CPLib.Substr(_eml,CPLib.At("@",_eml)+1);
        /* Case At("@",_eml) = 0 and At(".",_eml) = 0 */
        if (CPLib.eqr(CPLib.At("@",_eml),0) && CPLib.eqr(CPLib.At(".",_eml),0)) {
          /* bRitorno := False */
          bRitorno = false;
          /* _err := _err + _eml+" - " */
          _err = _err+_eml+" - ";
          /* Case Len(LRTrim(_eml)) < 4 */
        } else if (CPLib.lt(CPLib.Len(CPLib.LRTrim(_eml)),4)) {
          /* bRitorno := False */
          bRitorno = false;
          /* _err := _err + _eml+" - " */
          _err = _err+_eml+" - ";
          /* Case Len(Left(_eml,At("@",_eml)-1))<2 */
        } else if (CPLib.lt(CPLib.Len(CPLib.Left(_eml,CPLib.At("@",_eml)-1)),2)) {
          /* bRitorno := False */
          bRitorno = false;
          /* _err := _err + _eml+" - " */
          _err = _err+_eml+" - ";
          /* Case Len(Substr(_eml,RAt(".",_eml)+1))<2 */
        } else if (CPLib.lt(CPLib.Len(CPLib.Substr(_eml,CPLib.RAt(".",_eml)+1)),2)) {
          /* bRitorno := False */
          bRitorno = false;
          /* _err := _err + _eml+" - " */
          _err = _err+_eml+" - ";
          /* Case Len(Left(_s,At(".",_s)-1))<2 */
        } else if (CPLib.lt(CPLib.Len(CPLib.Left(_s,CPLib.At(".",_s)-1)),2)) {
          /* bRitorno := False */
          bRitorno = false;
          /* _err := _err + _eml+" - " */
          _err = _err+_eml+" - ";
        } // End Case
      } // End While
    } // End If
    /* If not(bRitorno) */
    if ( ! (bRitorno)) {
      /* Error Msg 'I seguenti indirizzi non sono corretti: '+ Left(_err,Len(_err) - 3) */
      m_cLastMsgError = "I seguenti indirizzi non sono corretti: "+CPLib.Left(_err,CPLib.Len(_err)-3);
      new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
    } // End If
    /* Return bRitorno */
    throw new Stop(bRitorno);
  }
  void _init_() {
  }
  public String RunAsync(String p_pEmail) {
    pEmail = p_pEmail;
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
    );
  }
  public boolean Run(String p_pEmail) {
    pEmail = p_pEmail;
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
  public static arfn_emailokR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_emailokR(p_Ctx, p_Caller);
  }
  public static arfn_emailokR Make(CPContext p_Ctx) {
    return new arfn_emailokR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pEmail = CPLib.Space(100);
    _v = CPLib.Space(100);
    _eml = CPLib.Space(100);
    _s = CPLib.Space(100);
    bRitorno = false;
    _err = "";
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_emailok,
  public static final String i_InvokedRoutines = ",arfn_emailok,";
  public static String[] m_cRunParameterNames={"pEmail"};
}
