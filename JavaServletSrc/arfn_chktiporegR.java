// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_chktiporegR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String m_cPhName_tbtipreg;
  public String m_cServer_tbtipreg;
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
  public java.sql.Date pData;
  public String pOper;
  public boolean bRitorno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_chktiporegR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arfn_chktiporeg",m_Caller);
    m_cPhName_tbtipreg = p_ContextObject.GetPhName("tbtipreg");
    if (m_cPhName_tbtipreg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipreg = m_cPhName_tbtipreg+" "+m_Ctx.GetWritePhName("tbtipreg");
    }
    m_cServer_tbtipreg = p_ContextObject.GetServer("tbtipreg");
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
      return "arfn_chktiporeg";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pOper",p_cVarName)) {
      return pOper;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pData",p_cVarName)) {
      return pData;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      return bRitorno;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pData",p_cVarName)) {
      pData = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      bRitorno = value;
      return;
    }
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
    CPResultSet Cursor_tbtipreg=null;
    try {
      /* pData Date // Data Operazione */
      /* pOper Char(2) // Tipo Registrazione */
      /* bRitorno Bool */
      /* bRitorno := True */
      bRitorno = true;
      // * --- Select from tbtipreg
      m_cServer = m_Ctx.GetServer("tbtipreg");
      m_cPhName = m_Ctx.GetPhName("tbtipreg");
      if (Cursor_tbtipreg!=null)
        Cursor_tbtipreg.Close();
      Cursor_tbtipreg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pOper,"?",0,0,m_cServer, m_oParameters),m_cServer,pOper)+" "+")"+(m_Ctx.IsSharedTemp("tbtipreg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tbtipreg.Eof())) {
        /* Case not(Empty(tbtipreg->DATAINI)) and Empty(tbtipreg->DATAFINE) */
        if ( ! (CPLib.Empty(Cursor_tbtipreg.GetDate("DATAINI"))) && CPLib.Empty(Cursor_tbtipreg.GetDate("DATAFINE"))) {
          /* If pData < tbtipreg->DATAINI */
          if (CPLib.lt(pData,Cursor_tbtipreg.GetDate("DATAINI"))) {
            /* bRitorno := False */
            bRitorno = false;
            /* Error Msg 'Tipo operazione non valido per la data registrazione indicata' */
            m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"Tipo operazione non valido per la data registrazione indicata");
            new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
          } // End If
          /* Case Empty(tbtipreg->DATAINI) and not(Empty(tbtipreg->DATAFINE)) */
        } else if (CPLib.Empty(Cursor_tbtipreg.GetDate("DATAINI")) &&  ! (CPLib.Empty(Cursor_tbtipreg.GetDate("DATAFINE")))) {
          /* If pData > tbtipreg->DATAFINE */
          if (CPLib.gt(pData,Cursor_tbtipreg.GetDate("DATAFINE"))) {
            /* bRitorno := False */
            bRitorno = false;
            /* Error Msg 'Tipo operazione non valido per la data registrazione indicata' */
            m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"Tipo operazione non valido per la data registrazione indicata");
            new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
          } // End If
          /* Case not(Empty(tbtipreg->DATAINI)) and not(Empty(tbtipreg->DATAFINE)) */
        } else if ( ! (CPLib.Empty(Cursor_tbtipreg.GetDate("DATAINI"))) &&  ! (CPLib.Empty(Cursor_tbtipreg.GetDate("DATAFINE")))) {
          /* If not(pData >= tbtipreg->DATAINI and pData <= tbtipreg->DATAFINE) */
          if ( ! (CPLib.ge(pData,Cursor_tbtipreg.GetDate("DATAINI")) && CPLib.le(pData,Cursor_tbtipreg.GetDate("DATAFINE")))) {
            /* bRitorno := False */
            bRitorno = false;
            /* Error Msg 'Tipo operazione non valido per la data registrazione indicata' */
            m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"Tipo operazione non valido per la data registrazione indicata");
            new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
          } // End If
        } // End Case
        Cursor_tbtipreg.Next();
      }
      m_cConnectivityError = Cursor_tbtipreg.ErrorMessage();
      Cursor_tbtipreg.Close();
      // * --- End Select
      /* Return bRitorno */
      throw new Stop(bRitorno);
    } finally {
      try {
        if (Cursor_tbtipreg!=null)
          Cursor_tbtipreg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_pData,String p_pOper) {
    pData = p_pData;
    pOper = p_pOper;
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
    );
  }
  public boolean Run(java.sql.Date p_pData,String p_pOper) {
    pData = p_pData;
    pOper = p_pOper;
    return Run();
  }
  public boolean Run() {
    boolean l_result;
    l_result = false;
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
        l_result = stop_value.GetLogic();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = false;
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
  public static arfn_chktiporegR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_chktiporegR(p_Ctx, p_Caller);
  }
  public static arfn_chktiporegR Make(CPContext p_Ctx) {
    return new arfn_chktiporegR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pData = CPLib.NullDate();
    pOper = CPLib.Space(2);
    bRitorno = false;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chktiporeg,
  public static final String i_InvokedRoutines = ",arfn_chktiporeg,";
  public static String[] m_cRunParameterNames={"pData","pOper"};
}
