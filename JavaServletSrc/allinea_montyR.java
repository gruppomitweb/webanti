// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class allinea_montyR implements CallerWithObjs {
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
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_cgo_operazioni_storico;
  public String m_cServer_cgo_operazioni_storico;
  public String m_cPhName_f_opextrbo;
  public String m_cServer_f_opextrbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
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
  public String _docall;
  public double _deleted;
  public double _read;
  public String gAzienda;
  public String gPathApp;
  public String filename;
  public String fhand;
  public String _riga;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public allinea_montyR (CPContext p_ContextObject, Caller caller) {
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
                                all'oggetto globale (unico per pi� istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda � contenuta nel global object.
                             */
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("allinea_monty",m_Caller);
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_cgo_operazioni_storico = p_ContextObject.GetPhName("cgo_operazioni_storico");
    if (m_cPhName_cgo_operazioni_storico.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_storico = m_cPhName_cgo_operazioni_storico+" "+m_Ctx.GetWritePhName("cgo_operazioni_storico");
    }
    m_cServer_cgo_operazioni_storico = p_ContextObject.GetServer("cgo_operazioni_storico");
    m_cPhName_f_opextrbo = p_ContextObject.GetPhName("f_opextrbo");
    if (m_cPhName_f_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_opextrbo = m_cPhName_f_opextrbo+" "+m_Ctx.GetWritePhName("f_opextrbo");
    }
    m_cServer_f_opextrbo = p_ContextObject.GetServer("f_opextrbo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_deleted",p_cVarName)) {
      return _deleted;
    }
    if (CPLib.eqr("_read",p_cVarName)) {
      return _read;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "allinea_monty";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_docall",p_cVarName)) {
      return _docall;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      return filename;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
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
    if (CPLib.eqr("_deleted",p_cVarName)) {
      _deleted = value;
      return;
    }
    if (CPLib.eqr("_read",p_cVarName)) {
      _read = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_docall",p_cVarName)) {
      _docall = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      filename = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      _riga = value;
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
    /* _docall Char(1) */
    /* _deleted Numeric(10, 0) */
    /* _read Numeric(10, 0) */
    /* gAzienda Char(10) // Azienda */
    /* gPathApp Char(80) // Path Applicazione */
    /* filename Char(80) */
    /* fhand Char(10) */
    /* _riga Char(100) */
    /* Verifica se esiste il nome file nella lista */
    /* _deleted := 0 */
    _deleted = CPLib.Round(0,0);
    /* _read := 0 */
    _read = CPLib.Round(0,0);
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry0000000Dstatus;
    nTry0000000Dstatus = m_Sql.GetTransactionStatus();
    String cTry0000000Dmsg;
    cTry0000000Dmsg = m_Sql.TransactionErrorMessage();
    try {
      /* filename := "appo/"+LRTrim(gAzienda)+"/monty.csv" */
      filename = "appo/"+CPLib.LRTrim(gAzienda)+"/monty.csv";
      /* fhand := FileLibMit.OpenRead(LRTrim(filename)) */
      fhand = FileLibMit.OpenRead(CPLib.LRTrim(filename));
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* _riga := FileLibMit.ReadLine(fhand) */
        _riga = FileLibMit.ReadLine(fhand);
        // * --- Write into opextrbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("opextrbo");
        m_cPhName = m_Ctx.GetPhName("opextrbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("allinea_monty",27,"00000012")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL("2020_"+CPLib.LRTrim(CPLib.Substr(_riga,11,10)),"C",25,0,m_cServer)+", ";
        m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL("08986940966_2020_"+CPLib.LRTrim(CPLib.Substr(_riga,11,10)),"C",50,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(_riga,10)),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(CPLib.Left(_riga,10)))+"";
        m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL("2020","?",0,0,m_cServer),m_cServer,"2020")+"";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter();
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
      } // End While
      // Commit
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      m_Sql.CompleteTransaction();
    } catch(Exception l_exeption) {
      Stop.ReactToException(l_exeption);
      // Rollback
      m_Sql.AbortTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      m_bError = true;
      m_Sql.CompleteTransaction();
    } finally {
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000000Dstatus,0)) {
        m_Sql.SetTransactionStatus(nTry0000000Dstatus,cTry0000000Dmsg);
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
          p_oResult.m_oResult=Run();
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
  public Forward Run() {
    Forward f;
    f = Forward.Unforwarded;
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
      } catch(Forward forward) {
        f=forward;
      } catch(Stop stop_value) {
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
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
    return f;
  }
  public static allinea_montyR Make(CPContext p_Ctx, Caller p_Caller) {
    return new allinea_montyR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _docall = CPLib.Space(1);
    _deleted = 0;
    _read = 0;
    filename = CPLib.Space(80);
    fhand = CPLib.Space(10);
    _riga = CPLib.Space(100);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
