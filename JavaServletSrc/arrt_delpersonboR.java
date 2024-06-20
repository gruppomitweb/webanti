// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_delpersonboR implements CallerWithObjs {
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
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xntestit;
  public String m_cServer_xntestit;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xerzistiope;
  public String m_cServer_xerzistiope;
  public String m_cPhName_xerzistifrz;
  public String m_cServer_xerzistifrz;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_xeneficfrz;
  public String m_cServer_xeneficfrz;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public String m_cPhName_xapotit;
  public String m_cServer_xapotit;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_wraziobo;
  public String m_cServer_wraziobo;
  public String m_cPhName_wperazbo;
  public String m_cServer_wperazbo;
  public String m_cPhName_wogopefbo;
  public String m_cServer_wogopefbo;
  public String m_cPhName_wogopebo;
  public String m_cServer_wogopebo;
  public String m_cPhName_wntestbo;
  public String m_cServer_wntestbo;
  public String m_cPhName_wlientiope;
  public String m_cServer_wlientiope;
  public String m_cPhName_wlientifrz;
  public String m_cServer_wlientifrz;
  public String m_cPhName_widuciabo;
  public String m_cServer_widuciabo;
  public String m_cPhName_werzistiope;
  public String m_cServer_werzistiope;
  public String m_cPhName_werzistifrz;
  public String m_cServer_werzistifrz;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_weneficope;
  public String m_cServer_weneficope;
  public String m_cPhName_weneficfrz;
  public String m_cServer_weneficfrz;
  public String m_cPhName_wapopebo;
  public String m_cServer_wapopebo;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_personbo_dip;
  public String m_cServer_personbo_dip;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_kperazbo;
  public String m_cServer_kperazbo;
  public String m_cPhName_jperazbo;
  public String m_cServer_jperazbo;
  public String m_cPhName_jntestit;
  public String m_cServer_jntestit;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_japotit;
  public String m_cServer_japotit;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_woginfo;
  public String m_cServer_woginfo;
  public String m_cPhName_fiduciabo;
  public String m_cServer_fiduciabo;
  public String m_cPhName_soginfo;
  public String m_cServer_soginfo;
  public String m_cPhName_garantbo;
  public String m_cServer_garantbo;
  public String m_cPhName_xoginfo;
  public String m_cServer_xoginfo;
  public String m_cPhName_xiduciabo;
  public String m_cServer_xiduciabo;
  public String m_cPhName_xarantbo;
  public String m_cServer_xarantbo;
  public String m_cPhName_welegabo;
  public String m_cServer_welegabo;
  public String m_cPhName_warantbo;
  public String m_cServer_warantbo;
  public String m_cPhName_jarantbo;
  public String m_cServer_jarantbo;
  public String m_cPhName_wersonbo_agg;
  public String m_cServer_wersonbo_agg;
  public String m_cPhName_wersonbo_dip;
  public String m_cServer_wersonbo_dip;
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
  public String w_CONNES;
  public double conta;
  public String _presenza;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_delpersonboR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_delpersonbo",m_Caller);
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    if (m_cPhName_xraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo = m_cPhName_xraziobo+" "+m_Ctx.GetWritePhName("xraziobo");
    }
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xogopefbo = p_ContextObject.GetPhName("xogopefbo");
    if (m_cPhName_xogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopefbo = m_cPhName_xogopefbo+" "+m_Ctx.GetWritePhName("xogopefbo");
    }
    m_cServer_xogopefbo = p_ContextObject.GetServer("xogopefbo");
    m_cPhName_xogopebo = p_ContextObject.GetPhName("xogopebo");
    if (m_cPhName_xogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopebo = m_cPhName_xogopebo+" "+m_Ctx.GetWritePhName("xogopebo");
    }
    m_cServer_xogopebo = p_ContextObject.GetServer("xogopebo");
    m_cPhName_xntestit = p_ContextObject.GetPhName("xntestit");
    if (m_cPhName_xntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestit = m_cPhName_xntestit+" "+m_Ctx.GetWritePhName("xntestit");
    }
    m_cServer_xntestit = p_ContextObject.GetServer("xntestit");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xlientiope = p_ContextObject.GetPhName("xlientiope");
    if (m_cPhName_xlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientiope = m_cPhName_xlientiope+" "+m_Ctx.GetWritePhName("xlientiope");
    }
    m_cServer_xlientiope = p_ContextObject.GetServer("xlientiope");
    m_cPhName_xlientifrz = p_ContextObject.GetPhName("xlientifrz");
    if (m_cPhName_xlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientifrz = m_cPhName_xlientifrz+" "+m_Ctx.GetWritePhName("xlientifrz");
    }
    m_cServer_xlientifrz = p_ContextObject.GetServer("xlientifrz");
    m_cPhName_xerzistiope = p_ContextObject.GetPhName("xerzistiope");
    if (m_cPhName_xerzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistiope = m_cPhName_xerzistiope+" "+m_Ctx.GetWritePhName("xerzistiope");
    }
    m_cServer_xerzistiope = p_ContextObject.GetServer("xerzistiope");
    m_cPhName_xerzistifrz = p_ContextObject.GetPhName("xerzistifrz");
    if (m_cPhName_xerzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistifrz = m_cPhName_xerzistifrz+" "+m_Ctx.GetWritePhName("xerzistifrz");
    }
    m_cServer_xerzistifrz = p_ContextObject.GetServer("xerzistifrz");
    m_cPhName_xeneficope = p_ContextObject.GetPhName("xeneficope");
    if (m_cPhName_xeneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficope = m_cPhName_xeneficope+" "+m_Ctx.GetWritePhName("xeneficope");
    }
    m_cServer_xeneficope = p_ContextObject.GetServer("xeneficope");
    m_cPhName_xeneficfrz = p_ContextObject.GetPhName("xeneficfrz");
    if (m_cPhName_xeneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficfrz = m_cPhName_xeneficfrz+" "+m_Ctx.GetWritePhName("xeneficfrz");
    }
    m_cServer_xeneficfrz = p_ContextObject.GetServer("xeneficfrz");
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    if (m_cPhName_xelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xelegabo = m_cPhName_xelegabo+" "+m_Ctx.GetWritePhName("xelegabo");
    }
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    m_cPhName_xapotit = p_ContextObject.GetPhName("xapotit");
    if (m_cPhName_xapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapotit = m_cPhName_xapotit+" "+m_Ctx.GetWritePhName("xapotit");
    }
    m_cServer_xapotit = p_ContextObject.GetServer("xapotit");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_wraziobo = p_ContextObject.GetPhName("wraziobo");
    if (m_cPhName_wraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wraziobo = m_cPhName_wraziobo+" "+m_Ctx.GetWritePhName("wraziobo");
    }
    m_cServer_wraziobo = p_ContextObject.GetServer("wraziobo");
    m_cPhName_wperazbo = p_ContextObject.GetPhName("wperazbo");
    if (m_cPhName_wperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wperazbo = m_cPhName_wperazbo+" "+m_Ctx.GetWritePhName("wperazbo");
    }
    m_cServer_wperazbo = p_ContextObject.GetServer("wperazbo");
    m_cPhName_wogopefbo = p_ContextObject.GetPhName("wogopefbo");
    if (m_cPhName_wogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wogopefbo = m_cPhName_wogopefbo+" "+m_Ctx.GetWritePhName("wogopefbo");
    }
    m_cServer_wogopefbo = p_ContextObject.GetServer("wogopefbo");
    m_cPhName_wogopebo = p_ContextObject.GetPhName("wogopebo");
    if (m_cPhName_wogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wogopebo = m_cPhName_wogopebo+" "+m_Ctx.GetWritePhName("wogopebo");
    }
    m_cServer_wogopebo = p_ContextObject.GetServer("wogopebo");
    m_cPhName_wntestbo = p_ContextObject.GetPhName("wntestbo");
    if (m_cPhName_wntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wntestbo = m_cPhName_wntestbo+" "+m_Ctx.GetWritePhName("wntestbo");
    }
    m_cServer_wntestbo = p_ContextObject.GetServer("wntestbo");
    m_cPhName_wlientiope = p_ContextObject.GetPhName("wlientiope");
    if (m_cPhName_wlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wlientiope = m_cPhName_wlientiope+" "+m_Ctx.GetWritePhName("wlientiope");
    }
    m_cServer_wlientiope = p_ContextObject.GetServer("wlientiope");
    m_cPhName_wlientifrz = p_ContextObject.GetPhName("wlientifrz");
    if (m_cPhName_wlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wlientifrz = m_cPhName_wlientifrz+" "+m_Ctx.GetWritePhName("wlientifrz");
    }
    m_cServer_wlientifrz = p_ContextObject.GetServer("wlientifrz");
    m_cPhName_widuciabo = p_ContextObject.GetPhName("widuciabo");
    if (m_cPhName_widuciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_widuciabo = m_cPhName_widuciabo+" "+m_Ctx.GetWritePhName("widuciabo");
    }
    m_cServer_widuciabo = p_ContextObject.GetServer("widuciabo");
    m_cPhName_werzistiope = p_ContextObject.GetPhName("werzistiope");
    if (m_cPhName_werzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_werzistiope = m_cPhName_werzistiope+" "+m_Ctx.GetWritePhName("werzistiope");
    }
    m_cServer_werzistiope = p_ContextObject.GetServer("werzistiope");
    m_cPhName_werzistifrz = p_ContextObject.GetPhName("werzistifrz");
    if (m_cPhName_werzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_werzistifrz = m_cPhName_werzistifrz+" "+m_Ctx.GetWritePhName("werzistifrz");
    }
    m_cServer_werzistifrz = p_ContextObject.GetServer("werzistifrz");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_weneficope = p_ContextObject.GetPhName("weneficope");
    if (m_cPhName_weneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_weneficope = m_cPhName_weneficope+" "+m_Ctx.GetWritePhName("weneficope");
    }
    m_cServer_weneficope = p_ContextObject.GetServer("weneficope");
    m_cPhName_weneficfrz = p_ContextObject.GetPhName("weneficfrz");
    if (m_cPhName_weneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_weneficfrz = m_cPhName_weneficfrz+" "+m_Ctx.GetWritePhName("weneficfrz");
    }
    m_cServer_weneficfrz = p_ContextObject.GetServer("weneficfrz");
    m_cPhName_wapopebo = p_ContextObject.GetPhName("wapopebo");
    if (m_cPhName_wapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wapopebo = m_cPhName_wapopebo+" "+m_Ctx.GetWritePhName("wapopebo");
    }
    m_cServer_wapopebo = p_ContextObject.GetServer("wapopebo");
    m_cPhName_terzistiope = p_ContextObject.GetPhName("terzistiope");
    if (m_cPhName_terzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistiope = m_cPhName_terzistiope+" "+m_Ctx.GetWritePhName("terzistiope");
    }
    m_cServer_terzistiope = p_ContextObject.GetServer("terzistiope");
    m_cPhName_terzistifrz = p_ContextObject.GetPhName("terzistifrz");
    if (m_cPhName_terzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistifrz = m_cPhName_terzistifrz+" "+m_Ctx.GetWritePhName("terzistifrz");
    }
    m_cServer_terzistifrz = p_ContextObject.GetServer("terzistifrz");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    if (m_cPhName_sogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopefbo = m_cPhName_sogopefbo+" "+m_Ctx.GetWritePhName("sogopefbo");
    }
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_personbo_dip = p_ContextObject.GetPhName("personbo_dip");
    if (m_cPhName_personbo_dip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_dip = m_cPhName_personbo_dip+" "+m_Ctx.GetWritePhName("personbo_dip");
    }
    m_cServer_personbo_dip = p_ContextObject.GetServer("personbo_dip");
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_kperazbo = p_ContextObject.GetPhName("kperazbo");
    if (m_cPhName_kperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kperazbo = m_cPhName_kperazbo+" "+m_Ctx.GetWritePhName("kperazbo");
    }
    m_cServer_kperazbo = p_ContextObject.GetServer("kperazbo");
    m_cPhName_jperazbo = p_ContextObject.GetPhName("jperazbo");
    if (m_cPhName_jperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jperazbo = m_cPhName_jperazbo+" "+m_Ctx.GetWritePhName("jperazbo");
    }
    m_cServer_jperazbo = p_ContextObject.GetServer("jperazbo");
    m_cPhName_jntestit = p_ContextObject.GetPhName("jntestit");
    if (m_cPhName_jntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestit = m_cPhName_jntestit+" "+m_Ctx.GetWritePhName("jntestit");
    }
    m_cServer_jntestit = p_ContextObject.GetServer("jntestit");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_japotit = p_ContextObject.GetPhName("japotit");
    if (m_cPhName_japotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japotit = m_cPhName_japotit+" "+m_Ctx.GetWritePhName("japotit");
    }
    m_cServer_japotit = p_ContextObject.GetServer("japotit");
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    if (m_cPhName_japopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japopebo = m_cPhName_japopebo+" "+m_Ctx.GetWritePhName("japopebo");
    }
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_beneficope = p_ContextObject.GetPhName("beneficope");
    if (m_cPhName_beneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficope = m_cPhName_beneficope+" "+m_Ctx.GetWritePhName("beneficope");
    }
    m_cServer_beneficope = p_ContextObject.GetServer("beneficope");
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    if (m_cPhName_beneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficfrz = m_cPhName_beneficfrz+" "+m_Ctx.GetWritePhName("beneficfrz");
    }
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_woginfo = p_ContextObject.GetPhName("woginfo");
    if (m_cPhName_woginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_woginfo = m_cPhName_woginfo+" "+m_Ctx.GetWritePhName("woginfo");
    }
    m_cServer_woginfo = p_ContextObject.GetServer("woginfo");
    m_cPhName_fiduciabo = p_ContextObject.GetPhName("fiduciabo");
    if (m_cPhName_fiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fiduciabo = m_cPhName_fiduciabo+" "+m_Ctx.GetWritePhName("fiduciabo");
    }
    m_cServer_fiduciabo = p_ContextObject.GetServer("fiduciabo");
    m_cPhName_soginfo = p_ContextObject.GetPhName("soginfo");
    if (m_cPhName_soginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_soginfo = m_cPhName_soginfo+" "+m_Ctx.GetWritePhName("soginfo");
    }
    m_cServer_soginfo = p_ContextObject.GetServer("soginfo");
    m_cPhName_garantbo = p_ContextObject.GetPhName("garantbo");
    if (m_cPhName_garantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_garantbo = m_cPhName_garantbo+" "+m_Ctx.GetWritePhName("garantbo");
    }
    m_cServer_garantbo = p_ContextObject.GetServer("garantbo");
    m_cPhName_xoginfo = p_ContextObject.GetPhName("xoginfo");
    if (m_cPhName_xoginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xoginfo = m_cPhName_xoginfo+" "+m_Ctx.GetWritePhName("xoginfo");
    }
    m_cServer_xoginfo = p_ContextObject.GetServer("xoginfo");
    m_cPhName_xiduciabo = p_ContextObject.GetPhName("xiduciabo");
    if (m_cPhName_xiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xiduciabo = m_cPhName_xiduciabo+" "+m_Ctx.GetWritePhName("xiduciabo");
    }
    m_cServer_xiduciabo = p_ContextObject.GetServer("xiduciabo");
    m_cPhName_xarantbo = p_ContextObject.GetPhName("xarantbo");
    if (m_cPhName_xarantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xarantbo = m_cPhName_xarantbo+" "+m_Ctx.GetWritePhName("xarantbo");
    }
    m_cServer_xarantbo = p_ContextObject.GetServer("xarantbo");
    m_cPhName_welegabo = p_ContextObject.GetPhName("welegabo");
    if (m_cPhName_welegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_welegabo = m_cPhName_welegabo+" "+m_Ctx.GetWritePhName("welegabo");
    }
    m_cServer_welegabo = p_ContextObject.GetServer("welegabo");
    m_cPhName_warantbo = p_ContextObject.GetPhName("warantbo");
    if (m_cPhName_warantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_warantbo = m_cPhName_warantbo+" "+m_Ctx.GetWritePhName("warantbo");
    }
    m_cServer_warantbo = p_ContextObject.GetServer("warantbo");
    m_cPhName_jarantbo = p_ContextObject.GetPhName("jarantbo");
    if (m_cPhName_jarantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jarantbo = m_cPhName_jarantbo+" "+m_Ctx.GetWritePhName("jarantbo");
    }
    m_cServer_jarantbo = p_ContextObject.GetServer("jarantbo");
    m_cPhName_wersonbo_agg = p_ContextObject.GetPhName("wersonbo_agg");
    if (m_cPhName_wersonbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo_agg = m_cPhName_wersonbo_agg+" "+m_Ctx.GetWritePhName("wersonbo_agg");
    }
    m_cServer_wersonbo_agg = p_ContextObject.GetServer("wersonbo_agg");
    m_cPhName_wersonbo_dip = p_ContextObject.GetPhName("wersonbo_dip");
    if (m_cPhName_wersonbo_dip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo_dip = m_cPhName_wersonbo_dip+" "+m_Ctx.GetWritePhName("wersonbo_dip");
    }
    m_cServer_wersonbo_dip = p_ContextObject.GetServer("wersonbo_dip");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_delpersonbo";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("CONNES",p_cVarName)) {
      return w_CONNES;
    }
    if (CPLib.eqr("_presenza",p_cVarName)) {
      return _presenza;
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
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("CONNES",p_cVarName)) {
      w_CONNES = value;
      return;
    }
    if (CPLib.eqr("_presenza",p_cVarName)) {
      _presenza = value;
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
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_terzistiope=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_terzistifrz=null;
    CPResultSet Cursor_xperazbo=null;
    CPResultSet Cursor_xlientiope=null;
    CPResultSet Cursor_xeneficope=null;
    CPResultSet Cursor_xogopebo=null;
    CPResultSet Cursor_xerzistiope=null;
    CPResultSet Cursor_xraziobo=null;
    CPResultSet Cursor_xlientifrz=null;
    CPResultSet Cursor_xeneficfrz=null;
    CPResultSet Cursor_xogopefbo=null;
    CPResultSet Cursor_xerzistifrz=null;
    CPResultSet Cursor_soginfo=null;
    CPResultSet Cursor_fiduciabo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_garantbo=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_xoginfo=null;
    CPResultSet Cursor_xiduciabo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_xelegabo=null;
    CPResultSet Cursor_xarantbo=null;
    CPResultSet Cursor_xapopebo=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_rapotit=null;
    CPResultSet Cursor_xntestit=null;
    CPResultSet Cursor_xapotit=null;
    CPResultSet Cursor_jntestbo=null;
    CPResultSet Cursor_jelegabo=null;
    CPResultSet Cursor_jarantbo=null;
    CPResultSet Cursor_japopebo=null;
    CPResultSet Cursor_jntestit=null;
    CPResultSet Cursor_japotit=null;
    CPResultSet Cursor_jperazbo=null;
    CPResultSet Cursor_kperazbo=null;
    CPResultSet Cursor_opextrbo=null;
    CPResultSet Cursor_wperazbo=null;
    CPResultSet Cursor_wlientiope=null;
    CPResultSet Cursor_weneficope=null;
    CPResultSet Cursor_wogopebo=null;
    CPResultSet Cursor_werzistiope=null;
    CPResultSet Cursor_wraziobo=null;
    CPResultSet Cursor_wlientifrz=null;
    CPResultSet Cursor_weneficfrz=null;
    CPResultSet Cursor_wogopefbo=null;
    CPResultSet Cursor_werzistifrz=null;
    CPResultSet Cursor_woginfo=null;
    CPResultSet Cursor_widuciabo=null;
    CPResultSet Cursor_wntestbo=null;
    CPResultSet Cursor_welegabo=null;
    CPResultSet Cursor_warantbo=null;
    CPResultSet Cursor_wapopebo=null;
    try {
      /* w_CONNES Char(16) */
      /* conta Numeric(10, 0) */
      /* _presenza Memo */
      /* Dichiarazione variabili globali */
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from operazbo
      m_cServer = m_Ctx.GetServer("operazbo");
      m_cPhName = m_Ctx.GetPhName("operazbo");
      if (Cursor_operazbo!=null)
        Cursor_operazbo.Close();
      Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_operazbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_operazbo.Next();
      }
      m_cConnectivityError = Cursor_operazbo.ErrorMessage();
      Cursor_operazbo.Close();
      // * --- End Select
      // * --- Select from clientiope
      m_cServer = m_Ctx.GetServer("clientiope");
      m_cPhName = m_Ctx.GetPhName("clientiope");
      if (Cursor_clientiope!=null)
        Cursor_clientiope.Close();
      Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_clientiope.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
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
      Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_beneficope.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_beneficope.Next();
      }
      m_cConnectivityError = Cursor_beneficope.ErrorMessage();
      Cursor_beneficope.Close();
      // * --- End Select
      // * --- Select from sogopebo
      m_cServer = m_Ctx.GetServer("sogopebo");
      m_cPhName = m_Ctx.GetPhName("sogopebo");
      if (Cursor_sogopebo!=null)
        Cursor_sogopebo.Close();
      Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_sogopebo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_sogopebo.Next();
      }
      m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
      Cursor_sogopebo.Close();
      // * --- End Select
      // * --- Select from terzistiope
      m_cServer = m_Ctx.GetServer("terzistiope");
      m_cPhName = m_Ctx.GetPhName("terzistiope");
      if (Cursor_terzistiope!=null)
        Cursor_terzistiope.Close();
      Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_terzistiope.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_terzistiope.Next();
      }
      m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
      Cursor_terzistiope.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Operazioni AUI, " */
        _presenza = _presenza+"Operazioni AUI, ";
      } // End If
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from fraziobo
      m_cServer = m_Ctx.GetServer("fraziobo");
      m_cPhName = m_Ctx.GetPhName("fraziobo");
      if (Cursor_fraziobo!=null)
        Cursor_fraziobo.Close();
      Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_fraziobo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_fraziobo.Next();
      }
      m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
      Cursor_fraziobo.Close();
      // * --- End Select
      // * --- Select from clientifrz
      m_cServer = m_Ctx.GetServer("clientifrz");
      m_cPhName = m_Ctx.GetPhName("clientifrz");
      if (Cursor_clientifrz!=null)
        Cursor_clientifrz.Close();
      Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_clientifrz.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
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
      Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_beneficfrz.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_beneficfrz.Next();
      }
      m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
      Cursor_beneficfrz.Close();
      // * --- End Select
      // * --- Select from sogopefbo
      m_cServer = m_Ctx.GetServer("sogopefbo");
      m_cPhName = m_Ctx.GetPhName("sogopefbo");
      if (Cursor_sogopefbo!=null)
        Cursor_sogopefbo.Close();
      Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_sogopefbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_sogopefbo.Next();
      }
      m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
      Cursor_sogopefbo.Close();
      // * --- End Select
      // * --- Select from terzistifrz
      m_cServer = m_Ctx.GetServer("terzistifrz");
      m_cPhName = m_Ctx.GetPhName("terzistifrz");
      if (Cursor_terzistifrz!=null)
        Cursor_terzistifrz.Close();
      Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_terzistifrz.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_terzistifrz.Next();
      }
      m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
      Cursor_terzistifrz.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Frazionate AUI, " */
        _presenza = _presenza+"Frazionate AUI, ";
      } // End If
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from xperazbo
      m_cServer = m_Ctx.GetServer("xperazbo");
      m_cPhName = m_Ctx.GetPhName("xperazbo");
      if (Cursor_xperazbo!=null)
        Cursor_xperazbo.Close();
      Cursor_xperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xperazbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_xperazbo.Next();
      }
      m_cConnectivityError = Cursor_xperazbo.ErrorMessage();
      Cursor_xperazbo.Close();
      // * --- End Select
      // * --- Select from xlientiope
      m_cServer = m_Ctx.GetServer("xlientiope");
      m_cPhName = m_Ctx.GetPhName("xlientiope");
      if (Cursor_xlientiope!=null)
        Cursor_xlientiope.Close();
      Cursor_xlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xlientiope.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
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
      Cursor_xeneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xeneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xeneficope.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_xeneficope.Next();
      }
      m_cConnectivityError = Cursor_xeneficope.ErrorMessage();
      Cursor_xeneficope.Close();
      // * --- End Select
      // * --- Select from xogopebo
      m_cServer = m_Ctx.GetServer("xogopebo");
      m_cPhName = m_Ctx.GetPhName("xogopebo");
      if (Cursor_xogopebo!=null)
        Cursor_xogopebo.Close();
      Cursor_xogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xogopebo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_xogopebo.Next();
      }
      m_cConnectivityError = Cursor_xogopebo.ErrorMessage();
      Cursor_xogopebo.Close();
      // * --- End Select
      // * --- Select from xerzistiope
      m_cServer = m_Ctx.GetServer("xerzistiope");
      m_cPhName = m_Ctx.GetPhName("xerzistiope");
      if (Cursor_xerzistiope!=null)
        Cursor_xerzistiope.Close();
      Cursor_xerzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xerzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xerzistiope.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_xerzistiope.Next();
      }
      m_cConnectivityError = Cursor_xerzistiope.ErrorMessage();
      Cursor_xerzistiope.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Operazioni Provvisorie, " */
        _presenza = _presenza+"Operazioni Provvisorie, ";
      } // End If
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from xraziobo
      m_cServer = m_Ctx.GetServer("xraziobo");
      m_cPhName = m_Ctx.GetPhName("xraziobo");
      if (Cursor_xraziobo!=null)
        Cursor_xraziobo.Close();
      Cursor_xraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xraziobo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_xraziobo.Next();
      }
      m_cConnectivityError = Cursor_xraziobo.ErrorMessage();
      Cursor_xraziobo.Close();
      // * --- End Select
      // * --- Select from xlientifrz
      m_cServer = m_Ctx.GetServer("xlientifrz");
      m_cPhName = m_Ctx.GetPhName("xlientifrz");
      if (Cursor_xlientifrz!=null)
        Cursor_xlientifrz.Close();
      Cursor_xlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xlientifrz.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
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
      Cursor_xeneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xeneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xeneficfrz.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_xeneficfrz.Next();
      }
      m_cConnectivityError = Cursor_xeneficfrz.ErrorMessage();
      Cursor_xeneficfrz.Close();
      // * --- End Select
      // * --- Select from xogopefbo
      m_cServer = m_Ctx.GetServer("xogopefbo");
      m_cPhName = m_Ctx.GetPhName("xogopefbo");
      if (Cursor_xogopefbo!=null)
        Cursor_xogopefbo.Close();
      Cursor_xogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xogopefbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_xogopefbo.Next();
      }
      m_cConnectivityError = Cursor_xogopefbo.ErrorMessage();
      Cursor_xogopefbo.Close();
      // * --- End Select
      // * --- Select from xerzistifrz
      m_cServer = m_Ctx.GetServer("xerzistifrz");
      m_cPhName = m_Ctx.GetPhName("xerzistifrz");
      if (Cursor_xerzistifrz!=null)
        Cursor_xerzistifrz.Close();
      Cursor_xerzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xerzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xerzistifrz.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_xerzistifrz.Next();
      }
      m_cConnectivityError = Cursor_xerzistifrz.ErrorMessage();
      Cursor_xerzistifrz.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Frazionate Provvisorie, " */
        _presenza = _presenza+"Frazionate Provvisorie, ";
      } // End If
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from soginfo
      m_cServer = m_Ctx.GetServer("soginfo");
      m_cPhName = m_Ctx.GetPhName("soginfo");
      if (Cursor_soginfo!=null)
        Cursor_soginfo.Close();
      Cursor_soginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("soginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_soginfo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_soginfo.Next();
      }
      m_cConnectivityError = Cursor_soginfo.ErrorMessage();
      Cursor_soginfo.Close();
      // * --- End Select
      // * --- Select from fiduciabo
      m_cServer = m_Ctx.GetServer("fiduciabo");
      m_cPhName = m_Ctx.GetPhName("fiduciabo");
      if (Cursor_fiduciabo!=null)
        Cursor_fiduciabo.Close();
      Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_fiduciabo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_fiduciabo.Next();
      }
      m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
      Cursor_fiduciabo.Close();
      // * --- End Select
      // * --- Select from intestbo
      m_cServer = m_Ctx.GetServer("intestbo");
      m_cPhName = m_Ctx.GetPhName("intestbo");
      if (Cursor_intestbo!=null)
        Cursor_intestbo.Close();
      Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intestbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
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
      Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_delegabo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_delegabo.Next();
      }
      m_cConnectivityError = Cursor_delegabo.ErrorMessage();
      Cursor_delegabo.Close();
      // * --- End Select
      // * --- Select from garantbo
      m_cServer = m_Ctx.GetServer("garantbo");
      m_cPhName = m_Ctx.GetPhName("garantbo");
      if (Cursor_garantbo!=null)
        Cursor_garantbo.Close();
      Cursor_garantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("garantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_garantbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_garantbo.Next();
      }
      m_cConnectivityError = Cursor_garantbo.ErrorMessage();
      Cursor_garantbo.Close();
      // * --- End Select
      // * --- Select from rapopebo
      m_cServer = m_Ctx.GetServer("rapopebo");
      m_cPhName = m_Ctx.GetPhName("rapopebo");
      if (Cursor_rapopebo!=null)
        Cursor_rapopebo.Close();
      Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_rapopebo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_rapopebo.Next();
      }
      m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
      Cursor_rapopebo.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Rapporti Continuativi AUI, " */
        _presenza = _presenza+"Rapporti Continuativi AUI, ";
      } // End If
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from xoginfo
      m_cServer = m_Ctx.GetServer("xoginfo");
      m_cPhName = m_Ctx.GetPhName("xoginfo");
      if (Cursor_xoginfo!=null)
        Cursor_xoginfo.Close();
      Cursor_xoginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xoginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xoginfo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
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
      Cursor_xiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xiduciabo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_xiduciabo.Next();
      }
      m_cConnectivityError = Cursor_xiduciabo.ErrorMessage();
      Cursor_xiduciabo.Close();
      // * --- End Select
      // * --- Select from xntestbo
      m_cServer = m_Ctx.GetServer("xntestbo");
      m_cPhName = m_Ctx.GetPhName("xntestbo");
      if (Cursor_xntestbo!=null)
        Cursor_xntestbo.Close();
      Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xntestbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_xntestbo.Next();
      }
      m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
      Cursor_xntestbo.Close();
      // * --- End Select
      // * --- Select from xelegabo
      m_cServer = m_Ctx.GetServer("xelegabo");
      m_cPhName = m_Ctx.GetPhName("xelegabo");
      if (Cursor_xelegabo!=null)
        Cursor_xelegabo.Close();
      Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xelegabo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_xelegabo.Next();
      }
      m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
      Cursor_xelegabo.Close();
      // * --- End Select
      // * --- Select from xarantbo
      m_cServer = m_Ctx.GetServer("xarantbo");
      m_cPhName = m_Ctx.GetPhName("xarantbo");
      if (Cursor_xarantbo!=null)
        Cursor_xarantbo.Close();
      Cursor_xarantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xarantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xarantbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_xarantbo.Next();
      }
      m_cConnectivityError = Cursor_xarantbo.ErrorMessage();
      Cursor_xarantbo.Close();
      // * --- End Select
      // * --- Select from xapopebo
      m_cServer = m_Ctx.GetServer("xapopebo");
      m_cPhName = m_Ctx.GetPhName("xapopebo");
      if (Cursor_xapopebo!=null)
        Cursor_xapopebo.Close();
      Cursor_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xapopebo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_xapopebo.Next();
      }
      m_cConnectivityError = Cursor_xapopebo.ErrorMessage();
      Cursor_xapopebo.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Rapporti Continuativi Provvisori, " */
        _presenza = _presenza+"Rapporti Continuativi Provvisori, ";
      } // End If
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from intestit
      m_cServer = m_Ctx.GetServer("intestit");
      m_cPhName = m_Ctx.GetPhName("intestit");
      if (Cursor_intestit!=null)
        Cursor_intestit.Close();
      Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODCLI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intestit.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_intestit.Next();
      }
      m_cConnectivityError = Cursor_intestit.ErrorMessage();
      Cursor_intestit.Close();
      // * --- End Select
      // * --- Select from rapotit
      m_cServer = m_Ctx.GetServer("rapotit");
      m_cPhName = m_Ctx.GetPhName("rapotit");
      if (Cursor_rapotit!=null)
        Cursor_rapotit.Close();
      Cursor_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("rapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_rapotit.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_rapotit.Next();
      }
      m_cConnectivityError = Cursor_rapotit.ErrorMessage();
      Cursor_rapotit.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Titolari Effettivi AUI, " */
        _presenza = _presenza+"Titolari Effettivi AUI, ";
      } // End If
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from xntestit
      m_cServer = m_Ctx.GetServer("xntestit");
      m_cPhName = m_Ctx.GetPhName("xntestit");
      if (Cursor_xntestit!=null)
        Cursor_xntestit.Close();
      Cursor_xntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODCLI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xntestit.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_xntestit.Next();
      }
      m_cConnectivityError = Cursor_xntestit.ErrorMessage();
      Cursor_xntestit.Close();
      // * --- End Select
      // * --- Select from xapotit
      m_cServer = m_Ctx.GetServer("xapotit");
      m_cPhName = m_Ctx.GetPhName("xapotit");
      if (Cursor_xapotit!=null)
        Cursor_xapotit.Close();
      Cursor_xapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xapotit.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_xapotit.Next();
      }
      m_cConnectivityError = Cursor_xapotit.ErrorMessage();
      Cursor_xapotit.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Titolari Effettivi Provvisori, " */
        _presenza = _presenza+"Titolari Effettivi Provvisori, ";
      } // End If
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from jntestbo
      m_cServer = m_Ctx.GetServer("jntestbo");
      m_cPhName = m_Ctx.GetPhName("jntestbo");
      if (Cursor_jntestbo!=null)
        Cursor_jntestbo.Close();
      Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_jntestbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_jntestbo.Next();
      }
      m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
      Cursor_jntestbo.Close();
      // * --- End Select
      // * --- Select from jelegabo
      m_cServer = m_Ctx.GetServer("jelegabo");
      m_cPhName = m_Ctx.GetPhName("jelegabo");
      if (Cursor_jelegabo!=null)
        Cursor_jelegabo.Close();
      Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_jelegabo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_jelegabo.Next();
      }
      m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
      Cursor_jelegabo.Close();
      // * --- End Select
      // * --- Select from jarantbo
      m_cServer = m_Ctx.GetServer("jarantbo");
      m_cPhName = m_Ctx.GetPhName("jarantbo");
      if (Cursor_jarantbo!=null)
        Cursor_jarantbo.Close();
      Cursor_jarantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jarantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_jarantbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_jarantbo.Next();
      }
      m_cConnectivityError = Cursor_jarantbo.ErrorMessage();
      Cursor_jarantbo.Close();
      // * --- End Select
      // * --- Select from japopebo
      m_cServer = m_Ctx.GetServer("japopebo");
      m_cPhName = m_Ctx.GetPhName("japopebo");
      if (Cursor_japopebo!=null)
        Cursor_japopebo.Close();
      Cursor_japopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("japopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_japopebo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_japopebo.Next();
      }
      m_cConnectivityError = Cursor_japopebo.ErrorMessage();
      Cursor_japopebo.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Rapporti Continuativi AGE, " */
        _presenza = _presenza+"Rapporti Continuativi AGE, ";
      } // End If
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from jntestit
      m_cServer = m_Ctx.GetServer("jntestit");
      m_cPhName = m_Ctx.GetPhName("jntestit");
      if (Cursor_jntestit!=null)
        Cursor_jntestit.Close();
      Cursor_jntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODCLI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_jntestit.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_jntestit.Next();
      }
      m_cConnectivityError = Cursor_jntestit.ErrorMessage();
      Cursor_jntestit.Close();
      // * --- End Select
      // * --- Select from japotit
      m_cServer = m_Ctx.GetServer("japotit");
      m_cPhName = m_Ctx.GetPhName("japotit");
      if (Cursor_japotit!=null)
        Cursor_japotit.Close();
      Cursor_japotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("japotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_japotit.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_japotit.Next();
      }
      m_cConnectivityError = Cursor_japotit.ErrorMessage();
      Cursor_japotit.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Titolari Effettivi AUI, " */
        _presenza = _presenza+"Titolari Effettivi AUI, ";
      } // End If
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from jperazbo
      m_cServer = m_Ctx.GetServer("jperazbo");
      m_cPhName = m_Ctx.GetPhName("jperazbo");
      if (Cursor_jperazbo!=null)
        Cursor_jperazbo.Close();
      Cursor_jperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_jperazbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_jperazbo.Next();
      }
      m_cConnectivityError = Cursor_jperazbo.ErrorMessage();
      Cursor_jperazbo.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Operazioni AGE, " */
        _presenza = _presenza+"Operazioni AGE, ";
      } // End If
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from kperazbo
      m_cServer = m_Ctx.GetServer("kperazbo");
      m_cPhName = m_Ctx.GetPhName("kperazbo");
      if (Cursor_kperazbo!=null)
        Cursor_kperazbo.Close();
      Cursor_kperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("kperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_kperazbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_kperazbo.Next();
      }
      m_cConnectivityError = Cursor_kperazbo.ErrorMessage();
      Cursor_kperazbo.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Operazioni Società Quotate, " */
        _presenza = _presenza+"Operazioni Società Quotate, ";
      } // End If
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from opextrbo
      m_cServer = m_Ctx.GetServer("opextrbo");
      m_cPhName = m_Ctx.GetPhName("opextrbo");
      if (Cursor_opextrbo!=null)
        Cursor_opextrbo.Close();
      Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select ANNO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_opextrbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_opextrbo.Next();
      }
      m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
      Cursor_opextrbo.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Operazioni Extraconto, " */
        _presenza = _presenza+"Operazioni Extraconto, ";
      } // End If
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from wperazbo
      m_cServer = m_Ctx.GetServer("wperazbo");
      m_cPhName = m_Ctx.GetPhName("wperazbo");
      if (Cursor_wperazbo!=null)
        Cursor_wperazbo.Close();
      Cursor_wperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_wperazbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_wperazbo.Next();
      }
      m_cConnectivityError = Cursor_wperazbo.ErrorMessage();
      Cursor_wperazbo.Close();
      // * --- End Select
      // * --- Select from wlientiope
      m_cServer = m_Ctx.GetServer("wlientiope");
      m_cPhName = m_Ctx.GetPhName("wlientiope");
      if (Cursor_wlientiope!=null)
        Cursor_wlientiope.Close();
      Cursor_wlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_wlientiope.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_wlientiope.Next();
      }
      m_cConnectivityError = Cursor_wlientiope.ErrorMessage();
      Cursor_wlientiope.Close();
      // * --- End Select
      // * --- Select from weneficope
      m_cServer = m_Ctx.GetServer("weneficope");
      m_cPhName = m_Ctx.GetPhName("weneficope");
      if (Cursor_weneficope!=null)
        Cursor_weneficope.Close();
      Cursor_weneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("weneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_weneficope.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_weneficope.Next();
      }
      m_cConnectivityError = Cursor_weneficope.ErrorMessage();
      Cursor_weneficope.Close();
      // * --- End Select
      // * --- Select from wogopebo
      m_cServer = m_Ctx.GetServer("wogopebo");
      m_cPhName = m_Ctx.GetPhName("wogopebo");
      if (Cursor_wogopebo!=null)
        Cursor_wogopebo.Close();
      Cursor_wogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_wogopebo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_wogopebo.Next();
      }
      m_cConnectivityError = Cursor_wogopebo.ErrorMessage();
      Cursor_wogopebo.Close();
      // * --- End Select
      // * --- Select from werzistiope
      m_cServer = m_Ctx.GetServer("werzistiope");
      m_cPhName = m_Ctx.GetPhName("werzistiope");
      if (Cursor_werzistiope!=null)
        Cursor_werzistiope.Close();
      Cursor_werzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("werzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_werzistiope.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_werzistiope.Next();
      }
      m_cConnectivityError = Cursor_werzistiope.ErrorMessage();
      Cursor_werzistiope.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Operazioni Storico, " */
        _presenza = _presenza+"Operazioni Storico, ";
      } // End If
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from wraziobo
      m_cServer = m_Ctx.GetServer("wraziobo");
      m_cPhName = m_Ctx.GetPhName("wraziobo");
      if (Cursor_wraziobo!=null)
        Cursor_wraziobo.Close();
      Cursor_wraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_wraziobo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_wraziobo.Next();
      }
      m_cConnectivityError = Cursor_wraziobo.ErrorMessage();
      Cursor_wraziobo.Close();
      // * --- End Select
      // * --- Select from wlientifrz
      m_cServer = m_Ctx.GetServer("wlientifrz");
      m_cPhName = m_Ctx.GetPhName("wlientifrz");
      if (Cursor_wlientifrz!=null)
        Cursor_wlientifrz.Close();
      Cursor_wlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_wlientifrz.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_wlientifrz.Next();
      }
      m_cConnectivityError = Cursor_wlientifrz.ErrorMessage();
      Cursor_wlientifrz.Close();
      // * --- End Select
      // * --- Select from weneficfrz
      m_cServer = m_Ctx.GetServer("weneficfrz");
      m_cPhName = m_Ctx.GetPhName("weneficfrz");
      if (Cursor_weneficfrz!=null)
        Cursor_weneficfrz.Close();
      Cursor_weneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("weneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_weneficfrz.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_weneficfrz.Next();
      }
      m_cConnectivityError = Cursor_weneficfrz.ErrorMessage();
      Cursor_weneficfrz.Close();
      // * --- End Select
      // * --- Select from wogopefbo
      m_cServer = m_Ctx.GetServer("wogopefbo");
      m_cPhName = m_Ctx.GetPhName("wogopefbo");
      if (Cursor_wogopefbo!=null)
        Cursor_wogopefbo.Close();
      Cursor_wogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_wogopefbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_wogopefbo.Next();
      }
      m_cConnectivityError = Cursor_wogopefbo.ErrorMessage();
      Cursor_wogopefbo.Close();
      // * --- End Select
      // * --- Select from werzistifrz
      m_cServer = m_Ctx.GetServer("werzistifrz");
      m_cPhName = m_Ctx.GetPhName("werzistifrz");
      if (Cursor_werzistifrz!=null)
        Cursor_werzistifrz.Close();
      Cursor_werzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("werzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_werzistifrz.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_werzistifrz.Next();
      }
      m_cConnectivityError = Cursor_werzistifrz.ErrorMessage();
      Cursor_werzistifrz.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Frazionate Storico, " */
        _presenza = _presenza+"Frazionate Storico, ";
      } // End If
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from woginfo
      m_cServer = m_Ctx.GetServer("woginfo");
      m_cPhName = m_Ctx.GetPhName("woginfo");
      if (Cursor_woginfo!=null)
        Cursor_woginfo.Close();
      Cursor_woginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("woginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_woginfo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_woginfo.Next();
      }
      m_cConnectivityError = Cursor_woginfo.ErrorMessage();
      Cursor_woginfo.Close();
      // * --- End Select
      // * --- Select from widuciabo
      m_cServer = m_Ctx.GetServer("widuciabo");
      m_cPhName = m_Ctx.GetPhName("widuciabo");
      if (Cursor_widuciabo!=null)
        Cursor_widuciabo.Close();
      Cursor_widuciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("widuciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_widuciabo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_widuciabo.Next();
      }
      m_cConnectivityError = Cursor_widuciabo.ErrorMessage();
      Cursor_widuciabo.Close();
      // * --- End Select
      // * --- Select from wntestbo
      m_cServer = m_Ctx.GetServer("wntestbo");
      m_cPhName = m_Ctx.GetPhName("wntestbo");
      if (Cursor_wntestbo!=null)
        Cursor_wntestbo.Close();
      Cursor_wntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_wntestbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_wntestbo.Next();
      }
      m_cConnectivityError = Cursor_wntestbo.ErrorMessage();
      Cursor_wntestbo.Close();
      // * --- End Select
      // * --- Select from welegabo
      m_cServer = m_Ctx.GetServer("welegabo");
      m_cPhName = m_Ctx.GetPhName("welegabo");
      if (Cursor_welegabo!=null)
        Cursor_welegabo.Close();
      Cursor_welegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("welegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_welegabo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_welegabo.Next();
      }
      m_cConnectivityError = Cursor_welegabo.ErrorMessage();
      Cursor_welegabo.Close();
      // * --- End Select
      // * --- Select from warantbo
      m_cServer = m_Ctx.GetServer("warantbo");
      m_cPhName = m_Ctx.GetPhName("warantbo");
      if (Cursor_warantbo!=null)
        Cursor_warantbo.Close();
      Cursor_warantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("warantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_warantbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_warantbo.Next();
      }
      m_cConnectivityError = Cursor_warantbo.ErrorMessage();
      Cursor_warantbo.Close();
      // * --- End Select
      // * --- Select from wapopebo
      m_cServer = m_Ctx.GetServer("wapopebo");
      m_cPhName = m_Ctx.GetPhName("wapopebo");
      if (Cursor_wapopebo!=null)
        Cursor_wapopebo.Close();
      Cursor_wapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_wapopebo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_wapopebo.Next();
      }
      m_cConnectivityError = Cursor_wapopebo.ErrorMessage();
      Cursor_wapopebo.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* _presenza := _presenza + "Rapporti Continuativi Storico, " */
        _presenza = _presenza+"Rapporti Continuativi Storico, ";
      } // End If
      /* If Empty(LRTrim(_presenza)) */
      if (CPLib.Empty(CPLib.LRTrim(_presenza))) {
        // * --- Delete from aerighe
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_delpersonbo",32,"000000C7")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESINT = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_CONNES,"?",0,0,m_cServer),m_cServer,w_CONNES)+"";
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
        // * --- Delete from personbo_agg
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo_agg");
        m_cPhName = m_Ctx.GetPhName("personbo_agg");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_delpersonbo",32,"000000C8")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer),m_cServer,w_CONNES)+"";
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
        // * --- Delete from personbo_dip
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo_dip");
        m_cPhName = m_Ctx.GetPhName("personbo_dip");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_dip",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_delpersonbo",32,"000000C9")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer),m_cServer,w_CONNES)+"";
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
        // * --- Delete from personbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_delpersonbo",32,"000000CA")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer),m_cServer,w_CONNES)+"";
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
        // * --- Delete from wersonbo_agg
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("wersonbo_agg");
        m_cPhName = m_Ctx.GetPhName("wersonbo_agg");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo_agg",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_delpersonbo",32,"000000CB")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer),m_cServer,w_CONNES)+"";
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
        // * --- Delete from wersonbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_delpersonbo",32,"000000CC")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer),m_cServer,w_CONNES)+"";
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
        /* _presenza := Left(_presenza,Len(LRTrim(_presenza)) -2) */
        _presenza = CPLib.Left(_presenza,CPLib.Len(CPLib.LRTrim(_presenza))-2);
        // Transaction Error
        m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Impossibile Cancellare il soggetto. È presente in: "+CPLib.LRTrim(_presenza)+""));
        throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Impossibile Cancellare il soggetto. È presente in: "+CPLib.LRTrim(_presenza)+""));
      } // End If
    } finally {
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
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
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
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
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
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
        if (Cursor_sogopefbo!=null)
          Cursor_sogopefbo.Close();
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
      try {
        if (Cursor_xperazbo!=null)
          Cursor_xperazbo.Close();
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
        if (Cursor_xogopebo!=null)
          Cursor_xogopebo.Close();
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
        if (Cursor_xraziobo!=null)
          Cursor_xraziobo.Close();
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
        if (Cursor_xogopefbo!=null)
          Cursor_xogopefbo.Close();
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
        if (Cursor_soginfo!=null)
          Cursor_soginfo.Close();
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
        if (Cursor_garantbo!=null)
          Cursor_garantbo.Close();
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
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
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
        if (Cursor_xarantbo!=null)
          Cursor_xarantbo.Close();
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
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_rapotit!=null)
          Cursor_rapotit.Close();
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
        if (Cursor_xapotit!=null)
          Cursor_xapotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jelegabo!=null)
          Cursor_jelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jarantbo!=null)
          Cursor_jarantbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_japopebo!=null)
          Cursor_japopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestit!=null)
          Cursor_jntestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_japotit!=null)
          Cursor_japotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jperazbo!=null)
          Cursor_jperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_kperazbo!=null)
          Cursor_kperazbo.Close();
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
        if (Cursor_wperazbo!=null)
          Cursor_wperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wlientiope!=null)
          Cursor_wlientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_weneficope!=null)
          Cursor_weneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wogopebo!=null)
          Cursor_wogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_werzistiope!=null)
          Cursor_werzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wraziobo!=null)
          Cursor_wraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wlientifrz!=null)
          Cursor_wlientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_weneficfrz!=null)
          Cursor_weneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wogopefbo!=null)
          Cursor_wogopefbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_werzistifrz!=null)
          Cursor_werzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_woginfo!=null)
          Cursor_woginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_widuciabo!=null)
          Cursor_widuciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wntestbo!=null)
          Cursor_wntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_welegabo!=null)
          Cursor_welegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_warantbo!=null)
          Cursor_warantbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wapopebo!=null)
          Cursor_wapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_CONNES) {
    w_CONNES = p_w_CONNES;
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
  public Forward Run(String p_w_CONNES) {
    w_CONNES = p_w_CONNES;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_delpersonboR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_delpersonboR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_CONNES = CPLib.Space(16);
    conta = 0;
    _presenza = "";
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"w_CONNES"};
}
