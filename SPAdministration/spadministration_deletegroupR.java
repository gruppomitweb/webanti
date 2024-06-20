// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_deletegroupR implements CallerWithObjs {
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
  public String m_cPhName_cpgroups;
  public String m_cServer_cpgroups;
  public String m_cPhName_cpgrpgrp;
  public String m_cServer_cpgrpgrp;
  public String m_cPhName_cpprgsec;
  public String m_cServer_cpprgsec;
  public String m_cPhName_cpusrgrp;
  public String m_cServer_cpusrgrp;
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
  public double idfolder;
  public boolean d;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spadministration_deletegroupR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spadministration_deletegroup",m_Caller);
    m_cPhName_cpgroups = p_ContextObject.GetPhName("cpgroups");
    if (m_cPhName_cpgroups.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpgroups = m_cPhName_cpgroups+" "+m_Ctx.GetWritePhName("cpgroups");
    }
    m_cServer_cpgroups = p_ContextObject.GetServer("cpgroups");
    m_cPhName_cpgrpgrp = p_ContextObject.GetPhName("cpgrpgrp");
    if (m_cPhName_cpgrpgrp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpgrpgrp = m_cPhName_cpgrpgrp+" "+m_Ctx.GetWritePhName("cpgrpgrp");
    }
    m_cServer_cpgrpgrp = p_ContextObject.GetServer("cpgrpgrp");
    m_cPhName_cpprgsec = p_ContextObject.GetPhName("cpprgsec");
    if (m_cPhName_cpprgsec.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpprgsec = m_cPhName_cpprgsec+" "+m_Ctx.GetWritePhName("cpprgsec");
    }
    m_cServer_cpprgsec = p_ContextObject.GetServer("cpprgsec");
    m_cPhName_cpusrgrp = p_ContextObject.GetPhName("cpusrgrp");
    if (m_cPhName_cpusrgrp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusrgrp = m_cPhName_cpusrgrp+" "+m_Ctx.GetWritePhName("cpusrgrp");
    }
    m_cServer_cpusrgrp = p_ContextObject.GetServer("cpusrgrp");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("idfolder",p_cVarName)) {
      return idfolder;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "spadministration_deletegroup";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
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
    if (CPLib.eqr("d",p_cVarName)) {
      return d;
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
    if (CPLib.eqr("idfolder",p_cVarName)) {
      idfolder = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("d",p_cVarName)) {
      d = value;
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
    /* idfolder Numeric(4, 0) */
    /* d Bool */
    /* If UserAdmin.HasAdminRights() */
    if (UserAdmin.Make(m_Ctx).HasAdminRights()) {
      // * --- Delete from cpgrpgrp
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("cpgrpgrp");
      m_cPhName = m_Ctx.GetPhName("cpgrpgrp");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpgrpgrp",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("spadministration_deletegroup",23,"00000004")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"groupcode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idfolder,"?",0,0,m_cServer),m_cServer,idfolder)+"";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter();
      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
      if (CPLib.lt(m_nUpdatedRows,0)) {
        m_Sql.AbortTransaction();
      }
      m_Sql.CompleteTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      // * --- Delete from cpgrpgrp
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("cpgrpgrp");
      m_cPhName = m_Ctx.GetPhName("cpgrpgrp");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpgrpgrp",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("spadministration_deletegroup",23,"00000005")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"groupbase = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idfolder,"?",0,0,m_cServer),m_cServer,idfolder)+"";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter();
      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
      if (CPLib.lt(m_nUpdatedRows,0)) {
        m_Sql.AbortTransaction();
      }
      m_Sql.CompleteTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      // * --- Delete from cpprgsec
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("cpprgsec");
      m_cPhName = m_Ctx.GetPhName("cpprgsec");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpprgsec",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("spadministration_deletegroup",23,"00000006")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"grpcode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idfolder,"?",0,0,m_cServer),m_cServer,idfolder)+"";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter();
      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
      if (CPLib.lt(m_nUpdatedRows,0)) {
        m_Sql.AbortTransaction();
      }
      m_Sql.CompleteTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      // * --- Delete from cpusrgrp
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("cpusrgrp");
      m_cPhName = m_Ctx.GetPhName("cpusrgrp");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusrgrp",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("spadministration_deletegroup",23,"00000007")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"groupcode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idfolder,"?",0,0,m_cServer),m_cServer,idfolder)+"";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter();
      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
      if (CPLib.lt(m_nUpdatedRows,0)) {
        m_Sql.AbortTransaction();
      }
      m_Sql.CompleteTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      // * --- Delete from cpgroups
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("cpgroups");
      m_cPhName = m_Ctx.GetPhName("cpgroups");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpgroups",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("spadministration_deletegroup",23,"00000008")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"code = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idfolder,"?",0,0,m_cServer),m_cServer,idfolder)+"";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter();
      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
      if (CPLib.lt(m_nUpdatedRows,0)) {
        m_Sql.AbortTransaction();
      }
      m_Sql.CompleteTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
    } // End If
    /* Return true */
    throw new Stop(true);
  }
  void _init_() {
  }
  public String RunAsync(double p_idfolder) {
    idfolder = p_idfolder;
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
  public boolean Run(double p_idfolder) {
    idfolder = p_idfolder;
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
  public static spadministration_deletegroupR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spadministration_deletegroupR(p_Ctx, p_Caller);
  }
  public static spadministration_deletegroupR Make(CPContext p_Ctx) {
    return new spadministration_deletegroupR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    idfolder = 0;
    d = false;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,spadministration_deletegroup,
  public static final String i_InvokedRoutines = ",spadministration_deletegroup,";
  public static String[] m_cRunParameterNames={"idfolder"};
}
