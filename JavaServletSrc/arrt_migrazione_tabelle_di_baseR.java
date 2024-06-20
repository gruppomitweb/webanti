// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_migrazione_tabelle_di_baseR implements CallerWithObjs {
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
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_cptsrvr;
  public String m_cServer_cptsrvr;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
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
  public String pNomeDataBaseSorgente;
  public String pNomeAziendaSogernteDati;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String ODBCDataSource;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_migrazione_tabelle_di_baseR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_migrazione_tabelle_di_base",m_Caller);
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_cptsrvr = p_ContextObject.GetPhName("cptsrvr");
    if (m_cPhName_cptsrvr.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cptsrvr = m_cPhName_cptsrvr+" "+m_Ctx.GetWritePhName("cptsrvr");
    }
    m_cServer_cptsrvr = p_ContextObject.GetServer("cptsrvr");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
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
      return "arrt_migrazione_tabelle_di_base";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pNomeDataBaseSorgente",p_cVarName)) {
      return pNomeDataBaseSorgente;
    }
    if (CPLib.eqr("pNomeAziendaSogernteDati",p_cVarName)) {
      return pNomeAziendaSogernteDati;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("ODBCDataSource",p_cVarName)) {
      return ODBCDataSource;
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
    if (CPLib.eqr("pNomeDataBaseSorgente",p_cVarName)) {
      pNomeDataBaseSorgente = value;
      return;
    }
    if (CPLib.eqr("pNomeAziendaSogernteDati",p_cVarName)) {
      pNomeAziendaSogernteDati = value;
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
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("ODBCDataSource",p_cVarName)) {
      ODBCDataSource = value;
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
  void page_1() throws Exception {
    CPResultSet Cursor_cptsrvr=null;
    CPResultSet Cursor_tbstati=null;
    try {
      /* pNomeDataBaseSorgente Char(0) // Nome del DB sorgente dei dati */
      /* pNomeAziendaSogernteDati Char(0) // Il nome è sufficientemente parlante credo */
      /* gAzienda Char(10) // Azienda Destinazione */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* ODBCDataSource Char(500) // ODBCDataSource letto su cptserver */
      /* gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from cptsrvr
      m_cServer = m_Ctx.GetServer("cptsrvr");
      m_cPhName = m_Ctx.GetPhName("cptsrvr");
      if (Cursor_cptsrvr!=null)
        Cursor_cptsrvr.Close();
      Cursor_cptsrvr = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"ServerName="+CPSql.SQLValueAdapter(CPLib.ToSQL(pNomeDataBaseSorgente,"?",0,0,m_cServer, m_oParameters),m_cServer,pNomeDataBaseSorgente)+" "+")"+(m_Ctx.IsSharedTemp("cptsrvr")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cptsrvr.Eof())) {
        /* ODBCDataSource := cptsrvr->ODBCDataSource */
        ODBCDataSource = Cursor_cptsrvr.GetString("ODBCDataSource");
        Cursor_cptsrvr.Next();
      }
      m_cConnectivityError = Cursor_cptsrvr.ErrorMessage();
      Cursor_cptsrvr.Close();
      // * --- End Select
      /* -- Collegamento alla tabella CPAZI del DB sorgente dei dati */
      /* Utilities.SetAlternativeServer('','cpazi',ODBCDataSource) */
      Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("","cpazi",ODBCDataSource);
      /* If Utilities.SetCompany(pNomeAziendaSogernteDati) */
      if (Utilities.Make(m_Ctx,m_Caller).SetCompany(pNomeAziendaSogernteDati)) {
        double nTry00000011status;
        nTry00000011status = m_Sql.GetTransactionStatus();
        String cTry00000011msg;
        cTry00000011msg = m_Sql.TransactionErrorMessage();
        try {
          /* -- Collegamento alle tabelle sorgente dei dati */
          /* Utilities.SetAlternativeServer('','tbstati',ODBCDataSource) */
          Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("","tbstati",ODBCDataSource);
          // * --- Select from tbstati
          m_cServer = m_Ctx.GetServer("tbstati");
          m_cPhName = m_Ctx.GetPhName("tbstati");
          if (Cursor_tbstati!=null)
            Cursor_tbstati.Close();
          Cursor_tbstati = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbstati")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tbstati.Eof())) {
            /* Exec "Posizionamento DB" Page 8:switchDB('tbstati', 'D') */
            switchDB("tbstati","D");
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            // * --- Insert into tbstati from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbstati",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_migrazione_tabelle_di_base",148,"00000017")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000017(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tbstati.GetString("CODSTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tbstati.GetString("DESCRI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tbstati.GetString("SIGLA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tbstati.GetString("ISO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tbstati.GetString("ISO2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tbstati.GetString("IDTBLS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tbstati.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tbstati.GetString("FLGSAE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbstati",true);
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
            /* Exec "Posizionamento DB" Page 8:switchDB('anadip', 'S') */
            switchDB("anadip","S");
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            // Exit Loop
            if (true) {
              break;
            }
            Cursor_tbstati.Next();
          }
          m_cConnectivityError = Cursor_tbstati.ErrorMessage();
          Cursor_tbstati.Close();
          // * --- End Select
          /* Utilities.ResetAlternativeServer('','tbstati') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","tbstati");
          /* Utilities.SetCompany(gAzienda) */
          Utilities.Make(m_Ctx,m_Caller).SetCompany(gAzienda);
          /* gMsgImp := 'Elaborazione completata con successo!' // Messaggio Import */
          gMsgImp = "Elaborazione completata con successo!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          /* Utilities.ResetAlternativeServer('','tbstati') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","tbstati");
          /* gMsgProc := gMsgProc + 'Elaborazione non portata a termine' + NL */
          gMsgProc = gMsgProc+"Elaborazione non portata a termine"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := 'Elaborazione abortita!' // Messaggio Import */
          gMsgImp = "Elaborazione abortita!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000011status,0)) {
            m_Sql.SetTransactionStatus(nTry00000011status,cTry00000011msg);
          }
        }
      } else { // Else
        /* gMsgProc := gMsgProc + 'Elaborazione non portata a termine' + NL */
        gMsgProc = gMsgProc+"Elaborazione non portata a termine"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Errore nel collegamento al DB sorgente' + NL */
        gMsgProc = gMsgProc+"Errore nel collegamento al DB sorgente"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Elaborazione abortita!' // Messaggio Import */
        gMsgImp = "Elaborazione abortita!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_cptsrvr!=null)
          Cursor_cptsrvr.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbstati!=null)
          Cursor_tbstati.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void switchDB(String pTableName,String pAction) throws Exception {
    /* -- switching tra i BD di sorgente e destinazione */
    /* pTableName Char(0) */
    /* pAction Char(0) */
    /* If pAction='D' */
    if (CPLib.eqr(pAction,"D")) {
      /* Utilities.ResetAlternativeServer('',pTableName) */
      Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("",pTableName);
      /* Utilities.ResetAlternativeServer('','cpazi') */
      Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","cpazi");
      /* Utilities.SetCompany(gAzienda) */
      Utilities.Make(m_Ctx,m_Caller).SetCompany(gAzienda);
    } else { // Else
      /* Utilities.SetAlternativeServer('',pTableName,ODBCDataSource) */
      Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("",pTableName,ODBCDataSource);
      /* Utilities.SetAlternativeServer('','cpazi',ODBCDataSource) */
      Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("","cpazi",ODBCDataSource);
      /* Utilities.SetCompany(pNomeAziendaSogernteDati) */
      Utilities.Make(m_Ctx,m_Caller).SetCompany(pNomeAziendaSogernteDati);
    } // End If
  }
  void _init_() {
  }
  public String RunAsync(String p_pNomeDataBaseSorgente,String p_pNomeAziendaSogernteDati) {
    pNomeDataBaseSorgente = p_pNomeDataBaseSorgente;
    pNomeAziendaSogernteDati = p_pNomeAziendaSogernteDati;
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
  public Forward Run(String p_pNomeDataBaseSorgente,String p_pNomeAziendaSogernteDati) {
    pNomeDataBaseSorgente = p_pNomeDataBaseSorgente;
    pNomeAziendaSogernteDati = p_pNomeAziendaSogernteDati;
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
          page_1();
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
  public static arrt_migrazione_tabelle_di_baseR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_migrazione_tabelle_di_baseR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pNomeDataBaseSorgente = CPLib.Space(0);
    pNomeAziendaSogernteDati = CPLib.Space(0);
    ODBCDataSource = CPLib.Space(500);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pNomeDataBaseSorgente","pNomeAziendaSogernteDati"};
  protected static String GetFieldsName_00000017(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODSTA,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"SIGLA,";
    p_cSql = p_cSql+"ISO,";
    p_cSql = p_cSql+"ISO2,";
    p_cSql = p_cSql+"IDTBLS,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"FLGSAE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbstati",true);
    return p_cSql;
  }
}
