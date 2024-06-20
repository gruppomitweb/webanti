// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_japotit_deleteR implements CallerWithObjs {
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
  public String m_cPhName_japotit;
  public String m_cServer_japotit;
  public String m_cPhName_jntestit;
  public String m_cServer_jntestit;
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
  public String w_IDBASE;
  public String w_NUMPROG;
  public double _fine;
  public String _tipooprap;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_japotit_deleteR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_japotit_delete",m_Caller);
    m_cPhName_japotit = p_ContextObject.GetPhName("japotit");
    if (m_cPhName_japotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japotit = m_cPhName_japotit+" "+m_Ctx.GetWritePhName("japotit");
    }
    m_cServer_japotit = p_ContextObject.GetServer("japotit");
    m_cPhName_jntestit = p_ContextObject.GetPhName("jntestit");
    if (m_cPhName_jntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestit = m_cPhName_jntestit+" "+m_Ctx.GetWritePhName("jntestit");
    }
    m_cServer_jntestit = p_ContextObject.GetServer("jntestit");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_fine",p_cVarName)) {
      return _fine;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_japotit_delete";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      return w_IDBASE;
    }
    if (CPLib.eqr("NUMPROG",p_cVarName)) {
      return w_NUMPROG;
    }
    if (CPLib.eqr("_tipooprap",p_cVarName)) {
      return _tipooprap;
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
    if (CPLib.eqr("_fine",p_cVarName)) {
      _fine = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      w_IDBASE = value;
      return;
    }
    if (CPLib.eqr("NUMPROG",p_cVarName)) {
      w_NUMPROG = value;
      return;
    }
    if (CPLib.eqr("_tipooprap",p_cVarName)) {
      _tipooprap = value;
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_jntestit=null;
    try {
      /* Variabili del caller */
      /* w_IDBASE Char(10) // Idbase */
      /* w_NUMPROG Char(11) */
      /* Variabili locali */
      /* _fine Numeric(1, 0) := 0 */
      _fine = CPLib.Round(0,0);
      /* _tipooprap Char(2) := '' */
      _tipooprap = "";
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000008status;
      nTry00000008status = m_Sql.GetTransactionStatus();
      String cTry00000008msg;
      cTry00000008msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Read from japotit
        m_cServer = m_Ctx.GetServer("japotit");
        m_cPhName = m_Ctx.GetPhName("japotit");
        m_cSql = "";
        m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0,m_cServer),m_cServer,w_IDBASE);
        if (m_Ctx.IsSharedTemp("japotit")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOOPRAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _tipooprap = Read_Cursor.GetString("TIPOOPRAP");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on japotit into routine arrt_japotit_delete returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _tipooprap = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If _tipooprap='50' */
        if (CPLib.eqr(_tipooprap,"50")) {
          // * --- Select from jntestit
          m_cServer = m_Ctx.GetServer("jntestit");
          m_cPhName = m_Ctx.GetPhName("jntestit");
          if (Cursor_jntestit!=null)
            Cursor_jntestit.Close();
          Cursor_jntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG1="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMPROG,"?",0,0,m_cServer, m_oParameters),m_cServer,w_NUMPROG)+" "+")"+(m_Ctx.IsSharedTemp("jntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_jntestit.Eof())) {
            /* If not(Empty(jntestit->DATAFINE)) */
            if ( ! (CPLib.Empty(Cursor_jntestit.GetDate("DATAFINE")))) {
              /* _fine := 1 */
              _fine = CPLib.Round(1,0);
            } // End If
            Cursor_jntestit.Next();
          }
          m_cConnectivityError = Cursor_jntestit.ErrorMessage();
          Cursor_jntestit.Close();
          // * --- End Select
          /* If _fine=1 */
          if (CPLib.eqr(_fine,1)) {
            // Transaction Error
            cTry00000008msg = CPLib.FormatMsg(m_Ctx,"Impossibile cancellare delle aperture con chiusure");
            m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Impossibile cancellare delle aperture con chiusure"));
          } else { // Else
            // * --- Delete from jntestit
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("jntestit");
            m_cPhName = m_Ctx.GetPhName("jntestit");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestit",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_japotit_delete",47,"00000010")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMPROG1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMPROG,"?",0,0,m_cServer),m_cServer,w_NUMPROG)+"";
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
          } // End If
          /* ElseIf _tipooprap='51' */
        } else if (CPLib.eqr(_tipooprap,"51")) {
          // * --- Write into jntestit from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("jntestit");
          m_cPhName = m_Ctx.GetPhName("jntestit");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestit",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_japotit_delete",47,"00000011")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
          m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(CPLib.NullString(),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestit",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"NUMPROG2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_NUMPROG,"?",0,0,m_cServer),m_cServer,w_NUMPROG)+"";
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
        } // End If
        // * --- Delete from japotit
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("japotit");
        m_cPhName = m_Ctx.GetPhName("japotit");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japotit",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_japotit_delete",47,"00000012")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"?",0,0,m_cServer),m_cServer,w_IDBASE)+"";
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000008status,0)) {
          m_Sql.SetTransactionStatus(nTry00000008status,cTry00000008msg);
        }
      }
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestit!=null)
          Cursor_jntestit.Close();
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
      m_Caller.SetString("IDBASE","C",10,0,w_IDBASE);
      m_Caller.SetString("NUMPROG","C",11,0,w_NUMPROG);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_japotit_deleteR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_japotit_deleteR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_IDBASE = m_Caller.GetString("IDBASE","C",10,0);
    w_NUMPROG = m_Caller.GetString("NUMPROG","C",11,0);
    _fine = CPLib.Round(0,0);
    _tipooprap = "";
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
