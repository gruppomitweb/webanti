// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_datisog_sol_rowR implements CallerWithObjs {
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
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_tbstgru;
  public String m_cServer_tbstgru;
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
  public String pCli;
  public java.sql.Date pDatOpe;
  public String pSTATO;
  public java.sql.Date pDatRet;
  public MemoryCursorRow_mcsoggettiall1_mcrdef cRowRitorno;
  public String _numsto;
  public String _ramate;
  public String _tipsot;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_datisog_sol_rowR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_datisog_sol_row",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_tbstgru = p_ContextObject.GetPhName("tbstgru");
    if (m_cPhName_tbstgru.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstgru = m_cPhName_tbstgru+" "+m_Ctx.GetWritePhName("tbstgru");
    }
    m_cServer_tbstgru = p_ContextObject.GetServer("tbstgru");
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
      return "arfn_datisog_sol_row";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pCli",p_cVarName)) {
      return pCli;
    }
    if (CPLib.eqr("pSTATO",p_cVarName)) {
      return pSTATO;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      return _numsto;
    }
    if (CPLib.eqr("_ramate",p_cVarName)) {
      return _ramate;
    }
    if (CPLib.eqr("_tipsot",p_cVarName)) {
      return _tipsot;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      return pDatOpe;
    }
    if (CPLib.eqr("pDatRet",p_cVarName)) {
      return pDatRet;
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
    if (CPLib.eqr("cRowRitorno",p_cVarName)) {
      return cRowRitorno;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pCli",p_cVarName)) {
      pCli = value;
      return;
    }
    if (CPLib.eqr("pSTATO",p_cVarName)) {
      pSTATO = value;
      return;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      _numsto = value;
      return;
    }
    if (CPLib.eqr("_ramate",p_cVarName)) {
      _ramate = value;
      return;
    }
    if (CPLib.eqr("_tipsot",p_cVarName)) {
      _tipsot = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      pDatOpe = value;
      return;
    }
    if (CPLib.eqr("pDatRet",p_cVarName)) {
      pDatRet = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("cRowRitorno",p_cVarName)) {
      cRowRitorno = (MemoryCursorRow_mcsoggettiall1_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    try {
      /* pCli Char(16) // Codice Soggetto */
      /* pDatOpe Date // Data Operazione */
      /* pSTATO Char(1) // Stato Registrazione */
      /* pDatRet Date // Data Rettifica */
      /* cRowRitorno Row(mcSoggettiAll1.MCRDef) // Row di ritorno */
      /* _numsto Char(15) */
      /* _ramate Char(3) */
      /* _tipsot Char(1) */
      /* _numsto := arfn_chkspers(pCli,iif(pSTATO='1',pDatRet,pDatOpe)) */
      _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(pCli,(CPLib.eqr(pSTATO,"1")?pDatRet:pDatOpe));
      /* If Empty(LRTrim(_numsto)) */
      if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCli,"?",0,0,m_cServer, m_oParameters),m_cServer,pCli)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* cRowRitorno.NDG := personbo->CONNES */
          cRowRitorno.NDG = Cursor_personbo.GetString("CONNES");
          /* cRowRitorno.RAGSOC := personbo->RAGSOC */
          cRowRitorno.RAGSOC = Cursor_personbo.GetString("RAGSOC");
          /* cRowRitorno.SESSO := personbo->SESSO */
          cRowRitorno.SESSO = Cursor_personbo.GetString("SESSO");
          /* cRowRitorno.CODFISC := personbo->CODFISC */
          cRowRitorno.CODFISC = Cursor_personbo.GetString("CODFISC");
          /* cRowRitorno.DATANASC := personbo->DATANASC */
          cRowRitorno.DATANASC = Cursor_personbo.GetDate("DATANASC");
          /* cRowRitorno.STATO := personbo->PAESE */
          cRowRitorno.STATO = Cursor_personbo.GetString("PAESE");
          /* If personbo->PAESE='086' */
          if (CPLib.eqr(Cursor_personbo.GetString("PAESE"),"086")) {
            /* cRowRitorno.DESCCIT := personbo->DESCCIT */
            cRowRitorno.DESCCIT = Cursor_personbo.GetString("DESCCIT");
            /* cRowRitorno.CODCAB := personbo->CODCAB */
            cRowRitorno.CODCAB = Cursor_personbo.GetString("CODCAB");
          } // End If
          /* If personbo->TIPINTER='EE' */
          if (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")) {
            /* cRowRitorno.NASCOMU := personbo->NASSTATO */
            cRowRitorno.NASCOMU = Cursor_personbo.GetString("NASSTATO");
          } else { // Else
            /* cRowRitorno.NASCOMU := personbo->NASCOMUN */
            cRowRitorno.NASCOMU = Cursor_personbo.GetString("NASCOMUN");
          } // End If
          /* cRowRitorno.SAE := personbo->SOTGRUP */
          cRowRitorno.SAE = Cursor_personbo.GetString("SOTGRUP");
          /* cRowRitorno.ATECO := personbo->ATTIV */
          cRowRitorno.ATECO = Cursor_personbo.GetString("ATTIV");
          /* cRowRitorno.SETSINT := personbo->SETTSINT */
          cRowRitorno.SETSINT = Cursor_personbo.GetString("SETTSINT");
          /* cRowRitorno.NOSARA := personbo->NOSARA */
          cRowRitorno.NOSARA = Cursor_personbo.GetString("NOSARA");
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
      } else { // Else
        // * --- Select from wersonbo
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_wersonbo.Eof())) {
          /* cRowRitorno.NDG := wersonbo->CONNES */
          cRowRitorno.NDG = Cursor_wersonbo.GetString("CONNES");
          /* cRowRitorno.RAGSOC := wersonbo->RAGSOC */
          cRowRitorno.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
          /* cRowRitorno.SESSO := wersonbo->SESSO */
          cRowRitorno.SESSO = Cursor_wersonbo.GetString("SESSO");
          /* cRowRitorno.CODFISC := wersonbo->CODFISC */
          cRowRitorno.CODFISC = Cursor_wersonbo.GetString("CODFISC");
          /* cRowRitorno.DATANASC := wersonbo->DATANASC */
          cRowRitorno.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
          /* cRowRitorno.STATO := wersonbo->PAESE */
          cRowRitorno.STATO = Cursor_wersonbo.GetString("PAESE");
          /* If wersonbo->PAESE='086' */
          if (CPLib.eqr(Cursor_wersonbo.GetString("PAESE"),"086")) {
            /* cRowRitorno.DESCCIT := wersonbo->DESCCIT */
            cRowRitorno.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
            /* cRowRitorno.CODCAB := wersonbo->CODCAB */
            cRowRitorno.CODCAB = Cursor_wersonbo.GetString("CODCAB");
          } // End If
          /* If wersonbo->TIPINTER='EE' */
          if (CPLib.eqr(Cursor_wersonbo.GetString("TIPINTER"),"EE")) {
            /* cRowRitorno.NASCOMU := wersonbo->NASSTATO */
            cRowRitorno.NASCOMU = Cursor_wersonbo.GetString("NASSTATO");
          } else { // Else
            /* cRowRitorno.NASCOMU := wersonbo->NASCOMUN */
            cRowRitorno.NASCOMU = Cursor_wersonbo.GetString("NASCOMUN");
          } // End If
          /* cRowRitorno.SAE := wersonbo->SOTGRUP */
          cRowRitorno.SAE = Cursor_wersonbo.GetString("SOTGRUP");
          /* cRowRitorno.ATECO := wersonbo->ATTIV */
          cRowRitorno.ATECO = Cursor_wersonbo.GetString("ATTIV");
          /* cRowRitorno.SETSINT := wersonbo->SETTSINT */
          cRowRitorno.SETSINT = Cursor_wersonbo.GetString("SETTSINT");
          /* cRowRitorno.NOSARA := wersonbo->NOSARA */
          cRowRitorno.NOSARA = Cursor_wersonbo.GetString("NOSARA");
          Cursor_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
        Cursor_wersonbo.Close();
        // * --- End Select
      } // End If
      /* Return cRowRitorno */
      throw new Stop(cRowRitorno);
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pCli,java.sql.Date p_pDatOpe,String p_pSTATO,java.sql.Date p_pDatRet) {
    pCli = p_pCli;
    pDatOpe = p_pDatOpe;
    pSTATO = p_pSTATO;
    pDatRet = p_pDatRet;
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
  public MemoryCursorRow_mcsoggettiall1_mcrdef Run(String p_pCli,java.sql.Date p_pDatOpe,String p_pSTATO,java.sql.Date p_pDatRet) {
    pCli = p_pCli;
    pDatOpe = p_pDatOpe;
    pSTATO = p_pSTATO;
    pDatRet = p_pDatRet;
    return Run();
  }
  public MemoryCursorRow_mcsoggettiall1_mcrdef Run() {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_result;
    l_result = null;
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
        l_result = (MemoryCursorRow_mcsoggettiall1_mcrdef)stop_value.GetObject();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = null;
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
  public static arfn_datisog_sol_rowR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_datisog_sol_rowR(p_Ctx, p_Caller);
  }
  public static arfn_datisog_sol_rowR Make(CPContext p_Ctx) {
    return new arfn_datisog_sol_rowR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pCli = CPLib.Space(16);
    pDatOpe = CPLib.NullDate();
    pSTATO = CPLib.Space(1);
    pDatRet = CPLib.NullDate();
    cRowRitorno = new MemoryCursorRow_mcsoggettiall1_mcrdef();
    _numsto = CPLib.Space(15);
    _ramate = CPLib.Space(3);
    _tipsot = CPLib.Space(1);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chkspers,arfn_datisog_sol_row,
  public static final String i_InvokedRoutines = ",arfn_chkspers,arfn_datisog_sol_row,";
  public static String[] m_cRunParameterNames={"pCli","pDatOpe","pSTATO","pDatRet"};
}
