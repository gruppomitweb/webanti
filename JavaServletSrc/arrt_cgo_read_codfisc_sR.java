// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_read_codfisc_sR implements CallerWithObjs {
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
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_cgo_operazioni_storico;
  public String m_cServer_cgo_operazioni_storico;
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
  public armt_snai_oper_storicoBO pObj;
  public String pTipo;
  public String _lastope;
  public String cDoc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_read_codfisc_sR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_read_codfisc_s",m_Caller);
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
    m_cPhName_cgo_operazioni_storico = p_ContextObject.GetPhName("cgo_operazioni_storico");
    if (m_cPhName_cgo_operazioni_storico.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_storico = m_cPhName_cgo_operazioni_storico+" "+m_Ctx.GetWritePhName("cgo_operazioni_storico");
    }
    m_cServer_cgo_operazioni_storico = p_ContextObject.GetServer("cgo_operazioni_storico");
    m_cPhName_cgo_docope = p_ContextObject.GetPhName("cgo_docope");
    if (m_cPhName_cgo_docope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_docope = m_cPhName_cgo_docope+" "+m_Ctx.GetWritePhName("cgo_docope");
    }
    m_cServer_cgo_docope = p_ContextObject.GetServer("cgo_docope");
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
      return "arrt_cgo_read_codfisc_s";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("_lastope",p_cVarName)) {
      return _lastope;
    }
    if (CPLib.eqr("cDoc",p_cVarName)) {
      return cDoc;
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
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("_lastope",p_cVarName)) {
      _lastope = value;
      return;
    }
    if (CPLib.eqr("cDoc",p_cVarName)) {
      cDoc = value;
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
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_personbo_agg=null;
    try {
      /* pObj Object(armt_snai_oper_storicoBO) */
      /* pTipo Char(1) */
      /* _lastope Char(15) */
      /* cDoc Char(128) */
      /* In base al codice ficale del cliente legge i dati anagrafici (tranne documento ?) */
      /* If pTipo='I' */
      if (CPLib.eqr(pTipo,"I")) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_CODFISC,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_CODFISC)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* pObj.Set_COGNOME(personbo->COGNOME) */
          pObj.Set_COGNOME(Cursor_personbo.GetString("COGNOME"));
          /* pObj.Set_NOME(personbo->NOME) */
          pObj.Set_NOME(Cursor_personbo.GetString("NOME"));
          /* pObj.Set_DESCCIT(personbo->DESCCIT) */
          pObj.Set_DESCCIT(Cursor_personbo.GetString("DESCCIT"));
          /* pObj.Set_PROVINCIA(personbo->PROVINCIA) */
          pObj.Set_PROVINCIA(Cursor_personbo.GetString("PROVINCIA"));
          /* pObj.Set_DOMICILIO(personbo->DOMICILIO) */
          pObj.Set_DOMICILIO(Cursor_personbo.GetString("DOMICILIO"));
          /* pObj.Set_PAESE(personbo->PAESE) */
          pObj.Set_PAESE(Cursor_personbo.GetString("PAESE"));
          /* pObj.Set_NASCOMUN(personbo->NASCOMUN) */
          pObj.Set_NASCOMUN(Cursor_personbo.GetString("NASCOMUN"));
          /* pObj.Set_TIPINTER(personbo->TIPINTER) */
          pObj.Set_TIPINTER(Cursor_personbo.GetString("TIPINTER"));
          /* pObj.Set_SESSO(personbo->SESSO) */
          pObj.Set_SESSO(Cursor_personbo.GetString("SESSO"));
          /* pObj.Set_NASSTATO(personbo->NASSTATO) */
          pObj.Set_NASSTATO(Cursor_personbo.GetString("NASSTATO"));
          /* pObj.Set_DATANASC(personbo->DATANASC) */
          pObj.Set_DATANASC(Cursor_personbo.GetDate("DATANASC"));
          /* pObj.Set_TIPODOC(personbo->TIPODOC) */
          pObj.Set_TIPODOC(Cursor_personbo.GetString("TIPODOC"));
          /* pObj.Set_NUMDOCUM(personbo->NUMDOCUM) */
          pObj.Set_NUMDOCUM(Cursor_personbo.GetString("NUMDOCUM"));
          /* pObj.Set_DATARILASC(personbo->DATARILASC) */
          pObj.Set_DATARILASC(Cursor_personbo.GetDate("DATARILASC"));
          /* pObj.Set_DATAVALI(personbo->DATAVALI) */
          pObj.Set_DATAVALI(Cursor_personbo.GetDate("DATAVALI"));
          /* pObj.Set_PEP('N') */
          pObj.Set_PEP("N");
          /* pObj.w_ATTIV := personbo->ATTIV */
          pObj.w_ATTIV = Cursor_personbo.GetString("ATTIV");
          /* pObj.w_CODCAB := personbo->CODCAB */
          pObj.w_CODCAB = Cursor_personbo.GetString("CODCAB");
          /* pObj.w_AUTRILASC := personbo->AUTRILASC */
          pObj.w_AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
          // * --- Select from personbo_agg
          m_cServer = m_Ctx.GetServer("personbo_agg");
          m_cPhName = m_Ctx.GetPhName("personbo_agg");
          if (Cursor_personbo_agg!=null)
            Cursor_personbo_agg.Close();
          Cursor_personbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo_agg.Eof())) {
            /* pObj.Set_RDCODAUT(personbo_agg->RDCODAUT) */
            pObj.Set_RDCODAUT(Cursor_personbo_agg.GetString("RDCODAUT"));
            /* pObj.Set_RDLOCAUT(personbo_agg->RDLOCAUT) */
            pObj.Set_RDLOCAUT(Cursor_personbo_agg.GetString("RDLOCAUT"));
            /* pObj.Set_NUMTEL(personbo_agg->NUMTEL) */
            pObj.Set_NUMTEL(Cursor_personbo_agg.GetString("NUMTEL"));
            /* _lastope := personbo_agg->LASTOPER */
            _lastope = Cursor_personbo_agg.GetString("LASTOPER");
            Cursor_personbo_agg.Next();
          }
          m_cConnectivityError = Cursor_personbo_agg.ErrorMessage();
          Cursor_personbo_agg.Close();
          // * --- End Select
          /* pObj.Calculate() */
          pObj.Calculate();
          /* pObj.Set_CAP(personbo->CAP) */
          pObj.Set_CAP(Cursor_personbo.GetString("CAP"));
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        /* ElseIf pTipo='E' */
      } else if (CPLib.eqr(pTipo,"E")) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COGNOME="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_COGNOME,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_COGNOME)+"  and  NOME="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_NOME,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_NOME)+"  and  NASCOMUN="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_NASCOMUN,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_NASCOMUN)+"  and  NASSTATO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_NASSTATO,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_NASSTATO)+"  and  DATANASC="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_DATANASC,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_DATANASC)+"  and  SESSO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_SESSO,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_SESSO)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* pObj.Set_CODFISC(personbo->CODFISC) */
          pObj.Set_CODFISC(Cursor_personbo.GetString("CODFISC"));
          /* pObj.Set_DESCCIT(personbo->DESCCIT) */
          pObj.Set_DESCCIT(Cursor_personbo.GetString("DESCCIT"));
          /* pObj.Set_PROVINCIA(personbo->PROVINCIA) */
          pObj.Set_PROVINCIA(Cursor_personbo.GetString("PROVINCIA"));
          /* pObj.Set_DOMICILIO(personbo->DOMICILIO) */
          pObj.Set_DOMICILIO(Cursor_personbo.GetString("DOMICILIO"));
          /* pObj.Set_PAESE(personbo->PAESE) */
          pObj.Set_PAESE(Cursor_personbo.GetString("PAESE"));
          /* pObj.Set_TIPINTER(personbo->TIPINTER) */
          pObj.Set_TIPINTER(Cursor_personbo.GetString("TIPINTER"));
          /* pObj.Set_TIPODOC(personbo->TIPODOC) */
          pObj.Set_TIPODOC(Cursor_personbo.GetString("TIPODOC"));
          /* pObj.Set_NUMDOCUM(personbo->NUMDOCUM) */
          pObj.Set_NUMDOCUM(Cursor_personbo.GetString("NUMDOCUM"));
          /* pObj.Set_DATARILASC(personbo->DATARILASC) */
          pObj.Set_DATARILASC(Cursor_personbo.GetDate("DATARILASC"));
          /* pObj.Set_DATAVALI(personbo->DATAVALI) */
          pObj.Set_DATAVALI(Cursor_personbo.GetDate("DATAVALI"));
          /* pObj.w_ATTIV := personbo->ATTIV */
          pObj.w_ATTIV = Cursor_personbo.GetString("ATTIV");
          /* pObj.w_CODCAB := personbo->CODCAB */
          pObj.w_CODCAB = Cursor_personbo.GetString("CODCAB");
          /* pObj.w_AUTRILASC := personbo->AUTRILASC */
          pObj.w_AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
          // * --- Select from personbo_agg
          m_cServer = m_Ctx.GetServer("personbo_agg");
          m_cPhName = m_Ctx.GetPhName("personbo_agg");
          if (Cursor_personbo_agg!=null)
            Cursor_personbo_agg.Close();
          Cursor_personbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo_agg.Eof())) {
            /* pObj.Set_RDCODAUT(personbo_agg->RDCODAUT) */
            pObj.Set_RDCODAUT(Cursor_personbo_agg.GetString("RDCODAUT"));
            /* pObj.Set_RDLOCAUT(personbo_agg->RDLOCAUT) */
            pObj.Set_RDLOCAUT(Cursor_personbo_agg.GetString("RDLOCAUT"));
            /* pObj.Set_NUMTEL(personbo_agg->NUMTEL) */
            pObj.Set_NUMTEL(Cursor_personbo_agg.GetString("NUMTEL"));
            /* _lastope := personbo_agg->LASTOPER */
            _lastope = Cursor_personbo_agg.GetString("LASTOPER");
            Cursor_personbo_agg.Next();
          }
          m_cConnectivityError = Cursor_personbo_agg.ErrorMessage();
          Cursor_personbo_agg.Close();
          // * --- End Select
          /* pObj.Check() */
          pObj.Check();
          /* pObj.Calculate() */
          pObj.Calculate();
          /* pObj.Set_CAP(personbo->CAP) */
          pObj.Set_CAP(Cursor_personbo.GetString("CAP"));
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
      } // End If
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo_agg!=null)
          Cursor_personbo_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(armt_snai_oper_storicoBO p_pObj,String p_pTipo) {
    pObj = p_pObj;
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
  public Forward Run(armt_snai_oper_storicoBO p_pObj,String p_pTipo) {
    pObj = p_pObj;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_cgo_read_codfisc_sR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_read_codfisc_sR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pObj = null;
    pTipo = CPLib.Space(1);
    _lastope = CPLib.Space(15);
    cDoc = CPLib.Space(128);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pObj","pTipo"};
}
