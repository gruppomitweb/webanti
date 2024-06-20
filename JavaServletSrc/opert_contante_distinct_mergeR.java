// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class opert_contante_distinct_mergeR implements CallerWithObjs {
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
  public String m_cPhName_ope_contante;
  public String m_cServer_ope_contante;
  public String m_cPhName_ope_contante_distinct;
  public String m_cServer_ope_contante_distinct;
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
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public opert_contante_distinct_mergeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("opert_contante_distinct_merge",m_Caller);
    m_cPhName_ope_contante = p_ContextObject.GetPhName("ope_contante");
    if (m_cPhName_ope_contante.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_ope_contante = m_cPhName_ope_contante+" "+m_Ctx.GetWritePhName("ope_contante");
    }
    m_cServer_ope_contante = p_ContextObject.GetServer("ope_contante");
    m_cPhName_ope_contante_distinct = p_ContextObject.GetPhName("ope_contante_distinct");
    if (m_cPhName_ope_contante_distinct.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_ope_contante_distinct = m_cPhName_ope_contante_distinct+" "+m_Ctx.GetWritePhName("ope_contante_distinct");
    }
    m_cServer_ope_contante_distinct = p_ContextObject.GetServer("ope_contante_distinct");
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
      return "opert_contante_distinct_merge";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
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
    VQRHolder l_VQRHolder = null;
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry00000002status;
    nTry00000002status = m_Sql.GetTransactionStatus();
    String cTry00000002msg;
    cTry00000002msg = m_Sql.TransactionErrorMessage();
    try {
      // * --- Write into ope_contante from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("ope_contante");
      m_cPhName = m_Ctx.GetPhName("ope_contante");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"ope_contante",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("opert_contante_distinct_merge",17,"00000003")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"TIPOATTIV = "+CPLib.ToSQL("SP","C",2,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"ope_contante",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"TAGLIO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(9999,"?",0,0,m_cServer),m_cServer,9999)+"";
      m_cSql = m_cSql+" and TIPOATTIV = "+CPSql.SQLValueAdapter(CPLib.ToSQL("CD","?",0,0,m_cServer),m_cServer,"CD")+"";
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
      // * --- Merge into ope_contante_distinct from query
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("ope_contante_distinct");
      m_cPhName = m_Ctx.GetPhName("ope_contante_distinct");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"ope_contante_distinct",m_Ctx.GetCompany());
      try {
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        CPSql.MultipleStringValues l_InsertList = CPSql.NewMultipleStringValues(m_oParameters,"cptmp_1xab23.IDOPE ","cptmp_1xab23.BILLSRIT ","cptmp_1xab23.BILLSSOV ","cptmp_1xab23.TIPATT ","cptmp_1xab23.TIPOATTIV ","cptmp_1xab23.CODICEGLN ","cptmp_1xab23.ABIINTER ","cptmp_1xab23.ABIPROPR ","cptmp_1xab23.GLNALTROSOG ","cptmp_1xab23.GLNALTRASC ","cptmp_1xab23.CODCLICON ","cptmp_1xab23.CODCOMCON ","cptmp_1xab23.ATECO_CON ","cptmp_1xab23.CODDIPE ");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        CPSql.MultipleStringValues l_UpdateList = CPSql.NewMultipleStringValues(m_oParameters,"cptmp_1xab23.BILLSRIT ","cptmp_1xab23.BILLSSOV ","cptmp_1xab23.TIPATT ","cptmp_1xab23.TIPOATTIV ","cptmp_1xab23.CODICEGLN ","cptmp_1xab23.ABIINTER ","cptmp_1xab23.ABIPROPR ","cptmp_1xab23.GLNALTROSOG ","cptmp_1xab23.GLNALTRASC ","cptmp_1xab23.CODCLICON ","cptmp_1xab23.CODCOMCON ","cptmp_1xab23.ATECO_CON ","cptmp_1xab23.CODDIPE ");
        m_nUpdatedRows = m_Sql.MergeFromSql(CPLib.GetSQLPrefixComment("opert_contante_distinct_merge",17,"00000004"),"ope_contante_distinct",CPSql.GetSqlPhraseDescriptor("qbe_ope_contante_distinct",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this),CPSql.NewMultipleStringValues("IDOPE"),CPSql.NewMultipleStringValues("IDOPE","BILLSRIT","BILLSSOV","TIPATT","TIPOATTIV","CODICEGLN","ABIINTER","ABIPROPR","GLNALTROSOG","GLNALTRASC","CODCLICON","CODCOMCON","ATECO_CON","CODDIPE"),l_InsertList,CPSql.NewMultipleStringValues("BILLSRIT","BILLSSOV","TIPATT","TIPOATTIV","CODICEGLN","ABIINTER","ABIPROPR","GLNALTROSOG","GLNALTRASC","CODCLICON","CODCOMCON","ATECO_CON","CODDIPE"),CPSql.NewMultipleStringValues("=","=","=","=","=","=","=","=","=","=","=","=","="),l_UpdateList,m_Ctx,m_oWrInfo);
      } finally {
        if (l_VQRHolder!=null)
          l_VQRHolder.DropTempTables(m_Ctx);
      }
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
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000002status,0)) {
        m_Sql.SetTransactionStatus(nTry00000002status,cTry00000002msg);
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
  public static opert_contante_distinct_mergeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new opert_contante_distinct_mergeR(p_Ctx, p_Caller);
  }
  public void Blank() {
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_ope_contante_distinct,
  public static final String m_cVQRList = ",qbe_ope_contante_distinct,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
