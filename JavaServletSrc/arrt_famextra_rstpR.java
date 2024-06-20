// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_famextra_rstpR implements CallerWithObjs {
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
  public String m_cPhName_sid_invio1;
  public String m_cServer_sid_invio1;
  public String m_cPhName_sid_invio3;
  public String m_cServer_sid_invio3;
  public String m_cPhName_tmp_sid_invio1;
  public String m_cServer_tmp_sid_invio1;
  public String m_cPhName_tmp_sid_invio3;
  public String m_cServer_tmp_sid_invio3;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_tmp_sid_invio;
  public String m_cServer_tmp_sid_invio;
  public String m_cPhName_sid_invio;
  public String m_cServer_sid_invio;
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
  public String w_stpinvio;
  public String w_xanno;
  public String w_xmese;
  public String gMsgImp;
  public String gMsgProc;
  public String gDescAzi;
  public double _record;
  public String _annoc;
  public String _mesec;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_famextra_rstpR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_famextra_rstp",m_Caller);
    m_cPhName_sid_invio1 = p_ContextObject.GetPhName("sid_invio1");
    if (m_cPhName_sid_invio1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio1 = m_cPhName_sid_invio1+" "+m_Ctx.GetWritePhName("sid_invio1");
    }
    m_cServer_sid_invio1 = p_ContextObject.GetServer("sid_invio1");
    m_cPhName_sid_invio3 = p_ContextObject.GetPhName("sid_invio3");
    if (m_cPhName_sid_invio3.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio3 = m_cPhName_sid_invio3+" "+m_Ctx.GetWritePhName("sid_invio3");
    }
    m_cServer_sid_invio3 = p_ContextObject.GetServer("sid_invio3");
    m_cPhName_tmp_sid_invio1 = p_ContextObject.GetPhName("tmp_sid_invio1");
    if (m_cPhName_tmp_sid_invio1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_sid_invio1 = m_cPhName_tmp_sid_invio1+" "+m_Ctx.GetWritePhName("tmp_sid_invio1");
    }
    m_cServer_tmp_sid_invio1 = p_ContextObject.GetServer("tmp_sid_invio1");
    m_cPhName_tmp_sid_invio3 = p_ContextObject.GetPhName("tmp_sid_invio3");
    if (m_cPhName_tmp_sid_invio3.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_sid_invio3 = m_cPhName_tmp_sid_invio3+" "+m_Ctx.GetWritePhName("tmp_sid_invio3");
    }
    m_cServer_tmp_sid_invio3 = p_ContextObject.GetServer("tmp_sid_invio3");
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio")) {
      m_cPhName_tmp_sid_invio = p_ContextObject.GetPhName("tmp_sid_invio");
      if (m_cPhName_tmp_sid_invio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sid_invio = m_cPhName_tmp_sid_invio+" "+m_Ctx.GetWritePhName("tmp_sid_invio");
      }
      m_cServer_tmp_sid_invio = p_ContextObject.GetServer("tmp_sid_invio");
    }
    m_cPhName_sid_invio = p_ContextObject.GetPhName("sid_invio");
    if (m_cPhName_sid_invio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio = m_cPhName_sid_invio+" "+m_Ctx.GetWritePhName("sid_invio");
    }
    m_cServer_sid_invio = p_ContextObject.GetServer("sid_invio");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_record",p_cVarName)) {
      return _record;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_famextra_rstp";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("stpinvio",p_cVarName)) {
      return w_stpinvio;
    }
    if (CPLib.eqr("xanno",p_cVarName)) {
      return w_xanno;
    }
    if (CPLib.eqr("xmese",p_cVarName)) {
      return w_xmese;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("_annoc",p_cVarName)) {
      return _annoc;
    }
    if (CPLib.eqr("_mesec",p_cVarName)) {
      return _mesec;
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
    if (CPLib.eqr("_record",p_cVarName)) {
      _record = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("stpinvio",p_cVarName)) {
      w_stpinvio = value;
      return;
    }
    if (CPLib.eqr("xanno",p_cVarName)) {
      w_xanno = value;
      return;
    }
    if (CPLib.eqr("xmese",p_cVarName)) {
      w_xmese = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
    if (CPLib.eqr("_annoc",p_cVarName)) {
      _annoc = value;
      return;
    }
    if (CPLib.eqr("_mesec",p_cVarName)) {
      _mesec = value;
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
    /* w_stpinvio Char(10) */
    /* w_xanno Char(4) */
    /* w_xmese Char(2) */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Memo // Messaggio */
    /* gDescAzi Char(70) // Descrizione Intermediario */
    /* _record Numeric(10, 0) */
    /* _annoc Char(4) */
    /* _mesec Char(2) */
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry0000000Estatus;
    nTry0000000Estatus = m_Sql.GetTransactionStatus();
    String cTry0000000Emsg;
    cTry0000000Emsg = m_Sql.TransactionErrorMessage();
    try {
      // * --- Create temporary table tmp_sid_invio
      if (m_Ctx.IsSharedTemp("tmp_sid_invio")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio")) {
          m_cServer = m_Ctx.GetServer("tmp_sid_invio");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_sid_invio");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_sid_invio");
      if ( ! (m_Ctx.IsSharedTemp("tmp_sid_invio"))) {
        m_cServer = m_Ctx.GetServer("tmp_sid_invio");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_sid_invio",m_cServer,"proto")),m_cPhName,"tmp_sid_invio",m_Ctx);
      }
      m_cPhName_tmp_sid_invio = m_cPhName;
      // * --- Insert into tmp_sid_invio from sql
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_sid_invio");
      m_cPhName = m_Ctx.GetPhName("tmp_sid_invio");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_sid_invio",m_Ctx.GetCompany());
      m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("arrt_famextra_rstp",78,"00000011"),m_cServer,m_oWrInfo,"* ","from "+m_cPhName_sid_invio+" where " + QueryLoader.SetSqlFunctions("CODINVIO="+CPLib.ToSQL(w_stpinvio,"?",0,0)+" ",m_cServer,m_Ctx)+"","tmp_sid_invio",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"tmp_sid_invio"));
      {
        if (CPLib.gt(m_nUpdatedRows,10000000*1.1)) {
          com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
          if ( ! (CPLib.IsNull(info))) {
            info.log("Routine arrt_famextra_rstp: Insert on tmp_sid_invio inserts "+(m_nUpdatedRows)+" rows larger then the expected 10000000");
          }
        }
      }
      if (CPLib.lt(m_nUpdatedRows,0)) {
        m_Sql.AbortTransaction();
      }
      m_Sql.CompleteTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
        throw new RoutineException();
      }
      /* _annoc := w_xanno */
      _annoc = w_xanno;
      /* _mesec := w_xmese */
      _mesec = w_xmese;
      // Commit
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      m_Sql.CompleteTransaction();
      /* gMsgImp := "Elaborazione Terminata. E' possibile effettuare la stampa" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata. E' possibile effettuare la stampa";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } catch(Exception l_exeption) {
      Stop.ReactToException(l_exeption);
      /* gMsgImp := "Elaborazione Terminata con errori. Consultare l'assistenza" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata con errori. Consultare l'assistenza";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // Rollback
      m_Sql.AbortTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      m_bError = true;
      m_Sql.CompleteTransaction();
    } finally {
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000000Estatus,0)) {
        m_Sql.SetTransactionStatus(nTry0000000Estatus,cTry0000000Emsg);
      }
    }
    /* Stop arrp_fam_stpextra.vrp */
    Forward f;
    f=new Forward("Report",false,this,Forward.Start,false);
    f.SetParameter("hideCover",true);
    f.SetParameter("hideLanguage",true);
    f.SetParameter("hideSettings",true);
    f.SetParameter("formatTypes","PDF|XLS|CSV");
    f.SetParameter("DescAzi",gDescAzi);
    f.SetParameter("w_annoc",_annoc);
    f.SetParameter("w_mese",_mesec);
    f.SetParameter("ReportName","arrp_fam_stpextra.vrp");
    f.SetParameter("m_cParameterSequence","hideCover"+","+"hideLanguage"+","+"hideSettings"+","+"formatTypes"+","+"DescAzi"+","+"w_annoc"+","+"w_mese"+","+"ReportName");
    f.SetParameter("m_cMode","hyperlink");
    throw f;
  }
  void _init_() {
  }
  public String RunAsync() {
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
      m_Caller.SetString("stpinvio","C",10,0,w_stpinvio);
      m_Caller.SetString("xanno","C",4,0,w_xanno);
      m_Caller.SetString("xmese","C",2,0,w_xmese);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_famextra_rstpR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_famextra_rstpR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_stpinvio = m_Caller.GetString("stpinvio","C",10,0);
    w_xanno = m_Caller.GetString("xanno","C",4,0);
    w_xmese = m_Caller.GetString("xmese","C",2,0);
    _record = 0;
    _annoc = CPLib.Space(4);
    _mesec = CPLib.Space(2);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
