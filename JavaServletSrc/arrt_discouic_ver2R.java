// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_discouic_ver2R implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_filedatiuic;
  public String m_cServer_filedatiuic;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_xbrl_def;
  public String m_cServer_xbrl_def;
  public String m_cPhName_clientisara;
  public String m_cServer_clientisara;
  public String m_cPhName_storicoxbrl;
  public String m_cServer_storicoxbrl;
  public String m_cPhName_storicoxbrl_dett;
  public String m_cServer_storicoxbrl_dett;
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
  public String _abicab;
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
  public MemoryCursor_tmp_invio_xbrl mcTmp;
  public MemoryCursor_tmp_dischebo_xbrl_ita mcIta;
  public MemoryCursor_tmp_dischebo_xbrl_ext mcExt;
  public MemoryCursor_tmp_dischebo_xbrl_alt mcAlt;
  public MemoryCursorRow_tmp_invio_xbrl rowTmp;
  public String _ita1;
  public String _ita2;
  public String _ext1;
  public String _ext2;
  public String _alt1;
  public String _alt2;
  public MemoryCursor_mctesto_mcrdef mcTxt1;
  public MemoryCursor_mctesto_mcrdef mcTxt2;
  public String _sara;
  public double _nosara;
  public double _pqtotale;
  public String _datini;
  public String _datfin;
  public java.sql.Date _ddatini;
  public java.sql.Date _ddatfin;
  public java.sql.Date _dataoggi;
  public String _cdataoggi;
  public double _contarow;
  public String _oldmsg;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_discouic_ver2R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_discouic_ver2",m_Caller);
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
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
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_xbrl_def = p_ContextObject.GetPhName("xbrl_def");
    if (m_cPhName_xbrl_def.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xbrl_def = m_cPhName_xbrl_def+" "+m_Ctx.GetWritePhName("xbrl_def");
    }
    m_cServer_xbrl_def = p_ContextObject.GetServer("xbrl_def");
    m_cPhName_clientisara = p_ContextObject.GetPhName("clientisara");
    if (m_cPhName_clientisara.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientisara = m_cPhName_clientisara+" "+m_Ctx.GetWritePhName("clientisara");
    }
    m_cServer_clientisara = p_ContextObject.GetServer("clientisara");
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
    if (CPLib.eqr("_nosara",p_cVarName)) {
      return _nosara;
    }
    if (CPLib.eqr("_pqtotale",p_cVarName)) {
      return _pqtotale;
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
      return "arrt_discouic_ver2";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("tipocr",p_cVarName)) {
      return w_tipocr;
    }
    if (CPLib.eqr("codcr",p_cVarName)) {
      return w_codcr;
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
    if (CPLib.eqr("_abicab",p_cVarName)) {
      return _abicab;
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
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowTmp",p_cVarName)) {
      return rowTmp;
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
    if (CPLib.eqr("_nosara",p_cVarName)) {
      _nosara = value;
      return;
    }
    if (CPLib.eqr("_pqtotale",p_cVarName)) {
      _pqtotale = value;
      return;
    }
    if (CPLib.eqr("_contarow",p_cVarName)) {
      _contarow = value;
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
    if (CPLib.eqr("_abicab",p_cVarName)) {
      _abicab = value;
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
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowTmp",p_cVarName)) {
      rowTmp = (MemoryCursorRow_tmp_invio_xbrl)value;
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
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    try {
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_tipocr Char(2) */
      /* w_codcr Char(11) */
      /* w_datinv Date */
      /* w_numinv Numeric(10, 0) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(128) // Path Documenti */
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
      /* _abicab Char(12) */
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
      /* mcTmp MemoryCursor(tmp_invio_xbrl) */
      /* mcIta MemoryCursor(tmp_dischebo_xbrl_ita) */
      /* mcExt MemoryCursor(tmp_dischebo_xbrl_ext) */
      /* mcAlt MemoryCursor(tmp_dischebo_xbrl_alt) */
      /* rowTmp Row(tmp_invio_xbrl) */
      /* _ita1 Memo */
      /* _ita2 Memo */
      /* _ext1 Memo */
      /* _ext2 Memo */
      /* _alt1 Memo */
      /* _alt2 Memo */
      /* mcTxt1 MemoryCursor(mcTesto.MCRDef) */
      /* mcTxt2 MemoryCursor(mcTesto.MCRDef) */
      /* _sara Char(1) */
      /* _nosara Numeric(1, 0) */
      /* _pqtotale Numeric(3, 0) */
      /* _datini Char(8) */
      /* _datfin Char(8) */
      /* _ddatini Date */
      /* _ddatfin Date */
      /* _dataoggi Date */
      /* _cdataoggi Char(8) */
      /* _contarow Numeric(15, 0) */
      /* _oldmsg Memo */
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
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* Verifica le operazioni da trasportare */
      /* _contaop := 0 */
      _contaop = CPLib.Round(0,0);
      /* Exec "Operazioni" Page 2:Page_2 */
      Page_2();
      /* Exec "Operazioni Società Quotate" Page 6:Page_6 */
      Page_6();
      /* Exec "Frazionate" Page 3:Page_3 */
      Page_3();
      /* Exec "Creazione File per Invio" Page 4:Page_4 */
      Page_4();
      /* Exec "Creazione file zip" Page 5:Page_5 */
      Page_5();
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Elaborazione Terminata. Premere il tasto con la lente per prelevare il file' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata. Premere il tasto con la lente per prelevare il file";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_opeuif=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_clientiope=null;
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
        // * --- Select from qbe_opeuif
        SPBridge.HMCaller _h0000007F;
        _h0000007F = new SPBridge.HMCaller();
        _h0000007F.Set("m_cVQRList",m_cVQRList);
        _h0000007F.Set("cdadata",_cdataoggi);
        if (Cursor_qbe_opeuif!=null)
          Cursor_qbe_opeuif.Close();
        Cursor_qbe_opeuif = new VQRHolder("qbe_opeuif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000007F,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_opeuif.Eof())) {
          /* _nosara := 0 */
          _nosara = CPLib.Round(0,0);
          /* _sara := 'N' */
          _sara = "N";
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESCLI"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_opeuif.GetString("CONNESCLI"));
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
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_discouic_ver2 returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _sara = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _nosara := iif(_sara='N',0,1) */
          _nosara = CPLib.Round((CPLib.eqr(_sara,"N")?0:1),0);
          /* _pqtotale := qbe_opeuif->PROQUOTA */
          _pqtotale = CPLib.Round(Cursor_qbe_opeuif.GetDouble("PROQUOTA"),0);
          /* If _nosara=0 */
          if (CPLib.eqr(_nosara,0)) {
            // * --- Select from clientiope
            m_cServer = m_Ctx.GetServer("clientiope");
            m_cPhName = m_Ctx.GetPhName("clientiope");
            if (Cursor_clientiope!=null)
              Cursor_clientiope.Close();
            Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("IDBASE"),"?",0,0)+"  and  CODSOG <> "+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_discouic_ver2 returns two or more records. This item should return only a record.");
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
              /* _pqtotale := _pqtotale + clientiope->PROQUOTA */
              _pqtotale = CPLib.Round(_pqtotale+Cursor_clientiope.GetDouble("PROQUOTA"),0);
              Cursor_clientiope.Next();
            }
            m_cConnectivityError = Cursor_clientiope.ErrorMessage();
            Cursor_clientiope.Close();
            // * --- End Select
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* If _conta > 1 */
            if (CPLib.gt(_conta,1)) {
              /* _operaz := 1 / _conta */
              _operaz = CPLib.Round(1/_conta,2);
              /* _ocont := iif(qbe_opeuif->TOTCONT <> 0,1 / _conta,0) */
              _ocont = CPLib.Round((CPLib.ne(Cursor_qbe_opeuif.GetDouble("TOTCONT"),0)?1/_conta:0),2);
            } else { // Else
              /* _operaz := 1 */
              _operaz = CPLib.Round(1,2);
              /* _ocont := iif(qbe_opeuif->TOTCONT <> 0,1,0) */
              _ocont = CPLib.Round((CPLib.ne(Cursor_qbe_opeuif.GetDouble("TOTCONT"),0)?1:0),2);
            } // End If
          } // End If
          /* If _nosara=0 */
          if (CPLib.eqr(_nosara,0)) {
            /* _contaop := _contaop + 1 */
            _contaop = CPLib.Round(_contaop+1,0);
            /* gMsgImp := 'Elaboro Operazione N. '+ LRTrim(Str(_contaop,10,0)) // Messaggio Import */
            gMsgImp = "Elaboro Operazione N. "+CPLib.LRTrim(CPLib.Str(_contaop,10,0));
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
            /* If Empty(LRTrim(qbe_opeuif->CODDIPE)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_opeuif.GetString("CODDIPE")))) {
              /* _coddip := '000000' */
              _coddip = "000000";
              /* _cabdip := _cabint */
              _cabdip = _cabint;
            } else { // Else
              /* _coddip := LRTrim(qbe_opeuif->CODDIPE) */
              _coddip = CPLib.LRTrim(Cursor_qbe_opeuif.GetString("CODDIPE"));
              /* _cabdip := LRTrim(qbe_opeuif->CABDIP) */
              _cabdip = CPLib.LRTrim(Cursor_qbe_opeuif.GetString("CABDIP"));
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
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _cabdip = Read_Cursor.GetString("CAB");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_ver2 returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _cabdip = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
            } // End If
            /* _paesecli := qbe_opeuif->PAESECLI */
            _paesecli = Cursor_qbe_opeuif.GetString("PAESECLI");
            /* If _paesecli='086' */
            if (CPLib.eqr(_paesecli,"086")) {
              /* _cabcli := iif(not(Empty(qbe_opeuif->CABCLI)),qbe_opeuif->CABCLI,qbe_opeuif->CODCAB2) */
              _cabcli = ( ! (CPLib.Empty(Cursor_qbe_opeuif.GetString("CABCLI")))?Cursor_qbe_opeuif.GetString("CABCLI"):Cursor_qbe_opeuif.GetString("CODCAB2"));
            } else { // Else
              /* _cabcli := '' */
              _cabcli = "";
            } // End If
            /* _settsint := iif(Empty(qbe_opeuif->SETTSINT),'999',qbe_opeuif->SETTSINT) */
            _settsint = (CPLib.Empty(Cursor_qbe_opeuif.GetString("SETTSINT"))?"999":Cursor_qbe_opeuif.GetString("SETTSINT"));
            /* If At(LRTrim(qbe_opeuif->CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
            if (CPLib.gt(CPLib.At(CPLib.LRTrim(Cursor_qbe_opeuif.GetString("CODVOC")),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
              /* _paesecp := LRTrim(qbe_opeuif->C_STA) */
              _paesecp = CPLib.LRTrim(Cursor_qbe_opeuif.GetString("C_STA"));
              /* _cabcp := iif(_paesecp <>'086','',LRTrim(qbe_opeuif->C_CAB)) */
              _cabcp = (CPLib.ne(_paesecp,"086")?"":CPLib.LRTrim(Cursor_qbe_opeuif.GetString("C_CAB")));
              /* If Empty(qbe_opeuif->PAESE) */
              if (CPLib.Empty(Cursor_qbe_opeuif.GetString("PAESE"))) {
                /* _paeseicp := _paesecp */
                _paeseicp = _paesecp;
              } else { // Else
                /* _paeseicp := LRTrim(qbe_opeuif->PAESE) */
                _paeseicp = CPLib.LRTrim(Cursor_qbe_opeuif.GetString("PAESE"));
              } // End If
              /* Case Empty(qbe_opeuif->CODCAB2) and _paeseicp='086' */
              if (CPLib.Empty(Cursor_qbe_opeuif.GetString("CODCAB2")) && CPLib.eqr(_paeseicp,"086")) {
                /* If _paesecp='086' */
                if (CPLib.eqr(_paesecp,"086")) {
                  /* _cabicp := _cabcp */
                  _cabicp = _cabcp;
                } else { // Else
                  /* _cabicp := '' */
                  _cabicp = "";
                } // End If
                /* Case Empty(qbe_opeuif->CODCAB2) and _paeseicp<>'086' and not(Empty(_paeseicp)) */
              } else if (CPLib.Empty(Cursor_qbe_opeuif.GetString("CODCAB2")) && CPLib.ne(_paeseicp,"086") &&  ! (CPLib.Empty(_paeseicp))) {
                /* _cabicp := '' */
                _cabicp = "";
                /* Case not(Empty(qbe_opeuif->CODCAB2)) and _paeseicp = '086' */
              } else if ( ! (CPLib.Empty(Cursor_qbe_opeuif.GetString("CODCAB2"))) && CPLib.eqr(_paeseicp,"086")) {
                /* _cabicp := qbe_opeuif->CODCAB2 */
                _cabicp = Cursor_qbe_opeuif.GetString("CODCAB2");
              } // End Case
              /* If _paeseicp <> '086' */
              if (CPLib.ne(_paeseicp,"086")) {
                /* mcExt.AppendBlank() */
                mcExt.AppendBlank();
                /* mcExt.CODINTDIP := _coddip */
                mcExt.row.CODINTDIP = _coddip;
                /* mcExt.ABICABDIP := _abicab */
                mcExt.row.ABICABDIP = _abicab;
                /* mcExt.CODCABDIP := LRTrim(_cabdip) */
                mcExt.row.CODCABDIP = CPLib.LRTrim(_cabdip);
                /* mcExt.PERPAESE := _paesecli */
                mcExt.row.PERPAESE = _paesecli;
                /* mcExt.PERCAB := _cabcli */
                mcExt.row.PERCAB = _cabcli;
                /* mcExt.CODVOC := qbe_opeuif->CODVOC */
                mcExt.row.CODVOC = Cursor_qbe_opeuif.GetString("CODVOC");
                /* mcExt.FLAGLIRE := qbe_opeuif->FLAGLIRE */
                mcExt.row.FLAGLIRE = Cursor_qbe_opeuif.GetString("FLAGLIRE");
                /* mcExt.SEGNO := qbe_opeuif->SEGNO */
                mcExt.row.SEGNO = Cursor_qbe_opeuif.GetString("SEGNO");
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
                /* If _pqtotale=0 */
                if (CPLib.eqr(_pqtotale,0)) {
                  /* mcExt.TOTLIRE := qbe_opeuif->TOTLIRE / (_conta * 100) */
                  mcExt.row.TOTLIRE = Cursor_qbe_opeuif.GetDouble("TOTLIRE")/(_conta*100);
                  /* mcExt.TOTCONT := qbe_opeuif->TOTCONT / (_conta * 100) */
                  mcExt.row.TOTCONT = Cursor_qbe_opeuif.GetDouble("TOTCONT")/(_conta*100);
                } else { // Else
                  /* mcExt.TOTLIRE := (qbe_opeuif->TOTLIRE / 10000) * qbe_opeuif->PROQUOTA */
                  mcExt.row.TOTLIRE = (Cursor_qbe_opeuif.GetDouble("TOTLIRE")/10000)*Cursor_qbe_opeuif.GetDouble("PROQUOTA");
                  /* mcExt.TOTCONT := (qbe_opeuif->TOTCONT / 10000)  * qbe_opeuif->PROQUOTA */
                  mcExt.row.TOTCONT = (Cursor_qbe_opeuif.GetDouble("TOTCONT")/10000)*Cursor_qbe_opeuif.GetDouble("PROQUOTA");
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
                /* mcIta.ABICABDIP := _abicab */
                mcIta.row.ABICABDIP = _abicab;
                /* mcIta.CODCABDIP := LRTrim(_cabdip) */
                mcIta.row.CODCABDIP = CPLib.LRTrim(_cabdip);
                /* mcIta.PERPAESE := _paesecli */
                mcIta.row.PERPAESE = _paesecli;
                /* mcIta.PERCAB := _cabcli */
                mcIta.row.PERCAB = _cabcli;
                /* mcIta.CODVOC := qbe_opeuif->CODVOC */
                mcIta.row.CODVOC = Cursor_qbe_opeuif.GetString("CODVOC");
                /* mcIta.FLAGLIRE := qbe_opeuif->FLAGLIRE */
                mcIta.row.FLAGLIRE = Cursor_qbe_opeuif.GetString("FLAGLIRE");
                /* mcIta.SEGNO := qbe_opeuif->SEGNO */
                mcIta.row.SEGNO = Cursor_qbe_opeuif.GetString("SEGNO");
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
                /* If _pqtotale=0 */
                if (CPLib.eqr(_pqtotale,0)) {
                  /* mcIta.TOTLIRE := qbe_opeuif->TOTLIRE / (_conta * 100) */
                  mcIta.row.TOTLIRE = Cursor_qbe_opeuif.GetDouble("TOTLIRE")/(_conta*100);
                  /* mcIta.TOTCONT := qbe_opeuif->TOTCONT / (_conta * 100) */
                  mcIta.row.TOTCONT = Cursor_qbe_opeuif.GetDouble("TOTCONT")/(_conta*100);
                } else { // Else
                  /* mcIta.TOTLIRE := (qbe_opeuif->TOTLIRE / 10000) * qbe_opeuif->PROQUOTA */
                  mcIta.row.TOTLIRE = (Cursor_qbe_opeuif.GetDouble("TOTLIRE")/10000)*Cursor_qbe_opeuif.GetDouble("PROQUOTA");
                  /* mcIta.TOTCONT := (qbe_opeuif->TOTCONT / 10000)  * qbe_opeuif->PROQUOTA */
                  mcIta.row.TOTCONT = (Cursor_qbe_opeuif.GetDouble("TOTCONT")/10000)*Cursor_qbe_opeuif.GetDouble("PROQUOTA");
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
              /* mcAlt.AppendBlank() */
              mcAlt.AppendBlank();
              /* mcAlt.CODINTDIP := _coddip */
              mcAlt.row.CODINTDIP = _coddip;
              /* mcAlt.ABICABDIP := _abicab */
              mcAlt.row.ABICABDIP = _abicab;
              /* mcAlt.CODCABDIP := LRTrim(_cabdip) */
              mcAlt.row.CODCABDIP = CPLib.LRTrim(_cabdip);
              /* mcAlt.PERPAESE := _paesecli */
              mcAlt.row.PERPAESE = _paesecli;
              /* mcAlt.PERCAB := _cabcli */
              mcAlt.row.PERCAB = _cabcli;
              /* mcAlt.CODVOC := qbe_opeuif->CODVOC */
              mcAlt.row.CODVOC = Cursor_qbe_opeuif.GetString("CODVOC");
              /* mcAlt.FLAGLIRE := qbe_opeuif->FLAGLIRE */
              mcAlt.row.FLAGLIRE = Cursor_qbe_opeuif.GetString("FLAGLIRE");
              /* mcAlt.SEGNO := qbe_opeuif->SEGNO */
              mcAlt.row.SEGNO = Cursor_qbe_opeuif.GetString("SEGNO");
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
              /* If _pqtotale=0 */
              if (CPLib.eqr(_pqtotale,0)) {
                /* mcAlt.TOTLIRE := qbe_opeuif->TOTLIRE / (_conta * 100) */
                mcAlt.row.TOTLIRE = Cursor_qbe_opeuif.GetDouble("TOTLIRE")/(_conta*100);
                /* mcAlt.TOTCONT := qbe_opeuif->TOTCONT / (_conta * 100) */
                mcAlt.row.TOTCONT = Cursor_qbe_opeuif.GetDouble("TOTCONT")/(_conta*100);
              } else { // Else
                /* mcAlt.TOTLIRE := (qbe_opeuif->TOTLIRE / 10000) * qbe_opeuif->PROQUOTA */
                mcAlt.row.TOTLIRE = (Cursor_qbe_opeuif.GetDouble("TOTLIRE")/10000)*Cursor_qbe_opeuif.GetDouble("PROQUOTA");
                /* mcAlt.TOTCONT := (qbe_opeuif->TOTCONT / 10000)  * qbe_opeuif->PROQUOTA */
                mcAlt.row.TOTCONT = (Cursor_qbe_opeuif.GetDouble("TOTCONT")/10000)*Cursor_qbe_opeuif.GetDouble("PROQUOTA");
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
              // * --- Select from clientiope
              m_cServer = m_Ctx.GetServer("clientiope");
              m_cPhName = m_Ctx.GetPhName("clientiope");
              if (Cursor_clientiope!=null)
                Cursor_clientiope.Close();
              Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_clientiope.Eof())) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _paesecli := personbo->PAESE */
                  _paesecli = Cursor_personbo.GetString("PAESE");
                  /* If _paesecli='086' */
                  if (CPLib.eqr(_paesecli,"086")) {
                    /* _cabcli := iif(not(Empty(personbo->CODCAB)),personbo->CODCAB,qbe_opeuif->CODCAB2) */
                    _cabcli = ( ! (CPLib.Empty(Cursor_personbo.GetString("CODCAB")))?Cursor_personbo.GetString("CODCAB"):Cursor_qbe_opeuif.GetString("CODCAB2"));
                  } else { // Else
                    /* _cabcli := '' */
                    _cabcli = "";
                  } // End If
                  /* _settsint := iif(Empty(personbo->SETTSINT),'999',personbo->SETTSINT) */
                  _settsint = (CPLib.Empty(Cursor_personbo.GetString("SETTSINT"))?"999":Cursor_personbo.GetString("SETTSINT"));
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
                /* If At(LRTrim(qbe_opeuif->CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
                if (CPLib.gt(CPLib.At(CPLib.LRTrim(Cursor_qbe_opeuif.GetString("CODVOC")),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
                  /* _paesecp := LRTrim(qbe_opeuif->C_STA) */
                  _paesecp = CPLib.LRTrim(Cursor_qbe_opeuif.GetString("C_STA"));
                  /* _cabcp := iif(_paesecp <>'086','',LRTrim(qbe_opeuif->C_CAB)) */
                  _cabcp = (CPLib.ne(_paesecp,"086")?"":CPLib.LRTrim(Cursor_qbe_opeuif.GetString("C_CAB")));
                  /* If Empty(qbe_opeuif->PAESE) */
                  if (CPLib.Empty(Cursor_qbe_opeuif.GetString("PAESE"))) {
                    /* _paeseicp := _paesecp */
                    _paeseicp = _paesecp;
                  } else { // Else
                    /* _paeseicp := LRTrim(qbe_opeuif->PAESE) */
                    _paeseicp = CPLib.LRTrim(Cursor_qbe_opeuif.GetString("PAESE"));
                  } // End If
                  /* Case Empty(qbe_opeuif->CODCAB2) and _paeseicp='086' */
                  if (CPLib.Empty(Cursor_qbe_opeuif.GetString("CODCAB2")) && CPLib.eqr(_paeseicp,"086")) {
                    /* If _paesecp='086' */
                    if (CPLib.eqr(_paesecp,"086")) {
                      /* _cabicp := _cabcp */
                      _cabicp = _cabcp;
                    } else { // Else
                      /* _cabicp := '' */
                      _cabicp = "";
                    } // End If
                    /* Case Empty(qbe_opeuif->CODCAB2) and _paeseicp<>'086' and not(Empty(_paeseicp)) */
                  } else if (CPLib.Empty(Cursor_qbe_opeuif.GetString("CODCAB2")) && CPLib.ne(_paeseicp,"086") &&  ! (CPLib.Empty(_paeseicp))) {
                    /* _cabicp := '' */
                    _cabicp = "";
                    /* Case not(Empty(qbe_opeuif->CODCAB2)) and _paeseicp = '086' */
                  } else if ( ! (CPLib.Empty(Cursor_qbe_opeuif.GetString("CODCAB2"))) && CPLib.eqr(_paeseicp,"086")) {
                    /* _cabicp := qbe_opeuif->CODCAB2 */
                    _cabicp = Cursor_qbe_opeuif.GetString("CODCAB2");
                  } // End Case
                  /* If _paeseicp <> '086' */
                  if (CPLib.ne(_paeseicp,"086")) {
                    /* mcExt.AppendBlank() */
                    mcExt.AppendBlank();
                    /* mcExt.CODINTDIP := _coddip */
                    mcExt.row.CODINTDIP = _coddip;
                    /* mcExt.ABICABDIP := _abicab */
                    mcExt.row.ABICABDIP = _abicab;
                    /* mcExt.CODCABDIP := LRTrim(_cabdip) */
                    mcExt.row.CODCABDIP = CPLib.LRTrim(_cabdip);
                    /* mcExt.PERPAESE := _paesecli */
                    mcExt.row.PERPAESE = _paesecli;
                    /* mcExt.PERCAB := _cabcli */
                    mcExt.row.PERCAB = _cabcli;
                    /* mcExt.CODVOC := qbe_opeuif->CODVOC */
                    mcExt.row.CODVOC = Cursor_qbe_opeuif.GetString("CODVOC");
                    /* mcExt.FLAGLIRE := qbe_opeuif->FLAGLIRE */
                    mcExt.row.FLAGLIRE = Cursor_qbe_opeuif.GetString("FLAGLIRE");
                    /* mcExt.SEGNO := qbe_opeuif->SEGNO */
                    mcExt.row.SEGNO = Cursor_qbe_opeuif.GetString("SEGNO");
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
                    /* If _pqtotale=0 */
                    if (CPLib.eqr(_pqtotale,0)) {
                      /* mcExt.TOTLIRE := qbe_opeuif->TOTLIRE / (_conta * 100) */
                      mcExt.row.TOTLIRE = Cursor_qbe_opeuif.GetDouble("TOTLIRE")/(_conta*100);
                      /* mcExt.TOTCONT := qbe_opeuif->TOTCONT / (_conta * 100) */
                      mcExt.row.TOTCONT = Cursor_qbe_opeuif.GetDouble("TOTCONT")/(_conta*100);
                    } else { // Else
                      /* mcExt.TOTLIRE := (qbe_opeuif->TOTLIRE / 10000) * clientiope->PROQUOTA */
                      mcExt.row.TOTLIRE = (Cursor_qbe_opeuif.GetDouble("TOTLIRE")/10000)*Cursor_clientiope.GetDouble("PROQUOTA");
                      /* mcExt.TOTCONT := (qbe_opeuif->TOTCONT / 10000)  * clientiope->PROQUOTA */
                      mcExt.row.TOTCONT = (Cursor_qbe_opeuif.GetDouble("TOTCONT")/10000)*Cursor_clientiope.GetDouble("PROQUOTA");
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
                    /* mcIta.ABICABDIP := _abicab */
                    mcIta.row.ABICABDIP = _abicab;
                    /* mcIta.CODCABDIP := LRTrim(_cabdip) */
                    mcIta.row.CODCABDIP = CPLib.LRTrim(_cabdip);
                    /* mcIta.PERPAESE := _paesecli */
                    mcIta.row.PERPAESE = _paesecli;
                    /* mcIta.PERCAB := _cabcli */
                    mcIta.row.PERCAB = _cabcli;
                    /* mcIta.CODVOC := qbe_opeuif->CODVOC */
                    mcIta.row.CODVOC = Cursor_qbe_opeuif.GetString("CODVOC");
                    /* mcIta.FLAGLIRE := qbe_opeuif->FLAGLIRE */
                    mcIta.row.FLAGLIRE = Cursor_qbe_opeuif.GetString("FLAGLIRE");
                    /* mcIta.SEGNO := qbe_opeuif->SEGNO */
                    mcIta.row.SEGNO = Cursor_qbe_opeuif.GetString("SEGNO");
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
                    /* If _pqtotale=0 */
                    if (CPLib.eqr(_pqtotale,0)) {
                      /* mcIta.TOTLIRE := qbe_opeuif->TOTLIRE / (_conta * 100) */
                      mcIta.row.TOTLIRE = Cursor_qbe_opeuif.GetDouble("TOTLIRE")/(_conta*100);
                      /* mcIta.TOTCONT := qbe_opeuif->TOTCONT / (_conta * 100) */
                      mcIta.row.TOTCONT = Cursor_qbe_opeuif.GetDouble("TOTCONT")/(_conta*100);
                    } else { // Else
                      /* mcIta.TOTLIRE := (qbe_opeuif->TOTLIRE / 10000) * clientiope->PROQUOTA */
                      mcIta.row.TOTLIRE = (Cursor_qbe_opeuif.GetDouble("TOTLIRE")/10000)*Cursor_clientiope.GetDouble("PROQUOTA");
                      /* mcIta.TOTCONT := (qbe_opeuif->TOTCONT / 10000)  * clientiope->PROQUOTA */
                      mcIta.row.TOTCONT = (Cursor_qbe_opeuif.GetDouble("TOTCONT")/10000)*Cursor_clientiope.GetDouble("PROQUOTA");
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
                  /* mcAlt.AppendBlank() */
                  mcAlt.AppendBlank();
                  /* mcAlt.CODINTDIP := _coddip */
                  mcAlt.row.CODINTDIP = _coddip;
                  /* mcAlt.ABICABDIP := _abicab */
                  mcAlt.row.ABICABDIP = _abicab;
                  /* mcAlt.CODCABDIP := LRTrim(_cabdip) */
                  mcAlt.row.CODCABDIP = CPLib.LRTrim(_cabdip);
                  /* mcAlt.PERPAESE := _paesecli */
                  mcAlt.row.PERPAESE = _paesecli;
                  /* mcAlt.PERCAB := _cabcli */
                  mcAlt.row.PERCAB = _cabcli;
                  /* mcAlt.CODVOC := qbe_opeuif->CODVOC */
                  mcAlt.row.CODVOC = Cursor_qbe_opeuif.GetString("CODVOC");
                  /* mcAlt.FLAGLIRE := qbe_opeuif->FLAGLIRE */
                  mcAlt.row.FLAGLIRE = Cursor_qbe_opeuif.GetString("FLAGLIRE");
                  /* mcAlt.SEGNO := qbe_opeuif->SEGNO */
                  mcAlt.row.SEGNO = Cursor_qbe_opeuif.GetString("SEGNO");
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
                  /* If _pqtotale=0 */
                  if (CPLib.eqr(_pqtotale,0)) {
                    /* mcAlt.TOTLIRE := qbe_opeuif->TOTLIRE / (_conta * 100) */
                    mcAlt.row.TOTLIRE = Cursor_qbe_opeuif.GetDouble("TOTLIRE")/(_conta*100);
                    /* mcAlt.TOTCONT := qbe_opeuif->TOTCONT / (_conta * 100) */
                    mcAlt.row.TOTCONT = Cursor_qbe_opeuif.GetDouble("TOTCONT")/(_conta*100);
                  } else { // Else
                    /* mcAlt.TOTLIRE := (qbe_opeuif->TOTLIRE / 10000) * clientiope->PROQUOTA */
                    mcAlt.row.TOTLIRE = (Cursor_qbe_opeuif.GetDouble("TOTLIRE")/10000)*Cursor_clientiope.GetDouble("PROQUOTA");
                    /* mcAlt.TOTCONT := (qbe_opeuif->TOTCONT / 10000)  * clientiope->PROQUOTA */
                    mcAlt.row.TOTCONT = (Cursor_qbe_opeuif.GetDouble("TOTCONT")/10000)*Cursor_clientiope.GetDouble("PROQUOTA");
                  } // End If
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
          Cursor_qbe_opeuif.Next();
        }
        m_cConnectivityError = Cursor_qbe_opeuif.ErrorMessage();
        Cursor_qbe_opeuif.Close();
        // * --- End Select
        /* _dataoggi := arfn_datesum(_dataoggi,1) */
        _dataoggi = arfn_datesumR.Make(m_Ctx,this).Run(_dataoggi,1);
        /* _cdataoggi := DateToChar(_dataoggi) */
        _cdataoggi = CPLib.DateToChar(_dataoggi);
      } // End While
      /* gMsgProc := gMsgProc + NL + 'Sono stati elaborati '+LRTrim(Str(_contaop,10,0))+' record del file Operazioni' + NL */
      gMsgProc = gMsgProc+"\n"+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_contaop,10,0))+" record del file Operazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_clientifrz=null;
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
        // * --- Select from qbe_frauif
        SPBridge.HMCaller _h00000173;
        _h00000173 = new SPBridge.HMCaller();
        _h00000173.Set("m_cVQRList",m_cVQRList);
        _h00000173.Set("cdadata",_cdataoggi);
        if (Cursor_qbe_frauif!=null)
          Cursor_qbe_frauif.Close();
        Cursor_qbe_frauif = new VQRHolder("qbe_frauif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000173,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_frauif.Eof())) {
          /* _nosara := 0 */
          _nosara = CPLib.Round(0,0);
          /* _sara := 'N' */
          _sara = "N";
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESCLI"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_frauif.GetString("CONNESCLI"));
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
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_discouic_ver2 returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _sara = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _nosara := iif(_sara='N',0,1) */
          _nosara = CPLib.Round((CPLib.eqr(_sara,"N")?0:1),0);
          /* _pqtotale := qbe_frauif->PROQUOTA */
          _pqtotale = CPLib.Round(Cursor_qbe_frauif.GetDouble("PROQUOTA"),0);
          /* If _nosara=0 */
          if (CPLib.eqr(_nosara,0)) {
            // * --- Select from clientifrz
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            if (Cursor_clientifrz!=null)
              Cursor_clientifrz.Close();
            Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frauif.GetString("IDBASE"),"?",0,0)+"  and  CODSOG <> "+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_discouic_ver2 returns two or more records. This item should return only a record.");
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
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* If _conta > 1 */
            if (CPLib.gt(_conta,1)) {
              /* _operaz := 1 / _conta */
              _operaz = CPLib.Round(1/_conta,2);
              /* _ocont := iif(qbe_frauif->TOTCONT <> 0,1 / _conta,0) */
              _ocont = CPLib.Round((CPLib.ne(Cursor_qbe_frauif.GetDouble("TOTCONT"),0)?1/_conta:0),2);
            } else { // Else
              /* _operaz := 1 */
              _operaz = CPLib.Round(1,2);
              /* _ocont := iif(qbe_frauif->TOTCONT <> 0,1,0) */
              _ocont = CPLib.Round((CPLib.ne(Cursor_qbe_frauif.GetDouble("TOTCONT"),0)?1:0),2);
            } // End If
          } // End If
          /* If _nosara=0 */
          if (CPLib.eqr(_nosara,0)) {
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
            /* _settsint := '' */
            _settsint = "";
            /* _conta := 0 */
            _conta = CPLib.Round(0,0);
            /* _operaz := 0 */
            _operaz = CPLib.Round(0,2);
            /* _ocont := 0 */
            _ocont = CPLib.Round(0,2);
            /* If Empty(LRTrim(qbe_frauif->CODDIPE)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frauif.GetString("CODDIPE")))) {
              /* _coddip := '000000' */
              _coddip = "000000";
              /* _cabdip := _cabint */
              _cabdip = _cabint;
            } else { // Else
              /* _coddip := qbe_frauif->CODDIPE */
              _coddip = Cursor_qbe_frauif.GetString("CODDIPE");
              /* _cabdip := qbe_frauif->CABDIP */
              _cabdip = Cursor_qbe_frauif.GetString("CABDIP");
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
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _cabdip = Read_Cursor.GetString("CAB");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_ver2 returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _cabdip = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
            } // End If
            /* _paesecli := qbe_frauif->PAESECLI */
            _paesecli = Cursor_qbe_frauif.GetString("PAESECLI");
            /* If _paesecli='086' */
            if (CPLib.eqr(_paesecli,"086")) {
              /* _cabcli := iif(not(Empty(qbe_frauif->CABCLI)),qbe_frauif->CABCLI,qbe_frauif->CODCAB2) */
              _cabcli = ( ! (CPLib.Empty(Cursor_qbe_frauif.GetString("CABCLI")))?Cursor_qbe_frauif.GetString("CABCLI"):Cursor_qbe_frauif.GetString("CODCAB2"));
            } else { // Else
              /* _cabcli := '' */
              _cabcli = "";
            } // End If
            /* _settsint := iif(Empty(qbe_frauif->SETTSINT),'999',qbe_frauif->SETTSINT) */
            _settsint = (CPLib.Empty(Cursor_qbe_frauif.GetString("SETTSINT"))?"999":Cursor_qbe_frauif.GetString("SETTSINT"));
            /* If At(LRTrim(qbe_frauif->CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
            if (CPLib.gt(CPLib.At(CPLib.LRTrim(Cursor_qbe_frauif.GetString("CODVOC")),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
              /* _paesecp := qbe_frauif->C_STA */
              _paesecp = Cursor_qbe_frauif.GetString("C_STA");
              /* _cabcp := iif(_paesecp <>'086','',LRTrim(qbe_frauif->C_CAB)) */
              _cabcp = (CPLib.ne(_paesecp,"086")?"":CPLib.LRTrim(Cursor_qbe_frauif.GetString("C_CAB")));
              /* If Empty(qbe_frauif->PAESE) */
              if (CPLib.Empty(Cursor_qbe_frauif.GetString("PAESE"))) {
                /* _paeseicp := _paesecp */
                _paeseicp = _paesecp;
              } else { // Else
                /* _paeseicp := qbe_frauif->PAESE */
                _paeseicp = Cursor_qbe_frauif.GetString("PAESE");
              } // End If
              /* Case Empty(qbe_frauif->CODCAB2) and _paeseicp='086' */
              if (CPLib.Empty(Cursor_qbe_frauif.GetString("CODCAB2")) && CPLib.eqr(_paeseicp,"086")) {
                /* If _paesecp='086' */
                if (CPLib.eqr(_paesecp,"086")) {
                  /* _cabicp := _cabcp */
                  _cabicp = _cabcp;
                } else { // Else
                  /* _cabicp := '' */
                  _cabicp = "";
                } // End If
                /* Case Empty(qbe_frauif->CODCAB2) and _paeseicp<>'086' and not(Empty(_paeseicp)) */
              } else if (CPLib.Empty(Cursor_qbe_frauif.GetString("CODCAB2")) && CPLib.ne(_paeseicp,"086") &&  ! (CPLib.Empty(_paeseicp))) {
                /* _cabicp := '' */
                _cabicp = "";
                /* Case not(Empty(qbe_frauif->CODCAB2)) and _paeseicp = '086' */
              } else if ( ! (CPLib.Empty(Cursor_qbe_frauif.GetString("CODCAB2"))) && CPLib.eqr(_paeseicp,"086")) {
                /* _cabicp := qbe_frauif->CODCAB2 */
                _cabicp = Cursor_qbe_frauif.GetString("CODCAB2");
              } // End Case
              /* If _paeseicp <> '086' */
              if (CPLib.ne(_paeseicp,"086")) {
                /* mcExt.AppendBlank() */
                mcExt.AppendBlank();
                /* mcExt.CODINTDIP := _coddip */
                mcExt.row.CODINTDIP = _coddip;
                /* mcExt.ABICABDIP := _abicab */
                mcExt.row.ABICABDIP = _abicab;
                /* mcExt.CODCABDIP := _cabdip */
                mcExt.row.CODCABDIP = _cabdip;
                /* mcExt.PERPAESE := _paesecli */
                mcExt.row.PERPAESE = _paesecli;
                /* mcExt.PERCAB := _cabcli */
                mcExt.row.PERCAB = _cabcli;
                /* mcExt.CODVOC := qbe_frauif->CODVOC */
                mcExt.row.CODVOC = Cursor_qbe_frauif.GetString("CODVOC");
                /* mcExt.FLAGLIRE := qbe_frauif->FLAGLIRE */
                mcExt.row.FLAGLIRE = Cursor_qbe_frauif.GetString("FLAGLIRE");
                /* mcExt.SEGNO := qbe_frauif->SEGNO */
                mcExt.row.SEGNO = Cursor_qbe_frauif.GetString("SEGNO");
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
                /* If _pqtotale=0 */
                if (CPLib.eqr(_pqtotale,0)) {
                  /* mcExt.TOTLIRE := qbe_frauif->TOTLIRE / (_conta * 100) */
                  mcExt.row.TOTLIRE = Cursor_qbe_frauif.GetDouble("TOTLIRE")/(_conta*100);
                  /* mcExt.TOTCONT := qbe_frauif->TOTCONT / (_conta * 100) */
                  mcExt.row.TOTCONT = Cursor_qbe_frauif.GetDouble("TOTCONT")/(_conta*100);
                } else { // Else
                  /* mcExt.TOTLIRE := (qbe_frauif->TOTLIRE / 10000) * qbe_frauif->PROQUOTA */
                  mcExt.row.TOTLIRE = (Cursor_qbe_frauif.GetDouble("TOTLIRE")/10000)*Cursor_qbe_frauif.GetDouble("PROQUOTA");
                  /* mcExt.TOTCONT := (qbe_frauif->TOTCONT / 10000)  * qbe_frauif->PROQUOTA */
                  mcExt.row.TOTCONT = (Cursor_qbe_frauif.GetDouble("TOTCONT")/10000)*Cursor_qbe_frauif.GetDouble("PROQUOTA");
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
                /* mcIta.ABICABDIP := _abicab */
                mcIta.row.ABICABDIP = _abicab;
                /* mcIta.CODCABDIP := _cabdip */
                mcIta.row.CODCABDIP = _cabdip;
                /* mcIta.PERPAESE := _paesecli */
                mcIta.row.PERPAESE = _paesecli;
                /* mcIta.PERCAB := _cabcli */
                mcIta.row.PERCAB = _cabcli;
                /* mcIta.CODVOC := qbe_frauif->CODVOC */
                mcIta.row.CODVOC = Cursor_qbe_frauif.GetString("CODVOC");
                /* mcIta.FLAGLIRE := qbe_frauif->FLAGLIRE */
                mcIta.row.FLAGLIRE = Cursor_qbe_frauif.GetString("FLAGLIRE");
                /* mcIta.SEGNO := qbe_frauif->SEGNO */
                mcIta.row.SEGNO = Cursor_qbe_frauif.GetString("SEGNO");
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
                /* If _pqtotale=0 */
                if (CPLib.eqr(_pqtotale,0)) {
                  /* mcIta.TOTLIRE := qbe_frauif->TOTLIRE / (_conta * 100) */
                  mcIta.row.TOTLIRE = Cursor_qbe_frauif.GetDouble("TOTLIRE")/(_conta*100);
                  /* mcIta.TOTCONT := qbe_frauif->TOTCONT / (_conta * 100) */
                  mcIta.row.TOTCONT = Cursor_qbe_frauif.GetDouble("TOTCONT")/(_conta*100);
                } else { // Else
                  /* mcIta.TOTLIRE := (qbe_frauif->TOTLIRE / 10000) * qbe_frauif->PROQUOTA */
                  mcIta.row.TOTLIRE = (Cursor_qbe_frauif.GetDouble("TOTLIRE")/10000)*Cursor_qbe_frauif.GetDouble("PROQUOTA");
                  /* mcIta.TOTCONT := (qbe_frauif->TOTCONT / 10000)  * qbe_frauif->PROQUOTA */
                  mcIta.row.TOTCONT = (Cursor_qbe_frauif.GetDouble("TOTCONT")/10000)*Cursor_qbe_frauif.GetDouble("PROQUOTA");
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
              /* mcAlt.AppendBlank() */
              mcAlt.AppendBlank();
              /* mcAlt.CODINTDIP := _coddip */
              mcAlt.row.CODINTDIP = _coddip;
              /* mcAlt.ABICABDIP := _abicab */
              mcAlt.row.ABICABDIP = _abicab;
              /* mcAlt.CODCABDIP := _cabdip */
              mcAlt.row.CODCABDIP = _cabdip;
              /* mcAlt.PERPAESE := _paesecli */
              mcAlt.row.PERPAESE = _paesecli;
              /* mcAlt.PERCAB := _cabcli */
              mcAlt.row.PERCAB = _cabcli;
              /* mcAlt.CODVOC := qbe_frauif->CODVOC */
              mcAlt.row.CODVOC = Cursor_qbe_frauif.GetString("CODVOC");
              /* mcAlt.FLAGLIRE := qbe_frauif->FLAGLIRE */
              mcAlt.row.FLAGLIRE = Cursor_qbe_frauif.GetString("FLAGLIRE");
              /* mcAlt.SEGNO := qbe_frauif->SEGNO */
              mcAlt.row.SEGNO = Cursor_qbe_frauif.GetString("SEGNO");
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
              /* If _pqtotale=0 */
              if (CPLib.eqr(_pqtotale,0)) {
                /* mcAlt.TOTLIRE := qbe_frauif->TOTLIRE / (_conta * 100) */
                mcAlt.row.TOTLIRE = Cursor_qbe_frauif.GetDouble("TOTLIRE")/(_conta*100);
                /* mcAlt.TOTCONT := qbe_frauif->TOTCONT / (_conta * 100) */
                mcAlt.row.TOTCONT = Cursor_qbe_frauif.GetDouble("TOTCONT")/(_conta*100);
              } else { // Else
                /* mcAlt.TOTLIRE := (qbe_frauif->TOTLIRE / 10000) * qbe_frauif->PROQUOTA */
                mcAlt.row.TOTLIRE = (Cursor_qbe_frauif.GetDouble("TOTLIRE")/10000)*Cursor_qbe_frauif.GetDouble("PROQUOTA");
                /* mcAlt.TOTCONT := (qbe_frauif->TOTCONT / 10000)  * qbe_frauif->PROQUOTA */
                mcAlt.row.TOTCONT = (Cursor_qbe_frauif.GetDouble("TOTCONT")/10000)*Cursor_qbe_frauif.GetDouble("PROQUOTA");
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
              // * --- Select from clientifrz
              m_cServer = m_Ctx.GetServer("clientifrz");
              m_cPhName = m_Ctx.GetPhName("clientifrz");
              if (Cursor_clientifrz!=null)
                Cursor_clientifrz.Close();
              Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frauif.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_clientifrz.Eof())) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _paesecli := personbo->PAESE */
                  _paesecli = Cursor_personbo.GetString("PAESE");
                  /* If _paesecli='086' */
                  if (CPLib.eqr(_paesecli,"086")) {
                    /* _cabcli := iif(not(Empty(personbo->CODCAB)),personbo->CODCAB,qbe_frauif->CODCAB2) */
                    _cabcli = ( ! (CPLib.Empty(Cursor_personbo.GetString("CODCAB")))?Cursor_personbo.GetString("CODCAB"):Cursor_qbe_frauif.GetString("CODCAB2"));
                  } else { // Else
                    /* _cabcli := '' */
                    _cabcli = "";
                  } // End If
                  /* _settsint := iif(Empty(personbo->SETTSINT),'999',personbo->SETTSINT) */
                  _settsint = (CPLib.Empty(Cursor_personbo.GetString("SETTSINT"))?"999":Cursor_personbo.GetString("SETTSINT"));
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
                /* If At(LRTrim(qbe_frauif->CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
                if (CPLib.gt(CPLib.At(CPLib.LRTrim(Cursor_qbe_frauif.GetString("CODVOC")),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
                  /* _paesecp := qbe_frauif->C_STA */
                  _paesecp = Cursor_qbe_frauif.GetString("C_STA");
                  /* _cabcp := iif(_paesecp <>'086','',LRTrim(qbe_frauif->C_CAB)) */
                  _cabcp = (CPLib.ne(_paesecp,"086")?"":CPLib.LRTrim(Cursor_qbe_frauif.GetString("C_CAB")));
                  /* If Empty(qbe_frauif->PAESE) */
                  if (CPLib.Empty(Cursor_qbe_frauif.GetString("PAESE"))) {
                    /* _paeseicp := _paesecp */
                    _paeseicp = _paesecp;
                  } else { // Else
                    /* _paeseicp := qbe_frauif->PAESE */
                    _paeseicp = Cursor_qbe_frauif.GetString("PAESE");
                  } // End If
                  /* Case Empty(qbe_frauif->CODCAB2) and _paeseicp='086' */
                  if (CPLib.Empty(Cursor_qbe_frauif.GetString("CODCAB2")) && CPLib.eqr(_paeseicp,"086")) {
                    /* If _paesecp='086' */
                    if (CPLib.eqr(_paesecp,"086")) {
                      /* _cabicp := _cabcp */
                      _cabicp = _cabcp;
                    } else { // Else
                      /* _cabicp := '' */
                      _cabicp = "";
                    } // End If
                    /* Case Empty(qbe_frauif->CODCAB2) and _paeseicp<>'086' and not(Empty(_paeseicp)) */
                  } else if (CPLib.Empty(Cursor_qbe_frauif.GetString("CODCAB2")) && CPLib.ne(_paeseicp,"086") &&  ! (CPLib.Empty(_paeseicp))) {
                    /* _cabicp := '' */
                    _cabicp = "";
                    /* Case not(Empty(qbe_frauif->CODCAB2)) and _paeseicp = '086' */
                  } else if ( ! (CPLib.Empty(Cursor_qbe_frauif.GetString("CODCAB2"))) && CPLib.eqr(_paeseicp,"086")) {
                    /* _cabicp := qbe_frauif->CODCAB2 */
                    _cabicp = Cursor_qbe_frauif.GetString("CODCAB2");
                  } // End Case
                  /* If _paeseicp <> '086' */
                  if (CPLib.ne(_paeseicp,"086")) {
                    /* mcExt.AppendBlank() */
                    mcExt.AppendBlank();
                    /* mcExt.CODINTDIP := _coddip */
                    mcExt.row.CODINTDIP = _coddip;
                    /* mcExt.ABICABDIP := _abicab */
                    mcExt.row.ABICABDIP = _abicab;
                    /* mcExt.CODCABDIP := _cabdip */
                    mcExt.row.CODCABDIP = _cabdip;
                    /* mcExt.PERPAESE := _paesecli */
                    mcExt.row.PERPAESE = _paesecli;
                    /* mcExt.PERCAB := _cabcli */
                    mcExt.row.PERCAB = _cabcli;
                    /* mcExt.CODVOC := qbe_frauif->CODVOC */
                    mcExt.row.CODVOC = Cursor_qbe_frauif.GetString("CODVOC");
                    /* mcExt.FLAGLIRE := qbe_frauif->FLAGLIRE */
                    mcExt.row.FLAGLIRE = Cursor_qbe_frauif.GetString("FLAGLIRE");
                    /* mcExt.SEGNO := qbe_frauif->SEGNO */
                    mcExt.row.SEGNO = Cursor_qbe_frauif.GetString("SEGNO");
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
                    /* If _pqtotale=0 */
                    if (CPLib.eqr(_pqtotale,0)) {
                      /* mcExt.TOTLIRE := qbe_frauif->TOTLIRE / (_conta * 100) */
                      mcExt.row.TOTLIRE = Cursor_qbe_frauif.GetDouble("TOTLIRE")/(_conta*100);
                      /* mcExt.TOTCONT := qbe_frauif->TOTCONT / (_conta * 100) */
                      mcExt.row.TOTCONT = Cursor_qbe_frauif.GetDouble("TOTCONT")/(_conta*100);
                    } else { // Else
                      /* mcExt.TOTLIRE := (qbe_frauif->TOTLIRE / 10000) * clientifrz->PROQUOTA */
                      mcExt.row.TOTLIRE = (Cursor_qbe_frauif.GetDouble("TOTLIRE")/10000)*Cursor_clientifrz.GetDouble("PROQUOTA");
                      /* mcExt.TOTCONT := (qbe_frauif->TOTCONT / 10000)  * clientifrz->PROQUOTA */
                      mcExt.row.TOTCONT = (Cursor_qbe_frauif.GetDouble("TOTCONT")/10000)*Cursor_clientifrz.GetDouble("PROQUOTA");
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
                    /* mcIta.ABICABDIP := _abicab */
                    mcIta.row.ABICABDIP = _abicab;
                    /* mcIta.CODCABDIP := _cabdip */
                    mcIta.row.CODCABDIP = _cabdip;
                    /* mcIta.PERPAESE := _paesecli */
                    mcIta.row.PERPAESE = _paesecli;
                    /* mcIta.PERCAB := _cabcli */
                    mcIta.row.PERCAB = _cabcli;
                    /* mcIta.CODVOC := qbe_frauif->CODVOC */
                    mcIta.row.CODVOC = Cursor_qbe_frauif.GetString("CODVOC");
                    /* mcIta.FLAGLIRE := qbe_frauif->FLAGLIRE */
                    mcIta.row.FLAGLIRE = Cursor_qbe_frauif.GetString("FLAGLIRE");
                    /* mcIta.SEGNO := qbe_frauif->SEGNO */
                    mcIta.row.SEGNO = Cursor_qbe_frauif.GetString("SEGNO");
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
                    /* If _pqtotale=0 */
                    if (CPLib.eqr(_pqtotale,0)) {
                      /* mcIta.TOTLIRE := qbe_frauif->TOTLIRE / (_conta * 100) */
                      mcIta.row.TOTLIRE = Cursor_qbe_frauif.GetDouble("TOTLIRE")/(_conta*100);
                      /* mcIta.TOTCONT := qbe_frauif->TOTCONT / (_conta * 100) */
                      mcIta.row.TOTCONT = Cursor_qbe_frauif.GetDouble("TOTCONT")/(_conta*100);
                    } else { // Else
                      /* mcIta.TOTLIRE := (qbe_frauif->TOTLIRE / 10000) * clientifrz->PROQUOTA */
                      mcIta.row.TOTLIRE = (Cursor_qbe_frauif.GetDouble("TOTLIRE")/10000)*Cursor_clientifrz.GetDouble("PROQUOTA");
                      /* mcIta.TOTCONT := (qbe_frauif->TOTCONT / 10000)  * clientifrz->PROQUOTA */
                      mcIta.row.TOTCONT = (Cursor_qbe_frauif.GetDouble("TOTCONT")/10000)*Cursor_clientifrz.GetDouble("PROQUOTA");
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
                  /* mcAlt.AppendBlank() */
                  mcAlt.AppendBlank();
                  /* mcAlt.CODINTDIP := _coddip */
                  mcAlt.row.CODINTDIP = _coddip;
                  /* mcAlt.ABICABDIP := _abicab */
                  mcAlt.row.ABICABDIP = _abicab;
                  /* mcAlt.CODCABDIP := _cabdip */
                  mcAlt.row.CODCABDIP = _cabdip;
                  /* mcAlt.PERPAESE := _paesecli */
                  mcAlt.row.PERPAESE = _paesecli;
                  /* mcAlt.PERCAB := _cabcli */
                  mcAlt.row.PERCAB = _cabcli;
                  /* mcAlt.CODVOC := qbe_frauif->CODVOC */
                  mcAlt.row.CODVOC = Cursor_qbe_frauif.GetString("CODVOC");
                  /* mcAlt.FLAGLIRE := qbe_frauif->FLAGLIRE */
                  mcAlt.row.FLAGLIRE = Cursor_qbe_frauif.GetString("FLAGLIRE");
                  /* mcAlt.SEGNO := qbe_frauif->SEGNO */
                  mcAlt.row.SEGNO = Cursor_qbe_frauif.GetString("SEGNO");
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
                  /* If _pqtotale=0 */
                  if (CPLib.eqr(_pqtotale,0)) {
                    /* mcAlt.TOTLIRE := qbe_frauif->TOTLIRE / (_conta * 100) */
                    mcAlt.row.TOTLIRE = Cursor_qbe_frauif.GetDouble("TOTLIRE")/(_conta*100);
                    /* mcAlt.TOTCONT := qbe_frauif->TOTCONT / (_conta * 100) */
                    mcAlt.row.TOTCONT = Cursor_qbe_frauif.GetDouble("TOTCONT")/(_conta*100);
                  } else { // Else
                    /* mcAlt.TOTLIRE := (qbe_frauif->TOTLIRE / 10000) * clientifrz->PROQUOTA */
                    mcAlt.row.TOTLIRE = (Cursor_qbe_frauif.GetDouble("TOTLIRE")/10000)*Cursor_clientifrz.GetDouble("PROQUOTA");
                    /* mcAlt.TOTCONT := (qbe_frauif->TOTCONT / 10000)  * clientifrz->PROQUOTA */
                    mcAlt.row.TOTCONT = (Cursor_qbe_frauif.GetDouble("TOTCONT")/10000)*Cursor_clientifrz.GetDouble("PROQUOTA");
                  } // End If
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
          Cursor_qbe_frauif.Next();
        }
        m_cConnectivityError = Cursor_qbe_frauif.ErrorMessage();
        Cursor_qbe_frauif.Close();
        // * --- End Select
        /* _dataoggi := arfn_datesum(_dataoggi,1) */
        _dataoggi = arfn_datesumR.Make(m_Ctx,this).Run(_dataoggi,1);
        /* _cdataoggi := DateToChar(_dataoggi) */
        _cdataoggi = CPLib.DateToChar(_dataoggi);
      } // End While
      /* gMsgProc := gMsgProc + NL + 'Sono stati elaborati '+LRTrim(Str(_contaop,10,0))+' record del file Frazionate' + NL */
      gMsgProc = gMsgProc+"\n"+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_contaop,10,0))+" record del file Frazionate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
      MemoryCursor_tmp_invio_xbrl cpmc_000002A2;
      cpmc_000002A2 = new MemoryCursor_tmp_invio_xbrl();
      for (MemoryCursorRow_tmp_invio_xbrl rowTmp : mcTmp._iterable_()) {
        cpmc_000002A2.Append(rowTmp);
      }
      for (MemoryCursorRow_tmp_invio_xbrl rowTmp : cpmc_000002A2._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_tmp_invio_xbrl>(){  public int compare(MemoryCursorRow_tmp_invio_xbrl r1,MemoryCursorRow_tmp_invio_xbrl r2){    if (CPLib.gt(r1.N_ITA,r2.N_ITA)) return 1;    if (CPLib.lt(r1.N_ITA,r2.N_ITA)) return -1;    return 0;  }})) {
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
        /* _totcon := rowTmp.TOTCONT */
        _totcon = CPLib.Round(rowTmp.TOTCONT,2);
        /* _totcon := iif(_totcon - Int(_totcon) > 0,Int(_totcon)+1,_totcon) */
        _totcon = CPLib.Round((CPLib.gt(_totcon-CPLib.Int(_totcon),0)?CPLib.Int(_totcon)+1:_totcon),2);
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
      MemoryCursor_tmp_invio_xbrl cpmc_000002EB;
      cpmc_000002EB = new MemoryCursor_tmp_invio_xbrl();
      for (MemoryCursorRow_tmp_invio_xbrl rowTmp : mcTmp._iterable_()) {
        cpmc_000002EB.Append(rowTmp);
      }
      for (MemoryCursorRow_tmp_invio_xbrl rowTmp : cpmc_000002EB._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_tmp_invio_xbrl>(){  public int compare(MemoryCursorRow_tmp_invio_xbrl r1,MemoryCursorRow_tmp_invio_xbrl r2){    if (CPLib.gt(r1.N_EXT,r2.N_EXT)) return 1;    if (CPLib.lt(r1.N_EXT,r2.N_EXT)) return -1;    return 0;  }})) {
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
        /* _totcon := rowTmp.TOTCONT */
        _totcon = CPLib.Round(rowTmp.TOTCONT,2);
        /* _totcon := iif(_totcon - Int(_totcon) > 0,Int(_totcon)+1,_totcon) */
        _totcon = CPLib.Round((CPLib.gt(_totcon-CPLib.Int(_totcon),0)?CPLib.Int(_totcon)+1:_totcon),2);
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
      MemoryCursor_tmp_invio_xbrl cpmc_00000334;
      cpmc_00000334 = new MemoryCursor_tmp_invio_xbrl();
      for (MemoryCursorRow_tmp_invio_xbrl rowTmp : mcTmp._iterable_()) {
        cpmc_00000334.Append(rowTmp);
      }
      for (MemoryCursorRow_tmp_invio_xbrl rowTmp : cpmc_00000334._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_tmp_invio_xbrl>(){  public int compare(MemoryCursorRow_tmp_invio_xbrl r1,MemoryCursorRow_tmp_invio_xbrl r2){    if (CPLib.gt(r1.N_ALT,r2.N_ALT)) return 1;    if (CPLib.lt(r1.N_ALT,r2.N_ALT)) return -1;    return 0;  }})) {
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
        /* _totcon := rowTmp.TOTCONT */
        _totcon = CPLib.Round(rowTmp.TOTCONT,2);
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
      /* cProg := Utilities.GetAutonumber("PRGFILEUIC\'"+LRTrim(gAzienda)+"'",'',10) */
      cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILEUIC\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
      // * --- Insert into filedatiuic from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("filedatiuic");
      m_cPhName = m_Ctx.GetPhName("filedatiuic");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"filedatiuic",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_ver2",180,"0000037C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_0000037C(m_Ctx,m_oWrInfo);
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
      // * --- Select from qbe_kpeuif
      SPBridge.HMCaller _h00000383;
      _h00000383 = new SPBridge.HMCaller();
      _h00000383.Set("m_cVQRList",m_cVQRList);
      _h00000383.Set("cdadata",_datini);
      _h00000383.Set("c_adata",_datfin);
      if (Cursor_qbe_kpeuif!=null)
        Cursor_qbe_kpeuif.Close();
      Cursor_qbe_kpeuif = new VQRHolder("qbe_kpeuif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000383,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_kpeuif.Eof())) {
        /* _contaop := _contaop + 1 */
        _contaop = CPLib.Round(_contaop+1,0);
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
          /* _coddip := '000000' */
          _coddip = "000000";
          /* _cabdip := _cabint */
          _cabdip = _cabint;
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
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _cabdip = Read_Cursor.GetString("CAB");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_ver2 returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _cabdip = "";
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
          /* _settsint := iif(Empty(personbo->SETTSINT),'999',personbo->SETTSINT) */
          _settsint = (CPLib.Empty(Cursor_personbo.GetString("SETTSINT"))?"999":Cursor_personbo.GetString("SETTSINT"));
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        /* If At(LRTrim(qbe_kpeuif->CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
        if (CPLib.gt(CPLib.At(CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("CODVOC")),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
          /* _paesecp := qbe_kpeuif->C_STA */
          _paesecp = Cursor_qbe_kpeuif.GetString("C_STA");
          /* _cabcp := iif(_paesecp <>'086','',LRTrim(qbe_kpeuif->C_CAB)) */
          _cabcp = (CPLib.ne(_paesecp,"086")?"":CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("C_CAB")));
          /* _paeseicp := qbe_kpeuif->PAESE */
          _paeseicp = Cursor_qbe_kpeuif.GetString("PAESE");
          /* _cabicp := iif(Empty(qbe_kpeuif->CODCAB2),'',qbe_kpeuif->CODCAB2) */
          _cabicp = (CPLib.Empty(Cursor_qbe_kpeuif.GetString("CODCAB2"))?"":Cursor_qbe_kpeuif.GetString("CODCAB2"));
          /* If _paeseicp <> '086' */
          if (CPLib.ne(_paeseicp,"086")) {
            /* mcExt.AppendBlank() */
            mcExt.AppendBlank();
            /* mcExt.CODINTDIP := _coddip */
            mcExt.row.CODINTDIP = _coddip;
            /* mcExt.ABICABDIP := _abicab */
            mcExt.row.ABICABDIP = _abicab;
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
            /* mcIta.ABICABDIP := _abicab */
            mcIta.row.ABICABDIP = _abicab;
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
          /* mcAlt.AppendBlank() */
          mcAlt.AppendBlank();
          /* mcAlt.CODINTDIP := _coddip */
          mcAlt.row.CODINTDIP = _coddip;
          /* mcAlt.ABICABDIP := _abicab */
          mcAlt.row.ABICABDIP = _abicab;
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
          Cursor_clientisara = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientisara")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_clientisara.Eof())) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientisara.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
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
              /* _settsint := iif(Empty(personbo->SETTSINT),'999',personbo->SETTSINT) */
              _settsint = (CPLib.Empty(Cursor_personbo.GetString("SETTSINT"))?"999":Cursor_personbo.GetString("SETTSINT"));
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            /* If At(LRTrim(qbe_kpeuif->CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
            if (CPLib.gt(CPLib.At(CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("CODVOC")),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
              /* _paesecp := qbe_kpeuif->C_STA */
              _paesecp = Cursor_qbe_kpeuif.GetString("C_STA");
              /* _cabcp := iif(_paesecp <>'086','',LRTrim(qbe_kpeuif->C_CAB)) */
              _cabcp = (CPLib.ne(_paesecp,"086")?"":CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("C_CAB")));
              /* _paeseicp := qbe_kpeuif->PAESE */
              _paeseicp = Cursor_qbe_kpeuif.GetString("PAESE");
              /* _cabicp := iif(Empty(qbe_kpeuif->CODCAB2),'',qbe_kpeuif->CODCAB2) */
              _cabicp = (CPLib.Empty(Cursor_qbe_kpeuif.GetString("CODCAB2"))?"":Cursor_qbe_kpeuif.GetString("CODCAB2"));
              /* If _paeseicp <> '086' */
              if (CPLib.ne(_paeseicp,"086")) {
                /* mcExt.AppendBlank() */
                mcExt.AppendBlank();
                /* mcExt.CODINTDIP := _coddip */
                mcExt.row.CODINTDIP = _coddip;
                /* mcExt.ABICABDIP := _abicab */
                mcExt.row.ABICABDIP = _abicab;
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
                /* mcIta.ABICABDIP := _abicab */
                mcIta.row.ABICABDIP = _abicab;
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
              /* mcAlt.AppendBlank() */
              mcAlt.AppendBlank();
              /* mcAlt.CODINTDIP := _coddip */
              mcAlt.row.CODINTDIP = _coddip;
              /* mcAlt.ABICABDIP := _abicab */
              mcAlt.row.ABICABDIP = _abicab;
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
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(_contaop,10,0))+' record del file Operazioni Società Quotate' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_contaop,10,0))+" record del file Operazioni Società Quotate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
      m_Caller.SetDate("DaDatOpe","D",8,0,w_DaDatOpe);
      m_Caller.SetDate("ADatOpe","D",8,0,w_ADatOpe);
      m_Caller.SetString("tipocr","C",2,0,w_tipocr);
      m_Caller.SetString("codcr","C",11,0,w_codcr);
      m_Caller.SetDate("datinv","D",8,0,w_datinv);
      m_Caller.SetNumber("numinv","N",10,0,w_numinv);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_discouic_ver2R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_discouic_ver2R(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    w_tipocr = m_Caller.GetString("tipocr","C",2,0);
    w_codcr = m_Caller.GetString("codcr","C",11,0);
    w_datinv = m_Caller.GetDate("datinv","D",8,0);
    w_numinv = m_Caller.GetNumber("numinv","N",10,0);
    _tipcentro = CPLib.Space(2);
    _codcentro = CPLib.Space(11);
    _settsint = CPLib.Space(3);
    _appconta = 0;
    _totconta = 0;
    _conta = 0;
    _contaw = 0;
    _contaop = 0;
    _coddip = CPLib.Space(6);
    _abicab = CPLib.Space(12);
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
    mcTmp = new MemoryCursor_tmp_invio_xbrl();
    mcIta = new MemoryCursor_tmp_dischebo_xbrl_ita();
    mcExt = new MemoryCursor_tmp_dischebo_xbrl_ext();
    mcAlt = new MemoryCursor_tmp_dischebo_xbrl_alt();
    rowTmp = new MemoryCursorRow_tmp_invio_xbrl();
    _ita1 = "";
    _ita2 = "";
    _ext1 = "";
    _ext2 = "";
    _alt1 = "";
    _alt2 = "";
    mcTxt1 = new MemoryCursor_mctesto_mcrdef();
    mcTxt2 = new MemoryCursor_mctesto_mcrdef();
    _sara = CPLib.Space(1);
    _nosara = 0;
    _pqtotale = 0;
    _datini = CPLib.Space(8);
    _datfin = CPLib.Space(8);
    _ddatini = CPLib.NullDate();
    _ddatfin = CPLib.NullDate();
    _dataoggi = CPLib.NullDate();
    _cdataoggi = CPLib.Space(8);
    _contarow = 0;
    _oldmsg = "";
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
  // ENTITY_VQR: ,qbe_opeuif,qbe_frauif,qbe_kpeuif,
  public static final String m_cVQRList = ",qbe_opeuif,qbe_frauif,qbe_kpeuif,";
  // ENTITY_BATCHES: ,arfn_datesum,arfn_fdate,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_datesum,arfn_fdate,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000037C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
