// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_fam_stpperiodoR implements CallerWithObjs {
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
  public String m_cPhName_sid_invio;
  public String m_cServer_sid_invio;
  public String m_cPhName_sid_invio1;
  public String m_cServer_sid_invio1;
  public String m_cPhName_sid_invio2;
  public String m_cServer_sid_invio2;
  public String m_cPhName_sid_invio3;
  public String m_cServer_sid_invio3;
  public String m_cPhName_tmp_sid_invio1;
  public String m_cServer_tmp_sid_invio1;
  public String m_cPhName_tmp_sid_invio2;
  public String m_cServer_tmp_sid_invio2;
  public String m_cPhName_tmp_sid_invio3;
  public String m_cServer_tmp_sid_invio3;
  public String m_cPhName_tmp_sid_invio4;
  public String m_cServer_tmp_sid_invio4;
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
  java.util.concurrent.ConcurrentHashMap<String,CPSessionCache> i_oSPSessionCaches;
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public double w_dainviare;
  public double w_anno;
  public String w_mese;
  public String w_flgdett;
  public double _conta;
  public String _errore;
  public MemoryCursor_tmp_stpperiodo mcTemp;
  public MemoryCursorRow_tmp_stpperiodo rowTemp;
  public MemoryCursor_sid_invio mcSID0;
  public MemoryCursorRow_sid_invio rowSID0;
  public MemoryCursor_sid_invio1 mcSID1;
  public MemoryCursorRow_sid_invio1 rowSID1;
  public MemoryCursor_sid_invio2 mcSID2;
  public MemoryCursorRow_sid_invio2 rowSID2;
  public MemoryCursor_sid_invio2 mcSID2r;
  public MemoryCursor_sid_invio3 mcSID3;
  public MemoryCursorRow_sid_invio3 rowSID3;
  public MemoryCursor_sid_invio3 mcSID3r;
  public MemoryCursor_sid_invio4 mcSID4;
  public MemoryCursor_sid_invio4 mcSID4r;
  public double _crea;
  public double _stampa;
  public double _okrep;
  public double _asaldi;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public double _cicli;
  public String _oldmsg;
  public String _unique;
  public String _tipinvio;
  public double _reccount;
  public String w_annoc;
  public String _mese;
  public String chOpex;
  public String gMsgImp;
  public String gMsgProc;
  public String gDescAzi;
  public java.sql.Date gScadSaldi;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_fam_stpperiodoR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_fam_stpperiodo",m_Caller);
    m_cPhName_sid_invio = p_ContextObject.GetPhName("sid_invio");
    if (m_cPhName_sid_invio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio = m_cPhName_sid_invio+" "+m_Ctx.GetWritePhName("sid_invio");
    }
    m_cServer_sid_invio = p_ContextObject.GetServer("sid_invio");
    m_cPhName_sid_invio1 = p_ContextObject.GetPhName("sid_invio1");
    if (m_cPhName_sid_invio1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio1 = m_cPhName_sid_invio1+" "+m_Ctx.GetWritePhName("sid_invio1");
    }
    m_cServer_sid_invio1 = p_ContextObject.GetServer("sid_invio1");
    m_cPhName_sid_invio2 = p_ContextObject.GetPhName("sid_invio2");
    if (m_cPhName_sid_invio2.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio2 = m_cPhName_sid_invio2+" "+m_Ctx.GetWritePhName("sid_invio2");
    }
    m_cServer_sid_invio2 = p_ContextObject.GetServer("sid_invio2");
    m_cPhName_sid_invio3 = p_ContextObject.GetPhName("sid_invio3");
    if (m_cPhName_sid_invio3.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio3 = m_cPhName_sid_invio3+" "+m_Ctx.GetWritePhName("sid_invio3");
    }
    m_cServer_sid_invio3 = p_ContextObject.GetServer("sid_invio3");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio1")) {
      m_cPhName_tmp_sid_invio1 = p_ContextObject.GetPhName("tmp_sid_invio1");
      if (m_cPhName_tmp_sid_invio1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sid_invio1 = m_cPhName_tmp_sid_invio1+" "+m_Ctx.GetWritePhName("tmp_sid_invio1");
      }
      m_cServer_tmp_sid_invio1 = p_ContextObject.GetServer("tmp_sid_invio1");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio2")) {
      m_cPhName_tmp_sid_invio2 = p_ContextObject.GetPhName("tmp_sid_invio2");
      if (m_cPhName_tmp_sid_invio2.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sid_invio2 = m_cPhName_tmp_sid_invio2+" "+m_Ctx.GetWritePhName("tmp_sid_invio2");
      }
      m_cServer_tmp_sid_invio2 = p_ContextObject.GetServer("tmp_sid_invio2");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio3")) {
      m_cPhName_tmp_sid_invio3 = p_ContextObject.GetPhName("tmp_sid_invio3");
      if (m_cPhName_tmp_sid_invio3.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sid_invio3 = m_cPhName_tmp_sid_invio3+" "+m_Ctx.GetWritePhName("tmp_sid_invio3");
      }
      m_cServer_tmp_sid_invio3 = p_ContextObject.GetServer("tmp_sid_invio3");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio4")) {
      m_cPhName_tmp_sid_invio4 = p_ContextObject.GetPhName("tmp_sid_invio4");
      if (m_cPhName_tmp_sid_invio4.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sid_invio4 = m_cPhName_tmp_sid_invio4+" "+m_Ctx.GetWritePhName("tmp_sid_invio4");
      }
      m_cServer_tmp_sid_invio4 = p_ContextObject.GetServer("tmp_sid_invio4");
    }
    i_oSPSessionCaches = (java.util.concurrent.ConcurrentHashMap<String,CPSessionCache>)m_Ctx.GetGlobalObject("i_oSPSessionCaches",null);
    if (CPLib.IsNull(i_oSPSessionCaches)) {
      i_oSPSessionCaches = new java.util.concurrent.ConcurrentHashMap<String,CPSessionCache>();
      m_Ctx.SetGlobalObject("i_oSPSessionCaches",i_oSPSessionCaches);
    }
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("dainviare",p_cVarName)) {
      return w_dainviare;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_crea",p_cVarName)) {
      return _crea;
    }
    if (CPLib.eqr("_stampa",p_cVarName)) {
      return _stampa;
    }
    if (CPLib.eqr("_okrep",p_cVarName)) {
      return _okrep;
    }
    if (CPLib.eqr("_asaldi",p_cVarName)) {
      return _asaldi;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      return _contacicli;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_fam_stpperiodo";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("mese",p_cVarName)) {
      return w_mese;
    }
    if (CPLib.eqr("flgdett",p_cVarName)) {
      return w_flgdett;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("_unique",p_cVarName)) {
      return _unique;
    }
    if (CPLib.eqr("_tipinvio",p_cVarName)) {
      return _tipinvio;
    }
    if (CPLib.eqr("annoc",p_cVarName)) {
      return w_annoc;
    }
    if (CPLib.eqr("_mese",p_cVarName)) {
      return _mese;
    }
    if (CPLib.eqr("chOpex",p_cVarName)) {
      return chOpex;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      return w_DaDatOpe;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      return w_ADatOpe;
    }
    if (CPLib.eqr("gScadSaldi",p_cVarName)) {
      return gScadSaldi;
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
    if (CPLib.eqr("mcTemp",p_cVarName)) {
      return mcTemp;
    }
    if (CPLib.eqr("mcSID0",p_cVarName)) {
      return mcSID0;
    }
    if (CPLib.eqr("mcSID1",p_cVarName)) {
      return mcSID1;
    }
    if (CPLib.eqr("mcSID2",p_cVarName)) {
      return mcSID2;
    }
    if (CPLib.eqr("mcSID2r",p_cVarName)) {
      return mcSID2r;
    }
    if (CPLib.eqr("mcSID3",p_cVarName)) {
      return mcSID3;
    }
    if (CPLib.eqr("mcSID3r",p_cVarName)) {
      return mcSID3r;
    }
    if (CPLib.eqr("mcSID4",p_cVarName)) {
      return mcSID4;
    }
    if (CPLib.eqr("mcSID4r",p_cVarName)) {
      return mcSID4r;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowTemp",p_cVarName)) {
      return rowTemp;
    }
    if (CPLib.eqr("rowSID0",p_cVarName)) {
      return rowSID0;
    }
    if (CPLib.eqr("rowSID1",p_cVarName)) {
      return rowSID1;
    }
    if (CPLib.eqr("rowSID2",p_cVarName)) {
      return rowSID2;
    }
    if (CPLib.eqr("rowSID3",p_cVarName)) {
      return rowSID3;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("dainviare",p_cVarName)) {
      w_dainviare = value;
      return;
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_crea",p_cVarName)) {
      _crea = value;
      return;
    }
    if (CPLib.eqr("_stampa",p_cVarName)) {
      _stampa = value;
      return;
    }
    if (CPLib.eqr("_okrep",p_cVarName)) {
      _okrep = value;
      return;
    }
    if (CPLib.eqr("_asaldi",p_cVarName)) {
      _asaldi = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
      return;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      _contacicli = value;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("mese",p_cVarName)) {
      w_mese = value;
      return;
    }
    if (CPLib.eqr("flgdett",p_cVarName)) {
      w_flgdett = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("_unique",p_cVarName)) {
      _unique = value;
      return;
    }
    if (CPLib.eqr("_tipinvio",p_cVarName)) {
      _tipinvio = value;
      return;
    }
    if (CPLib.eqr("annoc",p_cVarName)) {
      w_annoc = value;
      return;
    }
    if (CPLib.eqr("_mese",p_cVarName)) {
      _mese = value;
      return;
    }
    if (CPLib.eqr("chOpex",p_cVarName)) {
      chOpex = value;
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
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      w_DaDatOpe = value;
      return;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      w_ADatOpe = value;
      return;
    }
    if (CPLib.eqr("gScadSaldi",p_cVarName)) {
      gScadSaldi = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowTemp",p_cVarName)) {
      rowTemp = (MemoryCursorRow_tmp_stpperiodo)value;
      return;
    }
    if (CPLib.eqr("rowSID0",p_cVarName)) {
      rowSID0 = (MemoryCursorRow_sid_invio)value;
      return;
    }
    if (CPLib.eqr("rowSID1",p_cVarName)) {
      rowSID1 = (MemoryCursorRow_sid_invio1)value;
      return;
    }
    if (CPLib.eqr("rowSID2",p_cVarName)) {
      rowSID2 = (MemoryCursorRow_sid_invio2)value;
      return;
    }
    if (CPLib.eqr("rowSID3",p_cVarName)) {
      rowSID3 = (MemoryCursorRow_sid_invio3)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcTemp",p_cVarName)) {
      mcTemp = (MemoryCursor_tmp_stpperiodo)value;
      return;
    }
    if (CPLib.eqr("mcSID0",p_cVarName)) {
      mcSID0 = (MemoryCursor_sid_invio)value;
      return;
    }
    if (CPLib.eqr("mcSID1",p_cVarName)) {
      mcSID1 = (MemoryCursor_sid_invio1)value;
      return;
    }
    if (CPLib.eqr("mcSID2",p_cVarName)) {
      mcSID2 = (MemoryCursor_sid_invio2)value;
      return;
    }
    if (CPLib.eqr("mcSID2r",p_cVarName)) {
      mcSID2r = (MemoryCursor_sid_invio2)value;
      return;
    }
    if (CPLib.eqr("mcSID3",p_cVarName)) {
      mcSID3 = (MemoryCursor_sid_invio3)value;
      return;
    }
    if (CPLib.eqr("mcSID3r",p_cVarName)) {
      mcSID3r = (MemoryCursor_sid_invio3)value;
      return;
    }
    if (CPLib.eqr("mcSID4",p_cVarName)) {
      mcSID4 = (MemoryCursor_sid_invio4)value;
      return;
    }
    if (CPLib.eqr("mcSID4r",p_cVarName)) {
      mcSID4r = (MemoryCursor_sid_invio4)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_fam_periodo01=null;
    CPResultSet Cursor_qbe_fam_periodo03=null;
    CPResultSet Cursor_qbe_fam_periodo05=null;
    CPResultSet Cursor_qbe_fam_delete_rap=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_dainviare Numeric(1, 0) */
      /* w_anno Numeric(4, 0) */
      /* w_mese Char(2) */
      /* w_flgdett Char(2) */
      /* _conta Numeric(10, 0) */
      /* _errore Memo */
      /* mcTemp MemoryCursor(tmp_stpperiodo) */
      /* rowTemp Row(tmp_stpperiodo) */
      /* mcSID0 MemoryCursor(sid_invio) */
      /* rowSID0 Row(sid_invio) */
      /* mcSID1 MemoryCursor(sid_invio1) */
      /* rowSID1 Row(sid_invio1) */
      /* mcSID2 MemoryCursor(sid_invio2) */
      /* rowSID2 Row(sid_invio2) */
      /* mcSID2r MemoryCursor(sid_invio2) */
      /* mcSID3 MemoryCursor(sid_invio3) */
      /* rowSID3 Row(sid_invio3) */
      /* mcSID3r MemoryCursor(sid_invio3) */
      /* mcSID4 MemoryCursor(sid_invio4) */
      /* mcSID4r MemoryCursor(sid_invio4) */
      /* _crea Numeric(1, 0) */
      /* _stampa Numeric(1, 0) */
      /* _okrep Numeric(1, 0) */
      /* _asaldi Numeric(4, 0) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _oldmsg Char(100) */
      /* _unique Char(50) */
      /* _tipinvio Char(1) */
      /* _reccount Numeric(0, 0) */
      /* w_annoc Char(4) */
      /* _mese Char(2) */
      /* chOpex Char(0) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gScadSaldi Date // Scadenza Invio Saldi */
      /* _okrep := 0 */
      _okrep = CPLib.Round(0,0);
      /* _stampa := 0 */
      _stampa = CPLib.Round(0,0);
      // * --- Create temporary table tmp_sid_invio1
      if (m_Ctx.IsSharedTemp("tmp_sid_invio1")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio1")) {
          m_cServer = m_Ctx.GetServer("tmp_sid_invio1");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio1");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_sid_invio1");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_sid_invio1");
      if ( ! (m_Ctx.IsSharedTemp("tmp_sid_invio1"))) {
        m_cServer = m_Ctx.GetServer("tmp_sid_invio1");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_sid_invio1",m_cServer,"proto")),m_cPhName,"tmp_sid_invio1",m_Ctx);
      }
      m_cPhName_tmp_sid_invio1 = m_cPhName;
      // * --- Create temporary table tmp_sid_invio2
      if (m_Ctx.IsSharedTemp("tmp_sid_invio2")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio2")) {
          m_cServer = m_Ctx.GetServer("tmp_sid_invio2");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio2");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_sid_invio2");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_sid_invio2");
      if ( ! (m_Ctx.IsSharedTemp("tmp_sid_invio2"))) {
        m_cServer = m_Ctx.GetServer("tmp_sid_invio2");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_sid_invio2",m_cServer,"proto")),m_cPhName,"tmp_sid_invio2",m_Ctx);
      }
      m_cPhName_tmp_sid_invio2 = m_cPhName;
      // * --- Create temporary table tmp_sid_invio3
      if (m_Ctx.IsSharedTemp("tmp_sid_invio3")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio3")) {
          m_cServer = m_Ctx.GetServer("tmp_sid_invio3");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio3");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_sid_invio3");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_sid_invio3");
      if ( ! (m_Ctx.IsSharedTemp("tmp_sid_invio3"))) {
        m_cServer = m_Ctx.GetServer("tmp_sid_invio3");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_sid_invio3",m_cServer,"proto")),m_cPhName,"tmp_sid_invio3",m_Ctx);
      }
      m_cPhName_tmp_sid_invio3 = m_cPhName;
      // * --- Create temporary table tmp_sid_invio4
      if (m_Ctx.IsSharedTemp("tmp_sid_invio4")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_sid_invio4")) {
          m_cServer = m_Ctx.GetServer("tmp_sid_invio4");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio4");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_sid_invio4");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_sid_invio4");
      if ( ! (m_Ctx.IsSharedTemp("tmp_sid_invio4"))) {
        m_cServer = m_Ctx.GetServer("tmp_sid_invio4");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_sid_invio4",m_cServer,"proto")),m_cPhName,"tmp_sid_invio4",m_Ctx);
      }
      m_cPhName_tmp_sid_invio4 = m_cPhName;
      // * --- Create cache chOpex
      // * --- Item di creazione fittizio. La cache viene effettivamente istanziata nel momento in cui viene utilizzata.
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000003Astatus;
      nTry0000003Astatus = m_Sql.GetTransactionStatus();
      String cTry0000003Amsg;
      cTry0000003Amsg = m_Sql.TransactionErrorMessage();
      try {
        /* w_annoc := Str(w_anno,4,0) */
        w_annoc = CPLib.Str(w_anno,4,0);
        /* _mese := w_mese */
        _mese = w_mese;
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* gMsgProc := 'Ora Inizio  Elaborazione periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = "Ora Inizio  Elaborazione periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + "Estrazione dati per il periodo" + NL // Messaggio */
        gMsgProc = gMsgProc+"Estrazione dati per il periodo"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := "Attendere. Estrazione dati per il periodo ..." // Messaggio Import */
        gMsgImp = "Attendere. Estrazione dati per il periodo ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _tipinvio := '1' */
        _tipinvio = "1";
        /* If Date() >  arfn_finemese(arfn_datesum(w_ADatOpe,1)) */
        if (CPLib.gt(CPLib.Date(),arfn_finemeseR.Make(m_Ctx,this).Run(arfn_datesumR.Make(m_Ctx,this).Run(w_ADatOpe,1)))) {
          /* _tipinvio := '2' */
          _tipinvio = "2";
        } // End If
        /* gMsgProc := gMsgProc + 'Ora Inizio controllo nuovi invii periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Inizio controllo nuovi invii periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Fill memory cursor mcTemp on qbe_fam_periodo01
        mcTemp.Zap();
        SPBridge.HMCaller _h00000047;
        _h00000047 = new SPBridge.HMCaller();
        _h00000047.Set("m_cVQRList",m_cVQRList);
        _h00000047.Set("_dadata",w_DaDatOpe);
        _h00000047.Set("_adata",w_ADatOpe);
        _h00000047.Set("_inviato",w_dainviare);
        if (Cursor_qbe_fam_periodo01!=null)
          Cursor_qbe_fam_periodo01.Close();
        Cursor_qbe_fam_periodo01 = new VQRHolder("qbe_fam_periodo01",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000047,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_fam_periodo01;
          Cursor_qbe_fam_periodo01.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_fam_stpperiodo: query on qbe_fam_periodo01 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_fam_periodo01.Eof())) {
          mcTemp.AppendBlank();
          mcTemp.row.RAPPORTO = Cursor_qbe_fam_periodo01.GetString("RAPPORTO");
          mcTemp.row.DATAINI = Cursor_qbe_fam_periodo01.GetDate("DATAINI");
          mcTemp.row.DATAFINE = Cursor_qbe_fam_periodo01.GetDate("DATAFINE");
          mcTemp.row.TIPOAG = Cursor_qbe_fam_periodo01.GetString("TIPOAG");
          mcTemp.row.TIPORAP = Cursor_qbe_fam_periodo01.GetString("TIPORAP");
          mcTemp.row.DESCRAP = Cursor_qbe_fam_periodo01.GetString("DESCRAP");
          mcTemp.row.VALUTA = Cursor_qbe_fam_periodo01.GetString("VALUTA");
          mcTemp.row.INVIATO = Cursor_qbe_fam_periodo01.GetDouble("INVIATO");
          mcTemp.row.TIPO = Cursor_qbe_fam_periodo01.GetString("TIPO");
          mcTemp.row.CAB = Cursor_qbe_fam_periodo01.GetString("CAB");
          mcTemp.row.UNIQUECODE = Cursor_qbe_fam_periodo01.GetString("UNIQUECODE");
          mcTemp.row.OLDINTER = Cursor_qbe_fam_periodo01.GetString("OLDINTER");
          mcTemp.row.IDBASE = Cursor_qbe_fam_periodo01.GetString("IDBASE");
          mcTemp.row.DATAMODI = Cursor_qbe_fam_periodo01.GetDate("DATAMODI");
          mcTemp.row.IDESITO = Cursor_qbe_fam_periodo01.GetString("IDESITO");
          mcTemp.row.ISOAGE = Cursor_qbe_fam_periodo01.GetString("ISOAGE");
          Cursor_qbe_fam_periodo01.Next();
        }
        m_cConnectivityError = Cursor_qbe_fam_periodo01.ErrorMessage();
        Cursor_qbe_fam_periodo01.Close();
        mcTemp.GoTop();
        /* _crea := 0 */
        _crea = CPLib.Round(0,0);
        for (MemoryCursorRow_tmp_stpperiodo rowTemp : mcTemp._iterable_()) {
          /* If _crea=0 */
          if (CPLib.eqr(_crea,0)) {
            /* rowSID0.CODINVIO := DateToChar(Date())+_tipinvio+"1" */
            rowSID0.CODINVIO = CPLib.DateToChar(CPLib.Date())+_tipinvio+"1";
            /* rowSID0.TIPINVIO := _tipinvio */
            rowSID0.TIPINVIO = _tipinvio;
            /* rowSID0.TPCINVIO := '1' */
            rowSID0.TPCINVIO = "1";
            /* rowSID0.ANNINVIO := Str(Year(w_DaDatOpe),4,0) */
            rowSID0.ANNINVIO = CPLib.Str(CPLib.Year(w_DaDatOpe),4,0);
            /* rowSID0.MESINVIO := iif(Month(w_DaDatOpe)<=9,'0'+Str(Month(w_DaDatOpe),1,0),Str(Month(w_DaDatOpe),2,0)) */
            rowSID0.MESINVIO = (CPLib.le(CPLib.Month(w_DaDatOpe),9)?"0"+CPLib.Str(CPLib.Month(w_DaDatOpe),1,0):CPLib.Str(CPLib.Month(w_DaDatOpe),2,0));
            /* mcSID0.AppendRow(rowSID0) */
            mcSID0.AppendRow(rowSID0);
            /* _crea := 1 */
            _crea = CPLib.Round(1,0);
          } // End If
          /* gMsgImp := 'Sono stati effettuati '+LRTrim(Str(_conta,10,0))+" controlli" // Messaggio Import */
          gMsgImp = "Sono stati effettuati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" controlli";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* rowSID1.CODINVIO1 := DateToChar(Date())+_tipinvio+"1" */
          rowSID1.CODINVIO1 = CPLib.DateToChar(CPLib.Date())+_tipinvio+"1";
          /* rowSID1.RAPINVIO1 := rowTemp.RAPPORTO */
          rowSID1.RAPINVIO1 = rowTemp.RAPPORTO;
          /* rowSID1.TPRINVIO1 := rowTemp.TIPOAG */
          rowSID1.TPRINVIO1 = rowTemp.TIPOAG;
          /* rowSID1.INIINVIO1 := rowTemp.DATAINI */
          rowSID1.INIINVIO1 = rowTemp.DATAINI;
          /* If _tipinvio='2' */
          if (CPLib.eqr(_tipinvio,"2")) {
            /* rowSID1.FININVIO1 := iif(not(Empty(rowTemp.DATAFINE)),rowTemp.DATAFINE,NullDate()) */
            rowSID1.FININVIO1 = ( ! (CPLib.Empty(rowTemp.DATAFINE))?rowTemp.DATAFINE:CPLib.NullDate());
          } else { // Else
            /* rowSID1.FININVIO1 := iif(rowTemp.DATAFINE>=w_DaDatOpe and rowTemp.DATAFINE<=w_ADatOpe,rowTemp.DATAFINE,NullDate()) */
            rowSID1.FININVIO1 = (CPLib.ge(rowTemp.DATAFINE,w_DaDatOpe) && CPLib.le(rowTemp.DATAFINE,w_ADatOpe)?rowTemp.DATAFINE:CPLib.NullDate());
          } // End If
          /* rowSID1.TIPINVIO1 := _tipinvio */
          rowSID1.TIPINVIO1 = _tipinvio;
          /* rowSID1.TPCINVIO1 := '1' */
          rowSID1.TPCINVIO1 = "1";
          /* mcSID1.AppendRow(rowSID1) */
          mcSID1.AppendRow(rowSID1);
          /* mcSID2r := arfn_fam_mesefile02(rowSID1,w_DaDatOpe,w_ADatOpe,rowTemp.TIPO) */
          mcSID2r = arfn_fam_mesefile02R.Make(m_Ctx,this).Run(rowSID1,w_DaDatOpe,w_ADatOpe,rowTemp.TIPO);
          for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2r._iterable_()) {
            /* mcSID2.AppendRow(rowSID2) */
            mcSID2.AppendRow(rowSID2);
          }
          /* If _tipinvio='2' */
          if (CPLib.eqr(_tipinvio,"2")) {
            /* If At(rowTemp.TIPOAG,"01;02;03;04;05;06;07;09;10;12;14;15;23;24;98") <> 0 */
            if (CPLib.ne(CPLib.At(rowTemp.TIPOAG,"01;02;03;04;05;06;07;09;10;12;14;15;23;24;98"),0)) {
              /* _asaldi := iif(DateDiff(gScadSaldi,Date()) < 90,Year(Date())-2,Year(Date())-1) */
              _asaldi = CPLib.Round((CPLib.lt(CPLib.DateDiff(gScadSaldi,CPLib.Date()),90)?CPLib.Year(CPLib.Date())-2:CPLib.Year(CPLib.Date())-1),0);
              /* mcSID3r := arfn_fam_mesefile03(rowSID1,_asaldi,rowTemp.TIPO,rowTemp.VALUTA) */
              mcSID3r = arfn_fam_mesefile03R.Make(m_Ctx,this).Run(rowSID1,_asaldi,rowTemp.TIPO,rowTemp.VALUTA);
              for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3r._iterable_()) {
                /* mcSID3.AppendRow(rowSID3) */
                mcSID3.AppendRow(rowSID3);
              }
            } // End If
          } // End If
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
        }
        /* Exec "Operazioni Extraconto" Page 2:Page_2 */
        Page_2();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* gMsgProc := gMsgProc + 'Ora Fine controllo nuovi invii periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine controllo nuovi invii periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Inizio controllo chiusure periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Inizio controllo chiusure periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _tipinvio := '1' */
        _tipinvio = "1";
        /* If Date() >  arfn_finemese(arfn_datesum(w_ADatOpe,1)) */
        if (CPLib.gt(CPLib.Date(),arfn_finemeseR.Make(m_Ctx,this).Run(arfn_datesumR.Make(m_Ctx,this).Run(w_ADatOpe,1)))) {
          /* _tipinvio := '2' */
          _tipinvio = "2";
        } // End If
        // * --- Fill memory cursor mcTemp on qbe_fam_periodo03
        mcTemp.Zap();
        SPBridge.HMCaller _h0000006F;
        _h0000006F = new SPBridge.HMCaller();
        _h0000006F.Set("m_cVQRList",m_cVQRList);
        _h0000006F.Set("_dadata",w_DaDatOpe);
        _h0000006F.Set("_adata",w_ADatOpe);
        _h0000006F.Set("_inviato",w_dainviare);
        if (Cursor_qbe_fam_periodo03!=null)
          Cursor_qbe_fam_periodo03.Close();
        Cursor_qbe_fam_periodo03 = new VQRHolder("qbe_fam_periodo03",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000006F,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_fam_periodo03;
          Cursor_qbe_fam_periodo03.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_fam_stpperiodo: query on qbe_fam_periodo03 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_fam_periodo03.Eof())) {
          mcTemp.AppendBlank();
          mcTemp.row.RAPPORTO = Cursor_qbe_fam_periodo03.GetString("RAPPORTO");
          mcTemp.row.DATAINI = Cursor_qbe_fam_periodo03.GetDate("DATAINI");
          mcTemp.row.DATAFINE = Cursor_qbe_fam_periodo03.GetDate("DATAFINE");
          mcTemp.row.TIPOAG = Cursor_qbe_fam_periodo03.GetString("TIPOAG");
          mcTemp.row.TIPORAP = Cursor_qbe_fam_periodo03.GetString("TIPORAP");
          mcTemp.row.DESCRAP = Cursor_qbe_fam_periodo03.GetString("DESCRAP");
          mcTemp.row.VALUTA = Cursor_qbe_fam_periodo03.GetString("VALUTA");
          mcTemp.row.INVIATO = Cursor_qbe_fam_periodo03.GetDouble("INVIATO");
          mcTemp.row.TIPO = Cursor_qbe_fam_periodo03.GetString("TIPO");
          mcTemp.row.CAB = Cursor_qbe_fam_periodo03.GetString("CAB");
          mcTemp.row.UNIQUECODE = Cursor_qbe_fam_periodo03.GetString("UNIQUECODE");
          mcTemp.row.OLDINTER = Cursor_qbe_fam_periodo03.GetString("OLDINTER");
          mcTemp.row.IDBASE = Cursor_qbe_fam_periodo03.GetString("IDBASE");
          mcTemp.row.DATAMODI = Cursor_qbe_fam_periodo03.GetDate("DATAMODI");
          mcTemp.row.IDESITO = Cursor_qbe_fam_periodo03.GetString("IDESITO");
          mcTemp.row.ISOAGE = Cursor_qbe_fam_periodo03.GetString("ISOAGE");
          Cursor_qbe_fam_periodo03.Next();
        }
        m_cConnectivityError = Cursor_qbe_fam_periodo03.ErrorMessage();
        Cursor_qbe_fam_periodo03.Close();
        mcTemp.GoTop();
        /* _crea := 0 */
        _crea = CPLib.Round(0,0);
        for (MemoryCursorRow_tmp_stpperiodo rowTemp : mcTemp._iterable_()) {
          /* If _tipinvio='1' */
          if (CPLib.eqr(_tipinvio,"1")) {
            /* If _crea=0 */
            if (CPLib.eqr(_crea,0)) {
              /* rowSID0.CODINVIO := DateToChar(Date())+"15" */
              rowSID0.CODINVIO = CPLib.DateToChar(CPLib.Date())+"15";
              /* rowSID0.TIPINVIO := '1' */
              rowSID0.TIPINVIO = "1";
              /* rowSID0.TPCINVIO := '5' */
              rowSID0.TPCINVIO = "5";
              /* rowSID0.ANNINVIO := Str(Year(w_DaDatOpe),4,0) */
              rowSID0.ANNINVIO = CPLib.Str(CPLib.Year(w_DaDatOpe),4,0);
              /* rowSID0.MESINVIO := iif(Month(w_DaDatOpe)<=9,'0'+Str(Month(w_DaDatOpe),1,0),Str(Month(w_DaDatOpe),2,0)) */
              rowSID0.MESINVIO = (CPLib.le(CPLib.Month(w_DaDatOpe),9)?"0"+CPLib.Str(CPLib.Month(w_DaDatOpe),1,0):CPLib.Str(CPLib.Month(w_DaDatOpe),2,0));
              /* mcSID0.AppendRow(rowSID0) */
              mcSID0.AppendRow(rowSID0);
              /* _crea := 1 */
              _crea = CPLib.Round(1,0);
            } // End If
            /* gMsgImp := 'Sono stati effettuati '+LRTrim(Str(_conta,10,0))+" controlli" // Messaggio Import */
            gMsgImp = "Sono stati effettuati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" controlli";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* rowSID1.CODINVIO1 := DateToChar(Date())+"15" */
            rowSID1.CODINVIO1 = CPLib.DateToChar(CPLib.Date())+"15";
            /* rowSID1.RAPINVIO1 := rowTemp.RAPPORTO */
            rowSID1.RAPINVIO1 = rowTemp.RAPPORTO;
            /* rowSID1.TPRINVIO1 := rowTemp.TIPOAG */
            rowSID1.TPRINVIO1 = rowTemp.TIPOAG;
            /* rowSID1.INIINVIO1 := rowTemp.DATAINI */
            rowSID1.INIINVIO1 = rowTemp.DATAINI;
            /* rowSID1.FININVIO1 := iif(rowTemp.DATAFINE>=w_DaDatOpe and rowTemp.DATAFINE<=w_ADatOpe,rowTemp.DATAFINE,NullDate()) */
            rowSID1.FININVIO1 = (CPLib.ge(rowTemp.DATAFINE,w_DaDatOpe) && CPLib.le(rowTemp.DATAFINE,w_ADatOpe)?rowTemp.DATAFINE:CPLib.NullDate());
            /* rowSID1.TIPINVIO1 := '1' */
            rowSID1.TIPINVIO1 = "1";
            /* rowSID1.TPCINVIO1 := '5' */
            rowSID1.TPCINVIO1 = "5";
            /* mcSID1.AppendRow(rowSID1) */
            mcSID1.AppendRow(rowSID1);
            /* If w_flgdett='S' */
            if (CPLib.eqr(w_flgdett,"S")) {
              /* mcSID2r := arfn_fam_mesefile02(rowSID1,w_DaDatOpe,w_ADatOpe,rowTemp.TIPO) */
              mcSID2r = arfn_fam_mesefile02R.Make(m_Ctx,this).Run(rowSID1,w_DaDatOpe,w_ADatOpe,rowTemp.TIPO);
              for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2r._iterable_()) {
                /* mcSID2.AppendRow(rowSID2) */
                mcSID2.AppendRow(rowSID2);
              }
            } // End If
          } else { // Else
            /* If _crea=0 */
            if (CPLib.eqr(_crea,0)) {
              /* rowSID0.CODINVIO := DateToChar(Date())+"22" */
              rowSID0.CODINVIO = CPLib.DateToChar(CPLib.Date())+"22";
              /* rowSID0.TIPINVIO := '2' */
              rowSID0.TIPINVIO = "2";
              /* rowSID0.TPCINVIO := '2' */
              rowSID0.TPCINVIO = "2";
              /* rowSID0.ANNINVIO := Str(w_anno,4,0) */
              rowSID0.ANNINVIO = CPLib.Str(w_anno,4,0);
              /* rowSID0.MESINVIO := w_mese */
              rowSID0.MESINVIO = w_mese;
              /* mcSID0.AppendRow(rowSID0) */
              mcSID0.AppendRow(rowSID0);
              /* _crea := 1 */
              _crea = CPLib.Round(1,0);
            } // End If
            /* gMsgImp := 'Sono stati effettuati '+LRTrim(Str(_conta,10,0))+" controlli" // Messaggio Import */
            gMsgImp = "Sono stati effettuati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" controlli";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* rowSID1.CODINVIO1 := DateToChar(Date())+"22" */
            rowSID1.CODINVIO1 = CPLib.DateToChar(CPLib.Date())+"22";
            /* rowSID1.RAPINVIO1 := rowTemp.RAPPORTO */
            rowSID1.RAPINVIO1 = rowTemp.RAPPORTO;
            /* rowSID1.TPRINVIO1 := rowTemp.TIPOAG */
            rowSID1.TPRINVIO1 = rowTemp.TIPOAG;
            /* rowSID1.INIINVIO1 := rowTemp.DATAINI */
            rowSID1.INIINVIO1 = rowTemp.DATAINI;
            /* rowSID1.FININVIO1 := rowTemp.DATAFINE */
            rowSID1.FININVIO1 = rowTemp.DATAFINE;
            /* rowSID1.TIPINVIO1 := '2' */
            rowSID1.TIPINVIO1 = "2";
            /* rowSID1.TPCINVIO1 := '2' */
            rowSID1.TPCINVIO1 = "2";
            /* mcSID1.AppendRow(rowSID1) */
            mcSID1.AppendRow(rowSID1);
            /* mcSID2r := arfn_fam_mesefile02(rowSID1,w_DaDatOpe,w_ADatOpe,rowTemp.TIPO) */
            mcSID2r = arfn_fam_mesefile02R.Make(m_Ctx,this).Run(rowSID1,w_DaDatOpe,w_ADatOpe,rowTemp.TIPO);
            for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2r._iterable_()) {
              /* mcSID2.AppendRow(rowSID2) */
              mcSID2.AppendRow(rowSID2);
            }
            /* If At(rowTemp.TIPOAG,"01;02;03;04;05;06;07;09;10;12;14;15;23;24;98") <> 0 */
            if (CPLib.ne(CPLib.At(rowTemp.TIPOAG,"01;02;03;04;05;06;07;09;10;12;14;15;23;24;98"),0)) {
              /* If rowTemp.TIPOAG <> '98' */
              if (CPLib.ne(rowTemp.TIPOAG,"98")) {
                /* _asaldi := iif(DateDiff(gScadSaldi,Date()) <= 90,Year(Date())-2,Year(Date())-1) */
                _asaldi = CPLib.Round((CPLib.le(CPLib.DateDiff(gScadSaldi,CPLib.Date()),90)?CPLib.Year(CPLib.Date())-2:CPLib.Year(CPLib.Date())-1),0);
              } else { // Else
                /* If (Year(Date()) -Year(rowTemp.DATAINI)=1 and DateDiff(gScadSaldi,Date()) <= 90) or (Year(Date()) -Year(rowTemp.DATAINI)=0) */
                if ((CPLib.eqr(CPLib.Year(CPLib.Date())-CPLib.Year(rowTemp.DATAINI),1) && CPLib.le(CPLib.DateDiff(gScadSaldi,CPLib.Date()),90)) || (CPLib.eqr(CPLib.Year(CPLib.Date())-CPLib.Year(rowTemp.DATAINI),0))) {
                  /* _asaldi := 0 */
                  _asaldi = CPLib.Round(0,0);
                } else { // Else
                  /* _asaldi := Year(rowTemp.DATAINI) */
                  _asaldi = CPLib.Round(CPLib.Year(rowTemp.DATAINI),0);
                } // End If
              } // End If
              /* mcSID3r := arfn_fam_mesefile03(rowSID1,_asaldi,rowTemp.TIPO,rowTemp.VALUTA) */
              mcSID3r = arfn_fam_mesefile03R.Make(m_Ctx,this).Run(rowSID1,_asaldi,rowTemp.TIPO,rowTemp.VALUTA);
              for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3r._iterable_()) {
                /* mcSID3.AppendRow(rowSID3) */
                mcSID3.AppendRow(rowSID3);
              }
            } // End If
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
          } // End If
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
        }
        /* gMsgProc := gMsgProc + 'Ora Fine controllo chiusure periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine controllo chiusure periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Inizio controllo rettifiche periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Inizio controllo rettifiche periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Fill memory cursor mcTemp on qbe_fam_periodo05
        mcTemp.Zap();
        SPBridge.HMCaller _h000000AC;
        _h000000AC = new SPBridge.HMCaller();
        _h000000AC.Set("m_cVQRList",m_cVQRList);
        _h000000AC.Set("_dadata",w_DaDatOpe);
        _h000000AC.Set("_adata",w_ADatOpe);
        if (Cursor_qbe_fam_periodo05!=null)
          Cursor_qbe_fam_periodo05.Close();
        Cursor_qbe_fam_periodo05 = new VQRHolder("qbe_fam_periodo05",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000AC,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_fam_periodo05;
          Cursor_qbe_fam_periodo05.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_fam_stpperiodo: query on qbe_fam_periodo05 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_fam_periodo05.Eof())) {
          mcTemp.AppendBlank();
          mcTemp.row.RAPPORTO = Cursor_qbe_fam_periodo05.GetString("RAPPORTO");
          mcTemp.row.DATAINI = Cursor_qbe_fam_periodo05.GetDate("DATAINI");
          mcTemp.row.DATAFINE = Cursor_qbe_fam_periodo05.GetDate("DATAFINE");
          mcTemp.row.TIPOAG = Cursor_qbe_fam_periodo05.GetString("TIPOAG");
          mcTemp.row.TIPORAP = Cursor_qbe_fam_periodo05.GetString("TIPORAP");
          mcTemp.row.DESCRAP = Cursor_qbe_fam_periodo05.GetString("DESCRAP");
          mcTemp.row.VALUTA = Cursor_qbe_fam_periodo05.GetString("VALUTA");
          mcTemp.row.INVIATO = Cursor_qbe_fam_periodo05.GetDouble("INVIATO");
          mcTemp.row.TIPO = Cursor_qbe_fam_periodo05.GetString("TIPO");
          mcTemp.row.CAB = Cursor_qbe_fam_periodo05.GetString("CAB");
          mcTemp.row.UNIQUECODE = Cursor_qbe_fam_periodo05.GetString("UNIQUECODE");
          mcTemp.row.OLDINTER = Cursor_qbe_fam_periodo05.GetString("OLDINTER");
          mcTemp.row.IDBASE = Cursor_qbe_fam_periodo05.GetString("IDBASE");
          mcTemp.row.DATAMODI = Cursor_qbe_fam_periodo05.GetDate("DATAMODI");
          mcTemp.row.IDESITO = Cursor_qbe_fam_periodo05.GetString("IDESITO");
          mcTemp.row.ISOAGE = Cursor_qbe_fam_periodo05.GetString("ISOAGE");
          Cursor_qbe_fam_periodo05.Next();
        }
        m_cConnectivityError = Cursor_qbe_fam_periodo05.ErrorMessage();
        Cursor_qbe_fam_periodo05.Close();
        mcTemp.GoTop();
        /* _crea := 0 */
        _crea = CPLib.Round(0,0);
        for (MemoryCursorRow_tmp_stpperiodo rowTemp : mcTemp._iterable_()) {
          /* If _crea=0 */
          if (CPLib.eqr(_crea,0)) {
            /* rowSID0.CODINVIO := DateToChar(Date())+"22" */
            rowSID0.CODINVIO = CPLib.DateToChar(CPLib.Date())+"22";
            /* rowSID0.TIPINVIO := '2' */
            rowSID0.TIPINVIO = "2";
            /* rowSID0.TPCINVIO := '2' */
            rowSID0.TPCINVIO = "2";
            /* rowSID0.ANNINVIO := Str(w_anno,4,0) */
            rowSID0.ANNINVIO = CPLib.Str(w_anno,4,0);
            /* rowSID0.MESINVIO := w_mese */
            rowSID0.MESINVIO = w_mese;
            /* mcSID0.AppendRow(rowSID0) */
            mcSID0.AppendRow(rowSID0);
            /* _crea := 1 */
            _crea = CPLib.Round(1,0);
          } // End If
          /* gMsgImp := 'Sono stati effettuati '+LRTrim(Str(_conta,10,0))+" controlli" // Messaggio Import */
          gMsgImp = "Sono stati effettuati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" controlli";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* rowSID1.CODINVIO1 := DateToChar(Date())+"22" */
          rowSID1.CODINVIO1 = CPLib.DateToChar(CPLib.Date())+"22";
          /* rowSID1.RAPINVIO1 := rowTemp.RAPPORTO */
          rowSID1.RAPINVIO1 = rowTemp.RAPPORTO;
          /* rowSID1.TPRINVIO1 := rowTemp.TIPOAG */
          rowSID1.TPRINVIO1 = rowTemp.TIPOAG;
          /* rowSID1.INIINVIO1 := rowTemp.DATAINI */
          rowSID1.INIINVIO1 = rowTemp.DATAINI;
          /* rowSID1.FININVIO1 := rowTemp.DATAFINE */
          rowSID1.FININVIO1 = rowTemp.DATAFINE;
          /* rowSID1.TIPINVIO1 := '2' */
          rowSID1.TIPINVIO1 = "2";
          /* rowSID1.TPCINVIO1 := '2' */
          rowSID1.TPCINVIO1 = "2";
          /* mcSID1.AppendRow(rowSID1) */
          mcSID1.AppendRow(rowSID1);
          /* mcSID2r := arfn_fam_mesefile02(rowSID1,w_DaDatOpe,w_ADatOpe,rowTemp.TIPO) */
          mcSID2r = arfn_fam_mesefile02R.Make(m_Ctx,this).Run(rowSID1,w_DaDatOpe,w_ADatOpe,rowTemp.TIPO);
          for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2r._iterable_()) {
            /* mcSID2.AppendRow(rowSID2) */
            mcSID2.AppendRow(rowSID2);
          }
          /* If At(rowTemp.TIPOAG,"01;02;03;04;05;06;07;09;10;12;14;15;23;24;98") <> 0 */
          if (CPLib.ne(CPLib.At(rowTemp.TIPOAG,"01;02;03;04;05;06;07;09;10;12;14;15;23;24;98"),0)) {
            /* If rowTemp.TIPOAG <> '98' */
            if (CPLib.ne(rowTemp.TIPOAG,"98")) {
              /* _asaldi := iif(Date() <= gScadSaldi,Year(Date())-2,Year(Date())-1) */
              _asaldi = CPLib.Round((CPLib.le(CPLib.Date(),gScadSaldi)?CPLib.Year(CPLib.Date())-2:CPLib.Year(CPLib.Date())-1),0);
            } else { // Else
              /* If (Year(Date()) -Year(rowTemp.DATAINI)=1 and Date() <= gScadSaldi) or (Year(Date()) -Year(rowTemp.DATAINI)=0) */
              if ((CPLib.eqr(CPLib.Year(CPLib.Date())-CPLib.Year(rowTemp.DATAINI),1) && CPLib.le(CPLib.Date(),gScadSaldi)) || (CPLib.eqr(CPLib.Year(CPLib.Date())-CPLib.Year(rowTemp.DATAINI),0))) {
                /* _asaldi := 0 */
                _asaldi = CPLib.Round(0,0);
              } else { // Else
                /* _asaldi := Year(rowTemp.DATAINI) */
                _asaldi = CPLib.Round(CPLib.Year(rowTemp.DATAINI),0);
              } // End If
            } // End If
            /* mcSID3r := arfn_fam_mesefile03(rowSID1,_asaldi,rowTemp.TIPO,rowTemp.VALUTA) */
            mcSID3r = arfn_fam_mesefile03R.Make(m_Ctx,this).Run(rowSID1,_asaldi,rowTemp.TIPO,rowTemp.VALUTA);
            for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3r._iterable_()) {
              /* mcSID3.AppendRow(rowSID3) */
              mcSID3.AppendRow(rowSID3);
            }
          } // End If
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
        }
        /* gMsgProc := gMsgProc + 'Ora Fine controllo rettifiche periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine controllo rettifiche periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Inizio controllo cancellazioni periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Inizio controllo cancellazioni periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Fill memory cursor mcTemp on qbe_fam_delete_rap
        mcTemp.Zap();
        SPBridge.HMCaller _h000000D1;
        _h000000D1 = new SPBridge.HMCaller();
        _h000000D1.Set("m_cVQRList",m_cVQRList);
        _h000000D1.Set("_dadata",w_DaDatOpe);
        _h000000D1.Set("_adata",w_ADatOpe);
        if (Cursor_qbe_fam_delete_rap!=null)
          Cursor_qbe_fam_delete_rap.Close();
        Cursor_qbe_fam_delete_rap = new VQRHolder("qbe_fam_delete_rap",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000D1,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_fam_delete_rap;
          Cursor_qbe_fam_delete_rap.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_fam_stpperiodo: query on qbe_fam_delete_rap returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_fam_delete_rap.Eof())) {
          mcTemp.AppendBlank();
          mcTemp.row.RAPPORTO = Cursor_qbe_fam_delete_rap.GetString("RAPPORTO");
          mcTemp.row.DATAINI = Cursor_qbe_fam_delete_rap.GetDate("DATAINI");
          mcTemp.row.DATAFINE = Cursor_qbe_fam_delete_rap.GetDate("DATAFINE");
          mcTemp.row.TIPOAG = Cursor_qbe_fam_delete_rap.GetString("TIPOAG");
          mcTemp.row.TIPORAP = Cursor_qbe_fam_delete_rap.GetString("TIPORAP");
          mcTemp.row.DESCRAP = Cursor_qbe_fam_delete_rap.GetString("DESCRAP");
          mcTemp.row.VALUTA = Cursor_qbe_fam_delete_rap.GetString("VALUTA");
          mcTemp.row.INVIATO = Cursor_qbe_fam_delete_rap.GetDouble("INVIATO");
          mcTemp.row.TIPO = Cursor_qbe_fam_delete_rap.GetString("TIPO");
          mcTemp.row.CAB = Cursor_qbe_fam_delete_rap.GetString("CAB");
          mcTemp.row.UNIQUECODE = Cursor_qbe_fam_delete_rap.GetString("UNIQUECODE");
          mcTemp.row.OLDINTER = Cursor_qbe_fam_delete_rap.GetString("OLDINTER");
          mcTemp.row.IDBASE = Cursor_qbe_fam_delete_rap.GetString("IDBASE");
          mcTemp.row.DATAMODI = Cursor_qbe_fam_delete_rap.GetDate("DATAMODI");
          mcTemp.row.IDESITO = Cursor_qbe_fam_delete_rap.GetString("IDESITO");
          mcTemp.row.ISOAGE = Cursor_qbe_fam_delete_rap.GetString("ISOAGE");
          Cursor_qbe_fam_delete_rap.Next();
        }
        m_cConnectivityError = Cursor_qbe_fam_delete_rap.ErrorMessage();
        Cursor_qbe_fam_delete_rap.Close();
        mcTemp.GoTop();
        /* _crea := 0 */
        _crea = CPLib.Round(0,0);
        for (MemoryCursorRow_tmp_stpperiodo rowTemp : mcTemp._iterable_()) {
          /* If _crea=0 */
          if (CPLib.eqr(_crea,0)) {
            /* rowSID0.CODINVIO := DateToChar(Date())+"24" */
            rowSID0.CODINVIO = CPLib.DateToChar(CPLib.Date())+"24";
            /* rowSID0.TIPINVIO := '2' */
            rowSID0.TIPINVIO = "2";
            /* rowSID0.TPCINVIO := '4' */
            rowSID0.TPCINVIO = "4";
            /* rowSID0.ANNINVIO := Str(w_anno,4,0) */
            rowSID0.ANNINVIO = CPLib.Str(w_anno,4,0);
            /* rowSID0.MESINVIO := w_mese */
            rowSID0.MESINVIO = w_mese;
            /* mcSID0.AppendRow(rowSID0) */
            mcSID0.AppendRow(rowSID0);
            /* _crea := 1 */
            _crea = CPLib.Round(1,0);
          } // End If
          /* gMsgImp := 'Sono stati effettuati '+LRTrim(Str(_conta,10,0))+" controlli" // Messaggio Import */
          gMsgImp = "Sono stati effettuati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" controlli";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* rowSID1.CODINVIO1 := DateToChar(Date())+"24" */
          rowSID1.CODINVIO1 = CPLib.DateToChar(CPLib.Date())+"24";
          /* rowSID1.RAPINVIO1 := rowTemp.RAPPORTO */
          rowSID1.RAPINVIO1 = rowTemp.RAPPORTO;
          /* rowSID1.TPRINVIO1 := rowTemp.TIPOAG */
          rowSID1.TPRINVIO1 = rowTemp.TIPOAG;
          /* rowSID1.INIINVIO1 := rowTemp.DATAINI */
          rowSID1.INIINVIO1 = rowTemp.DATAINI;
          /* rowSID1.FININVIO1 := rowTemp.DATAFINE */
          rowSID1.FININVIO1 = rowTemp.DATAFINE;
          /* rowSID1.TIPINVIO1 := '2' */
          rowSID1.TIPINVIO1 = "2";
          /* rowSID1.TPCINVIO1 := '4' */
          rowSID1.TPCINVIO1 = "4";
          /* mcSID1.AppendRow(rowSID1) */
          mcSID1.AppendRow(rowSID1);
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
        }
        /* gMsgProc := gMsgProc + 'Ora Fine controllo cancellazioni periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine controllo cancellazioni periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine controllo periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine controllo periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        for (MemoryCursorRow_sid_invio1 rowSID1 : mcSID1._iterable_()) {
          /* _stampa := 1 */
          _stampa = CPLib.Round(1,0);
          // * --- Insert into tmp_sid_invio1 from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_sid_invio1");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio1");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_sid_invio1",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_stpperiodo",102,"000000EB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000EB(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.CODINVIO1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.RAPINVIO1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TPRINVIO1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.INIINVIO1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.FININVIO1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TIPINVIO1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TPCINVIO1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_sid_invio1",true);
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
        }
        for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2._iterable_()) {
          // * --- Insert into tmp_sid_invio2 from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_sid_invio2");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio2");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_sid_invio2",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_stpperiodo",102,"000000ED")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000ED(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CODINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RAPINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.APRINVIO2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.INIINVIO2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.FININVIO2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.FCFINVIO2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CFSINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RUOINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.COGINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.NOMINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.SEXINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.DNSINVIO2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CNSINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.PNSINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RGSINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CSLINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.PLSINVIO2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_sid_invio2",true);
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
        }
        for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3._iterable_()) {
          // * --- Insert into tmp_sid_invio3 from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_sid_invio3");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio3");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_sid_invio3",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_stpperiodo",102,"000000EF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000EF(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.CODINVIO3,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.RAPINVIO3,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.TPRINVIO3,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.ANNINVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.VALINVIO3,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM1INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI1INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM2INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI2INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM3INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI3INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM4INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI4INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM5INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI5INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM6INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI6INVIO3,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_sid_invio3",true);
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
        }
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc + 'Sono stati effettuati '+LRTrim(Str(_conta,10,0))+" controlli" +NL // Messaggio */
        gMsgProc = gMsgProc+"Sono stati effettuati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" controlli"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine Elaborazione periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := "Elaborazione Terminata. E' possibile effettuare la stampa" // Messaggio Import */
        gMsgImp = "Elaborazione Terminata. E' possibile effettuare la stampa";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* gMsgImp := "Elaborazione Terminata con errori. Consultare l'assistenza" // Messaggio Import */
        gMsgImp = "Elaborazione Terminata con errori. Consultare l'assistenza";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* _okrep := 1 */
        _okrep = CPLib.Round(1,0);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000003Astatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000003Astatus,cTry0000003Amsg);
        }
      }
      /* If _okrep=0 */
      if (CPLib.eqr(_okrep,0)) {
        /* If _stampa=1 */
        if (CPLib.eqr(_stampa,1)) {
          /* Stop arrp_fam_stpperiodo.vrp */
          Forward f;
          f=new Forward("Report",false,this,Forward.Start,false);
          f.SetParameter("hideCover",true);
          f.SetParameter("hideLanguage",true);
          f.SetParameter("hideSettings",true);
          f.SetParameter("hideParameterMask",true);
          f.SetParameter("DescAzi",gDescAzi);
          f.SetParameter("w_annoc",CPLib.Str(w_anno,4,0));
          f.SetParameter("w_mese",w_mese);
          f.SetParameter("w_fgldett",w_flgdett);
          f.SetParameter("ReportName","arrp_fam_stpperiodo.vrp");
          f.SetParameter("m_cParameterSequence","hideCover"+","+"hideLanguage"+","+"hideSettings"+","+"hideParameterMask"+","+"DescAzi"+","+"w_annoc"+","+"w_mese"+","+"w_fgldett"+","+"ReportName");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
        } else { // Else
          // * --- Insert into tmp_sid_invio1 from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_sid_invio1");
          m_cPhName = m_Ctx.GetPhName("tmp_sid_invio1");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_sid_invio1",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_stpperiodo",102,"000000FA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000FA(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("00000000","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("XXX","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_sid_invio1",true);
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
          /* Stop arrp_fam_stpperiodo_neg.vrp */
          Forward f;
          f=new Forward("Report",false,this,Forward.Start,false);
          f.SetParameter("hideCover",true);
          f.SetParameter("hideLanguage",true);
          f.SetParameter("hideSettings",true);
          f.SetParameter("hideParameterMask",true);
          f.SetParameter("formatTypes","PDF");
          f.SetParameter("DescAzi",gDescAzi);
          f.SetParameter("w_annoc",CPLib.Str(w_anno,4,0));
          f.SetParameter("w_mese",w_mese);
          f.SetParameter("ReportName","arrp_fam_stpperiodo_neg.vrp");
          f.SetParameter("m_cParameterSequence","hideCover"+","+"hideLanguage"+","+"hideSettings"+","+"hideParameterMask"+","+"formatTypes"+","+"DescAzi"+","+"w_annoc"+","+"w_mese"+","+"ReportName");
          f.SetParameter("m_cMode","hyperlink");
          throw f;
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_qbe_fam_periodo01!=null)
          Cursor_qbe_fam_periodo01.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_fam_periodo03!=null)
          Cursor_qbe_fam_periodo03.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_fam_periodo05!=null)
          Cursor_qbe_fam_periodo05.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_fam_delete_rap!=null)
          Cursor_qbe_fam_delete_rap.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_famperiodo_opx_min_max=null;
    CPResultSet Cursor_qbe_famperiodo_opx01=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      // * --- Select from qbe_famperiodo_opx_min_max
      SPBridge.HMCaller _h00000100;
      _h00000100 = new SPBridge.HMCaller();
      _h00000100.Set("m_cVQRList",m_cVQRList);
      _h00000100.Set("_dadata",w_DaDatOpe);
      _h00000100.Set("_adata",w_ADatOpe);
      _h00000100.Set("_inviato",0);
      if (Cursor_qbe_famperiodo_opx_min_max!=null)
        Cursor_qbe_famperiodo_opx_min_max.Close();
      Cursor_qbe_famperiodo_opx_min_max = new VQRHolder("qbe_famperiodo_opx_min_max",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000100,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_famperiodo_opx_min_max.Eof())) {
        /* _min := qbe_famperiodo_opx_min_max->MINPRG */
        _min = CPLib.Round(Cursor_qbe_famperiodo_opx_min_max.GetDouble("MINPRG"),0);
        /* _max := qbe_famperiodo_opx_min_max->MAXPRG */
        _max = CPLib.Round(Cursor_qbe_famperiodo_opx_min_max.GetDouble("MAXPRG"),0);
        /* _tot := qbe_famperiodo_opx_min_max->TOTPRG */
        _tot = CPLib.Round(Cursor_qbe_famperiodo_opx_min_max.GetDouble("TOTPRG"),0);
        Cursor_qbe_famperiodo_opx_min_max.Next();
      }
      m_cConnectivityError = Cursor_qbe_famperiodo_opx_min_max.ErrorMessage();
      Cursor_qbe_famperiodo_opx_min_max.Close();
      // * --- End Select
      /* If _tot > 0 */
      if (CPLib.gt(_tot,0)) {
        /* _mono := 0 */
        _mono = CPLib.Round(0,0);
        /* _oldmsg := '' */
        _oldmsg = "";
        /* _mono := iif(_tot > 5000,0,1) */
        _mono = CPLib.Round((CPLib.gt(_tot,5000)?0:1),0);
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* If _tot = 0 */
          if (CPLib.eqr(_tot,0)) {
            /* _cicli := 0 */
            _cicli = CPLib.Round(0,0);
          } else { // Else
            /* _cicli := 1 */
            _cicli = CPLib.Round(1,0);
          } // End If
        } else { // Else
          /* _reccount := _max - _min */
          _reccount = CPLib.Round(_max-_min,0);
          /* _cicli := iif(Mod(_reccount,1000) <> 0,Int(_reccount/1000) + 1,Int(_reccount/1000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,1000),0)?CPLib.Int(_reccount/1000)+1:CPLib.Int(_reccount/1000)),0);
        } // End If
        /* _contacicli := 1 */
        _contacicli = CPLib.Round(1,0);
        /* While _contacicli <= _cicli */
        while (CPLib.le(_contacicli,_cicli)) {
          /* If _mono = 1 */
          if (CPLib.eqr(_mono,1)) {
            /* _bottom := _min */
            _bottom = CPLib.Round(_min,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* If _contacicli=1 */
            if (CPLib.eqr(_contacicli,1)) {
              /* _bottom := _min */
              _bottom = CPLib.Round(_min,0);
              /* _top := _min + 999 */
              _top = CPLib.Round(_min+999,0);
              /* ElseIf _contacicli = _cicli */
            } else if (CPLib.eqr(_contacicli,_cicli)) {
              /* _bottom := _top + 1 */
              _bottom = CPLib.Round(_top+1,0);
              /* _top := _max */
              _top = CPLib.Round(_max,0);
            } else { // Else
              /* _bottom := _top + 1 */
              _bottom = CPLib.Round(_top+1,0);
              /* _top := _bottom + 999 */
              _top = CPLib.Round(_bottom+999,0);
            } // End If
          } // End If
          /* gMsgImp := 'Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio Import */
          gMsgImp = "Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If Empty(_oldmsg) */
          if (CPLib.Empty(_oldmsg)) {
            /* gMsgProc := gMsgProc + 'Periodo: '+w_annoc+'-'+_mese+' - Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio */
            gMsgProc = gMsgProc+"Periodo: "+w_annoc+"-"+_mese+" - Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Periodo: '+w_annoc+'-'+_mese+" - " + LRTrim(gMsgImp)) // Messaggio */
            gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Periodo: "+w_annoc+"-"+_mese+" - "+CPLib.LRTrim(gMsgImp));
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* _oldmsg := 'Periodo: '+w_annoc+'-'+_mese+' - Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) */
          _oldmsg = "Periodo: "+w_annoc+"-"+_mese+" - Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
          /* If _top>=_min */
          if (CPLib.ge(_top,_min)) {
            /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
            gMsgImp = "Lettura operazioni extraconto in corso ...";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* mcTemp.Zap() */
            mcTemp.Zap();
            // * --- Fill memory cursor mcTemp on qbe_famperiodo_opx01
            mcTemp.Zap();
            SPBridge.HMCaller _h00000125;
            _h00000125 = new SPBridge.HMCaller();
            _h00000125.Set("m_cVQRList",m_cVQRList);
            _h00000125.Set("_dadata",w_DaDatOpe);
            _h00000125.Set("_adata",w_ADatOpe);
            _h00000125.Set("_inviato",0);
            _h00000125.Set("_bottom",_bottom);
            _h00000125.Set("_top",_top);
            if (Cursor_qbe_famperiodo_opx01!=null)
              Cursor_qbe_famperiodo_opx01.Close();
            l_VQRHolder = new VQRHolder("qbe_famperiodo_opx01",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000125,true);
            Cursor_qbe_famperiodo_opx01 = l_VQRHolder.GetCachedResultSet(i_oSPSessionCaches, chOpex, m_Ctx);
            {
              final CPResultSet m_TheCursor = Cursor_qbe_famperiodo_opx01;
              Cursor_qbe_famperiodo_opx01.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,5000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_fam_stpperiodo: query on qbe_famperiodo_opx01 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 5000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_qbe_famperiodo_opx01.Eof())) {
              mcTemp.AppendBlank();
              mcTemp.row.RAPPORTO = Cursor_qbe_famperiodo_opx01.GetString("RAPPORTO");
              mcTemp.row.DATAINI = Cursor_qbe_famperiodo_opx01.GetDate("DATAINI");
              mcTemp.row.DATAFINE = Cursor_qbe_famperiodo_opx01.GetDate("DATAFINE");
              mcTemp.row.TIPOAG = Cursor_qbe_famperiodo_opx01.GetString("TIPOAG");
              mcTemp.row.TIPORAP = Cursor_qbe_famperiodo_opx01.GetString("TIPORAP");
              mcTemp.row.DESCRAP = Cursor_qbe_famperiodo_opx01.GetString("DESCRAP");
              mcTemp.row.VALUTA = Cursor_qbe_famperiodo_opx01.GetString("VALUTA");
              mcTemp.row.INVIATO = Cursor_qbe_famperiodo_opx01.GetDouble("INVIATO");
              mcTemp.row.TIPO = Cursor_qbe_famperiodo_opx01.GetString("TIPO");
              mcTemp.row.CAB = Cursor_qbe_famperiodo_opx01.GetString("CAB");
              mcTemp.row.UNIQUECODE = Cursor_qbe_famperiodo_opx01.GetString("UNIQUECODE");
              mcTemp.row.OLDINTER = Cursor_qbe_famperiodo_opx01.GetString("OLDINTER");
              mcTemp.row.IDBASE = Cursor_qbe_famperiodo_opx01.GetString("IDBASE");
              mcTemp.row.DATAMODI = Cursor_qbe_famperiodo_opx01.GetDate("DATAMODI");
              mcTemp.row.IDESITO = Cursor_qbe_famperiodo_opx01.GetString("IDESITO");
              mcTemp.row.ISOAGE = Cursor_qbe_famperiodo_opx01.GetString("ISOAGE");
              Cursor_qbe_famperiodo_opx01.Next();
            }
            m_cConnectivityError = Cursor_qbe_famperiodo_opx01.ErrorMessage();
            Cursor_qbe_famperiodo_opx01.Close();
            mcTemp.GoTop();
            /* If mcTemp.RecCount() > 0 */
            if (CPLib.gt(mcTemp.RecCount(),0)) {
              for (MemoryCursorRow_tmp_stpperiodo rowTemp : mcTemp._iterable_()) {
                /* rowSID1.CODINVIO1 := DateToChar(Date())+_tipinvio+"1" */
                rowSID1.CODINVIO1 = CPLib.DateToChar(CPLib.Date())+_tipinvio+"1";
                /* rowSID1.RAPINVIO1 := rowTemp.RAPPORTO */
                rowSID1.RAPINVIO1 = rowTemp.RAPPORTO;
                /* rowSID1.TPRINVIO1 := rowTemp.TIPOAG */
                rowSID1.TPRINVIO1 = rowTemp.TIPOAG;
                /* rowSID1.INIINVIO1 := rowTemp.DATAINI */
                rowSID1.INIINVIO1 = rowTemp.DATAINI;
                /* rowSID1.FININVIO1 := rowTemp.DATAFINE */
                rowSID1.FININVIO1 = rowTemp.DATAFINE;
                /* rowSID1.TIPINVIO1 := _tipinvio */
                rowSID1.TIPINVIO1 = _tipinvio;
                /* rowSID1.TPCINVIO1 := '1' */
                rowSID1.TPCINVIO1 = "1";
                /* mcSID1.AppendRow(rowSID1) */
                mcSID1.AppendRow(rowSID1);
                /* mcSID2r := arfn_fam_mesefile02(rowSID1,w_DaDatOpe,w_ADatOpe,rowTemp.TIPO) */
                mcSID2r = arfn_fam_mesefile02R.Make(m_Ctx,this).Run(rowSID1,w_DaDatOpe,w_ADatOpe,rowTemp.TIPO);
                for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2r._iterable_()) {
                  /* mcSID2.AppendRow(rowSID2) */
                  mcSID2.AppendRow(rowSID2);
                }
                /* If _tipinvio='2' */
                if (CPLib.eqr(_tipinvio,"2")) {
                  /* If (Year(Date()) -Year(rowTemp.DATAINI)=1 and DateDiff(gScadSaldi,Date()) < 90) or (Year(Date()) -Year(rowTemp.DATAINI)=0) */
                  if ((CPLib.eqr(CPLib.Year(CPLib.Date())-CPLib.Year(rowTemp.DATAINI),1) && CPLib.lt(CPLib.DateDiff(gScadSaldi,CPLib.Date()),90)) || (CPLib.eqr(CPLib.Year(CPLib.Date())-CPLib.Year(rowTemp.DATAINI),0))) {
                    /* _asaldi := 0 */
                    _asaldi = CPLib.Round(0,0);
                  } else { // Else
                    /* _asaldi := Year(rowTemp.DATAINI) */
                    _asaldi = CPLib.Round(CPLib.Year(rowTemp.DATAINI),0);
                  } // End If
                  /* mcSID3r := arfn_fam_mesefile03(rowSID1,_asaldi,rowTemp.TIPO,rowTemp.VALUTA) */
                  mcSID3r = arfn_fam_mesefile03R.Make(m_Ctx,this).Run(rowSID1,_asaldi,rowTemp.TIPO,rowTemp.VALUTA);
                  for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3r._iterable_()) {
                    /* mcSID3.AppendRow(rowSID3) */
                    mcSID3.AppendRow(rowSID3);
                  }
                } // End If
                /* _conta := _conta + 1 */
                _conta = CPLib.Round(_conta+1,0);
                /* gMsgImp := 'Sono stati generati '+LRTrim(Str(_conta,10,0))+" record su un totale di "+LRTrim(Str(_tot,10,0)) // Messaggio Import */
                gMsgImp = "Sono stati generati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" record su un totale di "+CPLib.LRTrim(CPLib.Str(_tot,10,0));
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              }
            } // End If
          } else { // Else
            /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
            gMsgImp = "Lettura operazioni extraconto in corso ...";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          /* _contacicli := _contacicli+1 */
          _contacicli = CPLib.Round(_contacicli+1,0);
        } // End While
        /* gMsgProc := gMsgProc + NL // Messaggio */
        gMsgProc = gMsgProc+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_qbe_famperiodo_opx_min_max!=null)
          Cursor_qbe_famperiodo_opx_min_max.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famperiodo_opx01!=null)
          Cursor_qbe_famperiodo_opx01.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,double p_w_dainviare,double p_w_anno,String p_w_mese,String p_w_flgdett) {
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_dainviare = p_w_dainviare;
    w_anno = p_w_anno;
    w_mese = p_w_mese;
    w_flgdett = p_w_flgdett;
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
  public Forward Run(java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,double p_w_dainviare,double p_w_anno,String p_w_mese,String p_w_flgdett) {
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_dainviare = p_w_dainviare;
    w_anno = p_w_anno;
    w_mese = p_w_mese;
    w_flgdett = p_w_flgdett;
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_fam_stpperiodoR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_fam_stpperiodoR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = CPLib.NullDate();
    w_ADatOpe = CPLib.NullDate();
    w_dainviare = 0;
    w_anno = 0;
    w_mese = CPLib.Space(2);
    w_flgdett = CPLib.Space(2);
    _conta = 0;
    _errore = "";
    mcTemp = new MemoryCursor_tmp_stpperiodo();
    rowTemp = new MemoryCursorRow_tmp_stpperiodo();
    mcSID0 = new MemoryCursor_sid_invio();
    rowSID0 = new MemoryCursorRow_sid_invio();
    mcSID1 = new MemoryCursor_sid_invio1();
    rowSID1 = new MemoryCursorRow_sid_invio1();
    mcSID2 = new MemoryCursor_sid_invio2();
    rowSID2 = new MemoryCursorRow_sid_invio2();
    mcSID2r = new MemoryCursor_sid_invio2();
    mcSID3 = new MemoryCursor_sid_invio3();
    rowSID3 = new MemoryCursorRow_sid_invio3();
    mcSID3r = new MemoryCursor_sid_invio3();
    mcSID4 = new MemoryCursor_sid_invio4();
    mcSID4r = new MemoryCursor_sid_invio4();
    _crea = 0;
    _stampa = 0;
    _okrep = 0;
    _asaldi = 0;
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _cicli = 0;
    _oldmsg = CPLib.Space(100);
    _unique = CPLib.Space(50);
    _tipinvio = CPLib.Space(1);
    _reccount = 0;
    w_annoc = CPLib.Space(4);
    _mese = CPLib.Space(2);
    chOpex = CPLib.Space(0);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gScadSaldi=m_Ctx.GetGlobalDate("gScadSaldi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_fam_periodo01,qbe_fam_periodo03,qbe_fam_periodo05,qbe_fam_delete_rap,qbe_famperiodo_opx_min_max,qbe_famperiodo_opx01,
  public static final String m_cVQRList = ",qbe_fam_periodo01,qbe_fam_periodo03,qbe_fam_periodo05,qbe_fam_delete_rap,qbe_famperiodo_opx_min_max,qbe_famperiodo_opx01,";
  // ENTITY_BATCHES: ,arfn_datesum,arfn_fam_mesefile02,arfn_fam_mesefile03,arfn_fdatetime,arfn_finemese,
  public static final String i_InvokedRoutines = ",arfn_datesum,arfn_fam_mesefile02,arfn_fam_mesefile03,arfn_fdatetime,arfn_finemese,";
  public static String[] m_cRunParameterNames={"w_DaDatOpe","w_ADatOpe","w_dainviare","w_anno","w_mese","w_flgdett"};
  protected static String GetFieldsName_000000EB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO1,";
    p_cSql = p_cSql+"RAPINVIO1,";
    p_cSql = p_cSql+"TPRINVIO1,";
    p_cSql = p_cSql+"INIINVIO1,";
    p_cSql = p_cSql+"FININVIO1,";
    p_cSql = p_cSql+"TIPINVIO1,";
    p_cSql = p_cSql+"TPCINVIO1,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_sid_invio1",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000ED(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO2,";
    p_cSql = p_cSql+"RAPINVIO2,";
    p_cSql = p_cSql+"APRINVIO2,";
    p_cSql = p_cSql+"INIINVIO2,";
    p_cSql = p_cSql+"FININVIO2,";
    p_cSql = p_cSql+"FCFINVIO2,";
    p_cSql = p_cSql+"CFSINVIO2,";
    p_cSql = p_cSql+"RUOINVIO2,";
    p_cSql = p_cSql+"COGINVIO2,";
    p_cSql = p_cSql+"NOMINVIO2,";
    p_cSql = p_cSql+"SEXINVIO2,";
    p_cSql = p_cSql+"DNSINVIO2,";
    p_cSql = p_cSql+"CNSINVIO2,";
    p_cSql = p_cSql+"PNSINVIO2,";
    p_cSql = p_cSql+"RGSINVIO2,";
    p_cSql = p_cSql+"CSLINVIO2,";
    p_cSql = p_cSql+"PLSINVIO2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_sid_invio2",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000EF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO3,";
    p_cSql = p_cSql+"RAPINVIO3,";
    p_cSql = p_cSql+"TPRINVIO3,";
    p_cSql = p_cSql+"ANNINVIO3,";
    p_cSql = p_cSql+"VALINVIO3,";
    p_cSql = p_cSql+"IM1INVIO3,";
    p_cSql = p_cSql+"FI1INVIO3,";
    p_cSql = p_cSql+"IM2INVIO3,";
    p_cSql = p_cSql+"FI2INVIO3,";
    p_cSql = p_cSql+"IM3INVIO3,";
    p_cSql = p_cSql+"FI3INVIO3,";
    p_cSql = p_cSql+"IM4INVIO3,";
    p_cSql = p_cSql+"FI4INVIO3,";
    p_cSql = p_cSql+"IM5INVIO3,";
    p_cSql = p_cSql+"FI5INVIO3,";
    p_cSql = p_cSql+"IM6INVIO3,";
    p_cSql = p_cSql+"FI6INVIO3,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_sid_invio3",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000FA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO1,";
    p_cSql = p_cSql+"RAPINVIO1,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_sid_invio1",true);
    return p_cSql;
  }
}
