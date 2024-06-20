// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_mass_cf_calcola_maxR implements CallerWithObjs {
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
  public String w_tipoinv;
  public String _annorif;
  public double _maxinv;
  public double w_maxinvii;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_mass_cf_calcola_maxR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_mass_cf_calcola_max",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_maxinv",p_cVarName)) {
      return _maxinv;
    }
    if (CPLib.eqr("maxinvii",p_cVarName)) {
      return w_maxinvii;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_mass_cf_calcola_max";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("tipoinv",p_cVarName)) {
      return w_tipoinv;
    }
    if (CPLib.eqr("_annorif",p_cVarName)) {
      return _annorif;
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
    if (CPLib.eqr("_maxinv",p_cVarName)) {
      _maxinv = value;
      return;
    }
    if (CPLib.eqr("maxinvii",p_cVarName)) {
      w_maxinvii = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipoinv",p_cVarName)) {
      w_tipoinv = value;
      return;
    }
    if (CPLib.eqr("_annorif",p_cVarName)) {
      _annorif = value;
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
    CPResultSet Cursor_qbe_opextrbo_count_year=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_tipoinv Char(1) // Tipo Invio */
      /* _annorif Char(4) */
      /* _maxinv Numeric(10, 0) */
      /* w_maxinvii Numeric(10, 0) // Numero Massimo Invii */
      /* _annorif := Str(Year(Date()) - 1,4,0) */
      _annorif = CPLib.Str(CPLib.Year(CPLib.Date())-1,4,0);
      // * --- Select from qbe_opextrbo_count_year
      SPBridge.HMCaller _h0000000A;
      _h0000000A = new SPBridge.HMCaller();
      _h0000000A.Set("m_cVQRList",m_cVQRList);
      _h0000000A.Set("pANNO",_annorif);
      if (Cursor_qbe_opextrbo_count_year!=null)
        Cursor_qbe_opextrbo_count_year.Close();
      Cursor_qbe_opextrbo_count_year = new VQRHolder("qbe_opextrbo_count_year",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000000A,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_opextrbo_count_year.Eof())) {
        /* _maxinv := qbe_opextrbo_count_year->CONTA */
        _maxinv = CPLib.Round(Cursor_qbe_opextrbo_count_year.GetDouble("CONTA"),0);
        Cursor_qbe_opextrbo_count_year.Next();
      }
      m_cConnectivityError = Cursor_qbe_opextrbo_count_year.ErrorMessage();
      Cursor_qbe_opextrbo_count_year.Close();
      // * --- End Select
      /* w_maxinvii := iif(w_tipoinv='P',_maxinv,Int((_maxinv/100)*20)) // Numero Massimo Invii */
      w_maxinvii = CPLib.Round((CPLib.eqr(w_tipoinv,"P")?_maxinv:CPLib.Int((_maxinv/100)*20)),0);
      /* Return w_maxinvii */
      throw new Stop(w_maxinvii);
    } finally {
      try {
        if (Cursor_qbe_opextrbo_count_year!=null)
          Cursor_qbe_opextrbo_count_year.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_tipoinv) {
    w_tipoinv = p_w_tipoinv;
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
  public double Run(String p_w_tipoinv) {
    w_tipoinv = p_w_tipoinv;
    return Run();
  }
  public double Run() {
    double l_result;
    l_result = 0;
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
        l_result = stop_value.GetNumber();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = 0;
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
  public static arrt_mass_cf_calcola_maxR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_mass_cf_calcola_maxR(p_Ctx, p_Caller);
  }
  public static arrt_mass_cf_calcola_maxR Make(CPContext p_Ctx) {
    return new arrt_mass_cf_calcola_maxR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_tipoinv = CPLib.Space(1);
    _annorif = CPLib.Space(4);
    _maxinv = 0;
    w_maxinvii = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_opextrbo_count_year,
  public static final String m_cVQRList = ",qbe_opextrbo_count_year,";
  // ENTITY_BATCHES: ,arrt_mass_cf_calcola_max,
  public static final String i_InvokedRoutines = ",arrt_mass_cf_calcola_max,";
  public static String[] m_cRunParameterNames={"w_tipoinv"};
}
