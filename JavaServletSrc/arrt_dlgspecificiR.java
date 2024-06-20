// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_dlgspecificiR implements CallerWithObjs {
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
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_meneficfrz;
  public String m_cServer_meneficfrz;
  public String m_cPhName_meneficope;
  public String m_cServer_meneficope;
  public String m_cPhName_merzistifrz;
  public String m_cServer_merzistifrz;
  public String m_cPhName_merzistiope;
  public String m_cServer_merzistiope;
  public String m_cPhName_mlientifrz;
  public String m_cServer_mlientifrz;
  public String m_cPhName_mlientiope;
  public String m_cServer_mlientiope;
  public String m_cPhName_mogopebo;
  public String m_cServer_mogopebo;
  public String m_cPhName_mogopefbo;
  public String m_cServer_mogopefbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
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
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_tipo1;
  public String m_cServer_tipo1;
  public String m_cPhName_tipo2_3;
  public String m_cServer_tipo2_3;
  public String m_cPhName_tipo4;
  public String m_cServer_tipo4;
  public String m_cPhName_tipo5;
  public String m_cServer_tipo5;
  public String m_cPhName_tipo6;
  public String m_cServer_tipo6;
  public String m_cPhName_fiduciabo;
  public String m_cServer_fiduciabo;
  public String m_cPhName_xiduciabo;
  public String m_cServer_xiduciabo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_tipo9;
  public String m_cServer_tipo9;
  public String m_cPhName_tipo7;
  public String m_cServer_tipo7;
  public String m_cPhName_tipo8;
  public String m_cServer_tipo8;
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
  public String w_codinter;
  public String w_tipinter;
  public String w_flgint;
  public String w_flgrae;
  public String w_flgsto;
  public String w_flgdel;
  public String w_passwd;
  public String w_tipofile;
  public double w_numreg;
  public double w_numrec;
  public String gPathApp;
  public String gIntemediario;
  public String gUrlApp;
  public String gAzienda;
  public double gNumRec;
  public double gNumReg;
  public String gMsgImp;
  public String gMsgProc;
  public String gFlgWU;
  public String w_codcab;
  public String w_cabcod;
  public String w_desccit;
  public String w_citdesc;
  public String w_provin;
  public String w_provind;
  public String w_coddipe;
  public String _note;
  public String fhand;
  public String _nomefile;
  public String cNomeFile;
  public String cOnlyNomeFile;
  public String cNomeFileZip;
  public double nTotRec;
  public double nTotReg;
  public double nNumRec;
  public double _avanza;
  public String _codrif;
  public String w_cdadata;
  public String w_c_adata;
  public String w_cdadata_rap;
  public String w_c_adata_rap;
  public double _ctotale;
  public double _conta;
  public double _max;
  public double _min;
  public double _top;
  public double _bottom;
  public double _cicli;
  public double _contacilci;
  public String _flagrap;
  public double _ciclo;
  public String _ramate;
  public String _numsto;
  public double _oldrighe;
  public double _continua;
  public String _oldrap;
  public String _idereg;
  public String xStato;
  public double _conta1;
  public double _conta2;
  public double _conta4;
  public double _conta5;
  public double _conta6;
  public double _conta7;
  public double _conta8;
  public double _conta9;
  public String w_codage;
  public String w_codcli;
  public String w_ragben;
  public String _raeatc;
  public double _rownum;
  public String _tiprec;
  public String _tipoag;
  public String _datage;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_dlgspecificiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_dlgspecifici",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
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
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
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
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo");
    if (m_cPhName_kersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kersonbo = m_cPhName_kersonbo+" "+m_Ctx.GetWritePhName("kersonbo");
    }
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_meneficfrz = p_ContextObject.GetPhName("meneficfrz");
    if (m_cPhName_meneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_meneficfrz = m_cPhName_meneficfrz+" "+m_Ctx.GetWritePhName("meneficfrz");
    }
    m_cServer_meneficfrz = p_ContextObject.GetServer("meneficfrz");
    m_cPhName_meneficope = p_ContextObject.GetPhName("meneficope");
    if (m_cPhName_meneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_meneficope = m_cPhName_meneficope+" "+m_Ctx.GetWritePhName("meneficope");
    }
    m_cServer_meneficope = p_ContextObject.GetServer("meneficope");
    m_cPhName_merzistifrz = p_ContextObject.GetPhName("merzistifrz");
    if (m_cPhName_merzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_merzistifrz = m_cPhName_merzistifrz+" "+m_Ctx.GetWritePhName("merzistifrz");
    }
    m_cServer_merzistifrz = p_ContextObject.GetServer("merzistifrz");
    m_cPhName_merzistiope = p_ContextObject.GetPhName("merzistiope");
    if (m_cPhName_merzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_merzistiope = m_cPhName_merzistiope+" "+m_Ctx.GetWritePhName("merzistiope");
    }
    m_cServer_merzistiope = p_ContextObject.GetServer("merzistiope");
    m_cPhName_mlientifrz = p_ContextObject.GetPhName("mlientifrz");
    if (m_cPhName_mlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mlientifrz = m_cPhName_mlientifrz+" "+m_Ctx.GetWritePhName("mlientifrz");
    }
    m_cServer_mlientifrz = p_ContextObject.GetServer("mlientifrz");
    m_cPhName_mlientiope = p_ContextObject.GetPhName("mlientiope");
    if (m_cPhName_mlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mlientiope = m_cPhName_mlientiope+" "+m_Ctx.GetWritePhName("mlientiope");
    }
    m_cServer_mlientiope = p_ContextObject.GetServer("mlientiope");
    m_cPhName_mogopebo = p_ContextObject.GetPhName("mogopebo");
    if (m_cPhName_mogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mogopebo = m_cPhName_mogopebo+" "+m_Ctx.GetWritePhName("mogopebo");
    }
    m_cServer_mogopebo = p_ContextObject.GetServer("mogopebo");
    m_cPhName_mogopefbo = p_ContextObject.GetPhName("mogopefbo");
    if (m_cPhName_mogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mogopefbo = m_cPhName_mogopefbo+" "+m_Ctx.GetWritePhName("mogopefbo");
    }
    m_cServer_mogopefbo = p_ContextObject.GetServer("mogopefbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
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
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
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
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_tipo1 = p_ContextObject.GetPhName("tipo1");
    if (m_cPhName_tipo1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo1 = m_cPhName_tipo1+" "+m_Ctx.GetWritePhName("tipo1");
    }
    m_cServer_tipo1 = p_ContextObject.GetServer("tipo1");
    m_cPhName_tipo2_3 = p_ContextObject.GetPhName("tipo2_3");
    if (m_cPhName_tipo2_3.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo2_3 = m_cPhName_tipo2_3+" "+m_Ctx.GetWritePhName("tipo2_3");
    }
    m_cServer_tipo2_3 = p_ContextObject.GetServer("tipo2_3");
    m_cPhName_tipo4 = p_ContextObject.GetPhName("tipo4");
    if (m_cPhName_tipo4.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo4 = m_cPhName_tipo4+" "+m_Ctx.GetWritePhName("tipo4");
    }
    m_cServer_tipo4 = p_ContextObject.GetServer("tipo4");
    m_cPhName_tipo5 = p_ContextObject.GetPhName("tipo5");
    if (m_cPhName_tipo5.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo5 = m_cPhName_tipo5+" "+m_Ctx.GetWritePhName("tipo5");
    }
    m_cServer_tipo5 = p_ContextObject.GetServer("tipo5");
    m_cPhName_tipo6 = p_ContextObject.GetPhName("tipo6");
    if (m_cPhName_tipo6.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo6 = m_cPhName_tipo6+" "+m_Ctx.GetWritePhName("tipo6");
    }
    m_cServer_tipo6 = p_ContextObject.GetServer("tipo6");
    m_cPhName_fiduciabo = p_ContextObject.GetPhName("fiduciabo");
    if (m_cPhName_fiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fiduciabo = m_cPhName_fiduciabo+" "+m_Ctx.GetWritePhName("fiduciabo");
    }
    m_cServer_fiduciabo = p_ContextObject.GetServer("fiduciabo");
    m_cPhName_xiduciabo = p_ContextObject.GetPhName("xiduciabo");
    if (m_cPhName_xiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xiduciabo = m_cPhName_xiduciabo+" "+m_Ctx.GetWritePhName("xiduciabo");
    }
    m_cServer_xiduciabo = p_ContextObject.GetServer("xiduciabo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_tipo9 = p_ContextObject.GetPhName("tipo9");
    if (m_cPhName_tipo9.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo9 = m_cPhName_tipo9+" "+m_Ctx.GetWritePhName("tipo9");
    }
    m_cServer_tipo9 = p_ContextObject.GetServer("tipo9");
    m_cPhName_tipo7 = p_ContextObject.GetPhName("tipo7");
    if (m_cPhName_tipo7.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo7 = m_cPhName_tipo7+" "+m_Ctx.GetWritePhName("tipo7");
    }
    m_cServer_tipo7 = p_ContextObject.GetServer("tipo7");
    m_cPhName_tipo8 = p_ContextObject.GetPhName("tipo8");
    if (m_cPhName_tipo8.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo8 = m_cPhName_tipo8+" "+m_Ctx.GetWritePhName("tipo8");
    }
    m_cServer_tipo8 = p_ContextObject.GetServer("tipo8");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("numreg",p_cVarName)) {
      return w_numreg;
    }
    if (CPLib.eqr("numrec",p_cVarName)) {
      return w_numrec;
    }
    if (CPLib.eqr("gNumRec",p_cVarName)) {
      return gNumRec;
    }
    if (CPLib.eqr("gNumReg",p_cVarName)) {
      return gNumReg;
    }
    if (CPLib.eqr("nTotRec",p_cVarName)) {
      return nTotRec;
    }
    if (CPLib.eqr("nTotReg",p_cVarName)) {
      return nTotReg;
    }
    if (CPLib.eqr("nNumRec",p_cVarName)) {
      return nNumRec;
    }
    if (CPLib.eqr("_avanza",p_cVarName)) {
      return _avanza;
    }
    if (CPLib.eqr("_ctotale",p_cVarName)) {
      return _ctotale;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      return _contacilci;
    }
    if (CPLib.eqr("_ciclo",p_cVarName)) {
      return _ciclo;
    }
    if (CPLib.eqr("_oldrighe",p_cVarName)) {
      return _oldrighe;
    }
    if (CPLib.eqr("_continua",p_cVarName)) {
      return _continua;
    }
    if (CPLib.eqr("_conta1",p_cVarName)) {
      return _conta1;
    }
    if (CPLib.eqr("_conta2",p_cVarName)) {
      return _conta2;
    }
    if (CPLib.eqr("_conta4",p_cVarName)) {
      return _conta4;
    }
    if (CPLib.eqr("_conta5",p_cVarName)) {
      return _conta5;
    }
    if (CPLib.eqr("_conta6",p_cVarName)) {
      return _conta6;
    }
    if (CPLib.eqr("_conta7",p_cVarName)) {
      return _conta7;
    }
    if (CPLib.eqr("_conta8",p_cVarName)) {
      return _conta8;
    }
    if (CPLib.eqr("_conta9",p_cVarName)) {
      return _conta9;
    }
    if (CPLib.eqr("_rownum",p_cVarName)) {
      return _rownum;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_dlgspecifici";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("codinter",p_cVarName)) {
      return w_codinter;
    }
    if (CPLib.eqr("tipinter",p_cVarName)) {
      return w_tipinter;
    }
    if (CPLib.eqr("flgint",p_cVarName)) {
      return w_flgint;
    }
    if (CPLib.eqr("flgrae",p_cVarName)) {
      return w_flgrae;
    }
    if (CPLib.eqr("flgsto",p_cVarName)) {
      return w_flgsto;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      return w_flgdel;
    }
    if (CPLib.eqr("passwd",p_cVarName)) {
      return w_passwd;
    }
    if (CPLib.eqr("tipofile",p_cVarName)) {
      return w_tipofile;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
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
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      return gFlgWU;
    }
    if (CPLib.eqr("codcab",p_cVarName)) {
      return w_codcab;
    }
    if (CPLib.eqr("cabcod",p_cVarName)) {
      return w_cabcod;
    }
    if (CPLib.eqr("desccit",p_cVarName)) {
      return w_desccit;
    }
    if (CPLib.eqr("citdesc",p_cVarName)) {
      return w_citdesc;
    }
    if (CPLib.eqr("provin",p_cVarName)) {
      return w_provin;
    }
    if (CPLib.eqr("provind",p_cVarName)) {
      return w_provind;
    }
    if (CPLib.eqr("coddipe",p_cVarName)) {
      return w_coddipe;
    }
    if (CPLib.eqr("_note",p_cVarName)) {
      return _note;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
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
    if (CPLib.eqr("_codrif",p_cVarName)) {
      return _codrif;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      return w_cdadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("cdadata_rap",p_cVarName)) {
      return w_cdadata_rap;
    }
    if (CPLib.eqr("c_adata_rap",p_cVarName)) {
      return w_c_adata_rap;
    }
    if (CPLib.eqr("_flagrap",p_cVarName)) {
      return _flagrap;
    }
    if (CPLib.eqr("_ramate",p_cVarName)) {
      return _ramate;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      return _numsto;
    }
    if (CPLib.eqr("_oldrap",p_cVarName)) {
      return _oldrap;
    }
    if (CPLib.eqr("_idereg",p_cVarName)) {
      return _idereg;
    }
    if (CPLib.eqr("xStato",p_cVarName)) {
      return xStato;
    }
    if (CPLib.eqr("codage",p_cVarName)) {
      return w_codage;
    }
    if (CPLib.eqr("codcli",p_cVarName)) {
      return w_codcli;
    }
    if (CPLib.eqr("ragben",p_cVarName)) {
      return w_ragben;
    }
    if (CPLib.eqr("_raeatc",p_cVarName)) {
      return _raeatc;
    }
    if (CPLib.eqr("_tiprec",p_cVarName)) {
      return _tiprec;
    }
    if (CPLib.eqr("_tipoag",p_cVarName)) {
      return _tipoag;
    }
    if (CPLib.eqr("_datage",p_cVarName)) {
      return _datage;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
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
    if (CPLib.eqr("numreg",p_cVarName)) {
      w_numreg = value;
      return;
    }
    if (CPLib.eqr("numrec",p_cVarName)) {
      w_numrec = value;
      return;
    }
    if (CPLib.eqr("gNumRec",p_cVarName)) {
      gNumRec = value;
      return;
    }
    if (CPLib.eqr("gNumReg",p_cVarName)) {
      gNumReg = value;
      return;
    }
    if (CPLib.eqr("nTotRec",p_cVarName)) {
      nTotRec = value;
      return;
    }
    if (CPLib.eqr("nTotReg",p_cVarName)) {
      nTotReg = value;
      return;
    }
    if (CPLib.eqr("nNumRec",p_cVarName)) {
      nNumRec = value;
      return;
    }
    if (CPLib.eqr("_avanza",p_cVarName)) {
      _avanza = value;
      return;
    }
    if (CPLib.eqr("_ctotale",p_cVarName)) {
      _ctotale = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
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
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
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
    if (CPLib.eqr("_ciclo",p_cVarName)) {
      _ciclo = value;
      return;
    }
    if (CPLib.eqr("_oldrighe",p_cVarName)) {
      _oldrighe = value;
      return;
    }
    if (CPLib.eqr("_continua",p_cVarName)) {
      _continua = value;
      return;
    }
    if (CPLib.eqr("_conta1",p_cVarName)) {
      _conta1 = value;
      return;
    }
    if (CPLib.eqr("_conta2",p_cVarName)) {
      _conta2 = value;
      return;
    }
    if (CPLib.eqr("_conta4",p_cVarName)) {
      _conta4 = value;
      return;
    }
    if (CPLib.eqr("_conta5",p_cVarName)) {
      _conta5 = value;
      return;
    }
    if (CPLib.eqr("_conta6",p_cVarName)) {
      _conta6 = value;
      return;
    }
    if (CPLib.eqr("_conta7",p_cVarName)) {
      _conta7 = value;
      return;
    }
    if (CPLib.eqr("_conta8",p_cVarName)) {
      _conta8 = value;
      return;
    }
    if (CPLib.eqr("_conta9",p_cVarName)) {
      _conta9 = value;
      return;
    }
    if (CPLib.eqr("_rownum",p_cVarName)) {
      _rownum = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("codinter",p_cVarName)) {
      w_codinter = value;
      return;
    }
    if (CPLib.eqr("tipinter",p_cVarName)) {
      w_tipinter = value;
      return;
    }
    if (CPLib.eqr("flgint",p_cVarName)) {
      w_flgint = value;
      return;
    }
    if (CPLib.eqr("flgrae",p_cVarName)) {
      w_flgrae = value;
      return;
    }
    if (CPLib.eqr("flgsto",p_cVarName)) {
      w_flgsto = value;
      return;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      w_flgdel = value;
      return;
    }
    if (CPLib.eqr("passwd",p_cVarName)) {
      w_passwd = value;
      return;
    }
    if (CPLib.eqr("tipofile",p_cVarName)) {
      w_tipofile = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
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
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      gFlgWU = value;
      return;
    }
    if (CPLib.eqr("codcab",p_cVarName)) {
      w_codcab = value;
      return;
    }
    if (CPLib.eqr("cabcod",p_cVarName)) {
      w_cabcod = value;
      return;
    }
    if (CPLib.eqr("desccit",p_cVarName)) {
      w_desccit = value;
      return;
    }
    if (CPLib.eqr("citdesc",p_cVarName)) {
      w_citdesc = value;
      return;
    }
    if (CPLib.eqr("provin",p_cVarName)) {
      w_provin = value;
      return;
    }
    if (CPLib.eqr("provind",p_cVarName)) {
      w_provind = value;
      return;
    }
    if (CPLib.eqr("coddipe",p_cVarName)) {
      w_coddipe = value;
      return;
    }
    if (CPLib.eqr("_note",p_cVarName)) {
      _note = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
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
    if (CPLib.eqr("_codrif",p_cVarName)) {
      _codrif = value;
      return;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      w_cdadata = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("cdadata_rap",p_cVarName)) {
      w_cdadata_rap = value;
      return;
    }
    if (CPLib.eqr("c_adata_rap",p_cVarName)) {
      w_c_adata_rap = value;
      return;
    }
    if (CPLib.eqr("_flagrap",p_cVarName)) {
      _flagrap = value;
      return;
    }
    if (CPLib.eqr("_ramate",p_cVarName)) {
      _ramate = value;
      return;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      _numsto = value;
      return;
    }
    if (CPLib.eqr("_oldrap",p_cVarName)) {
      _oldrap = value;
      return;
    }
    if (CPLib.eqr("_idereg",p_cVarName)) {
      _idereg = value;
      return;
    }
    if (CPLib.eqr("xStato",p_cVarName)) {
      xStato = value;
      return;
    }
    if (CPLib.eqr("codage",p_cVarName)) {
      w_codage = value;
      return;
    }
    if (CPLib.eqr("codcli",p_cVarName)) {
      w_codcli = value;
      return;
    }
    if (CPLib.eqr("ragben",p_cVarName)) {
      w_ragben = value;
      return;
    }
    if (CPLib.eqr("_raeatc",p_cVarName)) {
      _raeatc = value;
      return;
    }
    if (CPLib.eqr("_tiprec",p_cVarName)) {
      _tiprec = value;
      return;
    }
    if (CPLib.eqr("_tipoag",p_cVarName)) {
      _tipoag = value;
      return;
    }
    if (CPLib.eqr("_datage",p_cVarName)) {
      _datage = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    /* w_codinter Char(11) */
    /* w_tipinter Char(2) */
    /* w_flgint Char(1) */
    /* w_flgrae Char(1) */
    /* w_flgsto Char(1) */
    /* w_flgdel Char(1) */
    /* w_passwd Char(20) */
    /* w_tipofile Char(1) */
    /* w_numreg Numeric(15, 0) */
    /* w_numrec Numeric(15, 0) */
    /* gPathApp Char(80) // Path Applicazione */
    /* gIntemediario Char(11) // Intermediario */
    /* gUrlApp Char(80) // URL Applicazione */
    /* gAzienda Char(10) // Azienda */
    /* gNumRec Numeric(15, 0) // N° Record DIANA */
    /* gNumReg Numeric(15, 0) // N° Registrazioni DIANA */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Memo // Messaggio */
    /* gFlgWU Char(1) // Gestione WU */
    /* w_codcab Char(6) */
    /* w_cabcod Char(6) */
    /* w_desccit Char(30) */
    /* w_citdesc Char(30) */
    /* w_provin Char(2) */
    /* w_provind Char(2) */
    /* w_coddipe Char(6) */
    /* _note Memo */
    /* fhand Char(10) */
    /* _nomefile Char(15) */
    /* cNomeFile Char(30) */
    /* cOnlyNomeFile Char(30) */
    /* cNomeFileZip Char(30) */
    /* nTotRec Numeric(10, 0) */
    /* nTotReg Numeric(10, 0) */
    /* nNumRec Numeric(10, 0) */
    /* _avanza Numeric(1, 0) */
    /* _codrif Char(16) */
    /* w_cdadata Char(8) */
    /* w_c_adata Char(8) */
    /* w_cdadata_rap Char(8) */
    /* w_c_adata_rap Char(8) */
    /* _ctotale Numeric(10, 0) */
    /* _conta Numeric(10, 0) */
    /* _max Numeric(15, 0) */
    /* _min Numeric(15, 0) */
    /* _top Numeric(15, 0) */
    /* _bottom Numeric(15, 0) */
    /* _cicli Numeric(15, 0) */
    /* _contacilci Numeric(15, 0) */
    /* _ctotale Numeric(15, 0) */
    /* _flagrap Char(1) */
    /* _ciclo Numeric(1, 0) */
    /* _ramate Char(3) */
    /* _numsto Char(15) */
    /* _oldrighe Numeric(1, 0) */
    /* _continua Numeric(1, 0) */
    /* _oldrap Char(25) */
    /* _idereg Char(20) */
    /* xStato Char(1) */
    /* _conta1 Numeric(10, 0) */
    /* _conta2 Numeric(10, 0) */
    /* _conta4 Numeric(10, 0) */
    /* _conta5 Numeric(10, 0) */
    /* _conta6 Numeric(10, 0) */
    /* _conta7 Numeric(10, 0) */
    /* _conta8 Numeric(10, 0) */
    /* _conta9 Numeric(10, 0) */
    /* w_codage Char(6) */
    /* w_codcli Char(16) */
    /* w_ragben Char(70) */
    /* _raeatc Char(1) */
    /* _rownum Numeric(10, 0) */
    /* _tiprec Char(1) */
    /* _tipoag Char(10) */
    /* _datage Char(54) */
    /* If LRTrim(w_passwd) <> 'MITUIFDEL' */
    if (CPLib.ne(CPLib.LRTrim(w_passwd),"MITUIFDEL")) {
      /* gMsgImp := 'PASSWORD ERRATA. IMPOSSIBILE ELABORARE' // Messaggio Import */
      gMsgImp = "PASSWORD ERRATA. IMPOSSIBILE ELABORARE";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } else { // Else
      /* gMsgProc := gMsgProc + 'Ora Inizio Procedura: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Inizio Procedura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* xStato := '' */
      xStato = "";
      /* _codrif := '' */
      _codrif = "";
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* _ctotale := 0 */
      _ctotale = CPLib.Round(0,0);
      /* w_cdadata := '' */
      w_cdadata = "";
      /* w_c_adata := '' */
      w_c_adata = "";
      /* w_codage := '' */
      w_codage = "";
      /* w_codcli := '' */
      w_codcli = "";
      /* w_ragben := '' */
      w_ragben = "";
      /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/ARCHIVIO.zip" */
      cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/ARCHIVIO.zip";
      /* If w_tipofile='U' */
      if (CPLib.eqr(w_tipofile,"U")) {
        /* cOnlyNomeFile := "ARCHIVIO.AUI" */
        cOnlyNomeFile = "ARCHIVIO.AUI";
        /* cNomeFile := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/ARCHIVIO.AUI" */
        cNomeFile = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/ARCHIVIO.AUI";
        /* fhand := FileLibMit.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(cOnlyNomeFile)) */
        fhand = FileLibMit.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(cOnlyNomeFile));
      } // End If
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000061status;
      nTry00000061status = m_Sql.GetTransactionStatus();
      String cTry00000061msg;
      cTry00000061msg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' dei dati' + NL */
        gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" dei dati"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* Exec "Operazioni" Page 2:Page_2 */
        Page_2();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Informazioni" Page 3:Page_3 */
        Page_3();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Titolari" Page 4:Page_4 */
        Page_4();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* If w_tipofile='U' */
        if (CPLib.eqr(w_tipofile,"U")) {
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
        } // End If
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* Exec "Crea file zip" Page 5:Page_5 */
        Page_5();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* w_numreg := nTotReg */
        w_numreg = CPLib.Round(nTotReg,0);
        /* w_numrec := nTotRec */
        w_numrec = CPLib.Round(nTotRec,0);
        /* fhand := FileLibMit.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/valoriaui.txt") */
        fhand = FileLibMit.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/valoriaui.txt");
        /* FileLibMit.WriteLine(fhand,'Risultati creazione campionennnn.txt') */
        FileLibMit.WriteLine(fhand,"Risultati creazione campionennnn.txt");
        /* FileLibMit.WriteLine(fhand,'') */
        FileLibMit.WriteLine(fhand,"");
        /* FileLibMit.WriteLine(fhand,'File Prodotti: '+Str(_conta,10,0)) */
        FileLibMit.WriteLine(fhand,"File Prodotti: "+CPLib.Str(_conta,10,0));
        /* FileLibMit.WriteLine(fhand,'N° Registrazioni: '+Str(w_numreg,10,0)) */
        FileLibMit.WriteLine(fhand,"N° Registrazioni: "+CPLib.Str(w_numreg,10,0));
        /* FileLibMit.WriteLine(fhand,'N° Record: '+Str(w_numrec,10,0)) */
        FileLibMit.WriteLine(fhand,"N° Record: "+CPLib.Str(w_numrec,10,0));
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* gMsgImp := 'Elaborazione terminata. Premere il bottone per prelevare il file' // Messaggio Import */
        gMsgImp = "Elaborazione terminata. Premere il bottone per prelevare il file";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' dei dati' + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" dei dati"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc + "Rilevati errori nell'elaborazione dei dati !" + NL */
        gMsgProc = gMsgProc+"Rilevati errori nell'elaborazione dei dati !"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
        gMsgProc = gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' dei dati' + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" dei dati"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000061status,0)) {
          m_Sql.SetTransactionStatus(nTry00000061status,cTry00000061msg);
        }
      }
    } // End If
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_oped_chkdiana_limits=null;
    CPResultSet Cursor_qbe_oped_chkdiana=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_kersonbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_mlientiope=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_mogopebo=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_meneficope=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_merzistiope=null;
    CPResultSet Cursor_terzistiope=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle operazioni */
      /* gMsgImp := 'Verifica Operazioni da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Operazioni da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _ciclo := 0 */
      _ciclo = CPLib.Round(0,0);
      /* Prima gli italiani */
      // * --- Select from qbe_oped_chkdiana_limits
      SPBridge.HMCaller _h0000007F;
      _h0000007F = new SPBridge.HMCaller();
      _h0000007F.Set("m_cVQRList",m_cVQRList);
      _h0000007F.Set("cdadata",w_cdadata);
      _h0000007F.Set("c_adata",w_c_adata);
      _h0000007F.Set("codage",w_codage);
      _h0000007F.Set("codcli",w_codcli);
      _h0000007F.Set("ragben",w_ragben);
      if (Cursor_qbe_oped_chkdiana_limits!=null)
        Cursor_qbe_oped_chkdiana_limits.Close();
      Cursor_qbe_oped_chkdiana_limits = new VQRHolder("qbe_oped_chkdiana_limits",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000007F,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_oped_chkdiana_limits.Eof())) {
        /* _max := qbe_oped_chkdiana_limits->MAXOPE */
        _max = CPLib.Round(Cursor_qbe_oped_chkdiana_limits.GetDouble("MAXOPE"),0);
        /* _min := qbe_oped_chkdiana_limits->MINOPE */
        _min = CPLib.Round(Cursor_qbe_oped_chkdiana_limits.GetDouble("MINOPE"),0);
        Cursor_qbe_oped_chkdiana_limits.Next();
      }
      m_cConnectivityError = Cursor_qbe_oped_chkdiana_limits.ErrorMessage();
      Cursor_qbe_oped_chkdiana_limits.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      /* _bottom := _min */
      _bottom = CPLib.Round(_min,0);
      /* If _min > 5000 */
      if (CPLib.gt(_min,5000)) {
        /* _contacilci := Int(_min/5000) + 1 */
        _contacilci = CPLib.Round(CPLib.Int(_min/5000)+1,0);
      } else { // Else
        /* _contacilci := 1 */
        _contacilci = CPLib.Round(1,0);
      } // End If
      /* gMsgImp := 'Lettura operazioni in corso ...' // Messaggio Import */
      gMsgImp = "Lettura operazioni in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* While _contacilci<=_cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* _bottom := iif(_ciclo=0,_bottom,((_contacilci -1 ) * 5000) + 1) */
        _bottom = CPLib.Round((CPLib.eqr(_ciclo,0)?_bottom:((_contacilci-1)*5000)+1),0);
        /* _top := _contacilci * 5000 */
        _top = CPLib.Round(_contacilci*5000,0);
        /* _ciclo := 1 */
        _ciclo = CPLib.Round(1,0);
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* gMsgImp := 'Lettura operazioni in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura operazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Cicla sulle operazioni */
        // * --- Select from qbe_oped_chkdiana
        SPBridge.HMCaller _h0000008F;
        _h0000008F = new SPBridge.HMCaller();
        _h0000008F.Set("m_cVQRList",m_cVQRList);
        _h0000008F.Set("cdadata",w_cdadata);
        _h0000008F.Set("c_adata",w_c_adata);
        _h0000008F.Set("codage",w_codage);
        _h0000008F.Set("_bottom",_bottom);
        _h0000008F.Set("_top",_top);
        _h0000008F.Set("codcli",w_codcli);
        _h0000008F.Set("ragben",w_ragben);
        if (Cursor_qbe_oped_chkdiana!=null)
          Cursor_qbe_oped_chkdiana.Close();
        Cursor_qbe_oped_chkdiana = new VQRHolder("qbe_oped_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000008F,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_oped_chkdiana.Eof())) {
          /* _ctotale := _ctotale + 1 */
          _ctotale = CPLib.Round(_ctotale+1,0);
          /* gMsgImp := 'Elaborazione Operazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
          gMsgImp = "Elaborazione Operazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _idereg := arfn_calc_idereg("O",qbe_oped_chkdiana->NUMPROG,qbe_oped_chkdiana->IDEREG) */
          _idereg = arfn_calc_ideregR.Make(m_Ctx,this).Run("O",Cursor_qbe_oped_chkdiana.GetString("NUMPROG"),Cursor_qbe_oped_chkdiana.GetString("IDEREG"));
          /* If qbe_oped_chkdiana->DATAOPE <  CharToDate('20100601') */
          if (CPLib.lt(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20100601"))) {
            /* _raeatc := 'R' */
            _raeatc = "R";
            /* ElseIf qbe_oped_chkdiana->DATAOPE >  CharToDate('20131231') */
          } else if (CPLib.gt(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
            /* _raeatc := 'A' */
            _raeatc = "A";
          } else { // Else
            /* _raeatc := w_flgrae */
            _raeatc = w_flgrae;
          } // End If
          /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '1' + _idereg */
          _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"1"+_idereg;
          /* _flagrap := '' */
          _flagrap = "";
          // * --- Select from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          if (Cursor_anarapbo!=null)
            Cursor_anarapbo.Close();
          Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_anarapbo.Eof())) {
            /* _flagrap := anarapbo->TIPORAP */
            _flagrap = Cursor_anarapbo.GetString("TIPORAP");
            Cursor_anarapbo.Next();
          }
          m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
          Cursor_anarapbo.Close();
          // * --- End Select
          /* _flagrap := iif(Empty(LRTrim(_flagrap)),qbe_oped_chkdiana->FLAGRAP,_flagrap) */
          _flagrap = (CPLib.Empty(CPLib.LRTrim(_flagrap))?Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"):_flagrap);
          /* _datage := arfn_datidip_sol(qbe_oped_chkdiana->CODDIPE,qbe_oped_chkdiana->CODCAB,qbe_oped_chkdiana->DESCCIT,qbe_oped_chkdiana->PROVINCIA) */
          _datage = arfn_datidip_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("CODDIPE"),Cursor_qbe_oped_chkdiana.GetString("CODCAB"),Cursor_qbe_oped_chkdiana.GetString("DESCCIT"),Cursor_qbe_oped_chkdiana.GetString("PROVINCIA"));
          /* _tipoag := Right(_datage,10) */
          _tipoag = CPLib.Right(_datage,10);
          /* _note := _note + Left(_datage,44) */
          _note = _note+CPLib.Left(_datage,44);
          /* _note := _note + Left(DateToChar(qbe_oped_chkdiana->DATAOPE)+Space(8),8) + Left(LRTrim(qbe_oped_chkdiana->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_oped_chkdiana->FLAGCONT)+" ",1) */
          _note = _note+CPLib.Left(CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGCONT"))+" ",1);
          /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CODANA)+Space(4),4) + Left(LRTrim(qbe_oped_chkdiana->CODVOC)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CODVOC"))+CPLib.Space(2),2);
          /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->TIPOINT2)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("TIPOINT2"))+CPLib.Space(2),2);
          /* _note := _note + iif(Empty(LRTrim(qbe_oped_chkdiana->CODFISCICP)),Left(LRTrim(qbe_oped_chkdiana->CODINT2)+Space(11),11),Left(LRTrim(qbe_oped_chkdiana->CODFISCICP)+Space(11),11)) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CODFISCICP")))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CODINT2"))+CPLib.Space(11),11):CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CODFISCICP"))+CPLib.Space(11),11));
          /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->PAESE)+Space(3),3) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("PAESE"))+CPLib.Space(3),3);
          /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CODCAB2)+Space(6),6) + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->DESC2,' '))+Space(30),30) + Left(LRTrim(qbe_oped_chkdiana->PROV2)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("DESC2")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("PROV2"))+CPLib.Space(2),2);
          /* _note := _note + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->DESCINTER,' '))+Space(50),50) + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->RAPPORTO,' '))+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
          _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("DESCINTER")," "))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO")," "))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
          /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_oped_chkdiana->DATAREG))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATAREG")))+CPLib.Space(8),8);
          /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_oped_chkdiana->COLLEG)+Space(12),12) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("COLLEG"))+CPLib.Space(12),12);
          /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->STATOREG)+" ",1)  */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("STATOREG"))+" ",1);
          /* If Empty(qbe_oped_chkdiana->DATARETT) or DateToChar(qbe_oped_chkdiana->DATARETT)='01000101' */
          if (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATARETT")),"01000101")) {
            /* _note := _note + Space(8) */
            _note = _note+CPLib.Space(8);
          } else { // Else
            /* _note := _note + Left(LRTrim(DateToChar(qbe_oped_chkdiana->DATARETT))+Space(8),8) */
            _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_oped_chkdiana.GetDate("DATARETT")))+CPLib.Space(8),8);
          } // End If
          /* _note := _note + iif(Empty(LRTrim(qbe_oped_chkdiana->OPERAZMOD)),Space(20),Left(qbe_oped_chkdiana->OPERAZMOD,8)+"O"+Right(qbe_oped_chkdiana->OPERAZMOD,11)) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_oped_chkdiana.GetString("OPERAZMOD"),8)+"O"+CPLib.Right(Cursor_qbe_oped_chkdiana.GetString("OPERAZMOD"),11));
          /* _note := _note + arfn_flaglire(qbe_oped_chkdiana->FLAGLIRE,qbe_oped_chkdiana->DATAOPE) + Left(LRTrim(qbe_oped_chkdiana->VALUTA)+Space(3),3) + Left(LRTrim(qbe_oped_chkdiana->SEGNO)+" ",1) */
          _note = _note+arfn_flaglireR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("FLAGLIRE"),Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("SEGNO"))+" ",1);
          /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_oped_chkdiana->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_oped_chkdiana->TOTCONT,15,0)),15) + Space(59)+Left(LRTrim(_tipoag)+Space(10),10) */
          _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_oped_chkdiana.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_oped_chkdiana.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(59)+CPLib.Left(CPLib.LRTrim(_tipoag)+CPLib.Space(10),10);
          /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
          FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nTotReg := nTotReg + 1 */
          nTotReg = CPLib.Round(nTotReg+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
          /* If not(Empty(qbe_oped_chkdiana->CONNESCLI)) */
          if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESCLI")))) {
            /* _oldrap := '' */
            _oldrap = "";
            /* _codrif := qbe_oped_chkdiana->CONNESCLI */
            _codrif = Cursor_qbe_oped_chkdiana.GetString("CONNESCLI");
            /* If gFlgWU='S' and not(Empty(LRTrim(qbe_oped_chkdiana->CONNESDOC))) */
            if (CPLib.eqr(gFlgWU,"S") &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CONNESDOC"))))) {
              // * --- Select from kersonbo
              m_cServer = m_Ctx.GetServer("kersonbo");
              m_cPhName = m_Ctx.GetPhName("kersonbo");
              if (Cursor_kersonbo!=null)
                Cursor_kersonbo.Close();
              Cursor_kersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("CONNESDOC"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("kersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_kersonbo.Eof())) {
                /* _ramate := iif(w_flgrae='R',LRTrim(kersonbo->RAMOGRUP),Left(LRTrim(kersonbo->ATTIV),3)) */
                _ramate = (CPLib.eqr(w_flgrae,"R")?CPLib.LRTrim(Cursor_kersonbo.GetString("RAMOGRUP")):CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("ATTIV")),3));
                /* If qbe_oped_chkdiana->DATAOPE > CharToDate('20131231') */
                if (CPLib.gt(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '7' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
                } else { // Else
                  /* If Empty(qbe_oped_chkdiana->CONNESOPER) or (qbe_oped_chkdiana->CONNESOPER=qbe_oped_chkdiana->CONNESCLI) */
                  if (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),Cursor_qbe_oped_chkdiana.GetString("CONNESCLI")))) {
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+ '2'+_idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"2"+_idereg;
                  } else { // Else
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '3' + _idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"3"+_idereg;
                  } // End If
                } // End If
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CONNESCLI)+Space(16),16) + Left(LRTrim(kersonbo->RAGSOC)+Space(70),70) + Left(LRTrim(kersonbo->PAESE)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CONNESCLI"))+CPLib.Space(16),16)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("RAGSOC"))+CPLib.Space(70),70)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PAESE"))+CPLib.Space(3),3);
                /* _note := _note + Left(LRTrim(kersonbo->CODCAB)+Space(6),6) + Left(LRTrim(kersonbo->DESCCIT)+Space(30),30) + Left(LRTrim(kersonbo->PROVINCIA)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODCAB"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DESCCIT"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(kersonbo->DOMICILIO)+Space(35),35) + Left(LRTrim(kersonbo->CAP)+ Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("DOMICILIO"))+CPLib.Space(35),35)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CAP"))+CPLib.Space(5),5);
                /* _note := _note + iif(kersonbo->CFESTERO=1,Space(16),Left(LRTrim(kersonbo->CODFISC)+Space(16),16)) */
                _note = _note+(CPLib.eqr(Cursor_kersonbo.GetDouble("CFESTERO"),1)?CPLib.Space(16):CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CODFISC"))+CPLib.Space(16),16));
                /* If Empty(kersonbo->DATANASC) or DateToChar(kersonbo->DATANASC)='01000101' */
                if (CPLib.Empty(Cursor_kersonbo.GetDate("DATANASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATANASC))+Space(8),8) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC")))+CPLib.Space(8),8);
                } // End If
                /* If not(Empty(kersonbo->NASSTATO)) */
                if ( ! (CPLib.Empty(Cursor_kersonbo.GetString("NASSTATO")))) {
                  /* _note := _note + Left(LRTrim(kersonbo->NASSTATO)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate)+Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASSTATO"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
                } else { // Else
                  /* _note := _note + Left(LRTrim(kersonbo->NASCOMUN)+Space(30),30) + Left(LRTrim(kersonbo->SOTGRUP)+Space(3),3) + Left(LRTrim(_ramate) +Space(3),3) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NASCOMUN"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SOTGRUP"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(_ramate)+CPLib.Space(3),3);
                } // End If
                /* _note := _note + Left(LRTrim(kersonbo->SETTSINT)+Space(3),3) + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->RAPPORTO,' '))+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SETTSINT"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO")," "))+CPLib.Space(25),25);
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->FLAGRAP)+" ",1) + Left(LRTrim(kersonbo->TIPODOC)+Space(2),2) + Left(LRTrim(kersonbo->NUMDOCUM)+Space(15),15) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("TIPODOC"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("NUMDOCUM"))+CPLib.Space(15),15);
                /* If Empty(kersonbo->DATARILASC) or DateToChar(kersonbo->DATARILASC)='01000101' */
                if (CPLib.Empty(Cursor_kersonbo.GetDate("DATARILASC")) || CPLib.eqr(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")),"01000101")) {
                  /* _note := _note + Space(8) */
                  _note = _note+CPLib.Space(8);
                } else { // Else
                  /* _note := _note + Left(LRTrim(DateToChar(kersonbo->DATARILASC))+Space(8),8)  */
                  _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_kersonbo.GetDate("DATARILASC")))+CPLib.Space(8),8);
                } // End If
                /* _note := _note + Left(LRTrim(kersonbo->AUTRILASC)+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("AUTRILASC"))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(kersonbo->SESSO)+" ",1) + Space(34) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("SESSO"))+" ",1)+CPLib.Space(34);
                /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_kersonbo.Next();
              }
              m_cConnectivityError = Cursor_kersonbo.ErrorMessage();
              Cursor_kersonbo.Close();
              // * --- End Select
            } else { // Else
              /* If qbe_oped_chkdiana->DATAOPE > CharToDate('20131231') */
              if (CPLib.gt(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '7' + _idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
              } else { // Else
                /* If Empty(qbe_oped_chkdiana->CONNESOPER) or (qbe_oped_chkdiana->CONNESOPER=qbe_oped_chkdiana->CONNESCLI) */
                if (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),Cursor_qbe_oped_chkdiana.GetString("CONNESCLI")))) {
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '2' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"2"+_idereg;
                } else { // Else
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '3' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"3"+_idereg;
                } // End If
              } // End If
              /* _note := _note + LRTrim(arfn_datisog_sol(qbe_oped_chkdiana->CONNESCLI,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'2',_raeatc,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("CONNESCLI"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"2",_raeatc,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } // End If
          } // End If
          /* If not(Empty(qbe_oped_chkdiana->RAPPORTO)) */
          if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO")))) {
            /* _oldrap := '' */
            _oldrap = "";
            // * --- Read from knarapbo
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"));
            if (m_Ctx.IsSharedTemp("knarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _oldrap = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_dlgspecifici returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _oldrap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(_oldrap)) */
            if ( ! (CPLib.Empty(_oldrap))) {
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* If qbe_oped_chkdiana->RAPPORTO = intestbo->RAPPORTO */
                if (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_intestbo.GetString("RAPPORTO"))) {
                  /* _avanza := 0 */
                  _avanza = CPLib.Round(0,0);
                  /* If Empty(intestbo->CODINTER) or intestbo->STATOREG='2' or intestbo->STATOREG='3' */
                  if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"3")) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If intestbo->DATAINI > qbe_oped_chkdiana->DATAOPE */
                  if (CPLib.gt(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE < qbe_oped_chkdiana->DATAOPE */
                  if ( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"))) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If intestbo->CODINTER=qbe_oped_chkdiana->CONNESCLI */
                  if (CPLib.eqr(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_oped_chkdiana.GetString("CONNESCLI"))) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If _avanza = 0 */
                  if (CPLib.eqr(_avanza,0)) {
                    /* _codrif := intestbo->CODINTER */
                    _codrif = Cursor_intestbo.GetString("CODINTER");
                    /* If qbe_oped_chkdiana->DATAOPE > CharToDate('20131231') */
                    if (CPLib.gt(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                      /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '7' + _idereg */
                      _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
                    } else { // Else
                      /* If Empty(qbe_oped_chkdiana->CONNESOPER) or (qbe_oped_chkdiana->CONNESOPER=intestbo->CODINTER) */
                      if (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),Cursor_intestbo.GetString("CODINTER")))) {
                        /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '2' + _idereg */
                        _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"2"+_idereg;
                      } else { // Else
                        /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '3' + _idereg */
                        _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"3"+_idereg;
                      } // End If
                    } // End If
                    /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'2',_raeatc,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"2",_raeatc,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
                    /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                    FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                  } // End If
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
            } // End If
          } // End If
          /* If Empty(LRTrim(_oldrap)) */
          if (CPLib.Empty(CPLib.LRTrim(_oldrap))) {
            /* _oldrighe := 0 */
            _oldrighe = CPLib.Round(0,0);
            /* If qbe_oped_chkdiana->STATOREG='3' */
            if (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("STATOREG"),"3")) {
              /* _oldrighe := 0 */
              _oldrighe = CPLib.Round(0,0);
              // * --- Select from mlientiope
              m_cServer = m_Ctx.GetServer("mlientiope");
              m_cPhName = m_Ctx.GetPhName("mlientiope");
              if (Cursor_mlientiope!=null)
                Cursor_mlientiope.Close();
              Cursor_mlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_mlientiope.Eof())) {
                /* If mlientiope->CODSOG <> qbe_oped_chkdiana->CONNESCLI */
                if (CPLib.ne(Cursor_mlientiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetString("CONNESCLI"))) {
                  /* _oldrighe := 1 */
                  _oldrighe = CPLib.Round(1,0);
                  /* If qbe_oped_chkdiana->DATAOPE > CharToDate('20131231') */
                  if (CPLib.gt(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '7' + _idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
                  } else { // Else
                    /* If Empty(qbe_oped_chkdiana->CONNESOPER) or (qbe_oped_chkdiana->CONNESOPER=mlientiope->CODSOG) */
                    if (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),Cursor_mlientiope.GetString("CODSOG")))) {
                      /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+ '2' + _idereg */
                      _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"2"+_idereg;
                    } else { // Else
                      /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '3' + _idereg */
                      _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"3"+_idereg;
                    } // End If
                  } // End If
                  /* _note := _note + LRTrim(arfn_datisog_sol(mlientiope->CODSOG,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'2',_raeatc,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_mlientiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"2",_raeatc,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
                  /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                  FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
                Cursor_mlientiope.Next();
              }
              m_cConnectivityError = Cursor_mlientiope.ErrorMessage();
              Cursor_mlientiope.Close();
              // * --- End Select
            } // End If
            /* If _oldrighe=0 */
            if (CPLib.eqr(_oldrighe,0)) {
              // * --- Select from clientiope
              m_cServer = m_Ctx.GetServer("clientiope");
              m_cPhName = m_Ctx.GetPhName("clientiope");
              if (Cursor_clientiope!=null)
                Cursor_clientiope.Close();
              Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_clientiope.Eof())) {
                /* _rownum := 0 */
                _rownum = CPLib.Round(0,0);
                // * --- Read from intestbo
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_cSql = "";
                m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"));
                m_cSql = m_cSql+" and CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"C",16,0,m_cServer),m_cServer,Cursor_clientiope.GetString("CODSOG"));
                if (m_Ctx.IsSharedTemp("intestbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _rownum = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on intestbo into routine arrt_dlgspecifici returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _rownum = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If _rownum = 0 */
                if (CPLib.eqr(_rownum,0)) {
                  /* If clientiope->CODSOG <> qbe_oped_chkdiana->CONNESCLI */
                  if (CPLib.ne(Cursor_clientiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetString("CONNESCLI"))) {
                    /* If qbe_oped_chkdiana->DATAOPE > CharToDate('20131231') */
                    if (CPLib.gt(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                      /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '7' + _idereg */
                      _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
                    } else { // Else
                      /* If Empty(qbe_oped_chkdiana->CONNESOPER) or (qbe_oped_chkdiana->CONNESOPER=clientiope->CODSOG) */
                      if (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),Cursor_clientiope.GetString("CODSOG")))) {
                        /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '2' + _idereg */
                        _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"2"+_idereg;
                      } else { // Else
                        /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '3' + _idereg */
                        _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"3"+_idereg;
                      } // End If
                    } // End If
                    /* _note := _note + LRTrim(arfn_datisog_sol(clientiope->CODSOG,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'2',_raeatc,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_clientiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"2",_raeatc,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
                    /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                    FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                  } // End If
                } // End If
                Cursor_clientiope.Next();
              }
              m_cConnectivityError = Cursor_clientiope.ErrorMessage();
              Cursor_clientiope.Close();
              // * --- End Select
            } // End If
          } // End If
          /* If not(Empty(qbe_oped_chkdiana->CONNESOPER)) and qbe_oped_chkdiana->CONNESOPER <> _codrif */
          if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),_codrif)) {
            /* If qbe_oped_chkdiana->DATAOPE > CharToDate('20131231') */
            if (CPLib.gt(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'8' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"8"+_idereg;
            } else { // Else
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'4' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"4"+_idereg;
            } // End If
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_oped_chkdiana->CONNESOPER,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'4',_raeatc,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"4",_raeatc,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
          /* _oldrighe := 0 */
          _oldrighe = CPLib.Round(0,0);
          /* If qbe_oped_chkdiana->STATOREG='3' */
          if (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("STATOREG"),"3")) {
            // * --- Select from mogopebo
            m_cServer = m_Ctx.GetServer("mogopebo");
            m_cPhName = m_Ctx.GetPhName("mogopebo");
            if (Cursor_mogopebo!=null)
              Cursor_mogopebo.Close();
            Cursor_mogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_mogopebo.Eof())) {
              /* If mogopebo->CODSOG <> qbe_oped_chkdiana->CONNESOPER */
              if (CPLib.ne(Cursor_mogopebo.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"))) {
                /* _oldrighe := 1 */
                _oldrighe = CPLib.Round(1,0);
                /* If qbe_oped_chkdiana->DATAOPE > CharToDate('20131231') */
                if (CPLib.gt(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '8' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"8"+_idereg;
                } else { // Else
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '4' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"4"+_idereg;
                } // End If
                /* _note := _note + LRTrim(arfn_datisog_sol(mogopebo->CODSOG,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'4',_raeatc,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_mogopebo.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"4",_raeatc,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
                /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
              Cursor_mogopebo.Next();
            }
            m_cConnectivityError = Cursor_mogopebo.ErrorMessage();
            Cursor_mogopebo.Close();
            // * --- End Select
          } // End If
          /* If _oldrighe=0 */
          if (CPLib.eqr(_oldrighe,0)) {
            // * --- Select from sogopebo
            m_cServer = m_Ctx.GetServer("sogopebo");
            m_cPhName = m_Ctx.GetPhName("sogopebo");
            if (Cursor_sogopebo!=null)
              Cursor_sogopebo.Close();
            Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopebo.Eof())) {
              /* If sogopebo->CODSOG <> qbe_oped_chkdiana->CONNESOPER */
              if (CPLib.ne(Cursor_sogopebo.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"))) {
                /* If qbe_oped_chkdiana->DATAOPE > CharToDate('20131231') */
                if (CPLib.gt(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '8' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"8"+_idereg;
                } else { // Else
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '4' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"4"+_idereg;
                } // End If
                /* _note := _note + LRTrim(arfn_datisog_sol(sogopebo->CODSOG,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'4',_raeatc,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_sogopebo.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"4",_raeatc,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
                /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
              Cursor_sogopebo.Next();
            }
            m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
            Cursor_sogopebo.Close();
            // * --- End Select
          } // End If
          /* If not(Empty(qbe_oped_chkdiana->CONNESBEN)) or not(Empty(qbe_oped_chkdiana->C_RAG)) */
          if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"))) ||  ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("C_RAG")))) {
            /* If not(Empty(qbe_oped_chkdiana->C_RAG)) */
            if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("C_RAG")))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
              /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CONNESBEN)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
              /* _note := _note +Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_RAG,' '))+Space(70),70) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_RAG")," "))+CPLib.Space(70),70);
              /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->C_STA)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_STA"))+CPLib.Space(3),3);
              /* _note := _note +Left(LRTrim(qbe_oped_chkdiana->C_CAB)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6);
              /* _note := _note +Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_CTA,' '))+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_CTA")," "))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->C_PRV)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_IND,' '))+Space(35),35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_IND")," "))+CPLib.Space(35),35);
              /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->C_CAP)+Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5);
              /* _note := _note + Space(63) */
              _note = _note+CPLib.Space(63);
              /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->C_RAPPORTO)+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
              /* _note := _note + Space(91) */
              _note = _note+CPLib.Space(91);
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              /* ElseIf not(Empty(qbe_oped_chkdiana->CONNESBEN)) */
            } else if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN")))) {
              /* _numsto := arfn_chkspers(qbe_oped_chkdiana->CONNESBEN,qbe_oped_chkdiana->DATAREG) */
              _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"));
              /* If Empty(LRTrim(_numsto)) */
              if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CONNESBEN)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_RAG))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_STA))),Left(LRTrim(qbe_oped_chkdiana->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_CAB))),Left(LRTrim(qbe_oped_chkdiana->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_CTA))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_PRV))),Left(LRTrim(qbe_oped_chkdiana->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_IND))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_CAP))),Left(LRTrim(qbe_oped_chkdiana->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_RAPPORTO))),Left(LRTrim(qbe_oped_chkdiana->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_oped_chkdiana->RAPPORTBEN)+Space(25),25)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                  FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                  /* _note := _note + Left(LRTrim(qbe_oped_chkdiana->CONNESBEN)+Space(16),16) */
                  _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"))+CPLib.Space(16),16);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_RAG))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_STA))),Left(LRTrim(qbe_oped_chkdiana->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_CAB))),Left(LRTrim(qbe_oped_chkdiana->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_CTA))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_PRV))),Left(LRTrim(qbe_oped_chkdiana->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_IND))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_CAP))),Left(LRTrim(qbe_oped_chkdiana->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                  /* _note := _note + Space(63) */
                  _note = _note+CPLib.Space(63);
                  /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana->C_RAPPORTO))),Left(LRTrim(qbe_oped_chkdiana->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_oped_chkdiana->RAPPORTBEN)+Space(25),25)) */
                  _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                  /* _note := _note + Space(91) */
                  _note = _note+CPLib.Space(91);
                  /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                  FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
            } // End If
          } // End If
          /* _oldrighe := 0 */
          _oldrighe = CPLib.Round(0,0);
          /* If qbe_oped_chkdiana->STATOREG='3' */
          if (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("STATOREG"),"3")) {
            // * --- Select from meneficope
            m_cServer = m_Ctx.GetServer("meneficope");
            m_cPhName = m_Ctx.GetPhName("meneficope");
            if (Cursor_meneficope!=null)
              Cursor_meneficope.Close();
            Cursor_meneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("meneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_meneficope.Eof())) {
              /* _oldrighe := 1 */
              _oldrighe = CPLib.Round(1,0);
              /* If Empty(LRTrim(meneficope->CODSOG)) and not(Empty(LRTrim(meneficope->C_RAG))) */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAG"))))) {
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                /* _note := _note + Left(LRTrim(meneficope->CODSOG)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                /* _note := _note +Left(LRTrim(arfn_agechar(meneficope->C_RAG,' '))+Space(70),70) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_RAG")," "))+CPLib.Space(70),70);
                /* _note := _note + Left(LRTrim(meneficope->C_STA)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))+CPLib.Space(3),3);
                /* _note := _note +Left(LRTrim(meneficope->C_CAB)+Space(6),6) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))+CPLib.Space(6),6);
                /* _note := _note +Left(LRTrim(arfn_agechar(meneficope->C_CTA,' '))+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_CTA")," "))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(meneficope->C_PRV)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(arfn_agechar(meneficope->C_IND,' '))+Space(35),35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_IND")," "))+CPLib.Space(35),35);
                /* _note := _note + Left(LRTrim(meneficope->C_CAP)+Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))+CPLib.Space(5),5);
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + Left(LRTrim(meneficope->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } else { // Else
                /* If meneficope->CODSOG <> qbe_oped_chkdiana->CONNESBEN */
                if (CPLib.ne(Cursor_meneficope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"))) {
                  /* _numsto := arfn_chkspers(meneficope->CODSOG,qbe_oped_chkdiana->DATAREG) */
                  _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"));
                  /* If Empty(LRTrim(_numsto)) */
                  if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                    // * --- Select from personbo
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_meneficope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_personbo.Eof())) {
                      /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                      _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                      /* _note := _note + Left(LRTrim(meneficope->CODSOG)+Space(16),16) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                      /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_RAG))),Left(LRTrim(arfn_agechar(meneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                      /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_STA))),Left(LRTrim(meneficope->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                      /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAB))),Left(LRTrim(meneficope->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                      /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CTA))),Left(LRTrim(arfn_agechar(meneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                      /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_PRV))),Left(LRTrim(meneficope->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                      /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_IND))),Left(LRTrim(arfn_agechar(meneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                      /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAP))),Left(LRTrim(meneficope->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                      /* _note := _note + Space(63) */
                      _note = _note+CPLib.Space(63);
                      /* _note := _note +Left(LRTrim(meneficope->C_RAPPORTO)+Space(25),25) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                      /* _note := _note + Space(91) */
                      _note = _note+CPLib.Space(91);
                      /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                      FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                      Cursor_personbo.Next();
                    }
                    m_cConnectivityError = Cursor_personbo.ErrorMessage();
                    Cursor_personbo.Close();
                    // * --- End Select
                  } else { // Else
                    // * --- Select from wersonbo
                    m_cServer = m_Ctx.GetServer("wersonbo");
                    m_cPhName = m_Ctx.GetPhName("wersonbo");
                    if (Cursor_wersonbo!=null)
                      Cursor_wersonbo.Close();
                    Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_wersonbo.Eof())) {
                      /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                      _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                      /* _note := _note + Left(LRTrim(meneficope->CODSOG)+Space(16),16) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                      /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_RAG))),Left(LRTrim(arfn_agechar(meneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                      /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_STA))),Left(LRTrim(meneficope->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                      /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAB))),Left(LRTrim(meneficope->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                      /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CTA))),Left(LRTrim(arfn_agechar(meneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                      /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_PRV))),Left(LRTrim(meneficope->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                      /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_IND))),Left(LRTrim(arfn_agechar(meneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                      /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAP))),Left(LRTrim(meneficope->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                      /* _note := _note + Space(63) */
                      _note = _note+CPLib.Space(63);
                      /* _note := _note +Left(LRTrim(meneficope->C_RAPPORTO)+Space(25),25) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                      /* _note := _note + Space(91) */
                      _note = _note+CPLib.Space(91);
                      /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                      FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                      Cursor_wersonbo.Next();
                    }
                    m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                    Cursor_wersonbo.Close();
                    // * --- End Select
                  } // End If
                } // End If
              } // End If
              Cursor_meneficope.Next();
            }
            m_cConnectivityError = Cursor_meneficope.ErrorMessage();
            Cursor_meneficope.Close();
            // * --- End Select
          } // End If
          /* If _oldrighe=0 */
          if (CPLib.eqr(_oldrighe,0)) {
            // * --- Select from beneficope
            m_cServer = m_Ctx.GetServer("beneficope");
            m_cPhName = m_Ctx.GetPhName("beneficope");
            if (Cursor_beneficope!=null)
              Cursor_beneficope.Close();
            Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_beneficope.Eof())) {
              /* If Empty(LRTrim(beneficope->CODSOG)) and not(Empty(LRTrim(beneficope->C_RAG))) */
              if (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAG"))))) {
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                /* _note := _note + Left(LRTrim(beneficope->CODSOG)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                /* _note := _note +Left(LRTrim(arfn_agechar(beneficope->C_RAG,' '))+Space(70),70) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_RAG")," "))+CPLib.Space(70),70);
                /* _note := _note + Left(LRTrim(beneficope->C_STA)+Space(3),3) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))+CPLib.Space(3),3);
                /* _note := _note +Left(LRTrim(beneficope->C_CAB)+Space(6),6) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))+CPLib.Space(6),6);
                /* _note := _note +Left(LRTrim(arfn_agechar(beneficope->C_CTA,' '))+Space(30),30) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_CTA")," "))+CPLib.Space(30),30);
                /* _note := _note + Left(LRTrim(beneficope->C_PRV)+Space(2),2) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))+CPLib.Space(2),2);
                /* _note := _note + Left(LRTrim(arfn_agechar(beneficope->C_IND,' '))+Space(35),35) */
                _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_IND")," "))+CPLib.Space(35),35);
                /* _note := _note + Left(LRTrim(beneficope->C_CAP)+Space(5),5) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))+CPLib.Space(5),5);
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + Left(LRTrim(beneficope->C_RAPPORTO)+Space(25),25) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } else { // Else
                /* If beneficope->CODSOG <> qbe_oped_chkdiana->CONNESBEN */
                if (CPLib.ne(Cursor_beneficope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetString("CONNESBEN"))) {
                  /* _numsto := arfn_chkspers(beneficope->CODSOG,qbe_oped_chkdiana->DATAREG) */
                  _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"));
                  /* If Empty(LRTrim(_numsto)) */
                  if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                    // * --- Select from personbo
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_beneficope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_personbo.Eof())) {
                      /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                      _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                      /* _note := _note + Left(LRTrim(beneficope->CODSOG)+Space(16),16) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                      /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_RAG))),Left(LRTrim(arfn_agechar(beneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                      /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_STA))),Left(LRTrim(beneficope->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                      /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAB))),Left(LRTrim(beneficope->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                      /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CTA))),Left(LRTrim(arfn_agechar(beneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                      /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_PRV))),Left(LRTrim(beneficope->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                      /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_IND))),Left(LRTrim(arfn_agechar(beneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                      /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAP))),Left(LRTrim(beneficope->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                      /* _note := _note + Space(63) */
                      _note = _note+CPLib.Space(63);
                      /* _note := _note +Left(LRTrim(beneficope->C_RAPPORTO)+Space(25),25) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                      /* _note := _note + Space(91) */
                      _note = _note+CPLib.Space(91);
                      /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                      FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                      Cursor_personbo.Next();
                    }
                    m_cConnectivityError = Cursor_personbo.ErrorMessage();
                    Cursor_personbo.Close();
                    // * --- End Select
                  } else { // Else
                    // * --- Select from wersonbo
                    m_cServer = m_Ctx.GetServer("wersonbo");
                    m_cPhName = m_Ctx.GetPhName("wersonbo");
                    if (Cursor_wersonbo!=null)
                      Cursor_wersonbo.Close();
                    Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_wersonbo.Eof())) {
                      /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                      _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                      /* _note := _note + Left(LRTrim(beneficope->CODSOG)+Space(16),16) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                      /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_RAG))),Left(LRTrim(arfn_agechar(beneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                      /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_STA))),Left(LRTrim(beneficope->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                      /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAB))),Left(LRTrim(beneficope->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                      /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CTA))),Left(LRTrim(arfn_agechar(beneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                      /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_PRV))),Left(LRTrim(beneficope->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                      /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_IND))),Left(LRTrim(arfn_agechar(beneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                      /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAP))),Left(LRTrim(beneficope->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                      _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                      /* _note := _note + Space(63) */
                      _note = _note+CPLib.Space(63);
                      /* _note := _note +Left(LRTrim(beneficope->C_RAPPORTO)+Space(25),25) */
                      _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                      /* _note := _note + Space(91) */
                      _note = _note+CPLib.Space(91);
                      /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                      FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                      /* nTotRec := nTotRec + 1 */
                      nTotRec = CPLib.Round(nTotRec+1,0);
                      /* nNumRec := nNumRec + 1 */
                      nNumRec = CPLib.Round(nNumRec+1,0);
                      Cursor_wersonbo.Next();
                    }
                    m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                    Cursor_wersonbo.Close();
                    // * --- End Select
                  } // End If
                } // End If
              } // End If
              Cursor_beneficope.Next();
            }
            m_cConnectivityError = Cursor_beneficope.ErrorMessage();
            Cursor_beneficope.Close();
            // * --- End Select
          } // End If
          /* If not(Empty(qbe_oped_chkdiana->CONNALTRO)) */
          if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNALTRO")))) {
            /* If qbe_oped_chkdiana->DATAOPE > CharToDate('20131231') */
            if (CPLib.gt(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '9' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"9"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(qbe_oped_chkdiana->CONNALTRO,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'9',_raeatc,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("CONNALTRO"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"9",_raeatc,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
            } else { // Else
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '6' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"6"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(qbe_oped_chkdiana->CONNALTRO,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'6',_raeatc,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("CONNALTRO"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"6",_raeatc,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
            } // End If
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
          /* _oldrighe := 0 */
          _oldrighe = CPLib.Round(0,0);
          /* If qbe_oped_chkdiana->STATOREG='3' */
          if (CPLib.eqr(Cursor_qbe_oped_chkdiana.GetString("STATOREG"),"3")) {
            // * --- Select from merzistiope
            m_cServer = m_Ctx.GetServer("merzistiope");
            m_cPhName = m_Ctx.GetPhName("merzistiope");
            if (Cursor_merzistiope!=null)
              Cursor_merzistiope.Close();
            Cursor_merzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("merzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_merzistiope.Eof())) {
              /* If merzistiope->CODSOG <> qbe_oped_chkdiana->CONNALTRO */
              if (CPLib.ne(Cursor_merzistiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetString("CONNALTRO"))) {
                /* If qbe_oped_chkdiana->DATAOPE > CharToDate('20131231') */
                if (CPLib.gt(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '9' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"9"+_idereg;
                } else { // Else
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '6' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"6"+_idereg;
                } // End If
                /* _note := _note + LRTrim(arfn_datisog_sol(merzistiope->CODSOG,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'6',_raeatc,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_merzistiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"6",_raeatc,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
                /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
              Cursor_merzistiope.Next();
            }
            m_cConnectivityError = Cursor_merzistiope.ErrorMessage();
            Cursor_merzistiope.Close();
            // * --- End Select
          } // End If
          /* If _oldrighe=0 */
          if (CPLib.eqr(_oldrighe,0)) {
            // * --- Select from terzistiope
            m_cServer = m_Ctx.GetServer("terzistiope");
            m_cPhName = m_Ctx.GetPhName("terzistiope");
            if (Cursor_terzistiope!=null)
              Cursor_terzistiope.Close();
            Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_terzistiope.Eof())) {
              /* If terzistiope->CODSOG <> qbe_oped_chkdiana->CONNALTRO */
              if (CPLib.ne(Cursor_terzistiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetString("CONNALTRO"))) {
                /* If qbe_oped_chkdiana->DATAOPE > CharToDate('20131231') */
                if (CPLib.gt(Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '9' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"9"+_idereg;
                  /* _note := _note + LRTrim(arfn_datisog_sol(terzistiope->CODSOG,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'9',_raeatc,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_terzistiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"9",_raeatc,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
                } else { // Else
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '6' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"6"+_idereg;
                  /* _note := _note + LRTrim(arfn_datisog_sol(terzistiope->CODSOG,qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->RAPPORTO,qbe_oped_chkdiana->FLAGRAP,'6',_raeatc,qbe_oped_chkdiana->STATOREG,qbe_oped_chkdiana->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_terzistiope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana.GetDate("DATAREG"),Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana.GetString("FLAGRAP"),"6",_raeatc,Cursor_qbe_oped_chkdiana.GetString("STATOREG"),Cursor_qbe_oped_chkdiana.GetDate("DATARETT")));
                } // End If
                /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
              Cursor_terzistiope.Next();
            }
            m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
            Cursor_terzistiope.Close();
            // * --- End Select
          } // End If
          Cursor_qbe_oped_chkdiana.Next();
        }
        m_cConnectivityError = Cursor_qbe_oped_chkdiana.ErrorMessage();
        Cursor_qbe_oped_chkdiana.Close();
        // * --- End Select
        /* gNumRec := nTotRec // N° Record DIANA */
        gNumRec = CPLib.Round(nTotRec,0);
        m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
        /* gNumReg := nTotReg // N° Registrazioni DIANA */
        gNumReg = CPLib.Round(nTotReg,0);
        m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_oped_chkdiana_limits!=null)
          Cursor_qbe_oped_chkdiana_limits.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_oped_chkdiana!=null)
          Cursor_qbe_oped_chkdiana.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_kersonbo!=null)
          Cursor_kersonbo.Close();
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
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_mlientiope!=null)
          Cursor_mlientiope.Close();
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
        if (Cursor_mogopebo!=null)
          Cursor_mogopebo.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_meneficope!=null)
          Cursor_meneficope.Close();
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
        if (Cursor_merzistiope!=null)
          Cursor_merzistiope.Close();
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
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_rapd_chkdiana_min_max=null;
    CPResultSet Cursor_qbe_rapd_chkdiana=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_fiduciabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle informazioni sui rapporti */
      /* _conta := _conta + 1 */
      _conta = CPLib.Round(_conta+1,0);
      /* w_cdadata_rap := '' */
      w_cdadata_rap = "";
      /* w_c_adata_rap := '' */
      w_c_adata_rap = "";
      /* _contacilci := 0 */
      _contacilci = CPLib.Round(0,0);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _ciclo := 0 */
      _ciclo = CPLib.Round(0,0);
      /* Prima gli italiani */
      /* _contacilci := 0 */
      _contacilci = CPLib.Round(0,0);
      // * --- Select from qbe_rapd_chkdiana_min_max
      if (Cursor_qbe_rapd_chkdiana_min_max!=null)
        Cursor_qbe_rapd_chkdiana_min_max.Close();
      Cursor_qbe_rapd_chkdiana_min_max = new VQRHolder("qbe_rapd_chkdiana_min_max",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_rapd_chkdiana_min_max.Eof())) {
        /* _min := qbe_rapd_chkdiana_min_max->MININF */
        _min = CPLib.Round(Cursor_qbe_rapd_chkdiana_min_max.GetDouble("MININF"),0);
        /* _max := qbe_rapd_chkdiana_min_max->MAXINF */
        _max = CPLib.Round(Cursor_qbe_rapd_chkdiana_min_max.GetDouble("MAXINF"),0);
        Cursor_qbe_rapd_chkdiana_min_max.Next();
      }
      m_cConnectivityError = Cursor_qbe_rapd_chkdiana_min_max.ErrorMessage();
      Cursor_qbe_rapd_chkdiana_min_max.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      /* _bottom := _min */
      _bottom = CPLib.Round(_min,0);
      /* If _min > 5000 */
      if (CPLib.gt(_min,5000)) {
        /* _contacilci := Int(_min/5000) + 1 */
        _contacilci = CPLib.Round(CPLib.Int(_min/5000)+1,0);
      } else { // Else
        /* _contacilci := 1 */
        _contacilci = CPLib.Round(1,0);
      } // End If
      /* gMsgImp := 'Lettura informazioni in corso ...' // Messaggio Import */
      gMsgImp = "Lettura informazioni in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* While _contacilci<=_cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* _bottom := iif(_ciclo=0,_bottom,((_contacilci -1 ) * 5000) + 1) */
        _bottom = CPLib.Round((CPLib.eqr(_ciclo,0)?_bottom:((_contacilci-1)*5000)+1),0);
        /* _top := _contacilci * 5000 */
        _top = CPLib.Round(_contacilci*5000,0);
        /* _ciclo := 1 */
        _ciclo = CPLib.Round(1,0);
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* gMsgImp := 'Lettura informazioni in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura informazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Cicla sulle operazioni */
        // * --- Select from qbe_rapd_chkdiana
        if (Cursor_qbe_rapd_chkdiana!=null)
          Cursor_qbe_rapd_chkdiana.Close();
        Cursor_qbe_rapd_chkdiana = new VQRHolder("qbe_rapd_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_rapd_chkdiana.Eof())) {
          /* _continua := 0 */
          _continua = CPLib.Round(0,0);
          /* If qbe_rapd_chkdiana->DATAOPE <  CharToDate('20100601') */
          if (CPLib.lt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20100601"))) {
            /* _raeatc := 'R' */
            _raeatc = "R";
            /* ElseIf qbe_rapd_chkdiana->DATAOPE >  CharToDate('20131231') */
          } else if (CPLib.gt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
            /* _raeatc := 'A' */
            _raeatc = "A";
          } else { // Else
            /* _raeatc := w_flgrae */
            _raeatc = w_flgrae;
          } // End If
          /* _continua := 1 */
          _continua = CPLib.Round(1,0);
          /* If _continua=1 */
          if (CPLib.eqr(_continua,1)) {
            /* _ctotale := _ctotale + 1 */
            _ctotale = CPLib.Round(_ctotale+1,0);
            /* gMsgImp := 'Elaborazione Informazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
            gMsgImp = "Elaborazione Informazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _idereg := arfn_calc_idereg("I",qbe_rapd_chkdiana->NUMPROG,qbe_rapd_chkdiana->IDEREG) */
            _idereg = arfn_calc_ideregR.Make(m_Ctx,this).Run("I",Cursor_qbe_rapd_chkdiana.GetString("NUMPROG"),Cursor_qbe_rapd_chkdiana.GetString("IDEREG"));
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '1' + _idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"1"+_idereg;
            /* _flagrap := '' */
            _flagrap = "";
            /* If not(Empty(qbe_rapd_chkdiana->FLAGRAP)) */
            if ( ! (CPLib.Empty(Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP")))) {
              /* _flagrap := qbe_rapd_chkdiana->FLAGRAP */
              _flagrap = Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP");
            } else { // Else
              // * --- Select from anarapbo
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              if (Cursor_anarapbo!=null)
                Cursor_anarapbo.Close();
              Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TIPORAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_anarapbo.Eof())) {
                /* _flagrap := anarapbo->TIPORAP */
                _flagrap = Cursor_anarapbo.GetString("TIPORAP");
                Cursor_anarapbo.Next();
              }
              m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
              Cursor_anarapbo.Close();
              // * --- End Select
            } // End If
            /* _datage := arfn_datidip_sol(qbe_rapd_chkdiana->CODDIPE,qbe_rapd_chkdiana->CODCAB,qbe_rapd_chkdiana->DESCCIT,qbe_rapd_chkdiana->PROVINCIA) */
            _datage = arfn_datidip_solR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana.GetString("CODDIPE"),Cursor_qbe_rapd_chkdiana.GetString("CODCAB"),Cursor_qbe_rapd_chkdiana.GetString("DESCCIT"),Cursor_qbe_rapd_chkdiana.GetString("PROVINCIA"));
            /* _tipoag := Right(_datage,10) */
            _tipoag = CPLib.Right(_datage,10);
            /* _note := _note + Left(_datage,44) */
            _note = _note+CPLib.Left(_datage,44);
            /* _note := _note + Left(LRTrim(DateToChar(qbe_rapd_chkdiana->DATAOPE))+Space(8),8) + Left(LRTrim(qbe_rapd_chkdiana->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_rapd_chkdiana->FLAGCONT)+" ",1) */
            _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE")))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("FLAGCONT"))+" ",1);
            /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->CODANA)+Space(4),4) + Left(LRTrim(qbe_rapd_chkdiana->CODVOC)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("CODVOC"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->TIPOINT2)+Space(2),2) + Left(LRTrim(qbe_rapd_chkdiana->CODINT2)+Space(11),11) + Left(LRTrim(qbe_rapd_chkdiana->PAESE)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("TIPOINT2"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("CODINT2"))+CPLib.Space(11),11)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("PAESE"))+CPLib.Space(3),3);
            /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->CODCAB2)+Space(6),6) + Left(LRTrim(qbe_rapd_chkdiana->DESC2)+Space(30),30) + Left(LRTrim(qbe_rapd_chkdiana->PROV2)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("DESC2"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("PROV2"))+CPLib.Space(2),2);
            /* _note := _note + Space(50) + Left(LRTrim(qbe_rapd_chkdiana->RAPPORTO)+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
            _note = _note+CPLib.Space(50)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
            /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_rapd_chkdiana->DATAREG))+Space(8),8) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana.GetDate("DATAREG")))+CPLib.Space(8),8);
            /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_rapd_chkdiana->COLLEG)+Space(12),12) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("COLLEG"))+CPLib.Space(12),12);
            /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana->STATOREG)+" ",1)  */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("STATOREG"))+" ",1);
            /* If Empty(qbe_rapd_chkdiana->DATARETT) or DateToChar(qbe_rapd_chkdiana->DATARETT)='01000101' */
            if (CPLib.Empty(Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")),"01000101")) {
              /* _note := _note + Space(8) */
              _note = _note+CPLib.Space(8);
            } else { // Else
              /* _note := _note + Left(LRTrim(DateToChar(qbe_rapd_chkdiana->DATARETT))+Space(8),8) */
              _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")))+CPLib.Space(8),8);
            } // End If
            /* If Left(qbe_rapd_chkdiana->OPERAZMOD,1)='I' */
            if (CPLib.eqr(CPLib.Left(Cursor_qbe_rapd_chkdiana.GetString("OPERAZMOD"),1),"I")) {
              /* _note := _note + iif(Empty(LRTrim(qbe_rapd_chkdiana->OPERAZMOD)),Space(20),qbe_rapd_chkdiana->OPERAZMOD) */
              _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("OPERAZMOD")))?CPLib.Space(20):Cursor_qbe_rapd_chkdiana.GetString("OPERAZMOD"));
            } else { // Else
              /* _note := _note + iif(Empty(LRTrim(qbe_rapd_chkdiana->OPERAZMOD)),Space(20),Left(qbe_rapd_chkdiana->OPERAZMOD,8)+"I"+Right(qbe_rapd_chkdiana->OPERAZMOD,11)) */
              _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_rapd_chkdiana.GetString("OPERAZMOD"),8)+"I"+CPLib.Right(Cursor_qbe_rapd_chkdiana.GetString("OPERAZMOD"),11));
            } // End If
            /* _note := _note + arfn_flaglire(qbe_rapd_chkdiana->RAPLIRE,qbe_rapd_chkdiana->DATAOPE) + Left(LRTrim(qbe_rapd_chkdiana->RAPVALUTA)+Space(3),3) + Left(LRTrim(qbe_rapd_chkdiana->SEGNO)+" ",1) */
            _note = _note+arfn_flaglireR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana.GetString("RAPLIRE"),Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"))+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("RAPVALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana.GetString("SEGNO"))+" ",1);
            /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_rapd_chkdiana->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_rapd_chkdiana->TOTCONT,15,0)),15) + Space(59)+Left(LRTrim(_tipoag)+Space(10),10) */
            _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_rapd_chkdiana.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_rapd_chkdiana.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(59)+CPLib.Left(CPLib.LRTrim(_tipoag)+CPLib.Space(10),10);
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nTotReg := nTotReg + 1 */
            nTotReg = CPLib.Round(nTotReg+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            /* Case qbe_rapd_chkdiana->TIPOOPRAP='25' or qbe_rapd_chkdiana->TIPOOPRAP='28' */
            if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"28")) {
              /* If qbe_rapd_chkdiana->TIPOOPRAP='25' */
              if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"25")) {
                // * --- Select from intestbo
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                if (Cursor_intestbo!=null)
                  Cursor_intestbo.Close();
                Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_intestbo.Eof())) {
                  /* If intestbo->DATAINI <= qbe_rapd_chkdiana->DATAOPE and (intestbo->DATAFINE >= qbe_rapd_chkdiana->DATAOPE or Empty(intestbo->DATAFINE)) */
                  if (CPLib.le(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE")) && (CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE")) || CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")))) {
                    /* If qbe_rapd_chkdiana->DATAOPE > CharToDate('20131231') */
                    if (CPLib.gt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                      /* _tiprec := '7' */
                      _tiprec = "7";
                    } else { // Else
                      /* _tiprec := '2' */
                      _tiprec = "2";
                    } // End If
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
                    /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                    /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                    FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                  } // End If
                  Cursor_intestbo.Next();
                }
                m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                Cursor_intestbo.Close();
                // * --- End Select
                // * --- Select from delegabo
                m_cServer = m_Ctx.GetServer("delegabo");
                m_cPhName = m_Ctx.GetPhName("delegabo");
                if (Cursor_delegabo!=null)
                  Cursor_delegabo.Close();
                Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_delegabo.Eof())) {
                  /* _avanza := 0 */
                  _avanza = CPLib.Round(0,0);
                  /* If Empty(delegabo->CODINTER) */
                  if (CPLib.Empty(Cursor_delegabo.GetString("CODINTER"))) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If _avanza=0 */
                  if (CPLib.eqr(_avanza,0)) {
                    /* If qbe_rapd_chkdiana->DATAOPE > CharToDate('20131231') */
                    if (CPLib.gt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                      /* _tiprec := '8' */
                      _tiprec = "8";
                    } else { // Else
                      /* _tiprec := '4' */
                      _tiprec = "4";
                    } // End If
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
                    /* _note := _note + LRTrim(arfn_datisog_sol(delegabo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                    /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                    FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                  } // End If
                  Cursor_delegabo.Next();
                }
                m_cConnectivityError = Cursor_delegabo.ErrorMessage();
                Cursor_delegabo.Close();
                // * --- End Select
              } else { // Else
                // * --- Select from intestbo
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                if (Cursor_intestbo!=null)
                  Cursor_intestbo.Close();
                Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_intestbo.Eof())) {
                  /* If intestbo->DATAINI <= qbe_rapd_chkdiana->DATAOPE and (intestbo->DATAFINE >= qbe_rapd_chkdiana->DATAOPE or Empty(intestbo->DATAFINE)) */
                  if (CPLib.le(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE")) && (CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE")) || CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")))) {
                    /* If qbe_rapd_chkdiana->DATAOPE > CharToDate('20131231') */
                    if (CPLib.gt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                      /* _tiprec := '7' */
                      _tiprec = "7";
                    } else { // Else
                      /* _tiprec := '2' */
                      _tiprec = "2";
                    } // End If
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
                    /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                    /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                    FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                  } // End If
                  Cursor_intestbo.Next();
                }
                m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                Cursor_intestbo.Close();
                // * --- End Select
                // * --- Select from delegabo
                m_cServer = m_Ctx.GetServer("delegabo");
                m_cPhName = m_Ctx.GetPhName("delegabo");
                if (Cursor_delegabo!=null)
                  Cursor_delegabo.Close();
                Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_delegabo.Eof())) {
                  /* _avanza := 0 */
                  _avanza = CPLib.Round(0,0);
                  /* If Empty(delegabo->CODINTER) */
                  if (CPLib.Empty(Cursor_delegabo.GetString("CODINTER"))) {
                    /* _avanza := 1 */
                    _avanza = CPLib.Round(1,0);
                  } // End If
                  /* If _avanza=0 */
                  if (CPLib.eqr(_avanza,0)) {
                    /* If qbe_rapd_chkdiana->DATAOPE > CharToDate('20131231') */
                    if (CPLib.gt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                      /* _tiprec := '8' */
                      _tiprec = "8";
                    } else { // Else
                      /* _tiprec := '4' */
                      _tiprec = "4";
                    } // End If
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
                    /* _note := _note + LRTrim(arfn_datisog_sol(delegabo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                    /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                    FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                  } // End If
                  Cursor_delegabo.Next();
                }
                m_cConnectivityError = Cursor_delegabo.ErrorMessage();
                Cursor_delegabo.Close();
                // * --- End Select
              } // End If
              /* Case Right(qbe_rapd_chkdiana->TIPOOPRAP,1)='6' or qbe_rapd_chkdiana->TIPOOPRAP='38' */
            } else if (CPLib.eqr(CPLib.Right(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),1),"6") || CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"38")) {
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(intestbo->CODINTER) */
                if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* If qbe_rapd_chkdiana->DATAOPE > CharToDate('20131231') */
                  if (CPLib.gt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                    /* _tiprec := '7' */
                    _tiprec = "7";
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'7'+_idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
                  } else { // Else
                    /* If qbe_rapd_chkdiana->DATAOPE > CharToDate('20100531') and qbe_rapd_chkdiana->DATAOPE < CharToDate('20140101') */
                    if (CPLib.gt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20100531")) && CPLib.lt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20140101"))) {
                      /* _tiprec := '2' */
                      _tiprec = "2";
                    } else { // Else
                      /* If Empty(qbe_rapd_chkdiana->CONNESOPER) or (qbe_rapd_chkdiana->CONNESOPER=intestbo->CODINTER) */
                      if (CPLib.Empty(Cursor_qbe_rapd_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("CONNESOPER"),Cursor_intestbo.GetString("CODINTER")))) {
                        /* _tiprec := '2' */
                        _tiprec = "2";
                      } else { // Else
                        /* _tiprec := '3' */
                        _tiprec = "3";
                      } // End If
                    } // End If
                  } // End If
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + _tiprec + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
                  /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                  /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                  FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
              /* If not(Empty(qbe_rapd_chkdiana->CONNESOPER)) */
              if ( ! (CPLib.Empty(Cursor_qbe_rapd_chkdiana.GetString("CONNESOPER")))) {
                /* If qbe_rapd_chkdiana->DATAOPE > CharToDate('20131231') */
                if (CPLib.gt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                  /* _tiprec := '8' */
                  _tiprec = "8";
                } else { // Else
                  /* _tiprec := '4' */
                  _tiprec = "4";
                } // End If
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
                /* _note := _note + LRTrim(arfn_datisog_sol(qbe_rapd_chkdiana->CONNESOPER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana.GetString("CONNESOPER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                /* FileLibMit.Write(fhand,_note+NL) */
                FileLibMit.Write(fhand,_note+"\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
              // * --- Select from fiduciabo
              m_cServer = m_Ctx.GetServer("fiduciabo");
              m_cPhName = m_Ctx.GetPhName("fiduciabo");
              if (Cursor_fiduciabo!=null)
                Cursor_fiduciabo.Close();
              Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_fiduciabo.Eof())) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(fiduciabo->CODSOG) */
                if (CPLib.Empty(Cursor_fiduciabo.GetString("CODSOG"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'9'+_idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"9"+_idereg;
                  /* _note := _note + LRTrim(arfn_datisog_sol(fiduciabo->CODSOG,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,'9',_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_fiduciabo.GetString("CODSOG"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),"9",_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                  /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                  FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
                Cursor_fiduciabo.Next();
              }
              m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
              Cursor_fiduciabo.Close();
              // * --- End Select
              /* Case qbe_rapd_chkdiana->TIPOOPRAP='31' or qbe_rapd_chkdiana->TIPOOPRAP='32' */
            } else if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"31") || CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"32")) {
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(intestbo->CODINTER) */
                if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* If qbe_rapd_chkdiana->DATAOPE > CharToDate('20131231') */
                  if (CPLib.gt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                    /* _tiprec := '7' */
                    _tiprec = "7";
                  } else { // Else
                    /* If qbe_rapd_chkdiana->DATAOPE > CharToDate('20100531') and qbe_rapd_chkdiana->DATAOPE < CharToDate('20140101') */
                    if (CPLib.gt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20100531")) && CPLib.lt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20140101"))) {
                      /* _tiprec := '2' */
                      _tiprec = "2";
                    } else { // Else
                      /* If Empty(qbe_rapd_chkdiana->CONNESOPER) or (qbe_rapd_chkdiana->CONNESOPER=intestbo->CODINTER) */
                      if (CPLib.Empty(Cursor_qbe_rapd_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("CONNESOPER"),Cursor_intestbo.GetString("CODINTER")))) {
                        /* _tiprec := '2' */
                        _tiprec = "2";
                      } else { // Else
                        /* _tiprec := '3' */
                        _tiprec = "3";
                      } // End If
                    } // End If
                  } // End If
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
                  /* If qbe_rapd_chkdiana->TIPOOPRAP='31' */
                  if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"31")) {
                    /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,arfn_dateminus(qbe_rapd_chkdiana->DATAREG,1),qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),1),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                    /* ElseIf qbe_rapd_chkdiana->TIPOOPRAP='32' */
                  } else if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"32")) {
                    /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                  } // End If
                  /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                  FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
              // * --- Select from delegabo
              m_cServer = m_Ctx.GetServer("delegabo");
              m_cPhName = m_Ctx.GetPhName("delegabo");
              if (Cursor_delegabo!=null)
                Cursor_delegabo.Close();
              Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_delegabo.Eof())) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(delegabo->CODINTER) */
                if (CPLib.Empty(Cursor_delegabo.GetString("CODINTER"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* If qbe_rapd_chkdiana->DATAOPE > CharToDate('20131231') */
                  if (CPLib.gt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                    /* _tiprec := '8' */
                    _tiprec = "8";
                  } else { // Else
                    /* _tiprec := '4' */
                    _tiprec = "4";
                  } // End If
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
                  /* If qbe_rapd_chkdiana->TIPOOPRAP='31' */
                  if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"31")) {
                    /* _note := _note + LRTrim(arfn_datisog_sol(delegabo->CODINTER,arfn_dateminus(qbe_rapd_chkdiana->DATAREG,1),qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),1),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                    /* ElseIf qbe_rapd_chkdiana->TIPOOPRAP='32' */
                  } else if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"32")) {
                    /* _note := _note + LRTrim(arfn_datisog_sol(delegabo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                  } // End If
                  /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                  FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
                Cursor_delegabo.Next();
              }
              m_cConnectivityError = Cursor_delegabo.ErrorMessage();
              Cursor_delegabo.Close();
              // * --- End Select
              /* If not(Empty(qbe_rapd_chkdiana->CONNESOPER)) */
              if ( ! (CPLib.Empty(Cursor_qbe_rapd_chkdiana.GetString("CONNESOPER")))) {
                /* If qbe_rapd_chkdiana->DATAOPE > CharToDate('20131231') */
                if (CPLib.gt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                  /* _tiprec := '8' */
                  _tiprec = "8";
                } else { // Else
                  /* _tiprec := '4' */
                  _tiprec = "4";
                } // End If
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
                /* _note := _note + LRTrim(arfn_datisog_sol(qbe_rapd_chkdiana->CONNESOPER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana.GetString("CONNESOPER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                /* FileLibMit.Write(fhand,_note+NL) */
                FileLibMit.Write(fhand,_note+"\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
              // * --- Select from fiduciabo
              m_cServer = m_Ctx.GetServer("fiduciabo");
              m_cPhName = m_Ctx.GetPhName("fiduciabo");
              if (Cursor_fiduciabo!=null)
                Cursor_fiduciabo.Close();
              Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_fiduciabo.Eof())) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(fiduciabo->CODSOG) */
                if (CPLib.Empty(Cursor_fiduciabo.GetString("CODSOG"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'9'+_idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"9"+_idereg;
                  /* If qbe_rapd_chkdiana->TIPOOPRAP='31' */
                  if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"31")) {
                    /* _note := _note + LRTrim(arfn_datisog_sol(fiduciabo->CODSOG,arfn_dateminus(qbe_rapd_chkdiana->DATAREG,1),qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,'9',_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_fiduciabo.GetString("CODSOG"),arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),1),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),"9",_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                    /* ElseIf qbe_rapd_chkdiana->TIPOOPRAP='32' */
                  } else if (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("TIPOOPRAP"),"32")) {
                    /* _note := _note + LRTrim(arfn_datisog_sol(fiduciabo->CODSOG,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,'9',_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_fiduciabo.GetString("CODSOG"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),"9",_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                  } // End If
                  /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                  FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
                Cursor_fiduciabo.Next();
              }
              m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
              Cursor_fiduciabo.Close();
              // * --- End Select
            } else { // Otherwise
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(intestbo->CODINTER) */
                if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* If qbe_rapd_chkdiana->DATAOPE > CharToDate('20131231') */
                  if (CPLib.gt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                    /* _tiprec := '7' */
                    _tiprec = "7";
                  } else { // Else
                    /* If qbe_rapd_chkdiana->DATAOPE > CharToDate('20100531') and qbe_rapd_chkdiana->DATAOPE < CharToDate('20140101') */
                    if (CPLib.gt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20100531")) && CPLib.lt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20140101"))) {
                      /* _tiprec := '2' */
                      _tiprec = "2";
                    } else { // Else
                      /* If Empty(qbe_rapd_chkdiana->CONNESOPER) or (qbe_rapd_chkdiana->CONNESOPER=intestbo->CODINTER) */
                      if (CPLib.Empty(Cursor_qbe_rapd_chkdiana.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_rapd_chkdiana.GetString("CONNESOPER"),Cursor_intestbo.GetString("CODINTER")))) {
                        /* _tiprec := '2' */
                        _tiprec = "2";
                      } else { // Else
                        /* _tiprec := '3' */
                        _tiprec = "3";
                      } // End If
                    } // End If
                  } // End If
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
                  /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                  /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                  FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
              /* If not(Empty(qbe_rapd_chkdiana->CONNESOPER)) */
              if ( ! (CPLib.Empty(Cursor_qbe_rapd_chkdiana.GetString("CONNESOPER")))) {
                /* If qbe_rapd_chkdiana->DATAOPE > CharToDate('20131231') */
                if (CPLib.gt(Cursor_qbe_rapd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                  /* _tiprec := '8' */
                  _tiprec = "8";
                } else { // Else
                  /* _tiprec := '4' */
                  _tiprec = "4";
                } // End If
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
                /* _note := _note + LRTrim(arfn_datisog_sol(qbe_rapd_chkdiana->CONNESOPER,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana.GetString("CONNESOPER"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                /* FileLibMit.Write(fhand,_note+NL) */
                FileLibMit.Write(fhand,_note+"\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
              // * --- Select from fiduciabo
              m_cServer = m_Ctx.GetServer("fiduciabo");
              m_cPhName = m_Ctx.GetPhName("fiduciabo");
              if (Cursor_fiduciabo!=null)
                Cursor_fiduciabo.Close();
              Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_fiduciabo.Eof())) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(fiduciabo->CODSOG) */
                if (CPLib.Empty(Cursor_fiduciabo.GetString("CODSOG"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'9'+_idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"9"+_idereg;
                  /* _note := _note + LRTrim(arfn_datisog_sol(fiduciabo->CODSOG,qbe_rapd_chkdiana->DATAREG,qbe_rapd_chkdiana->RAPPORTO,qbe_rapd_chkdiana->FLAGRAP,'9',_raeatc,qbe_rapd_chkdiana->STATOREG,qbe_rapd_chkdiana->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_fiduciabo.GetString("CODSOG"),Cursor_qbe_rapd_chkdiana.GetDate("DATAREG"),Cursor_qbe_rapd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana.GetString("FLAGRAP"),"9",_raeatc,Cursor_qbe_rapd_chkdiana.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana.GetDate("DATARETT")));
                  /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                  FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
                Cursor_fiduciabo.Next();
              }
              m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
              Cursor_fiduciabo.Close();
              // * --- End Select
            } // End Case
          } // End If
          Cursor_qbe_rapd_chkdiana.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapd_chkdiana.ErrorMessage();
        Cursor_qbe_rapd_chkdiana.Close();
        // * --- End Select
        /* gNumRec := nTotRec // N° Record DIANA */
        gNumRec = CPLib.Round(nTotRec,0);
        m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
        /* gNumReg := nTotReg // N° Registrazioni DIANA */
        gNumReg = CPLib.Round(nTotReg,0);
        m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_rapd_chkdiana_min_max!=null)
          Cursor_qbe_rapd_chkdiana_min_max.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rapd_chkdiana!=null)
          Cursor_qbe_rapd_chkdiana.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
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
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fiduciabo!=null)
          Cursor_fiduciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_titd_chkdiana=null;
    CPResultSet Cursor_intestit=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Titolari Effettivi */
      /* _conta := _conta + 1 */
      _conta = CPLib.Round(_conta+1,0);
      /* w_cdadata_rap := '' */
      w_cdadata_rap = "";
      /* w_c_adata_rap := '' */
      w_c_adata_rap = "";
      // * --- Select from qbe_titd_chkdiana
      if (Cursor_qbe_titd_chkdiana!=null)
        Cursor_qbe_titd_chkdiana.Close();
      Cursor_qbe_titd_chkdiana = new VQRHolder("qbe_titd_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_titd_chkdiana.Eof())) {
        /* _continua := 0 */
        _continua = CPLib.Round(0,0);
        /* If qbe_titd_chkdiana->DATAOPE <  CharToDate('20100601') */
        if (CPLib.lt(Cursor_qbe_titd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20100601"))) {
          /* _raeatc := 'R' */
          _raeatc = "R";
          /* ElseIf qbe_titd_chkdiana->DATAOPE >  CharToDate('20131231') */
        } else if (CPLib.gt(Cursor_qbe_titd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
          /* _raeatc := 'A' */
          _raeatc = "A";
        } else { // Else
          /* _raeatc := w_flgrae */
          _raeatc = w_flgrae;
        } // End If
        /* _continua := 1 */
        _continua = CPLib.Round(1,0);
        /* If _continua=1 */
        if (CPLib.eqr(_continua,1)) {
          /* _ctotale := _ctotale + 1 */
          _ctotale = CPLib.Round(_ctotale+1,0);
          /* gMsgImp := 'Elaborazione Informazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
          gMsgImp = "Elaborazione Informazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _idereg := arfn_calc_idereg("T",qbe_titd_chkdiana->NUMPROG,qbe_titd_chkdiana->IDEREG) */
          _idereg = arfn_calc_ideregR.Make(m_Ctx,this).Run("T",Cursor_qbe_titd_chkdiana.GetString("NUMPROG"),Cursor_qbe_titd_chkdiana.GetString("IDEREG"));
          /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '1' + _idereg */
          _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"1"+_idereg;
          /* _datage := arfn_datidip_sol(qbe_titd_chkdiana->CODDIPE,qbe_titd_chkdiana->CODCAB,qbe_titd_chkdiana->DESCCIT,qbe_titd_chkdiana->PROVINCIA) */
          _datage = arfn_datidip_solR.Make(m_Ctx,this).Run(Cursor_qbe_titd_chkdiana.GetString("CODDIPE"),Cursor_qbe_titd_chkdiana.GetString("CODCAB"),Cursor_qbe_titd_chkdiana.GetString("DESCCIT"),Cursor_qbe_titd_chkdiana.GetString("PROVINCIA"));
          /* _tipoag := Right(_datage,10) */
          _tipoag = CPLib.Right(_datage,10);
          /* _note := _note + Left(_datage,44) */
          _note = _note+CPLib.Left(_datage,44);
          /* _note := _note + Left(DateToChar(qbe_titd_chkdiana->DATAOPE)+Space(8),8) + Left(LRTrim(qbe_titd_chkdiana->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_titd_chkdiana->FLAGCONT)+" ",1) */
          _note = _note+CPLib.Left(CPLib.DateToChar(Cursor_qbe_titd_chkdiana.GetDate("DATAOPE"))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("FLAGCONT"))+" ",1);
          /* _note := _note + Left(LRTrim(qbe_titd_chkdiana->CODANA)+Space(4),4) + Left(LRTrim(qbe_titd_chkdiana->CODVOC)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("CODVOC"))+CPLib.Space(2),2);
          /* _note := _note + Left(LRTrim(qbe_titd_chkdiana->TIPOINT2)+Space(2),2) + Left(LRTrim(qbe_titd_chkdiana->CODINT2)+Space(11),11) + Left(LRTrim(qbe_titd_chkdiana->PAESE)+Space(3),3) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("TIPOINT2"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("CODINT2"))+CPLib.Space(11),11)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("PAESE"))+CPLib.Space(3),3);
          /* _note := _note + Left(LRTrim(qbe_titd_chkdiana->CODCAB2)+Space(6),6) + Left(LRTrim(qbe_titd_chkdiana->DESC2)+Space(30),30) + Left(LRTrim(qbe_titd_chkdiana->PROV2)+Space(2),2) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("DESC2"))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("PROV2"))+CPLib.Space(2),2);
          /* _note := _note + Left(LRTrim(qbe_titd_chkdiana->DESCINTER)+Space(50),50) + Left(LRTrim(qbe_titd_chkdiana->RAPPORTO)+Space(25),25) + Left(LRTrim(qbe_titd_chkdiana->FLAGRAP)+" ",1) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("DESCINTER"))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("RAPPORTO"))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("FLAGRAP"))+" ",1);
          /* _note := _note + Left(LRTrim(qbe_titd_chkdiana->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_titd_chkdiana->DATAREG))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_titd_chkdiana.GetDate("DATAREG")))+CPLib.Space(8),8);
          /* _note := _note + Left(LRTrim(qbe_titd_chkdiana->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_titd_chkdiana->COLLEG)+Space(12),12) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("COLLEG"))+CPLib.Space(12),12);
          /* _note := _note + Left(LRTrim(qbe_titd_chkdiana->STATOREG)+" ",1)  */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("STATOREG"))+" ",1);
          /* If Empty(qbe_titd_chkdiana->DATARETT) or DateToChar(qbe_titd_chkdiana->DATARETT)='01000101' */
          if (CPLib.Empty(Cursor_qbe_titd_chkdiana.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_titd_chkdiana.GetDate("DATARETT")),"01000101")) {
            /* _note := _note + Space(8) */
            _note = _note+CPLib.Space(8);
          } else { // Else
            /* _note := _note + Left(LRTrim(DateToChar(qbe_titd_chkdiana->DATARETT))+Space(8),8) */
            _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_titd_chkdiana.GetDate("DATARETT")))+CPLib.Space(8),8);
          } // End If
          /* If Left(qbe_titd_chkdiana->OPERAZMOD,1)='T' */
          if (CPLib.eqr(CPLib.Left(Cursor_qbe_titd_chkdiana.GetString("OPERAZMOD"),1),"T")) {
            /* _note := _note + iif(Empty(LRTrim(qbe_titd_chkdiana->OPERAZMOD)),Space(20),qbe_titd_chkdiana->OPERAZMOD) */
            _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("OPERAZMOD")))?CPLib.Space(20):Cursor_qbe_titd_chkdiana.GetString("OPERAZMOD"));
          } else { // Else
            /* _note := _note + iif(Empty(LRTrim(qbe_titd_chkdiana->OPERAZMOD)),Space(20),Left(qbe_titd_chkdiana->OPERAZMOD,8)+"T"+Right(qbe_titd_chkdiana->OPERAZMOD,11)) */
            _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_titd_chkdiana.GetString("OPERAZMOD"),8)+"T"+CPLib.Right(Cursor_qbe_titd_chkdiana.GetString("OPERAZMOD"),11));
          } // End If
          /* _note := _note + Left(LRTrim(qbe_titd_chkdiana->FLAGLIRE)+" ",1) + Left(LRTrim(qbe_titd_chkdiana->VALUTA)+Space(3),3) + Left(LRTrim(qbe_titd_chkdiana->SEGNO)+" ",1) */
          _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("FLAGLIRE"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_titd_chkdiana.GetString("SEGNO"))+" ",1);
          /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_titd_chkdiana->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_titd_chkdiana->TOTCONT,15,0)),15) + Space(59)+Left(LRTrim(_tipoag)+Space(10),10) */
          _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_titd_chkdiana.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_titd_chkdiana.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(59)+CPLib.Left(CPLib.LRTrim(_tipoag)+CPLib.Space(10),10);
          /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
          FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nTotReg := nTotReg + 1 */
          nTotReg = CPLib.Round(nTotReg+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
          /* If not(Empty(qbe_titd_chkdiana->CONNESCLI)) */
          if ( ! (CPLib.Empty(Cursor_qbe_titd_chkdiana.GetString("CONNESCLI")))) {
            /* If qbe_titd_chkdiana->DATAOPE > CharToDate('20131231') */
            if (CPLib.gt(Cursor_qbe_titd_chkdiana.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
              /* If qbe_titd_chkdiana->TIPOLEG='5' */
              if (CPLib.eqr(Cursor_qbe_titd_chkdiana.GetString("TIPOLEG"),"5")) {
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'7'+_idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
                /* _tiprec := '7' */
                _tiprec = "7";
              } else { // Else
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'9'+_idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"9"+_idereg;
                /* _tiprec := '9' */
                _tiprec = "9";
              } // End If
            } else { // Else
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'2'+_idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"2"+_idereg;
              /* _tiprec := '2' */
              _tiprec = "2";
            } // End If
            /* If qbe_titd_chkdiana->TIPOOPRAP='54' */
            if (CPLib.eqr(Cursor_qbe_titd_chkdiana.GetString("TIPOOPRAP"),"54")) {
              /* _note := _note + LRTrim(arfn_datisog_sol(qbe_titd_chkdiana->CONNESCLI,arfn_dateminus(qbe_titd_chkdiana->DATAREG,1),qbe_titd_chkdiana->RAPPORTO,qbe_titd_chkdiana->FLAGRAP,_tiprec,_raeatc,qbe_titd_chkdiana->STATOREG,qbe_titd_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_titd_chkdiana.GetString("CONNESCLI"),arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_titd_chkdiana.GetDate("DATAREG"),1),Cursor_qbe_titd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_titd_chkdiana.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_titd_chkdiana.GetString("STATOREG"),Cursor_qbe_titd_chkdiana.GetDate("DATARETT")));
            } else { // Else
              /* _note := _note + LRTrim(arfn_datisog_sol(qbe_titd_chkdiana->CONNESCLI,qbe_titd_chkdiana->DATAREG,qbe_titd_chkdiana->RAPPORTO,qbe_titd_chkdiana->FLAGRAP,_tiprec,_raeatc,qbe_titd_chkdiana->STATOREG,qbe_titd_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_titd_chkdiana.GetString("CONNESCLI"),Cursor_qbe_titd_chkdiana.GetDate("DATAREG"),Cursor_qbe_titd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_titd_chkdiana.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_titd_chkdiana.GetString("STATOREG"),Cursor_qbe_titd_chkdiana.GetDate("DATARETT")));
            } // End If
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
          /* If qbe_titd_chkdiana->TIPOOPRAP='50' or qbe_titd_chkdiana->TIPOOPRAP='52' */
          if (CPLib.eqr(Cursor_qbe_titd_chkdiana.GetString("TIPOOPRAP"),"50") || CPLib.eqr(Cursor_qbe_titd_chkdiana.GetString("TIPOOPRAP"),"52")) {
            // * --- Select from intestit
            m_cServer = m_Ctx.GetServer("intestit");
            m_cPhName = m_Ctx.GetPhName("intestit");
            if (Cursor_intestit!=null)
              Cursor_intestit.Close();
            Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG1="+CPLib.ToSQL(Cursor_qbe_titd_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestit.Eof())) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'6'+_idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"6"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(intestit->CODINTER,qbe_titd_chkdiana->DATAREG,qbe_titd_chkdiana->RAPPORTO,qbe_titd_chkdiana->FLAGRAP,'6',_raeatc,qbe_titd_chkdiana->STATOREG,qbe_titd_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestit.GetString("CODINTER"),Cursor_qbe_titd_chkdiana.GetDate("DATAREG"),Cursor_qbe_titd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_titd_chkdiana.GetString("FLAGRAP"),"6",_raeatc,Cursor_qbe_titd_chkdiana.GetString("STATOREG"),Cursor_qbe_titd_chkdiana.GetDate("DATARETT")));
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_intestit.Next();
            }
            m_cConnectivityError = Cursor_intestit.ErrorMessage();
            Cursor_intestit.Close();
            // * --- End Select
            /* ElseIf qbe_titd_chkdiana->TIPOOPRAP='51' or qbe_titd_chkdiana->TIPOOPRAP='53' */
          } else if (CPLib.eqr(Cursor_qbe_titd_chkdiana.GetString("TIPOOPRAP"),"51") || CPLib.eqr(Cursor_qbe_titd_chkdiana.GetString("TIPOOPRAP"),"53")) {
            // * --- Select from intestit
            m_cServer = m_Ctx.GetServer("intestit");
            m_cPhName = m_Ctx.GetPhName("intestit");
            if (Cursor_intestit!=null)
              Cursor_intestit.Close();
            Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG2="+CPLib.ToSQL(Cursor_qbe_titd_chkdiana.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestit.Eof())) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'6'+_idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"6"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(intestit->CODINTER,qbe_titd_chkdiana->DATAREG,qbe_titd_chkdiana->RAPPORTO,qbe_titd_chkdiana->FLAGRAP,'6',_raeatc,qbe_titd_chkdiana->STATOREG,qbe_titd_chkdiana->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestit.GetString("CODINTER"),Cursor_qbe_titd_chkdiana.GetDate("DATAREG"),Cursor_qbe_titd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_titd_chkdiana.GetString("FLAGRAP"),"6",_raeatc,Cursor_qbe_titd_chkdiana.GetString("STATOREG"),Cursor_qbe_titd_chkdiana.GetDate("DATARETT")));
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_intestit.Next();
            }
            m_cConnectivityError = Cursor_intestit.ErrorMessage();
            Cursor_intestit.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from intestit
            m_cServer = m_Ctx.GetServer("intestit");
            m_cPhName = m_Ctx.GetPhName("intestit");
            if (Cursor_intestit!=null)
              Cursor_intestit.Close();
            Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_qbe_titd_chkdiana.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestit.Eof())) {
              /* If intestit->DATAINI <= qbe_titd_chkdiana->DATAOPE and (Empty(intestit->DATAFINE) or (intestit->DATAFINE >= qbe_titd_chkdiana->DATAOPE)) */
              if (CPLib.le(Cursor_intestit.GetDate("DATAINI"),Cursor_qbe_titd_chkdiana.GetDate("DATAOPE")) && (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE")) || (CPLib.ge(Cursor_intestit.GetDate("DATAFINE"),Cursor_qbe_titd_chkdiana.GetDate("DATAOPE"))))) {
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'6'+_idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"6"+_idereg;
                /* If qbe_titd_chkdiana->TIPOOPRAP='54' */
                if (CPLib.eqr(Cursor_qbe_titd_chkdiana.GetString("TIPOOPRAP"),"54")) {
                  /* _note := _note + LRTrim(arfn_datisog_sol(intestit->CODINTER,arfn_dateminus(qbe_titd_chkdiana->DATAREG,1),qbe_titd_chkdiana->RAPPORTO,qbe_titd_chkdiana->FLAGRAP,'6',_raeatc,qbe_titd_chkdiana->STATOREG,qbe_titd_chkdiana->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestit.GetString("CODINTER"),arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_titd_chkdiana.GetDate("DATAREG"),1),Cursor_qbe_titd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_titd_chkdiana.GetString("FLAGRAP"),"6",_raeatc,Cursor_qbe_titd_chkdiana.GetString("STATOREG"),Cursor_qbe_titd_chkdiana.GetDate("DATARETT")));
                } else { // Else
                  /* _note := _note + LRTrim(arfn_datisog_sol(intestit->CODINTER,qbe_titd_chkdiana->DATAREG,qbe_titd_chkdiana->RAPPORTO,qbe_titd_chkdiana->FLAGRAP,'6',_raeatc,qbe_titd_chkdiana->STATOREG,qbe_titd_chkdiana->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestit.GetString("CODINTER"),Cursor_qbe_titd_chkdiana.GetDate("DATAREG"),Cursor_qbe_titd_chkdiana.GetString("RAPPORTO"),Cursor_qbe_titd_chkdiana.GetString("FLAGRAP"),"6",_raeatc,Cursor_qbe_titd_chkdiana.GetString("STATOREG"),Cursor_qbe_titd_chkdiana.GetDate("DATARETT")));
                } // End If
                /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
              } // End If
              Cursor_intestit.Next();
            }
            m_cConnectivityError = Cursor_intestit.ErrorMessage();
            Cursor_intestit.Close();
            // * --- End Select
          } // End If
          /* gNumRec := nTotRec // N° Record DIANA */
          gNumRec = CPLib.Round(nTotRec,0);
          m_Ctx.SetGlobalNumber("gNumRec",gNumRec);
          /* gNumReg := nTotReg // N° Registrazioni DIANA */
          gNumReg = CPLib.Round(nTotReg,0);
          m_Ctx.SetGlobalNumber("gNumReg",gNumReg);
        } // End If
        Cursor_qbe_titd_chkdiana.Next();
      }
      m_cConnectivityError = Cursor_qbe_titd_chkdiana.ErrorMessage();
      Cursor_qbe_titd_chkdiana.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_titd_chkdiana!=null)
          Cursor_qbe_titd_chkdiana.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    // Qui vengono scritti i file da inserire nello zip
        String[] filenames = new String[]{cNomeFile};
        
        // Crea un buffer per la lettura dei file
        byte[] buf = new byte[1024];
        
        try {
            // Creail file ZIP
            String outFilename = cNomeFileZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Comprime i file
            for (int i=0; i<filenames.length; i++) {
                java.io.FileInputStream in = new java.io.FileInputStream(filenames[i]);
        
                // Apre il file da aggiungere allo ZIP
                out.putNextEntry(new java.util.zip.ZipEntry(cOnlyNomeFile));
        
                // Trasferisce i dati da i file allo ZIP
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
        
                // Chiude il file
                out.closeEntry();
                in.close();
            }
        
            // Chiude il file ZIP
            out.close();
        } catch (java.io.IOException e) {
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
      m_Caller.SetString("codinter","C",11,0,w_codinter);
      m_Caller.SetString("tipinter","C",2,0,w_tipinter);
      m_Caller.SetString("flgint","C",1,0,w_flgint);
      m_Caller.SetString("flgrae","C",1,0,w_flgrae);
      m_Caller.SetString("flgsto","C",1,0,w_flgsto);
      m_Caller.SetString("flgdel","C",1,0,w_flgdel);
      m_Caller.SetString("passwd","C",20,0,w_passwd);
      m_Caller.SetString("tipofile","C",1,0,w_tipofile);
      m_Caller.SetNumber("numreg","N",15,0,w_numreg);
      m_Caller.SetNumber("numrec","N",15,0,w_numrec);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_dlgspecificiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_dlgspecificiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_codinter = m_Caller.GetString("codinter","C",11,0);
    w_tipinter = m_Caller.GetString("tipinter","C",2,0);
    w_flgint = m_Caller.GetString("flgint","C",1,0);
    w_flgrae = m_Caller.GetString("flgrae","C",1,0);
    w_flgsto = m_Caller.GetString("flgsto","C",1,0);
    w_flgdel = m_Caller.GetString("flgdel","C",1,0);
    w_passwd = m_Caller.GetString("passwd","C",20,0);
    w_tipofile = m_Caller.GetString("tipofile","C",1,0);
    w_numreg = m_Caller.GetNumber("numreg","N",15,0);
    w_numrec = m_Caller.GetNumber("numrec","N",15,0);
    w_codcab = CPLib.Space(6);
    w_cabcod = CPLib.Space(6);
    w_desccit = CPLib.Space(30);
    w_citdesc = CPLib.Space(30);
    w_provin = CPLib.Space(2);
    w_provind = CPLib.Space(2);
    w_coddipe = CPLib.Space(6);
    _note = "";
    fhand = CPLib.Space(10);
    _nomefile = CPLib.Space(15);
    cNomeFile = CPLib.Space(30);
    cOnlyNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    nTotRec = 0;
    nTotReg = 0;
    nNumRec = 0;
    _avanza = 0;
    _codrif = CPLib.Space(16);
    w_cdadata = CPLib.Space(8);
    w_c_adata = CPLib.Space(8);
    w_cdadata_rap = CPLib.Space(8);
    w_c_adata_rap = CPLib.Space(8);
    _ctotale = 0;
    _conta = 0;
    _max = 0;
    _min = 0;
    _top = 0;
    _bottom = 0;
    _cicli = 0;
    _contacilci = 0;
    _flagrap = CPLib.Space(1);
    _ciclo = 0;
    _ramate = CPLib.Space(3);
    _numsto = CPLib.Space(15);
    _oldrighe = 0;
    _continua = 0;
    _oldrap = CPLib.Space(25);
    _idereg = CPLib.Space(20);
    xStato = CPLib.Space(1);
    _conta1 = 0;
    _conta2 = 0;
    _conta4 = 0;
    _conta5 = 0;
    _conta6 = 0;
    _conta7 = 0;
    _conta8 = 0;
    _conta9 = 0;
    w_codage = CPLib.Space(6);
    w_codcli = CPLib.Space(16);
    w_ragben = CPLib.Space(70);
    _raeatc = CPLib.Space(1);
    _rownum = 0;
    _tiprec = CPLib.Space(1);
    _tipoag = CPLib.Space(10);
    _datage = CPLib.Space(54);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gNumRec=m_Ctx.GetGlobalNumber("gNumRec");
    gNumReg=m_Ctx.GetGlobalNumber("gNumReg");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gFlgWU=m_Ctx.GetGlobalString("gFlgWU");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_oped_chkdiana_limits,qbe_oped_chkdiana,qbe_rapd_chkdiana_min_max,qbe_rapd_chkdiana,qbe_titd_chkdiana,
  public static final String m_cVQRList = ",qbe_oped_chkdiana_limits,qbe_oped_chkdiana,qbe_rapd_chkdiana_min_max,qbe_rapd_chkdiana,qbe_titd_chkdiana,";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_calc_idereg,arfn_chkspers,arfn_dateminus,arfn_datidip_sol,arfn_datisog_sol,arfn_fdatetime,arfn_flaglire,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_calc_idereg,arfn_chkspers,arfn_dateminus,arfn_datidip_sol,arfn_datisog_sol,arfn_fdatetime,arfn_flaglire,";
  public static String[] m_cRunParameterNames={};
}
