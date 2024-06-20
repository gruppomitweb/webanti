// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_riordinaR implements CallerWithObjs {
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
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_jperazbo;
  public String m_cServer_jperazbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
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
  public String m_cPhName_tmp_beneficope_ol;
  public String m_cServer_tmp_beneficope_ol;
  public String m_cPhName_tmp_clientiope_ol;
  public String m_cServer_tmp_clientiope_ol;
  public String m_cPhName_tmp_fraziobo_ol;
  public String m_cServer_tmp_fraziobo_ol;
  public String m_cPhName_tmp_operazbo_ol;
  public String m_cServer_tmp_operazbo_ol;
  public String m_cPhName_tmp_rapopebo;
  public String m_cServer_tmp_rapopebo;
  public String m_cPhName_tmp_rapotit;
  public String m_cServer_tmp_rapotit;
  public String m_cPhName_tmp_sogopebo_ol;
  public String m_cServer_tmp_sogopebo_ol;
  public String m_cPhName_tmp_terzistiope_ol;
  public String m_cServer_tmp_terzistiope_ol;
  public String m_cPhName_zperazbo;
  public String m_cServer_zperazbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
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
  public String w_frzuif;
  public String w_opeage;
  public String w_opeuif;
  public String w_rapage;
  public String w_rapuif;
  public String w_titaui;
  public String w_flgpart;
  public double w_prgidb;
  public double w_prgnprg;
  public double w_prgiope;
  public java.sql.Date w_daData;
  public String w_dataover;
  public double w_ngiorni;
  public String cProg;
  public String cProg1;
  public String cIDBASE;
  public String cIDB2;
  public String cIdReg;
  public String cIdMod;
  public String cTipRap;
  public String cFlgRap;
  public double cPrgImp;
  public String cOldProg;
  public String w_cDATREG;
  public double _conta;
  public String mycProg;
  public double mycPrgImp;
  public String gAzienda;
  public String gMsgImp;
  public String gFlgWU;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_riordinaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_riordina",m_Caller);
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
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    if (m_cPhName_japopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japopebo = m_cPhName_japopebo+" "+m_Ctx.GetWritePhName("japopebo");
    }
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
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
    m_cPhName_jperazbo = p_ContextObject.GetPhName("jperazbo");
    if (m_cPhName_jperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jperazbo = m_cPhName_jperazbo+" "+m_Ctx.GetWritePhName("jperazbo");
    }
    m_cServer_jperazbo = p_ContextObject.GetServer("jperazbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
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
    if (m_Ctx.IsTmpAlreadyCreated("tmp_beneficope_ol")) {
      m_cPhName_tmp_beneficope_ol = p_ContextObject.GetPhName("tmp_beneficope_ol");
      if (m_cPhName_tmp_beneficope_ol.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_beneficope_ol = m_cPhName_tmp_beneficope_ol+" "+m_Ctx.GetWritePhName("tmp_beneficope_ol");
      }
      m_cServer_tmp_beneficope_ol = p_ContextObject.GetServer("tmp_beneficope_ol");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_clientiope_ol")) {
      m_cPhName_tmp_clientiope_ol = p_ContextObject.GetPhName("tmp_clientiope_ol");
      if (m_cPhName_tmp_clientiope_ol.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_clientiope_ol = m_cPhName_tmp_clientiope_ol+" "+m_Ctx.GetWritePhName("tmp_clientiope_ol");
      }
      m_cServer_tmp_clientiope_ol = p_ContextObject.GetServer("tmp_clientiope_ol");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_fraziobo_ol")) {
      m_cPhName_tmp_fraziobo_ol = p_ContextObject.GetPhName("tmp_fraziobo_ol");
      if (m_cPhName_tmp_fraziobo_ol.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_fraziobo_ol = m_cPhName_tmp_fraziobo_ol+" "+m_Ctx.GetWritePhName("tmp_fraziobo_ol");
      }
      m_cServer_tmp_fraziobo_ol = p_ContextObject.GetServer("tmp_fraziobo_ol");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_operazbo_ol")) {
      m_cPhName_tmp_operazbo_ol = p_ContextObject.GetPhName("tmp_operazbo_ol");
      if (m_cPhName_tmp_operazbo_ol.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_operazbo_ol = m_cPhName_tmp_operazbo_ol+" "+m_Ctx.GetWritePhName("tmp_operazbo_ol");
      }
      m_cServer_tmp_operazbo_ol = p_ContextObject.GetServer("tmp_operazbo_ol");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_rapopebo")) {
      m_cPhName_tmp_rapopebo = p_ContextObject.GetPhName("tmp_rapopebo");
      if (m_cPhName_tmp_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_rapopebo = m_cPhName_tmp_rapopebo+" "+m_Ctx.GetWritePhName("tmp_rapopebo");
      }
      m_cServer_tmp_rapopebo = p_ContextObject.GetServer("tmp_rapopebo");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_rapotit")) {
      m_cPhName_tmp_rapotit = p_ContextObject.GetPhName("tmp_rapotit");
      if (m_cPhName_tmp_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_rapotit = m_cPhName_tmp_rapotit+" "+m_Ctx.GetWritePhName("tmp_rapotit");
      }
      m_cServer_tmp_rapotit = p_ContextObject.GetServer("tmp_rapotit");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_sogopebo_ol")) {
      m_cPhName_tmp_sogopebo_ol = p_ContextObject.GetPhName("tmp_sogopebo_ol");
      if (m_cPhName_tmp_sogopebo_ol.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_sogopebo_ol = m_cPhName_tmp_sogopebo_ol+" "+m_Ctx.GetWritePhName("tmp_sogopebo_ol");
      }
      m_cServer_tmp_sogopebo_ol = p_ContextObject.GetServer("tmp_sogopebo_ol");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_terzistiope_ol")) {
      m_cPhName_tmp_terzistiope_ol = p_ContextObject.GetPhName("tmp_terzistiope_ol");
      if (m_cPhName_tmp_terzistiope_ol.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_terzistiope_ol = m_cPhName_tmp_terzistiope_ol+" "+m_Ctx.GetWritePhName("tmp_terzistiope_ol");
      }
      m_cServer_tmp_terzistiope_ol = p_ContextObject.GetServer("tmp_terzistiope_ol");
    }
    m_cPhName_zperazbo = p_ContextObject.GetPhName("zperazbo");
    if (m_cPhName_zperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_zperazbo = m_cPhName_zperazbo+" "+m_Ctx.GetWritePhName("zperazbo");
    }
    m_cServer_zperazbo = p_ContextObject.GetServer("zperazbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("prgidb",p_cVarName)) {
      return w_prgidb;
    }
    if (CPLib.eqr("prgnprg",p_cVarName)) {
      return w_prgnprg;
    }
    if (CPLib.eqr("prgiope",p_cVarName)) {
      return w_prgiope;
    }
    if (CPLib.eqr("ngiorni",p_cVarName)) {
      return w_ngiorni;
    }
    if (CPLib.eqr("cPrgImp",p_cVarName)) {
      return cPrgImp;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("mycPrgImp",p_cVarName)) {
      return mycPrgImp;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_riordina";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("frzuif",p_cVarName)) {
      return w_frzuif;
    }
    if (CPLib.eqr("opeage",p_cVarName)) {
      return w_opeage;
    }
    if (CPLib.eqr("opeuif",p_cVarName)) {
      return w_opeuif;
    }
    if (CPLib.eqr("rapage",p_cVarName)) {
      return w_rapage;
    }
    if (CPLib.eqr("rapuif",p_cVarName)) {
      return w_rapuif;
    }
    if (CPLib.eqr("titaui",p_cVarName)) {
      return w_titaui;
    }
    if (CPLib.eqr("flgpart",p_cVarName)) {
      return w_flgpart;
    }
    if (CPLib.eqr("dataover",p_cVarName)) {
      return w_dataover;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("cProg1",p_cVarName)) {
      return cProg1;
    }
    if (CPLib.eqr("cIDBASE",p_cVarName)) {
      return cIDBASE;
    }
    if (CPLib.eqr("cIDB2",p_cVarName)) {
      return cIDB2;
    }
    if (CPLib.eqr("cIdReg",p_cVarName)) {
      return cIdReg;
    }
    if (CPLib.eqr("cIdMod",p_cVarName)) {
      return cIdMod;
    }
    if (CPLib.eqr("cTipRap",p_cVarName)) {
      return cTipRap;
    }
    if (CPLib.eqr("cFlgRap",p_cVarName)) {
      return cFlgRap;
    }
    if (CPLib.eqr("cOldProg",p_cVarName)) {
      return cOldProg;
    }
    if (CPLib.eqr("cDATREG",p_cVarName)) {
      return w_cDATREG;
    }
    if (CPLib.eqr("mycProg",p_cVarName)) {
      return mycProg;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      return gFlgWU;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("daData",p_cVarName)) {
      return w_daData;
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
    if (CPLib.eqr("prgidb",p_cVarName)) {
      w_prgidb = value;
      return;
    }
    if (CPLib.eqr("prgnprg",p_cVarName)) {
      w_prgnprg = value;
      return;
    }
    if (CPLib.eqr("prgiope",p_cVarName)) {
      w_prgiope = value;
      return;
    }
    if (CPLib.eqr("ngiorni",p_cVarName)) {
      w_ngiorni = value;
      return;
    }
    if (CPLib.eqr("cPrgImp",p_cVarName)) {
      cPrgImp = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("mycPrgImp",p_cVarName)) {
      mycPrgImp = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("frzuif",p_cVarName)) {
      w_frzuif = value;
      return;
    }
    if (CPLib.eqr("opeage",p_cVarName)) {
      w_opeage = value;
      return;
    }
    if (CPLib.eqr("opeuif",p_cVarName)) {
      w_opeuif = value;
      return;
    }
    if (CPLib.eqr("rapage",p_cVarName)) {
      w_rapage = value;
      return;
    }
    if (CPLib.eqr("rapuif",p_cVarName)) {
      w_rapuif = value;
      return;
    }
    if (CPLib.eqr("titaui",p_cVarName)) {
      w_titaui = value;
      return;
    }
    if (CPLib.eqr("flgpart",p_cVarName)) {
      w_flgpart = value;
      return;
    }
    if (CPLib.eqr("dataover",p_cVarName)) {
      w_dataover = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("cProg1",p_cVarName)) {
      cProg1 = value;
      return;
    }
    if (CPLib.eqr("cIDBASE",p_cVarName)) {
      cIDBASE = value;
      return;
    }
    if (CPLib.eqr("cIDB2",p_cVarName)) {
      cIDB2 = value;
      return;
    }
    if (CPLib.eqr("cIdReg",p_cVarName)) {
      cIdReg = value;
      return;
    }
    if (CPLib.eqr("cIdMod",p_cVarName)) {
      cIdMod = value;
      return;
    }
    if (CPLib.eqr("cTipRap",p_cVarName)) {
      cTipRap = value;
      return;
    }
    if (CPLib.eqr("cFlgRap",p_cVarName)) {
      cFlgRap = value;
      return;
    }
    if (CPLib.eqr("cOldProg",p_cVarName)) {
      cOldProg = value;
      return;
    }
    if (CPLib.eqr("cDATREG",p_cVarName)) {
      w_cDATREG = value;
      return;
    }
    if (CPLib.eqr("mycProg",p_cVarName)) {
      mycProg = value;
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
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      gFlgWU = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("daData",p_cVarName)) {
      w_daData = value;
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
    /* w_frzuif Char(1) */
    /* w_opeage Char(1) */
    /* w_opeuif Char(1) */
    /* w_rapage Char(1) */
    /* w_rapuif Char(1) */
    /* w_titaui Char(1) */
    /* w_flgpart Char(1) */
    /* w_prgidb Numeric(10, 0) // Prog. IDBASE */
    /* w_prgnprg Numeric(10, 0) // Prog. IDBASE */
    /* w_prgiope Numeric(10, 0) // Prog. IDBASE */
    /* w_daData Date // Da Data Registrazione */
    /* w_dataover Char(1) // date oltre il limite */
    /* w_ngiorni Numeric(2, 0) // Numero di giorni */
    /* cProg Char(11) */
    /* cProg1 Char(10) */
    /* cIDBASE Char(10) */
    /* cIDB2 Char(10) */
    /* cIdReg Char(20) */
    /* cIdMod Char(20) */
    /* cTipRap Char(2) */
    /* cFlgRap Char(1) */
    /* cPrgImp Numeric(10, 0) */
    /* cOldProg Char(11) */
    /* w_cDATREG Char(8) */
    /* _conta Numeric(15, 0) */
    /* mycProg Char(11) */
    /* mycPrgImp Numeric(10, 0) */
    /* gAzienda Char(10) // Azienda */
    /* gMsgImp Char(120) // Messaggio allineamento 1 */
    /* gFlgWU Char(1) // Gestione WU */
    /* -- */
    /* Crea il file appoggio */
    /* If w_rapuif = 'S' */
    if (CPLib.eqr(w_rapuif,"S")) {
      /* Exec "Rapporti UIC/UIF" Page 2:Page_2 */
      Page_2();
    } // End If
    /* If w_rapage = 'S' */
    if (CPLib.eqr(w_rapage,"S")) {
      /* Exec "Rapporti AE" Page 3:Page_3 */
      Page_3();
    } // End If
    /* If w_opeuif = 'S' */
    if (CPLib.eqr(w_opeuif,"S")) {
      /* If gFlgWU='S' */
      if (CPLib.eqr(gFlgWU,"S")) {
        /* Exec "Operazioni UIF WU" Page 8:Page_8 */
        Page_8();
      } else { // Else
        /* Exec "Operazioni UIF" Page 4:Page_4 */
        Page_4();
      } // End If
    } // End If
    /* If w_frzuif = 'S' */
    if (CPLib.eqr(w_frzuif,"S")) {
      /* Exec "Frazionate UIF" Page 5:Page_5 */
      Page_5();
    } // End If
    /* If w_opeage = 'S' */
    if (CPLib.eqr(w_opeage,"S")) {
      /* Exec "Operazioni AGE" Page 6:Page_6 */
      Page_6();
    } // End If
    /* If w_titaui = 'S' */
    if (CPLib.eqr(w_titaui,"S")) {
      /* Exec "Titolari Effettivi" Page 7:Page_7 */
      Page_7();
    } // End If
    /* gMsgImp := 'Ricostruzione Indici Terminata' // Messaggio allineamento 1 */
    gMsgImp = "Ricostruzione Indici Terminata";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_ridx_raplim=null;
    CPResultSet Cursor_tmp_rapopebo=null;
    CPResultSet Cursor_qbe_reindex_rap=null;
    CPResultSet Cursor_qbe_numprog_ruif=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Crea il file appoggio */
      // * --- Drop temporary table tmp_rapopebo
      if (m_Ctx.IsSharedTemp("tmp_rapopebo")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_rapopebo")) {
          m_cServer = m_Ctx.GetServer("tmp_rapopebo");
          m_cPhName = m_Ctx.GetPhName("tmp_rapopebo");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_rapopebo");
      }
      // * --- Create temporary table tmp_rapopebo
      if (m_Ctx.IsSharedTemp("tmp_rapopebo")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_rapopebo")) {
          m_cServer = m_Ctx.GetServer("tmp_rapopebo");
          m_cPhName = m_Ctx.GetPhName("tmp_rapopebo");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_rapopebo");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_rapopebo");
      if ( ! (m_Ctx.IsSharedTemp("tmp_rapopebo"))) {
        m_cServer = m_Ctx.GetServer("tmp_rapopebo");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_rapopebo",m_cServer,"proto")),m_cPhName,"tmp_rapopebo",m_Ctx,new String[]{"IDBASE","NUMPROG","DATAOPE","DATAREG","CDATOPE","CDATREG"});
      }
      m_cPhName_tmp_rapopebo = m_cPhName;
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000037status;
      nTry00000037status = m_Sql.GetTransactionStatus();
      String cTry00000037msg;
      cTry00000037msg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgImp := 'Creazione Tabella appoggio per ricostruzione indici' // Messaggio allineamento 1 */
        gMsgImp = "Creazione Tabella appoggio per ricostruzione indici";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If Empty(w_daData) */
        if (CPLib.Empty(w_daData)) {
          /* gMsgImp := 'Copia operazioni da riodinare' // Messaggio allineamento 1 */
          gMsgImp = "Copia operazioni da riodinare";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Insert into tmp_rapopebo from sql
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_rapopebo");
          m_cPhName = m_Ctx.GetPhName("tmp_rapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_rapopebo",m_Ctx.GetCompany());
          m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("arrt_riordina",197,"0000003B"),m_cServer,m_oWrInfo,"* ","from "+m_cPhName_rapopebo+"","tmp_rapopebo",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"tmp_rapopebo"));
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* Cancella il file intestbo e scrive i record corretti */
          /* gMsgImp := 'Cancellazione dati da tabella informazioni' // Messaggio allineamento 1 */
          gMsgImp = "Cancellazione dati da tabella informazioni";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Delete from rapopebo
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"0000003E")+"delete from "+m_oWrInfo.GetTableWriteName();
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
          /* gMsgImp := 'Azzeramento progressivi' // Messaggio allineamento 1 */
          gMsgImp = "Azzeramento progressivi";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000040")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000041")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000042")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          /* gMsgImp := 'Copia operazioni da riodinare' // Messaggio allineamento 1 */
          gMsgImp = "Copia operazioni da riodinare";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Insert into tmp_rapopebo from query
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_rapopebo");
          m_cPhName = m_Ctx.GetPhName("tmp_rapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_rapopebo",m_Ctx.GetCompany());
          SPBridge.HMCaller _h00000044;
          _h00000044 = new SPBridge.HMCaller();
          _h00000044.Set("m_cVQRList",m_cVQRList);
          _h00000044.Set("daData",w_daData);
          m_nUpdatedRows=m_Sql.InsertIntoVQR(CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000044"),m_oWrInfo,"qbe_ridx_rapopebo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000044,m_Ctx);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* Cancella il file intestbo e scrive i record corretti */
          /* gMsgImp := 'Cancellazione dati da tabella informazioni' // Messaggio allineamento 1 */
          gMsgImp = "Cancellazione dati da tabella informazioni";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Delete from rapopebo
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000047")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"DATAREG >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_daData,"?",0,0,m_cServer),m_cServer,w_daData)+"";
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
          /* gMsgImp := 'Azzeramento progressivi' // Messaggio allineamento 1 */
          gMsgImp = "Azzeramento progressivi";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Select from qbe_ridx_raplim
          if (Cursor_qbe_ridx_raplim!=null)
            Cursor_qbe_ridx_raplim.Close();
          Cursor_qbe_ridx_raplim = new VQRHolder("qbe_ridx_raplim",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_ridx_raplim.Eof())) {
            // * --- Write into cpwarn from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"0000004A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(CPLib.Val(Cursor_qbe_ridx_raplim.GetString("MAXNPRG")),"N",10,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
            m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
            // * --- Write into cpwarn from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"0000004B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(Cursor_qbe_ridx_raplim.GetDouble("MAXPOPE"),"N",10,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
            m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
            Cursor_qbe_ridx_raplim.Next();
          }
          m_cConnectivityError = Cursor_qbe_ridx_raplim.ErrorMessage();
          Cursor_qbe_ridx_raplim.Close();
          // * --- End Select
        } // End If
        /* If w_dataover='S' */
        if (CPLib.eqr(w_dataover,"S")) {
          // * --- Select from tmp_rapopebo
          m_cServer = m_Ctx.GetServer("tmp_rapopebo");
          m_cPhName = m_Ctx.GetPhName("tmp_rapopebo");
          if (Cursor_tmp_rapopebo!=null)
            Cursor_tmp_rapopebo.Close();
          Cursor_tmp_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"[DIFFDAY(DATAOPE,DATAREG)]>30 "+")"+(m_Ctx.IsSharedTemp("tmp_rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_rapopebo.Eof())) {
            // * --- Write into tmp_rapopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_rapopebo");
            m_cPhName = m_Ctx.GetPhName("tmp_rapopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_rapopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"0000004E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DATAREG = "+CPLib.ToSQL(arfn_datesumR.Make(m_Ctx,this).Run(Cursor_tmp_rapopebo.GetDate("DATAOPE"),w_ngiorni),"D",8,0)+", ";
            m_cSql = m_cSql+"CDATREG = "+CPLib.ToSQL(CPLib.DateToChar(arfn_datesumR.Make(m_Ctx,this).Run(Cursor_tmp_rapopebo.GetDate("DATAOPE"),w_ngiorni)),"C",8,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_rapopebo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_rapopebo.GetString("IDBASE"))+"";
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
            Cursor_tmp_rapopebo.Next();
          }
          m_cConnectivityError = Cursor_tmp_rapopebo.ErrorMessage();
          Cursor_tmp_rapopebo.Close();
          // * --- End Select
        } // End If
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* gMsgImp := 'Lettura Tabella appoggio per creazione indici' // Messaggio allineamento 1 */
        gMsgImp = "Lettura Tabella appoggio per creazione indici";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from qbe_reindex_rap
        if (Cursor_qbe_reindex_rap!=null)
          Cursor_qbe_reindex_rap.Close();
        Cursor_qbe_reindex_rap = new VQRHolder("qbe_reindex_rap",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_reindex_rap.Eof())) {
          /* w_cDATREG := qbe_reindex_rap->CDATREG */
          w_cDATREG = Cursor_qbe_reindex_rap.GetString("CDATREG");
          // * --- Select from qbe_numprog_ruif
          SPBridge.HMCaller _h00000053;
          _h00000053 = new SPBridge.HMCaller();
          _h00000053.Set("m_cVQRList",m_cVQRList);
          _h00000053.Set("cDATREG",w_cDATREG);
          if (Cursor_qbe_numprog_ruif!=null)
            Cursor_qbe_numprog_ruif.Close();
          Cursor_qbe_numprog_ruif = new VQRHolder("qbe_numprog_ruif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000053,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_numprog_ruif.Eof())) {
            /* Legge tutte le operazioni Collegate */
            /* cProg := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            /* cPrgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,10) */
            cPrgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
            // * --- Select from tmp_rapopebo
            m_cServer = m_Ctx.GetServer("tmp_rapopebo");
            m_cPhName = m_Ctx.GetPhName("tmp_rapopebo");
            if (Cursor_tmp_rapopebo!=null)
              Cursor_tmp_rapopebo.Close();
            Cursor_tmp_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_qbe_numprog_ruif.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("tmp_rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_rapopebo.Eof())) {
              /* cIDB2 := LibreriaMit.UniqueId() */
              cIDB2 = LibreriaMit.UniqueId();
              /* cProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cIdReg := "I"+Right(LRTrim(cProg),9)+cIDB2 */
              cIdReg = "I"+CPLib.Right(CPLib.LRTrim(cProg),9)+cIDB2;
              /* cIdMod := iif(Empty(LRTrim(tmp_rapopebo->OPERAZMOD)),'',Left(tmp_rapopebo->OPERAZMOD,8)+cProg+Right(LRTrim(tmp_rapopebo->OPERAZMOD),1)) */
              cIdMod = (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_rapopebo.GetString("OPERAZMOD")))?"":CPLib.Left(Cursor_tmp_rapopebo.GetString("OPERAZMOD"),8)+cProg+CPLib.Right(CPLib.LRTrim(Cursor_tmp_rapopebo.GetString("OPERAZMOD")),1));
              /* cFlgRap := '' */
              cFlgRap = "";
              // * --- Read from anarapbo
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_tmp_rapopebo.GetString("RAPPORTO"));
              if (m_Ctx.IsSharedTemp("anarapbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPORAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                cFlgRap = Read_Cursor.GetString("TIPORAP");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_riordina returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                cFlgRap = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              // * --- Insert into rapopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"0000005E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000005E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_tmp_rapopebo.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_tmp_rapopebo.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_tmp_rapopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_tmp_rapopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDate("DATAAGE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cFlgRap,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cIdReg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cIdMod,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cPrgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_tmp_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_tmp_rapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_tmp_rapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cIDB2,"?",0,0,m_cServer)+", ";
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
                throw new RoutineException();
              }
              /* cTipRap := tmp_rapopebo->TIPOOPRAP */
              cTipRap = Cursor_tmp_rapopebo.GetString("TIPOOPRAP");
              /* If cTipRap = '23' or cTipRap = '35' or cTipRap = '45' */
              if (CPLib.eqr(cTipRap,"23") || CPLib.eqr(cTipRap,"35") || CPLib.eqr(cTipRap,"45")) {
                // * --- Write into intestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000061")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(cProg,"C",11,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDate("DATAOPE"),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_rapopebo.GetString("RAPPORTO"))+"";
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
                /* ElseIf cTipRap='26' or cTipRap='36' or cTipRap='46' */
              } else if (CPLib.eqr(cTipRap,"26") || CPLib.eqr(cTipRap,"36") || CPLib.eqr(cTipRap,"46")) {
                // * --- Write into intestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000062")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cProg,"C",11,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDate("DATAOPE"),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_rapopebo.GetString("RAPPORTO"))+"";
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
                /* ElseIf cTipRap='25' */
              } else if (CPLib.eqr(cTipRap,"25")) {
                // * --- Write into delegabo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("delegabo");
                m_cPhName = m_Ctx.GetPhName("delegabo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000063")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(cProg,"C",11,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDate("DATAOPE"),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"delegabo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_rapopebo.GetString("RAPPORTO"))+"";
                m_cSql = m_cSql+" and NUMPROG1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_rapopebo.GetString("NUMPROG"))+"";
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
                /* ElseIf cTipRap='28' */
              } else if (CPLib.eqr(cTipRap,"28")) {
                // * --- Write into delegabo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("delegabo");
                m_cPhName = m_Ctx.GetPhName("delegabo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000064")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cProg,"C",11,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDate("DATAOPE"),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"delegabo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_rapopebo.GetString("RAPPORTO"))+"";
                m_cSql = m_cSql+" and NUMPROG2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_rapopebo.GetString("NUMPROG"))+"";
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
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              /* gMsgImp := 'Sono state reindicizzate '+LRTrim(Str(_conta,10,0))+' informazioni su rapporti UIF' // Messaggio allineamento 1 */
              gMsgImp = "Sono state reindicizzate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" informazioni su rapporti UIF";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              Cursor_tmp_rapopebo.Next();
            }
            m_cConnectivityError = Cursor_tmp_rapopebo.ErrorMessage();
            Cursor_tmp_rapopebo.Close();
            // * --- End Select
            Cursor_qbe_numprog_ruif.Next();
          }
          m_cConnectivityError = Cursor_qbe_numprog_ruif.ErrorMessage();
          Cursor_qbe_numprog_ruif.Close();
          // * --- End Select
          Cursor_qbe_reindex_rap.Next();
        }
        m_cConnectivityError = Cursor_qbe_reindex_rap.ErrorMessage();
        Cursor_qbe_reindex_rap.Close();
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000037status,0)) {
          m_Sql.SetTransactionStatus(nTry00000037status,cTry00000037msg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_ridx_raplim!=null)
          Cursor_qbe_ridx_raplim.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_rapopebo!=null)
          Cursor_tmp_rapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_reindex_rap!=null)
          Cursor_qbe_reindex_rap.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_numprog_ruif!=null)
          Cursor_qbe_numprog_ruif.Close();
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
  void Page_3() throws Exception {
    CPResultSet Cursor_tmp_rapopebo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_jntestbo=null;
    try {
      /* Crea il file appoggio */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000006Bstatus;
      nTry0000006Bstatus = m_Sql.GetTransactionStatus();
      String cTry0000006Bmsg;
      cTry0000006Bmsg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgImp := 'Creazione Tabella appoggio per ricostruzione indici' // Messaggio allineamento 1 */
        gMsgImp = "Creazione Tabella appoggio per ricostruzione indici";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Drop temporary table tmp_rapopebo
        if (m_Ctx.IsSharedTemp("tmp_rapopebo")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_rapopebo")) {
            m_cServer = m_Ctx.GetServer("tmp_rapopebo");
            m_cPhName = m_Ctx.GetPhName("tmp_rapopebo");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_rapopebo");
        }
        // * --- Create temporary table tmp_rapopebo
        if (m_Ctx.IsSharedTemp("tmp_rapopebo")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_rapopebo")) {
            m_cServer = m_Ctx.GetServer("tmp_rapopebo");
            m_cPhName = m_Ctx.GetPhName("tmp_rapopebo");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_rapopebo");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_rapopebo");
        if ( ! (m_Ctx.IsSharedTemp("tmp_rapopebo"))) {
          m_cServer = m_Ctx.GetServer("tmp_rapopebo");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_rapopebo",m_cServer,"proto")),m_cPhName,"tmp_rapopebo",m_Ctx,new String[]{"IDBASE","NUMPROG","DATAOPE","DATAREG","CDATOPE","CDATREG"});
        }
        m_cPhName_tmp_rapopebo = m_cPhName;
        /* gMsgImp := 'Copia operazioni da riodinare' // Messaggio allineamento 1 */
        gMsgImp = "Copia operazioni da riodinare";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Insert into tmp_rapopebo from sql
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_rapopebo");
        m_cPhName = m_Ctx.GetPhName("tmp_rapopebo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_rapopebo",m_Ctx.GetCompany());
        m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000070"),m_cServer,m_oWrInfo,"* ","from "+m_cPhName_japopebo+"","tmp_rapopebo",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"tmp_rapopebo"));
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        /* Cancella il file intestbo e scrive i record corretti */
        /* gMsgImp := 'Cancellazione dati da tabella informazioni' // Messaggio allineamento 1 */
        gMsgImp = "Cancellazione dati da tabella informazioni";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Delete from japopebo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("japopebo");
        m_cPhName = m_Ctx.GetPhName("japopebo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japopebo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000073")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
        /* gMsgImp := 'Azzeramento progressivi' // Messaggio allineamento 1 */
        gMsgImp = "Azzeramento progressivi";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Write into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000075")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGINFAGE2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGINFAGE2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
        m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
        // * --- Write into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000076")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGINFAGE1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGINFAGE1\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
        m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
        // * --- Write into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000077")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPINFAGE\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPINFAGE\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
        m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        // * --- Select from tmp_rapopebo
        m_cServer = m_Ctx.GetServer("tmp_rapopebo");
        m_cPhName = m_Ctx.GetPhName("tmp_rapopebo");
        if (Cursor_tmp_rapopebo!=null)
          Cursor_tmp_rapopebo.Close();
        Cursor_tmp_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_rapopebo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"DATAREG ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_rapopebo.Eof())) {
          /* cProg := Utilities.GetAutonumber("PRGINFAGE2\'"+LRTrim(gAzienda)+"'",'',11) */
          cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
          /* cIDBASE := Utilities.GetAutonumber("PRGINFAGE1\'"+LRTrim(gAzienda)+"'",'',10) */
          cIDBASE = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFAGE1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* cPrgImp := Utilities.GetAutonumber("PRGIMPINFAGE\'"+LRTrim(gAzienda)+"'",0,10) */
          cPrgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINFAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
          /* cIdReg := DateToChar(tmp_rapopebo->DATAOPE)+cProg+'0' */
          cIdReg = CPLib.DateToChar(Cursor_tmp_rapopebo.GetDate("DATAOPE"))+cProg+"0";
          /* cFlgRap := '' */
          cFlgRap = "";
          // * --- Read from jnarapbo
          m_cServer = m_Ctx.GetServer("jnarapbo");
          m_cPhName = m_Ctx.GetPhName("jnarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_tmp_rapopebo.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("jnarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPORAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            cFlgRap = Read_Cursor.GetString("TIPORAP");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on jnarapbo into routine arrt_riordina returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            cFlgRap = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Insert into japopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("japopebo");
          m_cPhName = m_Ctx.GetPhName("japopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000080")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000080(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cIDBASE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cIdReg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(Cursor_tmp_rapopebo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cFlgRap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetDate("DATAAGE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
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
            throw new RoutineException();
          }
          /* cTipRap := tmp_rapopebo->TIPOOPRAP */
          cTipRap = Cursor_tmp_rapopebo.GetString("TIPOOPRAP");
          // * --- Select from jntestbo
          m_cServer = m_Ctx.GetServer("jntestbo");
          m_cPhName = m_Ctx.GetPhName("jntestbo");
          if (Cursor_jntestbo!=null)
            Cursor_jntestbo.Close();
          Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_tmp_rapopebo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_jntestbo.Eof())) {
            /* If cTipRap = '23' or cTipRap = '35' or cTipRap = '45' */
            if (CPLib.eqr(cTipRap,"23") || CPLib.eqr(cTipRap,"35") || CPLib.eqr(cTipRap,"45")) {
              // * --- Write into jntestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jntestbo");
              m_cPhName = m_Ctx.GetPhName("jntestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000084")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(cProg,"C",11,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jntestbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_jntestbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jntestbo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_jntestbo.GetDouble("CPROWNUM"))+"";
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
              /* ElseIf cTipRap='26' or cTipRap = '36' or cTipRap = '46' */
            } else if (CPLib.eqr(cTipRap,"26") || CPLib.eqr(cTipRap,"36") || CPLib.eqr(cTipRap,"46")) {
              // * --- Write into jntestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jntestbo");
              m_cPhName = m_Ctx.GetPhName("jntestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000085")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(cProg,"C",11,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jntestbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_jntestbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jntestbo.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_jntestbo.GetDouble("CPROWNUM"))+"";
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
            Cursor_jntestbo.Next();
          }
          m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
          Cursor_jntestbo.Close();
          // * --- End Select
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          /* gMsgImp := 'Sono state reindicizzate '+LRTrim(Str(_conta,10,0))+' informazioni su rapporti AGE' // Messaggio allineamento 1 */
          gMsgImp = "Sono state reindicizzate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" informazioni su rapporti AGE";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          Cursor_tmp_rapopebo.Next();
        }
        m_cConnectivityError = Cursor_tmp_rapopebo.ErrorMessage();
        Cursor_tmp_rapopebo.Close();
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000006Bstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000006Bstatus,cTry0000006Bmsg);
        }
      }
    } finally {
      try {
        if (Cursor_tmp_rapopebo!=null)
          Cursor_tmp_rapopebo.Close();
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
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_qbe_ridx_opelim=null;
    CPResultSet Cursor_tmp_operazbo_ol=null;
    CPResultSet Cursor_qbe_reindex_ope=null;
    CPResultSet Cursor_qbe_numprog_uif=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Crea il file appoggio */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000008Cstatus;
      nTry0000008Cstatus = m_Sql.GetTransactionStatus();
      String cTry0000008Cmsg;
      cTry0000008Cmsg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgImp := 'Allineamento date in corso...' // Messaggio allineamento 1 */
        gMsgImp = "Allineamento date in corso...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from operazbo
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
        Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATREG<>[DTOC(DATAREG)] "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_operazbo.Eof())) {
          // * --- Write into operazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"0000008F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"CDATREG = "+CPLib.ToSQL(CPLib.DateToChar(Cursor_operazbo.GetDate("DATAREG")),"C",8,0,m_cServer)+", ";
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
        /* gMsgImp := 'Creazione Tabella appoggio per ricostruzione indici' // Messaggio allineamento 1 */
        gMsgImp = "Creazione Tabella appoggio per ricostruzione indici";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Drop temporary table tmp_beneficope_ol
        if (m_Ctx.IsSharedTemp("tmp_beneficope_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_beneficope_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_beneficope_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_beneficope_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_beneficope_ol");
        }
        // * --- Drop temporary table tmp_clientiope_ol
        if (m_Ctx.IsSharedTemp("tmp_clientiope_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_clientiope_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_clientiope_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_clientiope_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_clientiope_ol");
        }
        // * --- Drop temporary table tmp_sogopebo_ol
        if (m_Ctx.IsSharedTemp("tmp_sogopebo_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_sogopebo_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_sogopebo_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_sogopebo_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_sogopebo_ol");
        }
        // * --- Drop temporary table tmp_terzistiope_ol
        if (m_Ctx.IsSharedTemp("tmp_terzistiope_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_terzistiope_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_terzistiope_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_terzistiope_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_terzistiope_ol");
        }
        // * --- Create temporary table tmp_beneficope_ol
        if (m_Ctx.IsSharedTemp("tmp_beneficope_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_beneficope_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_beneficope_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_beneficope_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_beneficope_ol");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_beneficope_ol");
        m_cServer = m_Ctx.GetServer("tmp_beneficope_ol");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_cPhName_beneficope,m_cPhName,"tmp_beneficope_ol",m_Ctx.GetServer("beneficope"),m_Ctx);
        m_cPhName_tmp_beneficope_ol = m_cPhName;
        // * --- Delete from beneficope
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("beneficope");
        m_cPhName = m_Ctx.GetPhName("beneficope");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000097")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        // * --- Create temporary table tmp_clientiope_ol
        if (m_Ctx.IsSharedTemp("tmp_clientiope_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_clientiope_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_clientiope_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_clientiope_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_clientiope_ol");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_clientiope_ol");
        m_cServer = m_Ctx.GetServer("tmp_clientiope_ol");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_cPhName_clientiope,m_cPhName,"tmp_clientiope_ol",m_Ctx.GetServer("clientiope"),m_Ctx);
        m_cPhName_tmp_clientiope_ol = m_cPhName;
        // * --- Delete from clientiope
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("clientiope");
        m_cPhName = m_Ctx.GetPhName("clientiope");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000099")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        // * --- Create temporary table tmp_sogopebo_ol
        if (m_Ctx.IsSharedTemp("tmp_sogopebo_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_sogopebo_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_sogopebo_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_sogopebo_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_sogopebo_ol");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_sogopebo_ol");
        m_cServer = m_Ctx.GetServer("tmp_sogopebo_ol");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_cPhName_sogopebo,m_cPhName,"tmp_sogopebo_ol",m_Ctx.GetServer("sogopebo"),m_Ctx);
        m_cPhName_tmp_sogopebo_ol = m_cPhName;
        // * --- Delete from sogopebo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("sogopebo");
        m_cPhName = m_Ctx.GetPhName("sogopebo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"0000009B")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        // * --- Create temporary table tmp_terzistiope_ol
        if (m_Ctx.IsSharedTemp("tmp_terzistiope_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_terzistiope_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_terzistiope_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_terzistiope_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_terzistiope_ol");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_terzistiope_ol");
        m_cServer = m_Ctx.GetServer("tmp_terzistiope_ol");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_cPhName_terzistiope,m_cPhName,"tmp_terzistiope_ol",m_Ctx.GetServer("terzistiope"),m_Ctx);
        m_cPhName_tmp_terzistiope_ol = m_cPhName;
        // * --- Delete from terzistiope
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("terzistiope");
        m_cPhName = m_Ctx.GetPhName("terzistiope");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"0000009D")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        // * --- Drop temporary table tmp_operazbo_ol
        if (m_Ctx.IsSharedTemp("tmp_operazbo_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_operazbo_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_operazbo_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_operazbo_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_operazbo_ol");
        }
        // * --- Create temporary table tmp_operazbo_ol
        if (m_Ctx.IsSharedTemp("tmp_operazbo_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_operazbo_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_operazbo_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_operazbo_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_operazbo_ol");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_operazbo_ol");
        if ( ! (m_Ctx.IsSharedTemp("tmp_operazbo_ol"))) {
          m_cServer = m_Ctx.GetServer("tmp_operazbo_ol");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_operazbo_ol",m_cServer,"proto")),m_cPhName,"tmp_operazbo_ol",m_Ctx,new String[]{"IDBASE","NUMPROG","DATAOPE","DATAREG","CDATOPE","CDATREG","STATOREG","OPERAZMOD"});
        }
        m_cPhName_tmp_operazbo_ol = m_cPhName;
        /* If Empty(w_daData) */
        if (CPLib.Empty(w_daData)) {
          /* gMsgImp := 'Copia operazioni da riodinare' // Messaggio allineamento 1 */
          gMsgImp = "Copia operazioni da riodinare";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Insert into tmp_operazbo_ol from sql
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_operazbo_ol");
          m_cPhName = m_Ctx.GetPhName("tmp_operazbo_ol");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_operazbo_ol",m_Ctx.GetCompany());
          m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000A2"),m_cServer,m_oWrInfo,"* ","from "+m_cPhName_operazbo+"","tmp_operazbo_ol",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"tmp_operazbo_ol"));
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* gMsgImp := 'Azzeramento progressivi' // Messaggio allineamento 1 */
          gMsgImp = "Azzeramento progressivi";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000A4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000A5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          /* mycProg := Replicate('0',11) */
          mycProg = CPLib.Replicate("0",11);
          /* mycPrgImp := 0 */
          mycPrgImp = CPLib.Round(0,0);
        } else { // Else
          /* gMsgImp := 'Copia operazioni da riodinare' // Messaggio allineamento 1 */
          gMsgImp = "Copia operazioni da riodinare";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Insert into tmp_operazbo_ol from query
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_operazbo_ol");
          m_cPhName = m_Ctx.GetPhName("tmp_operazbo_ol");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_operazbo_ol",m_Ctx.GetCompany());
          SPBridge.HMCaller _h000000A9;
          _h000000A9 = new SPBridge.HMCaller();
          _h000000A9.Set("m_cVQRList",m_cVQRList);
          _h000000A9.Set("daData",w_daData);
          m_nUpdatedRows=m_Sql.InsertIntoVQR(CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000A9"),m_oWrInfo,"qbe_ridx_operazbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000A9,m_Ctx);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* gMsgImp := 'Azzeramento progressivi' // Messaggio allineamento 1 */
          gMsgImp = "Azzeramento progressivi";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Select from qbe_ridx_opelim
          SPBridge.HMCaller _h000000AB;
          _h000000AB = new SPBridge.HMCaller();
          _h000000AB.Set("m_cVQRList",m_cVQRList);
          _h000000AB.Set("daData",w_daData);
          if (Cursor_qbe_ridx_opelim!=null)
            Cursor_qbe_ridx_opelim.Close();
          Cursor_qbe_ridx_opelim = new VQRHolder("qbe_ridx_opelim",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000AB,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_ridx_opelim.Eof())) {
            // * --- Write into cpwarn from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000AC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(CPLib.Val(Cursor_qbe_ridx_opelim.GetString("MAXNPRG")),"N",10,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
            m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
            // * --- Write into cpwarn from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000AD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(Cursor_qbe_ridx_opelim.GetDouble("MAXPOPE"),"N",10,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
            m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
            /* mycProg := Right(Replicate('0',11)+qbe_ridx_opelim->MAXNPRG,11) */
            mycProg = CPLib.Right(CPLib.Replicate("0",11)+Cursor_qbe_ridx_opelim.GetString("MAXNPRG"),11);
            /* mycPrgImp := qbe_ridx_opelim->MAXPOPE */
            mycPrgImp = CPLib.Round(Cursor_qbe_ridx_opelim.GetDouble("MAXPOPE"),0);
            Cursor_qbe_ridx_opelim.Next();
          }
          m_cConnectivityError = Cursor_qbe_ridx_opelim.ErrorMessage();
          Cursor_qbe_ridx_opelim.Close();
          // * --- End Select
        } // End If
        /* If w_dataover='S' */
        if (CPLib.eqr(w_dataover,"S")) {
          // * --- Select from tmp_operazbo_ol
          m_cServer = m_Ctx.GetServer("tmp_operazbo_ol");
          m_cPhName = m_Ctx.GetPhName("tmp_operazbo_ol");
          if (Cursor_tmp_operazbo_ol!=null)
            Cursor_tmp_operazbo_ol.Close();
          Cursor_tmp_operazbo_ol = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"[DIFFDAY(DATAOPE,DATAREG)]>30 "+")"+(m_Ctx.IsSharedTemp("tmp_operazbo_ol")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_operazbo_ol.Eof())) {
            // * --- Write into tmp_operazbo_ol from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_operazbo_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_operazbo_ol");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_operazbo_ol",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000B2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DATAREG = "+CPLib.ToSQL(arfn_datesumR.Make(m_Ctx,this).Run(Cursor_tmp_operazbo_ol.GetDate("DATAOPE"),w_ngiorni),"D",8,0)+", ";
            m_cSql = m_cSql+"CDATREG = "+CPLib.ToSQL(CPLib.DateToChar(arfn_datesumR.Make(m_Ctx,this).Run(Cursor_tmp_operazbo_ol.GetDate("DATAOPE"),w_ngiorni)),"C",8,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_operazbo_ol",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_operazbo_ol.GetString("IDBASE"))+"";
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
            Cursor_tmp_operazbo_ol.Next();
          }
          m_cConnectivityError = Cursor_tmp_operazbo_ol.ErrorMessage();
          Cursor_tmp_operazbo_ol.Close();
          // * --- End Select
        } // End If
        // * --- Select from qbe_reindex_ope
        if (Cursor_qbe_reindex_ope!=null)
          Cursor_qbe_reindex_ope.Close();
        Cursor_qbe_reindex_ope = new VQRHolder("qbe_reindex_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_reindex_ope.Eof())) {
          /* w_cDATREG := qbe_reindex_ope->CDATREG */
          w_cDATREG = Cursor_qbe_reindex_ope.GetString("CDATREG");
          /* System.out.println('Allienamento data registrazione '+w_cDATREG) */
          System.out.println("Allienamento data registrazione "+w_cDATREG);
          Cursor_qbe_reindex_ope.Next();
        }
        m_cConnectivityError = Cursor_qbe_reindex_ope.ErrorMessage();
        Cursor_qbe_reindex_ope.Close();
        // * --- End Select
        /* Cancella il file operazbo e scrive i record corretti */
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* gMsgImp := 'Lettura Tabella appoggio per creazione indici' // Messaggio allineamento 1 */
        gMsgImp = "Lettura Tabella appoggio per creazione indici";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from qbe_reindex_ope
        if (Cursor_qbe_reindex_ope!=null)
          Cursor_qbe_reindex_ope.Close();
        Cursor_qbe_reindex_ope = new VQRHolder("qbe_reindex_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_reindex_ope.Eof())) {
          /* w_cDATREG := qbe_reindex_ope->CDATREG */
          w_cDATREG = Cursor_qbe_reindex_ope.GetString("CDATREG");
          /* System.out.println('Elaborazione data registrazione '+w_cDATREG) */
          System.out.println("Elaborazione data registrazione "+w_cDATREG);
          // * --- Select from qbe_numprog_uif
          SPBridge.HMCaller _h000000BC;
          _h000000BC = new SPBridge.HMCaller();
          _h000000BC.Set("m_cVQRList",m_cVQRList);
          _h000000BC.Set("cDATREG",w_cDATREG);
          if (Cursor_qbe_numprog_uif!=null)
            Cursor_qbe_numprog_uif.Close();
          Cursor_qbe_numprog_uif = new VQRHolder("qbe_numprog_uif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000BC,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_numprog_uif.Eof())) {
            /* Legge tutte le operazioni Collegate */
            /* mycProg := Right(Replicate('0',11)+LRTrim(Str(Val(mycProg)+1,11,0)) ,11) */
            mycProg = CPLib.Right(CPLib.Replicate("0",11)+CPLib.LRTrim(CPLib.Str(CPLib.Val(mycProg)+1,11,0)),11);
            /* mycPrgImp := mycPrgImp+1 */
            mycPrgImp = CPLib.Round(mycPrgImp+1,0);
            /* cProg := mycProg */
            cProg = mycProg;
            /* cPrgImp := mycPrgImp */
            cPrgImp = CPLib.Round(mycPrgImp,0);
            // * --- Select from tmp_operazbo_ol
            m_cServer = m_Ctx.GetServer("tmp_operazbo_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_operazbo_ol");
            if (Cursor_tmp_operazbo_ol!=null)
              Cursor_tmp_operazbo_ol.Close();
            Cursor_tmp_operazbo_ol = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_qbe_numprog_uif.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("tmp_operazbo_ol")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"STATOREG ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_operazbo_ol.Eof())) {
              /* If not(Empty(tmp_operazbo_ol->IDBASE2)) */
              if ( ! (CPLib.Empty(Cursor_tmp_operazbo_ol.GetString("IDBASE2")))) {
                /* cIdReg := 'O'+Right(cProg,9)+tmp_operazbo_ol->IDBASE2 */
                cIdReg = "O"+CPLib.Right(cProg,9)+Cursor_tmp_operazbo_ol.GetString("IDBASE2");
                /* cIdMod := tmp_operazbo_ol->OPERAZMOD */
                cIdMod = Cursor_tmp_operazbo_ol.GetString("OPERAZMOD");
              } else { // Else
                /* cIdReg := DateToChar(tmp_operazbo_ol->DATAOPE)+cProg+Right(LRTrim(tmp_operazbo_ol->IDEREG),1) */
                cIdReg = CPLib.DateToChar(Cursor_tmp_operazbo_ol.GetDate("DATAOPE"))+cProg+CPLib.Right(CPLib.LRTrim(Cursor_tmp_operazbo_ol.GetString("IDEREG")),1);
                /* cIdMod := iif(Empty(LRTrim(tmp_operazbo_ol->OPERAZMOD)),'',Left(tmp_operazbo_ol->OPERAZMOD,8)+cProg+Right(LRTrim(tmp_operazbo_ol->OPERAZMOD),1)) */
                cIdMod = (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_operazbo_ol.GetString("OPERAZMOD")))?"":CPLib.Left(Cursor_tmp_operazbo_ol.GetString("OPERAZMOD"),8)+cProg+CPLib.Right(CPLib.LRTrim(Cursor_tmp_operazbo_ol.GetString("OPERAZMOD")),1));
              } // End If
              // * --- Write into operazbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("operazbo");
              m_cPhName = m_Ctx.GetPhName("operazbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000C8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"OPERAZMOD = "+CPLib.ToSQL(cIdMod,"C",20,0,m_cServer)+", ";
              m_cSql = m_cSql+"IDEREG = "+CPLib.ToSQL(cIdReg,"C",20,0,m_cServer)+", ";
              m_cSql = m_cSql+"PRGIMPOPE = "+CPLib.ToSQL(cPrgImp,"N",15,0)+", ";
              m_cSql = m_cSql+"NUMPROG = "+CPLib.ToSQL(cProg,"C",11,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAREG = "+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetDate("DATAREG"),"D",8,0)+", ";
              m_cSql = m_cSql+"CDATREG = "+CPLib.ToSQL(CPLib.DateToChar(Cursor_tmp_operazbo_ol.GetDate("DATAREG")),"C",8,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_operazbo_ol.GetString("IDBASE"))+"";
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
              /* If not(Empty(tmp_operazbo_ol->IDBASE2)) */
              if ( ! (CPLib.Empty(Cursor_tmp_operazbo_ol.GetString("IDBASE2")))) {
                // * --- Write into tmp_operazbo_ol from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_operazbo_ol");
                m_cPhName = m_Ctx.GetPhName("tmp_operazbo_ol");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_operazbo_ol",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000CA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"OPERAZMOD = "+CPLib.ToSQL(cIdReg,"C",20,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_operazbo_ol",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"OPERAZMOD = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("IDEREG"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_operazbo_ol.GetString("IDEREG"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000CB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"OPERAZMOD = "+CPLib.ToSQL(cIdReg,"C",20,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"OPERAZMOD = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("IDEREG"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_operazbo_ol.GetString("IDEREG"))+"";
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
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              // * --- Delete from tmp_operazbo_ol
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_operazbo_ol");
              m_cPhName = m_Ctx.GetPhName("tmp_operazbo_ol");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_operazbo_ol",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000CD")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_operazbo_ol.GetString("IDBASE"))+"";
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
              Cursor_tmp_operazbo_ol.Next();
            }
            m_cConnectivityError = Cursor_tmp_operazbo_ol.ErrorMessage();
            Cursor_tmp_operazbo_ol.Close();
            // * --- End Select
            /* gMsgImp := 'Sono state reindicizzate '+LRTrim(Str(_conta,10,0))+' operazioni '+w_cDATREG // Messaggio allineamento 1 */
            gMsgImp = "Sono state reindicizzate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" operazioni "+w_cDATREG;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            Cursor_qbe_numprog_uif.Next();
          }
          m_cConnectivityError = Cursor_qbe_numprog_uif.ErrorMessage();
          Cursor_qbe_numprog_uif.Close();
          // * --- End Select
          Cursor_qbe_reindex_ope.Next();
        }
        m_cConnectivityError = Cursor_qbe_reindex_ope.ErrorMessage();
        Cursor_qbe_reindex_ope.Close();
        // * --- End Select
        /* Allineo i progressivi */
        // * --- Write into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000D0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(CPLib.Val(mycProg),"N",10,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
        m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
        // * --- Write into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000D1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(mycPrgImp,"N",10,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
        m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
        // * --- Insert into beneficope from sql
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("beneficope");
        m_cPhName = m_Ctx.GetPhName("beneficope");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
        m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000D2"),m_cServer,m_oWrInfo,"* ","from "+m_cPhName_tmp_beneficope_ol+"","beneficope",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"beneficope"));
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        // * --- Insert into clientiope from sql
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("clientiope");
        m_cPhName = m_Ctx.GetPhName("clientiope");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
        m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000D3"),m_cServer,m_oWrInfo,"* ","from "+m_cPhName_tmp_clientiope_ol+"","clientiope",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"clientiope"));
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        // * --- Insert into sogopebo from sql
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("sogopebo");
        m_cPhName = m_Ctx.GetPhName("sogopebo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
        m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000D4"),m_cServer,m_oWrInfo,"* ","from "+m_cPhName_tmp_sogopebo_ol+"","sogopebo",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"sogopebo"));
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        // * --- Insert into terzistiope from sql
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("terzistiope");
        m_cPhName = m_Ctx.GetPhName("terzistiope");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
        m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000D5"),m_cServer,m_oWrInfo,"* ","from "+m_cPhName_tmp_terzistiope_ol+"","terzistiope",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"terzistiope"));
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
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000008Cstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000008Cstatus,cTry0000008Cmsg);
        }
      }
    } finally {
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_ridx_opelim!=null)
          Cursor_qbe_ridx_opelim.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_operazbo_ol!=null)
          Cursor_tmp_operazbo_ol.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_reindex_ope!=null)
          Cursor_qbe_reindex_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_numprog_uif!=null)
          Cursor_qbe_numprog_uif.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Cursor_qbe_ridx_frzlim=null;
    CPResultSet Cursor_tmp_fraziobo_ol=null;
    CPResultSet Cursor_qbe_reindex_frz=null;
    CPResultSet Cursor_qbe_numprog_fuif=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Crea il file appoggio */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000000DAstatus;
      nTry000000DAstatus = m_Sql.GetTransactionStatus();
      String cTry000000DAmsg;
      cTry000000DAmsg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgImp := 'Creazione Tabella appoggio per ricostruzione indici' // Messaggio allineamento 1 */
        gMsgImp = "Creazione Tabella appoggio per ricostruzione indici";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Drop temporary table tmp_beneficope_ol
        if (m_Ctx.IsSharedTemp("tmp_beneficope_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_beneficope_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_beneficope_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_beneficope_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_beneficope_ol");
        }
        // * --- Drop temporary table tmp_clientiope_ol
        if (m_Ctx.IsSharedTemp("tmp_clientiope_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_clientiope_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_clientiope_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_clientiope_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_clientiope_ol");
        }
        // * --- Drop temporary table tmp_sogopebo_ol
        if (m_Ctx.IsSharedTemp("tmp_sogopebo_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_sogopebo_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_sogopebo_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_sogopebo_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_sogopebo_ol");
        }
        // * --- Drop temporary table tmp_terzistiope_ol
        if (m_Ctx.IsSharedTemp("tmp_terzistiope_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_terzistiope_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_terzistiope_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_terzistiope_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_terzistiope_ol");
        }
        // * --- Create temporary table tmp_beneficope_ol
        if (m_Ctx.IsSharedTemp("tmp_beneficope_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_beneficope_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_beneficope_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_beneficope_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_beneficope_ol");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_beneficope_ol");
        m_cServer = m_Ctx.GetServer("tmp_beneficope_ol");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_cPhName_beneficfrz,m_cPhName,"tmp_beneficope_ol",m_Ctx.GetServer("beneficfrz"),m_Ctx);
        m_cPhName_tmp_beneficope_ol = m_cPhName;
        // * --- Delete from beneficfrz
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("beneficfrz");
        m_cPhName = m_Ctx.GetPhName("beneficfrz");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000E2")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
        // * --- Create temporary table tmp_clientiope_ol
        if (m_Ctx.IsSharedTemp("tmp_clientiope_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_clientiope_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_clientiope_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_clientiope_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_clientiope_ol");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_clientiope_ol");
        m_cServer = m_Ctx.GetServer("tmp_clientiope_ol");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_cPhName_clientifrz,m_cPhName,"tmp_clientiope_ol",m_Ctx.GetServer("clientifrz"),m_Ctx);
        m_cPhName_tmp_clientiope_ol = m_cPhName;
        // * --- Delete from clientifrz
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("clientifrz");
        m_cPhName = m_Ctx.GetPhName("clientifrz");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000E4")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
        // * --- Create temporary table tmp_sogopebo_ol
        if (m_Ctx.IsSharedTemp("tmp_sogopebo_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_sogopebo_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_sogopebo_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_sogopebo_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_sogopebo_ol");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_sogopebo_ol");
        m_cServer = m_Ctx.GetServer("tmp_sogopebo_ol");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_cPhName_sogopefbo,m_cPhName,"tmp_sogopebo_ol",m_Ctx.GetServer("sogopefbo"),m_Ctx);
        m_cPhName_tmp_sogopebo_ol = m_cPhName;
        // * --- Delete from sogopefbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("sogopefbo");
        m_cPhName = m_Ctx.GetPhName("sogopefbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000E6")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
        // * --- Create temporary table tmp_terzistiope_ol
        if (m_Ctx.IsSharedTemp("tmp_terzistiope_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_terzistiope_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_terzistiope_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_terzistiope_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_terzistiope_ol");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_terzistiope_ol");
        m_cServer = m_Ctx.GetServer("tmp_terzistiope_ol");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_cPhName_terzistifrz,m_cPhName,"tmp_terzistiope_ol",m_Ctx.GetServer("terzistifrz"),m_Ctx);
        m_cPhName_tmp_terzistiope_ol = m_cPhName;
        // * --- Delete from terzistifrz
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("terzistifrz");
        m_cPhName = m_Ctx.GetPhName("terzistifrz");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000E8")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
        // * --- Drop temporary table tmp_fraziobo_ol
        if (m_Ctx.IsSharedTemp("tmp_fraziobo_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_fraziobo_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_fraziobo_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_fraziobo_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_fraziobo_ol");
        }
        // * --- Create temporary table tmp_fraziobo_ol
        if (m_Ctx.IsSharedTemp("tmp_fraziobo_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_fraziobo_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_fraziobo_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_fraziobo_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_fraziobo_ol");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_fraziobo_ol");
        if ( ! (m_Ctx.IsSharedTemp("tmp_fraziobo_ol"))) {
          m_cServer = m_Ctx.GetServer("tmp_fraziobo_ol");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_fraziobo_ol",m_cServer,"proto")),m_cPhName,"tmp_fraziobo_ol",m_Ctx,new String[]{"IDBASE","NUMPROG","DATAOPE","DATAREG","CDATOPE","CDATREG"});
        }
        m_cPhName_tmp_fraziobo_ol = m_cPhName;
        /* If Empty(w_daData) */
        if (CPLib.Empty(w_daData)) {
          /* gMsgImp := 'Copia frazionate da riodinare' // Messaggio allineamento 1 */
          gMsgImp = "Copia frazionate da riodinare";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Insert into tmp_fraziobo_ol from sql
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_fraziobo_ol");
          m_cPhName = m_Ctx.GetPhName("tmp_fraziobo_ol");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_fraziobo_ol",m_Ctx.GetCompany());
          m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000ED"),m_cServer,m_oWrInfo,"* ","from "+m_cPhName_fraziobo+"","tmp_fraziobo_ol",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"tmp_fraziobo_ol"));
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* gMsgImp := 'Cancellazione dati da tabella frazionate' // Messaggio allineamento 1 */
          gMsgImp = "Cancellazione dati da tabella frazionate";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Delete from fraziobo
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000EF")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
          /* gMsgImp := 'Azzeramento progressivi' // Messaggio allineamento 1 */
          gMsgImp = "Azzeramento progressivi";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000F1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000F2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          /* gMsgImp := 'Copia frazionate da riodinare' // Messaggio allineamento 1 */
          gMsgImp = "Copia frazionate da riodinare";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Insert into tmp_fraziobo_ol from query
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_fraziobo_ol");
          m_cPhName = m_Ctx.GetPhName("tmp_fraziobo_ol");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_fraziobo_ol",m_Ctx.GetCompany());
          SPBridge.HMCaller _h000000F4;
          _h000000F4 = new SPBridge.HMCaller();
          _h000000F4.Set("m_cVQRList",m_cVQRList);
          _h000000F4.Set("daData",w_daData);
          m_nUpdatedRows=m_Sql.InsertIntoVQR(CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000F4"),m_oWrInfo,"qbe_ridx_fraziobo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000F4,m_Ctx);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* gMsgImp := 'Cancellazione dati da tabella operazioni' // Messaggio allineamento 1 */
          gMsgImp = "Cancellazione dati da tabella operazioni";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Delete from fraziobo
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000F6")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"DATAREG >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_daData,"?",0,0,m_cServer),m_cServer,w_daData)+"";
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
          /* gMsgImp := 'Azzeramento progressivi' // Messaggio allineamento 1 */
          gMsgImp = "Azzeramento progressivi";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Select from qbe_ridx_frzlim
          if (Cursor_qbe_ridx_frzlim!=null)
            Cursor_qbe_ridx_frzlim.Close();
          Cursor_qbe_ridx_frzlim = new VQRHolder("qbe_ridx_frzlim",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_ridx_frzlim.Eof())) {
            // * --- Write into cpwarn from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000F9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(CPLib.Val(Cursor_qbe_ridx_frzlim.GetString("MAXNPRG")),"N",10,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
            m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
            // * --- Write into cpwarn from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000FA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(Cursor_qbe_ridx_frzlim.GetDouble("MAXPOPE"),"N",10,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
            m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
            Cursor_qbe_ridx_frzlim.Next();
          }
          m_cConnectivityError = Cursor_qbe_ridx_frzlim.ErrorMessage();
          Cursor_qbe_ridx_frzlim.Close();
          // * --- End Select
        } // End If
        /* If w_dataover='S' */
        if (CPLib.eqr(w_dataover,"S")) {
          // * --- Select from tmp_fraziobo_ol
          m_cServer = m_Ctx.GetServer("tmp_fraziobo_ol");
          m_cPhName = m_Ctx.GetPhName("tmp_fraziobo_ol");
          if (Cursor_tmp_fraziobo_ol!=null)
            Cursor_tmp_fraziobo_ol.Close();
          Cursor_tmp_fraziobo_ol = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"[DIFFDAY(DATAOPE,DATAREG)]>30 "+")"+(m_Ctx.IsSharedTemp("tmp_fraziobo_ol")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_fraziobo_ol.Eof())) {
            // * --- Write into tmp_fraziobo_ol from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_fraziobo_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_fraziobo_ol");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_fraziobo_ol",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"000000FD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DATAREG = "+CPLib.ToSQL(arfn_datesumR.Make(m_Ctx,this).Run(Cursor_tmp_fraziobo_ol.GetDate("DATAOPE"),w_ngiorni),"D",8,0)+", ";
            m_cSql = m_cSql+"CDATREG = "+CPLib.ToSQL(CPLib.DateToChar(arfn_datesumR.Make(m_Ctx,this).Run(Cursor_tmp_fraziobo_ol.GetDate("DATAOPE"),w_ngiorni)),"C",8,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_fraziobo_ol",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_fraziobo_ol.GetString("IDBASE"))+"";
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
            Cursor_tmp_fraziobo_ol.Next();
          }
          m_cConnectivityError = Cursor_tmp_fraziobo_ol.ErrorMessage();
          Cursor_tmp_fraziobo_ol.Close();
          // * --- End Select
        } // End If
        /* Cancella il file operazbo e scrive i record corretti */
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* gMsgImp := 'Lettura Tabella appoggio per creazione indici' // Messaggio allineamento 1 */
        gMsgImp = "Lettura Tabella appoggio per creazione indici";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from qbe_reindex_frz
        if (Cursor_qbe_reindex_frz!=null)
          Cursor_qbe_reindex_frz.Close();
        Cursor_qbe_reindex_frz = new VQRHolder("qbe_reindex_frz",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_reindex_frz.Eof())) {
          /* w_cDATREG := qbe_reindex_frz->CDATREG */
          w_cDATREG = Cursor_qbe_reindex_frz.GetString("CDATREG");
          // * --- Select from qbe_numprog_fuif
          SPBridge.HMCaller _h00000103;
          _h00000103 = new SPBridge.HMCaller();
          _h00000103.Set("m_cVQRList",m_cVQRList);
          _h00000103.Set("cDATREG",w_cDATREG);
          if (Cursor_qbe_numprog_fuif!=null)
            Cursor_qbe_numprog_fuif.Close();
          Cursor_qbe_numprog_fuif = new VQRHolder("qbe_numprog_fuif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000103,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_numprog_fuif.Eof())) {
            /* Legge tutte le operazioni Collegate */
            /* cProg := Utilities.GetAutonumber("PFRAZIO2\'"+LRTrim(gAzienda)+"'",'',11) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            /* cPrgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(gAzienda)+"'",0,10) */
            cPrgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
            // * --- Select from tmp_fraziobo_ol
            m_cServer = m_Ctx.GetServer("tmp_fraziobo_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_fraziobo_ol");
            if (Cursor_tmp_fraziobo_ol!=null)
              Cursor_tmp_fraziobo_ol.Close();
            Cursor_tmp_fraziobo_ol = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_qbe_numprog_fuif.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("tmp_fraziobo_ol")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"STATOREG ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_fraziobo_ol.Eof())) {
              /* In base al valore di idbase2 applico il vecchio sistema o il nuovo */
              /* If not(Empty(tmp_fraziobo_ol->IDBASE2)) */
              if ( ! (CPLib.Empty(Cursor_tmp_fraziobo_ol.GetString("IDBASE2")))) {
                /* cIdReg := 'F'+Right(cProg,9)+tmp_fraziobo_ol->IDBASE2 */
                cIdReg = "F"+CPLib.Right(cProg,9)+Cursor_tmp_fraziobo_ol.GetString("IDBASE2");
                /* cIdMod := tmp_fraziobo_ol->OPERAZMOD */
                cIdMod = Cursor_tmp_fraziobo_ol.GetString("OPERAZMOD");
              } else { // Else
                /* cIdReg := DateToChar(tmp_fraziobo_ol->DATAOPE)+cProg+Right(LRTrim(tmp_fraziobo_ol->IDEREG),1) */
                cIdReg = CPLib.DateToChar(Cursor_tmp_fraziobo_ol.GetDate("DATAOPE"))+cProg+CPLib.Right(CPLib.LRTrim(Cursor_tmp_fraziobo_ol.GetString("IDEREG")),1);
                /* cIdMod := iif(Empty(LRTrim(tmp_fraziobo_ol->OPERAZMOD)),'',Left(tmp_fraziobo_ol->OPERAZMOD,8)+cProg+Right(LRTrim(tmp_fraziobo_ol->OPERAZMOD),1)) */
                cIdMod = (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_fraziobo_ol.GetString("OPERAZMOD")))?"":CPLib.Left(Cursor_tmp_fraziobo_ol.GetString("OPERAZMOD"),8)+cProg+CPLib.Right(CPLib.LRTrim(Cursor_tmp_fraziobo_ol.GetString("OPERAZMOD")),1));
              } // End If
              // * --- Insert into fraziobo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"0000010E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000010E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDouble("ANNOOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDate("DATAIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDouble("DUCOLLEG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("DURAT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("IDBASE2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("idcauana"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cIdReg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDouble("IMPIN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDouble("IMPOUT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("MTCN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDouble("NOPROT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cIdMod,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cPrgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
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
              /* If not(Empty(tmp_fraziobo_ol->IDBASE2)) */
              if ( ! (CPLib.Empty(Cursor_tmp_fraziobo_ol.GetString("IDBASE2")))) {
                // * --- Write into tmp_fraziobo_ol from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_fraziobo_ol");
                m_cPhName = m_Ctx.GetPhName("tmp_fraziobo_ol");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_fraziobo_ol",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000110")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"OPERAZMOD = "+CPLib.ToSQL(cIdReg,"C",20,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_fraziobo_ol",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"OPERAZMOD = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("IDEREG"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_fraziobo_ol.GetString("IDEREG"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000111")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"OPERAZMOD = "+CPLib.ToSQL(cIdReg,"C",20,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"OPERAZMOD = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("IDEREG"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_fraziobo_ol.GetString("IDEREG"))+"";
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
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              // * --- Delete from tmp_fraziobo_ol
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_fraziobo_ol");
              m_cPhName = m_Ctx.GetPhName("tmp_fraziobo_ol");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_fraziobo_ol",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000113")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_fraziobo_ol.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_fraziobo_ol.GetString("IDBASE"))+"";
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
              Cursor_tmp_fraziobo_ol.Next();
            }
            m_cConnectivityError = Cursor_tmp_fraziobo_ol.ErrorMessage();
            Cursor_tmp_fraziobo_ol.Close();
            // * --- End Select
            /* gMsgImp := 'Sono state reindicizzate '+LRTrim(Str(_conta,10,0))+' frazionate' // Messaggio allineamento 1 */
            gMsgImp = "Sono state reindicizzate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" frazionate";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            Cursor_qbe_numprog_fuif.Next();
          }
          m_cConnectivityError = Cursor_qbe_numprog_fuif.ErrorMessage();
          Cursor_qbe_numprog_fuif.Close();
          // * --- End Select
          Cursor_qbe_reindex_frz.Next();
        }
        m_cConnectivityError = Cursor_qbe_reindex_frz.ErrorMessage();
        Cursor_qbe_reindex_frz.Close();
        // * --- End Select
        // * --- Insert into beneficfrz from sql
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("beneficfrz");
        m_cPhName = m_Ctx.GetPhName("beneficfrz");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
        m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000115"),m_cServer,m_oWrInfo,"* ","from "+m_cPhName_tmp_beneficope_ol+"","beneficfrz",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"beneficfrz"));
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        // * --- Insert into clientifrz from sql
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("clientifrz");
        m_cPhName = m_Ctx.GetPhName("clientifrz");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
        m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000116"),m_cServer,m_oWrInfo,"* ","from "+m_cPhName_tmp_clientiope_ol+"","clientifrz",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"clientifrz"));
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        // * --- Insert into sogopefbo from sql
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("sogopefbo");
        m_cPhName = m_Ctx.GetPhName("sogopefbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
        m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000117"),m_cServer,m_oWrInfo,"* ","from "+m_cPhName_tmp_sogopebo_ol+"","sogopefbo",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"sogopefbo"));
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        // * --- Insert into terzistifrz from sql
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("terzistifrz");
        m_cPhName = m_Ctx.GetPhName("terzistifrz");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
        m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000118"),m_cServer,m_oWrInfo,"* ","from "+m_cPhName_tmp_terzistiope_ol+"","terzistifrz",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"terzistifrz"));
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
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000DAstatus,0)) {
          m_Sql.SetTransactionStatus(nTry000000DAstatus,cTry000000DAmsg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_ridx_frzlim!=null)
          Cursor_qbe_ridx_frzlim.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_fraziobo_ol!=null)
          Cursor_tmp_fraziobo_ol.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_reindex_frz!=null)
          Cursor_qbe_reindex_frz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_numprog_fuif!=null)
          Cursor_qbe_numprog_fuif.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_6() throws Exception {
    CPResultSet Cursor_qbe_reindex_ope=null;
    CPResultSet Cursor_qbe_numprog_uif=null;
    CPResultSet Cursor_tmp_operazbo_ol=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Crea il file appoggio */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000011Dstatus;
      nTry0000011Dstatus = m_Sql.GetTransactionStatus();
      String cTry0000011Dmsg;
      cTry0000011Dmsg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgImp := 'Creazione Tabella appoggio per ricostruzione indici' // Messaggio allineamento 1 */
        gMsgImp = "Creazione Tabella appoggio per ricostruzione indici";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Drop temporary table tmp_operazbo_ol
        if (m_Ctx.IsSharedTemp("tmp_operazbo_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_operazbo_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_operazbo_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_operazbo_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_operazbo_ol");
        }
        // * --- Create temporary table tmp_operazbo_ol
        if (m_Ctx.IsSharedTemp("tmp_operazbo_ol")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_operazbo_ol")) {
            m_cServer = m_Ctx.GetServer("tmp_operazbo_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_operazbo_ol");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_operazbo_ol");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_operazbo_ol");
        if ( ! (m_Ctx.IsSharedTemp("tmp_operazbo_ol"))) {
          m_cServer = m_Ctx.GetServer("tmp_operazbo_ol");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_operazbo_ol",m_cServer,"proto")),m_cPhName,"tmp_operazbo_ol",m_Ctx,new String[]{"IDBASE","NUMPROG","DATAOPE","DATAREG","CDATOPE","CDATREG"});
        }
        m_cPhName_tmp_operazbo_ol = m_cPhName;
        /* gMsgImp := 'Copia operazioni da riodinare' // Messaggio allineamento 1 */
        gMsgImp = "Copia operazioni da riodinare";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Insert into tmp_operazbo_ol from sql
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_operazbo_ol");
        m_cPhName = m_Ctx.GetPhName("tmp_operazbo_ol");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_operazbo_ol",m_Ctx.GetCompany());
        m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000122"),m_cServer,m_oWrInfo,"* ","from "+m_cPhName_jperazbo+"","tmp_operazbo_ol",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"tmp_operazbo_ol"));
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        /* Cancella il file operazbo e scrive i record corretti */
        /* gMsgImp := 'Cancellazione dati da tabella operazioni' // Messaggio allineamento 1 */
        gMsgImp = "Cancellazione dati da tabella operazioni";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Delete from jperazbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("jperazbo");
        m_cPhName = m_Ctx.GetPhName("jperazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jperazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000125")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
        /* gMsgImp := 'Azzeramento progressivi' // Messaggio allineamento 1 */
        gMsgImp = "Azzeramento progressivi";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Write into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000127")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAGE2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAGE2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
        m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
        // * --- Write into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000128")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAGE1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAGE1\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
        m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
        // * --- Write into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000129")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPOPEAGE\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPOPEAGE\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
        m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* gMsgImp := 'Lettura Tabella appoggio per creazione indici' // Messaggio allineamento 1 */
        gMsgImp = "Lettura Tabella appoggio per creazione indici";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from qbe_reindex_ope
        if (Cursor_qbe_reindex_ope!=null)
          Cursor_qbe_reindex_ope.Close();
        Cursor_qbe_reindex_ope = new VQRHolder("qbe_reindex_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_reindex_ope.Eof())) {
          /* w_cDATREG := qbe_reindex_ope->CDATREG */
          w_cDATREG = Cursor_qbe_reindex_ope.GetString("CDATREG");
          // * --- Select from qbe_numprog_uif
          SPBridge.HMCaller _h0000012E;
          _h0000012E = new SPBridge.HMCaller();
          _h0000012E.Set("m_cVQRList",m_cVQRList);
          _h0000012E.Set("cDATREG",w_cDATREG);
          if (Cursor_qbe_numprog_uif!=null)
            Cursor_qbe_numprog_uif.Close();
          Cursor_qbe_numprog_uif = new VQRHolder("qbe_numprog_uif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000012E,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_numprog_uif.Eof())) {
            /* Legge tutte le operazioni Collegate */
            /* cProg := Utilities.GetAutonumber("POPERAGE2\'"+LRTrim(gAzienda)+"'",'',11) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAGE2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            /* cPrgImp := Utilities.GetAutonumber("PRGIMPOPEAGE\'"+LRTrim(gAzienda)+"'",0,10) */
            cPrgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPEAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
            // * --- Select from tmp_operazbo_ol
            m_cServer = m_Ctx.GetServer("tmp_operazbo_ol");
            m_cPhName = m_Ctx.GetPhName("tmp_operazbo_ol");
            if (Cursor_tmp_operazbo_ol!=null)
              Cursor_tmp_operazbo_ol.Close();
            Cursor_tmp_operazbo_ol = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_qbe_numprog_uif.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("tmp_operazbo_ol")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"STATOREG ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_operazbo_ol.Eof())) {
              /* cIDBASE := Utilities.GetAutonumber("POPERAGE1\'"+LRTrim(gAzienda)+"'",'',10) */
              cIDBASE = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAGE1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cIdReg := DateToChar(tmp_operazbo_ol->DATAOPE)+cProg+Right(LRTrim(tmp_operazbo_ol->IDEREG),1) */
              cIdReg = CPLib.DateToChar(Cursor_tmp_operazbo_ol.GetDate("DATAOPE"))+cProg+CPLib.Right(CPLib.LRTrim(Cursor_tmp_operazbo_ol.GetString("IDEREG")),1);
              /* cIdMod := iif(Empty(LRTrim(tmp_operazbo_ol->OPERAZMOD)),'',Left(tmp_operazbo_ol->OPERAZMOD,8)+cProg+Right(LRTrim(tmp_operazbo_ol->OPERAZMOD),1)) */
              cIdMod = (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_operazbo_ol.GetString("OPERAZMOD")))?"":CPLib.Left(Cursor_tmp_operazbo_ol.GetString("OPERAZMOD"),8)+cProg+CPLib.Right(CPLib.LRTrim(Cursor_tmp_operazbo_ol.GetString("OPERAZMOD")),1));
              // * --- Insert into jperazbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jperazbo");
              m_cPhName = m_Ctx.GetPhName("jperazbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jperazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000136")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000136(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cIDBASE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cIdMod,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("idcauana"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetDouble("NOPROT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cPrgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("DURAT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_operazbo_ol.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jperazbo",true);
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
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              Cursor_tmp_operazbo_ol.Next();
            }
            m_cConnectivityError = Cursor_tmp_operazbo_ol.ErrorMessage();
            Cursor_tmp_operazbo_ol.Close();
            // * --- End Select
            /* gMsgImp := 'Sono state reindicizzate '+LRTrim(Str(_conta,10,0))+' operazioni' // Messaggio allineamento 1 */
            gMsgImp = "Sono state reindicizzate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" operazioni";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            Cursor_qbe_numprog_uif.Next();
          }
          m_cConnectivityError = Cursor_qbe_numprog_uif.ErrorMessage();
          Cursor_qbe_numprog_uif.Close();
          // * --- End Select
          Cursor_qbe_reindex_ope.Next();
        }
        m_cConnectivityError = Cursor_qbe_reindex_ope.ErrorMessage();
        Cursor_qbe_reindex_ope.Close();
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000011Dstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000011Dstatus,cTry0000011Dmsg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_reindex_ope!=null)
          Cursor_qbe_reindex_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_numprog_uif!=null)
          Cursor_qbe_numprog_uif.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_operazbo_ol!=null)
          Cursor_tmp_operazbo_ol.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_7() throws Exception {
    CPResultSet Cursor_qbe_ridx_titlim=null;
    CPResultSet Cursor_qbe_reindex_tit=null;
    CPResultSet Cursor_qbe_numprog_tuif=null;
    CPResultSet Cursor_tmp_rapotit=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Reindicizza tabella titolari effettivi */
      // * --- Drop temporary table tmp_rapotit
      if (m_Ctx.IsSharedTemp("tmp_rapotit")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_rapotit")) {
          m_cServer = m_Ctx.GetServer("tmp_rapotit");
          m_cPhName = m_Ctx.GetPhName("tmp_rapotit");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_rapotit");
      }
      // * --- Create temporary table tmp_rapotit
      if (m_Ctx.IsSharedTemp("tmp_rapotit")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_rapotit")) {
          m_cServer = m_Ctx.GetServer("tmp_rapotit");
          m_cPhName = m_Ctx.GetPhName("tmp_rapotit");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_rapotit");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_rapotit");
      if ( ! (m_Ctx.IsSharedTemp("tmp_rapotit"))) {
        m_cServer = m_Ctx.GetServer("tmp_rapotit");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_rapotit",m_cServer,"proto")),m_cPhName,"tmp_rapotit",m_Ctx,new String[]{"IDBASE","NUMPROG","DATAOPE","DATAREG","CDATOPE","CDATREG"});
      }
      m_cPhName_tmp_rapotit = m_cPhName;
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000013Fstatus;
      nTry0000013Fstatus = m_Sql.GetTransactionStatus();
      String cTry0000013Fmsg;
      cTry0000013Fmsg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgImp := 'Creazione Tabella appoggio per ricostruzione indici' // Messaggio allineamento 1 */
        gMsgImp = "Creazione Tabella appoggio per ricostruzione indici";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If Empty(w_daData) */
        if (CPLib.Empty(w_daData)) {
          /* gMsgImp := 'Copia informazioni titolarità da riodinare' // Messaggio allineamento 1 */
          gMsgImp = "Copia informazioni titolarità da riodinare";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Insert into tmp_rapotit from sql
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_rapotit");
          m_cPhName = m_Ctx.GetPhName("tmp_rapotit");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_rapotit",m_Ctx.GetCompany());
          m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000143"),m_cServer,m_oWrInfo,"* ","from "+m_cPhName_rapotit+"","tmp_rapotit",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"tmp_rapotit"));
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* Cancella il file intestbo e scrive i record corretti */
          /* gMsgImp := 'Cancellazione dati da tabella titolari effettivi' // Messaggio allineamento 1 */
          gMsgImp = "Cancellazione dati da tabella titolari effettivi";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Delete from rapotit
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapotit");
          m_cPhName = m_Ctx.GetPhName("rapotit");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000146")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
          /* gMsgImp := 'Azzeramento progressivi' // Messaggio allineamento 1 */
          gMsgImp = "Azzeramento progressivi";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000148")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000149")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPTIT\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPTIT\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          /* gMsgImp := 'Copia informazioni titolarità da riodinare' // Messaggio allineamento 1 */
          gMsgImp = "Copia informazioni titolarità da riodinare";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Create temporary table tmp_rapotit
          if (m_Ctx.IsSharedTemp("tmp_rapotit")) {
            if (m_Ctx.IsTmpAlreadyCreated("tmp_rapotit")) {
              m_cServer = m_Ctx.GetServer("tmp_rapotit");
              m_cPhName = m_Ctx.GetPhName("tmp_rapotit");
              m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
            }
          } else {
            m_Ctx.DropTmp("tmp_rapotit");
          }
          m_cPhName = m_Ctx.CreateTmpPhName("tmp_rapotit");
          new VQRHolder("qbe_ridx_rapotit",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).CreateServerQuery(m_Ctx, "tmp_rapotit",false,new String[]{"DATAOPE","STATOREG"});
          m_cPhName_tmp_rapotit = m_cPhName;
          /* Cancella il file intestbo e scrive i record corretti */
          /* gMsgImp := 'Cancellazione dati da tabella titolari effettivi' // Messaggio allineamento 1 */
          gMsgImp = "Cancellazione dati da tabella titolari effettivi";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Delete from rapotit
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapotit");
          m_cPhName = m_Ctx.GetPhName("rapotit");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"0000014E")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"DATAREG >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_daData,"?",0,0,m_cServer),m_cServer,w_daData)+"";
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
          /* gMsgImp := 'Azzeramento progressivi' // Messaggio allineamento 1 */
          gMsgImp = "Azzeramento progressivi";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Select from qbe_ridx_titlim
          if (Cursor_qbe_ridx_titlim!=null)
            Cursor_qbe_ridx_titlim.Close();
          Cursor_qbe_ridx_titlim = new VQRHolder("qbe_ridx_titlim",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_ridx_titlim.Eof())) {
            // * --- Write into cpwarn from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000151")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(Cursor_qbe_ridx_titlim.GetString("MAXNPRG"),"N",10,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
            m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
            // * --- Write into cpwarn from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000152")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(Cursor_qbe_ridx_titlim.GetDouble("MAXPOPE"),"N",10,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPTIT\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPTIT\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
            m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
            Cursor_qbe_ridx_titlim.Next();
          }
          m_cConnectivityError = Cursor_qbe_ridx_titlim.ErrorMessage();
          Cursor_qbe_ridx_titlim.Close();
          // * --- End Select
        } // End If
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* gMsgImp := 'Lettura Tabella appoggio per creazione indici' // Messaggio allineamento 1 */
        gMsgImp = "Lettura Tabella appoggio per creazione indici";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from qbe_reindex_tit
        if (Cursor_qbe_reindex_tit!=null)
          Cursor_qbe_reindex_tit.Close();
        Cursor_qbe_reindex_tit = new VQRHolder("qbe_reindex_tit",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_reindex_tit.Eof())) {
          /* w_cDATREG := qbe_reindex_tit->CDATREG */
          w_cDATREG = Cursor_qbe_reindex_tit.GetString("CDATREG");
          // * --- Select from qbe_numprog_tuif
          SPBridge.HMCaller _h00000157;
          _h00000157 = new SPBridge.HMCaller();
          _h00000157.Set("m_cVQRList",m_cVQRList);
          _h00000157.Set("cDATREG",w_cDATREG);
          if (Cursor_qbe_numprog_tuif!=null)
            Cursor_qbe_numprog_tuif.Close();
          Cursor_qbe_numprog_tuif = new VQRHolder("qbe_numprog_tuif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000157,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_numprog_tuif.Eof())) {
            /* Legge tutte le operazioni Collegate */
            /* cProg := Utilities.GetAutonumber("PRGTITO2\'"+LRTrim(gAzienda)+"'",'',11) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            /* cPrgImp := Utilities.GetAutonumber("PRGIMPTIT\'"+LRTrim(gAzienda)+"'",0,10) */
            cPrgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPTIT\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
            // * --- Select from tmp_rapotit
            m_cServer = m_Ctx.GetServer("tmp_rapotit");
            m_cPhName = m_Ctx.GetPhName("tmp_rapotit");
            if (Cursor_tmp_rapotit!=null)
              Cursor_tmp_rapotit.Close();
            Cursor_tmp_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_qbe_numprog_tuif.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("tmp_rapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"STATOREG ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_rapotit.Eof())) {
              /* cIDB2 := LibreriaMit.UniqueId() */
              cIDB2 = LibreriaMit.UniqueId();
              /* cIDBASE := Utilities.GetAutonumber("PRGTITO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cIDBASE = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGTITO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cIdReg := 'T'+Right(cProg,9)+cIDB2 */
              cIdReg = "T"+CPLib.Right(cProg,9)+cIDB2;
              /* cIdMod := iif(Empty(LRTrim(tmp_rapotit->OPERAZMOD)),'',Left(tmp_rapotit->OPERAZMOD,8)+cProg+Right(LRTrim(tmp_rapotit->OPERAZMOD),1)) */
              cIdMod = (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_rapotit.GetString("OPERAZMOD")))?"":CPLib.Left(Cursor_tmp_rapotit.GetString("OPERAZMOD"),8)+cProg+CPLib.Right(CPLib.LRTrim(Cursor_tmp_rapotit.GetString("OPERAZMOD")),1));
              // * --- Insert into rapotit from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("rapotit");
              m_cPhName = m_Ctx.GetPhName("rapotit");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000160")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000160(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cIDBASE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cIdReg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cIdMod,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetDate("DATAAGE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cPrgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_tmp_rapotit.GetDate("DATAOPE")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_rapotit.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(Cursor_tmp_rapotit.GetDate("DATAREG")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cIDB2,"?",0,0,m_cServer)+", ";
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
                throw new RoutineException();
              }
              // * --- Write into intestit from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("intestit");
              m_cPhName = m_Ctx.GetPhName("intestit");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestit",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000161")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(cProg,"C",11,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(Cursor_tmp_rapotit.GetDate("DATAOPE"),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestit",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_rapotit.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_rapotit.GetString("CONNESCLI"))+"";
              m_cSql = m_cSql+" and NUMPROG1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_rapotit.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_rapotit.GetString("NUMPROG"))+"";
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
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              // * --- Delete from tmp_rapotit
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_rapotit");
              m_cPhName = m_Ctx.GetPhName("tmp_rapotit");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_rapotit",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000163")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_rapotit.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_rapotit.GetString("IDBASE"))+"";
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
              /* gMsgImp := 'Sono state reindicizzate '+LRTrim(Str(_conta,10,0))+' informazioni su titolari effettivi UIF' // Messaggio allineamento 1 */
              gMsgImp = "Sono state reindicizzate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" informazioni su titolari effettivi UIF";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              Cursor_tmp_rapotit.Next();
            }
            m_cConnectivityError = Cursor_tmp_rapotit.ErrorMessage();
            Cursor_tmp_rapotit.Close();
            // * --- End Select
            Cursor_qbe_numprog_tuif.Next();
          }
          m_cConnectivityError = Cursor_qbe_numprog_tuif.ErrorMessage();
          Cursor_qbe_numprog_tuif.Close();
          // * --- End Select
          Cursor_qbe_reindex_tit.Next();
        }
        m_cConnectivityError = Cursor_qbe_reindex_tit.ErrorMessage();
        Cursor_qbe_reindex_tit.Close();
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000013Fstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000013Fstatus,cTry0000013Fmsg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_ridx_titlim!=null)
          Cursor_qbe_ridx_titlim.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_reindex_tit!=null)
          Cursor_qbe_reindex_tit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_numprog_tuif!=null)
          Cursor_qbe_numprog_tuif.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_rapotit!=null)
          Cursor_tmp_rapotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_8() throws Exception {
    CPResultSet Cursor_qbe_reindex_opewu=null;
    CPResultSet Cursor_qbe_numprog_wu=null;
    CPResultSet Cursor_zperazbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Crea il file appoggio */
      /* gMsgImp := 'Creazione Tabella appoggio per ricostruzione indici' // Messaggio allineamento 1 */
      gMsgImp = "Creazione Tabella appoggio per ricostruzione indici";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000016Astatus;
      nTry0000016Astatus = m_Sql.GetTransactionStatus();
      String cTry0000016Amsg;
      cTry0000016Amsg = m_Sql.TransactionErrorMessage();
      try {
        /* If w_flgpart='N' */
        if (CPLib.eqr(w_flgpart,"N")) {
          /* gMsgImp := 'Azzeramento progressivi' // Messaggio allineamento 1 */
          gMsgImp = "Azzeramento progressivi";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"0000016D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"0000016E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"0000016F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(0,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          /* gMsgImp := 'Allineamento progressivi' // Messaggio allineamento 1 */
          gMsgImp = "Allineamento progressivi";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000171")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(w_prgnprg,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000172")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(w_prgidb,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000173")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(w_prgiope,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* gMsgImp := 'Lettura Tabella appoggio per creazione indici' // Messaggio allineamento 1 */
        gMsgImp = "Lettura Tabella appoggio per creazione indici";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from qbe_reindex_opewu
        if (Cursor_qbe_reindex_opewu!=null)
          Cursor_qbe_reindex_opewu.Close();
        Cursor_qbe_reindex_opewu = new VQRHolder("qbe_reindex_opewu",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_reindex_opewu.Eof())) {
          /* w_cDATREG := qbe_reindex_opewu->CDATREG */
          w_cDATREG = Cursor_qbe_reindex_opewu.GetString("CDATREG");
          // * --- Select from qbe_numprog_wu
          SPBridge.HMCaller _h00000178;
          _h00000178 = new SPBridge.HMCaller();
          _h00000178.Set("m_cVQRList",m_cVQRList);
          _h00000178.Set("cDATREG",w_cDATREG);
          if (Cursor_qbe_numprog_wu!=null)
            Cursor_qbe_numprog_wu.Close();
          Cursor_qbe_numprog_wu = new VQRHolder("qbe_numprog_wu",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000178,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_numprog_wu.Eof())) {
            /* Legge tutte le operazioni Collegate */
            /* cProg := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(gAzienda)+"'",'',11) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            /* cPrgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,10) */
            cPrgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
            // * --- Select from zperazbo
            m_cServer = m_Ctx.GetServer("zperazbo");
            m_cPhName = m_Ctx.GetPhName("zperazbo");
            if (Cursor_zperazbo!=null)
              Cursor_zperazbo.Close();
            Cursor_zperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPLib.ToSQL(Cursor_qbe_numprog_wu.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("zperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"STATOREG ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_zperazbo.Eof())) {
              /* cIDBASE := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",'',10) */
              cIDBASE = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* cIdReg := DateToChar(zperazbo->DATAOPE)+cProg+Right(LRTrim(zperazbo->IDEREG),1) */
              cIdReg = CPLib.DateToChar(Cursor_zperazbo.GetDate("DATAOPE"))+cProg+CPLib.Right(CPLib.LRTrim(Cursor_zperazbo.GetString("IDEREG")),1);
              /* cIdMod := iif(Empty(LRTrim(zperazbo->OPERAZMOD)),'',Left(zperazbo->OPERAZMOD,8)+cProg+Right(LRTrim(zperazbo->OPERAZMOD),1)) */
              cIdMod = (CPLib.Empty(CPLib.LRTrim(Cursor_zperazbo.GetString("OPERAZMOD")))?"":CPLib.Left(Cursor_zperazbo.GetString("OPERAZMOD"),8)+cProg+CPLib.Right(CPLib.LRTrim(Cursor_zperazbo.GetString("OPERAZMOD")),1));
              // * --- Insert into operazbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("operazbo");
              m_cPhName = m_Ctx.GetPhName("operazbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_riordina",197,"00000180")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000180(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cIDBASE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cIdMod,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetDouble("NOPROT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cPrgImp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetDate("DATAIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_zperazbo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
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
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              Cursor_zperazbo.Next();
            }
            m_cConnectivityError = Cursor_zperazbo.ErrorMessage();
            Cursor_zperazbo.Close();
            // * --- End Select
            /* gMsgImp := 'Sono state reindicizzate '+LRTrim(Str(_conta,10,0))+' operazioni' // Messaggio allineamento 1 */
            gMsgImp = "Sono state reindicizzate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" operazioni";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            Cursor_qbe_numprog_wu.Next();
          }
          m_cConnectivityError = Cursor_qbe_numprog_wu.ErrorMessage();
          Cursor_qbe_numprog_wu.Close();
          // * --- End Select
          Cursor_qbe_reindex_opewu.Next();
        }
        m_cConnectivityError = Cursor_qbe_reindex_opewu.ErrorMessage();
        Cursor_qbe_reindex_opewu.Close();
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000016Astatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000016Astatus,cTry0000016Amsg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_reindex_opewu!=null)
          Cursor_qbe_reindex_opewu.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_numprog_wu!=null)
          Cursor_qbe_numprog_wu.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_zperazbo!=null)
          Cursor_zperazbo.Close();
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
      m_Caller.SetString("frzuif","C",1,0,w_frzuif);
      m_Caller.SetString("opeage","C",1,0,w_opeage);
      m_Caller.SetString("opeuif","C",1,0,w_opeuif);
      m_Caller.SetString("rapage","C",1,0,w_rapage);
      m_Caller.SetString("rapuif","C",1,0,w_rapuif);
      m_Caller.SetString("titaui","C",1,0,w_titaui);
      m_Caller.SetString("flgpart","C",1,0,w_flgpart);
      m_Caller.SetNumber("prgidb","N",10,0,w_prgidb);
      m_Caller.SetNumber("prgnprg","N",10,0,w_prgnprg);
      m_Caller.SetNumber("prgiope","N",10,0,w_prgiope);
      m_Caller.SetDate("daData","D",8,0,w_daData);
      m_Caller.SetString("dataover","C",1,0,w_dataover);
      m_Caller.SetNumber("ngiorni","N",2,0,w_ngiorni);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_riordinaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_riordinaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_frzuif = m_Caller.GetString("frzuif","C",1,0);
    w_opeage = m_Caller.GetString("opeage","C",1,0);
    w_opeuif = m_Caller.GetString("opeuif","C",1,0);
    w_rapage = m_Caller.GetString("rapage","C",1,0);
    w_rapuif = m_Caller.GetString("rapuif","C",1,0);
    w_titaui = m_Caller.GetString("titaui","C",1,0);
    w_flgpart = m_Caller.GetString("flgpart","C",1,0);
    w_prgidb = m_Caller.GetNumber("prgidb","N",10,0);
    w_prgnprg = m_Caller.GetNumber("prgnprg","N",10,0);
    w_prgiope = m_Caller.GetNumber("prgiope","N",10,0);
    w_daData = m_Caller.GetDate("daData","D",8,0);
    w_dataover = m_Caller.GetString("dataover","C",1,0);
    w_ngiorni = m_Caller.GetNumber("ngiorni","N",2,0);
    cProg = CPLib.Space(11);
    cProg1 = CPLib.Space(10);
    cIDBASE = CPLib.Space(10);
    cIDB2 = CPLib.Space(10);
    cIdReg = CPLib.Space(20);
    cIdMod = CPLib.Space(20);
    cTipRap = CPLib.Space(2);
    cFlgRap = CPLib.Space(1);
    cPrgImp = 0;
    cOldProg = CPLib.Space(11);
    w_cDATREG = CPLib.Space(8);
    _conta = 0;
    mycProg = CPLib.Space(11);
    mycPrgImp = 0;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gFlgWU=m_Ctx.GetGlobalString("gFlgWU");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_ridx_rapopebo,qbe_ridx_raplim,qbe_reindex_rap,qbe_numprog_ruif,qbe_ridx_operazbo,qbe_ridx_opelim,qbe_reindex_ope,qbe_reindex_ope,qbe_numprog_uif,qbe_ridx_fraziobo,qbe_ridx_frzlim,qbe_reindex_frz,qbe_numprog_fuif,qbe_reindex_ope,qbe_numprog_uif,qbe_ridx_rapotit,qbe_ridx_titlim,qbe_reindex_tit,qbe_numprog_tuif,qbe_reindex_opewu,qbe_numprog_wu,
  public static final String m_cVQRList = ",qbe_ridx_rapopebo,qbe_ridx_raplim,qbe_reindex_rap,qbe_numprog_ruif,qbe_ridx_operazbo,qbe_ridx_opelim,qbe_reindex_ope,qbe_reindex_ope,qbe_numprog_uif,qbe_ridx_fraziobo,qbe_ridx_frzlim,qbe_reindex_frz,qbe_numprog_fuif,qbe_reindex_ope,qbe_numprog_uif,qbe_ridx_rapotit,qbe_ridx_titlim,qbe_reindex_tit,qbe_numprog_tuif,qbe_reindex_opewu,qbe_numprog_wu,";
  // ENTITY_BATCHES: ,arfn_datesum,
  public static final String i_InvokedRoutines = ",arfn_datesum,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000005E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000080(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"japopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000010E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
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
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000136(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000160(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"NUMPROG,";
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
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPTIT,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapotit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000180(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"PRGIMPOPE,";
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
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
}
