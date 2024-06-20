// * --- Area Manuale = BO - Header
// * --- afterlogin
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;
// * --- Fine Area Manuale
public class afterloginR implements CallerWithObjs {
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_webaos_agg_soggetti;
  public String m_cServer_webaos_agg_soggetti;
  public String m_cPhName_tmp_tipoleg;
  public String m_cServer_tmp_tipoleg;
  public String m_cPhName_tbtipleg;
  public String m_cServer_tbtipleg;
  public String m_cPhName_cpusers_add;
  public String m_cServer_cpusers_add;
  public String m_cPhName_tmp_mezzipag;
  public String m_cServer_tmp_mezzipag;
  public String m_cPhName_cgo_tbmezpag;
  public String m_cServer_cgo_tbmezpag;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_cpgroups;
  public String m_cServer_cpgroups;
  public String m_cPhName_cpprgsec;
  public String m_cServer_cpprgsec;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
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
  public double gUserCode;
  public java.sql.Date gDatDel;
  public java.sql.Date gDatTra;
  public java.sql.Date gDatTER;
  public String gIntemediario;
  public String gTipInter;
  public String gPathApp;
  public String gUrlApp;
  public String cActLog;
  public String gFlgWU;
  public String gSeekAos;
  public String gSblocco;
  public String gEmail;
  public String gDescAzi;
  public String gChkDate;
  public String gAzienda;
  public String gFatRis;
  public String gTelepass;
  public String gFlgDoc;
  public String gCodDip;
  public String gFlgCMod;
  public double gFlgDTP;
  public double gVLT;
  public double gVNP;
  public String gStpDwn;
  public String gWebCHK;
  public String gIPC;
  public String gIPS;
  public String gIPSP;
  public String gIPP;
  public String gFlgRet;
  public java.sql.Date gDataTito;
  public java.sql.Date gScadSaldi;
  public String gFlgIPMT;
  public String gGesDoc;
  public java.sql.Date gDataVaria;
  public String gAgeCGO;
  public double gScadTrx;
  public String gPathDoc;
  public String gAggTabs;
  public String gTipMul;
  public String gQADV;
  public String gSuperDIP;
  public String gVerImp;
  public boolean chkfile;
  public String cAnno;
  public double nMese;
  public String cMese;
  public String cGiorno;
  public double w_utentecp;
  public java.sql.Date _datini;
  public java.sql.Date _datfin;
  public double _aggage;
  public double _conta;
  public String fhand;
  public String riga;
  public boolean creadir;
  public String _tipo;
  public String _idsid;
  public String _datatabs;
  public String _data_agg;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public afterloginR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("afterlogin",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_webaos_agg_soggetti = p_ContextObject.GetPhName("webaos_agg_soggetti");
    if (m_cPhName_webaos_agg_soggetti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_webaos_agg_soggetti = m_cPhName_webaos_agg_soggetti+" "+m_Ctx.GetWritePhName("webaos_agg_soggetti");
    }
    m_cServer_webaos_agg_soggetti = p_ContextObject.GetServer("webaos_agg_soggetti");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_tipoleg")) {
      m_cPhName_tmp_tipoleg = p_ContextObject.GetPhName("tmp_tipoleg");
      if (m_cPhName_tmp_tipoleg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_tipoleg = m_cPhName_tmp_tipoleg+" "+m_Ctx.GetWritePhName("tmp_tipoleg");
      }
      m_cServer_tmp_tipoleg = p_ContextObject.GetServer("tmp_tipoleg");
    }
    m_cPhName_tbtipleg = p_ContextObject.GetPhName("tbtipleg");
    if (m_cPhName_tbtipleg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipleg = m_cPhName_tbtipleg+" "+m_Ctx.GetWritePhName("tbtipleg");
    }
    m_cServer_tbtipleg = p_ContextObject.GetServer("tbtipleg");
    m_cPhName_cpusers_add = p_ContextObject.GetPhName("cpusers_add");
    if (m_cPhName_cpusers_add.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers_add = m_cPhName_cpusers_add+" "+m_Ctx.GetWritePhName("cpusers_add");
    }
    m_cServer_cpusers_add = p_ContextObject.GetServer("cpusers_add");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_mezzipag")) {
      m_cPhName_tmp_mezzipag = p_ContextObject.GetPhName("tmp_mezzipag");
      if (m_cPhName_tmp_mezzipag.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_mezzipag = m_cPhName_tmp_mezzipag+" "+m_Ctx.GetWritePhName("tmp_mezzipag");
      }
      m_cServer_tmp_mezzipag = p_ContextObject.GetServer("tmp_mezzipag");
    }
    m_cPhName_cgo_tbmezpag = p_ContextObject.GetPhName("cgo_tbmezpag");
    if (m_cPhName_cgo_tbmezpag.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_tbmezpag = m_cPhName_cgo_tbmezpag+" "+m_Ctx.GetWritePhName("cgo_tbmezpag");
    }
    m_cServer_cgo_tbmezpag = p_ContextObject.GetServer("cgo_tbmezpag");
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
    m_cPhName_cpgroups = p_ContextObject.GetPhName("cpgroups");
    if (m_cPhName_cpgroups.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpgroups = m_cPhName_cpgroups+" "+m_Ctx.GetWritePhName("cpgroups");
    }
    m_cServer_cpgroups = p_ContextObject.GetServer("cpgroups");
    m_cPhName_cpprgsec = p_ContextObject.GetPhName("cpprgsec");
    if (m_cPhName_cpprgsec.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpprgsec = m_cPhName_cpprgsec+" "+m_Ctx.GetWritePhName("cpprgsec");
    }
    m_cServer_cpprgsec = p_ContextObject.GetServer("cpprgsec");
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    if (m_cPhName_tbcauana.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcauana = m_cPhName_tbcauana+" "+m_Ctx.GetWritePhName("tbcauana");
    }
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      return gUserCode;
    }
    if (CPLib.eqr("gFlgDTP",p_cVarName)) {
      return gFlgDTP;
    }
    if (CPLib.eqr("gVLT",p_cVarName)) {
      return gVLT;
    }
    if (CPLib.eqr("gVNP",p_cVarName)) {
      return gVNP;
    }
    if (CPLib.eqr("gScadTrx",p_cVarName)) {
      return gScadTrx;
    }
    if (CPLib.eqr("nMese",p_cVarName)) {
      return nMese;
    }
    if (CPLib.eqr("utentecp",p_cVarName)) {
      return w_utentecp;
    }
    if (CPLib.eqr("_aggage",p_cVarName)) {
      return _aggage;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "afterlogin";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      return gTipInter;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("cActLog",p_cVarName)) {
      return cActLog;
    }
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      return gFlgWU;
    }
    if (CPLib.eqr("gSeekAos",p_cVarName)) {
      return gSeekAos;
    }
    if (CPLib.eqr("gSblocco",p_cVarName)) {
      return gSblocco;
    }
    if (CPLib.eqr("gEmail",p_cVarName)) {
      return gEmail;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gChkDate",p_cVarName)) {
      return gChkDate;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gFatRis",p_cVarName)) {
      return gFatRis;
    }
    if (CPLib.eqr("gTelepass",p_cVarName)) {
      return gTelepass;
    }
    if (CPLib.eqr("gFlgDoc",p_cVarName)) {
      return gFlgDoc;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
    }
    if (CPLib.eqr("gFlgCMod",p_cVarName)) {
      return gFlgCMod;
    }
    if (CPLib.eqr("gStpDwn",p_cVarName)) {
      return gStpDwn;
    }
    if (CPLib.eqr("gWebCHK",p_cVarName)) {
      return gWebCHK;
    }
    if (CPLib.eqr("gIPC",p_cVarName)) {
      return gIPC;
    }
    if (CPLib.eqr("gIPS",p_cVarName)) {
      return gIPS;
    }
    if (CPLib.eqr("gIPSP",p_cVarName)) {
      return gIPSP;
    }
    if (CPLib.eqr("gIPP",p_cVarName)) {
      return gIPP;
    }
    if (CPLib.eqr("gFlgRet",p_cVarName)) {
      return gFlgRet;
    }
    if (CPLib.eqr("gFlgIPMT",p_cVarName)) {
      return gFlgIPMT;
    }
    if (CPLib.eqr("gGesDoc",p_cVarName)) {
      return gGesDoc;
    }
    if (CPLib.eqr("gAgeCGO",p_cVarName)) {
      return gAgeCGO;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gAggTabs",p_cVarName)) {
      return gAggTabs;
    }
    if (CPLib.eqr("gTipMul",p_cVarName)) {
      return gTipMul;
    }
    if (CPLib.eqr("gQADV",p_cVarName)) {
      return gQADV;
    }
    if (CPLib.eqr("gSuperDIP",p_cVarName)) {
      return gSuperDIP;
    }
    if (CPLib.eqr("gVerImp",p_cVarName)) {
      return gVerImp;
    }
    if (CPLib.eqr("cAnno",p_cVarName)) {
      return cAnno;
    }
    if (CPLib.eqr("cMese",p_cVarName)) {
      return cMese;
    }
    if (CPLib.eqr("cGiorno",p_cVarName)) {
      return cGiorno;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("_tipo",p_cVarName)) {
      return _tipo;
    }
    if (CPLib.eqr("_idsid",p_cVarName)) {
      return _idsid;
    }
    if (CPLib.eqr("_datatabs",p_cVarName)) {
      return _datatabs;
    }
    if (CPLib.eqr("_data_agg",p_cVarName)) {
      return _data_agg;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gDatDel",p_cVarName)) {
      return gDatDel;
    }
    if (CPLib.eqr("gDatTra",p_cVarName)) {
      return gDatTra;
    }
    if (CPLib.eqr("gDatTER",p_cVarName)) {
      return gDatTER;
    }
    if (CPLib.eqr("gDataTito",p_cVarName)) {
      return gDataTito;
    }
    if (CPLib.eqr("gScadSaldi",p_cVarName)) {
      return gScadSaldi;
    }
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      return gDataVaria;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      return _datfin;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("chkfile",p_cVarName)) {
      return chkfile;
    }
    if (CPLib.eqr("creadir",p_cVarName)) {
      return creadir;
    }
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
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      gUserCode = value;
      return;
    }
    if (CPLib.eqr("gFlgDTP",p_cVarName)) {
      gFlgDTP = value;
      return;
    }
    if (CPLib.eqr("gVLT",p_cVarName)) {
      gVLT = value;
      return;
    }
    if (CPLib.eqr("gVNP",p_cVarName)) {
      gVNP = value;
      return;
    }
    if (CPLib.eqr("gScadTrx",p_cVarName)) {
      gScadTrx = value;
      return;
    }
    if (CPLib.eqr("nMese",p_cVarName)) {
      nMese = value;
      return;
    }
    if (CPLib.eqr("utentecp",p_cVarName)) {
      w_utentecp = value;
      return;
    }
    if (CPLib.eqr("_aggage",p_cVarName)) {
      _aggage = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      gTipInter = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("cActLog",p_cVarName)) {
      cActLog = value;
      return;
    }
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      gFlgWU = value;
      return;
    }
    if (CPLib.eqr("gSeekAos",p_cVarName)) {
      gSeekAos = value;
      return;
    }
    if (CPLib.eqr("gSblocco",p_cVarName)) {
      gSblocco = value;
      return;
    }
    if (CPLib.eqr("gEmail",p_cVarName)) {
      gEmail = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
    if (CPLib.eqr("gChkDate",p_cVarName)) {
      gChkDate = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gFatRis",p_cVarName)) {
      gFatRis = value;
      return;
    }
    if (CPLib.eqr("gTelepass",p_cVarName)) {
      gTelepass = value;
      return;
    }
    if (CPLib.eqr("gFlgDoc",p_cVarName)) {
      gFlgDoc = value;
      return;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
      return;
    }
    if (CPLib.eqr("gFlgCMod",p_cVarName)) {
      gFlgCMod = value;
      return;
    }
    if (CPLib.eqr("gStpDwn",p_cVarName)) {
      gStpDwn = value;
      return;
    }
    if (CPLib.eqr("gWebCHK",p_cVarName)) {
      gWebCHK = value;
      return;
    }
    if (CPLib.eqr("gIPC",p_cVarName)) {
      gIPC = value;
      return;
    }
    if (CPLib.eqr("gIPS",p_cVarName)) {
      gIPS = value;
      return;
    }
    if (CPLib.eqr("gIPSP",p_cVarName)) {
      gIPSP = value;
      return;
    }
    if (CPLib.eqr("gIPP",p_cVarName)) {
      gIPP = value;
      return;
    }
    if (CPLib.eqr("gFlgRet",p_cVarName)) {
      gFlgRet = value;
      return;
    }
    if (CPLib.eqr("gFlgIPMT",p_cVarName)) {
      gFlgIPMT = value;
      return;
    }
    if (CPLib.eqr("gGesDoc",p_cVarName)) {
      gGesDoc = value;
      return;
    }
    if (CPLib.eqr("gAgeCGO",p_cVarName)) {
      gAgeCGO = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gAggTabs",p_cVarName)) {
      gAggTabs = value;
      return;
    }
    if (CPLib.eqr("gTipMul",p_cVarName)) {
      gTipMul = value;
      return;
    }
    if (CPLib.eqr("gQADV",p_cVarName)) {
      gQADV = value;
      return;
    }
    if (CPLib.eqr("gSuperDIP",p_cVarName)) {
      gSuperDIP = value;
      return;
    }
    if (CPLib.eqr("gVerImp",p_cVarName)) {
      gVerImp = value;
      return;
    }
    if (CPLib.eqr("cAnno",p_cVarName)) {
      cAnno = value;
      return;
    }
    if (CPLib.eqr("cMese",p_cVarName)) {
      cMese = value;
      return;
    }
    if (CPLib.eqr("cGiorno",p_cVarName)) {
      cGiorno = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("_tipo",p_cVarName)) {
      _tipo = value;
      return;
    }
    if (CPLib.eqr("_idsid",p_cVarName)) {
      _idsid = value;
      return;
    }
    if (CPLib.eqr("_datatabs",p_cVarName)) {
      _datatabs = value;
      return;
    }
    if (CPLib.eqr("_data_agg",p_cVarName)) {
      _data_agg = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("gDatDel",p_cVarName)) {
      gDatDel = value;
      return;
    }
    if (CPLib.eqr("gDatTra",p_cVarName)) {
      gDatTra = value;
      return;
    }
    if (CPLib.eqr("gDatTER",p_cVarName)) {
      gDatTER = value;
      return;
    }
    if (CPLib.eqr("gDataTito",p_cVarName)) {
      gDataTito = value;
      return;
    }
    if (CPLib.eqr("gScadSaldi",p_cVarName)) {
      gScadSaldi = value;
      return;
    }
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      gDataVaria = value;
      return;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      _datfin = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("chkfile",p_cVarName)) {
      chkfile = value;
      return;
    }
    if (CPLib.eqr("creadir",p_cVarName)) {
      creadir = value;
      return;
    }
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
    CPResultSet Cursor_webaos_agg_soggetti=null;
    CPResultSet Cursor_tbtipleg=null;
    CPResultSet Cursor_cgo_tbmezpag=null;
    CPResultSet Cursor_cpusers_add=null;
    try {
      /* gUserCode Numeric(4, 0) // Codice Utente CP */
      /* gDatDel Date // Data Massima Cancellazione Operazioni */
      /* gDatTra Date // Data Massima Trasf a Storico */
      /* gDatTER Date // Data Massima Trasf a Storico */
      /* gIntemediario Char(11) // Intermediario */
      /* gTipInter Char(2) // Tipo Intermediario */
      /* gPathApp Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* cActLog Char(1) // Log Applicazione */
      /* gFlgWU Char(1) // Gestione WU */
      /* gSeekAos Char(1) // Collegamento con AOS */
      /* gSblocco Char(1) // Sblocco controllo */
      /* gEmail Char(40) // Email Utente */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gChkDate Char(1) // Controllo Date */
      /* gAzienda Char(10) // Azienda */
      /* gFatRis Char(1) // Fattore Rischio */
      /* gTelepass Char(1) // Versione Telepass */
      /* gFlgDoc Char(1) // Collegamento con storico documenti */
      /* gCodDip Char(6) // Dipendenza */
      /* gFlgCMod Char(1) // Crea Record Modifica */
      /* gFlgDTP Numeric(1, 0) // Forza Data Trasferimento Provvisorie */
      /* gVLT Numeric(10, 2) // Limite VLT */
      /* gVNP Numeric(10, 2) // Limite VNT */
      /* gStpDwn Char(1) // Stampa Download */
      /* gWebCHK Char(1) // Collegamento a WEBCHK */
      /* gIPC Char(20) // IPClient */
      /* gIPS Char(120) // IPServer */
      /* gIPSP Char(20) // Porta Server */
      /* gIPP Char(10) // Protocollo URL */
      /* gFlgRet Char(1) // Flag Creazione File di Ritorno */
      /* gDataTito Date // Data per Titolari Effettivi */
      /* gScadSaldi Date // Scadenza Invio Saldi */
      /* gFlgIPMT Char(1) // IP MoneyTrasfer */
      /* gGesDoc Char(1) // Gestione Documentale */
      /* gDataVaria Date // Data Variazione */
      /* gAgeCGO Char(1) // Creazione Automatica agente */
      /* gScadTrx Numeric(3, 0) // Giorni Alert Transazioni */
      /* gPathDoc Char(128) // Path Documenti */
      /* gAggTabs Char(1) // Aggiornamento Tabelle */
      /* gTipMul Char(3) // Tipo Gioco Multiple (CGO) */
      /* gQADV Char(1) // Attiva Questionario QADV */
      /* gSuperDIP Char(1) // SuperUser Dipendenza */
      /* gVerImp Char(1) // Verifica da import */
      /* chkfile Bool */
      /* cAnno Char(4) */
      /* nMese Numeric(2, 0) */
      /* cMese Char(2) */
      /* cGiorno Char(2) */
      /* w_utentecp Numeric(4, 0) */
      /* _datini Date */
      /* _datfin Date */
      /* _aggage Numeric(1, 0) */
      /* _conta Numeric(1, 0) */
      /* fhand Char(1) */
      /* riga Memo */
      /* creadir Bool */
      /* _tipo Char(1) */
      /* _idsid Char(8) := '' */
      _idsid = "";
      /* _datatabs Char(8) */
      /* _data_agg Char(8) */
      /* gSblocco := 'N' // Sblocco controllo */
      gSblocco = "N";
      m_Ctx.SetGlobalString("gSblocco",gSblocco);
      /* cAnno := Str(Year(Date()),4,0) */
      cAnno = CPLib.Str(CPLib.Year(CPLib.Date()),4,0);
      /* nMese := Month(Date()) */
      nMese = CPLib.Round(CPLib.Month(CPLib.Date()),0);
      /* Case nMese = 1 */
      if (CPLib.eqr(nMese,1)) {
        /* cMese := '10' */
        cMese = "10";
        /* Case nMese = 2 */
      } else if (CPLib.eqr(nMese,2)) {
        /* cMese := '11' */
        cMese = "11";
        /* Case nMese = 3 */
      } else if (CPLib.eqr(nMese,3)) {
        /* cMese := '12' */
        cMese = "12";
      } else { // Otherwise
        /* cMese := Right('00'+LRTrim(Str(nMese - 3,2,0)),2) */
        cMese = CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(nMese-3,2,0)),2);
      } // End Case
      /* cGiorno := Right('00'+LRTrim(Str(Day(Date()),2,0)),2) */
      cGiorno = CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Day(CPLib.Date()),2,0)),2);
      /* gDatTra := CharToDate(cAnno+cMese+cGiorno) // Data Massima Trasf a Storico */
      gDatTra = CPLib.CharToDate(cAnno+cMese+cGiorno);
      m_Ctx.SetGlobalDate("gDatTra",gDatTra);
      /* cAnno := Str(Year(Date()) - 10,4,0) */
      cAnno = CPLib.Str(CPLib.Year(CPLib.Date())-10,4,0);
      /* cMese := Right('00'+LRTrim(Str(Month(Date()),2,0)),2) */
      cMese = CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(CPLib.Date()),2,0)),2);
      /* cGiorno := Right('00'+LRTrim(Str(Day(Date()),2,0)),2) */
      cGiorno = CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Day(CPLib.Date()),2,0)),2);
      /* gDatDel := CharToDate(cAnno+cMese+cGiorno) // Data Massima Cancellazione Operazioni */
      gDatDel = CPLib.CharToDate(cAnno+cMese+cGiorno);
      m_Ctx.SetGlobalDate("gDatDel",gDatDel);
      /* w_utentecp := 0 */
      w_utentecp = CPLib.Round(0,0);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* w_utentecp := 1 */
        w_utentecp = CPLib.Round(1,0);
        /* gIntemediario := intermbo->CODINTER // Intermediario */
        gIntemediario = Cursor_intermbo.GetString("CODINTER");
        m_Ctx.SetGlobalString("gIntemediario",gIntemediario);
        /* gTipInter := intermbo->TIPINTER // Tipo Intermediario */
        gTipInter = Cursor_intermbo.GetString("TIPINTER");
        m_Ctx.SetGlobalString("gTipInter",gTipInter);
        /* cActLog := intermbo->FLGLOG // Log Applicazione */
        cActLog = Cursor_intermbo.GetString("FLGLOG");
        m_Ctx.SetGlobalString("cActLog",cActLog);
        /* gSeekAos := intermbo->FLGAOS // Collegamento con AOS */
        gSeekAos = Cursor_intermbo.GetString("FLGAOS");
        m_Ctx.SetGlobalString("gSeekAos",gSeekAos);
        /* gDescAzi := intermbo->RAGSOC // Descrizione Intermediario */
        gDescAzi = Cursor_intermbo.GetString("RAGSOC");
        m_Ctx.SetGlobalString("gDescAzi",gDescAzi);
        /* gChkDate := intermbo->SOSPMAF // Controllo Date */
        gChkDate = Cursor_intermbo.GetString("SOSPMAF");
        m_Ctx.SetGlobalString("gChkDate",gChkDate);
        /* gFatRis := intermbo->FLGEAOS // Fattore Rischio */
        gFatRis = Cursor_intermbo.GetString("FLGEAOS");
        m_Ctx.SetGlobalString("gFatRis",gFatRis);
        /* gFlgDoc := intermbo->FLGCDOC // Collegamento con storico documenti */
        gFlgDoc = Cursor_intermbo.GetString("FLGCDOC");
        m_Ctx.SetGlobalString("gFlgDoc",gFlgDoc);
        /* gTelepass := intermbo->FLGAPERS // Versione Telepass */
        gTelepass = Cursor_intermbo.GetString("FLGAPERS");
        m_Ctx.SetGlobalString("gTelepass",gTelepass);
        /* gFlgWU := intermbo->FLGWU // Gestione WU */
        gFlgWU = Cursor_intermbo.GetString("FLGWU");
        m_Ctx.SetGlobalString("gFlgWU",gFlgWU);
        /* gFlgCMod := intermbo->FLGOPEXTR // Crea Record Modifica */
        gFlgCMod = Cursor_intermbo.GetString("FLGOPEXTR");
        m_Ctx.SetGlobalString("gFlgCMod",gFlgCMod);
        /* gFlgDTP := intermbo->FLGDATATP // Forza Data Trasferimento Provvisorie */
        gFlgDTP = CPLib.Round(Cursor_intermbo.GetDouble("FLGDATATP"),0);
        m_Ctx.SetGlobalNumber("gFlgDTP",gFlgDTP);
        /* gVLT := intermbo->LIMITVLT // Limite VLT */
        gVLT = CPLib.Round(Cursor_intermbo.GetDouble("LIMITVLT"),2);
        m_Ctx.SetGlobalNumber("gVLT",gVLT);
        /* gVNP := intermbo->LIMITVNP // Limite VNT */
        gVNP = CPLib.Round(Cursor_intermbo.GetDouble("LIMITVNP"),2);
        m_Ctx.SetGlobalNumber("gVNP",gVNP);
        /* gStpDwn := intermbo->FLGSTPDIR // Stampa Download */
        gStpDwn = Cursor_intermbo.GetString("FLGSTPDIR");
        m_Ctx.SetGlobalString("gStpDwn",gStpDwn);
        /* gWebCHK := intermbo->FLGCHK // Collegamento a WEBCHK */
        gWebCHK = Cursor_intermbo.GetString("FLGCHK");
        m_Ctx.SetGlobalString("gWebCHK",gWebCHK);
        /* gUrlApp := LRTrim(gIPP)+'://'+LRTrim(gIPS)+":"+LRTrim(gIPSP)+"/"+LRTrim(intermbo->URLAPPL)+"/" // URL Applicazione */
        gUrlApp = CPLib.LRTrim(gIPP)+"://"+CPLib.LRTrim(gIPS)+":"+CPLib.LRTrim(gIPSP)+"/"+CPLib.LRTrim(Cursor_intermbo.GetString("URLAPPL"))+"/";
        m_Ctx.SetGlobalString("gUrlApp",gUrlApp);
        /* gPathApp := Strtran(FileLibMit.GetLocation(),'\','/') // Path Applicazione */
        gPathApp = CPLib.Strtran(FileLibMit.GetLocation(),"\\","/");
        m_Ctx.SetGlobalString("gPathApp",gPathApp);
        /* gFlgRet := intermbo->FLGRITORNO // Flag Creazione File di Ritorno */
        gFlgRet = Cursor_intermbo.GetString("FLGRITORNO");
        m_Ctx.SetGlobalString("gFlgRet",gFlgRet);
        /* gDataTito := intermbo->DTTITAGE // Data per Titolari Effettivi */
        gDataTito = Cursor_intermbo.GetDate("DTTITAGE");
        m_Ctx.SetGlobalDate("gDataTito",gDataTito);
        /* gScadSaldi := intermbo->SCADSALDI // Scadenza Invio Saldi */
        gScadSaldi = Cursor_intermbo.GetDate("SCADSALDI");
        m_Ctx.SetGlobalDate("gScadSaldi",gScadSaldi);
        /* gFlgIPMT := intermbo->FLGIPMT // IP MoneyTrasfer */
        gFlgIPMT = Cursor_intermbo.GetString("FLGIPMT");
        m_Ctx.SetGlobalString("gFlgIPMT",gFlgIPMT);
        /* gGesDoc := intermbo->FLGGESDOC // Gestione Documentale */
        gGesDoc = Cursor_intermbo.GetString("FLGGESDOC");
        m_Ctx.SetGlobalString("gGesDoc",gGesDoc);
        /* _aggage := intermbo->AGGAGE */
        _aggage = CPLib.Round(Cursor_intermbo.GetDouble("AGGAGE"),0);
        /* gAgeCGO := intermbo->FLGUTEAGE // Creazione Automatica agente */
        gAgeCGO = Cursor_intermbo.GetString("FLGUTEAGE");
        m_Ctx.SetGlobalString("gAgeCGO",gAgeCGO);
        /* gScadTrx := intermbo->WUGGALERT // Giorni Alert Transazioni */
        gScadTrx = CPLib.Round(Cursor_intermbo.GetDouble("WUGGALERT"),0);
        m_Ctx.SetGlobalNumber("gScadTrx",gScadTrx);
        /* gPathDoc := intermbo->RICEVUTE // Path Documenti */
        gPathDoc = Cursor_intermbo.GetString("RICEVUTE");
        m_Ctx.SetGlobalString("gPathDoc",gPathDoc);
        /* gAggTabs := 'N' // Aggiornamento Tabelle */
        gAggTabs = "N";
        m_Ctx.SetGlobalString("gAggTabs",gAggTabs);
        /* gTipMul := intermbo->CGOTGDEFMUL // Tipo Gioco Multiple (CGO) */
        gTipMul = Cursor_intermbo.GetString("CGOTGDEFMUL");
        m_Ctx.SetGlobalString("gTipMul",gTipMul);
        /* _tipo := intermbo->TIPOINST */
        _tipo = Cursor_intermbo.GetString("TIPOINST");
        /* gQADV := intermbo->FLGCGOQADV // Attiva Questionario QADV */
        gQADV = Cursor_intermbo.GetString("FLGCGOQADV");
        m_Ctx.SetGlobalString("gQADV",gQADV);
        /* _idsid := intermbo->IDSID */
        _idsid = Cursor_intermbo.GetString("IDSID");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* gVerImp := 'N' // Verifica da import */
      gVerImp = "N";
      m_Ctx.SetGlobalString("gVerImp",gVerImp);
      /* gPathApp := Left(gPathApp,Len(LRTrim(gPathApp))-1) // Path Applicazione */
      gPathApp = CPLib.Left(gPathApp,CPLib.Len(CPLib.LRTrim(gPathApp))-1);
      m_Ctx.SetGlobalString("gPathApp",gPathApp);
      /* If gSeekAos='S' */
      if (CPLib.eqr(gSeekAos,"S")) {
        // * --- Select from webaos_agg_soggetti
        m_cServer = m_Ctx.GetServer("webaos_agg_soggetti");
        m_cPhName = m_Ctx.GetPhName("webaos_agg_soggetti");
        if (Cursor_webaos_agg_soggetti!=null)
          Cursor_webaos_agg_soggetti.Close();
        Cursor_webaos_agg_soggetti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("webaos_agg_soggetti")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_webaos_agg_soggetti.Eof())) {
          /* gDatTER := webaos_agg_soggetti->ULTAGGSOG // Ultimo Aggiornamento TER */
          gDatTER = Cursor_webaos_agg_soggetti.GetDate("ULTAGGSOG");
          m_Ctx.SetGlobalDate("gDatTER",gDatTER);
          Cursor_webaos_agg_soggetti.Next();
        }
        m_cConnectivityError = Cursor_webaos_agg_soggetti.ErrorMessage();
        Cursor_webaos_agg_soggetti.Close();
        // * --- End Select
      } // End If
      // * --- Create temporary table tmp_tipoleg
      if (m_Ctx.IsSharedTemp("tmp_tipoleg")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_tipoleg")) {
          m_cServer = m_Ctx.GetServer("tmp_tipoleg");
          m_cPhName = m_Ctx.GetPhName("tmp_tipoleg");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_tipoleg");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_tipoleg");
      if ( ! (m_Ctx.IsSharedTemp("tmp_tipoleg"))) {
        m_cServer = m_Ctx.GetServer("tmp_tipoleg");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_tipoleg",m_cServer,"proto")),m_cPhName,"tmp_tipoleg",m_Ctx);
      }
      m_cPhName_tmp_tipoleg = m_cPhName;
      // * --- Select from tbtipleg
      m_cServer = m_Ctx.GetServer("tbtipleg");
      m_cPhName = m_Ctx.GetPhName("tbtipleg");
      if (Cursor_tbtipleg!=null)
        Cursor_tbtipleg.Close();
      Cursor_tbtipleg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbtipleg")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tbtipleg.Eof())) {
        /* If Empty(tbtipleg->DATAINI) and Empty(tbtipleg->DATAFINE) */
        if (CPLib.Empty(Cursor_tbtipleg.GetDate("DATAINI")) && CPLib.Empty(Cursor_tbtipleg.GetDate("DATAFINE"))) {
          /* _datini := CharToDate('19000101') */
          _datini = CPLib.CharToDate("19000101");
          /* _datfin := CharToDate('20991231') */
          _datfin = CPLib.CharToDate("20991231");
        } // End If
        /* If not(Empty(tbtipleg->DATAINI)) and Empty(tbtipleg->DATAFINE) */
        if ( ! (CPLib.Empty(Cursor_tbtipleg.GetDate("DATAINI"))) && CPLib.Empty(Cursor_tbtipleg.GetDate("DATAFINE"))) {
          /* _datini := tbtipleg->DATAINI */
          _datini = Cursor_tbtipleg.GetDate("DATAINI");
          /* _datfin := CharToDate('20991231') */
          _datfin = CPLib.CharToDate("20991231");
        } // End If
        /* If Empty(tbtipleg->DATAINI) and not(Empty(tbtipleg->DATAFINE)) */
        if (CPLib.Empty(Cursor_tbtipleg.GetDate("DATAINI")) &&  ! (CPLib.Empty(Cursor_tbtipleg.GetDate("DATAFINE")))) {
          /* _datini := CharToDate('19000101') */
          _datini = CPLib.CharToDate("19000101");
          /* _datfin := tbtipleg->DATAFINE */
          _datfin = Cursor_tbtipleg.GetDate("DATAFINE");
        } // End If
        /* If not(Empty(tbtipleg->DATAINI)) and not(Empty(tbtipleg->DATAFINE)) */
        if ( ! (CPLib.Empty(Cursor_tbtipleg.GetDate("DATAINI"))) &&  ! (CPLib.Empty(Cursor_tbtipleg.GetDate("DATAFINE")))) {
          /* _datini := tbtipleg->DATAINI */
          _datini = Cursor_tbtipleg.GetDate("DATAINI");
          /* _datfin := tbtipleg->DATAFINE */
          _datfin = Cursor_tbtipleg.GetDate("DATAFINE");
        } // End If
        // * --- Insert into tmp_tipoleg from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_tipoleg");
        m_cPhName = m_Ctx.GetPhName("tmp_tipoleg");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_tipoleg",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"00000087")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000087(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_datini,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_datfin,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tbtipleg.GetString("TIPLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tbtipleg.GetString("DESCRIZ"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tbtipleg.GetString("FILTRO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datini),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datfin),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_tipoleg",true);
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
        /* If not(Empty(tbtipleg->DESCRIZ2)) */
        if ( ! (CPLib.Empty(Cursor_tbtipleg.GetString("DESCRIZ2")))) {
          /* If Empty(tbtipleg->DATAINID2) and Empty(tbtipleg->DATAFIND2) */
          if (CPLib.Empty(Cursor_tbtipleg.GetDate("DATAINID2")) && CPLib.Empty(Cursor_tbtipleg.GetDate("DATAFIND2"))) {
            /* _datini := CharToDate('19000101') */
            _datini = CPLib.CharToDate("19000101");
            /* _datfin := CharToDate('20991231') */
            _datfin = CPLib.CharToDate("20991231");
          } // End If
          /* If not(Empty(tbtipleg->DATAINID2)) and Empty(tbtipleg->DATAFIND2) */
          if ( ! (CPLib.Empty(Cursor_tbtipleg.GetDate("DATAINID2"))) && CPLib.Empty(Cursor_tbtipleg.GetDate("DATAFIND2"))) {
            /* _datini := tbtipleg->DATAINID2 */
            _datini = Cursor_tbtipleg.GetDate("DATAINID2");
            /* _datfin := CharToDate('20991231') */
            _datfin = CPLib.CharToDate("20991231");
          } // End If
          /* If Empty(tbtipleg->DATAINID2) and not(Empty(tbtipleg->DATAFIND2)) */
          if (CPLib.Empty(Cursor_tbtipleg.GetDate("DATAINID2")) &&  ! (CPLib.Empty(Cursor_tbtipleg.GetDate("DATAFIND2")))) {
            /* _datini := CharToDate('19000101') */
            _datini = CPLib.CharToDate("19000101");
            /* _datfin := tbtipleg->DATAFIND2 */
            _datfin = Cursor_tbtipleg.GetDate("DATAFIND2");
          } // End If
          /* If not(Empty(tbtipleg->DATAINID2)) and not(Empty(tbtipleg->DATAFIND2)) */
          if ( ! (CPLib.Empty(Cursor_tbtipleg.GetDate("DATAINID2"))) &&  ! (CPLib.Empty(Cursor_tbtipleg.GetDate("DATAFIND2")))) {
            /* _datini := tbtipleg->DATAINID2 */
            _datini = Cursor_tbtipleg.GetDate("DATAINID2");
            /* _datfin := tbtipleg->DATAFIND2 */
            _datfin = Cursor_tbtipleg.GetDate("DATAFIND2");
          } // End If
          // * --- Insert into tmp_tipoleg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_tipoleg");
          m_cPhName = m_Ctx.GetPhName("tmp_tipoleg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_tipoleg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"00000095")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000095(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datini,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datfin,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tbtipleg.GetString("TIPLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tbtipleg.GetString("DESCRIZ2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tbtipleg.GetString("FILTRO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datini),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datfin),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_tipoleg",true);
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
        Cursor_tbtipleg.Next();
      }
      m_cConnectivityError = Cursor_tbtipleg.ErrorMessage();
      Cursor_tbtipleg.Close();
      // * --- End Select
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from cgo_tbmezpag
      m_cServer = m_Ctx.GetServer("cgo_tbmezpag");
      m_cPhName = m_Ctx.GetPhName("cgo_tbmezpag");
      if (Cursor_cgo_tbmezpag!=null)
        Cursor_cgo_tbmezpag.Close();
      Cursor_cgo_tbmezpag = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_tbmezpag")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_tbmezpag.Eof())) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        Cursor_cgo_tbmezpag.Next();
      }
      m_cConnectivityError = Cursor_cgo_tbmezpag.ErrorMessage();
      Cursor_cgo_tbmezpag.Close();
      // * --- End Select
      /* If _conta = 0 */
      if (CPLib.eqr(_conta,0)) {
        // * --- Insert into cgo_tbmezpag from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_tbmezpag");
        m_cPhName = m_Ctx.GetPhName("cgo_tbmezpag");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_tbmezpag",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"0000009B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000009B(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Bonifico Italia","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_tbmezpag",true);
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
        // * --- Insert into cgo_tbmezpag from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_tbmezpag");
        m_cPhName = m_Ctx.GetPhName("cgo_tbmezpag");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_tbmezpag",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"0000009C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000009C(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Bonifico Estero","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_tbmezpag",true);
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
        // * --- Insert into cgo_tbmezpag from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_tbmezpag");
        m_cPhName = m_Ctx.GetPhName("cgo_tbmezpag");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_tbmezpag",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"0000009D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000009D(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Bonifico Postale","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_tbmezpag",true);
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
        // * --- Insert into cgo_tbmezpag from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_tbmezpag");
        m_cPhName = m_Ctx.GetPhName("cgo_tbmezpag");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_tbmezpag",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"0000009E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000009E(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Assegno Circolare","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_tbmezpag",true);
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
        // * --- Insert into cgo_tbmezpag from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_tbmezpag");
        m_cPhName = m_Ctx.GetPhName("cgo_tbmezpag");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_tbmezpag",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"0000009F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000009F(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("B","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Assegno Bancario","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_tbmezpag",true);
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
        // * --- Insert into cgo_tbmezpag from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_tbmezpag");
        m_cPhName = m_Ctx.GetPhName("cgo_tbmezpag");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_tbmezpag",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"000000A0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000000A0(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("V","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Carta di Credito","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_tbmezpag",true);
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
        // * --- Insert into cgo_tbmezpag from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_tbmezpag");
        m_cPhName = m_Ctx.GetPhName("cgo_tbmezpag");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_tbmezpag",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"000000A1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000000A1(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Contante","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_tbmezpag",true);
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
      // * --- Create temporary table tmp_mezzipag
      if (m_Ctx.IsSharedTemp("tmp_mezzipag")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_mezzipag")) {
          m_cServer = m_Ctx.GetServer("tmp_mezzipag");
          m_cPhName = m_Ctx.GetPhName("tmp_mezzipag");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_mezzipag");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_mezzipag");
      if ( ! (m_Ctx.IsSharedTemp("tmp_mezzipag"))) {
        m_cServer = m_Ctx.GetServer("tmp_mezzipag");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_mezzipag",m_cServer,"proto")),m_cPhName,"tmp_mezzipag",m_Ctx);
      }
      m_cPhName_tmp_mezzipag = m_cPhName;
      // * --- Insert into tmp_mezzipag from sql
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_mezzipag");
      m_cPhName = m_Ctx.GetPhName("tmp_mezzipag");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_mezzipag",m_Ctx.GetCompany());
      m_nUpdatedRows=m_Sql.InsertIntoSQL(CPLib.GetSQLPrefixComment("afterlogin",186,"000000A3"),m_cServer,m_oWrInfo,"MPCODICE,MPDESCRI,MPFLGVAL ","from "+m_cPhName_cgo_tbmezpag+"","tmp_mezzipag",m_Ctx,CPLib.HasTableCPCCCHK(m_Ctx,"tmp_mezzipag"));
      if (CPLib.lt(m_nUpdatedRows,0)) {
        m_Sql.AbortTransaction();
      }
      m_Sql.CompleteTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      /* chkfile := FileLibMit.ExistFile('telepass.info') */
      chkfile = FileLibMit.ExistFile("telepass.info");
      /* gAzienda := Utilities.GetCompany() // Azienda */
      gAzienda = Utilities.Make(m_Ctx,m_Caller).GetCompany();
      m_Ctx.SetGlobalString("gAzienda",gAzienda);
      /* gUserCode := Utilities.UserCode() // Codice Utente CP */
      gUserCode = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).UserCode(),0);
      m_Ctx.SetGlobalNumber("gUserCode",gUserCode);
      /* gDataVaria := Date() // Data Variazione */
      gDataVaria = CPLib.Date();
      m_Ctx.SetGlobalDate("gDataVaria",gDataVaria);
      /* If Utilities.UserCode() > 0 */
      if (CPLib.gt(Utilities.Make(m_Ctx,m_Caller).UserCode(),0)) {
        // * --- Select from cpusers_add
        m_cServer = m_Ctx.GetServer("cpusers_add");
        m_cPhName = m_Ctx.GetPhName("cpusers_add");
        if (Cursor_cpusers_add!=null)
          Cursor_cpusers_add.Close();
        Cursor_cpusers_add = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Utilities.Make(m_Ctx,m_Caller).UserCode(),"?",0,0,m_cServer, m_oParameters),m_cServer,Utilities.Make(m_Ctx,m_Caller).UserCode())+" "+")"+(m_Ctx.IsSharedTemp("cpusers_add")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cpusers_add.Eof())) {
          /* gCodDip := cpusers_add->CODDIP // Dipendenza */
          gCodDip = Cursor_cpusers_add.GetString("CODDIP");
          m_Ctx.SetGlobalString("gCodDip",gCodDip);
          /* gSuperDIP := cpusers_add->SUPERDIP // SuperUser Dipendenza */
          gSuperDIP = Cursor_cpusers_add.GetString("SUPERDIP");
          m_Ctx.SetGlobalString("gSuperDIP",gSuperDIP);
          Cursor_cpusers_add.Next();
        }
        m_cConnectivityError = Cursor_cpusers_add.ErrorMessage();
        Cursor_cpusers_add.Close();
        // * --- End Select
        /* If Utilities.IsInGroup(6) or Utilities.IsInGroup(12) */
        if (Utilities.Make(m_Ctx,m_Caller).IsInGroup(6) || Utilities.Make(m_Ctx,m_Caller).IsInGroup(12)) {
          /* FileLibMit.CreateDir("appo/"+LRTrim(gCodDip)) */
          FileLibMit.CreateDir("appo/"+CPLib.LRTrim(gCodDip));
          /* FileLibMit.CreateDirPath(LRTrim(gPathApp)+"/WEB-INF/Tmp/"+LRTrim(gCodDip)) */
          FileLibMit.CreateDirPath(CPLib.LRTrim(gPathApp)+"/WEB-INF/Tmp/"+CPLib.LRTrim(gCodDip));
          /* Exec "Cancella Documenti" Page 2:Page_2 */
          Page_2();
        } // End If
        /* If FileLibMit.ExistFile('newtab/tipifile') */
        if (FileLibMit.ExistFile("newtab/tipifile")) {
          /* Exec "Scrivi i tipi file per l'upload" Page 3:Page_3 */
          Page_3();
        } // End If
        /* If FileLibMit.ExistFile('newtab/release') */
        if (FileLibMit.ExistFile("newtab/release")) {
          /* fhand := FileLibMit.OpenRead('newtab/release') */
          fhand = FileLibMit.OpenRead("newtab/release");
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* If Len(LRTrim(riga)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _datatabs := LRTrim(riga) */
            _datatabs = CPLib.LRTrim(riga);
          } // End If
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* If not(Empty(gAzienda)) */
          if ( ! (CPLib.Empty(gAzienda))) {
            /* If FileLibMit.ExistFile(LRTrim(gPathDoc)+'/Log/'+LRTrim(gAzienda)+'/aggtab.txt') and Utilities.GetCompany() <> 'xxx' */
            if (FileLibMit.ExistFile(CPLib.LRTrim(gPathDoc)+"/Log/"+CPLib.LRTrim(gAzienda)+"/aggtab.txt") && CPLib.ne(Utilities.Make(m_Ctx,m_Caller).GetCompany(),"xxx")) {
              /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/Log/'+LRTrim(gAzienda)+'/aggtab.txt') */
              fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/Log/"+CPLib.LRTrim(gAzienda)+"/aggtab.txt");
              /* riga := FileLibMit.ReadLine(fhand) */
              riga = FileLibMit.ReadLine(fhand);
              /* If Len(LRTrim(riga)) > 0 */
              if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
                /* _data_agg := LRTrim(riga) */
                _data_agg = CPLib.LRTrim(riga);
              } // End If
              /* FileLibMit.Close(fhand) */
              FileLibMit.Close(fhand);
              /* If Empty(_data_agg) or (_datatabs > _data_agg) */
              if (CPLib.Empty(_data_agg) || (CPLib.gt(_datatabs,_data_agg))) {
                /* gAggTabs := 'S' // Aggiornamento Tabelle */
                gAggTabs = "S";
                m_Ctx.SetGlobalString("gAggTabs",gAggTabs);
              } // End If
            } else { // Else
              /* _data_agg := DateToChar(Date()) */
              _data_agg = CPLib.DateToChar(CPLib.Date());
              /* gAggTabs := 'S' // Aggiornamento Tabelle */
              gAggTabs = "S";
              m_Ctx.SetGlobalString("gAggTabs",gAggTabs);
              /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/Log/'+LRTrim(gAzienda)+'/aggtab.txt') */
              fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/Log/"+CPLib.LRTrim(gAzienda)+"/aggtab.txt");
              // Scrive il file con la data aggiornamento
              FileLibMit.Write(fhand,_data_agg);
              FileLibMit.Close(fhand);
            } // End If
          } // End If
        } // End If
        /* Exec Routine arrt_writelog('LOGIN','','') */
        arrt_writelogR.Make(m_Ctx,this).Run("LOGIN","","");
        /* If Year(Date()) = '2020 */
        if (CPLib.eqr(CPLib.Year(CPLib.Date()),2020)) {
          // * --- Write into intermbo from all
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("intermbo");
          m_cPhName = m_Ctx.GetPhName("intermbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intermbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"000000C8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"SCADSALDI = "+CPLib.ToSQL(CPLib.CharToDate("20200401"),"D",8,0)+", ";
          m_cSql = m_cSql+"FLGDATAIM = "+CPLib.ToSQL(0,"N",1,0)+", ";
          m_cSql = m_cSql+"FLGDATATP = "+CPLib.ToSQL(0,"N",1,0)+", ";
          m_cSql = m_cSql+"PATHJAVA = "+CPLib.ToSQL(System.getProperty("java.home"),"C",250,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intermbo",false,true);
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
          /* gScadSaldi := CharToDate('20200401') // Scadenza Invio Saldi */
          gScadSaldi = CPLib.CharToDate("20200401");
          m_Ctx.SetGlobalDate("gScadSaldi",gScadSaldi);
        } else { // Else
          // * --- Write into intermbo from all
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("intermbo");
          m_cPhName = m_Ctx.GetPhName("intermbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intermbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"000000CA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"SCADSALDI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Str(CPLib.Year(CPLib.Date()),4,0)+"0228"),"D",8,0)+", ";
          m_cSql = m_cSql+"FLGDATAIM = "+CPLib.ToSQL(0,"N",1,0)+", ";
          m_cSql = m_cSql+"FLGDATATP = "+CPLib.ToSQL(0,"N",1,0)+", ";
          m_cSql = m_cSql+"PATHJAVA = "+CPLib.ToSQL(System.getProperty("java.home"),"C",250,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intermbo",false,true);
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
          /* gScadSaldi := CharToDate(Str(Year(Date()),4,0)+'0430') // Scadenza Invio Saldi */
          gScadSaldi = CPLib.CharToDate(CPLib.Str(CPLib.Year(CPLib.Date()),4,0)+"0430");
          m_Ctx.SetGlobalDate("gScadSaldi",gScadSaldi);
        } // End If
        /* If _tipo='L' and not(Empty(LRTrim(_idsid))) */
        if (CPLib.eqr(_tipo,"L") &&  ! (CPLib.Empty(CPLib.LRTrim(_idsid)))) {
          // Cambia permessi alle shell
          // SID Standard
          File f = new File(CPLib.LRTrim(gPathApp)+"/SID/prog/runPredisposizioneMIT.sh");
          boolean bool = f.setExecutable(true, true);
          f = new File(CPLib.LRTrim(gPathApp)+"/SID/prog/runRicevuteMIT.sh");
          bool = f.setExecutable(true, true);
        } // End If
        /* If FileLibMit.ExistFile('fix_cauana.info') */
        if (FileLibMit.ExistFile("fix_cauana.info")) {
          // * --- Delete from tbcauana
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tbcauana");
          m_cPhName = m_Ctx.GetPhName("tbcauana");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbcauana",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"000000D1")+"delete from "+m_oWrInfo.GetTableWriteName();
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
          // * --- Write into operazbo from all
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"000000D2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"idcauana = "+CPLib.ToSQL("","C",4,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
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
          // * --- Write into fraziobo from all
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"000000D3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"idcauana = "+CPLib.ToSQL("","C",4,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
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
          // * --- Write into xperazbo from all
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xperazbo");
          m_cPhName = m_Ctx.GetPhName("xperazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"000000D4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"idcauana = "+CPLib.ToSQL("","C",4,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
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
          // * --- Write into xraziobo from all
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xraziobo");
          m_cPhName = m_Ctx.GetPhName("xraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"000000D5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"idcauana = "+CPLib.ToSQL("","C",4,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
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
          /* gAggTabs := 'S' // Aggiornamento Tabelle */
          gAggTabs = "S";
          m_Ctx.SetGlobalString("gAggTabs",gAggTabs);
          /* FileLibMit.DeleteFile('fix_cauana.info') */
          FileLibMit.DeleteFile("fix_cauana.info");
        } // End If
        /* If (FileLibMit.ExistFile(LRTrim(gPathApp)+"/WEB-INF/classes/dictionary/dbadm_SERVLET_DML.log") or FileLibMit.ExistFile(LRTrim(gPathApp)+"/WEB-INF/classes/dictionary/dbadm_SERVLET_DDL.log")) and Utilities.GetCompany() <> 'xxx' */
        if ((FileLibMit.ExistFile(CPLib.LRTrim(gPathApp)+"/WEB-INF/classes/dictionary/dbadm_SERVLET_DML.log") || FileLibMit.ExistFile(CPLib.LRTrim(gPathApp)+"/WEB-INF/classes/dictionary/dbadm_SERVLET_DDL.log")) && CPLib.ne(Utilities.Make(m_Ctx,m_Caller).GetCompany(),"xxx")) {
          /* FileLibMit.MoveFile(LRTrim(gPathApp)+"/WEB-INF/classes/dictionary/dbadm_SERVLET_DML.log",LRTrim(gPathDoc)+"/Log/"+LRTrim(gAzienda)+"/"+DateTimeToChar(DateTime())+"_dbadm_SERVLET_DML.log") */
          FileLibMit.MoveFile(CPLib.LRTrim(gPathApp)+"/WEB-INF/classes/dictionary/dbadm_SERVLET_DML.log",CPLib.LRTrim(gPathDoc)+"/Log/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.DateTimeToChar(CPLib.DateTime())+"_dbadm_SERVLET_DML.log");
          /* FileLibMit.MoveFile(LRTrim(gPathApp)+"/WEB-INF/classes/dictionary/dbadm_SERVLET_DDL.log",LRTrim(gPathDoc)+"/Log/"+LRTrim(gAzienda)+"/"+DateTimeToChar(DateTime())+"_dbadm_SERVLET_DDL.log") */
          FileLibMit.MoveFile(CPLib.LRTrim(gPathApp)+"/WEB-INF/classes/dictionary/dbadm_SERVLET_DDL.log",CPLib.LRTrim(gPathDoc)+"/Log/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.DateTimeToChar(CPLib.DateTime())+"_dbadm_SERVLET_DDL.log");
          /* FileLibMit.MoveFile(LRTrim(gPathApp)+"/WEB-INF/classes/dictionary/dbadm_SERVLET_Errors.log",LRTrim(gPathDoc)+"/Log/"+LRTrim(gAzienda)+"/"+DateTimeToChar(DateTime())+"_dbadm_SERVLET_Errors.log") */
          FileLibMit.MoveFile(CPLib.LRTrim(gPathApp)+"/WEB-INF/classes/dictionary/dbadm_SERVLET_Errors.log",CPLib.LRTrim(gPathDoc)+"/Log/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.DateTimeToChar(CPLib.DateTime())+"_dbadm_SERVLET_Errors.log");
        } // End If
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
        if (Cursor_webaos_agg_soggetti!=null)
          Cursor_webaos_agg_soggetti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbtipleg!=null)
          Cursor_tbtipleg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_tbmezpag!=null)
          Cursor_cgo_tbmezpag.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cpusers_add!=null)
          Cursor_cpusers_add.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    // Cancella vecchi file esiti
    File di = new File(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gCodDip)+"/");
    File fl[] = di.listFiles();
    int _i;
    int count=0;
    for (_i=0; _i < fl.length; _i++)  {
      fl[_i].delete();
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_cpgroups=null;
    CPResultSet Read_Cursor=null;
    try {
      /* _gruppo Numeric(10, 0) */
      double _gruppo;
      _gruppo = 0;
      /* fhand := FileLibMit.OpenRead('newtab/tipifile') */
      fhand = FileLibMit.OpenRead("newtab/tipifile");
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          // * --- Select from cpgroups
          m_cServer = m_Ctx.GetServer("cpgroups");
          m_cPhName = m_Ctx.GetPhName("cpgroups");
          if (Cursor_cpgroups!=null)
            Cursor_cpgroups.Close();
          Cursor_cpgroups = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpgroups")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cpgroups.Eof())) {
            /* _gruppo := 0 */
            _gruppo = CPLib.Round(0,0);
            // * --- Read from cpprgsec
            m_cServer = m_Ctx.GetServer("cpprgsec");
            m_cPhName = m_Ctx.GetPhName("cpprgsec");
            m_cSql = "";
            m_cSql = m_cSql+"progname="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(riga),"C",50,0,m_cServer),m_cServer,CPLib.LRTrim(riga));
            m_cSql = m_cSql+" and grpcode="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cpgroups.GetDouble("code"),"N",10,0,m_cServer),m_cServer,Cursor_cpgroups.GetDouble("code"));
            if (m_Ctx.IsSharedTemp("cpprgsec")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("grpcode",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _gruppo = Read_Cursor.GetDouble("grpcode");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on cpprgsec into routine afterlogin returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _gruppo = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If _gruppo = 0 */
            if (CPLib.eqr(_gruppo,0)) {
              // * --- Insert into cpprgsec from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpprgsec");
              m_cPhName = m_Ctx.GetPhName("cpprgsec");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpprgsec",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"000000E9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000E9(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(riga),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cpgroups.GetDouble("code"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpprgsec",true);
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
            Cursor_cpgroups.Next();
          }
          m_cConnectivityError = Cursor_cpgroups.ErrorMessage();
          Cursor_cpgroups.Close();
          // * --- End Select
        } // End If
      } // End While
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* fhand := '' */
      fhand = "";
      /* If FileLibMit.ExistFile(LRTrim(gPathApp)+"/newtab/"+LRTrim(gAzienda)+"_sicurezze") */
      if (FileLibMit.ExistFile(CPLib.LRTrim(gPathApp)+"/newtab/"+CPLib.LRTrim(gAzienda)+"_sicurezze")) {
        /* fhand := FileLibMit.OpenRead('newtab/'+LRTrim(gAzienda)+'_sicurezze') */
        fhand = FileLibMit.OpenRead("newtab/"+CPLib.LRTrim(gAzienda)+"_sicurezze");
      } else { // Else
        /* If FileLibMit.ExistFile(LRTrim(gPathApp)+"/newtab/sicurezze") */
        if (FileLibMit.ExistFile(CPLib.LRTrim(gPathApp)+"/newtab/sicurezze")) {
          /* fhand := FileLibMit.OpenRead('newtab/sicurezze') */
          fhand = FileLibMit.OpenRead("newtab/sicurezze");
        } // End If
      } // End If
      /* If not(Empty(fhand)) */
      if ( ! (CPLib.Empty(fhand))) {
        /* While not(FileLibMit.Eof(fhand)) */
        while ( ! (FileLibMit.Eof(fhand))) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* If Len(LRTrim(riga)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            // * --- Merge into cpprgsec from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpprgsec");
            m_cPhName = m_Ctx.GetPhName("cpprgsec");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpprgsec",m_Ctx.GetCompany());
            m_cQuery = "select ";
            m_cQuery =  m_cQuery+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(riga,30)),"?",0,0)+" as progname";
            m_cQuery =  m_cQuery+", "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,31,3)),"?",0,0)+" as grpcode";
            m_cQuery =  m_cQuery+", "+CPLib.ToSQL(0,"?",0,0)+" as usrcode";
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
              m_cQuery = m_cQuery+" from dual";
            }
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cWhere = "cpprgsec.progname = cptmp_1xab23.progname";
            m_cWhere = m_cWhere+" and "+"cpprgsec.grpcode = cptmp_1xab23.grpcode";
            m_cWhere = m_cWhere+" and "+"cpprgsec.usrcode = cptmp_1xab23.usrcode";
            m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
              m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"000000F5")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" cpprgsec USING ";
              m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
              m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
              m_cSql = m_cSql+"sec1 = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,34,5)),"N",10,0)+", ";
              m_cSql = m_cSql+"sec2 = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,39,5)),"N",10,0)+", ";
              m_cSql = m_cSql+"sec3 = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,44,5)),"N",10,0)+", ";
              m_cSql = m_cSql+"sec4 = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,49,5)),"N",10,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpprgsec",true,true);
              m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
              m_cSql = m_cSql+GetFieldsName_000000F5(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(riga,30)),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,31,3)),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,34,5)),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,39,5)),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,44,5)),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,49,5)),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpprgsec",true);
              m_cSql = m_cSql+")";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = m_cSql+";";
              }
            } else {
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"000000F5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"sec1 = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,34,5)),"N",10,0)+", ";
              m_cSql = m_cSql+"sec2 = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,39,5)),"N",10,0)+", ";
              m_cSql = m_cSql+"sec3 = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,44,5)),"N",10,0)+", ";
              m_cSql = m_cSql+"sec4 = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,49,5)),"N",10,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpprgsec",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"progname = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(riga,30)),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(CPLib.Left(riga,30)))+"";
              m_cSql = m_cSql+" and grpcode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,31,3)),"?",0,0,m_cServer),m_cServer,CPLib.Val(CPLib.Substr(riga,31,3)))+"";
              m_cSql = m_cSql+" and usrcode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(0,"?",0,0,m_cServer),m_cServer,0)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.eqr(m_nUpdatedRows,0)) {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("afterlogin",186,"000000F5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000F5(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(riga,30)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,31,3)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,34,5)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,39,5)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,44,5)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,49,5)),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpprgsec",true);
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
          } // End If
        } // End While
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
      } // End If
    } finally {
      try {
        if (Cursor_cpgroups!=null)
          Cursor_cpgroups.Close();
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
  public static afterloginR Make(CPContext p_Ctx, Caller p_Caller) {
    return new afterloginR(p_Ctx, p_Caller);
  }
  public void Blank() {
    chkfile = false;
    cAnno = CPLib.Space(4);
    nMese = 0;
    cMese = CPLib.Space(2);
    cGiorno = CPLib.Space(2);
    w_utentecp = 0;
    _datini = CPLib.NullDate();
    _datfin = CPLib.NullDate();
    _aggage = 0;
    _conta = 0;
    fhand = CPLib.Space(1);
    riga = "";
    creadir = false;
    _tipo = CPLib.Space(1);
    _idsid = "";
    _datatabs = CPLib.Space(8);
    _data_agg = CPLib.Space(8);
    gUserCode=m_Ctx.GetGlobalNumber("gUserCode");
    gDatDel=m_Ctx.GetGlobalDate("gDatDel");
    gDatTra=m_Ctx.GetGlobalDate("gDatTra");
    gDatTER=m_Ctx.GetGlobalDate("gDatTER");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gTipInter=m_Ctx.GetGlobalString("gTipInter");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    cActLog=m_Ctx.GetGlobalString("cActLog");
    gFlgWU=m_Ctx.GetGlobalString("gFlgWU");
    gSeekAos=m_Ctx.GetGlobalString("gSeekAos");
    gSblocco=m_Ctx.GetGlobalString("gSblocco");
    gEmail=m_Ctx.GetGlobalString("gEmail");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gChkDate=m_Ctx.GetGlobalString("gChkDate");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gFatRis=m_Ctx.GetGlobalString("gFatRis");
    gTelepass=m_Ctx.GetGlobalString("gTelepass");
    gFlgDoc=m_Ctx.GetGlobalString("gFlgDoc");
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
    gFlgCMod=m_Ctx.GetGlobalString("gFlgCMod");
    gFlgDTP=m_Ctx.GetGlobalNumber("gFlgDTP");
    gVLT=m_Ctx.GetGlobalNumber("gVLT");
    gVNP=m_Ctx.GetGlobalNumber("gVNP");
    gStpDwn=m_Ctx.GetGlobalString("gStpDwn");
    gWebCHK=m_Ctx.GetGlobalString("gWebCHK");
    gIPC=m_Ctx.GetGlobalString("gIPC");
    gIPS=m_Ctx.GetGlobalString("gIPS");
    gIPSP=m_Ctx.GetGlobalString("gIPSP");
    gIPP=m_Ctx.GetGlobalString("gIPP");
    gFlgRet=m_Ctx.GetGlobalString("gFlgRet");
    gDataTito=m_Ctx.GetGlobalDate("gDataTito");
    gScadSaldi=m_Ctx.GetGlobalDate("gScadSaldi");
    gFlgIPMT=m_Ctx.GetGlobalString("gFlgIPMT");
    gGesDoc=m_Ctx.GetGlobalString("gGesDoc");
    gDataVaria=m_Ctx.GetGlobalDate("gDataVaria");
    gAgeCGO=m_Ctx.GetGlobalString("gAgeCGO");
    gScadTrx=m_Ctx.GetGlobalNumber("gScadTrx");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gAggTabs=m_Ctx.GetGlobalString("gAggTabs");
    gTipMul=m_Ctx.GetGlobalString("gTipMul");
    gQADV=m_Ctx.GetGlobalString("gQADV");
    gSuperDIP=m_Ctx.GetGlobalString("gSuperDIP");
    gVerImp=m_Ctx.GetGlobalString("gVerImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_writelog,
  public static final String i_InvokedRoutines = ",arrt_writelog,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000087(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TPDATINI,";
    p_cSql = p_cSql+"TPDATFIN,";
    p_cSql = p_cSql+"TPCODICE,";
    p_cSql = p_cSql+"TPDESCRI,";
    p_cSql = p_cSql+"TPFILTRO,";
    p_cSql = p_cSql+"TPCDATINI,";
    p_cSql = p_cSql+"TPCDATFIN,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_tipoleg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000095(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TPDATINI,";
    p_cSql = p_cSql+"TPDATFIN,";
    p_cSql = p_cSql+"TPCODICE,";
    p_cSql = p_cSql+"TPDESCRI,";
    p_cSql = p_cSql+"TPFILTRO,";
    p_cSql = p_cSql+"TPCDATINI,";
    p_cSql = p_cSql+"TPCDATFIN,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_tipoleg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"MPCODICE,";
    p_cSql = p_cSql+"MPDESCRI,";
    p_cSql = p_cSql+"MPFLGVAL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_tbmezpag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"MPCODICE,";
    p_cSql = p_cSql+"MPDESCRI,";
    p_cSql = p_cSql+"MPFLGVAL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_tbmezpag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"MPCODICE,";
    p_cSql = p_cSql+"MPDESCRI,";
    p_cSql = p_cSql+"MPFLGVAL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_tbmezpag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"MPCODICE,";
    p_cSql = p_cSql+"MPDESCRI,";
    p_cSql = p_cSql+"MPFLGVAL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_tbmezpag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"MPCODICE,";
    p_cSql = p_cSql+"MPDESCRI,";
    p_cSql = p_cSql+"MPFLGVAL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_tbmezpag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"MPCODICE,";
    p_cSql = p_cSql+"MPDESCRI,";
    p_cSql = p_cSql+"MPFLGVAL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_tbmezpag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"MPCODICE,";
    p_cSql = p_cSql+"MPDESCRI,";
    p_cSql = p_cSql+"MPFLGVAL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_tbmezpag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"progname,";
    p_cSql = p_cSql+"grpcode,";
    p_cSql = p_cSql+"usrcode,";
    p_cSql = p_cSql+"sec1,";
    p_cSql = p_cSql+"sec2,";
    p_cSql = p_cSql+"sec3,";
    p_cSql = p_cSql+"sec4,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpprgsec",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"progname,";
    p_cSql = p_cSql+"grpcode,";
    p_cSql = p_cSql+"usrcode,";
    p_cSql = p_cSql+"sec1,";
    p_cSql = p_cSql+"sec2,";
    p_cSql = p_cSql+"sec3,";
    p_cSql = p_cSql+"sec4,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpprgsec",true);
    return p_cSql;
  }
}
