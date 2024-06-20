// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_allinea_aerigheR implements CallerWithObjs {
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
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_tmp_impesiti;
  public String m_cServer_tmp_impesiti;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_tmp_imp_filae;
  public String m_cServer_tmp_imp_filae;
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
  public String w_msgproc;
  public double w_scelta;
  public double w_impzip;
  public String gMsgProc;
  public String w_nomefile;
  public String cProg;
  public String cconnes;
  public String _nasstato;
  public String _nascitta;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public double gOkPrintEsiti;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_allinea_aerighe
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_allinea_aerigheR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_allinea_aerighe",m_Caller);
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_tmp_impesiti = p_ContextObject.GetPhName("tmp_impesiti");
    if (m_cPhName_tmp_impesiti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_impesiti = m_cPhName_tmp_impesiti+" "+m_Ctx.GetWritePhName("tmp_impesiti");
    }
    m_cServer_tmp_impesiti = p_ContextObject.GetServer("tmp_impesiti");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_tmp_imp_filae = p_ContextObject.GetPhName("tmp_imp_filae");
    if (m_cPhName_tmp_imp_filae.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_imp_filae = m_cPhName_tmp_imp_filae+" "+m_Ctx.GetWritePhName("tmp_imp_filae");
    }
    m_cServer_tmp_imp_filae = p_ContextObject.GetServer("tmp_imp_filae");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("scelta",p_cVarName)) {
      return w_scelta;
    }
    if (CPLib.eqr("impzip",p_cVarName)) {
      return w_impzip;
    }
    if (CPLib.eqr("gOkPrintEsiti",p_cVarName)) {
      return gOkPrintEsiti;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_allinea_aerighe";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("msgproc",p_cVarName)) {
      return w_msgproc;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("cconnes",p_cVarName)) {
      return cconnes;
    }
    if (CPLib.eqr("_nasstato",p_cVarName)) {
      return _nasstato;
    }
    if (CPLib.eqr("_nascitta",p_cVarName)) {
      return _nascitta;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
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
    if (CPLib.eqr("scelta",p_cVarName)) {
      w_scelta = value;
      return;
    }
    if (CPLib.eqr("impzip",p_cVarName)) {
      w_impzip = value;
      return;
    }
    if (CPLib.eqr("gOkPrintEsiti",p_cVarName)) {
      gOkPrintEsiti = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("msgproc",p_cVarName)) {
      w_msgproc = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("cconnes",p_cVarName)) {
      cconnes = value;
      return;
    }
    if (CPLib.eqr("_nasstato",p_cVarName)) {
      _nasstato = value;
      return;
    }
    if (CPLib.eqr("_nascitta",p_cVarName)) {
      _nascitta = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
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
    CPResultSet Cursor_tmp_impesiti=null;
    CPResultSet Cursor_tmp_imp_filae=null;
    try {
      /* w_msgproc Memo */
      /* w_scelta Numeric(1, 0) */
      /* w_impzip Numeric(1, 0) */
      /* gMsgProc Memo */
      /* w_nomefile Char(100) */
      /* cProg Char(25) */
      /* cconnes Char(16) */
      /* _nasstato Char(30) */
      /* _nascitta Char(30) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Memo // Messaggio Import */
      /* gOkPrintEsiti Numeric(1, 0) // Abbilita le stampe degli esiti importati */
      /* gMsgProc := '' // Messaggio */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Estrai il filezip */
      /* gMsgImp := 'Ora Inzio Elaborazione dati '+ arfn_fdatetime(DateTime()) */
      gMsgImp = "Ora Inzio Elaborazione dati "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from tmp_impesiti
      m_cServer = m_Ctx.GetServer("tmp_impesiti");
      m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
      if (Cursor_tmp_impesiti!=null)
        Cursor_tmp_impesiti.Close();
      Cursor_tmp_impesiti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_impesiti")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_impesiti.Eof())) {
        /* cProg := tmp_impesiti->aprog */
        cProg = Cursor_tmp_impesiti.GetString("aprog");
        /* cconnes := tmp_impesiti->connes */
        cconnes = Cursor_tmp_impesiti.GetString("connes");
        // * --- Select from tmp_imp_filae
        m_cServer = m_Ctx.GetServer("tmp_imp_filae");
        m_cPhName = m_Ctx.GetPhName("tmp_imp_filae");
        if (Cursor_tmp_imp_filae!=null)
          Cursor_tmp_imp_filae.Close();
        Cursor_tmp_imp_filae = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(cProg,"?",0,0,m_cServer, m_oParameters),m_cServer,cProg)+" "+")"+(m_Ctx.IsSharedTemp("tmp_imp_filae")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_imp_filae.Eof())) {
          /* gMsgImp := 'Aggiornamento dati cliente con codice '+cconnes // Messaggio allineamento 1 */
          gMsgImp = "Aggiornamento dati cliente con codice "+cconnes;
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If Empty(LRTrim(tmp_imp_filae->SESSO)) */
          if (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("SESSO")))) {
            // * --- Write into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_aerighe",252,"0000001A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CF"),"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(Cursor_tmp_imp_filae.GetString("SLCITTA"),30),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("SLPROV"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL("G","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL((CPLib.eqr(Cursor_tmp_imp_filae.GetString("INVIO"),"4")?1:0),"N",1,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cconnes,"?",0,0,m_cServer),m_cServer,cconnes)+"";
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
          } else { // Else
            /* _nasstato := '' */
            _nasstato = "";
            /* _nascitta := '' */
            _nascitta = "";
            /* If Substr(tmp_imp_filae->CF,12,1)='Z' */
            if (CPLib.eqr(CPLib.Substr(Cursor_tmp_imp_filae.GetString("CF"),12,1),"Z")) {
              /* _nasstato := Left(tmp_imp_filae->NACITTA,30) */
              _nasstato = CPLib.Left(Cursor_tmp_imp_filae.GetString("NACITTA"),30);
            } else { // Else
              /* _nascitta := Left(tmp_imp_filae->NACITTA,30) */
              _nascitta = CPLib.Left(Cursor_tmp_imp_filae.GetString("NACITTA"),30);
            } // End If
            // * --- Write into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_aerighe",252,"00000020")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("CNOME"))+" "+CPLib.LRTrim(Cursor_tmp_imp_filae.GetString("NOME")),"C",70,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CF"),"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetDate("NADATA"),"D",8,0)+", ";
            m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(_nascitta,"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(Cursor_tmp_imp_filae.GetString("SESSO"),"M")?"1":"2"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(_nasstato,"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NOME"),"C",25,0,m_cServer)+", ";
            m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("CNOME"),"C",26,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(Cursor_tmp_imp_filae.GetString("NAPROV"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL("P","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL((CPLib.eqr(Cursor_tmp_imp_filae.GetString("INVIO"),"4")?1:0),"N",1,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cconnes,"?",0,0,m_cServer),m_cServer,cconnes)+"";
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
          } // End If
          Cursor_tmp_imp_filae.Next();
        }
        m_cConnectivityError = Cursor_tmp_imp_filae.ErrorMessage();
        Cursor_tmp_imp_filae.Close();
        // * --- End Select
        Cursor_tmp_impesiti.Next();
      }
      m_cConnectivityError = Cursor_tmp_impesiti.ErrorMessage();
      Cursor_tmp_impesiti.Close();
      // * --- End Select
      /* gMsgImp := 'Ora Fine Elaborazione dati '+ arfn_fdatetime(DateTime()) */
      gMsgImp = "Ora Fine Elaborazione dati "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_tmp_impesiti!=null)
          Cursor_tmp_impesiti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_imp_filae!=null)
          Cursor_tmp_imp_filae.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
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
      m_Caller.SetString("msgproc","M",10,0,w_msgproc);
      m_Caller.SetNumber("scelta","N",1,0,w_scelta);
      m_Caller.SetNumber("impzip","N",1,0,w_impzip);
      m_Caller.SetString("gMsgProc","M",10,0,gMsgProc);
      m_Caller.SetString("nomefile","C",100,0,w_nomefile);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_allinea_aerigheR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_allinea_aerigheR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_msgproc = m_Caller.GetString("msgproc","M",10,0);
    w_scelta = m_Caller.GetNumber("scelta","N",1,0);
    w_impzip = m_Caller.GetNumber("impzip","N",1,0);
    gMsgProc = m_Caller.GetString("gMsgProc","M",10,0);
    w_nomefile = m_Caller.GetString("nomefile","C",100,0);
    cProg = CPLib.Space(25);
    cconnes = CPLib.Space(16);
    _nasstato = CPLib.Space(30);
    _nascitta = CPLib.Space(30);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gOkPrintEsiti=m_Ctx.GetGlobalNumber("gOkPrintEsiti");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
}
