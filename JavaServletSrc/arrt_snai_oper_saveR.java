// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_snai_oper_saveR implements CallerWithObjs {
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
  public String m_cPhName_cgo_causali;
  public String m_cServer_cgo_causali;
  public String m_cPhName_cgo_docope;
  public String m_cServer_cgo_docope;
  public String m_cPhName_cgo_operazioni;
  public String m_cServer_cgo_operazioni;
  public String m_cPhName_cgo_operazioni_dl;
  public String m_cServer_cgo_operazioni_dl;
  public String m_cPhName_cgo_operazioni_dl_multi;
  public String m_cServer_cgo_operazioni_dl_multi;
  public String m_cPhName_cgo_operazioni_dl_multi_dc;
  public String m_cServer_cgo_operazioni_dl_multi_dc;
  public String m_cPhName_cgo_operazioni_dl_multi_dt;
  public String m_cServer_cgo_operazioni_dl_multi_dt;
  public String m_cPhName_cgo_operazioni_dl_multi_dt_dc;
  public String m_cServer_cgo_operazioni_dl_multi_dt_dc;
  public String m_cPhName_cgo_operazioni_storico;
  public String m_cServer_cgo_operazioni_storico;
  public String m_cPhName_cgo_operazioni_storico_multi;
  public String m_cServer_cgo_operazioni_storico_multi;
  public String m_cPhName_cgo_tipdoc;
  public String m_cServer_cgo_tipdoc;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xperazbo_agg;
  public String m_cServer_xperazbo_agg;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_xraziobo_agg;
  public String m_cServer_xraziobo_agg;
  public String m_cPhName_cgo_qadv_operazioni;
  public String m_cServer_cgo_qadv_operazioni;
  public String m_cPhName_cgo_qadv_operazioni_storico;
  public String m_cServer_cgo_qadv_operazioni_storico;
  public String m_cPhName_cgo_qadv_operazioni_dl;
  public String m_cServer_cgo_qadv_operazioni_dl;
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
  public String pSNAINUMOPE;
  public String pTipo;
  public String pAzi;
  public String gAzienda;
  public String cActLog;
  public double nProgImp;
  public String cInfProg1;
  public String cInfProg2;
  public String _tipinter;
  public String _codinter;
  public String _citinter;
  public String _cabinter;
  public String _prvinter;
  public double _limoper;
  public String _flgvlt;
  public String _flgvnp;
  public String _oldazi;
  public String _codazi;
  public java.sql.Date _datfin;
  public java.sql.Date _datdip;
  public String _codfisc;
  public String _connes;
  public String _mezpag;
  public String _numasg;
  public String xFLGSAE;
  public String cColleg;
  public double _oldute;
  public String _snainumope;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_snai_oper_saveR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_snai_oper_save",m_Caller);
    m_cPhName_cgo_causali = p_ContextObject.GetPhName("cgo_causali");
    if (m_cPhName_cgo_causali.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_causali = m_cPhName_cgo_causali+" "+m_Ctx.GetWritePhName("cgo_causali");
    }
    m_cServer_cgo_causali = p_ContextObject.GetServer("cgo_causali");
    m_cPhName_cgo_docope = p_ContextObject.GetPhName("cgo_docope");
    if (m_cPhName_cgo_docope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_docope = m_cPhName_cgo_docope+" "+m_Ctx.GetWritePhName("cgo_docope");
    }
    m_cServer_cgo_docope = p_ContextObject.GetServer("cgo_docope");
    m_cPhName_cgo_operazioni = p_ContextObject.GetPhName("cgo_operazioni");
    if (m_cPhName_cgo_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni = m_cPhName_cgo_operazioni+" "+m_Ctx.GetWritePhName("cgo_operazioni");
    }
    m_cServer_cgo_operazioni = p_ContextObject.GetServer("cgo_operazioni");
    m_cPhName_cgo_operazioni_dl = p_ContextObject.GetPhName("cgo_operazioni_dl");
    if (m_cPhName_cgo_operazioni_dl.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl = m_cPhName_cgo_operazioni_dl+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl");
    }
    m_cServer_cgo_operazioni_dl = p_ContextObject.GetServer("cgo_operazioni_dl");
    m_cPhName_cgo_operazioni_dl_multi = p_ContextObject.GetPhName("cgo_operazioni_dl_multi");
    if (m_cPhName_cgo_operazioni_dl_multi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi = m_cPhName_cgo_operazioni_dl_multi+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi");
    }
    m_cServer_cgo_operazioni_dl_multi = p_ContextObject.GetServer("cgo_operazioni_dl_multi");
    m_cPhName_cgo_operazioni_dl_multi_dc = p_ContextObject.GetPhName("cgo_operazioni_dl_multi_dc");
    if (m_cPhName_cgo_operazioni_dl_multi_dc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi_dc = m_cPhName_cgo_operazioni_dl_multi_dc+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi_dc");
    }
    m_cServer_cgo_operazioni_dl_multi_dc = p_ContextObject.GetServer("cgo_operazioni_dl_multi_dc");
    m_cPhName_cgo_operazioni_dl_multi_dt = p_ContextObject.GetPhName("cgo_operazioni_dl_multi_dt");
    if (m_cPhName_cgo_operazioni_dl_multi_dt.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi_dt = m_cPhName_cgo_operazioni_dl_multi_dt+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi_dt");
    }
    m_cServer_cgo_operazioni_dl_multi_dt = p_ContextObject.GetServer("cgo_operazioni_dl_multi_dt");
    m_cPhName_cgo_operazioni_dl_multi_dt_dc = p_ContextObject.GetPhName("cgo_operazioni_dl_multi_dt_dc");
    if (m_cPhName_cgo_operazioni_dl_multi_dt_dc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi_dt_dc = m_cPhName_cgo_operazioni_dl_multi_dt_dc+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi_dt_dc");
    }
    m_cServer_cgo_operazioni_dl_multi_dt_dc = p_ContextObject.GetServer("cgo_operazioni_dl_multi_dt_dc");
    m_cPhName_cgo_operazioni_storico = p_ContextObject.GetPhName("cgo_operazioni_storico");
    if (m_cPhName_cgo_operazioni_storico.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_storico = m_cPhName_cgo_operazioni_storico+" "+m_Ctx.GetWritePhName("cgo_operazioni_storico");
    }
    m_cServer_cgo_operazioni_storico = p_ContextObject.GetServer("cgo_operazioni_storico");
    m_cPhName_cgo_operazioni_storico_multi = p_ContextObject.GetPhName("cgo_operazioni_storico_multi");
    if (m_cPhName_cgo_operazioni_storico_multi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_storico_multi = m_cPhName_cgo_operazioni_storico_multi+" "+m_Ctx.GetWritePhName("cgo_operazioni_storico_multi");
    }
    m_cServer_cgo_operazioni_storico_multi = p_ContextObject.GetServer("cgo_operazioni_storico_multi");
    m_cPhName_cgo_tipdoc = p_ContextObject.GetPhName("cgo_tipdoc");
    if (m_cPhName_cgo_tipdoc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_tipdoc = m_cPhName_cgo_tipdoc+" "+m_Ctx.GetWritePhName("cgo_tipdoc");
    }
    m_cServer_cgo_tipdoc = p_ContextObject.GetServer("cgo_tipdoc");
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
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
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
    m_cPhName_cgo_qadv_operazioni = p_ContextObject.GetPhName("cgo_qadv_operazioni");
    if (m_cPhName_cgo_qadv_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_qadv_operazioni = m_cPhName_cgo_qadv_operazioni+" "+m_Ctx.GetWritePhName("cgo_qadv_operazioni");
    }
    m_cServer_cgo_qadv_operazioni = p_ContextObject.GetServer("cgo_qadv_operazioni");
    m_cPhName_cgo_qadv_operazioni_storico = p_ContextObject.GetPhName("cgo_qadv_operazioni_storico");
    if (m_cPhName_cgo_qadv_operazioni_storico.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_qadv_operazioni_storico = m_cPhName_cgo_qadv_operazioni_storico+" "+m_Ctx.GetWritePhName("cgo_qadv_operazioni_storico");
    }
    m_cServer_cgo_qadv_operazioni_storico = p_ContextObject.GetServer("cgo_qadv_operazioni_storico");
    m_cPhName_cgo_qadv_operazioni_dl = p_ContextObject.GetPhName("cgo_qadv_operazioni_dl");
    if (m_cPhName_cgo_qadv_operazioni_dl.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_qadv_operazioni_dl = m_cPhName_cgo_qadv_operazioni_dl+" "+m_Ctx.GetWritePhName("cgo_qadv_operazioni_dl");
    }
    m_cServer_cgo_qadv_operazioni_dl = p_ContextObject.GetServer("cgo_qadv_operazioni_dl");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("_limoper",p_cVarName)) {
      return _limoper;
    }
    if (CPLib.eqr("_oldute",p_cVarName)) {
      return _oldute;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_snai_oper_save";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pSNAINUMOPE",p_cVarName)) {
      return pSNAINUMOPE;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pAzi",p_cVarName)) {
      return pAzi;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("cActLog",p_cVarName)) {
      return cActLog;
    }
    if (CPLib.eqr("cInfProg1",p_cVarName)) {
      return cInfProg1;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      return cInfProg2;
    }
    if (CPLib.eqr("_tipinter",p_cVarName)) {
      return _tipinter;
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
    if (CPLib.eqr("_flgvlt",p_cVarName)) {
      return _flgvlt;
    }
    if (CPLib.eqr("_flgvnp",p_cVarName)) {
      return _flgvnp;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      return _oldazi;
    }
    if (CPLib.eqr("_codazi",p_cVarName)) {
      return _codazi;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      return _codfisc;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("_mezpag",p_cVarName)) {
      return _mezpag;
    }
    if (CPLib.eqr("_numasg",p_cVarName)) {
      return _numasg;
    }
    if (CPLib.eqr("xFLGSAE",p_cVarName)) {
      return xFLGSAE;
    }
    if (CPLib.eqr("cColleg",p_cVarName)) {
      return cColleg;
    }
    if (CPLib.eqr("_snainumope",p_cVarName)) {
      return _snainumope;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_datfin",p_cVarName)) {
      return _datfin;
    }
    if (CPLib.eqr("_datdip",p_cVarName)) {
      return _datdip;
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
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("_limoper",p_cVarName)) {
      _limoper = value;
      return;
    }
    if (CPLib.eqr("_oldute",p_cVarName)) {
      _oldute = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pSNAINUMOPE",p_cVarName)) {
      pSNAINUMOPE = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pAzi",p_cVarName)) {
      pAzi = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("cActLog",p_cVarName)) {
      cActLog = value;
      return;
    }
    if (CPLib.eqr("cInfProg1",p_cVarName)) {
      cInfProg1 = value;
      return;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      cInfProg2 = value;
      return;
    }
    if (CPLib.eqr("_tipinter",p_cVarName)) {
      _tipinter = value;
      return;
    }
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
    if (CPLib.eqr("_flgvlt",p_cVarName)) {
      _flgvlt = value;
      return;
    }
    if (CPLib.eqr("_flgvnp",p_cVarName)) {
      _flgvnp = value;
      return;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      _oldazi = value;
      return;
    }
    if (CPLib.eqr("_codazi",p_cVarName)) {
      _codazi = value;
      return;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      _codfisc = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
    if (CPLib.eqr("_mezpag",p_cVarName)) {
      _mezpag = value;
      return;
    }
    if (CPLib.eqr("_numasg",p_cVarName)) {
      _numasg = value;
      return;
    }
    if (CPLib.eqr("xFLGSAE",p_cVarName)) {
      xFLGSAE = value;
      return;
    }
    if (CPLib.eqr("cColleg",p_cVarName)) {
      cColleg = value;
      return;
    }
    if (CPLib.eqr("_snainumope",p_cVarName)) {
      _snainumope = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_datfin",p_cVarName)) {
      _datfin = value;
      return;
    }
    if (CPLib.eqr("_datdip",p_cVarName)) {
      _datdip = value;
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_cgo_operazioni=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_cgo_qadv_operazioni=null;
    try {
      /* Parametri */
      /* pSNAINUMOPE Char(15) */
      /* pTipo Char(1) */
      /* pAzi Char(10) */
      /* gAzienda Char(10) // Azienda */
      /* cActLog Char(1) // Log Applicazione */
      /* nProgImp Numeric(15, 0) */
      /* cInfProg1 Char(10) */
      /* cInfProg2 Char(11) */
      /* _tipinter Char(2) */
      /* _codinter Char(11) */
      /* _citinter Char(30) */
      /* _cabinter Char(6) */
      /* _prvinter Char(2) */
      /* _limoper Numeric(12, 2) */
      /* _flgvlt Char(1) */
      /* _flgvnp Char(1) */
      /* _oldazi Char(10) */
      /* _codazi Char(10) */
      /* _datfin Date */
      /* _datdip Date */
      /* _codfisc Char(16) */
      /* _connes Char(16) */
      /* _mezpag Char(1) */
      /* _numasg Char(25) */
      /* xFLGSAE Char(1) */
      /* cColleg Char(12) */
      /* _oldute Numeric(10, 0) */
      /* _snainumope Char(15) */
      /* If not(Empty(pAzi)) */
      if ( ! (CPLib.Empty(pAzi))) {
        /* _oldute := Utilities.UserCode() */
        _oldute = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).UserCode(),0);
        /* Utilities.SetUserCode(1) */
        Utilities.Make(m_Ctx,m_Caller).SetUserCode(1);
        /* _oldazi := Utilities.GetCompany() */
        _oldazi = Utilities.Make(m_Ctx,m_Caller).GetCompany();
        /* Utilities.SetCompany(pAzi) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(pAzi);
        /* _codazi := pAzi */
        _codazi = pAzi;
      } else { // Else
        /* _codazi := gAzienda */
        _codazi = gAzienda;
      } // End If
      /* Info Msg 'Inizio Routine Salvataggio Operazione: '+ pSNAINUMOPE */
      if ( ! (CPLib.IsNull(m_Info))) {
        m_Info.log("Inizio Routine Salvataggio Operazione: "+pSNAINUMOPE);
      }
      /* If pTipo='X' or pTipo='S' */
      if (CPLib.eqr(pTipo,"X") || CPLib.eqr(pTipo,"S")) {
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* _tipinter := intermbo->TIPINTER */
          _tipinter = Cursor_intermbo.GetString("TIPINTER");
          /* _codinter := intermbo->CODINTER */
          _codinter = Cursor_intermbo.GetString("CODINTER");
          /* _citinter := intermbo->DESCCIT */
          _citinter = Cursor_intermbo.GetString("DESCCIT");
          /* _cabinter := intermbo->CODCAB */
          _cabinter = Cursor_intermbo.GetString("CODCAB");
          /* _prvinter := intermbo->PROVINCIA */
          _prvinter = Cursor_intermbo.GetString("PROVINCIA");
          /* _limoper := intermbo->IMPINTOPE */
          _limoper = CPLib.Round(Cursor_intermbo.GetDouble("IMPINTOPE"),2);
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        // * --- Select from cgo_operazioni
        m_cServer = m_Ctx.GetServer("cgo_operazioni");
        m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
        if (Cursor_cgo_operazioni!=null)
          Cursor_cgo_operazioni.Close();
        Cursor_cgo_operazioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pSNAINUMOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,pSNAINUMOPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_operazioni.Eof())) {
          /* _flgvlt := cgo_operazioni->CGOFLGVLT */
          _flgvlt = Cursor_cgo_operazioni.GetString("CGOFLGVLT");
          /* _flgvnp := cgo_operazioni->CGOFLGVNP */
          _flgvnp = Cursor_cgo_operazioni.GetString("CGOFLGVNP");
          /* _mezpag := cgo_operazioni->MEZPAGAM */
          _mezpag = Cursor_cgo_operazioni.GetString("MEZPAGAM");
          /* _numasg := cgo_operazioni->ASSEGNO */
          _numasg = Cursor_cgo_operazioni.GetString("ASSEGNO");
          Cursor_cgo_operazioni.Next();
        }
        m_cConnectivityError = Cursor_cgo_operazioni.ErrorMessage();
        Cursor_cgo_operazioni.Close();
        // * --- End Select
        /* If _flgvlt='A' or pTipo='S' */
        if (CPLib.eqr(_flgvlt,"A") || CPLib.eqr(pTipo,"S")) {
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry00000038status;
          nTry00000038status = m_Sql.GetTransactionStatus();
          String cTry00000038msg;
          cTry00000038msg = m_Sql.TransactionErrorMessage();
          try {
            /* Exec "Scrive i dati del soggetto" Page 2:Page_2 */
            Page_2();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* Exec "Scrive i dati dell'operazione" Page 3:Page_3 */
            Page_3();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            // * --- Select from cgo_operazioni
            m_cServer = m_Ctx.GetServer("cgo_operazioni");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
            if (Cursor_cgo_operazioni!=null)
              Cursor_cgo_operazioni.Close();
            Cursor_cgo_operazioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pSNAINUMOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,pSNAINUMOPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_cgo_operazioni.Eof())) {
              /* If pTipo='S' */
              if (CPLib.eqr(pTipo,"S")) {
                /* _datfin := Date() */
                _datfin = CPLib.Date();
                /* _datdip := NullDate() */
                _datdip = CPLib.NullDate();
              } else { // Else
                /* _datfin := NullDate() */
                _datfin = CPLib.NullDate();
                /* _datdip := Date() */
                _datdip = CPLib.Date();
              } // End If
              // * --- Insert into cgo_operazioni_storico from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
              m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_storico",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000041")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000041(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SNAINUMOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PEP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("DESCCITDIP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PROVINCIADIP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODCABDIP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PAESEICP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("DESCINTERCP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("idcauana"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("NOPROT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDate("DATAIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("CACODICE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDateTime("CADATAORA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("IBAN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("MEZPAGAM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CGOFLGVLT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CGOFLGVNP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CGOTIPOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMOPEDL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CGODIPCOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CAFLGOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datdip,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datfin,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("ASSEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDate("CGODATCON"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CGOESICON"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CGONOTCON"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDate("CADATIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("RDCODAUT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("RDLOCAUT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("CATIPGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("CATIPGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("CAPV_COD"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("VLTPLAT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CC4CIFRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CCDATSCA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMTEL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("IDDOCALL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("FLGDOCALL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("CCANNSCA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("CCMESSCA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PEPDESCRI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("DOMICILIO2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("DESCCIT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PROVINCIA2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PAESE2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("FLGDOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PROFESSIONE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("FLAGWALLET"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("IMPWALLET"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODWALLET"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODTRANSZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_operazioni_storico",true);
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
              /* If cgo_operazioni->TIPOGIOCO='V' */
              if (CPLib.eqr(Cursor_cgo_operazioni.GetString("TIPOGIOCO"),"V")) {
                /* _snainumope := '' */
                _snainumope = "";
                // * --- Read from cgo_qadv_operazioni
                m_cServer = m_Ctx.GetServer("cgo_qadv_operazioni");
                m_cPhName = m_Ctx.GetPhName("cgo_qadv_operazioni");
                m_cSql = "";
                m_cSql = m_cSql+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SNAINUMOPE"),"C",15,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetString("SNAINUMOPE"));
                if (m_Ctx.IsSharedTemp("cgo_qadv_operazioni")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SNAINUMOPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _snainumope = Read_Cursor.GetString("SNAINUMOPE");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on cgo_qadv_operazioni into routine arrt_snai_oper_save returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _snainumope = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If not(Empty(LRTrim(_snainumope))) */
                if ( ! (CPLib.Empty(CPLib.LRTrim(_snainumope)))) {
                  // * --- Select from cgo_qadv_operazioni
                  m_cServer = m_Ctx.GetServer("cgo_qadv_operazioni");
                  m_cPhName = m_Ctx.GetPhName("cgo_qadv_operazioni");
                  if (Cursor_cgo_qadv_operazioni!=null)
                    Cursor_cgo_qadv_operazioni.Close();
                  Cursor_cgo_qadv_operazioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SNAINUMOPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_qadv_operazioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_cgo_qadv_operazioni.Eof())) {
                    // * --- Insert into cgo_qadv_operazioni_storico from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("cgo_qadv_operazioni_storico");
                    m_cPhName = m_Ctx.GetPhName("cgo_qadv_operazioni_storico");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_qadv_operazioni_storico",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000047")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000047(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SNAINUMOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_DOMANDA01"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_PUNTEGGIO01"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_DOMANDA02"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_PUNTEGGIO02"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_DOMANDA03"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetString("QADV_DOMANDA03_1"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetString("QADV_DOMANDA03_2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetString("QADV_DOMANDA03_3"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_PUNTEGGIO03"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetString("QADV_MOTIVO03"),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_DOMANDA04"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetString("QADV_DOMANDA04_1"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetString("QADV_DOMANDA04_2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetString("QADV_DOMANDA04_3"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetString("QADV_DOMANDA04_4"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_PUNTEGGIO04"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetString("QADV_MOTIVO04"),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_DOMANDA05"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_PUNTEGGIO05"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetString("QADV_MOTIVO05"),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_DOMANDA06"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_PUNTEGGIO06"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_DOMANDA07"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_PUNTEGGIO07"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_DOMANDA08"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_PUNTEGGIO08"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_DOMANDA09"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_PUNTEGGIO09"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_DOMANDA10"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_PUNTEGGIO10"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_DOMANDA11"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_PUNTEGGIO11"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_DOMANDA12"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_PUNTEGGIO12"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetString("QADV_FLGCOMPLETO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni.GetDouble("QADV_TOTALE"),"?",0,0)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_qadv_operazioni_storico",true);
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
                    Cursor_cgo_qadv_operazioni.Next();
                  }
                  m_cConnectivityError = Cursor_cgo_qadv_operazioni.ErrorMessage();
                  Cursor_cgo_qadv_operazioni.Close();
                  // * --- End Select
                  // * --- Delete from cgo_qadv_operazioni
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_qadv_operazioni");
                  m_cPhName = m_Ctx.GetPhName("cgo_qadv_operazioni");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_qadv_operazioni",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000048")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetString("SNAINUMOPE"))+"";
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
              } // End If
              Cursor_cgo_operazioni.Next();
            }
            m_cConnectivityError = Cursor_cgo_operazioni.ErrorMessage();
            Cursor_cgo_operazioni.Close();
            // * --- End Select
            // * --- Delete from cgo_operazioni
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_operazioni");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000049")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pSNAINUMOPE,"?",0,0,m_cServer),m_cServer,pSNAINUMOPE)+"";
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
            /* Exec Routine arrt_writelog('DELETE','CGO_OPERAZIONI',pSNAINUMOPE,"","I") */
            arrt_writelogR.Make(m_Ctx,this).Run("DELETE","CGO_OPERAZIONI",pSNAINUMOPE,"","I");
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
            /* Exec Routine arrt_writelog('DELETE','CGO_OPERAZIONI',pSNAINUMOPE,"","I") */
            arrt_writelogR.Make(m_Ctx,this).Run("DELETE","CGO_OPERAZIONI",pSNAINUMOPE,"","I");
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000038status,0)) {
              m_Sql.SetTransactionStatus(nTry00000038status,cTry00000038msg);
            }
          }
          /* ElseIf _flgvlt='S' and pTipo <> 'S' */
        } else if (CPLib.eqr(_flgvlt,"S") && CPLib.ne(pTipo,"S")) {
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry0000004Fstatus;
          nTry0000004Fstatus = m_Sql.GetTransactionStatus();
          String cTry0000004Fmsg;
          cTry0000004Fmsg = m_Sql.TransactionErrorMessage();
          try {
            // * --- Write into cgo_operazioni from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_operazioni");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000050")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CGODIPCOM = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pSNAINUMOPE,"?",0,0,m_cServer),m_cServer,pSNAINUMOPE)+"";
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
            /* Exec Routine arrt_writelog('UPDATE','CGO_OPERAZIONI',pSNAINUMOPE,'','I') */
            arrt_writelogR.Make(m_Ctx,this).Run("UPDATE","CGO_OPERAZIONI",pSNAINUMOPE,"","I");
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
            /* Exec Routine arrt_writelog('DELETE','CGO_OPERAZIONI',pSNAINUMOPE,"",'I') */
            arrt_writelogR.Make(m_Ctx,this).Run("DELETE","CGO_OPERAZIONI",pSNAINUMOPE,"","I");
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000004Fstatus,0)) {
              m_Sql.SetTransactionStatus(nTry0000004Fstatus,cTry0000004Fmsg);
            }
          }
        } // End If
      } // End If
      /* Legge parametro intermediario */
      /* If not(Empty(pAzi)) */
      if ( ! (CPLib.Empty(pAzi))) {
        /* Utilities.SetUserCode(_oldute) */
        Utilities.Make(m_Ctx,m_Caller).SetUserCode(_oldute);
        /* Utilities.SetCompany(_oldazi) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(_oldazi);
      } // End If
      /* Info Msg 'Fine Routine Salvataggio Operazione: '+ pSNAINUMOPE */
      if ( ! (CPLib.IsNull(m_Info))) {
        m_Info.log("Fine Routine Salvataggio Operazione: "+pSNAINUMOPE);
      }
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_operazioni!=null)
          Cursor_cgo_operazioni.Close();
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
        if (Cursor_cgo_qadv_operazioni!=null)
          Cursor_cgo_qadv_operazioni.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_cgo_operazioni=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_intestbo=null;
    try {
      /* xAnnNas Char(2) // Anno Di Nascita */
      String xAnnNas;
      xAnnNas = CPLib.Space(2);
      /* xMesNas Char(2) // Mese Di Nascita */
      String xMesNas;
      xMesNas = CPLib.Space(2);
      /* xDayNas Char(2) // Giorno Di Nascita */
      String xDayNas;
      xDayNas = CPLib.Space(2);
      /* cDNAS Date */
      java.sql.Date cDNAS;
      cDNAS = CPLib.NullDate();
      /* xSesso Char(1) */
      String xSesso;
      xSesso = CPLib.Space(1);
      /* cSNAS Char(30) */
      String cSNAS;
      cSNAS = CPLib.Space(30);
      /* cCNAS Char(30) */
      String cCNAS;
      cCNAS = CPLib.Space(30);
      /* cPNAS Char(2) */
      String cPNAS;
      cPNAS = CPLib.Space(2);
      /* xCodCab Char(6) */
      String xCodCab;
      xCodCab = CPLib.Space(6);
      /* _datnas Date */
      java.sql.Date _datnas;
      _datnas = CPLib.NullDate();
      /* _datemi Date */
      java.sql.Date _datemi;
      _datemi = CPLib.NullDate();
      /* _datval Date */
      java.sql.Date _datval;
      _datval = CPLib.NullDate();
      /* xRagSoc Char(70) */
      String xRagSoc;
      xRagSoc = CPLib.Space(70);
      /* cCli1 Char(16) */
      String cCli1;
      cCli1 = CPLib.Space(16);
      /* xCF Char(16) */
      String xCF;
      xCF = CPLib.Space(16);
      /* xCFE Numeric(1, 0) */
      double xCFE;
      xCFE = 0;
      /* xCitta Char(30) */
      String xCitta;
      xCitta = CPLib.Space(30);
      /* cProgSto Char(15) */
      String cProgSto;
      cProgSto = CPLib.Space(15);
      /* xRiga1 Memo */
      String xRiga1;
      xRiga1 = "";
      /* xRiga2 Memo */
      String xRiga2;
      xRiga2 = "";
      /* _tipdoc Char(2) */
      String _tipdoc;
      _tipdoc = CPLib.Space(2);
      // * --- Select from cgo_operazioni
      m_cServer = m_Ctx.GetServer("cgo_operazioni");
      m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
      if (Cursor_cgo_operazioni!=null)
        Cursor_cgo_operazioni.Close();
      Cursor_cgo_operazioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pSNAINUMOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,pSNAINUMOPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_operazioni.Eof())) {
        /* _tipdoc := '' */
        _tipdoc = "";
        /* _connes := '' */
        _connes = "";
        /* xRiga1 := '' */
        xRiga1 = "";
        /* xRiga2 := '' */
        xRiga2 = "";
        /* xFLGSAE := '' */
        xFLGSAE = "";
        // * --- Read from tbstati
        m_cServer = m_Ctx.GetServer("tbstati");
        m_cPhName = m_Ctx.GetPhName("tbstati");
        m_cSql = "";
        m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetString("PAESE"));
        if (m_Ctx.IsSharedTemp("tbstati")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGSAE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          xFLGSAE = Read_Cursor.GetString("FLGSAE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tbstati into routine arrt_snai_oper_save returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          xFLGSAE = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Read from cgo_tipdoc
        m_cServer = m_Ctx.GetServer("cgo_tipdoc");
        m_cPhName = m_Ctx.GetPhName("cgo_tipdoc");
        m_cSql = "";
        m_cSql = m_cSql+"TIPDOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetString("TIPODOC"),"C",2,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetString("TIPODOC"));
        if (m_Ctx.IsSharedTemp("cgo_tipdoc")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("AUIDOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _tipdoc = Read_Cursor.GetString("AUIDOC");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cgo_tipdoc into routine arrt_snai_oper_save returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _tipdoc = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(cgo_operazioni->CONNESCLI)) */
        if ( ! (CPLib.Empty(Cursor_cgo_operazioni.GetString("CONNESCLI")))) {
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CONNESCLI"),"C",16,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetString("CONNESCLI"));
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _connes = Read_Cursor.GetString("CONNES");
            _codfisc = Read_Cursor.GetString("CODFISC");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_snai_oper_save returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _connes = "";
            _codfisc = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
        } else { // Else
          /* If not(Empty(LRTrim(cgo_operazioni->CODFISC))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_operazioni.GetString("CODFISC"))))) {
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODFISC"),"C",16,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetString("CODFISC"));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _connes = Read_Cursor.GetString("CONNES");
              _codfisc = Read_Cursor.GetString("CODFISC");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_snai_oper_save returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _connes = "";
              _codfisc = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
        } // End If
        /* If Empty(LRTrim(_connes)) */
        if (CPLib.Empty(CPLib.LRTrim(_connes))) {
          /* _connes := cgo_operazioni->CODFISC */
          _connes = Cursor_cgo_operazioni.GetString("CODFISC");
          /* _codfisc := cgo_operazioni->CODFISC */
          _codfisc = Cursor_cgo_operazioni.GetString("CODFISC");
          /* If cgo_operazioni->CFESTERO=1 and Empty(LRTrim(cgo_operazioni->CODFISC)) */
          if (CPLib.eqr(Cursor_cgo_operazioni.GetDouble("CFESTERO"),1) && CPLib.Empty(CPLib.LRTrim(Cursor_cgo_operazioni.GetString("CODFISC")))) {
            /* _connes := Utilities.GetAutonumber("PRGCLIEST\'"+LRTrim(_codazi)+"'","",16) */
            _connes = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGCLIEST\\'"+CPLib.LRTrim(_codazi)+"'","",16);
            /* _codfisc := _connes */
            _codfisc = _connes;
          } // End If
          /* nProgImp := Utilities.GetAutonumber("PRGIMPOCLI\'"+LRTrim(_codazi)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOCLI\\'"+CPLib.LRTrim(_codazi)+"'",0,15),0);
          // * --- Insert into personbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000083")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000083(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codfisc,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDate("DATANASC"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_operazioni.GetDouble("CFESTERO"),0)?"600":"77"+xFLGSAE),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_operazioni.GetDouble("CFESTERO"),0)?"600":"711"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipdoc,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDate("DATARILASC"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SESSO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDate("DATAVALI"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NOME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("CFESTERO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PEP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
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
          }
          // * --- Insert into personbo_agg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo_agg");
          m_cPhName = m_Ctx.GetPhName("personbo_agg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000084")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000084(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("RDCODAUT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("RDLOCAUT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMTEL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SNAINUMOPE"),"?",0,0,m_cServer)+", ";
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
          }
        } else { // Else
          /* xAnnNas := '' // Anno Di Nascita */
          xAnnNas = "";
          /* xMesNas := '' // Mese Di Nascita */
          xMesNas = "";
          /* xDayNas := '' // Giorno Di Nascita */
          xDayNas = "";
          /* cDNAS := NullDate() */
          cDNAS = CPLib.NullDate();
          /* xSesso := '' */
          xSesso = "";
          /* cSNAS := '' */
          cSNAS = "";
          /* cCNAS := '' */
          cCNAS = "";
          /* cPNAS := '' */
          cPNAS = "";
          /* xCodCab := '' */
          xCodCab = "";
          /* _datnas := cgo_operazioni->DATANASC */
          _datnas = Cursor_cgo_operazioni.GetDate("DATANASC");
          /* _datemi := cgo_operazioni->DATARILASC */
          _datemi = Cursor_cgo_operazioni.GetDate("DATARILASC");
          /* _datval := cgo_operazioni->DATAVALI */
          _datval = Cursor_cgo_operazioni.GetDate("DATAVALI");
          /* xRagSoc := LRTrim(cgo_operazioni->COGNOME)+" "+ LRTrim(cgo_operazioni->NOME) */
          xRagSoc = CPLib.LRTrim(Cursor_cgo_operazioni.GetString("COGNOME"))+" "+CPLib.LRTrim(Cursor_cgo_operazioni.GetString("NOME"));
          /* cCli1 := cgo_operazioni->CODFISC */
          cCli1 = Cursor_cgo_operazioni.GetString("CODFISC");
          /* xCF := cgo_operazioni->CODFISC */
          xCF = Cursor_cgo_operazioni.GetString("CODFISC");
          /* xCFE := cgo_operazioni->CFESTERO */
          xCFE = CPLib.Round(Cursor_cgo_operazioni.GetDouble("CFESTERO"),0);
          /* If Empty(LRTrim(xCodCab)) */
          if (CPLib.Empty(CPLib.LRTrim(xCodCab))) {
            /* xCitta := cgo_operazioni->DESCCIT */
            xCitta = Cursor_cgo_operazioni.GetString("DESCCIT");
            // * --- Read from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(xCitta,"C",60,0,m_cServer),m_cServer,xCitta);
            if (m_Ctx.IsSharedTemp("tbcitta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xCodCab = Read_Cursor.GetString("CAB");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_snai_oper_save returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xCodCab = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* xAnnNas := Substr(DateToChar(cgo_operazioni->DATANASC),1,4) // Anno Di Nascita */
          xAnnNas = CPLib.Substr(CPLib.DateToChar(Cursor_cgo_operazioni.GetDate("DATANASC")),1,4);
          /* xMesNas := Substr(DateToChar(cgo_operazioni->DATANASC),5,2) // Mese Di Nascita */
          xMesNas = CPLib.Substr(CPLib.DateToChar(Cursor_cgo_operazioni.GetDate("DATANASC")),5,2);
          /* xDayNas := Substr(DateToChar(cgo_operazioni->DATANASC),7,2) // Giorno Di Nascita */
          xDayNas = CPLib.Substr(CPLib.DateToChar(Cursor_cgo_operazioni.GetDate("DATANASC")),7,2);
          /* cDNAS := _datnas */
          cDNAS = _datnas;
          /* xSesso := cgo_operazioni->SESSO */
          xSesso = Cursor_cgo_operazioni.GetString("SESSO");
          /* If not(Empty(LRTrim(cgo_operazioni->TIPINTER))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_operazioni.GetString("TIPINTER"))))) {
            /* If LRTrim(cgo_operazioni->TIPINTER)='EE' */
            if (CPLib.eqr(CPLib.LRTrim(Cursor_cgo_operazioni.GetString("TIPINTER")),"EE")) {
              /* cSNAS := '' */
              cSNAS = "";
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NASSTATO"),"C",40,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetString("NASSTATO"));
              if (m_Ctx.IsSharedTemp("tbstati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                cSNAS = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_snai_oper_save returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                cSNAS = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(cSNAS) */
              if (CPLib.Empty(cSNAS)) {
                /* cSNAS := cgo_operazioni->NASCOMUN */
                cSNAS = Cursor_cgo_operazioni.GetString("NASCOMUN");
              } // End If
              /* cCNAS := '' */
              cCNAS = "";
              /* cPNAS := 'EE' */
              cPNAS = "EE";
            } else { // Else
              /* cCNAS := '' */
              cCNAS = "";
              /* cPNAS := '' */
              cPNAS = "";
              // * --- Read from tbcitta
              m_cServer = m_Ctx.GetServer("tbcitta");
              m_cPhName = m_Ctx.GetPhName("tbcitta");
              m_cSql = "";
              m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NASCOMUN"),"C",60,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetString("NASCOMUN"));
              if (m_Ctx.IsSharedTemp("tbcitta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                cCNAS = Read_Cursor.GetString("CITTA");
                cPNAS = Read_Cursor.GetString("PROV");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_snai_oper_save returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                cCNAS = "";
                cPNAS = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(cCNAS) */
              if (CPLib.Empty(cCNAS)) {
                /* cCNAS := cgo_operazioni->NASCOMUN */
                cCNAS = Cursor_cgo_operazioni.GetString("NASCOMUN");
              } // End If
              /* cSNAS := '' */
              cSNAS = "";
            } // End If
          } else { // Else
            /* cSNAS := cgo_operazioni->NASSTATO */
            cSNAS = Cursor_cgo_operazioni.GetString("NASSTATO");
            /* cCNAS := cgo_operazioni->NASCOMUN */
            cCNAS = Cursor_cgo_operazioni.GetString("NASCOMUN");
            /* cPNAS := '' */
            cPNAS = "";
          } // End If
          /* xRiga1 := LibreriaMit.SpacePad(xCF,16) */
          xRiga1 = LibreriaMit.SpacePad(xCF,16);
          /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(xRagSoc,70) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad(xRagSoc,70);
          /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cgo_operazioni->DOMICILIO,35) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_operazioni.GetString("DOMICILIO"),35);
          /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cgo_operazioni->DESCCIT,30) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_operazioni.GetString("DESCCIT"),30);
          /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cgo_operazioni->PROVINCIA,2) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_operazioni.GetString("PROVINCIA"),2);
          /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(LRTrim(cgo_operazioni->CAP),5) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_cgo_operazioni.GetString("CAP")),5);
          /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cgo_operazioni->PAESE,3) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_operazioni.GetString("PAESE"),3);
          /* If cgo_operazioni->CFESTERO=0 */
          if (CPLib.eqr(Cursor_cgo_operazioni.GetDouble("CFESTERO"),0)) {
            /* xRiga1 := xRiga1 + LibreriaMit.SpacePad('600',3) */
            xRiga1 = xRiga1+LibreriaMit.SpacePad("600",3);
            /* xRiga1 := xRiga1 + LibreriaMit.SpacePad('   ',3) */
            xRiga1 = xRiga1+LibreriaMit.SpacePad("   ",3);
            /* xRiga1 := xRiga1 + LibreriaMit.SpacePad('600',3) */
            xRiga1 = xRiga1+LibreriaMit.SpacePad("600",3);
          } else { // Else
            /* xRiga1 := xRiga1 + LibreriaMit.SpacePad('77'+xFLGSAE,3) */
            xRiga1 = xRiga1+LibreriaMit.SpacePad("77"+xFLGSAE,3);
            /* xRiga1 := xRiga1 + LibreriaMit.SpacePad('   ',3) */
            xRiga1 = xRiga1+LibreriaMit.SpacePad("   ",3);
            /* xRiga1 := xRiga1 + LibreriaMit.SpacePad('711',3) */
            xRiga1 = xRiga1+LibreriaMit.SpacePad("711",3);
          } // End If
          /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(Left(cCNAS,30),30) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad(CPLib.Left(cCNAS,30),30);
          /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(cPNAS,2) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad(cPNAS,2);
          /* xRiga1 := xRiga1 + LibreriaMit.SpacePad(Left(cSNAS,30),30) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad(CPLib.Left(cSNAS,30),30);
          /* xRiga1 := xRiga1 + iif(DateToChar(_datnas) <> '01000101',LibreriaMit.SpacePad(DateToChar(_datnas),8),Space(8)) */
          xRiga1 = xRiga1+(CPLib.ne(CPLib.DateToChar(_datnas),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(_datnas),8):CPLib.Space(8));
          /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(_tipdoc,2) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad(_tipdoc,2);
          /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(cgo_operazioni->NUMDOCUM,15) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_operazioni.GetString("NUMDOCUM"),15);
          /* xRiga1 := xRiga1 + iif(DateToChar(_datemi) <> '01000101',LibreriaMit.SpacePad(DateToChar(_datemi),8),Space(8)) */
          xRiga1 = xRiga1+(CPLib.ne(CPLib.DateToChar(_datemi),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(_datemi),8):CPLib.Space(8));
          /* xRiga1 := xRiga1 + iif(DateToChar(_datval) <> '01000101',LibreriaMit.SpacePad(DateToChar(_datval),8),Space(8)) */
          xRiga1 = xRiga1+(CPLib.ne(CPLib.DateToChar(_datval),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(_datval),8):CPLib.Space(8));
          /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(cgo_operazioni->AUTRILASC,30) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_operazioni.GetString("AUTRILASC"),30);
          /* xRiga1 := xRiga1 +LibreriaMit.SpacePad(cgo_operazioni->PEP,1) */
          xRiga1 = xRiga1+LibreriaMit.SpacePad(Cursor_cgo_operazioni.GetString("PEP"),1);
          /* Crea la riga di confronto */
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCli1,"?",0,0,m_cServer, m_oParameters),m_cServer,cCli1)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* xRiga2 := LibreriaMit.SpacePad(personbo->CODFISC,16) */
            xRiga2 = LibreriaMit.SpacePad(Cursor_personbo.GetString("CODFISC"),16);
            /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->RAGSOC,70) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("RAGSOC"),70);
            /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->DOMICILIO,35) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("DOMICILIO"),35);
            /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->DESCCIT,30) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("DESCCIT"),30);
            /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->PROVINCIA,2) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("PROVINCIA"),2);
            /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(LRTrim(personbo->CAP),5) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_personbo.GetString("CAP")),5);
            /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->PAESE,3) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("PAESE"),3);
            /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->SOTGRUP,3) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("SOTGRUP"),3);
            /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->RAMOGRUP,3) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("RAMOGRUP"),3);
            /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->SETTSINT,3) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("SETTSINT"),3);
            /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(Left(personbo->NASCOMUN,30),30) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(CPLib.Left(Cursor_personbo.GetString("NASCOMUN"),30),30);
            /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->TIPINTER,2) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("TIPINTER"),2);
            /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(Left(personbo->NASSTATO,30),30) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(CPLib.Left(Cursor_personbo.GetString("NASSTATO"),30),30);
            /* xRiga2 := xRiga2 + iif(DateToChar(personbo->DATANASC) <> '01000101',LibreriaMit.SpacePad(DateToChar(personbo->DATANASC),8),Space(8)) */
            xRiga2 = xRiga2+(CPLib.ne(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),8):CPLib.Space(8));
            /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->TIPODOC,2) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("TIPODOC"),2);
            /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->NUMDOCUM,15) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("NUMDOCUM"),15);
            /* xRiga2 := xRiga2 + iif(DateToChar(personbo->DATARILASC) <> '01000101',LibreriaMit.SpacePad(DateToChar(personbo->DATARILASC),8),Space(8)) */
            xRiga2 = xRiga2+(CPLib.ne(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),8):CPLib.Space(8));
            /* xRiga2 := xRiga2 + iif(DateToChar(personbo->DATAVALI) <> '01000101',LibreriaMit.SpacePad(DateToChar(personbo->DATAVALI),8),Space(8)) */
            xRiga2 = xRiga2+(CPLib.ne(CPLib.DateToChar(Cursor_personbo.GetDate("DATAVALI")),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_personbo.GetDate("DATAVALI")),8):CPLib.Space(8));
            /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->AUTRILASC,30) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("AUTRILASC"),30);
            /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->PEP,1) */
            xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("PEP"),1);
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
          /* If Upper(LRTrim(xRiga1)) <> Upper(LRTrim(xRiga2)) */
          if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(xRiga1)),CPLib.Upper(CPLib.LRTrim(xRiga2)))) {
            /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(_codazi)+"'","",15) */
            cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(_codazi)+"'","",15);
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCli1,"?",0,0,m_cServer, m_oParameters),m_cServer,cCli1)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Insert into wersonbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"000000E3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000E3(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
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
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
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
            m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"000000E4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(xRagSoc,70),"C",70,0,m_cServer)+", ";
            m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(Cursor_cgo_operazioni.GetString("DOMICILIO"),35),"C",35,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(cDNAS,"D",8,0)+", ";
            m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.Left(cCNAS,30),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_operazioni.GetDouble("CFESTERO"),0)?"600":"77"+xFLGSAE),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL((CPLib.eqr(Cursor_cgo_operazioni.GetDouble("CFESTERO"),0)?"600":"711"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(_tipdoc,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(Cursor_cgo_operazioni.GetString("NUMDOCUM"),15),"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(_datemi,"D",8,0)+", ";
            m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(Cursor_cgo_operazioni.GetString("DESCCIT"),30),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PAESE"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CAP"),"C",9,0,m_cServer)+", ";
            m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SESSO"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(_datval,"D",8,0)+", ";
            m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("COGNOME"),"C",26,0,m_cServer)+", ";
            m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NOME"),"C",25,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(cPNAS,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(xCFE,"N",1,0)+", ";
            m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.Left(cSNAS,30),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"PEP = "+CPLib.ToSQL((CPLib.Empty(Cursor_cgo_operazioni.GetString("PEP"))?"N":Cursor_cgo_operazioni.GetString("PEP")),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL("P","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
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
              m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
            }
            /* _codfisc := '' */
            _codfisc = "";
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAINI,DATAFINE,RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If cgo_operazioni->DATAOPE >= intestbo->DATAINI and (Empty(intestbo->DATAFINE) or intestbo->DATAFINE >= cgo_operazioni->DATAOPE) */
              if (CPLib.ge(Cursor_cgo_operazioni.GetDate("DATAOPE"),Cursor_intestbo.GetDate("DATAINI")) && (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")) || CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_cgo_operazioni.GetDate("DATAOPE")))) {
                /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(_codazi)+"'",'',10) */
                cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(_codazi)+"'","",10);
                /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(_codazi)+"'",'',11) */
                cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(_codazi)+"'","",11);
                /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(_codazi)+"'",0,15) */
                nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(_codazi)+"'",0,15),0);
                /* cColleg := 'I'+cInfProg2 */
                cColleg = "I"+cInfProg2;
                // * --- Insert into rapopebo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("rapopebo");
                m_cPhName = m_Ctx.GetPhName("rapopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"000000EC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000EC(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cColleg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date())+cInfProg1+"0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull("31","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
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
                /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(_codazi)+"'",'',10) */
                cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(_codazi)+"'","",10);
                /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(_codazi)+"'",'',11) */
                cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(_codazi)+"'","",11);
                /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(_codazi)+"'",0,15) */
                nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(_codazi)+"'",0,15),0);
                // * --- Insert into rapopebo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("rapopebo");
                m_cPhName = m_Ctx.GetPhName("rapopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"000000F0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000F0(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cabinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cColleg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_citinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date())+cInfProg1+"0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_prvinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull("32","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
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
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } // End If
          // * --- Read from personbo_agg
          m_cServer = m_Ctx.GetServer("personbo_agg");
          m_cPhName = m_Ctx.GetPhName("personbo_agg");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"C",16,0,m_cServer),m_cServer,_connes);
          if (m_Ctx.IsSharedTemp("personbo_agg")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _codfisc = Read_Cursor.GetString("CONNES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo_agg into routine arrt_snai_oper_save returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _codfisc = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_codfisc)) */
          if (CPLib.Empty(CPLib.LRTrim(_codfisc))) {
            // * --- Insert into personbo_agg from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo_agg");
            m_cPhName = m_Ctx.GetPhName("personbo_agg");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"000000F3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000F3(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("RDCODAUT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("RDLOCAUT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMTEL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SNAINUMOPE"),"?",0,0,m_cServer)+", ";
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
            }
          } else { // Else
            // * --- Write into personbo_agg from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo_agg");
            m_cPhName = m_Ctx.GetPhName("personbo_agg");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"000000F4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"RDCODAUT = "+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("RDCODAUT"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"RDLOCAUT = "+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("RDLOCAUT"),"C",20,0,m_cServer)+", ";
            m_cSql = m_cSql+"NUMTEL = "+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMTEL"),"C",20,0,m_cServer)+", ";
            m_cSql = m_cSql+"LASTOPER = "+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SNAINUMOPE"),"C",15,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
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
            }
          } // End If
          /* Exec Routine arrt_writelog('SAVE','PERSONBO',_connes,"",'I') */
          arrt_writelogR.Make(m_Ctx,this).Run("SAVE","PERSONBO",_connes,"","I");
        } // End If
        Cursor_cgo_operazioni.Next();
      }
      m_cConnectivityError = Cursor_cgo_operazioni.ErrorMessage();
      Cursor_cgo_operazioni.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cgo_operazioni!=null)
          Cursor_cgo_operazioni.Close();
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
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_cgo_operazioni=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_inter2bo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_cgo_qadv_operazioni_dl=null;
    CPResultSet Cursor_cgo_operazioni_dl_multi_dt=null;
    CPResultSet Cursor_cgo_operazioni_dl_multi_dt_dc=null;
    try {
      /* _cauana Char(4) */
      String _cauana;
      _cauana = CPLib.Space(4);
      /* _causin Char(2) */
      String _causin;
      _causin = CPLib.Space(2);
      /* _segno Char(1) */
      String _segno;
      _segno = CPLib.Space(1);
      /* cOpeProg1 Char(10) */
      String cOpeProg1;
      cOpeProg1 = CPLib.Space(10);
      /* cOpeProg2 Char(11) */
      String cOpeProg2;
      cOpeProg2 = CPLib.Space(11);
      /* abicab Char(11) */
      String abicab;
      abicab = CPLib.Space(11);
      /* _mezpagam Char(1) */
      String _mezpagam;
      _mezpagam = CPLib.Space(1);
      /* _tipope Char(2) */
      String _tipope;
      _tipope = CPLib.Space(2);
      /* xSNAINUMOPE Char(15) */
      String xSNAINUMOPE;
      xSNAINUMOPE = CPLib.Space(15);
      // * --- Select from cgo_operazioni
      m_cServer = m_Ctx.GetServer("cgo_operazioni");
      m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
      if (Cursor_cgo_operazioni!=null)
        Cursor_cgo_operazioni.Close();
      Cursor_cgo_operazioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pSNAINUMOPE,"?",0,0,m_cServer, m_oParameters),m_cServer,pSNAINUMOPE)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_operazioni.Eof())) {
        /* _cauana := '' */
        _cauana = "";
        /* _causin := '' */
        _causin = "";
        /* _segno := '' */
        _segno = "";
        /* _mezpagam := iif(LRTrim(cgo_operazioni->MEZPAGAM) <> 'I' and LRTrim(cgo_operazioni->MEZPAGAM) <> 'E','A',LRTrim(cgo_operazioni->MEZPAGAM)) */
        _mezpagam = (CPLib.ne(CPLib.LRTrim(Cursor_cgo_operazioni.GetString("MEZPAGAM")),"I") && CPLib.ne(CPLib.LRTrim(Cursor_cgo_operazioni.GetString("MEZPAGAM")),"E")?"A":CPLib.LRTrim(Cursor_cgo_operazioni.GetString("MEZPAGAM")));
        // * --- Read from cgo_causali
        m_cServer = m_Ctx.GetServer("cgo_causali");
        m_cPhName = m_Ctx.GetPhName("cgo_causali");
        m_cSql = "";
        m_cSql = m_cSql+"CACODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("CACODICE"),"N",5,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetDouble("CACODICE"));
        m_cSql = m_cSql+" and CATIPOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_mezpagam,"C",2,0,m_cServer),m_cServer,_mezpagam);
        if (m_Ctx.IsSharedTemp("cgo_causali")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CACODANA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CACODSIN",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CASEGNO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _cauana = Read_Cursor.GetString("CACODANA");
          _causin = Read_Cursor.GetString("CACODSIN");
          _segno = Read_Cursor.GetString("CASEGNO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cgo_causali into routine arrt_snai_oper_save returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _cauana = "";
          _causin = "";
          _segno = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If _cauana <> '26' and _cauana <> '48' and _cauana <> 'AA' */
        if (CPLib.ne(_cauana,"26") && CPLib.ne(_cauana,"48") && CPLib.ne(_cauana,"AA")) {
          /* _tipope := '10' */
          _tipope = "10";
        } else { // Else
          /* If cgo_operazioni->TOTCONT <> 0 or cgo_operazioni->IMPWALLET <> 0 */
          if (CPLib.ne(Cursor_cgo_operazioni.GetDouble("TOTCONT"),0) || CPLib.ne(Cursor_cgo_operazioni.GetDouble("IMPWALLET"),0)) {
            /* _tipope := '10' */
            _tipope = "10";
          } else { // Else
            /* If _segno = 'D' */
            if (CPLib.eqr(_segno,"D")) {
              /* _tipope := '11' */
              _tipope = "11";
            } else { // Else
              /* _tipope := '12' */
              _tipope = "12";
            } // End If
          } // End If
        } // End If
        /* cOpeProg1 := Utilities.GetAutonumber("PPOPER1\'"+LRTrim(_codazi)+"'",'',10) */
        cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER1\\'"+CPLib.LRTrim(_codazi)+"'","",10);
        /* cOpeProg2 := Utilities.GetAutonumber("PPOPER2\'"+LRTrim(_codazi)+"'",'',11) */
        cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER2\\'"+CPLib.LRTrim(_codazi)+"'","",11);
        /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(_codazi)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(_codazi)+"'",0,15),0);
        // * --- Insert into xperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xperazbo");
        m_cPhName = m_Ctx.GetPhName("xperazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000111")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000111(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_operazioni.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_operazioni.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_operazioni.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cauana,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODCABDIP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_causin,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDate("DATAOPE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDate("DATAREG"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("DESCCITDIP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.gt(Cursor_cgo_operazioni.GetDouble("TOTCONT"),0)?"1":"0"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_cgo_operazioni.GetDate("DATAOPE"))+cOpeProg2+"Z","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("PROVINCIADIP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("TOTCONT")*100,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("TOTLIRE")*100,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CGOTIPOPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
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
        }
        // * --- Insert into xperazbo_agg from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xperazbo_agg");
        m_cPhName = m_Ctx.GetPhName("xperazbo_agg");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo_agg",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000112")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000112(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("CACODICE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDateTime("CADATAORA"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("CATIPGIO"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("CATIPCON"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetDouble("CAPV_COD"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("IDDOCALL"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("VLTPLAT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xperazbo_agg",true);
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
        /* If cgo_operazioni->MEZPAGAM='I' or cgo_operazioni->MEZPAGAM='E' or cgo_operazioni->MEZPAGAM='P' */
        if (CPLib.eqr(Cursor_cgo_operazioni.GetString("MEZPAGAM"),"I") || CPLib.eqr(Cursor_cgo_operazioni.GetString("MEZPAGAM"),"E") || CPLib.eqr(Cursor_cgo_operazioni.GetString("MEZPAGAM"),"P")) {
          /* If Left(Upper(cgo_operazioni->IBAN),2)='IT' */
          if (CPLib.eqr(CPLib.Left(CPLib.Upper(Cursor_cgo_operazioni.GetString("IBAN")),2),"IT")) {
            /* abicab := Substr(cgo_operazioni->IBAN,6,5)+"-"+Substr(cgo_operazioni->IBAN,11,5) */
            abicab = CPLib.Substr(Cursor_cgo_operazioni.GetString("IBAN"),6,5)+"-"+CPLib.Substr(Cursor_cgo_operazioni.GetString("IBAN"),11,5);
            // * --- Write into xperazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000116")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL("02","C",2,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
            // * --- Select from inter2bo
            m_cServer = m_Ctx.GetServer("inter2bo");
            m_cPhName = m_Ctx.GetPhName("inter2bo");
            if (Cursor_inter2bo!=null)
              Cursor_inter2bo.Close();
            Cursor_inter2bo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(abicab,"?",0,0,m_cServer, m_oParameters),m_cServer,abicab)+" "+")"+(m_Ctx.IsSharedTemp("inter2bo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_inter2bo.Eof())) {
              // * --- Write into xperazbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xperazbo");
              m_cPhName = m_Ctx.GetPhName("xperazbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000118")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_inter2bo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(Cursor_inter2bo.GetString("RAGSOC"),"C",50,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
              Cursor_inter2bo.Next();
            }
            m_cConnectivityError = Cursor_inter2bo.ErrorMessage();
            Cursor_inter2bo.Close();
            // * --- End Select
          } else { // Else
            /* abicab := Left(Upper(cgo_operazioni->IBAN),11) */
            abicab = CPLib.Left(CPLib.Upper(Cursor_cgo_operazioni.GetString("IBAN")),11);
            // * --- Write into xperazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"0000011A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CODINT2 = "+CPLib.ToSQL(abicab,"C",11,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL("12","C",2,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            // * --- Write into xperazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"0000011C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
            m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
            m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
            m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"C",16,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } // End If
        /* Exec Routine arrt_writelog('SAVE','XPERAZBO',pSNAINUMOPE,"","I") */
        arrt_writelogR.Make(m_Ctx,this).Run("SAVE","XPERAZBO",pSNAINUMOPE,"","I");
        /* If cgo_operazioni->TIPOPEDL='S' */
        if (CPLib.eqr(Cursor_cgo_operazioni.GetString("TIPOPEDL"),"S")) {
          /* If not(Empty(LRTrim(cgo_operazioni->NUMOPEDL))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_cgo_operazioni.GetString("NUMOPEDL"))))) {
            // * --- Delete from cgo_operazioni_dl
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_operazioni_dl");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000120")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMOPEDL"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetString("NUMOPEDL"))+"";
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
            /* If cgo_operazioni->TIPOGIOCO='V' */
            if (CPLib.eqr(Cursor_cgo_operazioni.GetString("TIPOGIOCO"),"V")) {
              /* _snainumope := '' */
              _snainumope = "";
              // * --- Read from cgo_qadv_operazioni_dl
              m_cServer = m_Ctx.GetServer("cgo_qadv_operazioni_dl");
              m_cPhName = m_Ctx.GetPhName("cgo_qadv_operazioni_dl");
              m_cSql = "";
              m_cSql = m_cSql+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMOPEDL"),"C",15,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetString("NUMOPEDL"));
              if (m_Ctx.IsSharedTemp("cgo_qadv_operazioni_dl")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SNAINUMOPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _snainumope = Read_Cursor.GetString("SNAINUMOPE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on cgo_qadv_operazioni_dl into routine arrt_snai_oper_save returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _snainumope = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If not(Empty(LRTrim(_snainumope))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(_snainumope)))) {
                // * --- Select from cgo_qadv_operazioni_dl
                m_cServer = m_Ctx.GetServer("cgo_qadv_operazioni_dl");
                m_cPhName = m_Ctx.GetPhName("cgo_qadv_operazioni_dl");
                if (Cursor_cgo_qadv_operazioni_dl!=null)
                  Cursor_cgo_qadv_operazioni_dl.Close();
                Cursor_cgo_qadv_operazioni_dl = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMOPEDL"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_qadv_operazioni_dl")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_cgo_qadv_operazioni_dl.Eof())) {
                  // * --- Insert into cgo_qadv_operazioni_storico from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cgo_qadv_operazioni_storico");
                  m_cPhName = m_Ctx.GetPhName("cgo_qadv_operazioni_storico");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_qadv_operazioni_storico",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000126")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000126(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SNAINUMOPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_DOMANDA01"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_PUNTEGGIO01"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_DOMANDA02"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_PUNTEGGIO02"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_DOMANDA03"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetString("QADV_DOMANDA03_1"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetString("QADV_DOMANDA03_2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetString("QADV_DOMANDA03_3"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_PUNTEGGIO03"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetString("QADV_MOTIVO03"),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_DOMANDA04"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetString("QADV_DOMANDA04_1"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetString("QADV_DOMANDA04_2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetString("QADV_DOMANDA04_3"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetString("QADV_DOMANDA04_4"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_PUNTEGGIO04"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetString("QADV_MOTIVO04"),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_DOMANDA05"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_PUNTEGGIO05"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetString("QADV_MOTIVO05"),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_DOMANDA06"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_PUNTEGGIO06"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_DOMANDA07"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_PUNTEGGIO07"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_DOMANDA08"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_PUNTEGGIO08"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_DOMANDA09"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_PUNTEGGIO09"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_DOMANDA10"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_PUNTEGGIO10"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_DOMANDA11"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_PUNTEGGIO11"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_DOMANDA12"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_PUNTEGGIO12"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetString("QADV_FLGCOMPLETO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_qadv_operazioni_dl.GetDouble("QADV_TOTALE"),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_qadv_operazioni_storico",true);
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
                  Cursor_cgo_qadv_operazioni_dl.Next();
                }
                m_cConnectivityError = Cursor_cgo_qadv_operazioni_dl.ErrorMessage();
                Cursor_cgo_qadv_operazioni_dl.Close();
                // * --- End Select
                // * --- Delete from cgo_qadv_operazioni_dl
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_qadv_operazioni_dl");
                m_cPhName = m_Ctx.GetPhName("cgo_qadv_operazioni_dl");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_qadv_operazioni_dl",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000127")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMOPEDL"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetString("NUMOPEDL"))+"";
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
          } // End If
          /* ElseIf cgo_operazioni->TIPOPEDL='M' */
        } else if (CPLib.eqr(Cursor_cgo_operazioni.GetString("TIPOPEDL"),"M")) {
          /* xSNAINUMOPE := '' */
          xSNAINUMOPE = "";
          // * --- Select from cgo_operazioni_dl_multi_dt
          m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
          if (Cursor_cgo_operazioni_dl_multi_dt!=null)
            Cursor_cgo_operazioni_dl_multi_dt.Close();
          Cursor_cgo_operazioni_dl_multi_dt = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMOPEDL"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi_dt")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_operazioni_dl_multi_dt.Eof())) {
            // * --- Insert into cgo_operazioni_storico_multi from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_operazioni_storico_multi");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico_multi");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_storico_multi",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"0000012A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000012A(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SNAINUMOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetDouble("CPROWNUM"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetString("FLGFULL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetString("CGOTIPOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetDate("DATOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetString("NUMOPEDL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetDouble("CACODICE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetDouble("CATIPGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt.GetDouble("CATIPCON"),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_operazioni_storico_multi",true);
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
            Cursor_cgo_operazioni_dl_multi_dt.Next();
          }
          m_cConnectivityError = Cursor_cgo_operazioni_dl_multi_dt.ErrorMessage();
          Cursor_cgo_operazioni_dl_multi_dt.Close();
          // * --- End Select
          // * --- Delete from cgo_operazioni_dl_multi_dt
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi_dt",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"0000012B")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMOPEDL"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetString("NUMOPEDL"))+"";
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
          // * --- Delete from cgo_operazioni_dl_multi
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"0000012C")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMOPEDL"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetString("NUMOPEDL"))+"";
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
          /* ElseIf cgo_operazioni->TIPOPEDL='D' */
        } else if (CPLib.eqr(Cursor_cgo_operazioni.GetString("TIPOPEDL"),"D")) {
          /* xSNAINUMOPE := '' */
          xSNAINUMOPE = "";
          // * --- Select from cgo_operazioni_dl_multi_dt_dc
          m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt_dc");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt_dc");
          if (Cursor_cgo_operazioni_dl_multi_dt_dc!=null)
            Cursor_cgo_operazioni_dl_multi_dt_dc.Close();
          Cursor_cgo_operazioni_dl_multi_dt_dc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMOPEDL"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl_multi_dt_dc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_operazioni_dl_multi_dt_dc.Eof())) {
            // * --- Insert into cgo_operazioni_storico_multi from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_operazioni_storico_multi");
            m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico_multi");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_storico_multi",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"0000012F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000012F(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni.GetString("SNAINUMOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetDouble("CPROWNUM"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("FLGFULL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("CGOTIPOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetDate("DATOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("NUMOPEDL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetDouble("CACODICE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetDouble("CATIPGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_operazioni_dl_multi_dt_dc.GetDouble("CATIPCON"),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_operazioni_storico_multi",true);
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
            Cursor_cgo_operazioni_dl_multi_dt_dc.Next();
          }
          m_cConnectivityError = Cursor_cgo_operazioni_dl_multi_dt_dc.ErrorMessage();
          Cursor_cgo_operazioni_dl_multi_dt_dc.Close();
          // * --- End Select
          // * --- Delete from cgo_operazioni_dl_multi_dt_dc
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt_dc");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt_dc");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi_dt_dc",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000130")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMOPEDL"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetString("NUMOPEDL"))+"";
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
          // * --- Delete from cgo_operazioni_dl_multi_dc
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dc");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dc");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi_dc",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_snai_oper_save",155,"00000131")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_operazioni.GetString("NUMOPEDL"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_operazioni.GetString("NUMOPEDL"))+"";
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
        Cursor_cgo_operazioni.Next();
      }
      m_cConnectivityError = Cursor_cgo_operazioni.ErrorMessage();
      Cursor_cgo_operazioni.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cgo_operazioni!=null)
          Cursor_cgo_operazioni.Close();
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
        if (Cursor_inter2bo!=null)
          Cursor_inter2bo.Close();
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
        if (Cursor_cgo_qadv_operazioni_dl!=null)
          Cursor_cgo_qadv_operazioni_dl.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_operazioni_dl_multi_dt!=null)
          Cursor_cgo_operazioni_dl_multi_dt.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_operazioni_dl_multi_dt_dc!=null)
          Cursor_cgo_operazioni_dl_multi_dt_dc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pSNAINUMOPE,String p_pTipo,String p_pAzi) {
    pSNAINUMOPE = p_pSNAINUMOPE;
    pTipo = p_pTipo;
    pAzi = p_pAzi;
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
  public Forward Run(String p_pSNAINUMOPE,String p_pTipo,String p_pAzi) {
    pSNAINUMOPE = p_pSNAINUMOPE;
    pTipo = p_pTipo;
    pAzi = p_pAzi;
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
  public static arrt_snai_oper_saveR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_snai_oper_saveR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pSNAINUMOPE = CPLib.Space(15);
    pTipo = CPLib.Space(1);
    pAzi = CPLib.Space(10);
    nProgImp = 0;
    cInfProg1 = CPLib.Space(10);
    cInfProg2 = CPLib.Space(11);
    _tipinter = CPLib.Space(2);
    _codinter = CPLib.Space(11);
    _citinter = CPLib.Space(30);
    _cabinter = CPLib.Space(6);
    _prvinter = CPLib.Space(2);
    _limoper = 0;
    _flgvlt = CPLib.Space(1);
    _flgvnp = CPLib.Space(1);
    _oldazi = CPLib.Space(10);
    _codazi = CPLib.Space(10);
    _datfin = CPLib.NullDate();
    _datdip = CPLib.NullDate();
    _codfisc = CPLib.Space(16);
    _connes = CPLib.Space(16);
    _mezpag = CPLib.Space(1);
    _numasg = CPLib.Space(25);
    xFLGSAE = CPLib.Space(1);
    cColleg = CPLib.Space(12);
    _oldute = 0;
    _snainumope = CPLib.Space(15);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    cActLog=m_Ctx.GetGlobalString("cActLog");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_writelog,
  public static final String i_InvokedRoutines = ",arrt_writelog,";
  public static String[] m_cRunParameterNames={"pSNAINUMOPE","pTipo","pAzi"};
  protected static String GetFieldsName_00000041(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DOMICILIO,";
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
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCITDIP,";
    p_cSql = p_cSql+"PROVINCIADIP,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESEICP,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTERCP,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNALTRO,";
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
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"MEZPAGAM,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"CGOFLGVLT,";
    p_cSql = p_cSql+"CGOFLGVNP,";
    p_cSql = p_cSql+"CGOTIPOPE,";
    p_cSql = p_cSql+"NUMOPEDL,";
    p_cSql = p_cSql+"CGODIPCOM,";
    p_cSql = p_cSql+"CAFLGOPE,";
    p_cSql = p_cSql+"CGODATDIPCOM,";
    p_cSql = p_cSql+"CGODATFINCOM,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"ASSEGNO,";
    p_cSql = p_cSql+"CGODATCON,";
    p_cSql = p_cSql+"CGOESICON,";
    p_cSql = p_cSql+"CGONOTCON,";
    p_cSql = p_cSql+"CADATIMP,";
    p_cSql = p_cSql+"RDCODAUT,";
    p_cSql = p_cSql+"RDLOCAUT,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+"VLTPLAT,";
    p_cSql = p_cSql+"CC4CIFRE,";
    p_cSql = p_cSql+"CCDATSCA,";
    p_cSql = p_cSql+"NUMTEL,";
    p_cSql = p_cSql+"IDDOCALL,";
    p_cSql = p_cSql+"FLGDOCALL,";
    p_cSql = p_cSql+"CCANNSCA,";
    p_cSql = p_cSql+"CCMESSCA,";
    p_cSql = p_cSql+"PEPDESCRI,";
    p_cSql = p_cSql+"DOMICILIO2,";
    p_cSql = p_cSql+"DESCCIT2,";
    p_cSql = p_cSql+"PROVINCIA2,";
    p_cSql = p_cSql+"PAESE2,";
    p_cSql = p_cSql+"CAP2,";
    p_cSql = p_cSql+"FLGDOM,";
    p_cSql = p_cSql+"PROFESSIONE,";
    p_cSql = p_cSql+"FLAGWALLET,";
    p_cSql = p_cSql+"IMPWALLET,";
    p_cSql = p_cSql+"CODWALLET,";
    p_cSql = p_cSql+"CODTRANSZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_operazioni_storico",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000047(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"QADV_DOMANDA01,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO01,";
    p_cSql = p_cSql+"QADV_DOMANDA02,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO02,";
    p_cSql = p_cSql+"QADV_DOMANDA03,";
    p_cSql = p_cSql+"QADV_DOMANDA03_1,";
    p_cSql = p_cSql+"QADV_DOMANDA03_2,";
    p_cSql = p_cSql+"QADV_DOMANDA03_3,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO03,";
    p_cSql = p_cSql+"QADV_MOTIVO03,";
    p_cSql = p_cSql+"QADV_DOMANDA04,";
    p_cSql = p_cSql+"QADV_DOMANDA04_1,";
    p_cSql = p_cSql+"QADV_DOMANDA04_2,";
    p_cSql = p_cSql+"QADV_DOMANDA04_3,";
    p_cSql = p_cSql+"QADV_DOMANDA04_4,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO04,";
    p_cSql = p_cSql+"QADV_MOTIVO04,";
    p_cSql = p_cSql+"QADV_DOMANDA05,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO05,";
    p_cSql = p_cSql+"QADV_MOTIVO05,";
    p_cSql = p_cSql+"QADV_DOMANDA06,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO06,";
    p_cSql = p_cSql+"QADV_DOMANDA07,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO07,";
    p_cSql = p_cSql+"QADV_DOMANDA08,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO08,";
    p_cSql = p_cSql+"QADV_DOMANDA09,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO09,";
    p_cSql = p_cSql+"QADV_DOMANDA10,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO10,";
    p_cSql = p_cSql+"QADV_DOMANDA11,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO11,";
    p_cSql = p_cSql+"QADV_DOMANDA12,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO12,";
    p_cSql = p_cSql+"QADV_FLGCOMPLETO,";
    p_cSql = p_cSql+"QADV_TOTALE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_qadv_operazioni_storico",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000083(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000084(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RDCODAUT,";
    p_cSql = p_cSql+"RDLOCAUT,";
    p_cSql = p_cSql+"NUMTEL,";
    p_cSql = p_cSql+"LASTOPER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000EC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RDCODAUT,";
    p_cSql = p_cSql+"RDLOCAUT,";
    p_cSql = p_cSql+"NUMTEL,";
    p_cSql = p_cSql+"LASTOPER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000111(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000112(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000126(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"QADV_DOMANDA01,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO01,";
    p_cSql = p_cSql+"QADV_DOMANDA02,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO02,";
    p_cSql = p_cSql+"QADV_DOMANDA03,";
    p_cSql = p_cSql+"QADV_DOMANDA03_1,";
    p_cSql = p_cSql+"QADV_DOMANDA03_2,";
    p_cSql = p_cSql+"QADV_DOMANDA03_3,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO03,";
    p_cSql = p_cSql+"QADV_MOTIVO03,";
    p_cSql = p_cSql+"QADV_DOMANDA04,";
    p_cSql = p_cSql+"QADV_DOMANDA04_1,";
    p_cSql = p_cSql+"QADV_DOMANDA04_2,";
    p_cSql = p_cSql+"QADV_DOMANDA04_3,";
    p_cSql = p_cSql+"QADV_DOMANDA04_4,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO04,";
    p_cSql = p_cSql+"QADV_MOTIVO04,";
    p_cSql = p_cSql+"QADV_DOMANDA05,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO05,";
    p_cSql = p_cSql+"QADV_MOTIVO05,";
    p_cSql = p_cSql+"QADV_DOMANDA06,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO06,";
    p_cSql = p_cSql+"QADV_DOMANDA07,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO07,";
    p_cSql = p_cSql+"QADV_DOMANDA08,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO08,";
    p_cSql = p_cSql+"QADV_DOMANDA09,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO09,";
    p_cSql = p_cSql+"QADV_DOMANDA10,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO10,";
    p_cSql = p_cSql+"QADV_DOMANDA11,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO11,";
    p_cSql = p_cSql+"QADV_DOMANDA12,";
    p_cSql = p_cSql+"QADV_PUNTEGGIO12,";
    p_cSql = p_cSql+"QADV_FLGCOMPLETO,";
    p_cSql = p_cSql+"QADV_TOTALE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_qadv_operazioni_storico",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"FLGFULL,";
    p_cSql = p_cSql+"CGOTIPOPE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"NUMOPEDL,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_operazioni_storico_multi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"FLGFULL,";
    p_cSql = p_cSql+"CGOTIPOPE,";
    p_cSql = p_cSql+"DATOPE,";
    p_cSql = p_cSql+"NUMOPEDL,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_operazioni_storico_multi",true);
    return p_cSql;
  }
}
