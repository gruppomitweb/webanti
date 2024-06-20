// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_import_mitantiR implements CallerWithObjs {
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
  public String m_cPhName_f_storicoxbrl;
  public String m_cServer_f_storicoxbrl;
  public String m_cPhName_storicoxbrl;
  public String m_cServer_storicoxbrl;
  public String m_cPhName_f_storicoxbrl_dett;
  public String m_cServer_f_storicoxbrl_dett;
  public String m_cPhName_storicoxbrl_dett;
  public String m_cServer_storicoxbrl_dett;
  public String m_cPhName_f_aefaminvio;
  public String m_cServer_f_aefaminvio;
  public String m_cPhName_aefaminvio;
  public String m_cServer_aefaminvio;
  public String m_cPhName_f_operazbo_agg;
  public String m_cServer_f_operazbo_agg;
  public String m_cPhName_operazbo_agg;
  public String m_cServer_operazbo_agg;
  public String m_cPhName_f_fraziobo_agg;
  public String m_cServer_f_fraziobo_agg;
  public String m_cPhName_fraziobo_agg;
  public String m_cServer_fraziobo_agg;
  public String m_cPhName_f_personbo_agg;
  public String m_cServer_f_personbo_agg;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_f_wersonbo_agg;
  public String m_cServer_f_wersonbo_agg;
  public String m_cPhName_wersonbo_agg;
  public String m_cServer_wersonbo_agg;
  public String m_cPhName_qbe_f_aeoprig_totale;
  public String m_cServer_qbe_f_aeoprig_totale;
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
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String _oldrapporto;
  public double _maxprg;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_import_mitantiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_import_mitanti",m_Caller);
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
    m_cPhName_f_storicoxbrl = p_ContextObject.GetPhName("f_storicoxbrl");
    if (m_cPhName_f_storicoxbrl.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_storicoxbrl = m_cPhName_f_storicoxbrl+" "+m_Ctx.GetWritePhName("f_storicoxbrl");
    }
    m_cServer_f_storicoxbrl = p_ContextObject.GetServer("f_storicoxbrl");
    m_cPhName_storicoxbrl = p_ContextObject.GetPhName("storicoxbrl");
    if (m_cPhName_storicoxbrl.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_storicoxbrl = m_cPhName_storicoxbrl+" "+m_Ctx.GetWritePhName("storicoxbrl");
    }
    m_cServer_storicoxbrl = p_ContextObject.GetServer("storicoxbrl");
    m_cPhName_f_storicoxbrl_dett = p_ContextObject.GetPhName("f_storicoxbrl_dett");
    if (m_cPhName_f_storicoxbrl_dett.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_storicoxbrl_dett = m_cPhName_f_storicoxbrl_dett+" "+m_Ctx.GetWritePhName("f_storicoxbrl_dett");
    }
    m_cServer_f_storicoxbrl_dett = p_ContextObject.GetServer("f_storicoxbrl_dett");
    m_cPhName_storicoxbrl_dett = p_ContextObject.GetPhName("storicoxbrl_dett");
    if (m_cPhName_storicoxbrl_dett.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_storicoxbrl_dett = m_cPhName_storicoxbrl_dett+" "+m_Ctx.GetWritePhName("storicoxbrl_dett");
    }
    m_cServer_storicoxbrl_dett = p_ContextObject.GetServer("storicoxbrl_dett");
    m_cPhName_f_aefaminvio = p_ContextObject.GetPhName("f_aefaminvio");
    if (m_cPhName_f_aefaminvio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_aefaminvio = m_cPhName_f_aefaminvio+" "+m_Ctx.GetWritePhName("f_aefaminvio");
    }
    m_cServer_f_aefaminvio = p_ContextObject.GetServer("f_aefaminvio");
    m_cPhName_aefaminvio = p_ContextObject.GetPhName("aefaminvio");
    if (m_cPhName_aefaminvio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefaminvio = m_cPhName_aefaminvio+" "+m_Ctx.GetWritePhName("aefaminvio");
    }
    m_cServer_aefaminvio = p_ContextObject.GetServer("aefaminvio");
    m_cPhName_f_operazbo_agg = p_ContextObject.GetPhName("f_operazbo_agg");
    if (m_cPhName_f_operazbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_operazbo_agg = m_cPhName_f_operazbo_agg+" "+m_Ctx.GetWritePhName("f_operazbo_agg");
    }
    m_cServer_f_operazbo_agg = p_ContextObject.GetServer("f_operazbo_agg");
    m_cPhName_operazbo_agg = p_ContextObject.GetPhName("operazbo_agg");
    if (m_cPhName_operazbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo_agg = m_cPhName_operazbo_agg+" "+m_Ctx.GetWritePhName("operazbo_agg");
    }
    m_cServer_operazbo_agg = p_ContextObject.GetServer("operazbo_agg");
    m_cPhName_f_fraziobo_agg = p_ContextObject.GetPhName("f_fraziobo_agg");
    if (m_cPhName_f_fraziobo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_fraziobo_agg = m_cPhName_f_fraziobo_agg+" "+m_Ctx.GetWritePhName("f_fraziobo_agg");
    }
    m_cServer_f_fraziobo_agg = p_ContextObject.GetServer("f_fraziobo_agg");
    m_cPhName_fraziobo_agg = p_ContextObject.GetPhName("fraziobo_agg");
    if (m_cPhName_fraziobo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo_agg = m_cPhName_fraziobo_agg+" "+m_Ctx.GetWritePhName("fraziobo_agg");
    }
    m_cServer_fraziobo_agg = p_ContextObject.GetServer("fraziobo_agg");
    m_cPhName_f_personbo_agg = p_ContextObject.GetPhName("f_personbo_agg");
    if (m_cPhName_f_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_personbo_agg = m_cPhName_f_personbo_agg+" "+m_Ctx.GetWritePhName("f_personbo_agg");
    }
    m_cServer_f_personbo_agg = p_ContextObject.GetServer("f_personbo_agg");
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_f_wersonbo_agg = p_ContextObject.GetPhName("f_wersonbo_agg");
    if (m_cPhName_f_wersonbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_wersonbo_agg = m_cPhName_f_wersonbo_agg+" "+m_Ctx.GetWritePhName("f_wersonbo_agg");
    }
    m_cServer_f_wersonbo_agg = p_ContextObject.GetServer("f_wersonbo_agg");
    m_cPhName_wersonbo_agg = p_ContextObject.GetPhName("wersonbo_agg");
    if (m_cPhName_wersonbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo_agg = m_cPhName_wersonbo_agg+" "+m_Ctx.GetWritePhName("wersonbo_agg");
    }
    m_cServer_wersonbo_agg = p_ContextObject.GetServer("wersonbo_agg");
    m_cPhName_qbe_f_aeoprig_totale = p_ContextObject.GetPhName("qbe_f_aeoprig_totale");
    if (m_cPhName_qbe_f_aeoprig_totale.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_qbe_f_aeoprig_totale = m_cPhName_qbe_f_aeoprig_totale+" "+m_Ctx.GetWritePhName("qbe_f_aeoprig_totale");
    }
    m_cServer_qbe_f_aeoprig_totale = p_ContextObject.GetServer("qbe_f_aeoprig_totale");
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
    if (CPLib.eqr("_maxprg",p_cVarName)) {
      return _maxprg;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_import_mitanti";
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
    if (CPLib.eqr("_oldrapporto",p_cVarName)) {
      return _oldrapporto;
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
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
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
    if (CPLib.eqr("_maxprg",p_cVarName)) {
      _maxprg = value;
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
    if (CPLib.eqr("_oldrapporto",p_cVarName)) {
      _oldrapporto = value;
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
    /* Parametro */
    /* pOper Char(1) */
    /* pFlg Char(1) */
    /* Dichiarazione variabili del caller */
    /* w_msgproc Memo */
    /* Definizione variabili locali */
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
    double nTry0000002Bstatus;
    nTry0000002Bstatus = m_Sql.GetTransactionStatus();
    String cTry0000002Bmsg;
    cTry0000002Bmsg = m_Sql.TransactionErrorMessage();
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
        /* Exec "Rapporti + Informazioni" Page 4:Page_4 */
        Page_4();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case pOper='O' */
      } else if (CPLib.eqr(pOper,"O")) {
        /* Exec "Frazionate + Operazioni" Page 5:Page_5 */
        Page_5();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case pOper='T' */
      } else if (CPLib.eqr(pOper,"T")) {
        /* Exec "Titolari" Page 6:Page_6 */
        Page_6();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case pOper='G' */
      } else if (CPLib.eqr(pOper,"G")) {
        /* Exec "Rapporti (AGE)" Page 7:Page_7 */
        Page_7();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case pOper='A' */
      } else if (CPLib.eqr(pOper,"A")) {
        /* Exec "Anagrafe Rapporti" Page 8:Page_8 */
        Page_8();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case pOper='D' */
      } else if (CPLib.eqr(pOper,"D")) {
        /* Exec "Deleghe + OPEX (AGE)" Page 9:Page_9 */
        Page_9();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case pOper='X' */
      } else if (CPLib.eqr(pOper,"X")) {
        /* Exec "Rapporti AUI (P)" Page 10:Page_10 */
        Page_10();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case pOper='Y' */
      } else if (CPLib.eqr(pOper,"Y")) {
        /* Exec "Operazioni + Frazionate (P)" Page 11:Page_11 */
        Page_11();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case pOper='Z' */
      } else if (CPLib.eqr(pOper,"Z")) {
        /* Exec "Titolari (P)" Page 12:Page_12 */
        Page_12();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case pOper='S' */
      } else if (CPLib.eqr(pOper,"S")) {
        /* Exec "Saldi AGE" Page 15:Page_15 */
        Page_15();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case pOper='E' */
      } else if (CPLib.eqr(pOper,"E")) {
        /* Exec "Operazioni Extraconto" Page 13:Page_13 */
        Page_13();
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
        /* Exec "Rapporti + Informazioni" Page 4:Page_4 */
        Page_4();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Si importa prima da storico dove sono le vecchie operazioni. Non spostare altrimenti salta l'aggiornamento dei contatori. */
        /* Exec "Operazioni + Frazionate (S)" Page 14:Page_14 */
        Page_14();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Frazionate + Operazioni" Page 5:Page_5 */
        Page_5();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Titolari" Page 6:Page_6 */
        Page_6();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Rapporti (AGE)" Page 7:Page_7 */
        Page_7();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Anagrafe Rapporti" Page 8:Page_8 */
        Page_8();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Deleghe + OPEX (AGE)" Page 9:Page_9 */
        Page_9();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Rapporti AUI (P)" Page 10:Page_10 */
        Page_10();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Operazioni + Frazionate (P)" Page 11:Page_11 */
        Page_11();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Titolari (P)" Page 12:Page_12 */
        Page_12();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Operazioni Extraconto" Page 13:Page_13 */
        Page_13();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Saldi AGE" Page 15:Page_15 */
        Page_15();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Garantiti" Page 16:Page_16 */
        Page_16();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Storico XBRL" Page 17:Page_17 */
        Page_17();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case pOper='1' */
      } else if (CPLib.eqr(pOper,"1")) {
        /* Exec "Storico XBRL" Page 17:Page_17 */
        Page_17();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case pOper='2' */
      } else if (CPLib.eqr(pOper,"2")) {
        /* Exec "Operazioni + Frazionate (S)" Page 14:Page_14 */
        Page_14();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case pOper='3' */
      } else if (CPLib.eqr(pOper,"3")) {
        /* Exec "Supporto AGE" Page 18:Page_18 */
        Page_18();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case pOper='J' */
      } else if (CPLib.eqr(pOper,"J")) {
        /* Exec "Garantiti" Page 16:Page_16 */
        Page_16();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
      } // End Case
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
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000002Bstatus,0)) {
        m_Sql.SetTransactionStatus(nTry0000002Bstatus,cTry0000002Bmsg);
      }
    }
    /* gMsgImp := 'Fine Elaborazione' // Messaggio Import */
    gMsgImp = "Fine Elaborazione";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_f_intermbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_f_inter2bo=null;
    CPResultSet Cursor_f_anadip=null;
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
      // * --- Select from f_intermbo
      m_cServer = m_Ctx.GetServer("f_intermbo");
      m_cPhName = m_Ctx.GetPhName("f_intermbo");
      if (Cursor_f_intermbo!=null)
        Cursor_f_intermbo.Close();
      Cursor_f_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_intermbo.Eof())) {
        /* If not(Empty(f_intermbo->CODINTER)) */
        if ( ! (CPLib.Empty(Cursor_f_intermbo.GetString("CODINTER")))) {
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
          m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_f_intermbo.GetString("CODINTER"),"C",11,0,m_cServer),m_cServer,Cursor_f_intermbo.GetString("CODINTER"));
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
              Error l_oErrorFault = new Error("Read on intermbo into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
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
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000005D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000005D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetDate("DATANASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_intermbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_intermbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_intermbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetDate("DATARILASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_intermbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_intermbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("SUPPLEM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("DBPROT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetDouble("CONTATORE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("AEPATH"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetDouble("MOLTI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("CODINTER2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("NUMINTER2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("IMPINTER2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetDate("DATAINTER2"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intermbo.GetString("IDSID"),"?",0,0,m_cServer)+", ";
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
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000005E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"AEPATH = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("AEPATH"),"C",250,0,m_cServer)+", ";
            m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQLNull(Cursor_f_intermbo.GetString("CODDIPE"),"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODINTER2 = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("CODINTER2"),"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"CONNES = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("CONNES"),"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"CONTATORE = "+CPLib.ToSQL(Cursor_f_intermbo.GetDouble("CONTATORE"),"N",15,0)+", ";
            m_cSql = m_cSql+"DATAINTER2 = "+CPLib.ToSQL(Cursor_f_intermbo.GetDate("DATAINTER2"),"D",8,0)+", ";
            m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_f_intermbo.GetDate("DATANASC"),"D",8,0)+", ";
            m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_f_intermbo.GetDate("DATARILASC"),"D",8,0)+", ";
            m_cSql = m_cSql+"DBPROT = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("DBPROT"),"C",100,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
            m_cSql = m_cSql+"F_INGLESE = "+CPLib.ToSQL(Cursor_f_intermbo.GetDouble("F_INGLESE"),"N",1,0)+", ";
            m_cSql = m_cSql+"F_LOG = "+CPLib.ToSQL(Cursor_f_intermbo.GetDouble("F_LOG"),"N",1,0)+", ";
            m_cSql = m_cSql+"FLGDATAIM = "+CPLib.ToSQL(Cursor_f_intermbo.GetDouble("FLGDATAIM"),"N",1,0)+", ";
            m_cSql = m_cSql+"FLGDATATP = "+CPLib.ToSQL(Cursor_f_intermbo.GetDouble("FLGDATATP"),"N",1,0)+", ";
            m_cSql = m_cSql+"FLGSIDAUTO = "+CPLib.ToSQL(Cursor_f_intermbo.GetDouble("FLGSIDAUTO"),"N",1,0)+", ";
            m_cSql = m_cSql+"IDSID = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("IDSID"),"C",8,0,m_cServer)+", ";
            m_cSql = m_cSql+"IMPINTER2 = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("IMPINTER2"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"IMPPATH = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("IMPPATH"),"C",240,0,m_cServer)+", ";
            m_cSql = m_cSql+"MOLTI = "+CPLib.ToSQL(Cursor_f_intermbo.GetDouble("MOLTI"),"N",1,0)+", ";
            m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"NOCODFISC = "+CPLib.ToSQL(Cursor_f_intermbo.GetDouble("NOCODFISC"),"N",1,0)+", ";
            m_cSql = m_cSql+"NODOM = "+CPLib.ToSQL(Cursor_f_intermbo.GetDouble("NODOM"),"N",1,0)+", ";
            m_cSql = m_cSql+"NOSAB = "+CPLib.ToSQL(Cursor_f_intermbo.GetDouble("NOSAB"),"N",1,0)+", ";
            m_cSql = m_cSql+"NOTE = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("NOTE"),"M",10,0,m_cServer,m_oParameters)+", ";
            m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"NUMINTER2 = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("NUMINTER2"),"C",5,0,m_cServer)+", ";
            m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("PARTIVA"),"C",14,0,m_cServer)+", ";
            m_cSql = m_cSql+"PATRONO = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("PATRONO"),"C",4,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQLNull(Cursor_f_intermbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"SIDPASS = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("SIDPASS"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"SOSPMAF = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("SOSPMAF"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQLNull(Cursor_f_intermbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"SUPPLEM = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("SUPPLEM"),"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQLNull(Cursor_f_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQLNull(Cursor_f_intermbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(Cursor_f_intermbo.GetString("TIPOPERS"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"TPSOFTAE = "+CPLib.ToSQL(Cursor_f_intermbo.GetDouble("TPSOFTAE"),"N",1,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intermbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_f_intermbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_f_intermbo.GetString("CODINTER"))+"";
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
        Cursor_f_intermbo.Next();
      }
      m_cConnectivityError = Cursor_f_intermbo.ErrorMessage();
      Cursor_f_intermbo.Close();
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
      // * --- Select from f_inter2bo
      m_cServer = m_Ctx.GetServer("f_inter2bo");
      m_cPhName = m_Ctx.GetPhName("f_inter2bo");
      if (Cursor_f_inter2bo!=null)
        Cursor_f_inter2bo.Close();
      Cursor_f_inter2bo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_inter2bo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_inter2bo.Eof())) {
        /* If not(Empty(f_inter2bo->CODINTER)) */
        if ( ! (CPLib.Empty(Cursor_f_inter2bo.GetString("CODINTER")))) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Intermediari controparte' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Intermediari controparte";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _codinter := '' */
          _codinter = "";
          // * --- Read from inter2bo
          m_cServer = m_Ctx.GetServer("inter2bo");
          m_cPhName = m_Ctx.GetPhName("inter2bo");
          m_cSql = "";
          m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_f_inter2bo.GetString("CODINTER"),"C",11,0,m_cServer),m_cServer,Cursor_f_inter2bo.GetString("CODINTER"));
          if (m_Ctx.IsSharedTemp("inter2bo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODINTER",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _codinter = Read_Cursor.GetString("CODINTER");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on inter2bo into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
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
            // * --- Insert into inter2bo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("inter2bo");
            m_cPhName = m_Ctx.GetPhName("inter2bo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"inter2bo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000006C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000006C(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_inter2bo.GetDate("DATANASC")),"18991230")?CPLib.NullDate():Cursor_f_inter2bo.GetDate("DATANASC")),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_inter2bo.GetDate("DATARILASC")),"18991230")?CPLib.NullDate():Cursor_f_inter2bo.GetDate("DATARILASC")),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_inter2bo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inter2bo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"inter2bo",true);
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
            // * --- Write into inter2bo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("inter2bo");
            m_cPhName = m_Ctx.GetPhName("inter2bo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"inter2bo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000006D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_inter2bo.GetDate("DATANASC")),"18991230")?CPLib.NullDate():Cursor_f_inter2bo.GetDate("DATANASC")),"D",8,0)+", ";
            m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_inter2bo.GetDate("DATARILASC")),"18991230")?CPLib.NullDate():Cursor_f_inter2bo.GetDate("DATARILASC")),"D",8,0)+", ";
            m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("CAP"),"C",9,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQLNull(Cursor_f_inter2bo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("TIPOPERS"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"CONNES = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("CONNES"),"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("CODDIPE"),"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("PARTIVA"),"C",14,0,m_cServer)+", ";
            m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"SOSPMAF = "+CPLib.ToSQL(Cursor_f_inter2bo.GetString("SOSPMAF"),"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"inter2bo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_f_inter2bo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_f_inter2bo.GetString("CODINTER"))+"";
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
        Cursor_f_inter2bo.Next();
      }
      m_cConnectivityError = Cursor_f_inter2bo.ErrorMessage();
      Cursor_f_inter2bo.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Intermediari controparte' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Intermediari controparte"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Intermediari controparte' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Intermediari controparte"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Intermediari controparte' // Messaggio Import */
      gMsgImp = "Fine importazione del file Intermediari controparte";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Legge la tabella dipendenze e aggiunge i record */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Dipendenze' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Dipendenze"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_anadip
      m_cServer = m_Ctx.GetServer("f_anadip");
      m_cPhName = m_Ctx.GetPhName("f_anadip");
      if (Cursor_f_anadip!=null)
        Cursor_f_anadip.Close();
      Cursor_f_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_anadip")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_anadip.Eof())) {
        /* If not(Empty(f_anadip->CODDIP)) */
        if ( ! (CPLib.Empty(Cursor_f_anadip.GetString("CODDIP")))) {
          /* _codip := '' */
          _codip = "";
          // * --- Read from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_cSql = "";
          m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_f_anadip.GetString("CODDIP"),"C",6,0,m_cServer),m_cServer,Cursor_f_anadip.GetString("CODDIP"));
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
              Error l_oErrorFault = new Error("Read on anadip into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
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
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000079")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000079(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("ABICABSARA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("AGACCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("AGEREGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("ANOMOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("CAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("CAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("CODAGE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("CODLOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("DESCRIZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("FLGATT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_anadip.GetString("MACROAGENT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("NAZAGENTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("NUOVO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetDouble("OPXSOSAGE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetDouble("OPXSOSCLI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("TELEFONO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("TERMINALID"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("TIPOAGE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("TIPOSV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anadip.GetString("VALCOMPL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_f_anadip.GetDouble("AGENTE"),1)?"S":"N"),"?",0,0,m_cServer)+", ";
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
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000007A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"ABICABSARA = "+CPLib.ToSQL(Cursor_f_anadip.GetString("ABICABSARA"),"C",12,0,m_cServer)+", ";
            m_cSql = m_cSql+"AGACCODE = "+CPLib.ToSQL(Cursor_f_anadip.GetString("AGACCODE"),"C",10,0,m_cServer)+", ";
            m_cSql = m_cSql+"AGEREGIO = "+CPLib.ToSQL(Cursor_f_anadip.GetString("AGEREGIO"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"ANOMOPER = "+CPLib.ToSQL(Cursor_f_anadip.GetString("ANOMOPER"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(Cursor_f_anadip.GetString("CAB"),"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"RISGLOB = "+CPLib.ToSQL(Cursor_f_anadip.GetString("CAB2"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAB2 = "+CPLib.ToSQL(Cursor_f_anadip.GetString("CAB2"),"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_f_anadip.GetString("CAP"),"C",5,0,m_cServer)+", ";
            m_cSql = m_cSql+"CATEG01 = "+CPLib.ToSQL(Cursor_f_anadip.GetString("CATEG01"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CATEG02 = "+CPLib.ToSQL(Cursor_f_anadip.GetString("CATEG02"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CATEG03 = "+CPLib.ToSQL(Cursor_f_anadip.GetString("CATEG03"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CATEG04 = "+CPLib.ToSQL(Cursor_f_anadip.GetString("CATEG04"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CATEG05 = "+CPLib.ToSQL(Cursor_f_anadip.GetString("CATEG05"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CATEGORIA = "+CPLib.ToSQL(Cursor_f_anadip.GetString("CATEGORIA"),"C",10,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODAGE = "+CPLib.ToSQL(Cursor_f_anadip.GetString("CODAGE"),"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_f_anadip.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODLOC = "+CPLib.ToSQL(Cursor_f_anadip.GetString("CODLOC"),"C",25,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_f_anadip.GetString("DESCCIT"),"C",60,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCRIZ = "+CPLib.ToSQL(Cursor_f_anadip.GetString("DESCRIZ"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_f_anadip.GetString("DOMICILIO"),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGATT = "+CPLib.ToSQL(Cursor_f_anadip.GetString("FLGATT"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_f_anadip.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
            m_cSql = m_cSql+"MACROAGENTE = "+CPLib.ToSQLNull(Cursor_f_anadip.GetString("MACROAGENT"),"C",5,0,m_cServer)+", ";
            m_cSql = m_cSql+"NAZAGENTE = "+CPLib.ToSQL(Cursor_f_anadip.GetString("NAZAGENTE"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"NUOVO = "+CPLib.ToSQL(Cursor_f_anadip.GetString("NUOVO"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"OPXSOSAGE = "+CPLib.ToSQL(Cursor_f_anadip.GetDouble("OPXSOSAGE"),"N",10,0)+", ";
            m_cSql = m_cSql+"OPXSOSCLI = "+CPLib.ToSQL(Cursor_f_anadip.GetDouble("OPXSOSCLI"),"N",10,0)+", ";
            m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(Cursor_f_anadip.GetString("PARTIVA"),"C",11,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_f_anadip.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"TELEFONO = "+CPLib.ToSQL(Cursor_f_anadip.GetString("TELEFONO"),"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"TERMINALID = "+CPLib.ToSQL(Cursor_f_anadip.GetString("TERMINALID"),"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPOAGENTE = "+CPLib.ToSQL(Cursor_f_anadip.GetString("TIPOAGE"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPOSV = "+CPLib.ToSQL(Cursor_f_anadip.GetString("TIPOSV"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"VALCOMPL = "+CPLib.ToSQL(Cursor_f_anadip.GetString("VALCOMPL"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"AGENTE = "+CPLib.ToSQL((CPLib.eqr(Cursor_f_anadip.GetDouble("AGENTE"),1)?"S":"N"),"C",1,0,m_cServer)+", ";
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
        Cursor_f_anadip.Next();
      }
      m_cConnectivityError = Cursor_f_anadip.ErrorMessage();
      Cursor_f_anadip.Close();
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
        if (Cursor_f_intermbo!=null)
          Cursor_f_intermbo.Close();
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
        if (Cursor_f_inter2bo!=null)
          Cursor_f_inter2bo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_anadip!=null)
          Cursor_f_anadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_f_personbo_totale=null;
    CPResultSet Cursor_qbe_f_personbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_f_personbo_agg=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_f_opextrbo=null;
    CPResultSet Cursor_qbe_f_wersonbo_totale=null;
    CPResultSet Cursor_qbe_f_wersonbo=null;
    CPResultSet Cursor_f_wersonbo_agg=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Dati Soggetti */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Soggetti' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Soggetti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Dati Soggetti */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000084status;
      nTry00000084status = m_Sql.GetTransactionStatus();
      String cTry00000084msg;
      cTry00000084msg = m_Sql.TransactionErrorMessage();
      try {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* _maxfon := 0 */
        _maxfon = CPLib.Round(0,0);
        // * --- Select from qbe_f_personbo_totale
        if (Cursor_qbe_f_personbo_totale!=null)
          Cursor_qbe_f_personbo_totale.Close();
        Cursor_qbe_f_personbo_totale = new VQRHolder("qbe_f_personbo_totale",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_f_personbo_totale.Eof())) {
          /* _maxfon := qbe_f_personbo_totale->TOTALE */
          _maxfon = CPLib.Round(Cursor_qbe_f_personbo_totale.GetDouble("TOTALE"),0);
          Cursor_qbe_f_personbo_totale.Next();
        }
        m_cConnectivityError = Cursor_qbe_f_personbo_totale.ErrorMessage();
        Cursor_qbe_f_personbo_totale.Close();
        // * --- End Select
        /* If _maxfon <= 20000 */
        if (CPLib.le(_maxfon,20000)) {
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } else { // Else
          /* _cicli := iif(Mod(_maxfon,20000) <> 0,Int(_maxfon/20000) + 1,Int(_maxfon/20000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_maxfon,20000),0)?CPLib.Int(_maxfon/20000)+1:CPLib.Int(_maxfon/20000)),0);
        } // End If
        /* _pci := 1 */
        _pci = CPLib.Round(1,0);
        /* While _pci <= _cicli */
        while (CPLib.le(_pci,_cicli)) {
          /* _bot := ((_pci -1 ) * 20000) + 1 */
          _bot = CPLib.Round(((_pci-1)*20000)+1,0);
          /* _top := _pci * 20000 */
          _top = CPLib.Round(_pci*20000,0);
          // * --- Select from qbe_f_personbo
          SPBridge.HMCaller _h00000091;
          _h00000091 = new SPBridge.HMCaller();
          _h00000091.Set("m_cVQRList",m_cVQRList);
          _h00000091.Set("_bot",_bot);
          _h00000091.Set("_top",_top);
          if (Cursor_qbe_f_personbo!=null)
            Cursor_qbe_f_personbo.Close();
          Cursor_qbe_f_personbo = new VQRHolder("qbe_f_personbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000091,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_f_personbo.Eof())) {
            /* _connes := '' */
            _connes = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_personbo.GetString("CONNES")),"C",16,0,m_cServer),m_cServer,CPLib.Upper(Cursor_qbe_f_personbo.GetString("CONNES")));
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
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _connes = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(_connes) */
            if (CPLib.Empty(_connes)) {
              /* cSNAS := '' */
              cSNAS = "";
              /* cCNAS := '' */
              cCNAS = "";
              /* If qbe_f_personbo->TIPINTER='EE' */
              if (CPLib.eqr(Cursor_qbe_f_personbo.GetString("TIPINTER"),"EE")) {
                /* cSNAS := qbe_f_personbo->NASCOMUN */
                cSNAS = Cursor_qbe_f_personbo.GetString("NASCOMUN");
                /* ElseIf Empty(LRTrim(qbe_f_personbo->TIPINTER)) or LRTrim(qbe_f_personbo->TIPINTER) <> 'EE' */
              } else if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_f_personbo.GetString("TIPINTER"))) || CPLib.ne(CPLib.LRTrim(Cursor_qbe_f_personbo.GetString("TIPINTER")),"EE")) {
                /* cCNAS := qbe_f_personbo->NASCOMUN */
                cCNAS = Cursor_qbe_f_personbo.GetString("NASCOMUN");
              } // End If
              /* _tipper := iif(Empty(LRTrim(qbe_f_personbo->SESSO)),'G','P') */
              _tipper = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_f_personbo.GetString("SESSO")))?"G":"P");
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Soggetti' // Messaggio Import */
              gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Soggetti";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* nProgImp := Utilities.GetAutonumber("PRGIMPOCLI\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOCLI\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into personbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000009E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000009E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_personbo.GetString("CONNES")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_personbo.GetDate("DATANASC")),"18991230")?CPLib.NullDate():Cursor_qbe_f_personbo.GetDate("DATANASC")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cCNAS,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_personbo.GetDate("DATARILASC")),"18991230")?CPLib.NullDate():Cursor_qbe_f_personbo.GetDate("DATARILASC")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipper,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_personbo.GetDate("DATAVALI")),"18991230")?CPLib.NullDate():Cursor_qbe_f_personbo.GetDate("DATAVALI")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cSNAS,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("OLDCONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("SETTSINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("DATAVARAGE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("SETTSINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("FATCA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_f_personbo.GetString("OLDCONNES"),11),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("TIN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("ODB"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("TELEF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("TIPOORO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CODORO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("NOTIT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("FLGVALIDO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CITTADIN1"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CITTADIN2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("RESFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("MITIG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("MITIGDOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("NOSARA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("DATAPROF"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("DATAREVPRO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("IDENT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("PEPDATE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CRIME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("CRIMEDATE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("ALTRODOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("ALTROCAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CONTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDateTime("NUMIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("DATAIDENT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("DATARAUT"),"?",0,0)+", ";
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
              // * --- Select from f_personbo_agg
              m_cServer = m_Ctx.GetServer("f_personbo_agg");
              m_cPhName = m_Ctx.GetPhName("f_personbo_agg");
              if (Cursor_f_personbo_agg!=null)
                Cursor_f_personbo_agg.Close();
              Cursor_f_personbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CONNES"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_personbo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_f_personbo_agg.Eof())) {
                // * --- Insert into personbo_agg from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo_agg");
                m_cPhName = m_Ctx.GetPhName("personbo_agg");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000000A0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000A0(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_personbo_agg.GetString("CONNES")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("EMAIL"),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGEMAIL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("TELEFONO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("RDCODAUT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("RDLOCAUT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGBANCA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGVALIDO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("REGRES"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGBL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetDouble("CLOCCUPA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("NUMTEL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("NAZIONE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("LASTOPER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CODCLIEST"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGANAVAL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetDouble("MITIG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("MITIGDOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGPREGIUD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGTRUST"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGRISCHIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGRISCHIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGFALSADI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGRICINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
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
                Cursor_f_personbo_agg.Next();
              }
              m_cConnectivityError = Cursor_f_personbo_agg.ErrorMessage();
              Cursor_f_personbo_agg.Close();
              // * --- End Select
            } else { // Else
              /* cSNAS := '' */
              cSNAS = "";
              /* cCNAS := '' */
              cCNAS = "";
              /* If qbe_f_personbo->TIPINTER='EE' */
              if (CPLib.eqr(Cursor_qbe_f_personbo.GetString("TIPINTER"),"EE")) {
                /* cSNAS := qbe_f_personbo->NASCOMUN */
                cSNAS = Cursor_qbe_f_personbo.GetString("NASCOMUN");
                /* ElseIf Empty(LRTrim(qbe_f_personbo->TIPINTER)) or LRTrim(qbe_f_personbo->TIPINTER) <> 'EE' */
              } else if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_f_personbo.GetString("TIPINTER"))) || CPLib.ne(CPLib.LRTrim(Cursor_qbe_f_personbo.GetString("TIPINTER")),"EE")) {
                /* cCNAS := qbe_f_personbo->NASCOMUN */
                cCNAS = Cursor_qbe_f_personbo.GetString("NASCOMUN");
              } // End If
              /* _tipper := iif(Empty(LRTrim(qbe_f_personbo->SESSO)),'G','P') */
              _tipper = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_f_personbo.GetString("SESSO")))?"G":"P");
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Soggetti' // Messaggio Import */
              gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Soggetti";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
              cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _datamin := NullDate() */
                _datamin = CPLib.NullDate();
                // * --- Select from f_opextrbo
                m_cServer = m_Ctx.GetServer("f_opextrbo");
                m_cPhName = m_Ctx.GetPhName("f_opextrbo");
                if (Cursor_f_opextrbo!=null)
                  Cursor_f_opextrbo.Close();
                Cursor_f_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAOPE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("f_opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_f_opextrbo.Eof())) {
                  /* _datamin := f_opextrbo->DATAOPE */
                  _datamin = Cursor_f_opextrbo.GetDate("DATAOPE");
                  Cursor_f_opextrbo.Next();
                }
                m_cConnectivityError = Cursor_f_opextrbo.ErrorMessage();
                Cursor_f_opextrbo.Close();
                // * --- End Select
                // * --- Insert into wersonbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000000AE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000AE(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_personbo.GetString("CONNES")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCONNES"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATEXTRA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RAREA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATONOMECNOME"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOCOLD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("PROGIMPORT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROGIMP_C"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_datamin,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVARAGE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("FATCA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("BANCABEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ODB"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TELEF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOORO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODORO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDNASCOMUN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDNASSTATO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("NOTIT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("FLGVALIDO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CITTADIN1"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CITTADIN2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RESFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("MITIG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MITIGDOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOSARA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAPROF"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAREVPROF"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDENT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("PEPDATE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CRIME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("CRIMEDATE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ALTRODOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ALTROCAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDateTime("NUMIMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAPSEGNA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODLEGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOSOGGETTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CAUSALE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("IMPORTOMAX"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("FATTURATO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("FREQUENZA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("NUMOPERAZ"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOGAFFIDATARIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("FLGNOTRIM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DISATTIVO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAFINE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAINI"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAIDENT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARAUT"),"?",0,0)+", ";
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
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              // * --- Write into personbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000000AF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_personbo.GetDate("DATANASC")),"18991230")?CPLib.NullDate():Cursor_qbe_f_personbo.GetDate("DATANASC")),"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(cCNAS,"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_personbo.GetDate("DATARILASC")),"18991230")?CPLib.NullDate():Cursor_qbe_f_personbo.GetDate("DATARILASC")),"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(_tipper,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CODDIPE"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("PARTIVA"),"C",14,0,m_cServer)+", ";
              m_cSql = m_cSql+"NOTE = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("NOTE"),"M",10,0,m_cServer,m_oParameters)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"SOSPMAF = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("SOSPMAF"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_personbo.GetDate("DATAVALI")),"18991230")?CPLib.NullDate():Cursor_qbe_f_personbo.GetDate("DATAVALI")),"D",8,0)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(cSNAS,"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("DOCFILE"),"C",100,0,m_cServer)+", ";
              m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("NOME"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("COGNOME"),"C",26,0,m_cServer)+", ";
              m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("CFESTERO"),"N",1,0)+", ";
              m_cSql = m_cSql+"OLDCONNES = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("OLDCONNES"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("PKTBSPECIE"),"C",4,0,m_cServer)+", ";
              m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("COMPORT"),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"RNATGIU = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("RNATGIU"),"N",3,0)+", ";
              m_cSql = m_cSql+"RATTIV = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("RATTIV"),"N",3,0)+", ";
              m_cSql = m_cSql+"RCOMP = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("RCOMP"),"N",3,0)+", ";
              m_cSql = m_cSql+"RAREA = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("RAREA"),"N",3,0)+", ";
              m_cSql = m_cSql+"PROGIMPORT = "+CPLib.ToSQL(nProgImp,"N",15,0)+", ";
              m_cSql = m_cSql+"AREAGEO = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("AREAGEO"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"PEP = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("PEP"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATASEGN = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("DATASEGN"),"D",8,0)+", ";
              m_cSql = m_cSql+"OLDSETSIN = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("SETTSINT2"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAVARAGE = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("DATAVARAGE"),"D",8,0)+", ";
              m_cSql = m_cSql+"SETTSINT2 = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("SETTSINT2"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"FATCA = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("FATCA"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"BANCABEN = "+CPLib.ToSQL(CPLib.Left(Cursor_qbe_f_personbo.GetString("OLDCONNES"),11),"C",11,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIN = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("TIN"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"ODB = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("ODB"),"N",1,0)+", ";
              m_cSql = m_cSql+"TELEF = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("TELEF"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOORO = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("TIPOORO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODORO = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CODORO"),"C",11,0,m_cServer)+", ";
              m_cSql = m_cSql+"NOTIT = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("NOTIT"),"N",1,0)+", ";
              m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLGVALIDO = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("FLGVALIDO"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"CITTADIN1 = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CITTADIN1"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CITTADIN2 = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CITTADIN2"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RESFISC = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("RESFISC"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"MITIG = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("MITIG"),"N",4,0)+", ";
              m_cSql = m_cSql+"MITIGDOC = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("MITIGDOC"),"C",100,0,m_cServer)+", ";
              m_cSql = m_cSql+"NOSARA = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("NOSARA"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"RISGLOB = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("RISGLOB"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAPROF = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("DATAPROF"),"D",8,0)+", ";
              m_cSql = m_cSql+"DATAREVPROF = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("DATAREVPRO"),"D",8,0)+", ";
              m_cSql = m_cSql+"IDENT = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("IDENT"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"PEPDATE = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("PEPDATE"),"D",8,0)+", ";
              m_cSql = m_cSql+"DAC6 = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("DAC6"),"C",100,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGDAC6 = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDouble("FLAGDAC6"),"N",1,0)+", ";
              m_cSql = m_cSql+"CRIME = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CRIME"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"CRIMEDATE = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("CRIMEDATE"),"D",8,0)+", ";
              m_cSql = m_cSql+"ALTRODOM = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("ALTRODOM"),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"ALTROCAP = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("ALTROCAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CONTO = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CONTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMIMP = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDateTime("NUMIMP"),"T",14,0)+", ";
              m_cSql = m_cSql+"DATAIDENT = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("DATAIDENT"),"D",8,0)+", ";
              m_cSql = m_cSql+"DATASIGN = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("DATASEGN"),"D",8,0)+", ";
              m_cSql = m_cSql+"DATARAUT = "+CPLib.ToSQL(Cursor_qbe_f_personbo.GetDate("DATARAUT"),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_personbo.GetString("CONNES")),"?",0,0,m_cServer),m_cServer,CPLib.Upper(Cursor_qbe_f_personbo.GetString("CONNES")))+"";
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
              // * --- Select from f_personbo_agg
              m_cServer = m_Ctx.GetServer("f_personbo_agg");
              m_cPhName = m_Ctx.GetPhName("f_personbo_agg");
              if (Cursor_f_personbo_agg!=null)
                Cursor_f_personbo_agg.Close();
              Cursor_f_personbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_f_personbo.GetString("CONNES"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_personbo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_f_personbo_agg.Eof())) {
                // * --- Merge into personbo_agg from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo_agg");
                m_cPhName = m_Ctx.GetPhName("personbo_agg");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                m_cQuery = "select ";
                m_cQuery =  m_cQuery+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_personbo_agg.GetString("CONNES")),"?",0,0)+" as CONNES";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                  m_cQuery = m_cQuery+" from dual";
                }
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cWhere = "personbo_agg.CONNES = cptmp_1xab23.CONNES";
                m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000000B1")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" personbo_agg USING ";
                  m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                  m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                  m_cSql = m_cSql+"personbo_agg.EMAIL = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("EMAIL"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.FLGEMAIL = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGEMAIL"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.TELEFONO = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("TELEFONO"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.RDCODAUT = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("RDCODAUT"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.RDLOCAUT = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("RDLOCAUT"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.FLGBANCA = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGBANCA"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.FLGVALIDO = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGVALIDO"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.REGRES = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("REGRES"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.FLGBL = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGBL"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.CLOCCUPA = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetDouble("CLOCCUPA"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.NUMTEL = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("NUMTEL"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.NAZIONE = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("NAZIONE"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.LASTOPER = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("LASTOPER"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.CODCLIEST = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CODCLIEST"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.FLGANAVAL = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGANAVAL"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.MITIG = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetDouble("MITIG"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.MITGDOC = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("MITIGDOC"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.CATEG01 = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG01"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.CATEG02 = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG02"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.CATEG03 = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG03"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.CATEG04 = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG04"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.CATEG05 = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG05"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.CATEGORIA = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEGORIA"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.FLGPREGIUD = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGPREGIUD"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.FLGTRUST = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGTRUST"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.FLGRISCHIO = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGRISCHIO"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.FLGEQUIFIN = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGRISCHIO"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.FLGFALSADIC = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGFALSADI"),"?",0,0)+" , ";
                  m_cSql = m_cSql+"personbo_agg.FLGRICINF = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGRICINF"),"?",0,0)+" , ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",true,true);
                  m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                  m_cSql = m_cSql+GetFieldsName_000000B1(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_personbo_agg.GetString("CONNES")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("EMAIL"),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGEMAIL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("TELEFONO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("RDCODAUT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("RDLOCAUT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGBANCA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGVALIDO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("REGRES"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGBL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetDouble("CLOCCUPA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("NUMTEL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("NAZIONE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("LASTOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CODCLIEST"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGANAVAL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetDouble("MITIG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("MITIGDOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGPREGIUD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGTRUST"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGRISCHIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGRISCHIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGFALSADI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGRICINF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
                  m_cSql = m_cSql+")";
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                    m_cSql = m_cSql+";";
                  }
                } else {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000000B1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"EMAIL = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("EMAIL"),"M",10,0,m_cServer,m_oParameters)+", ";
                  m_cSql = m_cSql+"FLGEMAIL = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGEMAIL"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TELEFONO = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("TELEFONO"),"C",50,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RDCODAUT = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("RDCODAUT"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RDLOCAUT = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("RDLOCAUT"),"C",20,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLGBANCA = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGBANCA"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLGVALIDO = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGVALIDO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"REGRES = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("REGRES"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLGBL = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGBL"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CLOCCUPA = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetDouble("CLOCCUPA"),"N",3,0)+", ";
                  m_cSql = m_cSql+"NUMTEL = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("NUMTEL"),"C",20,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NAZIONE = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("NAZIONE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"LASTOPER = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("LASTOPER"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCLIEST = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CODCLIEST"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLGANAVAL = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGANAVAL"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"MITIG = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetDouble("MITIG"),"N",4,0)+", ";
                  m_cSql = m_cSql+"MITGDOC = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("MITIGDOC"),"C",100,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CATEG01 = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG01"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CATEG02 = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG02"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CATEG03 = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG03"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CATEG04 = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG04"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CATEG05 = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG05"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CATEGORIA = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEGORIA"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLGPREGIUD = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGPREGIUD"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLGTRUST = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGTRUST"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLGRISCHIO = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGRISCHIO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLGEQUIFIN = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGRISCHIO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLGFALSADIC = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGFALSADI"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLGRICINF = "+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGRICINF"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(Cursor_f_personbo_agg.GetString("CONNES")),"?",0,0,m_cServer),m_cServer,CPLib.Upper(Cursor_f_personbo_agg.GetString("CONNES")))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.eqr(m_nUpdatedRows,0)) {
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000000B1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000B1(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_personbo_agg.GetString("CONNES")),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("EMAIL"),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGEMAIL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("TELEFONO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("RDCODAUT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("RDLOCAUT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGBANCA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGVALIDO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("REGRES"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGBL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetDouble("CLOCCUPA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("NUMTEL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("NAZIONE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("LASTOPER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CODCLIEST"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGANAVAL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetDouble("MITIG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("MITIGDOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGPREGIUD"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGTRUST"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGRISCHIO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGRISCHIO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGFALSADI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_personbo_agg.GetString("FLGRICINF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
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
                Cursor_f_personbo_agg.Next();
              }
              m_cConnectivityError = Cursor_f_personbo_agg.ErrorMessage();
              Cursor_f_personbo_agg.Close();
              // * --- End Select
            } // End If
            Cursor_qbe_f_personbo.Next();
          }
          m_cConnectivityError = Cursor_qbe_f_personbo.ErrorMessage();
          Cursor_qbe_f_personbo.Close();
          // * --- End Select
          /* _pci := _pci + 1 */
          _pci = CPLib.Round(_pci+1,0);
        } // End While
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* _maxfon := 0 */
        _maxfon = CPLib.Round(0,0);
        // * --- Select from qbe_f_wersonbo_totale
        if (Cursor_qbe_f_wersonbo_totale!=null)
          Cursor_qbe_f_wersonbo_totale.Close();
        Cursor_qbe_f_wersonbo_totale = new VQRHolder("qbe_f_wersonbo_totale",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_f_wersonbo_totale.Eof())) {
          /* _maxfon := qbe_f_wersonbo_totale->TOTALE */
          _maxfon = CPLib.Round(Cursor_qbe_f_wersonbo_totale.GetDouble("TOTALE"),0);
          Cursor_qbe_f_wersonbo_totale.Next();
        }
        m_cConnectivityError = Cursor_qbe_f_wersonbo_totale.ErrorMessage();
        Cursor_qbe_f_wersonbo_totale.Close();
        // * --- End Select
        /* If _maxfon <= 20000 */
        if (CPLib.le(_maxfon,20000)) {
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } else { // Else
          /* _cicli := iif(Mod(_maxfon,20000) <> 0,Int(_maxfon/20000) + 1,Int(_maxfon/20000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_maxfon,20000),0)?CPLib.Int(_maxfon/20000)+1:CPLib.Int(_maxfon/20000)),0);
        } // End If
        /* _pci := 1 */
        _pci = CPLib.Round(1,0);
        /* While _pci <= _cicli */
        while (CPLib.le(_pci,_cicli)) {
          /* _bot := ((_pci -1 ) * 20000) + 1 */
          _bot = CPLib.Round(((_pci-1)*20000)+1,0);
          /* _top := _pci * 20000 */
          _top = CPLib.Round(_pci*20000,0);
          // * --- Select from qbe_f_wersonbo
          SPBridge.HMCaller _h000000BF;
          _h000000BF = new SPBridge.HMCaller();
          _h000000BF.Set("m_cVQRList",m_cVQRList);
          _h000000BF.Set("_bot",_bot);
          _h000000BF.Set("_top",_top);
          if (Cursor_qbe_f_wersonbo!=null)
            Cursor_qbe_f_wersonbo.Close();
          Cursor_qbe_f_wersonbo = new VQRHolder("qbe_f_wersonbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000BF,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_f_wersonbo.Eof())) {
            /* cSNAS := '' */
            cSNAS = "";
            /* cCNAS := '' */
            cCNAS = "";
            /* If qbe_f_wersonbo->TIPINTER='EE' */
            if (CPLib.eqr(Cursor_qbe_f_wersonbo.GetString("TIPINTER"),"EE")) {
              /* cSNAS := qbe_f_wersonbo->NASCOMUN */
              cSNAS = Cursor_qbe_f_wersonbo.GetString("NASCOMUN");
              /* ElseIf Empty(LRTrim(qbe_f_wersonbo->TIPINTER)) or LRTrim(qbe_f_wersonbo->TIPINTER) <> 'EE' */
            } else if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_f_wersonbo.GetString("TIPINTER"))) || CPLib.ne(CPLib.LRTrim(Cursor_qbe_f_wersonbo.GetString("TIPINTER")),"EE")) {
              /* cCNAS := qbe_f_wersonbo->NASCOMUN */
              cCNAS = Cursor_qbe_f_wersonbo.GetString("NASCOMUN");
            } // End If
            /* _tipper := iif(Empty(LRTrim(qbe_f_wersonbo->SESSO)),'G','P') */
            _tipper = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_f_wersonbo.GetString("SESSO")))?"G":"P");
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Soggetti (Storico)' // Messaggio Import */
            gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Soggetti (Storico)";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
            cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
            // * --- Insert into wersonbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000000C9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000C9(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_wersonbo.GetString("CONNES")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDate("DATANASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cCNAS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDate("DATARILASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipper,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDate("DATAVALI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cSNAS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDouble("CFESTERO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("OLDCONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDouble("RNATGIU"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDouble("RATTIV"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDate("DATAMODI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDate("DATASEGN"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDate("DATAVARAGE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("SETTSINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("FATCA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("TIN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDouble("ODB"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("TELEF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("TIPOORO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("CODORO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDouble("NOTIT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("FLGVALIDO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("CITTADIN1"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("CITTADIN2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("RESFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDouble("MITIG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("MITIGDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDouble("NOSARA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDate("DATAPROF"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDate("DATAREVPRO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("IDENT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDate("PEPDATE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("ALTRODOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("ALTROCAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("CONTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDateTime("NUMIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDate("DATAIDENT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDate("DATARAUT"),"?",0,0)+", ";
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
            // * --- Select from f_wersonbo_agg
            m_cServer = m_Ctx.GetServer("f_wersonbo_agg");
            m_cPhName = m_Ctx.GetPhName("f_wersonbo_agg");
            if (Cursor_f_wersonbo_agg!=null)
              Cursor_f_wersonbo_agg.Close();
            Cursor_f_wersonbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_wersonbo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_f_wersonbo_agg.Eof())) {
              // * --- Insert into wersonbo_agg from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wersonbo_agg");
              m_cPhName = m_Ctx.GetPhName("wersonbo_agg");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo_agg",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000000CB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000CB(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wersonbo.GetDate("DATAMODI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_wersonbo.GetString("CONNES")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("EMAIL"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("FLGEMAIL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("TELEFONO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("RDCODAUT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("RDLOCAUT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("FLGBANCA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("FLGVALIDO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("REGRES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("FLGBL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetDouble("CLOCCUPA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("NUMTEL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("NAZIONE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("LASTOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("CODCLIEST"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("FLGANAVAL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetDouble("MITIG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("MITIGDOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("FLGPREGIUD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("FLGTRUST"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("FLGRISCHIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("FLGEQUIFIN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("FLGFALSADI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wersonbo_agg.GetString("FLGRICINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wersonbo_agg",true);
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
              Cursor_f_wersonbo_agg.Next();
            }
            m_cConnectivityError = Cursor_f_wersonbo_agg.ErrorMessage();
            Cursor_f_wersonbo_agg.Close();
            // * --- End Select
            Cursor_qbe_f_wersonbo.Next();
          }
          m_cConnectivityError = Cursor_qbe_f_wersonbo.ErrorMessage();
          Cursor_qbe_f_wersonbo.Close();
          // * --- End Select
          /* _pci := _pci + 1 */
          _pci = CPLib.Round(_pci+1,0);
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000084status,0)) {
          m_Sql.SetTransactionStatus(nTry00000084status,cTry00000084msg);
        }
      }
      /* If _pci  > _cicli */
      if (CPLib.gt(_pci,_cicli)) {
        /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Soggetti' + NL */
        gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Soggetti"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + 'Elaborazione terminata con errori. Import abortito' + NL */
        gMsgProc = gMsgProc+"Elaborazione terminata con errori. Import abortito"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Soggetti' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Soggetti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Soggetti' // Messaggio Import */
      gMsgImp = "Fine importazione del file Soggetti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_qbe_f_personbo_totale!=null)
          Cursor_qbe_f_personbo_totale.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_f_personbo!=null)
          Cursor_qbe_f_personbo.Close();
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
        if (Cursor_f_personbo_agg!=null)
          Cursor_f_personbo_agg.Close();
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
        if (Cursor_f_opextrbo!=null)
          Cursor_f_opextrbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_f_wersonbo_totale!=null)
          Cursor_qbe_f_wersonbo_totale.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_f_wersonbo!=null)
          Cursor_qbe_f_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_wersonbo_agg!=null)
          Cursor_f_wersonbo_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_f_anarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_f_intestbo=null;
    CPResultSet Cursor_f_rapopebo=null;
    CPResultSet Cursor_f_soggetbo=null;
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_f_delegabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Dati Rapporti */
      /* _codrap Char(25) */
      /* _oldrapporto Char(25) // Vecchio codice rapporto */
      /* check_prog Numeric(10, 0) */
      double check_prog;
      check_prog = 0;
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Rapporti' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Rapporti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_anarapbo
      m_cServer = m_Ctx.GetServer("f_anarapbo");
      m_cPhName = m_Ctx.GetPhName("f_anarapbo");
      if (Cursor_f_anarapbo!=null)
        Cursor_f_anarapbo.Close();
      Cursor_f_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_anarapbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_anarapbo.Eof())) {
        /* If not(Empty(f_anarapbo->RAPPORTO)) */
        if ( ! (CPLib.Empty(Cursor_f_anarapbo.GetString("RAPPORTO")))) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Rapporti' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Rapporti";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPRAP\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAP\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into anarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000000DF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000DF(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_anarapbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_anarapbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetDouble("NOPROT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_anarapbo.GetDate("DATAMOD")),"18991230")?CPLib.NullDate():Cursor_f_anarapbo.GetDate("DATAMOD")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetDouble("RTIPO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetDouble("RCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetDouble("RIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetDouble("RFREQ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetDouble("RRAGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetDouble("RAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"anarapbo",true);
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
          /* _codrap := '' */
          _codrap = "";
          // * --- Read from knarapbo
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_f_anarapbo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_f_anarapbo.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("knarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _codrap = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _codrap = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(_codrap) */
          if (CPLib.Empty(_codrap)) {
            // * --- Insert into knarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000000E3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000E3(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_anarapbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"knarapbo",true);
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
            // * --- Write into knarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000000E4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(Cursor_f_anarapbo.GetString("DESCRAP"),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL("D","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_f_anarapbo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"knarapbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_f_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_f_anarapbo.GetString("RAPPORTO"))+"";
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
          /* _numrig := 1 */
          _numrig = CPLib.Round(1,0);
          // * --- Select from f_intestbo
          m_cServer = m_Ctx.GetServer("f_intestbo");
          m_cPhName = m_Ctx.GetPhName("f_intestbo");
          if (Cursor_f_intestbo!=null)
            Cursor_f_intestbo.Close();
          Cursor_f_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_f_anarapbo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_f_intestbo.Eof())) {
            /* If not(Empty(f_intestbo->CODINTER)) */
            if ( ! (CPLib.Empty(Cursor_f_intestbo.GetString("CODINTER")))) {
              /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Intestatari Rapporti' // Messaggio Import */
              gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Intestatari Rapporti";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into intestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000000EA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000EA(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intestbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_intestbo.GetDate("DATAINI")),"18991230")?CPLib.NullDate():Cursor_f_intestbo.GetDate("DATAINI")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intestbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Upper(Cursor_f_intestbo.GetString("CODINTER")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_intestbo.GetDate("DATAFINE")),"18991230")?CPLib.NullDate():Cursor_f_intestbo.GetDate("DATAFINE")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intestbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intestbo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intestbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intestbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intestbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intestbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_intestbo.GetDate("DATARETT")),"18991230")?CPLib.NullDate():Cursor_f_intestbo.GetDate("DATARETT")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intestbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intestbo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intestbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_intestbo.GetDouble("ABBINATO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
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
              /* _numrig := _numrig + 1 */
              _numrig = CPLib.Round(_numrig+1,0);
            } // End If
            Cursor_f_intestbo.Next();
          }
          m_cConnectivityError = Cursor_f_intestbo.ErrorMessage();
          Cursor_f_intestbo.Close();
          // * --- End Select
        } // End If
        Cursor_f_anarapbo.Next();
      }
      m_cConnectivityError = Cursor_f_anarapbo.ErrorMessage();
      Cursor_f_anarapbo.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Rapporti' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Rapporti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Rappoorti' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Rappoorti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Rapporti' // Messaggio Import */
      gMsgImp = "Fine importazione del file Rapporti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Informazioni Rapporti */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Informazioni Rapporti' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Informazioni Rapporti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_rapopebo
      m_cServer = m_Ctx.GetServer("f_rapopebo");
      m_cPhName = m_Ctx.GetPhName("f_rapopebo");
      if (Cursor_f_rapopebo!=null)
        Cursor_f_rapopebo.Close();
      Cursor_f_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_rapopebo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_rapopebo.Eof())) {
        /* If not(Empty(f_rapopebo->RAPPORTO)) */
        if ( ! (CPLib.Empty(Cursor_f_rapopebo.GetString("RAPPORTO")))) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Informazioni Rapporti' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Informazioni Rapporti";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into rapopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000000F7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000F7(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_f_rapopebo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_rapopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_rapopebo.GetString("CODINTER")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_rapopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_rapopebo.GetDate("DATAAGE")),"18991230")?CPLib.NullDate():Cursor_f_rapopebo.GetDate("DATAAGE")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_rapopebo.GetDate("DATAOPE")),"18991230")?CPLib.NullDate():Cursor_f_rapopebo.GetDate("DATAOPE")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_rapopebo.GetDate("DATAREG")),"18991230")?CPLib.NullDate():Cursor_f_rapopebo.GetDate("DATAREG")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_rapopebo.GetDate("DATARETT")),"18991230")?CPLib.NullDate():Cursor_f_rapopebo.GetDate("DATARETT")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_rapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_rapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
          /* _numrig := 1 */
          _numrig = CPLib.Round(1,0);
          // * --- Select from f_soggetbo
          m_cServer = m_Ctx.GetServer("f_soggetbo");
          m_cPhName = m_Ctx.GetPhName("f_soggetbo");
          if (Cursor_f_soggetbo!=null)
            Cursor_f_soggetbo.Close();
          Cursor_f_soggetbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_f_rapopebo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_soggetbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_f_soggetbo.Eof())) {
            /* If not(Empty(f_soggetbo->CODSOG)) */
            if ( ! (CPLib.Empty(Cursor_f_soggetbo.GetString("CODSOG")))) {
              // * --- Insert into soginfo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("soginfo");
              m_cPhName = m_Ctx.GetPhName("soginfo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"soginfo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000000FB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000FB(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Upper(Cursor_f_soggetbo.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_soggetbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
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
              /* _numrig := _numrig + 1 */
              _numrig = CPLib.Round(_numrig+1,0);
            } // End If
            Cursor_f_soggetbo.Next();
          }
          m_cConnectivityError = Cursor_f_soggetbo.ErrorMessage();
          Cursor_f_soggetbo.Close();
          // * --- End Select
        } // End If
        Cursor_f_rapopebo.Next();
      }
      m_cConnectivityError = Cursor_f_rapopebo.ErrorMessage();
      Cursor_f_rapopebo.Close();
      // * --- End Select
      /* check_prog := 0 */
      check_prog = CPLib.Round(0,0);
      // * --- Read from cpwarn
      m_cServer = m_Ctx.GetServer("cpwarn");
      m_cPhName = m_Ctx.GetPhName("cpwarn");
      m_cSql = "";
      m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","C",100,0,m_cServer),m_cServer,"prog\\PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'");
      m_cSql = m_cSql+" and warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"C",10,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda));
      if (m_Ctx.IsSharedTemp("cpwarn")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("autonum",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        check_prog = Read_Cursor.GetDouble("autonum");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        check_prog = 0;
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If check_prog>0 */
      if (CPLib.gt(check_prog,0)) {
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h00000100;
        _h00000100 = new SPBridge.HMCaller();
        _h00000100.Set("m_cVQRList",m_cVQRList);
        _h00000100.Set("tbname","rapopebo");
        _h00000100.Set("fldname","NUMPROG");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000100,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000101")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(Cursor_qbe_tab_mmc.GetDouble("max"),"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda))+"";
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
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } else { // Else
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h00000102;
        _h00000102 = new SPBridge.HMCaller();
        _h00000102.Set("m_cVQRList",m_cVQRList);
        _h00000102.Set("tbname","rapopebo");
        _h00000102.Set("fldname","NUMPROG");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000102,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          // * --- Insert into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000103")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000103(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tab_mmc.GetDouble("max"),"?",0,0)+", ";
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
          }
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } // End If
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Informazioni Rapporti' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Informazioni Rapporti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _numrig := 1 */
      _numrig = CPLib.Round(1,0);
      /* _oldrapporto := '' // Vecchio codice rapporto */
      _oldrapporto = "";
      // * --- Select from f_delegabo
      m_cServer = m_Ctx.GetServer("f_delegabo");
      m_cPhName = m_Ctx.GetPhName("f_delegabo");
      if (Cursor_f_delegabo!=null)
        Cursor_f_delegabo.Close();
      Cursor_f_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_delegabo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"RAPPORTO ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_delegabo.Eof())) {
        /* If not(Empty(f_delegabo->CODINTER)) */
        if ( ! (CPLib.Empty(Cursor_f_delegabo.GetString("CODINTER")))) {
          /* If _oldrapporto<>f_delegabo->RAPPORTO */
          if (CPLib.ne(_oldrapporto,Cursor_f_delegabo.GetString("RAPPORTO"))) {
            /* _numrig := 1 */
            _numrig = CPLib.Round(1,0);
            /* _oldrapporto := f_delegabo->RAPPORTO // Vecchio codice rapporto */
            _oldrapporto = Cursor_f_delegabo.GetString("RAPPORTO");
          } else { // Else
            /* _numrig := _numrig + 1 */
            _numrig = CPLib.Round(_numrig+1,0);
          } // End If
          // * --- Insert into delegabo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("delegabo");
          m_cPhName = m_Ctx.GetPhName("delegabo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000010D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000010D(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetDate("DATAINI"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetDate("DATARETT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetDate("DATAFINE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetDouble("ABBINATO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_delegabo.GetDouble("NOAGE"),"?",0,0,m_cServer)+", ";
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
        } // End If
        Cursor_f_delegabo.Next();
      }
      m_cConnectivityError = Cursor_f_delegabo.ErrorMessage();
      Cursor_f_delegabo.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Informazioni Rapporti' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Informazioni Rapporti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Informazioni Rapporti' // Messaggio Import */
      gMsgImp = "Fine importazione del file Informazioni Rapporti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_f_anarapbo!=null)
          Cursor_f_anarapbo.Close();
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
        if (Cursor_f_intestbo!=null)
          Cursor_f_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_rapopebo!=null)
          Cursor_f_rapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_soggetbo!=null)
          Cursor_f_soggetbo.Close();
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
        if (Cursor_f_delegabo!=null)
          Cursor_f_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Cursor_f_clienti=null;
    CPResultSet Cursor_f_benefic=null;
    CPResultSet Cursor_f_terzisti=null;
    CPResultSet Cursor_f_soggetbo=null;
    CPResultSet Cursor_f_operazbo_agg=null;
    CPResultSet Cursor_qbe_f_operazbo_totale=null;
    CPResultSet Cursor_qbe_f_operazbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_f_fraziobo_agg=null;
    CPResultSet Cursor_qbe_f_fraziobo_totale=null;
    CPResultSet Cursor_qbe_f_fraziobo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* check_prog Numeric(10, 0) */
      double check_prog;
      check_prog = 0;
      /* altricli Bool */
      boolean altricli;
      altricli = false;
      /* altriben Bool */
      boolean altriben;
      altriben = false;
      /* altriterz Bool */
      boolean altriterz;
      altriterz = false;
      /* altrisog Bool */
      boolean altrisog;
      altrisog = false;
      /* altriagg Bool */
      boolean altriagg;
      altriagg = false;
      /* _idbase Char(10) */
      String _idbase;
      _idbase = CPLib.Space(10);
      /* codidpe Char(6) // appoggio per verifica dipendenze */
      String codidpe;
      codidpe = CPLib.Space(6);
      /* _maxprg Numeric(11, 0) */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000011Astatus;
      nTry0000011Astatus = m_Sql.GetTransactionStatus();
      String cTry0000011Amsg;
      cTry0000011Amsg = m_Sql.TransactionErrorMessage();
      try {
        /* _maxfo := '' */
        _maxfo = "";
        /* _maxfon := 0 */
        _maxfon = CPLib.Round(0,0);
        /* _top := 0 */
        _top = CPLib.Round(0,0);
        /* _bot := 0 */
        _bot = CPLib.Round(0,0);
        /* _cicli := 0 */
        _cicli = CPLib.Round(0,0);
        /* _pci := 0 */
        _pci = CPLib.Round(0,0);
        /* altricli := False */
        altricli = false;
        /* altriterz := False */
        altriterz = false;
        /* altrisog := False */
        altrisog = false;
        /* altriben := False  */
        altriben = false;
        /* altriagg := False */
        altriagg = false;
        // * --- Select from f_clienti
        m_cServer = m_Ctx.GetServer("f_clienti");
        m_cPhName = m_Ctx.GetPhName("f_clienti");
        if (Cursor_f_clienti!=null)
          Cursor_f_clienti.Close();
        Cursor_f_clienti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_clienti")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_f_clienti.Eof())) {
          /* altricli := True */
          altricli = true;
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_f_clienti.Next();
        }
        m_cConnectivityError = Cursor_f_clienti.ErrorMessage();
        Cursor_f_clienti.Close();
        // * --- End Select
        // * --- Select from f_benefic
        m_cServer = m_Ctx.GetServer("f_benefic");
        m_cPhName = m_Ctx.GetPhName("f_benefic");
        if (Cursor_f_benefic!=null)
          Cursor_f_benefic.Close();
        Cursor_f_benefic = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_benefic")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_f_benefic.Eof())) {
          /* altriben := True */
          altriben = true;
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_f_benefic.Next();
        }
        m_cConnectivityError = Cursor_f_benefic.ErrorMessage();
        Cursor_f_benefic.Close();
        // * --- End Select
        // * --- Select from f_terzisti
        m_cServer = m_Ctx.GetServer("f_terzisti");
        m_cPhName = m_Ctx.GetPhName("f_terzisti");
        if (Cursor_f_terzisti!=null)
          Cursor_f_terzisti.Close();
        Cursor_f_terzisti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_terzisti")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_f_terzisti.Eof())) {
          /* altriterz := True */
          altriterz = true;
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_f_terzisti.Next();
        }
        m_cConnectivityError = Cursor_f_terzisti.ErrorMessage();
        Cursor_f_terzisti.Close();
        // * --- End Select
        // * --- Select from f_soggetbo
        m_cServer = m_Ctx.GetServer("f_soggetbo");
        m_cPhName = m_Ctx.GetPhName("f_soggetbo");
        if (Cursor_f_soggetbo!=null)
          Cursor_f_soggetbo.Close();
        Cursor_f_soggetbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_soggetbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_f_soggetbo.Eof())) {
          /* altrisog := True */
          altrisog = true;
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_f_soggetbo.Next();
        }
        m_cConnectivityError = Cursor_f_soggetbo.ErrorMessage();
        Cursor_f_soggetbo.Close();
        // * --- End Select
        // * --- Select from f_operazbo_agg
        m_cServer = m_Ctx.GetServer("f_operazbo_agg");
        m_cPhName = m_Ctx.GetPhName("f_operazbo_agg");
        if (Cursor_f_operazbo_agg!=null)
          Cursor_f_operazbo_agg.Close();
        Cursor_f_operazbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_operazbo_agg")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_f_operazbo_agg.Eof())) {
          /* altriagg := True */
          altriagg = true;
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_f_operazbo_agg.Next();
        }
        m_cConnectivityError = Cursor_f_operazbo_agg.ErrorMessage();
        Cursor_f_operazbo_agg.Close();
        // * --- End Select
        // * --- Select from qbe_f_operazbo_totale
        if (Cursor_qbe_f_operazbo_totale!=null)
          Cursor_qbe_f_operazbo_totale.Close();
        Cursor_qbe_f_operazbo_totale = new VQRHolder("qbe_f_operazbo_totale",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_f_operazbo_totale.Eof())) {
          /* _maxfon := qbe_f_operazbo_totale->TOTALE */
          _maxfon = CPLib.Round(Cursor_qbe_f_operazbo_totale.GetDouble("TOTALE"),0);
          Cursor_qbe_f_operazbo_totale.Next();
        }
        m_cConnectivityError = Cursor_qbe_f_operazbo_totale.ErrorMessage();
        Cursor_qbe_f_operazbo_totale.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni' +NL */
        gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If _maxfon > 0 */
        if (CPLib.gt(_maxfon,0)) {
          /* If _maxfon <= 20000 */
          if (CPLib.le(_maxfon,20000)) {
            /* _cicli := 1 */
            _cicli = CPLib.Round(1,0);
          } else { // Else
            /* _cicli := iif(Mod(_maxfon,20000) <> 0,Int(_maxfon/20000) + 1,Int(_maxfon/20000)) */
            _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_maxfon,20000),0)?CPLib.Int(_maxfon/20000)+1:CPLib.Int(_maxfon/20000)),0);
          } // End If
          /* _pci := 1 */
          _pci = CPLib.Round(1,0);
          /* conta := 0 */
          conta = CPLib.Round(0,0);
          /* While _pci <= _cicli */
          while (CPLib.le(_pci,_cicli)) {
            /* _bot := ((_pci -1 ) * 20000) + 1 */
            _bot = CPLib.Round(((_pci-1)*20000)+1,0);
            /* _top := _pci * 20000 */
            _top = CPLib.Round(_pci*20000,0);
            // * --- Select from qbe_f_operazbo
            SPBridge.HMCaller _h00000142;
            _h00000142 = new SPBridge.HMCaller();
            _h00000142.Set("m_cVQRList",m_cVQRList);
            _h00000142.Set("_bot",_bot);
            _h00000142.Set("_top",_top);
            if (Cursor_qbe_f_operazbo!=null)
              Cursor_qbe_f_operazbo.Close();
            Cursor_qbe_f_operazbo = new VQRHolder("qbe_f_operazbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000142,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_f_operazbo.Eof())) {
              /* If not(Empty(qbe_f_operazbo->CODDIPE)) */
              if ( ! (CPLib.Empty(Cursor_qbe_f_operazbo.GetString("CODDIPE")))) {
                /* codidpe := '' // appoggio per verifica dipendenze */
                codidpe = "";
                // * --- Read from anadip
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_cSql = "";
                m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("CODDIPE"),"C",6,0,m_cServer),m_cServer,Cursor_qbe_f_operazbo.GetString("CODDIPE"));
                if (m_Ctx.IsSharedTemp("anadip")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  codidpe = Read_Cursor.GetString("CODDIP");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  codidpe = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(codidpe) */
                if (CPLib.Empty(codidpe)) {
                  // * --- Insert into anadip from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("anadip");
                  m_cPhName = m_Ctx.GetPhName("anadip");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anadip",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000147")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000147(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("DIPENDENZA NON INSERITA","?",0,0,m_cServer)+", ";
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
                    throw new RoutineException();
                  }
                } // End If
              } // End If
              /* If not(Empty(qbe_f_operazbo->IDBASE)) */
              if ( ! (CPLib.Empty(Cursor_qbe_f_operazbo.GetString("IDBASE")))) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Operazioni' // Messaggio Import */
                gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Operazioni";
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                /* _dataret := iif(DateToChar(qbe_f_operazbo->DATARETT)='18991230',NullDate(),qbe_f_operazbo->DATARETT) */
                _dataret = (CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_operazbo.GetDate("DATARETT")),"18991230")?CPLib.NullDate():Cursor_qbe_f_operazbo.GetDate("DATARETT"));
                /* _dataimp := iif(DateToChar(qbe_f_operazbo->DATAIMP)='18991230',NullDate(),qbe_f_operazbo->DATAIMP) */
                _dataimp = (CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_operazbo.GetDate("DATAIMP")),"18991230")?CPLib.NullDate():Cursor_qbe_f_operazbo.GetDate("DATAIMP"));
                /* Verifico se già presente un operazione con lo stesso idbase. Nel caso inserisco il numprog su idbase, per evitare duplicazioni di chiave primaria. */
                /* _idbase := '' */
                _idbase = "";
                // * --- Read from operazbo
                m_cServer = m_Ctx.GetServer("operazbo");
                m_cPhName = m_Ctx.GetPhName("operazbo");
                m_cSql = "";
                m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("IDBASE"),"C",10,0,m_cServer),m_cServer,Cursor_qbe_f_operazbo.GetString("IDBASE"));
                if (m_Ctx.IsSharedTemp("operazbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _idbase = Read_Cursor.GetString("IDBASE");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on operazbo into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _idbase = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                // * --- Insert into operazbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("operazbo");
                m_cPhName = m_Ctx.GetPhName("operazbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000151")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000151(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_operazbo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_operazbo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_operazbo.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_operazbo.GetString("CONNALTRO")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_operazbo.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_operazbo.GetString("CONNESCLI")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_operazbo.GetString("CONNESOPER")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_dataret,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_idbase)?Cursor_qbe_f_operazbo.GetString("IDBASE"):CPLib.Right(Cursor_qbe_f_operazbo.GetString("NUMPROG"),10)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("NOPROT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("RAREA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("RCOMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("RFREQ"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("RIMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("RTIPO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(Cursor_qbe_f_operazbo.GetDate("DATAOPE")),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(Cursor_qbe_f_operazbo.GetString("IDEREG"),10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("IMPIN"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("IMPOUT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("MITIG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("MITIGDOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("SV58550"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("PROQUOTA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("TIPOORO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDouble("IMPSARA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("SV58550MA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_f_operazbo.GetDouble("NOSARA"),1)?"S":"N"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("MEZPAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("PRESTAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetDateTime("NUMIMP"),"?",0,0)+", ";
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
                  throw new RoutineException();
                }
                /* If altricli=True  */
                if (CPLib.eqr(altricli,true)) {
                  // * --- Select from f_clienti
                  m_cServer = m_Ctx.GetServer("f_clienti");
                  m_cPhName = m_Ctx.GetPhName("f_clienti");
                  if (Cursor_f_clienti!=null)
                    Cursor_f_clienti.Close();
                  Cursor_f_clienti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_clienti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_clienti.Eof())) {
                    // * --- Insert into clientiope from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("clientiope");
                    m_cPhName = m_Ctx.GetPhName("clientiope");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000154")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000154(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_clienti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_clienti.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_clienti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_clienti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_clienti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_clienti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_clienti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_clienti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
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
                    Cursor_f_clienti.Next();
                  }
                  m_cConnectivityError = Cursor_f_clienti.ErrorMessage();
                  Cursor_f_clienti.Close();
                  // * --- End Select
                } // End If
                /* If altriben=True  */
                if (CPLib.eqr(altriben,true)) {
                  /* _numrig := 1 */
                  _numrig = CPLib.Round(1,0);
                  // * --- Select from f_benefic
                  m_cServer = m_Ctx.GetServer("f_benefic");
                  m_cPhName = m_Ctx.GetPhName("f_benefic");
                  if (Cursor_f_benefic!=null)
                    Cursor_f_benefic.Close();
                  Cursor_f_benefic = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_benefic")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_benefic.Eof())) {
                    // * --- Insert into beneficope from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("beneficope");
                    m_cPhName = m_Ctx.GetPhName("beneficope");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000158")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000158(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_benefic.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
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
                    /* _numrig := _numrig + 1 */
                    _numrig = CPLib.Round(_numrig+1,0);
                    Cursor_f_benefic.Next();
                  }
                  m_cConnectivityError = Cursor_f_benefic.ErrorMessage();
                  Cursor_f_benefic.Close();
                  // * --- End Select
                } // End If
                /* If altriterz=True  */
                if (CPLib.eqr(altriterz,true)) {
                  // * --- Select from f_terzisti
                  m_cServer = m_Ctx.GetServer("f_terzisti");
                  m_cPhName = m_Ctx.GetPhName("f_terzisti");
                  if (Cursor_f_terzisti!=null)
                    Cursor_f_terzisti.Close();
                  Cursor_f_terzisti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_terzisti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_terzisti.Eof())) {
                    // * --- Insert into terzistiope from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("terzistiope");
                    m_cPhName = m_Ctx.GetPhName("terzistiope");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000015C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000015C(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_terzisti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_terzisti.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_terzisti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_terzisti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_terzisti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_terzisti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_terzisti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_terzisti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
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
                    Cursor_f_terzisti.Next();
                  }
                  m_cConnectivityError = Cursor_f_terzisti.ErrorMessage();
                  Cursor_f_terzisti.Close();
                  // * --- End Select
                } // End If
                /* If altrisog=True  */
                if (CPLib.eqr(altrisog,true)) {
                  /* _numrig := 1 */
                  _numrig = CPLib.Round(1,0);
                  // * --- Select from f_soggetbo
                  m_cServer = m_Ctx.GetServer("f_soggetbo");
                  m_cPhName = m_Ctx.GetPhName("f_soggetbo");
                  if (Cursor_f_soggetbo!=null)
                    Cursor_f_soggetbo.Close();
                  Cursor_f_soggetbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_soggetbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_soggetbo.Eof())) {
                    // * --- Insert into sogopebo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("sogopebo");
                    m_cPhName = m_Ctx.GetPhName("sogopebo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000160")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000160(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Upper(Cursor_f_soggetbo.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_soggetbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
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
                    /* _numrig := _numrig + 1 */
                    _numrig = CPLib.Round(_numrig+1,0);
                    Cursor_f_soggetbo.Next();
                  }
                  m_cConnectivityError = Cursor_f_soggetbo.ErrorMessage();
                  Cursor_f_soggetbo.Close();
                  // * --- End Select
                } // End If
                /* If altriagg */
                if (altriagg) {
                  // * --- Select from f_operazbo_agg
                  m_cServer = m_Ctx.GetServer("f_operazbo_agg");
                  m_cPhName = m_Ctx.GetPhName("f_operazbo_agg");
                  if (Cursor_f_operazbo_agg!=null)
                    Cursor_f_operazbo_agg.Close();
                  Cursor_f_operazbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPLib.ToSQL(Cursor_qbe_f_operazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_operazbo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_operazbo_agg.Eof())) {
                    // * --- Insert into operazbo_agg from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("operazbo_agg");
                    m_cPhName = m_Ctx.GetPhName("operazbo_agg");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo_agg",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000164")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000164(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetDouble("CACODICE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("IDBIGLIETT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetDateTime("CADATAORA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetDouble("CATIPGIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetDouble("CATIPCON"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetDouble("CAPV_COD"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("IDDOCALL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("VPCODICE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetDateTime("WUDATRET"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetDouble("FLAGFRAUD"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("SV58724"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("SV58726SCA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("SV58726SA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("SV58726PIS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("C_COGNOME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("C_NOME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_operazbo_agg.GetString("SOSPAGAM"),"?",0,0,m_cServer)+", ";
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
                      throw new RoutineException();
                    }
                    Cursor_f_operazbo_agg.Next();
                  }
                  m_cConnectivityError = Cursor_f_operazbo_agg.ErrorMessage();
                  Cursor_f_operazbo_agg.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_qbe_f_operazbo.Next();
            }
            m_cConnectivityError = Cursor_qbe_f_operazbo.ErrorMessage();
            Cursor_qbe_f_operazbo.Close();
            // * --- End Select
            /* _pci := _pci + 1 */
            _pci = CPLib.Round(_pci+1,0);
          } // End While
          /* Verifico la presenza del contatore dei progressivi e dell'idbase. Per evitare errori in inserimento. */
          /* If _pci > _cicli */
          if (CPLib.gt(_pci,_cicli)) {
            /* idbase */
            /* check_prog := 0 */
            check_prog = CPLib.Round(0,0);
            // * --- Read from cpwarn
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_cSql = "";
            m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","C",100,0,m_cServer),m_cServer,"prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'");
            m_cSql = m_cSql+" and warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"C",10,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda));
            if (m_Ctx.IsSharedTemp("cpwarn")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("autonum",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              check_prog = Read_Cursor.GetDouble("autonum");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              check_prog = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If check_prog>0 */
            if (CPLib.gt(check_prog,0)) {
              /* Se riunisco lo storico con le operazioni sommo i due contatori del numero di operazioni, mentre per il numprog prendo il massimo di operazbo comunque */
              /* If pFlg='N' */
              if (CPLib.eqr(pFlg,"N")) {
                // * --- Write into cpwarn from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cpwarn");
                m_cPhName = m_Ctx.GetPhName("cpwarn");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000016E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_maxfon,"N",10,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
                m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda))+"";
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
                // * --- Write into cpwarn from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cpwarn");
                m_cPhName = m_Ctx.GetPhName("cpwarn");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000016F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"autonum = autonum+("+CPLib.ToSQL(_maxfon,"N",10,0)+"), ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
                m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda))+"";
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
              // * --- Insert into cpwarn from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpwarn");
              m_cPhName = m_Ctx.GetPhName("cpwarn");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000170")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000170(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_maxfon,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer)+", ";
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
            } // End If
            /* progressivo */
            /* check_prog := 0 */
            check_prog = CPLib.Round(0,0);
            // * --- Read from cpwarn
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_cSql = "";
            m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","C",100,0,m_cServer),m_cServer,"prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'");
            m_cSql = m_cSql+" and warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"C",10,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda));
            if (m_Ctx.IsSharedTemp("cpwarn")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("autonum",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              check_prog = Read_Cursor.GetDouble("autonum");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              check_prog = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If check_prog>0 */
            if (CPLib.gt(check_prog,0)) {
              // * --- Select from qbe_tab_mmc
              SPBridge.HMCaller _h00000175;
              _h00000175 = new SPBridge.HMCaller();
              _h00000175.Set("m_cVQRList",m_cVQRList);
              _h00000175.Set("tbname","operazbo");
              _h00000175.Set("fldname","NUMPROG");
              if (Cursor_qbe_tab_mmc!=null)
                Cursor_qbe_tab_mmc.Close();
              Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000175,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_tab_mmc.Eof())) {
                // * --- Write into cpwarn from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cpwarn");
                m_cPhName = m_Ctx.GetPhName("cpwarn");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000176")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(Cursor_qbe_tab_mmc.GetDouble("max"),"N",10,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
                m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda))+"";
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
                Cursor_qbe_tab_mmc.Next();
              }
              m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
              Cursor_qbe_tab_mmc.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from qbe_tab_mmc
              SPBridge.HMCaller _h00000177;
              _h00000177 = new SPBridge.HMCaller();
              _h00000177.Set("m_cVQRList",m_cVQRList);
              _h00000177.Set("tbname","operazbo");
              _h00000177.Set("fldname","NUMPROG");
              if (Cursor_qbe_tab_mmc!=null)
                Cursor_qbe_tab_mmc.Close();
              Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000177,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_tab_mmc.Eof())) {
                // * --- Insert into cpwarn from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cpwarn");
                m_cPhName = m_Ctx.GetPhName("cpwarn");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000178")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000178(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL("prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tab_mmc.GetDouble("max"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer)+", ";
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
                Cursor_qbe_tab_mmc.Next();
              }
              m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
              Cursor_qbe_tab_mmc.Close();
              // * --- End Select
            } // End If
            /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Operazioni' + NL */
            gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Operazioni"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := gMsgProc + 'Elaborazione terminata con errori. Import abortito' + NL */
            gMsgProc = gMsgProc+"Elaborazione terminata con errori. Import abortito"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            // Transaction Error
            cTry0000011Amsg = CPLib.FormatMsg(m_Ctx,"Errore nell'import delle operazioni");
            m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Errore nell'import delle operazioni"));
            throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Errore nell'import delle operazioni"));
          } // End If
        } // End If
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni' + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Fine importazione del file Operazioni' // Messaggio Import */
        gMsgImp = "Fine importazione del file Operazioni";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _maxfo := '' */
        _maxfo = "";
        /* _maxfon := 0 */
        _maxfon = CPLib.Round(0,0);
        /* _top := 0 */
        _top = CPLib.Round(0,0);
        /* _bot := 0 */
        _bot = CPLib.Round(0,0);
        /* _cicli := 0 */
        _cicli = CPLib.Round(0,0);
        /* _pci := 0 */
        _pci = CPLib.Round(0,0);
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* altriagg := False */
        altriagg = false;
        // * --- Select from f_fraziobo_agg
        m_cServer = m_Ctx.GetServer("f_fraziobo_agg");
        m_cPhName = m_Ctx.GetPhName("f_fraziobo_agg");
        if (Cursor_f_fraziobo_agg!=null)
          Cursor_f_fraziobo_agg.Close();
        Cursor_f_fraziobo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_fraziobo_agg")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_f_fraziobo_agg.Eof())) {
          /* altriagg := True */
          altriagg = true;
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_f_fraziobo_agg.Next();
        }
        m_cConnectivityError = Cursor_f_fraziobo_agg.ErrorMessage();
        Cursor_f_fraziobo_agg.Close();
        // * --- End Select
        // * --- Select from qbe_f_fraziobo_totale
        if (Cursor_qbe_f_fraziobo_totale!=null)
          Cursor_qbe_f_fraziobo_totale.Close();
        Cursor_qbe_f_fraziobo_totale = new VQRHolder("qbe_f_fraziobo_totale",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_f_fraziobo_totale.Eof())) {
          /* _maxfon := qbe_f_fraziobo_totale->TOTALE */
          _maxfon = CPLib.Round(Cursor_qbe_f_fraziobo_totale.GetDouble("TOTALE"),0);
          /* _maxprg := Val(qbe_f_fraziobo_totale->MAXPRG) */
          _maxprg = CPLib.Round(CPLib.Val(Cursor_qbe_f_fraziobo_totale.GetString("MAXPRG")),0);
          Cursor_qbe_f_fraziobo_totale.Next();
        }
        m_cConnectivityError = Cursor_qbe_f_fraziobo_totale.ErrorMessage();
        Cursor_qbe_f_fraziobo_totale.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Frazionate' +NL */
        gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Frazionate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If _maxfon > 0 */
        if (CPLib.gt(_maxfon,0)) {
          /* If _maxfon <= 20000 */
          if (CPLib.le(_maxfon,20000)) {
            /* _cicli := 1 */
            _cicli = CPLib.Round(1,0);
          } else { // Else
            /* _cicli := iif(Mod(_maxfon,20000) <> 0,Int(_maxfon/20000) + 1,Int(_maxfon/20000)) */
            _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_maxfon,20000),0)?CPLib.Int(_maxfon/20000)+1:CPLib.Int(_maxfon/20000)),0);
          } // End If
          /* _pci := 1 */
          _pci = CPLib.Round(1,0);
          /* conta := 0 */
          conta = CPLib.Round(0,0);
          /* While _pci <= _cicli */
          while (CPLib.le(_pci,_cicli)) {
            /* _bot := ((_pci -1 ) * 20000) + 1 */
            _bot = CPLib.Round(((_pci-1)*20000)+1,0);
            /* _top := _pci * 20000 */
            _top = CPLib.Round(_pci*20000,0);
            // * --- Select from qbe_f_fraziobo
            SPBridge.HMCaller _h00000197;
            _h00000197 = new SPBridge.HMCaller();
            _h00000197.Set("m_cVQRList",m_cVQRList);
            _h00000197.Set("_bot",_bot);
            _h00000197.Set("_top",_top);
            if (Cursor_qbe_f_fraziobo!=null)
              Cursor_qbe_f_fraziobo.Close();
            Cursor_qbe_f_fraziobo = new VQRHolder("qbe_f_fraziobo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000197,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_f_fraziobo.Eof())) {
              /* If not(Empty(qbe_f_fraziobo->CODDIPE)) */
              if ( ! (CPLib.Empty(Cursor_qbe_f_fraziobo.GetString("CODDIPE")))) {
                /* codidpe := '' // appoggio per verifica dipendenze */
                codidpe = "";
                // * --- Read from anadip
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_cSql = "";
                m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("CODDIPE"),"C",6,0,m_cServer),m_cServer,Cursor_qbe_f_fraziobo.GetString("CODDIPE"));
                if (m_Ctx.IsSharedTemp("anadip")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  codidpe = Read_Cursor.GetString("CODDIP");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  codidpe = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(codidpe) */
                if (CPLib.Empty(codidpe)) {
                  // * --- Insert into anadip from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("anadip");
                  m_cPhName = m_Ctx.GetPhName("anadip");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anadip",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000019C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000019C(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("DIPENDENZA NON INSERITA","?",0,0,m_cServer)+", ";
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
                    throw new RoutineException();
                  }
                } // End If
              } // End If
              /* If not(Empty(qbe_f_fraziobo->IDBASE)) */
              if ( ! (CPLib.Empty(Cursor_qbe_f_fraziobo.GetString("IDBASE")))) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                /* _maxprg := _maxprg + 1 */
                _maxprg = CPLib.Round(_maxprg+1,0);
                /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Frazionate' // Messaggio Import */
                gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Frazionate";
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* nProgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                /* _dataret := iif(DateToChar(qbe_f_fraziobo->DATARETT)='18991230',NullDate(),qbe_f_fraziobo->DATARETT) */
                _dataret = (CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_fraziobo.GetDate("DATARETT")),"18991230")?CPLib.NullDate():Cursor_qbe_f_fraziobo.GetDate("DATARETT"));
                /* _dataimp := iif(DateToChar(qbe_f_fraziobo->DATAIMP)='18991230',NullDate(),qbe_f_fraziobo->DATAIMP) */
                _dataimp = (CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_fraziobo.GetDate("DATAIMP")),"18991230")?CPLib.NullDate():Cursor_qbe_f_fraziobo.GetDate("DATAIMP"));
                /* Verifico se già presente un operazione con lo stesso idbase. Nel caso inserisco il numprog su idbase, per evitare duplicazioni di chiave primaria. */
                /* _maxfo := Right('00000000000'+LRTrim(Str(_maxprg,11,0)),11) */
                _maxfo = CPLib.Right("00000000000"+CPLib.LRTrim(CPLib.Str(_maxprg,11,0)),11);
                /* _idbase := '' */
                _idbase = "";
                // * --- Read from fraziobo
                m_cServer = m_Ctx.GetServer("fraziobo");
                m_cPhName = m_Ctx.GetPhName("fraziobo");
                m_cSql = "";
                m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("IDBASE"),"C",10,0,m_cServer),m_cServer,Cursor_qbe_f_fraziobo.GetString("IDBASE"));
                if (m_Ctx.IsSharedTemp("fraziobo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _idbase = Read_Cursor.GetString("IDBASE");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _idbase = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                // * --- Insert into fraziobo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("fraziobo");
                m_cPhName = m_Ctx.GetPhName("fraziobo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001A8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001A8(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_fraziobo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_fraziobo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_fraziobo.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_fraziobo.GetString("CONNALTRO")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_fraziobo.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_fraziobo.GetString("CONNESCLI")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_fraziobo.GetString("CONNESOPER")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_dataret,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_idbase)?Cursor_qbe_f_fraziobo.GetString("IDBASE"):CPLib.Right(Cursor_qbe_f_fraziobo.GetString("NUMPROG"),10)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("RAREA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("RIMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(Cursor_qbe_f_fraziobo.GetDate("DATAOPE")),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right(Cursor_qbe_f_fraziobo.GetString("IDEREG"),10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("IMPIN"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("IMPOUT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("MITIG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("MITIGDOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("SV58550"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("PROQUOTA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("TIPOORO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDouble("IMPSARA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("SV58550MA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_f_fraziobo.GetDouble("NOSARA"),1)?"S":"N"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("MEZPAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("PRESTAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetDateTime("NUMIMP"),"?",0,0)+", ";
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
                /* If altricli=True */
                if (CPLib.eqr(altricli,true)) {
                  // * --- Select from f_clienti
                  m_cServer = m_Ctx.GetServer("f_clienti");
                  m_cPhName = m_Ctx.GetPhName("f_clienti");
                  if (Cursor_f_clienti!=null)
                    Cursor_f_clienti.Close();
                  Cursor_f_clienti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_clienti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_clienti.Eof())) {
                    // * --- Insert into clientifrz from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("clientifrz");
                    m_cPhName = m_Ctx.GetPhName("clientifrz");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001AB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000001AB(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_clienti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_clienti.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_clienti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_clienti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_clienti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_clienti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_clienti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_clienti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
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
                    Cursor_f_clienti.Next();
                  }
                  m_cConnectivityError = Cursor_f_clienti.ErrorMessage();
                  Cursor_f_clienti.Close();
                  // * --- End Select
                } // End If
                /* If altriben=True  */
                if (CPLib.eqr(altriben,true)) {
                  /* _numrig := 1 */
                  _numrig = CPLib.Round(1,0);
                  // * --- Select from f_benefic
                  m_cServer = m_Ctx.GetServer("f_benefic");
                  m_cPhName = m_Ctx.GetPhName("f_benefic");
                  if (Cursor_f_benefic!=null)
                    Cursor_f_benefic.Close();
                  Cursor_f_benefic = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_benefic")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_benefic.Eof())) {
                    // * --- Insert into beneficfrz from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("beneficfrz");
                    m_cPhName = m_Ctx.GetPhName("beneficfrz");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001AF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000001AF(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_benefic.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_benefic.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
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
                    /* _numrig := _numrig + 1 */
                    _numrig = CPLib.Round(_numrig+1,0);
                    Cursor_f_benefic.Next();
                  }
                  m_cConnectivityError = Cursor_f_benefic.ErrorMessage();
                  Cursor_f_benefic.Close();
                  // * --- End Select
                } // End If
                /* If altriterz=True */
                if (CPLib.eqr(altriterz,true)) {
                  // * --- Select from f_terzisti
                  m_cServer = m_Ctx.GetServer("f_terzisti");
                  m_cPhName = m_Ctx.GetPhName("f_terzisti");
                  if (Cursor_f_terzisti!=null)
                    Cursor_f_terzisti.Close();
                  Cursor_f_terzisti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_terzisti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_terzisti.Eof())) {
                    // * --- Insert into terzistifrz from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("terzistifrz");
                    m_cPhName = m_Ctx.GetPhName("terzistifrz");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001B3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000001B3(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_terzisti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_terzisti.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_terzisti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_terzisti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_terzisti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_terzisti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_terzisti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_terzisti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
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
                    Cursor_f_terzisti.Next();
                  }
                  m_cConnectivityError = Cursor_f_terzisti.ErrorMessage();
                  Cursor_f_terzisti.Close();
                  // * --- End Select
                } // End If
                /* If altrisog=True  */
                if (CPLib.eqr(altrisog,true)) {
                  /* _numrig := 1 */
                  _numrig = CPLib.Round(1,0);
                  // * --- Select from f_soggetbo
                  m_cServer = m_Ctx.GetServer("f_soggetbo");
                  m_cPhName = m_Ctx.GetPhName("f_soggetbo");
                  if (Cursor_f_soggetbo!=null)
                    Cursor_f_soggetbo.Close();
                  Cursor_f_soggetbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_soggetbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_soggetbo.Eof())) {
                    // * --- Insert into sogopefbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("sogopefbo");
                    m_cPhName = m_Ctx.GetPhName("sogopefbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001B7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000001B7(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Upper(Cursor_f_soggetbo.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_soggetbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_soggetbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
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
                    /* _numrig := _numrig + 1 */
                    _numrig = CPLib.Round(_numrig+1,0);
                    Cursor_f_soggetbo.Next();
                  }
                  m_cConnectivityError = Cursor_f_soggetbo.ErrorMessage();
                  Cursor_f_soggetbo.Close();
                  // * --- End Select
                } // End If
                /* If altriagg */
                if (altriagg) {
                  // * --- Select from f_fraziobo_agg
                  m_cServer = m_Ctx.GetServer("f_fraziobo_agg");
                  m_cPhName = m_Ctx.GetPhName("f_fraziobo_agg");
                  if (Cursor_f_fraziobo_agg!=null)
                    Cursor_f_fraziobo_agg.Close();
                  Cursor_f_fraziobo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPLib.ToSQL(Cursor_qbe_f_fraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_fraziobo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_fraziobo_agg.Eof())) {
                    // * --- Insert into fraziobo_agg from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("fraziobo_agg");
                    m_cPhName = m_Ctx.GetPhName("fraziobo_agg");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo_agg",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001BB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000001BB(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetDouble("CACODICE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("IDBIGLIETT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetDateTime("CADATAORA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetDouble("CATIPGIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetDouble("CATIPCON"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetDouble("CAPV_COD"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("IDDOCALL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("VPCODICE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetDateTime("WUDATRET"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetDouble("FLAGFRAUD"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("SV58724"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("SV58726SCA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("SV58726SA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("SV58726PIS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("C_COGNOME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("C_NOME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_fraziobo_agg.GetString("SOSPAGAM"),"?",0,0,m_cServer)+", ";
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
                      throw new RoutineException();
                    }
                    Cursor_f_fraziobo_agg.Next();
                  }
                  m_cConnectivityError = Cursor_f_fraziobo_agg.ErrorMessage();
                  Cursor_f_fraziobo_agg.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_qbe_f_fraziobo.Next();
            }
            m_cConnectivityError = Cursor_qbe_f_fraziobo.ErrorMessage();
            Cursor_qbe_f_fraziobo.Close();
            // * --- End Select
            /* _pci := _pci + 1 */
            _pci = CPLib.Round(_pci+1,0);
          } // End While
          /* Verifico la presenza del contatore dei progressivi e dell'idbase. Per evitare errori in inserimento. */
          /* If _pci > _cicli */
          if (CPLib.gt(_pci,_cicli)) {
            /* idbase */
            /* check_prog := 0 */
            check_prog = CPLib.Round(0,0);
            // * --- Read from cpwarn
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_cSql = "";
            m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","C",100,0,m_cServer),m_cServer,"prog\\PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'");
            m_cSql = m_cSql+" and warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"C",10,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda));
            if (m_Ctx.IsSharedTemp("cpwarn")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("autonum",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              check_prog = Read_Cursor.GetDouble("autonum");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              check_prog = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If check_prog>0 */
            if (CPLib.gt(check_prog,0)) {
              /* Se riunisco lo storico con le operazioni sommo i due contatori del numero di operazioni, mentre per il numprog prendo il massimo di operazbo comunque */
              /* If pFlg='N' */
              if (CPLib.eqr(pFlg,"N")) {
                // * --- Write into cpwarn from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cpwarn");
                m_cPhName = m_Ctx.GetPhName("cpwarn");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001C5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_maxfon,"N",10,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
                m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda))+"";
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
                // * --- Write into cpwarn from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cpwarn");
                m_cPhName = m_Ctx.GetPhName("cpwarn");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001C6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"autonum = autonum+("+CPLib.ToSQL(_maxfon,"N",10,0)+"), ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
                m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda))+"";
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
              // * --- Insert into cpwarn from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpwarn");
              m_cPhName = m_Ctx.GetPhName("cpwarn");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001C7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001C7(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_maxfon,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer)+", ";
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
            } // End If
            /* numprog */
            /* check_prog := 0 */
            check_prog = CPLib.Round(0,0);
            // * --- Read from cpwarn
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_cSql = "";
            m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'","C",100,0,m_cServer),m_cServer,"prog\\PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'");
            m_cSql = m_cSql+" and warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"C",10,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda));
            if (m_Ctx.IsSharedTemp("cpwarn")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("autonum",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              check_prog = Read_Cursor.GetDouble("autonum");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              check_prog = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If check_prog>0 */
            if (CPLib.gt(check_prog,0)) {
              // * --- Select from qbe_tab_mmc
              SPBridge.HMCaller _h000001CC;
              _h000001CC = new SPBridge.HMCaller();
              _h000001CC.Set("m_cVQRList",m_cVQRList);
              _h000001CC.Set("tbname","fraziobo");
              _h000001CC.Set("fldname","NUMPROG");
              if (Cursor_qbe_tab_mmc!=null)
                Cursor_qbe_tab_mmc.Close();
              Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001CC,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_tab_mmc.Eof())) {
                // * --- Write into cpwarn from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cpwarn");
                m_cPhName = m_Ctx.GetPhName("cpwarn");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001CD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(Cursor_qbe_tab_mmc.GetDouble("max"),"N",10,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
                m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda))+"";
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
                Cursor_qbe_tab_mmc.Next();
              }
              m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
              Cursor_qbe_tab_mmc.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from qbe_tab_mmc
              SPBridge.HMCaller _h000001CE;
              _h000001CE = new SPBridge.HMCaller();
              _h000001CE.Set("m_cVQRList",m_cVQRList);
              _h000001CE.Set("tbname","fraziobo");
              _h000001CE.Set("fldname","NUMPROG");
              if (Cursor_qbe_tab_mmc!=null)
                Cursor_qbe_tab_mmc.Close();
              Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001CE,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_tab_mmc.Eof())) {
                // * --- Insert into cpwarn from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cpwarn");
                m_cPhName = m_Ctx.GetPhName("cpwarn");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001CF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001CF(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tab_mmc.GetDouble("max"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer)+", ";
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
                Cursor_qbe_tab_mmc.Next();
              }
              m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
              Cursor_qbe_tab_mmc.Close();
              // * --- End Select
            } // End If
            /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Frazionate' + NL */
            gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Frazionate"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgImp := 'Fine importazione del file Frazionate' // Messaggio Import */
            gMsgImp = "Fine importazione del file Frazionate";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            // Transaction Error
            cTry0000011Amsg = CPLib.FormatMsg(m_Ctx,"Errore nell'import delle frazionate");
            m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Errore nell'import delle frazionate"));
            throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Errore nell'import delle frazionate"));
          } // End If
        } // End If
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Frazionate' + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Frazionate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Fine importazione del file Frazionate' // Messaggio Import */
        gMsgImp = "Fine importazione del file Frazionate";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
        /* Debug Msg m_Sql.TransactionErrorMessage() */
        if ( ! (CPLib.IsNull(m_Debug))) {
          m_Debug.log(m_Sql.TransactionErrorMessage());
        }
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000011Astatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000011Astatus,cTry0000011Amsg);
        }
      }
    } finally {
      try {
        if (Cursor_f_clienti!=null)
          Cursor_f_clienti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_benefic!=null)
          Cursor_f_benefic.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_terzisti!=null)
          Cursor_f_terzisti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_soggetbo!=null)
          Cursor_f_soggetbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_operazbo_agg!=null)
          Cursor_f_operazbo_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_f_operazbo_totale!=null)
          Cursor_qbe_f_operazbo_totale.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_f_operazbo!=null)
          Cursor_qbe_f_operazbo.Close();
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
      try {
        if (Cursor_f_fraziobo_agg!=null)
          Cursor_f_fraziobo_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_f_fraziobo_totale!=null)
          Cursor_qbe_f_fraziobo_totale.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_f_fraziobo!=null)
          Cursor_qbe_f_fraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_6() throws Exception {
    CPResultSet Cursor_f_rapotit=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_f_inttitbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Informazioni Titolarità */
      /* check_prog Numeric(10, 0) */
      double check_prog;
      check_prog = 0;
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Informazioni Titolarità' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Informazioni Titolarità"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_rapotit
      m_cServer = m_Ctx.GetServer("f_rapotit");
      m_cPhName = m_Ctx.GetPhName("f_rapotit");
      if (Cursor_f_rapotit!=null)
        Cursor_f_rapotit.Close();
      Cursor_f_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_rapotit")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_rapotit.Eof())) {
        /* If not(Empty(f_rapotit->CONNESCLI)) */
        if ( ! (CPLib.Empty(Cursor_f_rapotit.GetString("CONNESCLI")))) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Informazioni Titolarità' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Informazioni Titolarità";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPTIT\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPTIT\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into rapotit from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapotit");
          m_cPhName = m_Ctx.GetPhName("rapotit");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001E1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000001E1(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_rapotit.GetDate("DATAOPE")),"18991230")?CPLib.NullDate():Cursor_f_rapotit.GetDate("DATAOPE")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_rapotit.GetDate("DATAREG")),"18991230")?CPLib.NullDate():Cursor_f_rapotit.GetDate("DATAREG")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_rapotit.GetString("CONNESCLI")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_rapotit.GetString("CONNESOPER")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_rapotit.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_rapotit.GetDate("DATAAGE")),"18991230")?CPLib.NullDate():Cursor_f_rapotit.GetDate("DATAAGE")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_rapotit.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_f_rapotit.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
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
        } // End If
        Cursor_f_rapotit.Next();
      }
      m_cConnectivityError = Cursor_f_rapotit.ErrorMessage();
      Cursor_f_rapotit.Close();
      // * --- End Select
      /* Idbase */
      /* check_prog := 0 */
      check_prog = CPLib.Round(0,0);
      // * --- Read from cpwarn
      m_cServer = m_Ctx.GetServer("cpwarn");
      m_cPhName = m_Ctx.GetPhName("cpwarn");
      m_cSql = "";
      m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGTITO1\\'"+CPLib.LRTrim(gAzienda)+"'","C",100,0,m_cServer),m_cServer,"prog\\PRGTITO1\\'"+CPLib.LRTrim(gAzienda)+"'");
      m_cSql = m_cSql+" and warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"C",10,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda));
      if (m_Ctx.IsSharedTemp("cpwarn")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("autonum",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        check_prog = Read_Cursor.GetDouble("autonum");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        check_prog = 0;
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If check_prog>0 */
      if (CPLib.gt(check_prog,0)) {
        // * --- Write into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001E6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_maxfon,"N",10,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGTITO1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGTITO1\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
        m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda))+"";
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001E7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000001E7(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGTITO1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_maxfon,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer)+", ";
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
        }
      } // End If
      /* Progessivo */
      /* check_prog := 0 */
      check_prog = CPLib.Round(0,0);
      // * --- Read from cpwarn
      m_cServer = m_Ctx.GetServer("cpwarn");
      m_cPhName = m_Ctx.GetPhName("cpwarn");
      m_cSql = "";
      m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'","C",100,0,m_cServer),m_cServer,"prog\\PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'");
      m_cSql = m_cSql+" and warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"C",10,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda));
      if (m_Ctx.IsSharedTemp("cpwarn")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("autonum",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        check_prog = Read_Cursor.GetDouble("autonum");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        check_prog = 0;
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If check_prog>0 */
      if (CPLib.gt(check_prog,0)) {
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000001EC;
        _h000001EC = new SPBridge.HMCaller();
        _h000001EC.Set("m_cVQRList",m_cVQRList);
        _h000001EC.Set("tbname","rapotit");
        _h000001EC.Set("fldname","NUMPROG");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001EC,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001ED")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(Cursor_qbe_tab_mmc.GetDouble("max"),"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda))+"";
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
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } else { // Else
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000001EE;
        _h000001EE = new SPBridge.HMCaller();
        _h000001EE.Set("m_cVQRList",m_cVQRList);
        _h000001EE.Set("tbname","rapotit");
        _h000001EE.Set("fldname","NUMPROG");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001EE,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          // * --- Insert into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001EF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000001EF(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tab_mmc.GetDouble("max"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer)+", ";
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
          }
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } // End If
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Informazioni Titolarità' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Informazioni Titolarità"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_inttitbo
      m_cServer = m_Ctx.GetServer("f_inttitbo");
      m_cPhName = m_Ctx.GetPhName("f_inttitbo");
      if (Cursor_f_inttitbo!=null)
        Cursor_f_inttitbo.Close();
      Cursor_f_inttitbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_inttitbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_inttitbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file di intestazione Titolarità' // Messaggio Import */
        gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file di intestazione Titolarità";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* nProgImp := Utilities.GetAutonumber("PRGIMPTITE\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPTITE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        // * --- Insert into intestit from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("intestit");
        m_cPhName = m_Ctx.GetPhName("intestit");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestit",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000001F6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000001F6(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_inttitbo.GetString("CONNESCLI")),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_inttitbo.GetString("CODINTER")),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetDate("DATAINI"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetDate("DATARETT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetDate("DATAFINE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_inttitbo.GetDouble("ABBINATO"),"?",0,0)+", ";
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
        Cursor_f_inttitbo.Next();
      }
      m_cConnectivityError = Cursor_f_inttitbo.ErrorMessage();
      Cursor_f_inttitbo.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file di intestazioni Titolarità' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file di intestazioni Titolarità"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Informazioni Titolarità' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Informazioni Titolarità"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Informazioni Titolarità' // Messaggio Import */
      gMsgImp = "Fine importazione del file Informazioni Titolarità";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_f_rapotit!=null)
          Cursor_f_rapotit.Close();
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
      try {
        if (Cursor_f_inttitbo!=null)
          Cursor_f_inttitbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_7() throws Exception {
    CPResultSet Cursor_f_jnarapbo=null;
    CPResultSet Cursor_f_jntestbo=null;
    CPResultSet Cursor_f_japopebo=null;
    try {
      /* Dati Rapporti */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Rapporti (AGE)' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Rapporti (AGE)"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_jnarapbo
      m_cServer = m_Ctx.GetServer("f_jnarapbo");
      m_cPhName = m_Ctx.GetPhName("f_jnarapbo");
      if (Cursor_f_jnarapbo!=null)
        Cursor_f_jnarapbo.Close();
      Cursor_f_jnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_jnarapbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_jnarapbo.Eof())) {
        /* If not(Empty(f_jnarapbo->RAPPORTO)) */
        if ( ! (CPLib.Empty(Cursor_f_jnarapbo.GetString("RAPPORTO")))) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Rapporti (AGE)' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Rapporti (AGE)";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPRAPAGE\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAPAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into jnarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("jnarapbo");
          m_cPhName = m_Ctx.GetPhName("jnarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jnarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000202")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000202(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetDouble("NOPROT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_jnarapbo.GetDate("DATAMOD")),"18991230")?CPLib.NullDate():Cursor_f_jnarapbo.GetDate("DATAMOD")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetDouble("RTIPO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetDouble("RCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetDouble("RIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetDouble("RFREQ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetDouble("RRAGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetDouble("RAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jnarapbo",true);
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
          /* _numrig := 1 */
          _numrig = CPLib.Round(1,0);
          // * --- Select from f_jntestbo
          m_cServer = m_Ctx.GetServer("f_jntestbo");
          m_cPhName = m_Ctx.GetPhName("f_jntestbo");
          if (Cursor_f_jntestbo!=null)
            Cursor_f_jntestbo.Close();
          Cursor_f_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_f_jnarapbo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_f_jntestbo.Eof())) {
            /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOGAGE\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOGAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into jntestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("jntestbo");
            m_cPhName = m_Ctx.GetPhName("jntestbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000206")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000206(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jntestbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_jntestbo.GetDate("DATAINI")),"18991230")?CPLib.NullDate():Cursor_f_jntestbo.GetDate("DATAINI")),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jntestbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_jntestbo.GetString("CODINTER")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_jntestbo.GetDate("DATAFINE")),"18991230")?CPLib.NullDate():Cursor_f_jntestbo.GetDate("DATAFINE")),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jntestbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jntestbo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jntestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jntestbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jntestbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jntestbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jntestbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_jntestbo.GetDate("DATARETT")),"18991230")?CPLib.NullDate():Cursor_f_jntestbo.GetDate("DATARETT")),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jntestbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jntestbo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jntestbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_jntestbo.GetDouble("ABBINATO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jntestbo",true);
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
            /* _numrig := _numrig + 1 */
            _numrig = CPLib.Round(_numrig+1,0);
            Cursor_f_jntestbo.Next();
          }
          m_cConnectivityError = Cursor_f_jntestbo.ErrorMessage();
          Cursor_f_jntestbo.Close();
          // * --- End Select
        } // End If
        Cursor_f_jnarapbo.Next();
      }
      m_cConnectivityError = Cursor_f_jnarapbo.ErrorMessage();
      Cursor_f_jnarapbo.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Rapporti (AGE)'+ NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Rapporti (AGE)"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Rappoorti (AGE)' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Rappoorti (AGE)"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Rapporti (AGE)' // Messaggio Import */
      gMsgImp = "Fine importazione del file Rapporti (AGE)";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Informazioni Rapporti */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Informazioni Rapporti (AGE)' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Informazioni Rapporti (AGE)"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_japopebo
      m_cServer = m_Ctx.GetServer("f_japopebo");
      m_cPhName = m_Ctx.GetPhName("f_japopebo");
      if (Cursor_f_japopebo!=null)
        Cursor_f_japopebo.Close();
      Cursor_f_japopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_japopebo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_japopebo.Eof())) {
        /* If not(Empty(f_japopebo->RAPPORTO)) */
        if ( ! (CPLib.Empty(Cursor_f_japopebo.GetString("RAPPORTO")))) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Informazioni Rapporti (AGE)' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Informazioni Rapporti (AGE)";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPINFAGE\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINFAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into japopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("japopebo");
          m_cPhName = m_Ctx.GetPhName("japopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000213")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000213(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_japopebo.GetDate("DATAOPE")),"18991230")?CPLib.NullDate():Cursor_f_japopebo.GetDate("DATAOPE")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_japopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_japopebo.GetDate("DATAREG")),"18991230")?CPLib.NullDate():Cursor_f_japopebo.GetDate("DATAREG")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_japopebo.GetString("CONNESCLI")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_japopebo.GetString("CONNESOPER")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_japopebo.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_japopebo.GetDate("DATAAGE")),"18991230")?CPLib.NullDate():Cursor_f_japopebo.GetDate("DATAAGE")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_japopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_f_japopebo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"japopebo",true);
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
        Cursor_f_japopebo.Next();
      }
      m_cConnectivityError = Cursor_f_japopebo.ErrorMessage();
      Cursor_f_japopebo.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Informazioni Rapporti (AGE)' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Informazioni Rapporti (AGE)"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Informazioni Rapporti (AGE)' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Informazioni Rapporti (AGE)"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Informazioni Rapporti (AGE)' // Messaggio Import */
      gMsgImp = "Fine importazione del file Informazioni Rapporti (AGE)";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_f_jnarapbo!=null)
          Cursor_f_jnarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_jntestbo!=null)
          Cursor_f_jntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_japopebo!=null)
          Cursor_f_japopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_8() throws Exception {
    CPResultSet Cursor_f_aetesta=null;
    CPResultSet Cursor_f_aerighe=null;
    CPResultSet Read_Cursor=null;
    try {
      /* Legge la tabella aetesta e aggiunge i record */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Anagrafe dei rapporti' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Anagrafe dei rapporti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_aetesta
      m_cServer = m_Ctx.GetServer("f_aetesta");
      m_cPhName = m_Ctx.GetPhName("f_aetesta");
      if (Cursor_f_aetesta!=null)
        Cursor_f_aetesta.Close();
      Cursor_f_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_aetesta")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_aetesta.Eof())) {
        /* If not(Empty(f_aetesta->RAPPORTO)) */
        if ( ! (CPLib.Empty(Cursor_f_aetesta.GetString("RAPPORTO")))) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Anagrafe dei Rapporti' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Anagrafe dei Rapporti";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* nProgImp := Utilities.GetAutonumber("PROGAET\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAET\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into aetesta from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aetesta");
          m_cPhName = m_Ctx.GetPhName("aetesta");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000021F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000021F(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetString("COINT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetString("RIFANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetString("DESCRI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetString("UNIQUE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetString("CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetString("OLDINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetDate("DATAMODI"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetDouble("INVIATO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetDate("DATAINVIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetDouble("ANNULLA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetDate("DATAANNU"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetString("OLDUNIQUE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetDate("DATAOLDUNI"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetString("IDESITO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetDouble("INVIATOC"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aetesta.GetDate("DATAINVIOC"),"?",0,0)+", ";
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
          /* _numrig := 1 */
          _numrig = CPLib.Round(1,0);
          // * --- Select from f_aerighe
          m_cServer = m_Ctx.GetServer("f_aerighe");
          m_cPhName = m_Ctx.GetPhName("f_aerighe");
          if (Cursor_f_aerighe!=null)
            Cursor_f_aerighe.Close();
          Cursor_f_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_f_aetesta.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_f_aerighe.Eof())) {
            /* If not(Empty(f_aerighe->CONNESINT)) */
            if ( ! (CPLib.Empty(Cursor_f_aerighe.GetString("CONNESINT")))) {
              /* nProgImp2 := Utilities.GetAutonumber("PROGAER\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAER\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(Cursor_f_aerighe.GetString("CONNESINT")),"C",16,0,m_cServer),m_cServer,CPLib.Upper(Cursor_f_aerighe.GetString("CONNESINT")));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CFESTERO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _nocodfis = CPLib.Round(Read_Cursor.GetDouble("CFESTERO"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _nocodfis = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              // * --- Insert into aerighe from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000225")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000225(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetDouble("ABBINATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_aerighe.GetDate("ADATA")),"18991230")?CPLib.NullDate():Cursor_f_aerighe.GetDate("ADATA")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_aerighe.GetDate("ADATARET")),"18991230")?CPLib.NullDate():Cursor_f_aerighe.GetDate("ADATARET")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_aerighe.GetDate("ADTPRE")),"18991230")?CPLib.NullDate():Cursor_f_aerighe.GetDate("ADTPRE")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("ANNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("AOLDFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("AOLDPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("APROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetDouble("ASPEDITO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_aerighe.GetDate("CDATA")),"18991230")?CPLib.NullDate():Cursor_f_aerighe.GetDate("CDATA")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_aerighe.GetDate("CDATARET")),"18991230")?CPLib.NullDate():Cursor_f_aerighe.GetDate("CDATARET")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_aerighe.GetDate("CDTPRE")),"18991230")?CPLib.NullDate():Cursor_f_aerighe.GetDate("CDTPRE")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("CFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("COLDFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("COLDPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Upper(Cursor_f_aerighe.GetString("CONNESINT")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("CPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetDouble("CSPEDITO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("ESITOANNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("FILEANNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nocodfis,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("PROG1"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("PROG2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("PROGREC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aerighe.GetDouble("RSPEDITO"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aerighe",true);
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
              /* _numrig := _numrig + 1 */
              _numrig = CPLib.Round(_numrig+1,0);
            } // End If
            Cursor_f_aerighe.Next();
          }
          m_cConnectivityError = Cursor_f_aerighe.ErrorMessage();
          Cursor_f_aerighe.Close();
          // * --- End Select
        } // End If
        Cursor_f_aetesta.Next();
      }
      m_cConnectivityError = Cursor_f_aetesta.ErrorMessage();
      Cursor_f_aetesta.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Anagrafe dei rapporti' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Anagrafe dei rapporti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Anagrafe dei rapporti' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Anagrafe dei rapporti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Anagrafe dei rapporti' // Messaggio Import */
      gMsgImp = "Fine importazione del file Anagrafe dei rapporti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_f_aetesta!=null)
          Cursor_f_aetesta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_aerighe!=null)
          Cursor_f_aerighe.Close();
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
  void Page_9() throws Exception {
    CPResultSet Cursor_f_aederig=null;
    CPResultSet Cursor_f_aedestor=null;
    CPResultSet Cursor_f_aedecanc=null;
    CPResultSet Cursor_qbe_f_aeoprig_totale=null;
    CPResultSet Cursor_qbe_f_aeoprig=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Legge la tabella aederig e aggiunge i record */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Deleghe' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Deleghe"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_aederig
      m_cServer = m_Ctx.GetServer("f_aederig");
      m_cPhName = m_Ctx.GetPhName("f_aederig");
      if (Cursor_f_aederig!=null)
        Cursor_f_aederig.Close();
      Cursor_f_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_aederig")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_aederig.Eof())) {
        /* If not(Empty(f_aederig->CONNESINT)) */
        if ( ! (CPLib.Empty(Cursor_f_aederig.GetString("CONNESINT")))) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Deleghe' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Deleghe";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* nProgImp := Utilities.GetAutonumber("PROGAED\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAED\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000232")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000232(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_aederig.GetDate("ADATA")),"18991230")?CPLib.NullDate():Cursor_f_aederig.GetDate("ADATA")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_aederig.GetDate("ADATARET")),"18991230")?CPLib.NullDate():Cursor_f_aederig.GetDate("ADATARET")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_aederig.GetDate("ADTPRE")),"18991230")?CPLib.NullDate():Cursor_f_aederig.GetDate("ADTPRE")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetString("AOLDFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetString("AOLDPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetString("APROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetDouble("ASPEDITO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_aederig.GetDate("CDATA")),"18991230")?CPLib.NullDate():Cursor_f_aederig.GetDate("CDATA")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_aederig.GetDate("CDATARET")),"18991230")?CPLib.NullDate():Cursor_f_aederig.GetDate("CDATARET")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_aederig.GetDate("CDTPRE")),"18991230")?CPLib.NullDate():Cursor_f_aederig.GetDate("CDTPRE")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetString("CFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetString("COINT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetString("COLDFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetString("COLDPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_aederig.GetString("CONNESINT")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetString("CPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetDouble("CSPEDITO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetDouble("RSPEDITO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aederig.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aederig",true);
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
        Cursor_f_aederig.Next();
      }
      m_cConnectivityError = Cursor_f_aederig.ErrorMessage();
      Cursor_f_aederig.Close();
      // * --- End Select
      // * --- Select from f_aedestor
      m_cServer = m_Ctx.GetServer("f_aedestor");
      m_cPhName = m_Ctx.GetPhName("f_aedestor");
      if (Cursor_f_aedestor!=null)
        Cursor_f_aedestor.Close();
      Cursor_f_aedestor = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_aedestor")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_aedestor.Eof())) {
        /* If not(Empty(f_aedestor->CONNESINT)) */
        if ( ! (CPLib.Empty(Cursor_f_aedestor.GetString("CONNESINT")))) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Storico Deleghe' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Storico Deleghe";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* cProg := Utilities.GetAutonumber("PSTOAGE\'"+LRTrim(gAzienda)+"'",'',10) */
          cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          // * --- Insert into aedestor from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aedestor");
          m_cPhName = m_Ctx.GetPhName("aedestor");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aedestor",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000238")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000238(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_aedestor.GetString("CONNESINT")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetDouble("ASPEDITO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetDate("ADATA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetString("APROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetString("AFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetDate("ADATARET"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetDouble("CSPEDITO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetDate("CDATA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetString("CPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetString("CFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetDate("CDATARET"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetDate("ADTPRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetDate("CDTPRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetString("COINT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetDouble("ABBINATO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetString("IDESITO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedestor.GetString("IDESITO"),"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aedestor",true);
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
        Cursor_f_aedestor.Next();
      }
      m_cConnectivityError = Cursor_f_aedestor.ErrorMessage();
      Cursor_f_aedestor.Close();
      // * --- End Select
      // * --- Select from f_aedecanc
      m_cServer = m_Ctx.GetServer("f_aedecanc");
      m_cPhName = m_Ctx.GetPhName("f_aedecanc");
      if (Cursor_f_aedecanc!=null)
        Cursor_f_aedecanc.Close();
      Cursor_f_aedecanc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_aedecanc")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_aedecanc.Eof())) {
        /* If not(Empty(f_aedecanc->CONNESINT)) */
        if ( ! (CPLib.Empty(Cursor_f_aedecanc.GetString("CONNESINT")))) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Storico Deleghe' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Storico Deleghe";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* cCanc := Utilities.GetAutonumber("PDELAGE\'"+LRTrim(gAzienda)+"'",'',10) */
          cCanc = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PDELAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          // * --- Insert into aedecanc from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aedecanc");
          m_cPhName = m_Ctx.GetPhName("aedecanc");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aedecanc",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000023E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000023E(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cCanc,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_aedecanc.GetString("CONNESINT")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetDouble("ASPEDITO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetDate("ADATA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("APROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("AOLDPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("AFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("AOLDFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetDate("ADATARET"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetDouble("CSPEDITO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetDate("CDATA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("CPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("COLDPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("CFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("COLDFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetDate("CDATARET"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("RIFRIGA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("COINT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("RIFSTOR"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetDate("DATARIF"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("TIPOCAN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("IDPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetDate("ADTPRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetDate("CDTPRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetDouble("ABBINATO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("IDESITO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aedecanc.GetString("OLDINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aedecanc",true);
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
        Cursor_f_aedecanc.Next();
      }
      m_cConnectivityError = Cursor_f_aedecanc.ErrorMessage();
      Cursor_f_aedecanc.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Deleghe' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Deleghe"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Deleghe' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Deleghe"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Deleghe' // Messaggio Import */
      gMsgImp = "Fine importazione del file Deleghe";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Legge la tabella aeoprig e aggiunge i record */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Oper. Extraconto' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Oper. Extraconto"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* _maxfon := 0 */
      _maxfon = CPLib.Round(0,0);
      // * --- Select from qbe_f_aeoprig_totale
      if (Cursor_qbe_f_aeoprig_totale!=null)
        Cursor_qbe_f_aeoprig_totale.Close();
      Cursor_qbe_f_aeoprig_totale = new VQRHolder("qbe_f_aeoprig_totale",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_f_aeoprig_totale.Eof())) {
        /* _maxfon := qbe_f_aeoprig_totale->TOTALE */
        _maxfon = CPLib.Round(Cursor_qbe_f_aeoprig_totale.GetDouble("TOTALE"),0);
        Cursor_qbe_f_aeoprig_totale.Next();
      }
      m_cConnectivityError = Cursor_qbe_f_aeoprig_totale.ErrorMessage();
      Cursor_qbe_f_aeoprig_totale.Close();
      // * --- End Select
      /* If _maxfon <= 20000 */
      if (CPLib.le(_maxfon,20000)) {
        /* _cicli := 1 */
        _cicli = CPLib.Round(1,0);
      } else { // Else
        /* _cicli := iif(Mod(_maxfon,20000) <> 0,Int(_maxfon/20000) + 1,Int(_maxfon/20000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_maxfon,20000),0)?CPLib.Int(_maxfon/20000)+1:CPLib.Int(_maxfon/20000)),0);
      } // End If
      /* While _pci <= _cicli */
      while (CPLib.le(_pci,_cicli)) {
        /* _bot := ((_pci -1 ) * 20000) + 1 */
        _bot = CPLib.Round(((_pci-1)*20000)+1,0);
        /* _top := _pci * 20000 */
        _top = CPLib.Round(_pci*20000,0);
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000250status;
        nTry00000250status = m_Sql.GetTransactionStatus();
        String cTry00000250msg;
        cTry00000250msg = m_Sql.TransactionErrorMessage();
        try {
          // * --- Select from qbe_f_aeoprig
          SPBridge.HMCaller _h00000251;
          _h00000251 = new SPBridge.HMCaller();
          _h00000251.Set("m_cVQRList",m_cVQRList);
          _h00000251.Set("_bot",_bot);
          _h00000251.Set("_top",_top);
          if (Cursor_qbe_f_aeoprig!=null)
            Cursor_qbe_f_aeoprig.Close();
          Cursor_qbe_f_aeoprig = new VQRHolder("qbe_f_aeoprig",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000251,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_f_aeoprig.Eof())) {
            /* If not(Empty(qbe_f_aeoprig->CONNESINT)) */
            if ( ! (CPLib.Empty(Cursor_qbe_f_aeoprig.GetString("CONNESINT")))) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Oper. Extraconto' // Messaggio Import */
              gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Oper. Extraconto";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* nProgImp := Utilities.GetAutonumber("PROGAEO\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAEO\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              // * --- Insert into aeoprig from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aeoprig");
              m_cPhName = m_Ctx.GetPhName("aeoprig");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000256")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000256(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_aeoprig.GetDate("ADATA")),"18991230")?CPLib.NullDate():Cursor_qbe_f_aeoprig.GetDate("ADATA")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_aeoprig.GetDate("ADATARET")),"18991230")?CPLib.NullDate():Cursor_qbe_f_aeoprig.GetDate("ADATARET")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_aeoprig.GetDate("ADTPRE")),"18991230")?CPLib.NullDate():Cursor_qbe_f_aeoprig.GetDate("ADTPRE")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetString("AOLDFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetString("AOLDPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetString("APROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetDouble("ASPEDITO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_aeoprig.GetDate("CDATA")),"18991230")?CPLib.NullDate():Cursor_qbe_f_aeoprig.GetDate("CDATA")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_aeoprig.GetDate("CDATARET")),"18991230")?CPLib.NullDate():Cursor_qbe_f_aeoprig.GetDate("CDATARET")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_aeoprig.GetDate("CDTPRE")),"18991230")?CPLib.NullDate():Cursor_qbe_f_aeoprig.GetDate("CDTPRE")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetString("CFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetString("COLDFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetString("COLDPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_aeoprig.GetString("CONNESINT")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetString("CPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetDouble("CSPEDITO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_aeoprig.GetDouble("RSPEDITO"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeoprig",true);
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
            Cursor_qbe_f_aeoprig.Next();
          }
          m_cConnectivityError = Cursor_qbe_f_aeoprig.ErrorMessage();
          Cursor_qbe_f_aeoprig.Close();
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
          // * --- Delete from aeoprig
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aeoprig");
          m_cPhName = m_Ctx.GetPhName("aeoprig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000259")+"delete from "+m_oWrInfo.GetTableWriteName();
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
          }
          // Exit Loop
          if (true) {
            break;
          }
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000250status,0)) {
            m_Sql.SetTransactionStatus(nTry00000250status,cTry00000250msg);
          }
        }
        /* _pci := _pci + 1 */
        _pci = CPLib.Round(_pci+1,0);
      } // End While
      /* If _pci > _cicli */
      if (CPLib.gt(_pci,_cicli)) {
        /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Oper. Extraconto' + NL */
        gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Oper. Extraconto"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + 'Elaborazione terminata con errori. Import abortito' + NL */
        gMsgProc = gMsgProc+"Elaborazione terminata con errori. Import abortito"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Oper. Extraconto' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Oper. Extraconto"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Oper. Extraconto' // Messaggio Import */
      gMsgImp = "Fine importazione del file Oper. Extraconto";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_f_aederig!=null)
          Cursor_f_aederig.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_aedestor!=null)
          Cursor_f_aedestor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_aedecanc!=null)
          Cursor_f_aedecanc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_f_aeoprig_totale!=null)
          Cursor_qbe_f_aeoprig_totale.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_f_aeoprig!=null)
          Cursor_qbe_f_aeoprig.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_10() throws Exception {
    CPResultSet Cursor_f_xnarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_f_xntestbo=null;
    CPResultSet Cursor_f_xapopebo=null;
    CPResultSet Cursor_f_xoggetbo=null;
    try {
      /* Dati Rapporti P */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Rapporti P' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Rapporti P"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_xnarapbo
      m_cServer = m_Ctx.GetServer("f_xnarapbo");
      m_cPhName = m_Ctx.GetPhName("f_xnarapbo");
      if (Cursor_f_xnarapbo!=null)
        Cursor_f_xnarapbo.Close();
      Cursor_f_xnarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_xnarapbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_xnarapbo.Eof())) {
        /* If not(Empty(f_xnarapbo->RAPPORTO)) */
        if ( ! (CPLib.Empty(Cursor_f_xnarapbo.GetString("RAPPORTO")))) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Rapporti P' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Rapporti P";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPRAP\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAP\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into xnarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xnarapbo");
          m_cPhName = m_Ctx.GetPhName("xnarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xnarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000269")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000269(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_xnarapbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_xnarapbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetDouble("NOPROT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_xnarapbo.GetDate("DATAMOD")),"18991230")?CPLib.NullDate():Cursor_f_xnarapbo.GetDate("DATAMOD")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetDouble("RTIPO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetDouble("RCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetDouble("RIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetDouble("RFREQ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetDouble("RRAGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetDouble("RAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xnarapbo",true);
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
          /* _codrap := '' */
          _codrap = "";
          // * --- Read from knarapbo
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_f_xnarapbo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_f_xnarapbo.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("knarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _codrap = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _codrap = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(_codrap) */
          if (CPLib.Empty(_codrap)) {
            // * --- Insert into knarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000026D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000026D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"knarapbo",true);
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
            // * --- Write into knarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("knarapbo");
            m_cPhName = m_Ctx.GetPhName("knarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000026E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("DESCRAP"),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL("P","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"knarapbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_f_xnarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_f_xnarapbo.GetString("RAPPORTO"))+"";
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
          /* _numrig := 1 */
          _numrig = CPLib.Round(1,0);
          // * --- Select from f_xntestbo
          m_cServer = m_Ctx.GetServer("f_xntestbo");
          m_cPhName = m_Ctx.GetPhName("f_xntestbo");
          if (Cursor_f_xntestbo!=null)
            Cursor_f_xntestbo.Close();
          Cursor_f_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_f_xnarapbo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_f_xntestbo.Eof())) {
            /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Intestatari Rapporti P' // Messaggio Import */
            gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Intestatari Rapporti P";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into xntestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000273")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000273(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xntestbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_xntestbo.GetDate("DATAINI")),"18991230")?CPLib.NullDate():Cursor_f_xntestbo.GetDate("DATAINI")),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xntestbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Upper(Cursor_f_xntestbo.GetString("CODINTER")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_xntestbo.GetDate("DATAFINE")),"18991230")?CPLib.NullDate():Cursor_f_xntestbo.GetDate("DATAFINE")),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xntestbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xntestbo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xntestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xntestbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xntestbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xntestbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xntestbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_xntestbo.GetDate("DATARETT")),"18991230")?CPLib.NullDate():Cursor_f_xntestbo.GetDate("DATARETT")),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xntestbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xntestbo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xntestbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xntestbo",true);
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
            /* _numrig := _numrig + 1 */
            _numrig = CPLib.Round(_numrig+1,0);
            Cursor_f_xntestbo.Next();
          }
          m_cConnectivityError = Cursor_f_xntestbo.ErrorMessage();
          Cursor_f_xntestbo.Close();
          // * --- End Select
        } // End If
        Cursor_f_xnarapbo.Next();
      }
      m_cConnectivityError = Cursor_f_xnarapbo.ErrorMessage();
      Cursor_f_xnarapbo.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Rapporti P' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Rapporti P"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Rapporti P' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Rapporti P"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Rapporti P' // Messaggio Import */
      gMsgImp = "Fine importazione del file Rapporti P";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Informazioni Rapporti P */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Informazioni Rapporti P' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Informazioni Rapporti P"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_xapopebo
      m_cServer = m_Ctx.GetServer("f_xapopebo");
      m_cPhName = m_Ctx.GetPhName("f_xapopebo");
      if (Cursor_f_xapopebo!=null)
        Cursor_f_xapopebo.Close();
      Cursor_f_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_xapopebo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_xapopebo.Eof())) {
        /* If not(Empty(f_xapopebo->RAPPORTO)) */
        if ( ! (CPLib.Empty(Cursor_f_xapopebo.GetString("RAPPORTO")))) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Informazioni Rapporti P' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Informazioni Rapporti P";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into xapopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xapopebo");
          m_cPhName = m_Ctx.GetPhName("xapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000280")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000280(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_xapopebo.GetDate("DATAOPE")),"18991230")?CPLib.NullDate():Cursor_f_xapopebo.GetDate("DATAOPE")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_xapopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_xapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_xapopebo.GetDate("DATAREG")),"18991230")?CPLib.NullDate():Cursor_f_xapopebo.GetDate("DATAREG")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_xapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Upper(Cursor_f_xapopebo.GetString("CONNESCLI")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xapopebo.GetString("CONNESOPER")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xapopebo.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_xapopebo.GetDate("DATAAGE")),"18991230")?CPLib.NullDate():Cursor_f_xapopebo.GetDate("DATAAGE")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_f_xapopebo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xapopebo",true);
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
          /* _numrig := 1 */
          _numrig = CPLib.Round(1,0);
          // * --- Select from f_xoggetbo
          m_cServer = m_Ctx.GetServer("f_xoggetbo");
          m_cPhName = m_Ctx.GetPhName("f_xoggetbo");
          if (Cursor_f_xoggetbo!=null)
            Cursor_f_xoggetbo.Close();
          Cursor_f_xoggetbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_f_xapopebo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_xoggetbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_f_xoggetbo.Eof())) {
            // * --- Insert into xoginfo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xoginfo");
            m_cPhName = m_Ctx.GetPhName("xoginfo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xoginfo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000283")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000283(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Upper(Cursor_f_xoggetbo.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_xoggetbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xoginfo",true);
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
            /* _numrig := _numrig + 1 */
            _numrig = CPLib.Round(_numrig+1,0);
            Cursor_f_xoggetbo.Next();
          }
          m_cConnectivityError = Cursor_f_xoggetbo.ErrorMessage();
          Cursor_f_xoggetbo.Close();
          // * --- End Select
        } // End If
        Cursor_f_xapopebo.Next();
      }
      m_cConnectivityError = Cursor_f_xapopebo.ErrorMessage();
      Cursor_f_xapopebo.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Informazioni Rapporti P' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Informazioni Rapporti P"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Informazioni Rapporti P' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Informazioni Rapporti P"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Informazioni Rapporti P' // Messaggio Import */
      gMsgImp = "Fine importazione del file Informazioni Rapporti P";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_f_xnarapbo!=null)
          Cursor_f_xnarapbo.Close();
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
        if (Cursor_f_xntestbo!=null)
          Cursor_f_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_xapopebo!=null)
          Cursor_f_xapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_xoggetbo!=null)
          Cursor_f_xoggetbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_11() throws Exception {
    CPResultSet Cursor_f_xperazbo=null;
    CPResultSet Cursor_f_xlienti=null;
    CPResultSet Cursor_f_xenefic=null;
    CPResultSet Cursor_f_xerzisti=null;
    CPResultSet Cursor_f_xoggetbo=null;
    CPResultSet Cursor_f_xraziobo=null;
    try {
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000289status;
      nTry00000289status = m_Sql.GetTransactionStatus();
      String cTry00000289msg;
      cTry00000289msg = m_Sql.TransactionErrorMessage();
      try {
        /* Operazioni P */
        /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni P' +NL */
        gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni P"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        // * --- Select from f_xperazbo
        m_cServer = m_Ctx.GetServer("f_xperazbo");
        m_cPhName = m_Ctx.GetPhName("f_xperazbo");
        if (Cursor_f_xperazbo!=null)
          Cursor_f_xperazbo.Close();
        Cursor_f_xperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_xperazbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_f_xperazbo.Eof())) {
          /* If not(Empty(f_xperazbo->IDBASE)) */
          if ( ! (CPLib.Empty(Cursor_f_xperazbo.GetString("IDBASE")))) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Operazioni P' // Messaggio Import */
            gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Operazioni P";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into xperazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000292")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000292(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_f_xperazbo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_f_xperazbo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xperazbo.GetString("CONNALTRO")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xperazbo.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xperazbo.GetString("CONNESCLI")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xperazbo.GetString("CONNESOPER")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetDate("DATAIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetDouble("PAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xperazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xperazbo",true);
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
            // * --- Select from f_xlienti
            m_cServer = m_Ctx.GetServer("f_xlienti");
            m_cPhName = m_Ctx.GetPhName("f_xlienti");
            if (Cursor_f_xlienti!=null)
              Cursor_f_xlienti.Close();
            Cursor_f_xlienti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_f_xperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_xlienti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_f_xlienti.Eof())) {
              // * --- Insert into xlientiope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xlientiope");
              m_cPhName = m_Ctx.GetPhName("xlientiope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientiope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000294")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000294(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xlienti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xlienti.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xlienti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xlienti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xlienti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xlienti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xlienti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xlienti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xlientiope",true);
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
              Cursor_f_xlienti.Next();
            }
            m_cConnectivityError = Cursor_f_xlienti.ErrorMessage();
            Cursor_f_xlienti.Close();
            // * --- End Select
            /* _numrig := 1 */
            _numrig = CPLib.Round(1,0);
            // * --- Select from f_xenefic
            m_cServer = m_Ctx.GetServer("f_xenefic");
            m_cPhName = m_Ctx.GetPhName("f_xenefic");
            if (Cursor_f_xenefic!=null)
              Cursor_f_xenefic.Close();
            Cursor_f_xenefic = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_f_xperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_xenefic")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_f_xenefic.Eof())) {
              // * --- Insert into xeneficope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xeneficope");
              m_cPhName = m_Ctx.GetPhName("xeneficope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000297")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000297(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xenefic.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xeneficope",true);
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
              /* _numrig := _numrig + 1 */
              _numrig = CPLib.Round(_numrig+1,0);
              Cursor_f_xenefic.Next();
            }
            m_cConnectivityError = Cursor_f_xenefic.ErrorMessage();
            Cursor_f_xenefic.Close();
            // * --- End Select
            // * --- Select from f_xerzisti
            m_cServer = m_Ctx.GetServer("f_xerzisti");
            m_cPhName = m_Ctx.GetPhName("f_xerzisti");
            if (Cursor_f_xerzisti!=null)
              Cursor_f_xerzisti.Close();
            Cursor_f_xerzisti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_f_xperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_xerzisti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_f_xerzisti.Eof())) {
              // * --- Insert into xerzistiope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xerzistiope");
              m_cPhName = m_Ctx.GetPhName("xerzistiope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xerzistiope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000029A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000029A(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xerzisti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xerzisti.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xerzisti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xerzisti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xerzisti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xerzisti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xerzisti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xerzisti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xerzistiope",true);
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
              Cursor_f_xerzisti.Next();
            }
            m_cConnectivityError = Cursor_f_xerzisti.ErrorMessage();
            Cursor_f_xerzisti.Close();
            // * --- End Select
            /* _numrig := 1 */
            _numrig = CPLib.Round(1,0);
            // * --- Select from f_xoggetbo
            m_cServer = m_Ctx.GetServer("f_xoggetbo");
            m_cPhName = m_Ctx.GetPhName("f_xoggetbo");
            if (Cursor_f_xoggetbo!=null)
              Cursor_f_xoggetbo.Close();
            Cursor_f_xoggetbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_f_xperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_xoggetbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_f_xoggetbo.Eof())) {
              // * --- Insert into xogopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xogopebo");
              m_cPhName = m_Ctx.GetPhName("xogopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xogopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000029D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000029D(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Upper(Cursor_f_xoggetbo.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_xoggetbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xogopebo",true);
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
              /* _numrig := _numrig + 1 */
              _numrig = CPLib.Round(_numrig+1,0);
              Cursor_f_xoggetbo.Next();
            }
            m_cConnectivityError = Cursor_f_xoggetbo.ErrorMessage();
            Cursor_f_xoggetbo.Close();
            // * --- End Select
          } // End If
          Cursor_f_xperazbo.Next();
        }
        m_cConnectivityError = Cursor_f_xperazbo.ErrorMessage();
        Cursor_f_xperazbo.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Operazioni P' + NL */
        gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Operazioni P"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni P' + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni P"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Fine importazione del file Operazioni P' // Messaggio Import */
        gMsgImp = "Fine importazione del file Operazioni P";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Frazionate P */
        /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Frazionate P' +NL */
        gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Frazionate P"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        // * --- Select from f_xraziobo
        m_cServer = m_Ctx.GetServer("f_xraziobo");
        m_cPhName = m_Ctx.GetPhName("f_xraziobo");
        if (Cursor_f_xraziobo!=null)
          Cursor_f_xraziobo.Close();
        Cursor_f_xraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_xraziobo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_f_xraziobo.Eof())) {
          /* If not(Empty(f_xraziobo->IDBASE)) */
          if ( ! (CPLib.Empty(Cursor_f_xraziobo.GetString("IDBASE")))) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Frazionate P' // Messaggio Import */
            gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Frazionate P";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into xraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xraziobo");
            m_cPhName = m_Ctx.GetPhName("xraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000002AA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000002AA(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_f_xraziobo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_f_xraziobo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xraziobo.GetString("CONNALTRO")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xraziobo.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xraziobo.GetString("CONNESCLI")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xraziobo.GetString("CONNESOPER")),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetDate("DATAIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetDouble("PAGASOGOP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xraziobo",true);
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
            // * --- Select from f_xlienti
            m_cServer = m_Ctx.GetServer("f_xlienti");
            m_cPhName = m_Ctx.GetPhName("f_xlienti");
            if (Cursor_f_xlienti!=null)
              Cursor_f_xlienti.Close();
            Cursor_f_xlienti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_f_xraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_xlienti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_f_xlienti.Eof())) {
              // * --- Insert into xlientifrz from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xlientifrz");
              m_cPhName = m_Ctx.GetPhName("xlientifrz");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientifrz",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000002AC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000002AC(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xlienti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xlienti.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xlienti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xlienti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xlienti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xlienti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xlienti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xlienti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xlientifrz",true);
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
              Cursor_f_xlienti.Next();
            }
            m_cConnectivityError = Cursor_f_xlienti.ErrorMessage();
            Cursor_f_xlienti.Close();
            // * --- End Select
            /* _numrig := 1 */
            _numrig = CPLib.Round(1,0);
            // * --- Select from f_xenefic
            m_cServer = m_Ctx.GetServer("f_xenefic");
            m_cPhName = m_Ctx.GetPhName("f_xenefic");
            if (Cursor_f_xenefic!=null)
              Cursor_f_xenefic.Close();
            Cursor_f_xenefic = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_f_xraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_xenefic")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_f_xenefic.Eof())) {
              // * --- Insert into xeneficfrz from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xeneficfrz");
              m_cPhName = m_Ctx.GetPhName("xeneficfrz");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficfrz",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000002AF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000002AF(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xenefic.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xenefic.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xeneficfrz",true);
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
              /* _numrig := _numrig + 1 */
              _numrig = CPLib.Round(_numrig+1,0);
              Cursor_f_xenefic.Next();
            }
            m_cConnectivityError = Cursor_f_xenefic.ErrorMessage();
            Cursor_f_xenefic.Close();
            // * --- End Select
            // * --- Select from f_xerzisti
            m_cServer = m_Ctx.GetServer("f_xerzisti");
            m_cPhName = m_Ctx.GetPhName("f_xerzisti");
            if (Cursor_f_xerzisti!=null)
              Cursor_f_xerzisti.Close();
            Cursor_f_xerzisti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_f_xraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_xerzisti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_f_xerzisti.Eof())) {
              // * --- Insert into xerzistifrz from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xerzistifrz");
              m_cPhName = m_Ctx.GetPhName("xerzistifrz");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xerzistifrz",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000002B2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000002B2(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xerzisti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xerzisti.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xerzisti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xerzisti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xerzisti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xerzisti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xerzisti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xerzisti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xerzistifrz",true);
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
              Cursor_f_xerzisti.Next();
            }
            m_cConnectivityError = Cursor_f_xerzisti.ErrorMessage();
            Cursor_f_xerzisti.Close();
            // * --- End Select
            /* _numrig := 1 */
            _numrig = CPLib.Round(1,0);
            // * --- Select from f_xoggetbo
            m_cServer = m_Ctx.GetServer("f_xoggetbo");
            m_cPhName = m_Ctx.GetPhName("f_xoggetbo");
            if (Cursor_f_xoggetbo!=null)
              Cursor_f_xoggetbo.Close();
            Cursor_f_xoggetbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_f_xraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_xoggetbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_f_xoggetbo.Eof())) {
              // * --- Insert into xogopefbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xogopefbo");
              m_cPhName = m_Ctx.GetPhName("xogopefbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xogopefbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000002B5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000002B5(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(CPLib.Upper(Cursor_f_xoggetbo.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_xoggetbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xoggetbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xogopefbo",true);
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
              /* _numrig := _numrig + 1 */
              _numrig = CPLib.Round(_numrig+1,0);
              Cursor_f_xoggetbo.Next();
            }
            m_cConnectivityError = Cursor_f_xoggetbo.ErrorMessage();
            Cursor_f_xoggetbo.Close();
            // * --- End Select
          } // End If
          Cursor_f_xraziobo.Next();
        }
        m_cConnectivityError = Cursor_f_xraziobo.ErrorMessage();
        Cursor_f_xraziobo.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Frazionate P' + NL */
        gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Frazionate P"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Frazionate P' + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Frazionate P"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Fine importazione del file Frazionate P' // Messaggio Import */
        gMsgImp = "Fine importazione del file Frazionate P";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
        /* Debug Msg m_Sql.TransactionErrorMessage() */
        if ( ! (CPLib.IsNull(m_Debug))) {
          m_Debug.log(m_Sql.TransactionErrorMessage());
        }
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000289status,0)) {
          m_Sql.SetTransactionStatus(nTry00000289status,cTry00000289msg);
        }
      }
    } finally {
      try {
        if (Cursor_f_xperazbo!=null)
          Cursor_f_xperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_xlienti!=null)
          Cursor_f_xlienti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_xenefic!=null)
          Cursor_f_xenefic.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_xerzisti!=null)
          Cursor_f_xerzisti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_xoggetbo!=null)
          Cursor_f_xoggetbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_xraziobo!=null)
          Cursor_f_xraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_12() throws Exception {
    CPResultSet Cursor_f_xapotit=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_f_xnttitbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Informazioni Titolarità Provvisorie */
      /* check_prog Numeric(10, 0) */
      double check_prog;
      check_prog = 0;
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Informazioni Titolarità P' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Informazioni Titolarità P"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_xapotit
      m_cServer = m_Ctx.GetServer("f_xapotit");
      m_cPhName = m_Ctx.GetPhName("f_xapotit");
      if (Cursor_f_xapotit!=null)
        Cursor_f_xapotit.Close();
      Cursor_f_xapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_xapotit")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_xapotit.Eof())) {
        /* If not(Empty(f_xapotit->CONNESCLI)) */
        if ( ! (CPLib.Empty(Cursor_f_xapotit.GetString("CONNESCLI")))) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Informazioni Titolarità P' // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Informazioni Titolarità P";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPTIT\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPTIT\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into xapotit from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xapotit");
          m_cPhName = m_Ctx.GetPhName("xapotit");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapotit",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000002C6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002C6(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_f_xapotit.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xapotit.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xapotit.GetString("CONNESCLI")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xapotit.GetString("CONNESOPER")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_xapotit.GetDate("DATAAGE")),"18991230")?CPLib.NullDate():Cursor_f_xapotit.GetDate("DATAAGE")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_xapotit.GetDate("DATAOPE")),"18991230")?CPLib.NullDate():Cursor_f_xapotit.GetDate("DATAOPE")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_f_xapotit.GetDate("DATAREG")),"18991230")?CPLib.NullDate():Cursor_f_xapotit.GetDate("DATAREG")),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xapotit.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xapotit",true);
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
        Cursor_f_xapotit.Next();
      }
      m_cConnectivityError = Cursor_f_xapotit.ErrorMessage();
      Cursor_f_xapotit.Close();
      // * --- End Select
      /* Idbase */
      /* check_prog := 0 */
      check_prog = CPLib.Round(0,0);
      // * --- Read from cpwarn
      m_cServer = m_Ctx.GetServer("cpwarn");
      m_cPhName = m_Ctx.GetPhName("cpwarn");
      m_cSql = "";
      m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGPTIT1\\'"+CPLib.LRTrim(gAzienda)+"'","C",100,0,m_cServer),m_cServer,"prog\\PRGPTIT1\\'"+CPLib.LRTrim(gAzienda)+"'");
      m_cSql = m_cSql+" and warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"C",10,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda));
      if (m_Ctx.IsSharedTemp("cpwarn")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("autonum",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        check_prog = Read_Cursor.GetDouble("autonum");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        check_prog = 0;
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If check_prog>0 */
      if (CPLib.gt(check_prog,0)) {
        // * --- Write into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000002CB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_maxfon,"N",10,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGPTIT1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGPTIT1\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
        m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda))+"";
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000002CC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000002CC(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGPTIT1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_maxfon,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer)+", ";
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
        }
      } // End If
      /* Progessivo */
      /* check_prog := 0 */
      check_prog = CPLib.Round(0,0);
      // * --- Read from cpwarn
      m_cServer = m_Ctx.GetServer("cpwarn");
      m_cPhName = m_Ctx.GetPhName("cpwarn");
      m_cSql = "";
      m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGPTIT2\\'"+CPLib.LRTrim(gAzienda)+"'","C",100,0,m_cServer),m_cServer,"prog\\PRGPTIT2\\'"+CPLib.LRTrim(gAzienda)+"'");
      m_cSql = m_cSql+" and warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"C",10,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda));
      if (m_Ctx.IsSharedTemp("cpwarn")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("autonum",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        check_prog = Read_Cursor.GetDouble("autonum");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        check_prog = 0;
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If check_prog>0 */
      if (CPLib.gt(check_prog,0)) {
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000002D1;
        _h000002D1 = new SPBridge.HMCaller();
        _h000002D1.Set("m_cVQRList",m_cVQRList);
        _h000002D1.Set("tbname","rapotit");
        _h000002D1.Set("fldname","NUMPROG");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000002D1,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000002D2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(Cursor_qbe_tab_mmc.GetDouble("max"),"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGPTIT2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGPTIT2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda))+"";
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
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } else { // Else
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000002D3;
        _h000002D3 = new SPBridge.HMCaller();
        _h000002D3.Set("m_cVQRList",m_cVQRList);
        _h000002D3.Set("tbname","rapotit");
        _h000002D3.Set("fldname","NUMPROG");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000002D3,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          // * --- Insert into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000002D4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002D4(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGPTIT2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tab_mmc.GetDouble("max"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer)+", ";
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
          }
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } // End If
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Informazioni Titolarità P' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Informazioni Titolarità P"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_xnttitbo
      m_cServer = m_Ctx.GetServer("f_xnttitbo");
      m_cPhName = m_Ctx.GetPhName("f_xnttitbo");
      if (Cursor_f_xnttitbo!=null)
        Cursor_f_xnttitbo.Close();
      Cursor_f_xnttitbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_xnttitbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_xnttitbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file di intestazione Titolarità P' // Messaggio Import */
        gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file di intestazione Titolarità P";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* nProgImp := Utilities.GetAutonumber("PRGIMPTITE\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPTITE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        // * --- Insert into xntestit from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xntestit");
        m_cPhName = m_Ctx.GetPhName("xntestit");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestit",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000002DB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000002DB(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetDouble("ABBINATO"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xnttitbo.GetString("CONNESCLI")),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_xnttitbo.GetString("CODINTER")),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetDate("DATAFINE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetDate("DATAINI"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetDate("DATARETT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_xnttitbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xntestit",true);
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
        Cursor_f_xnttitbo.Next();
      }
      m_cConnectivityError = Cursor_f_xnttitbo.ErrorMessage();
      Cursor_f_xnttitbo.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file di intestazioni Titolarità P' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file di intestazioni Titolarità P"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Informazioni Titolarità P' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Informazioni Titolarità P"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Informazioni Titolarità P' // Messaggio Import */
      gMsgImp = "Fine importazione del file Informazioni Titolarità P";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_f_xapotit!=null)
          Cursor_f_xapotit.Close();
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
      try {
        if (Cursor_f_xnttitbo!=null)
          Cursor_f_xnttitbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_13() throws Exception {
    CPResultSet Cursor_qbe_f_opextrbo_totale=null;
    CPResultSet Cursor_qbe_f_opextrbo=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Dati Operazioni ExtraConto */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni ExtraConto' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni ExtraConto"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* _maxfon := 0 */
      _maxfon = CPLib.Round(0,0);
      // * --- Select from qbe_f_opextrbo_totale
      if (Cursor_qbe_f_opextrbo_totale!=null)
        Cursor_qbe_f_opextrbo_totale.Close();
      Cursor_qbe_f_opextrbo_totale = new VQRHolder("qbe_f_opextrbo_totale",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_f_opextrbo_totale.Eof())) {
        /* _maxfon := qbe_f_opextrbo_totale->TOTALE */
        _maxfon = CPLib.Round(Cursor_qbe_f_opextrbo_totale.GetDouble("TOTALE"),0);
        Cursor_qbe_f_opextrbo_totale.Next();
      }
      m_cConnectivityError = Cursor_qbe_f_opextrbo_totale.ErrorMessage();
      Cursor_qbe_f_opextrbo_totale.Close();
      // * --- End Select
      /* If _maxfon <= 20000 */
      if (CPLib.le(_maxfon,20000)) {
        /* _cicli := 1 */
        _cicli = CPLib.Round(1,0);
      } else { // Else
        /* _cicli := iif(Mod(_maxfon,20000) <> 0,Int(_maxfon/20000) + 1,Int(_maxfon/20000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_maxfon,20000),0)?CPLib.Int(_maxfon/20000)+1:CPLib.Int(_maxfon/20000)),0);
      } // End If
      /* _pci := 1 */
      _pci = CPLib.Round(1,0);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000002EBstatus;
      nTry000002EBstatus = m_Sql.GetTransactionStatus();
      String cTry000002EBmsg;
      cTry000002EBmsg = m_Sql.TransactionErrorMessage();
      try {
        /* While _pci <= _cicli */
        while (CPLib.le(_pci,_cicli)) {
          /* _bot := ((_pci -1 ) * 20000) + 1 */
          _bot = CPLib.Round(((_pci-1)*20000)+1,0);
          /* _top := _pci * 20000 */
          _top = CPLib.Round(_pci*20000,0);
          // * --- Select from qbe_f_opextrbo
          SPBridge.HMCaller _h000002EF;
          _h000002EF = new SPBridge.HMCaller();
          _h000002EF.Set("m_cVQRList",m_cVQRList);
          _h000002EF.Set("_bot",_bot);
          _h000002EF.Set("_top",_top);
          if (Cursor_qbe_f_opextrbo!=null)
            Cursor_qbe_f_opextrbo.Close();
          Cursor_qbe_f_opextrbo = new VQRHolder("qbe_f_opextrbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000002EF,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_f_opextrbo.Eof())) {
            /* _dataimp := NullDate() */
            _dataimp = CPLib.NullDate();
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Operazioni ExtraConto' // Messaggio Import */
            gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Operazioni ExtraConto";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            // * --- Read from opextrbo
            m_cServer = m_Ctx.GetServer("opextrbo");
            m_cPhName = m_Ctx.GetPhName("opextrbo");
            m_cSql = "";
            m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_opextrbo.GetString("COLLEG")),"C",16,0,m_cServer),m_cServer,CPLib.Upper(Cursor_qbe_f_opextrbo.GetString("COLLEG")));
            m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("ANNO"),"C",4,0,m_cServer),m_cServer,Cursor_qbe_f_opextrbo.GetString("ANNO"));
            if (m_Ctx.IsSharedTemp("opextrbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DATAOPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _dataimp = Read_Cursor.GetDate("DATAOPE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _dataimp = CPLib.NullDate();
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(_dataimp) */
            if (CPLib.Empty(_dataimp)) {
              /* nProgImp := Utilities.GetAutonumber("PROGOPEX\'"+LRTrim(gAzienda)+"'",0,10) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGOPEX\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
              // * --- Insert into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000002F6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000002F6(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_opextrbo.GetString("COLLEG")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("ANNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_opextrbo.GetDate("DATAOPE")),"18991230")?CPLib.NullDate():Cursor_qbe_f_opextrbo.GetDate("DATAOPE")),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("NOTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDouble("SALDO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDouble("QUANTITA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("UNIQUE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("OLDINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDate("DATAMODI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDouble("INVIATO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDate("DATAINVIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDouble("ANNULLA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDate("DATAANNU"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("OLDUNIQUE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDate("DATAOLDUNI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("IDESITO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDouble("INVSALDO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDate("DTSALDO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
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
              /* ElseIf qbe_f_opextrbo->DATAOPE < _dataimp */
            } else if (CPLib.lt(Cursor_qbe_f_opextrbo.GetDate("DATAOPE"),_dataimp)) {
              // * --- Write into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000002F7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL((CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_opextrbo.GetDate("DATAOPE")),"18991230")?CPLib.NullDate():Cursor_qbe_f_opextrbo.GetDate("DATAOPE")),"D",8,0)+", ";
              m_cSql = m_cSql+"COINT = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("COINT"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"NOTE = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("NOTE"),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"RIFIMP = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("RIFIMP"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SALDO = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDouble("SALDO"),"N",17,0)+", ";
              m_cSql = m_cSql+"QUANTITA = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDouble("QUANTITA"),"N",6,0)+", ";
              m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("VALUTA"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("UNIQUE"),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"OLDINTER = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("OLDINTER"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDate("DATAMODI"),"D",8,0)+", ";
              m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDouble("INVIATO"),"N",1,0)+", ";
              m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDate("DATAINVIO"),"D",8,0)+", ";
              m_cSql = m_cSql+"ANNULLA = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDouble("ANNULLA"),"N",1,0)+", ";
              m_cSql = m_cSql+"DATAANNU = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDate("DATAANNU"),"D",8,0)+", ";
              m_cSql = m_cSql+"OLDUNIQUE = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("OLDUNIQUE"),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAOLDUNI = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDate("DATAOLDUNI"),"D",8,0)+", ";
              m_cSql = m_cSql+"IDESITO = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("IDESITO"),"C",13,0,m_cServer)+", ";
              m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("CONNESOPER"),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"INVSALDO = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDouble("INVSALDO"),"N",1,0)+", ";
              m_cSql = m_cSql+"DTSALDO = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetDate("DTSALDO"),"D",8,0)+", ";
              m_cSql = m_cSql+"NATURA = "+CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("NATURA"),"C",2,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(Cursor_qbe_f_opextrbo.GetString("COLLEG")),"?",0,0,m_cServer),m_cServer,CPLib.Upper(Cursor_qbe_f_opextrbo.GetString("COLLEG")))+"";
              m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_f_opextrbo.GetString("ANNO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_f_opextrbo.GetString("ANNO"))+"";
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
            Cursor_qbe_f_opextrbo.Next();
          }
          m_cConnectivityError = Cursor_qbe_f_opextrbo.ErrorMessage();
          Cursor_qbe_f_opextrbo.Close();
          // * --- End Select
          /* _pci := _pci + 1 */
          _pci = CPLib.Round(_pci+1,0);
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000002EBstatus,0)) {
          m_Sql.SetTransactionStatus(nTry000002EBstatus,cTry000002EBmsg);
        }
      }
      /* If _pci > _cicli */
      if (CPLib.gt(_pci,_cicli)) {
        /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Operazioni ExtraConto' + NL */
        gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Operazioni ExtraConto"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + 'Elaborazione terminata con errori. Import abortito' + NL */
        gMsgProc = gMsgProc+"Elaborazione terminata con errori. Import abortito"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni ExtraConto' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni ExtraConto"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Operazioni ExtraConto' // Messaggio Import */
      gMsgImp = "Fine importazione del file Operazioni ExtraConto";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_qbe_f_opextrbo_totale!=null)
          Cursor_qbe_f_opextrbo_totale.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_f_opextrbo!=null)
          Cursor_qbe_f_opextrbo.Close();
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
  void Page_14() throws Exception {
    CPResultSet Cursor_f_wlienti=null;
    CPResultSet Cursor_f_wenefic=null;
    CPResultSet Cursor_f_werzisti=null;
    CPResultSet Cursor_f_woggetbo=null;
    CPResultSet Cursor_qbe_f_wperazbo_totale=null;
    CPResultSet Cursor_qbe_f_wperazbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_qbe_f_wraziobo_totale=null;
    CPResultSet Cursor_qbe_f_wraziobo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* check_prog Numeric(10, 0) */
      double check_prog;
      check_prog = 0;
      /* altricli Bool */
      boolean altricli;
      altricli = false;
      /* altriben Bool */
      boolean altriben;
      altriben = false;
      /* altriterz Bool */
      boolean altriterz;
      altriterz = false;
      /* altrisog Bool */
      boolean altrisog;
      altrisog = false;
      /* _idbase Char(10) */
      String _idbase;
      _idbase = CPLib.Space(10);
      /* codidpe Char(6) // appoggio per verifica dipendenze */
      String codidpe;
      codidpe = CPLib.Space(6);
      /* _maxfo := '' */
      _maxfo = "";
      /* _maxfon := 0 */
      _maxfon = CPLib.Round(0,0);
      /* _top := 0 */
      _top = CPLib.Round(0,0);
      /* _bot := 0 */
      _bot = CPLib.Round(0,0);
      /* _cicli := 0 */
      _cicli = CPLib.Round(0,0);
      /* _pci := 0 */
      _pci = CPLib.Round(0,0);
      /* altricli := False */
      altricli = false;
      /* altriterz := False */
      altriterz = false;
      /* altrisog := False */
      altrisog = false;
      /* altriben := False  */
      altriben = false;
      // * --- Select from f_wlienti
      m_cServer = m_Ctx.GetServer("f_wlienti");
      m_cPhName = m_Ctx.GetPhName("f_wlienti");
      if (Cursor_f_wlienti!=null)
        Cursor_f_wlienti.Close();
      Cursor_f_wlienti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_wlienti")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_wlienti.Eof())) {
        /* altricli := True */
        altricli = true;
        // Exit Loop
        if (true) {
          break;
        }
        Cursor_f_wlienti.Next();
      }
      m_cConnectivityError = Cursor_f_wlienti.ErrorMessage();
      Cursor_f_wlienti.Close();
      // * --- End Select
      // * --- Select from f_wenefic
      m_cServer = m_Ctx.GetServer("f_wenefic");
      m_cPhName = m_Ctx.GetPhName("f_wenefic");
      if (Cursor_f_wenefic!=null)
        Cursor_f_wenefic.Close();
      Cursor_f_wenefic = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_wenefic")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_wenefic.Eof())) {
        /* altriben := True */
        altriben = true;
        // Exit Loop
        if (true) {
          break;
        }
        Cursor_f_wenefic.Next();
      }
      m_cConnectivityError = Cursor_f_wenefic.ErrorMessage();
      Cursor_f_wenefic.Close();
      // * --- End Select
      // * --- Select from f_werzisti
      m_cServer = m_Ctx.GetServer("f_werzisti");
      m_cPhName = m_Ctx.GetPhName("f_werzisti");
      if (Cursor_f_werzisti!=null)
        Cursor_f_werzisti.Close();
      Cursor_f_werzisti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_werzisti")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_werzisti.Eof())) {
        /* altriterz := True */
        altriterz = true;
        // Exit Loop
        if (true) {
          break;
        }
        Cursor_f_werzisti.Next();
      }
      m_cConnectivityError = Cursor_f_werzisti.ErrorMessage();
      Cursor_f_werzisti.Close();
      // * --- End Select
      // * --- Select from f_woggetbo
      m_cServer = m_Ctx.GetServer("f_woggetbo");
      m_cPhName = m_Ctx.GetPhName("f_woggetbo");
      if (Cursor_f_woggetbo!=null)
        Cursor_f_woggetbo.Close();
      Cursor_f_woggetbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_woggetbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_woggetbo.Eof())) {
        /* altrisog := True */
        altrisog = true;
        // Exit Loop
        if (true) {
          break;
        }
        Cursor_f_woggetbo.Next();
      }
      m_cConnectivityError = Cursor_f_woggetbo.ErrorMessage();
      Cursor_f_woggetbo.Close();
      // * --- End Select
      // * --- Select from qbe_f_wperazbo_totale
      if (Cursor_qbe_f_wperazbo_totale!=null)
        Cursor_qbe_f_wperazbo_totale.Close();
      Cursor_qbe_f_wperazbo_totale = new VQRHolder("qbe_f_wperazbo_totale",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_f_wperazbo_totale.Eof())) {
        /* _maxfon := qbe_f_wperazbo_totale->TOTALE */
        _maxfon = CPLib.Round(Cursor_qbe_f_wperazbo_totale.GetDouble("TOTALE"),0);
        Cursor_qbe_f_wperazbo_totale.Next();
      }
      m_cConnectivityError = Cursor_qbe_f_wperazbo_totale.ErrorMessage();
      Cursor_qbe_f_wperazbo_totale.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni (Storico)' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni (Storico)"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If _maxfon > 0 */
      if (CPLib.gt(_maxfon,0)) {
        /* If _maxfon <= 20000 */
        if (CPLib.le(_maxfon,20000)) {
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } else { // Else
          /* _cicli := iif(Mod(_maxfon,20000) <> 0,Int(_maxfon/20000) + 1,Int(_maxfon/20000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_maxfon,20000),0)?CPLib.Int(_maxfon/20000)+1:CPLib.Int(_maxfon/20000)),0);
        } // End If
        /* _pci := 1 */
        _pci = CPLib.Round(1,0);
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* While _pci <= _cicli */
        while (CPLib.le(_pci,_cicli)) {
          /* _bot := ((_pci -1 ) * 20000) + 1 */
          _bot = CPLib.Round(((_pci-1)*20000)+1,0);
          /* _top := _pci * 20000 */
          _top = CPLib.Round(_pci*20000,0);
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry0000032Bstatus;
          nTry0000032Bstatus = m_Sql.GetTransactionStatus();
          String cTry0000032Bmsg;
          cTry0000032Bmsg = m_Sql.TransactionErrorMessage();
          try {
            // * --- Select from qbe_f_wperazbo
            SPBridge.HMCaller _h0000032C;
            _h0000032C = new SPBridge.HMCaller();
            _h0000032C.Set("m_cVQRList",m_cVQRList);
            _h0000032C.Set("_bot",_bot);
            _h0000032C.Set("_top",_top);
            if (Cursor_qbe_f_wperazbo!=null)
              Cursor_qbe_f_wperazbo.Close();
            Cursor_qbe_f_wperazbo = new VQRHolder("qbe_f_wperazbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000032C,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_f_wperazbo.Eof())) {
              /* If not(Empty(qbe_f_wperazbo->CODDIPE)) */
              if ( ! (CPLib.Empty(Cursor_qbe_f_wperazbo.GetString("CODDIPE")))) {
                /* codidpe := '' // appoggio per verifica dipendenze */
                codidpe = "";
                // * --- Read from anadip
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_cSql = "";
                m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODDIPE"),"C",6,0,m_cServer),m_cServer,Cursor_qbe_f_wperazbo.GetString("CODDIPE"));
                if (m_Ctx.IsSharedTemp("anadip")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  codidpe = Read_Cursor.GetString("CODDIP");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  codidpe = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(codidpe) */
                if (CPLib.Empty(codidpe)) {
                  // * --- Insert into anadip from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("anadip");
                  m_cPhName = m_Ctx.GetPhName("anadip");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anadip",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000331")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000331(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("DIPENDENZA NON INSERITA","?",0,0,m_cServer)+", ";
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
                    throw new RoutineException();
                  }
                } // End If
              } // End If
              /* If not(Empty(qbe_f_wperazbo->IDBASE)) */
              if ( ! (CPLib.Empty(Cursor_qbe_f_wperazbo.GetString("IDBASE")))) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Operazioni' // Messaggio Import */
                gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Operazioni";
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                /* _dataret := iif(DateToChar(qbe_f_wperazbo->DATARETT)='18991230',NullDate(),qbe_f_wperazbo->DATARETT) */
                _dataret = (CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_wperazbo.GetDate("DATARETT")),"18991230")?CPLib.NullDate():Cursor_qbe_f_wperazbo.GetDate("DATARETT"));
                /* _dataimp := iif(DateToChar(qbe_f_wperazbo->DATAIMP)='18991230',NullDate(),qbe_f_wperazbo->DATAIMP) */
                _dataimp = (CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_wperazbo.GetDate("DATAIMP")),"18991230")?CPLib.NullDate():Cursor_qbe_f_wperazbo.GetDate("DATAIMP"));
                /* Verifico se già presente un operazione con lo stesso idbase. Nel caso inserisco il numprog su idbase, per evitare duplicazioni di chiave primaria. */
                /* _idbase := '' */
                _idbase = "";
                /* If pFlg='N' */
                if (CPLib.eqr(pFlg,"N")) {
                  // * --- Read from wperazbo
                  m_cServer = m_Ctx.GetServer("wperazbo");
                  m_cPhName = m_Ctx.GetPhName("wperazbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("IDBASE"),"C",10,0,m_cServer),m_cServer,Cursor_qbe_f_wperazbo.GetString("IDBASE"));
                  if (m_Ctx.IsSharedTemp("wperazbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _idbase = Read_Cursor.GetString("IDBASE");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on wperazbo into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _idbase = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  // * --- Insert into wperazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wperazbo");
                  m_cPhName = m_Ctx.GetPhName("wperazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wperazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000033C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000033C(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_wperazbo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_wperazbo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_wperazbo.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDate("DATAREG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_dataret,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_idbase)?Cursor_qbe_f_wperazbo.GetString("IDBASE"):CPLib.Right(Cursor_qbe_f_wperazbo.GetString("NUMPROG"),10)),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("NOPROT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("RAREA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("RCOMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("RFREQ"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("RIMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("RTIPO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wperazbo",true);
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
                } else { // Else
                  // * --- Read from operazbo
                  m_cServer = m_Ctx.GetServer("operazbo");
                  m_cPhName = m_Ctx.GetPhName("operazbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("IDBASE"),"C",10,0,m_cServer),m_cServer,Cursor_qbe_f_wperazbo.GetString("IDBASE"));
                  if (m_Ctx.IsSharedTemp("operazbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _idbase = Read_Cursor.GetString("IDBASE");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on operazbo into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _idbase = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  // * --- Insert into operazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("operazbo");
                  m_cPhName = m_Ctx.GetPhName("operazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000033E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000033E(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_wperazbo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_wperazbo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_wperazbo.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDate("DATAREG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_dataret,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_idbase)?Cursor_qbe_f_wperazbo.GetString("IDBASE"):CPLib.Right(Cursor_qbe_f_wperazbo.GetString("NUMPROG"),10)),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("NOPROT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("RAREA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("RCOMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("RFREQ"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("RIMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("RTIPO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
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
                    throw new RoutineException();
                  }
                } // End If
                /* If altricli=True  */
                if (CPLib.eqr(altricli,true)) {
                  // * --- Select from f_wlienti
                  m_cServer = m_Ctx.GetServer("f_wlienti");
                  m_cPhName = m_Ctx.GetPhName("f_wlienti");
                  if (Cursor_f_wlienti!=null)
                    Cursor_f_wlienti.Close();
                  Cursor_f_wlienti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_wlienti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_wlienti.Eof())) {
                    /* If pFlg='N' */
                    if (CPLib.eqr(pFlg,"N")) {
                      // * --- Insert into wlientiope from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("wlientiope");
                      m_cPhName = m_Ctx.GetPhName("wlientiope");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wlientiope",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000342")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000342(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wlientiope",true);
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
                    } else { // Else
                      // * --- Insert into clientiope from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("clientiope");
                      m_cPhName = m_Ctx.GetPhName("clientiope");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000343")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000343(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
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
                    } // End If
                    Cursor_f_wlienti.Next();
                  }
                  m_cConnectivityError = Cursor_f_wlienti.ErrorMessage();
                  Cursor_f_wlienti.Close();
                  // * --- End Select
                } // End If
                /* If altriben=True  */
                if (CPLib.eqr(altriben,true)) {
                  /* _numrig := 1 */
                  _numrig = CPLib.Round(1,0);
                  // * --- Select from f_wenefic
                  m_cServer = m_Ctx.GetServer("f_wenefic");
                  m_cPhName = m_Ctx.GetPhName("f_wenefic");
                  if (Cursor_f_wenefic!=null)
                    Cursor_f_wenefic.Close();
                  Cursor_f_wenefic = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_wenefic")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_wenefic.Eof())) {
                    /* If pFlg='N' */
                    if (CPLib.eqr(pFlg,"N")) {
                      // * --- Insert into weneficope from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("weneficope");
                      m_cPhName = m_Ctx.GetPhName("weneficope");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"weneficope",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000348")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000348(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"weneficope",true);
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
                    } else { // Else
                      // * --- Insert into beneficope from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("beneficope");
                      m_cPhName = m_Ctx.GetPhName("beneficope");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000349")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000349(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
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
                    } // End If
                    /* _numrig := _numrig + 1 */
                    _numrig = CPLib.Round(_numrig+1,0);
                    Cursor_f_wenefic.Next();
                  }
                  m_cConnectivityError = Cursor_f_wenefic.ErrorMessage();
                  Cursor_f_wenefic.Close();
                  // * --- End Select
                } // End If
                /* If altriterz=True  */
                if (CPLib.eqr(altriterz,true)) {
                  // * --- Select from f_werzisti
                  m_cServer = m_Ctx.GetServer("f_werzisti");
                  m_cPhName = m_Ctx.GetPhName("f_werzisti");
                  if (Cursor_f_werzisti!=null)
                    Cursor_f_werzisti.Close();
                  Cursor_f_werzisti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_werzisti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_werzisti.Eof())) {
                    /* If pFlg='N' */
                    if (CPLib.eqr(pFlg,"N")) {
                      // * --- Insert into werzistiope from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("werzistiope");
                      m_cPhName = m_Ctx.GetPhName("werzistiope");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"werzistiope",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000034E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000034E(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"werzistiope",true);
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
                    } else { // Else
                      // * --- Insert into terzistiope from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("terzistiope");
                      m_cPhName = m_Ctx.GetPhName("terzistiope");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000034F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000034F(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
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
                    } // End If
                    Cursor_f_werzisti.Next();
                  }
                  m_cConnectivityError = Cursor_f_werzisti.ErrorMessage();
                  Cursor_f_werzisti.Close();
                  // * --- End Select
                } // End If
                /* If altrisog=True  */
                if (CPLib.eqr(altrisog,true)) {
                  /* _numrig := 1 */
                  _numrig = CPLib.Round(1,0);
                  // * --- Select from f_woggetbo
                  m_cServer = m_Ctx.GetServer("f_woggetbo");
                  m_cPhName = m_Ctx.GetPhName("f_woggetbo");
                  if (Cursor_f_woggetbo!=null)
                    Cursor_f_woggetbo.Close();
                  Cursor_f_woggetbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_wperazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_woggetbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_woggetbo.Eof())) {
                    /* If pFlg='N' */
                    if (CPLib.eqr(pFlg,"N")) {
                      // * --- Insert into wogopebo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("wogopebo");
                      m_cPhName = m_Ctx.GetPhName("wogopebo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wogopebo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000354")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000354(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wogopebo",true);
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
                    } else { // Else
                      // * --- Insert into sogopebo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("sogopebo");
                      m_cPhName = m_Ctx.GetPhName("sogopebo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000355")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000355(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_woggetbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_woggetbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
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
                    } // End If
                    /* _numrig := _numrig + 1 */
                    _numrig = CPLib.Round(_numrig+1,0);
                    Cursor_f_woggetbo.Next();
                  }
                  m_cConnectivityError = Cursor_f_woggetbo.ErrorMessage();
                  Cursor_f_woggetbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_qbe_f_wperazbo.Next();
            }
            m_cConnectivityError = Cursor_qbe_f_wperazbo.ErrorMessage();
            Cursor_qbe_f_wperazbo.Close();
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
            // * --- Delete from wperazbo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wperazbo");
            m_cPhName = m_Ctx.GetPhName("wperazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wperazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000359")+"delete from "+m_oWrInfo.GetTableWriteName();
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
            }
            // Exit Loop
            if (true) {
              break;
            }
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000032Bstatus,0)) {
              m_Sql.SetTransactionStatus(nTry0000032Bstatus,cTry0000032Bmsg);
            }
          }
          /* _pci := _pci + 1 */
          _pci = CPLib.Round(_pci+1,0);
        } // End While
        /* Verifico la presenza del contatore dei progressivi e dell'idbase. Per evitare errori in inserimento. */
        /* If _pci > _cicli */
        if (CPLib.gt(_pci,_cicli)) {
          /* idbase */
          /* check_prog := 0 */
          check_prog = CPLib.Round(0,0);
          // * --- Read from cpwarn
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_cSql = "";
          m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","C",100,0,m_cServer),m_cServer,"prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'");
          m_cSql = m_cSql+" and warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"C",10,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda));
          if (m_Ctx.IsSharedTemp("cpwarn")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("autonum",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            check_prog = Read_Cursor.GetDouble("autonum");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            check_prog = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If check_prog>0 */
          if (CPLib.gt(check_prog,0)) {
            // * --- Write into cpwarn from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000362")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_maxfon,"N",10,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
            m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda))+"";
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
            // * --- Insert into cpwarn from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000363")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000363(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL("prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_maxfon,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer)+", ";
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
            }
          } // End If
          /* progressivo */
          /* check_prog := 0 */
          check_prog = CPLib.Round(0,0);
          // * --- Read from cpwarn
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_cSql = "";
          m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","C",100,0,m_cServer),m_cServer,"prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'");
          m_cSql = m_cSql+" and warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"C",10,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda));
          if (m_Ctx.IsSharedTemp("cpwarn")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("autonum",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            check_prog = Read_Cursor.GetDouble("autonum");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            check_prog = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If check_prog>0 */
          if (CPLib.gt(check_prog,0)) {
            // * --- Select from qbe_tab_mmc
            SPBridge.HMCaller _h00000368;
            _h00000368 = new SPBridge.HMCaller();
            _h00000368.Set("m_cVQRList",m_cVQRList);
            _h00000368.Set("tbname","operazbo");
            _h00000368.Set("fldname","NUMPROG");
            if (Cursor_qbe_tab_mmc!=null)
              Cursor_qbe_tab_mmc.Close();
            Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000368,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_tab_mmc.Eof())) {
              // * --- Write into cpwarn from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpwarn");
              m_cPhName = m_Ctx.GetPhName("cpwarn");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000369")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(Cursor_qbe_tab_mmc.GetDouble("max"),"N",10,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
              m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda))+"";
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
              Cursor_qbe_tab_mmc.Next();
            }
            m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
            Cursor_qbe_tab_mmc.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from qbe_tab_mmc
            SPBridge.HMCaller _h0000036A;
            _h0000036A = new SPBridge.HMCaller();
            _h0000036A.Set("m_cVQRList",m_cVQRList);
            _h0000036A.Set("tbname","operazbo");
            _h0000036A.Set("fldname","NUMPROG");
            if (Cursor_qbe_tab_mmc!=null)
              Cursor_qbe_tab_mmc.Close();
            Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000036A,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_tab_mmc.Eof())) {
              // * --- Insert into cpwarn from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpwarn");
              m_cPhName = m_Ctx.GetPhName("cpwarn");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000036B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000036B(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tab_mmc.GetDouble("max"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer)+", ";
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
              }
              Cursor_qbe_tab_mmc.Next();
            }
            m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
            Cursor_qbe_tab_mmc.Close();
            // * --- End Select
          } // End If
          /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Operazioni (Storico)' + NL */
          gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Operazioni (Storico)"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := gMsgProc + 'Elaborazione terminata con errori. Import abortito' + NL */
          gMsgProc = gMsgProc+"Elaborazione terminata con errori. Import abortito"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni (Storico)' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni (Storico)"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Operazioni (Storico)' // Messaggio Import */
      gMsgImp = "Fine importazione del file Operazioni (Storico)";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _maxfo := '' */
      _maxfo = "";
      /* _maxfon := 0 */
      _maxfon = CPLib.Round(0,0);
      /* _top := 0 */
      _top = CPLib.Round(0,0);
      /* _bot := 0 */
      _bot = CPLib.Round(0,0);
      /* _cicli := 0 */
      _cicli = CPLib.Round(0,0);
      /* _pci := 0 */
      _pci = CPLib.Round(0,0);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* altricli := False */
      altricli = false;
      /* altriterz := False */
      altriterz = false;
      /* altrisog := False */
      altrisog = false;
      /* altriben := False  */
      altriben = false;
      // * --- Select from qbe_f_wraziobo_totale
      if (Cursor_qbe_f_wraziobo_totale!=null)
        Cursor_qbe_f_wraziobo_totale.Close();
      Cursor_qbe_f_wraziobo_totale = new VQRHolder("qbe_f_wraziobo_totale",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_f_wraziobo_totale.Eof())) {
        /* _maxfon := qbe_f_wraziobo_totale->TOTALE */
        _maxfon = CPLib.Round(Cursor_qbe_f_wraziobo_totale.GetDouble("TOTALE"),0);
        Cursor_qbe_f_wraziobo_totale.Next();
      }
      m_cConnectivityError = Cursor_qbe_f_wraziobo_totale.ErrorMessage();
      Cursor_qbe_f_wraziobo_totale.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Frazionate (Storico)' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Frazionate (Storico)"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If _maxfon > 0 */
      if (CPLib.gt(_maxfon,0)) {
        /* If _maxfon <= 20000 */
        if (CPLib.le(_maxfon,20000)) {
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } else { // Else
          /* _cicli := iif(Mod(_maxfon,20000) <> 0,Int(_maxfon/20000) + 1,Int(_maxfon/20000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_maxfon,20000),0)?CPLib.Int(_maxfon/20000)+1:CPLib.Int(_maxfon/20000)),0);
        } // End If
        /* _pci := 1 */
        _pci = CPLib.Round(1,0);
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* While _pci <= _cicli */
        while (CPLib.le(_pci,_cicli)) {
          /* _bot := ((_pci -1 ) * 20000) + 1 */
          _bot = CPLib.Round(((_pci-1)*20000)+1,0);
          /* _top := _pci * 20000 */
          _top = CPLib.Round(_pci*20000,0);
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry00000389status;
          nTry00000389status = m_Sql.GetTransactionStatus();
          String cTry00000389msg;
          cTry00000389msg = m_Sql.TransactionErrorMessage();
          try {
            // * --- Select from qbe_f_wraziobo
            SPBridge.HMCaller _h0000038A;
            _h0000038A = new SPBridge.HMCaller();
            _h0000038A.Set("m_cVQRList",m_cVQRList);
            _h0000038A.Set("_bot",_bot);
            _h0000038A.Set("_top",_top);
            if (Cursor_qbe_f_wraziobo!=null)
              Cursor_qbe_f_wraziobo.Close();
            Cursor_qbe_f_wraziobo = new VQRHolder("qbe_f_wraziobo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000038A,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_f_wraziobo.Eof())) {
              /* If not(Empty(qbe_f_wraziobo->CODDIPE)) */
              if ( ! (CPLib.Empty(Cursor_qbe_f_wraziobo.GetString("CODDIPE")))) {
                /* codidpe := '' // appoggio per verifica dipendenze */
                codidpe = "";
                // * --- Read from anadip
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_cSql = "";
                m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODDIPE"),"C",6,0,m_cServer),m_cServer,Cursor_qbe_f_wraziobo.GetString("CODDIPE"));
                if (m_Ctx.IsSharedTemp("anadip")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  codidpe = Read_Cursor.GetString("CODDIP");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  codidpe = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(codidpe) */
                if (CPLib.Empty(codidpe)) {
                  // * --- Insert into anadip from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("anadip");
                  m_cPhName = m_Ctx.GetPhName("anadip");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anadip",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000038F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000038F(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("DIPENDENZA NON INSERITA","?",0,0,m_cServer)+", ";
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
                    throw new RoutineException();
                  }
                } // End If
              } // End If
              /* If not(Empty(qbe_f_wraziobo->IDBASE)) */
              if ( ! (CPLib.Empty(Cursor_qbe_f_wraziobo.GetString("IDBASE")))) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Frazionate' // Messaggio Import */
                gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Frazionate";
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* nProgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                /* _dataret := iif(DateToChar(qbe_f_wraziobo->DATARETT)='18991230',NullDate(),qbe_f_wraziobo->DATARETT) */
                _dataret = (CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_wraziobo.GetDate("DATARETT")),"18991230")?CPLib.NullDate():Cursor_qbe_f_wraziobo.GetDate("DATARETT"));
                /* _dataimp := iif(DateToChar(qbe_f_wraziobo->DATAIMP)='18991230',NullDate(),qbe_f_wraziobo->DATAIMP) */
                _dataimp = (CPLib.eqr(CPLib.DateToChar(Cursor_qbe_f_wraziobo.GetDate("DATAIMP")),"18991230")?CPLib.NullDate():Cursor_qbe_f_wraziobo.GetDate("DATAIMP"));
                /* Verifico se già presente un operazione con lo stesso idbase. Nel caso inserisco il numprog su idbase, per evitare duplicazioni di chiave primaria. */
                /* _idbase := '' */
                _idbase = "";
                /* If pFlg='N' */
                if (CPLib.eqr(pFlg,"N")) {
                  // * --- Read from wraziobo
                  m_cServer = m_Ctx.GetServer("wraziobo");
                  m_cPhName = m_Ctx.GetPhName("wraziobo");
                  m_cSql = "";
                  m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("IDBASE"),"C",10,0,m_cServer),m_cServer,Cursor_qbe_f_wraziobo.GetString("IDBASE"));
                  if (m_Ctx.IsSharedTemp("wraziobo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _idbase = Read_Cursor.GetString("IDBASE");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on wraziobo into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _idbase = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  // * --- Insert into wraziobo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wraziobo");
                  m_cPhName = m_Ctx.GetPhName("wraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000039A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000039A(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_wraziobo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_wraziobo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_wraziobo.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDate("DATAREG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_dataret,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_idbase)?Cursor_qbe_f_wraziobo.GetString("IDBASE"):CPLib.Right(Cursor_qbe_f_wraziobo.GetString("NUMPROG"),10)),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("RAREA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("RIMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(Cursor_qbe_f_wraziobo.GetDate("DATAOPE")),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wraziobo",true);
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
                } else { // Else
                  // * --- Read from fraziobo
                  m_cServer = m_Ctx.GetServer("fraziobo");
                  m_cPhName = m_Ctx.GetPhName("fraziobo");
                  m_cSql = "";
                  m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("IDBASE"),"C",10,0,m_cServer),m_cServer,Cursor_qbe_f_wraziobo.GetString("IDBASE"));
                  if (m_Ctx.IsSharedTemp("fraziobo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _idbase = Read_Cursor.GetString("IDBASE");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _idbase = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  // * --- Insert into fraziobo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("fraziobo");
                  m_cPhName = m_Ctx.GetPhName("fraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"0000039C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000039C(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_wraziobo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_wraziobo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_qbe_f_wraziobo.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_dataimp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDate("DATAREG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_dataret,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_idbase)?Cursor_qbe_f_wraziobo.GetString("IDBASE"):CPLib.Right(Cursor_qbe_f_wraziobo.GetString("NUMPROG"),10)),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("RAREA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("RIMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(Cursor_qbe_f_wraziobo.GetDate("DATAOPE")),"?",0,0)+", ";
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
                } // End If
                /* If altricli=True */
                if (CPLib.eqr(altricli,true)) {
                  // * --- Select from f_wlienti
                  m_cServer = m_Ctx.GetServer("f_wlienti");
                  m_cPhName = m_Ctx.GetPhName("f_wlienti");
                  if (Cursor_f_wlienti!=null)
                    Cursor_f_wlienti.Close();
                  Cursor_f_wlienti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_wlienti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_wlienti.Eof())) {
                    /* If pFlg='N' */
                    if (CPLib.eqr(pFlg,"N")) {
                      // * --- Insert into wlientifrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("wlientifrz");
                      m_cPhName = m_Ctx.GetPhName("wlientifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wlientifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003A0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000003A0(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wlientifrz",true);
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
                    } else { // Else
                      // * --- Insert into clientifrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("clientifrz");
                      m_cPhName = m_Ctx.GetPhName("clientifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003A1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000003A1(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wlienti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
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
                    } // End If
                    Cursor_f_wlienti.Next();
                  }
                  m_cConnectivityError = Cursor_f_wlienti.ErrorMessage();
                  Cursor_f_wlienti.Close();
                  // * --- End Select
                } // End If
                /* If altriben=True  */
                if (CPLib.eqr(altriben,true)) {
                  /* _numrig := 1 */
                  _numrig = CPLib.Round(1,0);
                  // * --- Select from f_wenefic
                  m_cServer = m_Ctx.GetServer("f_wenefic");
                  m_cPhName = m_Ctx.GetPhName("f_wenefic");
                  if (Cursor_f_wenefic!=null)
                    Cursor_f_wenefic.Close();
                  Cursor_f_wenefic = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_wenefic")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_wenefic.Eof())) {
                    /* If pFlg='N' */
                    if (CPLib.eqr(pFlg,"N")) {
                      // * --- Insert into weneficfrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("weneficfrz");
                      m_cPhName = m_Ctx.GetPhName("weneficfrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"weneficfrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003A6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000003A6(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"weneficfrz",true);
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
                    } else { // Else
                      // * --- Insert into beneficfrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("beneficfrz");
                      m_cPhName = m_Ctx.GetPhName("beneficfrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003A7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000003A7(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_wenefic.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
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
                    } // End If
                    /* _numrig := _numrig + 1 */
                    _numrig = CPLib.Round(_numrig+1,0);
                    Cursor_f_wenefic.Next();
                  }
                  m_cConnectivityError = Cursor_f_wenefic.ErrorMessage();
                  Cursor_f_wenefic.Close();
                  // * --- End Select
                } // End If
                /* If altriterz=True */
                if (CPLib.eqr(altriterz,true)) {
                  // * --- Select from f_werzisti
                  m_cServer = m_Ctx.GetServer("f_werzisti");
                  m_cPhName = m_Ctx.GetPhName("f_werzisti");
                  if (Cursor_f_werzisti!=null)
                    Cursor_f_werzisti.Close();
                  Cursor_f_werzisti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_werzisti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_werzisti.Eof())) {
                    /* If pFlg='N' */
                    if (CPLib.eqr(pFlg,"N")) {
                      // * --- Insert into werzistifrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("werzistifrz");
                      m_cPhName = m_Ctx.GetPhName("werzistifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"werzistifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003AC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000003AC(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"werzistifrz",true);
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
                    } else { // Else
                      // * --- Insert into terzistifrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("terzistifrz");
                      m_cPhName = m_Ctx.GetPhName("terzistifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003AD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000003AD(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_werzisti.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
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
                    } // End If
                    Cursor_f_werzisti.Next();
                  }
                  m_cConnectivityError = Cursor_f_werzisti.ErrorMessage();
                  Cursor_f_werzisti.Close();
                  // * --- End Select
                } // End If
                /* If altrisog=True  */
                if (CPLib.eqr(altrisog,true)) {
                  /* _numrig := 1 */
                  _numrig = CPLib.Round(1,0);
                  // * --- Select from f_woggetbo
                  m_cServer = m_Ctx.GetServer("f_woggetbo");
                  m_cPhName = m_Ctx.GetPhName("f_woggetbo");
                  if (Cursor_f_woggetbo!=null)
                    Cursor_f_woggetbo.Close();
                  Cursor_f_woggetbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_f_wraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("f_woggetbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_f_woggetbo.Eof())) {
                    /* If pFlg='N' */
                    if (CPLib.eqr(pFlg,"N")) {
                      // * --- Insert into wogopefbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("wogopefbo");
                      m_cPhName = m_Ctx.GetPhName("wogopefbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wogopefbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003B2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000003B2(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wogopefbo",true);
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
                    } else { // Else
                      // * --- Insert into sogopefbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("sogopefbo");
                      m_cPhName = m_Ctx.GetPhName("sogopefbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003B3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000003B3(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_numrig,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_woggetbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_f_woggetbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_woggetbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
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
                    } // End If
                    /* _numrig := _numrig + 1 */
                    _numrig = CPLib.Round(_numrig+1,0);
                    Cursor_f_woggetbo.Next();
                  }
                  m_cConnectivityError = Cursor_f_woggetbo.ErrorMessage();
                  Cursor_f_woggetbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_qbe_f_wraziobo.Next();
            }
            m_cConnectivityError = Cursor_qbe_f_wraziobo.ErrorMessage();
            Cursor_qbe_f_wraziobo.Close();
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
            // * --- Delete from wraziobo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wraziobo");
            m_cPhName = m_Ctx.GetPhName("wraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003B7")+"delete from "+m_oWrInfo.GetTableWriteName();
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
            }
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000389status,0)) {
              m_Sql.SetTransactionStatus(nTry00000389status,cTry00000389msg);
            }
          }
          /* _pci := _pci + 1 */
          _pci = CPLib.Round(_pci+1,0);
        } // End While
        /* Verifico la presenza del contatore dei progressivi e dell'idbase. Per evitare errori in inserimento. */
        /* If _pci > _cicli */
        if (CPLib.gt(_pci,_cicli)) {
          /* idbase */
          /* check_prog := 0 */
          check_prog = CPLib.Round(0,0);
          // * --- Read from cpwarn
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_cSql = "";
          m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","C",100,0,m_cServer),m_cServer,"prog\\PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'");
          m_cSql = m_cSql+" and warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"C",10,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda));
          if (m_Ctx.IsSharedTemp("cpwarn")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("autonum",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            check_prog = Read_Cursor.GetDouble("autonum");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            check_prog = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If check_prog>0 */
          if (CPLib.gt(check_prog,0)) {
            // * --- Write into cpwarn from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003BF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_maxfon,"N",10,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
            m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda))+"";
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
            // * --- Insert into cpwarn from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003C0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000003C0(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_maxfon,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer)+", ";
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
            }
          } // End If
          /* numprog */
          /* check_prog := 0 */
          check_prog = CPLib.Round(0,0);
          // * --- Read from cpwarn
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_cSql = "";
          m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'","C",100,0,m_cServer),m_cServer,"prog\\PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'");
          m_cSql = m_cSql+" and warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"C",10,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda));
          if (m_Ctx.IsSharedTemp("cpwarn")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("autonum",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            check_prog = Read_Cursor.GetDouble("autonum");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            check_prog = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If check_prog>0 */
          if (CPLib.gt(check_prog,0)) {
            // * --- Select from qbe_tab_mmc
            SPBridge.HMCaller _h000003C5;
            _h000003C5 = new SPBridge.HMCaller();
            _h000003C5.Set("m_cVQRList",m_cVQRList);
            _h000003C5.Set("tbname","fraziobo");
            _h000003C5.Set("fldname","NUMPROG");
            if (Cursor_qbe_tab_mmc!=null)
              Cursor_qbe_tab_mmc.Close();
            Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000003C5,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_tab_mmc.Eof())) {
              // * --- Write into cpwarn from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpwarn");
              m_cPhName = m_Ctx.GetPhName("cpwarn");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003C6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(Cursor_qbe_tab_mmc.GetDouble("max"),"N",10,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
              m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(gAzienda))+"";
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
              Cursor_qbe_tab_mmc.Next();
            }
            m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
            Cursor_qbe_tab_mmc.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from qbe_tab_mmc
            SPBridge.HMCaller _h000003C7;
            _h000003C7 = new SPBridge.HMCaller();
            _h000003C7.Set("m_cVQRList",m_cVQRList);
            _h000003C7.Set("tbname","fraziobo");
            _h000003C7.Set("fldname","NUMPROG");
            if (Cursor_qbe_tab_mmc!=null)
              Cursor_qbe_tab_mmc.Close();
            Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000003C7,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_tab_mmc.Eof())) {
              // * --- Insert into cpwarn from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpwarn");
              m_cPhName = m_Ctx.GetPhName("cpwarn");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003C8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000003C8(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tab_mmc.GetDouble("max"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gAzienda),"?",0,0,m_cServer)+", ";
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
              }
              Cursor_qbe_tab_mmc.Next();
            }
            m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
            Cursor_qbe_tab_mmc.Close();
            // * --- End Select
          } // End If
          /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Frazionate (Storico)' + NL */
          gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Frazionate (Storico)"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := gMsgProc + 'Elaborazione terminata con errori. Import abortito' + NL */
          gMsgProc = gMsgProc+"Elaborazione terminata con errori. Import abortito"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Frazionate (Storico)' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Frazionate (Storico)"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file Frazionate (Storico)' // Messaggio Import */
      gMsgImp = "Fine importazione del file Frazionate (Storico)";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_f_wlienti!=null)
          Cursor_f_wlienti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_wenefic!=null)
          Cursor_f_wenefic.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_werzisti!=null)
          Cursor_f_werzisti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_woggetbo!=null)
          Cursor_f_woggetbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_f_wperazbo_totale!=null)
          Cursor_qbe_f_wperazbo_totale.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_f_wperazbo!=null)
          Cursor_qbe_f_wperazbo.Close();
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
      try {
        if (Cursor_qbe_f_wraziobo_totale!=null)
          Cursor_qbe_f_wraziobo_totale.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_f_wraziobo!=null)
          Cursor_qbe_f_wraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_15() throws Exception {
    CPResultSet Cursor_f_aeannora=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_f_aesaldi=null;
    CPResultSet Cursor_f_aeinvio=null;
    try {
      /* _tiporap Char(2) */
      String _tiporap;
      _tiporap = CPLib.Space(2);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Saldi AGE' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Saldi AGE"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_aeannora
      m_cServer = m_Ctx.GetServer("f_aeannora");
      m_cPhName = m_Ctx.GetPhName("f_aeannora");
      if (Cursor_f_aeannora!=null)
        Cursor_f_aeannora.Close();
      Cursor_f_aeannora = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_aeannora")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_aeannora.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Inserisco Saldo per Rapporto: '+f_aeannora->RAPPORTO // Messaggio Import */
        gMsgImp = "Inserisco Saldo per Rapporto: "+Cursor_f_aeannora.GetString("RAPPORTO");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _tiporap := '' */
        _tiporap = "";
        /* _codrap := '' */
        _codrap = "";
        // * --- Read from aetesta
        m_cServer = m_Ctx.GetServer("aetesta");
        m_cPhName = m_Ctx.GetPhName("aetesta");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_f_aeannora.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_f_aeannora.GetString("RAPPORTO"));
        if (m_Ctx.IsSharedTemp("aetesta")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOAG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _tiporap = Read_Cursor.GetString("TIPOAG");
          _codrap = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aetesta into routine arrt_import_mitanti returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _tiporap = "";
          _codrap = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(_codrap)) */
        if ( ! (CPLib.Empty(_codrap))) {
          // * --- Insert into aeannora from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aeannora");
          m_cPhName = m_Ctx.GetPhName("aeannora");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeannora",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003D9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000003D9(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeannora.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeannora.GetString("ANNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeannora.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeannora.GetDouble("IMPORTO1"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeannora.GetDouble("IMPORTO2"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeannora.GetDouble("IMPORTO3"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeannora.GetDouble("IMPORTO4"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeannora.GetDouble("IMPORTO5"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeannora.GetString("PROG1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeannora.GetString("PROG2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeannora.GetString("ESITOANNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeannora.GetString("PROGREC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeannora.GetString("FILEANNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeannora",true);
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
        Cursor_f_aeannora.Next();
      }
      m_cConnectivityError = Cursor_f_aeannora.ErrorMessage();
      Cursor_f_aeannora.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file AEANNORA' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file AEANNORA"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_aesaldi
      m_cServer = m_Ctx.GetServer("f_aesaldi");
      m_cPhName = m_Ctx.GetPhName("f_aesaldi");
      if (Cursor_f_aesaldi!=null)
        Cursor_f_aesaldi.Close();
      Cursor_f_aesaldi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_aesaldi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_aesaldi.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Inserisco File Saldi: '+f_aesaldi->NOMEFILE // Messaggio Import */
        gMsgImp = "Inserisco File Saldi: "+Cursor_f_aesaldi.GetString("NOMEFILE");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Insert into aesaldi from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aesaldi");
        m_cPhName = m_Ctx.GetPhName("aesaldi");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003DF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000003DF(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aesaldi.GetString("NOMEFILE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aesaldi.GetString("ANNO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aesaldi.GetString("PROTOCOLLO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aesaldi.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aesaldi.GetString("TIPO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aesaldi.GetString("FILEINV1"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aesaldi.GetString("FILEINV2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aesaldi.GetDouble("ANNULLATO"),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aesaldi",true);
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
        Cursor_f_aesaldi.Next();
      }
      m_cConnectivityError = Cursor_f_aesaldi.ErrorMessage();
      Cursor_f_aesaldi.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file AESALDI' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file AESALDI"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_aeinvio
      m_cServer = m_Ctx.GetServer("f_aeinvio");
      m_cPhName = m_Ctx.GetPhName("f_aeinvio");
      if (Cursor_f_aeinvio!=null)
        Cursor_f_aeinvio.Close();
      Cursor_f_aeinvio = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_aeinvio")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_aeinvio.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Inserisco Dati File Invio: '+f_aeinvio->FILEANNO // Messaggio Import */
        gMsgImp = "Inserisco Dati File Invio: "+Cursor_f_aeinvio.GetString("FILEANNO");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Insert into aeinvio from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aeinvio");
        m_cPhName = m_Ctx.GetPhName("aeinvio");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeinvio",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003E5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000003E5(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeinvio.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeinvio.GetString("PROG1"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeinvio.GetString("PROG2"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeinvio.GetString("PROGREC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeinvio.GetString("FILEANNO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeinvio.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeinvio.GetString("ANNO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aeinvio.GetString("TIPO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeinvio",true);
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
        Cursor_f_aeinvio.Next();
      }
      m_cConnectivityError = Cursor_f_aeinvio.ErrorMessage();
      Cursor_f_aeinvio.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file AEINVIO' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file AEINVIO"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Saldi AGE' +NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Saldi AGE"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_f_aeannora!=null)
          Cursor_f_aeannora.Close();
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
        if (Cursor_f_aesaldi!=null)
          Cursor_f_aesaldi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_aeinvio!=null)
          Cursor_f_aeinvio.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_16() throws Exception {
    CPResultSet Cursor_f_garantbo=null;
    try {
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Garantiti' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Garantiti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_garantbo
      m_cServer = m_Ctx.GetServer("f_garantbo");
      m_cPhName = m_Ctx.GetPhName("f_garantbo");
      if (Cursor_f_garantbo!=null)
        Cursor_f_garantbo.Close();
      Cursor_f_garantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_garantbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_garantbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Inserisco Garantito per Rapporto: '+f_garantbo->RAPPORTO // Messaggio Import */
        gMsgImp = "Inserisco Garantito per Rapporto: "+Cursor_f_garantbo.GetString("RAPPORTO");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Insert into garantbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("garantbo");
        m_cPhName = m_Ctx.GetPhName("garantbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"garantbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003EE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000003EE(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_garantbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(Cursor_f_garantbo.GetString("CODINTER")),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_garantbo.GetDate("DATAINI"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_garantbo.GetDate("DATAFINE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_garantbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"garantbo",true);
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
        Cursor_f_garantbo.Next();
      }
      m_cConnectivityError = Cursor_f_garantbo.ErrorMessage();
      Cursor_f_garantbo.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Garantiti' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Garantiti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Garantiti' +NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Garantiti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_f_garantbo!=null)
          Cursor_f_garantbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_17() throws Exception {
    CPResultSet Cursor_f_storicoxbrl=null;
    CPResultSet Cursor_f_storicoxbrl_dett=null;
    try {
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Storico XBRL' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Storico XBRL"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_storicoxbrl
      m_cServer = m_Ctx.GetServer("f_storicoxbrl");
      m_cPhName = m_Ctx.GetPhName("f_storicoxbrl");
      if (Cursor_f_storicoxbrl!=null)
        Cursor_f_storicoxbrl.Close();
      Cursor_f_storicoxbrl = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_storicoxbrl")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_storicoxbrl.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Inserisco Registrazione : '+ f_storicoxbrl->ANNORIF + "-" + f_storicoxbrl->MESERIF + "-"+f_storicoxbrl->PROGRIF // Messaggio Import */
        gMsgImp = "Inserisco Registrazione : "+Cursor_f_storicoxbrl.GetString("ANNORIF")+"-"+Cursor_f_storicoxbrl.GetString("MESERIF")+"-"+Cursor_f_storicoxbrl.GetString("PROGRIF");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Insert into storicoxbrl from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("storicoxbrl");
        m_cPhName = m_Ctx.GetPhName("storicoxbrl");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"storicoxbrl",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003F7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000003F7(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("ANNORIF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("MESERIF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("PROGRIF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("CODINTDIP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("ABICABDIP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("CODCABDIP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("PERPAESE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("PERCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("PAESECP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("CODCABCP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("PAESEICP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetString("CABICP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetDouble("TOTLIRE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetDouble("TOTCONT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetDouble("OPERAZIONI"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl.GetDouble("CONTANTI"),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"storicoxbrl",true);
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
        Cursor_f_storicoxbrl.Next();
      }
      m_cConnectivityError = Cursor_f_storicoxbrl.ErrorMessage();
      Cursor_f_storicoxbrl.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Storico XBRL' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Storico XBRL"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from f_storicoxbrl_dett
      m_cServer = m_Ctx.GetServer("f_storicoxbrl_dett");
      m_cPhName = m_Ctx.GetPhName("f_storicoxbrl_dett");
      if (Cursor_f_storicoxbrl_dett!=null)
        Cursor_f_storicoxbrl_dett.Close();
      Cursor_f_storicoxbrl_dett = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_storicoxbrl_dett")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_f_storicoxbrl_dett.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Inserisco Registrazione : '+ f_storicoxbrl_dett->ANNORIF + "-" + f_storicoxbrl_dett->MESERIF + "-"+f_storicoxbrl_dett->PROGRIF+"-"+f_storicoxbrl_dett->TIPOPE+"-"+f_storicoxbrl_dett->NUMPROG // Messaggio Import */
        gMsgImp = "Inserisco Registrazione : "+Cursor_f_storicoxbrl_dett.GetString("ANNORIF")+"-"+Cursor_f_storicoxbrl_dett.GetString("MESERIF")+"-"+Cursor_f_storicoxbrl_dett.GetString("PROGRIF")+"-"+Cursor_f_storicoxbrl_dett.GetString("TIPOPE")+"-"+Cursor_f_storicoxbrl_dett.GetString("NUMPROG");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Insert into storicoxbrl_dett from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("storicoxbrl_dett");
        m_cPhName = m_Ctx.GetPhName("storicoxbrl_dett");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"storicoxbrl_dett",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"000003FD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000003FD(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("ANNORIF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("MESERIF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("PROGRIF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("TIPOPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetDate("DATAOPE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetDouble("TOTLIRE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetDouble("TOTCONT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("CODINTDIP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("ABICABDIP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("CODCABDIP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("PERPAESE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("PERCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("PAESECP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("CODCABCP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("INTCONTRO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("PAESEICP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_storicoxbrl_dett.GetString("CABICP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"storicoxbrl_dett",true);
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
        Cursor_f_storicoxbrl_dett.Next();
      }
      m_cConnectivityError = Cursor_f_storicoxbrl_dett.ErrorMessage();
      Cursor_f_storicoxbrl_dett.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Storico XBRL (Dettaglio)' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Storico XBRL (Dettaglio)"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Storico XBRL' +NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Storico XBRL"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_f_storicoxbrl!=null)
          Cursor_f_storicoxbrl.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_f_storicoxbrl_dett!=null)
          Cursor_f_storicoxbrl_dett.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_18() throws Exception {
    CPResultSet Cursor_f_aefaminvio=null;
    try {
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file INVII AGE' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file INVII AGE"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000404status;
      nTry00000404status = m_Sql.GetTransactionStatus();
      String cTry00000404msg;
      cTry00000404msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from f_aefaminvio
        m_cServer = m_Ctx.GetServer("f_aefaminvio");
        m_cPhName = m_Ctx.GetPhName("f_aefaminvio");
        if (Cursor_f_aefaminvio!=null)
          Cursor_f_aefaminvio.Close();
        Cursor_f_aefaminvio = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("f_aefaminvio")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_f_aefaminvio.Eof())) {
          /* gMsgImp := 'Inserisco Registrazione : '+ f_aefaminvio->IDBASE + " per Anno/Mese: " +f_aefaminvio->ANNO +"/"+f_aefaminvio->MESE // Messaggio Import */
          gMsgImp = "Inserisco Registrazione : "+Cursor_f_aefaminvio.GetString("IDBASE")+" per Anno/Mese: "+Cursor_f_aefaminvio.GetString("ANNO")+"/"+Cursor_f_aefaminvio.GetString("MESE");
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Insert into aefaminvio from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aefaminvio");
          m_cPhName = m_Ctx.GetPhName("aefaminvio");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aefaminvio",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_mitanti",736,"00000407")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000407(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aefaminvio.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aefaminvio.GetString("IDIDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aefaminvio.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aefaminvio.GetString("TIPOINVIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aefaminvio.GetString("ANNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aefaminvio.GetString("MESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aefaminvio.GetString("TIPOCOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aefaminvio.GetDate("OLDDATA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aefaminvio.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aefaminvio.GetString("NOMEFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aefaminvio.GetString("FILEINV1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aefaminvio.GetString("FILEINV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aefaminvio.GetDouble("PROG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aefaminvio.GetString("PROTOCOLLO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_f_aefaminvio.GetString("CODERROR"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefaminvio",true);
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
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          Cursor_f_aefaminvio.Next();
        }
        m_cConnectivityError = Cursor_f_aefaminvio.ErrorMessage();
        Cursor_f_aefaminvio.Close();
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000404status,0)) {
          m_Sql.SetTransactionStatus(nTry00000404status,cTry00000404msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file Storico XBRL' + NL */
      gMsgProc = gMsgProc+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file Storico XBRL"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_f_aefaminvio!=null)
          Cursor_f_aefaminvio.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pOper,String p_pFlg) {
    pOper = p_pOper;
    pFlg = p_pFlg;
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
  public static arrt_import_mitantiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_mitantiR(p_Ctx, p_Caller);
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
    _oldrapporto = CPLib.Space(25);
    _maxprg = 0;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_f_personbo_totale,qbe_f_personbo,qbe_f_wersonbo_totale,qbe_f_wersonbo,qbe_tab_mmc,qbe_tab_mmc,qbe_f_operazbo_totale,qbe_f_operazbo,qbe_tab_mmc,qbe_tab_mmc,qbe_f_fraziobo_totale,qbe_f_fraziobo,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_f_aeoprig_totale,qbe_f_aeoprig,qbe_tab_mmc,qbe_tab_mmc,qbe_f_opextrbo_totale,qbe_f_opextrbo,qbe_f_wperazbo_totale,qbe_f_wperazbo,qbe_tab_mmc,qbe_tab_mmc,qbe_f_wraziobo_totale,qbe_f_wraziobo,qbe_tab_mmc,qbe_tab_mmc,
  public static final String m_cVQRList = ",qbe_f_personbo_totale,qbe_f_personbo,qbe_f_wersonbo_totale,qbe_f_wersonbo,qbe_tab_mmc,qbe_tab_mmc,qbe_f_operazbo_totale,qbe_f_operazbo,qbe_tab_mmc,qbe_tab_mmc,qbe_f_fraziobo_totale,qbe_f_fraziobo,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_f_aeoprig_totale,qbe_f_aeoprig,qbe_tab_mmc,qbe_tab_mmc,qbe_f_opextrbo_totale,qbe_f_opextrbo,qbe_f_wperazbo_totale,qbe_f_wperazbo,qbe_tab_mmc,qbe_tab_mmc,qbe_f_wraziobo_totale,qbe_f_wraziobo,qbe_tab_mmc,qbe_tab_mmc,";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pOper","pFlg"};
  protected static String GetFieldsName_0000005D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"SUPPLEM,";
    p_cSql = p_cSql+"DBPROT,";
    p_cSql = p_cSql+"CONTATORE,";
    p_cSql = p_cSql+"AEPATH,";
    p_cSql = p_cSql+"MOLTI,";
    p_cSql = p_cSql+"CFINVIO,";
    p_cSql = p_cSql+"CAFINVIO,";
    p_cSql = p_cSql+"FILEINVIO,";
    p_cSql = p_cSql+"DATAINVIO,";
    p_cSql = p_cSql+"FLGWU,";
    p_cSql = p_cSql+"IDSID,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intermbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINTER,";
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
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"inter2bo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000079(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ABICABSARA,";
    p_cSql = p_cSql+"AGACCODE,";
    p_cSql = p_cSql+"AGEREGIO,";
    p_cSql = p_cSql+"ANOMOPER,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"CAB2,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+"CODAGE,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"CODLOC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"FLGATT,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"NAZAGENTE,";
    p_cSql = p_cSql+"NUOVO,";
    p_cSql = p_cSql+"OPXSOSAGE,";
    p_cSql = p_cSql+"OPXSOSCLI,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"TERMINALID,";
    p_cSql = p_cSql+"TIPOAGENTE,";
    p_cSql = p_cSql+"TIPOSV,";
    p_cSql = p_cSql+"VALCOMPL,";
    p_cSql = p_cSql+"AGENTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anadip",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"OLDCONNES,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"PEP,";
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
    p_cSql = p_cSql+"NOTIT,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+"CITTADIN1,";
    p_cSql = p_cSql+"CITTADIN2,";
    p_cSql = p_cSql+"RESFISC,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITIGDOC,";
    p_cSql = p_cSql+"NOSARA,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"DATAPROF,";
    p_cSql = p_cSql+"DATAREVPROF,";
    p_cSql = p_cSql+"IDENT,";
    p_cSql = p_cSql+"PEPDATE,";
    p_cSql = p_cSql+"DAC6,";
    p_cSql = p_cSql+"FLAGDAC6,";
    p_cSql = p_cSql+"CRIME,";
    p_cSql = p_cSql+"CRIMEDATE,";
    p_cSql = p_cSql+"ALTRODOM,";
    p_cSql = p_cSql+"ALTROCAP,";
    p_cSql = p_cSql+"CONTO,";
    p_cSql = p_cSql+"NUMIMP,";
    p_cSql = p_cSql+"DATAIDENT,";
    p_cSql = p_cSql+"DATASIGN,";
    p_cSql = p_cSql+"DATARAUT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"EMAIL,";
    p_cSql = p_cSql+"FLGEMAIL,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"RDCODAUT,";
    p_cSql = p_cSql+"RDLOCAUT,";
    p_cSql = p_cSql+"FLGBANCA,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+"REGRES,";
    p_cSql = p_cSql+"FLGBL,";
    p_cSql = p_cSql+"CLOCCUPA,";
    p_cSql = p_cSql+"NUMTEL,";
    p_cSql = p_cSql+"NAZIONE,";
    p_cSql = p_cSql+"LASTOPER,";
    p_cSql = p_cSql+"CODCLIEST,";
    p_cSql = p_cSql+"FLGANAVAL,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+"FLGPREGIUD,";
    p_cSql = p_cSql+"FLGTRUST,";
    p_cSql = p_cSql+"FLGRISCHIO,";
    p_cSql = p_cSql+"FLGEQUIFIN,";
    p_cSql = p_cSql+"FLGFALSADIC,";
    p_cSql = p_cSql+"FLGRICINF,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000AE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+"CITTADIN1,";
    p_cSql = p_cSql+"CITTADIN2,";
    p_cSql = p_cSql+"RESFISC,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+"NOSARA,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"DATAPROF,";
    p_cSql = p_cSql+"DATAREVPROF,";
    p_cSql = p_cSql+"IDENT,";
    p_cSql = p_cSql+"PEPDATE,";
    p_cSql = p_cSql+"DAC6,";
    p_cSql = p_cSql+"FLAGDAC6,";
    p_cSql = p_cSql+"CRIME,";
    p_cSql = p_cSql+"CRIMEDATE,";
    p_cSql = p_cSql+"ALTRODOM,";
    p_cSql = p_cSql+"ALTROCAP,";
    p_cSql = p_cSql+"CONTO,";
    p_cSql = p_cSql+"NUMIMP,";
    p_cSql = p_cSql+"RAPSEGNA,";
    p_cSql = p_cSql+"CODLEGRAP,";
    p_cSql = p_cSql+"TIPOSOGGETTO,";
    p_cSql = p_cSql+"CAUSALE,";
    p_cSql = p_cSql+"IMPORTOMAX,";
    p_cSql = p_cSql+"FATTURATO,";
    p_cSql = p_cSql+"FREQUENZA,";
    p_cSql = p_cSql+"NUMOPERAZ,";
    p_cSql = p_cSql+"SOGAFFIDATARIO,";
    p_cSql = p_cSql+"FLGNOTRIM,";
    p_cSql = p_cSql+"DISATTIVO,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAIDENT,";
    p_cSql = p_cSql+"DATARAUT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"EMAIL,";
    p_cSql = p_cSql+"FLGEMAIL,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"RDCODAUT,";
    p_cSql = p_cSql+"RDLOCAUT,";
    p_cSql = p_cSql+"FLGBANCA,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+"REGRES,";
    p_cSql = p_cSql+"FLGBL,";
    p_cSql = p_cSql+"CLOCCUPA,";
    p_cSql = p_cSql+"NUMTEL,";
    p_cSql = p_cSql+"NAZIONE,";
    p_cSql = p_cSql+"LASTOPER,";
    p_cSql = p_cSql+"CODCLIEST,";
    p_cSql = p_cSql+"FLGANAVAL,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+"FLGPREGIUD,";
    p_cSql = p_cSql+"FLGTRUST,";
    p_cSql = p_cSql+"FLGRISCHIO,";
    p_cSql = p_cSql+"FLGEQUIFIN,";
    p_cSql = p_cSql+"FLGFALSADIC,";
    p_cSql = p_cSql+"FLGRICINF,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"OLDCONNES,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"datamodi,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"DATASEGN,";
    p_cSql = p_cSql+"DATAVARAGE,";
    p_cSql = p_cSql+"SETTSINT2,";
    p_cSql = p_cSql+"FATCA,";
    p_cSql = p_cSql+"TIN,";
    p_cSql = p_cSql+"ODB,";
    p_cSql = p_cSql+"TELEF,";
    p_cSql = p_cSql+"TIPOORO,";
    p_cSql = p_cSql+"CODORO,";
    p_cSql = p_cSql+"NOTIT,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+"CITTADIN1,";
    p_cSql = p_cSql+"CITTADIN2,";
    p_cSql = p_cSql+"RESFISC,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+"NOSARA,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"DATAPROF,";
    p_cSql = p_cSql+"DATAREVPROF,";
    p_cSql = p_cSql+"IDENT,";
    p_cSql = p_cSql+"PEPDATE,";
    p_cSql = p_cSql+"DAC6,";
    p_cSql = p_cSql+"FLAGDAC6,";
    p_cSql = p_cSql+"ALTRODOM,";
    p_cSql = p_cSql+"ALTROCAP,";
    p_cSql = p_cSql+"CONTO,";
    p_cSql = p_cSql+"NUMIMP,";
    p_cSql = p_cSql+"DATAIDENT,";
    p_cSql = p_cSql+"DATARAUT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"sanumpro,";
    p_cSql = p_cSql+"datamodi,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"EMAIL,";
    p_cSql = p_cSql+"FLGEMAIL,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"RDCODAUT,";
    p_cSql = p_cSql+"RDLOCAUT,";
    p_cSql = p_cSql+"FLGBANCA,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+"REGRES,";
    p_cSql = p_cSql+"FLGBL,";
    p_cSql = p_cSql+"CLOCCUPA,";
    p_cSql = p_cSql+"NUMTEL,";
    p_cSql = p_cSql+"NAZIONE,";
    p_cSql = p_cSql+"LASTOPER,";
    p_cSql = p_cSql+"CODCLIEST,";
    p_cSql = p_cSql+"FLGANAVAL,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+"FLGPREGIUD,";
    p_cSql = p_cSql+"FLGTRUST,";
    p_cSql = p_cSql+"FLGRISCHIO,";
    p_cSql = p_cSql+"FLGEQUIFIN,";
    p_cSql = p_cSql+"FLGFALSADIC,";
    p_cSql = p_cSql+"FLGRICINF,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000DF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CONTINUA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"TIPMOD,";
    p_cSql = p_cSql+"DATAMOD,";
    p_cSql = p_cSql+"IDRAPPORTO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"IMPAPE,";
    p_cSql = p_cSql+"IMPCHIU,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"knarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000EA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
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
  protected static String GetFieldsName_000000F7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000FB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000103(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000010D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"NOAGE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"delegabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000147(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anadip",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000151(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
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
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
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
    p_cSql = p_cSql+"RESPINS,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITIGDOC,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"SV58550,";
    p_cSql = p_cSql+"PROQUOTA,";
    p_cSql = p_cSql+"TIPOORO,";
    p_cSql = p_cSql+"DAC6,";
    p_cSql = p_cSql+"FLAGDAC6,";
    p_cSql = p_cSql+"IMPSARA,";
    p_cSql = p_cSql+"SV58550MA,";
    p_cSql = p_cSql+"NOSARA,";
    p_cSql = p_cSql+"MEZPAG,";
    p_cSql = p_cSql+"PRESTAZ,";
    p_cSql = p_cSql+"NUMIMP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000154(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000158(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000015C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000160(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000164(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000170(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000178(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000019C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anadip",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001A8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
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
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
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
    p_cSql = p_cSql+"RESPINS,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITIGDOC,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"SV58550,";
    p_cSql = p_cSql+"PROQUOTA,";
    p_cSql = p_cSql+"TIPOORO,";
    p_cSql = p_cSql+"DAC6,";
    p_cSql = p_cSql+"FLAGDAC6,";
    p_cSql = p_cSql+"IMPSARA,";
    p_cSql = p_cSql+"SV58550MA,";
    p_cSql = p_cSql+"NOSARA,";
    p_cSql = p_cSql+"MEZPAG,";
    p_cSql = p_cSql+"PRESTAZ,";
    p_cSql = p_cSql+"NUMIMP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001AB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001AF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001B3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001B7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001BB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001C7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001CF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001E1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPTIT,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapotit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001E7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001EF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001F6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PRGIMPTITE,";
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
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000202(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CONTINUA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"TIPMOD,";
    p_cSql = p_cSql+"DATAMOD,";
    p_cSql = p_cSql+"IDRAPPORTO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"IMPAPE,";
    p_cSql = p_cSql+"IMPCHIU,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000206(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000213(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"japopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000021F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RIFANA,";
    p_cSql = p_cSql+"PROGAET,";
    p_cSql = p_cSql+"FLGIMP,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"OLDINTER,";
    p_cSql = p_cSql+"DATAMODI,";
    p_cSql = p_cSql+"INVIATO,";
    p_cSql = p_cSql+"DATAINVIO,";
    p_cSql = p_cSql+"ANNULLA,";
    p_cSql = p_cSql+"DATAANNU,";
    p_cSql = p_cSql+"OLDUNIQUE,";
    p_cSql = p_cSql+"DATAOLDUNI,";
    p_cSql = p_cSql+"IDESITOFAM,";
    p_cSql = p_cSql+"INVIATOC,";
    p_cSql = p_cSql+"DATAINVIOC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aetesta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000225(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ABBSALDI,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"ADTPRE,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"AOLDFILE,";
    p_cSql = p_cSql+"AOLDPROG,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"CDTPRE,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"COLDFILE,";
    p_cSql = p_cSql+"COLDPROG,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"ESITOANNO,";
    p_cSql = p_cSql+"FILEANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROG1,";
    p_cSql = p_cSql+"PROG2,";
    p_cSql = p_cSql+"PROGAER,";
    p_cSql = p_cSql+"PROGREC,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RSPEDITO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aerighe",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000232(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"ADTPRE,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"AOLDFILE,";
    p_cSql = p_cSql+"AOLDPROG,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"CDTPRE,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"COLDFILE,";
    p_cSql = p_cSql+"COLDPROG,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGDLG,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RSPEDITO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aederig",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000238(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"ADTPRE,";
    p_cSql = p_cSql+"CDTPRE,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"IDESITO,";
    p_cSql = p_cSql+"DATESITO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aedestor",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000023E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"AOLDPROG,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"AOLDFILE,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"COLDPROG,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"COLDFILE,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"RIFRIGA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RIFSTOR,";
    p_cSql = p_cSql+"DATARIF,";
    p_cSql = p_cSql+"TIPOCAN,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IDPROG,";
    p_cSql = p_cSql+"ADTPRE,";
    p_cSql = p_cSql+"CDTPRE,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"IDESITO,";
    p_cSql = p_cSql+"OLDINTER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aedecanc",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000256(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"ADTPRE,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"AOLDFILE,";
    p_cSql = p_cSql+"AOLDPROG,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"CDTPRE,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"COLDFILE,";
    p_cSql = p_cSql+"COLDPROG,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGOPX,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"RSPEDITO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeoprig",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000269(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CONTINUA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"TIPMOD,";
    p_cSql = p_cSql+"DATAMOD,";
    p_cSql = p_cSql+"IDRAPPORTO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000026D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"knarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000273(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000280(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000283(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xoginfo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000292(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
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
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
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
    p_cSql = p_cSql+"RESPINS,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000294(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000297(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xeneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000029A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xerzistiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000029D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002AA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
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
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
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
    p_cSql = p_cSql+"RESPINS,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002AC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002AF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xeneficfrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002B2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xerzistifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002B5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xogopefbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002C6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xapotit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002CC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002D4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002DB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"CODCLI,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"PRGIMPTITE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xntestit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002F6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"RIFIMP,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000331(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anadip",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000033C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
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
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
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
    p_cSql = p_cSql+"RESPINS,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000033E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
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
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
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
    p_cSql = p_cSql+"RESPINS,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000342(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000343(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000348(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"weneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000349(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000034E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"werzistiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000034F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000354(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000355(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000363(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000036B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000038F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anadip",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000039A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
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
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
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
    p_cSql = p_cSql+"RESPINS,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000039C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
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
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
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
    p_cSql = p_cSql+"RESPINS,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003A0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003A1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000003A6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"weneficfrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003A7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000003AC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"werzistifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003AD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000003B2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wogopefbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003B3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sogopefbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003C0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003C8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003D9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPRAP,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IMPORTO1,";
    p_cSql = p_cSql+"IMPORTO2,";
    p_cSql = p_cSql+"IMPORTO3,";
    p_cSql = p_cSql+"IMPORTO4,";
    p_cSql = p_cSql+"IMPORTO5,";
    p_cSql = p_cSql+"PROG1,";
    p_cSql = p_cSql+"PROG2,";
    p_cSql = p_cSql+"ESITOANNO,";
    p_cSql = p_cSql+"PROGREC,";
    p_cSql = p_cSql+"FILEANNO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeannora",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003DF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NOMEFILE,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"PROTOCOLLO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"FILEINV1,";
    p_cSql = p_cSql+"FILEINV2,";
    p_cSql = p_cSql+"ANNULLATO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aesaldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003E5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"PROG1,";
    p_cSql = p_cSql+"PROG2,";
    p_cSql = p_cSql+"PROGREC,";
    p_cSql = p_cSql+"FILEANNO,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeinvio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003EE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"garantbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003F7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNORIF,";
    p_cSql = p_cSql+"MESERIF,";
    p_cSql = p_cSql+"PROGRIF,";
    p_cSql = p_cSql+"CODINTDIP,";
    p_cSql = p_cSql+"ABICABDIP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"CODCABCP,";
    p_cSql = p_cSql+"PAESEICP,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"OPERAZIONI,";
    p_cSql = p_cSql+"CONTANTI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"storicoxbrl",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003FD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNORIF,";
    p_cSql = p_cSql+"MESERIF,";
    p_cSql = p_cSql+"PROGRIF,";
    p_cSql = p_cSql+"TIPOPE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"CODINTDIP,";
    p_cSql = p_cSql+"ABICABDIP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"PERPAESE,";
    p_cSql = p_cSql+"PERCAB,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"CODCABCP,";
    p_cSql = p_cSql+"INTCONTRO,";
    p_cSql = p_cSql+"PAESEICP,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"storicoxbrl_dett",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000407(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDIDBASE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINVIO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"MESE,";
    p_cSql = p_cSql+"TIPOCOM,";
    p_cSql = p_cSql+"OLDDATA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NOMEFILE,";
    p_cSql = p_cSql+"FILEINV1,";
    p_cSql = p_cSql+"FILEINV2,";
    p_cSql = p_cSql+"PROG,";
    p_cSql = p_cSql+"PROTOCOLLO,";
    p_cSql = p_cSql+"CODERROR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefaminvio",true);
    return p_cSql;
  }
}
