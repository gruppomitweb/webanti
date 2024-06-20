// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_famanagR implements CallerWithObjs {
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
  public String pNDG;
  public String pRuolo;
  public MemoryCursorRow_sid_invio2 rowRitorno;
  public String _tipsog;
  public String _codfisc;
  public String _paeseres;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_famanagR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_famanag",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
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
      return "arfn_famanag";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pNDG",p_cVarName)) {
      return pNDG;
    }
    if (CPLib.eqr("pRuolo",p_cVarName)) {
      return pRuolo;
    }
    if (CPLib.eqr("_tipsog",p_cVarName)) {
      return _tipsog;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      return _codfisc;
    }
    if (CPLib.eqr("_paeseres",p_cVarName)) {
      return _paeseres;
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
    if (CPLib.eqr("rowRitorno",p_cVarName)) {
      return rowRitorno;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pNDG",p_cVarName)) {
      pNDG = value;
      return;
    }
    if (CPLib.eqr("pRuolo",p_cVarName)) {
      pRuolo = value;
      return;
    }
    if (CPLib.eqr("_tipsog",p_cVarName)) {
      _tipsog = value;
      return;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      _codfisc = value;
      return;
    }
    if (CPLib.eqr("_paeseres",p_cVarName)) {
      _paeseres = value;
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
    if (CPLib.eqr("rowRitorno",p_cVarName)) {
      rowRitorno = (MemoryCursorRow_sid_invio2)value;
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
    CPResultSet Read_Cursor=null;
    try {
      /* pNDG Char(16) // Codice Soggetto */
      /* pRuolo Char(1) // Ruolo */
      /* rowRitorno Row(sid_invio2) */
      /* _tipsog Char(1) // Tipo Soggetto */
      /* _codfisc Char(16) // Codice Fiscale calcolato */
      /* _paeseres Char(40) */
      // * --- Select from personbo
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      if (Cursor_personbo!=null)
        Cursor_personbo.Close();
      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pNDG,"?",0,0,m_cServer, m_oParameters),m_cServer,pNDG)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_personbo.Eof())) {
        /* rowRitorno.FCFINVIO2 := personbo->CFESTERO */
        rowRitorno.FCFINVIO2 = Cursor_personbo.GetDouble("CFESTERO");
        /* rowRitorno.CFSINVIO2 := iif(personbo->CFESTERO=1,Space(16),personbo->CODFISC) */
        rowRitorno.CFSINVIO2 = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?CPLib.Space(16):Cursor_personbo.GetString("CODFISC"));
        /* If not(Empty(personbo->SESSO)) */
        if ( ! (CPLib.Empty(Cursor_personbo.GetString("SESSO")))) {
          /* rowRitorno.COGINVIO2 := personbo->COGNOME */
          rowRitorno.COGINVIO2 = Cursor_personbo.GetString("COGNOME");
          /* rowRitorno.NOMINVIO2 := personbo->NOME */
          rowRitorno.NOMINVIO2 = Cursor_personbo.GetString("NOME");
          /* rowRitorno.DNSINVIO2 := personbo->DATANASC */
          rowRitorno.DNSINVIO2 = Cursor_personbo.GetDate("DATANASC");
          /* rowRitorno.CNSINVIO2 := iif(personbo->TIPINTER='EE',personbo->NASSTATO,personbo->NASCOMUN) */
          rowRitorno.CNSINVIO2 = (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")?Cursor_personbo.GetString("NASSTATO"):Cursor_personbo.GetString("NASCOMUN"));
          /* rowRitorno.PNSINVIO2 := personbo->TIPINTER */
          rowRitorno.PNSINVIO2 = Cursor_personbo.GetString("TIPINTER");
          /* rowRitorno.SEXINVIO2 := iif(personbo->SESSO='1','M',iif(personbo->SESSO='2','F','')) */
          rowRitorno.SEXINVIO2 = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1")?"M":(CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"F":""));
          /* Case pRuolo='I' */
          if (CPLib.eqr(pRuolo,"I")) {
            /* If not(Empty(personbo->CODFISC)) and not(Empty(personbo->PARTIVA)) */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("PARTIVA")))) {
              /* rowRitorno.RUOINVIO2 := '4' */
              rowRitorno.RUOINVIO2 = "4";
            } else { // Else
              /* rowRitorno.RUOINVIO2 := '0' */
              rowRitorno.RUOINVIO2 = "0";
            } // End If
            /* Case pRuolo='D' */
          } else if (CPLib.eqr(pRuolo,"D")) {
            /* rowRitorno.RUOINVIO2 := '5' */
            rowRitorno.RUOINVIO2 = "5";
            /* Case pRuolo='T' */
          } else if (CPLib.eqr(pRuolo,"T")) {
            /* rowRitorno.RUOINVIO2 := '7' */
            rowRitorno.RUOINVIO2 = "7";
            /* Case pRuolo='G' */
          } else if (CPLib.eqr(pRuolo,"G")) {
            /* rowRitorno.RUOINVIO2 := '8' */
            rowRitorno.RUOINVIO2 = "8";
            /* Case pRuolo='S' */
          } else if (CPLib.eqr(pRuolo,"S")) {
            /* rowRitorno.RUOINVIO2 := '6' */
            rowRitorno.RUOINVIO2 = "6";
          } // End Case
        } else { // Else
          /* rowRitorno.RGSINVIO2 := Left(personbo->RAGSOC,60) */
          rowRitorno.RGSINVIO2 = CPLib.Left(Cursor_personbo.GetString("RAGSOC"),60);
          /* If Upper(personbo->PROVINCIA)<>'EE' */
          if (CPLib.ne(CPLib.Upper(Cursor_personbo.GetString("PROVINCIA")),"EE")) {
            /* rowRitorno.CSLINVIO2 := personbo->DESCCIT */
            rowRitorno.CSLINVIO2 = Cursor_personbo.GetString("DESCCIT");
          } else { // Else
            /* _paeseres := '' */
            _paeseres = "";
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _paeseres = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arfn_famanag returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _paeseres = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* rowRitorno.CSLINVIO2 := LRTrim(_paeseres) */
            rowRitorno.CSLINVIO2 = CPLib.LRTrim(_paeseres);
          } // End If
          /* rowRitorno.PLSINVIO2 := personbo->PROVINCIA */
          rowRitorno.PLSINVIO2 = Cursor_personbo.GetString("PROVINCIA");
          /* Case pRuolo='I' */
          if (CPLib.eqr(pRuolo,"I")) {
            /* rowRitorno.RUOINVIO2 := '0' */
            rowRitorno.RUOINVIO2 = "0";
            /* Case pRuolo='D' */
          } else if (CPLib.eqr(pRuolo,"D")) {
            /* rowRitorno.RUOINVIO2 := '5' */
            rowRitorno.RUOINVIO2 = "5";
            /* Case pRuolo='T' */
          } else if (CPLib.eqr(pRuolo,"T")) {
            /* rowRitorno.RUOINVIO2 := '7' */
            rowRitorno.RUOINVIO2 = "7";
            /* Case pRuolo='G' */
          } else if (CPLib.eqr(pRuolo,"G")) {
            /* rowRitorno.RUOINVIO2 := '8' */
            rowRitorno.RUOINVIO2 = "8";
            /* Case pRuolo='S' */
          } else if (CPLib.eqr(pRuolo,"S")) {
            /* rowRitorno.RUOINVIO2 := '6' */
            rowRitorno.RUOINVIO2 = "6";
          } // End Case
        } // End If
        Cursor_personbo.Next();
      }
      m_cConnectivityError = Cursor_personbo.ErrorMessage();
      Cursor_personbo.Close();
      // * --- End Select
      /* Return rowRitorno */
      throw new Stop(rowRitorno);
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
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
  public String RunAsync(String p_pNDG,String p_pRuolo) {
    pNDG = p_pNDG;
    pRuolo = p_pRuolo;
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
  public MemoryCursorRow_sid_invio2 Run(String p_pNDG,String p_pRuolo) {
    pNDG = p_pNDG;
    pRuolo = p_pRuolo;
    return Run();
  }
  public MemoryCursorRow_sid_invio2 Run() {
    MemoryCursorRow_sid_invio2 l_result;
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
        l_result = (MemoryCursorRow_sid_invio2)stop_value.GetObject();
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
  public static arfn_famanagR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_famanagR(p_Ctx, p_Caller);
  }
  public static arfn_famanagR Make(CPContext p_Ctx) {
    return new arfn_famanagR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pNDG = CPLib.Space(16);
    pRuolo = CPLib.Space(1);
    rowRitorno = new MemoryCursorRow_sid_invio2();
    _tipsog = CPLib.Space(1);
    _codfisc = CPLib.Space(16);
    _paeseres = CPLib.Space(40);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_famanag,
  public static final String i_InvokedRoutines = ",arfn_famanag,";
  public static String[] m_cRunParameterNames={"pNDG","pRuolo"};
}
