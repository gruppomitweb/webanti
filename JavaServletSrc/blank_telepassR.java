// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class blank_telepassR implements CallerWithObjs {
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
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
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
  public java.sql.Date datini;
  public double _conta;
  public String gMsgAll;
  public MemoryCursor_personbo mcProva;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public blank_telepassR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("blank_telepass",m_Caller);
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "blank_telepass";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("gMsgAll",p_cVarName)) {
      return gMsgAll;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("datini",p_cVarName)) {
      return datini;
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
    if (CPLib.eqr("mcProva",p_cVarName)) {
      return mcProva;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gMsgAll",p_cVarName)) {
      gMsgAll = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("datini",p_cVarName)) {
      datini = value;
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
    if (CPLib.eqr("mcProva",p_cVarName)) {
      mcProva = (MemoryCursor_personbo)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_personbo=null;
    try {
      /* Definisce la data limite */
      /* datini Date */
      /* _conta Numeric(15, 0) */
      /* gMsgAll Char(120) // Messaggio allineamento 1 */
      /* -- */
      /* mcProva MemoryCursor(personbo) */
      // * --- Fill memory cursor mcProva on personbo
      mcProva.Zap();
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      if (Cursor_personbo!=null)
        Cursor_personbo.Close();
      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("personbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_personbo;
        Cursor_personbo.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine blank_telepass: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_personbo.Eof())) {
        mcProva.AppendWithTrimmedKey(Cursor_personbo.GetString("CONNES"));
        mcProva.row.CONNES = Cursor_personbo.GetString("CONNES");
        mcProva.row.CODCAB = Cursor_personbo.GetString("CODCAB");
        mcProva.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
        mcProva.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
        mcProva.row.CODFISC = Cursor_personbo.GetString("CODFISC");
        mcProva.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
        mcProva.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
        mcProva.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
        mcProva.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
        mcProva.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
        mcProva.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
        mcProva.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
        mcProva.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
        mcProva.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
        mcProva.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
        mcProva.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
        mcProva.row.PAESE = Cursor_personbo.GetString("PAESE");
        mcProva.row.CAP = Cursor_personbo.GetString("CAP");
        mcProva.row.CODINTER = Cursor_personbo.GetString("CODINTER");
        mcProva.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
        mcProva.row.TIPOPERS = Cursor_personbo.GetString("TIPOPERS");
        mcProva.row.CODDIPE = Cursor_personbo.GetString("CODDIPE");
        mcProva.row.PARTIVA = Cursor_personbo.GetString("PARTIVA");
        mcProva.row.NOTE = Cursor_personbo.GetString("NOTE");
        mcProva.row.SESSO = Cursor_personbo.GetString("SESSO");
        mcProva.row.SOSPMAF = Cursor_personbo.GetString("SOSPMAF");
        mcProva.row.idcitta = Cursor_personbo.GetString("idcitta");
        mcProva.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
        mcProva.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
        mcProva.row.DOCFILE = Cursor_personbo.GetString("DOCFILE");
        mcProva.row.NOME = Cursor_personbo.GetString("NOME");
        mcProva.row.COGNOME = Cursor_personbo.GetString("COGNOME");
        mcProva.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
        mcProva.row.OLDCONNES = Cursor_personbo.GetString("OLDCONNES");
        mcProva.row.DATEXTRA = Cursor_personbo.GetDate("DATEXTRA");
        mcProva.row.PKTBSPECIE = Cursor_personbo.GetString("PKTBSPECIE");
        mcProva.row.COMPORT = Cursor_personbo.GetString("COMPORT");
        mcProva.row.ATTIV = Cursor_personbo.GetString("ATTIV");
        mcProva.row.RNATGIU = Cursor_personbo.GetDouble("RNATGIU");
        mcProva.row.RATTIV = Cursor_personbo.GetDouble("RATTIV");
        mcProva.row.RCOMP = Cursor_personbo.GetDouble("RCOMP");
        mcProva.row.RAREA = Cursor_personbo.GetDouble("RAREA");
        mcProva.row.ALLINEATO = Cursor_personbo.GetDouble("ALLINEATO");
        mcProva.row.ALLINEATONOMECNOME = Cursor_personbo.GetDouble("ALLINEATONOMECNOME");
        mcProva.row.RAGSOCOLD = Cursor_personbo.GetString("RAGSOCOLD");
        mcProva.row.PROGIMPORT = Cursor_personbo.GetDouble("PROGIMPORT");
        mcProva.row.PROGIMP_C = Cursor_personbo.GetString("PROGIMP_C");
        mcProva.row.AREAGEO = Cursor_personbo.GetString("AREAGEO");
        mcProva.row.PEP = Cursor_personbo.GetString("PEP");
        mcProva.row.IDFILE = Cursor_personbo.GetString("IDFILE");
        mcProva.row.OLDCODFISC = Cursor_personbo.GetString("OLDCODFISC");
        mcProva.row.MACROAGENTE = Cursor_personbo.GetString("MACROAGENTE");
        mcProva.row.SPOTID = Cursor_personbo.GetString("SPOTID");
        mcProva.row.DATASEGN = Cursor_personbo.GetDate("DATASEGN");
        mcProva.row.OLDSETSIN = Cursor_personbo.GetString("OLDSETSIN");
        mcProva.row.DATAVARAGE = Cursor_personbo.GetDate("DATAVARAGE");
        mcProva.row.SETTSINT2 = Cursor_personbo.GetString("SETTSINT2");
        mcProva.row.FATCA = Cursor_personbo.GetString("FATCA");
        mcProva.row.BANCABEN = Cursor_personbo.GetString("BANCABEN");
        mcProva.row.TIN = Cursor_personbo.GetString("TIN");
        mcProva.row.ODB = Cursor_personbo.GetDouble("ODB");
        mcProva.row.TELEF = Cursor_personbo.GetString("TELEF");
        mcProva.row.TIPOORO = Cursor_personbo.GetString("TIPOORO");
        mcProva.row.CODORO = Cursor_personbo.GetString("CODORO");
        mcProva.row.IDNASCOMUN = Cursor_personbo.GetString("IDNASCOMUN");
        mcProva.row.IDNASSTATO = Cursor_personbo.GetString("IDNASSTATO");
        mcProva.row.NOTIT = Cursor_personbo.GetDouble("NOTIT");
        mcProva.row.IDBASE = Cursor_personbo.GetString("IDBASE");
        mcProva.row.FLGVALIDO = Cursor_personbo.GetString("FLGVALIDO");
        mcProva.row.CITTADIN1 = Cursor_personbo.GetString("CITTADIN1");
        mcProva.row.CITTADIN2 = Cursor_personbo.GetString("CITTADIN2");
        mcProva.row.RESFISC = Cursor_personbo.GetString("RESFISC");
        mcProva.row.MITIG = Cursor_personbo.GetDouble("MITIG");
        mcProva.row.MITIGDOC = Cursor_personbo.GetString("MITIGDOC");
        mcProva.row.NOSARA = Cursor_personbo.GetString("NOSARA");
        mcProva.row.RISGLOB = Cursor_personbo.GetString("RISGLOB");
        mcProva.row.DATAPROF = Cursor_personbo.GetDate("DATAPROF");
        mcProva.row.DATAREVPROF = Cursor_personbo.GetDate("DATAREVPROF");
        mcProva.row.IDENT = Cursor_personbo.GetString("IDENT");
        mcProva.row.PEPDATE = Cursor_personbo.GetDate("PEPDATE");
        mcProva.row.DAC6 = Cursor_personbo.GetString("DAC6");
        mcProva.row.FLAGDAC6 = Cursor_personbo.GetDouble("FLAGDAC6");
        mcProva.row.CRIME = Cursor_personbo.GetString("CRIME");
        mcProva.row.CRIMEDATE = Cursor_personbo.GetDate("CRIMEDATE");
        mcProva.row.ALTRODOM = Cursor_personbo.GetString("ALTRODOM");
        mcProva.row.ALTROCAP = Cursor_personbo.GetString("ALTROCAP");
        mcProva.row.CONTO = Cursor_personbo.GetString("CONTO");
        mcProva.row.NUMIMP = Cursor_personbo.GetDateTime("NUMIMP");
        mcProva.row.RAPSEGNA = Cursor_personbo.GetString("RAPSEGNA");
        mcProva.row.CODLEGRAP = Cursor_personbo.GetString("CODLEGRAP");
        mcProva.row.TIPOSOGGETTO = Cursor_personbo.GetString("TIPOSOGGETTO");
        mcProva.row.CAUSALE = Cursor_personbo.GetDouble("CAUSALE");
        mcProva.row.IMPORTOMAX = Cursor_personbo.GetDouble("IMPORTOMAX");
        mcProva.row.FATTURATO = Cursor_personbo.GetDouble("FATTURATO");
        mcProva.row.FREQUENZA = Cursor_personbo.GetString("FREQUENZA");
        mcProva.row.NUMOPERAZ = Cursor_personbo.GetDouble("NUMOPERAZ");
        mcProva.row.SOGAFFIDATARIO = Cursor_personbo.GetString("SOGAFFIDATARIO");
        mcProva.row.FLGNOTRIM = Cursor_personbo.GetString("FLGNOTRIM");
        mcProva.row.DISATTIVO = Cursor_personbo.GetDate("DISATTIVO");
        mcProva.row.DATAFINE = Cursor_personbo.GetDate("DATAFINE");
        mcProva.row.DATAINI = Cursor_personbo.GetDate("DATAINI");
        mcProva.row.DATAIDENT = Cursor_personbo.GetDate("DATAIDENT");
        mcProva.row.DATASIGN = Cursor_personbo.GetDate("DATASIGN");
        mcProva.row.DATARAUT = Cursor_personbo.GetDate("DATARAUT");
        mcProva.row.VERIFICA = Cursor_personbo.GetString("VERIFICA");
        mcProva.row.NOTERIS = Cursor_personbo.GetString("NOTERIS");
        Cursor_personbo.Next();
      }
      m_cConnectivityError = Cursor_personbo.ErrorMessage();
      Cursor_personbo.Close();
      mcProva.GoTop();
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static blank_telepassR Make(CPContext p_Ctx, Caller p_Caller) {
    return new blank_telepassR(p_Ctx, p_Caller);
  }
  public void Blank() {
    datini = CPLib.NullDate();
    _conta = 0;
    mcProva = new MemoryCursor_personbo();
    gMsgAll=m_Ctx.GetGlobalString("gMsgAll");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
