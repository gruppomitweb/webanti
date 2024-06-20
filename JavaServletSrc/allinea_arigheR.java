// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class allinea_arigheR implements CallerWithObjs {
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
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
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
  public double _riga;
  public String _descdel;
  public String _cauana;
  public String _tipope;
  public String _idb;
  public String _conta;
  public String cInfProg1;
  public String cInfProg2;
  public double nProgImp;
  public String _codinter;
  public String _citinter;
  public String _cabinter;
  public String _prvinter;
  public String _tipinter;
  public String _idb2;
  public String gAzienda;
  public String _idreg;
  public String w_OPERAZMOD;
  public String w_IDBASE2;
  public String w_IDEREG;
  public String cNewProg;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public allinea_arigheR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("allinea_arighe",m_Caller);
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
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
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    if (m_cPhName_aeopcanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopcanc = m_cPhName_aeopcanc+" "+m_Ctx.GetWritePhName("aeopcanc");
    }
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "allinea_arighe";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_descdel",p_cVarName)) {
      return _descdel;
    }
    if (CPLib.eqr("_cauana",p_cVarName)) {
      return _cauana;
    }
    if (CPLib.eqr("_tipope",p_cVarName)) {
      return _tipope;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      return _idb;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("cInfProg1",p_cVarName)) {
      return cInfProg1;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      return cInfProg2;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      return _codinter;
    }
    if (CPLib.eqr("_citinter",p_cVarName)) {
      return _citinter;
    }
    if (CPLib.eqr("_cabinter",p_cVarName)) {
      return _cabinter;
    }
    if (CPLib.eqr("_prvinter",p_cVarName)) {
      return _prvinter;
    }
    if (CPLib.eqr("_tipinter",p_cVarName)) {
      return _tipinter;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      return _idb2;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      return _idreg;
    }
    if (CPLib.eqr("OPERAZMOD",p_cVarName)) {
      return w_OPERAZMOD;
    }
    if (CPLib.eqr("IDBASE2",p_cVarName)) {
      return w_IDBASE2;
    }
    if (CPLib.eqr("IDEREG",p_cVarName)) {
      return w_IDEREG;
    }
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      return cNewProg;
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
    if (CPLib.eqr("_riga",p_cVarName)) {
      _riga = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_descdel",p_cVarName)) {
      _descdel = value;
      return;
    }
    if (CPLib.eqr("_cauana",p_cVarName)) {
      _cauana = value;
      return;
    }
    if (CPLib.eqr("_tipope",p_cVarName)) {
      _tipope = value;
      return;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      _idb = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("cInfProg1",p_cVarName)) {
      cInfProg1 = value;
      return;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      cInfProg2 = value;
      return;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      _codinter = value;
      return;
    }
    if (CPLib.eqr("_citinter",p_cVarName)) {
      _citinter = value;
      return;
    }
    if (CPLib.eqr("_cabinter",p_cVarName)) {
      _cabinter = value;
      return;
    }
    if (CPLib.eqr("_prvinter",p_cVarName)) {
      _prvinter = value;
      return;
    }
    if (CPLib.eqr("_tipinter",p_cVarName)) {
      _tipinter = value;
      return;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      _idb2 = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      _idreg = value;
      return;
    }
    if (CPLib.eqr("OPERAZMOD",p_cVarName)) {
      w_OPERAZMOD = value;
      return;
    }
    if (CPLib.eqr("IDBASE2",p_cVarName)) {
      w_IDBASE2 = value;
      return;
    }
    if (CPLib.eqr("IDEREG",p_cVarName)) {
      w_IDEREG = value;
      return;
    }
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      cNewProg = value;
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
    CPResultSet Cursor_wuibi=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_wuibt=null;
    CPResultSet Cursor_rapotit=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _riga Numeric(3, 0) */
      /* _descdel Char(70) */
      /* _cauana Char(4) */
      /* _tipope Char(2) */
      /* _idb Char(2) */
      /* _conta Char(10) */
      /* cInfProg1 Char(10) */
      /* cInfProg2 Char(11) */
      /* nProgImp Numeric(15, 0) */
      /* _codinter Char(11) */
      /* _citinter Char(30) */
      /* _cabinter Char(6) */
      /* _prvinter Char(2) */
      /* _tipinter Char(2) */
      /* _idb2 Char(10) */
      /* gAzienda Char(10) // Azienda */
      /* _idreg Char(20) */
      /* w_OPERAZMOD Char(20) // Operazione Modificata */
      /* w_IDBASE2 Char(10) // Idbase */
      /* w_IDEREG Char(20) // Idbase */
      /* cNewProg Char(10) */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000018status;
      nTry00000018status = m_Sql.GetTransactionStatus();
      String cTry00000018msg;
      cTry00000018msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from wuibi
        if (Cursor_wuibi!=null)
          Cursor_wuibi.Close();
        Cursor_wuibi = new VQRHolder("wuibi",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_wuibi.Eof())) {
          // * --- Select from rapopebo
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          if (Cursor_rapopebo!=null)
            Cursor_rapopebo.Close();
          Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_wuibi.GetString("NUMPROG"),"?",0,0)+"  and  STATOREG='1' "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rapopebo.Eof())) {
            /* If Empty(rapopebo->DATARETT) */
            if (CPLib.Empty(Cursor_rapopebo.GetDate("DATARETT"))) {
              /* cNewProg := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
              cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
              /* w_OPERAZMOD := rapopebo->IDEREG // Operazione Modificata */
              w_OPERAZMOD = Cursor_rapopebo.GetString("IDEREG");
              /* w_IDBASE2 := LibreriaMit.UniqueId() // Idbase */
              w_IDBASE2 = LibreriaMit.UniqueId();
              /* w_IDEREG := 'I'+Right(rapopebo->NUMPROG,9)+w_IDBASE2 // Idbase */
              w_IDEREG = "I"+CPLib.Right(Cursor_rapopebo.GetString("NUMPROG"),9)+w_IDBASE2;
              // * --- Insert into rapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("allinea_arighe",26,"00000020")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000020(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAAGE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_IDBASE2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_IDEREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_OPERAZMOD,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("PRGIMPINF"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
              // * --- Write into rapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("allinea_arighe",26,"00000021")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapopebo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_rapopebo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_rapopebo.GetString("IDBASE"))+"";
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
            Cursor_rapopebo.Next();
          }
          m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
          Cursor_rapopebo.Close();
          // * --- End Select
          Cursor_wuibi.Next();
        }
        m_cConnectivityError = Cursor_wuibi.ErrorMessage();
        Cursor_wuibi.Close();
        // * --- End Select
        // * --- Select from wuibt
        if (Cursor_wuibt!=null)
          Cursor_wuibt.Close();
        Cursor_wuibt = new VQRHolder("wuibt",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_wuibt.Eof())) {
          // * --- Select from rapotit
          m_cServer = m_Ctx.GetServer("rapotit");
          m_cPhName = m_Ctx.GetPhName("rapotit");
          if (Cursor_rapotit!=null)
            Cursor_rapotit.Close();
          Cursor_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_wuibt.GetString("NUMPROG"),"?",0,0)+"  and  STATOREG='1' "+")"+(m_Ctx.IsSharedTemp("rapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rapotit.Eof())) {
            /* If Empty(rapotit->DATARETT) */
            if (CPLib.Empty(Cursor_rapotit.GetDate("DATARETT"))) {
              /* w_OPERAZMOD := rapotit->IDEREG // Operazione Modificata */
              w_OPERAZMOD = Cursor_rapotit.GetString("IDEREG");
              /* w_IDBASE2 := LibreriaMit.UniqueId() // Idbase */
              w_IDBASE2 = LibreriaMit.UniqueId();
              /* w_IDEREG := 'T'+Right(rapotit->NUMPROG,9)+w_IDBASE2 */
              w_IDEREG = "T"+CPLib.Right(Cursor_rapotit.GetString("NUMPROG"),9)+w_IDBASE2;
              /* cNewProg := Utilities.GetAutonumber("PRGTITO1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
              cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
              // * --- Insert into rapotit from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapotit");
              m_cPhName = m_Ctx.GetPhName("rapotit");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("allinea_arighe",26,"00000029")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000029(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDate("DATAAGE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_IDEREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_OPERAZMOD,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("PRGIMPTIT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
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
                throw new RoutineException();
              }
              // * --- Write into rapotit from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapotit");
              m_cPhName = m_Ctx.GetPhName("rapotit");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("allinea_arighe",26,"0000002A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapotit",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_rapotit.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_rapotit.GetString("IDBASE"))+"";
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
            Cursor_rapotit.Next();
          }
          m_cConnectivityError = Cursor_rapotit.ErrorMessage();
          Cursor_rapotit.Close();
          // * --- End Select
          Cursor_wuibt.Next();
        }
        m_cConnectivityError = Cursor_wuibt.ErrorMessage();
        Cursor_wuibt.Close();
        // * --- End Select
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000018status,0)) {
          m_Sql.SetTransactionStatus(nTry00000018status,cTry00000018msg);
        }
      }
    } finally {
      try {
        if (Cursor_wuibi!=null)
          Cursor_wuibi.Close();
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
        if (Cursor_wuibt!=null)
          Cursor_wuibt.Close();
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
  public static allinea_arigheR Make(CPContext p_Ctx, Caller p_Caller) {
    return new allinea_arigheR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _riga = 0;
    _descdel = CPLib.Space(70);
    _cauana = CPLib.Space(4);
    _tipope = CPLib.Space(2);
    _idb = CPLib.Space(2);
    _conta = CPLib.Space(10);
    cInfProg1 = CPLib.Space(10);
    cInfProg2 = CPLib.Space(11);
    nProgImp = 0;
    _codinter = CPLib.Space(11);
    _citinter = CPLib.Space(30);
    _cabinter = CPLib.Space(6);
    _prvinter = CPLib.Space(2);
    _tipinter = CPLib.Space(2);
    _idb2 = CPLib.Space(10);
    _idreg = CPLib.Space(20);
    w_OPERAZMOD = CPLib.Space(20);
    w_IDBASE2 = CPLib.Space(10);
    w_IDEREG = CPLib.Space(20);
    cNewProg = CPLib.Space(10);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,wuibi,wuibt,
  public static final String m_cVQRList = ",wuibi,wuibt,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000020(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000029(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapotit",true);
    return p_cSql;
  }
}
