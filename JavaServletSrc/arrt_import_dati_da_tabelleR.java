// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_import_dati_da_tabelleR implements CallerWithObjs {
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
  public String m_cPhName_imp_archope;
  public String m_cServer_imp_archope;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_mogopebo;
  public String m_cServer_mogopebo;
  public String m_cPhName_mlientiope;
  public String m_cServer_mlientiope;
  public String m_cPhName_meneficope;
  public String m_cServer_meneficope;
  public String m_cPhName_merzistiope;
  public String m_cServer_merzistiope;
  public String m_cPhName_imp_archfraz;
  public String m_cServer_imp_archfraz;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_mogopefbo;
  public String m_cServer_mogopefbo;
  public String m_cPhName_mlientifrz;
  public String m_cServer_mlientifrz;
  public String m_cPhName_meneficfrz;
  public String m_cServer_meneficfrz;
  public String m_cPhName_merzistifrz;
  public String m_cServer_merzistifrz;
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
  public MemoryCursor_mcconnes_mcrdef personbo_mc;
  public MemoryCursorRow_mcconnes_mcrdef personbo_row;
  public MemoryCursor_anadip anadip_mc;
  public MemoryCursor_tbcauana tbcausana_mc;
  public MemoryCursor_tbcitta tbcitta_mc;
  public MemoryCursor_tmp_errimp mcErrori;
  public double _conteggio;
  public double _conteggio2;
  public double _attuale;
  public String _codinter;
  public String _citinter;
  public String _cabinter;
  public String _prvinter;
  public String _flgmodi;
  public double _flgdataim;
  public String _frapcli;
  public String gMsgProc;
  public String gMsgImp;
  public String gAzienda;
  public double cNumNew;
  public String _coddip;
  public String _descerr;
  public double _findsub;
  public String _intercod;
  public String _intercit;
  public String _intercab;
  public String _interprv;
  public String _unicode;
  public double _esito;
  public String _rifimp;
  public String _idreg;
  public String stringaflagrap2;
  public String _numprog;
  public String _flagrap2;
  public String _oldidb;
  public String cFlagLire;
  public java.sql.Date _datareg;
  public String cFlagCont;
  public String cFlagFraz;
  public String _colleg;
  public String cIdCau;
  public double nProgImp;
  public double conta;
  public double _totin;
  public double _totout;
  public String cOpeProg1;
  public String cOpeProg2;
  public String _statoreg;
  public java.sql.Date _datarett;
  public String _idb2;
  public String _benrag;
  public String _bensta;
  public String _bencta;
  public String _bencab;
  public String _benprv;
  public String _benind;
  public String _bencap;
  public double _opeerr;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _cicli;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public double _generr;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_import_dati_da_tabelleR (CPContext p_ContextObject, Caller caller) {
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
    m_MessageSink = CPMessageSink.SinkFromCaller(m_Caller);
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_import_dati_da_tabelle",m_Caller);
    m_cPhName_imp_archope = p_ContextObject.GetPhName("imp_archope");
    if (m_cPhName_imp_archope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_imp_archope = m_cPhName_imp_archope+" "+m_Ctx.GetWritePhName("imp_archope");
    }
    m_cServer_imp_archope = p_ContextObject.GetServer("imp_archope");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_beneficope = p_ContextObject.GetPhName("beneficope");
    if (m_cPhName_beneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficope = m_cPhName_beneficope+" "+m_Ctx.GetWritePhName("beneficope");
    }
    m_cServer_beneficope = p_ContextObject.GetServer("beneficope");
    m_cPhName_terzistiope = p_ContextObject.GetPhName("terzistiope");
    if (m_cPhName_terzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistiope = m_cPhName_terzistiope+" "+m_Ctx.GetWritePhName("terzistiope");
    }
    m_cServer_terzistiope = p_ContextObject.GetServer("terzistiope");
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
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    if (m_cPhName_tbcauana.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcauana = m_cPhName_tbcauana+" "+m_Ctx.GetWritePhName("tbcauana");
    }
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_mogopebo = p_ContextObject.GetPhName("mogopebo");
    if (m_cPhName_mogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mogopebo = m_cPhName_mogopebo+" "+m_Ctx.GetWritePhName("mogopebo");
    }
    m_cServer_mogopebo = p_ContextObject.GetServer("mogopebo");
    m_cPhName_mlientiope = p_ContextObject.GetPhName("mlientiope");
    if (m_cPhName_mlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mlientiope = m_cPhName_mlientiope+" "+m_Ctx.GetWritePhName("mlientiope");
    }
    m_cServer_mlientiope = p_ContextObject.GetServer("mlientiope");
    m_cPhName_meneficope = p_ContextObject.GetPhName("meneficope");
    if (m_cPhName_meneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_meneficope = m_cPhName_meneficope+" "+m_Ctx.GetWritePhName("meneficope");
    }
    m_cServer_meneficope = p_ContextObject.GetServer("meneficope");
    m_cPhName_merzistiope = p_ContextObject.GetPhName("merzistiope");
    if (m_cPhName_merzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_merzistiope = m_cPhName_merzistiope+" "+m_Ctx.GetWritePhName("merzistiope");
    }
    m_cServer_merzistiope = p_ContextObject.GetServer("merzistiope");
    m_cPhName_imp_archfraz = p_ContextObject.GetPhName("imp_archfraz");
    if (m_cPhName_imp_archfraz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_imp_archfraz = m_cPhName_imp_archfraz+" "+m_Ctx.GetWritePhName("imp_archfraz");
    }
    m_cServer_imp_archfraz = p_ContextObject.GetServer("imp_archfraz");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_terzistifrz = p_ContextObject.GetPhName("terzistifrz");
    if (m_cPhName_terzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistifrz = m_cPhName_terzistifrz+" "+m_Ctx.GetWritePhName("terzistifrz");
    }
    m_cServer_terzistifrz = p_ContextObject.GetServer("terzistifrz");
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    if (m_cPhName_beneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficfrz = m_cPhName_beneficfrz+" "+m_Ctx.GetWritePhName("beneficfrz");
    }
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    if (m_cPhName_sogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopefbo = m_cPhName_sogopefbo+" "+m_Ctx.GetWritePhName("sogopefbo");
    }
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    m_cPhName_mogopefbo = p_ContextObject.GetPhName("mogopefbo");
    if (m_cPhName_mogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mogopefbo = m_cPhName_mogopefbo+" "+m_Ctx.GetWritePhName("mogopefbo");
    }
    m_cServer_mogopefbo = p_ContextObject.GetServer("mogopefbo");
    m_cPhName_mlientifrz = p_ContextObject.GetPhName("mlientifrz");
    if (m_cPhName_mlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mlientifrz = m_cPhName_mlientifrz+" "+m_Ctx.GetWritePhName("mlientifrz");
    }
    m_cServer_mlientifrz = p_ContextObject.GetServer("mlientifrz");
    m_cPhName_meneficfrz = p_ContextObject.GetPhName("meneficfrz");
    if (m_cPhName_meneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_meneficfrz = m_cPhName_meneficfrz+" "+m_Ctx.GetWritePhName("meneficfrz");
    }
    m_cServer_meneficfrz = p_ContextObject.GetServer("meneficfrz");
    m_cPhName_merzistifrz = p_ContextObject.GetPhName("merzistifrz");
    if (m_cPhName_merzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_merzistifrz = m_cPhName_merzistifrz+" "+m_Ctx.GetWritePhName("merzistifrz");
    }
    m_cServer_merzistifrz = p_ContextObject.GetServer("merzistifrz");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conteggio",p_cVarName)) {
      return _conteggio;
    }
    if (CPLib.eqr("_conteggio2",p_cVarName)) {
      return _conteggio2;
    }
    if (CPLib.eqr("_attuale",p_cVarName)) {
      return _attuale;
    }
    if (CPLib.eqr("_flgdataim",p_cVarName)) {
      return _flgdataim;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      return cNumNew;
    }
    if (CPLib.eqr("_findsub",p_cVarName)) {
      return _findsub;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("_totin",p_cVarName)) {
      return _totin;
    }
    if (CPLib.eqr("_totout",p_cVarName)) {
      return _totout;
    }
    if (CPLib.eqr("_opeerr",p_cVarName)) {
      return _opeerr;
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
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      return _contacicli;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_generr",p_cVarName)) {
      return _generr;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_import_dati_da_tabelle";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
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
    if (CPLib.eqr("_flgmodi",p_cVarName)) {
      return _flgmodi;
    }
    if (CPLib.eqr("_frapcli",p_cVarName)) {
      return _frapcli;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
    }
    if (CPLib.eqr("_descerr",p_cVarName)) {
      return _descerr;
    }
    if (CPLib.eqr("_intercod",p_cVarName)) {
      return _intercod;
    }
    if (CPLib.eqr("_intercit",p_cVarName)) {
      return _intercit;
    }
    if (CPLib.eqr("_intercab",p_cVarName)) {
      return _intercab;
    }
    if (CPLib.eqr("_interprv",p_cVarName)) {
      return _interprv;
    }
    if (CPLib.eqr("_unicode",p_cVarName)) {
      return _unicode;
    }
    if (CPLib.eqr("_rifimp",p_cVarName)) {
      return _rifimp;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      return _idreg;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      return stringaflagrap2;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      return _numprog;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      return _flagrap2;
    }
    if (CPLib.eqr("_oldidb",p_cVarName)) {
      return _oldidb;
    }
    if (CPLib.eqr("cFlagLire",p_cVarName)) {
      return cFlagLire;
    }
    if (CPLib.eqr("cFlagCont",p_cVarName)) {
      return cFlagCont;
    }
    if (CPLib.eqr("cFlagFraz",p_cVarName)) {
      return cFlagFraz;
    }
    if (CPLib.eqr("_colleg",p_cVarName)) {
      return _colleg;
    }
    if (CPLib.eqr("cIdCau",p_cVarName)) {
      return cIdCau;
    }
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      return cOpeProg1;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      return cOpeProg2;
    }
    if (CPLib.eqr("_statoreg",p_cVarName)) {
      return _statoreg;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      return _idb2;
    }
    if (CPLib.eqr("_benrag",p_cVarName)) {
      return _benrag;
    }
    if (CPLib.eqr("_bensta",p_cVarName)) {
      return _bensta;
    }
    if (CPLib.eqr("_bencta",p_cVarName)) {
      return _bencta;
    }
    if (CPLib.eqr("_bencab",p_cVarName)) {
      return _bencab;
    }
    if (CPLib.eqr("_benprv",p_cVarName)) {
      return _benprv;
    }
    if (CPLib.eqr("_benind",p_cVarName)) {
      return _benind;
    }
    if (CPLib.eqr("_bencap",p_cVarName)) {
      return _bencap;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_datareg",p_cVarName)) {
      return _datareg;
    }
    if (CPLib.eqr("_datarett",p_cVarName)) {
      return _datarett;
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
    if (CPLib.eqr("personbo_mc",p_cVarName)) {
      return personbo_mc;
    }
    if (CPLib.eqr("anadip_mc",p_cVarName)) {
      return anadip_mc;
    }
    if (CPLib.eqr("tbcausana_mc",p_cVarName)) {
      return tbcausana_mc;
    }
    if (CPLib.eqr("tbcitta_mc",p_cVarName)) {
      return tbcitta_mc;
    }
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      return mcErrori;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("personbo_row",p_cVarName)) {
      return personbo_row;
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
    if (CPLib.eqr("_conteggio",p_cVarName)) {
      _conteggio = value;
      return;
    }
    if (CPLib.eqr("_conteggio2",p_cVarName)) {
      _conteggio2 = value;
      return;
    }
    if (CPLib.eqr("_attuale",p_cVarName)) {
      _attuale = value;
      return;
    }
    if (CPLib.eqr("_flgdataim",p_cVarName)) {
      _flgdataim = value;
      return;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      cNumNew = value;
      return;
    }
    if (CPLib.eqr("_findsub",p_cVarName)) {
      _findsub = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("_totin",p_cVarName)) {
      _totin = value;
      return;
    }
    if (CPLib.eqr("_totout",p_cVarName)) {
      _totout = value;
      return;
    }
    if (CPLib.eqr("_opeerr",p_cVarName)) {
      _opeerr = value;
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
    if (CPLib.eqr("_generr",p_cVarName)) {
      _generr = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
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
    if (CPLib.eqr("_flgmodi",p_cVarName)) {
      _flgmodi = value;
      return;
    }
    if (CPLib.eqr("_frapcli",p_cVarName)) {
      _frapcli = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
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
    if (CPLib.eqr("_coddip",p_cVarName)) {
      _coddip = value;
      return;
    }
    if (CPLib.eqr("_descerr",p_cVarName)) {
      _descerr = value;
      return;
    }
    if (CPLib.eqr("_intercod",p_cVarName)) {
      _intercod = value;
      return;
    }
    if (CPLib.eqr("_intercit",p_cVarName)) {
      _intercit = value;
      return;
    }
    if (CPLib.eqr("_intercab",p_cVarName)) {
      _intercab = value;
      return;
    }
    if (CPLib.eqr("_interprv",p_cVarName)) {
      _interprv = value;
      return;
    }
    if (CPLib.eqr("_unicode",p_cVarName)) {
      _unicode = value;
      return;
    }
    if (CPLib.eqr("_rifimp",p_cVarName)) {
      _rifimp = value;
      return;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      _idreg = value;
      return;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      stringaflagrap2 = value;
      return;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      _numprog = value;
      return;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      _flagrap2 = value;
      return;
    }
    if (CPLib.eqr("_oldidb",p_cVarName)) {
      _oldidb = value;
      return;
    }
    if (CPLib.eqr("cFlagLire",p_cVarName)) {
      cFlagLire = value;
      return;
    }
    if (CPLib.eqr("cFlagCont",p_cVarName)) {
      cFlagCont = value;
      return;
    }
    if (CPLib.eqr("cFlagFraz",p_cVarName)) {
      cFlagFraz = value;
      return;
    }
    if (CPLib.eqr("_colleg",p_cVarName)) {
      _colleg = value;
      return;
    }
    if (CPLib.eqr("cIdCau",p_cVarName)) {
      cIdCau = value;
      return;
    }
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      cOpeProg1 = value;
      return;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      cOpeProg2 = value;
      return;
    }
    if (CPLib.eqr("_statoreg",p_cVarName)) {
      _statoreg = value;
      return;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      _idb2 = value;
      return;
    }
    if (CPLib.eqr("_benrag",p_cVarName)) {
      _benrag = value;
      return;
    }
    if (CPLib.eqr("_bensta",p_cVarName)) {
      _bensta = value;
      return;
    }
    if (CPLib.eqr("_bencta",p_cVarName)) {
      _bencta = value;
      return;
    }
    if (CPLib.eqr("_bencab",p_cVarName)) {
      _bencab = value;
      return;
    }
    if (CPLib.eqr("_benprv",p_cVarName)) {
      _benprv = value;
      return;
    }
    if (CPLib.eqr("_benind",p_cVarName)) {
      _benind = value;
      return;
    }
    if (CPLib.eqr("_bencap",p_cVarName)) {
      _bencap = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_datareg",p_cVarName)) {
      _datareg = value;
      return;
    }
    if (CPLib.eqr("_datarett",p_cVarName)) {
      _datarett = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("personbo_row",p_cVarName)) {
      personbo_row = (MemoryCursorRow_mcconnes_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("personbo_mc",p_cVarName)) {
      personbo_mc = (MemoryCursor_mcconnes_mcrdef)value;
      return;
    }
    if (CPLib.eqr("anadip_mc",p_cVarName)) {
      anadip_mc = (MemoryCursor_anadip)value;
      return;
    }
    if (CPLib.eqr("tbcausana_mc",p_cVarName)) {
      tbcausana_mc = (MemoryCursor_tbcauana)value;
      return;
    }
    if (CPLib.eqr("tbcitta_mc",p_cVarName)) {
      tbcitta_mc = (MemoryCursor_tbcitta)value;
      return;
    }
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      mcErrori = (MemoryCursor_tmp_errimp)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_tbcauana=null;
    CPResultSet Cursor_tbcitta=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_imp_archope=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_terzistiope=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_qbe_imp_archfraz_minmax=null;
    CPResultSet Cursor_imp_archfraz=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_terzistifrz=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* personbo_mc MemoryCursor(mcConnes.MCRDef) // memory cursor dei connes delle anagrafiche */
      /* personbo_row Row(mcConnes.MCRDef) // row del connes dell'anagrafica */
      /* anadip_mc MemoryCursor(anadip) // memory cursor dipendenze */
      /* tbcausana_mc MemoryCursor(tbcauana) // causali analitiche */
      /* tbcitta_mc MemoryCursor(tbcitta) // memory cursor della tabella delle citta */
      /* mcErrori MemoryCursor(tmp_errimp) // Memori cursor per errori */
      /* _conteggio Numeric(3, 0) */
      /* _conteggio2 Numeric(3, 0) */
      /* _attuale Numeric(3, 0) */
      /* Status Msg 'Creo MC causale anlitica' */
      m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Creo MC causale anlitica"));
      // * --- Fill memory cursor tbcausana_mc on tbcauana
      tbcausana_mc.Zap();
      m_cServer = m_Ctx.GetServer("tbcauana");
      m_cPhName = m_Ctx.GetPhName("tbcauana");
      if (Cursor_tbcauana!=null)
        Cursor_tbcauana.Close();
      Cursor_tbcauana = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbcauana")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbcauana;
        Cursor_tbcauana.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_dati_da_tabelle: query on tbcauana returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbcauana.Eof())) {
        tbcausana_mc.AppendWithTrimmedKey(CPLib.Left(CPLib.LRTrim(Cursor_tbcauana.GetString("CODCAU"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_tbcauana.GetString("CAUSINT"))+CPLib.Space(2),2));
        tbcausana_mc.row.idbase = Cursor_tbcauana.GetString("idbase");
        tbcausana_mc.row.DESCRI = Cursor_tbcauana.GetString("DESCRI");
        tbcausana_mc.row.CODCAU = Cursor_tbcauana.GetString("CODCAU");
        tbcausana_mc.row.SEGNO = Cursor_tbcauana.GetString("SEGNO");
        tbcausana_mc.row.CAUSINT = Cursor_tbcauana.GetString("CAUSINT");
        tbcausana_mc.row.DATAVALI = Cursor_tbcauana.GetDate("DATAVALI");
        tbcausana_mc.row.VALPERINT = Cursor_tbcauana.GetString("VALPERINT");
        tbcausana_mc.row.DATINI = Cursor_tbcauana.GetDate("DATINI");
        tbcausana_mc.row.FLGINTER = Cursor_tbcauana.GetString("FLGINTER");
        tbcausana_mc.row.MITBASE = Cursor_tbcauana.GetString("MITBASE");
        tbcausana_mc.row.USEBASE = Cursor_tbcauana.GetString("USEBASE");
        tbcausana_mc.row.NOSARA = Cursor_tbcauana.GetString("NOSARA");
        Cursor_tbcauana.Next();
      }
      m_cConnectivityError = Cursor_tbcauana.ErrorMessage();
      Cursor_tbcauana.Close();
      tbcausana_mc.GoTop();
      /* _conteggio2 := tbcausana_mc.RecCount() */
      _conteggio2 = CPLib.Round(tbcausana_mc.RecCount(),0);
      System.out.println("Mccausali "+_conteggio2);
      /* Status Msg 'Creo MC città' */
      m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Creo MC città"));
      // * --- Fill memory cursor tbcitta_mc on tbcitta
      tbcitta_mc.Zap();
      m_cServer = m_Ctx.GetServer("tbcitta");
      m_cPhName = m_Ctx.GetPhName("tbcitta");
      if (Cursor_tbcitta!=null)
        Cursor_tbcitta.Close();
      Cursor_tbcitta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbcitta")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbcitta;
        Cursor_tbcitta.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,10000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_dati_da_tabelle: query on tbcitta returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 10000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbcitta.Eof())) {
        tbcitta_mc.AppendBlank();
        tbcitta_mc.row.IDBASE = Cursor_tbcitta.GetString("IDBASE");
        tbcitta_mc.row.CITTA = Cursor_tbcitta.GetString("CITTA");
        tbcitta_mc.row.CAB = Cursor_tbcitta.GetString("CAB");
        tbcitta_mc.row.PROV = Cursor_tbcitta.GetString("PROV");
        tbcitta_mc.row.CAP = Cursor_tbcitta.GetString("CAP");
        tbcitta_mc.row.PKTBSTATI = Cursor_tbcitta.GetString("PKTBSTATI");
        tbcitta_mc.row.SIGLA = Cursor_tbcitta.GetString("SIGLA");
        tbcitta_mc.row.PREF = Cursor_tbcitta.GetString("PREF");
        tbcitta_mc.row.IDTBLS = Cursor_tbcitta.GetString("IDTBLS");
        tbcitta_mc.row.IDCITTA = Cursor_tbcitta.GetString("IDCITTA");
        tbcitta_mc.row.IDISTAT = Cursor_tbcitta.GetString("IDISTAT");
        tbcitta_mc.row.IDREGIO = Cursor_tbcitta.GetString("IDREGIO");
        tbcitta_mc.row.DATAINI = Cursor_tbcitta.GetDate("DATAINI");
        tbcitta_mc.row.DATAFIN = Cursor_tbcitta.GetDate("DATAFIN");
        Cursor_tbcitta.Next();
      }
      m_cConnectivityError = Cursor_tbcitta.ErrorMessage();
      Cursor_tbcitta.Close();
      tbcitta_mc.GoTop();
      /* _conteggio2 := tbcitta_mc.RecCount() */
      _conteggio2 = CPLib.Round(tbcitta_mc.RecCount(),0);
      System.out.println("Mccitta "+_conteggio2);
      /* Status Msg 'Creo MC dipendenze' */
      m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Creo MC dipendenze"));
      // * --- Fill memory cursor anadip_mc on anadip
      anadip_mc.Zap();
      m_cServer = m_Ctx.GetServer("anadip");
      m_cPhName = m_Ctx.GetPhName("anadip");
      if (Cursor_anadip!=null)
        Cursor_anadip.Close();
      Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("anadip")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_anadip;
        Cursor_anadip.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_dati_da_tabelle: query on anadip returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_anadip.Eof())) {
        anadip_mc.AppendWithTrimmedKey(Cursor_anadip.GetString("CODDIP"));
        anadip_mc.row.CODDIP = Cursor_anadip.GetString("CODDIP");
        anadip_mc.row.DESCRIZ = Cursor_anadip.GetString("DESCRIZ");
        anadip_mc.row.IDCITTA = Cursor_anadip.GetString("IDCITTA");
        anadip_mc.row.DESCCIT = Cursor_anadip.GetString("DESCCIT");
        anadip_mc.row.PROVINCIA = Cursor_anadip.GetString("PROVINCIA");
        anadip_mc.row.CAB = Cursor_anadip.GetString("CAB");
        anadip_mc.row.IDBASE = Cursor_anadip.GetString("IDBASE");
        anadip_mc.row.AGENTE = Cursor_anadip.GetString("AGENTE");
        anadip_mc.row.MACROAGENTE = Cursor_anadip.GetString("MACROAGENTE");
        anadip_mc.row.TERMINALID = Cursor_anadip.GetString("TERMINALID");
        anadip_mc.row.DOMICILIO = Cursor_anadip.GetString("DOMICILIO");
        anadip_mc.row.TELEFONO = Cursor_anadip.GetString("TELEFONO");
        anadip_mc.row.CODLOC = Cursor_anadip.GetString("CODLOC");
        anadip_mc.row.ABICABSARA = Cursor_anadip.GetString("ABICABSARA");
        anadip_mc.row.NUOVO = Cursor_anadip.GetString("NUOVO");
        anadip_mc.row.CAP = Cursor_anadip.GetString("CAP");
        anadip_mc.row.AGACCODE = Cursor_anadip.GetString("AGACCODE");
        anadip_mc.row.NAZAGENTE = Cursor_anadip.GetString("NAZAGENTE");
        anadip_mc.row.OPXSOSCLI = Cursor_anadip.GetDouble("OPXSOSCLI");
        anadip_mc.row.OPXSOSAGE = Cursor_anadip.GetDouble("OPXSOSAGE");
        anadip_mc.row.VALCOMPL = Cursor_anadip.GetString("VALCOMPL");
        anadip_mc.row.ANOMOPER = Cursor_anadip.GetString("ANOMOPER");
        anadip_mc.row.AGEREGIO = Cursor_anadip.GetString("AGEREGIO");
        anadip_mc.row.FLGATT = Cursor_anadip.GetString("FLGATT");
        anadip_mc.row.CODAGE = Cursor_anadip.GetString("CODAGE");
        anadip_mc.row.TIPOSV = Cursor_anadip.GetString("TIPOSV");
        anadip_mc.row.FLGNOAUA = Cursor_anadip.GetString("FLGNOAUA");
        anadip_mc.row.FLGWUPOS = Cursor_anadip.GetString("FLGWUPOS");
        anadip_mc.row.CATEG01 = Cursor_anadip.GetString("CATEG01");
        anadip_mc.row.CATEG02 = Cursor_anadip.GetString("CATEG02");
        anadip_mc.row.CATEG03 = Cursor_anadip.GetString("CATEG03");
        anadip_mc.row.CATEG04 = Cursor_anadip.GetString("CATEG04");
        anadip_mc.row.CATEG05 = Cursor_anadip.GetString("CATEG05");
        anadip_mc.row.CATEGORIA = Cursor_anadip.GetString("CATEGORIA");
        anadip_mc.row.CAB2 = Cursor_anadip.GetString("CAB2");
        anadip_mc.row.RISGLOB = Cursor_anadip.GetString("RISGLOB");
        anadip_mc.row.DATAPROF = Cursor_anadip.GetDate("DATAPROF");
        anadip_mc.row.CODICEAAMS = Cursor_anadip.GetString("CODICEAAMS");
        anadip_mc.row.CONCESSIONE = Cursor_anadip.GetString("CONCESSIONE");
        anadip_mc.row.CODFISC = Cursor_anadip.GetString("CODFISC");
        anadip_mc.row.PARTIVA = Cursor_anadip.GetString("PARTIVA");
        anadip_mc.row.TIPOAGENTE = Cursor_anadip.GetString("TIPOAGENTE");
        anadip_mc.row.NUMCIVICO = Cursor_anadip.GetString("NUMCIVICO");
        anadip_mc.row.DATAINI = Cursor_anadip.GetDate("DATAINI");
        anadip_mc.row.DATAFINE = Cursor_anadip.GetDate("DATAFINE");
        anadip_mc.row.SERRIMDEN = Cursor_anadip.GetString("SERRIMDEN");
        anadip_mc.row.FLGCOMPL = Cursor_anadip.GetDouble("FLGCOMPL");
        Cursor_anadip.Next();
      }
      m_cConnectivityError = Cursor_anadip.ErrorMessage();
      Cursor_anadip.Close();
      anadip_mc.GoTop();
      /* _conteggio2 := anadip_mc.RecCount() */
      _conteggio2 = CPLib.Round(anadip_mc.RecCount(),0);
      System.out.println("Mcanadip "+_conteggio2);
      /* Status Msg 'Fine generazione Mc. Inizio elaborazione' */
      m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Fine generazione Mc. Inizio elaborazione"));
      /* _conteggio := 0 */
      _conteggio = CPLib.Round(0,0);
      /* Status Msg 'Generazione key su connes' */
      m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Generazione key su connes"));
      System.out.println("Mcpersone  key"+_conteggio);
      // * --- Select from personbo
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      if (Cursor_personbo!=null)
        Cursor_personbo.Close();
      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("personbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_personbo.Eof())) {
        /* personbo_mc.AppendWithKey(LRTrim(personbo->CONNES)) // memory cursor dei connes delle anagrafiche */
        personbo_mc.AppendWithKey(CPLib.LRTrim(Cursor_personbo.GetString("CONNES")));
        /* personbo_mc.connes := personbo->CONNES // memory cursor dei connes delle anagrafiche */
        personbo_mc.row.connes = Cursor_personbo.GetString("CONNES");
        /* _conteggio := _conteggio+1 */
        _conteggio = CPLib.Round(_conteggio+1,0);
        /* Status Msg 'Generazione key su connes numero %1' */
        m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Generazione key su connes numero %1",_conteggio));
        /* If Mod(_conteggio,100)=0 */
        if (CPLib.eqr(CPLib.Mod(_conteggio,100),0)) {
          System.out.println("Mcpersone  key "+_conteggio);
        } // End If
        Cursor_personbo.Next();
      }
      m_cConnectivityError = Cursor_personbo.ErrorMessage();
      Cursor_personbo.Close();
      // * --- End Select
      /* Status Msg 'Fine generazione key su connes' */
      m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Fine generazione key su connes"));
      System.out.println("Mcpersone  key fine"+_conteggio);
      /* _codinter Char(11) */
      /* _citinter Char(30) */
      /* _cabinter Char(6) */
      /* _prvinter Char(2) */
      /* _flgmodi Char(1) */
      /* _flgdataim Numeric(1, 0) */
      /* _frapcli Char(1) */
      /* gMsgProc Char(120) // Messaggio */
      /* gMsgImp Memo // Messaggio Import */
      /* gAzienda Char(10) // Azienda */
      /* cNumNew Numeric(10, 0) */
      /* _coddip Char(6) */
      /* _descerr Char(50) // descrizione errore */
      /* _findsub Numeric(1, 0) // variabile necessaria per saltare i controlli */
      /* _intercod Char(11) */
      /* _intercit Char(30) */
      /* _intercab Char(6) */
      /* _interprv Char(2) */
      /* _unicode Char(10) */
      /* _esito Numeric(1, 0) */
      /* _rifimp Char(11) */
      /* _idreg Char(20) */
      /* stringaflagrap2 Char(9) // stringa di valori di flagrap2 */
      /* _numprog Char(11) */
      /* _flagrap2 Char(1) */
      /* _oldidb Char(10) */
      /* cFlagLire Char(1) */
      /* _datareg Date */
      /* cFlagCont Char(1) */
      /* cFlagFraz Char(1) */
      /* _colleg Char(12) */
      /* cIdCau Char(4) */
      /* nProgImp Numeric(15, 0) */
      /* conta Numeric(10, 0) */
      /* _totin Numeric(15, 0) */
      /* _totout Numeric(15, 0) */
      /* cOpeProg1 Char(10) */
      /* cOpeProg2 Char(11) */
      /* _statoreg Char(1) */
      /* _datarett Date */
      /* _idb2 Char(10) */
      /* _benrag Char(70) */
      /* _bensta Char(3) */
      /* _bencta Char(30) */
      /* _bencab Char(6) */
      /* _benprv Char(2) */
      /* _benind Char(35) */
      /* _bencap Char(5) */
      /* _opeerr Numeric(1, 0) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _generr Numeric(1, 0) */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _codinter := intermbo->CODINTER */
        _codinter = Cursor_intermbo.GetString("CODINTER");
        /* _citinter := intermbo->DESCCIT */
        _citinter = Cursor_intermbo.GetString("DESCCIT");
        /* _cabinter := intermbo->CODCAB */
        _cabinter = Cursor_intermbo.GetString("CODCAB");
        /* _prvinter := intermbo->PROVINCIA */
        _prvinter = Cursor_intermbo.GetString("PROVINCIA");
        /* _flgmodi := intermbo->FLGOPEXTR */
        _flgmodi = Cursor_intermbo.GetString("FLGOPEXTR");
        /* _flgdataim := intermbo->FLGDATAIM */
        _flgdataim = CPLib.Round(Cursor_intermbo.GetDouble("FLGDATAIM"),0);
        /* _frapcli := intermbo->FLGRAPCLI */
        _frapcli = Cursor_intermbo.GetString("FLGRAPCLI");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' delle operazioni' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" delle operazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000006Cstatus;
      nTry0000006Cstatus = m_Sql.GetTransactionStatus();
      String cTry0000006Cmsg;
      cTry0000006Cmsg = m_Sql.TransactionErrorMessage();
      try {
        /* _generr := 0 */
        _generr = CPLib.Round(0,0);
        // * --- Select from imp_archope
        m_cServer = m_Ctx.GetServer("imp_archope");
        m_cPhName = m_Ctx.GetPhName("imp_archope");
        if (Cursor_imp_archope!=null)
          Cursor_imp_archope.Close();
        Cursor_imp_archope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("imp_archope")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_imp_archope.Eof())) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' operazioni ' // Messaggio Import */
          gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" operazioni ";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* Status Msg 'Sto elaborando operazione %1' */
          m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Sto elaborando operazione %1",CPLib.LRTrim(CPLib.Str(conta,10,0))));
          /* _descerr := '' */
          _descerr = "";
          /* _findsub := 1 */
          _findsub = CPLib.Round(1,0);
          /* If not(Empty(LRTrim(imp_archope->CONNESCLI))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("CONNESCLI"))))) {
            /* If not(personbo_mc.GoToKey(LRTrim(imp_archope->CONNESCLI))) */
            if ( ! (personbo_mc.GoToKey(CPLib.LRTrim(Cursor_imp_archope.GetString("CONNESCLI"))))) {
              /* _descerr := 'Anagrafica Intestatario Operazione assente. Inform: '+imp_archope->INFORM */
              _descerr = "Anagrafica Intestatario Operazione assente. Inform: "+Cursor_imp_archope.GetString("INFORM");
              /* _findsub := 0 */
              _findsub = CPLib.Round(0,0);
              /* _generr := 1 */
              _generr = CPLib.Round(1,0);
            } // End If
          } // End If
          /* If not(Empty(LRTrim(imp_archope->CONNESOPER))) and _findsub=1 */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("CONNESOPER")))) && CPLib.eqr(_findsub,1)) {
            /* If not(personbo_mc.GoToKey(imp_archope->CONNESOPER)) */
            if ( ! (personbo_mc.GoToKey(Cursor_imp_archope.GetString("CONNESOPER")))) {
              /* _descerr := iif(Empty(_descerr),'Anagrafica Soggetto Operante Operazione assente',_descerr+' Anagrafica Soggetto Operante Operazione assente') */
              _descerr = (CPLib.Empty(_descerr)?"Anagrafica Soggetto Operante Operazione assente":_descerr+" Anagrafica Soggetto Operante Operazione assente");
              /* _findsub := 0 */
              _findsub = CPLib.Round(0,0);
              /* _generr := 1 */
              _generr = CPLib.Round(1,0);
            } // End If
          } // End If
          /* If not(Empty(LRTrim(imp_archope->CONNESBEN))) and _findsub=1 */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("CONNESBEN")))) && CPLib.eqr(_findsub,1)) {
            /* If not(personbo_mc.GoToKey(imp_archope->CONNESBEN)) */
            if ( ! (personbo_mc.GoToKey(Cursor_imp_archope.GetString("CONNESBEN")))) {
              /* _descerr := iif(Empty(_descerr),'Anagrafica Controparte Operazione assente',_descerr+' Anagrafica Controparte Operazione assente') */
              _descerr = (CPLib.Empty(_descerr)?"Anagrafica Controparte Operazione assente":_descerr+" Anagrafica Controparte Operazione assente");
              /* _findsub := 0 */
              _findsub = CPLib.Round(0,0);
              /* _generr := 1 */
              _generr = CPLib.Round(1,0);
            } // End If
          } // End If
          /* If not(Empty(LRTrim(imp_archope->CONNALTRO))) and _findsub=1 */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("CONNALTRO")))) && CPLib.eqr(_findsub,1)) {
            /* If not(personbo_mc.GoToKey(imp_archope->CONNALTRO)) */
            if ( ! (personbo_mc.GoToKey(Cursor_imp_archope.GetString("CONNALTRO")))) {
              /* _descerr := iif(Empty(_descerr),'Anagrafica Soggetto per conto del quale assente',_descerr+' Anagrafica Soggetto per conto del quale assente') */
              _descerr = (CPLib.Empty(_descerr)?"Anagrafica Soggetto per conto del quale assente":_descerr+" Anagrafica Soggetto per conto del quale assente");
              /* _findsub := 0 */
              _findsub = CPLib.Round(0,0);
              /* _generr := 1 */
              _generr = CPLib.Round(1,0);
            } // End If
          } // End If
          /* If Empty(LRTrim(imp_archope->CONNESCLI)) and Empty(LRTrim(imp_archope->RAPPORTO)) and _findsub = 1 */
          if (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("CONNESCLI"))) && CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("RAPPORTO"))) && CPLib.eqr(_findsub,1)) {
            /* _descerr := 'Rapporto continuativo o Intestatario Operazione assente' */
            _descerr = "Rapporto continuativo o Intestatario Operazione assente";
            /* _findsub := 0 */
            _findsub = CPLib.Round(0,0);
            /* _generr := 1 */
            _generr = CPLib.Round(1,0);
          } // End If
          /* If _findsub=1 */
          if (CPLib.eqr(_findsub,1)) {
            /* _intercod := iif(Empty(LRTrim(imp_archope->CODINTER)),_codinter,imp_archope->CODINTER) */
            _intercod = (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("CODINTER")))?_codinter:Cursor_imp_archope.GetString("CODINTER"));
            /* _intercit := iif(Empty(LRTrim(imp_archope->DESCCIT)),_citinter,imp_archope->DESCCIT) */
            _intercit = (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("DESCCIT")))?_citinter:Cursor_imp_archope.GetString("DESCCIT"));
            /* _intercab := iif(Empty(LRTrim(imp_archope->CODCAB)),_cabinter,imp_archope->CODCAB) */
            _intercab = (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("CODCAB")))?_cabinter:Cursor_imp_archope.GetString("CODCAB"));
            /* _interprv := iif(Empty(LRTrim(imp_archope->PROVINCIA)),_prvinter,imp_archope->PROVINCIA) */
            _interprv = (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("PROVINCIA")))?_prvinter:Cursor_imp_archope.GetString("PROVINCIA"));
            /* If not(Empty(LRTrim(imp_archope->CODDIPE))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("CODDIPE"))))) {
              /* If anadip_mc.GoToKey(imp_archope->CODDIPE) */
              if (anadip_mc.GoToKey(Cursor_imp_archope.GetString("CODDIPE"))) {
                /* _coddip := anadip_mc.CODDIP */
                _coddip = anadip_mc.row.CODDIP;
                /* _intercit := anadip_mc.DESCCIT */
                _intercit = anadip_mc.row.DESCCIT;
                /* _intercab := anadip_mc.CAB */
                _intercab = anadip_mc.row.CAB;
                /* _interprv := anadip_mc.PROVINCIA */
                _interprv = anadip_mc.row.PROVINCIA;
              } else { // Else
                /* gMsgProc := gMsgProc +"Rilevati errori nella tabella delle operazioni per l'operazione in data "+CharToDate(imp_archope->DATAOPE)+" con importo "+Str((Val(imp_archope->TOTLIRE))/100,14,2)+" si è indicata la dipendenza con codice: " + LRTrim(imp_archope->CODDIPE)+" non è prensente  in anagrafica dipendenze." +" Ricreare il file ARCHDIP e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annullata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nella tabella delle operazioni per l'operazione in data "+CPLib.CharToDate(Cursor_imp_archope.GetString("DATAOPE"))+" con importo "+CPLib.Str((CPLib.Val(Cursor_imp_archope.GetString("TOTLIRE")))/100,14,2)+" si è indicata la dipendenza con codice: "+CPLib.LRTrim(Cursor_imp_archope.GetString("CODDIPE"))+" non è prensente  in anagrafica dipendenze."+" Ricreare il file ARCHDIP e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annullata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                // Exit Loop
                if (true) {
                  break;
                }
              } // End If
              /* If not(Empty(LRTrim(imp_archope->DESCCIT)+LRTrim(imp_archope->CODCAB)+LRTrim(imp_archope->PROVINCIA))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("DESCCIT"))+CPLib.LRTrim(Cursor_imp_archope.GetString("CODCAB"))+CPLib.LRTrim(Cursor_imp_archope.GetString("PROVINCIA"))))) {
                /* _intercit := LRTrim(imp_archope->DESCCIT) */
                _intercit = CPLib.LRTrim(Cursor_imp_archope.GetString("DESCCIT"));
                /* _intercab := LRTrim(imp_archope->CODCAB) */
                _intercab = CPLib.LRTrim(Cursor_imp_archope.GetString("CODCAB"));
                /* _interprv := LRTrim(imp_archope->PROVINCIA) */
                _interprv = CPLib.LRTrim(Cursor_imp_archope.GetString("PROVINCIA"));
              } // End If
            } // End If
            /* Verifico la presenza dell'_unicode per evitare duplicazioni di informazioni diverse con lo stesso _unicode */
            /* _unicode := '' */
            _unicode = "";
            /* If Len(LRTrim(imp_archope->UNIQUECODE)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(Cursor_imp_archope.GetString("UNIQUECODE"))),0)) {
              // * --- Read from operazbo
              m_cServer = m_Ctx.GetServer("operazbo");
              m_cPhName = m_Ctx.GetPhName("operazbo");
              m_cSql = "";
              m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_archope.GetString("UNIQUECODE"),"C",7,0,m_cServer),m_cServer,Cursor_imp_archope.GetString("UNIQUECODE"));
              if (m_Ctx.IsSharedTemp("operazbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _unicode = Read_Cursor.GetString("UNIQUECODE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on operazbo into routine arrt_import_dati_da_tabelle returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _unicode = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_unicode)) > 0 */
              if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_unicode)),0)) {
                /* gMsgProc := gMsgProc +"Rilevati errori nella tabella delle operazioni per l'operazione in data "+CharToDate(imp_archope->DATAOPE)+" con importo "+Str((Val(imp_archope->TOTLIRE))/100,14,2)+". L'attuale procedura di importazione verrà annullata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nella tabella delle operazioni per l'operazione in data "+CPLib.CharToDate(Cursor_imp_archope.GetString("DATAOPE"))+" con importo "+CPLib.Str((CPLib.Val(Cursor_imp_archope.GetString("TOTLIRE")))/100,14,2)+". L'attuale procedura di importazione verrà annullata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                // Transaction Error
                cTry0000006Cmsg = CPLib.FormatMsg(m_Ctx,"'%1'",gMsgProc);
                m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"'%1'",gMsgProc));
                // Exit Loop
                if (true) {
                  break;
                }
              } // End If
            } // End If
            /* _rifimp := '' */
            _rifimp = "";
            /* _idreg := '' */
            _idreg = "";
            /* stringaflagrap2 := _flagrap2 // stringa di valori di flagrap2 */
            stringaflagrap2 = _flagrap2;
            /* _numprog := '' */
            _numprog = "";
            /* If Len(LRTrim(imp_archope->RIFIMP)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(Cursor_imp_archope.GetString("RIFIMP"))),0)) {
              /* If Upper(imp_archope->RIFIMP)='XXXXXXXXX' */
              if (CPLib.eqr(CPLib.Upper(Cursor_imp_archope.GetString("RIFIMP")),"XXXXXXXXX")) {
                // * --- Select from operazbo
                m_cServer = m_Ctx.GetServer("operazbo");
                m_cPhName = m_Ctx.GetPhName("operazbo");
                if (Cursor_operazbo!=null)
                  Cursor_operazbo.Close();
                Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMPROG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"INFORM = "+CPLib.ToSQL(Cursor_imp_archope.GetString("INFORM"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_operazbo.Eof())) {
                  /* _numprog := operazbo->NUMPROG */
                  _numprog = Cursor_operazbo.GetString("NUMPROG");
                  Cursor_operazbo.Next();
                }
                m_cConnectivityError = Cursor_operazbo.ErrorMessage();
                Cursor_operazbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from operazbo
                m_cServer = m_Ctx.GetServer("operazbo");
                m_cPhName = m_Ctx.GetPhName("operazbo");
                if (Cursor_operazbo!=null)
                  Cursor_operazbo.Close();
                Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMPROG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RIFIMP = "+CPLib.ToSQL(Cursor_imp_archope.GetString("RIFIMP"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_operazbo.Eof())) {
                  /* _numprog := operazbo->NUMPROG */
                  _numprog = Cursor_operazbo.GetString("NUMPROG");
                  Cursor_operazbo.Next();
                }
                m_cConnectivityError = Cursor_operazbo.ErrorMessage();
                Cursor_operazbo.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If not(Empty(LRTrim(_numprog))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(_numprog)))) {
              /* If Empty(LRTrim(imp_archope->DATAOPE)) or IsNull(imp_archope->DATAOPE) */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("DATAOPE"))) || Cursor_imp_archope.IsNull("DATAOPE")) {
                /* cNumNew := cNumNew + 1 */
                cNumNew = CPLib.Round(cNumNew+1,0);
                // * --- Select from operazbo
                m_cServer = m_Ctx.GetServer("operazbo");
                m_cPhName = m_Ctx.GetPhName("operazbo");
                if (Cursor_operazbo!=null)
                  Cursor_operazbo.Close();
                Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer, m_oParameters),m_cServer,_numprog)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_operazbo.Eof())) {
                  /* gMsgImp := "E' stata cancellata l'operazione con codice "+_numprog // Messaggio Import */
                  gMsgImp = "E' stata cancellata l'operazione con codice "+_numprog;
                  m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  // * --- Write into operazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("operazbo");
                  m_cPhName = m_Ctx.GetPhName("operazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000000B8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("2","C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_operazbo.GetString("IDBASE"))+"";
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
              } else { // Else
                /* stringaflagrap2 := 'ABCDEFGHI' // stringa di valori di flagrap2 */
                stringaflagrap2 = "ABCDEFGHI";
                /* gMsgImp := "E' stata variata l'operazione con codice "+_numprog // Messaggio Import */
                gMsgImp = "E' stata variata l'operazione con codice "+_numprog;
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* Stranezza su idreg da vericare se corretto averlo aggiunto nella quey sottostante */
                // * --- Select from operazbo
                m_cServer = m_Ctx.GetServer("operazbo");
                m_cPhName = m_Ctx.GetPhName("operazbo");
                if (Cursor_operazbo!=null)
                  Cursor_operazbo.Close();
                Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,NUMPROG,DATAOPE,FLAGRAP2,IDEREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer, m_oParameters),m_cServer,_numprog)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_operazbo.Eof())) {
                  /* _oldidb := operazbo->IDBASE */
                  _oldidb = Cursor_operazbo.GetString("IDBASE");
                  /* _flagrap2 := iif(Empty(operazbo->FLAGRAP2) or operazbo->FLAGRAP2='S',Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(operazbo->FLAGRAP2,stringaflagrap2)+1),1)) */
                  _flagrap2 = (CPLib.Empty(Cursor_operazbo.GetString("FLAGRAP2")) || CPLib.eqr(Cursor_operazbo.GetString("FLAGRAP2"),"S")?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(Cursor_operazbo.GetString("FLAGRAP2"),stringaflagrap2)+1),1));
                  /* _idreg := operazbo->IDEREG */
                  _idreg = Cursor_operazbo.GetString("IDEREG");
                  // * --- Write into operazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("operazbo");
                  m_cPhName = m_Ctx.GetPhName("operazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000000C0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                  m_cSql = m_cSql+"FLAGRAP2 = "+CPLib.ToSQL(_flagrap2,"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_operazbo.GetString("IDBASE"))+"";
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
                  // * --- Select from sogopebo
                  m_cServer = m_Ctx.GetServer("sogopebo");
                  m_cPhName = m_Ctx.GetPhName("sogopebo");
                  if (Cursor_sogopebo!=null)
                    Cursor_sogopebo.Close();
                  Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_sogopebo.Eof())) {
                    // * --- Insert into mogopebo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("mogopebo");
                    m_cPhName = m_Ctx.GetPhName("mogopebo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mogopebo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000000C2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000C2(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mogopebo",true);
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
                    Cursor_sogopebo.Next();
                  }
                  m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
                  Cursor_sogopebo.Close();
                  // * --- End Select
                  // * --- Select from clientiope
                  m_cServer = m_Ctx.GetServer("clientiope");
                  m_cPhName = m_Ctx.GetPhName("clientiope");
                  if (Cursor_clientiope!=null)
                    Cursor_clientiope.Close();
                  Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_clientiope.Eof())) {
                    // * --- Insert into mlientiope from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("mlientiope");
                    m_cPhName = m_Ctx.GetPhName("mlientiope");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mlientiope",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000000C4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000C4(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mlientiope",true);
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
                    Cursor_clientiope.Next();
                  }
                  m_cConnectivityError = Cursor_clientiope.ErrorMessage();
                  Cursor_clientiope.Close();
                  // * --- End Select
                  // * --- Select from beneficope
                  m_cServer = m_Ctx.GetServer("beneficope");
                  m_cPhName = m_Ctx.GetPhName("beneficope");
                  if (Cursor_beneficope!=null)
                    Cursor_beneficope.Close();
                  Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_beneficope.Eof())) {
                    // * --- Insert into meneficope from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("meneficope");
                    m_cPhName = m_Ctx.GetPhName("meneficope");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"meneficope",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000000C6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000C6(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetDouble("CPROWNUM"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"meneficope",true);
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
                    Cursor_beneficope.Next();
                  }
                  m_cConnectivityError = Cursor_beneficope.ErrorMessage();
                  Cursor_beneficope.Close();
                  // * --- End Select
                  // * --- Select from terzistiope
                  m_cServer = m_Ctx.GetServer("terzistiope");
                  m_cPhName = m_Ctx.GetPhName("terzistiope");
                  if (Cursor_terzistiope!=null)
                    Cursor_terzistiope.Close();
                  Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_terzistiope.Eof())) {
                    // * --- Insert into merzistiope from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("merzistiope");
                    m_cPhName = m_Ctx.GetPhName("merzistiope");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"merzistiope",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000000C8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000C8(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"merzistiope",true);
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
                    Cursor_terzistiope.Next();
                  }
                  m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
                  Cursor_terzistiope.Close();
                  // * --- End Select
                  Cursor_operazbo.Next();
                }
                m_cConnectivityError = Cursor_operazbo.ErrorMessage();
                Cursor_operazbo.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If (not(Empty(LRTrim(_numprog))) and not(Empty(LRTrim(imp_archope->DATAOPE)))) or Empty(LRTrim(_numprog)) */
            if (( ! (CPLib.Empty(CPLib.LRTrim(_numprog))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("DATAOPE"))))) || CPLib.Empty(CPLib.LRTrim(_numprog))) {
              /* If not(Empty(LRTrim(_numprog))) and not(Empty(LRTrim(imp_archope->DATAOPE))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(_numprog))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("DATAOPE"))))) {
                /* cOpeProg2 := _numprog */
                cOpeProg2 = _numprog;
                /* _statoreg := '1' */
                _statoreg = "1";
                /* _datarett := Date() */
                _datarett = CPLib.Date();
              } else { // Else
                /* cOpeProg2 := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(gAzienda)+"'",'',11) */
                cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
                /* _statoreg := '0' */
                _statoreg = "0";
                /* _datarett := NullDate() */
                _datarett = CPLib.NullDate();
              } // End If
              /* cOpeProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",'',10) */
              cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* _idb2 := LibreriaMit.UniqueId() */
              _idb2 = LibreriaMit.UniqueId();
              /* Case imp_archope->FLAGLIRE='S' or imp_archope->FLAGLIRE='1' or imp_archope->FLAGLIRE='7' */
              if (CPLib.eqr(Cursor_imp_archope.GetString("FLAGLIRE"),"S") || CPLib.eqr(Cursor_imp_archope.GetString("FLAGLIRE"),"1") || CPLib.eqr(Cursor_imp_archope.GetString("FLAGLIRE"),"7")) {
                /* cFlagLire := '1' */
                cFlagLire = "1";
                /* Case imp_archope->FLAGLIRE='E' or imp_archope->FLAGLIRE='3' or imp_archope->FLAGLIRE='5' */
              } else if (CPLib.eqr(Cursor_imp_archope.GetString("FLAGLIRE"),"E") || CPLib.eqr(Cursor_imp_archope.GetString("FLAGLIRE"),"3") || CPLib.eqr(Cursor_imp_archope.GetString("FLAGLIRE"),"5")) {
                /* If imp_archope->FLAGLIRE = 'E' */
                if (CPLib.eqr(Cursor_imp_archope.GetString("FLAGLIRE"),"E")) {
                  /* cFlagLire := '3' */
                  cFlagLire = "3";
                } else { // Else
                  /* cFlagLire := imp_archope->FLAGLIRE */
                  cFlagLire = Cursor_imp_archope.GetString("FLAGLIRE");
                } // End If
              } else { // Otherwise
                /* cFlagLire := imp_archope->FLAGLIRE */
                cFlagLire = Cursor_imp_archope.GetString("FLAGLIRE");
              } // End Case
              /* _datareg := iif(Empty(LRTrim(imp_archope->DATAREG)) or _flgdataim=1,Date(),CharToDate(imp_archope->DATAREG)) */
              _datareg = (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("DATAREG"))) || CPLib.eqr(_flgdataim,1)?CPLib.Date():CPLib.CharToDate(Cursor_imp_archope.GetString("DATAREG")));
              /* cFlagCont := iif(imp_archope->FLAGCONT='1' or imp_archope->FLAGCONT='S','1','0')  */
              cFlagCont = (CPLib.eqr(Cursor_imp_archope.GetString("FLAGCONT"),"1") || CPLib.eqr(Cursor_imp_archope.GetString("FLAGCONT"),"S")?"1":"0");
              /* cFlagFraz := iif(Empty(imp_archope->FLAGFRAZ),'0',iif(imp_archope->FLAGFRAZ='S','1',iif(imp_archope->FLAGFRAZ='N','1',imp_archope->FLAGFRAZ))) */
              cFlagFraz = (CPLib.Empty(Cursor_imp_archope.GetString("FLAGFRAZ"))?"0":(CPLib.eqr(Cursor_imp_archope.GetString("FLAGFRAZ"),"S")?"1":(CPLib.eqr(Cursor_imp_archope.GetString("FLAGFRAZ"),"N")?"1":Cursor_imp_archope.GetString("FLAGFRAZ"))));
              /* _colleg := LRTrim(imp_archope->NUMPROG) */
              _colleg = CPLib.LRTrim(Cursor_imp_archope.GetString("NUMPROG"));
              /* cFlagFraz := iif(not(Empty(LRTrim(_colleg))),'2',cFlagFraz) */
              cFlagFraz = ( ! (CPLib.Empty(CPLib.LRTrim(_colleg)))?"2":cFlagFraz);
              /* cIdCau := '' */
              cIdCau = "";
              /* If tbcausana_mc.GoToKey(Left(LRTrim(imp_archope->CODANA)+Space(4),4)+Left(LRTrim(imp_archope->CODVOC)+Space(2),2)) */
              if (tbcausana_mc.GoToKey(CPLib.Left(CPLib.LRTrim(Cursor_imp_archope.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_imp_archope.GetString("CODVOC"))+CPLib.Space(2),2))) {
                /* cIdCau := tbcausana_mc.idbase */
                cIdCau = tbcausana_mc.row.idbase;
              } // End If
              /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              /* _totin := imp_archope->IMPIN */
              _totin = CPLib.Round(Cursor_imp_archope.GetDouble("IMPIN"),0);
              /* _totout := imp_archope->IMPOUT */
              _totout = CPLib.Round(Cursor_imp_archope.GetDouble("IMPOUT"),0);
              /* _benrag := Upper(imp_archope->C_RAG) */
              _benrag = CPLib.Upper(Cursor_imp_archope.GetString("C_RAG"));
              /* _bensta := arfn_conv_stato_uic(imp_archope->C_STA) */
              _bensta = arfn_conv_stato_uicR.Make(m_Ctx,this).Run(Cursor_imp_archope.GetString("C_STA"));
              /* _bencta := Upper(imp_archope->C_CTA) */
              _bencta = CPLib.Upper(Cursor_imp_archope.GetString("C_CTA"));
              /* _bencab := imp_archope->C_CAB */
              _bencab = Cursor_imp_archope.GetString("C_CAB");
              /* _benprv := Upper(imp_archope->C_PRV) */
              _benprv = CPLib.Upper(Cursor_imp_archope.GetString("C_PRV"));
              /* _benind := Upper(imp_archope->C_IND) */
              _benind = CPLib.Upper(Cursor_imp_archope.GetString("C_IND"));
              /* _bencap := Upper(imp_archope->C_CAP) */
              _bencap = CPLib.Upper(Cursor_imp_archope.GetString("C_CAP"));
              /* If _bensta = '086' and Empty(_bencab)  */
              if (CPLib.eqr(_bensta,"086") && CPLib.Empty(_bencab)) {
                MemoryCursor_tbcitta cpmc_000000ED;
                cpmc_000000ED = new MemoryCursor_tbcitta();
                for (MemoryCursorRow_tbcitta RowMCCitta : tbcitta_mc._iterable_()) {
                  if (CPLib.eqr(_bencta,tbcitta_mc.row.CITTA)) {
                    cpmc_000000ED.Append(RowMCCitta);
                  }
                }
                for (MemoryCursorRow_tbcitta RowMCCitta : cpmc_000000ED._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_tbcitta>(){  public int compare(MemoryCursorRow_tbcitta r1,MemoryCursorRow_tbcitta r2){    if (CPLib.gt(r1.CITTA,r2.CITTA)) return 1;    if (CPLib.lt(r1.CITTA,r2.CITTA)) return -1;    return 0;  }})) {
                  /* _bencab := RowMCCitta.CAB */
                  _bencab = RowMCCitta.CAB;
                  /* _benprv := RowMCCitta.PROV */
                  _benprv = RowMCCitta.PROV;
                  /* _bencap := RowMCCitta.CAP */
                  _bencap = RowMCCitta.CAP;
                }
              } // End If
              /* If not(Empty(LRTrim(imp_archope->CONNESBEN))) and Empty(LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap)) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("CONNESBEN")))) && CPLib.Empty(CPLib.LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap))) {
                /* _benrag := '' */
                _benrag = "";
                /* _bensta := '' */
                _bensta = "";
                /* _bencta := '' */
                _bencta = "";
                /* _bencab := '' */
                _bencab = "";
                /* _benprv := '' */
                _benprv = "";
                /* _benind := '' */
                _benind = "";
                /* _bencap := '' */
                _bencap = "";
                // * --- Read from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_cSql = "";
                m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_archope.GetString("CONNESBEN"),"C",16,0,m_cServer),m_cServer,Cursor_imp_archope.GetString("CONNESBEN"));
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DOMICILIO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PAESE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _bencab = Read_Cursor.GetString("CODCAB");
                  _benrag = Read_Cursor.GetString("RAGSOC");
                  _benind = Read_Cursor.GetString("DOMICILIO");
                  _bencta = Read_Cursor.GetString("DESCCIT");
                  _benprv = Read_Cursor.GetString("PROVINCIA");
                  _bensta = Read_Cursor.GetString("PAESE");
                  _bencap = Read_Cursor.GetString("CAP");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_dati_da_tabelle returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _bencab = "";
                  _benrag = "";
                  _benind = "";
                  _bencta = "";
                  _benprv = "";
                  _bensta = "";
                  _bencap = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
              /* If Empty(LRTrim(imp_archope->CONNESBEN)) and Empty(LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap)) and _frapcli='S' */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("CONNESBEN"))) && CPLib.Empty(CPLib.LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap)) && CPLib.eqr(_frapcli,"S")) {
                /* If not(Empty(LRTrim(imp_archope->RAPPORTO))) */
                if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archope.GetString("RAPPORTO"))))) {
                  // * --- Select from intestbo
                  m_cServer = m_Ctx.GetServer("intestbo");
                  m_cPhName = m_Ctx.GetPhName("intestbo");
                  if (Cursor_intestbo!=null)
                    Cursor_intestbo.Close();
                  Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_imp_archope.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_intestbo.Eof())) {
                    /* _benrag := '' */
                    _benrag = "";
                    /* _bensta := '' */
                    _bensta = "";
                    /* _bencta := '' */
                    _bencta = "";
                    /* _bencab := '' */
                    _bencab = "";
                    /* _benprv := '' */
                    _benprv = "";
                    /* _benind := '' */
                    _benind = "";
                    /* _bencap := '' */
                    _bencap = "";
                    // * --- Read from personbo
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    m_cSql = "";
                    m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"));
                    if (m_Ctx.IsSharedTemp("personbo")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DOMICILIO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PAESE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _bencab = Read_Cursor.GetString("CODCAB");
                      _benrag = Read_Cursor.GetString("RAGSOC");
                      _benind = Read_Cursor.GetString("DOMICILIO");
                      _bencta = Read_Cursor.GetString("DESCCIT");
                      _benprv = Read_Cursor.GetString("PROVINCIA");
                      _bensta = Read_Cursor.GetString("PAESE");
                      _bencap = Read_Cursor.GetString("CAP");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_dati_da_tabelle returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _bencab = "";
                      _benrag = "";
                      _benind = "";
                      _bencta = "";
                      _benprv = "";
                      _bensta = "";
                      _bencap = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    // Exit Loop
                    if (true) {
                      break;
                    }
                    Cursor_intestbo.Next();
                  }
                  m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                  Cursor_intestbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              // * --- Insert into operazbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("operazbo");
              m_cPhName = m_Ctx.GetPhName("operazbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"00000106")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000106(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Right(Cursor_imp_archope.GetString("DATAOPE"),4)),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(arfn_conv_stato_uicR.Make(m_Ctx,this).Run(CPLib.Left(CPLib.LRTrim(Cursor_imp_archope.GetString("AREAGEO")),3)),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_bencab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_bencap,5),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_bencta,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_benind,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_benprv,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_benrag,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_bensta,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_archope.GetString("CAMBIO"))/10000,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(Cursor_imp_archope.GetString("DATAOPE"),4)+CPLib.Substr(Cursor_imp_archope.GetString("DATAOPE"),3,2)+CPLib.Left(Cursor_imp_archope.GetString("DATAOPE"),2),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(Cursor_imp_archope.GetString("DATAOPE"),4)+CPLib.Substr(Cursor_imp_archope.GetString("DATAOPE"),3,2)+CPLib.Left(Cursor_imp_archope.GetString("DATAOPE"),2),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datareg),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(Cursor_imp_archope.GetString("DATAIMP"),4)+CPLib.Substr(Cursor_imp_archope.GetString("DATAIMP"),3,2)+CPLib.Left(Cursor_imp_archope.GetString("DATAIMP"),2)),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(Cursor_imp_archope.GetString("DATAOPE"),4)+CPLib.Substr(Cursor_imp_archope.GetString("DATAOPE"),3,2)+CPLib.Left(Cursor_imp_archope.GetString("DATAOPE"),2)),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datareg,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datarett,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetDouble("DUCOLLEG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("DURAT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_flagrap2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("AGOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDateTime(CPLib.Substr(Cursor_imp_archope.GetString("ORACOLLEG"),5,4)+CPLib.Substr(Cursor_imp_archope.GetString("ORACOLLEG"),3,2)+CPLib.Left(Cursor_imp_archope.GetString("ORACOLLEG"),2)+CPLib.Substr(Cursor_imp_archope.GetString("ORACOLLEG"),9,6)),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(arfn_conv_stato_uicR.Make(m_Ctx,this).Run(Cursor_imp_archope.GetString("PAESE")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_statoreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_imp_archope.GetString("TIPO")),3),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_archope.GetString("TOTCONT")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_archope.GetString("TOTLIRE")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archope.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_colleg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totin/100,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_totout/100,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_nUpdatedRows = 0;
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.lt(m_nUpdatedRows,1)) {
                // No rows inserted
                /* gMsgProc := gMsgProc +"Rilevati errori nella tabella delle operazioni per l'operazione in data "+CharToDate(imp_archope->DATAOPE)+" con importo "+Str((Val(imp_archope->TOTLIRE))/100,14,2)+". L'attuale procedura di importazione verrà annullata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Rilevati errori nella tabella delle operazioni per l'operazione in data "+CPLib.CharToDate(Cursor_imp_archope.GetString("DATAOPE"))+" con importo "+CPLib.Str((CPLib.Val(Cursor_imp_archope.GetString("TOTLIRE")))/100,14,2)+". L'attuale procedura di importazione verrà annullata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                // Exit Loop
                if (true) {
                  break;
                }
                // Transaction Error
                cTry0000006Cmsg = CPLib.FormatMsg(m_Ctx,"'%1'",gMsgProc);
                m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"'%1'",gMsgProc));
                m_cLastMsgError = "";
                /* _esito := 1 */
                _esito = CPLib.Round(1,0);
                // Exit Loop
                if (true) {
                  break;
                }
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
              /* If not(Empty(LRTrim(_oldidb))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(_oldidb)))) {
                // * --- Select from sogopebo
                m_cServer = m_Ctx.GetServer("sogopebo");
                m_cPhName = m_Ctx.GetPhName("sogopebo");
                if (Cursor_sogopebo!=null)
                  Cursor_sogopebo.Close();
                Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_sogopebo.Eof())) {
                  // * --- Insert into sogopebo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("sogopebo");
                  m_cPhName = m_Ctx.GetPhName("sogopebo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"00000110")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000110(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopebo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sogopebo",true);
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
                  Cursor_sogopebo.Next();
                }
                m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
                Cursor_sogopebo.Close();
                // * --- End Select
                // * --- Delete from sogopebo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("sogopebo");
                m_cPhName = m_Ctx.GetPhName("sogopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"00000111")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer),m_cServer,_oldidb)+"";
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
                // * --- Select from clientiope
                m_cServer = m_Ctx.GetServer("clientiope");
                m_cPhName = m_Ctx.GetPhName("clientiope");
                if (Cursor_clientiope!=null)
                  Cursor_clientiope.Close();
                Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_clientiope.Eof())) {
                  // * --- Insert into clientiope from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("clientiope");
                  m_cPhName = m_Ctx.GetPhName("clientiope");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"00000113")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000113(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"clientiope",true);
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
                  Cursor_clientiope.Next();
                }
                m_cConnectivityError = Cursor_clientiope.ErrorMessage();
                Cursor_clientiope.Close();
                // * --- End Select
                // * --- Delete from clientiope
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("clientiope");
                m_cPhName = m_Ctx.GetPhName("clientiope");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"00000114")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer),m_cServer,_oldidb)+"";
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
                // * --- Select from beneficope
                m_cServer = m_Ctx.GetServer("beneficope");
                m_cPhName = m_Ctx.GetPhName("beneficope");
                if (Cursor_beneficope!=null)
                  Cursor_beneficope.Close();
                Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_beneficope.Eof())) {
                  // * --- Insert into beneficope from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("beneficope");
                  m_cPhName = m_Ctx.GetPhName("beneficope");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"00000116")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000116(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"beneficope",true);
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
                  Cursor_beneficope.Next();
                }
                m_cConnectivityError = Cursor_beneficope.ErrorMessage();
                Cursor_beneficope.Close();
                // * --- End Select
                // * --- Delete from beneficope
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("beneficope");
                m_cPhName = m_Ctx.GetPhName("beneficope");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"00000117")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer),m_cServer,_oldidb)+"";
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
                // * --- Select from terzistiope
                m_cServer = m_Ctx.GetServer("terzistiope");
                m_cPhName = m_Ctx.GetPhName("terzistiope");
                if (Cursor_terzistiope!=null)
                  Cursor_terzistiope.Close();
                Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_terzistiope.Eof())) {
                  // * --- Insert into terzistiope from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("terzistiope");
                  m_cPhName = m_Ctx.GetPhName("terzistiope");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"00000119")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000119(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"terzistiope",true);
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
                  Cursor_terzistiope.Next();
                }
                m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
                Cursor_terzistiope.Close();
                // * --- End Select
                // * --- Delete from terzistiope
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("terzistiope");
                m_cPhName = m_Ctx.GetPhName("terzistiope");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"0000011A")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer),m_cServer,_oldidb)+"";
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
              /* cNumNew := cNumNew + 1 */
              cNumNew = CPLib.Round(cNumNew+1,0);
            } // End If
          } else { // Else
            /* mcErrori.AppendBlank() // Memori cursor per errori */
            mcErrori.AppendBlank();
            /* mcErrori.nomearch := imp_archope->INFORM // Memori cursor per errori */
            mcErrori.row.nomearch = Cursor_imp_archope.GetString("INFORM");
            /* mcErrori.numriga := 1 // Memori cursor per errori */
            mcErrori.row.numriga = 1;
            /* mcErrori.SaveRow() // Memori cursor per errori */
            mcErrori.SaveRow();
            /* _opeerr := 1 */
            _opeerr = CPLib.Round(1,0);
          } // End If
          Cursor_imp_archope.Next();
        }
        m_cConnectivityError = Cursor_imp_archope.ErrorMessage();
        Cursor_imp_archope.Close();
        // * --- End Select
        /* _max := 0 */
        _max = CPLib.Round(0,0);
        /* _min := 0 */
        _min = CPLib.Round(0,0);
        /* _tot := 0 */
        _tot = CPLib.Round(0,0);
        // * --- Select from qbe_imp_archfraz_minmax
        if (Cursor_qbe_imp_archfraz_minmax!=null)
          Cursor_qbe_imp_archfraz_minmax.Close();
        Cursor_qbe_imp_archfraz_minmax = new VQRHolder("qbe_imp_archfraz_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_imp_archfraz_minmax.Eof())) {
          /* _max := qbe_imp_archfraz_minmax->MAXPRG */
          _max = CPLib.Round(Cursor_qbe_imp_archfraz_minmax.GetDouble("MAXPRG"),0);
          /* _min := qbe_imp_archfraz_minmax->MINPRG */
          _min = CPLib.Round(Cursor_qbe_imp_archfraz_minmax.GetDouble("MINPRG"),0);
          /* _tot := qbe_imp_archfraz_minmax->TOTPRG */
          _tot = CPLib.Round(Cursor_qbe_imp_archfraz_minmax.GetDouble("TOTPRG"),0);
          Cursor_qbe_imp_archfraz_minmax.Next();
        }
        m_cConnectivityError = Cursor_qbe_imp_archfraz_minmax.ErrorMessage();
        Cursor_qbe_imp_archfraz_minmax.Close();
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
            // * --- Select from imp_archfraz
            m_cServer = m_Ctx.GetServer("imp_archfraz");
            m_cPhName = m_Ctx.GetPhName("imp_archfraz");
            if (Cursor_imp_archfraz!=null)
              Cursor_imp_archfraz.Close();
            Cursor_imp_archfraz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONTATORE >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  CONTATORE <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+" "+")"+(m_Ctx.IsSharedTemp("imp_archfraz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_imp_archfraz.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' operazioni ' // Messaggio Import */
              gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" operazioni ";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* Status Msg 'Sto elaborando frazionata %1 su %2' */
              m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Sto elaborando frazionata %1 su %2",CPLib.LRTrim(CPLib.Str(conta,10,0)),CPLib.LRTrim(CPLib.Str(_tot,10,0))));
              /* _descerr := '' */
              _descerr = "";
              /* _findsub := 1 */
              _findsub = CPLib.Round(1,0);
              /* If not(Empty(LRTrim(imp_archfraz->CONNESCLI))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("CONNESCLI"))))) {
                /* If not(personbo_mc.GoToKey(LRTrim(imp_archfraz->CONNESCLI))) */
                if ( ! (personbo_mc.GoToKey(CPLib.LRTrim(Cursor_imp_archfraz.GetString("CONNESCLI"))))) {
                  /* _descerr := 'Anagrafica Intestatario Operazione assente. Inform: '+imp_archfraz->INFORM */
                  _descerr = "Anagrafica Intestatario Operazione assente. Inform: "+Cursor_imp_archfraz.GetString("INFORM");
                  /* _findsub := 0 */
                  _findsub = CPLib.Round(0,0);
                  /* _generr := 1 */
                  _generr = CPLib.Round(1,0);
                } // End If
              } // End If
              /* If not(Empty(LRTrim(imp_archfraz->CONNESOPER))) and _findsub=1 */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("CONNESOPER")))) && CPLib.eqr(_findsub,1)) {
                /* If not(personbo_mc.GoToKey(imp_archfraz->CONNESOPER)) */
                if ( ! (personbo_mc.GoToKey(Cursor_imp_archfraz.GetString("CONNESOPER")))) {
                  /* _descerr := iif(Empty(_descerr),'Anagrafica Soggetto Operante Operazione assente',_descerr+' Anagrafica Soggetto Operante Operazione assente') */
                  _descerr = (CPLib.Empty(_descerr)?"Anagrafica Soggetto Operante Operazione assente":_descerr+" Anagrafica Soggetto Operante Operazione assente");
                  /* _findsub := 0 */
                  _findsub = CPLib.Round(0,0);
                  /* _generr := 1 */
                  _generr = CPLib.Round(1,0);
                } // End If
              } // End If
              /* If not(Empty(LRTrim(imp_archfraz->CONNESBEN))) and _findsub=1 */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("CONNESBEN")))) && CPLib.eqr(_findsub,1)) {
                /* If not(personbo_mc.GoToKey(imp_archfraz->CONNESBEN)) */
                if ( ! (personbo_mc.GoToKey(Cursor_imp_archfraz.GetString("CONNESBEN")))) {
                  /* _descerr := iif(Empty(_descerr),'Anagrafica Controparte Operazione assente',_descerr+' Anagrafica Controparte Operazione assente') */
                  _descerr = (CPLib.Empty(_descerr)?"Anagrafica Controparte Operazione assente":_descerr+" Anagrafica Controparte Operazione assente");
                  /* _findsub := 0 */
                  _findsub = CPLib.Round(0,0);
                  /* _generr := 1 */
                  _generr = CPLib.Round(1,0);
                } // End If
              } // End If
              /* If not(Empty(LRTrim(imp_archfraz->CONNALTRO))) and _findsub=1 */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("CONNALTRO")))) && CPLib.eqr(_findsub,1)) {
                /* If not(personbo_mc.GoToKey(imp_archfraz->CONNALTRO)) */
                if ( ! (personbo_mc.GoToKey(Cursor_imp_archfraz.GetString("CONNALTRO")))) {
                  /* _descerr := iif(Empty(_descerr),'Anagrafica Soggetto per conto del quale assente',_descerr+' Anagrafica Soggetto per conto del quale assente') */
                  _descerr = (CPLib.Empty(_descerr)?"Anagrafica Soggetto per conto del quale assente":_descerr+" Anagrafica Soggetto per conto del quale assente");
                  /* _findsub := 0 */
                  _findsub = CPLib.Round(0,0);
                  /* _generr := 1 */
                  _generr = CPLib.Round(1,0);
                } // End If
              } // End If
              /* If Empty(LRTrim(imp_archfraz->CONNESCLI)) and Empty(LRTrim(imp_archfraz->RAPPORTO)) and _findsub = 1 */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("CONNESCLI"))) && CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("RAPPORTO"))) && CPLib.eqr(_findsub,1)) {
                /* _descerr := 'Rapporto continuativo o Intestatario Operazione assente' */
                _descerr = "Rapporto continuativo o Intestatario Operazione assente";
                /* _findsub := 0 */
                _findsub = CPLib.Round(0,0);
                /* _generr := 1 */
                _generr = CPLib.Round(1,0);
              } // End If
              /* If _findsub=1 */
              if (CPLib.eqr(_findsub,1)) {
                /* _intercod := iif(Empty(LRTrim(imp_archfraz->CODINTER)),_codinter,imp_archfraz->CODINTER) */
                _intercod = (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("CODINTER")))?_codinter:Cursor_imp_archfraz.GetString("CODINTER"));
                /* _intercit := iif(Empty(LRTrim(imp_archfraz->DESCCIT)),_citinter,imp_archfraz->DESCCIT) */
                _intercit = (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("DESCCIT")))?_citinter:Cursor_imp_archfraz.GetString("DESCCIT"));
                /* _intercab := iif(Empty(LRTrim(imp_archfraz->CODCAB)),_cabinter,imp_archfraz->CODCAB) */
                _intercab = (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("CODCAB")))?_cabinter:Cursor_imp_archfraz.GetString("CODCAB"));
                /* _interprv := iif(Empty(LRTrim(imp_archfraz->PROVINCIA)),_prvinter,imp_archfraz->PROVINCIA) */
                _interprv = (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("PROVINCIA")))?_prvinter:Cursor_imp_archfraz.GetString("PROVINCIA"));
                /* If not(Empty(LRTrim(imp_archfraz->CODDIPE))) */
                if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("CODDIPE"))))) {
                  /* If anadip_mc.GoToKey(imp_archfraz->CODDIPE) */
                  if (anadip_mc.GoToKey(Cursor_imp_archfraz.GetString("CODDIPE"))) {
                    /* _coddip := anadip_mc.CODDIP */
                    _coddip = anadip_mc.row.CODDIP;
                    /* _intercit := anadip_mc.DESCCIT */
                    _intercit = anadip_mc.row.DESCCIT;
                    /* _intercab := anadip_mc.CAB */
                    _intercab = anadip_mc.row.CAB;
                    /* _interprv := anadip_mc.PROVINCIA */
                    _interprv = anadip_mc.row.PROVINCIA;
                  } else { // Else
                    /* gMsgProc := gMsgProc +"Rilevati errori nella tabella delle operazioni per l'operazione in data "+CharToDate(imp_archfraz->DATAOPE)+" con importo "+Str((Val(imp_archfraz->TOTLIRE))/100,14,2)+" si è indicata la dipendenza con codice: " + LRTrim(imp_archfraz->CODDIPE)+" non è prensente  in anagrafica dipendenze." +" Ricreare il file ARCHDIP e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annullata automaticamente."+ NL */
                    gMsgProc = gMsgProc+"Rilevati errori nella tabella delle operazioni per l'operazione in data "+CPLib.CharToDate(Cursor_imp_archfraz.GetString("DATAOPE"))+" con importo "+CPLib.Str((CPLib.Val(Cursor_imp_archfraz.GetString("TOTLIRE")))/100,14,2)+" si è indicata la dipendenza con codice: "+CPLib.LRTrim(Cursor_imp_archfraz.GetString("CODDIPE"))+" non è prensente  in anagrafica dipendenze."+" Ricreare il file ARCHDIP e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annullata automaticamente."+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } // End If
                  /* If not(Empty(LRTrim(imp_archfraz->DESCCIT)+LRTrim(imp_archfraz->CODCAB)+LRTrim(imp_archfraz->PROVINCIA))) */
                  if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("DESCCIT"))+CPLib.LRTrim(Cursor_imp_archfraz.GetString("CODCAB"))+CPLib.LRTrim(Cursor_imp_archfraz.GetString("PROVINCIA"))))) {
                    /* _intercit := LRTrim(imp_archfraz->DESCCIT) */
                    _intercit = CPLib.LRTrim(Cursor_imp_archfraz.GetString("DESCCIT"));
                    /* _intercab := LRTrim(imp_archfraz->CODCAB) */
                    _intercab = CPLib.LRTrim(Cursor_imp_archfraz.GetString("CODCAB"));
                    /* _interprv := LRTrim(imp_archfraz->PROVINCIA) */
                    _interprv = CPLib.LRTrim(Cursor_imp_archfraz.GetString("PROVINCIA"));
                  } // End If
                } // End If
                /* Verifico la presenza dell'_unicode per evitare duplicazioni di informazioni diverse con lo stesso _unicode */
                /* _unicode := '' */
                _unicode = "";
                /* If Len(LRTrim(imp_archfraz->UNIQUECODE)) > 0 */
                if (CPLib.gt(CPLib.Len(CPLib.LRTrim(Cursor_imp_archfraz.GetString("UNIQUECODE"))),0)) {
                  // * --- Read from fraziobo
                  m_cServer = m_Ctx.GetServer("fraziobo");
                  m_cPhName = m_Ctx.GetPhName("fraziobo");
                  m_cSql = "";
                  m_cSql = m_cSql+"UNIQUECODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_archfraz.GetString("UNIQUECODE"),"C",10,0,m_cServer),m_cServer,Cursor_imp_archfraz.GetString("UNIQUECODE"));
                  if (m_Ctx.IsSharedTemp("fraziobo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _unicode = Read_Cursor.GetString("UNIQUECODE");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_import_dati_da_tabelle returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _unicode = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Len(LRTrim(_unicode)) > 0 */
                  if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_unicode)),0)) {
                    /* gMsgProc := gMsgProc +"Rilevati errori nella tabella delle operazioni per l'operazione in data "+CharToDate(imp_archfraz->DATAOPE)+" con importo "+Str((Val(imp_archfraz->TOTLIRE))/100,14,2)+". L'attuale procedura di importazione verrà annullata automaticamente."+ NL */
                    gMsgProc = gMsgProc+"Rilevati errori nella tabella delle operazioni per l'operazione in data "+CPLib.CharToDate(Cursor_imp_archfraz.GetString("DATAOPE"))+" con importo "+CPLib.Str((CPLib.Val(Cursor_imp_archfraz.GetString("TOTLIRE")))/100,14,2)+". L'attuale procedura di importazione verrà annullata automaticamente."+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Transaction Error
                    cTry0000006Cmsg = CPLib.FormatMsg(m_Ctx,"'%1'",gMsgProc);
                    m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"'%1'",gMsgProc));
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } // End If
                } // End If
                /* _rifimp := '' */
                _rifimp = "";
                /* _idreg := '' */
                _idreg = "";
                /* stringaflagrap2 := _flagrap2 // stringa di valori di flagrap2 */
                stringaflagrap2 = _flagrap2;
                /* _numprog := '' */
                _numprog = "";
                /* If Len(LRTrim(imp_archfraz->RIFIMP)) > 0 */
                if (CPLib.gt(CPLib.Len(CPLib.LRTrim(Cursor_imp_archfraz.GetString("RIFIMP"))),0)) {
                  /* If Upper(imp_archfraz->RIFIMP)='XXXXXXXXX' */
                  if (CPLib.eqr(CPLib.Upper(Cursor_imp_archfraz.GetString("RIFIMP")),"XXXXXXXXX")) {
                    // * --- Select from fraziobo
                    m_cServer = m_Ctx.GetServer("fraziobo");
                    m_cPhName = m_Ctx.GetPhName("fraziobo");
                    if (Cursor_fraziobo!=null)
                      Cursor_fraziobo.Close();
                    Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMPROG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"INFORM = "+CPLib.ToSQL(Cursor_imp_archfraz.GetString("INFORM"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_fraziobo.Eof())) {
                      /* _numprog := fraziobo->NUMPROG */
                      _numprog = Cursor_fraziobo.GetString("NUMPROG");
                      Cursor_fraziobo.Next();
                    }
                    m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
                    Cursor_fraziobo.Close();
                    // * --- End Select
                  } else { // Else
                    // * --- Select from fraziobo
                    m_cServer = m_Ctx.GetServer("fraziobo");
                    m_cPhName = m_Ctx.GetPhName("fraziobo");
                    if (Cursor_fraziobo!=null)
                      Cursor_fraziobo.Close();
                    Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMPROG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RIFIMP = "+CPLib.ToSQL(Cursor_imp_archfraz.GetString("RIFIMP"),"?",0,0)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_fraziobo.Eof())) {
                      /* _numprog := fraziobo->NUMPROG */
                      _numprog = Cursor_fraziobo.GetString("NUMPROG");
                      Cursor_fraziobo.Next();
                    }
                    m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
                    Cursor_fraziobo.Close();
                    // * --- End Select
                  } // End If
                } // End If
                /* If not(Empty(LRTrim(_numprog))) */
                if ( ! (CPLib.Empty(CPLib.LRTrim(_numprog)))) {
                  /* If Empty(LRTrim(imp_archfraz->DATAOPE)) or IsNull(imp_archfraz->DATAOPE) */
                  if (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("DATAOPE"))) || Cursor_imp_archfraz.IsNull("DATAOPE")) {
                    /* cNumNew := cNumNew + 1 */
                    cNumNew = CPLib.Round(cNumNew+1,0);
                    // * --- Select from fraziobo
                    m_cServer = m_Ctx.GetServer("fraziobo");
                    m_cPhName = m_Ctx.GetPhName("fraziobo");
                    if (Cursor_fraziobo!=null)
                      Cursor_fraziobo.Close();
                    Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer, m_oParameters),m_cServer,_numprog)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_fraziobo.Eof())) {
                      /* gMsgImp := "E' stata cancellata l'operazione con codice "+_numprog // Messaggio Import */
                      gMsgImp = "E' stata cancellata l'operazione con codice "+_numprog;
                      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                      // * --- Write into fraziobo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("fraziobo");
                      m_cPhName = m_Ctx.GetPhName("fraziobo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"00000186")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("2","C",1,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_fraziobo.GetString("IDBASE"))+"";
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
                      Cursor_fraziobo.Next();
                    }
                    m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
                    Cursor_fraziobo.Close();
                    // * --- End Select
                  } else { // Else
                    /* stringaflagrap2 := 'ABCDEFGHI' // stringa di valori di flagrap2 */
                    stringaflagrap2 = "ABCDEFGHI";
                    /* gMsgImp := "E' stata variata l'operazione con codice "+_numprog // Messaggio Import */
                    gMsgImp = "E' stata variata l'operazione con codice "+_numprog;
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                    /* Stranezza su idreg da vericare se corretto averlo aggiunto nella quey sottostante */
                    // * --- Select from fraziobo
                    m_cServer = m_Ctx.GetServer("fraziobo");
                    m_cPhName = m_Ctx.GetPhName("fraziobo");
                    if (Cursor_fraziobo!=null)
                      Cursor_fraziobo.Close();
                    Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,NUMPROG,DATAOPE,FLAGRAP2,IDEREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer, m_oParameters),m_cServer,_numprog)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_fraziobo.Eof())) {
                      /* _oldidb := fraziobo->IDBASE */
                      _oldidb = Cursor_fraziobo.GetString("IDBASE");
                      /* _flagrap2 := iif(Empty(fraziobo->FLAGRAP2) or fraziobo->FLAGRAP2='S',Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(fraziobo->FLAGRAP2,stringaflagrap2)+1),1)) */
                      _flagrap2 = (CPLib.Empty(Cursor_fraziobo.GetString("FLAGRAP2")) || CPLib.eqr(Cursor_fraziobo.GetString("FLAGRAP2"),"S")?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(Cursor_fraziobo.GetString("FLAGRAP2"),stringaflagrap2)+1),1));
                      /* _idreg := fraziobo->IDEREG */
                      _idreg = Cursor_fraziobo.GetString("IDEREG");
                      // * --- Write into fraziobo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("fraziobo");
                      m_cPhName = m_Ctx.GetPhName("fraziobo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"0000018E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                      m_cSql = m_cSql+"FLAGRAP2 = "+CPLib.ToSQL(_flagrap2,"C",1,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_fraziobo.GetString("IDBASE"))+"";
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
                      // * --- Select from sogopefbo
                      m_cServer = m_Ctx.GetServer("sogopefbo");
                      m_cPhName = m_Ctx.GetPhName("sogopefbo");
                      if (Cursor_sogopefbo!=null)
                        Cursor_sogopefbo.Close();
                      Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_sogopefbo.Eof())) {
                        // * --- Insert into mogopefbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("mogopefbo");
                        m_cPhName = m_Ctx.GetPhName("mogopefbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mogopefbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"00000190")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_00000190(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mogopefbo",true);
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
                        Cursor_sogopefbo.Next();
                      }
                      m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
                      Cursor_sogopefbo.Close();
                      // * --- End Select
                      // * --- Select from clientifrz
                      m_cServer = m_Ctx.GetServer("clientifrz");
                      m_cPhName = m_Ctx.GetPhName("clientifrz");
                      if (Cursor_clientifrz!=null)
                        Cursor_clientifrz.Close();
                      Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_clientifrz.Eof())) {
                        // * --- Insert into mlientifrz from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("mlientifrz");
                        m_cPhName = m_Ctx.GetPhName("mlientifrz");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mlientifrz",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"00000192")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_00000192(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mlientifrz",true);
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
                        Cursor_clientifrz.Next();
                      }
                      m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
                      Cursor_clientifrz.Close();
                      // * --- End Select
                      // * --- Select from beneficfrz
                      m_cServer = m_Ctx.GetServer("beneficfrz");
                      m_cPhName = m_Ctx.GetPhName("beneficfrz");
                      if (Cursor_beneficfrz!=null)
                        Cursor_beneficfrz.Close();
                      Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_beneficfrz.Eof())) {
                        // * --- Insert into meneficfrz from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("meneficfrz");
                        m_cPhName = m_Ctx.GetPhName("meneficfrz");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"meneficfrz",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"00000194")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_00000194(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetDouble("CPROWNUM"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"meneficfrz",true);
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
                        Cursor_beneficfrz.Next();
                      }
                      m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
                      Cursor_beneficfrz.Close();
                      // * --- End Select
                      // * --- Select from terzistifrz
                      m_cServer = m_Ctx.GetServer("terzistifrz");
                      m_cPhName = m_Ctx.GetPhName("terzistifrz");
                      if (Cursor_terzistifrz!=null)
                        Cursor_terzistifrz.Close();
                      Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_terzistifrz.Eof())) {
                        // * --- Insert into merzistifrz from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("merzistifrz");
                        m_cPhName = m_Ctx.GetPhName("merzistifrz");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"merzistifrz",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"00000196")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_00000196(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"merzistifrz",true);
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
                        Cursor_terzistifrz.Next();
                      }
                      m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
                      Cursor_terzistifrz.Close();
                      // * --- End Select
                      Cursor_fraziobo.Next();
                    }
                    m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
                    Cursor_fraziobo.Close();
                    // * --- End Select
                  } // End If
                } // End If
                /* If (not(Empty(LRTrim(_numprog))) and not(Empty(LRTrim(imp_archfraz->DATAOPE)))) or Empty(LRTrim(_numprog)) */
                if (( ! (CPLib.Empty(CPLib.LRTrim(_numprog))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("DATAOPE"))))) || CPLib.Empty(CPLib.LRTrim(_numprog))) {
                  /* If not(Empty(LRTrim(_numprog))) and not(Empty(LRTrim(imp_archfraz->DATAOPE))) */
                  if ( ! (CPLib.Empty(CPLib.LRTrim(_numprog))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("DATAOPE"))))) {
                    /* cOpeProg2 := _numprog */
                    cOpeProg2 = _numprog;
                    /* _statoreg := '1' */
                    _statoreg = "1";
                    /* _datarett := Date() */
                    _datarett = CPLib.Date();
                  } else { // Else
                    /* cOpeProg2 := Utilities.GetAutonumber("PFRAZIO2\'"+LRTrim(gAzienda)+"'",'',11) */
                    cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
                    /* _statoreg := '0' */
                    _statoreg = "0";
                    /* _datarett := NullDate() */
                    _datarett = CPLib.NullDate();
                  } // End If
                  /* cOpeProg1 := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(gAzienda)+"'",'',10) */
                  cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                  /* _idb2 := LibreriaMit.UniqueId() */
                  _idb2 = LibreriaMit.UniqueId();
                  /* Case imp_archfraz->FLAGLIRE='S' or imp_archfraz->FLAGLIRE='1' or imp_archfraz->FLAGLIRE='7' */
                  if (CPLib.eqr(Cursor_imp_archfraz.GetString("FLAGLIRE"),"S") || CPLib.eqr(Cursor_imp_archfraz.GetString("FLAGLIRE"),"1") || CPLib.eqr(Cursor_imp_archfraz.GetString("FLAGLIRE"),"7")) {
                    /* cFlagLire := '1' */
                    cFlagLire = "1";
                    /* Case imp_archfraz->FLAGLIRE='E' or imp_archfraz->FLAGLIRE='3' or imp_archfraz->FLAGLIRE='5' */
                  } else if (CPLib.eqr(Cursor_imp_archfraz.GetString("FLAGLIRE"),"E") || CPLib.eqr(Cursor_imp_archfraz.GetString("FLAGLIRE"),"3") || CPLib.eqr(Cursor_imp_archfraz.GetString("FLAGLIRE"),"5")) {
                    /* If imp_archfraz->FLAGLIRE = 'E' */
                    if (CPLib.eqr(Cursor_imp_archfraz.GetString("FLAGLIRE"),"E")) {
                      /* cFlagLire := '3' */
                      cFlagLire = "3";
                    } else { // Else
                      /* cFlagLire := imp_archfraz->FLAGLIRE */
                      cFlagLire = Cursor_imp_archfraz.GetString("FLAGLIRE");
                    } // End If
                  } else { // Otherwise
                    /* cFlagLire := imp_archfraz->FLAGLIRE */
                    cFlagLire = Cursor_imp_archfraz.GetString("FLAGLIRE");
                  } // End Case
                  /* _datareg := iif(Empty(LRTrim(imp_archfraz->DATAREG)) or _flgdataim=1,Date(),CharToDate(imp_archfraz->DATAREG)) */
                  _datareg = (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("DATAREG"))) || CPLib.eqr(_flgdataim,1)?CPLib.Date():CPLib.CharToDate(Cursor_imp_archfraz.GetString("DATAREG")));
                  /* cFlagCont := iif(imp_archfraz->FLAGCONT='1' or imp_archfraz->FLAGCONT='S','1','0')  */
                  cFlagCont = (CPLib.eqr(Cursor_imp_archfraz.GetString("FLAGCONT"),"1") || CPLib.eqr(Cursor_imp_archfraz.GetString("FLAGCONT"),"S")?"1":"0");
                  /* cFlagFraz := iif(Empty(imp_archfraz->FLAGFRAZ),'0',iif(imp_archfraz->FLAGFRAZ='S','1',iif(imp_archfraz->FLAGFRAZ='N','1',imp_archfraz->FLAGFRAZ))) */
                  cFlagFraz = (CPLib.Empty(Cursor_imp_archfraz.GetString("FLAGFRAZ"))?"0":(CPLib.eqr(Cursor_imp_archfraz.GetString("FLAGFRAZ"),"S")?"1":(CPLib.eqr(Cursor_imp_archfraz.GetString("FLAGFRAZ"),"N")?"1":Cursor_imp_archfraz.GetString("FLAGFRAZ"))));
                  /* _colleg := LRTrim(imp_archfraz->NUMPROG) */
                  _colleg = CPLib.LRTrim(Cursor_imp_archfraz.GetString("NUMPROG"));
                  /* cFlagFraz := iif(not(Empty(LRTrim(_colleg))),'2',cFlagFraz) */
                  cFlagFraz = ( ! (CPLib.Empty(CPLib.LRTrim(_colleg)))?"2":cFlagFraz);
                  /* cIdCau := '' */
                  cIdCau = "";
                  /* If tbcausana_mc.GoToKey(Left(LRTrim(imp_archfraz->CODANA)+Space(4),4)+Left(LRTrim(imp_archfraz->CODVOC)+Space(2),2)) */
                  if (tbcausana_mc.GoToKey(CPLib.Left(CPLib.LRTrim(Cursor_imp_archfraz.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_imp_archfraz.GetString("CODVOC"))+CPLib.Space(2),2))) {
                    /* cIdCau := tbcausana_mc.idbase */
                    cIdCau = tbcausana_mc.row.idbase;
                  } // End If
                  /* nProgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                  /* conta := conta + 1 */
                  conta = CPLib.Round(conta+1,0);
                  /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' operazioni ' // Messaggio Import */
                  gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" operazioni ";
                  m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  /* _totin := imp_archfraz->IMPIN */
                  _totin = CPLib.Round(Cursor_imp_archfraz.GetDouble("IMPIN"),0);
                  /* _totout := imp_archfraz->IMPOUT */
                  _totout = CPLib.Round(Cursor_imp_archfraz.GetDouble("IMPOUT"),0);
                  /* _benrag := Upper(imp_archfraz->C_RAG) */
                  _benrag = CPLib.Upper(Cursor_imp_archfraz.GetString("C_RAG"));
                  /* _bensta := arfn_conv_stato_uic(imp_archfraz->C_STA) */
                  _bensta = arfn_conv_stato_uicR.Make(m_Ctx,this).Run(Cursor_imp_archfraz.GetString("C_STA"));
                  /* _bencta := Upper(imp_archfraz->C_CTA) */
                  _bencta = CPLib.Upper(Cursor_imp_archfraz.GetString("C_CTA"));
                  /* _bencab := imp_archfraz->C_CAB */
                  _bencab = Cursor_imp_archfraz.GetString("C_CAB");
                  /* _benprv := Upper(imp_archfraz->C_PRV) */
                  _benprv = CPLib.Upper(Cursor_imp_archfraz.GetString("C_PRV"));
                  /* _benind := Upper(imp_archfraz->C_IND) */
                  _benind = CPLib.Upper(Cursor_imp_archfraz.GetString("C_IND"));
                  /* _bencap := Upper(imp_archfraz->C_CAP) */
                  _bencap = CPLib.Upper(Cursor_imp_archfraz.GetString("C_CAP"));
                  /* If _bensta = '086' and Empty(_bencab)  */
                  if (CPLib.eqr(_bensta,"086") && CPLib.Empty(_bencab)) {
                    MemoryCursor_tbcitta cpmc_000001BD;
                    cpmc_000001BD = new MemoryCursor_tbcitta();
                    for (MemoryCursorRow_tbcitta RowMCCitta : tbcitta_mc._iterable_()) {
                      if (CPLib.eqr(_bencta,tbcitta_mc.row.CITTA)) {
                        cpmc_000001BD.Append(RowMCCitta);
                      }
                    }
                    for (MemoryCursorRow_tbcitta RowMCCitta : cpmc_000001BD._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_tbcitta>(){  public int compare(MemoryCursorRow_tbcitta r1,MemoryCursorRow_tbcitta r2){    if (CPLib.gt(r1.CITTA,r2.CITTA)) return 1;    if (CPLib.lt(r1.CITTA,r2.CITTA)) return -1;    return 0;  }})) {
                      /* _bencab := RowMCCitta.CAB */
                      _bencab = RowMCCitta.CAB;
                      /* _benprv := RowMCCitta.PROV */
                      _benprv = RowMCCitta.PROV;
                      /* _bencap := RowMCCitta.CAP */
                      _bencap = RowMCCitta.CAP;
                    }
                  } // End If
                  /* If not(Empty(LRTrim(imp_archfraz->CONNESBEN))) and Empty(LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap)) */
                  if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("CONNESBEN")))) && CPLib.Empty(CPLib.LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap))) {
                    /* _benrag := '' */
                    _benrag = "";
                    /* _bensta := '' */
                    _bensta = "";
                    /* _bencta := '' */
                    _bencta = "";
                    /* _bencab := '' */
                    _bencab = "";
                    /* _benprv := '' */
                    _benprv = "";
                    /* _benind := '' */
                    _benind = "";
                    /* _bencap := '' */
                    _bencap = "";
                    // * --- Read from personbo
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    m_cSql = "";
                    m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_imp_archfraz.GetString("CONNESBEN"),"C",16,0,m_cServer),m_cServer,Cursor_imp_archfraz.GetString("CONNESBEN"));
                    if (m_Ctx.IsSharedTemp("personbo")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DOMICILIO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PAESE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _bencab = Read_Cursor.GetString("CODCAB");
                      _benrag = Read_Cursor.GetString("RAGSOC");
                      _benind = Read_Cursor.GetString("DOMICILIO");
                      _bencta = Read_Cursor.GetString("DESCCIT");
                      _benprv = Read_Cursor.GetString("PROVINCIA");
                      _bensta = Read_Cursor.GetString("PAESE");
                      _bencap = Read_Cursor.GetString("CAP");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_dati_da_tabelle returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _bencab = "";
                      _benrag = "";
                      _benind = "";
                      _bencta = "";
                      _benprv = "";
                      _bensta = "";
                      _bencap = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } // End If
                  /* If Empty(LRTrim(imp_archfraz->CONNESBEN)) and Empty(LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap)) and _frapcli='S' */
                  if (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("CONNESBEN"))) && CPLib.Empty(CPLib.LRTrim(_benrag+_bensta+_bencta+_bencab+_benprv+_benind+_bencap)) && CPLib.eqr(_frapcli,"S")) {
                    /* If not(Empty(LRTrim(imp_archfraz->RAPPORTO))) */
                    if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_imp_archfraz.GetString("RAPPORTO"))))) {
                      // * --- Select from intestbo
                      m_cServer = m_Ctx.GetServer("intestbo");
                      m_cPhName = m_Ctx.GetPhName("intestbo");
                      if (Cursor_intestbo!=null)
                        Cursor_intestbo.Close();
                      Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_imp_archfraz.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_intestbo.Eof())) {
                        /* _benrag := '' */
                        _benrag = "";
                        /* _bensta := '' */
                        _bensta = "";
                        /* _bencta := '' */
                        _bencta = "";
                        /* _bencab := '' */
                        _bencab = "";
                        /* _benprv := '' */
                        _benprv = "";
                        /* _benind := '' */
                        _benind = "";
                        /* _bencap := '' */
                        _bencap = "";
                        // * --- Read from personbo
                        m_cServer = m_Ctx.GetServer("personbo");
                        m_cPhName = m_Ctx.GetPhName("personbo");
                        m_cSql = "";
                        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"));
                        if (m_Ctx.IsSharedTemp("personbo")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DOMICILIO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PAESE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _bencab = Read_Cursor.GetString("CODCAB");
                          _benrag = Read_Cursor.GetString("RAGSOC");
                          _benind = Read_Cursor.GetString("DOMICILIO");
                          _bencta = Read_Cursor.GetString("DESCCIT");
                          _benprv = Read_Cursor.GetString("PROVINCIA");
                          _bensta = Read_Cursor.GetString("PAESE");
                          _bencap = Read_Cursor.GetString("CAP");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_dati_da_tabelle returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _bencab = "";
                          _benrag = "";
                          _benind = "";
                          _bencta = "";
                          _benprv = "";
                          _bensta = "";
                          _bencap = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                        // Exit Loop
                        if (true) {
                          break;
                        }
                        Cursor_intestbo.Next();
                      }
                      m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                      Cursor_intestbo.Close();
                      // * --- End Select
                    } // End If
                  } // End If
                  // * --- Insert into fraziobo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("fraziobo");
                  m_cPhName = m_Ctx.GetPhName("fraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000001D6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001D6(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Right(Cursor_imp_archfraz.GetString("DATAOPE"),4)),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(arfn_conv_stato_uicR.Make(m_Ctx,this).Run(CPLib.Left(CPLib.LRTrim(Cursor_imp_archfraz.GetString("AREAGEO")),3)),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_bencab,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_bencap,5),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_bencta,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_benind,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_benprv,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_benrag,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_bensta,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_archfraz.GetString("CAMBIO"))/10000,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(Cursor_imp_archfraz.GetString("DATAOPE"),4)+CPLib.Substr(Cursor_imp_archfraz.GetString("DATAOPE"),3,2)+CPLib.Left(Cursor_imp_archfraz.GetString("DATAOPE"),2),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(Cursor_imp_archfraz.GetString("DATAOPE"),4)+CPLib.Substr(Cursor_imp_archfraz.GetString("DATAOPE"),3,2)+CPLib.Left(Cursor_imp_archfraz.GetString("DATAOPE"),2),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datareg),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(Cursor_imp_archfraz.GetString("DATAIMP"),4)+CPLib.Substr(Cursor_imp_archfraz.GetString("DATAIMP"),3,2)+CPLib.Left(Cursor_imp_archfraz.GetString("DATAIMP"),2)),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(Cursor_imp_archfraz.GetString("DATAOPE"),4)+CPLib.Substr(Cursor_imp_archfraz.GetString("DATAOPE"),3,2)+CPLib.Left(Cursor_imp_archfraz.GetString("DATAOPE"),2)),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_datareg,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_datarett,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cFlagCont,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cFlagFraz,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cFlagLire,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_flagrap2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cIdCau,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("AGOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDateTime(CPLib.Substr(Cursor_imp_archfraz.GetString("ORACOLLEG"),5,4)+CPLib.Substr(Cursor_imp_archfraz.GetString("ORACOLLEG"),3,2)+CPLib.Left(Cursor_imp_archfraz.GetString("ORACOLLEG"),2)+CPLib.Substr(Cursor_imp_archfraz.GetString("ORACOLLEG"),9,6)),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(arfn_conv_stato_uicR.Make(m_Ctx,this).Run(Cursor_imp_archfraz.GetString("PAESE")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetDouble("RAREA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetDouble("RCOMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetDouble("RFREQ"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetDouble("RIMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetDouble("RRAGIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetDouble("RTIPO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_statoreg,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_imp_archfraz.GetString("TIPO")),3),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_archfraz.GetString("TOTCONT")),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(Cursor_imp_archfraz.GetString("TOTLIRE")),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_imp_archfraz.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_colleg,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_totin/100,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_totout/100,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo",true);
                  m_cSql = m_cSql+")";
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_nUpdatedRows = 0;
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.lt(m_nUpdatedRows,1)) {
                    // No rows inserted
                    /* gMsgProc := gMsgProc +"Rilevati errori nella tabella delle operazioni per l'operazione in data "+CharToDate(imp_archfraz->DATAOPE)+" con importo "+Str((Val(imp_archfraz->TOTLIRE))/100,14,2)+". L'attuale procedura di importazione verrà annullata automaticamente."+ NL */
                    gMsgProc = gMsgProc+"Rilevati errori nella tabella delle operazioni per l'operazione in data "+CPLib.CharToDate(Cursor_imp_archfraz.GetString("DATAOPE"))+" con importo "+CPLib.Str((CPLib.Val(Cursor_imp_archfraz.GetString("TOTLIRE")))/100,14,2)+". L'attuale procedura di importazione verrà annullata automaticamente."+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                    // Transaction Error
                    cTry0000006Cmsg = CPLib.FormatMsg(m_Ctx,"'%1'",gMsgProc);
                    m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"'%1'",gMsgProc));
                    m_cLastMsgError = "";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  /* If not(Empty(LRTrim(_oldidb))) */
                  if ( ! (CPLib.Empty(CPLib.LRTrim(_oldidb)))) {
                    // * --- Select from sogopefbo
                    m_cServer = m_Ctx.GetServer("sogopefbo");
                    m_cPhName = m_Ctx.GetPhName("sogopefbo");
                    if (Cursor_sogopefbo!=null)
                      Cursor_sogopefbo.Close();
                    Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_sogopefbo.Eof())) {
                      // * --- Insert into sogopefbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("sogopefbo");
                      m_cPhName = m_Ctx.GetPhName("sogopefbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000001E0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000001E0(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_sogopefbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sogopefbo",true);
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
                      Cursor_sogopefbo.Next();
                    }
                    m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
                    Cursor_sogopefbo.Close();
                    // * --- End Select
                    // * --- Delete from sogopefbo
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("sogopefbo");
                    m_cPhName = m_Ctx.GetPhName("sogopefbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000001E1")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer),m_cServer,_oldidb)+"";
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
                    // * --- Select from clientifrz
                    m_cServer = m_Ctx.GetServer("clientifrz");
                    m_cPhName = m_Ctx.GetPhName("clientifrz");
                    if (Cursor_clientifrz!=null)
                      Cursor_clientifrz.Close();
                    Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_clientifrz.Eof())) {
                      // * --- Insert into clientifrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("clientifrz");
                      m_cPhName = m_Ctx.GetPhName("clientifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000001E3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000001E3(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"clientifrz",true);
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
                      Cursor_clientifrz.Next();
                    }
                    m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
                    Cursor_clientifrz.Close();
                    // * --- End Select
                    // * --- Delete from clientifrz
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("clientifrz");
                    m_cPhName = m_Ctx.GetPhName("clientifrz");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000001E4")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer),m_cServer,_oldidb)+"";
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
                    // * --- Select from beneficfrz
                    m_cServer = m_Ctx.GetServer("beneficfrz");
                    m_cPhName = m_Ctx.GetPhName("beneficfrz");
                    if (Cursor_beneficfrz!=null)
                      Cursor_beneficfrz.Close();
                    Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_beneficfrz.Eof())) {
                      // * --- Insert into beneficfrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("beneficfrz");
                      m_cPhName = m_Ctx.GetPhName("beneficfrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000001E6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000001E6(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetDouble("CPROWNUM"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"beneficfrz",true);
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
                      Cursor_beneficfrz.Next();
                    }
                    m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
                    Cursor_beneficfrz.Close();
                    // * --- End Select
                    // * --- Delete from beneficfrz
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("beneficfrz");
                    m_cPhName = m_Ctx.GetPhName("beneficfrz");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000001E7")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer),m_cServer,_oldidb)+"";
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
                    // * --- Select from terzistifrz
                    m_cServer = m_Ctx.GetServer("terzistifrz");
                    m_cPhName = m_Ctx.GetPhName("terzistifrz");
                    if (Cursor_terzistifrz!=null)
                      Cursor_terzistifrz.Close();
                    Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_terzistifrz.Eof())) {
                      // * --- Insert into terzistifrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("terzistifrz");
                      m_cPhName = m_Ctx.GetPhName("terzistifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000001E9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000001E9(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"terzistifrz",true);
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
                      Cursor_terzistifrz.Next();
                    }
                    m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
                    Cursor_terzistifrz.Close();
                    // * --- End Select
                    // * --- Delete from terzistifrz
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("terzistifrz");
                    m_cPhName = m_Ctx.GetPhName("terzistifrz");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000001EA")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer),m_cServer,_oldidb)+"";
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
                  /* cNumNew := cNumNew + 1 */
                  cNumNew = CPLib.Round(cNumNew+1,0);
                } // End If
              } else { // Else
                /* mcErrori.AppendBlank() // Memori cursor per errori */
                mcErrori.AppendBlank();
                /* mcErrori.nomearch := imp_archfraz->INFORM // Memori cursor per errori */
                mcErrori.row.nomearch = Cursor_imp_archfraz.GetString("INFORM");
                /* mcErrori.numriga := 2 // Memori cursor per errori */
                mcErrori.row.numriga = 2;
                /* mcErrori.SaveRow() // Memori cursor per errori */
                mcErrori.SaveRow();
                /* _opeerr := 1 */
                _opeerr = CPLib.Round(1,0);
              } // End If
              Cursor_imp_archfraz.Next();
            }
            m_cConnectivityError = Cursor_imp_archfraz.ErrorMessage();
            Cursor_imp_archfraz.Close();
            // * --- End Select
          } // End If
          /* _contacicli := _contacicli+1 */
          _contacicli = CPLib.Round(_contacicli+1,0);
        } // End While
        /* If _generr=1 */
        if (CPLib.eqr(_generr,1)) {
          // Transaction Error
          m_Sql.AbortTransaction();
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000006Cstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000006Cstatus,cTry0000006Cmsg);
        }
      }
      for (MemoryCursorRow_tmp_errimp rowErr : mcErrori._iterable_()) {
        /* If rowErr.numriga=1 */
        if (CPLib.eqr(rowErr.numriga,1)) {
          // * --- Write into imp_archope from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("imp_archope");
          m_cPhName = m_Ctx.GetPhName("imp_archope");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"imp_archope",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000001F8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"IPCOLLEG = "+CPLib.ToSQL("Errore","C",15,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"imp_archope",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"INFORM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowErr.nomearch),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(rowErr.nomearch))+"";
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
        } else { // Else
          // * --- Write into imp_archfraz from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("imp_archfraz");
          m_cPhName = m_Ctx.GetPhName("imp_archfraz");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"imp_archfraz",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dati_da_tabelle",101,"000001F9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"IPCOLLEG = "+CPLib.ToSQL("Errore","C",15,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"imp_archfraz",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"INFORM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowErr.nomearch),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(rowErr.nomearch))+"";
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
      }
      /* Status Msg 'Fine elaborazione' */
      m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Fine elaborazione"));
      /* gMsgProc := gMsgProc + 'Operazioni Inserite o modificate: '+LRTrim(Str(cNumNew,10,0)) + NL */
      gMsgProc = gMsgProc+"Operazioni Inserite o modificate: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' delle operazioni' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" delle operazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione delle operazioni' // Messaggio Import */
      gMsgImp = "Fine importazione delle operazioni";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_tbcauana!=null)
          Cursor_tbcauana.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbcitta!=null)
          Cursor_tbcitta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
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
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_imp_archope!=null)
          Cursor_imp_archope.Close();
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
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
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
        if (Cursor_beneficope!=null)
          Cursor_beneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_terzistiope!=null)
          Cursor_terzistiope.Close();
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
      try {
        if (Cursor_qbe_imp_archfraz_minmax!=null)
          Cursor_qbe_imp_archfraz_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_imp_archfraz!=null)
          Cursor_imp_archfraz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sogopefbo!=null)
          Cursor_sogopefbo.Close();
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
        if (Cursor_beneficfrz!=null)
          Cursor_beneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_terzistifrz!=null)
          Cursor_terzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync() {
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_import_dati_da_tabelleR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_dati_da_tabelleR(p_Ctx, p_Caller);
  }
  public void Blank() {
    personbo_mc = new MemoryCursor_mcconnes_mcrdef();
    personbo_row = new MemoryCursorRow_mcconnes_mcrdef();
    anadip_mc = new MemoryCursor_anadip();
    tbcausana_mc = new MemoryCursor_tbcauana();
    tbcitta_mc = new MemoryCursor_tbcitta();
    mcErrori = new MemoryCursor_tmp_errimp();
    _conteggio = 0;
    _conteggio2 = 0;
    _attuale = 0;
    _codinter = CPLib.Space(11);
    _citinter = CPLib.Space(30);
    _cabinter = CPLib.Space(6);
    _prvinter = CPLib.Space(2);
    _flgmodi = CPLib.Space(1);
    _flgdataim = 0;
    _frapcli = CPLib.Space(1);
    cNumNew = 0;
    _coddip = CPLib.Space(6);
    _descerr = CPLib.Space(50);
    _findsub = 0;
    _intercod = CPLib.Space(11);
    _intercit = CPLib.Space(30);
    _intercab = CPLib.Space(6);
    _interprv = CPLib.Space(2);
    _unicode = CPLib.Space(10);
    _esito = 0;
    _rifimp = CPLib.Space(11);
    _idreg = CPLib.Space(20);
    stringaflagrap2 = CPLib.Space(9);
    _numprog = CPLib.Space(11);
    _flagrap2 = CPLib.Space(1);
    _oldidb = CPLib.Space(10);
    cFlagLire = CPLib.Space(1);
    _datareg = CPLib.NullDate();
    cFlagCont = CPLib.Space(1);
    cFlagFraz = CPLib.Space(1);
    _colleg = CPLib.Space(12);
    cIdCau = CPLib.Space(4);
    nProgImp = 0;
    conta = 0;
    _totin = 0;
    _totout = 0;
    cOpeProg1 = CPLib.Space(10);
    cOpeProg2 = CPLib.Space(11);
    _statoreg = CPLib.Space(1);
    _datarett = CPLib.NullDate();
    _idb2 = CPLib.Space(10);
    _benrag = CPLib.Space(70);
    _bensta = CPLib.Space(3);
    _bencta = CPLib.Space(30);
    _bencab = CPLib.Space(6);
    _benprv = CPLib.Space(2);
    _benind = CPLib.Space(35);
    _bencap = CPLib.Space(5);
    _opeerr = 0;
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _cicli = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _generr = 0;
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_imp_archfraz_minmax,
  public static final String m_cVQRList = ",qbe_imp_archfraz_minmax,";
  // ENTITY_BATCHES: ,arfn_conv_stato_uic,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_conv_stato_uic,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_000000C2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"meneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"merzistiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000106(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"AREAGEO,";
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
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
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
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000110(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000113(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000116(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"beneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000119(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"terzistiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000190(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mogopefbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000192(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000194(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"meneficfrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000196(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"merzistifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001D6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"AREAGEO,";
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
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
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
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001E0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopefbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001E3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001E6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"beneficfrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001E9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"terzistifrz",true);
    return p_cSql;
  }
}
