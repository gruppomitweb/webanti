// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_soggope_opeauiR implements CallerWithObjs {
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
  public armt_operazioniBO pObj;
  public String _primo;
  public String _tipoleg;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_soggope_opeauiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_soggope_opeaui",m_Caller);
    m_cPhName_soggope = p_ContextObject.GetPhName("soggope");
    if (m_cPhName_soggope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_soggope = m_cPhName_soggope+" "+m_Ctx.GetWritePhName("soggope");
    }
    m_cServer_soggope = p_ContextObject.GetServer("soggope");
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
      return "arrt_soggope_opeaui";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_primo",p_cVarName)) {
      return _primo;
    }
    if (CPLib.eqr("_tipoleg",p_cVarName)) {
      return _tipoleg;
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
    if (CPLib.eqr("_primo",p_cVarName)) {
      _primo = value;
      return;
    }
    if (CPLib.eqr("_tipoleg",p_cVarName)) {
      _tipoleg = value;
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
    CPResultSet Cursor_soggope=null;
    try {
      /* pObj Object(armt_operazioniBO) */
      /* _primo Char(16) // Primo Esecutore che va nel form */
      /* _tipoleg Char(1) // Tipo Legame */
      // * --- Select from soggope
      m_cServer = m_Ctx.GetServer("soggope");
      m_cPhName = m_Ctx.GetPhName("soggope");
      if (Cursor_soggope!=null)
        Cursor_soggope.Close();
      Cursor_soggope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,TIPOLEG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_CONNESCLI,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_CONNESCLI)+"  and  RUOLO='O'  and  ([NOTEMPTYDATE(DATAINI)]=0  or  DATAINI <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_DATAOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_DATAOPE)+")  and  ([NOTEMPTYDATE(DATAFINE)]=0  or  DATAFINE >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_DATAOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_DATAOPE)+") "+")"+(m_Ctx.IsSharedTemp("soggope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_soggope.Eof())) {
        /* If Empty(_primo) */
        if (CPLib.Empty(_primo)) {
          /* _primo := soggope->CODINTER // Primo Esecutore che va nel form */
          _primo = Cursor_soggope.GetString("CODINTER");
          /* _tipoleg := soggope->TIPOLEG // Tipo Legame */
          _tipoleg = Cursor_soggope.GetString("TIPOLEG");
        } // End If
        /* If soggope->PRIMO=1 */
        if (CPLib.eqr(Cursor_soggope.GetDouble("PRIMO"),1)) {
          /* _primo := soggope->CODINTER // Primo Esecutore che va nel form */
          _primo = Cursor_soggope.GetString("CODINTER");
          /* _tipoleg := soggope->TIPOLEG // Tipo Legame */
          _tipoleg = Cursor_soggope.GetString("TIPOLEG");
          // Exit Loop
          if (true) {
            break;
          }
        } // End If
        Cursor_soggope.Next();
      }
      m_cConnectivityError = Cursor_soggope.ErrorMessage();
      Cursor_soggope.Close();
      // * --- End Select
      // * --- Select from soggope
      m_cServer = m_Ctx.GetServer("soggope");
      m_cPhName = m_Ctx.GetPhName("soggope");
      if (Cursor_soggope!=null)
        Cursor_soggope.Close();
      Cursor_soggope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,TIPOLEG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_CONNESCLI,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_CONNESCLI)+"  and  RUOLO='O'  and  ([NOTEMPTYDATE(DATAINI)]=0  or  DATAINI <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_DATAOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_DATAOPE)+")  and  ([NOTEMPTYDATE(DATAFINE)]=0  or  DATAFINE >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_DATAOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_DATAOPE)+") "+")"+(m_Ctx.IsSharedTemp("soggope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_soggope.Eof())) {
        /* pObj.Set_CONNESOPER(_primo) */
        pObj.Set_CONNESOPER(_primo);
        /* pObj.Set_TIPOLEG(_tipoleg) */
        pObj.Set_TIPOLEG(_tipoleg);
        /* If soggope->CODINTER<>_primo */
        if (CPLib.ne(Cursor_soggope.GetString("CODINTER"),_primo)) {
          /* pObj.ardt_sogope.AddRow() */
          pObj.ardt_sogope.AddRow();
          /* pObj.ardt_sogope.Set_CODSOG(soggope->CODINTER) */
          pObj.ardt_sogope.Set_CODSOG(Cursor_soggope.GetString("CODINTER"));
          /* pObj.ardt_sogope.Set_LEGAME(soggope->TIPOLEG) */
          pObj.ardt_sogope.Set_LEGAME(Cursor_soggope.GetString("TIPOLEG"));
          /* pObj.ardt_sogope.SaveRow() */
          pObj.ardt_sogope.SaveRow();
        } // End If
        Cursor_soggope.Next();
      }
      m_cConnectivityError = Cursor_soggope.ErrorMessage();
      Cursor_soggope.Close();
      // * --- End Select
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
  public String RunAsync(armt_operazioniBO p_pObj) {
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
  public Forward Run(armt_operazioniBO p_pObj) {
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
  public static arrt_soggope_opeauiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_soggope_opeauiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pObj = null;
    _primo = CPLib.Space(16);
    _tipoleg = CPLib.Space(1);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pObj"};
}
