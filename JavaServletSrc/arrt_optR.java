// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_optR implements CallerWithObjs {
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
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  String m_cServer;
  String m_cPhName;
  CPPhTableWrInfo m_oWrInfo;
  String m_cQuery;
  String m_cQueryTable;
  String m_cSql;
  java.util.List<String> m_oParameters;
  String m_cWhere;
  int m_nUpdatedRows;
  // Contiene il messaggio di errore dell'ultima select terminata a causa della caduta della connessione
  String m_cConnectivityError;
  public double _contazi;
  public String _otp;
  public String _oldazi;
  public String _newazi;
  public String fhand;
  public String riga;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_optR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_opt",m_Caller);
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_contazi",p_cVarName)) {
      return _contazi;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_opt";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("_otp",p_cVarName)) {
      return _otp;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      return _oldazi;
    }
    if (CPLib.eqr("_newazi",p_cVarName)) {
      return _newazi;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
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
    if (CPLib.eqr("_contazi",p_cVarName)) {
      _contazi = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_otp",p_cVarName)) {
      _otp = value;
      return;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      _oldazi = value;
      return;
    }
    if (CPLib.eqr("_newazi",p_cVarName)) {
      _newazi = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
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
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_intermbo=null;
    try {
      /* _contazi Numeric(3, 0) := 0 */
      _contazi = CPLib.Round(0,0);
      /* _otp Char(1) := '' */
      _otp = "";
      /* _oldazi Char(10) := '' */
      _oldazi = "";
      /* _newazi Char(10) := '' */
      _newazi = "";
      /* fhand Char(0) */
      /* riga Char(0) */
      // * --- Select from cpazi
      m_cServer = m_Ctx.GetServer("cpazi");
      m_cPhName = m_Ctx.GetPhName("cpazi");
      if (Cursor_cpazi!=null)
        Cursor_cpazi.Close();
      Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select codazi  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cpazi.Eof())) {
        /* _contazi := _contazi + 1 */
        _contazi = CPLib.Round(_contazi+1,0);
        /* _newazi := cpazi->codazi */
        _newazi = Cursor_cpazi.GetString("codazi");
        Cursor_cpazi.Next();
      }
      m_cConnectivityError = Cursor_cpazi.ErrorMessage();
      Cursor_cpazi.Close();
      // * --- End Select
      /* If _contazi=1 */
      if (CPLib.eqr(_contazi,1)) {
        /* _oldazi := Utilities.GetCompany() */
        _oldazi = Utilities.Make(m_Ctx,m_Caller).GetCompany();
        /* Utilities.SetCompany(_newazi) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(_newazi);
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select FLGCGOOTP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* _otp := intermbo->FLGCGOOTP */
          _otp = Cursor_intermbo.GetString("FLGCGOOTP");
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* Utilities.SetCompany(_oldazi) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(_oldazi);
      } else { // Else
        /* fhand := FileLibMit.OpenRead("./conf.otp") */
        fhand = FileLibMit.OpenRead("./conf.otp");
        /* _otp := FileLibMit.ReadLine(fhand) */
        _otp = FileLibMit.ReadLine(fhand);
        // Chiude il file di configurazione
        FileLibMit.Close(fhand);
      } // End If
      /* CPSecurity.SetOTPisActive(iif(_otp='N',false,true)) */
      CPSecurity.SetOTPisActive((CPLib.eqr(_otp,"N")?false:true));
      /* Return _otp */
      throw new Stop(_otp);
    } finally {
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync() {
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
  public static arrt_optR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_optR(p_Ctx, p_Caller);
  }
  public static arrt_optR Make(CPContext p_Ctx) {
    return new arrt_optR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    _contazi = CPLib.Round(0,0);
    _otp = "";
    _oldazi = "";
    _newazi = "";
    fhand = CPLib.Space(0);
    riga = CPLib.Space(0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_opt,
  public static final String i_InvokedRoutines = ",arrt_opt,";
  public static String[] m_cRunParameterNames={};
}
