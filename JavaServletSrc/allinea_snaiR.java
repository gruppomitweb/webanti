// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class allinea_snaiR implements CallerWithObjs {
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
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_cgo_operazioni_storico;
  public String m_cServer_cgo_operazioni_storico;
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
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public allinea_snaiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("allinea_snai",m_Caller);
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
      return "allinea_snai";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_docall",p_cVarName)) {
      return _docall;
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
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
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
    CPResultSet Cursor_cgo_operazioni_storico=null;
    try {
      /* _docall Char(1) */
      /* _deleted Numeric(10, 0) */
      /* _read Numeric(10, 0) */
      /* Verifica se esiste il nome file nella lista */
      /* _deleted := 0 */
      _deleted = CPLib.Round(0,0);
      /* _read := 0 */
      _read = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000008status;
      nTry00000008status = m_Sql.GetTransactionStatus();
      String cTry00000008msg;
      cTry00000008msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from cgo_operazioni_storico
        m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
        m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
        if (Cursor_cgo_operazioni_storico!=null)
          Cursor_cgo_operazioni_storico.Close();
        Cursor_cgo_operazioni_storico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select SNAINUMOPE,IDDOCALL,TIPOGIOCO,TOTLIRE,TOTCONT,FLGDOCALL  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"FLGDOCALL='N' "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_storico")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_operazioni_storico.Eof())) {
          /* _read := _read + 1 */
          _read = CPLib.Round(_read+1,0);
          /* _docall := arfn_cgo_chkdocs(cgo_operazioni_storico->IDDOCALL,cgo_operazioni_storico->TIPOGIOCO,cgo_operazioni_storico->TOTLIRE,cgo_operazioni_storico->TOTCONT,cgo_operazioni_storico->FLGDOCALL) */
          _docall = arfn_cgo_chkdocsR.Make(m_Ctx,this).Run(Cursor_cgo_operazioni_storico.GetString("IDDOCALL"),Cursor_cgo_operazioni_storico.GetString("TIPOGIOCO"),Cursor_cgo_operazioni_storico.GetDouble("TOTLIRE"),Cursor_cgo_operazioni_storico.GetDouble("TOTCONT"),Cursor_cgo_operazioni_storico.GetString("FLGDOCALL"));
          /* If _docall <> cgo_operazioni_storico->FLGDOCALL */
          if (CPLib.ne(_docall,Cursor_cgo_operazioni_storico.GetString("FLGDOCALL"))) {
            // * --- Write into cgo_operazioni_storico from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_storico",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("allinea_snai",18,"0000000D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"FLGDOCALL = "+CPLib.ToSQL(_docall,"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni_storico",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni_storico.GetString("SNAINUMOPE"))+"";
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
            /* _deleted := _deleted + 1 */
            _deleted = CPLib.Round(_deleted+1,0);
          } // End If
          Cursor_cgo_operazioni_storico.Next();
        }
        m_cConnectivityError = Cursor_cgo_operazioni_storico.ErrorMessage();
        Cursor_cgo_operazioni_storico.Close();
        // * --- End Select
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* Info Msg 'Sono state esaminate ' + LRTrim(Str(_read,10,0))+" operazioni." */
        if ( ! (CPLib.IsNull(m_Info))) {
          m_Info.log("Sono state esaminate "+CPLib.LRTrim(CPLib.Str(_read,10,0))+" operazioni.");
        }
        /* Info Msg 'Sono state aggiornate ' + LRTrim(Str(_deleted,10,0))+" operazioni." */
        if ( ! (CPLib.IsNull(m_Info))) {
          m_Info.log("Sono state aggiornate "+CPLib.LRTrim(CPLib.Str(_deleted,10,0))+" operazioni.");
        }
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000008status,0)) {
          m_Sql.SetTransactionStatus(nTry00000008status,cTry00000008msg);
        }
      }
    } finally {
      try {
        if (Cursor_cgo_operazioni_storico!=null)
          Cursor_cgo_operazioni_storico.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync() {
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
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
  public static allinea_snaiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new allinea_snaiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _docall = CPLib.Space(1);
    _deleted = 0;
    _read = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_cgo_chkdocs,
  public static final String i_InvokedRoutines = ",arfn_cgo_chkdocs,";
  public static String[] m_cRunParameterNames={};
}
