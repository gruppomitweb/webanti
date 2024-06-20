// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_fammigra_impR implements CallerWithObjs {
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
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_famesiti;
  public String m_cServer_famesiti;
  public String m_cPhName_famesitid;
  public String m_cServer_famesitid;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbluonas;
  public String m_cServer_tbluonas;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
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
  public String gMsgImp;
  public String gMsgProc;
  public String gDescAzi;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _reccount;
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
  public String _nome;
  public String _cognome;
  public String _paese;
  public String _paeseres;
  public double _contaerr;
  public String _valage;
  public double _noprot;
  public String _stringa1;
  public String _stringa2;
  public java.sql.Date _dataini;
  public java.sql.Date _datafin;
  public java.sql.Date _datainirap;
  public java.sql.Date _datafinrap;
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
  public java.sql.Date _datarap;
  public java.sql.Date _maxope;
  public java.sql.Date _datini;
  public java.sql.Date _datfin;
  public boolean _luonas;
  public double _tipoint;
  public String _ragsoc;
  public boolean _vuotoragsoc;
  public boolean _pf;
  public String _connes;
  public boolean _passa;
  public String _cf12;
  public double _lencf12;
  public String _app;
  public boolean _findvuoto;
  public java.sql.Date _datanas;
  public java.sql.Date w_dadata;
  public java.sql.Date w_a_data;
  public String _saldi;
  public String _provnas;
  public String _idbase;
  public String _univoco;
  public CPPooler.LogEvent pdata;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_fammigra_impR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_fammigra_imp",m_Caller);
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_famesiti = p_ContextObject.GetPhName("famesiti");
    if (m_cPhName_famesiti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_famesiti = m_cPhName_famesiti+" "+m_Ctx.GetWritePhName("famesiti");
    }
    m_cServer_famesiti = p_ContextObject.GetServer("famesiti");
    m_cPhName_famesitid = p_ContextObject.GetPhName("famesitid");
    if (m_cPhName_famesitid.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_famesitid = m_cPhName_famesitid+" "+m_Ctx.GetWritePhName("famesitid");
    }
    m_cServer_famesitid = p_ContextObject.GetServer("famesitid");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbluonas = p_ContextObject.GetPhName("tbluonas");
    if (m_cPhName_tbluonas.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbluonas = m_cPhName_tbluonas+" "+m_Ctx.GetWritePhName("tbluonas");
    }
    m_cServer_tbluonas = p_ContextObject.GetServer("tbluonas");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
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
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
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
    if (CPLib.eqr("_tipoint",p_cVarName)) {
      return _tipoint;
    }
    if (CPLib.eqr("_lencf12",p_cVarName)) {
      return _lencf12;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_fammigra_imp";
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
    if (CPLib.eqr("_nome",p_cVarName)) {
      return _nome;
    }
    if (CPLib.eqr("_cognome",p_cVarName)) {
      return _cognome;
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
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      return _ragsoc;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("_cf12",p_cVarName)) {
      return _cf12;
    }
    if (CPLib.eqr("_app",p_cVarName)) {
      return _app;
    }
    if (CPLib.eqr("_saldi",p_cVarName)) {
      return _saldi;
    }
    if (CPLib.eqr("_provnas",p_cVarName)) {
      return _provnas;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      return _idbase;
    }
    if (CPLib.eqr("_univoco",p_cVarName)) {
      return _univoco;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dataini",p_cVarName)) {
      return _dataini;
    }
    if (CPLib.eqr("_datafin",p_cVarName)) {
      return _datafin;
    }
    if (CPLib.eqr("_datainirap",p_cVarName)) {
      return _datainirap;
    }
    if (CPLib.eqr("_datafinrap",p_cVarName)) {
      return _datafinrap;
    }
    if (CPLib.eqr("_datamax",p_cVarName)) {
      return _datamax;
    }
    if (CPLib.eqr("_datarap",p_cVarName)) {
      return _datarap;
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
    if (CPLib.eqr("_datanas",p_cVarName)) {
      return _datanas;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
    }
    if (CPLib.eqr("a_data",p_cVarName)) {
      return w_a_data;
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
    if (CPLib.eqr("_vuotoragsoc",p_cVarName)) {
      return _vuotoragsoc;
    }
    if (CPLib.eqr("_pf",p_cVarName)) {
      return _pf;
    }
    if (CPLib.eqr("_passa",p_cVarName)) {
      return _passa;
    }
    if (CPLib.eqr("_findvuoto",p_cVarName)) {
      return _findvuoto;
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
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
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
    if (CPLib.eqr("_tipoint",p_cVarName)) {
      _tipoint = value;
      return;
    }
    if (CPLib.eqr("_lencf12",p_cVarName)) {
      _lencf12 = value;
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
    if (CPLib.eqr("_nome",p_cVarName)) {
      _nome = value;
      return;
    }
    if (CPLib.eqr("_cognome",p_cVarName)) {
      _cognome = value;
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
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      _ragsoc = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
    if (CPLib.eqr("_cf12",p_cVarName)) {
      _cf12 = value;
      return;
    }
    if (CPLib.eqr("_app",p_cVarName)) {
      _app = value;
      return;
    }
    if (CPLib.eqr("_saldi",p_cVarName)) {
      _saldi = value;
      return;
    }
    if (CPLib.eqr("_provnas",p_cVarName)) {
      _provnas = value;
      return;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      _idbase = value;
      return;
    }
    if (CPLib.eqr("_univoco",p_cVarName)) {
      _univoco = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_dataini",p_cVarName)) {
      _dataini = value;
      return;
    }
    if (CPLib.eqr("_datafin",p_cVarName)) {
      _datafin = value;
      return;
    }
    if (CPLib.eqr("_datainirap",p_cVarName)) {
      _datainirap = value;
      return;
    }
    if (CPLib.eqr("_datafinrap",p_cVarName)) {
      _datafinrap = value;
      return;
    }
    if (CPLib.eqr("_datamax",p_cVarName)) {
      _datamax = value;
      return;
    }
    if (CPLib.eqr("_datarap",p_cVarName)) {
      _datarap = value;
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
    if (CPLib.eqr("_datanas",p_cVarName)) {
      _datanas = value;
      return;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
    if (CPLib.eqr("a_data",p_cVarName)) {
      w_a_data = value;
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
    if (CPLib.eqr("_vuotoragsoc",p_cVarName)) {
      _vuotoragsoc = value;
      return;
    }
    if (CPLib.eqr("_pf",p_cVarName)) {
      _pf = value;
      return;
    }
    if (CPLib.eqr("_passa",p_cVarName)) {
      _passa = value;
      return;
    }
    if (CPLib.eqr("_findvuoto",p_cVarName)) {
      _findvuoto = value;
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
    CPResultSet Cursor_qbe_famesiti_minmax=null;
    CPResultSet Cursor_qbe_famesiti_migra_sel=null;
    CPResultSet Cursor_famesitid=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_aetesta=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* gMsgImp Memo // Messaggio Import */
      /* gMsgProc Memo // Messaggio Import */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _reccount Numeric(0, 0) */
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
      /* _nome Char(25) */
      /* _cognome Char(26) */
      /* _paese Char(3) */
      /* _paeseres Char(40) */
      /* _contaerr Numeric(10, 0) */
      /* _valage Char(60) */
      /* _noprot Numeric(1, 0) */
      /* _stringa1 Char(128) */
      /* _stringa2 Char(128) */
      /* _dataini Date */
      /* _datafin Date */
      /* _datainirap Date */
      /* _datafinrap Date */
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
      /* _datarap Date */
      /* _maxope Date */
      /* _datini Date */
      /* _datfin Date */
      /* _luonas Bool */
      /* _tipoint Numeric(1, 0) */
      /* _ragsoc Char(0) */
      /* _vuotoragsoc Bool */
      /* _pf Bool */
      /* _connes Char(0) */
      /* _passa Bool */
      /* _cf12 Char(0) */
      /* _lencf12 Numeric(0, 0) */
      /* _app Char(0) */
      /* _findvuoto Bool */
      /* _datanas Date */
      /* w_dadata Date */
      /* w_a_data Date */
      /* _saldi Char(0) */
      /* _provnas Char(2) */
      /* _idbase Char(10) */
      /* _univoco Char(50) */
      /* pdata Object(CPPooler.LogEvent) */
      /* gMsgProc := 'Ora Inizio Import Famiglie: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = "Ora Inizio Import Famiglie: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000048status;
      nTry00000048status = m_Sql.GetTransactionStatus();
      String cTry00000048msg;
      cTry00000048msg = m_Sql.TransactionErrorMessage();
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
        SPBridge.HMCaller _h0000004E;
        _h0000004E = new SPBridge.HMCaller();
        _h0000004E.Set("m_cVQRList",m_cVQRList);
        _h0000004E.Set("dadata",w_dadata);
        _h0000004E.Set("a_data",w_a_data);
        if (Cursor_qbe_famesiti_minmax!=null)
          Cursor_qbe_famesiti_minmax.Close();
        Cursor_qbe_famesiti_minmax = new VQRHolder("qbe_famesiti_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000004E,true).GetResultSet(m_Ctx);
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
          /* _reccount := _max - _min */
          _reccount = CPLib.Round(_max-_min,0);
          /* _cicli := iif(Mod(_reccount,5000) <> 0,Int(_reccount/5000) + 1,Int(_reccount/5000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,5000),0)?CPLib.Int(_reccount/5000)+1:CPLib.Int(_reccount/5000)),0);
        } // End If
        /* _contacicli := 1 */
        _contacicli = CPLib.Round(1,0);
        /* conta := 0 */
        conta = CPLib.Round(0,0);
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
              /* _top := _min +4999 */
              _top = CPLib.Round(_min+4999,0);
              /* ElseIf _contacicli = _cicli */
            } else if (CPLib.eqr(_contacicli,_cicli)) {
              /* _bottom := _top + 1 */
              _bottom = CPLib.Round(_top+1,0);
              /* _top := _max */
              _top = CPLib.Round(_max,0);
            } else { // Else
              /* _bottom := _top + 1 */
              _bottom = CPLib.Round(_top+1,0);
              /* _top := _bottom + 4999 */
              _top = CPLib.Round(_bottom+4999,0);
            } // End If
          } // End If
          /* If _top>=_min */
          if (CPLib.ge(_top,_min)) {
            // * --- Select from qbe_famesiti_migra_sel
            SPBridge.HMCaller _h00000067;
            _h00000067 = new SPBridge.HMCaller();
            _h00000067.Set("m_cVQRList",m_cVQRList);
            _h00000067.Set("_bottom",_bottom);
            _h00000067.Set("_top",_top);
            _h00000067.Set("dadata",w_dadata);
            _h00000067.Set("a_data",w_a_data);
            if (Cursor_qbe_famesiti_migra_sel!=null)
              Cursor_qbe_famesiti_migra_sel.Close();
            Cursor_qbe_famesiti_migra_sel = new VQRHolder("qbe_famesiti_migra_sel",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000067,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_famesiti_migra_sel.Eof())) {
              /* _saldi := LRTrim(qbe_famesiti_migra_sel->FAMSAL2011)+LRTrim(qbe_famesiti_migra_sel->FAMSAL2012)+LRTrim(qbe_famesiti_migra_sel->FAMSAL2013)+LRTrim(qbe_famesiti_migra_sel->FAMSAL2014)+LRTrim(qbe_famesiti_migra_sel->FAMSAL2015)+LRTrim(qbe_famesiti_migra_sel->FAMSAL2016)+LRTrim(qbe_famesiti_migra_sel->FAMSAL2017) */
              _saldi = CPLib.LRTrim(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2011"))+CPLib.LRTrim(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2012"))+CPLib.LRTrim(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2013"))+CPLib.LRTrim(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2014"))+CPLib.LRTrim(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2015"))+CPLib.LRTrim(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2016"))+CPLib.LRTrim(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2017"));
              /* _famcodice := LRTrim(qbe_famesiti_migra_sel->FAMCODICE) */
              _famcodice = CPLib.LRTrim(Cursor_qbe_famesiti_migra_sel.GetString("FAMCODICE"));
              /* _datainirap := qbe_famesiti_migra_sel->FAMDATINI */
              _datainirap = Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATINI");
              /* _datafinrap := qbe_famesiti_migra_sel->FAMDATFIN */
              _datafinrap = Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATFIN");
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
                /* _ragsoc := '' */
                _ragsoc = "";
                /* _pf := False */
                _pf = false;
                /* _connes := '' */
                _connes = "";
                /* _passa := False */
                _passa = false;
                /* _vuotoragsoc := False */
                _vuotoragsoc = false;
                /* _cf12 := '' */
                _cf12 = "";
                /* _lencf12 := 0 */
                _lencf12 = CPLib.Round(0,0);
                /* _codfisc := '' */
                _codfisc = "";
                /* _findvuoto := True */
                _findvuoto = true;
                /* _provnas := '' */
                _provnas = "";
                // * --- Select from famesitid
                m_cServer = m_Ctx.GetServer("famesitid");
                m_cPhName = m_Ctx.GetPhName("famesitid");
                if (Cursor_famesitid!=null)
                  Cursor_famesitid.Close();
                Cursor_famesitid = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"FADRAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_famcodice,"?",0,0,m_cServer, m_oParameters),m_cServer,_famcodice)+" "+")"+(m_Ctx.IsSharedTemp("famesitid")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_famesitid.Eof())) {
                  /* gMsgImp := "Sto elaborando il soggetto con rapporto: "+famesitid->FADRAPPORTO + " del "+arfn_fdate(_datainirap) // Messaggio Import */
                  gMsgImp = "Sto elaborando il soggetto con rapporto: "+Cursor_famesitid.GetString("FADRAPPORTO")+" del "+arfn_fdateR.Make(m_Ctx,this).Run(_datainirap);
                  m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  /* _pf := False */
                  _pf = false;
                  /* If (not(Empty(famesitid->FADSESSO)) and At(Upper(famesitid->FADSESSO),'|1|M|2|F') >0) or (not(Empty(famesitid->FADCODFIS)) and Len(LRTrim(famesitid->FADCODFIS))=16) or (not(Empty(famesitid->FADSESSO)) and At(Upper(famesitid->FADSESSO),'|1|M|2|F') > 0 and Len(LRTrim(famesitid->FADCODFIS))=11) */
                  if (( ! (CPLib.Empty(Cursor_famesitid.GetString("FADSESSO"))) && CPLib.gt(CPLib.At(CPLib.Upper(Cursor_famesitid.GetString("FADSESSO")),"|1|M|2|F"),0)) || ( ! (CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_famesitid.GetString("FADCODFIS"))),16)) || ( ! (CPLib.Empty(Cursor_famesitid.GetString("FADSESSO"))) && CPLib.gt(CPLib.At(CPLib.Upper(Cursor_famesitid.GetString("FADSESSO")),"|1|M|2|F"),0) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_famesitid.GetString("FADCODFIS"))),11))) {
                    /* _pf := True */
                    _pf = true;
                  } // End If
                  /* If Empty(famesitid->FADCOGRAG) */
                  if (CPLib.Empty(Cursor_famesitid.GetString("FADCOGRAG"))) {
                    /* If not(Empty(famesitid->FADCODFIS)) */
                    if ( ! (CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS")))) {
                      /* _ragsoc := LRTrim(famesitid->FADCODFIS) */
                      _ragsoc = CPLib.LRTrim(Cursor_famesitid.GetString("FADCODFIS"));
                      /* _ragsoc := Strtran(_ragsoc,"*","X") */
                      _ragsoc = CPLib.Strtran(_ragsoc,"*","X");
                    } else { // Else
                      /* _ragsoc := LibreriaMit.UniqueId() */
                      _ragsoc = LibreriaMit.UniqueId();
                    } // End If
                    /* _vuotoragsoc := True */
                    _vuotoragsoc = true;
                  } else { // Else
                    /* _ragsoc := LRTrim(famesitid->FADCOGRAG) */
                    _ragsoc = CPLib.LRTrim(Cursor_famesitid.GetString("FADCOGRAG"));
                  } // End If
                  /* If not(Empty(famesitid->FADCODFIS)) */
                  if ( ! (CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS")))) {
                    /* _cf12 := Strtran(famesitid->FADCODFIS,"*","") */
                    _cf12 = CPLib.Strtran(Cursor_famesitid.GetString("FADCODFIS"),"*","");
                    /* _lencf12 := Len(_cf12) */
                    _lencf12 = CPLib.Round(CPLib.Len(_cf12),0);
                    /* _codfisc := LRTrim(Strtran(famesitid->FADCODFIS,"*","X")) */
                    _codfisc = CPLib.LRTrim(CPLib.Strtran(Cursor_famesitid.GetString("FADCODFIS"),"*","X"));
                    /* _app := '%'+Right(_codfisc,_lencf12) */
                    _app = "%"+CPLib.Right(_codfisc,_lencf12);
                    // * --- Select from personbo
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODFISC like "+CPSql.SQLValueAdapter(CPLib.ToSQL(_app,"?",0,0,m_cServer, m_oParameters),m_cServer,_app)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_personbo.Eof())) {
                      /* _connes := personbo->CONNES */
                      _connes = Cursor_personbo.GetString("CONNES");
                      Cursor_personbo.Next();
                    }
                    m_cConnectivityError = Cursor_personbo.ErrorMessage();
                    Cursor_personbo.Close();
                    // * --- End Select
                    /* If Empty(_connes) */
                    if (CPLib.Empty(_connes)) {
                      // * --- Select from personbo
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODFISC like "+CPSql.SQLValueAdapter(CPLib.ToSQL(_app,"?",0,0,m_cServer, m_oParameters),m_cServer,_app)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_personbo.Eof())) {
                        /* _connes := personbo->CONNES */
                        _connes = Cursor_personbo.GetString("CONNES");
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      // * --- End Select
                      /* If Empty(_connes) */
                      if (CPLib.Empty(_connes)) {
                        /* _connes := LibreriaMit.UniqueId() */
                        _connes = LibreriaMit.UniqueId();
                        // * --- Merge into personbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo");
                        m_cPhName = m_Ctx.GetPhName("personbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                        m_cQuery = "select ";
                        m_cQuery =  m_cQuery+""+CPLib.ToSQL(_connes,"?",0,0)+" as CONNES";
                        m_cQuery =  m_cQuery+", "+CPLib.ToSQL(_codfisc,"?",0,0)+" as CODFISC";
                        if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                          m_cQuery = m_cQuery+" from dual";
                        }
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cWhere = "personbo.CONNES = cptmp_1xab23.CONNES";
                        m_cWhere = m_cWhere+" and "+"personbo.CODFISC = cptmp_1xab23.CODFISC";
                        m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                        if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"00000095")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" personbo USING ";
                          m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                          m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",true,true);
                          m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                          m_cSql = m_cSql+GetFieldsName_00000095(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_codfisc,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
                          m_cSql = m_cSql+")";
                          if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                            m_cSql = m_cSql+";";
                          }
                        } else {
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"00000095")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                          m_cSql = m_cSql+" and CODFISC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codfisc,"?",0,0,m_cServer),m_cServer,_codfisc)+"";
                          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                          if (CPLib.eqr(m_nUpdatedRows,0)) {
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"00000095")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                            m_cSql = m_cSql+GetFieldsName_00000095(m_Ctx,m_oWrInfo);
                            m_cSql = m_cSql+") values (";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_codfisc,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+m_oWrInfo.InsertValues();
                            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
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
                        /* _passa := True */
                        _passa = true;
                      } // End If
                    } // End If
                  } else { // Else
                    // * --- Select from personbo
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAGSOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ragsoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_ragsoc)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_personbo.Eof())) {
                      /* _connes := personbo->CONNES */
                      _connes = Cursor_personbo.GetString("CONNES");
                      Cursor_personbo.Next();
                    }
                    m_cConnectivityError = Cursor_personbo.ErrorMessage();
                    Cursor_personbo.Close();
                    // * --- End Select
                    /* If Empty(_connes) */
                    if (CPLib.Empty(_connes)) {
                      /* _findvuoto := False */
                      _findvuoto = false;
                      /* If _vuotoragsoc */
                      if (_vuotoragsoc) {
                        /* _sesso := iif(At(famesitid->FADSESSO,"|1|M") <> 0,'1','2') */
                        _sesso = (CPLib.ne(CPLib.At(Cursor_famesitid.GetString("FADSESSO"),"|1|M"),0)?"1":"2");
                        /* _nassta := famesitid->FADNASSEL */
                        _nassta = Cursor_famesitid.GetString("FADNASSEL");
                        /* _datanas := famesitid->FADDATNAS */
                        _datanas = Cursor_famesitid.GetDate("FADDATNAS");
                        /* If not(Empty(_sesso)) and not(Empty(_nassta)) and not(Empty(_datanas)) */
                        if ( ! (CPLib.Empty(_sesso)) &&  ! (CPLib.Empty(_nassta)) &&  ! (CPLib.Empty(_datanas))) {
                          /* _contaerr := 0 */
                          _contaerr = CPLib.Round(0,0);
                          // * --- Select from personbo
                          m_cServer = m_Ctx.GetServer("personbo");
                          m_cPhName = m_Ctx.GetPhName("personbo");
                          if (Cursor_personbo!=null)
                            Cursor_personbo.Close();
                          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SESSO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_sesso,"?",0,0,m_cServer, m_oParameters),m_cServer,_sesso)+"  and  NASSTATO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nassta,"?",0,0,m_cServer, m_oParameters),m_cServer,_nassta)+"  and  DATANASC="+CPSql.SQLValueAdapter(CPLib.ToSQL(_datanas,"?",0,0,m_cServer, m_oParameters),m_cServer,_datanas)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                          while ( ! (Cursor_personbo.Eof())) {
                            /* _contaerr := _contaerr + 1 */
                            _contaerr = CPLib.Round(_contaerr+1,0);
                            /* _connes := personbo->CONNES */
                            _connes = Cursor_personbo.GetString("CONNES");
                            Cursor_personbo.Next();
                          }
                          m_cConnectivityError = Cursor_personbo.ErrorMessage();
                          Cursor_personbo.Close();
                          // * --- End Select
                          /* If _contaerr > 1 */
                          if (CPLib.gt(_contaerr,1)) {
                            /* _findvuoto := False */
                            _findvuoto = false;
                          } else { // Else
                            /* _findvuoto := iif(Empty(_connes),False,True) */
                            _findvuoto = (CPLib.Empty(_connes)?false:true);
                          } // End If
                        } // End If
                      } // End If
                      /* If not(_findvuoto) */
                      if ( ! (_findvuoto)) {
                        /* _connes := LibreriaMit.UniqueId() */
                        _connes = LibreriaMit.UniqueId();
                        // * --- Merge into personbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo");
                        m_cPhName = m_Ctx.GetPhName("personbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                        m_cQuery = "select ";
                        m_cQuery =  m_cQuery+""+CPLib.ToSQL(_connes,"?",0,0)+" as CONNES";
                        m_cQuery =  m_cQuery+", "+CPLib.ToSQL("","?",0,0)+" as CODFISC";
                        m_cQuery =  m_cQuery+", "+CPLib.ToSQL(1,"?",0,0)+" as CFESTERO";
                        if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                          m_cQuery = m_cQuery+" from dual";
                        }
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cWhere = "personbo.CONNES = cptmp_1xab23.CONNES";
                        m_cWhere = m_cWhere+" and "+"personbo.CODFISC = cptmp_1xab23.CODFISC";
                        m_cWhere = m_cWhere+" and "+"personbo.CFESTERO = cptmp_1xab23.CFESTERO";
                        m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                        if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"000000A9")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" personbo USING ";
                          m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                          m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",true,true);
                          m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                          m_cSql = m_cSql+GetFieldsName_000000A9(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
                          m_cSql = m_cSql+")";
                          if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                            m_cSql = m_cSql+";";
                          }
                        } else {
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"000000A9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                          m_cSql = m_cSql+" and CODFISC = "+CPSql.SQLValueAdapter(CPLib.ToSQL("","?",0,0,m_cServer),m_cServer,"")+"";
                          m_cSql = m_cSql+" and CFESTERO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
                          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                          if (CPLib.eqr(m_nUpdatedRows,0)) {
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"000000A9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                            m_cSql = m_cSql+GetFieldsName_000000A9(m_Ctx,m_oWrInfo);
                            m_cSql = m_cSql+") values (";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                            m_cSql = m_cSql+m_oWrInfo.InsertValues();
                            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
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
                        /* _passa := True */
                        _passa = true;
                      } // End If
                    } // End If
                  } // End If
                  /* If _passa */
                  if (_passa) {
                    /* If _pf */
                    if (_pf) {
                      /* If not(Empty(_codfisc)) */
                      if ( ! (CPLib.Empty(_codfisc))) {
                        /* _sesso := iif(Val(Substr(_codfisc,10,2)) > 40,'2','1') */
                        _sesso = (CPLib.gt(CPLib.Val(CPLib.Substr(_codfisc,10,2)),40)?"2":"1");
                        /* _provnas := '' */
                        _provnas = "";
                        // * --- Read from tbluonas
                        m_cServer = m_Ctx.GetServer("tbluonas");
                        m_cPhName = m_Ctx.GetPhName("tbluonas");
                        m_cSql = "";
                        m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_codfisc,12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(_codfisc,12,4));
                        if (m_Ctx.IsSharedTemp("tbluonas")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _provnas = Read_Cursor.GetString("PROVINCIA");
                          _nassta = Read_Cursor.GetString("DESCRI");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on tbluonas into routine arrt_fammigra_imp returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _provnas = "";
                          _nassta = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                        /* _nassta := Left(_nassta,30) */
                        _nassta = CPLib.Left(_nassta,30);
                        /* Exec "Calcolo Data di Nascita" Page 2:CalcNas */
                        CalcNas();
                        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                          throw new RoutineException();
                        }
                      } else { // Else
                        /* _sesso := iif(At(famesitid->FADSESSO,"|1|M") > 0,'M',iif(At(famesitid->FADSESSO,"|2|F") > 0,'F','')) */
                        _sesso = (CPLib.gt(CPLib.At(Cursor_famesitid.GetString("FADSESSO"),"|1|M"),0)?"M":(CPLib.gt(CPLib.At(Cursor_famesitid.GetString("FADSESSO"),"|2|F"),0)?"F":""));
                        /* _nassta := LRTrim(Left(famesitid->FADNASSEL,30)) */
                        _nassta = CPLib.LRTrim(CPLib.Left(Cursor_famesitid.GetString("FADNASSEL"),30));
                        /* _provnas := famesitid->FADPRVSEL */
                        _provnas = Cursor_famesitid.GetString("FADPRVSEL");
                        /* _datanas := famesitid->FADDATNAS */
                        _datanas = Cursor_famesitid.GetDate("FADDATNAS");
                      } // End If
                      // * --- Write into personbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"000000B7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(_ragsoc,"C",70,0,m_cServer)+", ";
                      m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(_sesso,"C",1,0,m_cServer)+", ";
                      m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL((CPLib.eqr(_provnas,"EE")?CPLib.Left(_nassta,30):""),"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL((CPLib.ne(_provnas,"EE")?CPLib.Left(_nassta,30):""),"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(_datanas,"D",8,0)+", ";
                      m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(_provnas,"C",2,0,m_cServer)+", ";
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
                        throw new RoutineException();
                      }
                    } else { // Else
                      // * --- Write into personbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"000000B8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_famesitid.GetString("FADCOGRAG"),"C",70,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(Cursor_famesitid.GetString("FADNASSEL"),30)),"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_famesitid.GetString("FADPRVSEL"),"C",2,0,m_cServer)+", ";
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
                        throw new RoutineException();
                      }
                    } // End If
                  } else { // Else
                    /* _idbase := '' */
                    _idbase = "";
                    /* _univoco := '' */
                    _univoco = "";
                    // * --- Read from opextrbo
                    m_cServer = m_Ctx.GetServer("opextrbo");
                    m_cPhName = m_Ctx.GetPhName("opextrbo");
                    m_cSql = "";
                    m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"C",16,0,m_cServer),m_cServer,_connes);
                    m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_famesiti_migra_sel.GetString("FAMCODICE"),"C",4,0,m_cServer),m_cServer,Cursor_qbe_famesiti_migra_sel.GetString("FAMCODICE"));
                    if (m_Ctx.IsSharedTemp("opextrbo")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("UNIQUER",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _univoco = Read_Cursor.GetString("UNIQUER");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_fammigra_imp returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _univoco = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* If LRTrim(_univoco) <> LRTrim(qbe_famesiti_migra_sel->FAMCODICE) */
                    if (CPLib.ne(CPLib.LRTrim(_univoco),CPLib.LRTrim(Cursor_qbe_famesiti_migra_sel.GetString("FAMCODICE")))) {
                      /* If _pf */
                      if (_pf) {
                        /* If not(Empty(_codfisc)) */
                        if ( ! (CPLib.Empty(_codfisc))) {
                          /* _sesso := iif(Val(Substr(_codfisc,10,2)) > 40,'2','1') */
                          _sesso = (CPLib.gt(CPLib.Val(CPLib.Substr(_codfisc,10,2)),40)?"2":"1");
                          /* _provnas := '' */
                          _provnas = "";
                          // * --- Read from tbluonas
                          m_cServer = m_Ctx.GetServer("tbluonas");
                          m_cPhName = m_Ctx.GetPhName("tbluonas");
                          m_cSql = "";
                          m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_codfisc,12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(_codfisc,12,4));
                          if (m_Ctx.IsSharedTemp("tbluonas")) {
                            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                          }
                          if (Read_Cursor!=null)
                            Read_Cursor.Close();
                          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                          if ( ! (Read_Cursor.Eof())) {
                            _provnas = Read_Cursor.GetString("PROVINCIA");
                            _nassta = Read_Cursor.GetString("DESCRI");
                            Read_Cursor.Next();
                            if ( ! (Read_Cursor.Eof())) {
                              Error l_oErrorFault = new Error("Read on tbluonas into routine arrt_fammigra_imp returns two or more records. This item should return only a record.");
                              CPStdCounter.Error(l_oErrorFault);
                            }
                            Read_Cursor.Close();
                          } else {
                            // Error: no record found!
                            _provnas = "";
                            _nassta = "";
                            Read_Cursor.Close();
                            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                          }
                          /* _nassta := Left(_nassta,30) */
                          _nassta = CPLib.Left(_nassta,30);
                          /* Exec "Calcolo Data di Nascita" Page 2:CalcNas */
                          CalcNas();
                          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                            throw new RoutineException();
                          }
                        } else { // Else
                          /* _sesso := iif(At(famesitid->FADSESSO,"|1|M") > 0,'M',iif(At(famesitid->FADSESSO,"|2|F") > 0,'F','')) */
                          _sesso = (CPLib.gt(CPLib.At(Cursor_famesitid.GetString("FADSESSO"),"|1|M"),0)?"M":(CPLib.gt(CPLib.At(Cursor_famesitid.GetString("FADSESSO"),"|2|F"),0)?"F":""));
                          /* _nassta := LRTrim(Left(famesitid->FADNASSEL,30)) */
                          _nassta = CPLib.LRTrim(CPLib.Left(Cursor_famesitid.GetString("FADNASSEL"),30));
                          /* _provnas := famesitid->FADPRVSEL */
                          _provnas = Cursor_famesitid.GetString("FADPRVSEL");
                          /* _datanas := famesitid->FADDATNAS */
                          _datanas = Cursor_famesitid.GetDate("FADDATNAS");
                        } // End If
                        /* _connes := LibreriaMit.UniqueId() */
                        _connes = LibreriaMit.UniqueId();
                        // * --- Merge into personbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo");
                        m_cPhName = m_Ctx.GetPhName("personbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                        m_cQuery = "select ";
                        m_cQuery =  m_cQuery+""+CPLib.ToSQL(_connes,"?",0,0)+" as CONNES";
                        if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                          m_cQuery = m_cQuery+" from dual";
                        }
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cWhere = "personbo.CONNES = cptmp_1xab23.CONNES";
                        m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                        if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"000000C9")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" personbo USING ";
                          m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                          m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                          m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(_ragsoc,"C",70,0,m_cServer)+", ";
                          m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(_sesso,"C",1,0,m_cServer)+", ";
                          m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL((CPLib.eqr(_provnas,"EE")?CPLib.Left(_nassta,30):""),"C",30,0,m_cServer)+", ";
                          m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL((CPLib.ne(_provnas,"EE")?CPLib.Left(_nassta,30):""),"C",30,0,m_cServer)+", ";
                          m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(_datanas,"D",8,0)+", ";
                          m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(_provnas,"C",2,0,m_cServer)+", ";
                          m_cSql = m_cSql+"personbo.CFESTERO = "+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?1:0),"?",0,0,m_cServer,m_oParameters),m_cServer,(CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?1:0))+" , ";
                          m_cSql = m_cSql+"personbo.CODFISC = "+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?"":CPLib.Strtran(Cursor_famesitid.GetString("FADCODFIS"),"*","X")),"?",0,0,m_cServer,m_oParameters),m_cServer,(CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?"":CPLib.Strtran(Cursor_famesitid.GetString("FADCODFIS"),"*","X")))+" , ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",true,true);
                          m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                          m_cSql = m_cSql+GetFieldsName_000000C9(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_ragsoc,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_sesso,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_provnas,"EE")?CPLib.Left(_nassta,30):""),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.ne(_provnas,"EE")?CPLib.Left(_nassta,30):""),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_datanas,"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_provnas,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?1:0),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?"":CPLib.Strtran(Cursor_famesitid.GetString("FADCODFIS"),"*","X")),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
                          m_cSql = m_cSql+")";
                          if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                            m_cSql = m_cSql+";";
                          }
                        } else {
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"000000C9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                          m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(_ragsoc,"C",70,0,m_cServer)+", ";
                          m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(_sesso,"C",1,0,m_cServer)+", ";
                          m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL((CPLib.eqr(_provnas,"EE")?CPLib.Left(_nassta,30):""),"C",30,0,m_cServer)+", ";
                          m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL((CPLib.ne(_provnas,"EE")?CPLib.Left(_nassta,30):""),"C",30,0,m_cServer)+", ";
                          m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(_datanas,"D",8,0)+", ";
                          m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(_provnas,"C",2,0,m_cServer)+", ";
                          m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?1:0),"N",1,0)+", ";
                          m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?"":CPLib.Strtran(Cursor_famesitid.GetString("FADCODFIS"),"*","X")),"C",16,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                          if (CPLib.eqr(m_nUpdatedRows,0)) {
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"000000C9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                            m_cSql = m_cSql+GetFieldsName_000000C9(m_Ctx,m_oWrInfo);
                            m_cSql = m_cSql+") values (";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_ragsoc,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_sesso,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_provnas,"EE")?CPLib.Left(_nassta,30):""),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.ne(_provnas,"EE")?CPLib.Left(_nassta,30):""),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_datanas,"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_provnas,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?1:0),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?"":CPLib.Strtran(Cursor_famesitid.GetString("FADCODFIS"),"*","X")),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+m_oWrInfo.InsertValues();
                            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
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
                      } else { // Else
                        // * --- Merge into personbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo");
                        m_cPhName = m_Ctx.GetPhName("personbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                        m_cQuery = "select ";
                        m_cQuery =  m_cQuery+""+CPLib.ToSQL(_connes,"?",0,0)+" as CONNES";
                        if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                          m_cQuery = m_cQuery+" from dual";
                        }
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cWhere = "personbo.CONNES = cptmp_1xab23.CONNES";
                        m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                        if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"000000CA")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" personbo USING ";
                          m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                          m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                          m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(_ragsoc,"C",70,0,m_cServer)+", ";
                          m_cSql = m_cSql+"personbo.DESCCIT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(Cursor_famesitid.GetString("FADNASSEL"),30)),"?",0,0,m_cServer,m_oParameters),m_cServer,CPLib.LRTrim(CPLib.Left(Cursor_famesitid.GetString("FADNASSEL"),30)))+" , ";
                          m_cSql = m_cSql+"personbo.PROVINCIA = "+CPLib.ToSQL(Cursor_famesitid.GetString("FADPRVSEL"),"?",0,0)+" , ";
                          m_cSql = m_cSql+"personbo.CFESTERO = "+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?1:0),"?",0,0,m_cServer,m_oParameters),m_cServer,(CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?1:0))+" , ";
                          m_cSql = m_cSql+"personbo.CODFISC = "+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?"":CPLib.Strtran(Cursor_famesitid.GetString("FADCODFIS"),"*","X")),"?",0,0,m_cServer,m_oParameters),m_cServer,(CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?"":CPLib.Strtran(Cursor_famesitid.GetString("FADCODFIS"),"*","X")))+" , ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",true,true);
                          m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                          m_cSql = m_cSql+GetFieldsName_000000CA(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_ragsoc,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(Cursor_famesitid.GetString("FADNASSEL"),30)),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_famesitid.GetString("FADPRVSEL"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?1:0),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?"":CPLib.Strtran(Cursor_famesitid.GetString("FADCODFIS"),"*","X")),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
                          m_cSql = m_cSql+")";
                          if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                            m_cSql = m_cSql+";";
                          }
                        } else {
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"000000CA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                          m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(_ragsoc,"C",70,0,m_cServer)+", ";
                          m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(Cursor_famesitid.GetString("FADNASSEL"),30)),"C",30,0,m_cServer)+", ";
                          m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_famesitid.GetString("FADPRVSEL"),"C",2,0,m_cServer)+", ";
                          m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?1:0),"N",1,0)+", ";
                          m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?"":CPLib.Strtran(Cursor_famesitid.GetString("FADCODFIS"),"*","X")),"C",16,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                          if (CPLib.eqr(m_nUpdatedRows,0)) {
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"000000CA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                            m_cSql = m_cSql+GetFieldsName_000000CA(m_Ctx,m_oWrInfo);
                            m_cSql = m_cSql+") values (";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_ragsoc,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(Cursor_famesitid.GetString("FADNASSEL"),30)),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_famesitid.GetString("FADPRVSEL"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?1:0),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS"))?"":CPLib.Strtran(Cursor_famesitid.GetString("FADCODFIS"),"*","X")),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+m_oWrInfo.InsertValues();
                            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
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
                      } // End If
                    } // End If
                  } // End If
                  // * --- Merge into opextrbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("opextrbo");
                  m_cPhName = m_Ctx.GetPhName("opextrbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                  m_cQuery = "select ";
                  m_cQuery =  m_cQuery+""+CPLib.ToSQL(Cursor_qbe_famesiti_migra_sel.GetString("FAMCODICE"),"?",0,0)+" as UNIQUER";
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                    m_cQuery = m_cQuery+" from dual";
                  }
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cWhere = "opextrbo.UNIQUER = cptmp_1xab23.UNIQUER";
                  m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"000000CB")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" opextrbo USING ";
                    m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                    m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",true,true);
                    m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                    m_cSql = m_cSql+GetFieldsName_000000CB(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_famesiti_migra_sel.GetString("FAMCODICE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(Cursor_qbe_famesiti_migra_sel.GetDouble("FAMANNORIF"),4,0),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATINI"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATINI"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.gt(CPLib.At("1",_saldi),0)?1:0),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"opextrbo",true);
                    m_cSql = m_cSql+")";
                    if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                      m_cSql = m_cSql+";";
                    }
                  } else {
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"000000CB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"UNIQUER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_famesiti_migra_sel.GetString("FAMCODICE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_famesiti_migra_sel.GetString("FAMCODICE"))+"";
                    m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.eqr(m_nUpdatedRows,0)) {
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_imp",250,"000000CB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000CB(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_famesiti_migra_sel.GetString("FAMCODICE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(Cursor_qbe_famesiti_migra_sel.GetDouble("FAMANNORIF"),4,0),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATINI"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATINI"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.gt(CPLib.At("1",_saldi),0)?1:0),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"opextrbo",true);
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
                  Cursor_famesitid.Next();
                }
                m_cConnectivityError = Cursor_famesitid.ErrorMessage();
                Cursor_famesitid.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from aetesta
                m_cServer = m_Ctx.GetServer("aetesta");
                m_cPhName = m_Ctx.GetPhName("aetesta");
                if (Cursor_aetesta!=null)
                  Cursor_aetesta.Close();
                Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_famcodice,"?",0,0,m_cServer, m_oParameters),m_cServer,_famcodice)+"  or  UNIQUER="+CPSql.SQLValueAdapter(CPLib.ToSQL(_famcodice,"?",0,0,m_cServer, m_oParameters),m_cServer,_famcodice)+" "+")"+(m_Ctx.IsSharedTemp("aetesta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aetesta.Eof())) {
                  Cursor_aetesta.Next();
                }
                m_cConnectivityError = Cursor_aetesta.ErrorMessage();
                Cursor_aetesta.Close();
                // * --- End Select
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000048status,0)) {
          m_Sql.SetTransactionStatus(nTry00000048status,cTry00000048msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Import Famiglie: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Import Famiglie: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Elaborazione Terminata!' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
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
        if (Cursor_famesitid!=null)
          Cursor_famesitid.Close();
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
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aetesta!=null)
          Cursor_aetesta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void CalcNas() throws Exception {
    /* Mese Char(2) */
    String Mese;
    Mese = CPLib.Space(2);
    /* Giorno Char(2) */
    String Giorno;
    Giorno = CPLib.Space(2);
    /* Anno Char(2) */
    String Anno;
    Anno = CPLib.Space(2);
    /* Variabile del mese */
    /* Case Substr(_codfisc,9,1)='A' */
    if (CPLib.eqr(CPLib.Substr(_codfisc,9,1),"A")) {
      /* Mese := '01' */
      Mese = "01";
      /* Case Substr(_codfisc,9,1)='B' */
    } else if (CPLib.eqr(CPLib.Substr(_codfisc,9,1),"B")) {
      /* Mese := '02' */
      Mese = "02";
      /* Case Substr(_codfisc,9,1)='C' */
    } else if (CPLib.eqr(CPLib.Substr(_codfisc,9,1),"C")) {
      /* Mese := '03' */
      Mese = "03";
      /* Case Substr(_codfisc,9,1)='D' */
    } else if (CPLib.eqr(CPLib.Substr(_codfisc,9,1),"D")) {
      /* Mese := '04' */
      Mese = "04";
      /* Case Substr(_codfisc,9,1)='E' */
    } else if (CPLib.eqr(CPLib.Substr(_codfisc,9,1),"E")) {
      /* Mese := '05' */
      Mese = "05";
      /* Case Substr(_codfisc,9,1)='H' */
    } else if (CPLib.eqr(CPLib.Substr(_codfisc,9,1),"H")) {
      /* Mese := '06' */
      Mese = "06";
      /* Case Substr(_codfisc,9,1)='L' */
    } else if (CPLib.eqr(CPLib.Substr(_codfisc,9,1),"L")) {
      /* Mese := '07' */
      Mese = "07";
      /* Case Substr(_codfisc,9,1)='M' */
    } else if (CPLib.eqr(CPLib.Substr(_codfisc,9,1),"M")) {
      /* Mese := '08' */
      Mese = "08";
      /* Case Substr(_codfisc,9,1)='P' */
    } else if (CPLib.eqr(CPLib.Substr(_codfisc,9,1),"P")) {
      /* Mese := '09' */
      Mese = "09";
      /* Case Substr(_codfisc,9,1)='R' */
    } else if (CPLib.eqr(CPLib.Substr(_codfisc,9,1),"R")) {
      /* Mese := '10' */
      Mese = "10";
      /* Case Substr(_codfisc,9,1)='S' */
    } else if (CPLib.eqr(CPLib.Substr(_codfisc,9,1),"S")) {
      /* Mese := '11' */
      Mese = "11";
      /* Case Substr(_codfisc,9,1)='T' */
    } else if (CPLib.eqr(CPLib.Substr(_codfisc,9,1),"T")) {
      /* Mese := '12' */
      Mese = "12";
    } // End Case
    /* Variabile del giorno */
    /* Giorno := iif(Val(Substr(_codfisc,10,2)) < 40,Substr(_codfisc,10,2),Str(Val(Substr(_codfisc,10,2))-40,2,0)) */
    Giorno = (CPLib.lt(CPLib.Val(CPLib.Substr(_codfisc,10,2)),40)?CPLib.Substr(_codfisc,10,2):CPLib.Str(CPLib.Val(CPLib.Substr(_codfisc,10,2))-40,2,0));
    /* Variabile anno */
    /* Anno := iif('20'+Substr(_codfisc,7,2) > Str(Year(Date()),4,0),'19'+Substr(_codfisc,7,2),'20'+Substr(_codfisc,7,2)) */
    Anno = (CPLib.gt("20"+CPLib.Substr(_codfisc,7,2),CPLib.Str(CPLib.Year(CPLib.Date()),4,0))?"19"+CPLib.Substr(_codfisc,7,2):"20"+CPLib.Substr(_codfisc,7,2));
    /* _datanas := CharToDate(Anno+Mese+Giorno) */
    _datanas = CPLib.CharToDate(Anno+Mese+Giorno);
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
  public static arrt_fammigra_impR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_fammigra_impR(p_Ctx, p_Caller);
  }
  public static arrt_fammigra_impR Make(CPContext p_Ctx) {
    return new arrt_fammigra_impR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _reccount = 0;
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
    _nome = CPLib.Space(25);
    _cognome = CPLib.Space(26);
    _paese = CPLib.Space(3);
    _paeseres = CPLib.Space(40);
    _contaerr = 0;
    _valage = CPLib.Space(60);
    _noprot = 0;
    _stringa1 = CPLib.Space(128);
    _stringa2 = CPLib.Space(128);
    _dataini = CPLib.NullDate();
    _datafin = CPLib.NullDate();
    _datainirap = CPLib.NullDate();
    _datafinrap = CPLib.NullDate();
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
    _datarap = CPLib.NullDate();
    _maxope = CPLib.NullDate();
    _datini = CPLib.NullDate();
    _datfin = CPLib.NullDate();
    _luonas = false;
    _tipoint = 0;
    _ragsoc = CPLib.Space(0);
    _vuotoragsoc = false;
    _pf = false;
    _connes = CPLib.Space(0);
    _passa = false;
    _cf12 = CPLib.Space(0);
    _lencf12 = 0;
    _app = CPLib.Space(0);
    _findvuoto = false;
    _datanas = CPLib.NullDate();
    w_dadata = CPLib.NullDate();
    w_a_data = CPLib.NullDate();
    _saldi = CPLib.Space(0);
    _provnas = CPLib.Space(2);
    _idbase = CPLib.Space(10);
    _univoco = CPLib.Space(50);
    pdata = null;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_famesiti_minmax,qbe_famesiti_migra_sel,
  public static final String m_cVQRList = ",qbe_famesiti_minmax,qbe_famesiti_migra_sel,";
  // ENTITY_BATCHES: ,arfn_fdate,arfn_fdatetime,arrt_fammigra_imp,
  public static final String i_InvokedRoutines = ",arfn_fdate,arfn_fdatetime,arrt_fammigra_imp,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000095(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUER,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"INVIATO,";
    p_cSql = p_cSql+"DATAINVIO,";
    p_cSql = p_cSql+"INVSALDO,";
    p_cSql = p_cSql+"PROGOPEX,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
}
