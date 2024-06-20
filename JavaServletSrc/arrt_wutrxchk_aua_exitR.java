// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_wutrxchk_aua_exitR implements CallerWithObjs {
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
  public String m_cPhName_wutrxchk;
  public String m_cServer_wutrxchk;
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
  public double pIDTrx;
  public String pTipo;
  public double w_TRXUTENTE;
  public String w_TRFLGINLAV;
  public java.sql.Timestamp w_TRXTINILAV;
  public java.sql.Date w_TRXDINILAV;
  public double gUserCode;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_wutrxchk_aua_exitR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_wutrxchk_aua_exit",m_Caller);
    m_cPhName_wutrxchk = p_ContextObject.GetPhName("wutrxchk");
    if (m_cPhName_wutrxchk.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wutrxchk = m_cPhName_wutrxchk+" "+m_Ctx.GetWritePhName("wutrxchk");
    }
    m_cServer_wutrxchk = p_ContextObject.GetServer("wutrxchk");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("TRXUTENTE",p_cVarName)) {
      return w_TRXUTENTE;
    }
    if (CPLib.eqr("pIDTrx",p_cVarName)) {
      return pIDTrx;
    }
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      return gUserCode;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_wutrxchk_aua_exit";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("TRFLGINLAV",p_cVarName)) {
      return w_TRFLGINLAV;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("TRXDINILAV",p_cVarName)) {
      return w_TRXDINILAV;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("TRXTINILAV",p_cVarName)) {
      return w_TRXTINILAV;
    }
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
    if (CPLib.eqr("TRXUTENTE",p_cVarName)) {
      w_TRXUTENTE = value;
      return;
    }
    if (CPLib.eqr("pIDTrx",p_cVarName)) {
      pIDTrx = value;
      return;
    }
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      gUserCode = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("TRFLGINLAV",p_cVarName)) {
      w_TRFLGINLAV = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("TRXDINILAV",p_cVarName)) {
      w_TRXDINILAV = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
    if (CPLib.eqr("TRXTINILAV",p_cVarName)) {
      w_TRXTINILAV = value;
      return;
    }
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
    /* pIDTrx Numeric(15, 0) // ID Transazione */
    /* pTipo Char(1) // ID Transazione */
    /* w_TRXUTENTE Numeric(10, 0) // Codice Utente che lavora la transazione */
    /* w_TRFLGINLAV Char(1) // IN lavorazione */
    /* w_TRXTINILAV DateTime // Ora Inizio Lavorazione */
    /* w_TRXDINILAV Date // Data Inizio Lavorazione */
    /* gUserCode Numeric(4, 0) // Codice Utente CP */
    /* If pTipo='X' */
    if (CPLib.eqr(pTipo,"X")) {
      // * --- Write into wutrxchk from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("wutrxchk");
      m_cPhName = m_Ctx.GetPhName("wutrxchk");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wutrxchk",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_wutrxchk_aua_exit",11,"0000000C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"TRXUTENTE = "+CPLib.ToSQL(0,"N",10,0)+", ";
      m_cSql = m_cSql+"TRXTINILAV = "+CPLib.ToSQL(CPLib.NullDateTime(),"T",14,0)+", ";
      m_cSql = m_cSql+"TRXDINILAV = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
      m_cSql = m_cSql+"TRFLGINLAV = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"wutrxchk",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"TRXCODPRG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDTrx,"?",0,0,m_cServer),m_cServer,pIDTrx)+"";
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
    } else { // Else
      /* w_TRXUTENTE := 0 // Codice Utente che lavora la transazione */
      w_TRXUTENTE = CPLib.Round(0,0);
      /* w_TRFLGINLAV := 'N' // IN lavorazione */
      w_TRFLGINLAV = "N";
      /* w_TRXTINILAV := NullDateTime() // Ora Inizio Lavorazione */
      w_TRXTINILAV = CPLib.NullDateTime();
      /* w_TRXDINILAV := NullDate() // Data Inizio Lavorazione */
      w_TRXDINILAV = CPLib.NullDate();
    } // End If
  }
  void _init_() {
  }
  public String RunAsync(double p_pIDTrx,String p_pTipo) {
    pIDTrx = p_pIDTrx;
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
  public Forward Run(double p_pIDTrx,String p_pTipo) {
    pIDTrx = p_pIDTrx;
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
      m_Caller.SetNumber("TRXUTENTE","N",10,0,w_TRXUTENTE);
      m_Caller.SetString("TRFLGINLAV","C",1,0,w_TRFLGINLAV);
      m_Caller.SetDateTime("TRXTINILAV","T",14,0,w_TRXTINILAV);
      m_Caller.SetDate("TRXDINILAV","D",8,0,w_TRXDINILAV);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_wutrxchk_aua_exitR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_wutrxchk_aua_exitR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pIDTrx = 0;
    pTipo = CPLib.Space(1);
    w_TRXUTENTE = m_Caller.GetNumber("TRXUTENTE","N",10,0);
    w_TRFLGINLAV = m_Caller.GetString("TRFLGINLAV","C",1,0);
    w_TRXTINILAV = m_Caller.GetDateTime("TRXTINILAV","T",14,0);
    w_TRXDINILAV = m_Caller.GetDate("TRXDINILAV","D",8,0);
    gUserCode=m_Ctx.GetGlobalNumber("gUserCode");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pIDTrx","pTipo"};
}
