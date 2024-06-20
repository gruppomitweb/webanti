// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_inf_load_prvR implements CallerWithObjs {
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
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
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
  public armt_provinformazioniBL pObj;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_inf_load_prvR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_inf_load_prv",m_Caller);
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    if (m_cPhName_xelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xelegabo = m_cPhName_xelegabo+" "+m_Ctx.GetWritePhName("xelegabo");
    }
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
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
      return "arrt_inf_load_prv";
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
    CPResultSet Cursor_xelegabo=null;
    CPResultSet Cursor_xntestbo=null;
    try {
      /* pObj Object(armt_provinformazioniBL) */
      /* Crea file appoggio */
      /* pObj.CtxLoad_ardt_provinformazioni() */
      pObj.CtxLoad_ardt_provinformazioni();
      /* pObj.CtxLoad_ardt_pdelegabo() */
      pObj.CtxLoad_ardt_pdelegabo();
      /* If pObj.w_TIPOOPRAP='25' or pObj.w_TIPOOPRAP='28' */
      if (CPLib.eqr(pObj.w_TIPOOPRAP,"25") || CPLib.eqr(pObj.w_TIPOOPRAP,"28")) {
        // * --- Select from xelegabo
        m_cServer = m_Ctx.GetServer("xelegabo");
        m_cPhName = m_Ctx.GetPhName("xelegabo");
        if (Cursor_xelegabo!=null)
          Cursor_xelegabo.Close();
        Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xelegabo.Eof())) {
          /* pObj.ardt_pdelegabo.AddRow() */
          pObj.ardt_pdelegabo.AddRow();
          /* pObj.ardt_pdelegabo.Set_CODINTER(xelegabo->CODINTER) */
          pObj.ardt_pdelegabo.Set_CODINTER(Cursor_xelegabo.GetString("CODINTER"));
          /* pObj.ardt_pdelegabo.Set_DATAINI(xelegabo->DATAINI) */
          pObj.ardt_pdelegabo.Set_DATAINI(Cursor_xelegabo.GetDate("DATAINI"));
          /* pObj.ardt_pdelegabo.Set_DATAFINE(xelegabo->DATAFINE) */
          pObj.ardt_pdelegabo.Set_DATAFINE(Cursor_xelegabo.GetDate("DATAFINE"));
          /* pObj.ardt_pdelegabo.w_IDBASE := xelegabo->IDBASE */
          pObj.ardt_pdelegabo.w_IDBASE = Cursor_xelegabo.GetString("IDBASE");
          /* pObj.ardt_pdelegabo.w_NUMPROG1 := xelegabo->NUMPROG1 */
          pObj.ardt_pdelegabo.w_NUMPROG1 = Cursor_xelegabo.GetString("NUMPROG1");
          /* pObj.ardt_pdelegabo.w_NUMPROG2 := xelegabo->NUMPROG2 */
          pObj.ardt_pdelegabo.w_NUMPROG2 = Cursor_xelegabo.GetString("NUMPROG2");
          /* pObj.ardt_pdelegabo.Calculate() */
          pObj.ardt_pdelegabo.Calculate();
          /* pObj.ardt_pdelegabo.SaveRow() */
          pObj.ardt_pdelegabo.SaveRow();
          Cursor_xelegabo.Next();
        }
        m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
        Cursor_xelegabo.Close();
        // * --- End Select
      } else { // Else
        // * --- Select from xntestbo
        m_cServer = m_Ctx.GetServer("xntestbo");
        m_cPhName = m_Ctx.GetPhName("xntestbo");
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
        Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xntestbo.Eof())) {
          /* pObj.ardt_provinformazioni.AddRow() */
          pObj.ardt_provinformazioni.AddRow();
          /* pObj.ardt_provinformazioni.Set_CODINTER(xntestbo->CODINTER) */
          pObj.ardt_provinformazioni.Set_CODINTER(Cursor_xntestbo.GetString("CODINTER"));
          /* pObj.ardt_provinformazioni.Set_DATAINI(xntestbo->DATAINI) */
          pObj.ardt_provinformazioni.Set_DATAINI(Cursor_xntestbo.GetDate("DATAINI"));
          /* pObj.ardt_provinformazioni.Set_DATAFINE(xntestbo->DATAFINE) */
          pObj.ardt_provinformazioni.Set_DATAFINE(Cursor_xntestbo.GetDate("DATAFINE"));
          /* pObj.ardt_provinformazioni.w_IDBASE := xntestbo->IDBASE */
          pObj.ardt_provinformazioni.w_IDBASE = Cursor_xntestbo.GetString("IDBASE");
          /* pObj.ardt_provinformazioni.w_NUMPROG1 := xntestbo->NUMPROG1 */
          pObj.ardt_provinformazioni.w_NUMPROG1 = Cursor_xntestbo.GetString("NUMPROG1");
          /* pObj.ardt_provinformazioni.w_NUMPROG2 := xntestbo->NUMPROG2 */
          pObj.ardt_provinformazioni.w_NUMPROG2 = Cursor_xntestbo.GetString("NUMPROG2");
          /* pObj.ardt_provinformazioni.Calculate() */
          pObj.ardt_provinformazioni.Calculate();
          /* pObj.ardt_provinformazioni.SaveRow() */
          pObj.ardt_provinformazioni.SaveRow();
          Cursor_xntestbo.Next();
        }
        m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
        Cursor_xntestbo.Close();
        // * --- End Select
      } // End If
      /* pObj.SetUpdated() */
      pObj.SetUpdated();
    } finally {
      try {
        if (Cursor_xelegabo!=null)
          Cursor_xelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(armt_provinformazioniBL p_pObj) {
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
  public Forward Run(armt_provinformazioniBL p_pObj) {
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
  public static arrt_inf_load_prvR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_inf_load_prvR(p_Ctx, p_Caller);
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
