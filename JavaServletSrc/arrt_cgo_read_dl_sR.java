// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_read_dl_sR implements CallerWithObjs {
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
  public String m_cPhName_cgo_operazioni_dl;
  public String m_cServer_cgo_operazioni_dl;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
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
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_read_dl_sR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_read_dl_s",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_cgo_operazioni_dl = p_ContextObject.GetPhName("cgo_operazioni_dl");
    if (m_cPhName_cgo_operazioni_dl.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl = m_cPhName_cgo_operazioni_dl+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl");
    }
    m_cServer_cgo_operazioni_dl = p_ContextObject.GetServer("cgo_operazioni_dl");
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
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
      return "arrt_cgo_read_dl_s";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
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
    CPResultSet Cursor_cgo_operazioni_dl=null;
    try {
      /* Definizione oggetto chiamante */
      /* pObj Object(armt_snai_oper_storicoBO) */
      /* In base al codice ficale del cliente legge i dati anagrafici (tranne documento ?) */
      // * --- Select from cgo_operazioni_dl
      m_cServer = m_Ctx.GetServer("cgo_operazioni_dl");
      m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl");
      if (Cursor_cgo_operazioni_dl!=null)
        Cursor_cgo_operazioni_dl.Close();
      Cursor_cgo_operazioni_dl = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_NUMOPEDL,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_NUMOPEDL)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_operazioni_dl.Eof())) {
        /* pObj.Set_CODFISC(cgo_operazioni_dl->CODFISC) */
        pObj.Set_CODFISC(Cursor_cgo_operazioni_dl.GetString("CODFISC"));
        /* pObj.Set_COGNOME(cgo_operazioni_dl->COGNOME) */
        pObj.Set_COGNOME(Cursor_cgo_operazioni_dl.GetString("COGNOME"));
        /* pObj.Set_NOME(cgo_operazioni_dl->NOME) */
        pObj.Set_NOME(Cursor_cgo_operazioni_dl.GetString("NOME"));
        /* pObj.Set_DESCCIT(cgo_operazioni_dl->DESCCIT) */
        pObj.Set_DESCCIT(Cursor_cgo_operazioni_dl.GetString("DESCCIT"));
        /* pObj.Set_PROVINCIA(cgo_operazioni_dl->PROVINCIA) */
        pObj.Set_PROVINCIA(Cursor_cgo_operazioni_dl.GetString("PROVINCIA"));
        /* pObj.Set_CAP(cgo_operazioni_dl->CAP) */
        pObj.Set_CAP(Cursor_cgo_operazioni_dl.GetString("CAP"));
        /* pObj.Set_DOMICILIO(cgo_operazioni_dl->DOMICILIO) */
        pObj.Set_DOMICILIO(Cursor_cgo_operazioni_dl.GetString("DOMICILIO"));
        /* pObj.Set_PAESE(cgo_operazioni_dl->PAESE) */
        pObj.Set_PAESE(Cursor_cgo_operazioni_dl.GetString("PAESE"));
        /* pObj.Set_NASCOMUN(cgo_operazioni_dl->NASCOMUN) */
        pObj.Set_NASCOMUN(Cursor_cgo_operazioni_dl.GetString("NASCOMUN"));
        /* pObj.Set_TIPINTER(cgo_operazioni_dl->TIPINTER) */
        pObj.Set_TIPINTER(Cursor_cgo_operazioni_dl.GetString("TIPINTER"));
        /* pObj.Set_SESSO(cgo_operazioni_dl->SESSO) */
        pObj.Set_SESSO(Cursor_cgo_operazioni_dl.GetString("SESSO"));
        /* pObj.Set_NASSTATO(cgo_operazioni_dl->NASSTATO) */
        pObj.Set_NASSTATO(Cursor_cgo_operazioni_dl.GetString("NASSTATO"));
        /* pObj.Set_DATANASC(cgo_operazioni_dl->DATANASC) */
        pObj.Set_DATANASC(Cursor_cgo_operazioni_dl.GetDate("DATANASC"));
        /* pObj.Set_TIPODOC(cgo_operazioni_dl->TIPODOC) */
        pObj.Set_TIPODOC(Cursor_cgo_operazioni_dl.GetString("TIPODOC"));
        /* pObj.Set_NUMDOCUM(cgo_operazioni_dl->NUMDOCUM) */
        pObj.Set_NUMDOCUM(Cursor_cgo_operazioni_dl.GetString("NUMDOCUM"));
        /* pObj.Set_DATARILASC(cgo_operazioni_dl->DATARILASC) */
        pObj.Set_DATARILASC(Cursor_cgo_operazioni_dl.GetDate("DATARILASC"));
        /* pObj.Set_DATAVALI(cgo_operazioni_dl->DATAVALI) */
        pObj.Set_DATAVALI(Cursor_cgo_operazioni_dl.GetDate("DATAVALI"));
        /* pObj.Set_TOTCONT(cgo_operazioni_dl->TOTCONT) */
        pObj.Set_TOTCONT(Cursor_cgo_operazioni_dl.GetDouble("TOTCONT"));
        /* pObj.Set_CGOFLGVLT(cgo_operazioni_dl->CGOFLGVLT) */
        pObj.Set_CGOFLGVLT(Cursor_cgo_operazioni_dl.GetString("CGOFLGVLT"));
        /* pObj.w_FILTROMP := iif(cgo_operazioni_dl->TOTCONT <> cgo_operazioni_dl->TOTLIRE,"'I','E','P','B','C','V'","'I','E','P','B','C','V','S'") */
        pObj.w_FILTROMP = (CPLib.ne(Cursor_cgo_operazioni_dl.GetDouble("TOTCONT"),Cursor_cgo_operazioni_dl.GetDouble("TOTLIRE"))?"'I','E','P','B','C','V'":"'I','E','P','B','C','V','S'");
        /* pObj.Set_MEZPAGAM(cgo_operazioni_dl->MEZPAGAM) */
        pObj.Set_MEZPAGAM(Cursor_cgo_operazioni_dl.GetString("MEZPAGAM"));
        /* pObj.Set_IBAN(cgo_operazioni_dl->IBAN) */
        pObj.Set_IBAN(Cursor_cgo_operazioni_dl.GetString("IBAN"));
        /* pObj.Set_CC4CIFRE(cgo_operazioni_dl->CC4CIFRE) */
        pObj.Set_CC4CIFRE(Cursor_cgo_operazioni_dl.GetString("CC4CIFRE"));
        /* pObj.Set_CCMESSCA(cgo_operazioni_dl->CCMESSCA) */
        pObj.Set_CCMESSCA(Cursor_cgo_operazioni_dl.GetDouble("CCMESSCA"));
        /* pObj.Set_CCANNSCA(cgo_operazioni_dl->CCANNSCA) */
        pObj.Set_CCANNSCA(Cursor_cgo_operazioni_dl.GetDouble("CCANNSCA"));
        /* pObj.Set_ASSEGNO(cgo_operazioni_dl->ASSEGNO) */
        pObj.Set_ASSEGNO(Cursor_cgo_operazioni_dl.GetString("ASSEGNO"));
        /* pObj.Set_FLAGCONT(cgo_operazioni_dl->FLAGCONT) */
        pObj.Set_FLAGCONT(Cursor_cgo_operazioni_dl.GetString("FLAGCONT"));
        /* pObj.Set_RDCODAUT(cgo_operazioni_dl->RDCODAUT) */
        pObj.Set_RDCODAUT(Cursor_cgo_operazioni_dl.GetString("RDCODAUT"));
        /* pObj.Set_RDLOCAUT(cgo_operazioni_dl->RDLOCAUT) */
        pObj.Set_RDLOCAUT(Cursor_cgo_operazioni_dl.GetString("RDLOCAUT"));
        /* pObj.Set_NUMTEL(cgo_operazioni_dl->NUMTEL) */
        pObj.Set_NUMTEL(Cursor_cgo_operazioni_dl.GetString("NUMTEL"));
        /* pObj.Set_PEP(cgo_operazioni_dl->PEP) */
        pObj.Set_PEP(Cursor_cgo_operazioni_dl.GetString("PEP"));
        /* pObj.Set_PEPDESCRI(cgo_operazioni_dl->PEPDESCRI) */
        pObj.Set_PEPDESCRI(Cursor_cgo_operazioni_dl.GetString("PEPDESCRI"));
        /* pObj.w_ATTIV := cgo_operazioni_dl->ATTIV */
        pObj.w_ATTIV = Cursor_cgo_operazioni_dl.GetString("ATTIV");
        /* pObj.w_CODCAB := cgo_operazioni_dl->CODCAB */
        pObj.w_CODCAB = Cursor_cgo_operazioni_dl.GetString("CODCAB");
        /* pObj.w_AUTRILASC := cgo_operazioni_dl->AUTRILASC */
        pObj.w_AUTRILASC = Cursor_cgo_operazioni_dl.GetString("AUTRILASC");
        /* pObj.w_IDDOCALL := cgo_operazioni_dl->IDDOCALL */
        pObj.w_IDDOCALL = Cursor_cgo_operazioni_dl.GetString("IDDOCALL");
        /* pObj.w_FLGDOCALL := cgo_operazioni_dl->FLGDOCALL */
        pObj.w_FLGDOCALL = Cursor_cgo_operazioni_dl.GetString("FLGDOCALL");
        /* pObj.Check() */
        pObj.Check();
        Cursor_cgo_operazioni_dl.Next();
      }
      m_cConnectivityError = Cursor_cgo_operazioni_dl.ErrorMessage();
      Cursor_cgo_operazioni_dl.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cgo_operazioni_dl!=null)
          Cursor_cgo_operazioni_dl.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(armt_snai_oper_storicoBO p_pObj) {
    pObj = p_pObj;
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
  public Forward Run(armt_snai_oper_storicoBO p_pObj) {
    pObj = p_pObj;
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
  public static arrt_cgo_read_dl_sR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_read_dl_sR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pObj = null;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pObj"};
}
