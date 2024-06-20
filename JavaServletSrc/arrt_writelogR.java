// * --- Area Manuale = BO - Header
// * --- arrt_writelog
import java.util.UUID;
import java.nio.ByteBuffer;
// * --- Fine Area Manuale
public class arrt_writelogR implements CallerWithObjs {
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
  public String m_cPhName_log_app;
  public String m_cServer_log_app;
  public String m_cPhName_cpusers;
  public String m_cServer_cpusers;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
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
  public String pOperazione;
  public String pTabella;
  public String pChiave;
  public String pTesto;
  public String pTipo;
  public String gUtente;
  public String gAzienda;
  public String cActLog;
  public java.sql.Date gDataVaria;
  public double gUserCode;
  public String gIPC;
  public String gPathDoc;
  public String cProg;
  public java.sql.Timestamp _orario;
  public String _desute;
  public String cMessage;
  public String fhand;
  public String filename;
  public String _nomeapp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_writelogR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_writelog",m_Caller);
    m_cPhName_log_app = p_ContextObject.GetPhName("log_app");
    if (m_cPhName_log_app.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_log_app = m_cPhName_log_app+" "+m_Ctx.GetWritePhName("log_app");
    }
    m_cServer_log_app = p_ContextObject.GetServer("log_app");
    m_cPhName_cpusers = p_ContextObject.GetPhName("cpusers");
    if (m_cPhName_cpusers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers = m_cPhName_cpusers+" "+m_Ctx.GetWritePhName("cpusers");
    }
    m_cServer_cpusers = p_ContextObject.GetServer("cpusers");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
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
      return "arrt_writelog";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pOperazione",p_cVarName)) {
      return pOperazione;
    }
    if (CPLib.eqr("pTabella",p_cVarName)) {
      return pTabella;
    }
    if (CPLib.eqr("pChiave",p_cVarName)) {
      return pChiave;
    }
    if (CPLib.eqr("pTesto",p_cVarName)) {
      return pTesto;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("gUtente",p_cVarName)) {
      return gUtente;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("cActLog",p_cVarName)) {
      return cActLog;
    }
    if (CPLib.eqr("gIPC",p_cVarName)) {
      return gIPC;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_desute",p_cVarName)) {
      return _desute;
    }
    if (CPLib.eqr("cMessage",p_cVarName)) {
      return cMessage;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      return filename;
    }
    if (CPLib.eqr("_nomeapp",p_cVarName)) {
      return _nomeapp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      return gDataVaria;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_orario",p_cVarName)) {
      return _orario;
    }
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
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      gUserCode = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pOperazione",p_cVarName)) {
      pOperazione = value;
      return;
    }
    if (CPLib.eqr("pTabella",p_cVarName)) {
      pTabella = value;
      return;
    }
    if (CPLib.eqr("pChiave",p_cVarName)) {
      pChiave = value;
      return;
    }
    if (CPLib.eqr("pTesto",p_cVarName)) {
      pTesto = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("gUtente",p_cVarName)) {
      gUtente = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("cActLog",p_cVarName)) {
      cActLog = value;
      return;
    }
    if (CPLib.eqr("gIPC",p_cVarName)) {
      gIPC = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_desute",p_cVarName)) {
      _desute = value;
      return;
    }
    if (CPLib.eqr("cMessage",p_cVarName)) {
      cMessage = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      filename = value;
      return;
    }
    if (CPLib.eqr("_nomeapp",p_cVarName)) {
      _nomeapp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      gDataVaria = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
    if (CPLib.eqr("_orario",p_cVarName)) {
      _orario = value;
      return;
    }
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Read_Cursor=null;
    try {
      /* Parametri dell'applicazione */
      /* pOperazione Char(15) // Tipo operazione */
      /* pTabella Char(20) // Nome Tabella */
      /* pChiave Char(30) // Nome Tabella */
      /* pTesto Memo := '' // Testo Log */
      /* pTipo Char(0) := "I" */
      /* Variabili Globali */
      /* gUtente Char(10) // Utente Procedura */
      /* gAzienda Char(10) // Azienda */
      /* cActLog Char(1) // Log Applicazione */
      /* gDataVaria Date // Data Variazione */
      /* gUserCode Numeric(4, 0) // Codice Utente CP */
      /* gIPC Char(20) // IPClient */
      /* gPathDoc Char(128) // Path Documenti */
      /* Variabili Locali */
      /* cProg Char(20) */
      /* _orario DateTime */
      /* _desute Char(20) */
      /* cMessage Memo */
      /* fhand Char(10) */
      /* filename Char(30) */
      /* _nomeapp Char(80) */
      /* Se il log è attivo */
      /* gDataVaria := NullDate() // Data Variazione */
      gDataVaria = CPLib.NullDate();
      m_Ctx.SetGlobalDate("gDataVaria",gDataVaria);
      /* If cActLog = 'S' */
      if (CPLib.eqr(cActLog,"S")) {
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* _nomeapp := LRTrim(intermbo->URLAPPL) */
          _nomeapp = CPLib.LRTrim(Cursor_intermbo.GetString("URLAPPL"));
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* filename := LRTrim(gPathDoc)+"/Log/"+LRTrim(gAzienda)+"/"+LRTrim(_nomeapp)+"_"+DateToChar(Date())+".log" */
        filename = CPLib.LRTrim(gPathDoc)+"/Log/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomeapp)+"_"+CPLib.DateToChar(CPLib.Date())+".log";
        /* fhand := FileLibMit.OpenAppendPath(LRTrim(filename)) */
        fhand = FileLibMit.OpenAppendPath(CPLib.LRTrim(filename));
        /* _orario := DateTime() */
        _orario = CPLib.DateTime();
        /* _desute := '' */
        _desute = "";
        // * --- Read from cpusers
        m_cServer = m_Ctx.GetServer("cpusers");
        m_cPhName = m_Ctx.GetPhName("cpusers");
        m_cSql = "";
        m_cSql = m_cSql+"code="+CPSql.SQLValueAdapter(CPLib.ToSQL(gUserCode,"N",10,0,m_cServer),m_cServer,gUserCode);
        if (m_Ctx.IsSharedTemp("cpusers")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("name",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _desute = Read_Cursor.GetString("name");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cpusers into routine arrt_writelog returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _desute = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* cMessage := 'Operazione compiuta:'+LRTrim(pOperazione)+' - Orario: '+arfn_fdatetime(_orario)+ ' - Utente: '+LRTrim(Str(gUserCode,10,0))+" - "+LRTrim(_desute) + ' - IP Client: '+ LRTrim(gIPC) */
        cMessage = "Operazione compiuta:"+CPLib.LRTrim(pOperazione)+" - Orario: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(_orario)+" - Utente: "+CPLib.LRTrim(CPLib.Str(gUserCode,10,0))+" - "+CPLib.LRTrim(_desute)+" - IP Client: "+CPLib.LRTrim(gIPC);
        /* If not(Empty(LRTrim(pTabella))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(pTabella)))) {
          /* cMessage := cMessage + " - Tabella: "+LRTrim(pTabella)+" - Chiave: "+LRTrim(pChiave) */
          cMessage = cMessage+" - Tabella: "+CPLib.LRTrim(pTabella)+" - Chiave: "+CPLib.LRTrim(pChiave);
        } // End If
        // Scrive la stringa e chiude il file
        FileLibMit.WriteLine(fhand,cMessage);
        FileLibMit.Close(fhand);
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000026status;
        nTry00000026status = m_Sql.GetTransactionStatus();
        String cTry00000026msg;
        cTry00000026msg = m_Sql.TransactionErrorMessage();
        try {
          /* cProg := LibreriaMit.GeneraCodice(20,true,false,"") */
          cProg = LibreriaMit.GeneraCodice(20,true,false,"");
          // * --- Insert into log_app from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("log_app");
          m_cPhName = m_Ctx.GetPhName("log_app");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"log_app",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_writelog",45,"00000028")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000028(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(gUserCode,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(pOperazione,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(( ! (CPLib.Empty(pTesto))?pTesto:CPLib.LRTrim(cMessage)),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(pTabella),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(pChiave,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(pTipo,"?",0,0,m_cServer)+", ";
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
            throw new RoutineException();
          }
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000026status,0)) {
            m_Sql.SetTransactionStatus(nTry00000026status,cTry00000026msg);
          }
        }
      } // End If
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
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
  public String RunAsync(String p_pOperazione,String p_pTabella,String p_pChiave) {
    return RunAsync(p_pOperazione,p_pTabella,p_pChiave,"");
  }
  public String RunAsync(String p_pOperazione,String p_pTabella,String p_pChiave,String p_pTesto) {
    return RunAsync(p_pOperazione,p_pTabella,p_pChiave,p_pTesto,"I");
  }
  public String RunAsync(String p_pOperazione,String p_pTabella,String p_pChiave,String p_pTesto,String p_pTipo) {
    pOperazione = p_pOperazione;
    pTabella = p_pTabella;
    pChiave = p_pChiave;
    pTesto = p_pTesto;
    pTipo = p_pTipo;
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
  public Forward Run(String p_pOperazione,String p_pTabella,String p_pChiave) {
    return Run(p_pOperazione,p_pTabella,p_pChiave,"");
  }
  public Forward Run(String p_pOperazione,String p_pTabella,String p_pChiave,String p_pTesto) {
    return Run(p_pOperazione,p_pTabella,p_pChiave,p_pTesto,"I");
  }
  public Forward Run(String p_pOperazione,String p_pTabella,String p_pChiave,String p_pTesto,String p_pTipo) {
    pOperazione = p_pOperazione;
    pTabella = p_pTabella;
    pChiave = p_pChiave;
    pTesto = p_pTesto;
    pTipo = p_pTipo;
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_writelogR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_writelogR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pOperazione = CPLib.Space(15);
    pTabella = CPLib.Space(20);
    pChiave = CPLib.Space(30);
    pTesto = "";
    pTipo = CPLib.Space(0);
    cProg = CPLib.Space(20);
    _orario = CPLib.NullDateTime();
    _desute = CPLib.Space(20);
    cMessage = "";
    fhand = CPLib.Space(10);
    filename = CPLib.Space(30);
    _nomeapp = CPLib.Space(80);
    gUtente=m_Ctx.GetGlobalString("gUtente");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    cActLog=m_Ctx.GetGlobalString("cActLog");
    gDataVaria=m_Ctx.GetGlobalDate("gDataVaria");
    gUserCode=m_Ctx.GetGlobalNumber("gUserCode");
    gIPC=m_Ctx.GetGlobalString("gIPC");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pOperazione","pTabella","pChiave","pTesto","pTipo"};
  protected static String GetFieldsName_00000028(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
