// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_trasfrapR implements CallerWithObjs {
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
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_xoginfo;
  public String m_cServer_xoginfo;
  public String m_cPhName_soginfo;
  public String m_cServer_soginfo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public String m_cPhName_xiduciabo;
  public String m_cServer_xiduciabo;
  public String m_cPhName_fiduciabo;
  public String m_cServer_fiduciabo;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
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
  public String cProg1;
  public String cProg2;
  public String cProg3;
  public String cIDB2;
  public String w_RAPPORTO;
  public double nProgImp;
  public double _crap;
  public double _cinf;
  public java.sql.Date _datareg;
  public MemoryCursor_xnarapbo mcRapporti;
  public double _contarow;
  public String _rapporto;
  public String _numprog;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String gCodDip;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_trasfrapR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_trasfrap",m_Caller);
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_xoginfo = p_ContextObject.GetPhName("xoginfo");
    if (m_cPhName_xoginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xoginfo = m_cPhName_xoginfo+" "+m_Ctx.GetWritePhName("xoginfo");
    }
    m_cServer_xoginfo = p_ContextObject.GetServer("xoginfo");
    m_cPhName_soginfo = p_ContextObject.GetPhName("soginfo");
    if (m_cPhName_soginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_soginfo = m_cPhName_soginfo+" "+m_Ctx.GetWritePhName("soginfo");
    }
    m_cServer_soginfo = p_ContextObject.GetServer("soginfo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    if (m_cPhName_xelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xelegabo = m_cPhName_xelegabo+" "+m_Ctx.GetWritePhName("xelegabo");
    }
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    m_cPhName_xiduciabo = p_ContextObject.GetPhName("xiduciabo");
    if (m_cPhName_xiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xiduciabo = m_cPhName_xiduciabo+" "+m_Ctx.GetWritePhName("xiduciabo");
    }
    m_cServer_xiduciabo = p_ContextObject.GetServer("xiduciabo");
    m_cPhName_fiduciabo = p_ContextObject.GetPhName("fiduciabo");
    if (m_cPhName_fiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fiduciabo = m_cPhName_fiduciabo+" "+m_Ctx.GetWritePhName("fiduciabo");
    }
    m_cServer_fiduciabo = p_ContextObject.GetServer("fiduciabo");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("_crap",p_cVarName)) {
      return _crap;
    }
    if (CPLib.eqr("_cinf",p_cVarName)) {
      return _cinf;
    }
    if (CPLib.eqr("_contarow",p_cVarName)) {
      return _contarow;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_trasfrap";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("cProg1",p_cVarName)) {
      return cProg1;
    }
    if (CPLib.eqr("cProg2",p_cVarName)) {
      return cProg2;
    }
    if (CPLib.eqr("cProg3",p_cVarName)) {
      return cProg3;
    }
    if (CPLib.eqr("cIDB2",p_cVarName)) {
      return cIDB2;
    }
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      return w_RAPPORTO;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      return _numprog;
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
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_datareg",p_cVarName)) {
      return _datareg;
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
    if (CPLib.eqr("mcRapporti",p_cVarName)) {
      return mcRapporti;
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
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("_crap",p_cVarName)) {
      _crap = value;
      return;
    }
    if (CPLib.eqr("_cinf",p_cVarName)) {
      _cinf = value;
      return;
    }
    if (CPLib.eqr("_contarow",p_cVarName)) {
      _contarow = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("cProg1",p_cVarName)) {
      cProg1 = value;
      return;
    }
    if (CPLib.eqr("cProg2",p_cVarName)) {
      cProg2 = value;
      return;
    }
    if (CPLib.eqr("cProg3",p_cVarName)) {
      cProg3 = value;
      return;
    }
    if (CPLib.eqr("cIDB2",p_cVarName)) {
      cIDB2 = value;
      return;
    }
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      w_RAPPORTO = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      _numprog = value;
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
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_datareg",p_cVarName)) {
      _datareg = value;
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
    if (CPLib.eqr("mcRapporti",p_cVarName)) {
      mcRapporti = (MemoryCursor_xnarapbo)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_xnarapbo=null;
    CPResultSet Cursor_qbe_trasfrrap2=null;
    CPResultSet Cursor_xapopebo=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_xelegabo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_xoginfo=null;
    CPResultSet Cursor_xiduciabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* cProg1 Char(10) */
      /* cProg2 Char(11) */
      /* cProg3 Char(10) */
      /* cIDB2 Char(10) */
      /* w_RAPPORTO Char(25) */
      /* nProgImp Numeric(15, 0) */
      /* _crap Numeric(10, 0) */
      /* _cinf Numeric(10, 0) */
      /* _datareg Date */
      /* mcRapporti MemoryCursor(xnarapbo) */
      /* _contarow Numeric(3, 0) */
      /* _rapporto Char(25) */
      /* _numprog Char(11) */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gCodDip Char(6) // Dipendenza */
      /* Scorre la query e trasferisce i dati */
      /* gMsgProc := 'Ora Inizio Trasferimento: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Trasferimento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000017status;
      nTry00000017status = m_Sql.GetTransactionStatus();
      String cTry00000017msg;
      cTry00000017msg = m_Sql.TransactionErrorMessage();
      try {
        /* _crap := 0 */
        _crap = CPLib.Round(0,0);
        /* _cinf := 0 */
        _cinf = CPLib.Round(0,0);
        // * --- Select from xnarapbo
        m_cServer = m_Ctx.GetServer("xnarapbo");
        m_cPhName = m_Ctx.GetPhName("xnarapbo");
        if (Cursor_xnarapbo!=null)
          Cursor_xnarapbo.Close();
        Cursor_xnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("xnarapbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xnarapbo.Eof())) {
          /* If Empty(xnarapbo->CODDIPE) or xnarapbo->CODDIPE=gCodDip or Empty(gCodDip) */
          if (CPLib.Empty(Cursor_xnarapbo.GetString("CODDIPE")) || CPLib.eqr(Cursor_xnarapbo.GetString("CODDIPE"),gCodDip) || CPLib.Empty(gCodDip)) {
            /* _crap := _crap + 1 */
            _crap = CPLib.Round(_crap+1,0);
            /* gMsgImp := 'Trasferimento dati base del rapporto: '+xnarapbo->RAPPORTO // Messaggio Import */
            gMsgImp = "Trasferimento dati base del rapporto: "+Cursor_xnarapbo.GetString("RAPPORTO");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* nProgImp := Utilities.GetAutonumber("PRGIMPRAP\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAP\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            /* mcRapporti.AppendBlank() */
            mcRapporti.AppendBlank();
            /* mcRapporti.RAPPORTO := xnarapbo->RAPPORTO */
            mcRapporti.row.RAPPORTO = Cursor_xnarapbo.GetString("RAPPORTO");
            /* mcRapporti.SaveRow() */
            mcRapporti.SaveRow();
            /* _rapporto := xnarapbo->RAPPORTO */
            _rapporto = Cursor_xnarapbo.GetString("RAPPORTO");
            // * --- Merge into anarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
            m_cQuery = "select ";
            m_cQuery =  m_cQuery+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAPPORTO"),"?",0,0)+" as RAPPORTO";
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
              m_cQuery = m_cQuery+" from dual";
            }
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cWhere = "anarapbo.RAPPORTO = cptmp_1xab23.RAPPORTO";
            m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
              m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"00000023")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" anarapbo USING ";
              m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
              m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
              m_cSql = m_cSql+"anarapbo.AREAGEO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("AREAGEO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CONTINUA = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CONTINUA"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.DATAMOD = "+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAMOD"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.DESCRAP = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("DESCRAP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.DOCFILE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("DOCFILE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.FLAGLIRE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("FLAGLIRE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.IDBASE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDBASE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.IDRAPPORTO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDRAPPORTO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.MODSVOL = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("MODSVOL"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.NATURA = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("NATURA"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.NOPROT = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("NOPROT"),"?",0,0)+" , ";
              m_cSql = m_cSql+"PRGIMPRAP = "+CPLib.ToSQL(nProgImp,"N",15,0)+", ";
              m_cSql = m_cSql+"anarapbo.RAGIO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAGIO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.RAREA = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RAREA"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.RCOMP = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RCOMP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.RFREQ = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RFREQ"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.RIMP = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RIMP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.RRAGIO = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RRAGIO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.RTIPO = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RTIPO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.SCOPO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("SCOPO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.TIPMOD = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPMOD"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.TIPO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.TIPOAG = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPOAG"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.TIPORAP = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPORAP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.VALUTA = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("VALUTA"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.IMPAPE = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPAPE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.IMPCHIU = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPCHIU"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.SPLITCODE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("SPLITCODE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.MACODICE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("MACODICE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CODDIP = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CODICELR = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODICELR"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.MITIG = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("MITIG"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.MITGDOC = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("MITGDOC"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CATEG01 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG01"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CATEG02 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG02"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CATEG03 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG03"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CATEG04 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG04"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CATEG05 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG05"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CATEGORIA = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEGORIA"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CODDIPE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.DAC6 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("DAC6"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.FLAGDAC6 = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("FLAGDAC6"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.IBAN = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("IBAN"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CODOGG = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODOGG"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.RISGLOB = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("RISGLOB"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.DATAPROF = "+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAPROF"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.DATAREVPROF = "+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAREVPROF"),"?",0,0)+" , ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",true,true);
              m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
              m_cSql = m_cSql+GetFieldsName_00000023(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAMOD"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("NOPROT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xnarapbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xnarapbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPAPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPCHIU"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("SPLITCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("MACODICE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODICELR"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("MITIG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("IBAN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODOGG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAPROF"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAREVPROF"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"anarapbo",true);
              m_cSql = m_cSql+")";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = m_cSql+";";
              }
            } else {
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"00000023")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"AREAGEO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("AREAGEO"),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"CONTINUA = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CONTINUA"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAMOD = "+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAMOD"),"D",8,0)+", ";
              m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("DESCRAP"),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("DOCFILE"),"C",100,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGLIRE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("FLAGLIRE"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"IDRAPPORTO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDRAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"MODSVOL = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("MODSVOL"),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"NATURA = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("NATURA"),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"NOPROT = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("NOPROT"),"N",1,0)+", ";
              m_cSql = m_cSql+"PRGIMPRAP = "+CPLib.ToSQL(nProgImp,"N",15,0)+", ";
              m_cSql = m_cSql+"RAGIO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAGIO"),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAREA = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RAREA"),"N",3,0)+", ";
              m_cSql = m_cSql+"RCOMP = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RCOMP"),"N",3,0)+", ";
              m_cSql = m_cSql+"RFREQ = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RFREQ"),"N",3,0)+", ";
              m_cSql = m_cSql+"RIMP = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RIMP"),"N",3,0)+", ";
              m_cSql = m_cSql+"RRAGIO = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RRAGIO"),"N",3,0)+", ";
              m_cSql = m_cSql+"RTIPO = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RTIPO"),"N",3,0)+", ";
              m_cSql = m_cSql+"SCOPO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("SCOPO"),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPMOD = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPMOD"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPO"),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPOAG"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQLNull(Cursor_xnarapbo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQLNull(Cursor_xnarapbo.GetString("VALUTA"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"IMPAPE = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPAPE"),"N",1,0)+", ";
              m_cSql = m_cSql+"IMPCHIU = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPCHIU"),"N",1,0)+", ";
              m_cSql = m_cSql+"SPLITCODE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("SPLITCODE"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"MACODICE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("MACODICE"),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODDIP = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODICELR = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODICELR"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"MITIG = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("MITIG"),"N",4,0)+", ";
              m_cSql = m_cSql+"MITGDOC = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("MITGDOC"),"C",100,0,m_cServer)+", ";
              m_cSql = m_cSql+"CATEG01 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG01"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CATEG02 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG02"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CATEG03 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG03"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CATEG04 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG04"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CATEG05 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG05"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CATEGORIA = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEGORIA"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DAC6 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("DAC6"),"C",100,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGDAC6 = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("FLAGDAC6"),"N",1,0)+", ";
              m_cSql = m_cSql+"IBAN = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("IBAN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODOGG = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODOGG"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RISGLOB = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("RISGLOB"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAPROF = "+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAPROF"),"D",8,0)+", ";
              m_cSql = m_cSql+"DATAREVPROF = "+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAREVPROF"),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xnarapbo.GetString("RAPPORTO"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.eqr(m_nUpdatedRows,0)) {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"00000023")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000023(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAMOD"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("NOPROT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RAREA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RCOMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RFREQ"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RIMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RRAGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RTIPO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xnarapbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xnarapbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPAPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPCHIU"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("SPLITCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("MACODICE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODICELR"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("MITIG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("IBAN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODOGG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAPROF"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAREVPROF"),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"anarapbo",true);
                m_cSql = m_cSql+")";
              } else {
                m_cSql = "";
              }
            }
            if ( ! (CPLib.Empty(m_cSql))) {
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            }
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              throw new RoutineException();
            }
            // * --- Write into knarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"00000024")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL("D","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"knarapbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xnarapbo.GetString("RAPPORTO"))+"";
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
            /* If xnarapbo->NOPROT<>1 */
            if (CPLib.ne(Cursor_xnarapbo.GetDouble("NOPROT"),1)) {
              /* nProgImp := Utilities.GetAutonumber("PROGAET\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAET\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into aetesta from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"00000027")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000027(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_xnarapbo.GetString("TIPORAP"),"1")?"1":"2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_xnarapbo.GetString("TIPOAG"),"99")?CPLib.Upper(CPLib.Left(Cursor_xnarapbo.GetString("DESCRAP"),24)):""),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("A","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aetesta",true);
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
            } // End If
          } // End If
          Cursor_xnarapbo.Next();
        }
        m_cConnectivityError = Cursor_xnarapbo.ErrorMessage();
        Cursor_xnarapbo.Close();
        // * --- End Select
        // * --- Select from qbe_trasfrrap2
        if (Cursor_qbe_trasfrrap2!=null)
          Cursor_qbe_trasfrrap2.Close();
        Cursor_qbe_trasfrrap2 = new VQRHolder("qbe_trasfrrap2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_trasfrrap2.Eof())) {
          // * --- Select from xapopebo
          m_cServer = m_Ctx.GetServer("xapopebo");
          m_cPhName = m_Ctx.GetPhName("xapopebo");
          if (Cursor_xapopebo!=null)
            Cursor_xapopebo.Close();
          Cursor_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAREG="+CPLib.ToSQL(Cursor_qbe_trasfrrap2.GetDate("DATAREG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAOPE ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_xapopebo.Eof())) {
            /* If Empty(xapopebo->CODDIPE) or xapopebo->CODDIPE=gCodDip or Empty(gCodDip) */
            if (CPLib.Empty(Cursor_xapopebo.GetString("CODDIPE")) || CPLib.eqr(Cursor_xapopebo.GetString("CODDIPE"),gCodDip) || CPLib.Empty(gCodDip)) {
              /* _cinf := _cinf + 1 */
              _cinf = CPLib.Round(_cinf+1,0);
              /* _rapporto := xapopebo->RAPPORTO */
              _rapporto = Cursor_xapopebo.GetString("RAPPORTO");
              /* _numprog := xapopebo->NUMPROG */
              _numprog = Cursor_xapopebo.GetString("NUMPROG");
              /* gMsgImp := 'Trasferimento dati informazione n. '+xapopebo->NUMPROG+' del rapporto: '+xapopebo->RAPPORTO // Messaggio Import */
              gMsgImp = "Trasferimento dati informazione n. "+Cursor_xapopebo.GetString("NUMPROG")+" del rapporto: "+Cursor_xapopebo.GetString("RAPPORTO");
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* cProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
              cProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
              /* cIDB2 := LibreriaMit.UniqueId() */
              cIDB2 = LibreriaMit.UniqueId();
              /* _datareg := Date() */
              _datareg = CPLib.Date();
              /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into rapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"00000034")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000034(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xapopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xapopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetDate("DATAAGE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datareg,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I"+CPLib.Right(cProg2,9)+cIDB2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_xapopebo.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cIDB2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
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
                throw new RoutineException();
              }
              /* Case xapopebo->TIPOOPRAP='25' or xapopebo->TIPOOPRAP='28' */
              if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"28")) {
                /* If xapopebo->TIPOOPRAP='25' */
                if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"25")) {
                  /* _contarow := 0 */
                  _contarow = CPLib.Round(0,0);
                  // * --- Select from delegabo
                  m_cServer = m_Ctx.GetServer("delegabo");
                  m_cPhName = m_Ctx.GetPhName("delegabo");
                  if (Cursor_delegabo!=null)
                    Cursor_delegabo.Close();
                  Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CPROWNUM  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
                  while ( ! (Cursor_delegabo.Eof())) {
                    /* _contarow := delegabo->CPROWNUM */
                    _contarow = CPLib.Round(Cursor_delegabo.GetDouble("CPROWNUM"),0);
                    Cursor_delegabo.Next();
                  }
                  m_cConnectivityError = Cursor_delegabo.ErrorMessage();
                  Cursor_delegabo.Close();
                  // * --- End Select
                  // * --- Select from xelegabo
                  m_cServer = m_Ctx.GetServer("xelegabo");
                  m_cPhName = m_Ctx.GetPhName("xelegabo");
                  if (Cursor_xelegabo!=null)
                    Cursor_xelegabo.Close();
                  Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_xelegabo.Eof())) {
                    /* _contarow := _contarow + 1 */
                    _contarow = CPLib.Round(_contarow+1,0);
                    // * --- Insert into delegabo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("delegabo");
                    m_cPhName = m_Ctx.GetPhName("delegabo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"0000003C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000003C(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_contarow,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetDate("DATAINI"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetDate("DATARETT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetDate("DATAFINE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("NOAGE"),"?",0,0,m_cServer)+", ";
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
                      throw new RoutineException();
                    }
                    Cursor_xelegabo.Next();
                  }
                  m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
                  Cursor_xelegabo.Close();
                  // * --- End Select
                  // * --- Delete from xelegabo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xelegabo");
                  m_cPhName = m_Ctx.GetPhName("xelegabo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xelegabo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"0000003D")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("RAPPORTO"))+"";
                  m_cSql = m_cSql+" and NUMPROG1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("NUMPROG"))+"";
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
                } else { // Else
                  // * --- Select from xelegabo
                  m_cServer = m_Ctx.GetServer("xelegabo");
                  m_cPhName = m_Ctx.GetPhName("xelegabo");
                  if (Cursor_xelegabo!=null)
                    Cursor_xelegabo.Close();
                  Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO=RAPPORTO  and  NUMPROG2="+CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_xelegabo.Eof())) {
                    // * --- Write into delegabo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("delegabo");
                    m_cPhName = m_Ctx.GetPhName("delegabo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"0000003F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_xapopebo.GetDate("DATAOPE"),"D",8,0)+", ";
                    m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cProg2,"C",11,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"delegabo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("RAPPORTO"))+"";
                    m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xelegabo.GetString("CODINTER"))+"";
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
                    Cursor_xelegabo.Next();
                  }
                  m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
                  Cursor_xelegabo.Close();
                  // * --- End Select
                  // * --- Delete from xelegabo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xelegabo");
                  m_cPhName = m_Ctx.GetPhName("xelegabo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xelegabo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"00000040")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("RAPPORTO"))+"";
                  m_cSql = m_cSql+" and NUMPROG2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("NUMPROG"))+"";
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
                } // End If
                /* Case Right(xapopebo->TIPOOPRAP,1)='6' or xapopebo->TIPOOPRAP='38' */
              } else if (CPLib.eqr(CPLib.Right(Cursor_xapopebo.GetString("TIPOOPRAP"),1),"6") || CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"38")) {
                // * --- Write into intestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"00000041")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_xapopebo.GetDate("DATAOPE"),"D",8,0)+", ";
                m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cProg2,"C",11,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("RAPPORTO"))+"";
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
                // * --- Delete from xntestbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xntestbo");
                m_cPhName = m_Ctx.GetPhName("xntestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"00000042")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("RAPPORTO"))+"";
                m_cSql = m_cSql+" and NUMPROG2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("NUMPROG"))+"";
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
              } else { // Otherwise
                /* _contarow := 0 */
                _contarow = CPLib.Round(0,0);
                // * --- Select from intestbo
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                if (Cursor_intestbo!=null)
                  Cursor_intestbo.Close();
                Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CPROWNUM  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
                while ( ! (Cursor_intestbo.Eof())) {
                  /* _contarow := intestbo->CPROWNUM */
                  _contarow = CPLib.Round(Cursor_intestbo.GetDouble("CPROWNUM"),0);
                  Cursor_intestbo.Next();
                }
                m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                Cursor_intestbo.Close();
                // * --- End Select
                // * --- Select from xntestbo
                m_cServer = m_Ctx.GetServer("xntestbo");
                m_cPhName = m_Ctx.GetPhName("xntestbo");
                if (Cursor_xntestbo!=null)
                  Cursor_xntestbo.Close();
                Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xntestbo.Eof())) {
                  /* cProg3 := LibreriaMit.UniqueId() */
                  cProg3 = LibreriaMit.UniqueId();
                  /* nProgImp := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                  /* _contarow := _contarow + 1 */
                  _contarow = CPLib.Round(_contarow+1,0);
                  // * --- Insert into intestbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"0000004A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000004A(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cProg3,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_contarow,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetDate("DATAFINE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetDate("DATARETT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetDouble("ABBINATO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
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
                    throw new RoutineException();
                  }
                  // * --- Delete from xntestbo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xntestbo");
                  m_cPhName = m_Ctx.GetPhName("xntestbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"0000004B")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("RAPPORTO"))+"";
                  m_cSql = m_cSql+" and NUMPROG1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("NUMPROG"))+"";
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
                  Cursor_xntestbo.Next();
                }
                m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
                Cursor_xntestbo.Close();
                // * --- End Select
                // * --- Select from xoginfo
                m_cServer = m_Ctx.GetServer("xoginfo");
                m_cPhName = m_Ctx.GetPhName("xoginfo");
                if (Cursor_xoginfo!=null)
                  Cursor_xoginfo.Close();
                Cursor_xoginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xapopebo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xoginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xoginfo.Eof())) {
                  // * --- Insert into soginfo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("soginfo");
                  m_cPhName = m_Ctx.GetPhName("soginfo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"soginfo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"0000004D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000004D(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xoginfo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xoginfo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xoginfo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xoginfo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xoginfo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xoginfo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xoginfo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xoginfo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"soginfo",true);
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
                  // * --- Delete from xoginfo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xoginfo");
                  m_cPhName = m_Ctx.GetPhName("xoginfo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xoginfo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"0000004E")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xoginfo.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xoginfo.GetString("IDFILEBO"))+"";
                  m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xoginfo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_xoginfo.GetDouble("CPROWNUM"))+"";
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
                  Cursor_xoginfo.Next();
                }
                m_cConnectivityError = Cursor_xoginfo.ErrorMessage();
                Cursor_xoginfo.Close();
                // * --- End Select
                // * --- Select from xiduciabo
                m_cServer = m_Ctx.GetServer("xiduciabo");
                m_cPhName = m_Ctx.GetPhName("xiduciabo");
                if (Cursor_xiduciabo!=null)
                  Cursor_xiduciabo.Close();
                Cursor_xiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xiduciabo.Eof())) {
                  // * --- Insert into fiduciabo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("fiduciabo");
                  m_cPhName = m_Ctx.GetPhName("fiduciabo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fiduciabo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"00000050")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000050(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fiduciabo",true);
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
                  // * --- Delete from xiduciabo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xiduciabo");
                  m_cPhName = m_Ctx.GetPhName("xiduciabo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xiduciabo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"00000051")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xiduciabo.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xiduciabo.GetString("IDFILEBO"))+"";
                  m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xiduciabo.GetString("CODSOG"))+"";
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
                  Cursor_xiduciabo.Next();
                }
                m_cConnectivityError = Cursor_xiduciabo.ErrorMessage();
                Cursor_xiduciabo.Close();
                // * --- End Select
              } // End Case
              /* Exec Routine arrt_ae_agg_aetesta(xapopebo->RAPPORTO,xapopebo->TIPOOPRAP,cProg2,xapopebo->DATAOPE,iif(Right(xapopebo->TIPOOPRAP,1)='6','S','N')) */
              arrt_ae_agg_aetestaR.Make(m_Ctx,this).Run(Cursor_xapopebo.GetString("RAPPORTO"),Cursor_xapopebo.GetString("TIPOOPRAP"),cProg2,Cursor_xapopebo.GetDate("DATAOPE"),(CPLib.eqr(CPLib.Right(Cursor_xapopebo.GetString("TIPOOPRAP"),1),"6")?"S":"N"));
              // * --- Delete from xapopebo
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xapopebo");
              m_cPhName = m_Ctx.GetPhName("xapopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"00000053")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("IDBASE"))+"";
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
            } // End If
            Cursor_xapopebo.Next();
          }
          m_cConnectivityError = Cursor_xapopebo.ErrorMessage();
          Cursor_xapopebo.Close();
          // * --- End Select
          Cursor_qbe_trasfrrap2.Next();
        }
        m_cConnectivityError = Cursor_qbe_trasfrrap2.ErrorMessage();
        Cursor_qbe_trasfrrap2.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + "Sono stati trasferiti "+LRTrim(Str(_crap,10,0))+" rapporti" + NL // Messaggio */
        gMsgProc = gMsgProc+"Sono stati trasferiti "+CPLib.LRTrim(CPLib.Str(_crap,10,0))+" rapporti"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        for (MemoryCursorRow_xnarapbo rowRapporto : mcRapporti._iterable_()) {
          // * --- Delete from xnarapbo
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xnarapbo");
          m_cPhName = m_Ctx.GetPhName("xnarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xnarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasfrap",104,"00000056")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowRapporto.RAPPORTO,"?",0,0,m_cServer),m_cServer,rowRapporto.RAPPORTO)+"";
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
        }
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc + "Sono state trasferite "+LRTrim(Str(_cinf,10,0))+" informazioni" + NL // Messaggio */
        gMsgProc = gMsgProc+"Sono state trasferite "+CPLib.LRTrim(CPLib.Str(_cinf,10,0))+" informazioni"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine Trasferimento: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Trasferimento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Elaborazione terminata con successo !' // Messaggio Import */
        gMsgImp = "Elaborazione terminata con successo !";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* gMsgProc := gMsgProc + 'Errore sul rapporto: ' + _rapporto + " -  Numero Informazione: "+_numprog+ NL */
        gMsgProc = gMsgProc+"Errore sul rapporto: "+_rapporto+" -  Numero Informazione: "+_numprog+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
        gMsgProc = gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Elaborazione scartata per errori !' // Messaggio Import */
        gMsgImp = "Elaborazione scartata per errori !";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000017status,0)) {
          m_Sql.SetTransactionStatus(nTry00000017status,cTry00000017msg);
        }
      }
    } finally {
      try {
        if (Cursor_xnarapbo!=null)
          Cursor_xnarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasfrrap2!=null)
          Cursor_qbe_trasfrrap2.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xapopebo!=null)
          Cursor_xapopebo.Close();
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
        if (Cursor_xelegabo!=null)
          Cursor_xelegabo.Close();
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
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xoginfo!=null)
          Cursor_xoginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xiduciabo!=null)
          Cursor_xiduciabo.Close();
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
  public String Run() {
    String l_result;
    l_result = "";
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
        l_result = stop_value.GetString();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = "";
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
    return l_result;
  }
  public static arrt_trasfrapR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_trasfrapR(p_Ctx, p_Caller);
  }
  public static arrt_trasfrapR Make(CPContext p_Ctx) {
    return new arrt_trasfrapR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    cProg1 = CPLib.Space(10);
    cProg2 = CPLib.Space(11);
    cProg3 = CPLib.Space(10);
    cIDB2 = CPLib.Space(10);
    w_RAPPORTO = CPLib.Space(25);
    nProgImp = 0;
    _crap = 0;
    _cinf = 0;
    _datareg = CPLib.NullDate();
    mcRapporti = new MemoryCursor_xnarapbo();
    _contarow = 0;
    _rapporto = CPLib.Space(25);
    _numprog = CPLib.Space(11);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_trasfrrap2,
  public static final String m_cVQRList = ",qbe_trasfrrap2,";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_ae_agg_aetesta,arrt_trasfrap,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_ae_agg_aetesta,arrt_trasfrap,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000023(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"CONTINUA,";
    p_cSql = p_cSql+"DATAMOD,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDRAPPORTO,";
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
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"TIPMOD,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"IMPAPE,";
    p_cSql = p_cSql+"IMPCHIU,";
    p_cSql = p_cSql+"SPLITCODE,";
    p_cSql = p_cSql+"MACODICE,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"CODICELR,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DAC6,";
    p_cSql = p_cSql+"FLAGDAC6,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"CODOGG,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"DATAPROF,";
    p_cSql = p_cSql+"DATAREVPROF,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000027(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"PROGAET,";
    p_cSql = p_cSql+"RIFANA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aetesta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000034(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
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
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERATORE,";
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
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"NOAGE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"delegabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000004A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"CODINTER,";
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000004D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"soginfo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000050(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fiduciabo",true);
    return p_cSql;
  }
}
