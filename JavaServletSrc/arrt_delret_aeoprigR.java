// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_delret_aeoprigR implements CallerWithObjs {
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
  public String m_cPhName_aecanc;
  public String m_cServer_aecanc;
  public String m_cPhName_aestor;
  public String m_cServer_aestor;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
  public String m_cPhName_aeopstor;
  public String m_cServer_aeopstor;
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
  public String pTipo;
  public String w_IDBASE;
  public String w_CONNESINT;
  public java.sql.Date w_ADATARET;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_delret_aeoprigR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_delret_aeoprig",m_Caller);
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    if (m_cPhName_aecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aecanc = m_cPhName_aecanc+" "+m_Ctx.GetWritePhName("aecanc");
    }
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
    m_cPhName_aestor = p_ContextObject.GetPhName("aestor");
    if (m_cPhName_aestor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aestor = m_cPhName_aestor+" "+m_Ctx.GetWritePhName("aestor");
    }
    m_cServer_aestor = p_ContextObject.GetServer("aestor");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    if (m_cPhName_aeopcanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopcanc = m_cPhName_aeopcanc+" "+m_Ctx.GetWritePhName("aeopcanc");
    }
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
    m_cPhName_aeopstor = p_ContextObject.GetPhName("aeopstor");
    if (m_cPhName_aeopstor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopstor = m_cPhName_aeopstor+" "+m_Ctx.GetWritePhName("aeopstor");
    }
    m_cServer_aeopstor = p_ContextObject.GetServer("aeopstor");
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
      return "arrt_delret_aeoprig";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      return w_IDBASE;
    }
    if (CPLib.eqr("CONNESINT",p_cVarName)) {
      return w_CONNESINT;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("ADATARET",p_cVarName)) {
      return w_ADATARET;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      w_IDBASE = value;
      return;
    }
    if (CPLib.eqr("CONNESINT",p_cVarName)) {
      w_CONNESINT = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("ADATARET",p_cVarName)) {
      w_ADATARET = value;
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
    /* pTipo Char(1) */
    /* w_IDBASE Char(10) */
    /* w_CONNESINT Char(16) */
    /* w_ADATARET Date */
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry00000008status;
    nTry00000008status = m_Sql.GetTransactionStatus();
    String cTry00000008msg;
    cTry00000008msg = m_Sql.TransactionErrorMessage();
    try {
      /* If pTipo='R' */
      if (CPLib.eqr(pTipo,"R")) {
        /* w_ADATARET := NullDate() */
        w_ADATARET = CPLib.NullDate();
        // * --- Write into aeoprig from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aeoprig");
        m_cPhName = m_Ctx.GetPhName("aeoprig");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_delret_aeoprig",6,"0000000B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
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
        // * --- Delete from aeopstor
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aeopstor");
        m_cPhName = m_Ctx.GetPhName("aeopstor");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeopstor",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_delret_aeoprig",6,"0000000C")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        /* ElseIf pTipo='D' */
      } else if (CPLib.eqr(pTipo,"D")) {
        // * --- Delete from aeopcanc
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aeopcanc");
        m_cPhName = m_Ctx.GetPhName("aeopcanc");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeopcanc",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_delret_aeoprig",6,"0000000D")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        // * --- Delete from aeopstor
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aeopstor");
        m_cPhName = m_Ctx.GetPhName("aeopstor");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeopstor",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_delret_aeoprig",6,"0000000E")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      } // End If
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
  }
  void _init_() {
  }
  public String RunAsync(String p_pTipo) {
    pTipo = p_pTipo;
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
  public Forward Run(String p_pTipo) {
    pTipo = p_pTipo;
    return Run();
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
      m_Caller.SetString("CONNESINT","C",16,0,w_CONNESINT);
      m_Caller.SetDate("ADATARET","D",8,0,w_ADATARET);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_delret_aeoprigR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_delret_aeoprigR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    w_IDBASE = m_Caller.GetString("IDBASE","C",10,0);
    w_CONNESINT = m_Caller.GetString("CONNESINT","C",16,0);
    w_ADATARET = m_Caller.GetDate("ADATARET","D",8,0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pTipo"};
}
