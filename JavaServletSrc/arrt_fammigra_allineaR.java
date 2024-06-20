// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_fammigra_allineaR implements CallerWithObjs {
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
  public String m_cPhName_famesiti;
  public String m_cServer_famesiti;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_famesitid;
  public String m_cServer_famesitid;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tmp_esitierr;
  public String m_cServer_tmp_esitierr;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
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
  public java.sql.Date w_dadata;
  public java.sql.Date w_a_data;
  public String gMsgImp;
  public String gMsgProc;
  public String gDescAzi;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _cicli;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public double conta;
  public String _errore;
  public double _trovato;
  public double _findsog;
  public String _rapporto;
  public String _ndgsog;
  public String _codfisc;
  public String _paese;
  public String _paeseres;
  public double _contaerr;
  public String _valage;
  public double _noprot;
  public String _stringa1;
  public String _stringa2;
  public java.sql.Date _dataini;
  public java.sql.Date _datafin;
  public String _datiage;
  public String _datimit;
  public String _origine;
  public String _ruolo;
  public String cReport;
  public String _famcodice;
  public String _raporig;
  public String _check;
  public String _sesso;
  public String _nascom;
  public String _nassta;
  public java.sql.Date _datamax;
  public java.sql.Date _maxope;
  public java.sql.Date _datini;
  public java.sql.Date _datfin;
  public boolean _luonas;
  public double _intaui;
  public double _delaui;
  public double _titaui;
  public double _garaui;
  public double _intage;
  public double _delage;
  public double _titage;
  public double _garage;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_fammigra_allineaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_fammigra_allinea",m_Caller);
    m_cPhName_famesiti = p_ContextObject.GetPhName("famesiti");
    if (m_cPhName_famesiti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_famesiti = m_cPhName_famesiti+" "+m_Ctx.GetWritePhName("famesiti");
    }
    m_cServer_famesiti = p_ContextObject.GetServer("famesiti");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_famesitid = p_ContextObject.GetPhName("famesitid");
    if (m_cPhName_famesitid.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_famesitid = m_cPhName_famesitid+" "+m_Ctx.GetWritePhName("famesitid");
    }
    m_cServer_famesitid = p_ContextObject.GetServer("famesitid");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_esitierr")) {
      m_cPhName_tmp_esitierr = p_ContextObject.GetPhName("tmp_esitierr");
      if (m_cPhName_tmp_esitierr.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_esitierr = m_cPhName_tmp_esitierr+" "+m_Ctx.GetWritePhName("tmp_esitierr");
      }
      m_cServer_tmp_esitierr = p_ContextObject.GetServer("tmp_esitierr");
    }
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
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
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      return _contacicli;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("_trovato",p_cVarName)) {
      return _trovato;
    }
    if (CPLib.eqr("_findsog",p_cVarName)) {
      return _findsog;
    }
    if (CPLib.eqr("_contaerr",p_cVarName)) {
      return _contaerr;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      return _noprot;
    }
    if (CPLib.eqr("_intaui",p_cVarName)) {
      return _intaui;
    }
    if (CPLib.eqr("_delaui",p_cVarName)) {
      return _delaui;
    }
    if (CPLib.eqr("_titaui",p_cVarName)) {
      return _titaui;
    }
    if (CPLib.eqr("_garaui",p_cVarName)) {
      return _garaui;
    }
    if (CPLib.eqr("_intage",p_cVarName)) {
      return _intage;
    }
    if (CPLib.eqr("_delage",p_cVarName)) {
      return _delage;
    }
    if (CPLib.eqr("_titage",p_cVarName)) {
      return _titage;
    }
    if (CPLib.eqr("_garage",p_cVarName)) {
      return _garage;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_fammigra_allinea";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
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
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_ndgsog",p_cVarName)) {
      return _ndgsog;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      return _codfisc;
    }
    if (CPLib.eqr("_paese",p_cVarName)) {
      return _paese;
    }
    if (CPLib.eqr("_paeseres",p_cVarName)) {
      return _paeseres;
    }
    if (CPLib.eqr("_valage",p_cVarName)) {
      return _valage;
    }
    if (CPLib.eqr("_stringa1",p_cVarName)) {
      return _stringa1;
    }
    if (CPLib.eqr("_stringa2",p_cVarName)) {
      return _stringa2;
    }
    if (CPLib.eqr("_datiage",p_cVarName)) {
      return _datiage;
    }
    if (CPLib.eqr("_datimit",p_cVarName)) {
      return _datimit;
    }
    if (CPLib.eqr("_origine",p_cVarName)) {
      return _origine;
    }
    if (CPLib.eqr("_ruolo",p_cVarName)) {
      return _ruolo;
    }
    if (CPLib.eqr("cReport",p_cVarName)) {
      return cReport;
    }
    if (CPLib.eqr("_famcodice",p_cVarName)) {
      return _famcodice;
    }
    if (CPLib.eqr("_raporig",p_cVarName)) {
      return _raporig;
    }
    if (CPLib.eqr("_check",p_cVarName)) {
      return _check;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      return _sesso;
    }
    if (CPLib.eqr("_nascom",p_cVarName)) {
      return _nascom;
    }
    if (CPLib.eqr("_nassta",p_cVarName)) {
      return _nassta;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
    }
    if (CPLib.eqr("a_data",p_cVarName)) {
      return w_a_data;
    }
    if (CPLib.eqr("_dataini",p_cVarName)) {
      return _dataini;
    }
    if (CPLib.eqr("_datafin",p_cVarName)) {
      return _datafin;
    }
    if (CPLib.eqr("_datamax",p_cVarName)) {
      return _datamax;
    }
    if (CPLib.eqr("_maxope",p_cVarName)) {
      return _maxope;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      return _datfin;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_luonas",p_cVarName)) {
      return _luonas;
    }
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
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("_trovato",p_cVarName)) {
      _trovato = value;
      return;
    }
    if (CPLib.eqr("_findsog",p_cVarName)) {
      _findsog = value;
      return;
    }
    if (CPLib.eqr("_contaerr",p_cVarName)) {
      _contaerr = value;
      return;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      _noprot = value;
      return;
    }
    if (CPLib.eqr("_intaui",p_cVarName)) {
      _intaui = value;
      return;
    }
    if (CPLib.eqr("_delaui",p_cVarName)) {
      _delaui = value;
      return;
    }
    if (CPLib.eqr("_titaui",p_cVarName)) {
      _titaui = value;
      return;
    }
    if (CPLib.eqr("_garaui",p_cVarName)) {
      _garaui = value;
      return;
    }
    if (CPLib.eqr("_intage",p_cVarName)) {
      _intage = value;
      return;
    }
    if (CPLib.eqr("_delage",p_cVarName)) {
      _delage = value;
      return;
    }
    if (CPLib.eqr("_titage",p_cVarName)) {
      _titage = value;
      return;
    }
    if (CPLib.eqr("_garage",p_cVarName)) {
      _garage = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
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
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_ndgsog",p_cVarName)) {
      _ndgsog = value;
      return;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      _codfisc = value;
      return;
    }
    if (CPLib.eqr("_paese",p_cVarName)) {
      _paese = value;
      return;
    }
    if (CPLib.eqr("_paeseres",p_cVarName)) {
      _paeseres = value;
      return;
    }
    if (CPLib.eqr("_valage",p_cVarName)) {
      _valage = value;
      return;
    }
    if (CPLib.eqr("_stringa1",p_cVarName)) {
      _stringa1 = value;
      return;
    }
    if (CPLib.eqr("_stringa2",p_cVarName)) {
      _stringa2 = value;
      return;
    }
    if (CPLib.eqr("_datiage",p_cVarName)) {
      _datiage = value;
      return;
    }
    if (CPLib.eqr("_datimit",p_cVarName)) {
      _datimit = value;
      return;
    }
    if (CPLib.eqr("_origine",p_cVarName)) {
      _origine = value;
      return;
    }
    if (CPLib.eqr("_ruolo",p_cVarName)) {
      _ruolo = value;
      return;
    }
    if (CPLib.eqr("cReport",p_cVarName)) {
      cReport = value;
      return;
    }
    if (CPLib.eqr("_famcodice",p_cVarName)) {
      _famcodice = value;
      return;
    }
    if (CPLib.eqr("_raporig",p_cVarName)) {
      _raporig = value;
      return;
    }
    if (CPLib.eqr("_check",p_cVarName)) {
      _check = value;
      return;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      _sesso = value;
      return;
    }
    if (CPLib.eqr("_nascom",p_cVarName)) {
      _nascom = value;
      return;
    }
    if (CPLib.eqr("_nassta",p_cVarName)) {
      _nassta = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
    if (CPLib.eqr("a_data",p_cVarName)) {
      w_a_data = value;
      return;
    }
    if (CPLib.eqr("_dataini",p_cVarName)) {
      _dataini = value;
      return;
    }
    if (CPLib.eqr("_datafin",p_cVarName)) {
      _datafin = value;
      return;
    }
    if (CPLib.eqr("_datamax",p_cVarName)) {
      _datamax = value;
      return;
    }
    if (CPLib.eqr("_maxope",p_cVarName)) {
      _maxope = value;
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
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("_luonas",p_cVarName)) {
      _luonas = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Pag_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_famesiti_minmax=null;
    CPResultSet Cursor_qbe_famesiti_migra_sel=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_dadata Date */
      /* w_a_data Date */
      /* gMsgImp Memo // Messaggio Import */
      /* gMsgProc Memo // Messaggio Import */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* conta Numeric(10, 0) */
      /* _errore Memo */
      /* _trovato Numeric(1, 0) */
      /* _findsog Numeric(1, 0) */
      /* _rapporto Char(25) */
      /* _ndgsog Char(16) */
      /* _codfisc Char(16) */
      /* _paese Char(3) */
      /* _paeseres Char(40) */
      /* _contaerr Numeric(10, 0) */
      /* _valage Char(60) */
      /* _noprot Numeric(1, 0) */
      /* _stringa1 Char(128) */
      /* _stringa2 Char(128) */
      /* _dataini Date */
      /* _datafin Date */
      /* _datiage Memo */
      /* _datimit Memo */
      /* _origine Char(1) */
      /* _ruolo Char(1) */
      /* cReport Char(20) */
      /* _famcodice Char(50) */
      /* _raporig Char(25) */
      /* _check Char(4) */
      /* _sesso Char(1) */
      /* _nascom Char(40) */
      /* _nassta Char(40) */
      /* _datamax Date */
      /* _maxope Date */
      /* _datini Date */
      /* _datfin Date */
      /* _luonas Bool */
      /* _intaui Numeric(3, 0) */
      /* _delaui Numeric(3, 0) */
      /* _titaui Numeric(3, 0) */
      /* _garaui Numeric(3, 0) */
      /* _intage Numeric(3, 0) */
      /* _delage Numeric(3, 0) */
      /* _titage Numeric(3, 0) */
      /* _garage Numeric(3, 0) */
      /* _datamax := NullDate() */
      _datamax = CPLib.NullDate();
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAINTER  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _datamax := intermbo->DATAINTER */
        _datamax = Cursor_intermbo.GetDate("DATAINTER");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _maxope := arfn_fammigra_datamax(_datamax) */
      _maxope = arfn_fammigra_datamaxR.Make(m_Ctx,this).Run(_datamax);
      // * --- Drop temporary table tmp_esitierr
      if (m_Ctx.IsSharedTemp("tmp_esitierr")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_esitierr")) {
          m_cServer = m_Ctx.GetServer("tmp_esitierr");
          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_esitierr");
      }
      // * --- Create temporary table tmp_esitierr
      if (m_Ctx.IsSharedTemp("tmp_esitierr")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_esitierr")) {
          m_cServer = m_Ctx.GetServer("tmp_esitierr");
          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_esitierr");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_esitierr");
      if ( ! (m_Ctx.IsSharedTemp("tmp_esitierr"))) {
        m_cServer = m_Ctx.GetServer("tmp_esitierr");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_esitierr",m_cServer,"proto")),m_cPhName,"tmp_esitierr",m_Ctx);
      }
      m_cPhName_tmp_esitierr = m_cPhName;
      /* gMsgProc := 'Ora Inizio Esame Famiglie: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = "Ora Inizio Esame Famiglie: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000044status;
      nTry00000044status = m_Sql.GetTransactionStatus();
      String cTry00000044msg;
      cTry00000044msg = m_Sql.TransactionErrorMessage();
      try {
        /* _contaerr := 0 */
        _contaerr = CPLib.Round(0,0);
        /* _max := 0 */
        _max = CPLib.Round(0,0);
        /* _min := 0 */
        _min = CPLib.Round(0,0);
        /* _tot := 0 */
        _tot = CPLib.Round(0,0);
        // * --- Select from qbe_famesiti_minmax
        SPBridge.HMCaller _h0000004A;
        _h0000004A = new SPBridge.HMCaller();
        _h0000004A.Set("m_cVQRList",m_cVQRList);
        _h0000004A.Set("dadata",w_dadata);
        _h0000004A.Set("a_data",w_a_data);
        if (Cursor_qbe_famesiti_minmax!=null)
          Cursor_qbe_famesiti_minmax.Close();
        Cursor_qbe_famesiti_minmax = new VQRHolder("qbe_famesiti_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000004A,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_famesiti_minmax.Eof())) {
          /* _max := qbe_famesiti_minmax->MAXCONTA */
          _max = CPLib.Round(Cursor_qbe_famesiti_minmax.GetDouble("MAXCONTA"),0);
          /* _min := qbe_famesiti_minmax->MINCONTA */
          _min = CPLib.Round(Cursor_qbe_famesiti_minmax.GetDouble("MINCONTA"),0);
          /* _tot := qbe_famesiti_minmax->TOTCONTA */
          _tot = CPLib.Round(Cursor_qbe_famesiti_minmax.GetDouble("TOTCONTA"),0);
          Cursor_qbe_famesiti_minmax.Next();
        }
        m_cConnectivityError = Cursor_qbe_famesiti_minmax.ErrorMessage();
        Cursor_qbe_famesiti_minmax.Close();
        // * --- End Select
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
          /* _cicli := iif(Mod(_tot,1000) <> 0,Int(_tot/1000) + 1,Int(_tot/1000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_tot,1000),0)?CPLib.Int(_tot/1000)+1:CPLib.Int(_tot/1000)),0);
        } // End If
        /* _contacicli := 1 */
        _contacicli = CPLib.Round(1,0);
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* _contaerr := 0 */
        _contaerr = CPLib.Round(0,0);
        /* While _contacicli<=_cicli */
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
          /* If _top>=_min */
          if (CPLib.ge(_top,_min)) {
            // * --- Select from qbe_famesiti_migra_sel
            SPBridge.HMCaller _h00000063;
            _h00000063 = new SPBridge.HMCaller();
            _h00000063.Set("m_cVQRList",m_cVQRList);
            _h00000063.Set("_bottom",_bottom);
            _h00000063.Set("_top",_top);
            _h00000063.Set("dadata",w_dadata);
            _h00000063.Set("a_data",w_a_data);
            if (Cursor_qbe_famesiti_migra_sel!=null)
              Cursor_qbe_famesiti_migra_sel.Close();
            Cursor_qbe_famesiti_migra_sel = new VQRHolder("qbe_famesiti_migra_sel",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000063,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_famesiti_migra_sel.Eof())) {
              /* _famcodice := qbe_famesiti_migra_sel->FAMCODICE */
              _famcodice = Cursor_qbe_famesiti_migra_sel.GetString("FAMCODICE");
              /* _errore := '' */
              _errore = "";
              /* _trovato := 0 */
              _trovato = CPLib.Round(0,0);
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* gMsgImp := 'Sono state elaborate '+LRTrim(Str(conta,10,0))+' famiglie su '+ LRTrim(Str(_tot,10,0)) // Messaggio Import */
              gMsgImp = "Sono state elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" famiglie su "+CPLib.LRTrim(CPLib.Str(_tot,10,0));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* If qbe_famesiti_migra_sel->FAMTIPORAP='98' */
              if (CPLib.eqr(Cursor_qbe_famesiti_migra_sel.GetString("FAMTIPORAP"),"98")) {
                /* _ndgsog := '' */
                _ndgsog = "";
                // * --- Read from opextrbo
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                m_cSql = "";
                m_cSql = m_cSql+"UNIQUER="+CPSql.SQLValueAdapter(CPLib.ToSQL(_famcodice,"C",50,0,m_cServer),m_cServer,_famcodice);
                if (m_Ctx.IsSharedTemp("opextrbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("COLLEG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _ndgsog = Read_Cursor.GetString("COLLEG");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_fammigra_allinea returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _ndgsog = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(_ndgsog) */
                if (CPLib.Empty(_ndgsog)) {
                  /* Case At('2011',_famcodice) > 0 */
                  if (CPLib.gt(CPLib.At("2011",_famcodice),0)) {
                    /* _contaerr := _contaerr + 1 */
                    _contaerr = CPLib.Round(_contaerr+1,0);
                    /* _ndgsog := LRTrim(Substr(_famcodice,18,16)) */
                    _ndgsog = CPLib.LRTrim(CPLib.Substr(_famcodice,18,16));
                    /* gMsgImp := 'Allineo famiglia con NDG: '+_ndgsog // Messaggio Import */
                    gMsgImp = "Allineo famiglia con NDG: "+_ndgsog;
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                    // * --- Write into opextrbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("opextrbo");
                    m_cPhName = m_Ctx.GetPhName("opextrbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_allinea",185,"00000071")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(_famcodice,"C",50,0,m_cServer)+", ";
                    m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer),m_cServer,_ndgsog)+"";
                    m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL("2011","?",0,0,m_cServer),m_cServer,"2011")+"";
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
                    /* Case At('2012',_famcodice) > 0 */
                  } else if (CPLib.gt(CPLib.At("2012",_famcodice),0)) {
                    /* _contaerr := _contaerr + 1 */
                    _contaerr = CPLib.Round(_contaerr+1,0);
                    /* _ndgsog := LRTrim(Substr(_famcodice,18,16)) */
                    _ndgsog = CPLib.LRTrim(CPLib.Substr(_famcodice,18,16));
                    /* gMsgImp := 'Allineo famiglia con NDG: '+_ndgsog // Messaggio Import */
                    gMsgImp = "Allineo famiglia con NDG: "+_ndgsog;
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                    // * --- Write into opextrbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("opextrbo");
                    m_cPhName = m_Ctx.GetPhName("opextrbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_allinea",185,"00000075")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(_famcodice,"C",50,0,m_cServer)+", ";
                    m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer),m_cServer,_ndgsog)+"";
                    m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL("2012","?",0,0,m_cServer),m_cServer,"2012")+"";
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
                    /* Case At('2013',_famcodice) > 0 */
                  } else if (CPLib.gt(CPLib.At("2013",_famcodice),0)) {
                    /* Case At('2014',_famcodice) > 0 */
                  } else if (CPLib.gt(CPLib.At("2014",_famcodice),0)) {
                    /* Case At('2015',_famcodice) > 0 */
                  } else if (CPLib.gt(CPLib.At("2015",_famcodice),0)) {
                    /* _valage := Substr(_famcodice,16) */
                    _valage = CPLib.Substr(_famcodice,16);
                    /* _contaerr := _contaerr + 1 */
                    _contaerr = CPLib.Round(_contaerr+1,0);
                    /* _ndgsog := Left(_valage,At('_',_valage) - 1) */
                    _ndgsog = CPLib.Left(_valage,CPLib.At("_",_valage)-1);
                    /* gMsgImp := 'Allineo famiglia con NDG: '+_ndgsog // Messaggio Import */
                    gMsgImp = "Allineo famiglia con NDG: "+_ndgsog;
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                    // * --- Write into opextrbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("opextrbo");
                    m_cPhName = m_Ctx.GetPhName("opextrbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_allinea",185,"0000007A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(_famcodice,"C",50,0,m_cServer)+", ";
                    m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer),m_cServer,_ndgsog)+"";
                    m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL("2015","?",0,0,m_cServer),m_cServer,"2015")+"";
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
                  } // End Case
                } // End If
              } else { // Else
              } // End If
              Cursor_qbe_famesiti_migra_sel.Next();
            }
            m_cConnectivityError = Cursor_qbe_famesiti_migra_sel.ErrorMessage();
            Cursor_qbe_famesiti_migra_sel.Close();
            // * --- End Select
          } // End If
          /* _contacicli := _contacicli+1 */
          _contacicli = CPLib.Round(_contacicli+1,0);
        } // End While
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000044status,0)) {
          m_Sql.SetTransactionStatus(nTry00000044status,cTry00000044msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Sono stati allineate '+LRTrim(Str(_contaerr,10,0))+" famiglie su "+LRTrim(Str(_tot,10,0)) + " famiglie esaminate"+NL // Messaggio */
      gMsgProc = gMsgProc+"Sono stati allineate "+CPLib.LRTrim(CPLib.Str(_contaerr,10,0))+" famiglie su "+CPLib.LRTrim(CPLib.Str(_tot,10,0))+" famiglie esaminate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Esame Famiglie: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Esame Famiglie: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Elaborazione Terminata!' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famesiti_minmax!=null)
          Cursor_qbe_famesiti_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famesiti_migra_sel!=null)
          Cursor_qbe_famesiti_migra_sel.Close();
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
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_w_dadata,java.sql.Date p_w_a_data) {
    w_dadata = p_w_dadata;
    w_a_data = p_w_a_data;
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
  public String Run(java.sql.Date p_w_dadata,java.sql.Date p_w_a_data) {
    w_dadata = p_w_dadata;
    w_a_data = p_w_a_data;
    return Run();
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
          Pag_1();
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
  public static arrt_fammigra_allineaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_fammigra_allineaR(p_Ctx, p_Caller);
  }
  public static arrt_fammigra_allineaR Make(CPContext p_Ctx) {
    return new arrt_fammigra_allineaR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_dadata = CPLib.NullDate();
    w_a_data = CPLib.NullDate();
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _cicli = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    conta = 0;
    _errore = "";
    _trovato = 0;
    _findsog = 0;
    _rapporto = CPLib.Space(25);
    _ndgsog = CPLib.Space(16);
    _codfisc = CPLib.Space(16);
    _paese = CPLib.Space(3);
    _paeseres = CPLib.Space(40);
    _contaerr = 0;
    _valage = CPLib.Space(60);
    _noprot = 0;
    _stringa1 = CPLib.Space(128);
    _stringa2 = CPLib.Space(128);
    _dataini = CPLib.NullDate();
    _datafin = CPLib.NullDate();
    _datiage = "";
    _datimit = "";
    _origine = CPLib.Space(1);
    _ruolo = CPLib.Space(1);
    cReport = CPLib.Space(20);
    _famcodice = CPLib.Space(50);
    _raporig = CPLib.Space(25);
    _check = CPLib.Space(4);
    _sesso = CPLib.Space(1);
    _nascom = CPLib.Space(40);
    _nassta = CPLib.Space(40);
    _datamax = CPLib.NullDate();
    _maxope = CPLib.NullDate();
    _datini = CPLib.NullDate();
    _datfin = CPLib.NullDate();
    _luonas = false;
    _intaui = 0;
    _delaui = 0;
    _titaui = 0;
    _garaui = 0;
    _intage = 0;
    _delage = 0;
    _titage = 0;
    _garage = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_famesiti_minmax,qbe_famesiti_migra_sel,
  public static final String m_cVQRList = ",qbe_famesiti_minmax,qbe_famesiti_migra_sel,";
  // ENTITY_BATCHES: ,arfn_fammigra_datamax,arfn_fdatetime,arrt_fammigra_allinea,
  public static final String i_InvokedRoutines = ",arfn_fammigra_datamax,arfn_fdatetime,arrt_fammigra_allinea,";
  public static String[] m_cRunParameterNames={"w_dadata","w_a_data"};
}
