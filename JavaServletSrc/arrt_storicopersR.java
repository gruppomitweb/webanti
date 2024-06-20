// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_storicopersR implements CallerWithObjs {
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
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_wersonbo_agg;
  public String m_cServer_wersonbo_agg;
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
  public armt_personboBL pObj;
  public String cProgSto;
  public java.sql.Date _data;
  public String _oldcon;
  public MemoryCursorRow_personbo rowOld;
  public MemoryCursorRow_personbo rowNew;
  public MemoryCursor_personbo mcPersonbo;
  public boolean _modificato;
  public String gAzienda;
  public java.sql.Date gDataVaria;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_storicopersR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_storicopers",m_Caller);
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
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_wersonbo_agg = p_ContextObject.GetPhName("wersonbo_agg");
    if (m_cPhName_wersonbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo_agg = m_cPhName_wersonbo_agg+" "+m_Ctx.GetWritePhName("wersonbo_agg");
    }
    m_cServer_wersonbo_agg = p_ContextObject.GetServer("wersonbo_agg");
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
      return "arrt_storicopers";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      return cProgSto;
    }
    if (CPLib.eqr("_oldcon",p_cVarName)) {
      return _oldcon;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_data",p_cVarName)) {
      return _data;
    }
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      return gDataVaria;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_modificato",p_cVarName)) {
      return _modificato;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcPersonbo",p_cVarName)) {
      return mcPersonbo;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowOld",p_cVarName)) {
      return rowOld;
    }
    if (CPLib.eqr("rowNew",p_cVarName)) {
      return rowNew;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      cProgSto = value;
      return;
    }
    if (CPLib.eqr("_oldcon",p_cVarName)) {
      _oldcon = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_data",p_cVarName)) {
      _data = value;
      return;
    }
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      gDataVaria = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("_modificato",p_cVarName)) {
      _modificato = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowOld",p_cVarName)) {
      rowOld = (MemoryCursorRow_personbo)value;
      return;
    }
    if (CPLib.eqr("rowNew",p_cVarName)) {
      rowNew = (MemoryCursorRow_personbo)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcPersonbo",p_cVarName)) {
      mcPersonbo = (MemoryCursor_personbo)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo_agg=null;
    try {
      /* pObj Object(armt_personboBL) */
      /* cProgSto Char(15) */
      /* _data Date */
      /* _oldcon Char(16) */
      /* rowOld Row(personbo) */
      /* rowNew Row(personbo) */
      /* mcPersonbo MemoryCursor(personbo) */
      /* _modificato Bool */
      /* gAzienda Char(10) // Azienda */
      /* gDataVaria Date // Data Variazione */
      // * --- Fill memory cursor mcPersonbo on personbo
      mcPersonbo.Zap();
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      if (Cursor_personbo!=null)
        Cursor_personbo.Close();
      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_personbo;
        Cursor_personbo.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_storicopers: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_personbo.Eof())) {
        mcPersonbo.AppendBlank();
        mcPersonbo.row.CONNES = Cursor_personbo.GetString("CONNES");
        mcPersonbo.row.CODCAB = Cursor_personbo.GetString("CODCAB");
        mcPersonbo.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
        mcPersonbo.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
        mcPersonbo.row.CODFISC = Cursor_personbo.GetString("CODFISC");
        mcPersonbo.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
        mcPersonbo.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
        mcPersonbo.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
        mcPersonbo.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
        mcPersonbo.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
        mcPersonbo.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
        mcPersonbo.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
        mcPersonbo.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
        mcPersonbo.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
        mcPersonbo.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
        mcPersonbo.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
        mcPersonbo.row.PAESE = Cursor_personbo.GetString("PAESE");
        mcPersonbo.row.CAP = Cursor_personbo.GetString("CAP");
        mcPersonbo.row.CODINTER = Cursor_personbo.GetString("CODINTER");
        mcPersonbo.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
        mcPersonbo.row.TIPOPERS = Cursor_personbo.GetString("TIPOPERS");
        mcPersonbo.row.CODDIPE = Cursor_personbo.GetString("CODDIPE");
        mcPersonbo.row.PARTIVA = Cursor_personbo.GetString("PARTIVA");
        mcPersonbo.row.NOTE = Cursor_personbo.GetString("NOTE");
        mcPersonbo.row.SESSO = Cursor_personbo.GetString("SESSO");
        mcPersonbo.row.SOSPMAF = Cursor_personbo.GetString("SOSPMAF");
        mcPersonbo.row.idcitta = Cursor_personbo.GetString("idcitta");
        mcPersonbo.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
        mcPersonbo.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
        mcPersonbo.row.DOCFILE = Cursor_personbo.GetString("DOCFILE");
        mcPersonbo.row.NOME = Cursor_personbo.GetString("NOME");
        mcPersonbo.row.COGNOME = Cursor_personbo.GetString("COGNOME");
        mcPersonbo.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
        mcPersonbo.row.OLDCONNES = Cursor_personbo.GetString("OLDCONNES");
        mcPersonbo.row.DATEXTRA = Cursor_personbo.GetDate("DATEXTRA");
        mcPersonbo.row.PKTBSPECIE = Cursor_personbo.GetString("PKTBSPECIE");
        mcPersonbo.row.COMPORT = Cursor_personbo.GetString("COMPORT");
        mcPersonbo.row.ATTIV = Cursor_personbo.GetString("ATTIV");
        mcPersonbo.row.RNATGIU = Cursor_personbo.GetDouble("RNATGIU");
        mcPersonbo.row.RATTIV = Cursor_personbo.GetDouble("RATTIV");
        mcPersonbo.row.RCOMP = Cursor_personbo.GetDouble("RCOMP");
        mcPersonbo.row.RAREA = Cursor_personbo.GetDouble("RAREA");
        mcPersonbo.row.ALLINEATO = Cursor_personbo.GetDouble("ALLINEATO");
        mcPersonbo.row.ALLINEATONOMECNOME = Cursor_personbo.GetDouble("ALLINEATONOMECNOME");
        mcPersonbo.row.RAGSOCOLD = Cursor_personbo.GetString("RAGSOCOLD");
        mcPersonbo.row.PROGIMPORT = Cursor_personbo.GetDouble("PROGIMPORT");
        mcPersonbo.row.PROGIMP_C = Cursor_personbo.GetString("PROGIMP_C");
        mcPersonbo.row.AREAGEO = Cursor_personbo.GetString("AREAGEO");
        mcPersonbo.row.PEP = Cursor_personbo.GetString("PEP");
        mcPersonbo.row.IDFILE = Cursor_personbo.GetString("IDFILE");
        mcPersonbo.row.OLDCODFISC = Cursor_personbo.GetString("OLDCODFISC");
        mcPersonbo.row.MACROAGENTE = Cursor_personbo.GetString("MACROAGENTE");
        mcPersonbo.row.SPOTID = Cursor_personbo.GetString("SPOTID");
        mcPersonbo.row.DATASEGN = Cursor_personbo.GetDate("DATASEGN");
        mcPersonbo.row.OLDSETSIN = Cursor_personbo.GetString("OLDSETSIN");
        mcPersonbo.row.DATAVARAGE = Cursor_personbo.GetDate("DATAVARAGE");
        mcPersonbo.row.SETTSINT2 = Cursor_personbo.GetString("SETTSINT2");
        mcPersonbo.row.FATCA = Cursor_personbo.GetString("FATCA");
        mcPersonbo.row.BANCABEN = Cursor_personbo.GetString("BANCABEN");
        mcPersonbo.row.TIN = Cursor_personbo.GetString("TIN");
        mcPersonbo.row.ODB = Cursor_personbo.GetDouble("ODB");
        mcPersonbo.row.TELEF = Cursor_personbo.GetString("TELEF");
        mcPersonbo.row.TIPOORO = Cursor_personbo.GetString("TIPOORO");
        mcPersonbo.row.CODORO = Cursor_personbo.GetString("CODORO");
        mcPersonbo.row.IDNASCOMUN = Cursor_personbo.GetString("IDNASCOMUN");
        mcPersonbo.row.IDNASSTATO = Cursor_personbo.GetString("IDNASSTATO");
        mcPersonbo.row.NOTIT = Cursor_personbo.GetDouble("NOTIT");
        mcPersonbo.row.IDBASE = Cursor_personbo.GetString("IDBASE");
        mcPersonbo.row.FLGVALIDO = Cursor_personbo.GetString("FLGVALIDO");
        mcPersonbo.row.CITTADIN1 = Cursor_personbo.GetString("CITTADIN1");
        mcPersonbo.row.CITTADIN2 = Cursor_personbo.GetString("CITTADIN2");
        mcPersonbo.row.RESFISC = Cursor_personbo.GetString("RESFISC");
        mcPersonbo.row.MITIG = Cursor_personbo.GetDouble("MITIG");
        mcPersonbo.row.MITIGDOC = Cursor_personbo.GetString("MITIGDOC");
        mcPersonbo.row.NOSARA = Cursor_personbo.GetString("NOSARA");
        mcPersonbo.row.RISGLOB = Cursor_personbo.GetString("RISGLOB");
        mcPersonbo.row.DATAPROF = Cursor_personbo.GetDate("DATAPROF");
        mcPersonbo.row.DATAREVPROF = Cursor_personbo.GetDate("DATAREVPROF");
        mcPersonbo.row.IDENT = Cursor_personbo.GetString("IDENT");
        mcPersonbo.row.PEPDATE = Cursor_personbo.GetDate("PEPDATE");
        mcPersonbo.row.DAC6 = Cursor_personbo.GetString("DAC6");
        mcPersonbo.row.FLAGDAC6 = Cursor_personbo.GetDouble("FLAGDAC6");
        mcPersonbo.row.CRIME = Cursor_personbo.GetString("CRIME");
        mcPersonbo.row.CRIMEDATE = Cursor_personbo.GetDate("CRIMEDATE");
        mcPersonbo.row.ALTRODOM = Cursor_personbo.GetString("ALTRODOM");
        mcPersonbo.row.ALTROCAP = Cursor_personbo.GetString("ALTROCAP");
        mcPersonbo.row.CONTO = Cursor_personbo.GetString("CONTO");
        mcPersonbo.row.NUMIMP = Cursor_personbo.GetDateTime("NUMIMP");
        mcPersonbo.row.RAPSEGNA = Cursor_personbo.GetString("RAPSEGNA");
        mcPersonbo.row.CODLEGRAP = Cursor_personbo.GetString("CODLEGRAP");
        mcPersonbo.row.TIPOSOGGETTO = Cursor_personbo.GetString("TIPOSOGGETTO");
        mcPersonbo.row.CAUSALE = Cursor_personbo.GetDouble("CAUSALE");
        mcPersonbo.row.IMPORTOMAX = Cursor_personbo.GetDouble("IMPORTOMAX");
        mcPersonbo.row.FATTURATO = Cursor_personbo.GetDouble("FATTURATO");
        mcPersonbo.row.FREQUENZA = Cursor_personbo.GetString("FREQUENZA");
        mcPersonbo.row.NUMOPERAZ = Cursor_personbo.GetDouble("NUMOPERAZ");
        mcPersonbo.row.SOGAFFIDATARIO = Cursor_personbo.GetString("SOGAFFIDATARIO");
        mcPersonbo.row.FLGNOTRIM = Cursor_personbo.GetString("FLGNOTRIM");
        mcPersonbo.row.DISATTIVO = Cursor_personbo.GetDate("DISATTIVO");
        mcPersonbo.row.DATAFINE = Cursor_personbo.GetDate("DATAFINE");
        mcPersonbo.row.DATAINI = Cursor_personbo.GetDate("DATAINI");
        mcPersonbo.row.DATAIDENT = Cursor_personbo.GetDate("DATAIDENT");
        mcPersonbo.row.DATASIGN = Cursor_personbo.GetDate("DATASIGN");
        mcPersonbo.row.DATARAUT = Cursor_personbo.GetDate("DATARAUT");
        mcPersonbo.row.VERIFICA = Cursor_personbo.GetString("VERIFICA");
        mcPersonbo.row.NOTERIS = Cursor_personbo.GetString("NOTERIS");
        Cursor_personbo.Next();
      }
      m_cConnectivityError = Cursor_personbo.ErrorMessage();
      Cursor_personbo.Close();
      mcPersonbo.GoTop();
      for (MemoryCursorRow_personbo rwPers : mcPersonbo._iterable_()) {
        /* rowOld.Copy(rwPers) */
        rowOld.Copy(rwPers);
      }
      /* rowNew.CONNES := pObj.w_CONNES */
      rowNew.CONNES = pObj.w_CONNES;
      /* rowNew.CODCAB := pObj.w_CODCAB */
      rowNew.CODCAB = pObj.w_CODCAB;
      /* rowNew.RAGSOC := pObj.w_RAGSOC */
      rowNew.RAGSOC = pObj.w_RAGSOC;
      /* rowNew.DOMICILIO := pObj.w_DOMICILIO */
      rowNew.DOMICILIO = pObj.w_DOMICILIO;
      /* rowNew.CODFISC := pObj.w_CODFISC */
      rowNew.CODFISC = pObj.w_CODFISC;
      /* rowNew.DATANASC := pObj.w_DATANASC */
      rowNew.DATANASC = pObj.w_DATANASC;
      /* rowNew.NASCOMUN := pObj.w_NASCOMUN */
      rowNew.NASCOMUN = pObj.w_NASCOMUN;
      /* rowNew.SOTGRUP := pObj.w_SOTGRUP */
      rowNew.SOTGRUP = pObj.w_SOTGRUP;
      /* rowNew.RAMOGRUP := pObj.w_RAMOGRUP */
      rowNew.RAMOGRUP = pObj.w_RAMOGRUP;
      /* rowNew.SETTSINT := pObj.w_SETTSINT */
      rowNew.SETTSINT = pObj.w_SETTSINT;
      /* rowNew.TIPODOC := pObj.w_TIPODOC */
      rowNew.TIPODOC = pObj.w_TIPODOC;
      /* rowNew.NUMDOCUM := pObj.w_NUMDOCUM */
      rowNew.NUMDOCUM = pObj.w_NUMDOCUM;
      /* rowNew.DATARILASC := pObj.w_DATARILASC */
      rowNew.DATARILASC = pObj.w_DATARILASC;
      /* rowNew.AUTRILASC := pObj.w_AUTRILASC */
      rowNew.AUTRILASC = pObj.w_AUTRILASC;
      /* rowNew.DESCCIT := pObj.w_DESCCIT */
      rowNew.DESCCIT = pObj.w_DESCCIT;
      /* rowNew.PROVINCIA := pObj.w_PROVINCIA */
      rowNew.PROVINCIA = pObj.w_PROVINCIA;
      /* rowNew.PAESE := pObj.w_PAESE */
      rowNew.PAESE = pObj.w_PAESE;
      /* rowNew.CAP := pObj.w_CAP */
      rowNew.CAP = pObj.w_CAP;
      /* rowNew.CODINTER := pObj.w_CODINTER */
      rowNew.CODINTER = pObj.w_CODINTER;
      /* rowNew.TIPINTER := pObj.w_TIPINTER */
      rowNew.TIPINTER = pObj.w_TIPINTER;
      /* rowNew.TIPOPERS := pObj.w_TIPOPERS */
      rowNew.TIPOPERS = pObj.w_TIPOPERS;
      /* rowNew.CODDIPE := pObj.w_CODDIPE */
      rowNew.CODDIPE = pObj.w_CODDIPE;
      /* rowNew.PARTIVA := pObj.w_PARTIVA */
      rowNew.PARTIVA = pObj.w_PARTIVA;
      /* rowNew.NOTE := pObj.w_NOTE */
      rowNew.NOTE = pObj.w_NOTE;
      /* rowNew.SESSO := pObj.w_SESSO */
      rowNew.SESSO = pObj.w_SESSO;
      /* rowNew.SOSPMAF := pObj.w_SOSPMAF */
      rowNew.SOSPMAF = pObj.w_SOSPMAF;
      /* rowNew.idcitta := pObj.w_idcitta */
      rowNew.idcitta = pObj.w_idcitta;
      /* rowNew.DATAVALI := pObj.w_DATAVALI */
      rowNew.DATAVALI = pObj.w_DATAVALI;
      /* rowNew.NASSTATO := pObj.w_NASSTATO */
      rowNew.NASSTATO = pObj.w_NASSTATO;
      /* rowNew.DOCFILE := pObj.w_DOCFILE */
      rowNew.DOCFILE = pObj.w_DOCFILE;
      /* rowNew.NOME := pObj.w_NOME */
      rowNew.NOME = pObj.w_NOME;
      /* rowNew.COGNOME := pObj.w_COGNOME */
      rowNew.COGNOME = pObj.w_COGNOME;
      /* rowNew.CFESTERO := pObj.w_CFESTERO */
      rowNew.CFESTERO = pObj.w_CFESTERO;
      /* rowNew.OLDCONNES := pObj.w_OLDCONNES */
      rowNew.OLDCONNES = pObj.w_OLDCONNES;
      /* rowNew.DATEXTRA := pObj.w_DATEXTRA */
      rowNew.DATEXTRA = pObj.w_DATEXTRA;
      /* rowNew.PKTBSPECIE := pObj.w_PKTBSPECIE */
      rowNew.PKTBSPECIE = pObj.w_PKTBSPECIE;
      /* rowNew.COMPORT := pObj.w_COMPORT */
      rowNew.COMPORT = pObj.w_COMPORT;
      /* rowNew.ATTIV := pObj.w_ATTIV */
      rowNew.ATTIV = pObj.w_ATTIV;
      /* rowNew.RNATGIU := pObj.w_RNATGIU */
      rowNew.RNATGIU = pObj.w_RNATGIU;
      /* rowNew.RATTIV := pObj.w_RATTIV */
      rowNew.RATTIV = pObj.w_RATTIV;
      /* rowNew.RCOMP := pObj.w_RCOMP */
      rowNew.RCOMP = pObj.w_RCOMP;
      /* rowNew.RAREA := pObj.w_RAREA */
      rowNew.RAREA = pObj.w_RAREA;
      /* rowNew.ALLINEATO := pObj.w_ALLINEATO */
      rowNew.ALLINEATO = pObj.w_ALLINEATO;
      /* rowNew.ALLINEATONOMECNOME := pObj.w_ALLINEATONOMECNOME */
      rowNew.ALLINEATONOMECNOME = pObj.w_ALLINEATONOMECNOME;
      /* rowNew.RAGSOCOLD := pObj.w_RAGSOCOLD */
      rowNew.RAGSOCOLD = pObj.w_RAGSOCOLD;
      /* rowNew.PROGIMPORT := pObj.w_PROGIMPORT */
      rowNew.PROGIMPORT = pObj.w_PROGIMPORT;
      /* rowNew.PROGIMP_C := pObj.w_PROGIMP_C */
      rowNew.PROGIMP_C = pObj.w_PROGIMP_C;
      /* rowNew.AREAGEO := pObj.w_AREAGEO */
      rowNew.AREAGEO = pObj.w_AREAGEO;
      /* rowNew.PEP := pObj.w_PEP */
      rowNew.PEP = pObj.w_PEP;
      /* rowNew.IDFILE := pObj.w_IDFILE */
      rowNew.IDFILE = pObj.w_IDFILE;
      /* rowNew.OLDCODFISC := pObj.w_OLDCODFISC */
      rowNew.OLDCODFISC = pObj.w_OLDCODFISC;
      /* rowNew.MACROAGENTE := pObj.w_MACROAGENTE */
      rowNew.MACROAGENTE = pObj.w_MACROAGENTE;
      /* rowNew.SPOTID := pObj.w_SPOTID */
      rowNew.SPOTID = pObj.w_SPOTID;
      /* rowNew.DATASEGN := pObj.w_DATASEGN */
      rowNew.DATASEGN = pObj.w_DATASEGN;
      /* rowNew.OLDSETSIN := pObj.w_OLDSETSIN */
      rowNew.OLDSETSIN = pObj.w_OLDSETSIN;
      /* rowNew.DATAVARAGE := pObj.w_DATAVARAGE */
      rowNew.DATAVARAGE = pObj.w_DATAVARAGE;
      /* rowNew.SETTSINT2 := pObj.w_SETTSINT2 */
      rowNew.SETTSINT2 = pObj.w_SETTSINT2;
      /* rowNew.FATCA := pObj.w_FATCA */
      rowNew.FATCA = pObj.w_FATCA;
      /* rowNew.BANCABEN := pObj.w_BANCABEN */
      rowNew.BANCABEN = pObj.w_BANCABEN;
      /* rowNew.TIN := pObj.w_TIN */
      rowNew.TIN = pObj.w_TIN;
      /* rowNew.ODB := pObj.w_ODB */
      rowNew.ODB = pObj.w_ODB;
      /* rowNew.TELEF := pObj.w_TELEF */
      rowNew.TELEF = pObj.w_TELEF;
      /* rowNew.TIPOORO := pObj.w_TIPOORO */
      rowNew.TIPOORO = pObj.w_TIPOORO;
      /* rowNew.CODORO := pObj.w_CODORO */
      rowNew.CODORO = pObj.w_CODORO;
      /* rowNew.IDNASCOMUN := pObj.w_IDNASCOMUN */
      rowNew.IDNASCOMUN = pObj.w_IDNASCOMUN;
      /* rowNew.IDNASSTATO := pObj.w_IDNASSTATO */
      rowNew.IDNASSTATO = pObj.w_IDNASSTATO;
      /* rowNew.NOTIT := pObj.w_NOTIT */
      rowNew.NOTIT = pObj.w_NOTIT;
      /* rowNew.IDBASE := pObj.w_IDBASE */
      rowNew.IDBASE = pObj.w_IDBASE;
      /* rowNew.FLGVALIDO := pObj.w_FLGVALIDO */
      rowNew.FLGVALIDO = pObj.w_FLGVALIDO;
      /* rowNew.CITTADIN1 := pObj.w_CITTADIN1 */
      rowNew.CITTADIN1 = pObj.w_CITTADIN1;
      /* rowNew.CITTADIN2 := pObj.w_CITTADIN2 */
      rowNew.CITTADIN2 = pObj.w_CITTADIN2;
      /* rowNew.RESFISC := pObj.w_RESFISC */
      rowNew.RESFISC = pObj.w_RESFISC;
      /* rowNew.MITIG := pObj.w_MITIG */
      rowNew.MITIG = pObj.w_MITIG;
      /* rowNew.MITIGDOC := pObj.w_MITIGDOC */
      rowNew.MITIGDOC = pObj.w_MITIGDOC;
      /* rowNew.NOSARA := pObj.w_NOSARA */
      rowNew.NOSARA = pObj.w_NOSARA;
      /* rowNew.RISGLOB := pObj.w_RISGLOB */
      rowNew.RISGLOB = pObj.w_RISGLOB;
      /* rowNew.DATAPROF := pObj.w_DATAPROF */
      rowNew.DATAPROF = pObj.w_DATAPROF;
      /* rowNew.DATAREVPROF := pObj.w_DATAREVPROF */
      rowNew.DATAREVPROF = pObj.w_DATAREVPROF;
      /* rowNew.IDENT := pObj.w_IDENT */
      rowNew.IDENT = pObj.w_IDENT;
      /* rowNew.PEPDATE := pObj.w_PEPDATE */
      rowNew.PEPDATE = pObj.w_PEPDATE;
      /* rowNew.DAC6 := pObj.w_DAC6 */
      rowNew.DAC6 = pObj.w_DAC6;
      /* rowNew.FLAGDAC6 := pObj.w_FLAGDAC6 */
      rowNew.FLAGDAC6 = pObj.w_FLAGDAC6;
      /* rowNew.CRIME := pObj.w_CRIME */
      rowNew.CRIME = pObj.w_CRIME;
      /* rowNew.CRIMEDATE := pObj.w_CRIMEDATE */
      rowNew.CRIMEDATE = pObj.w_CRIMEDATE;
      /* rowNew.ALTRODOM := pObj.w_ALTRODOM */
      rowNew.ALTRODOM = pObj.w_ALTRODOM;
      /* rowNew.ALTROCAP := pObj.w_ALTROCAP */
      rowNew.ALTROCAP = pObj.w_ALTROCAP;
      /* rowNew.CONTO := pObj.w_CONTO */
      rowNew.CONTO = pObj.w_CONTO;
      /* rowNew.NUMIMP := pObj.w_NUMIMP */
      rowNew.NUMIMP = pObj.w_NUMIMP;
      /* rowNew.RAPSEGNA := pObj.w_RAPSEGNA */
      rowNew.RAPSEGNA = pObj.w_RAPSEGNA;
      /* rowNew.CODLEGRAP := pObj.w_CODLEGRAP */
      rowNew.CODLEGRAP = pObj.w_CODLEGRAP;
      /* rowNew.TIPOSOGGETTO := pObj.w_TIPOSOGGETTO */
      rowNew.TIPOSOGGETTO = pObj.w_TIPOSOGGETTO;
      /* rowNew.CAUSALE := pObj.w_CAUSALE */
      rowNew.CAUSALE = pObj.w_CAUSALE;
      /* rowNew.IMPORTOMAX := pObj.w_IMPORTOMAX */
      rowNew.IMPORTOMAX = pObj.w_IMPORTOMAX;
      /* rowNew.FATTURATO := pObj.w_FATTURATO */
      rowNew.FATTURATO = pObj.w_FATTURATO;
      /* rowNew.FREQUENZA := pObj.w_FREQUENZA */
      rowNew.FREQUENZA = pObj.w_FREQUENZA;
      /* rowNew.NUMOPERAZ := pObj.w_NUMOPERAZ */
      rowNew.NUMOPERAZ = pObj.w_NUMOPERAZ;
      /* rowNew.SOGAFFIDATARIO := pObj.w_SOGAFFIDATARIO */
      rowNew.SOGAFFIDATARIO = pObj.w_SOGAFFIDATARIO;
      /* rowNew.FLGNOTRIM := pObj.w_FLGNOTRIM */
      rowNew.FLGNOTRIM = pObj.w_FLGNOTRIM;
      /* rowNew.DISATTIVO := pObj.w_DISATTIVO */
      rowNew.DISATTIVO = pObj.w_DISATTIVO;
      /* rowNew.DATAFINE := pObj.w_DATAFINE */
      rowNew.DATAFINE = pObj.w_DATAFINE;
      /* rowNew.DATAINI := pObj.w_DATAINI */
      rowNew.DATAINI = pObj.w_DATAINI;
      /* rowNew.DATAIDENT := pObj.w_DATAIDENT */
      rowNew.DATAIDENT = pObj.w_DATAIDENT;
      /* rowNew.DATASIGN := pObj.w_DATASIGN */
      rowNew.DATASIGN = pObj.w_DATASIGN;
      /* rowNew.DATARAUT := pObj.w_DATARAUT */
      rowNew.DATARAUT = pObj.w_DATARAUT;
      /* rowNew.VERIFICA := pObj.w_VERIFICA */
      rowNew.VERIFICA = pObj.w_VERIFICA;
      /* rowNew.NOTERIS := pObj.w_NOTERIS */
      rowNew.NOTERIS = pObj.w_NOTERIS;
      /* _modificato := false */
      _modificato = false;
      /* Exec "Confronta i valori" Page 2:Confronto */
      Confronto();
      /* If _modificato */
      if (_modificato) {
        /* _data := Date() */
        _data = CPLib.Date();
        /* cProgSto := '' */
        cProgSto = "";
        // * --- Select from wersonbo
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select sanumpro  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_CONNES)+"  and  datamodi="+CPSql.SQLValueAdapter(CPLib.ToSQL(_data,"?",0,0,m_cServer, m_oParameters),m_cServer,_data)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_wersonbo.Eof())) {
          /* cProgSto := wersonbo->sanumpro */
          cProgSto = Cursor_wersonbo.GetString("sanumpro");
          Cursor_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
        Cursor_wersonbo.Close();
        // * --- End Select
        /* If Empty(LRTrim(cProgSto)) */
        if (CPLib.Empty(CPLib.LRTrim(cProgSto))) {
          /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
          cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            // * --- Insert into wersonbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_storicopers",97,"00000089")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000089(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(pObj.w_CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATEXTRA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATONOMECNOME"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOCOLD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("PROGIMPORT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROGIMP_C"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVARAGE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("FATCA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("BANCABEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ODB"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TELEF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOORO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODORO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDNASCOMUN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDNASSTATO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("NOTIT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("FLGVALIDO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CITTADIN1"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CITTADIN2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RESFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("MITIG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MITIGDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOSARA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAPROF"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAREVPROF"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDENT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("PEPDATE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CRIME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("CRIMEDATE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ALTRODOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ALTROCAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAPSEGNA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODLEGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOSOGGETTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CAUSALE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("IMPORTOMAX"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("FATTURATO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("FREQUENZA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("NUMOPERAZ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOGAFFIDATARIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("FLGNOTRIM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DISATTIVO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAFINE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAINI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAIDENT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATASIGN"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARAUT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("VERIFICA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTERIS"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wersonbo",true);
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
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
          /* _oldcon := '' */
          _oldcon = "";
          // * --- Read from personbo_agg
          m_cServer = m_Ctx.GetServer("personbo_agg");
          m_cPhName = m_Ctx.GetPhName("personbo_agg");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_CONNES,"C",16,0,m_cServer),m_cServer,pObj.w_CONNES);
          if (m_Ctx.IsSharedTemp("personbo_agg")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _oldcon = Read_Cursor.GetString("CONNES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo_agg into routine arrt_storicopers returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _oldcon = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(_oldcon) */
          if (CPLib.Empty(_oldcon)) {
            // * --- Insert into wersonbo_agg from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wersonbo_agg");
            m_cPhName = m_Ctx.GetPhName("wersonbo_agg");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo_agg",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_storicopers",97,"0000008D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000008D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(pObj.w_CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wersonbo_agg",true);
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
          } else { // Else
            // * --- Select from personbo_agg
            m_cServer = m_Ctx.GetServer("personbo_agg");
            m_cPhName = m_Ctx.GetPhName("personbo_agg");
            if (Cursor_personbo_agg!=null)
              Cursor_personbo_agg.Close();
            Cursor_personbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pObj.w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,pObj.w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("personbo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo_agg.Eof())) {
              // * --- Insert into wersonbo_agg from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wersonbo_agg");
              m_cPhName = m_Ctx.GetPhName("wersonbo_agg");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo_agg",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_storicopers",97,"0000008F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000008F(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
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
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("NUMCEL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("PEC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("REFERENTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wersonbo_agg",true);
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
              Cursor_personbo_agg.Next();
            }
            m_cConnectivityError = Cursor_personbo_agg.ErrorMessage();
            Cursor_personbo_agg.Close();
            // * --- End Select
          } // End If
        } // End If
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
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
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
  void Confronto() throws Exception {
    /* _modificato := _modificato or (LRTrim(rowOld.CODCAB)<>LRTrim(rowNew.CODCAB)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.CODCAB),CPLib.LRTrim(rowNew.CODCAB)));
    /* _modificato := _modificato or (LRTrim(rowOld.RAGSOC)<>LRTrim(rowNew.RAGSOC)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.RAGSOC),CPLib.LRTrim(rowNew.RAGSOC)));
    /* _modificato := _modificato or (LRTrim(rowOld.DOMICILIO)<>LRTrim(rowNew.DOMICILIO)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.DOMICILIO),CPLib.LRTrim(rowNew.DOMICILIO)));
    /* _modificato := _modificato or (LRTrim(rowOld.CODFISC)<>LRTrim(rowNew.CODFISC)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.CODFISC),CPLib.LRTrim(rowNew.CODFISC)));
    /* _modificato := _modificato or (rowOld.DATANASC<>rowNew.DATANASC) */
    _modificato = _modificato || (CPLib.ne(rowOld.DATANASC,rowNew.DATANASC));
    /* _modificato := _modificato or (LRTrim(rowOld.NASCOMUN)<>LRTrim(rowNew.NASCOMUN)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.NASCOMUN),CPLib.LRTrim(rowNew.NASCOMUN)));
    /* _modificato := _modificato or (LRTrim(rowOld.SOTGRUP)<>LRTrim(rowNew.SOTGRUP)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.SOTGRUP),CPLib.LRTrim(rowNew.SOTGRUP)));
    /* _modificato := _modificato or (LRTrim(rowOld.RAMOGRUP)<>LRTrim(rowNew.RAMOGRUP)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.RAMOGRUP),CPLib.LRTrim(rowNew.RAMOGRUP)));
    /* _modificato := _modificato or (LRTrim(rowOld.SETTSINT)<>LRTrim(rowNew.SETTSINT)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.SETTSINT),CPLib.LRTrim(rowNew.SETTSINT)));
    /* _modificato := _modificato or (LRTrim(rowOld.TIPODOC)<>LRTrim(rowNew.TIPODOC)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.TIPODOC),CPLib.LRTrim(rowNew.TIPODOC)));
    /* _modificato := _modificato or (LRTrim(rowOld.NUMDOCUM)<>LRTrim(rowNew.NUMDOCUM)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.NUMDOCUM),CPLib.LRTrim(rowNew.NUMDOCUM)));
    /* _modificato := _modificato or (rowOld.DATARILASC<>rowNew.DATARILASC) */
    _modificato = _modificato || (CPLib.ne(rowOld.DATARILASC,rowNew.DATARILASC));
    /* _modificato := _modificato or (LRTrim(rowOld.AUTRILASC)<>LRTrim(rowNew.AUTRILASC)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.AUTRILASC),CPLib.LRTrim(rowNew.AUTRILASC)));
    /* _modificato := _modificato or (LRTrim(rowOld.DESCCIT)<>LRTrim(rowNew.DESCCIT)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.DESCCIT),CPLib.LRTrim(rowNew.DESCCIT)));
    /* _modificato := _modificato or (LRTrim(rowOld.PROVINCIA)<>LRTrim(rowNew.PROVINCIA)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.PROVINCIA),CPLib.LRTrim(rowNew.PROVINCIA)));
    /* _modificato := _modificato or (LRTrim(rowOld.PAESE)<>LRTrim(rowNew.PAESE)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.PAESE),CPLib.LRTrim(rowNew.PAESE)));
    /* _modificato := _modificato or (LRTrim(rowOld.CAP)<>LRTrim(rowNew.CAP)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.CAP),CPLib.LRTrim(rowNew.CAP)));
    /* _modificato := _modificato or (LRTrim(rowOld.CODINTER)<>LRTrim(rowNew.CODINTER)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.CODINTER),CPLib.LRTrim(rowNew.CODINTER)));
    /* _modificato := _modificato or (LRTrim(rowOld.TIPINTER)<>LRTrim(rowNew.TIPINTER)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.TIPINTER),CPLib.LRTrim(rowNew.TIPINTER)));
    /* _modificato := _modificato or (LRTrim(rowOld.TIPOPERS)<>LRTrim(rowNew.TIPOPERS)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.TIPOPERS),CPLib.LRTrim(rowNew.TIPOPERS)));
    /* _modificato := _modificato or (LRTrim(rowOld.CODDIPE)<>LRTrim(rowNew.CODDIPE)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.CODDIPE),CPLib.LRTrim(rowNew.CODDIPE)));
    /* _modificato := _modificato or (LRTrim(rowOld.PARTIVA)<>LRTrim(rowNew.PARTIVA)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.PARTIVA),CPLib.LRTrim(rowNew.PARTIVA)));
    /* _modificato := _modificato or (LRTrim(rowOld.NOTE)<>LRTrim(rowNew.NOTE)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.NOTE),CPLib.LRTrim(rowNew.NOTE)));
    /* _modificato := _modificato or (LRTrim(rowOld.SESSO)<>LRTrim(rowNew.SESSO)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.SESSO),CPLib.LRTrim(rowNew.SESSO)));
    /* _modificato := _modificato or (LRTrim(rowOld.SOSPMAF)<>LRTrim(rowNew.SOSPMAF)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.SOSPMAF),CPLib.LRTrim(rowNew.SOSPMAF)));
    /* _modificato := _modificato or (LRTrim(rowOld.idcitta)<>LRTrim(rowNew.idcitta)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.idcitta),CPLib.LRTrim(rowNew.idcitta)));
    /* _modificato := _modificato or (rowOld.DATAVALI<>rowNew.DATAVALI) */
    _modificato = _modificato || (CPLib.ne(rowOld.DATAVALI,rowNew.DATAVALI));
    /* _modificato := _modificato or (LRTrim(rowOld.NASSTATO)<>LRTrim(rowNew.NASSTATO)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.NASSTATO),CPLib.LRTrim(rowNew.NASSTATO)));
    /* _modificato := _modificato or (LRTrim(rowOld.DOCFILE)<>LRTrim(rowNew.DOCFILE)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.DOCFILE),CPLib.LRTrim(rowNew.DOCFILE)));
    /* _modificato := _modificato or (LRTrim(rowOld.NOME)<>LRTrim(rowNew.NOME)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.NOME),CPLib.LRTrim(rowNew.NOME)));
    /* _modificato := _modificato or (LRTrim(rowOld.COGNOME)<>LRTrim(rowNew.COGNOME)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.COGNOME),CPLib.LRTrim(rowNew.COGNOME)));
    /* _modificato := _modificato or (rowOld.CFESTERO<>rowNew.CFESTERO) */
    _modificato = _modificato || (CPLib.ne(rowOld.CFESTERO,rowNew.CFESTERO));
    /* _modificato := _modificato or (LRTrim(rowOld.OLDCONNES)<>LRTrim(rowNew.OLDCONNES)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.OLDCONNES),CPLib.LRTrim(rowNew.OLDCONNES)));
    /* _modificato := _modificato or (rowOld.DATEXTRA<>rowNew.DATEXTRA) */
    _modificato = _modificato || (CPLib.ne(rowOld.DATEXTRA,rowNew.DATEXTRA));
    /* _modificato := _modificato or (LRTrim(rowOld.PKTBSPECIE)<>LRTrim(rowNew.PKTBSPECIE)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.PKTBSPECIE),CPLib.LRTrim(rowNew.PKTBSPECIE)));
    /* _modificato := _modificato or (LRTrim(rowOld.COMPORT)<>LRTrim(rowNew.COMPORT)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.COMPORT),CPLib.LRTrim(rowNew.COMPORT)));
    /* _modificato := _modificato or (LRTrim(rowOld.ATTIV)<>LRTrim(rowNew.ATTIV)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.ATTIV),CPLib.LRTrim(rowNew.ATTIV)));
    /* _modificato := _modificato or (rowOld.RNATGIU<>rowNew.RNATGIU) */
    _modificato = _modificato || (CPLib.ne(rowOld.RNATGIU,rowNew.RNATGIU));
    /* _modificato := _modificato or (rowOld.RATTIV<>rowNew.RATTIV) */
    _modificato = _modificato || (CPLib.ne(rowOld.RATTIV,rowNew.RATTIV));
    /* _modificato := _modificato or (rowOld.RCOMP<>rowNew.RCOMP) */
    _modificato = _modificato || (CPLib.ne(rowOld.RCOMP,rowNew.RCOMP));
    /* _modificato := _modificato or (rowOld.RAREA<>rowNew.RAREA) */
    _modificato = _modificato || (CPLib.ne(rowOld.RAREA,rowNew.RAREA));
    /* _modificato := _modificato or (rowOld.ALLINEATO<>rowNew.ALLINEATO) */
    _modificato = _modificato || (CPLib.ne(rowOld.ALLINEATO,rowNew.ALLINEATO));
    /* _modificato := _modificato or (rowOld.ALLINEATONOMECNOME<>rowNew.ALLINEATONOMECNOME) */
    _modificato = _modificato || (CPLib.ne(rowOld.ALLINEATONOMECNOME,rowNew.ALLINEATONOMECNOME));
    /* _modificato := _modificato or (LRTrim(rowOld.RAGSOCOLD)<>LRTrim(rowNew.RAGSOCOLD)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.RAGSOCOLD),CPLib.LRTrim(rowNew.RAGSOCOLD)));
    /* _modificato := _modificato or (rowOld.PROGIMPORT<>rowNew.PROGIMPORT) */
    _modificato = _modificato || (CPLib.ne(rowOld.PROGIMPORT,rowNew.PROGIMPORT));
    /* _modificato := _modificato or (LRTrim(rowOld.PROGIMP_C)<>LRTrim(rowNew.PROGIMP_C)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.PROGIMP_C),CPLib.LRTrim(rowNew.PROGIMP_C)));
    /* _modificato := _modificato or (LRTrim(rowOld.AREAGEO)<>LRTrim(rowNew.AREAGEO)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.AREAGEO),CPLib.LRTrim(rowNew.AREAGEO)));
    /* _modificato := _modificato or (LRTrim(rowOld.PEP)<>LRTrim(rowNew.PEP)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.PEP),CPLib.LRTrim(rowNew.PEP)));
    /* _modificato := _modificato or (LRTrim(rowOld.IDFILE)<>LRTrim(rowNew.IDFILE)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.IDFILE),CPLib.LRTrim(rowNew.IDFILE)));
    /* _modificato := _modificato or (LRTrim(rowOld.OLDCODFISC)<>LRTrim(rowNew.OLDCODFISC)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.OLDCODFISC),CPLib.LRTrim(rowNew.OLDCODFISC)));
    /* _modificato := _modificato or (LRTrim(rowOld.MACROAGENTE)<>LRTrim(rowNew.MACROAGENTE)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.MACROAGENTE),CPLib.LRTrim(rowNew.MACROAGENTE)));
    /* _modificato := _modificato or (LRTrim(rowOld.SPOTID)<>LRTrim(rowNew.SPOTID)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.SPOTID),CPLib.LRTrim(rowNew.SPOTID)));
    /* _modificato := _modificato or (rowOld.DATASEGN<>rowNew.DATASEGN) */
    _modificato = _modificato || (CPLib.ne(rowOld.DATASEGN,rowNew.DATASEGN));
    /* _modificato := _modificato or (LRTrim(rowOld.OLDSETSIN)<>LRTrim(rowNew.OLDSETSIN)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.OLDSETSIN),CPLib.LRTrim(rowNew.OLDSETSIN)));
    /* _modificato := _modificato or (rowOld.DATAVARAGE<>rowNew.DATAVARAGE) */
    _modificato = _modificato || (CPLib.ne(rowOld.DATAVARAGE,rowNew.DATAVARAGE));
    /* _modificato := _modificato or (LRTrim(rowOld.SETTSINT2)<>LRTrim(rowNew.SETTSINT2)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.SETTSINT2),CPLib.LRTrim(rowNew.SETTSINT2)));
    /* _modificato := _modificato or (LRTrim(rowOld.FATCA)<>LRTrim(rowNew.FATCA)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.FATCA),CPLib.LRTrim(rowNew.FATCA)));
    /* _modificato := _modificato or (LRTrim(rowOld.BANCABEN)<>LRTrim(rowNew.BANCABEN)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.BANCABEN),CPLib.LRTrim(rowNew.BANCABEN)));
    /* _modificato := _modificato or (LRTrim(rowOld.TIN)<>LRTrim(rowNew.TIN)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.TIN),CPLib.LRTrim(rowNew.TIN)));
    /* _modificato := _modificato or (rowOld.ODB<>rowNew.ODB) */
    _modificato = _modificato || (CPLib.ne(rowOld.ODB,rowNew.ODB));
    /* _modificato := _modificato or (LRTrim(rowOld.TELEF)<>LRTrim(rowNew.TELEF)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.TELEF),CPLib.LRTrim(rowNew.TELEF)));
    /* _modificato := _modificato or (LRTrim(rowOld.TIPOORO)<>LRTrim(rowNew.TIPOORO)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.TIPOORO),CPLib.LRTrim(rowNew.TIPOORO)));
    /* _modificato := _modificato or (LRTrim(rowOld.CODORO)<>LRTrim(rowNew.CODORO)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.CODORO),CPLib.LRTrim(rowNew.CODORO)));
    /* _modificato := _modificato or (LRTrim(rowOld.IDNASCOMUN)<>LRTrim(rowNew.IDNASCOMUN)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.IDNASCOMUN),CPLib.LRTrim(rowNew.IDNASCOMUN)));
    /* _modificato := _modificato or (LRTrim(rowOld.IDNASSTATO)<>LRTrim(rowNew.IDNASSTATO)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.IDNASSTATO),CPLib.LRTrim(rowNew.IDNASSTATO)));
    /* _modificato := _modificato or (rowOld.NOTIT<>rowNew.NOTIT) */
    _modificato = _modificato || (CPLib.ne(rowOld.NOTIT,rowNew.NOTIT));
    /* _modificato := _modificato or (LRTrim(rowOld.IDBASE)<>LRTrim(rowNew.IDBASE)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.IDBASE),CPLib.LRTrim(rowNew.IDBASE)));
    /* _modificato := _modificato or (LRTrim(rowOld.FLGVALIDO)<>LRTrim(rowNew.FLGVALIDO)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.FLGVALIDO),CPLib.LRTrim(rowNew.FLGVALIDO)));
    /* _modificato := _modificato or (LRTrim(rowOld.CITTADIN1)<>LRTrim(rowNew.CITTADIN1)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.CITTADIN1),CPLib.LRTrim(rowNew.CITTADIN1)));
    /* _modificato := _modificato or (LRTrim(rowOld.CITTADIN2)<>LRTrim(rowNew.CITTADIN2)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.CITTADIN2),CPLib.LRTrim(rowNew.CITTADIN2)));
    /* _modificato := _modificato or (LRTrim(rowOld.RESFISC)<>LRTrim(rowNew.RESFISC)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.RESFISC),CPLib.LRTrim(rowNew.RESFISC)));
    /* _modificato := _modificato or (rowOld.MITIG<>rowNew.MITIG) */
    _modificato = _modificato || (CPLib.ne(rowOld.MITIG,rowNew.MITIG));
    /* _modificato := _modificato or (LRTrim(rowOld.MITIGDOC)<>LRTrim(rowNew.MITIGDOC)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.MITIGDOC),CPLib.LRTrim(rowNew.MITIGDOC)));
    /* _modificato := _modificato or (LRTrim(rowOld.NOSARA)<>LRTrim(rowNew.NOSARA)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.NOSARA),CPLib.LRTrim(rowNew.NOSARA)));
    /* _modificato := _modificato or (LRTrim(rowOld.RISGLOB)<>LRTrim(rowNew.RISGLOB)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.RISGLOB),CPLib.LRTrim(rowNew.RISGLOB)));
    /* _modificato := _modificato or (rowOld.DATAPROF<>rowNew.DATAPROF) */
    _modificato = _modificato || (CPLib.ne(rowOld.DATAPROF,rowNew.DATAPROF));
    /* _modificato := _modificato or (rowOld.DATAREVPROF<>rowNew.DATAREVPROF) */
    _modificato = _modificato || (CPLib.ne(rowOld.DATAREVPROF,rowNew.DATAREVPROF));
    /* _modificato := _modificato or (LRTrim(rowOld.IDENT)<>LRTrim(rowNew.IDENT)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.IDENT),CPLib.LRTrim(rowNew.IDENT)));
    /* _modificato := _modificato or (rowOld.PEPDATE<>rowNew.PEPDATE) */
    _modificato = _modificato || (CPLib.ne(rowOld.PEPDATE,rowNew.PEPDATE));
    /* _modificato := _modificato or (LRTrim(rowOld.DAC6)<>LRTrim(rowNew.DAC6)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.DAC6),CPLib.LRTrim(rowNew.DAC6)));
    /* _modificato := _modificato or (rowOld.FLAGDAC6<>rowNew.FLAGDAC6) */
    _modificato = _modificato || (CPLib.ne(rowOld.FLAGDAC6,rowNew.FLAGDAC6));
    /* _modificato := _modificato or (LRTrim(rowOld.CRIME)<>LRTrim(rowNew.CRIME)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.CRIME),CPLib.LRTrim(rowNew.CRIME)));
    /* _modificato := _modificato or (rowOld.CRIMEDATE<>rowNew.CRIMEDATE) */
    _modificato = _modificato || (CPLib.ne(rowOld.CRIMEDATE,rowNew.CRIMEDATE));
    /* _modificato := _modificato or (LRTrim(rowOld.ALTRODOM)<>LRTrim(rowNew.ALTRODOM)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.ALTRODOM),CPLib.LRTrim(rowNew.ALTRODOM)));
    /* _modificato := _modificato or (LRTrim(rowOld.ALTROCAP)<>LRTrim(rowNew.ALTROCAP)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.ALTROCAP),CPLib.LRTrim(rowNew.ALTROCAP)));
    /* _modificato := _modificato or (LRTrim(rowOld.CONTO)<>LRTrim(rowNew.CONTO)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.CONTO),CPLib.LRTrim(rowNew.CONTO)));
    /* _modificato := _modificato or (rowOld.NUMIMP<>rowNew.NUMIMP) */
    _modificato = _modificato || (CPLib.ne(rowOld.NUMIMP,rowNew.NUMIMP));
    /* _modificato := _modificato or (LRTrim(rowOld.RAPSEGNA)<>LRTrim(rowNew.RAPSEGNA)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.RAPSEGNA),CPLib.LRTrim(rowNew.RAPSEGNA)));
    /* _modificato := _modificato or (LRTrim(rowOld.CODLEGRAP)<>LRTrim(rowNew.CODLEGRAP)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.CODLEGRAP),CPLib.LRTrim(rowNew.CODLEGRAP)));
    /* _modificato := _modificato or (LRTrim(rowOld.TIPOSOGGETTO)<>LRTrim(rowNew.TIPOSOGGETTO)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.TIPOSOGGETTO),CPLib.LRTrim(rowNew.TIPOSOGGETTO)));
    /* _modificato := _modificato or (rowOld.CAUSALE<>rowNew.CAUSALE) */
    _modificato = _modificato || (CPLib.ne(rowOld.CAUSALE,rowNew.CAUSALE));
    /* _modificato := _modificato or (rowOld.IMPORTOMAX<>rowNew.IMPORTOMAX) */
    _modificato = _modificato || (CPLib.ne(rowOld.IMPORTOMAX,rowNew.IMPORTOMAX));
    /* _modificato := _modificato or (rowOld.FATTURATO<>rowNew.FATTURATO) */
    _modificato = _modificato || (CPLib.ne(rowOld.FATTURATO,rowNew.FATTURATO));
    /* _modificato := _modificato or (rowOld.FREQUENZA<>rowNew.FREQUENZA) */
    _modificato = _modificato || (CPLib.ne(rowOld.FREQUENZA,rowNew.FREQUENZA));
    /* _modificato := _modificato or (rowOld.NUMOPERAZ<>rowNew.NUMOPERAZ) */
    _modificato = _modificato || (CPLib.ne(rowOld.NUMOPERAZ,rowNew.NUMOPERAZ));
    /* _modificato := _modificato or (LRTrim(rowOld.SOGAFFIDATARIO)<>LRTrim(rowNew.SOGAFFIDATARIO)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.SOGAFFIDATARIO),CPLib.LRTrim(rowNew.SOGAFFIDATARIO)));
    /* _modificato := _modificato or (LRTrim(rowOld.FLGNOTRIM)<>LRTrim(rowNew.FLGNOTRIM)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.FLGNOTRIM),CPLib.LRTrim(rowNew.FLGNOTRIM)));
    /* _modificato := _modificato or (rowOld.DISATTIVO<>rowNew.DISATTIVO) */
    _modificato = _modificato || (CPLib.ne(rowOld.DISATTIVO,rowNew.DISATTIVO));
    /* _modificato := _modificato or (rowOld.DATAFINE<>rowNew.DATAFINE) */
    _modificato = _modificato || (CPLib.ne(rowOld.DATAFINE,rowNew.DATAFINE));
    /* _modificato := _modificato or (rowOld.DATAINI<>rowNew.DATAINI) */
    _modificato = _modificato || (CPLib.ne(rowOld.DATAINI,rowNew.DATAINI));
    /* _modificato := _modificato or (rowOld.DATAIDENT<>rowNew.DATAIDENT) */
    _modificato = _modificato || (CPLib.ne(rowOld.DATAIDENT,rowNew.DATAIDENT));
    /* _modificato := _modificato or (rowOld.DATASIGN<>rowNew.DATASIGN) */
    _modificato = _modificato || (CPLib.ne(rowOld.DATASIGN,rowNew.DATASIGN));
    /* _modificato := _modificato or (rowOld.DATARAUT<>rowNew.DATARAUT) */
    _modificato = _modificato || (CPLib.ne(rowOld.DATARAUT,rowNew.DATARAUT));
    /* _modificato := _modificato or (LRTrim(rowOld.VERIFICA)<>LRTrim(rowNew.VERIFICA)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.VERIFICA),CPLib.LRTrim(rowNew.VERIFICA)));
    /* _modificato := _modificato or (LRTrim(rowOld.NOTERIS)<>LRTrim(rowNew.NOTERIS)) */
    _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(rowOld.NOTERIS),CPLib.LRTrim(rowNew.NOTERIS)));
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
  public static arrt_storicopersR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_storicopersR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pObj = null;
    cProgSto = CPLib.Space(15);
    _data = CPLib.NullDate();
    _oldcon = CPLib.Space(16);
    rowOld = new MemoryCursorRow_personbo();
    rowNew = new MemoryCursorRow_personbo();
    mcPersonbo = new MemoryCursor_personbo();
    _modificato = false;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gDataVaria=m_Ctx.GetGlobalDate("gDataVaria");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000089(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"sanumpro,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"idcitta,";
    p_cSql = p_cSql+"datamodi,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"OLDCONNES,";
    p_cSql = p_cSql+"DATEXTRA,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"RAGSOCOLD,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PROGIMP_C,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"SPOTID,";
    p_cSql = p_cSql+"DATASEGN,";
    p_cSql = p_cSql+"OLDSETSIN,";
    p_cSql = p_cSql+"DATAVARAGE,";
    p_cSql = p_cSql+"SETTSINT2,";
    p_cSql = p_cSql+"FATCA,";
    p_cSql = p_cSql+"BANCABEN,";
    p_cSql = p_cSql+"TIN,";
    p_cSql = p_cSql+"ODB,";
    p_cSql = p_cSql+"TELEF,";
    p_cSql = p_cSql+"TIPOORO,";
    p_cSql = p_cSql+"CODORO,";
    p_cSql = p_cSql+"IDNASCOMUN,";
    p_cSql = p_cSql+"IDNASSTATO,";
    p_cSql = p_cSql+"NOTIT,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+"CITTADIN1,";
    p_cSql = p_cSql+"CITTADIN2,";
    p_cSql = p_cSql+"RESFISC,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+"NOSARA,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"DATAPROF,";
    p_cSql = p_cSql+"DATAREVPROF,";
    p_cSql = p_cSql+"IDENT,";
    p_cSql = p_cSql+"PEPDATE,";
    p_cSql = p_cSql+"DAC6,";
    p_cSql = p_cSql+"FLAGDAC6,";
    p_cSql = p_cSql+"CRIME,";
    p_cSql = p_cSql+"CRIMEDATE,";
    p_cSql = p_cSql+"ALTRODOM,";
    p_cSql = p_cSql+"ALTROCAP,";
    p_cSql = p_cSql+"CONTO,";
    p_cSql = p_cSql+"RAPSEGNA,";
    p_cSql = p_cSql+"CODLEGRAP,";
    p_cSql = p_cSql+"TIPOSOGGETTO,";
    p_cSql = p_cSql+"CAUSALE,";
    p_cSql = p_cSql+"IMPORTOMAX,";
    p_cSql = p_cSql+"FATTURATO,";
    p_cSql = p_cSql+"FREQUENZA,";
    p_cSql = p_cSql+"NUMOPERAZ,";
    p_cSql = p_cSql+"SOGAFFIDATARIO,";
    p_cSql = p_cSql+"FLGNOTRIM,";
    p_cSql = p_cSql+"DISATTIVO,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAIDENT,";
    p_cSql = p_cSql+"DATASIGN,";
    p_cSql = p_cSql+"DATARAUT,";
    p_cSql = p_cSql+"VERIFICA,";
    p_cSql = p_cSql+"NOTERIS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"sanumpro,";
    p_cSql = p_cSql+"datamodi,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"sanumpro,";
    p_cSql = p_cSql+"datamodi,";
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
    p_cSql = p_cSql+"NUMCEL,";
    p_cSql = p_cSql+"PEC,";
    p_cSql = p_cSql+"REFERENTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo_agg",true);
    return p_cSql;
  }
}
