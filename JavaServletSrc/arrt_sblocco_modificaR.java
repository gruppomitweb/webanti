// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_sblocco_modificaR implements CallerWithObjs {
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
  public String pConnes;
  public String w_xFLGVALIDO;
  public String w_xFLGANAVAL;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_sblocco_modificaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_sblocco_modifica",m_Caller);
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
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
      return "arrt_sblocco_modifica";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("xFLGVALIDO",p_cVarName)) {
      return w_xFLGVALIDO;
    }
    if (CPLib.eqr("xFLGANAVAL",p_cVarName)) {
      return w_xFLGANAVAL;
    }
    if (CPLib.eqr("pConnes",p_cVarName)) {
      return pConnes;
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
    if (CPLib.eqr("xFLGVALIDO",p_cVarName)) {
      w_xFLGVALIDO = value;
      return;
    }
    if (CPLib.eqr("xFLGANAVAL",p_cVarName)) {
      w_xFLGANAVAL = value;
      return;
    }
    if (CPLib.eqr("pConnes",p_cVarName)) {
      pConnes = value;
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
    /* pConnes Char(16) */
    /* w_xFLGVALIDO Char(1) */
    /* w_xFLGANAVAL Char(1) */
    /* w_xFLGVALIDO := 'N' */
    w_xFLGVALIDO = "N";
    /* w_xFLGANAVAL := 'N' */
    w_xFLGANAVAL = "N";
    // * --- Write into personbo_agg from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("personbo_agg");
    m_cPhName = m_Ctx.GetPhName("personbo_agg");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_sblocco_modifica",4,"00000009")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
    m_cSql = m_cSql+"FLGVALIDO = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
    m_cSql = m_cSql+"FLGANAVAL = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
    m_cSql = m_cSql+" where ";
    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pConnes,"?",0,0,m_cServer),m_cServer,pConnes)+"";
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
    /* If m_nUpdatedRows=0 */
    if (CPLib.eqr(m_nUpdatedRows,0)) {
      // * --- Insert into personbo_agg from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("personbo_agg");
      m_cPhName = m_Ctx.GetPhName("personbo_agg");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_sblocco_modifica",4,"0000000B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_0000000B(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(pConnes,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
      m_cSql = m_cSql+")";
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
  }
  void _init_() {
  }
  public String RunAsync(String p_pConnes) {
    pConnes = p_pConnes;
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
  public Forward Run(String p_pConnes) {
    pConnes = p_pConnes;
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
      m_Caller.SetString("xFLGVALIDO","C",1,0,w_xFLGVALIDO);
      m_Caller.SetString("xFLGANAVAL","C",1,0,w_xFLGANAVAL);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_sblocco_modificaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_sblocco_modificaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pConnes = CPLib.Space(16);
    w_xFLGVALIDO = m_Caller.GetString("xFLGVALIDO","C",1,0);
    w_xFLGANAVAL = m_Caller.GetString("xFLGANAVAL","C",1,0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pConnes"};
  protected static String GetFieldsName_0000000B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+"FLGANAVAL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
}
