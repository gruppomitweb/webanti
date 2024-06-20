// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_migrazione_nuova_societaR implements CallerWithObjs {
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
  public java.sql.Date pDataOpe;
  public java.sql.Date pDataReg;
  public String pNomeDataBaseSorgente;
  public String pNomeAziendaSogernteDati;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String ODBCDataSource;
  public String cNewProg;
  public String RAPPORTO_ver;
  public double CPROWNUM_ver;
  public String CONNES_ver;
  public double conta;
  public MemoryCursor_delegabo mc_delegabo_app;
  public MemoryCursor_intestbo mc_intestbo_app;
  public MemoryCursor_rapopebo mc_rapopebo_app;
  public MemoryCursor_rapotit mc_rapotit_app;
  public MemoryCursor_intestit mc_intestit_app;
  public String rapopebo_progressivo;
  public String rapotit_progressivo;
  public boolean isFirst;
  public String cInfProg2;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_migrazione_nuova_societaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_migrazione_nuova_societa",m_Caller);
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("CPROWNUM_ver",p_cVarName)) {
      return CPROWNUM_ver;
    }
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
      return "arrt_migrazione_nuova_societa";
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
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      return cNewProg;
    }
    if (CPLib.eqr("RAPPORTO_ver",p_cVarName)) {
      return RAPPORTO_ver;
    }
    if (CPLib.eqr("CONNES_ver",p_cVarName)) {
      return CONNES_ver;
    }
    if (CPLib.eqr("rapopebo_progressivo",p_cVarName)) {
      return rapopebo_progressivo;
    }
    if (CPLib.eqr("rapotit_progressivo",p_cVarName)) {
      return rapotit_progressivo;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      return cInfProg2;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDataOpe",p_cVarName)) {
      return pDataOpe;
    }
    if (CPLib.eqr("pDataReg",p_cVarName)) {
      return pDataReg;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("isFirst",p_cVarName)) {
      return isFirst;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mc_delegabo_app",p_cVarName)) {
      return mc_delegabo_app;
    }
    if (CPLib.eqr("mc_intestbo_app",p_cVarName)) {
      return mc_intestbo_app;
    }
    if (CPLib.eqr("mc_rapopebo_app",p_cVarName)) {
      return mc_rapopebo_app;
    }
    if (CPLib.eqr("mc_rapotit_app",p_cVarName)) {
      return mc_rapotit_app;
    }
    if (CPLib.eqr("mc_intestit_app",p_cVarName)) {
      return mc_intestit_app;
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
    if (CPLib.eqr("CPROWNUM_ver",p_cVarName)) {
      CPROWNUM_ver = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
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
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      cNewProg = value;
      return;
    }
    if (CPLib.eqr("RAPPORTO_ver",p_cVarName)) {
      RAPPORTO_ver = value;
      return;
    }
    if (CPLib.eqr("CONNES_ver",p_cVarName)) {
      CONNES_ver = value;
      return;
    }
    if (CPLib.eqr("rapopebo_progressivo",p_cVarName)) {
      rapopebo_progressivo = value;
      return;
    }
    if (CPLib.eqr("rapotit_progressivo",p_cVarName)) {
      rapotit_progressivo = value;
      return;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      cInfProg2 = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDataOpe",p_cVarName)) {
      pDataOpe = value;
      return;
    }
    if (CPLib.eqr("pDataReg",p_cVarName)) {
      pDataReg = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("isFirst",p_cVarName)) {
      isFirst = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mc_delegabo_app",p_cVarName)) {
      mc_delegabo_app = (MemoryCursor_delegabo)value;
      return;
    }
    if (CPLib.eqr("mc_intestbo_app",p_cVarName)) {
      mc_intestbo_app = (MemoryCursor_intestbo)value;
      return;
    }
    if (CPLib.eqr("mc_rapopebo_app",p_cVarName)) {
      mc_rapopebo_app = (MemoryCursor_rapopebo)value;
      return;
    }
    if (CPLib.eqr("mc_rapotit_app",p_cVarName)) {
      mc_rapotit_app = (MemoryCursor_rapotit)value;
      return;
    }
    if (CPLib.eqr("mc_intestit_app",p_cVarName)) {
      mc_intestit_app = (MemoryCursor_intestit)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void page_1() throws Exception {
    CPResultSet Cursor_cptsrvr=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_rapotit=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_intestit=null;
    try {
      /* pDataOpe Date // data operazione  */
      /* pDataReg Date // data registrazione operazione */
      /* pNomeDataBaseSorgente Char(0) // Nome del DB sorgente dei dati */
      /* pNomeAziendaSogernteDati Char(0) // Il nome è sufficientemente parlante credo */
      /* gAzienda Char(10) // Azienda Destinazione */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* ODBCDataSource Char(500) // ODBCDataSource letto su cptserver */
      /* cNewProg Char(10) */
      /* RAPPORTO_ver Char(25) */
      /* CPROWNUM_ver Numeric(4, 0) */
      /* CONNES_ver Char(16) */
      /* conta Numeric(10, 0) */
      /* mc_delegabo_app MemoryCursor(delegabo) */
      /* mc_intestbo_app MemoryCursor(intestbo) */
      /* mc_rapopebo_app MemoryCursor(rapopebo) */
      /* mc_rapotit_app MemoryCursor(rapotit) */
      /* mc_intestit_app MemoryCursor(intestit) */
      /* rapopebo_progressivo Char(10) // progressivo di rapopebo */
      /* rapotit_progressivo Char(10) // progressivo di rapotit */
      /* isFirst Bool */
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
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000021status;
        nTry00000021status = m_Sql.GetTransactionStatus();
        String cTry00000021msg;
        cTry00000021msg = m_Sql.TransactionErrorMessage();
        try {
          /* conta := 0 */
          conta = CPLib.Round(0,0);
          /* Utilities.SetAlternativeServer('','delegabo',ODBCDataSource) */
          Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("","delegabo",ODBCDataSource);
          // * --- Fill memory cursor mc_delegabo_app on delegabo
          mc_delegabo_app.Zap();
          m_cServer = m_Ctx.GetServer("delegabo");
          m_cPhName = m_Ctx.GetPhName("delegabo");
          if (Cursor_delegabo!=null)
            Cursor_delegabo.Close();
          Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"[NOTEMPTYDATE(DATAFINE)]=0 "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_delegabo;
            Cursor_delegabo.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_migrazione_nuova_societa: query on delegabo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_delegabo.Eof())) {
            mc_delegabo_app.AppendBlank();
            mc_delegabo_app.row.RAPPORTO = Cursor_delegabo.GetString("RAPPORTO");
            mc_delegabo_app.row.CPROWNUM = Cursor_delegabo.GetDouble("CPROWNUM");
            mc_delegabo_app.row.CODINTER = Cursor_delegabo.GetString("CODINTER");
            mc_delegabo_app.row.DESCINTER = Cursor_delegabo.GetString("DESCINTER");
            mc_delegabo_app.row.DATAINI = Cursor_delegabo.GetDate("DATAINI");
            mc_delegabo_app.row.TIPORAP = Cursor_delegabo.GetString("TIPORAP");
            mc_delegabo_app.row.TIPOPERS = Cursor_delegabo.GetString("TIPOPERS");
            mc_delegabo_app.row.STATOREG = Cursor_delegabo.GetString("STATOREG");
            mc_delegabo_app.row.OPERAZMOD = Cursor_delegabo.GetString("OPERAZMOD");
            mc_delegabo_app.row.DATARETT = Cursor_delegabo.GetDate("DATARETT");
            mc_delegabo_app.row.IDEREG = Cursor_delegabo.GetString("IDEREG");
            mc_delegabo_app.row.COLLEGAMEN = Cursor_delegabo.GetString("COLLEGAMEN");
            mc_delegabo_app.row.DATAFINE = Cursor_delegabo.GetDate("DATAFINE");
            mc_delegabo_app.row.NUMPROG1 = Cursor_delegabo.GetString("NUMPROG1");
            mc_delegabo_app.row.NUMPROG2 = Cursor_delegabo.GetString("NUMPROG2");
            mc_delegabo_app.row.IDBASE = Cursor_delegabo.GetString("IDBASE");
            mc_delegabo_app.row.UCODE = Cursor_delegabo.GetString("UCODE");
            mc_delegabo_app.row.ABBINATO = Cursor_delegabo.GetDouble("ABBINATO");
            mc_delegabo_app.row.NOAGE = Cursor_delegabo.GetString("NOAGE");
            mc_delegabo_app.row.NUMIMP = Cursor_delegabo.GetDateTime("NUMIMP");
            Cursor_delegabo.Next();
          }
          m_cConnectivityError = Cursor_delegabo.ErrorMessage();
          Cursor_delegabo.Close();
          mc_delegabo_app.GoTop();
          /* gMsgProc := gMsgProc +'delegabo: '+mc_delegabo_app.RecCount()+ NL */
          gMsgProc = gMsgProc+"delegabo: "+mc_delegabo_app.RecCount()+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* Utilities.SetAlternativeServer('','intestbo',ODBCDataSource) */
          Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("","intestbo",ODBCDataSource);
          // * --- Fill memory cursor mc_intestbo_app on intestbo
          mc_intestbo_app.Zap();
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"(STATOREG='0'  or  STATOREG='1'  or  STATOREG='')  and  [NOTEMPTYDATE(DATAFINE)]=0 "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_intestbo;
            Cursor_intestbo.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_migrazione_nuova_societa: query on intestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_intestbo.Eof())) {
            mc_intestbo_app.AppendWithTrimmedKey(Cursor_intestbo.GetString("CODINTER"));
            mc_intestbo_app.row.IDBASE = Cursor_intestbo.GetString("IDBASE");
            mc_intestbo_app.row.CPROWNUM = Cursor_intestbo.GetDouble("CPROWNUM");
            mc_intestbo_app.row.DATAINI = Cursor_intestbo.GetDate("DATAINI");
            mc_intestbo_app.row.TIPOPERS = Cursor_intestbo.GetString("TIPOPERS");
            mc_intestbo_app.row.CODINTER = Cursor_intestbo.GetString("CODINTER");
            mc_intestbo_app.row.DATAFINE = Cursor_intestbo.GetDate("DATAFINE");
            mc_intestbo_app.row.NUMPROG1 = Cursor_intestbo.GetString("NUMPROG1");
            mc_intestbo_app.row.NUMPROG2 = Cursor_intestbo.GetString("NUMPROG2");
            mc_intestbo_app.row.RAPPORTO = Cursor_intestbo.GetString("RAPPORTO");
            mc_intestbo_app.row.TIPORAP = Cursor_intestbo.GetString("TIPORAP");
            mc_intestbo_app.row.STATOREG = Cursor_intestbo.GetString("STATOREG");
            mc_intestbo_app.row.DESCINTER = Cursor_intestbo.GetString("DESCINTER");
            mc_intestbo_app.row.OPERAZMOD = Cursor_intestbo.GetString("OPERAZMOD");
            mc_intestbo_app.row.DATARETT = Cursor_intestbo.GetDate("DATARETT");
            mc_intestbo_app.row.IDEREG = Cursor_intestbo.GetString("IDEREG");
            mc_intestbo_app.row.COLLEGAMEN = Cursor_intestbo.GetString("COLLEGAMEN");
            mc_intestbo_app.row.UCODE = Cursor_intestbo.GetString("UCODE");
            mc_intestbo_app.row.ABBINATO = Cursor_intestbo.GetDouble("ABBINATO");
            mc_intestbo_app.row.PRGIMPSOG = Cursor_intestbo.GetDouble("PRGIMPSOG");
            mc_intestbo_app.row.PROQUOTA = Cursor_intestbo.GetDouble("PROQUOTA");
            mc_intestbo_app.row.NUMIMP = Cursor_intestbo.GetDateTime("NUMIMP");
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          mc_intestbo_app.GoTop();
          /* gMsgProc := gMsgProc +'intestbo: '+mc_intestbo_app.RecCount()+ NL */
          gMsgProc = gMsgProc+"intestbo: "+mc_intestbo_app.RecCount()+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* Utilities.SetAlternativeServer('','rapopebo',ODBCDataSource) */
          Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("","rapopebo",ODBCDataSource);
          // * --- Fill memory cursor mc_rapopebo_app on rapopebo
          mc_rapopebo_app.Zap();
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          if (Cursor_rapopebo!=null)
            Cursor_rapopebo.Close();
          Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("rapopebo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_rapopebo;
            Cursor_rapopebo.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_migrazione_nuova_societa: query on rapopebo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_rapopebo.Eof())) {
            mc_rapopebo_app.AppendBlank();
            mc_rapopebo_app.row.IDBASE = Cursor_rapopebo.GetString("IDBASE");
            mc_rapopebo_app.row.NUMPROG = Cursor_rapopebo.GetString("NUMPROG");
            mc_rapopebo_app.row.DATAOPE = Cursor_rapopebo.GetDate("DATAOPE");
            mc_rapopebo_app.row.TIPOINTER = Cursor_rapopebo.GetString("TIPOINTER");
            mc_rapopebo_app.row.CODINTER = Cursor_rapopebo.GetString("CODINTER");
            mc_rapopebo_app.row.TIPOINF = Cursor_rapopebo.GetString("TIPOINF");
            mc_rapopebo_app.row.IDEREG = Cursor_rapopebo.GetString("IDEREG");
            mc_rapopebo_app.row.CODDIPE = Cursor_rapopebo.GetString("CODDIPE");
            mc_rapopebo_app.row.DESCCIT = Cursor_rapopebo.GetString("DESCCIT");
            mc_rapopebo_app.row.PROVINCIA = Cursor_rapopebo.GetString("PROVINCIA");
            mc_rapopebo_app.row.CODCAB = Cursor_rapopebo.GetString("CODCAB");
            mc_rapopebo_app.row.FLAGFRAZ = Cursor_rapopebo.GetString("FLAGFRAZ");
            mc_rapopebo_app.row.FLAGCONT = Cursor_rapopebo.GetString("FLAGCONT");
            mc_rapopebo_app.row.CODANA = Cursor_rapopebo.GetString("CODANA");
            mc_rapopebo_app.row.CODVOC = Cursor_rapopebo.GetString("CODVOC");
            mc_rapopebo_app.row.TIPOINT2 = Cursor_rapopebo.GetString("TIPOINT2");
            mc_rapopebo_app.row.CODINT2 = Cursor_rapopebo.GetString("CODINT2");
            mc_rapopebo_app.row.PAESE = Cursor_rapopebo.GetString("PAESE");
            mc_rapopebo_app.row.DESC2 = Cursor_rapopebo.GetString("DESC2");
            mc_rapopebo_app.row.PROV2 = Cursor_rapopebo.GetString("PROV2");
            mc_rapopebo_app.row.CODCAB2 = Cursor_rapopebo.GetString("CODCAB2");
            mc_rapopebo_app.row.DESCINTER = Cursor_rapopebo.GetString("DESCINTER");
            mc_rapopebo_app.row.RAPPORTO = Cursor_rapopebo.GetString("RAPPORTO");
            mc_rapopebo_app.row.FLAGRAP = Cursor_rapopebo.GetString("FLAGRAP");
            mc_rapopebo_app.row.TIPOLEG = Cursor_rapopebo.GetString("TIPOLEG");
            mc_rapopebo_app.row.DATAREG = Cursor_rapopebo.GetDate("DATAREG");
            mc_rapopebo_app.row.OPRAP = Cursor_rapopebo.GetString("OPRAP");
            mc_rapopebo_app.row.TIPOOPRAP = Cursor_rapopebo.GetString("TIPOOPRAP");
            mc_rapopebo_app.row.FLAGLIRE = Cursor_rapopebo.GetString("FLAGLIRE");
            mc_rapopebo_app.row.VALUTA = Cursor_rapopebo.GetString("VALUTA");
            mc_rapopebo_app.row.SEGNO = Cursor_rapopebo.GetString("SEGNO");
            mc_rapopebo_app.row.TOTLIRE = Cursor_rapopebo.GetDouble("TOTLIRE");
            mc_rapopebo_app.row.TOTCONT = Cursor_rapopebo.GetDouble("TOTCONT");
            mc_rapopebo_app.row.STATOREG = Cursor_rapopebo.GetString("STATOREG");
            mc_rapopebo_app.row.OPERAZMOD = Cursor_rapopebo.GetString("OPERAZMOD");
            mc_rapopebo_app.row.DATARETT = Cursor_rapopebo.GetDate("DATARETT");
            mc_rapopebo_app.row.CONNESCLI = Cursor_rapopebo.GetString("CONNESCLI");
            mc_rapopebo_app.row.CONNESOPER = Cursor_rapopebo.GetString("CONNESOPER");
            mc_rapopebo_app.row.CONNESBEN = Cursor_rapopebo.GetString("CONNESBEN");
            mc_rapopebo_app.row.COLLEG = Cursor_rapopebo.GetString("COLLEG");
            mc_rapopebo_app.row.CAMBIO = Cursor_rapopebo.GetDouble("CAMBIO");
            mc_rapopebo_app.row.RAPPORTBEN = Cursor_rapopebo.GetString("RAPPORTBEN");
            mc_rapopebo_app.row.FLAGRAP2 = Cursor_rapopebo.GetString("FLAGRAP2");
            mc_rapopebo_app.row.OPERATORE = Cursor_rapopebo.GetString("OPERATORE");
            mc_rapopebo_app.row.AUTOM = Cursor_rapopebo.GetString("AUTOM");
            mc_rapopebo_app.row.RESPINS = Cursor_rapopebo.GetString("RESPINS");
            mc_rapopebo_app.row.INFORM = Cursor_rapopebo.GetString("INFORM");
            mc_rapopebo_app.row.DATAAGE = Cursor_rapopebo.GetDate("DATAAGE");
            mc_rapopebo_app.row.UCODE = Cursor_rapopebo.GetString("UCODE");
            mc_rapopebo_app.row.PRGIMPINF = Cursor_rapopebo.GetDouble("PRGIMPINF");
            mc_rapopebo_app.row.UNIQUECODE = Cursor_rapopebo.GetString("UNIQUECODE");
            mc_rapopebo_app.row.CDATOPE = Cursor_rapopebo.GetString("CDATOPE");
            mc_rapopebo_app.row.CDATREG = Cursor_rapopebo.GetString("CDATREG");
            mc_rapopebo_app.row.IDBASE2 = Cursor_rapopebo.GetString("IDBASE2");
            mc_rapopebo_app.row.CONNALTRO = Cursor_rapopebo.GetString("CONNALTRO");
            mc_rapopebo_app.row.NUMIMP = Cursor_rapopebo.GetDateTime("NUMIMP");
            mc_rapopebo_app.row.FLAGTIT = Cursor_rapopebo.GetDouble("FLAGTIT");
            Cursor_rapopebo.Next();
          }
          m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
          Cursor_rapopebo.Close();
          mc_rapopebo_app.GoTop();
          /* gMsgProc := gMsgProc +'rapopebo: '+mc_rapopebo_app.RecCount()+ NL */
          gMsgProc = gMsgProc+"rapopebo: "+mc_rapopebo_app.RecCount()+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* -- Collegamento alle tabelle sorgente dei dati */
          /* Utilities.SetAlternativeServer('','intestit',ODBCDataSource) */
          Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("","intestit",ODBCDataSource);
          /* Utilities.SetAlternativeServer('','anarapbo',ODBCDataSource) */
          Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("","anarapbo",ODBCDataSource);
          /* Utilities.SetAlternativeServer('','personbo',ODBCDataSource) */
          Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("","personbo",ODBCDataSource);
          /* Utilities.SetAlternativeServer('','personbo_agg',ODBCDataSource) */
          Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("","personbo_agg",ODBCDataSource);
          /* Utilities.SetAlternativeServer('','rapotit',ODBCDataSource) */
          Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("","rapotit",ODBCDataSource);
          /* Utilities.SetAlternativeServer('','anadip',ODBCDataSource) */
          Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("","anadip",ODBCDataSource);
          /* -- Pendo i rapporti che hanno qualcosa di attivo */
          // * --- Select from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          if (Cursor_anadip!=null)
            Cursor_anadip.Close();
          Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("anadip")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_anadip.Eof())) {
            /* Exec "Posizionamento DB" Page 8:switchDB('anadip', 'D') */
            switchDB("anadip","D");
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            // * --- Insert into anadip from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anadip",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_migrazione_nuova_societa",167,"00000037")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000037(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("ABICABSARA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("AGACCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("AGENTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("AGEREGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("ANOMOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("CAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("CODAGE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("CODLOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("DESCRIZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("FLGATT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("FLGNOAUA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("FLGWUPOS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("IDCITTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_anadip.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("NAZAGENTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("NUOVO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetDouble("OPXSOSAGE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetDouble("OPXSOSCLI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("TELEFONO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("TERMINALID"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("TIPOSV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anadip.GetString("VALCOMPL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"anadip",true);
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
            Cursor_anadip.Next();
          }
          m_cConnectivityError = Cursor_anadip.ErrorMessage();
          Cursor_anadip.Close();
          // * --- End Select
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"(STATOREG='0'  or  STATOREG='1'  or  STATOREG='')  and  [NOTEMPTYDATE(DATAFINE)]=0 "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* gMsgProc := gMsgProc +'Elaborazione del Rapporto n. '+LRTrim(Str(conta,10,0))+ NL */
            gMsgProc = gMsgProc+"Elaborazione del Rapporto n. "+CPLib.LRTrim(CPLib.Str(conta,10,0))+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* -- Vado a vedere se l'ho già */
            /* Exec "Posizionamento DB" Page 8:switchDB('anarapbo', 'D') */
            switchDB("anarapbo","D");
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* RAPPORTO_ver := '' */
            RAPPORTO_ver = "";
            // * --- Read from anarapbo
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_intestbo.GetString("RAPPORTO"));
            if (m_Ctx.IsSharedTemp("anarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              RAPPORTO_ver = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_migrazione_nuova_societa returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              RAPPORTO_ver = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* Exec "Posizionamento DB" Page 8:switchDB('anarapbo', 'S') */
            switchDB("anarapbo","S");
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* If Empty(RAPPORTO_ver) */
            if (CPLib.Empty(RAPPORTO_ver)) {
              // * --- Select from anarapbo
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              if (Cursor_anarapbo!=null)
                Cursor_anarapbo.Close();
              Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0)+"=RAPPORTO "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_anarapbo.Eof())) {
                /* cNewProg := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
                cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
                /* Exec "Posizionamento DB" Page 8:switchDB('anarapbo', 'D') */
                switchDB("anarapbo","D");
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                // * --- Insert into anarapbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_migrazione_nuova_societa",167,"00000047")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000047(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDate("CADSTATO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("CASTATOC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("CASTATOM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CODICELR"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CODOGG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDate("DATAMOD"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("IBAN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("IMPAPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("IMPCHIU"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("MACODICE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("MITIG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("NOPROT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RAREA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RCOMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RFREQ"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RIMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RRAGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetDouble("RTIPO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("SPLITCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("STATORAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_anarapbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_anarapbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"anarapbo",true);
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
                /* Exec "Posizionamento DB" Page 8:switchDB('anarapbo', 'S') */
                switchDB("anarapbo","S");
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* gMsgProc := gMsgProc +'Inserito rapporto: '+anarapbo->RAPPORTO+ NL */
                gMsgProc = gMsgProc+"Inserito rapporto: "+Cursor_anarapbo.GetString("RAPPORTO")+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                Cursor_anarapbo.Next();
              }
              m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
              Cursor_anarapbo.Close();
              // * --- End Select
            } // End If
            /* Exec "Inserimento Anagrafica" Page 2:insertAnag(intestbo->CODINTER) */
            insertAnag(Cursor_intestbo.GetString("CODINTER"));
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            // * --- Select from delegabo
            m_cServer = m_Ctx.GetServer("delegabo");
            m_cPhName = m_Ctx.GetPhName("delegabo");
            if (Cursor_delegabo!=null)
              Cursor_delegabo.Close();
            Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,RAPPORTO,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_delegabo.Eof())) {
              /* If Empty(delegabo->DATAFINE) */
              if (CPLib.Empty(Cursor_delegabo.GetDate("DATAFINE"))) {
                /* Exec "Inserimento Anagrafica" Page 2:insertAnag(delegabo->CODINTER) */
                insertAnag(Cursor_delegabo.GetString("CODINTER"));
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
              } // End If
              Cursor_delegabo.Next();
            }
            m_cConnectivityError = Cursor_delegabo.ErrorMessage();
            Cursor_delegabo.Close();
            // * --- End Select
            /* -- intestatari */
            for (MemoryCursorRow_rapopebo rw_rapo : mc_rapopebo_app._iterable_()) {
              if (CPLib.eqr(Cursor_intestbo.GetString("RAPPORTO"),rw_rapo.RAPPORTO) && CPLib.eqr(rw_rapo.TIPOOPRAP,"23")) {
                /* isFirst := True */
                isFirst = true;
                for (MemoryCursorRow_intestbo rw_int : mc_intestbo_app._iterable_()) {
                  if (CPLib.eqr(Cursor_intestbo.GetString("RAPPORTO"),rw_int.RAPPORTO)) {
                    /* If isFirst */
                    if (isFirst) {
                      /* Exec "Inserimento Anagrafica" Page 2:insertAnag(rw_rapo.CONNESOPER) */
                      insertAnag(rw_rapo.CONNESOPER);
                      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                        throw new RoutineException();
                      }
                      /* rapopebo_progressivo := insertInfo(rw_rapo, '23') // progressivo di rapopebo */
                      rapopebo_progressivo = insertInfo(rw_rapo,"23");
                      /* isFirst := False */
                      isFirst = false;
                    } // End If
                    /* Exec "Inserimento Intestatario" Page 3:insertIntest(rapopebo_progressivo, rw_int) */
                    insertIntest(rapopebo_progressivo,rw_int);
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                  }
                }
                // Exit Loop
                if (true) {
                  break;
                }
              }
            }
            /* -- delegati */
            for (MemoryCursorRow_rapopebo rw_rapo : mc_rapopebo_app._iterable_()) {
              if (CPLib.eqr(Cursor_intestbo.GetString("RAPPORTO"),rw_rapo.RAPPORTO) && CPLib.eqr(rw_rapo.TIPOOPRAP,"25")) {
                /* isFirst := True */
                isFirst = true;
                for (MemoryCursorRow_delegabo rw_dele : mc_delegabo_app._iterable_()) {
                  if (CPLib.eqr(Cursor_intestbo.GetString("RAPPORTO"),rw_dele.RAPPORTO)) {
                    /* If isFirst */
                    if (isFirst) {
                      /* Exec "Inserimento Anagrafica" Page 2:insertAnag(rw_rapo.CONNESOPER) */
                      insertAnag(rw_rapo.CONNESOPER);
                      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                        throw new RoutineException();
                      }
                      /* rapopebo_progressivo := insertInfo(rw_rapo, '25') // progressivo di rapopebo */
                      rapopebo_progressivo = insertInfo(rw_rapo,"25");
                      /* isFirst := False */
                      isFirst = false;
                    } // End If
                    /* Exec "Inserimento Delegato" Page 4:insertDelega(rapopebo_progressivo, rw_dele) */
                    insertDelega(rapopebo_progressivo,rw_dele);
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                  }
                }
                // Exit Loop
                if (true) {
                  break;
                }
              }
            }
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
          // * --- Fill memory cursor mc_rapotit_app on rapotit
          mc_rapotit_app.Zap();
          m_cServer = m_Ctx.GetServer("rapotit");
          m_cPhName = m_Ctx.GetPhName("rapotit");
          if (Cursor_rapotit!=null)
            Cursor_rapotit.Close();
          Cursor_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"(STATOREG='0'  or  STATOREG='1'  or  STATOREG='')  and  TIPOOPRAP='50' "+")"+(m_Ctx.IsSharedTemp("rapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_rapotit;
            Cursor_rapotit.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_migrazione_nuova_societa: query on rapotit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_rapotit.Eof())) {
            mc_rapotit_app.AppendBlank();
            mc_rapotit_app.row.IDBASE = Cursor_rapotit.GetString("IDBASE");
            mc_rapotit_app.row.DATAOPE = Cursor_rapotit.GetDate("DATAOPE");
            mc_rapotit_app.row.NUMPROG = Cursor_rapotit.GetString("NUMPROG");
            mc_rapotit_app.row.TIPOINTER = Cursor_rapotit.GetString("TIPOINTER");
            mc_rapotit_app.row.CODINTER = Cursor_rapotit.GetString("CODINTER");
            mc_rapotit_app.row.TIPOINF = Cursor_rapotit.GetString("TIPOINF");
            mc_rapotit_app.row.IDEREG = Cursor_rapotit.GetString("IDEREG");
            mc_rapotit_app.row.CODDIPE = Cursor_rapotit.GetString("CODDIPE");
            mc_rapotit_app.row.DESCCIT = Cursor_rapotit.GetString("DESCCIT");
            mc_rapotit_app.row.PROVINCIA = Cursor_rapotit.GetString("PROVINCIA");
            mc_rapotit_app.row.CODCAB = Cursor_rapotit.GetString("CODCAB");
            mc_rapotit_app.row.FLAGFRAZ = Cursor_rapotit.GetString("FLAGFRAZ");
            mc_rapotit_app.row.FLAGCONT = Cursor_rapotit.GetString("FLAGCONT");
            mc_rapotit_app.row.CODANA = Cursor_rapotit.GetString("CODANA");
            mc_rapotit_app.row.CODVOC = Cursor_rapotit.GetString("CODVOC");
            mc_rapotit_app.row.TIPOINT2 = Cursor_rapotit.GetString("TIPOINT2");
            mc_rapotit_app.row.CODINT2 = Cursor_rapotit.GetString("CODINT2");
            mc_rapotit_app.row.PAESE = Cursor_rapotit.GetString("PAESE");
            mc_rapotit_app.row.DESC2 = Cursor_rapotit.GetString("DESC2");
            mc_rapotit_app.row.PROV2 = Cursor_rapotit.GetString("PROV2");
            mc_rapotit_app.row.CODCAB2 = Cursor_rapotit.GetString("CODCAB2");
            mc_rapotit_app.row.DESCINTER = Cursor_rapotit.GetString("DESCINTER");
            mc_rapotit_app.row.RAPPORTO = Cursor_rapotit.GetString("RAPPORTO");
            mc_rapotit_app.row.FLAGRAP = Cursor_rapotit.GetString("FLAGRAP");
            mc_rapotit_app.row.TIPOLEG = Cursor_rapotit.GetString("TIPOLEG");
            mc_rapotit_app.row.DATAREG = Cursor_rapotit.GetDate("DATAREG");
            mc_rapotit_app.row.OPRAP = Cursor_rapotit.GetString("OPRAP");
            mc_rapotit_app.row.TIPOOPRAP = Cursor_rapotit.GetString("TIPOOPRAP");
            mc_rapotit_app.row.FLAGLIRE = Cursor_rapotit.GetString("FLAGLIRE");
            mc_rapotit_app.row.VALUTA = Cursor_rapotit.GetString("VALUTA");
            mc_rapotit_app.row.SEGNO = Cursor_rapotit.GetString("SEGNO");
            mc_rapotit_app.row.TOTLIRE = Cursor_rapotit.GetDouble("TOTLIRE");
            mc_rapotit_app.row.TOTCONT = Cursor_rapotit.GetDouble("TOTCONT");
            mc_rapotit_app.row.STATOREG = Cursor_rapotit.GetString("STATOREG");
            mc_rapotit_app.row.OPERAZMOD = Cursor_rapotit.GetString("OPERAZMOD");
            mc_rapotit_app.row.DATARETT = Cursor_rapotit.GetDate("DATARETT");
            mc_rapotit_app.row.CONNESCLI = Cursor_rapotit.GetString("CONNESCLI");
            mc_rapotit_app.row.CONNESOPER = Cursor_rapotit.GetString("CONNESOPER");
            mc_rapotit_app.row.CONNESBEN = Cursor_rapotit.GetString("CONNESBEN");
            mc_rapotit_app.row.COLLEG = Cursor_rapotit.GetString("COLLEG");
            mc_rapotit_app.row.CAMBIO = Cursor_rapotit.GetDouble("CAMBIO");
            mc_rapotit_app.row.RAPPORTBEN = Cursor_rapotit.GetString("RAPPORTBEN");
            mc_rapotit_app.row.FLAGRAP2 = Cursor_rapotit.GetString("FLAGRAP2");
            mc_rapotit_app.row.OPERATORE = Cursor_rapotit.GetString("OPERATORE");
            mc_rapotit_app.row.AUTOM = Cursor_rapotit.GetString("AUTOM");
            mc_rapotit_app.row.RESPINS = Cursor_rapotit.GetString("RESPINS");
            mc_rapotit_app.row.INFORM = Cursor_rapotit.GetString("INFORM");
            mc_rapotit_app.row.DATAAGE = Cursor_rapotit.GetDate("DATAAGE");
            mc_rapotit_app.row.UCODE = Cursor_rapotit.GetString("UCODE");
            mc_rapotit_app.row.PRGIMPTIT = Cursor_rapotit.GetDouble("PRGIMPTIT");
            mc_rapotit_app.row.CDATOPE = Cursor_rapotit.GetString("CDATOPE");
            mc_rapotit_app.row.UNIQUECODE = Cursor_rapotit.GetString("UNIQUECODE");
            mc_rapotit_app.row.CDATREG = Cursor_rapotit.GetString("CDATREG");
            mc_rapotit_app.row.IDBASE2 = Cursor_rapotit.GetString("IDBASE2");
            mc_rapotit_app.row.NUMIMP = Cursor_rapotit.GetDateTime("NUMIMP");
            Cursor_rapotit.Next();
          }
          m_cConnectivityError = Cursor_rapotit.ErrorMessage();
          Cursor_rapotit.Close();
          mc_rapotit_app.GoTop();
          /* Exec "Posizionamento DB" Page 8:switchDB('personbo', 'D') */
          switchDB("personbo","D");
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("personbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* Exec "Posizionamento DB" Page 8:switchDB('personbo', 'S') */
            switchDB("personbo","S");
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* isFirst := True */
            isFirst = true;
            for (MemoryCursorRow_rapotit rw_rapotit : mc_rapotit_app._iterable_()) {
              if (CPLib.eqr(Cursor_personbo.GetString("CONNES"),rw_rapotit.CONNESCLI)) {
                // * --- Fill memory cursor mc_intestit_app on intestit
                mc_intestit_app.Zap();
                m_cServer = m_Ctx.GetServer("intestit");
                m_cPhName = m_Ctx.GetPhName("intestit");
                if (Cursor_intestit!=null)
                  Cursor_intestit.Close();
                Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG1="+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_rapotit.NUMPROG,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_rapotit.NUMPROG)+"  and  [NOTEMPTYDATE(DATAFINE)]=0 "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_intestit;
                  Cursor_intestit.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_migrazione_nuova_societa: query on intestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_intestit.Eof())) {
                  mc_intestit_app.AppendBlank();
                  mc_intestit_app.row.CODCLI = Cursor_intestit.GetString("CODCLI");
                  mc_intestit_app.row.RAPPORTO = Cursor_intestit.GetString("RAPPORTO");
                  mc_intestit_app.row.CODINTER = Cursor_intestit.GetString("CODINTER");
                  mc_intestit_app.row.DESCINTER = Cursor_intestit.GetString("DESCINTER");
                  mc_intestit_app.row.DATAINI = Cursor_intestit.GetDate("DATAINI");
                  mc_intestit_app.row.TIPORAP = Cursor_intestit.GetString("TIPORAP");
                  mc_intestit_app.row.TIPOPERS = Cursor_intestit.GetString("TIPOPERS");
                  mc_intestit_app.row.STATOREG = Cursor_intestit.GetString("STATOREG");
                  mc_intestit_app.row.OPERAZMOD = Cursor_intestit.GetString("OPERAZMOD");
                  mc_intestit_app.row.DATARETT = Cursor_intestit.GetDate("DATARETT");
                  mc_intestit_app.row.IDEREG = Cursor_intestit.GetString("IDEREG");
                  mc_intestit_app.row.COLLEGAMEN = Cursor_intestit.GetString("COLLEGAMEN");
                  mc_intestit_app.row.DATAFINE = Cursor_intestit.GetDate("DATAFINE");
                  mc_intestit_app.row.NUMPROG1 = Cursor_intestit.GetString("NUMPROG1");
                  mc_intestit_app.row.NUMPROG2 = Cursor_intestit.GetString("NUMPROG2");
                  mc_intestit_app.row.IDBASE = Cursor_intestit.GetString("IDBASE");
                  mc_intestit_app.row.UCODE = Cursor_intestit.GetString("UCODE");
                  mc_intestit_app.row.ABBINATO = Cursor_intestit.GetDouble("ABBINATO");
                  mc_intestit_app.row.PRGIMPTITE = Cursor_intestit.GetDouble("PRGIMPTITE");
                  mc_intestit_app.row.NUMIMP = Cursor_intestit.GetDateTime("NUMIMP");
                  mc_intestit_app.row.NOAGE = Cursor_intestit.GetString("NOAGE");
                  Cursor_intestit.Next();
                }
                m_cConnectivityError = Cursor_intestit.ErrorMessage();
                Cursor_intestit.Close();
                mc_intestit_app.GoTop();
                for (MemoryCursorRow_intestit rw_intestit : mc_intestit_app._iterable_()) {
                  /* If isFirst */
                  if (isFirst) {
                    /* rapotit_progressivo := insertTit(rw_rapotit) // progressivo di rapotit */
                    rapotit_progressivo = insertTit(rw_rapotit);
                    /* isFirst := False */
                    isFirst = false;
                  } // End If
                  /* Exec "Inserimento Anagrafica" Page 2:insertAnag(rw_intestit.CODINTER) */
                  insertAnag(rw_intestit.CODINTER);
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* Exec "Inserimento Titolarità" Page 7:insertInTit(rw_intestit, rapotit_progressivo) */
                  insertInTit(rw_intestit,rapotit_progressivo);
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                }
              }
            }
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
          /* Exec "Posizionamento DB" Page 8:switchDB('personbo', 'S') */
          switchDB("personbo","S");
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* gMsgProc := gMsgProc +'Inserimento in rapotit e intestit: '+ NL */
          gMsgProc = gMsgProc+"Inserimento in rapotit e intestit: "+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* Utilities.ResetAlternativeServer('','intestbo') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","intestbo");
          /* Utilities.ResetAlternativeServer('','anarapbo') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","anarapbo");
          /* Utilities.ResetAlternativeServer('','delegabo') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","delegabo");
          /* Utilities.ResetAlternativeServer('','intestit') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","intestit");
          /* Utilities.ResetAlternativeServer('','rapopebo') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","rapopebo");
          /* Utilities.ResetAlternativeServer('','personbo') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","personbo");
          /* Utilities.ResetAlternativeServer('','personbo_agg') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","personbo_agg");
          /* Utilities.ResetAlternativeServer('','rapotit') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","rapotit");
          /* Utilities.ResetAlternativeServer('','cpazi') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","cpazi");
          /* Utilities.ResetAlternativeServer('','anadip') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","anadip");
          /* Utilities.SetCompany(gAzienda) */
          Utilities.Make(m_Ctx,m_Caller).SetCompany(gAzienda);
          /* gMsgProc := gMsgProc + 'Sono stati trasferiti: ' + LRTrim(Str(conta,10,0)) + ' rapporti' + NL */
          gMsgProc = gMsgProc+"Sono stati trasferiti: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" rapporti"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Aggiornamento massivo di personbo: ' + arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Aggiornamento massivo di personbo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Write into personbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_migrazione_nuova_societa",167,"00000082")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL("","C",10,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"SOTGRUP = "+CPSql.SQLValueAdapter(CPLib.ToSQL("600","?",0,0,m_cServer),m_cServer,"600")+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
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
          /* gMsgProc := gMsgProc + 'Aggiornamento massivo di anarapbo: ' + arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Aggiornamento massivo di anarapbo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Write into anarapbo from all
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_migrazione_nuova_societa",167,"00000084")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"CODOGG = "+CPLib.ToSQL("060","C",3,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
          /* gMsgImp := 'Elaborazione completata con successo!' // Messaggio Import */
          gMsgImp = "Elaborazione completata con successo!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          /* Utilities.ResetAlternativeServer('','intestbo') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","intestbo");
          /* Utilities.ResetAlternativeServer('','anarapbo') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","anarapbo");
          /* Utilities.ResetAlternativeServer('','delegabo') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","delegabo");
          /* Utilities.ResetAlternativeServer('','intestit') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","intestit");
          /* Utilities.ResetAlternativeServer('','rapopebo') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","rapopebo");
          /* Utilities.ResetAlternativeServer('','personbo') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","personbo");
          /* Utilities.ResetAlternativeServer('','personbo_agg') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","personbo_agg");
          /* Utilities.ResetAlternativeServer('','rapotit') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","rapotit");
          /* Utilities.ResetAlternativeServer('','cpazi') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","cpazi");
          /* Utilities.ResetAlternativeServer('','anadip') */
          Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","anadip");
          /* Utilities.SetCompany(gAzienda) */
          Utilities.Make(m_Ctx,m_Caller).SetCompany(gAzienda);
          /* gMsgProc := gMsgProc + 'Elaborazione non portata a termine' + NL */
          gMsgProc = gMsgProc+"Elaborazione non portata a termine"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := 'Elaborazione abortita!' // Messaggio Import */
          gMsgImp = "Elaborazione abortita!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000021status,0)) {
            m_Sql.SetTransactionStatus(nTry00000021status,cTry00000021msg);
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
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
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
      try {
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_rapotit!=null)
          Cursor_rapotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void insertAnag(String pconnes) throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo_agg=null;
    try {
      /* -- Inserimento in personbo e personbo_agg */
      /* pconnes Char(16) */
      /* CONNES_ver Char(16) */
      String CONNES_ver;
      CONNES_ver = CPLib.Space(16);
      /* Exec "Posizionamento DB" Page 8:switchDB('personbo', 'S') */
      switchDB("personbo","S");
      // * --- Select from personbo
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      if (Cursor_personbo!=null)
        Cursor_personbo.Close();
      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pconnes,"?",0,0,m_cServer, m_oParameters),m_cServer,pconnes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_personbo.Eof())) {
        /* Exec "Posizionamento DB" Page 8:switchDB('personbo', 'D') */
        switchDB("personbo","D");
        /* CONNES_ver := '' */
        CONNES_ver = "";
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pconnes,"C",16,0,m_cServer),m_cServer,pconnes);
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          CONNES_ver = Read_Cursor.GetString("CONNES");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_migrazione_nuova_societa returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          CONNES_ver = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(CONNES_ver) */
        if (CPLib.Empty(CONNES_ver)) {
          /* cNewProg := Utilities.GetAutonumber("PRGIMPOCLI\'"+LRTrim(gAzienda)+"'",Space(10),10) */
          cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOCLI\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
          // * --- Insert into personbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_migrazione_nuova_societa",167,"000000A5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000A5(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATONOMECNOME"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("BANCABEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CITTADIN1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CITTADIN2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODORO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAPROF"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVARAGE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATEXTRA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("FATCA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("FLGVALIDO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDNASCOMUN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDNASSTATO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("MITIG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOSARA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("NOTIT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ODB"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCONNES"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROGIMP_C"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOCOLD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RESFISC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TELEF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOORO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
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
          /* Exec "Posizionamento DB" Page 8:switchDB('personbo_agg', 'S') */
          switchDB("personbo_agg","S");
          // * --- Select from personbo_agg
          m_cServer = m_Ctx.GetServer("personbo_agg");
          m_cPhName = m_Ctx.GetPhName("personbo_agg");
          if (Cursor_personbo_agg!=null)
            Cursor_personbo_agg.Close();
          Cursor_personbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo_agg.Eof())) {
            /* Exec "Posizionamento DB" Page 8:switchDB('personbo_agg', 'D') */
            switchDB("personbo_agg","D");
            // * --- Insert into personbo_agg from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo_agg");
            m_cPhName = m_Ctx.GetPhName("personbo_agg");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_migrazione_nuova_societa",167,"000000A9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000A9(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("EMAIL"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGEMAIL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("TELEFONO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("RDCODAUT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("RDLOCAUT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGBANCA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGVALIDO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("REGRES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGBL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetDouble("CLOCCUPA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("NUMTEL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("NAZIONE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("LASTOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CODCLIEST"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGANAVAL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CLPRVDOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetDouble("MITIG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGPREGIUD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGTRUST"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGRISCHIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGEQUIFIN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGFALSADIC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGRICINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("WUGID"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("WUNAZRILDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("WUCOGNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("WUNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("WULUONAS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
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
            /* Exec "Posizionamento DB" Page 8:switchDB('personbo_agg', 'S') */
            switchDB("personbo_agg","S");
            Cursor_personbo_agg.Next();
          }
          m_cConnectivityError = Cursor_personbo_agg.ErrorMessage();
          Cursor_personbo_agg.Close();
          // * --- End Select
        } // End If
        /* Exec "Posizionamento DB" Page 8:switchDB('personbo', 'S') */
        switchDB("personbo","S");
        Cursor_personbo.Next();
      }
      m_cConnectivityError = Cursor_personbo.ErrorMessage();
      Cursor_personbo.Close();
      // * --- End Select
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
      try {
        if (Cursor_personbo_agg!=null)
          Cursor_personbo_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void insertIntest(String pProgressivo,MemoryCursorRow_intestbo rw_intest) throws Exception {
    CPResultSet Cursor_intestbo=null;
    try {
      /* -- Inserimento in intestbo */
      /* pProgressivo Char(11) */
      /* rw_intest Row(intestbo) */
      /* Exec "Posizionamento DB" Page 8:switchDB('intestbo', 'D') */
      switchDB("intestbo","D");
      /* CPROWNUM_ver := 0 */
      CPROWNUM_ver = CPLib.Round(0,0);
      // * --- Select from intestbo
      m_cServer = m_Ctx.GetServer("intestbo");
      m_cPhName = m_Ctx.GetPhName("intestbo");
      if (Cursor_intestbo!=null)
        Cursor_intestbo.Close();
      Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CPROWNUM  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_intest.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_intest.RAPPORTO)+"=RAPPORTO "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM DESC ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_intestbo.Eof())) {
        /* CPROWNUM_ver := intestbo->CPROWNUM */
        CPROWNUM_ver = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
        // Exit Loop
        if (true) {
          break;
        }
        Cursor_intestbo.Next();
      }
      m_cConnectivityError = Cursor_intestbo.ErrorMessage();
      Cursor_intestbo.Close();
      // * --- End Select
      /* CPROWNUM_ver := CPROWNUM_ver+1 */
      CPROWNUM_ver = CPLib.Round(CPROWNUM_ver+1,0);
      // * --- Insert into intestbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("intestbo");
      m_cPhName = m_Ctx.GetPhName("intestbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_migrazione_nuova_societa",167,"000000B7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000000B7(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_intest.IDBASE,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPROWNUM_ver,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(pDataOpe,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_intest.TIPOPERS,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQLNull(rw_intest.CODINTER,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(pProgressivo,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_intest.RAPPORTO,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_intest.TIPORAP,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_intest.DESCINTER,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_intest.OPERAZMOD,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_intest.IDEREG,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_intest.COLLEGAMEN,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_intest.UCODE,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_intest.ABBINATO,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG",0,10),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_intest.PROQUOTA,"?",0,0)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"intestbo",true);
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
      /* Exec "Posizionamento DB" Page 8:switchDB('intestbo', 'S') */
      switchDB("intestbo","S");
    } finally {
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void insertDelega(String pProgressivo,MemoryCursorRow_delegabo rw_delegato) throws Exception {
    CPResultSet Cursor_delegabo=null;
    try {
      /* -- inserimento in delegabo */
      /* pProgressivo Char(11) */
      /* rw_delegato Row(delegabo) */
      /* Exec "Posizionamento DB" Page 8:switchDB('delegabo', 'D') */
      switchDB("delegabo","D");
      /* CPROWNUM_ver := 0 */
      CPROWNUM_ver = CPLib.Round(0,0);
      // * --- Select from delegabo
      m_cServer = m_Ctx.GetServer("delegabo");
      m_cPhName = m_Ctx.GetPhName("delegabo");
      if (Cursor_delegabo!=null)
        Cursor_delegabo.Close();
      Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CPROWNUM  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_delegato.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_delegato.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM DESC ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_delegabo.Eof())) {
        /* CPROWNUM_ver := delegabo->CPROWNUM */
        CPROWNUM_ver = CPLib.Round(Cursor_delegabo.GetDouble("CPROWNUM"),0);
        // Exit Loop
        if (true) {
          break;
        }
        Cursor_delegabo.Next();
      }
      m_cConnectivityError = Cursor_delegabo.ErrorMessage();
      Cursor_delegabo.Close();
      // * --- End Select
      /* CPROWNUM_ver := CPROWNUM_ver+1 */
      CPROWNUM_ver = CPLib.Round(CPROWNUM_ver+1,0);
      // * --- Insert into delegabo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("delegabo");
      m_cPhName = m_Ctx.GetPhName("delegabo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_migrazione_nuova_societa",167,"000000C4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000000C4(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_delegato.ABBINATO,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_delegato.CODINTER,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_delegato.COLLEGAMEN,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPROWNUM_ver,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_delegato.DATAFINE,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(pDataOpe,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_delegato.DESCINTER,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_delegato.IDBASE,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_delegato.IDEREG,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_delegato.NOAGE,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(pProgressivo,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_delegato.OPERAZMOD,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_delegato.RAPPORTO,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_delegato.TIPOPERS,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_delegato.TIPORAP,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(rw_delegato.UCODE,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"delegabo",true);
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
      /* Exec "Posizionamento DB" Page 8:switchDB('delegabo', 'S') */
      switchDB("delegabo","S");
    } finally {
      try {
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  String insertInfo(MemoryCursorRow_rapopebo rw_rapopebo,String pTipoOper) throws Exception {
    /* -- inserimento in rapopebo */
    /* rw_rapopebo Row(rapopebo) */
    /* pTipoOper Char(0) */
    /* cInfProg1 Char(10) // idbase */
    String cInfProg1;
    cInfProg1 = CPLib.Space(10);
    /* cInfProg2 Char(11) // numprog */
    /* nProgImp Numeric(15, 0) */
    double nProgImp;
    nProgImp = 0;
    /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
    cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
    /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
    cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
    /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
    nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
    /* Exec "Posizionamento DB" Page 8:switchDB('rapopebo', 'D') */
    switchDB("rapopebo","D");
    // * --- Insert into rapopebo from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("rapopebo");
    m_cPhName = m_Ctx.GetPhName("rapopebo");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_migrazione_nuova_societa",167,"000000D2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
    m_cSql = m_cSql+GetFieldsName_000000D2(m_Ctx,m_oWrInfo);
    m_cSql = m_cSql+") values (";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.AUTOM,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.CAMBIO,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(pDataOpe),"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(pDataReg),"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.CODANA,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.CODCAB,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.CODCAB2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQLNull(rw_rapopebo.CODDIPE,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.CODINT2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.CODINTER,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.CODVOC,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.CONNALTRO,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.CONNESBEN,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.CONNESCLI,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQLNull(rw_rapopebo.CONNESOPER,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.DATAAGE,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(pDataOpe,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(pDataReg,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.DESC2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.DESCCIT,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.DESCINTER,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.FLAGCONT,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.FLAGLIRE,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.FLAGRAP,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.FLAGRAP2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.IDBASE2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL("I"+CPLib.Right(cInfProg2,9)+rw_rapopebo.IDBASE2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.INFORM,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.OPERATORE,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.OPERAZMOD,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.OPRAP,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.PAESE,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.PROV2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.PROVINCIA,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQLNull(rw_rapopebo.RAPPORTO,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.RESPINS,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.SEGNO,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.TIPOINF,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.TIPOINT2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.TIPOINTER,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQLNull(rw_rapopebo.TIPOLEG,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQLNull(pTipoOper,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.TOTCONT,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.TOTLIRE,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.UCODE,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.UNIQUECODE,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapopebo.VALUTA,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+m_oWrInfo.InsertValues();
    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"rapopebo",true);
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
    /* Exec "Posizionamento DB" Page 8:switchDB('rapopebo', 'S') */
    switchDB("rapopebo","S");
    /* Page Return cInfProg2 */
    return cInfProg2;
  }
  String insertTit(MemoryCursorRow_rapotit rw_rapotit_ins) throws Exception {
    /* -- inserimento in rapotit */
    /* rw_rapotit_ins Row(rapotit) */
    /* cInfProg1 Char(10) // idbase */
    String cInfProg1;
    cInfProg1 = CPLib.Space(10);
    /* cInfProg2 Char(11) // numprog */
    /* nProgImp Numeric(15, 0) */
    double nProgImp;
    nProgImp = 0;
    /* cInfProg1 := Utilities.GetAutonumber("PRGTITO1\'"+LRTrim(gAzienda)+"'",'',10) */
    cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
    /* cInfProg2 := Utilities.GetAutonumber("PRGTITO2\'"+LRTrim(gAzienda)+"'",'',11) */
    cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
    /* nProgImp := Utilities.GetAutonumber("PRGIMPTIT\'"+LRTrim(gAzienda)+"'",0,15) */
    nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPTIT\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
    /* Exec "Posizionamento DB" Page 8:switchDB('rapotit', 'D') */
    switchDB("rapotit","D");
    // * --- Insert into rapotit from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("rapotit");
    m_cPhName = m_Ctx.GetPhName("rapotit");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_migrazione_nuova_societa",167,"000000E0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
    m_cSql = m_cSql+GetFieldsName_000000E0(m_Ctx,m_oWrInfo);
    m_cSql = m_cSql+") values (";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.AUTOM,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.CAMBIO,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.CDATOPE,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.CDATREG,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.CODANA,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.CODCAB,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.CODCAB2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.CODDIPE,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.CODINT2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.CODINTER,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.CODVOC,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.COLLEG,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.CONNESBEN,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.CONNESCLI,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.CONNESOPER,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.DATAAGE,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(pDataOpe,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(pDataReg,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.DESC2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.DESCCIT,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.DESCINTER,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.FLAGCONT,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.FLAGFRAZ,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.FLAGLIRE,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.FLAGRAP,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.FLAGRAP2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.IDBASE2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL("T"+CPLib.Right(cInfProg2,9)+rw_rapotit_ins.IDBASE2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.INFORM,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.OPERATORE,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.OPERAZMOD,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.OPRAP,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.PAESE,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.PROV2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.PROVINCIA,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.RAPPORTBEN,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.RAPPORTO,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.RESPINS,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.SEGNO,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.TIPOINF,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.TIPOINT2,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.TIPOINTER,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.TIPOOPRAP,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.TOTCONT,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.TOTLIRE,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.UCODE,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.UNIQUECODE,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_rapotit_ins.VALUTA,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+m_oWrInfo.InsertValues();
    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"rapotit",true);
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
    /* Exec "Posizionamento DB" Page 8:switchDB('rapotit', 'S') */
    switchDB("rapotit","S");
    /* Page Return cInfProg2 */
    return cInfProg2;
  }
  void insertInTit(MemoryCursorRow_intestit rw_intestit_ins,String pProgressivo) throws Exception {
    /* -- inserimento in intestit */
    /* rw_intestit_ins Row(intestit) */
    /* pProgressivo Char(11) // numprog */
    /* Exec "Posizionamento DB" Page 8:switchDB('intestit', 'D') */
    switchDB("intestit","D");
    // * --- Insert into intestit from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("intestit");
    m_cPhName = m_Ctx.GetPhName("intestit");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestit",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_migrazione_nuova_societa",167,"000000E8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
    m_cSql = m_cSql+GetFieldsName_000000E8(m_Ctx,m_oWrInfo);
    m_cSql = m_cSql+") values (";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestit_ins.ABBINATO,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestit_ins.CODCLI,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestit_ins.CODINTER,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestit_ins.COLLEGAMEN,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(pDataOpe,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestit_ins.DESCINTER,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestit_ins.IDBASE,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestit_ins.IDEREG,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(pProgressivo,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestit_ins.OPERAZMOD,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPTITE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestit_ins.RAPPORTO,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestit_ins.STATOREG,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestit_ins.TIPOPERS,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestit_ins.TIPORAP,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestit_ins.UCODE,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+m_oWrInfo.InsertValues();
    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"intestit",true);
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
    /* Exec "Posizionamento DB" Page 8:switchDB('intestit', 'S') */
    switchDB("intestit","S");
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
  public String RunAsync(java.sql.Date p_pDataOpe,java.sql.Date p_pDataReg,String p_pNomeDataBaseSorgente,String p_pNomeAziendaSogernteDati) {
    pDataOpe = p_pDataOpe;
    pDataReg = p_pDataReg;
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
  public Forward Run(java.sql.Date p_pDataOpe,java.sql.Date p_pDataReg,String p_pNomeDataBaseSorgente,String p_pNomeAziendaSogernteDati) {
    pDataOpe = p_pDataOpe;
    pDataReg = p_pDataReg;
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
  public static arrt_migrazione_nuova_societaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_migrazione_nuova_societaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pDataOpe = CPLib.NullDate();
    pDataReg = CPLib.NullDate();
    pNomeDataBaseSorgente = CPLib.Space(0);
    pNomeAziendaSogernteDati = CPLib.Space(0);
    ODBCDataSource = CPLib.Space(500);
    cNewProg = CPLib.Space(10);
    RAPPORTO_ver = CPLib.Space(25);
    CPROWNUM_ver = 0;
    CONNES_ver = CPLib.Space(16);
    conta = 0;
    mc_delegabo_app = new MemoryCursor_delegabo();
    mc_intestbo_app = new MemoryCursor_intestbo();
    mc_rapopebo_app = new MemoryCursor_rapopebo();
    mc_rapotit_app = new MemoryCursor_rapotit();
    mc_intestit_app = new MemoryCursor_intestit();
    rapopebo_progressivo = CPLib.Space(10);
    rapotit_progressivo = CPLib.Space(10);
    isFirst = false;
    cInfProg2 = CPLib.Space(11);
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
  public static String[] m_cRunParameterNames={"pDataOpe","pDataReg","pNomeDataBaseSorgente","pNomeAziendaSogernteDati"};
  protected static String GetFieldsName_00000037(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ABICABSARA,";
    p_cSql = p_cSql+"AGACCODE,";
    p_cSql = p_cSql+"AGENTE,";
    p_cSql = p_cSql+"AGEREGIO,";
    p_cSql = p_cSql+"ANOMOPER,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"CAB2,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+"CODAGE,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"CODLOC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"FLGATT,";
    p_cSql = p_cSql+"FLGNOAUA,";
    p_cSql = p_cSql+"FLGWUPOS,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDCITTA,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"NAZAGENTE,";
    p_cSql = p_cSql+"NUOVO,";
    p_cSql = p_cSql+"OPXSOSAGE,";
    p_cSql = p_cSql+"OPXSOSCLI,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"TERMINALID,";
    p_cSql = p_cSql+"TIPOSV,";
    p_cSql = p_cSql+"VALCOMPL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anadip",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000047(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"CADSTATO,";
    p_cSql = p_cSql+"CASTATOC,";
    p_cSql = p_cSql+"CASTATOM,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODICELR,";
    p_cSql = p_cSql+"CODOGG,";
    p_cSql = p_cSql+"CONTINUA,";
    p_cSql = p_cSql+"DAC6,";
    p_cSql = p_cSql+"DATAMOD,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGDAC6,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDRAPPORTO,";
    p_cSql = p_cSql+"IMPAPE,";
    p_cSql = p_cSql+"IMPCHIU,";
    p_cSql = p_cSql+"MACODICE,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITIGDOC,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SPLITCODE,";
    p_cSql = p_cSql+"STATORAP,";
    p_cSql = p_cSql+"TIPMOD,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"BANCABEN,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CITTADIN1,";
    p_cSql = p_cSql+"CITTADIN2,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODORO,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"DATAPROF,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATASEGN,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DATAVARAGE,";
    p_cSql = p_cSql+"DATEXTRA,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"FATCA,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcitta,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IDNASCOMUN,";
    p_cSql = p_cSql+"IDNASSTATO,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"NOSARA,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NOTIT,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"ODB,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"OLDCONNES,";
    p_cSql = p_cSql+"OLDSETSIN,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"PROGIMP_C,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAGSOCOLD,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESFISC,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"SETTSINT2,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"SPOTID,";
    p_cSql = p_cSql+"TELEF,";
    p_cSql = p_cSql+"TIN,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"TIPOORO,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"EMAIL,";
    p_cSql = p_cSql+"FLGEMAIL,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"RDCODAUT,";
    p_cSql = p_cSql+"RDLOCAUT,";
    p_cSql = p_cSql+"FLGBANCA,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+"REGRES,";
    p_cSql = p_cSql+"FLGBL,";
    p_cSql = p_cSql+"CLOCCUPA,";
    p_cSql = p_cSql+"NUMTEL,";
    p_cSql = p_cSql+"NAZIONE,";
    p_cSql = p_cSql+"LASTOPER,";
    p_cSql = p_cSql+"CODCLIEST,";
    p_cSql = p_cSql+"FLGANAVAL,";
    p_cSql = p_cSql+"CLPRVDOM,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+"FLGPREGIUD,";
    p_cSql = p_cSql+"FLGTRUST,";
    p_cSql = p_cSql+"FLGRISCHIO,";
    p_cSql = p_cSql+"FLGEQUIFIN,";
    p_cSql = p_cSql+"FLGFALSADIC,";
    p_cSql = p_cSql+"FLGRICINF,";
    p_cSql = p_cSql+"WUGID,";
    p_cSql = p_cSql+"WUNAZRILDOC,";
    p_cSql = p_cSql+"WUCOGNOME,";
    p_cSql = p_cSql+"WUNOME,";
    p_cSql = p_cSql+"WULUONAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+"PROQUOTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NOAGE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"delegabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPTIT,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapotit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"CODCLI,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"PRGIMPTITE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestit",true);
    return p_cSql;
  }
}
