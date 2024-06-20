// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_wu_sbloccoR implements CallerWithObjs {
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
  public java.sql.Timestamp _tinilav;
  public java.sql.Timestamp _tfinlav;
  public double _durata;
  public MemoryCursor_qbe_wu_sblocco_vqr mcSblocco;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_wu_sbloccoR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_wu_sblocco",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_durata",p_cVarName)) {
      return _durata;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_wu_sblocco";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_tinilav",p_cVarName)) {
      return _tinilav;
    }
    if (CPLib.eqr("_tfinlav",p_cVarName)) {
      return _tfinlav;
    }
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcSblocco",p_cVarName)) {
      return mcSblocco;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_durata",p_cVarName)) {
      _durata = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
    if (CPLib.eqr("_tinilav",p_cVarName)) {
      _tinilav = value;
      return;
    }
    if (CPLib.eqr("_tfinlav",p_cVarName)) {
      _tfinlav = value;
      return;
    }
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcSblocco",p_cVarName)) {
      mcSblocco = (MemoryCursor_qbe_wu_sblocco_vqr)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_wu_sblocco=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _tinilav DateTime */
      /* _tfinlav DateTime */
      /* _durata Numeric(15, 0) */
      /* mcSblocco MemoryCursor(qbe_wu_sblocco.vqr) */
      // * --- Select from qbe_wu_sblocco
      if (Cursor_qbe_wu_sblocco!=null)
        Cursor_qbe_wu_sblocco.Close();
      Cursor_qbe_wu_sblocco = new VQRHolder("qbe_wu_sblocco",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_wu_sblocco.Eof())) {
        /* _tinilav := qbe_wu_sblocco->TRXTINILAV */
        _tinilav = Cursor_qbe_wu_sblocco.GetDateTime("TRXTINILAV");
        /* _tfinlav := DateTime() */
        _tfinlav = CPLib.DateTime();
        /* _durata := (_tfinlav.getTime() - _tinilav.getTime()) / 1000 */
        _durata = CPLib.Round((_tfinlav.getTime()-_tinilav.getTime())/1000,0);
        /* If _durata/3600 >= 2 */
        if (CPLib.ge(_durata/3600,2)) {
          /* mcSblocco.AppendBlank() */
          mcSblocco.AppendBlank();
          /* mcSblocco.TRXCODPRG := qbe_wu_sblocco->TRXCODPRG */
          mcSblocco.row.TRXCODPRG = Cursor_qbe_wu_sblocco.GetDouble("TRXCODPRG");
          /* mcSblocco.TRXCODDIP := qbe_wu_sblocco->TRXCODDIP */
          mcSblocco.row.TRXCODDIP = Cursor_qbe_wu_sblocco.GetString("TRXCODDIP");
          /* mcSblocco.TRXMTCN := qbe_wu_sblocco->TRXMTCN */
          mcSblocco.row.TRXMTCN = Cursor_qbe_wu_sblocco.GetString("TRXMTCN");
          /* mcSblocco.TRXDATOPE := qbe_wu_sblocco->TRXDATOPE */
          mcSblocco.row.TRXDATOPE = Cursor_qbe_wu_sblocco.GetDate("TRXDATOPE");
          /* mcSblocco.TRXCOGNOM := qbe_wu_sblocco->TRXCOGNOM */
          mcSblocco.row.TRXCOGNOM = Cursor_qbe_wu_sblocco.GetString("TRXCOGNOM");
          /* mcSblocco.TRXNOME := qbe_wu_sblocco->TRXNOME */
          mcSblocco.row.TRXNOME = Cursor_qbe_wu_sblocco.GetString("TRXNOME");
          /* mcSblocco.TRXCODFIS := qbe_wu_sblocco->TRXCODFIS */
          mcSblocco.row.TRXCODFIS = Cursor_qbe_wu_sblocco.GetString("TRXCODFIS");
          /* mcSblocco.TRXUTENTE := qbe_wu_sblocco->TRXUTENTE */
          mcSblocco.row.TRXUTENTE = Cursor_qbe_wu_sblocco.GetDouble("TRXUTENTE");
          /* mcSblocco.fullname := qbe_wu_sblocco->fullname */
          mcSblocco.row.fullname = Cursor_qbe_wu_sblocco.GetString("fullname");
          /* mcSblocco.TRXTINILAV := qbe_wu_sblocco->TRXTINILAV */
          mcSblocco.row.TRXTINILAV = Cursor_qbe_wu_sblocco.GetDateTime("TRXTINILAV");
          /* mcSblocco.TRXSCAEDT := qbe_wu_sblocco->TRXSCAEDT */
          mcSblocco.row.TRXSCAEDT = Cursor_qbe_wu_sblocco.GetDate("TRXSCAEDT");
          /* mcSblocco.SCADENZA := qbe_wu_sblocco->SCADENZA */
          mcSblocco.row.SCADENZA = Cursor_qbe_wu_sblocco.GetDouble("SCADENZA");
          /* mcSblocco.SaveRow() */
          mcSblocco.SaveRow();
        } // End If
        Cursor_qbe_wu_sblocco.Next();
      }
      m_cConnectivityError = Cursor_qbe_wu_sblocco.ErrorMessage();
      Cursor_qbe_wu_sblocco.Close();
      // * --- End Select
      /* Return mcSblocco */
      throw new Stop(mcSblocco);
    } finally {
      try {
        if (Cursor_qbe_wu_sblocco!=null)
          Cursor_qbe_wu_sblocco.Close();
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
  public MemoryCursor_qbe_wu_sblocco_vqr Run() {
    MemoryCursor_qbe_wu_sblocco_vqr l_result;
    l_result = null;
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
        l_result = (MemoryCursor_qbe_wu_sblocco_vqr)stop_value.GetObject();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = null;
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
  public static arfn_wu_sbloccoR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_wu_sbloccoR(p_Ctx, p_Caller);
  }
  public static arfn_wu_sbloccoR Make(CPContext p_Ctx) {
    return new arfn_wu_sbloccoR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    _tinilav = CPLib.NullDateTime();
    _tfinlav = CPLib.NullDateTime();
    _durata = 0;
    mcSblocco = new MemoryCursor_qbe_wu_sblocco_vqr();
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_wu_sblocco,
  public static final String m_cVQRList = ",qbe_wu_sblocco,";
  // ENTITY_BATCHES: ,arfn_wu_sblocco,
  public static final String i_InvokedRoutines = ",arfn_wu_sblocco,";
  public static String[] m_cRunParameterNames={};
}
