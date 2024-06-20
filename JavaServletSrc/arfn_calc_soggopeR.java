// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_calc_soggopeR implements CallerWithObjs {
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
  public String m_cPhName_soggope;
  public String m_cServer_soggope;
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
  public String pDatOpe;
  public String pRuolo;
  public double nRitorno;
  public java.sql.Date _datope;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_calc_soggopeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_calc_soggope",m_Caller);
    m_cPhName_soggope = p_ContextObject.GetPhName("soggope");
    if (m_cPhName_soggope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_soggope = m_cPhName_soggope+" "+m_Ctx.GetWritePhName("soggope");
    }
    m_cServer_soggope = p_ContextObject.GetServer("soggope");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("nRitorno",p_cVarName)) {
      return nRitorno;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_calc_soggope";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pConnes",p_cVarName)) {
      return pConnes;
    }
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      return pDatOpe;
    }
    if (CPLib.eqr("pRuolo",p_cVarName)) {
      return pRuolo;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_datope",p_cVarName)) {
      return _datope;
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
    if (CPLib.eqr("nRitorno",p_cVarName)) {
      nRitorno = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pConnes",p_cVarName)) {
      pConnes = value;
      return;
    }
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      pDatOpe = value;
      return;
    }
    if (CPLib.eqr("pRuolo",p_cVarName)) {
      pRuolo = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_datope",p_cVarName)) {
      _datope = value;
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
    CPResultSet Cursor_soggope=null;
    try {
      /* pConnes Char(16) // Codice Cliente */
      /* pDatOpe Char(8) // Data Operazione */
      /* pRuolo Char(1) // Ruolo Da Verificare */
      /* nRitorno Numeric(3, 0) */
      /* _datope Date // Data Operazione */
      /* _datope := CharToDate(pDatOpe) // Data Operazione */
      _datope = CPLib.CharToDate(pDatOpe);
      /* nRitorno := 0 */
      nRitorno = CPLib.Round(0,0);
      // * --- Select from soggope
      m_cServer = m_Ctx.GetServer("soggope");
      m_cPhName = m_Ctx.GetPhName("soggope");
      if (Cursor_soggope!=null)
        Cursor_soggope.Close();
      Cursor_soggope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(pConnes,"?",0,0,m_cServer, m_oParameters),m_cServer,pConnes)+"  and  RUOLO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRuolo,"?",0,0,m_cServer, m_oParameters),m_cServer,pRuolo)+"  and  ([NOTEMPTYDATE(DATAINI)]=0  or  DATAINI <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer, m_oParameters),m_cServer,_datope)+")  and  ([NOTEMPTYDATE(DATAFINE)]=0  or  DATAFINE >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"?",0,0,m_cServer, m_oParameters),m_cServer,_datope)+") "+")"+(m_Ctx.IsSharedTemp("soggope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_soggope.Eof())) {
        /* nRitorno := nRitorno + 1 */
        nRitorno = CPLib.Round(nRitorno+1,0);
        Cursor_soggope.Next();
      }
      m_cConnectivityError = Cursor_soggope.ErrorMessage();
      Cursor_soggope.Close();
      // * --- End Select
      /* Return nRitorno */
      throw new Stop(nRitorno);
    } finally {
      try {
        if (Cursor_soggope!=null)
          Cursor_soggope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pConnes,String p_pDatOpe,String p_pRuolo) {
    pConnes = p_pConnes;
    pDatOpe = p_pDatOpe;
    pRuolo = p_pRuolo;
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
  public double Run(String p_pConnes,String p_pDatOpe,String p_pRuolo) {
    pConnes = p_pConnes;
    pDatOpe = p_pDatOpe;
    pRuolo = p_pRuolo;
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
  public static arfn_calc_soggopeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_calc_soggopeR(p_Ctx, p_Caller);
  }
  public static arfn_calc_soggopeR Make(CPContext p_Ctx) {
    return new arfn_calc_soggopeR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pConnes = CPLib.Space(16);
    pDatOpe = CPLib.Space(8);
    pRuolo = CPLib.Space(1);
    nRitorno = 0;
    _datope = CPLib.NullDate();
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_calc_soggope,
  public static final String i_InvokedRoutines = ",arfn_calc_soggope,";
  public static String[] m_cRunParameterNames={"pConnes","pDatOpe","pRuolo"};
}
