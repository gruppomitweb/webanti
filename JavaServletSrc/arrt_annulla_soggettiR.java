// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_annulla_soggettiR implements CallerWithObjs {
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
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
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
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_jperazbo;
  public String m_cServer_jperazbo;
  public String m_cPhName_kperazbo;
  public String m_cServer_kperazbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
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
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xntestit;
  public String m_cServer_xntestit;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
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
  public double _esiste;
  public String _presenza;
  public String w_CONNES;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _reccount;
  public double _cicli;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public String _oldmsg;
  public String gMsgProc;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_annulla_soggettiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_annulla_soggetti",m_Caller);
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
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
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
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_jperazbo = p_ContextObject.GetPhName("jperazbo");
    if (m_cPhName_jperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jperazbo = m_cPhName_jperazbo+" "+m_Ctx.GetWritePhName("jperazbo");
    }
    m_cServer_jperazbo = p_ContextObject.GetServer("jperazbo");
    m_cPhName_kperazbo = p_ContextObject.GetPhName("kperazbo");
    if (m_cPhName_kperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kperazbo = m_cPhName_kperazbo+" "+m_Ctx.GetWritePhName("kperazbo");
    }
    m_cServer_kperazbo = p_ContextObject.GetServer("kperazbo");
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
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
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
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_esiste",p_cVarName)) {
      return _esiste;
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
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_annulla_soggetti";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_presenza",p_cVarName)) {
      return _presenza;
    }
    if (CPLib.eqr("CONNES",p_cVarName)) {
      return w_CONNES;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
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
    if (CPLib.eqr("_esiste",p_cVarName)) {
      _esiste = value;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_presenza",p_cVarName)) {
      _presenza = value;
      return;
    }
    if (CPLib.eqr("CONNES",p_cVarName)) {
      w_CONNES = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
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
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_personbo=null;
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
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_xelegabo=null;
    CPResultSet Cursor_xapopebo=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_rapotit=null;
    CPResultSet Cursor_xntestit=null;
    CPResultSet Cursor_xapotit=null;
    CPResultSet Cursor_jntestbo=null;
    CPResultSet Cursor_jelegabo=null;
    CPResultSet Cursor_japopebo=null;
    CPResultSet Cursor_jperazbo=null;
    CPResultSet Cursor_kperazbo=null;
    CPResultSet Cursor_opextrbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _esiste Numeric(10, 0) */
      /* _presenza Memo */
      /* w_CONNES Char(16) // NDG Soggetto */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _reccount Numeric(0, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _oldmsg Char(100) */
      /* gMsgProc Char(120) // Messaggio */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000017;
      _h00000017 = new SPBridge.HMCaller();
      _h00000017.Set("m_cVQRList",m_cVQRList);
      _h00000017.Set("tbname","personbo");
      _h00000017.Set("fldname","PROGIMPORT");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000017,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _min := qbe_tab_mmc->min */
        _min = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("min"),0);
        /* _max := qbe_tab_mmc->max */
        _max = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("max"),0);
        /* _tot := qbe_tab_mmc->tot */
        _tot = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* If _tot > 0 */
      if (CPLib.gt(_tot,0)) {
        /* _mono := 0 */
        _mono = CPLib.Round(0,0);
        /* _oldmsg := '' */
        _oldmsg = "";
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
          /* _reccount := _tot */
          _reccount = CPLib.Round(_tot,0);
          /* _cicli := iif(Mod(_reccount,1000) <> 0,Int(_reccount/1000) + 1,Int(_reccount/1000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,1000),0)?CPLib.Int(_reccount/1000)+1:CPLib.Int(_reccount/1000)),0);
        } // End If
        /* _contacicli := 1 */
        _contacicli = CPLib.Round(1,0);
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000029status;
        nTry00000029status = m_Sql.GetTransactionStatus();
        String cTry00000029msg;
        cTry00000029msg = m_Sql.TransactionErrorMessage();
        try {
          /* While _contacicli <= _cicli */
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
            /* gMsgImp := 'Lettura soggetti in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio Import */
            gMsgImp = "Lettura soggetti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If Empty(_oldmsg) */
            if (CPLib.Empty(_oldmsg)) {
              /* gMsgProc := gMsgProc + 'Lettura soggetti in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) + NL // Messaggio */
              gMsgProc = gMsgProc+"Lettura soggetti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0))+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* gMsgProc := Strtran(gMsgProc,_oldmsg,LRTrim(gMsgImp)) // Messaggio */
              gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,CPLib.LRTrim(gMsgImp));
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
            /* _oldmsg := 'Lettura soggetti in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) */
            _oldmsg = "Lettura soggetti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
            /* If _top>=_min */
            if (CPLib.ge(_top,_min)) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PROGIMPORT >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PROGIMPORT <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* gMsgImp := 'Elaborazione soggetto con NDG: '+ w_CONNES // Messaggio Import */
                gMsgImp = "Elaborazione soggetto con NDG: "+w_CONNES;
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* w_CONNES := personbo->CONNES // NDG Soggetto */
                w_CONNES = Cursor_personbo.GetString("CONNES");
                /* _esiste := 0 */
                _esiste = CPLib.Round(0,0);
                // * --- Select from operazbo
                m_cServer = m_Ctx.GetServer("operazbo");
                m_cPhName = m_Ctx.GetPhName("operazbo");
                if (Cursor_operazbo!=null)
                  Cursor_operazbo.Close();
                Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_operazbo.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_terzistiope.Next();
                }
                m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
                Cursor_terzistiope.Close();
                // * --- End Select
                // * --- Select from fraziobo
                m_cServer = m_Ctx.GetServer("fraziobo");
                m_cPhName = m_Ctx.GetPhName("fraziobo");
                if (Cursor_fraziobo!=null)
                  Cursor_fraziobo.Close();
                Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_fraziobo.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_terzistifrz.Next();
                }
                m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
                Cursor_terzistifrz.Close();
                // * --- End Select
                // * --- Select from xperazbo
                m_cServer = m_Ctx.GetServer("xperazbo");
                m_cPhName = m_Ctx.GetPhName("xperazbo");
                if (Cursor_xperazbo!=null)
                  Cursor_xperazbo.Close();
                Cursor_xperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xperazbo.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_xerzistiope.Next();
                }
                m_cConnectivityError = Cursor_xerzistiope.ErrorMessage();
                Cursor_xerzistiope.Close();
                // * --- End Select
                // * --- Select from xraziobo
                m_cServer = m_Ctx.GetServer("xraziobo");
                m_cPhName = m_Ctx.GetPhName("xraziobo");
                if (Cursor_xraziobo!=null)
                  Cursor_xraziobo.Close();
                Cursor_xraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xraziobo.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_xerzistifrz.Next();
                }
                m_cConnectivityError = Cursor_xerzistifrz.ErrorMessage();
                Cursor_xerzistifrz.Close();
                // * --- End Select
                // * --- Select from intestbo
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                if (Cursor_intestbo!=null)
                  Cursor_intestbo.Close();
                Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_intestbo.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_delegabo.Next();
                }
                m_cConnectivityError = Cursor_delegabo.ErrorMessage();
                Cursor_delegabo.Close();
                // * --- End Select
                // * --- Select from rapopebo
                m_cServer = m_Ctx.GetServer("rapopebo");
                m_cPhName = m_Ctx.GetPhName("rapopebo");
                if (Cursor_rapopebo!=null)
                  Cursor_rapopebo.Close();
                Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_rapopebo.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_rapopebo.Next();
                }
                m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
                Cursor_rapopebo.Close();
                // * --- End Select
                // * --- Select from anarapbo
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                if (Cursor_anarapbo!=null)
                  Cursor_anarapbo.Close();
                Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select rapporto  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODICELR="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_anarapbo.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_anarapbo.Next();
                }
                m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
                Cursor_anarapbo.Close();
                // * --- End Select
                // * --- Select from xntestbo
                m_cServer = m_Ctx.GetServer("xntestbo");
                m_cPhName = m_Ctx.GetPhName("xntestbo");
                if (Cursor_xntestbo!=null)
                  Cursor_xntestbo.Close();
                Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xntestbo.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_xelegabo.Next();
                }
                m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
                Cursor_xelegabo.Close();
                // * --- End Select
                // * --- Select from xapopebo
                m_cServer = m_Ctx.GetServer("xapopebo");
                m_cPhName = m_Ctx.GetPhName("xapopebo");
                if (Cursor_xapopebo!=null)
                  Cursor_xapopebo.Close();
                Cursor_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xapopebo.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_xapopebo.Next();
                }
                m_cConnectivityError = Cursor_xapopebo.ErrorMessage();
                Cursor_xapopebo.Close();
                // * --- End Select
                // * --- Select from intestit
                m_cServer = m_Ctx.GetServer("intestit");
                m_cPhName = m_Ctx.GetPhName("intestit");
                if (Cursor_intestit!=null)
                  Cursor_intestit.Close();
                Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODCLI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_intestit.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_rapotit.Next();
                }
                m_cConnectivityError = Cursor_rapotit.ErrorMessage();
                Cursor_rapotit.Close();
                // * --- End Select
                // * --- Select from xntestit
                m_cServer = m_Ctx.GetServer("xntestit");
                m_cPhName = m_Ctx.GetPhName("xntestit");
                if (Cursor_xntestit!=null)
                  Cursor_xntestit.Close();
                Cursor_xntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODCLI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xntestit.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_xapotit.Next();
                }
                m_cConnectivityError = Cursor_xapotit.ErrorMessage();
                Cursor_xapotit.Close();
                // * --- End Select
                // * --- Select from jntestbo
                m_cServer = m_Ctx.GetServer("jntestbo");
                m_cPhName = m_Ctx.GetPhName("jntestbo");
                if (Cursor_jntestbo!=null)
                  Cursor_jntestbo.Close();
                Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_jntestbo.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
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
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_jelegabo.Next();
                }
                m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
                Cursor_jelegabo.Close();
                // * --- End Select
                // * --- Select from japopebo
                m_cServer = m_Ctx.GetServer("japopebo");
                m_cPhName = m_Ctx.GetPhName("japopebo");
                if (Cursor_japopebo!=null)
                  Cursor_japopebo.Close();
                Cursor_japopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("japopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_japopebo.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_japopebo.Next();
                }
                m_cConnectivityError = Cursor_japopebo.ErrorMessage();
                Cursor_japopebo.Close();
                // * --- End Select
                // * --- Select from jperazbo
                m_cServer = m_Ctx.GetServer("jperazbo");
                m_cPhName = m_Ctx.GetPhName("jperazbo");
                if (Cursor_jperazbo!=null)
                  Cursor_jperazbo.Close();
                Cursor_jperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_jperazbo.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_jperazbo.Next();
                }
                m_cConnectivityError = Cursor_jperazbo.ErrorMessage();
                Cursor_jperazbo.Close();
                // * --- End Select
                // * --- Select from kperazbo
                m_cServer = m_Ctx.GetServer("kperazbo");
                m_cPhName = m_Ctx.GetPhName("kperazbo");
                if (Cursor_kperazbo!=null)
                  Cursor_kperazbo.Close();
                Cursor_kperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("kperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_kperazbo.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_kperazbo.Next();
                }
                m_cConnectivityError = Cursor_kperazbo.ErrorMessage();
                Cursor_kperazbo.Close();
                // * --- End Select
                // * --- Select from opextrbo
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                if (Cursor_opextrbo!=null)
                  Cursor_opextrbo.Close();
                Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select ANNO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_opextrbo.Eof())) {
                  /* _esiste := _esiste + 1 */
                  _esiste = CPLib.Round(_esiste+1,0);
                  Cursor_opextrbo.Next();
                }
                m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
                Cursor_opextrbo.Close();
                // * --- End Select
                /* If _esiste = 0 */
                if (CPLib.eqr(_esiste,0)) {
                  /* gMsgProc := gMsgProc + 'Cancellazione del soggetto con NDG: '+ w_CONNES + NL // Messaggio */
                  gMsgProc = gMsgProc+"Cancellazione del soggetto con NDG: "+w_CONNES+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  // * --- Delete from personbo_agg
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo_agg");
                  m_cPhName = m_Ctx.GetPhName("personbo_agg");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_annulla_soggetti",20,"00000098")+"delete from "+m_oWrInfo.GetTableWriteName();
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
                    throw new RoutineException();
                  }
                  // * --- Delete from personbo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_annulla_soggetti",20,"00000099")+"delete from "+m_oWrInfo.GetTableWriteName();
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
                    throw new RoutineException();
                  }
                  // * --- Delete from wersonbo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_annulla_soggetti",20,"0000009A")+"delete from "+m_oWrInfo.GetTableWriteName();
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
                    throw new RoutineException();
                  }
                } // End If
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } else { // Else
              /* gMsgImp := 'Lettura soggetti in corso ...' // Messaggio Import */
              gMsgImp = "Lettura soggetti in corso ...";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
          /* gMsgImp := 'Elaborazione terminata con successo!' // Messaggio Import */
          gMsgImp = "Elaborazione terminata con successo!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
          /* gMsgImp := 'Elaborazione abortita causa errori. Contattare Assistenza!' // Messaggio Import */
          gMsgImp = "Elaborazione abortita causa errori. Contattare Assistenza!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000029status,0)) {
            m_Sql.SetTransactionStatus(nTry00000029status,cTry00000029msg);
          }
        }
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
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
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
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
        if (Cursor_japopebo!=null)
          Cursor_japopebo.Close();
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_annulla_soggettiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_annulla_soggettiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _esiste = 0;
    _presenza = "";
    w_CONNES = CPLib.Space(16);
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _reccount = 0;
    _cicli = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _oldmsg = CPLib.Space(100);
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tab_mmc,
  public static final String m_cVQRList = ",qbe_tab_mmc,";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
}
