// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_import_dbtodbR implements CallerWithObjs {
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
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aeopstor;
  public String m_cServer_aeopstor;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
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
  public String m_cPhName_cpwarn;
  public String m_cServer_cpwarn;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_f_aederig;
  public String m_cServer_f_aederig;
  public String m_cPhName_f_aeoprig;
  public String m_cServer_f_aeoprig;
  public String m_cPhName_f_aerighe;
  public String m_cServer_f_aerighe;
  public String m_cPhName_f_aetesta;
  public String m_cServer_f_aetesta;
  public String m_cPhName_f_anadip;
  public String m_cServer_f_anadip;
  public String m_cPhName_f_anarapbo;
  public String m_cServer_f_anarapbo;
  public String m_cPhName_f_benefic;
  public String m_cServer_f_benefic;
  public String m_cPhName_f_clienti;
  public String m_cServer_f_clienti;
  public String m_cPhName_f_fraziobo;
  public String m_cServer_f_fraziobo;
  public String m_cPhName_f_inter2bo;
  public String m_cServer_f_inter2bo;
  public String m_cPhName_f_intermbo;
  public String m_cServer_f_intermbo;
  public String m_cPhName_f_intestbo;
  public String m_cServer_f_intestbo;
  public String m_cPhName_f_japopebo;
  public String m_cServer_f_japopebo;
  public String m_cPhName_f_jnarapbo;
  public String m_cServer_f_jnarapbo;
  public String m_cPhName_f_jntestbo;
  public String m_cServer_f_jntestbo;
  public String m_cPhName_f_operazbo;
  public String m_cServer_f_operazbo;
  public String m_cPhName_f_opextrbo;
  public String m_cServer_f_opextrbo;
  public String m_cPhName_f_personbo;
  public String m_cServer_f_personbo;
  public String m_cPhName_f_rapopebo;
  public String m_cServer_f_rapopebo;
  public String m_cPhName_f_rapotit;
  public String m_cServer_f_rapotit;
  public String m_cPhName_f_soggetbo;
  public String m_cServer_f_soggetbo;
  public String m_cPhName_f_terzisti;
  public String m_cServer_f_terzisti;
  public String m_cPhName_f_wenefic;
  public String m_cServer_f_wenefic;
  public String m_cPhName_f_werzisti;
  public String m_cServer_f_werzisti;
  public String m_cPhName_f_wlienti;
  public String m_cServer_f_wlienti;
  public String m_cPhName_f_woggetbo;
  public String m_cServer_f_woggetbo;
  public String m_cPhName_f_wperazbo;
  public String m_cServer_f_wperazbo;
  public String m_cPhName_f_wraziobo;
  public String m_cServer_f_wraziobo;
  public String m_cPhName_f_xapopebo;
  public String m_cServer_f_xapopebo;
  public String m_cPhName_f_xapotit;
  public String m_cServer_f_xapotit;
  public String m_cPhName_f_xenefic;
  public String m_cServer_f_xenefic;
  public String m_cPhName_f_xerzisti;
  public String m_cServer_f_xerzisti;
  public String m_cPhName_f_xlienti;
  public String m_cServer_f_xlienti;
  public String m_cPhName_f_xnarapbo;
  public String m_cServer_f_xnarapbo;
  public String m_cPhName_f_xntestbo;
  public String m_cServer_f_xntestbo;
  public String m_cPhName_f_xoggetbo;
  public String m_cServer_f_xoggetbo;
  public String m_cPhName_f_xperazbo;
  public String m_cServer_f_xperazbo;
  public String m_cPhName_f_xraziobo;
  public String m_cServer_f_xraziobo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_joginfo;
  public String m_cServer_joginfo;
  public String m_cPhName_jogopebo;
  public String m_cServer_jogopebo;
  public String m_cPhName_jperazbo;
  public String m_cServer_jperazbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
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
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_titolabo;
  public String m_cServer_titolabo;
  public String m_cPhName_titopers;
  public String m_cServer_titopers;
  public String m_cPhName_weneficfrz;
  public String m_cServer_weneficfrz;
  public String m_cPhName_weneficope;
  public String m_cServer_weneficope;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_werzistifrz;
  public String m_cServer_werzistifrz;
  public String m_cPhName_werzistiope;
  public String m_cServer_werzistiope;
  public String m_cPhName_wlientifrz;
  public String m_cServer_wlientifrz;
  public String m_cPhName_wlientiope;
  public String m_cServer_wlientiope;
  public String m_cPhName_wogopebo;
  public String m_cServer_wogopebo;
  public String m_cPhName_wogopefbo;
  public String m_cServer_wogopefbo;
  public String m_cPhName_wperazbo;
  public String m_cServer_wperazbo;
  public String m_cPhName_wraziobo;
  public String m_cServer_wraziobo;
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
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xoginfo;
  public String m_cServer_xoginfo;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_f_aesaldi;
  public String m_cServer_f_aesaldi;
  public String m_cPhName_f_aeannora;
  public String m_cServer_f_aeannora;
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_f_aestor;
  public String m_cServer_f_aestor;
  public String m_cPhName_f_aedestor;
  public String m_cServer_f_aedestor;
  public String m_cPhName_aedestor;
  public String m_cServer_aedestor;
  public String m_cPhName_f_aedecanc;
  public String m_cServer_f_aedecanc;
  public String m_cPhName_aedecanc;
  public String m_cServer_aedecanc;
  public String m_cPhName_f_aeinvio;
  public String m_cServer_f_aeinvio;
  public String m_cPhName_aeinvio;
  public String m_cServer_aeinvio;
  public String m_cPhName_aesaldi;
  public String m_cServer_aesaldi;
  public String m_cPhName_f_wersonbo;
  public String m_cServer_f_wersonbo;
  public String m_cPhName_f_inttitbo;
  public String m_cServer_f_inttitbo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_f_xnttitbo;
  public String m_cServer_f_xnttitbo;
  public String m_cPhName_xntestit;
  public String m_cServer_xntestit;
  public String m_cPhName_f_delegabo;
  public String m_cServer_f_delegabo;
  public String m_cPhName_f_garantbo;
  public String m_cServer_f_garantbo;
  public String m_cPhName_garantbo;
  public String m_cServer_garantbo;
  public String m_cPhName_db_intermbo;
  public String m_cServer_db_intermbo;
  public String m_cPhName_db_anadip;
  public String m_cServer_db_anadip;
  public String m_cPhName_db_personbo;
  public String m_cServer_db_personbo;
  public String m_cPhName_db_wersonbo;
  public String m_cServer_db_wersonbo;
  public String m_cPhName_db_opextrbo;
  public String m_cServer_db_opextrbo;
  public String m_cPhName_db_fraziobo;
  public String m_cServer_db_fraziobo;
  public String m_cPhName_db_cpwarn;
  public String m_cServer_db_cpwarn;
  public String m_cPhName_db_operazbo;
  public String m_cServer_db_operazbo;
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
  public String pOper;
  public String pFlg;
  public String w_msgproc;
  public double conta;
  public String cSNAS;
  public String cCNAS;
  public String _tipper;
  public double nProgImp;
  public double nProgImp2;
  public String cProgSto;
  public double _numrig;
  public String _connes;
  public double _nocodfis;
  public String _maxfo;
  public double _maxfon;
  public double _top;
  public String _topl;
  public double _bot;
  public String _botl;
  public double _cicli;
  public double _pci;
  public java.sql.Date _dataret;
  public java.sql.Date _dataimp;
  public java.sql.Date _datamin;
  public String _codinter;
  public String cProg;
  public String cCanc;
  public String _codrap;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _reccount;
  public double _prgopx;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_import_dbtodbR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_import_dbtodb",m_Caller);
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aeopstor = p_ContextObject.GetPhName("aeopstor");
    if (m_cPhName_aeopstor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopstor = m_cPhName_aeopstor+" "+m_Ctx.GetWritePhName("aeopstor");
    }
    m_cServer_aeopstor = p_ContextObject.GetServer("aeopstor");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
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
    m_cPhName_cpwarn = p_ContextObject.GetPhName("cpwarn");
    if (m_cPhName_cpwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpwarn = m_cPhName_cpwarn+" "+m_Ctx.GetWritePhName("cpwarn");
    }
    m_cServer_cpwarn = p_ContextObject.GetServer("cpwarn");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_f_aederig = p_ContextObject.GetPhName("f_aederig");
    if (m_cPhName_f_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_aederig = m_cPhName_f_aederig+" "+m_Ctx.GetWritePhName("f_aederig");
    }
    m_cServer_f_aederig = p_ContextObject.GetServer("f_aederig");
    m_cPhName_f_aeoprig = p_ContextObject.GetPhName("f_aeoprig");
    if (m_cPhName_f_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_aeoprig = m_cPhName_f_aeoprig+" "+m_Ctx.GetWritePhName("f_aeoprig");
    }
    m_cServer_f_aeoprig = p_ContextObject.GetServer("f_aeoprig");
    m_cPhName_f_aerighe = p_ContextObject.GetPhName("f_aerighe");
    if (m_cPhName_f_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_aerighe = m_cPhName_f_aerighe+" "+m_Ctx.GetWritePhName("f_aerighe");
    }
    m_cServer_f_aerighe = p_ContextObject.GetServer("f_aerighe");
    m_cPhName_f_aetesta = p_ContextObject.GetPhName("f_aetesta");
    if (m_cPhName_f_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_aetesta = m_cPhName_f_aetesta+" "+m_Ctx.GetWritePhName("f_aetesta");
    }
    m_cServer_f_aetesta = p_ContextObject.GetServer("f_aetesta");
    m_cPhName_f_anadip = p_ContextObject.GetPhName("f_anadip");
    if (m_cPhName_f_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_anadip = m_cPhName_f_anadip+" "+m_Ctx.GetWritePhName("f_anadip");
    }
    m_cServer_f_anadip = p_ContextObject.GetServer("f_anadip");
    m_cPhName_f_anarapbo = p_ContextObject.GetPhName("f_anarapbo");
    if (m_cPhName_f_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_anarapbo = m_cPhName_f_anarapbo+" "+m_Ctx.GetWritePhName("f_anarapbo");
    }
    m_cServer_f_anarapbo = p_ContextObject.GetServer("f_anarapbo");
    m_cPhName_f_benefic = p_ContextObject.GetPhName("f_benefic");
    if (m_cPhName_f_benefic.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_benefic = m_cPhName_f_benefic+" "+m_Ctx.GetWritePhName("f_benefic");
    }
    m_cServer_f_benefic = p_ContextObject.GetServer("f_benefic");
    m_cPhName_f_clienti = p_ContextObject.GetPhName("f_clienti");
    if (m_cPhName_f_clienti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_clienti = m_cPhName_f_clienti+" "+m_Ctx.GetWritePhName("f_clienti");
    }
    m_cServer_f_clienti = p_ContextObject.GetServer("f_clienti");
    m_cPhName_f_fraziobo = p_ContextObject.GetPhName("f_fraziobo");
    if (m_cPhName_f_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_fraziobo = m_cPhName_f_fraziobo+" "+m_Ctx.GetWritePhName("f_fraziobo");
    }
    m_cServer_f_fraziobo = p_ContextObject.GetServer("f_fraziobo");
    m_cPhName_f_inter2bo = p_ContextObject.GetPhName("f_inter2bo");
    if (m_cPhName_f_inter2bo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_inter2bo = m_cPhName_f_inter2bo+" "+m_Ctx.GetWritePhName("f_inter2bo");
    }
    m_cServer_f_inter2bo = p_ContextObject.GetServer("f_inter2bo");
    m_cPhName_f_intermbo = p_ContextObject.GetPhName("f_intermbo");
    if (m_cPhName_f_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_intermbo = m_cPhName_f_intermbo+" "+m_Ctx.GetWritePhName("f_intermbo");
    }
    m_cServer_f_intermbo = p_ContextObject.GetServer("f_intermbo");
    m_cPhName_f_intestbo = p_ContextObject.GetPhName("f_intestbo");
    if (m_cPhName_f_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_intestbo = m_cPhName_f_intestbo+" "+m_Ctx.GetWritePhName("f_intestbo");
    }
    m_cServer_f_intestbo = p_ContextObject.GetServer("f_intestbo");
    m_cPhName_f_japopebo = p_ContextObject.GetPhName("f_japopebo");
    if (m_cPhName_f_japopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_japopebo = m_cPhName_f_japopebo+" "+m_Ctx.GetWritePhName("f_japopebo");
    }
    m_cServer_f_japopebo = p_ContextObject.GetServer("f_japopebo");
    m_cPhName_f_jnarapbo = p_ContextObject.GetPhName("f_jnarapbo");
    if (m_cPhName_f_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_jnarapbo = m_cPhName_f_jnarapbo+" "+m_Ctx.GetWritePhName("f_jnarapbo");
    }
    m_cServer_f_jnarapbo = p_ContextObject.GetServer("f_jnarapbo");
    m_cPhName_f_jntestbo = p_ContextObject.GetPhName("f_jntestbo");
    if (m_cPhName_f_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_jntestbo = m_cPhName_f_jntestbo+" "+m_Ctx.GetWritePhName("f_jntestbo");
    }
    m_cServer_f_jntestbo = p_ContextObject.GetServer("f_jntestbo");
    m_cPhName_f_operazbo = p_ContextObject.GetPhName("f_operazbo");
    if (m_cPhName_f_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_operazbo = m_cPhName_f_operazbo+" "+m_Ctx.GetWritePhName("f_operazbo");
    }
    m_cServer_f_operazbo = p_ContextObject.GetServer("f_operazbo");
    m_cPhName_f_opextrbo = p_ContextObject.GetPhName("f_opextrbo");
    if (m_cPhName_f_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_opextrbo = m_cPhName_f_opextrbo+" "+m_Ctx.GetWritePhName("f_opextrbo");
    }
    m_cServer_f_opextrbo = p_ContextObject.GetServer("f_opextrbo");
    m_cPhName_f_personbo = p_ContextObject.GetPhName("f_personbo");
    if (m_cPhName_f_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_personbo = m_cPhName_f_personbo+" "+m_Ctx.GetWritePhName("f_personbo");
    }
    m_cServer_f_personbo = p_ContextObject.GetServer("f_personbo");
    m_cPhName_f_rapopebo = p_ContextObject.GetPhName("f_rapopebo");
    if (m_cPhName_f_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_rapopebo = m_cPhName_f_rapopebo+" "+m_Ctx.GetWritePhName("f_rapopebo");
    }
    m_cServer_f_rapopebo = p_ContextObject.GetServer("f_rapopebo");
    m_cPhName_f_rapotit = p_ContextObject.GetPhName("f_rapotit");
    if (m_cPhName_f_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_rapotit = m_cPhName_f_rapotit+" "+m_Ctx.GetWritePhName("f_rapotit");
    }
    m_cServer_f_rapotit = p_ContextObject.GetServer("f_rapotit");
    m_cPhName_f_soggetbo = p_ContextObject.GetPhName("f_soggetbo");
    if (m_cPhName_f_soggetbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_soggetbo = m_cPhName_f_soggetbo+" "+m_Ctx.GetWritePhName("f_soggetbo");
    }
    m_cServer_f_soggetbo = p_ContextObject.GetServer("f_soggetbo");
    m_cPhName_f_terzisti = p_ContextObject.GetPhName("f_terzisti");
    if (m_cPhName_f_terzisti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_terzisti = m_cPhName_f_terzisti+" "+m_Ctx.GetWritePhName("f_terzisti");
    }
    m_cServer_f_terzisti = p_ContextObject.GetServer("f_terzisti");
    m_cPhName_f_wenefic = p_ContextObject.GetPhName("f_wenefic");
    if (m_cPhName_f_wenefic.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_wenefic = m_cPhName_f_wenefic+" "+m_Ctx.GetWritePhName("f_wenefic");
    }
    m_cServer_f_wenefic = p_ContextObject.GetServer("f_wenefic");
    m_cPhName_f_werzisti = p_ContextObject.GetPhName("f_werzisti");
    if (m_cPhName_f_werzisti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_werzisti = m_cPhName_f_werzisti+" "+m_Ctx.GetWritePhName("f_werzisti");
    }
    m_cServer_f_werzisti = p_ContextObject.GetServer("f_werzisti");
    m_cPhName_f_wlienti = p_ContextObject.GetPhName("f_wlienti");
    if (m_cPhName_f_wlienti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_wlienti = m_cPhName_f_wlienti+" "+m_Ctx.GetWritePhName("f_wlienti");
    }
    m_cServer_f_wlienti = p_ContextObject.GetServer("f_wlienti");
    m_cPhName_f_woggetbo = p_ContextObject.GetPhName("f_woggetbo");
    if (m_cPhName_f_woggetbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_woggetbo = m_cPhName_f_woggetbo+" "+m_Ctx.GetWritePhName("f_woggetbo");
    }
    m_cServer_f_woggetbo = p_ContextObject.GetServer("f_woggetbo");
    m_cPhName_f_wperazbo = p_ContextObject.GetPhName("f_wperazbo");
    if (m_cPhName_f_wperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_wperazbo = m_cPhName_f_wperazbo+" "+m_Ctx.GetWritePhName("f_wperazbo");
    }
    m_cServer_f_wperazbo = p_ContextObject.GetServer("f_wperazbo");
    m_cPhName_f_wraziobo = p_ContextObject.GetPhName("f_wraziobo");
    if (m_cPhName_f_wraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_wraziobo = m_cPhName_f_wraziobo+" "+m_Ctx.GetWritePhName("f_wraziobo");
    }
    m_cServer_f_wraziobo = p_ContextObject.GetServer("f_wraziobo");
    m_cPhName_f_xapopebo = p_ContextObject.GetPhName("f_xapopebo");
    if (m_cPhName_f_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_xapopebo = m_cPhName_f_xapopebo+" "+m_Ctx.GetWritePhName("f_xapopebo");
    }
    m_cServer_f_xapopebo = p_ContextObject.GetServer("f_xapopebo");
    m_cPhName_f_xapotit = p_ContextObject.GetPhName("f_xapotit");
    if (m_cPhName_f_xapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_xapotit = m_cPhName_f_xapotit+" "+m_Ctx.GetWritePhName("f_xapotit");
    }
    m_cServer_f_xapotit = p_ContextObject.GetServer("f_xapotit");
    m_cPhName_f_xenefic = p_ContextObject.GetPhName("f_xenefic");
    if (m_cPhName_f_xenefic.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_xenefic = m_cPhName_f_xenefic+" "+m_Ctx.GetWritePhName("f_xenefic");
    }
    m_cServer_f_xenefic = p_ContextObject.GetServer("f_xenefic");
    m_cPhName_f_xerzisti = p_ContextObject.GetPhName("f_xerzisti");
    if (m_cPhName_f_xerzisti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_xerzisti = m_cPhName_f_xerzisti+" "+m_Ctx.GetWritePhName("f_xerzisti");
    }
    m_cServer_f_xerzisti = p_ContextObject.GetServer("f_xerzisti");
    m_cPhName_f_xlienti = p_ContextObject.GetPhName("f_xlienti");
    if (m_cPhName_f_xlienti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_xlienti = m_cPhName_f_xlienti+" "+m_Ctx.GetWritePhName("f_xlienti");
    }
    m_cServer_f_xlienti = p_ContextObject.GetServer("f_xlienti");
    m_cPhName_f_xnarapbo = p_ContextObject.GetPhName("f_xnarapbo");
    if (m_cPhName_f_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_xnarapbo = m_cPhName_f_xnarapbo+" "+m_Ctx.GetWritePhName("f_xnarapbo");
    }
    m_cServer_f_xnarapbo = p_ContextObject.GetServer("f_xnarapbo");
    m_cPhName_f_xntestbo = p_ContextObject.GetPhName("f_xntestbo");
    if (m_cPhName_f_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_xntestbo = m_cPhName_f_xntestbo+" "+m_Ctx.GetWritePhName("f_xntestbo");
    }
    m_cServer_f_xntestbo = p_ContextObject.GetServer("f_xntestbo");
    m_cPhName_f_xoggetbo = p_ContextObject.GetPhName("f_xoggetbo");
    if (m_cPhName_f_xoggetbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_xoggetbo = m_cPhName_f_xoggetbo+" "+m_Ctx.GetWritePhName("f_xoggetbo");
    }
    m_cServer_f_xoggetbo = p_ContextObject.GetServer("f_xoggetbo");
    m_cPhName_f_xperazbo = p_ContextObject.GetPhName("f_xperazbo");
    if (m_cPhName_f_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_xperazbo = m_cPhName_f_xperazbo+" "+m_Ctx.GetWritePhName("f_xperazbo");
    }
    m_cServer_f_xperazbo = p_ContextObject.GetServer("f_xperazbo");
    m_cPhName_f_xraziobo = p_ContextObject.GetPhName("f_xraziobo");
    if (m_cPhName_f_xraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_xraziobo = m_cPhName_f_xraziobo+" "+m_Ctx.GetWritePhName("f_xraziobo");
    }
    m_cServer_f_xraziobo = p_ContextObject.GetServer("f_xraziobo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    if (m_cPhName_inter2bo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_inter2bo = m_cPhName_inter2bo+" "+m_Ctx.GetWritePhName("inter2bo");
    }
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
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
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    if (m_cPhName_japopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japopebo = m_cPhName_japopebo+" "+m_Ctx.GetWritePhName("japopebo");
    }
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_joginfo = p_ContextObject.GetPhName("joginfo");
    if (m_cPhName_joginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_joginfo = m_cPhName_joginfo+" "+m_Ctx.GetWritePhName("joginfo");
    }
    m_cServer_joginfo = p_ContextObject.GetServer("joginfo");
    m_cPhName_jogopebo = p_ContextObject.GetPhName("jogopebo");
    if (m_cPhName_jogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jogopebo = m_cPhName_jogopebo+" "+m_Ctx.GetWritePhName("jogopebo");
    }
    m_cServer_jogopebo = p_ContextObject.GetServer("jogopebo");
    m_cPhName_jperazbo = p_ContextObject.GetPhName("jperazbo");
    if (m_cPhName_jperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jperazbo = m_cPhName_jperazbo+" "+m_Ctx.GetWritePhName("jperazbo");
    }
    m_cServer_jperazbo = p_ContextObject.GetServer("jperazbo");
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
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    if (m_cPhName_tbvalute.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbvalute = m_cPhName_tbvalute+" "+m_Ctx.GetWritePhName("tbvalute");
    }
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
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
    m_cPhName_titolabo = p_ContextObject.GetPhName("titolabo");
    if (m_cPhName_titolabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_titolabo = m_cPhName_titolabo+" "+m_Ctx.GetWritePhName("titolabo");
    }
    m_cServer_titolabo = p_ContextObject.GetServer("titolabo");
    m_cPhName_titopers = p_ContextObject.GetPhName("titopers");
    if (m_cPhName_titopers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_titopers = m_cPhName_titopers+" "+m_Ctx.GetWritePhName("titopers");
    }
    m_cServer_titopers = p_ContextObject.GetServer("titopers");
    m_cPhName_weneficfrz = p_ContextObject.GetPhName("weneficfrz");
    if (m_cPhName_weneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_weneficfrz = m_cPhName_weneficfrz+" "+m_Ctx.GetWritePhName("weneficfrz");
    }
    m_cServer_weneficfrz = p_ContextObject.GetServer("weneficfrz");
    m_cPhName_weneficope = p_ContextObject.GetPhName("weneficope");
    if (m_cPhName_weneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_weneficope = m_cPhName_weneficope+" "+m_Ctx.GetWritePhName("weneficope");
    }
    m_cServer_weneficope = p_ContextObject.GetServer("weneficope");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_werzistifrz = p_ContextObject.GetPhName("werzistifrz");
    if (m_cPhName_werzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_werzistifrz = m_cPhName_werzistifrz+" "+m_Ctx.GetWritePhName("werzistifrz");
    }
    m_cServer_werzistifrz = p_ContextObject.GetServer("werzistifrz");
    m_cPhName_werzistiope = p_ContextObject.GetPhName("werzistiope");
    if (m_cPhName_werzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_werzistiope = m_cPhName_werzistiope+" "+m_Ctx.GetWritePhName("werzistiope");
    }
    m_cServer_werzistiope = p_ContextObject.GetServer("werzistiope");
    m_cPhName_wlientifrz = p_ContextObject.GetPhName("wlientifrz");
    if (m_cPhName_wlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wlientifrz = m_cPhName_wlientifrz+" "+m_Ctx.GetWritePhName("wlientifrz");
    }
    m_cServer_wlientifrz = p_ContextObject.GetServer("wlientifrz");
    m_cPhName_wlientiope = p_ContextObject.GetPhName("wlientiope");
    if (m_cPhName_wlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wlientiope = m_cPhName_wlientiope+" "+m_Ctx.GetWritePhName("wlientiope");
    }
    m_cServer_wlientiope = p_ContextObject.GetServer("wlientiope");
    m_cPhName_wogopebo = p_ContextObject.GetPhName("wogopebo");
    if (m_cPhName_wogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wogopebo = m_cPhName_wogopebo+" "+m_Ctx.GetWritePhName("wogopebo");
    }
    m_cServer_wogopebo = p_ContextObject.GetServer("wogopebo");
    m_cPhName_wogopefbo = p_ContextObject.GetPhName("wogopefbo");
    if (m_cPhName_wogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wogopefbo = m_cPhName_wogopefbo+" "+m_Ctx.GetWritePhName("wogopefbo");
    }
    m_cServer_wogopefbo = p_ContextObject.GetServer("wogopefbo");
    m_cPhName_wperazbo = p_ContextObject.GetPhName("wperazbo");
    if (m_cPhName_wperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wperazbo = m_cPhName_wperazbo+" "+m_Ctx.GetWritePhName("wperazbo");
    }
    m_cServer_wperazbo = p_ContextObject.GetServer("wperazbo");
    m_cPhName_wraziobo = p_ContextObject.GetPhName("wraziobo");
    if (m_cPhName_wraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wraziobo = m_cPhName_wraziobo+" "+m_Ctx.GetWritePhName("wraziobo");
    }
    m_cServer_wraziobo = p_ContextObject.GetServer("wraziobo");
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
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    if (m_cPhName_xraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo = m_cPhName_xraziobo+" "+m_Ctx.GetWritePhName("xraziobo");
    }
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_f_aesaldi = p_ContextObject.GetPhName("f_aesaldi");
    if (m_cPhName_f_aesaldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_aesaldi = m_cPhName_f_aesaldi+" "+m_Ctx.GetWritePhName("f_aesaldi");
    }
    m_cServer_f_aesaldi = p_ContextObject.GetServer("f_aesaldi");
    m_cPhName_f_aeannora = p_ContextObject.GetPhName("f_aeannora");
    if (m_cPhName_f_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_aeannora = m_cPhName_f_aeannora+" "+m_Ctx.GetWritePhName("f_aeannora");
    }
    m_cServer_f_aeannora = p_ContextObject.GetServer("f_aeannora");
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    m_cPhName_f_aestor = p_ContextObject.GetPhName("f_aestor");
    if (m_cPhName_f_aestor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_aestor = m_cPhName_f_aestor+" "+m_Ctx.GetWritePhName("f_aestor");
    }
    m_cServer_f_aestor = p_ContextObject.GetServer("f_aestor");
    m_cPhName_f_aedestor = p_ContextObject.GetPhName("f_aedestor");
    if (m_cPhName_f_aedestor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_aedestor = m_cPhName_f_aedestor+" "+m_Ctx.GetWritePhName("f_aedestor");
    }
    m_cServer_f_aedestor = p_ContextObject.GetServer("f_aedestor");
    m_cPhName_aedestor = p_ContextObject.GetPhName("aedestor");
    if (m_cPhName_aedestor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aedestor = m_cPhName_aedestor+" "+m_Ctx.GetWritePhName("aedestor");
    }
    m_cServer_aedestor = p_ContextObject.GetServer("aedestor");
    m_cPhName_f_aedecanc = p_ContextObject.GetPhName("f_aedecanc");
    if (m_cPhName_f_aedecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_aedecanc = m_cPhName_f_aedecanc+" "+m_Ctx.GetWritePhName("f_aedecanc");
    }
    m_cServer_f_aedecanc = p_ContextObject.GetServer("f_aedecanc");
    m_cPhName_aedecanc = p_ContextObject.GetPhName("aedecanc");
    if (m_cPhName_aedecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aedecanc = m_cPhName_aedecanc+" "+m_Ctx.GetWritePhName("aedecanc");
    }
    m_cServer_aedecanc = p_ContextObject.GetServer("aedecanc");
    m_cPhName_f_aeinvio = p_ContextObject.GetPhName("f_aeinvio");
    if (m_cPhName_f_aeinvio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_aeinvio = m_cPhName_f_aeinvio+" "+m_Ctx.GetWritePhName("f_aeinvio");
    }
    m_cServer_f_aeinvio = p_ContextObject.GetServer("f_aeinvio");
    m_cPhName_aeinvio = p_ContextObject.GetPhName("aeinvio");
    if (m_cPhName_aeinvio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeinvio = m_cPhName_aeinvio+" "+m_Ctx.GetWritePhName("aeinvio");
    }
    m_cServer_aeinvio = p_ContextObject.GetServer("aeinvio");
    m_cPhName_aesaldi = p_ContextObject.GetPhName("aesaldi");
    if (m_cPhName_aesaldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aesaldi = m_cPhName_aesaldi+" "+m_Ctx.GetWritePhName("aesaldi");
    }
    m_cServer_aesaldi = p_ContextObject.GetServer("aesaldi");
    m_cPhName_f_wersonbo = p_ContextObject.GetPhName("f_wersonbo");
    if (m_cPhName_f_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_wersonbo = m_cPhName_f_wersonbo+" "+m_Ctx.GetWritePhName("f_wersonbo");
    }
    m_cServer_f_wersonbo = p_ContextObject.GetServer("f_wersonbo");
    m_cPhName_f_inttitbo = p_ContextObject.GetPhName("f_inttitbo");
    if (m_cPhName_f_inttitbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_inttitbo = m_cPhName_f_inttitbo+" "+m_Ctx.GetWritePhName("f_inttitbo");
    }
    m_cServer_f_inttitbo = p_ContextObject.GetServer("f_inttitbo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_f_xnttitbo = p_ContextObject.GetPhName("f_xnttitbo");
    if (m_cPhName_f_xnttitbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_xnttitbo = m_cPhName_f_xnttitbo+" "+m_Ctx.GetWritePhName("f_xnttitbo");
    }
    m_cServer_f_xnttitbo = p_ContextObject.GetServer("f_xnttitbo");
    m_cPhName_xntestit = p_ContextObject.GetPhName("xntestit");
    if (m_cPhName_xntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestit = m_cPhName_xntestit+" "+m_Ctx.GetWritePhName("xntestit");
    }
    m_cServer_xntestit = p_ContextObject.GetServer("xntestit");
    m_cPhName_f_delegabo = p_ContextObject.GetPhName("f_delegabo");
    if (m_cPhName_f_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_delegabo = m_cPhName_f_delegabo+" "+m_Ctx.GetWritePhName("f_delegabo");
    }
    m_cServer_f_delegabo = p_ContextObject.GetServer("f_delegabo");
    m_cPhName_f_garantbo = p_ContextObject.GetPhName("f_garantbo");
    if (m_cPhName_f_garantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_garantbo = m_cPhName_f_garantbo+" "+m_Ctx.GetWritePhName("f_garantbo");
    }
    m_cServer_f_garantbo = p_ContextObject.GetServer("f_garantbo");
    m_cPhName_garantbo = p_ContextObject.GetPhName("garantbo");
    if (m_cPhName_garantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_garantbo = m_cPhName_garantbo+" "+m_Ctx.GetWritePhName("garantbo");
    }
    m_cServer_garantbo = p_ContextObject.GetServer("garantbo");
    m_cPhName_db_intermbo = p_ContextObject.GetPhName("db_intermbo");
    if (m_cPhName_db_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_db_intermbo = m_cPhName_db_intermbo+" "+m_Ctx.GetWritePhName("db_intermbo");
    }
    m_cServer_db_intermbo = p_ContextObject.GetServer("db_intermbo");
    m_cPhName_db_anadip = p_ContextObject.GetPhName("db_anadip");
    if (m_cPhName_db_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_db_anadip = m_cPhName_db_anadip+" "+m_Ctx.GetWritePhName("db_anadip");
    }
    m_cServer_db_anadip = p_ContextObject.GetServer("db_anadip");
    m_cPhName_db_personbo = p_ContextObject.GetPhName("db_personbo");
    if (m_cPhName_db_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_db_personbo = m_cPhName_db_personbo+" "+m_Ctx.GetWritePhName("db_personbo");
    }
    m_cServer_db_personbo = p_ContextObject.GetServer("db_personbo");
    m_cPhName_db_wersonbo = p_ContextObject.GetPhName("db_wersonbo");
    if (m_cPhName_db_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_db_wersonbo = m_cPhName_db_wersonbo+" "+m_Ctx.GetWritePhName("db_wersonbo");
    }
    m_cServer_db_wersonbo = p_ContextObject.GetServer("db_wersonbo");
    m_cPhName_db_opextrbo = p_ContextObject.GetPhName("db_opextrbo");
    if (m_cPhName_db_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_db_opextrbo = m_cPhName_db_opextrbo+" "+m_Ctx.GetWritePhName("db_opextrbo");
    }
    m_cServer_db_opextrbo = p_ContextObject.GetServer("db_opextrbo");
    m_cPhName_db_fraziobo = p_ContextObject.GetPhName("db_fraziobo");
    if (m_cPhName_db_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_db_fraziobo = m_cPhName_db_fraziobo+" "+m_Ctx.GetWritePhName("db_fraziobo");
    }
    m_cServer_db_fraziobo = p_ContextObject.GetServer("db_fraziobo");
    m_cPhName_db_cpwarn = p_ContextObject.GetPhName("db_cpwarn");
    if (m_cPhName_db_cpwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_db_cpwarn = m_cPhName_db_cpwarn+" "+m_Ctx.GetWritePhName("db_cpwarn");
    }
    m_cServer_db_cpwarn = p_ContextObject.GetServer("db_cpwarn");
    m_cPhName_db_operazbo = p_ContextObject.GetPhName("db_operazbo");
    if (m_cPhName_db_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_db_operazbo = m_cPhName_db_operazbo+" "+m_Ctx.GetWritePhName("db_operazbo");
    }
    m_cServer_db_operazbo = p_ContextObject.GetServer("db_operazbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("nProgImp2",p_cVarName)) {
      return nProgImp2;
    }
    if (CPLib.eqr("_numrig",p_cVarName)) {
      return _numrig;
    }
    if (CPLib.eqr("_nocodfis",p_cVarName)) {
      return _nocodfis;
    }
    if (CPLib.eqr("_maxfon",p_cVarName)) {
      return _maxfon;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_bot",p_cVarName)) {
      return _bot;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_pci",p_cVarName)) {
      return _pci;
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
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    if (CPLib.eqr("_prgopx",p_cVarName)) {
      return _prgopx;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_import_dbtodb";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("msgproc",p_cVarName)) {
      return w_msgproc;
    }
    if (CPLib.eqr("pOper",p_cVarName)) {
      return pOper;
    }
    if (CPLib.eqr("pFlg",p_cVarName)) {
      return pFlg;
    }
    if (CPLib.eqr("cSNAS",p_cVarName)) {
      return cSNAS;
    }
    if (CPLib.eqr("cCNAS",p_cVarName)) {
      return cCNAS;
    }
    if (CPLib.eqr("_tipper",p_cVarName)) {
      return _tipper;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      return cProgSto;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("_maxfo",p_cVarName)) {
      return _maxfo;
    }
    if (CPLib.eqr("_topl",p_cVarName)) {
      return _topl;
    }
    if (CPLib.eqr("_botl",p_cVarName)) {
      return _botl;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      return _codinter;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("cCanc",p_cVarName)) {
      return cCanc;
    }
    if (CPLib.eqr("_codrap",p_cVarName)) {
      return _codrap;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dataret",p_cVarName)) {
      return _dataret;
    }
    if (CPLib.eqr("_dataimp",p_cVarName)) {
      return _dataimp;
    }
    if (CPLib.eqr("_datamin",p_cVarName)) {
      return _datamin;
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
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("nProgImp2",p_cVarName)) {
      nProgImp2 = value;
      return;
    }
    if (CPLib.eqr("_numrig",p_cVarName)) {
      _numrig = value;
      return;
    }
    if (CPLib.eqr("_nocodfis",p_cVarName)) {
      _nocodfis = value;
      return;
    }
    if (CPLib.eqr("_maxfon",p_cVarName)) {
      _maxfon = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_bot",p_cVarName)) {
      _bot = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_pci",p_cVarName)) {
      _pci = value;
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
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
      return;
    }
    if (CPLib.eqr("_prgopx",p_cVarName)) {
      _prgopx = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("msgproc",p_cVarName)) {
      w_msgproc = value;
      return;
    }
    if (CPLib.eqr("pOper",p_cVarName)) {
      pOper = value;
      return;
    }
    if (CPLib.eqr("pFlg",p_cVarName)) {
      pFlg = value;
      return;
    }
    if (CPLib.eqr("cSNAS",p_cVarName)) {
      cSNAS = value;
      return;
    }
    if (CPLib.eqr("cCNAS",p_cVarName)) {
      cCNAS = value;
      return;
    }
    if (CPLib.eqr("_tipper",p_cVarName)) {
      _tipper = value;
      return;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      cProgSto = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
    if (CPLib.eqr("_maxfo",p_cVarName)) {
      _maxfo = value;
      return;
    }
    if (CPLib.eqr("_topl",p_cVarName)) {
      _topl = value;
      return;
    }
    if (CPLib.eqr("_botl",p_cVarName)) {
      _botl = value;
      return;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      _codinter = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("cCanc",p_cVarName)) {
      cCanc = value;
      return;
    }
    if (CPLib.eqr("_codrap",p_cVarName)) {
      _codrap = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_dataret",p_cVarName)) {
      _dataret = value;
      return;
    }
    if (CPLib.eqr("_dataimp",p_cVarName)) {
      _dataimp = value;
      return;
    }
    if (CPLib.eqr("_datamin",p_cVarName)) {
      _datamin = value;
      return;
    }
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
    CPResultSet Cursor_db_cpwarn=null;
    try {
      /* Parametro */
      /* pOper Char(1) */
      /* pFlg Char(1) */
      /* w_msgproc Memo */
      /* conta Numeric(10, 0) */
      /* cSNAS Char(30) */
      /* cCNAS Char(30) */
      /* _tipper Char(1) */
      /* nProgImp Numeric(15, 0) */
      /* nProgImp2 Numeric(15, 0) */
      /* cProgSto Char(15) */
      /* _numrig Numeric(3, 0) */
      /* _connes Char(16) */
      /* _nocodfis Numeric(1, 0) */
      /* _maxfo Char(11) */
      /* _maxfon Numeric(11, 0) */
      /* _top Numeric(11, 0) */
      /* _topl Char(11) */
      /* _bot Numeric(11, 0) */
      /* _botl Char(11) */
      /* _cicli Numeric(11, 0) */
      /* _pci Numeric(11, 0) */
      /* _dataret Date */
      /* _dataimp Date */
      /* _datamin Date */
      /* _codinter Char(11) */
      /* cProg Char(10) */
      /* cCanc Char(10) */
      /* _codrap Char(25) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _reccount Numeric(0, 0) */
      /* _prgopx Numeric(10, 0) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Inizio Elaborazione' // Messaggio Import */
      gMsgImp = "Inizio Elaborazione";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Lancia la pagina appropriata */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000002Fstatus;
      nTry0000002Fstatus = m_Sql.GetTransactionStatus();
      String cTry0000002Fmsg;
      cTry0000002Fmsg = m_Sql.TransactionErrorMessage();
      try {
        /* Case pOper='I' */
        if (CPLib.eqr(pOper,"I")) {
          /* Exec "Intermediari + Dipendenze" Page 2:Page_2 */
          Page_2();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='P' */
        } else if (CPLib.eqr(pOper,"P")) {
          /* Exec "Soggetti" Page 3:Page_3 */
          Page_3();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='R' */
        } else if (CPLib.eqr(pOper,"R")) {
          /* Exec "Rapporti + Informazioni (AUI)" Page 7:Page_7 */
          Page_7();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='O' */
        } else if (CPLib.eqr(pOper,"O")) {
          /* Exec "Operazioni + Frazionate" Page 5:Page_5 */
          Page_5();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='T' */
        } else if (CPLib.eqr(pOper,"T")) {
          /* Exec "Titolari Effettivi" Page 14:Page_14 */
          Page_14();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='G' */
        } else if (CPLib.eqr(pOper,"G")) {
          /* Exec "Rapporti + Informazioni (AGE)" Page 8:Page_8 */
          Page_8();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='A' */
        } else if (CPLib.eqr(pOper,"A")) {
          /* Exec "Anagrafe Rapporti" Page 9:Page_9 */
          Page_9();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='D' */
        } else if (CPLib.eqr(pOper,"D")) {
          /* Exec "Deleghe + Oper. Extra" Page 10:Page_10 */
          Page_10();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='X' */
        } else if (CPLib.eqr(pOper,"X")) {
          /* Exec "Rapporti + Informazioni (AUI) P" Page 12:Page_12 */
          Page_12();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='Y' */
        } else if (CPLib.eqr(pOper,"Y")) {
          /* Exec "Operazioni + Frazionate P" Page 13:Page_13 */
          Page_13();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='Z' */
        } else if (CPLib.eqr(pOper,"Z")) {
          /* Exec "Titolari Effettivi P" Page 15:Page_15 */
          Page_15();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='S' */
        } else if (CPLib.eqr(pOper,"S")) {
          /* Exec "Saldi (AGE)" Page 17:Page_17 */
          Page_17();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='E' */
        } else if (CPLib.eqr(pOper,"E")) {
          /* Exec "Operazioni Extraconto" Page 4:Page_4 */
          Page_4();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='F' */
        } else if (CPLib.eqr(pOper,"F")) {
          /* Exec "Intermediari + Dipendenze" Page 2:Page_2 */
          Page_2();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Exec "Soggetti" Page 3:Page_3 */
          Page_3();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Exec "Operazioni Extraconto" Page 4:Page_4 */
          Page_4();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Exec "Operazioni + Frazionate" Page 5:Page_5 */
          Page_5();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Si importa prima da storico dove sono le vecchie operazioni. Non spostare altrimenti salta l'aggiornamento dei contatori. */
          /* Case pOper='1' */
        } else if (CPLib.eqr(pOper,"1")) {
          /* Exec "Rapporti + Informazioni (Storico)" Page 6:Page_6 */
          Page_6();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='2' */
        } else if (CPLib.eqr(pOper,"2")) {
          /* Exec "Operaz. + Frazio. (Storico)" Page 11:Page_11 */
          Page_11();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='3' */
        } else if (CPLib.eqr(pOper,"3")) {
          /* Exec "Titolari Effettivi (Storico)" Page 16:Page_16 */
          Page_16();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pOper='J' */
        } else if (CPLib.eqr(pOper,"J")) {
          /* Exec "Garantiti" Page 18:Page_18 */
          Page_18();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
        } // End Case
        // * --- Delete from cpwarn
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"00000048")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
        // * --- Select from db_cpwarn
        m_cServer = m_Ctx.GetServer("db_cpwarn");
        m_cPhName = m_Ctx.GetPhName("db_cpwarn");
        if (Cursor_db_cpwarn!=null)
          Cursor_db_cpwarn.Close();
        Cursor_db_cpwarn = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("db_cpwarn")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_db_cpwarn.Eof())) {
          // * --- Insert into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"0000004A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000004A(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_cpwarn.GetString("tablecode"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_cpwarn.GetString("warncode"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_cpwarn.GetDouble("autonum"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_cpwarn.GetString("desccode"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
          Cursor_db_cpwarn.Next();
        }
        m_cConnectivityError = Cursor_db_cpwarn.ErrorMessage();
        Cursor_db_cpwarn.Close();
        // * --- End Select
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000002Fstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000002Fstatus,cTry0000002Fmsg);
        }
      }
      /* gMsgImp := 'Fine Elaborazione' // Messaggio Import */
      gMsgImp = "Fine Elaborazione";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_db_cpwarn!=null)
          Cursor_db_cpwarn.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_db_intermbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_db_anadip=null;
    try {
      /* _codip Char(6) */
      String _codip;
      _codip = CPLib.Space(6);
      /* Legge la tabella intermediari controparte e aggiunge i record */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Intermediario' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Intermediario"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from db_intermbo
      m_cServer = m_Ctx.GetServer("db_intermbo");
      m_cPhName = m_Ctx.GetPhName("db_intermbo");
      if (Cursor_db_intermbo!=null)
        Cursor_db_intermbo.Close();
      Cursor_db_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("db_intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_db_intermbo.Eof())) {
        /* If not(Empty(db_intermbo->CODINTER)) */
        if ( ! (CPLib.Empty(Cursor_db_intermbo.GetString("CODINTER")))) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Intermediario' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Intermediario";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _codinter := '' */
          _codinter = "";
          // * --- Read from intermbo
          m_cServer = m_Ctx.GetServer("intermbo");
          m_cPhName = m_Ctx.GetPhName("intermbo");
          m_cSql = "";
          m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_db_intermbo.GetString("CODINTER"),"C",11,0,m_cServer),m_cServer,Cursor_db_intermbo.GetString("CODINTER"));
          if (m_Ctx.IsSharedTemp("intermbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODINTER",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _codinter = Read_Cursor.GetString("CODINTER");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on intermbo into routine arrt_import_dbtodb returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _codinter = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_codinter)) */
          if (CPLib.Empty(CPLib.LRTrim(_codinter))) {
            // * --- Insert into intermbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("intermbo");
            m_cPhName = m_Ctx.GetPhName("intermbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intermbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"00000059")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000059(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DATANASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_db_intermbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_db_intermbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_db_intermbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DATARILASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_db_intermbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_db_intermbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("IDCITTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("SUPPLEM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DATAVALI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("DBPROT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("F_INGLESE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("CONTATORE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("PATHAPP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("URLAPPL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGLOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGAOS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("AEPATH"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("MOLTI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGEAOS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGCDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGAPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DTINIATT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGTIPIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGSTPCON"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGIMPAGE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("CFINVIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("CAFINVIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FILEINVIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DATAINVIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGWU"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("IMPINTOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("GGYELWAR"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("GGREDWAR"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGOPEXTR"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("SKT_SERVER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("SKT_PORT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("SKT_PATHS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("SKT_MODET"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("RASPAUI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("RESPAUI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("TESTIP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("FLGDATAIM"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("FLGDATATP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("LIMITVLT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("LIMITVNP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("NOCODFISC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGSTPDIR"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("PATRONO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("NODOM"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("NOSAB"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("CODINTER2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("NUMINTER2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("IMPINTER2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DATAINTER"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("TPSOFTAE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("PROVNA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("F_LOG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("IMPPATH"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("PRGAEPATH"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("CODAGE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGCHK"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGNODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DATAINTER2"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("IDSID"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("SIDPASS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("FLGSIDAUTO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("PATHSID"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("PATHJAVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("TIPOINST"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("SNAISTOR"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("LIMITEFRZ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FRAZDEL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGRAPCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FILEDAPRED"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FILEESITI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FILEPRED"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("RICEVUTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("RICESITI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("RICFATTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("PATHCERT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("ESCLUDI0"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("OPGTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("NUMGIORN"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("SOLOFRAZ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("SOLOPERS"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("CODORO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGSCDFRZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGRITORNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("SBLRITORNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGCREAAGE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DNASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("COMNASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("PRNASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("CITTADINA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("SOGCOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("CAMBI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("AGGAGE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DTTITAGE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDate("SCADSALDI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGIPMT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("GIORNIFRZ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("MINFRZSNAI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("ALTSRVMAIL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("ALTPRTMAIL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("ALTEMLMAIL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("ALTUSRMAIL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("ALTPWDMAIL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGGESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("USRGESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("PWDGESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("URLDESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("EMAILDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DATADOC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGDDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGLIGHT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGCGOPWD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"intermbo",true);
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
            // * --- Write into intermbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("intermbo");
            m_cPhName = m_Ctx.GetPhName("intermbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intermbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"0000005A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DATANASC"),"D",8,0)+", ";
            m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQLNull(Cursor_db_intermbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQLNull(Cursor_db_intermbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQLNull(Cursor_db_intermbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DATARILASC"),"D",8,0)+", ";
            m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQLNull(Cursor_db_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("TIPOPERS"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"CONNES = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("CONNES"),"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQLNull(Cursor_db_intermbo.GetString("CODDIPE"),"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("PARTIVA"),"C",14,0,m_cServer)+", ";
            m_cSql = m_cSql+"NOTE = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("NOTE"),"M",10,0,m_cServer,m_oParameters)+", ";
            m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"SOSPMAF = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("SOSPMAF"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"IDCITTA = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("IDCITTA"),"C",10,0,m_cServer)+", ";
            m_cSql = m_cSql+"SUPPLEM = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("SUPPLEM"),"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DATAVALI"),"D",8,0)+", ";
            m_cSql = m_cSql+"DBPROT = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("DBPROT"),"C",100,0,m_cServer)+", ";
            m_cSql = m_cSql+"F_INGLESE = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("F_INGLESE"),"N",1,0)+", ";
            m_cSql = m_cSql+"CONTATORE = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("CONTATORE"),"N",15,0)+", ";
            m_cSql = m_cSql+"PATHAPP = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("PATHAPP"),"C",80,0,m_cServer)+", ";
            m_cSql = m_cSql+"URLAPPL = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("URLAPPL"),"C",80,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGLOG = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGLOG"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGAOS = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGAOS"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"AEPATH = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("AEPATH"),"C",250,0,m_cServer)+", ";
            m_cSql = m_cSql+"MOLTI = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("MOLTI"),"N",1,0)+", ";
            m_cSql = m_cSql+"FLGEAOS = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGEAOS"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGCDOC = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGCDOC"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGFRAZ = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGFRAZ"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGAPERS = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGAPERS"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DTINIATT = "+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DTINIATT"),"D",8,0)+", ";
            m_cSql = m_cSql+"FLGTIPIMP = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGTIPIMP"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGSTPCON = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGSTPCON"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGIMPAGE = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGIMPAGE"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"CFINVIO = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("CFINVIO"),"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAFINVIO = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("CAFINVIO"),"C",5,0,m_cServer)+", ";
            m_cSql = m_cSql+"FILEINVIO = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FILEINVIO"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DATAINVIO"),"D",8,0)+", ";
            m_cSql = m_cSql+"FLGWU = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGWU"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"IMPINTOPE = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("IMPINTOPE"),"N",12,2)+", ";
            m_cSql = m_cSql+"GGYELWAR = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("GGYELWAR"),"N",3,0)+", ";
            m_cSql = m_cSql+"GGREDWAR = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("GGREDWAR"),"N",3,0)+", ";
            m_cSql = m_cSql+"FLGOPEXTR = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGOPEXTR"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"SKT_SERVER = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("SKT_SERVER"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"SKT_PORT = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("SKT_PORT"),"N",5,0)+", ";
            m_cSql = m_cSql+"SKT_PATHS = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("SKT_PATHS"),"C",60,0,m_cServer)+", ";
            m_cSql = m_cSql+"SKT_MODET = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("SKT_MODET"),"C",5,0,m_cServer)+", ";
            m_cSql = m_cSql+"RASPAUI = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("RASPAUI"),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"RESPAUI = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("RESPAUI"),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"TESTIP = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("TESTIP"),"C",11,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGDATAIM = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("FLGDATAIM"),"N",1,0)+", ";
            m_cSql = m_cSql+"FLGDATATP = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("FLGDATATP"),"N",1,0)+", ";
            m_cSql = m_cSql+"LIMITVLT = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("LIMITVLT"),"N",10,2)+", ";
            m_cSql = m_cSql+"LIMITVNP = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("LIMITVNP"),"N",10,2)+", ";
            m_cSql = m_cSql+"NOCODFISC = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("NOCODFISC"),"N",1,0)+", ";
            m_cSql = m_cSql+"FLGSTPDIR = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGSTPDIR"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"PATRONO = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("PATRONO"),"C",4,0,m_cServer)+", ";
            m_cSql = m_cSql+"NODOM = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("NODOM"),"N",1,0)+", ";
            m_cSql = m_cSql+"NOSAB = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("NOSAB"),"N",1,0)+", ";
            m_cSql = m_cSql+"CODINTER2 = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("CODINTER2"),"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"NUMINTER2 = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("NUMINTER2"),"C",5,0,m_cServer)+", ";
            m_cSql = m_cSql+"IMPINTER2 = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("IMPINTER2"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATAINTER = "+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DATAINTER"),"D",8,0)+", ";
            m_cSql = m_cSql+"TPSOFTAE = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("TPSOFTAE"),"N",1,0)+", ";
            m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("COGNOME"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("NOME"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("NASSTATO"),"C",40,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROVNA = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("PROVNA"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"F_LOG = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("F_LOG"),"N",1,0)+", ";
            m_cSql = m_cSql+"IMPPATH = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("IMPPATH"),"C",240,0,m_cServer)+", ";
            m_cSql = m_cSql+"PRGAEPATH = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("PRGAEPATH"),"C",250,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODAGE = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("CODAGE"),"C",7,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGCHK = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGCHK"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGNODOC = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGNODOC"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATAINTER2 = "+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DATAINTER2"),"D",8,0)+", ";
            m_cSql = m_cSql+"IDSID = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("IDSID"),"C",8,0,m_cServer)+", ";
            m_cSql = m_cSql+"SIDPASS = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("SIDPASS"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGSIDAUTO = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("FLGSIDAUTO"),"N",1,0)+", ";
            m_cSql = m_cSql+"PATHSID = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("PATHSID"),"C",250,0,m_cServer)+", ";
            m_cSql = m_cSql+"PATHJAVA = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("PATHJAVA"),"C",250,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPOINST = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("TIPOINST"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"SNAISTOR = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("SNAISTOR"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"LIMITEFRZ = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("LIMITEFRZ"),"N",10,2)+", ";
            m_cSql = m_cSql+"FRAZDEL = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FRAZDEL"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGRAPCLI = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGRAPCLI"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FILEDAPRED = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FILEDAPRED"),"C",250,0,m_cServer)+", ";
            m_cSql = m_cSql+"FILEESITI = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FILEESITI"),"C",250,0,m_cServer)+", ";
            m_cSql = m_cSql+"FILEPRED = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FILEPRED"),"C",250,0,m_cServer)+", ";
            m_cSql = m_cSql+"RICEVUTE = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("RICEVUTE"),"C",250,0,m_cServer)+", ";
            m_cSql = m_cSql+"RICESITI = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("RICESITI"),"C",250,0,m_cServer)+", ";
            m_cSql = m_cSql+"RICFATTE = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("RICFATTE"),"C",250,0,m_cServer)+", ";
            m_cSql = m_cSql+"PATHCERT = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("PATHCERT"),"C",250,0,m_cServer)+", ";
            m_cSql = m_cSql+"ESCLUDI0 = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("ESCLUDI0"),"N",1,0)+", ";
            m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
            m_cSql = m_cSql+"OPGTIPO = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("OPGTIPO"),"N",1,0)+", ";
            m_cSql = m_cSql+"NUMGIORN = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("NUMGIORN"),"N",3,0)+", ";
            m_cSql = m_cSql+"SOLOFRAZ = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("SOLOFRAZ"),"N",1,0)+", ";
            m_cSql = m_cSql+"SOLOPERS = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("SOLOPERS"),"N",1,0)+", ";
            m_cSql = m_cSql+"CODORO = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("CODORO"),"C",20,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGSCDFRZ = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGSCDFRZ"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGRITORNO = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGRITORNO"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"SBLRITORNO = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("SBLRITORNO"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGCREAAGE = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGCREAAGE"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DNASC = "+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DNASC"),"D",8,0)+", ";
            m_cSql = m_cSql+"COMNASC = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("COMNASC"),"C",40,0,m_cServer)+", ";
            m_cSql = m_cSql+"PRNASC = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("PRNASC"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CITTADINA = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("CITTADINA"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"SOGCOM = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("SOGCOM"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAMBI = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("CAMBI"),"N",1,0)+", ";
            m_cSql = m_cSql+"AGGAGE = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("AGGAGE"),"N",1,0)+", ";
            m_cSql = m_cSql+"DTTITAGE = "+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DTTITAGE"),"D",8,0)+", ";
            m_cSql = m_cSql+"SCADSALDI = "+CPLib.ToSQL(Cursor_db_intermbo.GetDate("SCADSALDI"),"D",8,0)+", ";
            m_cSql = m_cSql+"FLGIPMT = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGIPMT"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"GIORNIFRZ = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("GIORNIFRZ"),"N",3,0)+", ";
            m_cSql = m_cSql+"MINFRZSNAI = "+CPLib.ToSQL(Cursor_db_intermbo.GetDouble("MINFRZSNAI"),"N",12,2)+", ";
            m_cSql = m_cSql+"ALTSRVMAIL = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("ALTSRVMAIL"),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"ALTPRTMAIL = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("ALTPRTMAIL"),"C",5,0,m_cServer)+", ";
            m_cSql = m_cSql+"ALTEMLMAIL = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("ALTEMLMAIL"),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"ALTUSRMAIL = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("ALTUSRMAIL"),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"ALTPWDMAIL = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("ALTPWDMAIL"),"C",80,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGGESDOC = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGGESDOC"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"USRGESDOC = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("USRGESDOC"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"PWDGESDOC = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("PWDGESDOC"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"URLDESDOC = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("URLDESDOC"),"C",80,0,m_cServer)+", ";
            m_cSql = m_cSql+"EMAILDOC = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("EMAILDOC"),"C",80,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATADOC = "+CPLib.ToSQL(Cursor_db_intermbo.GetDate("DATADOC"),"D",8,0)+", ";
            m_cSql = m_cSql+"FLGDDOC = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGDDOC"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGLIGHT = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGLIGHT"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGCGOPWD = "+CPLib.ToSQL(Cursor_db_intermbo.GetString("FLGCGOPWD"),"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intermbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_db_intermbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_db_intermbo.GetString("CODINTER"))+"";
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
        } // End If
        Cursor_db_intermbo.Next();
      }
      m_cConnectivityError = Cursor_db_intermbo.ErrorMessage();
      Cursor_db_intermbo.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Intermediario' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Intermediario"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Intermediari controparte' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Intermediari controparte"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Intermediari controparte' // Messaggio Import */
      gMsgImp = "Fine importazione del file Intermediari controparte";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Legge la tabella intermediari controparte e aggiunge i record */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Intermediari controparte' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Intermediari controparte"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* Legge la tabella dipendenze e aggiunge i record */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Dipendenze' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Dipendenze"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from db_anadip
      m_cServer = m_Ctx.GetServer("db_anadip");
      m_cPhName = m_Ctx.GetPhName("db_anadip");
      if (Cursor_db_anadip!=null)
        Cursor_db_anadip.Close();
      Cursor_db_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("db_anadip")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_db_anadip.Eof())) {
        /* If not(Empty(db_anadip->CODDIP)) */
        if ( ! (CPLib.Empty(Cursor_db_anadip.GetString("CODDIP")))) {
          /* _codip := '' */
          _codip = "";
          // * --- Read from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_cSql = "";
          m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_db_anadip.GetString("CODDIP"),"C",6,0,m_cServer),m_cServer,Cursor_db_anadip.GetString("CODDIP"));
          if (m_Ctx.IsSharedTemp("anadip")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _codip = Read_Cursor.GetString("CODDIP");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anadip into routine arrt_import_dbtodb returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _codip = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(_codip) */
          if (CPLib.Empty(_codip)) {
            // * --- Insert into anadip from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anadip",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"00000069")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000069(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("DESCRIZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("IDCITTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("AGENTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_db_anadip.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("TERMINALID"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("TELEFONO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("CODLOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("ABICABSARA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("NUOVO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("AGACCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("NAZAGENTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetDouble("OPXSOSCLI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetDouble("OPXSOSAGE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("VALCOMPL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("ANOMOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("AGEREGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_anadip.GetString("FLGATT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"anadip",true);
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
            // * --- Write into anadip from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anadip",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"0000006A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DESCRIZ = "+CPLib.ToSQL(Cursor_db_anadip.GetString("DESCRIZ"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"IDCITTA = "+CPLib.ToSQL(Cursor_db_anadip.GetString("IDCITTA"),"C",10,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_db_anadip.GetString("DESCCIT"),"C",60,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_db_anadip.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(Cursor_db_anadip.GetString("CAB"),"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_db_anadip.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
            m_cSql = m_cSql+"AGENTE = "+CPLib.ToSQL(Cursor_db_anadip.GetString("AGENTE"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"MACROAGENTE = "+CPLib.ToSQLNull(Cursor_db_anadip.GetString("MACROAGENTE"),"C",5,0,m_cServer)+", ";
            m_cSql = m_cSql+"TERMINALID = "+CPLib.ToSQL(Cursor_db_anadip.GetString("TERMINALID"),"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_db_anadip.GetString("DOMICILIO"),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"TELEFONO = "+CPLib.ToSQL(Cursor_db_anadip.GetString("TELEFONO"),"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODLOC = "+CPLib.ToSQL(Cursor_db_anadip.GetString("CODLOC"),"C",25,0,m_cServer)+", ";
            m_cSql = m_cSql+"ABICABSARA = "+CPLib.ToSQL(Cursor_db_anadip.GetString("ABICABSARA"),"C",12,0,m_cServer)+", ";
            m_cSql = m_cSql+"NUOVO = "+CPLib.ToSQL(Cursor_db_anadip.GetString("NUOVO"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_db_anadip.GetString("CAP"),"C",5,0,m_cServer)+", ";
            m_cSql = m_cSql+"AGACCODE = "+CPLib.ToSQL(Cursor_db_anadip.GetString("AGACCODE"),"C",10,0,m_cServer)+", ";
            m_cSql = m_cSql+"NAZAGENTE = "+CPLib.ToSQL(Cursor_db_anadip.GetString("NAZAGENTE"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"OPXSOSCLI = "+CPLib.ToSQL(Cursor_db_anadip.GetDouble("OPXSOSCLI"),"N",10,0)+", ";
            m_cSql = m_cSql+"OPXSOSAGE = "+CPLib.ToSQL(Cursor_db_anadip.GetDouble("OPXSOSAGE"),"N",10,0)+", ";
            m_cSql = m_cSql+"VALCOMPL = "+CPLib.ToSQL(Cursor_db_anadip.GetString("VALCOMPL"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"ANOMOPER = "+CPLib.ToSQL(Cursor_db_anadip.GetString("ANOMOPER"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"AGEREGIO = "+CPLib.ToSQL(Cursor_db_anadip.GetString("AGEREGIO"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGATT = "+CPLib.ToSQL(Cursor_db_anadip.GetString("FLGATT"),"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anadip",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODDIP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codip,"?",0,0,m_cServer),m_cServer,_codip)+"";
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
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Dipendenze' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Dipendenze";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        Cursor_db_anadip.Next();
      }
      m_cConnectivityError = Cursor_db_anadip.ErrorMessage();
      Cursor_db_anadip.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Dipendenze' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Dipendenze"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Dipendenze' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Dipendenze"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Dipendenze' // Messaggio Import */
      gMsgImp = "Fine importazione del file Dipendenze";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_db_intermbo!=null)
          Cursor_db_intermbo.Close();
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
        if (Cursor_db_anadip!=null)
          Cursor_db_anadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_db_personbo_minmax=null;
    CPResultSet Cursor_db_personbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_db_wersonbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Dati Soggetti */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Soggetti' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Soggetti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Dati Soggetti */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000074status;
      nTry00000074status = m_Sql.GetTransactionStatus();
      String cTry00000074msg;
      cTry00000074msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Delete from personbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"00000076")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* _maxfon := 0 */
        _maxfon = CPLib.Round(0,0);
        // * --- Select from qbe_db_personbo_minmax
        if (Cursor_qbe_db_personbo_minmax!=null)
          Cursor_qbe_db_personbo_minmax.Close();
        Cursor_qbe_db_personbo_minmax = new VQRHolder("qbe_db_personbo_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_db_personbo_minmax.Eof())) {
          /* _min := qbe_db_personbo_minmax->MINPRG */
          _min = CPLib.Round(Cursor_qbe_db_personbo_minmax.GetDouble("MINPRG"),0);
          /* _max := qbe_db_personbo_minmax->MAXPRG */
          _max = CPLib.Round(Cursor_qbe_db_personbo_minmax.GetDouble("MAXPRG"),0);
          /* _tot := qbe_db_personbo_minmax->TOTPRG */
          _tot = CPLib.Round(Cursor_qbe_db_personbo_minmax.GetDouble("TOTPRG"),0);
          Cursor_qbe_db_personbo_minmax.Next();
        }
        m_cConnectivityError = Cursor_qbe_db_personbo_minmax.ErrorMessage();
        Cursor_qbe_db_personbo_minmax.Close();
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
          /* _cicli := iif(Mod(_reccount,1000) <> 0,Int(_reccount/1000) + 1,Int(_reccount/1000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,1000),0)?CPLib.Int(_reccount/1000)+1:CPLib.Int(_reccount/1000)),0);
        } // End If
        /* _pci := 1 */
        _pci = CPLib.Round(1,0);
        /* While _pci <= _cicli */
        while (CPLib.le(_pci,_cicli)) {
          /* If _mono = 1 */
          if (CPLib.eqr(_mono,1)) {
            /* _bot := _min */
            _bot = CPLib.Round(_min,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* If _pci=1 */
            if (CPLib.eqr(_pci,1)) {
              /* _bot := _min */
              _bot = CPLib.Round(_min,0);
              /* _top := _min + 999 */
              _top = CPLib.Round(_min+999,0);
              /* ElseIf _pci = _cicli */
            } else if (CPLib.eqr(_pci,_cicli)) {
              /* _bot := _top + 1 */
              _bot = CPLib.Round(_top+1,0);
              /* _top := _max */
              _top = CPLib.Round(_max,0);
            } else { // Else
              /* _bot := _top + 1 */
              _bot = CPLib.Round(_top+1,0);
              /* _top := _bot + 999 */
              _top = CPLib.Round(_bot+999,0);
            } // End If
          } // End If
          // * --- Select from db_personbo
          m_cServer = m_Ctx.GetServer("db_personbo");
          m_cPhName = m_Ctx.GetPhName("db_personbo");
          if (Cursor_db_personbo!=null)
            Cursor_db_personbo.Close();
          Cursor_db_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PROGIMPORT >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_bot,"?",0,0,m_cServer, m_oParameters),m_cServer,_bot)+"  and  PROGIMPORT <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+" "+")"+(m_Ctx.IsSharedTemp("db_personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_db_personbo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Soggetti' // Messaggio Import */
            gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Soggetti";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _connes := '' */
            _connes = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(Cursor_db_personbo.GetString("CONNES")),"C",16,0,m_cServer),m_cServer,CPLib.Upper(Cursor_db_personbo.GetString("CONNES")));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _connes = Read_Cursor.GetString("CONNES");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_dbtodb returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _connes = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(_connes) and not(Empty(db_personbo->CONNES)) */
            if (CPLib.Empty(_connes) &&  ! (CPLib.Empty(Cursor_db_personbo.GetString("CONNES")))) {
              // * --- Insert into personbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"00000096")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000096(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_db_personbo.GetString("CONNES")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("OLDCONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDate("DATEXTRA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDouble("ALLINEATO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDouble("ALLINEATONOMECNOME"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("RAGSOCOLD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDouble("PROGIMPORT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("PROGIMP_C"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDate("DATAVARAGE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("SETTSINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("FATCA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("BANCABEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("TIN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDouble("ODB"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("TELEF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("TIPOORO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("CODORO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("IDNASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetString("IDNASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_personbo.GetDouble("NOTIT"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
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
            Cursor_db_personbo.Next();
          }
          m_cConnectivityError = Cursor_db_personbo.ErrorMessage();
          Cursor_db_personbo.Close();
          // * --- End Select
          /* _pci := _pci + 1 */
          _pci = CPLib.Round(_pci+1,0);
        } // End While
        /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Soggetti' + NL */
        gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Soggetti"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Delete from wersonbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"0000009A")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        // * --- Select from db_wersonbo
        m_cServer = m_Ctx.GetServer("db_wersonbo");
        m_cPhName = m_Ctx.GetPhName("db_wersonbo");
        if (Cursor_db_wersonbo!=null)
          Cursor_db_wersonbo.Close();
        Cursor_db_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("db_wersonbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_db_wersonbo.Eof())) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Storico Soggetti' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Storico Soggetti";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Insert into wersonbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("wersonbo");
          m_cPhName = m_Ctx.GetPhName("wersonbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"0000009F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000009F(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("sanumpro"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("OLDCONNES"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDate("DATEXTRA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDouble("RNATGIU"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDouble("RATTIV"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDouble("RCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDouble("RAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDouble("ALLINEATO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDouble("ALLINEATONOMECNOME"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("RAGSOCOLD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDouble("PROGIMPORT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("PROGIMP_C"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDate("datamodi"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDate("DATASEGN"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDate("DATAVARAGE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("SETTSINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("FATCA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("BANCABEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("TIN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDouble("ODB"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("TELEF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("TIPOORO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("CODORO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("IDNASCOMUN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetString("IDNASSTATO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_wersonbo.GetDouble("NOTIT"),"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wersonbo",true);
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
          Cursor_db_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_db_wersonbo.ErrorMessage();
        Cursor_db_wersonbo.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Storico Soggetti' + NL */
        gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Storico Soggetti"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
        /* gMsgProc := gMsgProc + 'Elaborazione terminata con errori. Import abortito' + NL */
        gMsgProc = gMsgProc+"Elaborazione terminata con errori. Import abortito"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000074status,0)) {
          m_Sql.SetTransactionStatus(nTry00000074status,cTry00000074msg);
        }
      }
      /* If _pci  > _cicli */
      if (CPLib.gt(_pci,_cicli)) {
      } else { // Else
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Soggetti' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Soggetti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Soggetti' // Messaggio Import */
      gMsgImp = "Fine importazione del file Soggetti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_qbe_db_personbo_minmax!=null)
          Cursor_qbe_db_personbo_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_db_personbo!=null)
          Cursor_db_personbo.Close();
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
        if (Cursor_db_wersonbo!=null)
          Cursor_db_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_db_opextrbo_minmax=null;
    CPResultSet Cursor_db_opextrbo=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Operazioni Extraconto */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni Extraconto' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni Extraconto"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000000AAstatus;
      nTry000000AAstatus = m_Sql.GetTransactionStatus();
      String cTry000000AAmsg;
      cTry000000AAmsg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Delete from opextrbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("opextrbo");
        m_cPhName = m_Ctx.GetPhName("opextrbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"000000AC")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* _maxfon := 0 */
        _maxfon = CPLib.Round(0,0);
        // * --- Select from qbe_db_opextrbo_minmax
        if (Cursor_qbe_db_opextrbo_minmax!=null)
          Cursor_qbe_db_opextrbo_minmax.Close();
        Cursor_qbe_db_opextrbo_minmax = new VQRHolder("qbe_db_opextrbo_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_db_opextrbo_minmax.Eof())) {
          /* _min := qbe_db_opextrbo_minmax->MINPRG */
          _min = CPLib.Round(Cursor_qbe_db_opextrbo_minmax.GetDouble("MINPRG"),0);
          /* _max := qbe_db_opextrbo_minmax->MAXPRG */
          _max = CPLib.Round(Cursor_qbe_db_opextrbo_minmax.GetDouble("MAXPRG"),0);
          /* _tot := qbe_db_opextrbo_minmax->TOTPRG */
          _tot = CPLib.Round(Cursor_qbe_db_opextrbo_minmax.GetDouble("TOTPRG"),0);
          Cursor_qbe_db_opextrbo_minmax.Next();
        }
        m_cConnectivityError = Cursor_qbe_db_opextrbo_minmax.ErrorMessage();
        Cursor_qbe_db_opextrbo_minmax.Close();
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
          /* _cicli := iif(Mod(_reccount,1000) <> 0,Int(_reccount/1000) + 1,Int(_reccount/1000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,1000),0)?CPLib.Int(_reccount/1000)+1:CPLib.Int(_reccount/1000)),0);
        } // End If
        /* _pci := 1 */
        _pci = CPLib.Round(1,0);
        /* While _pci <= _cicli */
        while (CPLib.le(_pci,_cicli)) {
          /* If _mono = 1 */
          if (CPLib.eqr(_mono,1)) {
            /* _bot := _min */
            _bot = CPLib.Round(_min,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* If _pci=1 */
            if (CPLib.eqr(_pci,1)) {
              /* _bot := _min */
              _bot = CPLib.Round(_min,0);
              /* _top := _min + 999 */
              _top = CPLib.Round(_min+999,0);
              /* ElseIf _pci = _cicli */
            } else if (CPLib.eqr(_pci,_cicli)) {
              /* _bot := _top + 1 */
              _bot = CPLib.Round(_top+1,0);
              /* _top := _max */
              _top = CPLib.Round(_max,0);
            } else { // Else
              /* _bot := _top + 1 */
              _bot = CPLib.Round(_top+1,0);
              /* _top := _bot + 999 */
              _top = CPLib.Round(_bot+999,0);
            } // End If
          } // End If
          // * --- Select from db_opextrbo
          m_cServer = m_Ctx.GetServer("db_opextrbo");
          m_cPhName = m_Ctx.GetPhName("db_opextrbo");
          if (Cursor_db_opextrbo!=null)
            Cursor_db_opextrbo.Close();
          Cursor_db_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PROGOPEX >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_bot,"?",0,0,m_cServer, m_oParameters),m_cServer,_bot)+"  and  PROGOPEX <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+" "+")"+(m_Ctx.IsSharedTemp("db_opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_db_opextrbo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Operazioni Extraconto' // Messaggio Import */
            gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Operazioni Extraconto";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _prgopx := 0 */
            _prgopx = CPLib.Round(0,0);
            // * --- Read from opextrbo
            m_cServer = m_Ctx.GetServer("opextrbo");
            m_cPhName = m_Ctx.GetPhName("opextrbo");
            m_cSql = "";
            m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(Cursor_db_opextrbo.GetString("COLLEG")),"C",16,0,m_cServer),m_cServer,CPLib.Upper(Cursor_db_opextrbo.GetString("COLLEG")));
            m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_db_opextrbo.GetString("ANNO"),"C",4,0,m_cServer),m_cServer,Cursor_db_opextrbo.GetString("ANNO"));
            if (m_Ctx.IsSharedTemp("opextrbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROGOPEX",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _prgopx = CPLib.Round(Read_Cursor.GetDouble("PROGOPEX"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_import_dbtodb returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _prgopx = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If _prgopx = 0 */
            if (CPLib.eqr(_prgopx,0)) {
              // * --- Insert into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"000000CC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000CC(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_db_opextrbo.GetString("COLLEG")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("ANNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("NOTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetDouble("PROGOPEX"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetDouble("SALDO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetDouble("QUANTITA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("UNIQUER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("OLDINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetDate("DATAMODI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetDouble("INVIATO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetDate("DATAINVIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetDouble("ANNULLA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetDate("DATAANNU"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("OLDUNIQUE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetDate("DATAOLDUNI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("IDESITO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetDouble("INVSALDO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetDate("DTSALDO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_opextrbo.GetString("CFESTERO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"opextrbo",true);
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
            Cursor_db_opextrbo.Next();
          }
          m_cConnectivityError = Cursor_db_opextrbo.ErrorMessage();
          Cursor_db_opextrbo.Close();
          // * --- End Select
          /* _pci := _pci + 1 */
          _pci = CPLib.Round(_pci+1,0);
        } // End While
        /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Operazioni Extraconto' + NL */
        gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Operazioni Extraconto"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
        /* gMsgProc := gMsgProc + 'Elaborazione terminata con errori. Import abortito' + NL */
        gMsgProc = gMsgProc+"Elaborazione terminata con errori. Import abortito"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000AAstatus,0)) {
          m_Sql.SetTransactionStatus(nTry000000AAstatus,cTry000000AAmsg);
        }
      }
      /* If _pci  > _cicli */
      if (CPLib.gt(_pci,_cicli)) {
      } else { // Else
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni Extraconto' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni Extraconto"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Operazioni Extraconto' // Messaggio Import */
      gMsgImp = "Fine importazione del file Operazioni Extraconto";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_qbe_db_opextrbo_minmax!=null)
          Cursor_qbe_db_opextrbo_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_db_opextrbo!=null)
          Cursor_db_opextrbo.Close();
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
    CPResultSet Cursor_qbe_db_fraziobo_minmax=null;
    CPResultSet Cursor_db_fraziobo=null;
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_db_operazbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Operazioni Extraconto */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Frazionate' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Frazionate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000000D8status;
      nTry000000D8status = m_Sql.GetTransactionStatus();
      String cTry000000D8msg;
      cTry000000D8msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Delete from fraziobo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("fraziobo");
        m_cPhName = m_Ctx.GetPhName("fraziobo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"000000DA")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* _maxfon := 0 */
        _maxfon = CPLib.Round(0,0);
        // * --- Select from qbe_db_fraziobo_minmax
        if (Cursor_qbe_db_fraziobo_minmax!=null)
          Cursor_qbe_db_fraziobo_minmax.Close();
        Cursor_qbe_db_fraziobo_minmax = new VQRHolder("qbe_db_fraziobo_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_db_fraziobo_minmax.Eof())) {
          /* _min := qbe_db_fraziobo_minmax->MINPRG */
          _min = CPLib.Round(Cursor_qbe_db_fraziobo_minmax.GetDouble("MINPRG"),0);
          /* _max := qbe_db_fraziobo_minmax->MAXPRG */
          _max = CPLib.Round(Cursor_qbe_db_fraziobo_minmax.GetDouble("MAXPRG"),0);
          /* _tot := qbe_db_fraziobo_minmax->TOTPRG */
          _tot = CPLib.Round(Cursor_qbe_db_fraziobo_minmax.GetDouble("TOTPRG"),0);
          Cursor_qbe_db_fraziobo_minmax.Next();
        }
        m_cConnectivityError = Cursor_qbe_db_fraziobo_minmax.ErrorMessage();
        Cursor_qbe_db_fraziobo_minmax.Close();
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
          /* _cicli := iif(Mod(_reccount,1000) <> 0,Int(_reccount/1000) + 1,Int(_reccount/1000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,1000),0)?CPLib.Int(_reccount/1000)+1:CPLib.Int(_reccount/1000)),0);
        } // End If
        /* _pci := 1 */
        _pci = CPLib.Round(1,0);
        /* While _pci <= _cicli */
        while (CPLib.le(_pci,_cicli)) {
          /* If _mono = 1 */
          if (CPLib.eqr(_mono,1)) {
            /* _bot := _min */
            _bot = CPLib.Round(_min,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* If _pci=1 */
            if (CPLib.eqr(_pci,1)) {
              /* _bot := _min */
              _bot = CPLib.Round(_min,0);
              /* _top := _min + 999 */
              _top = CPLib.Round(_min+999,0);
              /* ElseIf _pci = _cicli */
            } else if (CPLib.eqr(_pci,_cicli)) {
              /* _bot := _top + 1 */
              _bot = CPLib.Round(_top+1,0);
              /* _top := _max */
              _top = CPLib.Round(_max,0);
            } else { // Else
              /* _bot := _top + 1 */
              _bot = CPLib.Round(_top+1,0);
              /* _top := _bot + 999 */
              _top = CPLib.Round(_bot+999,0);
            } // End If
          } // End If
          // * --- Select from db_fraziobo
          m_cServer = m_Ctx.GetServer("db_fraziobo");
          m_cPhName = m_Ctx.GetPhName("db_fraziobo");
          if (Cursor_db_fraziobo!=null)
            Cursor_db_fraziobo.Close();
          Cursor_db_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PRGIMPFRZ >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_bot,"?",0,0,m_cServer, m_oParameters),m_cServer,_bot)+"  and  PRGIMPFRZ <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+" "+")"+(m_Ctx.IsSharedTemp("db_fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_db_fraziobo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Frazionate' // Messaggio Import */
            gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Frazionate";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            // * --- Insert into fraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"000000F7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000F7(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_db_fraziobo.GetString("CONNESCLI")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("PRGIMPFRZ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDate("DATAIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("ANNOOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("IDBASE2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("IMPIN"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("IMPOUT"),"?",0,0)+", ";
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
              throw new RoutineException();
            }
            Cursor_db_fraziobo.Next();
          }
          m_cConnectivityError = Cursor_db_fraziobo.ErrorMessage();
          Cursor_db_fraziobo.Close();
          // * --- End Select
          /* _pci := _pci + 1 */
          _pci = CPLib.Round(_pci+1,0);
        } // End While
        /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Frazionate' + NL */
        gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Frazionate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Delete from personbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"000000FB")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* _maxfon := 0 */
        _maxfon = CPLib.Round(0,0);
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000000FE;
        _h000000FE = new SPBridge.HMCaller();
        _h000000FE.Set("m_cVQRList",m_cVQRList);
        _h000000FE.Set("tbname","db_personbo");
        _h000000FE.Set("fldname","db_operazbo.PRGIMPOPE");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000FE,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* _min := qbe_db_fraziobo_minmax->MINPRG */
          _min = CPLib.Round(Cursor_qbe_db_fraziobo_minmax.GetDouble("MINPRG"),0);
          /* _max := qbe_db_fraziobo_minmax->MAXPRG */
          _max = CPLib.Round(Cursor_qbe_db_fraziobo_minmax.GetDouble("MAXPRG"),0);
          /* _tot := qbe_db_fraziobo_minmax->TOTPRG */
          _tot = CPLib.Round(Cursor_qbe_db_fraziobo_minmax.GetDouble("TOTPRG"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
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
          /* _cicli := iif(Mod(_reccount,1000) <> 0,Int(_reccount/1000) + 1,Int(_reccount/1000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,1000),0)?CPLib.Int(_reccount/1000)+1:CPLib.Int(_reccount/1000)),0);
        } // End If
        /* _pci := 1 */
        _pci = CPLib.Round(1,0);
        /* While _pci <= _cicli */
        while (CPLib.le(_pci,_cicli)) {
          /* If _mono = 1 */
          if (CPLib.eqr(_mono,1)) {
            /* _bot := _min */
            _bot = CPLib.Round(_min,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* If _pci=1 */
            if (CPLib.eqr(_pci,1)) {
              /* _bot := _min */
              _bot = CPLib.Round(_min,0);
              /* _top := _min + 999 */
              _top = CPLib.Round(_min+999,0);
              /* ElseIf _pci = _cicli */
            } else if (CPLib.eqr(_pci,_cicli)) {
              /* _bot := _top + 1 */
              _bot = CPLib.Round(_top+1,0);
              /* _top := _max */
              _top = CPLib.Round(_max,0);
            } else { // Else
              /* _bot := _top + 1 */
              _bot = CPLib.Round(_top+1,0);
              /* _top := _bot + 999 */
              _top = CPLib.Round(_bot+999,0);
            } // End If
          } // End If
          // * --- Select from db_operazbo
          m_cServer = m_Ctx.GetServer("db_operazbo");
          m_cPhName = m_Ctx.GetPhName("db_operazbo");
          if (Cursor_db_operazbo!=null)
            Cursor_db_operazbo.Close();
          Cursor_db_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PRGIMPFRZ >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_bot,"?",0,0,m_cServer, m_oParameters),m_cServer,_bot)+"  and  PRGIMPFRZ <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+" "+")"+(m_Ctx.IsSharedTemp("db_operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_db_operazbo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Frazionate' // Messaggio Import */
            gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Frazionate";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            // * --- Insert into fraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dbtodb",709,"00000118")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000118(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_db_fraziobo.GetString("CONNESCLI")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("PRGIMPFRZ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDate("DATAIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("ANNOOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetString("IDBASE2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("IMPIN"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_db_fraziobo.GetDouble("IMPOUT"),"?",0,0)+", ";
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
              throw new RoutineException();
            }
            Cursor_db_operazbo.Next();
          }
          m_cConnectivityError = Cursor_db_operazbo.ErrorMessage();
          Cursor_db_operazbo.Close();
          // * --- End Select
          /* _pci := _pci + 1 */
          _pci = CPLib.Round(_pci+1,0);
        } // End While
        /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Frazionate' + NL */
        gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Frazionate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
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
        /* gMsgProc := gMsgProc + 'Elaborazione terminata con errori. Import abortito' + NL */
        gMsgProc = gMsgProc+"Elaborazione terminata con errori. Import abortito"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000D8status,0)) {
          m_Sql.SetTransactionStatus(nTry000000D8status,cTry000000D8msg);
        }
      }
      /* If _pci  > _cicli */
      if (CPLib.gt(_pci,_cicli)) {
      } else { // Else
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Frazionate' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Frazionate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Frazionate' // Messaggio Import */
      gMsgImp = "Fine importazione del file Frazionate";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_qbe_db_fraziobo_minmax!=null)
          Cursor_qbe_db_fraziobo_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_db_fraziobo!=null)
          Cursor_db_fraziobo.Close();
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
      try {
        if (Cursor_db_operazbo!=null)
          Cursor_db_operazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_6() throws Exception {
    /* --Rapporti + Informazioni (Storico) */
  }
  void Page_7() throws Exception {
    /* --Rapporti + Informazioni (AUI) */
  }
  void Page_8() throws Exception {
    /* --Rapporti + Informazioni (AGE) */
  }
  void Page_9() throws Exception {
    /* --Anagrafe Rapporti */
  }
  void Page_10() throws Exception {
    /* --Deleghe + Oper. Extra */
  }
  void Page_11() throws Exception {
    /* Operaz. + Frazio. (Storico) */
  }
  void Page_12() throws Exception {
    /* --Rapporti + Informazioni (AUI) P */
  }
  void Page_13() throws Exception {
    /* --Operazioni + Frazionate P */
  }
  void Page_14() throws Exception {
    /* --Titolari Effettivi */
  }
  void Page_15() throws Exception {
    /* --Titolari Effettivi P */
  }
  void Page_16() throws Exception {
    /* --Titolari Effettivi (Storico) */
  }
  void Page_17() throws Exception {
    /* Saldi (AGE) */
  }
  void Page_18() throws Exception {
    /* --Garantiti */
  }
  void _init_() {
  }
  public String RunAsync(String p_pOper,String p_pFlg) {
    pOper = p_pOper;
    pFlg = p_pFlg;
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
  public Forward Run(String p_pOper,String p_pFlg) {
    pOper = p_pOper;
    pFlg = p_pFlg;
    return Run();
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
      m_Caller.SetString("msgproc","M",10,0,w_msgproc);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_import_dbtodbR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_dbtodbR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pOper = CPLib.Space(1);
    pFlg = CPLib.Space(1);
    w_msgproc = m_Caller.GetString("msgproc","M",10,0);
    conta = 0;
    cSNAS = CPLib.Space(30);
    cCNAS = CPLib.Space(30);
    _tipper = CPLib.Space(1);
    nProgImp = 0;
    nProgImp2 = 0;
    cProgSto = CPLib.Space(15);
    _numrig = 0;
    _connes = CPLib.Space(16);
    _nocodfis = 0;
    _maxfo = CPLib.Space(11);
    _maxfon = 0;
    _top = 0;
    _topl = CPLib.Space(11);
    _bot = 0;
    _botl = CPLib.Space(11);
    _cicli = 0;
    _pci = 0;
    _dataret = CPLib.NullDate();
    _dataimp = CPLib.NullDate();
    _datamin = CPLib.NullDate();
    _codinter = CPLib.Space(11);
    cProg = CPLib.Space(10);
    cCanc = CPLib.Space(10);
    _codrap = CPLib.Space(25);
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _reccount = 0;
    _prgopx = 0;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_db_personbo_minmax,qbe_db_opextrbo_minmax,qbe_db_fraziobo_minmax,qbe_tab_mmc,
  public static final String m_cVQRList = ",qbe_db_personbo_minmax,qbe_db_opextrbo_minmax,qbe_db_fraziobo_minmax,qbe_tab_mmc,";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pOper","pFlg"};
  protected static String GetFieldsName_0000004A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+"desccode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000059(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"IDCITTA,";
    p_cSql = p_cSql+"SUPPLEM,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DBPROT,";
    p_cSql = p_cSql+"F_INGLESE,";
    p_cSql = p_cSql+"CONTATORE,";
    p_cSql = p_cSql+"PATHAPP,";
    p_cSql = p_cSql+"URLAPPL,";
    p_cSql = p_cSql+"FLGLOG,";
    p_cSql = p_cSql+"FLGAOS,";
    p_cSql = p_cSql+"AEPATH,";
    p_cSql = p_cSql+"MOLTI,";
    p_cSql = p_cSql+"FLGEAOS,";
    p_cSql = p_cSql+"FLGCDOC,";
    p_cSql = p_cSql+"FLGFRAZ,";
    p_cSql = p_cSql+"FLGAPERS,";
    p_cSql = p_cSql+"DTINIATT,";
    p_cSql = p_cSql+"FLGTIPIMP,";
    p_cSql = p_cSql+"FLGSTPCON,";
    p_cSql = p_cSql+"FLGIMPAGE,";
    p_cSql = p_cSql+"CFINVIO,";
    p_cSql = p_cSql+"CAFINVIO,";
    p_cSql = p_cSql+"FILEINVIO,";
    p_cSql = p_cSql+"DATAINVIO,";
    p_cSql = p_cSql+"FLGWU,";
    p_cSql = p_cSql+"IMPINTOPE,";
    p_cSql = p_cSql+"GGYELWAR,";
    p_cSql = p_cSql+"GGREDWAR,";
    p_cSql = p_cSql+"FLGOPEXTR,";
    p_cSql = p_cSql+"SKT_SERVER,";
    p_cSql = p_cSql+"SKT_PORT,";
    p_cSql = p_cSql+"SKT_PATHS,";
    p_cSql = p_cSql+"SKT_MODET,";
    p_cSql = p_cSql+"RASPAUI,";
    p_cSql = p_cSql+"RESPAUI,";
    p_cSql = p_cSql+"TESTIP,";
    p_cSql = p_cSql+"FLGDATAIM,";
    p_cSql = p_cSql+"FLGDATATP,";
    p_cSql = p_cSql+"LIMITVLT,";
    p_cSql = p_cSql+"LIMITVNP,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"FLGSTPDIR,";
    p_cSql = p_cSql+"PATRONO,";
    p_cSql = p_cSql+"NODOM,";
    p_cSql = p_cSql+"NOSAB,";
    p_cSql = p_cSql+"CODINTER2,";
    p_cSql = p_cSql+"NUMINTER2,";
    p_cSql = p_cSql+"IMPINTER2,";
    p_cSql = p_cSql+"DATAINTER,";
    p_cSql = p_cSql+"TPSOFTAE,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"PROVNA,";
    p_cSql = p_cSql+"F_LOG,";
    p_cSql = p_cSql+"IMPPATH,";
    p_cSql = p_cSql+"PRGAEPATH,";
    p_cSql = p_cSql+"CODAGE,";
    p_cSql = p_cSql+"FLGCHK,";
    p_cSql = p_cSql+"FLGNODOC,";
    p_cSql = p_cSql+"DATAINTER2,";
    p_cSql = p_cSql+"IDSID,";
    p_cSql = p_cSql+"SIDPASS,";
    p_cSql = p_cSql+"FLGSIDAUTO,";
    p_cSql = p_cSql+"PATHSID,";
    p_cSql = p_cSql+"PATHJAVA,";
    p_cSql = p_cSql+"TIPOINST,";
    p_cSql = p_cSql+"SNAISTOR,";
    p_cSql = p_cSql+"LIMITEFRZ,";
    p_cSql = p_cSql+"FRAZDEL,";
    p_cSql = p_cSql+"FLGRAPCLI,";
    p_cSql = p_cSql+"FILEDAPRED,";
    p_cSql = p_cSql+"FILEESITI,";
    p_cSql = p_cSql+"FILEPRED,";
    p_cSql = p_cSql+"RICEVUTE,";
    p_cSql = p_cSql+"RICESITI,";
    p_cSql = p_cSql+"RICFATTE,";
    p_cSql = p_cSql+"PATHCERT,";
    p_cSql = p_cSql+"ESCLUDI0,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"OPGTIPO,";
    p_cSql = p_cSql+"NUMGIORN,";
    p_cSql = p_cSql+"SOLOFRAZ,";
    p_cSql = p_cSql+"SOLOPERS,";
    p_cSql = p_cSql+"CODORO,";
    p_cSql = p_cSql+"FLGSCDFRZ,";
    p_cSql = p_cSql+"FLGRITORNO,";
    p_cSql = p_cSql+"SBLRITORNO,";
    p_cSql = p_cSql+"FLGCREAAGE,";
    p_cSql = p_cSql+"DNASC,";
    p_cSql = p_cSql+"COMNASC,";
    p_cSql = p_cSql+"PRNASC,";
    p_cSql = p_cSql+"CITTADINA,";
    p_cSql = p_cSql+"SOGCOM,";
    p_cSql = p_cSql+"CAMBI,";
    p_cSql = p_cSql+"AGGAGE,";
    p_cSql = p_cSql+"DTTITAGE,";
    p_cSql = p_cSql+"SCADSALDI,";
    p_cSql = p_cSql+"FLGIPMT,";
    p_cSql = p_cSql+"GIORNIFRZ,";
    p_cSql = p_cSql+"MINFRZSNAI,";
    p_cSql = p_cSql+"ALTSRVMAIL,";
    p_cSql = p_cSql+"ALTPRTMAIL,";
    p_cSql = p_cSql+"ALTEMLMAIL,";
    p_cSql = p_cSql+"ALTUSRMAIL,";
    p_cSql = p_cSql+"ALTPWDMAIL,";
    p_cSql = p_cSql+"FLGGESDOC,";
    p_cSql = p_cSql+"USRGESDOC,";
    p_cSql = p_cSql+"PWDGESDOC,";
    p_cSql = p_cSql+"URLDESDOC,";
    p_cSql = p_cSql+"EMAILDOC,";
    p_cSql = p_cSql+"DATADOC,";
    p_cSql = p_cSql+"FLGDDOC,";
    p_cSql = p_cSql+"FLGLIGHT,";
    p_cSql = p_cSql+"FLGCGOPWD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intermbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000069(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"IDCITTA,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"AGENTE,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"TERMINALID,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"CODLOC,";
    p_cSql = p_cSql+"ABICABSARA,";
    p_cSql = p_cSql+"NUOVO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"AGACCODE,";
    p_cSql = p_cSql+"NAZAGENTE,";
    p_cSql = p_cSql+"OPXSOSCLI,";
    p_cSql = p_cSql+"OPXSOSAGE,";
    p_cSql = p_cSql+"VALCOMPL,";
    p_cSql = p_cSql+"ANOMOPER,";
    p_cSql = p_cSql+"AGEREGIO,";
    p_cSql = p_cSql+"FLGATT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anadip",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000096(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"idcitta,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"OLDCONNES,";
    p_cSql = p_cSql+"DATEXTRA,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"RAGSOCOLD,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PROGIMP_C,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"SPOTID,";
    p_cSql = p_cSql+"DATASEGN,";
    p_cSql = p_cSql+"OLDSETSIN,";
    p_cSql = p_cSql+"DATAVARAGE,";
    p_cSql = p_cSql+"SETTSINT2,";
    p_cSql = p_cSql+"FATCA,";
    p_cSql = p_cSql+"BANCABEN,";
    p_cSql = p_cSql+"TIN,";
    p_cSql = p_cSql+"ODB,";
    p_cSql = p_cSql+"TELEF,";
    p_cSql = p_cSql+"TIPOORO,";
    p_cSql = p_cSql+"CODORO,";
    p_cSql = p_cSql+"IDNASCOMUN,";
    p_cSql = p_cSql+"IDNASSTATO,";
    p_cSql = p_cSql+"NOTIT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"sanumpro,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"idcitta,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"OLDCONNES,";
    p_cSql = p_cSql+"DATEXTRA,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"RAGSOCOLD,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PROGIMP_C,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"datamodi,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"SPOTID,";
    p_cSql = p_cSql+"DATASEGN,";
    p_cSql = p_cSql+"OLDSETSIN,";
    p_cSql = p_cSql+"DATAVARAGE,";
    p_cSql = p_cSql+"SETTSINT2,";
    p_cSql = p_cSql+"FATCA,";
    p_cSql = p_cSql+"BANCABEN,";
    p_cSql = p_cSql+"TIN,";
    p_cSql = p_cSql+"ODB,";
    p_cSql = p_cSql+"TELEF,";
    p_cSql = p_cSql+"TIPOORO,";
    p_cSql = p_cSql+"CODORO,";
    p_cSql = p_cSql+"IDNASCOMUN,";
    p_cSql = p_cSql+"IDNASSTATO,";
    p_cSql = p_cSql+"NOTIT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"PROGOPEX,";
    p_cSql = p_cSql+"SALDO,";
    p_cSql = p_cSql+"QUANTITA,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"UNIQUER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"OLDINTER,";
    p_cSql = p_cSql+"DATAMODI,";
    p_cSql = p_cSql+"INVIATO,";
    p_cSql = p_cSql+"DATAINVIO,";
    p_cSql = p_cSql+"ANNULLA,";
    p_cSql = p_cSql+"DATAANNU,";
    p_cSql = p_cSql+"OLDUNIQUE,";
    p_cSql = p_cSql+"DATAOLDUNI,";
    p_cSql = p_cSql+"IDESITO,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"INVSALDO,";
    p_cSql = p_cSql+"DTSALDO,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000118(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
}
