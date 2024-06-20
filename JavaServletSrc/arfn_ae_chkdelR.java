// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_ae_chkdelR implements CallerWithObjs {
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
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
  public String m_cPhName_aedecanc;
  public String m_cServer_aedecanc;
  public String m_cPhName_aecanc;
  public String m_cServer_aecanc;
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
  public String pIDB;
  public String pTipo;
  public boolean _Ritorno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_ae_chkdelR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_ae_chkdel",m_Caller);
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    if (m_cPhName_aeopcanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopcanc = m_cPhName_aeopcanc+" "+m_Ctx.GetWritePhName("aeopcanc");
    }
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
    m_cPhName_aedecanc = p_ContextObject.GetPhName("aedecanc");
    if (m_cPhName_aedecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aedecanc = m_cPhName_aedecanc+" "+m_Ctx.GetWritePhName("aedecanc");
    }
    m_cServer_aedecanc = p_ContextObject.GetServer("aedecanc");
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    if (m_cPhName_aecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aecanc = m_cPhName_aecanc+" "+m_Ctx.GetWritePhName("aecanc");
    }
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
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
      return "arfn_ae_chkdel";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pIDB",p_cVarName)) {
      return pIDB;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
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
    if (CPLib.eqr("_Ritorno",p_cVarName)) {
      return _Ritorno;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pIDB",p_cVarName)) {
      pIDB = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("_Ritorno",p_cVarName)) {
      _Ritorno = value;
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
    CPResultSet Cursor_aecanc=null;
    CPResultSet Cursor_aedecanc=null;
    CPResultSet Cursor_aeopcanc=null;
    try {
      /* pIDB Char(10) // IDBASE */
      /* pTipo Char(1) // Archivio */
      /* _Ritorno Bool */
      /* _Ritorno := True */
      _Ritorno = true;
      /* Case pTipo='R' */
      if (CPLib.eqr(pTipo,"R")) {
        // * --- Select from aecanc
        m_cServer = m_Ctx.GetServer("aecanc");
        m_cPhName = m_Ctx.GetPhName("aecanc");
        if (Cursor_aecanc!=null)
          Cursor_aecanc.Close();
        Cursor_aecanc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select PROGRES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDB,"?",0,0,m_cServer, m_oParameters),m_cServer,pIDB)+" "+")"+(m_Ctx.IsSharedTemp("aecanc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aecanc.Eof())) {
          /* _Ritorno := False */
          _Ritorno = false;
          Cursor_aecanc.Next();
        }
        m_cConnectivityError = Cursor_aecanc.ErrorMessage();
        Cursor_aecanc.Close();
        // * --- End Select
        /* Case pTipo='D' */
      } else if (CPLib.eqr(pTipo,"D")) {
        // * --- Select from aedecanc
        m_cServer = m_Ctx.GetServer("aedecanc");
        m_cPhName = m_Ctx.GetPhName("aedecanc");
        if (Cursor_aedecanc!=null)
          Cursor_aedecanc.Close();
        Cursor_aedecanc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select PROGRES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDB,"?",0,0,m_cServer, m_oParameters),m_cServer,pIDB)+" "+")"+(m_Ctx.IsSharedTemp("aedecanc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aedecanc.Eof())) {
          /* _Ritorno := False */
          _Ritorno = false;
          Cursor_aedecanc.Next();
        }
        m_cConnectivityError = Cursor_aedecanc.ErrorMessage();
        Cursor_aedecanc.Close();
        // * --- End Select
        /* Case pTipo='O' */
      } else if (CPLib.eqr(pTipo,"O")) {
        // * --- Select from aeopcanc
        m_cServer = m_Ctx.GetServer("aeopcanc");
        m_cPhName = m_Ctx.GetPhName("aeopcanc");
        if (Cursor_aeopcanc!=null)
          Cursor_aeopcanc.Close();
        Cursor_aeopcanc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select PROGRES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDB,"?",0,0,m_cServer, m_oParameters),m_cServer,pIDB)+" "+")"+(m_Ctx.IsSharedTemp("aeopcanc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aeopcanc.Eof())) {
          /* _Ritorno := False */
          _Ritorno = false;
          Cursor_aeopcanc.Next();
        }
        m_cConnectivityError = Cursor_aeopcanc.ErrorMessage();
        Cursor_aeopcanc.Close();
        // * --- End Select
      } // End Case
      /* Return _Ritorno */
      throw new Stop(_Ritorno);
    } finally {
      try {
        if (Cursor_aecanc!=null)
          Cursor_aecanc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aedecanc!=null)
          Cursor_aedecanc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeopcanc!=null)
          Cursor_aeopcanc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pIDB,String p_pTipo) {
    pIDB = p_pIDB;
    pTipo = p_pTipo;
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
  public boolean Run(String p_pIDB,String p_pTipo) {
    pIDB = p_pIDB;
    pTipo = p_pTipo;
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
  public static arfn_ae_chkdelR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_ae_chkdelR(p_Ctx, p_Caller);
  }
  public static arfn_ae_chkdelR Make(CPContext p_Ctx) {
    return new arfn_ae_chkdelR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pIDB = CPLib.Space(10);
    pTipo = CPLib.Space(1);
    _Ritorno = false;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_ae_chkdel,
  public static final String i_InvokedRoutines = ",arfn_ae_chkdel,";
  public static String[] m_cRunParameterNames={"pIDB","pTipo"};
}
