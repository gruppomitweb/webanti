// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class opert_chgpivaR implements CallerWithObjs {
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
  public String m_cPhName_scarti_import;
  public String m_cServer_scarti_import;
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
  public String pIVA1;
  public String pIVA2;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public opert_chgpivaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("opert_chgpiva",m_Caller);
    m_cPhName_scarti_import = p_ContextObject.GetPhName("scarti_import");
    if (m_cPhName_scarti_import.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_scarti_import = m_cPhName_scarti_import+" "+m_Ctx.GetWritePhName("scarti_import");
    }
    m_cServer_scarti_import = p_ContextObject.GetServer("scarti_import");
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
      return "opert_chgpiva";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pIVA1",p_cVarName)) {
      return pIVA1;
    }
    if (CPLib.eqr("pIVA2",p_cVarName)) {
      return pIVA2;
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
    if (CPLib.eqr("pIVA1",p_cVarName)) {
      pIVA1 = value;
      return;
    }
    if (CPLib.eqr("pIVA2",p_cVarName)) {
      pIVA2 = value;
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
    /* pIVA1 Char(11) */
    /* pIVA2 Char(11) */
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry00000006status;
    nTry00000006status = m_Sql.GetTransactionStatus();
    String cTry00000006msg;
    cTry00000006msg = m_Sql.TransactionErrorMessage();
    try {
      // * --- Write into scarti_import from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("scarti_import");
      m_cPhName = m_Ctx.GetPhName("scarti_import");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"scarti_import",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("opert_chgpiva",4,"00000007")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(pIVA2,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"scarti_import",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pIVA1,"?",0,0,m_cServer),m_cServer,pIVA1)+"";
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
      /* Exec Routine opert_imp_dati_soggetto(pIVA2) */
      opert_imp_dati_soggettoR.Make(m_Ctx,this).Run(pIVA2);
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
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000006status,0)) {
        m_Sql.SetTransactionStatus(nTry00000006status,cTry00000006msg);
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pIVA1,String p_pIVA2) {
    pIVA1 = p_pIVA1;
    pIVA2 = p_pIVA2;
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
  public String Run(String p_pIVA1,String p_pIVA2) {
    pIVA1 = p_pIVA1;
    pIVA2 = p_pIVA2;
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
  public static opert_chgpivaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new opert_chgpivaR(p_Ctx, p_Caller);
  }
  public static opert_chgpivaR Make(CPContext p_Ctx) {
    return new opert_chgpivaR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pIVA1 = CPLib.Space(11);
    pIVA2 = CPLib.Space(11);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,opert_chgpiva,opert_imp_dati_soggetto,
  public static final String i_InvokedRoutines = ",opert_chgpiva,opert_imp_dati_soggetto,";
  public static String[] m_cRunParameterNames={"pIVA1","pIVA2"};
}