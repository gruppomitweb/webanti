// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class imp_newtabs_mtR implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbtipint;
  public String m_cServer_tbtipint;
  public String m_cPhName_cauanainter;
  public String m_cServer_cauanainter;
  public String m_cPhName_tbtipreg;
  public String m_cServer_tbtipreg;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_tbcausin;
  public String m_cServer_tbcausin;
  public String m_cPhName_aefiles;
  public String m_cServer_aefiles;
  public String m_cPhName_tbsetsin;
  public String m_cServer_tbsetsin;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_mtstati;
  public String m_cServer_mtstati;
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
  public String fhand;
  public String riga;
  public String _code1;
  public String _code;
  public String _code2;
  public String _code3;
  public String _code4;
  public String _code5;
  public String _code10;
  public String _code11;
  public double conta;
  public String _lista;
  public String _oldazi;
  public String _id4;
  public String _stringa;
  public String gMsgImp;
  public String gMsgProc;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public imp_newtabs_mtR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("imp_newtabs_mt",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbtipint = p_ContextObject.GetPhName("tbtipint");
    if (m_cPhName_tbtipint.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipint = m_cPhName_tbtipint+" "+m_Ctx.GetWritePhName("tbtipint");
    }
    m_cServer_tbtipint = p_ContextObject.GetServer("tbtipint");
    m_cPhName_cauanainter = p_ContextObject.GetPhName("cauanainter");
    if (m_cPhName_cauanainter.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cauanainter = m_cPhName_cauanainter+" "+m_Ctx.GetWritePhName("cauanainter");
    }
    m_cServer_cauanainter = p_ContextObject.GetServer("cauanainter");
    m_cPhName_tbtipreg = p_ContextObject.GetPhName("tbtipreg");
    if (m_cPhName_tbtipreg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipreg = m_cPhName_tbtipreg+" "+m_Ctx.GetWritePhName("tbtipreg");
    }
    m_cServer_tbtipreg = p_ContextObject.GetServer("tbtipreg");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    if (m_cPhName_tbvalute.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbvalute = m_cPhName_tbvalute+" "+m_Ctx.GetWritePhName("tbvalute");
    }
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    if (m_cPhName_tbcauana.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcauana = m_cPhName_tbcauana+" "+m_Ctx.GetWritePhName("tbcauana");
    }
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_cPhName_tbcausin = p_ContextObject.GetPhName("tbcausin");
    if (m_cPhName_tbcausin.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcausin = m_cPhName_tbcausin+" "+m_Ctx.GetWritePhName("tbcausin");
    }
    m_cServer_tbcausin = p_ContextObject.GetServer("tbcausin");
    m_cPhName_aefiles = p_ContextObject.GetPhName("aefiles");
    if (m_cPhName_aefiles.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefiles = m_cPhName_aefiles+" "+m_Ctx.GetWritePhName("aefiles");
    }
    m_cServer_aefiles = p_ContextObject.GetServer("aefiles");
    m_cPhName_tbsetsin = p_ContextObject.GetPhName("tbsetsin");
    if (m_cPhName_tbsetsin.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbsetsin = m_cPhName_tbsetsin+" "+m_Ctx.GetWritePhName("tbsetsin");
    }
    m_cServer_tbsetsin = p_ContextObject.GetServer("tbsetsin");
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    if (m_cPhName_inter2bo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_inter2bo = m_cPhName_inter2bo+" "+m_Ctx.GetWritePhName("inter2bo");
    }
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_mtstati = p_ContextObject.GetPhName("mtstati");
    if (m_cPhName_mtstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtstati = m_cPhName_mtstati+" "+m_Ctx.GetWritePhName("mtstati");
    }
    m_cServer_mtstati = p_ContextObject.GetServer("mtstati");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "imp_newtabs_mt";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("_code1",p_cVarName)) {
      return _code1;
    }
    if (CPLib.eqr("_code",p_cVarName)) {
      return _code;
    }
    if (CPLib.eqr("_code2",p_cVarName)) {
      return _code2;
    }
    if (CPLib.eqr("_code3",p_cVarName)) {
      return _code3;
    }
    if (CPLib.eqr("_code4",p_cVarName)) {
      return _code4;
    }
    if (CPLib.eqr("_code5",p_cVarName)) {
      return _code5;
    }
    if (CPLib.eqr("_code10",p_cVarName)) {
      return _code10;
    }
    if (CPLib.eqr("_code11",p_cVarName)) {
      return _code11;
    }
    if (CPLib.eqr("_lista",p_cVarName)) {
      return _lista;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      return _oldazi;
    }
    if (CPLib.eqr("_id4",p_cVarName)) {
      return _id4;
    }
    if (CPLib.eqr("_stringa",p_cVarName)) {
      return _stringa;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("_code1",p_cVarName)) {
      _code1 = value;
      return;
    }
    if (CPLib.eqr("_code",p_cVarName)) {
      _code = value;
      return;
    }
    if (CPLib.eqr("_code2",p_cVarName)) {
      _code2 = value;
      return;
    }
    if (CPLib.eqr("_code3",p_cVarName)) {
      _code3 = value;
      return;
    }
    if (CPLib.eqr("_code4",p_cVarName)) {
      _code4 = value;
      return;
    }
    if (CPLib.eqr("_code5",p_cVarName)) {
      _code5 = value;
      return;
    }
    if (CPLib.eqr("_code10",p_cVarName)) {
      _code10 = value;
      return;
    }
    if (CPLib.eqr("_code11",p_cVarName)) {
      _code11 = value;
      return;
    }
    if (CPLib.eqr("_lista",p_cVarName)) {
      _lista = value;
      return;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      _oldazi = value;
      return;
    }
    if (CPLib.eqr("_id4",p_cVarName)) {
      _id4 = value;
      return;
    }
    if (CPLib.eqr("_stringa",p_cVarName)) {
      _stringa = value;
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    /* Definizione Variabili Locali */
    /* fhand Char(1) */
    /* riga Memo */
    /* _code1 Char(1) */
    /* _code Char(2) */
    /* _code2 Char(2) */
    /* _code3 Char(3) */
    /* _code4 Char(4) */
    /* _code5 Char(5) */
    /* _code10 Char(10) */
    /* _code11 Char(11) */
    /* conta Numeric(10, 0) */
    /* _lista Char(30) */
    /* _oldazi Char(10) */
    /* _id4 Char(4) */
    /* _stringa Char(100) */
    /* Dichiarazione variabili globali */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Char(120) */
    /* gAzienda Char(10) // Azienda */
    /* Lettura Tabelle */
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file mtstati.txt' + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file mtstati.txt"+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* fhand := FileLibMit.OpenRead('./newtab/mtstati.txt') */
    fhand = FileLibMit.OpenRead("./newtab/mtstati.txt");
    /* While not(FileLibMit.Eof(fhand)) */
    while ( ! (FileLibMit.Eof(fhand))) {
      /* riga := FileLibMit.ReadLine(fhand) */
      riga = FileLibMit.ReadLine(fhand);
      /* If Len(LRTrim(riga)) > 0 */
      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
        /* gMsgImp := 'TBSTATI - Inserimento codice '+ Left(riga,3) */
        gMsgImp = "TBSTATI - Inserimento codice "+CPLib.Left(riga,3);
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _code5 := Utilities.GetAutonumber("PRGMTSTATI\'"+LRTrim(gAzienda)+"'","",5) */
        _code5 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGMTSTATI\\'"+CPLib.LRTrim(gAzienda)+"'","",5);
        // * --- Insert into mtstati from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("mtstati");
        m_cPhName = m_Ctx.GetPhName("mtstati");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mtstati",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("imp_newtabs_mt",42,"0000001E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000001E(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_code5,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,4,40),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mtstati",true);
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
      } // End If
    } // End While
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file mtstati.txt' + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file mtstati.txt"+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'ELABORAZIONE TERMINATA' */
    gMsgImp = "ELABORAZIONE TERMINATA";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static imp_newtabs_mtR Make(CPContext p_Ctx, Caller p_Caller) {
    return new imp_newtabs_mtR(p_Ctx, p_Caller);
  }
  public void Blank() {
    fhand = CPLib.Space(1);
    riga = "";
    _code1 = CPLib.Space(1);
    _code = CPLib.Space(2);
    _code2 = CPLib.Space(2);
    _code3 = CPLib.Space(3);
    _code4 = CPLib.Space(4);
    _code5 = CPLib.Space(5);
    _code10 = CPLib.Space(10);
    _code11 = CPLib.Space(11);
    conta = 0;
    _lista = CPLib.Space(30);
    _oldazi = CPLib.Space(10);
    _id4 = CPLib.Space(4);
    _stringa = CPLib.Space(100);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000001E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODSTA,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"SIGLA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mtstati",true);
    return p_cSql;
  }
}
