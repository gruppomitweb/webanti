// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_cgo_confread_infbachecaR implements CallerWithObjs {
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
  public String m_cPhName_cgo_infbacheca_usr;
  public String m_cServer_cgo_infbacheca_usr;
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
  public double pInfo;
  public String cRitorno;
  public double _utente;
  public double gUserCode;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_cgo_confread_infbachecaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_cgo_confread_infbacheca",m_Caller);
    m_cPhName_cgo_infbacheca_usr = p_ContextObject.GetPhName("cgo_infbacheca_usr");
    if (m_cPhName_cgo_infbacheca_usr.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_infbacheca_usr = m_cPhName_cgo_infbacheca_usr+" "+m_Ctx.GetWritePhName("cgo_infbacheca_usr");
    }
    m_cServer_cgo_infbacheca_usr = p_ContextObject.GetServer("cgo_infbacheca_usr");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pInfo",p_cVarName)) {
      return pInfo;
    }
    if (CPLib.eqr("_utente",p_cVarName)) {
      return _utente;
    }
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      return gUserCode;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_cgo_confread_infbacheca";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
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
    if (CPLib.eqr("pInfo",p_cVarName)) {
      pInfo = value;
      return;
    }
    if (CPLib.eqr("_utente",p_cVarName)) {
      _utente = value;
      return;
    }
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      gUserCode = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
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
    try {
      /* pInfo Numeric(10, 0) */
      /* cRitorno Char(2) // Valore di ritorno */
      /* _utente Numeric(10, 0) */
      /* gUserCode Numeric(4, 0) // Codice Utente CP */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000009status;
      nTry00000009status = m_Sql.GetTransactionStatus();
      String cTry00000009msg;
      cTry00000009msg = m_Sql.TransactionErrorMessage();
      try {
        /* _utente := 0 */
        _utente = CPLib.Round(0,0);
        // * --- Read from cgo_infbacheca_usr
        m_cServer = m_Ctx.GetServer("cgo_infbacheca_usr");
        m_cPhName = m_Ctx.GetPhName("cgo_infbacheca_usr");
        m_cSql = "";
        m_cSql = m_cSql+"IBUCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pInfo,"N",10,0,m_cServer),m_cServer,pInfo);
        m_cSql = m_cSql+" and IBUCODUSR="+CPSql.SQLValueAdapter(CPLib.ToSQL(gUserCode,"N",10,0,m_cServer),m_cServer,gUserCode);
        if (m_Ctx.IsSharedTemp("cgo_infbacheca_usr")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IBUCODUSR",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _utente = CPLib.Round(Read_Cursor.GetDouble("IBUCODUSR"),0);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cgo_infbacheca_usr into routine arfn_cgo_confread_infbacheca returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _utente = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* If _utente=0 */
        if (CPLib.eqr(_utente,0)) {
          // * --- Insert into cgo_infbacheca_usr from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_infbacheca_usr");
          m_cPhName = m_Ctx.GetPhName("cgo_infbacheca_usr");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_infbacheca_usr",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_cgo_confread_infbacheca",2,"0000000E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000000E(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(pInfo,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(gUserCode,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_infbacheca_usr",true);
          m_cSql = m_cSql+")";
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
        } // End If
        /* cRitorno := 'OK' // Valore di ritorno */
        cRitorno = "OK";
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* cRitorno := 'KO' // Valore di ritorno */
        cRitorno = "KO";
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
    }
  }
  void _init_() {
  }
  public String RunAsync(double p_pInfo) {
    pInfo = p_pInfo;
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
  public String Run(double p_pInfo) {
    pInfo = p_pInfo;
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
  public static arfn_cgo_confread_infbachecaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_cgo_confread_infbachecaR(p_Ctx, p_Caller);
  }
  public static arfn_cgo_confread_infbachecaR Make(CPContext p_Ctx) {
    return new arfn_cgo_confread_infbachecaR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pInfo = 0;
    cRitorno = CPLib.Space(2);
    _utente = 0;
    gUserCode=m_Ctx.GetGlobalNumber("gUserCode");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_cgo_confread_infbacheca,
  public static final String i_InvokedRoutines = ",arfn_cgo_confread_infbacheca,";
  public static String[] m_cRunParameterNames={"pInfo"};
  protected static String GetFieldsName_0000000E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IBUCODICE,";
    p_cSql = p_cSql+"IBUCODUSR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_infbacheca_usr",true);
    return p_cSql;
  }
}
