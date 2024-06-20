// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_mcpersonbo_altrodbR implements CallerWithObjs {
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
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
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
  public String likeconnes;
  public String likeragsoc;
  public String likecodfisc;
  public String likecitta;
  public String gAzienda;
  public String ODBCDataSource;
  public String pNomeAziendaSogernteDati;
  public MemoryCursor_personbo mcpersonbo;
  public String sql_A;
  public String sql_B;
  public String sql_C;
  public String sql_D;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_mcpersonbo_altrodbR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_mcpersonbo_altrodb",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_cptsrvr = p_ContextObject.GetPhName("cptsrvr");
    if (m_cPhName_cptsrvr.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cptsrvr = m_cPhName_cptsrvr+" "+m_Ctx.GetWritePhName("cptsrvr");
    }
    m_cServer_cptsrvr = p_ContextObject.GetServer("cptsrvr");
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
      return "arfn_mcpersonbo_altrodb";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("likeconnes",p_cVarName)) {
      return likeconnes;
    }
    if (CPLib.eqr("likeragsoc",p_cVarName)) {
      return likeragsoc;
    }
    if (CPLib.eqr("likecodfisc",p_cVarName)) {
      return likecodfisc;
    }
    if (CPLib.eqr("likecitta",p_cVarName)) {
      return likecitta;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("ODBCDataSource",p_cVarName)) {
      return ODBCDataSource;
    }
    if (CPLib.eqr("pNomeAziendaSogernteDati",p_cVarName)) {
      return pNomeAziendaSogernteDati;
    }
    if (CPLib.eqr("sql_A",p_cVarName)) {
      return sql_A;
    }
    if (CPLib.eqr("sql_B",p_cVarName)) {
      return sql_B;
    }
    if (CPLib.eqr("sql_C",p_cVarName)) {
      return sql_C;
    }
    if (CPLib.eqr("sql_D",p_cVarName)) {
      return sql_D;
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
    if (CPLib.eqr("mcpersonbo",p_cVarName)) {
      return mcpersonbo;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("likeconnes",p_cVarName)) {
      likeconnes = value;
      return;
    }
    if (CPLib.eqr("likeragsoc",p_cVarName)) {
      likeragsoc = value;
      return;
    }
    if (CPLib.eqr("likecodfisc",p_cVarName)) {
      likecodfisc = value;
      return;
    }
    if (CPLib.eqr("likecitta",p_cVarName)) {
      likecitta = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("ODBCDataSource",p_cVarName)) {
      ODBCDataSource = value;
      return;
    }
    if (CPLib.eqr("pNomeAziendaSogernteDati",p_cVarName)) {
      pNomeAziendaSogernteDati = value;
      return;
    }
    if (CPLib.eqr("sql_A",p_cVarName)) {
      sql_A = value;
      return;
    }
    if (CPLib.eqr("sql_B",p_cVarName)) {
      sql_B = value;
      return;
    }
    if (CPLib.eqr("sql_C",p_cVarName)) {
      sql_C = value;
      return;
    }
    if (CPLib.eqr("sql_D",p_cVarName)) {
      sql_D = value;
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
    if (CPLib.eqr("mcpersonbo",p_cVarName)) {
      mcpersonbo = (MemoryCursor_personbo)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_cptsrvr=null;
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_personbo=null;
    try {
      /* likeconnes Char(0) */
      /* likeragsoc Char(0) */
      /* likecodfisc Char(0) */
      /* likecitta Char(0) */
      /* gAzienda Char(10) // Azienda Destinazione */
      /* ODBCDataSource Char(500) // ODBCDataSource letto su cptserver */
      // * --- Select from cptsrvr
      m_cServer = m_Ctx.GetServer("cptsrvr");
      m_cPhName = m_Ctx.GetPhName("cptsrvr");
      if (Cursor_cptsrvr!=null)
        Cursor_cptsrvr.Close();
      Cursor_cptsrvr = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"ServerName='SORGENTE' "+")"+(m_Ctx.IsSharedTemp("cptsrvr")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cptsrvr.Eof())) {
        /* ODBCDataSource := cptsrvr->ODBCDataSource */
        ODBCDataSource = Cursor_cptsrvr.GetString("ODBCDataSource");
        Cursor_cptsrvr.Next();
      }
      m_cConnectivityError = Cursor_cptsrvr.ErrorMessage();
      Cursor_cptsrvr.Close();
      // * --- End Select
      /* pNomeAziendaSogernteDati Char(0) // Il nome è sufficientemente parlante credo */
      /* mcpersonbo MemoryCursor(personbo) */
      /* sql_A Char(0) */
      /* sql_B Char(0) */
      /* sql_C Char(0) */
      /* sql_D Char(0) */
      /* Utilities.SetAlternativeServer('','personbo',ODBCDataSource) */
      Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("","personbo",ODBCDataSource);
      /* Utilities.SetAlternativeServer('','cpazi',ODBCDataSource) */
      Utilities.Make(m_Ctx,m_Caller).SetAlternativeServer("","cpazi",ODBCDataSource);
      // * --- Select from cpazi
      m_cServer = m_Ctx.GetServer("cpazi");
      m_cPhName = m_Ctx.GetPhName("cpazi");
      if (Cursor_cpazi!=null)
        Cursor_cpazi.Close();
      Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select codazi  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cpazi.Eof())) {
        /* pNomeAziendaSogernteDati := cpazi->codazi // Il nome è sufficientemente parlante credo */
        pNomeAziendaSogernteDati = Cursor_cpazi.GetString("codazi");
        Cursor_cpazi.Next();
      }
      m_cConnectivityError = Cursor_cpazi.ErrorMessage();
      Cursor_cpazi.Close();
      // * --- End Select
      /* Utilities.SetCompany(pNomeAziendaSogernteDati) */
      Utilities.Make(m_Ctx,m_Caller).SetCompany(pNomeAziendaSogernteDati);
      /* sql_A := '%'+likeconnes+'%' */
      sql_A = "%"+likeconnes+"%";
      /* sql_B := '%'+likeragsoc+'%' */
      sql_B = "%"+likeragsoc+"%";
      /* sql_C := '%'+likecodfisc+'%' */
      sql_C = "%"+likecodfisc+"%";
      /* sql_D := '%'+likecitta+'%' */
      sql_D = "%"+likecitta+"%";
      double nTry0000001Bstatus;
      nTry0000001Bstatus = m_Sql.GetTransactionStatus();
      String cTry0000001Bmsg;
      cTry0000001Bmsg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Fill memory cursor mcpersonbo on personbo
        mcpersonbo.Zap();
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES LIKE "+CPSql.SQLValueAdapter(CPLib.ToSQL(sql_A,"?",0,0,m_cServer, m_oParameters),m_cServer,sql_A)+"  and  RAGSOC LIKE "+CPSql.SQLValueAdapter(CPLib.ToSQL(sql_B,"?",0,0,m_cServer, m_oParameters),m_cServer,sql_B)+"  and  CODFISC like "+CPSql.SQLValueAdapter(CPLib.ToSQL(sql_C,"?",0,0,m_cServer, m_oParameters),m_cServer,sql_C)+"  and  DESCCIT like "+CPSql.SQLValueAdapter(CPLib.ToSQL(sql_D,"?",0,0,m_cServer, m_oParameters),m_cServer,sql_D)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_personbo;
          Cursor_personbo.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_mcpersonbo_altrodb: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_personbo.Eof())) {
          mcpersonbo.AppendBlank();
          mcpersonbo.row.CONNES = Cursor_personbo.GetString("CONNES");
          mcpersonbo.row.CODCAB = Cursor_personbo.GetString("CODCAB");
          mcpersonbo.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
          mcpersonbo.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
          mcpersonbo.row.CODFISC = Cursor_personbo.GetString("CODFISC");
          mcpersonbo.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
          mcpersonbo.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
          mcpersonbo.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
          mcpersonbo.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
          mcpersonbo.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
          mcpersonbo.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
          mcpersonbo.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
          mcpersonbo.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
          mcpersonbo.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
          mcpersonbo.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
          mcpersonbo.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
          mcpersonbo.row.PAESE = Cursor_personbo.GetString("PAESE");
          mcpersonbo.row.CAP = Cursor_personbo.GetString("CAP");
          mcpersonbo.row.CODINTER = Cursor_personbo.GetString("CODINTER");
          mcpersonbo.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
          mcpersonbo.row.TIPOPERS = Cursor_personbo.GetString("TIPOPERS");
          mcpersonbo.row.CODDIPE = Cursor_personbo.GetString("CODDIPE");
          mcpersonbo.row.PARTIVA = Cursor_personbo.GetString("PARTIVA");
          mcpersonbo.row.NOTE = Cursor_personbo.GetString("NOTE");
          mcpersonbo.row.SESSO = Cursor_personbo.GetString("SESSO");
          mcpersonbo.row.SOSPMAF = Cursor_personbo.GetString("SOSPMAF");
          mcpersonbo.row.idcitta = Cursor_personbo.GetString("idcitta");
          mcpersonbo.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
          mcpersonbo.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
          mcpersonbo.row.DOCFILE = Cursor_personbo.GetString("DOCFILE");
          mcpersonbo.row.NOME = Cursor_personbo.GetString("NOME");
          mcpersonbo.row.COGNOME = Cursor_personbo.GetString("COGNOME");
          mcpersonbo.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
          mcpersonbo.row.OLDCONNES = Cursor_personbo.GetString("OLDCONNES");
          mcpersonbo.row.DATEXTRA = Cursor_personbo.GetDate("DATEXTRA");
          mcpersonbo.row.PKTBSPECIE = Cursor_personbo.GetString("PKTBSPECIE");
          mcpersonbo.row.COMPORT = Cursor_personbo.GetString("COMPORT");
          mcpersonbo.row.ATTIV = Cursor_personbo.GetString("ATTIV");
          mcpersonbo.row.RNATGIU = Cursor_personbo.GetDouble("RNATGIU");
          mcpersonbo.row.RATTIV = Cursor_personbo.GetDouble("RATTIV");
          mcpersonbo.row.RCOMP = Cursor_personbo.GetDouble("RCOMP");
          mcpersonbo.row.RAREA = Cursor_personbo.GetDouble("RAREA");
          mcpersonbo.row.ALLINEATO = Cursor_personbo.GetDouble("ALLINEATO");
          mcpersonbo.row.ALLINEATONOMECNOME = Cursor_personbo.GetDouble("ALLINEATONOMECNOME");
          mcpersonbo.row.RAGSOCOLD = Cursor_personbo.GetString("RAGSOCOLD");
          mcpersonbo.row.PROGIMPORT = Cursor_personbo.GetDouble("PROGIMPORT");
          mcpersonbo.row.PROGIMP_C = Cursor_personbo.GetString("PROGIMP_C");
          mcpersonbo.row.AREAGEO = Cursor_personbo.GetString("AREAGEO");
          mcpersonbo.row.PEP = Cursor_personbo.GetString("PEP");
          mcpersonbo.row.IDFILE = Cursor_personbo.GetString("IDFILE");
          mcpersonbo.row.OLDCODFISC = Cursor_personbo.GetString("OLDCODFISC");
          mcpersonbo.row.MACROAGENTE = Cursor_personbo.GetString("MACROAGENTE");
          mcpersonbo.row.SPOTID = Cursor_personbo.GetString("SPOTID");
          mcpersonbo.row.DATASEGN = Cursor_personbo.GetDate("DATASEGN");
          mcpersonbo.row.OLDSETSIN = Cursor_personbo.GetString("OLDSETSIN");
          mcpersonbo.row.DATAVARAGE = Cursor_personbo.GetDate("DATAVARAGE");
          mcpersonbo.row.SETTSINT2 = Cursor_personbo.GetString("SETTSINT2");
          mcpersonbo.row.FATCA = Cursor_personbo.GetString("FATCA");
          mcpersonbo.row.BANCABEN = Cursor_personbo.GetString("BANCABEN");
          mcpersonbo.row.TIN = Cursor_personbo.GetString("TIN");
          mcpersonbo.row.ODB = Cursor_personbo.GetDouble("ODB");
          mcpersonbo.row.TELEF = Cursor_personbo.GetString("TELEF");
          mcpersonbo.row.TIPOORO = Cursor_personbo.GetString("TIPOORO");
          mcpersonbo.row.CODORO = Cursor_personbo.GetString("CODORO");
          mcpersonbo.row.IDNASCOMUN = Cursor_personbo.GetString("IDNASCOMUN");
          mcpersonbo.row.IDNASSTATO = Cursor_personbo.GetString("IDNASSTATO");
          mcpersonbo.row.NOTIT = Cursor_personbo.GetDouble("NOTIT");
          mcpersonbo.row.IDBASE = Cursor_personbo.GetString("IDBASE");
          mcpersonbo.row.FLGVALIDO = Cursor_personbo.GetString("FLGVALIDO");
          mcpersonbo.row.CITTADIN1 = Cursor_personbo.GetString("CITTADIN1");
          mcpersonbo.row.CITTADIN2 = Cursor_personbo.GetString("CITTADIN2");
          mcpersonbo.row.RESFISC = Cursor_personbo.GetString("RESFISC");
          mcpersonbo.row.MITIG = Cursor_personbo.GetDouble("MITIG");
          mcpersonbo.row.MITIGDOC = Cursor_personbo.GetString("MITIGDOC");
          mcpersonbo.row.NOSARA = Cursor_personbo.GetString("NOSARA");
          mcpersonbo.row.RISGLOB = Cursor_personbo.GetString("RISGLOB");
          mcpersonbo.row.DATAPROF = Cursor_personbo.GetDate("DATAPROF");
          mcpersonbo.row.DATAREVPROF = Cursor_personbo.GetDate("DATAREVPROF");
          mcpersonbo.row.IDENT = Cursor_personbo.GetString("IDENT");
          mcpersonbo.row.PEPDATE = Cursor_personbo.GetDate("PEPDATE");
          mcpersonbo.row.DAC6 = Cursor_personbo.GetString("DAC6");
          mcpersonbo.row.FLAGDAC6 = Cursor_personbo.GetDouble("FLAGDAC6");
          mcpersonbo.row.CRIME = Cursor_personbo.GetString("CRIME");
          mcpersonbo.row.CRIMEDATE = Cursor_personbo.GetDate("CRIMEDATE");
          mcpersonbo.row.ALTRODOM = Cursor_personbo.GetString("ALTRODOM");
          mcpersonbo.row.ALTROCAP = Cursor_personbo.GetString("ALTROCAP");
          mcpersonbo.row.CONTO = Cursor_personbo.GetString("CONTO");
          mcpersonbo.row.NUMIMP = Cursor_personbo.GetDateTime("NUMIMP");
          mcpersonbo.row.RAPSEGNA = Cursor_personbo.GetString("RAPSEGNA");
          mcpersonbo.row.CODLEGRAP = Cursor_personbo.GetString("CODLEGRAP");
          mcpersonbo.row.TIPOSOGGETTO = Cursor_personbo.GetString("TIPOSOGGETTO");
          mcpersonbo.row.CAUSALE = Cursor_personbo.GetDouble("CAUSALE");
          mcpersonbo.row.IMPORTOMAX = Cursor_personbo.GetDouble("IMPORTOMAX");
          mcpersonbo.row.FATTURATO = Cursor_personbo.GetDouble("FATTURATO");
          mcpersonbo.row.FREQUENZA = Cursor_personbo.GetString("FREQUENZA");
          mcpersonbo.row.NUMOPERAZ = Cursor_personbo.GetDouble("NUMOPERAZ");
          mcpersonbo.row.SOGAFFIDATARIO = Cursor_personbo.GetString("SOGAFFIDATARIO");
          mcpersonbo.row.FLGNOTRIM = Cursor_personbo.GetString("FLGNOTRIM");
          mcpersonbo.row.DISATTIVO = Cursor_personbo.GetDate("DISATTIVO");
          mcpersonbo.row.DATAFINE = Cursor_personbo.GetDate("DATAFINE");
          mcpersonbo.row.DATAINI = Cursor_personbo.GetDate("DATAINI");
          mcpersonbo.row.DATAIDENT = Cursor_personbo.GetDate("DATAIDENT");
          mcpersonbo.row.DATASIGN = Cursor_personbo.GetDate("DATASIGN");
          mcpersonbo.row.DATARAUT = Cursor_personbo.GetDate("DATARAUT");
          mcpersonbo.row.VERIFICA = Cursor_personbo.GetString("VERIFICA");
          mcpersonbo.row.NOTERIS = Cursor_personbo.GetString("NOTERIS");
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        mcpersonbo.GoTop();
        /* Utilities.ResetAlternativeServer('','personbo') */
        Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","personbo");
        /* Utilities.ResetAlternativeServer('','cpazi') */
        Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","cpazi");
        /* Utilities.SetCompany(gAzienda) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(gAzienda);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* Utilities.ResetAlternativeServer('','personbo') */
        Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","personbo");
        /* Utilities.ResetAlternativeServer('','cpazi') */
        Utilities.Make(m_Ctx,m_Caller).ResetAlternativeServer("","cpazi");
        /* Utilities.SetCompany(gAzienda) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(gAzienda);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000001Bstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000001Bstatus,cTry0000001Bmsg);
        }
      }
      /* Return mcpersonbo */
      throw new Stop(mcpersonbo);
    } finally {
      try {
        if (Cursor_cptsrvr!=null)
          Cursor_cptsrvr.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
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
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_likeconnes,String p_likeragsoc,String p_likecodfisc,String p_likecitta) {
    likeconnes = p_likeconnes;
    likeragsoc = p_likeragsoc;
    likecodfisc = p_likecodfisc;
    likecitta = p_likecitta;
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
  public MemoryCursor_personbo Run(String p_likeconnes,String p_likeragsoc,String p_likecodfisc,String p_likecitta) {
    likeconnes = p_likeconnes;
    likeragsoc = p_likeragsoc;
    likecodfisc = p_likecodfisc;
    likecitta = p_likecitta;
    return Run();
  }
  public MemoryCursor_personbo Run() {
    MemoryCursor_personbo l_result;
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
        l_result = (MemoryCursor_personbo)stop_value.GetObject();
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
  public static arfn_mcpersonbo_altrodbR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_mcpersonbo_altrodbR(p_Ctx, p_Caller);
  }
  public static arfn_mcpersonbo_altrodbR Make(CPContext p_Ctx) {
    return new arfn_mcpersonbo_altrodbR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    likeconnes = CPLib.Space(0);
    likeragsoc = CPLib.Space(0);
    likecodfisc = CPLib.Space(0);
    likecitta = CPLib.Space(0);
    ODBCDataSource = CPLib.Space(500);
    pNomeAziendaSogernteDati = CPLib.Space(0);
    mcpersonbo = new MemoryCursor_personbo();
    sql_A = CPLib.Space(0);
    sql_B = CPLib.Space(0);
    sql_C = CPLib.Space(0);
    sql_D = CPLib.Space(0);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_mcpersonbo_altrodb,
  public static final String i_InvokedRoutines = ",arfn_mcpersonbo_altrodb,";
  public static String[] m_cRunParameterNames={"likeconnes","likeragsoc","likecodfisc","likecitta"};
}
