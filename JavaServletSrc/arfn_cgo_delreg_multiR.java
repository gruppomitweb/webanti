// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_cgo_delreg_multiR implements CallerWithObjs {
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
  public String m_cPhName_cgo_operazioni_dl;
  public String m_cServer_cgo_operazioni_dl;
  public String m_cPhName_cgo_operazioni_dl_multi;
  public String m_cServer_cgo_operazioni_dl_multi;
  public String m_cPhName_cgo_operazioni_dl_multi_dt;
  public String m_cServer_cgo_operazioni_dl_multi_dt;
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
  public String pSNAINUMOPE;
  public String cRitorno;
  public String _iddoc;
  public double _iddoc_ope;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_cgo_delreg_multiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_cgo_delreg_multi",m_Caller);
    m_cPhName_cgo_operazioni_dl = p_ContextObject.GetPhName("cgo_operazioni_dl");
    if (m_cPhName_cgo_operazioni_dl.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl = m_cPhName_cgo_operazioni_dl+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl");
    }
    m_cServer_cgo_operazioni_dl = p_ContextObject.GetServer("cgo_operazioni_dl");
    m_cPhName_cgo_operazioni_dl_multi = p_ContextObject.GetPhName("cgo_operazioni_dl_multi");
    if (m_cPhName_cgo_operazioni_dl_multi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi = m_cPhName_cgo_operazioni_dl_multi+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi");
    }
    m_cServer_cgo_operazioni_dl_multi = p_ContextObject.GetServer("cgo_operazioni_dl_multi");
    m_cPhName_cgo_operazioni_dl_multi_dt = p_ContextObject.GetPhName("cgo_operazioni_dl_multi_dt");
    if (m_cPhName_cgo_operazioni_dl_multi_dt.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi_dt = m_cPhName_cgo_operazioni_dl_multi_dt+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi_dt");
    }
    m_cServer_cgo_operazioni_dl_multi_dt = p_ContextObject.GetServer("cgo_operazioni_dl_multi_dt");
    m_cPhName_cgo_docope = p_ContextObject.GetPhName("cgo_docope");
    if (m_cPhName_cgo_docope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_docope = m_cPhName_cgo_docope+" "+m_Ctx.GetWritePhName("cgo_docope");
    }
    m_cServer_cgo_docope = p_ContextObject.GetServer("cgo_docope");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_iddoc_ope",p_cVarName)) {
      return _iddoc_ope;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_cgo_delreg_multi";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pSNAINUMOPE",p_cVarName)) {
      return pSNAINUMOPE;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_iddoc",p_cVarName)) {
      return _iddoc;
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
    if (CPLib.eqr("_iddoc_ope",p_cVarName)) {
      _iddoc_ope = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pSNAINUMOPE",p_cVarName)) {
      pSNAINUMOPE = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_iddoc",p_cVarName)) {
      _iddoc = value;
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
    CPResultSet Cursor_cgo_docope=null;
    try {
      /* pSNAINUMOPE Char(15) */
      /* cRitorno Char(0) */
      /* _iddoc Char(36) */
      /* _iddoc_ope Numeric(1, 0) */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000009status;
      nTry00000009status = m_Sql.GetTransactionStatus();
      String cTry00000009msg;
      cTry00000009msg = m_Sql.TransactionErrorMessage();
      try {
        /* _iddoc := '' */
        _iddoc = "";
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
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDDOCALL",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _iddoc = Read_Cursor.GetString("IDDOCALL");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cgo_operazioni_dl_multi into routine arfn_cgo_delreg_multi returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _iddoc = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* _iddoc_ope := 0 */
        _iddoc_ope = CPLib.Round(0,0);
        // * --- Select from cgo_docope
        m_cServer = m_Ctx.GetServer("cgo_docope");
        m_cPhName = m_Ctx.GetPhName("cgo_docope");
        if (Cursor_cgo_docope!=null)
          Cursor_cgo_docope.Close();
        Cursor_cgo_docope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DCNUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_iddoc)+" "+")"+(m_Ctx.IsSharedTemp("cgo_docope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_docope.Eof())) {
          /* _iddoc_ope := 1 */
          _iddoc_ope = CPLib.Round(1,0);
          /* If Len(LRTrim(cgo_docope->DCDOCUNICO)+LRTrim(cgo_docope->DCDOCNOM1)+LRTrim(cgo_docope->DCDOCNOM2)+LRTrim(cgo_docope->DCDOCNOM3)+LRTrim(cgo_docope->DCDOCNOM4)+LRTrim(cgo_docope->DCDOCNOM5)+LRTrim(cgo_docope->DCDOCNOM6)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCUNICO"))+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM1"))+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM2"))+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM3"))+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM4"))+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM5"))+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM6"))),0)) {
            /* _iddoc_ope := 2 */
            _iddoc_ope = CPLib.Round(2,0);
          } // End If
          Cursor_cgo_docope.Next();
        }
        m_cConnectivityError = Cursor_cgo_docope.ErrorMessage();
        Cursor_cgo_docope.Close();
        // * --- End Select
        /* If _iddoc_ope=1 or _iddoc_ope=0 */
        if (CPLib.eqr(_iddoc_ope,1) || CPLib.eqr(_iddoc_ope,0)) {
          // * --- Delete from cgo_docope
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_docope");
          m_cPhName = m_Ctx.GetPhName("cgo_docope");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_cgo_delreg_multi",41,"00000012")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"DCNUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddoc,"?",0,0,m_cServer),m_cServer,_iddoc)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          // * --- Delete from cgo_operazioni_dl_multi_dt
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi_dt",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_cgo_delreg_multi",41,"00000013")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pSNAINUMOPE,"?",0,0,m_cServer),m_cServer,pSNAINUMOPE)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          // * --- Delete from cgo_operazioni_dl_multi
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_cgo_delreg_multi",41,"00000014")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pSNAINUMOPE,"?",0,0,m_cServer),m_cServer,pSNAINUMOPE)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
        } else { // Else
          // Transaction Error
          cTry00000009msg = CPLib.FormatMsg(m_Ctx,"Presenza di documentazione");
          m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Presenza di documentazione"));
          throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Presenza di documentazione"));
        } // End If
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* cRitorno := 'OK' */
        cRitorno = "OK";
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* If _iddoc_ope=2 */
        if (CPLib.eqr(_iddoc_ope,2)) {
          /* cRitorno := 'DE' */
          cRitorno = "DE";
        } else { // Else
          /* cRitorno := 'KO' */
          cRitorno = "KO";
        } // End If
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000009status,0)) {
          m_Sql.SetTransactionStatus(nTry00000009status,cTry00000009msg);
        }
      }
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
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
  public static arfn_cgo_delreg_multiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_cgo_delreg_multiR(p_Ctx, p_Caller);
  }
  public static arfn_cgo_delreg_multiR Make(CPContext p_Ctx) {
    return new arfn_cgo_delreg_multiR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pSNAINUMOPE = CPLib.Space(15);
    cRitorno = CPLib.Space(0);
    _iddoc = CPLib.Space(36);
    _iddoc_ope = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_cgo_delreg_multi,
  public static final String i_InvokedRoutines = ",arfn_cgo_delreg_multi,";
  public static String[] m_cRunParameterNames={"pSNAINUMOPE"};
}
