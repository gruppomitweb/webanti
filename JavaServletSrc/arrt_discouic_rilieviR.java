// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_discouic_rilieviR implements CallerWithObjs {
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tmp_stpoperazioni;
  public String m_cServer_tmp_stpoperazioni;
  public String m_cPhName_clientisara;
  public String m_cServer_clientisara;
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
  public String w_rcoddip;
  public String w_rabicab;
  public String w_rcabdip;
  public String w_rpaecli;
  public String w_rcabcli;
  public String w_rcodvoc;
  public String w_rflglire;
  public String w_rsegno;
  public String w_rsetsin;
  public String w_rpaecon;
  public String w_rcabcon;
  public String w_rpaeint;
  public String w_rcabint;
  public String w_TipoOper;
  public String gPathApp;
  public String gTipInter;
  public String gIntemediario;
  public String gAzienda;
  public String gDescAzi;
  public String gMsgImp;
  public String gMsgProc;
  public String _tipcentro;
  public String _sottotipo;
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
  public String _dipbase;
  public String _dipcab;
  public String _dipabicab;
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
  public double _find;
  public boolean _clientikpe;
  public boolean _clientifrz;
  public boolean _clientiope;
  public MemoryCursor_tmp_invio_xbrl mcTmp;
  public MemoryCursor_tmp_dischebo_xbrl_ita mcIta;
  public MemoryCursor_tmp_dischebo_xbrl_ext mcExt;
  public MemoryCursor_tmp_dischebo_xbrl_alt mcAlt;
  public MemoryCursorRow_tmp_invio_xbrl rowTmp;
  public MemoryCursor_mctesto_mcrdef mcTxt1;
  public MemoryCursor_mctesto_mcrdef mcTxt2;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_discouic_rilieviR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_discouic_rilievi",m_Caller);
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
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
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
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
      m_cPhName_tmp_stpoperazioni = p_ContextObject.GetPhName("tmp_stpoperazioni");
      if (m_cPhName_tmp_stpoperazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stpoperazioni = m_cPhName_tmp_stpoperazioni+" "+m_Ctx.GetWritePhName("tmp_stpoperazioni");
      }
      m_cServer_tmp_stpoperazioni = p_ContextObject.GetServer("tmp_stpoperazioni");
    }
    m_cPhName_clientisara = p_ContextObject.GetPhName("clientisara");
    if (m_cPhName_clientisara.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientisara = m_cPhName_clientisara+" "+m_Ctx.GetWritePhName("clientisara");
    }
    m_cServer_clientisara = p_ContextObject.GetServer("clientisara");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
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
    if (CPLib.eqr("_find",p_cVarName)) {
      return _find;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_discouic_rilievi";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("rcoddip",p_cVarName)) {
      return w_rcoddip;
    }
    if (CPLib.eqr("rabicab",p_cVarName)) {
      return w_rabicab;
    }
    if (CPLib.eqr("rcabdip",p_cVarName)) {
      return w_rcabdip;
    }
    if (CPLib.eqr("rpaecli",p_cVarName)) {
      return w_rpaecli;
    }
    if (CPLib.eqr("rcabcli",p_cVarName)) {
      return w_rcabcli;
    }
    if (CPLib.eqr("rcodvoc",p_cVarName)) {
      return w_rcodvoc;
    }
    if (CPLib.eqr("rflglire",p_cVarName)) {
      return w_rflglire;
    }
    if (CPLib.eqr("rsegno",p_cVarName)) {
      return w_rsegno;
    }
    if (CPLib.eqr("rsetsin",p_cVarName)) {
      return w_rsetsin;
    }
    if (CPLib.eqr("rpaecon",p_cVarName)) {
      return w_rpaecon;
    }
    if (CPLib.eqr("rcabcon",p_cVarName)) {
      return w_rcabcon;
    }
    if (CPLib.eqr("rpaeint",p_cVarName)) {
      return w_rpaeint;
    }
    if (CPLib.eqr("rcabint",p_cVarName)) {
      return w_rcabint;
    }
    if (CPLib.eqr("TipoOper",p_cVarName)) {
      return w_TipoOper;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      return gTipInter;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
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
    if (CPLib.eqr("_sottotipo",p_cVarName)) {
      return _sottotipo;
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
    if (CPLib.eqr("_dipbase",p_cVarName)) {
      return _dipbase;
    }
    if (CPLib.eqr("_dipcab",p_cVarName)) {
      return _dipcab;
    }
    if (CPLib.eqr("_dipabicab",p_cVarName)) {
      return _dipabicab;
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
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      return w_DaDatOpe;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      return w_ADatOpe;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
    }
    if (CPLib.eqr("adata",p_cVarName)) {
      return w_adata;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_clientikpe",p_cVarName)) {
      return _clientikpe;
    }
    if (CPLib.eqr("_clientifrz",p_cVarName)) {
      return _clientifrz;
    }
    if (CPLib.eqr("_clientiope",p_cVarName)) {
      return _clientiope;
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
    if (CPLib.eqr("_find",p_cVarName)) {
      _find = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("rcoddip",p_cVarName)) {
      w_rcoddip = value;
      return;
    }
    if (CPLib.eqr("rabicab",p_cVarName)) {
      w_rabicab = value;
      return;
    }
    if (CPLib.eqr("rcabdip",p_cVarName)) {
      w_rcabdip = value;
      return;
    }
    if (CPLib.eqr("rpaecli",p_cVarName)) {
      w_rpaecli = value;
      return;
    }
    if (CPLib.eqr("rcabcli",p_cVarName)) {
      w_rcabcli = value;
      return;
    }
    if (CPLib.eqr("rcodvoc",p_cVarName)) {
      w_rcodvoc = value;
      return;
    }
    if (CPLib.eqr("rflglire",p_cVarName)) {
      w_rflglire = value;
      return;
    }
    if (CPLib.eqr("rsegno",p_cVarName)) {
      w_rsegno = value;
      return;
    }
    if (CPLib.eqr("rsetsin",p_cVarName)) {
      w_rsetsin = value;
      return;
    }
    if (CPLib.eqr("rpaecon",p_cVarName)) {
      w_rpaecon = value;
      return;
    }
    if (CPLib.eqr("rcabcon",p_cVarName)) {
      w_rcabcon = value;
      return;
    }
    if (CPLib.eqr("rpaeint",p_cVarName)) {
      w_rpaeint = value;
      return;
    }
    if (CPLib.eqr("rcabint",p_cVarName)) {
      w_rcabint = value;
      return;
    }
    if (CPLib.eqr("TipoOper",p_cVarName)) {
      w_TipoOper = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
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
    if (CPLib.eqr("_sottotipo",p_cVarName)) {
      _sottotipo = value;
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
    if (CPLib.eqr("_dipbase",p_cVarName)) {
      _dipbase = value;
      return;
    }
    if (CPLib.eqr("_dipcab",p_cVarName)) {
      _dipcab = value;
      return;
    }
    if (CPLib.eqr("_dipabicab",p_cVarName)) {
      _dipabicab = value;
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
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
    if (CPLib.eqr("adata",p_cVarName)) {
      w_adata = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("_clientikpe",p_cVarName)) {
      _clientikpe = value;
      return;
    }
    if (CPLib.eqr("_clientifrz",p_cVarName)) {
      _clientifrz = value;
      return;
    }
    if (CPLib.eqr("_clientiope",p_cVarName)) {
      _clientiope = value;
      return;
    }
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_tab_mmc=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_rcoddip Char(6) // Dipendenza */
      /* w_rabicab Char(10) // ABI + CAB Dipendenza */
      /* w_rcabdip Char(6) // CAB Dipendenza */
      /* w_rpaecli Char(3) // Paese Cliente */
      /* w_rcabcli Char(6) // CAB Cliente */
      /* w_rcodvoc Char(2) // Causale Sintetica */
      /* w_rflglire Char(1) // Valuta */
      /* w_rsegno Char(1) // Segno */
      /* w_rsetsin Char(3) // Settore Sintetico */
      /* w_rpaecon Char(3) // Paese Controparte */
      /* w_rcabcon Char(6) // CAB Controparte */
      /* w_rpaeint Char(3) // Paese Int. Controparte */
      /* w_rcabint Char(6) // CAB Int. Controparte */
      /* w_TipoOper Char(2) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gTipInter Char(2) // Tipo Intermediario */
      /* gIntemediario Char(11) // Intermediario */
      /* gAzienda Char(10) // Azienda */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo */
      /* _tipcentro Char(2) */
      /* _sottotipo Char(1) */
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
      /* _dipbase Char(6) */
      /* _dipcab Char(6) */
      /* _dipabicab Char(12) */
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
      /* _find Numeric(1, 0) */
      /* _clientikpe Bool */
      /* _clientifrz Bool */
      /* _clientiope Bool */
      /* mcTmp MemoryCursor(tmp_invio_xbrl) */
      /* mcIta MemoryCursor(tmp_dischebo_xbrl_ita) */
      /* mcExt MemoryCursor(tmp_dischebo_xbrl_ext) */
      /* mcAlt MemoryCursor(tmp_dischebo_xbrl_alt) */
      /* rowTmp Row(tmp_invio_xbrl) */
      /* mcTxt1 MemoryCursor(mcTesto.MCRDef) */
      /* mcTxt2 MemoryCursor(mcTesto.MCRDef) */
      /* Assegna valore a variabili */
      /* w_dadata := w_DaDatOpe */
      w_dadata = w_DaDatOpe;
      /* w_adata := w_ADatOpe */
      w_adata = w_ADatOpe;
      /* cdadata := DateToChar(w_DaDatOpe) */
      cdadata = CPLib.DateToChar(w_DaDatOpe);
      /* c_adata := DateToChar(w_ADatOpe) */
      c_adata = CPLib.DateToChar(w_ADatOpe);
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
            Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_rilievi returns two or more records. This item should return only a record.");
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
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000073;
      _h00000073 = new SPBridge.HMCaller();
      _h00000073.Set("m_cVQRList",m_cVQRList);
      _h00000073.Set("tbname","clientiope");
      _h00000073.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000073,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _clientiope := qbe_tab_mmc->tot > 0 */
        _clientiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000075;
      _h00000075 = new SPBridge.HMCaller();
      _h00000075.Set("m_cVQRList",m_cVQRList);
      _h00000075.Set("tbname","clientifrz");
      _h00000075.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000075,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _clientifrz := qbe_tab_mmc->tot > 0 */
        _clientifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000077;
      _h00000077 = new SPBridge.HMCaller();
      _h00000077.Set("m_cVQRList",m_cVQRList);
      _h00000077.Set("tbname","clientifrz");
      _h00000077.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000077,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _clientikpe := qbe_tab_mmc->tot > 0 */
        _clientikpe = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Drop temporary table tmp_stpoperazioni
      if (m_Ctx.IsSharedTemp("tmp_stpoperazioni")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpoperazioni");
      }
      // * --- Create temporary table tmp_stpoperazioni
      if (m_Ctx.IsSharedTemp("tmp_stpoperazioni")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpoperazioni");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_stpoperazioni");
      if ( ! (m_Ctx.IsSharedTemp("tmp_stpoperazioni"))) {
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stpoperazioni",m_cServer,"proto")),m_cPhName,"tmp_stpoperazioni",m_Ctx);
      }
      m_cPhName_tmp_stpoperazioni = m_cPhName;
      /* Verifica le operazioni da trasportare */
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Exec "Verifica" Page 2:Page_2 */
      Page_2();
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Elaborazione terminata. Attendere la preparazione della stampa' // Messaggio Import */
      gMsgImp = "Elaborazione terminata. Attendere la preparazione della stampa";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If _contaop=0 */
      if (CPLib.eqr(_contaop,0)) {
        // * --- Insert into tmp_stpoperazioni from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_rilievi",129,"00000083")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000083(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("0123456789","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
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
        /* Stop Report */
        Forward f;
        f=new Forward("Report",false,this,Forward.Start,false);
        f.SetParameter("ReportName","arrp_stpoper_ver_neg");
        f.SetParameter("outputFormat","PDF");
        f.SetParameter("cdadata",cdadata);
        f.SetParameter("c_adata",c_adata);
        f.SetParameter("DescAzi",gDescAzi);
        f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"cdadata"+","+"c_adata"+","+"DescAzi");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
        /* Stop Report */
        Forward f;
        f=new Forward("Report",false,this,Forward.Start,false);
        f.SetParameter("ReportName","arrp_stpoper_ver");
        f.SetParameter("outputFormat","PDF");
        f.SetParameter("rotation","LANDSCAPE");
        f.SetParameter("cdadata",cdadata);
        f.SetParameter("c_adata",c_adata);
        f.SetParameter("DescAzi",gDescAzi);
        f.SetParameter("xtipo","R");
        f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"rotation"+","+"cdadata"+","+"c_adata"+","+"DescAzi"+","+"xtipo");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End If
    } finally {
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
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_ope_uif_ril=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_clientisara=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_ope_uif_ril
      SPBridge.HMCaller _h00000087;
      _h00000087 = new SPBridge.HMCaller();
      _h00000087.Set("m_cVQRList",m_cVQRList);
      _h00000087.Set("cdadata",cdadata);
      _h00000087.Set("c_adata",c_adata);
      _h00000087.Set("pCODDIPE",w_rcoddip);
      _h00000087.Set("pCODCAB",w_rcabdip);
      _h00000087.Set("pPAESE",w_rpaeint);
      _h00000087.Set("pCODCAB2",w_rcabint);
      _h00000087.Set("pCODVOC",w_rcodvoc);
      _h00000087.Set("pSEGNO",w_rsegno);
      _h00000087.Set("pC_STA",w_rpaecon);
      _h00000087.Set("pC_CAB",w_rcabcon);
      _h00000087.Set("pVALUTA",w_rflglire);
      if (Cursor_qbe_ope_uif_ril!=null)
        Cursor_qbe_ope_uif_ril.Close();
      Cursor_qbe_ope_uif_ril = new VQRHolder("qbe_ope_uif_ril",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000087,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_ope_uif_ril.Eof())) {
        /* gMsgImp := 'Elaboro Operazione: '+ LRTrim(qbe_ope_uif_ril->TIPO_OPE)+"-"+LRTrim(qbe_ope_uif_ril->NUMPROG) // Messaggio Import */
        gMsgImp = "Elaboro Operazione: "+CPLib.LRTrim(Cursor_qbe_ope_uif_ril.GetString("TIPO_OPE"))+"-"+CPLib.LRTrim(Cursor_qbe_ope_uif_ril.GetString("NUMPROG"));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* If LRTrim(qbe_ope_uif_ril->SETTSINT)=w_rsetsin and LRTrim(qbe_ope_uif_ril->CABCLI)=w_rcabcli and LRTrim(qbe_ope_uif_ril->PAESECLI)=w_rpaecli */
        if (CPLib.eqr(CPLib.LRTrim(Cursor_qbe_ope_uif_ril.GetString("SETTSINT")),w_rsetsin) && CPLib.eqr(CPLib.LRTrim(Cursor_qbe_ope_uif_ril.GetString("CABCLI")),w_rcabcli) && CPLib.eqr(CPLib.LRTrim(Cursor_qbe_ope_uif_ril.GetString("PAESECLI")),w_rpaecli)) {
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
        } // End If
        /* If qbe_ope_uif_ril->TIPO_OPE='OPE' and _clientiope */
        if (CPLib.eqr(Cursor_qbe_ope_uif_ril.GetString("TIPO_OPE"),"OPE") && _clientiope) {
          // * --- Select from clientiope
          m_cServer = m_Ctx.GetServer("clientiope");
          m_cPhName = m_Ctx.GetPhName("clientiope");
          if (Cursor_clientiope!=null)
            Cursor_clientiope.Close();
          Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_clientiope.Eof())) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select PAESE,CODCAB,SETTSINT  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* If LRTrim(personbo->SETTSINT)=w_rsetsin and LRTrim(personbo->CODCAB)=w_rcabcli and LRTrim(personbo->PAESE)=w_rpaecli */
              if (CPLib.eqr(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT")),w_rsetsin) && CPLib.eqr(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB")),w_rcabcli) && CPLib.eqr(CPLib.LRTrim(Cursor_personbo.GetString("PAESE")),w_rpaecli)) {
                /* _conta := _conta + 1 */
                _conta = CPLib.Round(_conta+1,0);
              } // End If
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            Cursor_clientiope.Next();
          }
          m_cConnectivityError = Cursor_clientiope.ErrorMessage();
          Cursor_clientiope.Close();
          // * --- End Select
        } // End If
        /* If qbe_ope_uif_ril->TIPO_OPE='FRZ' and _clientifrz */
        if (CPLib.eqr(Cursor_qbe_ope_uif_ril.GetString("TIPO_OPE"),"FRZ") && _clientifrz) {
          // * --- Select from clientifrz
          m_cServer = m_Ctx.GetServer("clientifrz");
          m_cPhName = m_Ctx.GetPhName("clientifrz");
          if (Cursor_clientifrz!=null)
            Cursor_clientifrz.Close();
          Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_clientifrz.Eof())) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select PAESE,CODCAB,SETTSINT  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* If LRTrim(personbo->SETTSINT)=w_rsetsin and LRTrim(personbo->CODCAB)=w_rcabcli and LRTrim(personbo->PAESE)=w_rpaecli */
              if (CPLib.eqr(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT")),w_rsetsin) && CPLib.eqr(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB")),w_rcabcli) && CPLib.eqr(CPLib.LRTrim(Cursor_personbo.GetString("PAESE")),w_rpaecli)) {
                /* _conta := _conta + 1 */
                _conta = CPLib.Round(_conta+1,0);
              } // End If
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            Cursor_clientifrz.Next();
          }
          m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
          Cursor_clientifrz.Close();
          // * --- End Select
        } // End If
        /* If qbe_ope_uif_ril->TIPO_OPE='KPE' and _clientikpe */
        if (CPLib.eqr(Cursor_qbe_ope_uif_ril.GetString("TIPO_OPE"),"KPE") && _clientikpe) {
          // * --- Select from clientisara
          m_cServer = m_Ctx.GetServer("clientisara");
          m_cPhName = m_Ctx.GetPhName("clientisara");
          if (Cursor_clientisara!=null)
            Cursor_clientisara.Close();
          Cursor_clientisara = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientisara")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_clientisara.Eof())) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select PAESE,CODCAB,SETTSINT  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientisara.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* If LRTrim(personbo->SETTSINT)=w_rsetsin and LRTrim(personbo->CODCAB)=w_rcabcli and LRTrim(personbo->PAESE)=w_rpaecli */
              if (CPLib.eqr(CPLib.LRTrim(Cursor_personbo.GetString("SETTSINT")),w_rsetsin) && CPLib.eqr(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB")),w_rcabcli) && CPLib.eqr(CPLib.LRTrim(Cursor_personbo.GetString("PAESE")),w_rpaecli)) {
                /* _conta := _conta + 1 */
                _conta = CPLib.Round(_conta+1,0);
              } // End If
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            Cursor_clientisara.Next();
          }
          m_cConnectivityError = Cursor_clientisara.ErrorMessage();
          Cursor_clientisara.Close();
          // * --- End Select
        } // End If
        /* If _conta > 0 */
        if (CPLib.gt(_conta,0)) {
          /* _contaop := _contaop + 1 */
          _contaop = CPLib.Round(_contaop+1,0);
          /* _sottotipo := iif(qbe_ope_uif_ril->PAESE <> '086','E','I') */
          _sottotipo = (CPLib.ne(Cursor_qbe_ope_uif_ril.GetString("PAESE"),"086")?"E":"I");
          // * --- Insert into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_rilievi",129,"0000009E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000009E(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetDate("DATARETT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("idcauana"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("TIPO_OPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_sottotipo,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_rcoddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_rabicab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_rcabdip),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_rpaecli,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_rcabcli,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_ope_uif_ril.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_rsetsin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_rpaecon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_rcabcon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_rpaeint,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_rcabint,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
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
        Cursor_qbe_ope_uif_ril.Next();
      }
      m_cConnectivityError = Cursor_qbe_ope_uif_ril.ErrorMessage();
      Cursor_qbe_ope_uif_ril.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_ope_uif_ril!=null)
          Cursor_qbe_ope_uif_ril.Close();
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
      try {
        if (Cursor_clientifrz!=null)
          Cursor_clientifrz.Close();
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
      m_Caller.SetString("rcoddip","C",6,0,w_rcoddip);
      m_Caller.SetString("rabicab","C",10,0,w_rabicab);
      m_Caller.SetString("rcabdip","C",6,0,w_rcabdip);
      m_Caller.SetString("rpaecli","C",3,0,w_rpaecli);
      m_Caller.SetString("rcabcli","C",6,0,w_rcabcli);
      m_Caller.SetString("rcodvoc","C",2,0,w_rcodvoc);
      m_Caller.SetString("rflglire","C",1,0,w_rflglire);
      m_Caller.SetString("rsegno","C",1,0,w_rsegno);
      m_Caller.SetString("rsetsin","C",3,0,w_rsetsin);
      m_Caller.SetString("rpaecon","C",3,0,w_rpaecon);
      m_Caller.SetString("rcabcon","C",6,0,w_rcabcon);
      m_Caller.SetString("rpaeint","C",3,0,w_rpaeint);
      m_Caller.SetString("rcabint","C",6,0,w_rcabint);
      m_Caller.SetString("TipoOper","C",2,0,w_TipoOper);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_discouic_rilieviR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_discouic_rilieviR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    w_rcoddip = m_Caller.GetString("rcoddip","C",6,0);
    w_rabicab = m_Caller.GetString("rabicab","C",10,0);
    w_rcabdip = m_Caller.GetString("rcabdip","C",6,0);
    w_rpaecli = m_Caller.GetString("rpaecli","C",3,0);
    w_rcabcli = m_Caller.GetString("rcabcli","C",6,0);
    w_rcodvoc = m_Caller.GetString("rcodvoc","C",2,0);
    w_rflglire = m_Caller.GetString("rflglire","C",1,0);
    w_rsegno = m_Caller.GetString("rsegno","C",1,0);
    w_rsetsin = m_Caller.GetString("rsetsin","C",3,0);
    w_rpaecon = m_Caller.GetString("rpaecon","C",3,0);
    w_rcabcon = m_Caller.GetString("rcabcon","C",6,0);
    w_rpaeint = m_Caller.GetString("rpaeint","C",3,0);
    w_rcabint = m_Caller.GetString("rcabint","C",6,0);
    w_TipoOper = m_Caller.GetString("TipoOper","C",2,0);
    _tipcentro = CPLib.Space(2);
    _sottotipo = CPLib.Space(1);
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
    _dipbase = CPLib.Space(6);
    _dipcab = CPLib.Space(6);
    _dipabicab = CPLib.Space(12);
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
    _find = 0;
    _clientikpe = false;
    _clientifrz = false;
    _clientiope = false;
    mcTmp = new MemoryCursor_tmp_invio_xbrl();
    mcIta = new MemoryCursor_tmp_dischebo_xbrl_ita();
    mcExt = new MemoryCursor_tmp_dischebo_xbrl_ext();
    mcAlt = new MemoryCursor_tmp_dischebo_xbrl_alt();
    rowTmp = new MemoryCursorRow_tmp_invio_xbrl();
    mcTxt1 = new MemoryCursor_mctesto_mcrdef();
    mcTxt2 = new MemoryCursor_mctesto_mcrdef();
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gTipInter=m_Ctx.GetGlobalString("gTipInter");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_ope_uif_ril,
  public static final String m_cVQRList = ",qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_ope_uif_ril,";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000083(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
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
    p_cSql = p_cSql+"CONNESCOL,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
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
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"SUBTYP,";
    p_cSql = p_cSql+"CODINTDIP,";
    p_cSql = p_cSql+"ABICABDIP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"CODVOCAGG,";
    p_cSql = p_cSql+"FLAGLIREAGG,";
    p_cSql = p_cSql+"SEGNOAGG,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"CODCABCP,";
    p_cSql = p_cSql+"PAESEICP,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
}
