// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_save_esiticonR implements CallerWithObjs {
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
  public String m_cPhName_cgo_operazioni;
  public String m_cServer_cgo_operazioni;
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
  public String pNumOpe;
  public java.sql.Date pDatCon;
  public String pEsiCon;
  public String pNotCon;
  public String pAll;
  public String _coddip;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_save_esiticonR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_save_esiticon",m_Caller);
    m_cPhName_cgo_operazioni = p_ContextObject.GetPhName("cgo_operazioni");
    if (m_cPhName_cgo_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni = m_cPhName_cgo_operazioni+" "+m_Ctx.GetWritePhName("cgo_operazioni");
    }
    m_cServer_cgo_operazioni = p_ContextObject.GetServer("cgo_operazioni");
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
      return "arrt_cgo_save_esiticon";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pNumOpe",p_cVarName)) {
      return pNumOpe;
    }
    if (CPLib.eqr("pEsiCon",p_cVarName)) {
      return pEsiCon;
    }
    if (CPLib.eqr("pNotCon",p_cVarName)) {
      return pNotCon;
    }
    if (CPLib.eqr("pAll",p_cVarName)) {
      return pAll;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDatCon",p_cVarName)) {
      return pDatCon;
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
    if (CPLib.eqr("pNumOpe",p_cVarName)) {
      pNumOpe = value;
      return;
    }
    if (CPLib.eqr("pEsiCon",p_cVarName)) {
      pEsiCon = value;
      return;
    }
    if (CPLib.eqr("pNotCon",p_cVarName)) {
      pNotCon = value;
      return;
    }
    if (CPLib.eqr("pAll",p_cVarName)) {
      pAll = value;
      return;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      _coddip = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDatCon",p_cVarName)) {
      pDatCon = value;
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
    CPResultSet Read_Cursor=null;
    try {
      /* pNumOpe Char(15) // Codice Operazione */
      /* pDatCon Date // Data Contatto */
      /* pEsiCon Char(2) // Esito Contatto */
      /* pNotCon Memo // Note Contatto */
      /* pAll Char(1) // Note Contatto */
      /* _coddip Char(6) */
      /* If pAll='S' */
      if (CPLib.eqr(pAll,"S")) {
        /* _coddip := '' */
        _coddip = "";
        // * --- Read from cgo_operazioni
        m_cServer = m_Ctx.GetServer("cgo_operazioni");
        m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
        m_cSql = "";
        m_cSql = m_cSql+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pNumOpe,"C",15,0,m_cServer),m_cServer,pNumOpe);
        if (m_Ctx.IsSharedTemp("cgo_operazioni")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _coddip = Read_Cursor.GetString("CODDIPE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cgo_operazioni into routine arrt_cgo_save_esiticon returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _coddip = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(_coddip)) */
        if ( ! (CPLib.Empty(_coddip))) {
          // * --- Write into cgo_operazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_operazioni");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_save_esiticon",12,"0000000D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"CGODATCON = "+CPLib.ToSQL(pDatCon,"D",8,0)+", ";
          m_cSql = m_cSql+"CGOESICON = "+CPLib.ToSQL(pEsiCon,"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CGONOTCON = "+CPLib.ToSQL(pNotCon,"M",10,0,m_cServer,m_oParameters)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CODDIPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"?",0,0,m_cServer),m_cServer,_coddip)+"";
          m_cSql = m_cSql+" and CGODIPCOM = "+CPSql.SQLValueAdapter(CPLib.ToSQL("N","?",0,0,m_cServer),m_cServer,"N")+"";
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
      } else { // Else
        // * --- Write into cgo_operazioni from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_operazioni");
        m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_save_esiticon",12,"0000000E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CGODATCON = "+CPLib.ToSQL(pDatCon,"D",8,0)+", ";
        m_cSql = m_cSql+"CGOESICON = "+CPLib.ToSQL(pEsiCon,"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"CGONOTCON = "+CPLib.ToSQL(pNotCon,"M",10,0,m_cServer,m_oParameters)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pNumOpe,"?",0,0,m_cServer),m_cServer,pNumOpe)+"";
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
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pNumOpe,java.sql.Date p_pDatCon,String p_pEsiCon,String p_pNotCon,String p_pAll) {
    pNumOpe = p_pNumOpe;
    pDatCon = p_pDatCon;
    pEsiCon = p_pEsiCon;
    pNotCon = p_pNotCon;
    pAll = p_pAll;
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
  public String Run(String p_pNumOpe,java.sql.Date p_pDatCon,String p_pEsiCon,String p_pNotCon,String p_pAll) {
    pNumOpe = p_pNumOpe;
    pDatCon = p_pDatCon;
    pEsiCon = p_pEsiCon;
    pNotCon = p_pNotCon;
    pAll = p_pAll;
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
  public static arrt_cgo_save_esiticonR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_save_esiticonR(p_Ctx, p_Caller);
  }
  public static arrt_cgo_save_esiticonR Make(CPContext p_Ctx) {
    return new arrt_cgo_save_esiticonR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pNumOpe = CPLib.Space(15);
    pDatCon = CPLib.NullDate();
    pEsiCon = CPLib.Space(2);
    pNotCon = "";
    pAll = CPLib.Space(1);
    _coddip = CPLib.Space(6);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_cgo_save_esiticon,
  public static final String i_InvokedRoutines = ",arrt_cgo_save_esiticon,";
  public static String[] m_cRunParameterNames={"pNumOpe","pDatCon","pEsiCon","pNotCon","pAll"};
}
