// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_crea_aggR implements CallerWithObjs {
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
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_personbo_dip;
  public String m_cServer_personbo_dip;
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
  public String pCONNES;
  public String cConnes;
  public String gCodDip;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_crea_aggR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_crea_agg",m_Caller);
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_personbo_dip = p_ContextObject.GetPhName("personbo_dip");
    if (m_cPhName_personbo_dip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_dip = m_cPhName_personbo_dip+" "+m_Ctx.GetWritePhName("personbo_dip");
    }
    m_cServer_personbo_dip = p_ContextObject.GetServer("personbo_dip");
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
      return "arrt_crea_agg";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pCONNES",p_cVarName)) {
      return pCONNES;
    }
    if (CPLib.eqr("cConnes",p_cVarName)) {
      return cConnes;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
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
    if (CPLib.eqr("pCONNES",p_cVarName)) {
      pCONNES = value;
      return;
    }
    if (CPLib.eqr("cConnes",p_cVarName)) {
      cConnes = value;
      return;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
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
    /* pCONNES Char(16) */
    /* cConnes Char(16) */
    /* gCodDip Char(6) // Dipendenza */
    /* cConnes := '' */
    cConnes = "";
    // * --- Merge into personbo_agg from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("personbo_agg");
    m_cPhName = m_Ctx.GetPhName("personbo_agg");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
    m_cQuery = "select ";
    m_cQuery =  m_cQuery+""+CPLib.ToSQL(pCONNES,"?",0,0)+" as CONNES";
    if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
      m_cQuery = m_cQuery+" from dual";
    }
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cWhere = "personbo_agg.CONNES = cptmp_1xab23.CONNES";
    m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
    if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
      m_cSql = CPLib.GetSQLPrefixComment("arrt_crea_agg",6,"00000009")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" personbo_agg USING ";
      m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
      m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",true,true);
      m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
      m_cSql = m_cSql+GetFieldsName_00000009(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(pCONNES,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
      m_cSql = m_cSql+")";
      if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
        m_cSql = m_cSql+";";
      }
    } else {
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_crea_agg",6,"00000009")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pCONNES,"?",0,0,m_cServer),m_cServer,pCONNES)+"";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter();
      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
      if (CPLib.eqr(m_nUpdatedRows,0)) {
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_crea_agg",6,"00000009")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000009(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(pCONNES,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
        m_cSql = m_cSql+")";
      } else {
        m_cSql = "";
      }
    }
    if ( ! (CPLib.Empty(m_cSql))) {
      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
    }
    if (CPLib.lt(m_nUpdatedRows,0)) {
      m_Sql.AbortTransaction();
    }
    m_Sql.CompleteTransaction();
    m_cLastMsgError = m_Sql.TransactionErrorMessage();
    if (CPLib.ne(m_cLastMsgError,"")) {
      m_bError = true;
    }
    /* cConnes := '' */
    cConnes = "";
    // * --- Merge into personbo_dip from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("personbo_dip");
    m_cPhName = m_Ctx.GetPhName("personbo_dip");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_dip",m_Ctx.GetCompany());
    m_cQuery = "select ";
    m_cQuery =  m_cQuery+""+CPLib.ToSQL(pCONNES,"?",0,0)+" as CONNES";
    m_cQuery =  m_cQuery+", "+CPLib.ToSQL(gCodDip,"?",0,0)+" as CODDIPE";
    if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
      m_cQuery = m_cQuery+" from dual";
    }
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cWhere = "personbo_dip.CONNES = cptmp_1xab23.CONNES";
    m_cWhere = m_cWhere+" and "+"personbo_dip.CODDIPE = cptmp_1xab23.CODDIPE";
    m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
    if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
      m_cSql = CPLib.GetSQLPrefixComment("arrt_crea_agg",6,"0000000C")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" personbo_dip USING ";
      m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
      m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_dip",true,true);
      m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
      m_cSql = m_cSql+GetFieldsName_0000000C(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(pCONNES,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(gCodDip,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_dip",true);
      m_cSql = m_cSql+")";
      if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
        m_cSql = m_cSql+";";
      }
    } else {
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_crea_agg",6,"0000000C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_dip",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pCONNES,"?",0,0,m_cServer),m_cServer,pCONNES)+"";
      m_cSql = m_cSql+" and CODDIPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gCodDip,"?",0,0,m_cServer),m_cServer,gCodDip)+"";
      m_cSql = m_cSql+m_oWrInfo.WhereFilter();
      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
      if (CPLib.eqr(m_nUpdatedRows,0)) {
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_crea_agg",6,"0000000C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000000C(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(pCONNES,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(gCodDip,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_dip",true);
        m_cSql = m_cSql+")";
      } else {
        m_cSql = "";
      }
    }
    if ( ! (CPLib.Empty(m_cSql))) {
      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
    }
    if (CPLib.lt(m_nUpdatedRows,0)) {
      m_Sql.AbortTransaction();
    }
    m_Sql.CompleteTransaction();
    m_cLastMsgError = m_Sql.TransactionErrorMessage();
    if (CPLib.ne(m_cLastMsgError,"")) {
      m_bError = true;
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pCONNES) {
    pCONNES = p_pCONNES;
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
  public Forward Run(String p_pCONNES) {
    pCONNES = p_pCONNES;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_crea_aggR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_crea_aggR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pCONNES = CPLib.Space(16);
    cConnes = CPLib.Space(16);
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pCONNES"};
  protected static String GetFieldsName_00000009(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"FLGPREGIUD,";
    p_cSql = p_cSql+"FLGTRUST,";
    p_cSql = p_cSql+"FLGRISCHIO,";
    p_cSql = p_cSql+"FLGEQUIFIN,";
    p_cSql = p_cSql+"FLGFALSADIC,";
    p_cSql = p_cSql+"FLGRICINF,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000000C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_dip",true);
    return p_cSql;
  }
}
