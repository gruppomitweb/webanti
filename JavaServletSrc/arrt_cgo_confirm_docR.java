// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_confirm_docR implements CallerWithObjs {
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
  public String m_cPhName_cgo_docope;
  public String m_cServer_cgo_docope;
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
  public String pIDDOC;
  public String xOld0;
  public String xOld1;
  public String xOld2;
  public String xOld3;
  public String xOld4;
  public String xOld5;
  public String xOld6;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_confirm_docR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_confirm_doc",m_Caller);
    m_cPhName_cgo_docope = p_ContextObject.GetPhName("cgo_docope");
    if (m_cPhName_cgo_docope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_docope = m_cPhName_cgo_docope+" "+m_Ctx.GetWritePhName("cgo_docope");
    }
    m_cServer_cgo_docope = p_ContextObject.GetServer("cgo_docope");
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
      return "arrt_cgo_confirm_doc";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pIDDOC",p_cVarName)) {
      return pIDDOC;
    }
    if (CPLib.eqr("xOld0",p_cVarName)) {
      return xOld0;
    }
    if (CPLib.eqr("xOld1",p_cVarName)) {
      return xOld1;
    }
    if (CPLib.eqr("xOld2",p_cVarName)) {
      return xOld2;
    }
    if (CPLib.eqr("xOld3",p_cVarName)) {
      return xOld3;
    }
    if (CPLib.eqr("xOld4",p_cVarName)) {
      return xOld4;
    }
    if (CPLib.eqr("xOld5",p_cVarName)) {
      return xOld5;
    }
    if (CPLib.eqr("xOld6",p_cVarName)) {
      return xOld6;
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
    if (CPLib.eqr("pIDDOC",p_cVarName)) {
      pIDDOC = value;
      return;
    }
    if (CPLib.eqr("xOld0",p_cVarName)) {
      xOld0 = value;
      return;
    }
    if (CPLib.eqr("xOld1",p_cVarName)) {
      xOld1 = value;
      return;
    }
    if (CPLib.eqr("xOld2",p_cVarName)) {
      xOld2 = value;
      return;
    }
    if (CPLib.eqr("xOld3",p_cVarName)) {
      xOld3 = value;
      return;
    }
    if (CPLib.eqr("xOld4",p_cVarName)) {
      xOld4 = value;
      return;
    }
    if (CPLib.eqr("xOld5",p_cVarName)) {
      xOld5 = value;
      return;
    }
    if (CPLib.eqr("xOld6",p_cVarName)) {
      xOld6 = value;
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
    CPResultSet Cursor_cgo_docope=null;
    try {
      /* pIDDOC Char(36) */
      /* xOld0 Char(1) // Documento Unico */
      /* xOld1 Char(1) // Documento 1 */
      /* xOld2 Char(1) // Documento 2 */
      /* xOld3 Char(1) // Documento 3 */
      /* xOld4 Char(1) // Documento 4 */
      /* xOld5 Char(1) // Documento 5 */
      /* xOld6 Char(1) // Documento 6 */
      // * --- Select from cgo_docope
      m_cServer = m_Ctx.GetServer("cgo_docope");
      m_cPhName = m_Ctx.GetPhName("cgo_docope");
      if (Cursor_cgo_docope!=null)
        Cursor_cgo_docope.Close();
      Cursor_cgo_docope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DCNUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"?",0,0,m_cServer, m_oParameters),m_cServer,pIDDOC)+" "+")"+(m_Ctx.IsSharedTemp("cgo_docope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_docope.Eof())) {
        /* xOld0 := iif(cgo_docope->DCDOCNEW0='X','S',cgo_docope->DCDOCNEW0) // Documento Unico */
        xOld0 = (CPLib.eqr(Cursor_cgo_docope.GetString("DCDOCNEW0"),"X")?"S":Cursor_cgo_docope.GetString("DCDOCNEW0"));
        /* xOld1 := iif(cgo_docope->DCDOCNEW1='X','S',cgo_docope->DCDOCNEW1) // Documento 1 */
        xOld1 = (CPLib.eqr(Cursor_cgo_docope.GetString("DCDOCNEW1"),"X")?"S":Cursor_cgo_docope.GetString("DCDOCNEW1"));
        /* xOld2 := iif(cgo_docope->DCDOCNEW2='X','S',cgo_docope->DCDOCNEW2) // Documento 2 */
        xOld2 = (CPLib.eqr(Cursor_cgo_docope.GetString("DCDOCNEW2"),"X")?"S":Cursor_cgo_docope.GetString("DCDOCNEW2"));
        /* xOld3 := iif(cgo_docope->DCDOCNEW3='X','S',cgo_docope->DCDOCNEW3) // Documento 3 */
        xOld3 = (CPLib.eqr(Cursor_cgo_docope.GetString("DCDOCNEW3"),"X")?"S":Cursor_cgo_docope.GetString("DCDOCNEW3"));
        /* xOld4 := iif(cgo_docope->DCDOCNEW4='X','S',cgo_docope->DCDOCNEW4) // Documento 4 */
        xOld4 = (CPLib.eqr(Cursor_cgo_docope.GetString("DCDOCNEW4"),"X")?"S":Cursor_cgo_docope.GetString("DCDOCNEW4"));
        /* xOld5 := iif(cgo_docope->DCDOCNEW5='X','S',cgo_docope->DCDOCNEW5) // Documento 5 */
        xOld5 = (CPLib.eqr(Cursor_cgo_docope.GetString("DCDOCNEW5"),"X")?"S":Cursor_cgo_docope.GetString("DCDOCNEW5"));
        /* xOld6 := iif(cgo_docope->DCDOCNEW6='X','S',cgo_docope->DCDOCNEW6) // Documento 6 */
        xOld6 = (CPLib.eqr(Cursor_cgo_docope.GetString("DCDOCNEW6"),"X")?"S":Cursor_cgo_docope.GetString("DCDOCNEW6"));
        // * --- Write into cgo_docope from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_docope");
        m_cPhName = m_Ctx.GetPhName("cgo_docope");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_confirm_doc",2,"00000014")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"DCDOCNEW0 = "+CPLib.ToSQL(xOld0,"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"DCDOCNEW1 = "+CPLib.ToSQL(xOld1,"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"DCDOCNEW2 = "+CPLib.ToSQL(xOld2,"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"DCDOCNEW3 = "+CPLib.ToSQL(xOld3,"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"DCDOCNEW4 = "+CPLib.ToSQL(xOld4,"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"DCDOCNEW5 = "+CPLib.ToSQL(xOld5,"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"DCDOCNEW6 = "+CPLib.ToSQL(xOld6,"C",1,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_docope",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"DCNUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"?",0,0,m_cServer),m_cServer,pIDDOC)+"";
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
        Cursor_cgo_docope.Next();
      }
      m_cConnectivityError = Cursor_cgo_docope.ErrorMessage();
      Cursor_cgo_docope.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cgo_docope!=null)
          Cursor_cgo_docope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pIDDOC) {
    pIDDOC = p_pIDDOC;
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
  public Forward Run(String p_pIDDOC) {
    pIDDOC = p_pIDDOC;
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
  public static arrt_cgo_confirm_docR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_confirm_docR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pIDDOC = CPLib.Space(36);
    xOld0 = CPLib.Space(1);
    xOld1 = CPLib.Space(1);
    xOld2 = CPLib.Space(1);
    xOld3 = CPLib.Space(1);
    xOld4 = CPLib.Space(1);
    xOld5 = CPLib.Space(1);
    xOld6 = CPLib.Space(1);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pIDDOC"};
}
