// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_trasf_prov_auiR implements CallerWithObjs {
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
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_docfrabo;
  public String m_cServer_docfrabo;
  public String m_cPhName_docopebo;
  public String m_cServer_docopebo;
  public String m_cPhName_fiduciabo;
  public String m_cServer_fiduciabo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_fraziobo_agg;
  public String m_cServer_fraziobo_agg;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_operazbo_agg;
  public String m_cServer_operazbo_agg;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_rapcoll;
  public String m_cServer_rapcoll;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_soginfo;
  public String m_cServer_soginfo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_storico_import;
  public String m_cServer_storico_import;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_terzistirap;
  public String m_cServer_terzistirap;
  public String m_cPhName_xapcoll;
  public String m_cServer_xapcoll;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xapotit;
  public String m_cServer_xapotit;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public String m_cPhName_xeneficfrz;
  public String m_cServer_xeneficfrz;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_xerzistifrz;
  public String m_cServer_xerzistifrz;
  public String m_cPhName_xerzistiope;
  public String m_cServer_xerzistiope;
  public String m_cPhName_xerzistirap;
  public String m_cServer_xerzistirap;
  public String m_cPhName_xiduciabo;
  public String m_cServer_xiduciabo;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xntestit;
  public String m_cServer_xntestit;
  public String m_cPhName_xocfrabo;
  public String m_cServer_xocfrabo;
  public String m_cPhName_xocopebo;
  public String m_cServer_xocopebo;
  public String m_cPhName_xoginfo;
  public String m_cServer_xoginfo;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xperazbo_agg;
  public String m_cServer_xperazbo_agg;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_xraziobo_agg;
  public String m_cServer_xraziobo_agg;
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
  public java.sql.Date pDatIni;
  public java.sql.Date pDatFin;
  public String pForza;
  public String pInform;
  public String pSource;
  public String pDoCheck;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public double gFlgDTP;
  public String gCodDip;
  public String cActLog;
  public String cProg1;
  public String cProg2;
  public String cProg3;
  public String cIDB2;
  public String w_idbase;
  public double _conta;
  public double _contano;
  public String w_cdaope;
  public String w_c_aope;
  public String w_cdareg;
  public String w_c_areg;
  public String w_datreg;
  public String w_RAPPORTO;
  public double _min;
  public double _max;
  public double _tot;
  public double _cicli;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public java.sql.Date _maxreg;
  public java.sql.Date _minreg;
  public String idb2;
  public java.sql.Date _datareg;
  public String _idrif;
  public double _totale;
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public String w_flgforce;
  public double nProgImp;
  public double _crap;
  public double _cinf;
  public MemoryCursor_xnarapbo mcRapporti;
  public double _contarow;
  public String _rapporto;
  public String _numprog;
  public double _maxdel;
  public double _flgdatareg;
  public String _oldprog;
  public String _nprog;
  public java.sql.Date _datafine;
  public double _nx;
  public double _sx;
  public java.sql.Date _date_oggi;
  public boolean fai_controlli;
  public String _error_string;
  public double _conta_err;
  public MemoryCursor_mcerrmcf_mcrdef mcErrori;
  public boolean _aborted;
  public boolean _passato_il_check;
  public boolean _passato_il_sub_check;
  public String _tmp;
  public MemoryCursor_mcstringa_mcrdef mcCauana;
  public MemoryCursorRow_mcstringa_mcrdef rwCauana;
  public MemoryCursor_storico_import mcNumimp_incontrati;
  public MemoryCursorRow_storico_import rwNumimp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_trasf_prov_auiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_trasf_prov_aui",m_Caller);
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
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    if (m_cPhName_beneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficfrz = m_cPhName_beneficfrz+" "+m_Ctx.GetWritePhName("beneficfrz");
    }
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
    m_cPhName_beneficope = p_ContextObject.GetPhName("beneficope");
    if (m_cPhName_beneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficope = m_cPhName_beneficope+" "+m_Ctx.GetWritePhName("beneficope");
    }
    m_cServer_beneficope = p_ContextObject.GetServer("beneficope");
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
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_docfrabo = p_ContextObject.GetPhName("docfrabo");
    if (m_cPhName_docfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docfrabo = m_cPhName_docfrabo+" "+m_Ctx.GetWritePhName("docfrabo");
    }
    m_cServer_docfrabo = p_ContextObject.GetServer("docfrabo");
    m_cPhName_docopebo = p_ContextObject.GetPhName("docopebo");
    if (m_cPhName_docopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docopebo = m_cPhName_docopebo+" "+m_Ctx.GetWritePhName("docopebo");
    }
    m_cServer_docopebo = p_ContextObject.GetServer("docopebo");
    m_cPhName_fiduciabo = p_ContextObject.GetPhName("fiduciabo");
    if (m_cPhName_fiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fiduciabo = m_cPhName_fiduciabo+" "+m_Ctx.GetWritePhName("fiduciabo");
    }
    m_cServer_fiduciabo = p_ContextObject.GetServer("fiduciabo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_fraziobo_agg = p_ContextObject.GetPhName("fraziobo_agg");
    if (m_cPhName_fraziobo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo_agg = m_cPhName_fraziobo_agg+" "+m_Ctx.GetWritePhName("fraziobo_agg");
    }
    m_cServer_fraziobo_agg = p_ContextObject.GetServer("fraziobo_agg");
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
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_operazbo_agg = p_ContextObject.GetPhName("operazbo_agg");
    if (m_cPhName_operazbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo_agg = m_cPhName_operazbo_agg+" "+m_Ctx.GetWritePhName("operazbo_agg");
    }
    m_cServer_operazbo_agg = p_ContextObject.GetServer("operazbo_agg");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_rapcoll = p_ContextObject.GetPhName("rapcoll");
    if (m_cPhName_rapcoll.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapcoll = m_cPhName_rapcoll+" "+m_Ctx.GetWritePhName("rapcoll");
    }
    m_cServer_rapcoll = p_ContextObject.GetServer("rapcoll");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    m_cPhName_soginfo = p_ContextObject.GetPhName("soginfo");
    if (m_cPhName_soginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_soginfo = m_cPhName_soginfo+" "+m_Ctx.GetWritePhName("soginfo");
    }
    m_cServer_soginfo = p_ContextObject.GetServer("soginfo");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    if (m_cPhName_sogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopefbo = m_cPhName_sogopefbo+" "+m_Ctx.GetWritePhName("sogopefbo");
    }
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    m_cPhName_storico_import = p_ContextObject.GetPhName("storico_import");
    if (m_cPhName_storico_import.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_storico_import = m_cPhName_storico_import+" "+m_Ctx.GetWritePhName("storico_import");
    }
    m_cServer_storico_import = p_ContextObject.GetServer("storico_import");
    m_cPhName_terzistifrz = p_ContextObject.GetPhName("terzistifrz");
    if (m_cPhName_terzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistifrz = m_cPhName_terzistifrz+" "+m_Ctx.GetWritePhName("terzistifrz");
    }
    m_cServer_terzistifrz = p_ContextObject.GetServer("terzistifrz");
    m_cPhName_terzistiope = p_ContextObject.GetPhName("terzistiope");
    if (m_cPhName_terzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistiope = m_cPhName_terzistiope+" "+m_Ctx.GetWritePhName("terzistiope");
    }
    m_cServer_terzistiope = p_ContextObject.GetServer("terzistiope");
    m_cPhName_terzistirap = p_ContextObject.GetPhName("terzistirap");
    if (m_cPhName_terzistirap.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistirap = m_cPhName_terzistirap+" "+m_Ctx.GetWritePhName("terzistirap");
    }
    m_cServer_terzistirap = p_ContextObject.GetServer("terzistirap");
    m_cPhName_xapcoll = p_ContextObject.GetPhName("xapcoll");
    if (m_cPhName_xapcoll.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapcoll = m_cPhName_xapcoll+" "+m_Ctx.GetWritePhName("xapcoll");
    }
    m_cServer_xapcoll = p_ContextObject.GetServer("xapcoll");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_xapotit = p_ContextObject.GetPhName("xapotit");
    if (m_cPhName_xapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapotit = m_cPhName_xapotit+" "+m_Ctx.GetWritePhName("xapotit");
    }
    m_cServer_xapotit = p_ContextObject.GetServer("xapotit");
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    if (m_cPhName_xelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xelegabo = m_cPhName_xelegabo+" "+m_Ctx.GetWritePhName("xelegabo");
    }
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    m_cPhName_xeneficfrz = p_ContextObject.GetPhName("xeneficfrz");
    if (m_cPhName_xeneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficfrz = m_cPhName_xeneficfrz+" "+m_Ctx.GetWritePhName("xeneficfrz");
    }
    m_cServer_xeneficfrz = p_ContextObject.GetServer("xeneficfrz");
    m_cPhName_xeneficope = p_ContextObject.GetPhName("xeneficope");
    if (m_cPhName_xeneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficope = m_cPhName_xeneficope+" "+m_Ctx.GetWritePhName("xeneficope");
    }
    m_cServer_xeneficope = p_ContextObject.GetServer("xeneficope");
    m_cPhName_xerzistifrz = p_ContextObject.GetPhName("xerzistifrz");
    if (m_cPhName_xerzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistifrz = m_cPhName_xerzistifrz+" "+m_Ctx.GetWritePhName("xerzistifrz");
    }
    m_cServer_xerzistifrz = p_ContextObject.GetServer("xerzistifrz");
    m_cPhName_xerzistiope = p_ContextObject.GetPhName("xerzistiope");
    if (m_cPhName_xerzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistiope = m_cPhName_xerzistiope+" "+m_Ctx.GetWritePhName("xerzistiope");
    }
    m_cServer_xerzistiope = p_ContextObject.GetServer("xerzistiope");
    m_cPhName_xerzistirap = p_ContextObject.GetPhName("xerzistirap");
    if (m_cPhName_xerzistirap.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistirap = m_cPhName_xerzistirap+" "+m_Ctx.GetWritePhName("xerzistirap");
    }
    m_cServer_xerzistirap = p_ContextObject.GetServer("xerzistirap");
    m_cPhName_xiduciabo = p_ContextObject.GetPhName("xiduciabo");
    if (m_cPhName_xiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xiduciabo = m_cPhName_xiduciabo+" "+m_Ctx.GetWritePhName("xiduciabo");
    }
    m_cServer_xiduciabo = p_ContextObject.GetServer("xiduciabo");
    m_cPhName_xlientifrz = p_ContextObject.GetPhName("xlientifrz");
    if (m_cPhName_xlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientifrz = m_cPhName_xlientifrz+" "+m_Ctx.GetWritePhName("xlientifrz");
    }
    m_cServer_xlientifrz = p_ContextObject.GetServer("xlientifrz");
    m_cPhName_xlientiope = p_ContextObject.GetPhName("xlientiope");
    if (m_cPhName_xlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientiope = m_cPhName_xlientiope+" "+m_Ctx.GetWritePhName("xlientiope");
    }
    m_cServer_xlientiope = p_ContextObject.GetServer("xlientiope");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xntestit = p_ContextObject.GetPhName("xntestit");
    if (m_cPhName_xntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestit = m_cPhName_xntestit+" "+m_Ctx.GetWritePhName("xntestit");
    }
    m_cServer_xntestit = p_ContextObject.GetServer("xntestit");
    m_cPhName_xocfrabo = p_ContextObject.GetPhName("xocfrabo");
    if (m_cPhName_xocfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocfrabo = m_cPhName_xocfrabo+" "+m_Ctx.GetWritePhName("xocfrabo");
    }
    m_cServer_xocfrabo = p_ContextObject.GetServer("xocfrabo");
    m_cPhName_xocopebo = p_ContextObject.GetPhName("xocopebo");
    if (m_cPhName_xocopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocopebo = m_cPhName_xocopebo+" "+m_Ctx.GetWritePhName("xocopebo");
    }
    m_cServer_xocopebo = p_ContextObject.GetServer("xocopebo");
    m_cPhName_xoginfo = p_ContextObject.GetPhName("xoginfo");
    if (m_cPhName_xoginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xoginfo = m_cPhName_xoginfo+" "+m_Ctx.GetWritePhName("xoginfo");
    }
    m_cServer_xoginfo = p_ContextObject.GetServer("xoginfo");
    m_cPhName_xogopebo = p_ContextObject.GetPhName("xogopebo");
    if (m_cPhName_xogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopebo = m_cPhName_xogopebo+" "+m_Ctx.GetWritePhName("xogopebo");
    }
    m_cServer_xogopebo = p_ContextObject.GetServer("xogopebo");
    m_cPhName_xogopefbo = p_ContextObject.GetPhName("xogopefbo");
    if (m_cPhName_xogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopefbo = m_cPhName_xogopefbo+" "+m_Ctx.GetWritePhName("xogopefbo");
    }
    m_cServer_xogopefbo = p_ContextObject.GetServer("xogopefbo");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xperazbo_agg = p_ContextObject.GetPhName("xperazbo_agg");
    if (m_cPhName_xperazbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo_agg = m_cPhName_xperazbo_agg+" "+m_Ctx.GetWritePhName("xperazbo_agg");
    }
    m_cServer_xperazbo_agg = p_ContextObject.GetServer("xperazbo_agg");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    if (m_cPhName_xraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo = m_cPhName_xraziobo+" "+m_Ctx.GetWritePhName("xraziobo");
    }
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_xraziobo_agg = p_ContextObject.GetPhName("xraziobo_agg");
    if (m_cPhName_xraziobo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo_agg = m_cPhName_xraziobo_agg+" "+m_Ctx.GetWritePhName("xraziobo_agg");
    }
    m_cServer_xraziobo_agg = p_ContextObject.GetServer("xraziobo_agg");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gFlgDTP",p_cVarName)) {
      return gFlgDTP;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_contano",p_cVarName)) {
      return _contano;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
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
    if (CPLib.eqr("_totale",p_cVarName)) {
      return _totale;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("_crap",p_cVarName)) {
      return _crap;
    }
    if (CPLib.eqr("_cinf",p_cVarName)) {
      return _cinf;
    }
    if (CPLib.eqr("_contarow",p_cVarName)) {
      return _contarow;
    }
    if (CPLib.eqr("_maxdel",p_cVarName)) {
      return _maxdel;
    }
    if (CPLib.eqr("_flgdatareg",p_cVarName)) {
      return _flgdatareg;
    }
    if (CPLib.eqr("_nx",p_cVarName)) {
      return _nx;
    }
    if (CPLib.eqr("_sx",p_cVarName)) {
      return _sx;
    }
    if (CPLib.eqr("_conta_err",p_cVarName)) {
      return _conta_err;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_trasf_prov_aui";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pForza",p_cVarName)) {
      return pForza;
    }
    if (CPLib.eqr("pInform",p_cVarName)) {
      return pInform;
    }
    if (CPLib.eqr("pSource",p_cVarName)) {
      return pSource;
    }
    if (CPLib.eqr("pDoCheck",p_cVarName)) {
      return pDoCheck;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
    }
    if (CPLib.eqr("cActLog",p_cVarName)) {
      return cActLog;
    }
    if (CPLib.eqr("cProg1",p_cVarName)) {
      return cProg1;
    }
    if (CPLib.eqr("cProg2",p_cVarName)) {
      return cProg2;
    }
    if (CPLib.eqr("cProg3",p_cVarName)) {
      return cProg3;
    }
    if (CPLib.eqr("cIDB2",p_cVarName)) {
      return cIDB2;
    }
    if (CPLib.eqr("idbase",p_cVarName)) {
      return w_idbase;
    }
    if (CPLib.eqr("cdaope",p_cVarName)) {
      return w_cdaope;
    }
    if (CPLib.eqr("c_aope",p_cVarName)) {
      return w_c_aope;
    }
    if (CPLib.eqr("cdareg",p_cVarName)) {
      return w_cdareg;
    }
    if (CPLib.eqr("c_areg",p_cVarName)) {
      return w_c_areg;
    }
    if (CPLib.eqr("datreg",p_cVarName)) {
      return w_datreg;
    }
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      return w_RAPPORTO;
    }
    if (CPLib.eqr("idb2",p_cVarName)) {
      return idb2;
    }
    if (CPLib.eqr("_idrif",p_cVarName)) {
      return _idrif;
    }
    if (CPLib.eqr("flgforce",p_cVarName)) {
      return w_flgforce;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      return _numprog;
    }
    if (CPLib.eqr("_oldprog",p_cVarName)) {
      return _oldprog;
    }
    if (CPLib.eqr("_nprog",p_cVarName)) {
      return _nprog;
    }
    if (CPLib.eqr("_error_string",p_cVarName)) {
      return _error_string;
    }
    if (CPLib.eqr("_tmp",p_cVarName)) {
      return _tmp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDatIni",p_cVarName)) {
      return pDatIni;
    }
    if (CPLib.eqr("pDatFin",p_cVarName)) {
      return pDatFin;
    }
    if (CPLib.eqr("_maxreg",p_cVarName)) {
      return _maxreg;
    }
    if (CPLib.eqr("_minreg",p_cVarName)) {
      return _minreg;
    }
    if (CPLib.eqr("_datareg",p_cVarName)) {
      return _datareg;
    }
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      return w_DaDatOpe;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      return w_ADatOpe;
    }
    if (CPLib.eqr("_datafine",p_cVarName)) {
      return _datafine;
    }
    if (CPLib.eqr("_date_oggi",p_cVarName)) {
      return _date_oggi;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("fai_controlli",p_cVarName)) {
      return fai_controlli;
    }
    if (CPLib.eqr("_aborted",p_cVarName)) {
      return _aborted;
    }
    if (CPLib.eqr("_passato_il_check",p_cVarName)) {
      return _passato_il_check;
    }
    if (CPLib.eqr("_passato_il_sub_check",p_cVarName)) {
      return _passato_il_sub_check;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcRapporti",p_cVarName)) {
      return mcRapporti;
    }
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      return mcErrori;
    }
    if (CPLib.eqr("mcCauana",p_cVarName)) {
      return mcCauana;
    }
    if (CPLib.eqr("mcNumimp_incontrati",p_cVarName)) {
      return mcNumimp_incontrati;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rwCauana",p_cVarName)) {
      return rwCauana;
    }
    if (CPLib.eqr("rwNumimp",p_cVarName)) {
      return rwNumimp;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("gFlgDTP",p_cVarName)) {
      gFlgDTP = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_contano",p_cVarName)) {
      _contano = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
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
    if (CPLib.eqr("_totale",p_cVarName)) {
      _totale = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("_crap",p_cVarName)) {
      _crap = value;
      return;
    }
    if (CPLib.eqr("_cinf",p_cVarName)) {
      _cinf = value;
      return;
    }
    if (CPLib.eqr("_contarow",p_cVarName)) {
      _contarow = value;
      return;
    }
    if (CPLib.eqr("_maxdel",p_cVarName)) {
      _maxdel = value;
      return;
    }
    if (CPLib.eqr("_flgdatareg",p_cVarName)) {
      _flgdatareg = value;
      return;
    }
    if (CPLib.eqr("_nx",p_cVarName)) {
      _nx = value;
      return;
    }
    if (CPLib.eqr("_sx",p_cVarName)) {
      _sx = value;
      return;
    }
    if (CPLib.eqr("_conta_err",p_cVarName)) {
      _conta_err = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pForza",p_cVarName)) {
      pForza = value;
      return;
    }
    if (CPLib.eqr("pInform",p_cVarName)) {
      pInform = value;
      return;
    }
    if (CPLib.eqr("pSource",p_cVarName)) {
      pSource = value;
      return;
    }
    if (CPLib.eqr("pDoCheck",p_cVarName)) {
      pDoCheck = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
      return;
    }
    if (CPLib.eqr("cActLog",p_cVarName)) {
      cActLog = value;
      return;
    }
    if (CPLib.eqr("cProg1",p_cVarName)) {
      cProg1 = value;
      return;
    }
    if (CPLib.eqr("cProg2",p_cVarName)) {
      cProg2 = value;
      return;
    }
    if (CPLib.eqr("cProg3",p_cVarName)) {
      cProg3 = value;
      return;
    }
    if (CPLib.eqr("cIDB2",p_cVarName)) {
      cIDB2 = value;
      return;
    }
    if (CPLib.eqr("idbase",p_cVarName)) {
      w_idbase = value;
      return;
    }
    if (CPLib.eqr("cdaope",p_cVarName)) {
      w_cdaope = value;
      return;
    }
    if (CPLib.eqr("c_aope",p_cVarName)) {
      w_c_aope = value;
      return;
    }
    if (CPLib.eqr("cdareg",p_cVarName)) {
      w_cdareg = value;
      return;
    }
    if (CPLib.eqr("c_areg",p_cVarName)) {
      w_c_areg = value;
      return;
    }
    if (CPLib.eqr("datreg",p_cVarName)) {
      w_datreg = value;
      return;
    }
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      w_RAPPORTO = value;
      return;
    }
    if (CPLib.eqr("idb2",p_cVarName)) {
      idb2 = value;
      return;
    }
    if (CPLib.eqr("_idrif",p_cVarName)) {
      _idrif = value;
      return;
    }
    if (CPLib.eqr("flgforce",p_cVarName)) {
      w_flgforce = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      _numprog = value;
      return;
    }
    if (CPLib.eqr("_oldprog",p_cVarName)) {
      _oldprog = value;
      return;
    }
    if (CPLib.eqr("_nprog",p_cVarName)) {
      _nprog = value;
      return;
    }
    if (CPLib.eqr("_error_string",p_cVarName)) {
      _error_string = value;
      return;
    }
    if (CPLib.eqr("_tmp",p_cVarName)) {
      _tmp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDatIni",p_cVarName)) {
      pDatIni = value;
      return;
    }
    if (CPLib.eqr("pDatFin",p_cVarName)) {
      pDatFin = value;
      return;
    }
    if (CPLib.eqr("_maxreg",p_cVarName)) {
      _maxreg = value;
      return;
    }
    if (CPLib.eqr("_minreg",p_cVarName)) {
      _minreg = value;
      return;
    }
    if (CPLib.eqr("_datareg",p_cVarName)) {
      _datareg = value;
      return;
    }
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      w_DaDatOpe = value;
      return;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      w_ADatOpe = value;
      return;
    }
    if (CPLib.eqr("_datafine",p_cVarName)) {
      _datafine = value;
      return;
    }
    if (CPLib.eqr("_date_oggi",p_cVarName)) {
      _date_oggi = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("fai_controlli",p_cVarName)) {
      fai_controlli = value;
      return;
    }
    if (CPLib.eqr("_aborted",p_cVarName)) {
      _aborted = value;
      return;
    }
    if (CPLib.eqr("_passato_il_check",p_cVarName)) {
      _passato_il_check = value;
      return;
    }
    if (CPLib.eqr("_passato_il_sub_check",p_cVarName)) {
      _passato_il_sub_check = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rwCauana",p_cVarName)) {
      rwCauana = (MemoryCursorRow_mcstringa_mcrdef)value;
      return;
    }
    if (CPLib.eqr("rwNumimp",p_cVarName)) {
      rwNumimp = (MemoryCursorRow_storico_import)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcRapporti",p_cVarName)) {
      mcRapporti = (MemoryCursor_xnarapbo)value;
      return;
    }
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      mcErrori = (MemoryCursor_mcerrmcf_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcCauana",p_cVarName)) {
      mcCauana = (MemoryCursor_mcstringa_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcNumimp_incontrati",p_cVarName)) {
      mcNumimp_incontrati = (MemoryCursor_storico_import)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void main() throws Exception {
    CPResultSet Cursor_qbe_tbcauana=null;
    CPResultSet Cursor_xperazbo=null;
    CPResultSet Cursor_xraziobo=null;
    CPResultSet Cursor_storico_import=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pDatIni Date */
      /* pDatFin Date */
      /* pForza Char(1) */
      /* pInform Char(30) // annotazioni varie / Rifimp esteso (9X) */
      /* pSource Char(0) // Sorgente della chiamata (o=opera, f=fraz, r=rapp, i=informazioni) */
      /* pDoCheck Char(0) // S = Si, N = No (Default = S)  */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gFlgDTP Numeric(1, 0) // Forza Data Trasferimento Provvisorie */
      /* gCodDip Char(6) // Dipendenza */
      /* cActLog Char(1) // Log Applicazione */
      /* cProg1 Char(10) */
      /* cProg2 Char(11) */
      /* cProg3 Char(10) */
      /* cIDB2 Char(10) */
      /* w_idbase Char(10) */
      /* _conta Numeric(10, 0) */
      /* _contano Numeric(10, 0) */
      /* w_cdaope Char(8) */
      /* w_c_aope Char(8) */
      /* w_cdareg Char(8) */
      /* w_c_areg Char(8) */
      /* w_datreg Char(8) */
      /* w_RAPPORTO Char(25) */
      /* _min Numeric(10, 0) */
      /* _max Numeric(10, 0) */
      /* _tot Numeric(10, 0) */
      /* _cicli Numeric(10, 0) */
      /* _contacicli Numeric(10, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _maxreg Date */
      /* _minreg Date */
      /* idb2 Char(10) */
      /* _datareg Date */
      /* _idrif Char(10) */
      /* _totale Numeric(10, 0) */
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_flgforce Char(1) */
      /* nProgImp Numeric(15, 0) */
      /* _crap Numeric(10, 0) */
      /* _cinf Numeric(10, 0) */
      /* _datareg Date */
      /* mcRapporti MemoryCursor(xnarapbo) */
      /* _contarow Numeric(3, 0) */
      /* _rapporto Char(25) */
      /* _numprog Char(11) */
      /* _maxdel Numeric(10, 0) */
      /* _flgdatareg Numeric(8, 0) */
      /* _oldprog Char(11) */
      /* _nprog Char(11) */
      /* _datafine Date */
      /* _nx Numeric(1, 0) */
      /* _sx Numeric(1, 0) */
      /* _date_oggi Date */
      /* fai_controlli Bool := iif(pDoCheck="N",False,True) */
      fai_controlli = (CPLib.eqr(pDoCheck,"N")?false:true);
      /* _error_string Char(0) := "" */
      _error_string = "";
      /* _conta_err Numeric(0, 0) := 0 */
      _conta_err = CPLib.Round(0,0);
      /* mcErrori MemoryCursor(mcErrMCF.MCRDef) // mc errori generico */
      /* _aborted Bool := False */
      _aborted = false;
      /* _passato_il_check Bool */
      /* _passato_il_sub_check Bool */
      /* _tmp Char(0) */
      /* mcCauana MemoryCursor(mcStringa.MCRDef) // MC dei codici Causali Analitiche+Sintetiche+Segno */
      /* rwCauana Row(mcStringa.MCRDef) */
      /* mcNumimp_incontrati MemoryCursor(storico_import) // MC di NUMIMP che ho incontrato lungo il trasferimento (possono essere più di uno) */
      /* rwNumimp Row(storico_import) */
      /* _date_oggi := Date() */
      _date_oggi = CPLib.Date();
      /* mcErrori := new MemoryCursor(mcErrMCF.MCRDef) */
      mcErrori = new MemoryCursor_mcerrmcf_mcrdef();
      /* gMsgProc := 'Ora Inizio Trasferimento: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Trasferimento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000004Estatus;
      nTry0000004Estatus = m_Sql.GetTransactionStatus();
      String cTry0000004Emsg;
      cTry0000004Emsg = m_Sql.TransactionErrorMessage();
      try {
        /* Case pSource="o" */
        if (CPLib.eqr(pSource,"o")) {
          // * --- Select from QBE_TBCAUANA
          if (Cursor_qbe_tbcauana!=null)
            Cursor_qbe_tbcauana.Close();
          Cursor_qbe_tbcauana = new VQRHolder("QBE_TBCAUANA",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_tbcauana.Eof())) {
            /* rwCauana := new Row(mcStringa.MCRDef) */
            rwCauana = new MemoryCursorRow_mcstringa_mcrdef();
            /* _tmp := ""+LRTrim(QBE_TBCAUANA->CODCAU)+LRTrim(QBE_TBCAUANA->CAUSINT)+LRTrim(QBE_TBCAUANA->SEGNO) // uso come chiave la concatenazione di: causale_analitica+causale_sintetica+segno    es. "15"+"6S"+"D" = "156SD" */
            _tmp = ""+CPLib.LRTrim(Cursor_qbe_tbcauana.GetString("CODCAU"))+CPLib.LRTrim(Cursor_qbe_tbcauana.GetString("CAUSINT"))+CPLib.LRTrim(Cursor_qbe_tbcauana.GetString("SEGNO"));
            /* rwCauana.CODICE := _tmp */
            rwCauana.CODICE = _tmp;
            /* rwCauana.ps_rowstatus := QBE_TBCAUANA->idbase */
            rwCauana.ps_rowstatus = Cursor_qbe_tbcauana.GetString("idbase");
            /* If not(mcCauana.HasKey(_tmp)) */
            if ( ! (mcCauana.HasKey(_tmp))) {
              /* mcCauana.AppendRowWithKey(_tmp,rwCauana ) // MC dei codici Causali Analitiche+Sintetiche+Segno */
              mcCauana.AppendRowWithKey(_tmp,rwCauana);
            } // End If
            Cursor_qbe_tbcauana.Next();
          }
          m_cConnectivityError = Cursor_qbe_tbcauana.ErrorMessage();
          Cursor_qbe_tbcauana.Close();
          // * --- End Select
          /* _tmp := "" */
          _tmp = "";
          // * --- Select from xperazbo
          m_cServer = m_Ctx.GetServer("xperazbo");
          m_cPhName = m_Ctx.GetPhName("xperazbo");
          if (Cursor_xperazbo!=null)
            Cursor_xperazbo.Close();
          Cursor_xperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("xperazbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" group by "+"NUMIMP ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_xperazbo.Eof())) {
            /* mcNumimp_incontrati.AppendBlank() // MC di NUMIMP che ho incontrato lungo il trasferimento (possono essere più di uno) */
            mcNumimp_incontrati.AppendBlank();
            /* mcNumimp_incontrati.NUMIMP := xperazbo->NUMIMP // MC di NUMIMP che ho incontrato lungo il trasferimento (possono essere più di uno) */
            mcNumimp_incontrati.row.NUMIMP = Cursor_xperazbo.GetDateTime("NUMIMP");
            Cursor_xperazbo.Next();
          }
          m_cConnectivityError = Cursor_xperazbo.ErrorMessage();
          Cursor_xperazbo.Close();
          // * --- End Select
          /* Exec "Operazioni" Page 2:ope */
          ope();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          for (MemoryCursorRow_storico_import rwImp : mcNumimp_incontrati._iterable_()) {
            /* If not(arfn_delete_import_numimp_check(rwImp.NUMIMP)) */
            if ( ! (arfn_delete_import_numimp_checkR.Make(m_Ctx,this).Run(rwImp.NUMIMP))) {
              // * --- Delete from storico_import
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("storico_import");
              m_cPhName = m_Ctx.GetPhName("storico_import");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"storico_import",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"0000005F")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rwImp.NUMIMP,"?",0,0,m_cServer),m_cServer,rwImp.NUMIMP)+"";
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
          }
          /* Case pSource="f" */
        } else if (CPLib.eqr(pSource,"f")) {
          // * --- Select from QBE_TBCAUANA
          if (Cursor_qbe_tbcauana!=null)
            Cursor_qbe_tbcauana.Close();
          Cursor_qbe_tbcauana = new VQRHolder("QBE_TBCAUANA",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_tbcauana.Eof())) {
            /* rwCauana := new Row(mcStringa.MCRDef) */
            rwCauana = new MemoryCursorRow_mcstringa_mcrdef();
            /* _tmp := ""+LRTrim(QBE_TBCAUANA->CODCAU)+LRTrim(QBE_TBCAUANA->CAUSINT)+LRTrim(QBE_TBCAUANA->SEGNO) // uso come chiave la concatenazione di: causale_analitica+causale_sintetica+segno    es. "15"+"6S"+"D" = "156SD" */
            _tmp = ""+CPLib.LRTrim(Cursor_qbe_tbcauana.GetString("CODCAU"))+CPLib.LRTrim(Cursor_qbe_tbcauana.GetString("CAUSINT"))+CPLib.LRTrim(Cursor_qbe_tbcauana.GetString("SEGNO"));
            /* rwCauana.CODICE := _tmp */
            rwCauana.CODICE = _tmp;
            /* rwCauana.ps_rowstatus := QBE_TBCAUANA->idbase */
            rwCauana.ps_rowstatus = Cursor_qbe_tbcauana.GetString("idbase");
            /* If not(mcCauana.HasKey(_tmp)) */
            if ( ! (mcCauana.HasKey(_tmp))) {
              /* mcCauana.AppendRowWithKey(_tmp,rwCauana ) // MC dei codici Causali Analitiche+Sintetiche+Segno */
              mcCauana.AppendRowWithKey(_tmp,rwCauana);
            } // End If
            Cursor_qbe_tbcauana.Next();
          }
          m_cConnectivityError = Cursor_qbe_tbcauana.ErrorMessage();
          Cursor_qbe_tbcauana.Close();
          // * --- End Select
          /* _tmp := "" */
          _tmp = "";
          // * --- Select from xraziobo
          m_cServer = m_Ctx.GetServer("xraziobo");
          m_cPhName = m_Ctx.GetPhName("xraziobo");
          if (Cursor_xraziobo!=null)
            Cursor_xraziobo.Close();
          Cursor_xraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("xraziobo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" group by "+"NUMIMP ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_xraziobo.Eof())) {
            /* mcNumimp_incontrati.AppendBlank() // MC di NUMIMP che ho incontrato lungo il trasferimento (possono essere più di uno) */
            mcNumimp_incontrati.AppendBlank();
            /* mcNumimp_incontrati.NUMIMP := xraziobo->NUMIMP // MC di NUMIMP che ho incontrato lungo il trasferimento (possono essere più di uno) */
            mcNumimp_incontrati.row.NUMIMP = Cursor_xraziobo.GetDateTime("NUMIMP");
            Cursor_xraziobo.Next();
          }
          m_cConnectivityError = Cursor_xraziobo.ErrorMessage();
          Cursor_xraziobo.Close();
          // * --- End Select
          /* Exec "Frazionate" Page 3:fraz */
          fraz();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          for (MemoryCursorRow_storico_import rwImp : mcNumimp_incontrati._iterable_()) {
            /* If not(arfn_delete_import_numimp_check(rwImp.NUMIMP)) */
            if ( ! (arfn_delete_import_numimp_checkR.Make(m_Ctx,this).Run(rwImp.NUMIMP))) {
              // * --- Delete from storico_import
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("storico_import");
              m_cPhName = m_Ctx.GetPhName("storico_import");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"storico_import",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"0000006E")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rwImp.NUMIMP,"?",0,0,m_cServer),m_cServer,rwImp.NUMIMP)+"";
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
          }
          /* Case pSource="r" */
        } else if (CPLib.eqr(pSource,"r")) {
          /* Exec "Rapporti" Page 4:rapp */
          rapp();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Exec "Informazioni" Page 5:info */
          info();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          // * --- Select from storico_import
          m_cServer = m_Ctx.GetServer("storico_import");
          m_cPhName = m_Ctx.GetPhName("storico_import");
          if (Cursor_storico_import!=null)
            Cursor_storico_import.Close();
          Cursor_storico_import = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"[NOTEMPTYDATE(ELIM_IMP)]=0 "+")"+(m_Ctx.IsSharedTemp("storico_import")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_storico_import.Eof())) {
            /* If not(arfn_delete_import_numimp_check(storico_import->NUMIMP)) */
            if ( ! (arfn_delete_import_numimp_checkR.Make(m_Ctx,this).Run(Cursor_storico_import.GetDateTime("NUMIMP")))) {
              // * --- Delete from storico_import
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("storico_import");
              m_cPhName = m_Ctx.GetPhName("storico_import");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"storico_import",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000073")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_storico_import.GetDateTime("NUMIMP"),"?",0,0,m_cServer),m_cServer,Cursor_storico_import.GetDateTime("NUMIMP"))+"";
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
            Cursor_storico_import.Next();
          }
          m_cConnectivityError = Cursor_storico_import.ErrorMessage();
          Cursor_storico_import.Close();
          // * --- End Select
          /* Case pSource="t" */
        } else if (CPLib.eqr(pSource,"t")) {
          /* Exec "Titolari" Page 6:tito */
          tito();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          // * --- Select from storico_import
          m_cServer = m_Ctx.GetServer("storico_import");
          m_cPhName = m_Ctx.GetPhName("storico_import");
          if (Cursor_storico_import!=null)
            Cursor_storico_import.Close();
          Cursor_storico_import = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NUMIMP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"[NOTEMPTYDATE(ELIM_IMP)]=0 "+")"+(m_Ctx.IsSharedTemp("storico_import")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_storico_import.Eof())) {
            /* If not(arfn_delete_import_numimp_check(storico_import->NUMIMP)) */
            if ( ! (arfn_delete_import_numimp_checkR.Make(m_Ctx,this).Run(Cursor_storico_import.GetDateTime("NUMIMP")))) {
              // * --- Delete from storico_import
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("storico_import");
              m_cPhName = m_Ctx.GetPhName("storico_import");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"storico_import",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000077")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_storico_import.GetDateTime("NUMIMP"),"?",0,0,m_cServer),m_cServer,Cursor_storico_import.GetDateTime("NUMIMP"))+"";
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
            Cursor_storico_import.Next();
          }
          m_cConnectivityError = Cursor_storico_import.ErrorMessage();
          Cursor_storico_import.Close();
          // * --- End Select
        } // End Case
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* _aborted := True */
        _aborted = true;
        /* mcErrori.AppendBlank() */
        mcErrori.AppendBlank();
        /* mcErrori.ERCODICE := "" */
        mcErrori.row.ERCODICE = "";
        /* mcErrori.ERDESCRI := "Il trasferimento è stato bloccato!"+NL+NL+'Errore SQL: ' + m_Sql.TransactionErrorMessage() */
        mcErrori.row.ERDESCRI = "Il trasferimento è stato bloccato!"+"\n"+"\n"+"Errore SQL: "+m_Sql.TransactionErrorMessage();
        /* mcErrori.SaveRow() */
        mcErrori.SaveRow();
        /* gMsgProc := gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
        gMsgProc = gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := "Elaborazione Terminata con errori Non è stata trasferita alcuna operazione" // Messaggio Import */
        gMsgImp = "Elaborazione Terminata con errori Non è stata trasferita alcuna operazione";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000004Estatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000004Estatus,cTry0000004Emsg);
        }
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Trasferimento: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Trasferimento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If mcErrori.RecCount()=0 */
      if (CPLib.eqr(mcErrori.RecCount(),0)) {
        /* mcErrori.AppendBlank() */
        mcErrori.AppendBlank();
        /* mcErrori.ERCODICE := "" */
        mcErrori.row.ERCODICE = "";
        /* mcErrori.ERDESCRI := "TRASFERIMENTO AVVENUTO SENZA ERRORI  " */
        mcErrori.row.ERDESCRI = "TRASFERIMENTO AVVENUTO SENZA ERRORI  ";
        /* mcErrori.SaveRow() */
        mcErrori.SaveRow();
        /* ElseIf mcErrori.RecCount()=1 and _aborted */
      } else if (CPLib.eqr(mcErrori.RecCount(),1) && _aborted) {
        /* gMsgImp := "Elaborazione Terminata. Trasferimento abortito." // Messaggio Import */
        gMsgImp = "Elaborazione Terminata. Trasferimento abortito.";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* ElseIf mcErrori.RecCount()>0 and not(_aborted) */
      } else if (CPLib.gt(mcErrori.RecCount(),0) &&  ! (_aborted)) {
        /* gMsgImp := "Elaborazione Terminata con presenza di anomalie. Prelevare il file generato" // Messaggio Import */
        gMsgImp = "Elaborazione Terminata con presenza di anomalie. Prelevare il file generato";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
      /* If cActLog='S' */
      if (CPLib.eqr(cActLog,"S")) {
        /* Exec Routine arrt_writelog("Trasferimento AUI",iif(pSource='o','Operazioni',iif(pSource='f','Frazionate',iif(pSource='r','Rapporti','Legami'))),'',gMsgProc) */
        arrt_writelogR.Make(m_Ctx,this).Run("Trasferimento AUI",(CPLib.eqr(pSource,"o")?"Operazioni":(CPLib.eqr(pSource,"f")?"Frazionate":(CPLib.eqr(pSource,"r")?"Rapporti":"Legami"))),"",gMsgProc);
      } // End If
      /* Return mcErrori */
      throw new Stop(mcErrori);
    } finally {
      try {
        if (Cursor_qbe_tbcauana!=null)
          Cursor_qbe_tbcauana.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xperazbo!=null)
          Cursor_xperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xraziobo!=null)
          Cursor_xraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_storico_import!=null)
          Cursor_storico_import.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void ope() throws Exception {
    CPResultSet Cursor_qbe_trasf_ope_nx=null;
    CPResultSet Cursor_qbe_trasf_ope_sx=null;
    CPResultSet Cursor_qbe_trasfope_controllo_totale=null;
    CPResultSet Cursor_qbe_trasfope_datope=null;
    CPResultSet Cursor_qbe_trasfope_count_ope=null;
    CPResultSet Cursor_qbe_trasfope_idbase_ope=null;
    CPResultSet Cursor_xperazbo=null;
    CPResultSet Cursor_xperazbo_agg=null;
    CPResultSet Cursor_xogopebo=null;
    CPResultSet Cursor_xlientiope=null;
    CPResultSet Cursor_xeneficope=null;
    CPResultSet Cursor_xerzistiope=null;
    CPResultSet Cursor_xocopebo=null;
    CPResultSet Cursor_xapcoll=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* mcqbe_trasfope_controllo_totale MemoryCursor(qbe_trasfope_controllo_totale.vqr) // Operazioni definitive con lo stesso rifimp o inform */
      MemoryCursor_qbe_trasfope_controllo_totale_vqr mcqbe_trasfope_controllo_totale;
      mcqbe_trasfope_controllo_totale = new MemoryCursor_qbe_trasfope_controllo_totale_vqr();
      /* Scorre la query e trasferisce i dati */
      /* w_DaDatOpe := pDatIni */
      w_DaDatOpe = pDatIni;
      /* w_ADatOpe := pDatFin */
      w_ADatOpe = pDatFin;
      /* w_flgforce := pForza */
      w_flgforce = pForza;
      /* gMsgImp := "Selezione record da elaborare..." // Messaggio Import */
      gMsgImp = "Selezione record da elaborare...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* w_cdaope := iif(Empty(w_DaDatOpe) or DateToChar(w_DaDatOpe)='01000101','',DateToChar(w_DaDatOpe)) */
      w_cdaope = (CPLib.Empty(w_DaDatOpe) || CPLib.eqr(CPLib.DateToChar(w_DaDatOpe),"01000101")?"":CPLib.DateToChar(w_DaDatOpe));
      /* w_c_aope := iif(Empty(w_ADatOpe) or DateToChar(w_ADatOpe)='01000101','',DateToChar(w_ADatOpe)) */
      w_c_aope = (CPLib.Empty(w_ADatOpe) || CPLib.eqr(CPLib.DateToChar(w_ADatOpe),"01000101")?"":CPLib.DateToChar(w_ADatOpe));
      /* w_cdareg := '' */
      w_cdareg = "";
      /* w_c_areg := '' */
      w_c_areg = "";
      /* _totale := 0 */
      _totale = CPLib.Round(0,0);
      /* _nx := 0 */
      _nx = CPLib.Round(0,0);
      /* _sx := 0 */
      _sx = CPLib.Round(0,0);
      // * --- Select from qbe_trasf_ope_nx
      if (Cursor_qbe_trasf_ope_nx!=null)
        Cursor_qbe_trasf_ope_nx.Close();
      Cursor_qbe_trasf_ope_nx = new VQRHolder("qbe_trasf_ope_nx",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_trasf_ope_nx.Eof())) {
        /* _nx := iif(qbe_trasf_ope_nx->TOTALE>0,1,0) */
        _nx = CPLib.Round((CPLib.gt(Cursor_qbe_trasf_ope_nx.GetDouble("TOTALE"),0)?1:0),0);
        Cursor_qbe_trasf_ope_nx.Next();
      }
      m_cConnectivityError = Cursor_qbe_trasf_ope_nx.ErrorMessage();
      Cursor_qbe_trasf_ope_nx.Close();
      // * --- End Select
      // * --- Select from qbe_trasf_ope_sx
      if (Cursor_qbe_trasf_ope_sx!=null)
        Cursor_qbe_trasf_ope_sx.Close();
      Cursor_qbe_trasf_ope_sx = new VQRHolder("qbe_trasf_ope_sx",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_trasf_ope_sx.Eof())) {
        /* _sx := iif(qbe_trasf_ope_sx->TOTALE>0,1,0) */
        _sx = CPLib.Round((CPLib.gt(Cursor_qbe_trasf_ope_sx.GetDouble("TOTALE"),0)?1:0),0);
        Cursor_qbe_trasf_ope_sx.Next();
      }
      m_cConnectivityError = Cursor_qbe_trasf_ope_sx.ErrorMessage();
      Cursor_qbe_trasf_ope_sx.Close();
      // * --- End Select
      /* If w_flgforce <> 'S' and (_nx=1 or _sx=1) */
      if (CPLib.ne(w_flgforce,"S") && (CPLib.eqr(_nx,1) || CPLib.eqr(_sx,1))) {
        // * --- Fill memory cursor mcqbe_trasfope_controllo_totale on qbe_trasfope_controllo_totale
        mcqbe_trasfope_controllo_totale.Zap();
        SPBridge.HMCaller _h0000009F;
        _h0000009F = new SPBridge.HMCaller();
        _h0000009F.Set("m_cVQRList",m_cVQRList);
        _h0000009F.Set("cdaope",w_cdaope);
        _h0000009F.Set("c_aope",w_c_aope);
        _h0000009F.Set("pInform",pInform);
        _h0000009F.Set("_nx",_nx);
        _h0000009F.Set("_sx",_sx);
        if (Cursor_qbe_trasfope_controllo_totale!=null)
          Cursor_qbe_trasfope_controllo_totale.Close();
        Cursor_qbe_trasfope_controllo_totale = new VQRHolder("qbe_trasfope_controllo_totale",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000009F,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_trasfope_controllo_totale;
          Cursor_qbe_trasfope_controllo_totale.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_trasf_prov_aui: query on qbe_trasfope_controllo_totale returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_trasfope_controllo_totale.Eof())) {
          mcqbe_trasfope_controllo_totale.AppendBlank();
          mcqbe_trasfope_controllo_totale.row.NUMPROG = Cursor_qbe_trasfope_controllo_totale.GetString("NUMPROG");
          mcqbe_trasfope_controllo_totale.row.RIFIMP = Cursor_qbe_trasfope_controllo_totale.GetString("RIFIMP");
          mcqbe_trasfope_controllo_totale.row.INFORM = Cursor_qbe_trasfope_controllo_totale.GetString("INFORM");
          Cursor_qbe_trasfope_controllo_totale.Next();
        }
        m_cConnectivityError = Cursor_qbe_trasfope_controllo_totale.ErrorMessage();
        Cursor_qbe_trasfope_controllo_totale.Close();
        mcqbe_trasfope_controllo_totale.GoTop();
      } // End If
      /* If mcqbe_trasfope_controllo_totale.IsEmpty() */
      if (mcqbe_trasfope_controllo_totale.IsEmpty()) {
        // * --- Select from qbe_trasfope_datope
        SPBridge.HMCaller _h000000A1;
        _h000000A1 = new SPBridge.HMCaller();
        _h000000A1.Set("m_cVQRList",m_cVQRList);
        _h000000A1.Set("cdaope",w_cdaope);
        _h000000A1.Set("c_aope",w_c_aope);
        _h000000A1.Set("pInform",pInform);
        if (Cursor_qbe_trasfope_datope!=null)
          Cursor_qbe_trasfope_datope.Close();
        Cursor_qbe_trasfope_datope = new VQRHolder("qbe_trasfope_datope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000A1,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_trasfope_datope.Eof())) {
          /* w_datreg := DateToChar(qbe_trasfope_datope->DATAOPE) */
          w_datreg = CPLib.DateToChar(Cursor_qbe_trasfope_datope.GetDate("DATAOPE"));
          // * --- Select from qbe_trasfope_count_ope
          SPBridge.HMCaller _h000000A3;
          _h000000A3 = new SPBridge.HMCaller();
          _h000000A3.Set("m_cVQRList",m_cVQRList);
          _h000000A3.Set("datreg",w_datreg);
          if (Cursor_qbe_trasfope_count_ope!=null)
            Cursor_qbe_trasfope_count_ope.Close();
          Cursor_qbe_trasfope_count_ope = new VQRHolder("qbe_trasfope_count_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000A3,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_trasfope_count_ope.Eof())) {
            /* _min := qbe_trasfope_count_ope->MINOPE */
            _min = CPLib.Round(Cursor_qbe_trasfope_count_ope.GetDouble("MINOPE"),0);
            /* _max := qbe_trasfope_count_ope->MAXOPE */
            _max = CPLib.Round(Cursor_qbe_trasfope_count_ope.GetDouble("MAXOPE"),0);
            /* _tot := qbe_trasfope_count_ope->TOTOPE */
            _tot = CPLib.Round(Cursor_qbe_trasfope_count_ope.GetDouble("TOTOPE"),0);
            Cursor_qbe_trasfope_count_ope.Next();
          }
          m_cConnectivityError = Cursor_qbe_trasfope_count_ope.ErrorMessage();
          Cursor_qbe_trasfope_count_ope.Close();
          // * --- End Select
          /* If _tot < 5000 */
          if (CPLib.lt(_tot,5000)) {
            /* _cicli := iif(_tot=0,0,1) */
            _cicli = CPLib.Round((CPLib.eqr(_tot,0)?0:1),0);
          } else { // Else
            /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
            _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
          } // End If
          /* _contacicli := 1 */
          _contacicli = CPLib.Round(1,0);
          /* While _contacicli<=_cicli */
          while (CPLib.le(_contacicli,_cicli)) {
            /* If _cicli = 1 */
            if (CPLib.eqr(_cicli,1)) {
              /* _bottom := _min */
              _bottom = CPLib.Round(_min,0);
              /* _top := _max */
              _top = CPLib.Round(_max,0);
            } else { // Else
              /* _bottom := ((_contacicli -1 ) * 5000) + 1 */
              _bottom = CPLib.Round(((_contacicli-1)*5000)+1,0);
              /* _top := _contacicli * 5000 */
              _top = CPLib.Round(_contacicli*5000,0);
            } // End If
            /* gMsgImp := 'Lettura operazioni in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
            gMsgImp = "Lettura operazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If _top>=_min */
            if (CPLib.ge(_top,_min)) {
              // * --- Select from qbe_trasfope_idbase_ope
              if (Cursor_qbe_trasfope_idbase_ope!=null)
                Cursor_qbe_trasfope_idbase_ope.Close();
              Cursor_qbe_trasfope_idbase_ope = new VQRHolder("qbe_trasfope_idbase_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_trasfope_idbase_ope.Eof())) {
                /* w_idbase := qbe_trasfope_idbase_ope->IDBASE */
                w_idbase = Cursor_qbe_trasfope_idbase_ope.GetString("IDBASE");
                // * --- Select from xperazbo
                m_cServer = m_Ctx.GetServer("xperazbo");
                m_cPhName = m_Ctx.GetPhName("xperazbo");
                if (Cursor_xperazbo!=null)
                  Cursor_xperazbo.Close();
                Cursor_xperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,w_idbase)+" "+")"+(m_Ctx.IsSharedTemp("xperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xperazbo.Eof())) {
                  /* _passato_il_check := True  */
                  _passato_il_check = true;
                  /* If fai_controlli */
                  if (fai_controlli) {
                    /* _error_string := '' */
                    _error_string = "";
                    /* If (DateDiff(xperazbo->DATAOPE, _date_oggi))>(20*365) */
                    if (CPLib.gt((CPLib.DateDiff(Cursor_xperazbo.GetDate("DATAOPE"),_date_oggi)),(20*365))) {
                      /* _error_string := ' Data Operazione più vecchia di 20 Anni,' */
                      _error_string = " Data Operazione più vecchia di 20 Anni,";
                      /* _passato_il_check := False */
                      _passato_il_check = false;
                    } // End If
                    /* If xperazbo->DATAOPE>_date_oggi */
                    if (CPLib.gt(Cursor_xperazbo.GetDate("DATAOPE"),_date_oggi)) {
                      /* _error_string := _error_string+' Data Operazione maggiore della Data odierna,' */
                      _error_string = _error_string+" Data Operazione maggiore della Data odierna,";
                      /* _passato_il_check := False */
                      _passato_il_check = false;
                    } // End If
                    /* _tmp := ""+LRTrim(xperazbo->CODANA)+LRTrim(xperazbo->CODVOC)+LRTrim(xperazbo->SEGNO) // CODANA+CODVOC+SEGNO */
                    _tmp = ""+CPLib.LRTrim(Cursor_xperazbo.GetString("CODANA"))+CPLib.LRTrim(Cursor_xperazbo.GetString("CODVOC"))+CPLib.LRTrim(Cursor_xperazbo.GetString("SEGNO"));
                    /* If not(mcCauana.HasKey(_tmp)) */
                    if ( ! (mcCauana.HasKey(_tmp))) {
                      /* _error_string := _error_string+' Anomalia sui campi Causale Analitica e/o Causale Sintetica e/o Segno,' */
                      _error_string = _error_string+" Anomalia sui campi Causale Analitica e/o Causale Sintetica e/o Segno,";
                      /* _passato_il_check := False */
                      _passato_il_check = false;
                    } // End If
                    /* _tmp := "" */
                    _tmp = "";
                    /* _error_string := Substr(_error_string,2,Len(_error_string)-2)+"." */
                    _error_string = CPLib.Substr(_error_string,2,CPLib.Len(_error_string)-2)+".";
                  } // End If
                  /* If _passato_il_check */
                  if (_passato_il_check) {
                    /* Calcol i nuovi progressivi */
                    /* idb2 := LibreriaMit.UniqueId() */
                    idb2 = LibreriaMit.UniqueId();
                    /* cProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
                    cProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
                    /* cProg2 := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(gAzienda)+"'",Space(11),11) */
                    cProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(11),11);
                    /* _datareg := Date() */
                    _datareg = CPLib.Date();
                    // * --- Insert into operazbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("operazbo");
                    m_cPhName = m_Ctx.GetPhName("operazbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000CC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000CC(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("ANNOOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datareg),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDate("DATAIMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDate("DATAOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datareg,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDate("DATARETT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(idb2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cProg2,9)+idb2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("IMPIN"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("IMPOUT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("IMPSARA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("MITIG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("MITIGDOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("NOPROT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("NOSARA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("PROQUOTA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("RAREA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("RCOMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("RFREQ"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("RIMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("RTIPO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("SV58550"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("SV58550MA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("TIPOORO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("MEZPAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("PRESTAZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetDouble("CAUSALE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo.GetString("VASP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
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
                    // * --- Select from xperazbo_agg
                    m_cServer = m_Ctx.GetServer("xperazbo_agg");
                    m_cPhName = m_Ctx.GetPhName("xperazbo_agg");
                    if (Cursor_xperazbo_agg!=null)
                      Cursor_xperazbo_agg.Close();
                    Cursor_xperazbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,w_idbase)+" "+")"+(m_Ctx.IsSharedTemp("xperazbo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xperazbo_agg.Eof())) {
                      // * --- Insert into operazbo_agg from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("operazbo_agg");
                      m_cPhName = m_Ctx.GetPhName("operazbo_agg");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo_agg",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000CE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000CE(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetDouble("CACODICE"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("IDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetDateTime("CADATAORA"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetDouble("CATIPGIO"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetDouble("CATIPCON"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetDouble("CAPV_COD"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("IDDOCALL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("VPCODICE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetDate("WUDATRET"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetDouble("FLAGFRAUD"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("SV58724"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("SV58726SCA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("SV58726SA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("SV58726PISP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("C_COGNOME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("C_NOME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xperazbo_agg.GetString("SOSPAGAM"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo_agg",true);
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
                      // * --- Delete from xperazbo_agg
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xperazbo_agg");
                      m_cPhName = m_Ctx.GetPhName("xperazbo_agg");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo_agg",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000CF")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"?",0,0,m_cServer),m_cServer,w_idbase)+"";
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
                      Cursor_xperazbo_agg.Next();
                    }
                    m_cConnectivityError = Cursor_xperazbo_agg.ErrorMessage();
                    Cursor_xperazbo_agg.Close();
                    // * --- End Select
                    // * --- Select from xogopebo
                    m_cServer = m_Ctx.GetServer("xogopebo");
                    m_cPhName = m_Ctx.GetPhName("xogopebo");
                    if (Cursor_xogopebo!=null)
                      Cursor_xogopebo.Close();
                    Cursor_xogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xogopebo.Eof())) {
                      // * --- Insert into sogopebo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("sogopebo");
                      m_cPhName = m_Ctx.GetPhName("sogopebo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000D1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000D1(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xogopebo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xogopebo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
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
                      }
                      // * --- Delete from xogopebo
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xogopebo");
                      m_cPhName = m_Ctx.GetPhName("xogopebo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xogopebo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000D2")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xogopebo.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xogopebo.GetString("IDFILEBO"))+"";
                      m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xogopebo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_xogopebo.GetDouble("CPROWNUM"))+"";
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
                      Cursor_xogopebo.Next();
                    }
                    m_cConnectivityError = Cursor_xogopebo.ErrorMessage();
                    Cursor_xogopebo.Close();
                    // * --- End Select
                    // * --- Select from xlientiope
                    m_cServer = m_Ctx.GetServer("xlientiope");
                    m_cPhName = m_Ctx.GetPhName("xlientiope");
                    if (Cursor_xlientiope!=null)
                      Cursor_xlientiope.Close();
                    Cursor_xlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xlientiope.Eof())) {
                      // * --- Insert into clientiope from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("clientiope");
                      m_cPhName = m_Ctx.GetPhName("clientiope");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000D4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000D4(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
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
                      }
                      // * --- Delete from xlientiope
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xlientiope");
                      m_cPhName = m_Ctx.GetPhName("xlientiope");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientiope",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000D5")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xlientiope.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xlientiope.GetString("IDFILEBO"))+"";
                      m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xlientiope.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xlientiope.GetString("CODSOG"))+"";
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
                      Cursor_xlientiope.Next();
                    }
                    m_cConnectivityError = Cursor_xlientiope.ErrorMessage();
                    Cursor_xlientiope.Close();
                    // * --- End Select
                    // * --- Select from xeneficope
                    m_cServer = m_Ctx.GetServer("xeneficope");
                    m_cPhName = m_Ctx.GetPhName("xeneficope");
                    if (Cursor_xeneficope!=null)
                      Cursor_xeneficope.Close();
                    Cursor_xeneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xeneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xeneficope.Eof())) {
                      // * --- Insert into beneficope from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("beneficope");
                      m_cPhName = m_Ctx.GetPhName("beneficope");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000D7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000D7(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetDouble("CPROWNUM"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
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
                      }
                      // * --- Delete from xeneficope
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xeneficope");
                      m_cPhName = m_Ctx.GetPhName("xeneficope");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficope",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000D8")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xeneficope.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xeneficope.GetString("IDFILEBO"))+"";
                      m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xeneficope.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_xeneficope.GetDouble("CPROWNUM"))+"";
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
                      Cursor_xeneficope.Next();
                    }
                    m_cConnectivityError = Cursor_xeneficope.ErrorMessage();
                    Cursor_xeneficope.Close();
                    // * --- End Select
                    // * --- Select from xerzistiope
                    m_cServer = m_Ctx.GetServer("xerzistiope");
                    m_cPhName = m_Ctx.GetPhName("xerzistiope");
                    if (Cursor_xerzistiope!=null)
                      Cursor_xerzistiope.Close();
                    Cursor_xerzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xerzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xerzistiope.Eof())) {
                      // * --- Insert into terzistiope from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("terzistiope");
                      m_cPhName = m_Ctx.GetPhName("terzistiope");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000DA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000DA(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
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
                      }
                      // * --- Delete from xerzistiope
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xerzistiope");
                      m_cPhName = m_Ctx.GetPhName("xerzistiope");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xerzistiope",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000DB")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xerzistiope.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xerzistiope.GetString("IDFILEBO"))+"";
                      m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xerzistiope.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xerzistiope.GetString("CODSOG"))+"";
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
                      Cursor_xerzistiope.Next();
                    }
                    m_cConnectivityError = Cursor_xerzistiope.ErrorMessage();
                    Cursor_xerzistiope.Close();
                    // * --- End Select
                    // * --- Select from xocopebo
                    m_cServer = m_Ctx.GetServer("xocopebo");
                    m_cPhName = m_Ctx.GetPhName("xocopebo");
                    if (Cursor_xocopebo!=null)
                      Cursor_xocopebo.Close();
                    Cursor_xocopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_xperazbo.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xocopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xocopebo.Eof())) {
                      // * --- Insert into docopebo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("docopebo");
                      m_cPhName = m_Ctx.GetPhName("docopebo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"docopebo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000DD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000DD(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetDate("DATARILASC"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetDate("DATAVALI"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocopebo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"docopebo",true);
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
                      // * --- Delete from xocopebo
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xocopebo");
                      m_cPhName = m_Ctx.GetPhName("xocopebo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xocopebo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000DE")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xocopebo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_xocopebo.GetString("NUMPROG"))+"";
                      m_cSql = m_cSql+" and CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xocopebo.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_xocopebo.GetString("CONNESCLI"))+"";
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
                      Cursor_xocopebo.Next();
                    }
                    m_cConnectivityError = Cursor_xocopebo.ErrorMessage();
                    Cursor_xocopebo.Close();
                    // * --- End Select
                    // * --- Select from xapcoll
                    m_cServer = m_Ctx.GetServer("xapcoll");
                    m_cPhName = m_Ctx.GetPhName("xapcoll");
                    if (Cursor_xapcoll!=null)
                      Cursor_xapcoll.Close();
                    Cursor_xapcoll = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xapcoll")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xapcoll.Eof())) {
                      // * --- Insert into rapcoll from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("rapcoll");
                      m_cPhName = m_Ctx.GetPhName("rapcoll");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapcoll",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000E0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000000E0(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapcoll.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapcoll.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"rapcoll",true);
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
                      // * --- Delete from xapcoll
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xapcoll");
                      m_cPhName = m_Ctx.GetPhName("xapcoll");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapcoll",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000E1")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapcoll.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xapcoll.GetString("IDFILEBO"))+"";
                      m_cSql = m_cSql+" and RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapcoll.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xapcoll.GetString("RAPPORTO"))+"";
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
                      Cursor_xapcoll.Next();
                    }
                    m_cConnectivityError = Cursor_xapcoll.ErrorMessage();
                    Cursor_xapcoll.Close();
                    // * --- End Select
                    // * --- Delete from xperazbo
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("xperazbo");
                    m_cPhName = m_Ctx.GetPhName("xperazbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000000E2")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xperazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_xperazbo.GetString("IDBASE"))+"";
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
                    /* _conta := _conta + 1 */
                    _conta = CPLib.Round(_conta+1,0);
                    /* gMsgImp := "Sono state trasferite "+LRTrim(Str(_conta,10,0))+" operazioni" // Messaggio Import */
                    gMsgImp = "Sono state trasferite "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" operazioni";
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  } else { // Else
                    /* Check non passato :( */
                    /* _conta_err := _conta_err+1 */
                    _conta_err = CPLib.Round(_conta_err+1,0);
                    /* mcErrori.AppendBlank() */
                    mcErrori.AppendBlank();
                    /* mcErrori.ERCODICE := xperazbo->NUMPROG */
                    mcErrori.row.ERCODICE = Cursor_xperazbo.GetString("NUMPROG");
                    /* mcErrori.ERDESCRI := _error_string */
                    mcErrori.row.ERDESCRI = _error_string;
                    /* mcErrori.SaveRow() */
                    mcErrori.SaveRow();
                  } // End If
                  Cursor_xperazbo.Next();
                }
                m_cConnectivityError = Cursor_xperazbo.ErrorMessage();
                Cursor_xperazbo.Close();
                // * --- End Select
                Cursor_qbe_trasfope_idbase_ope.Next();
              }
              m_cConnectivityError = Cursor_qbe_trasfope_idbase_ope.ErrorMessage();
              Cursor_qbe_trasfope_idbase_ope.Close();
              // * --- End Select
            } else { // Else
              /* gMsgImp := 'Lettura operazioni in corso ...' // Messaggio Import */
              gMsgImp = "Lettura operazioni in corso ...";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End If
            /* _contacicli := _contacicli+1 */
            _contacicli = CPLib.Round(_contacicli+1,0);
          } // End While
          Cursor_qbe_trasfope_datope.Next();
        }
        m_cConnectivityError = Cursor_qbe_trasfope_datope.ErrorMessage();
        Cursor_qbe_trasfope_datope.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + 'Trasferite '+LRTrim(Str(_conta,10,0))+" operazioni" + NL */
        gMsgProc = gMsgProc+"Trasferite "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" operazioni"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If _conta_err>0 */
        if (CPLib.gt(_conta_err,0)) {
          /* gMsgProc := gMsgProc + 'Bloccate '+LRTrim(Str(_conta_err,10,0))+" operazioni per anomalie riscontrate. Consultare la stampa dei errori" + NL */
          gMsgProc = gMsgProc+"Bloccate "+CPLib.LRTrim(CPLib.Str(_conta_err,10,0))+" operazioni per anomalie riscontrate. Consultare la stampa dei errori"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
      } else { // Else
        /* mcErrori.AppendBlank() */
        mcErrori.AppendBlank();
        /* mcErrori.ERCODICE := "" */
        mcErrori.row.ERCODICE = "";
        /* mcErrori.ERDESCRI := "Il trasferimento è stato bloccato in quanto sono state trovate operazioni con gli stessi riferimenti" */
        mcErrori.row.ERDESCRI = "Il trasferimento è stato bloccato in quanto sono state trovate operazioni con gli stessi riferimenti";
        /* mcErrori.SaveRow() */
        mcErrori.SaveRow();
        for (MemoryCursorRow_qbe_trasfope_controllo_totale_vqr rwqbe_trasfope_controllo_totale : mcqbe_trasfope_controllo_totale._iterable_()) {
          /* mcErrori.AppendBlank() */
          mcErrori.AppendBlank();
          /* mcErrori.ERCODICE := "" */
          mcErrori.row.ERCODICE = "";
          /* mcErrori.ERDESCRI := "Riferimento1: "+LRTrim(rwqbe_trasfope_controllo_totale.RIFIMP)+" Riferimento2: "+LRTrim(rwqbe_trasfope_controllo_totale.INFORM)+" Riscontrati sull'operazione definitiva con numero progressivo: "+LRTrim(rwqbe_trasfope_controllo_totale.NUMPROG) */
          mcErrori.row.ERDESCRI = "Riferimento1: "+CPLib.LRTrim(rwqbe_trasfope_controllo_totale.RIFIMP)+" Riferimento2: "+CPLib.LRTrim(rwqbe_trasfope_controllo_totale.INFORM)+" Riscontrati sull'operazione definitiva con numero progressivo: "+CPLib.LRTrim(rwqbe_trasfope_controllo_totale.NUMPROG);
          /* mcErrori.SaveRow() */
          mcErrori.SaveRow();
        }
        /* gMsgProc := gMsgProc + 'Il trasferimento è stato bloccato in quanto sono state trovate operazioni con gli stessi riferimenti' + NL */
        gMsgProc = gMsgProc+"Il trasferimento è stato bloccato in quanto sono state trovate operazioni con gli stessi riferimenti"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := "Elaborazione Abortita." // Messaggio Import */
        gMsgImp = "Elaborazione Abortita.";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
    } finally {
      try {
        if (Cursor_qbe_trasf_ope_nx!=null)
          Cursor_qbe_trasf_ope_nx.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasf_ope_sx!=null)
          Cursor_qbe_trasf_ope_sx.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasfope_controllo_totale!=null)
          Cursor_qbe_trasfope_controllo_totale.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasfope_datope!=null)
          Cursor_qbe_trasfope_datope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasfope_count_ope!=null)
          Cursor_qbe_trasfope_count_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasfope_idbase_ope!=null)
          Cursor_qbe_trasfope_idbase_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xperazbo!=null)
          Cursor_xperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xperazbo_agg!=null)
          Cursor_xperazbo_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xogopebo!=null)
          Cursor_xogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xlientiope!=null)
          Cursor_xlientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xeneficope!=null)
          Cursor_xeneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xerzistiope!=null)
          Cursor_xerzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xocopebo!=null)
          Cursor_xocopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xapcoll!=null)
          Cursor_xapcoll.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void fraz() throws Exception {
    CPResultSet Cursor_qbe_trasffra_controllo_totale=null;
    CPResultSet Cursor_qbe_trasffra_datope=null;
    CPResultSet Cursor_qbe_trasffra_count_fra=null;
    CPResultSet Cursor_qbe_trasffra_idbase_fra=null;
    CPResultSet Cursor_xraziobo=null;
    CPResultSet Cursor_xraziobo_agg=null;
    CPResultSet Cursor_xogopefbo=null;
    CPResultSet Cursor_xlientifrz=null;
    CPResultSet Cursor_xeneficfrz=null;
    CPResultSet Cursor_xerzistifrz=null;
    CPResultSet Cursor_xocfrabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* mcqbe_trasffra_controllo_totale MemoryCursor(qbe_trasffra_controllo_totale.vqr) // Frazionate definitive con lo stesso rifimp o inform */
      MemoryCursor_qbe_trasffra_controllo_totale_vqr mcqbe_trasffra_controllo_totale;
      mcqbe_trasffra_controllo_totale = new MemoryCursor_qbe_trasffra_controllo_totale_vqr();
      /* Scorre la query e trasferisce i dati */
      /* w_DaDatOpe := pDatIni */
      w_DaDatOpe = pDatIni;
      /* w_ADatOpe := pDatFin */
      w_ADatOpe = pDatFin;
      /* w_flgforce := pForza */
      w_flgforce = pForza;
      /* gMsgImp := "Selezione record da elaborare..." // Messaggio Import */
      gMsgImp = "Selezione record da elaborare...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* w_cdaope := iif(Empty(w_DaDatOpe) or DateToChar(w_DaDatOpe)='01000101','',DateToChar(w_DaDatOpe)) */
      w_cdaope = (CPLib.Empty(w_DaDatOpe) || CPLib.eqr(CPLib.DateToChar(w_DaDatOpe),"01000101")?"":CPLib.DateToChar(w_DaDatOpe));
      /* w_c_aope := iif(Empty(w_ADatOpe) or DateToChar(w_ADatOpe)='01000101','',DateToChar(w_ADatOpe)) */
      w_c_aope = (CPLib.Empty(w_ADatOpe) || CPLib.eqr(CPLib.DateToChar(w_ADatOpe),"01000101")?"":CPLib.DateToChar(w_ADatOpe));
      /* w_cdareg := '' */
      w_cdareg = "";
      /* w_c_areg := '' */
      w_c_areg = "";
      /* _totale := 0 */
      _totale = CPLib.Round(0,0);
      /* If w_flgforce <> 'S' */
      if (CPLib.ne(w_flgforce,"S")) {
        // * --- Fill memory cursor mcqbe_trasffra_controllo_totale on qbe_trasffra_controllo_totale
        mcqbe_trasffra_controllo_totale.Zap();
        SPBridge.HMCaller _h00000109;
        _h00000109 = new SPBridge.HMCaller();
        _h00000109.Set("m_cVQRList",m_cVQRList);
        _h00000109.Set("cdaope",w_cdaope);
        _h00000109.Set("c_aope",w_c_aope);
        _h00000109.Set("pInform",pInform);
        if (Cursor_qbe_trasffra_controllo_totale!=null)
          Cursor_qbe_trasffra_controllo_totale.Close();
        Cursor_qbe_trasffra_controllo_totale = new VQRHolder("qbe_trasffra_controllo_totale",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000109,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_trasffra_controllo_totale;
          Cursor_qbe_trasffra_controllo_totale.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_trasf_prov_aui: query on qbe_trasffra_controllo_totale returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_trasffra_controllo_totale.Eof())) {
          mcqbe_trasffra_controllo_totale.AppendBlank();
          mcqbe_trasffra_controllo_totale.row.NUMPROG = Cursor_qbe_trasffra_controllo_totale.GetString("NUMPROG");
          mcqbe_trasffra_controllo_totale.row.RIFIMP = Cursor_qbe_trasffra_controllo_totale.GetString("RIFIMP");
          mcqbe_trasffra_controllo_totale.row.INFORM = Cursor_qbe_trasffra_controllo_totale.GetString("INFORM");
          Cursor_qbe_trasffra_controllo_totale.Next();
        }
        m_cConnectivityError = Cursor_qbe_trasffra_controllo_totale.ErrorMessage();
        Cursor_qbe_trasffra_controllo_totale.Close();
        mcqbe_trasffra_controllo_totale.GoTop();
      } // End If
      /* If mcqbe_trasffra_controllo_totale.IsEmpty() */
      if (mcqbe_trasffra_controllo_totale.IsEmpty()) {
        // * --- Select from qbe_trasffra_datope
        SPBridge.HMCaller _h0000010B;
        _h0000010B = new SPBridge.HMCaller();
        _h0000010B.Set("m_cVQRList",m_cVQRList);
        _h0000010B.Set("cdaope",w_cdaope);
        _h0000010B.Set("c_aope",w_c_aope);
        _h0000010B.Set("pInform",pInform);
        if (Cursor_qbe_trasffra_datope!=null)
          Cursor_qbe_trasffra_datope.Close();
        Cursor_qbe_trasffra_datope = new VQRHolder("qbe_trasffra_datope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000010B,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_trasffra_datope.Eof())) {
          /* w_datreg := DateToChar(qbe_trasffra_datope->DATAOPE) */
          w_datreg = CPLib.DateToChar(Cursor_qbe_trasffra_datope.GetDate("DATAOPE"));
          // * --- Select from qbe_trasffra_count_fra
          SPBridge.HMCaller _h0000010D;
          _h0000010D = new SPBridge.HMCaller();
          _h0000010D.Set("m_cVQRList",m_cVQRList);
          _h0000010D.Set("datreg",w_datreg);
          if (Cursor_qbe_trasffra_count_fra!=null)
            Cursor_qbe_trasffra_count_fra.Close();
          Cursor_qbe_trasffra_count_fra = new VQRHolder("qbe_trasffra_count_fra",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000010D,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_trasffra_count_fra.Eof())) {
            /* _min := qbe_trasffra_count_fra->MINOPE */
            _min = CPLib.Round(Cursor_qbe_trasffra_count_fra.GetDouble("MINOPE"),0);
            /* _max := qbe_trasffra_count_fra->MAXOPE */
            _max = CPLib.Round(Cursor_qbe_trasffra_count_fra.GetDouble("MAXOPE"),0);
            /* _tot := qbe_trasffra_count_fra->TOTOPE */
            _tot = CPLib.Round(Cursor_qbe_trasffra_count_fra.GetDouble("TOTOPE"),0);
            Cursor_qbe_trasffra_count_fra.Next();
          }
          m_cConnectivityError = Cursor_qbe_trasffra_count_fra.ErrorMessage();
          Cursor_qbe_trasffra_count_fra.Close();
          // * --- End Select
          /* If _tot < 5000 */
          if (CPLib.lt(_tot,5000)) {
            /* _cicli := iif(_tot=0,0,1) */
            _cicli = CPLib.Round((CPLib.eqr(_tot,0)?0:1),0);
          } else { // Else
            /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
            _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
          } // End If
          /* _contacicli := 1 */
          _contacicli = CPLib.Round(1,0);
          /* While _contacicli<=_cicli */
          while (CPLib.le(_contacicli,_cicli)) {
            /* If _cicli = 1 */
            if (CPLib.eqr(_cicli,1)) {
              /* _bottom := _min */
              _bottom = CPLib.Round(_min,0);
              /* _top := _max */
              _top = CPLib.Round(_max,0);
            } else { // Else
              /* _bottom := ((_contacicli -1 ) * 5000) + 1 */
              _bottom = CPLib.Round(((_contacicli-1)*5000)+1,0);
              /* _top := _contacicli * 5000 */
              _top = CPLib.Round(_contacicli*5000,0);
            } // End If
            /* gMsgImp := 'Lettura frazionate in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
            gMsgImp = "Lettura frazionate in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If _top>=_min */
            if (CPLib.ge(_top,_min)) {
              // * --- Select from qbe_trasffra_idbase_fra
              if (Cursor_qbe_trasffra_idbase_fra!=null)
                Cursor_qbe_trasffra_idbase_fra.Close();
              Cursor_qbe_trasffra_idbase_fra = new VQRHolder("qbe_trasffra_idbase_fra",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_trasffra_idbase_fra.Eof())) {
                /* w_idbase := qbe_trasffra_idbase_fra->IDBASE */
                w_idbase = Cursor_qbe_trasffra_idbase_fra.GetString("IDBASE");
                // * --- Select from xraziobo
                m_cServer = m_Ctx.GetServer("xraziobo");
                m_cPhName = m_Ctx.GetPhName("xraziobo");
                if (Cursor_xraziobo!=null)
                  Cursor_xraziobo.Close();
                Cursor_xraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,w_idbase)+" "+")"+(m_Ctx.IsSharedTemp("xraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xraziobo.Eof())) {
                  /* _passato_il_check := True  */
                  _passato_il_check = true;
                  /* If fai_controlli */
                  if (fai_controlli) {
                    /* _error_string := '' */
                    _error_string = "";
                    /* If (DateDiff(xraziobo->DATAOPE, _date_oggi))>(20*365) */
                    if (CPLib.gt((CPLib.DateDiff(Cursor_xraziobo.GetDate("DATAOPE"),_date_oggi)),(20*365))) {
                      /* _error_string := ' Data Operazione più vecchia di 20 Anni,' */
                      _error_string = " Data Operazione più vecchia di 20 Anni,";
                      /* _passato_il_check := False */
                      _passato_il_check = false;
                    } // End If
                    /* If xraziobo->DATAOPE>_date_oggi */
                    if (CPLib.gt(Cursor_xraziobo.GetDate("DATAOPE"),_date_oggi)) {
                      /* _error_string := _error_string+' Data Operazione maggiore della Data odierna,' */
                      _error_string = _error_string+" Data Operazione maggiore della Data odierna,";
                      /* _passato_il_check := False */
                      _passato_il_check = false;
                    } // End If
                    /* _tmp := ""+LRTrim(xraziobo->CODANA)+LRTrim(xraziobo->CODVOC)+LRTrim(xraziobo->SEGNO) // CODANA+CODVOC+SEGNO */
                    _tmp = ""+CPLib.LRTrim(Cursor_xraziobo.GetString("CODANA"))+CPLib.LRTrim(Cursor_xraziobo.GetString("CODVOC"))+CPLib.LRTrim(Cursor_xraziobo.GetString("SEGNO"));
                    /* If not(mcCauana.HasKey(_tmp)) */
                    if ( ! (mcCauana.HasKey(_tmp))) {
                      /* _error_string := _error_string+' Anomalia sui campi Causale Analitica e/o Causale Sintetica e/o Segno,' */
                      _error_string = _error_string+" Anomalia sui campi Causale Analitica e/o Causale Sintetica e/o Segno,";
                      /* _passato_il_check := False */
                      _passato_il_check = false;
                    } // End If
                    /* _tmp := "" */
                    _tmp = "";
                    /* _error_string := Substr(_error_string,2,Len(_error_string)-2)+"." */
                    _error_string = CPLib.Substr(_error_string,2,CPLib.Len(_error_string)-2)+".";
                  } // End If
                  /* If _passato_il_check */
                  if (_passato_il_check) {
                    /* Calcol i nuovi progressivi */
                    /* idb2 := LibreriaMit.UniqueId() */
                    idb2 = LibreriaMit.UniqueId();
                    /* cProg1 := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
                    cProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
                    /* cProg2 := Utilities.GetAutonumber("PFRAZIO2\'"+LRTrim(gAzienda)+"'",Space(11),11) */
                    cProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(11),11);
                    /* _datareg := Date() */
                    _datareg = CPLib.Date();
                    // * --- Insert into fraziobo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("fraziobo");
                    m_cPhName = m_Ctx.GetPhName("fraziobo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000136")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000136(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("ANNOOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datareg),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datareg,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDate("DATARETT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(idb2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("F"+CPLib.Right(cProg2,9)+idb2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("IMPIN"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("IMPOUT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("IMPSARA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("MITIGDOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("MITIG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("NOSARA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("PRGIMPFRZ"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("PROQUOTA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("RAREA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("RIMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("SV58550"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("SV58550MA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("TIPOORO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("MEZPAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("PRESTAZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetDouble("CAUSALE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo.GetString("VASP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo",true);
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
                    // * --- Select from xraziobo_agg
                    m_cServer = m_Ctx.GetServer("xraziobo_agg");
                    m_cPhName = m_Ctx.GetPhName("xraziobo_agg");
                    if (Cursor_xraziobo_agg!=null)
                      Cursor_xraziobo_agg.Close();
                    Cursor_xraziobo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,w_idbase)+" "+")"+(m_Ctx.IsSharedTemp("xraziobo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xraziobo_agg.Eof())) {
                      // * --- Insert into fraziobo_agg from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("fraziobo_agg");
                      m_cPhName = m_Ctx.GetPhName("fraziobo_agg");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo_agg",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000138")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000138(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetDouble("CACODICE"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("IDBIGLIETTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetDateTime("CADATAORA"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetDouble("CATIPGIO"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetDouble("CATIPCON"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetDouble("CAPV_COD"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("IDDOCALL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("VPCODICE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetDate("WUDATRET"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetDouble("FLAGFRAUD"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("SV58724"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("SV58726SCA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("SV58726SA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("SV58726PISP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("C_COGNOME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("C_NOME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xraziobo_agg.GetString("SOSPAGAM"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo_agg",true);
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
                      // * --- Delete from xraziobo_agg
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xraziobo_agg");
                      m_cPhName = m_Ctx.GetPhName("xraziobo_agg");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo_agg",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000139")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"?",0,0,m_cServer),m_cServer,w_idbase)+"";
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
                      Cursor_xraziobo_agg.Next();
                    }
                    m_cConnectivityError = Cursor_xraziobo_agg.ErrorMessage();
                    Cursor_xraziobo_agg.Close();
                    // * --- End Select
                    // * --- Select from xogopefbo
                    m_cServer = m_Ctx.GetServer("xogopefbo");
                    m_cPhName = m_Ctx.GetPhName("xogopefbo");
                    if (Cursor_xogopefbo!=null)
                      Cursor_xogopefbo.Close();
                    Cursor_xogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xogopefbo.Eof())) {
                      // * --- Insert into sogopefbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("sogopefbo");
                      m_cPhName = m_Ctx.GetPhName("sogopefbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"0000013B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000013B(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xogopefbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xogopefbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
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
                      }
                      // * --- Delete from xogopebo
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xogopebo");
                      m_cPhName = m_Ctx.GetPhName("xogopebo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xogopebo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"0000013C")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xogopefbo.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xogopefbo.GetString("IDFILEBO"))+"";
                      m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xogopefbo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_xogopefbo.GetDouble("CPROWNUM"))+"";
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
                      Cursor_xogopefbo.Next();
                    }
                    m_cConnectivityError = Cursor_xogopefbo.ErrorMessage();
                    Cursor_xogopefbo.Close();
                    // * --- End Select
                    // * --- Select from xlientifrz
                    m_cServer = m_Ctx.GetServer("xlientifrz");
                    m_cPhName = m_Ctx.GetPhName("xlientifrz");
                    if (Cursor_xlientifrz!=null)
                      Cursor_xlientifrz.Close();
                    Cursor_xlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xlientifrz.Eof())) {
                      // * --- Insert into clientifrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("clientifrz");
                      m_cPhName = m_Ctx.GetPhName("clientifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"0000013E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000013E(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
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
                      }
                      // * --- Delete from xlientifrz
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xlientifrz");
                      m_cPhName = m_Ctx.GetPhName("xlientifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"0000013F")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xlientifrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xlientifrz.GetString("IDFILEBO"))+"";
                      m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xlientifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xlientifrz.GetString("CODSOG"))+"";
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
                      Cursor_xlientifrz.Next();
                    }
                    m_cConnectivityError = Cursor_xlientifrz.ErrorMessage();
                    Cursor_xlientifrz.Close();
                    // * --- End Select
                    // * --- Select from xeneficfrz
                    m_cServer = m_Ctx.GetServer("xeneficfrz");
                    m_cPhName = m_Ctx.GetPhName("xeneficfrz");
                    if (Cursor_xeneficfrz!=null)
                      Cursor_xeneficfrz.Close();
                    Cursor_xeneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xeneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xeneficfrz.Eof())) {
                      // * --- Insert into beneficfrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("beneficfrz");
                      m_cPhName = m_Ctx.GetPhName("beneficfrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000141")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000141(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetDouble("CPROWNUM"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
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
                      }
                      // * --- Delete from xeneficfrz
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xeneficfrz");
                      m_cPhName = m_Ctx.GetPhName("xeneficfrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficfrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000142")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xeneficfrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xeneficfrz.GetString("IDFILEBO"))+"";
                      m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xeneficfrz.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_xeneficfrz.GetDouble("CPROWNUM"))+"";
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
                      Cursor_xeneficfrz.Next();
                    }
                    m_cConnectivityError = Cursor_xeneficfrz.ErrorMessage();
                    Cursor_xeneficfrz.Close();
                    // * --- End Select
                    // * --- Select from xerzistifrz
                    m_cServer = m_Ctx.GetServer("xerzistifrz");
                    m_cPhName = m_Ctx.GetPhName("xerzistifrz");
                    if (Cursor_xerzistifrz!=null)
                      Cursor_xerzistifrz.Close();
                    Cursor_xerzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xerzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xerzistifrz.Eof())) {
                      // * --- Insert into terzistifrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("terzistifrz");
                      m_cPhName = m_Ctx.GetPhName("terzistifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000144")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000144(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
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
                      }
                      // * --- Delete from xerzistifrz
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xerzistifrz");
                      m_cPhName = m_Ctx.GetPhName("xerzistifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xerzistifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000145")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xerzistifrz.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xerzistifrz.GetString("IDFILEBO"))+"";
                      m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xerzistifrz.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xerzistifrz.GetString("CODSOG"))+"";
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
                      Cursor_xerzistifrz.Next();
                    }
                    m_cConnectivityError = Cursor_xerzistifrz.ErrorMessage();
                    Cursor_xerzistifrz.Close();
                    // * --- End Select
                    // * --- Select from xocfrabo
                    m_cServer = m_Ctx.GetServer("xocfrabo");
                    m_cPhName = m_Ctx.GetPhName("xocfrabo");
                    if (Cursor_xocfrabo!=null)
                      Cursor_xocfrabo.Close();
                    Cursor_xocfrabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_xraziobo.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xocfrabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_xocfrabo.Eof())) {
                      // * --- Insert into docfrabo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("docfrabo");
                      m_cPhName = m_Ctx.GetPhName("docfrabo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"docfrabo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000147")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000147(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetDate("DATARILASC"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetDate("DATAVALI"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xocfrabo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"docfrabo",true);
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
                      // * --- Delete from xocfrabo
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xocfrabo");
                      m_cPhName = m_Ctx.GetPhName("xocfrabo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xocfrabo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000148")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xocfrabo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_xocfrabo.GetString("NUMPROG"))+"";
                      m_cSql = m_cSql+" and CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xocfrabo.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_xocfrabo.GetString("CONNESCLI"))+"";
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
                      Cursor_xocfrabo.Next();
                    }
                    m_cConnectivityError = Cursor_xocfrabo.ErrorMessage();
                    Cursor_xocfrabo.Close();
                    // * --- End Select
                    // * --- Delete from xraziobo
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("xraziobo");
                    m_cPhName = m_Ctx.GetPhName("xraziobo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000149")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"?",0,0,m_cServer),m_cServer,w_idbase)+"";
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
                    /* _conta := _conta + 1 */
                    _conta = CPLib.Round(_conta+1,0);
                    /* gMsgImp := "Sono state trasferite "+LRTrim(Str(_conta,10,0))+"  frazionate" // Messaggio Import */
                    gMsgImp = "Sono state trasferite "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+"  frazionate";
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  } else { // Else
                    /* Check non passato :( */
                    /* _conta_err := _conta_err+1 */
                    _conta_err = CPLib.Round(_conta_err+1,0);
                    /* mcErrori.AppendBlank() */
                    mcErrori.AppendBlank();
                    /* mcErrori.ERCODICE := xraziobo->NUMPROG */
                    mcErrori.row.ERCODICE = Cursor_xraziobo.GetString("NUMPROG");
                    /* mcErrori.ERDESCRI := _error_string */
                    mcErrori.row.ERDESCRI = _error_string;
                    /* mcErrori.SaveRow() */
                    mcErrori.SaveRow();
                  } // End If
                  Cursor_xraziobo.Next();
                }
                m_cConnectivityError = Cursor_xraziobo.ErrorMessage();
                Cursor_xraziobo.Close();
                // * --- End Select
                Cursor_qbe_trasffra_idbase_fra.Next();
              }
              m_cConnectivityError = Cursor_qbe_trasffra_idbase_fra.ErrorMessage();
              Cursor_qbe_trasffra_idbase_fra.Close();
              // * --- End Select
            } else { // Else
              /* gMsgImp := 'Lettura frazionate in corso ...' // Messaggio Import */
              gMsgImp = "Lettura frazionate in corso ...";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End If
            /* _contacicli := _contacicli+1 */
            _contacicli = CPLib.Round(_contacicli+1,0);
          } // End While
          Cursor_qbe_trasffra_datope.Next();
        }
        m_cConnectivityError = Cursor_qbe_trasffra_datope.ErrorMessage();
        Cursor_qbe_trasffra_datope.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + 'Trasferite '+LRTrim(Str(_conta,10,0))+" frazionate" + NL */
        gMsgProc = gMsgProc+"Trasferite "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" frazionate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If _conta_err>0 */
        if (CPLib.gt(_conta_err,0)) {
          /* gMsgProc := gMsgProc + 'Bloccate '+LRTrim(Str(_conta_err,10,0))+" frazionate per anomalie riscontrate. Consultare la stampa dei errori" + NL */
          gMsgProc = gMsgProc+"Bloccate "+CPLib.LRTrim(CPLib.Str(_conta_err,10,0))+" frazionate per anomalie riscontrate. Consultare la stampa dei errori"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* gMsgImp := "Elaborazione Terminata con successo." // Messaggio Import */
        gMsgImp = "Elaborazione Terminata con successo.";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } else { // Else
        /* mcErrori.AppendBlank() */
        mcErrori.AppendBlank();
        /* mcErrori.ERCODICE := "" */
        mcErrori.row.ERCODICE = "";
        /* mcErrori.ERDESCRI := "Il trasferimento è stato bloccato in quanto sono state trovate operazioni frazionate con gli stessi riferimenti" */
        mcErrori.row.ERDESCRI = "Il trasferimento è stato bloccato in quanto sono state trovate operazioni frazionate con gli stessi riferimenti";
        /* mcErrori.SaveRow() */
        mcErrori.SaveRow();
        for (MemoryCursorRow_qbe_trasffra_controllo_totale_vqr rwqbe_trasffra_controllo_totale : mcqbe_trasffra_controllo_totale._iterable_()) {
          /* mcErrori.AppendBlank() */
          mcErrori.AppendBlank();
          /* mcErrori.ERCODICE := "" */
          mcErrori.row.ERCODICE = "";
          /* mcErrori.ERDESCRI := "Riferimento1: "+LRTrim(rwqbe_trasffra_controllo_totale.RIFIMP)+" Riferimento2: "+LRTrim(rwqbe_trasffra_controllo_totale.INFORM)+" Riscontrati sull'operazione definitiva con numero progressivo: "+LRTrim(rwqbe_trasffra_controllo_totale.NUMPROG) */
          mcErrori.row.ERDESCRI = "Riferimento1: "+CPLib.LRTrim(rwqbe_trasffra_controllo_totale.RIFIMP)+" Riferimento2: "+CPLib.LRTrim(rwqbe_trasffra_controllo_totale.INFORM)+" Riscontrati sull'operazione definitiva con numero progressivo: "+CPLib.LRTrim(rwqbe_trasffra_controllo_totale.NUMPROG);
          /* mcErrori.SaveRow() */
          mcErrori.SaveRow();
        }
        /* gMsgProc := gMsgProc + 'Il trasferimento è stato bloccato in quanto sono state trovate operazioni frazionate con gli stessi riferimenti' + NL */
        gMsgProc = gMsgProc+"Il trasferimento è stato bloccato in quanto sono state trovate operazioni frazionate con gli stessi riferimenti"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := "Elaborazione Abortita." // Messaggio Import */
        gMsgImp = "Elaborazione Abortita.";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
    } finally {
      try {
        if (Cursor_qbe_trasffra_controllo_totale!=null)
          Cursor_qbe_trasffra_controllo_totale.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasffra_datope!=null)
          Cursor_qbe_trasffra_datope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasffra_count_fra!=null)
          Cursor_qbe_trasffra_count_fra.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasffra_idbase_fra!=null)
          Cursor_qbe_trasffra_idbase_fra.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xraziobo!=null)
          Cursor_xraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xraziobo_agg!=null)
          Cursor_xraziobo_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xogopefbo!=null)
          Cursor_xogopefbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xlientifrz!=null)
          Cursor_xlientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xeneficfrz!=null)
          Cursor_xeneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xerzistifrz!=null)
          Cursor_xerzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xocfrabo!=null)
          Cursor_xocfrabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void rapp() throws Exception {
    CPResultSet Cursor_xnarapbo=null;
    try {
      /* Scorre la query e trasferisce i dati */
      /* _crap := 0 */
      _crap = CPLib.Round(0,0);
      /* _cinf := 0 */
      _cinf = CPLib.Round(0,0);
      // * --- Select from xnarapbo
      m_cServer = m_Ctx.GetServer("xnarapbo");
      m_cPhName = m_Ctx.GetPhName("xnarapbo");
      if (Cursor_xnarapbo!=null)
        Cursor_xnarapbo.Close();
      Cursor_xnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("xnarapbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xnarapbo.Eof())) {
        /* _passato_il_check := True  */
        _passato_il_check = true;
        /* If fai_controlli */
        if (fai_controlli) {
          /* _error_string := '' */
          _error_string = "";
          /* If Empty(xnarapbo->RAPPORTO) */
          if (CPLib.Empty(Cursor_xnarapbo.GetString("RAPPORTO"))) {
            /* _error_string := ' non presente il Codice Rapporto,' */
            _error_string = " non presente il Codice Rapporto,";
            /* _passato_il_check := False */
            _passato_il_check = false;
          } // End If
          /* _tmp := xnarapbo->TIPORAP */
          _tmp = Cursor_xnarapbo.GetString("TIPORAP");
          /* If Empty(_tmp) or (_tmp<>"0" and _tmp<>"1" and _tmp<>"2" and _tmp<>"3") */
          if (CPLib.Empty(_tmp) || (CPLib.ne(_tmp,"0") && CPLib.ne(_tmp,"1") && CPLib.ne(_tmp,"2") && CPLib.ne(_tmp,"3"))) {
            /* _error_string := _error_string+ " anomalia Tipo Rapporto,"+NL */
            _error_string = _error_string+" anomalia Tipo Rapporto,"+"\n";
            /* _passato_il_check := False */
            _passato_il_check = false;
          } // End If
          /* _tmp := "" */
          _tmp = "";
          /* _error_string := Substr(_error_string,2,Len(_error_string)-2)+"." */
          _error_string = CPLib.Substr(_error_string,2,CPLib.Len(_error_string)-2)+".";
        } // End If
        /* If _passato_il_check */
        if (_passato_il_check) {
          /* If Empty(xnarapbo->CODDIPE) or xnarapbo->CODDIPE=gCodDip or Empty(gCodDip) */
          if (CPLib.Empty(Cursor_xnarapbo.GetString("CODDIPE")) || CPLib.eqr(Cursor_xnarapbo.GetString("CODDIPE"),gCodDip) || CPLib.Empty(gCodDip)) {
            /* _crap := _crap + 1 */
            _crap = CPLib.Round(_crap+1,0);
            /* gMsgImp := 'Trasferimento dati base del rapporto: '+xnarapbo->RAPPORTO // Messaggio Import */
            gMsgImp = "Trasferimento dati base del rapporto: "+Cursor_xnarapbo.GetString("RAPPORTO");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* nProgImp := Utilities.GetAutonumber("PRGIMPRAP\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAP\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            /* mcRapporti.AppendBlank() */
            mcRapporti.AppendBlank();
            /* mcRapporti.RAPPORTO := xnarapbo->RAPPORTO */
            mcRapporti.row.RAPPORTO = Cursor_xnarapbo.GetString("RAPPORTO");
            /* mcRapporti.SaveRow() */
            mcRapporti.SaveRow();
            /* _rapporto := xnarapbo->RAPPORTO */
            _rapporto = Cursor_xnarapbo.GetString("RAPPORTO");
            // * --- Merge into anarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
            m_cQuery = "select ";
            m_cQuery =  m_cQuery+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAPPORTO"),"?",0,0)+" as RAPPORTO";
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
              m_cQuery = m_cQuery+" from dual";
            }
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cWhere = "anarapbo.RAPPORTO = cptmp_1xab23.RAPPORTO";
            m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
              m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"0000017F")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" anarapbo USING ";
              m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
              m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
              m_cSql = m_cSql+"anarapbo.AREAGEO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("AREAGEO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CONTINUA = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CONTINUA"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.DATAMOD = "+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAMOD"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.DESCRAP = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("DESCRAP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.DOCFILE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("DOCFILE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.FLAGLIRE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("FLAGLIRE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.IDBASE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDBASE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.IDRAPPORTO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDRAPPORTO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.MODSVOL = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("MODSVOL"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.NATURA = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("NATURA"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.NOPROT = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("NOPROT"),"?",0,0)+" , ";
              m_cSql = m_cSql+"PRGIMPRAP = "+CPLib.ToSQL(nProgImp,"N",15,0)+", ";
              m_cSql = m_cSql+"anarapbo.RAGIO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAGIO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.RAREA = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RAREA"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.RCOMP = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RCOMP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.RFREQ = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RFREQ"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.RIMP = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RIMP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.RRAGIO = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RRAGIO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.RTIPO = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RTIPO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.SCOPO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("SCOPO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.TIPMOD = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPMOD"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.TIPO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPO"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.TIPOAG = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPOAG"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.TIPORAP = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPORAP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.VALUTA = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("VALUTA"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.IMPAPE = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPAPE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.IMPCHIU = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPCHIU"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.SPLITCODE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("SPLITCODE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.MACODICE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("MACODICE"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CODDIP = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CODICELR = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODICELR"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.MITIG = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("MITIG"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.MITGDOC = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("MITGDOC"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CATEG01 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG01"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CATEG02 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG02"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CATEG03 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG03"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CATEG04 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG04"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CATEG05 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG05"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CATEGORIA = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEGORIA"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CODDIPE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.DAC6 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("DAC6"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.FLAGDAC6 = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("FLAGDAC6"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.IBAN = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("IBAN"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.CODOGG = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODOGG"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.RISGLOB = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("RISGLOB"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.DATAPROF = "+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAPROF"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.DATAREVPROF = "+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAREVPROF"),"?",0,0)+" , ";
              m_cSql = m_cSql+"anarapbo.NOCANC = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("NOCANC"),"?",0,0)+" , ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",true,true);
              m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
              m_cSql = m_cSql+GetFieldsName_0000017F(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAMOD"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("NOPROT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xnarapbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xnarapbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPAPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPCHIU"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("SPLITCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("MACODICE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODICELR"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("MITIG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("IBAN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODOGG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAPROF"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAREVPROF"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("NOCANC"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"anarapbo",true);
              m_cSql = m_cSql+")";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = m_cSql+";";
              }
            } else {
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"0000017F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"AREAGEO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("AREAGEO"),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"CONTINUA = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CONTINUA"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAMOD = "+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAMOD"),"D",8,0)+", ";
              m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("DESCRAP"),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("DOCFILE"),"C",100,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGLIRE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("FLAGLIRE"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"IDRAPPORTO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDRAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"MODSVOL = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("MODSVOL"),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"NATURA = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("NATURA"),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"NOPROT = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("NOPROT"),"N",1,0)+", ";
              m_cSql = m_cSql+"PRGIMPRAP = "+CPLib.ToSQL(nProgImp,"N",15,0)+", ";
              m_cSql = m_cSql+"RAGIO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAGIO"),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAREA = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RAREA"),"N",3,0)+", ";
              m_cSql = m_cSql+"RCOMP = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RCOMP"),"N",3,0)+", ";
              m_cSql = m_cSql+"RFREQ = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RFREQ"),"N",3,0)+", ";
              m_cSql = m_cSql+"RIMP = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RIMP"),"N",3,0)+", ";
              m_cSql = m_cSql+"RRAGIO = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RRAGIO"),"N",3,0)+", ";
              m_cSql = m_cSql+"RTIPO = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RTIPO"),"N",3,0)+", ";
              m_cSql = m_cSql+"SCOPO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("SCOPO"),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPMOD = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPMOD"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPO = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPO"),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPOAG"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQLNull(Cursor_xnarapbo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQLNull(Cursor_xnarapbo.GetString("VALUTA"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"IMPAPE = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPAPE"),"N",1,0)+", ";
              m_cSql = m_cSql+"IMPCHIU = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPCHIU"),"N",1,0)+", ";
              m_cSql = m_cSql+"SPLITCODE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("SPLITCODE"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"MACODICE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("MACODICE"),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODDIP = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODICELR = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODICELR"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"MITIG = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("MITIG"),"N",4,0)+", ";
              m_cSql = m_cSql+"MITGDOC = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("MITGDOC"),"C",100,0,m_cServer)+", ";
              m_cSql = m_cSql+"CATEG01 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG01"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CATEG02 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG02"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CATEG03 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG03"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CATEG04 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG04"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CATEG05 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG05"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CATEGORIA = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEGORIA"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DAC6 = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("DAC6"),"C",100,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGDAC6 = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("FLAGDAC6"),"N",1,0)+", ";
              m_cSql = m_cSql+"IBAN = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("IBAN"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODOGG = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODOGG"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RISGLOB = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("RISGLOB"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAPROF = "+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAPROF"),"D",8,0)+", ";
              m_cSql = m_cSql+"DATAREVPROF = "+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAREVPROF"),"D",8,0)+", ";
              m_cSql = m_cSql+"NOCANC = "+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("NOCANC"),"N",1,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xnarapbo.GetString("RAPPORTO"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.eqr(m_nUpdatedRows,0)) {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"0000017F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000017F(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAMOD"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("NOPROT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RAREA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RCOMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RFREQ"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RIMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RRAGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("RTIPO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xnarapbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xnarapbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPAPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("IMPCHIU"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("SPLITCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("MACODICE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODICELR"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("MITIG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("IBAN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("CODOGG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAPROF"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDate("DATAREVPROF"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetDouble("NOCANC"),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"anarapbo",true);
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
            }
            // * --- Write into knarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000180")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL("D","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"knarapbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xnarapbo.GetString("RAPPORTO"))+"";
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
            /* If xnarapbo->NOPROT<>1 */
            if (CPLib.ne(Cursor_xnarapbo.GetDouble("NOPROT"),1)) {
              /* nProgImp := Utilities.GetAutonumber("PROGAET\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAET\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into aetesta from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000183")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000183(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_xnarapbo.GetString("TIPORAP"),"1")?"1":"2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_xnarapbo.GetString("TIPOAG"),"99")?CPLib.Upper(CPLib.Left(Cursor_xnarapbo.GetString("DESCRAP"),24)):""),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xnarapbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("A","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aetesta",true);
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
          /* Check non passato :( */
          /* _conta_err := _conta_err+1 */
          _conta_err = CPLib.Round(_conta_err+1,0);
          /* mcErrori.AppendBlank() */
          mcErrori.AppendBlank();
          /* mcErrori.ERCODICE := xnarapbo->RAPPORTO */
          mcErrori.row.ERCODICE = Cursor_xnarapbo.GetString("RAPPORTO");
          /* mcErrori.ERDESCRI := _error_string */
          mcErrori.row.ERDESCRI = _error_string;
          /* mcErrori.SaveRow() */
          mcErrori.SaveRow();
        } // End If
        Cursor_xnarapbo.Next();
      }
      m_cConnectivityError = Cursor_xnarapbo.ErrorMessage();
      Cursor_xnarapbo.Close();
      // * --- End Select
      for (MemoryCursorRow_xnarapbo rowRapporto : mcRapporti._iterable_()) {
        /* Elimino i soli rapporti trasferiti */
        // * --- Delete from xnarapbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xnarapbo");
        m_cPhName = m_Ctx.GetPhName("xnarapbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xnarapbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"0000018C")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowRapporto.RAPPORTO,"?",0,0,m_cServer),m_cServer,rowRapporto.RAPPORTO)+"";
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
      }
      /* gMsgProc := gMsgProc + "Sono stati trasferiti "+LRTrim(Str(_crap,10,0))+" rapporti" + NL // Messaggio */
      gMsgProc = gMsgProc+"Sono stati trasferiti "+CPLib.LRTrim(CPLib.Str(_crap,10,0))+" rapporti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If _conta_err>0 */
      if (CPLib.gt(_conta_err,0)) {
        /* gMsgProc := gMsgProc + 'Bloccati '+LRTrim(Str(_conta_err,10,0))+" rapporti per anomalie riscontrate. Consultare la stampa dei errori" + NL */
        gMsgProc = gMsgProc+"Bloccati "+CPLib.LRTrim(CPLib.Str(_conta_err,10,0))+" rapporti per anomalie riscontrate. Consultare la stampa dei errori"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_xnarapbo!=null)
          Cursor_xnarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void info() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_trasfinfo_datope=null;
    CPResultSet Cursor_qbe_trasfinfo_count_inf=null;
    CPResultSet Cursor_qbe_trasfinfo_idbase_inf=null;
    CPResultSet Cursor_xapopebo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_xelegabo=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_xoginfo=null;
    CPResultSet Cursor_xiduciabo=null;
    CPResultSet Cursor_xerzistirap=null;
    CPResultSet Cursor_rapopebo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Scorre la query e trasferisce i dati */
      /* gMsgImp := "Selezione record da elaborare..." // Messaggio Import */
      gMsgImp = "Selezione record da elaborare...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* w_cdaope := iif(Empty(w_DaDatOpe) or DateToChar(w_DaDatOpe)='01000101','',DateToChar(w_DaDatOpe)) */
      w_cdaope = (CPLib.Empty(w_DaDatOpe) || CPLib.eqr(CPLib.DateToChar(w_DaDatOpe),"01000101")?"":CPLib.DateToChar(w_DaDatOpe));
      /* w_c_aope := iif(Empty(w_ADatOpe) or DateToChar(w_ADatOpe)='01000101','',DateToChar(w_ADatOpe)) */
      w_c_aope = (CPLib.Empty(w_ADatOpe) || CPLib.eqr(CPLib.DateToChar(w_ADatOpe),"01000101")?"":CPLib.DateToChar(w_ADatOpe));
      /* w_cdareg := '' */
      w_cdareg = "";
      /* w_c_areg := '' */
      w_c_areg = "";
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _flgdatareg := intermbo->FLGDATATP */
        _flgdatareg = CPLib.Round(Cursor_intermbo.GetDouble("FLGDATATP"),0);
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      // * --- Select from qbe_trasfinfo_datope
      SPBridge.HMCaller _h00000199;
      _h00000199 = new SPBridge.HMCaller();
      _h00000199.Set("m_cVQRList",m_cVQRList);
      _h00000199.Set("cdaope",w_cdaope);
      _h00000199.Set("c_aope",w_c_aope);
      _h00000199.Set("cdareg",w_cdareg);
      _h00000199.Set("c_areg",w_c_areg);
      if (Cursor_qbe_trasfinfo_datope!=null)
        Cursor_qbe_trasfinfo_datope.Close();
      Cursor_qbe_trasfinfo_datope = new VQRHolder("qbe_trasfinfo_datope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000199,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_trasfinfo_datope.Eof())) {
        /* w_datreg := DateToChar(qbe_trasfinfo_datope->DATAOPE) */
        w_datreg = CPLib.DateToChar(Cursor_qbe_trasfinfo_datope.GetDate("DATAOPE"));
        // * --- Select from qbe_trasfinfo_count_inf
        SPBridge.HMCaller _h0000019B;
        _h0000019B = new SPBridge.HMCaller();
        _h0000019B.Set("m_cVQRList",m_cVQRList);
        _h0000019B.Set("datreg",w_datreg);
        if (Cursor_qbe_trasfinfo_count_inf!=null)
          Cursor_qbe_trasfinfo_count_inf.Close();
        Cursor_qbe_trasfinfo_count_inf = new VQRHolder("qbe_trasfinfo_count_inf",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000019B,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_trasfinfo_count_inf.Eof())) {
          /* _min := qbe_trasfinfo_count_inf->MININF */
          _min = CPLib.Round(Cursor_qbe_trasfinfo_count_inf.GetDouble("MININF"),0);
          /* _max := qbe_trasfinfo_count_inf->MAXINF */
          _max = CPLib.Round(Cursor_qbe_trasfinfo_count_inf.GetDouble("MAXINF"),0);
          /* _tot := qbe_trasfinfo_count_inf->TOTINF */
          _tot = CPLib.Round(Cursor_qbe_trasfinfo_count_inf.GetDouble("TOTINF"),0);
          Cursor_qbe_trasfinfo_count_inf.Next();
        }
        m_cConnectivityError = Cursor_qbe_trasfinfo_count_inf.ErrorMessage();
        Cursor_qbe_trasfinfo_count_inf.Close();
        // * --- End Select
        /* If _tot < 5000 */
        if (CPLib.lt(_tot,5000)) {
          /* _cicli := iif(_tot=0,0,1) */
          _cicli = CPLib.Round((CPLib.eqr(_tot,0)?0:1),0);
        } else { // Else
          /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
        } // End If
        /* _contacicli := 1 */
        _contacicli = CPLib.Round(1,0);
        /* While _contacicli<=_cicli */
        while (CPLib.le(_contacicli,_cicli)) {
          /* If _cicli = 1 */
          if (CPLib.eqr(_cicli,1)) {
            /* _bottom := _min */
            _bottom = CPLib.Round(_min,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* _bottom := ((_contacicli -1 ) * 5000) + 1 */
            _bottom = CPLib.Round(((_contacicli-1)*5000)+1,0);
            /* _top := _contacicli * 5000 */
            _top = CPLib.Round(_contacicli*5000,0);
          } // End If
          /* gMsgImp := 'Lettura informazioni in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
          gMsgImp = "Lettura informazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If _top>=_min */
          if (CPLib.ge(_top,_min)) {
            // * --- Select from qbe_trasfinfo_idbase_inf
            if (Cursor_qbe_trasfinfo_idbase_inf!=null)
              Cursor_qbe_trasfinfo_idbase_inf.Close();
            Cursor_qbe_trasfinfo_idbase_inf = new VQRHolder("qbe_trasfinfo_idbase_inf",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_trasfinfo_idbase_inf.Eof())) {
              /* w_idbase := qbe_trasfinfo_idbase_inf->IDBASE */
              w_idbase = Cursor_qbe_trasfinfo_idbase_inf.GetString("IDBASE");
              // * --- Select from xapopebo
              m_cServer = m_Ctx.GetServer("xapopebo");
              m_cPhName = m_Ctx.GetPhName("xapopebo");
              if (Cursor_xapopebo!=null)
                Cursor_xapopebo.Close();
              Cursor_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,w_idbase)+" "+")"+(m_Ctx.IsSharedTemp("xapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xapopebo.Eof())) {
                /* If Empty(xapopebo->CODDIPE) or xapopebo->CODDIPE=gCodDip or Empty(gCodDip) */
                if (CPLib.Empty(Cursor_xapopebo.GetString("CODDIPE")) || CPLib.eqr(Cursor_xapopebo.GetString("CODDIPE"),gCodDip) || CPLib.Empty(gCodDip)) {
                  /* _passato_il_check := True  */
                  _passato_il_check = true;
                  /* If fai_controlli */
                  if (fai_controlli) {
                    /* _error_string := '' */
                    _error_string = "";
                    /* If Empty(LRTrim(xapopebo->RAPPORTO)) */
                    if (CPLib.Empty(CPLib.LRTrim(Cursor_xapopebo.GetString("RAPPORTO")))) {
                      /* _error_string := ' Rapporto non presente,' */
                      _error_string = " Rapporto non presente,";
                      /* _passato_il_check := False */
                      _passato_il_check = false;
                    } // End If
                    /* If (DateDiff(xapopebo->DATAOPE, _date_oggi))>(20*365) */
                    if (CPLib.gt((CPLib.DateDiff(Cursor_xapopebo.GetDate("DATAOPE"),_date_oggi)),(20*365))) {
                      /* _error_string := _error_string+' Data Operazione Informazione più vecchia di 20 Anni,' */
                      _error_string = _error_string+" Data Operazione Informazione più vecchia di 20 Anni,";
                      /* _passato_il_check := False */
                      _passato_il_check = false;
                    } // End If
                    /* If xapopebo->DATAOPE>_date_oggi */
                    if (CPLib.gt(Cursor_xapopebo.GetDate("DATAOPE"),_date_oggi)) {
                      /* _error_string := _error_string+' Data Operazione Informazione maggiore della Data odierna,' */
                      _error_string = _error_string+" Data Operazione Informazione maggiore della Data odierna,";
                      /* _passato_il_check := False */
                      _passato_il_check = false;
                    } // End If
                    /* If Empty(LRTrim(xapopebo->FLAGRAP)) */
                    if (CPLib.Empty(CPLib.LRTrim(Cursor_xapopebo.GetString("FLAGRAP")))) {
                      /* _error_string := _error_string+ " anomalia Tipo Rapporto,"+NL */
                      _error_string = _error_string+" anomalia Tipo Rapporto,"+"\n";
                      /* _passato_il_check := False */
                      _passato_il_check = false;
                    } // End If
                    /* If Empty(xapopebo->TIPOOPRAP) */
                    if (CPLib.Empty(Cursor_xapopebo.GetString("TIPOOPRAP"))) {
                      /* _error_string := _error_string+ " anomalia Tipo Registrazione,"+NL */
                      _error_string = _error_string+" anomalia Tipo Registrazione,"+"\n";
                      /* _passato_il_check := False */
                      _passato_il_check = false;
                    } // End If
                    /* If At(xapopebo->TIPOOPRAP,'|26|36|38|43|44|46') <> 0 */
                    if (CPLib.ne(CPLib.At(Cursor_xapopebo.GetString("TIPOOPRAP"),"|26|36|38|43|44|46"),0)) {
                      // * --- Select from xntestbo
                      m_cServer = m_Ctx.GetServer("xntestbo");
                      m_cPhName = m_Ctx.GetPhName("xntestbo");
                      if (Cursor_xntestbo!=null)
                        Cursor_xntestbo.Close();
                      Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_xntestbo.Eof())) {
                        /* _numprog := '' */
                        _numprog = "";
                        // * --- Read from intestbo
                        m_cServer = m_Ctx.GetServer("intestbo");
                        m_cPhName = m_Ctx.GetPhName("intestbo");
                        m_cSql = "";
                        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("RAPPORTO"));
                        m_cSql = m_cSql+" and CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"));
                        if (m_Ctx.IsSharedTemp("intestbo")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMPROG1",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _numprog = Read_Cursor.GetString("NUMPROG1");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on intestbo into routine arrt_trasf_prov_aui returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _numprog = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                        /* If Empty(_numprog) */
                        if (CPLib.Empty(_numprog)) {
                          /* _error_string := _error_string+ " Manca Apertura per chiusura rapporto,"+NL */
                          _error_string = _error_string+" Manca Apertura per chiusura rapporto,"+"\n";
                          /* _passato_il_check := False */
                          _passato_il_check = false;
                          // Exit Loop
                          if (true) {
                            break;
                          }
                        } // End If
                        Cursor_xntestbo.Next();
                      }
                      m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
                      Cursor_xntestbo.Close();
                      // * --- End Select
                    } // End If
                    /* If xapopebo->TIPOOPRAP='28' */
                    if (CPLib.eqr(Cursor_xapopebo.GetString("TIPOOPRAP"),"28")) {
                      // * --- Select from xelegabo
                      m_cServer = m_Ctx.GetServer("xelegabo");
                      m_cPhName = m_Ctx.GetPhName("xelegabo");
                      if (Cursor_xelegabo!=null)
                        Cursor_xelegabo.Close();
                      Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_xelegabo.Eof())) {
                        /* _numprog := '' */
                        _numprog = "";
                        // * --- Read from delegabo
                        m_cServer = m_Ctx.GetServer("delegabo");
                        m_cPhName = m_Ctx.GetPhName("delegabo");
                        m_cSql = "";
                        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("RAPPORTO"));
                        m_cSql = m_cSql+" and CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_xelegabo.GetString("CODINTER"));
                        if (m_Ctx.IsSharedTemp("delegabo")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMPROG1",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _numprog = Read_Cursor.GetString("NUMPROG1");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on delegabo into routine arrt_trasf_prov_aui returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _numprog = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                        /* If Empty(_numprog) */
                        if (CPLib.Empty(_numprog)) {
                          /* _error_string := _error_string+ " Manca Apertura per chiusura delega,"+NL */
                          _error_string = _error_string+" Manca Apertura per chiusura delega,"+"\n";
                          /* _passato_il_check := False */
                          _passato_il_check = false;
                          // Exit Loop
                          if (true) {
                            break;
                          }
                        } // End If
                        Cursor_xelegabo.Next();
                      }
                      m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
                      Cursor_xelegabo.Close();
                      // * --- End Select
                    } // End If
                    /* _error_string := Substr(_error_string,2,Len(_error_string)-2)+"." */
                    _error_string = CPLib.Substr(_error_string,2,CPLib.Len(_error_string)-2)+".";
                  } // End If
                  /* If _passato_il_check */
                  if (_passato_il_check) {
                    /* _rapporto := '' */
                    _rapporto = "";
                    // * --- Read from anarapbo
                    m_cServer = m_Ctx.GetServer("anarapbo");
                    m_cPhName = m_Ctx.GetPhName("anarapbo");
                    m_cSql = "";
                    m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("RAPPORTO"));
                    if (m_Ctx.IsSharedTemp("anarapbo")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _rapporto = Read_Cursor.GetString("RAPPORTO");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_trasf_prov_aui returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _rapporto = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* If not(Empty(LRTrim(_rapporto))) */
                    if ( ! (CPLib.Empty(CPLib.LRTrim(_rapporto)))) {
                      /* cProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
                      cProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                      /* cProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
                      cProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
                      /* Case At(xapopebo->TIPOOPRAP,'|25|28|39|40|41|47') <> 0 */
                      if (CPLib.ne(CPLib.At(Cursor_xapopebo.GetString("TIPOOPRAP"),"|25|28|39|40|41|47"),0)) {
                        /* If At(xapopebo->TIPOOPRAP,'|25|39|40') <> 0 */
                        if (CPLib.ne(CPLib.At(Cursor_xapopebo.GetString("TIPOOPRAP"),"|25|39|40"),0)) {
                          /* _maxdel := 0 */
                          _maxdel = CPLib.Round(0,0);
                          // * --- Select from delegabo
                          m_cServer = m_Ctx.GetServer("delegabo");
                          m_cPhName = m_Ctx.GetPhName("delegabo");
                          if (Cursor_delegabo!=null)
                            Cursor_delegabo.Close();
                          Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CPROWNUM  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
                          while ( ! (Cursor_delegabo.Eof())) {
                            /* _maxdel := delegabo->CPROWNUM */
                            _maxdel = CPLib.Round(Cursor_delegabo.GetDouble("CPROWNUM"),0);
                            Cursor_delegabo.Next();
                          }
                          m_cConnectivityError = Cursor_delegabo.ErrorMessage();
                          Cursor_delegabo.Close();
                          // * --- End Select
                          // * --- Select from xelegabo
                          m_cServer = m_Ctx.GetServer("xelegabo");
                          m_cPhName = m_Ctx.GetPhName("xelegabo");
                          if (Cursor_xelegabo!=null)
                            Cursor_xelegabo.Close();
                          Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                          while ( ! (Cursor_xelegabo.Eof())) {
                            /* _maxdel := _maxdel + 1 */
                            _maxdel = CPLib.Round(_maxdel+1,0);
                            // * --- Insert into delegabo from values
                            m_Sql.RequireTransaction();
                            m_cServer = m_Ctx.GetServer("delegabo");
                            m_cPhName = m_Ctx.GetPhName("delegabo");
                            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001E0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                            m_cSql = m_cSql+GetFieldsName_000001E0(m_Ctx,m_oWrInfo);
                            m_cSql = m_cSql+") values (";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_maxdel+1,"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetDate("DATAINI"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetDate("DATARETT"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetDate("DATAFINE"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("NOAGE"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+m_oWrInfo.InsertValues();
                            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"delegabo",true);
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
                            Cursor_xelegabo.Next();
                          }
                          m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
                          Cursor_xelegabo.Close();
                          // * --- End Select
                          // * --- Delete from xelegabo
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("xelegabo");
                          m_cPhName = m_Ctx.GetPhName("xelegabo");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xelegabo",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001E1")+"delete from "+m_oWrInfo.GetTableWriteName();
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("RAPPORTO"))+"";
                          m_cSql = m_cSql+" and NUMPROG1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("NUMPROG"))+"";
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
                          // * --- Select from xelegabo
                          m_cServer = m_Ctx.GetServer("xelegabo");
                          m_cPhName = m_Ctx.GetPhName("xelegabo");
                          if (Cursor_xelegabo!=null)
                            Cursor_xelegabo.Close();
                          Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                          while ( ! (Cursor_xelegabo.Eof())) {
                            // * --- Write into delegabo from values
                            m_Sql.RequireTransaction();
                            m_cServer = m_Ctx.GetServer("delegabo");
                            m_cPhName = m_Ctx.GetPhName("delegabo");
                            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001E3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                            m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_xapopebo.GetDate("DATAOPE"),"D",8,0)+", ";
                            m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cProg2,"C",11,0,m_cServer)+", ";
                            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"delegabo",false,true);
                            m_cSql = m_cSql+" where ";
                            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("RAPPORTO"))+"";
                            m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xelegabo.GetString("CODINTER"))+"";
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
                            Cursor_xelegabo.Next();
                          }
                          m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
                          Cursor_xelegabo.Close();
                          // * --- End Select
                          // * --- Delete from xelegabo
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("xelegabo");
                          m_cPhName = m_Ctx.GetPhName("xelegabo");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xelegabo",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001E4")+"delete from "+m_oWrInfo.GetTableWriteName();
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("RAPPORTO"))+"";
                          m_cSql = m_cSql+" and NUMPROG2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("NUMPROG"))+"";
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
                        /* Case At(xapopebo->TIPOOPRAP,'|26|36|38|43|44|46') <> 0 */
                      } else if (CPLib.ne(CPLib.At(Cursor_xapopebo.GetString("TIPOOPRAP"),"|26|36|38|43|44|46"),0)) {
                        // * --- Write into intestbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("intestbo");
                        m_cPhName = m_Ctx.GetPhName("intestbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001E5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_xapopebo.GetDate("DATAOPE"),"D",8,0)+", ";
                        m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cProg2,"C",11,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("RAPPORTO"))+"";
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
                        // * --- Delete from xntestbo
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("xntestbo");
                        m_cPhName = m_Ctx.GetPhName("xntestbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001E6")+"delete from "+m_oWrInfo.GetTableWriteName();
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("RAPPORTO"))+"";
                        m_cSql = m_cSql+" and NUMPROG2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("NUMPROG"))+"";
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
                      } else { // Otherwise
                        // * --- Select from xntestbo
                        m_cServer = m_Ctx.GetServer("xntestbo");
                        m_cPhName = m_Ctx.GetPhName("xntestbo");
                        if (Cursor_xntestbo!=null)
                          Cursor_xntestbo.Close();
                        Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                        while ( ! (Cursor_xntestbo.Eof())) {
                          /* cProg3 := LibreriaMit.UniqueId() */
                          cProg3 = LibreriaMit.UniqueId();
                          /* nProgImp := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
                          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                          // * --- Insert into intestbo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("intestbo");
                          m_cPhName = m_Ctx.GetPhName("intestbo");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001EA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                          m_cSql = m_cSql+GetFieldsName_000001EA(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cProg3,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetDate("DATAINI"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetDate("DATAFINE"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetDate("DATARETT"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetDouble("ABBINATO"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"intestbo",true);
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
                          Cursor_xntestbo.Next();
                        }
                        m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
                        Cursor_xntestbo.Close();
                        // * --- End Select
                        // * --- Delete from xntestbo
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("xntestbo");
                        m_cPhName = m_Ctx.GetPhName("xntestbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001EB")+"delete from "+m_oWrInfo.GetTableWriteName();
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("RAPPORTO"))+"";
                        m_cSql = m_cSql+" and NUMPROG1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapopebo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_xapopebo.GetString("NUMPROG"))+"";
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
                        // * --- Select from xoginfo
                        m_cServer = m_Ctx.GetServer("xoginfo");
                        m_cPhName = m_Ctx.GetPhName("xoginfo");
                        if (Cursor_xoginfo!=null)
                          Cursor_xoginfo.Close();
                        Cursor_xoginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_xapopebo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xoginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                        while ( ! (Cursor_xoginfo.Eof())) {
                          // * --- Insert into soginfo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("soginfo");
                          m_cPhName = m_Ctx.GetPhName("soginfo");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"soginfo",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001ED")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                          m_cSql = m_cSql+GetFieldsName_000001ED(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xoginfo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xoginfo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xoginfo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xoginfo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xoginfo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xoginfo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xoginfo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xoginfo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"soginfo",true);
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
                          // * --- Delete from xoginfo
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("xoginfo");
                          m_cPhName = m_Ctx.GetPhName("xoginfo");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xoginfo",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001EE")+"delete from "+m_oWrInfo.GetTableWriteName();
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xoginfo.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xoginfo.GetString("IDFILEBO"))+"";
                          m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xoginfo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_xoginfo.GetDouble("CPROWNUM"))+"";
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
                          Cursor_xoginfo.Next();
                        }
                        m_cConnectivityError = Cursor_xoginfo.ErrorMessage();
                        Cursor_xoginfo.Close();
                        // * --- End Select
                        // * --- Select from xiduciabo
                        m_cServer = m_Ctx.GetServer("xiduciabo");
                        m_cPhName = m_Ctx.GetPhName("xiduciabo");
                        if (Cursor_xiduciabo!=null)
                          Cursor_xiduciabo.Close();
                        Cursor_xiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                        while ( ! (Cursor_xiduciabo.Eof())) {
                          // * --- Insert into fiduciabo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("fiduciabo");
                          m_cPhName = m_Ctx.GetPhName("fiduciabo");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fiduciabo",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001F0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                          m_cSql = m_cSql+GetFieldsName_000001F0(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fiduciabo",true);
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
                          // * --- Delete from xiduciabo
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("xiduciabo");
                          m_cPhName = m_Ctx.GetPhName("xiduciabo");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xiduciabo",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001F1")+"delete from "+m_oWrInfo.GetTableWriteName();
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xiduciabo.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xiduciabo.GetString("IDFILEBO"))+"";
                          m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xiduciabo.GetString("CODSOG"))+"";
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
                          Cursor_xiduciabo.Next();
                        }
                        m_cConnectivityError = Cursor_xiduciabo.ErrorMessage();
                        Cursor_xiduciabo.Close();
                        // * --- End Select
                        // * --- Select from xerzistirap
                        m_cServer = m_Ctx.GetServer("xerzistirap");
                        m_cPhName = m_Ctx.GetPhName("xerzistirap");
                        if (Cursor_xerzistirap!=null)
                          Cursor_xerzistirap.Close();
                        Cursor_xerzistirap = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xerzistirap")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                        while ( ! (Cursor_xerzistirap.Eof())) {
                          // * --- Insert into terzistirap from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("terzistirap");
                          m_cPhName = m_Ctx.GetPhName("terzistirap");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistirap",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001F3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                          m_cSql = m_cSql+GetFieldsName_000001F3(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistirap.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistirap.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistirap.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistirap.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistirap.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistirap.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistirap.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"terzistirap",true);
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
                          // * --- Delete from xerzistirap
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("xerzistirap");
                          m_cPhName = m_Ctx.GetPhName("xerzistirap");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xerzistirap",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001F4")+"delete from "+m_oWrInfo.GetTableWriteName();
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xerzistirap.GetString("IDFILEBO"),"?",0,0,m_cServer),m_cServer,Cursor_xerzistirap.GetString("IDFILEBO"))+"";
                          m_cSql = m_cSql+" and CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xerzistirap.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xerzistirap.GetString("CODSOG"))+"";
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
                          Cursor_xerzistirap.Next();
                        }
                        m_cConnectivityError = Cursor_xerzistirap.ErrorMessage();
                        Cursor_xerzistirap.Close();
                        // * --- End Select
                      } // End Case
                      /* cIDB2 := LibreriaMit.UniqueId() */
                      cIDB2 = LibreriaMit.UniqueId();
                      /* _datareg := Date() */
                      _datareg = CPLib.Date();
                      // * --- Insert into rapopebo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("rapopebo");
                      m_cPhName = m_Ctx.GetPhName("rapopebo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001F7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000001F7(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xapopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xapopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetDate("DATAAGE"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetDate("DATAOPE"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_datareg,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetDate("DATARETT"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("I"+CPLib.Right(cProg2,9)+cIDB2,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetDouble("PRGIMPINF"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_xapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(cIDB2,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapopebo.GetDouble("FLAGTIT"),"?",0,0)+", ";
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
                      }
                      // * --- Delete from xapopebo
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("xapopebo");
                      m_cPhName = m_Ctx.GetPhName("xapopebo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"000001F8")+"delete from "+m_oWrInfo.GetTableWriteName();
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_idbase,"?",0,0,m_cServer),m_cServer,w_idbase)+"";
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
                      /* _conta := _conta + 1 */
                      _conta = CPLib.Round(_conta+1,0);
                    } else { // Else
                      /* _contano := _contano + 1 */
                      _contano = CPLib.Round(_contano+1,0);
                    } // End If
                  } else { // Else
                    /* Check non passato :( */
                    /* _conta_err := _conta_err+1 */
                    _conta_err = CPLib.Round(_conta_err+1,0);
                    /* mcErrori.AppendBlank() */
                    mcErrori.AppendBlank();
                    /* mcErrori.ERCODICE := xapopebo->RAPPORTO */
                    mcErrori.row.ERCODICE = Cursor_xapopebo.GetString("RAPPORTO");
                    /* mcErrori.ERDESCRI := _error_string */
                    mcErrori.row.ERDESCRI = _error_string;
                    /* mcErrori.SaveRow() */
                    mcErrori.SaveRow();
                  } // End If
                } // End If
                Cursor_xapopebo.Next();
              }
              m_cConnectivityError = Cursor_xapopebo.ErrorMessage();
              Cursor_xapopebo.Close();
              // * --- End Select
              /* If _passato_il_check */
              if (_passato_il_check) {
                // * --- Select from rapopebo
                m_cServer = m_Ctx.GetServer("rapopebo");
                m_cPhName = m_Ctx.GetPhName("rapopebo");
                if (Cursor_rapopebo!=null)
                  Cursor_rapopebo.Close();
                Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAOPE,TIPOOPRAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAOPE ",m_cServer,m_Ctx,true));
                while ( ! (Cursor_rapopebo.Eof())) {
                  /* If At(rapopebo->TIPOOPRAP,'|26|36|38|43|44|46') > 0 */
                  if (CPLib.gt(CPLib.At(Cursor_rapopebo.GetString("TIPOOPRAP"),"|26|36|38|43|44|46"),0)) {
                    // * --- Write into knarapbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("knarapbo");
                    m_cPhName = m_Ctx.GetPhName("knarapbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000204")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"DATAFIN = "+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAOPE"),"D",8,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"knarapbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer),m_cServer,_rapporto)+"";
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
                    /* ElseIf At(rapopebo->TIPOOPRAP,'|23|24|27|33|34|35|43|44|45') > 0 */
                  } else if (CPLib.gt(CPLib.At(Cursor_rapopebo.GetString("TIPOOPRAP"),"|23|24|27|33|34|35|43|44|45"),0)) {
                    // * --- Write into knarapbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("knarapbo");
                    m_cPhName = m_Ctx.GetPhName("knarapbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000205")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(Cursor_rapopebo.GetDate("DATAOPE"),"D",8,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"knarapbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer),m_cServer,_rapporto)+"";
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
                  Cursor_rapopebo.Next();
                }
                m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
                Cursor_rapopebo.Close();
                // * --- End Select
              } // End If
              Cursor_qbe_trasfinfo_idbase_inf.Next();
            }
            m_cConnectivityError = Cursor_qbe_trasfinfo_idbase_inf.ErrorMessage();
            Cursor_qbe_trasfinfo_idbase_inf.Close();
            // * --- End Select
          } else { // Else
            /* gMsgImp := 'Lettura operazioni in corso ...' // Messaggio Import */
            gMsgImp = "Lettura operazioni in corso ...";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          /* _contacicli := _contacicli+1 */
          _contacicli = CPLib.Round(_contacicli+1,0);
        } // End While
        Cursor_qbe_trasfinfo_datope.Next();
      }
      m_cConnectivityError = Cursor_qbe_trasfinfo_datope.ErrorMessage();
      Cursor_qbe_trasfinfo_datope.Close();
      // * --- End Select
      /* gMsgImp := "Elaborazione Terminata con successo. Trasferite "+LRTrim(Str(_conta,10,0))+" - Escluse "+LRTrim(Str(_contano,10,0))+" informazioni" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata con successo. Trasferite "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" - Escluse "+CPLib.LRTrim(CPLib.Str(_contano,10,0))+" informazioni";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If _conta_err>0 */
      if (CPLib.gt(_conta_err,0)) {
        /* gMsgProc := gMsgProc + 'Bloccate '+LRTrim(Str(_conta_err,10,0))+" informazioni per anomalie riscontrate. Consultare la stampa dei errori" + NL */
        gMsgProc = gMsgProc+"Bloccate "+CPLib.LRTrim(CPLib.Str(_conta_err,10,0))+" informazioni per anomalie riscontrate. Consultare la stampa dei errori"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
        if (Cursor_qbe_trasfinfo_datope!=null)
          Cursor_qbe_trasfinfo_datope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasfinfo_count_inf!=null)
          Cursor_qbe_trasfinfo_count_inf.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_trasfinfo_idbase_inf!=null)
          Cursor_qbe_trasfinfo_idbase_inf.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xapopebo!=null)
          Cursor_xapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
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
        if (Cursor_xelegabo!=null)
          Cursor_xelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xoginfo!=null)
          Cursor_xoginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xiduciabo!=null)
          Cursor_xiduciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xerzistirap!=null)
          Cursor_xerzistirap.Close();
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
    }
  }
  void tito() throws Exception {
    CPResultSet Cursor_xapotit=null;
    CPResultSet Cursor_xntestit=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    try {
      /* Scorre la query e trasferisce i dati */
      /* _cinf := 0 */
      _cinf = CPLib.Round(0,0);
      // * --- Select from xapotit
      m_cServer = m_Ctx.GetServer("xapotit");
      m_cPhName = m_Ctx.GetPhName("xapotit");
      if (Cursor_xapotit!=null)
        Cursor_xapotit.Close();
      Cursor_xapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("xapotit")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"DATAREG,DATAOPE ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_xapotit.Eof())) {
        /* If Empty(xapotit->CODDIPE) or xapotit->CODDIPE=gCodDip or Empty(gCodDip) */
        if (CPLib.Empty(Cursor_xapotit.GetString("CODDIPE")) || CPLib.eqr(Cursor_xapotit.GetString("CODDIPE"),gCodDip) || CPLib.Empty(gCodDip)) {
          /* _passato_il_check := True  */
          _passato_il_check = true;
          /* If fai_controlli */
          if (fai_controlli) {
            /* _error_string := '' */
            _error_string = "";
            /* If Empty(xapotit->DATAOPE) */
            if (CPLib.Empty(Cursor_xapotit.GetDate("DATAOPE"))) {
              /* _error_string := ' Data Inizio Legame non presente,' */
              _error_string = " Data Inizio Legame non presente,";
              /* _passato_il_check := False */
              _passato_il_check = false;
            } // End If
            /* If (DateDiff(xapotit->DATAOPE, _date_oggi))>(20*365) */
            if (CPLib.gt((CPLib.DateDiff(Cursor_xapotit.GetDate("DATAOPE"),_date_oggi)),(20*365))) {
              /* ATTENZIONE: La data di inizio titolarià può essere più vecchia di 20 anni! */
            } // End If
            /* If xapotit->DATAOPE>_date_oggi */
            if (CPLib.gt(Cursor_xapotit.GetDate("DATAOPE"),_date_oggi)) {
              /* _error_string := _error_string+' Data Inizio Legame maggiore della Data odierna,' */
              _error_string = _error_string+" Data Inizio Legame maggiore della Data odierna,";
              /* _passato_il_check := False */
              _passato_il_check = false;
            } // End If
            /* If Empty(LRTrim(xapotit->TIPOLEG)) or not(xapotit->TIPOLEG='5' or xapotit->TIPOLEG='7' or xapotit->TIPOLEG='8') */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_xapotit.GetString("TIPOLEG"))) ||  ! (CPLib.eqr(Cursor_xapotit.GetString("TIPOLEG"),"5") || CPLib.eqr(Cursor_xapotit.GetString("TIPOLEG"),"7") || CPLib.eqr(Cursor_xapotit.GetString("TIPOLEG"),"8"))) {
              /* _error_string := _error_string+ " anomalia Tipo Legame,"+NL */
              _error_string = _error_string+" anomalia Tipo Legame,"+"\n";
              /* _passato_il_check := False */
              _passato_il_check = false;
            } // End If
            /* If Empty(xapotit->TIPOOPRAP) */
            if (CPLib.Empty(Cursor_xapotit.GetString("TIPOOPRAP"))) {
              /* _error_string := _error_string+ " anomalia Tipo Registrazione,"+NL */
              _error_string = _error_string+" anomalia Tipo Registrazione,"+"\n";
              /* _passato_il_check := False */
              _passato_il_check = false;
            } // End If
            /* If xapotit->TIPOOPRAP='51' or xapotit->TIPOOPRAP='53' */
            if (CPLib.eqr(Cursor_xapotit.GetString("TIPOOPRAP"),"51") || CPLib.eqr(Cursor_xapotit.GetString("TIPOOPRAP"),"53")) {
              // * --- Select from xntestit
              m_cServer = m_Ctx.GetServer("xntestit");
              m_cPhName = m_Ctx.GetPhName("xntestit");
              if (Cursor_xntestit!=null)
                Cursor_xntestit.Close();
              Cursor_xntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_xapotit.GetString("CONNESCLI"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_xapotit.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xntestit.Eof())) {
                /* _nprog := '' */
                _nprog = "";
                // * --- Read from intestit
                m_cServer = m_Ctx.GetServer("intestit");
                m_cPhName = m_Ctx.GetPhName("intestit");
                m_cSql = "";
                m_cSql = m_cSql+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODCLI"),"C",16,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODCLI"));
                m_cSql = m_cSql+" and CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODINTER"));
                if (m_Ctx.IsSharedTemp("intestit")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMPROG1",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _nprog = Read_Cursor.GetString("NUMPROG1");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on intestit into routine arrt_trasf_prov_aui returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _nprog = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(_nprog) */
                if (CPLib.Empty(_nprog)) {
                  /* _error_string := _error_string+ " Manca Apertura per chiusura legame,"+NL */
                  _error_string = _error_string+" Manca Apertura per chiusura legame,"+"\n";
                  /* _passato_il_check := False */
                  _passato_il_check = false;
                  // Exit Loop
                  if (true) {
                    break;
                  }
                } // End If
                Cursor_xntestit.Next();
              }
              m_cConnectivityError = Cursor_xntestit.ErrorMessage();
              Cursor_xntestit.Close();
              // * --- End Select
            } // End If
            /* Verifica presenza dei Titolare in Anagrafica */
            /* _passato_il_sub_check := False */
            _passato_il_sub_check = false;
            // * --- Select from xntestit
            m_cServer = m_Ctx.GetServer("xntestit");
            m_cPhName = m_Ctx.GetPhName("xntestit");
            if (Cursor_xntestit!=null)
              Cursor_xntestit.Close();
            Cursor_xntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_xapotit.GetString("CONNESCLI"),"?",0,0)+"  and  (NUMPROG1="+CPLib.ToSQL(Cursor_xapotit.GetString("NUMPROG"),"?",0,0)+"  or  NUMPROG2="+CPLib.ToSQL(Cursor_xapotit.GetString("NUMPROG"),"?",0,0)+") "+")"+(m_Ctx.IsSharedTemp("xntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestit.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0)+"=CONNES "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _passato_il_sub_check := True */
                _passato_il_sub_check = true;
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              /* If not(_passato_il_sub_check) */
              if ( ! (_passato_il_sub_check)) {
                /* _error_string := _error_string+ " Titolare Effettivo "+xntestit->CODINTER+" non presente in Anagrafica,"+NL */
                _error_string = _error_string+" Titolare Effettivo "+Cursor_xntestit.GetString("CODINTER")+" non presente in Anagrafica,"+"\n";
                /* _passato_il_check := False */
                _passato_il_check = false;
              } // End If
              Cursor_xntestit.Next();
            }
            m_cConnectivityError = Cursor_xntestit.ErrorMessage();
            Cursor_xntestit.Close();
            // * --- End Select
            /* Verifica presenza del Società controllato da titolari effettivi / Società Fiduciante in Anagrafica */
            /* _passato_il_sub_check := False */
            _passato_il_sub_check = false;
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_xapotit.GetString("CONNESCLI"),"?",0,0)+"=CONNES "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* _passato_il_sub_check := True */
              _passato_il_sub_check = true;
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            /* If not(_passato_il_sub_check) */
            if ( ! (_passato_il_sub_check)) {
              /* _error_string := _error_string+ " Società controllata da titolari effettivi / Società Fiduciante non presente in Anagrafica,"+NL */
              _error_string = _error_string+" Società controllata da titolari effettivi / Società Fiduciante non presente in Anagrafica,"+"\n";
              /* _passato_il_check := False */
              _passato_il_check = false;
            } // End If
            /* _error_string := Substr(_error_string,2,Len(_error_string)-2)+"." */
            _error_string = CPLib.Substr(_error_string,2,CPLib.Len(_error_string)-2)+".";
          } // End If
          /* If _passato_il_check */
          if (_passato_il_check) {
            /* _cinf := _cinf + 1 */
            _cinf = CPLib.Round(_cinf+1,0);
            /* gMsgImp := 'Trasferimento dati  informazioni n. '+xapotit->NUMPROG+' del soggetto: '+xapotit->CONNESCLI // Messaggio Import */
            gMsgImp = "Trasferimento dati  informazioni n. "+Cursor_xapotit.GetString("NUMPROG")+" del soggetto: "+Cursor_xapotit.GetString("CONNESCLI");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* Calcol i nuovi progressivi */
            /* _oldprog := '' */
            _oldprog = "";
            /* cProg1 := Utilities.GetAutonumber("PRGTITO1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
            cProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
            /* cProg2 := Utilities.GetAutonumber("PRGTITO2\'"+LRTrim(gAzienda)+"'",Space(11),11) */
            cProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(11),11);
            /* nProgImp := Utilities.GetAutonumber("PRGIMPTIT\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPTIT\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            /* _datareg := Date() */
            _datareg = CPLib.Date();
            /* idb2 := LibreriaMit.UniqueId() */
            idb2 = LibreriaMit.UniqueId();
            // * --- Insert into rapotit from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("rapotit");
            m_cPhName = m_Ctx.GetPhName("rapotit");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000244")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000244(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datareg),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetDate("DATAAGE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datareg,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(idb2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("T"+CPLib.Right(cProg2,9)+idb2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xapotit.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
            }
            /* _oldprog := cProg2 */
            _oldprog = cProg2;
            // * --- Select from xntestit
            m_cServer = m_Ctx.GetServer("xntestit");
            m_cPhName = m_Ctx.GetPhName("xntestit");
            if (Cursor_xntestit!=null)
              Cursor_xntestit.Close();
            Cursor_xntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_xapotit.GetString("CONNESCLI"),"?",0,0)+"  and  (NUMPROG1="+CPLib.ToSQL(Cursor_xapotit.GetString("NUMPROG"),"?",0,0)+"  or  NUMPROG2="+CPLib.ToSQL(Cursor_xapotit.GetString("NUMPROG"),"?",0,0)+") "+")"+(m_Ctx.IsSharedTemp("xntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestit.Eof())) {
              /* If xapotit->TIPOOPRAP='50' or xapotit->TIPOOPRAP='52' or xapotit->TIPOOPRAP='58' */
              if (CPLib.eqr(Cursor_xapotit.GetString("TIPOOPRAP"),"50") || CPLib.eqr(Cursor_xapotit.GetString("TIPOOPRAP"),"52") || CPLib.eqr(Cursor_xapotit.GetString("TIPOOPRAP"),"58")) {
                /* _nprog := '' */
                _nprog = "";
                /* _datafine := NullDate() */
                _datafine = CPLib.NullDate();
                // * --- Read from intestit
                m_cServer = m_Ctx.GetServer("intestit");
                m_cPhName = m_Ctx.GetPhName("intestit");
                m_cSql = "";
                m_cSql = m_cSql+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODCLI"),"C",16,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODCLI"));
                m_cSql = m_cSql+" and CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODINTER"));
                if (m_Ctx.IsSharedTemp("intestit")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMPROG1",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATAFINE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _nprog = Read_Cursor.GetString("NUMPROG1");
                  _datafine = Read_Cursor.GetDate("DATAFINE");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on intestit into routine arrt_trasf_prov_aui returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _nprog = "";
                  _datafine = CPLib.NullDate();
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(LRTrim(_nprog)) or (not(Empty(LRTrim(_nprog))) and not(Empty(_datafine))) */
                if (CPLib.Empty(CPLib.LRTrim(_nprog)) || ( ! (CPLib.Empty(CPLib.LRTrim(_nprog))) &&  ! (CPLib.Empty(_datafine)))) {
                  // * --- Insert into intestit from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("intestit");
                  m_cPhName = m_Ctx.GetPhName("intestit");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestit",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"0000024C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000024C(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("CODCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetDate("DATARETT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetDate("DATAFINE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_oldprog,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetDouble("ABBINATO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetDouble("PRGIMPTITE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("NOAGE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"intestit",true);
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
                // * --- Delete from xntestit
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xntestit");
                m_cPhName = m_Ctx.GetPhName("xntestit");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestit",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"0000024D")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODCLI"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODCLI"))+"";
                m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODINTER"))+"";
                m_cSql = m_cSql+" and NUMPROG1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("NUMPROG1"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("NUMPROG1"))+"";
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
                /* ElseIf xapotit->TIPOOPRAP='51' or xapotit->TIPOOPRAP='53' */
              } else if (CPLib.eqr(Cursor_xapotit.GetString("TIPOOPRAP"),"51") || CPLib.eqr(Cursor_xapotit.GetString("TIPOOPRAP"),"53")) {
                // * --- Write into intestit from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestit");
                m_cPhName = m_Ctx.GetPhName("intestit");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestit",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"0000024E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_xapotit.GetDate("DATAOPE"),"D",8,0)+", ";
                m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(_oldprog,"C",11,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestit",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODCLI"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODCLI"))+"";
                m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODINTER"))+"";
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
                // * --- Delete from xntestit
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xntestit");
                m_cPhName = m_Ctx.GetPhName("xntestit");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestit",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"0000024F")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODCLI"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODCLI"))+"";
                m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODINTER"))+"";
                m_cSql = m_cSql+" and NUMPROG2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("NUMPROG2"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("NUMPROG2"))+"";
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
              Cursor_xntestit.Next();
            }
            m_cConnectivityError = Cursor_xntestit.ErrorMessage();
            Cursor_xntestit.Close();
            // * --- End Select
            /* Exec Routine arrt_ae_agg_aetesta_tit(xapotit->CONNESCLI) */
            arrt_ae_agg_aetesta_titR.Make(m_Ctx,this).Run(Cursor_xapotit.GetString("CONNESCLI"));
            // * --- Delete from xapotit
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xapotit");
            m_cPhName = m_Ctx.GetPhName("xapotit");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapotit",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_trasf_prov_aui",87,"00000251")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xapotit.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_xapotit.GetString("IDBASE"))+"";
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
            /* Check non passato :( */
            /* _conta_err := _conta_err+1 */
            _conta_err = CPLib.Round(_conta_err+1,0);
            /* mcErrori.AppendBlank() */
            mcErrori.AppendBlank();
            /* mcErrori.ERCODICE := xapotit->CONNESOPER */
            mcErrori.row.ERCODICE = Cursor_xapotit.GetString("CONNESOPER");
            /* mcErrori.ERDESCRI := _error_string */
            mcErrori.row.ERDESCRI = _error_string;
            /* mcErrori.SaveRow() */
            mcErrori.SaveRow();
          } // End If
        } // End If
        Cursor_xapotit.Next();
      }
      m_cConnectivityError = Cursor_xapotit.ErrorMessage();
      Cursor_xapotit.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + "Sono state trasferite "+LRTrim(Str(_cinf,10,0))+" informazioni" + NL // Messaggio */
      gMsgProc = gMsgProc+"Sono state trasferite "+CPLib.LRTrim(CPLib.Str(_cinf,10,0))+" informazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Trasferimento: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Trasferimento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_xapotit!=null)
          Cursor_xapotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xntestit!=null)
          Cursor_xntestit.Close();
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
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_pDatIni,java.sql.Date p_pDatFin,String p_pForza,String p_pInform,String p_pSource,String p_pDoCheck) {
    pDatIni = p_pDatIni;
    pDatFin = p_pDatFin;
    pForza = p_pForza;
    pInform = p_pInform;
    pSource = p_pSource;
    pDoCheck = p_pDoCheck;
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
  public MemoryCursor_mcerrmcf_mcrdef Run(java.sql.Date p_pDatIni,java.sql.Date p_pDatFin,String p_pForza,String p_pInform,String p_pSource,String p_pDoCheck) {
    pDatIni = p_pDatIni;
    pDatFin = p_pDatFin;
    pForza = p_pForza;
    pInform = p_pInform;
    pSource = p_pSource;
    pDoCheck = p_pDoCheck;
    return Run();
  }
  public MemoryCursor_mcerrmcf_mcrdef Run() {
    MemoryCursor_mcerrmcf_mcrdef l_result;
    l_result = null;
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
          main();
        } finally {
          try {
            m_bEventRunning = true;
            com.zucchetti.sitepainter.EventHandler.notifyEvent(com.zucchetti.sitepainter.EventHandler.RUN_END,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
          } finally {
            m_bEventRunning = false;
          }
        }
      } catch(Stop stop_value) {
        l_result = (MemoryCursor_mcerrmcf_mcrdef)stop_value.GetObject();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = null;
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
  public static arrt_trasf_prov_auiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_trasf_prov_auiR(p_Ctx, p_Caller);
  }
  public static arrt_trasf_prov_auiR Make(CPContext p_Ctx) {
    return new arrt_trasf_prov_auiR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pDatIni = CPLib.NullDate();
    pDatFin = CPLib.NullDate();
    pForza = CPLib.Space(1);
    pInform = CPLib.Space(30);
    pSource = CPLib.Space(0);
    pDoCheck = CPLib.Space(0);
    cProg1 = CPLib.Space(10);
    cProg2 = CPLib.Space(11);
    cProg3 = CPLib.Space(10);
    cIDB2 = CPLib.Space(10);
    w_idbase = CPLib.Space(10);
    _conta = 0;
    _contano = 0;
    w_cdaope = CPLib.Space(8);
    w_c_aope = CPLib.Space(8);
    w_cdareg = CPLib.Space(8);
    w_c_areg = CPLib.Space(8);
    w_datreg = CPLib.Space(8);
    w_RAPPORTO = CPLib.Space(25);
    _min = 0;
    _max = 0;
    _tot = 0;
    _cicli = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _maxreg = CPLib.NullDate();
    _minreg = CPLib.NullDate();
    idb2 = CPLib.Space(10);
    _datareg = CPLib.NullDate();
    _idrif = CPLib.Space(10);
    _totale = 0;
    w_DaDatOpe = CPLib.NullDate();
    w_ADatOpe = CPLib.NullDate();
    w_flgforce = CPLib.Space(1);
    nProgImp = 0;
    _crap = 0;
    _cinf = 0;
    mcRapporti = new MemoryCursor_xnarapbo();
    _contarow = 0;
    _rapporto = CPLib.Space(25);
    _numprog = CPLib.Space(11);
    _maxdel = 0;
    _flgdatareg = 0;
    _oldprog = CPLib.Space(11);
    _nprog = CPLib.Space(11);
    _datafine = CPLib.NullDate();
    _nx = 0;
    _sx = 0;
    _date_oggi = CPLib.NullDate();
    fai_controlli = (CPLib.eqr(pDoCheck,"N")?false:true);
    _error_string = "";
    _conta_err = CPLib.Round(0,0);
    mcErrori = new MemoryCursor_mcerrmcf_mcrdef();
    _aborted = false;
    _passato_il_check = false;
    _passato_il_sub_check = false;
    _tmp = CPLib.Space(0);
    mcCauana = new MemoryCursor_mcstringa_mcrdef();
    rwCauana = new MemoryCursorRow_mcstringa_mcrdef();
    mcNumimp_incontrati = new MemoryCursor_storico_import();
    rwNumimp = new MemoryCursorRow_storico_import();
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gFlgDTP=m_Ctx.GetGlobalNumber("gFlgDTP");
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
    cActLog=m_Ctx.GetGlobalString("cActLog");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tbcauana,qbe_tbcauana,qbe_trasf_ope_nx,qbe_trasf_ope_sx,qbe_trasfope_controllo_totale,qbe_trasfope_datope,qbe_trasfope_count_ope,qbe_trasfope_idbase_ope,qbe_trasffra_controllo_totale,qbe_trasffra_datope,qbe_trasffra_count_fra,qbe_trasffra_idbase_fra,qbe_trasfinfo_datope,qbe_trasfinfo_count_inf,qbe_trasfinfo_idbase_inf,
  public static final String m_cVQRList = ",qbe_tbcauana,qbe_tbcauana,qbe_trasf_ope_nx,qbe_trasf_ope_sx,qbe_trasfope_controllo_totale,qbe_trasfope_datope,qbe_trasfope_count_ope,qbe_trasfope_idbase_ope,qbe_trasffra_controllo_totale,qbe_trasffra_datope,qbe_trasffra_count_fra,qbe_trasffra_idbase_fra,qbe_trasfinfo_datope,qbe_trasfinfo_count_inf,qbe_trasfinfo_idbase_inf,";
  // ENTITY_BATCHES: ,arfn_delete_import_numimp_check,arfn_fdatetime,arrt_ae_agg_aetesta_tit,arrt_trasf_prov_aui,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_delete_import_numimp_check,arfn_fdatetime,arrt_ae_agg_aetesta_tit,arrt_trasf_prov_aui,arrt_writelog,";
  public static String[] m_cRunParameterNames={"pDatIni","pDatFin","pForza","pInform","pSource","pDoCheck"};
  protected static String GetFieldsName_000000CC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
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
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DAC6,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGDAC6,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"IMPSARA,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITIGDOC,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NOSARA,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROQUOTA,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"SV58550,";
    p_cSql = p_cSql+"SV58550MA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOORO,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"MEZPAG,";
    p_cSql = p_cSql+"PRESTAZ,";
    p_cSql = p_cSql+"CAUSALE,";
    p_cSql = p_cSql+"VASP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"IDBIGLIETTO,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+"IDDOCALL,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+"WUDATRET,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+"FLAGFRAUD,";
    p_cSql = p_cSql+"SV58724,";
    p_cSql = p_cSql+"SV58726SCA,";
    p_cSql = p_cSql+"SV58726SA,";
    p_cSql = p_cSql+"SV58726PISP,";
    p_cSql = p_cSql+"C_COGNOME,";
    p_cSql = p_cSql+"C_NOME,";
    p_cSql = p_cSql+"SOSPAGAM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"beneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000DA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000000DD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"docopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapcoll",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000136(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
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
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DAC6,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGDAC6,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"IMPSARA,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MITIGDOC,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NOSARA,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"PROQUOTA,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"SV58550,";
    p_cSql = p_cSql+"SV58550MA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOORO,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"MEZPAG,";
    p_cSql = p_cSql+"PRESTAZ,";
    p_cSql = p_cSql+"CAUSALE,";
    p_cSql = p_cSql+"VASP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000138(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"IDBIGLIETTO,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+"IDDOCALL,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+"WUDATRET,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+"FLAGFRAUD,";
    p_cSql = p_cSql+"SV58724,";
    p_cSql = p_cSql+"SV58726SCA,";
    p_cSql = p_cSql+"SV58726SA,";
    p_cSql = p_cSql+"SV58726PISP,";
    p_cSql = p_cSql+"C_COGNOME,";
    p_cSql = p_cSql+"C_NOME,";
    p_cSql = p_cSql+"SOSPAGAM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000013B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopefbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000013E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000141(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"beneficfrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000144(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000147(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"docfrabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000017F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"CONTINUA,";
    p_cSql = p_cSql+"DATAMOD,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDRAPPORTO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"TIPMOD,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"IMPAPE,";
    p_cSql = p_cSql+"IMPCHIU,";
    p_cSql = p_cSql+"SPLITCODE,";
    p_cSql = p_cSql+"MACODICE,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"CODICELR,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DAC6,";
    p_cSql = p_cSql+"FLAGDAC6,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"CODOGG,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"DATAPROF,";
    p_cSql = p_cSql+"DATAREVPROF,";
    p_cSql = p_cSql+"NOCANC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000183(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"PROGAET,";
    p_cSql = p_cSql+"RIFANA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aetesta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001E0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"NOAGE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"delegabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001EA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001ED(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"soginfo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001F0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fiduciabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001F3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"terzistirap",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001F7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
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
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPINF,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"FLAGTIT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000244(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
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
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPTIT,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapotit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000024C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODCLI,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"PRGIMPTITE,";
    p_cSql = p_cSql+"NOAGE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestit",true);
    return p_cSql;
  }
}
