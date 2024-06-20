// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_chg_connesR implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xerzistiope;
  public String m_cServer_xerzistiope;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xeneficfrz;
  public String m_cServer_xeneficfrz;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
  public String m_cPhName_xerzistifrz;
  public String m_cServer_xerzistifrz;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_xapotit;
  public String m_cServer_xapotit;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_jperazbo;
  public String m_cServer_jperazbo;
  public String m_cPhName_kperazbo;
  public String m_cServer_kperazbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_personbo_dip;
  public String m_cServer_personbo_dip;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_xntestit;
  public String m_cServer_xntestit;
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
  public String w_oldcon;
  public String w_newcon;
  public double conta;
  public String _esiste;
  public String cRitorno;
  public java.sql.Date _datmin;
  public double _numope;
  public double _totsal;
  public String _anno;
  public double _annomin;
  public double _prog;
  public String gMsgImp;
  public String gMsgProc;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_chg_connesR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_chg_connes",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
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
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    if (m_cPhName_beneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficfrz = m_cPhName_beneficfrz+" "+m_Ctx.GetWritePhName("beneficfrz");
    }
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
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
    m_cPhName_xlientiope = p_ContextObject.GetPhName("xlientiope");
    if (m_cPhName_xlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientiope = m_cPhName_xlientiope+" "+m_Ctx.GetWritePhName("xlientiope");
    }
    m_cServer_xlientiope = p_ContextObject.GetServer("xlientiope");
    m_cPhName_xeneficope = p_ContextObject.GetPhName("xeneficope");
    if (m_cPhName_xeneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficope = m_cPhName_xeneficope+" "+m_Ctx.GetWritePhName("xeneficope");
    }
    m_cServer_xeneficope = p_ContextObject.GetServer("xeneficope");
    m_cPhName_xogopebo = p_ContextObject.GetPhName("xogopebo");
    if (m_cPhName_xogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopebo = m_cPhName_xogopebo+" "+m_Ctx.GetWritePhName("xogopebo");
    }
    m_cServer_xogopebo = p_ContextObject.GetServer("xogopebo");
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
    m_cPhName_xeneficfrz = p_ContextObject.GetPhName("xeneficfrz");
    if (m_cPhName_xeneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficfrz = m_cPhName_xeneficfrz+" "+m_Ctx.GetWritePhName("xeneficfrz");
    }
    m_cServer_xeneficfrz = p_ContextObject.GetServer("xeneficfrz");
    m_cPhName_xogopefbo = p_ContextObject.GetPhName("xogopefbo");
    if (m_cPhName_xogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopefbo = m_cPhName_xogopefbo+" "+m_Ctx.GetWritePhName("xogopefbo");
    }
    m_cServer_xogopefbo = p_ContextObject.GetServer("xogopefbo");
    m_cPhName_xerzistifrz = p_ContextObject.GetPhName("xerzistifrz");
    if (m_cPhName_xerzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistifrz = m_cPhName_xerzistifrz+" "+m_Ctx.GetWritePhName("xerzistifrz");
    }
    m_cServer_xerzistifrz = p_ContextObject.GetServer("xerzistifrz");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    if (m_cPhName_xelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xelegabo = m_cPhName_xelegabo+" "+m_Ctx.GetWritePhName("xelegabo");
    }
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    m_cPhName_xapotit = p_ContextObject.GetPhName("xapotit");
    if (m_cPhName_xapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapotit = m_cPhName_xapotit+" "+m_Ctx.GetWritePhName("xapotit");
    }
    m_cServer_xapotit = p_ContextObject.GetServer("xapotit");
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
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    if (m_cPhName_japopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japopebo = m_cPhName_japopebo+" "+m_Ctx.GetWritePhName("japopebo");
    }
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
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
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_personbo_dip = p_ContextObject.GetPhName("personbo_dip");
    if (m_cPhName_personbo_dip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_dip = m_cPhName_personbo_dip+" "+m_Ctx.GetWritePhName("personbo_dip");
    }
    m_cServer_personbo_dip = p_ContextObject.GetServer("personbo_dip");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_xntestit = p_ContextObject.GetPhName("xntestit");
    if (m_cPhName_xntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestit = m_cPhName_xntestit+" "+m_Ctx.GetWritePhName("xntestit");
    }
    m_cServer_xntestit = p_ContextObject.GetServer("xntestit");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("_numope",p_cVarName)) {
      return _numope;
    }
    if (CPLib.eqr("_totsal",p_cVarName)) {
      return _totsal;
    }
    if (CPLib.eqr("_annomin",p_cVarName)) {
      return _annomin;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      return _prog;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_chg_connes";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("oldcon",p_cVarName)) {
      return w_oldcon;
    }
    if (CPLib.eqr("newcon",p_cVarName)) {
      return w_newcon;
    }
    if (CPLib.eqr("_esiste",p_cVarName)) {
      return _esiste;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_datmin",p_cVarName)) {
      return _datmin;
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
    if (CPLib.eqr("_numope",p_cVarName)) {
      _numope = value;
      return;
    }
    if (CPLib.eqr("_totsal",p_cVarName)) {
      _totsal = value;
      return;
    }
    if (CPLib.eqr("_annomin",p_cVarName)) {
      _annomin = value;
      return;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      _prog = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("oldcon",p_cVarName)) {
      w_oldcon = value;
      return;
    }
    if (CPLib.eqr("newcon",p_cVarName)) {
      w_newcon = value;
      return;
    }
    if (CPLib.eqr("_esiste",p_cVarName)) {
      _esiste = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      _anno = value;
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_datmin",p_cVarName)) {
      _datmin = value;
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_personbo_agg=null;
    CPResultSet Cursor_personbo_dip=null;
    CPResultSet Cursor_opextrbo=null;
    CPResultSet Cursor_qbe_opeanno_cli=null;
    CPResultSet Cursor_qbe_saldi_opex_o=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_oldcon Char(16) */
      /* w_newcon Char(16) */
      /* conta Numeric(10, 0) */
      /* _esiste Char(16) */
      /* cRitorno Char(2) */
      /* _datmin Date */
      /* _numope Numeric(10, 0) */
      /* _totsal Numeric(12, 2) */
      /* _anno Char(4) */
      /* _annomin Numeric(4, 0) */
      /* _prog Numeric(10, 0) */
      /* Dichiarazione variabili globali */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo */
      /* gAzienda Char(10) // Azienda */
      /* Verifica se il nuovo codice esiste già */
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' di cambio NDG ' + NL */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" di cambio NDG "+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Inizio Aggiornamento Soggetto e relativi collegamenti' // Messaggio Import */
      gMsgImp = "Inizio Aggiornamento Soggetto e relativi collegamenti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000016status;
      nTry00000016status = m_Sql.GetTransactionStatus();
      String cTry00000016msg;
      cTry00000016msg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgImp := 'Crea Nuovo record personbo' // Messaggio Import */
        gMsgImp = "Crea Nuovo record personbo";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _esiste := '' */
        _esiste = "";
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_newcon,"C",16,0,m_cServer),m_cServer,w_newcon);
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _esiste = Read_Cursor.GetString("CONNES");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_chg_connes returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _esiste = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(_esiste) */
        if (CPLib.Empty(_esiste)) {
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldcon)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            // * --- Insert into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000001C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000001C(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_newcon,"?",0,0,m_cServer)+", ";
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
            m_cSql = m_cSql+""+CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer)+", ";
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
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
          // * --- Select from personbo_agg
          m_cServer = m_Ctx.GetServer("personbo_agg");
          m_cPhName = m_Ctx.GetPhName("personbo_agg");
          if (Cursor_personbo_agg!=null)
            Cursor_personbo_agg.Close();
          Cursor_personbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldcon)+" "+")"+(m_Ctx.IsSharedTemp("personbo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo_agg.Eof())) {
            // * --- Insert into personbo_agg from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo_agg");
            m_cPhName = m_Ctx.GetPhName("personbo_agg");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000001E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000001E(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_newcon,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("EMAIL"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGEMAIL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("TELEFONO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("RDCODAUT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("RDLOCAUT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGBANCA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGVALIDO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("REGRES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGBL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetDouble("CLOCCUPA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("NUMTEL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("NAZIONE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("LASTOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CODCLIEST"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGANAVAL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CLPRVDOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetDouble("MITIG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGPREGIUD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGTRUST"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGRISCHIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGEQUIFIN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGFALSADIC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("FLGRICINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("WUGID"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("WUNAZRILDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("WUCOGNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("WUNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("WULUONAS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("NUMCEL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("PEC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_agg.GetString("REFERENTE"),"?",0,0,m_cServer)+", ";
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
            Cursor_personbo_agg.Next();
          }
          m_cConnectivityError = Cursor_personbo_agg.ErrorMessage();
          Cursor_personbo_agg.Close();
          // * --- End Select
          // * --- Select from personbo_dip
          m_cServer = m_Ctx.GetServer("personbo_dip");
          m_cPhName = m_Ctx.GetPhName("personbo_dip");
          if (Cursor_personbo_dip!=null)
            Cursor_personbo_dip.Close();
          Cursor_personbo_dip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldcon)+" "+")"+(m_Ctx.IsSharedTemp("personbo_dip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo_dip.Eof())) {
            // * --- Insert into personbo_dip from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo_dip");
            m_cPhName = m_Ctx.GetPhName("personbo_dip");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_dip",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000020")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000020(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_newcon,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo_dip.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_dip",true);
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
            Cursor_personbo_dip.Next();
          }
          m_cConnectivityError = Cursor_personbo_dip.ErrorMessage();
          Cursor_personbo_dip.Close();
          // * --- End Select
          // * --- Select from opextrbo
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          if (Cursor_opextrbo!=null)
            Cursor_opextrbo.Close();
          Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldcon)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_opextrbo.Eof())) {
            // * --- Insert into opextrbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("opextrbo");
            m_cPhName = m_Ctx.GetPhName("opextrbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000022")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000022(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_newcon,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("ANNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("COINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("NOTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDouble("PROGOPEX"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDouble("SALDO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDouble("QUANTITA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("UNIQUER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("OLDINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDate("DATAMODI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDouble("INVIATO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDate("DATAINVIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDouble("ANNULLA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDate("DATAANNU"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("OLDUNIQUE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDate("DATAOLDUNI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("IDESITO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDouble("INVSALDO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDate("DTSALDO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("CFESTERO"),"?",0,0,m_cServer)+", ";
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
            Cursor_opextrbo.Next();
          }
          m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
          Cursor_opextrbo.Close();
          // * --- End Select
          // * --- Delete from opextrbo
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000023")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
          // * --- Write into opextrbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000024")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"DATAANNU = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
          m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
          m_cSql = m_cSql+" and INVIATO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
          // * --- Delete from opextrbo
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000025")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
          m_cSql = m_cSql+" and INVIATO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(0,"?",0,0,m_cServer),m_cServer,0)+"";
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
        /* gMsgProc := gMsgProc + 'Aggiornamento WERSONBO' + NL */
        gMsgProc = gMsgProc+"Aggiornamento WERSONBO"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Aggiorna wersonbo' // Messaggio Import */
        gMsgImp = "Aggiorna wersonbo";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Write into wersonbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000028")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNES = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"wersonbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        /* gMsgImp := 'Aggiorna operazbo' // Messaggio Import */
        gMsgImp = "Aggiorna operazbo";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + 'Aggiornamento Operazioni' + NL */
        gMsgProc = gMsgProc+"Aggiornamento Operazioni"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Write into operazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000002B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into operazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000002C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESBEN = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into operazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000002D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into operazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000002E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNALTRO = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNALTRO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into clientiope from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("clientiope");
        m_cPhName = m_Ctx.GetPhName("clientiope");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000002F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"clientiope",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into beneficope from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("beneficope");
        m_cPhName = m_Ctx.GetPhName("beneficope");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000030")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"beneficope",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into sogopebo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("sogopebo");
        m_cPhName = m_Ctx.GetPhName("sogopebo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000031")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"sogopebo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into terzistiope from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("terzistiope");
        m_cPhName = m_Ctx.GetPhName("terzistiope");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000032")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"terzistiope",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        /* gMsgImp := 'Aggiorna fraziobo' // Messaggio Import */
        gMsgImp = "Aggiorna fraziobo";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + 'Aggiornamento Frazionate' + NL */
        gMsgProc = gMsgProc+"Aggiornamento Frazionate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Write into fraziobo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("fraziobo");
        m_cPhName = m_Ctx.GetPhName("fraziobo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000035")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into fraziobo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("fraziobo");
        m_cPhName = m_Ctx.GetPhName("fraziobo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000036")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESBEN = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into fraziobo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("fraziobo");
        m_cPhName = m_Ctx.GetPhName("fraziobo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000037")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into fraziobo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("fraziobo");
        m_cPhName = m_Ctx.GetPhName("fraziobo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000038")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNALTRO = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNALTRO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into clientifrz from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("clientifrz");
        m_cPhName = m_Ctx.GetPhName("clientifrz");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000039")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"clientifrz",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into beneficfrz from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("beneficfrz");
        m_cPhName = m_Ctx.GetPhName("beneficfrz");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000003A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"beneficfrz",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into sogopefbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("sogopefbo");
        m_cPhName = m_Ctx.GetPhName("sogopefbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000003B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"sogopefbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into terzistifrz from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("terzistifrz");
        m_cPhName = m_Ctx.GetPhName("terzistifrz");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000003C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"terzistifrz",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        /* gMsgImp := 'Aggiorna xperazbo' // Messaggio Import */
        gMsgImp = "Aggiorna xperazbo";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + 'Aggiornamento Operazioni Provvisorie' + NL */
        gMsgProc = gMsgProc+"Aggiornamento Operazioni Provvisorie"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Write into xperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xperazbo");
        m_cPhName = m_Ctx.GetPhName("xperazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000003F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xperazbo");
        m_cPhName = m_Ctx.GetPhName("xperazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000040")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESBEN = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xperazbo");
        m_cPhName = m_Ctx.GetPhName("xperazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000041")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xperazbo");
        m_cPhName = m_Ctx.GetPhName("xperazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000042")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNALTRO = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNALTRO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xlientiope from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xlientiope");
        m_cPhName = m_Ctx.GetPhName("xlientiope");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientiope",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000043")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xlientiope",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xeneficope from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xeneficope");
        m_cPhName = m_Ctx.GetPhName("xeneficope");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficope",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000044")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xeneficope",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xogopebo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xogopebo");
        m_cPhName = m_Ctx.GetPhName("xogopebo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xogopebo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000045")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xogopebo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xerzistiope from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xerzistiope");
        m_cPhName = m_Ctx.GetPhName("xerzistiope");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xerzistiope",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000046")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xerzistiope",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        /* gMsgImp := 'Aggiorna xraziobo' // Messaggio Import */
        gMsgImp = "Aggiorna xraziobo";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + 'Aggiornamento Frazionate Provvisorie' + NL */
        gMsgProc = gMsgProc+"Aggiornamento Frazionate Provvisorie"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Write into xraziobo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xraziobo");
        m_cPhName = m_Ctx.GetPhName("xraziobo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000049")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xraziobo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xraziobo");
        m_cPhName = m_Ctx.GetPhName("xraziobo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000004A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESBEN = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xraziobo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xraziobo");
        m_cPhName = m_Ctx.GetPhName("xraziobo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000004B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xraziobo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xraziobo");
        m_cPhName = m_Ctx.GetPhName("xraziobo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000004C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNALTRO = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNALTRO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xlientifrz from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xlientifrz");
        m_cPhName = m_Ctx.GetPhName("xlientifrz");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientifrz",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000004D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xlientifrz",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xeneficfrz from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xeneficfrz");
        m_cPhName = m_Ctx.GetPhName("xeneficfrz");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficfrz",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000004E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xeneficfrz",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xogopefbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xogopefbo");
        m_cPhName = m_Ctx.GetPhName("xogopefbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xogopefbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000004F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xogopefbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xerzistifrz from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xerzistifrz");
        m_cPhName = m_Ctx.GetPhName("xerzistifrz");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xerzistifrz",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000050")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xerzistifrz",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        /* gMsgImp := 'Aggiorna rapporti AUI' // Messaggio Import */
        gMsgImp = "Aggiorna rapporti AUI";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + 'Aggiornamento Rapporti AUI' + NL */
        gMsgProc = gMsgProc+"Aggiornamento Rapporti AUI"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Write into intestbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000053")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into delegabo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("delegabo");
        m_cPhName = m_Ctx.GetPhName("delegabo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000054")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"delegabo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into rapopebo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("rapopebo");
        m_cPhName = m_Ctx.GetPhName("rapopebo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000055")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapopebo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        /* gMsgImp := 'Aggiorna rapporti provvisori' // Messaggio Import */
        gMsgImp = "Aggiorna rapporti provvisori";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + 'Aggiornamento Rapporti Provvisori' + NL */
        gMsgProc = gMsgProc+"Aggiornamento Rapporti Provvisori"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Write into xntestbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xntestbo");
        m_cPhName = m_Ctx.GetPhName("xntestbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000058")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xntestbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xelegabo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xelegabo");
        m_cPhName = m_Ctx.GetPhName("xelegabo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xelegabo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000059")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xelegabo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xapopebo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xapopebo");
        m_cPhName = m_Ctx.GetPhName("xapopebo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000005A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xapopebo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        /* gMsgImp := 'Aggiorna Titolari AUI' // Messaggio Import */
        gMsgImp = "Aggiorna Titolari AUI";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + 'Aggiornamento Titolari AUI' + NL */
        gMsgProc = gMsgProc+"Aggiornamento Titolari AUI"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Write into rapotit from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("rapotit");
        m_cPhName = m_Ctx.GetPhName("rapotit");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000005D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapotit",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into rapotit from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("rapotit");
        m_cPhName = m_Ctx.GetPhName("rapotit");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000005E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapotit",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into intestit from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("intestit");
        m_cPhName = m_Ctx.GetPhName("intestit");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestit",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000005F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestit",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into intestit from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("intestit");
        m_cPhName = m_Ctx.GetPhName("intestit");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestit",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000060")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestit",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        /* gMsgImp := 'Aggiorna Titolari provvisori' // Messaggio Import */
        gMsgImp = "Aggiorna Titolari provvisori";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + 'Aggiornamento Titolari Provvisori' + NL */
        gMsgProc = gMsgProc+"Aggiornamento Titolari Provvisori"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Write into xapotit from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xapotit");
        m_cPhName = m_Ctx.GetPhName("xapotit");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapotit",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000063")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xapotit",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xapotit from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xapotit");
        m_cPhName = m_Ctx.GetPhName("xapotit");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapotit",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000064")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xapotit",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xntestit from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xntestit");
        m_cPhName = m_Ctx.GetPhName("xntestit");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestit",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000065")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xntestit",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into xntestit from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xntestit");
        m_cPhName = m_Ctx.GetPhName("xntestit");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestit",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000066")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xntestit",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        /* gMsgImp := 'Aggiorna AGE' // Messaggio Import */
        gMsgImp = "Aggiorna AGE";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + 'Aggiornamento AGE' + NL */
        gMsgProc = gMsgProc+"Aggiornamento AGE"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Write into jntestbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("jntestbo");
        m_cPhName = m_Ctx.GetPhName("jntestbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000069")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into jelegabo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("jelegabo");
        m_cPhName = m_Ctx.GetPhName("jelegabo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jelegabo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000006A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jelegabo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into japopebo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("japopebo");
        m_cPhName = m_Ctx.GetPhName("japopebo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japopebo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000006B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"japopebo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into jperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("jperazbo");
        m_cPhName = m_Ctx.GetPhName("jperazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jperazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000006C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jperazbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into jperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("jperazbo");
        m_cPhName = m_Ctx.GetPhName("jperazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jperazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000006D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jperazbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into jperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("jperazbo");
        m_cPhName = m_Ctx.GetPhName("jperazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jperazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"0000006E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jperazbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESBEN = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        /* gMsgImp := 'Aggiorna Operazioni Società Quotate' // Messaggio Import */
        gMsgImp = "Aggiorna Operazioni Società Quotate";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + 'Aggiornamento Operazioni Società Quotate' + NL */
        gMsgProc = gMsgProc+"Aggiornamento Operazioni Società Quotate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Write into kperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("kperazbo");
        m_cPhName = m_Ctx.GetPhName("kperazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"kperazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000071")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"kperazbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into kperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("kperazbo");
        m_cPhName = m_Ctx.GetPhName("kperazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"kperazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000072")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"kperazbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Write into kperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("kperazbo");
        m_cPhName = m_Ctx.GetPhName("kperazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"kperazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000073")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"kperazbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESBEN = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        /* gMsgImp := 'Aggiorna aerighe' // Messaggio Import */
        gMsgImp = "Aggiorna aerighe";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Write into aerighe from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000075")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESINT = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        /* gMsgImp := 'Aggiorna aeoprig' // Messaggio Import */
        gMsgImp = "Aggiorna aeoprig";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Write into aeoprig from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aeoprig");
        m_cPhName = m_Ctx.GetPhName("aeoprig");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000077")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESINT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        /* gMsgImp := 'Aggiorna aederig' // Messaggio Import */
        gMsgImp = "Aggiorna aederig";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Write into aederig from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000079")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESINT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        /* gMsgImp := 'Cancella vecchia scheda' // Messaggio Import */
        gMsgImp = "Cancella vecchia scheda";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + 'Elimina Vecchia Scheda' + NL */
        gMsgProc = gMsgProc+"Elimina Vecchia Scheda"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If not(Empty(_esiste)) */
        if ( ! (CPLib.Empty(_esiste))) {
          /* _annomin := Year(Date()) - 10 */
          _annomin = CPLib.Round(CPLib.Year(CPLib.Date())-10,0);
          // * --- Select from qbe_opeanno_cli
          SPBridge.HMCaller _h0000007E;
          _h0000007E = new SPBridge.HMCaller();
          _h0000007E.Set("m_cVQRList",m_cVQRList);
          _h0000007E.Set("pCONNESCLI",w_newcon);
          if (Cursor_qbe_opeanno_cli!=null)
            Cursor_qbe_opeanno_cli.Close();
          Cursor_qbe_opeanno_cli = new VQRHolder("qbe_opeanno_cli",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000007E,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_opeanno_cli.Eof())) {
            /* gMsgProc := gMsgProc +  'Esamino Anno '+ LRTrim(Str(qbe_opeanno_cli->ANNO,4,0)) + NL */
            gMsgProc = gMsgProc+"Esamino Anno "+CPLib.LRTrim(CPLib.Str(Cursor_qbe_opeanno_cli.GetDouble("ANNO"),4,0))+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* _anno := '' */
            _anno = "";
            // * --- Read from opextrbo
            m_cServer = m_Ctx.GetServer("opextrbo");
            m_cPhName = m_Ctx.GetPhName("opextrbo");
            m_cSql = "";
            m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_newcon,"C",16,0,m_cServer),m_cServer,w_newcon);
            m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(Cursor_qbe_opeanno_cli.GetDouble("ANNO"),4,0),"C",4,0,m_cServer),m_cServer,CPLib.Str(Cursor_qbe_opeanno_cli.GetDouble("ANNO"),4,0));
            if (m_Ctx.IsSharedTemp("opextrbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ANNO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _anno = Read_Cursor.GetString("ANNO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_chg_connes returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _anno = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _totsal := 0 */
            _totsal = CPLib.Round(0,2);
            /* _numope := 0 */
            _numope = CPLib.Round(0,0);
            /* _datmin := NullDate() */
            _datmin = CPLib.NullDate();
            // * --- Select from qbe_saldi_opex_o
            SPBridge.HMCaller _h00000086;
            _h00000086 = new SPBridge.HMCaller();
            _h00000086.Set("m_cVQRList",m_cVQRList);
            _h00000086.Set("annosel",Cursor_qbe_opeanno_cli.GetDouble("ANNO"));
            _h00000086.Set("ndgcli",w_newcon);
            if (Cursor_qbe_saldi_opex_o!=null)
              Cursor_qbe_saldi_opex_o.Close();
            Cursor_qbe_saldi_opex_o = new VQRHolder("qbe_saldi_opex_o",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000086,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_saldi_opex_o.Eof())) {
              /* _totsal := _totsal + qbe_saldi_opex_o->TOTLIRE */
              _totsal = CPLib.Round(_totsal+Cursor_qbe_saldi_opex_o.GetDouble("TOTLIRE"),2);
              /* _numope := _numope + qbe_saldi_opex_o->TOTOPER */
              _numope = CPLib.Round(_numope+Cursor_qbe_saldi_opex_o.GetDouble("TOTOPER"),0);
              /* If Empty(_datmin) or _datmin > qbe_saldi_opex_o->DATAOPE */
              if (CPLib.Empty(_datmin) || CPLib.gt(_datmin,Cursor_qbe_saldi_opex_o.GetDate("DATAOPE"))) {
                /* _datmin := qbe_saldi_opex_o->DATAOPE */
                _datmin = Cursor_qbe_saldi_opex_o.GetDate("DATAOPE");
              } // End If
              Cursor_qbe_saldi_opex_o.Next();
            }
            m_cConnectivityError = Cursor_qbe_saldi_opex_o.ErrorMessage();
            Cursor_qbe_saldi_opex_o.Close();
            // * --- End Select
            /* If qbe_opeanno_cli->ANNO = Year(Date()) */
            if (CPLib.eqr(Cursor_qbe_opeanno_cli.GetDouble("ANNO"),CPLib.Year(CPLib.Date()))) {
              /* _totsal := 0 */
              _totsal = CPLib.Round(0,2);
              /* _numope := 0 */
              _numope = CPLib.Round(0,0);
            } // End If
            /* If qbe_opeanno_cli->ANNO >= _annomin */
            if (CPLib.ge(Cursor_qbe_opeanno_cli.GetDouble("ANNO"),_annomin)) {
              /* If Empty(_anno) */
              if (CPLib.Empty(_anno)) {
                /* _prog := Utilities.GetAutonumber("PROGOPEX\'"+LRTrim(gAzienda)+"'",0,10) */
                _prog = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGOPEX\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
                // * --- Insert into opextrbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000091")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000091(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_newcon,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(Cursor_qbe_opeanno_cli.GetDouble("ANNO"),4,0),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_datmin,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_totsal,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_numope,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("Generata da cambio intestatario: "+CPLib.LRTrim(w_oldcon),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(Cursor_qbe_opeanno_cli.GetDouble("ANNO"),4,0)+"_"+CPLib.LRTrim(w_newcon),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0)+", ";
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
                /* gMsgProc := gMsgProc +  'Creazione Nuova operazione Extraconto per il periodo '+ Left(DateToChar(_datmin),6) +" (DA INVIARE!!!)"+ NL */
                gMsgProc = gMsgProc+"Creazione Nuova operazione Extraconto per il periodo "+CPLib.Left(CPLib.DateToChar(_datmin),6)+" (DA INVIARE!!!)"+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } else { // Else
                // * --- Write into opextrbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000093")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(_datmin,"D",8,0)+", ";
                m_cSql = m_cSql+"SALDO = "+CPLib.ToSQL(_totsal,"N",17,0)+", ";
                m_cSql = m_cSql+"QUANTITA = "+CPLib.ToSQL(_numope,"N",6,0)+", ";
                m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL("242","C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_newcon,"?",0,0,m_cServer),m_cServer,w_newcon)+"";
                m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(Cursor_qbe_opeanno_cli.GetDouble("ANNO"),4,0),"?",0,0,m_cServer),m_cServer,CPLib.Str(Cursor_qbe_opeanno_cli.GetDouble("ANNO"),4,0))+"";
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
                /* gMsgProc := gMsgProc +  "Aggiornamento operazione Extraconto per l'anno "+ Str(qbe_opeanno_cli->ANNO,4,0) + NL */
                gMsgProc = gMsgProc+"Aggiornamento operazione Extraconto per l'anno "+CPLib.Str(Cursor_qbe_opeanno_cli.GetDouble("ANNO"),4,0)+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } // End If
            } // End If
            Cursor_qbe_opeanno_cli.Next();
          }
          m_cConnectivityError = Cursor_qbe_opeanno_cli.ErrorMessage();
          Cursor_qbe_opeanno_cli.Close();
          // * --- End Select
        } // End If
        // * --- Delete from personbo_agg
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo_agg");
        m_cPhName = m_Ctx.GetPhName("personbo_agg");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000095")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // * --- Delete from personbo_dip
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo_dip");
        m_cPhName = m_Ctx.GetPhName("personbo_dip");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_dip",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000096")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chg_connes",24,"00000097")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* cRitorno := 'OK' */
        cRitorno = "OK";
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* cRitorno := 'KO' */
        cRitorno = "KO";
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000016status,0)) {
          m_Sql.SetTransactionStatus(nTry00000016status,cTry00000016msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' di cambio NDG ' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" di cambio NDG "+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Elaborazione completata' // Messaggio Import */
      gMsgImp = "Elaborazione completata";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
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
      try {
        if (Cursor_personbo_agg!=null)
          Cursor_personbo_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo_dip!=null)
          Cursor_personbo_dip.Close();
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
        if (Cursor_qbe_opeanno_cli!=null)
          Cursor_qbe_opeanno_cli.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_saldi_opex_o!=null)
          Cursor_qbe_saldi_opex_o.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_oldcon,String p_w_newcon) {
    w_oldcon = p_w_oldcon;
    w_newcon = p_w_newcon;
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
  public String Run(String p_w_oldcon,String p_w_newcon) {
    w_oldcon = p_w_oldcon;
    w_newcon = p_w_newcon;
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
          Page_1();
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
  public static arrt_chg_connesR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_chg_connesR(p_Ctx, p_Caller);
  }
  public static arrt_chg_connesR Make(CPContext p_Ctx) {
    return new arrt_chg_connesR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_oldcon = CPLib.Space(16);
    w_newcon = CPLib.Space(16);
    conta = 0;
    _esiste = CPLib.Space(16);
    cRitorno = CPLib.Space(2);
    _datmin = CPLib.NullDate();
    _numope = 0;
    _totsal = 0;
    _anno = CPLib.Space(4);
    _annomin = 0;
    _prog = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_opeanno_cli,qbe_saldi_opex_o,
  public static final String m_cVQRList = ",qbe_opeanno_cli,qbe_saldi_opex_o,";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_chg_connes,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_chg_connes,";
  public static String[] m_cRunParameterNames={"w_oldcon","w_newcon"};
  protected static String GetFieldsName_0000001C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000001E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CLPRVDOM,";
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
    p_cSql = p_cSql+"WUGID,";
    p_cSql = p_cSql+"WUNAZRILDOC,";
    p_cSql = p_cSql+"WUCOGNOME,";
    p_cSql = p_cSql+"WUNOME,";
    p_cSql = p_cSql+"WULUONAS,";
    p_cSql = p_cSql+"NUMCEL,";
    p_cSql = p_cSql+"PEC,";
    p_cSql = p_cSql+"REFERENTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000020(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_dip",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000022(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000091(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"SALDO,";
    p_cSql = p_cSql+"QUANTITA,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"PROGOPEX,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
}
