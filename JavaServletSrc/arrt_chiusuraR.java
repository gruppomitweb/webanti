// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_chiusuraR implements CallerWithObjs {
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
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_appointestbo;
  public String m_cServer_appointestbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_aefiles;
  public String m_cServer_aefiles;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_garantbo;
  public String m_cServer_garantbo;
  public String m_cPhName_jarantbo;
  public String m_cServer_jarantbo;
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
  public String pTipo;
  public java.sql.Date w_datchi;
  public java.sql.Date w_datreg;
  public String w_tipoarch;
  public String w_causale;
  public String w_macage;
  public String _errlog;
  public double imprec;
  public double _noprot;
  public String _rapold;
  public String _tipoco;
  public double _nriga;
  public double _newrow;
  public double _conta;
  public String _idriga;
  public double _bottom;
  public double _top;
  public double _max;
  public double _cicli;
  public double _min;
  public double nProgImp;
  public String cInfProg1;
  public String cInfProg2;
  public double _closed;
  public double _delega;
  public String _coddel;
  public double _nrow;
  public String _idb2;
  public String _idreg;
  public String _macodice;
  public String gMsgImp;
  public String gAzienda;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_chiusuraR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_chiusura",m_Caller);
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_appointestbo = p_ContextObject.GetPhName("appointestbo");
    if (m_cPhName_appointestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_appointestbo = m_cPhName_appointestbo+" "+m_Ctx.GetWritePhName("appointestbo");
    }
    m_cServer_appointestbo = p_ContextObject.GetServer("appointestbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_aefiles = p_ContextObject.GetPhName("aefiles");
    if (m_cPhName_aefiles.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefiles = m_cPhName_aefiles+" "+m_Ctx.GetWritePhName("aefiles");
    }
    m_cServer_aefiles = p_ContextObject.GetServer("aefiles");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    if (m_cPhName_japopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japopebo = m_cPhName_japopebo+" "+m_Ctx.GetWritePhName("japopebo");
    }
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    m_cPhName_garantbo = p_ContextObject.GetPhName("garantbo");
    if (m_cPhName_garantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_garantbo = m_cPhName_garantbo+" "+m_Ctx.GetWritePhName("garantbo");
    }
    m_cServer_garantbo = p_ContextObject.GetServer("garantbo");
    m_cPhName_jarantbo = p_ContextObject.GetPhName("jarantbo");
    if (m_cPhName_jarantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jarantbo = m_cPhName_jarantbo+" "+m_Ctx.GetWritePhName("jarantbo");
    }
    m_cServer_jarantbo = p_ContextObject.GetServer("jarantbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("imprec",p_cVarName)) {
      return imprec;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      return _noprot;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      return _nriga;
    }
    if (CPLib.eqr("_newrow",p_cVarName)) {
      return _newrow;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("_closed",p_cVarName)) {
      return _closed;
    }
    if (CPLib.eqr("_delega",p_cVarName)) {
      return _delega;
    }
    if (CPLib.eqr("_nrow",p_cVarName)) {
      return _nrow;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_chiusura";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("tipoarch",p_cVarName)) {
      return w_tipoarch;
    }
    if (CPLib.eqr("causale",p_cVarName)) {
      return w_causale;
    }
    if (CPLib.eqr("macage",p_cVarName)) {
      return w_macage;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("_errlog",p_cVarName)) {
      return _errlog;
    }
    if (CPLib.eqr("_rapold",p_cVarName)) {
      return _rapold;
    }
    if (CPLib.eqr("_tipoco",p_cVarName)) {
      return _tipoco;
    }
    if (CPLib.eqr("_idriga",p_cVarName)) {
      return _idriga;
    }
    if (CPLib.eqr("cInfProg1",p_cVarName)) {
      return cInfProg1;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      return cInfProg2;
    }
    if (CPLib.eqr("_coddel",p_cVarName)) {
      return _coddel;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      return _idb2;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      return _idreg;
    }
    if (CPLib.eqr("_macodice",p_cVarName)) {
      return _macodice;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("datchi",p_cVarName)) {
      return w_datchi;
    }
    if (CPLib.eqr("datreg",p_cVarName)) {
      return w_datreg;
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
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("imprec",p_cVarName)) {
      imprec = value;
      return;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      _noprot = value;
      return;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      _nriga = value;
      return;
    }
    if (CPLib.eqr("_newrow",p_cVarName)) {
      _newrow = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("_closed",p_cVarName)) {
      _closed = value;
      return;
    }
    if (CPLib.eqr("_delega",p_cVarName)) {
      _delega = value;
      return;
    }
    if (CPLib.eqr("_nrow",p_cVarName)) {
      _nrow = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipoarch",p_cVarName)) {
      w_tipoarch = value;
      return;
    }
    if (CPLib.eqr("causale",p_cVarName)) {
      w_causale = value;
      return;
    }
    if (CPLib.eqr("macage",p_cVarName)) {
      w_macage = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("_errlog",p_cVarName)) {
      _errlog = value;
      return;
    }
    if (CPLib.eqr("_rapold",p_cVarName)) {
      _rapold = value;
      return;
    }
    if (CPLib.eqr("_tipoco",p_cVarName)) {
      _tipoco = value;
      return;
    }
    if (CPLib.eqr("_idriga",p_cVarName)) {
      _idriga = value;
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
    if (CPLib.eqr("_coddel",p_cVarName)) {
      _coddel = value;
      return;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      _idb2 = value;
      return;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      _idreg = value;
      return;
    }
    if (CPLib.eqr("_macodice",p_cVarName)) {
      _macodice = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("datchi",p_cVarName)) {
      w_datchi = value;
      return;
    }
    if (CPLib.eqr("datreg",p_cVarName)) {
      w_datreg = value;
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
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    /* pTipo Char(1) */
    /* w_datchi Date */
    /* w_datreg Date */
    /* w_tipoarch Char(1) // Tipo Archivio */
    /* w_causale Char(2) // Tipo Archivio */
    /* w_macage Char(5) // Tipo Archivio */
    /* _errlog Memo */
    /* imprec Numeric(10, 0) */
    /* _noprot Numeric(1, 0) */
    /* _rapold Char(25) */
    /* _tipoco Char(1) */
    /* _nriga Numeric(4, 0) */
    /* _newrow Numeric(4, 0) */
    /* _conta Numeric(10, 0) */
    /* _idriga Char(10) */
    /* _bottom Numeric(15, 0) */
    /* _top Numeric(15, 0) */
    /* _max Numeric(15, 0) */
    /* _cicli Numeric(15, 0) */
    /* _min Numeric(15, 0) */
    /* nProgImp Numeric(15, 0) */
    /* cInfProg1 Char(10) */
    /* cInfProg2 Char(11) */
    /* _closed Numeric(1, 0) */
    /* _delega Numeric(1, 0) */
    /* _coddel Char(16) */
    /* _nrow Numeric(4, 0) */
    /* _idb2 Char(10) */
    /* _idreg Char(20) */
    /* _macodice Char(5) */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gAzienda Char(10) // Azienda */
    /* gMsgProc Char(120) // Messaggio */
    /* Case pTipo='R' */
    if (CPLib.eqr(pTipo,"R")) {
      /* Exec "Rapporti" Page 2:Page_2 */
      Page_2();
      /* Case pTipo='D' */
    } else if (CPLib.eqr(pTipo,"D")) {
      /* Exec "Deleghe" Page 3:Page_3 */
      Page_3();
      /* Case pTipo='T' */
    } else if (CPLib.eqr(pTipo,"T")) {
      /* Exec "Titolari" Page 4:Page_4 */
      Page_4();
    } // End Case
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_intestbo_macodice=null;
    CPResultSet Cursor_qbe_allinea_intesbo_macodice=null;
    CPResultSet Cursor_qbe_closeall_minmax=null;
    CPResultSet Cursor_qbe_closeall=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_qbe_closeall_minmax_age=null;
    CPResultSet Cursor_qbe_closeall_age=null;
    CPResultSet Cursor_japopebo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* gMsgProc := 'Inizio chiusura rapporti alle ore: '+arfn_fdatetime(DateTime()) + NL // Messaggio Import */
      gMsgProc = "Inizio chiusura rapporti alle ore: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* imprec := 0 */
      imprec = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000002Dstatus;
      nTry0000002Dstatus = m_Sql.GetTransactionStatus();
      String cTry0000002Dmsg;
      cTry0000002Dmsg = m_Sql.TransactionErrorMessage();
      try {
        /* Apertuture da AUI */
        /* If w_tipoarch='A' */
        if (CPLib.eqr(w_tipoarch,"A")) {
          /* If not(Empty(w_macage)) */
          if ( ! (CPLib.Empty(w_macage))) {
            // * --- Select from qbe_intestbo_macodice
            SPBridge.HMCaller _h00000031;
            _h00000031 = new SPBridge.HMCaller();
            _h00000031.Set("m_cVQRList",m_cVQRList);
            _h00000031.Set("pMACODICE",w_macage);
            if (Cursor_qbe_intestbo_macodice!=null)
              Cursor_qbe_intestbo_macodice.Close();
            Cursor_qbe_intestbo_macodice = new VQRHolder("qbe_intestbo_macodice",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000031,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_intestbo_macodice.Eof())) {
              // * --- Write into intestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_chiusura",164,"00000032")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQLNull(Cursor_qbe_intestbo_macodice.GetString("RAPPORTO"),"C",16,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_intestbo_macodice.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_intestbo_macodice.GetString("RAPPORTO"))+"";
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
              Cursor_qbe_intestbo_macodice.Next();
            }
            m_cConnectivityError = Cursor_qbe_intestbo_macodice.ErrorMessage();
            Cursor_qbe_intestbo_macodice.Close();
            // * --- End Select
            // * --- Select from qbe_allinea_intesbo_macodice
            SPBridge.HMCaller _h00000033;
            _h00000033 = new SPBridge.HMCaller();
            _h00000033.Set("m_cVQRList",m_cVQRList);
            _h00000033.Set("pMACODICE",w_macage);
            if (Cursor_qbe_allinea_intesbo_macodice!=null)
              Cursor_qbe_allinea_intesbo_macodice.Close();
            Cursor_qbe_allinea_intesbo_macodice = new VQRHolder("qbe_allinea_intesbo_macodice",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000033,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_allinea_intesbo_macodice.Eof())) {
              // * --- Write into intestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_chiusura",164,"00000034")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(Cursor_qbe_allinea_intesbo_macodice.GetString("NUMPROG2"),"C",11,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_qbe_allinea_intesbo_macodice.GetDate("DATAFINE"),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allinea_intesbo_macodice.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allinea_intesbo_macodice.GetString("RAPPORTO"))+"";
              m_cSql = m_cSql+" and IDBASE <> "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allinea_intesbo_macodice.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allinea_intesbo_macodice.GetString("IDBASE"))+"";
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
              // * --- Delete from intestbo
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_chiusura",164,"00000035")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allinea_intesbo_macodice.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allinea_intesbo_macodice.GetString("IDBASE"))+"";
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
              Cursor_qbe_allinea_intesbo_macodice.Next();
            }
            m_cConnectivityError = Cursor_qbe_allinea_intesbo_macodice.ErrorMessage();
            Cursor_qbe_allinea_intesbo_macodice.Close();
            // * --- End Select
          } // End If
          // * --- Select from qbe_closeall_minmax
          if (Cursor_qbe_closeall_minmax!=null)
            Cursor_qbe_closeall_minmax.Close();
          Cursor_qbe_closeall_minmax = new VQRHolder("qbe_closeall_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_closeall_minmax.Eof())) {
            /* _max := qbe_closeall_minmax->MAXPRGIMPSOG */
            _max = CPLib.Round(Cursor_qbe_closeall_minmax.GetDouble("MAXPRGIMPSOG"),0);
            /* _min := qbe_closeall_minmax->MINPRGIMPSOG */
            _min = CPLib.Round(Cursor_qbe_closeall_minmax.GetDouble("MINPRGIMPSOG"),0);
            Cursor_qbe_closeall_minmax.Next();
          }
          m_cConnectivityError = Cursor_qbe_closeall_minmax.ErrorMessage();
          Cursor_qbe_closeall_minmax.Close();
          // * --- End Select
          /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
          /* _conta := 1 */
          _conta = CPLib.Round(1,0);
          /* While _conta <= _cicli */
          while (CPLib.le(_conta,_cicli)) {
            /* _bottom := ((_conta -1 ) * 10000) + 1 */
            _bottom = CPLib.Round(((_conta-1)*10000)+1,0);
            /* _top := _conta * 10000 */
            _top = CPLib.Round(_conta*10000,0);
            /* If _top>=_min */
            if (CPLib.ge(_top,_min)) {
              // * --- Select from qbe_closeall
              if (Cursor_qbe_closeall!=null)
                Cursor_qbe_closeall.Close();
              Cursor_qbe_closeall = new VQRHolder("qbe_closeall",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_closeall.Eof())) {
                /* If Empty(w_macage) or (not(Empty(w_macage)) and w_macage=qbe_closeall->MACODICE) */
                if (CPLib.Empty(w_macage) || ( ! (CPLib.Empty(w_macage)) && CPLib.eqr(w_macage,Cursor_qbe_closeall.GetString("MACODICE")))) {
                  /* _closed := 0 */
                  _closed = CPLib.Round(0,0);
                  // * --- Select from rapopebo
                  m_cServer = m_Ctx.GetServer("rapopebo");
                  m_cPhName = m_Ctx.GetPhName("rapopebo");
                  if (Cursor_rapopebo!=null)
                    Cursor_rapopebo.Close();
                  Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO,STATOREG,TIPOOPRAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_closeall.GetString("RAPPORTO"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_rapopebo.Eof())) {
                    /* If rapopebo->TIPOOPRAP='26' or rapopebo->TIPOOPRAP='36' or rapopebo->TIPOOPRAP='46' or rapopebo->TIPOOPRAP='38'  */
                    if (CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"26") || CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"36") || CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"46") || CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"38")) {
                      /* _closed := 1 */
                      _closed = CPLib.Round(1,0);
                    } // End If
                    Cursor_rapopebo.Next();
                  }
                  m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
                  Cursor_rapopebo.Close();
                  // * --- End Select
                  /* If _closed=0 */
                  if (CPLib.eqr(_closed,0)) {
                    // * --- Select from rapopebo
                    m_cServer = m_Ctx.GetServer("rapopebo");
                    m_cPhName = m_Ctx.GetPhName("rapopebo");
                    if (Cursor_rapopebo!=null)
                      Cursor_rapopebo.Close();
                    Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_closeall.GetString("RAPPORTO"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1')  and  (TIPOOPRAP='23'  or  TIPOOPRAP='45') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_rapopebo.Eof())) {
                      /* If rapopebo->DATAOPE <= w_datchi */
                      if (CPLib.le(Cursor_rapopebo.GetDate("DATAOPE"),w_datchi)) {
                        /* imprec := imprec + 1 */
                        imprec = CPLib.Round(imprec+1,0);
                        /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
                        cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                        /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
                        cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
                        /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
                        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                        /* _idb2 := LibreriaMit.UniqueId() // Idbase */
                        _idb2 = LibreriaMit.UniqueId();
                        /* _idreg := 'I'+Right(cInfProg2,9)+_idb2 // Idbase */
                        _idreg = "I"+CPLib.Right(cInfProg2,9)+_idb2;
                        /* gMsgImp := "Creazione Informazione di chiusura n.: "+LRTrim(Str(imprec,10,0)) // Messaggio Import */
                        gMsgImp = "Creazione Informazione di chiusura n.: "+CPLib.LRTrim(CPLib.Str(imprec,10,0));
                        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                        // * --- Insert into rapopebo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("rapopebo");
                        m_cPhName = m_Ctx.GetPhName("rapopebo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_chiusura",164,"0000004F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_0000004F(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(w_datchi,"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(w_datreg,"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQLNull(w_causale,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(w_datchi),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(w_datreg),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
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
                        // * --- Write into intestbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("intestbo");
                        m_cPhName = m_Ctx.GetPhName("intestbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_chiusura",164,"00000050")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(w_datchi,"D",8,0)+", ";
                        m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_closeall.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_closeall.GetString("RAPPORTO"))+"";
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
                        // * --- Write into garantbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("garantbo");
                        m_cPhName = m_Ctx.GetPhName("garantbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"garantbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_chiusura",164,"00000051")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(w_datchi,"D",8,0)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"garantbo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_closeall.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_closeall.GetString("RAPPORTO"))+"";
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
                  } // End If
                } // End If
                Cursor_qbe_closeall.Next();
              }
              m_cConnectivityError = Cursor_qbe_closeall.ErrorMessage();
              Cursor_qbe_closeall.Close();
              // * --- End Select
            } // End If
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
          } // End While
          /* ElseIf w_tipoarch='E' */
        } else if (CPLib.eqr(w_tipoarch,"E")) {
          // * --- Select from qbe_closeall_minmax_age
          if (Cursor_qbe_closeall_minmax_age!=null)
            Cursor_qbe_closeall_minmax_age.Close();
          Cursor_qbe_closeall_minmax_age = new VQRHolder("qbe_closeall_minmax_age",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_closeall_minmax_age.Eof())) {
            /* _max := qbe_closeall_minmax_age->MAXPRGIMPSOG */
            _max = CPLib.Round(Cursor_qbe_closeall_minmax_age.GetDouble("MAXPRGIMPSOG"),0);
            /* _min := qbe_closeall_minmax_age->MINPRGIMPSOG */
            _min = CPLib.Round(Cursor_qbe_closeall_minmax_age.GetDouble("MINPRGIMPSOG"),0);
            Cursor_qbe_closeall_minmax_age.Next();
          }
          m_cConnectivityError = Cursor_qbe_closeall_minmax_age.ErrorMessage();
          Cursor_qbe_closeall_minmax_age.Close();
          // * --- End Select
          /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
          /* _conta := 1 */
          _conta = CPLib.Round(1,0);
          /* While _conta <= _cicli */
          while (CPLib.le(_conta,_cicli)) {
            /* _bottom := ((_conta -1 ) * 10000) + 1 */
            _bottom = CPLib.Round(((_conta-1)*10000)+1,0);
            /* _top := _conta * 10000 */
            _top = CPLib.Round(_conta*10000,0);
            /* If _top>=_min */
            if (CPLib.ge(_top,_min)) {
              // * --- Select from qbe_closeall_age
              if (Cursor_qbe_closeall_age!=null)
                Cursor_qbe_closeall_age.Close();
              Cursor_qbe_closeall_age = new VQRHolder("qbe_closeall_age",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_closeall_age.Eof())) {
                /* _closed := 0 */
                _closed = CPLib.Round(0,0);
                // * --- Select from japopebo
                m_cServer = m_Ctx.GetServer("japopebo");
                m_cPhName = m_Ctx.GetPhName("japopebo");
                if (Cursor_japopebo!=null)
                  Cursor_japopebo.Close();
                Cursor_japopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_closeall_age.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("japopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_japopebo.Eof())) {
                  /* If japopebo->TIPOOPRAP='26' or japopebo->TIPOOPRAP='36' or japopebo->TIPOOPRAP='46' or japopebo->TIPOOPRAP='38'  */
                  if (CPLib.eqr(Cursor_japopebo.GetString("TIPOOPRAP"),"26") || CPLib.eqr(Cursor_japopebo.GetString("TIPOOPRAP"),"36") || CPLib.eqr(Cursor_japopebo.GetString("TIPOOPRAP"),"46") || CPLib.eqr(Cursor_japopebo.GetString("TIPOOPRAP"),"38")) {
                    /* _closed := 1 */
                    _closed = CPLib.Round(1,0);
                  } // End If
                  Cursor_japopebo.Next();
                }
                m_cConnectivityError = Cursor_japopebo.ErrorMessage();
                Cursor_japopebo.Close();
                // * --- End Select
                /* If _closed=0 */
                if (CPLib.eqr(_closed,0)) {
                  // * --- Select from japopebo
                  m_cServer = m_Ctx.GetServer("japopebo");
                  m_cPhName = m_Ctx.GetPhName("japopebo");
                  if (Cursor_japopebo!=null)
                    Cursor_japopebo.Close();
                  Cursor_japopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_closeall_age.GetString("RAPPORTO"),"?",0,0)+"  and  TIPOOPRAP='23' "+")"+(m_Ctx.IsSharedTemp("japopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_japopebo.Eof())) {
                    /* If japopebo->DATAOPE <= w_datchi */
                    if (CPLib.le(Cursor_japopebo.GetDate("DATAOPE"),w_datchi)) {
                      /* imprec := imprec + 1 */
                      imprec = CPLib.Round(imprec+1,0);
                      /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
                      cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                      /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
                      cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
                      /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
                      nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                      /* _idb2 := LibreriaMit.UniqueId() // Idbase */
                      _idb2 = LibreriaMit.UniqueId();
                      /* _idreg := 'I'+Right(cInfProg2,9)+_idb2 // Idbase */
                      _idreg = "I"+CPLib.Right(cInfProg2,9)+_idb2;
                      /* gMsgImp := "Creazione Informazione di chiusura n.: "+LRTrim(Str(imprec,10,0)) // Messaggio Import */
                      gMsgImp = "Creazione Informazione di chiusura n.: "+CPLib.LRTrim(CPLib.Str(imprec,10,0));
                      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                      // * --- Insert into japopebo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("japopebo");
                      m_cPhName = m_Ctx.GetPhName("japopebo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japopebo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_chiusura",164,"0000006B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000006B(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(w_datchi,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_japopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(w_datreg,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(w_causale,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(w_datchi),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"japopebo",true);
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
                      // * --- Write into jntestbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("jntestbo");
                      m_cPhName = m_Ctx.GetPhName("jntestbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_chiusura",164,"0000006C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(w_datchi,"D",8,0)+", ";
                      m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_closeall_age.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_closeall_age.GetString("RAPPORTO"))+"";
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
                      // * --- Write into jarantbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("jarantbo");
                      m_cPhName = m_Ctx.GetPhName("jarantbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jarantbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_chiusura",164,"0000006D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(w_datchi,"D",8,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jarantbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"DATAFINE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_closeall.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_closeall.GetString("RAPPORTO"))+"";
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
                    Cursor_japopebo.Next();
                  }
                  m_cConnectivityError = Cursor_japopebo.ErrorMessage();
                  Cursor_japopebo.Close();
                  // * --- End Select
                } // End If
                Cursor_qbe_closeall_age.Next();
              }
              m_cConnectivityError = Cursor_qbe_closeall_age.ErrorMessage();
              Cursor_qbe_closeall_age.Close();
              // * --- End Select
            } // End If
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
          } // End While
        } // End If
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000002Dstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000002Dstatus,cTry0000002Dmsg);
        }
      }
      /* gMsgImp := 'Elaborazione Terminata!' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Totale Informazioni: '+LRTrim(Str(imprec,10,0)) + NL // Messaggio Import */
      gMsgProc = gMsgProc+"Totale Informazioni: "+CPLib.LRTrim(CPLib.Str(imprec,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Fine chiusura rapporti alle ore: '+arfn_fdatetime(DateTime()) // Messaggio Import */
      gMsgProc = gMsgProc+"Fine chiusura rapporti alle ore: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_intestbo_macodice!=null)
          Cursor_qbe_intestbo_macodice.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_allinea_intesbo_macodice!=null)
          Cursor_qbe_allinea_intesbo_macodice.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_closeall_minmax!=null)
          Cursor_qbe_closeall_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_closeall!=null)
          Cursor_qbe_closeall.Close();
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
        if (Cursor_qbe_closeall_minmax_age!=null)
          Cursor_qbe_closeall_minmax_age.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_closeall_age!=null)
          Cursor_qbe_closeall_age.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_japopebo!=null)
          Cursor_japopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_qbe_closeall_minmax_age=null;
    CPResultSet Cursor_qbe_closeall_age=null;
    CPResultSet Cursor_japopebo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* gMsgImp := 'Inizio chiusura deleghe' // Messaggio Import */
      gMsgImp = "Inizio chiusura deleghe";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* imprec := 0 */
      imprec = CPLib.Round(0,0);
      /* Apertuture da AUI */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000078status;
      nTry00000078status = m_Sql.GetTransactionStatus();
      String cTry00000078msg;
      cTry00000078msg = m_Sql.TransactionErrorMessage();
      try {
        /* If w_tipoarch='A' */
        if (CPLib.eqr(w_tipoarch,"A")) {
          // * --- Select from delegabo
          m_cServer = m_Ctx.GetServer("delegabo");
          m_cPhName = m_Ctx.GetPhName("delegabo");
          if (Cursor_delegabo!=null)
            Cursor_delegabo.Close();
          Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO,CODINTER,CPROWNUM,STATOREG,DATAFINE,NUMPROG1  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("delegabo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_delegabo.Eof())) {
            /* If Empty(delegabo->DATAFINE) and delegabo->STATOREG<>'2' */
            if (CPLib.Empty(Cursor_delegabo.GetDate("DATAFINE")) && CPLib.ne(Cursor_delegabo.GetString("STATOREG"),"2")) {
              // * --- Select from rapopebo
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              if (Cursor_rapopebo!=null)
                Cursor_rapopebo.Close();
              Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_delegabo.GetString("RAPPORTO"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1')  and  (TIPOOPRAP='25'  or  TIPOOPRAP='39'  or  TIPOOPRAP='40')  and  NUMPROG="+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG1"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_rapopebo.Eof())) {
                /* If rapopebo->DATAOPE <= w_datchi */
                if (CPLib.le(Cursor_rapopebo.GetDate("DATAOPE"),w_datchi)) {
                  /* imprec := imprec + 1 */
                  imprec = CPLib.Round(imprec+1,0);
                  /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
                  cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                  /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
                  cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
                  /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                  /* gMsgImp := "Creazione Informazione di chiusura delega n.: "+LRTrim(Str(imprec,10,0)) // Messaggio Import */
                  gMsgImp = "Creazione Informazione di chiusura delega n.: "+CPLib.LRTrim(CPLib.Str(imprec,10,0));
                  m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  /* _idb2 := LibreriaMit.UniqueId() // Idbase */
                  _idb2 = LibreriaMit.UniqueId();
                  /* _idreg := 'I'+Right(cInfProg2,9)+_idb2 // Idbase */
                  _idreg = "I"+CPLib.Right(cInfProg2,9)+_idb2;
                  // * --- Insert into rapopebo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("rapopebo");
                  m_cPhName = m_Ctx.GetPhName("rapopebo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_chiusura",164,"00000085")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000085(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(w_datchi,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(w_datreg,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(w_causale,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_rapopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapopebo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(w_datchi),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(w_datreg),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
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
                  // * --- Write into delegabo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("delegabo");
                  m_cPhName = m_Ctx.GetPhName("delegabo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_chiusura",164,"00000086")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(w_datchi,"D",8,0)+", ";
                  m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"delegabo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("RAPPORTO"))+"";
                  m_cSql = m_cSql+" and NUMPROG1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG1"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("NUMPROG1"))+"";
                  m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetDouble("CPROWNUM"))+"";
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
            } // End If
            Cursor_delegabo.Next();
          }
          m_cConnectivityError = Cursor_delegabo.ErrorMessage();
          Cursor_delegabo.Close();
          // * --- End Select
          /* ElseIf w_tipoarch='E' */
        } else if (CPLib.eqr(w_tipoarch,"E")) {
          // * --- Select from qbe_closeall_minmax_age
          if (Cursor_qbe_closeall_minmax_age!=null)
            Cursor_qbe_closeall_minmax_age.Close();
          Cursor_qbe_closeall_minmax_age = new VQRHolder("qbe_closeall_minmax_age",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_closeall_minmax_age.Eof())) {
            /* _max := qbe_closeall_minmax_age->MAXPRGIMPSOG */
            _max = CPLib.Round(Cursor_qbe_closeall_minmax_age.GetDouble("MAXPRGIMPSOG"),0);
            /* _min := qbe_closeall_minmax_age->MINPRGIMPSOG */
            _min = CPLib.Round(Cursor_qbe_closeall_minmax_age.GetDouble("MINPRGIMPSOG"),0);
            Cursor_qbe_closeall_minmax_age.Next();
          }
          m_cConnectivityError = Cursor_qbe_closeall_minmax_age.ErrorMessage();
          Cursor_qbe_closeall_minmax_age.Close();
          // * --- End Select
          /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
          /* _conta := 1 */
          _conta = CPLib.Round(1,0);
          /* While _conta <= _cicli */
          while (CPLib.le(_conta,_cicli)) {
            /* _bottom := ((_conta -1 ) * 10000) + 1 */
            _bottom = CPLib.Round(((_conta-1)*10000)+1,0);
            /* _top := _conta * 10000 */
            _top = CPLib.Round(_conta*10000,0);
            /* If _top>=_min */
            if (CPLib.ge(_top,_min)) {
              // * --- Select from qbe_closeall_age
              if (Cursor_qbe_closeall_age!=null)
                Cursor_qbe_closeall_age.Close();
              Cursor_qbe_closeall_age = new VQRHolder("qbe_closeall_age",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_closeall_age.Eof())) {
                /* _closed := 0 */
                _closed = CPLib.Round(0,0);
                // * --- Select from japopebo
                m_cServer = m_Ctx.GetServer("japopebo");
                m_cPhName = m_Ctx.GetPhName("japopebo");
                if (Cursor_japopebo!=null)
                  Cursor_japopebo.Close();
                Cursor_japopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_closeall_age.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("japopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_japopebo.Eof())) {
                  /* If japopebo->TIPOOPRAP='26' or japopebo->TIPOOPRAP='36' or japopebo->TIPOOPRAP='46' or japopebo->TIPOOPRAP='38'  */
                  if (CPLib.eqr(Cursor_japopebo.GetString("TIPOOPRAP"),"26") || CPLib.eqr(Cursor_japopebo.GetString("TIPOOPRAP"),"36") || CPLib.eqr(Cursor_japopebo.GetString("TIPOOPRAP"),"46") || CPLib.eqr(Cursor_japopebo.GetString("TIPOOPRAP"),"38")) {
                    /* _closed := 1 */
                    _closed = CPLib.Round(1,0);
                  } // End If
                  Cursor_japopebo.Next();
                }
                m_cConnectivityError = Cursor_japopebo.ErrorMessage();
                Cursor_japopebo.Close();
                // * --- End Select
                /* If _closed=0 */
                if (CPLib.eqr(_closed,0)) {
                  // * --- Select from japopebo
                  m_cServer = m_Ctx.GetServer("japopebo");
                  m_cPhName = m_Ctx.GetPhName("japopebo");
                  if (Cursor_japopebo!=null)
                    Cursor_japopebo.Close();
                  Cursor_japopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_closeall_age.GetString("RAPPORTO"),"?",0,0)+"  and  TIPOOPRAP='23' "+")"+(m_Ctx.IsSharedTemp("japopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_japopebo.Eof())) {
                    /* If japopebo->DATAOPE <= w_datchi */
                    if (CPLib.le(Cursor_japopebo.GetDate("DATAOPE"),w_datchi)) {
                      /* imprec := imprec + 1 */
                      imprec = CPLib.Round(imprec+1,0);
                      /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
                      cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                      /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
                      cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
                      /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
                      nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                      /* gMsgImp := "Creazione Informazione di chiusura n.: "+LRTrim(Str(imprec,10,0)) // Messaggio Import */
                      gMsgImp = "Creazione Informazione di chiusura n.: "+CPLib.LRTrim(CPLib.Str(imprec,10,0));
                      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                      /* _idb2 := LibreriaMit.UniqueId() // Idbase */
                      _idb2 = LibreriaMit.UniqueId();
                      /* _idreg := 'I'+Right(cInfProg2,9)+_idb2 // Idbase */
                      _idreg = "I"+CPLib.Right(cInfProg2,9)+_idb2;
                      // * --- Insert into japopebo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("japopebo");
                      m_cPhName = m_Ctx.GetPhName("japopebo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japopebo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_chiusura",164,"0000009F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000009F(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(w_datchi,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_japopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(w_datreg,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("26","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japopebo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(w_datchi),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"japopebo",true);
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
                      // * --- Write into jntestbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("jntestbo");
                      m_cPhName = m_Ctx.GetPhName("jntestbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_chiusura",164,"000000A0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(w_datchi,"D",8,0)+", ";
                      m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_closeall_age.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_closeall_age.GetString("RAPPORTO"))+"";
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
                    Cursor_japopebo.Next();
                  }
                  m_cConnectivityError = Cursor_japopebo.ErrorMessage();
                  Cursor_japopebo.Close();
                  // * --- End Select
                } // End If
                Cursor_qbe_closeall_age.Next();
              }
              m_cConnectivityError = Cursor_qbe_closeall_age.ErrorMessage();
              Cursor_qbe_closeall_age.Close();
              // * --- End Select
            } // End If
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
          } // End While
        } // End If
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000078status,0)) {
          m_Sql.SetTransactionStatus(nTry00000078status,cTry00000078msg);
        }
      }
      /* gMsgImp := 'Fine chiusura deleghe. Totale Informazioni: '+LRTrim(Str(imprec,10,0)) // Messaggio Import */
      gMsgImp = "Fine chiusura deleghe. Totale Informazioni: "+CPLib.LRTrim(CPLib.Str(imprec,10,0));
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
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
        if (Cursor_qbe_closeall_minmax_age!=null)
          Cursor_qbe_closeall_minmax_age.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_closeall_age!=null)
          Cursor_qbe_closeall_age.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_japopebo!=null)
          Cursor_japopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_rapotit=null;
    try {
      /* gMsgImp := 'Inizio chiusura Titolari' // Messaggio Import */
      gMsgImp = "Inizio chiusura Titolari";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* imprec := 0 */
      imprec = CPLib.Round(0,0);
      /* Apertuture da AUI */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000000A9status;
      nTry000000A9status = m_Sql.GetTransactionStatus();
      String cTry000000A9msg;
      cTry000000A9msg = m_Sql.TransactionErrorMessage();
      try {
        /* If w_tipoarch='A' */
        if (CPLib.eqr(w_tipoarch,"A")) {
          // * --- Select from intestit
          m_cServer = m_Ctx.GetServer("intestit");
          m_cPhName = m_Ctx.GetPhName("intestit");
          if (Cursor_intestit!=null)
            Cursor_intestit.Close();
          Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intestit")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestit.Eof())) {
            /* If Empty(intestit->DATAFINE) and intestit->STATOREG<>'2' */
            if (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE")) && CPLib.ne(Cursor_intestit.GetString("STATOREG"),"2")) {
              /* imprec := imprec + 1 */
              imprec = CPLib.Round(imprec+1,0);
              /* cInfProg1 := Utilities.GetAutonumber("PRGTITO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cInfProg2 := Utilities.GetAutonumber("PRGTITO2\'"+LRTrim(gAzienda)+"'",'',11) */
              cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPTIT\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPTIT\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              /* gMsgImp := "Creazione Informazione di titolarità n.: "+LRTrim(Str(imprec,10,0)) // Messaggio Import */
              gMsgImp = "Creazione Informazione di titolarità n.: "+CPLib.LRTrim(CPLib.Str(imprec,10,0));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _idb2 := LibreriaMit.UniqueId() // Idbase */
              _idb2 = LibreriaMit.UniqueId();
              /* _idreg := 'T'+Right(cInfProg2,9)+_idb2 // Idbase */
              _idreg = "T"+CPLib.Right(cInfProg2,9)+_idb2;
              // * --- Select from rapotit
              m_cServer = m_Ctx.GetServer("rapotit");
              m_cPhName = m_Ctx.GetPhName("rapotit");
              if (Cursor_rapotit!=null)
                Cursor_rapotit.Close();
              Cursor_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_intestit.GetString("NUMPROG1"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1')  and  CONNESCLI="+CPLib.ToSQL(Cursor_intestit.GetString("CODCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("rapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_rapotit.Eof())) {
                // * --- Insert into rapotit from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("rapotit");
                m_cPhName = m_Ctx.GetPhName("rapotit");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_chiusura",164,"000000B5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000B5(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_datchi,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_datreg,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_causale,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("TOTLIRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("TOTCONT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(w_datchi),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(w_datreg),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
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
                // * --- Write into intestit from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestit");
                m_cPhName = m_Ctx.GetPhName("intestit");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestit",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_chiusura",164,"000000B6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(w_datchi,"D",8,0)+", ";
                m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cInfProg2,"C",11,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestit",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODCLI"),"?",0,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODCLI"))+"";
                m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODINTER"))+"";
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
                Cursor_rapotit.Next();
              }
              m_cConnectivityError = Cursor_rapotit.ErrorMessage();
              Cursor_rapotit.Close();
              // * --- End Select
            } // End If
            Cursor_intestit.Next();
          }
          m_cConnectivityError = Cursor_intestit.ErrorMessage();
          Cursor_intestit.Close();
          // * --- End Select
          /* ElseIf w_tipoarch='E' */
        } else if (CPLib.eqr(w_tipoarch,"E")) {
        } // End If
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000A9status,0)) {
          m_Sql.SetTransactionStatus(nTry000000A9status,cTry000000A9msg);
        }
      }
      /* gMsgImp := 'Fine chiusura titolari. Totale Informazioni: '+LRTrim(Str(imprec,10,0)) // Messaggio Import */
      gMsgImp = "Fine chiusura titolari. Totale Informazioni: "+CPLib.LRTrim(CPLib.Str(imprec,10,0));
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
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
  public String RunAsync(String p_pTipo) {
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
  public Forward Run(String p_pTipo) {
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
      m_Caller.SetDate("datchi","D",8,0,w_datchi);
      m_Caller.SetDate("datreg","D",8,0,w_datreg);
      m_Caller.SetString("tipoarch","C",1,0,w_tipoarch);
      m_Caller.SetString("causale","C",2,0,w_causale);
      m_Caller.SetString("macage","C",5,0,w_macage);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_chiusuraR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_chiusuraR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    w_datchi = m_Caller.GetDate("datchi","D",8,0);
    w_datreg = m_Caller.GetDate("datreg","D",8,0);
    w_tipoarch = m_Caller.GetString("tipoarch","C",1,0);
    w_causale = m_Caller.GetString("causale","C",2,0);
    w_macage = m_Caller.GetString("macage","C",5,0);
    _errlog = "";
    imprec = 0;
    _noprot = 0;
    _rapold = CPLib.Space(25);
    _tipoco = CPLib.Space(1);
    _nriga = 0;
    _newrow = 0;
    _conta = 0;
    _idriga = CPLib.Space(10);
    _bottom = 0;
    _top = 0;
    _max = 0;
    _cicli = 0;
    _min = 0;
    nProgImp = 0;
    cInfProg1 = CPLib.Space(10);
    cInfProg2 = CPLib.Space(11);
    _closed = 0;
    _delega = 0;
    _coddel = CPLib.Space(16);
    _nrow = 0;
    _idb2 = CPLib.Space(10);
    _idreg = CPLib.Space(20);
    _macodice = CPLib.Space(5);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_intestbo_macodice,qbe_allinea_intesbo_macodice,qbe_closeall_minmax,qbe_closeall,qbe_closeall_minmax_age,qbe_closeall_age,qbe_closeall_minmax_age,qbe_closeall_age,
  public static final String m_cVQRList = ",qbe_intestbo_macodice,qbe_allinea_intesbo_macodice,qbe_closeall_minmax,qbe_closeall,qbe_closeall_minmax_age,qbe_closeall_age,qbe_closeall_minmax_age,qbe_closeall_age,";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pTipo"};
  protected static String GetFieldsName_0000004F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"japopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000085(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"japopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPTIT,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapotit",true);
    return p_cSql;
  }
}
