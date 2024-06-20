// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_wu_docscadutiR implements CallerWithObjs {
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
  public String m_cPhName_dersonbo;
  public String m_cServer_dersonbo;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_log_app;
  public String m_cServer_log_app;
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
  public java.sql.Date dDatRif;
  public double _conta;
  public String _msg;
  public String cProg;
  public String _azienda;
  public double _yearref;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_wu_docscadutiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_wu_docscaduti",m_Caller);
    m_cPhName_dersonbo = p_ContextObject.GetPhName("dersonbo");
    if (m_cPhName_dersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_dersonbo = m_cPhName_dersonbo+" "+m_Ctx.GetWritePhName("dersonbo");
    }
    m_cServer_dersonbo = p_ContextObject.GetServer("dersonbo");
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_log_app = p_ContextObject.GetPhName("log_app");
    if (m_cPhName_log_app.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_log_app = m_cPhName_log_app+" "+m_Ctx.GetWritePhName("log_app");
    }
    m_cServer_log_app = p_ContextObject.GetServer("log_app");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_yearref",p_cVarName)) {
      return _yearref;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_wu_docscaduti";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_msg",p_cVarName)) {
      return _msg;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_azienda",p_cVarName)) {
      return _azienda;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("dDatRif",p_cVarName)) {
      return dDatRif;
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
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_yearref",p_cVarName)) {
      _yearref = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_msg",p_cVarName)) {
      _msg = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_azienda",p_cVarName)) {
      _azienda = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("dDatRif",p_cVarName)) {
      dDatRif = value;
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
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_dersonbo=null;
    try {
      /* dDatRif Date */
      /* _conta Numeric(10, 0) */
      /* _msg Memo */
      /* cProg Char(20) */
      /* _azienda Char(10) */
      /* _yearref Numeric(4, 0) */
      /* Info Msg 'Controllo documenti scaduti' */
      if ( ! (CPLib.IsNull(m_Info))) {
        m_Info.log(CPLib.FormatMsg(m_Ctx,"Controllo documenti scaduti"));
      }
      // * --- Select from cpazi
      m_cServer = m_Ctx.GetServer("cpazi");
      m_cPhName = m_Ctx.GetPhName("cpazi");
      if (Cursor_cpazi!=null)
        Cursor_cpazi.Close();
      Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select codazi  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cpazi.Eof())) {
        /* _azienda := cpazi->codazi */
        _azienda = Cursor_cpazi.GetString("codazi");
        Cursor_cpazi.Next();
      }
      m_cConnectivityError = Cursor_cpazi.ErrorMessage();
      Cursor_cpazi.Close();
      // * --- End Select
      /* Utilities.SetCompany(_azienda) */
      Utilities.Make(m_Ctx,m_Caller).SetCompany(_azienda);
      /* Utilities.SetUserCode(1) */
      Utilities.Make(m_Ctx,m_Caller).SetUserCode(1);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000000Fstatus;
      nTry0000000Fstatus = m_Sql.GetTransactionStatus();
      String cTry0000000Fmsg;
      cTry0000000Fmsg = m_Sql.TransactionErrorMessage();
      try {
        /* _msg := 'Ora inizio disabilitazione documenti scaduti: '+arfn_fdatetime(DateTime()) + NL */
        _msg = "Ora inizio disabilitazione documenti scaduti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* dDatRif := Date() */
        dDatRif = CPLib.Date();
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        // * --- Select from dersonbo
        m_cServer = m_Ctx.GetServer("dersonbo");
        m_cPhName = m_Ctx.GetPhName("dersonbo");
        if (Cursor_dersonbo!=null)
          Cursor_dersonbo.Close();
        Cursor_dersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPODOC,NUMDOCUM,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAVALI < "+CPSql.SQLValueAdapter(CPLib.ToSQL(dDatRif,"?",0,0,m_cServer, m_oParameters),m_cServer,dDatRif)+"  and  FLGDISABLED='N' "+")"+(m_Ctx.IsSharedTemp("dersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_dersonbo.Eof())) {
          /* If not(Empty(dersonbo->DATAVALI)) */
          if ( ! (CPLib.Empty(Cursor_dersonbo.GetDate("DATAVALI")))) {
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            // * --- Write into dersonbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("dersonbo");
            m_cPhName = m_Ctx.GetPhName("dersonbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_docscaduti",10,"00000017")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"FLGDISABLED = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dersonbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"TIPODOC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_dersonbo.GetString("TIPODOC"),"?",0,0,m_cServer),m_cServer,Cursor_dersonbo.GetString("TIPODOC"))+"";
            m_cSql = m_cSql+" and NUMDOCUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_dersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer),m_cServer,Cursor_dersonbo.GetString("NUMDOCUM"))+"";
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
          } // End If
          Cursor_dersonbo.Next();
        }
        m_cConnectivityError = Cursor_dersonbo.ErrorMessage();
        Cursor_dersonbo.Close();
        // * --- End Select
        /* _yearref := Year(Date()) - 1 */
        _yearref = CPLib.Round(CPLib.Year(CPLib.Date())-1,0);
        /* dDatRif := CharToDate(Str(_yearref,4,0)+Substr(DateToChar(Date()),5,4)) */
        dDatRif = CPLib.CharToDate(CPLib.Str(_yearref,4,0)+CPLib.Substr(CPLib.DateToChar(CPLib.Date()),5,4));
        // * --- Select from dersonbo
        m_cServer = m_Ctx.GetServer("dersonbo");
        m_cPhName = m_Ctx.GetPhName("dersonbo");
        if (Cursor_dersonbo!=null)
          Cursor_dersonbo.Close();
        Cursor_dersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPODOC,NUMDOCUM,DATULTOPE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATULTOPE < "+CPSql.SQLValueAdapter(CPLib.ToSQL(dDatRif,"?",0,0,m_cServer, m_oParameters),m_cServer,dDatRif)+"  and  FLGDISABLED='N' "+")"+(m_Ctx.IsSharedTemp("dersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_dersonbo.Eof())) {
          /* If not(Empty(dersonbo->DATULTOPE)) */
          if ( ! (CPLib.Empty(Cursor_dersonbo.GetDate("DATULTOPE")))) {
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            // * --- Write into dersonbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("dersonbo");
            m_cPhName = m_Ctx.GetPhName("dersonbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_docscaduti",10,"0000001D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"FLGDISABLED = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dersonbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"TIPODOC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_dersonbo.GetString("TIPODOC"),"?",0,0,m_cServer),m_cServer,Cursor_dersonbo.GetString("TIPODOC"))+"";
            m_cSql = m_cSql+" and NUMDOCUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_dersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer),m_cServer,Cursor_dersonbo.GetString("NUMDOCUM"))+"";
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
          } // End If
          Cursor_dersonbo.Next();
        }
        m_cConnectivityError = Cursor_dersonbo.ErrorMessage();
        Cursor_dersonbo.Close();
        // * --- End Select
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* _msg := _msg + "Sono stati disabilitati "+LRTrim(Str(_conta,10,0)) + " record" + NL */
        _msg = _msg+"Sono stati disabilitati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" record"+"\n";
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* _msg := _msg + "Errore durante la fase di scrittura. Contattare assistenza!" + NL */
        _msg = _msg+"Errore durante la fase di scrittura. Contattare assistenza!"+"\n";
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000000Fstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000000Fstatus,cTry0000000Fmsg);
        }
      }
      /* _msg := _msg + 'Ora fine disabilitazione documenti scaduti: '+arfn_fdatetime(DateTime()) */
      _msg = _msg+"Ora fine disabilitazione documenti scaduti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_azienda)+"'",'',20) */
      cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_azienda)+"'","",20);
      // * --- Insert into log_app from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("log_app");
      m_cPhName = m_Ctx.GetPhName("log_app");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"log_app",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_docscaduti",10,"00000024")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000024(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("CLEAN_DOCS","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_msg,"?",0,0,m_cServer, m_oParameters)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("Scheduler","?",0,0,m_cServer, m_oParameters)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("CLEANDOC","?",0,0,m_cServer, m_oParameters)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
      m_cSql = m_cSql+")";
      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
      if (CPLib.lt(m_nUpdatedRows,0)) {
        m_Sql.AbortTransaction();
      }
      m_Sql.CompleteTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
    } finally {
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_dersonbo!=null)
          Cursor_dersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync() {
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
    );
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
  public static arrt_wu_docscadutiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_wu_docscadutiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    dDatRif = CPLib.NullDate();
    _conta = 0;
    _msg = "";
    cProg = CPLib.Space(20);
    _azienda = CPLib.Space(10);
    _yearref = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000024(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    p_cSql = p_cSql+"LOGTYPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
}
