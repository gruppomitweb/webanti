// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_aggstatorapR implements CallerWithObjs {
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
  public String m_cPhName_statorap;
  public String m_cServer_statorap;
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
  public String w_RAPPORTO;
  public String w_CODINTER;
  public java.sql.Date w_DATAINI;
  public java.sql.Date w_DATAFINE;
  public String w_TIPOPERS;
  public String w_tiporegr;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_aggstatorapR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_aggstatorap",m_Caller);
    m_cPhName_statorap = p_ContextObject.GetPhName("statorap");
    if (m_cPhName_statorap.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_statorap = m_cPhName_statorap+" "+m_Ctx.GetWritePhName("statorap");
    }
    m_cServer_statorap = p_ContextObject.GetServer("statorap");
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
      return "arrt_aggstatorap";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      return w_RAPPORTO;
    }
    if (CPLib.eqr("CODINTER",p_cVarName)) {
      return w_CODINTER;
    }
    if (CPLib.eqr("TIPOPERS",p_cVarName)) {
      return w_TIPOPERS;
    }
    if (CPLib.eqr("tiporegr",p_cVarName)) {
      return w_tiporegr;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DATAINI",p_cVarName)) {
      return w_DATAINI;
    }
    if (CPLib.eqr("DATAFINE",p_cVarName)) {
      return w_DATAFINE;
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
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      w_RAPPORTO = value;
      return;
    }
    if (CPLib.eqr("CODINTER",p_cVarName)) {
      w_CODINTER = value;
      return;
    }
    if (CPLib.eqr("TIPOPERS",p_cVarName)) {
      w_TIPOPERS = value;
      return;
    }
    if (CPLib.eqr("tiporegr",p_cVarName)) {
      w_tiporegr = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DATAINI",p_cVarName)) {
      w_DATAINI = value;
      return;
    }
    if (CPLib.eqr("DATAFINE",p_cVarName)) {
      w_DATAFINE = value;
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
    /* Variabili dell'oggetto chiamante */
    /* w_RAPPORTO Char(25) // Rapporto (Copia della testata) */
    /* w_CODINTER Char(16) // Intestatario (Non Intermediario) */
    /* w_DATAINI Date // Data Inizio */
    /* w_DATAFINE Date // Data Fine */
    /* w_TIPOPERS Char(1) // Tipo Soggetto */
    /* w_tiporegr Char(1) */
    /* Tenta di inserire la riga se non riesce l'aggiorna */
    double nTry00000009status;
    nTry00000009status = m_Sql.GetTransactionStatus();
    String cTry00000009msg;
    cTry00000009msg = m_Sql.TransactionErrorMessage();
    try {
      // * --- Insert into statorap from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("statorap");
      m_cPhName = m_Ctx.GetPhName("statorap");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"statorap",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_aggstatorap",17,"0000000A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_0000000A(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_RAPPORTO,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CODINTER,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_DATAINI,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_DATAFINE,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_TIPOPERS,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_tiporegr,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"statorap",true);
      m_cSql = m_cSql+")";
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
    } catch(Exception l_exeption) {
      Stop.ReactToException(l_exeption);
      // Accept Error
      m_Sql.AcceptTransactionError();
      m_cLastMsgError = "";
      m_bError = false;
      // * --- Write into statorap from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("statorap");
      m_cPhName = m_Ctx.GetPhName("statorap");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"statorap",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_aggstatorap",17,"0000000C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(w_DATAINI,"D",8,0)+", ";
      m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(w_DATAFINE,"D",8,0)+", ";
      m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(w_TIPOPERS,"C",1,0,m_cServer)+", ";
      m_cSql = m_cSql+"STATORAP = "+CPLib.ToSQL(w_tiporegr,"C",1,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"statorap",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"?",0,0,m_cServer),m_cServer,w_RAPPORTO)+"";
      m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODINTER,"?",0,0,m_cServer),m_cServer,w_CODINTER)+"";
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
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000009status,0)) {
        m_Sql.SetTransactionStatus(nTry00000009status,cTry00000009msg);
      }
    }
    /* Return  */
    Forward f;
    f=new Forward("centrale",false,this,Forward.Start,false);
    f.SetParameter("m_cParameterSequence", "");
    f.SetParameter("m_cMode","hyperlink");
    throw f;
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
      m_Caller.SetString("RAPPORTO","C",25,0,w_RAPPORTO);
      m_Caller.SetString("CODINTER","C",16,0,w_CODINTER);
      m_Caller.SetDate("DATAINI","D",8,0,w_DATAINI);
      m_Caller.SetDate("DATAFINE","D",8,0,w_DATAFINE);
      m_Caller.SetString("TIPOPERS","C",1,0,w_TIPOPERS);
      m_Caller.SetString("tiporegr","C",1,0,w_tiporegr);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_aggstatorapR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_aggstatorapR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_RAPPORTO = m_Caller.GetString("RAPPORTO","C",25,0);
    w_CODINTER = m_Caller.GetString("CODINTER","C",16,0);
    w_DATAINI = m_Caller.GetDate("DATAINI","D",8,0);
    w_DATAFINE = m_Caller.GetDate("DATAFINE","D",8,0);
    w_TIPOPERS = m_Caller.GetString("TIPOPERS","C",1,0);
    w_tiporegr = m_Caller.GetString("tiporegr","C",1,0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000000A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"STATORAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"statorap",true);
    return p_cSql;
  }
}
