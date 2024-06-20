// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class aosrt_utility_indicatori_anomalieR implements CallerWithObjs {
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
  public String m_cPhName_mod_ind_mit;
  public String m_cServer_mod_ind_mit;
  public String m_cPhName_mod_ind_def;
  public String m_cServer_mod_ind_def;
  public String m_cPhName_ind_mit;
  public String m_cServer_ind_mit;
  public String m_cPhName_ind_def;
  public String m_cServer_ind_def;
  public String m_cPhName_sub_ind_def;
  public String m_cServer_sub_ind_def;
  public String m_cPhName_sub_ind_mit;
  public String m_cServer_sub_ind_mit;
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
  public aosrt_utility_indicatori_anomalieR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("aosrt_utility_indicatori_anomalie",m_Caller);
    m_cPhName_mod_ind_mit = p_ContextObject.GetPhName("mod_ind_mit");
    if (m_cPhName_mod_ind_mit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mod_ind_mit = m_cPhName_mod_ind_mit+" "+m_Ctx.GetWritePhName("mod_ind_mit");
    }
    m_cServer_mod_ind_mit = p_ContextObject.GetServer("mod_ind_mit");
    m_cPhName_mod_ind_def = p_ContextObject.GetPhName("mod_ind_def");
    if (m_cPhName_mod_ind_def.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mod_ind_def = m_cPhName_mod_ind_def+" "+m_Ctx.GetWritePhName("mod_ind_def");
    }
    m_cServer_mod_ind_def = p_ContextObject.GetServer("mod_ind_def");
    m_cPhName_ind_mit = p_ContextObject.GetPhName("ind_mit");
    if (m_cPhName_ind_mit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_ind_mit = m_cPhName_ind_mit+" "+m_Ctx.GetWritePhName("ind_mit");
    }
    m_cServer_ind_mit = p_ContextObject.GetServer("ind_mit");
    m_cPhName_ind_def = p_ContextObject.GetPhName("ind_def");
    if (m_cPhName_ind_def.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_ind_def = m_cPhName_ind_def+" "+m_Ctx.GetWritePhName("ind_def");
    }
    m_cServer_ind_def = p_ContextObject.GetServer("ind_def");
    m_cPhName_sub_ind_def = p_ContextObject.GetPhName("sub_ind_def");
    if (m_cPhName_sub_ind_def.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sub_ind_def = m_cPhName_sub_ind_def+" "+m_Ctx.GetWritePhName("sub_ind_def");
    }
    m_cServer_sub_ind_def = p_ContextObject.GetServer("sub_ind_def");
    m_cPhName_sub_ind_mit = p_ContextObject.GetPhName("sub_ind_mit");
    if (m_cPhName_sub_ind_mit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sub_ind_mit = m_cPhName_sub_ind_mit+" "+m_Ctx.GetWritePhName("sub_ind_mit");
    }
    m_cServer_sub_ind_mit = p_ContextObject.GetServer("sub_ind_mit");
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
      return "aosrt_utility_indicatori_anomalie";
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
    CPResultSet Cursor_mod_ind_def=null;
    CPResultSet Cursor_mod_ind_mit=null;
    try {
      /* idmod_new Char(0) := '0000000001' // id del nuovo modello del cliente */
      String idmod_new;
      idmod_new = "0000000001";
      /* idmod_mit Char(0) := '0000000001' // id del modello mit */
      String idmod_mit;
      idmod_mit = "0000000001";
      // * --- Select from mod_ind_def
      m_cServer = m_Ctx.GetServer("mod_ind_def");
      m_cPhName = m_Ctx.GetPhName("mod_ind_def");
      if (Cursor_mod_ind_def!=null)
        Cursor_mod_ind_def.Close();
      Cursor_mod_ind_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDMOD  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("mod_ind_def")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"IDMOD DESC ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_mod_ind_def.Eof())) {
        /* idmod_new := LRTrim(Str(Val(mod_ind_def->IDMOD)+1,10,0)) // id del nuovo modello del cliente */
        idmod_new = CPLib.LRTrim(CPLib.Str(CPLib.Val(Cursor_mod_ind_def.GetString("IDMOD"))+1,10,0));
        // Exit Loop
        if (true) {
          break;
        }
        Cursor_mod_ind_def.Next();
      }
      m_cConnectivityError = Cursor_mod_ind_def.ErrorMessage();
      Cursor_mod_ind_def.Close();
      // * --- End Select
      // * --- Select from mod_ind_mit
      m_cServer = m_Ctx.GetServer("mod_ind_mit");
      m_cPhName = m_Ctx.GetPhName("mod_ind_mit");
      if (Cursor_mod_ind_mit!=null)
        Cursor_mod_ind_mit.Close();
      Cursor_mod_ind_mit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDMOD,DESCRI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("mod_ind_mit")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"IDMOD DESC,DESCRI ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_mod_ind_mit.Eof())) {
        /* idmod_mit := mod_ind_mit->IDMOD // id del modello mit */
        idmod_mit = Cursor_mod_ind_mit.GetString("IDMOD");
        // * --- Insert into mod_ind_def from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("mod_ind_def");
        m_cPhName = m_Ctx.GetPhName("mod_ind_def");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mod_ind_def",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("aosrt_utility_indicatori_anomalie",11,"00000009")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000009(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(idmod_new,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQLNull(idmod_mit,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_mod_ind_mit.GetString("DESCRI"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mod_ind_def",true);
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
        // Exit Loop
        if (true) {
          break;
        }
        Cursor_mod_ind_mit.Next();
      }
      m_cConnectivityError = Cursor_mod_ind_mit.ErrorMessage();
      Cursor_mod_ind_mit.Close();
      // * --- End Select
      // * --- Insert into ind_def from sql
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("ind_def");
      m_cPhName = m_Ctx.GetPhName("ind_def");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"ind_def",m_Ctx.GetCompany());
      m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("aosrt_utility_indicatori_anomalie",11,"0000000B"),m_cServer,m_oWrInfo,"*","from "+m_cPhName_ind_mit+" where " + QueryLoader.SetSqlFunctions("IDMOD="+CPLib.ToSQL(idmod_mit,"?",0,0)+" ",m_cServer,m_Ctx)+"","ind_def",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"ind_def"));
      if (CPLib.lt(m_nUpdatedRows,0)) {
        m_Sql.AbortTransaction();
      }
      m_Sql.CompleteTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      // * --- Insert into sub_ind_def from sql
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("sub_ind_def");
      m_cPhName = m_Ctx.GetPhName("sub_ind_def");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sub_ind_def",m_Ctx.GetCompany());
      m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("aosrt_utility_indicatori_anomalie",11,"0000000C"),m_cServer,m_oWrInfo,"*","from "+m_cPhName_sub_ind_mit+" where " + QueryLoader.SetSqlFunctions("IDMOD="+CPLib.ToSQL(idmod_mit,"?",0,0)+" ",m_cServer,m_Ctx)+"","sub_ind_def",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"sub_ind_def"));
      if (CPLib.lt(m_nUpdatedRows,0)) {
        m_Sql.AbortTransaction();
      }
      m_Sql.CompleteTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      // * --- Write into ind_def from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("ind_def");
      m_cPhName = m_Ctx.GetPhName("ind_def");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"ind_def",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("aosrt_utility_indicatori_anomalie",11,"0000000D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"LOCKMIT = "+CPLib.ToSQL(true,"L",1,0)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"ind_def",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"IDMOD = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idmod_new,"?",0,0,m_cServer),m_cServer,idmod_new)+"";
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
      // * --- Write into sub_ind_def from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("sub_ind_def");
      m_cPhName = m_Ctx.GetPhName("sub_ind_def");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sub_ind_def",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("aosrt_utility_indicatori_anomalie",11,"0000000E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"LOCKMIT = "+CPLib.ToSQL(true,"L",1,0)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"sub_ind_def",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"IDMOD = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idmod_new,"?",0,0,m_cServer),m_cServer,idmod_new)+"";
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
    } finally {
      try {
        if (Cursor_mod_ind_def!=null)
          Cursor_mod_ind_def.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_mod_ind_mit!=null)
          Cursor_mod_ind_mit.Close();
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static aosrt_utility_indicatori_anomalieR Make(CPContext p_Ctx, Caller p_Caller) {
    return new aosrt_utility_indicatori_anomalieR(p_Ctx, p_Caller);
  }
  public void Blank() {
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000009(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDMOD,";
    p_cSql = p_cSql+"IDMODMIT,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mod_ind_def",true);
    return p_cSql;
  }
}
