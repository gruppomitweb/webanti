// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_moduli_multi_reportR implements CallerWithObjs {
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
  public String m_cPhName_cgo_operazioni_dl_multi;
  public String m_cServer_cgo_operazioni_dl_multi;
  public String m_cPhName_cgo_operazioni_storico;
  public String m_cServer_cgo_operazioni_storico;
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
  public String pSNAINUMOPE;
  public String _numope;
  public String _result;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_moduli_multi_reportR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_moduli_multi_report",m_Caller);
    m_cPhName_cgo_operazioni_dl_multi = p_ContextObject.GetPhName("cgo_operazioni_dl_multi");
    if (m_cPhName_cgo_operazioni_dl_multi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi = m_cPhName_cgo_operazioni_dl_multi+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi");
    }
    m_cServer_cgo_operazioni_dl_multi = p_ContextObject.GetServer("cgo_operazioni_dl_multi");
    m_cPhName_cgo_operazioni_storico = p_ContextObject.GetPhName("cgo_operazioni_storico");
    if (m_cPhName_cgo_operazioni_storico.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_storico = m_cPhName_cgo_operazioni_storico+" "+m_Ctx.GetWritePhName("cgo_operazioni_storico");
    }
    m_cServer_cgo_operazioni_storico = p_ContextObject.GetServer("cgo_operazioni_storico");
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
      return "arrt_cgo_moduli_multi_report";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pSNAINUMOPE",p_cVarName)) {
      return pSNAINUMOPE;
    }
    if (CPLib.eqr("_numope",p_cVarName)) {
      return _numope;
    }
    if (CPLib.eqr("_result",p_cVarName)) {
      return _result;
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
    if (CPLib.eqr("pSNAINUMOPE",p_cVarName)) {
      pSNAINUMOPE = value;
      return;
    }
    if (CPLib.eqr("_numope",p_cVarName)) {
      _numope = value;
      return;
    }
    if (CPLib.eqr("_result",p_cVarName)) {
      _result = value;
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_cgo_operazioni_agenzia_storico_report=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pSNAINUMOPE Char(15) // Numero Operazione */
      /* _numope Char(15) */
      /* _result Char(0) // Risultato */
      /* _result := 'KO' // Risultato */
      _result = "KO";
      /* _numope := '' */
      _numope = "";
      // * --- Read from cgo_operazioni_dl_multi
      m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi");
      m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi");
      m_cSql = "";
      m_cSql = m_cSql+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pSNAINUMOPE,"C",15,0,m_cServer),m_cServer,pSNAINUMOPE);
      if (m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SNAINUMOPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _numope = Read_Cursor.GetString("SNAINUMOPE");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cgo_operazioni_dl_multi into routine arrt_cgo_moduli_multi_report returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _numope = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If not(Empty(_numope)) */
      if ( ! (CPLib.Empty(_numope))) {
        /* _result := arrt_cgo_moduli_multi_new(pSNAINUMOPE) // Risultato */
        _result = arrt_cgo_moduli_multi_newR.Make(m_Ctx,this).Run(pSNAINUMOPE);
      } else { // Else
        // * --- Select from qbe_cgo_operazioni_agenzia_storico_report
        SPBridge.HMCaller _h0000000C;
        _h0000000C = new SPBridge.HMCaller();
        _h0000000C.Set("m_cVQRList",m_cVQRList);
        _h0000000C.Set("pSNAINUMOPE",pSNAINUMOPE);
        if (Cursor_qbe_cgo_operazioni_agenzia_storico_report!=null)
          Cursor_qbe_cgo_operazioni_agenzia_storico_report.Close();
        Cursor_qbe_cgo_operazioni_agenzia_storico_report = new VQRHolder("qbe_cgo_operazioni_agenzia_storico_report",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000000C,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_cgo_operazioni_agenzia_storico_report.Eof())) {
          /* _numope := qbe_cgo_operazioni_agenzia_storico_report->IDCODICE */
          _numope = Cursor_qbe_cgo_operazioni_agenzia_storico_report.GetString("IDCODICE");
          Cursor_qbe_cgo_operazioni_agenzia_storico_report.Next();
        }
        m_cConnectivityError = Cursor_qbe_cgo_operazioni_agenzia_storico_report.ErrorMessage();
        Cursor_qbe_cgo_operazioni_agenzia_storico_report.Close();
        // * --- End Select
        /* If not(Empty(_numope)) */
        if ( ! (CPLib.Empty(_numope))) {
          /* _result := arrt_cgo_moduli_storico(_numope) */
          _result = arrt_cgo_moduli_storicoR.Make(m_Ctx,this).Run(_numope);
        } // End If
      } // End If
      /* Return _result */
      throw new Stop(_result);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_cgo_operazioni_agenzia_storico_report!=null)
          Cursor_qbe_cgo_operazioni_agenzia_storico_report.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pSNAINUMOPE) {
    pSNAINUMOPE = p_pSNAINUMOPE;
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
  public String Run(String p_pSNAINUMOPE) {
    pSNAINUMOPE = p_pSNAINUMOPE;
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
  public static arrt_cgo_moduli_multi_reportR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_moduli_multi_reportR(p_Ctx, p_Caller);
  }
  public static arrt_cgo_moduli_multi_reportR Make(CPContext p_Ctx) {
    return new arrt_cgo_moduli_multi_reportR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pSNAINUMOPE = CPLib.Space(15);
    _numope = CPLib.Space(15);
    _result = CPLib.Space(0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_cgo_operazioni_agenzia_storico_report,
  public static final String m_cVQRList = ",qbe_cgo_operazioni_agenzia_storico_report,";
  // ENTITY_BATCHES: ,arrt_cgo_moduli_multi_new,arrt_cgo_moduli_multi_report,arrt_cgo_moduli_storico,
  public static final String i_InvokedRoutines = ",arrt_cgo_moduli_multi_new,arrt_cgo_moduli_multi_report,arrt_cgo_moduli_storico,";
  public static String[] m_cRunParameterNames={"pSNAINUMOPE"};
}
