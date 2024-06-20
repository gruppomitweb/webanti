// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_insert_tmp_abbina_cointestatariR implements CallerWithObjs {
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
  public String m_cPhName_tmp_abbina_cointestatari;
  public String m_cServer_tmp_abbina_cointestatari;
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
  public String w_Password;
  public String w_fonte;
  public String w_COINT;
  public String w_OrderBy;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_insert_tmp_abbina_cointestatariR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_insert_tmp_abbina_cointestatari",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_abbina_cointestatari")) {
      m_cPhName_tmp_abbina_cointestatari = p_ContextObject.GetPhName("tmp_abbina_cointestatari");
      if (m_cPhName_tmp_abbina_cointestatari.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_abbina_cointestatari = m_cPhName_tmp_abbina_cointestatari+" "+m_Ctx.GetWritePhName("tmp_abbina_cointestatari");
      }
      m_cServer_tmp_abbina_cointestatari = p_ContextObject.GetServer("tmp_abbina_cointestatari");
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
      return "arrt_insert_tmp_abbina_cointestatari";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("Password",p_cVarName)) {
      return w_Password;
    }
    if (CPLib.eqr("fonte",p_cVarName)) {
      return w_fonte;
    }
    if (CPLib.eqr("COINT",p_cVarName)) {
      return w_COINT;
    }
    if (CPLib.eqr("OrderBy",p_cVarName)) {
      return w_OrderBy;
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
    if (CPLib.eqr("Password",p_cVarName)) {
      w_Password = value;
      return;
    }
    if (CPLib.eqr("fonte",p_cVarName)) {
      w_fonte = value;
      return;
    }
    if (CPLib.eqr("COINT",p_cVarName)) {
      w_COINT = value;
      return;
    }
    if (CPLib.eqr("OrderBy",p_cVarName)) {
      w_OrderBy = value;
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
    VQRHolder l_VQRHolder = null;
    /* w_Password Char(9) // Password */
    /* w_fonte Char(1) // Archivio da allienare */
    /* w_COINT Char(1) // Solo rapporti cointestati */
    /* w_OrderBy Char(14) // Ordine */
    // * --- Create temporary table tmp_abbina_cointestatari
    if (m_Ctx.IsSharedTemp("tmp_abbina_cointestatari")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_abbina_cointestatari")) {
        m_cServer = m_Ctx.GetServer("tmp_abbina_cointestatari");
        m_cPhName = m_Ctx.GetPhName("tmp_abbina_cointestatari");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_abbina_cointestatari");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_abbina_cointestatari");
    if ( ! (m_Ctx.IsSharedTemp("tmp_abbina_cointestatari"))) {
      m_cServer = m_Ctx.GetServer("tmp_abbina_cointestatari");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_abbina_cointestatari",m_cServer,"proto")),m_cPhName,"tmp_abbina_cointestatari",m_Ctx);
    }
    m_cPhName_tmp_abbina_cointestatari = m_cPhName;
    // * --- Insert into tmp_abbina_cointestatari from query
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("tmp_abbina_cointestatari");
    m_cPhName = m_Ctx.GetPhName("tmp_abbina_cointestatari");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_abbina_cointestatari",m_Ctx.GetCompany());
    m_nUpdatedRows=m_Sql.InsertIntoVQR(CPLib.GetSQLPrefixComment("arrt_insert_tmp_abbina_cointestatari",13,"00000007"),m_oWrInfo,"qbe_ae_abbina_cointestati_1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,m_Ctx);
    if (CPLib.lt(m_nUpdatedRows,0)) {
      m_Sql.AbortTransaction();
    }
    m_Sql.CompleteTransaction();
    m_cLastMsgError = m_Sql.TransactionErrorMessage();
    if (CPLib.ne(m_cLastMsgError,"")) {
      m_bError = true;
    }
    /* Stop arpg_abbina_cointestatari */
    Forward f;
    f=new Forward("arpg_abbina_cointestatari",false,this,Forward.Start,false);
    f.SetParameter("COINT",w_COINT);
    f.SetParameter("fonte",w_fonte);
    f.SetParameter("OrderBy",w_OrderBy);
    f.SetParameter("Password",w_Password);
    f.SetParameter("m_cParameterSequence","COINT"+","+"fonte"+","+"OrderBy"+","+"Password");
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
      m_Caller.SetString("Password","C",9,0,w_Password);
      m_Caller.SetString("fonte","C",1,0,w_fonte);
      m_Caller.SetString("COINT","C",1,0,w_COINT);
      m_Caller.SetString("OrderBy","C",14,0,w_OrderBy);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_insert_tmp_abbina_cointestatariR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_insert_tmp_abbina_cointestatariR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_Password = m_Caller.GetString("Password","C",9,0);
    w_fonte = m_Caller.GetString("fonte","C",1,0);
    w_COINT = m_Caller.GetString("COINT","C",1,0);
    w_OrderBy = m_Caller.GetString("OrderBy","C",14,0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_ae_abbina_cointestati_1,
  public static final String m_cVQRList = ",qbe_ae_abbina_cointestati_1,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
