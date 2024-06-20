// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_update_poR implements CallerWithObjs {
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
  public String m_cPhName_cgo_operazioni_storico;
  public String m_cServer_cgo_operazioni_storico;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_operazbo_agg;
  public String m_cServer_operazbo_agg;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xperazbo_agg;
  public String m_cServer_xperazbo_agg;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_cgo_tipdoc;
  public String m_cServer_cgo_tipdoc;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
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
  public String w_SNAINUMOPE;
  public String _idb;
  public String _tipint;
  public String _PAESE;
  public String _DESCCIT;
  public String _RAGSOC;
  public String _PROVINCIA;
  public String _CODCAB;
  public String _ragcli;
  public String _domcli;
  public String _citcli;
  public String _prvcli;
  public String _stacli;
  public String _capcli;
  public String _cabcli;
  public double _totlire;
  public double _totcont;
  public double _modifica;
  public String _idb2;
  public String cNewProg;
  public String stringaflagrap2;
  public String _flagrap2;
  public String _tipinter;
  public String _codinter;
  public String _citinter;
  public String _cabinter;
  public String _prvinter;
  public double _limoper;
  public String _connesben;
  public String gAzienda;
  public String xFLGSAE;
  public String cInfProg1;
  public String cInfProg2;
  public double nProgImp;
  public String cColleg;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_update_poR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_update_po",m_Caller);
    m_cPhName_cgo_operazioni_storico = p_ContextObject.GetPhName("cgo_operazioni_storico");
    if (m_cPhName_cgo_operazioni_storico.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_storico = m_cPhName_cgo_operazioni_storico+" "+m_Ctx.GetWritePhName("cgo_operazioni_storico");
    }
    m_cServer_cgo_operazioni_storico = p_ContextObject.GetServer("cgo_operazioni_storico");
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    if (m_cPhName_inter2bo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_inter2bo = m_cPhName_inter2bo+" "+m_Ctx.GetWritePhName("inter2bo");
    }
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_operazbo_agg = p_ContextObject.GetPhName("operazbo_agg");
    if (m_cPhName_operazbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo_agg = m_cPhName_operazbo_agg+" "+m_Ctx.GetWritePhName("operazbo_agg");
    }
    m_cServer_operazbo_agg = p_ContextObject.GetServer("operazbo_agg");
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
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xperazbo_agg = p_ContextObject.GetPhName("xperazbo_agg");
    if (m_cPhName_xperazbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo_agg = m_cPhName_xperazbo_agg+" "+m_Ctx.GetWritePhName("xperazbo_agg");
    }
    m_cServer_xperazbo_agg = p_ContextObject.GetServer("xperazbo_agg");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_cgo_tipdoc = p_ContextObject.GetPhName("cgo_tipdoc");
    if (m_cPhName_cgo_tipdoc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_tipdoc = m_cPhName_cgo_tipdoc+" "+m_Ctx.GetWritePhName("cgo_tipdoc");
    }
    m_cServer_cgo_tipdoc = p_ContextObject.GetServer("cgo_tipdoc");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_totlire",p_cVarName)) {
      return _totlire;
    }
    if (CPLib.eqr("_totcont",p_cVarName)) {
      return _totcont;
    }
    if (CPLib.eqr("_modifica",p_cVarName)) {
      return _modifica;
    }
    if (CPLib.eqr("_limoper",p_cVarName)) {
      return _limoper;
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
      return "arrt_cgo_update_po";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("SNAINUMOPE",p_cVarName)) {
      return w_SNAINUMOPE;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      return _idb;
    }
    if (CPLib.eqr("_tipint",p_cVarName)) {
      return _tipint;
    }
    if (CPLib.eqr("_PAESE",p_cVarName)) {
      return _PAESE;
    }
    if (CPLib.eqr("_DESCCIT",p_cVarName)) {
      return _DESCCIT;
    }
    if (CPLib.eqr("_RAGSOC",p_cVarName)) {
      return _RAGSOC;
    }
    if (CPLib.eqr("_PROVINCIA",p_cVarName)) {
      return _PROVINCIA;
    }
    if (CPLib.eqr("_CODCAB",p_cVarName)) {
      return _CODCAB;
    }
    if (CPLib.eqr("_ragcli",p_cVarName)) {
      return _ragcli;
    }
    if (CPLib.eqr("_domcli",p_cVarName)) {
      return _domcli;
    }
    if (CPLib.eqr("_citcli",p_cVarName)) {
      return _citcli;
    }
    if (CPLib.eqr("_prvcli",p_cVarName)) {
      return _prvcli;
    }
    if (CPLib.eqr("_stacli",p_cVarName)) {
      return _stacli;
    }
    if (CPLib.eqr("_capcli",p_cVarName)) {
      return _capcli;
    }
    if (CPLib.eqr("_cabcli",p_cVarName)) {
      return _cabcli;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      return _idb2;
    }
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      return cNewProg;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      return stringaflagrap2;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      return _flagrap2;
    }
    if (CPLib.eqr("_tipinter",p_cVarName)) {
      return _tipinter;
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
    if (CPLib.eqr("_connesben",p_cVarName)) {
      return _connesben;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("xFLGSAE",p_cVarName)) {
      return xFLGSAE;
    }
    if (CPLib.eqr("cInfProg1",p_cVarName)) {
      return cInfProg1;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      return cInfProg2;
    }
    if (CPLib.eqr("cColleg",p_cVarName)) {
      return cColleg;
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
    if (CPLib.eqr("_totlire",p_cVarName)) {
      _totlire = value;
      return;
    }
    if (CPLib.eqr("_totcont",p_cVarName)) {
      _totcont = value;
      return;
    }
    if (CPLib.eqr("_modifica",p_cVarName)) {
      _modifica = value;
      return;
    }
    if (CPLib.eqr("_limoper",p_cVarName)) {
      _limoper = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("SNAINUMOPE",p_cVarName)) {
      w_SNAINUMOPE = value;
      return;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      _idb = value;
      return;
    }
    if (CPLib.eqr("_tipint",p_cVarName)) {
      _tipint = value;
      return;
    }
    if (CPLib.eqr("_PAESE",p_cVarName)) {
      _PAESE = value;
      return;
    }
    if (CPLib.eqr("_DESCCIT",p_cVarName)) {
      _DESCCIT = value;
      return;
    }
    if (CPLib.eqr("_RAGSOC",p_cVarName)) {
      _RAGSOC = value;
      return;
    }
    if (CPLib.eqr("_PROVINCIA",p_cVarName)) {
      _PROVINCIA = value;
      return;
    }
    if (CPLib.eqr("_CODCAB",p_cVarName)) {
      _CODCAB = value;
      return;
    }
    if (CPLib.eqr("_ragcli",p_cVarName)) {
      _ragcli = value;
      return;
    }
    if (CPLib.eqr("_domcli",p_cVarName)) {
      _domcli = value;
      return;
    }
    if (CPLib.eqr("_citcli",p_cVarName)) {
      _citcli = value;
      return;
    }
    if (CPLib.eqr("_prvcli",p_cVarName)) {
      _prvcli = value;
      return;
    }
    if (CPLib.eqr("_stacli",p_cVarName)) {
      _stacli = value;
      return;
    }
    if (CPLib.eqr("_capcli",p_cVarName)) {
      _capcli = value;
      return;
    }
    if (CPLib.eqr("_cabcli",p_cVarName)) {
      _cabcli = value;
      return;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      _idb2 = value;
      return;
    }
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      cNewProg = value;
      return;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      stringaflagrap2 = value;
      return;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      _flagrap2 = value;
      return;
    }
    if (CPLib.eqr("_tipinter",p_cVarName)) {
      _tipinter = value;
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
    if (CPLib.eqr("_connesben",p_cVarName)) {
      _connesben = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("xFLGSAE",p_cVarName)) {
      xFLGSAE = value;
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
    if (CPLib.eqr("cColleg",p_cVarName)) {
      cColleg = value;
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_cgo_operazioni_storico=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_xperazbo=null;
    CPResultSet Cursor_operazbo=null;
    try {
      /* w_SNAINUMOPE Char(15) // N. Operazione */
      /* _idb Char(10) */
      /* abicab Char(11) */
      String abicab;
      abicab = CPLib.Space(11);
      /* _tipint Char(2) */
      /* _PAESE Char(3) */
      /* _DESCCIT Char(70) */
      /* _RAGSOC Char(70) */
      /* _PROVINCIA Char(2) */
      /* _CODCAB Char(6) */
      /* _ragcli Char(70) */
      /* _domcli Char(35) */
      /* _citcli Char(30) */
      /* _prvcli Char(2) */
      /* _stacli Char(3) */
      /* _capcli Char(9) */
      /* _cabcli Char(6) */
      /* _totlire Numeric(15, 0) */
      /* _totcont Numeric(15, 0) */
      /* _modifica Numeric(1, 0) */
      /* _idb2 Char(10) */
      /* cNewProg Char(10) */
      /* stringaflagrap2 Char(10) */
      /* _flagrap2 Char(1) */
      /* _tipinter Char(2) */
      /* _codinter Char(11) */
      /* _citinter Char(30) */
      /* _cabinter Char(6) */
      /* _prvinter Char(2) */
      /* _limoper Numeric(12, 2) */
      /* _connesben Char(16) */
      /* gAzienda Char(10) // Azienda */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000025status;
      nTry00000025status = m_Sql.GetTransactionStatus();
      String cTry00000025msg;
      cTry00000025msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* _tipinter := intermbo->TIPINTER */
          _tipinter = Cursor_intermbo.GetString("TIPINTER");
          /* _codinter := intermbo->CODINTER */
          _codinter = Cursor_intermbo.GetString("CODINTER");
          /* _citinter := intermbo->DESCCIT */
          _citinter = Cursor_intermbo.GetString("DESCCIT");
          /* _cabinter := intermbo->CODCAB */
          _cabinter = Cursor_intermbo.GetString("CODCAB");
          /* _prvinter := intermbo->PROVINCIA */
          _prvinter = Cursor_intermbo.GetString("PROVINCIA");
          /* _limoper := intermbo->IMPINTOPE */
          _limoper = CPLib.Round(Cursor_intermbo.GetDouble("IMPINTOPE"),2);
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* Exec "Dati Anagrafici" Page 2:Page_2 */
        Page_2();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        // * --- Select from cgo_operazioni_storico
        m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
        m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
        if (Cursor_cgo_operazioni_storico!=null)
          Cursor_cgo_operazioni_storico.Close();
        Cursor_cgo_operazioni_storico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,w_SNAINUMOPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_storico")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_operazioni_storico.Eof())) {
          /* _idb := '' */
          _idb = "";
          // * --- Read from operazbo_agg
          m_cServer = m_Ctx.GetServer("operazbo_agg");
          m_cPhName = m_Ctx.GetPhName("operazbo_agg");
          m_cSql = "";
          m_cSql = m_cSql+"IDBIGLIETTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CAIDBIGLIETTO"),"C",30,0,m_cServer),m_cServer,Cursor_cgo_operazioni_storico.GetString("CAIDBIGLIETTO"));
          if (m_Ctx.IsSharedTemp("operazbo_agg")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _idb = Read_Cursor.GetString("IDBASE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on operazbo_agg into routine arrt_cgo_update_po returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _idb = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(_idb) */
          if (CPLib.Empty(_idb)) {
            // * --- Read from xperazbo_agg
            m_cServer = m_Ctx.GetServer("xperazbo_agg");
            m_cPhName = m_Ctx.GetPhName("xperazbo_agg");
            m_cSql = "";
            m_cSql = m_cSql+"IDBIGLIETTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CAIDBIGLIETTO"),"C",30,0,m_cServer),m_cServer,Cursor_cgo_operazioni_storico.GetString("CAIDBIGLIETTO"));
            if (m_Ctx.IsSharedTemp("xperazbo_agg")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _idb = Read_Cursor.GetString("IDBASE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on xperazbo_agg into routine arrt_cgo_update_po returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _idb = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _modifica := 0 */
            _modifica = CPLib.Round(0,0);
            // * --- Select from xperazbo
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            if (Cursor_xperazbo!=null)
              Cursor_xperazbo.Close();
            Cursor_xperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TOTLIRE,TOTCONT,CODINT2  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idb,"?",0,0,m_cServer, m_oParameters),m_cServer,_idb)+" "+")"+(m_Ctx.IsSharedTemp("xperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xperazbo.Eof())) {
              /* If ((cgo_operazioni_storico->TOTLIRE * 100) <> xperazbo->TOTLIRE) or ((cgo_operazioni_storico->TOTCONT * 100) <> xperazbo->TOTCONT) */
              if ((CPLib.ne((Cursor_cgo_operazioni_storico.GetDouble("TOTLIRE")*100),Cursor_xperazbo.GetDouble("TOTLIRE"))) || (CPLib.ne((Cursor_cgo_operazioni_storico.GetDouble("TOTCONT")*100),Cursor_xperazbo.GetDouble("TOTCONT")))) {
                /* _modifica := 1 */
                _modifica = CPLib.Round(1,0);
                /* _totlire := (cgo_operazioni_storico->TOTLIRE * 100) */
                _totlire = CPLib.Round((Cursor_cgo_operazioni_storico.GetDouble("TOTLIRE")*100),0);
                /* _totcont := (cgo_operazioni_storico->TOTCONT * 100) */
                _totcont = CPLib.Round((Cursor_cgo_operazioni_storico.GetDouble("TOTCONT")*100),0);
              } else { // Else
                /* _totlire := xperazbo->TOTLIRE */
                _totlire = CPLib.Round(Cursor_xperazbo.GetDouble("TOTLIRE"),0);
                /* _totcont := xperazbo->TOTCONT */
                _totcont = CPLib.Round(Cursor_xperazbo.GetDouble("TOTCONT"),0);
              } // End If
              /* If Left(Upper(cgo_operazioni_storico->IBAN),2)='IT' */
              if (CPLib.eqr(CPLib.Left(CPLib.Upper(Cursor_cgo_operazioni_storico.GetString("IBAN")),2),"IT")) {
                /* abicab := Substr(cgo_operazioni_storico->IBAN,6,5)+"-"+Substr(cgo_operazioni_storico->IBAN,11,5) */
                abicab = CPLib.Substr(Cursor_cgo_operazioni_storico.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_operazioni_storico.GetString("IBAN"),11,5);
              } else { // Else
                /* abicab := Left(Upper(cgo_operazioni_storico->IBAN),11) */
                abicab = CPLib.Left(CPLib.Upper(Cursor_cgo_operazioni_storico.GetString("IBAN")),11);
              } // End If
              /* If (At(cgo_operazioni_storico->MEZPAGAM,'|I|E|P') > 0 and Empty(xperazbo->CODINT2)) or (not(Empty(xperazbo->CODINT2)) and At(cgo_operazioni_storico->MEZPAGAM,'|I|E|P') > 0 and xperazbo->CODINT2 <> abicab) or (not(Empty(xperazbo->CODINT2)) and At(cgo_operazioni_storico->MEZPAGAM,'|I|E|P') = 0) */
              if ((CPLib.gt(CPLib.At(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"|I|E|P"),0) && CPLib.Empty(Cursor_xperazbo.GetString("CODINT2"))) || ( ! (CPLib.Empty(Cursor_xperazbo.GetString("CODINT2"))) && CPLib.gt(CPLib.At(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"|I|E|P"),0) && CPLib.ne(Cursor_xperazbo.GetString("CODINT2"),abicab)) || ( ! (CPLib.Empty(Cursor_xperazbo.GetString("CODINT2"))) && CPLib.eqr(CPLib.At(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"|I|E|P"),0))) {
                /* _modifica := 1 */
                _modifica = CPLib.Round(1,0);
                /* If At(cgo_operazioni_storico->MEZPAGAM,'|I|E|P') > 0 */
                if (CPLib.gt(CPLib.At(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"|I|E|P"),0)) {
                  /* If Left(Upper(cgo_operazioni_storico->IBAN),2)='IT' */
                  if (CPLib.eqr(CPLib.Left(CPLib.Upper(Cursor_cgo_operazioni_storico.GetString("IBAN")),2),"IT")) {
                    /* _tipint := '' */
                    _tipint = "";
                    /* _PAESE := '' */
                    _PAESE = "";
                    /* _DESCCIT := '' */
                    _DESCCIT = "";
                    /* _RAGSOC := '' */
                    _RAGSOC = "";
                    /* _PROVINCIA := '' */
                    _PROVINCIA = "";
                    /* _CODCAB := '' */
                    _CODCAB = "";
                    // * --- Read from inter2bo
                    m_cServer = m_Ctx.GetServer("inter2bo");
                    m_cPhName = m_Ctx.GetPhName("inter2bo");
                    m_cSql = "";
                    m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(abicab,"C",11,0,m_cServer),m_cServer,abicab);
                    if (m_Ctx.IsSharedTemp("inter2bo")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPINTER",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PAESE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _tipint = Read_Cursor.GetString("TIPINTER");
                      _RAGSOC = Read_Cursor.GetString("RAGSOC");
                      _DESCCIT = Read_Cursor.GetString("DESCCIT");
                      _PAESE = Read_Cursor.GetString("PAESE");
                      _PROVINCIA = Read_Cursor.GetString("PROVINCIA");
                      _CODCAB = Read_Cursor.GetString("CODCAB");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on inter2bo into routine arrt_cgo_update_po returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _tipint = "";
                      _RAGSOC = "";
                      _DESCCIT = "";
                      _PAESE = "";
                      _PROVINCIA = "";
                      _CODCAB = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } else { // Else
                    /* _tipint := '12' */
                    _tipint = "12";
                  } // End If
                  /* _ragcli := '' */
                  _ragcli = "";
                  /* _domcli := '' */
                  _domcli = "";
                  /* _citcli := '' */
                  _citcli = "";
                  /* _prvcli := '' */
                  _prvcli = "";
                  /* _stacli := '' */
                  _stacli = "";
                  /* _capcli := '' */
                  _capcli = "";
                  /* _cabcli := '' */
                  _cabcli = "";
                  /* _connesben := cgo_operazioni_storico->CODFISC */
                  _connesben = Cursor_cgo_operazioni_storico.GetString("CODFISC");
                  // * --- Read from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CODFISC"),"C",16,0,m_cServer),m_cServer,Cursor_cgo_operazioni_storico.GetString("CODFISC"));
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DOMICILIO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PAESE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _ragcli = Read_Cursor.GetString("RAGSOC");
                    _domcli = Read_Cursor.GetString("DOMICILIO");
                    _citcli = Read_Cursor.GetString("DESCCIT");
                    _prvcli = Read_Cursor.GetString("PROVINCIA");
                    _stacli = Read_Cursor.GetString("PAESE");
                    _capcli = Read_Cursor.GetString("CAP");
                    _cabcli = Read_Cursor.GetString("CODCAB");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on personbo into routine arrt_cgo_update_po returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _ragcli = "";
                    _domcli = "";
                    _citcli = "";
                    _prvcli = "";
                    _stacli = "";
                    _capcli = "";
                    _cabcli = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } else { // Else
                  /* _tipint := '' */
                  _tipint = "";
                  /* _PAESE := '' */
                  _PAESE = "";
                  /* _DESCCIT := '' */
                  _DESCCIT = "";
                  /* _RAGSOC := '' */
                  _RAGSOC = "";
                  /* _PROVINCIA := '' */
                  _PROVINCIA = "";
                  /* _CODCAB := '' */
                  _CODCAB = "";
                  /* _ragcli := '' */
                  _ragcli = "";
                  /* _domcli := '' */
                  _domcli = "";
                  /* _citcli := '' */
                  _citcli = "";
                  /* _prvcli := '' */
                  _prvcli = "";
                  /* _stacli := '' */
                  _stacli = "";
                  /* _capcli := '' */
                  _capcli = "";
                  /* _cabcli := '' */
                  _cabcli = "";
                  /* _connesben := '' */
                  _connesben = "";
                } // End If
              } // End If
              Cursor_xperazbo.Next();
            }
            m_cConnectivityError = Cursor_xperazbo.ErrorMessage();
            Cursor_xperazbo.Close();
            // * --- End Select
            /* If _modifica=1 */
            if (CPLib.eqr(_modifica,1)) {
              // * --- Write into xperazbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xperazbo");
              m_cPhName = m_Ctx.GetPhName("xperazbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_update_po",27,"00000063")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(_tipint,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(_ragcli,"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(_stacli,"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(_citcli,"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(_cabcli,"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(_prvcli,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(_domcli,"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(_capcli,"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(_connesben,"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"TOTLIRE = "+CPLib.ToSQL(_totlire,"N",15,0)+", ";
              m_cSql = m_cSql+"TOTCONT = "+CPLib.ToSQL(_totcont,"N",15,0)+", ";
              m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_idb,"?",0,0,m_cServer),m_cServer,_idb)+"";
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
              /* Exec Routine arrt_writelog('SAVE','XPERAZBO',w_SNAINUMOPE,"Sto elaborando l'operazione con codice:"+w_SNAINUMOPE,'I') */
              arrt_writelogR.Make(m_Ctx,this).Run("SAVE","XPERAZBO",w_SNAINUMOPE,"Sto elaborando l'operazione con codice:"+w_SNAINUMOPE,"I");
            } // End If
          } else { // Else
            // * --- Select from operazbo
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            if (Cursor_operazbo!=null)
              Cursor_operazbo.Close();
            Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TOTLIRE,TOTCONT,CODINT2  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idb,"?",0,0,m_cServer, m_oParameters),m_cServer,_idb)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_operazbo.Eof())) {
              /* If ((cgo_operazioni_storico->TOTLIRE * 100) <> operazbo->TOTLIRE) or ((cgo_operazioni_storico->TOTCONT * 100) <> operazbo->TOTCONT) */
              if ((CPLib.ne((Cursor_cgo_operazioni_storico.GetDouble("TOTLIRE")*100),Cursor_operazbo.GetDouble("TOTLIRE"))) || (CPLib.ne((Cursor_cgo_operazioni_storico.GetDouble("TOTCONT")*100),Cursor_operazbo.GetDouble("TOTCONT")))) {
                /* _modifica := 1 */
                _modifica = CPLib.Round(1,0);
                /* _totlire := (cgo_operazioni_storico->TOTLIRE * 100) */
                _totlire = CPLib.Round((Cursor_cgo_operazioni_storico.GetDouble("TOTLIRE")*100),0);
                /* _totcont := (cgo_operazioni_storico->TOTCONT * 100) */
                _totcont = CPLib.Round((Cursor_cgo_operazioni_storico.GetDouble("TOTCONT")*100),0);
              } else { // Else
                /* _totlire := operazbo->TOTLIRE */
                _totlire = CPLib.Round(Cursor_operazbo.GetDouble("TOTLIRE"),0);
                /* _totcont := operazbo->TOTCONT */
                _totcont = CPLib.Round(Cursor_operazbo.GetDouble("TOTCONT"),0);
              } // End If
              /* If Left(Upper(cgo_operazioni_storico->IBAN),2)='IT' */
              if (CPLib.eqr(CPLib.Left(CPLib.Upper(Cursor_cgo_operazioni_storico.GetString("IBAN")),2),"IT")) {
                /* abicab := Substr(cgo_operazioni_storico->IBAN,6,5)+"-"+Substr(cgo_operazioni_storico->IBAN,11,5) */
                abicab = CPLib.Substr(Cursor_cgo_operazioni_storico.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_operazioni_storico.GetString("IBAN"),11,5);
              } else { // Else
                /* abicab := Left(Upper(cgo_operazioni_storico->IBAN),11) */
                abicab = CPLib.Left(CPLib.Upper(Cursor_cgo_operazioni_storico.GetString("IBAN")),11);
              } // End If
              /* If (At(cgo_operazioni_storico->MEZPAGAM,'|I|E|P') > 0 and Empty(operazbo->CODINT2)) or (not(Empty(operazbo->CODINT2)) and At(cgo_operazioni_storico->MEZPAGAM,'|I|E|P') > 0 and operazbo->CODINT2 <> abicab) or (not(Empty(operazbo->CODINT2)) and At(cgo_operazioni_storico->MEZPAGAM,'|I|E|P') = 0) */
              if ((CPLib.gt(CPLib.At(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"|I|E|P"),0) && CPLib.Empty(Cursor_operazbo.GetString("CODINT2"))) || ( ! (CPLib.Empty(Cursor_operazbo.GetString("CODINT2"))) && CPLib.gt(CPLib.At(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"|I|E|P"),0) && CPLib.ne(Cursor_operazbo.GetString("CODINT2"),abicab)) || ( ! (CPLib.Empty(Cursor_operazbo.GetString("CODINT2"))) && CPLib.eqr(CPLib.At(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"|I|E|P"),0))) {
                /* _modifica := 1 */
                _modifica = CPLib.Round(1,0);
                /* If At(cgo_operazioni_storico->MEZPAGAM,'|I|E|P') > 0 */
                if (CPLib.gt(CPLib.At(Cursor_cgo_operazioni_storico.GetString("MEZPAGAM"),"|I|E|P"),0)) {
                  /* If Left(Upper(cgo_operazioni_storico->IBAN),2)='IT' */
                  if (CPLib.eqr(CPLib.Left(CPLib.Upper(Cursor_cgo_operazioni_storico.GetString("IBAN")),2),"IT")) {
                    /* _tipint := '' */
                    _tipint = "";
                    /* _PAESE := '' */
                    _PAESE = "";
                    /* _DESCCIT := '' */
                    _DESCCIT = "";
                    /* _RAGSOC := '' */
                    _RAGSOC = "";
                    /* _PROVINCIA := '' */
                    _PROVINCIA = "";
                    /* _CODCAB := '' */
                    _CODCAB = "";
                    // * --- Read from inter2bo
                    m_cServer = m_Ctx.GetServer("inter2bo");
                    m_cPhName = m_Ctx.GetPhName("inter2bo");
                    m_cSql = "";
                    m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(abicab,"C",11,0,m_cServer),m_cServer,abicab);
                    if (m_Ctx.IsSharedTemp("inter2bo")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPINTER",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PAESE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _tipint = Read_Cursor.GetString("TIPINTER");
                      _RAGSOC = Read_Cursor.GetString("RAGSOC");
                      _DESCCIT = Read_Cursor.GetString("DESCCIT");
                      _PAESE = Read_Cursor.GetString("PAESE");
                      _PROVINCIA = Read_Cursor.GetString("PROVINCIA");
                      _CODCAB = Read_Cursor.GetString("CODCAB");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on inter2bo into routine arrt_cgo_update_po returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _tipint = "";
                      _RAGSOC = "";
                      _DESCCIT = "";
                      _PAESE = "";
                      _PROVINCIA = "";
                      _CODCAB = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } else { // Else
                    /* _tipint := '12' */
                    _tipint = "12";
                  } // End If
                  /* _ragcli := '' */
                  _ragcli = "";
                  /* _domcli := '' */
                  _domcli = "";
                  /* _citcli := '' */
                  _citcli = "";
                  /* _prvcli := '' */
                  _prvcli = "";
                  /* _stacli := '' */
                  _stacli = "";
                  /* _capcli := '' */
                  _capcli = "";
                  /* _cabcli := '' */
                  _cabcli = "";
                  /* _connesben := cgo_operazioni_storico->CODFISC */
                  _connesben = Cursor_cgo_operazioni_storico.GetString("CODFISC");
                  // * --- Read from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CODFISC"),"C",16,0,m_cServer),m_cServer,Cursor_cgo_operazioni_storico.GetString("CODFISC"));
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DOMICILIO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PAESE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _ragcli = Read_Cursor.GetString("RAGSOC");
                    _domcli = Read_Cursor.GetString("DOMICILIO");
                    _citcli = Read_Cursor.GetString("DESCCIT");
                    _prvcli = Read_Cursor.GetString("PROVINCIA");
                    _stacli = Read_Cursor.GetString("PAESE");
                    _capcli = Read_Cursor.GetString("CAP");
                    _cabcli = Read_Cursor.GetString("CODCAB");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on personbo into routine arrt_cgo_update_po returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _ragcli = "";
                    _domcli = "";
                    _citcli = "";
                    _prvcli = "";
                    _stacli = "";
                    _capcli = "";
                    _cabcli = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } else { // Else
                  /* _tipint := '' */
                  _tipint = "";
                  /* _PAESE := '' */
                  _PAESE = "";
                  /* _DESCCIT := '' */
                  _DESCCIT = "";
                  /* _RAGSOC := '' */
                  _RAGSOC = "";
                  /* _PROVINCIA := '' */
                  _PROVINCIA = "";
                  /* _CODCAB := '' */
                  _CODCAB = "";
                  /* _ragcli := '' */
                  _ragcli = "";
                  /* _domcli := '' */
                  _domcli = "";
                  /* _citcli := '' */
                  _citcli = "";
                  /* _prvcli := '' */
                  _prvcli = "";
                  /* _stacli := '' */
                  _stacli = "";
                  /* _capcli := '' */
                  _capcli = "";
                  /* _cabcli := '' */
                  _cabcli = "";
                  /* _connesben := '' */
                  _connesben = "";
                } // End If
              } // End If
              /* If _modifica=1 */
              if (CPLib.eqr(_modifica,1)) {
                /* cNewProg := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
                cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
                /* stringaflagrap2 := 'ABCDEFGHI' // stringa di valori di flagrap2 */
                stringaflagrap2 = "ABCDEFGHI";
                // * --- Select from operazbo
                m_cServer = m_Ctx.GetServer("operazbo");
                m_cPhName = m_Ctx.GetPhName("operazbo");
                if (Cursor_operazbo!=null)
                  Cursor_operazbo.Close();
                Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idb,"?",0,0,m_cServer, m_oParameters),m_cServer,_idb)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_operazbo.Eof())) {
                  /* _flagrap2 := iif(Empty(operazbo->FLAGRAP2) or operazbo->FLAGRAP2='S',Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(operazbo->FLAGRAP2,stringaflagrap2)+1),1)) */
                  _flagrap2 = (CPLib.Empty(Cursor_operazbo.GetString("FLAGRAP2")) || CPLib.eqr(Cursor_operazbo.GetString("FLAGRAP2"),"S")?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(Cursor_operazbo.GetString("FLAGRAP2"),stringaflagrap2)+1),1));
                  /* _idb2 := LibreriaMit.UniqueId() // Idbase */
                  _idb2 = LibreriaMit.UniqueId();
                  // * --- Insert into operazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("operazbo");
                  m_cPhName = m_Ctx.GetPhName("operazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_update_po",27,"00000098")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000098(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAIMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAREG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_flagrap2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("NOPROT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RAREA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RCOMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RFREQ"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RIMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RTIPO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
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
                  // * --- Write into operazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("operazbo");
                  m_cPhName = m_Ctx.GetPhName("operazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_update_po",27,"00000099")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(_tipint,"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(_ragcli,"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(_stacli,"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(_citcli,"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(_cabcli,"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(_prvcli,"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(_domcli,"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(_capcli,"C",5,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(_connesben,"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TOTLIRE = "+CPLib.ToSQL(_totlire,"N",15,0)+", ";
                  m_cSql = m_cSql+"TOTCONT = "+CPLib.ToSQL(_totcont,"N",15,0)+", ";
                  m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                  m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("1","C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"OPERAZMOD = "+CPLib.ToSQL(Cursor_operazbo.GetString("IDEREG"),"C",20,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP2 = "+CPLib.ToSQL(_flagrap2,"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"IDBASE2 = "+CPLib.ToSQL(_idb2,"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"IDEREG = "+CPLib.ToSQL("O"+CPLib.Right(Cursor_operazbo.GetString("NUMPROG"),9)+_idb2,"C",20,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(_PAESE,"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(_DESCCIT,"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(_PROVINCIA,"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(_CODCAB,"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(_RAGSOC,"C",50,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_idb,"?",0,0,m_cServer),m_cServer,_idb)+"";
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
                  Cursor_operazbo.Next();
                }
                m_cConnectivityError = Cursor_operazbo.ErrorMessage();
                Cursor_operazbo.Close();
                // * --- End Select
                /* Exec Routine arrt_writelog('SAVE','OPERAZBO',w_SNAINUMOPE,"Sto elaborando l'operazione con codice:"+w_SNAINUMOPE,'I') */
                arrt_writelogR.Make(m_Ctx,this).Run("SAVE","OPERAZBO",w_SNAINUMOPE,"Sto elaborando l'operazione con codice:"+w_SNAINUMOPE,"I");
              } // End If
              Cursor_operazbo.Next();
            }
            m_cConnectivityError = Cursor_operazbo.ErrorMessage();
            Cursor_operazbo.Close();
            // * --- End Select
          } // End If
          Cursor_cgo_operazioni_storico.Next();
        }
        m_cConnectivityError = Cursor_cgo_operazioni_storico.ErrorMessage();
        Cursor_cgo_operazioni_storico.Close();
        // * --- End Select
        // * --- Write into cgo_operazioni_storico from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
        m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_storico",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_update_po",27,"0000009B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"FLGSBLOCCO = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"DATASBLOCCO = "+CPLib.ToSQL(CPLib.NullDateTime(),"T",14,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni_storico",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"?",0,0,m_cServer),m_cServer,w_SNAINUMOPE)+"";
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000025status,0)) {
          m_Sql.SetTransactionStatus(nTry00000025status,cTry00000025msg);
        }
      }
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_operazioni_storico!=null)
          Cursor_cgo_operazioni_storico.Close();
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
        if (Cursor_xperazbo!=null)
          Cursor_xperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_cgo_operazioni_storico=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_intestbo=null;
    try {
      /* xAnnNas Char(2) // Anno Di Nascita */
      String xAnnNas;
      xAnnNas = CPLib.Space(2);
      /* xMesNas Char(2) // Mese Di Nascita */
      String xMesNas;
      xMesNas = CPLib.Space(2);
      /* xDayNas Char(2) // Giorno Di Nascita */
      String xDayNas;
      xDayNas = CPLib.Space(2);
      /* cDNAS Date */
      java.sql.Date cDNAS;
      cDNAS = CPLib.NullDate();
      /* xSesso Char(1) */
      String xSesso;
      xSesso = CPLib.Space(1);
      /* cSNAS Char(30) */
      String cSNAS;
      cSNAS = CPLib.Space(30);
      /* cCNAS Char(30) */
      String cCNAS;
      cCNAS = CPLib.Space(30);
      /* cPNAS Char(2) */
      String cPNAS;
      cPNAS = CPLib.Space(2);
      /* xCodCab Char(6) */
      String xCodCab;
      xCodCab = CPLib.Space(6);
      /* _datnas Date */
      java.sql.Date _datnas;
      _datnas = CPLib.NullDate();
      /* _datemi Date */
      java.sql.Date _datemi;
      _datemi = CPLib.NullDate();
      /* _datval Date */
      java.sql.Date _datval;
      _datval = CPLib.NullDate();
      /* xRagSoc Char(70) */
      String xRagSoc;
      xRagSoc = CPLib.Space(70);
      /* cCli1 Char(16) */
      String cCli1;
      cCli1 = CPLib.Space(16);
      /* xCF Char(16) */
      String xCF;
      xCF = CPLib.Space(16);
      /* xCFE Numeric(1, 0) */
      double xCFE;
      xCFE = 0;
      /* xCitta Char(30) */
      String xCitta;
      xCitta = CPLib.Space(30);
      /* cProgSto Char(15) */
      String cProgSto;
      cProgSto = CPLib.Space(15);
      /* xRiga1 Memo */
      String xRiga1;
      xRiga1 = "";
      /* xRiga2 Memo */
      String xRiga2;
      xRiga2 = "";
      /* _tipdoc Char(2) */
      String _tipdoc;
      _tipdoc = CPLib.Space(2);
      /* _connes Char(16) */
      String _connes;
      _connes = CPLib.Space(16);
      /* _codfisc Char(16) */
      String _codfisc;
      _codfisc = CPLib.Space(16);
      /* xFLGSAE Char(3) */
      /* cInfProg1 Char(10) */
      /* cInfProg2 Char(11) */
      /* nProgImp Numeric(15, 0) */
      /* cColleg Char(12) */
      // * --- Select from cgo_operazioni_storico
      m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
      m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
      if (Cursor_cgo_operazioni_storico!=null)
        Cursor_cgo_operazioni_storico.Close();
      Cursor_cgo_operazioni_storico = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SNAINUMOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,w_SNAINUMOPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_storico")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_operazioni_storico.Eof())) {
        /* _tipdoc := '' */
        _tipdoc = "";
        /* _connes := '' */
        _connes = "";
        /* xRiga1 := '' */
        xRiga1 = "";
        /* xRiga2 := '' */
        xRiga2 = "";
        /* xFLGSAE := '' */
        xFLGSAE = "";
        // * --- Read from tbstati
        m_cServer = m_Ctx.GetServer("tbstati");
        m_cPhName = m_Ctx.GetPhName("tbstati");
        m_cSql = "";
        m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_cgo_operazioni_storico.GetString("PAESE"));
        if (m_Ctx.IsSharedTemp("tbstati")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGSAE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          xFLGSAE = Read_Cursor.GetString("FLGSAE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbstati into routine arrt_cgo_update_po returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          xFLGSAE = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Read from cgo_tipdoc
        m_cServer = m_Ctx.GetServer("cgo_tipdoc");
        m_cPhName = m_Ctx.GetPhName("cgo_tipdoc");
        m_cSql = "";
        m_cSql = m_cSql+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("TIPODOC"),"C",2,0,m_cServer),m_cServer,Cursor_cgo_operazioni_storico.GetString("TIPODOC"));
        if (m_Ctx.IsSharedTemp("cgo_tipdoc")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("AUIDOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _tipdoc = Read_Cursor.GetString("AUIDOC");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cgo_tipdoc into routine arrt_cgo_update_po returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _tipdoc = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(LRTrim(cgo_operazioni_storico->CODFISC))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_operazioni_storico.GetString("CODFISC"))))) {
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CODFISC"),"C",16,0,m_cServer),m_cServer,Cursor_cgo_operazioni_storico.GetString("CODFISC"));
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _connes = Read_Cursor.GetString("CONNES");
            _codfisc = Read_Cursor.GetString("CODFISC");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_cgo_update_po returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _connes = "";
            _codfisc = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
        } // End If
        /* xAnnNas := '' // Anno Di Nascita */
        xAnnNas = "";
        /* xMesNas := '' // Mese Di Nascita */
        xMesNas = "";
        /* xDayNas := '' // Giorno Di Nascita */
        xDayNas = "";
        /* cDNAS := NullDate() */
        cDNAS = CPLib.NullDate();
        /* xSesso := '' */
        xSesso = "";
        /* cSNAS := '' */
        cSNAS = "";
        /* cCNAS := '' */
        cCNAS = "";
        /* cPNAS := '' */
        cPNAS = "";
        /* xCodCab := '' */
        xCodCab = "";
        /* _datnas := cgo_operazioni_storico->DATANASC */
        _datnas = Cursor_cgo_operazioni_storico.GetDate("DATANASC");
        /* _datemi := cgo_operazioni_storico->DATARILASC */
        _datemi = Cursor_cgo_operazioni_storico.GetDate("DATARILASC");
        /* _datval := cgo_operazioni_storico->DATAVALI */
        _datval = Cursor_cgo_operazioni_storico.GetDate("DATAVALI");
        /* xRagSoc := LRTrim(cgo_operazioni_storico->COGNOME)+" "+ LRTrim(cgo_operazioni_storico->NOME) */
        xRagSoc = CPLib.LRTrim(Cursor_cgo_operazioni_storico.GetString("COGNOME"))+" "+CPLib.LRTrim(Cursor_cgo_operazioni_storico.GetString("NOME"));
        /* cCli1 := cgo_operazioni_storico->CODFISC */
        cCli1 = Cursor_cgo_operazioni_storico.GetString("CODFISC");
        /* xCF := cgo_operazioni_storico->CODFISC */
        xCF = Cursor_cgo_operazioni_storico.GetString("CODFISC");
        /* xCFE := cgo_operazioni_storico->CFESTERO */
        xCFE = CPLib.Round(Cursor_cgo_operazioni_storico.GetDouble("CFESTERO"),0);
        /* If Empty(LRTrim(xCodCab)) */
        if (CPLib.Empty(CPLib.LRTrim(xCodCab))) {
          /* xCitta := cgo_operazioni_storico->DESCCIT */
          xCitta = Cursor_cgo_operazioni_storico.GetString("DESCCIT");
          // * --- Read from tbcitta
          m_cServer = m_Ctx.GetServer("tbcitta");
          m_cPhName = m_Ctx.GetPhName("tbcitta");
          m_cSql = "";
          m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(xCitta,"C",60,0,m_cServer),m_cServer,xCitta);
          if (m_Ctx.IsSharedTemp("tbcitta")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            xCodCab = Read_Cursor.GetString("CAB");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_cgo_update_po returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            xCodCab = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
        } // End If
        /* xAnnNas := Substr(DateToChar(cgo_operazioni_storico->DATANASC),1,4) // Anno Di Nascita */
        xAnnNas = CPLib.Substr(CPLib.DateToChar(Cursor_cgo_operazioni_storico.GetDate("DATANASC")),1,4);
        /* xMesNas := Substr(DateToChar(cgo_operazioni_storico->DATANASC),5,2) // Mese Di Nascita */
        xMesNas = CPLib.Substr(CPLib.DateToChar(Cursor_cgo_operazioni_storico.GetDate("DATANASC")),5,2);
        /* xDayNas := Substr(DateToChar(cgo_operazioni_storico->DATANASC),7,2) // Giorno Di Nascita */
        xDayNas = CPLib.Substr(CPLib.DateToChar(Cursor_cgo_operazioni_storico.GetDate("DATANASC")),7,2);
        /* cDNAS := _datnas */
        cDNAS = _datnas;
        /* xSesso := cgo_operazioni_storico->SESSO */
        xSesso = Cursor_cgo_operazioni_storico.GetString("SESSO");
        /* If not(Empty(LRTrim(cgo_operazioni_storico->TIPINTER))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_operazioni_storico.GetString("TIPINTER"))))) {
          /* If LRTrim(cgo_operazioni_storico->TIPINTER)='EE' */
          if (CPLib.eqr(CPLib.LRTrim(Cursor_cgo_operazioni_storico.GetString("TIPINTER")),"EE")) {
            /* cSNAS := '' */
            cSNAS = "";
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("NASSTATO"),"C",40,0,m_cServer),m_cServer,Cursor_cgo_operazioni_storico.GetString("NASSTATO"));
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              cSNAS = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_cgo_update_po returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              cSNAS = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(cSNAS) */
            if (CPLib.Empty(cSNAS)) {
              /* cSNAS := cgo_operazioni_storico->NASCOMUN */
              cSNAS = Cursor_cgo_operazioni_storico.GetString("NASCOMUN");
            } // End If
            /* cCNAS := '' */
            cCNAS = "";
            /* cPNAS := 'EE' */
            cPNAS = "EE";
          } else { // Else
            /* cCNAS := '' */
            cCNAS = "";
            /* cPNAS := '' */
            cPNAS = "";
            // * --- Read from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("NASCOMUN"),"C",60,0,m_cServer),m_cServer,Cursor_cgo_operazioni_storico.GetString("NASCOMUN"));
            if (m_Ctx.IsSharedTemp("tbcitta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              cCNAS = Read_Cursor.GetString("CITTA");
              cPNAS = Read_Cursor.GetString("PROV");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_cgo_update_po returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              cCNAS = "";
              cPNAS = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(cCNAS) */
            if (CPLib.Empty(cCNAS)) {
              /* cCNAS := cgo_operazioni_storico->NASCOMUN */
              cCNAS = Cursor_cgo_operazioni_storico.GetString("NASCOMUN");
            } // End If
            /* cSNAS := '' */
            cSNAS = "";
          } // End If
        } else { // Else
          /* cSNAS := cgo_operazioni_storico->NASSTATO */
          cSNAS = Cursor_cgo_operazioni_storico.GetString("NASSTATO");
          /* cCNAS := cgo_operazioni_storico->NASCOMUN */
          cCNAS = Cursor_cgo_operazioni_storico.GetString("NASCOMUN");
          /* cPNAS := '' */
          cPNAS = "";
        } // End If
        /* xRiga1 := LibreriaMit.SpacePad(xCF,16) */
        xRiga1 = LibreriaMit.SpacePad(xCF,16);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(xRagSoc,70) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(xRagSoc,70);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cgo_operazioni_storico->DOMICILIO,35) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_operazioni_storico.GetString("DOMICILIO"),35);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cgo_operazioni_storico->DESCCIT,30) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_operazioni_storico.GetString("DESCCIT"),30);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cgo_operazioni_storico->PROVINCIA,2) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_operazioni_storico.GetString("PROVINCIA"),2);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(LRTrim(cgo_operazioni_storico->CAP),5) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_cgo_operazioni_storico.GetString("CAP")),5);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cgo_operazioni_storico->PAESE,3) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_operazioni_storico.GetString("PAESE"),3);
        /* If cgo_operazioni_storico->CFESTERO=0 */
        if (CPLib.eqr(Cursor_cgo_operazioni_storico.GetDouble("CFESTERO"),0)) {
          /* xRiga1 := xRiga1 + LibreriaMit.SpacePad('600',3) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad("600",3);
          /* xRiga1 := xRiga1 + LibreriaMit.SpacePad('   ',3) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad("   ",3);
          /* xRiga1 := xRiga1 + LibreriaMit.SpacePad('600',3) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad("600",3);
        } else { // Else
          /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(xFLGSAE,3) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad(xFLGSAE,3);
          /* xRiga1 := xRiga1 + LibreriaMit.SpacePad('   ',3) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad("   ",3);
          /* xRiga1 := xRiga1 + LibreriaMit.SpacePad('711',3) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad("711",3);
        } // End If
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(Left(cCNAS,30),30) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(CPLib.Left(cCNAS,30),30);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cPNAS,2) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(cPNAS,2);
        /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(Left(cSNAS,30),30) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(CPLib.Left(cSNAS,30),30);
        /* xRiga1 := xRiga1 + iif(DateToChar(_datnas) <> '01000101',LibreriaMit.SpacePad(DateToChar(_datnas),8),Space(8)) */
        xRiga1 = xRiga1+(CPLib.ne(CPLib.DateToChar(_datnas),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(_datnas),8):CPLib.Space(8));
        /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(_tipdoc,2) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(_tipdoc,2);
        /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(cgo_operazioni_storico->NUMDOCUM,15) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_operazioni_storico.GetString("NUMDOCUM"),15);
        /* xRiga1 := xRiga1 + iif(DateToChar(_datemi) <> '01000101',LibreriaMit.SpacePad(DateToChar(_datemi),8),Space(8)) */
        xRiga1 = xRiga1+(CPLib.ne(CPLib.DateToChar(_datemi),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(_datemi),8):CPLib.Space(8));
        /* xRiga1 := xRiga1 + iif(DateToChar(_datval) <> '01000101',LibreriaMit.SpacePad(DateToChar(_datval),8),Space(8)) */
        xRiga1 = xRiga1+(CPLib.ne(CPLib.DateToChar(_datval),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(_datval),8):CPLib.Space(8));
        /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(cgo_operazioni_storico->AUTRILASC,30) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_operazioni_storico.GetString("AUTRILASC"),30);
        /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(cgo_operazioni_storico->PEP,1) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_operazioni_storico.GetString("PEP"),1);
        /* Crea la riga di confronto */
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCli1,"?",0,0,m_cServer, m_oParameters),m_cServer,cCli1)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* xRiga2 := LibreriaMit.SpacePad(personbo->CODFISC,16) */
          xRiga2 = LibreriaMit.SpacePad(Cursor_personbo.GetString("CODFISC"),16);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->RAGSOC,70) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("RAGSOC"),70);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->DOMICILIO,35) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("DOMICILIO"),35);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->DESCCIT,30) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("DESCCIT"),30);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->PROVINCIA,2) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("PROVINCIA"),2);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(LRTrim(personbo->CAP),5) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_personbo.GetString("CAP")),5);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->PAESE,3) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("PAESE"),3);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->SOTGRUP,3) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("SOTGRUP"),3);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->RAMOGRUP,3) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("RAMOGRUP"),3);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->SETTSINT,3) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("SETTSINT"),3);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(Left(personbo->NASCOMUN,30),30) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(CPLib.Left(Cursor_personbo.GetString("NASCOMUN"),30),30);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->TIPINTER,2) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("TIPINTER"),2);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(Left(personbo->NASSTATO,30),30) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(CPLib.Left(Cursor_personbo.GetString("NASSTATO"),30),30);
          /* xRiga2 := xRiga2 + iif(DateToChar(personbo->DATANASC) <> '01000101',LibreriaMit.SpacePad(DateToChar(personbo->DATANASC),8),Space(8)) */
          xRiga2 = xRiga2+(CPLib.ne(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),8):CPLib.Space(8));
          /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->TIPODOC,2) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("TIPODOC"),2);
          /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->NUMDOCUM,15) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("NUMDOCUM"),15);
          /* xRiga2 := xRiga2 + iif(DateToChar(personbo->DATARILASC) <> '01000101',LibreriaMit.SpacePad(DateToChar(personbo->DATARILASC),8),Space(8)) */
          xRiga2 = xRiga2+(CPLib.ne(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),8):CPLib.Space(8));
          /* xRiga2 := xRiga2 + iif(DateToChar(personbo->DATAVALI) <> '01000101',LibreriaMit.SpacePad(DateToChar(personbo->DATAVALI),8),Space(8)) */
          xRiga2 = xRiga2+(CPLib.ne(CPLib.DateToChar(Cursor_personbo.GetDate("DATAVALI")),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_personbo.GetDate("DATAVALI")),8):CPLib.Space(8));
          /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->AUTRILASC,30) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("AUTRILASC"),30);
          /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->PEP,1) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("PEP"),1);
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        /* If Upper(LRTrim(xRiga1)) <> Upper(LRTrim(xRiga2)) */
        if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(xRiga1)),CPLib.Upper(CPLib.LRTrim(xRiga2)))) {
          /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
          cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCli1,"?",0,0,m_cServer, m_oParameters),m_cServer,cCli1)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            // * --- Insert into wersonbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_update_po",27,"00000123")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000123(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
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
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
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
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDateTime("NUMIMP"),"?",0,0)+", ";
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
          // * --- Write into personbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_update_po",27,"00000124")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(xRagSoc,70),"C",70,0,m_cServer)+", ";
          m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(Cursor_cgo_operazioni_storico.GetString("DOMICILIO"),35),"C",35,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(cDNAS,"D",8,0)+", ";
          m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.Left(cCNAS,30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_operazioni_storico.GetDouble("CFESTERO"),0)?"600":"77"+xFLGSAE),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_operazioni_storico.GetDouble("CFESTERO"),0)?"600":"711"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(_tipdoc,"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(Cursor_cgo_operazioni_storico.GetString("NUMDOCUM"),15),"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(_datemi,"D",8,0)+", ";
          m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(Cursor_cgo_operazioni_storico.GetString("DESCCIT"),30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("PAESE"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("CAP"),"C",9,0,m_cServer)+", ";
          m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("SESSO"),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(_datval,"D",8,0)+", ";
          m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("COGNOME"),"C",26,0,m_cServer)+", ";
          m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("NOME"),"C",25,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(cPNAS,"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(xCFE,"N",1,0)+", ";
          m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.Left(cSNAS,30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"PEP = "+CPLib.ToSQL((CPLib.Empty(Cursor_cgo_operazioni_storico.GetString("PEP"))?"N":Cursor_cgo_operazioni_storico.GetString("PEP")),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL("P","C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
          }
          /* _codfisc := '' */
          _codfisc = "";
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAINI,DATAFINE,RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* If cgo_operazioni_storico->DATAOPE >= intestbo->DATAINI and (Empty(intestbo->DATAFINE) or intestbo->DATAFINE >= cgo_operazioni_storico->DATAOPE) */
            if (CPLib.ge(Cursor_cgo_operazioni_storico.GetDate("DATAOPE"),Cursor_intestbo.GetDate("DATAINI")) && (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")) || CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_cgo_operazioni_storico.GetDate("DATAOPE")))) {
              /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
              cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              /* cColleg := 'I'+cInfProg2 */
              cColleg = "I"+cInfProg2;
              // * --- Insert into rapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_update_po",27,"0000012C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000012C(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cColleg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date())+cInfProg1+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull("31","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
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
              /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
              cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into rapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_update_po",27,"00000130")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000130(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cColleg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date())+cInfProg1+"0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull("32","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
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
            } // End If
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
        } // End If
        // * --- Read from personbo_agg
        m_cServer = m_Ctx.GetServer("personbo_agg");
        m_cPhName = m_Ctx.GetPhName("personbo_agg");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"C",16,0,m_cServer),m_cServer,_connes);
        if (m_Ctx.IsSharedTemp("personbo_agg")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _codfisc = Read_Cursor.GetString("CONNES");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo_agg into routine arrt_cgo_update_po returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _codfisc = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(_codfisc)) */
        if (CPLib.Empty(CPLib.LRTrim(_codfisc))) {
          // * --- Insert into personbo_agg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo_agg");
          m_cPhName = m_Ctx.GetPhName("personbo_agg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_update_po",27,"00000133")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000133(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("RDCODAUT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("RDLOCAUT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("NUMTEL"),"?",0,0,m_cServer)+", ";
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
        } else { // Else
          // * --- Write into personbo_agg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo_agg");
          m_cPhName = m_Ctx.GetPhName("personbo_agg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_update_po",27,"00000134")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"RDCODAUT = "+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("RDCODAUT"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"RDLOCAUT = "+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("RDLOCAUT"),"C",20,0,m_cServer)+", ";
          m_cSql = m_cSql+"NUMTEL = "+CPLib.ToSQL(Cursor_cgo_operazioni_storico.GetString("NUMTEL"),"C",20,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
        } // End If
        /* Exec Routine arrt_writelog('SAVE','PERSONBO',w_SNAINUMOPE,"Sto elaborando l'operazione con codice:"+w_SNAINUMOPE+' - Salvataggio dati soggetto con codice:'+_connes,'I') */
        arrt_writelogR.Make(m_Ctx,this).Run("SAVE","PERSONBO",w_SNAINUMOPE,"Sto elaborando l'operazione con codice:"+w_SNAINUMOPE+" - Salvataggio dati soggetto con codice:"+_connes,"I");
        Cursor_cgo_operazioni_storico.Next();
      }
      m_cConnectivityError = Cursor_cgo_operazioni_storico.ErrorMessage();
      Cursor_cgo_operazioni_storico.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cgo_operazioni_storico!=null)
          Cursor_cgo_operazioni_storico.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
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
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_SNAINUMOPE) {
    w_SNAINUMOPE = p_w_SNAINUMOPE;
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
  public Forward Run(String p_w_SNAINUMOPE) {
    w_SNAINUMOPE = p_w_SNAINUMOPE;
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
  public static arrt_cgo_update_poR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_update_poR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_SNAINUMOPE = CPLib.Space(15);
    _idb = CPLib.Space(10);
    _tipint = CPLib.Space(2);
    _PAESE = CPLib.Space(3);
    _DESCCIT = CPLib.Space(70);
    _RAGSOC = CPLib.Space(70);
    _PROVINCIA = CPLib.Space(2);
    _CODCAB = CPLib.Space(6);
    _ragcli = CPLib.Space(70);
    _domcli = CPLib.Space(35);
    _citcli = CPLib.Space(30);
    _prvcli = CPLib.Space(2);
    _stacli = CPLib.Space(3);
    _capcli = CPLib.Space(9);
    _cabcli = CPLib.Space(6);
    _totlire = 0;
    _totcont = 0;
    _modifica = 0;
    _idb2 = CPLib.Space(10);
    cNewProg = CPLib.Space(10);
    stringaflagrap2 = CPLib.Space(10);
    _flagrap2 = CPLib.Space(1);
    _tipinter = CPLib.Space(2);
    _codinter = CPLib.Space(11);
    _citinter = CPLib.Space(30);
    _cabinter = CPLib.Space(6);
    _prvinter = CPLib.Space(2);
    _limoper = 0;
    _connesben = CPLib.Space(16);
    xFLGSAE = CPLib.Space(3);
    cInfProg1 = CPLib.Space(10);
    cInfProg2 = CPLib.Space(11);
    nProgImp = 0;
    cColleg = CPLib.Space(12);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_writelog,
  public static final String i_InvokedRoutines = ",arrt_writelog,";
  public static String[] m_cRunParameterNames={"w_SNAINUMOPE"};
  protected static String GetFieldsName_00000098(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
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
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000123(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"datamodi,";
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
    p_cSql = p_cSql+"NUMIMP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000130(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000133(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RDCODAUT,";
    p_cSql = p_cSql+"RDLOCAUT,";
    p_cSql = p_cSql+"NUMTEL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
}
