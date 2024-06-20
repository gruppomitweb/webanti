// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_fammigra_stpR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
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
  public String w_flgwrt;
  public String w_flgnoe;
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
  public MemoryCursor_mcesitierr_mcrdef mcEsitiErr;
  public String _paese;
  public String _paeseres;
  public double _contaerr;
  public String _valage;
  public MemoryCursor_mcfamiglia_mcrdef mcFamCom;
  public MemoryCursor_mcfamiglia_mcrdef mcFam0;
  public MemoryCursor_mcfamiglia_mcrdef mcFam5;
  public MemoryCursor_mcfamiglia_mcrdef mcFam7;
  public MemoryCursor_mcfamiglia_mcrdef mcFam8;
  public MemoryCursorRow_mcfamiglia_mcrdef rowFamCom;
  public MemoryCursor_famesitid mcFamesitid;
  public MemoryCursorRow_famesitid rowFamesitid;
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
  public double _anno;
  public String _anno1;
  public String _anno2;
  public String _anno3;
  public String _anno4;
  public String _anno5;
  public String _anno6;
  public String _anno7;
  public double _tipoint;
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
  public arrt_fammigra_stpR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_fammigra_stp",m_Caller);
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
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    if (CPLib.eqr("_tipoint",p_cVarName)) {
      return _tipoint;
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
      return "arrt_fammigra_stp";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("flgwrt",p_cVarName)) {
      return w_flgwrt;
    }
    if (CPLib.eqr("flgnoe",p_cVarName)) {
      return w_flgnoe;
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
    if (CPLib.eqr("_anno1",p_cVarName)) {
      return _anno1;
    }
    if (CPLib.eqr("_anno2",p_cVarName)) {
      return _anno2;
    }
    if (CPLib.eqr("_anno3",p_cVarName)) {
      return _anno3;
    }
    if (CPLib.eqr("_anno4",p_cVarName)) {
      return _anno4;
    }
    if (CPLib.eqr("_anno5",p_cVarName)) {
      return _anno5;
    }
    if (CPLib.eqr("_anno6",p_cVarName)) {
      return _anno6;
    }
    if (CPLib.eqr("_anno7",p_cVarName)) {
      return _anno7;
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
    if (CPLib.eqr("mcEsitiErr",p_cVarName)) {
      return mcEsitiErr;
    }
    if (CPLib.eqr("mcFamCom",p_cVarName)) {
      return mcFamCom;
    }
    if (CPLib.eqr("mcFam0",p_cVarName)) {
      return mcFam0;
    }
    if (CPLib.eqr("mcFam5",p_cVarName)) {
      return mcFam5;
    }
    if (CPLib.eqr("mcFam7",p_cVarName)) {
      return mcFam7;
    }
    if (CPLib.eqr("mcFam8",p_cVarName)) {
      return mcFam8;
    }
    if (CPLib.eqr("mcFamesitid",p_cVarName)) {
      return mcFamesitid;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowFamCom",p_cVarName)) {
      return rowFamCom;
    }
    if (CPLib.eqr("rowFamesitid",p_cVarName)) {
      return rowFamesitid;
    }
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
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
    if (CPLib.eqr("_anno",p_cVarName)) {
      _anno = value;
      return;
    }
    if (CPLib.eqr("_tipoint",p_cVarName)) {
      _tipoint = value;
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
    if (CPLib.eqr("flgwrt",p_cVarName)) {
      w_flgwrt = value;
      return;
    }
    if (CPLib.eqr("flgnoe",p_cVarName)) {
      w_flgnoe = value;
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
    if (CPLib.eqr("_anno1",p_cVarName)) {
      _anno1 = value;
      return;
    }
    if (CPLib.eqr("_anno2",p_cVarName)) {
      _anno2 = value;
      return;
    }
    if (CPLib.eqr("_anno3",p_cVarName)) {
      _anno3 = value;
      return;
    }
    if (CPLib.eqr("_anno4",p_cVarName)) {
      _anno4 = value;
      return;
    }
    if (CPLib.eqr("_anno5",p_cVarName)) {
      _anno5 = value;
      return;
    }
    if (CPLib.eqr("_anno6",p_cVarName)) {
      _anno6 = value;
      return;
    }
    if (CPLib.eqr("_anno7",p_cVarName)) {
      _anno7 = value;
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
    if (CPLib.eqr("rowFamCom",p_cVarName)) {
      rowFamCom = (MemoryCursorRow_mcfamiglia_mcrdef)value;
      return;
    }
    if (CPLib.eqr("rowFamesitid",p_cVarName)) {
      rowFamesitid = (MemoryCursorRow_famesitid)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcEsitiErr",p_cVarName)) {
      mcEsitiErr = (MemoryCursor_mcesitierr_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcFamCom",p_cVarName)) {
      mcFamCom = (MemoryCursor_mcfamiglia_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcFam0",p_cVarName)) {
      mcFam0 = (MemoryCursor_mcfamiglia_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcFam5",p_cVarName)) {
      mcFam5 = (MemoryCursor_mcfamiglia_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcFam7",p_cVarName)) {
      mcFam7 = (MemoryCursor_mcfamiglia_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcFam8",p_cVarName)) {
      mcFam8 = (MemoryCursor_mcfamiglia_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcFamesitid",p_cVarName)) {
      mcFamesitid = (MemoryCursor_famesitid)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Pag_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_famesiti_minmax=null;
    CPResultSet Cursor_qbe_famesiti_migra_sel=null;
    CPResultSet Cursor_opextrbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_famesitid=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_aetesta=null;
    CPResultSet Cursor_aeannora=null;
    CPResultSet Cursor_qbe_famesiti_jntestbo_minmax=null;
    CPResultSet Cursor_qbe_famesiti_intestbo_minmax=null;
    CPResultSet Cursor_qbe_famesiti_noopex=null;
    CPResultSet Cursor_qbe_famesiti_norapp=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_dadata Date */
      /* w_a_data Date */
      /* w_flgwrt Char(1) */
      /* w_flgnoe Char(1) */
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
      /* mcEsitiErr MemoryCursor(mcEsitiErr.MCRDef) */
      /* _paese Char(3) */
      /* _paeseres Char(40) */
      /* _contaerr Numeric(10, 0) */
      /* _valage Char(60) */
      /* mcFamCom MemoryCursor(mcFamiglia.MCRDef) */
      /* mcFam0 MemoryCursor(mcFamiglia.MCRDef) */
      /* mcFam5 MemoryCursor(mcFamiglia.MCRDef) */
      /* mcFam7 MemoryCursor(mcFamiglia.MCRDef) */
      /* mcFam8 MemoryCursor(mcFamiglia.MCRDef) */
      /* rowFamCom Row(mcFamiglia.MCRDef) */
      /* mcFamesitid MemoryCursor(famesitid) */
      /* rowFamesitid Row(famesitid) */
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
      /* _anno Numeric(4, 0) */
      /* _anno1 Char(4) */
      /* _anno2 Char(4) */
      /* _anno3 Char(4) */
      /* _anno4 Char(4) */
      /* _anno5 Char(4) */
      /* _anno6 Char(4) */
      /* _anno7 Char(4) */
      /* _tipoint Numeric(1, 0) */
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
        /* _anno := Year(_datamax) */
        _anno = CPLib.Round(CPLib.Year(_datamax),0);
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _maxope := arfn_fammigra_datamax(_datamax) */
      _maxope = arfn_fammigra_datamaxR.Make(m_Ctx,this).Run(_datamax);
      /* If _anno > 0 */
      if (CPLib.gt(_anno,0)) {
        /* _anno1 := Str((_anno - 7),4,0) */
        _anno1 = CPLib.Str((_anno-7),4,0);
        /* _anno2 := Str((_anno - 6),4,0) */
        _anno2 = CPLib.Str((_anno-6),4,0);
        /* _anno3 := Str((_anno - 5),4,0) */
        _anno3 = CPLib.Str((_anno-5),4,0);
        /* _anno4 := Str((_anno - 4),4,0) */
        _anno4 = CPLib.Str((_anno-4),4,0);
        /* _anno5 := Str((_anno - 3),4,0) */
        _anno5 = CPLib.Str((_anno-3),4,0);
        /* _anno6 := Str((_anno - 2),4,0) */
        _anno6 = CPLib.Str((_anno-2),4,0);
        /* _anno7 := Str((_anno - 1),4,0) */
        _anno7 = CPLib.Str((_anno-1),4,0);
      } // End If
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
      double nTry00000067status;
      nTry00000067status = m_Sql.GetTransactionStatus();
      String cTry00000067msg;
      cTry00000067msg = m_Sql.TransactionErrorMessage();
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
        SPBridge.HMCaller _h0000006D;
        _h0000006D = new SPBridge.HMCaller();
        _h0000006D.Set("m_cVQRList",m_cVQRList);
        _h0000006D.Set("dadata",w_dadata);
        _h0000006D.Set("a_data",w_a_data);
        if (Cursor_qbe_famesiti_minmax!=null)
          Cursor_qbe_famesiti_minmax.Close();
        Cursor_qbe_famesiti_minmax = new VQRHolder("qbe_famesiti_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000006D,true).GetResultSet(m_Ctx);
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
        /* Info Msg "Minimo %1 - Massimo %2 - Totale Record %3" */
        if ( ! (CPLib.IsNull(m_Info))) {
          m_Info.log(CPLib.FormatMsg(m_Ctx,"Minimo %1 - Massimo %2 - Totale Record %3",_min,_max,_tot));
        }
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
        /* Info Msg "Cicli %1" */
        if ( ! (CPLib.IsNull(m_Info))) {
          m_Info.log(CPLib.FormatMsg(m_Ctx,"Cicli %1",_cicli));
        }
        /* While _contacicli<=_cicli */
        while (CPLib.le(_contacicli,_cicli)) {
          /* gMsgProc := gMsgProc + 'Ciclo '+ LRTrim(Str(_contacicli,5,0)) + " su "+LRTrim(Str(_cicli,5,0))+NL // Messaggio */
          gMsgProc = gMsgProc+"Ciclo "+CPLib.LRTrim(CPLib.Str(_contacicli,5,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,5,0))+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
              /* _top := _min + 4999 */
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
            SPBridge.HMCaller _h00000089;
            _h00000089 = new SPBridge.HMCaller();
            _h00000089.Set("m_cVQRList",m_cVQRList);
            _h00000089.Set("_bottom",_bottom);
            _h00000089.Set("_top",_top);
            _h00000089.Set("dadata",w_dadata);
            _h00000089.Set("a_data",w_a_data);
            if (Cursor_qbe_famesiti_migra_sel!=null)
              Cursor_qbe_famesiti_migra_sel.Close();
            Cursor_qbe_famesiti_migra_sel = new VQRHolder("qbe_famesiti_migra_sel",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000089,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_famesiti_migra_sel.Eof())) {
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
                // * --- Select from opextrbo
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                if (Cursor_opextrbo!=null)
                  Cursor_opextrbo.Close();
                Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"UNIQUER="+CPSql.SQLValueAdapter(CPLib.ToSQL(_famcodice,"?",0,0,m_cServer, m_oParameters),m_cServer,_famcodice)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_opextrbo.Eof())) {
                  /* _rapporto := opextrbo->RAPPORTO */
                  _rapporto = Cursor_opextrbo.GetString("RAPPORTO");
                  /* _ndgsog := opextrbo->COLLEG */
                  _ndgsog = Cursor_opextrbo.GetString("COLLEG");
                  /* _codfisc := '' */
                  _codfisc = "";
                  /* _nome := '' */
                  _nome = "";
                  /* _cognome := '' */
                  _cognome = "";
                  // * --- Read from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ndgsog,"C",16,0,m_cServer),m_cServer,_ndgsog);
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NOME",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COGNOME",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _codfisc = Read_Cursor.GetString("CODFISC");
                    _nome = Read_Cursor.GetString("NOME");
                    _cognome = Read_Cursor.GetString("COGNOME");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on personbo into routine arrt_fammigra_stp returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _codfisc = "";
                    _nome = "";
                    _cognome = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _trovato := 1 */
                  _trovato = CPLib.Round(1,0);
                  /* If opextrbo->DATAOPE <> qbe_famesiti_migra_sel->FAMDATINI */
                  if (CPLib.ne(Cursor_opextrbo.GetDate("DATAOPE"),Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATINI"))) {
                    /* _errore := '* - Data Prima Operazione non coincide' */
                    _errore = "* - Data Prima Operazione non coincide";
                    /* _contaerr := _contaerr + 1 */
                    _contaerr = CPLib.Round(_contaerr+1,0);
                    /* If w_flgwrt='M' */
                    if (CPLib.eqr(w_flgwrt,"M")) {
                      /* mcEsitiErr.AppendBlank() */
                      mcEsitiErr.AppendBlank();
                      /* mcEsitiErr.UNIQUECODE := _famcodice */
                      mcEsitiErr.row.UNIQUECODE = _famcodice;
                      /* mcEsitiErr.RAPPORTO := _rapporto */
                      mcEsitiErr.row.RAPPORTO = _rapporto;
                      /* mcEsitiErr.TIPORAP := 'O' */
                      mcEsitiErr.row.TIPORAP = "O";
                      /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                      mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                      /* mcEsitiErr.DATOMIT := DateToChar(opextrbo->DATAOPE) */
                      mcEsitiErr.row.DATOMIT = CPLib.DateToChar(Cursor_opextrbo.GetDate("DATAOPE"));
                      /* mcEsitiErr.DATOAGE := DateToChar(qbe_famesiti_migra_sel->FAMDATINI) */
                      mcEsitiErr.row.DATOAGE = CPLib.DateToChar(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATINI"));
                      /* mcEsitiErr.ERRMSG := _errore */
                      mcEsitiErr.row.ERRMSG = _errore;
                      /* mcEsitiErr.COGNOME := _cognome */
                      mcEsitiErr.row.COGNOME = _cognome;
                      /* mcEsitiErr.NOME := _nome */
                      mcEsitiErr.row.NOME = _nome;
                      /* mcEsitiErr.CODFISC := _codfisc */
                      mcEsitiErr.row.CODFISC = _codfisc;
                    } else { // Else
                      // * --- Insert into tmp_esitierr from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_esitierr");
                      m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000000A9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000A9(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_opextrbo.GetDate("DATAOPE")),"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATINI")),"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_cognome,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_nome,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_codfisc,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                    } // End If
                  } // End If
                  /* _errore := '' */
                  _errore = "";
                  /* If opextrbo->ANNO=_anno1 and qbe_famesiti_migra_sel->FAMSAL2011='0' and opextrbo->INVSALDO =1 */
                  if (CPLib.eqr(Cursor_opextrbo.GetString("ANNO"),_anno1) && CPLib.eqr(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2011"),"0") && CPLib.eqr(Cursor_opextrbo.GetDouble("INVSALDO"),1)) {
                    /* _errore := '* - Saldo ' + _anno1 + ' non inviato' */
                    _errore = "* - Saldo "+_anno1+" non inviato";
                    /* _valage := "Saldo Inviato AGE: "+qbe_famesiti_migra_sel->FAMSAL2011 */
                    _valage = "Saldo Inviato AGE: "+Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2011");
                  } // End If
                  /* If opextrbo->ANNO=_anno2 and qbe_famesiti_migra_sel->FAMSAL2012='0'  and opextrbo->INVSALDO =1 */
                  if (CPLib.eqr(Cursor_opextrbo.GetString("ANNO"),_anno2) && CPLib.eqr(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2012"),"0") && CPLib.eqr(Cursor_opextrbo.GetDouble("INVSALDO"),1)) {
                    /* _errore := '* - Saldo ' + _anno2 + ' non inviato' */
                    _errore = "* - Saldo "+_anno2+" non inviato";
                    /* _valage := "Saldo Inviato AGE: "+qbe_famesiti_migra_sel->FAMSAL2012 */
                    _valage = "Saldo Inviato AGE: "+Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2012");
                  } // End If
                  /* If opextrbo->ANNO=_anno3 and qbe_famesiti_migra_sel->FAMSAL2013='0' and opextrbo->INVSALDO =1 */
                  if (CPLib.eqr(Cursor_opextrbo.GetString("ANNO"),_anno3) && CPLib.eqr(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2013"),"0") && CPLib.eqr(Cursor_opextrbo.GetDouble("INVSALDO"),1)) {
                    /* _errore := '* - Saldo ' + _anno3 + ' non inviato' */
                    _errore = "* - Saldo "+_anno3+" non inviato";
                    /* _valage := "Saldo Inviato AGE: "+qbe_famesiti_migra_sel->FAMSAL2013 */
                    _valage = "Saldo Inviato AGE: "+Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2013");
                  } // End If
                  /* If opextrbo->ANNO=_anno4 and qbe_famesiti_migra_sel->FAMSAL2014='0' and opextrbo->INVSALDO =1 */
                  if (CPLib.eqr(Cursor_opextrbo.GetString("ANNO"),_anno4) && CPLib.eqr(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2014"),"0") && CPLib.eqr(Cursor_opextrbo.GetDouble("INVSALDO"),1)) {
                    /* _errore := '* - Saldo ' + _anno4 + ' non inviato' */
                    _errore = "* - Saldo "+_anno4+" non inviato";
                    /* _valage := "Saldo Inviato AGE: "+qbe_famesiti_migra_sel->FAMSAL2014 */
                    _valage = "Saldo Inviato AGE: "+Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2014");
                  } // End If
                  /* If opextrbo->ANNO=_anno5 and qbe_famesiti_migra_sel->FAMSAL2015='0'  and opextrbo->INVSALDO =1 */
                  if (CPLib.eqr(Cursor_opextrbo.GetString("ANNO"),_anno5) && CPLib.eqr(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2015"),"0") && CPLib.eqr(Cursor_opextrbo.GetDouble("INVSALDO"),1)) {
                    /* _errore := '* - Saldo ' + _anno5 + ' non inviato' */
                    _errore = "* - Saldo "+_anno5+" non inviato";
                    /* _valage := "Saldo Inviato AGE: "+qbe_famesiti_migra_sel->FAMSAL2015 */
                    _valage = "Saldo Inviato AGE: "+Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2015");
                  } // End If
                  /* If opextrbo->ANNO=_anno6 and qbe_famesiti_migra_sel->FAMSAL2016='0' and opextrbo->INVSALDO =1 */
                  if (CPLib.eqr(Cursor_opextrbo.GetString("ANNO"),_anno6) && CPLib.eqr(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2016"),"0") && CPLib.eqr(Cursor_opextrbo.GetDouble("INVSALDO"),1)) {
                    /* _errore := '* - Saldo ' + _anno6 + ' non inviato' */
                    _errore = "* - Saldo "+_anno6+" non inviato";
                    /* _valage := "Saldo Inviato AGE: "+qbe_famesiti_migra_sel->FAMSAL2016 */
                    _valage = "Saldo Inviato AGE: "+Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2016");
                  } // End If
                  /* If opextrbo->ANNO=_anno7 and qbe_famesiti_migra_sel->FAMSAL2017='0' and opextrbo->INVSALDO =1 */
                  if (CPLib.eqr(Cursor_opextrbo.GetString("ANNO"),_anno7) && CPLib.eqr(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2017"),"0") && CPLib.eqr(Cursor_opextrbo.GetDouble("INVSALDO"),1)) {
                    /* _errore := '* - Saldo ' + _anno7 + ' non inviato' */
                    _errore = "* - Saldo "+_anno7+" non inviato";
                    /* _valage := "Saldo Inviato AGE: "+qbe_famesiti_migra_sel->FAMSAL2017 */
                    _valage = "Saldo Inviato AGE: "+Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2017");
                  } // End If
                  /* If Len(LRTrim(_errore)) > 0 */
                  if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_errore)),0)) {
                    /* _contaerr := _contaerr + 1 */
                    _contaerr = CPLib.Round(_contaerr+1,0);
                    /* mcEsitiErr.AppendBlank() */
                    mcEsitiErr.AppendBlank();
                    /* mcEsitiErr.UNIQUECODE := _famcodice */
                    mcEsitiErr.row.UNIQUECODE = _famcodice;
                    /* mcEsitiErr.RAPPORTO := _rapporto */
                    mcEsitiErr.row.RAPPORTO = _rapporto;
                    /* mcEsitiErr.TIPORAP := 'O' */
                    mcEsitiErr.row.TIPORAP = "O";
                    /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                    mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                    /* mcEsitiErr.DATOMIT := "Saldo Inviato MIT: "+Str(opextrbo->INVSALDO,1,0) */
                    mcEsitiErr.row.DATOMIT = "Saldo Inviato MIT: "+CPLib.Str(Cursor_opextrbo.GetDouble("INVSALDO"),1,0);
                    /* mcEsitiErr.DATOAGE := _valage */
                    mcEsitiErr.row.DATOAGE = _valage;
                    /* mcEsitiErr.ERRMSG := _errore */
                    mcEsitiErr.row.ERRMSG = _errore;
                    /* mcEsitiErr.COGNOME := _cognome */
                    mcEsitiErr.row.COGNOME = _cognome;
                    /* mcEsitiErr.NOME := _nome */
                    mcEsitiErr.row.NOME = _nome;
                    /* mcEsitiErr.CODFISC := _codfisc */
                    mcEsitiErr.row.CODFISC = _codfisc;
                    /* If w_flgwrt='M' */
                    if (CPLib.eqr(w_flgwrt,"M")) {
                      /* mcEsitiErr.AppendBlank() */
                      mcEsitiErr.AppendBlank();
                      /* mcEsitiErr.UNIQUECODE := _famcodice */
                      mcEsitiErr.row.UNIQUECODE = _famcodice;
                      /* mcEsitiErr.RAPPORTO := _rapporto */
                      mcEsitiErr.row.RAPPORTO = _rapporto;
                      /* mcEsitiErr.TIPORAP := 'O' */
                      mcEsitiErr.row.TIPORAP = "O";
                      /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                      mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                      /* mcEsitiErr.DATOMIT := "Saldo Inviato MIT: "+Str(opextrbo->INVSALDO,1,0) */
                      mcEsitiErr.row.DATOMIT = "Saldo Inviato MIT: "+CPLib.Str(Cursor_opextrbo.GetDouble("INVSALDO"),1,0);
                      /* mcEsitiErr.DATOAGE := _valage */
                      mcEsitiErr.row.DATOAGE = _valage;
                      /* mcEsitiErr.ERRMSG := _errore */
                      mcEsitiErr.row.ERRMSG = _errore;
                      /* mcEsitiErr.COGNOME := _cognome */
                      mcEsitiErr.row.COGNOME = _cognome;
                      /* mcEsitiErr.NOME := _nome */
                      mcEsitiErr.row.NOME = _nome;
                      /* mcEsitiErr.CODFISC := _codfisc */
                      mcEsitiErr.row.CODFISC = _codfisc;
                    } else { // Else
                      // * --- Insert into tmp_esitierr from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_esitierr");
                      m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000000DA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000DA(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("Saldo Inviato MIT: "+CPLib.Str(Cursor_opextrbo.GetDouble("INVSALDO"),1,0),"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_valage,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_cognome,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_nome,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_codfisc,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                    } // End If
                  } // End If
                  /* _errore := '' */
                  _errore = "";
                  // * --- Select from famesitid
                  m_cServer = m_Ctx.GetServer("famesitid");
                  m_cPhName = m_Ctx.GetPhName("famesitid");
                  if (Cursor_famesitid!=null)
                    Cursor_famesitid.Close();
                  Cursor_famesitid = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"FADRAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_famcodice,"?",0,0,m_cServer, m_oParameters),m_cServer,_famcodice)+" "+")"+(m_Ctx.IsSharedTemp("famesitid")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_famesitid.Eof())) {
                    /* If not(Empty(famesitid->FADCODFIS)) */
                    if ( ! (CPLib.Empty(Cursor_famesitid.GetString("FADCODFIS")))) {
                      /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim('******'+Right(LRTrim(_codfisc),10)) */
                      if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("******"+CPLib.Right(CPLib.LRTrim(_codfisc),10)))) {
                        /* _errore := '* - Codice Fiscale non corrisponde' */
                        _errore = "* - Codice Fiscale non corrisponde";
                        /* _contaerr := _contaerr + 1 */
                        _contaerr = CPLib.Round(_contaerr+1,0);
                        /* If w_flgwrt='M' */
                        if (CPLib.eqr(w_flgwrt,"M")) {
                          /* mcEsitiErr.AppendBlank() */
                          mcEsitiErr.AppendBlank();
                          /* mcEsitiErr.UNIQUECODE := _famcodice */
                          mcEsitiErr.row.UNIQUECODE = _famcodice;
                          /* mcEsitiErr.RAPPORTO := _rapporto */
                          mcEsitiErr.row.RAPPORTO = _rapporto;
                          /* mcEsitiErr.TIPORAP := 'O' */
                          mcEsitiErr.row.TIPORAP = "O";
                          /* mcEsitiErr.NDGSOG := _ndgsog */
                          mcEsitiErr.row.NDGSOG = _ndgsog;
                          /* mcEsitiErr.DATOMIT := 'CF MIT: '+_codfisc */
                          mcEsitiErr.row.DATOMIT = "CF MIT: "+_codfisc;
                          /* mcEsitiErr.DATOAGE := 'CF AGE: '+famesitid->FADCODFIS */
                          mcEsitiErr.row.DATOAGE = "CF AGE: "+Cursor_famesitid.GetString("FADCODFIS");
                          /* mcEsitiErr.ERRMSG := _errore */
                          mcEsitiErr.row.ERRMSG = _errore;
                          /* mcEsitiErr.COGNOME := _cognome */
                          mcEsitiErr.row.COGNOME = _cognome;
                          /* mcEsitiErr.NOME := _nome */
                          mcEsitiErr.row.NOME = _nome;
                          /* mcEsitiErr.CODFISC := _codfisc */
                          mcEsitiErr.row.CODFISC = _codfisc;
                        } else { // Else
                          // * --- Insert into tmp_esitierr from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("tmp_esitierr");
                          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000000ED")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                          m_cSql = m_cSql+GetFieldsName_000000ED(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("CF MIT: "+_codfisc,"?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("CF AGE: "+Cursor_famesitid.GetString("FADCODFIS"),"?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_cognome,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_nome,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_codfisc,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                        } // End If
                      } // End If
                    } else { // Else
                      // * --- Select from personbo
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select COGNOME,NOME,RAGSOC,DATANASC,PAESE,NASCOMUN,TIPINTER,NASSTATO,PROVINCIA,SESSO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_opextrbo.GetString("COLLEG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_personbo.Eof())) {
                        /* _sesso := iif(personbo->SESSO='1','M',iif(personbo->SESSO='2','F','')) */
                        _sesso = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1")?"M":(CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"F":""));
                        /* _nascom := LRTrim(arfn_clear_nascita(personbo->NASCOMUN)) */
                        _nascom = CPLib.LRTrim(arfn_clear_nascitaR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASCOMUN")));
                        /* _nassta := LRTrim(arfn_clear_nascita(personbo->NASSTATO)) */
                        _nassta = CPLib.LRTrim(arfn_clear_nascitaR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASSTATO")));
                        /* If Empty(famesitid->FADSESSO) and Empty(famesitid->FADDATNAS) */
                        if (CPLib.Empty(Cursor_famesitid.GetString("FADSESSO")) && CPLib.Empty(Cursor_famesitid.GetDate("FADDATNAS"))) {
                          /* _paese := '' */
                          _paese = "";
                          // * --- Read from tbstati
                          m_cServer = m_Ctx.GetServer("tbstati");
                          m_cPhName = m_Ctx.GetPhName("tbstati");
                          m_cSql = "";
                          m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_famesitid.GetString("FADNASSEL"),"C",40,0,m_cServer),m_cServer,Cursor_famesitid.GetString("FADNASSEL"));
                          if (m_Ctx.IsSharedTemp("tbstati")) {
                            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                          }
                          if (Read_Cursor!=null)
                            Read_Cursor.Close();
                          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                          if ( ! (Read_Cursor.Eof())) {
                            _paese = Read_Cursor.GetString("CODSTA");
                            Read_Cursor.Next();
                            if ( ! (Read_Cursor.Eof())) {
                              Error l_oErrorFault = new Error("Read on tbstati into routine arrt_fammigra_stp returns two or more records. This item should return only a record.");
                              CPStdCounter.Error(l_oErrorFault);
                            }
                            Read_Cursor.Close();
                          } else {
                            // Error: no record found!
                            _paese = "";
                            Read_Cursor.Close();
                            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                          }
                          /* If (_paese <> personbo->PAESE) or (LRTrim(famesitid->FADCOGRAG) <> LRTrim(personbo->RAGSOC)) or (LRTrim(famesitid->FADPRVSEL) <> LRTrim(personbo->PROVINCIA)) */
                          if ((CPLib.ne(_paese,Cursor_personbo.GetString("PAESE"))) || (CPLib.ne(CPLib.LRTrim(Cursor_famesitid.GetString("FADCOGRAG")),CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC")))) || (CPLib.ne(CPLib.LRTrim(Cursor_famesitid.GetString("FADPRVSEL")),CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))))) {
                            /* _errore := '* - Dati persona giuridica non corrispondono' */
                            _errore = "* - Dati persona giuridica non corrispondono";
                            /* _contaerr := _contaerr + 1 */
                            _contaerr = CPLib.Round(_contaerr+1,0);
                            /* If w_flgwrt='M' */
                            if (CPLib.eqr(w_flgwrt,"M")) {
                              /* mcEsitiErr.AppendBlank() */
                              mcEsitiErr.AppendBlank();
                              /* mcEsitiErr.UNIQUECODE := _famcodice */
                              mcEsitiErr.row.UNIQUECODE = _famcodice;
                              /* mcEsitiErr.RAPPORTO := _rapporto */
                              mcEsitiErr.row.RAPPORTO = _rapporto;
                              /* mcEsitiErr.TIPORAP := 'O' */
                              mcEsitiErr.row.TIPORAP = "O";
                              /* mcEsitiErr.NDGSOG := _ndgsog */
                              mcEsitiErr.row.NDGSOG = _ndgsog;
                              /* mcEsitiErr.DATOMIT := 'Dati MIT: '+LRTrim(personbo->RAGSOC)+" - " + personbo->PAESE +" - "+ personbo->PROVINCIA */
                              mcEsitiErr.row.DATOMIT = "Dati MIT: "+CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+" - "+Cursor_personbo.GetString("PAESE")+" - "+Cursor_personbo.GetString("PROVINCIA");
                              /* mcEsitiErr.DATOAGE := 'Dati AGE: '+LRTrim(famesitid->FADCOGRAG)+" - " + _paese +" - "+ famesitid->FADPRVSEL */
                              mcEsitiErr.row.DATOAGE = "Dati AGE: "+CPLib.LRTrim(Cursor_famesitid.GetString("FADCOGRAG"))+" - "+_paese+" - "+Cursor_famesitid.GetString("FADPRVSEL");
                              /* mcEsitiErr.ERRMSG := _errore */
                              mcEsitiErr.row.ERRMSG = _errore;
                              /* mcEsitiErr.COGNOME := _cognome */
                              mcEsitiErr.row.COGNOME = _cognome;
                              /* mcEsitiErr.NOME := _nome */
                              mcEsitiErr.row.NOME = _nome;
                              /* mcEsitiErr.CODFISC := _codfisc */
                              mcEsitiErr.row.CODFISC = _codfisc;
                            } else { // Else
                              // * --- Insert into tmp_esitierr from values
                              m_Sql.RequireTransaction();
                              m_cServer = m_Ctx.GetServer("tmp_esitierr");
                              m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                              m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000104")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                              m_cSql = m_cSql+GetFieldsName_00000104(m_Ctx,m_oWrInfo);
                              m_cSql = m_cSql+") values (";
                              m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL("Dati MIT: "+CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+" - "+Cursor_personbo.GetString("PAESE")+" - "+Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer, m_oParameters)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL("Dati AGE: "+CPLib.LRTrim(Cursor_famesitid.GetString("FADCOGRAG"))+" - "+_paese+" - "+Cursor_famesitid.GetString("FADPRVSEL"),"?",0,0,m_cServer, m_oParameters)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL(_cognome,"?",0,0,m_cServer)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL(_nome,"?",0,0,m_cServer)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL(_codfisc,"?",0,0,m_cServer)+", ";
                              m_cSql = m_cSql+m_oWrInfo.InsertValues();
                              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                            } // End If
                          } // End If
                        } else { // Else
                          /* _luonas := iif(personbo->TIPINTER <> 'EE',Upper(LRTrim(arfn_clear_nascita(LRTrim(famesitid->FADNASSEL)))) <> Upper(LRTrim(arfn_clear_nascita(LRTrim(_nascom)))),Upper(LRTrim(arfn_clear_nascita(LRTrim(famesitid->FADNASSEL)))) <> Upper(LRTrim(arfn_clear_nascita(LRTrim(_nassta))))) */
                          _luonas = (CPLib.ne(Cursor_personbo.GetString("TIPINTER"),"EE")?CPLib.ne(CPLib.Upper(CPLib.LRTrim(arfn_clear_nascitaR.Make(m_Ctx,this).Run(CPLib.LRTrim(Cursor_famesitid.GetString("FADNASSEL"))))),CPLib.Upper(CPLib.LRTrim(arfn_clear_nascitaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_nascom))))):CPLib.ne(CPLib.Upper(CPLib.LRTrim(arfn_clear_nascitaR.Make(m_Ctx,this).Run(CPLib.LRTrim(Cursor_famesitid.GetString("FADNASSEL"))))),CPLib.Upper(CPLib.LRTrim(arfn_clear_nascitaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_nassta))))));
                          /* If (Upper(LRTrim(famesitid->FADPRVSEL)) <> Upper(LRTrim(personbo->TIPINTER))) or (famesitid->FADDATNAS <> personbo->DATANASC) or (Upper(LRTrim(famesitid->FADSESSO)) <> _sesso) or _luonas */
                          if ((CPLib.ne(CPLib.Upper(CPLib.LRTrim(Cursor_famesitid.GetString("FADPRVSEL"))),CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("TIPINTER"))))) || (CPLib.ne(Cursor_famesitid.GetDate("FADDATNAS"),Cursor_personbo.GetDate("DATANASC"))) || (CPLib.ne(CPLib.Upper(CPLib.LRTrim(Cursor_famesitid.GetString("FADSESSO"))),_sesso)) || _luonas) {
                            /* _errore := '* - Dati persona fisica non corrispondono' */
                            _errore = "* - Dati persona fisica non corrispondono";
                            /* _contaerr := _contaerr + 1 */
                            _contaerr = CPLib.Round(_contaerr+1,0);
                            /* If w_flgwrt='M' */
                            if (CPLib.eqr(w_flgwrt,"M")) {
                              /* mcEsitiErr.AppendBlank() */
                              mcEsitiErr.AppendBlank();
                              /* mcEsitiErr.UNIQUECODE := _famcodice */
                              mcEsitiErr.row.UNIQUECODE = _famcodice;
                              /* mcEsitiErr.RAPPORTO := _rapporto */
                              mcEsitiErr.row.RAPPORTO = _rapporto;
                              /* mcEsitiErr.TIPORAP := 'O' */
                              mcEsitiErr.row.TIPORAP = "O";
                              /* mcEsitiErr.NDGSOG := _ndgsog */
                              mcEsitiErr.row.NDGSOG = _ndgsog;
                              /* mcEsitiErr.DATOMIT := 'Dati MIT: '+ Upper(arfn_fdate(personbo->DATANASC) + " - "+personbo->TIPINTER+" - "+iif(personbo->TIPINTER='EE',Upper(LRTrim(arfn_clear_nascita(LRTrim(_nassta)))),Upper(LRTrim(arfn_clear_nascita(LRTrim(_nascom)))))+" - "+_sesso) */
                              mcEsitiErr.row.DATOMIT = "Dati MIT: "+CPLib.Upper(arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATANASC"))+" - "+Cursor_personbo.GetString("TIPINTER")+" - "+(CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")?CPLib.Upper(CPLib.LRTrim(arfn_clear_nascitaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_nassta)))):CPLib.Upper(CPLib.LRTrim(arfn_clear_nascitaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_nascom)))))+" - "+_sesso);
                              /* mcEsitiErr.DATOAGE := 'Dati AGE: '+ Upper(arfn_fdate(famesitid->FADDATNAS) + " - "+famesitid->FADPRVSEL+" - "+Upper(LRTrim(arfn_clear_nascita(LRTrim(famesitid->FADNASSEL))))+" - "+famesitid->FADSESSO) */
                              mcEsitiErr.row.DATOAGE = "Dati AGE: "+CPLib.Upper(arfn_fdateR.Make(m_Ctx,this).Run(Cursor_famesitid.GetDate("FADDATNAS"))+" - "+Cursor_famesitid.GetString("FADPRVSEL")+" - "+CPLib.Upper(CPLib.LRTrim(arfn_clear_nascitaR.Make(m_Ctx,this).Run(CPLib.LRTrim(Cursor_famesitid.GetString("FADNASSEL")))))+" - "+Cursor_famesitid.GetString("FADSESSO"));
                              /* mcEsitiErr.ERRMSG := _errore */
                              mcEsitiErr.row.ERRMSG = _errore;
                              /* mcEsitiErr.COGNOME := _cognome */
                              mcEsitiErr.row.COGNOME = _cognome;
                              /* mcEsitiErr.NOME := _nome */
                              mcEsitiErr.row.NOME = _nome;
                              /* mcEsitiErr.CODFISC := _codfisc */
                              mcEsitiErr.row.CODFISC = _codfisc;
                            } else { // Else
                              // * --- Insert into tmp_esitierr from values
                              m_Sql.RequireTransaction();
                              m_cServer = m_Ctx.GetServer("tmp_esitierr");
                              m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                              m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000115")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                              m_cSql = m_cSql+GetFieldsName_00000115(m_Ctx,m_oWrInfo);
                              m_cSql = m_cSql+") values (";
                              m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL("Dati MIT: "+CPLib.Upper(arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATANASC"))+" - "+Cursor_personbo.GetString("TIPINTER")+" - "+(CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")?CPLib.Upper(CPLib.LRTrim(arfn_clear_nascitaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_nassta)))):CPLib.Upper(CPLib.LRTrim(arfn_clear_nascitaR.Make(m_Ctx,this).Run(CPLib.LRTrim(_nascom)))))+" - "+_sesso),"?",0,0,m_cServer, m_oParameters)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL("Dati AGE: "+CPLib.Upper(arfn_fdateR.Make(m_Ctx,this).Run(Cursor_famesitid.GetDate("FADDATNAS"))+" - "+Cursor_famesitid.GetString("FADPRVSEL")+" - "+CPLib.Upper(CPLib.LRTrim(arfn_clear_nascitaR.Make(m_Ctx,this).Run(CPLib.LRTrim(Cursor_famesitid.GetString("FADNASSEL")))))+" - "+Cursor_famesitid.GetString("FADSESSO")),"?",0,0,m_cServer, m_oParameters)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL(_cognome,"?",0,0,m_cServer)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL(_nome,"?",0,0,m_cServer)+", ";
                              m_cSql = m_cSql+""+CPLib.ToSQL(_codfisc,"?",0,0,m_cServer)+", ";
                              m_cSql = m_cSql+m_oWrInfo.InsertValues();
                              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                            } // End If
                          } // End If
                        } // End If
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      // * --- End Select
                    } // End If
                    Cursor_famesitid.Next();
                  }
                  m_cConnectivityError = Cursor_famesitid.ErrorMessage();
                  Cursor_famesitid.Close();
                  // * --- End Select
                  Cursor_opextrbo.Next();
                }
                m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
                Cursor_opextrbo.Close();
                // * --- End Select
                /* If _trovato=0 */
                if (CPLib.eqr(_trovato,0)) {
                  /* _errore := '* - Famiglia presente in AGE ma non in WEBANTI' */
                  _errore = "* - Famiglia presente in AGE ma non in WEBANTI";
                  /* _contaerr := _contaerr + 1 */
                  _contaerr = CPLib.Round(_contaerr+1,0);
                  /* If w_flgwrt='M' */
                  if (CPLib.eqr(w_flgwrt,"M")) {
                    /* mcEsitiErr.AppendBlank() */
                    mcEsitiErr.AppendBlank();
                    /* mcEsitiErr.UNIQUECODE := _famcodice */
                    mcEsitiErr.row.UNIQUECODE = _famcodice;
                    /* mcEsitiErr.TIPORAP := 'O' */
                    mcEsitiErr.row.TIPORAP = "O";
                    /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                    mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                    /* mcEsitiErr.ERRMSG := _errore */
                    mcEsitiErr.row.ERRMSG = _errore;
                  } else { // Else
                    // * --- Insert into tmp_esitierr from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_esitierr");
                    m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"0000011F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000011F(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                  } // End If
                } // End If
              } else { // Else
                // * --- Select from aetesta
                m_cServer = m_Ctx.GetServer("aetesta");
                m_cPhName = m_Ctx.GetPhName("aetesta");
                if (Cursor_aetesta!=null)
                  Cursor_aetesta.Close();
                Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_famcodice,"?",0,0,m_cServer, m_oParameters),m_cServer,_famcodice)+"  or  UNIQUER="+CPSql.SQLValueAdapter(CPLib.ToSQL(_famcodice,"?",0,0,m_cServer, m_oParameters),m_cServer,_famcodice)+" "+")"+(m_Ctx.IsSharedTemp("aetesta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aetesta.Eof())) {
                  /* gMsgImp := 'Sono state elaborate '+LRTrim(Str(conta,10,0))+' famiglie su '+ LRTrim(Str(_tot,10,0)) // Messaggio Import */
                  gMsgImp = "Sono state elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" famiglie su "+CPLib.LRTrim(CPLib.Str(_tot,10,0));
                  m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  /* _raporig := aetesta->RAPPORTO */
                  _raporig = Cursor_aetesta.GetString("RAPPORTO");
                  /* _ndgsog := Replicate('X',16) */
                  _ndgsog = CPLib.Replicate("X",16);
                  /* _trovato := 1 */
                  _trovato = CPLib.Round(1,0);
                  /* If aetesta->TIPOAG <> qbe_famesiti_migra_sel->FAMTIPORAP */
                  if (CPLib.ne(Cursor_aetesta.GetString("TIPOAG"),Cursor_qbe_famesiti_migra_sel.GetString("FAMTIPORAP"))) {
                    /* _contaerr := _contaerr + 1 */
                    _contaerr = CPLib.Round(_contaerr+1,0);
                    /* If w_flgwrt='M' */
                    if (CPLib.eqr(w_flgwrt,"M")) {
                      /* mcEsitiErr.AppendBlank() */
                      mcEsitiErr.AppendBlank();
                      /* mcEsitiErr.UNIQUECODE := _famcodice */
                      mcEsitiErr.row.UNIQUECODE = _famcodice;
                      /* mcEsitiErr.RAPPORTO := _raporig */
                      mcEsitiErr.row.RAPPORTO = _raporig;
                      /* mcEsitiErr.TIPORAP := 'R' */
                      mcEsitiErr.row.TIPORAP = "R";
                      /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                      mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                      /* mcEsitiErr.DATOMIT := "Tipo Rapporto MIT: "+aetesta->TIPOAG */
                      mcEsitiErr.row.DATOMIT = "Tipo Rapporto MIT: "+Cursor_aetesta.GetString("TIPOAG");
                      /* mcEsitiErr.DATOAGE := "Tipo Rapporto AGE: "+qbe_famesiti_migra_sel->FAMTIPORAP */
                      mcEsitiErr.row.DATOAGE = "Tipo Rapporto AGE: "+Cursor_qbe_famesiti_migra_sel.GetString("FAMTIPORAP");
                      /* mcEsitiErr.ERRMSG := '* Tipo rapporto diverso' */
                      mcEsitiErr.row.ERRMSG = "* Tipo rapporto diverso";
                    } else { // Else
                      // * --- Insert into tmp_esitierr from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_esitierr");
                      m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000131")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000131(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_raporig,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("Tipo Rapporto MIT: "+Cursor_aetesta.GetString("TIPOAG"),"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("Tipo Rapporto AGE: "+Cursor_qbe_famesiti_migra_sel.GetString("FAMTIPORAP"),"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("* Tipo rapporto diverso","?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                    } // End If
                  } // End If
                  /* If At(qbe_famesiti_migra_sel->FAMTIPORAP,'|08|11|13|16|17|18|19|20|21|22|99|') = 0 */
                  if (CPLib.eqr(CPLib.At(Cursor_qbe_famesiti_migra_sel.GetString("FAMTIPORAP"),"|08|11|13|16|17|18|19|20|21|22|99|"),0)) {
                    // * --- Select from aeannora
                    m_cServer = m_Ctx.GetServer("aeannora");
                    m_cPhName = m_Ctx.GetPhName("aeannora");
                    if (Cursor_aeannora!=null)
                      Cursor_aeannora.Close();
                    Cursor_aeannora = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO,ANNO,IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_raporig,"?",0,0,m_cServer, m_oParameters),m_cServer,_raporig)+" "+")"+(m_Ctx.IsSharedTemp("aeannora")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_aeannora.Eof())) {
                      /* If aeannora->ANNO=_anno1 and qbe_famesiti_migra_sel->FAMSAL2011='0' */
                      if (CPLib.eqr(Cursor_aeannora.GetString("ANNO"),_anno1) && CPLib.eqr(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2011"),"0")) {
                        /* _errore := '* - Saldo '+ _anno1+' non inviato/non dovuto' */
                        _errore = "* - Saldo "+_anno1+" non inviato/non dovuto";
                      } // End If
                      /* If aeannora->ANNO=_anno2 and qbe_famesiti_migra_sel->FAMSAL2012='0' */
                      if (CPLib.eqr(Cursor_aeannora.GetString("ANNO"),_anno2) && CPLib.eqr(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2012"),"0")) {
                        /* _errore := '* - Saldo ' + _anno2 + ' non inviato/non dovuto' */
                        _errore = "* - Saldo "+_anno2+" non inviato/non dovuto";
                      } // End If
                      /* If aeannora->ANNO=_anno3 and qbe_famesiti_migra_sel->FAMSAL2013='0' */
                      if (CPLib.eqr(Cursor_aeannora.GetString("ANNO"),_anno3) && CPLib.eqr(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2013"),"0")) {
                        /* _errore := '* - Saldo ' + _anno3 + ' non inviato/non dovuto' */
                        _errore = "* - Saldo "+_anno3+" non inviato/non dovuto";
                      } // End If
                      /* If aeannora->ANNO=_anno4 and qbe_famesiti_migra_sel->FAMSAL2014='0' */
                      if (CPLib.eqr(Cursor_aeannora.GetString("ANNO"),_anno4) && CPLib.eqr(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2014"),"0")) {
                        /* _errore := '* - Saldo ' + _anno4 + ' non inviato/non dovuto' */
                        _errore = "* - Saldo "+_anno4+" non inviato/non dovuto";
                      } // End If
                      /* If aeannora->ANNO=_anno5 and qbe_famesiti_migra_sel->FAMSAL2015='0' */
                      if (CPLib.eqr(Cursor_aeannora.GetString("ANNO"),_anno5) && CPLib.eqr(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2015"),"0")) {
                        /* _errore := '* - Saldo ' + _anno5 + ' non inviato/non dovuto' */
                        _errore = "* - Saldo "+_anno5+" non inviato/non dovuto";
                      } // End If
                      /* If aeannora->ANNO=_anno6 and qbe_famesiti_migra_sel->FAMSAL2016='0' */
                      if (CPLib.eqr(Cursor_aeannora.GetString("ANNO"),_anno6) && CPLib.eqr(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2016"),"0")) {
                        /* _errore := '* - Saldo ' + _anno6 + ' non inviato/non dovuto' */
                        _errore = "* - Saldo "+_anno6+" non inviato/non dovuto";
                      } // End If
                      /* If aeannora->ANNO=_anno7 and qbe_famesiti_migra_sel->FAMSAL2017='0' */
                      if (CPLib.eqr(Cursor_aeannora.GetString("ANNO"),_anno7) && CPLib.eqr(Cursor_qbe_famesiti_migra_sel.GetString("FAMSAL2017"),"0")) {
                        /* _errore := '* - Saldo ' + _anno7 + ' non inviato/non dovuto' */
                        _errore = "* - Saldo "+_anno7+" non inviato/non dovuto";
                      } // End If
                      /* If Len(LRTrim(_errore)) > 0 */
                      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_errore)),0)) {
                        /* _contaerr := _contaerr + 1 */
                        _contaerr = CPLib.Round(_contaerr+1,0);
                        /* If w_flgwrt='M' */
                        if (CPLib.eqr(w_flgwrt,"M")) {
                          /* mcEsitiErr.AppendBlank() */
                          mcEsitiErr.AppendBlank();
                          /* mcEsitiErr.UNIQUECODE := _famcodice */
                          mcEsitiErr.row.UNIQUECODE = _famcodice;
                          /* mcEsitiErr.RAPPORTO := _raporig */
                          mcEsitiErr.row.RAPPORTO = _raporig;
                          /* mcEsitiErr.TIPORAP := 'R' */
                          mcEsitiErr.row.TIPORAP = "R";
                          /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                          mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                          /* mcEsitiErr.ERRMSG := _errore */
                          mcEsitiErr.row.ERRMSG = _errore;
                        } else { // Else
                          // * --- Insert into tmp_esitierr from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("tmp_esitierr");
                          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"0000014C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                          m_cSql = m_cSql+GetFieldsName_0000014C(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_raporig,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                        } // End If
                        /* _errore := '' */
                        _errore = "";
                      } // End If
                      Cursor_aeannora.Next();
                    }
                    m_cConnectivityError = Cursor_aeannora.ErrorMessage();
                    Cursor_aeannora.Close();
                    // * --- End Select
                  } // End If
                  /* _rapporto := '' */
                  _rapporto = "";
                  /* _noprot := 0 */
                  _noprot = CPLib.Round(0,0);
                  // * --- Read from anarapbo
                  m_cServer = m_Ctx.GetServer("anarapbo");
                  m_cPhName = m_Ctx.GetPhName("anarapbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_raporig,"C",25,0,m_cServer),m_cServer,_raporig);
                  if (m_Ctx.IsSharedTemp("anarapbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NOPROT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _rapporto = Read_Cursor.GetString("RAPPORTO");
                    _noprot = CPLib.Round(Read_Cursor.GetDouble("NOPROT"),0);
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_fammigra_stp returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _rapporto = "";
                    _noprot = 0;
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Empty(_rapporto) or (not(Empty(_rapporto)) and _noprot=1) */
                  if (CPLib.Empty(_rapporto) || ( ! (CPLib.Empty(_rapporto)) && CPLib.eqr(_noprot,1))) {
                    /* _rapporto := '' */
                    _rapporto = "";
                    // * --- Read from jnarapbo
                    m_cServer = m_Ctx.GetServer("jnarapbo");
                    m_cPhName = m_Ctx.GetPhName("jnarapbo");
                    m_cSql = "";
                    m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_raporig,"C",25,0,m_cServer),m_cServer,_raporig);
                    if (m_Ctx.IsSharedTemp("jnarapbo")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _rapporto = Read_Cursor.GetString("RAPPORTO");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on jnarapbo into routine arrt_fammigra_stp returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _rapporto = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* _noprot := iif(Empty(_rapporto),0,1) */
                    _noprot = CPLib.Round((CPLib.Empty(_rapporto)?0:1),0);
                  } // End If
                  /* If not(Empty(_rapporto)) */
                  if ( ! (CPLib.Empty(_rapporto))) {
                    /* If _noprot=1 */
                    if (CPLib.eqr(_noprot,1)) {
                      // * --- Select from qbe_famesiti_jntestbo_minmax
                      SPBridge.HMCaller _h00000159;
                      _h00000159 = new SPBridge.HMCaller();
                      _h00000159.Set("m_cVQRList",m_cVQRList);
                      _h00000159.Set("pRAPPORTO",_rapporto);
                      if (Cursor_qbe_famesiti_jntestbo_minmax!=null)
                        Cursor_qbe_famesiti_jntestbo_minmax.Close();
                      Cursor_qbe_famesiti_jntestbo_minmax = new VQRHolder("qbe_famesiti_jntestbo_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000159,true).GetResultSet(m_Ctx);
                      while ( ! (Cursor_qbe_famesiti_jntestbo_minmax.Eof())) {
                        /* If qbe_famesiti_migra_sel->FAMDATINI <> qbe_famesiti_jntestbo_minmax->DATAINI */
                        if (CPLib.ne(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATINI"),Cursor_qbe_famesiti_jntestbo_minmax.GetDate("DATAINI"))) {
                          /* _contaerr := _contaerr + 1 */
                          _contaerr = CPLib.Round(_contaerr+1,0);
                          /* If w_flgwrt='M' */
                          if (CPLib.eqr(w_flgwrt,"M")) {
                            /* mcEsitiErr.AppendBlank() */
                            mcEsitiErr.AppendBlank();
                            /* mcEsitiErr.UNIQUECODE := _famcodice */
                            mcEsitiErr.row.UNIQUECODE = _famcodice;
                            /* mcEsitiErr.RAPPORTO := _rapporto */
                            mcEsitiErr.row.RAPPORTO = _rapporto;
                            /* mcEsitiErr.TIPORAP := 'R' */
                            mcEsitiErr.row.TIPORAP = "R";
                            /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                            mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                            /* mcEsitiErr.DATOMIT := 'Data Inizio MITAGE: '+arfn_fdate(qbe_famesiti_jntestbo_minmax->DATAINI) */
                            mcEsitiErr.row.DATOMIT = "Data Inizio MITAGE: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_jntestbo_minmax.GetDate("DATAINI"));
                            /* mcEsitiErr.DATOAGE := 'Data Inizio AGE: '+arfn_fdate(qbe_famesiti_migra_sel->FAMDATINI) */
                            mcEsitiErr.row.DATOAGE = "Data Inizio AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATINI"));
                            /* mcEsitiErr.ERRMSG := '* Data inizio rapporto non coincide' */
                            mcEsitiErr.row.ERRMSG = "* Data inizio rapporto non coincide";
                          } else { // Else
                            // * --- Insert into tmp_esitierr from values
                            m_Sql.RequireTransaction();
                            m_cServer = m_Ctx.GetServer("tmp_esitierr");
                            m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000165")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                            m_cSql = m_cSql+GetFieldsName_00000165(m_Ctx,m_oWrInfo);
                            m_cSql = m_cSql+") values (";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio MITAGE: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_jntestbo_minmax.GetDate("DATAINI")),"?",0,0,m_cServer, m_oParameters)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATINI")),"?",0,0,m_cServer, m_oParameters)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("* Data inizio rapporto non coincide","?",0,0,m_cServer, m_oParameters)+", ";
                            m_cSql = m_cSql+m_oWrInfo.InsertValues();
                            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                          } // End If
                        } // End If
                        /* If (qbe_famesiti_migra_sel->FAMDATFIN <> qbe_famesiti_jntestbo_minmax->DATAFINE) and qbe_famesiti_jntestbo_minmax->DATAFINE <= CharToDate('20141231') */
                        if ((CPLib.ne(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATFIN"),Cursor_qbe_famesiti_jntestbo_minmax.GetDate("DATAFINE"))) && CPLib.le(Cursor_qbe_famesiti_jntestbo_minmax.GetDate("DATAFINE"),CPLib.CharToDate("20141231"))) {
                          /* _contaerr := _contaerr + 1 */
                          _contaerr = CPLib.Round(_contaerr+1,0);
                          /* If w_flgwrt='M' */
                          if (CPLib.eqr(w_flgwrt,"M")) {
                            /* mcEsitiErr.AppendBlank() */
                            mcEsitiErr.AppendBlank();
                            /* mcEsitiErr.UNIQUECODE := _famcodice */
                            mcEsitiErr.row.UNIQUECODE = _famcodice;
                            /* mcEsitiErr.RAPPORTO := _rapporto */
                            mcEsitiErr.row.RAPPORTO = _rapporto;
                            /* mcEsitiErr.TIPORAP := 'R' */
                            mcEsitiErr.row.TIPORAP = "R";
                            /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                            mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                            /* mcEsitiErr.DATOMIT := 'Data Fine MITAGE: '+arfn_fdate(qbe_famesiti_jntestbo_minmax->DATAFINE) */
                            mcEsitiErr.row.DATOMIT = "Data Fine MITAGE: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_jntestbo_minmax.GetDate("DATAFINE"));
                            /* mcEsitiErr.DATOAGE := 'Data Fine AGE: '+arfn_fdate(qbe_famesiti_migra_sel->FAMDATFIN) */
                            mcEsitiErr.row.DATOAGE = "Data Fine AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATFIN"));
                            /* mcEsitiErr.ERRMSG := '* Data Fine rapporto non coincide' */
                            mcEsitiErr.row.ERRMSG = "* Data Fine rapporto non coincide";
                          } else { // Else
                            // * --- Insert into tmp_esitierr from values
                            m_Sql.RequireTransaction();
                            m_cServer = m_Ctx.GetServer("tmp_esitierr");
                            m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000171")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                            m_cSql = m_cSql+GetFieldsName_00000171(m_Ctx,m_oWrInfo);
                            m_cSql = m_cSql+") values (";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine MITAGE: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_jntestbo_minmax.GetDate("DATAFINE")),"?",0,0,m_cServer, m_oParameters)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATINI")),"?",0,0,m_cServer, m_oParameters)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("* Data Fine rapporto non coincide","?",0,0,m_cServer, m_oParameters)+", ";
                            m_cSql = m_cSql+m_oWrInfo.InsertValues();
                            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                          } // End If
                        } // End If
                        Cursor_qbe_famesiti_jntestbo_minmax.Next();
                      }
                      m_cConnectivityError = Cursor_qbe_famesiti_jntestbo_minmax.ErrorMessage();
                      Cursor_qbe_famesiti_jntestbo_minmax.Close();
                      // * --- End Select
                    } else { // Else
                      // * --- Select from qbe_famesiti_intestbo_minmax
                      SPBridge.HMCaller _h00000172;
                      _h00000172 = new SPBridge.HMCaller();
                      _h00000172.Set("m_cVQRList",m_cVQRList);
                      _h00000172.Set("pRAPPORTO",_rapporto);
                      if (Cursor_qbe_famesiti_intestbo_minmax!=null)
                        Cursor_qbe_famesiti_intestbo_minmax.Close();
                      Cursor_qbe_famesiti_intestbo_minmax = new VQRHolder("qbe_famesiti_intestbo_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000172,true).GetResultSet(m_Ctx);
                      while ( ! (Cursor_qbe_famesiti_intestbo_minmax.Eof())) {
                        /* If qbe_famesiti_migra_sel->FAMDATINI <> qbe_famesiti_intestbo_minmax->DATAINI */
                        if (CPLib.ne(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATINI"),Cursor_qbe_famesiti_intestbo_minmax.GetDate("DATAINI"))) {
                          /* _contaerr := _contaerr + 1 */
                          _contaerr = CPLib.Round(_contaerr+1,0);
                          /* If w_flgwrt='M' */
                          if (CPLib.eqr(w_flgwrt,"M")) {
                            /* mcEsitiErr.AppendBlank() */
                            mcEsitiErr.AppendBlank();
                            /* mcEsitiErr.UNIQUECODE := _famcodice */
                            mcEsitiErr.row.UNIQUECODE = _famcodice;
                            /* mcEsitiErr.RAPPORTO := _rapporto */
                            mcEsitiErr.row.RAPPORTO = _rapporto;
                            /* mcEsitiErr.TIPORAP := 'R' */
                            mcEsitiErr.row.TIPORAP = "R";
                            /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                            mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                            /* mcEsitiErr.DATOMIT := 'Data Inizio MITAUI: '+arfn_fdate(qbe_famesiti_intestbo_minmax->DATAINI) */
                            mcEsitiErr.row.DATOMIT = "Data Inizio MITAUI: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_intestbo_minmax.GetDate("DATAINI"));
                            /* mcEsitiErr.DATOAGE := 'Data Inizio AGE: '+arfn_fdate(qbe_famesiti_migra_sel->FAMDATINI) */
                            mcEsitiErr.row.DATOAGE = "Data Inizio AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATINI"));
                            /* mcEsitiErr.ERRMSG := '* Data inizio rapporto non coincide' */
                            mcEsitiErr.row.ERRMSG = "* Data inizio rapporto non coincide";
                          } else { // Else
                            // * --- Insert into tmp_esitierr from values
                            m_Sql.RequireTransaction();
                            m_cServer = m_Ctx.GetServer("tmp_esitierr");
                            m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"0000017E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                            m_cSql = m_cSql+GetFieldsName_0000017E(m_Ctx,m_oWrInfo);
                            m_cSql = m_cSql+") values (";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio MITAUI: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_intestbo_minmax.GetDate("DATAINI")),"?",0,0,m_cServer, m_oParameters)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATINI")),"?",0,0,m_cServer, m_oParameters)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("* Data inizio rapporto non coincide","?",0,0,m_cServer, m_oParameters)+", ";
                            m_cSql = m_cSql+m_oWrInfo.InsertValues();
                            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                          } // End If
                        } // End If
                        /* If (qbe_famesiti_migra_sel->FAMDATFIN <> qbe_famesiti_intestbo_minmax->DATAFINE) and qbe_famesiti_intestbo_minmax->DATAFINE <= CharToDate('20141231') */
                        if ((CPLib.ne(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATFIN"),Cursor_qbe_famesiti_intestbo_minmax.GetDate("DATAFINE"))) && CPLib.le(Cursor_qbe_famesiti_intestbo_minmax.GetDate("DATAFINE"),CPLib.CharToDate("20141231"))) {
                          /* _contaerr := _contaerr + 1 */
                          _contaerr = CPLib.Round(_contaerr+1,0);
                          /* If w_flgwrt='M' */
                          if (CPLib.eqr(w_flgwrt,"M")) {
                            /* mcEsitiErr.AppendBlank() */
                            mcEsitiErr.AppendBlank();
                            /* mcEsitiErr.UNIQUECODE := _famcodice */
                            mcEsitiErr.row.UNIQUECODE = _famcodice;
                            /* mcEsitiErr.RAPPORTO := _rapporto */
                            mcEsitiErr.row.RAPPORTO = _rapporto;
                            /* mcEsitiErr.TIPORAP := 'R' */
                            mcEsitiErr.row.TIPORAP = "R";
                            /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                            mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                            /* mcEsitiErr.DATOMIT := 'Data Fine MITAUI: '+arfn_fdate(qbe_famesiti_intestbo_minmax->DATAFINE) */
                            mcEsitiErr.row.DATOMIT = "Data Fine MITAUI: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_intestbo_minmax.GetDate("DATAFINE"));
                            /* mcEsitiErr.DATOAGE := 'Data Fine AGE: '+arfn_fdate(qbe_famesiti_migra_sel->FAMDATFIN) */
                            mcEsitiErr.row.DATOAGE = "Data Fine AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATFIN"));
                            /* mcEsitiErr.ERRMSG := '* Data Fine rapporto non coincide' */
                            mcEsitiErr.row.ERRMSG = "* Data Fine rapporto non coincide";
                          } else { // Else
                            // * --- Insert into tmp_esitierr from values
                            m_Sql.RequireTransaction();
                            m_cServer = m_Ctx.GetServer("tmp_esitierr");
                            m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"0000018A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                            m_cSql = m_cSql+GetFieldsName_0000018A(m_Ctx,m_oWrInfo);
                            m_cSql = m_cSql+") values (";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine MITAUI: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_intestbo_minmax.GetDate("DATAFINE")),"?",0,0,m_cServer, m_oParameters)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_migra_sel.GetDate("FAMDATFIN")),"?",0,0,m_cServer, m_oParameters)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("* Data Fine rapporto non coincide","?",0,0,m_cServer, m_oParameters)+", ";
                            m_cSql = m_cSql+m_oWrInfo.InsertValues();
                            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                          } // End If
                        } // End If
                        Cursor_qbe_famesiti_intestbo_minmax.Next();
                      }
                      m_cConnectivityError = Cursor_qbe_famesiti_intestbo_minmax.ErrorMessage();
                      Cursor_qbe_famesiti_intestbo_minmax.Close();
                      // * --- End Select
                    } // End If
                    /* _errore := '' */
                    _errore = "";
                    /* mcFamCom.Zap() */
                    mcFamCom.Zap();
                    /* mcFamCom := arfn_ae_famiglia(_rapporto,'X') */
                    mcFamCom = arfn_ae_famigliaR.Make(m_Ctx,this).Run(_rapporto,"X");
                    /* mcFamesitid.Zap() */
                    mcFamesitid.Zap();
                    // * --- Fill memory cursor mcFamesitid on famesitid
                    mcFamesitid.Zap();
                    m_cServer = m_Ctx.GetServer("famesitid");
                    m_cPhName = m_Ctx.GetPhName("famesitid");
                    if (Cursor_famesitid!=null)
                      Cursor_famesitid.Close();
                    Cursor_famesitid = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"FADRAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_famcodice,"?",0,0,m_cServer, m_oParameters),m_cServer,_famcodice)+" "+")"+(m_Ctx.IsSharedTemp("famesitid")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    {
                      final CPResultSet m_TheCursor = Cursor_famesitid;
                      Cursor_famesitid.ActionOnClose(new Runnable() {
                        public void run() {
                          if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                            com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                            if ( ! (CPLib.IsNull(info))) {
                              info.log("Routine arrt_fammigra_stp: query on famesitid returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                            }
                          }
                        }
                        });
                    }
                    while ( ! (Cursor_famesitid.Eof())) {
                      mcFamesitid.AppendBlank();
                      mcFamesitid.row.FADRAPPORTO = Cursor_famesitid.GetString("FADRAPPORTO");
                      mcFamesitid.row.FADPROGR = Cursor_famesitid.GetDouble("FADPROGR");
                      mcFamesitid.row.FADCODFIS = Cursor_famesitid.GetString("FADCODFIS");
                      mcFamesitid.row.FADRUOLO = Cursor_famesitid.GetDouble("FADRUOLO");
                      mcFamesitid.row.FADDATINI = Cursor_famesitid.GetDate("FADDATINI");
                      mcFamesitid.row.FADDATFIN = Cursor_famesitid.GetDate("FADDATFIN");
                      mcFamesitid.row.FADTERNA1 = Cursor_famesitid.GetString("FADTERNA1");
                      mcFamesitid.row.FADTERNA2 = Cursor_famesitid.GetDouble("FADTERNA2");
                      mcFamesitid.row.FADTERNA3 = Cursor_famesitid.GetString("FADTERNA3");
                      mcFamesitid.row.FADCOGRAG = Cursor_famesitid.GetString("FADCOGRAG");
                      mcFamesitid.row.FADNOME = Cursor_famesitid.GetString("FADNOME");
                      mcFamesitid.row.FADSESSO = Cursor_famesitid.GetString("FADSESSO");
                      mcFamesitid.row.FADDATNAS = Cursor_famesitid.GetDate("FADDATNAS");
                      mcFamesitid.row.FADNASSEL = Cursor_famesitid.GetString("FADNASSEL");
                      mcFamesitid.row.FADPRVSEL = Cursor_famesitid.GetString("FADPRVSEL");
                      Cursor_famesitid.Next();
                    }
                    m_cConnectivityError = Cursor_famesitid.ErrorMessage();
                    Cursor_famesitid.Close();
                    mcFamesitid.GoTop();
                    /* _intaui := 0 */
                    _intaui = CPLib.Round(0,0);
                    /* _delaui := 0 */
                    _delaui = CPLib.Round(0,0);
                    /* _titaui := 0 */
                    _titaui = CPLib.Round(0,0);
                    /* _garaui := 0 */
                    _garaui = CPLib.Round(0,0);
                    /* _intage := 0 */
                    _intage = CPLib.Round(0,0);
                    /* _delage := 0 */
                    _delage = CPLib.Round(0,0);
                    /* _titage := 0 */
                    _titage = CPLib.Round(0,0);
                    /* _garage := 0 */
                    _garage = CPLib.Round(0,0);
                    MemoryCursor_famesitid cpmc_00000199;
                    cpmc_00000199 = new MemoryCursor_famesitid();
                    for (MemoryCursorRow_famesitid rowEsitid : mcFamesitid._iterable_()) {
                      cpmc_00000199.Append(rowEsitid);
                    }
                    for (MemoryCursorRow_famesitid rowEsitid : cpmc_00000199._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_famesitid>(){  public int compare(MemoryCursorRow_famesitid r1,MemoryCursorRow_famesitid r2){    if (CPLib.gt(r1.FADPROGR,r2.FADPROGR)) return 1;    if (CPLib.lt(r1.FADPROGR,r2.FADPROGR)) return -1;    return 0;  }})) {
                      /* _intage := _intage + iif(rowEsitid.FADRUOLO=0 or rowEsitid.FADRUOLO=4,1,0) */
                      _intage = CPLib.Round(_intage+(CPLib.eqr(rowEsitid.FADRUOLO,0) || CPLib.eqr(rowEsitid.FADRUOLO,4)?1:0),0);
                      /* If rowEsitid.FADRUOLO=0 or rowEsitid.FADRUOLO=4 */
                      if (CPLib.eqr(rowEsitid.FADRUOLO,0) || CPLib.eqr(rowEsitid.FADRUOLO,4)) {
                        /* _tipoint := rowEsitid.FADRUOLO */
                        _tipoint = CPLib.Round(rowEsitid.FADRUOLO,0);
                      } // End If
                      /* _delage := _delage + iif(rowEsitid.FADRUOLO=5,1,0) */
                      _delage = CPLib.Round(_delage+(CPLib.eqr(rowEsitid.FADRUOLO,5)?1:0),0);
                      /* _titage := _titage + iif(rowEsitid.FADRUOLO=7,1,0) */
                      _titage = CPLib.Round(_titage+(CPLib.eqr(rowEsitid.FADRUOLO,7)?1:0),0);
                      /* _garage := _garage + iif(rowEsitid.FADRUOLO=8,1,0) */
                      _garage = CPLib.Round(_garage+(CPLib.eqr(rowEsitid.FADRUOLO,8)?1:0),0);
                    }
                    for (MemoryCursorRow_mcfamiglia_mcrdef rowFamiglia : mcFamCom._iterable_()) {
                      /* If rowFamiglia.DATAINI <= _maxope */
                      if (CPLib.le(rowFamiglia.DATAINI,_maxope)) {
                        /* _intaui := _intaui + iif(Left(rowFamiglia.TIPOSOG,1)='0' or Left(rowFamiglia.TIPOSOG,1)='4',1,0) */
                        _intaui = CPLib.Round(_intaui+(CPLib.eqr(CPLib.Left(rowFamiglia.TIPOSOG,1),"0") || CPLib.eqr(CPLib.Left(rowFamiglia.TIPOSOG,1),"4")?1:0),0);
                        /* _delaui := _delaui + iif(Left(rowFamiglia.TIPOSOG,1)='5',1,0) */
                        _delaui = CPLib.Round(_delaui+(CPLib.eqr(CPLib.Left(rowFamiglia.TIPOSOG,1),"5")?1:0),0);
                        /* If _tipoint=0 */
                        if (CPLib.eqr(_tipoint,0)) {
                          /* _titaui := _titaui + iif(Left(rowFamiglia.TIPOSOG,1)='7',1,0) */
                          _titaui = CPLib.Round(_titaui+(CPLib.eqr(CPLib.Left(rowFamiglia.TIPOSOG,1),"7")?1:0),0);
                        } // End If
                        /* _garaui := _garaui + iif(Left(rowFamiglia.TIPOSOG,1)='8',1,0) */
                        _garaui = CPLib.Round(_garaui+(CPLib.eqr(CPLib.Left(rowFamiglia.TIPOSOG,1),"8")?1:0),0);
                      } // End If
                    }
                    /* If _intaui = _intage and _delaui=_delage and _titaui=_titage and _garaui=_garage */
                    if (CPLib.eqr(_intaui,_intage) && CPLib.eqr(_delaui,_delage) && CPLib.eqr(_titaui,_titage) && CPLib.eqr(_garaui,_garage)) {
                      /* mcFam0.Zap() */
                      mcFam0.Zap();
                      /* mcFam5.Zap() */
                      mcFam5.Zap();
                      /* mcFam7.Zap() */
                      mcFam7.Zap();
                      /* mcFam8.Zap() */
                      mcFam8.Zap();
                      for (MemoryCursorRow_mcfamiglia_mcrdef rowFam : mcFamCom._iterable_()) {
                        /* If rowFam.DATAINI <= _maxope */
                        if (CPLib.le(rowFam.DATAINI,_maxope)) {
                          /* If Left(rowFam.TIPOSOG,1)='0' or Left(rowFam.TIPOSOG,1)='4' */
                          if (CPLib.eqr(CPLib.Left(rowFam.TIPOSOG,1),"0") || CPLib.eqr(CPLib.Left(rowFam.TIPOSOG,1),"4")) {
                            /* mcFam0.AppendRow(rowFam) */
                            mcFam0.AppendRow(rowFam);
                          } // End If
                          /* If Left(rowFam.TIPOSOG,1)='5' */
                          if (CPLib.eqr(CPLib.Left(rowFam.TIPOSOG,1),"5")) {
                            /* mcFam5.AppendRow(rowFam) */
                            mcFam5.AppendRow(rowFam);
                          } // End If
                          /* If Left(rowFam.TIPOSOG,1)='7' */
                          if (CPLib.eqr(CPLib.Left(rowFam.TIPOSOG,1),"7")) {
                            /* mcFam7.AppendRow(rowFam) */
                            mcFam7.AppendRow(rowFam);
                          } // End If
                          /* If Left(rowFam.TIPOSOG,1)='8' */
                          if (CPLib.eqr(CPLib.Left(rowFam.TIPOSOG,1),"8")) {
                            /* mcFam8.AppendRow(rowFam) */
                            mcFam8.AppendRow(rowFam);
                          } // End If
                        } // End If
                      }
                      MemoryCursor_famesitid cpmc_000001B7;
                      cpmc_000001B7 = new MemoryCursor_famesitid();
                      for (MemoryCursorRow_famesitid rowEsitid : mcFamesitid._iterable_()) {
                        cpmc_000001B7.Append(rowEsitid);
                      }
                      for (MemoryCursorRow_famesitid rowEsitid : cpmc_000001B7._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_famesitid>(){  public int compare(MemoryCursorRow_famesitid r1,MemoryCursorRow_famesitid r2){    if (CPLib.gt(r1.FADPROGR,r2.FADPROGR)) return 1;    if (CPLib.lt(r1.FADPROGR,r2.FADPROGR)) return -1;    return 0;  }})) {
                        /* rowFamesitid.Copy(rowEsitid) */
                        rowFamesitid.Copy(rowEsitid);
                        /* _findsog := 0 */
                        _findsog = CPLib.Round(0,0);
                        /* If rowEsitid.FADRUOLO= 0 or rowEsitid.FADRUOLO=4 */
                        if (CPLib.eqr(rowEsitid.FADRUOLO,0) || CPLib.eqr(rowEsitid.FADRUOLO,4)) {
                          /* _check := '|0|4' */
                          _check = "|0|4";
                          /* Exec "Controllo Intestatari" Page 2:Pag_2 */
                          Pag_2();
                          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                            throw new RoutineException();
                          }
                        } // End If
                        /* If rowEsitid.FADRUOLO= 5 */
                        if (CPLib.eqr(rowEsitid.FADRUOLO,5)) {
                          /* _check := '5' */
                          _check = "5";
                          /* Exec "Controllo Delegati" Page 3:Pag_3 */
                          Pag_3();
                          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                            throw new RoutineException();
                          }
                        } // End If
                        /* If rowEsitid.FADRUOLO= 7 */
                        if (CPLib.eqr(rowEsitid.FADRUOLO,7)) {
                          /* _check := '7' */
                          _check = "7";
                          /* Exec "Controllo Titolari" Page 4:Pag_4 */
                          Pag_4();
                          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                            throw new RoutineException();
                          }
                        } // End If
                        /* If rowEsitid.FADRUOLO= 8 */
                        if (CPLib.eqr(rowEsitid.FADRUOLO,8)) {
                          /* _check := '8' */
                          _check = "8";
                          /* Exec "Controllo Garantiti" Page 5:Pag_5 */
                          Pag_5();
                          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                            throw new RoutineException();
                          }
                        } // End If
                      }
                    } else { // Else
                      /* If _intaui <> _intage */
                      if (CPLib.ne(_intaui,_intage)) {
                        /* _contaerr := _contaerr + 1 */
                        _contaerr = CPLib.Round(_contaerr+1,0);
                        /* If w_flgwrt='M' */
                        if (CPLib.eqr(w_flgwrt,"M")) {
                          /* mcEsitiErr.AppendBlank() */
                          mcEsitiErr.AppendBlank();
                          /* mcEsitiErr.UNIQUECODE := _famcodice */
                          mcEsitiErr.row.UNIQUECODE = _famcodice;
                          /* mcEsitiErr.RAPPORTO := _rapporto */
                          mcEsitiErr.row.RAPPORTO = _rapporto;
                          /* mcEsitiErr.TIPORAP := 'R' */
                          mcEsitiErr.row.TIPORAP = "R";
                          /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                          mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                          /* mcEsitiErr.DATOMIT := 'Intestatari AUI: '+LRTrim(Str(_intaui,3,0)) */
                          mcEsitiErr.row.DATOMIT = "Intestatari AUI: "+CPLib.LRTrim(CPLib.Str(_intaui,3,0));
                          /* mcEsitiErr.DATOAGE := 'Intestatari AGE: '+LRTrim(Str(_intage,3,0)) */
                          mcEsitiErr.row.DATOAGE = "Intestatari AGE: "+CPLib.LRTrim(CPLib.Str(_intage,3,0));
                          /* mcEsitiErr.ERRMSG := '* Numero Intestatari differisce tra AUI e AGE' */
                          mcEsitiErr.row.ERRMSG = "* Numero Intestatari differisce tra AUI e AGE";
                        } else { // Else
                          // * --- Insert into tmp_esitierr from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("tmp_esitierr");
                          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000001D2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                          m_cSql = m_cSql+GetFieldsName_000001D2(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("* Numero Intestatari differisce tra AUI e AGE","?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("Intestatari AUI: "+CPLib.LRTrim(CPLib.Str(_intaui,3,0)),"?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("Intestatari AGE: "+CPLib.LRTrim(CPLib.Str(_intage,3,0)),"?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                        } // End If
                      } // End If
                      /* If _delaui <> _delage */
                      if (CPLib.ne(_delaui,_delage)) {
                        /* _contaerr := _contaerr + 1 */
                        _contaerr = CPLib.Round(_contaerr+1,0);
                        /* If w_flgwrt='M' */
                        if (CPLib.eqr(w_flgwrt,"M")) {
                          /* mcEsitiErr.AppendBlank() */
                          mcEsitiErr.AppendBlank();
                          /* mcEsitiErr.UNIQUECODE := _famcodice */
                          mcEsitiErr.row.UNIQUECODE = _famcodice;
                          /* mcEsitiErr.RAPPORTO := _rapporto */
                          mcEsitiErr.row.RAPPORTO = _rapporto;
                          /* mcEsitiErr.TIPORAP := 'R' */
                          mcEsitiErr.row.TIPORAP = "R";
                          /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                          mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                          /* mcEsitiErr.DATOMIT := 'Delegati AUI: '+LRTrim(Str(_delaui,3,0)) */
                          mcEsitiErr.row.DATOMIT = "Delegati AUI: "+CPLib.LRTrim(CPLib.Str(_delaui,3,0));
                          /* mcEsitiErr.DATOAGE := 'Delegati AGE: '+LRTrim(Str(_delage,3,0)) */
                          mcEsitiErr.row.DATOAGE = "Delegati AGE: "+CPLib.LRTrim(CPLib.Str(_delage,3,0));
                          /* mcEsitiErr.ERRMSG := '* Numero Delegati differisce tra AUI e AGE' */
                          mcEsitiErr.row.ERRMSG = "* Numero Delegati differisce tra AUI e AGE";
                        } else { // Else
                          // * --- Insert into tmp_esitierr from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("tmp_esitierr");
                          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000001DE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                          m_cSql = m_cSql+GetFieldsName_000001DE(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("* Numero Delegati differisce tra AUI e AGE","?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("Delegati AUI: "+CPLib.LRTrim(CPLib.Str(_delaui,3,0)),"?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("Delegati AGE: "+CPLib.LRTrim(CPLib.Str(_delage,3,0)),"?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                        } // End If
                      } // End If
                      /* If _titaui <> _titage */
                      if (CPLib.ne(_titaui,_titage)) {
                        /* _contaerr := _contaerr + 1 */
                        _contaerr = CPLib.Round(_contaerr+1,0);
                        /* If w_flgwrt='M' */
                        if (CPLib.eqr(w_flgwrt,"M")) {
                          /* mcEsitiErr.AppendBlank() */
                          mcEsitiErr.AppendBlank();
                          /* mcEsitiErr.UNIQUECODE := _famcodice */
                          mcEsitiErr.row.UNIQUECODE = _famcodice;
                          /* mcEsitiErr.RAPPORTO := _rapporto */
                          mcEsitiErr.row.RAPPORTO = _rapporto;
                          /* mcEsitiErr.TIPORAP := 'R' */
                          mcEsitiErr.row.TIPORAP = "R";
                          /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                          mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                          /* mcEsitiErr.DATOMIT := 'Titolari AUI: '+LRTrim(Str(_titaui,3,0)) */
                          mcEsitiErr.row.DATOMIT = "Titolari AUI: "+CPLib.LRTrim(CPLib.Str(_titaui,3,0));
                          /* mcEsitiErr.DATOAGE := 'Titolari AGE: '+LRTrim(Str(_titage,3,0)) */
                          mcEsitiErr.row.DATOAGE = "Titolari AGE: "+CPLib.LRTrim(CPLib.Str(_titage,3,0));
                          /* mcEsitiErr.ERRMSG := '* Numero Titolari differisce tra AUI e AGE' */
                          mcEsitiErr.row.ERRMSG = "* Numero Titolari differisce tra AUI e AGE";
                        } else { // Else
                          // * --- Insert into tmp_esitierr from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("tmp_esitierr");
                          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000001EA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                          m_cSql = m_cSql+GetFieldsName_000001EA(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("* Numero Titolari differisce tra AUI e AGE","?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("Titolari AUI: "+CPLib.LRTrim(CPLib.Str(_titaui,3,0)),"?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("Titolari AGE: "+CPLib.LRTrim(CPLib.Str(_titage,3,0)),"?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                        } // End If
                      } // End If
                      /* If _garaui <> _garage */
                      if (CPLib.ne(_garaui,_garage)) {
                        /* _contaerr := _contaerr + 1 */
                        _contaerr = CPLib.Round(_contaerr+1,0);
                        /* If w_flgwrt='M' */
                        if (CPLib.eqr(w_flgwrt,"M")) {
                          /* mcEsitiErr.AppendBlank() */
                          mcEsitiErr.AppendBlank();
                          /* mcEsitiErr.UNIQUECODE := _famcodice */
                          mcEsitiErr.row.UNIQUECODE = _famcodice;
                          /* mcEsitiErr.RAPPORTO := _rapporto */
                          mcEsitiErr.row.RAPPORTO = _rapporto;
                          /* mcEsitiErr.TIPORAP := 'R' */
                          mcEsitiErr.row.TIPORAP = "R";
                          /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                          mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                          /* mcEsitiErr.DATOMIT := 'Garantiti AUI: '+LRTrim(Str(_garaui,3,0)) */
                          mcEsitiErr.row.DATOMIT = "Garantiti AUI: "+CPLib.LRTrim(CPLib.Str(_garaui,3,0));
                          /* mcEsitiErr.DATOAGE := 'Garantiti AGE: '+LRTrim(Str(_garage,3,0)) */
                          mcEsitiErr.row.DATOAGE = "Garantiti AGE: "+CPLib.LRTrim(CPLib.Str(_garage,3,0));
                          /* mcEsitiErr.ERRMSG := '* Numero Garantiti differisce tra AUI e AGE' */
                          mcEsitiErr.row.ERRMSG = "* Numero Garantiti differisce tra AUI e AGE";
                        } else { // Else
                          // * --- Insert into tmp_esitierr from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("tmp_esitierr");
                          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000001F6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                          m_cSql = m_cSql+GetFieldsName_000001F6(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("* Numero Garantiti differisce tra AUI e AGE","?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("Garantiti AUI: "+CPLib.LRTrim(CPLib.Str(_garaui,3,0)),"?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("Garantiti AGE: "+CPLib.LRTrim(CPLib.Str(_garage,3,0)),"?",0,0,m_cServer, m_oParameters)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                        } // End If
                      } // End If
                    } // End If
                  } else { // Else
                    /* _contaerr := _contaerr + 1 */
                    _contaerr = CPLib.Round(_contaerr+1,0);
                    /* If w_flgwrt='M' */
                    if (CPLib.eqr(w_flgwrt,"M")) {
                      /* mcEsitiErr.AppendBlank() */
                      mcEsitiErr.AppendBlank();
                      /* mcEsitiErr.UNIQUECODE := _famcodice */
                      mcEsitiErr.row.UNIQUECODE = _famcodice;
                      /* mcEsitiErr.RAPPORTO := _rapporto */
                      mcEsitiErr.row.RAPPORTO = _rapporto;
                      /* mcEsitiErr.TIPORAP := 'R' */
                      mcEsitiErr.row.TIPORAP = "R";
                      /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                      mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                      /* mcEsitiErr.ERRMSG := '* Famiglia presente in WEBANTI ma non presenti dati (AUI o AGE)' */
                      mcEsitiErr.row.ERRMSG = "* Famiglia presente in WEBANTI ma non presenti dati (AUI o AGE)";
                    } else { // Else
                      // * --- Insert into tmp_esitierr from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_esitierr");
                      m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000001FF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000001FF(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("* Famiglia presente in WEBANTI ma non presenti dati (AUI o AGE)","?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                    } // End If
                  } // End If
                  Cursor_aetesta.Next();
                }
                m_cConnectivityError = Cursor_aetesta.ErrorMessage();
                Cursor_aetesta.Close();
                // * --- End Select
                /* If _trovato=0 */
                if (CPLib.eqr(_trovato,0)) {
                  /* _contaerr := _contaerr + 1 */
                  _contaerr = CPLib.Round(_contaerr+1,0);
                  /* If w_flgwrt='M' */
                  if (CPLib.eqr(w_flgwrt,"M")) {
                    /* mcEsitiErr.AppendBlank() */
                    mcEsitiErr.AppendBlank();
                    /* mcEsitiErr.UNIQUECODE := _famcodice */
                    mcEsitiErr.row.UNIQUECODE = _famcodice;
                    /* mcEsitiErr.TIPORAP := 'R' */
                    mcEsitiErr.row.TIPORAP = "R";
                    /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                    mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                    /* mcEsitiErr.ERRMSG := '* - Famiglia presente in AGE ma non in WEBANTI' */
                    mcEsitiErr.row.ERRMSG = "* - Famiglia presente in AGE ma non in WEBANTI";
                  } else { // Else
                    // * --- Insert into tmp_esitierr from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_esitierr");
                    m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000208")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000208(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("* - Famiglia presente in AGE ma non in WEBANTI","?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                  } // End If
                } // End If
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
        /* If w_flgnoe='N' */
        if (CPLib.eqr(w_flgnoe,"N")) {
          // * --- Select from qbe_famesiti_noopex
          SPBridge.HMCaller _h0000020B;
          _h0000020B = new SPBridge.HMCaller();
          _h0000020B.Set("m_cVQRList",m_cVQRList);
          _h0000020B.Set("dadata",w_dadata);
          _h0000020B.Set("a_data",w_a_data);
          _h0000020B.Set("_datinv",_datamax);
          if (Cursor_qbe_famesiti_noopex!=null)
            Cursor_qbe_famesiti_noopex.Close();
          Cursor_qbe_famesiti_noopex = new VQRHolder("qbe_famesiti_noopex",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000020B,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_famesiti_noopex.Eof())) {
            /* gMsgImp := 'Extraconto non presente in AGE. Codice: '+ qbe_famesiti_noopex->RAPPORTO // Messaggio Import */
            gMsgImp = "Extraconto non presente in AGE. Codice: "+Cursor_qbe_famesiti_noopex.GetString("RAPPORTO");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _contaerr := _contaerr + 1 */
            _contaerr = CPLib.Round(_contaerr+1,0);
            /* _ndgsog := qbe_famesiti_noopex->COLLEG */
            _ndgsog = Cursor_qbe_famesiti_noopex.GetString("COLLEG");
            /* _codfisc := '' */
            _codfisc = "";
            /* _nome := '' */
            _nome = "";
            /* _cognome := '' */
            _cognome = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ndgsog,"C",16,0,m_cServer),m_cServer,_ndgsog);
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NOME",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COGNOME",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _codfisc = Read_Cursor.GetString("CODFISC");
              _nome = Read_Cursor.GetString("NOME");
              _cognome = Read_Cursor.GetString("COGNOME");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_fammigra_stp returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _codfisc = "";
              _nome = "";
              _cognome = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If w_flgwrt='M' */
            if (CPLib.eqr(w_flgwrt,"M")) {
              /* mcEsitiErr.AppendBlank() */
              mcEsitiErr.AppendBlank();
              /* mcEsitiErr.UNIQUECODE := qbe_famesiti_noopex->UNIQUER */
              mcEsitiErr.row.UNIQUECODE = Cursor_qbe_famesiti_noopex.GetString("UNIQUER");
              /* mcEsitiErr.RAPPORTO := qbe_famesiti_noopex->RAPPORTO */
              mcEsitiErr.row.RAPPORTO = Cursor_qbe_famesiti_noopex.GetString("RAPPORTO");
              /* mcEsitiErr.TIPORAP := 'O' */
              mcEsitiErr.row.TIPORAP = "O";
              /* mcEsitiErr.NDGSOG := qbe_famesiti_noopex->COLLEG */
              mcEsitiErr.row.NDGSOG = Cursor_qbe_famesiti_noopex.GetString("COLLEG");
              /* If qbe_famesiti_noopex->INVIATO=1 */
              if (CPLib.eqr(Cursor_qbe_famesiti_noopex.GetDouble("INVIATO"),1)) {
                /* mcEsitiErr.ERRMSG := '* - Extraconto presente in WEBANTI ma non in AGE' */
                mcEsitiErr.row.ERRMSG = "* - Extraconto presente in WEBANTI ma non in AGE";
              } else { // Else
                /* mcEsitiErr.ERRMSG := '* - Extraconto presente in WEBANTI ma non inviato' */
                mcEsitiErr.row.ERRMSG = "* - Extraconto presente in WEBANTI ma non inviato";
              } // End If
              /* mcEsitiErr.COGNOME := _cognome */
              mcEsitiErr.row.COGNOME = _cognome;
              /* mcEsitiErr.NOME := _nome */
              mcEsitiErr.row.NOME = _nome;
              /* mcEsitiErr.CODFISC := _codfisc */
              mcEsitiErr.row.CODFISC = _codfisc;
            } else { // Else
              // * --- Insert into tmp_esitierr from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_esitierr");
              m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"0000021F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000021F(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_famesiti_noopex.GetString("UNIQUER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_famesiti_noopex.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_famesiti_noopex.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_famesiti_noopex.GetDouble("INVIATO"),1)?"* - Extraconto presente in WEBANTI ma non in AGE":"* - Extraconto presente in WEBANTI ma non inviato"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cognome,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nome,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codfisc,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Data Operazione: "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_famesiti_noopex.GetDate("DATAOPE")),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
            } // End If
            Cursor_qbe_famesiti_noopex.Next();
          }
          m_cConnectivityError = Cursor_qbe_famesiti_noopex.ErrorMessage();
          Cursor_qbe_famesiti_noopex.Close();
          // * --- End Select
          // * --- Select from qbe_famesiti_norapp
          SPBridge.HMCaller _h00000220;
          _h00000220 = new SPBridge.HMCaller();
          _h00000220.Set("m_cVQRList",m_cVQRList);
          _h00000220.Set("_datinv",_datamax);
          if (Cursor_qbe_famesiti_norapp!=null)
            Cursor_qbe_famesiti_norapp.Close();
          Cursor_qbe_famesiti_norapp = new VQRHolder("qbe_famesiti_norapp",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000220,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_famesiti_norapp.Eof())) {
            /* gMsgImp := 'Esamino Famiglia Codice: '+ qbe_famesiti_norapp->RAPPORTO // Messaggio Import */
            gMsgImp = "Esamino Famiglia Codice: "+Cursor_qbe_famesiti_norapp.GetString("RAPPORTO");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _findsog := 1 */
            _findsog = CPLib.Round(1,0);
            /* _rapporto := '' */
            _rapporto = "";
            /* _noprot := 0 */
            _noprot = CPLib.Round(0,0);
            // * --- Read from anarapbo
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_famesiti_norapp.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_famesiti_norapp.GetString("RAPPORTO"));
            if (m_Ctx.IsSharedTemp("anarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NOPROT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _noprot = CPLib.Round(Read_Cursor.GetDouble("NOPROT"),0);
              _rapporto = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_fammigra_stp returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _noprot = 0;
              _rapporto = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(_rapporto) or (not(Empty(_rapporto)) and _noprot=1) */
            if (CPLib.Empty(_rapporto) || ( ! (CPLib.Empty(_rapporto)) && CPLib.eqr(_noprot,1))) {
              // * --- Select from qbe_famesiti_jntestbo_minmax
              SPBridge.HMCaller _h00000227;
              _h00000227 = new SPBridge.HMCaller();
              _h00000227.Set("m_cVQRList",m_cVQRList);
              _h00000227.Set("pRAPPORTO",Cursor_qbe_famesiti_norapp.GetString("RAPPORTO"));
              if (Cursor_qbe_famesiti_jntestbo_minmax!=null)
                Cursor_qbe_famesiti_jntestbo_minmax.Close();
              Cursor_qbe_famesiti_jntestbo_minmax = new VQRHolder("qbe_famesiti_jntestbo_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000227,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_famesiti_jntestbo_minmax.Eof())) {
                /* If qbe_famesiti_jntestbo_minmax->DATAINI >= _maxope */
                if (CPLib.ge(Cursor_qbe_famesiti_jntestbo_minmax.GetDate("DATAINI"),_maxope)) {
                  /* _findsog := 0 */
                  _findsog = CPLib.Round(0,0);
                } // End If
                /* If qbe_famesiti_jntestbo_minmax->DATAINI <= CharToDate('20110101') */
                if (CPLib.le(Cursor_qbe_famesiti_jntestbo_minmax.GetDate("DATAINI"),CPLib.CharToDate("20110101"))) {
                  /* _findsog := 0 */
                  _findsog = CPLib.Round(0,0);
                } // End If
                Cursor_qbe_famesiti_jntestbo_minmax.Next();
              }
              m_cConnectivityError = Cursor_qbe_famesiti_jntestbo_minmax.ErrorMessage();
              Cursor_qbe_famesiti_jntestbo_minmax.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from qbe_famesiti_intestbo_minmax
              SPBridge.HMCaller _h0000022C;
              _h0000022C = new SPBridge.HMCaller();
              _h0000022C.Set("m_cVQRList",m_cVQRList);
              _h0000022C.Set("pRAPPORTO",Cursor_qbe_famesiti_norapp.GetString("RAPPORTO"));
              if (Cursor_qbe_famesiti_intestbo_minmax!=null)
                Cursor_qbe_famesiti_intestbo_minmax.Close();
              Cursor_qbe_famesiti_intestbo_minmax = new VQRHolder("qbe_famesiti_intestbo_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000022C,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_famesiti_intestbo_minmax.Eof())) {
                /* If qbe_famesiti_intestbo_minmax->DATAINI >= _maxope */
                if (CPLib.ge(Cursor_qbe_famesiti_intestbo_minmax.GetDate("DATAINI"),_maxope)) {
                  /* _findsog := 0 */
                  _findsog = CPLib.Round(0,0);
                } // End If
                /* If qbe_famesiti_intestbo_minmax->DATAINI <= CharToDate('20110101') */
                if (CPLib.le(Cursor_qbe_famesiti_intestbo_minmax.GetDate("DATAINI"),CPLib.CharToDate("20110101"))) {
                  /* _findsog := 0 */
                  _findsog = CPLib.Round(0,0);
                } // End If
                Cursor_qbe_famesiti_intestbo_minmax.Next();
              }
              m_cConnectivityError = Cursor_qbe_famesiti_intestbo_minmax.ErrorMessage();
              Cursor_qbe_famesiti_intestbo_minmax.Close();
              // * --- End Select
            } // End If
            /* If _findsog=1 */
            if (CPLib.eqr(_findsog,1)) {
              /* gMsgImp := 'Famiglia non presente in AGE. Codice: '+ qbe_famesiti_norapp->RAPPORTO // Messaggio Import */
              gMsgImp = "Famiglia non presente in AGE. Codice: "+Cursor_qbe_famesiti_norapp.GetString("RAPPORTO");
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _contaerr := _contaerr + 1 */
              _contaerr = CPLib.Round(_contaerr+1,0);
              /* If w_flgwrt='M' */
              if (CPLib.eqr(w_flgwrt,"M")) {
                /* mcEsitiErr.AppendBlank() */
                mcEsitiErr.AppendBlank();
                /* mcEsitiErr.UNIQUECODE := qbe_famesiti_norapp->UNIQUER */
                mcEsitiErr.row.UNIQUECODE = Cursor_qbe_famesiti_norapp.GetString("UNIQUER");
                /* mcEsitiErr.RAPPORTO := qbe_famesiti_norapp->RAPPORTO */
                mcEsitiErr.row.RAPPORTO = Cursor_qbe_famesiti_norapp.GetString("RAPPORTO");
                /* mcEsitiErr.TIPORAP := 'R' */
                mcEsitiErr.row.TIPORAP = "R";
                /* mcEsitiErr.NDGSOG := Replicate('X',16) */
                mcEsitiErr.row.NDGSOG = CPLib.Replicate("X",16);
                /* mcEsitiErr.ERRMSG := '* - Famiglia presente in WEBANTI ma non in AGE' */
                mcEsitiErr.row.ERRMSG = "* - Famiglia presente in WEBANTI ma non in AGE";
              } else { // Else
                // * --- Insert into tmp_esitierr from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_esitierr");
                m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"0000023B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000023B(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_famesiti_norapp.GetString("UNIQUER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_famesiti_norapp.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",16),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("* - Famiglia presente in WEBANTI ma non in AGE","?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
              } // End If
            } // End If
            Cursor_qbe_famesiti_norapp.Next();
          }
          m_cConnectivityError = Cursor_qbe_famesiti_norapp.ErrorMessage();
          Cursor_qbe_famesiti_norapp.Close();
          // * --- End Select
        } // End If
        /* If _contaerr > 0 */
        if (CPLib.gt(_contaerr,0)) {
          /* If w_flgwrt='M' */
          if (CPLib.eqr(w_flgwrt,"M")) {
            for (MemoryCursorRow_mcesitierr_mcrdef rowEsitiErr : mcEsitiErr._iterable_()) {
              /* gMsgImp := 'Trasferimento dati per stampa. Codice '+ rowEsitiErr.RAPPORTO // Messaggio Import */
              gMsgImp = "Trasferimento dati per stampa. Codice "+rowEsitiErr.RAPPORTO;
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              // * --- Insert into tmp_esitierr from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_esitierr");
              m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000240")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000240(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowEsitiErr.UNIQUECODE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowEsitiErr.TIPORAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowEsitiErr.RAPPORTO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowEsitiErr.NDGSOG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowEsitiErr.ERRMSG,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowEsitiErr.DATOMIT,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowEsitiErr.DATOAGE,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
          } // End If
        } else { // Else
          // * --- Insert into tmp_esitierr from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_esitierr");
          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000241")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000241(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("X",50),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000067status,0)) {
          m_Sql.SetTransactionStatus(nTry00000067status,cTry00000067msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Sono stati rilevati: '+LRTrim(Str(_contaerr,10,0))+" errori su "+LRTrim(Str(_tot,10,0)) + " famiglie esaminate"+NL // Messaggio */
      gMsgProc = gMsgProc+"Sono stati rilevati: "+CPLib.LRTrim(CPLib.Str(_contaerr,10,0))+" errori su "+CPLib.LRTrim(CPLib.Str(_tot,10,0))+" famiglie esaminate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Esame Famiglie: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Esame Famiglie: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Elaborazione Terminata!' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If _contaerr > 0 */
      if (CPLib.gt(_contaerr,0)) {
        /* cReport := "arrp_famesiti_migra.vrp" */
        cReport = "arrp_famesiti_migra.vrp";
      } else { // Else
        /* cReport := "arrp_famesiti_migra_noerr.vrp" */
        cReport = "arrp_famesiti_migra_noerr.vrp";
      } // End If
      /* Return cReport */
      throw new Stop(cReport);
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
        if (Cursor_opextrbo!=null)
          Cursor_opextrbo.Close();
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
        if (Cursor_aetesta!=null)
          Cursor_aetesta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeannora!=null)
          Cursor_aeannora.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famesiti_jntestbo_minmax!=null)
          Cursor_qbe_famesiti_jntestbo_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famesiti_intestbo_minmax!=null)
          Cursor_qbe_famesiti_intestbo_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famesiti_noopex!=null)
          Cursor_qbe_famesiti_noopex.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famesiti_norapp!=null)
          Cursor_qbe_famesiti_norapp.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Pag_2() throws Exception {
    /* Esamina gli intestatari */
    /* mcFam0.GoTop() */
    mcFam0.GoTop();
    /* While not(mcFam0.Eof()) */
    while ( ! (mcFam0.Eof())) {
      /* _findsog := 0 */
      _findsog = CPLib.Round(0,0);
      /* gMsgImp := 'Confronto soggetto: '+rowFamesitid.FADCODFIS+" con soggetto: "+mcFam0.CODFISC */
      gMsgImp = "Confronto soggetto: "+rowFamesitid.FADCODFIS+" con soggetto: "+mcFam0.row.CODFISC;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If mcFam0.MATCH <> '*' */
      if (CPLib.ne(mcFam0.row.MATCH,"*")) {
        /* If not(Empty(rowFamesitid.FADCODFIS)) */
        if ( ! (CPLib.Empty(rowFamesitid.FADCODFIS))) {
          /* If Len(LRTrim(rowFamesitid.FADCODFIS))=11 */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(rowFamesitid.FADCODFIS)),11)) {
            /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim("***"+Right(LRTrim(mcFam0.CODFISC),8)) and Val(Left(mcFam0.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam0.DATAINI and iif(mcFam0.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam0.DATAFINE,True) */
            if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("***"+CPLib.Right(CPLib.LRTrim(mcFam0.row.CODFISC),8))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam0.row.DATAINI) && (CPLib.le(mcFam0.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam0.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } else { // Else
            /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim("******"+Right(LRTrim(mcFam0.CODFISC),10)) and Val(Left(mcFam0.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam0.DATAINI and iif(mcFam0.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam0.DATAFINE,True) */
            if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("******"+CPLib.Right(CPLib.LRTrim(mcFam0.row.CODFISC),10))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam0.row.DATAINI) && (CPLib.le(mcFam0.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam0.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } // End If
        } else { // Else
          /* If Empty(rowFamesitid.FADSESSO) */
          if (CPLib.Empty(rowFamesitid.FADSESSO)) {
            /* _stringa1 := LRTrim(arfn_agechar(Left(mcFam0.RAGSOC,60)," "))+"-"+LRTrim(arfn_agechar(mcFam0.SEDELEG," "))+"-"+LRTrim(mcFam0.PROVLEG) */
            _stringa1 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Left(mcFam0.row.RAGSOC,60)," "))+"-"+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcFam0.row.SEDELEG," "))+"-"+CPLib.LRTrim(mcFam0.row.PROVLEG);
            /* _stringa2 := LRTrim(arfn_agechar(Left(rowFamesitid.FADCOGRAG,60)," "))+"-"+LRTrim(arfn_agechar(rowFamesitid.FADNASSEL," "))+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
            _stringa2 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Left(rowFamesitid.FADCOGRAG,60)," "))+"-"+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADNASSEL," "))+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
            /* If _stringa1 = _stringa2 and Val(Left(mcFam0.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam0.DATAINI and iif(mcFam0.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam0.DATAFINE,True) */
            if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam0.row.DATAINI) && (CPLib.le(mcFam0.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam0.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } else { // Else
            /* _stringa1 := LRTrim(arfn_agechar(mcFam0.LUONAS," "))+"-"+LRTrim(mcFam0.PROVNAS)+"-"+DateToChar(mcFam0.DATNAS)+"-"+iif(mcFam0.SESSO='1','M',iif(mcFam0.SESSO='2','F','')) */
            _stringa1 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcFam0.row.LUONAS," "))+"-"+CPLib.LRTrim(mcFam0.row.PROVNAS)+"-"+CPLib.DateToChar(mcFam0.row.DATNAS)+"-"+(CPLib.eqr(mcFam0.row.SESSO,"1")?"M":(CPLib.eqr(mcFam0.row.SESSO,"2")?"F":""));
            /* _stringa2 := LRTrim(arfn_agechar(rowFamesitid.FADNASSEL," "))+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO */
            _stringa2 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADNASSEL," "))+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO;
            /* If _stringa1 = _stringa2 and Val(Left(mcFam0.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam0.DATAINI and iif(mcFam0.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam0.DATAFINE,True) */
            if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam0.row.DATAINI) && (CPLib.le(mcFam0.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam0.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } // End If
        } // End If
        /* If _findsog=3 */
        if (CPLib.eqr(_findsog,3)) {
          /* mcFam0.MATCH := '*' */
          mcFam0.row.MATCH = "*";
          /* mcFam0.SaveRow() */
          mcFam0.SaveRow();
          // Exit Loop
          if (true) {
            break;
          }
        } // End If
      } // End If
      /* mcFam0.Skip() */
      mcFam0.Skip();
    } // End While
    /* If _findsog <> 3 */
    if (CPLib.ne(_findsog,3)) {
      /* mcFam0.GoTop() */
      mcFam0.GoTop();
      /* While not(mcFam0.Eof()) */
      while ( ! (mcFam0.Eof())) {
        /* If mcFam0.MATCH <> '*' */
        if (CPLib.ne(mcFam0.row.MATCH,"*")) {
          /* If not(Empty(rowFamesitid.FADCODFIS)) */
          if ( ! (CPLib.Empty(rowFamesitid.FADCODFIS))) {
            /* If Len(LRTrim(rowFamesitid.FADCODFIS))=11 */
            if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(rowFamesitid.FADCODFIS)),11)) {
              /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim("***"+Right(LRTrim(mcFam0.CODFISC),8)) and Val(Left(mcFam0.TIPOSOG,1))=rowFamesitid.FADRUOLO */
              if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("***"+CPLib.Right(CPLib.LRTrim(mcFam0.row.CODFISC),8))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam0.CODINTER */
                _ndgsog = mcFam0.row.CODINTER;
                /* _dataini := mcFam0.DATAINI */
                _dataini = mcFam0.row.DATAINI;
                /* _datafin := mcFam0.DATAFINE */
                _datafin = mcFam0.row.DATAFINE;
                /* _origine := mcFam0.ORIGINE */
                _origine = mcFam0.row.ORIGINE;
                /* _ruolo := Left(mcFam0.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam0.row.TIPOSOG,1);
                /* ElseIf LRTrim(rowFamesitid.FADCODFIS)=LRTrim("***"+Right(LRTrim(mcFam0.CODFISC),8)) and Val(Left(mcFam0.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("***"+CPLib.Right(CPLib.LRTrim(mcFam0.row.CODFISC),8))) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam0.CODINTER */
                _ndgsog = mcFam0.row.CODINTER;
                /* _dataini := mcFam0.DATAINI */
                _dataini = mcFam0.row.DATAINI;
                /* _datafin := mcFam0.DATAFINE */
                _datafin = mcFam0.row.DATAFINE;
                /* _origine := mcFam0.ORIGINE */
                _origine = mcFam0.row.ORIGINE;
                /* _ruolo := Left(mcFam0.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam0.row.TIPOSOG,1);
              } // End If
            } else { // Else
              /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim('******'+Right(LRTrim(mcFam0.CODFISC),10)) and Val(Left(mcFam0.TIPOSOG,1))=rowFamesitid.FADRUOLO */
              if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("******"+CPLib.Right(CPLib.LRTrim(mcFam0.row.CODFISC),10))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam0.CODINTER */
                _ndgsog = mcFam0.row.CODINTER;
                /* _dataini := mcFam0.DATAINI */
                _dataini = mcFam0.row.DATAINI;
                /* _datafin := mcFam0.DATAFINE */
                _datafin = mcFam0.row.DATAFINE;
                /* _origine := mcFam0.ORIGINE */
                _origine = mcFam0.row.ORIGINE;
                /* _ruolo := Left(mcFam0.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam0.row.TIPOSOG,1);
                /* ElseIf LRTrim(rowFamesitid.FADCODFIS)=LRTrim('******'+Right(LRTrim(mcFam0.CODFISC),10)) and Val(Left(mcFam0.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("******"+CPLib.Right(CPLib.LRTrim(mcFam0.row.CODFISC),10))) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam0.CODINTER */
                _ndgsog = mcFam0.row.CODINTER;
                /* _dataini := mcFam0.DATAINI */
                _dataini = mcFam0.row.DATAINI;
                /* _datafin := mcFam0.DATAFINE */
                _datafin = mcFam0.row.DATAFINE;
                /* _origine := mcFam0.ORIGINE */
                _origine = mcFam0.row.ORIGINE;
                /* _ruolo := Left(mcFam0.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam0.row.TIPOSOG,1);
              } // End If
            } // End If
            /* If _findsog=1 or _findsog=2 */
            if (CPLib.eqr(_findsog,1) || CPLib.eqr(_findsog,2)) {
              /* If rowFamesitid.FADDATINI <> _dataini */
              if (CPLib.ne(rowFamesitid.FADDATINI,_dataini)) {
                /* _contaerr := _contaerr + 1 */
                _contaerr = CPLib.Round(_contaerr+1,0);
                /* If w_flgwrt='M' */
                if (CPLib.eqr(w_flgwrt,"M")) {
                  /* mcEsitiErr.AppendBlank() */
                  mcEsitiErr.AppendBlank();
                  /* mcEsitiErr.UNIQUECODE := _famcodice */
                  mcEsitiErr.row.UNIQUECODE = _famcodice;
                  /* mcEsitiErr.RAPPORTO := _rapporto */
                  mcEsitiErr.row.RAPPORTO = _rapporto;
                  /* mcEsitiErr.TIPORAP := 'R' */
                  mcEsitiErr.row.TIPORAP = "R";
                  /* mcEsitiErr.NDGSOG := _ndgsog */
                  mcEsitiErr.row.NDGSOG = _ndgsog;
                  /* mcEsitiErr.DATOMIT := 'Data Inizio '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_dataini) */
                  mcEsitiErr.row.DATOMIT = "Data Inizio "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_dataini);
                  /* mcEsitiErr.DATOAGE := 'Data Inizio AGE: '+arfn_fdate(rowFamesitid.FADDATINI) */
                  mcEsitiErr.row.DATOAGE = "Data Inizio AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI);
                  /* mcEsitiErr.ERRMSG := '* Data Inizio Intestatario non coincide (Ruolo: '+_ruolo+')' */
                  mcEsitiErr.row.ERRMSG = "* Data Inizio Intestatario non coincide (Ruolo: "+_ruolo+")";
                } else { // Else
                  // * --- Insert into tmp_esitierr from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_esitierr");
                  m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000291")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000291(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_dataini),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("* Data Inizio Intestatario non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
              } // End If
              /* If rowFamesitid.FADDATFIN <> _datafin and _datafin <= _maxope */
              if (CPLib.ne(rowFamesitid.FADDATFIN,_datafin) && CPLib.le(_datafin,_maxope)) {
                /* _contaerr := _contaerr + 1 */
                _contaerr = CPLib.Round(_contaerr+1,0);
                /* If w_flgwrt='M' */
                if (CPLib.eqr(w_flgwrt,"M")) {
                  /* mcEsitiErr.AppendBlank() */
                  mcEsitiErr.AppendBlank();
                  /* mcEsitiErr.UNIQUECODE := _famcodice */
                  mcEsitiErr.row.UNIQUECODE = _famcodice;
                  /* mcEsitiErr.RAPPORTO := _rapporto */
                  mcEsitiErr.row.RAPPORTO = _rapporto;
                  /* mcEsitiErr.TIPORAP := 'R' */
                  mcEsitiErr.row.TIPORAP = "R";
                  /* mcEsitiErr.NDGSOG := _ndgsog */
                  mcEsitiErr.row.NDGSOG = _ndgsog;
                  /* mcEsitiErr.DATOMIT := 'Data Fine '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_datafin) */
                  mcEsitiErr.row.DATOMIT = "Data Fine "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_datafin);
                  /* mcEsitiErr.DATOAGE := 'Data Fine AGE: '+arfn_fdate(rowFamesitid.FADDATFIN) */
                  mcEsitiErr.row.DATOAGE = "Data Fine AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN);
                  /* mcEsitiErr.ERRMSG := '* Data Fine Intestatario non coincide (Ruolo: '+_ruolo+')' */
                  mcEsitiErr.row.ERRMSG = "* Data Fine Intestatario non coincide (Ruolo: "+_ruolo+")";
                } else { // Else
                  // * --- Insert into tmp_esitierr from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_esitierr");
                  m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"0000029D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000029D(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_datafin),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("* Data Fine Intestatario non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
              } // End If
            } // End If
          } else { // Else
            /* If Empty(rowFamesitid.FADSESSO) */
            if (CPLib.Empty(rowFamesitid.FADSESSO)) {
              /* _stringa1 := LRTrim(Left(mcFam0.RAGSOC,60))+"-"+LRTrim(mcFam0.SEDELEG)+"-"+LRTrim(mcFam0.PROVLEG) */
              _stringa1 = CPLib.LRTrim(CPLib.Left(mcFam0.row.RAGSOC,60))+"-"+CPLib.LRTrim(mcFam0.row.SEDELEG)+"-"+CPLib.LRTrim(mcFam0.row.PROVLEG);
              /* _stringa2 := LRTrim(rowFamesitid.FADCOGRAG)+"-"+LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
              _stringa2 = CPLib.LRTrim(rowFamesitid.FADCOGRAG)+"-"+CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
              /* If _stringa1 = _stringa2 and Val(Left(mcFam0.TIPOSOG,1))=rowFamesitid.FADRUOLO */
              if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam0.CODINTER */
                _ndgsog = mcFam0.row.CODINTER;
                /* _dataini := mcFam0.DATAINI */
                _dataini = mcFam0.row.DATAINI;
                /* _datafin := mcFam0.DATAFINE */
                _datafin = mcFam0.row.DATAFINE;
                /* _origine := mcFam0.ORIGINE */
                _origine = mcFam0.row.ORIGINE;
                /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam0.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam0.CODINTER */
                _ndgsog = mcFam0.row.CODINTER;
                /* _dataini := mcFam0.DATAINI */
                _dataini = mcFam0.row.DATAINI;
                /* _datafin := mcFam0.DATAFINE */
                _datafin = mcFam0.row.DATAFINE;
                /* _origine := mcFam0.ORIGINE */
                _origine = mcFam0.row.ORIGINE;
                /* _ruolo := Left(mcFam0.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam0.row.TIPOSOG,1);
              } // End If
              /* If _findsog=0 */
              if (CPLib.eqr(_findsog,0)) {
                /* _stringa1 := LRTrim(arfn_agechar(Left(mcFam0.RAGSOC,60),' '))+"-"+LRTrim(arfn_agechar(mcFam0.SEDELEG,' '))+"-"+LRTrim(mcFam0.PROVLEG) */
                _stringa1 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Left(mcFam0.row.RAGSOC,60)," "))+"-"+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcFam0.row.SEDELEG," "))+"-"+CPLib.LRTrim(mcFam0.row.PROVLEG);
                /* _stringa2 := LRTrim(arfn_agechar(rowFamesitid.FADCOGRAG,' '))+"-"+LRTrim(arfn_agechar(rowFamesitid.FADNASSEL,' '))+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
                _stringa2 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADCOGRAG," "))+"-"+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADNASSEL," "))+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
                /* If _stringa1 = _stringa2 and Val(Left(mcFam0.TIPOSOG,1))=rowFamesitid.FADRUOLO */
                if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 1 */
                  _findsog = CPLib.Round(1,0);
                  /* _ndgsog := mcFam0.CODINTER */
                  _ndgsog = mcFam0.row.CODINTER;
                  /* _dataini := mcFam0.DATAINI */
                  _dataini = mcFam0.row.DATAINI;
                  /* _datafin := mcFam0.DATAFINE */
                  _datafin = mcFam0.row.DATAFINE;
                  /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam0.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
                } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 2 */
                  _findsog = CPLib.Round(2,0);
                  /* _ndgsog := mcFam0.CODINTER */
                  _ndgsog = mcFam0.row.CODINTER;
                  /* _dataini := mcFam0.DATAINI */
                  _dataini = mcFam0.row.DATAINI;
                  /* _datafin := mcFam0.DATAFINE */
                  _datafin = mcFam0.row.DATAFINE;
                  /* _ruolo := Left(mcFam0.TIPOSOG,1) */
                  _ruolo = CPLib.Left(mcFam0.row.TIPOSOG,1);
                } // End If
              } // End If
            } else { // Else
              /* _stringa1 := LRTrim(mcFam0.LUONAS)+"-"+LRTrim(mcFam0.PROVNAS)+"-"+DateToChar(mcFam0.DATNAS)+"-"+iif(mcFam0.SESSO='1','M',iif(mcFam0.SESSO='2','F','')) */
              _stringa1 = CPLib.LRTrim(mcFam0.row.LUONAS)+"-"+CPLib.LRTrim(mcFam0.row.PROVNAS)+"-"+CPLib.DateToChar(mcFam0.row.DATNAS)+"-"+(CPLib.eqr(mcFam0.row.SESSO,"1")?"M":(CPLib.eqr(mcFam0.row.SESSO,"2")?"F":""));
              /* _stringa2 := LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO */
              _stringa2 = CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO;
              /* If _stringa1 = _stringa2 and Val(Left(mcFam0.TIPOSOG,1)) = rowFamesitid.FADRUOLO */
              if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam0.CODINTER */
                _ndgsog = mcFam0.row.CODINTER;
                /* _dataini := mcFam0.DATAINI */
                _dataini = mcFam0.row.DATAINI;
                /* _datafin := mcFam0.DATAFINE */
                _datafin = mcFam0.row.DATAFINE;
                /* _origine := mcFam0.ORIGINE */
                _origine = mcFam0.row.ORIGINE;
                /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam0.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam0.CODINTER */
                _ndgsog = mcFam0.row.CODINTER;
                /* _dataini := mcFam0.DATAINI */
                _dataini = mcFam0.row.DATAINI;
                /* _datafin := mcFam0.DATAFINE */
                _datafin = mcFam0.row.DATAFINE;
                /* _origine := mcFam0.ORIGINE */
                _origine = mcFam0.row.ORIGINE;
                /* _ruolo := Left(mcFam0.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam0.row.TIPOSOG,1);
              } // End If
              /* If _findsog=0 */
              if (CPLib.eqr(_findsog,0)) {
                /* _stringa1 := LRTrim(arfn_agechar(mcFam0.LUONAS,' '))+"-"+LRTrim(mcFam0.PROVNAS)+"-"+DateToChar(mcFam0.DATNAS)+"-"+iif(mcFam0.SESSO='1','M',iif(mcFam0.SESSO='2','F','')) */
                _stringa1 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcFam0.row.LUONAS," "))+"-"+CPLib.LRTrim(mcFam0.row.PROVNAS)+"-"+CPLib.DateToChar(mcFam0.row.DATNAS)+"-"+(CPLib.eqr(mcFam0.row.SESSO,"1")?"M":(CPLib.eqr(mcFam0.row.SESSO,"2")?"F":""));
                /* _stringa2 := LRTrim(arfn_agechar(rowFamesitid.FADNASSEL,' '))+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO */
                _stringa2 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADNASSEL," "))+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO;
                /* If _stringa1 = _stringa2 and Val(Left(mcFam0.TIPOSOG,1)) = rowFamesitid.FADRUOLO */
                if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 1 */
                  _findsog = CPLib.Round(1,0);
                  /* _ndgsog := mcFam0.CODINTER */
                  _ndgsog = mcFam0.row.CODINTER;
                  /* _dataini := mcFam0.DATAINI */
                  _dataini = mcFam0.row.DATAINI;
                  /* _datafin := mcFam0.DATAFINE */
                  _datafin = mcFam0.row.DATAFINE;
                  /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam0.TIPOSOG,1)) <> rowFamesitid.FADRUOLO */
                } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam0.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 2 */
                  _findsog = CPLib.Round(2,0);
                  /* _ndgsog := mcFam0.CODINTER */
                  _ndgsog = mcFam0.row.CODINTER;
                  /* _dataini := mcFam0.DATAINI */
                  _dataini = mcFam0.row.DATAINI;
                  /* _datafin := mcFam0.DATAFINE */
                  _datafin = mcFam0.row.DATAFINE;
                  /* _ruolo := Left(mcFam0.TIPOSOG,1) */
                  _ruolo = CPLib.Left(mcFam0.row.TIPOSOG,1);
                } // End If
              } // End If
            } // End If
            /* If _findsog =1 or _findsog=2 */
            if (CPLib.eqr(_findsog,1) || CPLib.eqr(_findsog,2)) {
              /* If _stringa1=_stringa2 */
              if (CPLib.eqr(_stringa1,_stringa2)) {
                /* If rowFamesitid.FADDATINI <> _dataini */
                if (CPLib.ne(rowFamesitid.FADDATINI,_dataini)) {
                  /* _contaerr := _contaerr + 1 */
                  _contaerr = CPLib.Round(_contaerr+1,0);
                  /* If w_flgwrt='M' */
                  if (CPLib.eqr(w_flgwrt,"M")) {
                    /* mcEsitiErr.AppendBlank() */
                    mcEsitiErr.AppendBlank();
                    /* mcEsitiErr.UNIQUECODE := _famcodice */
                    mcEsitiErr.row.UNIQUECODE = _famcodice;
                    /* mcEsitiErr.RAPPORTO := _rapporto */
                    mcEsitiErr.row.RAPPORTO = _rapporto;
                    /* mcEsitiErr.TIPORAP := 'R' */
                    mcEsitiErr.row.TIPORAP = "R";
                    /* mcEsitiErr.NDGSOG := _ndgsog */
                    mcEsitiErr.row.NDGSOG = _ndgsog;
                    /* mcEsitiErr.DATOMIT := 'Data Inizio Intestatario '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_dataini) */
                    mcEsitiErr.row.DATOMIT = "Data Inizio Intestatario "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_dataini);
                    /* mcEsitiErr.DATOAGE := 'Data Inizio Intestatario AGE: '+arfn_fdate(rowFamesitid.FADDATINI) */
                    mcEsitiErr.row.DATOAGE = "Data Inizio Intestatario AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI);
                    /* mcEsitiErr.ERRMSG := '* Data Inizio Intestatario non coincide (Ruolo: '+_ruolo+')' */
                    mcEsitiErr.row.ERRMSG = "* Data Inizio Intestatario non coincide (Ruolo: "+_ruolo+")";
                  } else { // Else
                    // * --- Insert into tmp_esitierr from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_esitierr");
                    m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000002E2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000002E2(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio MIT: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataini),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("* Data Inizio Intestatario non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                } // End If
                /* If rowFamesitid.FADDATFIN <> _datafin and _datafin <= _maxope */
                if (CPLib.ne(rowFamesitid.FADDATFIN,_datafin) && CPLib.le(_datafin,_maxope)) {
                  /* _contaerr := _contaerr + 1 */
                  _contaerr = CPLib.Round(_contaerr+1,0);
                  /* If w_flgwrt='M' */
                  if (CPLib.eqr(w_flgwrt,"M")) {
                    /* mcEsitiErr.AppendBlank() */
                    mcEsitiErr.AppendBlank();
                    /* mcEsitiErr.UNIQUECODE := _famcodice */
                    mcEsitiErr.row.UNIQUECODE = _famcodice;
                    /* mcEsitiErr.RAPPORTO := _rapporto */
                    mcEsitiErr.row.RAPPORTO = _rapporto;
                    /* mcEsitiErr.TIPORAP := 'R' */
                    mcEsitiErr.row.TIPORAP = "R";
                    /* mcEsitiErr.NDGSOG := _ndgsog */
                    mcEsitiErr.row.NDGSOG = _ndgsog;
                    /* mcEsitiErr.DATOMIT := 'Data Fine Intestatario '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_datafin) */
                    mcEsitiErr.row.DATOMIT = "Data Fine Intestatario "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_datafin);
                    /* mcEsitiErr.DATOAGE := 'Data Fine Intestatario AGE: '+arfn_fdate(rowFamesitid.FADDATFIN) */
                    mcEsitiErr.row.DATOAGE = "Data Fine Intestatario AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN);
                    /* mcEsitiErr.ERRMSG := '* Data Fine Intestatario non coincide (Ruolo: '+_ruolo+')' */
                    mcEsitiErr.row.ERRMSG = "* Data Fine Intestatario non coincide (Ruolo: "+_ruolo+")";
                  } else { // Else
                    // * --- Insert into tmp_esitierr from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_esitierr");
                    m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000002EE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000002EE(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine MIT: "+arfn_fdateR.Make(m_Ctx,this).Run(_datafin),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("* Data Fine Intestatario non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                } // End If
              } else { // Else
                /* _contaerr := _contaerr + 1 */
                _contaerr = CPLib.Round(_contaerr+1,0);
                /* If w_flgwrt='M' */
                if (CPLib.eqr(w_flgwrt,"M")) {
                  /* mcEsitiErr.AppendBlank() */
                  mcEsitiErr.AppendBlank();
                  /* mcEsitiErr.UNIQUECODE := _famcodice */
                  mcEsitiErr.row.UNIQUECODE = _famcodice;
                  /* mcEsitiErr.RAPPORTO := _rapporto */
                  mcEsitiErr.row.RAPPORTO = _rapporto;
                  /* mcEsitiErr.TIPORAP := 'R' */
                  mcEsitiErr.row.TIPORAP = "R";
                  /* mcEsitiErr.NDGSOG := _ndgsog */
                  mcEsitiErr.row.NDGSOG = _ndgsog;
                  /* mcEsitiErr.DATOMIT := 'Dati MIT: '+_stringa1 */
                  mcEsitiErr.row.DATOMIT = "Dati MIT: "+_stringa1;
                  /* mcEsitiErr.DATOAGE := 'Dati AGE: '+_stringa2 */
                  mcEsitiErr.row.DATOAGE = "Dati AGE: "+_stringa2;
                  /* mcEsitiErr.ERRMSG := '* Dati Soggetto Non Coincidono' */
                  mcEsitiErr.row.ERRMSG = "* Dati Soggetto Non Coincidono";
                } else { // Else
                  // * --- Insert into tmp_esitierr from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_esitierr");
                  m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000002F9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000002F9(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Dati MIT: "+_stringa1,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Dati AGE: "+_stringa2,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("* Dati Soggetto Non Coincidono","?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
              } // End If
            } // End If
          } // End If
          /* If _findsog=1 or _findsog=2 */
          if (CPLib.eqr(_findsog,1) || CPLib.eqr(_findsog,2)) {
            /* mcFam0.MATCH := '*' */
            mcFam0.row.MATCH = "*";
            /* mcFam0.SaveRow() */
            mcFam0.SaveRow();
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        } // End If
        /* mcFam0.Skip() */
        mcFam0.Skip();
      } // End While
      /* If _findsog=2 */
      if (CPLib.eqr(_findsog,2)) {
        /* _contaerr := _contaerr + 1 */
        _contaerr = CPLib.Round(_contaerr+1,0);
        /* _datiage := 'Dati AGE: C.F. '+LRTrim(rowFamesitid.FADCODFIS) + ' - Ruolo Age: ' +Str(rowFamesitid.FADRUOLO,1,0) */
        _datiage = "Dati AGE: C.F. "+CPLib.LRTrim(rowFamesitid.FADCODFIS)+" - Ruolo Age: "+CPLib.Str(rowFamesitid.FADRUOLO,1,0);
        /* _errore := '* Ruolo intestatario non corrispondente' */
        _errore = "* Ruolo intestatario non corrispondente";
        /* If w_flgwrt='M' */
        if (CPLib.eqr(w_flgwrt,"M")) {
          /* mcEsitiErr.AppendBlank() */
          mcEsitiErr.AppendBlank();
          /* mcEsitiErr.UNIQUECODE := _famcodice */
          mcEsitiErr.row.UNIQUECODE = _famcodice;
          /* mcEsitiErr.RAPPORTO := _rapporto */
          mcEsitiErr.row.RAPPORTO = _rapporto;
          /* mcEsitiErr.TIPORAP := 'R' */
          mcEsitiErr.row.TIPORAP = "R";
          /* mcEsitiErr.NDGSOG := LRTrim(rowFamesitid.FADCODFIS) */
          mcEsitiErr.row.NDGSOG = CPLib.LRTrim(rowFamesitid.FADCODFIS);
          /* mcEsitiErr.DATOMIT := 'Dati MIT: Ruolo ' + _ruolo */
          mcEsitiErr.row.DATOMIT = "Dati MIT: Ruolo "+_ruolo;
          /* mcEsitiErr.DATOAGE := _datiage */
          mcEsitiErr.row.DATOAGE = _datiage;
          /* mcEsitiErr.ERRMSG := _errore */
          mcEsitiErr.row.ERRMSG = _errore;
        } else { // Else
          // * --- Insert into tmp_esitierr from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_esitierr");
          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"0000030C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000030C(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowFamesitid.FADCODFIS),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Dati MIT: Ruolo "+_ruolo,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datiage,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
      } // End If
      /* If _findsog=0 */
      if (CPLib.eqr(_findsog,0)) {
        /* _contaerr := _contaerr + 1 */
        _contaerr = CPLib.Round(_contaerr+1,0);
        /* If not(Empty(rowFamesitid.FADCODFIS)) */
        if ( ! (CPLib.Empty(rowFamesitid.FADCODFIS))) {
          /* _datiage := 'Dati AGE: C.F. '+LRTrim(rowFamesitid.FADCODFIS) */
          _datiage = "Dati AGE: C.F. "+CPLib.LRTrim(rowFamesitid.FADCODFIS);
          /* _errore := '* Codice Fiscale Soggetto non presente in AUI/AGE per il ruolo ('+rowFamesitid.FADRUOLO+') indicato' */
          _errore = "* Codice Fiscale Soggetto non presente in AUI/AGE per il ruolo ("+rowFamesitid.FADRUOLO+") indicato";
        } else { // Else
          /* If not(Empty(LRTrim(rowFamesitid.FADCOGRAG))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(rowFamesitid.FADCOGRAG)))) {
            /* _datiage := 'Dati AGE: Soggetto '+LRTrim(rowFamesitid.FADCOGRAG)+"-"+LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
            _datiage = "Dati AGE: Soggetto "+CPLib.LRTrim(rowFamesitid.FADCOGRAG)+"-"+CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
          } else { // Else
            /* _datiage := 'Dati AGE: Soggetto '+LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO */
            _datiage = "Dati AGE: Soggetto "+CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO;
          } // End If
          /* _errore := '* Nominativo non presente in AUI/AGE per il ruolo ('+rowFamesitid.FADRUOLO+') indicato'+iif(not(Empty(_datafinrap)),NL+" (Rapporto chiuso il "+arfn_fdate(_datafinrap)+")","") */
          _errore = "* Nominativo non presente in AUI/AGE per il ruolo ("+rowFamesitid.FADRUOLO+") indicato"+( ! (CPLib.Empty(_datafinrap))?"\n"+" (Rapporto chiuso il "+arfn_fdateR.Make(m_Ctx,this).Run(_datafinrap)+")":"");
        } // End If
        /* If w_flgwrt='M' */
        if (CPLib.eqr(w_flgwrt,"M")) {
          /* mcEsitiErr.AppendBlank() */
          mcEsitiErr.AppendBlank();
          /* mcEsitiErr.UNIQUECODE := _famcodice */
          mcEsitiErr.row.UNIQUECODE = _famcodice;
          /* mcEsitiErr.RAPPORTO := _rapporto */
          mcEsitiErr.row.RAPPORTO = _rapporto;
          /* mcEsitiErr.TIPORAP := 'R' */
          mcEsitiErr.row.TIPORAP = "R";
          /* mcEsitiErr.NDGSOG := rowFamesitid.FADCODFIS */
          mcEsitiErr.row.NDGSOG = rowFamesitid.FADCODFIS;
          /* mcEsitiErr.DATOMIT := '' */
          mcEsitiErr.row.DATOMIT = "";
          /* mcEsitiErr.DATOAGE := _datiage */
          mcEsitiErr.row.DATOAGE = _datiage;
          /* mcEsitiErr.ERRMSG := _errore */
          mcEsitiErr.row.ERRMSG = _errore;
        } else { // Else
          // * --- Insert into tmp_esitierr from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_esitierr");
          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"0000031F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000031F(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowFamesitid.FADCODFIS,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datiage,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
      } // End If
    } // End If
  }
  void Pag_3() throws Exception {
    /* Esamina i delegati */
    /* mcFam5.GoTop() */
    mcFam5.GoTop();
    /* While not(mcFam5.Eof()) */
    while ( ! (mcFam5.Eof())) {
      /* _findsog := 0 */
      _findsog = CPLib.Round(0,0);
      /* gMsgImp := 'Confronto soggetto: '+rowFamesitid.FADCODFIS+" con soggetto: "+mcFam5.CODFISC */
      gMsgImp = "Confronto soggetto: "+rowFamesitid.FADCODFIS+" con soggetto: "+mcFam5.row.CODFISC;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If mcFam5.MATCH <> '*' */
      if (CPLib.ne(mcFam5.row.MATCH,"*")) {
        /* If not(Empty(rowFamesitid.FADCODFIS)) */
        if ( ! (CPLib.Empty(rowFamesitid.FADCODFIS))) {
          /* If Len(LRTrim(rowFamesitid.FADCODFIS))=11 */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(rowFamesitid.FADCODFIS)),11)) {
            /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim("***"+Right(LRTrim(mcFam5.CODFISC),8)) and Val(Left(mcFam5.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam5.DATAINI and iif(mcFam5.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam5.DATAFINE,True) */
            if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("***"+CPLib.Right(CPLib.LRTrim(mcFam5.row.CODFISC),8))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam5.row.DATAINI) && (CPLib.le(mcFam5.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam5.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } else { // Else
            /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim("******"+Right(LRTrim(mcFam5.CODFISC),10)) and Val(Left(mcFam5.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam5.DATAINI and iif(mcFam5.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam5.DATAFINE,True) */
            if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("******"+CPLib.Right(CPLib.LRTrim(mcFam5.row.CODFISC),10))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam5.row.DATAINI) && (CPLib.le(mcFam5.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam5.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } // End If
        } else { // Else
          /* If Empty(rowFamesitid.FADSESSO) */
          if (CPLib.Empty(rowFamesitid.FADSESSO)) {
            /* _stringa1 := LRTrim(arfn_agechar(Left(mcFam5.RAGSOC,60)," "))+"-"+LRTrim(mcFam5.SEDELEG)+"-"+LRTrim(mcFam5.PROVLEG) */
            _stringa1 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Left(mcFam5.row.RAGSOC,60)," "))+"-"+CPLib.LRTrim(mcFam5.row.SEDELEG)+"-"+CPLib.LRTrim(mcFam5.row.PROVLEG);
            /* _stringa2 := LRTrim(arfn_agechar(rowFamesitid.FADCOGRAG," "))+"-"+LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
            _stringa2 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADCOGRAG," "))+"-"+CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
            /* If _stringa1 = _stringa2 and Val(Left(mcFam5.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam5.DATAINI and iif(mcFam5.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam5.DATAFINE,True) */
            if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam5.row.DATAINI) && (CPLib.le(mcFam5.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam5.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } else { // Else
            /* _stringa1 := LRTrim(arfn_agechar(mcFam5.LUONAS," "))+"-"+LRTrim(mcFam5.PROVNAS)+"-"+DateToChar(mcFam5.DATNAS)+iif(mcFam5.SESSO='1','M',iif(mcFam5.SESSO='2','F','')) */
            _stringa1 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcFam5.row.LUONAS," "))+"-"+CPLib.LRTrim(mcFam5.row.PROVNAS)+"-"+CPLib.DateToChar(mcFam5.row.DATNAS)+(CPLib.eqr(mcFam5.row.SESSO,"1")?"M":(CPLib.eqr(mcFam5.row.SESSO,"2")?"F":""));
            /* _stringa2 := LRTrim(arfn_agechar(rowFamesitid.FADNASSEL," "))+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+rowFamesitid.FADSESSO */
            _stringa2 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADNASSEL," "))+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+rowFamesitid.FADSESSO;
            /* If _stringa1 = _stringa2 and Val(Left(mcFam5.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam5.DATAINI and iif(mcFam5.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam5.DATAFINE,True) */
            if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam5.row.DATAINI) && (CPLib.le(mcFam5.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam5.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } // End If
        } // End If
        /* If _findsog=3 */
        if (CPLib.eqr(_findsog,3)) {
          /* mcFam5.MATCH := '*' */
          mcFam5.row.MATCH = "*";
          /* mcFam5.SaveRow() */
          mcFam5.SaveRow();
          // Exit Loop
          if (true) {
            break;
          }
        } // End If
      } // End If
      /* mcFam5.Skip() */
      mcFam5.Skip();
    } // End While
    /* If _findsog <> 3 */
    if (CPLib.ne(_findsog,3)) {
      /* mcFam5.GoTop() */
      mcFam5.GoTop();
      /* While not(mcFam5.Eof()) */
      while ( ! (mcFam5.Eof())) {
        /* If mcFam5.MATCH <> '*' */
        if (CPLib.ne(mcFam5.row.MATCH,"*")) {
          /* If not(Empty(rowFamesitid.FADCODFIS)) */
          if ( ! (CPLib.Empty(rowFamesitid.FADCODFIS))) {
            /* If Len(LRTrim(rowFamesitid.FADCODFIS))=11 */
            if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(rowFamesitid.FADCODFIS)),11)) {
              /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim("***"+Right(LRTrim(mcFam5.CODFISC),8)) and Val(Left(mcFam5.TIPOSOG,1))=rowFamesitid.FADRUOLO */
              if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("***"+CPLib.Right(CPLib.LRTrim(mcFam5.row.CODFISC),8))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam5.CODINTER */
                _ndgsog = mcFam5.row.CODINTER;
                /* _dataini := mcFam5.DATAINI */
                _dataini = mcFam5.row.DATAINI;
                /* _datafin := mcFam5.DATAFINE */
                _datafin = mcFam5.row.DATAFINE;
                /* _origine := mcFam5.ORIGINE */
                _origine = mcFam5.row.ORIGINE;
                /* _ruolo := Left(mcFam5.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam5.row.TIPOSOG,1);
                /* ElseIf LRTrim(rowFamesitid.FADCODFIS)=LRTrim("***"+Right(LRTrim(mcFam5.CODFISC),8)) and Val(Left(mcFam5.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("***"+CPLib.Right(CPLib.LRTrim(mcFam5.row.CODFISC),8))) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam5.CODINTER */
                _ndgsog = mcFam5.row.CODINTER;
                /* _dataini := mcFam5.DATAINI */
                _dataini = mcFam5.row.DATAINI;
                /* _datafin := mcFam5.DATAFINE */
                _datafin = mcFam5.row.DATAFINE;
                /* _origine := mcFam5.ORIGINE */
                _origine = mcFam5.row.ORIGINE;
                /* _ruolo := Left(mcFam5.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam5.row.TIPOSOG,1);
              } // End If
            } else { // Else
              /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim('******'+Right(LRTrim(mcFam5.CODFISC),10)) and Val(Left(mcFam5.TIPOSOG,1))=rowFamesitid.FADRUOLO */
              if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("******"+CPLib.Right(CPLib.LRTrim(mcFam5.row.CODFISC),10))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam5.CODINTER */
                _ndgsog = mcFam5.row.CODINTER;
                /* _dataini := mcFam5.DATAINI */
                _dataini = mcFam5.row.DATAINI;
                /* _datafin := mcFam5.DATAFINE */
                _datafin = mcFam5.row.DATAFINE;
                /* _origine := mcFam5.ORIGINE */
                _origine = mcFam5.row.ORIGINE;
                /* _ruolo := Left(mcFam5.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam5.row.TIPOSOG,1);
                /* ElseIf LRTrim(rowFamesitid.FADCODFIS)=LRTrim('******'+Right(LRTrim(mcFam5.CODFISC),10)) and Val(Left(mcFam5.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("******"+CPLib.Right(CPLib.LRTrim(mcFam5.row.CODFISC),10))) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam5.CODINTER */
                _ndgsog = mcFam5.row.CODINTER;
                /* _dataini := mcFam5.DATAINI */
                _dataini = mcFam5.row.DATAINI;
                /* _datafin := mcFam5.DATAFINE */
                _datafin = mcFam5.row.DATAFINE;
                /* _origine := mcFam5.ORIGINE */
                _origine = mcFam5.row.ORIGINE;
                /* _ruolo := Left(mcFam5.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam5.row.TIPOSOG,1);
              } // End If
            } // End If
            /* If _findsog=1 or _findsog=2 */
            if (CPLib.eqr(_findsog,1) || CPLib.eqr(_findsog,2)) {
              /* If rowFamesitid.FADDATINI <> _dataini */
              if (CPLib.ne(rowFamesitid.FADDATINI,_dataini)) {
                /* _contaerr := _contaerr + 1 */
                _contaerr = CPLib.Round(_contaerr+1,0);
                /* If w_flgwrt='M' */
                if (CPLib.eqr(w_flgwrt,"M")) {
                  /* mcEsitiErr.AppendBlank() */
                  mcEsitiErr.AppendBlank();
                  /* mcEsitiErr.UNIQUECODE := _famcodice */
                  mcEsitiErr.row.UNIQUECODE = _famcodice;
                  /* mcEsitiErr.RAPPORTO := _rapporto */
                  mcEsitiErr.row.RAPPORTO = _rapporto;
                  /* mcEsitiErr.TIPORAP := 'R' */
                  mcEsitiErr.row.TIPORAP = "R";
                  /* mcEsitiErr.NDGSOG := _ndgsog */
                  mcEsitiErr.row.NDGSOG = _ndgsog;
                  /* mcEsitiErr.DATOMIT := 'Data Inizio Delega '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_dataini) */
                  mcEsitiErr.row.DATOMIT = "Data Inizio Delega "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_dataini);
                  /* mcEsitiErr.DATOAGE := 'Data Inizio Delega AGE: '+arfn_fdate(rowFamesitid.FADDATINI) */
                  mcEsitiErr.row.DATOAGE = "Data Inizio Delega AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI);
                  /* mcEsitiErr.ERRMSG := '* Data Inizio Delega non coincide (Ruolo: '+_ruolo+')' */
                  mcEsitiErr.row.ERRMSG = "* Data Inizio Delega non coincide (Ruolo: "+_ruolo+")";
                } else { // Else
                  // * --- Insert into tmp_esitierr from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_esitierr");
                  m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000366")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000366(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_dataini),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("* Data Inizio Delega non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
              } // End If
              /* If rowFamesitid.FADDATFIN <> _datafin and _datafin <= _maxope */
              if (CPLib.ne(rowFamesitid.FADDATFIN,_datafin) && CPLib.le(_datafin,_maxope)) {
                /* _contaerr := _contaerr + 1 */
                _contaerr = CPLib.Round(_contaerr+1,0);
                /* If w_flgwrt='M' */
                if (CPLib.eqr(w_flgwrt,"M")) {
                  /* mcEsitiErr.AppendBlank() */
                  mcEsitiErr.AppendBlank();
                  /* mcEsitiErr.UNIQUECODE := _famcodice */
                  mcEsitiErr.row.UNIQUECODE = _famcodice;
                  /* mcEsitiErr.RAPPORTO := _rapporto */
                  mcEsitiErr.row.RAPPORTO = _rapporto;
                  /* mcEsitiErr.TIPORAP := 'R' */
                  mcEsitiErr.row.TIPORAP = "R";
                  /* mcEsitiErr.NDGSOG := _ndgsog */
                  mcEsitiErr.row.NDGSOG = _ndgsog;
                  /* mcEsitiErr.DATOMIT := 'Data Fine Delega '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_datafin) */
                  mcEsitiErr.row.DATOMIT = "Data Fine Delega "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_datafin);
                  /* mcEsitiErr.DATOAGE := 'Data Fine ADelega GE: '+arfn_fdate(rowFamesitid.FADDATFIN) */
                  mcEsitiErr.row.DATOAGE = "Data Fine ADelega GE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN);
                  /* mcEsitiErr.ERRMSG := '* Data Fine Delega non coincide (Ruolo: '+_ruolo+')' */
                  mcEsitiErr.row.ERRMSG = "* Data Fine Delega non coincide (Ruolo: "+_ruolo+")";
                } else { // Else
                  // * --- Insert into tmp_esitierr from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_esitierr");
                  m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000372")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000372(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_datafin),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("* Data Fine Delega non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
              } // End If
            } // End If
          } else { // Else
            /* If Empty(rowFamesitid.FADSESSO) */
            if (CPLib.Empty(rowFamesitid.FADSESSO)) {
              /* _stringa1 := LRTrim(Left(mcFam5.RAGSOC,60))+"-"+LRTrim(mcFam5.SEDELEG)+"-"+LRTrim(mcFam5.PROVLEG) */
              _stringa1 = CPLib.LRTrim(CPLib.Left(mcFam5.row.RAGSOC,60))+"-"+CPLib.LRTrim(mcFam5.row.SEDELEG)+"-"+CPLib.LRTrim(mcFam5.row.PROVLEG);
              /* _stringa2 := LRTrim(rowFamesitid.FADCOGRAG)+"-"+LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
              _stringa2 = CPLib.LRTrim(rowFamesitid.FADCOGRAG)+"-"+CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
              /* If _stringa1 = _stringa2 and Val(Left(mcFam5.TIPOSOG,1))=rowFamesitid.FADRUOLO */
              if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam5.CODINTER */
                _ndgsog = mcFam5.row.CODINTER;
                /* _dataini := mcFam5.DATAINI */
                _dataini = mcFam5.row.DATAINI;
                /* _datafin := mcFam5.DATAFINE */
                _datafin = mcFam5.row.DATAFINE;
                /* _origine := mcFam5.ORIGINE */
                _origine = mcFam5.row.ORIGINE;
                /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam5.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam5.CODINTER */
                _ndgsog = mcFam5.row.CODINTER;
                /* _dataini := mcFam5.DATAINI */
                _dataini = mcFam5.row.DATAINI;
                /* _datafin := mcFam5.DATAFINE */
                _datafin = mcFam5.row.DATAFINE;
                /* _origine := mcFam5.ORIGINE */
                _origine = mcFam5.row.ORIGINE;
                /* _ruolo := Left(mcFam5.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam5.row.TIPOSOG,1);
              } // End If
              /* If _findsog=0 */
              if (CPLib.eqr(_findsog,0)) {
                /* _stringa1 := LRTrim(arfn_agechar(Left(mcFam5.RAGSOC,60),' '))+"-"+LRTrim(arfn_agechar(mcFam5.SEDELEG,' '))+"-"+LRTrim(mcFam5.PROVLEG) */
                _stringa1 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Left(mcFam5.row.RAGSOC,60)," "))+"-"+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcFam5.row.SEDELEG," "))+"-"+CPLib.LRTrim(mcFam5.row.PROVLEG);
                /* _stringa2 := LRTrim(arfn_agechar(rowFamesitid.FADCOGRAG,' '))+"-"+LRTrim(arfn_agechar(rowFamesitid.FADNASSEL,' '))+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
                _stringa2 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADCOGRAG," "))+"-"+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADNASSEL," "))+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
                /* If _stringa1 = _stringa2 and Val(Left(mcFam5.TIPOSOG,1))=rowFamesitid.FADRUOLO */
                if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 1 */
                  _findsog = CPLib.Round(1,0);
                  /* _ndgsog := mcFam5.CODINTER */
                  _ndgsog = mcFam5.row.CODINTER;
                  /* _dataini := mcFam5.DATAINI */
                  _dataini = mcFam5.row.DATAINI;
                  /* _datafin := mcFam5.DATAFINE */
                  _datafin = mcFam5.row.DATAFINE;
                  /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam5.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
                } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 2 */
                  _findsog = CPLib.Round(2,0);
                  /* _ndgsog := mcFam5.CODINTER */
                  _ndgsog = mcFam5.row.CODINTER;
                  /* _dataini := mcFam5.DATAINI */
                  _dataini = mcFam5.row.DATAINI;
                  /* _datafin := mcFam5.DATAFINE */
                  _datafin = mcFam5.row.DATAFINE;
                  /* _ruolo := Left(mcFam5.TIPOSOG,1) */
                  _ruolo = CPLib.Left(mcFam5.row.TIPOSOG,1);
                } // End If
              } // End If
            } else { // Else
              /* _stringa1 := LRTrim(mcFam5.LUONAS)+"-"+LRTrim(mcFam5.PROVNAS)+"-"+DateToChar(mcFam5.DATNAS)+"-"+iif(mcFam5.SESSO='1','M',iif(mcFam5.SESSO='2','F','')) */
              _stringa1 = CPLib.LRTrim(mcFam5.row.LUONAS)+"-"+CPLib.LRTrim(mcFam5.row.PROVNAS)+"-"+CPLib.DateToChar(mcFam5.row.DATNAS)+"-"+(CPLib.eqr(mcFam5.row.SESSO,"1")?"M":(CPLib.eqr(mcFam5.row.SESSO,"2")?"F":""));
              /* _stringa2 := LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO */
              _stringa2 = CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO;
              /* If _stringa1 = _stringa2 and Val(Left(mcFam5.TIPOSOG,1)) = rowFamesitid.FADRUOLO */
              if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam5.CODINTER */
                _ndgsog = mcFam5.row.CODINTER;
                /* _dataini := mcFam5.DATAINI */
                _dataini = mcFam5.row.DATAINI;
                /* _datafin := mcFam5.DATAFINE */
                _datafin = mcFam5.row.DATAFINE;
                /* _origine := mcFam5.ORIGINE */
                _origine = mcFam5.row.ORIGINE;
                /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam5.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam5.CODINTER */
                _ndgsog = mcFam5.row.CODINTER;
                /* _dataini := mcFam5.DATAINI */
                _dataini = mcFam5.row.DATAINI;
                /* _datafin := mcFam5.DATAFINE */
                _datafin = mcFam5.row.DATAFINE;
                /* _origine := mcFam5.ORIGINE */
                _origine = mcFam5.row.ORIGINE;
                /* _ruolo := Left(mcFam5.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam5.row.TIPOSOG,1);
              } // End If
              /* If _findsog=0 */
              if (CPLib.eqr(_findsog,0)) {
                /* _stringa1 := LRTrim(arfn_agechar(mcFam5.LUONAS,' '))+"-"+LRTrim(mcFam5.PROVNAS)+"-"+DateToChar(mcFam5.DATNAS)+"-"+iif(mcFam5.SESSO='1','M',iif(mcFam5.SESSO='2','F','')) */
                _stringa1 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcFam5.row.LUONAS," "))+"-"+CPLib.LRTrim(mcFam5.row.PROVNAS)+"-"+CPLib.DateToChar(mcFam5.row.DATNAS)+"-"+(CPLib.eqr(mcFam5.row.SESSO,"1")?"M":(CPLib.eqr(mcFam5.row.SESSO,"2")?"F":""));
                /* _stringa2 := LRTrim(arfn_agechar(rowFamesitid.FADNASSEL,' '))+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO */
                _stringa2 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADNASSEL," "))+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO;
                /* If _stringa1 = _stringa2 and Val(Left(mcFam5.TIPOSOG,1)) = rowFamesitid.FADRUOLO */
                if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 1 */
                  _findsog = CPLib.Round(1,0);
                  /* _ndgsog := mcFam5.CODINTER */
                  _ndgsog = mcFam5.row.CODINTER;
                  /* _dataini := mcFam5.DATAINI */
                  _dataini = mcFam5.row.DATAINI;
                  /* _datafin := mcFam5.DATAFINE */
                  _datafin = mcFam5.row.DATAFINE;
                  /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam5.TIPOSOG,1)) <> rowFamesitid.FADRUOLO */
                } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam5.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 2 */
                  _findsog = CPLib.Round(2,0);
                  /* _ndgsog := mcFam5.CODINTER */
                  _ndgsog = mcFam5.row.CODINTER;
                  /* _dataini := mcFam5.DATAINI */
                  _dataini = mcFam5.row.DATAINI;
                  /* _datafin := mcFam5.DATAFINE */
                  _datafin = mcFam5.row.DATAFINE;
                  /* _ruolo := Left(mcFam5.TIPOSOG,1) */
                  _ruolo = CPLib.Left(mcFam5.row.TIPOSOG,1);
                } // End If
              } // End If
            } // End If
            /* If _findsog =1 or _findsog=2 */
            if (CPLib.eqr(_findsog,1) || CPLib.eqr(_findsog,2)) {
              /* If _stringa1=_stringa2 */
              if (CPLib.eqr(_stringa1,_stringa2)) {
                /* If rowFamesitid.FADDATINI <> _dataini */
                if (CPLib.ne(rowFamesitid.FADDATINI,_dataini)) {
                  /* _contaerr := _contaerr + 1 */
                  _contaerr = CPLib.Round(_contaerr+1,0);
                  /* If w_flgwrt='M' */
                  if (CPLib.eqr(w_flgwrt,"M")) {
                    /* mcEsitiErr.AppendBlank() */
                    mcEsitiErr.AppendBlank();
                    /* mcEsitiErr.UNIQUECODE := _famcodice */
                    mcEsitiErr.row.UNIQUECODE = _famcodice;
                    /* mcEsitiErr.RAPPORTO := _rapporto */
                    mcEsitiErr.row.RAPPORTO = _rapporto;
                    /* mcEsitiErr.TIPORAP := 'R' */
                    mcEsitiErr.row.TIPORAP = "R";
                    /* mcEsitiErr.NDGSOG := _ndgsog */
                    mcEsitiErr.row.NDGSOG = _ndgsog;
                    /* mcEsitiErr.DATOMIT := 'Data Inizio Delega '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_dataini) */
                    mcEsitiErr.row.DATOMIT = "Data Inizio Delega "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_dataini);
                    /* mcEsitiErr.DATOAGE := 'Data Inizio Delega AGE: '+arfn_fdate(rowFamesitid.FADDATINI) */
                    mcEsitiErr.row.DATOAGE = "Data Inizio Delega AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI);
                    /* mcEsitiErr.ERRMSG := '* Data Inizio Delega non coincide (Ruolo: '+_ruolo+')' */
                    mcEsitiErr.row.ERRMSG = "* Data Inizio Delega non coincide (Ruolo: "+_ruolo+")";
                  } else { // Else
                    // * --- Insert into tmp_esitierr from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_esitierr");
                    m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000003B7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000003B7(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio MIT: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataini),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("* Data Inizio Delega non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                } // End If
                /* If rowFamesitid.FADDATFIN <> _datafin and _datafin <= _maxope */
                if (CPLib.ne(rowFamesitid.FADDATFIN,_datafin) && CPLib.le(_datafin,_maxope)) {
                  /* _contaerr := _contaerr + 1 */
                  _contaerr = CPLib.Round(_contaerr+1,0);
                  /* If w_flgwrt='M' */
                  if (CPLib.eqr(w_flgwrt,"M")) {
                    /* mcEsitiErr.AppendBlank() */
                    mcEsitiErr.AppendBlank();
                    /* mcEsitiErr.UNIQUECODE := _famcodice */
                    mcEsitiErr.row.UNIQUECODE = _famcodice;
                    /* mcEsitiErr.RAPPORTO := _rapporto */
                    mcEsitiErr.row.RAPPORTO = _rapporto;
                    /* mcEsitiErr.TIPORAP := 'R' */
                    mcEsitiErr.row.TIPORAP = "R";
                    /* mcEsitiErr.NDGSOG := _ndgsog */
                    mcEsitiErr.row.NDGSOG = _ndgsog;
                    /* mcEsitiErr.DATOMIT := 'Data Fine Delega '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_datafin) */
                    mcEsitiErr.row.DATOMIT = "Data Fine Delega "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_datafin);
                    /* mcEsitiErr.DATOAGE := 'Data Fine Delega AGE: '+arfn_fdate(rowFamesitid.FADDATFIN) */
                    mcEsitiErr.row.DATOAGE = "Data Fine Delega AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN);
                    /* mcEsitiErr.ERRMSG := '* Data Fine Delega non coincide (Ruolo: '+_ruolo+')' */
                    mcEsitiErr.row.ERRMSG = "* Data Fine Delega non coincide (Ruolo: "+_ruolo+")";
                  } else { // Else
                    // * --- Insert into tmp_esitierr from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_esitierr");
                    m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000003C3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000003C3(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine MIT: "+arfn_fdateR.Make(m_Ctx,this).Run(_datafin),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("* Data Fine Delega non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                } // End If
              } else { // Else
                /* _contaerr := _contaerr + 1 */
                _contaerr = CPLib.Round(_contaerr+1,0);
                /* If w_flgwrt='M' */
                if (CPLib.eqr(w_flgwrt,"M")) {
                  /* mcEsitiErr.AppendBlank() */
                  mcEsitiErr.AppendBlank();
                  /* mcEsitiErr.UNIQUECODE := _famcodice */
                  mcEsitiErr.row.UNIQUECODE = _famcodice;
                  /* mcEsitiErr.RAPPORTO := _rapporto */
                  mcEsitiErr.row.RAPPORTO = _rapporto;
                  /* mcEsitiErr.TIPORAP := 'R' */
                  mcEsitiErr.row.TIPORAP = "R";
                  /* mcEsitiErr.NDGSOG := _ndgsog */
                  mcEsitiErr.row.NDGSOG = _ndgsog;
                  /* mcEsitiErr.DATOMIT := 'Dati MIT: '+_stringa1 */
                  mcEsitiErr.row.DATOMIT = "Dati MIT: "+_stringa1;
                  /* mcEsitiErr.DATOAGE := 'Dati AGE: '+_stringa2 */
                  mcEsitiErr.row.DATOAGE = "Dati AGE: "+_stringa2;
                  /* mcEsitiErr.ERRMSG := '* Dati Soggetto Non Coincidono' */
                  mcEsitiErr.row.ERRMSG = "* Dati Soggetto Non Coincidono";
                } else { // Else
                  // * --- Insert into tmp_esitierr from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_esitierr");
                  m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000003CE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000003CE(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Dati MIT: "+_stringa1,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Dati AGE: "+_stringa2,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("* Dati Soggetto Non Coincidono","?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
              } // End If
            } // End If
          } // End If
          /* If _findsog=1 or _findsog=2 */
          if (CPLib.eqr(_findsog,1) || CPLib.eqr(_findsog,2)) {
            /* mcFam5.MATCH := '*' */
            mcFam5.row.MATCH = "*";
            /* mcFam5.SaveRow() */
            mcFam5.SaveRow();
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        } // End If
        /* mcFam5.Skip() */
        mcFam5.Skip();
      } // End While
      /* If _findsog=2 */
      if (CPLib.eqr(_findsog,2)) {
        /* _contaerr := _contaerr + 1 */
        _contaerr = CPLib.Round(_contaerr+1,0);
        /* _datiage := 'Dati AGE: C.F. '+LRTrim(rowFamesitid.FADCODFIS) + ' - Ruolo Age: ' +Str(rowFamesitid.FADRUOLO,1,0) */
        _datiage = "Dati AGE: C.F. "+CPLib.LRTrim(rowFamesitid.FADCODFIS)+" - Ruolo Age: "+CPLib.Str(rowFamesitid.FADRUOLO,1,0);
        /* _errore := '* Ruolo intestatario non corrispondente' */
        _errore = "* Ruolo intestatario non corrispondente";
        /* If w_flgwrt='M' */
        if (CPLib.eqr(w_flgwrt,"M")) {
          /* mcEsitiErr.AppendBlank() */
          mcEsitiErr.AppendBlank();
          /* mcEsitiErr.UNIQUECODE := _famcodice */
          mcEsitiErr.row.UNIQUECODE = _famcodice;
          /* mcEsitiErr.RAPPORTO := _rapporto */
          mcEsitiErr.row.RAPPORTO = _rapporto;
          /* mcEsitiErr.TIPORAP := 'R' */
          mcEsitiErr.row.TIPORAP = "R";
          /* mcEsitiErr.NDGSOG := LRTrim(rowFamesitid.FADCODFIS) */
          mcEsitiErr.row.NDGSOG = CPLib.LRTrim(rowFamesitid.FADCODFIS);
          /* mcEsitiErr.DATOMIT := 'Dati MIT: Ruolo ' + _ruolo */
          mcEsitiErr.row.DATOMIT = "Dati MIT: Ruolo "+_ruolo;
          /* mcEsitiErr.DATOAGE := _datiage */
          mcEsitiErr.row.DATOAGE = _datiage;
          /* mcEsitiErr.ERRMSG := _errore */
          mcEsitiErr.row.ERRMSG = _errore;
        } else { // Else
          // * --- Insert into tmp_esitierr from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_esitierr");
          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000003E1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000003E1(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowFamesitid.FADCODFIS),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Dati MIT: Ruolo "+_ruolo,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datiage,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
      } // End If
      /* If _findsog=0 */
      if (CPLib.eqr(_findsog,0)) {
        /* _contaerr := _contaerr + 1 */
        _contaerr = CPLib.Round(_contaerr+1,0);
        /* If not(Empty(rowFamesitid.FADCODFIS)) */
        if ( ! (CPLib.Empty(rowFamesitid.FADCODFIS))) {
          /* _datiage := 'Dati AGE: C.F. '+LRTrim(rowFamesitid.FADCODFIS) */
          _datiage = "Dati AGE: C.F. "+CPLib.LRTrim(rowFamesitid.FADCODFIS);
          /* _errore := '* Codice Fiscale Soggetto non presente in AUI/AGE per il ruolo ('+rowFamesitid.FADRUOLO+') indicato' */
          _errore = "* Codice Fiscale Soggetto non presente in AUI/AGE per il ruolo ("+rowFamesitid.FADRUOLO+") indicato";
        } else { // Else
          /* If not(Empty(LRTrim(rowFamesitid.FADCOGRAG))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(rowFamesitid.FADCOGRAG)))) {
            /* _datiage := 'Dati AGE: Nominativo '+LRTrim(rowFamesitid.FADCOGRAG)+"-"+LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
            _datiage = "Dati AGE: Nominativo "+CPLib.LRTrim(rowFamesitid.FADCOGRAG)+"-"+CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
          } else { // Else
            /* _datiage := 'Dati AGE: Soggetto '+LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO */
            _datiage = "Dati AGE: Soggetto "+CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO;
          } // End If
          /* _errore := '* Nominativo non presente in AUI/AGE per il ruolo ('+rowFamesitid.FADRUOLO+') indicato'+iif(not(Empty(_datafinrap)),NL+" (Rapporto chiuso il "+arfn_fdate(_datafinrap)+")","") */
          _errore = "* Nominativo non presente in AUI/AGE per il ruolo ("+rowFamesitid.FADRUOLO+") indicato"+( ! (CPLib.Empty(_datafinrap))?"\n"+" (Rapporto chiuso il "+arfn_fdateR.Make(m_Ctx,this).Run(_datafinrap)+")":"");
        } // End If
        /* If w_flgwrt='M' */
        if (CPLib.eqr(w_flgwrt,"M")) {
          /* mcEsitiErr.AppendBlank() */
          mcEsitiErr.AppendBlank();
          /* mcEsitiErr.UNIQUECODE := _famcodice */
          mcEsitiErr.row.UNIQUECODE = _famcodice;
          /* mcEsitiErr.RAPPORTO := _rapporto */
          mcEsitiErr.row.RAPPORTO = _rapporto;
          /* mcEsitiErr.TIPORAP := 'R' */
          mcEsitiErr.row.TIPORAP = "R";
          /* mcEsitiErr.NDGSOG := rowFamesitid.FADCODFIS */
          mcEsitiErr.row.NDGSOG = rowFamesitid.FADCODFIS;
          /* mcEsitiErr.DATOMIT := '' */
          mcEsitiErr.row.DATOMIT = "";
          /* mcEsitiErr.DATOAGE := _datiage */
          mcEsitiErr.row.DATOAGE = _datiage;
          /* mcEsitiErr.ERRMSG := _errore */
          mcEsitiErr.row.ERRMSG = _errore;
        } else { // Else
          // * --- Insert into tmp_esitierr from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_esitierr");
          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000003F4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000003F4(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowFamesitid.FADCODFIS,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datiage,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
      } // End If
    } // End If
  }
  void Pag_4() throws Exception {
    /* Esamina i titolari */
    /* mcFam7.GoTop() */
    mcFam7.GoTop();
    /* While not(mcFam7.Eof()) */
    while ( ! (mcFam7.Eof())) {
      /* _findsog := 0 */
      _findsog = CPLib.Round(0,0);
      /* gMsgImp := 'Confronto soggetto: '+rowFamesitid.FADCODFIS+" con soggetto: "+mcFam7.CODFISC */
      gMsgImp = "Confronto soggetto: "+rowFamesitid.FADCODFIS+" con soggetto: "+mcFam7.row.CODFISC;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If mcFam7.MATCH <> '*' */
      if (CPLib.ne(mcFam7.row.MATCH,"*")) {
        /* If not(Empty(rowFamesitid.FADCODFIS)) */
        if ( ! (CPLib.Empty(rowFamesitid.FADCODFIS))) {
          /* If Len(LRTrim(rowFamesitid.FADCODFIS))=11 */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(rowFamesitid.FADCODFIS)),11)) {
            /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim("***"+Right(LRTrim(mcFam7.CODFISC),8)) and Val(Left(mcFam7.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam7.DATAINI and iif(mcFam7.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam7.DATAFINE,True) */
            if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("***"+CPLib.Right(CPLib.LRTrim(mcFam7.row.CODFISC),8))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam7.row.DATAINI) && (CPLib.le(mcFam7.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam7.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } else { // Else
            /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim("******"+Right(LRTrim(mcFam7.CODFISC),10)) and Val(Left(mcFam7.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam7.DATAINI and iif(mcFam7.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam7.DATAFINE,True) */
            if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("******"+CPLib.Right(CPLib.LRTrim(mcFam7.row.CODFISC),10))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam7.row.DATAINI) && (CPLib.le(mcFam7.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam7.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } // End If
        } else { // Else
          /* If Empty(rowFamesitid.FADSESSO) */
          if (CPLib.Empty(rowFamesitid.FADSESSO)) {
            /* _stringa1 := LRTrim(arfn_agechar(Left(mcFam7.RAGSOC,60)," "))+"-"+LRTrim(mcFam7.SEDELEG)+"-"+LRTrim(mcFam7.PROVLEG) */
            _stringa1 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Left(mcFam7.row.RAGSOC,60)," "))+"-"+CPLib.LRTrim(mcFam7.row.SEDELEG)+"-"+CPLib.LRTrim(mcFam7.row.PROVLEG);
            /* _stringa2 := LRTrim(arfn_agechar(rowFamesitid.FADCOGRAG," "))+"-"+LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
            _stringa2 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADCOGRAG," "))+"-"+CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
            /* If _stringa1 = _stringa2 and Val(Left(mcFam7.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam7.DATAINI and iif(mcFam7.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam7.DATAFINE,True) */
            if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam7.row.DATAINI) && (CPLib.le(mcFam7.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam7.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } else { // Else
            /* _stringa1 := arfn_agechar(LRTrim(mcFam7.LUONAS)," ")+"-"+LRTrim(mcFam7.PROVNAS)+"-"+DateToChar(mcFam7.DATNAS)+"-"+iif(mcFam7.SESSO='1','M',iif(mcFam7.SESSO='2','F','')) */
            _stringa1 = arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(mcFam7.row.LUONAS)," ")+"-"+CPLib.LRTrim(mcFam7.row.PROVNAS)+"-"+CPLib.DateToChar(mcFam7.row.DATNAS)+"-"+(CPLib.eqr(mcFam7.row.SESSO,"1")?"M":(CPLib.eqr(mcFam7.row.SESSO,"2")?"F":""));
            /* _stringa2 := arfn_agechar(LRTrim(rowFamesitid.FADNASSEL)," ")+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO */
            _stringa2 = arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(rowFamesitid.FADNASSEL)," ")+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO;
            /* If _stringa1 = _stringa2 and Val(Left(mcFam7.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam7.DATAINI and iif(mcFam7.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam7.DATAFINE,True) */
            if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam7.row.DATAINI) && (CPLib.le(mcFam7.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam7.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } // End If
        } // End If
        /* If _findsog=3 */
        if (CPLib.eqr(_findsog,3)) {
          /* mcFam7.MATCH := '*' */
          mcFam7.row.MATCH = "*";
          /* mcFam7.SaveRow() */
          mcFam7.SaveRow();
          // Exit Loop
          if (true) {
            break;
          }
        } // End If
      } // End If
      /* mcFam7.Skip() */
      mcFam7.Skip();
    } // End While
    /* If _findsog <> 3 */
    if (CPLib.ne(_findsog,3)) {
      /* mcFam7.GoTop() */
      mcFam7.GoTop();
      /* While not(mcFam7.Eof()) */
      while ( ! (mcFam7.Eof())) {
        /* If mcFam7.MATCH <> '*' */
        if (CPLib.ne(mcFam7.row.MATCH,"*")) {
          /* If not(Empty(rowFamesitid.FADCODFIS)) */
          if ( ! (CPLib.Empty(rowFamesitid.FADCODFIS))) {
            /* If Len(LRTrim(rowFamesitid.FADCODFIS))=11 */
            if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(rowFamesitid.FADCODFIS)),11)) {
              /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim("***"+Right(LRTrim(mcFam7.CODFISC),8)) and Val(Left(mcFam7.TIPOSOG,1))=rowFamesitid.FADRUOLO */
              if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("***"+CPLib.Right(CPLib.LRTrim(mcFam7.row.CODFISC),8))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam7.CODINTER */
                _ndgsog = mcFam7.row.CODINTER;
                /* _dataini := mcFam7.DATAINI */
                _dataini = mcFam7.row.DATAINI;
                /* _datafin := mcFam7.DATAFINE */
                _datafin = mcFam7.row.DATAFINE;
                /* _origine := mcFam7.ORIGINE */
                _origine = mcFam7.row.ORIGINE;
                /* _ruolo := Left(mcFam7.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam7.row.TIPOSOG,1);
                /* ElseIf LRTrim(rowFamesitid.FADCODFIS)=LRTrim("***"+Right(LRTrim(mcFam7.CODFISC),8)) and Val(Left(mcFam7.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("***"+CPLib.Right(CPLib.LRTrim(mcFam7.row.CODFISC),8))) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam7.CODINTER */
                _ndgsog = mcFam7.row.CODINTER;
                /* _dataini := mcFam7.DATAINI */
                _dataini = mcFam7.row.DATAINI;
                /* _datafin := mcFam7.DATAFINE */
                _datafin = mcFam7.row.DATAFINE;
                /* _origine := mcFam7.ORIGINE */
                _origine = mcFam7.row.ORIGINE;
                /* _ruolo := Left(mcFam7.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam7.row.TIPOSOG,1);
              } // End If
            } else { // Else
              /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim('******'+Right(LRTrim(mcFam7.CODFISC),10)) and Val(Left(mcFam7.TIPOSOG,1))=rowFamesitid.FADRUOLO */
              if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("******"+CPLib.Right(CPLib.LRTrim(mcFam7.row.CODFISC),10))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam7.CODINTER */
                _ndgsog = mcFam7.row.CODINTER;
                /* _dataini := mcFam7.DATAINI */
                _dataini = mcFam7.row.DATAINI;
                /* _datafin := mcFam7.DATAFINE */
                _datafin = mcFam7.row.DATAFINE;
                /* _origine := mcFam7.ORIGINE */
                _origine = mcFam7.row.ORIGINE;
                /* _ruolo := Left(mcFam7.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam7.row.TIPOSOG,1);
                /* ElseIf LRTrim(rowFamesitid.FADCODFIS)=LRTrim('******'+Right(LRTrim(mcFam7.CODFISC),10)) and Val(Left(mcFam7.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("******"+CPLib.Right(CPLib.LRTrim(mcFam7.row.CODFISC),10))) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam7.CODINTER */
                _ndgsog = mcFam7.row.CODINTER;
                /* _dataini := mcFam7.DATAINI */
                _dataini = mcFam7.row.DATAINI;
                /* _datafin := mcFam7.DATAFINE */
                _datafin = mcFam7.row.DATAFINE;
                /* _origine := mcFam7.ORIGINE */
                _origine = mcFam7.row.ORIGINE;
                /* _ruolo := Left(mcFam7.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam7.row.TIPOSOG,1);
              } // End If
            } // End If
            /* If _findsog=1 or _findsog=2 */
            if (CPLib.eqr(_findsog,1) || CPLib.eqr(_findsog,2)) {
              /* If rowFamesitid.FADDATINI <> _dataini */
              if (CPLib.ne(rowFamesitid.FADDATINI,_dataini)) {
                /* _contaerr := _contaerr + 1 */
                _contaerr = CPLib.Round(_contaerr+1,0);
                /* If w_flgwrt='M' */
                if (CPLib.eqr(w_flgwrt,"M")) {
                  /* mcEsitiErr.AppendBlank() */
                  mcEsitiErr.AppendBlank();
                  /* mcEsitiErr.UNIQUECODE := _famcodice */
                  mcEsitiErr.row.UNIQUECODE = _famcodice;
                  /* mcEsitiErr.RAPPORTO := _rapporto */
                  mcEsitiErr.row.RAPPORTO = _rapporto;
                  /* mcEsitiErr.TIPORAP := 'R' */
                  mcEsitiErr.row.TIPORAP = "R";
                  /* mcEsitiErr.NDGSOG := _ndgsog */
                  mcEsitiErr.row.NDGSOG = _ndgsog;
                  /* mcEsitiErr.DATOMIT := 'Data Inizio Legame '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_dataini) */
                  mcEsitiErr.row.DATOMIT = "Data Inizio Legame "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_dataini);
                  /* mcEsitiErr.DATOAGE := 'Data Inizio Legame AGE: '+arfn_fdate(rowFamesitid.FADDATINI) */
                  mcEsitiErr.row.DATOAGE = "Data Inizio Legame AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI);
                  /* mcEsitiErr.ERRMSG := '* Data Inizio Legame non coincide (Ruolo: '+_ruolo+')' */
                  mcEsitiErr.row.ERRMSG = "* Data Inizio Legame non coincide (Ruolo: "+_ruolo+")";
                } else { // Else
                  // * --- Insert into tmp_esitierr from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_esitierr");
                  m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"0000043B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000043B(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_dataini),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("* Data Inizio Legame non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
              } // End If
              /* If rowFamesitid.FADDATFIN <> _datafin and _datafin <= _maxope */
              if (CPLib.ne(rowFamesitid.FADDATFIN,_datafin) && CPLib.le(_datafin,_maxope)) {
                /* _contaerr := _contaerr + 1 */
                _contaerr = CPLib.Round(_contaerr+1,0);
                /* If w_flgwrt='M' */
                if (CPLib.eqr(w_flgwrt,"M")) {
                  /* mcEsitiErr.AppendBlank() */
                  mcEsitiErr.AppendBlank();
                  /* mcEsitiErr.UNIQUECODE := _famcodice */
                  mcEsitiErr.row.UNIQUECODE = _famcodice;
                  /* mcEsitiErr.RAPPORTO := _rapporto */
                  mcEsitiErr.row.RAPPORTO = _rapporto;
                  /* mcEsitiErr.TIPORAP := 'R' */
                  mcEsitiErr.row.TIPORAP = "R";
                  /* mcEsitiErr.NDGSOG := _ndgsog */
                  mcEsitiErr.row.NDGSOG = _ndgsog;
                  /* mcEsitiErr.DATOMIT := 'Data Fine Legame '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_datafin) */
                  mcEsitiErr.row.DATOMIT = "Data Fine Legame "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_datafin);
                  /* mcEsitiErr.DATOAGE := 'Data Fine Legame AGE: '+arfn_fdate(rowFamesitid.FADDATFIN) */
                  mcEsitiErr.row.DATOAGE = "Data Fine Legame AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN);
                  /* mcEsitiErr.ERRMSG := '* Data Fine Legame non coincide (Ruolo: '+_ruolo+')' */
                  mcEsitiErr.row.ERRMSG = "* Data Fine Legame non coincide (Ruolo: "+_ruolo+")";
                } else { // Else
                  // * --- Insert into tmp_esitierr from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_esitierr");
                  m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000447")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000447(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_datafin),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("* Data Fine Legame non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
              } // End If
            } // End If
          } else { // Else
            /* If Empty(rowFamesitid.FADSESSO) */
            if (CPLib.Empty(rowFamesitid.FADSESSO)) {
              /* _stringa1 := LRTrim(Left(mcFam7.RAGSOC,60))+"-"+LRTrim(mcFam7.SEDELEG)+"-"+LRTrim(mcFam7.PROVLEG) */
              _stringa1 = CPLib.LRTrim(CPLib.Left(mcFam7.row.RAGSOC,60))+"-"+CPLib.LRTrim(mcFam7.row.SEDELEG)+"-"+CPLib.LRTrim(mcFam7.row.PROVLEG);
              /* _stringa2 := LRTrim(rowFamesitid.FADCOGRAG)+"-"+LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
              _stringa2 = CPLib.LRTrim(rowFamesitid.FADCOGRAG)+"-"+CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
              /* If _stringa1 = _stringa2 and Val(Left(mcFam7.TIPOSOG,1))=rowFamesitid.FADRUOLO */
              if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam7.CODINTER */
                _ndgsog = mcFam7.row.CODINTER;
                /* _dataini := mcFam7.DATAINI */
                _dataini = mcFam7.row.DATAINI;
                /* _datafin := mcFam7.DATAFINE */
                _datafin = mcFam7.row.DATAFINE;
                /* _origine := mcFam7.ORIGINE */
                _origine = mcFam7.row.ORIGINE;
                /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam7.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam7.CODINTER */
                _ndgsog = mcFam7.row.CODINTER;
                /* _dataini := mcFam7.DATAINI */
                _dataini = mcFam7.row.DATAINI;
                /* _datafin := mcFam7.DATAFINE */
                _datafin = mcFam7.row.DATAFINE;
                /* _origine := mcFam7.ORIGINE */
                _origine = mcFam7.row.ORIGINE;
                /* _ruolo := Left(mcFam7.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam7.row.TIPOSOG,1);
              } // End If
              /* If _findsog=0 */
              if (CPLib.eqr(_findsog,0)) {
                /* _stringa1 := LRTrim(arfn_agechar(Left(mcFam7.RAGSOC,60),' '))+"-"+LRTrim(arfn_agechar(mcFam7.SEDELEG,' '))+"-"+LRTrim(mcFam7.PROVLEG) */
                _stringa1 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Left(mcFam7.row.RAGSOC,60)," "))+"-"+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcFam7.row.SEDELEG," "))+"-"+CPLib.LRTrim(mcFam7.row.PROVLEG);
                /* _stringa2 := LRTrim(arfn_agechar(rowFamesitid.FADCOGRAG,' '))+"-"+LRTrim(arfn_agechar(rowFamesitid.FADNASSEL,' '))+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
                _stringa2 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADCOGRAG," "))+"-"+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADNASSEL," "))+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
                /* If _stringa1 = _stringa2 and Val(Left(mcFam7.TIPOSOG,1))=rowFamesitid.FADRUOLO */
                if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 1 */
                  _findsog = CPLib.Round(1,0);
                  /* _ndgsog := mcFam7.CODINTER */
                  _ndgsog = mcFam7.row.CODINTER;
                  /* _dataini := mcFam7.DATAINI */
                  _dataini = mcFam7.row.DATAINI;
                  /* _datafin := mcFam7.DATAFINE */
                  _datafin = mcFam7.row.DATAFINE;
                  /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam7.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
                } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 2 */
                  _findsog = CPLib.Round(2,0);
                  /* _ndgsog := mcFam7.CODINTER */
                  _ndgsog = mcFam7.row.CODINTER;
                  /* _dataini := mcFam7.DATAINI */
                  _dataini = mcFam7.row.DATAINI;
                  /* _datafin := mcFam7.DATAFINE */
                  _datafin = mcFam7.row.DATAFINE;
                  /* _ruolo := Left(mcFam7.TIPOSOG,1) */
                  _ruolo = CPLib.Left(mcFam7.row.TIPOSOG,1);
                } // End If
              } // End If
            } else { // Else
              /* _stringa1 := LRTrim(mcFam7.LUONAS)+"-"+LRTrim(mcFam7.PROVNAS)+"-"+DateToChar(mcFam7.DATNAS)+"-"+iif(mcFam7.SESSO='1','M',iif(mcFam7.SESSO='2','F','')) */
              _stringa1 = CPLib.LRTrim(mcFam7.row.LUONAS)+"-"+CPLib.LRTrim(mcFam7.row.PROVNAS)+"-"+CPLib.DateToChar(mcFam7.row.DATNAS)+"-"+(CPLib.eqr(mcFam7.row.SESSO,"1")?"M":(CPLib.eqr(mcFam7.row.SESSO,"2")?"F":""));
              /* _stringa2 := LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO */
              _stringa2 = CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO;
              /* If _stringa1 = _stringa2 and Val(Left(mcFam7.TIPOSOG,1)) = rowFamesitid.FADRUOLO */
              if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam7.CODINTER */
                _ndgsog = mcFam7.row.CODINTER;
                /* _dataini := mcFam7.DATAINI */
                _dataini = mcFam7.row.DATAINI;
                /* _datafin := mcFam7.DATAFINE */
                _datafin = mcFam7.row.DATAFINE;
                /* _origine := mcFam7.ORIGINE */
                _origine = mcFam7.row.ORIGINE;
                /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam7.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam7.CODINTER */
                _ndgsog = mcFam7.row.CODINTER;
                /* _dataini := mcFam7.DATAINI */
                _dataini = mcFam7.row.DATAINI;
                /* _datafin := mcFam7.DATAFINE */
                _datafin = mcFam7.row.DATAFINE;
                /* _origine := mcFam7.ORIGINE */
                _origine = mcFam7.row.ORIGINE;
                /* _ruolo := Left(mcFam7.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam7.row.TIPOSOG,1);
              } // End If
              /* If _findsog=0 */
              if (CPLib.eqr(_findsog,0)) {
                /* _stringa1 := LRTrim(arfn_agechar(mcFam7.LUONAS,' '))+"-"+LRTrim(mcFam7.PROVNAS)+"-"+DateToChar(mcFam7.DATNAS)+"-"+iif(mcFam7.SESSO='1','M',iif(mcFam7.SESSO='2','F','')) */
                _stringa1 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcFam7.row.LUONAS," "))+"-"+CPLib.LRTrim(mcFam7.row.PROVNAS)+"-"+CPLib.DateToChar(mcFam7.row.DATNAS)+"-"+(CPLib.eqr(mcFam7.row.SESSO,"1")?"M":(CPLib.eqr(mcFam7.row.SESSO,"2")?"F":""));
                /* _stringa2 := LRTrim(arfn_agechar(rowFamesitid.FADNASSEL,' '))+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO */
                _stringa2 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADNASSEL," "))+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO;
                /* If _stringa1 = _stringa2 and Val(Left(mcFam7.TIPOSOG,1)) = rowFamesitid.FADRUOLO */
                if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 1 */
                  _findsog = CPLib.Round(1,0);
                  /* _ndgsog := mcFam7.CODINTER */
                  _ndgsog = mcFam7.row.CODINTER;
                  /* _dataini := mcFam7.DATAINI */
                  _dataini = mcFam7.row.DATAINI;
                  /* _datafin := mcFam7.DATAFINE */
                  _datafin = mcFam7.row.DATAFINE;
                  /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam7.TIPOSOG,1)) <> rowFamesitid.FADRUOLO */
                } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam7.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 2 */
                  _findsog = CPLib.Round(2,0);
                  /* _ndgsog := mcFam7.CODINTER */
                  _ndgsog = mcFam7.row.CODINTER;
                  /* _dataini := mcFam7.DATAINI */
                  _dataini = mcFam7.row.DATAINI;
                  /* _datafin := mcFam7.DATAFINE */
                  _datafin = mcFam7.row.DATAFINE;
                  /* _ruolo := Left(mcFam7.TIPOSOG,1) */
                  _ruolo = CPLib.Left(mcFam7.row.TIPOSOG,1);
                } // End If
              } // End If
            } // End If
            /* If _findsog =1 or _findsog=2 */
            if (CPLib.eqr(_findsog,1) || CPLib.eqr(_findsog,2)) {
              /* If _stringa1=_stringa2 */
              if (CPLib.eqr(_stringa1,_stringa2)) {
                /* If rowFamesitid.FADDATINI <> _dataini */
                if (CPLib.ne(rowFamesitid.FADDATINI,_dataini)) {
                  /* _contaerr := _contaerr + 1 */
                  _contaerr = CPLib.Round(_contaerr+1,0);
                  /* If w_flgwrt='M' */
                  if (CPLib.eqr(w_flgwrt,"M")) {
                    /* mcEsitiErr.AppendBlank() */
                    mcEsitiErr.AppendBlank();
                    /* mcEsitiErr.UNIQUECODE := _famcodice */
                    mcEsitiErr.row.UNIQUECODE = _famcodice;
                    /* mcEsitiErr.RAPPORTO := _rapporto */
                    mcEsitiErr.row.RAPPORTO = _rapporto;
                    /* mcEsitiErr.TIPORAP := 'R' */
                    mcEsitiErr.row.TIPORAP = "R";
                    /* mcEsitiErr.NDGSOG := _ndgsog */
                    mcEsitiErr.row.NDGSOG = _ndgsog;
                    /* mcEsitiErr.DATOMIT := 'Data Inizio Legame '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_dataini) */
                    mcEsitiErr.row.DATOMIT = "Data Inizio Legame "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_dataini);
                    /* mcEsitiErr.DATOAGE := 'Data Inizio Legame AGE: '+arfn_fdate(rowFamesitid.FADDATINI) */
                    mcEsitiErr.row.DATOAGE = "Data Inizio Legame AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI);
                    /* mcEsitiErr.ERRMSG := '* Data Inizio Legame non coincide (Ruolo: '+_ruolo+')' */
                    mcEsitiErr.row.ERRMSG = "* Data Inizio Legame non coincide (Ruolo: "+_ruolo+")";
                  } else { // Else
                    // * --- Insert into tmp_esitierr from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_esitierr");
                    m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"0000048C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000048C(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio MIT: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataini),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("* Data Inizio Legame non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                } // End If
                /* If rowFamesitid.FADDATFIN <> _datafin and _datafin <= _maxope */
                if (CPLib.ne(rowFamesitid.FADDATFIN,_datafin) && CPLib.le(_datafin,_maxope)) {
                  /* _contaerr := _contaerr + 1 */
                  _contaerr = CPLib.Round(_contaerr+1,0);
                  /* If w_flgwrt='M' */
                  if (CPLib.eqr(w_flgwrt,"M")) {
                    /* mcEsitiErr.AppendBlank() */
                    mcEsitiErr.AppendBlank();
                    /* mcEsitiErr.UNIQUECODE := _famcodice */
                    mcEsitiErr.row.UNIQUECODE = _famcodice;
                    /* mcEsitiErr.RAPPORTO := _rapporto */
                    mcEsitiErr.row.RAPPORTO = _rapporto;
                    /* mcEsitiErr.TIPORAP := 'R' */
                    mcEsitiErr.row.TIPORAP = "R";
                    /* mcEsitiErr.NDGSOG := _ndgsog */
                    mcEsitiErr.row.NDGSOG = _ndgsog;
                    /* mcEsitiErr.DATOMIT := 'Data Fine Legame '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_datafin) */
                    mcEsitiErr.row.DATOMIT = "Data Fine Legame "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_datafin);
                    /* mcEsitiErr.DATOAGE := 'Data Fine Legame AGE: '+arfn_fdate(rowFamesitid.FADDATFIN) */
                    mcEsitiErr.row.DATOAGE = "Data Fine Legame AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN);
                    /* mcEsitiErr.ERRMSG := '* Data Fine Legame non coincide (Ruolo: '+_ruolo+')' */
                    mcEsitiErr.row.ERRMSG = "* Data Fine Legame non coincide (Ruolo: "+_ruolo+")";
                  } else { // Else
                    // * --- Insert into tmp_esitierr from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_esitierr");
                    m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000498")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000498(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine MIT: "+arfn_fdateR.Make(m_Ctx,this).Run(_datafin),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("* Data Fine Legame non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                } // End If
              } else { // Else
                /* _contaerr := _contaerr + 1 */
                _contaerr = CPLib.Round(_contaerr+1,0);
                /* If w_flgwrt='M' */
                if (CPLib.eqr(w_flgwrt,"M")) {
                  /* mcEsitiErr.AppendBlank() */
                  mcEsitiErr.AppendBlank();
                  /* mcEsitiErr.UNIQUECODE := _famcodice */
                  mcEsitiErr.row.UNIQUECODE = _famcodice;
                  /* mcEsitiErr.RAPPORTO := _rapporto */
                  mcEsitiErr.row.RAPPORTO = _rapporto;
                  /* mcEsitiErr.TIPORAP := 'R' */
                  mcEsitiErr.row.TIPORAP = "R";
                  /* mcEsitiErr.NDGSOG := _ndgsog */
                  mcEsitiErr.row.NDGSOG = _ndgsog;
                  /* mcEsitiErr.DATOMIT := 'Dati MIT: '+_stringa1 */
                  mcEsitiErr.row.DATOMIT = "Dati MIT: "+_stringa1;
                  /* mcEsitiErr.DATOAGE := 'Dati AGE: '+_stringa2 */
                  mcEsitiErr.row.DATOAGE = "Dati AGE: "+_stringa2;
                  /* mcEsitiErr.ERRMSG := '* Dati Soggetto Non Coincidono' */
                  mcEsitiErr.row.ERRMSG = "* Dati Soggetto Non Coincidono";
                } else { // Else
                  // * --- Insert into tmp_esitierr from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_esitierr");
                  m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000004A3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000004A3(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Dati MIT: "+_stringa1,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Dati AGE: "+_stringa2,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("* Dati Soggetto Non Coincidono","?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
              } // End If
            } // End If
          } // End If
          /* If _findsog=1 or _findsog=2 */
          if (CPLib.eqr(_findsog,1) || CPLib.eqr(_findsog,2)) {
            /* mcFam7.MATCH := '*' */
            mcFam7.row.MATCH = "*";
            /* mcFam7.SaveRow() */
            mcFam7.SaveRow();
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        } // End If
        /* mcFam7.Skip() */
        mcFam7.Skip();
      } // End While
      /* If _findsog=2 */
      if (CPLib.eqr(_findsog,2)) {
        /* _contaerr := _contaerr + 1 */
        _contaerr = CPLib.Round(_contaerr+1,0);
        /* _datiage := 'Dati AGE: C.F. '+LRTrim(rowFamesitid.FADCODFIS) + ' - Ruolo Age: ' +Str(rowFamesitid.FADRUOLO,1,0) */
        _datiage = "Dati AGE: C.F. "+CPLib.LRTrim(rowFamesitid.FADCODFIS)+" - Ruolo Age: "+CPLib.Str(rowFamesitid.FADRUOLO,1,0);
        /* _errore := '* Ruolo intestatario non corrispondente' */
        _errore = "* Ruolo intestatario non corrispondente";
        /* If w_flgwrt='M' */
        if (CPLib.eqr(w_flgwrt,"M")) {
          /* mcEsitiErr.AppendBlank() */
          mcEsitiErr.AppendBlank();
          /* mcEsitiErr.UNIQUECODE := _famcodice */
          mcEsitiErr.row.UNIQUECODE = _famcodice;
          /* mcEsitiErr.RAPPORTO := _rapporto */
          mcEsitiErr.row.RAPPORTO = _rapporto;
          /* mcEsitiErr.TIPORAP := 'R' */
          mcEsitiErr.row.TIPORAP = "R";
          /* mcEsitiErr.NDGSOG := LRTrim(rowFamesitid.FADCODFIS) */
          mcEsitiErr.row.NDGSOG = CPLib.LRTrim(rowFamesitid.FADCODFIS);
          /* mcEsitiErr.DATOMIT := 'Dati MIT: Ruolo ' + _ruolo */
          mcEsitiErr.row.DATOMIT = "Dati MIT: Ruolo "+_ruolo;
          /* mcEsitiErr.DATOAGE := _datiage */
          mcEsitiErr.row.DATOAGE = _datiage;
          /* mcEsitiErr.ERRMSG := _errore */
          mcEsitiErr.row.ERRMSG = _errore;
        } else { // Else
          // * --- Insert into tmp_esitierr from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_esitierr");
          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000004B6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000004B6(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowFamesitid.FADCODFIS),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Dati MIT: Ruolo "+_ruolo,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datiage,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
      } // End If
      /* If _findsog=0 */
      if (CPLib.eqr(_findsog,0)) {
        /* _contaerr := _contaerr + 1 */
        _contaerr = CPLib.Round(_contaerr+1,0);
        /* If not(Empty(rowFamesitid.FADCODFIS)) */
        if ( ! (CPLib.Empty(rowFamesitid.FADCODFIS))) {
          /* _datiage := 'Dati AGE: C.F. '+LRTrim(rowFamesitid.FADCODFIS) */
          _datiage = "Dati AGE: C.F. "+CPLib.LRTrim(rowFamesitid.FADCODFIS);
          /* _errore := '* Codice Fiscale Soggetto non presente in AUI/AGE per il ruolo ('+rowFamesitid.FADRUOLO+') indicato' */
          _errore = "* Codice Fiscale Soggetto non presente in AUI/AGE per il ruolo ("+rowFamesitid.FADRUOLO+") indicato";
        } else { // Else
          /* If not(Empty(LRTrim(rowFamesitid.FADCOGRAG))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(rowFamesitid.FADCOGRAG)))) {
            /* _datiage := 'Dati AGE: Nominativo '+LRTrim(rowFamesitid.FADCOGRAG)+"-"+LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
            _datiage = "Dati AGE: Nominativo "+CPLib.LRTrim(rowFamesitid.FADCOGRAG)+"-"+CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
          } else { // Else
            /* _datiage := 'Dati AGE: Soggetto '+LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO */
            _datiage = "Dati AGE: Soggetto "+CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO;
          } // End If
          /* _errore := '* Nominativo non presente in AUI/AGE per il ruolo ('+rowFamesitid.FADRUOLO+') indicato' + iif(not(Empty(_datafinrap)),NL+" (Rapporto chiuso il "+arfn_fdate(_datafinrap)+")","") */
          _errore = "* Nominativo non presente in AUI/AGE per il ruolo ("+rowFamesitid.FADRUOLO+") indicato"+( ! (CPLib.Empty(_datafinrap))?"\n"+" (Rapporto chiuso il "+arfn_fdateR.Make(m_Ctx,this).Run(_datafinrap)+")":"");
        } // End If
        /* If w_flgwrt='M' */
        if (CPLib.eqr(w_flgwrt,"M")) {
          /* mcEsitiErr.AppendBlank() */
          mcEsitiErr.AppendBlank();
          /* mcEsitiErr.UNIQUECODE := _famcodice */
          mcEsitiErr.row.UNIQUECODE = _famcodice;
          /* mcEsitiErr.RAPPORTO := _rapporto */
          mcEsitiErr.row.RAPPORTO = _rapporto;
          /* mcEsitiErr.TIPORAP := 'R' */
          mcEsitiErr.row.TIPORAP = "R";
          /* mcEsitiErr.NDGSOG := rowFamesitid.FADCODFIS */
          mcEsitiErr.row.NDGSOG = rowFamesitid.FADCODFIS;
          /* mcEsitiErr.DATOMIT := '' */
          mcEsitiErr.row.DATOMIT = "";
          /* mcEsitiErr.DATOAGE := _datiage */
          mcEsitiErr.row.DATOAGE = _datiage;
          /* mcEsitiErr.ERRMSG := _errore */
          mcEsitiErr.row.ERRMSG = _errore;
        } else { // Else
          // * --- Insert into tmp_esitierr from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_esitierr");
          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"000004C9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000004C9(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowFamesitid.FADCODFIS,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datiage,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
      } // End If
    } // End If
  }
  void Pag_5() throws Exception {
    /* Esamina i garantiti */
    /* mcFam8.GoTop() */
    mcFam8.GoTop();
    /* While not(mcFam8.Eof()) */
    while ( ! (mcFam8.Eof())) {
      /* _findsog := 0 */
      _findsog = CPLib.Round(0,0);
      /* gMsgImp := 'Confronto soggetto: '+rowFamesitid.FADCODFIS+" con soggetto: "+mcFam8.CODFISC */
      gMsgImp = "Confronto soggetto: "+rowFamesitid.FADCODFIS+" con soggetto: "+mcFam8.row.CODFISC;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If mcFam8.MATCH <> '*' */
      if (CPLib.ne(mcFam8.row.MATCH,"*")) {
        /* If not(Empty(rowFamesitid.FADCODFIS)) */
        if ( ! (CPLib.Empty(rowFamesitid.FADCODFIS))) {
          /* If Len(LRTrim(rowFamesitid.FADCODFIS))=11 */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(rowFamesitid.FADCODFIS)),11)) {
            /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim("***"+Right(LRTrim(mcFam8.CODFISC),8)) and Val(Left(mcFam8.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam8.DATAINI and iif(mcFam8.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam8.DATAFINE,True) */
            if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("***"+CPLib.Right(CPLib.LRTrim(mcFam8.row.CODFISC),8))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam8.row.DATAINI) && (CPLib.le(mcFam8.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam8.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } else { // Else
            /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim("******"+Right(LRTrim(mcFam8.CODFISC),10)) and Val(Left(mcFam8.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam8.DATAINI and iif(mcFam8.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam8.DATAFINE,True) */
            if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("******"+CPLib.Right(CPLib.LRTrim(mcFam8.row.CODFISC),10))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam8.row.DATAINI) && (CPLib.le(mcFam8.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam8.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } // End If
        } else { // Else
          /* If Empty(rowFamesitid.FADSESSO) */
          if (CPLib.Empty(rowFamesitid.FADSESSO)) {
            /* _stringa1 := LRTrim(arfn_agechar(Left(mcFam8.RAGSOC,60)," "))+"-"+LRTrim(mcFam8.SEDELEG)+"-"+LRTrim(mcFam8.PROVLEG) */
            _stringa1 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Left(mcFam8.row.RAGSOC,60)," "))+"-"+CPLib.LRTrim(mcFam8.row.SEDELEG)+"-"+CPLib.LRTrim(mcFam8.row.PROVLEG);
            /* _stringa2 := LRTrim(arfn_agechar(rowFamesitid.FADCOGRAG," "))+"-"+LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
            _stringa2 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADCOGRAG," "))+"-"+CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
            /* If _stringa1 = _stringa2 and Val(Left(mcFam8.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam8.DATAINI and iif(mcFam8.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam8.DATAFINE,True) */
            if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam8.row.DATAINI) && (CPLib.le(mcFam8.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam8.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } else { // Else
            /* _stringa1 := LRTrim(arfn_agechar(mcFam8.LUONAS," "))+"-"+LRTrim(mcFam8.PROVNAS)+"-"+DateToChar(mcFam8.DATNAS)+"-"+iif(mcFam8.SESSO='1','M',iif(mcFam8.SESSO='2','F','')) */
            _stringa1 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcFam8.row.LUONAS," "))+"-"+CPLib.LRTrim(mcFam8.row.PROVNAS)+"-"+CPLib.DateToChar(mcFam8.row.DATNAS)+"-"+(CPLib.eqr(mcFam8.row.SESSO,"1")?"M":(CPLib.eqr(mcFam8.row.SESSO,"2")?"F":""));
            /* _stringa2 := LRTrim(arfn_agechar(rowFamesitid.FADNASSEL," "))+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO */
            _stringa2 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADNASSEL," "))+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO;
            /* If _stringa1 = _stringa2 and Val(Left(mcFam8.TIPOSOG,1))=rowFamesitid.FADRUOLO and rowFamesitid.FADDATINI = mcFam8.DATAINI and iif(mcFam8.DATAFINE <= _maxope,rowFamesitid.FADDATFIN=mcFam8.DATAFINE,True) */
            if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO) && CPLib.eqr(rowFamesitid.FADDATINI,mcFam8.row.DATAINI) && (CPLib.le(mcFam8.row.DATAFINE,_maxope)?CPLib.eqr(rowFamesitid.FADDATFIN,mcFam8.row.DATAFINE):true)) {
              /* _findsog := 3 */
              _findsog = CPLib.Round(3,0);
            } // End If
          } // End If
        } // End If
        /* If _findsog=3 */
        if (CPLib.eqr(_findsog,3)) {
          /* mcFam8.MATCH := '*' */
          mcFam8.row.MATCH = "*";
          /* mcFam8.SaveRow() */
          mcFam8.SaveRow();
          // Exit Loop
          if (true) {
            break;
          }
        } // End If
      } // End If
      /* mcFam8.Skip() */
      mcFam8.Skip();
    } // End While
    /* If _findsog <> 3 */
    if (CPLib.ne(_findsog,3)) {
      /* mcFam8.GoTop() */
      mcFam8.GoTop();
      /* While not(mcFam8.Eof()) */
      while ( ! (mcFam8.Eof())) {
        /* If mcFam8.MATCH <> '*' */
        if (CPLib.ne(mcFam8.row.MATCH,"*")) {
          /* If not(Empty(rowFamesitid.FADCODFIS)) */
          if ( ! (CPLib.Empty(rowFamesitid.FADCODFIS))) {
            /* If Len(LRTrim(rowFamesitid.FADCODFIS))=11 */
            if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(rowFamesitid.FADCODFIS)),11)) {
              /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim("***"+Right(LRTrim(mcFam8.CODFISC),8)) and Val(Left(mcFam8.TIPOSOG,1))=rowFamesitid.FADRUOLO */
              if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("***"+CPLib.Right(CPLib.LRTrim(mcFam8.row.CODFISC),8))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam8.CODINTER */
                _ndgsog = mcFam8.row.CODINTER;
                /* _dataini := mcFam8.DATAINI */
                _dataini = mcFam8.row.DATAINI;
                /* _datafin := mcFam8.DATAFINE */
                _datafin = mcFam8.row.DATAFINE;
                /* _origine := mcFam8.ORIGINE */
                _origine = mcFam8.row.ORIGINE;
                /* _ruolo := Left(mcFam8.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam8.row.TIPOSOG,1);
                /* ElseIf LRTrim(rowFamesitid.FADCODFIS)=LRTrim("***"+Right(LRTrim(mcFam8.CODFISC),8)) and Val(Left(mcFam8.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("***"+CPLib.Right(CPLib.LRTrim(mcFam8.row.CODFISC),8))) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam8.CODINTER */
                _ndgsog = mcFam8.row.CODINTER;
                /* _dataini := mcFam8.DATAINI */
                _dataini = mcFam8.row.DATAINI;
                /* _datafin := mcFam8.DATAFINE */
                _datafin = mcFam8.row.DATAFINE;
                /* _origine := mcFam8.ORIGINE */
                _origine = mcFam8.row.ORIGINE;
                /* _ruolo := Left(mcFam8.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam8.row.TIPOSOG,1);
              } // End If
            } else { // Else
              /* If LRTrim(rowFamesitid.FADCODFIS)=LRTrim('******'+Right(LRTrim(mcFam8.CODFISC),10)) and Val(Left(mcFam8.TIPOSOG,1))=rowFamesitid.FADRUOLO */
              if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("******"+CPLib.Right(CPLib.LRTrim(mcFam8.row.CODFISC),10))) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam8.CODINTER */
                _ndgsog = mcFam8.row.CODINTER;
                /* _dataini := mcFam8.DATAINI */
                _dataini = mcFam8.row.DATAINI;
                /* _datafin := mcFam8.DATAFINE */
                _datafin = mcFam8.row.DATAFINE;
                /* _origine := mcFam8.ORIGINE */
                _origine = mcFam8.row.ORIGINE;
                /* _ruolo := Left(mcFam8.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam8.row.TIPOSOG,1);
                /* ElseIf LRTrim(rowFamesitid.FADCODFIS)=LRTrim('******'+Right(LRTrim(mcFam8.CODFISC),10)) and Val(Left(mcFam8.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(CPLib.LRTrim(rowFamesitid.FADCODFIS),CPLib.LRTrim("******"+CPLib.Right(CPLib.LRTrim(mcFam8.row.CODFISC),10))) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam8.CODINTER */
                _ndgsog = mcFam8.row.CODINTER;
                /* _dataini := mcFam8.DATAINI */
                _dataini = mcFam8.row.DATAINI;
                /* _datafin := mcFam8.DATAFINE */
                _datafin = mcFam8.row.DATAFINE;
                /* _origine := mcFam8.ORIGINE */
                _origine = mcFam8.row.ORIGINE;
                /* _ruolo := Left(mcFam8.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam8.row.TIPOSOG,1);
              } // End If
            } // End If
            /* If _findsog=1 or _findsog=2 */
            if (CPLib.eqr(_findsog,1) || CPLib.eqr(_findsog,2)) {
              /* If rowFamesitid.FADDATINI <> _dataini */
              if (CPLib.ne(rowFamesitid.FADDATINI,_dataini)) {
                /* _contaerr := _contaerr + 1 */
                _contaerr = CPLib.Round(_contaerr+1,0);
                /* If w_flgwrt='M' */
                if (CPLib.eqr(w_flgwrt,"M")) {
                  /* mcEsitiErr.AppendBlank() */
                  mcEsitiErr.AppendBlank();
                  /* mcEsitiErr.UNIQUECODE := _famcodice */
                  mcEsitiErr.row.UNIQUECODE = _famcodice;
                  /* mcEsitiErr.RAPPORTO := _rapporto */
                  mcEsitiErr.row.RAPPORTO = _rapporto;
                  /* mcEsitiErr.TIPORAP := 'R' */
                  mcEsitiErr.row.TIPORAP = "R";
                  /* mcEsitiErr.NDGSOG := _ndgsog */
                  mcEsitiErr.row.NDGSOG = _ndgsog;
                  /* mcEsitiErr.DATOMIT := 'Data Inizio Garantito '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_dataini) */
                  mcEsitiErr.row.DATOMIT = "Data Inizio Garantito "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_dataini);
                  /* mcEsitiErr.DATOAGE := 'Data Inizio Garantito AGE: '+arfn_fdate(rowFamesitid.FADDATINI) */
                  mcEsitiErr.row.DATOAGE = "Data Inizio Garantito AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI);
                  /* mcEsitiErr.ERRMSG := '* Data Inizio Garantito non coincide (Ruolo: '+_ruolo+')' */
                  mcEsitiErr.row.ERRMSG = "* Data Inizio Garantito non coincide (Ruolo: "+_ruolo+")";
                } else { // Else
                  // * --- Insert into tmp_esitierr from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_esitierr");
                  m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000510")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000510(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_dataini),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("* Data Inizio Garantito non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
              } // End If
              /* If rowFamesitid.FADDATFIN <> _datafin and _datafin <= _maxope */
              if (CPLib.ne(rowFamesitid.FADDATFIN,_datafin) && CPLib.le(_datafin,_maxope)) {
                /* _contaerr := _contaerr + 1 */
                _contaerr = CPLib.Round(_contaerr+1,0);
                /* If w_flgwrt='M' */
                if (CPLib.eqr(w_flgwrt,"M")) {
                  /* mcEsitiErr.AppendBlank() */
                  mcEsitiErr.AppendBlank();
                  /* mcEsitiErr.UNIQUECODE := _famcodice */
                  mcEsitiErr.row.UNIQUECODE = _famcodice;
                  /* mcEsitiErr.RAPPORTO := _rapporto */
                  mcEsitiErr.row.RAPPORTO = _rapporto;
                  /* mcEsitiErr.TIPORAP := 'R' */
                  mcEsitiErr.row.TIPORAP = "R";
                  /* mcEsitiErr.NDGSOG := _ndgsog */
                  mcEsitiErr.row.NDGSOG = _ndgsog;
                  /* mcEsitiErr.DATOMIT := 'Data Fine Garantito '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_datafin) */
                  mcEsitiErr.row.DATOMIT = "Data Fine Garantito "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_datafin);
                  /* mcEsitiErr.DATOAGE := 'Data Fine Garantito AGE: '+arfn_fdate(rowFamesitid.FADDATFIN) */
                  mcEsitiErr.row.DATOAGE = "Data Fine Garantito AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN);
                  /* mcEsitiErr.ERRMSG := '* Data Fine Garantito non coincide (Ruolo: '+_ruolo+')' */
                  mcEsitiErr.row.ERRMSG = "* Data Fine Garantito non coincide (Ruolo: "+_ruolo+")";
                } else { // Else
                  // * --- Insert into tmp_esitierr from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_esitierr");
                  m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"0000051C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000051C(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_datafin),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("* Data Fine Garantito non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
              } // End If
            } // End If
          } else { // Else
            /* If Empty(rowFamesitid.FADSESSO) */
            if (CPLib.Empty(rowFamesitid.FADSESSO)) {
              /* _stringa1 := LRTrim(Left(mcFam8.RAGSOC,60))+"-"+LRTrim(mcFam8.SEDELEG)+"-"+LRTrim(mcFam8.PROVLEG) */
              _stringa1 = CPLib.LRTrim(CPLib.Left(mcFam8.row.RAGSOC,60))+"-"+CPLib.LRTrim(mcFam8.row.SEDELEG)+"-"+CPLib.LRTrim(mcFam8.row.PROVLEG);
              /* _stringa2 := LRTrim(rowFamesitid.FADCOGRAG)+"-"+LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
              _stringa2 = CPLib.LRTrim(rowFamesitid.FADCOGRAG)+"-"+CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
              /* If _stringa1 = _stringa2 and Val(Left(mcFam8.TIPOSOG,1))=rowFamesitid.FADRUOLO */
              if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam8.CODINTER */
                _ndgsog = mcFam8.row.CODINTER;
                /* _dataini := mcFam8.DATAINI */
                _dataini = mcFam8.row.DATAINI;
                /* _datafin := mcFam8.DATAFINE */
                _datafin = mcFam8.row.DATAFINE;
                /* _origine := mcFam8.ORIGINE */
                _origine = mcFam8.row.ORIGINE;
                /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam8.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam8.CODINTER */
                _ndgsog = mcFam8.row.CODINTER;
                /* _dataini := mcFam8.DATAINI */
                _dataini = mcFam8.row.DATAINI;
                /* _datafin := mcFam8.DATAFINE */
                _datafin = mcFam8.row.DATAFINE;
                /* _origine := mcFam8.ORIGINE */
                _origine = mcFam8.row.ORIGINE;
                /* _ruolo := Left(mcFam8.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam8.row.TIPOSOG,1);
              } // End If
              /* If _findsog=0 */
              if (CPLib.eqr(_findsog,0)) {
                /* _stringa1 := LRTrim(arfn_agechar(Left(mcFam8.RAGSOC,60),' '))+"-"+LRTrim(arfn_agechar(mcFam8.SEDELEG,' '))+"-"+LRTrim(mcFam8.PROVLEG) */
                _stringa1 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Left(mcFam8.row.RAGSOC,60)," "))+"-"+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcFam8.row.SEDELEG," "))+"-"+CPLib.LRTrim(mcFam8.row.PROVLEG);
                /* _stringa2 := LRTrim(arfn_agechar(rowFamesitid.FADCOGRAG,' '))+"-"+LRTrim(arfn_agechar(rowFamesitid.FADNASSEL,' '))+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
                _stringa2 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADCOGRAG," "))+"-"+CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADNASSEL," "))+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
                /* If _stringa1 = _stringa2 and Val(Left(mcFam8.TIPOSOG,1))=rowFamesitid.FADRUOLO */
                if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 1 */
                  _findsog = CPLib.Round(1,0);
                  /* _ndgsog := mcFam8.CODINTER */
                  _ndgsog = mcFam8.row.CODINTER;
                  /* _dataini := mcFam8.DATAINI */
                  _dataini = mcFam8.row.DATAINI;
                  /* _datafin := mcFam8.DATAFINE */
                  _datafin = mcFam8.row.DATAFINE;
                  /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam8.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
                } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 2 */
                  _findsog = CPLib.Round(2,0);
                  /* _ndgsog := mcFam8.CODINTER */
                  _ndgsog = mcFam8.row.CODINTER;
                  /* _dataini := mcFam8.DATAINI */
                  _dataini = mcFam8.row.DATAINI;
                  /* _datafin := mcFam8.DATAFINE */
                  _datafin = mcFam8.row.DATAFINE;
                  /* _ruolo := Left(mcFam8.TIPOSOG,1) */
                  _ruolo = CPLib.Left(mcFam8.row.TIPOSOG,1);
                } // End If
              } // End If
            } else { // Else
              /* _stringa1 := LRTrim(mcFam8.LUONAS)+"-"+LRTrim(mcFam8.PROVNAS)+"-"+DateToChar(mcFam8.DATNAS)+"-"+iif(mcFam8.SESSO='1','M',iif(mcFam8.SESSO='2','F','')) */
              _stringa1 = CPLib.LRTrim(mcFam8.row.LUONAS)+"-"+CPLib.LRTrim(mcFam8.row.PROVNAS)+"-"+CPLib.DateToChar(mcFam8.row.DATNAS)+"-"+(CPLib.eqr(mcFam8.row.SESSO,"1")?"M":(CPLib.eqr(mcFam8.row.SESSO,"2")?"F":""));
              /* _stringa2 := LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO */
              _stringa2 = CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO;
              /* If _stringa1 = _stringa2 and Val(Left(mcFam8.TIPOSOG,1)) = rowFamesitid.FADRUOLO */
              if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 1 */
                _findsog = CPLib.Round(1,0);
                /* _ndgsog := mcFam8.CODINTER */
                _ndgsog = mcFam8.row.CODINTER;
                /* _dataini := mcFam8.DATAINI */
                _dataini = mcFam8.row.DATAINI;
                /* _datafin := mcFam8.DATAFINE */
                _datafin = mcFam8.row.DATAFINE;
                /* _origine := mcFam8.ORIGINE */
                _origine = mcFam8.row.ORIGINE;
                /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam8.TIPOSOG,1))<>rowFamesitid.FADRUOLO */
              } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                /* _findsog := 2 */
                _findsog = CPLib.Round(2,0);
                /* _ndgsog := mcFam8.CODINTER */
                _ndgsog = mcFam8.row.CODINTER;
                /* _dataini := mcFam8.DATAINI */
                _dataini = mcFam8.row.DATAINI;
                /* _datafin := mcFam8.DATAFINE */
                _datafin = mcFam8.row.DATAFINE;
                /* _origine := mcFam8.ORIGINE */
                _origine = mcFam8.row.ORIGINE;
                /* _ruolo := Left(mcFam8.TIPOSOG,1) */
                _ruolo = CPLib.Left(mcFam8.row.TIPOSOG,1);
              } // End If
              /* If _findsog=0 */
              if (CPLib.eqr(_findsog,0)) {
                /* _stringa1 := LRTrim(arfn_agechar(mcFam8.LUONAS,' '))+"-"+LRTrim(mcFam8.PROVNAS)+"-"+DateToChar(mcFam8.DATNAS)+"-"+iif(mcFam8.SESSO='1','M',iif(mcFam8.SESSO='2','F','')) */
                _stringa1 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(mcFam8.row.LUONAS," "))+"-"+CPLib.LRTrim(mcFam8.row.PROVNAS)+"-"+CPLib.DateToChar(mcFam8.row.DATNAS)+"-"+(CPLib.eqr(mcFam8.row.SESSO,"1")?"M":(CPLib.eqr(mcFam8.row.SESSO,"2")?"F":""));
                /* _stringa2 := LRTrim(arfn_agechar(rowFamesitid.FADNASSEL,' '))+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO */
                _stringa2 = CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowFamesitid.FADNASSEL," "))+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO;
                /* If _stringa1 = _stringa2 and Val(Left(mcFam8.TIPOSOG,1)) = rowFamesitid.FADRUOLO */
                if (CPLib.eqr(_stringa1,_stringa2) && CPLib.eqr(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 1 */
                  _findsog = CPLib.Round(1,0);
                  /* _ndgsog := mcFam8.CODINTER */
                  _ndgsog = mcFam8.row.CODINTER;
                  /* _dataini := mcFam8.DATAINI */
                  _dataini = mcFam8.row.DATAINI;
                  /* _datafin := mcFam8.DATAFINE */
                  _datafin = mcFam8.row.DATAFINE;
                  /* ElseIf _stringa1 = _stringa2 and Val(Left(mcFam8.TIPOSOG,1)) <> rowFamesitid.FADRUOLO */
                } else if (CPLib.eqr(_stringa1,_stringa2) && CPLib.ne(CPLib.Val(CPLib.Left(mcFam8.row.TIPOSOG,1)),rowFamesitid.FADRUOLO)) {
                  /* _findsog := 2 */
                  _findsog = CPLib.Round(2,0);
                  /* _ndgsog := mcFam8.CODINTER */
                  _ndgsog = mcFam8.row.CODINTER;
                  /* _dataini := mcFam8.DATAINI */
                  _dataini = mcFam8.row.DATAINI;
                  /* _datafin := mcFam8.DATAFINE */
                  _datafin = mcFam8.row.DATAFINE;
                  /* _ruolo := Left(mcFam8.TIPOSOG,1) */
                  _ruolo = CPLib.Left(mcFam8.row.TIPOSOG,1);
                } // End If
              } // End If
            } // End If
            /* If _findsog =1 or _findsog=2 */
            if (CPLib.eqr(_findsog,1) || CPLib.eqr(_findsog,2)) {
              /* If _stringa1=_stringa2 */
              if (CPLib.eqr(_stringa1,_stringa2)) {
                /* If rowFamesitid.FADDATINI <> _dataini */
                if (CPLib.ne(rowFamesitid.FADDATINI,_dataini)) {
                  /* _contaerr := _contaerr + 1 */
                  _contaerr = CPLib.Round(_contaerr+1,0);
                  /* If w_flgwrt='M' */
                  if (CPLib.eqr(w_flgwrt,"M")) {
                    /* mcEsitiErr.AppendBlank() */
                    mcEsitiErr.AppendBlank();
                    /* mcEsitiErr.UNIQUECODE := _famcodice */
                    mcEsitiErr.row.UNIQUECODE = _famcodice;
                    /* mcEsitiErr.RAPPORTO := _rapporto */
                    mcEsitiErr.row.RAPPORTO = _rapporto;
                    /* mcEsitiErr.TIPORAP := 'R' */
                    mcEsitiErr.row.TIPORAP = "R";
                    /* mcEsitiErr.NDGSOG := _ndgsog */
                    mcEsitiErr.row.NDGSOG = _ndgsog;
                    /* mcEsitiErr.DATOMIT := 'Data Inizio Garantito '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_dataini) */
                    mcEsitiErr.row.DATOMIT = "Data Inizio Garantito "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_dataini);
                    /* mcEsitiErr.DATOAGE := 'Data Inizio Garantito AGE: '+arfn_fdate(rowFamesitid.FADDATINI) */
                    mcEsitiErr.row.DATOAGE = "Data Inizio Garantito AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI);
                    /* mcEsitiErr.ERRMSG := '* Data Inizio Garantito non coincide (Ruolo: '+_ruolo+')' */
                    mcEsitiErr.row.ERRMSG = "* Data Inizio Garantito non coincide (Ruolo: "+_ruolo+")";
                  } else { // Else
                    // * --- Insert into tmp_esitierr from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_esitierr");
                    m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000561")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000561(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio MIT: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataini),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Inizio AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATINI),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("* Data Inizio Garantito non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                } // End If
                /* If rowFamesitid.FADDATFIN <> _datafin and _datafin <= _maxope */
                if (CPLib.ne(rowFamesitid.FADDATFIN,_datafin) && CPLib.le(_datafin,_maxope)) {
                  /* _contaerr := _contaerr + 1 */
                  _contaerr = CPLib.Round(_contaerr+1,0);
                  /* If w_flgwrt='M' */
                  if (CPLib.eqr(w_flgwrt,"M")) {
                    /* mcEsitiErr.AppendBlank() */
                    mcEsitiErr.AppendBlank();
                    /* mcEsitiErr.UNIQUECODE := _famcodice */
                    mcEsitiErr.row.UNIQUECODE = _famcodice;
                    /* mcEsitiErr.RAPPORTO := _rapporto */
                    mcEsitiErr.row.RAPPORTO = _rapporto;
                    /* mcEsitiErr.TIPORAP := 'R' */
                    mcEsitiErr.row.TIPORAP = "R";
                    /* mcEsitiErr.NDGSOG := _ndgsog */
                    mcEsitiErr.row.NDGSOG = _ndgsog;
                    /* mcEsitiErr.DATOMIT := 'Data Fine Garantito '+iif(_origine='U','MITAUI: ','MITAGE: ')+arfn_fdate(_datafin) */
                    mcEsitiErr.row.DATOMIT = "Data Fine Garantito "+(CPLib.eqr(_origine,"U")?"MITAUI: ":"MITAGE: ")+arfn_fdateR.Make(m_Ctx,this).Run(_datafin);
                    /* mcEsitiErr.DATOAGE := 'Data Fine Garantito AGE: '+arfn_fdate(rowFamesitid.FADDATFIN) */
                    mcEsitiErr.row.DATOAGE = "Data Fine Garantito AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN);
                    /* mcEsitiErr.ERRMSG := '* Data Fine Garantito non coincide (Ruolo: '+_ruolo+')' */
                    mcEsitiErr.row.ERRMSG = "* Data Fine Garantito non coincide (Ruolo: "+_ruolo+")";
                  } else { // Else
                    // * --- Insert into tmp_esitierr from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_esitierr");
                    m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"0000056D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000056D(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine MIT: "+arfn_fdateR.Make(m_Ctx,this).Run(_datafin),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("Data Fine AGE: "+arfn_fdateR.Make(m_Ctx,this).Run(rowFamesitid.FADDATFIN),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("* Data Fine Garantito non coincide (Ruolo: "+_ruolo+")","?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
                } // End If
              } else { // Else
                /* _contaerr := _contaerr + 1 */
                _contaerr = CPLib.Round(_contaerr+1,0);
                /* If w_flgwrt='M' */
                if (CPLib.eqr(w_flgwrt,"M")) {
                  /* mcEsitiErr.AppendBlank() */
                  mcEsitiErr.AppendBlank();
                  /* mcEsitiErr.UNIQUECODE := _famcodice */
                  mcEsitiErr.row.UNIQUECODE = _famcodice;
                  /* mcEsitiErr.RAPPORTO := _rapporto */
                  mcEsitiErr.row.RAPPORTO = _rapporto;
                  /* mcEsitiErr.TIPORAP := 'R' */
                  mcEsitiErr.row.TIPORAP = "R";
                  /* mcEsitiErr.NDGSOG := _ndgsog */
                  mcEsitiErr.row.NDGSOG = _ndgsog;
                  /* mcEsitiErr.DATOMIT := 'Dati MIT: '+_stringa1 */
                  mcEsitiErr.row.DATOMIT = "Dati MIT: "+_stringa1;
                  /* mcEsitiErr.DATOAGE := 'Dati AGE: '+_stringa2 */
                  mcEsitiErr.row.DATOAGE = "Dati AGE: "+_stringa2;
                  /* mcEsitiErr.ERRMSG := '* Dati Soggetto Non Coincidono' */
                  mcEsitiErr.row.ERRMSG = "* Dati Soggetto Non Coincidono";
                } else { // Else
                  // * --- Insert into tmp_esitierr from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_esitierr");
                  m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"00000578")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000578(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ndgsog,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Dati MIT: "+_stringa1,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("Dati AGE: "+_stringa2,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("* Dati Soggetto Non Coincidono","?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
              } // End If
            } // End If
          } // End If
          /* If _findsog=1 or _findsog=2 */
          if (CPLib.eqr(_findsog,1) || CPLib.eqr(_findsog,2)) {
            /* mcFam8.MATCH := '*' */
            mcFam8.row.MATCH = "*";
            /* mcFam8.SaveRow() */
            mcFam8.SaveRow();
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        } // End If
        /* mcFam8.Skip() */
        mcFam8.Skip();
      } // End While
      /* If _findsog=2 */
      if (CPLib.eqr(_findsog,2)) {
        /* _contaerr := _contaerr + 1 */
        _contaerr = CPLib.Round(_contaerr+1,0);
        /* _datiage := 'Dati AGE: C.F. '+LRTrim(rowFamesitid.FADCODFIS) + ' - Ruolo Age: ' +Str(rowFamesitid.FADRUOLO,1,0) */
        _datiage = "Dati AGE: C.F. "+CPLib.LRTrim(rowFamesitid.FADCODFIS)+" - Ruolo Age: "+CPLib.Str(rowFamesitid.FADRUOLO,1,0);
        /* _errore := '* Ruolo intestatario non corrispondente' */
        _errore = "* Ruolo intestatario non corrispondente";
        /* If w_flgwrt='M' */
        if (CPLib.eqr(w_flgwrt,"M")) {
          /* mcEsitiErr.AppendBlank() */
          mcEsitiErr.AppendBlank();
          /* mcEsitiErr.UNIQUECODE := _famcodice */
          mcEsitiErr.row.UNIQUECODE = _famcodice;
          /* mcEsitiErr.RAPPORTO := _rapporto */
          mcEsitiErr.row.RAPPORTO = _rapporto;
          /* mcEsitiErr.TIPORAP := 'R' */
          mcEsitiErr.row.TIPORAP = "R";
          /* mcEsitiErr.NDGSOG := LRTrim(rowFamesitid.FADCODFIS) */
          mcEsitiErr.row.NDGSOG = CPLib.LRTrim(rowFamesitid.FADCODFIS);
          /* mcEsitiErr.DATOMIT := 'Dati MIT: Ruolo ' + _ruolo */
          mcEsitiErr.row.DATOMIT = "Dati MIT: Ruolo "+_ruolo;
          /* mcEsitiErr.DATOAGE := _datiage */
          mcEsitiErr.row.DATOAGE = _datiage;
          /* mcEsitiErr.ERRMSG := _errore */
          mcEsitiErr.row.ERRMSG = _errore;
        } else { // Else
          // * --- Insert into tmp_esitierr from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_esitierr");
          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"0000058B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000058B(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowFamesitid.FADCODFIS),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Dati MIT: Ruolo "+_ruolo,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datiage,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
      } // End If
      /* If _findsog=0 */
      if (CPLib.eqr(_findsog,0)) {
        /* _contaerr := _contaerr + 1 */
        _contaerr = CPLib.Round(_contaerr+1,0);
        /* If not(Empty(rowFamesitid.FADCODFIS)) */
        if ( ! (CPLib.Empty(rowFamesitid.FADCODFIS))) {
          /* _datiage := 'Dati AGE: C.F. '+LRTrim(rowFamesitid.FADCODFIS) */
          _datiage = "Dati AGE: C.F. "+CPLib.LRTrim(rowFamesitid.FADCODFIS);
          /* _errore := '* Codice Fiscale Soggetto non presente in AUI/AGE per il ruolo ('+rowFamesitid.FADRUOLO+') indicato' */
          _errore = "* Codice Fiscale Soggetto non presente in AUI/AGE per il ruolo ("+rowFamesitid.FADRUOLO+") indicato";
        } else { // Else
          /* If not(Empty(LRTrim(rowFamesitid.FADCOGRAG))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(rowFamesitid.FADCOGRAG)))) {
            /* _datiage := 'Dati AGE: Nominativo '+LRTrim(rowFamesitid.FADCOGRAG)+"-"+LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL) */
            _datiage = "Dati AGE: Nominativo "+CPLib.LRTrim(rowFamesitid.FADCOGRAG)+"-"+CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL);
          } else { // Else
            /* _datiage := 'Dati AGE: Soggetto '+LRTrim(rowFamesitid.FADNASSEL)+"-"+LRTrim(rowFamesitid.FADPRVSEL)+"-"+DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO */
            _datiage = "Dati AGE: Soggetto "+CPLib.LRTrim(rowFamesitid.FADNASSEL)+"-"+CPLib.LRTrim(rowFamesitid.FADPRVSEL)+"-"+CPLib.DateToChar(rowFamesitid.FADDATNAS)+"-"+rowFamesitid.FADSESSO;
          } // End If
          /* _errore := '* Nominativo non presente in AUI/AGE per il ruolo ('+rowFamesitid.FADRUOLO+') indicato' + iif(not(Empty(_datafinrap)),NL+" (Rapporto chiuso il "+arfn_fdate(_datafinrap)+")","") */
          _errore = "* Nominativo non presente in AUI/AGE per il ruolo ("+rowFamesitid.FADRUOLO+") indicato"+( ! (CPLib.Empty(_datafinrap))?"\n"+" (Rapporto chiuso il "+arfn_fdateR.Make(m_Ctx,this).Run(_datafinrap)+")":"");
        } // End If
        /* If w_flgwrt='M' */
        if (CPLib.eqr(w_flgwrt,"M")) {
          /* mcEsitiErr.AppendBlank() */
          mcEsitiErr.AppendBlank();
          /* mcEsitiErr.UNIQUECODE := _famcodice */
          mcEsitiErr.row.UNIQUECODE = _famcodice;
          /* mcEsitiErr.RAPPORTO := _rapporto */
          mcEsitiErr.row.RAPPORTO = _rapporto;
          /* mcEsitiErr.TIPORAP := 'R' */
          mcEsitiErr.row.TIPORAP = "R";
          /* mcEsitiErr.NDGSOG := rowFamesitid.FADCODFIS */
          mcEsitiErr.row.NDGSOG = rowFamesitid.FADCODFIS;
          /* mcEsitiErr.DATOMIT := '' */
          mcEsitiErr.row.DATOMIT = "";
          /* mcEsitiErr.DATOAGE := _datiage */
          mcEsitiErr.row.DATOAGE = _datiage;
          /* mcEsitiErr.ERRMSG := _errore */
          mcEsitiErr.row.ERRMSG = _errore;
        } else { // Else
          // * --- Insert into tmp_esitierr from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_esitierr");
          m_cPhName = m_Ctx.GetPhName("tmp_esitierr");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitierr",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fammigra_stp",226,"0000059E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000059E(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_famcodice,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowFamesitid.FADCODFIS,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datiage,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitierr",true);
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
      } // End If
    } // End If
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_w_dadata,java.sql.Date p_w_a_data,String p_w_flgwrt,String p_w_flgnoe) {
    w_dadata = p_w_dadata;
    w_a_data = p_w_a_data;
    w_flgwrt = p_w_flgwrt;
    w_flgnoe = p_w_flgnoe;
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
    );
  }
  public String Run(java.sql.Date p_w_dadata,java.sql.Date p_w_a_data,String p_w_flgwrt,String p_w_flgnoe) {
    w_dadata = p_w_dadata;
    w_a_data = p_w_a_data;
    w_flgwrt = p_w_flgwrt;
    w_flgnoe = p_w_flgnoe;
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
  public static arrt_fammigra_stpR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_fammigra_stpR(p_Ctx, p_Caller);
  }
  public static arrt_fammigra_stpR Make(CPContext p_Ctx) {
    return new arrt_fammigra_stpR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_dadata = CPLib.NullDate();
    w_a_data = CPLib.NullDate();
    w_flgwrt = CPLib.Space(1);
    w_flgnoe = CPLib.Space(1);
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
    mcEsitiErr = new MemoryCursor_mcesitierr_mcrdef();
    _paese = CPLib.Space(3);
    _paeseres = CPLib.Space(40);
    _contaerr = 0;
    _valage = CPLib.Space(60);
    mcFamCom = new MemoryCursor_mcfamiglia_mcrdef();
    mcFam0 = new MemoryCursor_mcfamiglia_mcrdef();
    mcFam5 = new MemoryCursor_mcfamiglia_mcrdef();
    mcFam7 = new MemoryCursor_mcfamiglia_mcrdef();
    mcFam8 = new MemoryCursor_mcfamiglia_mcrdef();
    rowFamCom = new MemoryCursorRow_mcfamiglia_mcrdef();
    mcFamesitid = new MemoryCursor_famesitid();
    rowFamesitid = new MemoryCursorRow_famesitid();
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
    _anno = 0;
    _anno1 = CPLib.Space(4);
    _anno2 = CPLib.Space(4);
    _anno3 = CPLib.Space(4);
    _anno4 = CPLib.Space(4);
    _anno5 = CPLib.Space(4);
    _anno6 = CPLib.Space(4);
    _anno7 = CPLib.Space(4);
    _tipoint = 0;
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
  // ENTITY_VQR: ,qbe_famesiti_minmax,qbe_famesiti_migra_sel,qbe_famesiti_jntestbo_minmax,qbe_famesiti_intestbo_minmax,qbe_famesiti_noopex,qbe_famesiti_norapp,qbe_famesiti_jntestbo_minmax,qbe_famesiti_intestbo_minmax,
  public static final String m_cVQRList = ",qbe_famesiti_minmax,qbe_famesiti_migra_sel,qbe_famesiti_jntestbo_minmax,qbe_famesiti_intestbo_minmax,qbe_famesiti_noopex,qbe_famesiti_norapp,qbe_famesiti_jntestbo_minmax,qbe_famesiti_intestbo_minmax,";
  // ENTITY_BATCHES: ,arfn_ae_famiglia,arfn_agechar,arfn_clear_nascita,arfn_fammigra_datamax,arfn_fdate,arfn_fdatetime,arrt_fammigra_stp,
  public static final String i_InvokedRoutines = ",arfn_ae_famiglia,arfn_agechar,arfn_clear_nascita,arfn_fammigra_datamax,arfn_fdate,arfn_fdatetime,arrt_fammigra_stp,";
  public static String[] m_cRunParameterNames={"w_dadata","w_a_data","w_flgwrt","w_flgnoe"};
  protected static String GetFieldsName_000000A9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000DA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000ED(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000104(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000115(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000011F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000131(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000014C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000165(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000171(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000017E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000018A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001D2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001DE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001EA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001F6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001FF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000208(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000021F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000023B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000240(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000241(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000291(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000029D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002E2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002EE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002F9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000030C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000031F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000366(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000372(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003B7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003C3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003CE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003E1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003F4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000043B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000447(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000048C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000498(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000004A3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000004B6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000004C9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000510(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000051C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000561(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000056D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000578(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000058B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000059E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NDGSOG,";
    p_cSql = p_cSql+"DATOMIT,";
    p_cSql = p_cSql+"DATOAGE,";
    p_cSql = p_cSql+"LSTERRORI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitierr",true);
    return p_cSql;
  }
}
