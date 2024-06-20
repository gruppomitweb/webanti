// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_calcola_datarevprofR implements CallerWithObjs {
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
  public String m_cPhName_tbrisglob;
  public String m_cServer_tbrisglob;
  public String m_cPhName_categris;
  public String m_cServer_categris;
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
  public armt_personboBO pObj;
  public double _giorni;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_calcola_datarevprofR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_calcola_datarevprof",m_Caller);
    m_cPhName_tbrisglob = p_ContextObject.GetPhName("tbrisglob");
    if (m_cPhName_tbrisglob.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbrisglob = m_cPhName_tbrisglob+" "+m_Ctx.GetWritePhName("tbrisglob");
    }
    m_cServer_tbrisglob = p_ContextObject.GetServer("tbrisglob");
    m_cPhName_categris = p_ContextObject.GetPhName("categris");
    if (m_cPhName_categris.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_categris = m_cPhName_categris+" "+m_Ctx.GetWritePhName("categris");
    }
    m_cServer_categris = p_ContextObject.GetServer("categris");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_giorni",p_cVarName)) {
      return _giorni;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_calcola_datarevprof";
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
    if (CPLib.eqr("_giorni",p_cVarName)) {
      _giorni = value;
      return;
    }
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
    CPResultSet Read_Cursor=null;
    try {
      /* pObj Object(armt_personboBO) */
      /* _giorni Numeric(5, 0) := 0 */
      _giorni = CPLib.Round(0,0);
      /* pObj.CtxLoad_armt_personbo_agg() */
      pObj.CtxLoad_armt_personbo_agg();
      /* If Empty(LRTrim(pObj.armt_personbo_agg.w_CATEG01)+LRTrim(pObj.armt_personbo_agg.w_CATEG02)+LRTrim(pObj.armt_personbo_agg.w_CATEG03)+LRTrim(pObj.armt_personbo_agg.w_CATEG04)+LRTrim(pObj.armt_personbo_agg.w_CATEG05)) */
      if (CPLib.Empty(CPLib.LRTrim(pObj.armt_personbo_agg.w_CATEG01)+CPLib.LRTrim(pObj.armt_personbo_agg.w_CATEG02)+CPLib.LRTrim(pObj.armt_personbo_agg.w_CATEG03)+CPLib.LRTrim(pObj.armt_personbo_agg.w_CATEG04)+CPLib.LRTrim(pObj.armt_personbo_agg.w_CATEG05))) {
        // * --- Read from tbrisglob
        m_cServer = m_Ctx.GetServer("tbrisglob");
        m_cPhName = m_Ctx.GetPhName("tbrisglob");
        m_cSql = "";
        m_cSql = m_cSql+"CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_RISGLOB,"C",3,0,m_cServer),m_cServer,pObj.w_RISGLOB);
        if (m_Ctx.IsSharedTemp("tbrisglob")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("GIORNI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _giorni = CPLib.Round(Read_Cursor.GetDouble("GIORNI"),0);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbrisglob into routine arrt_calcola_datarevprof returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _giorni = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
      } else { // Else
        /* If not(Empty(pObj.armt_personbo_agg.w_CATEG01)) */
        if ( ! (CPLib.Empty(pObj.armt_personbo_agg.w_CATEG01))) {
          // * --- Read from categris
          m_cServer = m_Ctx.GetServer("categris");
          m_cPhName = m_Ctx.GetPhName("categris");
          m_cSql = "";
          m_cSql = m_cSql+"IDCATEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.armt_personbo_agg.w_CATEG01,"C",10,0,m_cServer),m_cServer,pObj.armt_personbo_agg.w_CATEG01);
          m_cSql = m_cSql+" and CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_RISGLOB,"C",3,0,m_cServer),m_cServer,pObj.w_RISGLOB);
          if (m_Ctx.IsSharedTemp("categris")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("GIORNI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _giorni = CPLib.Round(Read_Cursor.GetDouble("GIORNI"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on categris into routine arrt_calcola_datarevprof returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _giorni = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
        } else { // Else
          /* If not(Empty(pObj.armt_personbo_agg.w_CATEG02)) */
          if ( ! (CPLib.Empty(pObj.armt_personbo_agg.w_CATEG02))) {
            // * --- Read from categris
            m_cServer = m_Ctx.GetServer("categris");
            m_cPhName = m_Ctx.GetPhName("categris");
            m_cSql = "";
            m_cSql = m_cSql+"IDCATEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.armt_personbo_agg.w_CATEG02,"C",10,0,m_cServer),m_cServer,pObj.armt_personbo_agg.w_CATEG02);
            m_cSql = m_cSql+" and CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_RISGLOB,"C",3,0,m_cServer),m_cServer,pObj.w_RISGLOB);
            if (m_Ctx.IsSharedTemp("categris")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("GIORNI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _giorni = CPLib.Round(Read_Cursor.GetDouble("GIORNI"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on categris into routine arrt_calcola_datarevprof returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _giorni = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } else { // Else
            /* If not(Empty(pObj.armt_personbo_agg.w_CATEG03)) */
            if ( ! (CPLib.Empty(pObj.armt_personbo_agg.w_CATEG03))) {
              // * --- Read from categris
              m_cServer = m_Ctx.GetServer("categris");
              m_cPhName = m_Ctx.GetPhName("categris");
              m_cSql = "";
              m_cSql = m_cSql+"IDCATEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.armt_personbo_agg.w_CATEG03,"C",10,0,m_cServer),m_cServer,pObj.armt_personbo_agg.w_CATEG03);
              m_cSql = m_cSql+" and CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_RISGLOB,"C",3,0,m_cServer),m_cServer,pObj.w_RISGLOB);
              if (m_Ctx.IsSharedTemp("categris")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("GIORNI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _giorni = CPLib.Round(Read_Cursor.GetDouble("GIORNI"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on categris into routine arrt_calcola_datarevprof returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _giorni = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } else { // Else
              /* If not(Empty(pObj.armt_personbo_agg.w_CATEG04)) */
              if ( ! (CPLib.Empty(pObj.armt_personbo_agg.w_CATEG04))) {
                // * --- Read from categris
                m_cServer = m_Ctx.GetServer("categris");
                m_cPhName = m_Ctx.GetPhName("categris");
                m_cSql = "";
                m_cSql = m_cSql+"IDCATEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.armt_personbo_agg.w_CATEG04,"C",10,0,m_cServer),m_cServer,pObj.armt_personbo_agg.w_CATEG04);
                m_cSql = m_cSql+" and CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_RISGLOB,"C",3,0,m_cServer),m_cServer,pObj.w_RISGLOB);
                if (m_Ctx.IsSharedTemp("categris")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("GIORNI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _giorni = CPLib.Round(Read_Cursor.GetDouble("GIORNI"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on categris into routine arrt_calcola_datarevprof returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _giorni = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } else { // Else
                /* If not(Empty(pObj.armt_personbo_agg.w_CATEG05)) */
                if ( ! (CPLib.Empty(pObj.armt_personbo_agg.w_CATEG05))) {
                  // * --- Read from categris
                  m_cServer = m_Ctx.GetServer("categris");
                  m_cPhName = m_Ctx.GetPhName("categris");
                  m_cSql = "";
                  m_cSql = m_cSql+"IDCATEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.armt_personbo_agg.w_CATEG05,"C",10,0,m_cServer),m_cServer,pObj.armt_personbo_agg.w_CATEG05);
                  m_cSql = m_cSql+" and CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_RISGLOB,"C",3,0,m_cServer),m_cServer,pObj.w_RISGLOB);
                  if (m_Ctx.IsSharedTemp("categris")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("GIORNI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _giorni = CPLib.Round(Read_Cursor.GetDouble("GIORNI"),0);
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on categris into routine arrt_calcola_datarevprof returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _giorni = 0;
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
              } // End If
            } // End If
          } // End If
        } // End If
      } // End If
      /* If _giorni > 0 */
      if (CPLib.gt(_giorni,0)) {
        /* pObj.w_DATAREVPROF := AddDays(pObj.w_DATAPROF,_giorni) */
        pObj.w_DATAREVPROF = CPLib.AddDays(pObj.w_DATAPROF,_giorni);
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
  public String RunAsync(armt_personboBO p_pObj) {
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
  public Forward Run(armt_personboBO p_pObj) {
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
  public static arrt_calcola_datarevprofR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_calcola_datarevprofR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pObj = null;
    _giorni = CPLib.Round(0,0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pObj"};
}
