// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_sos_bigliettoR implements CallerWithObjs {
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
  public armt_cgo_sosBL pObj;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_sos_bigliettoR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_sos_biglietto",m_Caller);
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
      return "arrt_cgo_sos_biglietto";
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
    CPResultSet Cursor_cgo_operazioni_storico=null;
    try {
      /* pObj Object(armt_cgo_sosBL) */
      // * --- Select from cgo_operazioni_storico
      m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
      m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
      if (Cursor_cgo_operazioni_storico!=null)
        Cursor_cgo_operazioni_storico.Close();
      Cursor_cgo_operazioni_storico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CAIDBIGLIETTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_IDBIGLIETTO,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_IDBIGLIETTO)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_storico")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_operazioni_storico.Eof())) {
        /* pObj.w_SOSCLIECOG := cgo_operazioni_storico->COGNOME */
        pObj.w_SOSCLIECOG = Cursor_cgo_operazioni_storico.GetString("COGNOME");
        /* pObj.w_SOSDATAOP := cgo_operazioni_storico->DATAOPE */
        pObj.w_SOSDATAOP = Cursor_cgo_operazioni_storico.GetDate("DATAOPE");
        /* pObj.w_SOSIMPOPE := cgo_operazioni_storico->TOTLIRE */
        pObj.w_SOSIMPOPE = Cursor_cgo_operazioni_storico.GetDouble("TOTLIRE");
        /* pObj.w_SOSMEZPAG := cgo_operazioni_storico->MEZPAGAM */
        pObj.w_SOSMEZPAG = Cursor_cgo_operazioni_storico.GetString("MEZPAGAM");
        /* pObj.w_SOSCLIECOG := cgo_operazioni_storico->COGNOME */
        pObj.w_SOSCLIECOG = Cursor_cgo_operazioni_storico.GetString("COGNOME");
        /* pObj.w_SOSCLIENOM := cgo_operazioni_storico->NOME */
        pObj.w_SOSCLIENOM = Cursor_cgo_operazioni_storico.GetString("NOME");
        /* pObj.w_SOSCLIEPN := cgo_operazioni_storico->TIPINTER */
        pObj.w_SOSCLIEPN = Cursor_cgo_operazioni_storico.GetString("TIPINTER");
        /* pObj.w_SOSCLIELN := iif(cgo_operazioni_storico->TIPINTER='EE',cgo_operazioni_storico->NASSTATO,cgo_operazioni_storico->NASCOMUN) */
        pObj.w_SOSCLIELN = (CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("TIPINTER"),"EE")?Cursor_cgo_operazioni_storico.GetString("NASSTATO"):Cursor_cgo_operazioni_storico.GetString("NASCOMUN"));
        /* pObj.w_SOSCLIEDN := cgo_operazioni_storico->DATANASC */
        pObj.w_SOSCLIEDN = Cursor_cgo_operazioni_storico.GetDate("DATANASC");
        /* pObj.w_SOSCLIESX := iif(cgo_operazioni_storico->SESSO='1','M','F') */
        pObj.w_SOSCLIESX = (CPLib.eqr(Cursor_cgo_operazioni_storico.GetString("SESSO"),"1")?"M":"F");
        /* pObj.w_SOSCLIECF := cgo_operazioni_storico->CODFISC */
        pObj.w_SOSCLIECF = Cursor_cgo_operazioni_storico.GetString("CODFISC");
        /* pObj.Set_SOSCLIEPAE(cgo_operazioni_storico->PAESE) */
        pObj.Set_SOSCLIEPAE(Cursor_cgo_operazioni_storico.GetString("PAESE"));
        /* pObj.w_SOSCLIEIND := cgo_operazioni_storico->DOMICILIO */
        pObj.w_SOSCLIEIND = Cursor_cgo_operazioni_storico.GetString("DOMICILIO");
        /* pObj.w_SOSCLIECR := cgo_operazioni_storico->DESCCIT */
        pObj.w_SOSCLIECR = Cursor_cgo_operazioni_storico.GetString("DESCCIT");
        /* pObj.w_SOSCLIECAR := cgo_operazioni_storico->CAP */
        pObj.w_SOSCLIECAR = Cursor_cgo_operazioni_storico.GetString("CAP");
        /* pObj.w_SOSCLIEPR := cgo_operazioni_storico->PROVINCIA */
        pObj.w_SOSCLIEPR = Cursor_cgo_operazioni_storico.GetString("PROVINCIA");
        /* pObj.w_SOSCLIETD := cgo_operazioni_storico->TIPODOC */
        pObj.w_SOSCLIETD = Cursor_cgo_operazioni_storico.GetString("TIPODOC");
        /* pObj.w_SOSCLIEND := cgo_operazioni_storico->NUMDOCUM */
        pObj.w_SOSCLIEND = Cursor_cgo_operazioni_storico.GetString("NUMDOCUM");
        /* pObj.w_SOSCLIEDRD := cgo_operazioni_storico->DATARILASC */
        pObj.w_SOSCLIEDRD = Cursor_cgo_operazioni_storico.GetDate("DATARILASC");
        /* pObj.w_SOSCLIEDSD := cgo_operazioni_storico->DATAVALI */
        pObj.w_SOSCLIEDSD = Cursor_cgo_operazioni_storico.GetDate("DATAVALI");
        /* pObj.w_SOSCLIEAUD := cgo_operazioni_storico->AUTRILASC */
        pObj.w_SOSCLIEAUD = Cursor_cgo_operazioni_storico.GetString("AUTRILASC");
        /* pObj.w_SOSTIPOOP := cgo_operazioni_storico->CAFLGOPE */
        pObj.w_SOSTIPOOP = Cursor_cgo_operazioni_storico.GetString("CAFLGOPE");
        Cursor_cgo_operazioni_storico.Next();
      }
      m_cConnectivityError = Cursor_cgo_operazioni_storico.ErrorMessage();
      Cursor_cgo_operazioni_storico.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cgo_operazioni_storico!=null)
          Cursor_cgo_operazioni_storico.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(armt_cgo_sosBL p_pObj) {
    pObj = p_pObj;
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
  public Forward Run(armt_cgo_sosBL p_pObj) {
    pObj = p_pObj;
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
  public static arrt_cgo_sos_bigliettoR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_sos_bigliettoR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pObj = null;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pObj"};
}