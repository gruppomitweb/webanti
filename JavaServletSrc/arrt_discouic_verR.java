// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_discouic_verR implements CallerWithObjs {
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
  public String m_cPhName_analisi_sv;
  public String m_cServer_analisi_sv;
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
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public String w_tipocr;
  public String w_codcr;
  public String w_flgfrazionate;
  public String w_storico;
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
  public double _cope;
  public double _cfra;
  public double _ckpe;
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
  public String _ita1;
  public String _ita2;
  public String _ext1;
  public String _ext2;
  public String _alt1;
  public String _alt2;
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
  public double _nosara;
  public String _sara;
  public String _autoic;
  public double _pqtotale;
  public String _dipbase;
  public String _dipcab;
  public String _dipabicab;
  public MemoryCursor_tmp_invio_xbrl mcTmp;
  public MemoryCursor_tmp_dischebo_xbrl_ita mcIta;
  public MemoryCursor_tmp_dischebo_xbrl_ext mcExt;
  public MemoryCursor_tmp_dischebo_xbrl_alt mcAlt;
  public MemoryCursorRow_tmp_invio_xbrl rowTmp;
  public MemoryCursor_mctesto_mcrdef mcTxt1;
  public MemoryCursor_mctesto_mcrdef mcTxt2;
  public MemoryCursor_qbe_opeuif_vqr mcOpeUif;
  public MemoryCursor_qbe_frauif_vqr mcFraUif;
  public MemoryCursorRow_mcsoggettiall1_mcrdef rowPers;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_discouic_verR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_discouic_ver",m_Caller);
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
    m_cPhName_analisi_sv = p_ContextObject.GetPhName("analisi_sv");
    if (m_cPhName_analisi_sv.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_analisi_sv = m_cPhName_analisi_sv+" "+m_Ctx.GetWritePhName("analisi_sv");
    }
    m_cServer_analisi_sv = p_ContextObject.GetServer("analisi_sv");
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
    if (CPLib.eqr("_cope",p_cVarName)) {
      return _cope;
    }
    if (CPLib.eqr("_cfra",p_cVarName)) {
      return _cfra;
    }
    if (CPLib.eqr("_ckpe",p_cVarName)) {
      return _ckpe;
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
    if (CPLib.eqr("_contarow",p_cVarName)) {
      return _contarow;
    }
    if (CPLib.eqr("_nosara",p_cVarName)) {
      return _nosara;
    }
    if (CPLib.eqr("_pqtotale",p_cVarName)) {
      return _pqtotale;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_discouic_ver";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
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
    if (CPLib.eqr("_sara",p_cVarName)) {
      return _sara;
    }
    if (CPLib.eqr("_autoic",p_cVarName)) {
      return _autoic;
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
    if (CPLib.eqr("_cope",p_cVarName)) {
      _cope = value;
      return;
    }
    if (CPLib.eqr("_cfra",p_cVarName)) {
      _cfra = value;
      return;
    }
    if (CPLib.eqr("_ckpe",p_cVarName)) {
      _ckpe = value;
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
    if (CPLib.eqr("_contarow",p_cVarName)) {
      _contarow = value;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
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
    if (CPLib.eqr("_sara",p_cVarName)) {
      _sara = value;
      return;
    }
    if (CPLib.eqr("_autoic",p_cVarName)) {
      _autoic = value;
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
      /* pTipo Char(1) */
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_tipocr Char(2) */
      /* w_codcr Char(11) */
      /* w_flgfrazionate Char(1) */
      /* w_storico Char(1) // Usa dati storici */
      /* gPathApp Char(80) // Path Applicazione */
      /* gTipInter Char(2) // Tipo Intermediario */
      /* gIntemediario Char(11) // Intermediario */
      /* gAzienda Char(10) // Azienda */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio Import */
      /* _tipcentro Char(2) */
      /* _sottotipo Char(1) */
      /* _codcentro Char(11) */
      /* _settsint Char(3) */
      /* _appconta Numeric(10, 0) */
      /* _totconta Numeric(10, 0) */
      /* _conta Numeric(10, 0) */
      /* _contaw Numeric(10, 0) */
      /* _contaop Numeric(10, 0) */
      /* _cope Numeric(10, 0) */
      /* _cfra Numeric(10, 0) */
      /* _ckpe Numeric(10, 0) */
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
      /* _ita1 Memo */
      /* _ita2 Memo */
      /* _ext1 Memo */
      /* _ext2 Memo */
      /* _alt1 Memo */
      /* _alt2 Memo */
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
      /* _nosara Numeric(1, 0) */
      /* _sara Char(1) */
      /* _autoic Char(1) */
      /* _pqtotale Numeric(3, 0) */
      /* _dipbase Char(6) */
      /* _dipcab Char(6) */
      /* _dipabicab Char(12) */
      /* mcTmp MemoryCursor(tmp_invio_xbrl) */
      /* mcIta MemoryCursor(tmp_dischebo_xbrl_ita) */
      /* mcExt MemoryCursor(tmp_dischebo_xbrl_ext) */
      /* mcAlt MemoryCursor(tmp_dischebo_xbrl_alt) */
      /* rowTmp Row(tmp_invio_xbrl) */
      /* mcTxt1 MemoryCursor(mcTesto.MCRDef) */
      /* mcTxt2 MemoryCursor(mcTesto.MCRDef) */
      /* mcOpeUif MemoryCursor(qbe_opeuif.vqr) */
      /* mcFraUif MemoryCursor(qbe_frauif.vqr) */
      /* rowPers Row(mcSoggettiAll1.MCRDef) */
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
            Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_ver returns two or more records. This item should return only a record.");
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
      /* gMsgProc := 'Ora Inizio Estrazione Dati:'+arfn_fdatetime(DateTime()) + NL // Messaggio Import */
      gMsgProc = "Ora Inizio Estrazione Dati:"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000089status;
      nTry00000089status = m_Sql.GetTransactionStatus();
      String cTry00000089msg;
      cTry00000089msg = m_Sql.TransactionErrorMessage();
      try {
        /* Exec "Operazioni" Page 2:Page_2 */
        Page_2();
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
        /* Exec "Operazioni Società Quotate" Page 4:Page_4 */
        Page_4();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000089status,0)) {
          m_Sql.SetTransactionStatus(nTry00000089status,cTry00000089msg);
        }
      }
      /* If _contaop=0 */
      if (CPLib.eqr(_contaop,0)) {
        // * --- Insert into tmp_stpoperazioni from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_ver",146,"00000091")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000091(m_Ctx,m_oWrInfo);
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
      } // End If
      /* gMsgImp := 'Estrazione dati terminata! Procedere con la stampa' // Messaggio Import */
      gMsgImp = "Estrazione dati terminata! Procedere con la stampa";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Record Estratti:'+LRTrim(Str(_contaop,10,0)) + NL // Messaggio Import */
      gMsgProc = gMsgProc+"Record Estratti:"+CPLib.LRTrim(CPLib.Str(_contaop,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Estrazione Dati:'+arfn_fdatetime(DateTime()) // Messaggio Import */
      gMsgProc = gMsgProc+"Ora Fine Estrazione Dati:"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Return _contaop */
      throw new Stop(_contaop);
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
        SPBridge.HMCaller _h000000A4;
        _h000000A4 = new SPBridge.HMCaller();
        _h000000A4.Set("m_cVQRList",m_cVQRList);
        _h000000A4.Set("cdadata",_cdataoggi);
        if (Cursor_qbe_opeuif!=null)
          Cursor_qbe_opeuif.Close();
        Cursor_qbe_opeuif = new VQRHolder("qbe_opeuif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000A4,true).GetResultSet(m_Ctx);
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
          /* If w_storico='S' */
          if (CPLib.eqr(w_storico,"S")) {
            /* rowPers := arfn_datisog_sol_row(rowOpeUif.CONNESCLI,rowOpeUif.DATAREG,rowOpeUif.STATOREG,rowOpeUif.DATARETT) */
            rowPers = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(rowOpeUif.CONNESCLI,rowOpeUif.DATAREG,rowOpeUif.STATOREG,rowOpeUif.DATARETT);
            /* _settsint := iif(Empty(rowPers.SETSINT),'999',rowPers.SETSINT) */
            _settsint = (CPLib.Empty(rowPers.SETSINT)?"999":rowPers.SETSINT);
            /* _sara := rowPers.NOSARA */
            _sara = rowPers.NOSARA;
          } else { // Else
            /* _settsint := iif(Empty(rowOpeUif.SETTSINT),'999',rowOpeUif.SETTSINT) */
            _settsint = (CPLib.Empty(rowOpeUif.SETTSINT)?"999":rowOpeUif.SETTSINT);
            /* _sara := rowOpeUif.NOSARA */
            _sara = rowOpeUif.NOSARA;
          } // End If
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
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_discouic_ver returns two or more records. This item should return only a record.");
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
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_ver returns two or more records. This item should return only a record.");
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
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_ver returns two or more records. This item should return only a record.");
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
              /* If _paeseicp <> '086' */
              if (CPLib.ne(_paeseicp,"086")) {
                /* _sottotipo := 'E' */
                _sottotipo = "E";
              } else { // Else
                /* _sottotipo := 'I' */
                _sottotipo = "I";
              } // End If
              // * --- Insert into tmp_stpoperazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
              m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_ver",146,"000000F9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000F9(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.AUTOM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabicp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CAMBIO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CDATOPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODANA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODCAB2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabcp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cabdip),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODINT2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODVOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODVOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.COLLEG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CONNESBEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CONNESOPER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DATAOPE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DATAREG,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DATARETT,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DESC2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DESCINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DOCFILE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGCONT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGFRAZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGRAP2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.IDBASE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.idcauana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.IDEREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.INFORM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.MODSVOL,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.NUMPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPERAG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPERATORE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPERAZMOD,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paesecp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paeseicp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabcli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paesecli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totimp*100,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.PROV2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.RAPPORTBEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.RAPPORTO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.RESPINS,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.SEGNO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.SEGNO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.STATOREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_sottotipo,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("OPE","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOINF,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOINT2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOLEG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOOPRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totcon,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totimp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.VALUTA,"?",0,0,m_cServer)+", ";
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
            } else { // Else
              /* _paesecp := '' */
              _paesecp = "";
              /* _cabcp := '' */
              _cabcp = "";
              /* _paeseicp := '' */
              _paeseicp = "";
              /* _cabicp := '' */
              _cabicp = "";
              /* _sottotipo := 'A' */
              _sottotipo = "A";
              // * --- Insert into tmp_stpoperazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
              m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_ver",146,"000000FF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000FF(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.AUTOM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabicp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CAMBIO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CDATOPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODANA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODCAB2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabcp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cabdip),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODINT2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODVOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODVOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.COLLEG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CONNESBEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CONNESOPER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DATAOPE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DATAREG,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DATARETT,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DESC2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DESCINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DOCFILE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGCONT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGFRAZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGRAP2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.IDBASE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.idcauana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.IDEREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.INFORM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.MODSVOL,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.NUMPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPERAG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPERATORE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPERAZMOD,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paesecp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paeseicp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabcli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paesecli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totimp*100,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.PROV2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.RAPPORTBEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.RAPPORTO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.RESPINS,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.SEGNO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.SEGNO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.STATOREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_sottotipo,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("OPE","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOINF,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOINT2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOLEG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOOPRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totcon,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totimp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.VALUTA,"?",0,0,m_cServer)+", ";
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
                    /* _sara := rowPers.NOSARA */
                    _sara = rowPers.NOSARA;
                  } else { // Else
                    /* _settsint := iif(Empty(personbo->SETTSINT),'999',personbo->SETTSINT) */
                    _settsint = (CPLib.Empty(Cursor_personbo.GetString("SETTSINT"))?"999":Cursor_personbo.GetString("SETTSINT"));
                    /* _sara := mcOpeUif.NOSARA */
                    _sara = mcOpeUif.row.NOSARA;
                  } // End If
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
                  /* If _paeseicp <> '086' */
                  if (CPLib.ne(_paeseicp,"086")) {
                    /* _sottotipo := 'E' */
                    _sottotipo = "E";
                  } else { // Else
                    /* _sottotipo := 'I' */
                    _sottotipo = "I";
                  } // End If
                  // * --- Insert into tmp_stpoperazioni from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_ver",146,"00000127")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000127(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.AUTOM,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabicp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CAMBIO,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CDATOPE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODANA,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODCAB,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODCAB2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabcp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cabdip),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODDIPE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODINT2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODVOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODVOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.COLLEG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CONNESBEN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CONNESCLI,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CONNESOPER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DATAOPE,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DATAREG,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DATARETT,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DESC2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DESCCIT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DESCINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DOCFILE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGCONT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGFRAZ,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGRAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGRAP2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.IDBASE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.idcauana,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.IDEREG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.INFORM,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.MODSVOL,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.NUMPROG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPERAG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPERATORE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPERAZMOD,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPRAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.PAESE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_paesecp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_paeseicp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabcli,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_paesecli,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_totimp*100,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.PROV2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.PROVINCIA,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.RAPPORTBEN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.RAPPORTO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.RESPINS,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.SEGNO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.SEGNO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.STATOREG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_sottotipo,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("OPE","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOINF,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOINT2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOLEG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOOPRAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_totcon,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_totimp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.VALUTA,"?",0,0,m_cServer)+", ";
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
                } else { // Else
                  /* _paesecp := '' */
                  _paesecp = "";
                  /* _cabcp := '' */
                  _cabcp = "";
                  /* _paeseicp := '' */
                  _paeseicp = "";
                  /* _cabicp := '' */
                  _cabicp = "";
                  /* _sottotipo := 'A' */
                  _sottotipo = "A";
                  // * --- Insert into tmp_stpoperazioni from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_ver",146,"0000012D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000012D(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.AUTOM,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabicp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CAMBIO,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CDATOPE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODANA,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODCAB,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODCAB2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabcp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cabdip),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODDIPE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODINT2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODVOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CODVOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.COLLEG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CONNESBEN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CONNESCLI,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.CONNESOPER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DATAOPE,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DATAREG,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DATARETT,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DESC2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DESCCIT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DESCINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.DOCFILE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGCONT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGFRAZ,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGRAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.FLAGRAP2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.IDBASE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.idcauana,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.IDEREG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.INFORM,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.MODSVOL,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.NUMPROG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPERAG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPERATORE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPERAZMOD,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.OPRAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.PAESE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_paesecp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_paeseicp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabcli,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_paesecli,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_totimp*100,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.PROV2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.PROVINCIA,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.RAPPORTBEN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.RAPPORTO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.RESPINS,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.SEGNO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.SEGNO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.STATOREG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_sottotipo,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("OPE","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOINF,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOINT2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOLEG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.TIPOOPRAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_totcon,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_totimp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowOpeUif.VALUTA,"?",0,0,m_cServer)+", ";
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
      /* Cicla su operazbo e seleziona i record nel range definito */
      /* _contarow := 0 */
      _contarow = CPLib.Round(0,0);
      /* _dataoggi := _ddatini */
      _dataoggi = _ddatini;
      /* _cdataoggi := _datini */
      _cdataoggi = _datini;
      /* _oldmsg := '' */
      _oldmsg = "";
      /* _cfra := 0 */
      _cfra = CPLib.Round(0,0);
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
        SPBridge.HMCaller _h00000142;
        _h00000142 = new SPBridge.HMCaller();
        _h00000142.Set("m_cVQRList",m_cVQRList);
        _h00000142.Set("cdadata",_cdataoggi);
        if (Cursor_qbe_frauif!=null)
          Cursor_qbe_frauif.Close();
        Cursor_qbe_frauif = new VQRHolder("qbe_frauif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000142,true).GetResultSet(m_Ctx);
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
          /* _cfra := _cfra + 1 */
          _cfra = CPLib.Round(_cfra+1,0);
          /* _conta := 1 */
          _conta = CPLib.Round(1,0);
          /* _nosara := 0 */
          _nosara = CPLib.Round(0,0);
          /* _settsint := '' */
          _settsint = "";
          /* If w_storico='S' */
          if (CPLib.eqr(w_storico,"S")) {
            /* rowPers := arfn_datisog_sol_row(rowFraUif.CONNESCLI,rowFraUif.DATAREG,rowFraUif.STATOREG,rowFraUif.DATARETT) */
            rowPers = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(rowFraUif.CONNESCLI,rowFraUif.DATAREG,rowFraUif.STATOREG,rowFraUif.DATARETT);
            /* _settsint := iif(Empty(rowPers.SETSINT),'999',rowPers.SETSINT) */
            _settsint = (CPLib.Empty(rowPers.SETSINT)?"999":rowPers.SETSINT);
            /* _sara := rowPers.NOSARA */
            _sara = rowPers.NOSARA;
          } else { // Else
            /* _settsint := iif(Empty(rowFraUif.SETTSINT),'999',rowFraUif.SETTSINT) */
            _settsint = (CPLib.Empty(rowFraUif.SETTSINT)?"999":rowFraUif.SETTSINT);
            /* _sara := rowFraUif.NOSARA */
            _sara = rowFraUif.NOSARA;
          } // End If
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
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_discouic_ver returns two or more records. This item should return only a record.");
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
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_ver returns two or more records. This item should return only a record.");
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
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_ver returns two or more records. This item should return only a record.");
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
              /* If _paeseicp <> '086' */
              if (CPLib.ne(_paeseicp,"086")) {
                /* _sottotipo := 'E' */
                _sottotipo = "E";
              } else { // Else
                /* _sottotipo := 'I' */
                _sottotipo = "I";
              } // End If
              // * --- Insert into tmp_stpoperazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
              m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_ver",146,"00000196")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000196(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.AUTOM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabicp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CAMBIO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CDATOPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODANA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODCAB2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabcp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cabdip),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODINT2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODVOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODVOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.COLLEG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CONNESBEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CONNESOPER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DATAOPE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DATAREG,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DATARETT,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DESC2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DESCINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DOCFILE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGCONT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGFRAZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGRAP2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.IDBASE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.idcauana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.IDEREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.INFORM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.MODSVOL,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.NUMPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPERAG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPERATORE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPERAZMOD,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paesecp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paeseicp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabcli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paesecli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totimp*100,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.PROV2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.RAPPORTBEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.RAPPORTO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.RESPINS,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.SEGNO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.SEGNO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.STATOREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_sottotipo,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("FRZ","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOINF,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOINT2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOLEG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOOPRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totcon,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totimp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.VALUTA,"?",0,0,m_cServer)+", ";
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
            } else { // Else
              /* _paesecp := '' */
              _paesecp = "";
              /* _cabcp := '' */
              _cabcp = "";
              /* _paeseicp := '' */
              _paeseicp = "";
              /* _cabicp := '' */
              _cabicp = "";
              /* _sottotipo := 'A' */
              _sottotipo = "A";
              // * --- Insert into tmp_stpoperazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
              m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_ver",146,"0000019C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000019C(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.AUTOM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabicp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CAMBIO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CDATOPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODANA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODCAB2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabcp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cabdip),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODINT2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODVOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODVOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.COLLEG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CONNESBEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CONNESOPER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DATAOPE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DATAREG,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DATARETT,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DESC2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DESCINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DOCFILE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGCONT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGFRAZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGRAP2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.IDBASE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.idcauana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.IDEREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.INFORM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.MODSVOL,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.NUMPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPERAG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPERATORE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPERAZMOD,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paesecp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paeseicp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabcli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paesecli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totimp*100,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.PROV2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.RAPPORTBEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.RAPPORTO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.RESPINS,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.SEGNO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.SEGNO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.STATOREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_sottotipo,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("FRZ","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOINF,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOINT2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOLEG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOOPRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totcon,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totimp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.VALUTA,"?",0,0,m_cServer)+", ";
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
                    /* _settsint := iif(Empty(rowPers.SETSINT),'999',rowPers.SETSINT) */
                    _settsint = (CPLib.Empty(rowPers.SETSINT)?"999":rowPers.SETSINT);
                    /* _sara := rowPers.NOSARA */
                    _sara = rowPers.NOSARA;
                  } else { // Else
                    /* _settsint := iif(Empty(personbo->SETTSINT),'999',personbo->SETTSINT) */
                    _settsint = (CPLib.Empty(Cursor_personbo.GetString("SETTSINT"))?"999":Cursor_personbo.GetString("SETTSINT"));
                    /* _sara := mcFraUif.NOSARA */
                    _sara = mcFraUif.row.NOSARA;
                  } // End If
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
                  /* If _paeseicp <> '086' */
                  if (CPLib.ne(_paeseicp,"086")) {
                    /* _sottotipo := 'E' */
                    _sottotipo = "E";
                  } else { // Else
                    /* _sottotipo := 'I' */
                    _sottotipo = "I";
                  } // End If
                  // * --- Insert into tmp_stpoperazioni from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_ver",146,"000001C4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001C4(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.AUTOM,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabicp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CAMBIO,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CDATOPE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODANA,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODCAB,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODCAB2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabcp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cabdip),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODDIPE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODINT2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODVOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODVOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.COLLEG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CONNESBEN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CONNESCLI,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CONNESOPER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DATAOPE,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DATAREG,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DATARETT,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DESC2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DESCCIT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DESCINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DOCFILE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGCONT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGFRAZ,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGRAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGRAP2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.IDBASE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.idcauana,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.IDEREG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.INFORM,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.MODSVOL,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.NUMPROG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPERAG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPERATORE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPERAZMOD,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPRAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.PAESE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_paesecp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_paeseicp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabcli,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_paesecli,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_totimp*100,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.PROV2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.PROVINCIA,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.RAPPORTBEN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.RAPPORTO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.RESPINS,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.SEGNO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.SEGNO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.STATOREG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_sottotipo,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("FRZ","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOINF,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOINT2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOLEG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOOPRAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_totcon,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_totimp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.VALUTA,"?",0,0,m_cServer)+", ";
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
                } else { // Else
                  /* _paesecp := '' */
                  _paesecp = "";
                  /* _cabcp := '' */
                  _cabcp = "";
                  /* _paeseicp := '' */
                  _paeseicp = "";
                  /* _cabicp := '' */
                  _cabicp = "";
                  /* _sottotipo := 'A' */
                  _sottotipo = "A";
                  // * --- Insert into tmp_stpoperazioni from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_ver",146,"000001CA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001CA(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_abicab))?"000000000000":_abicab),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.AUTOM,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabicp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CAMBIO,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CDATOPE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODANA,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODCAB,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODCAB2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabcp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cabdip),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODDIPE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODINT2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODVOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CODVOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.COLLEG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CONNESBEN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CONNESCLI,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.CONNESOPER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DATAOPE,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DATAREG,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DATARETT,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DESC2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DESCCIT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DESCINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.DOCFILE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGCONT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGFRAZ,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGLIRE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGRAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.FLAGRAP2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.IDBASE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.idcauana,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.IDEREG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.INFORM,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.MODSVOL,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.NUMPROG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPERAG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPERATORE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPERAZMOD,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.OPRAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.PAESE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_paesecp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_paeseicp,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cabcli,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_paesecli,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_totimp*100,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.PROV2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.PROVINCIA,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.RAPPORTBEN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.RAPPORTO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.RESPINS,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.SEGNO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.SEGNO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.STATOREG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_sottotipo,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("FRZ","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOINF,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOINT2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOLEG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.TIPOOPRAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_totcon,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_totimp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowFraUif.VALUTA,"?",0,0,m_cServer)+", ";
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
      /* If _cfra=0 */
      if (CPLib.eqr(_cfra,0)) {
        /* gMsgProc := gMsgProc + NL + 'Non sono presenti dati da elaborare nel file Frazionate' + NL */
        gMsgProc = gMsgProc+"\n"+"Non sono presenti dati da elaborare nel file Frazionate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + NL + 'Sono stati elaborati '+LRTrim(Str(_cfra,10,0))+' record del file Frazionate' + NL */
        gMsgProc = gMsgProc+"\n"+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_cfra,10,0))+" record del file Frazionate"+"\n";
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
    CPResultSet Cursor_qbe_kpeuif=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_clientisara=null;
    CPResultSet Cursor_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla su operazbo e seleziona i record nel range definito */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni Società Quotate' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni Società Quotate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _ckpe := 0 */
      _ckpe = CPLib.Round(0,0);
      // * --- Select from qbe_kpeuif
      SPBridge.HMCaller _h000001D4;
      _h000001D4 = new SPBridge.HMCaller();
      _h000001D4.Set("m_cVQRList",m_cVQRList);
      _h000001D4.Set("cdadata",_datini);
      _h000001D4.Set("c_adata",_datfin);
      if (Cursor_qbe_kpeuif!=null)
        Cursor_qbe_kpeuif.Close();
      Cursor_qbe_kpeuif = new VQRHolder("qbe_kpeuif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001D4,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_kpeuif.Eof())) {
        /* _ckpe := _ckpe + 1 */
        _ckpe = CPLib.Round(_ckpe+1,0);
        /* _contaop := _contaop + 1 */
        _contaop = CPLib.Round(_contaop+1,0);
        /* gMsgImp := 'Elaboro Operazione N. '+ LRTrim(Str(_contaop,10,0)) // Messaggio Import */
        gMsgImp = "Elaboro Operazione N. "+CPLib.LRTrim(CPLib.Str(_contaop,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _coddip := "" */
        _coddip = "";
        /* _abicab := iif(Empty(qbe_kpeuif->ABICABSARA),'000000000000',qbe_kpeuif->ABICABSARA) */
        _abicab = (CPLib.Empty(Cursor_qbe_kpeuif.GetString("ABICABSARA"))?"000000000000":Cursor_qbe_kpeuif.GetString("ABICABSARA"));
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
          /* _coddip := LRTrim(qbe_kpeuif->CODDIPE) */
          _coddip = CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("CODDIPE"));
          /* _cabdip := LRTrim(qbe_kpeuif->CABDIP) */
          _cabdip = CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("CABDIP"));
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
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_discouic_ver returns two or more records. This item should return only a record.");
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
        // * --- Select from clientisara
        m_cServer = m_Ctx.GetServer("clientisara");
        m_cPhName = m_Ctx.GetPhName("clientisara");
        if (Cursor_clientisara!=null)
          Cursor_clientisara.Close();
        Cursor_clientisara = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientisara")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_clientisara.Eof())) {
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          Cursor_clientisara.Next();
        }
        m_cConnectivityError = Cursor_clientisara.ErrorMessage();
        Cursor_clientisara.Close();
        // * --- End Select
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _paesecli := qbe_kpeuif->PAESECLI */
        _paesecli = Cursor_qbe_kpeuif.GetString("PAESECLI");
        /* If _paesecli='086' */
        if (CPLib.eqr(_paesecli,"086")) {
          /* _cabcli := iif(not(Empty(qbe_kpeuif->CABCLI)),qbe_kpeuif->CABCLI,qbe_kpeuif->CODCAB2) */
          _cabcli = ( ! (CPLib.Empty(Cursor_qbe_kpeuif.GetString("CABCLI")))?Cursor_qbe_kpeuif.GetString("CABCLI"):Cursor_qbe_kpeuif.GetString("CODCAB2"));
        } else { // Else
          /* _cabcli := '' */
          _cabcli = "";
        } // End If
        /* _settsint := iif(Empty(qbe_kpeuif->SETTSINT),'999',qbe_kpeuif->SETTSINT) */
        _settsint = (CPLib.Empty(Cursor_qbe_kpeuif.GetString("SETTSINT"))?"999":Cursor_qbe_kpeuif.GetString("SETTSINT"));
        /* If At(LRTrim(qbe_kpeuif->CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
        if (CPLib.gt(CPLib.At(CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("CODVOC")),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
          /* _paesecp := LRTrim(qbe_kpeuif->C_STA) */
          _paesecp = CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("C_STA"));
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
          /* If _paeseicp <> '086' */
          if (CPLib.ne(_paeseicp,"086")) {
            /* _sottotipo := 'E' */
            _sottotipo = "E";
          } else { // Else
            /* _sottotipo := 'I' */
            _sottotipo = "I";
          } // End If
          // * --- Insert into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_ver",146,"00000204")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000204(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_abicab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabicp,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabcp,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cabdip),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATARETT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_paesecp,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_paeseicp,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabcli,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_paesecli,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/_conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_sottotipo,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("KPE","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
        } else { // Else
          /* _paesecp := '' */
          _paesecp = "";
          /* _cabcp := '' */
          _cabcp = "";
          /* _paeseicp := '' */
          _paeseicp = "";
          /* _cabicp := '' */
          _cabicp = "";
          /* _sottotipo := 'A' */
          _sottotipo = "A";
          // * --- Insert into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_ver",146,"0000020A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000020A(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATARETT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("KPE","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_sottotipo,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_abicab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cabdip),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_paesecli,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabcli,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_paesecp,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabcp,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_paeseicp,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabicp,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/_conta,"?",0,0)+", ";
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
              /* _paesecp := LRTrim(qbe_kpeuif->C_STA) */
              _paesecp = CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("C_STA"));
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
              /* If _paeseicp <> '086' */
              if (CPLib.ne(_paeseicp,"086")) {
                /* _sottotipo := 'E' */
                _sottotipo = "E";
              } else { // Else
                /* _sottotipo := 'I' */
                _sottotipo = "I";
              } // End If
              // * --- Insert into tmp_stpoperazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
              m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_ver",146,"00000222")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000222(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientisara.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("KPE","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_sottotipo,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_abicab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cabdip),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paesecli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabcli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paesecp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabcp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paeseicp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabicp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/_conta,"?",0,0)+", ";
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
            } else { // Else
              /* _paesecp := '' */
              _paesecp = "";
              /* _cabcp := '' */
              _cabcp = "";
              /* _paeseicp := '' */
              _paeseicp = "";
              /* _cabicp := '' */
              _cabicp = "";
              /* _sottotipo := 'A' */
              _sottotipo = "A";
              // * --- Insert into tmp_stpoperazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
              m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_ver",146,"00000228")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000228(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientisara.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("KPE","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_sottotipo,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_abicab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cabdip),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paesecli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabcli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_settsint,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paesecp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabcp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_paeseicp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cabicp,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/_conta,"?",0,0)+", ";
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
      /* If _ckpe=0 */
      if (CPLib.eqr(_ckpe,0)) {
        /* gMsgProc := gMsgProc + 'Non sono presenti dati da elaborare nel file Operazioni Società Quotate' + NL */
        gMsgProc = gMsgProc+"Non sono presenti dati da elaborare nel file Operazioni Società Quotate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(_ckpe,10,0))+' record del file Operazioni Società Quotate' + NL */
        gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_ckpe,10,0))+" record del file Operazioni Società Quotate"+"\n";
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
  void _init_() {
  }
  public String RunAsync(String p_pTipo,java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,String p_w_tipocr,String p_w_codcr,String p_w_flgfrazionate,String p_w_storico) {
    pTipo = p_pTipo;
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_tipocr = p_w_tipocr;
    w_codcr = p_w_codcr;
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
  public double Run(String p_pTipo,java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,String p_w_tipocr,String p_w_codcr,String p_w_flgfrazionate,String p_w_storico) {
    pTipo = p_pTipo;
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_tipocr = p_w_tipocr;
    w_codcr = p_w_codcr;
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
  public static arrt_discouic_verR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_discouic_verR(p_Ctx, p_Caller);
  }
  public static arrt_discouic_verR Make(CPContext p_Ctx) {
    return new arrt_discouic_verR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    w_DaDatOpe = CPLib.NullDate();
    w_ADatOpe = CPLib.NullDate();
    w_tipocr = CPLib.Space(2);
    w_codcr = CPLib.Space(11);
    w_flgfrazionate = CPLib.Space(1);
    w_storico = CPLib.Space(1);
    _tipcentro = CPLib.Space(2);
    _sottotipo = CPLib.Space(1);
    _codcentro = CPLib.Space(11);
    _settsint = CPLib.Space(3);
    _appconta = 0;
    _totconta = 0;
    _conta = 0;
    _contaw = 0;
    _contaop = 0;
    _cope = 0;
    _cfra = 0;
    _ckpe = 0;
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
    _ita1 = "";
    _ita2 = "";
    _ext1 = "";
    _ext2 = "";
    _alt1 = "";
    _alt2 = "";
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
    _nosara = 0;
    _sara = CPLib.Space(1);
    _autoic = CPLib.Space(1);
    _pqtotale = 0;
    _dipbase = CPLib.Space(6);
    _dipcab = CPLib.Space(6);
    _dipabicab = CPLib.Space(12);
    mcTmp = new MemoryCursor_tmp_invio_xbrl();
    mcIta = new MemoryCursor_tmp_dischebo_xbrl_ita();
    mcExt = new MemoryCursor_tmp_dischebo_xbrl_ext();
    mcAlt = new MemoryCursor_tmp_dischebo_xbrl_alt();
    rowTmp = new MemoryCursorRow_tmp_invio_xbrl();
    mcTxt1 = new MemoryCursor_mctesto_mcrdef();
    mcTxt2 = new MemoryCursor_mctesto_mcrdef();
    mcOpeUif = new MemoryCursor_qbe_opeuif_vqr();
    mcFraUif = new MemoryCursor_qbe_frauif_vqr();
    rowPers = new MemoryCursorRow_mcsoggettiall1_mcrdef();
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
  // ENTITY_VQR: ,qbe_tab_mmc,qbe_tab_mmc,qbe_opeuif,qbe_frauif,qbe_kpeuif,
  public static final String m_cVQRList = ",qbe_tab_mmc,qbe_tab_mmc,qbe_opeuif,qbe_frauif,qbe_kpeuif,";
  // ENTITY_BATCHES: ,arfn_datesum,arfn_datisog_sol_row,arfn_fdate,arfn_fdatetime,arrt_discouic_ver,
  public static final String i_InvokedRoutines = ",arfn_datesum,arfn_datisog_sol_row,arfn_fdate,arfn_fdatetime,arrt_discouic_ver,";
  public static String[] m_cRunParameterNames={"pTipo","w_DaDatOpe","w_ADatOpe","w_tipocr","w_codcr","w_flgfrazionate","w_storico"};
  protected static String GetFieldsName_00000091(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ABICABDIP,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODCABCP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTDIP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CODVOCAGG,";
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
    p_cSql = p_cSql+"FLAGLIREAGG,";
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
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"PAESEICP,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SEGNOAGG,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"SUBTYP,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000FF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ABICABDIP,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODCABCP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTDIP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CODVOCAGG,";
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
    p_cSql = p_cSql+"FLAGLIREAGG,";
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
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"PAESEICP,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SEGNOAGG,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"SUBTYP,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000127(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ABICABDIP,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODCABCP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTDIP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CODVOCAGG,";
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
    p_cSql = p_cSql+"FLAGLIREAGG,";
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
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"PAESEICP,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SEGNOAGG,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"SUBTYP,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ABICABDIP,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODCABCP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTDIP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CODVOCAGG,";
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
    p_cSql = p_cSql+"FLAGLIREAGG,";
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
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"PAESEICP,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SEGNOAGG,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"SUBTYP,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000196(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ABICABDIP,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODCABCP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTDIP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CODVOCAGG,";
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
    p_cSql = p_cSql+"FLAGLIREAGG,";
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
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"PAESEICP,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SEGNOAGG,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"SUBTYP,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000019C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ABICABDIP,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODCABCP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTDIP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CODVOCAGG,";
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
    p_cSql = p_cSql+"FLAGLIREAGG,";
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
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"PAESEICP,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SEGNOAGG,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"SUBTYP,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001C4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ABICABDIP,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODCABCP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTDIP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CODVOCAGG,";
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
    p_cSql = p_cSql+"FLAGLIREAGG,";
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
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"PAESEICP,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SEGNOAGG,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"SUBTYP,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001CA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ABICABDIP,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODCABCP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTDIP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CODVOCAGG,";
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
    p_cSql = p_cSql+"FLAGLIREAGG,";
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
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"PAESEICP,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SEGNOAGG,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"SUBTYP,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000204(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ABICABDIP,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODCABCP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTDIP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CODVOCAGG,";
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
    p_cSql = p_cSql+"FLAGLIREAGG,";
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
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"PAESEICP,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SEGNOAGG,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"SUBTYP,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000020A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000222(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000228(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
}
