// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_discouic_xbrlR implements CallerWithObjs {
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
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_clientisara;
  public String m_cServer_clientisara;
  public String m_cPhName_filedatiuic;
  public String m_cServer_filedatiuic;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_storicoxbrl;
  public String m_cServer_storicoxbrl;
  public String m_cPhName_storicoxbrl_dett;
  public String m_cServer_storicoxbrl_dett;
  public String m_cPhName_xbrl_def;
  public String m_cServer_xbrl_def;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
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
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public String w_tipocr;
  public String w_codcr;
  public java.sql.Date w_datinv;
  public double w_numinv;
  public String w_flgfrazionate;
  public String w_storico;
  public String gPathApp;
  public String gPathDoc;
  public String gAzienda;
  public String gTipInter;
  public String gIntemediario;
  public String gMsgImp;
  public String gMsgProc;
  public String _tipcentro;
  public String _codcentro;
  public String _settsint;
  public double _appconta;
  public double _totconta;
  public double _conta;
  public double _contaw;
  public double _contaop;
  public String _coddip;
  public String _dipbase;
  public String _dipcab;
  public String _abicab;
  public String _dipabicab;
  public String _cabdip;
  public String _paesecli;
  public String _cabcli;
  public String _paesecp;
  public String _cabcp;
  public String _paeseicp;
  public String _cabicp;
  public double _operaz;
  public double _ocont;
  public String _testo;
  public String _txtappo;
  public String _file;
  public String cdadata;
  public String c_adata;
  public java.sql.Date w_dadata;
  public java.sql.Date w_adata;
  public String _mesi;
  public String _mese;
  public String cNomeFile;
  public String cOnlyNomeFile;
  public String cNomeFileZip;
  public String cProg;
  public String fhand;
  public double _nita;
  public double _next;
  public double _nalt;
  public String _datafine;
  public String _txttot;
  public double _tope;
  public double _tcon;
  public String _dataprod;
  public String _oraprod;
  public String _cDataOra;
  public double _totimp;
  public double _totcon;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _cicli;
  public double _contacilci;
  public double _bottom;
  public double _top;
  public String _cabint;
  public String _ita1;
  public String _ita2;
  public String _ext1;
  public String _ext2;
  public String _alt1;
  public String _alt2;
  public String _idf;
  public String _anno;
  public String _month;
  public String _progrif;
  public double _rifprog;
  public String _autoic;
  public double _pqtotale;
  public double _nosara;
  public String _sara;
  public String _datini;
  public String _datfin;
  public java.sql.Date _ddatini;
  public java.sql.Date _ddatfin;
  public java.sql.Date _dataoggi;
  public String _cdataoggi;
  public double _contarow;
  public String _oldmsg;
  public boolean _clientiope;
  public boolean _clientifrz;
  public double _cope;
  public String _chiave;
  public MemoryCursor_tmp_invio_xbrl mcTmp;
  public MemoryCursor_tmp_dischebo_xbrl_ita mcIta;
  public MemoryCursor_tmp_dischebo_xbrl_ext mcExt;
  public MemoryCursor_tmp_dischebo_xbrl_alt mcAlt;
  public MemoryCursorRow_tmp_invio_xbrl rowTmp;
  public MemoryCursor_mctesto_mcrdef mcTxt1;
  public MemoryCursor_mctesto_mcrdef mcTxt2;
  public MemoryCursorRow_mcsoggettiall1_mcrdef rowPers;
  public MemoryCursor_qbe_opeuif_vqr mcOpeUif;
  public MemoryCursor_qbe_frauif_vqr mcFraUif;
  public MemoryCursor_storicoxbrl mcStorico;
  public MemoryCursor_storicoxbrl_dett mcStoricoDett;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_discouic_xbrlR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_discouic_xbrl",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_clientisara = p_ContextObject.GetPhName("clientisara");
    if (m_cPhName_clientisara.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientisara = m_cPhName_clientisara+" "+m_Ctx.GetWritePhName("clientisara");
    }
    m_cServer_clientisara = p_ContextObject.GetServer("clientisara");
    m_cPhName_filedatiuic = p_ContextObject.GetPhName("filedatiuic");
    if (m_cPhName_filedatiuic.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_filedatiuic = m_cPhName_filedatiuic+" "+m_Ctx.GetWritePhName("filedatiuic");
    }
    m_cServer_filedatiuic = p_ContextObject.GetServer("filedatiuic");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_storicoxbrl = p_ContextObject.GetPhName("storicoxbrl");
    if (m_cPhName_storicoxbrl.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_storicoxbrl = m_cPhName_storicoxbrl+" "+m_Ctx.GetWritePhName("storicoxbrl");
    }
    m_cServer_storicoxbrl = p_ContextObject.GetServer("storicoxbrl");
    m_cPhName_storicoxbrl_dett = p_ContextObject.GetPhName("storicoxbrl_dett");
    if (m_cPhName_storicoxbrl_dett.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_storicoxbrl_dett = m_cPhName_storicoxbrl_dett+" "+m_Ctx.GetWritePhName("storicoxbrl_dett");
    }
    m_cServer_storicoxbrl_dett = p_ContextObject.GetServer("storicoxbrl_dett");
    m_cPhName_xbrl_def = p_ContextObject.GetPhName("xbrl_def");
    if (m_cPhName_xbrl_def.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xbrl_def = m_cPhName_xbrl_def+" "+m_Ctx.GetWritePhName("xbrl_def");
    }
    m_cServer_xbrl_def = p_ContextObject.GetServer("xbrl_def");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("numinv",p_cVarName)) {
      return w_numinv;
    }
    if (CPLib.eqr("_appconta",p_cVarName)) {
      return _appconta;
    }
    if (CPLib.eqr("_totconta",p_cVarName)) {
      return _totconta;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_contaw",p_cVarName)) {
      return _contaw;
    }
    if (CPLib.eqr("_contaop",p_cVarName)) {
      return _contaop;
    }
    if (CPLib.eqr("_operaz",p_cVarName)) {
      return _operaz;
    }
    if (CPLib.eqr("_ocont",p_cVarName)) {
      return _ocont;
    }
    if (CPLib.eqr("_nita",p_cVarName)) {
      return _nita;
    }
    if (CPLib.eqr("_next",p_cVarName)) {
      return _next;
    }
    if (CPLib.eqr("_nalt",p_cVarName)) {
      return _nalt;
    }
    if (CPLib.eqr("_tope",p_cVarName)) {
      return _tope;
    }
    if (CPLib.eqr("_tcon",p_cVarName)) {
      return _tcon;
    }
    if (CPLib.eqr("_totimp",p_cVarName)) {
      return _totimp;
    }
    if (CPLib.eqr("_totcon",p_cVarName)) {
      return _totcon;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      return _contacilci;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_rifprog",p_cVarName)) {
      return _rifprog;
    }
    if (CPLib.eqr("_pqtotale",p_cVarName)) {
      return _pqtotale;
    }
    if (CPLib.eqr("_nosara",p_cVarName)) {
      return _nosara;
    }
    if (CPLib.eqr("_contarow",p_cVarName)) {
      return _contarow;
    }
    if (CPLib.eqr("_cope",p_cVarName)) {
      return _cope;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_discouic_xbrl";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("tipocr",p_cVarName)) {
      return w_tipocr;
    }
    if (CPLib.eqr("codcr",p_cVarName)) {
      return w_codcr;
    }
    if (CPLib.eqr("flgfrazionate",p_cVarName)) {
      return w_flgfrazionate;
    }
    if (CPLib.eqr("storico",p_cVarName)) {
      return w_storico;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      return gTipInter;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("_tipcentro",p_cVarName)) {
      return _tipcentro;
    }
    if (CPLib.eqr("_codcentro",p_cVarName)) {
      return _codcentro;
    }
    if (CPLib.eqr("_settsint",p_cVarName)) {
      return _settsint;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
    }
    if (CPLib.eqr("_dipbase",p_cVarName)) {
      return _dipbase;
    }
    if (CPLib.eqr("_dipcab",p_cVarName)) {
      return _dipcab;
    }
    if (CPLib.eqr("_abicab",p_cVarName)) {
      return _abicab;
    }
    if (CPLib.eqr("_dipabicab",p_cVarName)) {
      return _dipabicab;
    }
    if (CPLib.eqr("_cabdip",p_cVarName)) {
      return _cabdip;
    }
    if (CPLib.eqr("_paesecli",p_cVarName)) {
      return _paesecli;
    }
    if (CPLib.eqr("_cabcli",p_cVarName)) {
      return _cabcli;
    }
    if (CPLib.eqr("_paesecp",p_cVarName)) {
      return _paesecp;
    }
    if (CPLib.eqr("_cabcp",p_cVarName)) {
      return _cabcp;
    }
    if (CPLib.eqr("_paeseicp",p_cVarName)) {
      return _paeseicp;
    }
    if (CPLib.eqr("_cabicp",p_cVarName)) {
      return _cabicp;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      return _testo;
    }
    if (CPLib.eqr("_txtappo",p_cVarName)) {
      return _txtappo;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      return _file;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      return cdadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return c_adata;
    }
    if (CPLib.eqr("_mesi",p_cVarName)) {
      return _mesi;
    }
    if (CPLib.eqr("_mese",p_cVarName)) {
      return _mese;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      return cNomeFile;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      return cOnlyNomeFile;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_datafine",p_cVarName)) {
      return _datafine;
    }
    if (CPLib.eqr("_txttot",p_cVarName)) {
      return _txttot;
    }
    if (CPLib.eqr("_dataprod",p_cVarName)) {
      return _dataprod;
    }
    if (CPLib.eqr("_oraprod",p_cVarName)) {
      return _oraprod;
    }
    if (CPLib.eqr("_cDataOra",p_cVarName)) {
      return _cDataOra;
    }
    if (CPLib.eqr("_cabint",p_cVarName)) {
      return _cabint;
    }
    if (CPLib.eqr("_ita1",p_cVarName)) {
      return _ita1;
    }
    if (CPLib.eqr("_ita2",p_cVarName)) {
      return _ita2;
    }
    if (CPLib.eqr("_ext1",p_cVarName)) {
      return _ext1;
    }
    if (CPLib.eqr("_ext2",p_cVarName)) {
      return _ext2;
    }
    if (CPLib.eqr("_alt1",p_cVarName)) {
      return _alt1;
    }
    if (CPLib.eqr("_alt2",p_cVarName)) {
      return _alt2;
    }
    if (CPLib.eqr("_idf",p_cVarName)) {
      return _idf;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    if (CPLib.eqr("_month",p_cVarName)) {
      return _month;
    }
    if (CPLib.eqr("_progrif",p_cVarName)) {
      return _progrif;
    }
    if (CPLib.eqr("_autoic",p_cVarName)) {
      return _autoic;
    }
    if (CPLib.eqr("_sara",p_cVarName)) {
      return _sara;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      return _datfin;
    }
    if (CPLib.eqr("_cdataoggi",p_cVarName)) {
      return _cdataoggi;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("_chiave",p_cVarName)) {
      return _chiave;
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
    if (CPLib.eqr("datinv",p_cVarName)) {
      return w_datinv;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
    }
    if (CPLib.eqr("adata",p_cVarName)) {
      return w_adata;
    }
    if (CPLib.eqr("_ddatini",p_cVarName)) {
      return _ddatini;
    }
    if (CPLib.eqr("_ddatfin",p_cVarName)) {
      return _ddatfin;
    }
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      return _dataoggi;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_clientiope",p_cVarName)) {
      return _clientiope;
    }
    if (CPLib.eqr("_clientifrz",p_cVarName)) {
      return _clientifrz;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcTmp",p_cVarName)) {
      return mcTmp;
    }
    if (CPLib.eqr("mcIta",p_cVarName)) {
      return mcIta;
    }
    if (CPLib.eqr("mcExt",p_cVarName)) {
      return mcExt;
    }
    if (CPLib.eqr("mcAlt",p_cVarName)) {
      return mcAlt;
    }
    if (CPLib.eqr("mcTxt1",p_cVarName)) {
      return mcTxt1;
    }
    if (CPLib.eqr("mcTxt2",p_cVarName)) {
      return mcTxt2;
    }
    if (CPLib.eqr("mcOpeUif",p_cVarName)) {
      return mcOpeUif;
    }
    if (CPLib.eqr("mcFraUif",p_cVarName)) {
      return mcFraUif;
    }
    if (CPLib.eqr("mcStorico",p_cVarName)) {
      return mcStorico;
    }
    if (CPLib.eqr("mcStoricoDett",p_cVarName)) {
      return mcStoricoDett;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowTmp",p_cVarName)) {
      return rowTmp;
    }
    if (CPLib.eqr("rowPers",p_cVarName)) {
      return rowPers;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("numinv",p_cVarName)) {
      w_numinv = value;
      return;
    }
    if (CPLib.eqr("_appconta",p_cVarName)) {
      _appconta = value;
      return;
    }
    if (CPLib.eqr("_totconta",p_cVarName)) {
      _totconta = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_contaw",p_cVarName)) {
      _contaw = value;
      return;
    }
    if (CPLib.eqr("_contaop",p_cVarName)) {
      _contaop = value;
      return;
    }
    if (CPLib.eqr("_operaz",p_cVarName)) {
      _operaz = value;
      return;
    }
    if (CPLib.eqr("_ocont",p_cVarName)) {
      _ocont = value;
      return;
    }
    if (CPLib.eqr("_nita",p_cVarName)) {
      _nita = value;
      return;
    }
    if (CPLib.eqr("_next",p_cVarName)) {
      _next = value;
      return;
    }
    if (CPLib.eqr("_nalt",p_cVarName)) {
      _nalt = value;
      return;
    }
    if (CPLib.eqr("_tope",p_cVarName)) {
      _tope = value;
      return;
    }
    if (CPLib.eqr("_tcon",p_cVarName)) {
      _tcon = value;
      return;
    }
    if (CPLib.eqr("_totimp",p_cVarName)) {
      _totimp = value;
      return;
    }
    if (CPLib.eqr("_totcon",p_cVarName)) {
      _totcon = value;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      _contacilci = value;
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
    if (CPLib.eqr("_rifprog",p_cVarName)) {
      _rifprog = value;
      return;
    }
    if (CPLib.eqr("_pqtotale",p_cVarName)) {
      _pqtotale = value;
      return;
    }
    if (CPLib.eqr("_nosara",p_cVarName)) {
      _nosara = value;
      return;
    }
    if (CPLib.eqr("_contarow",p_cVarName)) {
      _contarow = value;
      return;
    }
    if (CPLib.eqr("_cope",p_cVarName)) {
      _cope = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipocr",p_cVarName)) {
      w_tipocr = value;
      return;
    }
    if (CPLib.eqr("codcr",p_cVarName)) {
      w_codcr = value;
      return;
    }
    if (CPLib.eqr("flgfrazionate",p_cVarName)) {
      w_flgfrazionate = value;
      return;
    }
    if (CPLib.eqr("storico",p_cVarName)) {
      w_storico = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      gTipInter = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
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
    if (CPLib.eqr("_tipcentro",p_cVarName)) {
      _tipcentro = value;
      return;
    }
    if (CPLib.eqr("_codcentro",p_cVarName)) {
      _codcentro = value;
      return;
    }
    if (CPLib.eqr("_settsint",p_cVarName)) {
      _settsint = value;
      return;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      _coddip = value;
      return;
    }
    if (CPLib.eqr("_dipbase",p_cVarName)) {
      _dipbase = value;
      return;
    }
    if (CPLib.eqr("_dipcab",p_cVarName)) {
      _dipcab = value;
      return;
    }
    if (CPLib.eqr("_abicab",p_cVarName)) {
      _abicab = value;
      return;
    }
    if (CPLib.eqr("_dipabicab",p_cVarName)) {
      _dipabicab = value;
      return;
    }
    if (CPLib.eqr("_cabdip",p_cVarName)) {
      _cabdip = value;
      return;
    }
    if (CPLib.eqr("_paesecli",p_cVarName)) {
      _paesecli = value;
      return;
    }
    if (CPLib.eqr("_cabcli",p_cVarName)) {
      _cabcli = value;
      return;
    }
    if (CPLib.eqr("_paesecp",p_cVarName)) {
      _paesecp = value;
      return;
    }
    if (CPLib.eqr("_cabcp",p_cVarName)) {
      _cabcp = value;
      return;
    }
    if (CPLib.eqr("_paeseicp",p_cVarName)) {
      _paeseicp = value;
      return;
    }
    if (CPLib.eqr("_cabicp",p_cVarName)) {
      _cabicp = value;
      return;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      _testo = value;
      return;
    }
    if (CPLib.eqr("_txtappo",p_cVarName)) {
      _txtappo = value;
      return;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      _file = value;
      return;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      cdadata = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      c_adata = value;
      return;
    }
    if (CPLib.eqr("_mesi",p_cVarName)) {
      _mesi = value;
      return;
    }
    if (CPLib.eqr("_mese",p_cVarName)) {
      _mese = value;
      return;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      cNomeFile = value;
      return;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      cOnlyNomeFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_datafine",p_cVarName)) {
      _datafine = value;
      return;
    }
    if (CPLib.eqr("_txttot",p_cVarName)) {
      _txttot = value;
      return;
    }
    if (CPLib.eqr("_dataprod",p_cVarName)) {
      _dataprod = value;
      return;
    }
    if (CPLib.eqr("_oraprod",p_cVarName)) {
      _oraprod = value;
      return;
    }
    if (CPLib.eqr("_cDataOra",p_cVarName)) {
      _cDataOra = value;
      return;
    }
    if (CPLib.eqr("_cabint",p_cVarName)) {
      _cabint = value;
      return;
    }
    if (CPLib.eqr("_ita1",p_cVarName)) {
      _ita1 = value;
      return;
    }
    if (CPLib.eqr("_ita2",p_cVarName)) {
      _ita2 = value;
      return;
    }
    if (CPLib.eqr("_ext1",p_cVarName)) {
      _ext1 = value;
      return;
    }
    if (CPLib.eqr("_ext2",p_cVarName)) {
      _ext2 = value;
      return;
    }
    if (CPLib.eqr("_alt1",p_cVarName)) {
      _alt1 = value;
      return;
    }
    if (CPLib.eqr("_alt2",p_cVarName)) {
      _alt2 = value;
      return;
    }
    if (CPLib.eqr("_idf",p_cVarName)) {
      _idf = value;
      return;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      _anno = value;
      return;
    }
    if (CPLib.eqr("_month",p_cVarName)) {
      _month = value;
      return;
    }
    if (CPLib.eqr("_progrif",p_cVarName)) {
      _progrif = value;
      return;
    }
    if (CPLib.eqr("_autoic",p_cVarName)) {
      _autoic = value;
      return;
    }
    if (CPLib.eqr("_sara",p_cVarName)) {
      _sara = value;
      return;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      _datfin = value;
      return;
    }
    if (CPLib.eqr("_cdataoggi",p_cVarName)) {
      _cdataoggi = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("_chiave",p_cVarName)) {
      _chiave = value;
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
    if (CPLib.eqr("datinv",p_cVarName)) {
      w_datinv = value;
      return;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
    if (CPLib.eqr("adata",p_cVarName)) {
      w_adata = value;
      return;
    }
    if (CPLib.eqr("_ddatini",p_cVarName)) {
      _ddatini = value;
      return;
    }
    if (CPLib.eqr("_ddatfin",p_cVarName)) {
      _ddatfin = value;
      return;
    }
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      _dataoggi = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("_clientiope",p_cVarName)) {
      _clientiope = value;
      return;
    }
    if (CPLib.eqr("_clientifrz",p_cVarName)) {
      _clientifrz = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowTmp",p_cVarName)) {
      rowTmp = (MemoryCursorRow_tmp_invio_xbrl)value;
      return;
    }
    if (CPLib.eqr("rowPers",p_cVarName)) {
      rowPers = (MemoryCursorRow_mcsoggettiall1_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcTmp",p_cVarName)) {
      mcTmp = (MemoryCursor_tmp_invio_xbrl)value;
      return;
    }
    if (CPLib.eqr("mcIta",p_cVarName)) {
      mcIta = (MemoryCursor_tmp_dischebo_xbrl_ita)value;
      return;
    }
    if (CPLib.eqr("mcExt",p_cVarName)) {
      mcExt = (MemoryCursor_tmp_dischebo_xbrl_ext)value;
      return;
    }
    if (CPLib.eqr("mcAlt",p_cVarName)) {
      mcAlt = (MemoryCursor_tmp_dischebo_xbrl_alt)value;
      return;
    }
    if (CPLib.eqr("mcTxt1",p_cVarName)) {
      mcTxt1 = (MemoryCursor_mctesto_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcTxt2",p_cVarName)) {
      mcTxt2 = (MemoryCursor_mctesto_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcOpeUif",p_cVarName)) {
      mcOpeUif = (MemoryCursor_qbe_opeuif_vqr)value;
      return;
    }
    if (CPLib.eqr("mcFraUif",p_cVarName)) {
      mcFraUif = (MemoryCursor_qbe_frauif_vqr)value;
      return;
    }
    if (CPLib.eqr("mcStorico",p_cVarName)) {
      mcStorico = (MemoryCursor_storicoxbrl)value;
      return;
    }
    if (CPLib.eqr("mcStoricoDett",p_cVarName)) {
      mcStoricoDett = (MemoryCursor_storicoxbrl_dett)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_xbrl_def=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_tipocr Char(2) */
      /* w_codcr Char(11) */
      /* w_datinv Date */
      /* w_numinv Numeric(10, 0) */
      /* w_flgfrazionate Char(1) */
      /* w_storico Char(1) // Usa dati storici */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gTipInter Char(2) // Tipo Intermediario */
      /* gIntemediario Char(11) // Intermediario */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* _tipcentro Char(2) */
      /* _codcentro Char(11) */
      /* _settsint Char(3) */
      /* _appconta Numeric(10, 0) */
      /* _totconta Numeric(10, 0) */
      /* _conta Numeric(10, 0) */
      /* _contaw Numeric(10, 0) */
      /* _contaop Numeric(10, 0) */
      /* _coddip Char(6) */
      /* _dipbase Char(6) */
      /* _dipcab Char(6) */
      /* _abicab Char(12) */
      /* _dipabicab Char(12) */
      /* _cabdip Char(6) */
      /* _paesecli Char(3) */
      /* _cabcli Char(6) */
      /* _paesecp Char(3) */
      /* _cabcp Char(6) */
      /* _paeseicp Char(3) */
      /* _cabicp Char(6) */
      /* _operaz Numeric(6, 2) */
      /* _ocont Numeric(6, 2) */
      /* _testo Memo */
      /* _txtappo Memo */
      /* _file Char(20) */
      /* cdadata Char(8) */
      /* c_adata Char(8) */
      /* w_dadata Date */
      /* w_adata Date */
      /* _mesi Char(12) */
      /* _mese Char(1) */
      /* cNomeFile Char(30) */
      /* cOnlyNomeFile Char(30) */
      /* cNomeFileZip Char(30) */
      /* cProg Char(10) */
      /* fhand Char(10) */
      /* _nita Numeric(10, 0) */
      /* _next Numeric(10, 0) */
      /* _nalt Numeric(10, 0) */
      /* _datafine Char(10) */
      /* _txttot Memo */
      /* _tope Numeric(10, 0) */
      /* _tcon Numeric(10, 0) */
      /* _dataprod Char(10) */
      /* _oraprod Char(8) */
      /* _cDataOra Char(14) */
      /* _totimp Numeric(15, 2) */
      /* _totcon Numeric(15, 2) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacilci Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _cabint Char(6) */
      /* _ita1 Memo */
      /* _ita2 Memo */
      /* _ext1 Memo */
      /* _ext2 Memo */
      /* _alt1 Memo */
      /* _alt2 Memo */
      /* _idf Char(10) */
      /* _anno Char(4) */
      /* _month Char(2) */
      /* _progrif Char(10) */
      /* _rifprog Numeric(10, 0) */
      /* _autoic Char(1) */
      /* _pqtotale Numeric(3, 0) */
      /* _nosara Numeric(1, 0) */
      /* _sara Char(1) */
      /* _datini Char(8) */
      /* _datfin Char(8) */
      /* _ddatini Date */
      /* _ddatfin Date */
      /* _dataoggi Date */
      /* _cdataoggi Char(8) */
      /* _contarow Numeric(15, 0) */
      /* _oldmsg Memo */
      /* _clientiope Bool := False */
      _clientiope = false;
      /* _clientifrz Bool := False */
      _clientifrz = false;
      /* _cope Numeric(10, 0) */
      /* _chiave Char(128) */
      /* mcTmp MemoryCursor(tmp_invio_xbrl) */
      /* mcIta MemoryCursor(tmp_dischebo_xbrl_ita) */
      /* mcExt MemoryCursor(tmp_dischebo_xbrl_ext) */
      /* mcAlt MemoryCursor(tmp_dischebo_xbrl_alt) */
      /* rowTmp Row(tmp_invio_xbrl) */
      /* mcTxt1 MemoryCursor(mcTesto.MCRDef) */
      /* mcTxt2 MemoryCursor(mcTesto.MCRDef) */
      /* rowPers Row(mcSoggettiAll1.MCRDef) */
      /* mcOpeUif MemoryCursor(qbe_opeuif.vqr) */
      /* mcFraUif MemoryCursor(qbe_frauif.vqr) */
      /* mcStorico MemoryCursor(storicoxbrl) */
      /* mcStoricoDett MemoryCursor(storicoxbrl_dett) */
      /* Assegna valore a variabili */
      /* _ddatini := w_DaDatOpe */
      _ddatini = w_DaDatOpe;
      /* _ddatfin := w_ADatOpe */
      _ddatfin = w_ADatOpe;
      /* _datini := DateToChar(_ddatini) */
      _datini = CPLib.DateToChar(_ddatini);
      /* _datfin := DateToChar(_ddatfin) */
      _datfin = CPLib.DateToChar(_ddatfin);
      /* _tipcentro := iif(Empty(w_tipocr),gTipInter,w_tipocr) */
      _tipcentro = (CPLib.Empty(w_tipocr)?gTipInter:w_tipocr);
      /* _codcentro := iif(Empty(w_codcr),gIntemediario,w_codcr) */
      _codcentro = (CPLib.Empty(w_codcr)?gIntemediario:w_codcr);
      /* _datafine := Left(_datfin,4)+"-"+Substr(_datfin,5,2)+"-"+Substr(_datfin,7,2) */
      _datafine = CPLib.Left(_datfin,4)+"-"+CPLib.Substr(_datfin,5,2)+"-"+CPLib.Substr(_datfin,7,2);
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000007E;
      _h0000007E = new SPBridge.HMCaller();
      _h0000007E.Set("m_cVQRList",m_cVQRList);
      _h0000007E.Set("tbname","clientiope");
      _h0000007E.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000007E,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _clientiope := qbe_tab_mmc->tot > 0 */
        _clientiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000080;
      _h00000080 = new SPBridge.HMCaller();
      _h00000080.Set("m_cVQRList",m_cVQRList);
      _h00000080.Set("tbname","clientifrz");
      _h00000080.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000080,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _clientifrz := qbe_tab_mmc->tot > 0 */
        _clientifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000083status;
      nTry00000083status = m_Sql.GetTransactionStatus();
      String cTry00000083msg;
      cTry00000083msg = m_Sql.TransactionErrorMessage();
      try {
        /* _anno := Left(_datini,4) */
        _anno = CPLib.Left(_datini,4);
        /* _month := Substr(_datini,5,2) */
        _month = CPLib.Substr(_datini,5,2);
        // * --- Delete from storicoxbrl_dett
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("storicoxbrl_dett");
        m_cPhName = m_Ctx.GetPhName("storicoxbrl_dett");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"storicoxbrl_dett",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_xbrl",277,"00000087")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"ANNORIF = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer),m_cServer,_anno)+"";
        m_cSql = m_cSql+" and MESERIF = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_month,"?",0,0,m_cServer),m_cServer,_month)+"";
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
        // * --- Delete from storicoxbrl
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("storicoxbrl");
        m_cPhName = m_Ctx.GetPhName("storicoxbrl");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"storicoxbrl",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_xbrl",277,"00000088")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"ANNORIF = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer),m_cServer,_anno)+"";
        m_cSql = m_cSql+" and MESERIF = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_month,"?",0,0,m_cServer),m_cServer,_month)+"";
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
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* _contaop := 0 */
        _contaop = CPLib.Round(0,0);
        /* _totconta := 0 */
        _totconta = CPLib.Round(0,0);
        // * --- Select from xbrl_def
        m_cServer = m_Ctx.GetServer("xbrl_def");
        m_cPhName = m_Ctx.GetPhName("xbrl_def");
        if (Cursor_xbrl_def!=null)
          Cursor_xbrl_def.Close();
        Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("xbrl_def")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xbrl_def.Eof())) {
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          Cursor_xbrl_def.Next();
        }
        m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
        Cursor_xbrl_def.Close();
        // * --- End Select
        /* If _conta=0 */
        if (CPLib.eqr(_conta,0)) {
          /* gMsgProc := gMsgProc + 'Elaborazione Bloccata. Contattare Assistenza' + NL // Messaggio */
          gMsgProc = gMsgProc+"Elaborazione Bloccata. Contattare Assistenza"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := 'Elaborazione Bloccata. Contattare Assistenza' // Messaggio Import */
          gMsgImp = "Elaborazione Bloccata. Contattare Assistenza";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } else { // Else
          /* _conta := 0 */
          _conta = CPLib.Round(0,0);
          /* gMsgImp := 'Inizio selezione dati' // Messaggio Import */
          gMsgImp = "Inizio selezione dati";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Select from intermbo
          m_cServer = m_Ctx.GetServer("intermbo");
          m_cPhName = m_Ctx.GetPhName("intermbo");
          if (Cursor_intermbo!=null)
            Cursor_intermbo.Close();
          Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intermbo.Eof())) {
            /* _cabint := intermbo->CODCAB */
            _cabint = Cursor_intermbo.GetString("CODCAB");
            /* _dipbase := intermbo->CODDIPE */
            _dipbase = Cursor_intermbo.GetString("CODDIPE");
            /* _dipcab := '' */
            _dipcab = "";
            /* _dipabicab := '' */
            _dipabicab = "";
            /* _autoic := iif(Empty(intermbo->AUTOSARA),'N',intermbo->AUTOSARA) */
            _autoic = (CPLib.Empty(Cursor_intermbo.GetString("AUTOSARA"))?"N":Cursor_intermbo.GetString("AUTOSARA"));
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intermbo.GetString("CODDIPE"),"C",6,0,m_cServer),m_cServer,Cursor_intermbo.GetString("CODDIPE"));
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("ABICABSARA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _dipcab = Read_Cursor.GetString("CAB");
              _dipabicab = Read_Cursor.GetString("ABICABSARA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_xbrl returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _dipcab = "";
              _dipabicab = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            Cursor_intermbo.Next();
          }
          m_cConnectivityError = Cursor_intermbo.ErrorMessage();
          Cursor_intermbo.Close();
          // * --- End Select
          /* Verifica le operazioni da trasportare */
          /* _rifprog := 0 */
          _rifprog = CPLib.Round(0,0);
          /* Exec "Operazioni" Page 2:Page_2 */
          Page_2();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Exec "Operazioni Società Quotate" Page 6:Page_6 */
          Page_6();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* If w_flgfrazionate='S' */
          if (CPLib.eqr(w_flgfrazionate,"S")) {
            /* Exec "Frazionate" Page 3:Page_3 */
            Page_3();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
          } // End If
          /* Exec "Creazione File per Invio" Page 4:Page_4 */
          Page_4();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Exec "Creazione file zip" Page 5:Page_5 */
          Page_5();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Exec "Scrittura dati su DB" Page 7:Page_7 */
          Page_7();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* gMsgImp := "Elaborazione Terminata. Premere il tasto con la freccia verso l'alto per prelevare il file" // Messaggio Import */
          gMsgImp = "Elaborazione Terminata. Premere il tasto con la freccia verso l'alto per prelevare il file";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000083status,0)) {
          m_Sql.SetTransactionStatus(nTry00000083status,cTry00000083msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Return _totconta */
      throw new Stop(_totconta);
    } finally {
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xbrl_def!=null)
          Cursor_xbrl_def.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
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
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_opeuif=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla su operazbo e seleziona i record nel range definito */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Cicla su operazbo e seleziona i record nel range definito */
      /* _contarow := 0 */
      _contarow = CPLib.Round(0,0);
      /* _dataoggi := _ddatini */
      _dataoggi = _ddatini;
      /* _cdataoggi := _datini */
      _cdataoggi = _datini;
      /* _oldmsg := '' */
      _oldmsg = "";
      /* _contaop := 0 */
      _contaop = CPLib.Round(0,0);
      /* _cope := 0 */
      _cope = CPLib.Round(0,0);
      /* While _dataoggi <= _ddatfin */
      while (CPLib.le(_dataoggi,_ddatfin)) {
        /* If Empty(_oldmsg) */
        if (CPLib.Empty(_oldmsg)) {
          /* gMsgProc := gMsgProc + 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file operazioni" // Messaggio */
          gMsgProc = gMsgProc+"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file operazioni";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file operazioni") // Messaggio */
          gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file operazioni");
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* _oldmsg := 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file operazioni" */
        _oldmsg = "Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file operazioni";
        /* mcOpeUif.Zap() */
        mcOpeUif.Zap();
        // * --- Fill memory cursor mcOpeUif on qbe_opeuif
        mcOpeUif.Zap();
        SPBridge.HMCaller _h000000B7;
        _h000000B7 = new SPBridge.HMCaller();
        _h000000B7.Set("m_cVQRList",m_cVQRList);
        _h000000B7.Set("cdadata",_cdataoggi);
        if (Cursor_qbe_opeuif!=null)
          Cursor_qbe_opeuif.Close();
        Cursor_qbe_opeuif = new VQRHolder("qbe_opeuif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000B7,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_opeuif.Eof())) {
          mcOpeUif.AppendBlank();
          mcOpeUif.row.IDBASE = Cursor_qbe_opeuif.GetString("IDBASE");
          mcOpeUif.row.NUMPROG = Cursor_qbe_opeuif.GetString("NUMPROG");
          mcOpeUif.row.DATAOPE = Cursor_qbe_opeuif.GetDate("DATAOPE");
          mcOpeUif.row.TIPOINTER = Cursor_qbe_opeuif.GetString("TIPOINTER");
          mcOpeUif.row.CODINTER = Cursor_qbe_opeuif.GetString("CODINTER");
          mcOpeUif.row.TIPOINF = Cursor_qbe_opeuif.GetString("TIPOINF");
          mcOpeUif.row.IDEREG = Cursor_qbe_opeuif.GetString("IDEREG");
          mcOpeUif.row.DESCCIT = Cursor_qbe_opeuif.GetString("DESCCIT");
          mcOpeUif.row.CODDIPE = Cursor_qbe_opeuif.GetString("CODDIPE");
          mcOpeUif.row.PROVINCIA = Cursor_qbe_opeuif.GetString("PROVINCIA");
          mcOpeUif.row.CODCAB = Cursor_qbe_opeuif.GetString("CODCAB");
          mcOpeUif.row.FLAGFRAZ = Cursor_qbe_opeuif.GetString("FLAGFRAZ");
          mcOpeUif.row.FLAGCONT = Cursor_qbe_opeuif.GetString("FLAGCONT");
          mcOpeUif.row.CODANA = Cursor_qbe_opeuif.GetString("CODANA");
          mcOpeUif.row.CODVOC = Cursor_qbe_opeuif.GetString("CODVOC");
          mcOpeUif.row.TIPOINT2 = Cursor_qbe_opeuif.GetString("TIPOINT2");
          mcOpeUif.row.CODINT2 = Cursor_qbe_opeuif.GetString("CODINT2");
          mcOpeUif.row.PAESE = Cursor_qbe_opeuif.GetString("PAESE");
          mcOpeUif.row.DESC2 = Cursor_qbe_opeuif.GetString("DESC2");
          mcOpeUif.row.PROV2 = Cursor_qbe_opeuif.GetString("PROV2");
          mcOpeUif.row.CODCAB2 = Cursor_qbe_opeuif.GetString("CODCAB2");
          mcOpeUif.row.DESCINTER = Cursor_qbe_opeuif.GetString("DESCINTER");
          mcOpeUif.row.RAPPORTO = Cursor_qbe_opeuif.GetString("RAPPORTO");
          mcOpeUif.row.FLAGRAP = Cursor_qbe_opeuif.GetString("FLAGRAP");
          mcOpeUif.row.TIPOLEG = Cursor_qbe_opeuif.GetString("TIPOLEG");
          mcOpeUif.row.DATAREG = Cursor_qbe_opeuif.GetDate("DATAREG");
          mcOpeUif.row.OPRAP = Cursor_qbe_opeuif.GetString("OPRAP");
          mcOpeUif.row.TIPOOPRAP = Cursor_qbe_opeuif.GetString("TIPOOPRAP");
          mcOpeUif.row.FLAGLIRE = Cursor_qbe_opeuif.GetString("FLAGLIRE");
          mcOpeUif.row.VALUTA = Cursor_qbe_opeuif.GetString("VALUTA");
          mcOpeUif.row.SEGNO = Cursor_qbe_opeuif.GetString("SEGNO");
          mcOpeUif.row.TOTLIRE = Cursor_qbe_opeuif.GetDouble("TOTLIRE");
          mcOpeUif.row.TOTCONT = Cursor_qbe_opeuif.GetDouble("TOTCONT");
          mcOpeUif.row.STATOREG = Cursor_qbe_opeuif.GetString("STATOREG");
          mcOpeUif.row.OPERAZMOD = Cursor_qbe_opeuif.GetString("OPERAZMOD");
          mcOpeUif.row.DATARETT = Cursor_qbe_opeuif.GetDate("DATARETT");
          mcOpeUif.row.CONNESCLI = Cursor_qbe_opeuif.GetString("CONNESCLI");
          mcOpeUif.row.CONNESOPER = Cursor_qbe_opeuif.GetString("CONNESOPER");
          mcOpeUif.row.CONNESBEN = Cursor_qbe_opeuif.GetString("CONNESBEN");
          mcOpeUif.row.COLLEG = Cursor_qbe_opeuif.GetString("COLLEG");
          mcOpeUif.row.CAMBIO = Cursor_qbe_opeuif.GetDouble("CAMBIO");
          mcOpeUif.row.RAPPORTBEN = Cursor_qbe_opeuif.GetString("RAPPORTBEN");
          mcOpeUif.row.FLAGRAP2 = Cursor_qbe_opeuif.GetString("FLAGRAP2");
          mcOpeUif.row.OPERATORE = Cursor_qbe_opeuif.GetString("OPERATORE");
          mcOpeUif.row.AUTOM = Cursor_qbe_opeuif.GetString("AUTOM");
          mcOpeUif.row.idcauana = Cursor_qbe_opeuif.GetString("idcauana");
          mcOpeUif.row.OPERAG = Cursor_qbe_opeuif.GetString("OPERAG");
          mcOpeUif.row.DOCFILE = Cursor_qbe_opeuif.GetString("DOCFILE");
          mcOpeUif.row.RESPINS = Cursor_qbe_opeuif.GetString("RESPINS");
          mcOpeUif.row.INFORM = Cursor_qbe_opeuif.GetString("INFORM");
          mcOpeUif.row.CDATOPE = Cursor_qbe_opeuif.GetString("CDATOPE");
          mcOpeUif.row.NOPROT = Cursor_qbe_opeuif.GetDouble("NOPROT");
          mcOpeUif.row.UCODE = Cursor_qbe_opeuif.GetString("UCODE");
          mcOpeUif.row.CDATAOPE = Cursor_qbe_opeuif.GetString("CDATAOPE");
          mcOpeUif.row.ZCPARTE = Cursor_qbe_opeuif.GetString("ZCPARTE");
          mcOpeUif.row.RAGIO = Cursor_qbe_opeuif.GetString("RAGIO");
          mcOpeUif.row.MODSVOL = Cursor_qbe_opeuif.GetString("MODSVOL");
          mcOpeUif.row.AREAGEO = Cursor_qbe_opeuif.GetString("AREAGEO");
          mcOpeUif.row.C_CAB = Cursor_qbe_opeuif.GetString("C_CAB");
          mcOpeUif.row.C_STA = Cursor_qbe_opeuif.GetString("C_STA");
          mcOpeUif.row.RIFIMP = Cursor_qbe_opeuif.GetString("RIFIMP");
          mcOpeUif.row.PROQUOTA = Cursor_qbe_opeuif.GetDouble("PROQUOTA");
          mcOpeUif.row.IMPSARA = Cursor_qbe_opeuif.GetDouble("IMPSARA");
          mcOpeUif.row.CONNES = Cursor_qbe_opeuif.GetString("CONNES");
          mcOpeUif.row.RAGSOC = Cursor_qbe_opeuif.GetString("RAGSOC");
          mcOpeUif.row.CODFISC = Cursor_qbe_opeuif.GetString("CODFISC");
          mcOpeUif.row.PAESECLI = Cursor_qbe_opeuif.GetString("PAESECLI");
          mcOpeUif.row.CABCLI = Cursor_qbe_opeuif.GetString("CABCLI");
          mcOpeUif.row.DESCCITCLI = Cursor_qbe_opeuif.GetString("DESCCITCLI");
          mcOpeUif.row.SETTSINT = Cursor_qbe_opeuif.GetString("SETTSINT");
          mcOpeUif.row.SOTGRUP = Cursor_qbe_opeuif.GetString("SOTGRUP");
          mcOpeUif.row.SESSO = Cursor_qbe_opeuif.GetString("SESSO");
          mcOpeUif.row.NOSARA = Cursor_qbe_opeuif.GetString("NOSARA");
          mcOpeUif.row.CABDIP = Cursor_qbe_opeuif.GetString("CABDIP");
          mcOpeUif.row.ABICABSARA = Cursor_qbe_opeuif.GetString("ABICABSARA");
          mcOpeUif.row.CODDIP = Cursor_qbe_opeuif.GetString("CODDIP");
          mcOpeUif.row.DESCRIZ = Cursor_qbe_opeuif.GetString("DESCRIZ");
          mcOpeUif.row.DESCCITD = Cursor_qbe_opeuif.GetString("DESCCITD");
          Cursor_qbe_opeuif.Next();
        }
        m_cConnectivityError = Cursor_qbe_opeuif.ErrorMessage();
        Cursor_qbe_opeuif.Close();
        mcOpeUif.GoTop();
        for (MemoryCursorRow_qbe_opeuif_vqr rowOpeUif : mcOpeUif._iterable_()) {
          /* _cope := _cope + 1 */
          _cope = CPLib.Round(_cope+1,0);
          /* _conta := 1 */
          _conta = CPLib.Round(1,0);
          /* _nosara := 0 */
          _nosara = CPLib.Round(0,0);
          /* _settsint := "" */
          _settsint = "";
          /* _settsint := iif(Empty(rowOpeUif.SETTSINT),'999',rowOpeUif.SETTSINT) */
          _settsint = (CPLib.Empty(rowOpeUif.SETTSINT)?"999":rowOpeUif.SETTSINT);
          /* Case rowOpeUif.CDATOPE <= '20201231' */
          if (CPLib.le(rowOpeUif.CDATOPE,"20201231")) {
            /* If _settsint = '811' or _settsint = '812' */
            if (CPLib.eqr(_settsint,"811") || CPLib.eqr(_settsint,"812")) {
              /* _settsint := '810' */
              _settsint = "810";
            } // End If
            /* If _settsint = '101' or _settsint = '102' or _settsint = '103' or _settsint = '104' */
            if (CPLib.eqr(_settsint,"101") || CPLib.eqr(_settsint,"102") || CPLib.eqr(_settsint,"103") || CPLib.eqr(_settsint,"104")) {
              /* _settsint := '100' */
              _settsint = "100";
            } // End If
            /* Case rowOpeUif.CDATOPE <= '20111231' */
          } else if (CPLib.le(rowOpeUif.CDATOPE,"20111231")) {
            /* If _settsint = '713' or _settsint = '712' */
            if (CPLib.eqr(_settsint,"713") || CPLib.eqr(_settsint,"712")) {
              /* _settsint := '710' */
              _settsint = "710";
            } // End If
          } // End Case
          /* _sara := rowOpeUif.NOSARA */
          _sara = rowOpeUif.NOSARA;
          /* _nosara := iif(_sara='S',1,0) */
          _nosara = CPLib.Round((CPLib.eqr(_sara,"S")?1:0),0);
          /* _pqtotale := rowOpeUif.PROQUOTA */
          _pqtotale = CPLib.Round(rowOpeUif.PROQUOTA,0);
          /* If _nosara=0 and _clientiope */
          if (CPLib.eqr(_nosara,0) && _clientiope) {
            // * --- Select from clientiope
            m_cServer = m_Ctx.GetServer("clientiope");
            m_cPhName = m_Ctx.GetPhName("clientiope");
            if (Cursor_clientiope!=null)
              Cursor_clientiope.Close();
            Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowOpeUif.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowOpeUif.IDBASE)+"  and  CODSOG <> "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowOpeUif.CONNESCLI,"?",0,0,m_cServer, m_oParameters),m_cServer,rowOpeUif.CONNESCLI)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientiope.Eof())) {
              /* _sara := 'N' */
              _sara = "N";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"C",16,0,m_cServer),m_cServer,Cursor_clientiope.GetString("CODSOG"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NOSARA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _sara = Read_Cursor.GetString("NOSARA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_discouic_xbrl returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _sara = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _nosara := _nosara + iif(_sara='S',1,0) */
              _nosara = CPLib.Round(_nosara+(CPLib.eqr(_sara,"S")?1:0),0);
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              /* _pqtotale := _pqtotale + clientiope->PROQUOTA */
              _pqtotale = CPLib.Round(_pqtotale+Cursor_clientiope.GetDouble("PROQUOTA"),0);
              Cursor_clientiope.Next();
            }
            m_cConnectivityError = Cursor_clientiope.ErrorMessage();
            Cursor_clientiope.Close();
            // * --- End Select
          } // End If
          /* If _conta > 1 */
          if (CPLib.gt(_conta,1)) {
            /* _operaz := 1 / _conta */
            _operaz = CPLib.Round(1/_conta,2);
            /* _ocont := iif(rowOpeUif.TOTCONT <> 0,1 / _conta,0) */
            _ocont = CPLib.Round((CPLib.ne(rowOpeUif.TOTCONT,0)?1/_conta:0),2);
          } else { // Else
            /* _operaz := 1 */
            _operaz = CPLib.Round(1,2);
            /* _ocont := iif(rowOpeUif.TOTCONT <> 0,1,0) */
            _ocont = CPLib.Round((CPLib.ne(rowOpeUif.TOTCONT,0)?1:0),2);
          } // End If
          /* If _nosara=0 */
          if (CPLib.eqr(_nosara,0)) {
            /* _totconta := _totconta + 1 */
            _totconta = CPLib.Round(_totconta+1,0);
            /* _contaop := _contaop + 1 */
            _contaop = CPLib.Round(_contaop+1,0);
            /* _coddip := "" */
            _coddip = "";
            /* _abicab := '000000000000' */
            _abicab = "000000000000";
            /* _cabdip := '' */
            _cabdip = "";
            /* _paesecli := '' */
            _paesecli = "";
            /* _cabcli := '' */
            _cabcli = "";
            /* _paesecp := '' */
            _paesecp = "";
            /* _cabcp := '' */
            _cabcp = "";
            /* _paeseicp := '' */
            _paeseicp = "";
            /* _cabicp := '' */
            _cabicp = "";
            /* gMsgImp := 'Elaboro Operazione N. '+ LRTrim(Str(_contaop,10,0)) // Messaggio Import */
            gMsgImp = "Elaboro Operazione N. "+CPLib.LRTrim(CPLib.Str(_contaop,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If Empty(LRTrim(rowOpeUif.CODDIPE)) */
            if (CPLib.Empty(CPLib.LRTrim(rowOpeUif.CODDIPE))) {
              /* If _tipcentro='02' */
              if (CPLib.eqr(_tipcentro,"02")) {
                /* _coddip := _dipbase */
                _coddip = _dipbase;
                /* _cabdip := _dipcab */
                _cabdip = _dipcab;
                /* _abicab := _dipabicab */
                _abicab = _dipabicab;
              } else { // Else
                /* _coddip := '000000' */
                _coddip = "000000";
                /* _cabdip := _cabint */
                _cabdip = _cabint;
              } // End If
            } else { // Else
              /* _coddip := LRTrim(rowOpeUif.CODDIPE) */
              _coddip = CPLib.LRTrim(rowOpeUif.CODDIPE);
              /* _cabdip := LRTrim(rowOpeUif.CABDIP) */
              _cabdip = CPLib.LRTrim(rowOpeUif.CABDIP);
              /* If Empty(_cabdip) */
              if (CPLib.Empty(_cabdip)) {
                // * --- Read from anadip
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_cSql = "";
                m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"C",6,0,m_cServer),m_cServer,_coddip);
                if (m_Ctx.IsSharedTemp("anadip")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("ABICABSARA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _cabdip = Read_Cursor.GetString("CAB");
                  _abicab = Read_Cursor.GetString("ABICABSARA");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_xbrl returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _cabdip = "";
                  _abicab = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } else { // Else
                // * --- Read from anadip
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_cSql = "";
                m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"C",6,0,m_cServer),m_cServer,_coddip);
                if (m_Ctx.IsSharedTemp("anadip")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ABICABSARA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _abicab = Read_Cursor.GetString("ABICABSARA");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_xbrl returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _abicab = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
            } // End If
            /* If w_storico='S' */
            if (CPLib.eqr(w_storico,"S")) {
              /* rowPers := arfn_datisog_sol_row(rowOpeUif.CONNESCLI,rowOpeUif.DATAREG,rowOpeUif.STATOREG,rowOpeUif.DATARETT) */
              rowPers = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(rowOpeUif.CONNESCLI,rowOpeUif.DATAREG,rowOpeUif.STATOREG,rowOpeUif.DATARETT);
              /* _paesecli := rowPers.STATO */
              _paesecli = rowPers.STATO;
              /* _cabcli := rowPers.CODCAB */
              _cabcli = rowPers.CODCAB;
              /* _settsint := iif(Empty(rowPers.SETSINT),'999',rowPers.SETSINT) */
              _settsint = (CPLib.Empty(rowPers.SETSINT)?"999":rowPers.SETSINT);
              /* _sara := rowPers.NOSARA */
              _sara = rowPers.NOSARA;
            } else { // Else
              /* _paesecli := rowOpeUif.PAESECLI */
              _paesecli = rowOpeUif.PAESECLI;
              /* If _paesecli='086' */
              if (CPLib.eqr(_paesecli,"086")) {
                /* _cabcli := iif(not(Empty(rowOpeUif.CABCLI)),rowOpeUif.CABCLI,rowOpeUif.CODCAB2) */
                _cabcli = ( ! (CPLib.Empty(rowOpeUif.CABCLI))?rowOpeUif.CABCLI:rowOpeUif.CODCAB2);
              } else { // Else
                /* _cabcli := '' */
                _cabcli = "";
              } // End If
            } // End If
            /* If _pqtotale=0 and rowOpeUif.IMPSARA=0 */
            if (CPLib.eqr(_pqtotale,0) && CPLib.eqr(rowOpeUif.IMPSARA,0)) {
              /* _totimp := rowOpeUif.TOTLIRE / (_conta * 100) */
              _totimp = CPLib.Round(rowOpeUif.TOTLIRE/(_conta*100),2);
              /* _totcon := rowOpeUif.TOTCONT / (_conta * 100) */
              _totcon = CPLib.Round(rowOpeUif.TOTCONT/(_conta*100),2);
              /* ElseIf _pqtotale <> 0 and rowOpeUif.IMPSARA=0 */
            } else if (CPLib.ne(_pqtotale,0) && CPLib.eqr(rowOpeUif.IMPSARA,0)) {
              /* _totimp := (rowOpeUif.TOTLIRE / 10000) * rowOpeUif.PROQUOTA */
              _totimp = CPLib.Round((rowOpeUif.TOTLIRE/10000)*rowOpeUif.PROQUOTA,2);
              /* _totcon := (rowOpeUif.TOTCONT / 10000)  * rowOpeUif.PROQUOTA */
              _totcon = CPLib.Round((rowOpeUif.TOTCONT/10000)*rowOpeUif.PROQUOTA,2);
              /* ElseIf _pqtotale = 0 and rowOpeUif.IMPSARA <> 0 */
            } else if (CPLib.eqr(_pqtotale,0) && CPLib.ne(rowOpeUif.IMPSARA,0)) {
              /* _totimp := rowOpeUif.IMPSARA */
              _totimp = CPLib.Round(rowOpeUif.IMPSARA,2);
              /* _totcon := 0 */
              _totcon = CPLib.Round(0,2);
            } // End If
            /* If At(LRTrim(rowOpeUif.CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
            if (CPLib.gt(CPLib.At(CPLib.LRTrim(rowOpeUif.CODVOC),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
              /* _paesecp := LRTrim(rowOpeUif.C_STA) */
              _paesecp = CPLib.LRTrim(rowOpeUif.C_STA);
              /* If _autoic='S' */
              if (CPLib.eqr(_autoic,"S")) {
                /* _cabcp := iif(_paesecp <>'086','',LRTrim(rowOpeUif.C_CAB)) */
                _cabcp = (CPLib.ne(_paesecp,"086")?"":CPLib.LRTrim(rowOpeUif.C_CAB));
                /* If Empty(rowOpeUif.PAESE) */
                if (CPLib.Empty(rowOpeUif.PAESE)) {
                  /* _paeseicp := _paesecp */
                  _paeseicp = _paesecp;
                } else { // Else
                  /* _paeseicp := LRTrim(rowOpeUif.PAESE) */
                  _paeseicp = CPLib.LRTrim(rowOpeUif.PAESE);
                } // End If
                /* Case Empty(rowOpeUif.CODCAB2) and _paeseicp='086' */
                if (CPLib.Empty(rowOpeUif.CODCAB2) && CPLib.eqr(_paeseicp,"086")) {
                  /* If _paesecp='086' */
                  if (CPLib.eqr(_paesecp,"086")) {
                    /* _cabicp := _cabcp */
                    _cabicp = _cabcp;
                  } else { // Else
                    /* _cabicp := '' */
                    _cabicp = "";
                  } // End If
                  /* Case Empty(rowOpeUif.CODCAB2) and _paeseicp<>'086' and not(Empty(_paeseicp)) */
                } else if (CPLib.Empty(rowOpeUif.CODCAB2) && CPLib.ne(_paeseicp,"086") &&  ! (CPLib.Empty(_paeseicp))) {
                  /* _cabicp := '' */
                  _cabicp = "";
                  /* Case not(Empty(rowOpeUif.CODCAB2)) and _paeseicp = '086' */
                } else if ( ! (CPLib.Empty(rowOpeUif.CODCAB2)) && CPLib.eqr(_paeseicp,"086")) {
                  /* _cabicp := rowOpeUif.CODCAB2 */
                  _cabicp = rowOpeUif.CODCAB2;
                } // End Case
              } else { // Else
                /* _cabcp := LRTrim(rowOpeUif.C_CAB) */
                _cabcp = CPLib.LRTrim(rowOpeUif.C_CAB);
                /* _paeseicp := LRTrim(rowOpeUif.PAESE) */
                _paeseicp = CPLib.LRTrim(rowOpeUif.PAESE);
                /* _cabicp := LRTrim(rowOpeUif.CODCAB2) */
                _cabicp = CPLib.LRTrim(rowOpeUif.CODCAB2);
              } // End If
              /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_coddip)+iif(Empty(LRTrim(_abicab)),'000000000000',LRTrim(_abicab))+LRTrim(_cabdip)+LRTrim(_paesecli)+LRTrim(_cabcli)+LRTrim(rowOpeUif.CODVOC)+LRTrim(rowOpeUif.FLAGLIRE) */
              _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_coddip)+(CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":CPLib.LRTrim(_abicab))+CPLib.LRTrim(_cabdip)+CPLib.LRTrim(_paesecli)+CPLib.LRTrim(_cabcli)+CPLib.LRTrim(rowOpeUif.CODVOC)+CPLib.LRTrim(rowOpeUif.FLAGLIRE);
              /* _chiave := _chiave + LRTrim(rowOpeUif.SEGNO) + LRTrim(_settsint)+LRTrim(_paesecp)+LRTrim(_cabcp)+LRTrim(_paeseicp)+LRTrim(_cabicp) */
              _chiave = _chiave+CPLib.LRTrim(rowOpeUif.SEGNO)+CPLib.LRTrim(_settsint)+CPLib.LRTrim(_paesecp)+CPLib.LRTrim(_cabcp)+CPLib.LRTrim(_paeseicp)+CPLib.LRTrim(_cabicp);
              /* If not(mcStorico.GoToKey(_chiave)) */
              if ( ! (mcStorico.GoToKey(_chiave))) {
                /* _rifprog := _rifprog + 1 */
                _rifprog = CPLib.Round(_rifprog+1,0);
                /* _progrif := Right('0000000000'+LRTrim(Str(_rifprog,10,0)),10) */
                _progrif = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_rifprog,10,0)),10);
                /* mcStorico.AppendWithKey(_chiave) */
                mcStorico.AppendWithKey(_chiave);
                /* mcStorico.ANNORIF := _anno */
                mcStorico.row.ANNORIF = _anno;
                /* mcStorico.MESERIF := _month */
                mcStorico.row.MESERIF = _month;
                /* mcStorico.PROGRIF := _progrif */
                mcStorico.row.PROGRIF = _progrif;
                /* mcStorico.CODINTDIP := _coddip */
                mcStorico.row.CODINTDIP = _coddip;
                /* mcStorico.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                mcStorico.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                /* mcStorico.CODCABDIP := _cabdip */
                mcStorico.row.CODCABDIP = _cabdip;
                /* mcStorico.PERPAESE := _paesecli */
                mcStorico.row.PERPAESE = _paesecli;
                /* mcStorico.PERCAB := _cabcli */
                mcStorico.row.PERCAB = _cabcli;
                /* mcStorico.CODVOC := rowOpeUif.CODVOC */
                mcStorico.row.CODVOC = rowOpeUif.CODVOC;
                /* mcStorico.FLAGLIRE := rowOpeUif.FLAGLIRE */
                mcStorico.row.FLAGLIRE = rowOpeUif.FLAGLIRE;
                /* mcStorico.SEGNO := rowOpeUif.SEGNO */
                mcStorico.row.SEGNO = rowOpeUif.SEGNO;
                /* mcStorico.SETTSINT := _settsint */
                mcStorico.row.SETTSINT = _settsint;
                /* mcStorico.PAESECP := _paesecp */
                mcStorico.row.PAESECP = _paesecp;
                /* mcStorico.CODCABCP := _cabcp */
                mcStorico.row.CODCABCP = _cabcp;
                /* mcStorico.PAESEICP := _paeseicp */
                mcStorico.row.PAESEICP = _paeseicp;
                /* mcStorico.CABICP := _cabicp */
                mcStorico.row.CABICP = _cabicp;
                /* mcStorico.SaveRow() */
                mcStorico.SaveRow();
              } // End If
              /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_progrif)+'O'+LRTrim(rowOpeUif.NUMPROG) */
              _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_progrif)+"O"+CPLib.LRTrim(rowOpeUif.NUMPROG);
              /* mcStoricoDett.AppendWithKey(_chiave) */
              mcStoricoDett.AppendWithKey(_chiave);
              /* mcStoricoDett.ANNORIF := _anno */
              mcStoricoDett.row.ANNORIF = _anno;
              /* mcStoricoDett.MESERIF := _month */
              mcStoricoDett.row.MESERIF = _month;
              /* mcStoricoDett.PROGRIF := _progrif */
              mcStoricoDett.row.PROGRIF = _progrif;
              /* mcStoricoDett.TIPOPE := 'O' */
              mcStoricoDett.row.TIPOPE = "O";
              /* mcStoricoDett.NUMPROG := rowOpeUif.NUMPROG */
              mcStoricoDett.row.NUMPROG = rowOpeUif.NUMPROG;
              /* mcStoricoDett.DATAOPE := rowOpeUif.DATAOPE */
              mcStoricoDett.row.DATAOPE = rowOpeUif.DATAOPE;
              /* mcStoricoDett.CODVOC := rowOpeUif.CODVOC */
              mcStoricoDett.row.CODVOC = rowOpeUif.CODVOC;
              /* mcStoricoDett.FLAGLIRE := rowOpeUif.FLAGLIRE */
              mcStoricoDett.row.FLAGLIRE = rowOpeUif.FLAGLIRE;
              /* mcStoricoDett.SEGNO := rowOpeUif.SEGNO */
              mcStoricoDett.row.SEGNO = rowOpeUif.SEGNO;
              /* mcStoricoDett.TOTLIRE := _totimp */
              mcStoricoDett.row.TOTLIRE = _totimp;
              /* mcStoricoDett.TOTCONT := _totcon */
              mcStoricoDett.row.TOTCONT = _totcon;
              /* mcStoricoDett.CODINTDIP := _coddip */
              mcStoricoDett.row.CODINTDIP = _coddip;
              /* mcStoricoDett.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
              mcStoricoDett.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
              /* mcStoricoDett.CODCABDIP := _cabdip */
              mcStoricoDett.row.CODCABDIP = _cabdip;
              /* mcStoricoDett.RAPPORTO := rowOpeUif.RAPPORTO */
              mcStoricoDett.row.RAPPORTO = rowOpeUif.RAPPORTO;
              /* mcStoricoDett.CONNESCLI := rowOpeUif.CONNESCLI */
              mcStoricoDett.row.CONNESCLI = rowOpeUif.CONNESCLI;
              /* mcStoricoDett.PERPAESE := _paesecli */
              mcStoricoDett.row.PERPAESE = _paesecli;
              /* mcStoricoDett.PERCAB := _cabcli */
              mcStoricoDett.row.PERCAB = _cabcli;
              /* mcStoricoDett.SETTSINT := _settsint */
              mcStoricoDett.row.SETTSINT = _settsint;
              /* mcStoricoDett.CONNESBEN := rowOpeUif.CONNESBEN */
              mcStoricoDett.row.CONNESBEN = rowOpeUif.CONNESBEN;
              /* mcStoricoDett.PAESECP := _paesecp */
              mcStoricoDett.row.PAESECP = _paesecp;
              /* mcStoricoDett.CODCABCP := _cabcp */
              mcStoricoDett.row.CODCABCP = _cabcp;
              /* mcStoricoDett.INTCONTRO := rowOpeUif.CODINT2 */
              mcStoricoDett.row.INTCONTRO = rowOpeUif.CODINT2;
              /* mcStoricoDett.PAESEICP := _paeseicp */
              mcStoricoDett.row.PAESEICP = _paeseicp;
              /* mcStoricoDett.CABICP := _cabicp */
              mcStoricoDett.row.CABICP = _cabicp;
              /* mcStoricoDett.SaveRow() */
              mcStoricoDett.SaveRow();
              /* If _paeseicp <> '086' */
              if (CPLib.ne(_paeseicp,"086")) {
                /* mcExt.AppendBlank() */
                mcExt.AppendBlank();
                /* mcExt.CODINTDIP := _coddip */
                mcExt.row.CODINTDIP = _coddip;
                /* mcExt.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                mcExt.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                /* mcExt.CODCABDIP := LRTrim(_cabdip) */
                mcExt.row.CODCABDIP = CPLib.LRTrim(_cabdip);
                /* mcExt.PERPAESE := _paesecli */
                mcExt.row.PERPAESE = _paesecli;
                /* mcExt.PERCAB := _cabcli */
                mcExt.row.PERCAB = _cabcli;
                /* mcExt.CODVOC := rowOpeUif.CODVOC */
                mcExt.row.CODVOC = rowOpeUif.CODVOC;
                /* mcExt.FLAGLIRE := rowOpeUif.FLAGLIRE */
                mcExt.row.FLAGLIRE = rowOpeUif.FLAGLIRE;
                /* mcExt.SEGNO := rowOpeUif.SEGNO */
                mcExt.row.SEGNO = rowOpeUif.SEGNO;
                /* mcExt.SETTSINT := _settsint */
                mcExt.row.SETTSINT = _settsint;
                /* mcExt.PAESECP := _paesecp */
                mcExt.row.PAESECP = _paesecp;
                /* mcExt.CODCABCP := _cabcp */
                mcExt.row.CODCABCP = _cabcp;
                /* mcExt.PAESEICP := _paeseicp */
                mcExt.row.PAESEICP = _paeseicp;
                /* mcExt.CABICP := _cabicp */
                mcExt.row.CABICP = _cabicp;
                /* mcExt.TOTLIRE := _totimp */
                mcExt.row.TOTLIRE = _totimp;
                /* mcExt.TOTCONT := _totcon */
                mcExt.row.TOTCONT = _totcon;
                /* mcExt.OPERAZIONI := _operaz */
                mcExt.row.OPERAZIONI = _operaz;
                /* mcExt.CONTANTI := _ocont */
                mcExt.row.CONTANTI = _ocont;
                /* mcExt.SaveRow() */
                mcExt.SaveRow();
              } else { // Else
                /* mcIta.AppendBlank() */
                mcIta.AppendBlank();
                /* mcIta.CODINTDIP := _coddip */
                mcIta.row.CODINTDIP = _coddip;
                /* mcIta.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                mcIta.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                /* mcIta.CODCABDIP := LRTrim(_cabdip) */
                mcIta.row.CODCABDIP = CPLib.LRTrim(_cabdip);
                /* mcIta.PERPAESE := _paesecli */
                mcIta.row.PERPAESE = _paesecli;
                /* mcIta.PERCAB := _cabcli */
                mcIta.row.PERCAB = _cabcli;
                /* mcIta.CODVOC := rowOpeUif.CODVOC */
                mcIta.row.CODVOC = rowOpeUif.CODVOC;
                /* mcIta.FLAGLIRE := rowOpeUif.FLAGLIRE */
                mcIta.row.FLAGLIRE = rowOpeUif.FLAGLIRE;
                /* mcIta.SEGNO := rowOpeUif.SEGNO */
                mcIta.row.SEGNO = rowOpeUif.SEGNO;
                /* mcIta.SETTSINT := _settsint */
                mcIta.row.SETTSINT = _settsint;
                /* mcIta.PAESECP := _paesecp */
                mcIta.row.PAESECP = _paesecp;
                /* mcIta.CODCABCP := _cabcp */
                mcIta.row.CODCABCP = _cabcp;
                /* mcIta.PAESEICP := _paeseicp */
                mcIta.row.PAESEICP = _paeseicp;
                /* mcIta.CABICP := _cabicp */
                mcIta.row.CABICP = _cabicp;
                /* mcIta.TOTLIRE := _totimp */
                mcIta.row.TOTLIRE = _totimp;
                /* mcIta.TOTCONT := _totcon */
                mcIta.row.TOTCONT = _totcon;
                /* mcIta.OPERAZIONI := _operaz */
                mcIta.row.OPERAZIONI = _operaz;
                /* mcIta.CONTANTI := _ocont */
                mcIta.row.CONTANTI = _ocont;
                /* mcIta.SaveRow() */
                mcIta.SaveRow();
              } // End If
            } else { // Else
              /* _paesecp := '' */
              _paesecp = "";
              /* _cabcp := '' */
              _cabcp = "";
              /* _paeseicp := '' */
              _paeseicp = "";
              /* _cabicp := '' */
              _cabicp = "";
              /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_coddip)+iif(Empty(LRTrim(_abicab)),'000000000000',LRTrim(_abicab))+LRTrim(_cabdip)+LRTrim(_paesecli)+LRTrim(_cabcli)+LRTrim(rowOpeUif.CODVOC)+LRTrim(rowOpeUif.FLAGLIRE) */
              _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_coddip)+(CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":CPLib.LRTrim(_abicab))+CPLib.LRTrim(_cabdip)+CPLib.LRTrim(_paesecli)+CPLib.LRTrim(_cabcli)+CPLib.LRTrim(rowOpeUif.CODVOC)+CPLib.LRTrim(rowOpeUif.FLAGLIRE);
              /* _chiave := _chiave + LRTrim(rowOpeUif.SEGNO) + LRTrim(_settsint)+LRTrim(_paesecp)+LRTrim(_cabcp)+LRTrim(_paeseicp)+LRTrim(_cabicp) */
              _chiave = _chiave+CPLib.LRTrim(rowOpeUif.SEGNO)+CPLib.LRTrim(_settsint)+CPLib.LRTrim(_paesecp)+CPLib.LRTrim(_cabcp)+CPLib.LRTrim(_paeseicp)+CPLib.LRTrim(_cabicp);
              /* If not(mcStorico.GoToKey(_chiave)) */
              if ( ! (mcStorico.GoToKey(_chiave))) {
                /* _rifprog := _rifprog + 1 */
                _rifprog = CPLib.Round(_rifprog+1,0);
                /* _progrif := Right('0000000000'+LRTrim(Str(_rifprog,10,0)),10) */
                _progrif = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_rifprog,10,0)),10);
                /* mcStorico.AppendWithKey(_chiave) */
                mcStorico.AppendWithKey(_chiave);
                /* mcStorico.ANNORIF := _anno */
                mcStorico.row.ANNORIF = _anno;
                /* mcStorico.MESERIF := _month */
                mcStorico.row.MESERIF = _month;
                /* mcStorico.PROGRIF := _progrif */
                mcStorico.row.PROGRIF = _progrif;
                /* mcStorico.CODINTDIP := _coddip */
                mcStorico.row.CODINTDIP = _coddip;
                /* mcStorico.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                mcStorico.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                /* mcStorico.CODCABDIP := _cabdip */
                mcStorico.row.CODCABDIP = _cabdip;
                /* mcStorico.PERPAESE := _paesecli */
                mcStorico.row.PERPAESE = _paesecli;
                /* mcStorico.PERCAB := _cabcli */
                mcStorico.row.PERCAB = _cabcli;
                /* mcStorico.CODVOC := rowOpeUif.CODVOC */
                mcStorico.row.CODVOC = rowOpeUif.CODVOC;
                /* mcStorico.FLAGLIRE := rowOpeUif.FLAGLIRE */
                mcStorico.row.FLAGLIRE = rowOpeUif.FLAGLIRE;
                /* mcStorico.SEGNO := rowOpeUif.SEGNO */
                mcStorico.row.SEGNO = rowOpeUif.SEGNO;
                /* mcStorico.SETTSINT := _settsint */
                mcStorico.row.SETTSINT = _settsint;
                /* mcStorico.PAESECP := _paesecp */
                mcStorico.row.PAESECP = _paesecp;
                /* mcStorico.CODCABCP := _cabcp */
                mcStorico.row.CODCABCP = _cabcp;
                /* mcStorico.PAESEICP := _paeseicp */
                mcStorico.row.PAESEICP = _paeseicp;
                /* mcStorico.CABICP := _cabicp */
                mcStorico.row.CABICP = _cabicp;
                /* mcStorico.SaveRow() */
                mcStorico.SaveRow();
              } // End If
              /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_progrif)+'O'+LRTrim(rowOpeUif.NUMPROG) */
              _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_progrif)+"O"+CPLib.LRTrim(rowOpeUif.NUMPROG);
              /* mcStoricoDett.AppendWithKey(_chiave) */
              mcStoricoDett.AppendWithKey(_chiave);
              /* mcStoricoDett.ANNORIF := _anno */
              mcStoricoDett.row.ANNORIF = _anno;
              /* mcStoricoDett.MESERIF := _month */
              mcStoricoDett.row.MESERIF = _month;
              /* mcStoricoDett.PROGRIF := _progrif */
              mcStoricoDett.row.PROGRIF = _progrif;
              /* mcStoricoDett.TIPOPE := 'O' */
              mcStoricoDett.row.TIPOPE = "O";
              /* mcStoricoDett.NUMPROG := rowOpeUif.NUMPROG */
              mcStoricoDett.row.NUMPROG = rowOpeUif.NUMPROG;
              /* mcStoricoDett.DATAOPE := rowOpeUif.DATAOPE */
              mcStoricoDett.row.DATAOPE = rowOpeUif.DATAOPE;
              /* mcStoricoDett.CODVOC := rowOpeUif.CODVOC */
              mcStoricoDett.row.CODVOC = rowOpeUif.CODVOC;
              /* mcStoricoDett.FLAGLIRE := rowOpeUif.FLAGLIRE */
              mcStoricoDett.row.FLAGLIRE = rowOpeUif.FLAGLIRE;
              /* mcStoricoDett.SEGNO := rowOpeUif.SEGNO */
              mcStoricoDett.row.SEGNO = rowOpeUif.SEGNO;
              /* mcStoricoDett.TOTLIRE := _totimp */
              mcStoricoDett.row.TOTLIRE = _totimp;
              /* mcStoricoDett.TOTCONT := _totcon */
              mcStoricoDett.row.TOTCONT = _totcon;
              /* mcStoricoDett.CODINTDIP := _coddip */
              mcStoricoDett.row.CODINTDIP = _coddip;
              /* mcStoricoDett.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
              mcStoricoDett.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
              /* mcStoricoDett.CODCABDIP := _cabdip */
              mcStoricoDett.row.CODCABDIP = _cabdip;
              /* mcStoricoDett.RAPPORTO := rowOpeUif.RAPPORTO */
              mcStoricoDett.row.RAPPORTO = rowOpeUif.RAPPORTO;
              /* mcStoricoDett.CONNESCLI := rowOpeUif.CONNESCLI */
              mcStoricoDett.row.CONNESCLI = rowOpeUif.CONNESCLI;
              /* mcStoricoDett.PERPAESE := _paesecli */
              mcStoricoDett.row.PERPAESE = _paesecli;
              /* mcStoricoDett.PERCAB := _cabcli */
              mcStoricoDett.row.PERCAB = _cabcli;
              /* mcStoricoDett.SETTSINT := _settsint */
              mcStoricoDett.row.SETTSINT = _settsint;
              /* mcStoricoDett.CONNESBEN := rowOpeUif.CONNESBEN */
              mcStoricoDett.row.CONNESBEN = rowOpeUif.CONNESBEN;
              /* mcStoricoDett.PAESECP := _paesecp */
              mcStoricoDett.row.PAESECP = _paesecp;
              /* mcStoricoDett.CODCABCP := _cabcp */
              mcStoricoDett.row.CODCABCP = _cabcp;
              /* mcStoricoDett.INTCONTRO := rowOpeUif.CODINT2 */
              mcStoricoDett.row.INTCONTRO = rowOpeUif.CODINT2;
              /* mcStoricoDett.PAESEICP := _paeseicp */
              mcStoricoDett.row.PAESEICP = _paeseicp;
              /* mcStoricoDett.CABICP := _cabicp */
              mcStoricoDett.row.CABICP = _cabicp;
              /* mcStoricoDett.SaveRow() */
              mcStoricoDett.SaveRow();
              /* mcAlt.AppendBlank() */
              mcAlt.AppendBlank();
              /* mcAlt.CODINTDIP := _coddip */
              mcAlt.row.CODINTDIP = _coddip;
              /* mcAlt.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
              mcAlt.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
              /* mcAlt.CODCABDIP := LRTrim(_cabdip) */
              mcAlt.row.CODCABDIP = CPLib.LRTrim(_cabdip);
              /* mcAlt.PERPAESE := _paesecli */
              mcAlt.row.PERPAESE = _paesecli;
              /* mcAlt.PERCAB := _cabcli */
              mcAlt.row.PERCAB = _cabcli;
              /* mcAlt.CODVOC := rowOpeUif.CODVOC */
              mcAlt.row.CODVOC = rowOpeUif.CODVOC;
              /* mcAlt.FLAGLIRE := rowOpeUif.FLAGLIRE */
              mcAlt.row.FLAGLIRE = rowOpeUif.FLAGLIRE;
              /* mcAlt.SEGNO := rowOpeUif.SEGNO */
              mcAlt.row.SEGNO = rowOpeUif.SEGNO;
              /* mcAlt.SETTSINT := _settsint */
              mcAlt.row.SETTSINT = _settsint;
              /* mcAlt.PAESECP := _paesecp */
              mcAlt.row.PAESECP = _paesecp;
              /* mcAlt.CODCABCP := _cabcp */
              mcAlt.row.CODCABCP = _cabcp;
              /* mcAlt.PAESEICP := _paeseicp */
              mcAlt.row.PAESEICP = _paeseicp;
              /* mcAlt.CABICP := _cabicp */
              mcAlt.row.CABICP = _cabicp;
              /* mcAlt.TOTLIRE := _totimp */
              mcAlt.row.TOTLIRE = _totimp;
              /* mcAlt.TOTCONT := _totcon */
              mcAlt.row.TOTCONT = _totcon;
              /* mcAlt.OPERAZIONI := _operaz */
              mcAlt.row.OPERAZIONI = _operaz;
              /* mcAlt.CONTANTI := _ocont */
              mcAlt.row.CONTANTI = _ocont;
              /* mcAlt.SaveRow() */
              mcAlt.SaveRow();
            } // End If
            /* If _conta > 1 */
            if (CPLib.gt(_conta,1)) {
              // * --- Select from clientiope
              m_cServer = m_Ctx.GetServer("clientiope");
              m_cPhName = m_Ctx.GetPhName("clientiope");
              if (Cursor_clientiope!=null)
                Cursor_clientiope.Close();
              Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowOpeUif.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowOpeUif.IDBASE)+"  and  CODSOG <> "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowOpeUif.CONNESCLI,"?",0,0,m_cServer, m_oParameters),m_cServer,rowOpeUif.CONNESCLI)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_clientiope.Eof())) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* If w_storico='S' */
                  if (CPLib.eqr(w_storico,"S")) {
                    /* rowPers := arfn_datisog_sol_row(personbo->CONNES,rowOpeUif.DATAREG,rowOpeUif.STATOREG,rowOpeUif.DATARETT) */
                    rowPers = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("CONNES"),rowOpeUif.DATAREG,rowOpeUif.STATOREG,rowOpeUif.DATARETT);
                    /* _settsint := iif(Empty(rowPers.SETSINT),'999',rowPers.SETSINT) */
                    _settsint = (CPLib.Empty(rowPers.SETSINT)?"999":rowPers.SETSINT);
                    /* _paesecli := rowPers.STATO */
                    _paesecli = rowPers.STATO;
                    /* _cabcli := rowPers.CODCAB */
                    _cabcli = rowPers.CODCAB;
                    /* _sara := rowPers.NOSARA */
                    _sara = rowPers.NOSARA;
                  } else { // Else
                    /* _paesecli := personbo->PAESE */
                    _paesecli = Cursor_personbo.GetString("PAESE");
                    /* If _paesecli='086' */
                    if (CPLib.eqr(_paesecli,"086")) {
                      /* _cabcli := iif(not(Empty(personbo->CODCAB)),personbo->CODCAB,rowOpeUif.CODCAB2) */
                      _cabcli = ( ! (CPLib.Empty(Cursor_personbo.GetString("CODCAB")))?Cursor_personbo.GetString("CODCAB"):rowOpeUif.CODCAB2);
                    } else { // Else
                      /* _cabcli := '' */
                      _cabcli = "";
                    } // End If
                    /* _settsint := iif(Empty(personbo->SETTSINT),'999',personbo->SETTSINT) */
                    _settsint = (CPLib.Empty(Cursor_personbo.GetString("SETTSINT"))?"999":Cursor_personbo.GetString("SETTSINT"));
                    /* _sara := mcOpeUif.NOSARA */
                    _sara = mcOpeUif.row.NOSARA;
                  } // End If
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
                /* If _pqtotale=0 and clientiope->IMPSARA=0 */
                if (CPLib.eqr(_pqtotale,0) && CPLib.eqr(Cursor_clientiope.GetDouble("IMPSARA"),0)) {
                  /* _totimp := rowOpeUif.TOTLIRE / (_conta * 100) */
                  _totimp = CPLib.Round(rowOpeUif.TOTLIRE/(_conta*100),2);
                  /* _totcon := rowOpeUif.TOTCONT / (_conta * 100) */
                  _totcon = CPLib.Round(rowOpeUif.TOTCONT/(_conta*100),2);
                  /* ElseIf _pqtotale <> 0 and clientiope->IMPSARA=0 */
                } else if (CPLib.ne(_pqtotale,0) && CPLib.eqr(Cursor_clientiope.GetDouble("IMPSARA"),0)) {
                  /* _totimp := (rowOpeUif.TOTLIRE / 10000) * clientiope->PROQUOTA */
                  _totimp = CPLib.Round((rowOpeUif.TOTLIRE/10000)*Cursor_clientiope.GetDouble("PROQUOTA"),2);
                  /* _totcon := (rowOpeUif.TOTCONT / 10000)  * clientiope->PROQUOTA */
                  _totcon = CPLib.Round((rowOpeUif.TOTCONT/10000)*Cursor_clientiope.GetDouble("PROQUOTA"),2);
                  /* ElseIf _pqtotale = 0 and clientiope->IMPSARA <> 0 */
                } else if (CPLib.eqr(_pqtotale,0) && CPLib.ne(Cursor_clientiope.GetDouble("IMPSARA"),0)) {
                  /* _totimp := clientiope->IMPSARA */
                  _totimp = CPLib.Round(Cursor_clientiope.GetDouble("IMPSARA"),2);
                  /* _totcon := 0 */
                  _totcon = CPLib.Round(0,2);
                } // End If
                /* If At(LRTrim(rowOpeUif.CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
                if (CPLib.gt(CPLib.At(CPLib.LRTrim(rowOpeUif.CODVOC),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
                  /* _paesecp := LRTrim(rowOpeUif.C_STA) */
                  _paesecp = CPLib.LRTrim(rowOpeUif.C_STA);
                  /* If _autoic='S' */
                  if (CPLib.eqr(_autoic,"S")) {
                    /* _cabcp := iif(_paesecp <>'086','',LRTrim(rowOpeUif.C_CAB)) */
                    _cabcp = (CPLib.ne(_paesecp,"086")?"":CPLib.LRTrim(rowOpeUif.C_CAB));
                    /* If Empty(rowOpeUif.PAESE) */
                    if (CPLib.Empty(rowOpeUif.PAESE)) {
                      /* _paeseicp := _paesecp */
                      _paeseicp = _paesecp;
                    } else { // Else
                      /* _paeseicp := LRTrim(rowOpeUif.PAESE) */
                      _paeseicp = CPLib.LRTrim(rowOpeUif.PAESE);
                    } // End If
                    /* Case Empty(rowOpeUif.CODCAB2) and _paeseicp='086' */
                    if (CPLib.Empty(rowOpeUif.CODCAB2) && CPLib.eqr(_paeseicp,"086")) {
                      /* If _paesecp='086' */
                      if (CPLib.eqr(_paesecp,"086")) {
                        /* _cabicp := _cabcp */
                        _cabicp = _cabcp;
                      } else { // Else
                        /* _cabicp := '' */
                        _cabicp = "";
                      } // End If
                      /* Case Empty(rowOpeUif.CODCAB2) and _paeseicp<>'086' and not(Empty(_paeseicp)) */
                    } else if (CPLib.Empty(rowOpeUif.CODCAB2) && CPLib.ne(_paeseicp,"086") &&  ! (CPLib.Empty(_paeseicp))) {
                      /* _cabicp := '' */
                      _cabicp = "";
                      /* Case not(Empty(rowOpeUif.CODCAB2)) and _paeseicp = '086' */
                    } else if ( ! (CPLib.Empty(rowOpeUif.CODCAB2)) && CPLib.eqr(_paeseicp,"086")) {
                      /* _cabicp := rowOpeUif.CODCAB2 */
                      _cabicp = rowOpeUif.CODCAB2;
                    } // End Case
                  } else { // Else
                    /* _cabcp := LRTrim(rowOpeUif.C_CAB) */
                    _cabcp = CPLib.LRTrim(rowOpeUif.C_CAB);
                    /* _paeseicp := LRTrim(rowOpeUif.PAESE) */
                    _paeseicp = CPLib.LRTrim(rowOpeUif.PAESE);
                    /* _cabicp := LRTrim(rowOpeUif.CODCAB2) */
                    _cabicp = CPLib.LRTrim(rowOpeUif.CODCAB2);
                  } // End If
                  /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_progrif)+'O'+LRTrim(rowOpeUif.NUMPROG) */
                  _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_progrif)+"O"+CPLib.LRTrim(rowOpeUif.NUMPROG);
                  /* mcStoricoDett.AppendWithKey(_chiave) */
                  mcStoricoDett.AppendWithKey(_chiave);
                  /* mcStoricoDett.ANNORIF := _anno */
                  mcStoricoDett.row.ANNORIF = _anno;
                  /* mcStoricoDett.MESERIF := _month */
                  mcStoricoDett.row.MESERIF = _month;
                  /* mcStoricoDett.PROGRIF := _progrif */
                  mcStoricoDett.row.PROGRIF = _progrif;
                  /* mcStoricoDett.TIPOPE := 'O' */
                  mcStoricoDett.row.TIPOPE = "O";
                  /* mcStoricoDett.NUMPROG := rowOpeUif.NUMPROG */
                  mcStoricoDett.row.NUMPROG = rowOpeUif.NUMPROG;
                  /* mcStoricoDett.DATAOPE := rowOpeUif.DATAOPE */
                  mcStoricoDett.row.DATAOPE = rowOpeUif.DATAOPE;
                  /* mcStoricoDett.CODVOC := rowOpeUif.CODVOC */
                  mcStoricoDett.row.CODVOC = rowOpeUif.CODVOC;
                  /* mcStoricoDett.FLAGLIRE := rowOpeUif.FLAGLIRE */
                  mcStoricoDett.row.FLAGLIRE = rowOpeUif.FLAGLIRE;
                  /* mcStoricoDett.SEGNO := rowOpeUif.SEGNO */
                  mcStoricoDett.row.SEGNO = rowOpeUif.SEGNO;
                  /* mcStoricoDett.TOTLIRE := _totimp */
                  mcStoricoDett.row.TOTLIRE = _totimp;
                  /* mcStoricoDett.TOTCONT := _totcon */
                  mcStoricoDett.row.TOTCONT = _totcon;
                  /* mcStoricoDett.CODINTDIP := _coddip */
                  mcStoricoDett.row.CODINTDIP = _coddip;
                  /* mcStoricoDett.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                  mcStoricoDett.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                  /* mcStoricoDett.CODCABDIP := _cabdip */
                  mcStoricoDett.row.CODCABDIP = _cabdip;
                  /* mcStoricoDett.RAPPORTO := rowOpeUif.RAPPORTO */
                  mcStoricoDett.row.RAPPORTO = rowOpeUif.RAPPORTO;
                  /* mcStoricoDett.CONNESCLI := clientiope->CODSOG */
                  mcStoricoDett.row.CONNESCLI = Cursor_clientiope.GetString("CODSOG");
                  /* mcStoricoDett.PERPAESE := _paesecli */
                  mcStoricoDett.row.PERPAESE = _paesecli;
                  /* mcStoricoDett.PERCAB := _cabcli */
                  mcStoricoDett.row.PERCAB = _cabcli;
                  /* mcStoricoDett.SETTSINT := _settsint */
                  mcStoricoDett.row.SETTSINT = _settsint;
                  /* mcStoricoDett.CONNESBEN := rowOpeUif.CONNESBEN */
                  mcStoricoDett.row.CONNESBEN = rowOpeUif.CONNESBEN;
                  /* mcStoricoDett.PAESECP := _paesecp */
                  mcStoricoDett.row.PAESECP = _paesecp;
                  /* mcStoricoDett.CODCABCP := _cabcp */
                  mcStoricoDett.row.CODCABCP = _cabcp;
                  /* mcStoricoDett.INTCONTRO := rowOpeUif.CODINT2 */
                  mcStoricoDett.row.INTCONTRO = rowOpeUif.CODINT2;
                  /* mcStoricoDett.PAESEICP := _paeseicp */
                  mcStoricoDett.row.PAESEICP = _paeseicp;
                  /* mcStoricoDett.CABICP := _cabicp */
                  mcStoricoDett.row.CABICP = _cabicp;
                  /* mcStoricoDett.SaveRow() */
                  mcStoricoDett.SaveRow();
                  /* If _paeseicp <> '086' */
                  if (CPLib.ne(_paeseicp,"086")) {
                    /* mcExt.AppendBlank() */
                    mcExt.AppendBlank();
                    /* mcExt.CODINTDIP := _coddip */
                    mcExt.row.CODINTDIP = _coddip;
                    /* mcExt.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                    mcExt.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                    /* mcExt.CODCABDIP := LRTrim(_cabdip) */
                    mcExt.row.CODCABDIP = CPLib.LRTrim(_cabdip);
                    /* mcExt.PERPAESE := _paesecli */
                    mcExt.row.PERPAESE = _paesecli;
                    /* mcExt.PERCAB := _cabcli */
                    mcExt.row.PERCAB = _cabcli;
                    /* mcExt.CODVOC := rowOpeUif.CODVOC */
                    mcExt.row.CODVOC = rowOpeUif.CODVOC;
                    /* mcExt.FLAGLIRE := rowOpeUif.FLAGLIRE */
                    mcExt.row.FLAGLIRE = rowOpeUif.FLAGLIRE;
                    /* mcExt.SEGNO := rowOpeUif.SEGNO */
                    mcExt.row.SEGNO = rowOpeUif.SEGNO;
                    /* mcExt.SETTSINT := _settsint */
                    mcExt.row.SETTSINT = _settsint;
                    /* mcExt.PAESECP := _paesecp */
                    mcExt.row.PAESECP = _paesecp;
                    /* mcExt.CODCABCP := _cabcp */
                    mcExt.row.CODCABCP = _cabcp;
                    /* mcExt.PAESEICP := _paeseicp */
                    mcExt.row.PAESEICP = _paeseicp;
                    /* mcExt.CABICP := _cabicp */
                    mcExt.row.CABICP = _cabicp;
                    /* mcExt.TOTLIRE := _totimp */
                    mcExt.row.TOTLIRE = _totimp;
                    /* mcExt.TOTCONT := _totcon */
                    mcExt.row.TOTCONT = _totcon;
                    /* mcExt.OPERAZIONI := _operaz */
                    mcExt.row.OPERAZIONI = _operaz;
                    /* mcExt.CONTANTI := _ocont */
                    mcExt.row.CONTANTI = _ocont;
                    /* mcExt.SaveRow() */
                    mcExt.SaveRow();
                  } else { // Else
                    /* mcIta.AppendBlank() */
                    mcIta.AppendBlank();
                    /* mcIta.CODINTDIP := _coddip */
                    mcIta.row.CODINTDIP = _coddip;
                    /* mcIta.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                    mcIta.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                    /* mcIta.CODCABDIP := LRTrim(_cabdip) */
                    mcIta.row.CODCABDIP = CPLib.LRTrim(_cabdip);
                    /* mcIta.PERPAESE := _paesecli */
                    mcIta.row.PERPAESE = _paesecli;
                    /* mcIta.PERCAB := _cabcli */
                    mcIta.row.PERCAB = _cabcli;
                    /* mcIta.CODVOC := rowOpeUif.CODVOC */
                    mcIta.row.CODVOC = rowOpeUif.CODVOC;
                    /* mcIta.FLAGLIRE := rowOpeUif.FLAGLIRE */
                    mcIta.row.FLAGLIRE = rowOpeUif.FLAGLIRE;
                    /* mcIta.SEGNO := rowOpeUif.SEGNO */
                    mcIta.row.SEGNO = rowOpeUif.SEGNO;
                    /* mcIta.SETTSINT := _settsint */
                    mcIta.row.SETTSINT = _settsint;
                    /* mcIta.PAESECP := _paesecp */
                    mcIta.row.PAESECP = _paesecp;
                    /* mcIta.CODCABCP := _cabcp */
                    mcIta.row.CODCABCP = _cabcp;
                    /* mcIta.PAESEICP := _paeseicp */
                    mcIta.row.PAESEICP = _paeseicp;
                    /* mcIta.CABICP := _cabicp */
                    mcIta.row.CABICP = _cabicp;
                    /* mcIta.TOTLIRE := _totimp */
                    mcIta.row.TOTLIRE = _totimp;
                    /* mcIta.TOTCONT := _totcon */
                    mcIta.row.TOTCONT = _totcon;
                    /* mcIta.OPERAZIONI := _operaz */
                    mcIta.row.OPERAZIONI = _operaz;
                    /* mcIta.CONTANTI := _ocont */
                    mcIta.row.CONTANTI = _ocont;
                    /* mcIta.SaveRow() */
                    mcIta.SaveRow();
                  } // End If
                } else { // Else
                  /* _paesecp := '' */
                  _paesecp = "";
                  /* _cabcp := '' */
                  _cabcp = "";
                  /* _paeseicp := '' */
                  _paeseicp = "";
                  /* _cabicp := '' */
                  _cabicp = "";
                  /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_progrif)+'O'+LRTrim(rowOpeUif.NUMPROG) */
                  _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_progrif)+"O"+CPLib.LRTrim(rowOpeUif.NUMPROG);
                  /* mcStoricoDett.AppendWithKey(_chiave) */
                  mcStoricoDett.AppendWithKey(_chiave);
                  /* mcStoricoDett.ANNORIF := _anno */
                  mcStoricoDett.row.ANNORIF = _anno;
                  /* mcStoricoDett.MESERIF := _month */
                  mcStoricoDett.row.MESERIF = _month;
                  /* mcStoricoDett.PROGRIF := _progrif */
                  mcStoricoDett.row.PROGRIF = _progrif;
                  /* mcStoricoDett.TIPOPE := 'O' */
                  mcStoricoDett.row.TIPOPE = "O";
                  /* mcStoricoDett.NUMPROG := rowOpeUif.NUMPROG */
                  mcStoricoDett.row.NUMPROG = rowOpeUif.NUMPROG;
                  /* mcStoricoDett.DATAOPE := rowOpeUif.DATAOPE */
                  mcStoricoDett.row.DATAOPE = rowOpeUif.DATAOPE;
                  /* mcStoricoDett.CODVOC := rowOpeUif.CODVOC */
                  mcStoricoDett.row.CODVOC = rowOpeUif.CODVOC;
                  /* mcStoricoDett.FLAGLIRE := rowOpeUif.FLAGLIRE */
                  mcStoricoDett.row.FLAGLIRE = rowOpeUif.FLAGLIRE;
                  /* mcStoricoDett.SEGNO := rowOpeUif.SEGNO */
                  mcStoricoDett.row.SEGNO = rowOpeUif.SEGNO;
                  /* mcStoricoDett.TOTLIRE := _totimp */
                  mcStoricoDett.row.TOTLIRE = _totimp;
                  /* mcStoricoDett.TOTCONT := _totcon */
                  mcStoricoDett.row.TOTCONT = _totcon;
                  /* mcStoricoDett.CODINTDIP := _coddip */
                  mcStoricoDett.row.CODINTDIP = _coddip;
                  /* mcStoricoDett.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                  mcStoricoDett.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                  /* mcStoricoDett.CODCABDIP := _cabdip */
                  mcStoricoDett.row.CODCABDIP = _cabdip;
                  /* mcStoricoDett.RAPPORTO := rowOpeUif.RAPPORTO */
                  mcStoricoDett.row.RAPPORTO = rowOpeUif.RAPPORTO;
                  /* mcStoricoDett.CONNESCLI := clientiope->CODSOG */
                  mcStoricoDett.row.CONNESCLI = Cursor_clientiope.GetString("CODSOG");
                  /* mcStoricoDett.PERPAESE := _paesecli */
                  mcStoricoDett.row.PERPAESE = _paesecli;
                  /* mcStoricoDett.PERCAB := _cabcli */
                  mcStoricoDett.row.PERCAB = _cabcli;
                  /* mcStoricoDett.SETTSINT := _settsint */
                  mcStoricoDett.row.SETTSINT = _settsint;
                  /* mcStoricoDett.CONNESBEN := rowOpeUif.CONNESBEN */
                  mcStoricoDett.row.CONNESBEN = rowOpeUif.CONNESBEN;
                  /* mcStoricoDett.PAESECP := _paesecp */
                  mcStoricoDett.row.PAESECP = _paesecp;
                  /* mcStoricoDett.CODCABCP := _cabcp */
                  mcStoricoDett.row.CODCABCP = _cabcp;
                  /* mcStoricoDett.INTCONTRO := rowOpeUif.CODINT2 */
                  mcStoricoDett.row.INTCONTRO = rowOpeUif.CODINT2;
                  /* mcStoricoDett.PAESEICP := _paeseicp */
                  mcStoricoDett.row.PAESEICP = _paeseicp;
                  /* mcStoricoDett.CABICP := _cabicp */
                  mcStoricoDett.row.CABICP = _cabicp;
                  /* mcStoricoDett.SaveRow() */
                  mcStoricoDett.SaveRow();
                  /* mcAlt.AppendBlank() */
                  mcAlt.AppendBlank();
                  /* mcAlt.CODINTDIP := _coddip */
                  mcAlt.row.CODINTDIP = _coddip;
                  /* mcAlt.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                  mcAlt.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                  /* mcAlt.CODCABDIP := LRTrim(_cabdip) */
                  mcAlt.row.CODCABDIP = CPLib.LRTrim(_cabdip);
                  /* mcAlt.PERPAESE := _paesecli */
                  mcAlt.row.PERPAESE = _paesecli;
                  /* mcAlt.PERCAB := _cabcli */
                  mcAlt.row.PERCAB = _cabcli;
                  /* mcAlt.CODVOC := rowOpeUif.CODVOC */
                  mcAlt.row.CODVOC = rowOpeUif.CODVOC;
                  /* mcAlt.FLAGLIRE := rowOpeUif.FLAGLIRE */
                  mcAlt.row.FLAGLIRE = rowOpeUif.FLAGLIRE;
                  /* mcAlt.SEGNO := rowOpeUif.SEGNO */
                  mcAlt.row.SEGNO = rowOpeUif.SEGNO;
                  /* mcAlt.SETTSINT := _settsint */
                  mcAlt.row.SETTSINT = _settsint;
                  /* mcAlt.PAESECP := _paesecp */
                  mcAlt.row.PAESECP = _paesecp;
                  /* mcAlt.CODCABCP := _cabcp */
                  mcAlt.row.CODCABCP = _cabcp;
                  /* mcAlt.PAESEICP := _paeseicp */
                  mcAlt.row.PAESEICP = _paeseicp;
                  /* mcAlt.CABICP := _cabicp */
                  mcAlt.row.CABICP = _cabicp;
                  /* mcAlt.TOTLIRE := _totimp */
                  mcAlt.row.TOTLIRE = _totimp;
                  /* mcAlt.TOTCONT := _totcon */
                  mcAlt.row.TOTCONT = _totcon;
                  /* mcAlt.OPERAZIONI := _operaz */
                  mcAlt.row.OPERAZIONI = _operaz;
                  /* mcAlt.CONTANTI := _ocont */
                  mcAlt.row.CONTANTI = _ocont;
                  /* mcAlt.SaveRow() */
                  mcAlt.SaveRow();
                } // End If
                Cursor_clientiope.Next();
              }
              m_cConnectivityError = Cursor_clientiope.ErrorMessage();
              Cursor_clientiope.Close();
              // * --- End Select
            } // End If
          } // End If
        }
        /* _dataoggi := arfn_datesum(_dataoggi,1) */
        _dataoggi = arfn_datesumR.Make(m_Ctx,this).Run(_dataoggi,1);
        /* _cdataoggi := DateToChar(_dataoggi) */
        _cdataoggi = CPLib.DateToChar(_dataoggi);
      } // End While
      /* If _cope=0 */
      if (CPLib.eqr(_cope,0)) {
        /* gMsgProc := gMsgProc + NL + 'Non sono presenti dati da elaborare nel file Operazioni' + NL */
        gMsgProc = gMsgProc+"\n"+"Non sono presenti dati da elaborare nel file Operazioni"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + NL + 'Sono stati elaborati '+LRTrim(Str(_cope,10,0))+' record del file Operazioni' + NL */
        gMsgProc = gMsgProc+"\n"+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_cope,10,0))+" record del file Operazioni"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni' +NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_opeuif!=null)
          Cursor_qbe_opeuif.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientiope!=null)
          Cursor_clientiope.Close();
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
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_frauif=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla su fraziobo e seleziona i record nel range definito */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Frazionate' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Frazionate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Cicla su fraziobo e seleziona i record nel range definito */
      /* _contarow := 0 */
      _contarow = CPLib.Round(0,0);
      /* _dataoggi := _ddatini */
      _dataoggi = _ddatini;
      /* _cdataoggi := _datini */
      _cdataoggi = _datini;
      /* _oldmsg := '' */
      _oldmsg = "";
      /* _contaop := 0 */
      _contaop = CPLib.Round(0,0);
      /* _cope := 0 */
      _cope = CPLib.Round(0,0);
      /* While _dataoggi <= _ddatfin */
      while (CPLib.le(_dataoggi,_ddatfin)) {
        /* If Empty(_oldmsg) */
        if (CPLib.Empty(_oldmsg)) {
          /* gMsgProc := gMsgProc + 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file frazionate" // Messaggio */
          gMsgProc = gMsgProc+"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file frazionate";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file frazionate") // Messaggio */
          gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file frazionate");
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* _oldmsg := 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file frazionate" */
        _oldmsg = "Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file frazionate";
        /* mcFraUif.Zap() */
        mcFraUif.Zap();
        // * --- Fill memory cursor mcFraUif on qbe_frauif
        mcFraUif.Zap();
        SPBridge.HMCaller _h00000274;
        _h00000274 = new SPBridge.HMCaller();
        _h00000274.Set("m_cVQRList",m_cVQRList);
        _h00000274.Set("cdadata",_cdataoggi);
        if (Cursor_qbe_frauif!=null)
          Cursor_qbe_frauif.Close();
        Cursor_qbe_frauif = new VQRHolder("qbe_frauif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000274,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_frauif.Eof())) {
          mcFraUif.AppendBlank();
          mcFraUif.row.IDBASE = Cursor_qbe_frauif.GetString("IDBASE");
          mcFraUif.row.NUMPROG = Cursor_qbe_frauif.GetString("NUMPROG");
          mcFraUif.row.DATAOPE = Cursor_qbe_frauif.GetDate("DATAOPE");
          mcFraUif.row.TIPOINTER = Cursor_qbe_frauif.GetString("TIPOINTER");
          mcFraUif.row.CODINTER = Cursor_qbe_frauif.GetString("CODINTER");
          mcFraUif.row.TIPOINF = Cursor_qbe_frauif.GetString("TIPOINF");
          mcFraUif.row.IDEREG = Cursor_qbe_frauif.GetString("IDEREG");
          mcFraUif.row.DESCCIT = Cursor_qbe_frauif.GetString("DESCCIT");
          mcFraUif.row.CODDIPE = Cursor_qbe_frauif.GetString("CODDIPE");
          mcFraUif.row.PROVINCIA = Cursor_qbe_frauif.GetString("PROVINCIA");
          mcFraUif.row.CODCAB = Cursor_qbe_frauif.GetString("CODCAB");
          mcFraUif.row.FLAGFRAZ = Cursor_qbe_frauif.GetString("FLAGFRAZ");
          mcFraUif.row.FLAGCONT = Cursor_qbe_frauif.GetString("FLAGCONT");
          mcFraUif.row.CODANA = Cursor_qbe_frauif.GetString("CODANA");
          mcFraUif.row.CODVOC = Cursor_qbe_frauif.GetString("CODVOC");
          mcFraUif.row.TIPOINT2 = Cursor_qbe_frauif.GetString("TIPOINT2");
          mcFraUif.row.CODINT2 = Cursor_qbe_frauif.GetString("CODINT2");
          mcFraUif.row.PAESE = Cursor_qbe_frauif.GetString("PAESE");
          mcFraUif.row.DESC2 = Cursor_qbe_frauif.GetString("DESC2");
          mcFraUif.row.PROV2 = Cursor_qbe_frauif.GetString("PROV2");
          mcFraUif.row.CODCAB2 = Cursor_qbe_frauif.GetString("CODCAB2");
          mcFraUif.row.DESCINTER = Cursor_qbe_frauif.GetString("DESCINTER");
          mcFraUif.row.RAPPORTO = Cursor_qbe_frauif.GetString("RAPPORTO");
          mcFraUif.row.FLAGRAP = Cursor_qbe_frauif.GetString("FLAGRAP");
          mcFraUif.row.TIPOLEG = Cursor_qbe_frauif.GetString("TIPOLEG");
          mcFraUif.row.DATAREG = Cursor_qbe_frauif.GetDate("DATAREG");
          mcFraUif.row.OPRAP = Cursor_qbe_frauif.GetString("OPRAP");
          mcFraUif.row.TIPOOPRAP = Cursor_qbe_frauif.GetString("TIPOOPRAP");
          mcFraUif.row.FLAGLIRE = Cursor_qbe_frauif.GetString("FLAGLIRE");
          mcFraUif.row.VALUTA = Cursor_qbe_frauif.GetString("VALUTA");
          mcFraUif.row.SEGNO = Cursor_qbe_frauif.GetString("SEGNO");
          mcFraUif.row.TOTLIRE = Cursor_qbe_frauif.GetDouble("TOTLIRE");
          mcFraUif.row.TOTCONT = Cursor_qbe_frauif.GetDouble("TOTCONT");
          mcFraUif.row.STATOREG = Cursor_qbe_frauif.GetString("STATOREG");
          mcFraUif.row.OPERAZMOD = Cursor_qbe_frauif.GetString("OPERAZMOD");
          mcFraUif.row.DATARETT = Cursor_qbe_frauif.GetDate("DATARETT");
          mcFraUif.row.CONNESCLI = Cursor_qbe_frauif.GetString("CONNESCLI");
          mcFraUif.row.CONNESOPER = Cursor_qbe_frauif.GetString("CONNESOPER");
          mcFraUif.row.CONNESBEN = Cursor_qbe_frauif.GetString("CONNESBEN");
          mcFraUif.row.COLLEG = Cursor_qbe_frauif.GetString("COLLEG");
          mcFraUif.row.CAMBIO = Cursor_qbe_frauif.GetDouble("CAMBIO");
          mcFraUif.row.RAPPORTBEN = Cursor_qbe_frauif.GetString("RAPPORTBEN");
          mcFraUif.row.FLAGRAP2 = Cursor_qbe_frauif.GetString("FLAGRAP2");
          mcFraUif.row.OPERATORE = Cursor_qbe_frauif.GetString("OPERATORE");
          mcFraUif.row.AUTOM = Cursor_qbe_frauif.GetString("AUTOM");
          mcFraUif.row.idcauana = Cursor_qbe_frauif.GetString("idcauana");
          mcFraUif.row.OPERAG = Cursor_qbe_frauif.GetString("OPERAG");
          mcFraUif.row.DOCFILE = Cursor_qbe_frauif.GetString("DOCFILE");
          mcFraUif.row.RESPINS = Cursor_qbe_frauif.GetString("RESPINS");
          mcFraUif.row.INFORM = Cursor_qbe_frauif.GetString("INFORM");
          mcFraUif.row.CDATOPE = Cursor_qbe_frauif.GetString("CDATOPE");
          mcFraUif.row.NOPROT = Cursor_qbe_frauif.GetDouble("NOPROT");
          mcFraUif.row.UCODE = Cursor_qbe_frauif.GetString("UCODE");
          mcFraUif.row.CDATAOPE = Cursor_qbe_frauif.GetString("CDATAOPE");
          mcFraUif.row.ZCPARTE = Cursor_qbe_frauif.GetString("ZCPARTE");
          mcFraUif.row.RAGIO = Cursor_qbe_frauif.GetString("RAGIO");
          mcFraUif.row.MODSVOL = Cursor_qbe_frauif.GetString("MODSVOL");
          mcFraUif.row.AREAGEO = Cursor_qbe_frauif.GetString("AREAGEO");
          mcFraUif.row.C_CAB = Cursor_qbe_frauif.GetString("C_CAB");
          mcFraUif.row.C_STA = Cursor_qbe_frauif.GetString("C_STA");
          mcFraUif.row.RIFIMP = Cursor_qbe_frauif.GetString("RIFIMP");
          mcFraUif.row.PROQUOTA = Cursor_qbe_frauif.GetDouble("PROQUOTA");
          mcFraUif.row.IMPSARA = Cursor_qbe_frauif.GetDouble("IMPSARA");
          mcFraUif.row.CONNES = Cursor_qbe_frauif.GetString("CONNES");
          mcFraUif.row.RAGSOC = Cursor_qbe_frauif.GetString("RAGSOC");
          mcFraUif.row.CODFISC = Cursor_qbe_frauif.GetString("CODFISC");
          mcFraUif.row.PAESECLI = Cursor_qbe_frauif.GetString("PAESECLI");
          mcFraUif.row.CABCLI = Cursor_qbe_frauif.GetString("CABCLI");
          mcFraUif.row.DESCCITCLI = Cursor_qbe_frauif.GetString("DESCCITCLI");
          mcFraUif.row.SETTSINT = Cursor_qbe_frauif.GetString("SETTSINT");
          mcFraUif.row.SOTGRUP = Cursor_qbe_frauif.GetString("SOTGRUP");
          mcFraUif.row.SESSO = Cursor_qbe_frauif.GetString("SESSO");
          mcFraUif.row.NOSARA = Cursor_qbe_frauif.GetString("NOSARA");
          mcFraUif.row.CABDIP = Cursor_qbe_frauif.GetString("CABDIP");
          mcFraUif.row.ABICABSARA = Cursor_qbe_frauif.GetString("ABICABSARA");
          mcFraUif.row.CODDIP = Cursor_qbe_frauif.GetString("CODDIP");
          mcFraUif.row.DESCRIZ = Cursor_qbe_frauif.GetString("DESCRIZ");
          mcFraUif.row.DESCCITD = Cursor_qbe_frauif.GetString("DESCCITD");
          Cursor_qbe_frauif.Next();
        }
        m_cConnectivityError = Cursor_qbe_frauif.ErrorMessage();
        Cursor_qbe_frauif.Close();
        mcFraUif.GoTop();
        for (MemoryCursorRow_qbe_frauif_vqr rowFraUif : mcFraUif._iterable_()) {
          /* _cope := _cope + 1 */
          _cope = CPLib.Round(_cope+1,0);
          /* _conta := 1 */
          _conta = CPLib.Round(1,0);
          /* _nosara := 0 */
          _nosara = CPLib.Round(0,0);
          /* _settsint := iif(Empty(rowFraUif.SETTSINT),'999',rowFraUif.SETTSINT) */
          _settsint = (CPLib.Empty(rowFraUif.SETTSINT)?"999":rowFraUif.SETTSINT);
          /* Case rowFraUif.CDATOPE <= '20201231' */
          if (CPLib.le(rowFraUif.CDATOPE,"20201231")) {
            /* If _settsint = '811' or _settsint = '812' */
            if (CPLib.eqr(_settsint,"811") || CPLib.eqr(_settsint,"812")) {
              /* _settsint := '810' */
              _settsint = "810";
            } // End If
            /* If _settsint = '101' or _settsint = '102' or _settsint = '103' or _settsint = '104' */
            if (CPLib.eqr(_settsint,"101") || CPLib.eqr(_settsint,"102") || CPLib.eqr(_settsint,"103") || CPLib.eqr(_settsint,"104")) {
              /* _settsint := '100' */
              _settsint = "100";
            } // End If
            /* Case rowFraUif.CDATOPE <= '20111231' */
          } else if (CPLib.le(rowFraUif.CDATOPE,"20111231")) {
            /* If _settsint = '713' or _settsint = '712' */
            if (CPLib.eqr(_settsint,"713") || CPLib.eqr(_settsint,"712")) {
              /* _settsint := '710' */
              _settsint = "710";
            } // End If
          } // End Case
          /* _sara := rowFraUif.NOSARA */
          _sara = rowFraUif.NOSARA;
          /* _nosara := iif(_sara='S',1,0) */
          _nosara = CPLib.Round((CPLib.eqr(_sara,"S")?1:0),0);
          /* _pqtotale := rowFraUif.PROQUOTA */
          _pqtotale = CPLib.Round(rowFraUif.PROQUOTA,0);
          /* If _nosara=0 and _clientifrz */
          if (CPLib.eqr(_nosara,0) && _clientifrz) {
            // * --- Select from clientifrz
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            if (Cursor_clientifrz!=null)
              Cursor_clientifrz.Close();
            Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowFraUif.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowFraUif.IDBASE)+"  and  CODSOG <> "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowFraUif.CONNESCLI,"?",0,0,m_cServer, m_oParameters),m_cServer,rowFraUif.CONNESCLI)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientifrz.Eof())) {
              /* _sara := 'N' */
              _sara = "N";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"C",16,0,m_cServer),m_cServer,Cursor_clientifrz.GetString("CODSOG"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NOSARA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _sara = Read_Cursor.GetString("NOSARA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_discouic_xbrl returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _sara = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _nosara := _nosara + iif(_sara='N',0,1) */
              _nosara = CPLib.Round(_nosara+(CPLib.eqr(_sara,"N")?0:1),0);
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              /* _pqtotale := _pqtotale + clientifrz->PROQUOTA */
              _pqtotale = CPLib.Round(_pqtotale+Cursor_clientifrz.GetDouble("PROQUOTA"),0);
              Cursor_clientifrz.Next();
            }
            m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
            Cursor_clientifrz.Close();
            // * --- End Select
          } // End If
          /* If _conta > 1 */
          if (CPLib.gt(_conta,1)) {
            /* _operaz := 1 / _conta */
            _operaz = CPLib.Round(1/_conta,2);
            /* _ocont := iif(rowFraUif.TOTCONT <> 0,1 / _conta,0) */
            _ocont = CPLib.Round((CPLib.ne(rowFraUif.TOTCONT,0)?1/_conta:0),2);
          } else { // Else
            /* _operaz := 1 */
            _operaz = CPLib.Round(1,2);
            /* _ocont := iif(rowFraUif.TOTCONT <> 0,1,0) */
            _ocont = CPLib.Round((CPLib.ne(rowFraUif.TOTCONT,0)?1:0),2);
          } // End If
          /* If _nosara=0 */
          if (CPLib.eqr(_nosara,0)) {
            /* _totconta := _totconta + 1 */
            _totconta = CPLib.Round(_totconta+1,0);
            /* _contaop := _contaop + 1 */
            _contaop = CPLib.Round(_contaop+1,0);
            /* gMsgImp := 'Elaboro Frazionata N. '+ LRTrim(Str(_contaop,10,0)) // Messaggio Import */
            gMsgImp = "Elaboro Frazionata N. "+CPLib.LRTrim(CPLib.Str(_contaop,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _coddip := "" */
            _coddip = "";
            /* _abicab := '000000000000' */
            _abicab = "000000000000";
            /* _cabdip := '' */
            _cabdip = "";
            /* _paesecli := '' */
            _paesecli = "";
            /* _cabcli := '' */
            _cabcli = "";
            /* _paesecp := '' */
            _paesecp = "";
            /* _cabcp := '' */
            _cabcp = "";
            /* _paeseicp := '' */
            _paeseicp = "";
            /* _cabicp := '' */
            _cabicp = "";
            /* If Empty(LRTrim(rowFraUif.CODDIPE)) */
            if (CPLib.Empty(CPLib.LRTrim(rowFraUif.CODDIPE))) {
              /* If _tipcentro='02' */
              if (CPLib.eqr(_tipcentro,"02")) {
                /* _coddip := _dipbase */
                _coddip = _dipbase;
                /* _cabdip := _dipcab */
                _cabdip = _dipcab;
                /* _abicab := _dipabicab */
                _abicab = _dipabicab;
              } else { // Else
                /* _coddip := '000000' */
                _coddip = "000000";
                /* _cabdip := _cabint */
                _cabdip = _cabint;
              } // End If
            } else { // Else
              /* _coddip := rowFraUif.CODDIPE */
              _coddip = rowFraUif.CODDIPE;
              /* _cabdip := rowFraUif.CABDIP */
              _cabdip = rowFraUif.CABDIP;
              /* If Empty(_cabdip) */
              if (CPLib.Empty(_cabdip)) {
                // * --- Read from anadip
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_cSql = "";
                m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"C",6,0,m_cServer),m_cServer,_coddip);
                if (m_Ctx.IsSharedTemp("anadip")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("ABICABSARA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _cabdip = Read_Cursor.GetString("CAB");
                  _abicab = Read_Cursor.GetString("ABICABSARA");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_xbrl returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _cabdip = "";
                  _abicab = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } else { // Else
                // * --- Read from anadip
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_cSql = "";
                m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"C",6,0,m_cServer),m_cServer,_coddip);
                if (m_Ctx.IsSharedTemp("anadip")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ABICABSARA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _abicab = Read_Cursor.GetString("ABICABSARA");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_xbrl returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _abicab = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
            } // End If
            /* If w_storico='S' */
            if (CPLib.eqr(w_storico,"S")) {
              /* rowPers := arfn_datisog_sol_row(rowFraUif.CONNESCLI,rowFraUif.DATAREG,rowFraUif.STATOREG,rowFraUif.DATARETT) */
              rowPers = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(rowFraUif.CONNESCLI,rowFraUif.DATAREG,rowFraUif.STATOREG,rowFraUif.DATARETT);
              /* _settsint := iif(Empty(rowPers.SETSINT),'999',rowPers.SETSINT) */
              _settsint = (CPLib.Empty(rowPers.SETSINT)?"999":rowPers.SETSINT);
              /* _paesecli := rowPers.STATO */
              _paesecli = rowPers.STATO;
              /* _cabcli := rowPers.CODCAB */
              _cabcli = rowPers.CODCAB;
              /* _sara := rowPers.NOSARA */
              _sara = rowPers.NOSARA;
            } else { // Else
              /* _paesecli := rowFraUif.PAESECLI */
              _paesecli = rowFraUif.PAESECLI;
              /* If _paesecli='086' */
              if (CPLib.eqr(_paesecli,"086")) {
                /* _cabcli := iif(not(Empty(rowFraUif.CABCLI)),rowFraUif.CABCLI,rowFraUif.CODCAB2) */
                _cabcli = ( ! (CPLib.Empty(rowFraUif.CABCLI))?rowFraUif.CABCLI:rowFraUif.CODCAB2);
              } else { // Else
                /* _cabcli := '' */
                _cabcli = "";
              } // End If
            } // End If
            /* If _pqtotale=0 and rowFraUif.IMPSARA=0 */
            if (CPLib.eqr(_pqtotale,0) && CPLib.eqr(rowFraUif.IMPSARA,0)) {
              /* _totimp := rowFraUif.TOTLIRE / (_conta * 100) */
              _totimp = CPLib.Round(rowFraUif.TOTLIRE/(_conta*100),2);
              /* _totcon := rowFraUif.TOTCONT / (_conta * 100) */
              _totcon = CPLib.Round(rowFraUif.TOTCONT/(_conta*100),2);
              /* ElseIf _pqtotale <> 0 and rowFraUif.IMPSARA=0 */
            } else if (CPLib.ne(_pqtotale,0) && CPLib.eqr(rowFraUif.IMPSARA,0)) {
              /* _totimp := (rowFraUif.TOTLIRE / 10000) * rowFraUif.PROQUOTA */
              _totimp = CPLib.Round((rowFraUif.TOTLIRE/10000)*rowFraUif.PROQUOTA,2);
              /* _totcon := (rowFraUif.TOTCONT / 10000)  * rowFraUif.PROQUOTA */
              _totcon = CPLib.Round((rowFraUif.TOTCONT/10000)*rowFraUif.PROQUOTA,2);
              /* ElseIf _pqtotale = 0 and rowFraUif.IMPSARA <> 0 */
            } else if (CPLib.eqr(_pqtotale,0) && CPLib.ne(rowFraUif.IMPSARA,0)) {
              /* _totimp := rowFraUif.IMPSARA */
              _totimp = CPLib.Round(rowFraUif.IMPSARA,2);
              /* _totcon := 0 */
              _totcon = CPLib.Round(0,2);
            } // End If
            /* If At(LRTrim(rowFraUif.CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
            if (CPLib.gt(CPLib.At(CPLib.LRTrim(rowFraUif.CODVOC),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
              /* _paesecp := rowFraUif.C_STA */
              _paesecp = rowFraUif.C_STA;
              /* If _autoic='S' */
              if (CPLib.eqr(_autoic,"S")) {
                /* _cabcp := iif(_paesecp <>'086','',LRTrim(rowFraUif.C_CAB)) */
                _cabcp = (CPLib.ne(_paesecp,"086")?"":CPLib.LRTrim(rowFraUif.C_CAB));
                /* If Empty(rowFraUif.PAESE) */
                if (CPLib.Empty(rowFraUif.PAESE)) {
                  /* _paeseicp := _paesecp */
                  _paeseicp = _paesecp;
                } else { // Else
                  /* _paeseicp := LRTrim(rowFraUif.PAESE) */
                  _paeseicp = CPLib.LRTrim(rowFraUif.PAESE);
                } // End If
                /* Case Empty(rowFraUif.CODCAB2) and _paeseicp='086' */
                if (CPLib.Empty(rowFraUif.CODCAB2) && CPLib.eqr(_paeseicp,"086")) {
                  /* If _paesecp='086' */
                  if (CPLib.eqr(_paesecp,"086")) {
                    /* _cabicp := _cabcp */
                    _cabicp = _cabcp;
                  } else { // Else
                    /* _cabicp := '' */
                    _cabicp = "";
                  } // End If
                  /* Case Empty(rowFraUif.CODCAB2) and _paeseicp<>'086' and not(Empty(_paeseicp)) */
                } else if (CPLib.Empty(rowFraUif.CODCAB2) && CPLib.ne(_paeseicp,"086") &&  ! (CPLib.Empty(_paeseicp))) {
                  /* _cabicp := '' */
                  _cabicp = "";
                  /* Case not(Empty(rowFraUif.CODCAB2)) and _paeseicp = '086' */
                } else if ( ! (CPLib.Empty(rowFraUif.CODCAB2)) && CPLib.eqr(_paeseicp,"086")) {
                  /* _cabicp := rowFraUif.CODCAB2 */
                  _cabicp = rowFraUif.CODCAB2;
                } // End Case
              } else { // Else
                /* _cabcp := rowFraUif.C_CAB */
                _cabcp = rowFraUif.C_CAB;
                /* _paeseicp := LRTrim(rowFraUif.PAESE) */
                _paeseicp = CPLib.LRTrim(rowFraUif.PAESE);
                /* _cabicp := rowFraUif.CODCAB2 */
                _cabicp = rowFraUif.CODCAB2;
              } // End If
              /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_coddip)+iif(Empty(LRTrim(_abicab)),'000000000000',LRTrim(_abicab))+LRTrim(_cabdip)+LRTrim(_paesecli)+LRTrim(_cabcli)+LRTrim(rowFraUif.CODVOC)+LRTrim(rowFraUif.FLAGLIRE) */
              _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_coddip)+(CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":CPLib.LRTrim(_abicab))+CPLib.LRTrim(_cabdip)+CPLib.LRTrim(_paesecli)+CPLib.LRTrim(_cabcli)+CPLib.LRTrim(rowFraUif.CODVOC)+CPLib.LRTrim(rowFraUif.FLAGLIRE);
              /* _chiave := _chiave + LRTrim(rowFraUif.SEGNO) + LRTrim(_settsint)+LRTrim(_paesecp)+LRTrim(_cabcp)+LRTrim(_paeseicp)+LRTrim(_cabicp) */
              _chiave = _chiave+CPLib.LRTrim(rowFraUif.SEGNO)+CPLib.LRTrim(_settsint)+CPLib.LRTrim(_paesecp)+CPLib.LRTrim(_cabcp)+CPLib.LRTrim(_paeseicp)+CPLib.LRTrim(_cabicp);
              /* If not(mcStorico.GoToKey(_chiave)) */
              if ( ! (mcStorico.GoToKey(_chiave))) {
                /* _rifprog := _rifprog + 1 */
                _rifprog = CPLib.Round(_rifprog+1,0);
                /* _progrif := Right('0000000000'+LRTrim(Str(_rifprog,10,0)),10) */
                _progrif = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_rifprog,10,0)),10);
                /* mcStorico.AppendWithKey(_chiave) */
                mcStorico.AppendWithKey(_chiave);
                /* mcStorico.ANNORIF := _anno */
                mcStorico.row.ANNORIF = _anno;
                /* mcStorico.MESERIF := _month */
                mcStorico.row.MESERIF = _month;
                /* mcStorico.PROGRIF := _progrif */
                mcStorico.row.PROGRIF = _progrif;
                /* mcStorico.CODINTDIP := _coddip */
                mcStorico.row.CODINTDIP = _coddip;
                /* mcStorico.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                mcStorico.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                /* mcStorico.CODCABDIP := _cabdip */
                mcStorico.row.CODCABDIP = _cabdip;
                /* mcStorico.PERPAESE := _paesecli */
                mcStorico.row.PERPAESE = _paesecli;
                /* mcStorico.PERCAB := _cabcli */
                mcStorico.row.PERCAB = _cabcli;
                /* mcStorico.CODVOC := rowFraUif.CODVOC */
                mcStorico.row.CODVOC = rowFraUif.CODVOC;
                /* mcStorico.FLAGLIRE := rowFraUif.FLAGLIRE */
                mcStorico.row.FLAGLIRE = rowFraUif.FLAGLIRE;
                /* mcStorico.SEGNO := rowFraUif.SEGNO */
                mcStorico.row.SEGNO = rowFraUif.SEGNO;
                /* mcStorico.SETTSINT := _settsint */
                mcStorico.row.SETTSINT = _settsint;
                /* mcStorico.PAESECP := _paesecp */
                mcStorico.row.PAESECP = _paesecp;
                /* mcStorico.CODCABCP := _cabcp */
                mcStorico.row.CODCABCP = _cabcp;
                /* mcStorico.PAESEICP := _paeseicp */
                mcStorico.row.PAESEICP = _paeseicp;
                /* mcStorico.CABICP := _cabicp */
                mcStorico.row.CABICP = _cabicp;
                /* mcStorico.SaveRow() */
                mcStorico.SaveRow();
              } // End If
              /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_progrif)+'O'+LRTrim(rowFraUif.NUMPROG) */
              _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_progrif)+"O"+CPLib.LRTrim(rowFraUif.NUMPROG);
              /* mcStoricoDett.AppendWithKey(_chiave) */
              mcStoricoDett.AppendWithKey(_chiave);
              /* mcStoricoDett.ANNORIF := _anno */
              mcStoricoDett.row.ANNORIF = _anno;
              /* mcStoricoDett.MESERIF := _month */
              mcStoricoDett.row.MESERIF = _month;
              /* mcStoricoDett.PROGRIF := _progrif */
              mcStoricoDett.row.PROGRIF = _progrif;
              /* mcStoricoDett.TIPOPE := 'F' */
              mcStoricoDett.row.TIPOPE = "F";
              /* mcStoricoDett.NUMPROG := rowFraUif.NUMPROG */
              mcStoricoDett.row.NUMPROG = rowFraUif.NUMPROG;
              /* mcStoricoDett.DATAOPE := rowFraUif.DATAOPE */
              mcStoricoDett.row.DATAOPE = rowFraUif.DATAOPE;
              /* mcStoricoDett.CODVOC := rowFraUif.CODVOC */
              mcStoricoDett.row.CODVOC = rowFraUif.CODVOC;
              /* mcStoricoDett.FLAGLIRE := rowFraUif.FLAGLIRE */
              mcStoricoDett.row.FLAGLIRE = rowFraUif.FLAGLIRE;
              /* mcStoricoDett.SEGNO := rowFraUif.SEGNO */
              mcStoricoDett.row.SEGNO = rowFraUif.SEGNO;
              /* mcStoricoDett.TOTLIRE := _totimp */
              mcStoricoDett.row.TOTLIRE = _totimp;
              /* mcStoricoDett.TOTCONT := _totcon */
              mcStoricoDett.row.TOTCONT = _totcon;
              /* mcStoricoDett.CODINTDIP := _coddip */
              mcStoricoDett.row.CODINTDIP = _coddip;
              /* mcStoricoDett.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
              mcStoricoDett.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
              /* mcStoricoDett.CODCABDIP := _cabdip */
              mcStoricoDett.row.CODCABDIP = _cabdip;
              /* mcStoricoDett.RAPPORTO := rowFraUif.RAPPORTO */
              mcStoricoDett.row.RAPPORTO = rowFraUif.RAPPORTO;
              /* mcStoricoDett.CONNESCLI := rowFraUif.CONNESCLI */
              mcStoricoDett.row.CONNESCLI = rowFraUif.CONNESCLI;
              /* mcStoricoDett.PERPAESE := _paesecli */
              mcStoricoDett.row.PERPAESE = _paesecli;
              /* mcStoricoDett.PERCAB := _cabcli */
              mcStoricoDett.row.PERCAB = _cabcli;
              /* mcStoricoDett.SETTSINT := _settsint */
              mcStoricoDett.row.SETTSINT = _settsint;
              /* mcStoricoDett.CONNESBEN := rowFraUif.CONNESBEN */
              mcStoricoDett.row.CONNESBEN = rowFraUif.CONNESBEN;
              /* mcStoricoDett.PAESECP := _paesecp */
              mcStoricoDett.row.PAESECP = _paesecp;
              /* mcStoricoDett.CODCABCP := _cabcp */
              mcStoricoDett.row.CODCABCP = _cabcp;
              /* mcStoricoDett.INTCONTRO := rowFraUif.CODINT2 */
              mcStoricoDett.row.INTCONTRO = rowFraUif.CODINT2;
              /* mcStoricoDett.PAESEICP := _paeseicp */
              mcStoricoDett.row.PAESEICP = _paeseicp;
              /* mcStoricoDett.CABICP := _cabicp */
              mcStoricoDett.row.CABICP = _cabicp;
              /* mcStoricoDett.SaveRow() */
              mcStoricoDett.SaveRow();
              /* If _paeseicp <> '086' */
              if (CPLib.ne(_paeseicp,"086")) {
                /* mcExt.AppendBlank() */
                mcExt.AppendBlank();
                /* mcExt.CODINTDIP := _coddip */
                mcExt.row.CODINTDIP = _coddip;
                /* mcExt.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                mcExt.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                /* mcExt.CODCABDIP := _cabdip */
                mcExt.row.CODCABDIP = _cabdip;
                /* mcExt.PERPAESE := _paesecli */
                mcExt.row.PERPAESE = _paesecli;
                /* mcExt.PERCAB := _cabcli */
                mcExt.row.PERCAB = _cabcli;
                /* mcExt.CODVOC := rowFraUif.CODVOC */
                mcExt.row.CODVOC = rowFraUif.CODVOC;
                /* mcExt.FLAGLIRE := rowFraUif.FLAGLIRE */
                mcExt.row.FLAGLIRE = rowFraUif.FLAGLIRE;
                /* mcExt.SEGNO := rowFraUif.SEGNO */
                mcExt.row.SEGNO = rowFraUif.SEGNO;
                /* mcExt.SETTSINT := _settsint */
                mcExt.row.SETTSINT = _settsint;
                /* mcExt.PAESECP := _paesecp */
                mcExt.row.PAESECP = _paesecp;
                /* mcExt.CODCABCP := _cabcp */
                mcExt.row.CODCABCP = _cabcp;
                /* mcExt.PAESEICP := _paeseicp */
                mcExt.row.PAESEICP = _paeseicp;
                /* mcExt.CABICP := _cabicp */
                mcExt.row.CABICP = _cabicp;
                /* mcExt.TOTLIRE := _totimp */
                mcExt.row.TOTLIRE = _totimp;
                /* mcExt.TOTCONT := _totcon */
                mcExt.row.TOTCONT = _totcon;
                /* mcExt.OPERAZIONI := _operaz */
                mcExt.row.OPERAZIONI = _operaz;
                /* mcExt.CONTANTI := _ocont */
                mcExt.row.CONTANTI = _ocont;
                /* mcExt.SaveRow() */
                mcExt.SaveRow();
              } else { // Else
                /* mcIta.AppendBlank() */
                mcIta.AppendBlank();
                /* mcIta.CODINTDIP := _coddip */
                mcIta.row.CODINTDIP = _coddip;
                /* mcIta.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                mcIta.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                /* mcIta.CODCABDIP := _cabdip */
                mcIta.row.CODCABDIP = _cabdip;
                /* mcIta.PERPAESE := _paesecli */
                mcIta.row.PERPAESE = _paesecli;
                /* mcIta.PERCAB := _cabcli */
                mcIta.row.PERCAB = _cabcli;
                /* mcIta.CODVOC := rowFraUif.CODVOC */
                mcIta.row.CODVOC = rowFraUif.CODVOC;
                /* mcIta.FLAGLIRE := rowFraUif.FLAGLIRE */
                mcIta.row.FLAGLIRE = rowFraUif.FLAGLIRE;
                /* mcIta.SEGNO := rowFraUif.SEGNO */
                mcIta.row.SEGNO = rowFraUif.SEGNO;
                /* mcIta.SETTSINT := _settsint */
                mcIta.row.SETTSINT = _settsint;
                /* mcIta.PAESECP := _paesecp */
                mcIta.row.PAESECP = _paesecp;
                /* mcIta.CODCABCP := _cabcp */
                mcIta.row.CODCABCP = _cabcp;
                /* mcIta.PAESEICP := _paeseicp */
                mcIta.row.PAESEICP = _paeseicp;
                /* mcIta.CABICP := _cabicp */
                mcIta.row.CABICP = _cabicp;
                /* mcIta.TOTLIRE := _totimp */
                mcIta.row.TOTLIRE = _totimp;
                /* mcIta.TOTCONT := _totcon */
                mcIta.row.TOTCONT = _totcon;
                /* mcIta.OPERAZIONI := _operaz */
                mcIta.row.OPERAZIONI = _operaz;
                /* mcIta.CONTANTI := _ocont */
                mcIta.row.CONTANTI = _ocont;
                /* mcIta.SaveRow() */
                mcIta.SaveRow();
              } // End If
            } else { // Else
              /* _paesecp := '' */
              _paesecp = "";
              /* _cabcp := '' */
              _cabcp = "";
              /* _paeseicp := '' */
              _paeseicp = "";
              /* _cabicp := '' */
              _cabicp = "";
              /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_coddip)+iif(Empty(LRTrim(_abicab)),'000000000000',LRTrim(_abicab))+LRTrim(_cabdip)+LRTrim(_paesecli)+LRTrim(_cabcli)+LRTrim(rowFraUif.CODVOC)+LRTrim(rowFraUif.FLAGLIRE) */
              _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_coddip)+(CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":CPLib.LRTrim(_abicab))+CPLib.LRTrim(_cabdip)+CPLib.LRTrim(_paesecli)+CPLib.LRTrim(_cabcli)+CPLib.LRTrim(rowFraUif.CODVOC)+CPLib.LRTrim(rowFraUif.FLAGLIRE);
              /* _chiave := _chiave + LRTrim(rowFraUif.SEGNO) + LRTrim(_settsint)+LRTrim(_paesecp)+LRTrim(_cabcp)+LRTrim(_paeseicp)+LRTrim(_cabicp) */
              _chiave = _chiave+CPLib.LRTrim(rowFraUif.SEGNO)+CPLib.LRTrim(_settsint)+CPLib.LRTrim(_paesecp)+CPLib.LRTrim(_cabcp)+CPLib.LRTrim(_paeseicp)+CPLib.LRTrim(_cabicp);
              /* If not(mcStorico.GoToKey(_chiave)) */
              if ( ! (mcStorico.GoToKey(_chiave))) {
                /* _rifprog := _rifprog + 1 */
                _rifprog = CPLib.Round(_rifprog+1,0);
                /* _progrif := Right('0000000000'+LRTrim(Str(_rifprog,10,0)),10) */
                _progrif = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_rifprog,10,0)),10);
                /* mcStorico.AppendWithKey(_chiave) */
                mcStorico.AppendWithKey(_chiave);
                /* mcStorico.ANNORIF := _anno */
                mcStorico.row.ANNORIF = _anno;
                /* mcStorico.MESERIF := _month */
                mcStorico.row.MESERIF = _month;
                /* mcStorico.PROGRIF := _progrif */
                mcStorico.row.PROGRIF = _progrif;
                /* mcStorico.CODINTDIP := _coddip */
                mcStorico.row.CODINTDIP = _coddip;
                /* mcStorico.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                mcStorico.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                /* mcStorico.CODCABDIP := _cabdip */
                mcStorico.row.CODCABDIP = _cabdip;
                /* mcStorico.PERPAESE := _paesecli */
                mcStorico.row.PERPAESE = _paesecli;
                /* mcStorico.PERCAB := _cabcli */
                mcStorico.row.PERCAB = _cabcli;
                /* mcStorico.CODVOC := rowFraUif.CODVOC */
                mcStorico.row.CODVOC = rowFraUif.CODVOC;
                /* mcStorico.FLAGLIRE := rowFraUif.FLAGLIRE */
                mcStorico.row.FLAGLIRE = rowFraUif.FLAGLIRE;
                /* mcStorico.SEGNO := rowFraUif.SEGNO */
                mcStorico.row.SEGNO = rowFraUif.SEGNO;
                /* mcStorico.SETTSINT := _settsint */
                mcStorico.row.SETTSINT = _settsint;
                /* mcStorico.PAESECP := _paesecp */
                mcStorico.row.PAESECP = _paesecp;
                /* mcStorico.CODCABCP := _cabcp */
                mcStorico.row.CODCABCP = _cabcp;
                /* mcStorico.PAESEICP := _paeseicp */
                mcStorico.row.PAESEICP = _paeseicp;
                /* mcStorico.CABICP := _cabicp */
                mcStorico.row.CABICP = _cabicp;
                /* mcStorico.SaveRow() */
                mcStorico.SaveRow();
              } // End If
              /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_progrif)+'O'+LRTrim(rowFraUif.NUMPROG) */
              _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_progrif)+"O"+CPLib.LRTrim(rowFraUif.NUMPROG);
              /* mcStoricoDett.AppendWithKey(_chiave) */
              mcStoricoDett.AppendWithKey(_chiave);
              /* mcStoricoDett.ANNORIF := _anno */
              mcStoricoDett.row.ANNORIF = _anno;
              /* mcStoricoDett.MESERIF := _month */
              mcStoricoDett.row.MESERIF = _month;
              /* mcStoricoDett.PROGRIF := _progrif */
              mcStoricoDett.row.PROGRIF = _progrif;
              /* mcStoricoDett.TIPOPE := 'F' */
              mcStoricoDett.row.TIPOPE = "F";
              /* mcStoricoDett.NUMPROG := rowFraUif.NUMPROG */
              mcStoricoDett.row.NUMPROG = rowFraUif.NUMPROG;
              /* mcStoricoDett.DATAOPE := rowFraUif.DATAOPE */
              mcStoricoDett.row.DATAOPE = rowFraUif.DATAOPE;
              /* mcStoricoDett.CODVOC := rowFraUif.CODVOC */
              mcStoricoDett.row.CODVOC = rowFraUif.CODVOC;
              /* mcStoricoDett.FLAGLIRE := rowFraUif.FLAGLIRE */
              mcStoricoDett.row.FLAGLIRE = rowFraUif.FLAGLIRE;
              /* mcStoricoDett.SEGNO := rowFraUif.SEGNO */
              mcStoricoDett.row.SEGNO = rowFraUif.SEGNO;
              /* mcStoricoDett.TOTLIRE := _totimp */
              mcStoricoDett.row.TOTLIRE = _totimp;
              /* mcStoricoDett.TOTCONT := _totcon */
              mcStoricoDett.row.TOTCONT = _totcon;
              /* mcStoricoDett.CODINTDIP := _coddip */
              mcStoricoDett.row.CODINTDIP = _coddip;
              /* mcStoricoDett.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
              mcStoricoDett.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
              /* mcStoricoDett.CODCABDIP := _cabdip */
              mcStoricoDett.row.CODCABDIP = _cabdip;
              /* mcStoricoDett.RAPPORTO := rowFraUif.RAPPORTO */
              mcStoricoDett.row.RAPPORTO = rowFraUif.RAPPORTO;
              /* mcStoricoDett.CONNESCLI := rowFraUif.CONNESCLI */
              mcStoricoDett.row.CONNESCLI = rowFraUif.CONNESCLI;
              /* mcStoricoDett.PERPAESE := _paesecli */
              mcStoricoDett.row.PERPAESE = _paesecli;
              /* mcStoricoDett.PERCAB := _cabcli */
              mcStoricoDett.row.PERCAB = _cabcli;
              /* mcStoricoDett.SETTSINT := _settsint */
              mcStoricoDett.row.SETTSINT = _settsint;
              /* mcStoricoDett.CONNESBEN := rowFraUif.CONNESBEN */
              mcStoricoDett.row.CONNESBEN = rowFraUif.CONNESBEN;
              /* mcStoricoDett.PAESECP := _paesecp */
              mcStoricoDett.row.PAESECP = _paesecp;
              /* mcStoricoDett.CODCABCP := _cabcp */
              mcStoricoDett.row.CODCABCP = _cabcp;
              /* mcStoricoDett.INTCONTRO := rowFraUif.CODINT2 */
              mcStoricoDett.row.INTCONTRO = rowFraUif.CODINT2;
              /* mcStoricoDett.PAESEICP := _paeseicp */
              mcStoricoDett.row.PAESEICP = _paeseicp;
              /* mcStoricoDett.CABICP := _cabicp */
              mcStoricoDett.row.CABICP = _cabicp;
              /* mcStoricoDett.SaveRow() */
              mcStoricoDett.SaveRow();
              /* mcAlt.AppendBlank() */
              mcAlt.AppendBlank();
              /* mcAlt.CODINTDIP := _coddip */
              mcAlt.row.CODINTDIP = _coddip;
              /* mcAlt.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
              mcAlt.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
              /* mcAlt.CODCABDIP := _cabdip */
              mcAlt.row.CODCABDIP = _cabdip;
              /* mcAlt.PERPAESE := _paesecli */
              mcAlt.row.PERPAESE = _paesecli;
              /* mcAlt.PERCAB := _cabcli */
              mcAlt.row.PERCAB = _cabcli;
              /* mcAlt.CODVOC := rowFraUif.CODVOC */
              mcAlt.row.CODVOC = rowFraUif.CODVOC;
              /* mcAlt.FLAGLIRE := rowFraUif.FLAGLIRE */
              mcAlt.row.FLAGLIRE = rowFraUif.FLAGLIRE;
              /* mcAlt.SEGNO := rowFraUif.SEGNO */
              mcAlt.row.SEGNO = rowFraUif.SEGNO;
              /* mcAlt.SETTSINT := _settsint */
              mcAlt.row.SETTSINT = _settsint;
              /* mcAlt.PAESECP := _paesecp */
              mcAlt.row.PAESECP = _paesecp;
              /* mcAlt.CODCABCP := _cabcp */
              mcAlt.row.CODCABCP = _cabcp;
              /* mcAlt.PAESEICP := _paeseicp */
              mcAlt.row.PAESEICP = _paeseicp;
              /* mcAlt.CABICP := _cabicp */
              mcAlt.row.CABICP = _cabicp;
              /* mcAlt.TOTLIRE := _totimp */
              mcAlt.row.TOTLIRE = _totimp;
              /* mcAlt.TOTCONT := _totcon */
              mcAlt.row.TOTCONT = _totcon;
              /* mcAlt.OPERAZIONI := _operaz */
              mcAlt.row.OPERAZIONI = _operaz;
              /* mcAlt.CONTANTI := _ocont */
              mcAlt.row.CONTANTI = _ocont;
              /* mcAlt.SaveRow() */
              mcAlt.SaveRow();
            } // End If
            /* If _conta > 1 */
            if (CPLib.gt(_conta,1)) {
              // * --- Select from clientifrz
              m_cServer = m_Ctx.GetServer("clientifrz");
              m_cPhName = m_Ctx.GetPhName("clientifrz");
              if (Cursor_clientifrz!=null)
                Cursor_clientifrz.Close();
              Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowFraUif.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowFraUif.IDBASE)+"  and  CODSOG <> "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowFraUif.CONNESCLI,"?",0,0,m_cServer, m_oParameters),m_cServer,rowFraUif.CONNESCLI)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_clientifrz.Eof())) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* If w_storico='S' */
                  if (CPLib.eqr(w_storico,"S")) {
                    /* rowPers := arfn_datisog_sol_row(personbo->CONNES,rowFraUif.DATAREG,rowFraUif.STATOREG,rowFraUif.DATARETT) */
                    rowPers = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("CONNES"),rowFraUif.DATAREG,rowFraUif.STATOREG,rowFraUif.DATARETT);
                    /* _paesecli := rowPers.STATO */
                    _paesecli = rowPers.STATO;
                    /* _cabcli := rowPers.CODCAB */
                    _cabcli = rowPers.CODCAB;
                    /* _settsint := iif(Empty(rowPers.SETSINT),'999',rowPers.SETSINT) */
                    _settsint = (CPLib.Empty(rowPers.SETSINT)?"999":rowPers.SETSINT);
                    /* _sara := rowPers.NOSARA */
                    _sara = rowPers.NOSARA;
                  } else { // Else
                    /* _settsint := iif(Empty(personbo->SETTSINT),'999',personbo->SETTSINT) */
                    _settsint = (CPLib.Empty(Cursor_personbo.GetString("SETTSINT"))?"999":Cursor_personbo.GetString("SETTSINT"));
                    /* _paesecli := personbo->PAESE */
                    _paesecli = Cursor_personbo.GetString("PAESE");
                    /* If _paesecli='086' */
                    if (CPLib.eqr(_paesecli,"086")) {
                      /* _cabcli := iif(not(Empty(personbo->CODCAB)),personbo->CODCAB,rowFraUif.CODCAB2) */
                      _cabcli = ( ! (CPLib.Empty(Cursor_personbo.GetString("CODCAB")))?Cursor_personbo.GetString("CODCAB"):rowFraUif.CODCAB2);
                    } else { // Else
                      /* _cabcli := '' */
                      _cabcli = "";
                    } // End If
                    /* _sara := mcOpeUif.NOSARA */
                    _sara = mcOpeUif.row.NOSARA;
                  } // End If
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
                /* If _pqtotale=0 and clientifrz->IMPSARA=0 */
                if (CPLib.eqr(_pqtotale,0) && CPLib.eqr(Cursor_clientifrz.GetDouble("IMPSARA"),0)) {
                  /* _totimp := rowFraUif.TOTLIRE / (_conta * 100) */
                  _totimp = CPLib.Round(rowFraUif.TOTLIRE/(_conta*100),2);
                  /* _totcon := rowFraUif.TOTCONT / (_conta * 100) */
                  _totcon = CPLib.Round(rowFraUif.TOTCONT/(_conta*100),2);
                  /* ElseIf _pqtotale <> 0 and clientifrz->IMPSARA=0 */
                } else if (CPLib.ne(_pqtotale,0) && CPLib.eqr(Cursor_clientifrz.GetDouble("IMPSARA"),0)) {
                  /* _totimp := (rowFraUif.TOTLIRE / 10000) * clientifrz->PROQUOTA */
                  _totimp = CPLib.Round((rowFraUif.TOTLIRE/10000)*Cursor_clientifrz.GetDouble("PROQUOTA"),2);
                  /* _totcon := (rowFraUif.TOTCONT / 10000)  * clientifrz->PROQUOTA */
                  _totcon = CPLib.Round((rowFraUif.TOTCONT/10000)*Cursor_clientifrz.GetDouble("PROQUOTA"),2);
                  /* ElseIf _pqtotale = 0 and clientifrz->IMPSARA <> 0 */
                } else if (CPLib.eqr(_pqtotale,0) && CPLib.ne(Cursor_clientifrz.GetDouble("IMPSARA"),0)) {
                  /* _totimp := clientifrz->IMPSARA */
                  _totimp = CPLib.Round(Cursor_clientifrz.GetDouble("IMPSARA"),2);
                  /* _totcon := 0 */
                  _totcon = CPLib.Round(0,2);
                } // End If
                /* If At(LRTrim(rowFraUif.CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
                if (CPLib.gt(CPLib.At(CPLib.LRTrim(rowFraUif.CODVOC),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
                  /* _paesecp := rowFraUif.C_STA */
                  _paesecp = rowFraUif.C_STA;
                  /* If _autoic='S' */
                  if (CPLib.eqr(_autoic,"S")) {
                    /* _cabcp := iif(_paesecp <>'086','',LRTrim(rowFraUif.C_CAB)) */
                    _cabcp = (CPLib.ne(_paesecp,"086")?"":CPLib.LRTrim(rowFraUif.C_CAB));
                    /* If Empty(rowFraUif.PAESE) */
                    if (CPLib.Empty(rowFraUif.PAESE)) {
                      /* _paeseicp := _paesecp */
                      _paeseicp = _paesecp;
                    } else { // Else
                      /* _paeseicp := LRTrim(rowFraUif.PAESE) */
                      _paeseicp = CPLib.LRTrim(rowFraUif.PAESE);
                    } // End If
                    /* Case Empty(rowFraUif.CODCAB2) and _paeseicp='086' */
                    if (CPLib.Empty(rowFraUif.CODCAB2) && CPLib.eqr(_paeseicp,"086")) {
                      /* If _paesecp='086' */
                      if (CPLib.eqr(_paesecp,"086")) {
                        /* _cabicp := _cabcp */
                        _cabicp = _cabcp;
                      } else { // Else
                        /* _cabicp := '' */
                        _cabicp = "";
                      } // End If
                      /* Case Empty(rowFraUif.CODCAB2) and _paeseicp<>'086' and not(Empty(_paeseicp)) */
                    } else if (CPLib.Empty(rowFraUif.CODCAB2) && CPLib.ne(_paeseicp,"086") &&  ! (CPLib.Empty(_paeseicp))) {
                      /* _cabicp := '' */
                      _cabicp = "";
                      /* Case not(Empty(rowFraUif.CODCAB2)) and _paeseicp = '086' */
                    } else if ( ! (CPLib.Empty(rowFraUif.CODCAB2)) && CPLib.eqr(_paeseicp,"086")) {
                      /* _cabicp := rowFraUif.CODCAB2 */
                      _cabicp = rowFraUif.CODCAB2;
                    } // End Case
                  } else { // Else
                    /* _cabcp := rowFraUif.C_CAB */
                    _cabcp = rowFraUif.C_CAB;
                    /* _paeseicp := LRTrim(rowFraUif.PAESE) */
                    _paeseicp = CPLib.LRTrim(rowFraUif.PAESE);
                    /* _cabicp := rowFraUif.CODCAB2 */
                    _cabicp = rowFraUif.CODCAB2;
                  } // End If
                  /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_progrif)+'O'+LRTrim(rowFraUif.NUMPROG) */
                  _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_progrif)+"O"+CPLib.LRTrim(rowFraUif.NUMPROG);
                  /* mcStoricoDett.AppendWithKey(_chiave) */
                  mcStoricoDett.AppendWithKey(_chiave);
                  /* mcStoricoDett.ANNORIF := _anno */
                  mcStoricoDett.row.ANNORIF = _anno;
                  /* mcStoricoDett.MESERIF := _month */
                  mcStoricoDett.row.MESERIF = _month;
                  /* mcStoricoDett.PROGRIF := _progrif */
                  mcStoricoDett.row.PROGRIF = _progrif;
                  /* mcStoricoDett.TIPOPE := 'F' */
                  mcStoricoDett.row.TIPOPE = "F";
                  /* mcStoricoDett.NUMPROG := rowFraUif.NUMPROG */
                  mcStoricoDett.row.NUMPROG = rowFraUif.NUMPROG;
                  /* mcStoricoDett.DATAOPE := rowFraUif.DATAOPE */
                  mcStoricoDett.row.DATAOPE = rowFraUif.DATAOPE;
                  /* mcStoricoDett.CODVOC := rowFraUif.CODVOC */
                  mcStoricoDett.row.CODVOC = rowFraUif.CODVOC;
                  /* mcStoricoDett.FLAGLIRE := rowFraUif.FLAGLIRE */
                  mcStoricoDett.row.FLAGLIRE = rowFraUif.FLAGLIRE;
                  /* mcStoricoDett.SEGNO := rowFraUif.SEGNO */
                  mcStoricoDett.row.SEGNO = rowFraUif.SEGNO;
                  /* mcStoricoDett.TOTLIRE := _totimp */
                  mcStoricoDett.row.TOTLIRE = _totimp;
                  /* mcStoricoDett.TOTCONT := _totcon */
                  mcStoricoDett.row.TOTCONT = _totcon;
                  /* mcStoricoDett.CODINTDIP := _coddip */
                  mcStoricoDett.row.CODINTDIP = _coddip;
                  /* mcStoricoDett.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                  mcStoricoDett.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                  /* mcStoricoDett.CODCABDIP := _cabdip */
                  mcStoricoDett.row.CODCABDIP = _cabdip;
                  /* mcStoricoDett.RAPPORTO := rowFraUif.RAPPORTO */
                  mcStoricoDett.row.RAPPORTO = rowFraUif.RAPPORTO;
                  /* mcStoricoDett.CONNESCLI := rowFraUif.CONNESCLI */
                  mcStoricoDett.row.CONNESCLI = rowFraUif.CONNESCLI;
                  /* mcStoricoDett.PERPAESE := _paesecli */
                  mcStoricoDett.row.PERPAESE = _paesecli;
                  /* mcStoricoDett.PERCAB := _cabcli */
                  mcStoricoDett.row.PERCAB = _cabcli;
                  /* mcStoricoDett.SETTSINT := _settsint */
                  mcStoricoDett.row.SETTSINT = _settsint;
                  /* mcStoricoDett.CONNESBEN := clientifrz->CODSOG */
                  mcStoricoDett.row.CONNESBEN = Cursor_clientifrz.GetString("CODSOG");
                  /* mcStoricoDett.PAESECP := _paesecp */
                  mcStoricoDett.row.PAESECP = _paesecp;
                  /* mcStoricoDett.CODCABCP := _cabcp */
                  mcStoricoDett.row.CODCABCP = _cabcp;
                  /* mcStoricoDett.INTCONTRO := rowFraUif.CODINT2 */
                  mcStoricoDett.row.INTCONTRO = rowFraUif.CODINT2;
                  /* mcStoricoDett.PAESEICP := _paeseicp */
                  mcStoricoDett.row.PAESEICP = _paeseicp;
                  /* mcStoricoDett.CABICP := _cabicp */
                  mcStoricoDett.row.CABICP = _cabicp;
                  /* mcStoricoDett.SaveRow() */
                  mcStoricoDett.SaveRow();
                  /* If _paeseicp <> '086' */
                  if (CPLib.ne(_paeseicp,"086")) {
                    /* mcExt.AppendBlank() */
                    mcExt.AppendBlank();
                    /* mcExt.CODINTDIP := _coddip */
                    mcExt.row.CODINTDIP = _coddip;
                    /* mcExt.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                    mcExt.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                    /* mcExt.CODCABDIP := _cabdip */
                    mcExt.row.CODCABDIP = _cabdip;
                    /* mcExt.PERPAESE := _paesecli */
                    mcExt.row.PERPAESE = _paesecli;
                    /* mcExt.PERCAB := _cabcli */
                    mcExt.row.PERCAB = _cabcli;
                    /* mcExt.CODVOC := rowFraUif.CODVOC */
                    mcExt.row.CODVOC = rowFraUif.CODVOC;
                    /* mcExt.FLAGLIRE := rowFraUif.FLAGLIRE */
                    mcExt.row.FLAGLIRE = rowFraUif.FLAGLIRE;
                    /* mcExt.SEGNO := rowFraUif.SEGNO */
                    mcExt.row.SEGNO = rowFraUif.SEGNO;
                    /* mcExt.SETTSINT := _settsint */
                    mcExt.row.SETTSINT = _settsint;
                    /* mcExt.PAESECP := _paesecp */
                    mcExt.row.PAESECP = _paesecp;
                    /* mcExt.CODCABCP := _cabcp */
                    mcExt.row.CODCABCP = _cabcp;
                    /* mcExt.PAESEICP := _paeseicp */
                    mcExt.row.PAESEICP = _paeseicp;
                    /* mcExt.CABICP := _cabicp */
                    mcExt.row.CABICP = _cabicp;
                    /* mcExt.TOTLIRE := _totimp */
                    mcExt.row.TOTLIRE = _totimp;
                    /* mcExt.TOTCONT := _totcon */
                    mcExt.row.TOTCONT = _totcon;
                    /* mcExt.OPERAZIONI := _operaz */
                    mcExt.row.OPERAZIONI = _operaz;
                    /* mcExt.CONTANTI := _ocont */
                    mcExt.row.CONTANTI = _ocont;
                    /* mcExt.SaveRow() */
                    mcExt.SaveRow();
                  } else { // Else
                    /* mcIta.AppendBlank() */
                    mcIta.AppendBlank();
                    /* mcIta.CODINTDIP := _coddip */
                    mcIta.row.CODINTDIP = _coddip;
                    /* mcIta.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                    mcIta.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                    /* mcIta.CODCABDIP := _cabdip */
                    mcIta.row.CODCABDIP = _cabdip;
                    /* mcIta.PERPAESE := _paesecli */
                    mcIta.row.PERPAESE = _paesecli;
                    /* mcIta.PERCAB := _cabcli */
                    mcIta.row.PERCAB = _cabcli;
                    /* mcIta.CODVOC := rowFraUif.CODVOC */
                    mcIta.row.CODVOC = rowFraUif.CODVOC;
                    /* mcIta.FLAGLIRE := rowFraUif.FLAGLIRE */
                    mcIta.row.FLAGLIRE = rowFraUif.FLAGLIRE;
                    /* mcIta.SEGNO := rowFraUif.SEGNO */
                    mcIta.row.SEGNO = rowFraUif.SEGNO;
                    /* mcIta.SETTSINT := _settsint */
                    mcIta.row.SETTSINT = _settsint;
                    /* mcIta.PAESECP := _paesecp */
                    mcIta.row.PAESECP = _paesecp;
                    /* mcIta.CODCABCP := _cabcp */
                    mcIta.row.CODCABCP = _cabcp;
                    /* mcIta.PAESEICP := _paeseicp */
                    mcIta.row.PAESEICP = _paeseicp;
                    /* mcIta.CABICP := _cabicp */
                    mcIta.row.CABICP = _cabicp;
                    /* mcIta.TOTLIRE := _totimp */
                    mcIta.row.TOTLIRE = _totimp;
                    /* mcIta.TOTCONT := _totcon */
                    mcIta.row.TOTCONT = _totcon;
                    /* mcIta.OPERAZIONI := _operaz */
                    mcIta.row.OPERAZIONI = _operaz;
                    /* mcIta.CONTANTI := _ocont */
                    mcIta.row.CONTANTI = _ocont;
                    /* mcIta.SaveRow() */
                    mcIta.SaveRow();
                  } // End If
                } else { // Else
                  /* _paesecp := '' */
                  _paesecp = "";
                  /* _cabcp := '' */
                  _cabcp = "";
                  /* _paeseicp := '' */
                  _paeseicp = "";
                  /* _cabicp := '' */
                  _cabicp = "";
                  /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_progrif)+'O'+LRTrim(rowFraUif.NUMPROG) */
                  _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_progrif)+"O"+CPLib.LRTrim(rowFraUif.NUMPROG);
                  /* mcStoricoDett.AppendWithKey(_chiave) */
                  mcStoricoDett.AppendWithKey(_chiave);
                  /* mcStoricoDett.ANNORIF := _anno */
                  mcStoricoDett.row.ANNORIF = _anno;
                  /* mcStoricoDett.MESERIF := _month */
                  mcStoricoDett.row.MESERIF = _month;
                  /* mcStoricoDett.PROGRIF := _progrif */
                  mcStoricoDett.row.PROGRIF = _progrif;
                  /* mcStoricoDett.TIPOPE := 'F' */
                  mcStoricoDett.row.TIPOPE = "F";
                  /* mcStoricoDett.NUMPROG := rowFraUif.NUMPROG */
                  mcStoricoDett.row.NUMPROG = rowFraUif.NUMPROG;
                  /* mcStoricoDett.DATAOPE := rowFraUif.DATAOPE */
                  mcStoricoDett.row.DATAOPE = rowFraUif.DATAOPE;
                  /* mcStoricoDett.CODVOC := rowFraUif.CODVOC */
                  mcStoricoDett.row.CODVOC = rowFraUif.CODVOC;
                  /* mcStoricoDett.FLAGLIRE := rowFraUif.FLAGLIRE */
                  mcStoricoDett.row.FLAGLIRE = rowFraUif.FLAGLIRE;
                  /* mcStoricoDett.SEGNO := rowFraUif.SEGNO */
                  mcStoricoDett.row.SEGNO = rowFraUif.SEGNO;
                  /* mcStoricoDett.TOTLIRE := _totimp */
                  mcStoricoDett.row.TOTLIRE = _totimp;
                  /* mcStoricoDett.TOTCONT := _totcon */
                  mcStoricoDett.row.TOTCONT = _totcon;
                  /* mcStoricoDett.CODINTDIP := _coddip */
                  mcStoricoDett.row.CODINTDIP = _coddip;
                  /* mcStoricoDett.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                  mcStoricoDett.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                  /* mcStoricoDett.CODCABDIP := _cabdip */
                  mcStoricoDett.row.CODCABDIP = _cabdip;
                  /* mcStoricoDett.RAPPORTO := rowFraUif.RAPPORTO */
                  mcStoricoDett.row.RAPPORTO = rowFraUif.RAPPORTO;
                  /* mcStoricoDett.CONNESCLI := rowFraUif.CONNESCLI */
                  mcStoricoDett.row.CONNESCLI = rowFraUif.CONNESCLI;
                  /* mcStoricoDett.PERPAESE := _paesecli */
                  mcStoricoDett.row.PERPAESE = _paesecli;
                  /* mcStoricoDett.PERCAB := _cabcli */
                  mcStoricoDett.row.PERCAB = _cabcli;
                  /* mcStoricoDett.SETTSINT := _settsint */
                  mcStoricoDett.row.SETTSINT = _settsint;
                  /* mcStoricoDett.CONNESBEN := clientifrz->CODSOG */
                  mcStoricoDett.row.CONNESBEN = Cursor_clientifrz.GetString("CODSOG");
                  /* mcStoricoDett.PAESECP := _paesecp */
                  mcStoricoDett.row.PAESECP = _paesecp;
                  /* mcStoricoDett.CODCABCP := _cabcp */
                  mcStoricoDett.row.CODCABCP = _cabcp;
                  /* mcStoricoDett.INTCONTRO := rowFraUif.CODINT2 */
                  mcStoricoDett.row.INTCONTRO = rowFraUif.CODINT2;
                  /* mcStoricoDett.PAESEICP := _paeseicp */
                  mcStoricoDett.row.PAESEICP = _paeseicp;
                  /* mcStoricoDett.CABICP := _cabicp */
                  mcStoricoDett.row.CABICP = _cabicp;
                  /* mcStoricoDett.SaveRow() */
                  mcStoricoDett.SaveRow();
                  /* mcAlt.AppendBlank() */
                  mcAlt.AppendBlank();
                  /* mcAlt.CODINTDIP := _coddip */
                  mcAlt.row.CODINTDIP = _coddip;
                  /* mcAlt.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                  mcAlt.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                  /* mcAlt.CODCABDIP := _cabdip */
                  mcAlt.row.CODCABDIP = _cabdip;
                  /* mcAlt.PERPAESE := _paesecli */
                  mcAlt.row.PERPAESE = _paesecli;
                  /* mcAlt.PERCAB := _cabcli */
                  mcAlt.row.PERCAB = _cabcli;
                  /* mcAlt.CODVOC := rowFraUif.CODVOC */
                  mcAlt.row.CODVOC = rowFraUif.CODVOC;
                  /* mcAlt.FLAGLIRE := rowFraUif.FLAGLIRE */
                  mcAlt.row.FLAGLIRE = rowFraUif.FLAGLIRE;
                  /* mcAlt.SEGNO := rowFraUif.SEGNO */
                  mcAlt.row.SEGNO = rowFraUif.SEGNO;
                  /* mcAlt.SETTSINT := _settsint */
                  mcAlt.row.SETTSINT = _settsint;
                  /* mcAlt.PAESECP := _paesecp */
                  mcAlt.row.PAESECP = _paesecp;
                  /* mcAlt.CODCABCP := _cabcp */
                  mcAlt.row.CODCABCP = _cabcp;
                  /* mcAlt.PAESEICP := _paeseicp */
                  mcAlt.row.PAESEICP = _paeseicp;
                  /* mcAlt.CABICP := _cabicp */
                  mcAlt.row.CABICP = _cabicp;
                  /* mcAlt.TOTLIRE := _totimp */
                  mcAlt.row.TOTLIRE = _totimp;
                  /* mcAlt.TOTCONT := _totcon */
                  mcAlt.row.TOTCONT = _totcon;
                  /* mcAlt.OPERAZIONI := _operaz */
                  mcAlt.row.OPERAZIONI = _operaz;
                  /* mcAlt.CONTANTI := _ocont */
                  mcAlt.row.CONTANTI = _ocont;
                  /* mcAlt.SaveRow() */
                  mcAlt.SaveRow();
                } // End If
                Cursor_clientifrz.Next();
              }
              m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
              Cursor_clientifrz.Close();
              // * --- End Select
            } // End If
          } // End If
        }
        /* _dataoggi := arfn_datesum(_dataoggi,1) */
        _dataoggi = arfn_datesumR.Make(m_Ctx,this).Run(_dataoggi,1);
        /* _cdataoggi := DateToChar(_dataoggi) */
        _cdataoggi = CPLib.DateToChar(_dataoggi);
      } // End While
      /* If _cope=0 */
      if (CPLib.eqr(_cope,0)) {
        /* gMsgProc := gMsgProc + NL + 'Non sono presenti dati da elaborare nel file Frazionate' + NL */
        gMsgProc = gMsgProc+"\n"+"Non sono presenti dati da elaborare nel file Frazionate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + NL + 'Sono stati elaborati '+LRTrim(Str(_cope,10,0))+' record del file Frazionate' + NL */
        gMsgProc = gMsgProc+"\n"+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_cope,10,0))+" record del file Frazionate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Frazionate' +NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Frazionate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_frauif!=null)
          Cursor_qbe_frauif.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientifrz!=null)
          Cursor_clientifrz.Close();
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
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_xbrl_def=null;
    CPResultSet Read_Cursor=null;
    try {
      /* Crea il file per l'invio */
      /* gMsgProc := gMsgProc + 'Ora Inizio Creazione del file XBRL: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Inizio Creazione del file XBRL: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _nita := 0 */
      _nita = CPLib.Round(0,0);
      /* _next := 0 */
      _next = CPLib.Round(0,0);
      /* _nalt := 0 */
      _nalt = CPLib.Round(0,0);
      /* _txttot := '' */
      _txttot = "";
      /* _testo := '' */
      _testo = "";
      /* Invia il file */
      /* _mesi := "ABCDEFGHIJKL" */
      _mesi = "ABCDEFGHIJKL";
      /* _mese := Substr(_mesi,Month(w_DaDatOpe),1) */
      _mese = CPLib.Substr(_mesi,CPLib.Month(w_DaDatOpe),1);
      /* _file := iif(w_numinv > 1,"R","A")+Substr(DateToChar(w_DaDatOpe),4,1)+_mese+"00000.XML" */
      _file = (CPLib.gt(w_numinv,1)?"R":"A")+CPLib.Substr(CPLib.DateToChar(w_DaDatOpe),4,1)+_mese+"00000.XML";
      /* cNomeFile := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_file) */
      cNomeFile = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_file);
      /* cOnlyNomeFile := _file */
      cOnlyNomeFile = _file;
      /* cNomeFileZip := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_file)+"_"+Right('00000'+LRTrim(Str(w_numinv,5,0)),5)+".zip" */
      cNomeFileZip = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_file)+"_"+CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(w_numinv,5,0)),5)+".zip";
      /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_file)) */
      fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_file));
      /* If _tipcentro = '02' */
      if (CPLib.eqr(_tipcentro,"02")) {
        // * --- Select from xbrl_def
        m_cServer = m_Ctx.GetServer("xbrl_def");
        m_cPhName = m_Ctx.GetPhName("xbrl_def");
        if (Cursor_xbrl_def!=null)
          Cursor_xbrl_def.Close();
        Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='CONTESTO_BONIFICIBANCHE' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xbrl_def.Eof())) {
          /* _ita1 := xbrl_def->XML_TXT */
          _ita1 = Cursor_xbrl_def.GetString("XML_TXT");
          Cursor_xbrl_def.Next();
        }
        m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
        Cursor_xbrl_def.Close();
        // * --- End Select
        // * --- Select from xbrl_def
        m_cServer = m_Ctx.GetServer("xbrl_def");
        m_cPhName = m_Ctx.GetPhName("xbrl_def");
        if (Cursor_xbrl_def!=null)
          Cursor_xbrl_def.Close();
        Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='FATTI_BONIFICIBANCHE' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xbrl_def.Eof())) {
          /* _ita2 := xbrl_def->XML_TXT */
          _ita2 = Cursor_xbrl_def.GetString("XML_TXT");
          Cursor_xbrl_def.Next();
        }
        m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
        Cursor_xbrl_def.Close();
        // * --- End Select
        // * --- Select from xbrl_def
        m_cServer = m_Ctx.GetServer("xbrl_def");
        m_cPhName = m_Ctx.GetPhName("xbrl_def");
        if (Cursor_xbrl_def!=null)
          Cursor_xbrl_def.Close();
        Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='CONTESTO_BONIFICIESTERI' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xbrl_def.Eof())) {
          /* _ext1 := xbrl_def->XML_TXT */
          _ext1 = Cursor_xbrl_def.GetString("XML_TXT");
          Cursor_xbrl_def.Next();
        }
        m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
        Cursor_xbrl_def.Close();
        // * --- End Select
        // * --- Select from xbrl_def
        m_cServer = m_Ctx.GetServer("xbrl_def");
        m_cPhName = m_Ctx.GetPhName("xbrl_def");
        if (Cursor_xbrl_def!=null)
          Cursor_xbrl_def.Close();
        Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='FATTI_BONIFICIESTERI' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xbrl_def.Eof())) {
          /* _ext2 := xbrl_def->XML_TXT */
          _ext2 = Cursor_xbrl_def.GetString("XML_TXT");
          Cursor_xbrl_def.Next();
        }
        m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
        Cursor_xbrl_def.Close();
        // * --- End Select
        // * --- Select from xbrl_def
        m_cServer = m_Ctx.GetServer("xbrl_def");
        m_cPhName = m_Ctx.GetPhName("xbrl_def");
        if (Cursor_xbrl_def!=null)
          Cursor_xbrl_def.Close();
        Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='CONTESTO_ALTREOPERAZIONI' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xbrl_def.Eof())) {
          /* _alt1 := xbrl_def->XML_TXT */
          _alt1 = Cursor_xbrl_def.GetString("XML_TXT");
          Cursor_xbrl_def.Next();
        }
        m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
        Cursor_xbrl_def.Close();
        // * --- End Select
        // * --- Select from xbrl_def
        m_cServer = m_Ctx.GetServer("xbrl_def");
        m_cPhName = m_Ctx.GetPhName("xbrl_def");
        if (Cursor_xbrl_def!=null)
          Cursor_xbrl_def.Close();
        Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='FATTI_ALTREOPERAZIONI' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xbrl_def.Eof())) {
          /* _alt2 := xbrl_def->XML_TXT */
          _alt2 = Cursor_xbrl_def.GetString("XML_TXT");
          Cursor_xbrl_def.Next();
        }
        m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
        Cursor_xbrl_def.Close();
        // * --- End Select
      } else { // Else
        // * --- Select from xbrl_def
        m_cServer = m_Ctx.GetServer("xbrl_def");
        m_cPhName = m_Ctx.GetPhName("xbrl_def");
        if (Cursor_xbrl_def!=null)
          Cursor_xbrl_def.Close();
        Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='CONTESTO_BONIFICIALTRIITA' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xbrl_def.Eof())) {
          /* _ita1 := xbrl_def->XML_TXT */
          _ita1 = Cursor_xbrl_def.GetString("XML_TXT");
          Cursor_xbrl_def.Next();
        }
        m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
        Cursor_xbrl_def.Close();
        // * --- End Select
        // * --- Select from xbrl_def
        m_cServer = m_Ctx.GetServer("xbrl_def");
        m_cPhName = m_Ctx.GetPhName("xbrl_def");
        if (Cursor_xbrl_def!=null)
          Cursor_xbrl_def.Close();
        Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='FATTI_BONIFICIALTRIITA' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xbrl_def.Eof())) {
          /* _ita2 := xbrl_def->XML_TXT */
          _ita2 = Cursor_xbrl_def.GetString("XML_TXT");
          Cursor_xbrl_def.Next();
        }
        m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
        Cursor_xbrl_def.Close();
        // * --- End Select
        // * --- Select from xbrl_def
        m_cServer = m_Ctx.GetServer("xbrl_def");
        m_cPhName = m_Ctx.GetPhName("xbrl_def");
        if (Cursor_xbrl_def!=null)
          Cursor_xbrl_def.Close();
        Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='CONTESTO_BONIFICIALTRIESTERI' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xbrl_def.Eof())) {
          /* _ext1 := xbrl_def->XML_TXT */
          _ext1 = Cursor_xbrl_def.GetString("XML_TXT");
          Cursor_xbrl_def.Next();
        }
        m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
        Cursor_xbrl_def.Close();
        // * --- End Select
        // * --- Select from xbrl_def
        m_cServer = m_Ctx.GetServer("xbrl_def");
        m_cPhName = m_Ctx.GetPhName("xbrl_def");
        if (Cursor_xbrl_def!=null)
          Cursor_xbrl_def.Close();
        Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='FATTI_BONIFICIALTRIESTERI' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xbrl_def.Eof())) {
          /* _ext2 := xbrl_def->XML_TXT */
          _ext2 = Cursor_xbrl_def.GetString("XML_TXT");
          Cursor_xbrl_def.Next();
        }
        m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
        Cursor_xbrl_def.Close();
        // * --- End Select
        // * --- Select from xbrl_def
        m_cServer = m_Ctx.GetServer("xbrl_def");
        m_cPhName = m_Ctx.GetPhName("xbrl_def");
        if (Cursor_xbrl_def!=null)
          Cursor_xbrl_def.Close();
        Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='CONTESTO_ALTREOPERAZIONIALTRI' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xbrl_def.Eof())) {
          /* _alt1 := xbrl_def->XML_TXT */
          _alt1 = Cursor_xbrl_def.GetString("XML_TXT");
          Cursor_xbrl_def.Next();
        }
        m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
        Cursor_xbrl_def.Close();
        // * --- End Select
        // * --- Select from xbrl_def
        m_cServer = m_Ctx.GetServer("xbrl_def");
        m_cPhName = m_Ctx.GetPhName("xbrl_def");
        if (Cursor_xbrl_def!=null)
          Cursor_xbrl_def.Close();
        Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='FATTI_ALTREOPERAZIONIALTRI' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xbrl_def.Eof())) {
          /* _alt2 := xbrl_def->XML_TXT */
          _alt2 = Cursor_xbrl_def.GetString("XML_TXT");
          Cursor_xbrl_def.Next();
        }
        m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
        Cursor_xbrl_def.Close();
        // * --- End Select
      } // End If
      /* Crea il Record di testa */
      /* gMsgImp := 'Creazione  File XBRL' // Messaggio Import */
      gMsgImp = "Creazione  File XBRL";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from xbrl_def
      m_cServer = m_Ctx.GetServer("xbrl_def");
      m_cPhName = m_Ctx.GetPhName("xbrl_def");
      if (Cursor_xbrl_def!=null)
        Cursor_xbrl_def.Close();
      Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='PROLOGO' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xbrl_def.Eof())) {
        /* _testo := LRTrim(xbrl_def->XML_TXT) + NL */
        _testo = CPLib.LRTrim(Cursor_xbrl_def.GetString("XML_TXT"))+"\n";
        /* FileLibMit.Write(fhand,_testo) */
        FileLibMit.Write(fhand,_testo);
        Cursor_xbrl_def.Next();
      }
      m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
      Cursor_xbrl_def.Close();
      // * --- End Select
      // * --- Select from xbrl_def
      m_cServer = m_Ctx.GetServer("xbrl_def");
      m_cPhName = m_Ctx.GetPhName("xbrl_def");
      if (Cursor_xbrl_def!=null)
        Cursor_xbrl_def.Close();
      Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='TASSONOMIA' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xbrl_def.Eof())) {
        /* _testo := LRTrim(xbrl_def->XML_TXT) + NL */
        _testo = CPLib.LRTrim(Cursor_xbrl_def.GetString("XML_TXT"))+"\n";
        /* FileLibMit.Write(fhand,_testo) */
        FileLibMit.Write(fhand,_testo);
        Cursor_xbrl_def.Next();
      }
      m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
      Cursor_xbrl_def.Close();
      // * --- End Select
      /* _contaw := 0 */
      _contaw = CPLib.Round(0,0);
      /* mcIta.GoTop() */
      mcIta.GoTop();
      /* While not(mcIta.Eof()) */
      while ( ! (mcIta.Eof())) {
        /* _contaw := _contaw + 1 */
        _contaw = CPLib.Round(_contaw+1,0);
        /* gMsgImp := 'Elaboro Bonifico Italia: '+ LRTrim(Str(_contaw,10,0)) // Messaggio Import */
        gMsgImp = "Elaboro Bonifico Italia: "+CPLib.LRTrim(CPLib.Str(_contaw,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If mcTmp.GoToKey(LRTrim(mcIta.CODINTDIP)+LRTrim(mcIta.ABICABDIP)+LRTrim(mcIta.CODCABDIP)+LRTrim(mcIta.PERPAESE)+LRTrim(mcIta.PERCAB)+LRTrim(mcIta.CODVOC)+LRTrim(mcIta.FLAGLIRE)+LRTrim(mcIta.SEGNO)+LRTrim(mcIta.SETTSINT)+LRTrim(mcIta.PAESECP)+LRTrim(mcIta.CODCABCP)+LRTrim(mcIta.PAESEICP)+LRTrim(mcIta.CABICP)) */
        if (mcTmp.GoToKey(CPLib.LRTrim(mcIta.row.CODINTDIP)+CPLib.LRTrim(mcIta.row.ABICABDIP)+CPLib.LRTrim(mcIta.row.CODCABDIP)+CPLib.LRTrim(mcIta.row.PERPAESE)+CPLib.LRTrim(mcIta.row.PERCAB)+CPLib.LRTrim(mcIta.row.CODVOC)+CPLib.LRTrim(mcIta.row.FLAGLIRE)+CPLib.LRTrim(mcIta.row.SEGNO)+CPLib.LRTrim(mcIta.row.SETTSINT)+CPLib.LRTrim(mcIta.row.PAESECP)+CPLib.LRTrim(mcIta.row.CODCABCP)+CPLib.LRTrim(mcIta.row.PAESEICP)+CPLib.LRTrim(mcIta.row.CABICP))) {
          /* mcTmp.TOTLIRE := mcTmp.TOTLIRE + mcIta.TOTLIRE */
          mcTmp.row.TOTLIRE = mcTmp.row.TOTLIRE+mcIta.row.TOTLIRE;
          /* mcTmp.TOTCONT := mcTmp.TOTCONT + mcIta.TOTCONT */
          mcTmp.row.TOTCONT = mcTmp.row.TOTCONT+mcIta.row.TOTCONT;
          /* mcTmp.OPERAZIONI := mcTmp.OPERAZIONI + mcIta.OPERAZIONI */
          mcTmp.row.OPERAZIONI = mcTmp.row.OPERAZIONI+mcIta.row.OPERAZIONI;
          /* mcTmp.CONTANTI := mcTmp.CONTANTI + mcIta.CONTANTI */
          mcTmp.row.CONTANTI = mcTmp.row.CONTANTI+mcIta.row.CONTANTI;
          /* mcTmp.SaveRow() */
          mcTmp.SaveRow();
        } else { // Else
          /* _nita := _nita + 1 */
          _nita = CPLib.Round(_nita+1,0);
          /* rowTmp.CODINTDIP := mcIta.CODINTDIP */
          rowTmp.CODINTDIP = mcIta.row.CODINTDIP;
          /* rowTmp.ABICABDIP := mcIta.ABICABDIP */
          rowTmp.ABICABDIP = mcIta.row.ABICABDIP;
          /* rowTmp.CODCABDIP := mcIta.CODCABDIP */
          rowTmp.CODCABDIP = mcIta.row.CODCABDIP;
          /* rowTmp.PERPAESE := mcIta.PERPAESE */
          rowTmp.PERPAESE = mcIta.row.PERPAESE;
          /* rowTmp.PERCAB := mcIta.PERCAB */
          rowTmp.PERCAB = mcIta.row.PERCAB;
          /* rowTmp.CODVOC := mcIta.CODVOC */
          rowTmp.CODVOC = mcIta.row.CODVOC;
          /* rowTmp.FLAGLIRE := mcIta.FLAGLIRE */
          rowTmp.FLAGLIRE = mcIta.row.FLAGLIRE;
          /* rowTmp.SEGNO := mcIta.SEGNO */
          rowTmp.SEGNO = mcIta.row.SEGNO;
          /* rowTmp.SETTSINT := mcIta.SETTSINT */
          rowTmp.SETTSINT = mcIta.row.SETTSINT;
          /* rowTmp.PAESECP := mcIta.PAESECP */
          rowTmp.PAESECP = mcIta.row.PAESECP;
          /* rowTmp.CODCABCP := mcIta.CODCABCP */
          rowTmp.CODCABCP = mcIta.row.CODCABCP;
          /* rowTmp.PAESEICP := mcIta.PAESEICP */
          rowTmp.PAESEICP = mcIta.row.PAESEICP;
          /* rowTmp.CABICP := mcIta.CABICP */
          rowTmp.CABICP = mcIta.row.CABICP;
          /* rowTmp.TOTLIRE := mcIta.TOTLIRE */
          rowTmp.TOTLIRE = mcIta.row.TOTLIRE;
          /* rowTmp.TOTCONT := mcIta.TOTCONT */
          rowTmp.TOTCONT = mcIta.row.TOTCONT;
          /* rowTmp.OPERAZIONI := mcIta.OPERAZIONI */
          rowTmp.OPERAZIONI = mcIta.row.OPERAZIONI;
          /* rowTmp.CONTANTI := mcIta.CONTANTI */
          rowTmp.CONTANTI = mcIta.row.CONTANTI;
          /* rowTmp.N_ITA := _nita */
          rowTmp.N_ITA = _nita;
          /* mcTmp.AppendRowWithKey(LRTrim(mcIta.CODINTDIP)+LRTrim(mcIta.ABICABDIP)+LRTrim(mcIta.CODCABDIP)+LRTrim(mcIta.PERPAESE)+LRTrim(mcIta.PERCAB)+LRTrim(mcIta.CODVOC)+LRTrim(mcIta.FLAGLIRE)+LRTrim(mcIta.SEGNO)+LRTrim(mcIta.SETTSINT)+LRTrim(mcIta.PAESECP)+LRTrim(mcIta.CODCABCP)+LRTrim(mcIta.PAESEICP)+LRTrim(mcIta.CABICP),rowTmp) */
          mcTmp.AppendRowWithKey(CPLib.LRTrim(mcIta.row.CODINTDIP)+CPLib.LRTrim(mcIta.row.ABICABDIP)+CPLib.LRTrim(mcIta.row.CODCABDIP)+CPLib.LRTrim(mcIta.row.PERPAESE)+CPLib.LRTrim(mcIta.row.PERCAB)+CPLib.LRTrim(mcIta.row.CODVOC)+CPLib.LRTrim(mcIta.row.FLAGLIRE)+CPLib.LRTrim(mcIta.row.SEGNO)+CPLib.LRTrim(mcIta.row.SETTSINT)+CPLib.LRTrim(mcIta.row.PAESECP)+CPLib.LRTrim(mcIta.row.CODCABCP)+CPLib.LRTrim(mcIta.row.PAESEICP)+CPLib.LRTrim(mcIta.row.CABICP),rowTmp);
        } // End If
        /* mcIta.Skip() */
        mcIta.Skip();
      } // End While
      /* mcIta.Zap() */
      mcIta.Zap();
      MemoryCursor_tmp_invio_xbrl cpmc_00000473;
      cpmc_00000473 = new MemoryCursor_tmp_invio_xbrl();
      for (MemoryCursorRow_tmp_invio_xbrl rowTmp : mcTmp._iterable_()) {
        cpmc_00000473.Append(rowTmp);
      }
      for (MemoryCursorRow_tmp_invio_xbrl rowTmp : cpmc_00000473._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_tmp_invio_xbrl>(){  public int compare(MemoryCursorRow_tmp_invio_xbrl r1,MemoryCursorRow_tmp_invio_xbrl r2){    if (CPLib.gt(r1.N_ITA,r2.N_ITA)) return 1;    if (CPLib.lt(r1.N_ITA,r2.N_ITA)) return -1;    return 0;  }})) {
        /* gMsgImp := 'Sostituzione Macro Bonifici Italia per Riga '+ LRTrim(Str(rowTmp.N_ITA,10,0)) // Messaggio Import */
        gMsgImp = "Sostituzione Macro Bonifici Italia per Riga "+CPLib.LRTrim(CPLib.Str(rowTmp.N_ITA,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _txtappo := _ita1 */
        _txtappo = _ita1;
        /* _txtappo := Strtran(_txtappo,"##NITA##",iif(rowTmp.N_ITA=1,'',LRTrim(Str(rowTmp.N_ITA,10,0)))) */
        _txtappo = CPLib.Strtran(_txtappo,"##NITA##",(CPLib.eqr(rowTmp.N_ITA,1)?"":CPLib.LRTrim(CPLib.Str(rowTmp.N_ITA,10,0))));
        /* _txtappo := Strtran(_txtappo,"##TIPINTER##",_tipcentro) */
        _txtappo = CPLib.Strtran(_txtappo,"##TIPINTER##",_tipcentro);
        /* _txtappo := Strtran(_txtappo,"##PIVAINTER##",_codcentro) */
        _txtappo = CPLib.Strtran(_txtappo,"##PIVAINTER##",_codcentro);
        /* _txtappo := Strtran(_txtappo,"##FINE_PERIODO##",_datafine) */
        _txtappo = CPLib.Strtran(_txtappo,"##FINE_PERIODO##",_datafine);
        /* _txtappo := Strtran(_txtappo,"##CODDIP##",LRTrim(rowTmp.CODINTDIP)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CODDIP##",CPLib.LRTrim(rowTmp.CODINTDIP));
        /* _txtappo := Strtran(_txtappo,"##CABDIP##",LRTrim(rowTmp.CODCABDIP)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CABDIP##",CPLib.LRTrim(rowTmp.CODCABDIP));
        /* If _tipcentro='02' */
        if (CPLib.eqr(_tipcentro,"02")) {
          /* _txtappo := Strtran(_txtappo,"##ABICAB##",LRTrim(rowTmp.ABICABDIP)) */
          _txtappo = CPLib.Strtran(_txtappo,"##ABICAB##",CPLib.LRTrim(rowTmp.ABICABDIP));
        } // End If
        /* _txtappo := Strtran(_txtappo,"##PAESECLI##",LRTrim(rowTmp.PERPAESE)) */
        _txtappo = CPLib.Strtran(_txtappo,"##PAESECLI##",CPLib.LRTrim(rowTmp.PERPAESE));
        /* _txtappo := Strtran(_txtappo,"##CABCLI##",LRTrim(rowTmp.PERCAB)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CABCLI##",CPLib.LRTrim(rowTmp.PERCAB));
        /* _txtappo := Strtran(_txtappo,"##CODVOC##",LRTrim(rowTmp.CODVOC)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CODVOC##",CPLib.LRTrim(rowTmp.CODVOC));
        /* _txtappo := Strtran(_txtappo,"##VALUTA##",LRTrim(rowTmp.FLAGLIRE)) */
        _txtappo = CPLib.Strtran(_txtappo,"##VALUTA##",CPLib.LRTrim(rowTmp.FLAGLIRE));
        /* _txtappo := Strtran(_txtappo,"##SEGNO##",LRTrim(rowTmp.SEGNO)) */
        _txtappo = CPLib.Strtran(_txtappo,"##SEGNO##",CPLib.LRTrim(rowTmp.SEGNO));
        /* _txtappo := Strtran(_txtappo,"##SETTSINT##",LRTrim(rowTmp.SETTSINT)) */
        _txtappo = CPLib.Strtran(_txtappo,"##SETTSINT##",CPLib.LRTrim(rowTmp.SETTSINT));
        /* _txtappo := Strtran(_txtappo,"##PAESECP##",LRTrim(rowTmp.PAESECP)) */
        _txtappo = CPLib.Strtran(_txtappo,"##PAESECP##",CPLib.LRTrim(rowTmp.PAESECP));
        /* _txtappo := Strtran(_txtappo,"##CABCP##",LRTrim(rowTmp.CODCABCP)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CABCP##",CPLib.LRTrim(rowTmp.CODCABCP));
        /* _txtappo := Strtran(_txtappo,"##PAESEICP##",LRTrim(rowTmp.PAESEICP)) */
        _txtappo = CPLib.Strtran(_txtappo,"##PAESEICP##",CPLib.LRTrim(rowTmp.PAESEICP));
        /* _txtappo := Strtran(_txtappo,"##CABICP##",LRTrim(rowTmp.CABICP)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CABICP##",CPLib.LRTrim(rowTmp.CABICP));
        /* mcTxt1.AppendBlank() */
        mcTxt1.AppendBlank();
        /* mcTxt1.testo := LRTrim(_txtappo) */
        mcTxt1.row.testo = CPLib.LRTrim(_txtappo);
        /* mcTxt1.SaveRow() */
        mcTxt1.SaveRow();
        /* _txtappo := '' */
        _txtappo = "";
        /* _txtappo := _ita2 */
        _txtappo = _ita2;
        /* _tope := iif(rowTmp.OPERAZIONI - Int(rowTmp.OPERAZIONI) > 0,Int(rowTmp.OPERAZIONI)+1,rowTmp.OPERAZIONI) */
        _tope = CPLib.Round((CPLib.gt(rowTmp.OPERAZIONI-CPLib.Int(rowTmp.OPERAZIONI),0)?CPLib.Int(rowTmp.OPERAZIONI)+1:rowTmp.OPERAZIONI),0);
        /* _tcon := iif(rowTmp.CONTANTI - Int(rowTmp.CONTANTI) > 0,Int(rowTmp.CONTANTI)+1,rowTmp.CONTANTI) */
        _tcon = CPLib.Round((CPLib.gt(rowTmp.CONTANTI-CPLib.Int(rowTmp.CONTANTI),0)?CPLib.Int(rowTmp.CONTANTI)+1:rowTmp.CONTANTI),0);
        /* _totimp := rowTmp.TOTLIRE */
        _totimp = CPLib.Round(rowTmp.TOTLIRE,2);
        /* _totimp := iif(_totimp - Int(_totimp) > 0,Int(_totimp)+1,_totimp) */
        _totimp = CPLib.Round((CPLib.gt(_totimp-CPLib.Int(_totimp),0)?CPLib.Int(_totimp)+1:_totimp),2);
        /* _totimp := iif(_totimp=0,1,_totimp) */
        _totimp = CPLib.Round((CPLib.eqr(_totimp,0)?1:_totimp),2);
        /* _totcon := rowTmp.TOTCONT */
        _totcon = CPLib.Round(rowTmp.TOTCONT,2);
        /* _totcon := iif(_totcon - Int(_totcon) > 0,Int(_totcon)+1,_totcon) */
        _totcon = CPLib.Round((CPLib.gt(_totcon-CPLib.Int(_totcon),0)?CPLib.Int(_totcon)+1:_totcon),2);
        /* _totcon := iif(_totcon=0 and _tcon > 0,1,_totcon) */
        _totcon = CPLib.Round((CPLib.eqr(_totcon,0) && CPLib.gt(_tcon,0)?1:_totcon),2);
        /* _txtappo := Strtran(_txtappo,"##NITA##",iif(rowTmp.N_ITA=1,'',LRTrim(Str(rowTmp.N_ITA,10,0)))) */
        _txtappo = CPLib.Strtran(_txtappo,"##NITA##",(CPLib.eqr(rowTmp.N_ITA,1)?"":CPLib.LRTrim(CPLib.Str(rowTmp.N_ITA,10,0))));
        /* _txtappo := Strtran(_txtappo,"##TOTIMP##",LRTrim(Str(_totimp,15,0))) */
        _txtappo = CPLib.Strtran(_txtappo,"##TOTIMP##",CPLib.LRTrim(CPLib.Str(_totimp,15,0)));
        /* _txtappo := Strtran(_txtappo,"##TOTOPE##",LRTrim(Str(_tope,10,0))) */
        _txtappo = CPLib.Strtran(_txtappo,"##TOTOPE##",CPLib.LRTrim(CPLib.Str(_tope,10,0)));
        /* _txtappo := Strtran(_txtappo,"##TOTCON##",LRTrim(Str(_totcon,15,0))) */
        _txtappo = CPLib.Strtran(_txtappo,"##TOTCON##",CPLib.LRTrim(CPLib.Str(_totcon,15,0)));
        /* _txtappo := Strtran(_txtappo,"##OPECON##",LRTrim(Str(_tcon,10,0))) */
        _txtappo = CPLib.Strtran(_txtappo,"##OPECON##",CPLib.LRTrim(CPLib.Str(_tcon,10,0)));
        /* mcTxt2.AppendBlank() */
        mcTxt2.AppendBlank();
        /* mcTxt2.testo := LRTrim(_txtappo) */
        mcTxt2.row.testo = CPLib.LRTrim(_txtappo);
        /* mcTxt2.SaveRow() */
        mcTxt2.SaveRow();
        /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(rowTmp.CODINTDIP)+LRTrim(rowTmp.ABICABDIP)+LRTrim(rowTmp.CODCABDIP)+LRTrim(rowTmp.PERPAESE)+LRTrim(rowTmp.PERCAB)+LRTrim(rowTmp.CODVOC)+LRTrim(rowTmp.FLAGLIRE) */
        _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(rowTmp.CODINTDIP)+CPLib.LRTrim(rowTmp.ABICABDIP)+CPLib.LRTrim(rowTmp.CODCABDIP)+CPLib.LRTrim(rowTmp.PERPAESE)+CPLib.LRTrim(rowTmp.PERCAB)+CPLib.LRTrim(rowTmp.CODVOC)+CPLib.LRTrim(rowTmp.FLAGLIRE);
        /* _chiave := _chiave + LRTrim(rowTmp.SEGNO) + LRTrim(rowTmp.SETTSINT)+LRTrim(rowTmp.PAESECP)+LRTrim(rowTmp.CODCABCP)+LRTrim(rowTmp.PAESEICP)+LRTrim(rowTmp.CABICP) */
        _chiave = _chiave+CPLib.LRTrim(rowTmp.SEGNO)+CPLib.LRTrim(rowTmp.SETTSINT)+CPLib.LRTrim(rowTmp.PAESECP)+CPLib.LRTrim(rowTmp.CODCABCP)+CPLib.LRTrim(rowTmp.PAESEICP)+CPLib.LRTrim(rowTmp.CABICP);
        /* If mcStorico.GoToKey(_chiave) */
        if (mcStorico.GoToKey(_chiave)) {
          /* mcStorico.TOTLIRE := _totimp */
          mcStorico.row.TOTLIRE = _totimp;
          /* mcStorico.TOTCONT := _totcon */
          mcStorico.row.TOTCONT = _totcon;
          /* mcStorico.OPERAZIONI := _tope */
          mcStorico.row.OPERAZIONI = _tope;
          /* mcStorico.CONTANTI := _tcon */
          mcStorico.row.CONTANTI = _tcon;
          /* mcStorico.SaveRow() */
          mcStorico.SaveRow();
        } // End If
      }
      /* _contaw := 0 */
      _contaw = CPLib.Round(0,0);
      /* mcTmp.Zap() */
      mcTmp.Zap();
      /* mcExt.GoTop() */
      mcExt.GoTop();
      /* While not(mcExt.Eof()) */
      while ( ! (mcExt.Eof())) {
        /* _contaw := _contaw + 1 */
        _contaw = CPLib.Round(_contaw+1,0);
        /* gMsgImp := 'Elaboro Bonifico Estero: '+ LRTrim(Str(_contaw,10,0)) // Messaggio Import */
        gMsgImp = "Elaboro Bonifico Estero: "+CPLib.LRTrim(CPLib.Str(_contaw,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If mcTmp.GoToKey(LRTrim(mcExt.CODINTDIP)+LRTrim(mcExt.ABICABDIP)+LRTrim(mcExt.CODCABDIP)+LRTrim(mcExt.PERPAESE)+LRTrim(mcExt.PERCAB)+LRTrim(mcExt.CODVOC)+LRTrim(mcExt.FLAGLIRE)+LRTrim(mcExt.SEGNO)+LRTrim(mcExt.SETTSINT)+LRTrim(mcExt.PAESECP)+LRTrim(mcExt.CODCABCP)+LRTrim(mcExt.PAESEICP)+LRTrim(mcExt.CABICP)) */
        if (mcTmp.GoToKey(CPLib.LRTrim(mcExt.row.CODINTDIP)+CPLib.LRTrim(mcExt.row.ABICABDIP)+CPLib.LRTrim(mcExt.row.CODCABDIP)+CPLib.LRTrim(mcExt.row.PERPAESE)+CPLib.LRTrim(mcExt.row.PERCAB)+CPLib.LRTrim(mcExt.row.CODVOC)+CPLib.LRTrim(mcExt.row.FLAGLIRE)+CPLib.LRTrim(mcExt.row.SEGNO)+CPLib.LRTrim(mcExt.row.SETTSINT)+CPLib.LRTrim(mcExt.row.PAESECP)+CPLib.LRTrim(mcExt.row.CODCABCP)+CPLib.LRTrim(mcExt.row.PAESEICP)+CPLib.LRTrim(mcExt.row.CABICP))) {
          /* mcTmp.TOTLIRE := mcTmp.TOTLIRE + mcExt.TOTLIRE */
          mcTmp.row.TOTLIRE = mcTmp.row.TOTLIRE+mcExt.row.TOTLIRE;
          /* mcTmp.TOTCONT := mcTmp.TOTCONT + mcExt.TOTCONT */
          mcTmp.row.TOTCONT = mcTmp.row.TOTCONT+mcExt.row.TOTCONT;
          /* mcTmp.OPERAZIONI := mcTmp.OPERAZIONI + mcExt.OPERAZIONI */
          mcTmp.row.OPERAZIONI = mcTmp.row.OPERAZIONI+mcExt.row.OPERAZIONI;
          /* mcTmp.CONTANTI := mcTmp.CONTANTI + mcExt.CONTANTI */
          mcTmp.row.CONTANTI = mcTmp.row.CONTANTI+mcExt.row.CONTANTI;
          /* mcTmp.SaveRow() */
          mcTmp.SaveRow();
        } else { // Else
          /* _next := _next + 1 */
          _next = CPLib.Round(_next+1,0);
          /* rowTmp.CODINTDIP := mcExt.CODINTDIP */
          rowTmp.CODINTDIP = mcExt.row.CODINTDIP;
          /* rowTmp.ABICABDIP := mcExt.ABICABDIP */
          rowTmp.ABICABDIP = mcExt.row.ABICABDIP;
          /* rowTmp.CODCABDIP := mcExt.CODCABDIP */
          rowTmp.CODCABDIP = mcExt.row.CODCABDIP;
          /* rowTmp.PERPAESE := mcExt.PERPAESE */
          rowTmp.PERPAESE = mcExt.row.PERPAESE;
          /* rowTmp.PERCAB := mcExt.PERCAB */
          rowTmp.PERCAB = mcExt.row.PERCAB;
          /* rowTmp.CODVOC := mcExt.CODVOC */
          rowTmp.CODVOC = mcExt.row.CODVOC;
          /* rowTmp.FLAGLIRE := mcExt.FLAGLIRE */
          rowTmp.FLAGLIRE = mcExt.row.FLAGLIRE;
          /* rowTmp.SEGNO := mcExt.SEGNO */
          rowTmp.SEGNO = mcExt.row.SEGNO;
          /* rowTmp.SETTSINT := mcExt.SETTSINT */
          rowTmp.SETTSINT = mcExt.row.SETTSINT;
          /* rowTmp.PAESECP := mcExt.PAESECP */
          rowTmp.PAESECP = mcExt.row.PAESECP;
          /* rowTmp.CODCABCP := mcExt.CODCABCP */
          rowTmp.CODCABCP = mcExt.row.CODCABCP;
          /* rowTmp.PAESEICP := mcExt.PAESEICP */
          rowTmp.PAESEICP = mcExt.row.PAESEICP;
          /* rowTmp.CABICP := mcExt.CABICP */
          rowTmp.CABICP = mcExt.row.CABICP;
          /* rowTmp.TOTLIRE := mcExt.TOTLIRE */
          rowTmp.TOTLIRE = mcExt.row.TOTLIRE;
          /* rowTmp.TOTCONT := mcExt.TOTCONT */
          rowTmp.TOTCONT = mcExt.row.TOTCONT;
          /* rowTmp.OPERAZIONI := mcExt.OPERAZIONI */
          rowTmp.OPERAZIONI = mcExt.row.OPERAZIONI;
          /* rowTmp.CONTANTI := mcExt.CONTANTI */
          rowTmp.CONTANTI = mcExt.row.CONTANTI;
          /* rowTmp.N_EXT := _next */
          rowTmp.N_EXT = _next;
          /* mcTmp.AppendRowWithKey(LRTrim(mcExt.CODINTDIP)+LRTrim(mcExt.ABICABDIP)+LRTrim(mcExt.CODCABDIP)+LRTrim(mcExt.PERPAESE)+LRTrim(mcExt.PERCAB)+LRTrim(mcExt.CODVOC)+LRTrim(mcExt.FLAGLIRE)+LRTrim(mcExt.SEGNO)+LRTrim(mcExt.SETTSINT)+LRTrim(mcExt.PAESECP)+LRTrim(mcExt.CODCABCP)+LRTrim(mcExt.PAESEICP)+LRTrim(mcExt.CABICP),rowTmp) */
          mcTmp.AppendRowWithKey(CPLib.LRTrim(mcExt.row.CODINTDIP)+CPLib.LRTrim(mcExt.row.ABICABDIP)+CPLib.LRTrim(mcExt.row.CODCABDIP)+CPLib.LRTrim(mcExt.row.PERPAESE)+CPLib.LRTrim(mcExt.row.PERCAB)+CPLib.LRTrim(mcExt.row.CODVOC)+CPLib.LRTrim(mcExt.row.FLAGLIRE)+CPLib.LRTrim(mcExt.row.SEGNO)+CPLib.LRTrim(mcExt.row.SETTSINT)+CPLib.LRTrim(mcExt.row.PAESECP)+CPLib.LRTrim(mcExt.row.CODCABCP)+CPLib.LRTrim(mcExt.row.PAESEICP)+CPLib.LRTrim(mcExt.row.CABICP),rowTmp);
        } // End If
        /* mcExt.Skip() */
        mcExt.Skip();
      } // End While
      /* mcExt.Zap() */
      mcExt.Zap();
      MemoryCursor_tmp_invio_xbrl cpmc_000004C9;
      cpmc_000004C9 = new MemoryCursor_tmp_invio_xbrl();
      for (MemoryCursorRow_tmp_invio_xbrl rowTmp : mcTmp._iterable_()) {
        cpmc_000004C9.Append(rowTmp);
      }
      for (MemoryCursorRow_tmp_invio_xbrl rowTmp : cpmc_000004C9._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_tmp_invio_xbrl>(){  public int compare(MemoryCursorRow_tmp_invio_xbrl r1,MemoryCursorRow_tmp_invio_xbrl r2){    if (CPLib.gt(r1.N_EXT,r2.N_EXT)) return 1;    if (CPLib.lt(r1.N_EXT,r2.N_EXT)) return -1;    return 0;  }})) {
        /* gMsgImp := 'Sostituzione Macro Bonifici Esteri per Riga '+ LRTrim(Str(rowTmp.N_EXT,10,0)) // Messaggio Import */
        gMsgImp = "Sostituzione Macro Bonifici Esteri per Riga "+CPLib.LRTrim(CPLib.Str(rowTmp.N_EXT,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _txtappo := _ext1 */
        _txtappo = _ext1;
        /* _txtappo := Strtran(_txtappo,"##NEXT##",iif(rowTmp.N_EXT=1,'',LRTrim(Str(rowTmp.N_EXT,10,0)))) */
        _txtappo = CPLib.Strtran(_txtappo,"##NEXT##",(CPLib.eqr(rowTmp.N_EXT,1)?"":CPLib.LRTrim(CPLib.Str(rowTmp.N_EXT,10,0))));
        /* _txtappo := Strtran(_txtappo,"##PIVAINTER##",_codcentro) */
        _txtappo = CPLib.Strtran(_txtappo,"##PIVAINTER##",_codcentro);
        /* _txtappo := Strtran(_txtappo,"##TIPINTER##",_tipcentro) */
        _txtappo = CPLib.Strtran(_txtappo,"##TIPINTER##",_tipcentro);
        /* _txtappo := Strtran(_txtappo,"##FINE_PERIODO##",_datafine) */
        _txtappo = CPLib.Strtran(_txtappo,"##FINE_PERIODO##",_datafine);
        /* _txtappo := Strtran(_txtappo,"##CODDIP##",LRTrim(rowTmp.CODINTDIP)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CODDIP##",CPLib.LRTrim(rowTmp.CODINTDIP));
        /* _txtappo := Strtran(_txtappo,"##CABDIP##",LRTrim(rowTmp.CODCABDIP)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CABDIP##",CPLib.LRTrim(rowTmp.CODCABDIP));
        /* If _tipcentro='02' */
        if (CPLib.eqr(_tipcentro,"02")) {
          /* _txtappo := Strtran(_txtappo,"##ABICAB##",LRTrim(rowTmp.ABICABDIP)) */
          _txtappo = CPLib.Strtran(_txtappo,"##ABICAB##",CPLib.LRTrim(rowTmp.ABICABDIP));
        } // End If
        /* _txtappo := Strtran(_txtappo,"##PAESECLI##",LRTrim(rowTmp.PERPAESE)) */
        _txtappo = CPLib.Strtran(_txtappo,"##PAESECLI##",CPLib.LRTrim(rowTmp.PERPAESE));
        /* _txtappo := Strtran(_txtappo,"##CABCLI##",LRTrim(rowTmp.PERCAB)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CABCLI##",CPLib.LRTrim(rowTmp.PERCAB));
        /* _txtappo := Strtran(_txtappo,"##CODVOC##",LRTrim(rowTmp.CODVOC)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CODVOC##",CPLib.LRTrim(rowTmp.CODVOC));
        /* _txtappo := Strtran(_txtappo,"##VALUTA##",LRTrim(rowTmp.FLAGLIRE)) */
        _txtappo = CPLib.Strtran(_txtappo,"##VALUTA##",CPLib.LRTrim(rowTmp.FLAGLIRE));
        /* _txtappo := Strtran(_txtappo,"##SEGNO##",LRTrim(rowTmp.SEGNO)) */
        _txtappo = CPLib.Strtran(_txtappo,"##SEGNO##",CPLib.LRTrim(rowTmp.SEGNO));
        /* _txtappo := Strtran(_txtappo,"##SETTSINT##",LRTrim(rowTmp.SETTSINT)) */
        _txtappo = CPLib.Strtran(_txtappo,"##SETTSINT##",CPLib.LRTrim(rowTmp.SETTSINT));
        /* _txtappo := Strtran(_txtappo,"##PAESECP##",LRTrim(rowTmp.PAESECP)) */
        _txtappo = CPLib.Strtran(_txtappo,"##PAESECP##",CPLib.LRTrim(rowTmp.PAESECP));
        /* _txtappo := Strtran(_txtappo,"##CABCP##",LRTrim(rowTmp.CODCABCP)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CABCP##",CPLib.LRTrim(rowTmp.CODCABCP));
        /* _txtappo := Strtran(_txtappo,"##PAESEICP##",LRTrim(rowTmp.PAESEICP)) */
        _txtappo = CPLib.Strtran(_txtappo,"##PAESEICP##",CPLib.LRTrim(rowTmp.PAESEICP));
        /* _txtappo := Strtran(_txtappo,"##CABICP##",LRTrim(rowTmp.CABICP)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CABICP##",CPLib.LRTrim(rowTmp.CABICP));
        /* mcTxt1.AppendBlank() */
        mcTxt1.AppendBlank();
        /* mcTxt1.testo := LRTrim(_txtappo) */
        mcTxt1.row.testo = CPLib.LRTrim(_txtappo);
        /* mcTxt1.SaveRow() */
        mcTxt1.SaveRow();
        /* _txtappo := '' */
        _txtappo = "";
        /* _txtappo := _ext2 */
        _txtappo = _ext2;
        /* _tope := iif(rowTmp.OPERAZIONI - Int(rowTmp.OPERAZIONI) > 0,Int(rowTmp.OPERAZIONI)+1,rowTmp.OPERAZIONI) */
        _tope = CPLib.Round((CPLib.gt(rowTmp.OPERAZIONI-CPLib.Int(rowTmp.OPERAZIONI),0)?CPLib.Int(rowTmp.OPERAZIONI)+1:rowTmp.OPERAZIONI),0);
        /* _tcon := iif(rowTmp.CONTANTI - Int(rowTmp.CONTANTI) > 0,Int(rowTmp.CONTANTI)+1,rowTmp.CONTANTI) */
        _tcon = CPLib.Round((CPLib.gt(rowTmp.CONTANTI-CPLib.Int(rowTmp.CONTANTI),0)?CPLib.Int(rowTmp.CONTANTI)+1:rowTmp.CONTANTI),0);
        /* _totimp := rowTmp.TOTLIRE */
        _totimp = CPLib.Round(rowTmp.TOTLIRE,2);
        /* _totimp := iif(_totimp - Int(_totimp) > 0,Int(_totimp)+1,_totimp) */
        _totimp = CPLib.Round((CPLib.gt(_totimp-CPLib.Int(_totimp),0)?CPLib.Int(_totimp)+1:_totimp),2);
        /* _totimp := iif(_totimp=0,1,_totimp) */
        _totimp = CPLib.Round((CPLib.eqr(_totimp,0)?1:_totimp),2);
        /* _totcon := rowTmp.TOTCONT */
        _totcon = CPLib.Round(rowTmp.TOTCONT,2);
        /* _totcon := iif(_totcon - Int(_totcon) > 0,Int(_totcon)+1,_totcon) */
        _totcon = CPLib.Round((CPLib.gt(_totcon-CPLib.Int(_totcon),0)?CPLib.Int(_totcon)+1:_totcon),2);
        /* _totcon := iif(_totcon=0 and _tcon > 0,1,_totcon) */
        _totcon = CPLib.Round((CPLib.eqr(_totcon,0) && CPLib.gt(_tcon,0)?1:_totcon),2);
        /* _txtappo := Strtran(_txtappo,"##NEXT##",iif(rowTmp.N_EXT=1,'',LRTrim(Str(rowTmp.N_EXT,10,0)))) */
        _txtappo = CPLib.Strtran(_txtappo,"##NEXT##",(CPLib.eqr(rowTmp.N_EXT,1)?"":CPLib.LRTrim(CPLib.Str(rowTmp.N_EXT,10,0))));
        /* _txtappo := Strtran(_txtappo,"##TOTIMP##",LRTrim(Str(_totimp,15,0))) */
        _txtappo = CPLib.Strtran(_txtappo,"##TOTIMP##",CPLib.LRTrim(CPLib.Str(_totimp,15,0)));
        /* _txtappo := Strtran(_txtappo,"##TOTOPE##",LRTrim(Str(_tope,10,0))) */
        _txtappo = CPLib.Strtran(_txtappo,"##TOTOPE##",CPLib.LRTrim(CPLib.Str(_tope,10,0)));
        /* _txtappo := Strtran(_txtappo,"##TOTCON##",LRTrim(Str(_totcon,15,0))) */
        _txtappo = CPLib.Strtran(_txtappo,"##TOTCON##",CPLib.LRTrim(CPLib.Str(_totcon,15,0)));
        /* _txtappo := Strtran(_txtappo,"##OPECON##",LRTrim(Str(_tcon,10,0))) */
        _txtappo = CPLib.Strtran(_txtappo,"##OPECON##",CPLib.LRTrim(CPLib.Str(_tcon,10,0)));
        /* mcTxt2.AppendBlank() */
        mcTxt2.AppendBlank();
        /* mcTxt2.testo := LRTrim(_txtappo) */
        mcTxt2.row.testo = CPLib.LRTrim(_txtappo);
        /* mcTxt2.SaveRow() */
        mcTxt2.SaveRow();
        /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(rowTmp.CODINTDIP)+LRTrim(rowTmp.ABICABDIP)+LRTrim(rowTmp.CODCABDIP)+LRTrim(rowTmp.PERPAESE)+LRTrim(rowTmp.PERCAB)+LRTrim(rowTmp.CODVOC)+LRTrim(rowTmp.FLAGLIRE) */
        _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(rowTmp.CODINTDIP)+CPLib.LRTrim(rowTmp.ABICABDIP)+CPLib.LRTrim(rowTmp.CODCABDIP)+CPLib.LRTrim(rowTmp.PERPAESE)+CPLib.LRTrim(rowTmp.PERCAB)+CPLib.LRTrim(rowTmp.CODVOC)+CPLib.LRTrim(rowTmp.FLAGLIRE);
        /* _chiave := _chiave + LRTrim(rowTmp.SEGNO) + LRTrim(rowTmp.SETTSINT)+LRTrim(rowTmp.PAESECP)+LRTrim(rowTmp.CODCABCP)+LRTrim(rowTmp.PAESEICP)+LRTrim(rowTmp.CABICP) */
        _chiave = _chiave+CPLib.LRTrim(rowTmp.SEGNO)+CPLib.LRTrim(rowTmp.SETTSINT)+CPLib.LRTrim(rowTmp.PAESECP)+CPLib.LRTrim(rowTmp.CODCABCP)+CPLib.LRTrim(rowTmp.PAESEICP)+CPLib.LRTrim(rowTmp.CABICP);
        /* If mcStorico.GoToKey(_chiave) */
        if (mcStorico.GoToKey(_chiave)) {
          /* mcStorico.TOTLIRE := _totimp */
          mcStorico.row.TOTLIRE = _totimp;
          /* mcStorico.TOTCONT := _totcon */
          mcStorico.row.TOTCONT = _totcon;
          /* mcStorico.OPERAZIONI := _tope */
          mcStorico.row.OPERAZIONI = _tope;
          /* mcStorico.CONTANTI := _tcon */
          mcStorico.row.CONTANTI = _tcon;
          /* mcStorico.SaveRow() */
          mcStorico.SaveRow();
        } // End If
      }
      /* _contaw := 0 */
      _contaw = CPLib.Round(0,0);
      /* mcTmp.Zap() */
      mcTmp.Zap();
      /* mcAlt.GoTop() */
      mcAlt.GoTop();
      /* While not(mcAlt.Eof()) */
      while ( ! (mcAlt.Eof())) {
        /* _contaw := _contaw + 1 */
        _contaw = CPLib.Round(_contaw+1,0);
        /* gMsgImp := 'Elaboro Altre Operazioni: '+ LRTrim(Str(_contaw,10,0)) // Messaggio Import */
        gMsgImp = "Elaboro Altre Operazioni: "+CPLib.LRTrim(CPLib.Str(_contaw,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If mcTmp.GoToKey(LRTrim(mcAlt.CODINTDIP)+LRTrim(mcAlt.ABICABDIP)+LRTrim(mcAlt.CODCABDIP)+LRTrim(mcAlt.PERPAESE)+LRTrim(mcAlt.PERCAB)+LRTrim(mcAlt.CODVOC)+LRTrim(mcAlt.FLAGLIRE)+LRTrim(mcAlt.SEGNO)+LRTrim(mcAlt.SETTSINT)+LRTrim(mcAlt.PAESECP)+LRTrim(mcAlt.CODCABCP)+LRTrim(mcAlt.PAESEICP)+LRTrim(mcAlt.CABICP)) */
        if (mcTmp.GoToKey(CPLib.LRTrim(mcAlt.row.CODINTDIP)+CPLib.LRTrim(mcAlt.row.ABICABDIP)+CPLib.LRTrim(mcAlt.row.CODCABDIP)+CPLib.LRTrim(mcAlt.row.PERPAESE)+CPLib.LRTrim(mcAlt.row.PERCAB)+CPLib.LRTrim(mcAlt.row.CODVOC)+CPLib.LRTrim(mcAlt.row.FLAGLIRE)+CPLib.LRTrim(mcAlt.row.SEGNO)+CPLib.LRTrim(mcAlt.row.SETTSINT)+CPLib.LRTrim(mcAlt.row.PAESECP)+CPLib.LRTrim(mcAlt.row.CODCABCP)+CPLib.LRTrim(mcAlt.row.PAESEICP)+CPLib.LRTrim(mcAlt.row.CABICP))) {
          /* mcTmp.TOTLIRE := mcTmp.TOTLIRE + mcAlt.TOTLIRE */
          mcTmp.row.TOTLIRE = mcTmp.row.TOTLIRE+mcAlt.row.TOTLIRE;
          /* mcTmp.TOTCONT := mcTmp.TOTCONT + mcAlt.TOTCONT */
          mcTmp.row.TOTCONT = mcTmp.row.TOTCONT+mcAlt.row.TOTCONT;
          /* mcTmp.OPERAZIONI := mcTmp.OPERAZIONI + mcAlt.OPERAZIONI */
          mcTmp.row.OPERAZIONI = mcTmp.row.OPERAZIONI+mcAlt.row.OPERAZIONI;
          /* mcTmp.CONTANTI := mcTmp.CONTANTI + mcAlt.CONTANTI */
          mcTmp.row.CONTANTI = mcTmp.row.CONTANTI+mcAlt.row.CONTANTI;
          /* mcTmp.SaveRow() */
          mcTmp.SaveRow();
        } else { // Else
          /* _nalt := _nalt + 1 */
          _nalt = CPLib.Round(_nalt+1,0);
          /* rowTmp.CODINTDIP := mcAlt.CODINTDIP */
          rowTmp.CODINTDIP = mcAlt.row.CODINTDIP;
          /* rowTmp.ABICABDIP := mcAlt.ABICABDIP */
          rowTmp.ABICABDIP = mcAlt.row.ABICABDIP;
          /* rowTmp.CODCABDIP := mcAlt.CODCABDIP */
          rowTmp.CODCABDIP = mcAlt.row.CODCABDIP;
          /* rowTmp.PERPAESE := mcAlt.PERPAESE */
          rowTmp.PERPAESE = mcAlt.row.PERPAESE;
          /* rowTmp.PERCAB := mcAlt.PERCAB */
          rowTmp.PERCAB = mcAlt.row.PERCAB;
          /* rowTmp.CODVOC := mcAlt.CODVOC */
          rowTmp.CODVOC = mcAlt.row.CODVOC;
          /* rowTmp.FLAGLIRE := mcAlt.FLAGLIRE */
          rowTmp.FLAGLIRE = mcAlt.row.FLAGLIRE;
          /* rowTmp.SEGNO := mcAlt.SEGNO */
          rowTmp.SEGNO = mcAlt.row.SEGNO;
          /* rowTmp.SETTSINT := mcAlt.SETTSINT */
          rowTmp.SETTSINT = mcAlt.row.SETTSINT;
          /* rowTmp.PAESECP := mcAlt.PAESECP */
          rowTmp.PAESECP = mcAlt.row.PAESECP;
          /* rowTmp.CODCABCP := mcAlt.CODCABCP */
          rowTmp.CODCABCP = mcAlt.row.CODCABCP;
          /* rowTmp.PAESEICP := mcAlt.PAESEICP */
          rowTmp.PAESEICP = mcAlt.row.PAESEICP;
          /* rowTmp.CABICP := mcAlt.CABICP */
          rowTmp.CABICP = mcAlt.row.CABICP;
          /* rowTmp.TOTLIRE := mcAlt.TOTLIRE */
          rowTmp.TOTLIRE = mcAlt.row.TOTLIRE;
          /* rowTmp.TOTCONT := mcAlt.TOTCONT */
          rowTmp.TOTCONT = mcAlt.row.TOTCONT;
          /* rowTmp.OPERAZIONI := mcAlt.OPERAZIONI */
          rowTmp.OPERAZIONI = mcAlt.row.OPERAZIONI;
          /* rowTmp.CONTANTI := mcAlt.CONTANTI */
          rowTmp.CONTANTI = mcAlt.row.CONTANTI;
          /* rowTmp.N_ALT := _nalt */
          rowTmp.N_ALT = _nalt;
          /* mcTmp.AppendRowWithKey(LRTrim(mcAlt.CODINTDIP)+LRTrim(mcAlt.ABICABDIP)+LRTrim(mcAlt.CODCABDIP)+LRTrim(mcAlt.PERPAESE)+LRTrim(mcAlt.PERCAB)+LRTrim(mcAlt.CODVOC)+LRTrim(mcAlt.FLAGLIRE)+LRTrim(mcAlt.SEGNO)+LRTrim(mcAlt.SETTSINT)+LRTrim(mcAlt.PAESECP)+LRTrim(mcAlt.CODCABCP)+LRTrim(mcAlt.PAESEICP)+LRTrim(mcAlt.CABICP),rowTmp) */
          mcTmp.AppendRowWithKey(CPLib.LRTrim(mcAlt.row.CODINTDIP)+CPLib.LRTrim(mcAlt.row.ABICABDIP)+CPLib.LRTrim(mcAlt.row.CODCABDIP)+CPLib.LRTrim(mcAlt.row.PERPAESE)+CPLib.LRTrim(mcAlt.row.PERCAB)+CPLib.LRTrim(mcAlt.row.CODVOC)+CPLib.LRTrim(mcAlt.row.FLAGLIRE)+CPLib.LRTrim(mcAlt.row.SEGNO)+CPLib.LRTrim(mcAlt.row.SETTSINT)+CPLib.LRTrim(mcAlt.row.PAESECP)+CPLib.LRTrim(mcAlt.row.CODCABCP)+CPLib.LRTrim(mcAlt.row.PAESEICP)+CPLib.LRTrim(mcAlt.row.CABICP),rowTmp);
        } // End If
        /* mcAlt.Skip() */
        mcAlt.Skip();
      } // End While
      /* mcAlt.Zap() */
      mcAlt.Zap();
      MemoryCursor_tmp_invio_xbrl cpmc_0000051F;
      cpmc_0000051F = new MemoryCursor_tmp_invio_xbrl();
      for (MemoryCursorRow_tmp_invio_xbrl rowTmp : mcTmp._iterable_()) {
        cpmc_0000051F.Append(rowTmp);
      }
      for (MemoryCursorRow_tmp_invio_xbrl rowTmp : cpmc_0000051F._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_tmp_invio_xbrl>(){  public int compare(MemoryCursorRow_tmp_invio_xbrl r1,MemoryCursorRow_tmp_invio_xbrl r2){    if (CPLib.gt(r1.N_ALT,r2.N_ALT)) return 1;    if (CPLib.lt(r1.N_ALT,r2.N_ALT)) return -1;    return 0;  }})) {
        /* gMsgImp := 'Sostituzione Macro per Riga Altre Elaborazioni'+ LRTrim(Str(rowTmp.N_ALT,10,0)) // Messaggio Import */
        gMsgImp = "Sostituzione Macro per Riga Altre Elaborazioni"+CPLib.LRTrim(CPLib.Str(rowTmp.N_ALT,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _txtappo := _alt1 */
        _txtappo = _alt1;
        /* _txtappo := Strtran(_txtappo,"##NALT##",iif(rowTmp.N_ALT=1,'',LRTrim(Str(rowTmp.N_ALT,10,0)))) */
        _txtappo = CPLib.Strtran(_txtappo,"##NALT##",(CPLib.eqr(rowTmp.N_ALT,1)?"":CPLib.LRTrim(CPLib.Str(rowTmp.N_ALT,10,0))));
        /* _txtappo := Strtran(_txtappo,"##TIPINTER##",_tipcentro) */
        _txtappo = CPLib.Strtran(_txtappo,"##TIPINTER##",_tipcentro);
        /* _txtappo := Strtran(_txtappo,"##PIVAINTER##",_codcentro) */
        _txtappo = CPLib.Strtran(_txtappo,"##PIVAINTER##",_codcentro);
        /* _txtappo := Strtran(_txtappo,"##FINE_PERIODO##",_datafine) */
        _txtappo = CPLib.Strtran(_txtappo,"##FINE_PERIODO##",_datafine);
        /* _txtappo := Strtran(_txtappo,"##CODDIP##",LRTrim(rowTmp.CODINTDIP)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CODDIP##",CPLib.LRTrim(rowTmp.CODINTDIP));
        /* _txtappo := Strtran(_txtappo,"##CABDIP##",LRTrim(rowTmp.CODCABDIP)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CABDIP##",CPLib.LRTrim(rowTmp.CODCABDIP));
        /* If _tipcentro='02' */
        if (CPLib.eqr(_tipcentro,"02")) {
          /* _txtappo := Strtran(_txtappo,"##ABICAB##",LRTrim(rowTmp.ABICABDIP)) */
          _txtappo = CPLib.Strtran(_txtappo,"##ABICAB##",CPLib.LRTrim(rowTmp.ABICABDIP));
        } // End If
        /* _txtappo := Strtran(_txtappo,"##PAESECLI##",LRTrim(rowTmp.PERPAESE)) */
        _txtappo = CPLib.Strtran(_txtappo,"##PAESECLI##",CPLib.LRTrim(rowTmp.PERPAESE));
        /* _txtappo := Strtran(_txtappo,"##CABCLI##",LRTrim(rowTmp.PERCAB)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CABCLI##",CPLib.LRTrim(rowTmp.PERCAB));
        /* _txtappo := Strtran(_txtappo,"##CODVOC##",LRTrim(rowTmp.CODVOC)) */
        _txtappo = CPLib.Strtran(_txtappo,"##CODVOC##",CPLib.LRTrim(rowTmp.CODVOC));
        /* _txtappo := Strtran(_txtappo,"##VALUTA##",LRTrim(rowTmp.FLAGLIRE)) */
        _txtappo = CPLib.Strtran(_txtappo,"##VALUTA##",CPLib.LRTrim(rowTmp.FLAGLIRE));
        /* _txtappo := Strtran(_txtappo,"##SEGNO##",LRTrim(rowTmp.SEGNO)) */
        _txtappo = CPLib.Strtran(_txtappo,"##SEGNO##",CPLib.LRTrim(rowTmp.SEGNO));
        /* _txtappo := Strtran(_txtappo,"##SETTSINT##",LRTrim(rowTmp.SETTSINT)) */
        _txtappo = CPLib.Strtran(_txtappo,"##SETTSINT##",CPLib.LRTrim(rowTmp.SETTSINT));
        /* mcTxt1.AppendBlank() */
        mcTxt1.AppendBlank();
        /* mcTxt1.testo := LRTrim(_txtappo) */
        mcTxt1.row.testo = CPLib.LRTrim(_txtappo);
        /* mcTxt1.SaveRow() */
        mcTxt1.SaveRow();
        /* _txtappo := '' */
        _txtappo = "";
        /* _txtappo := _alt2 */
        _txtappo = _alt2;
        /* _tope := iif(rowTmp.OPERAZIONI - Int(rowTmp.OPERAZIONI) > 0,Int(rowTmp.OPERAZIONI)+1,rowTmp.OPERAZIONI) */
        _tope = CPLib.Round((CPLib.gt(rowTmp.OPERAZIONI-CPLib.Int(rowTmp.OPERAZIONI),0)?CPLib.Int(rowTmp.OPERAZIONI)+1:rowTmp.OPERAZIONI),0);
        /* _tcon := iif(rowTmp.CONTANTI - Int(rowTmp.CONTANTI) > 0,Int(rowTmp.CONTANTI)+1,rowTmp.CONTANTI) */
        _tcon = CPLib.Round((CPLib.gt(rowTmp.CONTANTI-CPLib.Int(rowTmp.CONTANTI),0)?CPLib.Int(rowTmp.CONTANTI)+1:rowTmp.CONTANTI),0);
        /* _totimp := rowTmp.TOTLIRE */
        _totimp = CPLib.Round(rowTmp.TOTLIRE,2);
        /* _totimp := iif(_totimp - Int(_totimp) > 0,Int(_totimp)+1,_totimp) */
        _totimp = CPLib.Round((CPLib.gt(_totimp-CPLib.Int(_totimp),0)?CPLib.Int(_totimp)+1:_totimp),2);
        /* _totimp := iif(_totimp=0,1,_totimp) */
        _totimp = CPLib.Round((CPLib.eqr(_totimp,0)?1:_totimp),2);
        /* _totcon := rowTmp.TOTCONT */
        _totcon = CPLib.Round(rowTmp.TOTCONT,2);
        /* _totcon := iif(_totcon=0 and _tcon > 0,1,_totcon) */
        _totcon = CPLib.Round((CPLib.eqr(_totcon,0) && CPLib.gt(_tcon,0)?1:_totcon),2);
        /* _totcon := iif(_totcon - Int(_totcon) > 0,Int(_totcon)+1,_totcon) */
        _totcon = CPLib.Round((CPLib.gt(_totcon-CPLib.Int(_totcon),0)?CPLib.Int(_totcon)+1:_totcon),2);
        /* _txtappo := Strtran(_txtappo,"##NALT##",iif(rowTmp.N_ALT=1,'',LRTrim(Str(rowTmp.N_ALT,10,0)))) */
        _txtappo = CPLib.Strtran(_txtappo,"##NALT##",(CPLib.eqr(rowTmp.N_ALT,1)?"":CPLib.LRTrim(CPLib.Str(rowTmp.N_ALT,10,0))));
        /* _txtappo := Strtran(_txtappo,"##TOTIMP##",LRTrim(Str(_totimp,15,0))) */
        _txtappo = CPLib.Strtran(_txtappo,"##TOTIMP##",CPLib.LRTrim(CPLib.Str(_totimp,15,0)));
        /* _txtappo := Strtran(_txtappo,"##TOTOPE##",LRTrim(Str(_tope,10,0))) */
        _txtappo = CPLib.Strtran(_txtappo,"##TOTOPE##",CPLib.LRTrim(CPLib.Str(_tope,10,0)));
        /* _txtappo := Strtran(_txtappo,"##TOTCON##",LRTrim(Str(_totcon,15,0))) */
        _txtappo = CPLib.Strtran(_txtappo,"##TOTCON##",CPLib.LRTrim(CPLib.Str(_totcon,15,0)));
        /* _txtappo := Strtran(_txtappo,"##OPECON##",LRTrim(Str(_tcon,10,0))) */
        _txtappo = CPLib.Strtran(_txtappo,"##OPECON##",CPLib.LRTrim(CPLib.Str(_tcon,10,0)));
        /* mcTxt2.AppendBlank() */
        mcTxt2.AppendBlank();
        /* mcTxt2.testo := LRTrim(_txtappo) */
        mcTxt2.row.testo = CPLib.LRTrim(_txtappo);
        /* mcTxt2.SaveRow() */
        mcTxt2.SaveRow();
        /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(rowTmp.CODINTDIP)+LRTrim(rowTmp.ABICABDIP)+LRTrim(rowTmp.CODCABDIP)+LRTrim(rowTmp.PERPAESE)+LRTrim(rowTmp.PERCAB)+LRTrim(rowTmp.CODVOC)+LRTrim(rowTmp.FLAGLIRE) */
        _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(rowTmp.CODINTDIP)+CPLib.LRTrim(rowTmp.ABICABDIP)+CPLib.LRTrim(rowTmp.CODCABDIP)+CPLib.LRTrim(rowTmp.PERPAESE)+CPLib.LRTrim(rowTmp.PERCAB)+CPLib.LRTrim(rowTmp.CODVOC)+CPLib.LRTrim(rowTmp.FLAGLIRE);
        /* _chiave := _chiave + LRTrim(rowTmp.SEGNO) + LRTrim(rowTmp.SETTSINT)+LRTrim(rowTmp.PAESECP)+LRTrim(rowTmp.CODCABCP)+LRTrim(rowTmp.PAESEICP)+LRTrim(rowTmp.CABICP) */
        _chiave = _chiave+CPLib.LRTrim(rowTmp.SEGNO)+CPLib.LRTrim(rowTmp.SETTSINT)+CPLib.LRTrim(rowTmp.PAESECP)+CPLib.LRTrim(rowTmp.CODCABCP)+CPLib.LRTrim(rowTmp.PAESEICP)+CPLib.LRTrim(rowTmp.CABICP);
        /* If mcStorico.GoToKey(_chiave) */
        if (mcStorico.GoToKey(_chiave)) {
          /* mcStorico.TOTLIRE := _totimp */
          mcStorico.row.TOTLIRE = _totimp;
          /* mcStorico.TOTCONT := _totcon */
          mcStorico.row.TOTCONT = _totcon;
          /* mcStorico.OPERAZIONI := _tope */
          mcStorico.row.OPERAZIONI = _tope;
          /* mcStorico.CONTANTI := _tcon */
          mcStorico.row.CONTANTI = _tcon;
          /* mcStorico.SaveRow() */
          mcStorico.SaveRow();
        } // End If
      }
      /* mcTxt1.GoTop() */
      mcTxt1.GoTop();
      /* _contaw := 0 */
      _contaw = CPLib.Round(0,0);
      /* While not(mcTxt1.Eof()) */
      while ( ! (mcTxt1.Eof())) {
        /* _contaw := _contaw + 1 */
        _contaw = CPLib.Round(_contaw+1,0);
        /* gMsgImp := 'Scrivo Riga Bonifici:'+LRTrim(Str(_contaw,10,0)) // Messaggio Import */
        gMsgImp = "Scrivo Riga Bonifici:"+CPLib.LRTrim(CPLib.Str(_contaw,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* FileLibMit.Write(fhand,LRTrim(mcTxt1.testo)+NL) */
        FileLibMit.Write(fhand,CPLib.LRTrim(mcTxt1.row.testo)+"\n");
        /* mcTxt1.Skip() */
        mcTxt1.Skip();
      } // End While
      /* mcTxt1.Zap() */
      mcTxt1.Zap();
      /* _txtappo := '' */
      _txtappo = "";
      // * --- Select from xbrl_def
      m_cServer = m_Ctx.GetServer("xbrl_def");
      m_cPhName = m_Ctx.GetPhName("xbrl_def");
      if (Cursor_xbrl_def!=null)
        Cursor_xbrl_def.Close();
      Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='UNITA' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xbrl_def.Eof())) {
        /* _txtappo := xbrl_def->XML_TXT */
        _txtappo = Cursor_xbrl_def.GetString("XML_TXT");
        /* _txtappo := Strtran(_txtappo,"##PIVAINTER##",_codcentro) */
        _txtappo = CPLib.Strtran(_txtappo,"##PIVAINTER##",_codcentro);
        /* _txtappo := Strtran(_txtappo,"##FINE_PERIODO##",_datafine) */
        _txtappo = CPLib.Strtran(_txtappo,"##FINE_PERIODO##",_datafine);
        /* _testo := LRTrim(_txtappo) + NL */
        _testo = CPLib.LRTrim(_txtappo)+"\n";
        /* FileLibMit.Write(fhand,_testo) */
        FileLibMit.Write(fhand,_testo);
        Cursor_xbrl_def.Next();
      }
      m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
      Cursor_xbrl_def.Close();
      // * --- End Select
      /* _cDataOra := DateTimeToChar(DateTime()) */
      _cDataOra = CPLib.DateTimeToChar(CPLib.DateTime());
      /* _dataprod := Left(_cDataOra,4) + "-"+ Substr(_cDataOra,5,2)+ "-" +Substr(_cDataOra,7,2) */
      _dataprod = CPLib.Left(_cDataOra,4)+"-"+CPLib.Substr(_cDataOra,5,2)+"-"+CPLib.Substr(_cDataOra,7,2);
      /* _oraprod := Substr(_cDataOra,9,2)+":"+Substr(_cDataOra,11,2)+":"+Substr(_cDataOra,13,2) */
      _oraprod = CPLib.Substr(_cDataOra,9,2)+":"+CPLib.Substr(_cDataOra,11,2)+":"+CPLib.Substr(_cDataOra,13,2);
      /* _txtappo := '' */
      _txtappo = "";
      // * --- Select from xbrl_def
      m_cServer = m_Ctx.GetServer("xbrl_def");
      m_cPhName = m_Ctx.GetPhName("xbrl_def");
      if (Cursor_xbrl_def!=null)
        Cursor_xbrl_def.Close();
      Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='TIMEPROD' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xbrl_def.Eof())) {
        /* _txtappo := xbrl_def->XML_TXT */
        _txtappo = Cursor_xbrl_def.GetString("XML_TXT");
        /* _txtappo := Strtran(_txtappo,"##DATAPROD##",_dataprod) */
        _txtappo = CPLib.Strtran(_txtappo,"##DATAPROD##",_dataprod);
        /* _txtappo := Strtran(_txtappo,"##ORAPROD##",_oraprod) */
        _txtappo = CPLib.Strtran(_txtappo,"##ORAPROD##",_oraprod);
        /* _testo := LRTrim(_txtappo) + NL */
        _testo = CPLib.LRTrim(_txtappo)+"\n";
        /* FileLibMit.Write(fhand,_testo) */
        FileLibMit.Write(fhand,_testo);
        Cursor_xbrl_def.Next();
      }
      m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
      Cursor_xbrl_def.Close();
      // * --- End Select
      /* mcTxt2.GoTop() */
      mcTxt2.GoTop();
      /* _contaw := 0 */
      _contaw = CPLib.Round(0,0);
      /* While not(mcTxt2.Eof()) */
      while ( ! (mcTxt2.Eof())) {
        /* _contaw := _contaw + 1 */
        _contaw = CPLib.Round(_contaw+1,0);
        /* gMsgImp := 'Scrivo Riga Totali: '+LRTrim(Str(_contaw,10,0)) // Messaggio Import */
        gMsgImp = "Scrivo Riga Totali: "+CPLib.LRTrim(CPLib.Str(_contaw,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* FileLibMit.Write(fhand,LRTrim(mcTxt2.testo)+NL) */
        FileLibMit.Write(fhand,CPLib.LRTrim(mcTxt2.row.testo)+"\n");
        /* mcTxt2.Skip() */
        mcTxt2.Skip();
      } // End While
      /* mcTxt2.Zap() */
      mcTxt2.Zap();
      // * --- Select from xbrl_def
      m_cServer = m_Ctx.GetServer("xbrl_def");
      m_cPhName = m_Ctx.GetPhName("xbrl_def");
      if (Cursor_xbrl_def!=null)
        Cursor_xbrl_def.Close();
      Cursor_xbrl_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SEZIONE='EPILOGO' "+")"+(m_Ctx.IsSharedTemp("xbrl_def")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xbrl_def.Eof())) {
        /* _testo := LRTrim(xbrl_def->XML_TXT) + NL */
        _testo = CPLib.LRTrim(Cursor_xbrl_def.GetString("XML_TXT"))+"\n";
        /* FileLibMit.Write(fhand,_testo) */
        FileLibMit.Write(fhand,_testo);
        Cursor_xbrl_def.Next();
      }
      m_cConnectivityError = Cursor_xbrl_def.ErrorMessage();
      Cursor_xbrl_def.Close();
      // * --- End Select
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* _idf := '' */
      _idf = "";
      // * --- Read from filedatiuic
      m_cServer = m_Ctx.GetServer("filedatiuic");
      m_cPhName = m_Ctx.GetPhName("filedatiuic");
      m_cSql = "";
      m_cSql = m_cSql+"nomefile="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_file)+"_"+CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(w_numinv,5,0)),5)+".zip","C",30,0,m_cServer),m_cServer,CPLib.LRTrim(_file)+"_"+CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(w_numinv,5,0)),5)+".zip");
      m_cSql = m_cSql+" and datafile="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Date(),"D",8,0,m_cServer),m_cServer,CPLib.Date());
      if (m_Ctx.IsSharedTemp("filedatiuic")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("idfile",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _idf = Read_Cursor.GetString("idfile");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on filedatiuic into routine arrt_discouic_xbrl returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _idf = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If Empty(_idf) */
      if (CPLib.Empty(_idf)) {
        /* cProg := Utilities.GetAutonumber("PRGFILEUIC\'"+LRTrim(gAzienda)+"'",'',10) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILEUIC\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        // * --- Insert into filedatiuic from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("filedatiuic");
        m_cPhName = m_Ctx.GetPhName("filedatiuic");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"filedatiuic",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_xbrl",277,"00000577")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000577(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_file)+"_"+CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(w_numinv,5,0)),5)+".zip","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Dati Aggregati relativi al periodo: "+arfn_fdateR.Make(m_Ctx,this).Run(w_DaDatOpe)+" - "+arfn_fdateR.Make(m_Ctx,this).Run(w_ADatOpe)+" - Invio N. "+CPLib.LRTrim(CPLib.Str(w_numinv,3,0)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"filedatiuic",true);
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
      /* gMsgProc := gMsgProc + 'Ora Fine Creazione del file XBRL: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Creazione del file XBRL: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_xbrl_def!=null)
          Cursor_xbrl_def.Close();
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
    }
  }
  void Page_5() throws Exception {
    /* Crea file zip */
    // These are the files to include in the ZIP file
        String[] filenames = new String[]{cNomeFile};
        
        // Create a buffer for reading the files
        byte[] buf = new byte[1024];
        
        try {
            // Create the ZIP file
            String outFilename = cNomeFileZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Compress the files
            for (int i=0; i<filenames.length; i++) {
                java.io.FileInputStream in = new java.io.FileInputStream(filenames[i]);
        
                // Add ZIP entry to output stream.
                out.putNextEntry(new java.util.zip.ZipEntry(cOnlyNomeFile));
        
                // Transfer bytes from the file to the ZIP file
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
        
                // Complete the entry
                out.closeEntry();
                in.close();
            }
        
            // Complete the ZIP file
            out.close();
        } catch (java.io.IOException e) {
        }
    
  }
  void Page_6() throws Exception {
    CPResultSet Cursor_qbe_kpeuif=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_clientisara=null;
    CPResultSet Cursor_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla su fraziobo e seleziona i record nel range definito */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni Società Quotate' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni Società Quotate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _contaop := 0 */
      _contaop = CPLib.Round(0,0);
      /* _cope := 0 */
      _cope = CPLib.Round(0,0);
      // * --- Select from qbe_kpeuif
      SPBridge.HMCaller _h0000057F;
      _h0000057F = new SPBridge.HMCaller();
      _h0000057F.Set("m_cVQRList",m_cVQRList);
      _h0000057F.Set("cdadata",_datini);
      _h0000057F.Set("c_adata",_datfin);
      if (Cursor_qbe_kpeuif!=null)
        Cursor_qbe_kpeuif.Close();
      Cursor_qbe_kpeuif = new VQRHolder("qbe_kpeuif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000057F,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_kpeuif.Eof())) {
        /* _cope := _cope + 1 */
        _cope = CPLib.Round(_cope+1,0);
        /* _contaop := _contaop + 1 */
        _contaop = CPLib.Round(_contaop+1,0);
        /* _totconta := _totconta + 1 */
        _totconta = CPLib.Round(_totconta+1,0);
        /* gMsgImp := 'Elaboro Operazione Società Quotata N. '+ LRTrim(Str(_contaop,10,0)) // Messaggio Import */
        gMsgImp = "Elaboro Operazione Società Quotata N. "+CPLib.LRTrim(CPLib.Str(_contaop,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _coddip := "" */
        _coddip = "";
        /* _abicab := '000000000000' */
        _abicab = "000000000000";
        /* _cabdip := '' */
        _cabdip = "";
        /* _paesecli := '' */
        _paesecli = "";
        /* _cabcli := '' */
        _cabcli = "";
        /* _paesecp := '' */
        _paesecp = "";
        /* _cabcp := '' */
        _cabcp = "";
        /* _paeseicp := '' */
        _paeseicp = "";
        /* _cabicp := '' */
        _cabicp = "";
        /* _settsint := '' */
        _settsint = "";
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* _operaz := 0 */
        _operaz = CPLib.Round(0,2);
        /* _ocont := 0 */
        _ocont = CPLib.Round(0,2);
        /* If Empty(LRTrim(qbe_kpeuif->CODDIPE)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("CODDIPE")))) {
          /* If _tipcentro='02' */
          if (CPLib.eqr(_tipcentro,"02")) {
            /* _coddip := _dipbase */
            _coddip = _dipbase;
            /* _cabdip := _dipcab */
            _cabdip = _dipcab;
            /* _abicab := _dipabicab */
            _abicab = _dipabicab;
          } else { // Else
            /* _coddip := '000000' */
            _coddip = "000000";
            /* _cabdip := _cabint */
            _cabdip = _cabint;
          } // End If
        } else { // Else
          /* _coddip := qbe_kpeuif->CODDIPE */
          _coddip = Cursor_qbe_kpeuif.GetString("CODDIPE");
          /* _cabdip := qbe_kpeuif->CABDIP */
          _cabdip = Cursor_qbe_kpeuif.GetString("CABDIP");
          /* If Empty(_cabdip) */
          if (CPLib.Empty(_cabdip)) {
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"C",6,0,m_cServer),m_cServer,_coddip);
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("ABICABSARA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _cabdip = Read_Cursor.GetString("CAB");
              _abicab = Read_Cursor.GetString("ABICABSARA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_xbrl returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _cabdip = "";
              _abicab = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } else { // Else
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"C",6,0,m_cServer),m_cServer,_coddip);
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ABICABSARA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _abicab = Read_Cursor.GetString("ABICABSARA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_xbrl returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _abicab = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
        } // End If
        /* _pqtotale := qbe_kpeuif->PROQUOTA */
        _pqtotale = CPLib.Round(Cursor_qbe_kpeuif.GetDouble("PROQUOTA"),0);
        // * --- Select from clientisara
        m_cServer = m_Ctx.GetServer("clientisara");
        m_cPhName = m_Ctx.GetPhName("clientisara");
        if (Cursor_clientisara!=null)
          Cursor_clientisara.Close();
        Cursor_clientisara = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDBASE"),"?",0,0)+"  and  CODSOG <> "+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientisara")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_clientisara.Eof())) {
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          /* _pqtotale := _pqtotale + clientisara->PROQUOTA */
          _pqtotale = CPLib.Round(_pqtotale+Cursor_clientisara.GetDouble("PROQUOTA"),0);
          Cursor_clientisara.Next();
        }
        m_cConnectivityError = Cursor_clientisara.ErrorMessage();
        Cursor_clientisara.Close();
        // * --- End Select
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* If _conta > 1 */
        if (CPLib.gt(_conta,1)) {
          /* _operaz := 1 / _conta */
          _operaz = CPLib.Round(1/_conta,2);
          /* _ocont := iif(qbe_kpeuif->TOTCONT <> 0,1 / _conta,0) */
          _ocont = CPLib.Round((CPLib.ne(Cursor_qbe_kpeuif.GetDouble("TOTCONT"),0)?1/_conta:0),2);
        } else { // Else
          /* _operaz := 1 */
          _operaz = CPLib.Round(1,2);
          /* _ocont := iif(qbe_kpeuif->TOTCONT <> 0,1,0) */
          _ocont = CPLib.Round((CPLib.ne(Cursor_qbe_kpeuif.GetDouble("TOTCONT"),0)?1:0),2);
        } // End If
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* rowPers := arfn_datisog_sol_row(personbo->CONNES,qbe_kpeuif->DATAREG,qbe_kpeuif->STATOREG,qbe_kpeuif->DATARETT) */
          rowPers = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("CONNES"),Cursor_qbe_kpeuif.GetDate("DATAREG"),Cursor_qbe_kpeuif.GetString("STATOREG"),Cursor_qbe_kpeuif.GetDate("DATARETT"));
          /* _paesecli := personbo->PAESE */
          _paesecli = Cursor_personbo.GetString("PAESE");
          /* If _paesecli='086' */
          if (CPLib.eqr(_paesecli,"086")) {
            /* _cabcli := iif(not(Empty(personbo->CODCAB)),personbo->CODCAB,qbe_kpeuif->CODCAB2) */
            _cabcli = ( ! (CPLib.Empty(Cursor_personbo.GetString("CODCAB")))?Cursor_personbo.GetString("CODCAB"):Cursor_qbe_kpeuif.GetString("CODCAB2"));
          } else { // Else
            /* _cabcli := '' */
            _cabcli = "";
          } // End If
          /* _settsint := iif(Empty(personbo->SETTSINT),'999',rowPers.SETSINT) */
          _settsint = (CPLib.Empty(Cursor_personbo.GetString("SETTSINT"))?"999":rowPers.SETSINT);
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        /* If At(LRTrim(qbe_kpeuif->CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
        if (CPLib.gt(CPLib.At(CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("CODVOC")),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
          /* _paesecp := qbe_kpeuif->C_STA */
          _paesecp = Cursor_qbe_kpeuif.GetString("C_STA");
          /* If _autoic='S' */
          if (CPLib.eqr(_autoic,"S")) {
            /* _cabcp := iif(_paesecp <>'086','',LRTrim(qbe_kpeuif->C_CAB)) */
            _cabcp = (CPLib.ne(_paesecp,"086")?"":CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("C_CAB")));
            /* If Empty(qbe_kpeuif->PAESE) */
            if (CPLib.Empty(Cursor_qbe_kpeuif.GetString("PAESE"))) {
              /* _paeseicp := _paesecp */
              _paeseicp = _paesecp;
            } else { // Else
              /* _paeseicp := LRTrim(qbe_kpeuif->PAESE) */
              _paeseicp = CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("PAESE"));
            } // End If
            /* Case Empty(qbe_kpeuif->CODCAB2) and _paeseicp='086' */
            if (CPLib.Empty(Cursor_qbe_kpeuif.GetString("CODCAB2")) && CPLib.eqr(_paeseicp,"086")) {
              /* If _paesecp='086' */
              if (CPLib.eqr(_paesecp,"086")) {
                /* _cabicp := _cabcp */
                _cabicp = _cabcp;
              } else { // Else
                /* _cabicp := '' */
                _cabicp = "";
              } // End If
              /* Case Empty(qbe_kpeuif->CODCAB2) and _paeseicp<>'086' and not(Empty(_paeseicp)) */
            } else if (CPLib.Empty(Cursor_qbe_kpeuif.GetString("CODCAB2")) && CPLib.ne(_paeseicp,"086") &&  ! (CPLib.Empty(_paeseicp))) {
              /* _cabicp := '' */
              _cabicp = "";
              /* Case not(Empty(qbe_kpeuif->CODCAB2)) and _paeseicp = '086' */
            } else if ( ! (CPLib.Empty(Cursor_qbe_kpeuif.GetString("CODCAB2"))) && CPLib.eqr(_paeseicp,"086")) {
              /* _cabicp := qbe_kpeuif->CODCAB2 */
              _cabicp = Cursor_qbe_kpeuif.GetString("CODCAB2");
            } // End Case
          } else { // Else
            /* _cabcp := LRTrim(qbe_kpeuif->C_CAB) */
            _cabcp = CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("C_CAB"));
            /* _paeseicp := LRTrim(qbe_kpeuif->PAESE) */
            _paeseicp = CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("PAESE"));
            /* _cabicp := LRTrim(qbe_kpeuif->CODCAB2) */
            _cabicp = CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("CODCAB2"));
          } // End If
          /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_coddip)+iif(Empty(LRTrim(_abicab)),'000000000000',LRTrim(_abicab))+LRTrim(_cabdip)+LRTrim(_paesecli)+LRTrim(_cabcli)+LRTrim(qbe_kpeuif->CODVOC)+LRTrim(qbe_kpeuif->FLAGLIRE) */
          _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_coddip)+(CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":CPLib.LRTrim(_abicab))+CPLib.LRTrim(_cabdip)+CPLib.LRTrim(_paesecli)+CPLib.LRTrim(_cabcli)+CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("CODVOC"))+CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("FLAGLIRE"));
          /* _chiave := _chiave + LRTrim(qbe_kpeuif->SEGNO) + LRTrim(_settsint)+LRTrim(_paesecp)+LRTrim(_cabcp)+LRTrim(_paeseicp)+LRTrim(_cabicp) */
          _chiave = _chiave+CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("SEGNO"))+CPLib.LRTrim(_settsint)+CPLib.LRTrim(_paesecp)+CPLib.LRTrim(_cabcp)+CPLib.LRTrim(_paeseicp)+CPLib.LRTrim(_cabicp);
          /* If not(mcStorico.GoToKey(_chiave)) */
          if ( ! (mcStorico.GoToKey(_chiave))) {
            /* _rifprog := _rifprog + 1 */
            _rifprog = CPLib.Round(_rifprog+1,0);
            /* _progrif := Right('0000000000'+LRTrim(Str(_rifprog,10,0)),10) */
            _progrif = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_rifprog,10,0)),10);
            /* mcStorico.AppendWithKey(_chiave) */
            mcStorico.AppendWithKey(_chiave);
            /* mcStorico.ANNORIF := _anno */
            mcStorico.row.ANNORIF = _anno;
            /* mcStorico.MESERIF := _month */
            mcStorico.row.MESERIF = _month;
            /* mcStorico.PROGRIF := _progrif */
            mcStorico.row.PROGRIF = _progrif;
            /* mcStorico.CODINTDIP := _coddip */
            mcStorico.row.CODINTDIP = _coddip;
            /* mcStorico.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
            mcStorico.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
            /* mcStorico.CODCABDIP := _cabdip */
            mcStorico.row.CODCABDIP = _cabdip;
            /* mcStorico.PERPAESE := _paesecli */
            mcStorico.row.PERPAESE = _paesecli;
            /* mcStorico.PERCAB := _cabcli */
            mcStorico.row.PERCAB = _cabcli;
            /* mcStorico.CODVOC := qbe_kpeuif->CODVOC */
            mcStorico.row.CODVOC = Cursor_qbe_kpeuif.GetString("CODVOC");
            /* mcStorico.FLAGLIRE := qbe_kpeuif->FLAGLIRE */
            mcStorico.row.FLAGLIRE = Cursor_qbe_kpeuif.GetString("FLAGLIRE");
            /* mcStorico.SEGNO := qbe_kpeuif->SEGNO */
            mcStorico.row.SEGNO = Cursor_qbe_kpeuif.GetString("SEGNO");
            /* mcStorico.SETTSINT := _settsint */
            mcStorico.row.SETTSINT = _settsint;
            /* mcStorico.PAESECP := _paesecp */
            mcStorico.row.PAESECP = _paesecp;
            /* mcStorico.CODCABCP := _cabcp */
            mcStorico.row.CODCABCP = _cabcp;
            /* mcStorico.PAESEICP := _paeseicp */
            mcStorico.row.PAESEICP = _paeseicp;
            /* mcStorico.CABICP := _cabicp */
            mcStorico.row.CABICP = _cabicp;
            /* mcStorico.SaveRow() */
            mcStorico.SaveRow();
          } // End If
          /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_progrif)+'O'+LRTrim(qbe_kpeuif->NUMPROG) */
          _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_progrif)+"O"+CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("NUMPROG"));
          /* mcStoricoDett.AppendWithKey(_chiave) */
          mcStoricoDett.AppendWithKey(_chiave);
          /* mcStoricoDett.ANNORIF := _anno */
          mcStoricoDett.row.ANNORIF = _anno;
          /* mcStoricoDett.MESERIF := _month */
          mcStoricoDett.row.MESERIF = _month;
          /* mcStoricoDett.PROGRIF := _progrif */
          mcStoricoDett.row.PROGRIF = _progrif;
          /* mcStoricoDett.TIPOPE := 'K' */
          mcStoricoDett.row.TIPOPE = "K";
          /* mcStoricoDett.NUMPROG := qbe_kpeuif->NUMPROG */
          mcStoricoDett.row.NUMPROG = Cursor_qbe_kpeuif.GetString("NUMPROG");
          /* mcStoricoDett.DATAOPE := qbe_kpeuif->DATAOPE */
          mcStoricoDett.row.DATAOPE = Cursor_qbe_kpeuif.GetDate("DATAOPE");
          /* mcStoricoDett.CODVOC := qbe_kpeuif->CODVOC */
          mcStoricoDett.row.CODVOC = Cursor_qbe_kpeuif.GetString("CODVOC");
          /* mcStoricoDett.FLAGLIRE := qbe_kpeuif->FLAGLIRE */
          mcStoricoDett.row.FLAGLIRE = Cursor_qbe_kpeuif.GetString("FLAGLIRE");
          /* mcStoricoDett.SEGNO := qbe_kpeuif->SEGNO */
          mcStoricoDett.row.SEGNO = Cursor_qbe_kpeuif.GetString("SEGNO");
          /* mcStoricoDett.TOTLIRE := _totimp */
          mcStoricoDett.row.TOTLIRE = _totimp;
          /* mcStoricoDett.TOTCONT := _totcon */
          mcStoricoDett.row.TOTCONT = _totcon;
          /* mcStoricoDett.CODINTDIP := _coddip */
          mcStoricoDett.row.CODINTDIP = _coddip;
          /* mcStoricoDett.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
          mcStoricoDett.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
          /* mcStoricoDett.CODCABDIP := _cabdip */
          mcStoricoDett.row.CODCABDIP = _cabdip;
          /* mcStoricoDett.RAPPORTO := qbe_kpeuif->RAPPORTO */
          mcStoricoDett.row.RAPPORTO = Cursor_qbe_kpeuif.GetString("RAPPORTO");
          /* mcStoricoDett.CONNESCLI := qbe_kpeuif->CONNESCLI */
          mcStoricoDett.row.CONNESCLI = Cursor_qbe_kpeuif.GetString("CONNESCLI");
          /* mcStoricoDett.PERPAESE := _paesecli */
          mcStoricoDett.row.PERPAESE = _paesecli;
          /* mcStoricoDett.PERCAB := _cabcli */
          mcStoricoDett.row.PERCAB = _cabcli;
          /* mcStoricoDett.SETTSINT := _settsint */
          mcStoricoDett.row.SETTSINT = _settsint;
          /* mcStoricoDett.CONNESBEN := qbe_kpeuif->CONNESBEN */
          mcStoricoDett.row.CONNESBEN = Cursor_qbe_kpeuif.GetString("CONNESBEN");
          /* mcStoricoDett.PAESECP := _paesecp */
          mcStoricoDett.row.PAESECP = _paesecp;
          /* mcStoricoDett.CODCABCP := _cabcp */
          mcStoricoDett.row.CODCABCP = _cabcp;
          /* mcStoricoDett.INTCONTRO := qbe_kpeuif->CODINT2 */
          mcStoricoDett.row.INTCONTRO = Cursor_qbe_kpeuif.GetString("CODINT2");
          /* mcStoricoDett.PAESEICP := _paeseicp */
          mcStoricoDett.row.PAESEICP = _paeseicp;
          /* mcStoricoDett.CABICP := _cabicp */
          mcStoricoDett.row.CABICP = _cabicp;
          /* mcStoricoDett.SaveRow() */
          mcStoricoDett.SaveRow();
          /* If _paeseicp <> '086' */
          if (CPLib.ne(_paeseicp,"086")) {
            /* mcExt.AppendBlank() */
            mcExt.AppendBlank();
            /* mcExt.CODINTDIP := _coddip */
            mcExt.row.CODINTDIP = _coddip;
            /* mcExt.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
            mcExt.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
            /* mcExt.CODCABDIP := _cabdip */
            mcExt.row.CODCABDIP = _cabdip;
            /* mcExt.PERPAESE := _paesecli */
            mcExt.row.PERPAESE = _paesecli;
            /* mcExt.PERCAB := _cabcli */
            mcExt.row.PERCAB = _cabcli;
            /* mcExt.CODVOC := qbe_kpeuif->CODVOC */
            mcExt.row.CODVOC = Cursor_qbe_kpeuif.GetString("CODVOC");
            /* mcExt.FLAGLIRE := qbe_kpeuif->FLAGLIRE */
            mcExt.row.FLAGLIRE = Cursor_qbe_kpeuif.GetString("FLAGLIRE");
            /* mcExt.SEGNO := qbe_kpeuif->SEGNO */
            mcExt.row.SEGNO = Cursor_qbe_kpeuif.GetString("SEGNO");
            /* mcExt.SETTSINT := _settsint */
            mcExt.row.SETTSINT = _settsint;
            /* mcExt.PAESECP := _paesecp */
            mcExt.row.PAESECP = _paesecp;
            /* mcExt.CODCABCP := _cabcp */
            mcExt.row.CODCABCP = _cabcp;
            /* mcExt.PAESEICP := iif(Empty(_paeseicp),_paesecp,_paeseicp) */
            mcExt.row.PAESEICP = (CPLib.Empty(_paeseicp)?_paesecp:_paeseicp);
            /* mcExt.CABICP := iif(Empty(_paeseicp) and _paesecp='086',_cabcp,_cabicp) */
            mcExt.row.CABICP = (CPLib.Empty(_paeseicp) && CPLib.eqr(_paesecp,"086")?_cabcp:_cabicp);
            /* If _pqtotale=0 */
            if (CPLib.eqr(_pqtotale,0)) {
              /* mcExt.TOTLIRE := qbe_kpeuif->TOTLIRE / (_conta * 100) */
              mcExt.row.TOTLIRE = Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/(_conta*100);
              /* mcExt.TOTCONT := qbe_kpeuif->TOTCONT / (_conta * 100) */
              mcExt.row.TOTCONT = Cursor_qbe_kpeuif.GetDouble("TOTCONT")/(_conta*100);
            } else { // Else
              /* mcExt.TOTLIRE := (qbe_kpeuif->TOTLIRE / 10000) * qbe_kpeuif->PROQUOTA */
              mcExt.row.TOTLIRE = (Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/10000)*Cursor_qbe_kpeuif.GetDouble("PROQUOTA");
              /* mcExt.TOTCONT := (qbe_kpeuif->TOTCONT / 10000)  * qbe_kpeuif->PROQUOTA */
              mcExt.row.TOTCONT = (Cursor_qbe_kpeuif.GetDouble("TOTCONT")/10000)*Cursor_qbe_kpeuif.GetDouble("PROQUOTA");
            } // End If
            /* mcExt.OPERAZIONI := _operaz */
            mcExt.row.OPERAZIONI = _operaz;
            /* mcExt.CONTANTI := _ocont */
            mcExt.row.CONTANTI = _ocont;
            /* mcExt.SaveRow() */
            mcExt.SaveRow();
          } else { // Else
            /* mcIta.AppendBlank() */
            mcIta.AppendBlank();
            /* mcIta.CODINTDIP := _coddip */
            mcIta.row.CODINTDIP = _coddip;
            /* mcIta.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
            mcIta.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
            /* mcIta.CODCABDIP := _cabdip */
            mcIta.row.CODCABDIP = _cabdip;
            /* mcIta.PERPAESE := _paesecli */
            mcIta.row.PERPAESE = _paesecli;
            /* mcIta.PERCAB := _cabcli */
            mcIta.row.PERCAB = _cabcli;
            /* mcIta.CODVOC := qbe_kpeuif->CODVOC */
            mcIta.row.CODVOC = Cursor_qbe_kpeuif.GetString("CODVOC");
            /* mcIta.FLAGLIRE := qbe_kpeuif->FLAGLIRE */
            mcIta.row.FLAGLIRE = Cursor_qbe_kpeuif.GetString("FLAGLIRE");
            /* mcIta.SEGNO := qbe_kpeuif->SEGNO */
            mcIta.row.SEGNO = Cursor_qbe_kpeuif.GetString("SEGNO");
            /* mcIta.SETTSINT := _settsint */
            mcIta.row.SETTSINT = _settsint;
            /* mcIta.PAESECP := _paesecp */
            mcIta.row.PAESECP = _paesecp;
            /* mcIta.CODCABCP := _cabcp */
            mcIta.row.CODCABCP = _cabcp;
            /* mcIta.PAESEICP := iif(Empty(_paeseicp),_paesecp,_paeseicp) */
            mcIta.row.PAESEICP = (CPLib.Empty(_paeseicp)?_paesecp:_paeseicp);
            /* mcIta.CABICP := iif(Empty(_paeseicp) and _paesecp='086',_cabcp,_cabicp) */
            mcIta.row.CABICP = (CPLib.Empty(_paeseicp) && CPLib.eqr(_paesecp,"086")?_cabcp:_cabicp);
            /* If _pqtotale=0 */
            if (CPLib.eqr(_pqtotale,0)) {
              /* mcIta.TOTLIRE := qbe_kpeuif->TOTLIRE / (_conta * 100) */
              mcIta.row.TOTLIRE = Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/(_conta*100);
              /* mcIta.TOTCONT := qbe_kpeuif->TOTCONT / (_conta * 100) */
              mcIta.row.TOTCONT = Cursor_qbe_kpeuif.GetDouble("TOTCONT")/(_conta*100);
            } else { // Else
              /* mcIta.TOTLIRE := (qbe_kpeuif->TOTLIRE / 10000) * qbe_kpeuif->PROQUOTA */
              mcIta.row.TOTLIRE = (Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/10000)*Cursor_qbe_kpeuif.GetDouble("PROQUOTA");
              /* mcIta.TOTCONT := (qbe_kpeuif->TOTCONT / 10000)  * qbe_kpeuif->PROQUOTA */
              mcIta.row.TOTCONT = (Cursor_qbe_kpeuif.GetDouble("TOTCONT")/10000)*Cursor_qbe_kpeuif.GetDouble("PROQUOTA");
            } // End If
            /* mcIta.OPERAZIONI := _operaz */
            mcIta.row.OPERAZIONI = _operaz;
            /* mcIta.CONTANTI := _ocont */
            mcIta.row.CONTANTI = _ocont;
            /* mcIta.SaveRow() */
            mcIta.SaveRow();
          } // End If
        } else { // Else
          /* _paesecp := '' */
          _paesecp = "";
          /* _cabcp := '' */
          _cabcp = "";
          /* _paeseicp := '' */
          _paeseicp = "";
          /* _cabicp := '' */
          _cabicp = "";
          /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_coddip)+iif(Empty(LRTrim(_abicab)),'000000000000',LRTrim(_abicab))+LRTrim(_cabdip)+LRTrim(_paesecli)+LRTrim(_cabcli)+LRTrim(qbe_kpeuif->CODVOC)+LRTrim(qbe_kpeuif->FLAGLIRE) */
          _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_coddip)+(CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":CPLib.LRTrim(_abicab))+CPLib.LRTrim(_cabdip)+CPLib.LRTrim(_paesecli)+CPLib.LRTrim(_cabcli)+CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("CODVOC"))+CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("FLAGLIRE"));
          /* _chiave := _chiave + LRTrim(qbe_kpeuif->SEGNO) + LRTrim(_settsint)+LRTrim(_paesecp)+LRTrim(_cabcp)+LRTrim(_paeseicp)+LRTrim(_cabicp) */
          _chiave = _chiave+CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("SEGNO"))+CPLib.LRTrim(_settsint)+CPLib.LRTrim(_paesecp)+CPLib.LRTrim(_cabcp)+CPLib.LRTrim(_paeseicp)+CPLib.LRTrim(_cabicp);
          /* If not(mcStorico.GoToKey(_chiave)) */
          if ( ! (mcStorico.GoToKey(_chiave))) {
            /* _rifprog := _rifprog + 1 */
            _rifprog = CPLib.Round(_rifprog+1,0);
            /* _progrif := Right('0000000000'+LRTrim(Str(_rifprog,10,0)),10) */
            _progrif = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_rifprog,10,0)),10);
            /* mcStorico.AppendWithKey(_chiave) */
            mcStorico.AppendWithKey(_chiave);
            /* mcStorico.ANNORIF := _anno */
            mcStorico.row.ANNORIF = _anno;
            /* mcStorico.MESERIF := _month */
            mcStorico.row.MESERIF = _month;
            /* mcStorico.PROGRIF := _progrif */
            mcStorico.row.PROGRIF = _progrif;
            /* mcStorico.CODINTDIP := _coddip */
            mcStorico.row.CODINTDIP = _coddip;
            /* mcStorico.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
            mcStorico.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
            /* mcStorico.CODCABDIP := _cabdip */
            mcStorico.row.CODCABDIP = _cabdip;
            /* mcStorico.PERPAESE := _paesecli */
            mcStorico.row.PERPAESE = _paesecli;
            /* mcStorico.PERCAB := _cabcli */
            mcStorico.row.PERCAB = _cabcli;
            /* mcStorico.CODVOC := qbe_kpeuif->CODVOC */
            mcStorico.row.CODVOC = Cursor_qbe_kpeuif.GetString("CODVOC");
            /* mcStorico.FLAGLIRE := qbe_kpeuif->FLAGLIRE */
            mcStorico.row.FLAGLIRE = Cursor_qbe_kpeuif.GetString("FLAGLIRE");
            /* mcStorico.SEGNO := qbe_kpeuif->SEGNO */
            mcStorico.row.SEGNO = Cursor_qbe_kpeuif.GetString("SEGNO");
            /* mcStorico.SETTSINT := _settsint */
            mcStorico.row.SETTSINT = _settsint;
            /* mcStorico.PAESECP := _paesecp */
            mcStorico.row.PAESECP = _paesecp;
            /* mcStorico.CODCABCP := _cabcp */
            mcStorico.row.CODCABCP = _cabcp;
            /* mcStorico.PAESEICP := _paeseicp */
            mcStorico.row.PAESEICP = _paeseicp;
            /* mcStorico.CABICP := _cabicp */
            mcStorico.row.CABICP = _cabicp;
            /* mcStorico.SaveRow() */
            mcStorico.SaveRow();
          } // End If
          /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_progrif)+'O'+LRTrim(qbe_kpeuif->NUMPROG) */
          _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_progrif)+"O"+CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("NUMPROG"));
          /* mcStoricoDett.AppendWithKey(_chiave) */
          mcStoricoDett.AppendWithKey(_chiave);
          /* mcStoricoDett.ANNORIF := _anno */
          mcStoricoDett.row.ANNORIF = _anno;
          /* mcStoricoDett.MESERIF := _month */
          mcStoricoDett.row.MESERIF = _month;
          /* mcStoricoDett.PROGRIF := _progrif */
          mcStoricoDett.row.PROGRIF = _progrif;
          /* mcStoricoDett.TIPOPE := 'K' */
          mcStoricoDett.row.TIPOPE = "K";
          /* mcStoricoDett.NUMPROG := qbe_kpeuif->NUMPROG */
          mcStoricoDett.row.NUMPROG = Cursor_qbe_kpeuif.GetString("NUMPROG");
          /* mcStoricoDett.DATAOPE := qbe_kpeuif->DATAOPE */
          mcStoricoDett.row.DATAOPE = Cursor_qbe_kpeuif.GetDate("DATAOPE");
          /* mcStoricoDett.CODVOC := qbe_kpeuif->CODVOC */
          mcStoricoDett.row.CODVOC = Cursor_qbe_kpeuif.GetString("CODVOC");
          /* mcStoricoDett.FLAGLIRE := qbe_kpeuif->FLAGLIRE */
          mcStoricoDett.row.FLAGLIRE = Cursor_qbe_kpeuif.GetString("FLAGLIRE");
          /* mcStoricoDett.SEGNO := qbe_kpeuif->SEGNO */
          mcStoricoDett.row.SEGNO = Cursor_qbe_kpeuif.GetString("SEGNO");
          /* mcStoricoDett.TOTLIRE := _totimp */
          mcStoricoDett.row.TOTLIRE = _totimp;
          /* mcStoricoDett.TOTCONT := _totcon */
          mcStoricoDett.row.TOTCONT = _totcon;
          /* mcStoricoDett.CODINTDIP := _coddip */
          mcStoricoDett.row.CODINTDIP = _coddip;
          /* mcStoricoDett.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
          mcStoricoDett.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
          /* mcStoricoDett.CODCABDIP := _cabdip */
          mcStoricoDett.row.CODCABDIP = _cabdip;
          /* mcStoricoDett.RAPPORTO := qbe_kpeuif->RAPPORTO */
          mcStoricoDett.row.RAPPORTO = Cursor_qbe_kpeuif.GetString("RAPPORTO");
          /* mcStoricoDett.CONNESCLI := qbe_kpeuif->CONNESCLI */
          mcStoricoDett.row.CONNESCLI = Cursor_qbe_kpeuif.GetString("CONNESCLI");
          /* mcStoricoDett.PERPAESE := _paesecli */
          mcStoricoDett.row.PERPAESE = _paesecli;
          /* mcStoricoDett.PERCAB := _cabcli */
          mcStoricoDett.row.PERCAB = _cabcli;
          /* mcStoricoDett.SETTSINT := _settsint */
          mcStoricoDett.row.SETTSINT = _settsint;
          /* mcStoricoDett.CONNESBEN := qbe_kpeuif->CONNESBEN */
          mcStoricoDett.row.CONNESBEN = Cursor_qbe_kpeuif.GetString("CONNESBEN");
          /* mcStoricoDett.PAESECP := _paesecp */
          mcStoricoDett.row.PAESECP = _paesecp;
          /* mcStoricoDett.CODCABCP := _cabcp */
          mcStoricoDett.row.CODCABCP = _cabcp;
          /* mcStoricoDett.INTCONTRO := qbe_kpeuif->CODINT2 */
          mcStoricoDett.row.INTCONTRO = Cursor_qbe_kpeuif.GetString("CODINT2");
          /* mcStoricoDett.PAESEICP := _paeseicp */
          mcStoricoDett.row.PAESEICP = _paeseicp;
          /* mcStoricoDett.CABICP := _cabicp */
          mcStoricoDett.row.CABICP = _cabicp;
          /* mcStoricoDett.SaveRow() */
          mcStoricoDett.SaveRow();
          /* mcAlt.AppendBlank() */
          mcAlt.AppendBlank();
          /* mcAlt.CODINTDIP := _coddip */
          mcAlt.row.CODINTDIP = _coddip;
          /* mcAlt.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
          mcAlt.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
          /* mcAlt.CODCABDIP := _cabdip */
          mcAlt.row.CODCABDIP = _cabdip;
          /* mcAlt.PERPAESE := _paesecli */
          mcAlt.row.PERPAESE = _paesecli;
          /* mcAlt.PERCAB := _cabcli */
          mcAlt.row.PERCAB = _cabcli;
          /* mcAlt.CODVOC := qbe_kpeuif->CODVOC */
          mcAlt.row.CODVOC = Cursor_qbe_kpeuif.GetString("CODVOC");
          /* mcAlt.FLAGLIRE := qbe_kpeuif->FLAGLIRE */
          mcAlt.row.FLAGLIRE = Cursor_qbe_kpeuif.GetString("FLAGLIRE");
          /* mcAlt.SEGNO := qbe_kpeuif->SEGNO */
          mcAlt.row.SEGNO = Cursor_qbe_kpeuif.GetString("SEGNO");
          /* mcAlt.SETTSINT := _settsint */
          mcAlt.row.SETTSINT = _settsint;
          /* mcAlt.PAESECP := _paesecp */
          mcAlt.row.PAESECP = _paesecp;
          /* mcAlt.CODCABCP := _cabcp */
          mcAlt.row.CODCABCP = _cabcp;
          /* mcAlt.PAESEICP := _paeseicp */
          mcAlt.row.PAESEICP = _paeseicp;
          /* mcAlt.CABICP := iif(Empty(_paeseicp) and _paesecp='086',_cabcp,_cabicp) */
          mcAlt.row.CABICP = (CPLib.Empty(_paeseicp) && CPLib.eqr(_paesecp,"086")?_cabcp:_cabicp);
          /* If _pqtotale=0 */
          if (CPLib.eqr(_pqtotale,0)) {
            /* mcAlt.TOTLIRE := qbe_kpeuif->TOTLIRE / (_conta * 100) */
            mcAlt.row.TOTLIRE = Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/(_conta*100);
            /* mcAlt.TOTCONT := qbe_kpeuif->TOTCONT / (_conta * 100) */
            mcAlt.row.TOTCONT = Cursor_qbe_kpeuif.GetDouble("TOTCONT")/(_conta*100);
          } else { // Else
            /* mcAlt.TOTLIRE := (qbe_kpeuif->TOTLIRE / 10000) * qbe_kpeuif->PROQUOTA */
            mcAlt.row.TOTLIRE = (Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/10000)*Cursor_qbe_kpeuif.GetDouble("PROQUOTA");
            /* mcAlt.TOTCONT := (qbe_kpeuif->TOTCONT / 10000)  * qbe_kpeuif->PROQUOTA */
            mcAlt.row.TOTCONT = (Cursor_qbe_kpeuif.GetDouble("TOTCONT")/10000)*Cursor_qbe_kpeuif.GetDouble("PROQUOTA");
          } // End If
          /* mcAlt.OPERAZIONI := _operaz */
          mcAlt.row.OPERAZIONI = _operaz;
          /* mcAlt.CONTANTI := _ocont */
          mcAlt.row.CONTANTI = _ocont;
          /* mcAlt.SaveRow() */
          mcAlt.SaveRow();
        } // End If
        /* If _conta > 1 */
        if (CPLib.gt(_conta,1)) {
          // * --- Select from clientisara
          m_cServer = m_Ctx.GetServer("clientisara");
          m_cPhName = m_Ctx.GetPhName("clientisara");
          if (Cursor_clientisara!=null)
            Cursor_clientisara.Close();
          Cursor_clientisara = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDBASE"),"?",0,0)+"  and  CODSOG <> "+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientisara")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_clientisara.Eof())) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientisara.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* rowPers := arfn_datisog_sol_row(personbo->CONNES,qbe_kpeuif->DATAREG,qbe_kpeuif->STATOREG,qbe_kpeuif->DATARETT) */
              rowPers = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("CONNES"),Cursor_qbe_kpeuif.GetDate("DATAREG"),Cursor_qbe_kpeuif.GetString("STATOREG"),Cursor_qbe_kpeuif.GetDate("DATARETT"));
              /* _paesecli := personbo->PAESE */
              _paesecli = Cursor_personbo.GetString("PAESE");
              /* If _paesecli='086' */
              if (CPLib.eqr(_paesecli,"086")) {
                /* _cabcli := iif(not(Empty(personbo->CODCAB)),personbo->CODCAB,qbe_kpeuif->CODCAB2) */
                _cabcli = ( ! (CPLib.Empty(Cursor_personbo.GetString("CODCAB")))?Cursor_personbo.GetString("CODCAB"):Cursor_qbe_kpeuif.GetString("CODCAB2"));
              } else { // Else
                /* _cabcli := '' */
                _cabcli = "";
              } // End If
              /* _settsint := iif(Empty(personbo->SETTSINT),'999',rowPers.SETSINT) */
              _settsint = (CPLib.Empty(Cursor_personbo.GetString("SETTSINT"))?"999":rowPers.SETSINT);
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            /* If At(LRTrim(qbe_kpeuif->CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
            if (CPLib.gt(CPLib.At(CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("CODVOC")),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
              /* _paesecp := qbe_kpeuif->C_STA */
              _paesecp = Cursor_qbe_kpeuif.GetString("C_STA");
              /* If _autoic='S' */
              if (CPLib.eqr(_autoic,"S")) {
                /* _cabcp := iif(_paesecp <>'086','',LRTrim(qbe_kpeuif->C_CAB)) */
                _cabcp = (CPLib.ne(_paesecp,"086")?"":CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("C_CAB")));
                /* If Empty(qbe_kpeuif->PAESE) */
                if (CPLib.Empty(Cursor_qbe_kpeuif.GetString("PAESE"))) {
                  /* _paeseicp := _paesecp */
                  _paeseicp = _paesecp;
                } else { // Else
                  /* _paeseicp := LRTrim(qbe_kpeuif->PAESE) */
                  _paeseicp = CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("PAESE"));
                } // End If
                /* Case Empty(qbe_kpeuif->CODCAB2) and _paeseicp='086' */
                if (CPLib.Empty(Cursor_qbe_kpeuif.GetString("CODCAB2")) && CPLib.eqr(_paeseicp,"086")) {
                  /* If _paesecp='086' */
                  if (CPLib.eqr(_paesecp,"086")) {
                    /* _cabicp := _cabcp */
                    _cabicp = _cabcp;
                  } else { // Else
                    /* _cabicp := '' */
                    _cabicp = "";
                  } // End If
                  /* Case Empty(qbe_kpeuif->CODCAB2) and _paeseicp<>'086' and not(Empty(_paeseicp)) */
                } else if (CPLib.Empty(Cursor_qbe_kpeuif.GetString("CODCAB2")) && CPLib.ne(_paeseicp,"086") &&  ! (CPLib.Empty(_paeseicp))) {
                  /* _cabicp := '' */
                  _cabicp = "";
                  /* Case not(Empty(qbe_kpeuif->CODCAB2)) and _paeseicp = '086' */
                } else if ( ! (CPLib.Empty(Cursor_qbe_kpeuif.GetString("CODCAB2"))) && CPLib.eqr(_paeseicp,"086")) {
                  /* _cabicp := qbe_kpeuif->CODCAB2 */
                  _cabicp = Cursor_qbe_kpeuif.GetString("CODCAB2");
                } // End Case
              } else { // Else
                /* _cabcp := LRTrim(qbe_kpeuif->C_CAB) */
                _cabcp = CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("C_CAB"));
                /* _paeseicp := LRTrim(qbe_kpeuif->PAESE) */
                _paeseicp = CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("PAESE"));
                /* _cabicp := LRTrim(qbe_kpeuif->CODCAB2) */
                _cabicp = CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("CODCAB2"));
              } // End If
              /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_progrif)+'O'+LRTrim(qbe_kpeuif->NUMPROG) */
              _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_progrif)+"O"+CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("NUMPROG"));
              /* mcStoricoDett.AppendWithKey(_chiave) */
              mcStoricoDett.AppendWithKey(_chiave);
              /* mcStoricoDett.ANNORIF := _anno */
              mcStoricoDett.row.ANNORIF = _anno;
              /* mcStoricoDett.MESERIF := _month */
              mcStoricoDett.row.MESERIF = _month;
              /* mcStoricoDett.PROGRIF := _progrif */
              mcStoricoDett.row.PROGRIF = _progrif;
              /* mcStoricoDett.TIPOPE := 'K' */
              mcStoricoDett.row.TIPOPE = "K";
              /* mcStoricoDett.NUMPROG := qbe_kpeuif->NUMPROG */
              mcStoricoDett.row.NUMPROG = Cursor_qbe_kpeuif.GetString("NUMPROG");
              /* mcStoricoDett.DATAOPE := qbe_kpeuif->DATAOPE */
              mcStoricoDett.row.DATAOPE = Cursor_qbe_kpeuif.GetDate("DATAOPE");
              /* mcStoricoDett.CODVOC := qbe_kpeuif->CODVOC */
              mcStoricoDett.row.CODVOC = Cursor_qbe_kpeuif.GetString("CODVOC");
              /* mcStoricoDett.FLAGLIRE := qbe_kpeuif->FLAGLIRE */
              mcStoricoDett.row.FLAGLIRE = Cursor_qbe_kpeuif.GetString("FLAGLIRE");
              /* mcStoricoDett.SEGNO := qbe_kpeuif->SEGNO */
              mcStoricoDett.row.SEGNO = Cursor_qbe_kpeuif.GetString("SEGNO");
              /* mcStoricoDett.TOTLIRE := _totimp */
              mcStoricoDett.row.TOTLIRE = _totimp;
              /* mcStoricoDett.TOTCONT := _totcon */
              mcStoricoDett.row.TOTCONT = _totcon;
              /* mcStoricoDett.CODINTDIP := _coddip */
              mcStoricoDett.row.CODINTDIP = _coddip;
              /* mcStoricoDett.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
              mcStoricoDett.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
              /* mcStoricoDett.CODCABDIP := _cabdip */
              mcStoricoDett.row.CODCABDIP = _cabdip;
              /* mcStoricoDett.RAPPORTO := qbe_kpeuif->RAPPORTO */
              mcStoricoDett.row.RAPPORTO = Cursor_qbe_kpeuif.GetString("RAPPORTO");
              /* mcStoricoDett.CONNESCLI := clientisara->CODSOG */
              mcStoricoDett.row.CONNESCLI = Cursor_clientisara.GetString("CODSOG");
              /* mcStoricoDett.PERPAESE := _paesecli */
              mcStoricoDett.row.PERPAESE = _paesecli;
              /* mcStoricoDett.PERCAB := _cabcli */
              mcStoricoDett.row.PERCAB = _cabcli;
              /* mcStoricoDett.SETTSINT := _settsint */
              mcStoricoDett.row.SETTSINT = _settsint;
              /* mcStoricoDett.CONNESBEN := qbe_kpeuif->CONNESBEN */
              mcStoricoDett.row.CONNESBEN = Cursor_qbe_kpeuif.GetString("CONNESBEN");
              /* mcStoricoDett.PAESECP := _paesecp */
              mcStoricoDett.row.PAESECP = _paesecp;
              /* mcStoricoDett.CODCABCP := _cabcp */
              mcStoricoDett.row.CODCABCP = _cabcp;
              /* mcStoricoDett.INTCONTRO := qbe_kpeuif->CODINT2 */
              mcStoricoDett.row.INTCONTRO = Cursor_qbe_kpeuif.GetString("CODINT2");
              /* mcStoricoDett.PAESEICP := _paeseicp */
              mcStoricoDett.row.PAESEICP = _paeseicp;
              /* mcStoricoDett.CABICP := _cabicp */
              mcStoricoDett.row.CABICP = _cabicp;
              /* mcStoricoDett.SaveRow() */
              mcStoricoDett.SaveRow();
              /* If _paeseicp <> '086' */
              if (CPLib.ne(_paeseicp,"086")) {
                /* mcExt.AppendBlank() */
                mcExt.AppendBlank();
                /* mcExt.CODINTDIP := _coddip */
                mcExt.row.CODINTDIP = _coddip;
                /* mcExt.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                mcExt.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                /* mcExt.CODCABDIP := _cabdip */
                mcExt.row.CODCABDIP = _cabdip;
                /* mcExt.PERPAESE := _paesecli */
                mcExt.row.PERPAESE = _paesecli;
                /* mcExt.PERCAB := _cabcli */
                mcExt.row.PERCAB = _cabcli;
                /* mcExt.CODVOC := qbe_kpeuif->CODVOC */
                mcExt.row.CODVOC = Cursor_qbe_kpeuif.GetString("CODVOC");
                /* mcExt.FLAGLIRE := qbe_kpeuif->FLAGLIRE */
                mcExt.row.FLAGLIRE = Cursor_qbe_kpeuif.GetString("FLAGLIRE");
                /* mcExt.SEGNO := qbe_kpeuif->SEGNO */
                mcExt.row.SEGNO = Cursor_qbe_kpeuif.GetString("SEGNO");
                /* mcExt.SETTSINT := _settsint */
                mcExt.row.SETTSINT = _settsint;
                /* mcExt.PAESECP := _paesecp */
                mcExt.row.PAESECP = _paesecp;
                /* mcExt.CODCABCP := _cabcp */
                mcExt.row.CODCABCP = _cabcp;
                /* mcExt.PAESEICP := iif(Empty(_paeseicp),_paesecp,_paeseicp) */
                mcExt.row.PAESEICP = (CPLib.Empty(_paeseicp)?_paesecp:_paeseicp);
                /* mcExt.CABICP := iif(Empty(_paeseicp) and _paesecp='086',_cabcp,_cabicp) */
                mcExt.row.CABICP = (CPLib.Empty(_paeseicp) && CPLib.eqr(_paesecp,"086")?_cabcp:_cabicp);
                /* If _pqtotale=0 */
                if (CPLib.eqr(_pqtotale,0)) {
                  /* mcExt.TOTLIRE := qbe_kpeuif->TOTLIRE / (_conta * 100) */
                  mcExt.row.TOTLIRE = Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/(_conta*100);
                  /* mcExt.TOTCONT := qbe_kpeuif->TOTCONT / (_conta * 100) */
                  mcExt.row.TOTCONT = Cursor_qbe_kpeuif.GetDouble("TOTCONT")/(_conta*100);
                } else { // Else
                  /* mcExt.TOTLIRE := (qbe_kpeuif->TOTLIRE / 10000) * clientisara->PROQUOTA */
                  mcExt.row.TOTLIRE = (Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/10000)*Cursor_clientisara.GetDouble("PROQUOTA");
                  /* mcExt.TOTCONT := (qbe_kpeuif->TOTCONT / 10000)  * clientisara->PROQUOTA */
                  mcExt.row.TOTCONT = (Cursor_qbe_kpeuif.GetDouble("TOTCONT")/10000)*Cursor_clientisara.GetDouble("PROQUOTA");
                } // End If
                /* mcExt.OPERAZIONI := _operaz */
                mcExt.row.OPERAZIONI = _operaz;
                /* mcExt.CONTANTI := _ocont */
                mcExt.row.CONTANTI = _ocont;
                /* mcExt.SaveRow() */
                mcExt.SaveRow();
              } else { // Else
                /* mcIta.AppendBlank() */
                mcIta.AppendBlank();
                /* mcIta.CODINTDIP := _coddip */
                mcIta.row.CODINTDIP = _coddip;
                /* mcIta.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
                mcIta.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
                /* mcIta.CODCABDIP := _cabdip */
                mcIta.row.CODCABDIP = _cabdip;
                /* mcIta.PERPAESE := _paesecli */
                mcIta.row.PERPAESE = _paesecli;
                /* mcIta.PERCAB := _cabcli */
                mcIta.row.PERCAB = _cabcli;
                /* mcIta.CODVOC := qbe_kpeuif->CODVOC */
                mcIta.row.CODVOC = Cursor_qbe_kpeuif.GetString("CODVOC");
                /* mcIta.FLAGLIRE := qbe_kpeuif->FLAGLIRE */
                mcIta.row.FLAGLIRE = Cursor_qbe_kpeuif.GetString("FLAGLIRE");
                /* mcIta.SEGNO := qbe_kpeuif->SEGNO */
                mcIta.row.SEGNO = Cursor_qbe_kpeuif.GetString("SEGNO");
                /* mcIta.SETTSINT := _settsint */
                mcIta.row.SETTSINT = _settsint;
                /* mcIta.PAESECP := _paesecp */
                mcIta.row.PAESECP = _paesecp;
                /* mcIta.CODCABCP := _cabcp */
                mcIta.row.CODCABCP = _cabcp;
                /* mcIta.PAESEICP := iif(Empty(_paeseicp),_paesecp,_paeseicp) */
                mcIta.row.PAESEICP = (CPLib.Empty(_paeseicp)?_paesecp:_paeseicp);
                /* mcIta.CABICP := iif(Empty(_paeseicp) and _paesecp='086',_cabcp,_cabicp) */
                mcIta.row.CABICP = (CPLib.Empty(_paeseicp) && CPLib.eqr(_paesecp,"086")?_cabcp:_cabicp);
                /* If _pqtotale=0 */
                if (CPLib.eqr(_pqtotale,0)) {
                  /* mcIta.TOTLIRE := qbe_kpeuif->TOTLIRE / (_conta * 100) */
                  mcIta.row.TOTLIRE = Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/(_conta*100);
                  /* mcIta.TOTCONT := qbe_kpeuif->TOTCONT / (_conta * 100) */
                  mcIta.row.TOTCONT = Cursor_qbe_kpeuif.GetDouble("TOTCONT")/(_conta*100);
                } else { // Else
                  /* mcIta.TOTLIRE := (qbe_kpeuif->TOTLIRE / 10000) * clientisara->PROQUOTA */
                  mcIta.row.TOTLIRE = (Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/10000)*Cursor_clientisara.GetDouble("PROQUOTA");
                  /* mcIta.TOTCONT := (qbe_kpeuif->TOTCONT / 10000)  * clientisara->PROQUOTA */
                  mcIta.row.TOTCONT = (Cursor_qbe_kpeuif.GetDouble("TOTCONT")/10000)*Cursor_clientisara.GetDouble("PROQUOTA");
                } // End If
                /* mcIta.OPERAZIONI := _operaz */
                mcIta.row.OPERAZIONI = _operaz;
                /* mcIta.CONTANTI := _ocont */
                mcIta.row.CONTANTI = _ocont;
                /* mcIta.SaveRow() */
                mcIta.SaveRow();
              } // End If
            } else { // Else
              /* _paesecp := '' */
              _paesecp = "";
              /* _cabcp := '' */
              _cabcp = "";
              /* _paeseicp := '' */
              _paeseicp = "";
              /* _cabicp := '' */
              _cabicp = "";
              /* _chiave := LRTrim(_anno)+LRTrim(_month)+LRTrim(_progrif)+'O'+LRTrim(qbe_kpeuif->NUMPROG) */
              _chiave = CPLib.LRTrim(_anno)+CPLib.LRTrim(_month)+CPLib.LRTrim(_progrif)+"O"+CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("NUMPROG"));
              /* mcStoricoDett.AppendWithKey(_chiave) */
              mcStoricoDett.AppendWithKey(_chiave);
              /* mcStoricoDett.ANNORIF := _anno */
              mcStoricoDett.row.ANNORIF = _anno;
              /* mcStoricoDett.MESERIF := _month */
              mcStoricoDett.row.MESERIF = _month;
              /* mcStoricoDett.PROGRIF := _progrif */
              mcStoricoDett.row.PROGRIF = _progrif;
              /* mcStoricoDett.TIPOPE := 'K' */
              mcStoricoDett.row.TIPOPE = "K";
              /* mcStoricoDett.NUMPROG := qbe_kpeuif->NUMPROG */
              mcStoricoDett.row.NUMPROG = Cursor_qbe_kpeuif.GetString("NUMPROG");
              /* mcStoricoDett.DATAOPE := qbe_kpeuif->DATAOPE */
              mcStoricoDett.row.DATAOPE = Cursor_qbe_kpeuif.GetDate("DATAOPE");
              /* mcStoricoDett.CODVOC := qbe_kpeuif->CODVOC */
              mcStoricoDett.row.CODVOC = Cursor_qbe_kpeuif.GetString("CODVOC");
              /* mcStoricoDett.FLAGLIRE := qbe_kpeuif->FLAGLIRE */
              mcStoricoDett.row.FLAGLIRE = Cursor_qbe_kpeuif.GetString("FLAGLIRE");
              /* mcStoricoDett.SEGNO := qbe_kpeuif->SEGNO */
              mcStoricoDett.row.SEGNO = Cursor_qbe_kpeuif.GetString("SEGNO");
              /* mcStoricoDett.TOTLIRE := _totimp */
              mcStoricoDett.row.TOTLIRE = _totimp;
              /* mcStoricoDett.TOTCONT := _totcon */
              mcStoricoDett.row.TOTCONT = _totcon;
              /* mcStoricoDett.CODINTDIP := _coddip */
              mcStoricoDett.row.CODINTDIP = _coddip;
              /* mcStoricoDett.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
              mcStoricoDett.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
              /* mcStoricoDett.CODCABDIP := _cabdip */
              mcStoricoDett.row.CODCABDIP = _cabdip;
              /* mcStoricoDett.RAPPORTO := qbe_kpeuif->RAPPORTO */
              mcStoricoDett.row.RAPPORTO = Cursor_qbe_kpeuif.GetString("RAPPORTO");
              /* mcStoricoDett.CONNESCLI := clientisara->CODSOG */
              mcStoricoDett.row.CONNESCLI = Cursor_clientisara.GetString("CODSOG");
              /* mcStoricoDett.PERPAESE := _paesecli */
              mcStoricoDett.row.PERPAESE = _paesecli;
              /* mcStoricoDett.PERCAB := _cabcli */
              mcStoricoDett.row.PERCAB = _cabcli;
              /* mcStoricoDett.SETTSINT := _settsint */
              mcStoricoDett.row.SETTSINT = _settsint;
              /* mcStoricoDett.CONNESBEN := qbe_kpeuif->CONNESBEN */
              mcStoricoDett.row.CONNESBEN = Cursor_qbe_kpeuif.GetString("CONNESBEN");
              /* mcStoricoDett.PAESECP := _paesecp */
              mcStoricoDett.row.PAESECP = _paesecp;
              /* mcStoricoDett.CODCABCP := _cabcp */
              mcStoricoDett.row.CODCABCP = _cabcp;
              /* mcStoricoDett.INTCONTRO := qbe_kpeuif->CODINT2 */
              mcStoricoDett.row.INTCONTRO = Cursor_qbe_kpeuif.GetString("CODINT2");
              /* mcStoricoDett.PAESEICP := _paeseicp */
              mcStoricoDett.row.PAESEICP = _paeseicp;
              /* mcStoricoDett.CABICP := _cabicp */
              mcStoricoDett.row.CABICP = _cabicp;
              /* mcStoricoDett.SaveRow() */
              mcStoricoDett.SaveRow();
              /* mcAlt.AppendBlank() */
              mcAlt.AppendBlank();
              /* mcAlt.CODINTDIP := _coddip */
              mcAlt.row.CODINTDIP = _coddip;
              /* mcAlt.ABICABDIP := iif(Empty(LRTrim(_abicab)),'000000000000',_abicab) */
              mcAlt.row.ABICABDIP = (CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab);
              /* mcAlt.CODCABDIP := _cabdip */
              mcAlt.row.CODCABDIP = _cabdip;
              /* mcAlt.PERPAESE := _paesecli */
              mcAlt.row.PERPAESE = _paesecli;
              /* mcAlt.PERCAB := _cabcli */
              mcAlt.row.PERCAB = _cabcli;
              /* mcAlt.CODVOC := qbe_kpeuif->CODVOC */
              mcAlt.row.CODVOC = Cursor_qbe_kpeuif.GetString("CODVOC");
              /* mcAlt.FLAGLIRE := qbe_kpeuif->FLAGLIRE */
              mcAlt.row.FLAGLIRE = Cursor_qbe_kpeuif.GetString("FLAGLIRE");
              /* mcAlt.SEGNO := qbe_kpeuif->SEGNO */
              mcAlt.row.SEGNO = Cursor_qbe_kpeuif.GetString("SEGNO");
              /* mcAlt.SETTSINT := _settsint */
              mcAlt.row.SETTSINT = _settsint;
              /* mcAlt.PAESECP := _paesecp */
              mcAlt.row.PAESECP = _paesecp;
              /* mcAlt.CODCABCP := _cabcp */
              mcAlt.row.CODCABCP = _cabcp;
              /* mcAlt.PAESEICP := _paeseicp */
              mcAlt.row.PAESEICP = _paeseicp;
              /* mcAlt.CABICP := iif(Empty(_paeseicp) and _paesecp='086',_cabcp,_cabicp) */
              mcAlt.row.CABICP = (CPLib.Empty(_paeseicp) && CPLib.eqr(_paesecp,"086")?_cabcp:_cabicp);
              /* If _pqtotale=0 */
              if (CPLib.eqr(_pqtotale,0)) {
                /* mcAlt.TOTLIRE := qbe_kpeuif->TOTLIRE / (_conta * 100) */
                mcAlt.row.TOTLIRE = Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/(_conta*100);
                /* mcAlt.TOTCONT := qbe_kpeuif->TOTCONT / (_conta * 100) */
                mcAlt.row.TOTCONT = Cursor_qbe_kpeuif.GetDouble("TOTCONT")/(_conta*100);
              } else { // Else
                /* mcAlt.TOTLIRE := (qbe_kpeuif->TOTLIRE / 10000) * clientisara->PROQUOTA */
                mcAlt.row.TOTLIRE = (Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/10000)*Cursor_clientisara.GetDouble("PROQUOTA");
                /* mcAlt.TOTCONT := (qbe_kpeuif->TOTCONT / 10000)  * clientisara->PROQUOTA */
                mcAlt.row.TOTCONT = (Cursor_qbe_kpeuif.GetDouble("TOTCONT")/10000)*Cursor_clientisara.GetDouble("PROQUOTA");
              } // End If
              /* mcAlt.OPERAZIONI := _operaz */
              mcAlt.row.OPERAZIONI = _operaz;
              /* mcAlt.CONTANTI := _ocont */
              mcAlt.row.CONTANTI = _ocont;
              /* mcAlt.SaveRow() */
              mcAlt.SaveRow();
            } // End If
            Cursor_clientisara.Next();
          }
          m_cConnectivityError = Cursor_clientisara.ErrorMessage();
          Cursor_clientisara.Close();
          // * --- End Select
        } // End If
        Cursor_qbe_kpeuif.Next();
      }
      m_cConnectivityError = Cursor_qbe_kpeuif.ErrorMessage();
      Cursor_qbe_kpeuif.Close();
      // * --- End Select
      /* If _cope=0 */
      if (CPLib.eqr(_cope,0)) {
        /* gMsgProc := gMsgProc + 'Non sono presenti dati da elaborare nel file Operazioni Società Quotate' + NL */
        gMsgProc = gMsgProc+"Non sono presenti dati da elaborare nel file Operazioni Società Quotate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(_cope,10,0))+' record del file Operazioni Società Quotate' + NL */
        gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_cope,10,0))+" record del file Operazioni Società Quotate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni Società Quotate' +NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni Società Quotate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_kpeuif!=null)
          Cursor_qbe_kpeuif.Close();
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
        if (Cursor_clientisara!=null)
          Cursor_clientisara.Close();
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
  void Page_7() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      for (MemoryCursorRow_storicoxbrl rwStorico : mcStorico._iterable_()) {
        /* gMsgImp := 'Aggiorno DB Storico: '+LRTrim(rwStorico.ANNORIF)+'-'+LRTrim(rwStorico.MESERIF)+'-'+LRTrim(rwStorico.PROGRIF) // Messaggio Import */
        gMsgImp = "Aggiorno DB Storico: "+CPLib.LRTrim(rwStorico.ANNORIF)+"-"+CPLib.LRTrim(rwStorico.MESERIF)+"-"+CPLib.LRTrim(rwStorico.PROGRIF);
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Insert into storicoxbrl from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("storicoxbrl");
        m_cPhName = m_Ctx.GetPhName("storicoxbrl");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"storicoxbrl",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_xbrl",277,"00000719")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000719(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.ANNORIF,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.MESERIF,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.PROGRIF,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.CODINTDIP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.ABICABDIP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.CODCABDIP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.PERPAESE,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.PERCAB,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.CODVOC,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.FLAGLIRE,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.SEGNO,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.SETTSINT,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.PAESECP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.CODCABCP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.PAESEICP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.CABICP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.TOTLIRE,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.TOTCONT,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.OPERAZIONI,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwStorico.CONTANTI,"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"storicoxbrl",true);
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
      }
      for (MemoryCursorRow_storicoxbrl_dett rwDettaglio : mcStoricoDett._iterable_()) {
        /* gMsgImp := 'Aggiorno DB Storico: '+LRTrim(rwDettaglio.ANNORIF)+'-'+LRTrim(rwDettaglio.MESERIF)+'-'+LRTrim(rwDettaglio.PROGRIF)+'-'+LRTrim(rwDettaglio.TIPOPE)+'-'+LRTrim(rwDettaglio.NUMPROG) // Messaggio Import */
        gMsgImp = "Aggiorno DB Storico: "+CPLib.LRTrim(rwDettaglio.ANNORIF)+"-"+CPLib.LRTrim(rwDettaglio.MESERIF)+"-"+CPLib.LRTrim(rwDettaglio.PROGRIF)+"-"+CPLib.LRTrim(rwDettaglio.TIPOPE)+"-"+CPLib.LRTrim(rwDettaglio.NUMPROG);
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Insert into storicoxbrl_dett from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("storicoxbrl_dett");
        m_cPhName = m_Ctx.GetPhName("storicoxbrl_dett");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"storicoxbrl_dett",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_xbrl",277,"0000071C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000071C(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.ANNORIF,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.MESERIF,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.PROGRIF,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.TIPOPE,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.NUMPROG,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.DATAOPE,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.CODVOC,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.FLAGLIRE,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.SEGNO,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.TOTLIRE,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.TOTCONT,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.CODINTDIP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.ABICABDIP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.CODCABDIP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.RAPPORTO,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.CONNESCLI,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.PERPAESE,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.PERCAB,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.SETTSINT,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.CONNESBEN,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.PAESECP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.CODCABCP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.INTCONTRO,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.PAESEICP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.CABICP,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"storicoxbrl_dett",true);
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
      }
      /* _idf := '' */
      _idf = "";
      // * --- Read from filedatiuic
      m_cServer = m_Ctx.GetServer("filedatiuic");
      m_cPhName = m_Ctx.GetPhName("filedatiuic");
      m_cSql = "";
      m_cSql = m_cSql+"nomefile="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_file)+"_"+CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(w_numinv,5,0)),5)+".zip","C",30,0,m_cServer),m_cServer,CPLib.LRTrim(_file)+"_"+CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(w_numinv,5,0)),5)+".zip");
      m_cSql = m_cSql+" and datafile="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Date(),"D",8,0,m_cServer),m_cServer,CPLib.Date());
      if (m_Ctx.IsSharedTemp("filedatiuic")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("idfile",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _idf = Read_Cursor.GetString("idfile");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on filedatiuic into routine arrt_discouic_xbrl returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _idf = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If Empty(_idf) */
      if (CPLib.Empty(_idf)) {
        /* cProg := Utilities.GetAutonumber("PRGFILEUIC\'"+LRTrim(gAzienda)+"'",'',10) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILEUIC\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        // * --- Insert into filedatiuic from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("filedatiuic");
        m_cPhName = m_Ctx.GetPhName("filedatiuic");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"filedatiuic",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_xbrl",277,"00000722")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000722(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_file)+"_"+CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(w_numinv,5,0)),5)+".zip","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Dati Aggregati relativi al periodo: "+arfn_fdateR.Make(m_Ctx,this).Run(w_DaDatOpe)+" - "+arfn_fdateR.Make(m_Ctx,this).Run(w_ADatOpe)+" - Invio N. "+CPLib.LRTrim(CPLib.Str(w_numinv,3,0)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"filedatiuic",true);
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
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,String p_w_tipocr,String p_w_codcr,java.sql.Date p_w_datinv,double p_w_numinv,String p_w_flgfrazionate,String p_w_storico) {
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_tipocr = p_w_tipocr;
    w_codcr = p_w_codcr;
    w_datinv = p_w_datinv;
    w_numinv = p_w_numinv;
    w_flgfrazionate = p_w_flgfrazionate;
    w_storico = p_w_storico;
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
  public double Run(java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,String p_w_tipocr,String p_w_codcr,java.sql.Date p_w_datinv,double p_w_numinv,String p_w_flgfrazionate,String p_w_storico) {
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_tipocr = p_w_tipocr;
    w_codcr = p_w_codcr;
    w_datinv = p_w_datinv;
    w_numinv = p_w_numinv;
    w_flgfrazionate = p_w_flgfrazionate;
    w_storico = p_w_storico;
    return Run();
  }
  public double Run() {
    double l_result;
    l_result = 0;
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
        l_result = stop_value.GetNumber();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = 0;
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
  public static arrt_discouic_xbrlR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_discouic_xbrlR(p_Ctx, p_Caller);
  }
  public static arrt_discouic_xbrlR Make(CPContext p_Ctx) {
    return new arrt_discouic_xbrlR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_DaDatOpe = CPLib.NullDate();
    w_ADatOpe = CPLib.NullDate();
    w_tipocr = CPLib.Space(2);
    w_codcr = CPLib.Space(11);
    w_datinv = CPLib.NullDate();
    w_numinv = 0;
    w_flgfrazionate = CPLib.Space(1);
    w_storico = CPLib.Space(1);
    _tipcentro = CPLib.Space(2);
    _codcentro = CPLib.Space(11);
    _settsint = CPLib.Space(3);
    _appconta = 0;
    _totconta = 0;
    _conta = 0;
    _contaw = 0;
    _contaop = 0;
    _coddip = CPLib.Space(6);
    _dipbase = CPLib.Space(6);
    _dipcab = CPLib.Space(6);
    _abicab = CPLib.Space(12);
    _dipabicab = CPLib.Space(12);
    _cabdip = CPLib.Space(6);
    _paesecli = CPLib.Space(3);
    _cabcli = CPLib.Space(6);
    _paesecp = CPLib.Space(3);
    _cabcp = CPLib.Space(6);
    _paeseicp = CPLib.Space(3);
    _cabicp = CPLib.Space(6);
    _operaz = 0;
    _ocont = 0;
    _testo = "";
    _txtappo = "";
    _file = CPLib.Space(20);
    cdadata = CPLib.Space(8);
    c_adata = CPLib.Space(8);
    w_dadata = CPLib.NullDate();
    w_adata = CPLib.NullDate();
    _mesi = CPLib.Space(12);
    _mese = CPLib.Space(1);
    cNomeFile = CPLib.Space(30);
    cOnlyNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    cProg = CPLib.Space(10);
    fhand = CPLib.Space(10);
    _nita = 0;
    _next = 0;
    _nalt = 0;
    _datafine = CPLib.Space(10);
    _txttot = "";
    _tope = 0;
    _tcon = 0;
    _dataprod = CPLib.Space(10);
    _oraprod = CPLib.Space(8);
    _cDataOra = CPLib.Space(14);
    _totimp = 0;
    _totcon = 0;
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _cicli = 0;
    _contacilci = 0;
    _bottom = 0;
    _top = 0;
    _cabint = CPLib.Space(6);
    _ita1 = "";
    _ita2 = "";
    _ext1 = "";
    _ext2 = "";
    _alt1 = "";
    _alt2 = "";
    _idf = CPLib.Space(10);
    _anno = CPLib.Space(4);
    _month = CPLib.Space(2);
    _progrif = CPLib.Space(10);
    _rifprog = 0;
    _autoic = CPLib.Space(1);
    _pqtotale = 0;
    _nosara = 0;
    _sara = CPLib.Space(1);
    _datini = CPLib.Space(8);
    _datfin = CPLib.Space(8);
    _ddatini = CPLib.NullDate();
    _ddatfin = CPLib.NullDate();
    _dataoggi = CPLib.NullDate();
    _cdataoggi = CPLib.Space(8);
    _contarow = 0;
    _oldmsg = "";
    _clientiope = false;
    _clientifrz = false;
    _cope = 0;
    _chiave = CPLib.Space(128);
    mcTmp = new MemoryCursor_tmp_invio_xbrl();
    mcIta = new MemoryCursor_tmp_dischebo_xbrl_ita();
    mcExt = new MemoryCursor_tmp_dischebo_xbrl_ext();
    mcAlt = new MemoryCursor_tmp_dischebo_xbrl_alt();
    rowTmp = new MemoryCursorRow_tmp_invio_xbrl();
    mcTxt1 = new MemoryCursor_mctesto_mcrdef();
    mcTxt2 = new MemoryCursor_mctesto_mcrdef();
    rowPers = new MemoryCursorRow_mcsoggettiall1_mcrdef();
    mcOpeUif = new MemoryCursor_qbe_opeuif_vqr();
    mcFraUif = new MemoryCursor_qbe_frauif_vqr();
    mcStorico = new MemoryCursor_storicoxbrl();
    mcStoricoDett = new MemoryCursor_storicoxbrl_dett();
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gTipInter=m_Ctx.GetGlobalString("gTipInter");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tab_mmc,qbe_tab_mmc,qbe_opeuif,qbe_frauif,qbe_kpeuif,
  public static final String m_cVQRList = ",qbe_tab_mmc,qbe_tab_mmc,qbe_opeuif,qbe_frauif,qbe_kpeuif,";
  // ENTITY_BATCHES: ,arfn_datesum,arfn_datisog_sol_row,arfn_fdate,arfn_fdatetime,arrt_discouic_xbrl,
  public static final String i_InvokedRoutines = ",arfn_datesum,arfn_datisog_sol_row,arfn_fdate,arfn_fdatetime,arrt_discouic_xbrl,";
  public static String[] m_cRunParameterNames={"w_DaDatOpe","w_ADatOpe","w_tipocr","w_codcr","w_datinv","w_numinv","w_flgfrazionate","w_storico"};
  protected static String GetFieldsName_00000577(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"filedatiuic",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000719(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNORIF,";
    p_cSql = p_cSql+"MESERIF,";
    p_cSql = p_cSql+"PROGRIF,";
    p_cSql = p_cSql+"CODINTDIP,";
    p_cSql = p_cSql+"ABICABDIP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"CODCABCP,";
    p_cSql = p_cSql+"PAESEICP,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"OPERAZIONI,";
    p_cSql = p_cSql+"CONTANTI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"storicoxbrl",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000071C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNORIF,";
    p_cSql = p_cSql+"MESERIF,";
    p_cSql = p_cSql+"PROGRIF,";
    p_cSql = p_cSql+"TIPOPE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"CODINTDIP,";
    p_cSql = p_cSql+"ABICABDIP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"CODCABCP,";
    p_cSql = p_cSql+"INTCONTRO,";
    p_cSql = p_cSql+"PAESEICP,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"storicoxbrl_dett",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000722(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"filedatiuic",true);
    return p_cSql;
  }
}
