// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_tit_load_auiR implements CallerWithObjs {
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
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_tmp_intestit;
  public String m_cServer_tmp_intestit;
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
  public armt_titolaboBL pObj;
  public String pOper;
  public String w_tito;
  public String w_mand;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_tit_load_auiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_tit_load_aui",m_Caller);
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_intestit")) {
      m_cPhName_tmp_intestit = p_ContextObject.GetPhName("tmp_intestit");
      if (m_cPhName_tmp_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_intestit = m_cPhName_tmp_intestit+" "+m_Ctx.GetWritePhName("tmp_intestit");
      }
      m_cServer_tmp_intestit = p_ContextObject.GetServer("tmp_intestit");
    }
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
      return "arrt_tit_load_aui";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pOper",p_cVarName)) {
      return pOper;
    }
    if (CPLib.eqr("tito",p_cVarName)) {
      return w_tito;
    }
    if (CPLib.eqr("mand",p_cVarName)) {
      return w_mand;
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
    if (CPLib.eqr("pOper",p_cVarName)) {
      pOper = value;
      return;
    }
    if (CPLib.eqr("tito",p_cVarName)) {
      w_tito = value;
      return;
    }
    if (CPLib.eqr("mand",p_cVarName)) {
      w_mand = value;
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
    CPResultSet Cursor_intestit=null;
    try {
      /* pObj Object(armt_titolaboBL) */
      /* pOper Char(1) */
      /* w_tito Char(16) */
      /* w_mand Char(25) */
      /* Crea file appoggio */
      /* If pOper='C' */
      if (CPLib.eqr(pOper,"C")) {
        // * --- Drop temporary table tmp_intestit
        if (m_Ctx.IsSharedTemp("tmp_intestit")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_intestit")) {
            m_cServer = m_Ctx.GetServer("tmp_intestit");
            m_cPhName = m_Ctx.GetPhName("tmp_intestit");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_intestit");
        }
        // * --- Create temporary table tmp_intestit
        if (m_Ctx.IsSharedTemp("tmp_intestit")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_intestit")) {
            m_cServer = m_Ctx.GetServer("tmp_intestit");
            m_cPhName = m_Ctx.GetPhName("tmp_intestit");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_intestit");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_intestit");
        if ( ! (m_Ctx.IsSharedTemp("tmp_intestit"))) {
          m_cServer = m_Ctx.GetServer("tmp_intestit");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_intestit",m_cServer,"proto")),m_cPhName,"tmp_intestit",m_Ctx);
        }
        m_cPhName_tmp_intestit = m_cPhName;
        /* ElseIf pOper='L' */
      } else if (CPLib.eqr(pOper,"L")) {
        // * --- Delete from tmp_intestit
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_intestit");
        m_cPhName = m_Ctx.GetPhName("tmp_intestit");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_intestit",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_tit_load_aui",163,"0000000B")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        // * --- Select from intestit
        m_cServer = m_Ctx.GetServer("intestit");
        m_cPhName = m_Ctx.GetPhName("intestit");
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
        Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_CONNESCLI,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_CONNESCLI)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestit.Eof())) {
          // * --- Insert into tmp_intestit from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_intestit");
          m_cPhName = m_Ctx.GetPhName("tmp_intestit");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_intestit",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_tit_load_aui",163,"0000000D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000000D(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("CODCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetDate("DATAINI"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetDate("DATARETT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetDate("DATAFINE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("L","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetDouble("ABBINATO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetDouble("PRGIMPTITE"),"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_intestit",true);
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
          Cursor_intestit.Next();
        }
        m_cConnectivityError = Cursor_intestit.ErrorMessage();
        Cursor_intestit.Close();
        // * --- End Select
      } // End If
    } finally {
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(armt_titolaboBL p_pObj,String p_pOper) {
    pObj = p_pObj;
    pOper = p_pOper;
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
  public Forward Run(armt_titolaboBL p_pObj,String p_pOper) {
    pObj = p_pObj;
    pOper = p_pOper;
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
  public static arrt_tit_load_auiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_tit_load_auiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pObj = null;
    pOper = CPLib.Space(1);
    w_tito = CPLib.Space(16);
    w_mand = CPLib.Space(25);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pObj","pOper"};
  protected static String GetFieldsName_0000000D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODCLI,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"PRGIMPTITE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_intestit",true);
    return p_cSql;
  }
}
