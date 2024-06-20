// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_chkdatdocR implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
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
  public String pCli;
  public java.sql.Date pOpe;
  public java.sql.Date _datini;
  public java.sql.Date _datend;
  public boolean bRet;
  public String _sesso;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_chkdatdocR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_chkdatdoc",m_Caller);
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
      return "arfn_chkdatdoc";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pCli",p_cVarName)) {
      return pCli;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      return _sesso;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pOpe",p_cVarName)) {
      return pOpe;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datend",p_cVarName)) {
      return _datend;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("bRet",p_cVarName)) {
      return bRet;
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
    if (CPLib.eqr("pCli",p_cVarName)) {
      pCli = value;
      return;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      _sesso = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pOpe",p_cVarName)) {
      pOpe = value;
      return;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_datend",p_cVarName)) {
      _datend = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bRet",p_cVarName)) {
      bRet = value;
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
    CPResultSet Read_Cursor=null;
    try {
      /* Parametri */
      /* pCli Char(16) // Codice Cliente */
      /* pOpe Date // Data operazione */
      /* variabili Locali */
      /* _datini Date */
      /* _datend Date */
      /* bRet Bool */
      /* _sesso Char(1) */
      /* Legge i dati del cliente */
      /* _sesso := '' */
      _sesso = "";
      // * --- Read from personbo
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      m_cSql = "";
      m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCli,"C",16,0,m_cServer),m_cServer,pCli);
      if (m_Ctx.IsSharedTemp("personbo")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DATARILASC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATAVALI",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SESSO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _datini = Read_Cursor.GetDate("DATARILASC");
        _datend = Read_Cursor.GetDate("DATAVALI");
        _sesso = Read_Cursor.GetString("SESSO");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on personbo into routine arfn_chkdatdoc returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _datini = CPLib.NullDate();
        _datend = CPLib.NullDate();
        _sesso = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* bRet := True */
      bRet = true;
      /* If not(Empty(_sesso)) */
      if ( ! (CPLib.Empty(_sesso))) {
        /* If not(Empty(_datini)) */
        if ( ! (CPLib.Empty(_datini))) {
          /* If _datini > pOpe */
          if (CPLib.gt(_datini,pOpe)) {
            /* bRet := False */
            bRet = false;
            /* Error Msg "Attenzione! Data di rilascio documento successiva all'operazione. E' necessario inserire gli estremi di un nuovo documento." */
            m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"Attenzione! Data di rilascio documento successiva all'operazione. E' necessario inserire gli estremi di un nuovo documento.");
            new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
          } // End If
        } // End If
        /* If bRet */
        if (bRet) {
          /* If not(Empty(_datend)) */
          if ( ! (CPLib.Empty(_datend))) {
            /* If _datend < pOpe */
            if (CPLib.lt(_datend,pOpe)) {
              /* bRet := False */
              bRet = false;
              /* Error Msg "Attenzione! Documento scaduto. E' necessario inserire gli estremi di un nuovo documento." */
              m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"Attenzione! Documento scaduto. E' necessario inserire gli estremi di un nuovo documento.");
              new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
            } // End If
          } // End If
        } // End If
      } // End If
      /* Return bRet */
      throw new Stop(bRet);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pCli,java.sql.Date p_pOpe) {
    pCli = p_pCli;
    pOpe = p_pOpe;
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
  public boolean Run(String p_pCli,java.sql.Date p_pOpe) {
    pCli = p_pCli;
    pOpe = p_pOpe;
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
  public static arfn_chkdatdocR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_chkdatdocR(p_Ctx, p_Caller);
  }
  public static arfn_chkdatdocR Make(CPContext p_Ctx) {
    return new arfn_chkdatdocR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pCli = CPLib.Space(16);
    pOpe = CPLib.NullDate();
    _datini = CPLib.NullDate();
    _datend = CPLib.NullDate();
    bRet = false;
    _sesso = CPLib.Space(1);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chkdatdoc,
  public static final String i_InvokedRoutines = ",arfn_chkdatdoc,";
  public static String[] m_cRunParameterNames={"pCli","pOpe"};
}
